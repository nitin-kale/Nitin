package RetailProduct;

import java.sql.Connection;
import java.sql.SQLException;

public class applyInv_Action extends getResultSet {

	// Table VAriable to insert and update in Db table
	private String vcompcode;
	private String vstorecode;
	private String varticle;
	private String vlocation;
	private String vcreateDate;
	private String vupdateDate;
	private Double vopStock;
	private String vtype;
	private Double vqty = 0.00;
	private Double vpurchase = 0.00;
	private Double vsales = 0.00;
	private Double vti = 0.00;
	private Double vto = 0.00;
	private Double vstkadjadd = 0.00;
	private Double vsalesreturn = 0.00;
	private Double vpurchasereturn = 0.00;
	private Double vloctrf = 0.00;
	private String xvverticle;
	private Double vstkadjsub = 0.00;
	private Double vbalqty = 0.00;
	private String FinalStatus = "Fail";
	private String Action = "Fail";
	private String Choice = "Update";
	private int TotalRecordinsert = 0;
	private String vvcomp;
	//// End Variable Declaration for Table
	private String invtype;
	private String batchcontrol;

	public String getChoice(String varticle, String xlocation, String vvcomp, String vstorecode) throws Exception {
		String sql = "call isArticlePresentinInvTable(" + varticle + "  ,'" + xlocation + "' , " + vvcomp + ", "
				+ vstorecode + ")";
		rs = this.getSPResult(sql);
		if (!rs.next()) {
			Choice = "Add";
		}
		return Choice;
	}

	public String invAction(String vsitecode, String vvarticle, String Type, String xDate, String tQty, String location,
			String vcomp, String vverticle, String vinvtype, String vbatchControlartilce) throws Throwable {
		// new General().msg("Type " + Type);
		vstorecode = vsitecode;
		vvcomp = vcomp;
		varticle = vvarticle;
		vtype = Type;
		xvverticle = vverticle;
		// new General().msg("Assin Verticle passed is" + xvverticle);

		vlocation = location;
		vcreateDate = xDate; // Apply for insert only
		vupdateDate = xDate; // Apply for update and insert
		invtype = vinvtype;
		batchcontrol = vbatchControlartilce;
		vqty = Double.parseDouble(tQty);
		assignQtytoTrans(vtype, vqty);
		Choice = getChoice(varticle, vlocation, vvcomp, vstorecode);
		if (Choice == "Add") {
			insertRecord();
		}
		if (Choice == "Update") {
			updateRecord();
		}
		// new General().msg("Stock Action Compalted....");
		return FinalStatus;
	}

	public void assignQtytoTrans(String vtype, Double xqty) {
		// new General().msg("Assigning Qty function ...");
		// new General().msg("Assignqty"+ " "+xqty) ;
		switch (vtype) {
		case "Purchase":
			vpurchase = xqty;
			break;
		case "Sales":
			vsales = xqty;
			break;
		case "TO":
			vto = xqty;
			break;
		case "TI":
			vti = xqty;
			break;
		case "Stkadjadd":
			vstkadjadd = xqty;
			break;
		case "Stkadjsub":
			vstkadjsub = xqty;
			break;
		case "SalesReturn":
			vsalesreturn = xqty * -1;
			break;
		case "PurchaseReturn":
			vpurchasereturn = xqty;
			break;
		case "loctrf":
			vloctrf = xqty;
			break;
		case "NewArticle":
			vpurchasereturn = 0.00;
			vsalesreturn = 0.00;
			vstkadjsub = 0.00;
			vstkadjadd = 0.00;
			vti = 0.00;
			vto = 0.00;
			vpurchase = 0.00;
			vsales = 0.00;
			break;
		default:
			throw new IllegalArgumentException("Invalid transaction Type: " + vtype);
		}
	}

	public void insertRecord() throws Throwable

	{
		// new General().msg("Stock Inserting Records to DB");
		prst = null;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String SQL = "INSERT INTO  stock_in_hand(company_code ,"
				+ "site_code  , Article_code , createdate , Op_stock , "
				+ "purchase ,    sales ,Transfer_In ,Transfer_out ,  "
				+ "Stock_adj_add, Stock_adj_sub , salesreturn, purchasereturn , "
				+ " Bal_qty, UpdateDate, location , verticle,"
				+ "BatchcontrolArticle , Inventory_type , loctrf ) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// new General().msg(vtype + " "+ varticle+ " "+vstorecode);
		if (vtype == "SalesReturn" || vtype == "Sales" || vtype == "TO" || vtype == "Stkadjsub"
				|| vtype == "PurchasReturn" || vtype == "NewArticle") {
			vqty = vqty * -1;
			vsales = vsales * -1;
			vto = vto * -1;
		}
		try {
			prst = con.prepareStatement(SQL);
			prst.setString(1, vvcomp);
			prst.setString(2, vstorecode);
			prst.setString(3, varticle);
			prst.setString(4, vcreateDate);
			prst.setDouble(5, 0);
			prst.setDouble(6, vpurchase);
			prst.setDouble(7, vsales);
			prst.setDouble(8, vti);
			prst.setDouble(9, vto);
			prst.setDouble(10, vstkadjadd);
			prst.setDouble(11, vstkadjsub);
			prst.setDouble(12, vsalesreturn);
			prst.setDouble(13, vpurchasereturn);
			prst.setDouble(14, vqty);
			prst.setString(15, vupdateDate);
			prst.setString(16, vlocation);
			prst.setString(17, xvverticle);
			prst.setString(18, batchcontrol);
			prst.setString(19, invtype);
			prst.setDouble(20, vloctrf);
			int count = prst.executeUpdate();
			TotalRecordinsert = TotalRecordinsert + 1;
			con.commit();
		} catch (SQLException e) {
			new General().msg("Apply inv Action- Insert" + e.getMessage());
			System.out.println(e.getMessage());
			con.rollback();
		} finally {
			if (prst != null) {
				prst.close();
				// new General().msg("Total Record inseted is "
				// +TotalRecordinsert) ;
				FinalStatus = "Sucess";
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public String updateRecord() throws SQLException, ClassNotFoundException {
		// new General().msg("Stock Updating now to DB");

		if (vtype == "Purchase") {
			// new General().msg("Updating Purchase Stock Update");
			String sql = "Call Stock_updatePurchase(" + vstorecode + " ," + varticle + "  ," + vqty + " ,'"
					+ vupdateDate + "', '" + vlocation + "' , " + vvcomp + ", " + xvverticle + ")";
			// new General().msg(sql);
			this.getSPResult(sql);
			FinalStatus = "Secuss";
		}

		if (vtype == "TI") {
			// new General().msg("Updating Stock Transfer TI");
			String sql = "Call Stock_updateTI(" + vstorecode + " ," + varticle + "  ," + vqty + " ,'" + vupdateDate
					+ "',  '" + vlocation + "' , " + vvcomp + ", " + xvverticle + ")";
			// this.getSPResult(sql) ;
			FinalStatus = "Secuss";
		}

		if (vtype == "Stkadjadd") {
			// new General().msg("Updating Stock Adj ADD Stock ");
			String sql = "Call Stock_updateStkAdjadd(" + vstorecode + " ," + varticle + "  ," + vqty + " ,'"
					+ vupdateDate + "' , '" + vlocation + "', " + vvcomp + ", " + xvverticle + ")";
			this.getSPResult(sql);
			FinalStatus = "Secuss";
		}
		if (vtype == "Sales") {
			// new General().msg("Updating Stock For Sales ");
			String sql = "Call Stock_updateSales(" + vstorecode + " ," + varticle + "  ," + vqty + " ,'" + vupdateDate
					+ "' , '" + vlocation + "' ," + vvcomp + ", " + xvverticle + ")";
			this.getSPResult(sql);
			FinalStatus = "Secuss";
		}
		if (vtype == "TO") {
			// new General().msg("Updating Stock TO ");
			String sql = "Call Stock_updateTO(" + vstorecode + " ," + varticle + "  ," + vqty + " ,'" + vupdateDate
					+ "'  ,  '" + vlocation + "' , " + vvcomp + ", " + xvverticle + ")";
			this.getSPResult(sql);
			FinalStatus = "Secuss";
		}
		if (vtype == "Stkadjsub") {
			// new General().msg("Updating Stock Adj SUB ");
			String sql = "Call Stock_updateStkAdjsub(" + vstorecode + " ," + varticle + "  ," + vqty + " ,'"
					+ vupdateDate + "'  ,  '" + vlocation + "'  , " + vvcomp + ", " + xvverticle + ")";
			this.getSPResult(sql);
			FinalStatus = "Secuss";
		}
		if (vtype == "SalesReturn") {
			// new General().msg("Updating Stock - Sales Return");
			String sql = "Call   Stock_updateSalesReturn(" + vstorecode + " ," + varticle + "  ," + vsalesreturn + " ,'"
					+ vupdateDate + "' ,  '" + vlocation + "' , " + vvcomp + ", " + xvverticle + ")";
			// new General().msg(sql);
			this.getSPResult(sql);
			FinalStatus = "Secuss";
		}
		if (vtype == "PurchaseReturn") {
			// new General().msg("Updating Stock Purchase Return");
			String sql = "Call Stock_updatePurchaseReturn(" + vstorecode + " ," + varticle + "  ," + vqty + " ,'"
					+ vupdateDate + "' ,  '" + vlocation + "' , " + vvcomp + ", " + xvverticle + ")";
			this.getSPResult(sql);
			FinalStatus = "Secuss";
		}

		if (vtype == "loctrf") {
			// new General().msg("Updating Stock Purchase Return");
			String sql = "Call Stock_updateloctrf(" + vstorecode + " ," + varticle + "  ," + vqty + " ,'" + vupdateDate
					+ "' ,  '" + vlocation + "' , " + vvcomp + ", " + xvverticle + ")";
			this.getSPResult(sql);
			FinalStatus = "Secuss";
		}

		return FinalStatus;

	}

	public static void main(String[] args) {

	}
}

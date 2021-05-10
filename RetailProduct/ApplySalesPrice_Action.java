package RetailProduct;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ApplySalesPrice_Action extends getResultSet {

	/// Apply when new new article is created and Article Purchase if sales
	/// price and cost and MRP is Different //

	private String DBdetail;
	private String vcompcode;
	private String xdate;
	private String vstorecode;
	private String varticle;
	private String vlocation;
	private String vstartDate;
	private String venddate;
	private String vmrp;
	private String vcost;
	private String vsp;
	private String VLC;
	String vcomp;
	String vstore;
	String vverticle;
	private String varticletype;
	private String Choice;
	private String vvcomp;
	private String xvverticle;
	private String xucode;
	private String xtaxcode;

	public String SalesPriceInsert(String vsitecode, String vvarticle, String xDate, String xmrp, String xsp,
			String xcost, String vcomp, String vverticle, String xvlc) throws Throwable {
		String FinalStatus = " ";

		xucode = this.ucode;
		xdate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
		vstorecode = vsitecode;
		varticle = vvarticle;
		vstartDate = xDate; // Apply for insert only
		venddate = "0000.00.00"; // Apply for update and insert
		vmrp = xmrp;
		vcost = xcost;
		vsp = xsp;
		VLC = xvlc;
		vvcomp = vcomp;
		xvverticle = vverticle;
		Choice = getChoice(vstorecode, varticle, vmrp, vcost, vsp, vvcomp, xvverticle, VLC);
		if (Choice == "Add") {
			insertSalesRecord();
		}
		if (Choice == "Update") {
			// updateRecord();
		}

		return FinalStatus;
	}

	public String getChoice(String vstorecode, String varticle, String vmrp, String vcost, String vsp, String vcomp,
			String xvverticle, String VLC) throws Exception {
		vcost = VLC;
		String sql = "call isArticlePresentinSalespriceTable(" + vstorecode + " , " + varticle + " , " + vmrp + " , "
				+ vcost + " , " + vsp + ", " + vcomp + ", " + xvverticle + ")";
		rs = this.getSPResult(sql);
		if (!rs.next()) {
			Choice = "Add";
			// new General().Quickmsg("Adding Data in Sales Price Table..") ;
		}
		return Choice;
	}

	public void insertSalesRecord() throws SQLException, ClassNotFoundException, IOException {
		// new General().msg("Adding new Records to DB");
		final int batchSize = 5;
		int TotalRecordinsert = 0;
		prst = null;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String SQL = "INSERT INTO  article_sales_price( Company_code ," + "Site_code  ," + "Article_code ,"
				+ "Start_date ," + "End_Date ," + " Cost ,"
				+ "Sales_price ,MRP, verticle, updatedby, updatedate ) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(SQL);
			prst.setString(1, vvcomp);
			prst.setString(2, vstorecode);
			prst.setString(3, varticle);
			prst.setString(4, vstartDate);
			prst.setString(5, venddate);
			prst.setString(6, VLC);
			prst.setString(7, vsp);
			prst.setString(8, vmrp);
			prst.setString(9, xvverticle);
			prst.setString(10, xucode);
			prst.setString(11, xdate);
			// new General().msg("Prst:" + " "+prst);
			prst.addBatch();
			// int count = prst.executeUpdate();
			// prst.executeBatch();

			// new General().msg("PRST"+""+prst);
			TotalRecordinsert = TotalRecordinsert + 1;
			DBdetail = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBdetail = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBdetail = "Sucess";
			con.commit();
		} catch (SQLException e) {
			// System.out.println(e.getMessage());
			con.rollback();
		} finally {
			if (prst != null) {
				prst.close();
				String Sql = "Call  updateArticlePrices(" + varticle + " , " + vmrp + " , " + vsp + " , " + vcost + ", "
						+ vstorecode + ", " + vvcomp + ", " + xvverticle + ", " + VLC + ")";
				this.getSPResult(Sql);
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

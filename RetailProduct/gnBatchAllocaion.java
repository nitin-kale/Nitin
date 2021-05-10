package RetailProduct;

import java.io.IOException;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class gnBatchAllocaion extends getResultSet {

	private Connection con1;
	String vtype;
	double balpostingqty = 0;

	String vcomp;
	String DBdetail;
	String vmylandingcost;
	String vstore;
	String vfinyear;
	String vsp;
	String vmrp;

	String vcost;
	String vverticle;
	String varticlecode;
	String vloc = "SL";
	String varticlesalesqty;
	double vtotalbalqty;
	double vbatchstock;
	String vbatchno;
	double vallocatestock;
	double aupostNegativeQty;
	double vpendingqty;
	double vbalpendingstock;
	String varticle;
	String vdocno;
	String vdocdate;
	String vdoctype;
	String SQL;
	double StocdiffQty = 0;

	private void getDefault() throws Throwable {
		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		vverticle = new gnHierarchy().getVerticleCode();
		vloc = "SL";
	}

	private double checkRecordAvailableForPosting(String vvdocno, String vvdocdate, String vvdoctype) throws Throwable {
		getDefault();
		vsp = "0";
		vmrp = "0";
		vcost = "0";
		varticle = "0";
		vmylandingcost = "0";
		vdocno = vvdocno;
		vdocdate = vvdocdate;
		vdoctype = vvdoctype;
		double vcount = 0;
		vtype = "isPendingStockPosting";
		SQL = "Call  Batch_GetBatchDetails( '" + vtype + "' ,   " + vcomp + " , " + vstore + " ,   " + varticle
				+ " ,  '" + vfinyear + "' , " + vverticle + " , " + vmrp + "  ," + " " + vsp + " , " + vcost + " , '"
				+ vloc + "' ,  " + vdocno + "  ,  '" + vdocdate + "' )";
		rs1 = this.getSPResult(SQL);
		if (rs1.next()) {
			vcount = Double.parseDouble(rs1.getString(1));
		}
		return vcount;
	}

	public void doBatchStockAllocation(String vvdocno, String vvdocdate, String vvdoctype) throws Throwable {
		getDefault();
		vdocno = vvdocno;
		vdocdate = vvdocdate;
		vdoctype = vvdoctype;
		double vcount;
		vcount = checkRecordAvailableForPosting(vdocno, vdocdate, vdoctype);
		// new General().msg("No.of Pending Allocation Bathed Are" + vcount);
		if (vcount > 0) {
			vsp = "0";
			vmrp = "0";
			vcost = "0";
			varticle = "0";
			vtype = "GetpendingArticlesforPosting";
			SQL = "Call  Batch_GetBatchDetails( '" + vtype + "' ,   " + vcomp + " , " + vstore + " ,   " + varticle
					+ " ,  '" + vfinyear + "' , " + vverticle + " , " + vmrp + "  ," + " " + vsp + " , " + vcost
					+ " , '" + vloc + "' ,  " + vdocno + "  ,  '" + vdocdate + "' )";
			rs1 = this.getSPResult(SQL);
			while (rs1.next()) {
				vpendingqty = Double.parseDouble(rs1.getString(5));
				varticle = rs1.getString(1);
				vmrp = rs1.getString(2);
				vcost = rs1.getString(4);
				vmylandingcost = rs1.getString(4);
				// new General().msg("Cost is " +vcost + " & Pending Qty is :" +
				// vpendingqty );
				vsp = rs1.getString(3);
				isPlusBatchAvailable();
			}
		}
	}

	private void isPlusBatchAvailable() throws Throwable {
		getDefault();
		vtype = "IsPlusBatchAvailable";
		// new General().msg("Verticle is :"+" "+vverticle) ;
		SQL = "Call  Batch_GetBatchDetails( '" + vtype + "' ,   " + vcomp + " , " + vstore + " ,   " + varticle
				+ " ,  '" + vfinyear + "' , " + vverticle + " , " + vmrp + "  ," + " " + vsp + " , " + vcost + " , '"
				+ vloc + "' ,  " + vdocno + "  ,  '" + vdocdate + "' )";
		// new General().msg(SQL) ;
		rs = this.getSPResult(SQL);
		StocdiffQty = 0;
		vtotalbalqty = getTotalStock(varticle, vmrp, vsp);
		if (vtotalbalqty == 0) {
			StocdiffQty = vpendingqty * -1;
			processNegativeStockPosting();
		} else {
			// new General().msg("PLUS Stock Batched are Available ..Posting
			// stock in existing Batches ");
			vtotalbalqty = getTotalStock(varticle, vmrp, vsp);
			StocdiffQty = vtotalbalqty - vpendingqty;
			// new General().msg("Total Stock for Artilce is All Batches:" +
			// vtotalbalqty);

			/*
			 * if ( StocdiffQty < 0 ) { vpendingqty = vpendingqty + StocdiffQty
			 * ; aupostNegativeQty = StocdiffQty ; new General().msg(
			 * "Posting Negative Stock  Allocation Still post negatibe Qty:"+
			 * ""+aupostNegativeQty); processNegativeStockPosting() ; }
			 */
			/*
			 * if (vpendingqty <= vtotalbalqty ) { vtype =
			 * "GetPlusBatchforAllocation" ; SQL =
			 * "Call  Batch_GetBatchDetails( '"+vtype+"' ,   "+vcomp+" , "
			 * +vstore+" ,   "+varticle+" ,  '"+vfinyear+"' , "+vverticle+" , "
			 * +vmrp+"  ," + " "+vsp+" , "+vcost+" , '"+vloc+"' ,  "+vdocno+
			 * "  , '"+vdocdate+"' )"; rs2 = this.getSPResult(SQL) ;
			 * vallocatestock = 0 ; while(rs2.next()) { vbatchno =
			 * rs2.getString(2) ; vbatchstock =
			 * Double.parseDouble(rs2.getString(3)) ; new General().msg(
			 * "Reducing Stock From Batch+"+ vbatchno+ " "
			 * +vbatchstock+""+vpendingqty); allocateBatchStock(varticle,
			 * vbatchno, vbatchstock) ; } }
			 */

			if (vpendingqty > 0) {
				vtype = "GetPlusBatchforAllocation";
				SQL = "Call  Batch_GetBatchDetails( '" + vtype + "' ,   " + vcomp + " , " + vstore + " ,   " + varticle
						+ " ,  '" + vfinyear + "' , " + vverticle + " , " + vmrp + "  ," + " " + vsp + " , " + vcost
						+ " , '" + vloc + "' ,  " + vdocno + "  , '" + vdocdate + "' )";
				rs2 = this.getSPResult(SQL);
				vallocatestock = 0;
				while (rs2.next()) {
					vbatchno = rs2.getString(2);
					vbatchstock = Double.parseDouble(rs2.getString(3));
					allocateBatchStock(varticle, vbatchno, vbatchstock);
				}
				if (vpendingqty != 0) {
					StocdiffQty = vpendingqty * -1;
					processNegativeStockPosting();
				}
			}
		}
	}

	private void processNegativeStockPosting() {
		// new General().msg("No PLus Stock Batched are available ..Posting
		// directly Negative Stock outr Loop ");
		aupostNegativeQty = StocdiffQty;
		insertNegativeBatch();
	}

	private void insertNegativeBatch() {
		String vdate = "";
		String vnewbatchno = "";
		try {
			Integer vnegbatch = getNegativeBatchIfAvailable();
			if (vnegbatch == 0) {
				vnewbatchno = getNewBatch();
				vdate = new gnConfig().date_ConverttoDBforamt(new General().getBegindate());
				String vopstock = "0";
				String vexpdate = "0000.00.00";
				String vbatcharticle = "N";
				String vsupplier = "0";
				// new General().msg("Final Insert Cost is "+ vmylandingcost );
				SQL = "Insert into stock_in_hand_details(company_code, site_code, verticle, article_code, location, batch_no,  "
						+ " op_stock, stockout, Bal_qty , mrp, Salesprice, cost, finyear, createDate, UpdateDate, expiry_date, supplier_code , batchControlArticle)"
						+ "values (" + vcomp + " , " + vstore + " , " + vverticle + ", " + varticle + ", '" + vloc
						+ "', " + vnewbatchno + " , " + vopstock + " ," + " " + aupostNegativeQty + ", "
						+ aupostNegativeQty + ", " + vmrp + ", " + vsp + " , " + vmylandingcost + ", '" + vfinyear
						+ "', '" + vdate + "' , " + " '" + vdate + "' , '" + vexpdate + "' , " + vsupplier + " , '"
						+ vbatcharticle + "')";
				// new General().msg(SQL);
				this.getResult(SQL);
				insertintoBstchTrackingTable(vnewbatchno, aupostNegativeQty, aupostNegativeQty);
			} else {
				vnewbatchno = Integer.toString(vnegbatch);
				// new General().msg("Adding Stock in Existing Batch:"+""+
				// aupostNegativeQty);
				vallocatestock = aupostNegativeQty;
				SQL = "call batch_updateNegStock(" + vcomp + ", " + vstore + " , " + varticle + " , " + vallocatestock
						+ ", " + vnewbatchno + " , '" + vloc + "', " + vverticle + ", '" + vfinyear + "')";
				// new General().msg(SQL);
				this.getResult(SQL);
				insertintoBstchTrackingTable(vnewbatchno, vallocatestock, vallocatestock);
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void allocateBatchStock(String varticle, String vbatchno, double vbatchstock)
			throws ClassNotFoundException, SQLException, IOException {
		// new General().msg("Reducing Stock From Batch+"+ vbatchno+ "
		// "+vbatchstock+" Pending Qty "+vpendingqty);
		vtype = "AllocateBatchStock";
		if (vpendingqty == vbatchstock) {
			vallocatestock = vpendingqty;
		}

		if (vpendingqty < vbatchstock) {
			vallocatestock = vpendingqty;
		}

		if (vpendingqty > vbatchstock) {
			vallocatestock = vbatchstock;
		}

		if (vpendingqty > 0) {
			SQL = "call batch_updateStock(" + vcomp + ", " + vstore + " , " + varticle + " , " + vallocatestock + ", "
					+ vbatchno + " , '" + vloc + "', " + vverticle + ", '" + vfinyear + "')";
			// new General().msg(SQL);
			this.getResult(SQL);
			insertintoBstchTrackingTable(vbatchno, vbatchstock, vallocatestock);
			vpendingqty = vpendingqty - vallocatestock;
			// new General().msg("Pendning Qty is :" + vpendingqty);
		}

	}

	private double getTotalStock(String varticle, String vmrp, String vsp) throws Throwable {
		getDefault();
		vcost = "0";
		double vstock = 0;
		vtype = "GetTotalStockofArticle";
		SQL = "Call  Batch_GetBatchDetails( '" + vtype + "' ,   " + vcomp + " , " + vstore + " ,   " + varticle
				+ " ,  '" + vfinyear + "' , " + vverticle + " , " + vmrp + "  ," + " " + vsp + " , " + vcost + " , '"
				+ vloc + "' ,  " + vdocno + "  , '" + vdocdate + "' )";
		rs = this.getSPResult(SQL);

		if (rs.next()) {
			vstock = Double.parseDouble(rs.getString(2));
		}
		// new General().msg("Total Stock Available for this Article is" +
		// ""+vstock);
		return vstock;
	}

	private String getNewBatch() throws Throwable {
		String vbatchno = "";
		String vpara = "911";
		String vtran = "MS";
		vbatchno = new gnSeq().getSeqno(vpara, vtran);
		new gnSeq().updateSeqno(vpara, vtran);
		// new General().Quickmsg("New Batch Created :" + " "+vbatchno);
		return vbatchno;
	}

	private Integer getNegativeBatchIfAvailable() throws ClassNotFoundException, SQLException {
		double vnegbatch = 0;
		vtype = "GetNegatibeBAtchIfAvailable";
		SQL = "Call  Batch_GetBatchDetails( '" + vtype + "' ,   " + vcomp + " , " + vstore + " ,   " + varticle
				+ " ,  '" + vfinyear + "' , " + vverticle + " , " + vmrp + "  ," + " " + vsp + " , " + vcost + " , '"
				+ vloc + "' ,  " + vdocno + "  , '" + vdocdate + "' )";
		rs = this.getSPResult(SQL);

		if (rs.next()) {
			vnegbatch = Integer.parseInt(rs.getString(3));
		}
		return (int) vnegbatch;
	}

	private void insertintoBstchTrackingTable(String vbatchno, double vvbatchStock, double vallocateStock) {
		try {
			SQL = "Insert into  pos_sales_batch_allocation(company_code, site_code, invno , invdate, article_code ,  "
					+ "  Articleqty , batchno,   BatchStock, AllocateStock, pendingqty , mrp, sp, cost, doctype)  "
					+ "values (" + vcomp + " , " + vstore + " , " + vdocno + ", '" + vdocdate + "' ,   " + varticle
					+ ", " + vpendingqty + ",  " + vbatchno + "  ," + " " + vvbatchStock + ", " + vallocateStock + ", "
					+ vpendingqty + ", " + vmrp + ", " + vsp + " , " + vcost + " , '" + vdoctype + "' )";
			// new General().msg(SQL);
			this.getResult(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
			new General().msg(e.getMessage());
		}
	}

}// Last

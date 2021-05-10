package RetailProduct;

public class gnBatch extends getResultSet {

	private String vcomp;
	private String vstore;
	private String vmrp = "0";
	private String vverticle;
	private String vsp = "0";
	private String vcost = "0";
	private String showbatch = "N";
	private String vfinyear;
	private String SQL;
	private String vtype = "";
	private String vlocation = "SL";

	private void getDefault() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		vverticle = new gnHierarchy().getVerticleCode();

	}

	public String getCostOfgivenBatch(String vbatchno) throws Throwable {
		getDefault();
		String vcostofBatch = "";
		SQL = "call batch_getBatchCost(  " + vcomp + ", " + vstore + ", '" + vbatchno + "', '" + vfinyear + "' ,   '"
				+ vlocation + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vcostofBatch = rs.getString(1);
		}
		return vcostofBatch;
	}

	public String IsBatchAvailableForIsBatchAvailableforMrpandSP(String varticle, String vmrp, String vsp)
			throws Throwable {
		getDefault();
		String Available = "N";
		vtype = "IsBatchAvailableforMrpandSP";
		SQL = "call batch_getInfo( '" + vtype + "' , " + vcomp + ", " + vstore + ", '" + varticle + "', '" + vfinyear
				+ "' , " + vverticle + " , " + vmrp + " , " + vsp + " , " + vcost + "  , '" + vlocation + "')";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			Available = "Y";
		}
		// new General().msg("In Batch Table batched are available Step 1 :" + "
		// "+Available);
		return Available;
	}

	public String IsBatchAvailableForCostMrpSP(String varticle, String vmrp, String vsp, String vcost)
			throws Throwable {
		getDefault();
		String Available = "N";
		vtype = "IsBatchAvailableforcostmrpsp";
		SQL = "call batch_getInfo( '" + vtype + "' , " + vcomp + ", " + vstore + ", '" + varticle + "', '" + vfinyear
				+ "' , " + vverticle + " , " + vmrp + " , " + vsp + " , " + vcost + "  , '" + vlocation + "')";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			Available = "Y";
		}
		// new General().msg("In Batch Table batched are available Step 1 :" + "
		// "+Available);
		return Available;
	}

	public String IsStockAvailabeForMrpandSP(String varticle, String vmrp, String vsp) throws Throwable {
		getDefault();
		String Available = "N";
		double vstock = 0;
		vtype = "IsStockAvailable";
		SQL = "call batch_getInfo( '" + vtype + "' , " + vcomp + ", " + vstore + ", '" + varticle + "', '" + vfinyear
				+ "' , " + vverticle + " , " + vmrp + " , " + vsp + " , " + vcost + "  , '" + vlocation + "')";
 		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vstock = Double.parseDouble(rs.getString(1));
			if (vstock > 0) {
				Available = "Y";
				//new General().msg("Is Stock Available:" + "" +Available);
			}
		}
 		return Available;
	}

	public String IsMultiBatchForMRP_SalesPrice(String varticle, String vmrp, String vsp, String vcost)
			throws Throwable {
		getDefault();
		double vcount;
		String multibatchavailable = "N";
		vtype = "IsMultiBatchForSalesPrice";
		SQL = "call batch_getInfo( '" + vtype + "' , " + vcomp + ", " + vstore + ", '" + varticle + "', '" + vfinyear
				+ "' , " + vverticle + " , " + vmrp + " , " + vsp + " , " + vcost + ", '" + vlocation + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vcount = Double.parseDouble(rs.getString(1));
			if (vcount >= 1) {
				multibatchavailable = "Y";
			}
		}
		// new General().Quickmsg("Mul batch for mrp available :" + "
		// "+multibatchavailable);
		return multibatchavailable;
	}

	public String IsMultiBatchForMRP_SalesPriceForSale(String varticle, String vmrp, String vsp, String vcost)
			throws Throwable {
		getDefault();
		double vcount;
		String multibatchavailable = "N";
		vtype = "IsMultiBatchForSalesPrice";
		SQL = "call batch_getInfo( '" + vtype + "' , " + vcomp + ", " + vstore + ", '" + varticle + "', '" + vfinyear
				+ "' , " + vverticle + " , " + vmrp + " , " + vsp + " , " + vcost + ", '" + vlocation + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vcount = Double.parseDouble(rs.getString(1));
			if (vcount > 1) {
				multibatchavailable = "Y";
				new General().msg(multibatchavailable);
			}
		}
		// new General().Quickmsg("Mul batch for mrp available :" + "
		// "+multibatchavailable);
		return multibatchavailable;
	}

	public String POS_IsMultiBatchForMRP_SalesPriceForSale(String varticle, String vmrp, String vsp) throws Throwable {
		getDefault();
		double vcount;
		String multibatchavailable = "N";
		vtype = "POS_IsMultiBatchForSalesPrice";
		SQL = "call batch_getInfo( '" + vtype + "' , " + vcomp + ", " + vstore + ", '" + varticle + "', '" + vfinyear
				+ "' , " + vverticle + " , " + vmrp + " , " + vsp + " , " + vcost + ", '" + vlocation + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vcount = Double.parseDouble(rs.getString(1));
			if (vcount > 1) {
				multibatchavailable = "Y";
			}
		}
		// new General().Quickmsg("Mul batch for mrp available :" + "
		// "+multibatchavailable);
		return multibatchavailable;
	}

	public String getNewBatch() throws Throwable {
		String vbatchno = "";
		String vpara = "911";
		String vtran = "MS";
		vbatchno = new gnSeq().getSeqno(vpara, vtran);
		new gnSeq().updateSeqno(vpara, vtran);
		// new General().Quickmsg("New Batch Created :" + " "+vbatchno);
		return vbatchno;
	}

	public String checkBatchForPurchase(String varticle, String vmrp, String vsp, String vcost) throws Throwable {
		getDefault();
		String batchno = "0";
		vtype = "IsBatchAvailableforInward";
		SQL = "call batch_getInfo( '" + vtype + "' , " + vcomp + ", " + vstore + ", '" + varticle + "', '" + vfinyear
				+ "' , " + vverticle + " , " + vmrp + " , " + vsp + " , " + vcost + "  , '" + vlocation + "')";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			batchno = rs.getString(1);
		}
		// new General().msg("In Batch Table batched are available Step 1 :" + "
		// "+Available);
		return batchno;

	}

	public String IsMultiBatchForPurPrice(String varticle, String vmrp, String vsp, String vcost) throws Throwable {
		getDefault();
		double vcount;
		String multibatchavailable = "N";
		vtype = "IsMultiBatchForPurPrice";
		SQL = "call batch_getInfo( '" + vtype + "' , " + vcomp + ", " + vstore + ", '" + varticle + "', '" + vfinyear
				+ "' , " + vverticle + " , " + vmrp + " , " + vsp + " ,  " + vcost + " , '" + vlocation + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vcount = Double.parseDouble(rs.getString(1));
			if (vcount > 1) {
				multibatchavailable = "Y";
			}
		}
		// new General().Quickmsg("Multi Purchase Price Available :" + "
		// "+multibatchavailable);
		return multibatchavailable;
	}

	public String IsMultiBatchForMRP(String varticle, String vmrp, String vsp, String vcost) throws Throwable {
		getDefault();
		double vcount;
		String multibatchavailable = "N";
		vtype = "IsMultiBatchForPurPrice";
		SQL = "call batch_getInfo( '" + vtype + "' , " + vcomp + ", " + vstore + ", '" + varticle + "', '" + vfinyear
				+ "' , " + vverticle + " , " + vmrp + " , " + vsp + " ,  " + vcost + ", '" + vlocation + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vcount = Double.parseDouble(rs.getString(1));
			if (vcount > 1) {
				multibatchavailable = "Y";
			}
		}
		return multibatchavailable;
	}

	public String getLowestBatch(String varticle, String vmrp, String vsp, String vcost) throws Throwable {
		getDefault();
		String vbatchno = " ";
		vtype = "GetLowerBatchZero";
		SQL = "call batch_getInfo( '" + vtype + "' , " + vcomp + ", " + vstore + ", '" + varticle + "' , '" + vfinyear
				+ "' , " + vverticle + " , " + vmrp + " , " + vsp + " , " + vcost + ", '" + vlocation + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vbatchno = rs.getString(1);
			// new General().Quickmsg("Getting Lowest Batch -->Number is :" + "
			// "+vbatchno);
		}
		return vbatchno;
	}

	public String getLowestBatchZero(String varticle, String vmrp, String vsp, String vcost) throws Throwable {
		getDefault();
		String vbatchno = " ";
		vtype = "GetLowerBatchZero";
		SQL = "call batch_getInfo( '" + vtype + "' , " + vcomp + ", " + vstore + ", '" + varticle + "' , '" + vfinyear
				+ "' , " + vverticle + " , " + vmrp + " , " + vsp + " , " + vcost + ", '" + vlocation + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vbatchno = rs.getString(1);
			// new General().Quickmsg("Getting Lowest Batch -->Number is :" + "
			// "+vbatchno);
		}
		return vbatchno;
	}

	public String getLowestBatchNonZero(String varticle, String vmrp, String vsp, String vcost) throws Throwable {
		getDefault();
		String vbatchno = " ";
		vtype = "GetLowerBatchNonZero";
		SQL = "call batch_getInfo( '" + vtype + "' , " + vcomp + ", " + vstore + ", '" + varticle + "' , '" + vfinyear
				+ "' , " + vverticle + " , " + vmrp + " , " + vsp + " , " + vcost + ", '" + vlocation + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vbatchno = rs.getString(1);
			// new General().Quickmsg("Getting Lowest Batch -->Number is :" + "
			// "+vbatchno);
		}
		return vbatchno;
	}

}

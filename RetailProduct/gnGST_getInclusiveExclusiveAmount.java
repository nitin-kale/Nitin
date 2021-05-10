package RetailProduct;

public class gnGST_getInclusiveExclusiveAmount extends getResultSet {

	String vcomp;
	String vstore;
	String vfinyear;
	String vtype;
	String vdocno;
	String vdocdate;
	String vdoctype;
	String status = "";
	String vamount = "";

	private void getDefaults() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
	}

	public String Purchase_getExclusiveAmount(String vdocno, String vdocdate, String vvdoctype) throws Throwable {
		getDefaults();
		vdoctype = "GRN";
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String SQL = "call     account_getExclAmount( " + vcomp + "  , " + vstore + "  , '" + vdoctype + "'  , "
				+ vdocno + "  , '" + vdocdate + "'   )";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vamount = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return vamount;
	}

	public String Sales_getExclusiveAmount(String vdocno, String vdocdate, String vvdoctype) throws Throwable {
		getDefaults();

		vdoctype = "SALE";
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String SQL = "call     account_getExclAmount( " + vcomp + "  , " + vstore + "  , '" + vdoctype + "'  , "
				+ vdocno + "  , '" + vdocdate + "'   )";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vamount = rs.getString(1);
		}
		rs.close();
		this.closeconn();

		return vamount;
	}

	public String SR_getExclusiveAmount(String vdocno, String vdocdate, String vvdoctype) throws Throwable {
		getDefaults();

		vdoctype = "SR";
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String SQL = "call   account_getExclAmount( " + vcomp + "  , " + vstore + "  , '" + vdoctype + "'  , " + vdocno
				+ "  , '" + vdocdate + "'   )";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vamount = rs.getString(1);
		}
		rs.close();
		this.closeconn();

		return vamount;
	}

	public String PR_getExclusiveAmount(String vdocno, String vdocdate, String vvdoctype) throws Throwable {
		getDefaults();

		vdoctype = "PR";
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String SQL = "call   account_getExclAmount( " + vcomp + "  , " + vstore + "  , '" + vdoctype + "'  , " + vdocno
				+ "  , '" + vdocdate + "'   )";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vamount = rs.getString(1);
		}
		rs.close();
		this.closeconn();

		return vamount;
	}

}

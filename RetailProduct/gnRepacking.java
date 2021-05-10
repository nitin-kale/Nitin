package RetailProduct;

public class gnRepacking extends getResultSet {

	String vcomp;
	String vstore;
	String vfinyear;
	String vdocno;
	String vdocdate;
	String vverticle;
	String SQL;
	String vtype;
	String varticle = "0";
	String vretvalue = "0";

	public String calculatePerGMPrice(Double vvalue) {
		double value = 0;
		value = vvalue / 1000;
		String vmyvalue = Double.toString(value);
		vmyvalue = new gnMath().get2DecimaltValue(vmyvalue);
		return vmyvalue;
	}

	public void getDefault() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		vverticle = new gnHierarchy().getVerticleCode();
	}

	public String getBulkIssueQty(String vvdocno, String vvdocdate) throws Throwable {
		getDefault();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		vdocno = vvdocno;
		vtype = "GetBulkIssueQty";
		SQL = "call   repack_getData('" + vtype + "'  , " + vcomp + "   ,  " + vstore + "  , " + varticle + "   , "
				+ vdocno + "  , '" + vdocdate + "'  )";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vretvalue = rs.getString(1);
		}
		return vretvalue;
	}

}// Last

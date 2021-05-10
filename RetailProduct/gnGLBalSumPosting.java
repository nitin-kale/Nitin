package RetailProduct;

import java.sql.SQLException;

public class gnGLBalSumPosting extends getResultSet {

	String vcomp;
	String vstore;
	String vdocdate;
	String vdocno;
	String vdoctype;

	public void GLBalanceSummaryPosting(String vvdoctype, String vvdocno, String vvdocdate) throws Throwable {
		new General().msg(vvdoctype + " " + vvdocdate + " " + vvdocno);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocno = vvdocno;
		vdoctype = vvdoctype;
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);

		String SQL = "call Account_post_datewise_glEntry(  " + vcomp + "   , " + vstore + "  ,  " + vdocno + "   , '"
				+ vdocdate + "'  , '" + vdoctype + "'   )";
		new General().msg(SQL);
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void AllGLBalanceSummaryPostingfoDate(String vfrom, String vto) throws Throwable {
		// new General().msg(vvdoctype +" "+ vvdocdate + " "+ vvdocno);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		// vdocno = vvdocno ;
		// vdoctype = vvdoctype ;
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		String SQL = "call Account_postAll_datewise_glEntry(  " + vcomp + "   , " + vstore + "     , '" + vfrom
				+ "'  ,'" + vto + "'     )";
		new General().msg(SQL);
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

}// Last

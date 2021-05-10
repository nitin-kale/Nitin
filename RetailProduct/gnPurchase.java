package RetailProduct;

import java.sql.SQLException;

public class gnPurchase extends getResultSet {

	String vcomp;
	String vstore;
	String vfrom;
	String vto;
	String vparty;
	String vdocno;
	String vdocdate;
	String vcode;
	String SQL;
	String vfinyear = "";

	public String getLastArticlePurchaseDetails(String vtype, String varticle, String vsupplier) throws Throwable {
		String value = "";
		vto = "";
		vfrom = "";
		vfinyear = new gnFinYear().getReportingFinYear();
		vcode = varticle;
		vstore = new gnConfig().getStoreID();
		try {
			SQL = "call view_supplierView1( '" + vtype + "', " + compcode + ", " + vstore + " , '" + vsupplier + "', '"
					+ vfrom + "', '" + vto + "' , '" + vcode + "' , '" + vfinyear + "'     )";
			// new General().msg(SQL);
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				value = rs.getString(1);
			}
		} catch (Exception e) {
			new General().msg(e.getLocalizedMessage());
		}
		return value;
	}

}

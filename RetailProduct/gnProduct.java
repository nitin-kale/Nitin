package RetailProduct;

import java.sql.SQLException;

public class gnProduct extends getResultSet {

	String SQL = "";

	public String getInnerQty(String varticle) throws ClassNotFoundException, SQLException {
		String vinnerQty = "1";
		String vtype = "innerQty";
		String vcomp = new gnConfig().getCompanycode();
		SQL = "call  product_getProductdetails('" + vtype + "', " + vcomp + ", " + varticle + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vinnerQty = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return vinnerQty;

	}

}

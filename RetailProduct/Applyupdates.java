package RetailProduct;

import java.sql.SQLException;

public class Applyupdates extends getResultSet {

	public void update_grqty(String varticle, String vgrqty, String vpono, String vcomp, String vstorecode,
			String vpodate) throws ClassNotFoundException, SQLException {
		String SQL = "call po_updateGrQty( " + varticle + " ,  " + vpono + "  , " + vgrqty + ", " + vcomp + ", "
				+ vstorecode + ", '" + vpodate + "') ";
		// new General().msg(SQL);
		this.getResult(SQL);

		String SQL1 = "call po_updateStatus( " + vcomp + ", " + vstorecode + ",    '" + vpodate + "' , " + vpono
				+ " ) ";
		// new General().msg(SQL1);
		this.getResult(SQL1);

	}

}// Last

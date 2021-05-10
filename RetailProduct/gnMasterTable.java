package RetailProduct;

import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JComboBox;

public class gnMasterTable extends getResultSet {

 	
	
	public void updateTableInfo(String vmastername, String vactive, String vverticle, String vmascode)
			throws SQLException {

		String SQL = "update Master_table set  active = '" + vactive + "' , verticle = '" + vverticle
				+ "'  where master_name = '" + vmastername + "' " + " and code = '" + vmascode + "' ";
		// new General().msg(SQL);
		this.getResult(SQL);
		try {
			this.closeconn();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

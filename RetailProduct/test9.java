package RetailProduct;

import java.io.IOException;
import java.sql.SQLException;

import mylicsource.gnBaseConnection;

public class test9 {

	public String getCode(String vname) throws ClassNotFoundException, SQLException, IOException {

		String vpass = "";
		vpass = new mylicsource.General().cpmanage(vname);
		return vpass;
	}

}

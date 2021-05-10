package RetailProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

public class getSqResultSet {
	public ResultSet rs, rs1, rs2;
	CallableStatement cs;
	Connection conn = null;
	PreparedStatement prst;
	public static String driver = "jdbc:sqlite::memory";

	private Connection connect() throws ClassNotFoundException {

		String vdbname = new gnPublicVariable().getlocalSqlPath();
		String url = "jdbc:sqlite:" + vdbname + " ";
		new General().msg("myeory Connection File is" + "" + url);
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			new General().msg("DB Connection Problem-2S0101");
		}
		return conn;
	}

	public String getVerifyKey(String vcomp, String vkey) throws SQLException, ClassNotFoundException {
		String status = "Fail";
		Connection conn = connect();
		String SQL = "select lickey FROM vlinfo WHERE  company_code  = ?    ";
		// new General().msg(SQL);
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vcomp);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String tmpky = rs.getString(1);
				status = new General().convertPassword(tmpky);
				tmpky = null;
			} else {
				new General().msg(
						"!!! Invalid Product Key !!! For This Company Please Check Or Call For New Licence Key ....:");
				status = "Fail";
			}
		} catch (Exception e) {
			new General().msg(e.getMessage());
		}
		rs.close();
		conn.close();
		return status;
	}

	public ResultSet getSPResult(String SQL) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = null;
		try {
			conn = this.connect();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			return rs;
		} catch (Exception e) {
			new General().msg("Result Set:" + " " + e.getLocalizedMessage() + "" + SQL);
			// new General().msg("Get Result Set msg:"+ e.getCause());
		}
		pstmt.close();
		return rs;
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		getSqResultSet app = new getSqResultSet();
		// app.insert("9999", "9867787495","AKN-2017-Retail-1001-202021");
		app.getVerifyKey("5000", "AKN-500");
	}

}// Last

package RetailProduct;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class gnDBParam extends getResultSet {

	String url1;
	String user;
	String pw;
	String vdriver;

	String dbname;
	String defaultDBPath = "C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\";
	String DBPath;
	String SQL;

	String url = "jdbc:mysql://localhost/master";
	public String login = "root";
	public String password = "aayushi7";
	public String driver = "com.mysql.jdbc.Driver";

	public void setConnection() throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, login, password);
		String query = "select dbname , dbuser, path , url, driver from  dbparam";
		Statement st = (Statement) conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next()) {
			dbname = rs.getString(1);
			user = rs.getString(2);
			DBPath = rs.getString(3);
			url1 = rs.getString(4);
			vdriver = rs.getString(5);

			getResultSet setparam = new getResultSet();
			setparam.login = rs.getString(2);
			setparam.url = rs.getString(4);
			setparam.driver = rs.getString(5);
			setparam.password = password;
			// new General().msg(setparam.login+"
			// "+setparam.url+""+setparam.driver);

			rs.close();

		}
	}

	public String getDBname() throws SQLException, ClassNotFoundException {
		SQL = "call getparam()";
		rs = this.getSPResult(SQL);
		dbname = rs.getString(1);
		rs.close();
		this.closeconn();
		return dbname;
	}

	public String getDBuser() throws ClassNotFoundException, SQLException {
		SQL = "call getparam()";
		rs = this.getSPResult(SQL);
		user = rs.getString(2);
		rs.close();
		this.closeconn();
		return user;
	}

	public String getDBpath() throws ClassNotFoundException, SQLException {
		SQL = "call getparam()";
		rs = this.getSPResult(SQL);
		DBPath = rs.getString(3);
		rs.close();
		this.closeconn();
		return DBPath;
	}

	public String geturl() throws ClassNotFoundException, SQLException {
		SQL = "call getparam()";
		rs = this.getSPResult(SQL);
		url1 = rs.getString(4);
		rs.close();
		this.closeconn();
		return url1;
	}

	public String getDriver() throws ClassNotFoundException, SQLException {
		SQL = "call getparam()";
		rs = this.getSPResult(SQL);
		vdriver = rs.getString(5);
		rs.close();
		this.closeconn();
		return vdriver;
	}

	public String getDBpw() {

		return pw;
	}

}// Last

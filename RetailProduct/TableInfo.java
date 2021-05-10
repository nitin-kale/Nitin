package RetailProduct;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableInfo extends getResultSet {

	private String databaseName = "master";
	private String userName = "root";
	private String password = "aayushi7";
	private String mySQLPort = "3306";
	private String hostUrl = "127.0.0.1";
	private String tableName = "";

	public Connection mygetConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + hostUrl + ":" + mySQLPort, userName, password);
		return conn;
	}

	public ResultSet getProcedure() throws SQLException, ClassNotFoundException, IOException {
		conn = this.getConnection();
		String[] types = { "PROCEDURE" };
		rs = conn.getMetaData().getProcedures(this.dbname, null, null);
		return rs;
	}

	public ResultSet getTables() throws SQLException, ClassNotFoundException, IOException {
		conn = getConnection();
		String[] types = { "TABLE" };
		rs = conn.getMetaData().getTables(this.dbname, null, "%", types);
		return rs;
	}

	public ResultSet getField(String tableName) throws SQLException, ClassNotFoundException, IOException {
		conn = getConnection();
		DatabaseMetaData meta = conn.getMetaData();
		rs = meta.getColumns(this.dbname, null, tableName, "%");
		return rs;
	}

	public void getPocedureContent(String vprocname)
			throws ClassNotFoundException, SQLException, MalformedURLException, IOException {
		String vdbname = this.dbname;
		String SQL = "select CONVERT( body USING utf8) from mysql.proc where db  =   '" + vdbname + "'   and name  = '"
				+ vprocname + "' ";
 		rs = this.getSPResult(SQL);
		if (rs.next()) {
			String vbody = rs.getString(1);
			//new General().msg(vbody);
 			String Title = "View Store Procedure:" + " " + vprocname;
			new showHelp().showHelp(vbody, Title);
		}
	}

	public static void main(String args[]) {

	}

}

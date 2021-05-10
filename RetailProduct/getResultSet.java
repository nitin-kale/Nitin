package RetailProduct;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.DatabaseMetaData;

public class getResultSet extends gnPublicVariable {

	JComboBox<String> Brand;

	Connection conn = null;
	Statement st = null;
	int choice;
	public java.sql.CallableStatement cs;
	public java.sql.PreparedStatement prst;
	public ResultSet rs;
	public ResultSet rs1;
	public ResultSet rs2;
	public ResultSet rs3;
	public ResultSet rs4;
	public ResultSet rs5;
	public ResultSet rs6;
	public DefaultTableModel model = new DefaultTableModel();
	public JTable table = new JTable();

	public static String InternetConnetionAvailable = "Y";
	// public String url = "jdbc:mysql://172.110.10.30//master";

	/*
	 * public String url = "jdbc:mysql://localhost/master"; public String login
	 * = "root"; public String password = "xxxxpmki7"; public String driver =
	 * "com.mysql.jdbc.Driver";
	 */

	public static String baseurl;

	public static String login;
	public static String password;

	public static String dbname;
	public static String driver;
	public static String url = "";
	public static String myterminal = "";

	public static String nodeType = "";

	public static String Remotebaseurl;
	public static String Remotedbname;
	public static String Remotedriver;
	public static String Remoteurl = "";

	public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		try {
			boolean status = false;
			status = true;

			if (status) {
				choice = 0;
				Class.forName(driver);
				url = baseurl + dbname + "?autoReconnect=true&useSSL=true";
				conn = DriverManager.getConnection(url, login, password);
				InternetConnetionAvailable = "Y";
			} else {
				choice = 1;
				switch (choice) {
				case 1:
					new General().msg("No Internet Connection Available");
					System.exit(0);
					new General().msg("No Internet Connection Available");
				}
			}
		} catch (ClassNotFoundException e) {
			new General().msg(e.getMessage());
		}
		return conn;
	}

	public Connection getRemoteConnection() throws ClassNotFoundException, SQLException, IOException {
		try {
			boolean status = false;
			status = true;
			if (status) {
				choice = 0;
				Class.forName(Remotedriver);
				Remoteurl = Remotebaseurl + dbname + "?autoReconnect=true&useSSL=true";
				conn = DriverManager.getConnection(Remoteurl, login, password);
				InternetConnetionAvailable = "Y";
			} else {
				choice = 1;
				switch (choice) {
				case 1:
					new General().msg("No Internet Connection Available");
					System.exit(0);
				}
			}
		} catch (ClassNotFoundException e) {
			new General().msg(e.getMessage());
		}
		return conn;
	}

	public String getResult(String Query) throws SQLException {
		new General().Devmsg(Query);
		String Action = "Sucess";
		try {
			switch (AccessRemoteDB) {
			case "N":
				conn = getConnection();
				break;
			case "Y":
				conn = getRemoteConnection();
				break;
			}

			st = conn.createStatement();
			// ResultSet rs = st.executeQuery(Query);
			int rows = st.executeUpdate(Query);
			if (rows == -1) {
				new General().msg("No  Data Found Please check For Set Operation Rows " + " " + rows + " " + Query);
				Action = "Sucess";
			} else {
				Action = "Sucess";
			}
		} catch (Exception e) {
			e.printStackTrace();
			new General().msg("Get result  " + " " + e.getLocalizedMessage() + "" + Query);
			Action = "Fail";
		} finally {
			conn.close();
		}
		return Action;
	}

	public ResultSet getSPResult(String SQL) throws SQLException, ClassNotFoundException {
		new General().Devmsg(SQL);
		try {
			switch (AccessRemoteDB) {
			case "N":
				conn = getConnection();
				break;
			case "Y":
				conn = getRemoteConnection();
				break;
			}
			// conn = getConnection() ;
			// //DriverManager.getConnection(url,login,password);
			boolean s = conn.isClosed();
			if (!s) {
				CallableStatement cs = (CallableStatement) conn.prepareCall(SQL);
				rs = cs.executeQuery();
			}
			return rs;
		} catch (Exception e) {
			//new General().msg("Result Set:" + " " + e.getLocalizedMessage() + "" + SQL);
			// new General().msg("Get Result Set msg:"+ e.getCause());
		}
		cs.close();
		prst.close();
		return rs;
	}

	
	

	public ResultSet getSPResult1(String SQL) throws SQLException, ClassNotFoundException {
		new General().Devmsg(SQL);
		try {
			switch (AccessRemoteDB) {
			case "N":
				conn = getConnection();
				break;
			case "Y":
				conn = getRemoteConnection();
				break;
			}
 			boolean s = conn.isClosed();
			if (!s) {
				CallableStatement cs = (CallableStatement) conn.prepareCall(SQL);
 				rs =  st.executeQuery(SQL) ;
			}
			return rs;
		} catch (Exception e) {
			new General().msg("Result Set:" + " " + e.getLocalizedMessage() + "" + SQL);
			// new General().msg("Get Result Set msg:"+ e.getCause());
		}
		//cs.close();
		prst.close();
		return rs;
	}

	
	public void checkInternet() {
		String vpara = "36";
		try {
			String value = new getConfigurationSetting().getSpecificConfiguration(vpara);
			internetRequired = value;
			checkInternetConnection();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void checkInternetConnection() throws IOException {
		boolean status = false;
		switch (internetRequired) {
		case "Y":
			status = new checkInernet().isInternetAvailable();
			if (status != true) {
				new gnImageSound().playAlertSound();
				new General().msg("No Internet Connection Available, Please Connect To Internet");
				new gnImageSound().playAlertSound();
				System.exit(0);
			}

		}
	}

	public void CreateDabase(String dbName) throws SQLException {

		String vdbname = "Create Database " + dbName + "";
		getResult(vdbname);
	}

	public String checkDBExists(String dbName) {
		String status = "Fail";
		try {
			Class.forName(driver);
			url = baseurl + dbname + "?autoReconnect=true&useSSL=true";
			conn = DriverManager.getConnection(url, login, password);
			System.out.println("Creating a connection...");
			ResultSet resultSet = conn.getMetaData().getCatalogs();
			while (resultSet.next()) {
				String databaseName = resultSet.getString(1);
				// new General().msg(databaseName);
				if (databaseName.equals(dbName.trim())) {
					status = "Sucess";
				}
			}
			resultSet.close();
			this.closeconn();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public void ResetRootPassword() throws Throwable {
		// String mypwd = new selectCompany().myString ;
		String mypwd = "kalyani";
		String SQL = "SET PASSWORD FOR root@localhost = PASSWORD(" + mypwd + ")";
		try {
			getSPResult(SQL);
			new gnImageSound().playSound();
		} catch (Exception e) {
			new General().msg("Error code 12333:");
		}
	}

	public boolean checktConnection() throws ClassNotFoundException, SQLException, IOException {
		Statement stmt = null;
		Connection conn = null;
		boolean check = false;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			conn = getConnection(); // DriverManager.getConnection(url,login,password);
			String scma = conn.getSchema();
			Properties hh = conn.getClientInfo();
			// String pr1 = hh.getProperty(url);
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT 1 FROM Dual");
			if (rs.next()) {
				check = true;
			}
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			return false;
		} finally {
			if (stmt != null)
				stmt.close();
			if (rs != null)
				rs.close();
		}
		return check;
	}

	public int getMaxConnection() throws ClassNotFoundException, SQLException {
		int max = 0;
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = getConnection();
			new General().msg("Connection is :" + conn);
			DatabaseMetaData metaData = (DatabaseMetaData) conn.getMetaData();
			max = metaData.getMaxConnections();
			new General().msg("Max Connection is :" + max);
		} catch (Exception e) {
			e.getMessage();
		}
		return max;

	}

	public void closeconn() throws SQLException, ClassNotFoundException {

		conn.close();

		if (st != null) {
			st.close();
		}

	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		// String SQL = "call master.getScanArticle(2001)";
		// new getResultSet().closeConnection();

	}

}

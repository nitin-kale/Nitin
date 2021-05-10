package RetailProduct;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.mysql.jdbc.CallableStatement;

public class getBaseConnection {

	Connection conn = null;
	Statement st = null;
	public static String url;
	public static String baseurl = "jdbc:mysql://localhost:3306/";
	public static String login = "root";
	public static String password = "aayushi7";
	public static String driver = "com.mysql.jdbc.Driver";
	public static String mydbname = "akn";
	public static int choice;

	public java.sql.CallableStatement cs;
	public java.sql.PreparedStatement prst;
	public ResultSet rs;
	public ResultSet rs1;
	public ResultSet rs2;
	public ResultSet rs3;
	public ResultSet rs4;
	public ResultSet rs5;
	public ResultSet rs6;

	public Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		try {
			choice = 0;
			if (choice == 0 || choice == 1) // Remove choice 1 in real
											// connection check project
			{
				Class.forName(driver);
				url = baseurl + mydbname + "?autoReconnect=true&useSSL=true";
				conn = DriverManager.getConnection(url, login, password);
				// InternetConnetionAvailable= "N" ;
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public ResultSet getSPResult(String SQL) throws SQLException, ClassNotFoundException { // new
																							// General().msg(SQL)
																							// ;

		try {
			conn = getConnection(); // DriverManager.getConnection(url,login,password);
			CallableStatement cs = (CallableStatement) conn.prepareCall(SQL);
			rs = cs.executeQuery();
			return rs;
		} catch (Exception e) {
			new General().msg("Result Set:" + " " + e.getLocalizedMessage() + "" + SQL);
			// new General().msg("Get Result Set msg:"+ e.getCause());
		}
		cs.close();
		prst.close();
		return rs;
	}

	public String getResult(String Query) throws SQLException {
		String Action = "Sucess";
		try {
			conn = getConnection(); // DriverManager.getConnection(url,login,password);
			st = conn.createStatement();
			// ResultSet rs = st.executeQuery(Query);
			int rows = st.executeUpdate(Query);
			if (rows == -1) {
				msg("No  Data Found Please check For Set Operation Rows " + " " + rows + " " + Query);
				Action = "Sucess";
			} else {
				Action = "Sucess";
				msg(" Operation Sucessfull ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg("Get result  " + " " + e.getLocalizedMessage() + "" + Query);
			Action = "Fail";
		} finally {
			conn.close();
		}
		return Action;
	}

	private void msg(String msg) {
		JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		JLabel lbl = new JLabel();
		lbl.setText(msg);
		JOptionPane.showMessageDialog(dialog, lbl);

	}

	public int msgInput(String msg) {
		String title = "Input Required";
		final JDialog dialog1 = new JDialog();
		dialog1.setAlwaysOnTop(true);
		int response = JOptionPane.showConfirmDialog(dialog1, msg, title, JOptionPane.YES_NO_OPTION);
		return response;
	}

}// Last

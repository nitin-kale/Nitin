package RetailProduct;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

public class gnlcoalsqliconnection extends getResultSet {
	public ResultSet rs, rs1, rs2;
	CallableStatement cs;
	Connection conn2 = null;
	PreparedStatement prst;

	public String gennk(String vcomp, String vstore) {
		String gnk = "";
		switch (ucode) {
		case "ADMIN":
			String vdate = new General().getDate();
			String vpos1 = vdate.substring(0, 2);
			String vpos2 = vdate.substring(3, 5);
			String vpos3 = vdate.substring(6, 8);
			String vposY = vdate.substring(6, 10);
			String newpara = "CO".concat(vcomp);
			String vnum = vpos1.concat(vpos2).concat(vpos3);

			switch (vstore) {
			case "9999":
				gnk = "AKN-".concat(vstore).concat("-").concat("Retail-").concat(vstore).concat("-").concat(newpara);
				break;
			default:
				gnk = "AKN-".concat(vposY).concat("-").concat("Retail-").concat(vstore).concat("-").concat(newpara);
				break;
			}
			vbaseceq = gnk;
			break;
		}
		return gnk;
	}

	private String checkLocalFileExist() {
		String status = "Sucess";

		if (new gnPublicVariable().localsqlPath == null) {
			status = "Fail";
			new General().Quickmsg("Local Connection File Missing ");
		}
		return status;

	}

	public String checkCompandStore(String vcomp, String vstore) {
		String vresult = "Failt";
		try {
			vresult = checkcompandstore(vcomp, vstore);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return vresult;
	}

	private String checkcompandstore(String vcomp, String vstore) throws ClassNotFoundException, SQLException {
		String vresult = "Sucess";
		Connection conn = connect();
		String SQL = str5 + "  WHERE  company_code  = ?   and store_code = ?  ";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, vcomp);
		pstmt.setString(2, vstore);
		rs = pstmt.executeQuery();
		if (!rs.next()) {
			new General().msg(alertmsg1);
			vresult = "Fail";
		}
		// new General().msg(vresult);
		return vresult;

	}

	private Connection connect() throws ClassNotFoundException {
		String localsqlpath = new gnPublicVariable().localsqlPath;
		String url = localparam + localsqlpath;
		try {
			conn2 = DriverManager.getConnection(url);
		} catch (SQLException e) {
			new General().msg("Connection Problem-2LocalS010ZT");
		}
		return conn2;
	}

	public void updateexpdate(String vcomp, String vstore, String vexpdate)
			throws ClassNotFoundException, SQLException {
		Connection conn = connect();
		String SQL = str3 + " '" + vexpdate + "' WHERE  company_code  = ?   and store_code = ?  ";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, vcomp);
		pstmt.setString(2, vstore);
		pstmt.executeUpdate();
		new General().msg("Sucessfully Done ..");
		conn.close();
	}

	public String getVerifyKeyForStore(String vcomp, String vstore)
			throws SQLException, ClassNotFoundException, IOException {
		String status = "Fail";
		String SQL = " ";
		String vkey = " ";
		conn = this.getConnection();
		st = conn.createStatement();
		SQL = str4 + " where company_code  =  " + vcomp + "  and Site_code = " + vstore + " ";
		rs = st.executeQuery(SQL);
		rs.next();
		vkey = rs.getString(1);
		Connection conn = connect();
		SQL = str5 + "  WHERE  company_code  = ?   and store_code = ?  ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vcomp);
			pstmt.setString(2, vstore);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String mycode1 = rs.getString(3).toString();
				String mystatus = new General().getValidateKeyParameter(mycode1, vstore);
				if (mystatus == "Sucess") {
					mycode1 = new General().getcode(mycode1);
					String mycode = new General().convertPassword(mycode1);
					System.out.println("code  is :" + mycode);
					System.out.println("Vkey  is :" + vkey);
					if (mycode.trim().equals(vkey.trim())) {
						status = "Sucess";
						System.out.println(status);
					}
				}
			} else {
				new General().msg("No Record Found For This Company  and Site in Lic. Key Master....:");
				status = "Fail";
			}

		} catch (Exception e) {
			new General().msg(e.getMessage());
		}
		conn2.close();
		conn.close();
		rs.close();
		// new General().msg(status);
		return status;

	}

	public String getVerifyExpKeyForStore(String vcomp, String vstore) throws SQLException, ClassNotFoundException {
		String status = "Fail";
		Connection conn = connect();
		String SQL = str5 + "  WHERE  company_code  = ?    and store_code = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, vcomp);
			pstmt.setString(2, vstore);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				status = rs.getString(4);
				new gnPublicVariable().expdate = status;
			} else {
				new General().msg("No Product Key Found  For This Company  ....:");
				status = "Fail";
			}
		} catch (Exception e) {
			new General().msg(e.getMessage());
		}
		return status;
	}

	public ResultSet getSPResult(String SQL) throws SQLException, ClassNotFoundException {
		new General().Devmsg(SQL);
		try {
			// Class.forName(driver);
			conn2 = connect(); // DriverManager.getConnection(url,login,password);
			CallableStatement cs = (CallableStatement) conn2.prepareCall(SQL);
			rs = cs.executeQuery();
			return rs;
		} catch (Exception e) {
			new General().msg("Result Set:" + " " + e.getLocalizedMessage() + "" + SQL);
			// new General().msg("Get Result Set msg:"+ e.getCause());
		}
		cs.close();
		return rs;
	}

}// Last

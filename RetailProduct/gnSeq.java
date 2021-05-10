package RetailProduct;

import java.sql.Connection;
import java.sql.SQLException;

public class gnSeq extends getResultSet {

	private String vstorecode;
	private String vcomp;
	private String grnSeq;
	private Connection con1;

	public String getBrandSeq() throws ClassNotFoundException, SQLException {
		String vseq = "";
		String SQL = " call Brand_getSeqfromBrandMaster() ";
		rs = this.getSPResult(SQL);

		if (rs.next()) {
			vseq = rs.getString(1);
		} else {
			vseq = "1";
		}
		return vseq;
	}

	public String checkSeqAvailableforGroups() throws Throwable {
		String status = "";
		String vtype = "CheckGroup";
		vstorecode = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String SQL = "call Account_FinAccountInsert( '" + vtype + "', " + vcomp + " , " + vstorecode + " , '" + vfinyear
				+ "' )";
		int i = 0;
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			i++;
		}

		if (i <= 0) {
			status = "N";

		}
		if (i > 0) {
			status = "Y";
		}

		return status;

	}

	public String checkSeqAvailableforGL() throws Throwable {
		String status = "";
		String vtype = "CheckGL";
		vstorecode = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String SQL = "call Account_FinAccountInsert( '" + vtype + "', " + vcomp + " , " + vstorecode + " , '" + vfinyear
				+ "' )";
		int i = 0;
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			i++;
		}

		if (i <= 0) {
			status = "N";

		}
		if (i > 0) {
			status = "Y";
		}

		return status;

	}

	public String checkSeqAvailableforSubGroup() throws Throwable {
		String status = "";
		String vtype = "CheckSubGroup";
		vstorecode = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String SQL = "call Account_FinAccountInsert( '" + vtype + "', " + vcomp + " , " + vstorecode + " , '" + vfinyear
				+ "' )";
		int i = 0;
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			i++;
		}

		if (i <= 0) {
			status = "N";

		}
		if (i > 0) {
			status = "Y";
		}

		return status;

	}

	public String checkSeqAvailableforFinyear() throws Throwable {
		String status = "";
		vstorecode = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String SQL = "call Num_checkTRSeq(" + vcomp + " , " + vstorecode + " , '" + vfinyear + "' )";
		int i = 0;
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			i++;
		}

		if (i <= 0) {
			status = "N";

		}
		if (i > 0) {
			status = "Y";
		}

		return status;
	}

	public String getGlcode(String vtran, String vtype) throws Throwable {
		String vglcode = "";
		vstorecode = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();

		switch (vtype) {
		case "TR":
			String sql1 = "Call  Account_getGlcode( " + vcomp + ", " + vstorecode + " , " + vtran + "  , '" + vfinyear
					+ "')";
			rs = this.getSPResult(sql1);
			rs.next();
			vglcode = rs.getString(1);
			rs.close();
			break;
		}
		return vglcode;
	}

	public String getLoctrfNo() throws Throwable {
		String vloctrfno = "";
		vstorecode = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		String delno = "call 	loctrf_getmaxno(" + vcomp + ", " + vstorecode + ") ";
		rs = this.getSPResult(delno);
		if (rs.next()) {
			int value = Integer.parseInt(rs.getString(1));
			value = value + 1;
			vloctrfno = Integer.toString(value);
			rs.close();
		} else {
			vloctrfno = "1";
		}
		return vloctrfno;
	}

	public String getSeqno(String vtran, String vtype) throws Throwable {
		vstorecode = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		switch (vtype) {
		case "TR":
			// con1 = this.getConnection();
			// con1.createStatement().execute("LOCK TABLE `ms_number_seq`
			// WRITE");
			String sql1 = "Call  num_getSeqNo( " + vcomp + ", " + vstorecode + " , " + vtran + " , '" + vfinyear
					+ "' , '" + vtype + "')";
			rs = this.getSPResult(sql1);
			rs.next();
			grnSeq = rs.getString(1);
			rs.close();
			// con1.commit();
			// con1.createStatement().execute("UNLOCK TABLES");
			break;
		case "MS":

			// con1= this.getConnection() ;
			// con1.createStatement().execute("LOCK TABLE `ms_number_seq`
			// WRITE");
			String sql2 = "Call  num_getSeqNo( " + vcomp + ", " + vstorecode + " , " + vtran + ", '" + vfinyear
					+ "' , '" + vtype + "')";
			rs1 = this.getSPResult(sql2);
			rs1.next();
			grnSeq = rs1.getString(1);
			rs1.close();
			// con1.commit();
			// con1.createStatement().execute("UNLOCK TABLES");
			break;
		}
		return grnSeq;
	}

	public void updateSeqno(String vtran, String vtype) throws Throwable {
		vstorecode = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		switch (vtype) {
		case "TR":
			String sql1 = "Call  num_updateSeqno (" + vcomp + ", " + vstorecode + " , " + vtran + " , '" + vfinyear
					+ "' , '" + vtype + "')";
			rs = this.getSPResult(sql1);
			rs.close();
			break;
		case "MS":
			String sql2 = "Call  num_updateSeqno (" + vcomp + ", " + vstorecode + " , " + vtran + " , '" + vfinyear
					+ "' , '" + vtype + "')";
			rs = this.getSPResult(sql2);
			rs.close();
			break;
		}
	}

	public void updateSeqno_Upoad(String vtran, String vtype, String vlastNo) throws Throwable {
		vstorecode = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		switch (vtype) {
		case "TR":
			String sql1 = "Call  num_UploadupdateSeqno (" + vcomp + ", " + vstorecode + " , " + vtran + " , '"
					+ vfinyear + "' , '" + vtype + "', " + vlastNo + ")";
			rs = this.getSPResult(sql1);
			rs.close();
			break;
		case "MS":
			String sql2 = "Call  num_UploadupdateSeqno(" + vcomp + ", " + vstorecode + " , " + vtran + " , '" + vfinyear
					+ "' , '" + vtype + "' , " + vlastNo + ")";
			rs = this.getSPResult(sql2);
			rs.close();
			break;
		}
	}

	public String getdeclarationNumber() throws SQLException, ClassNotFoundException {
		String vdoc_no = " ";
		String delno = "call 	decl_getDeclno() ";
		rs = this.getSPResult(delno);
		if (rs.next()) {
			rs.last();
			int value = Integer.parseInt(rs.getString(1));
			value = value + 1;
			vdoc_no = Integer.toString(value);
			rs.close();
		} else {
			vdoc_no = "1";
		}
		return vdoc_no;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

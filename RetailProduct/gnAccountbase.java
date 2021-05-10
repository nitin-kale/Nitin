package RetailProduct;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

public class gnAccountbase extends getResultSet {

	public String vamount;
	public String vtype;
	public static String FinalBalTypeis = "";

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public JScrollPane sjsp = new JScrollPane();

	// New Methods As new New logic used

	public void Calculate_glClosingBalancesForSite(String vfrom, String vto, String vfinyear) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "Call Account_gl_CalClosingForSite(" + vcomp + " ," + vstore + " ,  '" + vfrom + "' , '" + vto
				+ "'  , '" + vfinyear + "')";
		this.getSPResult(SQL);
	}

	public void Calculate_Group_ClosingBalancesForSite(String vfrom, String vto, String vfinyear) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "Call Account_Group_CalClosingForSite(" + vcomp + " ," + vstore + " ,  '" + vfrom + "' , '" + vto
				+ "'  , '" + vfinyear + "')";
		this.getSPResult(SQL);
	}

	public void Account_SubGroup_ClosingForSite(String vfrom, String vto, String vfinyear) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "Call Account_SubGroup_CalClosingForSite(" + vcomp + " ," + vstore + " ,  '" + vfrom + "' , '"
				+ vto + "'  , '" + vfinyear + "')";
		this.getSPResult(SQL);

	}

	public void getOpeningStockForSite() throws Throwable {
		String vgroup = "15";
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();

	}

	public ResultSet getAccountClosingDataForSite(String vtype) throws Throwable {
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call  Account_get_PLBSDataForSite( " + vcomp + ",  " + vstore + " ,  '" + vtype + "' , '"
				+ vfinyear + "')";
		rs = this.getSPResult(SQL);
		return rs;
	}

	public String get_GLClosingAmountForSite(String vgroup) throws Throwable {
		String value = "";
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vtype = "GL";
		String SQL = "call Account_getSpecificDataForSite(  '" + vtype + "' ,  " + vcomp + " ,   " + vstore + "   ,  "
				+ vgroup + " ,    '" + vfinyear + "' )";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			value = rs.getString(1);
			FinalBalTypeis = rs.getString(2);
		}
		return value;
	}

	public String get_GLOpeniingAmountForSite(String vgroup) throws Throwable {
		String value = "";
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vtype = "GL";
		String SQL = "call Account_getSpecificDataForSite(  '" + vtype + "' ,  " + vcomp + " ,   " + vstore + "   ,  "
				+ vgroup + " ,    '" + vfinyear + "' )";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			value = rs.getString(3);
			FinalBalTypeis = rs.getString(4);
		}
		return value;
	}

	public String get_groupClosingAmountForSite(String vgroup) throws Throwable {
		String value = "";
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vtype = "Group";
		String SQL = "call Account_getSpecificDataForSite(  '" + vtype + "' ,  " + vcomp + " ,   " + vstore + "   ,  "
				+ vgroup + " ,    '" + vfinyear + "' )";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			value = rs.getString(1);
			FinalBalTypeis = rs.getString(2);
		}
		return value;
	}

	public String get_groupOpeningAmountForSite(String vgroup) throws Throwable {
		String value = "";
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vtype = "Group";
		String SQL = "call Account_getSpecificDataForSite(  '" + vtype + "' ,  " + vcomp + " ,   " + vstore + "   ,  "
				+ vgroup + " ,    '" + vfinyear + "' )";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			value = rs.getString(3);
			FinalBalTypeis = rs.getString(4);
		}
		return value;
	}

	public String get_SubgroupOpeningAmountForSite(String vgroup) throws Throwable {
		String value = "";
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vtype = "SubGroup";
		String SQL = "call Account_getSpecificDataForSite(  '" + vtype + "' ,  " + vcomp + " ,   " + vstore + "   ,  "
				+ vgroup + " ,    '" + vfinyear + "' )";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			value = rs.getString(3);
			FinalBalTypeis = rs.getString(4);
		}
		return value;
	}

	public String get_SubgroupClosingAmountForSite(String vgroup) throws Throwable {
		String value = "";
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vtype = "SubGroup";
		String SQL = "call Account_getSpecificDataForSite(  '" + vtype + "' ,  " + vcomp + " ,   " + vstore + "   ,  "
				+ vgroup + " ,    '" + vfinyear + "' )";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			value = rs.getString(1);
			FinalBalTypeis = rs.getString(2);
		}
		return value;
	}

	public String get_GLAmountForSite(String vgroup) throws Throwable {
		String value = "";
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vtype = "GL";
		String SQL = "call Account_getSpecificDataForSite(  '" + vtype + "' ,  " + vcomp + " ,   " + vstore + "   ,  "
				+ vgroup + " ,    '" + vfinyear + "' )";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			value = rs.getString(1);
			FinalBalTypeis = rs.getString(2);
		}
		return value;
	}

	public void GenerateTB() throws Throwable {
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call Account_generateTBForSite(" + vcomp + "  , " + vstore + " , '" + vfinyear + "')";
		this.getSPResult(SQL);

	}

	// ==============Above All New Procedures and used below part not used
	// confirm and delete this below part =======================

	/*
	 * public String getCompanyOpStock(String vvfrom , String vvto) throws
	 * Throwable { //new General().msg(vvto); String value = "0.00" ; String
	 * vdate = vvfrom ; String vfrom = new
	 * gnConfig().date_ConverttoDBforamt(vvfrom) ; String vto = new
	 * gnConfig().date_ConverttoDBforamt(vvto) ; String vdate1 = new
	 * gnConfig().calculateManufDate(vdate, 1) ; //new General().msg(vdate1);
	 * //value = getAccountStock(vdate1); if (value == null) { value= "0.00" ; }
	 * return value ; }
	 */

	public String getCogs(String vdoctype, String vdocno, String vdocdate) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vamt = "";
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String SQL = "Call account_getcogs(" + vcomp + " , " + vstore + " , " + vdocno + " , '" + vdocdate + "' , '"
				+ vdoctype + "'  , '" + vfinyear + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vamt = rs.getString(1);

			Double vamtcheck = Double.parseDouble(vamt);
			if (vamtcheck < 0) {
				vamtcheck = vamtcheck * -1;
				vamt = Double.toString(vamtcheck);
			}
		}
		return vamt;
	}

	public String getFinalDrcrtype() {
		String value = FinalBalTypeis;
		return value;
	}

	public String getCgstTaxamt(String vdoctype, String vdocno, String vdocdate) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vamt = "";
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vtaxtype = "CGST";
		String SQL = "Call gst_getCGSTamount(" + vcomp + " , " + vstore + " , '" + vdoctype + "' , " + vdocno + " , '"
				+ vdocdate + "'  )";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vamt = rs.getString(1);
		}
		return vamt;
	}

	public String getSgstTaxamt(String vdoctype, String vdocno, String vdocdate) throws Throwable {

		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vamt = "";
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vtaxtype = "SGST";

		String SQL = "Call gst_getSGSTamount(" + vcomp + " , " + vstore + " , '" + vdoctype + "' , " + vdocno + " , '"
				+ vdocdate + "'  )";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vamt = rs.getString(1);
		}
		return vamt;

	}

	public String getIgstTaxamt(String vdoctype, String vdocno, String vdocdate) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vamt = "";
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vtaxtype = "IGST";

		String SQL = "Call gst_getIGSTamount(" + vcomp + " , " + vstore + " , '" + vdoctype + "' , " + vdocno + " , '"
				+ vdocdate + "' )";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vamt = rs.getString(1);
		}
		return vamt;

	}

	//
	public String getAdvCgstTaxamt(String vdoctype, String vdocno, String vdocdate, String vadvtype) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vamt = "";
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String SQL = "Call gst_getAdvCGSTamount(" + vcomp + " , " + vstore + " , '" + vdoctype + "' , " + vdocno
				+ " , '" + vdocdate + "'  , '" + vadvtype + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vamt = rs.getString(1);
		}
		return vamt;
	}

	public String getAdvSgstTaxamt(String vdoctype, String vdocno, String vdocdate, String vadvtype) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vamt = "";
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String SQL = "Call gst_getAdvSGSTamount(" + vcomp + " , " + vstore + " , '" + vdoctype + "' , " + vdocno
				+ " , '" + vdocdate + "'  , '" + vadvtype + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vamt = rs.getString(1);
		}
		return vamt;
	}

	public String getAdvIgstTaxamt(String vdoctype, String vdocno, String vdocdate, String vadvtype) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vamt = "";
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String SQL = "Call gst_getAdvIGSTamount(" + vcomp + " , " + vstore + " , '" + vdoctype + "' , " + vdocno
				+ " , '" + vdocdate + "'  , '" + vadvtype + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vamt = rs.getString(1);
		}
		return vamt;
	}

	//

	public String checkGlcodeavailable(String vglcode) throws Throwable {
		String value = "";
		//
		String vcomp = new gnConfig().getCompanycode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vstore = new gnConfig().getStoreID();
		String SQL = "Call  account_checkGLAvailable( " + vcomp + " , " + vstore + " , " + vglcode + " , '" + vfinyear
				+ "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			value = "Y";
		} else {
			value = "N";
		}
		return value;

	}

	public void Account_InsertSupplierCust() throws Throwable {
		String vglcode = "";
		String vglname = "";
		String vcomp = new gnConfig().getCompanyCode();
		String vtype = "";
		String SQL = "call account_getSuplandCsut(" + vcomp + ")";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vglcode = rs.getString(1);
			vglname = rs.getString(2);
			vtype = rs.getString(3);
			insertGlData(vglcode, vglname, vtype);
		}
	}

	public void insertAllSupplierandCustinglmast() throws Throwable {
		String vcomp = new gnConfig().getCompanycode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call account_insertAllCusandSup(" + vcomp + " , " + vstore + "  , '" + vfinyear + "')";
		this.getSPResult(SQL);

	}

	public void insertGlData(String vglcode, String vglname, String vtype) throws Throwable {
		String SQL;
		String vgrpcode = "";
		String vgrpname = "";
		String vsubcode = "";
		String vsubgrpname = "";
		String vdrcr = "";
		String isavailable = " ";
		isavailable = checkGlcodeavailable(vglcode);
		String vcomp = new gnConfig().getCompanycode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vstore = new gnConfig().getStoreID();
		if (isavailable == "N") {
			switch (vtype) {
			case "Y":
				vgrpcode = "8";
				vgrpname = "Sundry Creditors";
				vsubcode = "0";
				vsubgrpname = "-";
				vdrcr = "Cr";
				SQL = " Call Account_InsertSupplierCust(" + vcomp + " , " + vstore + " ,  " + vglcode + " , '" + vglname
						+ "' , '" + vsubcode + "' , '" + vgrpcode + "' , '" + vdrcr + "' , '" + vgrpname + "' , '"
						+ vsubgrpname + "' , '" + vfinyear + "'  )";
				this.getSPResult(SQL);
				break;

			case "N":
				vgrpcode = "20";
				vgrpname = "Sundry Debtors";
				vsubcode = "0";
				vsubgrpname = "-";
				vdrcr = "Dr";
				SQL = " Call Account_InsertSupplierCust( " + vcomp + " , " + vstore + " , " + vglcode + " , '" + vglname
						+ "' , '" + vsubcode + "' , '" + vgrpcode + "' , '" + vdrcr + "' , '" + vgrpname + "' , '"
						+ vsubgrpname + "' , '" + vfinyear + "' )";
				this.getSPResult(SQL);
				break;
			}
		}
		return;
	}

	public void showAccouuntEntry(String vtype, String vdocno, String vdocdate) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String SQL = "call  account_showEntry(" + vcomp + ", " + vstore + ",  '" + vtype + "', " + vdocno + " , '"
				+ vdocdate + "')";
		String col[] = { "DocType", "Doc.No", "Doc.Date", "Particular", "Amount", "DrCr", "Company", "Branch",
				"Finyear", "Naration" };
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col, 10, "N", "N", vtype);
		new gnTable().setTableColWidth(stable, 3, 400);
		new gnTable().setTableColWidth(stable, 6, 50);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, col);
		sjsp.setViewport(prt6);
		new General().msgsearch(sjsp, stable, "View Account Entry For Doc.no" + " " + vdocno, 700, 180);

	}

	public static void main(String[] args) {
	}

}// Last

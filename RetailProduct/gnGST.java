package RetailProduct;

import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

public class gnGST extends getResultSet {

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public JScrollPane sjsp = new JScrollPane();

	public String getMyGSTypeName() throws Throwable {
		String vmytype = "";
		String vscheme = "";

		vmytype = gst_getmytaxschemecode();
		switch (vmytype) {
		case "1":
			vscheme = "C";
			break;
		case "2":
			vscheme = "R";
			break;
		case "0":
			vscheme = "N";
			break;
		}
		return vscheme;
	}

	public void showGSTEntry(String vtype, String vdocno, String vdocdate1, String vdocdate2) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate1);
		vdocdate2 = new gnConfig().date_ConverttoDBforamt(vdocdate2);
		String SQL = "call  Gst_viewGstData('" + vtype + "', " + vcomp + ", " + vstore + ",   '" + vdocdate1 + "' , '"
				+ vdocdate2 + "',  " + vdocno + "  )";
		String col[] = { "DocType", "Docno", " Date", "Docvalue", "value_Sales", "TaxRate", "TAxablevalue",
				"TaxPayable", "CGST", "SGST", "IGST", "Supplier", "ReverseCharge" };
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col, 13, "N", "N", vtype);
		new gnTable().setTableColWidth(stable, 3, 400);
		new gnTable().setTableColWidth(stable, 6, 50);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("GST View Data");
		prt6.setScrollMode(0);
		prt6.add(stable, col);
		sjsp.setViewport(prt6);
		new General().msgsearch(sjsp, stable, "View Account Entry For Doc.no" + " " + vdocno, 700, 180);
	}

	public String getGSTSchemecode() throws Throwable {
		String vscheme = "0";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "call gst_getmyTaxScheme('" + vcomp + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			String taxtype = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return vscheme;
	}

	public String checkReverseChargeApplicable(String vcode) throws Throwable {
		String xresult = "";

		String myCompGst = ismyComanyGSTRegister();
		String supplierisGST = isSupplierGSTRegister(vcode);
		new General().msg(myCompGst + " " + supplierisGST);

		if (supplierisGST.trim() == "N") {
			xresult = "Y";
		}

		return xresult;
	}

	public String gst_getmytaxscheme() throws Throwable {
		String vscheme = "NO Tax";
		String vcomp = new gnConfig().getCompanyCode();
		String sql = "call gst_getmyTaxScheme('" + vcomp + "')";
		rs = this.getSPResult(sql);
		if (rs.next()) {
			String taxtype = rs.getString(1);
			switch (taxtype) {
			case "0":
				vscheme = "NO-TAX";
				break;
			case "1":
				vscheme = "Composition Scheme";
				break;
			case "2":
				vscheme = "Regular Scheme";
				break;
			}
		}
		rs.close();
		this.closeconn();

		return vscheme;

	}

	public String gst_getmytaxschemecode() throws Throwable {
		String vscheme = "NO Tax";
		String vcomp = new gnConfig().getCompanyCode();
		String sql = "call gst_getmyTaxScheme('" + vcomp + "')";
		rs = this.getSPResult(sql);
		if (rs.next()) {
			vscheme = rs.getString(1);
		}
		rs.close();
		this.closeconn();

		return vscheme;

	}

	public String getmonthname(String vdate) throws ClassNotFoundException, SQLException {
		String mon = " ";

		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		String sql = "call gst_getmonthname('" + vdate + "')";
		this.getSPResult(sql);
		rs.close();
		this.closeconn();

		return mon;

	}

	public String getmonth(String vdate) throws ClassNotFoundException, SQLException {
		String mon = " ";

		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		String sql = "call gst_getmonth('" + vdate + "')";
		rs = this.getSPResult(sql);
		if (rs.next()) {
			mon = rs.getString(1);
		}
		rs.close();
		this.closeconn();

		return mon;

	}

	public String ismyComanyGSTRegister() throws Throwable {
		String result = "Y";
		String vreg = "";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "Call  GST_ismycompanyreg(" + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vreg = rs.getString(1);
			String vgstno = rs.getString(2);
			result = vreg;
		}
		rs.close();
		this.closeconn();

		return result;
	}

	public String getComanyGSTno() throws Throwable {
		String result = "";
		String vreg = "";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "Call    GST_getmyGSTNO(" + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vreg = rs.getString(1);
			result = vreg;
		}
		rs.close();
		this.closeconn();

		return result;
	}

	public String getmystatename() throws Throwable {
		String vstatename = " ";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL1 = "call  gst_mystatename(" + vcomp + ")";
		rs = this.getSPResult(SQL1);
		if (rs.next()) {

			vstatename = rs.getString(1).toString().trim();
		}
		rs.close();
		this.closeconn();
		return vstatename;
	}

	public String getmyState() throws Throwable {
		String result = " ";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "Call  GST_getMyState(" + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			result = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return result;
	}

	public String validateGSTNO() throws Throwable {
		String result = "Y";
		String vreg = "";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "Call  GST_ismycompanyreg(" + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vreg = rs.getString(1);
			String vgstno = rs.getString(2);

			if (vreg == "Y" & vgstno.length() != 15) {
				result = "N";
			}
		}
		rs.close();
		this.closeconn();
		return result;

	}

	public String isSupplierGSTRegister(String vcode) throws Throwable {
		String result = "Y";
		String vcomp = new gnConfig().getCompanyCode();
		if (vcode.length() > 0) {
			String SQL = "Call  GST_isSupplierReg(" + vcomp + " , " + vcode + ")";
			rs = this.getSPResult(SQL);
			if (rs.next()) {
				result = rs.getString(1);
			}
			rs.close();
			this.closeconn();
		}
		return result;
	}

	public String isCustmoerGSTRegister(String vcode) throws Throwable {
		String result = "Y";
		// new General().msg(vcode);
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "Call  GST_isSupplierReg(" + vcomp + " , " + vcode + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			result = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return result;

	}

	public String getSupplierState(String vcode) throws Throwable {
		String result = " ";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "Call  GST_getSupplierState(" + vcomp + " , " + vcode + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			result = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return result;
	}

	public String getCustomerState(String vcode) throws Throwable {
		String result = " ";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "Call  GST_getSupplierState(" + vcomp + " , " + vcode + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			result = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return result;
	}

	public String getCustomerStatename(String vcode) throws Throwable {
		String result = " ";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "Call  GST_getCuststateandgst(" + vcomp + " , " + vcode + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			result = rs.getString(3);
		}
		rs.close();
		this.closeconn();
		return result;
	}

	public String getCustomerGSTNO(String vcode) throws Throwable {
		String result = " ";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "Call  GST_getCustomerGSTNO(" + vcomp + " , " + vcode + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			result = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return result;
	}

	public String getsupplierGSTNO(String vcode) throws Throwable {
		String result = " ";
		String vcomp = new gnConfig().getCompanyCode();
		if (vcode.length() > 0) {
			String SQL = "Call  GST_getCustomerGSTNO(" + vcomp + " , " + vcode + ")";
			rs = this.getSPResult(SQL);
			if (rs.next()) {
				result = rs.getString(1);
			}
			rs.close();
			this.closeconn();
		}
		return result;
	}

	public String getSupplierSchemeName(String vcode) throws Throwable {
		String vscheme = "NO Tax";
		String vcomp = new gnConfig().getCompanyCode();
		if (vcode.length() > 0) {
			String sql = "Call  GST_getSupplerSchemeCode(" + vcomp + " , " + vcode + ")";
			rs = this.getSPResult(sql);
			if (rs.next()) {
				String taxtype = rs.getString(1);
				switch (taxtype) {
				case "0":
					vscheme = "NO-TAX";
					break;
				case "1":
					vscheme = "Composition";
					break;
				case "2":
					vscheme = "Regular";
					break;
				}

			}
			rs.close();
			this.closeconn();
		}
		return vscheme;
	}

	public String getSupplierSchemecode(String vcode) throws Throwable {
		String result = " ";
		String vcomp = new gnConfig().getCompanyCode();
		if (vcode.length() > 0) {

			String SQL = "Call  GST_getSupplerSchemeCode(" + vcomp + " , " + vcode + ")";
			rs = this.getSPResult(SQL);
			if (rs.next()) {
				result = rs.getString(1);
			}
			rs.close();
			this.closeconn();
		}
		return result;
	}

}

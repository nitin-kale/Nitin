package RetailProduct;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class gnConfig extends getResultSet {

	public String getcompanyAdd1() throws ClassNotFoundException, SQLException {
		String vaddr = "";
		String vtype = "Addr1";
		String SQL = "call comp_getData('" + vtype + "', " + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vaddr = rs.getString(1);
		}
		return vaddr;
	}

	public String getcompanyAdd2() throws ClassNotFoundException, SQLException {
		String vaddr = "";
		String vtype = "Addr2";
		String SQL = "call comp_getData('" + vtype + "', " + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vaddr = rs.getString(1);
		}
		return vaddr;
	}

	public String getcompanyAdd3() throws ClassNotFoundException, SQLException {
		String vaddr = "";
		String vtype = "Addr3";
		String SQL = "call comp_getData('" + vtype + "', " + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vaddr = rs.getString(1);
		}
		return vaddr;
	}

	public String getcompanyAdd4() throws ClassNotFoundException, SQLException {
		String vaddr = "";
		String vtype = "Addr4";
		String SQL = "call comp_getData('" + vtype + "', " + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vaddr = rs.getString(1);
		}
		return vaddr;
	}

	public String getcompanyemail() throws ClassNotFoundException, SQLException {
		String vaddr = "";
		String vtype = "Email";
		String SQL = "call comp_getData('" + vtype + "', " + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vaddr = rs.getString(1);
		}
		return vaddr;
	}

	public String getcompanyphone() throws ClassNotFoundException, SQLException {
		String vaddr = "";
		String vtype = "Phone";
		String SQL = "call comp_getData('" + vtype + "', " + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vaddr = rs.getString(1);
		}
		return vaddr;
	}

	public String getCompanyCode() throws Throwable {
		String vcompcode = " ";
 		vcompcode = this.compcode;
		if (vcompcode.length() == 0) {
			vcompcode = "Fail";
			// new General().msg("No Company Found...Create Company First") ;
		}
		return vcompcode;
	}

	public String getCompany() throws Throwable {
 
		String name = this.compname;
		String SQL = "Select company_Name from ms_company_master where Company_code = " + vcomp + " " ;
		rs = this.getSPResult(SQL);
		if (rs.next())
		{
			name = rs.getString(1);
		}
		return name;
	}

	public String getStoreID() throws Throwable {
		String StoreID = this.myvstore;
		if (StoreID == "0") {
			new General().msg("Store is Not Created For This Company");
		}
		return StoreID;
	}

	public String getStorename(String value) throws Throwable {
		// String Storename = new ApplicationMenu().getStoreName() ;
		String Storename = this.storename;

		return Storename;
	}

	public DefaultTableModel getMasterTableData(DefaultTableModel model, String vmasterName, String vtype)
			throws SQLException, ClassNotFoundException {
		String vverticle = "1";
		String Col[] = { " Type ", "Code ", "Description" };
		String SQL = " call   master_getmasterData('" + vmasterName + "')";
		// String sql7 = "call master_getmasterData('"+vmasterName+",
		// "+vverticle+")";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Record  Not Fouund ...");
		} else {
			while (rs.next()) {
				model.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2) });
			}
			rs.close();
			this.closeconn();
		}
		return model;
	}

	public void TableRefresh() throws SQLException, ClassNotFoundException {
		String comp1 = "call rm_company_data_for_fresh_upload()";
		String conf1 = "call  rm_config_data_for_fresh_upload()";
		String cust1 = " call rm_customer_data_for_fresh_upload()";
		String ean1 = "call rm_ean_data_for_fresh_upload()";
		String num1 = "call rm_numseq_data_for_fresh_upload()";
		String role1 = " call  rm_Role_data_for_fresh_upload()";
		String site1 = "call  rm_site_data_for_fresh_upload()";
		String article1 = "call rm_article_data_for_fresh_upload()";
		String salesprice1 = "Call  rm_salesPriceconfig_data_for_fresh_upload() ";
		String tax1 = "call rm_tax_data_for_fresh_upload()";
		String user1 = "call rm_user_data_for_fresh_upload()";
		String mas = "call  rm_master_data_for_fresh_upload()";

		this.getSPResult(mas);
		rs.close();
		this.closeconn();

		this.getSPResult(comp1);
		rs.close();
		this.closeconn();

		this.getSPResult(conf1);
		rs.close();
		this.closeconn();

		this.getSPResult(cust1);
		rs.close();
		this.closeconn();

		this.getSPResult(ean1);
		rs.close();
		this.closeconn();

		this.getSPResult(num1);
		rs.close();
		this.closeconn();

		this.getSPResult(role1);
		rs.close();
		this.closeconn();

		this.getSPResult(site1);
		rs.close();
		this.closeconn();

		this.getSPResult(article1);
		rs.close();
		this.closeconn();

		this.getSPResult(salesprice1);
		rs.close();
		this.closeconn();

		this.getSPResult(tax1);
		rs.close();
		this.closeconn();

		this.getSPResult(user1);
		rs.close();
		this.closeconn();

		this.closeconn();
		rs.close();
		this.closeconn();

	}

	public String checkConfigTable() throws Throwable {
		String vcomp = getCompanyCode();
		String vstore = getStoreID();
		String Status = "Configuration Table is Empty Please check";
		String SQL = " Call  conf_getconfigTableCheck(" + vcomp + ", " + vstore + ")";

		rs = this.getSPResult(SQL);
		rs.next();
		int vcount = Integer.parseInt(rs.getString(1));
		// new General().msgint(vcount) ;
		if (vcount > 0) {
			Status = "Configuration Test Secussfull ";
		}
		rs.close();
		this.closeconn();
		return Status;
	}

	public String getTerminalID() throws Throwable {
		String name1 = "";
		name1 = this.myterminal;
		return name1;

	}

	public String invoiceaudit(int vcode) throws Throwable { // new
																// General().msg("Gnconfig()
																// method Audit
																// check is in
																// Progress" +
																// vcode +
																// vstore) ;
		String DB = "Fail";
		String vcomp = getCompanyCode();
		String vstore = getStoreID();
		String SQL = " call invoiceAudit(" + vcode + ", " + vstore + " , " + vcomp + ")";
		// new General().msg(SQL) ;
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Data is not inerted properly ");
			DB = "Fail";
		} else {
			Double hdr_gross = Double.parseDouble(rs.getString(2).toString());
			Double hdr_net = Double.parseDouble(rs.getString(3).toString());
			Double dtl_gross = Double.parseDouble(rs.getString(4).toString());
			Double dtl_net = Double.parseDouble(rs.getString(5).toString());
			Double pmtamt = Double.parseDouble(rs.getString(6).toString());
			DB = "Sucess";
		}
		rs.close();
		this.closeconn();
		return DB;
	}

	public String batch_isBatchExist(String vstorecode, String varticle, String vbatchno, String vexpDate,
			String vlocation, String vcomp) throws SQLException, ClassNotFoundException {
		String result = "";
		String SQL = "call  batch_isbatchExist(" + vstorecode + " , " + varticle + " ,'" + vbatchno + "' , '" + vexpDate
				+ "' , '" + vlocation + "', " + vcomp + ")";
		// new General().msg("Pass SQL to Check :" +SQL);
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			result = "insert";
		} else {
			result = "update";
		}
		rs.close();
		this.closeconn();
		return result;
	}

	public String setuploadPath() throws SQLException, ClassNotFoundException {
		String Path = "File Not Found ";
		String SQL = " call conf_getConfigUploadPath() ";
		rs = this.getSPResult(SQL);
		rs.next();
		Path = rs.getString(1);
		this.closeconn();
		rs.close();
		return Path;
	}

	public String getUserCode() throws Throwable {
		String vusercode = " ";
		vusercode = this.getUsercode();
		if (vusercode.length() == 0) {
			vusercode = "Fail";
			new General().msg("No Company Found...Create Company First");
		}
		return vusercode;
	}

	public String companycreated() throws ClassNotFoundException, SQLException {
		String Status = "Y";

		String SQL = "Call  Comp_checkCompanyCreated()";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			Status = "N";
			new General().msg("No Company Is Availbale ....");
		}
		rs.close();
		this.closeconn();
		return Status;
	}

	public String checkCompany(String vcomp) throws Throwable {
		String name = "";
		String sql = "call GetCompnayName(" + vcomp + ")";
		rs = this.getSPResult(sql);
		if (rs.next()) {
			name = rs.getString(1);
			this.closeconn();
			rs.close();
		} else {
			new General().msg("No Company");
			name = "No Company Fouund..";
		}
		rs.close();
		this.closeconn();
		return name;
	}

	public String getRoleName() {
		String vrolename = " ";
		vrolename = new gnPublicVariable().getRoleName().toUpperCase();
		if (vrolename.length() == 0) {
			vrolename = "Fail";
			// new General().msg("No Company Found...Create Company First") ;
		}
		return vrolename;
	}

	public String getmenuPressed() throws Throwable {
		String vmenu = new ApplicationMenu().getClickedMenu();
		if (vmenu.length() == 0) {
			vmenu = "Fail";
			// new General().msg("No Company Found...Create Company First") ;
		}
		return vmenu;
	}

	public String getDefaultCurrency(String vcode) throws SQLException, ClassNotFoundException {
		String SQL = " call getdefaultCurrency(" + vcode + ")";
		rs = this.getSPResult(SQL);
		rs.next();
		String dfcurr = rs.getString(1);
		rs.close();
		this.closeconn();
		return dfcurr;
	}

	public String getCurrencyName(String vcode1) throws SQLException, ClassNotFoundException {
		String SQL1 = " call getCurrencyName(" + vcode1 + ")";
		rs = this.getSPResult(SQL1);
		rs.next();
		String curname = rs.getString(1);
		rs.close();
		this.closeconn();
		return curname;
	}

	public String getbankclbal() throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		// String ssql = "Call bank_getMyBank("+vcomp+", "+vstore+")" ;
		String ssql = "Call bank_getMyBank(" + vcomp + ")";
		String vcode = "";

		rs = this.getSPResult(ssql);
		if (rs.next()) {
			rs.last();
			vcode = rs.getString(5);
			rs.close();
			this.closeconn();
		}
		return vcode;
	}

	public String getbankopbal() throws Throwable {
		String vcomp = getCompanyCode();
		String vstore = getStoreID();
		// String ssql = "Call bank_getMyBank("+vcomp+", "+vstore+")" ;
		String ssql = "Call bank_getMyBank(" + vcomp + ")";

		String vcode = "";
		rs = this.getSPResult(ssql);
		if (rs.next()) {
			rs.last();
			vcode = rs.getString(4);
			rs.close();
		}
		rs.close();
		this.closeconn();
		return vcode;
	}

	public String getAccCode() throws Throwable {
		String vcomp = getCompanyCode();
		String vstore = getStoreID();
		// String ssql = "Call bank_getMyBank("+vcomp+", "+vstore+")" ;
		String ssql = "Call bank_getMyBank(" + vcomp + ")";

		String vcode = "";
		rs = this.getSPResult(ssql);
		if (rs.next()) {
			rs.last();
			vcode = rs.getString(4);
			rs.close();
		}
		rs.close();
		this.closeconn();
		return vcode;
	}

	public String getBankCode() throws Throwable {
		String vcomp = getCompanyCode();
		String vstore = getStoreID();
		String ssql = "Call bank_getMyBank(" + vcomp + ")";
		String vcode = "";
		rs = this.getSPResult(ssql);
		if (rs.next()) {
			rs.last();
			vcode = rs.getString(1);
			rs.close();
		}
		rs.close();
		this.closeconn();
		return vcode;
	}

	public String getBankName(String vcode) throws Throwable {
		String vcomp = getCompanyCode();
		String vstore = getStoreID();
		// String ssql = "Call bank_getMyBank("+vcomp+", "+vstore+")" ;
		String ssql = "Call bank_getMyBank(" + vcomp + ")";

		String vcode1 = " ";
		rs = this.getSPResult(ssql);
		if (rs.next()) {
			rs.last();
			vcode1 = rs.getString(2);
		}
		rs.close();
		this.closeconn();
		return vcode1;
	}

	public String getCashierShift(String vcomp, String vsitecode, String vdate, int vterminal, String vcashier)
			throws SQLException, ClassNotFoundException {
		int vshiftcode = 0;
		String vcode = "";
		String newcode = "";
		// new General().msg(vsitecode + vdate + vterminal+vcashier);
		String ssql = "Call cashierShift(" + vcomp + ",   " + vsitecode + " ,'" + vdate + "' , " + vterminal + " ,'"
				+ vcashier + "')";
		rs = this.getSPResult(ssql);
		if (rs.next()) {
			rs.last();
			vcode = rs.getString(5);
			vshiftcode = 1 + Integer.parseInt(vcode);
			newcode = Integer.toString(vshiftcode);
			vcode = newcode;
		} else {
			vshiftcode = 1;
			vcode = (Integer.toString(vshiftcode));
		}
		rs.close();
		this.closeconn();
		return vcode;
	}

	public String get_duedate(String vgrndate, int vcrdays) throws Exception {
		String vexp = " ";
		String SQL = "Call date_addDays('" + vgrndate + "' , " + vcrdays + ")";
		rs = this.getSPResult(SQL);
		rs.next();
		vexp = rs.getString(1);
		rs.close();
		this.closeconn();
		return vexp;
	}

	public String calculateExpiryDate(String vmanufDate, int vdays) throws Exception {
		String vexp = " ";
		String SQL = "Call date_addDays('" + vmanufDate + "' , " + vdays + ")";
		rs = this.getSPResult(SQL);
		rs.next();
		vexp = rs.getString(1);
		rs.close();
		this.closeconn();

		return vexp;
	}

	public String calculateManufDate(String vexpDate, int vdays) throws Exception {
		String vmanuf = " ";
		vexpDate = date_ConverttoDBforamt(vexpDate);
		String SQL = "Call date_SubDays('" + vexpDate + "' , " + vdays + ")";
		rs = this.getSPResult(SQL);
		rs.next();
		vmanuf = rs.getString(1);
		rs.close();
		this.closeconn();
		return vmanuf;
	}

	public String date_ConverttoDBforamt(String vdate) throws SQLException, ClassNotFoundException {
		String insertdate = " ";
		String SQL = "call  Date_ConverttoDBformat('" + vdate + "')";
		rs = this.getSPResult(SQL);
		rs.next();
		insertdate = rs.getString(1);
		rs.close();
		this.closeconn();
		return insertdate;
	}

	public String Date_convertToApplformat(String vdate) throws SQLException, ClassNotFoundException {

		String getdate = " ";
		String SQL = "call  Date_ConverttoApplformat('" + vdate + "')";
		// new General().msg(SQL);
		rs1 = this.getSPResult(SQL);
		rs1.next();
		getdate = rs1.getString(1);
		// new General().msg("Convert Date is"+ getdate );
		rs1.close();
		this.closeconn();
		return getdate;
	}

	public int shelf_getShelfLife(String varticle) throws NumberFormatException, SQLException, ClassNotFoundException {
		int vshelf = 0;
		String SQL = "call   shelf_getshelfLife(" + varticle + ")";
		rs = this.getSPResult(SQL);
		rs.next();
		vshelf = Integer.parseInt(rs.getString(1));
		rs.close();
		this.closeconn();
		return vshelf;
	}

	public String getDaybeginDate() throws Throwable {
		String beginDate = null;
		vcomp = getCompanyCode();
		vstore = getStoreID();
		String SQL = " call getDaybeginDate(" + vstore + " , " + vcomp + ")";
		try {
			rs = this.getSPResult(SQL);
			rs.next();
			beginDate = rs.getString(1);
			rs.close();
			this.closeconn();
		} catch (Exception e1) {
			new General().msg(e1.getMessage());
		}
		return beginDate;
	}

	public String checkDaybegin(String vcomp, String vcode) throws SQLException, ClassNotFoundException {
		String Action = "N";
		String SQL = "call day_checkDayBegin( " + vcomp + ", " + vcode + ")";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			// new General().msg("check day begin flag and setting");
			Action = "N";
		} else {
			String vallow = rs.getString(4).trim();
			Action = vallow;
			rs.close();
		}
		rs.close();
		this.closeconn();
		return Action;
	}

	public static void main(String[] args) {

	}

} // Last

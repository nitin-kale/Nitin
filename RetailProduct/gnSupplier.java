package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class gnSupplier extends getResultSet {

	private JTextField vendorcode;
	private JTextField vendorName;
	private JTextField Email;
	private JTextField Phone;
	private JTextField crdays;

	private JTextField vmycode;
	private JTextField vmyname;

	public static String rcustcode;
	public static String rcustName;

	public static String rvendorcode;
	public static String rvendorName;

	public static String rEmail;
	public static String rPhone;
	public static String rcrdays;
	public static String rstatecode;
	public static String rstatename;
	public static String rregdlr;

	public DefaultTableModel smodel = new DefaultTableModel();

	//// Table Related

	public JTable stable = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			// 3 4 5 6 9 10 15 16
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 4 || column == 5 || column == 6 || column == 10 || column == 15
					|| column == 16 || column == 18) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Cambria", Font.PLAIN, 14));
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}

			if (Language == "H") {
				if (column == 2) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}
			return componentt;

		}
	};

	public String SCol[] = { "Type", "Customer code", "Name", "Phone", "Email", "Credit Days", "Verticle", "StateCode",
			"State Name", "GST.Reg.Dlr" };
	public JScrollPane sjsp = new JScrollPane();

	
	
	public String getNewCustomerCode() throws ClassNotFoundException, SQLException {
		
		String vcustcode = " ";
 		String SQL = "call getcustomerCode("+vcomp+")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vcustcode = rs.getString(1);
			if (vcustcode != "0") {
				vcustcode =  vcustcode;
 				//custid.setText(vcustcode);
			}
			switch (vcustcode) {
			case "0":
				vcustcode = "1";
				//custid.setText("1");
				break;
			}
		}
 		return vcustcode ;
	}

	
	public String  checkCustomerExists(String vcode1) throws ClassNotFoundException, SQLException
	{
		String status  = "N" ;
		String SQL = "Select code from ms_customer_master where company_code = "+vcomp+" "
				+ " and code  = "+vcode1+" " ;
		rs = this.getSPResult(SQL) ;
		if(rs.next())
		{
			status = "Y" ;
		}
		return status ;
	}

	
	
	public void updateCustData(String vcode1 , String vname, String vmobile , String vaddr1 , String vaddr2) throws Throwable 
	{
		String SQL = "update ms_customer_master set name = '"+vname+"' ,  mobile = '"+vmobile+"' , "
				+ "addr1 = '"+vaddr1+"' , addr2 = '"+vaddr2+"' where  "
				+ "  company_code =  '"+vcomp+"'  and  code  = '"+vcode1+"' " ;
		this.getResult(SQL);
		//new General().msg("Data Updated => Sucess .. ");
	}
 
  

	
 	
	public void SaveCustData(String vcode1 , String vname, String vmobile , String vaddr1 , String vaddr2, String applyforpromo , String applydate) throws Throwable {
  		String schemecode = "0" ;
		String status1 = "Sucess";
		boolean vdelear = false;
		int vcode = Integer.parseInt(vcode1);
		String vregDelear = "N";
		if (vdelear) {
			vregDelear = "Y";
		}
 		//String vSchemetype = (String) scheme.getSelectedItem();
		String vSchemetype = "0" ;
		switch (vSchemetype) {
		case "No Tax":
			schemecode = "0";
			break;
		case "Composition":
			schemecode = "1";
			break;
		case "Regular":
			schemecode = "2";
			break;
		}
 		String viscustomer = "Y";
		String vsuplyType =  "0";
 		String vaddr3 = "";
		String vaddr4 = "";
		String vcitycode = "0";
		String vcityname = "0";
		String vstatecode = "0";
		String vstatename = "0";
		String vtel = vmobile;

		String vtotalland = "0";
 
		String vtalukacode = "0";
		String vtalukaname = "0";

		String vdistcode = "0";
		String vdistname = "0";

 		String vmobile2 = "0";
		String vpincode = "0";
		String vemail = "0";
		String vclasscode =  "0";
		String vclassname =  "0";
		String vtypecode =  "0";
		String vtypename =  "0";
		String vgroupcode =  "0";
		String vgroupname =  "0";
		String vtinno = "0";
		String DBStatus = "Sucess" ;
		String vcontactperson = "0";
		int vcrdays = 0;
		String vdrcr = "N";
		String vopbal = "0";
		if (vopbal.length() == 0) {
			vopbal = "0";
		}
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
 		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String poshdr = "Insert into ms_customer_master(Code, " + "Name, Gender , Addr1 , Addr2 , Addr3 , Addr4 , "
				+ "city , city_name , state , state_name , " + " tel , mobile , mobile1 , pincode , Email ,"
				+ "IsSupplier , creditDays, contact_person ," + " GSTNO , cust_class , class_name ,"
				+ " cust_type, Type_name , cust_group,  group_name ,"
				+ " Supplier_type , company_code, Site_code, verticle,  fssaino, reg_delear ,  gstdate, opbal, drcr, scheme,"
				+ "  talukacode , talukaname, totalland , distcode , distname , alternatename, applyMonthlyPromo , promostartDate)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con1.prepareStatement(poshdr);
			prst.setInt(1, vcode);
			prst.setString(2, vname);
			prst.setString(3, "M");
			prst.setString(4, vaddr1);
			prst.setString(5, vaddr2);
			prst.setString(6, vaddr3);
			prst.setString(7, vaddr4);
			prst.setString(8, vcitycode);
			prst.setString(9, vcityname);
			prst.setString(10, vstatecode);
			prst.setString(11, vstatename);
			prst.setString(12, vtel);
			prst.setString(13, vmobile);
			prst.setString(14, vmobile2);
			prst.setString(15, vpincode);
			prst.setString(16, vemail);
			prst.setString(17, viscustomer);
			prst.setInt(18, vcrdays);
			prst.setString(19, vcontactperson);
			prst.setString(20, vtinno);
			prst.setString(21, vclasscode);
			prst.setString(22, vclassname);
			prst.setString(23, vtypecode);
			prst.setString(24, vtypename);
			prst.setString(25, vgroupcode);
			prst.setString(26, vgroupname);
			prst.setString(27, vsuplyType);
			prst.setString(28, vcomp);
			prst.setString(29, vstore);
			prst.setString(30, new gnHierarchy().getVerticleCode());
			prst.setString(31, "0");
			prst.setString(32, "N");
			prst.setString(33,  "0000.00.00");
			prst.setString(34, vopbal);
			prst.setString(35, vdrcr);
			prst.setString(36, schemecode);
			prst.setString(37, vtalukacode);
			prst.setString(38, vtalukaname);
			prst.setString(39, vtotalland);
			prst.setString(40, vdistcode);
			prst.setString(41, vdistname);
			prst.setString(42,  vname);
			prst.setString(43,  applyforpromo);
			prst.setString(44,  applydate);
  			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBStatus = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBStatus = "Sucess";
				con1.commit();
				new General().msg("Data Saved Sucessfully ..");
			}
			prst.executeBatch(); // insert remaining records
			con1.commit();
			new General().msg("Data Saved Sucessfully ..");
		} catch (SQLException e) {
			new General().msg(e.getLocalizedMessage());
			con1.rollback();
			DBStatus = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con1 != null) {
				con1.close();
				String btnType= "N" ;
  			}
		}
	}

	
	
	
	
	
	
	
	
	public void getBoth(String sname) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "call Tb_getbothsuplCustomer('" + sname + "' , " + vcomp + ")";
		new gnTable().RemoveTableRows(smodel);
		String col[] = { "Type", "Code", "Name", "Mobile", "Email", "Cr.Days", "State", "Name", "Reg.Dlr", "Supplier" };
		smodel.setColumnIdentifiers(col);
		String type = "Party";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col, 9, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		// DefaultCellEditor nk = new gnTable().cellEdit2(stable) ;
		// nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select Data ", 850, 300);
		Selectrow();
	}

	public void getPOSCustomer(String sname) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "call  Tb_getAllPOSCustomer('" + sname + "' , " + vcomp + ")";
		new gnTable().RemoveTableRows(smodel);
		smodel.setColumnIdentifiers(SCol);
		String type = "Customer";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 9, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		// DefaultCellEditor nk = new gnTable().cellEdit2(stable) ;
		// nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select Data ", 850, 300);
		Selectrow();
	}

	public String checkVendorSelected(JTextField vendorname) {
		String status = "Sucess";
		if (vendorname.getText().length() == 0) {
			new General().msg("No vendor is selected, Select Vendor ");
			status = "Fail";
		}
		return status;
	}

	public String getCustomerDue(String vcust) throws Throwable {
		String vdueamount = "";
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call   ws_getCustomerduePayment(" + vcomp + ", " + vstore + ", '" + vcust + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vdueamount = rs.getString(1);
		} else {
			vdueamount = "0.00";
		}
		return vdueamount;

	}

	public void getCustomer(String sname) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "call  Tb_getAllCustomer('" + sname + "' , " + vcomp + ")";
		new gnTable().RemoveTableRows(smodel);
		stable.setModel(smodel);
		smodel.setColumnIdentifiers(SCol);
		String type = "Customer";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 9, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		// DefaultCellEditor nk = new gnTable().cellEdit2(stable) ;
		// nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		Selectrow();
		// new General().msgsearch(sjsp, stable, "Select Data ", 850, 300);
	}

	
	
	public JTable getSupplierintable(String sname) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "call  Tb_getAllSupplier('" + sname + "' , " + vcomp + ")";
		new gnTable().RemoveTableRows(smodel);
		stable.setModel(smodel);
		smodel.setColumnIdentifiers(SCol);
		String type = "Vendor";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 9, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
        stable.grabFocus();
		return stable ;
	}

	
	
	public void getSupplier(String sname) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "call  Tb_getAllSupplier('" + sname + "' , " + vcomp + ")";
		new gnTable().RemoveTableRows(smodel);
		stable.setModel(smodel);
		smodel.setColumnIdentifiers(SCol);
		String type = "Vendor";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 9, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		// DefaultCellEditor nk = new gnTable().cellEdit2(stable) ;
		// nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		// Selectrow(stable,sjsp) ;
		// new General().msgsearch(sjsp, stable, "Select Data ", 950, 300);
		sjsp.setRequestFocusEnabled(true);
		stable.setFocusable(true);
		sjsp.setFocusable(true);
		stable.editCellAt(1, 2);
		Selectrow();
	}

	public void getSupplierNew(String sname, JTextField vcode, JTextField vname) throws Throwable {
		vmycode = vcode;
		vmyname = vname;
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "call  Tb_getAllSupplier('" + sname + "' , " + vcomp + ")";
		new gnTable().RemoveTableRows(smodel);
		stable.setModel(smodel);
		smodel.setColumnIdentifiers(SCol);
		String type = "Vendor";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 9, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		// DefaultCellEditor nk = new gnTable().cellEdit2(stable) ;
		// nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		// Selectrow(stable,sjsp) ;
		// new General().msgsearch(sjsp, stable, "Select Data ", 950, 300);
		sjsp.setRequestFocusEnabled(true);
		stable.setFocusable(true);
		sjsp.setFocusable(true);
		stable.editCellAt(1, 2);
		SelectrowNew();
	}

	public void SelectrowNew() {
		stable.setRequestFocusEnabled(true);
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = stable.getSelectedRow();
				String value = (String) stable.getValueAt(row, 0);
				try {
					dispalyinfo(value, row);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDisposeNew();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearchNew(sjsp, stable, "Select Data", 950, 300);
	}

	// 4

	public void Selectrow() {
		stable.setRequestFocusEnabled(true);
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = stable.getSelectedRow();
				String value = (String) stable.getValueAt(row, 0);
				try {
					dispalyinfo(value, row);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Data", 950, 300);
	}

	//

	public CellEditorListener ChangeNotification3 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = stable.getSelectedRow();
			String value = (String) stable.getValueAt(row, 0);
			try {
				dispalyinfo(value, row); // showCustData();
				new General().msgDispose();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	private void dispalyinfo(String value, int row) throws Throwable {
		switch (value) {
		case "Vendor":
			rvendorcode = (stable.getValueAt(row, 1).toString());
			rvendorName = (stable.getValueAt(row, 2).toString());
			// vmycode.setText(stable.getValueAt(row,1).toString());
			// vmyname.setText(stable.getValueAt(row,2).toString());
			rcustcode = (stable.getValueAt(row, 1).toString());
			rcustName = (stable.getValueAt(row, 2).toString());
			rPhone = (stable.getValueAt(row, 3).toString());
			rEmail = (stable.getValueAt(row, 4).toString());
			rcrdays = (stable.getValueAt(row, 5).toString());
			rstatecode = (stable.getValueAt(row, 7).toString());
			rstatename = (stable.getValueAt(row, 8).toString());
			rregdlr = (stable.getValueAt(row, 9).toString());
			new gnTable().RemoveTableRows(smodel);
			break;

		case "Customer":
			rcustcode = (stable.getValueAt(row, 1).toString());
			rcustName = (stable.getValueAt(row, 2).toString());
			rvendorcode = (stable.getValueAt(row, 1).toString());
			rvendorName = (stable.getValueAt(row, 2).toString());
			rPhone = (stable.getValueAt(row, 3).toString());
			rEmail = (stable.getValueAt(row, 4).toString());
			rcrdays = (stable.getValueAt(row, 5).toString());
			rstatecode = (stable.getValueAt(row, 7).toString());
			rstatename = (stable.getValueAt(row, 8).toString());
			rregdlr = (stable.getValueAt(row, 9).toString());
			new gnTable().RemoveTableRows(smodel);
			break;

		case "Party":
			rcustcode = (stable.getValueAt(row, 1).toString());
			rcustName = (stable.getValueAt(row, 2).toString());
			rvendorcode = (stable.getValueAt(row, 1).toString());
			rvendorName = (stable.getValueAt(row, 2).toString());
			rEmail = (stable.getValueAt(row, 4).toString());
			rPhone = (stable.getValueAt(row, 3).toString());
			rcrdays = (stable.getValueAt(row, 5).toString());
			rstatecode = (stable.getValueAt(row, 6).toString());
			rstatename = (stable.getValueAt(row, 7).toString());
			rregdlr = (stable.getValueAt(row, 8).toString());
			new gnTable().RemoveTableRows(smodel);
			break;

		}
	}

	public void setScanSupplier(JTextField vendor, JTextField setName, String vscancode) throws Throwable {
		vendorcode = vendor;
		vendorName = setName;
		String vcomp = new gnConfig().getCompanyCode();
		String vendorQuery = "Call  getScanSupplier(" + vscancode + " , " + vcomp + ")";
		// new General().msg(vendorQuery);
		rs = this.getSPResult(vendorQuery);
		if (rs.next()) {
			vendorcode.setText(rs.getString(1));
			vendorName.setText(rs.getString(2));
			rvendorcode = rs.getString(1);
			rvendorName = rs.getString(2);
			rEmail = rs.getString(4);
			rPhone = rs.getString(3);
			rcrdays = rs.getString(5);
			rstatecode = rs.getString(7);
			rstatename = rs.getString(8);
			rregdlr = rs.getString(9);
		} else {
			new General().msg("No Record Found ..");
		}
	}

	public void setScanCustomer(JTextField custcode, JTextField setName, String vscancode) throws Throwable {
		vendorcode = custcode;
		vendorName = setName;
		String vcomp = new gnConfig().getCompanyCode();
		String vendorQuery = "Call  getScanCustomer(" + vscancode + " , " + vcomp + ")";
		rs = this.getSPResult(vendorQuery);
		if (rs.next()) {
			vendorcode.setText(rs.getString(1));
			vendorName.setText(rs.getString(2));
			rcustcode = rs.getString(1);
			rcustName = rs.getString(2);
			rEmail = rs.getString(4);
			rPhone = rs.getString(3);
			rcrdays = rs.getString(5);
		} else {
			new General().msg("No Record Found ..");
		}
	}

	public String getpartyOpeningBal(String vpartycode) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "Call   led_getPatyinitialOpening(" + vcomp + ", " + vpartycode + ")";
		String vopbal = "";
		String vdrcr;
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vopbal = rs.getString(1);
		} else {
			new General().msg("No Record Found ..");
		}
		return vopbal;
	}

	public String getpartyOpeningDrcr(String vpartycode) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "Call   led_getPatyinitialOpening(" + vcomp + ", " + vpartycode + ")";
		String vopbal = "";
		String vdrcr = "";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vdrcr = rs.getString(2);
		} else {
			new General().msg("No Record Found ..");
		}
		return vdrcr;
	}
	
	
	
	
	public void updateCustDataForMonthPromo(String vcode1 , String vname, String vmobile , String vaddr1 , String vaddr2, String puramt) throws Throwable 
	{
		String SQL = "update ms_customer_master set name = '"+vname+"' ,  mobile = '"+vmobile+"' , "
				+ "addr1 = '"+vaddr1+"' , addr2 = '"+vaddr2+"' , permonthpuramt = '"+puramt+"'   where  "
				+ "  company_code =  '"+vcomp+"'  and  code  = '"+vcode1+"' " ;
		this.getResult(SQL);
		new General().msg("Data Updated => Sucess .. ");
	}
 
	
	
	
	public void SaveCustDataForMonthPromo(String vcode1 , String vname, String vmobile , String vaddr1 , String vaddr2, String puramt) throws Throwable {
  		String schemecode = "0" ;
		String status1 = "Sucess";
		boolean vdelear = false;
		int vcode = Integer.parseInt(vcode1);
		String vregDelear = "N";
		if (vdelear) {
			vregDelear = "Y";
		}

		//String vSchemetype = (String) scheme.getSelectedItem();
		String vSchemetype = "0" ;
		switch (vSchemetype) {
		case "No Tax":
			schemecode = "0";
			break;
		case "Composition":
			schemecode = "1";
			break;
		case "Regular":
			schemecode = "2";
			break;
		}
 		String viscustomer = "Y";
		String vsuplyType =  "0";
 		String vaddr3 = "";
		String vaddr4 = "";
		String vcitycode = "0";
		String vcityname = "0";
		String vstatecode = "0";
		String vstatename = "0";
		String vtel = vmobile;

		String vtotalland = "0";
 
		String vtalukacode = "0";
		String vtalukaname = "0";

		String vdistcode = "0";
		String vdistname = "0";

 		String vmobile2 = "0";
		String vpincode = "0";
		String vemail = "0";
		String vclasscode =  "0";
		String vclassname =  "0";
		String vtypecode =  "0";
		String vtypename =  "0";
		String vgroupcode =  "0";
		String vgroupname =  "0";
		String vtinno = "0";
		String DBStatus = "Sucess" ;
		String vcontactperson = "0";
		int vcrdays = 0;
		String vdrcr = "N";
		String vopbal = "0";
		if (vopbal.length() == 0) {
			vopbal = "0";
		}
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
 		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String poshdr = "Insert into ms_customer_master(Code, " + "Name, Gender , Addr1 , Addr2 , Addr3 , Addr4 , "
				+ "city , city_name , state , state_name , " + " tel , mobile , mobile1 , pincode , Email ,"
				+ "IsSupplier , creditDays, contact_person ," + " GSTNO , cust_class , class_name ,"
				+ " cust_type, Type_name , cust_group,  group_name ,"
				+ " Supplier_type , company_code, Site_code, verticle,  fssaino, reg_delear ,  gstdate, opbal, drcr, scheme,"
				+ "  talukacode , talukaname, totalland , distcode , distname , alternatename, permonthpuramt)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con1.prepareStatement(poshdr);
			prst.setInt(1, vcode);
			prst.setString(2, vname);
			prst.setString(3, "M");
			prst.setString(4, vaddr1);
			prst.setString(5, vaddr2);
			prst.setString(6, vaddr3);
			prst.setString(7, vaddr4);
			prst.setString(8, vcitycode);
			prst.setString(9, vcityname);
			prst.setString(10, vstatecode);
			prst.setString(11, vstatename);
			prst.setString(12, vtel);
			prst.setString(13, vmobile);
			prst.setString(14, vmobile2);
			prst.setString(15, vpincode);
			prst.setString(16, vemail);
			prst.setString(17, viscustomer);
			prst.setInt(18, vcrdays);
			prst.setString(19, vcontactperson);
			prst.setString(20, vtinno);
			prst.setString(21, vclasscode);
			prst.setString(22, vclassname);
			prst.setString(23, vtypecode);
			prst.setString(24, vtypename);
			prst.setString(25, vgroupcode);
			prst.setString(26, vgroupname);
			prst.setString(27, vsuplyType);
			prst.setString(28, vcomp);
			prst.setString(29, vstore);
			prst.setString(30, new gnHierarchy().getVerticleCode());
			prst.setString(31, "0");
			prst.setString(32, "N");
			prst.setString(33,  "0000.00.00");
			prst.setString(34, vopbal);
			prst.setString(35, vdrcr);
			prst.setString(36, schemecode);
			prst.setString(37, vtalukacode);
			prst.setString(38, vtalukaname);
			prst.setString(39, vtotalland);
			prst.setString(40, vdistcode);
			prst.setString(41, vdistname);
			prst.setString(42,  vname);
			prst.setString(43,  puramt);
 			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBStatus = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBStatus = "Sucess";
				con1.commit();
				new General().msg("Data Saved Sucessfully ..");
			}
			prst.executeBatch(); // insert remaining records
			con1.commit();
			new General().msg("Data Saved Sucessfully ..");
		} catch (SQLException e) {
			new General().msg(e.getLocalizedMessage());
			con1.rollback();
			DBStatus = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con1 != null) {
				con1.close();
				String btnType= "N" ;
  			}
		}
	}

	
	
public String isCustomerApplyforMonthlyPromo(String vcode) throws ClassNotFoundException, SQLException
{
	
	String isApply = "N" ;
	
	String SQL = "Select applyMonthlyPromo , promoStartDate , permonthpuramt from ms_customer_master where "
			+ " compnay_code = "+vcomp+"  and code = "+vcode+" " ;
    
	rs = this.getSPResult(SQL);
	if (rs.next())
	{
		isApply = rs.getString(1) ;
		
	}
	
	return isApply ;
}
	

public String getCustomerMonthlyPromoStartdate(String vcode) throws ClassNotFoundException, SQLException
{

	String vcustpromostartdate ="";
	
	String SQL = "Select applyMonthlyPromo , promoStartDate , permonthpuramt from ms_customer_master where "
			+ " compnay_code = "+vcomp+"  and code = "+vcode+" " ;

	rs = this.getSPResult(SQL);
	if (rs.next())
	{
		vcustpromostartdate = rs.getString(2) ;
	}

	return vcustpromostartdate;
}


public String getCustomerMonthlypurAmount(String vcode) throws ClassNotFoundException, SQLException
{

	String vamount = "0" ;
	
	String SQL = "Select applyMonthlyPromo , promoStartDate , permonthpuramt from ms_customer_master where "
			+ " compnay_code = "+vcomp+"  and code = "+vcode+" " ;

	rs = this.getSPResult(SQL);
	if (rs.next())
	{
		vamount = rs.getString(3) ;
		
	}
		
	
	return vamount ;
}



}// last

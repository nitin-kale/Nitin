package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class gnVoucher extends getResultSet {

	public static String rglcode;
	public static String rgroupcode;
	public static String rglname;
	public static String rgroupname;
	public static String rtaxper;

	public static String vdocno;
	public static String vdocdate;
	public static String vpaymentMode;
	public static String vinstrno;
	public static String vinstrdate;
	public static String vamount;

	public static String vbankcode;
	public static String vbankname;

	public static String vothbankcode;
	public static String vothbankname = "";

	public static String vtrtype;

	private String col[] = { "Type", "Gl code", "Gl Name", "Drcr", "Group code", "Group Name", "Taxper" };
	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public JScrollPane sjsp = new JScrollPane();
	String vcomp;
	String vtype;
	String SQL;

	public void getBankandCash() throws ClassNotFoundException, SQLException {
		String vgroup = "12";
		SQL = "call  account_getbankandcash()";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col, 5, "N", "Y", vtype);
		new gnTable().setTableColWidth(stable, 2, 300);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, col);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select Bank <Click on row to
		// select Record>", 700, 200);
		Selectrow();
	}

	public void getBank() throws ClassNotFoundException, SQLException {
		String vgroup = "12";
		SQL = "call  account_getGlHelp(" + vgroup + ")";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col, 5, "N", "Y", vtype);
		new gnTable().setTableColWidth(stable, 2, 300);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, col);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select Bank <Click on row to
		// select Record>", 700, 200);
		Selectrow();
	}

	public void getCash() throws ClassNotFoundException, SQLException {
		String vgroup = "14";
		SQL = "call  account_getGlHelp(" + vgroup + ")";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col, 5, "N", "Y", vtype);
		new gnTable().setTableColWidth(stable, 2, 300);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, col);
		sjsp.setViewport(prt6);
		Selectrow();
	}

	public void Selectrow() {

		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = stable.getSelectedRow();
				String value = (String) stable.getValueAt(row, 0);
				try {
					dispalyinfo(value, row); // showCustData();
					new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Data ", 900, 300);
	}

	private void dispalyinfo(String value, int row) {

		// {"Type" , "Gl code", "Gl Name", "Drcr" , "Group code" , "Group Name"
		// , "Taxper"} ;
		rglcode = stable.getValueAt(row, 1).toString();
		rglname = stable.getValueAt(row, 2).toString();
		rgroupcode = stable.getValueAt(row, 4).toString();
		rgroupname = stable.getValueAt(row, 5).toString();
		rtaxper = stable.getValueAt(row, 6).toString();
	}

	public void otherItemsForExpenses() {

	}

	public void ShowVouchers(String vtype, String vparty) throws Throwable {
		String col[] = { "Voucher", "Doc.No", "Doc.Date", "Mode", "Instrumentno", "Inst.Date", "Amount" };
		vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "";
		new gnTable().RemoveTableRows(smodel);

		switch (vtype) {
		case "PV":
			smodel.setColumnIdentifiers(col);
			SQL = "call voucher_viewData('" + vtype + "', " + vcomp + ", " + vstore + ", " + vparty + ")";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col, 6, "N", "Y", vtype);
			stable.setModel(smodel);
			SelectvoucherRow();
			break;
		case "RV":
			smodel.setColumnIdentifiers(col);
			SQL = "call voucher_viewData('" + vtype + "', " + vcomp + ", " + vstore + ", " + vparty + ")";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col, 6, "N", "Y", vtype);
			stable.setModel(smodel);
			SelectvoucherRow();
			break;

		case "EX":
			smodel.setColumnIdentifiers(col);
			SQL = "call voucher_viewData('" + vtype + "', " + vcomp + ", " + vstore + ", " + vparty + ")";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col, 6, "N", "Y", vtype);
			stable.setModel(smodel);
			SelectvoucherRow();
			break;

		case "IN":
			smodel.setColumnIdentifiers(col);
			SQL = "call voucher_viewData('" + vtype + "', " + vcomp + ", " + vstore + ", " + vparty + ")";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col, 6, "N", "Y", vtype);
			stable.setModel(smodel);
			SelectvoucherRow();
			break;

		case "CON":
			String colCON[] = { "Voucher", "Doc.No", "Doc.Date", "TrType", "BankCode", "Bank Name", "Mode",
					"Instrumentno", "Inst.Date", "Amount", "OtherBank", "Name" };
			smodel.setColumnIdentifiers(colCON);
			SQL = "call voucher_viewData('" + vtype + "', " + vcomp + ", " + vstore + " , '" + vparty + "')";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, colCON, 10, "N", "Y", vtype);
			stable.setModel(smodel);
			SelectBankRow();
			break;
		}
	}

	private void SelectBankRow() {
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = stable.getSelectedRow();
				String value = (String) stable.getValueAt(row, 0);
				try {
					// String colCON[] = {"Voucher", 1"Doc.No" , 2"Doc.Date" , 3
					// "TrType" , 4"BankCode", 5"Bank Name" ,
					// 6"Mode" ,7"Instrumentno" , 8"Inst.Date" , 9"Amount" ,
					// 10"OtherBank" , 11"Name" } ;

					vdocno = stable.getValueAt(row, 1).toString();
					vdocdate = stable.getValueAt(row, 2).toString();
					vtrtype = stable.getValueAt(row, 3).toString();

					vbankcode = stable.getValueAt(row, 4).toString();
					vbankname = stable.getValueAt(row, 5).toString();
					vpaymentMode = stable.getValueAt(row, 6).toString();
					vinstrno = stable.getValueAt(row, 7).toString();
					vinstrdate = stable.getValueAt(row, 8).toString();
					vamount = stable.getValueAt(row, 9).toString();
					vothbankcode = stable.getValueAt(row, 10).toString();
					if (stable.getValueAt(row, 11).toString().length() > 1) {
						vothbankname = stable.getValueAt(row, 11).toString();
					}

					new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Data ", 900, 300);
	}

	private void SelectvoucherRow() {
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = stable.getSelectedRow();
				String value = (String) stable.getValueAt(row, 0);
				try {
					vdocno = stable.getValueAt(row, 1).toString();
					vdocdate = stable.getValueAt(row, 2).toString();
					// "Doc.No" , "Doc.Date" , "Mode" , "Instrumentno" ,
					// "Inst.Date" , "Amount"
					vpaymentMode = stable.getValueAt(row, 3).toString();
					vinstrno = stable.getValueAt(row, 4).toString();
					vinstrdate = stable.getValueAt(row, 5).toString();
					vamount = stable.getValueAt(row, 6).toString();
					new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Data ", 900, 300);
	}

	public void editPVRVvoucherData(String vdoctype, String vparty, String vvdocno, String vvdocdate) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		String SQL = " call N_vouEdtdocno('" + vdoctype + "'  ,  '" + vparty + "'  ," + vcomp + " , " + vstore + "  , '"
				+ vdocdate + "' , " + vvdocno + " )";
		new General().msg(SQL);
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {

			vdocno = rs.getString(1);
			vdocdate = rs.getString(2);
			// "Doc.No" , "Doc.Date" , "Mode" , "Instrumentno" , "Inst.Date" ,
			// "Amount , glcode, glname, "
			vpaymentMode = rs.getString(3);
			vinstrno = rs.getString(4);
			vinstrdate = rs.getString(5);
			vamount = rs.getString(6);
			rglcode = rs.getString(7);
			rglname = rs.getString(8);
		}
	}

	public void editCONvoucherData(String vdoctype, String vparty, String vvdocno, String vvdocdate) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		String SQL = " call N_vouEdtdocno('" + vdoctype + "'  ,  '" + vparty + "'  ," + vcomp + " , " + vstore + "  , '"
				+ vdocdate + "' , " + vvdocno + " )";
		rs = this.getSPResult(SQL);
		while (rs.next()) {

			vdocno = rs.getString(1);
			vdocdate = rs.getString(2);
			vtrtype = rs.getString(3);

			vbankcode = rs.getString(4);
			vbankname = rs.getString(5);
			vpaymentMode = rs.getString(6);
			vinstrno = rs.getString(7);
			vinstrdate = rs.getString(8);
			vamount = rs.getString(9);
			vothbankcode = rs.getString(10);
			if (rs.getString(11).length() > 1) {
				vothbankname = rs.getString(11);
			}

		}
	}

}// Last

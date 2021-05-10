package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class VoucherEntryModule extends getResultSet {

	JFrame voucherEntryFrame;
	private JTextField tdate;
	int vchoice;
	private JTextField vouchertype;
	private JTextField voucherno;
	private JTextField account;
	JComboBox mode;

	private String col[] = { "Type", "Gl code", "Gl Name", "Group code", "Group Name", "Taxper", "Amount" };

	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 1 || column == 3 || column == 4 || column == 5 ? false : true;
		}
	};

	public JTable table = new JTable();
	public JTable stable = new JTable();
	public DefaultTableModel smodel = new DefaultTableModel();

	String vcomp;
	String vstore;

	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JPanel rpanel;
	JPanel lpanel;
	JScrollPane jsp;
	JPanel bankpanel;
	JPanel helppanel;
	JButton btnSave;
	JButton btnView;
	JButton btnClose;

	String vcrglcode;
	String vcrglname;
	String vcrgrpcode;
	String vcrgpname;
	String vcrsubgrpcode;
	String vcrsubgrpname;
	String vtaxcode;
	String vamount;
	String vcrtype = "Cr";

	String vdrglcode;
	String vdrglname;
	String vdrgrpcode;
	String vdrgpname;
	String vdrsubgrpcode;
	String vdrsubgrpname;
	String vdrtype = "Dr";

	String vmode;
	String vinstrumentno;
	String vinstrumentdate;
	String vdocno;
	String vdoctype;

	JInternalFrame internalFrame;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField instrumentno;
	private JTextField instrumentdate;
	private JTextField glcode;
	private JTextField groupcode;
	private String vglname;
	private String vgroupname;
	private String vglcode;
	private String vgroupcode;
	int Trow;
	private JScrollPane jsp1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VoucherEntryModule window = new VoucherEntryModule();
					window.voucherEntryFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Throwable
	 */
	public VoucherEntryModule() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		voucherEntryFrame = new JFrame();
		voucherEntryFrame.setAlwaysOnTop(true);
		voucherEntryFrame.setBounds(1, 1, 1350, 750);
		voucherEntryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		voucherEntryFrame.getContentPane().setLayout(null);

		internalFrame = new JInternalFrame("");
		internalFrame.setBounds(0, 0, 1332, 705);
		voucherEntryFrame.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setBounds(32, 12, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel);

		tdate = new JTextField();
		tdate.setBounds(69, 8, 116, 24);
		internalFrame.getContentPane().add(tdate);
		tdate.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Vou.Type");
		lblNewLabel_1.setBounds(12, 35, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel_1);

		vouchertype = new JTextField();
		vouchertype.setFont(new Font("Calibri", Font.BOLD, 14));
		vouchertype.setForeground(new Color(0, 0, 102));
		vouchertype.setEditable(false);
		vouchertype.setBackground(Color.CYAN);
		vouchertype.setBounds(69, 33, 116, 27);
		internalFrame.getContentPane().add(vouchertype);
		vouchertype.setColumns(10);

		voucherno = new JTextField();
		voucherno.setFont(new Font("Calibri", Font.BOLD, 14));
		voucherno.setForeground(new Color(0, 0, 102));
		voucherno.setEditable(false);
		voucherno.setBackground(Color.CYAN);
		voucherno.setBounds(229, 32, 116, 27);
		internalFrame.getContentPane().add(voucherno);
		voucherno.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Vou.No");
		lblNewLabel_2.setBounds(184, 35, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel_2);

		JPanel lpanel = new JPanel();
		lpanel.setBorder(new TitledBorder(null, "Select Voucher", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 102)));
		lpanel.setBackground(Color.WHITE);
		lpanel.setBounds(0, 102, 158, 391);
		internalFrame.getContentPane().add(lpanel);
		lpanel.setLayout(null);

		btn1 = new JButton("Contra voucher") {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		btn1.setMnemonic('C');
		btn1.setBounds(12, 27, 134, 25);
		lpanel.add(btn1);

		btn2 = new JButton("Payment Voucher");
		btn2.setMnemonic('P');
		btn2.setBounds(12, 52, 134, 25);
		lpanel.add(btn2);

		btn3 = new JButton("Receipt Voucher");
		btn3.setMnemonic('R');
		btn3.setBounds(12, 78, 134, 25);
		lpanel.add(btn3);

		btn4 = new JButton("Other Purchase");
		btn4.setMnemonic('O');
		btn4.setBounds(12, 103, 134, 25);
		lpanel.add(btn4);

		btn5 = new JButton("Create Pur.Item");
		btn5.setMnemonic('I');
		btn5.setBounds(12, 130, 134, 25);
		lpanel.add(btn5);

		rpanel = new JPanel();
		rpanel.setBackground(Color.CYAN);
		rpanel.setBounds(156, 104, 893, 389);
		internalFrame.getContentPane().add(rpanel);
		rpanel.setLayout(null);

		jsp = new JScrollPane();
		jsp.setBounds(12, 13, 869, 255);
		rpanel.add(jsp);

		bankpanel = new JPanel();
		bankpanel.setBackground(Color.WHITE);
		bankpanel.setBounds(12, 268, 869, 108);
		rpanel.add(bankpanel);
		bankpanel.setLayout(null);

		lblNewLabel_4 = new JLabel("Mode");
		lblNewLabel_4.setBounds(12, 13, 56, 16);
		bankpanel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Instrument No");
		lblNewLabel_5.setBounds(117, 13, 101, 16);
		bankpanel.add(lblNewLabel_5);

		instrumentno = new JTextField();
		instrumentno.setBounds(102, 42, 116, 22);
		bankpanel.add(instrumentno);
		instrumentno.setColumns(10);

		mode = new JComboBox();
		mode.setModel(new DefaultComboBoxModel(new String[] { "Cheque", "DD", "NEFT", "RTGS" }));
		mode.setBounds(12, 42, 78, 22);
		bankpanel.add(mode);

		JLabel lblNewLabel_6 = new JLabel("Instrument Date");
		lblNewLabel_6.setBounds(266, 13, 107, 16);
		bankpanel.add(lblNewLabel_6);

		instrumentdate = new JTextField();
		instrumentdate.setBounds(257, 42, 116, 22);
		bankpanel.add(instrumentdate);
		instrumentdate.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Account");
		lblNewLabel_3.setBounds(102, 73, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel_3);

		account = new JTextField();
		account.setBounds(160, 67, 282, 34);
		internalFrame.getContentPane().add(account);
		account.setColumns(10);

		helppanel = new JPanel();
		helppanel.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 51, 0)));
		helppanel.setBackground(Color.CYAN);
		helppanel.setBounds(155, 491, 894, 167);
		internalFrame.getContentPane().add(helppanel);
		helppanel.setLayout(null);

		jsp1 = new JScrollPane();
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(12, 13, 870, 141);
		helppanel.add(jsp1);

		btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(737, 76, 97, 25);
		internalFrame.getContentPane().add(btnSave);

		btnView = new JButton("View");
		btnView.setMnemonic('V');
		btnView.setBounds(844, 76, 97, 25);
		internalFrame.getContentPane().add(btnView);

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(952, 76, 97, 25);
		internalFrame.getContentPane().add(btnClose);

		glcode = new JTextField();
		glcode.setForeground(new Color(0, 0, 153));
		glcode.setEditable(false);
		glcode.setBounds(442, 67, 64, 34);
		internalFrame.getContentPane().add(glcode);
		glcode.setColumns(10);

		groupcode = new JTextField();
		groupcode.setForeground(new Color(0, 0, 153));
		groupcode.setEditable(false);
		groupcode.setBounds(507, 67, 48, 34);
		internalFrame.getContentPane().add(groupcode);
		groupcode.setColumns(10);
		internalFrame.setVisible(true);
		ActionListener btnlsn = new btnLsnr();
		ActionListener acclsnr = new accountLsnr();
		account.addActionListener(acclsnr);
		btn1.addActionListener(btnlsn);
		btn2.addActionListener(btnlsn);
		btn3.addActionListener(btnlsn);
		btn4.addActionListener(btnlsn);
		btn5.addActionListener(btnlsn);
		btnSave.addActionListener(btnlsn);
		btnClose.addActionListener(btnlsn);
		btnView.addActionListener(btnlsn);
		decorate();
	}

	private void decorate() throws Throwable {
		bankpanel.setVisible(false);
		helppanel.setVisible(false);
		new gnApp().setCompanyTitle(internalFrame);
		new gnApp().setFrameTitel(voucherEntryFrame);
		delTableRow(table, model, "POS");

	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Contra voucher") {
				vchoice = 1;
				try {
					refresh();
					headerSetting();
					account.grabFocus();
					// ProcessAccountAction();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			if (value == "Payment Voucher") {
				vchoice = 2;
				try {
					refresh();
					headerSetting();
					account.grabFocus();
					// ProcessAccountAction();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Receipt Voucher") {
				vchoice = 3;
				try {
					refresh();
					headerSetting();
					account.grabFocus();
					// ProcessAccountAction();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			if (value == "Other Purchase") {
				vchoice = 4;
				try {
					refresh();
					headerSetting();
					account.grabFocus();
					// ProcessAccountAction();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			if (value == "Create Pur.Item") {
				vchoice = 5;
				refresh();
				Ceateitem();
			}

			if (value == "Save") {
				callSave();
			}

			if (value == "Close") {
				voucherEntryFrame.dispose();
			}

			if (value == "View") {
				Callview();
			}
		}
	}

	/// ===========================
	class accountLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e1) {

			int value = e1.getID();
			if (value == 1001) {
				try {
					ProcessAccountAction();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void ProcessAccountAction() throws Throwable {
		switch (vchoice) {
		case 1: // Contra
			ContraAction();
			break;

		case 2: // Payment Voucher
			PVaction();
			break;

		case 3: // Receipt Vocuher
			RVaction();
			break;

		case 4: // Other Purchase
			PurAction();
			break;
		}
	}

	private void PVaction() throws ClassNotFoundException, SQLException {
		new gnVoucher().getBankandCash();
		setSelectValue();
		checkGroupforBank();
		new gnTable().RemoveTableRows(model);
		Addrow("PV");
		Selectrowmain();
	}

	private void RVaction() throws ClassNotFoundException, SQLException {

		new gnVoucher().getBankandCash();
		setSelectValue();
		checkGroupforBank();
		new gnTable().RemoveTableRows(model);
		Addrow("RV");
		Selectrowmain();
	}

	private void ContraAction() throws ClassNotFoundException, SQLException {

		new gnVoucher().getBankandCash();
		setSelectValue();
		checkGroupforBank();
		new gnTable().RemoveTableRows(model);
		Addrow("Contra");
		Selectrowmain();

	}

	private void PurAction() throws Throwable {

		String sname = "";
		new gnSupplier().getSupplier(sname);
		account.setText(new gnSupplier().rcustName);
		glcode.setText(new gnSupplier().rcustcode);
		groupcode.setText("20");
		vgroupname = "Sundry Debtors";
		vgroupcode = "20";
		vglcode = glcode.getText();
		vglname = account.getText();
		// checkGroupforBank() ;
		new gnTable().RemoveTableRows(model);
		Addrow("Purchase");
		Selectrowmain();
	}

	/// End ProcessAcccount Action

	// ==============================
	private void callSave() {
		switch (vchoice) {
		case 1:
			break;

		case 2:
			/*
			 * vdocno ; vdoctype ; vmode ; vinstrumentno ; vinstrumentdate ;
			 * 
			 * vcrglcode vcrglname vcrgrpcode vcrgpname vcrsubgrpcode
			 * vcrsubgrpname vtaxcode vamount = table.getValueAt(0, 6) ; vcrtype
			 * = "Cr" ;
			 * 
			 * vdrglcode = vdrglname vdrgrpcode vdrgpname vdrsubgrpcode
			 * vdrsubgrpname vdrtype = "Dr" ;
			 */
			break;

		}

	}

	private void Callview() {

	}

	private void Ceateitem() {

	}

	// ===========

	private void checkGroupforBank() {
		String vgroup = groupcode.getText();
		switch (vgroup) {
		case "12":
			bankpanel.setVisible(true);
		}
	}

	public void Selectrowmain() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				Trow = table.getSelectedRow();
				String vname = table.getValueAt(Trow, 2).toString();
				vname = "%" + vname + "%";
				String SQL = "";
				try {
					switch (vchoice) {
					case 1:
						SQL = "Call  account_getGLinfo1('" + vname + "')";
						showGl(SQL);
						break;

					case 2:
						SQL = "Call  account_getGLinfo1('" + vname + "')";
						showGl(SQL);
						break;

					case 3:
						SQL = "Call  account_getGLinfo1('" + vname + "')";
						showGl(SQL);
						break;

					case 4:
						SQL = "Call  account_getGLinfo1('" + vname + "')";
						showGl(SQL);
						break;

					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
	}

	/// Voucher Gl Search
	private void showGl(String vname) throws ClassNotFoundException, SQLException {
		smodel.setColumnIdentifiers(col);
		new gnTable().RemoveTableRows(smodel);
		String SQL = "Call  account_getGLinfo1('" + vname + "')";
		String col1[] = { "Glcode", "Glname", "Type", "Acc_Group", "Groupname", "Acc_subGroup", "Subgroupname",
				"Taxcode" };
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col1, 8, "N", "N", "N");
		JViewport prt6 = new JViewport();
		jsp1.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, col);
		jsp1.setViewport(prt6);
		Selectrow();
	}

	public void Selectrow() {
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
		new General().msgsearch(jsp1, stable, "Select Data ", 950, 300);
	}

	private void dispalyinfo(String value, int row) {
		table.setValueAt(stable.getValueAt(row, 0).toString(), Trow, 1);
		table.setValueAt(stable.getValueAt(row, 1).toString(), Trow, 2);
		table.setValueAt(stable.getValueAt(row, 3).toString(), Trow, 3);
		table.setValueAt(stable.getValueAt(row, 4).toString(), Trow, 4);
		table.setValueAt(stable.getValueAt(row, 7).toString(), Trow, 5);
		String vgroup = stable.getValueAt(row, 3).toString();
		switch (vgroup) {
		case "12": // Bankgrop
			bankpanel.setVisible(true);
			break;
		}
		vamount = stable.getValueAt(row, 3).toString();
		vcrglcode = stable.getValueAt(row, 1).toString();
	}
	//

	public void delTableRow(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg("Comp is "+ fld +" "+"Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "CalAction");
		imap.put(KeyStroke.getKeyStroke("VK_X"), "CalAction");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				String vtype = "";
				try {
					int row = table.getSelectedRow();
					// new General().msg("row Selected is:"+" "+row);
					model.removeRow(row);
					// removeRow(model, table) ;
					table.setEditingRow(row);
					// new gnTable().RemoveTableRows(model);
					switch (vchoice) {
					case 1:
						vtype = "Contra";
						Addrow(vtype);
						break;
					case 2:
						vtype = "PV";
						Addrow(vtype);
						break;
					case 3:
						vtype = "RV";
						Addrow(vtype);
						break;
					case 4:
						vtype = "Purchase";
						Addrow(vtype);
						break;
					}

				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void Addrow(String vtype) {
		// private String col[] = {"Type" , "Gl code", "Gl Name", "Group code" ,
		// "Group Name" , "Taxper" , "Amount"} ;
		model.addRow(new Object[] { vtype, " ", " ", " ", " ", " ", " " });
		new gnTable().setTableColWidth(table, 0, 50);
		new gnTable().setTableColWidth(table, 1, 50);
		new gnTable().setTableColWidth(table, 2, 200);
		new gnTable().setTableColWidth(table, 3, 50);
		new gnTable().setTableColWidth(table, 4, 200);
		new gnTable().setTableColWidth(table, 5, 50);
		new gnTable().setTableColWidth(table, 6, 200);
		table.requestFocusInWindow();
		// table.setRowSelectionInterval(1, 1);
		table.changeSelection(0, 2, true, true);
		// table.setRowSelectionAllowed(true);;

	}

	private void headerSetting() {
		tdate.setText(new General().getDate());

		switch (vchoice) {
		case 1:
			vouchertype.setText("Contra Voucher");
			break;
		case 2:
			vouchertype.setText("Payment Voucher");
			break;
		case 3:
			vouchertype.setText("Receipt Voucher");
			break;
		case 4:
			vouchertype.setText("Pur. Voucher");
			break;
		}
	}

	private void refresh() {
		account.setText("");
		glcode.setText("");
		groupcode.setText("");
		new gnTable().RemoveTableRows(model);
		instrumentno.setText("");
		instrumentdate.setText("");
		bankpanel.setVisible(false);
		vamount = "0";
		vcrglcode = "0";

	}

	private void setSelectValue() {
		account.setText(new gnVoucher().rglname);
		glcode.setText(new gnVoucher().rglcode);
		groupcode.setText(new gnVoucher().rgroupcode);
		vglcode = new gnVoucher().rglcode;
		vglname = new gnVoucher().rglname;
		vgroupname = new gnVoucher().rgroupname;
		vgroupcode = new gnVoucher().rgroupcode;
		new gnVoucher().rglcode = "";
		new gnVoucher().rglname = "";
		new gnVoucher().rgroupcode = "";
		new gnVoucher().rgroupname = "";
		new gnVoucher().rtaxper = "";
		model.setColumnIdentifiers(col);
		table.setModel(model);
		table.setBackground(Color.white);
		table.setForeground(Color.BLUE);
		table.setRowHeight(30);
		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.WHITE);
		prt1.add(table, col);
		prt1.setVisible(true);
		jsp.setViewport(prt1);
	}

	///

	public void getGenerlData() {

	}

	private void PVlegderEntery() throws Throwable {
		vstore = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		String vdocno = voucherno.getText();
		String vdocType1 = "PV";
		String vdocdate = new gnConfig().date_ConverttoDBforamt(tdate.getText());
		String SQL1 = "Call Led_LedgerEntry(" + vcomp + " , " + vstore + " , " + vdocno + " , '" + vdocdate + "'  ,'"
				+ vdocType1 + "' )";
		this.getSPResult(SQL1);
		try {
			postjournalEntery();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void postjournalEntery() throws Throwable {
		String vpmode = mode.getSelectedItem().toString().trim();

		if (vpmode == "Cash") {
			String vdocType1 = "PV-CASHPAY";
			String vdocdate1 = tdate.getText();
			// String vamount = vamount ;
			String vdocno = voucherno.getText();
			String vparty = "0";
			// new gnBridge().processEntryPosting(vparty , vdocType1, vdocno,
			// vdocdate1, vamount);
		}

		if (vpmode != "Cash") {
			String vdocType1 = "PV-BANKPAY";
			String vdocno = voucherno.getText();
			String vdocdate1 = tdate.getText();
			// String vamount = vamount ;
			String vparty = vcrglcode;
			// new gnBridge().processEntryPosting(vparty , vdocType1, vdocno,
			// vdocdate1, vamount);
		}
	}

	///

}// Last

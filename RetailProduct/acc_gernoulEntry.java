package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
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
import javax.swing.border.BevelBorder;
import java.awt.Font;

public class acc_gernoulEntry extends getResultSet {

	JFrame journalEntryFrame;
	private JTextField trdate;
	private JButton btnClose;
	JComboBox mode;

	String vdrgl = " ";
	String vdrglname = "";
	String vcrgl = " ";
	String vcrglname = "";
	String vdramount = "";
	String vcramount = "";

	public static String EditMode = "N";
	String vallow = "";
	private JTextField glname1;
	private JTextField glname2;
	private JTextField vouchertype;
	private JTextField seqno;
	public String vgl = "";
	private String vglcode1 = " ";
	private String vglcode2 = " ";
	private String vtrType;
	String vcomp;
	String vmode = "S";
	String vstore;
	private int Trow;
	JScrollPane jsp;
	JScrollPane sjsp;

	JInternalFrame internalFrame;
	JButton btnSave;

	JTable table = new JTable();
	DefaultTableModel smodel = new DefaultTableModel();

	JTable stable = new JTable();
	DefaultTableModel model = new DefaultTableModel();

	JTable etable = new JTable();
	DefaultTableModel emodel = new DefaultTableModel();

	String col[] = { "Code", "Name", "Type", "Group", "Group Name" };
	String entrycol[] = { "Type", "Code", "Particular", "Debit", "Credit" };
	private JButton btnAdd;
	private JTextField chqddno;
	private JTextField chqdddate;
	private JTextField Tcredit;
	private JTextField Tdebit;
	private JTextField naration;
	private JLabel lblNewLabel_4;
	private JPanel panel_1;
	private JButton btnEditIncome;
	private JPanel panel_2;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField from;
	private JTextField to;
	private JScrollPane jsp1;
	private JLabel MSG;
	private JLabel lblNewLabel_9;
	private JButton btnView;
	private JButton btnEdit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acc_gernoulEntry window = new acc_gernoulEntry();
					window.journalEntryFrame.setVisible(true);
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
	public acc_gernoulEntry() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		journalEntryFrame = new JFrame();
		journalEntryFrame.setAlwaysOnTop(true);
		journalEntryFrame.setBounds(1, 1, 1350, 750);
		journalEntryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		journalEntryFrame.getContentPane().setLayout(null);

		internalFrame = new JInternalFrame("");
		internalFrame.setBounds(1, 1, 1331, 704);
		journalEntryFrame.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 123, 653, 367);
		panel.setBackground(Color.CYAN);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		sjsp = new JScrollPane();
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(0, 6, 647, 188);
		panel.add(sjsp);

		JPanel bankPanel = new JPanel();
		bankPanel.setBackground(Color.WHITE);
		bankPanel.setBorder(new MatteBorder(3, 1, 1, 3, (Color) new Color(0, 0, 153)));
		bankPanel.setBounds(6, 298, 641, 63);
		panel.add(bankPanel);
		bankPanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setBounds(6, 6, 55, 16);
		bankPanel.add(lblNewLabel_1);

		mode = new JComboBox();
		mode.setModel(new DefaultComboBoxModel(new String[] { "Cheque", "DD", "NEFT", "RTGS" }));
		mode.setBounds(6, 34, 128, 26);
		bankPanel.add(mode);

		JLabel lblNewLabel_2 = new JLabel("Instrument No");
		lblNewLabel_2.setBounds(161, 6, 87, 16);
		bankPanel.add(lblNewLabel_2);

		chqddno = new JTextField();
		chqddno.setBounds(141, 33, 122, 28);
		bankPanel.add(chqddno);
		chqddno.setColumns(10);

		chqdddate = new JTextField();
		chqdddate.setBounds(275, 33, 122, 28);
		bankPanel.add(chqdddate);
		chqdddate.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Instrument Date");
		lblNewLabel_3.setBounds(275, 6, 122, 16);
		bankPanel.add(lblNewLabel_3);

		Tcredit = new JTextField();
		Tcredit.setBackground(Color.BLACK);
		Tcredit.setForeground(Color.WHITE);
		Tcredit.setEditable(false);
		Tcredit.setBounds(525, 190, 122, 28);
		panel.add(Tcredit);
		Tcredit.setColumns(10);

		Tdebit = new JTextField();
		Tdebit.setBackground(Color.BLACK);
		Tdebit.setForeground(Color.WHITE);
		Tdebit.setEditable(false);
		Tdebit.setBounds(398, 190, 122, 28);
		panel.add(Tdebit);
		Tdebit.setColumns(10);

		naration = new JTextField();
		naration.setBounds(18, 224, 629, 28);
		panel.add(naration);
		naration.setColumns(10);

		lblNewLabel_4 = new JLabel("Narration");
		lblNewLabel_4.setBounds(17, 206, 55, 16);
		panel.add(lblNewLabel_4);

		trdate = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		trdate.setBounds(22, 23, 93, 28);
		internalFrame.getContentPane().add(trdate);
		trdate.setColumns(10);

		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setBounds(22, 0, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel);

		btnSave = new JButton("Save");
		btnSave.setBounds(245, 502, 74, 28);
		btnSave.setMnemonic('S');
		internalFrame.getContentPane().add(btnSave);

		vouchertype = new JTextField();
		vouchertype.setBounds(19, 63, 172, 28);
		vouchertype.setEditable(false);
		internalFrame.getContentPane().add(vouchertype);
		vouchertype.setColumns(10);

		seqno = new JTextField();
		seqno.setBounds(193, 63, 44, 28);
		internalFrame.getContentPane().add(seqno);
		seqno.setColumns(10);

		btnClose = new JButton("Close");
		btnClose.setBounds(319, 502, 90, 28);
		btnClose.setMnemonic('C');
		internalFrame.getContentPane().add(btnClose);

		btnAdd = new JButton("AddRow");
		btnAdd.setBounds(556, 6, 90, 28);
		internalFrame.getContentPane().add(btnAdd);

		JLabel lblNewLabel_5 = new JLabel("Vou.No");
		lblNewLabel_5.setBounds(193, 46, 55, 16);
		internalFrame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Type");
		lblNewLabel_6.setBounds(22, 48, 55, 16);
		internalFrame.getContentPane().add(lblNewLabel_6);

		panel_1 = new JPanel();
		panel_1.setBounds(671, 6, 644, 484);
		panel_1.setBackground(Color.WHITE);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 0, 153));
		panel_2.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(0, 255, 153)));
		panel_2.setBounds(0, 0, 644, 60);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel_7 = new JLabel("From");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(25, 13, 56, 16);
		panel_2.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("To");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(186, 13, 39, 16);
		panel_2.add(lblNewLabel_8);

		from = new JTextField();
		from.setBounds(58, 10, 116, 22);
		panel_2.add(from);
		from.setColumns(10);

		to = new JTextField();
		to.setBounds(216, 10, 116, 22);
		panel_2.add(to);
		to.setColumns(10);

		jsp1 = new JScrollPane();
		jsp1.setBounds(0, 62, 644, 422);
		panel_1.add(jsp1);

		MSG = new JLabel("..");
		MSG.setBounds(174, 29, 93, 16);
		MSG.setForeground(new Color(51, 51, 102));
		MSG.setFont(new Font("Cambria", Font.BOLD, 13));
		internalFrame.getContentPane().add(MSG);

		lblNewLabel_9 = new JLabel("Journal Voucher Entry");
		lblNewLabel_9.setForeground(new Color(0, 51, 153));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setBounds(277, 0, 243, 28);
		internalFrame.getContentPane().add(lblNewLabel_9);

		btnView = new JButton("View");
		btnView.setMnemonic('V');
		btnView.setBounds(556, 95, 97, 25);
		internalFrame.getContentPane().add(btnView);

		btnEdit = new JButton("Edit Voucher");
		btnEdit.setMnemonic('E');
		btnEdit.setBounds(439, 95, 116, 25);
		// btnEdit.setVisible(false);
		internalFrame.getContentPane().add(btnEdit);

		jsp = new JScrollPane();
		jsp.setBounds(683, 63, 442, 68);

		// internalFrame.getContentPane().add(jsp);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		internalFrame.setVisible(true);

		ActionListener xtodate = new stodateLsnr();
		to.addActionListener(xtodate);
		ActionListener btnaction = new btnLsnr();
		btnView.addActionListener(btnaction);
		btnSave.addActionListener(btnaction);
		btnClose.addActionListener(btnaction);
		btnEdit.addActionListener(btnaction);
		decorate();
	}

	public void decorate() throws Throwable {
		vtrType = "JV";
		trdate.setEditable(false);
		vouchertype.setText("Journal Voucher");
		seqno.setEditable(false);
		String vpara29 = "29";
		String vEditDocumentAllow = new getConfigurationSetting().getSpecificConfiguration(vpara29);
		switch (vEditDocumentAllow) {
		case "N":
			btnEdit.setVisible(false);
		}
		vallow = new gnDate().checkDayBegin();
		switch (vallow) {
		case "Y":
			new gnApp().setFrameTitel(journalEntryFrame);
			new gnField().closeform(internalFrame, journalEntryFrame);
			vcomp = new gnConfig().getCompanycode();
			vstore = new gnConfig().getStoreID();
			panel_1.setVisible(false);
			btnAdd.setVisible(false);
			trdate.setText(new gnConfig().getDaybeginDate());
			trdate.setEditable(false);
			new gnField().closeform(internalFrame, journalEntryFrame);
			new gnStyleButton().getStyleButton(btnEdit, Color.gray, Color.WHITE);
			new gnStyleButton().getStyleButton(btnView, Color.gray, Color.WHITE);
			delTableRow(stable, smodel, "");
			setDefaultrows();
			String vtype = "JV";
			String vallowDate = new gnDate().checkBackDateTrAllow(vtype, trdate.getText());
			switch (vallowDate) {
			case "N":
				btnEdit.setVisible(false);
				trdate.setBackground(Color.RED);
				trdate.setForeground(Color.WHITE);
				new General().msg("Back Date For Transaction is not Allow..");
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				trdate.setText("?");
				journalEntryFrame.dispose();
				btnSave.setVisible(false);
				break;
			}
			break;
		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String status = "";
			if (value == "View") {
				panel_1.setVisible(true);
				try {
					from.setText(new gnFinYear().getFirstDateofFinYear());
					to.setText(new gnFinYear().getLastDateofFinYear());
					to.grabFocus();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Save") {
				try {
					status = validate();
					if (status == "Sucess") {
						switch (EditMode) {
						case "Y":
							String vvdoctype = "JV";
							String vdocno = seqno.getText();
							String vvdocdate = trdate.getText();
							new gnEDMiddleWare().JVVoucherModification(vvdoctype, vdocno, vvdocdate);
							SaveData();
							break;
						case "N":
							SaveData();
							break;
						}
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Edit Voucher") {
				EditMode = "Y";
				panel_1.setVisible(true);
				try {
					from.setText(new gnFinYear().getFirstDateofFinYear());
					to.setText(new gnFinYear().getLastDateofFinYear());
					to.grabFocus();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Close") {
				journalEntryFrame.dispose();
			}

		}
	}

	public void delTableRow(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg("Comp is "+ fld +" "+"Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "CalAction");
		imap.put(KeyStroke.getKeyStroke("VK_X"), "CalAction");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					int row = table.getSelectedRow();
					model.removeRow(row);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void callEditProcess() throws ClassNotFoundException, SQLException, Throwable {
		EditMode = "Y";
		btnEdit.setVisible(true);
		btnEdit.setBackground(Color.blue);
		btnEdit.setForeground(Color.WHITE);
		// panel.setBackground(Color.WHITE);
		internalFrame.setTitle("Edit -  Voucher");
		// String vparty = partycode.getText() ;
		String vtype = "JV";
		seqno.setText(new gnVoucher().vdocno);
		trdate.setText(new gnVoucher().vdocdate);

		chqddno.setText(new gnVoucher().vinstrno);
		chqdddate.setText(new gnVoucher().vinstrdate);
		mode.setSelectedItem(new gnVoucher().vpaymentMode);
		new gnStyleButton().getStyleButton(btnEdit, Color.gray, Color.WHITE);
		EditData(seqno.getText(), new gnConfig().date_ConverttoDBforamt(trdate.getText()), vtype);
	}

	private String validate() throws ClassNotFoundException, SQLException {

		Double dramt = 0.00;
		Double cramt = 0.00;
		String Status = "Sucess";
		int row = stable.getRowCount();
		if (trdate.getText().length() == 0) {
			Status = "Fail";
			new General().msg("Open Day First..");
		}
		for (int k = 0; k < row; k++) {
			dramt = new gnTable().getTotal(stable, 3);
			cramt = new gnTable().getTotal(stable, 4);
			Tdebit.setText(Double.toString(dramt));
			Tcredit.setText(Double.toString(cramt));
		}

		if (dramt - cramt != 0) {
			Status = "Fail";
			new General().msg("Debit & Credit is Not Match");

		}

		if (dramt == 0.00 & cramt == 0.00) {
			Status = "Fail";
			new General().msg("No Data Avaibale to Save Enter Amount");
		}

		if (stable.getValueAt(0, 1).toString().length() == 0) {
			Status = "Fail";
			new General().msg("Select Debit Ledger for Entry");
		}

		if (stable.getValueAt(1, 1).toString().length() == 0) {
			Status = "Fail";
			new General().msg("Select Credit Ledger for Entry");
		}

		if (dramt == 0.00 | cramt == 0.00) {
			Status = "Fail";
			new General().msg("Debit & Credit is Not Match");
		}

		if (trdate.getText().length() == 0) {
			Status = "Fail";
			new General().msg("Enter Date");
			trdate.grabFocus();
		}
		return Status;

	}

	public void SaveData() throws Throwable {
		String Status = "";
		String vpmtselected = mode.getSelectedItem().toString();
		String vchqno = chqddno.getText();
		String vchqdate = new gnConfig().Date_convertToApplformat(chqdddate.getText());
		String vtran = "108";
		String vtype = "TR";

		int row = stable.getRowCount();
		for (int i = 0; i < row; i++) {
			if (i == 0) {
				vdrgl = stable.getValueAt(i, 1).toString();
				vdrglname = stable.getValueAt(i, 2).toString();
				vdramount = stable.getValueAt(i, 3).toString();
			}
			if (i == 1) {
				vcrgl = stable.getValueAt(i, 1).toString();
				vcrglname = stable.getValueAt(i, 2).toString();
				vcramount = stable.getValueAt(i, 4).toString();
			}
		}
		String vnaration = naration.getText();
		try {
			switch (EditMode) {
			case "N":
				seqno.setText(new gnSeq().getSeqno(vtran, vtype));
				break;
			case "Y":
			}
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		
		if (vchqno.length() == 0) {
			vchqno = "0";
		}
		if (vchqdate.length() == 0) {
			vchqdate = "0000.00.00";
		}

		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		Status = "Fail";
		String pospayment = "Insert into  bank_transaction(Company_code, site_code, bank_code , "
				+ "Bank_name,   Transaction_date ,  Type , Amount ,  Payment_type ,  CHQ_DD_NUMBER , "
				+ "CHQ_DD_DATE, Clering_date, Partycode, Remark, Account_no, verticle, supplier_payment, doctype, docno, finyear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?)";
		prst = con.prepareStatement(pospayment);
		try {
			// { "Store" , "Bank_code" , "Party Code" , "Tr.Date" , "Type" ,
			// "Amount" , "Payment Type" , "Number" , "Chq/dd Date" , "Ramark" ,
			// "Ac.No" , "Bank Name"} ;
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, vdrgl);
			prst.setString(4, vdrglname);
			prst.setString(5, new gnConfig().date_ConverttoDBforamt(trdate.getText()));
			prst.setString(6, "JV");
			prst.setString(7, (vdramount));
			prst.setString(8, vpmtselected);
			prst.setString(9, vchqno);
			if (vchqdate == "0000.00.00") {
				prst.setString(10, vchqdate);
			} else {
				prst.setString(10, vchqdate);
			}
			prst.setString(11, "0000.00.00");
			prst.setString(12, vcrgl);
			prst.setString(13, naration.getText());
			String vacno = "0";
			prst.setString(14, vacno);
			prst.setString(15, "0");
			prst.setString(16, "N");
			prst.setString(17, "JV");
			prst.setString(18, seqno.getText());
			prst.setString(19, new gnFinYear().getCurrentFinYear(trdate.getText()));
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			Status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				con.commit();
				Status = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			con.commit();

		} catch (SQLException e) {
			new General().msg("Bank :" + e.getMessage());
			con.rollback();
			Status = "Fail";
		} finally {
			if (Status == "Sucess") {
				try {

					switch (EditMode) {
					case "N":
						new gnSeq().updateSeqno(vtran, vtype);
						break;
					case "Y":
					}
					legderEntery();
					PostAccountEntry();
					new General().msg("Data Saved Sucessfully");
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	private void legderEntery() throws Throwable {
		String vdocno = seqno.getText();
		String vdocType1 = "JV";
		String vdocdate = new gnConfig().date_ConverttoDBforamt(trdate.getText());
		String vfinyear = new gnFinYear().getCurrentFinYear(trdate.getText());

		String isdetors = new gnAccounting().getGroupCode(vdrgl);
		String iscreditors = new gnAccounting().getGroupCode(vcrgl);
		// new General().msg("Detors-> " + isdetors +"Creditor--> "+iscreditors
		// );
		String Passentry = "N";
		switch (isdetors) {
		case "8":
			vdocType1 = "Dr";
			Passentry = "Y";
			break;
		case "20":
			vdocType1 = "Dr";
			Passentry = "Y";
			break;
		}

		switch (iscreditors) {
		case "8":
			vdocType1 = "Cr";
			Passentry = "Y";
			break;
		case "20":
			vdocType1 = "Cr";
			Passentry = "Y";
			break;
		}
		// new General().msg("vpassentry-> " + Passentry );
		switch (Passentry) {
		case "Y":
			String VPostGST_accountEntryAtSaveTime = "Y";
			switch (VPostGST_accountEntryAtSaveTime) {
			case "Y":
				try {
					String SQL1 = "Call Led_LedgerEntry(" + vcomp + " , " + vstore + " , " + vdocno + " , '" + vdocdate
							+ "'  ,'" + vdocType1 + "'  , '" + vfinyear + "')";
					// new General().msg(SQL1);
					this.getSPResult(SQL1);
				} catch (Throwable e) {
					new General().msg(e.getLocalizedMessage());
				}
				break;
			}
			break;
		}
	}

	private void PostAccountEntry() throws Throwable {
		String vpmode = mode.getSelectedItem().toString();
		String vchqno = chqddno.getText();
		String vchqdate = new gnConfig().Date_convertToApplformat(chqdddate.getText());
		if (vpmode == "Cash") {
			this.vbankgl = "";
			this.vpaymenmode = "Cash";
			this.vchqddno = "0";
			this.vchqdddate = "0000.00.00";
		}

		if (vpmode != "Cash") {

			this.vpaymenmode = vpmode;
			this.vchqddno = vchqno;
			this.vchqdddate = new gnConfig().date_ConverttoDBforamt(vchqdate);
		}
		String Pdoctype = "JV";
		String Pdocno = seqno.getText();
		String Pdocdate = trdate.getText();
		String vnaration = naration.getText();
		new gnBridge().processOtherPosting(vdrgl, vcrgl, Pdoctype, Pdocno, Pdocdate, vcramount, vnaration);
		reset();
	}

	private void reset() {
		new gnTable().RemoveTableRows(smodel);
		new gnTable().RemoveTableRows(emodel);
		MSG.setText("..");
		EditMode = "N";
		btnEdit.setBackground(Color.CYAN);
		btnView.setBackground(Color.CYAN);
		Tdebit.setText("0");
		Tcredit.setText("0");
		vouchertype.setText("");
		// seqno.setText();
		naration.setText("");
		setDefaultrows();
	}

	private void setDefaultrows() {
		smodel.setColumnIdentifiers(entrycol);
		stable.setModel(smodel);
		smodel.addRow(new Object[] { "Dr ", " ", " ", "0", "0" });
		smodel.addRow(new Object[] { "Cr ", " ", " ", "0", "0" });
		JViewport prt66 = new JViewport();
		prt66.setBackground(Color.WHITE);
		new gnTable().setTableBasics(stable);
		stable.setRowHeight(30);
		table.setSelectionBackground(Color.BLACK);
		table.setSelectionForeground(Color.WHITE);
		prt66.setBorder(null);
		sjsp.setViewport(null);
		prt66.setToolTipText("Journal Entry");
		/// prt66.setScrollMode(0);
		prt66.add(stable, entrycol);
		stable.requestFocus();
		sjsp.setViewport(prt66);
		Selectrowmain();
	}

	public void Selectrowmain() {
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				Trow = stable.getSelectedRow();
				String vname = stable.getValueAt(Trow, 2).toString();
				vname = "%" + vname + "%";
				String vtype = "GL";
				try {
					new gnAccountSearch().showAccountSearchFor(vname, vtype);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					stable.setValueAt(new gnAccountSearch().vcode, Trow, 1);
					stable.setValueAt(new gnAccountSearch().vname, Trow, 2);
				}
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
	}

	//// Edit Process
	class stodateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vstatus = "";
			try {
				vstatus = new gnFinYear().checkDateRanegforFinyear(from.getText(), to.getText());
			} catch (Throwable e1) {
				new General().msg(e1.getMessage());
			}

			if (vstatus == "Sucess") {
				try {
					String vtype = "JV";
					String vto = new gnConfig().date_ConverttoDBforamt(to.getText());
					String vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
					String SQL = "call N_viewExpInc(" + vcomp + " , " + vstore + " , '" + vfrom + "' , '" + vto
							+ "' , '" + vtype + "')";
					showTableData(SQL, vtrType);
				} catch (ClassNotFoundException | SQLException e) {
					new General().msg(e.getMessage());
				}
			}
		}
	}

	private void showTableData(String SQL, String vtrType) throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(emodel);
		etable.grabFocus();
		String col[] = { "Type", "Doc,No", "Doc.Date", "Glcode", "Name", "Amount", "DrCr Type" };
		emodel.setColumnIdentifiers(col);
		etable.setModel(emodel);
		etable = new gnTableModel().Tablemodel(etable, emodel, SQL, col, 6, "N", "Y", vtrType);
		JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(etable, col);
		prt.setVisible(true);
		prt.setBackground(Color.WHITE);
		jsp1.setViewport(prt);
		new gnTable().setTableBasics(etable);
		selectRow7();
	}

	public void selectRow7() {
		etable.requestFocus();
		etable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		etable.getActionMap().put("enter", new AbstractAction() {
			String vdocdate;
			String vdocno;

			public void actionPerformed(ActionEvent e) {
				int row = etable.getSelectedRow();
				vdocno = (String) etable.getValueAt(row, 1);
				vdocdate = etable.getValueAt(row, 2).toString();
				try {
					showEdit(vdocno, vdocdate, vtrType);
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void showEdit(String vdocno, String vdocdate, String vtrtype) throws Throwable {
		// new gnAccountbase().showAccouuntEntry(vtrtype, vdocno, vdocdate) ;
		trdate.setText(vdocdate);
		seqno.setText(vdocno);
		seqno.setBackground(Color.black);
		seqno.setForeground(Color.white);
		MSG.setText("    EDIT ");
		EditMode = "Y";
		new gnStyleButton().getStyleButton(btnEdit, Color.gray, Color.WHITE);
		EditData(vdocno, vdocdate, vtrtype);
	}

	private void EditData(String vdocno, String vdocdate, String vtrtype) throws Throwable {
		// decorate();
		new gnTable().RemoveTableRows(smodel);
		String vchno = seqno.getText();
		String vdate = new gnConfig().date_ConverttoDBforamt(trdate.getText());
		String SQL = "call N_getaccEntry( " + vcomp + " , " + vstore + " , '" + vtrtype + "' , " + vchno + " , '"
				+ vdate + "' )";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			smodel.setColumnIdentifiers(entrycol);
			stable.setModel(smodel);
			String vdrcr = rs.getString(1);
			switch (vdrcr) {
			case "Dr":
				smodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), "0" });
				break;
			case "Cr":
				smodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), "0", rs.getString(4) });
				break;
			}
			JViewport prt66 = new JViewport();
			prt66.setBackground(Color.WHITE);
			stable.setRowHeight(30);
			prt66.setBorder(null);
			sjsp.setViewport(null);
			prt66.setToolTipText("Journal Entry");
			prt66.setScrollMode(0);
			prt66.add(stable, entrycol);
			sjsp.setViewport(prt66);
		}
		Selectrowmain();
	}

}// Last

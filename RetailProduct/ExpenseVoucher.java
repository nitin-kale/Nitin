package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;

//

public class ExpenseVoucher extends getResultSet {

	JFrame frmExpenses;
	private String vcomp;
	private String vverticle;
	private JTextField acno;
	JPanel panel;
	private JTextField clbal;
	private JButton btnExport;
	private String voucherMode = "I";
	JButton btnEdit;
	private JTextField paymentvno;
	private JTextField trdate;
	private JTextField companycode;
	private JPanel panel7;
	private JTextField companyname;
	private JTextField bankcode;
	private JTextField storecode;
	private JTextField storename;
	private JTextField bankname;
	private JTextField amount;
	private JTextField chqnumber;
	private JTextField chqdate;
	private JTextField partycode;
	private JTextField partyname;
	private JTextField remark;
	private JButton btnSave;
	private JButton btnCancel;
	JButton btnHis;
 
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public JComboBox comboPType;
	public JComboBox comboTrType;

	//
	
	private DefaultTableModel hmodel = new DefaultTableModel();
	private JTable htable = new JTable();
	
	private JTable table = new JTable();
	private JTable stable = new JTable();
	private DefaultTableModel smodel = new DefaultTableModel();

	private DefaultTableModel model = new DefaultTableModel();

	private JScrollPane sjsp;
	public String party[] = { "Type", "Customer code", "Name", "Phone", "Email", "Credit Days" };
	public String bank[] = { "Store", "Bank_code", "Party Code", "Tr.Date", "Type", "Amount", "Payment Type", "Number",
			"Chq/dd Date", "Ramark", "Ac.No", "Bank Name" };
	public String banksearch[] = { "Type", "Bank Code", "Bank Name", "City", "Account_No", "Cl.Bal" };
	private JButton btnAcEntry;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExpenseVoucher window = new ExpenseVoucher();
					window.frmExpenses.setVisible(true);
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
	public ExpenseVoucher() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frmExpenses = new JFrame();
		frmExpenses.getContentPane().setBackground(Color.WHITE);
		frmExpenses.setAlwaysOnTop(true);
		frmExpenses.setTitle("Business Application");
		//frmExpenses.setBounds(100, 50, 1011, 501);
		frmExpenses.setBounds(1, 90, 1350, 605);
 		frmExpenses.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	 	frmExpenses.getContentPane().setLayout(null);
 		ActionListener cncl = new lsnrBtn();

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.window, null));
		panel.setBounds(0, 0, 764, 227);
		frmExpenses.getContentPane().add(panel);
		panel.setLayout(null);

		storecode = new JTextField();
		storecode.setBackground(new Color(0, 0, 51));
		storecode.setForeground(new Color(204, 255, 255));
		storecode.setEditable(false);
		storecode.setFont(new Font("Arial Black", Font.BOLD, 12));
		storecode.setBounds(218, 28, 56, 25);
		panel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setBackground(new Color(0, 0, 51));
		storename.setForeground(new Color(204, 255, 255));
		storename.setFont(new Font("Arial Black", Font.BOLD, 12));
		storename.setBounds(273, 28, 272, 25);
		storename.setEditable(false);
		panel.add(storename);
		storename.setColumns(10);
		ActionListener bnk = new lsnrbankName();
		ActionListener pmt = new lsnrpmtType();
		ActionListener abc = new lsnrCustName();
		ActionListener jkl = new lsnrBtn();
		ActionListener nkk = new lsnrBtn();

		companycode = new JTextField();
		companycode.setBackground(new Color(0, 0, 51));
		companycode.setForeground(new Color(204, 255, 255));
		companycode.setFont(new Font("Arial Black", Font.BOLD, 12));
		companycode.setEditable(false);
		companycode.setBounds(218, 5, 56, 25);
		panel.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setBackground(new Color(0, 0, 51));
		companyname.setForeground(new Color(204, 255, 255));
		companyname.setFont(new Font("Arial Black", Font.BOLD, 12));
		companyname.setEditable(false);
		companyname.setBounds(274, 5, 272, 25);
		panel.add(companyname);
		companyname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Expense  VNO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1.setBounds(85, 61, 123, 16);
		panel.add(lblNewLabel_1);

		paymentvno = new JTextField();
		paymentvno.setBackground(new Color(0, 0, 51));
		paymentvno.setForeground(new Color(204, 255, 255));
		paymentvno.setFont(new Font("Arial Black", Font.BOLD, 12));
		paymentvno.setBounds(218, 52, 56, 25);
		panel.add(paymentvno);
		paymentvno.setColumns(10);

		trdate = new JTextField();
		trdate.setBackground(new Color(0, 0, 51));
		trdate.setForeground(new Color(204, 255, 255));
		trdate.setFont(new Font("Arial Black", Font.BOLD, 12));
		trdate.setEditable(false);
		trdate.setBounds(273, 52, 120, 25);
		panel.add(trdate);
		trdate.setColumns(10);

		panel7 = new JPanel();
		panel7.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel7.setBackground(Color.WHITE);
		panel7.setBounds(545, 5, 198, 60);
		panel.add(panel7);
		panel7.setLayout(null);

		JLabel lblAccno = new JLabel("Acc.No");
		lblAccno.setBounds(31, 16, 56, 16);
		panel7.add(lblAccno);
		lblAccno.setHorizontalAlignment(SwingConstants.RIGHT);

		acno = new JTextField();
		acno.setBounds(108, 13, 123, 22);
		panel7.add(acno);
		acno.setEnabled(false);
		acno.setEditable(false);
		acno.setColumns(10);

		JLabel lblNewLabel = new JLabel("Acc.Balance");
		lblNewLabel.setBounds(31, 40, 81, 16);
		panel7.add(lblNewLabel);

		clbal = new JTextField();
		clbal.setBounds(108, 37, 123, 22);
		panel7.add(clbal);
		clbal.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		clbal.setForeground(new Color(0, 0, 153));
		clbal.setEnabled(false);
		clbal.setColumns(10);

		JPanel panel_201 = new JPanel();
		panel_201.setBorder(new MatteBorder(2, 0, 1, 0, (Color) new Color(0, 255, 0)));
		panel_201.setBackground(Color.WHITE);
		panel_201.setBounds(12, 78, 749, 43);
		panel.add(panel_201);
		panel_201.setLayout(null);

		JLabel lblType = new JLabel("Type");
		lblType.setBounds(504, 9, 34, 16);
		panel_201.add(lblType);

		comboTrType = new JComboBox();
		comboTrType.setBounds(534, 6, 88, 25);
		comboTrType.setEnabled(false);
		panel_201.add(comboTrType);
		comboTrType.setFont(new Font("Calibri", Font.BOLD, 13));
		comboTrType.setEditable(true);
		comboTrType.setModel(new DefaultComboBoxModel(new String[] { "Expense" }));

		JLabel lblPartyCode = new JLabel("Ledger Code");
		lblPartyCode.setBounds(12, 9, 150, 27);
		panel_201.add(lblPartyCode);
		lblPartyCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPartyCode.setHorizontalAlignment(SwingConstants.RIGHT);

		partycode = new JTextField();
		partycode.setBounds(165, 6, 61, 30);
		panel_201.add(partycode);
		partycode.setForeground(new Color(0, 0, 128));
		partycode.setFont(new Font("Tahoma", Font.BOLD, 14));
		partycode.setColumns(10);

		partyname = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		partyname.setBounds(230, 6, 262, 30);
		panel_201.add(partyname);
		partyname.setForeground(new Color(0, 0, 128));
		partyname.setFont(new Font("Tahoma", Font.BOLD, 14));
		partyname.setColumns(10);

		btnEdit = new JButton("Edit-Voucher");
		btnEdit.setBounds(624, 4, 119, 28);
		btnEdit.setBackground(Color.cyan);
		btnEdit.setForeground(Color.BLACK);
		panel_201.add(btnEdit);
		btnEdit.setFont(new Font("Calibri", Font.BOLD, 14));
		btnEdit.setMnemonic('E');
		btnEdit.addActionListener(nkk);
		partyname.addActionListener(abc);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { partyname, comboTrType, comboPType, amount, remark, bankname }));

		JPanel panel_203 = new JPanel();
		panel_203.setBackground(Color.WHITE);
		panel_203.setBorder(new MatteBorder(3, 0, 0, 1, (Color) new Color(0, 255, 204)));
		panel_203.setBounds(12, 124, 749, 67);
		panel.add(panel_203);
		panel_203.setLayout(null);

		JLabel lblBankCode = new JLabel("Bank");
		lblBankCode.setBounds(253, 0, 40, 20);
		lblBankCode.setForeground(new Color(0, 0, 102));
		panel_203.add(lblBankCode);
		lblBankCode.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBankCode.setHorizontalAlignment(SwingConstants.LEFT);

		bankcode = new JTextField();
		bankcode.setBounds(214, 28, 61, 30);
		panel_203.add(bankcode);
		bankcode.setForeground(new Color(0, 0, 128));
		bankcode.setFont(new Font("Arial Black", Font.BOLD, 12));
		bankcode.setEnabled(false);

		bankcode.setColumns(10);

		bankname = new JTextField();
		bankname.setBounds(270, 28, 261, 30);
		panel_203.add(bankname);
		bankname.setForeground(new Color(0, 0, 128));
		bankname.setFont(new Font("Arial Black", Font.BOLD, 12));
		bankname.setEditable(true);
		bankname.setColumns(10);

		JLabel lblPaymentType = new JLabel("Payment Type");
		lblPaymentType.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaymentType.setBounds(0, 2, 105, 16);
		lblPaymentType.setForeground(new Color(0, 0, 102));
		panel_203.add(lblPaymentType);
		lblPaymentType.setFont(new Font("Tahoma", Font.BOLD, 13));

		comboPType = new JComboBox();
		comboPType.setBounds(0, 28, 105, 30);
		panel_203.add(comboPType);
		comboPType.setFont(new Font("Agency FB", Font.PLAIN, 17));
		comboPType.setModel(new DefaultComboBoxModel(new String[] { "Cash", "Cheque", "Demand Draft", "NEFT" }));

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setBounds(114, 0, 56, 16);
		lblAmount.setForeground(new Color(0, 0, 102));
		panel_203.add(lblAmount);
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 13));

		amount = new JTextField();
		amount.setFont(new Font("Arial Black", Font.BOLD, 12));
		amount.setBounds(109, 28, 110, 30);
		panel_203.add(amount);
		amount.setText("0");
		amount.setColumns(10);

		JLabel lblChqddNo = new JLabel("Instrument No");
		lblChqddNo.setBounds(520, 4, 105, 16);
		lblChqddNo.setForeground(new Color(0, 0, 102));
		panel_203.add(lblChqddNo);
		lblChqddNo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		chqnumber = new JTextField();
		chqnumber.setFont(new Font("Arial Black", Font.BOLD, 12));
		chqnumber.setBounds(538, 28, 94, 30);
		panel_203.add(chqnumber);
		chqnumber.setColumns(10);

		chqdate = new JTextField();
		chqdate.setFont(new Font("Arial Black", Font.BOLD, 12));
		chqdate.setBounds(635, 28, 94, 30);
		panel_203.add(chqdate);
		chqdate.setColumns(10);

		JLabel lblChqddDate = new JLabel("Instrument Date");
		lblChqddDate.setBounds(627, 4, 122, 16);
		lblChqddDate.setForeground(new Color(0, 0, 102));
		panel_203.add(lblChqddDate);
		lblChqddDate.setFont(new Font("Tahoma", Font.PLAIN, 14));

		remark = new JTextField();
		remark.setFont(new Font("Arial", Font.PLAIN, 13));
		remark.setBounds(119, 187, 642, 38);
		panel.add(remark);
		remark.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Remark");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(54, 204, 56, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Expense");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(12, 52, 85, 24);
		panel.add(lblNewLabel_3);
		comboPType.addActionListener(pmt);
		bankname.addActionListener(bnk);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(766, 186, 97, 41);
		frmExpenses.getContentPane().add(btnSave);
		btnSave.setMnemonic('S');

		btnHis = new JButton("View Data");
		btnHis.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHis.setBounds(864, 187, 97, 40);
		frmExpenses.getContentPane().add(btnHis);
		btnHis.setForeground(new Color(0, 0, 51));
		btnHis.setMnemonic('V');

		btnCancel = new JButton("Close");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(1203, 187, 99, 40);
		frmExpenses.getContentPane().add(btnCancel);
		btnCancel.setMnemonic('C');

		btnExport = new JButton("Export Data");
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExport.setBounds(1084, 187, 119, 40);
		frmExpenses.getContentPane().add(btnExport);
		btnExport.setMnemonic('E');

		btnAcEntry = new JButton("Account Entry");
		btnAcEntry.setMnemonic('A');
		btnAcEntry.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAcEntry.setBounds(962, 188, 122, 39);
		frmExpenses.getContentPane().add(btnAcEntry);
		
				sjsp = new JScrollPane();
				sjsp.setBounds(1, 228, 1349, 332);
				frmExpenses.getContentPane().add(sjsp);
				
				textPane = new JTextPane();
				textPane.setText("1.Select Leger Code\r\n2.Select Payment Mode \r\n3.If Payment Mode is Bank then Select Bank \r\n4.Enter Amout\r\n5.Save Data");
				textPane.setFont(new Font("Tahoma", Font.BOLD, 13));
				textPane.setBounds(765, 13, 537, 174);
				frmExpenses.getContentPane().add(textPane);

		btnAcEntry.addActionListener(nkk);
		btnCancel.addActionListener(cncl);
		btnSave.addActionListener(nkk);
		btnHis.addActionListener(nkk);

 		decorate();
		btnDisable();
		blockChqDetail();
	}

	private void chekcFreezeYear() {
		switch (isFinyearFreeze) {
		case "Y":
			btnEdit.setVisible(false);
			btnSave.setVisible(false);
 			new General().msg("Accounting Year is Freezeed..You Can View Data Only..");
			break;
		}
	}

	public void decorate() throws Throwable {

		new gnApp().setFrameTitel(frmExpenses);
 		new gnField().closeform(btnSave, frmExpenses);

		frmExpenses.setUndecorated(true);

 
		this.checkInternet();

 		companycode.setVisible(false); 
		companyname.setVisible(false);
 		storecode.setVisible(false);
 		storename.setVisible(false);

		String vpara29 = "29";
		String vEditDocumentAllow = new getConfigurationSetting().getSpecificConfiguration(vpara29);
		switch (vEditDocumentAllow) {
		case "N":
			btnEdit.setVisible(false);
		}

		trdate.setText(new gnConfig().getDaybeginDate());

		String vtype = "EX";
		String vallowDate = new gnDate().checkBackDateTrAllow(vtype, trdate.getText());
		switch (vallowDate) {
		case "N":
			btnEdit.setVisible(false);
			trdate.setBackground(Color.RED);
			trdate.setForeground(Color.WHITE);
			trdate.setText("?");
			new General().msg("Back Date For Transaction is not Allow..");
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
 			bankcode.setVisible(false);
			bankname.setVisible(false);
			partycode.setVisible(false);
			partyname.setVisible(false);
			btnSave.setVisible(false);
			break;
		}
 		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		vcomp = companycode.getText();
		btnSave.setEnabled(true);
		storecode.setText(new gnConfig().getStoreID());
		String value = storecode.getText();
		storename.setText(new gnConfig().getStorename(value));
		vstore = storecode.getText();
		switch (vcomp) {
		case "0":
			System.exit(0);
		}

 		bankcode.setText(new gnConfig().getBankCode());
		String vbank = bankcode.getText();
		bankname.setText(new gnConfig().getBankName(vbank));
		acno.setText(new gnConfig().getAccCode());
		clbal.setText(new gnConfig().getbankclbal());
		vverticle = new gnHierarchy().getVerticleCode();
		vverticle = new gnHierarchy().getVerticleCode();
		panel7.setVisible(false);

		int typecode = 1;
		new gnDecorate().SetSeqHdrButton(btnAcEntry, 1);
		new gnDecorate().SetSeqHdrButton(btnSave, 1);
		new gnDecorate().SetSeqHdrButton(btnCancel, 1);
		new gnDecorate().SetSeqHdrButton(btnExport, 1);
		new gnDecorate().SetSeqHdrButton(btnHis, 1);
  	}

	
	
	
	class lsnrpmtType implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vptype = (String) comboPType.getSelectedItem();
			if (vptype == "Cash") {
				blockChqDetail();
			} else {
				openChqDetail();
			}
		}
	}

	class lsnrbankName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String sname = bankname.getText().trim();
			sname = "%" + sname + "%";
			String vtype = "BANK";
			String vcomp = companycode.getText();
			try {
				// new gnBank().getbankDetail(vtype);
				new gnAccountGetGLofGivenGroup().getAllGLofGroup(vtype, sname);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				// bankcode.setText(new gnBank().rbankcode);
				// bankname.setText(new gnBank().rbankname);
				bankcode.setText(new gnAccountGetGLofGivenGroup().vcode);
				bankname.setText(new gnAccountGetGLofGivenGroup().vname);
				new gnAccountGetGLofGivenGroup().vname = null;
				new gnAccountGetGLofGivenGroup().vcode = null;

			}
		}
	}

	class lsnrCustName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			String sname = partyname.getText().trim();
			sname = "%" + sname + "%";
			String vtype = "EXPENSES"; // "Party" ;
			try {
				searchData() ;
				//new gnAccountGetGLofGivenGroup().getAllGLofGroup(vtype, sname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				//partycode.setText(new gnAccountGetGLofGivenGroup().vcode);
				//partyname.setText(new gnAccountGetGLofGivenGroup().vname);
				// partycode.setText(new gnSupplier().rcustcode);
				// partyname.setText(new gnSupplier().rcustName);
			}

		}
	}

	class lsnrBtn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			String status = "Sucess";

			if (value == "Edit-Voucher") {
				try {
					startEditProcess();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Close") {
				frmExpenses.dispose();
			}

			if (value == "Account Entry") {

				String vtype = "EX";
				String vdocno = paymentvno.getText();
				String vdocdate = trdate.getText();
				try {
					new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "View Data") {
				status = checkVendor();
				if (status == "Sucess") {
					try {
						ShowView();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			if (value == "Save") {
				try {
					status = validate();
					if (status == "Sucess") {
						switch (voucherMode) {
						case "E":
							String vvdoctype = "EX";
							String vdocno = paymentvno.getText();
							String vvdocdate = trdate.getText();
							new gnEDMiddleWare().ExpenseVoucherModification(vvdoctype, vdocno, vvdocdate);
							SaveData();
							break;
						case "I":
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

		}
	}

	private void startEditProcess() throws Throwable {
		voucherMode = "E";
		chekcFreezeYear();
		panel.setBackground(Color.WHITE);
 		String vparty = partycode.getText();
		String vtype = "EX";
		new gnVoucher().ShowVouchers(vtype, vparty);
		paymentvno.setText(new gnVoucher().vdocno);
		trdate.setText(new gnVoucher().vdocdate);
		chqnumber.setText(new gnVoucher().vinstrno);
		chqdate.setText(new gnVoucher().vinstrdate);
		comboPType.setSelectedItem(new gnVoucher().vpaymentMode);
		amount.setText(new gnVoucher().vamount);
		btnEdit.setBackground(Color.BLUE);
		btnEdit.setForeground(Color.white);
		new gnAdvance().getBankRelatedDetails(vtype, paymentvno.getText(), trdate.getText());
		bankcode.setText(new gnAdvance().rbankcode);
		bankname.setText(new gnAdvance().rbankname);

	}

	public void callEditProcess() throws Throwable {
		voucherMode = "E";
		panel.setBackground(Color.WHITE);
 		String vparty = partycode.getText();
		String vtype = "EX";
		// new gnVoucher().ShowVouchers(vtype, vparty);
		paymentvno.setText(new gnVoucher().vdocno);
		trdate.setText(new gnVoucher().vdocdate);
		chqnumber.setText(new gnVoucher().vinstrno);
		chqdate.setText(new gnVoucher().vinstrdate);
		comboPType.setSelectedItem(new gnVoucher().vpaymentMode);
		amount.setText(new gnVoucher().vamount);
		partycode.setText(new gnSupplier().rcustcode);
		partyname.setText(new gnSupplier().rcustName);

		btnEdit.setVisible(true);
		btnEdit.setBackground(Color.blue);
		btnEdit.setForeground(Color.WHITE);
		new gnAdvance().getBankRelatedDetails(vtype, paymentvno.getText(), trdate.getText());
		bankcode.setText(new gnAdvance().rbankcode);
		bankname.setText(new gnAdvance().rbankname);

		new gnStyleButton().getStyleButton(btnEdit, Color.gray, Color.WHITE);

	}

	private void insertintoGLmaster() throws Throwable {
		String vglcode = partycode.getText();
		String vglname = partyname.getText();
		String vtype = "Y";
		new gnAccountbase().insertGlData(vglcode, vglname, vtype);
	}

	private String validate() {

		String status = "Sucess";

		Double vamt = Double.parseDouble(amount.getText());
		status = new gnTable().isAmountnegative(amount.getText());
		if (status == "Fail") {
			amount.grabFocus();
		}

		if (partycode.getText().length() == 0) {
			status = "Fail";
			new General().msg("Select Party ..");
			return status;
		}
		String vtype1 = (String) comboPType.getSelectedItem();

		if (vtype1 != "Cash" && bankname.getText().length() == 0) {
			new General().msg("Select Bank ");
			bankname.grabFocus();
			new gnImageSound().playSound();
			status = "Fail";
		}

		if (vtype1 != "Cash" && bankcode.getText().length() == 0) {
			new General().msg("Select Bank ");
			bankname.grabFocus();
			new gnImageSound().playSound();
			status = "Fail";
		}

		if (vtype1 == "Cash" && bankname.getText().length() > 0) {
			new General().msg("Select Correct Payment Mode <Cheque/DD Etc..> ");
			comboPType.grabFocus();
			new gnImageSound().playSound();
			status = "Fail";
		}

		if (partyname.getText().length() == 0) {
			new General().msg("Select Party Code ");
			status = "Fail";
			partyname.grabFocus();
		}

		// double vamt = Double.parseDouble(amount.getText()) ;

		String vptype = (String) comboPType.getSelectedItem();
		if ((vptype == "Cheque" || vptype == "Demand Draft") && (amount.getText().length() == 0
				|| chqnumber.getText().length() == 0 || chqdate.getText().length() == 0)) {
			chqnumber.grabFocus();
			new gnImageSound().playSound();
			new General().msg("Check ( DD/CHQ Number OR Amount  OR Date Fields Can Not Be Empty)");
			status = "Fail";
		}

		if (status == "Sucess") {
			try {
				insertintoGLmaster();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return status;
	}

	private String checkVendor() {
		String status = "Sucess";
		String vparty = partyname.getText();
		if (vparty.length() == 0) {
			new General().msg("Select Party To View Data");
			status = "Fail";
		}
		return status;
	}

	private void ShowView() throws Throwable {
		new gnTable().RemoveTableRows(smodel);
 		String col[] = { "Doc.No", "Doc.Date", "Mode", "Instrumentno", "Inst.Date", "Amount", "Gl", "Name" };
 		smodel.setColumnIdentifiers(col);
		String vtype = "EX";
		String vparty = partycode.getText();
		vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call voucher_viewData('" + vtype + "', " + vcomp + ", " + vstore + ", " + vparty + ")";
		//new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			smodel.addRow(new Object[] {   rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6) , rs.getString(7) , rs.getString(8) });
		}
		stable.setModel(smodel);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(prt6);
		prt6.setToolTipText("ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, col);
		prt6.setBackground(Color.WHITE);
		new gnTable().setTableBasics(stable);
	}

	public void SaveData() throws Throwable {
		String Status = "";
		String vpmtselected = comboPType.getSelectedItem().toString();
		String vchqno = chqnumber.getText();
		String vchqdate = chqdate.getText();
		// String vtran = "108" ;
		String vtran = "110";
		String vtype = "TR";

		try {

			switch (voucherMode) {
			case "I":
				paymentvno.setText(new gnSeq().getSeqno(vtran, vtype));
				break;
			case "E":
			}
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
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
			prst.setString(2, storecode.getText());
			prst.setString(3, bankcode.getText());
			prst.setString(4, bankname.getText());
			prst.setString(5, new gnConfig().date_ConverttoDBforamt(trdate.getText()));
			prst.setString(6, "Expense");
			prst.setString(7, (amount.getText()));
			prst.setString(8, vpmtselected);
			prst.setString(9, vchqno);
			if (vchqdate == "0000.00.00") {
				prst.setString(10, vchqdate);
			} else {
				prst.setString(10, new gnConfig().Date_convertToApplformat(vchqdate));
			}
			prst.setString(11, "0000.00.00");
			prst.setString(12, partycode.getText());
			prst.setString(13, remark.getText());
			if (bankcode.getText().length() > 0) {
				prst.setString(14, acno.getText());
			} else {
				String vacno = "0";
				prst.setString(14, vacno);
			}
			prst.setString(15, vverticle);
			prst.setString(16, "N");
			prst.setString(17, "EX");
			prst.setString(18, paymentvno.getText());
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

					switch (voucherMode) {
					case "I":
						new gnSeq().updateSeqno(vtran, vtype);
						break;
					case "E":
					}
					postjournalEntery();
					// legderEntery();
					new General().msg("Data Saved Sucessfully");
					reset();
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
		String vstore = storecode.getText();
		String vdocno = paymentvno.getText();
		String vdocType1 = "PV";
		String vdocdate = new gnConfig().date_ConverttoDBforamt(trdate.getText());
		String vfinyear = new gnFinYear().getCurrentFinYear(trdate.getText());
		String VPostGST_accountEntryAtSaveTime = "Y";
		switch (VPostGST_accountEntryAtSaveTime) {
		case "Y":
			try {
				String SQL1 = "Call Led_LedgerEntry(" + vcomp + " , " + vstore + " , " + vdocno + " , '" + vdocdate
						+ "'  ,'" + vdocType1 + "'  , " + vfinyear + ")";
				this.getSPResult(SQL1);
				postjournalEntery();
			} catch (Throwable e) {
				new General().msg(e.getLocalizedMessage());
			}
			break;
		}
	}

	private void postjournalEntery() throws Throwable {
		String vdocdate = trdate.getText();
		String vamount = amount.getText();
		String vdocno = paymentvno.getText();
		new gnGSTMiddleWare().backend_DocaccountExpensePosting(vdocno, vdocdate, vamount);
		reset();
	}

	private void reset() throws Throwable {
		voucherMode = "I";
		btnEdit.setBackground(Color.cyan);
		btnEdit.setForeground(Color.BLACK);

		trdate.setText(new gnConfig().getDaybeginDate());
		new gnTable().RemoveTableRows(smodel);
		bankcode.setText("");
		bankname.setText("");
		partycode.setText("");
		partyname.setText("");
		remark.setText("");
		chqnumber.setText("");
		chqdate.setText("");
		acno.setText("");
		amount.setText("0.00");
		partyname.grabFocus();
		//decorate();
		// btnSave.setEnabled(false);
	}

	private void btnDisable() {
 
		btnCancel.setEnabled(true);
 		new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnCancel, Color.BLUE, Color.WHITE);

	}

	private void blockChqDetail() {
		chqnumber.setEditable(false);
		chqdate.setEditable(false);
		bankcode.setText("");
		bankname.setText("");
		acno.setText("0");
		bankcode.setEditable(false);
		bankcode.setEditable(false);
		acno.setText("0");
		bankcode.setBackground(Color.cyan);
		bankname.setBackground(Color.cyan);
		chqnumber.setBackground(Color.cyan);
		chqdate.setBackground(Color.cyan);

	}

	private void openChqDetail() {
		chqnumber.setEditable(true);
		chqdate.setEditable(true);
		// bankcode.setText(null);
		// bankcode.setText("");
		// acno.setText("0");
		bankcode.setBackground(Color.white);
		bankname.setBackground(Color.white);
		chqnumber.setBackground(Color.white);
		chqdate.setBackground(Color.white);

	}
	
	
	
	
private void searchData() throws Throwable
{
	
	String Col[] = { "Type", "Code", "Name", "Op.Bal", "DrCr", "Curr.Bal", "Drcr", "Acc.GrpCode",
			"Acc.Group", "Taxcode" };
 	new gnTable().RemoveTableRows(smodel);
 	smodel.setColumnIdentifiers(Col);
 	String vparty = partyname.getText();
    String sname = partyname.getText().trim();
	sname = "%" + sname + "%";
	String vtype = "Party";
 	vtype = "EXPENSES" ;
 	stable = new gnAccountGetGLofGivenGroup().getAllGLofGroupinTable(vtype, sname);
 	JViewport prt66 = new JViewport();
	sjsp.setViewport(prt66);
	prt66.setToolTipText("ScrollPaneport");
	prt66.setScrollMode(0);
	prt66.add(stable);
	sjsp.setVisible(true);
 	new gnTable().setTableBasics(stable);
	new gnTable().setTableColWidth(stable, 2, 200);
 	Selectrow();
 
}
	



public void Selectrow() {
	stable.requestFocus();
	stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
	stable.getActionMap().put("enter", new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			int row = stable.getSelectedRow();
			String value = (String) stable.getValueAt(row, 0);
			try {
 				partycode.setText(stable.getValueAt(row, 1).toString());
				partyname.setText(stable.getValueAt(row, 2).toString());
				amount.grabFocus();
				removeableData();
				btnHis.doClick();
  			} catch (Throwable e1) {
				e1.printStackTrace();
			} 
 		}
	});
 }



private void removeableData() throws Throwable {

	String Col[] = { "Type", "Code", "Name", "Op.Bal", "DrCr", "Curr.Bal", "Drcr", "Acc.GrpCode", "Acc.Group",
			"Taxcode" };
	new gnTable().RemoveTableRows(hmodel);
	smodel.setColumnIdentifiers(Col);
	String vparty = partyname.getText();
	String sname = "123452252ZSS";
	sname = "%" + sname + "%";
	String vtype = "Party";
	vtype = "INCOME2";
	stable = new gnAccountGetGLofGivenGroup().getAllGLofGroupinTable(vtype, sname);
	JViewport prt66 = new JViewport();
	sjsp.setViewport(prt66);
	prt66.setToolTipText("ScrollPaneport");
	prt66.setScrollMode(0);
	prt66.add(stable);
	sjsp.setVisible(true);
	new gnTable().setTableBasics(stable);
	new gnTable().setTableColWidth(stable, 2, 200);
	}


}// last

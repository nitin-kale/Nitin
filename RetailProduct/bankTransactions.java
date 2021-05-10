package RetailProduct;

import java.awt.Color;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
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
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

//

public class bankTransactions extends getResultSet {

	JFrame frmBusinessApplication;
	private String vcomp;
	JLabel lblPartyCode;
	private String vverticle;
	JButton btnHis;
	private JTextField acno;
	private String vstore;
	private JPanel panel_2;
	JPanel panel;
	String voucherMode = "I";
	JButton btnEdit;
	String vchoice = "Bank" ;
	private JTextField clbal;
	private JTextField docno;
	private JPanel bankpanel1;
	private JPanel paymentpanel;
	String vparty;
	String vdocType;
	String vbankcode;
	String vdocdate;
	String vamount;
	String vdocno;

	private JTextField companycode;
	private JTextField companyname;
	private JTextField bankcode;
	private JTextField storecode;
	private JTextField storename;
	private JTextField bankname;
	private JTextField trdate;
	private JTextField amount;
	private JTextField chqnumber;
	private JTextField chqdate;
	private JTextField partycode;
	private JTextField partyname;
	private JTextField remark;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnAddTransaction;
	public JInternalFrame internalFrame;
	JButton btnExport;
	JPanel bankpanel;
	String trtype;

	// ====
	String vtrantype1;
	String vpaymenttype1;

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
	private JLabel lblNewLabel_3;
	private JScrollPane hjsp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bankTransactions window = new bankTransactions();
					window.frmBusinessApplication.setVisible(true);
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
	public bankTransactions() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frmBusinessApplication = new JFrame();
		frmBusinessApplication.getContentPane().setBackground(Color.WHITE);
		frmBusinessApplication.setAlwaysOnTop(true);
		frmBusinessApplication.setTitle("Business Application");
		//frmBusinessApplication.setBounds(150, 225, 1011, 467);
		//frmBusinessApplication.setBounds(5, 220, 1350, 500);
		frmBusinessApplication.setBounds(1, 90, 1350, 605);

		frmBusinessApplication.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBusinessApplication.getContentPane().setLayout(null);
  		JPanel panel = new JPanel();
 		panel.setBackground(new Color(204, 255, 255));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 952, 148);
		frmBusinessApplication.getContentPane().add(panel);
		panel.setLayout(null);

		storecode = new JTextField();
		storecode.setBounds(426, 9, 56, 25);
		storecode.setForeground(new Color(0, 51, 0));
		storecode.setBackground(Color.WHITE);
		storecode.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		panel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setBounds(645, 9, 63, 25);
		storename.setForeground(new Color(0, 51, 0));
		storename.setBackground(Color.WHITE);
		storename.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		storename.setEditable(false);
		panel.add(storename);
		storename.setColumns(10);
		ActionListener bnk = new lsnrbankName();

		trdate = new JTextField();
		trdate.setBounds(142, 9, 85, 25);
		trdate.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		trdate.setForeground(new Color(0, 51, 0));
		trdate.setBackground(Color.WHITE);
		panel.add(trdate);
		trdate.setColumns(10);
		ActionListener pmt = new lsnrpmtType();
		ActionListener abc = new lsnrCustName();

		panel_2 = new JPanel();
		panel_2.setBounds(0, 189, 972, 48);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.add(panel_2);
		panel_2.setLayout(null);
		ActionListener jkl = new lsnrBtn();
		ActionListener nkk = new lsnrBtn();

		companycode = new JTextField();
		companycode.setBounds(709, 9, 56, 25);
		companycode.setForeground(new Color(0, 51, 0));
		companycode.setBackground(Color.WHITE);
		companycode.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		companycode.setEditable(false);
		panel.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setBounds(764, 9, 63, 25);
		companyname.setForeground(new Color(0, 51, 0));
		companyname.setBackground(Color.WHITE);
		companyname.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		companyname.setEditable(false);
		panel.add(companyname);
		companyname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Doc.no");
		lblNewLabel_1.setBounds(0, 13, 75, 16);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		panel.add(lblNewLabel_1);

		docno = new JTextField();
		docno.setBounds(87, 9, 56, 25);
		docno.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		docno.setForeground(new Color(0, 51, 0));
		docno.setBackground(Color.WHITE);
		panel.add(docno);
		docno.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Doc Type");
		lblNewLabel_2.setBounds(288, 53, 56, 16);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		panel.add(lblNewLabel_2);

		bankpanel = new JPanel();
		bankpanel.setBounds(20, 38, 926, 54);
		bankpanel.setBackground(Color.WHITE);
		bankpanel.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel.add(bankpanel);
		bankpanel.setLayout(null);

		// bankname = new JTextField()
		bankname = new gnRoundTextField(20) {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		bankname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bankname.setBounds(106, 20, 327, 30);
		bankpanel.add(bankname);
		bankname.setEditable(true);
		bankname.setColumns(10);

		JLabel lblBankCode = new JLabel("Select Bank");
		lblBankCode.setForeground(new Color(0, 0, 153));
		lblBankCode.setBounds(197, -1, 152, 20);
		bankpanel.add(lblBankCode);
		lblBankCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBankCode.setHorizontalAlignment(SwingConstants.CENTER);

		comboTrType = new JComboBox();
		comboTrType.setBounds(0, 20, 104, 30);
		bankpanel.add(comboTrType);
		comboTrType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboTrType.setModel(new DefaultComboBoxModel(new String[] { "Deposits", "Withdraw", "Transfer" }));

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setForeground(new Color(0, 0, 153));
		lblAmount.setBounds(493, 3, 56, 16);
		bankpanel.add(lblAmount);
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));

		// amount = new JTextField();
		amount = new gnRoundTextField(200);
		amount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		amount.setBounds(478, 20, 104, 30);
		bankpanel.add(amount);
		amount.setColumns(10);

		JLabel lblType = new JLabel("Transaction Type");
		lblType.setBounds(2, 1, 137, 16);
		bankpanel.add(lblType);
		lblType.setForeground(new Color(0, 0, 153));
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 13));

		// bankcode = new JTextField();
		bankcode = new gnRoundTextField(20);
		bankcode.setBounds(433, 20, 46, 30);
		bankpanel.add(bankcode);
		bankcode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bankcode.setColumns(10);
		
				paymentpanel = new JPanel();
				paymentpanel.setBounds(594, -1, 329, 54);
				bankpanel.add(paymentpanel);
				paymentpanel.setBackground(Color.CYAN);
				paymentpanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.GREEN, Color.DARK_GRAY, null, null));
				paymentpanel.setLayout(null);
				
						JLabel lblPaymentType = new JLabel("Instrument Type");
						lblPaymentType.setBounds(12, 1, 101, 16);
						lblPaymentType.setForeground(new Color(0, 0, 153));
						lblPaymentType.setFont(new Font("Tahoma", Font.PLAIN, 13));
						paymentpanel.add(lblPaymentType);
						
								comboPType = new JComboBox();
								comboPType.setBounds(9, 20, 104, 30);
								comboPType.setFont(new Font("Tahoma", Font.PLAIN, 14));
								paymentpanel.add(comboPType);
								comboPType.setModel(new DefaultComboBoxModel(new String[] { "Cash", "Cheque", "Demand Draft" }));
								
										JLabel lblChqddNo = new JLabel("Instrument No.");
										lblChqddNo.setBounds(125, 1, 91, 16);
										lblChqddNo.setForeground(new Color(0, 0, 153));
										lblChqddNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
										paymentpanel.add(lblChqddNo);
										
												JLabel lblChqddDate = new JLabel("Instrument Date");
												lblChqddDate.setBounds(230, 0, 105, 16);
												lblChqddDate.setForeground(new Color(0, 0, 153));
												lblChqddDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
												paymentpanel.add(lblChqddDate);
												
														chqnumber = new JTextField();
														chqnumber.setBounds(125, 20, 104, 30);
														chqnumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
														paymentpanel.add(chqnumber);
														chqnumber.setColumns(10);
														
																chqdate = new JTextField();
																chqdate.setBounds(233, 20, 84, 30);
																chqdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
																paymentpanel.add(chqdate);
																chqdate.setColumns(10);
																comboPType.addActionListener(pmt);

		JLabel lblAccno = new JLabel("Acc.No");
		lblAccno.setBounds(760, 9, 56, 16);
		lblAccno.setForeground(Color.WHITE);
		lblAccno.setVisible(false);
		panel.add(lblAccno);
		lblAccno.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel = new JLabel("Acc.Balance");
		lblNewLabel.setBounds(750, 33, 77, 16);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setVisible(false);
		panel.add(lblNewLabel);

		acno = new JTextField();
		acno.setBounds(850, 0, 84, 22);
		panel.add(acno);
		acno.setEnabled(false);
		acno.setEditable(false);
		acno.setColumns(10);

		clbal = new JTextField();
		clbal.setBounds(849, 24, 85, 22);
		panel.add(clbal);
		clbal.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		clbal.setForeground(new Color(0, 0, 153));
		clbal.setEnabled(false);
		clbal.setColumns(10);

		bankpanel1 = new JPanel();
		bankpanel1.setBounds(20, 105, 624, 27);
		panel.add(bankpanel1);
		bankpanel1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.GREEN, null, null));
		bankpanel1.setBackground(new Color(255, 255, 204));
		bankpanel1.setLayout(null);
		lblPartyCode = new JLabel("Transfer to Bank");
		lblPartyCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPartyCode.setBounds(12, 5, 126, 16);
		bankpanel1.add(lblPartyCode);
		lblPartyCode.setHorizontalAlignment(SwingConstants.RIGHT);

		partyname = new JTextField();
		partyname.setFont(new Font("Arial Black", Font.PLAIN, 14));
		partyname.setBounds(150, 0, 421, 25);
		bankpanel1.add(partyname);
		partyname.setColumns(10);
		
				partycode = new JTextField();
				partycode.setBounds(569, 1, 50, 25);
				bankpanel1.add(partycode);
				partycode.setFont(new Font("Tahoma", Font.PLAIN, 15));
				partycode.setText("0");
				partycode.setEditable(false);
				partycode.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Bank Transaction");
		lblNewLabel_3.setBounds(500, 6, 166, 16);
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		panel.add(lblNewLabel_3);
		
				btnEdit = new JButton("Edit-Voucher");
				btnEdit.setBounds(288, 9, 114, 28);
				panel.add(btnEdit);
				btnEdit.setMnemonic('E');
				btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 13));
				btnEdit.addActionListener(nkk);
 		ActionListener cncl = new lsnrBtn();

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 187, 952, 418);
		frmBusinessApplication.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		sjsp = new JScrollPane();
		sjsp.setViewportBorder(UIManager.getBorder("PopupMenu.border"));
		sjsp.setBounds(0, 26, 947, 392);
		panel_1.add(sjsp);

		btnSave = new JButton("Save");
		btnSave.setBounds(384, 1, 97, 28);
		panel_1.add(btnSave);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave.setMnemonic('S');

		btnAcEntry = new JButton("Account Entry");
		btnAcEntry.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAcEntry.setBounds(482, 1, 122, 28);
		panel_1.add(btnAcEntry);
		btnAcEntry.setMnemonic('A');

		btnHis = new JButton("View Data");
		btnHis.setBounds(604, 1, 97, 28);
		panel_1.add(btnHis);
		btnHis.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnHis.setForeground(new Color(0, 0, 51));
		btnHis.setMnemonic('V');

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(840, 1, 107, 28);
		panel_1.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancel.setMnemonic('C');

		btnExport = new JButton("Export Data");
		btnExport.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExport.setBounds(702, 1, 139, 28);
		panel_1.add(btnExport);

		btnCancel.addActionListener(cncl);
		btnAcEntry.addActionListener(nkk);
		btnSave.addActionListener(nkk);
 		btnExport.addActionListener(nkk);
 		btnHis.addActionListener(nkk);
 		
		JLabel lblRemark = new JLabel("Remark ");
		lblRemark.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRemark.setForeground(new Color(0, 0, 153));
		lblRemark.setBounds(0, 168, 56, 16);
		frmBusinessApplication.getContentPane().add(lblRemark);
		lblRemark.setHorizontalAlignment(SwingConstants.RIGHT);

		remark = new JTextField();
		remark.setFont(new Font("Tahoma", Font.PLAIN, 13));
		remark.setBounds(59, 148, 892, 39);
		frmBusinessApplication.getContentPane().add(remark);
		remark.setColumns(10);
		
		hjsp = new JScrollPane();
		hjsp.setBounds(953, 45, 397, 560);
		frmBusinessApplication.getContentPane().add(hjsp);
 		ActionListener trlsrn = new tranLsnr();
		comboTrType.addActionListener(trlsrn);
		partyname.addActionListener(abc);
		bankname.addActionListener(bnk);

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
		chekcFreezeYear();
		this.checkInternet();
		frmBusinessApplication.setUndecorated(true);

		new gnApp().setFrameTitel(frmBusinessApplication);
 		new gnField().closeform(btnSave, frmBusinessApplication);
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		vcomp = companycode.getText();
		storecode.setText(new gnConfig().getStoreID());
 		vstore = storecode.getText();
 		String value = storecode.getText();
		storename.setText(new gnConfig().getStorename(value));

		storename.setVisible(false);
		storecode.setVisible(false);
		companycode.setVisible(false);
		companyname.setVisible(false);

		
		String vpara29 = "29";
		String vEditDocumentAllow = new getConfigurationSetting().getSpecificConfiguration(vpara29);
		switch (vEditDocumentAllow) {
		case "N":
			btnEdit.setVisible(false);
		}

 		
		switch (vcomp) {
		case "0":
			System.exit(0);
		}

		trdate.setText(new gnConfig().getDaybeginDate());
 		String vtype = "CO";
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
			btnSave.setVisible(false);
			break;
		}

		int typecode = 1;
		new gnDecorate().SetSeqHdrButton(btnAcEntry, 1);
		new gnDecorate().SetSeqHdrButton(btnSave, 1);
		new gnDecorate().SetSeqHdrButton(btnCancel, 1);
		new gnDecorate().SetSeqHdrButton(btnExport, 1);
		new gnDecorate().SetSeqHdrButton(btnEdit, 1);
		new gnDecorate().SetSeqHdrButton(btnHis, 1);

  		String vbank = bankcode.getText();
 		acno.setVisible(false);
		clbal.setVisible(false);
		vverticle = new gnHierarchy().getVerticleCode();
		vverticle = new gnHierarchy().getVerticleCode();
		bankpanel1.setVisible(false);
		paymentpanel.setVisible(false);

		new gnDecorate().DispField_Eatch(companycode, 2);
		new gnDecorate().DispField_Eatch(companyname, 2);
		new gnDecorate().DispField_Eatch(storecode, 2);
		new gnDecorate().DispField_Eatch(storename, 2);
		new gnDecorate().DispField_Eatch(bankcode, 2);
		new gnDecorate().DispField_Eatch(bankname, 2);
		new gnDecorate().DispField_Eatch(trdate, 2);
		new gnDecorate().DispField_Eatch(acno, 2);
		new gnDecorate().DispField_Eatch(amount, 2);
		btnSave.setEnabled(true);
		partycode.setText("0");

	}

	class tranLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vtrtype = (String) comboTrType.getSelectedItem();
			switch (vtrtype) {
			// "Deposits", "Widraw" , "Transafer"
			case "Deposits":
				bankpanel1.setVisible(false);
				paymentpanel.setVisible(true);
				partycode.setText("0");
				break;
			case "Widraw":
				bankpanel1.setVisible(false);
				partycode.setText("0");
				paymentpanel.setVisible(true);
				break;
			case "Transfer":
				bankpanel1.setVisible(true);
				paymentpanel.setVisible(false);
				break;

			}
		}
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
			try {
				vchoice = "BANK";
				searchData();
  				//new gnAccountGetGLofGivenGroup().getAllGLofGroup(vtype, sname);
 			} catch (Throwable e1) {
 				e1.printStackTrace();
			} finally {
  				//bankcode.setText(new gnAccountGetGLofGivenGroup().vcode);
				//bankname.setText(new gnAccountGetGLofGivenGroup().vname);
				//amount.grabFocus();
				//new gnAccountGetGLofGivenGroup().vname = null;
				//new gnAccountGetGLofGivenGroup().vcode = null;
				//btnHis.doClick();
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
			String vtype = "BANK";
			try {

				vchoice = "Party" ;
				searchData();
				//new gnAccountGetGLofGivenGroup().getAllGLofGroup(vtype, sname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				//partycode.setText(new gnAccountGetGLofGivenGroup().vcode);
				//partyname.setText(new gnAccountGetGLofGivenGroup().vname);
				//amount.grabFocus();
				//new gnAccountGetGLofGivenGroup().vname = null;
				//new gnAccountGetGLofGivenGroup().vcode = null;
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
			if (value == "Cancel") {
				reset();
				frmBusinessApplication.dispose();
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
			
 
			if (value == "Edit-Voucher") {
				try {
					startEditProcess();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
			
			if (value == "Export Data") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

			if (value == "Account Entry") {

				String vtype = "CON";
				String vdocno = docno.getText();
				String vdocdate = trdate.getText();
				try {
					if (vdocno.length() > 0) {
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
					}
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
				}
			}

			if (value == "Save") {
				try {
					String vstatus = validate();
					if (vstatus == "Sucess") {
						switch (voucherMode) {
						case "E":
							String vvdoctype = "CON";
							String vdocno = docno.getText();
							String vvdocdate = trdate.getText();
							new gnEDMiddleWare().ContraEntryModification(vvdoctype, vdocno, vvdocdate);
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	

	private String checkVendor() {
		String status = "Sucess";
		String vparty = bankname.getText();
		if (vparty.length() == 0) {
			new General().msg("Select Bank To View Data");
			status = "Fail";
		}
		return status;
	}

	private void startEditProcess() throws Throwable {
		voucherMode = "E";
		chekcFreezeYear();
		// panel.setBackground(Color.WHITE);
		internalFrame.setTitle("Edit - Payment Voucher");
		String vbank = bankcode.getText();
		// String vparty = partycode.getText() ;
		String vtype = "CON";
		new gnVoucher().ShowVouchers(vtype, vbank);
		docno.setText(new gnVoucher().vdocno);
		trdate.setText(new gnVoucher().vdocdate);
		chqnumber.setText(new gnVoucher().vinstrno);
		chqdate.setText(new gnVoucher().vinstrdate);
		comboPType.setSelectedItem(new gnVoucher().vpaymentMode);
		amount.setText(new gnVoucher().vamount);
		bankcode.setText(new gnVoucher().vbankcode);
		bankname.setText(new gnVoucher().vbankname);
		comboTrType.setSelectedItem(new gnVoucher().vtrtype);
		paymentpanel.setVisible(true);
		if (new gnVoucher().vtrtype == "Transfer") {
			bankpanel1.setVisible(true);
		}

	}

	public void callEditProcess() throws Throwable {
		voucherMode = "E";
		// panel.setBackground(Color.WHITE);
		internalFrame.setTitle("Edit - Payment Voucher");
		String vbank = bankcode.getText();
		// String vparty = partycode.getText() ;
		String vtype = "CON";
		// new gnVoucher().ShowVouchers(vtype, vbank);
		docno.setText(new gnVoucher().vdocno);
		trdate.setText(new gnVoucher().vdocdate);
		chqnumber.setText(new gnVoucher().vinstrno);
		chqdate.setText(new gnVoucher().vinstrdate);
		comboPType.setSelectedItem(new gnVoucher().vpaymentMode);
		amount.setText(new gnVoucher().vamount);
		bankcode.setText(new gnVoucher().vbankcode);
		bankname.setText(new gnVoucher().vbankname);
		comboTrType.setSelectedItem(new gnVoucher().vtrtype);
		paymentpanel.setVisible(true);
		if (new gnVoucher().vtrtype == "Transfer") {
			bankpanel1.setVisible(true);
		}
		btnEdit.setVisible(true);
		new gnStyleButton().getStyleButton(btnEdit, Color.gray, Color.WHITE);

	}

	private String validate() {
		// Deposits
		// Widraw
		// Transfer
		String status = "Sucess";

		Double vamt = Double.parseDouble(amount.getText());

		status = new gnTable().isAmountnegative(amount.getText());
		if (status == "Fail") {
			amount.grabFocus();
		}

		if (bankcode.getText().length() == 0) {
			status = "Fail";
			new General().msg("Select Party ..");
			return status;
		}

		vtrantype1 = comboTrType.getSelectedItem().toString();
		switch (vtrantype1) {
		case "Transfer":
			if (bankcode.getText().length() == 0) {
				new General().msg("Select  Bank For Transfers");
				status = "Fail";
			}
			if (partycode.getText() == "0") {
				new General().msg("Select  Bank For Transfers");
				status = "Fail";
			}
			if (partyname.getText().length() == 0) {
				new General().msg("Select  Bank For Transfers");
				status = "Fail";
				partyname.grabFocus();
			}
			break;

		case "Withdraw":
			partycode.setText("0");
			break;

		case "Deposits":
			partycode.setText("0");
			break;

		}
		String vpaymenttype1;

		if (bankname.getText().length() == 0) {
			new General().msg("Select Bank Code");
			status = "Fail";
		}

		// if (partyname.getText().length() == 0 )
		/// {
		// new General().msg("Select Party Code ");
		// status = "Fail" ;
		// }

		if (amount.getText().length() == 0) {
			new General().msg("Enter Amount");
			status = "Fail";
			amount.grabFocus();
		}
		String vptype = (String) comboPType.getSelectedItem();
		if ((vptype == "Cheque" || vptype == "Demand Draft") && (amount.getText().length() == 0
				|| chqnumber.getText().length() == 0 || chqdate.getText().length() == 0)) {

			new gnImageSound().playSound();
			new General().msg("Check ( DD/CHQ Number OR Amount  OR Date Fields Can Not Be Empty)");
			status = "Fail";
		}
		vptype = "";
		return status;
	}

	public void SaveData() throws Throwable {
		String Status = "";
		String vpmtselected = comboPType.getSelectedItem().toString();
		vtrantype1 = comboTrType.getSelectedItem().toString();
		if (vtrantype1 == "Transfer") {
			vpmtselected = "Transfer";
		}
		String vtrtype = comboTrType.getSelectedItem().toString();
		String vchqno = chqnumber.getText();
		String vchqdate = chqdate.getText();
		String vtran = "109";
		String vtype = "TR";
		try {
			switch (voucherMode) {
			case "I":
				docno.setText(new gnSeq().getSeqno(vtran, vtype));
				break;
			case "E":
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
			prst.setString(2, storecode.getText());
			prst.setString(3, bankcode.getText());
			prst.setString(4, bankname.getText());
			prst.setString(5, new gnConfig().date_ConverttoDBforamt(trdate.getText()));
			prst.setString(6, vtrtype);
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
			prst.setString(17, "CO");
			prst.setString(18, docno.getText());
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
			if (prst != null) {
				prst.close();
				try {
					switch (voucherMode) {
					case "I":
						new gnSeq().updateSeqno(vtran, vtype);
						break;
					case "E":
					}
					postjournalEntery();
					new General().msg("Data Saved Sucessfully");
				} catch (Throwable e) {
					e.printStackTrace();
				}
				reset();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	private void postjournalEntery() throws Throwable {

		String vpmode = comboPType.getSelectedItem().toString().trim();
		String vchqno = chqnumber.getText();
		String vchqdate = chqdate.getText();
		vdocno = docno.getText();
		vdocdate = trdate.getText();
		vamount = amount.getText();
		String vtrtype = (String) comboTrType.getSelectedItem();
		String vdocdate2 = new gnConfig().date_ConverttoDBforamt(trdate.getText());

		// New Logic backend Accouunt entry posting
		new gnGSTMiddleWare().backend_DocaccountContraPosting(vdocno, vdocdate, vamount);
		// End New Logic backend Accouunt entry posting
		reset();
	}

	private void reset() {
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
		btnSave.setEnabled(true);
		bankname.grabFocus();
		try {
			//setStandardData();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void btnDisable() {
		btnSave.setEnabled(true);
		btnCancel.setEnabled(true);
		new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnCancel, Color.BLUE, Color.WHITE);

	}

	private void blockChqDetail() {
		chqnumber.setEditable(false);
		chqdate.setEditable(false);

	}

	private void openChqDetail() {
		chqnumber.setEditable(true);
		chqdate.setEditable(true);

	}
	
	
	

	private void ShowView() throws Throwable {
		new gnTable().RemoveTableRows(smodel);
		String col[] = {   "Doc.No", "Doc.Date", "Mode", "Instrumentno", "Inst.Date", "Amount" , "Type" , "GLCode" , "Gl.Name"};
		smodel.setColumnIdentifiers(col);
		String vtype = "Bank";
		String vparty = bankcode.getText();
		vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call voucher_viewData('" + vtype + "', " + vcomp + ", " + vstore + ", " + vparty + ")";
	    new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			smodel.addRow(new Object[] {    rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
					rs.getString(7), rs.getString(8), rs.getString(9) });
		}
		stable.setModel(smodel);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(prt6);
		prt6.setToolTipText("Bank Data");
		prt6.setScrollMode(0);
		prt6.add(stable, col);
		prt6.setBackground(Color.WHITE);
		new gnTable().setTableBasics(stable);

	}
	
	
	

	private void searchData() throws Throwable {

		String Col[] = { "Type", "Code", "Name", "Op.Bal", "DrCr", "Curr.Bal", "Drcr", "Acc.GrpCode", "Acc.Group",
				"Taxcode" };
		new gnTable().RemoveTableRows(hmodel);
		hmodel.setColumnIdentifiers(Col);
		String vparty = partyname.getText();
		String sname = partyname.getText().trim();
		sname = "%" + sname + "%";
		String vtype = "Party";
		vtype = "BANK";
		htable = new gnAccountGetGLofGivenGroup().getAllGLofGroupinTable(vtype, sname);
		JViewport prt66 = new JViewport();
		hjsp.setViewport(prt66);
		prt66.setToolTipText("ScrollPaneport");
		prt66.setScrollMode(0);
		prt66.add(htable);
		hjsp.setVisible(true);
		new gnTable().setTableBasics(htable);
		new gnTable().setTableColWidth(htable, 2, 200);
		Selectrow1();

	}

	public void Selectrow1() {
		htable.requestFocus();
		htable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		htable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = htable.getSelectedRow();
				String value = (String) htable.getValueAt(row, 0);
				try {
 				switch(vchoice)
				{
 					case "Party" :
					partycode.setText(htable.getValueAt(row, 1).toString());
					partyname.setText(htable.getValueAt(row, 2).toString());
					amount.grabFocus();
					btnHis.doClick();
					hjsp.setVisible(false);
					break ;
 					case "BANK" :
 	  				bankcode.setText(htable.getValueAt(row, 1).toString());
					bankname.setText(htable.getValueAt(row, 2).toString());
					amount.grabFocus();
					hjsp.setVisible(false);
 					break ;
				}
 					} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	
	
	
}// last

package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

//

public class IncomeVoucher extends getResultSet {

	JFrame frmIncome;
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
	public JInternalFrame internalFrame;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncomeVoucher window = new IncomeVoucher();
					window.frmIncome.setVisible(true);
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
	public IncomeVoucher() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frmIncome = new JFrame();
		frmIncome.setAlwaysOnTop(true);
		frmIncome.setTitle("Business Application");
		// frmIncome.setBounds(100, 250, 1011, 459);
		// frmIncome.setBounds(5, 220, 1350, 500);
		frmIncome.setBounds(1, 90, 1350, 605);

		frmIncome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmIncome.getContentPane().setLayout(null);
		frmIncome.getContentPane().setLayout(null);
		ActionListener cncl = new lsnrBtn();

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.window, null));
		panel.setBounds(0, 0, 900, 214);
		frmIncome.getContentPane().add(panel);
		panel.setLayout(null);

		storecode = new JTextField();
		storecode.setBackground(Color.DARK_GRAY);
		storecode.setForeground(Color.WHITE);
		storecode.setEditable(false);
		storecode.setFont(new Font("Calibri", Font.BOLD, 13));
		storecode.setBounds(645, 39, 56, 25);
		panel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setBackground(Color.DARK_GRAY);
		storename.setForeground(Color.WHITE);
		storename.setFont(new Font("Calibri", Font.BOLD, 13));
		storename.setBounds(700, 39, 44, 25);
		storename.setEditable(false);
		panel.add(storename);
		storename.setColumns(10);
		ActionListener bnk = new lsnrbankName();
		ActionListener pmt = new lsnrpmtType();
		ActionListener abc = new lsnrCustName();
		ActionListener jkl = new lsnrBtn();
		ActionListener nkk = new lsnrBtn();

		companycode = new JTextField();
		companycode.setBackground(Color.DARK_GRAY);
		companycode.setForeground(Color.WHITE);
		companycode.setFont(new Font("Calibri", Font.BOLD, 13));
		companycode.setEditable(false);
		companycode.setBounds(745, 39, 56, 25);
		panel.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setBackground(Color.DARK_GRAY);
		companyname.setForeground(Color.WHITE);
		companyname.setFont(new Font("Calibri", Font.BOLD, 13));
		companyname.setEditable(false);
		companyname.setBounds(801, 39, 43, 25);
		panel.add(companyname);
		companyname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Income  Vou.No");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(149, 43, 108, 16);
		panel.add(lblNewLabel_1);

		paymentvno = new JTextField();
		paymentvno.setBackground(Color.DARK_GRAY);
		paymentvno.setForeground(Color.WHITE);
		paymentvno.setFont(new Font("Arial", Font.BOLD, 14));
		paymentvno.setBounds(262, 39, 56, 30);
		panel.add(paymentvno);
		paymentvno.setColumns(10);

		trdate = new JTextField();
		trdate.setBackground(Color.DARK_GRAY);
		trdate.setForeground(Color.WHITE);
		trdate.setFont(new Font("Arial", Font.BOLD, 14));
		trdate.setEditable(false);
		trdate.setBounds(317, 39, 108, 30);
		panel.add(trdate);
		trdate.setColumns(10);

		JPanel panel_201 = new JPanel();
		panel_201.setBorder(null);
		panel_201.setBackground(Color.WHITE);
		panel_201.setBounds(130, 69, 752, 43);
		panel.add(panel_201);
		panel_201.setLayout(null);

		JLabel lblPartyCode = new JLabel("Ledger Code");
		lblPartyCode.setBounds(6, 12, 88, 16);
		panel_201.add(lblPartyCode);
		lblPartyCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPartyCode.setHorizontalAlignment(SwingConstants.RIGHT);

		// partyname = new JTextField() {
		// public void addNotify() {
		// super.addNotify();
		// requestFocus();
		// }
		// };

		partyname = new gnRoundTextField(10) {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};

		partyname.setBounds(164, 6, 273, 30);
		panel_201.add(partyname);
		partyname.setForeground(new Color(0, 0, 128));
		partyname.setFont(new Font("Arial Black", Font.BOLD, 13));
		partyname.setColumns(10);

		btnEdit = new JButton("Edit-Voucher");
		btnEdit.setBounds(624, 4, 119, 28);
		btnEdit.setBackground(Color.cyan);
		btnEdit.setForeground(Color.BLACK);
		panel_201.add(btnEdit);
		btnEdit.setFont(new Font("Calibri", Font.BOLD, 14));
		btnEdit.setMnemonic('E');

		partycode = new JTextField();
		partycode.setBounds(441, 7, 72, 30);
		panel_201.add(partycode);
		partycode.setForeground(new Color(0, 0, 128));
		partycode.setFont(new Font("Arial Black", Font.BOLD, 13));
		partycode.setColumns(10);
		btnEdit.addActionListener(nkk);
		partyname.addActionListener(abc);

		JPanel panel_203 = new JPanel();
		panel_203.setBackground(Color.WHITE);
		panel_203.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel_203.setBounds(130, 117, 762, 66);
		panel.add(panel_203);
		panel_203.setLayout(null);

		JLabel lblBankCode = new JLabel("Bank");
		lblBankCode.setBounds(264, 14, 40, 20);
		lblBankCode.setForeground(new Color(0, 0, 102));
		panel_203.add(lblBankCode);
		lblBankCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBankCode.setHorizontalAlignment(SwingConstants.RIGHT);

		bankcode = new JTextField();
		bankcode.setBounds(220, 31, 61, 30);
		panel_203.add(bankcode);
		bankcode.setForeground(new Color(0, 0, 128));
		bankcode.setFont(new Font("Arial Black", Font.PLAIN, 15));
		bankcode.setEnabled(false);
		bankcode.setColumns(10);

		bankname = new JTextField();
		bankname.setBounds(276, 31, 261, 30);
		panel_203.add(bankname);
		bankname.setForeground(new Color(0, 0, 128));
		bankname.setFont(new Font("Arial Black", Font.PLAIN, 15));
		bankname.setEditable(true);
		bankname.setColumns(10);

		JLabel lblPaymentType = new JLabel("Payment Type");
		lblPaymentType.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaymentType.setBounds(6, 16, 105, 16);
		lblPaymentType.setForeground(new Color(0, 0, 102));
		panel_203.add(lblPaymentType);
		lblPaymentType.setFont(new Font("Tahoma", Font.BOLD, 12));

		comboPType = new JComboBox();
		comboPType.setBounds(6, 31, 105, 30);
		panel_203.add(comboPType);
		comboPType.setFont(new Font("Arial Black", Font.PLAIN, 12));
		comboPType.setModel(new DefaultComboBoxModel(new String[] { "Cash", "Cheque", "Demand Draft", "NEFT" }));

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(125, 16, 80, 16);
		lblAmount.setForeground(new Color(0, 0, 102));
		panel_203.add(lblAmount);
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 12));

		amount = new JTextField();
		amount.setFont(new Font("Arial Black", Font.PLAIN, 15));
		amount.setBounds(115, 31, 110, 30);
		panel_203.add(amount);
		amount.setText("0");
		amount.setColumns(10);

		JLabel lblChqddNo = new JLabel("Instrument No");
		lblChqddNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblChqddNo.setBounds(544, 16, 94, 16);
		lblChqddNo.setForeground(new Color(0, 0, 102));
		panel_203.add(lblChqddNo);
		lblChqddNo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		chqnumber = new JTextField();
		chqnumber.setFont(new Font("Arial Black", Font.PLAIN, 15));
		chqnumber.setBounds(544, 31, 94, 30);
		panel_203.add(chqnumber);
		chqnumber.setColumns(10);

		chqdate = new JTextField();
		chqdate.setFont(new Font("Arial Black", Font.PLAIN, 15));
		chqdate.setBounds(641, 31, 121, 30);
		panel_203.add(chqdate);
		chqdate.setColumns(10);

		JLabel lblChqddDate = new JLabel("Instrument Date");
		lblChqddDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblChqddDate.setBounds(650, 16, 122, 16);
		lblChqddDate.setForeground(new Color(0, 0, 102));
		panel_203.add(lblChqddDate);
		lblChqddDate.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblRemark = new JLabel("Remark ");
		lblRemark.setForeground(new Color(0, 0, 102));
		lblRemark.setBounds(95, 186, 61, 28);
		panel.add(lblRemark);
		lblRemark.setFont(new Font("Calibri", Font.BOLD, 13));
		lblRemark.setHorizontalAlignment(SwingConstants.RIGHT);

		remark = new JTextField();
		remark.setBounds(156, 186, 674, 25);
		panel.add(remark);
		remark.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Income Voucher");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(12, 39, 215, 30);
		panel.add(lblNewLabel_3);

		JLabel lblType = new JLabel("Type");
		lblType.setBounds(515, 42, 34, 16);
		panel.add(lblType);

		comboTrType = new JComboBox();
		comboTrType.setBounds(545, 39, 88, 25);
		panel.add(comboTrType);
		comboTrType.setEnabled(false);
		comboTrType.setFont(new Font("Calibri", Font.BOLD, 13));
		comboTrType.setEditable(true);
		comboTrType.setModel(new DefaultComboBoxModel(new String[] { "Income" }));

		panel7 = new JPanel();
		panel7.setBounds(684, 0, 198, 28);
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
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { partyname, comboTrType, comboPType, amount, remark, bankname }));
		comboPType.addActionListener(pmt);
		bankname.addActionListener(bnk);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 218, 1328, 374);
		frmIncome.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		sjsp = new JScrollPane();
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(1, 13, 1327, 361);
		panel_1.add(sjsp);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(897, 173, 75, 43);
		frmIncome.getContentPane().add(btnSave);
		btnSave.setMnemonic('S');

		btnHis = new JButton("View Data");
		btnHis.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHis.setBounds(972, 173, 97, 43);
		frmIncome.getContentPane().add(btnHis);
		btnHis.setForeground(new Color(0, 0, 51));
		btnHis.setMnemonic('V');

		btnCancel = new JButton("Close");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCancel.setBounds(1265, 174, 67, 49);
		frmIncome.getContentPane().add(btnCancel);
		btnCancel.setMnemonic('C');

		btnExport = new JButton("Export Data");
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnExport.setBounds(1173, 174, 91, 43);
		frmIncome.getContentPane().add(btnExport);
		btnExport.setMnemonic('E');

		btnAcEntry = new JButton("Account Entry");
		btnAcEntry.setMnemonic('A');
		btnAcEntry.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnAcEntry.setBounds(1069, 174, 105, 43);
		frmIncome.getContentPane().add(btnAcEntry);
		
		JTextPane txtpnselectLegerCode = new JTextPane();
		txtpnselectLegerCode.setText("1.Select Leger Code\r\n2.Select Payment Mode \r\n3.If Payment Mode is Bank then Select Bank \r\n4.Enter Amout\r\n5.Save Data");
		txtpnselectLegerCode.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtpnselectLegerCode.setBounds(912, 13, 408, 147);
		frmIncome.getContentPane().add(txtpnselectLegerCode);

		btnAcEntry.addActionListener(nkk);
		btnCancel.addActionListener(cncl);
		btnSave.addActionListener(nkk);
		btnHis.addActionListener(nkk);
		btnExport.addActionListener(nkk);

		// FocusListener gg = new btnfocus();
		// partyname.addFocusListener(gg);

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
		this.checkInternet();
		frmIncome.setUndecorated(true);
		// new General().handleKeys();
		String vpara29 = "29";
		chekcFreezeYear();
		String vEditDocumentAllow = new getConfigurationSetting().getSpecificConfiguration(vpara29);
		switch (vEditDocumentAllow) {
		case "N":
			btnEdit.setVisible(false);
		}

		trdate.setText(new gnConfig().getDaybeginDate());
		String vtype = "IN";
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

		new gnApp().setFrameTitel(frmIncome);
		new gnField().closeform(btnSave, frmIncome);
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		storecode.setText(new gnConfig().getStoreID());
		storename.setText(new gnConfig().getStoreName());
		String value = storecode.getText();
		vstore = storecode.getText();
		vcomp = companycode.getText();

		storecode.setVisible(false);
		storename.setVisible(false);
		companycode.setVisible(false);
		companyname.setVisible(false);
		btnSave.setEnabled(true);
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
			// showLedger() ;
			try {
				searchData();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	private void showLedger() {
		String sname = partyname.getText().trim();
		sname = "%" + sname + "%";
		String vtype = "INCOME"; // "Party" ;
		try {
			new gnAccountGetGLofGivenGroup().getAllGLofGroup(vtype, sname);
		} catch (Throwable e1) {
			e1.printStackTrace();
		} finally {
			partycode.setText(new gnAccountGetGLofGivenGroup().vcode);
			partyname.setText(new gnAccountGetGLofGivenGroup().vname);
			amount.grabFocus();
			btnHis.doClick();
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

			if (value == "Export Data") {
				new Export_Table_Data_to_Excel().exportTable(stable);
			}

			if (value == "Close") {
				frmIncome.dispose();
			}

			if (value == "Account Entry") {

				String vtype = "IN";
				String vdocno = paymentvno.getText();
				String vdocdate = trdate.getText();
				try {
					if (vdocno.length() > 0) {
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
					}
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
							String vvdoctype = "IN";
							String vdocno = paymentvno.getText();
							String vvdocdate = trdate.getText();
							new gnEDMiddleWare().IncomeVoucherModification(vvdoctype, vdocno, vvdocdate);
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
		internalFrame.setTitle("Edit - Income  Voucher");
		String vparty = partycode.getText();
		String vtype = "IN";
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
		internalFrame.setTitle("Edit - Expense Voucher");
		String vparty = partycode.getText();
		String vtype = "IN";
		// new gnVoucher().ShowVouchers(vtype, vparty);
		paymentvno.setText(new gnVoucher().vdocno);
		trdate.setText(new gnVoucher().vdocdate);
		chqnumber.setText(new gnVoucher().vinstrno);
		chqdate.setText(new gnVoucher().vinstrdate);
		comboPType.setSelectedItem(new gnVoucher().vpaymentMode);
		amount.setText(new gnVoucher().vamount);
		// partycode.setText(new gnVoucher().rglcode) ;
		// partyname.setText(new gnVoucher().rglname) ;
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

 
	public void SaveData() throws Throwable {
		String Status = "";
		String vpmtselected = comboPType.getSelectedItem().toString();
		String vchqno = chqnumber.getText();
		String vchqdate = chqdate.getText();
		// String vtran = "110" ;
		String vtran = "111";
		String vtype = "TR";
		try {
			switch (voucherMode) {
			case "I":
				paymentvno.setText(new gnSeq().getSeqno(vtran, vtype));
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
			prst.setString(1, vcomp);
			prst.setString(2, storecode.getText());
			prst.setString(3, bankcode.getText());
			prst.setString(4, bankname.getText());
			prst.setString(5, new gnConfig().date_ConverttoDBforamt(trdate.getText()));
			prst.setString(6, "Income");
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
			prst.setString(17, "IN");
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
					new General().msg("Data Saved SucegnEDssfully");
					postjournalEntery();
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

	private void postjournalEntery() throws Throwable {

		String vdocdate1 = trdate.getText();
		String vamount = amount.getText();
		String vdocno = paymentvno.getText();
		new gnGSTMiddleWare().backend_DocaccountIncomePosting(vdocno, vdocdate1, vamount);
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
		amount.setText(null);
		partyname.grabFocus();
		decorate();
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

	/// Focus Management

	class btnfocus implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {

			if (partyname.isFocusOwner()) {
				partyname.setBackground(Color.darkGray);
				partyname.setForeground(Color.WHITE);
				showLedger();
 			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			partyname.setBackground(Color.white);
			partyname.setForeground(Color.BLACK);
		}
	}

	
	private void ShowView() throws Throwable {
 		new gnTable().RemoveTableRows(smodel);
		String col[] = { "Doc.No", "Doc.Date", "Mode", "Instrumentno", "Inst.Date", "Amount", "Gl", "Name" };
		smodel.setColumnIdentifiers(col);
		String vtype = "IN";
		String vparty = partycode.getText();
		String SQL = "call voucher_viewData('" + vtype + "', " + vcomp + ", " + vstore + ", " + vparty + ")";
		new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {

			smodel.addRow(new Object[] {  rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
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

	
	private void searchData() throws Throwable {
 
		String Col[] = { "Type", "Code", "Name", "Op.Bal", "DrCr", "Curr.Bal", "Drcr", "Acc.GrpCode", "Acc.Group",
				"Taxcode" };
		new gnTable().RemoveTableRows(smodel);
		smodel.setColumnIdentifiers(Col);
		String vparty = partyname.getText();
		String sname = partyname.getText().trim();
		sname = "%" + sname + "%";
		String vtype = "Party";
		vtype = "INCOME";
		stable = new gnAccountGetGLofGivenGroup().getAllGLofGroupinTable(vtype, sname);
		JViewport prt66 = new JViewport();
		sjsp.setViewport(prt66);
		prt66.setToolTipText("Income Voucher");
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
 				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				finally{
 					btnHis.doClick();
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
		vtype = "INCOME";
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

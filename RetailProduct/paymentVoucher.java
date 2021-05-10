package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.table.TableColumn;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import com.toedter.components.JSpinField;
import javax.swing.border.TitledBorder;
import javax.swing.JTextPane;

//

public class paymentVoucher extends getResultSet {

	JFrame frmpaymentvoucher;
	private String vcomp;
	private JToggleButton btnShow;
	private String vstore;
	private String vverticle;
	private JTextField acno;
	JPanel panel;
	private JTextField clbal;
	private JButton btnExport;
	private String voucherMode = "I";
	Connection con1;
	JButton btnEdit;
	private JTextField paymentvno;
	private JTextField trdate;
	private JTextField companycode;
	private JPanel panel7;
	private JTextField companyname;

	private JPanel PayentPanel;
	private JScrollPane pjsp;
	private JButton btnAdvance;
	private JButton btnDebitnote;
	private JButton btnCreditnote;
	private JButton btnDue;
	private JButton btnHistory;

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
	private JTable table = new JTable();
	private JTable searchtable = new JTable();
	private JTable stable = new JTable();
	private DefaultTableModel smodel = new DefaultTableModel();
	private DefaultTableModel model = new DefaultTableModel();

	private DefaultTableModel hmodel = new DefaultTableModel();
	private JTable htable = new JTable();

	private JScrollPane sjsp;
	public String party[] = { "Type", "Customer code", "Name", "Phone", "Email", "Credit Days" };
	public String bank[] = { "Store", "Bank_code", "Party Code", "Tr.Date", "Type", "Amount", "Payment Type", "Number",
			"Chq/dd Date", "Ramark", "Ac.No", "Bank Name" };
	public String banksearch[] = { "Type", "Bank Code", "Bank Name", "City", "Account_No", "Cl.Bal" };
	private JButton btnAcEntry;
	private JTextField GrnAmount;
	private JLabel lblNewLabel_4;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					paymentVoucher window = new paymentVoucher();
					window.frmpaymentvoucher.setVisible(true);
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
	public paymentVoucher() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frmpaymentvoucher = new JFrame();
		frmpaymentvoucher.getContentPane().setBackground(Color.WHITE);
		frmpaymentvoucher.setAlwaysOnTop(true);
		frmpaymentvoucher.setTitle("Business Application");
		// frmpaymentvoucher.setBounds(100, 100, 986, 491);
		// frmpaymentvoucher.setBounds(5, 220, 1350, 504);
		frmpaymentvoucher.setBounds(1, 90, 1350, 605);

		frmpaymentvoucher.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmpaymentvoucher.getContentPane().setLayout(null);
		frmpaymentvoucher.getContentPane().setLayout(null);
		ActionListener cncl = new lsnrBtn();

		panel = new JPanel();

		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 1338, 592);
		frmpaymentvoucher.getContentPane().add(panel);
		panel.setLayout(null);

		storecode = new JTextField();
		storecode.setHorizontalAlignment(SwingConstants.LEFT);
		storecode.setForeground(SystemColor.desktop);
		storecode.setBackground(Color.WHITE);
		storecode.setBounds(693, 42, 56, 25);
		storecode.setEditable(false);
		storecode.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		panel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setHorizontalAlignment(SwingConstants.LEFT);
		storename.setForeground(SystemColor.desktop);
		storename.setBackground(Color.WHITE);
		storename.setBounds(748, 42, 24, 25);
		storename.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		storename.setEditable(false);
		panel.add(storename);
		storename.setColumns(10);
		ActionListener bnk = new lsnrbankName();
		ActionListener pmt = new lsnrpmtType();
		ActionListener abc = new lsnrCustName();
		ActionListener jkl = new lsnrBtn();
		ActionListener nkk = new lsnrBtn();

		companycode = new JTextField();
		companycode.setHorizontalAlignment(SwingConstants.LEFT);
		companycode.setForeground(SystemColor.desktop);
		companycode.setBackground(Color.WHITE);
		companycode.setBounds(693, 19, 56, 25);
		companycode.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		companycode.setEditable(false);
		panel.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setHorizontalAlignment(SwingConstants.LEFT);
		companyname.setForeground(SystemColor.desktop);
		companyname.setBackground(Color.WHITE);
		companyname.setBounds(749, 19, 23, 25);
		companyname.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		companyname.setEditable(false);
		panel.add(companyname);
		companyname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Payment VNO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(132, 50, 164, 16);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		panel.add(lblNewLabel_1);

		paymentvno = new JTextField();
		paymentvno.setHorizontalAlignment(SwingConstants.LEFT);
		paymentvno.setForeground(SystemColor.desktop);
		paymentvno.setBackground(Color.WHITE);
		paymentvno.setBounds(308, 44, 56, 25);
		paymentvno.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		panel.add(paymentvno);
		paymentvno.setColumns(10);

		trdate = new JTextField();
		trdate.setHorizontalAlignment(SwingConstants.LEFT);
		trdate.setForeground(SystemColor.desktop);
		trdate.setBackground(Color.WHITE);
		trdate.setBounds(363, 44, 132, 25);
		trdate.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		trdate.setEditable(false);
		panel.add(trdate);
		trdate.setColumns(10);

		panel7 = new JPanel();
		panel7.setBounds(492, 0, 198, 66);
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
		panel_201.setBounds(25, 75, 840, 37);
		panel_201.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		panel_201.setBackground(Color.WHITE);
		panel.add(panel_201);
		panel_201.setLayout(null);

		JLabel lblType = new JLabel("Type");
		lblType.setBounds(518, 7, 34, 16);
		panel_201.add(lblType);

		comboTrType = new JComboBox();
		comboTrType.setBounds(548, 4, 88, 30);
		comboTrType.setEnabled(false);
		panel_201.add(comboTrType);
		comboTrType.setFont(new Font("Calibri", Font.BOLD, 13));
		comboTrType.setEditable(true);
		comboTrType.setModel(new DefaultComboBoxModel(new String[] { "Payments" }));

		JLabel lblPartyCode = new JLabel("Ledger Code");
		lblPartyCode.setForeground(new Color(0, 0, 153));
		lblPartyCode.setBounds(57, 10, 119, 24);
		panel_201.add(lblPartyCode);
		lblPartyCode.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblPartyCode.setHorizontalAlignment(SwingConstants.RIGHT);

		// partyname = new JTextField()
		partyname = new gnRoundTextField(20) {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		partyname.setToolTipText("Press Enter To Select  Account Ledger");
		partyname.setBounds(180, 4, 262, 30);
		panel_201.add(partyname);
		partyname.setForeground(new Color(0, 0, 128));
		partyname.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		partyname.setColumns(10);

		btnEdit = new JButton("Edit-Voucher");
		btnEdit.setBounds(653, 2, 119, 30);
		btnEdit.setBackground(Color.cyan);
		btnEdit.setForeground(Color.BLACK);
		panel_201.add(btnEdit);
		btnEdit.setFont(new Font("Calibri", Font.BOLD, 14));
		btnEdit.setMnemonic('E');

		// partycode = new JTextField();
		partycode = new gnRoundTextField(20);
		partycode.setBounds(445, 4, 61, 30);
		panel_201.add(partycode);
		partycode.setForeground(new Color(0, 0, 128));
		partycode.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		partycode.setColumns(10);

		lblNewLabel_4 = new JLabel("( Dr )");
		lblNewLabel_4.setBounds(6, 7, 56, 16);
		panel_201.add(lblNewLabel_4);
		btnEdit.addActionListener(nkk);
		partyname.addActionListener(abc);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { partyname, comboTrType, comboPType, amount, remark, bankname }));

		JPanel panel_203 = new JPanel();
		// JPanel panel_203 = new gnRoundPanel();
		panel_203.setBounds(25, 115, 840, 66);
		panel_203.setBackground(Color.WHITE);
		panel_203.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_203);
		panel_203.setLayout(null);

		JLabel lblBankCode = new JLabel("Bank");
		lblBankCode.setBounds(280, 0, 40, 20);
		lblBankCode.setForeground(new Color(0, 0, 102));
		panel_203.add(lblBankCode);
		lblBankCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBankCode.setHorizontalAlignment(SwingConstants.RIGHT);

		bankname = new JTextField();
		bankname.setToolTipText("Press Enter To Select Bank Account");
		bankname.setBounds(234, 23, 269, 33);
		panel_203.add(bankname);
		bankname.setForeground(new Color(0, 0, 153));
		bankname.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		bankname.setEditable(true);
		bankname.setColumns(10);

		JLabel lblPaymentType = new JLabel("Payment Type");
		lblPaymentType.setBounds(12, -3, 105, 27);
		lblPaymentType.setForeground(new Color(0, 0, 102));
		panel_203.add(lblPaymentType);
		lblPaymentType.setFont(new Font("Tahoma", Font.BOLD, 12));

		comboPType = new JComboBox();
		comboPType.setToolTipText("Select Payment Type");
		comboPType.setBounds(12, 23, 105, 33);
		panel_203.add(comboPType);
		comboPType.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		comboPType.setModel(new DefaultComboBoxModel(new String[] { "Cash", "Cheque", "Demand Draft", "NEFT" }));

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(121, 2, 56, 16);
		lblAmount.setForeground(new Color(0, 0, 102));
		panel_203.add(lblAmount);
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 12));

		amount = new JTextField();
		amount.setToolTipText("Enter Amount Here");
		amount.setFont(new Font("Arial", Font.BOLD, 16));
		amount.setBounds(121, 23, 110, 33);
		panel_203.add(amount);
		amount.setText("0");
		amount.setColumns(10);

		JLabel lblChqddNo = new JLabel("Instrument No");
		lblChqddNo.setBounds(558, 0, 105, 22);
		lblChqddNo.setForeground(new Color(0, 0, 102));
		panel_203.add(lblChqddNo);
		lblChqddNo.setFont(new Font("Tahoma", Font.BOLD, 13));

		chqnumber = new JTextField();
		chqnumber.setToolTipText("Enter ChequeNo/DD No Here");
		chqnumber.setFont(new Font("Arial", Font.BOLD, 16));
		chqnumber.setBounds(558, 23, 105, 33);
		panel_203.add(chqnumber);
		chqnumber.setColumns(10);

		chqdate = new JTextField();
		chqdate.setToolTipText("Enter Cheque / DD Date");
		chqdate.setFont(new Font("Arial", Font.BOLD, 16));
		chqdate.setBounds(669, 23, 155, 33);
		panel_203.add(chqdate);
		chqdate.setColumns(10);

		JLabel lblChqddDate = new JLabel("Instrument Date");
		lblChqddDate.setBounds(675, -1, 122, 22);
		lblChqddDate.setForeground(new Color(0, 0, 102));
		panel_203.add(lblChqddDate);
		lblChqddDate.setFont(new Font("Tahoma", Font.BOLD, 13));

		bankcode = new JTextField();
		bankcode.setBounds(503, 23, 50, 33);
		panel_203.add(bankcode);
		bankcode.setForeground(new Color(0, 0, 153));
		bankcode.setFont(new Font("Arial", Font.BOLD, 16));
		bankcode.setEnabled(false);
		bankcode.setColumns(10);

		JLabel lblRemark = new JLabel("Remark ");
		lblRemark.setBounds(68, 179, 77, 30);
		lblRemark.setForeground(new Color(0, 0, 0));
		panel.add(lblRemark);
		lblRemark.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRemark.setHorizontalAlignment(SwingConstants.RIGHT);

		remark = new JTextField();
		remark.setFont(new Font("Arial", Font.PLAIN, 15));
		remark.setBounds(150, 179, 714, 30);
		panel.add(remark);
		remark.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Payment");
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNewLabel_5.setBounds(33, 22, 77, 16);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(" ");
		lblNewLabel_6.setIcon(new ImageIcon(paymentVoucher.class.getResource("/RetailProduct/resouce/mdf7.jpg")));
		lblNewLabel_6.setBounds(0, 1, 198, 75);
		panel.add(lblNewLabel_6);

		PayentPanel = new JPanel();
		PayentPanel.setBounds(190, 7, 852, 37);
		panel.add(PayentPanel);
		PayentPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, null, Color.YELLOW, null));
		PayentPanel.setLayout(null);

		pjsp = new JScrollPane();
		pjsp.setBounds(0, 32, 846, 93);
		pjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		PayentPanel.add(pjsp);

		btnDue = new JButton("Due Payment");
		btnDue.setBounds(0, 0, 123, 25);
		btnDue.setMnemonic('D');
		PayentPanel.add(btnDue);

		btnHistory = new JButton("Bill Wise Details");
		btnHistory.setBounds(125, 0, 151, 25);
		btnHistory.setMnemonic('B');
		PayentPanel.add(btnHistory);

		btnCreditnote = new JButton("Credit Note");
		btnCreditnote.setBounds(277, 0, 97, 25);
		btnCreditnote.setMnemonic('R');
		PayentPanel.add(btnCreditnote);

		btnDebitnote = new JButton("Debit Note");
		btnDebitnote.setBounds(375, 0, 97, 25);
		btnDebitnote.setMnemonic('N');
		PayentPanel.add(btnDebitnote);

		btnAdvance = new JButton("Advance");
		btnAdvance.setBounds(473, 0, 97, 25);
		btnAdvance.setMnemonic('A');
		PayentPanel.add(btnAdvance);

		JLabel lblNewLabel_2 = new JLabel("Total Amount");
		lblNewLabel_2.setBounds(688, 7, 163, 16);
		PayentPanel.add(lblNewLabel_2);

		GrnAmount = new JTextField();
		GrnAmount.setBounds(774, 4, 77, 22);
		PayentPanel.add(GrnAmount);
		GrnAmount.setColumns(10);

		btnShow = new JToggleButton("Show Bill And Other Details");
		btnShow.setBounds(571, 0, 119, 26);
		PayentPanel.add(btnShow);
		btnShow.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnShow.setMnemonic('O');

		btnSave = new JButton("Save");
		btnSave.setBounds(863, 169, 97, 40);
		panel.add(btnSave);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setMnemonic('S');

		btnHis = new JButton("View Data");
		btnHis.setBounds(962, 169, 97, 40);
		panel.add(btnHis);
		btnHis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnHis.setForeground(new Color(0, 0, 51));
		btnHis.setMnemonic('V');

		btnAcEntry = new JButton("Account Entry");
		btnAcEntry.setBounds(1059, 169, 110, 40);
		panel.add(btnAcEntry);
		btnAcEntry.setMnemonic('A');
		btnAcEntry.setFont(new Font("Tahoma", Font.PLAIN, 12));

		btnExport = new JButton("Export Data");
		btnExport.setBounds(1165, 169, 97, 40);
		panel.add(btnExport);
		btnExport.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExport.setMnemonic('E');

		btnCancel = new JButton("Close");
		btnCancel.setBounds(1261, 169, 65, 40);
		panel.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setMnemonic('C');

		sjsp = new JScrollPane();
		sjsp.setBounds(0, 212, 1326, 343);
		panel.add(sjsp);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		textPane = new JTextPane();
		textPane.setText(
				"1.Select Leger Code\r\n2.Select Payment Mode \r\n3.If Payment Mode is Bank then Select Bank \r\n4.Enter Amout\r\n5.Save Data");
		textPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		textPane.setBounds(863, 35, 537, 131);
		panel.add(textPane);
		btnCancel.addActionListener(cncl);
		btnExport.addActionListener(nkk);

		btnAcEntry.addActionListener(nkk);
		btnHis.addActionListener(nkk);
		btnSave.addActionListener(nkk);
		btnShow.addActionListener(nkk);
		btnAdvance.addActionListener(nkk);
		btnDebitnote.addActionListener(nkk);
		btnCreditnote.addActionListener(nkk);
		btnDue.addActionListener(nkk);
		btnHistory.addActionListener(nkk);
		comboPType.addActionListener(pmt);
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

		frmpaymentvoucher.setUndecorated(true);

		new gnApp().setFrameTitel(frmpaymentvoucher);
		new gnField().closeform(btnSave, frmpaymentvoucher);
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		vcomp = companycode.getText();
		vstore = new gnConfig().getStoreID();
		storecode.setText(new gnConfig().getStoreID());
		String value = storecode.getText();
		storename.setText(new gnConfig().getStorename(value));

		companycode.setVisible(false);
		companyname.setVisible(false);
		storecode.setVisible(false);
		storename.setVisible(false);

		btnDue.setVisible(false);
		btnAdvance.setVisible(false);
		btnCreditnote.setVisible(false);
		btnHistory.setVisible(false);
		btnDebitnote.setVisible(false);
		PayentPanel.setVisible(false);
		frmpaymentvoucher.setUndecorated(true);
		btnShow.setVisible(false);
		pjsp.setVisible(false);
		companycode.setVisible(false);
		companyname.setVisible(false);
		storecode.setVisible(false);
		storename.setVisible(false);
		this.checkInternet();
		chekcFreezeYear();
		String vpara29 = "29";
		String vEditDocumentAllow = new getConfigurationSetting().getSpecificConfiguration(vpara29);
		switch (vEditDocumentAllow) {
		case "N":
			btnEdit.setVisible(false);
		}

		trdate.setText(new gnConfig().getDaybeginDate());

		String vtype = "PV";
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
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			bankcode.setVisible(false);
			bankname.setVisible(false);
			partycode.setVisible(false);
			partyname.setVisible(false);
			btnSave.setVisible(false);
			break;
		}
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

		GrnAmount.setText("0");

		int typecode = 1;
		new gnDecorate().SetSeqHdrButton(btnAdvance, 1);
		new gnDecorate().SetSeqHdrButton(btnDebitnote, 1);
		new gnDecorate().SetSeqHdrButton(btnCreditnote, 1);
		new gnDecorate().SetSeqHdrButton(btnDue, 1);
		new gnDecorate().SetSeqHdrButton(btnHistory, 1);

		new gnDecorate().SetSeqHdrButton(btnAcEntry, 1);
		new gnDecorate().SetSeqHdrButton(btnSave, 1);
		new gnDecorate().SetSeqHdrButton(btnCancel, 1);
		new gnDecorate().SetSeqHdrButton(btnExport, 1);
		new gnDecorate().SetSeqHdrButton(btnHis, 1);

		panel7.setVisible(false);

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
				chqnumber.grabFocus();
				new gnAccountGetGLofGivenGroup().vname = null;
				new gnAccountGetGLofGivenGroup().vcode = null;

			}
		}
	}

	class lsnrCustName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String sname = partyname.getText().trim();
			sname = "%" + sname + "%";
			String vtype = "Party";
			try {
				searchData();
				// vtype = "PV";
				// new gnAccountGetGLofGivenGroup().getAllGLofGroup(vtype,
				// sname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				// partycode.setText(new gnAccountGetGLofGivenGroup().vcode);
				// partyname.setText(new gnAccountGetGLofGivenGroup().vname);
				// amount.grabFocus();
				// btnHis.doClick();
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

			if (partycode.getText().length() > 0) {
				if (value == "Show Bill And Other Details") {
					if (PayentPanel.isVisible()) {
						PayentPanel.setVisible(false);
						frmpaymentvoucher.setBounds(100, 5, 1011, 491);
					} else {
						PayentPanel.setVisible(true);
						frmpaymentvoucher.setBounds(100, 5, 1011, 950);
					}
				}

				if (value == "Due Payment") {
					// new General().msg(value);
					String vvalue = "Due Grns";
					String vdocCat = "";
					String vvendor = partycode.getText();
					String iscreditors = "";
					try {
						iscreditors = new gnAccounting().getGroupCode(vvendor);
						searchtable = new gnPayment().getDataFor(vvalue, vvendor, vdocCat);
					} catch (Throwable e1) {
						new General().msg(e1.getLocalizedMessage());
					}
					showReturnTable(searchtable);
				}

				if (value == "Bill Wise Details") {
					// new General().msg(value);
					String vvalue = "Due Grns";
					String vdocCat = "";
					String vvendor = partycode.getText();
					String iscreditors = "";
					try {
						iscreditors = new gnAccounting().getGroupCode(vvendor);
						searchtable = new gnPayment().getDataFor(vvalue, vvendor, vdocCat);
					} catch (Throwable e1) {
						new General().msg(e1.getLocalizedMessage());
					}
					showReturnTable(searchtable);

				}

				if (value == "Credit Note") {

					// new General().msg(value);
					String vvalue = "CN";
					String vdocCat = "C";
					String vvendor = partycode.getText();
					String iscreditors = "";
					try {
						iscreditors = new gnAccounting().getGroupCode(vvendor);
						searchtable = new gnPayment().getDataFor(vvalue, vvendor, vdocCat);
					} catch (Throwable e1) {
						new General().msg(e1.getLocalizedMessage());
					}
					showReturnTable(searchtable);

				}

				if (value == "Debit Note") {

					// new General().msg(value);
					String vvalue = "DN";
					String vdocCat = "S";
					String vvendor = partycode.getText();
					String iscreditors = "";
					try {
						iscreditors = new gnAccounting().getGroupCode(vvendor);
						searchtable = new gnPayment().getDataFor(vvalue, vvendor, vdocCat);
					} catch (Throwable e1) {
						new General().msg(e1.getLocalizedMessage());
					}
					showReturnTable(searchtable);

				}

				if (value == "Advance") {

					// new General().msg(value);
					String vvalue = "AD";
					String vdocCat = "A";
					String vvendor = partycode.getText();
					String iscreditors = "";
					try {
						iscreditors = new gnAccounting().getGroupCode(vvendor);
						searchtable = new gnPayment().getDataFor(vvalue, vvendor, vdocCat);
					} catch (Throwable e1) {
						new General().msg(e1.getLocalizedMessage());
					}
					showReturnTable(searchtable);
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

			if (value == "Close") {
				frmpaymentvoucher.dispose();
			}

			if (value == "Export Data") {
				new Export_Table_Data_to_Excel().exportTable(stable);
			}

			if (value == "Account Entry") {

				String vtype = "PV";
				String vdocno = paymentvno.getText();
				String vdocdate = trdate.getText();
				try {
					if (vdocno.length() > 0) {
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
					new General().msg(e1.getLocalizedMessage());
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
							String vvdoctype = "PV";
							String vdocno = paymentvno.getText();
							String vvdocdate = trdate.getText();
							new gnEDMiddleWare().PaymentVoucherModification(vvdoctype, vdocno, vvdocdate);
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
		String vtype = "PV";
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
		String vtype = "PV";
		// new gnVoucher().ShowVouchers(vtype, vparty);
		paymentvno.setText(new gnVoucher().vdocno);
		trdate.setText(new gnVoucher().vdocdate);
		chqnumber.setText(new gnVoucher().vinstrno);
		chqdate.setText(new gnVoucher().vinstrdate);
		comboPType.setSelectedItem(new gnVoucher().vpaymentMode);
		amount.setText(new gnVoucher().vamount);
		partycode.setText(new gnVoucher().rglcode);
		partyname.setText(new gnVoucher().rglname);
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
		Double vtotalamt = Double.parseDouble(GrnAmount.getText());

		int row = table.getRowCount();
		if (row > 0) {
			if (!vamt.equals(vtotalamt)) {
				new General().msg("Payment amount and  GRN amount not Tally Please Check ..");
				GrnAmount.setBackground(Color.RED);
				GrnAmount.setForeground(Color.WHITE);
				amount.setText("0");
				status = "Fail";
			}
		}

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
		if ((vptype == "Cheque" || vptype == "NEFT" || vptype == "Demand Draft") && (amount.getText().length() == 0
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
		String vtype = "PV";
		String vparty = partycode.getText();
		vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call voucher_viewData('" + vtype + "', " + vcomp + ", " + vstore + ", " + vparty + ")";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			smodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
		}
		stable.setModel(smodel);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(prt6);
		prt6.setToolTipText("ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, col);
		new gnTable().setTableBasics(stable);
	}

	public void SaveData() throws Throwable {
		String Status = "";
		String vpmtselected = comboPType.getSelectedItem().toString();
		String vchqno = chqnumber.getText();
		String vchqdate = chqdate.getText();
		String vtran = "106";
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
			prst.setString(6, "Payment");
			prst.setString(7, (amount.getText()));
			prst.setString(8, vpmtselected);
			prst.setString(9, vchqno);
			if (vchqdate == "0000.00.00") {
				prst.setString(10, vchqdate);
			} else {
				prst.setString(10, new gnConfig().date_ConverttoDBforamt(vchqdate));
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
			prst.setString(17, "PV");
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
					legderEntery();
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
		switch (PostGST_accountEntryAtSaveTime) {
		case "Y":
			try {
				postjournalEntery();
			} catch (Throwable e) {
				new General().msg(e.getLocalizedMessage());
			}
			break;
		}
	}

	private void postjournalEntery() throws Throwable {

		// String vpmode = comboPType.getSelectedItem().toString().trim();
		// String vchqno = chqnumber.getText();
		// String vchqdate = chqdate.getText() ;
		// String vdocdate2 = new
		// gnConfig().date_ConverttoDBforamt(trdate.getText()) ;
		String vdocno = paymentvno.getText();
		String vdocdate = trdate.getText();
		String vamount = amount.getText();

		// New Logic backend Accouunt entry posting
		new gnGSTMiddleWare().backend_DocaccountPaymentPosting(vdocno, vdocdate, vamount);

		// End New Logic backend Accouunt entry posting

		if (table.getRowCount() > 0) {
			insertintoGrndetail(); // Inserting paid Amount Details and set
									// amount in grnhdr as paid amount
		}
		reset();
		// End New Logic backend process

	}

	private void reset() throws Throwable {
		new gnTable().RemoveTableRows(smodel);
		new gnTable().RemoveTableRows(model);
		DefaultTableModel mm = (DefaultTableModel) searchtable.getModel();
		new gnTable().RemoveTableRows(mm);
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
		bankcode.setBackground(Color.WHITE);
		bankname.setBackground(Color.WHITE);
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

	// Grn Settelent STart Here is required activate by default is non active //

	private void showReturnTable(JTable rtable) {
		JViewport prt = new JViewport();
		prt.add(rtable);
		prt.setVisible(true);
		pjsp.setViewport(prt);
		searchtable.setGridColor(Color.gray);
		Selectrow();
	}

	public void Selectrow() {
		searchtable.requestFocus();
		searchtable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		searchtable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = searchtable.getSelectedRow();
				String value = (String) searchtable.getValueAt(row, 0);
				try {
					display(row, value);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
	}

	private void display(int row, String value) {
		// int row = searchtable.getSelectedRow() ;
		// String value = (String) searchtable.getValueAt(row, 0);
		String value1 = (String) searchtable.getValueAt(row, 1);
		String value2 = (String) searchtable.getValueAt(row, 2);

		String vbankcode = "0";
		String vbankname = " ";
		String result = " ";
		switch (value) {
		case "GRN":
			result = checkGRNExist(value1);
			if (result == "Sucess")
				insertGrninTable(row);
			break;
		}
	}

	public String checkGRNExist(String value) {
		String Action = "Sucess";
		int rowCount = 0;
		int i = 0;
		rowCount = table.getRowCount();
		String Colname = "";
		for (i = 0; i < rowCount; i++) {
			Colname = table.getValueAt(i, 1).toString();
			if (Colname.equalsIgnoreCase(value)) {
				// new General().msg("GRN NO Already Selected ... ") ;
				Action = "Fail";
			}
		}
		return Action;
	}

	public void insertGrninTable(int row) {
		// String searchGr[] = { "Doc.Type" , "Grn no" , "Grn Date" , "Due Date"
		// , "Credit Days" , "DueAmount",
		// "Inv no" , "Inv Date" , "Grn Amount" ,"Grn Approve" };

		String grCOL[] = { "Remove", "Grn no", "Grn Date", "Due Date", "Credit Days", "Inv no", "Inv Date",
				"Grn Amount", "DueAmount", "Payment Amont", "Balance Amount" };
		model.setColumnIdentifiers(grCOL);
		String vgrnno = searchtable.getValueAt(row, 1).toString();
		String vgrndate = searchtable.getValueAt(row, 2).toString();
		String vduedate = searchtable.getValueAt(row, 3).toString();
		String vcrdays = searchtable.getValueAt(row, 4).toString();
		String vinvno = searchtable.getValueAt(row, 6).toString();
		String vinvdate = searchtable.getValueAt(row, 7).toString();
		String vgrnamt = searchtable.getValueAt(row, 8).toString();
		String vdueamt = searchtable.getValueAt(row, 5).toString();
		String vpaymentamt = searchtable.getValueAt(row, 5).toString();
		String vbalanceamt = "0";

		model.addRow(new Object[] { " ", vgrnno, vgrndate, vduedate, vcrdays, vinvno, vinvdate, vgrnamt, vdueamt,
				vpaymentamt, vbalanceamt });
		table.setModel(model);
		new gnTable().AddCheckBoxToTable(model, table, 0);
		GrnAmount.setText(Double.toString(new gnTable().getTotal(table, 7)));
		removeRow(model, table);
		JViewport prt1 = new JViewport();
		prt1.add(table, grCOL);
		prt1.setVisible(true);
		sjsp.setViewport(prt1);
		table.setGridColor(Color.gray);
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		// records.setText(RecordCount1) ;
	}

	public void removeRow(DefaultTableModel xmodel, JTable xtable) {
		DefaultTableModel modelName = xmodel;
		JTable tableName = xtable;
		TableColumn Del = tableName.getColumnModel().getColumn(0);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setText("remove");
		Del.setCellEditor(new DefaultCellEditor(chkbox));
		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int nn = e.getStateChange();
				if (nn == 2 && (modelName == model)) {
					int lastrow = tableName.getRowCount();
					int r = tableName.getSelectedRow();
					int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
					if (option == 0) {
						modelName.removeRow(r);
						if (tableName == table) {
							Double v = new gnTable().getTotal(tableName, 7);
							GrnAmount.setText(Double.toString(v));
						}

					}
				}
			}
		});
	}

	public void insertintoGrndetail() throws Throwable {
		// new General().msg("Reached...");
		String DBSUPGRN;
		int rowcount = table.getRowCount();
		String vgr = "";
		String vpaidamount = "";
		prst = null;
		final int batchSize = 3;
		String vdocdate = "";
		int TotalRecordinsert = 0;
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		DBSUPGRN = "Fail";
		String poshdr = "Insert into payment_grn_details(Site_code , "
				+ "partycode , payment_no, Payment_date,  grn_amount , "
				+ "grnno, grn_date, creditDays , due_date , inv_no, Inv_date, "
				+ "company_code, verticle ,transactionType , DocType, paidAmount)"
				+ "values(?,?,?,?,? ,?,? ,?,? ,?,?, ?, ?, ?,?,?)";
		try {
			for (int i = 0; i < rowcount; i++) {
				// String grCOL[] = { "Remove" , 1"Grn no" , 2"Grn Date" , 3"Due
				// Date" ,4 "Credit Days" ,
				// 5"Inv no" , 6"Inv Date" , 7"Grn Amount" , 8"DueAmount"
				// ,9"Payment Amont" , 10"Balance Amount" };

				prst = con1.prepareStatement(poshdr);
				prst.setString(1, vstore);
				prst.setString(2, partycode.getText());
				prst.setString(3, paymentvno.getText());
				prst.setString(4, new gnConfig().date_ConverttoDBforamt(trdate.getText()));
				prst.setString(5, table.getValueAt(i, 7).toString());
				prst.setString(6, table.getValueAt(i, 1).toString());
				prst.setString(7, new gnConfig().date_ConverttoDBforamt(table.getValueAt(i, 2).toString()));
				prst.setString(8, table.getValueAt(i, 4).toString());
				prst.setString(9, new gnConfig().date_ConverttoDBforamt(table.getValueAt(i, 3).toString()));
				prst.setString(10, table.getValueAt(i, 5).toString());
				prst.setString(11, new gnConfig().date_ConverttoDBforamt(table.getValueAt(i, 6).toString()));
				prst.setString(12, vcomp); // new
											// gnConfig().date_ConverttoDBforamt(
											// table.getValueAt(i,6 ).toString()
											// ));
				prst.setString(13, vverticle); // new
												// gnConfig().date_ConverttoDBforamt(
												// table.getValueAt(i,6
												// ).toString() ));
				prst.setString(14, "PUR");
				prst.setString(15, "GR");
				prst.setString(16, table.getValueAt(i, 9).toString());
				prst.addBatch();
				vpaidamount = table.getValueAt(i, 9).toString();
				vgr = table.getValueAt(i, 1).toString();
				vcomp = companycode.getText();
				vdocdate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(i, 2).toString());
				String sql = "call pmt_updatePaymentdetail(" + vstore + ", " + vgr + ",   '" + vdocdate + "', " + vcomp
						+ " , " + vpaidamount + ")";
				// new General().msg(sql);
				this.getSPResult(sql);

				TotalRecordinsert = TotalRecordinsert + 1;
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBSUPGRN = "Sucess";
					con1.commit();
				}
				prst.executeBatch();
				con1.commit();
				DBSUPGRN = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg("Supplier Grn Table" + e.getMessage());
			con1.rollback();
			DBSUPGRN = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBSUPGRN == "Sucess") {

			}
		}
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
		vtype = "PV";
		stable = new gnAccountGetGLofGivenGroup().getAllGLofGroupinTable(vtype, sname);
		JViewport prt66 = new JViewport();
		sjsp.setViewport(prt66);
		prt66.setToolTipText("ScrollPaneport");
		prt66.setScrollMode(0);
		prt66.add(stable);
		prt66.setBackground(Color.white);
		sjsp.setVisible(true);
		new gnTable().setTableBasics(stable);
		new gnTable().setTableColWidth(stable, 2, 200);
		Selectrow1();

	}

	public void Selectrow1() {
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
					amount.setText(null);
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

package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
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
import com.toedter.calendar.JCalendar;
import javax.swing.border.CompoundBorder;
import com.toedter.components.JLocaleChooser;
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;

//

public class receiptVoucher extends getResultSet {

	JFrame frmreceiptVoucher;
	private String voucherMode = "I";
	JPanel panel;
	private String vcomp;
	private String vstore;
	JButton btnPrint;
	private String vverticle;
	private JTextField acno;
	JButton btnAcEntry;
	JComboBox comboMonth ;
	JComboBox comboYear ;
 	JButton btnEdit;
	private JTextField companycode;
	private JTextField companyname;
	private JTextField bankcode;
	private JTextField storecode;
	private JTextField storename;
	private JTextField bankname;
	private JTextField amount;
	private JTextField chqnumber;
	private JTextField chqdate;
	private JTextField partycode;
	JButton btnHis;
	private JTextField partyname;
	private JTextField remark;
	private JButton btnSave;
	private JButton btnCancel;
 	private JTextField clbal;
	private JButton btnExport;
	private JTextField paymentvno;
	private JTextField trdate;
	public JComboBox comboPType;
	public JComboBox comboTrType;

	//
	private JTable table = new JTable();
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
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					receiptVoucher window = new receiptVoucher();
					window.frmreceiptVoucher.setVisible(true);
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
	public receiptVoucher() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frmreceiptVoucher = new JFrame();
 		frmreceiptVoucher.setBackground(Color.WHITE);
		frmreceiptVoucher.setAlwaysOnTop(true);
		frmreceiptVoucher.setTitle("Business Application");
		//frmreceiptVoucher.setBounds(100, 100, 982, 501); 
		//frmreceiptVoucher.setBounds(10, 221, 1350, 485);
		frmreceiptVoucher.setBounds(1, 90, 1350, 605);
		
 		frmreceiptVoucher.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmreceiptVoucher.getContentPane().setLayout(null);
 
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.DARK_GRAY, null));
		panel.setBounds(0, 0, 799, 224);
		frmreceiptVoucher.getContentPane().add(panel);
		panel.setLayout(null);

		ActionListener bnk = new lsnrbankName();
		ActionListener pmt = new lsnrpmtType();
		ActionListener abc = new lsnrCustName();
		ActionListener jkl = new lsnrBtn();
		ActionListener nkk = new lsnrBtn();

		JLabel lblRemark = new JLabel("Remark ");
		lblRemark.setForeground(new Color(0, 0, 153));
		lblRemark.setFont(new Font("Arial", Font.BOLD, 14));
		lblRemark.setBounds(23, 192, 61, 22);
		panel.add(lblRemark);
		lblRemark.setHorizontalAlignment(SwingConstants.RIGHT);

		remark = new JTextField();
		remark.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
		remark.setBounds(85, 190, 595, 25);
		panel.add(remark);
		remark.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Receipt VNO");
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(136, 19, 105, 16);
		panel.add(lblNewLabel_1);

		paymentvno = new JTextField();
		paymentvno.setForeground(Color.BLACK);
		paymentvno.setBackground(Color.WHITE);
		paymentvno.setEditable(false);
		paymentvno.setFont(new Font("Arial", Font.PLAIN, 15));
		paymentvno.setBounds(252, 13, 58, 25);
		panel.add(paymentvno);
		paymentvno.setColumns(10);

		trdate = new JTextField();
		trdate.setForeground(Color.BLACK);
		trdate.setBackground(Color.WHITE);
		trdate.setFont(new Font("Arial", Font.PLAIN, 15));
		trdate.setEditable(false);
		trdate.setBounds(308, 13, 114, 25);
		panel.add(trdate);
		trdate.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.GRAY));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(79, 41, 671, 39);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPartyCode = new JLabel("Select Party ");
		lblPartyCode.setForeground(new Color(0, 0, 153));
		lblPartyCode.setBounds(64, 7, 109, 22);
		panel_2.add(lblPartyCode);
		lblPartyCode.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblPartyCode.setHorizontalAlignment(SwingConstants.RIGHT);

		// partyname = new JTextField()
		partyname = new gnRoundTextField(20)
 		{
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		partyname.setBounds(172, 1, 282, 30);
		panel_2.add(partyname);
		partyname.setToolTipText("Select Party Press Enter  Or Enter Start Chars");
		partyname.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		partyname.setColumns(10);

		// partycode = new JTextField();
		partycode = new gnRoundTextField(20);
		partycode.setBounds(451, 1, 47, 30);
		panel_2.add(partycode);
		partycode.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		partycode.setColumns(10);

		lblNewLabel_2 = new JLabel("( Cr )");
		lblNewLabel_2.setBounds(0, 6, 56, 16);
		panel_2.add(lblNewLabel_2);
		
		lblNewLabel_5 = new JLabel("For Month");
		lblNewLabel_5.setBounds(582, 13, 77, 21);
		panel_2.add(lblNewLabel_5);
 
		 
		// JPanel panel_3 = new JPanel();
		JPanel panel_3 = new gnRoundPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_3.setBounds(26, 86, 773, 105);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblPaymentType = new JLabel("Payment Type");
		lblPaymentType.setForeground(new Color(0, 0, 153));
		lblPaymentType.setBounds(12, 3, 120, 16);
		panel_3.add(lblPaymentType);
		lblPaymentType.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));

		comboPType = new JComboBox();
		comboPType.setBounds(10, 26, 122, 30);
		panel_3.add(comboPType);
		comboPType.setForeground(new Color(0, 0, 51));
		comboPType.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		comboPType.setModel(new DefaultComboBoxModel(new String[] { "Cash", "Cheque", "DD", "NEFT" }));

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setForeground(new Color(0, 0, 153));
		lblAmount.setBounds(139, 2, 56, 16);
		panel_3.add(lblAmount);
		lblAmount.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));

		amount = new JTextField();
		amount.setBounds(137, 25, 116, 31);
		panel_3.add(amount);
		amount.setForeground(new Color(0, 0, 51));
		amount.setFont(new Font("Arial", Font.BOLD, 16));
		amount.setText("0");
		amount.setColumns(10);

		JLabel lblBankCode = new JLabel("Bank");
		lblBankCode.setForeground(new Color(0, 0, 153));
		lblBankCode.setBounds(267, 0, 40, 20);
		panel_3.add(lblBankCode);
		lblBankCode.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblBankCode.setHorizontalAlignment(SwingConstants.RIGHT);
		bankname = new JTextField();
		bankname.setBounds(256, 25, 223, 31);
		panel_3.add(bankname);
		bankname.setForeground(new Color(0, 0, 51));
		bankname.setToolTipText("Select Bank If Payment Through Cheque or DD/NEFT");
		bankname.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		bankname.setEditable(true);
		bankname.setColumns(10);

		chqnumber = new JTextField();
		chqnumber.setBounds(539, 26, 116, 30);
		panel_3.add(chqnumber);
		chqnumber.setForeground(new Color(0, 0, 51));
		chqnumber.setFont(new Font("Arial", Font.BOLD, 16));
		chqnumber.setColumns(10);

		JLabel lblChqddNo = new JLabel("Instrument No");
		lblChqddNo.setForeground(new Color(0, 0, 153));
		lblChqddNo.setBounds(539, 3, 105, 16);
		panel_3.add(lblChqddNo);
		lblChqddNo.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));

		JLabel lblChqddDate = new JLabel("Instrument Date");
		lblChqddDate.setForeground(new Color(0, 0, 153));
		lblChqddDate.setBounds(646, 3, 122, 16);
		panel_3.add(lblChqddDate);
		lblChqddDate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));

		chqdate = new JTextField();
		chqdate.setBounds(657, 27, 110, 29);
		panel_3.add(chqdate);
		chqdate.setForeground(new Color(0, 0, 51));
		chqdate.setFont(new Font("Arial", Font.BOLD, 16));
		chqdate.setColumns(10);

		bankcode = new JTextField();
		bankcode.setBounds(479, 25, 47, 31);
		panel_3.add(bankcode);
		bankcode.setForeground(new Color(0, 0, 51));
		bankcode.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		bankcode.setEnabled(false);
		bankcode.setColumns(10);
		bankname.addActionListener(bnk);
		comboPType.addActionListener(pmt);
		
		JLabel lblNewLabel_3 = new JLabel("Receipts");
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));
		lblNewLabel_3.setBounds(12, 9, 91, 34);
		panel.add(lblNewLabel_3);
		
				btnEdit = new JButton("Edit-Voucher");
				btnEdit.setBounds(625, 14, 119, 28);
				panel.add(btnEdit);
				btnEdit.setFont(new Font("Calibri", Font.BOLD, 14));
				btnEdit.setMnemonic('E');
				btnEdit.addActionListener(nkk);
		ActionListener cncl = new lsnrBtn();
		
		JPanel panel_4 = new JPanel();
		panel_4.setVisible(false);
		panel_4.setBounds(928, 0, 281, 44);
		frmreceiptVoucher.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
				comboTrType = new JComboBox();
				comboTrType.setBounds(53, 80, 101, 24);
				panel_4.add(comboTrType);
				comboTrType.setVisible(false);
				comboTrType.setEnabled(false);
				comboTrType.setFont(new Font("Calibri", Font.BOLD, 13));
				comboTrType.setEditable(true);
				comboTrType.setModel(new DefaultComboBoxModel(new String[] { "Receipt" }));
				
						companycode = new JTextField();
						companycode.setBounds(12, 136, 36, 25);
						panel_4.add(companycode);
						companycode.setForeground(Color.BLACK);
						companycode.setBackground(Color.WHITE);
						companycode.setFont(new Font("Arial", Font.PLAIN, 15));
						companycode.setEditable(false);
						companycode.setColumns(10);
						
								storecode = new JTextField();
								storecode.setBounds(45, 136, 56, 25);
								panel_4.add(storecode);
								storecode.setForeground(Color.BLACK);
								storecode.setBackground(Color.WHITE);
								storecode.setEditable(false);
								storecode.setFont(new Font("Arial", Font.PLAIN, 15));
								storecode.setColumns(10);
								
										storename = new JTextField();
										storename.setBounds(101, 136, 36, 25);
										panel_4.add(storename);
										storename.setForeground(Color.BLACK);
										storename.setBackground(Color.WHITE);
										storename.setFont(new Font("Arial", Font.PLAIN, 15));
										storename.setEditable(false);
										storename.setColumns(10);
										
												JLabel lblNewLabel = new JLabel("Acc.Balance");
												lblNewLabel.setBounds(77, 56, 77, 16);
												panel_4.add(lblNewLabel);
												
												lblNewLabel_6 = new JLabel("For Year");
												lblNewLabel_6.setBounds(12, 56, 56, 16);
												panel_4.add(lblNewLabel_6);
												
														companyname = new JTextField();
														companyname.setBounds(29, 87, 36, 43);
														panel_4.add(companyname);
														companyname.setEnabled(false);
														companyname.setForeground(Color.BLACK);
														companyname.setBackground(Color.WHITE);
														companyname.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
														companyname.setEditable(false);
														companyname.setColumns(10);
														
																JLabel lblAccno = new JLabel("Acc.No");
																lblAccno.setBounds(28, 3, 56, 16);
																panel_4.add(lblAccno);
																lblAccno.setHorizontalAlignment(SwingConstants.RIGHT);
																
																		acno = new JTextField();
																		acno.setBounds(96, 0, 80, 22);
																		panel_4.add(acno);
																		acno.setEnabled(false);
																		acno.setEditable(false);
																		acno.setColumns(10);
																		
																				clbal = new JTextField();
																				clbal.setBounds(95, 24, 81, 22);
																				panel_4.add(clbal);
																				clbal.setFont(new Font("Times New Roman", Font.ITALIC, 16));
																				clbal.setForeground(new Color(0, 0, 153));
																				clbal.setEnabled(false);
																				clbal.setColumns(10);
																				
																						panel.setFocusTraversalPolicy(new FocusTraversalOnArray(
																								new Component[] { partyname, comboTrType, comboPType, amount, remark, bankname }));
																						
																								btnSave = new JButton("Save");
																								btnSave.setBounds(798, 174, 88, 50);
																								frmreceiptVoucher.getContentPane().add(btnSave);
																								btnSave.setIcon(null);
																								btnSave.setFont(new Font("Calibri", Font.BOLD, 12));
																								btnSave.setMnemonic('S');
																								
																										btnHis = new JButton("View Data");
																										btnHis.setBounds(952, 174, 88, 50);
																										frmreceiptVoucher.getContentPane().add(btnHis);
																										btnHis.setFont(new Font("Calibri", Font.BOLD, 12));
																										btnHis.setForeground(new Color(0, 0, 51));
																										btnHis.setMnemonic('V');
																										
																										btnPrint = new JButton("Print");
																										btnPrint.setBounds(886, 174, 65, 50);
																										frmreceiptVoucher.getContentPane().add(btnPrint);
																										
																												btnExport = new JButton("Export Data");
																												btnExport.setBounds(1035, 174, 105, 50);
																												frmreceiptVoucher.getContentPane().add(btnExport);
																												btnExport.setFont(new Font("Calibri", Font.BOLD, 12));
																												btnExport.setMnemonic('E');
																												
																														btnAcEntry = new JButton("Account Entry");
																														btnAcEntry.setBounds(1138, 175, 105, 49);
																														frmreceiptVoucher.getContentPane().add(btnAcEntry);
																														btnAcEntry.setFont(new Font("Calibri", Font.BOLD, 12));
																														btnAcEntry.setMnemonic('A');
																														
																																btnCancel = new JButton("Close");
																																btnCancel.setBounds(1241, 174, 91, 50);
																																frmreceiptVoucher.getContentPane().add(btnCancel);
																																btnCancel.setFont(new Font("Calibri", Font.BOLD, 14));
																																btnCancel.setMnemonic('C');
																																
																																		sjsp = new JScrollPane();
																																		sjsp.setBounds(0, 225, 1332, 309);
																																		frmreceiptVoucher.getContentPane().add(sjsp);
																																		sjsp.setViewportBorder(null);
																																		
																																		textPane = new JTextPane();
																																		textPane.setText("1.Select Leger Code\r\n2.Select Payment Mode \r\n3.If Payment Mode is Bank then Select Bank \r\n4.Enter Amout\r\n5.Save Data");
																																		textPane.setFont(new Font("Tahoma", Font.BOLD, 13));
																																		textPane.setBounds(798, 40, 537, 131);
																																		frmreceiptVoucher.getContentPane().add(textPane);
																																btnCancel.addActionListener(cncl);
																														btnAcEntry.addActionListener(nkk);
																												btnExport.addActionListener(nkk);
																										btnPrint.addActionListener(nkk);
																										btnHis.addActionListener(nkk);
		btnSave.addActionListener(nkk);
		partyname.addActionListener(abc);

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

		frmreceiptVoucher.setUndecorated(true);
		companyname.setVisible(false);
 
		this.checkInternet();
		chekcFreezeYear();
		storename.setVisible(false);
		storecode.setVisible(false);
		companycode.setVisible(false);
		
		 
		partycode.setText(vRefcode);
		partyname.setText(vRefname);
		vRefcode = null ;
		vRefname = null ;
		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		// new General().setDate(trdate);
		String vpara29 = "29";
		String vEditDocumentAllow = new getConfigurationSetting().getSpecificConfiguration(vpara29);
		switch (vEditDocumentAllow) {
		case "N":
			btnEdit.setVisible(false);
		}
		trdate.setText(new gnConfig().getDaybeginDate());

		String vtype = "RV";
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

		new gnApp().setFrameTitel(frmreceiptVoucher);
 		new gnField().closeform(btnSave, frmreceiptVoucher);
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		vcomp = companycode.getText();
        vstore = vcomp ;
		String value = vcomp ;
 		storecode.setText(new gnConfig().getStoreID());
 		storename.setText(new gnConfig().getStorename(value));
        vstore = storecode.getText() ;
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

		int typecode = 1;
		new gnDecorate().SetSeqHdrButton(btnAcEntry, 1);
		new gnDecorate().SetSeqHdrButton(btnSave, 1);
		new gnDecorate().SetSeqHdrButton(btnCancel, 1);
		new gnDecorate().SetSeqHdrButton(btnExport, 1);
		new gnDecorate().SetSeqHdrButton(btnHis, 1);
		new gnDecorate().SetSeqHdrButton(btnPrint, 1);
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
			String vglgroup = "12";
			String vcomp = companycode.getText();
			try {
				// new gnBank().getbankDetail(vtype);
				new gnAccountGetGLofGivenGroup().getAllGLofGroup(vtype, sname);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
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
 			try {
				String vtype = "RV";
				//new gnAccountGetGLofGivenGroup().getAllGLofGroup(vtype, sname);
 				searchData();
  			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				//partycode.setText(new gnAccountGetGLofGivenGroup().vcode);
				//partyname.setText(new gnAccountGetGLofGivenGroup().vname);
				//amount.grabFocus();
				//btnHis.doClick();
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
			if (value == "Close") {
				try {
					frmreceiptVoucher.dispose();
				} catch (Throwable e1) {
 					e1.printStackTrace();
				}
			}

			if (value == "Edit-Voucher") {
				try {
					startEditProcess();
				} catch (Throwable e1) {
 					e1.printStackTrace();
				}
			}

			if (value == "View Data") {
				status = checkVendor();
				if (status == "Sucess") {
					try {
						ShowView();
					} catch (Throwable e1) {
 						e1.printStackTrace();
					}
				}
			}

			if (value == "Export Data") {
				new Export_Table_Data_to_Excel().exportTable(stable);
			}

			if (value == "Account Entry") {
				String vtype = "RV";
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

			if (value == "Print")
			{
				try {
					callPrint() ;
				} catch (Throwable e1) {
 					e1.printStackTrace();
				}
			} 

			
			if (value == "Save") {
				try {
					status = validate();
					if (status == "Sucess") {
 						switch (voucherMode) {
						case "E":
							String vvdoctype = "RV";
							String vdocno = paymentvno.getText();
							String vvdocdate = trdate.getText();
							new gnEDMiddleWare().PaymentReceiptModification(vvdoctype, vdocno, vvdocdate);
							SaveData();
							break;
						case "I":
							SaveData();
							break;
						}
					}
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg("Receipt Voucher -+" + " " + e1.getLocalizedMessage());
				} catch (IOException e1) {
					new General().msg("Receipt voucher -++" + " " + e1.getLocalizedMessage());
				} catch (Throwable e1) {
					new General().msg("Receipt voucher -+++" + " " + e1.getLocalizedMessage());
				}
			}
		}
	}

	private void startEditProcess() throws Throwable {
		voucherMode = "E";
		chekcFreezeYear();
		panel.setBackground(Color.WHITE);
 		String vparty = partycode.getText();
		String vtype = "RV";
		new gnVoucher().ShowVouchers(vtype, vparty);
		paymentvno.setText(new gnVoucher().vdocno);
		trdate.setText(new gnVoucher().vdocdate);
		chqnumber.setText(new gnVoucher().vinstrno);
		chqdate.setText(new gnVoucher().vinstrdate);
		comboPType.setSelectedItem(new gnVoucher().vpaymentMode);
		amount.setText(new gnVoucher().vamount);
		new gnAdvance().getBankRelatedDetails(vtype, paymentvno.getText(), trdate.getText());
		bankcode.setText(new gnAdvance().rbankcode);
		bankname.setText(new gnAdvance().rbankname);

	}

	public void callEditProcess() throws Throwable {
		voucherMode = "E";
		panel.setBackground(Color.WHITE);
 		String vparty = partycode.getText();
		String vtype = "RV";
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
		new gnAdvance().getBankRelatedDetails(vtype, paymentvno.getText(), trdate.getText());
		bankcode.setText(new gnAdvance().rbankcode);
		bankname.setText(new gnAdvance().rbankname);
 		new gnStyleButton().getStyleButton(btnEdit, Color.gray, Color.WHITE);

	}

	private void insertintoGLmaster() throws Throwable {
		String vglcode = partycode.getText();
		String vglname = partyname.getText();
		String vtype = "N";
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

		if (partyname.getText().length() == 0) {
			new General().msg("Select Party Code ");
			status = "Fail";
			partyname.grabFocus();

		}
		String vtype1 = (String) comboPType.getSelectedItem();
		if (vtype1 != "Cash" && bankname.getText().length() == 0) {
			new General().msg("Select Bank ");
			bankname.grabFocus();
			new gnImageSound().playSound();
			status = "Fail";

		}

		if (vtype1 == "Cash" && bankname.getText().length() > 0) {
			new General().msg("Select Payment Mode for Bank Like <Cheq/DD Etc..>");
			comboPType.grabFocus();
			new gnImageSound().playSound();
			status = "Fail";
		}
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
 				e.printStackTrace();
			} catch (Throwable e) {
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
		String vtype = "RV";
		String vparty = partycode.getText();
		vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call voucher_viewData('" + vtype + "', " + vcomp + ", " + vstore + ", " + vparty + ")";
 		rs = this.getSPResult(SQL);
		while (rs.next()) {
			smodel.addRow(new Object[] {  rs.getString(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7) , rs.getString(8) });
		}
		stable.setModel(smodel);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(prt6);
		prt6.setToolTipText("Receipt Data");
		prt6.setScrollMode(0);
		prt6.add(stable, col);
		prt6.setBackground(Color.white);
		new gnTable().setTableBasics(stable);
 	}

	public void SaveData() throws Throwable {
		
 		String Status = "";
		String vpmtselected = comboPType.getSelectedItem().toString();
		String vchqno = chqnumber.getText();
		String vchqdate = chqdate.getText();
		String vtran = "107";
		String vtype = "TR";
 		try {
			switch (voucherMode) {
			case "I":
				paymentvno.setText(new gnSeq().getSeqno(vtran, vtype));
				break;
			case "E":
				break;
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
				+ "CHQ_DD_DATE, Clering_date, Partycode, Remark, Account_no, "
				+ "verticle, supplier_payment, doctype, docno, finyear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,? )";
		prst = con.prepareStatement(pospayment);
		try {
 			prst.setString(1, vcomp);
			prst.setString(2, storecode.getText());
			prst.setString(3, bankcode.getText());
			prst.setString(4, bankname.getText());
			prst.setString(5, new gnConfig().date_ConverttoDBforamt(trdate.getText()));
			prst.setString(6, "Receipt");
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
			prst.setString(17, "RV");
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
			new General().msg("Voucher -RV :" + e.getMessage());
			con.rollback();
			Status = "Fail";
		} finally {
			if (Status == "Sucess") {
				switch (voucherMode) {
				case "I":
					new gnSeq().updateSeqno(vtran, vtype);
					break;
				case "E":
				}
 				new General().msg("Data Saved Sucessfully");
				legderEntery();
  			}
			if (prst != null) {
				prst.close();
				try {
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public void legderEntery() throws Throwable {
		new General().msg("Ledger postinbg starts ");
		String vstore = storecode.getText();
		String vdocno = paymentvno.getText();
		String vdocType1 = "RV";
		String vdocdate = new gnConfig().date_ConverttoDBforamt(trdate.getText());
		String vfinyear = new gnFinYear().getCurrentFinYear(trdate.getText());
 		switch (PostGST_accountEntryAtSaveTime) {
		case "Y":
			postjournalEntery();
		}
	}

	
	private void postjournalEntery() throws Throwable {

		new General().msg("Ledger postinbg starts 111");

		String vdocdate = trdate.getText();
		String vdocno = paymentvno.getText();
 		String vamount = amount.getText();
  		new gnGSTMiddleWare().backend_DocaccountReceiptPosting(vdocno, vdocdate, vamount);
  		reset();
	}

	private void reset() throws Throwable {

		voucherMode = "I";
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
 	vtype = "RV";
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
				removeableData() ;
 				btnHis.doClick();
  			} catch (Throwable e1) {
				e1.printStackTrace();
			} 
 		}
	});
 }

	
private void callPrint() throws Throwable
{
	String vdocno =  paymentvno.getText() ;  
	String vdoctype = "RV" ;
	String vdocdate = trdate.getText();
 	new gnDocPrint().callprint(vdoctype, vdocno, vdocdate);
	
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

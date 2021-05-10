package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.border.EtchedBorder;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.border.BevelBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Acct_transactionAudit extends getResultSet {

	JFrame transactionAuditFrame;
	JInternalFrame internalFrame;
	String SQL = "";
	JButton btnUpdateCogs;
	String vcomp;
	String vstore;
	private JTextField from;
	private JTextField to;
	String vfrom;
	String vto;
	JLabel msg;
	JScrollPane jsp;
	JButton btnPur;
	JButton btnSale;
	String trtype = "";
	String value;
	String value1;
	String value2;

	JButton btnPurret;
	JButton btnSaleret;
	JButton btnReceipts;
	JButton btnPayment;
	JButton btnContra;
	JButton btnAdvsup;
	JButton btnAdvcus;
	JButton btnRepost;
	JButton btnClose;
	JScrollPane jsp1;
	JScrollPane jsp2;
	private JTextField record;
	private JTextField amount;
	public JTextField processingRecord;

	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable();

	DefaultTableModel model1 = new DefaultTableModel();
	JTable table1 = new JTable();

	DefaultTableModel model2 = new DefaultTableModel();
	JTable table2 = new JTable();
	private JTextField finyear;
	private JTextField accRecords;
	private JTextField accAmount;
	private JTextField gstRecords;
	private JTextField gstAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acct_transactionAudit window = new Acct_transactionAudit();
					window.transactionAuditFrame.setVisible(true);
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
	public Acct_transactionAudit() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		transactionAuditFrame = new JFrame();
		transactionAuditFrame.setBounds(1, 0, 1370, 700);
		transactionAuditFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		transactionAuditFrame.getContentPane().setLayout(null);

		internalFrame = new JInternalFrame("Reposting Module");
		internalFrame.getContentPane().setBackground(Color.CYAN);
		internalFrame.setForeground(new Color(0, 102, 153));
		internalFrame.setBackground(Color.CYAN);
		internalFrame.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		internalFrame.setBounds(0, 0, 1360, 690);
		transactionAuditFrame.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 255, 204), 3));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1344, 34);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setBounds(12, 10, 37, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setBounds(144, 10, 115, 16);
		panel.add(lblNewLabel_1);

		from = new JTextField();
		from.setForeground(new Color(0, 51, 153));
		from.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		from.setBounds(46, 0, 97, 32);
		panel.add(from);
		from.setColumns(10);

		to = new JTextField();
		to.setForeground(new Color(0, 51, 153));
		to.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		to.setBounds(170, 0, 89, 32);
		panel.add(to);
		to.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel(
				" Note: Transaction Audit Module To Check Data Posted Correctly In Respective Tables");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setIcon(null);
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_3.setBounds(327, 4, 861, 29);
		panel.add(lblNewLabel_3);

		btnUpdateCogs = new JButton("Cogs Calculation");
		btnUpdateCogs.setBounds(1189, 4, 149, 29);
		panel.add(btnUpdateCogs);

		finyear = new JTextField();
		finyear.setForeground(Color.GREEN);
		finyear.setBackground(Color.BLACK);
		finyear.setBounds(256, 0, 60, 32);
		panel.add(finyear);
		finyear.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 255, 204), null));
		panel_1.setBounds(0, 35, 115, 593);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);

		btnPur = new JButton("Purchase");
		btnPur.setFont(new Font("Cambria", Font.BOLD, 13));
		btnPur.setMnemonic('P');
		btnPur.setBounds(0, 15, 115, 34);
		panel_1.add(btnPur);

		btnSale = new JButton("Sales");
		btnSale.setFont(new Font("Cambria", Font.BOLD, 13));
		btnSale.setMnemonic('S');
		btnSale.setBounds(0, 47, 115, 34);
		panel_1.add(btnSale);

		btnPurret = new JButton("Pur.Return");
		btnPurret.setFont(new Font("Cambria", Font.BOLD, 13));
		btnPurret.setMnemonic('U');
		btnPurret.setBounds(0, 203, 115, 34);
		panel_1.add(btnPurret);

		btnSaleret = new JButton("Sale Return");
		btnSaleret.setFont(new Font("Cambria", Font.BOLD, 13));
		btnSaleret.setMnemonic('A');
		btnSaleret.setBounds(0, 235, 115, 34);
		panel_1.add(btnSaleret);

		btnReceipts = new JButton("Receipts");
		btnReceipts.setFont(new Font("Cambria", Font.BOLD, 13));
		btnReceipts.setMnemonic('R');
		btnReceipts.setBounds(0, 92, 115, 34);
		panel_1.add(btnReceipts);

		btnPayment = new JButton("Payment");
		btnPayment.setFont(new Font("Cambria", Font.BOLD, 13));
		btnPayment.setMnemonic('Y');
		btnPayment.setBounds(0, 125, 115, 34);
		panel_1.add(btnPayment);

		btnContra = new JButton("Contra");
		btnContra.setFont(new Font("Cambria", Font.BOLD, 13));
		btnContra.setMnemonic('N');
		btnContra.setBounds(0, 157, 115, 34);
		panel_1.add(btnContra);

		btnAdvsup = new JButton("Adv.Supplier");
		btnAdvsup.setFont(new Font("Cambria", Font.BOLD, 13));
		btnAdvsup.setMnemonic('I');
		btnAdvsup.setBounds(0, 272, 115, 34);
		panel_1.add(btnAdvsup);

		btnAdvcus = new JButton("Adv.Customer");
		btnAdvcus.setFont(new Font("Cambria", Font.BOLD, 13));
		btnAdvcus.setMnemonic('M');
		btnAdvcus.setBounds(0, 306, 115, 34);
		panel_1.add(btnAdvcus);

		JLabel lblNewLabel_2 = new JLabel("Select Transaction");
		lblNewLabel_2.setForeground(new Color(0, 0, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(0, 0, 115, 16);
		panel_1.add(lblNewLabel_2);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(117, 37, 941, 553);
		internalFrame.getContentPane().add(jsp);

		btnRepost = new JButton("Repost Entries");
		btnRepost.setBounds(632, 586, 137, 42);
		internalFrame.getContentPane().add(btnRepost);
		btnRepost.setFont(new Font("Cambria", Font.BOLD, 14));
		btnRepost.setMnemonic('O');

		btnClose = new JButton("Close");
		btnClose.setBounds(766, 586, 90, 42);
		internalFrame.getContentPane().add(btnClose);
		btnClose.setFont(new Font("Cambria", Font.BOLD, 14));
		btnClose.setMnemonic('C');

		JLabel lblNewLabel_4 = new JLabel("Records");
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBounds(127, 602, 55, 16);
		internalFrame.getContentPane().add(lblNewLabel_4);

		record = new JTextField();
		record.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		record.setBounds(182, 586, 122, 42);
		internalFrame.getContentPane().add(record);
		record.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Amount");
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_5.setBounds(316, 602, 55, 16);
		internalFrame.getContentPane().add(lblNewLabel_5);

		amount = new JTextField();
		amount.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		amount.setBounds(366, 586, 122, 42);
		internalFrame.getContentPane().add(amount);
		amount.setColumns(10);

		processingRecord = new JTextField();
		processingRecord.setBounds(856, 586, 122, 49);
		internalFrame.getContentPane().add(processingRecord);
		processingRecord.setColumns(10);

		jsp1 = new JScrollPane();
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(1056, 74, 294, 254);
		internalFrame.getContentPane().add(jsp1);

		JLabel lblNewLabel_6 = new JLabel("Missing Account Entries");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_6.setBounds(1059, 58, 137, 16);
		internalFrame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Missing GST Entries");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setBounds(1066, 332, 115, 16);
		internalFrame.getContentPane().add(lblNewLabel_7);

		jsp2 = new JScrollPane();
		jsp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp2.setBounds(1056, 366, 294, 225);
		internalFrame.getContentPane().add(jsp2);

		msg = new JLabel(" ----->");
		msg.setFont(new Font("SansSerif", Font.BOLD, 12));
		msg.setBounds(1056, 592, 288, 34);
		internalFrame.getContentPane().add(msg);

		JLabel lblNewLabel_8 = new JLabel("Record");
		lblNewLabel_8.setBounds(1203, 35, 55, 16);
		internalFrame.getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Amount");
		lblNewLabel_9.setBounds(1264, 35, 55, 16);
		internalFrame.getContentPane().add(lblNewLabel_9);

		accRecords = new JTextField();
		accRecords.setBounds(1197, 48, 55, 28);
		internalFrame.getContentPane().add(accRecords);
		accRecords.setColumns(10);

		accAmount = new JTextField();
		accAmount.setBounds(1251, 48, 93, 28);
		internalFrame.getContentPane().add(accAmount);
		accAmount.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Records");
		lblNewLabel_10.setBounds(1197, 328, 55, 16);
		internalFrame.getContentPane().add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Amount");
		lblNewLabel_11.setBounds(1264, 328, 55, 16);
		internalFrame.getContentPane().add(lblNewLabel_11);

		gstRecords = new JTextField();
		gstRecords.setBounds(1193, 340, 55, 28);
		internalFrame.getContentPane().add(gstRecords);
		gstRecords.setColumns(10);

		gstAmount = new JTextField();
		gstAmount.setBounds(1247, 340, 97, 28);
		internalFrame.getContentPane().add(gstAmount);
		gstAmount.setColumns(10);
		transactionAuditFrame.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { from, to, btnRepost, btnClose, btnPur, btnSale, btnPurret,
						btnSaleret, btnReceipts, btnPayment, btnContra, btnAdvsup, btnAdvcus }));
		internalFrame.setVisible(true);
		ActionListener btnrpt = new btnRepost();
		btnRepost.addActionListener(btnrpt);

		ActionListener btnaction = new btnLsnr();
		btnPurret.addActionListener(btnaction);
		btnPur.addActionListener(btnaction);
		btnSale.addActionListener(btnaction);
		btnSaleret.addActionListener(btnaction);
		btnReceipts.addActionListener(btnaction);
		btnPayment.addActionListener(btnaction);
		btnContra.addActionListener(btnaction);
		btnAdvsup.addActionListener(btnaction);
		btnAdvcus.addActionListener(btnaction);
		btnClose.addActionListener(btnaction);
		btnUpdateCogs.addActionListener(btnaction);

		decorate();
	}

	private void decorate() throws Throwable {
		btnAdvcus.setVisible(false);
		btnAdvsup.setVisible(false);

		finyear.setText(new gnFinYear().getReportingFinYear());
		new gnApp().setFrameTitel(transactionAuditFrame);
		new gnField().closeform(internalFrame, transactionAuditFrame);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		from.setText(new gnFinYear().getFirstDateofFinYear());
		to.setText(new gnFinYear().getLastDateofFinYear());

		new gnDecorate().decorateBtn(btnPur, new Color(56, 189, 112), Color.BLACK);
		new gnDecorate().decorateBtn(btnSale, new Color(178, 11, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnReceipts, new Color(178, 11, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnPayment, new Color(178, 11, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnContra, new Color(56, 189, 112), Color.BLACK);
		new gnDecorate().decorateBtn(btnAdvcus, new Color(178, 11, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnAdvsup, new Color(178, 11, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnPurret, new Color(178, 11, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnSaleret, new Color(178, 11, 112), Color.WHITE);

		new gnStyleButtonSqr().getStyleButton(btnPur, new Color(178, 11, 112), Color.WHITE);
		new gnStyleButtonSqr().getStyleButton(btnSale, new Color(120, 151, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnReceipts, new Color(131, 211, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnPayment, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnContra, new Color(178, 11, 112), Color.WHITE);
		new gnStyleButtonSqr().getStyleButton(btnAdvsup, new Color(120, 151, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnAdvcus, new Color(131, 211, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnSaleret, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnPurret, new Color(56, 189, 112), Color.BLACK);

	}

	class btnRepost implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			value1 = e.getActionCommand();
			if (value1 == "Repost Entries") {
				try {
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		}
	}

	private void cogsAvgcost_Calculate() throws ClassNotFoundException, SQLException {
		new gnDecorate().setBusyCursor(transactionAuditFrame);
		/// One Time Run This Only What Does---> Calculate Avgcost and update in
		/// Article Master
		// Update Avgcost to SalesDetails Table and Calculate Cog This is
		/// Important if cogs was not
		// for privious installations run this once and repost entries for
		/// accounting stock and nee sales effect
		String SQL = "call  Account_calculate_updateAvgcost(" + vcomp + ", " + vstore + ")"; // update
																								// Article
																								// avgcost
																								// based
																								// on
																								// grn
																								// data
		this.getSPResult(SQL);
		String SQL1 = "call Account_updateCogsForSalesData(" + vcomp + ", " + vstore + ")"; // update
																							// cost
																							// as
																							// avgcost
																							// to
																							// sales
																							// table
																							// and
																							// calculate
																							// cogs
		this.getSPResult(SQL1);

	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			value = e.getActionCommand();
			if (value == "Cogs Calculation") {
				try {
					cogsAvgcost_Calculate();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Close") {
				transactionAuditFrame.dispose();
			}

			if (value == "Purchase") {
				value2 = "GRN";
				btnPur.setBackground(Color.blue);
				btnPur.setForeground(Color.WHITE);
				try {
					ProcessAction();
					decorate();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Sales") {
				value2 = "SALE";
				try {
					ProcessAction();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Pur.Return") {
				value2 = "PR";
				try {
					ProcessAction();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Sale Return") {
				value2 = "SR";
				try {
					ProcessAction();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Receipts") {
				try {
					value2 = "RV";
					ProcessAction();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Payment") {
				try {
					value2 = "PV";
					ProcessAction();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Contra") {
				try {
					value2 = "CO";
					ProcessAction();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Adv.Supplier") {
				try {
					value2 = "SAD";
					ProcessAction();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Adv.Customer") {
				try {
					value2 = "CAD";
					ProcessAction();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	private void ProcessAction() throws Throwable {
		vfrom = from.getText();
		vto = to.getText();

		String vstatus = new gnFinYear().checkDateRanegforFinyear(from.getText(), to.getText());
		if (vstatus == "Sucess") {

			String vfinyear = finyear.getText();
			String vvfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
			String vvto = new gnConfig().date_ConverttoDBforamt(vto);

			String Col[] = { "DocType", "Docno", "Docdate", "Finyear", "Hdr_Amount", "Detail Amount", "POS-Payment",
					"LedgerAmount", "DnCnAmount", "GST-Amount", "BankTransactions", "Account-Posting", "Status",
					"Final" };

			model.setColumnIdentifiers(Col);
			;
			table.setModel(model);
			new gnTable().RemoveTableRows(model);
			JViewport prt = new JViewport();

			switch (value2) {

			case ("GRN"):
				SQL = "Call 	Acc_audit_purchaseData(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '" + vvto
						+ "' , '" + vfinyear + "' )";
				this.getSPResult(SQL);
				SQL = "Call 	Acc_audit_viewTransactionData(  '" + value2 + "' ,  " + vcomp + " , " + vstore + " ,  '"
						+ vvfrom + "' , '" + vvto + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col, 13, "N", "N", "N");
				prt.add(table);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				// amount.setText(Double.toString(new gnTable().getTotal(table,
				// 6)));
				break;

			case ("SALE"):
				SQL = "Call 	Acc_audit_SaleData(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '" + vvto
						+ "' , '" + vfinyear + "' )";
				// new General().msg(SQL);
				this.getSPResult(SQL);
				SQL = "Call 	Acc_audit_viewTransactionData(  '" + value2 + "' ,  " + vcomp + " , " + vstore + " ,  '"
						+ vvfrom + "' , '" + vvto + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col, 13, "N", "N", "N");
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 6)));
				break;

			case "PR":
				SQL = "Call 	Acc_audit_PRData(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '" + vvto + "' , '"
						+ vfinyear + "' )";
				this.getSPResult(SQL);
				SQL = "Call 	Acc_audit_viewTransactionData(  '" + value2 + "' ,  " + vcomp + " , " + vstore + " , '"
						+ vvfrom + "' , '" + vvto + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col, 13, "N", "N", "N");
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 6)));
				break;

			case "SR":
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col, 6, "N", "Y", value);
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 6)));
				break;

			case ("PV"):
				SQL = "Call 	Acc_audit_PVData(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '" + vvto + "' , '"
						+ vfinyear + "' )";
				// new General().msg(SQL);
				this.getSPResult(SQL);
				SQL = "Call 	Acc_audit_viewTransactionData(  '" + value2 + "' ,  " + vcomp + " , " + vstore + " , '"
						+ vvfrom + "' , '" + vvto + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col, 13, "N", "N", "N");
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 7)));
				break;

			case ("RV"):
				SQL = "Call 	Acc_audit_RVData(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '" + vvto + "' , '"
						+ vfinyear + "' )";
				this.getSPResult(SQL);
				SQL = "Call 	Acc_audit_viewTransactionData(  '" + value2 + "' ,  " + vcomp + " , " + vstore + " , '"
						+ vvfrom + "' , '" + vvto + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col, 13, "N", "N", "N");
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 7)));
				break;

			case ("CO"):
				SQL = "Call 	Acc_audit_COData(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '" + vvto + "' , '"
						+ vfinyear + "' )";
				this.getSPResult(SQL);
				SQL = "Call 	Acc_audit_viewTransactionData(  '" + value2 + "' ,  " + vcomp + " , " + vstore + " , '"
						+ vvfrom + "' , '" + vvto + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col, 13, "N", "N", "N");
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 7)));
				break;

			case ("SAD"):
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col, 10, "N", "Y", value);
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 7)));
				break;
			case ("CAD"):
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col, 10, "N", "Y", value);
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 7)));
				break;
			}
		}
	}

}// Last

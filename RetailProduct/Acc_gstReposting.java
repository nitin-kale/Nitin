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

public class Acc_gstReposting extends getResultSet {

	JFrame RepostingFrame;
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
	JScrollPane jsp3;
	private JTextField record;
	private JTextField amount;
	public JTextField processingRecord;

	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable();

	DefaultTableModel model1 = new DefaultTableModel();
	JTable table1 = new JTable();

	DefaultTableModel model2 = new DefaultTableModel();
	JTable table2 = new JTable();

	DefaultTableModel model3 = new DefaultTableModel();
	JTable table3 = new JTable();

	private JTextField finyear;
	private JTextField accRecords;
	private JTextField accAmount;
	private JTextField gstRecords;
	private JTextField gstAmount;
	private JTextField crdrRecords;
	private JTextField crdrAmount;

	JButton btnIncome;
	JButton btnExpense;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acc_gstReposting window = new Acc_gstReposting();
					window.RepostingFrame.setVisible(true);
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
	public Acc_gstReposting() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		RepostingFrame = new JFrame();
		RepostingFrame.setBounds(1, 0, 1370, 700);
		RepostingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		RepostingFrame.getContentPane().setLayout(null);

		internalFrame = new JInternalFrame("Bulk Reposting Module");
		internalFrame.getContentPane().setBackground(Color.CYAN);
		internalFrame.setForeground(new Color(0, 102, 153));
		internalFrame.setBackground(Color.CYAN);
		internalFrame.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		internalFrame.setBounds(0, 0, 1360, 690);
		RepostingFrame.getContentPane().add(internalFrame);
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
				"Note: Reposting entry module will remove existing GST & Accounting entries and repost entries [For selected transaction and mention period]");
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
		btnPurret.setBounds(0, 257, 115, 34);
		panel_1.add(btnPurret);

		btnSaleret = new JButton("Sale Return");
		btnSaleret.setFont(new Font("Cambria", Font.BOLD, 13));
		btnSaleret.setMnemonic('A');
		btnSaleret.setBounds(0, 289, 115, 34);
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
		btnAdvsup.setBounds(0, 373, 115, 34);
		panel_1.add(btnAdvsup);

		btnAdvcus = new JButton("Adv.Customer");
		btnAdvcus.setFont(new Font("Cambria", Font.BOLD, 13));
		btnAdvcus.setMnemonic('M');
		btnAdvcus.setBounds(0, 407, 115, 34);
		panel_1.add(btnAdvcus);

		JLabel lblNewLabel_2 = new JLabel("Select Transaction");
		lblNewLabel_2.setForeground(new Color(0, 0, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(0, 0, 115, 16);
		panel_1.add(lblNewLabel_2);

		btnIncome = new JButton("Income");
		btnIncome.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnIncome.setBounds(0, 191, 115, 34);
		panel_1.add(btnIncome);

		btnExpense = new JButton("Expense");
		btnExpense.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnExpense.setBounds(0, 225, 115, 34);
		panel_1.add(btnExpense);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(117, 37, 870, 553);
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
		jsp1.setBounds(990, 74, 360, 164);
		internalFrame.getContentPane().add(jsp1);

		JLabel lblNewLabel_6 = new JLabel("Missing Account Entries");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_6.setBounds(1059, 54, 137, 16);
		internalFrame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Missing GST Entries");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setBounds(1081, 250, 115, 16);
		internalFrame.getContentPane().add(lblNewLabel_7);

		jsp2 = new JScrollPane();
		jsp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp2.setBounds(990, 277, 360, 139);
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
		lblNewLabel_10.setBounds(1201, 235, 55, 16);
		internalFrame.getContentPane().add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Amount");
		lblNewLabel_11.setBounds(1268, 235, 55, 16);
		internalFrame.getContentPane().add(lblNewLabel_11);

		gstRecords = new JTextField();
		gstRecords.setBounds(1197, 247, 55, 28);
		internalFrame.getContentPane().add(gstRecords);
		gstRecords.setColumns(10);

		gstAmount = new JTextField();
		gstAmount.setBounds(1251, 247, 97, 28);
		internalFrame.getContentPane().add(gstAmount);
		gstAmount.setColumns(10);

		JLabel lblMissingLedgerEntries = new JLabel("Missing Ledger Entries");
		lblMissingLedgerEntries.setForeground(Color.BLACK);
		lblMissingLedgerEntries.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblMissingLedgerEntries.setBounds(1059, 434, 137, 16);
		internalFrame.getContentPane().add(lblMissingLedgerEntries);

		JLabel label_1 = new JLabel("Records");
		label_1.setBounds(1197, 416, 55, 16);
		internalFrame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Amount");
		label_2.setBounds(1264, 416, 55, 16);
		internalFrame.getContentPane().add(label_2);

		crdrRecords = new JTextField();
		crdrRecords.setColumns(10);
		crdrRecords.setBounds(1193, 428, 55, 28);
		internalFrame.getContentPane().add(crdrRecords);

		crdrAmount = new JTextField();
		crdrAmount.setColumns(10);
		crdrAmount.setBounds(1247, 428, 97, 28);
		internalFrame.getContentPane().add(crdrAmount);

		jsp3 = new JScrollPane();
		jsp3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp3.setBounds(990, 454, 360, 139);
		internalFrame.getContentPane().add(jsp3);
		RepostingFrame.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { from, to, btnRepost, btnClose, btnPur, btnSale, btnPurret,
						btnSaleret, btnReceipts, btnPayment, btnContra, btnAdvsup, btnAdvcus }));
		internalFrame.setVisible(true);
		ActionListener btnrpt = new btnRepost();
		btnRepost.addActionListener(btnrpt);

		ActionListener btnaction = new btnLsnr();
		btnPurret.addActionListener(btnaction);
		btnExpense.addActionListener(btnaction);
		btnIncome.addActionListener(btnaction);
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

		new BackupDB().TakeBackup(new gnPublicVariable().DbBackupPath());

		btnAdvcus.setVisible(false);
		btnAdvsup.setVisible(false);
		finyear.setText(new gnFinYear().getReportingFinYear());
		new gnApp().setFrameTitel(RepostingFrame);
		new gnField().closeform(internalFrame, RepostingFrame);
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
		new gnDecorate().decorateBtn(btnIncome, new Color(178, 11, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnExpense, new Color(178, 11, 112), Color.WHITE);

		new gnStyleButtonSqr().getStyleButton(btnPur, new Color(178, 11, 112), Color.WHITE);
		new gnStyleButtonSqr().getStyleButton(btnSale, new Color(120, 151, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnReceipts, new Color(131, 211, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnPayment, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnContra, new Color(178, 11, 112), Color.WHITE);
		new gnStyleButtonSqr().getStyleButton(btnAdvsup, new Color(120, 151, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnAdvcus, new Color(131, 211, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnSaleret, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnPurret, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnIncome, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnExpense, new Color(56, 189, 112), Color.BLACK);

	}

	class btnRepost implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			value1 = e.getActionCommand();
			if (value1 == "Repost Entries") {
				try {
					PostEntries();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		}
	}

	private void cogsAvgcost_Calculate() throws ClassNotFoundException, SQLException {
		new gnDecorate().setBusyCursor(RepostingFrame);
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
			value2 = "";
			if (value == "Cogs Calculation") {
				try {
					cogsAvgcost_Calculate();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Close") {
				RepostingFrame.dispose();
			}

			if (value == "Income") {
				value2 = "IN";
				try {
					ProcessAction();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Expense") {
				value2 = "EX";
				try {
					ProcessAction();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Purchase") {
				value2 = "GRN";
				btnPur.setBackground(Color.blue);
				btnPur.setForeground(Color.WHITE);
				try {
					ProcessAction();
					// decorate();
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

			String vvfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
			String vvto = new gnConfig().date_ConverttoDBforamt(vto);
			String Col[] = { "Tr.Type", "Doc Type", "Doc.Date", "Doc. No.", "Party Code", "Party Name",
					"Transaction Amount" };
			String Col1[] = { "Doc.Type", "TR.Type", "Doc.Date", "Doc. No.", "Bankcode", "Name", "Other Bankcode",
					"Transaction Amount", "Payment Mode", "Chq/DD N0", "Chq/dd Date" };
			String Col2[] = { "Doc.Type", "TR.Type", "Doc.Date", "Doc. No.", "Bankcode", "Name", "Party Code",
					"Transaction Amount", "Payment Mode", "Chq/DD N0", "Chq/dd Date" };

			model.setColumnIdentifiers(Col);
			table.setModel(model);
			new gnTable().RemoveTableRows(model);
			JViewport prt = new JViewport();

			switch (value2) {

			case "SR":
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value2 + "' )";
				// new General().Devmsg(SQL);
				new gnTableModel().Tablemodel(table, model, SQL, Col, 6, "N", "Y", value2);
				prt = new JViewport();
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 6)));
				break;

			case "PR":
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value2 + "' )";
				// new General().Devmsg(SQL);
				new gnTableModel().Tablemodel(table, model, SQL, Col, 6, "N", "Y", value2);
				prt = new JViewport();
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 6)));
				break;

			case ("GRN"):
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value2 + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col, 6, "N", "Y", value2);
				prt = new JViewport();
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 6)));
				break;

			case ("SALE"):
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value2 + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col, 6, "N", "Y", value2);
				prt = new JViewport();
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 6)));
				break;

			case ("CO"):
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value2 + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col1, 10, "N", "Y", value2);
				prt = new JViewport();
				prt.add(table, Col1);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 7)));
				break;

			case ("PV"):
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value2 + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col2, 10, "N", "Y", value2);
				prt = new JViewport();
				prt.add(table, Col2);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 7)));
				break;

			case ("RV"):
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value2 + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col2, 10, "N", "Y", value2);
				prt = new JViewport();
				prt.add(table, Col2);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 7)));
				break;

			case ("SAD"):
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value2 + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col2, 10, "N", "Y", value2);
				prt = new JViewport();
				prt.add(table, Col2);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 7)));
				break;

			case ("CAD"):
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value2 + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col2, 10, "N", "Y", value2);
				prt = new JViewport();
				prt.add(table, Col2);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 7)));
				break;

			case ("IN"):
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value2 + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col2, 10, "N", "Y", value2);
				prt = new JViewport();
				prt.add(table, Col2);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 7)));
				break;

			case ("EX"):
				SQL = "Call 	Account_getRepostingEntries(" + vcomp + " , " + vstore + " , '" + vvfrom + "' , '"
						+ vvto + "' , '" + value2 + "' )";
				new gnTableModel().Tablemodel(table, model, SQL, Col2, 10, "N", "Y", value2);
				prt = new JViewport();
				prt.add(table, Col2);
				prt.setVisible(true);
				jsp.setViewport(prt);
				record.setText(Integer.toString(table.getRowCount()));
				amount.setText(Double.toString(new gnTable().getTotal(table, 7)));
				break;

			}
			showAccountMissingEntry();
			showLedgerMissingEntry();
			showGSTMissingEntry();
			btnRepost.setVisible(true);

		}
		Selectrow1();
	}

	private void showGSTMissingEntry() throws ClassNotFoundException, SQLException {
		gstRecords.setText("0");
		gstAmount.setText("0.00");
		// btnRepost.setVisible(false);
		new gnTable().RemoveTableRows(model2);
		table2.setModel(model2);
		String col123[] = { "DocType", "Doc.No", "Doc.Date", "Amount", "Party" };
		String vfinyear = finyear.getText();

		if (value2 != "RV" & value2 != "PV" & value2 != "CO") {
			String SQL = " Call Acc_GST_MissingData('" + value2 + "' , " + vcomp + " , " + vstore + ", '" + vfinyear
					+ "')";
			new gnTableModel().Tablemodel(table2, model2, SQL, col123, 4, "N", "Y", value2);
			new gnTable().setTableBasics(table2);
			gstRecords.setText(Integer.toString(new gnTable().getRowCount(table2)));
			gstAmount.setText(Double.toString(new gnTable().getTotal(table2, 3)));

			table2.setBackground(Color.RED);
			table2.setForeground(Color.WHITE);

			JViewport prt11 = new JViewport();
			prt11.add(table2);
			prt11.setVisible(true);
			prt11.setBackground(Color.WHITE);
			jsp2.setViewport(prt11);

			int row1 = table1.getRowCount();
			int row2 = table2.getRowCount();
			int row3 = table3.getRowCount();

			if (row1 == 0 || row2 == 0 || row3 == 0) {
				msg.setText("Reposting Is  Not Required");
				msg.setForeground(Color.BLUE);
			} else {
				new gnImageSound().playAlertSound();
				msg.setText("Reposting Is  Required");
				msg.setForeground(Color.RED);
				btnRepost.setVisible(true);
			}
		}
	}

	private void showAccountMissingEntry() throws ClassNotFoundException, SQLException {

		btnRepost.setVisible(false);
		new gnTable().RemoveTableRows(model1);
		table1.setModel(model1);
		String col123[] = { "Doc Type", "Doc.No", "Doc.Date", "Amount", "Fin.Year" };
		String vfinyear = finyear.getText();
		String SQL = " Call   Acc_Account_MissingEntry( '" + value2 + "' ,  " + vcomp + " , " + vstore + ", '"
				+ vfinyear + "'  )";
		new gnTableModel().Tablemodel(table1, model1, SQL, col123, 5, "N", "N", "N");
		new gnTable().setTableBasics(table1);
		accRecords.setText(Integer.toString(new gnTable().getRowCount(table1)));
		accAmount.setText(Double.toString(new gnTable().getTotal(table1, 3)));
		table1.setBackground(Color.RED);
		table1.setForeground(Color.WHITE);

		JViewport prt1 = new JViewport();
		prt1.add(table1);
		prt1.setVisible(true);
		prt1.setBackground(Color.WHITE);
		jsp1.setViewport(prt1);

		int row1 = table1.getRowCount();
		int row2 = table2.getRowCount();
		int row3 = table3.getRowCount();
		if (row1 == 0 || row2 == 0 || row3 == 0) {
			msg.setText("Reposting Is  Not Required");
			msg.setForeground(Color.BLUE);
		} else {
			new gnImageSound().playAlertSound();
			msg.setText("Reposting Is  Required");
			msg.setForeground(Color.RED);
			btnRepost.setVisible(true);
		}
		btnRepost.setVisible(true);
	}

	private void showLedgerMissingEntry() throws ClassNotFoundException, SQLException {
		crdrRecords.setText("0");
		crdrAmount.setText("0.00");
		btnRepost.setVisible(false);
		new gnTable().RemoveTableRows(model3);
		table3.setModel(model3);
		String col123[] = { "DocType", "Doc.No", "Doc.Date", "Amount", "Finyear" };
		String vfinyear = finyear.getText();
		String SQL = " Call   Acc_Crdr_MissingEntry( '" + value2 + "' , " + vcomp + " , " + vstore + ", '" + vfinyear
				+ "')";
		new gnTableModel().Tablemodel(table3, model3, SQL, col123, 5, "N", "N", "N");
		new gnTable().setTableBasics(table3);
		gstRecords.setText(Integer.toString(new gnTable().getRowCount(table3)));
		gstAmount.setText(Double.toString(new gnTable().getTotal(table3, 3)));
		table3.setBackground(Color.RED);
		table3.setForeground(Color.WHITE);

		JViewport prt111 = new JViewport();
		prt111.add(table3);
		prt111.setVisible(true);
		prt111.setBackground(Color.WHITE);
		jsp3.setViewport(prt111);
		int row3 = table3.getRowCount();
		int row1 = table1.getRowCount();
		int row2 = table2.getRowCount();

		if (row1 == 0 & row2 == 0 & row3 == 0) {
			msg.setText("Reposting Is  Not Required");
			msg.setForeground(Color.BLUE);
		} else {
			new gnImageSound().playAlertSound();
			msg.setText("Reposting Is  Required");
			msg.setForeground(Color.RED);
			btnRepost.setVisible(true);
		}
	}

	public void Selectrow1() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.requestFocus();
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String vtype = "GRN";
				String vdocno = table.getValueAt(row, 3).toString();
				String vdocdate = table.getValueAt(row, 2).toString();
				try {
					switch (value2) {
					case "EX":
						vtype = "EX";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;

					case "IN":
						vtype = "IN";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;
					case "GRN":
						vtype = "GRN";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;
					case "SALE":
						vtype = "PS";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						vtype = "WS";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;
					case "PV":
						vtype = "PV";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;
					case "RV":
						vtype = "RV";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;
					case "CO":
						vtype = "CON";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;
					case "PR":
						vtype = "PR";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;
					case "SR":
						vtype = "SR";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;
					}
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
				}
				;
			}
		});
	}

	private void PostEntries() throws Throwable {
		// new General().msg("Posting Entries Now") ;
		new gnDecorate().setBusyCursor(RepostingFrame);
		new gnReposting().processPostingEntries(vfrom, vto, value2);
		new gnTable().RemoveTableRows(model);
		new gnDecorate().setDefaultCursor(RepostingFrame);
	}
}// Last

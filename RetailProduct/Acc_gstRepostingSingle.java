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
import javax.swing.table.TableCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;

public class Acc_gstRepostingSingle extends getResultSet {

	JFrame SingleRepostingFrame;
	JInternalFrame internalFrame;
	String SQL = "";
	JButton btnUpdateCogs;
	String vcomp;
	String vstore;
	private JTextField from;
	private JTextField to;
	String vfrom;
	String vto;
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

	DefaultTableModel model2 = new DefaultTableModel();
	JTable table2 = new JTable();

	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 3) {
				componentt.setBackground(Color.black);
				componentt.setForeground(Color.white);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
				componentt.setFont(new Font("Calibri", Font.BOLD, 16));
			}
			return componentt;
		}
	};

	DefaultTableModel model1 = new DefaultTableModel();
	JTable table1 = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 1 || column == 2 || column == 3 || column == 4) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.RED);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
				componentt.setFont(new Font("Calibri", Font.BOLD, 11));
			}
			return componentt;
		}
	};

	private JTextField record;
	private JTextField amount;
	public JTextField processingRecord;
	private JTextField finyear;
	private JLabel msg;
	private JButton btnIncome;
	private JButton btnExpense;
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
					Acc_gstRepostingSingle window = new Acc_gstRepostingSingle();
					window.SingleRepostingFrame.setVisible(true);
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
	public Acc_gstRepostingSingle() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		SingleRepostingFrame = new JFrame();
		SingleRepostingFrame.setBounds(1, 0, 1370, 700);
		SingleRepostingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SingleRepostingFrame.getContentPane().setLayout(null);

		internalFrame = new JInternalFrame("Reposting Module- For Single Entry");
		internalFrame.getContentPane().setBackground(Color.WHITE);
		internalFrame.setForeground(new Color(0, 102, 153));
		internalFrame.setBackground(Color.CYAN);
		internalFrame.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		internalFrame.setBounds(0, 0, 1360, 690);
		SingleRepostingFrame.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1344, 34);
		panel.setBorder(new LineBorder(new Color(0, 255, 204), 3));
		panel.setBackground(Color.WHITE);
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
		lblNewLabel_1.setBounds(162, 10, 28, 16);
		panel.add(lblNewLabel_1);

		from = new JTextField();
		from.setForeground(new Color(0, 51, 153));
		from.setFont(new Font("Calibri", Font.BOLD, 13));
		from.setBounds(46, 0, 97, 32);
		panel.add(from);
		from.setColumns(10);

		to = new JTextField();
		to.setForeground(new Color(0, 51, 153));
		to.setFont(new Font("Calibri", Font.BOLD, 13));
		to.setBounds(188, 0, 116, 32);
		panel.add(to);
		to.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel(
				"Note: Reposting entry module will remove existing  Accounting entries and repost entries [For selected transaction Only]");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setIcon(null);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_3.setBounds(427, 4, 767, 29);
		panel.add(lblNewLabel_3);

		btnUpdateCogs = new JButton("Cogs Calculation");
		btnUpdateCogs.setBounds(1189, 4, 149, 29);
		panel.add(btnUpdateCogs);

		finyear = new JTextField();
		finyear.setFont(new Font("Tahoma", Font.PLAIN, 15));
		finyear.setEditable(false);
		finyear.setForeground(Color.YELLOW);
		finyear.setBackground(Color.BLACK);
		finyear.setBounds(302, 3, 116, 31);
		panel.add(finyear);
		finyear.setColumns(10);
		finyear.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 35, 115, 593);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 255, 204), null));
		internalFrame.getContentPane().add(panel_1);
		panel_1.setBackground(new Color(102, 255, 255));
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
		btnPurret.setBounds(0, 263, 115, 34);
		panel_1.add(btnPurret);

		btnSaleret = new JButton("Sale Return");
		btnSaleret.setFont(new Font("Cambria", Font.BOLD, 13));
		btnSaleret.setMnemonic('A');
		btnSaleret.setBounds(0, 295, 115, 34);
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
		btnAdvsup.setBounds(0, 389, 115, 34);
		panel_1.add(btnAdvsup);

		btnAdvcus = new JButton("Adv.Customer");
		btnAdvcus.setFont(new Font("Cambria", Font.BOLD, 13));
		btnAdvcus.setMnemonic('M');
		btnAdvcus.setBounds(0, 423, 115, 34);
		panel_1.add(btnAdvcus);

		JLabel lblNewLabel_2 = new JLabel("Select Transaction");
		lblNewLabel_2.setForeground(new Color(0, 0, 153));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(0, 0, 115, 16);
		panel_1.add(lblNewLabel_2);

		btnIncome = new JButton("Income");
		btnIncome.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIncome.setMnemonic('I');
		btnIncome.setBounds(0, 190, 115, 34);
		panel_1.add(btnIncome);

		btnExpense = new JButton("Expense");
		btnExpense.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExpense.setMnemonic('E');
		btnExpense.setBounds(0, 226, 115, 34);
		panel_1.add(btnExpense);

		jsp = new JScrollPane();
		jsp.setToolTipText(
				"Total Transaction For The Given Period & Financial Year .Select Transaction For Reposting ");
		jsp.setBounds(117, 37, 880, 544);
		jsp.setViewportBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 0, 0), Color.MAGENTA,
				new Color(0, 0, 0), new Color(255, 0, 0)));
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		internalFrame.getContentPane().add(jsp);

		btnRepost = new JButton("Repost Entries");
		btnRepost.setBounds(633, 592, 137, 34);
		internalFrame.getContentPane().add(btnRepost);
		btnRepost.setFont(new Font("Cambria", Font.BOLD, 14));
		btnRepost.setMnemonic('O');

		btnClose = new JButton("Close");
		btnClose.setBounds(767, 592, 90, 34);
		internalFrame.getContentPane().add(btnClose);
		btnClose.setFont(new Font("Cambria", Font.BOLD, 14));
		btnClose.setMnemonic('C');

		JLabel lblNewLabel_4 = new JLabel("Records");
		lblNewLabel_4.setBounds(216, 602, 55, 16);
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		internalFrame.getContentPane().add(lblNewLabel_4);

		record = new JTextField();
		record.setBounds(271, 586, 122, 42);
		record.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		internalFrame.getContentPane().add(record);
		record.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Amount");
		lblNewLabel_5.setBounds(415, 602, 55, 16);
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		internalFrame.getContentPane().add(lblNewLabel_5);

		amount = new JTextField();
		amount.setBounds(465, 586, 122, 42);
		amount.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		internalFrame.getContentPane().add(amount);
		amount.setColumns(10);

		processingRecord = new JTextField();
		processingRecord.setEditable(false);
		processingRecord.setBounds(857, 586, 140, 42);
		internalFrame.getContentPane().add(processingRecord);
		processingRecord.setColumns(10);

		jsp1 = new JScrollPane();
		jsp1.setBounds(995, 70, 349, 296);
		jsp1.setToolTipText("Entries in This Area is Missing in Accounting Table Please Select Docno And Repost ...");
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		internalFrame.getContentPane().add(jsp1);

		JLabel lblNewLabel_6 = new JLabel("Missing Account Entries");
		lblNewLabel_6.setBounds(995, 41, 140, 16);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		internalFrame.getContentPane().add(lblNewLabel_6);

		msg = new JLabel("---------->");
		msg.setFont(new Font("Arial Black", Font.BOLD, 13));
		msg.setBounds(1007, 592, 337, 28);
		internalFrame.getContentPane().add(msg);

		JLabel lblNewLabel_7 = new JLabel("Missing GST Entries");
		lblNewLabel_7.setBounds(995, 367, 130, 16);
		internalFrame.getContentPane().add(lblNewLabel_7);

		jsp2 = new JScrollPane();
		jsp2.setBounds(995, 404, 349, 176);
		internalFrame.getContentPane().add(jsp2);

		JLabel lblNewLabel_8 = new JLabel("Record");
		lblNewLabel_8.setBounds(1151, 367, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Amount");
		lblNewLabel_9.setBounds(1240, 367, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Record");
		lblNewLabel_10.setBounds(1167, 33, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Amount");
		lblNewLabel_11.setBounds(1240, 33, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel_11);

		accRecords = new JTextField();
		accRecords.setBounds(1161, 47, 61, 22);
		internalFrame.getContentPane().add(accRecords);
		accRecords.setColumns(10);

		accAmount = new JTextField();
		accAmount.setBounds(1228, 47, 116, 22);
		internalFrame.getContentPane().add(accAmount);
		accAmount.setColumns(10);

		gstRecords = new JTextField();
		gstRecords.setBounds(1143, 383, 61, 22);
		internalFrame.getContentPane().add(gstRecords);
		gstRecords.setColumns(10);

		gstAmount = new JTextField();
		gstAmount.setBounds(1207, 383, 116, 22);
		internalFrame.getContentPane().add(gstAmount);
		gstAmount.setColumns(10);
		SingleRepostingFrame.setFocusTraversalPolicy(
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
		btnIncome.addActionListener(btnaction);
		btnExpense.addActionListener(btnaction);

		btnUpdateCogs.addActionListener(btnaction);

		decorate();
	}

	private void decorate() throws Throwable {
		btnAdvcus.setVisible(false);
		btnAdvsup.setVisible(false);
		// btnRepost.setVisible(false);
		processingRecord.setVisible(false);

		new gnStyleButton().getStyleButton(btnClose, new Color(56, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnRepost, new Color(56, 211, 112), Color.WHITE);

		finyear.setText(new gnFinYear().getReportingFinYear());
		new gnApp().setFrameTitel(SingleRepostingFrame);
		new gnField().closeform(internalFrame, SingleRepostingFrame);
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
		new gnDecorate().decorateBtn(btnExpense, new Color(178, 11, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnIncome, new Color(178, 11, 112), Color.WHITE);

		new gnStyleButtonSqr().getStyleButton(btnPur, new Color(178, 11, 112), Color.WHITE);
		new gnStyleButtonSqr().getStyleButton(btnSale, new Color(120, 151, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnReceipts, new Color(131, 211, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnPayment, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnContra, new Color(178, 11, 112), Color.WHITE);
		new gnStyleButtonSqr().getStyleButton(btnAdvsup, new Color(120, 151, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnAdvcus, new Color(131, 211, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnSaleret, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnPurret, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnExpense, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnIncome, new Color(56, 189, 112), Color.BLACK);

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
		new gnDecorate().setBusyCursor(SingleRepostingFrame);
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
				SingleRepostingFrame.dispose();
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
			}
			Selectrow1();
			showMissingEntry();
			showGSTMissingEntry();
		}
	}

	private void showGSTMissingEntry() throws ClassNotFoundException, SQLException {
		gstRecords.setText("0");
		gstAmount.setText("0.00");
		// btnRepost.setVisible(false);
		new gnTable().RemoveTableRows(model2);
		table2.setModel(model2);
		String col123[] = { "DocType", "Doc.No", "Doc.Date", "Amount", "Party" };
		String vfinyear = finyear.getText();
		String SQL = " Call Acc_GST_MissingData('" + value2 + "' , " + vcomp + " , " + vstore + ", '" + vfinyear + "')";
		new gnTableModel().Tablemodel(table2, model2, SQL, col123, 4, "N", "Y", value2);
		new gnTable().setTableBasics(table2);
		gstRecords.setText(Integer.toString(new gnTable().getRowCount(table2)));
		gstAmount.setText(Double.toString(new gnTable().getTotal(table2, 3)));

		JViewport prt11 = new JViewport();
		prt11.add(table2);
		prt11.setVisible(true);
		prt11.setBackground(Color.WHITE);
		jsp2.setViewport(prt11);

	}

	private void showMissingEntry() throws ClassNotFoundException, SQLException {
		// btnRepost.setVisible(true);
		new gnTable().RemoveTableRows(model1);
		table1.setModel(model1);
		String col123[] = { "Doc Type", "Doc.No", "Doc.Date", "Amount", "Fin.Year" };
		String vfinyear = finyear.getText();
		String SQL = " Call acc_Account_MissingEntry ('" + value2 + "' ," + vcomp + " , " + vstore + ", '" + vfinyear
				+ "'  )";
		new gnTableModel().Tablemodel(table1, model1, SQL, col123, 5, "N", "N", "N");
		new gnTable().setTableBasics(table1);
		accRecords.setText(Integer.toString(new gnTable().getRowCount(table1)));
		accAmount.setText(Double.toString(new gnTable().getTotal(table1, 3)));
		JViewport prt1 = new JViewport();
		prt1.add(table1);
		prt1.setVisible(true);
		prt1.setBackground(Color.WHITE);
		jsp1.setViewport(prt1);

	}

	public void Selectrow1() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.requestFocus();
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String vtype = "";
				String vdocno = table.getValueAt(row, 3).toString();
				String vdocdate = table.getValueAt(row, 2).toString();
				try {
					switch (value) {

					case "Purchase":
						vtype = "GRN";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;
					case "Sales":
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
					case "Pur.Return":
						vtype = "PR";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;
					case "Sale Return":
						vtype = "SR";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;
					case "EX":
						vtype = "EX";
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
						break;
					case "IN":
						vtype = "IN";
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
		try {
			new gnDecorate().setBusyCursor(SingleRepostingFrame);
			int row = table.getSelectedRow();
			String vdocdate = table.getValueAt(row, 2).toString();
			String vdocno = table.getValueAt(row, 3).toString();

			if (value2 == "EX" || value2 == "IN" || value2 == "CO" || value2 == "PV" || value2 == "RV") {
				this.vbankgl = "";
				this.vpaymenmode = "";
				this.vchqddno = "0";
				this.vchqdddate = "";
				String vpmode = table.getValueAt(row, 8).toString();
				String vamount = table.getValueAt(row, 7).toString();
				String vpartycode = table.getValueAt(row, 6).toString();
				String vbankcode = table.getValueAt(row, 4).toString();
				String vchqno = table.getValueAt(row, 9).toString();
				String vchqdate = table.getValueAt(row, 10).toString();
				this.vbankgl = vbankcode;
				this.vpaymenmode = vpmode;
				this.vchqddno = vchqno;
				this.vchqdddate = new gnConfig().date_ConverttoDBforamt(vchqdate);
			}

			new gnRepostSingleEntry().processPostingEntries(value2, vdocno, vdocdate);
			new gnTable().RemoveTableRows(model);
			new gnDecorate().setDefaultCursor(SingleRepostingFrame);
			new General().Quickmsg("Account Entry Posed sucessfully..");
			new gnImageSound().playSound();

		} catch (Exception e) {
			e.printStackTrace();
			new General().msg("Reposting Error :-->" + "" + e.getLocalizedMessage());
		}
	}

}// Last

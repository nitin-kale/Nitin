package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import RetailProduct.ApplicationMenu.btnfocus;
import RetailProduct.ApplicationMenu.keyPressedlsnr;
//import RetailProduct.POS.discLsnr;
import RetailProduct.POS.scanqtyLsnr;
import RetailProduct.POS.scanrateLsnr;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;

public class creditSalesPOS1 extends getResultSet {

	JFrame creditsalesFrame1;
	public String vpaymentmode;
	public Double vpaymentamount;
	private String vglcode;
	JButton btnShowInv;
	// ====================For Payment Reference ==================
	public static String vpaytype;
	public static String vinvdate;

	public static String vinvno;
	public static String vnetamount;
	JButton btnReceipts;
	public static String vcustomer;
	JButton btnEdit;
	public static String EditMode = "N";
	// =========================
	private String vmygstno;
	String vallow;
	private int vmy;
	private int voth;
	private String advdate;
	private String vmycompanystate;
	private String vmyCompanyisGST;
	private String vshipbillno;
	private String vshipbilldate;
	private String vstate;
	private String vstatename;
	private String vregdlr;
	JButton btnAcEntry;
	private String vcustGSTno;
	private String vmovtype;
	JCheckBox sez;
	String vdoctype2 = "";
	String vtaxtype = " ";
	String vcgst = "";
	String vsgst = "";
	String vigst = " ";

	JCheckBox exportsales;
	JCheckBox chrevchrg;
	private String vreversechrg;
	private String vsez;
	private String vexport;
	private String vexpporttype;

	// =========================================================
	private Connection con1, con2, con3, con4, con5, con6, con7, con8;
	private String vcheckMargin;
	private int selectedrow;
	private String vuser;
	private String vterminal;
	private String vtime;
	private String vverticle;
	private Double vvggross = 0.00;
	private Double vvdisc = 0.00;
	private JButton btnSave;
	private JButton btnBatch;
	private JButton btnPrint;
	private JButton btnCancel;
	private JButton btnPayment;
	private JButton btnDeclare;
	private JButton btnCustomer;
	private JButton btnHold;
	private JButton btnUnhold;
	private JTextField scanarticle;
	private JTextField searchname;
	private String vcreditDays;
	JInternalFrame internalFrame;

	private String statusCC = "Sucess";
	private String statusCA = "Sucess";
	private String statusCN = "Sucess";
	private String DBaction;
	private String vmystatename;

	private final ButtonGroup buttonGroup = new ButtonGroup();

	// Variables For GUI
	private String vcomp;
	private String vstore;
	private JRadioButton b2b;
	private JRadioButton wsale;
	private JPanel selectionPanel;
	private JPanel paymentPanel;
	private JPanel panel;
	private String vadvrcptno;
	private JComboBox selection;
	private JTextField Tamount;
	private String menu;
	private JLabel lblNewLabel_3;
	private JTextField Quotno;
	private JTextField customercode;
	private JTextField customername;
	private JLabel lblNewLabel_4;
	private JTextField validupto;
	private JPanel quotPanel;
	private JLabel lblNewLabel_6;
	private JTextField amount;
	private JLabel lblNewLabel_7;
	private JTextField advance;
	private JLabel Msg;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField invno;
	private JTextField invdate;
	private JPanel scanPanel;
	//
	private String vsalestype;
	private String vinvtype;
	private String vpostingtype;
	private String DBdetail;
	private String DBhdr;
	private JRadioButton rbcashsale;
	private JRadioButton rbcrsale;

	public JTable stable = new JTable();
	public JScrollPane sjsp = new JScrollPane();
	public JViewport prt6 = new JViewport();
	public DefaultTableModel smodel = new DefaultTableModel();
	private Double vdueamount;

	public DefaultTableModel pmodel = new DefaultTableModel();
	public String paycol[] = { "Romove", "Mode", "Amount", "Card" };
	public JScrollPane pjsp = new JScrollPane();
	public JTable ptable = new JTable();

	private JScrollPane jsp;
	public String poscol[] = { "Romove", "Item", "Name", "Qty", "UOM", "Inner Qty", "Rate", "MRP", "Gross", "Bill Disc",
			"Disc", "Amount", "Tax%", "Tax Amount", "Batch Item", "BatchNo", "Exp.Date", "Cost", "Location" };

	private Object[][] data = {
			// {"Boolean" , Boolean.FALSE};
			{ "String", "" }, { "String", "" }, { "String", " " }, { "Double", new Double(123.45) }, { "String", " " },
			{ "Double", new Double(123.45) }, { "Double", new Double(123.45) }, { "Double", new Double(123.45) },
			{ "Double", new Double(123.45) }, { "Double", new Double(123.45) }, { "Double", new Double(123.45) },
			{ "Double", new Double(123.45) }, { "Double", new Double(123.45) }, { "Double", new Double(123.45) },
			{ "Double", new Double(123.45) }, { "String", "" }, { "String", " " }, { "Date", new Date() },
			{ "Double", new Double(123.45) } };

	//
	// public String poscol[] = {"Romove", 1"Item",2 "Name", 3"Qty" , 4 "UOM", 5
	// "Inner Qty" ,6 "Rate" , 7 "MRP", 8"Gross" ,9"Hdr Disc", 10"Disc" ,
	// 11"Amount", 12"Taxcode" ,13 "Tax Amount",
	// 14"Batch Item" , 15"BatchNo", 16"Exp.Date" ,17 "Cost"};

	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 3 || column == 4 || column == 5 || column == 6 || column == 10
					|| column == 15 || column == 16 || column == 17 || column == 18 ? true : false;
		}
	};

	//// Table Related
	public JTable table = new JTable(data, poscol) {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			// 3 4 5 6 9 10 15 16
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 4 || column == 5 || column == 6 || column == 10 || column == 15
					|| column == 16 || column == 18) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}

			if (Language == "H") {
				if (column == 2) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}
			return componentt;

		}
	};
	///

	private JPanel panel_3;

	//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					creditSalesPOS1 window = new creditSalesPOS1();
					window.creditsalesFrame1.setVisible(true);
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
	public creditSalesPOS1() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		creditsalesFrame1 = new JFrame();
		creditsalesFrame1.setResizable(false);
		creditsalesFrame1.setAlwaysOnTop(true);
		creditsalesFrame1.setBounds(1, 0, 1356, 760);
		creditsalesFrame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		creditsalesFrame1.getContentPane().setLayout(null);

		internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setEnabled(false);
		internalFrame.getContentPane().setBackground(new Color(0, 0, 51));
		internalFrame.setBounds(6, 0, 1350, 715);
		creditsalesFrame1.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(0, 0, 1338, 201);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 250, 205));
		panel_1.setBackground(new Color(0, 0, 51));
		panel_1.setBorder(new LineBorder(Color.WHITE, 3, true));
		panel_1.setBounds(6, 0, 424, 198);
		panel.add(panel_1);
		panel_1.setLayout(null);

		b2b = new JRadioButton("B2B Sales");
		b2b.setForeground(Color.WHITE);
		b2b.setBackground(new Color(0, 0, 51));
		b2b.setFont(new Font("Arial", Font.BOLD, 12));
		buttonGroup.add(b2b);
		b2b.setBounds(326, 7, 90, 18);
		panel_1.add(b2b);

		wsale = new JRadioButton("WholeSale");
		wsale.setForeground(Color.WHITE);
		wsale.setBackground(new Color(0, 0, 51));
		wsale.setFont(new Font("Arial", Font.BOLD, 12));
		buttonGroup.add(wsale);
		wsale.setBounds(96, 7, 96, 18);
		panel_1.add(wsale);

		lblNewLabel_8 = new JLabel("Invoice No");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Agency FB", Font.BOLD, 21));
		lblNewLabel_8.setBounds(323, 25, 80, 18);
		panel_1.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("Invoice Date");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Agency FB", Font.BOLD, 21));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(207, 25, 98, 16);
		panel_1.add(lblNewLabel_9);

		invno = new JTextField();
		invno.setHorizontalAlignment(SwingConstants.LEFT);
		invno.setForeground(Color.WHITE);
		invno.setToolTipText("Invoice No - Auto Generated Code");
		invno.setFont(new Font("Arial", Font.BOLD, 16));
		invno.setBackground(new Color(0, 0, 51));
		invno.setEditable(false);
		invno.setBounds(317, 47, 99, 27);
		panel_1.add(invno);
		invno.setColumns(10);

		invdate = new JTextField();
		invdate.setHorizontalAlignment(SwingConstants.LEFT);
		invdate.setForeground(Color.WHITE);
		invdate.setToolTipText("Billing Date");
		invdate.setText(" ");
		invdate.setFont(new Font("Arial", Font.BOLD, 16));
		invdate.setBackground(new Color(0, 0, 51));
		invdate.setEditable(false);
		invdate.setBounds(207, 47, 96, 28);
		panel_1.add(invdate);
		invdate.setColumns(10);

		rbcrsale = new JRadioButton("Credit Sale");
		rbcrsale.setBounds(9, 5, 99, 22);
		panel_1.add(rbcrsale);
		rbcrsale.setSelected(true);
		rbcrsale.setBackground(new Color(0, 0, 51));
		rbcrsale.setForeground(Color.WHITE);
		rbcrsale.setFont(new Font("Arial", Font.BOLD, 12));
		buttonGroup_1.add(rbcrsale);

		rbcashsale = new JRadioButton("Cash Sale");
		rbcashsale.setBounds(198, 4, 90, 24);
		panel_1.add(rbcashsale);
		rbcashsale.setForeground(Color.WHITE);
		// rbcashsale.setEnabled(false);
		rbcashsale.setVisible(false);
		rbcashsale.setBackground(new Color(0, 0, 51));
		rbcashsale.setFont(new Font("Arial", Font.BOLD, 12));
		buttonGroup_1.add(rbcashsale);

		paymentPanel = new JPanel();
		paymentPanel.setBorder(new TitledBorder(null, "Customer Payment  Information", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		paymentPanel.setBounds(828, 31, 504, 101);
		ActionListener custno = new custcodeLsnr();
		ActionListener custname = new custnameLsnr();
		ActionListener rbpay = new rbpayLsnr();
		ActionListener cr = new crdaysLsnr();

		lblNewLabel_21 = new JLabel("Select Customer Here ");
		lblNewLabel_21.setBounds(6, 59, 131, 16);
		panel_1.add(lblNewLabel_21);
		lblNewLabel_21.setFont(new Font("Agency FB", Font.BOLD, 17));
		lblNewLabel_21.setForeground(Color.WHITE);

		customercode = new JTextField();
		customercode.setBounds(8, 79, 63, 27);
		panel_1.add(customercode);
		customercode.setBackground(Color.CYAN);
		customercode.setText("0");
		customercode.addActionListener(custno);
		customercode.setColumns(10);

		customername = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		customername.setFont(new Font("Tahoma", Font.BOLD, 15));
		customername.setBounds(68, 79, 348, 27);
		panel_1.add(customername);
		customername.setToolTipText("Select Customer For Credit Sales");
		customername.setBackground(Color.WHITE);
		customername.addActionListener(custname);
		customername.setColumns(10);

		tvalue = new JTextField();
		tvalue.setToolTipText("Amount After Discount(LineLevel+Bill Level)");
		tvalue.setFont(new Font("Arial", Font.BOLD, 20));
		tvalue.setBounds(1117, 103, 184, 30);
		panel.add(tvalue);
		tvalue.setForeground(Color.WHITE);
		tvalue.setBackground(Color.DARK_GRAY);
		tvalue.setHorizontalAlignment(SwingConstants.LEFT);
		tvalue.setColumns(10);

		roundingamt = new JTextField();
		roundingamt.setFont(new Font("Arial Black", Font.PLAIN, 14));
		roundingamt.setBounds(1117, 133, 184, 30);
		panel.add(roundingamt);
		roundingamt.setForeground(Color.WHITE);
		roundingamt.setBackground(Color.DARK_GRAY);
		roundingamt.setHorizontalAlignment(SwingConstants.LEFT);
		roundingamt.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Records");
		lblNewLabel_11.setBounds(818, 147, 55, 16);
		panel.add(lblNewLabel_11);
		lblNewLabel_11.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblNewLabel_11.setForeground(Color.BLACK);

		JLabel lblNewLabel_19 = new JLabel("Value After Disc");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_19.setBounds(994, 109, 111, 16);
		panel.add(lblNewLabel_19);
		lblNewLabel_19.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_19.setForeground(Color.BLACK);

		JLabel lblNewLabel_20 = new JLabel("Rounding Amt");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_20.setBounds(1005, 139, 100, 16);
		panel.add(lblNewLabel_20);
		lblNewLabel_20.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_20.setForeground(Color.BLACK);

		btnEdit = new JButton("Edit Sales");
		btnEdit.setBounds(427, 0, 263, 30);
		panel.add(btnEdit);
		btnEdit.setMnemonic('E');
		btnEdit.setBackground(new Color(51, 255, 255));
		btnEdit.setForeground(new Color(0, 0, 153));
		btnEdit.setFont(new Font("Cambria", Font.BOLD, 12));

		JLabel lblNewLabel_12 = new JLabel("Sales Amount");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setBounds(1005, 160, 100, 25);
		panel.add(lblNewLabel_12);
		lblNewLabel_12.setForeground(Color.BLACK);
		lblNewLabel_12.setFont(new Font("Agency FB", Font.BOLD, 21));

		Tamount = new JTextField();
		Tamount.setBounds(1117, 163, 184, 28);
		panel.add(Tamount);
		Tamount.setToolTipText("Total Sales Amount");
		Tamount.setHorizontalAlignment(SwingConstants.LEFT);
		Tamount.setBackground(Color.DARK_GRAY);
		Tamount.setFont(new Font("Arial", Font.BOLD, 20));
		Tamount.setForeground(Color.WHITE);
		Tamount.setEditable(false);
		Tamount.setColumns(10);

		// This Portion is for Quotation Handle//
		quotPanel = new JPanel();
		quotPanel.setBounds(433, 0, 306, 197);
		// panel.add(quotPanel);
		quotPanel.setForeground(new Color(0, 0, 102));
		quotPanel.setBackground(new Color(255, 255, 255));
		quotPanel.setBorder(new TitledBorder(new LineBorder(new Color(64, 64, 64), 1, true), "Quotation Details",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 51, 153)));
		quotPanel.setLayout(null);
		// This Portion is for Quotation Handle//

		lblNewLabel_6 = new JLabel("Amount");
		lblNewLabel_6.setForeground(new Color(0, 0, 102));
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_6.setBounds(115, 12, 55, 16);
		quotPanel.add(lblNewLabel_6);

		amount = new JTextField();
		amount.setForeground(Color.BLACK);
		amount.setFont(new Font("Calibri", Font.BOLD, 12));
		amount.setEditable(false);
		amount.setBackground(Color.WHITE);
		amount.setText("0");
		amount.setBounds(115, 30, 55, 22);
		quotPanel.add(amount);
		amount.setColumns(10);

		lblNewLabel_3 = new JLabel("Quotation");
		lblNewLabel_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_3.setBounds(14, 12, 69, 16);
		quotPanel.add(lblNewLabel_3);

		Quotno = new JTextField();
		Quotno.setFont(new Font("Calibri", Font.BOLD, 12));
		Quotno.setBounds(16, 30, 98, 22);
		quotPanel.add(Quotno);
		Quotno.setText("0");
		Quotno.setColumns(10);

		lblNewLabel_4 = new JLabel("Valid Upto");
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_4.setBounds(226, 12, 69, 16);
		quotPanel.add(lblNewLabel_4);

		validupto = new JTextField();
		validupto.setForeground(Color.BLACK);
		validupto.setFont(new Font("Calibri", Font.BOLD, 12));
		validupto.setBackground(Color.WHITE);
		validupto.setEnabled(false);
		validupto.setBounds(226, 30, 70, 22);
		quotPanel.add(validupto);
		validupto.setEditable(false);
		validupto.setColumns(10);

		lblNewLabel_7 = new JLabel("Adv.");
		lblNewLabel_7.setForeground(new Color(0, 0, 102));
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_7.setBounds(174, 12, 50, 16);
		quotPanel.add(lblNewLabel_7);

		advance = new JTextField();
		advance.setForeground(Color.BLACK);
		advance.setFont(new Font("Calibri", Font.BOLD, 12));
		advance.setEditable(false);
		advance.setBackground(Color.WHITE);
		advance.setText("0");
		advance.setBounds(174, 30, 50, 22);
		quotPanel.add(advance);
		advance.setColumns(10);

		Msg = new JLabel("..");
		Msg.setFont(new Font("Calibri", Font.BOLD, 13));
		Msg.setForeground(new Color(0, 0, 102));
		Msg.setHorizontalAlignment(SwingConstants.CENTER);
		Msg.setBounds(164, 166, 131, 16);
		quotPanel.add(Msg);

		JLabel lblNewLabel_5 = new JLabel("Bill Level Discount");
		lblNewLabel_5.setBounds(198, 12, 119, 16);
		quotPanel.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD, 13));

		selectionPanel = new JPanel();
		selectionPanel.setBounds(14, 85, 148, 61);
		quotPanel.add(selectionPanel);
		selectionPanel.setBackground(Color.WHITE);
		selectionPanel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Price Selection From",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		selectionPanel.setLayout(null);

		selection = new JComboBox();
		selection.setEnabled(true);
		// selection.setEditable(false);
		selection.setToolTipText(
				"Select Price Selection Method in Billing - Example> Normal Price Will Applicable to All Customer If Customer Specific Price Maintained then Select Proper Option");
		selection.setForeground(new Color(0, 0, 153));
		selection.setFont(new Font("Calibri", Font.BOLD, 12));
		selection.setBackground(Color.WHITE);
		selection.setModel(new DefaultComboBoxModel(new String[] { "Normal Price", "Price Master" }));
		selection.setBounds(12, 26, 110, 22);
		selectionPanel.add(selection);

		chrevchrg = new JCheckBox("Reverse Chrg");
		chrevchrg.setBounds(164, 82, 112, 18);
		quotPanel.add(chrevchrg);
		chrevchrg.setFont(new Font("Cambria", Font.BOLD, 13));
		chrevchrg.setForeground(new Color(0, 0, 153));
		chrevchrg.setEnabled(false);
		chrevchrg.setBackground(Color.WHITE);

		exportsales = new JCheckBox("Export(Sales)");
		exportsales.setBounds(164, 105, 112, 18);
		quotPanel.add(exportsales);
		exportsales.setFont(new Font("Calibri", Font.BOLD, 13));
		exportsales.setForeground(new Color(0, 0, 153));
		exportsales.setBackground(Color.WHITE);

		sez = new JCheckBox("SEZ(Sales)");
		sez.setBounds(164, 128, 112, 18);
		quotPanel.add(sez);
		sez.setFont(new Font("Calibri", Font.BOLD, 13));
		sez.setForeground(new Color(0, 0, 153));
		sez.setBackground(Color.WHITE);

		JLabel lblNewLabel_17 = new JLabel("Adv.Payment");
		lblNewLabel_17.setBounds(24, 165, 90, 16);
		quotPanel.add(lblNewLabel_17);
		lblNewLabel_17.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_17.setForeground(Color.BLACK);

		advno = new JTextField();
		advno.setBounds(110, 159, 50, 30);
		quotPanel.add(advno);
		advno.setEditable(false);
		advno.setEnabled(false);
		advno.setToolTipText("Adjust Advance Payment  Under  This Credit Invoice");
		advno.setColumns(10);

		panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_3.setBounds(0, 254, 1332, 380);
		internalFrame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		jsp = new JScrollPane();
		jsp.setViewportBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 0, 1332, 259);
		panel_3.add(jsp);

		ActionListener btn = new BtnPressLsnr();

		JPanel mysearch = new MySearchPanel();
		panel_5 = mysearch;

		ActionListener article = new ArticlecodeLsnr();
		ActionListener nm = new articlenameLsnr();
		ActionListener show = new ShowInvLsnr();

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 636, 1338, 42);
		internalFrame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(0, 51, 102));
		btnCancel.setFont(new Font("Calibri", Font.BOLD, 14));
		btnCancel.setBounds(490, 0, 79, 37);
		panel_4.add(btnCancel);
		btnCancel.setMnemonic('C');

		btnAcEntry = new JButton("Account Entry");
		btnAcEntry.setForeground(new Color(0, 51, 102));
		btnAcEntry.setFont(new Font("Calibri", Font.BOLD, 14));
		btnAcEntry.setBounds(581, 0, 114, 37);
		panel_4.add(btnAcEntry);
		btnAcEntry.setMnemonic('A');

		btnCustomer = new JButton("Customer");
		btnCustomer.setForeground(new Color(0, 51, 102));
		btnCustomer.setFont(new Font("Calibri", Font.BOLD, 14));
		btnCustomer.setBounds(694, 0, 90, 37);
		panel_4.add(btnCustomer);
		btnCustomer.setMnemonic('O');

		btnReceipts = new JButton("Payment Receipts");
		btnReceipts.setBounds(784, 1, 154, 36);
		panel_4.add(btnReceipts);
		btnReceipts.setToolTipText("Select This Option if Customer Paid Payment ");
		btnReceipts.setMnemonic('R');

		btnPayment = new JButton("Payment");
		btnPayment.setBounds(939, 0, 90, 37);
		panel_4.add(btnPayment);
		btnPayment.setForeground(new Color(0, 51, 102));
		btnPayment.setFont(new Font("Calibri", Font.BOLD, 14));
		btnPayment.setMnemonic('T');

		btnDeclare = new JButton("Declaration");
		btnDeclare.setBounds(1028, 0, 101, 37);
		panel_4.add(btnDeclare);
		btnDeclare.setForeground(new Color(0, 51, 102));
		btnDeclare.setFont(new Font("Calibri", Font.BOLD, 14));
		btnDeclare.setMnemonic('D');
		btnDeclare.addActionListener(btn);
		btnDeclare.addActionListener(btn);
		btnDeclare.setEnabled(false);

		btnHold = new JButton("Hold");
		btnHold.setBounds(1129, 0, 90, 37);
		panel_4.add(btnHold);
		btnHold.setForeground(new Color(0, 51, 102));
		btnHold.setFont(new Font("Calibri", Font.BOLD, 14));
		btnHold.setEnabled(false);
		btnHold.setMnemonic('H');

		btnUnhold = new JButton("UnHold");
		btnUnhold.setBounds(1220, 0, 90, 37);
		panel_4.add(btnUnhold);
		btnUnhold.setForeground(new Color(0, 51, 102));
		btnUnhold.setFont(new Font("Calibri", Font.BOLD, 14));
		btnUnhold.setEnabled(false);
		btnUnhold.setMnemonic('U');

		btnPrint = new JButton("Print");
		btnPrint.setBounds(399, 0, 90, 37);
		panel_4.add(btnPrint);
		btnPrint.setForeground(new Color(0, 51, 102));
		btnPrint.setFont(new Font("Calibri", Font.BOLD, 14));
		btnPrint.setMnemonic('P');

		btnSave = new JButton("Save");
		btnSave.setBounds(307, 0, 90, 37);
		panel_4.add(btnSave);
		btnSave.setSelectedIcon(new ImageIcon("D:\\AKN\\ItemImage\\Save.png"));
		btnSave.setIcon(null);
		btnSave.setForeground(new Color(0, 51, 102));
		btnSave.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSave.setMnemonic('S');

		scanPanel = new JPanel();
		scanPanel.setBounds(6, 204, 1332, 49);
		internalFrame.getContentPane().add(scanPanel);
		scanPanel.setBackground(new Color(102, 255, 204));
		scanPanel.setBorder(new MatteBorder(2, 3, 4, 3, (Color) new Color(64, 64, 64)));
		scanPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Scan Article");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 17, 89, 16);
		scanPanel.add(lblNewLabel);

		// scanarticle = new JTextField();
		scanarticle = new gnRoundTextField(20);
		scanarticle.setBackground(Color.WHITE);
		scanarticle.setForeground(new Color(0, 0, 51));
		scanarticle.setToolTipText("Enter Item Code or Scan Item if Scanner Available");
		scanarticle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		scanarticle.setBounds(99, 9, 143, 33);
		scanPanel.add(scanarticle);
		scanarticle.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Name");
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_10.setForeground(new Color(0, 0, 102));
		lblNewLabel_10.setBounds(629, 17, 45, 22);
		scanPanel.add(lblNewLabel_10);

		// searchname = new JTextField();
		searchname = new gnRoundTextField(20);

		searchname.setFont(new Font("Arial", Font.PLAIN, 16));
		searchname.setBackground(Color.WHITE);
		searchname.setForeground(new Color(0, 0, 51));
		searchname.setToolTipText("Enter Name Of Item To Search");
		searchname.setBounds(676, 9, 132, 32);
		scanPanel.add(searchname);
		searchname.setColumns(10);

		JLabel lblNewLabel_22 = new JLabel("Qty");
		lblNewLabel_22.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_22.setForeground(new Color(0, 0, 102));
		lblNewLabel_22.setBounds(242, 17, 34, 16);
		scanPanel.add(lblNewLabel_22);

		// scanqty = new JTextField();
		scanqty = new gnRoundTextField(20);
		scanqty.setToolTipText("Change Quantity For Scan Item");

		scanqty.setFont(new Font("Arial Black", Font.PLAIN, 18));
		scanqty.setBackground(Color.WHITE);
		scanqty.setForeground(new Color(0, 0, 51));
		scanqty.setBounds(278, 9, 70, 32);
		scanPanel.add(scanqty);
		scanqty.setColumns(10);

		JLabel lblNewLabel_23 = new JLabel("Rate");
		lblNewLabel_23.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_23.setForeground(new Color(0, 0, 102));
		lblNewLabel_23.setBounds(352, 18, 34, 16);
		scanPanel.add(lblNewLabel_23);

		// rate = new JTextField();
		rate = new gnRoundTextField(20);
		rate.setToolTipText("Change Rate For Scan Item");

		rate.setFont(new Font("Arial Black", Font.PLAIN, 18));
		rate.setBackground(Color.WHITE);
		rate.setForeground(new Color(0, 0, 51));
		rate.setBounds(389, 9, 70, 32);
		scanPanel.add(rate);
		rate.setColumns(10);

		JLabel lblNewLabel_24 = new JLabel("Discount");
		lblNewLabel_24.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_24.setForeground(new Color(0, 0, 102));
		lblNewLabel_24.setBounds(467, 18, 71, 16);
		scanPanel.add(lblNewLabel_24);

		// discount = new JTextField();
		discount = new gnRoundTextField(20);

		discount.setFont(new Font("Arial Black", Font.PLAIN, 18));
		discount.setBackground(Color.WHITE);
		discount.setForeground(new Color(0, 0, 51));
		discount.setBounds(539, 10, 70, 32);
		scanPanel.add(discount);
		discount.setColumns(10);

		// btnBatch = new JButton("Get Batch Details");
		btnBatch = new gnRoundButton("Get Batch Details");

		btnBatch.setBounds(1194, 9, 132, 32);
		scanPanel.add(btnBatch);
		btnBatch.setFont(new Font("Agency FB", Font.BOLD, 18));
		btnBatch.setMnemonic('G');

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 136, 410, 55);
		panel_1.add(panel_2);
		panel_2.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { rbcashsale, rbcrsale, crdays }));
		panel_2.setForeground(Color.WHITE);
		panel_2.setBackground(new Color(0, 0, 51));
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 128, 128), Color.CYAN));
		panel_2.setLayout(null);

		JLabel lblNewLabel_14 = new JLabel("Due Date");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setBounds(105, 19, 58, 16);
		panel_2.add(lblNewLabel_14);
		lblNewLabel_14.setFont(new Font("Agency FB", Font.PLAIN, 20));

		paymentduedate = new JTextField();
		paymentduedate.setToolTipText("Due Date Will Calculate Based on Credit Days And Current Billing Date");
		paymentduedate.setEditable(false);
		paymentduedate.setBounds(164, 16, 85, 24);
		panel_2.add(paymentduedate);
		paymentduedate.setForeground(Color.WHITE);
		paymentduedate.setFont(new Font("Arial", Font.BOLD, 15));
		paymentduedate.setBackground(new Color(0, 0, 51));
		paymentduedate.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Cr.Days");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setForeground(Color.WHITE);
		lblNewLabel_13.setBounds(0, 19, 58, 16);
		panel_2.add(lblNewLabel_13);
		lblNewLabel_13.setFont(new Font("Agency FB", Font.PLAIN, 20));

		crdays = new JTextField();
		crdays.setToolTipText("Enter Credit Period for  Credit Sales");
		crdays.setBounds(60, 16, 42, 22);
		panel_2.add(crdays);
		crdays.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Due Amt.");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_16.setBounds(259, 19, 69, 16);
		panel_2.add(lblNewLabel_16);
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setFont(new Font("Agency FB", Font.PLAIN, 20));

		dueamount = new JTextField();
		dueamount.setBackground(new Color(0, 0, 51));
		dueamount.setBounds(313, 15, 69, 25);
		panel_2.add(dueamount);
		dueamount.setToolTipText("Customer Outstatnding Till Date");
		dueamount.setEditable(false);
		dueamount.setForeground(Color.WHITE);
		dueamount.setFont(new Font("Arial", Font.BOLD, 15));
		dueamount.setColumns(10);

		JLabel lblNewLabel_18 = new JLabel("GST.Reg.Dlr");
		lblNewLabel_18.setBounds(128, 111, 73, 16);
		panel_1.add(lblNewLabel_18);
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);

		statename = new JTextField();
		statename.setForeground(Color.YELLOW);
		statename.setBounds(233, 108, 119, 25);
		panel_1.add(statename);
		statename.setFont(new Font("Calibri", Font.BOLD, 12));
		statename.setBackground(Color.DARK_GRAY);
		statename.setEditable(false);
		statename.setColumns(10);

		statecode = new JTextField();
		statecode.setForeground(Color.YELLOW);
		statecode.setBounds(348, 108, 68, 25);
		panel_1.add(statecode);
		statecode.setFont(new Font("Calibri", Font.BOLD, 12));
		statecode.setBackground(Color.DARK_GRAY);
		statecode.setEditable(false);
		statecode.setColumns(10);

		regdlr = new JTextField();
		regdlr.setBackground(Color.DARK_GRAY);
		regdlr.setForeground(Color.YELLOW);
		regdlr.setBounds(198, 109, 34, 24);
		panel_1.add(regdlr);
		regdlr.setColumns(10);

		btnShowInv = new JButton("Show Invoice's");
		btnShowInv.setBounds(9, 106, 119, 25);
		btnShowInv.addActionListener(show);
		panel_1.add(btnShowInv);

		JButton btnNewButton = new JButton("-");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setBounds(1019, 0, -2, 180);
		panel.add(btnNewButton);

		lblNewLabel_1 = new JLabel("Gross Amount");
		lblNewLabel_1.setFont(new Font("Agency FB", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(989, 16, 116, 22);
		panel.add(lblNewLabel_1);

		grossamt = new JTextField();
		grossamt.setForeground(Color.WHITE);
		grossamt.setBackground(Color.DARK_GRAY);
		grossamt.setFont(new Font("Arial", Font.BOLD, 20));
		grossamt.setBounds(1117, 13, 184, 30);
		panel.add(grossamt);
		grossamt.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Discount");
		lblNewLabel_2.setToolTipText("Line Level Discount Given");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(1007, 49, 98, 16);
		panel.add(lblNewLabel_2);

		linedisc = new JTextField();
		linedisc.setForeground(Color.WHITE);
		linedisc.setToolTipText("Line Level Given Discount");
		linedisc.setBackground(Color.DARK_GRAY);
		linedisc.setFont(new Font("Arial Black", Font.PLAIN, 14));
		linedisc.setBounds(1117, 43, 184, 30);
		panel.add(linedisc);
		linedisc.setColumns(10);

		JLabel lblNewLabel_26 = new JLabel("Bill Discount");
		lblNewLabel_26.setToolTipText("Bill Level Discount Given");
		lblNewLabel_26.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_26.setForeground(Color.BLACK);
		lblNewLabel_26.setBounds(1005, 78, 98, 16);
		panel.add(lblNewLabel_26);

		billdisc = new JTextField();
		billdisc.setForeground(Color.WHITE);
		billdisc.setToolTipText("Bill Level Given Discount");
		billdisc.setBackground(Color.DARK_GRAY);
		billdisc.setFont(new Font("Arial Black", Font.PLAIN, 14));
		billdisc.setBounds(1117, 72, 184, 30);
		panel.add(billdisc);
		billdisc.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(427, 113, 263, 85);
		panel.add(panel_6);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Bill Level Discount",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_6.setLayout(null);

		JLabel lblNewLabel_25 = new JLabel("Disc %");
		lblNewLabel_25.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_25.setForeground(Color.BLACK);
		lblNewLabel_25.setBounds(83, 16, 56, 32);
		panel_6.add(lblNewLabel_25);

		JLabel lblNewLabel_28 = new JLabel("Disc.Amt");
		lblNewLabel_28.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_28.setForeground(Color.BLACK);
		lblNewLabel_28.setBounds(160, 19, 94, 22);
		panel_6.add(lblNewLabel_28);

		// disc = new JTextField();
		disc = new gnRoundTextField(20);

		disc.setBounds(160, 43, 65, 32);
		panel_6.add(disc);
		disc.setToolTipText("Enter Bill Level Discount Amount ");
		disc.setText(" ");
		disc.setBackground(Color.WHITE);
		disc.setHorizontalAlignment(SwingConstants.LEFT);
		disc.setForeground(new Color(0, 0, 51));
		disc.setFont(new Font("Arial Black", Font.PLAIN, 15));
		disc.setColumns(10);

		// discper = new JTextField();
		discper = new gnRoundTextField(10);
		discper.setToolTipText("Enter Bill Level Disc%");
		discper.setFont(new Font("Arial Black", Font.PLAIN, 15));

		discper.setForeground(new Color(0, 0, 153));
		discper.setBounds(83, 43, 56, 32);
		panel_6.add(discper);
		discper.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Total Qty");
		lblNewLabel_15.setFont(new Font("Agency FB", Font.BOLD, 18));
		lblNewLabel_15.setBounds(885, 147, 56, 16);
		panel.add(lblNewLabel_15);

		myRecords = new JLabel("0");
		myRecords.setFont(new Font("Arial", Font.BOLD, 18));
		myRecords.setHorizontalAlignment(SwingConstants.CENTER);
		myRecords.setBounds(807, 170, 67, 23);
		panel.add(myRecords);

		myQty = new JLabel("0.0");
		myQty.setFont(new Font("Arial", Font.BOLD, 18));
		myQty.setHorizontalAlignment(SwingConstants.CENTER);
		myQty.setBounds(874, 170, 67, 23);
		panel.add(myQty);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBorder(new MatteBorder(4, 10, 4, 10, (Color) Color.RED));
		panel_7.setBounds(957, 0, 381, 198);
		panel.add(panel_7);

		internalFrame.setVisible(true);

		ActionListener seZlsnr = new sezlsnr();
		ActionListener scanQty = new scanqtyLsnr();
		ActionListener scanRate = new scanrateLsnr();
		ActionListener Manuldisc = new scandiscLsnr();
		ActionListener advl = new advnoLsnr();
		ActionListener dscls = new discLsnr();
		rbcashsale.addActionListener(rbpay);
		rbcrsale.addActionListener(rbpay);
		btnEdit.addActionListener(btn);

		FocusListener fls = new btnfocus();
		btnAcEntry.addFocusListener(fls);
		btnReceipts.addFocusListener(fls);
		btnCustomer.addFocusListener(fls);

		KeyListener kk = new keyPressedlsnr();
		btnAcEntry.addKeyListener(kk);
		btnReceipts.addKeyListener(kk);
		btnCustomer.addKeyListener(kk);
		//

		crdays.addActionListener(cr);
		btnBatch.addActionListener(btn);
		scanqty.addActionListener(scanQty);
		rate.addActionListener(scanRate);
		discount.addActionListener(Manuldisc);
		searchname.addActionListener(nm);
		scanarticle.addActionListener(article);
		btnReceipts.addActionListener(btn);
		btnCustomer.addActionListener(btn);
		btnAcEntry.addActionListener(btn);
		btnCancel.addActionListener(btn);

		ActionListener qno = new QuotnoLsnr();
		Quotno.addActionListener(qno);
		advno.addActionListener(advl);
		sez.addActionListener(seZlsnr);
		exportsales.addActionListener(seZlsnr);

		btnHold.addFocusListener(fls);
		btnHold.addKeyListener(kk);
		btnHold.addActionListener(btn);
		btnUnhold.addFocusListener(fls);
		btnUnhold.addKeyListener(kk);
		btnDeclare.addFocusListener(fls);
		btnDeclare.addKeyListener(kk);
		btnPayment.addFocusListener(fls);
		btnPayment.addKeyListener(kk);
		btnPayment.addActionListener(btn);
		disc.addActionListener(dscls);
		btnSave.addFocusListener(fls);
		btnSave.addKeyListener(kk);
		btnSave.addActionListener(btn);
		btnPrint.addFocusListener(fls);
		btnPrint.addKeyListener(kk);
		btnPrint.addActionListener(btn);
		btnUnhold.addActionListener(btn);
		decorate();
	}

	class keyPressedlsnr implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int value = e.getKeyCode();
			// new General().msg("Key Pressed "+ value);
			switch (value) {
			case 10:
				if (btnSave.isFocusOwner()) {
					btnSave.doClick();
				}

				if (btnPayment.isFocusOwner()) {
					btnPayment.doClick();
				}

				if (btnPrint.isFocusOwner()) {
					btnPrint.doClick();
				}

				if (btnCancel.isFocusOwner()) {
					btnCancel.doClick();
				}

				if (btnDeclare.isFocusOwner()) {
					btnDeclare.doClick();
				}

				if (btnCustomer.isFocusOwner()) {
					btnCustomer.doClick();
				}

				if (btnHold.isFocusOwner()) {
					btnHold.doClick();
				}

				if (btnUnhold.isFocusOwner()) {
					btnUnhold.doClick();
				}

				if (btnAcEntry.isFocusOwner()) {
					btnAcEntry.doClick();
				}

				if (btnAdvance.isFocusOwner()) {
					btnAdvance.doClick();
				}

				if (btnReceipts.isFocusOwner()) {
					btnReceipts.doClick();
				}

			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {

		}

		@Override
		public void keyTyped(KeyEvent arg0) {

		}
	}

	class btnfocus implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {

			if (btnSave.isFocusOwner()) {
				btnSave.setBackground(Color.yellow);
			}

			if (btnPayment.isFocusOwner()) {
				btnPayment.setBackground(Color.yellow);
			}

			if (btnPrint.isFocusOwner()) {
				btnPrint.setBackground(Color.yellow);
			}

			if (btnCancel.isFocusOwner()) {
				btnCancel.setBackground(Color.yellow);
			}

			if (btnDeclare.isFocusOwner()) {
				btnDeclare.setBackground(Color.yellow);
			}

			if (btnCustomer.isFocusOwner()) {
				btnCustomer.setBackground(Color.yellow);
			}

			if (btnHold.isFocusOwner()) {
				btnHold.setBackground(Color.yellow);
			}

			if (btnUnhold.isFocusOwner()) {
				btnUnhold.setBackground(Color.yellow);
			}

			if (btnAcEntry.isFocusOwner()) {
				btnAcEntry.setBackground(Color.yellow);
			}

			if (btnReceipts.isFocusOwner()) {
				btnReceipts.setBackground(Color.yellow);
			}

		}

		@Override
		public void focusLost(FocusEvent e) {

			new gnStyleButton().getStyleButton(btnSave, new Color(56, 211, 112), Color.WHITE);
			new gnStyleButton().getStyleButton(btnPrint, new Color(56, 211, 112), Color.WHITE);
			new gnStyleButton().getStyleButton(btnPayment, new Color(56, 211, 112), Color.WHITE);
			new gnStyleButton().getStyleButton(btnCancel, new Color(56, 211, 112), Color.WHITE);
			new gnStyleButton().getStyleButton(btnDeclare, new Color(56, 211, 112), Color.WHITE);
			new gnStyleButton().getStyleButton(btnCustomer, new Color(56, 211, 112), Color.WHITE);
			new gnStyleButton().getStyleButton(btnHold, new Color(56, 211, 112), Color.WHITE);
			new gnStyleButton().getStyleButton(btnUnhold, new Color(56, 211, 112), Color.WHITE);
			new gnStyleButton().getStyleButton(btnAcEntry, new Color(56, 211, 112), Color.WHITE);
			// new gnStyleButton().getStyleButton(btnAdvance, new Color(56, 211,
			// 112) , Color.WHITE) ;
			new gnStyleButton().getStyleButton(btnReceipts, new Color(156, 211, 112), Color.WHITE);

		}
	}

	private void decorate() throws Throwable {

		wsale.setVisible(false);
		rbcashsale.setVisible(false);
		b2b.setVisible(false);
		//
		btnUnhold.setVisible(false);
		btnHold.setVisible(false);
		btnDeclare.setVisible(false);
		btnPayment.setVisible(false);

		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		try {

			gnProductDetails kk;
			kk = new gnProductDetails();
			/*
			 * JPanel myp = kk.getPanel2() ; myp.setBounds(0, 41, 346, 359);
			 * myp.setVisible(true); myp.setBackground(new Color(0, 0, 102));
			 * myp.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(102,
			 * 255, 153))); //myp.setBounds(6, 0, 484, 124); myp.setBounds(0,
			 * 41, 346, 359); new General().msgPanel(myp, "1212", 346, 356);
			 * panel_5.add(myp); panel_5.setBackground(new Color(0, 0, 102));
			 * panel_5.repaint();
			 */
			// new General().msgFrame(kk.ProductInfoframe, "1212", 346, 356);

		} catch (Throwable e) {
			e.printStackTrace();
		}

		//

		chekcFreezeYear();
		this.checkInternet();
		if (Language == "H") {
			customername.setFont(new Font("Shivaji02", Font.PLAIN, 16));
		}
		String vpara29 = "29";
		String vEditDocumentAllow = new getConfigurationSetting().getSpecificConfiguration(vpara29);
		new gnField().closeform(internalFrame, creditsalesFrame1);

		switch (vEditDocumentAllow) {
		case "N":
			btnEdit.setVisible(false);
			break;
		}

		vallow = new gnDate().checkDayBegin();
		switch (vallow) {
		case "Y":
			new gnApp().setCompanyTitle(internalFrame);
			new gnApp().setFrameTitel(creditsalesFrame1);
			vcomp = new gnConfig().getCompanyCode();
			invdate.setText(new gnConfig().getDaybeginDate());
			new gnField().closeform(internalFrame, creditsalesFrame1);

			String vtype = "SALE";
			String vallowDate = new gnDate().checkBackDateTrAllow(vtype, invdate.getText());
			switch (vallowDate) {
			case "N":
				btnEdit.setVisible(false);
				invdate.setBackground(Color.RED);
				invdate.setForeground(Color.WHITE);
				new General().msg("Back Date For Transaction is not Allow..");
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				invdate.setText("?");
				scanarticle.setVisible(false);
				searchname.setVisible(false);
				customername.setEditable(false);

				break;
			}
			btnPayment.setEnabled(false);
			chrevchrg.setVisible(false);
			new gnField().showInventory(internalFrame, "INV");
			new gnField().showCalc(internalFrame, "CAL");
			delTableRow(table, model, "WS");
			new gnField().moveDown(table);
			new gnField().closeform(internalFrame, creditsalesFrame1);
			if (vcomp == "0") {
				System.exit(0);
			}
			if (vcomp != "0") {
				menu = new gnConfig().getmenuPressed();
				menu = "wsales";
				switch (menu) {
				case "B2B":
					// Heading.setText("B2B Sales Module");
					selectionPanel.setVisible(true);
					quotPanel.setVisible(false);
					scanPanel.setVisible(false);
					b2b.setSelected(true);
					wsale.setEnabled(false);
					new gnStyleButton().getStyleButton(btnSave, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnPrint, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnPayment, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnCancel, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnDeclare, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnCustomer, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnHold, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnUnhold, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnAcEntry, new Color(56, 211, 112), Color.WHITE);

					break;
				case "wsales":

					scanPanel.setVisible(true);
					selectionPanel.setVisible(true);
					quotPanel.setVisible(false);
					b2b.setSelected(false);
					b2b.setEnabled(false);
					wsale.setEnabled(true);
					wsale.setSelected(true);

					new gnStyleButton().getStyleButton(btnSave, new Color(55, 209, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnPrint, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnPayment, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnCancel, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnDeclare, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnCustomer, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnHold, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnUnhold, new Color(56, 211, 112), Color.WHITE);
					new gnStyleButton().getStyleButton(btnAcEntry, new Color(56, 211, 112), Color.WHITE);
					// new gnStyleButton().getStyleButton(btnAdvance, new
					// Color(56, 211, 112) , Color.WHITE) ;
					new gnStyleButton().getStyleButton(btnReceipts, new Color(156, 211, 112), Color.WHITE);

				}

				// new gnDecorate().DispField_Eatch(Tamount, 10);
				// new gnDecorate().DispField_Eatch(crdays, 2);
			}
			break;
		case "N":
			break;
		}
	}

	class advnoLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String vpartycode = customercode.getText();
			String vdoctype = "AD";
			String vcat = "C";
			try {
				if (vpartycode.length() >= 1) {
					new gnLogger().loggerInfoEntry("Credit Sales", "Adjusting Advance Amount in Credt Sales");
					new gnDncnAdv().getOpenAdvdncn(vpartycode, vdoctype, vcat);
				}
			} catch (Throwable e1) {
				e1.printStackTrace();
				new gnLogger().loggerInfoEntry("Credit Sales",
						"Adjusting Advance Amount in Credt Sales" + " " + e1.getLocalizedMessage());
			} finally {
				advno.setText(new gnDncnAdv().rdocno);
				advdate = new gnDncnAdv().rdocdate;
				new gnDncnAdv().rdocdate = " ";
				new gnDncnAdv().rdocno = "";
				new gnLogger().loggerInfoEntry("Credit Sales", "Advance no selected " + " " + advno.getText());
			}

		}
	}

	class sezlsnr implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean ischeck = exportsales.isSelected();
			boolean ischeck1 = sez.isSelected();

			if (ischeck) {
				new gnLogger().loggerInfoEntry("Credit Sales", "Export Credit Sales Option Selected");
				sez.setSelected(false);
				try {
					impExp_shipping window;
					window = new impExp_shipping();
					window.ShippingForm.setVisible(true);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			if (ischeck1) {
				new gnLogger().loggerInfoEntry("Credit Sales", "SEZ Credit Sales Option Selected");
				exportsales.setSelected(false);
				try {
					impExp_shipping window;
					window = new impExp_shipping();
					window.ShippingForm.setVisible(true);
				} catch (Throwable e) {
					e.printStackTrace();
				}
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
					// showFieldHelp(vfieldName) ;
					int row = table.getSelectedRow();
					// new General().msg("row Selected is:"+" "+row);
					model.removeRow(row);
					removeRow(model, table);
					table.setEditingRow(row);
					new gnLogger().loggerInfoEntry("Credit Sales", "Item Removed from Table");
					Double v = new gnTable().getTotal(table, 11);
					Tamount.setText(Double.toString(v));
					vdueamount = v;
					int vcount = table.getRowCount();
					// records.setText(Integer.toString(vcount));
					myRecords.setText(Integer.toString(vcount));
					myQty.setText(Double.toString(new gnTable().getTotal(table, 3)));
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void chekcFreezeYear() {
		switch (isFinyearFreeze) {
		case "Y":
			btnEdit.setVisible(false);
			btnSave.setVisible(false);
			// btnUpdate.setVisible(false);
			// btnAcEntry.setVisible(false);
			// btnPrint.setVisible(false);
			new General().msg("Accounting Year is Freezeed..You Can View Data Only..");
			break;
		}
	}

	//

	class scandiscLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String value = discount.getText();
			table.setValueAt(value, 0, 10);
			value = (String) table.getValueAt(0, 1);
			try {
				QtychangeImapct(value, 0);
				scanqty.setText("");
				rate.setText("");
				discount.setText("");
			} catch (Throwable e) {
			}
		}
	}

	class scanqtyLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String value = scanqty.getText();
			table.setValueAt(value, 0, 3);
			value = (String) table.getValueAt(0, 1);
			try {
				QtychangeImapct(value, 0);
				scanqty.setText("");
				rate.setText("");
				discount.setText("");
			} catch (Throwable e) {
			}
		}
	}

	class scanrateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String value = rate.getText();
			table.setValueAt(value, 0, 6);
			value = (String) table.getValueAt(0, 1);
			try {
				QtychangeImapct(value, 0);
				scanqty.setText("");
				rate.setText("");
				discount.setText("");
			} catch (Throwable e) {
			}
		}
	}

	class discLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				DistributeDiscount();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void DistributeDiscount() throws Throwable {
		double vqty = 0;
		int row = table.getRowCount();
		if (row > 0) {
			for (int i = 0; i < row; i++) {
				double qty = Double.parseDouble(table.getValueAt(i, 3).toString());
				vqty = vqty + qty;
			}
		}
		Double vgivendisc = Double.parseDouble(disc.getText().toString());
		Double vdistDisc = vgivendisc / vqty;
		int row1 = table.getRowCount();
		if (row1 > 0) {
			for (int k = 0; k < row1; k++) {
				Double qtyrow = Double.parseDouble(table.getValueAt(k, 3).toString());
				Double vdiscamt = vdistDisc * qtyrow;
				table.setValueAt(vdiscamt, k, 9);
			}
		}
		recalculateData();
	}

	private void recalculateData() throws Throwable {
		int row1 = table.getRowCount();
		if (row1 > 0) {
			for (int k = 0; k < row1; k++) {
				String value = table.getValueAt(k, 1).toString();
				try {
					QtychangeImapct(value, k);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
	//

	class ShowInvLsnr implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String vcust = customercode.getText();
			try {
				new gnInvoice().getCustomerInvno(vcust);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					String vbillno = new gnInvoice().invno;
					String vbilldate = new gnInvoice().invdate;

					if (vbillno != null) {
						new gnSale().showinvoice(vbillno, vbilldate);
					}
					new gnInvoice().invno = null;
					new gnInvoice().invdate = null;
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}

	class rbpayLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			boolean vpay = rbcrsale.isSelected();
			if (vpay) {
				crdays.setEnabled(true);
				crdays.setText("");
				btnPayment.setEnabled(false);
			} else {
				crdays.setEnabled(false);
				crdays.setText("0");
				paymentduedate.setText("0");
				// btnPayment.setEnabled(true);
			}

		}
	}

	class crdaysLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			int vcrdays = Integer.parseInt(crdays.getText());
			try {
				String vduedate = new gnConfig().get_duedate(new gnConfig().date_ConverttoDBforamt(invdate.getText()),
						vcrdays);
				paymentduedate.setText(vduedate);
				scanarticle.grabFocus();
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

	class articlenameLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (vallow == "N") {
				creditsalesFrame1.dispose();
				new General().msg("Complete Day Open First ....");
			}
			String vtype = "Article";
			String sname = searchname.getText();
			sname = "%" + sname + "%";
			String varticle1 = " ";
			String vtrantype1 = "ALL";
			try {
				new gnAdmin().Search(vtype, sname, varticle1, vtrantype1);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				String varticle = new gnAdmin().rArticle;
				try {
					showArticleData(varticle);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void showBatchDetails() throws Throwable {
		if (table.getRowCount() > 0) {
			int row = table.getSelectedRow();
			selectedrow = row;
			String varticle = table.getValueAt(row, 1).toString();
			String vbatchArticle = new gnArticleContent().CheckBatchArticle(varticle);
			String vloc = table.getValueAt(row, 18).toString();
			try {
				CheckBatchArticle(varticle, vbatchArticle);
				// checkBatchforNonBatchItems(varticle , vbatchArticle) ;
				// new gnGetBatch().getBatchDetail(varticle, vbatchArticle, vloc
				// );
			} catch (Throwable e1) {
				e1.printStackTrace();
				new General().msg(e1.getLocalizedMessage());
			}
		}
	}

	class BtnPressLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Edit Sales") {
				new gnLogger().loggerInfoEntry("Credit Sale", "Edit Credit Sales Option Selected..");
				EditMode = "Y";
				btnEdit.setBackground(Color.BLUE);
				btnEdit.setForeground(Color.WHITE);
				scanarticle.setVisible(false);
				searchname.setVisible(false);
				custnameLsnr abc = new custnameLsnr();
				abc.actionPerformed(e);
			}

			if (value == "Get Batch Details") {
				try {
					new gnLogger().loggerInfoEntry("Credit Sale", "Selecting Batch Details..");
					showBatchDetails();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
					new gnLogger().loggerInfoEntry("Credit Sale",
							"Exception While batch Selection.." + " " + e1.getMessage());
				}
			}

			if (value == "Payment Receipts") {
				try {
					new gnLogger().loggerInfoEntry("Credit Sale",
							"Receipts Option Selection from Credit Sales Screen..");
					receiptVoucher window;
					window = new receiptVoucher();
					window.frmreceiptVoucher.setVisible(true);
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
					new gnLogger().loggerInfoEntry("Credit Sale",
							"Exception While Receipt transaction selection.." + " " + e1.getMessage());
				}
			}

			if (value == "Save") {
				new gnLogger().loggerInfoEntry("Credit Sale", "Data Validation  Process Starts....");
				String status = validate();
				if (status == "Sucess") {
					try {
						new gnLogger().loggerInfoEntry("Credit Sale", "Saving Data Process Starts....");
						PrepareToInsert();
					} catch (Throwable e1) {
						new General().msg(e1.getMessage());
						new gnLogger().loggerInfoEntry("Credit Sale",
								"Saving Data Process Exception...." + " " + e1.getMessage());
					}
				}
			}

			if (value == "Account Entry") {

				String vtype = "WS";
				String vdocno = invno.getText();
				String vdocdate = invdate.getText();
				try {
					new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
					new gnLogger().loggerInfoEntry("Credit Sale",
							"Show Account Data Exception...." + " " + e1.getMessage());
				}
			}

			if (value == "Print") {
				try {
					callprint();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
					new gnLogger().loggerInfoEntry("Credit Sale", "Print Data Exception...." + " " + e1.getMessage());
				}
			}

			if (value == "Hold") {

			}

			if (value == "Customer") {
				CustomerMaster window;
				try {
					window = new CustomerMaster();
					window.CustomerFrame.setVisible(true);
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
					new gnLogger().loggerInfoEntry("Credit Sale",
							"Customer Master Data  Exception...." + " " + e1.getMessage());
				}
			}

			if (value == "Payment") {
				pmodel.setColumnIdentifiers(paycol);
				try {
					Double vinvamt = Double.parseDouble(Tamount.getText());
					if (vinvamt > 0.00) {
						String vpara = "806";
						String vpaymentCurrency = "INR";
						new CreditSalesPayment().custpayment(vpaymentCurrency, ptable, pmodel, paycol,
								Tamount.getText());
					}
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getMessage());
					new gnLogger().loggerInfoEntry("Credit Sale",
							"Payment  Process Exception...." + " " + e1.getMessage());
				} catch (SQLException e1) {
					new General().msg(e1.getMessage());
					new gnLogger().loggerInfoEntry("Credit Sale",
							"Payment  Process Exception...." + " " + e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
					new gnLogger().loggerInfoEntry("Credit Sale",
							"Payment  Process Exception...." + " " + e1.getMessage());
				} finally {
					if (new CreditSalesPayment().status == "Sucess") {
						vdueamount = new CreditSalesPayment().vduepayment;
						ptable = new CreditSalesPayment().getmyPatmentTable();
					}
				}
			}

			if (value == "Cancel") {
				creditsalesFrame1.dispose();
			}

		}
	}

	class custcodeLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (vallow == "N") {
				creditsalesFrame1.dispose();
				new General().msg("Complete Day Open First ....");
				return;
			}

			String vVname = customercode.getText();
			if (vVname.length() > 0) {
				try {
					new gnSupplier().setScanCustomer(customercode, customername, vVname);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					new gnSupplier().rcustcode = " ";
					new gnSupplier().rcustName = " ";
				}
			}
		}
	}

	private void setcustomerGSTdetail() throws Throwable {
		String vcustcode = customercode.getText();
		try {
			if (vcustcode.length() > 0) {
				String vstatecode = new gnGST().getCustomerState(vcustcode);
				String vstatename = new gnGST().getCustomerStatename(vcustcode);
				String vregdlr = new gnGST().isCustmoerGSTRegister(vcustcode);
				regdlr.setText(vregdlr);
				statecode.setText(vstatecode);
				statename.setText(vstatename);
			}
		} catch (Exception e) {
			new gnLogger().loggerInfoEntry("Credit Sale",
					"Cust GST Related Master display ...." + " " + e.getMessage());
		}
	}

	class custnameLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (vallow == "N") {
				creditsalesFrame1.dispose();
				new General().msg("Complete Day Open First ....");
				return;
			}

			String value = e.getActionCommand();
			String vtype = "Customer";
			String sname = customername.getText().trim();
			sname = "%" + sname + "%";
			if (sname.length() == 0) {
				new General().msg("Select Party code ...");
				return;
			}
			try {
				new gnSupplier().rcustcode = "0";
				new gnSupplier().getCustomer(sname);
			} catch (Throwable e1) {
				e1.printStackTrace();
				new gnLogger().loggerInfoEntry("Credit Sale",
						"Customer Get  Process Exception...." + " " + e1.getMessage());
			} finally {
				customercode.setText(new gnSupplier().rcustcode);
				customername.setText(new gnSupplier().rcustName);
				new gnSupplier().rcustcode = " ";
				new gnSupplier().rcustName = " ";
				crdays.grabFocus();
				try {
					if (customercode.getText().length() > 0) {
						setcustomerGSTdetail();
						String vdueamount = new gnSupplier().getCustomerDue(customercode.getText());
						dueamount.setText(vdueamount);
					}
				} catch (Throwable e2) {
					e2.printStackTrace();
				}
				try {
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					if (EditMode == "Y") {
						try {
							getInvoiceNo();
						} catch (Throwable e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		}
	}

	private void getInvoiceNo() throws Throwable {
		try {
			String vtype = "WS";
			String vcustcode = customercode.getText();
			new gnSale().get_invnoForcustomer(vtype, vcustcode);
		} catch (Exception e) {
			new General().msg(e.getMessage());
			new gnLogger().loggerInfoEntry("Credit Sale", "Customer Get  Process Exception...." + " " + e.getMessage());
		} finally {
			invdate.setText(new gnSale().rinvdate);
			invno.setText(new gnSale().rinvno);
			new gnSale().rinvdate = null;
			new gnSale().rinvno = null;
			String vinvno = invno.getText();

			if (vinvno.length() == 0) {
				reset();
			}

			if (vinvno.length() > 0) {
				String vinvdate = new gnConfig().date_ConverttoDBforamt(invdate.getText());
				vcomp = new gnConfig().getCompanyCode();
				vstore = new gnConfig().getStoreID();
				String vtype3 = "WS";
				new gnLogger().loggerInfoEntry("Credit Sale", "Getting Data For Edit Invoice");
				String SQL = "Call sale_getEditSalesData( '" + vtype3 + "', " + vcomp + " ,  " + vstore + "  , "
						+ vinvno + ", '" + vinvdate + "' )";
				ShowTableData(SQL, poscol);
				scanarticle.setVisible(true);
				searchname.setVisible(true);
			}
		}
	}

	public void callEditProcess(String vdocno, String vdocDate) throws Throwable {
		new gnLogger().loggerInfoEntry("Credit Sale", "Edit Process Starts...");
		decorate();
		EditMode = "Y";
		btnEdit.setVisible(true);
		btnEdit.setBackground(Color.BLUE);
		btnEdit.setForeground(Color.WHITE);
		invdate.setText(vdocDate);
		invno.setText(vdocno);
		String vinvno = invno.getText();
		String vinvdate = new gnConfig().date_ConverttoDBforamt(vdocDate);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vtype3 = "WS";
		String SQL = "Call sale_getEditSalesData( '" + vtype3 + "', " + vcomp + " ,  " + vstore + "  , " + vdocno
				+ ", '" + vinvdate + "' )";
		vtype3 = "B2B";
		SQL = "Call sale_getEditSalesData( '" + vtype3 + "', " + vcomp + " ,  " + vstore + "  , " + vdocno + ", '"
				+ vinvdate + "' )";
		ShowTableData(SQL, poscol);
		scanarticle.setVisible(true);
		searchname.setVisible(true);
		setcustomerGSTdetail();
	}

	class QuotnoLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// String value = e.getActionCommand();
			String vqno = Quotno.getText();
			if (vallow == "N") {
				creditsalesFrame1.dispose();
				new General().msg("Complete Day Open First ....");
				return;
			}

			if (vqno.length() == 0) {
				new General().msg("Select Quot No");
				return;
			}
			try {
				new gnQuotation().getQuotationForInvoce();
			} catch (Throwable e1) {
				e1.printStackTrace();
				new gnLogger().loggerInfoEntry("Credit Sale",
						"get Quotation Exception..." + " " + e1.getLocalizedMessage());
			} finally {
				Quotno.setText(new gnQuotation().vquotationno);
				validupto.setText(new gnQuotation().vvalidupto);
				amount.setText(new gnQuotation().vamount);
				advance.setText(new gnQuotation().vadvance);
				customercode.setText(new gnQuotation().vcustcode);
				customername.setText(new gnQuotation().vcustname);
				Msg.setText(new gnQuotation().vstatus);
				customercode.setEnabled(false);
				customername.setEnabled(false);
				String vquotno = Quotno.getText();
				try {
					setcustomerGSTdetail();
				} catch (Throwable e2) {
					new General().msg(e2.getLocalizedMessage());
				}
				new gnQuotation().vquotationno = " ";
				String SQL = "call   wsales_getDataForQuotNo(" + vcomp + " , " + vstore + " , " + vquotno + ")";
				try {
					new gnTable().RemoveTableRows(model);
					ShowTableData(SQL, poscol);
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getLocalizedMessage());
					new gnLogger().loggerInfoEntry("Credit Sale",
							"get Quotation Exception..." + " " + e1.getLocalizedMessage());
				} catch (SQLException e1) {
					new General().msg(e1.getLocalizedMessage());
					new gnLogger().loggerInfoEntry("Credit Sale",
							"get Quotation Exception..." + " " + e1.getLocalizedMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
					new gnLogger().loggerInfoEntry("Credit Sale",
							"get Quotation Exception..." + " " + e1.getLocalizedMessage());
				}
			}
		}
	}

	class ArticlecodeLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// String value = e.getActionCommand();
			if (vallow == "N") {
				creditsalesFrame1.dispose();
				new General().msg("Complete Day Open First ....");
				return;
			}

			String varticle = scanarticle.getText();
			String SQL = " ";
			if (varticle.length() > 0) {
				try {
					showArticleData(varticle);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				new General().msg("Enter Article Code..");
				return;
			}

		}
	}

	private void showArticleData(String varticle) throws Throwable {
		String SQL = " ";
		String vcust = customercode.getText();
		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();

		String vtype = "";
		String vpriceselection = selection.getSelectedItem().toString();
		String vfinyear = new gnFinYear().getReportingFinYear();

		switch (vpriceselection) {
		case "Normal Price":
			vtype = "WS";
			String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
					new gnPublicVariable().vstore);
			SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , " + varticle + ", " + vcomp + " , "
					+ vstore + " , '" + vfinyear + "'  , " + vverticlecode + ")";
			new gnLogger().loggerInfoEntry("Credit Sale", "Article Scan..." + " " + varticle);
			break;
		case "Price Master":
			SQL = " call  wsale_sales_ApplyPriceListPrice(" + vcomp + " , " + vstore + " , '" + vcust + "' ,  "
					+ varticle + ")";
			new gnLogger().loggerInfoEntry("Credit Sale", "Article Scan..." + " " + varticle);
			break;
		}
		// new General().msg(SQL);
		try {
			String neginvallow = checkAllowNegInv(varticle);
			if (neginvallow == "Y") {
				ShowTableData(SQL, poscol);
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			new gnLogger().loggerInfoEntry("Credit Sale",
					"get Price Selection Exception..." + " " + e1.getLocalizedMessage());
		} catch (SQLException e1) {
			e1.printStackTrace();
			new gnLogger().loggerInfoEntry("Credit Sale",
					"get Price Selection Exception..." + " " + e1.getLocalizedMessage());
		}
	}

	private void ShowTableData(String SQL, String Col[]) throws Throwable {
		rs = this.getSPResult(SQL);
		((DefaultTableModel) model).setColumnIdentifiers(Col);
		table.setModel(model);
		TR tr = new TR();
		TableColumnModel tcm = table.getColumnModel();
		for (int c = 3; c < 9; c++) {
			TableColumn tc = tcm.getColumn(c);
			tc.setCellRenderer(tr);
		}

		while (rs.next()) {
			String vtaxamt = "0.00";
			String Result = new gnGST().ismyComanyGSTRegister();

			if (EditMode == "Y") {
				table.setGridColor(Color.YELLOW);
				customercode.setText(rs.getString(19));
				customername.setText(rs.getString(20));
			}

			switch (Result) {
			case "N":
				vtaxamt = "0.00";
				break;
			case "Y":
				vtaxamt = rs.getString(13);
				break;
			}
			model.insertRow(0,
					new Object[] { "remove", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), vtaxamt, rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18) });

			String vmsname = "Location";
			String vverticle = new gnHierarchy().getVerticleCode();
			String vsearch = "%%";
			String SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticle + " , '" + vsearch + "')";
			table.getColumnModel().getColumn(18).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL1)));
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));

			if (EditMode == "N") {
				table.setGridColor(Color.BLUE);
			}

			new gnTable().setTableBasics(table);
			table.getColumnModel().getColumn(0).getCellRenderer();
			table.setGridColor(Color.BLUE);
			table.setEnabled(true);
			removeRow(model, table);
			table.setCellSelectionEnabled(false);
			table.setRowHeight(25);
			selectedrow = table.getRowCount() - 1;

			if (EditMode == "N") {
				String vbatchArticle = rs.getString(14);
				String value = rs.getString(1);
				CheckBatchArticle(value, vbatchArticle);
			}
			TableColumnManager tcm1 = new TableColumnManager(table);
			tcm1.hideColumn("E");

			table.setRowSelectionAllowed(true);
			table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
			JViewport prt6 = new JViewport();
			jsp.setViewport(null);
			prt6.setToolTipText("Sales Data ");
			prt6.setScrollMode(0);
			prt6.setBackground(Color.white);
			prt6.add(table, Col);
			prt6.setBackground(Color.white);
			jsp.setViewport(prt6);
			new gnTable().setTablewidth(table, 1, 70);
			new gnTable().setTablewidth(table, 0, 40);
			new gnTable().setTablewidth(table, 2, 300);
			new gnTable().setTablewidth(table, 5, 90);
			new gnTable().setTablewidth(table, 8, 150);
			new gnTable().setTablewidth(table, 11, 200);
			new gnTable().setTablewidth(table, 13, 100);
			new gnTable().setTablewidth(table, 14, 50);
			new gnTable().setTablewidth(table, 15, 200);
			new gnTable().setTablewidth(table, 16, 200);

			removeRow(model, table);
			Double v = new gnTable().getTotal(table, 11);
			vdueamount = v;
			resetFigures();
			scanarticle.setText("");
			scanarticle.grabFocus();
			// Tamount.setText(Double.toString(v));
			int vcount = table.getRowCount();
			myRecords.setText(Integer.toString(vcount));
		}
	}

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			e.notifyAll();
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int i = table.getSelectedRow();
			String value = (String) table.getValueAt(i, 1);
			try {
				QtychangeImapct(value, i);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	public void QtychangeImapct(String value, int i) throws Throwable {
		String curqty1 = "  ";
		Double curqty = 0.00;
		Double vtaxamt = 0.00;

		String vuom = (String) table.getValueAt(i, 4).toString();
		String vinnerqty = (String) table.getValueAt(i, 5).toString();
		switch (vuom) {
		case "NO":
			table.setValueAt(1, i, 5);
			curqty1 = (String) table.getValueAt(i, 3).toString();
			curqty = Double.parseDouble(curqty1);
			break;

		case "Box":
			new General().msg("Enter Box Inner Qty ");
			curqty1 = (String) table.getValueAt(i, 3).toString();
			curqty = Double.parseDouble(curqty1);
			break;
		}
		if (curqty == 0.00) {
			table.setEditingRow(i);
			table.setGridColor(Color.YELLOW);
			table.setBackground(Color.red);
		}

		Double vqty = Double.parseDouble(table.getValueAt(i, 3).toString());
		Double vrate = Double.parseDouble(table.getValueAt(i, 6).toString());
		if (vrate <= 0.00) {
			// Action = "Fail";
			new General().msg("Please Check Cost  at Row" + "  " + i);
			// table.setValueAt("0", i, 6);
		}

		if (vqty <= 0.00) {
			// Action = "Fail";
			new General().msg("Please Check Qty  at Row" + "  " + i);
			// table.setValueAt("0", i, 3);
		}

		Double vhdrdisc = Double.parseDouble(table.getValueAt(i, 9).toString());
		Double vdisc = Double.parseDouble(table.getValueAt(i, 10).toString());
		Double vcostValue = vqty * vrate;
		Double vnet = vcostValue - vdisc - vhdrdisc;

		// if (vnet < 0.00)
		// {
		// vnet = 0.00 ;
		// }

		if (vrate <= 0.00) {
			// Action = "Fail";
			new General().msg("Please Check Cost  at Row" + "  " + i);
			// table.setValueAt("0", i, 6);
		}

		if (vqty <= 0.00) {
			// Action = "Fail";
			new General().msg("Please Check Qty  at Row" + "  " + i);
			// table.setValueAt("0", i, 3);

		}

		// roundingamt.setText(new
		// gnMath().get2DecimaltValue(Double.toString(vroundamt)));
		table.setValueAt(new gnMath().get2DecimaltValue(Double.toString(vcostValue)), i, 8);
		table.setValueAt(new gnMath().get2DecimaltValue(Double.toString(vnet)), i, 11);

		Double vtaxcode = Double.parseDouble(table.getValueAt(i, 12).toString());
		vnet = Double.parseDouble(new gnMath().get2DecimaltValue(Double.toString(vnet)));
		vtaxamt = new gnMath().CalTax_Sales(vnet, vtaxcode);
		String Result = new gnGST().ismyComanyGSTRegister();
		switch (Result) {
		case "N":
			vtaxamt = 0.00;
			break;
		case "Y":
			table.setValueAt(vtaxamt, i, 13);
			break;
		}

		table.addNotify();
		vcheckMargin = "Y";
		if (vcheckMargin == "Y") {
			// String varticle = table.getValueAt(i,1).toString();
			// String vcost = table.getValueAt(i, 17).toString();
			// String vsp = table.getValueAt(i,3).toString();
			// String status = new gnMath().checkMargin(varticle , vcost, vsp) ;
		}
		resetFigures();
		scanarticle.setText("");
		scanarticle.grabFocus();
		new gnLogger().loggerInfoEntry("Credit Sale", "Data Edited" + " Line  " + i + "Value " + value);
	}

	public void resetFigures() throws Throwable {

		// {0"Romove", 1"Item", 2"Name", 3"Qty" , 4"UOM", 5"Inner Qty" , 6"Rate"
		// ,
		// 7"MRP", 8"Gross" ,9"Hdr Disc", 10"Disc" ,
		// 11"Amount", 12"Taxcode" , 13"Tax Amount",
		// 14"Batch Item" , 15"BatchNo", 16"Exp.Date" , 17"Cost", 18"Location"};

		// New Part Added

		grossamt.setText(Double.toString(new gnTable().getTotal(table, 8)));
		linedisc.setText(Double.toString(new gnTable().getTotal(table, 10)));
		billdisc.setText(Double.toString(new gnTable().getTotal(table, 9)));

		tvalue.setText(Double.toString(new gnTable().getTotal(table, 11)));
		// InvAmt.setText(Double.toString( new gnTable().getTotal(table, 13)));

		Double vtamt = (new gnTable().getTotal(table, 11));
		int vnetAmtnew = (int) Math.round(vtamt);
		double vroundamt = (vnetAmtnew - vtamt);

		// roundng Logic is Here
		roundingamt.setText(new gnMath().get2DecimaltValue(Double.toString(vroundamt)));
		Tamount.setText(new gnMath().get2DecimaltValue(Double.toString(vnetAmtnew)));

		new gnLogger().loggerInfoEntry("Credit Sale", "Reset Operation Done");
	}

	private void checkBatchforNonBatchItems(String varticle, String vbatchcontrol) throws Throwable {

		// {"Romove", 1"Item",2 "Name", 3 "Qty" , 4 "UOM", 5 "Inner Qty" ,6
		// "Rate" ,
		// 7"MRP", 8"Gross" ,9"Hdr Disc",10 "Disc" ,
		// 11"Amount", 12 "Taxcode" ,13 "Tax Amount",
		// 14"Batch Item" ,15"BatchNo", 16"Exp.Date" ,17 "Cost",18 "Location"};

		String vcost = "0";
		String vsp = table.getValueAt(selectedrow, 6).toString();
		String vmrp = table.getValueAt(selectedrow, 7).toString();
		String vloc = "SL";
		String vaction = new gnBatch().IsBatchAvailableForIsBatchAvailableforMrpandSP(varticle, vmrp, vsp);
		switch (vaction) {
		case "Y":
			vcost = new gnArticle().Article_getData(varticle, "Cost");
			String vaction1 = new gnBatch().IsMultiBatchForMRP_SalesPrice(varticle, vmrp, vsp, vcost);
			switch (vaction1) {
			case "Y":
				try {
					String vtype = "GZcase123";
					new gnGetBatch().getBatchDetailForNonBathItems(vtype, varticle, vbatchcontrol, vloc);
				} catch (Exception e) {
					new General().msg(e.getLocalizedMessage());
				} finally {
					if (Double.parseDouble(new gnGetBatch().salesPrice) > 0) {
						selectedrow = 0;
						table.setValueAt(new gnGetBatch().batchno, selectedrow, 15);
						table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 16);
						table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 6);
						table.setValueAt(new gnGetBatch().mrp, selectedrow, 7);
						new gnGetBatch().resetValues();
						QtychangeImapct(varticle, selectedrow);
					}
				}
				break;
			case "N":
				String vbatch = new gnBatch().getLowestBatch(varticle, vmrp, vsp, vcost);
				table.setValueAt(vbatch, selectedrow, 15);
				break;
			} // Iswitch
			break;
		case "N":
			String vbatchno = new gnBatch().getNewBatch();
			table.setValueAt(vbatchno, selectedrow, 15);
			break;
		}// Outer Switch
	}

	public String CheckBatchArticle(String varticle, String vbatchcontrol) throws Throwable {
		// new General().msgDispose();
		String status = "Sucess";
		String vstorecode = vstore;
		;
		String vcomp = new gnConfig().getCompanyCode();
		String vloc = table.getValueAt(selectedrow, 18).toString();

		String batch[] = { "BatchArticlce", "Item Code", "name", "cost", "SalesPrice", "Mrp", "Batchno", "Manuf_date",
				"Exp.Date", "Bal_Qty" };

		String vpara811 = "811";
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
				vstorecode);
		switch (vmaintainbatchforNonBatchItem) {
		case "N":
			try {
				new gnGetBatch().getBatchDetail(varticle, vbatchcontrol, vloc);
			} catch (Exception e) {
				new gnLogger().loggerInfoEntry("Credit Sale", "Get Batch Exception" + " " + e.getMessage());
				// new General().msg(e.getLocalizedMessage());
			} finally {
				table.setValueAt(new gnGetBatch().batchno, selectedrow, 15);
				table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 16);
				new gnGetBatch().resetValues();
			}
			break;
		case "Y":
			checkBatchforNonBatchItems(varticle, vbatchcontrol);
		}
		return status;

	}// Method End

	public void showSearch(String SQL, String[] Colnames) throws Throwable {
		new gnTable().RemoveTableRows(smodel);
		stable = new gnTableModel().Tablemodel10(stable, smodel, SQL, Colnames, 10, "N", "N", "N");
		new gnTable().setTableBasics(table);
		if (stable.getRowCount() > 0) {
			new gnTable().setTablewidth(stable, 2, 300);
			new gnTable().setTablewidth(stable, 1, 100);
		}
		stable.setEnabled(true);
		stable.setCellSelectionEnabled(false);
		stable.setRowSelectionAllowed(true);
		stable.setGridColor(Color.BLUE);
		stable.setBackground(Color.WHITE);
		stable.setSelectionBackground(Color.CYAN);
		DefaultCellEditor nk = new gnTable().cellEdit(stable);
		nk.addCellEditorListener(ChangeNotification2);
		JViewport prt6 = new JViewport();
		prt6.add(stable, Colnames);
		prt6.setVisible(true);
		sjsp.setViewport(prt6);
		if (stable.getRowCount() > 0) {
			String vbatchv = (String) stable.getValueAt(0, 0);
			int vrw = stable.getRowCount();
			switch (vbatchv) {
			case "N":
				if (vrw > 1) {
					// new General().msgsearch(sjsp, stable, "Select Sales Price
					// " , 1000,400);
				}
				break;
			case "Y":
				new General().msgsearch(sjsp, stable, "Select Batch ", 1000, 500);
				break;
			}
		}
	}// End Search Table

	public CellEditorListener ChangeNotification2 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = stable.getSelectedRow();
			String vtype = (String) stable.getValueAt(row, 0);
			String varticle = (String) stable.getValueAt(row, 1);
			try {
				// displayInfo(vtype , row) ;
				QtychangeImapct(varticle, selectedrow);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	};
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField crdays;
	private JButton btnAdvance;
	private JTextField paymentduedate;
	private JTextField showInv;
	private JTextField dueamount;
	private JTextField statecode;
	private JTextField statename;
	private JTextField advno;
	private JTextField disc;
	private JTextField tvalue;
	private JTextField roundingamt;
	private JLabel lblNewLabel_21;
	private JTextField scanqty;
	private JTextField rate;
	private JTextField discount;
	private JTextField regdlr;
	private JPanel panel_5;
	private JLabel lblNewLabel_1;
	private JTextField grossamt;
	private JTextField linedisc;
	private JTextField billdisc;
	private JTextField discper;
	private JLabel myRecords;
	private JLabel myQty;

	public void displayInfo(String vtype, int row) {
		// new General().msg(vtype);
		String vmrp = " ";
		String vcost = " ";
		String vsp = " ";
		String vexpdate = " ";
		String vmanufdate = " ";
		String vbatchno = " ";
		switch (vtype) {
		// public String poscol[] = {"Romove", 1"Item",2 "Name", 3"Qty" , 4
		// "UOM", 5 "Inner Qty" ,6 "Rate" , 7 "MRP", 8"Gross" ,9"Hdr Disc",
		// 10"Disc" ,
		// 11"Amount", 12"Taxcode" ,13 "Tax Amount",
		// 14"Batch Item" , 15"BatchNo", 16"Exp.Date" ,17 "Cost"};
		case "Y":
			// vcost = (String) stable.getValueAt(row, 3) ;
			// vsp = (String) stable.getValueAt(row, 4) ;
			// vmrp = (String) stable.getValueAt(row, 5) ;
			// vmanufdate = (String) stable.getValueAt(row, 9) ;
			vbatchno = (String) stable.getValueAt(row, 6);
			vexpdate = (String) stable.getValueAt(row, 8);
			// new General().msg("BAtch no Exp date" + " "+vbatchno + "
			// "+vexpdate);
			table.setValueAt(vbatchno, selectedrow, 15);
			table.setValueAt(vexpdate, selectedrow, 16);
			// table.setValueAt(vcost, selectedrow, 15);
			// table.setValueAt(vmrp, selectedrow, 5);
			// table.setValueAt(vsp, selectedrow, 4);
			new gnTable().RemoveTableRows(smodel);
			// Article_Search.grabFocus();
			new General().msgDispose();
			break;
		}
	}

	public void removeRow(DefaultTableModel xmodel, JTable xtable) {
		// new General().msg("I REached Here ") ;
		String vauthallow = "N";
		DefaultTableModel modelName = xmodel;
		JTable tableName = xtable;

		TableColumn Del = tableName.getColumnModel().getColumn(0);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setSelected(false);
		chkbox.setVisible(true);
		chkbox.setMargin(new Insets(0, 16, 0, 0));
		chkbox.setIconTextGap(0);
		chkbox.setBackground(new Color(255, 255, 255, 0));
		chkbox.setText("");

		Del.setCellRenderer(new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Del.setCellEditor(new DefaultCellEditor(chkbox));
				// chkbox.setSelected(((Boolean)value).booleanValue()) ;
				return chkbox;
			}
		});

		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int nn = e.getStateChange();
				if (nn == 2 && modelName == model) {
					int lastrow = tableName.getRowCount();
					if (lastrow > 0) {
						int r = tableName.getSelectedRow();
						int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
						if (option == 0) {
							if (vauthallow == "Y") {
								Authorize window = new Authorize();
								window.frameauth.setVisible(true);
								window.frameauth.setAlwaysOnTop(true);
								modelName.removeRow(r);
							}
							modelName.removeRow(r);
							Double v = new gnTable().getTotal(table, 11);
							Tamount.setText(Double.toString(v));
							vdueamount = v;
							int vcount = table.getRowCount();
							myRecords.setText(Integer.toString(vcount));
						}
					}
					return;
				}
			}
		});
	}

	private String validate() {
		new gnLogger().loggerInfoEntry("Credit Sale", "Validation Starts");
		vcustomer = customercode.getText();
		String status = "Sucess";

		String status1 = new gnTable().isAmountnegative(Tamount.getText());
		String status2 = new gnTable().istableColValueNegative(table, 3);
		String status3 = new gnTable().istableColValueNegative(table, 6);

		Double vamt = Double.parseDouble(Tamount.getText());

		if (status1 == "Fail" || status2 == "Fail" || status3 == "Fail") {
			status = "Fail";

		}

		boolean isexport = exportsales.isSelected();
		if (isexport) {
			try {
				vshipbillno = new impExp_shipping().vbillno;
				vshipbilldate = new impExp_shipping().vbilldate;
				if (vshipbillno.length() == 0) {
					new General().msg("Please Enter  Shipping Details for Export Sales");
					status = "Fail";
				}
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		boolean vpay = rbcrsale.isSelected();

		if (vpay) {
			if (customername.getText().length() == 0) {
				new General().msg("Select Customer Or Create New Customer For  Credit Sales .. ");
				status = "Fail";
				customername.grabFocus();
			}

			String vcrdays = crdays.getText();

			if (vcrdays.length() == 0) {
				new General().msg("Enter Credit Days For Credit Sales .. ");
				status = "Fail";
				crdays.grabFocus();
			}
		} else {
			if (vdueamount > 0) {
				new General().msg("Check Bill Amount and Paid Amount..Payment is Due..");
				btnPayment.doClick();
				status = "Fail";
			}
		}

		switch (menu) {
		case "B2B":
			if (vcustomer.length() == 0) {
				new General().msg("Select Customer");
				status = "Fail";
			}

			if (vamt == 0.00) {
				new General().msg("Enter  Invoice Qty For Billing ");
				status = "Fail";
			}
			break;

		case "wsales":
			if (vcustomer.length() == 0) {
				vcustomer = "0";
			}
			if (vamt == 0.00) {
				new General().msg("Enter  Invoice Qty For Billing ");
				status = "Fail";
			}
			new gnImageSound().playAlertSound();
			break;
		}

		new gnLogger().loggerInfoEntry("Credit Sale", "Validaion Over - Status is" + "" + status);
		return status;
	}

	private void PrepareToInsert() throws Throwable {
		switch (menu) {
		case "B2B":

			if (EditMode == "N") {
				invno.setText(new gnSeq().getSeqno("5", "TR"));
			}
			vinvno = invno.getText();
			vsalestype = "B2B";
			vinvtype = "B2B";
			vglcode = new gnSeq().getGlcode("5", "TR");
			vpostingtype = "Y";
			break;

		case "wsales":
			if (EditMode == "N") {
				invno.setText(new gnSeq().getSeqno("5", "TR"));
			}
			vinvno = invno.getText();
			vsalestype = "WS";
			vinvtype = "WS";
			vpostingtype = "Y";
			vglcode = new gnSeq().getGlcode("5", "TR");
			break;
		}

		try {
			new gnLogger().loggerInfoEntry("Credit Sale", "Data Insert Process Start");
			vcustomer = customercode.getText();
			vuser = new gnConfig().getUserCode();
			vinvdate = new gnConfig().date_ConverttoDBforamt(invdate.getText());
			vterminal = "0";
			vtime = new General().getTime();
			vverticle = new gnHierarchy().getVerticleCode();
			vnetamount = Tamount.getText();

			// GST
			vmygstno = new gnGST().getComanyGSTno().trim();
			vmycompanystate = new gnGST().getmyState().trim().trim();
			vmyCompanyisGST = new gnGST().ismyComanyGSTRegister().trim();
			vmystatename = new gnGST().getmystatename();
			vstate = new gnGST().getCustomerState(customercode.getText().trim());
			vstatename = new gnGST().getCustomerStatename(customercode.getText().trim());
			vregdlr = new gnGST().isCustmoerGSTRegister(customercode.getText().trim());
			vcustGSTno = new gnGST().getCustomerGSTNO(customercode.getText().trim());

			vadvrcptno = advno.getText();
			if (vadvrcptno.length() == 0) {
				vadvrcptno = "0";
			}
			boolean isimport = exportsales.isSelected();
			if (isimport) {
				vexport = "Y";
				vshipbillno = new impExp_shipping().vbillno;
				vshipbilldate = new gnConfig().date_ConverttoDBforamt(new impExp_shipping().vbilldate);
				vexpporttype = new impExp_shipping().vexportType;
			} else {
				vexport = "N";
				vshipbillno = " ";
				vshipbilldate = "";
			}

			boolean isSEZ = sez.isSelected();
			if (isSEZ) {
				vsez = "Y";
				vshipbillno = new impExp_shipping().vbillno;
				vshipbilldate = new gnConfig().date_ConverttoDBforamt(new impExp_shipping().vbilldate);
				vexpporttype = new impExp_shipping().vexportType;
			} else {
				vsez = "N";
			}

			boolean vselection = chrevchrg.isSelected();
			if (vselection) {
				vreversechrg = "Y";
			} else {
				vreversechrg = "N";
			}

			vstate = vstate.trim();
			vmycompanystate = vmycompanystate.trim();

			vmy = Integer.parseInt(vmycompanystate);
			voth = Integer.parseInt(vstate);

			if ((vmy - voth == 0)) {
				vmovtype = "Intra-State";
			}
			if ((vmy - voth != 0)) {
				vmovtype = "Inter-State";

			}

			// End GST Field

			boolean vpay = rbcrsale.isSelected();
			if (vpay) {
				vpaytype = "Due";
				vcreditDays = crdays.getText();
			} else {
				vpaytype = "Paid";
				vcreditDays = "0";
			}
		} catch (Exception e) {
			// new General().msg("Prepare to insert :"+e.getLocalizedMessage());
		}

		insertintoGLmaster();

		if (EditMode == "Y") {
			new gnEDMiddleWare().SalesModification(vinvtype, invno.getText(), invdate.getText());
		}
		insertPosDetails();
	}

	private void insertintoGLmaster() throws Throwable {
		String vglcode = customercode.getText();
		String vglname = customername.getText();
		String vtype = "N";
		new gnAccountbase().insertGlData(vglcode, vglname, vtype);
	}

	//// pos Details Start here
	public void insertPosDetails() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		int pd_seq;
		DBdetail = "Fail";
		String poshdr = "Insert into pos_sales_detail (company_code ,"
				+ "site_code,   invDate	,  invno,  Article_code , EAN ,"
				+ "customer_code   ,  qty , sales_price,   MRP,   Taxcode,   Gross_amount, "
				+ "Disc,   hdr_disc ,   net_amount ,  Tax_amount ,  Promo_ind ,  promo_code,"
				+ "line_seq ,  CreatedBy,  insert_status,  Cashier_code, "
				+ "Terminal_ID,  shift ,  srno,   tax_per,   sales_type , "
				+ "batch_article,   Batch_no,   Expiry_date,   cost,   verticle,   uom, location,"
				+ " state, statename, regdealer, mycompanyisgst, mygstno, mycompState, custGSTno, "
				+ " cgst, sgst, igst , movementType,  taxablevalue, mystatename, finyear, cogs)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?, ?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?) ";

		prst = con1.prepareStatement(poshdr);
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				pd_seq = k + 1;
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vinvdate);
				prst.setString(4, vinvno);
				prst.setString(5, table.getValueAt(k, 1).toString());
				prst.setString(6, "0");
				prst.setString(7, vcustomer);
				prst.setString(8, (table.getValueAt(k, 3).toString())); // invqty
				prst.setDouble(9, Double.parseDouble(table.getValueAt(k, 6).toString())); // SP
				prst.setDouble(10, Double.parseDouble(table.getValueAt(k, 7).toString())); // Mrp
				prst.setString(11, (table.getValueAt(k, 12).toString())); // taxcode
				prst.setDouble(12, Double.parseDouble(table.getValueAt(k, 8).toString())); // Gross
				prst.setDouble(13, Double.parseDouble(table.getValueAt(k, 10).toString())); // disc
				prst.setDouble(14, Double.parseDouble(table.getValueAt(k, 9).toString())); // hdrdisc
				prst.setDouble(15, Double.parseDouble(table.getValueAt(k, 11).toString())); // netAmt
				prst.setDouble(16, Double.parseDouble(table.getValueAt(k, 13).toString())); // taxamt
				prst.setString(17, "N");
				prst.setString(18, "N");
				prst.setInt(19, pd_seq); // lineseq
				prst.setString(20, vuser); // cashiercode
				prst.setString(21, "Y"); // insertStatus
				prst.setString(22, vuser);
				prst.setString(23, vterminal); //
				prst.setInt(24, 0);
				prst.setInt(25, k);
				prst.setString(26, table.getValueAt(k, 12).toString()); // tax_per
				prst.setString(27, vsalestype);
				prst.setString(28, table.getValueAt(k, 14).toString()); // batchitem
				prst.setString(29, table.getValueAt(k, 15).toString()); // batchno
				prst.setString(30, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 16).toString().trim()));
				prst.setString(31, table.getValueAt(k, 17).toString());
				prst.setString(32, vverticle);
				prst.setString(33, table.getValueAt(k, 4).toString());
				prst.setString(34, table.getValueAt(k, 18).toString());
				prst.setString(35, vstate);
				prst.setString(36, vstatename);
				prst.setString(37, vregdlr);
				prst.setString(38, vmyCompanyisGST);
				prst.setString(39, vmygstno);
				prst.setString(40, vmycompanystate);
				prst.setString(41, vcustGSTno);

				if ((vmy - voth == 0 & vexport == "N" & vsez == "N"))
					;
				{
					double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 13).toString());
					double vcgst = vcaltaxamt / 2;
					double vsgst = vcaltaxamt / 2;
					double vigst = 0.00;

					prst.setString(42, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
					prst.setString(43, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
					prst.setString(44, new gnMath().get2DecimaltValue(Double.toString(vigst)));
					prst.setString(45, vmovtype);
				}

				if ((vmy - voth != 0 & vexport == "N" & vsez == "N")) {
					double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 13).toString());
					double vcgst = 0.00;
					double vsgst = 0.00;
					double vigst = vcaltaxamt;
					prst.setString(42, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
					prst.setString(43, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
					prst.setString(44, new gnMath().get2DecimaltValue(Double.toString(vigst)));
					prst.setString(45, vmovtype);

				}
				if ((vexport == "Y" || vsez == "Y"))

				{
					double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 13).toString());
					double vcgst = 0.00;
					double vsgst = 0.00;
					double vigst = vcaltaxamt;
					prst.setString(42, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
					prst.setString(43, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
					prst.setString(44, new gnMath().get2DecimaltValue(Double.toString(vigst)));
					prst.setString(45, vmovtype);

				}

				double vnet = Double.parseDouble(table.getValueAt(k, 11).toString());
				double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 13).toString());

				double vtaxablevalue = vnet - vcaltaxamt;
				prst.setString(46, new gnMath().get2DecimaltValue(Double.toString(vtaxablevalue)));
				prst.setString(47, vmystatename);
				prst.setString(48, new gnFinYear().getCurrentFinYear(invdate.getText()));

				// cogs

				double vtaxper = Double.parseDouble(table.getValueAt(k, 12).toString());
				double vcost = Double.parseDouble(table.getValueAt(k, 17).toString());
				double vqty = Double.parseDouble(table.getValueAt(k, 3).toString());
				// Double vcostvalue = vqty * vcost ;
				Double vcogs = new gnMath().CalTax_Pur(vcost, vtaxper);
				Double vcostvalue = vcost - vcogs;
				vcostvalue = vqty * vcostvalue;
				prst.setString(49, new gnMath().get2DecimaltValue(Double.toString(vcostvalue)));

				prst.addBatch();
				// new General().msg("Reahed...POs detail "+prst);

				TotalRecordinsert = TotalRecordinsert + 1;
				vvggross = vvggross + Double.parseDouble(table.getValueAt(k, 8).toString());
				vvdisc = vvdisc + (Double.parseDouble(table.getValueAt(k, 9).toString())
						+ Double.parseDouble(table.getValueAt(k, 10).toString()));
				if (TotalRecordinsert % batchSize == 0) {
					int[] recordws = prst.executeBatch();
					// con1.commit();
					DBdetail = "Sucess";
				}
				int[] ff = prst.executeBatch(); // insert remaining records
				// con1.commit();
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con1.rollback();
			DBdetail = "Fail";
			new gnLogger().loggerInfoEntry("Credit Sale", "Detail Data Exception" + " " + e.getMessage());
			new General().msg("Detail:" + e.getMessage());
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {
				insertPosHdr();
			}
		}
	}

	public void insertPosHdr() throws Throwable {
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con2 = this.getConnection();
		con2.setAutoCommit(false);
		DBhdr = "Fail";
		String poshdr = "Insert into pos_sales_hdr(company_code , " + "site_code, terminal_id ,  invno,   invDate ,  "
				+ "cashier_code, sales_type," + " Invoice_type, Posting_type, Gross_Amount,"
				+ " Discount, Net_Amount, customer_code, shift, verticle, time, payment_status, creditDays, due_date, "
				+ "  state, statename, regdealer, mycompanyisgst, mygstno, mycompState, custGSTno, movementtype,"
				+ " reversecharge, export, sezzone, mystatename, advReceiptno, shippingbillno, shippingbilldate, exporttype, glcode, Roundingamt, fineyear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,? ,?,?,?,?,?,?,?,? , ?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con2.prepareStatement(poshdr);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, vterminal);
			prst.setString(4, vinvno);
			prst.setString(5, vinvdate);
			prst.setString(6, vuser);
			prst.setString(7, vsalestype);
			prst.setString(8, vinvtype);
			prst.setString(9, vpostingtype);
			prst.setDouble(10, Double.parseDouble(tvalue.getText()));
			prst.setDouble(11, vvdisc);
			prst.setString(12, vnetamount);
			prst.setString(13, vcustomer);
			prst.setInt(14, 0);
			prst.setString(15, vverticle);
			prst.setString(16, new General().getTime());
			prst.setString(17, vpaytype);
			prst.setString(18, vcreditDays);
			prst.setString(19, new gnConfig().date_ConverttoDBforamt(paymentduedate.getText()));
			prst.setString(20, vstate);
			prst.setString(21, vstatename);
			prst.setString(22, vregdlr);
			prst.setString(23, vmyCompanyisGST);
			prst.setString(24, vmygstno);
			prst.setString(25, vmycompanystate);
			prst.setString(26, vcustGSTno);
			prst.setString(27, vmovtype);
			prst.setString(28, vreversechrg);
			prst.setString(29, vexport);
			prst.setString(30, vsez);
			prst.setString(31, vmystatename);
			prst.setString(32, vadvrcptno);
			prst.setString(33, vshipbillno);
			prst.setString(34, vshipbilldate);
			prst.setString(35, vexpporttype);
			prst.setString(36, vglcode);
			prst.setString(37, roundingamt.getText());
			prst.setString(38, new gnFinYear().getCurrentFinYear(invdate.getText()));
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBhdr = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBhdr = "Sucess";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con2.rollback();
			DBhdr = "Fail";
			new gnLogger().loggerInfoEntry("Credit Sale", "Hdr Data Exception" + " " + e.getMessage());
			new General().msg("Detail:" + e.getMessage());
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") {
				con1.commit();
				con2.commit();
				con1.close();
				con2.close();
				new gnLogger().loggerInfoEntry("Credit Sale", "Detail & Hdr Data  Save- Sucess");
				switch (menu) {
				case "B2B":
					updateQuotationStatus();
					if (EditMode == "N") {
						new gnSeq().updateSeqno("5", "TR");
					}
					calculateGSTReturnData();
					break;
				case "wsales":
					if (EditMode == "N") {
						new gnSeq().updateSeqno("5", "TR");
					}
					calculateGSTReturnData();
					break;
				}
				insertPayment();
			}
		}
	}//// Insert Heade End

	private void updateQuotationStatus() {
		switch (menu) {
		case "B2B":
			String vquotno = Quotno.getText();
			String SQL = "Call  wSales_updateQuotation(" + vcomp + " , " + vstore + ", " + vquotno + ") ";
			try {
				this.getResult(SQL);
			} catch (SQLException e) {
				e.printStackTrace();
				new General().msg(e.getLocalizedMessage());
			}
			break;
		}

	}

	// NKPayment Insert
	private void insertPayment() throws Throwable {
		boolean vpay = rbcrsale.isSelected();
		if (vpay) {
			reduceInv();
			// Stock_in_hand_details();
			btnPrint.doClick();
			new General().msg("Invoice Saved  Sucessfully");
			reset();
		} else {
			try {
				paymentCollection();
				inventoryImpact();
				new General().msg("Invoice Saved  Sucessfully");
				reset();
			} catch (Exception e) {
				new General().msg(e.getLocalizedMessage());
			} finally {
			}
		}
	}

	private void inventoryImpact() throws NumberFormatException, Throwable {
		DBaction = new gnConfig().invoiceaudit(Integer.parseInt(vinvno));
		if (DBaction == "Sucess") {

			btnPrint.doClick();
			reduceInv();

			// Stock_in_hand_details();
			new General().msg("Invoice Saved  Sucessfully");
			reset();
		}
	}

	public void paymentCollection() throws Throwable {
		statusCC = "Sucess";
		statusCA = "Sucess";
		statusCN = "Sucess";
		int row = ptable.getRowCount();
		String mode = " ";
		Double vcash = 0.00;
		Double vcc = 0.00;
		String pmcash = "Cash";
		String pmCC = "CC";
		String pmCN = "CN";
		int vsrno = 0;
		int vsrno1 = 0;
		for (int i = 0; i < row; i++) {
			mode = ptable.getValueAt(i, 1).toString().trim();
			switch (mode) {
			case "Cash":
				vcash = vcash + (Double.parseDouble(ptable.getValueAt(i, 2).toString()));
				break;
			}
		}
		if (vcash > 0) {
			vcash = vcash + new CreditSalesPayment().vduepayment;
			statusCA = insertPayment(pmcash, vcash, 0, vsrno);
		}

		// Credit Card
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim();
			switch (mode) {
			case "Credit Card":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				statusCC = insertPayment(pmCC, vcc, vno, vsrno1);
				break;
			}

		}

		// Credit Note consume - Update Payment_dncn_master Table
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim();
			switch (mode) {
			case "Credit Note":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				statusCN = insertPayment(pmCN, vcc, vno, vsrno1);
				// new General().msg("statusCN is insert is "+ statusCN);
				if (statusCN == "Sucess") {
					/// Updating Credit note Details for Consume Credit Notes
					/// ///
					String vrefdocno = invno.getText();
					// String vinvdate = vinvdate;
					String vreftrantype = "5";
					String vtype = "CN";
					String vcustid = vcustomer;
					String vdocno = (String) ptable.getValueAt(i, 3);
					Double vcnamount = vcc;
					String vamt = Double.toString(vcnamount);
					// new General().msg("updating CN is "+ vdocno);
					String vcomp = new gnConfig().getCompanyCode();
					String vstore = new gnConfig().getStoreID();
					String SQL = "call cn_updateCnDetails('" + vinvdate + "'  , " + vreftrantype + ",   '" + vrefdocno
							+ "'  ,  '" + vtype + "'  , " + vcustid + " , " + "" + vdocno + "  ," + vamt + " ,  "
							+ vcomp + "  , " + vstore + ")";
					// new General().msg(SQL);
					this.getSPResult(SQL);
				}
				break;
			}
		}
	}

	private String insertPayment(String vpmode, Double vamount, int vno, int i) throws Throwable {
		DBaction = "Fail";
		String mode = " ";
		int row = ptable.getRowCount();
		prst = null;
		vpaymentmode = vpmode;
		vpaymentamount = vamount;
		int vccno = vno;
		final int batchSize = 2;
		int TotalRecordinsert = 0;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		// String Status = "Fail" ;
		String pospayment = "Insert into  pos_Payments(company_code , " + "site_code,   invdate ,  invno,  "
				+ "cashier_code,   terminal_id , Payment_mode, Amount," + "Advance_Payment_Ind , TransactionType, "
				+ " Invoice_type, sales_type, Posting_type , currency, shift, srno, card_number, verticle, finyear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		prst = con.prepareStatement(pospayment);
		try {
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, vinvdate);
			prst.setString(4, vinvno);
			prst.setString(5, vuser);
			prst.setString(6, vterminal);
			prst.setString(7, vpaymentmode);
			prst.setDouble(8, vpaymentamount);
			prst.setString(9, "N");
			prst.setString(10, "5");
			prst.setString(11, vinvtype);
			prst.setString(12, vsalestype);
			prst.setString(13, vpostingtype);
			prst.setString(14, "INR");
			prst.setInt(15, 0);
			prst.setInt(16, i);
			prst.setInt(17, vccno);
			prst.setString(18, vverticle);
			prst.setString(19, new gnFinYear().getCurrentFinYear(invdate.getText()));

			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				con.commit();
				DBaction = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			con.commit();
			DBaction = "Sucess";
		} catch (SQLException e) {
			new General().msg("Payment===>" + e.getMessage());
			new gnLogger().loggerInfoEntry("Credit Sale", "Payment Entry Exception" + " " + e.getLocalizedMessage());
			con.rollback();
			DBaction = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return DBaction;
	}
	// End Payment Insert

	/// Reduce Inventory
	public String reduceInv() throws Throwable {
		String Action = " ";
		String vtype = "Sales";
		String varticle = " ";
		String vqty = "0.00";
		int rw = table.getRowCount();
		String vfinyear = new gnFinYear().getReportingFinYear();

		switch (menu) {
		case "B2B":
			String vtrntype = "B2B";
			String SQL = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vinvno + " , '"
					+ vinvdate + "' , '" + vfinyear + "')";
			this.getSPResult(SQL);
			String SQL1 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vinvno
					+ " , '" + vinvdate + "' ,  '" + vfinyear + "')";
			this.getSPResult(SQL1);

			String vpara811 = "811";
			String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
					vstore);
			switch (vmaintainbatchforNonBatchItem) {
			case "Y":
				SQL1 = "call Inv_impact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vinvno
						+ " , '" + vinvdate + "' ,  '" + vfinyear + "')";
				this.getSPResult(SQL1);
				break;
			}
			break;
		case "wsales":
			String vtrntype1 = "WS";
			String SQL2 = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   " + vinvno + " , '"
					+ vinvdate + "', '" + vfinyear + "')";
			this.getSPResult(SQL2);

			String SQL3 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   " + vinvno
					+ " , '" + vinvdate + "' ,  '" + vfinyear + "')";
			this.getSPResult(SQL3);

			vpara811 = "811";
			vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
			switch (vmaintainbatchforNonBatchItem) {
			case "Y":
				String SQL4 = "call  Inv_impact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   "
						+ vinvno + " , '" + vinvdate + "' ,  '" + vfinyear + "')";
				this.getSPResult(SQL4);
				break;
			}
			new gnLogger().loggerInfoEntry("Credit Sale", "Inventory Impact After Credit Sales (Status- Sucess)");
			break;
		}

		/*
		 * for ( int k1 =0 ; k1 < rw ; k1++) { varticle =
		 * table.getValueAt(k1,1).toString(); vqty =
		 * table.getValueAt(k1,3).toString() ; String vloc = "SL" ; String
		 * vinvtype = "0" ; String vbatchControl =
		 * table.getValueAt(k1,14).toString() ; new applyInv_Action().
		 * invAction(vstore , varticle, vtype, vinvdate, vqty, vloc, vcomp,
		 * vverticle, vinvtype, vbatchControl) ; Action = "Sucess" ; }
		 */
		return Action;
	}

	/// Inserting BAtch DEtails
	public void Stock_in_hand_details() throws Throwable {
		prst = null;
		final int batchSize = 7;
		int TotalRecordinsert = 0;
		this.closeconn();
		String status;
		con5 = this.getConnection();
		con5.setAutoCommit(false);
		String stockdetail = "Insert into stock_in_hand_details(Company_code, Site_code , "
				+ "Article_code,   Location ,   " + "supplier_code,   Batch_no, " + "Manuf_date, Expiry_date,"
				+ "Batch_qty,  bal_qty ,   cost ,  " + "SalesPrice, MRP,  " + " createDate, updateDate, verticle)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// public String poscol[] = {"Romove", 1"Item",2 "Name", 3"Qty" , 4
		// "UOM",
		// 5 "Inner Qty" ,6 "Rate" , 7 "MRP", 8"Gross" ,9"Hdr Disc", 10"Disc" ,
		// 11"Amount", 12"Taxcode" ,13 "Tax Amount",
		// 14"Batch Item" , 15"BatchNo", 16"Exp.Date" ,17 "Cost"};
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				String vbatchEnable = table.getValueAt(k, 14).toString();
				// new General().msg(vbatchEnable);
				switch (vbatchEnable) {
				case "Y":

					String vvexpdate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 16).toString().trim());
					String result = new gnConfig().batch_isBatchExist(vstore, table.getValueAt(k, 1).toString(),
							table.getValueAt(k, 15).toString(), vvexpdate, "SL", vcomp);
					// new General().msg("is Batch Exist result is"+ result);

					switch (result) {
					case "update":
						String varticle = table.getValueAt(k, 1).toString();
						String vbatchno = table.getValueAt(k, 15).toString();
						Double vsqty = Double.parseDouble((table.getValueAt(k, 3).toString()));
						vsqty = vsqty * -1;
						String vqty = Double.toString(vsqty);
						String vloc = "SL";
						String vvexpdate1 = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 16).toString());
						String SQL = "call batch_Addstock( " + vqty + " , " + vstore + ",  " + varticle + " , "
								+ vbatchno + " , '" + vvexpdate1 + "', '" + vloc + "', " + vcomp + " ,+" + vverticle
								+ ")";
						// new General().msg(SQL);
						this.getSPResult(SQL);

						break;

					case "insert":
						prst = con5.prepareStatement(stockdetail);
						String vloc1 = "SL";
						prst.setString(1, vcomp);
						prst.setString(2, vstore);
						prst.setString(3, (table.getValueAt(k, 1).toString()));
						prst.setString(4, vloc1);
						prst.setString(5, "0");
						prst.setString(6, (table.getValueAt(k, 15).toString()));
						String vmnfDate = "0000.00.00";
						prst.setString(7, vmnfDate);
						// prst.setString(8, new
						// gnConfig().date_ConverttoDBforamt(table.getValueAt(k,16).toString().trim())
						// ) ;
						prst.setString(8,
								new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 16).toString().trim()));

						Double vsqty2 = Double.parseDouble((table.getValueAt(k, 3).toString()));
						vsqty = vsqty2 * -1;
						String vqty2 = Double.toString(vsqty);
						prst.setString(9, vqty2);
						prst.setString(10, vqty2);
						prst.setString(11, (table.getValueAt(k, 17).toString()));
						prst.setString(12, (table.getValueAt(k, 6).toString()));
						prst.setString(13, (table.getValueAt(k, 7).toString()));
						prst.setString(14, vinvdate);
						prst.setString(15, vinvdate);
						prst.setString(16, vverticle);
						prst.addBatch();
						TotalRecordinsert = TotalRecordinsert + 1;
						if (++TotalRecordinsert % batchSize == 0) {
							prst.executeBatch();
							status = "Sucess";
							con5.commit();
						}
						prst.executeBatch(); // insert remaining records
						con5.commit();
						status = "Sucess";
					}
					break;
				}
			} // for
		} catch (SQLException e) {
			new General().msg("stock Details" + " " + e.getMessage());
			con5.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con5 != null) {
				con5.close();
			}
		}
	}

	private void calculateGSTReturnData() throws Throwable {
		String vinvno = invno.getText();
		String vdocdate = invdate.getText();
		String vparty = customercode.getText();
		String vdocno = invno.getText();
		String vamount = Tamount.getText();
		switch (PostGST_accountEntryAtSaveTime) {
		case "Y":
			// new gnGSTMiddleWare().gstCreditSaleProcess(vparty, vdocno,
			// vdocdate, vamount);
			new gnGSTMiddleWare().backend_DocgstPOSSalesProcess(vparty, vdocno, vdocdate, vamount);

			new gnLogger().loggerInfoEntry("Credit Sale", "GST Data Calculation and Account Posting - Sucess");
			break;
		}

		updateadvstatus();

	}

	public void updateadvstatus() throws Throwable {
		if (advno.getText().length() > 0) {
			String vadvno = advno.getText();
			String vadvdate = advdate;
			String vinvdate = invdate.getText();
			String vcat = "C";
			new gnDncnAdv().updateadvstatus(vadvdate, vinvdate, vadvno, vcat);
		}
	}

	private void callprint() throws Throwable {

		String vpara27 = "27";
		String printinvoice = new getConfigurationSetting().getSpecificConfiguration(vpara27);
		switch (printinvoice) {
		case "Y":
			new General().msg("Printing Invoice");
			String vinvno = invno.getText();
			String doctype = "Credit-INV";
			new gnDocPrint().callprint(doctype, vinvno, invdate.getText());
			new gnLogger().loggerInfoEntry("Credit Sale", "Printing Document");
			// printTaxDetails();
		}
	}

	private void printTaxDetails() throws Throwable {

		String isregister = new gnGST().ismyComanyGSTRegister();
		if (isregister == "Y") {
			new General().msg("Calling GST Breakup Report");
			String vdoctype = "GST-Breakup";
			String vinvno = invno.getText();
			new gnDocPrint().callprint(vdoctype, vinvno, invdate.getText());
		}
	}

	private String checkAllowNegInv(String varticle) throws Throwable {
		String vallowyn = "";
		String vallow = "";
		double vqty = 0.00;
		vallow = new getConfigurationSetting().AllowNegInv();
		int vl = varticle.length();
		// new General().msg("Article Length" + " "+vl);
		if (varticle != "") {
			vqty = new gnStockcheck().getArticleStock(varticle, "SL");
		}
		switch (vallow) {
		case "Y":
			vallowyn = "Y";
			break;
		case "N":
			if (vqty <= 0.00) {
				new General().msg("Negative Inventory Not Allow");
				vallowyn = "N";
			}
			break;
		}
		return vallowyn;
	}

	private void reset() {
		// invno.setText(null);
		new gnLogger().loggerInfoEntry("Credit Sale", "Transaction Complete- Sucess");
		EditMode = "N";
		customercode.setText("0");
		customername.setText(null);
		;
		btnEdit.setBackground(new Color(51, 255, 255));
		btnEdit.setForeground(new Color(0, 0, 153));
		btnEdit.setFont(new Font("Cambria", Font.BOLD, 12));
		scanarticle.setVisible(true);
		searchname.setVisible(true);

		try {
			invdate.setText(new gnConfig().getDaybeginDate());
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		voth = 0;
		vmy = 0;
		customercode.setText("0");
		customername.setText(null);
		;
		Tamount.setText("0");
		myRecords.setText("0");
		myQty.setText("0");
		crdays.setText("0");
		paymentduedate.setText("0");
		new gnTable().RemoveTableRows(pmodel);
		new gnTable().RemoveTableRows(model);
		advno.setText(null);
		exportsales.setSelected(false);
		sez.setSelected(false);
		try {
			new impExp_shipping().vbilldate = null;
			new impExp_shipping().vbillno = null;
			new impExp_shipping().vexportType = null;
		} catch (Throwable e) {
			e.printStackTrace();
		}
		customername.grabFocus();
		EditMode = "N";
	}
}// Last

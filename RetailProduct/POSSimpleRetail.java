package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.NumberFormatter;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import com.mysql.jdbc.Statement;

public class POSSimpleRetail extends getResultSet {
	JTextField docname;
	String vdoccode = null;
	private JTextField tokenno;
	private JButton btnDisc;
	private JTextField scanqty;
	private JTextField rate;
	JComboBox brand;

	private JLabel lblNewLabel_5;
	private JTextField disc;
	private JButton btnNewdoctor;
	JTextField editdisc;
	JComboBox size;
	JComboBox color;
	JComboBox pattern;

	String vdrugType;
	JTextField patientName;
	//

	public static String invoiceMode = "I";
	String VAccountPostingAmount;
	private Connection con1, con2, con3, con4, con5, con6, con7, con8;
	private String POS = "1";
	private String scannerAvailable = "N";
	private JButton btnDoctor;
	private JButton btnClose;
	private String vallowPopWindow = "N";
	public java.sql.PreparedStatement prst = null;
	JButton btnSalesLike;
	JComboBox namecombo = new JComboBox();
	private String vtokenno;
	String vallowday;
	private int vmy;
	private int voth;
	int editrow;
	JLabel editname;
	JLabel editcode;
	JTextField editqty;
	JTextField editrate;
	JPanel panelDoctorInfo;

	private JButton btnImgComp;
	JFormattedTextField chngqty;
	JFormattedTextField sp;
	// JPanel choicepanel;
	JSplitPane possplit;
	JScrollPane ajsp;
	JPanel panelPriceEdit;

	private String para707;
	private int para805;
	private JTextField records;
	private JCheckBox homeDelivery;
	public static String varticle = "0";
	private JPanel resto_panel1;
	private JButton btnTable1;
	private JButton btnTable2;
	private JButton btnTable3;
	private JLabel lblTable;
	private JTextField tableno;
	private JTextField tabletype;
	private String vstore;
	private JPanel resto_panel2;
	private JLabel lblTableNo;
	private JLabel lblFloor_1;
	private JTextField floor;
	private JTextField split;
	private JPanel resto_panel3lblSearchByName;
	private JLabel lblSelectTableInformation;

	/// End Variables to check Configuration //
	JTextField quickSearch;
	String vglcode;
	private JTextField vdropsearch;
	private JComboBox comboSplit;
	private JTextField hm_Phone;
	private JTextField hm_custname;
	private JTextField hm_addr1;
	private JTextField hm_addr2;
	private JTextField scanItem_2;
	private JLabel lblSerchByName;
	private JTextField scanName22;
	private JPanel pos_hdr1;
	private JComboBox comboTable;
	private JComboBox comboTtype;
	private JComboBox comboFloor;
	private JScrollPane Pjsp_1;
	private JPanel JspPanel;
	String vverticlecode;
	JLabel lblNewLabel_9;

	//

	private JPanel resto_panel3;
	private String AutodiscArticle;

	public JCheckBox chkbox;
	// public JTextField scanItem_2;
	private Double dues;

	private JPanel pmtPanel;
	public JPanel pmt;

	/// Variables to check Configuration //

	private String Conf_SalesreturnAllow;
	private String Conf_FloatCashManagementAllow;
	private String Conf_CashreturnAllow;
	private String Conf_CreditnoteAllow;
	private String Conf_DeclarationRequired;
	private String Conf_AllowDayEndwithDiff;
	private String Conf_BillingAddQtyforArticle;

	private String DBhdr;
	private String DBdetail;
	private String DBpayment;
	private String statusCC;
	private String statusCA;
	private String statusCN;

	public String vpaymentmode;
	public Double vpaymentamount;
	private int selectedrow;
	private int taxslabrow;

	private JTextField shift;
	public String vvcompnaycode;
	public String vvsitecode;
	public int vterminal;
	JPanel panelscan;
	public boolean process = true;
	public int vvinvno;
	public String Svinvdate;
	public Date Dinvdate;
	JLabel lblDoctor;
	// public String vvcashiercode;
	public String vvsales_type = "PS";
	public String vvinvoice_type = "RI";
	public String vvposting_type = "Y";
	public Double vvggross = 0.00;
	public Double vvdisc = 0.00;
	public Double vvnet = 0.00;
	public int vvcustid = 0;
	public int vean = 0;
	public String Status = "Sucess";

	/// for Pos detail to take table data declare varicales
	public String pd_article;
	public Double pd_salesprice;
	public Double pd_mrp;
	public Double pd_gross;
	public Double pd_Hdisc;
	public Double pd_disc;
	public Double pd_netamount;
	public int pd_qty;
	public int pd_seq;
	public String vvcashiercode;
	public int vshift;
	private String vverticle;
	private String vcomp;
	private String vtableno;
	private String vsplit;
	private String vtabletype;
	private String vfloor;
	private String cfloor;
	private String ctableno;
	private String csplit;
	private String ctabletype;
	private String vbeginstatus;
	private int nrow;

	private String vmygstno;
	private String vmycompanystate;
	private String vmystatename;
	private String vmyCompanyisGST;

	private String vstate;
	private String vstatename;
	private String vregdlr;
	private String vcustGSTno;
	private String vmovtype;
	// End GST Related Fields

	///// End Variable Declaration here
	public static TextField scanItem;
	public ActionListener custls;
	public JFrame MessageFrame;
	public JButton btnname;
	public JPanel Payment_Panel;
	public JPanel Searchpanel;
	public JPanel panel_2;
	public JScrollPane Pjsp;
	public JScrollPane jsp;
	public JPasswordField vvcost;
	private JTextField vexpedtr;

	// ===========GST

	public JFormattedTextField DuePayment;

	private JTextField scanName2;
	/// Bill Search
	private String SR[] = { "Item code", "Name", "Qty", "Rate", "MRP", "Gross", "Hdr_disc", "Disc", "Tax_Amt",
			"Total_Amt", "Tax_code", "Site_code", "Invno", "Invdate" };

	private String Col[] = { "Romove", "Item", "Name", "Qty", "Rate", "MRP", "Gross", "Hdr Disc", "Disc", "Tax",
			"Amount", "Taxcode", "Batch Item", "BatchNo", "Exp.Date", "Cost", "DrugType", "Content" };

	// For Customer Search

	public DefaultTableModel Articlemodel = new DefaultTableModel();
	public JTable Articletable = new JTable();

	public DefaultTableModel smodel = new DefaultTableModel();

	public String SCol[] = { "Customer code", "Name", "Phone", "Email" };
	public JTable stable = new JTable();
	public JScrollPane sjsp = new JScrollPane();
	public JViewport prt6 = new JViewport();

	// For Item Name Search
	public DefaultTableModel nmodel = new DefaultTableModel();
	public JTable ntable = new JTable();
	public String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price" };

	public DefaultTableModel model1 = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 3 || column == 4 || column == 7 || column == 8 || column == 1 || column == 2 || column == 5
					|| column == 6 || column == 7 || column == 10 ? false : true;
		}
	};

	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) { // 0 3 4 5 7 8 13
																// 14 15
			return column == 0 || column == 3 || column == 4 || column == 8 || column == 11 || column == 13
					|| column == 14 ? true : false;
		}
	};
	// private static final DecimalFormat formatter = new DecimalFormat(
	// "#######.##" );
	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 4 || column == 8 || column == 13 || column == 14
					|| column == 11) {
				componentt.setBackground(Color.BLACK);
				componentt.setForeground(Color.WHITE);
				componentt.setCursor(getCursor());
				// componentt.setFont(new Font("Cambria", Font.PLAIN, 13));
				componentt.setFont(new Font("Cambria", Font.BOLD, 15));
			} else {
				componentt.setBackground(Color.DARK_GRAY);
				componentt.setForeground(Color.WHITE);
				componentt.setFont(new Font("Calibri", Font.ITALIC, 12));
				if (getValueAt(roww, 12).toString().equalsIgnoreCase("N")) {
					componentt.setBackground(Color.CYAN);
					componentt.setForeground(Color.BLACK);
					componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
				} else if (getValueAt(roww, 12).toString().equalsIgnoreCase("Y")) {
					componentt.setBackground(Color.DARK_GRAY);
					componentt.setFont(new Font("Calibri", Font.BOLD, 14));
					componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
				}

				if (roww == 0) {
					componentt.setBackground(Color.BLACK);
					componentt.setForeground(Color.WHITE);
					componentt.setCursor(getCursor());
					componentt.setFont(new Font("Calibri", Font.BOLD, 15));
				}
			}
			if (Language == "H") {
				if (column == 2) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}

			return componentt;
		}
	};

	public DefaultTableModel pmodel = new DefaultTableModel();
	public JTable ptable = new JTable();
	public Double famount = 0.00;
	public Double duePayment = 0.00;
	public Double paidAmount = 0.00;
	public Double fnetAmount = 0.00;
	public Double fhdrDiscount = 0.00;
	public Double froundOffAmt = 0.00;
	// public JInternalFrame internalFrame;

	public JButton Btn_TAMT;
	public JButton Btn_ArticleImage;
	public JButton Btn_PAMT;
	public JButton Btn_DAMT;
	public JButton btn_Payment;
	public JButton btn_Save;
	private JButton btnDayEnd;
	private JButton btnDayBegin;
	private JButton btnNewCustomer;
	private JButton btnCashWidrow;
	private JButton btn_Deposit;
	private JButton btnDeclaration;
	private JButton btnBillUnhold;
	private JButton btnHold;
	private JTextField hm_addr3;

	public int option;
	public JTextField froundAmt;
	public String DBaction;

	public Connection conn = null;
	public Statement pst = null;
	public int x = 10; // Start Drawing from X=10
	public JButton btn_print;
	public JFrame POSSimpleFrame;

	private JComboBox InvType;
	public String PCol[] = { "X", "Payment Mode", "Amout", "CardNumber", "CardType" };
	public Object qty;
	public JPanel HeaderPanel = new JPanel();
	public JPanel Dpanel;
	public JPanel choicepanel;
	public JPanel BtnImgPanel;
	public JInternalFrame internalFrame;
	private JTextField invno;
	private JTextField invdate;
	private JTextField Tamount;
	protected Component choicepanel1;
	public ResultSet rs;
	public JScrollPane posscan;
	protected Window frameCustomer;
	public JTextField Site_code;
	public String action;
	public int rowcnt = 0;
	public String Ret_value;
	public JTextField custid;
	public JTextField custname;
	public JTextField mobile;
	JPanel editPanel;
	// public JTextField ScanItem;
	private JTextField Final_Tamt;
	private JTextField Final_Pamt;
	private JTextField Final_Damt;
	private JTextField netAmount;
	private JTextField hdrDiscount;
	private JTextField billsearch;
	private JTextField cashiercode;
	private JTextField terminalID;
	private JButton btnINR1;
	private JButton btnINR2;
	private JButton btnINR3;
	private JButton btnINR4;
	private JButton btnINR5;
	private JButton btnINR6;
	private JButton btnINR7;
	public String compName;

	// ===== Configuration Variables Declarations which will refer to
	// getConfigurationSetting Class
	private int config_1;
	private String config_2;
	private String config_3;
	private String config_4;
	private String config_5;
	private String config_6;
	private String config_63;

	// ====== Apply Setting on ======
	public static JButton btn_SalesReturn;

	// ===================End DEclaration of Variables ==============//

	static public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POSSimpleRetail window = new POSSimpleRetail();
					window.POSSimpleFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public POSSimpleRetail() throws Throwable {
		// this.closeconn();
		// setStandardData();
		// getPOSconfigValues();
		initialize();
		/// this.closeconn();

	}

	private void initialize() throws Throwable {
		POSSimpleFrame = new JFrame();
		POSSimpleFrame.setResizable(false);
		POSSimpleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		POSSimpleFrame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
		POSSimpleFrame.getContentPane().setBackground(Color.CYAN);
		POSSimpleFrame.getContentPane().setLayout(null);
		POSSimpleFrame.setTitle("Business Application - Stand Alone Store Edition");
		POSSimpleFrame.setOpacity(1.0f);
		POSSimpleFrame.setBackground(Color.DARK_GRAY);
		POSSimpleFrame.setAlwaysOnTop(true);
		POSSimpleFrame.setBounds(1, 0, 1356, 772);
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(new MatteBorder(2, 2, 2, 3, (Color) new Color(0, 0, 0)));
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(1, 0, 1400, 800);
		POSSimpleFrame.getContentPane().add(desktopPane);

		internalFrame = new JInternalFrame("POS Sales Module");
		internalFrame.setSelected(true);
		desktopPane.setLayer(internalFrame, 0);
		internalFrame.getContentPane().setEnabled(true);
		internalFrame.getContentPane().setBackground(Color.CYAN);
		internalFrame.getContentPane().setForeground(Color.CYAN);
		internalFrame.setBorder(new EmptyBorder(1, 0, 2, 1));
		internalFrame.setBounds(0, 0, 1346, 750);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel HeaderPanel = new JPanel();
		HeaderPanel.setBounds(0, 0, 1350, 136);
		HeaderPanel.setBackground(new Color(153, 255, 255));
		HeaderPanel.setBorder(new LineBorder(new Color(0, 0, 153), 1, true));
		internalFrame.getContentPane().add(HeaderPanel);
		HeaderPanel.setLayout(null);
		String vsalesType = "Sales_Type";

		String vverticle = new gnHierarchy().getVerticleCode();
		String SQL11 = " call   master_getmasterData('" + vsalesType + "' , " + vverticle + ")";
		/*
		 * JLabel lblinvType = new JLabel("Invoice Type");
		 * lblinvType.setFont(new Font("SansSerif", Font.PLAIN, 15));
		 * lblinvType.setBounds(100, 106, 84, 16); Hpanel_2.add(lblinvType);
		 * 
		 * InvType = new JComboBox<String>(); InvType.setMaximumRowCount(8);
		 * InvType.setBackground(Color.CYAN); InvType.setBounds(196, 104, 116,
		 * 22); Hpanel_2.add(InvType); String SQL121= "call getAllInvoiceType()"
		 * ; new gnComp().fillCombo(SQL121, InvType);
		 */
		ActionListener custname1 = new lsnrCustName();
		/*
		 * new General().setNumerOnlyforJtext(custid); ActionListener lscust =
		 * new custls(); custid.addActionListener(lscust);
		 * custid.addKeyListener(new KeyAdapter() { public void
		 * keyReleased(KeyEvent e) { int keycode = e.getKeyCode(); //
		 * System.out.println(keycode); if (keycode == 117) { Cust_Search window
		 * = new Cust_Search(); window.frameCustomer.setVisible(true);
		 * frameCustomer.setAlwaysOnTop(true); } } });
		 */
		/// Add Here //

		// Add Here//
		ActionListener hld = new holdLsnr();
		// btnHold.addActionListener(hld);
		// panel_5.add(btnHold);
		ActionListener ls777 = new lsSearch();

		/*
		 * scanItem_2.addKeyListener(new KeyAd539er() { public void
		 * keyReleased(KeyEvent e) { int keycode = e.getKeyCode(); if (keycode
		 * == 117) { Article_Search window = new Article_Search();
		 * window.ArticleSearchFrame.setVisible(true); } }
		 * 
		 * });
		 */

		// ====>here kale

		// === customer ===
		ActionListener ls = new ls();

		Dpanel = new JPanel();
		Dpanel.setBounds(1, 1, 1350, 532);
		Dpanel.setBackground(Color.WHITE);
		Dpanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// internalFrame.getContentPane().add(Dpanel);
		Dpanel.setLayout(null);

		choicepanel = new JPanel();
		choicepanel.setBounds(0, 1, 400, 542);
		choicepanel.setBackground(Color.WHITE);
		choicepanel.setBorder(new TitledBorder(new LineBorder(new Color(102, 255, 255), 5, true), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		choicepanel.setLayout(null);

		possplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, choicepanel, Dpanel);
		possplit.setOneTouchExpandable(true);
		possplit.setVisible(true);
		possplit.setBounds(1, 165, 1344, 348);
		possplit.setAutoscrolls(true);
		possplit.setDividerLocation(450);
		internalFrame.getContentPane().add(possplit);

		ajsp = new JScrollPane();
		ajsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ajsp.setBounds(0, 74, 1100, 268);
		ajsp.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.cyan));
		quickSearch = new JTextField("");
		quickSearch.setForeground(Color.WHITE);
		quickSearch.setBackground(Color.BLACK);
		quickSearch.setToolTipText("Enter Item Search Name Here and Press Enter");
		quickSearch.setBounds(0, 45, 164, 30);
		choicepanel.add(quickSearch);
		choicepanel.add(ajsp);

		lblNewLabel_7 = new JLabel("Search By Name");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setForeground(new Color(0, 0, 51));
		lblNewLabel_7.setBounds(0, 27, 134, 16);
		choicepanel.add(lblNewLabel_7);

		size = new JComboBox();
		size.setModel(new DefaultComboBoxModel(new String[] { "0" }));
		size.setBounds(279, 47, 62, 28);
		choicepanel.add(size);

		color = new JComboBox();
		color.setModel(new DefaultComboBoxModel(new String[] { "0" }));
		color.setBounds(342, 47, 92, 28);
		choicepanel.add(color);

		pattern = new JComboBox();
		pattern.setBounds(446, 47, 56, 28);
		choicepanel.add(pattern);

		JLabel lblsize = new JLabel("Size");
		lblsize.setBounds(285, 27, 56, 16);
		choicepanel.add(lblsize);

		JLabel lblNewLabel_8 = new JLabel("Color");
		lblNewLabel_8.setBounds(342, 27, 56, 16);
		choicepanel.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("Pattern");
		lblNewLabel_9.setBounds(456, 27, 56, 16);
		choicepanel.add(lblNewLabel_9);

		brand = new JComboBox();
		brand.setModel(new DefaultComboBoxModel(new String[] { "0" }));
		brand.setBounds(164, 47, 115, 27);
		choicepanel.add(brand);

		JLabel lblNewLabel_17 = new JLabel("Brand");
		lblNewLabel_17.setBounds(173, 27, 55, 16);
		choicepanel.add(lblNewLabel_17);
		ActionListener lsprint = new ls();
		ActionListener lspayment = new ls();
		ActionListener l2 = new ls();
		ActionListener SR = new ls();
		ActionListener bunhld = new UnholdLsnr();
		ActionListener lklk = new ls();
		ActionListener lklk1 = new ls();
		ActionListener lsdecl = new ls();
		ActionListener lssave1 = new lsSave();
		ActionListener lsnew = new ls();

		internalFrame.setVisible(true);
		pmodel.setColumnIdentifiers(PCol);

		// internalFrame.getContentPane().add(new pMenu().pmenu(Dpanel));
		String imgName = "1000";

		if (config_6 == "N") {
			// hdrDiscount.setEnabled(false) ;
		}

		JspPanel = new JPanel();
		JspPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JspPanel.setBounds(0, 6, 1224, 513);
		JspPanel.setLayout(null);
		// Dpanel.add(JspPanel);

		jsp = new JScrollPane();
		jsp.setBounds(0, 0, 1224, 536);
		jsp.setBorder(BorderFactory.createBevelBorder(10, Color.BLUE, Color.DARK_GRAY));
		jsp.setBackground(Color.WHITE);

		// JspPanel.add(jsp);

		jsp.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		// JViewport prt = new JViewport();
		// prt.setBackingStoreEnabled(true);
		// prt.setForeground(Color.RED);
		// prt.setBackground(new Color(51, 255, 255));
		// prt.add(table, Col);
		// prt.setBackground(Color.WHITE);
		// prt.setVisible(true);
		// jsp.setViewport(prt);

		sjsp.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.cyan));
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(0, 100, 1400, 200);
		// JspPanel.add(sjsp); // Un Comment if wants show on Frame this is used
		// in dialog to show auto

		resto_panel1 = new JPanel();
		resto_panel1.setBorder(new LineBorder(new Color(51, 0, 51), 3, true));
		resto_panel1.setBackground(new Color(51, 255, 255));
		resto_panel1.setBounds(0, 372, 1225, 195);

		resto_panel3 = new JPanel();
		resto_panel3.setBounds(386, 0, 224, 123);
		resto_panel3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(204, 255, 255), null));
		resto_panel3.setLayout(null);
		// HeaderPanel.add(resto_panel3);

		ActionListener tbl = new Table();
		resto_panel1.setLayout(null);
		btnTable1 = new JButton("1");
		btnTable1.setBounds(171, 13, 97, 47);
		btnTable1.setBackground(Color.WHITE);
		resto_panel1.add(btnTable1);
		btnTable1.addActionListener(tbl);

		btnTable2 = new JButton("2");
		btnTable2.setBounds(280, 13, 97, 47);
		btnTable2.setBackground(Color.WHITE);
		resto_panel1.add(btnTable2);
		btnTable2.addActionListener(tbl);

		btnTable3 = new JButton("3");
		btnTable3.setBounds(394, 13, 97, 47);
		btnTable3.setBackground(Color.WHITE);
		resto_panel1.add(btnTable3);

		resto_panel2 = new JPanel();
		resto_panel2.setBounds(0, 0, 161, 195);
		resto_panel2.setBorder(new LineBorder(new Color(51, 153, 255), 5, true));
		resto_panel2.setBackground(new Color(0, 51, 153));
		resto_panel1.add(resto_panel2);
		resto_panel2.setLayout(null);

		lblTableNo = new JLabel("Table No");
		lblTableNo.setForeground(Color.WHITE);
		lblTableNo.setBounds(17, 76, 56, 16);
		resto_panel2.add(lblTableNo);

		comboTable = new JComboBox();
		comboTable
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		comboTable.setBackground(Color.WHITE);
		comboTable.setBounds(17, 95, 82, 22);
		ActionListener cmbtbl = new CombTbl();
		comboTable.addActionListener(cmbtbl);
		resto_panel2.add(comboTable);

		JLabel lblFloor = new JLabel("Floor");
		lblFloor.setForeground(Color.WHITE);
		lblFloor.setBounds(24, 24, 34, 16);
		resto_panel2.add(lblFloor);

		JLabel lblTableType = new JLabel("Table Type");
		lblTableType.setForeground(Color.WHITE);
		lblTableType.setBounds(71, 24, 64, 16);
		resto_panel2.add(lblTableType);

		comboFloor = new JComboBox();
		comboFloor.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		comboFloor.setBackground(Color.WHITE);
		comboFloor.setBounds(17, 41, 43, 22);
		resto_panel2.add(comboFloor);
		// comboFloor.addActionListener(cmbtbl);

		comboTtype = new JComboBox();
		comboTtype.setModel(new DefaultComboBoxModel(new String[] { "Non AC", "AC" }));
		comboTtype.setBackground(Color.WHITE);
		comboTtype.setBounds(67, 41, 82, 22);
		// comboTtype.addActionListener(cmbtbl);
		resto_panel2.add(comboTtype);

		JLabel lblSplitTable = new JLabel("Split Table");
		lblSplitTable.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblSplitTable.setForeground(Color.WHITE);
		lblSplitTable.setBounds(85, 76, 64, 16);
		resto_panel2.add(lblSplitTable);

		comboSplit = new JComboBox();
		comboSplit.setModel(new DefaultComboBoxModel(new String[] { "0", "A", "B", "C", "D" }));
		comboSplit.setBounds(106, 95, 43, 22);
		comboSplit.addActionListener(cmbtbl);

		resto_panel2.add(comboSplit);

		lblSelectTableInformation = new JLabel("Select Table  Information");
		lblSelectTableInformation.setFont(new Font("Verdana", Font.ITALIC, 11));
		lblSelectTableInformation.setForeground(new Color(51, 255, 204));
		lblSelectTableInformation.setBounds(12, 2, 149, 16);
		resto_panel2.add(lblSelectTableInformation);

		JButton Table4 = new JButton("4");
		Table4.setBounds(171, 73, 97, 47);
		resto_panel1.add(Table4);

		JButton Table5 = new JButton("5");
		Table5.setBounds(280, 73, 97, 47);
		resto_panel1.add(Table5);

		JButton Table6 = new JButton("6");
		Table6.setBounds(394, 73, 97, 47);
		resto_panel1.add(Table6);

		JButton Table7 = new JButton("7");
		Table7.setBounds(171, 133, 97, 47);
		resto_panel1.add(Table7);

		JButton Table8 = new JButton("8");
		Table8.setBounds(280, 133, 97, 47);
		resto_panel1.add(Table8);

		JButton Table9 = new JButton("9");
		Table9.setBounds(397, 133, 97, 47);
		resto_panel1.add(Table9);
		btnTable3.addActionListener(tbl);

		ActionListener ls111 = new lshdr();

		table.setBackground(Color.white);
		table.setRowSelectionAllowed(true);
		table.setCellSelectionEnabled(false);
		ActionListener lsnrname = new lsnritemName();
		ActionListener ls720 = new lsSearch();

		//
		panelPriceEdit = new JPanel();
		panelPriceEdit.setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.GREEN, null, null));
		panelPriceEdit.setBounds(11, 519, 206, 185);
		// internalFrame.getContentPane().add(panelPriceEdit);
		panelPriceEdit.setLayout(null);

		editcode = new JLabel();
		editcode.setBounds(1, 2, 10, 10);
		editcode.setText("");
		panelPriceEdit.add(editcode);

		editname = new JLabel();
		editname.setFont(new Font("Tahoma", Font.BOLD, 11));
		editname.setBounds(12, 16, 182, 22);
		panelPriceEdit.add(editname);

		JLabel lblNewLabel_141 = new JLabel("Qty");
		lblNewLabel_141.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_141.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_141.setBounds(12, 45, 56, 16);
		panelPriceEdit.add(lblNewLabel_141);

		JLabel lblNewLabel_151 = new JLabel("Rate");
		lblNewLabel_151.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_151.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_151.setBounds(12, 68, 56, 16);
		panelPriceEdit.add(lblNewLabel_151);

		JLabel lblNewLabel_152 = new JLabel("Disc");
		lblNewLabel_152.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_152.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_152.setBounds(12, 91, 56, 16);
		panelPriceEdit.add(lblNewLabel_152);

		editqty = new JTextField();
		editqty.setBounds(80, 42, 116, 22);
		editqty.setColumns(10);
		panelPriceEdit.add(editqty);

		editrate = new JTextField();
		editrate.setBounds(80, 65, 116, 22);
		editrate.setColumns(10);
		panelPriceEdit.add(editrate);

		editdisc = new JTextField();
		editdisc.setBounds(80, 91, 116, 22);
		editdisc.setColumns(10);
		panelPriceEdit.add(editdisc);

		ActionListener editls = new editLsnr();
		editrate.addActionListener(editls);
		editqty.addActionListener(editls);
		editdisc.addActionListener(editls);

		// Dpanel.add(panelPriceEdit);
		//

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(UIManager.getColor("Slider.highlight")));
		panel.setBounds(0, 0, 1, 1);
		HeaderPanel.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1, 1);
		panel.add(panel_1);
		panel_1.setLayout(null);
		ActionListener lk999 = new lsnrBillSearch();

		// btnINR5 = new JButton("");
		// btnINR5.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\nkrs.png"));
		// btnINR5.setIcon(new
		// ImageIcon("D:\\AKN\\myProductImage\\signRs.jpg"));
		// btnINR5.setForeground(Color.WHITE);
		// btnINR5.setEnabled(false);
		// btnINR5.setBounds(281, 1, 60, 60);
		// pmtPanel.add(btnINR5);

		tabletype = new JTextField();
		tabletype.setForeground(new Color(0, 0, 153));
		tabletype.setEditable(false);
		tabletype.setBounds(122, 46, 98, 22);
		resto_panel3.add(tabletype);
		tabletype.setColumns(10);

		floor = new JTextField();
		floor.setForeground(new Color(0, 0, 153));
		floor.setEditable(false);
		floor.setBounds(43, 23, 40, 22);
		resto_panel3.add(floor);
		floor.setColumns(10);

		lblFloor_1 = new JLabel("Floor");
		lblFloor_1.setBounds(11, 25, 29, 16);
		resto_panel3.add(lblFloor_1);

		split = new JTextField();
		split.setForeground(new Color(0, 0, 153));
		split.setEditable(false);
		split.setBounds(82, 46, 40, 22);
		resto_panel3.add(split);
		split.setColumns(10);

		lblTable = new JLabel("Table");
		lblTable.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTable.setBounds(0, 47, 40, 16);
		resto_panel3.add(lblTable);

		tableno = new JTextField();
		tableno.setText("0");
		tableno.setForeground(new Color(0, 0, 204));
		tableno.setEditable(false);
		tableno.setBounds(43, 46, 40, 22);
		resto_panel3.add(tableno);
		tableno.setColumns(10);

		JButton btnTableInformation = new JButton("Table Information");
		btnTableInformation.setBounds(-2, 0, 226, 25);
		resto_panel3.add(btnTableInformation);
		btnTableInformation.setEnabled(false);
		btnTableInformation.setBackground(new Color(51, 255, 255));
		ActionListener itm = new ls();
		if (Language == "H") {
			scanName22.setFont(new Font("Shivaji02", Font.PLAIN, 16));
		}
		ActionListener hh = new lsSave();

		btnImgComp = new JButton("POS");
		btnImgComp.setBounds(0, 0, 95, 61);
		HeaderPanel.add(btnImgComp);
		btnImgComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnImgComp.setIcon(new ImageIcon(POS.class.getResource("/RetailProduct/POS1.png")));

		JLabel myImage = new JLabel(" ");
		myImage.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\Apperal5.jpg"));
		myImage.setBounds(1243, 0, 107, 61);
		HeaderPanel.add(myImage);

		JPanel btnPanel = new JPanel();
		btnPanel.setBackground(Color.WHITE);
		btnPanel.setBounds(0, 63, 1350, 31);
		HeaderPanel.add(btnPanel);
		btnPanel.setLayout(null);

		btn_Payment = new JButton("Payment");
		btn_Payment.setBounds(0, 0, 97, 27);
		btnPanel.add(btn_Payment);
		btn_Payment.setSelectedIcon(new ImageIcon(POS.class.getResource("/RetailProduct/btnPayment2.png")));
		btn_Payment.setBackground(new Color(199, 21, 133));
		btn_Payment.setForeground(new Color(0, 0, 102));
		btn_Payment.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Payment.setMnemonic('P');
		btn_Payment.setFont(new Font("Calibri", Font.BOLD, 12));
		btn_Save = new JButton("Save");
		btn_Save.setBounds(99, 0, 78, 27);
		btnPanel.add(btn_Save);
		btn_Save.setSelectedIcon(new ImageIcon(POS.class.getResource("/RetailProduct/btnSave1.png")));
		btn_Save.setIcon(null);
		btn_Save.setBackground(new Color(0, 0, 102));
		btn_Save.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Save.setForeground(new Color(0, 0, 102));
		btn_Save.setMnemonic('S');
		btn_Save.setFont(new Font("Calibri", Font.BOLD, 12));
		// internalFrame.getContentPane().add(choicepanel);

		btn_print = new JButton("Print");
		btn_print.setBounds(178, 0, 61, 27);
		btnPanel.add(btn_print);
		btn_print.setIcon(null);
		btn_print.setSelectedIcon(new ImageIcon(POS.class.getResource("/RetailProduct/btnPrint2.png")));
		btn_print.setHorizontalAlignment(SwingConstants.LEFT);
		btn_print.setBackground(new Color(0, 255, 255));
		btn_print.setForeground(new Color(0, 0, 102));
		btn_print.setMnemonic('T');
		btn_print.setFont(new Font("Calibri", Font.BOLD, 12));

		btnNewCustomer = new JButton("Customer");
		btnNewCustomer.setBounds(241, 0, 89, 27);
		btnPanel.add(btnNewCustomer);
		btnNewCustomer.setMnemonic('U');
		btnNewCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewCustomer.setFont(new Font("Calibri", Font.BOLD, 12));
		btnNewCustomer.setForeground(new Color(0, 0, 102));

		btnHold = new JButton("Bill Hold");
		btnHold.setBounds(328, 0, 89, 27);
		btnPanel.add(btnHold);
		btnHold.setHorizontalAlignment(SwingConstants.LEFT);
		btnHold.setForeground(new Color(0, 0, 102));
		btnHold.setFont(new Font("Calibri", Font.BOLD, 12));
		btnHold.setMnemonic('H');

		btnBillUnhold = new JButton("Bill UnHold");
		btnBillUnhold.setForeground(new Color(0, 0, 102));
		btnBillUnhold.setBounds(422, 0, 107, 27);
		btnPanel.add(btnBillUnhold);
		btnBillUnhold.setFont(new Font("Calibri", Font.BOLD, 12));
		btnBillUnhold.setHorizontalAlignment(SwingConstants.LEFT);

		btnDayBegin = new JButton("Edit-Sales");
		btnDayBegin.setBounds(530, 0, 107, 27);
		btnPanel.add(btnDayBegin);
		btnDayBegin.setMnemonic('B');
		btnDayBegin.setFont(new Font("Calibri", Font.BOLD, 12));
		btnDayBegin.setHorizontalAlignment(SwingConstants.LEFT);
		btnDayBegin.setForeground(new Color(0, 0, 102));

		btn_Deposit = new JButton("Cash Deposit");
		btn_Deposit.setBounds(628, 0, 118, 27);
		btnPanel.add(btn_Deposit);
		btn_Deposit.setFont(new Font("Calibri", Font.BOLD, 12));
		btn_Deposit.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Deposit.setForeground(new Color(0, 0, 102));

		btnDeclaration = new JButton("Declare Cash");
		btnDeclaration.setBounds(744, 0, 118, 27);
		btnPanel.add(btnDeclaration);
		btnDeclaration.setFont(new Font("Calibri", Font.BOLD, 12));
		btnDeclaration.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeclaration.setForeground(new Color(0, 0, 102));

		btnCashWidrow = new JButton("Cash Withdraw");
		btnCashWidrow.setBounds(930, 0, 118, 27);
		btnPanel.add(btnCashWidrow);
		btnCashWidrow.setFont(new Font("Calibri", Font.BOLD, 12));
		btnCashWidrow.setHorizontalAlignment(SwingConstants.LEFT);
		btnCashWidrow.setForeground(new Color(0, 0, 102));

		btn_SalesReturn = new JButton("Sales Return");
		btn_SalesReturn.setBounds(1046, 0, 118, 27);
		btnPanel.add(btn_SalesReturn);
		btn_SalesReturn.setMnemonic('R');
		btn_SalesReturn.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SalesReturn.addActionListener(SR);
		btn_SalesReturn.setForeground(new Color(0, 0, 102));
		btn_SalesReturn.setFont(new Font("Calibri", Font.BOLD, 12));

		btnDayEnd = new JButton("Day End");
		btnDayEnd.setBounds(1163, 0, 90, 27);
		btnPanel.add(btnDayEnd);
		btnDayEnd.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnCloseDay2.png"));
		btnDayEnd.setMnemonic('E');
		btnDayEnd.setFont(new Font("Calibri", Font.BOLD, 12));
		btnDayEnd.setHorizontalAlignment(SwingConstants.LEFT);
		btnDayEnd.setForeground(new Color(0, 0, 102));

		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Calibri", Font.BOLD, 12));
		btnClose.setForeground(new Color(0, 0, 102));
		btnClose.setBounds(1260, 0, 78, 27);
		btnPanel.add(btnClose);
		btnClose.setMnemonic('C');

		NPanel1 = new JPanel();
		NPanel1.setBackground(Color.BLACK);
		NPanel1.setBounds(0, 94, 1350, 38);
		HeaderPanel.add(NPanel1);
		NPanel1.setLayout(null);

		Site_code = new JTextField();
		Site_code.setBounds(107, 0, 0, 25);
		NPanel1.add(Site_code);
		Site_code.setForeground(new Color(0, 0, 102));
		Site_code.setBackground(Color.WHITE);
		Site_code.setFont(new Font("Calibri", Font.BOLD, 15));
		Site_code.setEditable(false);
		Site_code.setColumns(10);

		JLabel lblInvoiceDate = new JLabel("Invoice Date");
		lblInvoiceDate.setBounds(6, 12, 94, 16);
		NPanel1.add(lblInvoiceDate);
		lblInvoiceDate.setForeground(Color.DARK_GRAY);
		lblInvoiceDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInvoiceDate.setFont(new Font("Calibri", Font.BOLD, 13));

		invdate = new JTextField();
		invdate.setBounds(101, 8, 73, 25);
		NPanel1.add(invdate);
		invdate.setForeground(new Color(0, 0, 102));
		invdate.setBackground(Color.WHITE);
		invdate.setEditable(false);
		invdate.setFont(new Font("Calibri", Font.BOLD, 15));
		invdate.setColumns(10);

		JLabel lblInvoiceNumber = new JLabel("Invoice Number");
		lblInvoiceNumber.setBounds(152, 11, 119, 16);
		NPanel1.add(lblInvoiceNumber);
		lblInvoiceNumber.setForeground(Color.DARK_GRAY);
		lblInvoiceNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInvoiceNumber.setFont(new Font("Calibri", Font.BOLD, 13));

		invno = new JTextField();
		invno.setBounds(270, 8, 85, 25);
		NPanel1.add(invno);
		invno.setForeground(new Color(0, 0, 102));
		invno.setBackground(Color.WHITE);
		invno.setEditable(false);
		invno.setFont(new Font("Calibri", Font.BOLD, 15));
		invno.setColumns(10);

		JLabel lblCustId = new JLabel("Cust ID");
		lblCustId.setBounds(967, 12, 48, 16);
		NPanel1.add(lblCustId);
		lblCustId.setForeground(Color.DARK_GRAY);
		lblCustId.setFont(new Font("Calibri", Font.BOLD, 15));

		custid = new JTextField();
		custid.setBounds(1013, 6, 33, 27);
		NPanel1.add(custid);
		custid.setForeground(new Color(0, 51, 102));
		custid.setBackground(Color.WHITE);
		custid.setText("0");
		custid.setFont(new Font("Calibri", Font.BOLD, 13));
		custid.setColumns(10);

		custname = new JTextField();
		custname.setBounds(1046, 6, 150, 27);
		NPanel1.add(custname);
		custname.setBackground(Color.WHITE);
		custname.setText("Default");
		custname.setFont(new Font("Calibri", Font.BOLD, 13));
		custname.setForeground(new Color(0, 51, 102));
		custname.setColumns(10);

		JLabel lblMobileNo = new JLabel("Mobile");
		lblMobileNo.setBounds(1196, 10, 52, 16);
		NPanel1.add(lblMobileNo);
		lblMobileNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobileNo.setForeground(Color.DARK_GRAY);
		lblMobileNo.setFont(new Font("Calibri", Font.BOLD, 15));

		mobile = new JTextField();
		mobile.setBounds(1244, 6, 94, 27);
		NPanel1.add(mobile);
		mobile.setBackground(Color.WHITE);
		mobile.setEditable(false);
		mobile.setFont(new Font("Calibri", Font.BOLD, 13));
		mobile.setForeground(Color.WHITE);
		mobile.setColumns(10);

		panelDoctorInfo = new JPanel();
		panelDoctorInfo.setBounds(533, 2, 390, 31);
		NPanel1.add(panelDoctorInfo);
		panelDoctorInfo.setBackground(Color.WHITE);
		panelDoctorInfo.setBackground(new Color(102, 0, 102));
		panelDoctorInfo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelDoctorInfo.setVisible(false);
		panelDoctorInfo.setLayout(null);

		//
		JLabel lbldocname = new JLabel("Doc.Name");
		lbldocname.setBounds(-46, 2, 111, 16);
		lbldocname.setBackground(new Color(102, 102, 102));
		lbldocname.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldocname.setFont(new Font("Cambria", Font.PLAIN, 12));
		panelDoctorInfo.add(lbldocname);
		lbldocname.setForeground(Color.WHITE);

		docname = new JTextField();
		docname.setBounds(63, 0, 96, 24);
		docname.setEditable(true);
		docname.setText("");
		panelDoctorInfo.add(docname);
		docname.setBackground(new Color(240, 255, 255));
		docname.setFont(new Font("Cambria", Font.PLAIN, 13));
		docname.setColumns(10);

		JLabel PatName = new JLabel("Patient Name");
		PatName.setBounds(171, 5, 75, 16);
		PatName.setForeground(Color.WHITE);
		PatName.setHorizontalAlignment(SwingConstants.LEFT);
		PatName.setFont(new Font("Cambria", Font.PLAIN, 12));
		panelDoctorInfo.add(PatName);

		patientName = new JTextField();
		patientName.setBounds(250, 2, 111, 23);
		// patientName.setForeground(new Color(153, 255, 153));
		patientName.setBackground(new Color(240, 255, 255));
		patientName.setFont(new Font("Cambria", Font.PLAIN, 13));
		patientName.setText(" ");
		panelDoctorInfo.add(patientName);

		lblDoctor = new JLabel(" ");
		lblDoctor.setForeground(Color.WHITE);
		lblDoctor.setBounds(31, 85, 75, 38);
		panelDoctorInfo.add(lblDoctor);

		btnNewdoctor = new JButton("New Doctor");
		btnNewdoctor.setBounds(363, -2, 27, 33);
		panelDoctorInfo.add(btnNewdoctor);

		lblNewLabel_6 = new JLabel(" ");
		lblNewLabel_6.setIcon(new ImageIcon(POSSimpleRetail.class.getResource("/RetailProduct/Ph15.png")));
		lblNewLabel_6.setBounds(-11, 0, 1361, 38);
		NPanel1.add(lblNewLabel_6);
		btnNewdoctor.addActionListener(lssave1);

		lblNewLabel_10 = new JLabel("Meretoo POS - Retail Business Solution");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(147, 13, 1073, 38);
		HeaderPanel.add(lblNewLabel_10);

		lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setIcon(new ImageIcon(POSSimpleRetail.class.getResource("/RetailProduct/back1.png")));
		lblNewLabel_11.setBounds(93, 0, 1149, 61);
		HeaderPanel.add(lblNewLabel_11);
		custname.addActionListener(custname1);
		btnClose.addActionListener(l2);
		btnClose.addActionListener(lssave1);
		btnDayEnd.addActionListener(lspayment);
		btnCashWidrow.addActionListener(lklk);
		btnDeclaration.addActionListener(lsdecl);
		btn_Deposit.addActionListener(lklk1);

		btnDayBegin.addActionListener(lssave1);
		btnBillUnhold.addActionListener(bunhld);
		btnHold.addActionListener(hld);

		btnNewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerMaster window;
				try {
					window = new CustomerMaster();
					window.CustomerFrame.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btn_print.addActionListener(lsprint);
		btn_Save.addActionListener(lssave1);
		btn_Payment.addActionListener(lspayment);
		btn_Payment.addActionListener(l2);

		pmt = new JPanel();
		pmt.setBounds(953, 526, 397, 167);
		internalFrame.getContentPane().add(pmt);
		pmt.setBackground(Color.WHITE);
		pmt.setBackground(new Color(102, 0, 102));
		pmt.setBorder(new TitledBorder(null, "Bill Details", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		pmt.setLayout(null);

		//

		JLabel lblTotalAmount = new JLabel("Total Amount ");
		lblTotalAmount.setBackground(new Color(102, 102, 102));
		lblTotalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalAmount.setFont(new Font("Calibri", Font.BOLD, 16));
		lblTotalAmount.setBounds(80, 31, 111, 23);
		pmt.add(lblTotalAmount);
		lblTotalAmount.setForeground(Color.WHITE);

		Tamount = new JTextField();
		Tamount.setEditable(false);
		Tamount.setText("0.00");
		Tamount.setForeground(new Color(51, 255, 102));
		Tamount.setBounds(194, 22, 135, 35);
		pmt.add(Tamount);
		Tamount.setBackground(new Color(240, 255, 255));
		Tamount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Tamount.setColumns(10);

		JLabel lblHeaderLevelDiscount = new JLabel("Discout On Bill Value");
		lblHeaderLevelDiscount.setForeground(Color.WHITE);
		lblHeaderLevelDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeaderLevelDiscount.setFont(new Font("Calibri", Font.BOLD, 16));
		lblHeaderLevelDiscount.setBounds(20, 69, 171, 16);
		pmt.add(lblHeaderLevelDiscount);

		hdrDiscount = new JFormattedTextField();
		hdrDiscount.setForeground(new Color(153, 255, 153));
		hdrDiscount.setBackground(new Color(240, 255, 255));
		hdrDiscount.setFont(new Font("Tahoma", Font.BOLD, 16));
		hdrDiscount.setBounds(194, 59, 135, 35);
		hdrDiscount.setText("0");
		pmt.add(hdrDiscount);
		hdrDiscount.addActionListener(ls111);
		new General().setNumericOnly((JFormattedTextField) hdrDiscount);

		JLabel lblNetPayableAmount = new JLabel("Net Amount ");
		lblNetPayableAmount.setBackground(Color.YELLOW);
		lblNetPayableAmount.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNetPayableAmount.setForeground(Color.WHITE);
		lblNetPayableAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNetPayableAmount.setBounds(80, 127, 113, 25);
		pmt.add(lblNetPayableAmount);

		netAmount = new JFormattedTextField();
		netAmount.setText("0.00");
		netAmount.setForeground(new Color(153, 255, 153));
		netAmount.setBackground(new Color(240, 255, 255));
		netAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		netAmount.setEditable(false);
		netAmount.setBounds(194, 120, 135, 35);
		pmt.add(netAmount);

		JLabel lblRoundingOffAmount = new JLabel("Rounding Off Amount");
		lblRoundingOffAmount.setForeground(Color.WHITE);
		lblRoundingOffAmount.setFont(new Font("Calibri", Font.BOLD, 16));
		lblRoundingOffAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoundingOffAmount.setBounds(30, 99, 161, 16);
		pmt.add(lblRoundingOffAmount);

		froundAmt = new JTextField();
		froundAmt.setForeground(new Color(153, 255, 153));
		froundAmt.setBackground(new Color(240, 255, 255));
		froundAmt.setEditable(false);
		froundAmt.setBounds(194, 91, 135, 32);
		froundAmt.setText("0.00");
		pmt.add(froundAmt);

		JLabel lblNewLabel_1 = new JLabel("Rs.");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\rs.gif"));
		lblNewLabel_1.setBounds(66, 24, 17, 35);
		pmt.add(lblNewLabel_1);

		btnDisc = new JButton("Discount");
		btnDisc.setForeground(Color.WHITE);
		btnDisc.setBackground(Color.BLACK);
		btnDisc.setFont(new Font("Calibri", Font.BOLD, 13));
		btnDisc.setBounds(0, 139, 84, 28);
		pmt.add(btnDisc);

		pmtPanel = new JPanel();
		pmtPanel.setBounds(454, 519, 499, 185);
		internalFrame.getContentPane().add(pmtPanel);
		pmtPanel.setBackground(Color.WHITE);
		pmtPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.ORANGE, new Color(0, 0, 102)));
		pmtPanel.setVisible(false);
		pmtPanel.setLayout(null);

		Pjsp_1 = new JScrollPane();
		Pjsp_1.setBounds(5, 85, 397, 87);
		pmtPanel.add(Pjsp_1);
		Pjsp_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.CYAN);
		prt1.add(ptable, PCol);
		Pjsp_1.setViewport(prt1);

		JLabel lblTotalAmount_1 = new JLabel("Payable Amount");
		lblTotalAmount_1.setBounds(238, 6, 134, 20);
		lblTotalAmount_1.setHorizontalAlignment(SwingConstants.RIGHT);
		pmtPanel.add(lblTotalAmount_1);
		lblTotalAmount_1.setForeground(SystemColor.infoText);
		lblTotalAmount_1.setFont(new Font("SansSerif", Font.BOLD, 15));

		Final_Tamt = new JTextField();
		Final_Tamt.setBounds(376, 4, 116, 27);
		Final_Tamt.setEditable(false);
		Final_Tamt.setFont(new Font("Tahoma", Font.BOLD, 19));
		pmtPanel.add(Final_Tamt);
		Final_Tamt.setColumns(10);

		JLabel lblPaidAmount = new JLabel("Paid Amount");
		lblPaidAmount.setBounds(268, 29, 104, 16);
		lblPaidAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		pmtPanel.add(lblPaidAmount);
		lblPaidAmount.setFont(new Font("SansSerif", Font.BOLD, 14));

		Final_Pamt = new JTextField();
		Final_Pamt.setBounds(376, 28, 116, 25);
		Final_Pamt.setEditable(false);
		pmtPanel.add(Final_Pamt);
		Final_Pamt.setFont(new Font("Tahoma", Font.BOLD, 14));
		Final_Pamt.setColumns(10);

		JLabel lblPaymentDue = new JLabel("Due Amount");
		lblPaymentDue.setBounds(278, 51, 95, 21);
		lblPaymentDue.setHorizontalAlignment(SwingConstants.RIGHT);
		pmtPanel.add(lblPaymentDue);
		lblPaymentDue.setFont(new Font("SansSerif", Font.BOLD, 15));

		Final_Damt = new JTextField();
		Final_Damt.setBounds(376, 48, 116, 27);
		Final_Damt.setEditable(false);
		pmtPanel.add(Final_Damt);
		Final_Damt.setFont(new Font("Tahoma", Font.BOLD, 17));
		Final_Damt.setColumns(10);

		JButton btnNewButton_2 = new JButton(" ");
		btnNewButton_2.setBounds(5, -3, 43, 48);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btn_Payment.doClick();
			}
		});
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setForeground(Color.BLUE);
		pmtPanel.add(btnNewButton_2);
		btnNewButton_2.setIcon(new ImageIcon(POSSimpleRetail.class.getResource("/RetailProduct/Pay.png")));

		JLabel lblTerminalId = new JLabel("Terminal");
		lblTerminalId.setBounds(402, 98, 52, 16);
		pmtPanel.add(lblTerminalId);
		lblTerminalId.setFont(new Font("Calibri", Font.BOLD, 13));
		lblTerminalId.setForeground(Color.BLACK);

		terminalID = new JTextField();
		terminalID.setBounds(449, 92, 43, 28);
		pmtPanel.add(terminalID);
		terminalID.setBackground(new Color(255, 255, 255));
		terminalID.setForeground(new Color(51, 0, 51));
		terminalID.setEditable(false);
		terminalID.setColumns(10);

		JLabel lblNewLabel = new JLabel("Shift");
		lblNewLabel.setBounds(425, 122, 28, 16);
		pmtPanel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.BLACK);

		shift = new JTextField();
		shift.setBounds(449, 116, 43, 28);
		pmtPanel.add(shift);
		shift.setBackground(new Color(255, 255, 255));
		shift.setForeground(new Color(51, 0, 51));
		shift.setEditable(false);
		shift.setColumns(10);

		JLabel lblCashier = new JLabel("Cashier");
		lblCashier.setBounds(402, 148, 52, 16);
		pmtPanel.add(lblCashier);
		lblCashier.setHorizontalAlignment(SwingConstants.CENTER);
		lblCashier.setFont(new Font("Calibri", Font.BOLD, 13));
		lblCashier.setForeground(Color.BLACK);

		cashiercode = new JTextField();
		cashiercode.setBounds(449, 144, 45, 28);
		pmtPanel.add(cashiercode);
		cashiercode.setBackground(new Color(255, 255, 255));
		cashiercode.setForeground(new Color(51, 0, 51));
		cashiercode.setEditable(false);
		cashiercode.setColumns(10);

		lblNewLabel_12 = new JLabel("Select Payment Mode");
		lblNewLabel_12.setBounds(49, 4, 166, 16);
		pmtPanel.add(lblNewLabel_12);

		payCombo = new JComboBox();
		// payCombo.setModel(new DefaultComboBoxModel(new String[] {"Cash",
		// "CC"}));
		payCombo.setBounds(58, 24, 167, 22);
		pmtPanel.add(payCombo);

		lblNewLabel_13 = new JLabel("Amount");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_13.setBounds(5, 54, 56, 16);
		pmtPanel.add(lblNewLabel_13);

		custamountPaid = new JTextField();
		custamountPaid.setBounds(58, 51, 89, 25);
		pmtPanel.add(custamountPaid);
		custamountPaid.setColumns(10);

		pos_hdr1 = new JPanel();
		pos_hdr1.setBounds(229, 519, 228, 136);
		internalFrame.getContentPane().add(pos_hdr1);
		pos_hdr1.setBackground(Color.WHITE);
		pos_hdr1.setBackground(new Color(102, 0, 102));
		pos_hdr1.setBorder(
				new TitledBorder(null, "Home Delivery", TitledBorder.CENTER, TitledBorder.TOP, null, Color.GREEN));
		pos_hdr1.setLayout(null);

		JLabel lblDate = new JLabel("Phone");
		lblDate.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(10, 26, 56, 16);
		pos_hdr1.add(lblDate);

		hm_Phone = new JTextField();
		hm_Phone.setBackground(new Color(102, 0, 102));
		hm_Phone.setForeground(new Color(0, 0, 153));
		hm_Phone.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_Phone.setToolTipText("Enter Phone Number  Max Char Allow 10");
		hm_Phone.setBounds(51, 25, 78, 22);
		pos_hdr1.add(hm_Phone);
		hm_Phone.setColumns(10);

		hm_custname = new JTextField();
		hm_custname.setBackground(Color.WHITE);
		hm_custname.setForeground(new Color(0, 0, 51));
		hm_custname.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_custname.setToolTipText("Enter Name  Max Chars Allow is 30");
		hm_custname.setBounds(10, 48, 205, 22);
		pos_hdr1.add(hm_custname);
		hm_custname.setColumns(10);

		hm_addr1 = new JTextField();
		hm_addr1.setBackground(Color.WHITE);
		hm_addr1.setForeground(new Color(0, 0, 51));
		hm_addr1.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_addr1.setToolTipText("Enter Address  Max Chars Allow is 30");
		hm_addr1.setBounds(10, 66, 205, 22);
		pos_hdr1.add(hm_addr1);
		hm_addr1.setColumns(10);

		hm_addr2 = new JTextField();
		hm_addr2.setBackground(Color.WHITE);
		hm_addr2.setForeground(new Color(0, 0, 51));
		hm_addr2.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_addr2.setToolTipText("Enter Address  Max Chars Allow is 30");
		hm_addr2.setBounds(10, 83, 205, 22);
		pos_hdr1.add(hm_addr2);
		hm_addr2.setColumns(10);

		homeDelivery = new JCheckBox("Deliver At");
		homeDelivery.setFont(new Font("Calibri", Font.BOLD, 15));
		homeDelivery.setForeground(Color.WHITE);
		homeDelivery.setBackground(new Color(153, 255, 255));
		homeDelivery.setBounds(130, 25, 87, 18);
		pos_hdr1.add(homeDelivery);

		hm_addr3 = new JTextField();
		hm_addr3.setBackground(Color.WHITE);
		hm_addr3.setForeground(new Color(0, 0, 51));
		hm_addr3.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_addr3.setToolTipText("Enter City  Max Chars Allow is 30");
		hm_addr3.setBounds(10, 101, 205, 22);
		pos_hdr1.add(hm_addr3);
		hm_addr3.setColumns(10);
		pos_hdr1.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { homeDelivery, hm_Phone, hm_custname, hm_addr1, hm_addr2, hm_addr3, lblDate }));

		panelscan = new JPanel();
		panelscan.setBounds(0, 135, 1350, 31);
		internalFrame.getContentPane().add(panelscan);
		panelscan.setBackground(new Color(0, 0, 51));
		panelscan.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 255, 204), null));
		panelscan.setLayout(null);

		JLabel lblScanItem = new JLabel("Scan Item");
		lblScanItem.setForeground(Color.WHITE);
		lblScanItem.setFont(new Font("Cambria", Font.BOLD, 15));
		lblScanItem.setBounds(6, 7, 68, 16);
		panelscan.add(lblScanItem);

		scanItem_2 = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};

		scanItem_2.setToolTipText("Max code Length is 5 ");
		scanItem_2.setForeground(new Color(0, 0, 102));
		scanItem_2.setFont(new Font("Calibri", Font.BOLD, 17));
		scanItem_2.setBounds(72, -2, 124, 33);
		panelscan.add(scanItem_2);
		scanItem_2.setColumns(10);
		scanItem_2.addActionListener(itm);

		lblSerchByName = new JLabel("Search by name");
		lblSerchByName.setForeground(Color.WHITE);
		lblSerchByName.setFont(new Font("Cambria", Font.BOLD, 15));
		lblSerchByName.setBounds(542, 7, 124, 16);
		panelscan.add(lblSerchByName);

		scanName22 = new JTextField();
		scanName22.setBackground(Color.DARK_GRAY);
		scanName22.setFont(new Font("Calibri", Font.BOLD, 15));
		scanName22.setForeground(Color.WHITE);
		scanName22.setBounds(659, 1, 115, 30);

		panelscan.add(scanName22);
		scanName22.setColumns(10);

		scanqty = new gnRoundTextField(12);
		scanqty.setForeground(Color.GREEN);
		scanqty.setBackground(Color.DARK_GRAY);
		scanqty.setBounds(238, 1, 52, 28);
		panelscan.add(scanqty);
		scanqty.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Rate");
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(296, 7, 36, 16);
		panelscan.add(lblNewLabel_4);

		rate = new gnRoundTextField(12);
		rate.setForeground(Color.GREEN);
		rate.setBackground(Color.DARK_GRAY);
		rate.setBounds(331, 1, 75, 28);
		panelscan.add(rate);
		rate.setColumns(10);

		lblNewLabel_5 = new JLabel("Discount");
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(412, 7, 62, 16);
		panelscan.add(lblNewLabel_5);

		disc = new gnRoundTextField(12);
		disc.setForeground(Color.GREEN);
		disc.setBackground(Color.DARK_GRAY);
		disc.setBounds(475, 1, 66, 28);
		panelscan.add(disc);
		disc.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Qty");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(208, 7, 42, 16);
		panelscan.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("Issue Token");
		lblNewLabel_2.setBounds(783, 7, 72, 16);
		panelscan.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.WHITE);

		tokenno = new JTextField();
		tokenno.setBounds(855, 0, 42, 30);
		panelscan.add(tokenno);
		tokenno.setFont(new Font("Calibri", Font.BOLD, 13));
		tokenno.setForeground(Color.WHITE);
		tokenno.setBackground(Color.DARK_GRAY);
		tokenno.setColumns(10);

		JLabel lblSearchBillNo = new JLabel("View Bill");
		lblSearchBillNo.setBounds(905, 7, 65, 16);
		panelscan.add(lblSearchBillNo);
		lblSearchBillNo.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblSearchBillNo.setForeground(Color.WHITE);

		billsearch = new JTextField();
		billsearch.setForeground(Color.WHITE);
		billsearch.setBackground(Color.DARK_GRAY);
		billsearch.setBounds(964, -2, 78, 30);
		panelscan.add(billsearch);
		billsearch.setColumns(10);

		btnSalesLike = new JButton("Copy Bill");
		btnSalesLike.setBounds(1042, 0, 95, 31);
		panelscan.add(btnSalesLike);
		btnSalesLike.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalesLike.setMnemonic('L');

		btnDoctor = new JButton("Doctor & Patient Info");
		btnDoctor.setBounds(1138, 0, 115, 28);
		panelscan.add(btnDoctor);

		JLabel lblRecords_1 = new JLabel("Records");
		lblRecords_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRecords_1.setBounds(1245, 5, 56, 16);
		panelscan.add(lblRecords_1);
		lblRecords_1.setForeground(Color.WHITE);
		lblRecords_1.setFont(new Font("Arial", Font.BOLD, 12));

		records = new JTextField();
		records.setBounds(1300, 2, 38, 25);
		panelscan.add(records);
		records.setBackground(Color.WHITE);
		records.setEditable(false);
		records.setForeground(Color.DARK_GRAY);
		records.setFont(new Font("Calibri", Font.BOLD, 13));
		records.setColumns(10);
		btnDoctor.addActionListener(lssave1);
		billsearch.addActionListener(lk999);
		panelscan.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { scanItem_2, scanName22, scanqty, rate, disc }));

		editPanel = new JPanel();
		editPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.GREEN, null, null));
		editPanel.setBounds(11, 519, 209, 185);
		internalFrame.getContentPane().add(editPanel);
		editPanel.setLayout(null);
		JLabel lblNewLabel_14 = new JLabel("Qty");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_14.setBounds(12, 45, 56, 16);
		editPanel.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Rate");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_15.setBounds(12, 68, 56, 16);
		editPanel.add(lblNewLabel_15);

		ename = new JTextField();
		ename.setFont(new Font("Tahoma", Font.BOLD, 11));
		ename.setBounds(12, 16, 182, 22);
		editPanel.add(ename);
		ename.setColumns(10);

		eqty = new JTextField();
		eqty.setBounds(80, 42, 116, 22);
		editPanel.add(eqty);
		eqty.setColumns(10);

		erate = new JTextField();
		erate.setBounds(80, 65, 116, 22);
		editPanel.add(erate);
		erate.setColumns(10);

		// scanName22.addKeyListener(keyls);

		ptable.setCursor(new Cursor(Cursor.HAND_CURSOR));

		KeyListener keyls = new keyLsnr();
		quickSearch.addKeyListener(keyls);
		ActionListener billlike = new lsSave();
		ActionListener mnname = new lsnritemName();
		ActionListener hm = new hmDel_lsnr();
		ActionListener discgrp = new btndscsnr();
		ActionListener scanQty = new scanqtyLsnr();
		ActionListener scanRate = new scanrateLsnr();
		ActionListener Manuldisc = new discLsnr();
		ActionListener docls = new doctorLsnr();
		ActionListener patls = new patientLsnr();
		btnDisc.addActionListener(discgrp);
		scanqty.addActionListener(scanQty);
		rate.addActionListener(scanRate);
		disc.addActionListener(Manuldisc);
		homeDelivery.addActionListener(hm);
		scanName22.addActionListener(mnname);
		btnSalesLike.addActionListener(billlike);
		docname.addActionListener(docls);
		patientName.addActionListener(patls);

		ActionListener colrLs = new colorLsnr();
		ActionListener sizeLs = new sizeLsnr();
		ActionListener brandLs = new brandLsnr();

		color.addActionListener(colrLs);
		size.addActionListener(sizeLs);
		brand.addActionListener(brandLs);

		// nameFocusLsnr nmfocus = new nameFocusLsnr();
		// scanName22.addFocusListener(nmfocus);
		ActionListener paymentinsertls = new custamtpaidLsnr();
		custamountPaid.addActionListener(paymentinsertls);
		// decorate();
	}

	/// Start coding from Here

	class colorLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				FillArticleForAttributes();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class sizeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				FillArticleForAttributes();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class brandLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				FillArticleForAttributes();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void decorate() throws Throwable {

		this.checkInternet();
		chekcFreezeYear();
		editPanel.setVisible(false);
		pos_hdr1.setVisible(false);
		btnDoctor.setVisible(false);
		String vmsname = "";
		String SQL1 = "";
		vverticlecode = new gnHierarchy().getVerticleCode();
		switch (vverticlecode) {
		case "2":
			btnDoctor.setVisible(true);
			break;
		}

		btnDeclaration.setEnabled(false);
		btn_SalesReturn.setEnabled(false);
		vdoccode = "0";
		vallowday = new gnDate().checkDayBegin();

		switch (vallowday) {
		case "Y":
			String vvertname = this.verticlename;
			new gnApp().setCompanyTitle(internalFrame);
			new gnApp().setFrameTitel(POSSimpleFrame);
			new gnBackground().setLblBackground(lblDoctor);

			conn = this.getConnection();
			vstore = new gnConfig().getStoreID();
			vcomp = new gnConfig().getCompanyCode();
			compName = new gnConfig().getCompany();
			vvcashiercode = new gnConfig().getUserCode();

			vmsname = "PaymentMode";
			SQL1 = " call master_getMasterData('" + vmsname + "' , " + vverticlecode + ")";
			new gnComp().fillCombo(SQL1, payCombo);

			vmsname = "Brand";
			SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticlecode + ")";
			new gnComp().fillCombo(SQL1, brand);

			vmsname = "Size";
			SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticlecode + ")";
			new gnComp().fillCombo(SQL1, size);

			vmsname = "Color";
			SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticlecode + ")";
			new gnComp().fillCombo(SQL1, color);

			lblNewLabel_9.setVisible(false);
			pattern.setVisible(false);
			// vmsname = "Pattern";
			// SQL1 = "call master_getMasterData('" + vmsname + "' , " +
			// vverticlecode + ")";
			// new gnComp().fillCombo(SQL1, pattern);

			// PaymentWindow Popup Allow Config
			String vpara712 = "712";
			vallowPopWindow = new getConfigurationSetting().getSpecificConfiguration(vpara712);

			if (vcomp == "0") {
				System.exit(0);
			}

			Site_code.setText(vstore);
			invdate.setText(new gnConfig().getDaybeginDate());

			String vtype = "SALE";
			String vallowDate = new gnDate().checkBackDateTrAllow(vtype, invdate.getText());
			switch (vallowDate) {
			case "N":
				invdate.setBackground(Color.RED);
				invdate.setForeground(Color.WHITE);
				new General().msg("Back Date For Transaction is not Allow..");
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				invdate.setText("?");
				btnDayBegin.setVisible(false);
				btn_Payment.setVisible(false);
				btn_Save.setVisible(false);
				break;
			}

			scanItem_2.grabFocus();
			custid.setText("0");
			terminalID.setText(new gnConfig().getTerminalID());
			int vterminal = Integer.parseInt(terminalID.getText().toString());
			shift.setText((new gnConfig().getCashierShift(vcomp, Site_code.getText(),
					new gnConfig().date_ConverttoDBforamt(invdate.getText()), vterminal, vvcashiercode)));
			cashiercode.setText(vvcashiercode);
			btn_Save.setEnabled(false);
			new gnLogger().loggerInfoEntry("POS", "setting pos type");

			setVerticlePOS();
			new gnLogger().loggerInfoEntry("POS", "setting Configuration ...");
			setConfiguratin();

			//////

			new gnField().showCalc(internalFrame, "CAL");
			new gnField().showInventory(internalFrame, "INV");
			new gnField().showCalc(internalFrame, "CAL");

			delTableRow(table, model, "POS");
			new gnField().closeform(internalFrame, POSSimpleFrame);
			new gnField().moveDown(table);

			scanItem_2.setDocument(new gnSetinputLimit(12));
			hm_custname.setDocument(new gnSetinputLimit(30));
			hm_Phone.setDocument(new gnSetinputLimit(10));
			hm_addr1.setDocument(new gnSetinputLimit(30));
			hm_addr2.setDocument(new gnSetinputLimit(30));
			hm_addr3.setDocument(new gnSetinputLimit(30));
			new gnLogger().loggerInfoEntry("POS", "POS Screen Start by :" + this.ucode);
			new gnDecorate().DispField_Eatch(invdate, 20);
			new gnDecorate().DispField_Eatch(Site_code, 20);
			// new gnDecorate().DispField_Eatch(custname,20);
			new gnDecorate().DispField_Eatch(terminalID, 20);
			new gnDecorate().DispField_Eatch(shift, 20);
			new gnDecorate().DispField_Eatch(invdate, 20);
			new gnDecorate().DispField_Eatch(invno, 20);
			// new gnDecorate().DispField_Eatch(scanItem_2, 20);
			// new gnDecorate().DispField_Eatch(scanName22, 20);
			new gnDecorate().DispField_Eatch(tableno, 20);
			// new gnDecorate().DispField_Eatch(custid,20);
			new gnDecorate().DispField_Eatch(records, 20);
			new gnDecorate().DispField_Eatch(cashiercode, 20);

			new gnDecorate().DispField_Beval_int(Tamount, 1);
			new gnDecorate().DispField_Beval_int(netAmount, 1);
			new gnDecorate().DispField_Beval_int(hdrDiscount, 1);
			new gnDecorate().DispField_Beval_int(froundAmt, 1);

			new gnDecorate().setTextFieldBackgroud1(netAmount);
			new gnDecorate().setTextFieldBackgroud(netAmount);
			new gnDecorate().setTextFieldBackgroud1(hdrDiscount);
			new gnDecorate().setTextFieldBackgroud1(froundAmt);

			new gnDecorate().DispField_Beval_int(Final_Tamt, 1);
			new gnDecorate().DispField_Beval_int(Final_Damt, 1);
			new gnDecorate().DispField_Beval_int(Final_Pamt, 1);
			new gnDecorate().setTextFieldBackgroud(Final_Tamt);
			new gnDecorate().setTextFieldBackgroud1(Final_Pamt);
			new gnDecorate().setTextFieldBackgroud(Final_Damt);
			Final_Damt.setForeground(Color.WHITE);

			new gnDecorate().setTextFieldBackgroud1(Tamount);
			new gnDecorate().DispField_Eatch(hm_Phone, 20);
			new gnDecorate().DispField_Eatch(hm_custname, 20);
			new gnDecorate().DispField_Eatch(hm_addr1, 20);
			new gnDecorate().DispField_Eatch(hm_addr2, 20);
			new gnDecorate().DispField_Eatch(hm_addr3, 20);
			// btnDisc.setVisible(true);
			btn_Payment.setBackground(new Color(199, 21, 133));
			btn_Payment.setForeground(new Color(204, 255, 153));
			btn_print.setBackground(new Color(199, 21, 133));
			btn_print.setForeground(new Color(204, 255, 153));

			new gnDecorate().decorateBtn(btn_Save, new Color(130, 210, 112), Color.white);
			new gnStyleButtonSqr().getStyleButton(btn_Save, new Color(130, 210, 112), Color.WHITE);

			new gnDecorate().decorateBtn(btn_print, new Color(130, 210, 112), Color.WHITE);
			new gnStyleButtonSqr().getStyleButton(btn_print, new Color(130, 210, 112), Color.WHITE);

			new gnDecorate().decorateBtn(btn_Payment, new Color(130, 210, 112), Color.white);
			new gnStyleButtonSqr().getStyleButton(btn_Payment, new Color(130, 210, 112), Color.WHITE);

			new gnDecorate().decorateBtn(btnDayBegin, new Color(120, 151, 112), Color.GREEN);
			new gnStyleButtonSqr().getStyleButton(btnDayBegin, new Color(130, 210, 112), Color.WHITE);

			new gnDecorate().decorateBtn(btnDayEnd, new Color(120, 151, 112), Color.GREEN);
			new gnStyleButtonSqr().getStyleButton(btnDayEnd, new Color(130, 210, 112), Color.WHITE);

			new gnDecorate().decorateBtn(btnNewCustomer, new Color(120, 151, 112), Color.GREEN);
			new gnStyleButtonSqr().getStyleButton(btnNewCustomer, new Color(130, 210, 112), Color.WHITE);

			new gnDecorate().decorateBtn(btn_SalesReturn, new Color(120, 151, 112), Color.GREEN);
			new gnStyleButtonSqr().getStyleButton(btn_SalesReturn, new Color(130, 210, 112), Color.WHITE);

			new gnDecorate().decorateBtn(btnCashWidrow, new Color(120, 151, 112), Color.GREEN);

			new gnStyleButtonSqr().getStyleButton(btnCashWidrow, new Color(130, 210, 112), Color.WHITE);
			new gnDecorate().decorateBtn(btn_Deposit, new Color(120, 151, 112), Color.GREEN);
			new gnStyleButtonSqr().getStyleButton(btn_Deposit, new Color(130, 210, 112), Color.WHITE);
			new gnDecorate().decorateBtn(btnDeclaration, new Color(120, 151, 112), Color.GREEN);
			new gnStyleButtonSqr().getStyleButton(btnDeclaration, new Color(130, 210, 112), Color.WHITE);
			new gnDecorate().decorateBtn(btnHold, new Color(120, 151, 112), Color.GREEN);
			new gnStyleButtonSqr().getStyleButton(btnHold, new Color(130, 210, 112), Color.WHITE);
			new gnDecorate().decorateBtn(btnBillUnhold, new Color(120, 151, 112), Color.GREEN);
			new gnStyleButtonSqr().getStyleButton(btnBillUnhold, new Color(130, 210, 112), Color.WHITE);
			new gnDecorate().decorateBtn(btnClose, new Color(120, 151, 112), Color.GREEN);
			new gnStyleButtonSqr().getStyleButton(btnClose, new Color(130, 210, 112), Color.WHITE);
			new gnStyleButtonSqr().getStyleButton(btnClose, new Color(178, 11, 112), Color.WHITE);
			// new gnDecorate().setButtonColor11(btnDisc);
			new gnDecorate().decorateBtn(btnDoctor, Color.BLUE, Color.WHITE);

			btn_Save.setBackground(Color.magenta);
			btn_Save.setForeground(Color.WHITE);
			btn_Payment.setBackground(Color.magenta);
			btn_Payment.setForeground(Color.WHITE);
			hm_Phone.setEditable(false);
			hm_custname.setEditable(false);
			hm_addr1.setEditable(false);
			hm_addr2.setEditable(false);
			hm_addr3.setEditable(false);
			break;
		case "N":
			POSSimpleFrame.dispose();
			break;
		}
	}

	class custamtpaidLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				addPaymentWithNewLogic();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void chekcFreezeYear() {
		switch (isFinyearFreeze) {
		case "Y":
			btnDayBegin.setVisible(false);
			btn_Save.setVisible(false);
			btn_Payment.setVisible(false);
			new General().msg("Accounting Year is Freezeed..You Can View Data Only..");
			break;
		}
	}

	public void setStandardData() throws Throwable {
		conn = this.getConnection();
		vstore = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		compName = new gnConfig().getCompany();
		vvcashiercode = new gnConfig().getUserCode();
		if (vcomp == "0") {
			System.exit(0);
		}
		String vallow = new gnDate().checkDayBegin();
		switch (vallow) {
		case "N":
			System.exit(0);
			break;
		case "Y":
			vbeginstatus = "Sucess";
			setData();
			break;
		}
		// FillArticle() ;
	}

	public void setData() throws Throwable {
		if (vstore != "0") {
			String vdstatus = invdate.getText();
			switch (vdstatus) {
			case "1":
				new General().msg("Complete Day Begin First...");
				System.exit(0);
				break;
			}
			Site_code.setText(vstore);
			invdate.setText(new gnConfig().getDaybeginDate());
			scanItem_2.grabFocus();
			custid.setText("0");
			terminalID.setText(new gnConfig().getTerminalID());
			int vterminal = Integer.parseInt(terminalID.getText().toString());
			shift.setText((new gnConfig().getCashierShift(vcomp, Site_code.getText(),
					new gnConfig().date_ConverttoDBforamt(invdate.getText()), vterminal, vvcashiercode)));
			cashiercode.setText(vvcashiercode);
			btn_Save.setEnabled(false);
			new gnLogger().loggerInfoEntry("POS", "Setting POS Type");
			setVerticlePOS();
			new gnLogger().loggerInfoEntry("POS", "Setting Configuration Types");
			setConfiguratin();
		}
	}

	// lsnritemName

	class doctorLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String vstring = docname.getText();
			vstring = "%" + vstring + "%";
			try {
				new gnDoctor().getDocname(vstring);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				docname.setText(new gnDoctor().vvdocname);
				vdoccode = new gnDoctor().vvdoccode;
			}
		}
	}

	class patientLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			panelDoctorInfo.setVisible(false);
			pmt.setVisible(true);
			scanItem_2.grabFocus();
		}
	}

	class discLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String value = disc.getText();
			table.setValueAt(value, 0, 8);
			value = (String) table.getValueAt(0, 1);
			try {
				QtychangeImapct(value, 0);
				scanqty.setText("");
				rate.setText("");
				disc.setText("");
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
			} catch (Throwable e) {
			}
		}
	}

	class scanrateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String value = rate.getText();
			table.setValueAt(value, 0, 4);
			value = (String) table.getValueAt(0, 1);
			try {
				QtychangeImapct(value, 0);
				scanqty.setText("");
				rate.setText("");
			} catch (Throwable e) {
			}
		}
	}

	public void delTableRow(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg("Comp is "+ fld +" "+"Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "CalAction");
		// imap.put(KeyStroke.getKeyStroke("VK_X"), "CalAction");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					int row = table.getSelectedRow();
					model.removeRow(row);
					removeRow(model, table);
					table.setEditingRow(row);
					Double v = new gnTable().getTotal(table, 10);
					Tamount.setText(Double.toString(v));
					int vcount = table.getRowCount();
					records.setText(Integer.toString(vcount));
					calHdrDisocunt();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	class lsnritemName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String sname = scanName22.getText().trim();
			sname = "%" + sname + "%";
			String vType = "Article";
			String vtrantype = "POS";
			try {
				if (varticle != null && varticle.length() > 0) {
					new gnAdmin().Search(vType, sname, varticle, vtrantype);
					// new gnAdmin().articleNameSearch( sname, scanItem_2
					// ,scanName22 ) ;
				}
			} catch (ClassNotFoundException | SQLException e1) {
				new General().msg(e1.getLocalizedMessage());
				e1.printStackTrace();
				try {
				} catch (Throwable e2) {
					e2.printStackTrace();
				}
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				try {
					// setSearchArticle() ;
					varticle = new gnAdmin().rArticle;
					if (varticle != "0") {
						showTableData(varticle, model);
						new gnAdmin().rArticle = "0";
						scanName22.setText("");
						scanItem_2.grabFocus();
					}
					varticle = "0";
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void setSearchArticle() throws Throwable {
		varticle = scanItem_2.getText();
		new General().msg(varticle);
		if (varticle != "0") {
			showTableData(varticle, model);
		}
		varticle = "0";
		scanName22.setText("");
	}

	class QuickSrch implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				FillArticle();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	class keyLsnr implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int vkeycode = e.getKeyCode();
			if (quickSearch.isFocusOwner() && vkeycode == 40) {
				Articletable.grabFocus();
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			try {
				if (quickSearch.isFocusOwner()) {
					FillArticle();
					quickSearch.grabFocus();
				}

				if (scanName22.isFocusOwner()) {

				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	class nameFocusLsnr implements FocusListener {
		@Override
		public void focusGained(FocusEvent arg0) {
		}

		@Override
		public void focusLost(FocusEvent arg0) {

		}

	}

	// FillHere

	private void FillArticle() throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(Articlemodel);
		String sname = quickSearch.getText();
		sname = "%" + sname + "%";
		String SQL = "call  Tb_getAllArticleName( '" + sname + "' , " + vcomp + "  , " + vverticlecode + "      )";
		String ArticleCol[] = { "Article", "Name", "Sales Price", "Size", "Color", "Brand", "Type", "Material",
				"Pattern" };
		ajsp.setBounds(0, 74, 650, 268);
		rs = this.getSPResult(SQL);
		Articlemodel.setColumnIdentifiers(ArticleCol);
		Articletable.setModel(Articlemodel);
		Articletable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		while (rs.next()) {
			Articlemodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(12),
					rs.getString(13), rs.getString(10), rs.getString(9), rs.getString(11), rs.getString(14), });
			quickSearch.grabFocus();
			Articletable.setModel(Articlemodel);
			Articletable.getCellRenderer(1, 1);
			// Articletable.setDefaultRenderer(Object.class, new posRenderer());
			new gnTable().setTableBasics(Articletable);
			new gnTable().setTablewidth(Articletable, 0, 50);
			new gnTable().setTablewidth(Articletable, 1, 150);
			Articletable.setCellSelectionEnabled(true);
			Articletable.setRowSelectionAllowed(true);
			new gnTable().setTableBasics(Articletable);
			Articletable.setRowHeight(27);
			Articletable.setGridColor(Color.gray);
			Articletable.setBackground(Color.DARK_GRAY);
			Articletable.setForeground(Color.WHITE);
			JViewport prt777 = new JViewport();
			prt777.setBackground(Color.CYAN);
			prt777.add(Articletable, ArticleCol);
			prt777.setVisible(true);
			ajsp.setViewport(prt777);
			Articletable.requestFocus();
			SelectArticlerow();
		}
	}

	private void FillArticleForAttributes() throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(Articlemodel);
		String sname = quickSearch.getText();
		sname = "%" + sname + "%";

		String vbrand = brand.getSelectedItem().toString();
		String vcolor = color.getSelectedItem().toString();
		String vsize = size.getSelectedItem().toString();

		String SQL = "call  Tb_getAllArticleNameForAttributes( '" + sname + "' , " + vcomp + "  , " + vverticlecode
				+ " , '" + vbrand + "', '" + vcolor + "' , '" + vsize + "' )";
		String ArticleCol[] = { "Article", "Name", "Sales Price", "Size", "Color", "Brand", "Type", "Material",
				"Pattern" };
		ajsp.setBounds(0, 74, 650, 268);
		rs = this.getSPResult(SQL);
		Articlemodel.setColumnIdentifiers(ArticleCol);
		Articletable.setModel(Articlemodel);
		Articletable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		while (rs.next()) {
			Articlemodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(12),
					rs.getString(13), rs.getString(10), rs.getString(9), rs.getString(11), rs.getString(14), });
			quickSearch.grabFocus();
		}
		Articletable.setModel(Articlemodel);
		Articletable.getCellRenderer(1, 1);
		// Articletable.setDefaultRenderer(Object.class, new posRenderer());
		new gnTable().setTableBasics(Articletable);
		new gnTable().setTablewidth(Articletable, 0, 50);
		new gnTable().setTablewidth(Articletable, 1, 150);
		Articletable.setCellSelectionEnabled(true);
		Articletable.setRowSelectionAllowed(true);
		new gnTable().setTableBasics(Articletable);
		Articletable.setRowHeight(27);
		Articletable.setGridColor(Color.gray);
		Articletable.setBackground(Color.DARK_GRAY);
		Articletable.setForeground(Color.WHITE);
		JViewport prt777 = new JViewport();
		prt777.setBackground(Color.CYAN);
		prt777.add(Articletable, ArticleCol);
		prt777.setVisible(true);
		ajsp.setViewport(prt777);
		Articletable.requestFocus();
		SelectArticlerow();

	}

	public void SelectArticlerow() {
		Articletable.requestFocus();
		Articletable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		Articletable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = Articletable.getSelectedRow();
				String varticle = (String) Articletable.getValueAt(row, 0);
				try {
					showTableData(varticle, model);
					resetAttributes();
					quickSearch.grabFocus();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					// possplit.setDividerLocation(2);
				}
				new General().msgDispose();
			}
		});
	}

	public CellEditorListener ChangeNotification1011 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			// System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = Articletable.getSelectedRow();
			String vtype = (String) Articletable.getValueAt(row, 2);
			varticle = (String) Articletable.getValueAt(row, 2);
			try {
				showTableData(varticle, model);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	};

	class hmDel_lsnr implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			check();
		}
	}

	private void check() {

		boolean checkvalue = homeDelivery.isSelected();
		if (checkvalue == true) {
			hm_Phone.setEditable(true);
			hm_custname.setEditable(true);
			hm_addr1.setEditable(true);
			hm_addr2.setEditable(true);
			hm_addr3.setEditable(true);
			hm_Phone.setBackground(Color.white);
			hm_custname.setBackground(Color.white);
			hm_addr1.setBackground(Color.white);
			hm_addr2.setBackground(Color.white);
			hm_addr3.setBackground(Color.white);
		}

		if (checkvalue == false) {
			hm_Phone.setEditable(false);
			hm_custname.setEditable(false);
			hm_addr1.setEditable(false);
			hm_addr2.setEditable(false);
			hm_addr3.setEditable(false);

			hm_Phone.setBackground(Color.BLACK);
			hm_custname.setBackground(Color.BLACK);
			;
			hm_addr1.setBackground(Color.BLACK);
			;
			hm_addr2.setBackground(Color.BLACK);
			;
			hm_addr3.setBackground(Color.BLACK);
			;
			hm_custname.setBackground(Color.BLACK);

			hm_Phone.setText(null);
			hm_custname.setText(null);
			hm_addr1.setText(null);
			hm_addr2.setText(null);
			hm_addr3.setText(null);
		}
	}

	// Start Coding Here

	class ls implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (vbeginstatus == "Fail") {
				new General().msg("Day Begin Not done ... complate Day Begin first..");
				POSSimpleFrame.dispose();
			}

			if (value == "Day End") {
				try {

					POSSimpleFrame.dispose();
					dayEnd window;
					window = new dayEnd();
					window.frameDayEnd.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Cash Withdraw") {
				cashDeposit_Withdraw window;
				try {
					window = new cashDeposit_Withdraw();
					window.cashdepost_wdrw.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Cash Deposit") {
				cashDeposit_Withdraw window;
				try {
					window = new cashDeposit_Withdraw();
					window.cashdepost_wdrw.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Print") {
				try {
					printInvoice();
					scanItem_2.grabFocus();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				return;
			}

			if (value == "Declare Cash") {
				try {

					Declaration window = new Declaration();
					window.DeclarationFrame.setVisible(true);
					POSSimpleFrame.dispose();
				} catch (SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Payment") {
				try {
					int row = table.getRowCount();
					if (row > 0) {
						switch (vallowPopWindow) // New Change for payment
													// window popup as per
													// configuration
						{
						case "N":
							custamountPaid.grabFocus();
							custamountPaid.grabFocus();
							pmtPanel.setVisible(true);
							custamountPaid.grabFocus();

							// insertPaymentRow() ;
							pmt.setVisible(false);
							panelDoctorInfo.setVisible(false);
							break;

						case "Y":
							// new General().msgPanel(pmtPanel, "Pay Here ",450,
							// 300);
							break;
						}
						insertPaymentRow();
						// return;
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				return;
			}

			// Article Processing for Display Billing Data
			if (i == 1001) {
				if (vallowday == "N") {
					POSSimpleFrame.dispose();
					new General().msg("Complete Day Begin First...");
					return;
				}
				String result = ValidateItem(value);
				if (result == "Fail") {
					new General().msg("Item Not Found .. Please Try Again");
					scanItem_2.setText(null);
					scanItem_2.grabFocus();
				}
				if (result == "Sucess")
					try {
						value = value.trim();
						String nn1 = showTableData(value, model);
					} catch (SQLException e1) {
						new General().msg(e1.getMessage());
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().msg("ShowTableData" + " " + e1.getMessage());
					}
				return;
			}
		}

	}

	public String ValidateItem(String value) { // System.out.println(value);
		String result = "Sucess";
		// if (value.length() == 0 || value.length() >15 || value.isEmpty())
		if (value.length() == ' ') {
			// new General().msg("Please check Enter Article , Either you have
			// enter <0> or Lenght is higher then 15 char") ;
			result = "Fail";
		}

		if (value.length() == 0) {
			// new General().msg("Please check Enter Article , Either you have
			// enter <0> or Lenght is higher then 15 char") ;
			result = "Fail";
		}
		/*
		 * if (value.length() != 0 || value.length()<=15 ) { result = "Sucess" ;
		 * }
		 */
		return result;
	}

	class custls implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			String value = e1.getActionCommand();
			int i = e1.getID(); // Field id
			int custcode = Integer.parseInt(custid.getText());
			String vcustcode = custid.getText();
			if (vcustcode.length() == 0) {
				new General().msg("Enter Customer Code .. ");
				return;
			}
			try {
				dispCustInfo(custcode);
			} catch (SQLException ee) {
				ee.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class lshdr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			calHdrDisocunt();
		}
	}

	class lsnrBillSearch implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String vcust = custid.getText();
			try {
				new gnInvoice().getCustomerInvno(vcust);
			} catch (Throwable e2) {
				e2.printStackTrace();
			} finally {
				try {
					String vbillno = new gnInvoice().invno;
					String vbilldate = new gnInvoice().invdate;
					if (vbillno != null) {
						new gnSale().showinvoice(vbillno, vbilldate);
					}
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
				}
			}

		}
	}

	class lsnrCustName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String sname = custname.getText().trim();
			sname = "%" + sname + "%";
			String vcomp;
			try {
				vcomp = new gnConfig().getCompanyCode();
				String sqlcust = "call  Tb_getAllPOSCustomer('" + sname + "' , " + vcomp + ")";
				Search(sqlcust, SCol);
			} catch (Throwable e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}

	class lsSave implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);

			if (value == "Copy Bill") {
				btnSalesLike.setBackground(Color.black);
				btnSalesLike.setForeground(Color.white);
				ActionListener abc = new lsnrBillSearch();
				abc.actionPerformed(e);
				String vinvno = new gnInvoice().invno;
				String vinvdate = new gnInvoice().invdate;
				new gnInvoice().invno = null;
				new gnInvoice().invdate = null;

				try {
					vinvdate = new gnConfig().date_ConverttoDBforamt(vinvdate);
					vcomp = new gnConfig().getCompanyCode();
					vstore = new gnConfig().getStoreID();

				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
				String vtype3 = "PS";
				String SQL = "Call sale_getEditSalesData( '" + vtype3 + "', " + vcomp + " ,  " + vstore + "  , "
						+ vinvno + ", '" + vinvdate + "' )";
				// new General().msg(SQL);
				try {
					showEditTableData(SQL, model);
				} catch (Throwable e1) {
					new General().msg(SQL);
				}

			}

			if (value == "Check Other Item") {
				try {
					new gnArticleContent().getContent(varticle);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Edit-Sales") {

				try {
					int rowcnt = table.getRowCount();
					if (rowcnt > 0) {
						new General().msg("Please Save Active Bill Before Edit New Bill...");
						new gnImageSound().playAlertSound();
						new gnImageSound().playAlertSound();
					} else {

						StartEditProcess();
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Close") {
				POSSimpleFrame.dispose();
			}

			if (value == "Doctor & Patient Info") {
				pmt.setVisible(false);
				panelDoctorInfo.setVisible(true);
				docname.grabFocus();
			}

			if (value == "New Doctor") {

				medical_DoctorMaster window;
				try {
					window = new medical_DoctorMaster();
					window.Doctorframe.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Save") {
				try {
					String action = CheckBatchControlArticle();
					if (action == "Sucess") {
						pickDataForInsert();
					}
				} catch (Exception e1) {
					new General().msg("Save Data" + "" + e1.getLocalizedMessage());
					e1.printStackTrace();
				} catch (Throwable e1) {
					new General().msg("Save Data" + "" + e1.getLocalizedMessage());
					e1.printStackTrace();
				}
			}
		}
	}

	private void StartEditProcess() throws Throwable {
		invoiceMode = "E";
		chekcFreezeYear();
		getInvoiceNo();
	}

	private void getInvoiceNo() throws Throwable {
		try {
			String vtype = "PS";
			String vcustcode = custid.getText();
			new gnSale().get_invnoForcustomer(vtype, vcustcode);
		} catch (Exception e) {
			new General().msg(e.getMessage());
		} finally {
			if (new gnSale().rinvno.length() > 0) {
				invdate.setText(new gnSale().rinvdate);
				invno.setText(new gnSale().rinvno);
				new gnSale().rinvdate = "";
				new gnSale().rinvno = "";
				String vinvno = invno.getText();
				String vinvdate = new gnConfig().date_ConverttoDBforamt(invdate.getText());
				vcomp = new gnConfig().getCompanyCode();
				vstore = new gnConfig().getStoreID();
				String vtype3 = "PS";
				String SQL = "Call sale_getEditSalesData( '" + vtype3 + "', " + vcomp + " ,  " + vstore + "  , "
						+ vinvno + ", '" + vinvdate + "' )";
				showEditTableData(SQL, model);
			}
		}
	}

	public void callEditProcess(String vdocno, String vdocDate) throws Throwable {
		invoiceMode = "E";
		invdate.setText(vdocDate);
		invno.setText(vdocno);
		String vinvno = invno.getText();
		String vinvdate = new gnConfig().date_ConverttoDBforamt(vdocDate);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vtype3 = "PS";
		String SQL = "Call sale_getEditSalesData( '" + vtype3 + "', " + vcomp + " ,  " + vstore + "  , " + vinvno
				+ ", '" + vinvdate + "' )";
		table.setGridColor(Color.YELLOW);
		table.setRowHeight(30);
		showEditTableData(SQL, model);
	}

	//// SEarch Button Lsitener
	class lsSearch implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (value == "Search Aname") {
				String sname = scanName22.getText().trim();
				sname = "%" + sname + "%";
				try {
					String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
							new gnPublicVariable().vstore);
					String sqlaName = "call  Tb_getAllArticleName('" + sname + "')";
					String vtype = "Article";
					ASearch(sqlaName, ACol, vtype);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Search Now") {
				String sname = custname.getText().trim();
				sname = "%" + sname + "%";
				String sqlcust = "call  Tb_getAllCustomer('" + sname + "')";
				try {
					Search(sqlcust, SCol);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	//// Search Button Listner

	public void calHdrDisocunt() {
		Double xTamount = Double.parseDouble(Tamount.getText());
		fhdrDiscount = Double.parseDouble(hdrDiscount.getText());
		double vnetAmt = xTamount - fhdrDiscount;
		int vnetAmtnew = (int) Math.round(vnetAmt);
		double vroundamt = (vnetAmtnew - vnetAmt);
		froundAmt.setText(Double.toString(vroundamt));
		netAmount.setText(Integer.toString(vnetAmtnew));
	}

	private void calculateGSTReturnData() throws Throwable {

		String vparty = "0";
		String vdocno = invno.getText();
		String vdocdate = invdate.getText();
		// String vamount = Final_Tamt.getText();
		String vdoctype = "Retail";
		reduceInv();

		switch (PostGST_accountEntryAtSaveTime) {
		case "Y":
			// new gnGSTMiddleWare().gstPOSSalesProcess(vparty, vdocno,
			// vdocdate, VAccountPostingAmount);
			new gnGSTMiddleWare().backend_DocgstPOSSalesProcess(vparty, vdocno, vdocdate, VAccountPostingAmount);
			new gnLogger().loggerInfoEntry("Credit Sale", "Calculate GST Data and Posting Account Entry- Sucess");
			break;
		}
	}

	public void printInvoice() throws Throwable {
		new gnLogger().loggerInfoEntry("POS", "Printing Document Init..");
		String vinvno = invno.getText();
		if (vinvno.length() != 0) {
			String doctype = "POSINV";

			String vpara27 = "27";
			String printinvoice = new getConfigurationSetting().getSpecificConfiguration(vpara27);
			String vinvdate = invdate.getText();
			switch (printinvoice) {
			case "Y":
				scanItem_2.grabFocus();
				new gnDocPrint().callprint(doctype, vinvno, vinvdate);
				internalFrame.requestFocusInWindow();
				scanItem_2.grabFocus();
			}
		} else {
			new General().msg("Invoice Number Not Available For Printing...");
		}

		return;
	}

	public void initiateNewBill() throws Throwable {

		custamountPaid.setText(null);
		btnSalesLike.setBackground(Color.CYAN);
		btnSalesLike.setForeground(Color.BLACK);
		invdate.setText(new gnConfig().getDaybeginDate());
		// new gnDecorate().setButtonColor11(btnDayBegin);
		invoiceMode = "I";
		vdoccode = "0";
		docname.setText("0");
		patientName.setText("No Data");
		editPanel.setVisible(false);
		patientName.setText(null);
		int tableRowcount = table.getRowCount();
		int ptableRowcount = ptable.getRowCount();
		if (ptableRowcount <= 0 && tableRowcount <= 0) {
			this.closeconn();
			// invno.setText(null);
			Tamount.setText("0.00");
			Final_Pamt.setText(null);
			Final_Tamt.setText("00");
			Final_Damt.setText("00");
			duePayment = 0.00;
			paidAmount = 0.00;
			famount = 0.00;
			netAmount.setText("0.00");
			froundAmt.setText("0.00");
			hdrDiscount.setText("00");
			// custid.setText(null);
			custname.setText(null);
			mobile.setText(null);

			int vccode1 = 0;
			custid.setText(Integer.toString(vccode1));
			new gnTable().RemoveTableRows(model);
			new gnTable().RemoveTableRows(pmodel);
			String sitecode = Site_code.getText();
			// invno.setText(null);
			int vccode = 0;
			custid.setText(Integer.toString(vccode));
			String reset = "                                ";
			// scanItem.setText(reset);
			tableno.setText("0");
			floor.setText("1");
			tabletype.setText(null);
			split.setText(null);
			this.closeconn();
			new gnLogger().loggerInfoEntry("POS", "New Bill Init...");
			prst = null;
			System.gc();
			// new General().msg("No Data Availbale") ;
		}

		if (ptableRowcount >= 0 && tableRowcount >= 0) {
			// invno.setText(null);
			Tamount.setText("0.00");
			Final_Pamt.setText(null);
			Final_Tamt.setText("00");
			Final_Damt.setText("00");
			duePayment = 0.00;
			paidAmount = 0.00;
			famount = 0.00;
			netAmount.setText("0.00");
			froundAmt.setText("0.00");
			hdrDiscount.setText("00");
			// custid.setText(null);
			custname.setText(null);
			mobile.setText(null);

			int vccode1 = 0;
			custid.setText(Integer.toString(vccode1));
			new gnTable().RemoveTableRows(model);
			new gnTable().RemoveTableRows(pmodel);
			String sitecode = Site_code.getText();
			// invno.setText(null);
			int vccode = 0;
			custid.setText(Integer.toString(vccode));
			String reset = "                                ";
			// scanItem.setText(reset);
			tableno.setText("0");
			floor.setText("1");
			tabletype.setText(null);
			split.setText(null);
			scanItem_2.grabFocus();
			this.closeconn();
			new gnLogger().loggerInfoEntry("POS", "New Bill Init...");
		}

	}

	public void ReCalculatePayment() throws ClassNotFoundException, SQLException { // new
																					// General().msg("Triggering
																					// Recalculate
																					// Event
																					// ");
		paidAmount = 0.00;
		int maxRow1 = ptable.getRowCount();
		for (int i = 0; i < maxRow1; i++) {
			String paid = (String) ptable.getValueAt(i, 2).toString();
			int vpaid = Integer.parseInt(paid);
			String pmode = (String) ptable.getValueAt(i, 1).toString();
			String vcustid = custid.getText();
			String vdocno = (String) ptable.getValueAt(i, 3).toString();
			String Vresult = "Sucess";
			if (Vresult == "Sucess") {
				if (pmode == " " && vpaid != 0) {
					new General().msg("Please Check Payment Mode ...Select Payment Mode for Enter Amount");
				}
				if (pmode != " " && vpaid != 0) {
					paidAmount = paidAmount + vpaid;
					duePayment = 0.00;
					duePayment = (famount - paidAmount);
					Final_Pamt.setText(String.valueOf(paidAmount));
					Final_Damt.setText(String.valueOf(duePayment));
				}
				if (pmode != " " && vpaid == 0) {
					paidAmount = paidAmount + vpaid;
					duePayment = 0.00;
					duePayment = (famount - paidAmount);
					Final_Pamt.setText(String.valueOf(paidAmount));
					Final_Damt.setText(String.valueOf(duePayment));
				}

			}
		}
	}

	public void CalculatePayment() throws ClassNotFoundException, SQLException {
		Double vpaid = 0.00;
		String Vcheck = "Sucess";
		int maxRow1 = ptable.getRowCount();
		paidAmount = 0.00;
		for (int i = 0; i <= maxRow1 - 1; i++) {

			String paid = (String) ptable.getValueAt(i, 2).toString();
			vpaid = Double.parseDouble(paid);
			String pmode = (String) ptable.getValueAt(i, 1).toString();

			if (i != 0 && pmode == " " && vpaid == 0 && duePayment == famount) {
				pmodel.removeRow(i);
			}
			if (pmode != " " && vpaid != 0.00) {
				paidAmount = paidAmount + vpaid;
				duePayment = 0.00;
				duePayment = (famount - paidAmount);
				Final_Pamt.setText(String.valueOf(paidAmount));
				Final_Damt.setText(String.valueOf(duePayment));
			}

			if (pmode != " " && vpaid == 0.00) {
				paidAmount = paidAmount + vpaid;
				duePayment = 0.00;
				duePayment = (famount - paidAmount);
				Final_Pamt.setText(String.valueOf(paidAmount));
				Final_Damt.setText(String.valueOf(duePayment));
			}
		}
	}

	public String checkCN() throws Throwable {
		String result = "Sucess";
		int maxRow1 = ptable.getRowCount();
		for (int i = 0; i < maxRow1; i++) {
			String paid = (String) ptable.getValueAt(i, 2).toString();
			int vpaid = Integer.parseInt(paid);
			String pmode = (String) ptable.getValueAt(i, 1).toString();
			String vcustid = custid.getText();
			String vdocno = (String) ptable.getValueAt(i, 3).toString();
			String Vresult = "Sucess";
			switch (pmode) {
			case "Credit Note":
				Vresult = new gnApp().checkValidCN(pmode, vcustid, vdocno, paid);
				if (Vresult == "Fail") {
					result = Vresult;
				}
			}
		}
		return result;
	}

	public void checkperBillLine() {
		int row = table.getRowCount();
		if (row > para805) {
			new General().msg("Configuration : No of Lines more then Config Setting max line Allow is" + para805);
		}
	}

	public void checkpaymentMode() throws Throwable {
		Double vpaid = 0.00;
		paidAmount = 0.00;
		int rw = ptable.getSelectedRow();
		vpaid = Double.parseDouble((String) ptable.getValueAt(rw, 2));
		String pmode = (String) ptable.getValueAt(rw, 1).toString();
		switch (pmode) {
		case "Credit Note":
			String vcustomer = custid.getText();
			String vtype = "CN";
			String CNcol[] = { "Type", "CN.No", "Date", "Amount", "status" };
			String vcomp = new gnConfig().getCompanyCode();
			String vstore = new gnConfig().getStoreID();
			String SQL = "call  CN_getCNdetails( '" + vtype + "'  , " + vcustomer + " ,  " + vstore + " , " + vcomp
					+ ")";
			// new General().msg(SQL) ;
			ASearch(SQL, CNcol, vtype);
			break;
		}
		if (pmode == " " && vpaid != 0) {
			new General().msg("!!Payment Mode Not Selected!!.<Select Payment Mode for Enter Amount>");
			return;
		}
	}

	public void dispCustInfo(int custcode) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = " call getScanCustomer(" + custcode + " , " + vcomp + ")";
		rs = this.getSPResult(SQL);
		new General().ValidateResultSet(rs);
		int row = rs.getRow();
		if (row == 0) {
			return;
		}
		rs.first();
		custid.setText(rs.getString(1));
		custname.setText(rs.getString(2));
		mobile.setText(rs.getString(3));
		rs.close();
	}

	public void checkForSave() {
		if (duePayment <= 0) {
			if (process == true)
				btn_Save.doClick();
			process = false;
			return;
		}
	}

	public String CheckBatchArticle(String varticle, String vbatchcontrol) throws Throwable {
		// new General().msgDispose();
		String status = "Sucess";
		String vstorecode = Site_code.getText();
		String vcomp = new gnConfig().getCompanyCode();
		String vloc = "SL";
		String batch[] = { "BatchArticlce", "Item Code", "name", "cost", "SalesPrice", "Mrp", "Batchno", "Manuf_date",
				"Exp.Date", "Bal_Qty" };
		try {

			new gnGetBatch().getBatchDetail(varticle, vbatchcontrol, vloc);

		} catch (Exception e) {
			// new General().msg("Batch Selection...."+"
			// "+e.getLocalizedMessage());
		} finally {

			if (Double.parseDouble(new gnGetBatch().salesPrice) > 0) {
				table.setValueAt(new gnGetBatch().batchno, selectedrow, 13);
				table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 14);
				table.setValueAt(new gnGetBatch().batchno, 0, 13);
				table.setValueAt(new gnGetBatch().expiry_date, 0, 14);
				table.setValueAt(new gnGetBatch().salesPrice, 0, 4);
				table.setValueAt(new gnGetBatch().mrp, 0, 5);
				// table.setValueAt(new gnGetBatch().cost, 0, 15);
				new gnGetBatch().resetValues();
				QtychangeImapct(varticle, 0);
			}
		}
		return status;
	}// Method End

	public void insertPaymentRow() throws ClassNotFoundException, SQLException {
		String Vcheck = "Sucess";
		int billRows = table.getRowCount();
		if (billRows > 0)
			table.setBackground(Color.CYAN);
		table.setForeground(Color.blue);
		table.setGridColor(Color.YELLOW);
		table.setFocusable(true);
		calHdrDisocunt();
		CalculatePayment();
		ReCalculatePayment();

		famount = Double.parseDouble(netAmount.getText());
		duePayment = Double.parseDouble(netAmount.getText());
		paidAmount = 0.00;
		Final_Tamt.setText(netAmount.getText().toString());
		Final_Damt.setText(netAmount.getText().toString());

		new gnImageSound().playSound();
		new gnImageSound().playSound();

		new gnTable().setTableBasics(ptable);
		pmodel.addRow(new Object[] { "Del", "Cash", "0", "0", "0" });
		ptable.setModel(pmodel);
		String vtype = "PaymentMode";
		String vverticle = new gnHierarchy().getVerticleCode();
		String SQL = " call master_getMasterData('" + vtype + "'  , " + vverticle + ")";
		ptable.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new gnComp().generateBox(SQL)));
		ptable.setModel(pmodel);
		new gnTable().AddCheckBoxToTable(pmodel, ptable, 0);
		removeRow(pmodel, ptable);
		new gnTable().setCellMask(ptable, 3);
		ptable.requestFocus();
		ptable.changeSelection(0, 2, false, false);
		ptable.editCellAt(0, 2);
		ptable.setCellSelectionEnabled(true);
		ptable.setEditingColumn(2);
		custamountPaid.grabFocus();
		DefaultCellEditor nk = new gnTable().cellEdit(ptable);
		nk.addCellEditorListener(ChangeNotification1);
		// CalculatePayment();
		btn_Save.setEnabled(true);
		switch (vallowPopWindow) {
		case "Y":
			pmtPanel.setVisible(true);
			new General().msgPanel(pmtPanel, "Pay Here ", 450, 300);
			break;
		}
		// btn_Save.doClick();
	}

	public void addPaymentWithNewLogic() throws ClassNotFoundException, SQLException {
		String vmode = payCombo.getSelectedItem().toString();
		String vcustpaid = custamountPaid.getText();
		// pmodel.addRow(new Object[]{"Del", vmode, vcustpaid, "0","0"});
		pmodel.insertRow(0, new Object[] { "Del", vmode, vcustpaid, "0", "0" });
		ptable.setModel(pmodel);
		calHdrDisocunt();
		CalculatePayment();
		ReCalculatePayment();
		custamountPaid.setText(null);

	}

	public CellEditorListener ChangeNotification1 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
		}

		public void editingStopped(ChangeEvent e) {
			nrow = ptable.getSelectedRow();
			String nvalue = (String) ptable.getValueAt(nrow, 3);
			String vresult = "Sucess";
			try {
				checkpaymentMode();
				CalculatePayment();
				ReCalculatePayment();
			} catch (ClassNotFoundException | SQLException e1) {
				new General().msg(e1.getLocalizedMessage());
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	};

	public CellEditorListener ChangeNotification101 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
		}

		public void editingStopped(ChangeEvent e) {
			nrow = ptable.getSelectedRow();
			String nvalue = (String) ptable.getValueAt(nrow, 3);
			String vresult = "Sucess";
			try {
				vresult = checkCN();
				if (vresult == "Sucess") {
					CalculatePayment();
				}
			} catch (ClassNotFoundException | SQLException e1) {
				new General().msg(e1.getLocalizedMessage());
			} catch (Throwable e1) {
				new General().msg(e1.getLocalizedMessage());
			}
		}
	};

	public String CheckBatchControlArticle() {
		String Action = "Sucess";
		// Double vtotal = Double.parseDouble(netAmount.getText()) ;
		Action = new gnTable().isAmountnegative(netAmount.getText());
		int rw = table.getRowCount();
		String vbatch = " ";
		String vExp = "";
		String vbatchno = " ";
		String varticle = "";
		String vdrugType = "";
		for (int k = 0; k < rw; k++) {
			// public String Col[] = {"X","Item","Name","Qty" ,"Rate" ,"MRP",
			// "Gross" ,"Hdr Disc", "Disc" ,"Tax", "Amount","Taxcode" ,
			// 12"Batch Item" ,13"BatchNo", 14"Exp.Date" , 15"Cost", };
			vbatch = table.getValueAt(k, 12).toString();
			vExp = table.getValueAt(k, 14).toString();
			vbatchno = table.getValueAt(k, 13).toString();
			vdrugType = table.getValueAt(k, 16).toString();
			// Action = checkForDrugType(vdrugType) ;

			switch (vdrugType) {
			case "H1":
				if ((docname.getText().length() == 0) || (patientName.getText().length() == 0)) {
					new General().msg("Schedule H1 / H Drug  Is In Bill Please Enter Doctor and Patient Info");
					Action = "Fail";
					btnDoctor.doClick();
					break;
				}
				break;
			case "H":
				if ((docname.getText().length() == 0) || (patientName.getText().length() == 0)) {
					new General().msg("Schedule H1 / H Drug  Is In Bill Please Enter Doctor and Patient Info");
					Action = "Fail";
					btnDoctor.doClick();
					break;

				}
				break;
			}

			if (vbatchno.length() == 0) {
				vbatchno = "0";
			}
			varticle = table.getValueAt(k, 1).toString();
			switch (vbatch) {
			case "Y":
				switch (vExp) {
				case "0":
					new General().msg("Enter Batch no and Expiry Date for Item Code " + varticle);
					table.setEditingRow(k);
					table.setBackground(Color.BLUE);
					table.setEditingColumn(13);
					Action = "Fail";
				}
			}
		}
		return Action;
	}

	public String showTableData(String value, DefaultTableModel model) throws Throwable {
		String neginvallow = "Y";
		pmt.setVisible(true);
		String action = "Insert";
		String value1 = value;
		String vmyamount = "";
		value1 = value;
		String vtaxper = "";
		Object row[] = {};
		String vtype = "POS";
		String vfinyear = new gnFinYear().getReportingFinYear();
		neginvallow = checkAllowNegInv(value1);
		model.setColumnIdentifiers(Col);
		table.setModel(model);
		if (neginvallow == "Y") {
			String vpara707 = "707";
			para707 = new getConfigurationSetting().getSpecificConfiguration(vpara707);
			switch (para707) {
			case "Y":
				action = checkArticleExist(value1);
				break;
			}
			if (action == "Insert") {
				new gnLogger().loggerInfoEntry("POS", "Item Scan is :" + value);
				String SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , " + value + ", " + vcomp
						+ " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
				TR tr = new TR();
				TableColumnModel tcm = table.getColumnModel();
				for (int c = 3; c < 9; c++) {
					TableColumn tc = tcm.getColumn(c);
					tc.setCellRenderer(tr);
				}
				ResultSet rs = this.getSPResult(SQL);
				String rvalue = new General().ValidateResultSet(rs);
				if (rvalue != "Fail") {
					String varticle = rs.getString(1);
					AutodiscArticle = rs.getString(1);
					String vsp = rs.getString(4);
					if (Double.parseDouble(vsp) == 0.0) {
						new General().msg("Please Update Price Master  ");
						new gnLogger().loggerInfoEntry("POS", "Please Update Price Master  ");
					}
					model.insertRow(0,
							new Object[] { new Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
									rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
									rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
									rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(17),
									rs.getString(18) });
					table.setModel(model);
					table.setCursor(new Cursor(Cursor.HAND_CURSOR));

					vdrugType = rs.getString(17);
					SelectrowforEdit();
					new gnTable().setTableBasics(table);
					// table.removeColumn(table.getColumnModel().getColumn(15));//
					// Remove Column from model but avaible in table we need to
					// take hide col value check insert for cost
					// jsp.setAutoscrolls(true);
					new gnTable().setTablewidth(table, 2, 300);
					String vbatchArticle = rs.getString(12);
					CheckBatchArticle(value, vbatchArticle);
					Double itemtotal = new gnTable().getTotal(table, 10);
					Tamount.setText(Double.toString(itemtotal));
					scanItem_2.setText(null);
					scanItem_2.grabFocus();
					calHdrDisocunt();
					checkperBillLine();
					removeRow(model, table);
					selectedrow = table.getRowCount() - 1;
				}
			}
			int vcount = table.getRowCount();
			records.setText(Integer.toString(vcount));
			table.getColumnModel().getColumn(2).setPreferredWidth(300);
			table.setRowHeight(27);
			table.setGridColor(Color.DARK_GRAY);
			table.setSelectionBackground(Color.blue);
			table.setSelectionForeground(Color.WHITE);
			DecimalFormat dfpr = new DecimalFormat("######.00");
			NumberFormatter formatterpr = new NumberFormatter(dfpr);
			formatterpr.setAllowsInvalid(false);

			chngqty = new JFormattedTextField(formatterpr);
			sp = new JFormattedTextField(formatterpr);
			vexpedtr = new JTextField();

			chngqty.setBackground(Color.white);
			sp.setBackground(Color.white);
			vexpedtr.setBackground(Color.GREEN);
			ActionListener expdtr = new expDate();
			ActionListener qtychng = new qtyLsnr();
			ActionListener spchng = new spLsnr();
			table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(chngqty));
			table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(sp));
			table.getColumnModel().getColumn(14).setCellEditor(new DefaultCellEditor(vexpedtr));
			chngqty.addActionListener(qtychng);
			sp.addActionListener(spchng);
			vexpedtr.addActionListener(expdtr);
			DefaultCellEditor nk = new gnTable().cellEdit(table);
			nk.addCellEditorListener(ChangeNotification);
			table.setGridColor(Color.BLACK);
			this.closeconn();
		}
		varticle = "0";
		checkForDrugType(vdrugType);
		resetAttributes(); // gnPublicVariable method to reset color/size
		editPanel.setVisible(false);
		JViewport prt = new JViewport();
		prt.setForeground(Color.RED);
		prt.setBackground(new Color(51, 255, 255));
		prt.add(table, Col);
		prt.setBackground(Color.WHITE);
		prt.setVisible(true);
		jsp.setViewport(prt);
		jsp.setVisible(true);

		// As per TaxRAte Changes REset All other Values for Sccanned Row
		switch (vverticlecode) {
		case "7":
			QtychangeImapct(value, taxslabrow);
			break;

		case "14":
			QtychangeImapct(value, taxslabrow);
			break;
		}
		// End As per TaxRAte Changes REset All other Values for Sccanned Row

		return "OK";
	} // ShowTableData

	private String initialCheckForTaxSlab(String varticle, String vamount) throws Throwable {
		String vtaxcode = "";
		try {
			String vapplicable = new gnArticle().Article_isTaxSlabAppliccable(varticle);
			switch (vapplicable) {
			case "Y":
				vtaxcode = new gnArticle().Article_getArticleTaxSlabCode(vamount);
				break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		new General().msg(vtaxcode);
		return vtaxcode;
	}

	public String QtychangeImapct(String value, int i) throws Throwable {

		new gnLogger().loggerInfoEntry("POS",
				"User Editing Data Either for qty /  Rate /Discount for row" + " " + i + "Artilce " + value);
		String vmyamount = "";
		String vtaxrate = "";
		String curqty1 = (String) table.getValueAt(i, 3).toString();
		double curqty = Double.parseDouble((curqty1));
		pmt.setVisible(true);
		if (curqty == 0.0) {
			new General().msg(
					"< Qty > Can not be <0> {Do you Want to Remove Row.... Click On First Column in same Row.. ..}");
			table.setValueAt(1, i, 3);
			table.setEditingRow(i);
			table.setGridColor(Color.YELLOW);
		}
		String Csp1 = (String) table.getValueAt(i, 4);
		Double Csp = Double.parseDouble((String) Csp1);
		String Cemp_disc1 = (String) table.getValueAt(i, 7).toString();
		Double Cemp_disc = Double.parseDouble(Cemp_disc1);
		String Cdisc1 = (String) table.getValueAt(i, 8).toString();
		Double Cdisc = Double.parseDouble(Cdisc1);
		// Double vtax = Double.parseDouble(table.getValueAt(i, 11).toString());
		Double newqty = curqty;
		Double newgross = newqty * Csp;

		Double newAmount = (newgross - Cdisc - Cemp_disc);
		table.setValueAt(newAmount, i, 10);

		// For Tax Slab//
		switch (vverticlecode) {
		case "7":
			// new General().msg("checking for tax Slab ...");
			vmyamount = (String) table.getValueAt(i, 10).toString();
			vtaxrate = initialCheckForTaxSlab(value, vmyamount);
			table.setValueAt(vtaxrate, i, 11);
			break;
		case "14":
			// new General().msg( "checking for tax Slab ...");
			vmyamount = (String) table.getValueAt(i, 10).toString();
			vtaxrate = initialCheckForTaxSlab(value, vmyamount);
			table.setValueAt(vtaxrate, i, 11);
			break;
		}

		Double vtax = Double.parseDouble(table.getValueAt(i, 11).toString());
		Double newtax = new gnMath().CalTax_Sales(newAmount, vtax);
		table.setValueAt(newqty, i, 3);
		table.setValueAt(newgross, i, 6);
		table.setValueAt(newAmount, i, 10);
		table.setValueAt(newtax, i, 9);

		Double iTotal = new gnTable().getTotal(table, 10);
		Tamount.setText(Double.toString(iTotal));
		action = "Updated";
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		new gnLogger().loggerInfoEntry("POS",
				" Editing Data Over for qty /  Rate /Discount for row" + " " + i + "Artilce " + value);

		// Calcuate Margin Vloilation rule//
		String vcheckMargin = "Y";
		if (vcheckMargin == "Y") {
			String varticle = table.getValueAt(i, 1).toString();
			// String vcost = table.getValueAt(i, 15).toString();
			String vcost = table.getModel().getValueAt(i, 15).toString();
			String vsp = table.getValueAt(i, 4).toString();
			String status = new gnMath().checkMargin(varticle, vcost, vsp);
		}
		// End Margin Calcultion

		scanItem_2.grabFocus();
		calHdrDisocunt();

		String action = ValidateItemEntry();
		return action;
	}

	private void checkForDrugType(String vDrugType) {
		// new General().msg(vDrugType);
		if (vDrugType.isEmpty()) {
			vDrugType = "";
		}
		switch (vDrugType) {
		case "H1":
			if ((docname.getText().length() == 0) || (patientName.getText().length() == 0)) {
				new General().msg("Schedule H1 Drug Type Is In Bill, Please Enter Patient and Doctor Details...");
				btnDoctor.doClick();
			}
			break;
		case "H":
			if ((docname.getText().length() == 0) || (patientName.getText().length() == 0)) {
				new General().msg("Schedule H Drug Type is in Bill, Please Enter Patient and Doctor Details...");
				btnDoctor.doClick();
			}
			break;
		}
	}

	public String showEditTableData(String SQL, DefaultTableModel model) throws Throwable {
		String neginvallow = "Y";
		pmt.setVisible(true);
		String action = "Insert";
		String value1 = "0";
		Object row[] = {};
		model.setColumnIdentifiers(Col);
		new gnLogger().loggerInfoEntry("POS", "Item Scan is :" + SQL);
		table.setModel(model);
		TR tr = new TR();
		TableColumnModel tcm = table.getColumnModel();
		for (int c = 3; c < 9; c++) {
			TableColumn tc = tcm.getColumn(c);
			tc.setCellRenderer(tr);
		}
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			String varticle = rs.getString(1);
			String value = rs.getString(1);
			AutodiscArticle = rs.getString(1);
			model.insertRow(0,
					new Object[] { new Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
							rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17) });
			vdoccode = rs.getString(18);
			docname.setText(rs.getString(19));
			patientName.setText(rs.getString(20));
			table.setModel(model);
		}
		SelectrowforEdit();
		new gnTable().setTableBasics(table);
		// table.removeColumn(table.getColumnModel().getColumn(15));// Remove
		// Column from model but avaible in table we need to take hide col value
		// check insert for cost
		jsp.setAutoscrolls(true);
		selectedrow = table.getRowCount() - 1;
		new gnTable().setTablewidth(table, 2, 300);
		// String vbatchArticle = rs.getString(12) ;
		// CheckBatchArticle(value , vbatchArticle) ;
		Double itemtotal = new gnTable().getTotal(table, 10);
		Tamount.setText(Double.toString(itemtotal));
		// scanItem_2.setText(null);
		scanItem_2.grabFocus();
		calHdrDisocunt();
		checkperBillLine();
		removeRow(model, table);
		int vcount = table.getRowCount();
		records.setText(Integer.toString(vcount));
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		//
		DecimalFormat dfpr = new DecimalFormat("######.00");
		NumberFormatter formatterpr = new NumberFormatter(dfpr);
		formatterpr.setAllowsInvalid(false);

		chngqty = new JFormattedTextField(formatterpr);
		sp = new JFormattedTextField(formatterpr);
		vexpedtr = new JTextField();

		chngqty.setBackground(Color.white);
		sp.setBackground(Color.white);
		vexpedtr.setBackground(Color.GREEN);

		ActionListener expdtr = new expDate();
		ActionListener qtychng = new qtyLsnr();
		ActionListener spchng = new spLsnr();

		table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(chngqty));
		table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(sp));
		table.getColumnModel().getColumn(14).setCellEditor(new DefaultCellEditor(vexpedtr));

		chngqty.addActionListener(qtychng);
		sp.addActionListener(spchng);
		vexpedtr.addActionListener(expdtr);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification);
		table.setSelectionBackground(Color.WHITE);
		table.setSelectionForeground(Color.BLUE);
		table.setGridColor(Color.YELLOW);
		this.closeconn();
		varticle = "0";
		return "OK";
	} // ShowEdit TableData

	public void SelectrowforEdit() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				editrow = table.getSelectedRow();
				String vqty = (table.getValueAt(editrow, 3).toString());
				String vrate = (String) table.getValueAt(editrow, 4);
				String vcode = (String) table.getValueAt(editrow, 1);
				String vname = (String) table.getValueAt(editrow, 2);
				String vdisc = (String) table.getValueAt(editrow, 8);

				// Below Panel Activated for That
				eqty.setText(vqty);
				ename.setText(vname);
				erate.setText(vrate);
				editPanel.setVisible(true);
				// End

				try {
					editQtyPrice(vcode, vname, vqty, vrate, vdisc);
				} catch (Throwable e1) {
					e1.printStackTrace();//
					new General().msg("Edit Qty->:" + " " + e1.getLocalizedMessage());
					new gnLogger().loggerInfoEntry("POS", "Edit Qty->:" + " " + e1.getLocalizedMessage());
				} finally {
					try {
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().msg("Edit Qty:" + " " + e1.getLocalizedMessage());
						new gnLogger().loggerInfoEntry("POS", "Edit Qty->:" + " " + e1.getLocalizedMessage());
					}
				}
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
	}

	private void editQtyPrice(String vcode, String vname, String vqty, String vrate, String vdisc) {
		panelPriceEdit.setBounds(21, 86, 300, 300);
		editcode.setText(vcode);
		editname.setText(vname);
		editrate.setText(vrate);
		editqty.setText(vqty);
		editdisc.setText(vdisc);
		Dpanel.add(panelPriceEdit);
		editqty.requestFocus();
		editqty.grabFocus();
		panelPriceEdit.setBackground(Color.WHITE);
		new General().msgPanel(panelPriceEdit, "Edit Price and Qty", 350, 200);
		new gnLogger().loggerInfoEntry("POS", "Edit Price and Qty Called");
	}

	class editLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vnewqty = editqty.getText();
			String vnewrate = editrate.getText();
			String vnewdisc = editdisc.getText();
			table.setValueAt(vnewqty, editrow, 3);
			table.setValueAt(vnewrate, editrow, 4);
			table.setValueAt(vnewdisc, editrow, 8);
			String vcode = editcode.getText();
			try {
				table.notify();
				// panelPriceEdit.setVisible(false);
				new General().msgDispose();
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				try {
					new General().msg("row" + " " + editrow);
					QtychangeImapct(vcode, editrow);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}

	class expDate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row = table.getSelectedRow();
			// CellEditorListener hh ;
			String value = (String) table.getValueAt(row, 14);
			try {
				new selectdate().setTableCellDate(vexpedtr, table, row, 14);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
			}
		}
	}

	class qtyLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row = table.getSelectedRow();
			// CellEditorListener hh ;
			String value = (String) table.getValueAt(row, 1);
			String vnewqty = chngqty.getText();
			// new General().msg("Qty new"+ vnewqty);
			table.setValueAt(vnewqty, row, 3);
			table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(chngqty));
			table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(sp));
			try {

				QtychangeImapct(value, row);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class spLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row = table.getSelectedRow();
			// CellEditorListener hh ;
			String value = (String) table.getValueAt(row, 1);
			String vnewsp = sp.getText();
			// new General().msg("SP new "+ vnewsp);
			table.setValueAt(vnewsp, row, 4);
			table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(chngqty));
			table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(sp));
			try {
				QtychangeImapct(value, row);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			// System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 1);
			try {
				QtychangeImapct(value, row);
			} catch (Throwable e2) {
				e2.printStackTrace();
				new gnLogger().loggerInfoEntry("POS", "Edit Qty or Rate->:" + " " + e2.getLocalizedMessage());
			}
			// String vbatchcontrol = (String) table.getValueAt(row, 12);
			try {
			} catch (Throwable e1) {
				new General().msg(e1.getMessage());
				e1.printStackTrace();
				new gnLogger().loggerInfoEntry("POS", "Edit Qty->:" + " " + e1.getLocalizedMessage());
			}
		}
	};

	public void showSearch(String SQL, String[] Colnames) throws Throwable {
		new gnTable().RemoveTableRows(smodel);
		stable = new gnTableModel().Tablemodel10(stable, smodel, SQL, Colnames, 10, "N", "N", "N");
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
					new General().msgsearch(sjsp, stable, "Select  Sales Price  ", 1000, 400);
					new gnLogger().loggerInfoEntry("POS", "Sales Price Popup Window Activated");
				}
				break;
			case "Y":
				new General().msgsearch(sjsp, stable, "Select Batch ", 1000, 500);
				new gnLogger().loggerInfoEntry("POS", "Batch Selection  Popup Window Activated");
				break;
			}
		}
	}// End Search Table

	public CellEditorListener ChangeNotification2 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
		}

		public void editingStopped(ChangeEvent e) {
			int row = stable.getSelectedRow();
			String vtype = (String) stable.getValueAt(row, 0);
			String varticle = (String) stable.getValueAt(row, 1);
			try {
				displayInfo(vtype, row);
				QtychangeImapct(varticle, selectedrow);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	};

	public void displayInfo(String vtype, int row) {
		// new General().msg(vtype);
		String vmrp = " ";
		String vcost = " ";
		String vsp = " ";
		String vexpdate = " ";
		String vmanufdate = " ";
		String vbatchno = " ";
		switch (vtype) {
		case "Y":
			vcost = (String) stable.getValueAt(row, 3);
			vsp = (String) stable.getValueAt(row, 4);
			vmrp = (String) stable.getValueAt(row, 5);
			vbatchno = (String) stable.getValueAt(row, 6);
			vmanufdate = (String) stable.getValueAt(row, 7);
			vexpdate = (String) stable.getValueAt(row, 8);
			table.setValueAt(vbatchno, selectedrow, 13);
			table.setValueAt(vexpdate, selectedrow, 14);
			table.setValueAt(vcost, selectedrow, 15);
			table.setValueAt(vmrp, selectedrow, 5);
			table.setValueAt(vsp, selectedrow, 4);
			new gnTable().RemoveTableRows(smodel);
			scanItem_2.grabFocus();
			new General().msgDispose();
			new gnLogger().loggerInfoEntry("POS", "Setting Batch Details in Sales Row in Table");
			break;
		case "N":
			vcost = (String) stable.getValueAt(row, 3);
			vsp = (String) stable.getValueAt(row, 4);
			vmrp = (String) stable.getValueAt(row, 5);
			vbatchno = (String) stable.getValueAt(row, 6);
			vmanufdate = (String) stable.getValueAt(row, 7);
			vexpdate = (String) stable.getValueAt(row, 8);
			table.setValueAt(vbatchno, selectedrow, 13);
			table.setValueAt(vexpdate, selectedrow, 14);
			table.setValueAt(vcost, selectedrow, 15);
			table.setValueAt(vmrp, selectedrow, 5);
			table.setValueAt(vsp, selectedrow, 4);
			new gnTable().RemoveTableRows(smodel);
			scanItem_2.grabFocus();
			new General().msgDispose();
			new gnLogger().loggerInfoEntry("POS", "Setting New Seleced Price Details  in Sales Row in Table");
			break;
		}
	}

	public String checkArticleExist(String value) {
		new gnLogger().loggerInfoEntry("POS", "Checking in Table Article is Exist or not");
		int rowCount = 0;
		int i = 0;
		action = "Insert";
		rowCount = table.getRowCount();
		String Colname = "";
		for (i = 0; i < rowCount; i++) {
			Colname = table.getValueAt(i, 1).toString();
			if (Colname.equalsIgnoreCase(value)) {
				String curqty1 = (String) table.getValueAt(i, 3).toString();
				double curqty = Double.parseDouble(curqty1);
				double newqty = curqty + 1.0;
				table.setValueAt(newqty, i, 3);
				try {
					QtychangeImapct(value, i);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
		return action;
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
		new gnLogger().loggerInfoEntry("POS", "Remove Item From Sales Table  ");
		Del.setCellRenderer(new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Del.setCellEditor(new DefaultCellEditor(chkbox));
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
								new gnLogger().loggerInfoEntry("POS", "Remove Item From Sales Table  Row" + " " + r);
							}
							modelName.removeRow(r);
							Double v = new gnTable().getTotal(table, 10);
							Tamount.setText(Double.toString(v));
							int vcount = table.getRowCount();
							records.setText(Integer.toString(vcount));
							new gnLogger().loggerInfoEntry("POS",
									"Recalculating Billing Data After Row Remove Row No" + " " + r);
							calHdrDisocunt();
							new gnLogger().loggerInfoEntry("POS", "Article Billing Process Over");
							scanItem_2.grabFocus();
						}
					}
					return;
				}
				if (modelName == pmodel && nn == 2) {
					int option = new General().msgInput(" Payment Row Will be Deleted Are You Sure ?");

					if (option == 0) {
						int q = tableName.getSelectedRow();
						modelName.removeRow(q);
						try {
							ReCalculatePayment();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}
					return;
				}
				return;
			}
		});
		// 4sf7sf7up5 password for sharing file and pr
		// Del.setCellEditor(new DefaultCellEditor(chkbox));
	}

	private void setBtnCurrency(String name) {
		btnINR1.setText(name);
		btnINR2.setText(name);
		btnINR3.setText(name);
		btnINR4.setText(name);
		btnINR5.setText(name);
		btnINR6.setText(name);
		btnINR7.setText(name);
	}

	//// Customer Search Start here
	public void Search(String sqlsearch, String[] Col) throws SQLException, ClassNotFoundException {
		new gnTable().RemoveTableRows(smodel);
		stable = new gnTableModel().Tablemodel4(stable, smodel, sqlsearch, Col, 4, "N", "N", "N");
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(stable)));
		stable.setEnabled(true);
		stable.setCellSelectionEnabled(false);
		stable.setRowSelectionAllowed(true);
		stable.setBackground(Color.WHITE);
		stable.setSelectionBackground(Color.CYAN);
		DefaultCellEditor nk = new gnTable().cellEdit(stable);
		nk.addCellEditorListener(ChangeNotification3);
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer Search View");
		prt6.setScrollMode(0);
		prt6.add(stable, Col);
		sjsp.setViewport(prt6);
		new General().msgsearch(sjsp, stable, "Select Customer Code", 800, 300);
		new gnLogger().loggerInfoEntry("POS", "Selecting New Customer");

	}

	public CellEditorListener ChangeNotification3 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			// System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = stable.getSelectedRow();
			String value = (String) stable.getValueAt(row, 0);
			showCustData();
		}
	};

	public void showCustData() {
		int row = stable.getSelectedRow();
		String vcustcode = (String) stable.getValueAt(row, 0);
		String vcustname = (String) stable.getValueAt(row, 1);
		String vcustmobile = (String) stable.getValueAt(row, 2);
		String vcustemail = (String) stable.getValueAt(row, 3);
		custid.setText(vcustcode);
		custname.setText(vcustname);
		mobile.setText(vcustmobile);

		new gnTable().RemoveTableRows(smodel);
		new General().msgDispose();
		new gnLogger().loggerInfoEntry("POS", "Customer Search Over");

	}
	//// End Customer Name SEarch

	/// Item Name SEarch Related
	public void ASearch(String sqlsearch, String[] Col, String vtype) throws SQLException, ClassNotFoundException {
		// new General().msg(sqlsearch);
		new gnTable().RemoveTableRows(nmodel);
		ntable = new gnTableModel().Tablemodel(ntable, nmodel, sqlsearch, Col, 4, "N", "Y", vtype);
		ntable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification4);
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(ntable)));
		ntable.setEnabled(true);
		ntable.setCellSelectionEnabled(false);
		ntable.setRowSelectionAllowed(true);
		ntable.setGridColor(Color.gray);
		// prt6.setToolTipText("Article Scrollpane Port");
		prt6.add(ntable, Col);
		prt6.setVisible(true);
		sjsp.setViewport(prt6);
		new General().msgsearch(sjsp, ntable, "Select Article", 800, 500);
	}

	public CellEditorListener ChangeNotification4 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			// System.out.println("The user canceled editing.");
			ntable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification4);

		}

		public void editingStopped(ChangeEvent e) {
			int row = ntable.getSelectedRow();
			String value = ntable.getValueAt(row, 0).toString().trim();
			try {
				showArticle(value, row);
				new General().msgDispose();
			} catch (Throwable e1) {
				e1.printStackTrace();
				new General().msg("ShowArticle" + " " + e1.getMessage());
			}
		}
	};

	public void showArticle(String value, int row) throws Throwable {
		switch (value) {
		case "Article":
			String varticle = (String) ntable.getValueAt(row, 1);
			new gnTable().RemoveTableRows(nmodel);
			new General().msgDispose();
			// ntable.notifyAll();
			showTableData(varticle, model);
			break;
		case "CN":
			ptable.setValueAt(ntable.getValueAt(row, 3), nrow, 2);
			ptable.setValueAt(ntable.getValueAt(row, 1), nrow, 3);
			new gnTable().RemoveTableRows(nmodel);
			CalculatePayment();
			break;
		}
	}
	/// End Item Search Here

	public String Validate() {
		String Action = "Sucess";

		String Action1 = new gnTable().isAmountnegative(netAmount.getText());
		String Action2 = new gnTable().istableColValueNegative(table, 3);
		String Action3 = new gnTable().istableColValueNegative(table, 4);
		if (Action1 == "Fail" || Action2 == "Fail" || Action3 == "Fail") {
			Action = "Fail";
			new gnLogger().loggerInfoEntry("POS", "Bill Data Valiadtion for Value Negative found ...");
		}
		return Action;

	}

	public String ValidateItemEntry() {
		String Action = "Sucess";

		// String Action1 = new gnTable().isAmountnegative(netAmount.getText())
		// ;
		String Action2 = new gnTable().istableColValueNegative(table, 3);
		String Action3 = new gnTable().istableColValueNegative(table, 4);
		if (Action2 == "Fail" || Action3 == "Fail") {
			Action = "Fail";
			new gnLogger().loggerInfoEntry("POS", "Bill Data Valiadtion for Item Value Negative found ...");
		}
		return Action;
	}

	/// Start Data Saving Process Here
	public void pickDataForInsert() throws Throwable {
		String status = Validate();
		if (status == "Sucess") {
			CalculatePayment();
			calHdrDisocunt();
			dues = Double.parseDouble(Final_Damt.getText().toString());
			int Tamt = Integer.parseInt(netAmount.getText().toString());
			int FTamt = Integer.parseInt(Final_Tamt.getText().toString());
			VAccountPostingAmount = Final_Tamt.getText();
			if (!(dues <= 0.00 && (Tamt == FTamt))) {
				new General().msg("Please Check Sales and Payment ");
				return;
			}
			if (dues <= 0 && (Tamt == FTamt))

				// new General().msg("Processing Payment Save Action") ;
				DBaction = "DBFail";
			vvsitecode = Site_code.getText();
			vvcompnaycode = vcomp;
			vterminal = Integer.parseInt(terminalID.getText());

			switch (invoiceMode) {
			case "I":
				invno.setText(new gnSeq().getSeqno("5", "TR"));
				new gnLogger().loggerInfoEntry("POS", "New Bill no Generated For Sales ..." + " " + invno.getText());
				vglcode = new gnSeq().getGlcode("5", "TR");
				break;
			case "E":
				vglcode = new gnSeq().getGlcode("5", "TR");
				break;
			}

			// new General().msg(vglcode);
			new General().Quickmsg("Invoice number is " + invno.getText());
			vvinvno = Integer.parseInt(invno.getText());
			Svinvdate = new gnConfig().date_ConverttoDBforamt(invdate.getText());
			vvcashiercode = cashiercode.getText();
			vvsales_type = "PS";
			vverticle = new gnHierarchy().getVerticleCode();
			vvinvoice_type = "RI";
			vvposting_type = "Y";
			vvcustid = Integer.parseInt(custid.getText());
			vshift = Integer.parseInt(shift.getText());
			vvggross = 0.00;
			vvdisc = 0.00;
			vvnet = Double.parseDouble(Final_Tamt.getText());
			this.closeconn();

			// GST
			vmygstno = new gnGST().getComanyGSTno();
			vmycompanystate = new gnGST().getmyState();
			vmystatename = new gnGST().getmystatename();
			vmyCompanyisGST = new gnGST().ismyComanyGSTRegister();

			vstate = new gnGST().getCustomerState(custid.getText());
			vstatename = new gnGST().getCustomerStatename(custid.getText());
			vregdlr = new gnGST().isCustmoerGSTRegister(custid.getText());
			vcustGSTno = new gnGST().getCustomerGSTNO(custid.getText());

			if (custid.getText() == "0") {
				vstate = vmycompanystate;
			}

			// vstate = vstate.trim() ;
			vmycompanystate = vmycompanystate.trim();

			int vmy = Integer.parseInt(vmycompanystate);

			if ((vmy - voth == 0)) {
				vmovtype = "Intra-State";
			}

			if ((vmy - voth != 0)) {
				vmovtype = "Inter-State";
			}
			// End GST Field

			// Start Inserting Data Now

			switch (invoiceMode) {
			case "I":
				insertPosDetails();
				break;
			case "E":
				new gnLogger().loggerInfoEntry("POS", "POS Edit Bill :" + invno.getText() + "Start Inserting");
				String vinvtype = "PS";
				new gnEDMiddleWare().SalesModification(vinvtype, invno.getText(), invdate.getText());
				insertPosDetails();
				new gnLogger().loggerInfoEntry("POS", "POS Edit Bill Completer for invno:" + invno.getText());
				break;
			}
		}
	}

	//// pos Details Start here
	public void insertPosDetails() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		String DBdetail = "Fail";
		String poshdr = "Insert into pos_sales_detail (company_code ," + "site_code, " + " invDate ," + "invno,"
				+ "Article_code ," + "EAN ," + "customer_code ," + "qty," + "sales_price," + "MRP," + "Taxcode,"
				+ "Gross_amount, " + "Disc," + "hdr_disc ," + "net_amount , " + "Tax_amount , " + "Promo_ind,"
				+ "promo_code," + "line_seq," + "CreatedBy, " + "Insert_status," + " Cashier_code, " // 22
				+ "Terminal_ID, shift , srno, tax_per, sales_type , "
				+ "batch_article, Batch_no, Expiry_date, cost, verticle, location ,"
				+ "state, statename, regdealer, mycompanyisgst, mygstno, mycompState, custGSTno , cgst, sgst, igst , movementType, "
				+ "TaxableValue, mystatename, finyear , cogs)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,  ?,?,?,?,?,?,? ,?,?, ?,?,?,?,?,?) ";

		prst = con1.prepareStatement(poshdr);
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				pd_seq = k + 1;
				prst.setString(1, vvcompnaycode);
				prst.setString(2, vvsitecode);
				prst.setString(3, Svinvdate);
				prst.setInt(4, vvinvno);
				prst.setString(5, table.getValueAt(k, 1).toString());
				prst.setString(6, "0");
				prst.setInt(7, vvcustid);
				prst.setString(8, (table.getValueAt(k, 3).toString()));
				prst.setDouble(9, Double.parseDouble(table.getValueAt(k, 4).toString()));
				prst.setDouble(10, Double.parseDouble(table.getValueAt(k, 5).toString()));
				prst.setString(11, (table.getValueAt(k, 11).toString()));
				prst.setDouble(12, Double.parseDouble(table.getValueAt(k, 6).toString()));
				prst.setDouble(13, Double.parseDouble(table.getValueAt(k, 8).toString()));
				prst.setDouble(14, Double.parseDouble(table.getValueAt(k, 7).toString()));
				prst.setDouble(15, Double.parseDouble(table.getValueAt(k, 10).toString()));
				// Double vtaxamt =
				// (Double.parseDouble(table.getValueAt(k,10).toString())*4/100)
				// ;
				prst.setDouble(16, Double.parseDouble(table.getValueAt(k, 9).toString()));
				prst.setString(17, "N");
				prst.setString(18, "N");
				prst.setInt(19, pd_seq);
				prst.setString(20, vvcashiercode);
				prst.setString(21, "Y");
				prst.setString(22, vvcashiercode);
				prst.setInt(23, vterminal);
				prst.setInt(24, vshift);
				prst.setInt(25, k);
				prst.setString(26, table.getValueAt(k, 11).toString());
				prst.setString(27, vvsales_type);
				prst.setString(28, table.getValueAt(k, 12).toString());
				prst.setString(29, table.getValueAt(k, 13).toString());
				prst.setString(30, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 14).toString()));

				// String vproductrcost =
				// table.getModel().getValueAt(k,15).toString();
				String vproductrcost = table.getValueAt(k, 15).toString();
				// if (Double.parseDouble(vproductrcost) == 0.00);
				// {
				// vproductrcost = table.getValueAt(k,4).toString() ;
				// }

				// prst.setString(31,
				// table.getModel().getValueAt(k,15).toString()); //Hide cost
				// column value Insert
				prst.setString(31, vproductrcost); // Hide cost column value
													// Insert

				prst.setString(32, vverticle);
				prst.setString(33, "SL");

				prst.setString(34, vstate);
				prst.setString(35, vstatename);
				prst.setString(36, vregdlr);
				prst.setString(37, vmyCompanyisGST);
				prst.setString(38, vmygstno);
				prst.setString(39, vmycompanystate);
				prst.setString(40, vcustGSTno);

				if ((vmy - voth == 0)) {
					// DecimalFormat twodigit = new
					// DecimalFormat("###########.00");
					Double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 9).toString());
					double vcgst = vcaltaxamt / 2;
					double vsgst = vcaltaxamt / 2;
					double vigst = 0.00;

					prst.setString(41, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
					prst.setString(42, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
					prst.setString(43, new gnMath().get2DecimaltValue(Double.toString(vigst)));
					prst.setString(44, vmovtype);
				}

				if ((vmy - voth != 0)) {
					double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 9).toString());
					double vcgst = 0.00;
					double vsgst = 0.00;
					double vigst = vcaltaxamt;
					prst.setString(41, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
					prst.setString(42, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
					prst.setString(43, new gnMath().get2DecimaltValue(Double.toString(vigst)));
					prst.setString(44, vmovtype);
				}
				double vtaxablevalue = 0;
				double vnet = 0.0;
				double vtxamt;
				vnet = Double.parseDouble(table.getValueAt(k, 10).toString());
				vtxamt = Double.parseDouble(table.getValueAt(k, 9).toString());
				vtaxablevalue = vnet - vtxamt;
				prst.setString(45, new gnMath().get2DecimaltValue(Double.toString(vtaxablevalue)));
				prst.setString(46, vmystatename);
				prst.setString(47, new gnFinYear().getCurrentFinYear(invdate.getText()));

				// cogs

				double vtaxper = Double.parseDouble(table.getValueAt(k, 11).toString());
				double vcost = Double.parseDouble(table.getValueAt(k, 15).toString());
				double vqty = Double.parseDouble(table.getValueAt(k, 3).toString());
				// Double vcostvalue = vqty * vcost ;
				Double vcogs = new gnMath().CalTax_Pur(vcost, vtaxper);
				Double vcostvalue = vcost - vcogs;
				vcostvalue = vqty * vcostvalue;
				prst.setString(48, Double.toString(vcostvalue));

				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				vvggross = vvggross + Double.parseDouble(table.getValueAt(k, 6).toString());
				vvdisc = vvdisc + (Double.parseDouble(table.getValueAt(k, 7).toString())
						+ Double.parseDouble(table.getValueAt(k, 8).toString()));
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
			new General().msg(e.getLocalizedMessage());
			con1.rollback();
			new gnLogger().loggerDebugEntry("POS", "Detail  ===>>." + " " + e.getMessage() + "InvNo:" + "" + vvinvno);
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {
				new gnLogger().loggerDebugEntry("POS",
						"Detail  ===>>." + " " + "Save Sucessfully " + "InvNo:" + "" + vvinvno);
				insertPosHdr();
				// new General().msg(" Inserting Header Now.3.");
			}
		}
	}

	public void insertPosHdr() throws Throwable {
		new gnLogger().loggerDebugEntry("POS", "Header data Start Inserting " + "InvNo:" + "" + vvinvno);
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con2 = this.getConnection();
		con2.setAutoCommit(false);
		String Status = "Fail";
		String poshdr = "Insert into pos_sales_hdr(company_code , " + "site_code, terminal_id ,  invno,   invDate ,  "
				+ "cashier_code, sales_type," + " Invoice_type, Posting_type, Gross_Amount,"
				+ " Discount, Net_Amount, customer_code, shift, verticle, time, RoundingAmt , "
				+ "state, statename, regdealer, mycompanyisgst, mygstno, mycompState, custGSTno,"
				+ " movementtype , mystatename,glcode, updatedate, updateby, fineyear, doctor_code, patient_name, patient_phone, Doctor_name)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,? , ?,? ,?,?,?,?,?,?,?,?)";
		try {
			prst = con2.prepareStatement(poshdr);
			prst.setString(1, vvcompnaycode);
			prst.setString(2, vvsitecode);
			prst.setInt(3, vterminal);
			prst.setInt(4, vvinvno);
			prst.setString(5, Svinvdate);
			prst.setString(6, vvcashiercode);
			prst.setString(7, vvsales_type);
			prst.setString(8, vvinvoice_type);
			prst.setString(9, vvposting_type);
			prst.setDouble(10, vvggross);
			prst.setDouble(11, vvdisc);
			prst.setDouble(12, vvnet);
			prst.setInt(13, vvcustid);
			prst.setInt(14, vshift);
			prst.setString(15, vverticle);
			prst.setString(16, new General().getTime());
			prst.setString(17, froundAmt.getText());
			prst.setString(18, vstate);
			prst.setString(19, vstatename);
			prst.setString(20, vregdlr);
			prst.setString(21, vmyCompanyisGST);
			prst.setString(22, vmygstno);
			prst.setString(23, vmycompanystate);
			prst.setString(24, vcustGSTno);
			prst.setString(25, vmovtype);
			prst.setString(26, vmystatename);
			prst.setString(27, vglcode);
			prst.setString(28, Svinvdate);
			prst.setString(29, vvcashiercode);
			prst.setString(30, new gnFinYear().getCurrentFinYear(invdate.getText()));
			prst.setString(31, vdoccode);
			prst.setString(32, patientName.getText());
			prst.setString(33, "0");
			prst.setString(34, docname.getText());
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBhdr = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBhdr = "Sucess";
			new gnLogger().loggerDebugEntry("POS", "Header data Start Inserting " + "InvNo:" + "" + vvinvno);

		} catch (SQLException e) {
			new gnLogger().loggerDebugEntry("POS", "Header " + "InvNo:" + "" + vvinvno + " " + e.getMessage());
			con2.rollback();
			new gnLogger().loggerDebugEntry("POS", "Header " + "InvNo:" + "" + vvinvno + "RollBack Data ");
			DBhdr = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") { // new General().msg("Hdr and Detail are
										// Sucessfull now commiting..4");
				con1.commit();
				con2.commit();
				con1.close();
				con2.close();
				new gnLogger().loggerDebugEntry("POS", "Header  & Detail Data Inserted" + "InvNo:" + "" + vvinvno);
				// calculateGSTReturnData() ;
				boolean deliveryRequired = homeDelivery.isSelected();
				if (deliveryRequired) {
					insertHomeDelivery();
				}
				paymentCollection();
				calculateGSTReturnData();

			}
		}
	}//// Insert Heade End

	private void insertHomeDelivery() throws SQLException, ClassNotFoundException, IOException {
		new gnLogger().loggerDebugEntry("POS", "Home Delivery Details  Data Inserting" + "InvNo:" + "" + vvinvno);
		boolean deliveryRequired = homeDelivery.isSelected();
		if (deliveryRequired) {
			DBaction = "Fail";
			String mode = " ";
			prst = null;
			final int batchSize = 1;
			int TotalRecordinsert = 0;
			con8 = this.getConnection();
			con8.setAutoCommit(false);
			String Status = "Fail";
			String pospayment = "Insert into     home_delivery(company_code , "
					+ "site_code,  invdate ,  invno,        invAmount ,"
					+ " Reg_cust_code,  Phone,  Cust_Name , Addr1 ,  addr2 ,  addr3,     status , cashier, bill_time ) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			prst = con8.prepareStatement(pospayment);
			try {
				prst.setString(1, vvcompnaycode);
				prst.setString(2, vvsitecode);
				prst.setString(3, Svinvdate);
				prst.setInt(4, vvinvno);
				prst.setDouble(5, vvnet);
				prst.setInt(6, vvcustid);
				prst.setString(7, hm_Phone.getText());
				prst.setString(8, hm_custname.getText());
				prst.setString(9, hm_addr1.getText());
				prst.setString(10, hm_addr2.getText());
				prst.setString(11, hm_addr3.getText());
				prst.setString(12, "Pending");
				prst.setString(13, vvcashiercode);
				prst.setString(14, new General().getTime());

				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					con8.commit();
					DBaction = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				con8.commit();
				DBaction = "Sucess";
			} catch (SQLException e) {
				new General().msg("Home Delivery=>" + e.getMessage());
				new gnLogger().loggerDebugEntry("POS",
						"Home Delivery Exception" + "InvNo:" + "" + vvinvno + "" + e.getMessage());
				con8.rollback();
				DBaction = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
					new gnLogger().loggerDebugEntry("POS", "Home Delivery Data Inserted" + "InvNo:" + "" + vvinvno);
				}
				if (con8 != null) {
					con8.close();
				}
			}
		}
	}

	// Payment Insert
	public void paymentCollection() throws Throwable {
		new gnLogger().loggerDebugEntry("POS", "Payment Data Inserting" + "InvNo:" + "" + vvinvno);
		statusCC = "Sucess";
		statusCA = "Sucess";
		statusCN = "Sucess";
		String mystatus = "Sucess";

		int row = ptable.getRowCount();
		String mode = " ";
		Double vcash = 0.00;
		Double vcc = 0.00;
		String pmcash = "Cash";
		String pmCC = "Card";
		String pmCN = "CN";
		String pmCheque = "Cheque";
		String pmDD = "DD";
		String pmGV = "GV";
		String pmCoup = "Coupen";

		String refcol = "";

		int vsrno = 0;
		int vsrno1 = 0;

		// ==Cash Processing End
		for (int i = 0; i < row; i++) {
			mode = ptable.getValueAt(i, 1).toString().trim();
			switch (mode) {
			case "Cash":
				vcash = vcash + (Double.parseDouble(ptable.getValueAt(i, 2).toString()));
				break;
			}
		}

		if (vcash > 0) {
			vcash = vcash + dues;
			refcol = "";
			statusCA = insertPayment(pmcash, vcash, 0, vsrno, refcol);

		}
		// ===Cash Processing End

		// Credit Card
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim();
			switch (mode) {
			case "Card":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				refcol = ptable.getValueAt(i, 4).toString().trim();
				statusCC = insertPayment(pmCC, vcc, vno, vsrno1, refcol);
				break;
			}
		}

		// End Insert Credit Card

		// Cheque
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim();
			switch (mode) {
			case "Cheque":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				refcol = ptable.getValueAt(i, 4).toString().trim();
				mystatus = insertPayment(pmCheque, vcc, vno, vsrno1, refcol);
				break;
			}
		}
		// End Insert Cheque

		// Coupen
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim();
			switch (mode) {
			case "Coupen":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				refcol = ptable.getValueAt(i, 4).toString().trim();
				mystatus = insertPayment(pmCoup, vcc, vno, vsrno1, refcol);
				break;
			}
		}
		// End Insert Coupen

		// GV
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim();
			switch (mode) {
			case "GV":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				refcol = ptable.getValueAt(i, 4).toString().trim();
				mystatus = insertPayment(pmGV, vcc, vno, vsrno1, refcol);
				break;
			}
		}
		// End Insert GV

		// DD
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim();
			switch (mode) {
			case "DD":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				refcol = ptable.getValueAt(i, 4).toString().trim();
				mystatus = insertPayment(pmDD, vcc, vno, vsrno1, refcol);
				break;
			}
		}
		// End Insert DD

		// Credit Note consume - Update Payment_dncn_master Table
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim();
			switch (mode) {
			case "Credit Note":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				refcol = ptable.getValueAt(i, 4).toString().trim();
				statusCN = insertPayment(pmCN, vcc, vno, vsrno1, refcol);
				new General().msg("CN  Inserted in Payment Table" + statusCN);
				if (statusCN == "Sucess") {
					String vrefdocno = invno.getText();
					String vinvdate = Svinvdate;
					String vreftrantype = "5";
					String vtype = "CN";
					String vcustid = custid.getText();
					String vdocno = (String) ptable.getValueAt(i, 3);
					Double vcnamount = vcc;
					String vamt = Double.toString(vcnamount);
					new General().msg("updating CN  is  " + vdocno);
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
		new gnLogger().loggerDebugEntry("POS", "Invoice Audit is in Progress" + "InvNo:" + "" + vvinvno);
		DBaction = new gnConfig().invoiceaudit(vvinvno);
		if (DBaction == "Fail") {
			new gnImageSound().playAlertSound();
			new gnLogger().loggerDebugEntry("POS",
					"POs Table data not inserted properly..invoice audit Fails" + "InvNo:" + "" + vvinvno);
		}
		if (DBaction == "Sucess") {
			new gnLogger().loggerDebugEntry("POS", "Invoice audit Sucess For" + "InvNo:" + "" + vvinvno);
			switch (invoiceMode) {
			case "I":
				new gnSeq().updateSeqno("5", "TR");
				new gnLogger().loggerDebugEntry("POS", "POS invoice Seq.Number Updated");
				break;
			case "E":
				break;
			}
			btn_print.doClick();
			pmt.setVisible(true);
			pmtPanel.setVisible(false);
			scanItem_2.grabFocus();
			scanItem_2.setText(null);
			new gnTable().RemoveTableRows(nmodel);
			new gnTable().RemoveTableRows(pmodel);
			new gnTable().RemoveTableRows(model);
			new gnTable().RemoveTableRows(smodel);
			initiateNewBill();
			btn_Save.setEnabled(false);
		}
	}

	private String insertPayment(String vpmode, Double vamount, int vno, int i, String vrefcol) throws Throwable {
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
		String Status = "Fail";
		String pospayment = "Insert into  pos_Payments(company_code , " + "site_code,   invdate ,  invno,  "
				+ "cashier_code,   terminal_id , Payment_mode, Amount," + "Advance_Payment_Ind , TransactionType, "
				+ " Invoice_type, sales_type, Posting_type , currency, shift, srno, card_number, verticle, finyear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		prst = con.prepareStatement(pospayment);
		try {
			prst.setString(1, vvcompnaycode);
			prst.setString(2, vvsitecode);
			prst.setString(3, Svinvdate);
			prst.setInt(4, vvinvno);
			prst.setString(5, vvcashiercode);
			prst.setInt(6, vterminal);
			prst.setString(7, vpaymentmode);
			prst.setDouble(8, vpaymentamount);
			prst.setString(9, "N");
			prst.setString(10, "5");
			prst.setString(11, vvinvoice_type);
			prst.setString(12, vvsales_type);
			prst.setString(13, vvposting_type);
			prst.setString(14, "INR");
			prst.setInt(15, vshift);
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
			new gnLogger().loggerDebugEntry("POS", "Payment Data Insert Errot ===>>." + " " + e.getMessage());
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
		String vstore = vvsitecode;
		String vdate = Svinvdate;
		String vfinyear = new gnFinYear().getReportingFinYear();
		new gnLogger().loggerDebugEntry("POS", "Sales Inventroy Impact Calculation Starts");
		// New Procedure used now remove old logic of update inventpory
		// new General().msg("Reducing with new Logic ,,,now ");
		String vtrntype = "Sale";
		String SQL = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vvinvno + " , '"
				+ Svinvdate + "' , '" + vfinyear + "')";
		// new General().msg(SQL);
		this.getSPResult(SQL);
		// End Logic Change

		// New Procedure used now remove old logic of update inventpory
		// new General().msg("Reducing with new Logic ,,,now ");
		String vtrntype1 = "Sale";
		String SQL1 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   " + vvinvno
				+ " , '" + Svinvdate + "' ,  '" + vfinyear + "')";
		// new General().msg(SQL1);
		this.getSPResult(SQL1);
		// End Logic Change
		new gnLogger().loggerDebugEntry("POS", "Sales Data Inventroy Calculation Complete");
		return Action;
	}

	//// For Resto POS Features/////
	public void showBusyTables() throws Throwable {
		String i = "";
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL2 = "call resto_getDistinctActiveTable(" + vcomp + ", " + vstore + ")";
		rs = this.getSPResult(SQL2);
		while (rs.next()) {
			i = rs.getString(1);
			TableColor(i);
		}
	}

	class CombTbl implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String vtable = comboTable.getSelectedItem().toString();
			try {
				getTableEntry();
				checkTableStatus(vfloor, vtabletype, vsplit, vtableno);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	public void getTableEntry() {
		vtableno = comboTable.getSelectedItem().toString();
		vsplit = comboSplit.getSelectedItem().toString();
		vtabletype = comboTtype.getSelectedItem().toString();
		vfloor = comboFloor.getSelectedItem().toString();
	}

	private void getCurrentTableInfo() {
		cfloor = floor.getText();
		ctableno = tableno.getText();
		csplit = split.getText();
		ctabletype = tabletype.getText();
	}

	private void ShowTableInfo() {
		getTableEntry();
		floor.setText(vfloor);
		tableno.setText(vtableno);
		split.setText(vsplit);
		tabletype.setText(vtabletype);
	}

	private String checkTableStatus(String vfloor, String vtabletype, String vsplit, String vtableno) throws Throwable {
		String status = "NA";
		getTableEntry();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call    resto_getTableinfo(" + vfloor + " , '" + vtabletype + "' , '" + vsplit + "' , " + vtableno
				+ ", " + vcomp + ", " + vstore + " )";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			status = "Free";
			int currow = table.getRowCount();
			if (currow > 0) {
				new General().msg("Save Current Order");
			} else {
				ShowTableInfo();
			}
		}
		return status;
	}

	// nitin
	class UnholdLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (POS == "0") {
				new General().msg("Select Table From Below Table List ..");
				return;
			}
			if (POS == "1") {
				try {
					new gnBillUnhold().getHoldBill();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				String custcode = new gnBillUnhold().vcustcode;
				String custname = new gnBillUnhold().vcustomer;
				String vamt = new gnBillUnhold().vamount;
				tokenno.setText(new gnBillUnhold().vtokeanno);
				new gnBillUnhold().vcustomer = " ";
				new gnBillUnhold().vcustcode = " ";
				new gnBillUnhold().vamount = " ";
				String vcomp;
				try {
					vcomp = new gnConfig().getCompanyCode();
					String vstore = new gnConfig().getStoreID();
					String SQL = "Call resto_DisplayHoldBill( " + vcomp + "  , " + vstore + "  , '" + custname
							+ "' ,  '" + vamt + "')";
					rs = new getResultSet().getSPResult(SQL);
					showTableOrder(rs);
					removeholdBill();
				} catch (Throwable e1) {
					new General().msg("Unhold Bill -->" + " " + e1.getLocalizedMessage());
					e1.printStackTrace();
				}
			}
		}
	}

	private void removeholdBill() {
		switch (POS) {
		case "1":
			String SQL1 = "Call  RemoveHoldBill('" + vtokenno + "')";
			try {
				this.getSPResult(SQL1);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	class holdLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				switch (POS) {
				case "0":
					if (tableno.getText() == "0") {
						new General().msg("Select Table No. First");
						return;
					} else {
						saveTempOrder();
					}
					break;

				case "1":
					String vstatus = validatetoken();
					if (vstatus == "Sucess") {
						saveTempOrder();
					}
					break;
				}
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				try {
					// vtokenno = new IssueToken().vtokenno ;
					// saveTempOrder();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private String validatetoken() {
		String status = "Sucess";

		if (tokenno.getText().length() <= 0) {
			status = "Fail";
			new General().msg("Enter Token Number ..");
			tokenno.grabFocus();
		}
		return status;

	}

	// nitin
	public void saveTempOrder() throws Throwable {
		new General().Quickmsg("Saving Bill Data..");
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vtokenno = tokenno.getText();
		int vrow = table.getRowCount();
		if (vrow > 0) {
			if (POS == "0") {
				getCurrentTableInfo();
			}
			prst = null;
			final int batchSize = 10;
			int TotalRecordinsert = 0;
			Connection con = this.getConnection();
			con.setAutoCommit(false);
			String Status = "Fail";
			String poshdr = "Insert into resto_tableorders (floor ," + "table_type,   tableno ,  splittable, "
					+ "Item, name , qty ," + " rate, mrp  ,  gross ," + " hdrdisc, disc , tax ,"
					+ " amount, tax_code,  batchitem," + "Batchno, Expdate, cost, custcode,"
					+ " custname, postype , company_code, site_code," + " phone, email, token ,  TotalAmount )"// total
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
			prst = con.prepareStatement(poshdr);
			try {
				int row = table.getRowCount();
				for (int k = 0; k < row; k++) {
					pd_seq = k + 1;
					prst.setString(1, cfloor);
					prst.setString(2, ctabletype);
					prst.setString(3, ctableno);
					prst.setString(4, csplit);
					prst.setString(5, table.getValueAt(k, 1).toString());
					prst.setString(6, table.getValueAt(k, 2).toString());
					prst.setString(7, table.getValueAt(k, 3).toString());
					prst.setString(8, table.getValueAt(k, 4).toString());
					prst.setString(9, table.getValueAt(k, 5).toString());
					prst.setString(10, table.getValueAt(k, 6).toString());
					prst.setString(11, table.getValueAt(k, 7).toString());
					prst.setString(12, table.getValueAt(k, 8).toString());
					prst.setString(13, table.getValueAt(k, 9).toString());
					prst.setString(14, table.getValueAt(k, 10).toString());
					prst.setString(15, table.getValueAt(k, 11).toString());
					prst.setString(16, table.getValueAt(k, 12).toString());
					prst.setString(17, table.getValueAt(k, 13).toString());
					prst.setString(18, table.getValueAt(k, 14).toString());
					prst.setString(19, table.getModel().getValueAt(k, 15).toString());
					prst.setString(20, custid.getText());
					prst.setString(21, custname.getText());
					prst.setString(22, POS);
					prst.setString(23, vcomp);
					prst.setString(24, vstore);
					prst.setString(25, mobile.getText());
					prst.setString(26, " ");
					prst.setString(27, vtokenno);
					prst.setString(28, Tamount.getText());
					prst.addBatch();
					TotalRecordinsert = TotalRecordinsert + 1;
					if (TotalRecordinsert % batchSize == 0) {
						int[] recordws = prst.executeBatch();
						con.commit();
						DBaction = "DBSucess";
					}
					int[] ff = prst.executeBatch(); // insert remaining records
					con.commit();
				}
			} catch (SQLException e) {
				// System.out.println(e.getMessage());
				con.rollback();
				DBaction = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
					new gnTable().RemoveTableRows(model);
					if (POS == "0") {
						TableColor(ctableno);
					}
					Tamount.setText("0.00");
					netAmount.setText("0.00");
					tokenno.setText(null);
				}
				if (con != null) {
					con.close();
				}
			}
		} else {
			new General().msg(" No Data Found For Save Order");
		}
	}// Save Temporder

	////////// Button Press Managment Here ////////////////////////////
	class Table implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				checkTableProcess(value);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void checkTableProcess(String value) throws ClassNotFoundException, SQLException {
		String sql = "Call resto_getTableSplit(" + value + ")";
		String[] Col1 = { "Type", "Table No", "Split No", "Type ", "Floor " };
		TableSearch(sql, Col1);
	}

	public void TableSearch(String sqlsearch, String[] Col1) throws SQLException, ClassNotFoundException {
		int tablerow = table.getRowCount();
		if (tablerow == 0) {
			new gnTable().RemoveTableRows(smodel);
			// String[] col1 = { "Type" ,"Floor" ,"Table Type" ,"Table NO" ,
			// "Split Table"} ;
			String vtype = "Table";
			stable = new gnTableModel().Tablemodel4(stable, smodel, sqlsearch, Col1, 4, "N", "Y", vtype);
			String RecordCount1 = Integer.toString((new gnTable().getRowCount(stable)));
			stable.setEnabled(true);
			stable.setCellSelectionEnabled(false);
			stable.setRowSelectionAllowed(true);
			stable.setBackground(Color.WHITE);
			stable.setSelectionBackground(Color.BLUE);
			DefaultCellEditor nk = new gnTable().cellEdit(stable);
			nk.addCellEditorListener(ChangeNotification701);
			sjsp.setViewport(null);
			prt6.setToolTipText("Customer Search View");
			prt6.setScrollMode(0);
			prt6.add(stable, Col);
			sjsp.setViewport(prt6);
			new General().msgsearch(sjsp, stable, "Select Table ", 800, 300);
		} else {
			new General().msg("Save Current Table Data");
		}
	}

	public CellEditorListener ChangeNotification701 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			e.notifyAll();
		}

		public void editingStopped(ChangeEvent e) {
			int row = stable.getSelectedRow();
			String value = (String) stable.getValueAt(row, 0);
			ctableno = (String) stable.getValueAt(row, 1);
			csplit = (String) stable.getValueAt(row, 2);
			cfloor = (String) stable.getValueAt(row, 4);
			ctabletype = (String) stable.getValueAt(row, 3);
			tableno.setText(ctableno);
			split.setText(csplit);
			floor.setText(cfloor);
			tabletype.setText(ctabletype);
			// nitin
			new General().msg("Check Table Inforamtion after Table Populate");
			try {
				showOrder();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	private void showOrder() throws Throwable {
		String SQL = " ";
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		if (POS == "0") {
			SQL = "call    resto_getTableinfo(" + cfloor + " , '" + ctabletype + "' , '" + csplit + "' , " + ctableno
					+ ", " + vcomp + ",  " + vstore + ")";
		}
		// aayushi new General().msg(SQL);
		rs = this.getSPResult(SQL);
		showTableOrder(rs);
	}

	private void showTableOrder(ResultSet rs) throws SQLException {
		int curRow = table.getRowCount();
		if (curRow > 0) {
			new General().msg("Save Current Order First");
			return;
		} else {
			while (rs.next()) {
				model.setColumnIdentifiers(Col);
				model.addRow(new Object[] { " ", rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), "0 ",
						rs.getString(18) });
				table.setModel(model);
				removeRow(model, table);
				int row = table.getSelectedRow();
				Double itemtotal = new gnTable().getTotal(table, 10);
				Tamount.setText(Double.toString(itemtotal));
				calHdrDisocunt();
				switch (POS) {
				case "1":
					break;
				case "0":
					break;
				}
			}
		}
	}

	private void removeOrder() throws SQLException {
		try {
			String vcomp = new gnConfig().getCompanyCode();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String vstore = new gnConfig().getStoreID();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String SQL1 = "Call  resto_removeTableinfo(" + cfloor + " , '" + ctabletype + "' , '" + csplit + "' , "
				+ ctableno + " , " + vcomp + " , " + vstore + " )";
		new gnLogger().loggerDebugEntry("POS", "Resto- Removing Table Data");
		this.getResult(SQL1);
		releaseTable(ctableno);
	}

	private void releaseTable(String vtable) {
		if (POS == "0") {
			switch (vtable) {
			case "1":
				btnTable1.setBackground(Color.WHITE);
				btnTable1.setForeground(Color.BLUE);
				break;
			case "2":
				btnTable2.setBackground(Color.WHITE);
				btnTable2.setForeground(Color.BLUE);
				break;
			case "3":
				btnTable3.setBackground(Color.WHITE);
				btnTable3.setForeground(Color.BLUE);
				break;
			case "4":
				btnTable3.setBackground(Color.WHITE);
				btnTable3.setForeground(Color.BLUE);
				break;
			case "5":
				btnTable3.setBackground(Color.WHITE);
				btnTable3.setForeground(Color.BLUE);
				break;
			case "6":
				btnTable3.setBackground(Color.WHITE);
				btnTable3.setForeground(Color.BLUE);
				break;
			case "7":
				btnTable3.setBackground(Color.WHITE);
				btnTable3.setForeground(Color.BLUE);
				break;
			case "8":
				btnTable3.setBackground(Color.WHITE);
				btnTable3.setForeground(Color.BLUE);
				break;
			case "9":
				btnTable3.setBackground(Color.WHITE);
				btnTable3.setForeground(Color.BLUE);
				break;
			case "10":
				btnTable3.setBackground(Color.WHITE);
				btnTable3.setForeground(Color.BLUE);
				break;
			}
		}
	}

	private void TableColor(String value) {
		if (POS == "0") {
			switch (value) {
			case "1":
				btnTable1.setBackground(Color.RED);
				btnTable1.setForeground(Color.WHITE);
				break;
			case "2":
				btnTable2.setBackground(Color.RED);
				btnTable2.setForeground(Color.WHITE);
				break;
			case "3":
				btnTable3.setBackground(Color.RED);
				btnTable3.setForeground(Color.WHITE);
				break;
			case "4":
				btnTable3.setBackground(Color.RED);
				btnTable3.setForeground(Color.WHITE);
				break;
			case "5":
				btnTable3.setBackground(Color.RED);
				btnTable3.setForeground(Color.WHITE);
				break;
			case "6":
				btnTable3.setBackground(Color.RED);
				btnTable3.setForeground(Color.WHITE);
				break;
			case "7":
				btnTable3.setBackground(Color.RED);
				btnTable3.setForeground(Color.WHITE);
				break;
			case "8":
				btnTable3.setBackground(Color.RED);
				btnTable3.setForeground(Color.WHITE);
				break;
			case "9":
				btnTable3.setBackground(Color.RED);
				btnTable3.setForeground(Color.WHITE);
				break;
			case "10":
				btnTable3.setBackground(Color.RED);
				btnTable3.setForeground(Color.WHITE);
				break;
			case "11":
				btnTable3.setBackground(Color.RED);
				btnTable3.setForeground(Color.WHITE);
				break;
			}
		}
	}

	private void activateRestoPOS() {
		POS = "0";
		JspPanel.setBounds(0, 6, 1224, 340);
		jsp.setBounds(0, 0, 1212, 340);
		JspPanel.add(jsp);
		Dpanel.add(JspPanel);
		Dpanel.add(resto_panel1);
		resto_panel3.setVisible(true);
	}

	private void activateNormalPOS() {
		POS = "1";
		// JspPanel.setBounds(0, 31, 1224, 536);
		// Dpanel.setBounds(126, 165, 1213, 532);
		// Dpanel.setBounds(400, 165, 950, 532);
		JspPanel.setBounds(0, 0, 950, 532);
		jsp.setBounds(0, 0, 1325, 532);
		// JspPanel.add(jsp);
		// Dpanel.add(JspPanel);
		Dpanel.add(jsp);
		// pos_hdr1.setVisible(true);
		resto_panel3.setVisible(false);
	}

	private void setVerticlePOS() throws Throwable {
		vverticle = new gnHierarchy().getVerticleCode();
		// vverticle = "1" ; //new gnHierarchy().getVerticleCode() ;
		switch (vverticle) {
		case "0":
			activateNormalPOS();
			new gnLogger().loggerDebugEntry("POS", "Normal Sales Template Assign");
			break;
		case "1":
			activateNormalPOS();
			break;

		case "2":
			activateNormalPOS();
			break;

		case "3":
			activateRestoPOS();
			showBusyTables();
			new gnLogger().loggerDebugEntry("POS", "Resto POS Sales Template Assign");
			break;

		case "4":
			activateRestoPOS();
			showBusyTables();
			new gnLogger().loggerDebugEntry("POS", "Resto POS Sales Template Assign");
			break;

		case "5":
			activateNormalPOS();
			break;

		case "6":
			activateNormalPOS();
			break;

		case "7":
			activateNormalPOS();
			break;

		case "8":
			activateNormalPOS();
			break;

		case "9":
			activateNormalPOS();
			break;

		case "10":
			activateNormalPOS();
			break;

		case "11":
			activateNormalPOS();
			break;

		case "12":
			activateNormalPOS();
			break;

		case "13":
			activateNormalPOS();
			break;

		case "14":
			activateNormalPOS();
			break;
		}
		new gnLogger().loggerDebugEntry("POS", "POS Template Sucess...");
	}

	private void setConfiguration1() {
		Vector conf = new getConfigurationSetting().getVector();

	}

	private void setConfiguratin() throws Throwable {

		new gnLogger().loggerDebugEntry("POS", "Setting Config Parameter for POS ...");

		String paravalue = " ";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vpara = "700";
		paravalue = new getConfigurationSetting().getSpecificConfiguration(vpara);
		switch (paravalue) {
		case "Y":
			// BtnImgPanel_1.setVisible(true);
			break;
		case "N":
			// BtnImgPanel_1.setVisible(false);
			break;
		}
		// Invoice Search Panel Activation

		// Cash widhrow From drawer option
		String vpara701 = "701";
		new getConfigurationSetting().setBtnConfig(btnCashWidrow, vpara701);

		String vpara702 = "702";
		new getConfigurationSetting().setBtnConfig(btn_Deposit, vpara702);

		String vpara704 = "704";
		new getConfigurationSetting().setBtnConfig(btnDeclaration, vpara704);

		String vpara705 = "705";
		new getConfigurationSetting().setBtnConfig(btnHold, vpara705);
		new getConfigurationSetting().setBtnConfig(btnBillUnhold, vpara705);

		String vpara706 = "706";
		paravalue = new getConfigurationSetting().getSpecificConfiguration(vpara706);
		switch (paravalue) {
		case "Y":
			homeDelivery.setEnabled(true);
			break;
		case "N":
			homeDelivery.setEnabled(false);
			break;
		}

		String vpara805 = "805";
		para805 = Integer.parseInt(new getConfigurationSetting().getSpecificConfiguration(vpara805));

		String vpara708 = "708";
		new getConfigurationSetting().setBtnConfig(btnNewCustomer, vpara708);

		String vpara711 = "711";
		new getConfigurationSetting().setTextFielConfig(hdrDiscount, vpara711);
		new gnLogger().loggerDebugEntry("POS", "Setting Config Parameter for POS Over...");

	}

	private String checkAllowNegInv(String varticle) throws Throwable {
		String vallowyn = "";
		String vallow = "";
		double vqty = 0.00;
		vallow = new getConfigurationSetting().AllowNegInv();
		int vl = varticle.length();
		// new General().msg("Article Length" + " "+vl);
		if (varticle != "0") {
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

	TableCellRenderer tableCellRenderer1 = new DefaultTableCellRenderer() {

		SimpleDateFormat f = new SimpleDateFormat("MM/dd/yy");

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value instanceof Date) {
				new General().msg("Object Passed is:" + value);
				value = f.format(value);
			}
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	};
	private JPanel NPanel1;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JComboBox payCombo;
	private JLabel lblNewLabel_13;
	private JTextField custamountPaid;
	private JLabel lblNewLabel_6;
	private JTextField ename;
	private JTextField eqty;
	private JTextField erate;

	// }

	static class DateRenderer extends DefaultTableCellRenderer {
		DateFormat formatter;

		public DateRenderer() {
			super();
		}

		public void setValue(Object value) {
			if (formatter == null) {
				formatter = DateFormat.getDateInstance();
			}
			setText((value == null) ? "" : formatter.format(value));
		}
	}

	/// Discount for autombile

	class btndscsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			applyDiscGroup();
		}
	}

	private void applyDiscGroup() {
		int row = 0;
		try {
			row = table.getSelectedRow();
			new gnDisc().getDiscountInfo(AutodiscArticle);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			double vdiscper = Double.parseDouble(new gnDisc().rdisc);
			if (vdiscper > 0.00) {

				float vamt = Float.parseFloat(table.getValueAt(row, 6).toString());
				String.format("%.2f", vamt);
				float vdisc = (float) Math.round(vamt * vdiscper / 100);
				String.format("%.2f", vdisc);
				table.setValueAt(vdisc, row, 8);
				try {
					QtychangeImapct(AutodiscArticle, row);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}
}// Last

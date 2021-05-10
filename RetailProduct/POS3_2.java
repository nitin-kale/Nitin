package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
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
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.Popup;
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
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.NumberFormatter;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.mysql.jdbc.Statement;

import RetailProduct.ApplicationMenu.btnfocus;
import RetailProduct.ApplicationMenu.keyPressedlsnr;
import RetailProduct.GRNModule.discLsnr;
import RetailProduct.POSSimpleRetail.custamtpaidLsnr;
import RetailProduct.POSSimpleRetail.editLsnr;
import javax.swing.JProgressBar;
import javax.swing.border.CompoundBorder;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Window.Type;
import javax.swing.JTextPane;

public class POS3_2 extends getResultSet implements Runnable {

	// promo variables

	// REsto Price Related

	String vapplydiffPrice = "N";
	JPanel mergetablepanel;
	String vapplyBasePriceFor = "COUNTER";
	JButton btnMerge;
	String vaddSub = "ADD";
	String vwalkinprice = "";
	String vcounterprice = "";
	String vzomatoprice = "";
	String vswiggyprice = "";
	String vtelephoneprice = "";
	String vapplyBasePriceForCounter = "N";
	String vapplyBasePriceForWalkin = "N";
	String vapplyBasePriceForSwiggy = "N";
	String vapplyBasePriceForZomato = "N";
	String vapplyBasePriceForTelephone = "N";

	// REsto Price Related

	double vfreegivenqty = 0.0;
	String xvpromotypecode = "";
	JComboBox comboOrderType;
	String HoldBill = "N";
	String printDirectKot = "Y";
	String Promohdrdisc = "N";
	String xvmypromoArticle = "";
	String orderAdding = "N";
	private JScrollPane promojsp;
	private JTextField starttime;
	private JTextField endtime;
	private JTextField custamountPaid;
	private JTextField showqty;
	private JLabel lblNewLabel_10;
	private JTextField manualdisc;
	private JLabel lblNewLabel_11;
	private JTextField billhdrdiscper;
	private JTextField fgross;
	private JLabel lblNewLabel_13;
	private JTextField fdisc;
	private JTextField docno;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_2;
	double vmyfreeqty;
	JComboBox comboArticle;
	double vallocatefreeqty = 0;
	double vbalfreeqty = 0;
	String SelectionType = "Article";
	JPanel panelbillInfotemp;
	String xvfreeQty = "";
	String vlocation;
	JWindow wnd;
	JButton btnNewButton;
	String vprompTypecode = "";
	JComboBox<String> SalesType;
	String xvarticle = "0";
	String xvapply = "";
	double vmanualdisc = 0.0;
	int paycount = 0;
	String xvdiscper = "";
	String xvdiscamt = "";
	String xvfrom;
	String xvbillqty;
	String xvfreeArticle;
	String xvbillvalue;
	String xvto;
	JTextField docname;
	String promoArticle;
	String vdoccode = null;
	private JTextField tokenno;
	int taxslabrow;
	private JTextField scanqty;
	private JTextField rate;
	private JLabel lblNewLabel_5;
	private JLabel lblmsg;
	private JTextField disc;

	String vdrugType;
	//

	public static String invoiceMode = "I";
	String VAccountPostingAmount;
	private String POS = "1";
	private String scannerAvailable = "N";
	private JButton btnDoctor;
	private JButton btnClose;
	String vfgross;
	String vfdisc;
	private String vallowPopWindow = "N";
	private Connection con1, con2, con3, con4, con5, con6, con7, con8;
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
	JTextField edittaste;
	JTextField editrate;
	JTextField editEnd;

	JPanel panelPriceEdit;
	JWindow panelShowItems;

	String vmaintainbatchforNonBatchItem;
	JPanel panelDoctorInfo;

	private JButton btnImgComp;
	JFormattedTextField chngqty;
	JFormattedTextField sp;
	// JPanel choicepanel;
	JSplitPane possplit;

	private String para707;
	private String QueryStatus = "N";
	private int para805;
	private JTextField records;
	private JCheckBox homeDelivery;
	public static String varticle = "0";
	private JPanel resto_panel1;
	private JButton btnTable1;
	private JButton btnTable2;
	private JButton btnTable3;
	private JLabel lblTable;
	JComboBox payCombo;
	private JTextField tableno;
	private JTextField tabletype;
	private String vstore;
	private JPanel resto_panel2;
	private JLabel lblTableNo;
	private JLabel lblFloor_1;
	private JTextField floor;
	private JTextField split;
	private JPanel resto_panel3lblSearchByName;
	JPanel billtimePanel;
	private JLabel lblSelectTableInformation;
	String vglcode;
	private JTextField vdropsearch;
	private JComboBox comboSplit;
	private JTextField hm_Phone;
	private JTextField hm_custname;
	private JTextField hm_addr1;
	private JTextField hm_addr2;
	private JTextField scanItem_2;
	private JTextField scanName22;
	private JComboBox comboTable;
	private JComboBox comboTtype;
	private JComboBox comboFloor;
	private JScrollPane Pjsp_1;
	private JPanel JspPanel;
	String vinsertAllow;
	//

	private JPanel resto_panel3;
	private String AutodiscArticle;

	public JCheckBox chkbox;
	// public JTextField scanItem_2;
	private Double dues;

	private JPanel pmtPanel;
	public JPanel pmt;

	JTable promotable = new JTable();

	public DefaultTableModel promomodel = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 1 || column == 2 || column == 3 || column == 4 || column == 5 || column == 6
					|| column == 7 || column == 8 || column == 9 || column == 10 ? false : true;
		}
	};

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
	private JTextField shift;
	public String vvcompnaycode;
	public String vvsitecode;
	JPanel Hpanel_3;
	public int vterminal;
	JPanel panelscan;
	public boolean process = true;
	public int vvinvno;
	public String Svinvdate;
	public Date Dinvdate;
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
	JTextField editdisc;
	JSplitPane promoSplit;
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
	private String SR[] = { "Item code", "Name", "Qty", "Rate", "MRP", "Gross", "BillDisc", "Disc", "TaxAmt",
			"TotalAmt", "Tcode", "Site_code", "Invno", "Invdate" };

	// This was old
	// private String Col[] = { "Romove", "Item", "Name", "Qty", "Rate", "MRP",
	// "Gross", "Bill Disc", "Disc", "Tax",
	// "Amount", "Taxcode", "Batch Item", "BatchNo", "Exp.Date",
	// "Free(Qty)/Disc" , "Cost", "DrugType", "Content" };

	/*
	 * 17-Ordertype 18 - tableno -- 19 - KOT 13 - Taste
	 */

	// Resto
	// prst.setString(51, table.getValueAt(k, 17).toString()); // orderType
	// prst.setString(52, table.getValueAt(k, 18).toString()); // TableNo
	// prst.setString(53, table.getValueAtl(k, 19).toString()); // KOT
	// prst.setString(54, table.getValueAt(k, 13).toString()); //Tasste
	// prst.setString(55, orderno.getText()); //orderno
	// prst.setString(56, invdate.getText()); //orderdate
	// End REsto && KOT

	private String Col[] = { "X", "Item", "Name", "Qty", "Rate", "MRP", "Gross", "Disc Item", "Bill Disc", "Disc",
			"Tax", "Amount", "Tax%", "Taste", "BatchNo", "ExpDate", "Free(Qty)/Disc", "Order", "Table", "KOT" };

	// For Customer Search

	public DefaultTableModel Articlemodel = new DefaultTableModel();
	public JTable Articletable = new JTable();

	public DefaultTableModel smodel = new DefaultTableModel();

	public String SCol[] = { "Type", "Customer code", "Name", "Phone", "Email" };
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
			return column == 3 || column == 4 || column == 8 || column == 9 || column == 1 || column == 2 || column == 5
					|| column == 6 || column == 7 || column == 10 ? false : true;
		}
	};

	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			String vpara715 = "715";
			String vpara811 = "811";
			try {

				String allow = new getConfigurationSetting().getSpecificConfiguration(vpara715);
				switch (allow) {
				case "Y":
					return column == 0 || column == 13 || column == 3 || column == 4 || column == 7 || column == 12
							|| column == 14 || column == 15 ? true : false;
				case "N":
					return column == 0 || column == 0 || column == 3 || column == 7 || column == 12 || column == 14
							|| column == 15 ? true : false;
				}
				String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getSpecificConfiguration(vpara811);
				switch (vmaintainbatchforNonBatchItem) {
				case "Y":
					if (getValueAt(row, 16).toString().equalsIgnoreCase("0")
							|| getValueAt(row, 14).toString().equalsIgnoreCase("")) {
						return column == 0 || column == 3 || column == 4 || column == 7 || column == 12 || column == 14
								|| column == 15 ? true : false;
					}
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			return process;
		}
	};

	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 4 || column == 7 || column == 12 || column == 14
					|| column == 15) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.blue);
				componentt.setCursor(getCursor());
				// componentt.setFont(new Font("Cambria", Font.PLAIN, 13));
				componentt.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
			} else {
				componentt.setBackground(Color.DARK_GRAY);
				componentt.setForeground(Color.WHITE);
				componentt.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 11));

				if (getValueAt(roww, 13).toString().equalsIgnoreCase("N")) {
					componentt.setBackground(Color.CYAN);
					componentt.setForeground(Color.BLACK);
					componentt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
				} else if (getValueAt(roww, 13).toString().equalsIgnoreCase("Y")) {
					componentt.setBackground(Color.DARK_GRAY);
					componentt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
				}

				if (roww == 0) {
					componentt.setBackground(Color.BLACK);
					componentt.setForeground(Color.green);
					componentt.setCursor(getCursor());
					componentt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
				}
			}
			if (Language == "H") {
				if (column == 2) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}

			if (getValueAt(roww, 16).toString().equalsIgnoreCase("NB")) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			}
			return componentt;
		}
	};

	public DefaultTableModel pmodel = new DefaultTableModel();
	public JTable ptable = new JTable();

	public DefaultTableModel cropmodel = new DefaultTableModel();
	public JTable croptable = new JTable();

	public Double famount = 0.00;
	public Double duePayment = 0.00;
	public Double paidAmount = 0.00;
	public Double fnetAmount = 0.00;
	public Double fhdrDiscount = 0.00;
	public Double froundOffAmt = 0.00;
	String vverticlecode;

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
	JViewport prt;
	private JButton btnHold;
	private JTextField hm_addr3;

	public int option;
	public JTextField froundAmt;
	public String DBaction;

	public Connection conn = null;
	public Statement pst = null;
	public int x = 10; // Start Drawing from X=10
	public JButton btn_print;
	public JFrame POSFrame3_2;

	private JComboBox InvType;
	public String PCol[] = { "X", "Payment Mode", "Amout", "CardNumber", "CardType" };
	public Object qty;
	public JPanel HeaderPanel = new JPanel();
	public JPanel Dpanel;
	public JPanel choicepanel;
	public JPanel BtnImgPanel;
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
	public JTextField Email;
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

	String GetPriceFromMenuList = "Y";

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
					POS3_2 window = new POS3_2();
					window.POSFrame3_2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public POS3_2() throws Throwable {
		// this.closeconn();
		// setStandardData();
		// getPOSconfigValues();
		initialize();
		/// this.closeconn();

	}

	private void initialize() throws Throwable {
		POSFrame3_2 = new JFrame();
		POSFrame3_2.setResizable(false);
		POSFrame3_2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		POSFrame3_2.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
		POSFrame3_2.getContentPane().setBackground(Color.WHITE);
		POSFrame3_2.getContentPane().setLayout(null);
		POSFrame3_2.setTitle("Business Application - Stand Alone Store Edition");
		POSFrame3_2.setOpacity(1.0f);
		POSFrame3_2.setBackground(Color.DARK_GRAY);
		POSFrame3_2.setAlwaysOnTop(true);
		POSFrame3_2.setBounds(1, 0, 1356, 772);
		POSFrame3_2.getContentPane().setEnabled(true);
		POSFrame3_2.getContentPane().setBackground(Color.CYAN);
		POSFrame3_2.getContentPane().setLayout(null);

		ActionListener bunhld = new UnholdLsnr();
		ActionListener hld = new holdLsnr();

		JPanel HeaderPanel = new JPanel();
		HeaderPanel.setForeground(Color.BLACK);
		HeaderPanel.setBounds(0, 30, 1350, 145);
		HeaderPanel.setBackground(new Color(153, 255, 255));
		HeaderPanel.setBorder(null);
		POSFrame3_2.getContentPane().add(HeaderPanel);
		HeaderPanel.setLayout(null);
		String vsalesType = "Sales_Type";

		String vverticle = new gnHierarchy().getVerticleCode();
		String vsearch = "%%";
		String SQL11 = " call   master_getmasterData('" + vsalesType + "' , " + vverticle + ",  '" + vsearch + "')";
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
		// Hpanel_3 = new JPanel();
		Hpanel_3 = new gnRoundPanel();
		Hpanel_3.setBackground(new Color(153, 255, 255));
		Hpanel_3.setForeground(new Color(255, 255, 204));
		Hpanel_3.setBounds(423, -3, 634, 148);
		Hpanel_3.setLayout(null);
		Hpanel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		HeaderPanel.add(Hpanel_3);

		custname = new JTextField();
		custname.setBounds(83, 15, 350, 30);
		custname.setBackground(new Color(204, 255, 255));
		custname.setText("Default");
		custname.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		custname.setForeground(new Color(0, 0, 51));
		Hpanel_3.add(custname);
		custname.setColumns(10);
		ActionListener custname1 = new lsnrCustName();
		custname.addActionListener(custname1);

		custid = new JTextField();
		custid.setBounds(434, 13, 36, 30);
		custid.setForeground(Color.DARK_GRAY);
		custid.setBackground(Color.WHITE);
		custid.setText("0");
		custid.setFont(new Font("Segoe UI", Font.BOLD, 14));
		Hpanel_3.add(custid);
		custid.setColumns(10);

		mobile = new JTextField();
		mobile.setBounds(83, 45, 387, 28);
		mobile.setBackground(new Color(204, 255, 255));
		mobile.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		mobile.setForeground(new Color(0, 0, 51));
		Hpanel_3.add(mobile);
		mobile.setColumns(10);

		lblNewLabel_17 = new JLabel("Customer Information");
		lblNewLabel_17.setForeground(new Color(0, 0, 102));
		lblNewLabel_17.setBounds(83, 1, 236, 16);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 15));
		Hpanel_3.add(lblNewLabel_17);

		hm_addr1 = new JTextField();
		hm_addr1.setBounds(83, 75, 387, 28);
		Hpanel_3.add(hm_addr1);
		hm_addr1.setBackground(new Color(204, 255, 255));
		hm_addr1.setForeground(new Color(0, 0, 51));
		hm_addr1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		hm_addr1.setToolTipText("Enter Address  Max Chars Allow is 30");
		hm_addr1.setColumns(10);

		hm_addr2 = new JTextField();
		hm_addr2.setBounds(83, 105, 387, 25);
		Hpanel_3.add(hm_addr2);
		hm_addr2.setBackground(new Color(204, 255, 255));
		hm_addr2.setForeground(new Color(0, 0, 51));
		hm_addr2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		hm_addr2.setToolTipText("Enter Address  Max Chars Allow is 30");
		hm_addr2.setColumns(10);

		JLabel lblMobileNo = new JLabel("Mobile");
		lblMobileNo.setBounds(-14, 52, 85, 16);
		Hpanel_3.add(lblMobileNo);
		lblMobileNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobileNo.setForeground(new Color(0, 0, 51));
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblNewLabel_18 = new JLabel("Address");
		lblNewLabel_18.setForeground(new Color(0, 0, 51));
		lblNewLabel_18.setBounds(1, 79, 70, 16);
		lblNewLabel_18.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		Hpanel_3.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("Name");
		lblNewLabel_19.setBackground(new Color(0, 0, 51));
		lblNewLabel_19.setForeground(new Color(0, 0, 51));
		lblNewLabel_19.setBounds(-14, 23, 85, 16);
		lblNewLabel_19.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.RIGHT);
		Hpanel_3.add(lblNewLabel_19);

		btnNewButton = new JButton("Save Customer-F11");
		btnNewButton.setMnemonic('O');
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(0, 0, 51));
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton.setBounds(470, 118, 151, 30);
		Hpanel_3.add(btnNewButton);

		mergetablepanel = new JPanel();
		mergetablepanel.setBackground(Color.WHITE);
		mergetablepanel.setBounds(470, 1, 270, 119);
		Hpanel_3.add(mergetablepanel);
		mergetablepanel.setLayout(null);

		mergetable1 = new JTextField();
		mergetable1.setBounds(182, 47, 69, 31);
		mergetablepanel.add(mergetable1);
		mergetable1.setColumns(10);

		mergetable2 = new JTextField();
		mergetable2.setBounds(69, 30, 56, 22);
		mergetablepanel.add(mergetable2);
		mergetable2.setColumns(10);

		mergetable3 = new JTextField();
		mergetable3.setText("0");
		mergetable3.setBounds(69, 56, 56, 22);
		mergetablepanel.add(mergetable3);
		mergetable3.setColumns(10);

		JLabel lblMaxTable = new JLabel("Max 2 Table Megre Allow");
		lblMaxTable.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblMaxTable.setBounds(0, 0, 265, 16);
		mergetablepanel.add(lblMaxTable);

		JLabel lblNewLabel_23 = new JLabel("Table No");
		lblNewLabel_23.setBounds(185, 33, 66, 16);
		mergetablepanel.add(lblNewLabel_23);

		JLabel lblTableNo_1 = new JLabel("Table No");
		lblTableNo_1.setBounds(10, 33, 66, 16);
		mergetablepanel.add(lblTableNo_1);

		JLabel lblTableNo_2 = new JLabel("Table No");
		lblTableNo_2.setBounds(10, 59, 66, 16);
		mergetablepanel.add(lblTableNo_2);

		btnMerge = new JButton("Merge Table");
		btnMerge.setBounds(0, 94, 265, 25);
		mergetablepanel.add(btnMerge);

		lblNewLabel_24 = new JLabel("Addin");
		lblNewLabel_24.setIcon(null);
		lblNewLabel_24.setBounds(137, 30, 37, 50);
		mergetablepanel.add(lblNewLabel_24);

		JLabel lblNewLabel_26 = new JLabel("Note : Please Press F9  For New Customer Creation ");
		lblNewLabel_26.setBounds(80, 132, 390, 16);
		Hpanel_3.add(lblNewLabel_26);

		// ====>here kale

		// === customer ===
		ActionListener ls = new ls();

		Dpanel = new JPanel();
		Dpanel.setBounds(1, 1, 1350, 568);
		// Dpanel.setBounds(1, 1, 1350, 400);
		Dpanel.setBackground(new Color(192, 192, 192));
		Dpanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		// POSFrame.getContentPane().add(Dpanel);
		Dpanel.setLayout(null);

		choicepanel = new JPanel();
		choicepanel.setBounds(0, 1, 400, 542);
		choicepanel.setBackground(Color.CYAN);
		choicepanel.setBorder(new TitledBorder(new LineBorder(new Color(102, 255, 255), 5, true), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		choicepanel.setLayout(null);

		promoSplit = new JSplitPane();
		promoSplit.setOneTouchExpandable(true);
		promoSplit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		promoSplit.setBounds(6, 395, 248, 119);
		promoSplit.setBounds(6, 395, 248, 100);

		promojsp = new JScrollPane();
		promojsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		promoSplit.setRightComponent(promojsp);
		promoSplit.setLeftComponent(Dpanel);

		switch (promoModuleActivated) {
		case "Y":
			promoSplit.setDividerLocation(350);
			break;
		case "N":
			promoSplit.setDividerLocation(350);
			break;
		}

		possplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, choicepanel, promoSplit);
		possplit.setOneTouchExpandable(true);
		possplit.setVisible(true);
		possplit.setDividerLocation(130);
		possplit.setBounds(1, 242, 986, 489);
		possplit.setAutoscrolls(true);

		POSFrame3_2.getContentPane().add(possplit);
		ActionListener lsprint = new ls();
		ActionListener lspayment = new ls();
		ActionListener l2 = new ls();

		btnDeclaration = new JButton("Declare Cash");
		btnDeclaration.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		btnDeclaration.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeclaration.setBounds(0, 222, 118, 36);
		choicepanel.add(btnDeclaration);
		btnDeclaration.setForeground(new Color(0, 0, 153));

		btn_SalesReturn = new JButton("Sales Return");
		btn_SalesReturn.setMnemonic('R');
		btn_SalesReturn.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SalesReturn.setBounds(0, 176, 118, 44);
		choicepanel.add(btn_SalesReturn);
		ActionListener SR = new ls();
		btn_SalesReturn.addActionListener(SR);
		btn_SalesReturn.setForeground(new Color(0, 0, 153));
		btn_SalesReturn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		btnCashWidrow = new JButton("Cash Withdraw");
		btnCashWidrow.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		btnCashWidrow.setHorizontalAlignment(SwingConstants.LEFT);
		btnCashWidrow.setBounds(0, 256, 118, 36);
		choicepanel.add(btnCashWidrow);
		btnCashWidrow.setForeground(new Color(0, 0, 153));

		btn_Deposit = new JButton("Float Cash");
		btn_Deposit.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		btn_Deposit.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Deposit.setBounds(0, 291, 118, 36);
		choicepanel.add(btn_Deposit);
		btn_Deposit.setForeground(new Color(0, 0, 153));

		btnDayEnd = new JButton("Day End");
		btnDayEnd.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnCloseDay2.png"));
		btnDayEnd.setMnemonic('E');
		btnDayEnd.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnDayEnd.setHorizontalAlignment(SwingConstants.LEFT);
		btnDayEnd.setBounds(0, 322, 118, 36);
		choicepanel.add(btnDayEnd);
		btnDayEnd.setForeground(new Color(0, 0, 153));
		btnDayEnd.addActionListener(lspayment);

		btnDayBegin = new JButton("Edit-Sales");
		btnDayBegin.setMnemonic('B');
		btnDayBegin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnDayBegin.setHorizontalAlignment(SwingConstants.LEFT);
		btnDayBegin.setForeground(new Color(0, 0, 153));
		btnDayBegin.setBounds(0, 133, 118, 44);
		choicepanel.add(btnDayBegin);

		btnClose = new JButton("Close");
		btnClose.setBounds(0, 358, 119, 36);
		choicepanel.add(btnClose);
		btnClose.setHorizontalAlignment(SwingConstants.LEFT);
		btnClose.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnClose.setMnemonic('C');

		//

		btnBillUnhold = new JButton("Bill UnHold");
		btnBillUnhold.setBounds(0, 100, 118, 39);
		choicepanel.add(btnBillUnhold);
		btnBillUnhold.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnBillUnhold.setHorizontalAlignment(SwingConstants.LEFT);

		btnNewCustomer = new JButton("Customer");
		btnNewCustomer.setBounds(0, 0, 117, 27);
		choicepanel.add(btnNewCustomer);
		btnNewCustomer.setMnemonic('U');
		btnNewCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewCustomer.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnNewCustomer.setForeground(new Color(0, 0, 153));

		// btnSalesLike = new JButton("Copy Bill");
		btnSalesLike = new gnRoundButton("Copy Bill");
		btnSalesLike.setBounds(0, 26, 117, 36);
		choicepanel.add(btnSalesLike);
		btnSalesLike.setBackground(Color.CYAN);
		btnSalesLike.setForeground(Color.BLACK);
		btnSalesLike.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnSalesLike.setMnemonic('L');

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
		btnBillUnhold.addActionListener(bunhld);
		ActionListener lklk = new ls();
		ActionListener lklk1 = new ls();
		btn_Deposit.addActionListener(lklk1);
		btnCashWidrow.addActionListener(lklk);
		ActionListener lsdecl = new ls();
		btnDeclaration.addActionListener(lsdecl);
		ActionListener lssave1 = new lsSave();

		btnDayBegin.addActionListener(lssave1);
		ActionListener lsnew = new ls();

		pmodel.setColumnIdentifiers(PCol);

		// POSFrame.getContentPane().add(new pMenu().pmenu(Dpanel));
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
		jsp.setBounds(0, 0, 1224, 408);
		jsp.setBounds(0, 0, 1224, 436);
		jsp.setBounds(0, 0, 1224, 100);
		jsp.setBorder(BorderFactory.createBevelBorder(10, Color.BLUE, Color.DARK_GRAY));
		jsp.setBackground(Color.WHITE);
		Dpanel.add(jsp);

		// JspPanel.add(jsp);

		jsp.setViewportBorder(null);
		jsp.setWheelScrollingEnabled(true);
		JViewport prt = new JViewport();
		prt.setBackingStoreEnabled(true);
		prt.setForeground(Color.RED);
		prt.setBackground(new Color(51, 255, 255));
		prt.add(table, Col);
		prt.setBackground(Color.WHITE);
		prt.setVisible(true);
		jsp.setViewport(prt);

		sjsp.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.cyan));
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(0, 100, 1400, 200);
		// JspPanel.add(sjsp); // Un Comment if wants show on Frame this is used
		// in dialog to show auto

		// scanName22.addKeyListener(keyls);
		table.setBackground(Color.white);
		table.setRowSelectionAllowed(true);
		table.setCellSelectionEnabled(false);
		ActionListener lsnrname = new lsnritemName();
		ActionListener ls720 = new lsSearch();

		// New
		panelPriceEdit = new JPanel();
		panelPriceEdit.setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.GREEN, null, null));
		panelPriceEdit.setBounds(11, 519, 206, 185);
		// POSFrame.getContentPane().add(panelPriceEdit);
		// Dpanel.add(panelPriceEdit);
		panelPriceEdit.setLayout(null);

		panelShowItems = new JWindow();
		// panelShowItems.setBorder(new BevelBorder(BevelBorder.RAISED,
		// Color.ORANGE, Color.GREEN, null, null));
		panelShowItems.setBounds(11, 519, 206, 185);
		panelShowItems.getContentPane().setLayout(null);

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

		JLabel lblNewLabel_151 = new JLabel("Taste");
		lblNewLabel_151.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_151.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_151.setBounds(12, 68, 56, 16);
		panelPriceEdit.add(lblNewLabel_151);

		JLabel lblNewLabel_152 = new JLabel("Rate");
		lblNewLabel_152.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_152.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_152.setBounds(12, 95, 56, 16);
		panelPriceEdit.add(lblNewLabel_152);

		JLabel lblNewLabel_153 = new JLabel("Disc");
		lblNewLabel_153.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_153.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_153.setBounds(12, 118, 56, 16);
		panelPriceEdit.add(lblNewLabel_153);

		editqty = new JTextField();
		editqty.setBounds(80, 42, 116, 30);
		editqty.setColumns(10);
		panelPriceEdit.add(editqty);

		edittaste = new JTextField();
		edittaste.setBounds(80, 65, 116, 30);
		edittaste.setColumns(10);
		panelPriceEdit.add(edittaste);

		editrate = new JTextField();
		editrate.setBounds(80, 91, 116, 30);
		editrate.setColumns(10);
		panelPriceEdit.add(editrate);

		editdisc = new JTextField();
		editdisc.setBounds(80, 115, 116, 30);
		editdisc.setColumns(10);
		panelPriceEdit.add(editdisc);

		editEnd = new JTextField();
		editEnd.setBounds(80, 134, 116, 30);
		editEnd.setColumns(10);
		panelPriceEdit.add(editEnd);

		ActionListener editls = new editLsnr();
		editrate.addActionListener(editls);
		editqty.addActionListener(editls);
		editdisc.addActionListener(editls);
		edittaste.addActionListener(editls);
		editEnd.addActionListener(editls);

		// Dpanel.add(panelPriceEdit);
		//
		// End New

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
		ActionListener itm = new ls();
		ActionListener hh = new lsSave();

		btnImgComp = new JButton(" ");
		btnImgComp.setBounds(0, 0, 103, 53);
		HeaderPanel.add(btnImgComp);
		btnImgComp.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\mymainIcon6.ico"));
		btnImgComp.setIcon(new ImageIcon(POS.class.getResource("/RetailProduct/POS1.png")));

		JLabel lblNewLabel_20 = new JLabel(" ");
		lblNewLabel_20.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\Images\\rest1.jpg"));
		lblNewLabel_20.setBounds(1073, -3, 265, 145);
		HeaderPanel.add(lblNewLabel_20);

		panelbillInfotemp = new JPanel();
		panelbillInfotemp.setBounds(927, 77, 35, 55);
		HeaderPanel.add(panelbillInfotemp);
		panelbillInfotemp.setBorder(new MatteBorder(4, 1, 0, 1, (Color) new Color(153, 102, 102)));
		panelbillInfotemp.setBackground(Color.WHITE);
		panelbillInfotemp.setLayout(null);

		JLabel lblNewLabel_12 = new JLabel("Gross ");
		lblNewLabel_12.setBounds(12, 1, 212, 20);
		panelbillInfotemp.add(lblNewLabel_12);
		lblNewLabel_12.setForeground(new Color(0, 0, 51));
		lblNewLabel_12.setFont(new Font("Arial", Font.BOLD, 18));

		// fgross = new JTextField();
		fgross = new gnRoundTextField(20);
		fgross.setBackground(new Color(255, 255, 255));

		fgross.setBounds(0, 27, 102, 28);
		panelbillInfotemp.add(fgross);
		fgross.setEditable(false);
		fgross.setFont(new Font("Arial", Font.BOLD, 17));
		fgross.setColumns(10);

		lblNewLabel_13 = new JLabel("Discount");
		lblNewLabel_13.setBounds(126, 1, 98, 20);
		panelbillInfotemp.add(lblNewLabel_13);
		lblNewLabel_13.setForeground(new Color(0, 0, 51));
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 18));

		// fdisc = new JTextField();
		fdisc = new gnRoundTextField(20);
		fdisc.setBackground(new Color(255, 255, 255));

		fdisc.setBounds(111, 27, 101, 28);
		panelbillInfotemp.add(fdisc);
		fdisc.setEditable(false);
		fdisc.setFont(new Font("Arial", Font.BOLD, 17));
		fdisc.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new TitledBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(64, 64, 64), new Color(255, 255, 255),
						new Color(255, 0, 255), new Color(255, 255, 0)),
				"Select  Order Type and Table Here", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 51)));
		panel_4.setBounds(0, 53, 424, 92);
		HeaderPanel.add(panel_4);
		panel_4.setLayout(null);

		tokenno = new JTextField();
		tokenno.setBounds(310, 22, 102, 24);
		panel_4.add(tokenno);
		tokenno.setEditable(false);
		tokenno.setFont(new Font("Calibri", Font.BOLD, 13));
		tokenno.setForeground(Color.WHITE);
		tokenno.setBackground(new Color(128, 0, 0));
		tokenno.setColumns(10);

		// btnHold = new JButton("Bill Hold F5");
		btnHold = new gnRoundButton("Bill Hold F5");
		btnHold.setBounds(299, 49, 125, 30);
		panel_4.add(btnHold);
		btnHold.setBackground(new Color(255, 204, 204));
		btnHold.setHorizontalAlignment(SwingConstants.LEFT);
		btnHold.setForeground(new Color(0, 0, 51));
		btnHold.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnHold.setMnemonic('H');

		lblNewLabel_2 = new JLabel("KOT");
		lblNewLabel_2.setBounds(310, 9, 56, 16);
		panel_4.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel_1 = new JLabel("Order Type");
		lblNewLabel_1.setBounds(12, 30, 87, 16);
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);

		comboOrderType = new JComboBox();
		comboOrderType.setEnabled(false);
		comboOrderType.setBounds(12, 18, 87, 13);
		panel_4.add(comboOrderType);
		comboOrderType.setForeground(new Color(0, 0, 51));
		comboOrderType.setBackground(new Color(255, 204, 204));
		comboOrderType.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		comboOrderType.setModel(new DefaultComboBoxModel(
				new String[] { "N/A", "TABLE", "HOME DELIVERY", "COUNTER", "SWIGGY", "ZOMATO" , "AC"}));
		comboOrderType.setSelectedItem("N/A");

		JLabel lblNewLabel_15 = new JLabel("Table");
		lblNewLabel_15.setBounds(111, 30, 59, 16);
		panel_4.add(lblNewLabel_15);
		lblNewLabel_15.setForeground(new Color(0, 0, 51));
		lblNewLabel_15.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);

		comboTable = new JComboBox();
		comboTable.setEnabled(false);
		comboTable.setBounds(111, 18, 69, 16);
		panel_4.add(comboTable);
		comboTable.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		comboTable.setForeground(new Color(0, 0, 51));
		comboTable.setBackground(new Color(255, 204, 204));

		orderno = new JTextField();
		orderno.setFont(new Font("Tahoma", Font.BOLD, 13));
		orderno.setBounds(199, 49, 97, 30);
		panel_4.add(orderno);
		orderno.setColumns(10);

		JLabel lblNewLabel_22 = new JLabel("Order No");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_22.setBounds(201, 30, 97, 16);
		panel_4.add(lblNewLabel_22);

		nordertype = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
				nordertype.grabFocus();
			}
		};

		nordertype.setFont(new Font("Tahoma", Font.BOLD, 17));
		nordertype.setBounds(12, 49, 87, 30);
		panel_4.add(nordertype);
		nordertype.setColumns(10);

		ntableno = new JTextField();
		ntableno.setFont(new Font("Tahoma", Font.BOLD, 17));
		ntableno.setBounds(107, 49, 80, 30);
		panel_4.add(ntableno);
		ntableno.setColumns(10);
		btnHold.addActionListener(hld);
		btnHold.addActionListener(hld);

		JLabel lblNewLabel_21 = new JLabel("MERETOO");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_21.setBounds(12, 29, 85, 24);
		HeaderPanel.add(lblNewLabel_21);

		JLabel lblInvoiceNumber = new JLabel("Invoice Number");
		lblInvoiceNumber.setBounds(149, 3, 123, 16);
		HeaderPanel.add(lblInvoiceNumber);
		lblInvoiceNumber.setForeground(new Color(0, 0, 51));
		lblInvoiceNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInvoiceNumber.setFont(new Font("Tahoma", Font.BOLD, 14));

		// invno = new JTextField();
		invno = new gnRoundTextField(20);
		invno.setBounds(278, 1, 121, 25);
		HeaderPanel.add(invno);
		invno.setText("0");
		invno.setForeground(new Color(0, 0, 51));
		invno.setBackground(new Color(51, 255, 255));
		invno.setEditable(false);
		invno.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		invno.setColumns(10);

		JLabel lblInvoiceDate = new JLabel("Invoice Date");
		lblInvoiceDate.setBounds(159, 34, 107, 16);
		HeaderPanel.add(lblInvoiceDate);
		lblInvoiceDate.setForeground(new Color(0, 0, 51));
		lblInvoiceDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInvoiceDate.setFont(new Font("Tahoma", Font.BOLD, 14));

		// invdate = new JTextField();
		invdate = new gnRoundTextField(20);
		invdate.setBounds(278, 29, 123, 24);
		HeaderPanel.add(invdate);
		invdate.setForeground(new Color(0, 0, 51));
		invdate.setBackground(new Color(51, 255, 255));
		invdate.setEditable(false);
		invdate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		invdate.setColumns(10);

		comboArticle = new JComboBox();
		comboArticle.setBounds(115, 15, 17, 23);
		HeaderPanel.add(comboArticle);

		SalesType = new JComboBox<String>();
		SalesType.setBounds(125, 18, 50, 19);
		HeaderPanel.add(SalesType);
		SalesType.setVisible(false);
		SalesType.setEnabled(false);
		SalesType.setModel(new DefaultComboBoxModel(new String[] { "", "Sale", "Rent" }));
		SalesType.setForeground(Color.WHITE);
		SalesType.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 10));
		SalesType.setMaximumRowCount(20);
		SalesType.setBackground(Color.WHITE);
		new gnComp().fillCombo(SQL11, SalesType);
		panelbillInfotemp.setVisible(false);

		pmt = new JPanel();
		pmt.setBounds(989, 523, 361, 208);
		// jun25
		POSFrame3_2.getContentPane().add(pmt);
		pmt.setBackground(new Color(153, 255, 255));
		pmt.setBorder(new TitledBorder(
				new TitledBorder(
						new TitledBorder(
								new TitledBorder(
										new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "",
												TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
										"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
								"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
						"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)),
				"Bill Details", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 102)));
		pmt.setLayout(null);

		//

		JLabel lblTotalAmount = new JLabel("Gross Amount ");
		lblTotalAmount.setBackground(new Color(102, 102, 102));
		lblTotalAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalAmount.setFont(new Font("Arial", Font.BOLD, 17));
		lblTotalAmount.setBounds(72, 17, 158, 23);
		pmt.add(lblTotalAmount);
		lblTotalAmount.setForeground(new Color(0, 0, 51));

		// Tamount = new JTextField();
		Tamount = new gnRoundTextField(20);
		Tamount.setHorizontalAlignment(SwingConstants.RIGHT);
		Tamount.setEditable(false);
		Tamount.setText("0.00");
		// Tamount.setForeground(new Color(204, 255, 255));
		Tamount.setBounds(232, 8, 113, 33);
		pmt.add(Tamount);
		Tamount.setBackground(Color.BLACK);
		Tamount.setFont(new Font("Segoe UI", Font.BOLD, 22));
		Tamount.setColumns(10);

		JLabel lblHeaderLevelDiscount = new JLabel("Bill Level Disc");
		lblHeaderLevelDiscount.setForeground(new Color(0, 0, 51));
		lblHeaderLevelDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHeaderLevelDiscount.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lblHeaderLevelDiscount.setBounds(95, 51, 125, 25);
		pmt.add(lblHeaderLevelDiscount);

		// hdrDiscount = new JFormattedTextField();
		hdrDiscount = new gnRoundTextField(20);
		hdrDiscount.setHorizontalAlignment(SwingConstants.RIGHT);
		hdrDiscount.setForeground(new Color(204, 255, 255));
		hdrDiscount.setBackground(Color.BLACK);
		hdrDiscount.setFont(new Font("Arial", Font.BOLD, 22));
		hdrDiscount.setBounds(232, 47, 113, 30);
		hdrDiscount.setText("0");
		pmt.add(hdrDiscount);

		JLabel lblNetPayableAmount = new JLabel("Net Amount ");
		lblNetPayableAmount.setBackground(Color.YELLOW);
		lblNetPayableAmount.setFont(new Font("Arial", Font.BOLD, 17));
		lblNetPayableAmount.setForeground(new Color(0, 0, 51));
		lblNetPayableAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNetPayableAmount.setBounds(112, 158, 115, 25);
		pmt.add(lblNetPayableAmount);

		// netAmount = new JFormattedTextField();
		netAmount = new gnRoundTextField(20);
		netAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		netAmount.setText("0.00");
		netAmount.setForeground(Color.GREEN);
		netAmount.setBackground(Color.BLACK);
		netAmount.setFont(new Font("Arial", Font.BOLD, 27));
		netAmount.setEditable(false);
		netAmount.setBounds(232, 141, 113, 54);
		pmt.add(netAmount);

		JLabel lblRoundingOffAmount = new JLabel("Round.Off");
		lblRoundingOffAmount.setForeground(new Color(0, 0, 51));
		lblRoundingOffAmount.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lblRoundingOffAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoundingOffAmount.setBounds(134, 111, 86, 22);
		pmt.add(lblRoundingOffAmount);

		// froundAmt = new JTextField();
		froundAmt = new gnRoundTextField(20);
		froundAmt.setHorizontalAlignment(SwingConstants.RIGHT);
		froundAmt.setFont(new Font("Arial", Font.BOLD, 22));
		froundAmt.setForeground(new Color(204, 255, 255));
		froundAmt.setBackground(Color.BLACK);
		froundAmt.setEditable(false);
		froundAmt.setBounds(232, 107, 113, 30);
		froundAmt.setText("0.00");
		pmt.add(froundAmt);

		JLabel lblRecords_1 = new JLabel("Records");
		lblRecords_1.setBounds(12, 45, 86, 23);
		pmt.add(lblRecords_1);
		lblRecords_1.setForeground(new Color(0, 0, 51));
		lblRecords_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));

		// records = new JTextField();
		records = new gnRoundTextField(20);
		records.setBounds(12, 65, 68, 26);
		pmt.add(records);
		records.setHorizontalAlignment(SwingConstants.CENTER);
		records.setBackground(Color.WHITE);
		records.setEditable(false);
		records.setForeground(Color.BLACK);
		records.setFont(new Font("Arial", Font.BOLD, 18));
		records.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Total Qty");
		lblNewLabel_9.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_9.setForeground(new Color(0, 0, 51));
		lblNewLabel_9.setBounds(12, 94, 86, 16);
		pmt.add(lblNewLabel_9);

		// showqty = new JTextField();
		showqty = new gnRoundTextField(20);
		showqty.setHorizontalAlignment(SwingConstants.CENTER);
		showqty.setForeground(Color.BLACK);
		showqty.setBackground(Color.WHITE);
		showqty.setFont(new Font("Arial", Font.BOLD, 18));
		showqty.setBounds(12, 111, 71, 25);
		pmt.add(showqty);
		showqty.setColumns(10);

		lblNewLabel_10 = new JLabel("Other Discount");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lblNewLabel_10.setForeground(new Color(0, 0, 51));
		lblNewLabel_10.setBounds(95, 80, 125, 23);
		pmt.add(lblNewLabel_10);

		// manualdisc = new JTextField();
		manualdisc = new gnRoundTextField(20);
		manualdisc.setHorizontalAlignment(SwingConstants.RIGHT);
		manualdisc.setForeground(new Color(204, 255, 255));
		manualdisc.setFont(new Font("Arial", Font.BOLD, 22));
		manualdisc.setBackground(Color.BLACK);
		manualdisc.setBounds(232, 77, 113, 30);
		pmt.add(manualdisc);
		manualdisc.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("-");
		lblNewLabel_16.setEnabled(false);
		lblNewLabel_16.setIcon(new ImageIcon(POS.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel_16.setBounds(2, 45, 381, 3);
		pmt.add(lblNewLabel_16);

		lblNewLabel_25 = new JLabel("POS3_2");
		lblNewLabel_25.setBounds(28, 163, 56, 16);
		pmt.add(lblNewLabel_25);

		// panelscan = new JPanel();
		panelscan = new gnRoundPanel();
		panelscan.setForeground(Color.WHITE);
		panelscan.setBounds(0, 181, 1362, 59);
		POSFrame3_2.getContentPane().add(panelscan);
		panelscan.setBackground(new Color(102, 255, 255));
		panelscan.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(51, 0, 204)));
		panelscan.setLayout(null);

		JLabel lblScanItem = new JLabel("Search Item Here Or Press Enter For All Item List ");
		lblScanItem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScanItem.setForeground(new Color(0, 0, 51));
		lblScanItem.setFont(new Font("Mangal", Font.BOLD, 12));
		lblScanItem.setBounds(67, -1, 359, 16);
		panelscan.add(lblScanItem);

		scanItem_2 = new JTextField();
		scanItem_2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		scanItem_2.setBorder(BorderFactory.createLineBorder(Color.GREEN));

		scanItem_2.setToolTipText("Max code Length is 5 ");
		scanItem_2.setForeground(new Color(0, 0, 102));
		scanItem_2.setFont(new Font("Arial", Font.BOLD, 16));
		scanItem_2.setBounds(115, 14, 308, 30);
		panelscan.add(scanItem_2);
		scanItem_2.setColumns(10);
		scanqty = new gnRoundTextField(12);
		scanqty.setFont(new Font("Arial", Font.BOLD, 16));
		scanqty.setForeground(Color.BLACK);
		scanqty.setBackground(Color.WHITE);
		scanqty.setBounds(432, 14, 85, 30);
		panelscan.add(scanqty);
		scanqty.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Rate");
		lblNewLabel_4.setFont(new Font("Mangal", Font.BOLD, 12));
		lblNewLabel_4.setForeground(new Color(0, 0, 51));
		lblNewLabel_4.setBounds(535, -2, 68, 18);
		panelscan.add(lblNewLabel_4);

		rate = new gnRoundTextField(12);
		rate.setFont(new Font("Arial", Font.BOLD, 16));
		rate.setForeground(Color.BLACK);
		rate.setBackground(Color.WHITE);
		rate.setBounds(521, 14, 90, 30);
		panelscan.add(rate);
		rate.setColumns(10);

		lblNewLabel_5 = new JLabel("Discount Amount");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Mangal", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(0, 0, 51));
		lblNewLabel_5.setBounds(585, 0, 165, 16);
		panelscan.add(lblNewLabel_5);

		disc = new gnRoundTextField(12);
		disc.setFont(new Font("Arial", Font.BOLD, 16));
		disc.setForeground(Color.BLACK);
		disc.setBackground(Color.WHITE);
		disc.setText("0");
		disc.setToolTipText("Please Enter Bill Level Disc.Amount If Applicable");
		disc.setBounds(615, 14, 141, 30);
		panelscan.add(disc);
		disc.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Qty");
		lblNewLabel_3.setFont(new Font("Mangal", Font.BOLD, 12));
		lblNewLabel_3.setForeground(new Color(0, 0, 51));
		lblNewLabel_3.setBounds(446, -2, 68, 18);
		panelscan.add(lblNewLabel_3);

		lblNewLabel_11 = new JLabel("Discount %");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Mangal", Font.BOLD, 12));
		lblNewLabel_11.setForeground(new Color(0, 0, 51));
		lblNewLabel_11.setBounds(733, 0, 112, 16);
		panelscan.add(lblNewLabel_11);

		// billhdrdiscper = new JTextField();
		billhdrdiscper = new gnRoundTextField(15);
		billhdrdiscper.setFont(new Font("Arial", Font.BOLD, 16));
		billhdrdiscper.setForeground(Color.BLACK);
		billhdrdiscper.setBackground(Color.WHITE);
		billhdrdiscper.setToolTipText("Please Enter Bill Level Disc% if Applicable ");
		billhdrdiscper.setBounds(759, 14, 98, 30);
		panelscan.add(billhdrdiscper);
		billhdrdiscper.setColumns(10);

		lblmsg = new JLabel("Message");
		lblmsg.setBackground(new Color(51, 0, 102));
		lblmsg.setForeground(new Color(0, 0, 0));
		lblmsg.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblmsg.setBounds(857, -1, 474, 34);
		panelscan.add(lblmsg);

		JLabel lbl = new JLabel("Taste");
		lbl.setBounds(12, -1, 91, 16);
		panelscan.add(lbl);

		taste = new JTextField();
		taste.setBounds(12, 13, 91, 31);
		panelscan.add(taste);
		taste.setColumns(10);

		btnArticle = new JButton("Create New Item");
		btnArticle.setForeground(Color.DARK_GRAY);
		btnArticle.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnArticle.setMnemonic('I');
		btnArticle.setBounds(992, 29, 178, 30);
		panelscan.add(btnArticle);

		btnCancel = new JButton("Cancel Order");
		btnCancel.setMnemonic('O');
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(1173, 29, 158, 29);
		panelscan.add(btnCancel);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(919, 14, 29, 30);
		panelscan.add(panel_3);
		panel_3.setVisible(false);
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);

		homeDelivery = new JCheckBox("Deliver At");
		homeDelivery.setBounds(0, 0, 197, 18);
		panel_3.add(homeDelivery);
		homeDelivery.setFont(new Font("Calibri", Font.BOLD, 15));
		homeDelivery.setForeground(Color.MAGENTA);
		homeDelivery.setBackground(Color.WHITE);

		hm_Phone = new JTextField();
		hm_Phone.setBounds(216, 2, 30, 15);
		panel_3.add(hm_Phone);
		hm_Phone.setBackground(new Color(102, 0, 102));
		hm_Phone.setForeground(new Color(0, 0, 153));
		hm_Phone.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_Phone.setToolTipText("Enter Phone Number  Max Char Allow 10");
		hm_Phone.setColumns(10);

		hm_addr3 = new JTextField();
		hm_addr3.setBounds(0, 83, 205, 22);
		panel_3.add(hm_addr3);
		hm_addr3.setEnabled(false);
		hm_addr3.setEditable(false);
		hm_addr3.setBackground(Color.WHITE);
		hm_addr3.setForeground(new Color(0, 0, 51));
		hm_addr3.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_addr3.setToolTipText("Enter City  Max Chars Allow is 30");
		hm_addr3.setColumns(10);

		hm_custname = new JTextField();
		hm_custname.setBounds(0, 107, 205, 22);
		panel_3.add(hm_custname);
		hm_custname.setEnabled(false);
		hm_custname.setEditable(false);
		hm_custname.setBackground(Color.WHITE);
		hm_custname.setForeground(new Color(0, 0, 51));
		hm_custname.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_custname.setToolTipText("Enter Name  Max Chars Allow is 30");
		hm_custname.setColumns(10);

		JLabel lblSearchBillNo = new JLabel("View Bill");
		lblSearchBillNo.setBounds(187, 71, 57, 18);
		panel_3.add(lblSearchBillNo);
		lblSearchBillNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSearchBillNo.setForeground(Color.DARK_GRAY);

		billsearch = new JTextField();
		billsearch.setBounds(243, 66, 59, 27);
		panel_3.add(billsearch);
		billsearch.setBackground(Color.WHITE);
		billsearch.setForeground(Color.DARK_GRAY);
		billsearch.setFont(new Font("Arial", Font.BOLD, 15));
		billsearch.setColumns(10);
		billsearch.addActionListener(lk999);

		panelscan.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { scanItem_2, scanName22, scanqty, rate, disc }));

		// Site_code = new JTextField();
		Site_code = new gnRoundTextField(20);
		Site_code.setBounds(0, 3, 680, 28);
		POSFrame3_2.getContentPane().add(Site_code);
		Site_code.setForeground(new Color(0, 0, 51));
		Site_code.setBackground(Color.WHITE);
		Site_code.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		Site_code.setEditable(false);
		Site_code.setColumns(10);

		// btn_Payment = new JButton("Payment");
		btn_Payment = new gnRoundButton("Payment");
		btn_Payment.setBounds(989, 483, 123, 38);
		POSFrame3_2.getContentPane().add(btn_Payment);
		btn_Payment.setText("Payment-F7");
		btn_Payment.setText("Payment-F7");

		btn_Payment.setSelectedIcon(new ImageIcon(POS.class.getResource("/RetailProduct/btnPayment2.png")));
		btn_Payment.setBackground(new Color(204, 255, 204));
		btn_Payment.setForeground(Color.BLACK);
		btn_Payment.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Payment.setMnemonic('P');
		btn_Payment.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));

		// btn_Save = new JButton("Save-F8");
		btn_Save = new gnRoundButton("Save-F8");
		btn_Save.setBounds(1110, 483, 122, 38);
		POSFrame3_2.getContentPane().add(btn_Save);
		btn_Save.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_Save.setSelectedIcon(new ImageIcon(POS.class.getResource("/RetailProduct/btnApsave1.png")));
		btn_Save.setIcon(null);
		btn_Save.setBackground(new Color(0, 0, 102));
		btn_Save.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Save.setForeground(new Color(153, 255, 153));
		btn_Save.setMnemonic('S');
		btn_Save.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		// POSFrame.getContentPane().add(choicepanel);

		btn_print = new JButton("Print");
		btn_print.setBounds(1231, 483, 119, 38);
		POSFrame3_2.getContentPane().add(btn_print);
		btn_print.setIcon(null);
		btn_print.setSelectedIcon(new ImageIcon(POS.class.getResource("/RetailProduct/btnPrint2.png")));
		btn_print.setHorizontalAlignment(SwingConstants.LEFT);
		btn_print.setBackground(new Color(0, 255, 255));
		btn_print.setForeground(new Color(0, 0, 204));
		btn_print.setMnemonic('T');
		btn_print.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		btn_print.addActionListener(lsprint);
		btn_Save.addActionListener(lssave1);
		btnCancel.addActionListener(lssave1);
		btnArticle.addActionListener(lssave1);

		btn_Payment.addActionListener(l2);

		pmtPanel = new JPanel();
		Pjsp_1 = new JScrollPane();
		Pjsp_1.setBounds(5, 104, 350, 98);
		pmtPanel.add(Pjsp_1);
		Pjsp_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.CYAN);
		prt1.add(ptable, PCol);
		Pjsp_1.setViewport(prt1);

		JLabel lblTotalAmount_1 = new JLabel("Bill Value");
		lblTotalAmount_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalAmount_1.setBounds(140, 10, 92, 20);
		pmtPanel.add(lblTotalAmount_1);
		lblTotalAmount_1.setForeground(new Color(0, 0, 51));
		lblTotalAmount_1.setFont(new Font("Tahoma", Font.BOLD, 14));

		// Final_Tamt = new JTextField();
		Final_Tamt = new gnRoundTextField(20);
		Final_Tamt.setEditable(false);
		Final_Tamt.setBounds(244, 2, 112, 32);
		Final_Tamt.setFont(new Font("Arial Black", Font.BOLD, 23));
		pmtPanel.add(Final_Tamt);
		Final_Tamt.setColumns(10);

		JLabel lblPaidAmount = new JLabel("Amount Paid");
		lblPaidAmount.setForeground(new Color(0, 0, 51));
		lblPaidAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPaidAmount.setBounds(225, 47, 107, 16);
		pmtPanel.add(lblPaidAmount);
		lblPaidAmount.setFont(new Font("Tahoma", Font.BOLD, 14));

		// Final_Pamt = new JTextField();
		Final_Pamt = new gnRoundTextField(20);
		Final_Pamt.setEditable(false);
		Final_Pamt.setBounds(237, 69, 112, 32);
		new General().setNumerOnlyforJtext(Final_Pamt);
		Final_Pamt.setDocument(new gnSetinputLimit(10));
		pmtPanel.add(Final_Pamt);
		Final_Pamt.setFont(new Font("Tahoma", Font.BOLD, 18));
		Final_Pamt.setColumns(10);

		JLabel lblPaymentDue = new JLabel("Due Amount");
		lblPaymentDue.setForeground(new Color(0, 0, 51));
		lblPaymentDue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPaymentDue.setBounds(140, 215, 95, 21);
		pmtPanel.add(lblPaymentDue);
		lblPaymentDue.setFont(new Font("Tahoma", Font.BOLD, 14));

		// Final_Damt = new JTextField();
		Final_Damt = new gnRoundTextField(20);
		Final_Damt.setForeground(Color.YELLOW);
		Final_Damt.setBackground(Color.BLACK);
		Final_Damt.setEditable(false);
		Final_Damt.setBounds(237, 203, 112, 38);
		pmtPanel.add(Final_Damt);
		Final_Damt.setFont(new Font("Arial Narrow", Font.BOLD, 21));
		Final_Damt.setColumns(10);

		custamountPaid = new JTextField();
		custamountPaid.setFont(new Font("Arial", Font.BOLD, 18));
		custamountPaid.setBounds(5, 65, 173, 38);
		pmtPanel.add(custamountPaid);
		custamountPaid.setColumns(10);

		payCombo = new JComboBox();
		payCombo.setBackground(Color.WHITE);
		payCombo.setForeground(Color.DARK_GRAY);
		payCombo.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		payCombo.setBounds(5, 18, 145, 27);
		pmtPanel.add(payCombo);

		JLabel lblNewLabel_8 = new JLabel("Payment Mode");
		lblNewLabel_8.setForeground(new Color(0, 0, 51));
		lblNewLabel_8.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_8.setBounds(5, 2, 123, 16);
		pmtPanel.add(lblNewLabel_8);

		docno = new JTextField();
		docno.setText("0");
		docno.setEditable(false);
		docno.setBounds(183, 66, 42, 38);
		pmtPanel.add(docno);
		docno.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Enter Amount");
		lblNewLabel_14.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_14.setBounds(5, 47, 127, 16);
		pmtPanel.add(lblNewLabel_14);

		ptable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ActionListener billlike = new lsSave();
		ActionListener mnname = new lsnritemName();
		ActionListener hm = new hmDel_lsnr();
		ActionListener scanQty = new scanqtyLsnr();
		ActionListener scanRate = new scanrateLsnr();
		ActionListener docls = new doctorLsnr();
		ActionListener patls = new patientLsnr();

		ActionListener paymentinsertls = new custamtpaidLsnr();
		ActionListener lsdiscper = new discperLsnr();
		ActionListener lsdiscamt = new discitemLsnr();
		ActionListener paycomboLsnr = new LsnrPaycombo();
		ActionListener mypaycomboLsnr = new paymentLsnnr();
		ActionListener itemcodeLsnr = new myitemcodeLsnr();

		custamountPaid.addActionListener(paymentinsertls);
		payCombo.addActionListener(paycomboLsnr);
		btnClose.addActionListener(l2);
		btnClose.addActionListener(lssave1);
		btnMerge.addActionListener(lssave1);
		scanqty.addActionListener(scanQty);
		rate.addActionListener(scanRate);
		billhdrdiscper.addActionListener(lsdiscper);
		disc.addActionListener(lsdiscamt);
		scanItem_2.addActionListener(itemcodeLsnr);
		btn_Payment.addActionListener(mypaycomboLsnr);

		ActionListener lsartcomb = new articleComboLsnr();
		ActionListener mobilels = new lsnrMobile();
		mobile.addActionListener(mobilels);

		ActionListener newcusls = new newcustLsne();
		btnNewButton.addActionListener(newcusls);

		ActionListener custidLsnr = new custls();
		custid.addActionListener(custidLsnr);

		btnSalesLike.addActionListener(billlike);

		KeyListener kk = new keyPressedlsnr();
		editqty.addKeyListener(kk);
		btnMerge.addKeyListener(kk);
		mergetable1.addKeyListener(kk);
		mergetable2.addKeyListener(kk);
		mergetable3.addKeyListener(kk);
		btnMerge.addKeyListener(kk);

		edittaste.addKeyListener(kk);
		editrate.addKeyListener(kk);
		editdisc.addKeyListener(kk);
		btn_Save.addKeyListener(kk);
		btn_Payment.addKeyListener(kk);
		custid.addKeyListener(kk);
		custname.addKeyListener(kk);
		hm_addr1.addKeyListener(kk);
		hm_addr2.addKeyListener(kk);

		FocusListener fls = new btnfocus();
		btn_Payment.addFocusListener(fls);
		btnMerge.addFocusListener(fls);
		btn_Save.addFocusListener(fls);
		comboTable.addFocusListener(fls);
		comboOrderType.addFocusListener(fls);
		btnNewButton.addFocusListener(fls);

		ActionListener lstaste = new tasteLsnr();

		taste.addActionListener(lstaste);
		btnHold.addKeyListener(kk);
		btnHold.addFocusListener(fls);

		comboArticle.addActionListener(lsartcomb);

		ActionListener nordertypeLsnr = new norderLsnr();
		nordertype.addActionListener(nordertypeLsnr);

		ActionListener nordernoLsnr = new nordernoLsnr();
		orderno.addActionListener(nordernoLsnr);

		ActionListener ntablenonoLsnr = new ntablenoLsnr();
		ntableno.addActionListener(ntablenonoLsnr);
		homeDelivery.addActionListener(hm);

		// ActionListener merglsnr = new mergeLsnr();
		// mergetable1.addActionListener(editls);
		// mergetable2.addActionListener(editls);
		// mergetable3.addActionListener(editls);

		decorate();
	}

	/// Start coding from Herea

	public void decorate() throws Throwable {
		mobile.setDocument(new gnSetinputLimit(10));
		new General().setNumerOnlyforJtext(mobile);

		String vpara916 = "913";
		GetPriceFromMenuList = new getConfigurationSetting().getSpecificConfiguration(vpara916);
		// new General().msg(GetPriceFromMenuList);

		switch (GetPriceFromMenuList) {
		case "N": // old logic price will take from config base + / - Structure
			getPricePolicy(); // From Configuration for base price and add/sub
								// on baseprice
			break;
		case "Y":
			break;
		}

		lblmsg.setText("Ready For New Bill<Select Order Type & Table If Customer Is WALKIN>");
		comboArticle.setVisible(false);
		btnNewButton.setEnabled(true);
		comboOrderType.setEnabled(false);
		new gnApp().setFrameTitel(POSFrame3_2);

		delTableRow(table, model, "POS");
		delorder(promotable, promomodel, "POSOrder");
		POSPayment(table, model, "POS"); // F7 Payment
		POSBillSave(table, model, "POS"); // F8 Save Bill
		BillHold(table, model, "POS"); // F5 For Bill Hold
		promotable(table, model, "POS"); // F10 for Order List Below Table
		displayOrderList(table, model, "POS"); // Dispa
		orderType(table, model, "POS"); // O For Order Type
		myTable(table, model, "POS"); // T Char For Payment
		CustomerPanel(table, model, "POS"); // Focus is Customer Panel For
		savecustomer(table, model, "POS"); // save customer
		mergetable(table, model, "POS"); // Merge Table Bill

		setPaymentPanel();
		possplit.setDividerLocation(0);
		vstore = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		btnDayEnd.setEnabled(false);
		String vpara811 = "811";
		vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			rateDisable();
		}
		SalesType.setSelectedItem("Sale");
		btnSalesLike.setVisible(false);
		// billtimePanel.setVisible(false);
		this.checkInternet();
		chekcFreezeYear();
		vverticlecode = new gnHierarchy().getVerticleCode();

		String vpara714 = "714";
		String vframeclosable = new getConfigurationSetting().getSpecificConfiguration(vpara714);
		switch (vpara714) {
		case "N":
			POSFrame3_2.setUndecorated(false);
			break;
		case "Y":
			POSFrame3_2.setUndecorated(false);
			break;
		}

		btnDeclaration.setEnabled(false);
		btn_SalesReturn.setEnabled(false);

		JTextPane txtpnFViewOrder = new JTextPane();
		txtpnFViewOrder.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		txtpnFViewOrder.setToolTipText("Help Keys For Shorcuts");
		txtpnFViewOrder.setBorder(new MatteBorder(0, 2, 2, 0, (Color) new Color(64, 64, 64)));
		txtpnFViewOrder.setText(
				"\r\n F1-  Order Item List <Press F10 For Hold Orders>\r\n F2 - For Order Type  < Change Order Type>\r\n F3- For Table             <Change Table >\r\n F5- For Hold Bill\r\n F6- Merge Table\r\n F7- For Payment\r\n F8- For Save\r\n F9- For Cutomer Search/Customer Window\r\n F10- Order List     <To See Hold Orders>\r\n F11-Save Customer\r\n\r\nAlt+I   New Item\r\nAlt+O Cancel Order (Cursor Must Be In Order List Press F10 For Order List)\r\n=============================\r\n  ");
		txtpnFViewOrder.setBounds(989, 253, 337, 216);
		txtpnFViewOrder.setEditable(false);

		POSFrame3_2.getContentPane().add(txtpnFViewOrder);

		billtimePanel = new JPanel();
		billtimePanel.setBounds(1027, 4, 323, 27);
		POSFrame3_2.getContentPane().add(billtimePanel);
		billtimePanel.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		billtimePanel.setBackground(Color.WHITE);
		billtimePanel.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Start Time");
		lblNewLabel_6.setForeground(new Color(0, 0, 153));
		lblNewLabel_6.setBounds(0, 8, 63, 16);
		billtimePanel.add(lblNewLabel_6);

		starttime = new JTextField();
		starttime.setForeground(Color.BLACK);
		starttime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		starttime.setBounds(64, 2, 72, 28);
		billtimePanel.add(starttime);
		starttime.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Finish Time");
		lblNewLabel_7.setForeground(new Color(0, 0, 153));
		lblNewLabel_7.setBounds(136, 8, 72, 16);
		billtimePanel.add(lblNewLabel_7);

		endtime = new JTextField();
		endtime.setForeground(Color.BLACK);
		endtime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		endtime.setBounds(208, 0, 63, 28);
		billtimePanel.add(endtime);
		endtime.setColumns(10);

		JPanel dispPanel = new JPanel();
		dispPanel.setBounds(757, 3, 266, 33);
		POSFrame3_2.getContentPane().add(dispPanel);
		dispPanel.setBackground(Color.WHITE);
		// JPanel dispPanel = new gnRoundPanel();

		dispPanel.setBorder(null);
		dispPanel.setLayout(null);

		JLabel lblCashier = new JLabel("User");
		lblCashier.setBounds(0, 4, 28, 22);
		dispPanel.add(lblCashier);
		lblCashier.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCashier.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCashier.setForeground(Color.BLACK);

		// cashiercode = new JTextField();
		cashiercode = new gnRoundTextField(10);
		cashiercode.setHorizontalAlignment(SwingConstants.CENTER);
		cashiercode.setBounds(29, 4, 50, 22);
		dispPanel.add(cashiercode);
		cashiercode.setFont(new Font("Agency FB", Font.BOLD, 12));
		cashiercode.setBackground(Color.WHITE);
		cashiercode.setForeground(Color.BLACK);
		cashiercode.setEditable(false);
		cashiercode.setColumns(10);

		JLabel lblNewLabel = new JLabel("Shift");
		lblNewLabel.setBounds(72, 10, 31, 15);
		dispPanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		// lblNewLabel .setVisible(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setForeground(Color.BLACK);

		// shift = new JTextField();
		shift = new gnRoundTextField(10);
		shift.setHorizontalAlignment(SwingConstants.CENTER);
		shift.setBounds(112, 6, 50, 22);
		dispPanel.add(shift);
		shift.setFont(new Font("Agency FB", Font.BOLD, 12));
		// shift.setVisible(false);
		shift.setBackground(Color.WHITE);
		shift.setForeground(Color.BLACK);
		shift.setEditable(false);
		shift.setColumns(10);

		JLabel lblTerminalId = new JLabel("Terminal");
		lblTerminalId.setBounds(169, 10, 50, 15);
		dispPanel.add(lblTerminalId);
		// lblTerminalId.setVisible(false);
		lblTerminalId.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTerminalId.setForeground(Color.BLACK);

		// terminalID = new JTextField();
		terminalID = new gnRoundTextField(10);
		terminalID.setHorizontalAlignment(SwingConstants.CENTER);
		terminalID.setBounds(209, 6, 45, 22);
		dispPanel.add(terminalID);
		terminalID.setFont(new Font("Agency FB", Font.BOLD, 12));
		terminalID.setBackground(Color.WHITE);
		terminalID.setForeground(Color.BLACK);
		terminalID.setEditable(false);
		terminalID.setColumns(10);
		vdoccode = "0";
		vallowday = new gnDate().checkDayBegin();
		switch (vallowday) {
		case "Y":
			new gnApp().setFrameTitel(POSFrame3_2);
			conn = this.getConnection();
			vstore = new gnConfig().getStoreID();
			vcomp = new gnConfig().getCompanyCode();
			compName = new gnConfig().getCompany();
			vvcashiercode = new gnConfig().getUserCode();
			vverticlecode = new gnHierarchy().getVerticleCode();
			String vmasname = "Table";
			new gnComp().fillMasterCombo(comboTable, vmasname);

			String vmsname = "PaymentMode";
			String SQL1 = " call master_getMasterData('" + vmsname + "' , " + vverticlecode + " ,  '"
					+ vmastersearchString + "')";
			new gnComp().fillCombo(SQL1, payCombo);

			terminalID.setText(new gnConfig().getTerminalID());
			// PaymentWindow Popup Allow Config
			String vpara712 = "712";
			vallowPopWindow = new getConfigurationSetting().getSpecificConfiguration(vpara712);
			if (vcomp == "0") {
				System.exit(0);
			}
			Site_code.setText(compName);
			invdate.setText(new gnConfig().getDaybeginDate());
			String vtype = "SALE";
			String vallowDate = new gnDate().checkBackDateTrAllow(vtype, invdate.getText());
			switch (vallowDate) {
			case "N":
				invdate.setBackground(Color.RED);
				invdate.setForeground(Color.WHITE);
				new General().msg("Back Date For Transaction is not Allow..");
				new gnLogger().loggerInfoEntry("!!!BackDateEntry!!!", "Back Date For Transaction is not Allow..");
				new gnImageSound().playAlertSound();
				invdate.setText("?");
				// scanItem_2.setVisible(false);
				// scanName22.setVisible(false);
				btnDayBegin.setVisible(false);
				btn_Payment.setVisible(false);
				btn_Save.setVisible(false);
				break;
			}

			scanItem_2.grabFocus();
			custid.setText("0");
			int vterminal = Integer.parseInt(terminalID.getText().toString());
			shift.setText((new gnConfig().getCashierShift(vcomp, vstore,
					new gnConfig().date_ConverttoDBforamt(invdate.getText()), vterminal, vvcashiercode)));
			cashiercode.setText(vvcashiercode);
			btn_Save.setEnabled(false);
			new gnLogger().loggerInfoEntry("POS", "setting pos type");
			setVerticlePOS();
			new gnLogger().loggerInfoEntry("POS", "setting Configuration ...");
			setConfiguratin();

			//////

			// scanItem_2.setDocument(new gnSetinputLimit(12));
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
			new gnDecorate().DispField_Eatch(scanItem_2, 20);

			// new gnDecorate()ow.DispField_Eatch(custid,20);
			new gnDecorate().DispField_Eatch(records, 20);
			new gnDecorate().DispField_Eatch(showqty, 20);

			new gnDecorate().DispField_Eatch(cashiercode, 20);

			new gnDecorate().DispField_Beval_int(Tamount, 1);
			new gnDecorate().DispField_Beval_int(netAmount, 1);
			new gnDecorate().DispField_Beval_int(hdrDiscount, 1);
			new gnDecorate().DispField_Beval_int(froundAmt, 1);
			new gnDecorate().DispField_Beval_int(manualdisc, 1);

			// Final_Damt.setForeground(Color.blue);

			new gnDecorate().setTextFieldBackgroud1(Tamount);
			new gnDecorate().DispField_Eatch(hm_Phone, 20);
			new gnDecorate().DispField_Eatch(hm_custname, 20);
			String vvertname = this.verticlename;

			btn_print.setBackground(new Color(199, 21, 133));
			btn_print.setForeground(new Color(204, 255, 153));
			new gnStyleButtonSqr().getStyleButton(btnClose, new Color(178, 11, 112), Color.WHITE);

			hm_Phone.setEditable(false);
			hm_custname.setEditable(false);
			// getScanDataForBilling();
			JspPanel.setBounds(0, 0, 950, 532);
			jsp.setBounds(0, 0, 1325, 560);
			Dpanel.add(jsp);
			comboOrderType.setSelectedItem("N/A");
			comboOrderType.setEnabled(true);
			comboTable.setSelectedItem("0");
			comboTable.setVisible(false);
			checkTableishold();
			break;
		case "N":
			POSFrame3_2.dispose();
			break;
		}
	}

	public void setStandardData() throws Throwable {

		conn = this.getConnection();
		vstore = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		compName = new gnConfig().getCompany();
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
			// Site_code.setText(vstore);
			invdate.setText(new gnConfig().getDaybeginDate());
			scanItem_2.grabFocus();
			custid.setText("0");
			terminalID.setText(new gnConfig().getTerminalID());
			int vterminal = Integer.parseInt(terminalID.getText().toString());
			shift.setText((new gnConfig().getCashierShift(vcomp, vstore,
					new gnConfig().date_ConverttoDBforamt(invdate.getText()), vterminal, vvcashiercode)));
			vvcashiercode = new gnConfig().getUserCode();
			cashiercode.setText(vvcashiercode);
			btn_Save.setEnabled(false);
			new gnLogger().loggerInfoEntry("POS", "Setting POS Type");
			setVerticlePOS();
			new gnLogger().loggerInfoEntry("POS", "Setting Configuration Types");
			ordertype.grabFocus();
			// setConfiguratin();
		}
	}

	class myitemcodeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent r) {
			String value = r.getActionCommand();
			int i = r.getID(); // Field id
			if (i == 1001) {
				if (vallowday == "N") {
					POSFrame3_2.dispose();
					new General().msg("Complete Day Begin First...");
					return;
				}
				String result = ValidateItem(value);
				if (result == "Sucess")
					try {
						value = value.trim();
						QueryStatus = "N";
						try {
							String nn1 = showTableData(value, model);
						} catch (Exception rr) {
							rr.printStackTrace();
						}
						// new General().msg(QueryStatus);
						if (QueryStatus == "N") {
							searchbyShortKeys();
							if (promotable.getRowCount() == 0) {
								namesearch();
							}
						}
						QueryStatus = "N";
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().msg("ShowTableData search/Scan Item" + " " + e1.getMessage());
					}
				return;
			} // Item Scan
		}
	}

	private void searchbyShortKeys() {
		String sname = scanItem_2.getText().trim();
		String vType = "Article";
		String vtrantype = "POS";
		try {
			if (varticle != null && varticle.length() > 0) {
				String vpara716 = "716";
				String vallowpopupHelp = new getConfigurationSetting().getSpecificConfiguration(vpara716);
				switch (vallowpopupHelp) {
				case "Y":
					new gnAdmin().Search(vType, sname, varticle, vtrantype); // if
					break;
				case "N":
					String status = checkOrderType();
					if (status == "Sucess") {
						promotable = new gnAdmin().SearchintabeByShortKey(vType, sname);
						showArticleNameSearchResult(promotable);
						int row = promotable.getRowCount();
						if (row > 0) {
							promotable.grabFocus();
							SelectionType = "Article";
						}
						SelectionType = "Article";
					}
					break;
				}
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
				// setSearchArticle() ; //Not in use forevert dont uncomment it
				String vpara716 = "716";
				String vallowpopupHelp = new getConfigurationSetting().getSpecificConfiguration(vpara716);
				switch (vallowpopupHelp) {
				case "Y":
					varticle = new gnAdmin().rArticle;
					if (varticle != "0") {
						showTableData(varticle, model);
						new gnAdmin().rArticle = "0";
					}
					varticle = "0";
				}
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	private void namesearch() {
		String sname = scanItem_2.getText().trim();
		sname = "%" + sname + "%";
		String vType = "Article";
		String vtrantype = "POS";
		try {
			if (varticle != null && varticle.length() > 0) {
				String vpara716 = "716";
				String vallowpopupHelp = new getConfigurationSetting().getSpecificConfiguration(vpara716);
				switch (vallowpopupHelp) {
				case "Y":
					new gnAdmin().Search(vType, sname, varticle, vtrantype); // if
					break;
				case "N":
					String status = checkOrderType();
					if (status == "Sucess") {
						promotable = new gnAdmin().Searchintabe(vType, sname, varticle, vtrantype);
						// showArticleNameSearchResult(promotable);
						showArticleNameSearchResult1();
						int row = promotable.getRowCount();
						if (row > 0) {
							promotable.grabFocus();
							SelectionType = "Article";
						} else {
							scanItem_2.setText(null);
							scanItem_2.grabFocus();
						}
						SelectionType = "Article";
					}
					break;
				}
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
				// setSearchArticle() ; //Not in use forevert dont uncomment it
				String vpara716 = "716";
				String vallowpopupHelp = new getConfigurationSetting().getSpecificConfiguration(vpara716);
				switch (vallowpopupHelp) {
				case "Y":
					varticle = new gnAdmin().rArticle;
					if (varticle != "0") {
						showTableData(varticle, model);
						new gnAdmin().rArticle = "0";
						scanName2.setText("");
						scanItem_2.grabFocus();
					}
					varticle = "0";
				}
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class paymentLsnnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			if (table.getRowCount() > 0) {
				processPaymentNow();
			}
		}
	}

	private void setPaymentPanel() {

		// pmtPanel.setBounds(903, 169, 41, 25);
		POSFrame3_2.getContentPane().add(pmtPanel);
		pmtPanel.setBounds(989, 242, 361, 243);
		pmtPanel.setBackground(Color.WHITE);
		pmtPanel.setBorder(new MatteBorder(0, 2, 2, 0, (Color) new Color(64, 64, 64)));
		pmtPanel.setLayout(null);
		pmtPanel.setVisible(false);
	}

	private void processPaymentNow() {

		if (!comboOrderType.getSelectedItem().toString().trim().equals("N/A")) {
			try {
				promoModuleActivated = "N";
				switch (promoModuleActivated) {
				case "Y":
					String vdocno = invno.getText();
					String vdocdate = invdate.getText();
					new gnPromoGetInfo().refreshPromoTables(vdocno, vdocdate);
					startPromoApplyProcess();
					break;
				}

				switch (vallowPopWindow) // New Change for payment
				{
				case "N":
					pmt.setVisible(false);
					pmtPanel.setVisible(true); // original Line
					String vorder = comboOrderType.getSelectedItem().toString().trim();
					switch (vorder) {
					case "SWIGGY":
						payCombo.setSelectedItem("SWIGGY");
						custamountPaid.setText(netAmount.getText());
						custamountPaid.setBackground(Color.BLACK);
						custamountPaid.setForeground(Color.WHITE);
						break;
					case "ZOMATO":
						payCombo.setSelectedItem("ZOMATO");
						custamountPaid.setText(netAmount.getText());
						custamountPaid.setBackground(Color.BLACK);
						custamountPaid.setForeground(Color.WHITE);
						break;
					case "TABLE":
						payCombo.setSelectedItem("Cash");
						custamountPaid.setText(netAmount.getText());
						custamountPaid.setBackground(Color.WHITE);
						custamountPaid.setForeground(Color.BLUE);
						break;

					case "HOME DELIVERY":
						payCombo.setSelectedItem("Cash");
						custamountPaid.setText(netAmount.getText());
						custamountPaid.setBackground(Color.WHITE);
						custamountPaid.setForeground(Color.BLUE);
						break;

					case "COUNTER":
						payCombo.setSelectedItem("Cash");
						custamountPaid.setText(netAmount.getText());
						custamountPaid.setBackground(Color.WHITE);
						custamountPaid.setForeground(Color.BLUE);
						break;

					}
					String isrequire = checkKOTForWOHoldBillType();
					custamountPaid.grabFocus();
					new gnTable().RemoveTableRows(promomodel);
					break;

				case "Y":
					break;
				}
				insertPaymentRow();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
			return;
		} else {
			new General().msg("Please Select Order Type .... ");
			comboOrderType.grabFocus();
			comboOrderType.setEnabled(true);
			comboOrderType.setEditable(true);
		}
	}

	class LsnrPaycombo implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vname = payCombo.getSelectedItem().toString().trim();
			// new General().msg("Yes.."+ " "+vname) ;;
			switch (vname) {
			case "CN":
				try {
					// new General().msg("Yes.."+ " "+vname) ;;
					showCreitNote(vname);
					// checkpaymentMode() ;
				} catch (Throwable e) {
					e.printStackTrace();
				}

			}
		}
	}

	private void showCreitNote(String vname) throws Throwable {
		Double vpaid = 0.00;
		paidAmount = 0.00;
		int rw = ptable.getSelectedRow();
		vpaid = Double.parseDouble((String) ptable.getValueAt(rw, 2));
		String pmode = (String) ptable.getValueAt(rw, 1).toString();
		switch (vname) {
		case "CN":
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

	public void checkpaymentMode() throws Throwable {
		Double vpaid = 0.00;
		paidAmount = 0.00;
		int rw = ptable.getSelectedRow();
		vpaid = Double.parseDouble((String) ptable.getValueAt(rw, 2));
		String pmode = (String) ptable.getValueAt(rw, 1).toString();
		switch (pmode) {
		case "CN":
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

	class discperLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vvdiscper = billhdrdiscper.getText();
			double vdiscper = Double.parseDouble(vvdiscper);
			double vdiscamt = 0.0;
			double vgross = 0.0;
			double vmygross = 0.0;
			String vapplydiscountonfooditem = "Y";
			try {
				int row = table.getRowCount();
				if (row > 0) {
					for (int i = 0; i < row; i++) {
						switch (vapplydiscountonfooditem) {
						case "Y":
							String vmyarticle = (table.getValueAt(i, 1).toString());
							String vtype = "Articletype";
							String varticletype = new gnArticle().Article_getData(vmyarticle, vtype);
							if (varticletype.equals("11")) {
								vgross = Double.parseDouble(table.getValueAt(i, 6).toString());
								vmygross = vmygross + vgross;
								vdiscamt = (vmygross * vdiscper / 100);
								disc.setText(Double.toString(vdiscamt));
							}
							break;

						case "N":
							vgross = Double.parseDouble(table.getValueAt(i, 6).toString());
							vmygross = vmygross + vgross;
							vdiscamt = (vmygross * vdiscper / 100);
							disc.setText(Double.toString(vdiscamt));
							break;
						}
					}
				}
				DistributeDiscountper(vvdiscper);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class discitemLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			double vdisamt = Double.parseDouble(disc.getText());
			double vgross = 0.0;
			double vmygross = 0.0;
			String vmydiscper = null;
			int row = table.getRowCount();
			if (row > 0) {
				for (int i = 0; i < row; i++) {
					vgross = Double.parseDouble(table.getValueAt(i, 6).toString());
					vmygross = vmygross + vgross;
				}
				double vmydidcper = (vdisamt / vmygross) * 100;
				vmydiscper = new gnMath().get2DecimaltValue(Double.toString(vmydidcper));
			}
			try {
				DistributeDiscountper(vmydiscper);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	public void DistributeDiscountper(String vvdiscper) throws Throwable {
		double vqty = 0.00;
		double vdiscper = Double.parseDouble(vvdiscper);
		double vgross = 0.00;
		double proposeDiscount = 0.0;
		double issueDiscount = 0.0;
		double vdiscamt = 0.00;
		// { "Romove", "Item", "Name", "Qty", "Rate", "MRP", "Gross", "Bill
		// Disc", "Disc", "Tax" ,
		// "Amount", "Taxcode", "Batch Item", "BatchNo", "Return Date",
		// "Free(Qty)/Disc" };
		String vmydiscamt = "0";
		proposeDiscount = Double.parseDouble(disc.getText());
		int row = table.getRowCount();
		if (row > 0) {
			for (int i = 0; i < row; i++) {

				String vmyarticle = (table.getValueAt(i, 1).toString());
				String vtype = "Articletype";
				String varticletype = new gnArticle().Article_getData(vmyarticle, vtype);
				switch (varticletype) {
				case "11":
					vgross = Double.parseDouble(table.getValueAt(i, 6).toString());
					// vgross = Double.parseDouble(table.getValueAt(i,
					// 11).toString());
					vdiscamt = vgross * vdiscper / 100;
					issueDiscount = issueDiscount + vdiscamt;
					vmydiscamt = new gnMath().get2DecimaltValue(Double.toString(vdiscamt));

					switch (Promohdrdisc) {
					case "Y":
						if (vprompTypecode == "3") {
							table.setValueAt(vmydiscamt, i, 8);
						} else {
							table.setValueAt(vmydiscamt, i, 9);
						}
						break;

					case "N":
						table.setValueAt(vmydiscamt, i, 7);
						break;
					}
				}
			}
		}

		issueDiscount = proposeDiscount - issueDiscount;
		// new General().msg("Additional discount:"+ issueDiscount);
		if (issueDiscount != proposeDiscount) {
			double vtablecoldisc = Double.parseDouble(table.getValueAt(0, 7).toString());
			vtablecoldisc = vtablecoldisc + issueDiscount;
			String vchanddisc = new gnMath().get2DecimaltValue(Double.toString(vtablecoldisc));
			table.setValueAt(vchanddisc, 0, 7);
		}

		new gnLogger().loggerInfoEntry("GRN", "Hdr Discount Distributed- Sucess");
		recalculateData();
		calHdrDisocunt();
	}

	public void DistributeDiscountperForBillLevel(String vvdiscper) throws Throwable {
		double vqty = 0.00;
		double vdiscper = Double.parseDouble(vvdiscper);
		double vgross = 0.00;
		double vdisc1 = 0.00;
		double vdisc2 = 0.00;

		double vdiscamt = 0.00;
		// { "Romove", "Item", "Name", "Qty", "Rate", "MRP", "Gross", "Bill
		// Disc", "Disc", "Tax" ,
		// "Amount", "Taxcode", "Batch Item", "BatchNo", "Return Date",
		// "Free(Qty)/Disc" };
		int row = table.getRowCount();
		if (row > 0) {
			for (int i = 0; i < row; i++) {
				vgross = Double.parseDouble(table.getValueAt(i, 6).toString());
				vdisc1 = Double.parseDouble(table.getValueAt(i, 7).toString());
				vdisc2 = Double.parseDouble(table.getValueAt(i, 9).toString());
				vgross = vgross - vdisc1 - vdisc2;
				vdiscamt = vgross * vdiscper / 100;
				String vmydiscamt = new gnMath().get2DecimaltValue(Double.toString(vdiscamt));
				switch (Promohdrdisc) {
				case "Y":

					if (vprompTypecode == "3") {
						table.setValueAt(vmydiscamt, i, 8);
					} else {
						table.setValueAt(vmydiscamt, i, 9);
					}
					// QtychangeImapct(value, k);
					break;
				case "N":
					// QtychangeImapct(value, k);
					table.setValueAt(vmydiscamt, i, 7);
					break;
				}
			}
		}
		new gnLogger().loggerInfoEntry("GRN", "Hdr Discount Distributed- Sucess");
		recalculateData();
		calHdrDisocunt();
	}

	class custamtpaidLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				addPaymentWithNewLogic();
				btn_Save.grabFocus();
				btn_Save.requestFocusInWindow();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void addPaymentWithNewLogic() throws ClassNotFoundException, SQLException {
		String vmode = payCombo.getSelectedItem().toString();
		String vcustpaid = custamountPaid.getText();
		String vdocno = docno.getText();

		// pmodel.addRow(new Object[]{"Del", vmode, vcustpaid, "0","0"});
		pmodel.insertRow(0, new Object[] { "Del", vmode, vcustpaid, vdocno, "0" });
		ptable.setModel(pmodel);
		calHdrDisocunt();
		CalculatePayment();
		ReCalculatePayment();
		custamountPaid.setText(null);
	}

	private void chekcFreezeYear() {
		switch (isFinyearFreeze) {
		case "Y":
			btnDayBegin.setVisible(false);
			btn_Save.setVisible(false);
			btn_Payment.setVisible(false);
			// btnUpdate.setVisible(false);
			// btnAcEntry.setVisible(false);
			// btnPrint.setVisible(false);
			new General().msg("Accounting Year is Freezeed..You Can View Data Only..");
			break;
		}
	}

	private void rateEnable() {
		rate.setText(null);
		rate.setEnabled(true);
	}

	private void rateDisable() {
		rate.setText(null);
		rate.setEnabled(false);
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
			// jul14
			panelDoctorInfo.setVisible(false);
			pmt.setVisible(true);
			scanItem_2.grabFocus();
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
				scanItem_2.grabFocus();
			} catch (Throwable e) {
			}
		}
	}

	class scanrateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String value = rate.getText();
			try {
				// String vpara811 = "811";
				// String vmaintainbatchforNonBatchItem = new
				// getConfigurationSetting().getInitialConfig(vpara811,
				// compcode, vstore);
				switch (vmaintainbatchforNonBatchItem) {
				case "Y":
					table.setValueAt(value, selectedrow, 4);
					table.setValueAt(value, selectedrow, 5);
				}
				table.setValueAt(value, selectedrow, 4);
				value = (String) table.getValueAt(selectedrow, 1);
				QtychangeImapct(value, 0);
				scanqty.setText("");
				rate.setText("");
				scanItem_2.grabFocus();
			} catch (Throwable e) {
			}
		}
	}

	public void POSPayment(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg( "Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "Payment");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("Payment", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					btn_Payment.doClick();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void POSBillSave(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg( "Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "BillSave");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("BillSave", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					btn_Save.doClick();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void displayOrderList(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg( "Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "List");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("List", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					displayList();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void BillHold(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg( "Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), "Hold");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("Hold", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					btnHold.doClick();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void CustomerPanel(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg( "Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0), "Customer");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("Customer", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					custname.grabFocus();
					custname.setText(null);
					custid.setText(null);
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void orderType(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg( "Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), "Order");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("Order", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					// comboOrderType.grabFocus();
					nordertype.grabFocus();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void promotable(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg( "Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "promotable");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("promotable", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					checkTableishold();
					promotable.grabFocus();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void myTable(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg( "Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "myTable");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("myTable", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					// comboTable.grabFocus();
					ntable.grabFocus();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void delorder(JTable table, DefaultTableModel model, String FieldName) {
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0), "cancelord");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("cancelord", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					btnCancel.doClick();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void mergetable(JTable table, DefaultTableModel model, String FieldName) {
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0), "mergetable");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("mergetable", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					// mergePopup();
					mergetable2.requestFocus();
					mergetable2.grabFocus();
					Hpanel_3.add(mergetablepanel);
					new gnLogger().loggerInfoEntry("POS", "Merge Table Orders Data Starts ");
					new General().msgPanel(mergetablepanel, "Merge Table Bill", 290, 190);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void savecustomer(JTable table, DefaultTableModel model, String FieldName) {
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0), "savecust");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("savecust", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					btnNewButton.doClick();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void delTableRow(JTable table, DefaultTableModel model, String FieldName) {
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "CalAction");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				removerowAction();
			}
		});
	}

	private void removerowAction() {
		try {
			int rowcount = table.getRowCount();
			int row = table.getSelectedRow();
			String vremark = "Record Removed";
			int vcount = table.getRowCount();
			String vcode = "";
			switch (invoiceMode) {
			case "E":
				if (rowcount > 1) {
					updateAuditRecord(vremark, row);
					vcode = table.getValueAt(row, 1).toString();
					model.removeRow(row);
					removeRow(model, table);
					table.setEditingRow(row);
					Double v = new gnTable().getTotal(table, 10);
					Tamount.setText(Double.toString(v));
					records.setText(Integer.toString(vcount));
					calHdrDisocunt();
					scanItem_2.grabFocus();
				}
			case "I":
				vcode = table.getValueAt(row, 1).toString();
				updateAuditRecord(vremark, row);
				model.removeRow(row);
				removeRow(model, table);
				table.setEditingRow(row);
				Double v = new gnTable().getTotal(table, 10);
				Tamount.setText(Double.toString(v));
				records.setText(Integer.toString(vcount));
				calHdrDisocunt();
				scanItem_2.grabFocus();
			}

			new gnLogger().loggerInfoEntry("POS", "----------------------------------------------------------------");
			new gnLogger().loggerInfoEntry("POS", "Item Remove From Sales Bill - Item Code" + vcode);
			new gnLogger().loggerInfoEntry("POS", "----------------------------------------------------------------");

		} catch (Throwable e1) {
			e1.printStackTrace();
		}

	}

	class nameFocusLsnr implements FocusListener {
		@Override
		public void focusGained(FocusEvent arg0) {
			try {
				nameMainSearch();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void focusLost(FocusEvent arg0) {

		}

	}

	private void nameMainSearch() throws ClassNotFoundException, SQLException {
		jsp.setEnabled(false);
		Articletable.requestFocus();
		new gnTable().RemoveTableRows(Articlemodel);
		String sname = scanName22.getText().trim();
		sname = "%" + sname + "%";
		String ArticleCol[] = { "Name", "Sales Price", "Article", "Tax" };
		Articlemodel.setColumnIdentifiers(ArticleCol);
		Articletable.setModel(Articlemodel);
		String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + " , " + vverticlecode + ")";
		rs = this.getSPResult(SQL);
		while (rs.next()) {

			Articlemodel.addRow(new Object[] { rs.getString(2), rs.getString(4), rs.getString(1), rs.getString(8) });
			Articletable.setModel(Articlemodel);
			new gnTable().setTableBasics(Articletable);
			new gnTable().setTablewidth(Articletable, 0, 150);
			Articletable.setGridColor(Color.gray);
			JViewport prt777 = new JViewport();
			new gnTable().setFontBold(Articletable, 14);
			prt777.setBackground(Color.CYAN);
			prt777.add(Articletable, ArticleCol);
			prt777.setVisible(true);
			// namejsp.setViewport(prt777);
		}
		Selectrow();
	}

	public void Selectrow() {
		Articletable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		Articletable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = Articletable.getSelectedRow();
				String vtype = (String) Articletable.getValueAt(row, 2);
				varticle = (String) Articletable.getValueAt(row, 2);
				try {
					showTableData(varticle, model);

					jsp.setEnabled(true);
					Dpanel.setEnabled(true);

					Dpanel.add(jsp);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Data ", 950, 300);
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
			hm_addr1.setBackground(Color.BLACK);
			hm_addr2.setBackground(Color.BLACK);
			hm_addr3.setBackground(Color.BLACK);
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
				POSFrame3_2.dispose();
			}

			if (value == "Day End") {
				try {
					POSFrame3_2.dispose();
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

			if (value == "Float Cash") {
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
					POSFrame3_2.dispose();
				} catch (SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Payment-F7") {

				// processPaymentNow() ;
			}

		}
	}

	class lsnritemName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// namesearch() ;
		}
	}

	public void setSearchArticle() throws Throwable {
		// new General().msg(" i am in Setsearch article mrthos ");
		varticle = scanItem_2.getText();
		new General().msg(varticle);
		if (varticle != "0") {
			showTableData(varticle, model);
		}
		varticle = "0";
		scanItem_2.setText(null);
	}

	private String checkBatchSelected() throws Throwable {
		String vpara716 = "716";
		String status = "Fail";
		if (SelectionType == "Batch") {
			String vallowpopupHelp = new getConfigurationSetting().getSpecificConfiguration(vpara716);
			switch (vallowpopupHelp) {
			case "N":
				int row = promotable.getRowCount();
				if (row == 0) {
					status = "Sucess";
					// scanItem_2.setEnabled(true);
				}
				if (row > 0) {
					status = "Fail";
					new General().msg("Please Select Batch ");
					promotable.grabFocus();
					// scanItem_2.setEnabled(false);
				}
				break;
			}
		}
		return status;
	}

	// Copied from last version

	// this methid is used for show item search result for resto
	private void showArticleNameSearchResult1() throws ClassNotFoundException, SQLException {
		// new General().msg("item Search Callesd ");;
		new gnTable().RemoveTableRows(promomodel);
		scanItem_2.setEnabled(true);
		if (SelectionType == "Article") {
			scanItem_2.setEnabled(true);
		}

		String sname = scanItem_2.getText();
		sname = "%" + sname + "%";
		String vverticlecode = new gnHierarchy().getVerticleCode();
		String vtype = "Article";
		String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
		String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Pk.Size", "UOM" };
		promomodel.setColumnIdentifiers(ACol);

		rs = this.getSPResult(SQL);
		while (rs.next()) {
			promomodel.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6) });
		}

		// promotable = new gnTableModel().ablemodel(promotable, promomodel,
		// SQL, ACol, 6, "N", "Y", vtype);
		promotable.setModel(promomodel);
		promotable.requestFocus();
		new gnTable().setTableColWidth(promotable, 1, 75);
		new gnTable().setTableColWidth(promotable, 2, 300);
		promotable.setBackground(Color.black);
		promotable.setForeground(Color.WHITE);
		promotable.setSelectionForeground(Color.white);
		promotable.setEditingRow(0);
		JViewport prt1101 = new JViewport();
		prt1101.add(promotable);
		prt1101.setVisible(true);
		promojsp.setViewport(prt1101);
		new gnTable().setFontBold(promotable, 14);
		SelectArticlerow();
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	// Not used in resto

	private void showArticleNameSearchResult(JTable mytable) {
		// new General().msg("item Search Callesd ");;
		new gnTable().RemoveTableRows(promomodel);
		scanItem_2.setEnabled(true);
		if (SelectionType == "Article") {
			scanItem_2.setEnabled(true);
		}
		promotable = mytable;
		promotable.requestFocus();
		new gnTable().setTableColWidth(promotable, 1, 150);
		new gnTable().setTableColWidth(promotable, 5, 150);
		promotable.setBackground(Color.black);
		promotable.setForeground(Color.WHITE);
		promotable.setSelectionForeground(Color.white);
		promotable.setEditingRow(0);
		JViewport prt1101 = new JViewport();
		prt1101.add(promotable);
		prt1101.setVisible(true);
		promojsp.setViewport(prt1101);
		// jsp.setViewport(prt1101);
		new gnTable().setFontBold(promotable, 14);
		SelectArticlerow();
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		new gnTable().RemoveTableRows(promomodel);
	}

	// Not used in resto
	private void showArticleBatchSearchResult(JTable mytable) {
		// new General().msg(" Batch Search Callesd ");;
		new gnTable().RemoveTableRows(promomodel);
		scanItem_2.setEnabled(false);
		if (SelectionType == "Batch") {
			scanItem_2.setEnabled(false);
		}
		promotable = mytable;
		promotable.requestFocus();
		new gnTable().setTableColWidth(promotable, 1, 150);
		new gnTable().setTableColWidth(promotable, 5, 150);
		promotable.setBackground(Color.YELLOW);
		promotable.setForeground(Color.BLACK);
		promotable.setEditingRow(0);
		JViewport prt1101 = new JViewport();
		prt1101.setBackground(new Color(51, 255, 255));
		prt1101.add(promotable);
		prt1101.setVisible(true);
		promojsp.setViewport(prt1101);
		jsp.setViewport(prt1101);
		SelectArticlerow();
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		new gnTable().RemoveTableRows(promomodel);
	}

	public void SelectArticlerow() {
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		promotable.grabFocus();
		promotable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		promotable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				batchAction();
			}
		});
		scanItem_2.grabFocus();
	}

	private void batchAction() {
		int row = promotable.getSelectedRow();
		String value = (String) promotable.getValueAt(row, 0).toString().trim();
		try {
			// new General().msg(value);
			switch (value.trim()) {
			case "Article":
				varticle = promotable.getValueAt(row, 1).toString();
				// new General().msg(varticle);
				showTableData(varticle, model);
				varticle = "0";
				scanItem_2.setEnabled(true);
				new gnTable().RemoveTableRows(promomodel);
				promotable.repaint();
				scanItem_2.grabFocus();
				afterShortcutKeyExecute();
				scanItem_2.grabFocus();
				break;

			case "Batch":
				int batchrow = promotable.getSelectedRow();
				table.setValueAt(promotable.getValueAt(batchrow, 8), selectedrow, 14);
				table.setValueAt(promotable.getValueAt(batchrow, 10), selectedrow, 15); // nkkkk
				table.setValueAt(promotable.getValueAt(batchrow, 5), selectedrow, 4);
				table.setValueAt(promotable.getValueAt(batchrow, 6), selectedrow, 5);
				varticle = promotable.getValueAt(batchrow, 2).toString();
				// QtychangeImapct(varticle, selectedrow);
				promomodel.setRowCount(0);
				new gnTable().RemoveTableRows(promomodel);
				scanItem_2.setEnabled(true);
				scanItem_2.grabFocus();
				QtychangeImapct(varticle, selectedrow);
				JViewport jk = new JViewport();
				promojsp.setViewport(jk);
				captureCropDetails();
				break;

			case "NoBatch":
				batchrow = promotable.getSelectedRow();
				promotable.setBackground(Color.BLACK);
				promotable.setForeground(Color.white);
				table.setValueAt(promotable.getValueAt(batchrow, 8), selectedrow, 14);
				table.setValueAt(promotable.getValueAt(batchrow, 9), selectedrow, 15);
				table.setValueAt(promotable.getValueAt(batchrow, 5), selectedrow, 4);
				table.setValueAt(promotable.getValueAt(batchrow, 6), selectedrow, 5);
				varticle = promotable.getValueAt(batchrow, 2).toString();
				// QtychangeImapct(varticle, selectedrow);
				promomodel.setRowCount(0);
				new gnTable().RemoveTableRows(promomodel);
				scanItem_2.setEnabled(true);
				scanItem_2.grabFocus();
				QtychangeImapct(varticle, selectedrow);
				jk = new JViewport();
				promojsp.setViewport(jk);
				// captureCropDetails();
				break;
			}

		} catch (Throwable e1) {
			e1.printStackTrace();
		} finally {
			new gnTable().RemoveTableRows(promomodel);
			promotable.repaint();
			promomodel.setRowCount(0);
		}
	}

	// end Last Version

	public String ValidateItem(String value) {
		String result = "Sucess";
		if (value.length() == ' ') {
			result = "Sucess";
		}

		if (value.length() == 0) {
			result = "Sucess";
		}
		result = checkOrderType();
		return result;
	}

	class custls implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			String value = e1.getActionCommand();
			String vvalue = custid.getText();
			if (vvalue.length() > 0) {
				dipslayCustInfo();
			}

			if (vvalue.length() == 0) {
				lblmsg.setText("Create New Customer Now .. ");
				custname.grabFocus();
				custname.setText(null);
				mobile.setText(null);
				hm_addr1.setText(null);
				hm_addr2.setText(null);

			}

		}
	}

	private void dipslayCustInfo() {
		if (custid.getText().length() > 0) {
			int custcode = Integer.parseInt(custid.getText());
			String vcustcode = custid.getText();
			if (vcustcode.length() == 0) {
				new General().msg("Enter Customer Code .. ");
				return;
			}
			try {
				dispCustInfo(custcode);
				scanItem_2.grabFocus();
			} catch (SQLException ee) {
				ee.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
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

	class lsSave implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (value == "Pay") {
				try {
					pmt.setVisible(false);
					insertPaymentRow();
					pmtPanel.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

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

				String vtype3 = "RESTO";
				String SQL = "Call sale_getEditSalesData( '" + vtype3 + "', " + vcomp + " ,  " + vstore + "  , "
						+ vinvno + ", '" + vinvdate + "' )";
				try {
					showEditTableData(SQL, model);
				} catch (Throwable e1) {
					new General().msg(SQL);
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
				varticle = "0";
				scanqty.grabFocus();
				if (table.getRowCount() == 0) {
					POSFrame3_2.dispose();
				} else {
					new General().msg("Please Save Bill  First ...");
				}
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

			if (value == "Create New Item") {
				try {
					ArticleBase_Master window;
					window = new ArticleBase_Master();
					window.articlebasemasterFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Cancel Order") {

				int row = promotable.getRowCount();

				if (row > 0) {
					row = promotable.getSelectedRow();
					int vok = new General().msgInput("Do you want to cancel order ? ");
					if (vok == 0) {
						try {
							cancelOrder(row);
							promotable.repaint();
							nordertype.grabFocus();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						} catch (Throwable e1) {
							e1.printStackTrace();
						}
					}
				}
			}

			if (value == "Merge Table") {
				try {
					mergeTableAction();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Save-F8") {
				Thread t12 = new Thread();
				State Thstatus = t12.getState();
				// new General().Quickmsg("Thread Status is :" + Thstatus);
				try {
					billtimePanel.setVisible(true);
					String vvaction = FinalCheckBatchNo();
					if (vvaction == "Sucess") {
						String action = CheckBatchControlArticle();
						if (action == "Sucess") {
							starttime.setText(new General().getTime());
							pickDataForInsert();
							panelbillInfotemp.setVisible(false);
						}
					}
				} catch (Exception e1) {
					new General().msg("Save Data" + "" + e1.getLocalizedMessage());
					e1.printStackTrace();
				} catch (Throwable e1) {
					new General().msg("Save Data" + "" + e1.getLocalizedMessage());
					e1.printStackTrace();
				} finally {
					if (t12.isAlive()) {
						t12.destroy();
						Thstatus = t12.getState();
						// new General().Quickmsg("Thread Status is :" +
						// Thstatus);
					}
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
				String vtype3 = "RESTO";
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
		String vtype3 = "RESTO";
		String SQL = "Call sale_getEditSalesData( '" + vtype3 + "', " + vcomp + " ,  " + vstore + "  , " + vinvno
				+ ", '" + vinvdate + "' )";
		// new General().msg(SQL);
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
					e1.printStackTrace();
				}
			}
		}
	}
	//// Search Button Listner

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
		String vinvdate = invdate.getText();
		if (vinvno.length() != 0) {
			String doctype = "POSINV";
			// String vpara27 = "27";
			// String printinvoice = new
			// String printinvoice =
			// getConfigurationSetting().getSpecificConfiguration(vpara27);
			String printinvoice = "Y";
			switch (printinvoice) {
			case "Y":
				updateRounding();
				new gnDocPrint().callprint(doctype, vinvno, vinvdate);
				scanItem_2.grabFocus();
				if (printDirectKot == "Y") {
					// String vprinter = kotprintername.getText() ;
					new gnDocPrint().printKOTForDirectInvoice(doctype, vinvno, vinvdate);
				}
			}
		} else {
			new General().msg("Invoice Number Not Available For Printing...");
		}
		return;
	}

	private void resetinfo() throws ClassNotFoundException, SQLException {

		custid.setText(null);
		nordertype.setFont(new Font("Tahoma", Font.BOLD, 16));
		nordertype.setText(null);
		ntableno.setText(null);
		nordertype.setBackground(Color.WHITE);
		ntableno.setBackground(Color.WHITE);
		nordertype.setEditable(true);
		ntableno.setEditable(true);
		nordertype.setEnabled(true);
		ntableno.setEnabled(true);
		orderAdding = "N";
		printDirectKot = "Y";
		invoiceMode = "I";
		comboTable.setSelectedItem("0");
		custid.setText("0");
		btnNewButton.setEnabled(true);
		comboOrderType.setSelectedItem("N/A");
		comboOrderType.setEnabled(false);
		orderno.setEnabled(true);
		orderno.setText(null);
		btnHold.setEnabled(true);
		lblmsg.setText("Ready For New Bill<Select Order Type /Table    .. ");

		custamountPaid.setBackground(Color.WHITE);
		custamountPaid.setForeground(Color.BLUE);
		checkTableishold();
		scanItem_2.grabFocus();
	}

	public void initiateNewBill() throws Throwable {
		orderAdding = "N";
		scanItem_2.grabFocus();
		records.setText("0");
		showqty.setText("0");
		invoiceMode = "I";
		hm_addr1.setText(null);
		hm_addr2.setText(null);
		String vtype = "POSBill";
		String vremark = "Bill-SaveSucess";
		String vinvdate = invdate.getText();
		new gnAudit().insertBillingStatus(vtype, invno.getText(), vinvdate, vremark);
		manualdisc.setText("0.00");
		disc.setText(null);
		billhdrdiscper.setText(null);
		btnSalesLike.setVisible(false);
		String vdocno = invno.getText();
		String vdocdate = invdate.getText();
		new gnPromoGetInfo().refreshPromoTables(vdocno, vdocdate);
		new gnTable().RemoveTableRows(promomodel);
		custamountPaid.setText(null);
		endtime.setText(new General().getTime());
		btnSalesLike.setBackground(Color.CYAN);
		btnSalesLike.setForeground(Color.BLACK);
		invdate.setText(new gnConfig().getDaybeginDate());

		vdoccode = "0";
		int tableRowcount = table.getRowCount();
		int ptableRowcount = ptable.getRowCount();
		if (ptableRowcount <= 0 && tableRowcount <= 0) {
			this.closeconn();
			Tamount.setText("0.00");
			Final_Pamt.setText(null);
			Final_Tamt.setText("00");
			Final_Damt.setText("00");
			duePayment = 0.00;
			paidAmount = 0.00;
			famount = 0.00;
			netAmount.setText("0.00");
			froundAmt.setText("0.00");
			hdrDiscount.setText("0.00");
			// custid.setText(null);
			custname.setText(null);
			mobile.setText(null);
			int vccode1 = 0;
			custid.setText(Integer.toString(vccode1));
			new gnTable().RemoveTableRows(model);
			new gnTable().RemoveTableRows(pmodel);
			String sitecode = vstore;
			// invno.setText(null);
			int vccode = 0;
			custid.setText(Integer.toString(vccode));
			String reset = "                                ";
			// scanItem.setText(reset);
			this.closeconn();
			new gnLogger().loggerInfoEntry("POS", "New Bill Init...");
			prst = null;
			System.gc();
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
			String sitecode = vstore;
			// invno.setText(null);
			int vccode = 0;
			custid.setText(Integer.toString(vccode));
			String reset = "                                ";
			// scanItem.setText(reset);
			scanItem_2.grabFocus();
			this.closeconn();
			new gnLogger().loggerInfoEntry("POS", "New Bill Init...");
		}
		resetinfo();
		scanItem_2.grabFocus();
	}

	public void ReCalculatePayment() throws ClassNotFoundException, SQLException { // new
																					// General().msg("Triggering
																					// Recalculate
																					// Event
		// new General().msg("ReCalculatePayment()");
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
		// new General().msg("CalculatePayment()");
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

	public void dispCustInfo(int custcode) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = " call getScanCustomer(" + custcode + " , " + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			custid.setText(rs.getString(1));
			custname.setText(rs.getString(2));
			mobile.setText(rs.getString(3));
			hm_addr1.setText(rs.getString(6));
			hm_addr2.setText(rs.getString(7));
		}
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

	// Kalyani

	private void handleBatchZero(String varticle, String vbatchcontrol, String vtype) throws Throwable {
		// new General().msg("Processing now for zero batch Articles");
		String vcost = "0";
		String vsp = table.getValueAt(selectedrow, 4).toString();
		String vmrp = table.getValueAt(selectedrow, 5).toString();
		String vloc = "SL";
		String stockAvailabe = "";
		new General().msg("SP:" + vsp);
		stockAvailabe = new gnBatch().IsStockAvailabeForMrpandSP(varticle, vmrp, vsp);
		vtype = "GZcase0";
		vcost = new gnArticle().Article_getData(varticle, "Cost");

		// this portion is added on 10-jan-2010
		String vaction1 = new gnBatch().IsMultiBatchForMRP_SalesPriceForSale(varticle, vmrp, vsp, vcost);

		try {
			String vpara716 = "716";
			String vallowpopupHelp = new getConfigurationSetting().getSpecificConfiguration(vpara716);
			switch (vallowpopupHelp) {
			case "Y":
				new gnGetBatch().getBatchDetailForNonBathItems(vtype, varticle, vbatchcontrol, vloc);
				// SelectionType = "Batch" ;
				break;

			case "N":
				promotable = new gnGetBatch().getBatchDetailForNonBathItemsInTable(vtype, varticle, vbatchcontrol,
						vloc);
				showArticleBatchSearchResult(promotable);
				SelectionType = "Batch";
				break;
			}
		} catch (Exception r) {
			new General().msg(r.getLocalizedMessage());
		} finally {
			table.setValueAt(new gnGetBatch().batchno, selectedrow, 14);
			table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 15);
			table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 4);
			table.setValueAt(new gnGetBatch().mrp, selectedrow, 5);
			new gnGetBatch().resetValues();
			QtychangeImapct(varticle, selectedrow);
		}

	}

	private void handleBatchNonZero(String varticle, String vbatchcontrol, String vtype) throws Throwable {
		String vcost = "0";
		String vsp = table.getValueAt(selectedrow, 4).toString();
		String vmrp = table.getValueAt(selectedrow, 5).toString();
		String vloc = "SL";
		String stockAvailabe = "";
		stockAvailabe = new gnBatch().IsStockAvailabeForMrpandSP(varticle, vmrp, vsp);
		// vtype = "GZCase0" ;
		// new General().msg("Running case0 option" + vtype);
		vcost = new gnArticle().Article_getData(varticle, "Cost");
		String vaction1 = new gnBatch().IsMultiBatchForMRP_SalesPriceForSale(varticle, vmrp, vsp, vcost);
		// new General().msg(vaction1);
		switch (vaction1) {
		case "Y":
			try {
				// Help popup window Enable
				String vpara716 = "716";
				String vallowpopupHelp = new getConfigurationSetting().getSpecificConfiguration(vpara716);
				switch (vallowpopupHelp) {
				case "Y":
					new gnGetBatch().getBatchDetailForNonBathItems(vtype, varticle, vbatchcontrol, vloc);
					break;

				case "N":
					promotable = new gnGetBatch().getBatchDetailForNonBathItemsInTable(vtype, varticle, vbatchcontrol,
							vloc);
					showArticleBatchSearchResult(promotable);
					SelectionType = "Batch";
					break;
				}

			} catch (Exception r) {
				new General().msg(r.getLocalizedMessage());
			} finally {
				table.setValueAt(new gnGetBatch().batchno, selectedrow, 14);
				table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 15);
				table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 4);
				table.setValueAt(new gnGetBatch().mrp, selectedrow, 5);
				new gnGetBatch().resetValues();
				QtychangeImapct(varticle, selectedrow);
			}
			break;
		case "N":
			String vbatch = new gnBatch().getLowestBatchNonZero(varticle, vmrp, vsp, vcost);
			table.setValueAt(vbatch, selectedrow, 14);
			break;
		}
	}

	private void checkBatchforNonBatchItems(String varticle, String vbatchcontrol) throws Throwable {
		String vcost = "0";
		String vsp = table.getValueAt(selectedrow, 4).toString();
		String vmrp = table.getValueAt(selectedrow, 5).toString();
		String vloc = "SL";
		String stockAvailabe = "";
		String vtype = "";
		String vaction = new gnBatch().IsBatchAvailableForIsBatchAvailableforMrpandSP(varticle, vmrp, vsp);
		switch (vaction) {
		case "Y":
			stockAvailabe = new gnBatch().IsStockAvailabeForMrpandSP(varticle, vmrp, vsp);
			// new General().msg(stockAvailabe);
			scanItem_2.setText("");
			scanItem_2.grabFocus();
			switch (stockAvailabe) {
			case "Y":
				vtype = "GZcase123";
				handleBatchNonZero(varticle, vbatchcontrol, vtype);
				break;
			case "N":
				vtype = "GZcase0";
				handleBatchZero(varticle, vbatchcontrol, vtype);
				break;
			}
			break;
		case "N": // For New Batch
			table.setValueAt(0, selectedrow, 14);
			double mybatch = Double.parseDouble(table.getValueAt(selectedrow, 14).toString());
			if (mybatch <= 0) {
				table.setValueAt("NB", selectedrow, 16);
				String vbatchno = new gnBatch().getNewBatch();
				table.setValueAt(vbatchno, selectedrow, 14);
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				rateEnable();
				rate.grabFocus();
				// table.setEnabled(false);
			}
			break;
		}
	}

	private String FinalCheckBatchNo() throws Throwable {
		String check = "Sucess";
		int vfail = 0;
		int row = 0;

		if (custid.getText().length() == 0) {
			custid.setText("0");
		}

		row = table.getRowCount();
		String vstorecode = vstore;
		String vcomp = new gnConfig().getCompanyCode();
		String vloc = "SL";
		String vpara811 = "811";
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			for (int i = 0; i < row; i++) {
				String vbatchno = table.getValueAt(selectedrow, 14).toString();
				switch (vbatchno) {
				case "0":
					new General().msg("Please Select Batch For Row No :" + i + 1);
					check = "Fail";
					vfail = vfail + 1;
				}
				break;
			}
		}
		if (vfail > 0) {
			check = "Fail";
		}
		return check;
	}

	private void CheckBatchNo() throws Throwable {
		String vstorecode = vstore;
		// String vcomp = vcomp;
		String vloc = "SL";
		String vpara811 = "811";
		// String vmaintainbatchforNonBatchItem = new
		// getConfigurationSetting().getInitialConfig(vpara811,
		// vcomp,vstorecode);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			String vbatchno = table.getValueAt(selectedrow, 14).toString();
			switch (vbatchno) {
			case "0":
				String varticle = table.getValueAt(selectedrow, 1).toString();
				String vbatchcontrol = table.getValueAt(selectedrow, 13).toString();
				// checkBatchforNonBatchItems( varticle, vbatchcontrol) ;
			}
			break;
		}
	}

	public String CheckBatchArticle(String varticle, String vbatchcontrol) throws Throwable {
		// new General().msgDispose();
		// new General().msg("Batch Check Method Called "+" "+varticle +"
		// "+vbatchcontrol);
		String status = "Sucess";
		String vcost = "0";
		String vstorecode = vstore;
		String vcomp = new gnConfig().getCompanyCode();
		String batch[] = { "BatchArticlce", "Item Code", "name", "cost", "SalesPrice", "Mrp", "Batchno", "Manuf_date",
				"Exp.Date", "Bal_Qty" };
		String vloc = "SL";

		String vpara716 = "716";
		String vallowpopupHelp = new getConfigurationSetting().getSpecificConfiguration(vpara716);

		String vpara811 = "811";
		vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstorecode);
		// new General().msg("maintain batch"+""+vmaintainbatchforNonBatchItem)
		// ;

		switch (vmaintainbatchforNonBatchItem) {
		case "N":
			try {
				switch (vallowpopupHelp) {
				case "Y":
					new gnGetBatch().getBatchDetail(varticle, vbatchcontrol, vloc);
					break;

				case "N":
					promotable = new gnGetBatch().getBatchDetailintable(varticle, vbatchcontrol, vloc);
					if (promotable.getRowCount() > 0) {
						showArticleNameSearchResult(promotable); // NitinMay2020
						// showArticleBatchSearchResult(promotable) ;
					}

					if (promotable.getRowCount() == 0) {
						scanItem_2.grabFocus();
					}
					break;
				}
			} catch (Exception r) {
				new General().msg("Batch4106  Exception :" + " " + r.getLocalizedMessage());
			} finally {
				switch (vallowpopupHelp) {
				case "Y":
					if (Double.parseDouble(new gnGetBatch().salesPrice) > 0) {
						table.setValueAt(new gnGetBatch().batchno, selectedrow, 14);
						table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 15);
						table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 4);
						table.setValueAt(new gnGetBatch().mrp, selectedrow, 5);
						new gnGetBatch().resetValues();
						QtychangeImapct(varticle, selectedrow);
					}
				}
			} // Finally
				// captureCropDetails() ; ///commnted for furtilizer for batch
				// details popup in sames scrin on date 14.05.2020
			break;

		case "Y":
			checkBatchforNonBatchItems(varticle, vbatchcontrol);
			break;
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

		// nitinhere

		double disc1 = Double.parseDouble(hdrDiscount.getText());
		double disc2 = Double.parseDouble(manualdisc.getText());
		disc2 = disc1 + disc2;
		fdisc.setText(new gnMath().get2DecimaltValue(Double.toString(disc2)));
		fgross.setText(Tamount.getText());
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
		String SQL = " call master_getMasterData('" + vtype + "'  , " + vverticle + " , '" + vmastersearchString + "')";
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
		String vsaletype = SalesType.getSelectedItem().toString().trim();
		switch (vsaletype) {
		case "":
			vlocation = "NO";
			break;

		case "Sale":
			vlocation = "SL";
			break;

		case "Rent":
			vlocation = "Rent";
			break;
		}

		if (vlocation.equalsIgnoreCase("NO")) {
			Action = "fail";
			new General().msg("Please Select Sales Type ");
			SalesType.grabFocus();
			SalesType.setBackground(Color.yellow);
			SalesType.setForeground(Color.black);
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();

		}

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
			// Action = checkForDrugType(vdrugType) ;
			try {
				vdrugType = new gnArticle().Article_getData(varticle, "DrugType");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
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

	/*
	 * private void getandUpdateInoiceNoforUnlohod() throws Throwable { if
	 * (table.getRowCount() == 0) { switch (invoiceMode) { case "I":
	 * invno.setText(new gnSeq().getSeqno("5", "TR")); // new
	 * gnLogger().loggerInfoEntry("POS", "New Bill no Generated // For Sales
	 * ..."+" "+invno.getText()) ; vglcode = new gnSeq().getGlcode("5", "TR");
	 * new gnSeq().updateSeqno("5", "TR"); new
	 * gnLogger().loggerDebugEntry("POS", "POS invoice Seq.Number Updated");
	 * break; case "E": break; } } }
	 * 
	 */

	private void getandUpdateInoiceNo() throws Throwable {
		switch (invoiceMode) {
		case "I":
			// invno.setText(new gnSeq().getSeqno("5", "TR"));
			new gnLogger().loggerInfoEntry("POS", "New Bill no Generated For Sales ..." + " " + invno.getText());
			// vglcode = new gnSeq().getGlcode("5", "TR");
			// new gnSeq().updateSeqno("5", "TR");
			new gnLogger().loggerDebugEntry("POS", "POS invoice Seq.Number Updated");
			String vtype = "POSBill";
			String vinvdate = invdate.getText();
			String vremark = "Bill-NoSave";
			new gnAudit().insertBillingRecord(vtype, invno.getText(), vinvdate, vremark);
			new gnLogger().loggerDebugEntry("POS", "New Bill No  inserted in audit table ");
			break;
		case "E":
			break;
		}
	}

	private void getInvoiceNumberOnScan() {
		String InvoiceGenerateMethos = "OnSave";
		switch (InvoiceGenerateMethos) {
		case "OnScanItem":
			if (table.getRowCount() == 0) {
				try {
					getandUpdateInoiceNo();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			break;
		case "OnSave":
			if (table.getRowCount() == 0) {
				try {
					// jun17
					invno.setText(new gnSeq().getSeqno("5", "TR"));
					new gnLogger().loggerInfoEntry("POS",
							"New Bill no Generated For Sales ..." + " " + invno.getText());
					vglcode = new gnSeq().getGlcode("5", "TR");
					// new gnSeq().updateSeqno("5", "TR");
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
			break;
		}
	}

	public String showTableData(String value, DefaultTableModel model) throws Throwable {
		new gnTable().RemoveTableRows(promomodel);

		// getInvoiceNumberOnScan() ;
		model.setColumnIdentifiers(Col);
		billtimePanel.setVisible(false);
		starttime.setText(null);
		endtime.setText(null);
		promoArticle = value;
		String neginvallow = "Y";
		pmt.setVisible(true);
		panelbillInfotemp.setVisible(false);
		String action = "Insert";
		String value1 = value;
		value1 = value;
		Object row[] = {};
		String SQL = "";
		String vtype = "";
		String vbatchArticle = null;
		String vfinyear = new gnFinYear().getReportingFinYear();
		neginvallow = checkAllowNegInv(value1);
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
				String vverticlecode = new gnHierarchy().getVerticleCode();
				String vpara811 = "811";
				vmaintainbatchforNonBatchItem = "N";
				String vordertype = comboOrderType.getSelectedItem().toString().trim();

				// new Logic to pick price from menupriceList indusual for all
				// order type

				if (GetPriceFromMenuList.trim().equals("Y")) {
					String vtypeofArticle = "ArticleType";
					String varticletype = new gnArticle().Article_getData(value, vtypeofArticle);
					// new General().msg("Article Type :" + varticletype);
					switch (varticletype) {
					case "11":

						if (vordertype.equals("HOME DELIVERY")) {
							vordertype = "HomeDelivery";
						}
						SQL = "select am.article_code, am.name, 1 as qty,  coalesce(sp.Salesprice,0), "
								+ " coalesce(sp.mrp,0) , (1*coalesce(sp.salesprice,0))  as gross,"
								+ " 0 as manualdisc, 0 as Disc, 0 as disc, "
								
								+ " Round((coalesce(sp.Salesprice,0)*am.tax_per/(100)),2) as Tax_amount ,"
								+ " ( (1* coalesce(sp.salesprice,0))  + 5   ) as amount  , "
							 
							    //+ " Round((coalesce(sp.Salesprice,0)*am.tax_per/(100+am.tax_per)),2) as Tax_amount ,"
								//+ " (1* coalesce(sp.salesprice,0)) as amount  , "
								
								
								+ " am.tax_per ,"
								+ " am.Batch_control_Article, 0 as BatchNo, 0 as Exp_Date , 11  as freearticle "
								+ " from msarticle_master am left join menuPricelist sp" + " ON  am.company_code = "
								+ vcomp + " and am.company_code  = sp.company_code and "
								+ " am.article_code = sp.article_code and sp.site_code = " + vstore + "  "
								+ " where am.article_code = " + value + " and am.company_code = " + vcomp + " "
								+ " and am.verticle = " + vverticlecode + " " + " and sp.ordertype= '" + vordertype
								+ "'  ";
						        //new General().msg(SQL);
 						break;

					case "1":
						vtype = "RESTOBAR";
						SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', " + vcomp
								+ " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
						break;
					}

				}

				// End new Logic to pick price from menupriceList indusual for
				// all order type

				/*
				
					  
					  
					 */

				// Old Logic Start here
				if (GetPriceFromMenuList.trim().equals("N")) {
					// new General().msg("Apply diff price" +""
					// +vapplydiffPrice);
					switch (vapplydiffPrice) // If Config Setiing is not not
												// Allow diff Price
					{
					case "N":
						vtype = "RESTOBAR";
						SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', " + vcomp
								+ " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
						break;
					}

					switch (vapplydiffPrice) // If Diffrent Price Apply then
												// Only
					{

					case "Y":

						if (vordertype.equals("HOME DELIVERY")) {
							// vapplyBasePriceForTelephone = "N";
							switch (vapplyBasePriceForTelephone.trim()) {
							case "N": // Apply diffrent price
								// new General().msg("I am in Count Diff Price
								// Option N");
								vtype = "RESTOBAROTHERPRICE";
								SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', "
										+ vcomp + " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
								break;
							case "Y":
								vtype = "RESTOBAR";
								SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', "
										+ vcomp + " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
								break;
							}
						}

						if (vordertype.equals("ZOMATO")) {
							switch (vapplyBasePriceForZomato) {
							case "N": // Apply diffrent price
								// new General().msg("I am in Count Diff Price
								// Option N");
								vtype = "RESTOBAROTHERPRICE";
								SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', "
										+ vcomp + " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
								break;
							case "Y":
								vtype = "RESTOBAR";
								SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', "
										+ vcomp + " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
								break;
							}
						}

						if (vordertype.equals("COUNTER")) {
							switch (vapplyBasePriceForCounter) {
							case "N": // Apply diffrent price
								// new General().msg("I am in Count Diff Price
								// Option N");
								vtype = "RESTOBAROTHERPRICE";
								SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', "
										+ vcomp + " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
								break;
							case "Y":
								new General().msg("I am in Count Diff Price Option  Y");
								vtype = "RESTOBAR";
								SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', "
										+ vcomp + " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
								break;
							}
						}

						if (vordertype.equals("TABLE")) {
							switch (vapplyBasePriceForWalkin) {
							case "N": // Apply diffrent price
								// new General().msg("I am in Count Diff Price
								// Option N");
								vtype = "RESTOBAROTHERPRICE";
								SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', "
										+ vcomp + " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
								break;
							case "Y":
								vtype = "RESTOBAR";
								SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', "
										+ vcomp + " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
								break;
							}
						}

						if (vordertype.equals("SWIGGY")) {
							switch (vapplyBasePriceForSwiggy) {
							case "N": // Apply diffrent price
								// new General().msg("I am in Count Diff Price
								// Option N");
								vtype = "RESTOBAROTHERPRICE";
								SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', "
										+ vcomp + " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
								break;
							case "Y":
								vtype = "RESTOBAR";
								SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', "
										+ vcomp + " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
								break;
							}
						}

						break;
					}
				} // Old logic if End
				//// REsto Diff price apply
				// =======================Old Logic end Here =

				table.setModel(model);
				rs = this.getSPResult(SQL);
				if (rs.next()) {
					String varticle = rs.getString(1);
					AutodiscArticle = rs.getString(1);
					String vsp = rs.getString(4);
					int varticlereturn = Integer.parseInt(rs.getString(1));
					if (varticlereturn > 0) {
						if (Double.parseDouble(vsp) == 0.0) {
							// new General().Quickmsg("Please Update Price
							// Master ");
							new gnImageSound().playAlertSound();
							new gnImageSound().playAlertSound();
							new gnLogger().loggerInfoEntry("POS", "Please Update Price Master  ");
						}

						// { "X", "Item", "Name", "Qty", "Rate", "MRP", "Gross",
						// "Disc Item", "Bill Disc", "Disc",
						// "Tax", "Amount", "Tax%", "Batch(Y/N)", "BatchNo",
						// "ExpDate", "Free(Qty)/Disc", "Order", "Table", "KOT"
						// };
						// vaddSub
						// vapplyBasePriceFor = "NONE" ;
						model.insertRow(0,
								new Object[] { new Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
										rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
										rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
										rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
										rs.getString(16), comboOrderType.getSelectedItem().toString().trim(),
										comboTable.getSelectedItem().toString().trim(), "0" });
						QueryStatus = "Y";
						new gnTable().setTableColWidth(table, 15, 100);
						vdrugType = rs.getString(1);
						vbatchArticle = rs.getString(13);
						selectedrow = 0;
						new gnTable().setTablewidth(table, 2, 300);
						table.setModel(model);
						table.setRowHeight(40);
						btnSalesLike.setVisible(true);
						new gnLogger().loggerInfoEntry("POS",
								"Checking For Promo Applicablity For Article :" + varticle);
						table.setCursor(new Cursor(Cursor.HAND_CURSOR));
						varticle = "0";
						scanItem_2.setText(null);
						SelectrowforEdit();
					} // End if
				} // end While Rs

				Double itemtotal = new gnTable().getTotal(table, 6);
				Tamount.setText(Double.toString(itemtotal));

				Double vtotalqty = new gnTable().getTotal(table, 3);
				showqty.setText(Double.toString(vtotalqty));

				Double vmanualdisc = new gnTable().getTotal(table, 7);
				manualdisc.setText(Double.toString(vmanualdisc));

				Double vhdrdiscamt = new gnTable().getTotal(table, 8);
				Double vhdrdiscamt1 = new gnTable().getTotal(table, 9);
				vhdrdiscamt = vhdrdiscamt + vhdrdiscamt1;
				hdrDiscount.setText(Double.toString(vhdrdiscamt));
				calHdrDisocunt();
				checkperBillLine();
				removeRow(model, table);
				new gnTable().setTableBasics(table);
				int vcount = table.getRowCount();
				records.setText(Integer.toString(vcount));
				table.getColumnModel().getColumn(2).setPreferredWidth(300);
				table.getColumnModel().getColumn(14).setPreferredWidth(100);

				table.setRowHeight(34);

				table.setGridColor(Color.DARK_GRAY);
				table.setSelectionBackground(Color.blue);
				table.setSelectionForeground(Color.WHITE);
				table.setRowHeight(30);

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
				table.getColumnModel().getColumn(13).setCellEditor(new DefaultCellEditor(vexpedtr));
				chngqty.addActionListener(qtychng);
				sp.addActionListener(spchng);
				vexpedtr.addActionListener(expdtr);
				table.setGridColor(Color.BLACK);
				checkForDrugType(varticle);
				switch (vverticlecode) {
				case "7":
					QtychangeImapct(value, taxslabrow);
					break;
				case "14":
					QtychangeImapct(value, taxslabrow);
					break;
				}
			}
		}
		prt = new JViewport();
		prt.setForeground(Color.RED);
		prt.setBackground(new Color(51, 255, 255));
		prt.add(table, Col);
		prt.setBackground(Color.WHITE);
		prt.setVisible(true);
		jsp.setViewport(prt);
		jsp.setVisible(true);
		new gnTable().setFontBold(table, 14);
		if (QueryStatus.equals("Y")) {
			popupWindowForQtyPrice();
		}

		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification);
		return "OK";

	} // ShowTableData

	private int getArticleRowNumber(String myarticle) {
		int myrow = 7777;
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			String tableArticle = table.getValueAt(i, 1).toString().trim();
			if (tableArticle.equalsIgnoreCase(myarticle)) {
				myrow = i;
			}
		}
		return myrow;
	}

	public String QtychangeImapct(String value, int i) throws Throwable {
		// new General().msg("Row Edit is" + " "+ i) ;
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

		// Manul Disc
		String Cemp_disc1 = (String) table.getValueAt(i, 7).toString();
		Double Cemp_disc = Double.parseDouble(Cemp_disc1);

		String Cdisc1 = (String) table.getValueAt(i, 8).toString();
		Double Cdisc = Double.parseDouble(Cdisc1);

		String Cdisc2 = (String) table.getValueAt(i, 9).toString();
		Double Cdisc22 = Double.parseDouble(Cdisc2);

		// Double vtax = Double.parseDouble(table.getValueAt(i, 11).toString());
		Double newqty = curqty;
		Double newgross = newqty * Csp;

		Double newAmount = (newgross - Cdisc - Cemp_disc - Cdisc22);
		//

		String vmynetamt = Double.toString(newAmount);
		vmynetamt = new gnMath().get2DecimaltValue(vmynetamt);
		table.setValueAt(vmynetamt, i, 11);

		//

		// For Tax Slab//
		switch (vverticlecode) {
		case "7":
			// new General().msg("checking for tax Slab ...");
			vmyamount = (String) table.getValueAt(i, 11).toString();
			vtaxrate = initialCheckForTaxSlab(value, vmyamount);
			table.setValueAt(vtaxrate, i, 12);
			break;
		case "14":
			// new General().msg( "checking for tax Slab ...");
			vmyamount = (String) table.getValueAt(i, 11).toString();
			vtaxrate = initialCheckForTaxSlab(value, vmyamount);
			table.setValueAt(vtaxrate, i, 12);
			break;
		}

		Double vtax = Double.parseDouble(table.getValueAt(i, 12).toString());

		String vtypeofArticle = "ArticleType";
		String varticletype = new gnArticle().Article_getData(value, vtypeofArticle);

		Double newtax = 0.00;
		String vmytax = "0";

		switch (varticletype) {

		case "11":

			 //newtax = new gnMath().CalTax_Sales(newAmount, vtax);
			 //vmytax = Double.toString(newtax);
 			  
			  newtax = new gnMath().CalTax_Pur(newAmount, vtax);
			  vmytax = Double.toString(newtax);
			break;

		case "1":
			//newtax = new gnMath().CalTax_Sales(newAmount, vtax);
			//vmytax = Double.toString(newtax);
		
			  newtax = new gnMath().CalTax_Pur(newAmount, vtax);
			  vmytax = Double.toString(newtax);
		
			break;
		}

		table.setValueAt(newqty, i, 3);
		String vmygross = Double.toString(newgross);
		vmygross = new gnMath().get2DecimaltValue(vmygross);
		table.setValueAt(vmygross, i, 6);

		vmynetamt = Double.toString(newAmount);
		vmynetamt = new gnMath().get2DecimaltValue(vmynetamt);

		switch (varticletype) 
		{

		    case "11" :
	  		double vvmynetamt =   newAmount + newtax;
	  		vmynetamt = Double.toString(vvmynetamt) ;
	  		break ;
	  		
	 		case "1" :
		  	vvmynetamt =   newAmount + newtax;
		  	vmynetamt = Double.toString(vvmynetamt) ;
		  	break ;

	 	}

 		
		table.setValueAt(vmynetamt, i, 11);
 		table.setValueAt(new gnMath().get2DecimaltValue(vmytax), i, 10);

		//Double itemtotal = new gnTable().getTotal(table, 11);
		Double itemtotal = new gnTable().getTotal(table, 6);
		
		String vmyitemtotal = Double.toString(itemtotal);
		// new General().msg("Grosss"+ " "+vmyitemtotal) ;
		Tamount.setText(new gnMath().get2DecimaltValue(vmyitemtotal)); // Gross
																		// Amount

		Double vtotalqty = new gnTable().getTotal(table, 3);
		showqty.setText(Double.toString(vtotalqty));

		// manualdisc.setText("0");
		Double vmanualdisc = new gnTable().getTotal(table, 7);
		manualdisc.setText(new gnMath().get2DecimaltValue(Double.toString(vmanualdisc)));

		// hdrDiscount.setText("0");
		Double vpromodisc1 = new gnTable().getTotal(table, 8);
		Double vpromodisc2 = new gnTable().getTotal(table, 9);
		Double vhdrdiscamt = vpromodisc2 + vpromodisc1;
		String vmyhdrdisc = Double.toString(vhdrdiscamt);
		hdrDiscount.setText(new gnMath().get2DecimaltValue(vmyhdrdisc));
		new gnTable().setTablewidth(table, 2, 300);
		action = "Updated";
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		scanItem_2.grabFocus();

		calHdrDisocunt();

		switch (promoModuleActivated) {
		case "Y":
			break;
		}
		// String action = ValidateItemEntry();
		panelbillInfotemp.setVisible(false);
		return action;
 	}

	

	public void calHdrDisocunt() {

		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 2, 300);
 			
			
			Double itemtotal = new gnTable().getTotal(table, 6);
			Tamount.setText(new gnMath().get2DecimaltValue(Double.toString(itemtotal))); // Gross
 			Double vtotalqty = new gnTable().getTotal(table, 3);
			showqty.setText(new gnMath().get2DecimaltValue(Double.toString(vtotalqty)));
 			Double vhdrdiscamt = new gnTable().getTotal(table, 8);
			Double vhdrdiscamt1 = new gnTable().getTotal(table, 9);
			vhdrdiscamt = vhdrdiscamt + vhdrdiscamt1;
			hdrDiscount.setText(new gnMath().get2DecimaltValue(Double.toString(vhdrdiscamt)));
 			Double vmanualdisc = new gnTable().getTotal(table, 7);
			manualdisc.setText(new gnMath().get2DecimaltValue(Double.toString(vmanualdisc)));
 			Double xTamount = Double.parseDouble(Tamount.getText());
			// new General().msg("Gross Value is :" + " "+xTamount) ;
			xTamount = Double.parseDouble(new gnMath().get2DecimaltValue(Double.toString(xTamount)));
			// new General().msg("Gross Value is :" + " "+xTamount) ;
			fhdrDiscount = Double.parseDouble(hdrDiscount.getText());
			vmanualdisc = Double.parseDouble(manualdisc.getText());
			
			double vmytax = new gnTable().getTotal(table, 10) ;
			double vnetAmt = xTamount - fhdrDiscount - vmanualdisc + vmytax;
			
			int vnetAmtnew = (int) Math.round(vnetAmt);
			double vroundamt = (vnetAmtnew - vnetAmt);
			// froundAmt.setText(Double.toString(vroundamt));
			froundAmt.setText(new gnMath().get2DecimaltValue(Double.toString(vroundamt)));
			netAmount.setText(Integer.toString(vnetAmtnew));
	
		
		
		}


	}

	
	
	private void updateAuditRecord(String vremark, int i) throws Throwable {
		// insert into audit records
		String varticle = table.getValueAt(i, 1).toString();
		String vname = table.getValueAt(i, 2).toString();
		String vqty = table.getValueAt(i, 3).toString();
		String vrate = table.getValueAt(i, 4).toString();
		String vdisc = table.getValueAt(i, 7).toString();
		String vamt = table.getValueAt(i, 11).toString();
		String vtype = "POS";
		new gnAudit().updateAuditRecord(vtype, invno.getText(), invdate.getText(), varticle, vname, vqty, vrate, vdisc,
				vamt, vremark);
		//
	}

	private void recalculateData() throws Throwable {
		new gnLogger().loggerInfoEntry("GRN", "Recalculation After Data Edit Over");
		int row1 = table.getRowCount();
		if (row1 > 0) {
			for (int k = 0; k < row1; k++) {
				String value = table.getValueAt(k, 1).toString();
				try {
					QtychangeImapct(value, k);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
					new gnLogger().loggerInfoEntry("Sale", "Distribution Exception" + " " + e.getLocalizedMessage());
				}
			}
		}
	}

	
	
	public String RecalculateAfterPormo(int i) throws Throwable {

		// private String Col[] = { "Romove", 1"Item", 2"Name", 3"Qty", 4"Rate",
		// 5"MRP",6 "Gross",7 "m.Disc",8 "Bill Disc",9 "Disc",10 "Tax" ,
		// 11"Amount",12 "Taxcode", 13"Batch Item", 14"BatchNo",15 "Exp.Date",16
		// "Free(Qty)/Disc" };

		String value = table.getValueAt(i, 1).toString();
		new gnLogger().loggerInfoEntry("POS", "User Editing Data Either for qty /  Rate /Discount for row" + " " + i);
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
		String Cdisc2 = (String) table.getValueAt(i, 9).toString();
		Double Cdisc22 = Double.parseDouble(Cdisc2);

		// Double vtax = Double.parseDouble(table.getValueAt(i, 11).toString());
		Double newqty = curqty;
		Double newgross = newqty * Csp;

		Double newAmount = (newgross - Cdisc - Cemp_disc - Cdisc22);
		table.setValueAt(newAmount, i, 11);

		// private String Col[] = { "Romove", 1"Item", 2"Name", 3"Qty", 4"Rate",
		// 5"MRP",6 "Gross",7 "m.Disc",8 "Bill Disc",9 "Disc",10 "Tax" ,
		// 11"Amount",12 "Taxcode", 13"Batch Item", 14"BatchNo",15 "Exp.Date",16
		// "Free(Qty)/Disc" };

		// For Tax Slab//
		switch (vverticlecode) {
		case "7":
			// new General().msg("checking for tax Slab ...");
			vmyamount = (String) table.getValueAt(i, 11).toString();
			vtaxrate = initialCheckForTaxSlab(value, vmyamount);
			table.setValueAt(vtaxrate, i, 12);
			break;
		case "14":
			// new General().msg( "checking for tax Slab ...");
			vmyamount = (String) table.getValueAt(i, 11).toString();
			vtaxrate = initialCheckForTaxSlab(value, vmyamount);
			table.setValueAt(vtaxrate, i, 12);
			break;
		}

		Double vtax = Double.parseDouble(table.getValueAt(i, 12).toString());
		Double newtax = new gnMath().CalTax_Sales(newAmount, vtax);
		table.setValueAt(newqty, i, 3);

		String mynewgross = Double.toString(newgross);
		String mynewAmount = Double.toString(newAmount);
		String mynewtax = Double.toString(newtax);

		mynewgross = new gnMath().get2DecimaltValue(mynewgross);
		mynewAmount = new gnMath().get2DecimaltValue(mynewAmount);
		mynewtax = new gnMath().get2DecimaltValue(mynewtax);

		table.setValueAt(mynewgross, i, 6);
		table.setValueAt(mynewAmount, i, 11);
		table.setValueAt(mynewtax, i, 10);

		Double iTotal = new gnTable().getTotal(table, 11);
		Tamount.setText(Double.toString(iTotal));
		action = "Updated";
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		new gnLogger().loggerInfoEntry("POS",
				" Editing Data Over for qty /  Rate /Discount for row" + " " + i + "Artilce " + value);

		/*
		 * // Calcuate Margin Vloilation rule// String vcheckMargin = "Y"; if
		 * (vcheckMargin == "Y") { String varticle = table.getValueAt(i,
		 * 1).toString(); // String vcost = table.getValueAt(i, 15).toString();
		 * String vcost = table.getModel().getValueAt(i, 15).toString(); String
		 * vsp = table.getValueAt(i, 4).toString(); String status = new
		 * gnMath().checkMargin(varticle, vcost, vsp); }
		 */
		// End Margin Calcultion
		// scanItem_2.grabFocus();
		calHdrDisocunt();
		String action = ValidateItemEntry();
		return action;

	}

	private void resetPromoparameters() {
		new gnPromoCheck().vfromqty = 0.0;
		new gnPromoCheck().vtoqty = 0.0;
		new gnPromoCheck().vfreearticle = 0.0;
		new gnPromoCheck().vvfreearticle = "0";
		new gnPromoCheck().vfreeqty = 0.0;
		new gnPromoCheck().vmyfreeqty = 0.0;
		new gnPromoCheck().vdiscper = 0.0;
		new gnPromoCheck().vdiscamt = 0.0;
		new gnPromoCheck().vconvaluefrom = 0.0;
		new gnPromoCheck().vconditionto = 0.0;
		new gnPromoCheck().vbrand = "0";
		new gnPromoCheck().varticle = "0";
		new gnPromoCheck().vpurqty = 0.0;
		new gnPromoCheck().vpurvalue = 0.0;
		new gnPromoCheck().vtype = "";
		new gnPromoCheck().vpromono = "";
		new gnPromoCheck().vpromotypecode = "";
		new gnPromoCheck().vpromotype = "";
		new gnPromoCheck().vconditionOn = "";
		new gnPromoCheck().vapplyFreePromoNow = "N";

	}

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
		return vtaxcode;
	}

	private void checkForDrugType(String article) {
		// new General().msg(vDrugType);
		String vDrugType = null;
		try {
			vDrugType = new gnArticle().Article_getData(article, "DrugType");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String showEditTableData(String SQL, DefaultTableModel model) throws Throwable {
		String neginvallow = "Y";
		// getInvoiceNumberOnScan() ;
		pmt.setVisible(true);
		String action = "Insert";
		String value1 = "0";
		Object row[] = {};
		new gnLogger().loggerInfoEntry("POS", "Item Scan is :" + SQL);
		model.setColumnIdentifiers(Col);
		table.setModel(model);

		try {
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				String varticle = rs.getString(1);
				String value = rs.getString(1);
				AutodiscArticle = rs.getString(1);

				model.insertRow(0,
						new Object[] { new Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
								rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
								rs.getString(14), rs.getString(15), rs.getString(23), rs.getString(18),
								rs.getString(19), rs.getString(20) });

				// vdoccode = rs.getString(19);
				// docname.setText(rs.getString(20));

				// new for resto
				String vordertype = rs.getString(18);
				new General().msg(vordertype);
				orderno.setText(rs.getString(21));
				comboOrderType.setSelectedItem(vordertype);
				custid.setText(rs.getString(22));
			}
		} catch (Exception e) {
			new General().msg(e.getMessage());
		}

		// prst.setString(51, table.getValueAt(k, 17).toString()); // orderType
		// prst.setString(52, table.getValueAt(k, 18).toString()); // TableNo
		// prst.setString(53, table.getValueAt(k, 19).toString()); // KOT
		// prst.setString(54, table.getValueAt(k, 13).toString()); //Tasste
		// prst.setString(55, orderno.getText()); //orderno
		// prst.setString(56, invdate.getText()); //orderdate
		// End REsto && KOT

		// private String Col[] = { "X", "Item", "Name", "Qty", "Rate", "MRP",
		// "Gross",
		// "Disc Item", "Bill Disc", "Disc", "Tax", "Amount",
		// "Tax%", "Taste", "BatchNo", "ExpDate", "Free(Qty)/Disc",
		// "OrderType", "Table", "KOT" };

		SelectrowforEdit();
		new gnTable().setTableBasics(table);
		jsp.setAutoscrolls(true);
		selectedrow = table.getRowCount() - 1;
		new gnTable().setTablewidth(table, 2, 300);
		Double itemtotal = new gnTable().getTotal(table, 10);
		Tamount.setText(Double.toString(itemtotal));
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

	class editLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vnewqty = editqty.getText();
			String vnewrate = editrate.getText();
			String vnewdisc = editdisc.getText();
			String vnewtaste = edittaste.getText();
			table.setValueAt(vnewqty, editrow, 3);
			table.setValueAt(vnewrate, editrow, 4);
			table.setValueAt(vnewdisc, editrow, 8);
			table.setValueAt(vnewtaste, editrow, 13);
			String vcode = editcode.getText();
			try {
				// table.notify();
				if (editEnd.isFocusOwner()) {
					new General().msgDispose();
				}
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				try {
					QtychangeImapct(vcode, editrow);
					scanItem_2.grabFocus();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void popupWindowForQtyPrice() {
		editrow = table.getSelectedRow();
		String vqty = (table.getValueAt(editrow, 3).toString());
		String vrate = (String) table.getValueAt(editrow, 4);
		String vcode = (String) table.getValueAt(editrow, 1);
		String vname = (String) table.getValueAt(editrow, 2);
		String vdisc = (String) table.getValueAt(editrow, 8);
		String vtaste = (String) table.getValueAt(editrow, 13);

		try {
			editQtyPrice(vcode, vname, vqty, vrate, vdisc, vtaste);
		} catch (Throwable e1) {
			e1.printStackTrace();//
			new General().msg("Edit Qty->:" + " " + e1.getLocalizedMessage());
			new gnLogger().loggerInfoEntry("POS", "Edit Qty->:" + " " + e1.getLocalizedMessage());
		} finally {
			try {
				Dpanel.remove(panelPriceEdit);
			} catch (Throwable e1) {
				e1.printStackTrace();
				new General().msg("Edit Qty:" + " " + e1.getLocalizedMessage());
				new gnLogger().loggerInfoEntry("POS", "Edit Qty->:" + " " + e1.getLocalizedMessage());
			}
		}
	}

	public void SelectrowforEdit() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				popupWindowForQtyPrice();
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
	}

	private void editQtyPrice(String vcode, String vname, String vqty, String vrate, String vdisc, String vtaste) {
		panelPriceEdit.setBounds(21, 86, 300, 300);
		editcode.setText(vcode);
		editname.setText(vname);
		editrate.setText(vrate);
		editqty.setText(vqty);
		editdisc.setText(vdisc);
		edittaste.setText(vtaste);
		editqty.requestFocus();
		editqty.grabFocus();
		Dpanel.add(panelPriceEdit);
		editqty.grabFocus();
		new General().msgPanel(panelPriceEdit, "Edit Price and Qty", 350, 200);
		new gnLogger().loggerInfoEntry("POS", "Edit Price and Qty Called");
	}

	private void editQtyPrice1(String vcode, String vname, String vqty, String vrate, String vdisc) {
		wnd = new JWindow();
		wnd.setBounds(20, 85, 300, 300);
		panelPriceEdit.setBounds(21, 86, 300, 300);
		wnd.setAlwaysOnTop(true);
		wnd.getContentPane().add(panelPriceEdit);
		editcode.setText(vcode);
		editname.setText(vname);
		editrate.setText(vrate);
		editqty.setText(vqty);
		editdisc.setText(vdisc);
		Dpanel.add(panelPriceEdit);
		editqty.requestFocus();
		editqty.grabFocus();
		wnd.setVisible(true);
		// new General().msgPanel(panelPriceEdit, "Edit Price and Qty", 350,
		// 200);
		new gnLogger().loggerInfoEntry("POS", "Edit Price and Qty Called");
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
					varticle = "0";
					QueryStatus = "Y";
					scanItem_2.setText(null);
					scanItem_2.grabFocus();
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
		chkbox.setText("R");
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
							// modelName.removeRow(r);
							String vpara714 = "714";
							try {
								String vframeclosable = new getConfigurationSetting()
										.getSpecificConfiguration(vpara714);
								switch (vframeclosable) {
								case "N":

									removerowAction();
									/*
									 * int rowcnt = table.getRowCount(); if
									 * (rowcnt > 0) { String vremark =
									 * "Record Removed";
									 * updateAuditRecord(vremark, r); String
									 * vcode = table.getValueAt(r,
									 * 1).toString(); new
									 * gnLogger().loggerInfoEntry("POS",
									 * "----------------------------------------------------------------"
									 * ); new gnLogger().loggerInfoEntry("POS",
									 * "Item Remove From Sales Bill - Item Code"
									 * + vcode); new
									 * gnLogger().loggerInfoEntry("POS",
									 * "----------------------------------------------------------------"
									 * ); modelName.removeRow(r); }
									 */
									break;
								case "Y":
									removerowAction();

									/*
									 * String vremark = "Record Removed";
									 * updateAuditRecord(vremark, r); String
									 * vcode = table.getValueAt(r,
									 * 1).toString(); new
									 * gnLogger().loggerInfoEntry("POS",
									 * "----------------------------------------------------------------"
									 * ); new gnLogger().loggerInfoEntry("POS",
									 * "  Item Remove From Sales Bill - Item Code "
									 * + vcode); new
									 * gnLogger().loggerInfoEntry("POS",
									 * "----------------------------------------------------------------"
									 * ); modelName.removeRow(r);
									 */
									break;
								}
							} catch (Throwable e1) {
								e1.printStackTrace();
							}

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
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					return;
				}
				return;
			}
		});
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

	// nitin here
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
		// ntable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification4);
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(ntable)));
		ntable.setEnabled(true);
		ntable.setCellSelectionEnabled(false);
		ntable.setRowSelectionAllowed(true);
		ntable.setGridColor(Color.gray);
		// prt6.setToolTipText("Article Scrollpane Port");
		prt6.add(ntable, Col);
		prt6.setVisible(true);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, ntable, "Select Article", 800, 500);
		SelectDataRow();
	}

	public void SelectDataRow() {
		ntable.requestFocus();
		ntable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		ntable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = ntable.getSelectedRow();
					String value = ntable.getValueAt(row, 0).toString().trim();
					showArticle(value, row);
					new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
					// new General().msgDispose();
			}
		});
		new General().msgsearch(sjsp, ntable, "Select Article", 800, 500);
	}

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
			custamountPaid.setText(ntable.getValueAt(row, 3).toString());
			docno.setText(ntable.getValueAt(row, 1).toString());
			addPaymentWithNewLogic();
			docno.setText("0");
			custamountPaid.setText(null);
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
				custamountPaid.grabFocus();
				return;
			}

			if (dues <= 0 && (Tamt == FTamt))

				// new General().msg("Processing Payment Save Action") ;
				DBaction = "DBFail";
			vvsitecode = vstore;
			vvcompnaycode = vcomp;
			vterminal = Integer.parseInt(terminalID.getText());

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
				// jun172020
				invno.setText(new gnSeq().getSeqno("5", "TR"));
				new gnLogger().loggerInfoEntry("POS",
						"Please Note Bill no Generated For Sales ..." + " " + invno.getText());
				vglcode = new gnSeq().getGlcode("5", "TR");
				break;
			case "E":
				vglcode = new gnSeq().getGlcode("5", "TR");
				break;
			}
			// new General().msg(vglcode);
			new General().Quickmsg("Invoice number is " + invno.getText());
			vvinvno = Integer.parseInt(invno.getText());

			String vsaletype = SalesType.getSelectedItem().toString().trim();
			switch (vsaletype) {
			case " ":
				vlocation = "NO";
				break;

			case "Sale":
				vlocation = "SL";
				break;

			case "Rent":
				vlocation = "Rent";
				break;
			}

			if (vlocation.equalsIgnoreCase("NO")) {
				new General().msg("Please Select Sales Type");
				SalesType.grabFocus();
			}

			switch (invoiceMode) {
			case "I":
				if (!vlocation.equalsIgnoreCase("NO")) {
					insertPosDetails();
				}
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

	
	//// DB Insert - POS Details Start here
	public void insertPosDetails() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		String DBdetail = "Fail";
		String poshdr = "Insert into pos_sales_detail(company_code ," + "site_code, " + " invDate ," + "invno,"
				+ "Article_code ," + "EAN ," + "customer_code ," + "qty," + "sales_price," + "MRP," + "Taxcode,"
				+ "Gross_amount, " + "Disc," + "hdr_disc ," + "net_amount , " + "Tax_amount , " + "Promo_ind,"
				+ "promo_code," + "line_seq," + "CreatedBy, " + "Insert_status," + " Cashier_code, " // 22
				+ "Terminal_ID, shift , srno, tax_per, sales_type , "
				+ "batch_article, Batch_no, Expiry_date, cost, verticle, location ,"
				+ "state, statename, regdealer, mycompanyisgst, mygstno, mycompState, "
				+ "custGSTno , cgst, sgst, igst , movementType, "
				+ "TaxableValue, mystatename, finyear , cogs, "
				+ "freeArticle_disc , emp_disc , OrderType , Tableno , KOT, Taste ,"
				+ "orderno , orderdate)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?, ?,?,?, ?,?,?,?,?,?,? ,?,?, ?,?,?,?,?,?,?,?,?,?,?) ";
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
				prst.setString(11, (table.getValueAt(k, 12).toString()));
				prst.setString(12, table.getValueAt(k, 6).toString());
				prst.setString(13, table.getValueAt(k, 9).toString());
				prst.setString(14, table.getValueAt(k, 8).toString());
				prst.setString(15, table.getValueAt(k, 11).toString());
				// Double vtaxamt =
				// (Double.parseDouble(table.getValueAt(k,10).toString())*4/100)
				// ;
				prst.setString(16, table.getValueAt(k, 10).toString());
				prst.setString(17, "N");
				prst.setString(18, "N");
				prst.setInt(19, pd_seq);
				prst.setString(20, vvcashiercode);
				prst.setString(21, "Y");
				prst.setString(22, vvcashiercode);
				prst.setInt(23, vterminal);
				prst.setInt(24, vshift);
				prst.setInt(25, k+1);

				prst.setString(26, table.getValueAt(k, 12).toString());
				prst.setString(27, vvsales_type);
				prst.setString(28, "N");
				prst.setString(29, table.getValueAt(k, 14).toString());
				prst.setString(30, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 15).toString()));

				String vbatchno = table.getValueAt(k, 14).toString();
				String vproductrcost = new gnArticle().Article_getData(table.getValueAt(k, 1).toString(), "AvgCost");

				if (vproductrcost.length() == 0) {
					vproductrcost = "0";
				}

				String vpara811 = "811";
				// String vmaintainbatchforNonBatchItem = new
				// getConfigurationSetting().getInitialConfig(vpara811,
				// vcomp,vstore);
				switch (vmaintainbatchforNonBatchItem) {
				case "N":
					vproductrcost = new gnArticle().Article_getData(table.getValueAt(k, 1).toString(), "AvgCost");
					break;
				case "Y":
					vproductrcost = new gnBatch().getCostOfgivenBatch(vbatchno);
					break;
				}

				if (vproductrcost.length() == 0) {
					vproductrcost = "0";
				}
				prst.setString(31, vproductrcost); // cost is taking from
													// gnbatch.getcost landing
													// cost in case batch
													// activated for non batch
													// Items
				prst.setString(32, vverticle);
				prst.setString(33, vlocation);

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
					Double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
					double vcgst = vcaltaxamt / 2;
					double vsgst = vcaltaxamt / 2;
					double vigst = 0.00;

					String vtaxatemp = new gnMath().get2DecimaltValue(Double.toString(vcgst)) ;
					//new General().msg(vtaxatemp);
					prst.setString(41, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
					prst.setString(42, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
					prst.setString(43, new gnMath().get2DecimaltValue(Double.toString(vigst)));
					prst.setString(44, vmovtype);
				}

				if ((vmy - voth != 0)) {
					double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
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
				vnet = Double.parseDouble(table.getValueAt(k, 11).toString());
				vtxamt = Double.parseDouble(table.getValueAt(k, 10).toString());

				vtaxablevalue = vnet - vtxamt;     

				
				/*
				//new addition 
				String vtypeofArticle = "ArticleType";
				String value = table.getValueAt(k, 1).toString();
				String varticletype = new gnArticle().Article_getData(value, vtypeofArticle);

				switch (varticletype) {
				case "11":
 
					//prst.setString(15, table.getValueAt(k, 11).toString());
					 prst.setString(15, Double.toString(vnet+vtxamt));
  					 vtaxablevalue = vnet+vtxamt - vtxamt;

					 break;
 
				case "1":
					vtaxablevalue = vnet - vtxamt;
					 break;
 
				}
 				//End New Addition 
				
				*/
				
				prst.setString(45, new gnMath().get2DecimaltValue(Double.toString(vtaxablevalue)));
				prst.setString(46, vmystatename);
				prst.setString(47, new gnFinYear().getCurrentFinYear(invdate.getText()));
				// cogs
				double vtaxper = Double.parseDouble(table.getValueAt(k, 12).toString());
				// String vvcost = new
				// gnArticle().Article_getData(table.getValueAt(k,
				// 1).toString(), "Cost");

				double vcost = Double.parseDouble(vproductrcost);
				double vqty = Double.parseDouble(table.getValueAt(k, 3).toString());
				// Double vcostvalue = vqty * vcost ;
				Double vcogs = new gnMath().CalTax_Pur(vcost, vtaxper);
				Double vcostvalue = vcost - vcogs;
				vcostvalue = vqty * vcostvalue;
				prst.setString(48, Double.toString(vcostvalue));
				prst.setString(49, table.getValueAt(k, 16).toString());
				prst.setString(50, table.getValueAt(k, 7).toString());

				// Resto

				prst.setString(51, table.getValueAt(k, 17).toString()); // Manul
				prst.setString(52, table.getValueAt(k, 18).toString()); // Manul
				prst.setString(53, table.getValueAt(k, 19).toString()); // Manul
				prst.setString(54, table.getValueAt(k, 13).toString()); // Tasste
				prst.setString(55, orderno.getText()); // orderno
				prst.setString(56, invdate.getText()); // orderdate
				// End REsto
 
				//new General().msg("prst"+"-->"+prst);

				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				vvggross = vvggross + Double.parseDouble(table.getValueAt(k, 6).toString());
				vvdisc = vvdisc + (Double.parseDouble(table.getValueAt(k, 7).toString())
						+ Double.parseDouble(table.getValueAt(k, 8).toString())
						+ Double.parseDouble(table.getValueAt(k, 9).toString()));
				if (TotalRecordinsert % batchSize == 0) {
					int[] recordws = prst.executeBatch();
					 con1.commit();
					DBdetail = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				con1.commit();
				DBdetail = "Sucess";
			
		 } // For Loop
			
		} catch (SQLException e) {
			new General().msg(e.getLocalizedMessage());
 			new gnLogger().loggerDebugEntry("POS", "(Detail Nitin 32 )===>>." + " " + e.getMessage() + "InvNo:" + "" + vvinvno);
 			con1.rollback();
  			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {

				new gnLogger().loggerDebugEntry("POS",
						"Detail  ===>>." + " " + "Save Sucessfully " + "InvNo:" + "" + vvinvno);

				if (promoModuleActivated == "Y") {
					insertPromoData();
				}
				insertPosHdr();
				// new General().msg("Verticle is:"+vverticle);
				if (vverticle.equals("5")) {
					// new General().msg("Calling Crop Store Method..");
					//insertCropmappingDetails();
				}
				// updatePostingStatusForScanData();
			}
		}
	}

	
	//// DB Insert - POS Details Start here
	public void insertPosDetailsbkp() throws Throwable {
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
				+ "TaxableValue, mystatename, finyear , cogs, "
				+ "freeArticle_disc , emp_disc , OrderType , Tableno , KOT, Taste , orderno , orderdate)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?, ?,?,?, ?,?,?,?,?,?,? ,?,?, ?,?,?,?,?,?,?,?,?,?,?) ";
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
				prst.setString(11, (table.getValueAt(k, 12).toString()));
				prst.setString(12, table.getValueAt(k, 6).toString());
				prst.setString(13, table.getValueAt(k, 9).toString());
				prst.setString(14, table.getValueAt(k, 8).toString());
				prst.setString(15, table.getValueAt(k, 11).toString());
				// Double vtaxamt =
				// (Double.parseDouble(table.getValueAt(k,10).toString())*4/100)
				// ;
				prst.setString(16, table.getValueAt(k, 10).toString());
				prst.setString(17, "N");
				prst.setString(18, "N");
				prst.setInt(19, pd_seq);
				prst.setString(20, vvcashiercode);
				prst.setString(21, "Y");
				prst.setString(22, vvcashiercode);
				prst.setInt(23, vterminal);
				prst.setInt(24, vshift);
				prst.setInt(25, k);

				prst.setString(26, table.getValueAt(k, 12).toString());
				prst.setString(27, vvsales_type);
				prst.setString(28, "N");
				prst.setString(29, table.getValueAt(k, 14).toString());
				prst.setString(30, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 15).toString()));

				String vbatchno = table.getValueAt(k, 14).toString();
				String vproductrcost = new gnArticle().Article_getData(table.getValueAt(k, 1).toString(), "AvgCost");

				if (vproductrcost.length() == 0) {
					vproductrcost = "0";
				}

				String vpara811 = "811";
				// String vmaintainbatchforNonBatchItem = new
				// getConfigurationSetting().getInitialConfig(vpara811,
				// vcomp,vstore);
				switch (vmaintainbatchforNonBatchItem) {
				case "N":
					vproductrcost = new gnArticle().Article_getData(table.getValueAt(k, 1).toString(), "AvgCost");
					break;
				case "Y":
					vproductrcost = new gnBatch().getCostOfgivenBatch(vbatchno);
					break;
				}

				if (vproductrcost.length() == 0) {
					vproductrcost = "0";
				}
				prst.setString(31, vproductrcost); // cost is taking from
													// gnbatch.getcost landing
													// cost in case batch
													// activated for non batch
													// Items
				prst.setString(32, vverticle);
				prst.setString(33, vlocation);

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
					Double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
					double vcgst = vcaltaxamt / 2;
					double vsgst = vcaltaxamt / 2;
					double vigst = 0.00;

					prst.setString(41, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
					prst.setString(42, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
					prst.setString(43, new gnMath().get2DecimaltValue(Double.toString(vigst)));
					prst.setString(44, vmovtype);
				}

				if ((vmy - voth != 0)) {
					double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
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
				vnet = Double.parseDouble(table.getValueAt(k, 11).toString());
				vtxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
 				vtaxablevalue = vnet - vtxamt;
  				prst.setString(45, new gnMath().get2DecimaltValue(Double.toString(vtaxablevalue)));
				prst.setString(46, vmystatename);
				prst.setString(47, new gnFinYear().getCurrentFinYear(invdate.getText()));
				// cogs
				double vtaxper = Double.parseDouble(table.getValueAt(k, 12).toString());
				// String vvcost = new
				// gnArticle().Article_getData(table.getValueAt(k,
				// 1).toString(), "Cost");

				double vcost = Double.parseDouble(vproductrcost);
				double vqty = Double.parseDouble(table.getValueAt(k, 3).toString());
				// Double vcostvalue = vqty * vcost ;
				Double vcogs = new gnMath().CalTax_Pur(vcost, vtaxper);
				Double vcostvalue = vcost - vcogs;
				vcostvalue = vqty * vcostvalue;
				prst.setString(48, Double.toString(vcostvalue));
				prst.setString(49, table.getValueAt(k, 16).toString());
				prst.setString(50, table.getValueAt(k, 7).toString());

				// Resto

				prst.setString(51, table.getValueAt(k, 17).toString()); // Manul
				prst.setString(52, table.getValueAt(k, 18).toString()); // Manul
				prst.setString(53, table.getValueAt(k, 19).toString()); // Manul
				prst.setString(54, table.getValueAt(k, 13).toString()); // Tasste
				prst.setString(55, orderno.getText()); // orderno
				prst.setString(56, invdate.getText()); // orderdate
				// End REsto

  		 				
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				vvggross = vvggross + Double.parseDouble(table.getValueAt(k, 6).toString());
				vvdisc = vvdisc + (Double.parseDouble(table.getValueAt(k, 7).toString())
						+ Double.parseDouble(table.getValueAt(k, 8).toString())
						+ Double.parseDouble(table.getValueAt(k, 9).toString()));
				if (TotalRecordinsert % batchSize == 0) {
					int[] recordws = prst.executeBatch();
					con1.commit();
					DBdetail = "Sucess";
				}
				int[] ff = prst.executeBatch(); // insert remaining records
				con1.commit();
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg(e.getLocalizedMessage());
 			con1.rollback();
			new gnLogger().loggerDebugEntry("POS", "Detail NK  ===>>." + " " + e.getMessage() + "  InvNo:  " + "" + vvinvno);
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {

				new gnLogger().loggerDebugEntry("POS",
						"Detail  ===>>." + " " + "Save Sucessfully " + "InvNo:" + "" + vvinvno);

				if (promoModuleActivated == "Y") {
					insertPromoData();
				}
				insertPosHdr();
				// new General().msg("Verticle is:"+vverticle);
				if (vverticle.equals("5")) {
					// new General().msg("Calling Crop Store Method..");
					insertCropmappingDetails();
				}
				// updatePostingStatusForScanData();
			}
		}
	}

	
	
	
	
	
	private void updateRounding() throws SQLException, ClassNotFoundException {
		String xvinvno = invno.getText();
		String xvinvdate = new gnConfig().date_ConverttoDBforamt(invdate.getText());
		String SQL = "call pos_updateRounding(" + vcomp + " , " + vstore + " , " + xvinvno + " , '" + xvinvdate + "' )";
		this.getResult(SQL);

	}

	private void insertPromoData() throws ClassNotFoundException, SQLException {
		String vbilldate = new gnConfig().date_ConverttoDBforamt(invdate.getText());
		String vbillno = invno.getText();
		String vapplicable = "Y";
		String SQL = "Update tmp_pos_sales_promo set billdate =  '" + vbilldate + "' ,  Billno = " + vbillno + " "
				+ " where applicable = '" + vapplicable + "' ";
		// new General().msg(SQL);
		this.getResult(SQL);
		String SQL1 = " insert into pos_sales_promo " + "Select * from tmp_pos_sales_promo where applicable = '"
				+ vapplicable + "' ";
		// new General().msg(SQL1);
		this.getResult(SQL1);
		new General().Quickmsg("Promo Data Updated..Sucess");
	}

	private void insertPosHdr() throws Throwable {
		new gnLogger().loggerDebugEntry("POS", "Header data Start Inserting " + "InvNo:" + "" + vvinvno);
		
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con2 = this.getConnection();
		con2.setAutoCommit(false);
		String Status = "Fail";
		String poshdr = "Insert into pos_sales_hdr(company_code , " + "site_code, terminal_id ,  invno,   invDate ,  "
				+ " cashier_code, sales_type," + " Invoice_type, Posting_type, Gross_Amount,"
				+ " Discount, Net_Amount, customer_code, shift, verticle, time, RoundingAmt , "
				+ " state, statename, regdealer, mycompanyisgst, mygstno, mycompState, custGSTno,"
				+ " movementtype , mystatename,glcode, updatedate, updateby, "
				+ " fineyear, doctor_code, patient_name, patient_phone, Doctor_name)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,? , ?,? ,?,?,?,?,?,?,?,?)";
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
			prst.setString(31, "0");
			prst.setString(32, "0");
			prst.setString(33, "0");
			prst.setString(34, "N/A");
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
  			con2.rollback();
			new gnLogger().loggerDebugEntry("POS-Check Here Nitin", "Header " + "InvNo:" + "" + vvinvno + "-->RollBack Data ");
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

		// New Mode For Restaurant
		String pmswiggy = "SWIGGY";
		String pmgpay = "GPAY";
		String pmzomate = "ZOMATO";
		String pmpaytm = "PAYTM";
		String pmphonepay = "PhonePay";

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
			//new General().msg("srno"+ vsrno);
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
				//new General().msg("srno"+ vsrno1);
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

		// String pmswiggy = "Swiggy";
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim().toUpperCase();
			switch (mode) {
			case "SWIGGY":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				refcol = ptable.getValueAt(i, 4).toString().trim();
				mystatus = insertPayment(pmswiggy, vcc, vno, vsrno1, refcol);
				break;
			}
		}

		// String pmgpay = "GPAY";
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim().toUpperCase();
			switch (mode) {
			case "GPAY":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				refcol = ptable.getValueAt(i, 4).toString().trim();
				mystatus = insertPayment(pmgpay, vcc, vno, vsrno1, refcol);
				break;
			}
		}

		// String pmzomate = "ZOMATO";
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim().toUpperCase();
			switch (mode) {
			case "ZOMATO":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				refcol = ptable.getValueAt(i, 4).toString().trim();
				mystatus = insertPayment(pmzomate, vcc, vno, vsrno1, refcol);
				break;
			}
		}

		// String pmpaytm = "PAYTM"
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim().toUpperCase();
			switch (mode) {
			case "PAYTM":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				refcol = ptable.getValueAt(i, 4).toString().trim();
				mystatus = insertPayment(pmpaytm, vcc, vno, vsrno1, refcol);
				break;
			}
		}

		// String pmphonepay= "PhonePay";
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim().toUpperCase();
			switch (mode) {
			case "PHONEPAY":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				refcol = ptable.getValueAt(i, 4).toString().trim();
				mystatus = insertPayment(pmphonepay, vcc, vno, vsrno1, refcol);
				break;
			}
		}

		// Credit Note consume - Update Payment_dncn_master Table
		for (int i = 0; i < row; i++) {
			vsrno1 = vsrno + i;
			mode = ptable.getValueAt(i, 1).toString().trim();
			switch (mode) {
			case "CN":
				vcc = (Double.parseDouble(ptable.getValueAt(i, 2).toString().trim()));
				int vno = (Integer.parseInt(ptable.getValueAt(i, 3).toString().trim()));
				refcol = ptable.getValueAt(i, 4).toString().trim();
				statusCN = insertPayment(pmCN, vcc, vno, vsrno1, refcol);
				// new General().msg("CN Inserted in Payment Table" + statusCN);
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
			btn_print.doClick();
			new gnLogger().loggerDebugEntry("POS", "Invoice audit Sucess For" + "InvNo:" + "" + vvinvno);
			pmt.setVisible(true);
			pmtPanel.setVisible(false);
			scanItem_2.grabFocus();
			scanItem_2.setText(null);
			new gnTable().RemoveTableRows(nmodel);
			new gnTable().RemoveTableRows(pmodel);
			new gnTable().RemoveTableRows(model);
			new gnTable().RemoveTableRows(smodel);

			if (invoiceMode == "I") {
				new gnSeq().updateSeqno("5", "TR");
			}
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

		String vpara811 = "811";
		// String vmaintainbatchforNonBatchItem = new
		// getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			vtrntype1 = "Sale";
			SQL1 = "call Inv_impact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   " + vvinvno
					+ " , '" + Svinvdate + "' ,  '" + vfinyear + "')";
			this.getSPResult(SQL1);
			this.closeconn();
			// Batch Allocation for Multiple Batch Stock Allocation in case on
			// Batch does not have enough Stock
			String vdocno = Integer.toString(vvinvno);
			new gnBatchAllocaion().doBatchStockAllocation(vdocno, Svinvdate, vtrntype1);
			// End Batch Allocation for Multiple Batch Stock Allocation in case
			// on Batch does not have enough Stock
			break;
		}
		// End Logic Change
		new gnLogger().loggerDebugEntry("POS", "Sales Data Inventroy Calculation Complete");
		return Action;
	}

	// nitin
	class UnholdLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
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

	////////// Button Press Managment Here ////////////////////////////

	private void activateNormalPOS() {
		POS = "1";
		JspPanel.setBounds(0, 0, 950, 532);
		jsp.setBounds(0, 0, 1325, 560);
		Dpanel.add(jsp);
	}

	private void setVerticlePOS() throws Throwable {
		vverticle = new gnHierarchy().getVerticleCode();
		activateNormalPOS();
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
		para805 = 100;

		String vpara708 = "708";
		new getConfigurationSetting().setBtnConfig(btnNewCustomer, vpara708);

		String vpara711 = "711";
		new getConfigurationSetting().setTextFielConfig(hdrDiscount, vpara711);
		new gnLogger().loggerDebugEntry("POS", "Setting Config Parameter for POS Over...");
	}

	private String checkAllowNegInv(String varticle) throws Throwable {
		String vallowyn = "S";
		String vallow = "";
		double vqty = 0.00;
		vallow = new getConfigurationSetting().AllowNegInv();

		int vl = varticle.length();
		if (vl > 0) {
			vqty = new gnStockcheck().getArticleStock(varticle, "SL");
		}

		switch (vallow) {
		case "Y":
			vallowyn = "Y";
			break;
		case "N":

			if (vqty > 0.00) {
				vallowyn = "Y";
			}

			if (vqty == 0.0) {
				vallowyn = "N";
				new General().msg(" Negative Inventory Not Allow Current Stock is :" + " " + vqty);
				scanItem_2.grabFocus();
				scanItem_2.setText(null);
			}

			if (vqty < 0.00) {
				vallowyn = "N";
				new General().msg(" Negative Inventory Not Allow Current Stock is :" + " " + vqty);
				scanItem_2.setText(null);
				scanItem_2.grabFocus();
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
	private JTextField ordertype;
	private JTextField mytable;
	private JTextField taste;
	private JTextField orderno;
	private JTextField kotprintername;
	private JTextField nordertype;
	private JTextField ntableno;
	private JButton btnArticle;
	private JButton btnCancel;
	private JTextField mergetable1;
	private JTextField mergetable2;
	private JTextField mergetable3;
	private JLabel lblNewLabel_24;
	private JLabel lblNewLabel_25;

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

	@Override
	public void run() {
		Thread t1;
		try {
			t1 = new Thread(new POS());
			t1.start();
			t1.getUncaughtExceptionHandler();
		} catch (Throwable e) {
			e.printStackTrace();
			new General().msg(e.getLocalizedMessage());
		}
	}

	//// Promotion Handling
	public String pickDataForInsertforpromo() throws Throwable {

		String status = "Sucess";
		vvsitecode = vstore;
		vvcompnaycode = vcomp;
		vterminal = Integer.parseInt(terminalID.getText());
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
		vvnet = 0.00;
		// this.closeconn();

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
		vmycompanystate = vmycompanystate.trim();
		int vmy = Integer.parseInt(vmycompanystate);
		if ((vmy - voth == 0)) {
			vmovtype = "Intra-State";
		}
		if ((vmy - voth != 0)) {
			vmovtype = "Inter-State";
		}
		switch (invoiceMode) {
		case "I":
			new gnLogger().loggerInfoEntry("POS", "New Bill no Generated For Sales ..." + " " + invno.getText());
			break;
		case "E":
			vglcode = new gnSeq().getGlcode("5", "TR");
			break;
		}
		vvinvno = Integer.parseInt(invno.getText());
		switch (invoiceMode) {
		case "I":
			status = insertPosDetailsForPromoExecution();
			break;
		case "E":
			new gnLogger().loggerInfoEntry("POS", "POS Edit Bill :" + invno.getText() + "Start Inserting");
			String vinvtype = "PS";
			new gnEDMiddleWare().SalesModification(vinvtype, invno.getText(), invdate.getText());
			status = insertPosDetailsForPromoExecution();
			new gnLogger().loggerInfoEntry("POS", "POS Edit Bill Completer for invno:" + invno.getText());
			break;
		}
		return status;
	}

	//// pos Details for promo check Start here

	public String insertPosDetailsForPromoExecution() throws Throwable {
		// private String Col[] = { "Romove", 1"Item", 2"Name", 3"Qty",
		// 4"Rate", 5"MRP",6 "Gross",7 "m.Disc",8 "Bill Disc",9
		// "Disc",10 "Tax" ,
		// 11"Amount",12 "Taxcode", 13"Batch Item", 14"BatchNo",15
		// "Exp.Date",16 "Free(Qty)/Disc" };
		String vinvdate = invdate.getText();
		String vinvno = invno.getText();
		vinvdate = new gnConfig().date_ConverttoDBforamt(vinvdate);
		String vtype = "All";
		String SQL = "call Promo_baseAction( '" + vtype + "' ,  " + compcode + " , " + vstore + " , " + vinvno
				+ "  ,  '" + vinvdate + "')";
		// new General().msg("Inserting Temp Data..");
		this.getSPResult(SQL);
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		String DBdetail = "Fail";
		String poshdr = "Insert into tmp_pos_sales_detail (company_code ," + "site_code, " + " invDate ," + "invno,"
				+ "Article_code ," + "EAN ," + "customer_code ," + "qty," + "sales_price," + "MRP," + "Taxcode,"
				+ "Gross_amount, " + "Disc," + "hdr_disc ," + "net_amount , " + "Tax_amount , " + "Promo_ind,"
				+ "promo_code," + "line_seq," + "CreatedBy, " + "Insert_status," + " Cashier_code, " // 22
				+ "Terminal_ID, shift , srno, tax_per, sales_type , "
				+ "batch_article, Batch_no, Expiry_date, cost, verticle, location ,"
				+ "state, statename, regdealer, mycompanyisgst, mygstno, mycompState, custGSTno , cgst, sgst, igst , movementType, "
				+ "TaxableValue, mystatename, finyear , cogs, FreeArticle_Disc , "
				+ "Emp_disc , OrderType, Tableno , KOT, Taste, orderno , orderdate)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?, ?,?,?, ?,?,?,?,?,?,? ,?,?, ?,?,?,?,?,?,?,?, ?,?,?) ";
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

				prst.setString(11, (table.getValueAt(k, 12).toString()));
				prst.setDouble(12, Double.parseDouble(table.getValueAt(k, 6).toString()));
				prst.setDouble(13, Double.parseDouble(table.getValueAt(k, 9).toString()));
				prst.setDouble(14, Double.parseDouble(table.getValueAt(k, 8).toString()));
				prst.setDouble(15, Double.parseDouble(table.getValueAt(k, 11).toString()));
				prst.setDouble(16, Double.parseDouble(table.getValueAt(k, 10).toString()));
				prst.setString(17, "N");
				prst.setString(18, "N");
				prst.setInt(19, pd_seq);
				prst.setString(20, vvcashiercode);
				prst.setString(21, "Y");
				prst.setString(22, vvcashiercode);
				prst.setInt(23, vterminal);
				prst.setInt(24, vshift);
				prst.setInt(25, k);
				// prst.setString(25,
				// comboTable.getSelectedItem().toString().trim());
				prst.setString(26, table.getValueAt(k, 12).toString());
				prst.setString(27, vvsales_type);
				prst.setString(28, "N");
				prst.setString(29, table.getValueAt(k, 14).toString());
				prst.setString(30, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 15).toString()));
				String vproductrcost = new gnArticle().Article_getData(table.getValueAt(k, 1).toString(), "Cost");
				prst.setString(31, vproductrcost); // Hide cost column value
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
					Double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
					double vcgst = vcaltaxamt / 2;
					double vsgst = vcaltaxamt / 2;
					double vigst = 0.00;

					prst.setString(41, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
					prst.setString(42, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
					prst.setString(43, new gnMath().get2DecimaltValue(Double.toString(vigst)));
					prst.setString(44, vmovtype);
				}

				if ((vmy - voth != 0)) {
					double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
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
				vnet = Double.parseDouble(table.getValueAt(k, 11).toString());
				vtxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
				vtaxablevalue = vnet - vtxamt;
				prst.setString(45, new gnMath().get2DecimaltValue(Double.toString(vtaxablevalue)));
				prst.setString(46, vmystatename);
				prst.setString(47, new gnFinYear().getCurrentFinYear(invdate.getText()));
				double vtaxper = Double.parseDouble(table.getValueAt(k, 12).toString());

				String vvcost = new gnArticle().Article_getData(table.getValueAt(k, 1).toString(), "Cost");
				double vcost = Double.parseDouble(vvcost);
				double vqty = Double.parseDouble(table.getValueAt(k, 3).toString());
				Double vcogs = new gnMath().CalTax_Pur(vcost, vtaxper);
				Double vcostvalue = vcost - vcogs;
				vcostvalue = vqty * vcostvalue;
				// new General().msg("Cogs:"+" "+vcostvalue);
				prst.setString(48, Double.toString(vcostvalue));
				prst.setString(49, table.getValueAt(k, 16).toString()); // FreeARticleQty
				prst.setString(50, table.getValueAt(k, 7).toString()); // Manul

				// Resto
				prst.setString(51, table.getValueAt(k, 17).toString()); // Manul
				prst.setString(52, table.getValueAt(k, 18).toString()); // Manul
				prst.setString(53, table.getValueAt(k, 19).toString()); // Manul
				prst.setString(54, table.getValueAt(k, 13).toString()); // Tasste
				prst.setString(55, orderno.getText()); // orderno
				prst.setString(56, invdate.getText()); // orderdate
				// End REsto

				prst.addBatch();
				// new General().msg("Prst:" +" "+prst);
				TotalRecordinsert = TotalRecordinsert + 1;
				vvggross = vvggross + Double.parseDouble(table.getValueAt(k, 6).toString());
				vvdisc = vvdisc + (Double.parseDouble(table.getValueAt(k, 7).toString())
						+ Double.parseDouble(table.getValueAt(k, 8).toString()));
				if (TotalRecordinsert % batchSize == 0) {
					int[] recordws = prst.executeBatch();
					con1.commit();
					DBdetail = "Sucess";
				}
				int[] ff = prst.executeBatch(); // insert remaining records
				con1.commit();
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg(e.getLocalizedMessage());
			new gnLogger().loggerInfoEntry("Hold Bill", e.getLocalizedMessage());
			con1.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
				// new General().msg("Insert item master for Promo");
			}
			if (DBdetail == "Sucess") {
				new gnLogger().loggerDebugEntry("POS",
						"Detail  ===>>." + " " + "Save Sucessfully " + "InvNo:" + "" + vvinvno);
				if (promoModuleActivated == "Y") {
				}
			}
		}
		return DBdetail;
	}

	private void MarkForRemoveFreePromo() throws ClassNotFoundException, SQLException {
		String vfree = "FreeArticle";
		String vproducttype = "";
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			table.setValueAt("0", i, 8);
			table.setValueAt("0", i, 9);
			table.setValueAt("0", i, 16);
			try {
				RecalculateAfterPormo(i);
			} catch (Throwable e) {
				e.printStackTrace();
				new General().msg("Promo Data Reinitiate" + e.getLocalizedMessage());
			}
		}
		// new General().msg("Please check All Fields");
	}

	private void startPromoApplyProcess() throws Throwable {

		MarkForRemoveFreePromo();
		String vinvno = invno.getText();
		String vinvdate = invdate.getText();
		vinvdate = new gnConfig().date_ConverttoDBforamt(vinvdate);
		int myrow = 0;
		try {
			String status = pickDataForInsertforpromo();
			if (status == "Sucess") {
				new gnPromoCheck().collectDataForPromocheck(vinvno, vinvdate);
				new gnPromoCheck().applyPromoNow(vinvno, vinvdate);
			}
		} catch (Exception e) {
			new General().msg(e.getLocalizedMessage());
		} finally {

			// new General().msg("Applting Item Level disc Promos");
			ApplyPromoArticlesOnly();
			// new General().msg("End Item Level disc Promos");

			// new General().msg("Applting Brand & Hiearchy Level disc Promos");
			String vlevelType = "BrandDisc";
			LoadAricleDiscBrandandHierarchyLevel(vlevelType);

			vlevelType = "CatDisc";
			LoadAricleDiscBrandandHierarchyLevel(vlevelType);

			vlevelType = "SubCatDisc";
			LoadAricleDiscBrandandHierarchyLevel(vlevelType);
			// new General().msg("End Brand & Hierarcchy Level disc Promos");

			// new General().msg("Applying Free Article disc Promos");
			loadFreeArticleFromTable(); // With new logic use this
			// new General().msg("End Free Article disc Promos");

			// new General().msg("Applying Bill Level disc Promos");
			LoadBillLevelSpecialArticlePromo();
			loadBillLevelDisc();
			// new General().msg("End Bill Level disc Promos");

			ShowAppliedPromo();
		}
	}

	private void ApplyPromoArticlesOnly() throws Throwable {

		String varticle = "";
		double vtotalqty;
		double vtotalvalue;
		double vtotaldiscamt;
		double vperqtydisc;
		int row;
		double perqtydisc;
		Double vqty = 0.00;
		Double vvalue = 0.00;
		Double vtableqty = 0.0;
		Double vdiscamt = 0.00;
		Double vapplydiscamt = 0.0;
		String vproductname = "";
		double vpurcondto = 0;
		vallocatefreeqty = 0;
		String vfreeArticleqty = " ";
		String vinvno = invno.getText();
		String vinvdate = invdate.getText();
		vinvdate = new gnConfig().date_ConverttoDBforamt(vinvdate);
		String SQL = "select  article_code,   promoTypecode,  perqtydiscamt , qty, value , purcondto , Applydiscamt"
				+ "  from tmp_pos_promoApply  where company_code = " + vcomp + " and site_code = " + vstore + ""
				+ " and  billno = '" + vinvno + "' and  billdate = '" + vinvdate + "' ";
		rs = this.getSPResult(SQL);

		while (rs.next()) {
			vallocatefreeqty = 0;
			vprompTypecode = rs.getString(2);
			xvarticle = rs.getString(1).toString().trim();
			switch (vprompTypecode) {
			case "1":
				// new General().msg("Applying Discount in GUI For Article for
				// Item Disc %" + " "+ xvarticle) ;
				perqtydisc = Double.parseDouble(rs.getString(3));
				vtotalqty = Double.parseDouble(rs.getString(4));
				vpurcondto = Double.parseDouble(rs.getString(6));
				vapplydiscamt = Double.parseDouble(rs.getString(7));
				row = table.getRowCount();
				for (int i = 0; i < row; i++) {
					vproductname = table.getValueAt(i, 1).toString().trim();
					// new General().msg("Table Running Article Code is :" + "
					// "+vproductname);
					if (vproductname.equalsIgnoreCase(xvarticle)) {
						// new General().msg("In side Table Row found Table
						// Running Article Code is :" + " "+vproductname);
						if (vtotalqty > vpurcondto) {
							vqty = vpurcondto;
							vtableqty = Double.parseDouble(table.getValueAt(i, 3).toString());
							if (vtableqty > vpurcondto) {
								vtableqty = Double.parseDouble(table.getValueAt(i, 3).toString());
								vdiscamt = vpurcondto * perqtydisc;
								vallocatefreeqty = vallocatefreeqty + vdiscamt;
							}

							if (vtableqty <= vpurcondto) {
								vtableqty = Double.parseDouble(table.getValueAt(i, 3).toString());
								vdiscamt = vtableqty * perqtydisc;
								vallocatefreeqty = vallocatefreeqty + vdiscamt;
							}

							if (vallocatefreeqty >= vapplydiscamt) {
								Double xvdiscamt = vallocatefreeqty - vdiscamt;
								vdiscamt = vapplydiscamt - xvdiscamt;
								if (vdiscamt < 0) {
									vdiscamt = 0.0;
								}
							}
						}

						if (vtotalqty <= vpurcondto) {
							vtableqty = Double.parseDouble(table.getValueAt(i, 3).toString());
							vdiscamt = vtableqty * perqtydisc;
							vallocatefreeqty = vallocatefreeqty + vdiscamt;
						}

						if (vdiscamt > 0) {
							table.setValueAt(vdiscamt, i, 9);
							table.setValueAt("Discpercnt", i, 16);
						}
						RecalculateAfterPormo(i);
					}
				}
				break;

			case "2":
				// new General().msg("Applying Discount in GUI For Article for
				// Item Disc Amt" + " "+ xvarticle) ;
				perqtydisc = Double.parseDouble(rs.getString(3));
				vtotalqty = Double.parseDouble(rs.getString(4));
				row = table.getRowCount();
				for (int i = 0; i < row; i++) {
					vproductname = table.getValueAt(i, 1).toString().trim();
					// new General().msg("Table Running Article Code is :" + "
					// "+vproductname);
					if (vproductname.equalsIgnoreCase(xvarticle)) {
						vqty = Double.parseDouble(table.getValueAt(i, 3).toString());
						vdiscamt = vqty * perqtydisc;
						String vvdiscamt = new gnMath().get2DecimaltValue(Double.toString(vdiscamt));
						table.setValueAt(vvdiscamt, i, 9);
						table.setValueAt("Discamt", i, 16);
						RecalculateAfterPormo(i);
					}
				}
				break;
			}// Switch
		}
		new gnTable().setTableColWidth(table, 2, 300);
	}

	public void LoadAricleDiscBrandandHierarchyLevel(String vleveltype) throws Throwable {
		String varticle = "";
		String vtableArticle;
		String vtableQty;
		String vtableRate;
		int row;
		String vrate;
		String vqty;
		double vdisc;
		double vdiscperqty = 0;
		double vmydiscamt = 0;
		double vmyqty;
		double tabledisc;
		double vhdrdisc;
		String vfreearticledisc = "";
		double vgross;
		double vnet;
		String vinvno = invno.getText();
		String vinvdate = invdate.getText();
		String loadFree = vleveltype;
		vinvdate = new gnConfig().date_ConverttoDBforamt(vinvdate);
		String SQL = "select  article_code,  qty, rate , disc , Billdisc , FreeArticle_disc , gross, Amount   "
				+ "  from promo_applyontable  where company_code = " + vcomp + "   and site_code = " + vstore + ""
				+ "  and freeArticle_disc = '" + loadFree + "'  and  billno = '" + vinvno + "' and   billdate= '"
				+ vinvdate + "' ";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			varticle = rs.getString(1);
			vqty = rs.getString(2);
			vmyqty = Double.parseDouble(vqty);
			vrate = rs.getString(3);
			vdisc = Double.parseDouble(rs.getString(4));
			vhdrdisc = Double.parseDouble(rs.getString(5));
			vfreearticledisc = rs.getString(6);
			// new General().msg("disc qty rate" +vdisc+" "+vqty+" "+vrate);
			row = table.getRowCount();
			for (int i = 0; i < row; i++) {
				vtableArticle = table.getValueAt(i, 1).toString().trim();
				vtableQty = table.getValueAt(i, 3).toString().trim();
				double vvtableQty = Double.parseDouble(vtableQty);
				vtableRate = table.getValueAt(i, 4).toString().trim();
				tabledisc = Double.parseDouble(table.getValueAt(i, 8).toString().trim());
				if (tabledisc <= vdisc) {
					if (vtableArticle.equalsIgnoreCase(varticle) && vvtableQty == vmyqty) // &&
					{
						// new General().msg("inside disc" +vdisc);
						table.setValueAt(vdisc, i, 9);
						table.setValueAt(vfreearticledisc, i, 16);
						RecalculateAfterPormo(i);
					}
				}
			} // For
		} // End RS
		int vcount = table.getRowCount();
		records.setText(Integer.toString(vcount));
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.setRowHeight(27);
		table.setGridColor(Color.DARK_GRAY);
		table.setSelectionBackground(Color.blue);
		table.setSelectionForeground(Color.WHITE);
	}

	private void loadFreeArticleFromTable() throws Throwable {
		table.grabFocus();
		// new General().msg("Loading Free Disc as per new logic ") ;;
		int vsrno = 0;
		double vfreediscamt = 0;
		String vfreearticle = "";
		String vfreearticledisc = "0";

		String vinvno = invno.getText();
		String vinvdate = invdate.getText();
		String loadFree = "FreeArticle";
		vinvdate = new gnConfig().date_ConverttoDBforamt(vinvdate);
		String SQL = "select  article_code,  qty, rate , disc , Billdisc , FreeArticle_disc , gross, Amount  , srno "
				+ "  from promo_applyontable  where company_code = " + vcomp + "   and site_code = " + vstore + ""
				+ "  and trim(freeArticle_disc)  =  '" + loadFree + "'  and  billno = '" + vinvno
				+ "' and   billdate= '" + vinvdate + "' ";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vfreearticle = rs.getString(1);
			vfreediscamt = Double.parseDouble(rs.getString(4));
			vfreearticledisc = rs.getString(6);
			vsrno = Integer.parseInt(rs.getString(9));

			int row = table.getRowCount();
			for (int i = 0; i < row; i++) {
				String vproductname = table.getValueAt(i, 1).toString().trim();
				if (vproductname.equalsIgnoreCase(vfreearticle) && vsrno == i
						&& vfreearticledisc.equalsIgnoreCase(loadFree)) {
					table.setValueAt(vfreediscamt, i, 9);
					table.setValueAt("FreeArticle", i, 16);
					RecalculateAfterPormo(i);
				}
			} // For Loop
			scanItem_2.grabFocus();
			scanItem_2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		} // End Rs loop
	}// NewFreeLoad Methos End

	private void loadBillLevelDisc() throws Throwable {
		int row;
		String vdiscamt = "";
		String vqty;
		String vtableqty;
		String vproductname = "";
		String vinvno = invno.getText();
		String vinvdate = invdate.getText();
		vinvdate = new gnConfig().date_ConverttoDBforamt(vinvdate);
		String vbillvalue = netAmount.getText();

		String vpromotypecode = "";
		String vpromoType;
		String vpromocode;
		String vcode = "0";
		String vbillqty = "0";
		String vname = "0";
		String vconditionon;
		String vpurcondfrom;
		String vpurcondto;
		String vdiscper = null;
		String vtype = "BillLevel";
		String SQL;
		new gnPromoCheck().newApplyBillLevel(vinvno, vinvdate, vbillvalue);
		SQL = "Select * from tmp_pos_promoApply  where company_code  = " + vcomp + "  and site_code = " + vstore
				+ " and " + " billno=  " + vinvno + " and billdate = '" + vinvdate + "'  and  promotypecode = '" + 3
				+ "' ";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vdiscper = rs.getString(15).trim(); // hdrdisc
			vpromotypecode = rs.getString(9).trim();
		}

		if (vpromotypecode.equals("3")) {
			vprompTypecode = "3";
			billhdrdiscper.setText(vdiscper);
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			Promohdrdisc = "Y";
			DistributeDiscountperForBillLevel(vdiscper);
			Promohdrdisc = "N";
		} else {
		}
	}// End Method>

	private void LoadBillLevelSpecialArticlePromo() throws Throwable {
		String vinvno = invno.getText();
		String vinvdate = invdate.getText();
		vinvdate = new gnConfig().date_ConverttoDBforamt(vinvdate);
		String vbillvalue = netAmount.getText();
		new gnPromoCheck().newApplyBillLevelSpecialRatePromo(vinvno, vinvdate, vbillvalue);
		new gnPromoCheck().applySpecialRateOntable(vinvno, vinvdate);
		String vtype = "Spl-Rate";
		LoadSpecialAricleDisc(vtype);
	}

	public void LoadSpecialAricleDisc(String vleveltype) throws Throwable {
		String varticle = "";
		String vtableArticle;
		String vtableQty;
		String vtableRate;
		int row;
		String vrate;
		String vqty;
		double vdisc;
		double vdiscperqty = 0;
		double vmydiscamt = 0;
		double vmyqty;
		int vsrno = 0;
		double tabledisc;
		double vhdrdisc;
		String vfreearticledisc = "";
		double vgross;
		double vnet;
		String vinvno = invno.getText();
		String vinvdate = invdate.getText();
		String loadFree = vleveltype;
		vinvdate = new gnConfig().date_ConverttoDBforamt(vinvdate);
		String SQL = "select  article_code,  qty, rate , disc , Billdisc , FreeArticle_disc , gross, Amount , srno  "
				+ "  from promo_applyontable  where company_code = " + vcomp + "   and site_code = " + vstore + ""
				+ "  and freeArticle_disc = '" + loadFree + "'  and  billno = '" + vinvno + "' and   billdate= '"
				+ vinvdate + "' ";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			varticle = rs.getString(1);
			vqty = rs.getString(2);
			vmyqty = Double.parseDouble(vqty);
			vrate = rs.getString(3);
			vsrno = Integer.parseInt(rs.getString(9));
			vdisc = Double.parseDouble(rs.getString(4));
			vhdrdisc = Double.parseDouble(rs.getString(5));
			vfreearticledisc = rs.getString(6);
			// new General().msg("disc qty rate" +vdisc+" "+vqty+" "+vrate);
			row = table.getRowCount();
			for (int i = 0; i < row; i++) {
				vtableArticle = table.getValueAt(i, 1).toString().trim();
				vtableQty = table.getValueAt(i, 3).toString().trim();
				double vvtableQty = Double.parseDouble(vtableQty);
				vtableRate = table.getValueAt(i, 4).toString().trim();
				tabledisc = Double.parseDouble(table.getValueAt(i, 8).toString().trim());
				if (tabledisc <= vdisc) {
					if (vtableArticle.equalsIgnoreCase(varticle) && vvtableQty == vmyqty && vsrno == i) // &&
					{
						// new General().msg("inside disc" +vdisc);
						table.setValueAt(vdisc, i, 9);
						table.setValueAt(vfreearticledisc, i, 16);
						RecalculateAfterPormo(i);
					}
				}
			} // For
		} // End RS
		int vcount = table.getRowCount();
		records.setText(Integer.toString(vcount));
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.setRowHeight(27);
		table.setGridColor(Color.DARK_GRAY);
		table.setSelectionBackground(Color.blue);
		table.setSelectionForeground(Color.WHITE);
	}

	private void ShowAppliedPromo() throws Throwable {
		new gnTable().RemoveTableRows(promomodel);
		String vapplicable = "Y";
		String vinvno = invno.getText();
		String vinvdate = invdate.getText();
		vinvdate = new gnConfig().date_ConverttoDBforamt(vinvdate);
		String[] vcol = { "Article", "Name", "Qty", "Value", "PromoType", "PromoName", "PromoCode", "PurCondFrom",
				"PurCond.To", "ApplyPromo", "Dis%", "DiscAmt", "Apply Disc.Amt on Bill", "Per Qty Disc Amt.",
				"Free Article", "FreeQty" };
		promomodel.setColumnIdentifiers(vcol);
		String SQL = "Select  Article_code, name, qty , value, promotypecode, promoTypename , PromoCode , "
				+ "Purchasecondfrom , purCondto, ApplyPromo, discper, discamt,  applyDiscamt, perqtydiscamt,  freeArticle , freeQty "
				+ "   From tmp_pos_promoApply  where  Company_code  =  " + vcomp + "  and  site_code  = " + vstore
				+ " and " + "Billno  =  " + vinvno + "  and    billdate  ='" + vinvdate + "' ";
		// new General().msg(SQL);
		String vtypecode = "";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			promomodel.insertRow(0,
					new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10),
							rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
							rs.getString(16) });
		}
		promotable.setModel(promomodel);
		promotable.setBackground(Color.WHITE);
		promotable.setForeground(Color.BLUE);
		new gnTable().setTableColWidth(promotable, 1, 150);
		new gnTable().setTableColWidth(promotable, 5, 150);
		JViewport prt1101 = new JViewport();
		prt1101.setBackground(new Color(51, 255, 255));
		prt1101.add(promotable, vcol);
		prt1101.setVisible(true);
		promojsp.setViewport(prt1101);
		promoArticle = "0";
		resetPromoparameters();
	}

	public void Selectf7button() {
		new General().msg("Key Pressed");
		btn_Payment.requestFocus(true);
		btn_Payment.grabFocus();
		btn_Payment.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "F7");
		btn_Payment.getActionMap().put("F7", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					processPaymentNow();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	// Fertilizer Related change

	private void captureCropDetails() {

		// Fertilizer to capture crop details
		String vitemname = table.getValueAt(0, 2).toString(); // fertlizer
		assignCropDetails(varticle, vitemname); // Fertilizer

		// End Fertilizer to capture crop details
	}

	public void AddcaptureCropDetails() {

		// Fertilizer to capture crop details

		int row = croptable.getSelectedRow();
		// new General().msg("Selected Row is:"+""+row);
		String vitemname = croptable.getValueAt(row, 2).toString(); // fertlizer
		// String vitemname = "nitin" ;
		// new General().msg("Selected Article is:"+""+varticle);
		assignCropDetails(varticle, vitemname); // Fertilizer

		// End Fertilizer to capture crop details
	}

	private void assignCropDetails(String vitemcode, String vitemname) {
		// new gnTable().RemoveTableRows(cropmodel);
		String vverticle = new gnHierarchy().getVerticleCode();
		switch (vverticle) {
		case "5":
			String vcrop[] = { "Remove", "Itemcode", "Item Name", "Crop Name", "Area" };
			cropmodel.setColumnIdentifiers(vcrop);
			cropmodel.insertRow(0, new Object[] { "X", vitemcode, vitemname, " ", "0" });

			croptable.setModel(cropmodel);
			String vmsname = "Crop";
			String vsearch = "%%";
			String SQL1 = "call master_getMasterData('" + vmsname + "' , " + vverticle + "  , '" + vsearch + "')";
			croptable.getColumnModel().getColumn(3)
					.setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL1)));

			// croptable.getColumnModel().getColumn(5).setCellRenderer(new
			// gnBtnRenderer());
			// croptable.getColumnModel().getColumn(5).setCellEditor(new
			// gnButtonEditor(new JTextField()));

			new gnTable().setTableColWidth(croptable, 2, 150);
			new gnTable().setTableColWidth(croptable, 3, 150);
			croptable.setRowHeight(27);
			croptable.setBackground(Color.BLACK);
			croptable.setForeground(Color.WHITE);
			croptable.setSelectionForeground(Color.white);
			// croptable.setEditingRow(0);
			JViewport prt11011 = new JViewport();
			prt11011.setBackground(new Color(51, 255, 255));
			prt11011.add(croptable);
			prt11011.setVisible(true);
			promojsp.setViewport(prt11011);
			promojsp.setVisible(true);
			int row = croptable.getRowCount();

			// new General().msg("row:"+ " "+ row);
			// croptable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		} // Switch
	}

	private void insertCropmappingDetails() throws Throwable {
		// new General().msg("Insert Crop Details...");
		int row = croptable.getRowCount();
		if (row > 0) {
			prst = null;
			final int batchSize = 10;
			int TotalRecordinsert = 0;
			Connection con = this.getConnection();
			con.setAutoCommit(false);
			String grndetail = "Insert into  ms_farmercarft_master(Company_code,  branch_code,    Invoiceno, InvoiceDate ,  Farmercode,  "
					+ "Article_code , Name  , craftcode, craftName, landArea, seasoncode, seasonname, Frommonth , tomonth )"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				prst = con.prepareStatement(grndetail);
				for (int i = 0; i < row; i++) {
					prst.setString(1, vcomp);
					prst.setString(2, vstore);
					prst.setInt(3, vvinvno);
					prst.setString(4, Svinvdate);
					prst.setInt(5, vvcustid);
					prst.setString(6, croptable.getValueAt(i, 1).toString());
					prst.setString(7, croptable.getValueAt(i, 2).toString());
					prst.setString(8, croptable.getValueAt(i, 3).toString());
					prst.setString(9, croptable.getValueAt(i, 3).toString());
					prst.setString(10, croptable.getValueAt(i, 4).toString());
					prst.setString(11, "None");
					prst.setString(12, "None");
					prst.setString(13, "None");
					prst.setString(14, "None");
					prst.addBatch();
					TotalRecordinsert = TotalRecordinsert + 1;
					if (++TotalRecordinsert % batchSize == 0) {
						prst.executeBatch();
						con.commit();
					}
					prst.executeBatch(); // insert remaining records
					con.commit();
				} // For
			} catch (SQLException e) {
				new General().msg("Crop Data Saving Issues " + e.getMessage());
				con.rollback();
			} finally {
				if (prst != null) {
					prst.close();
					// new General().Quickmsg("Crop Data Saved SucessFully");
					new gnTable().RemoveTableRows(cropmodel);
				}
				if (con != null) {
					con.close();
				}
			}
		}
	}

	// For Quick Billing Scanning Data and Storing in Table and finally end of
	// day booking Sales
	private void getScanDataForBilling() throws Throwable {
		String vdate = new gnConfig().date_ConverttoDBforamt(new General().getBegindate());
		selectedrow = 0;
		String vtype = "GetDataForSalesBooking";
		String varticle = "0";
		String vname = "0";
		String vqty = "0";
		String vrate = "0";
		String vterminal = terminalID.getText();
		String vuid = new General().getUsercode();
		String vtime = new General().getTime();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String SQL = "call scanItem_billData( '" + vtype + "' ,  " + vcomp + " ," + vstore + " , " + varticle + " , '"
				+ vname + "' , '" + vdate + "' , " + vqty + " , " + vrate + " , " + vterminal + ", '" + vuid + "' , '"
				+ vtime + "')";
		try {
			ResultSet rs1 = this.getSPResult(SQL);
			while (rs1.next()) {
				String value = rs1.getString(1);
				showTableData(value, model);
			}

			if (table.getRowCount() > 0) {
				calHdrDisocunt();
				new General().msg(
						"Scan Data Loaded Sucessfully ..Please Click on Payment Button (Enter Total Amount...and Save Data");
			}
		} catch (Exception e) {
			new General().msg(e.getLocalizedMessage());
			new gnLogger().loggerInfoEntry("POS", e.getLocalizedMessage());
		}
	}

	private void updatePostingStatusForScanData() throws ClassNotFoundException, SQLException {
		String vdate = new gnConfig().date_ConverttoDBforamt(new General().getBegindate());
		selectedrow = 0;
		String vtype = "UpdateStatus";
		String varticle = "0";
		String vname = "0";
		String vqty = "0";
		String vrate = "0";
		String vterminal = terminalID.getText();
		String vuid = new General().getUsercode();
		String vtime = new General().getTime();
		String SQL = "call scanItem_billData( '" + vtype + "' ,  " + vcomp + " ," + vstore + " , " + varticle + " , '"
				+ vname + "' , '" + vdate + "' , " + vqty + " , " + vrate + " , " + vterminal + " , '" + vuid + "' , '"
				+ vtime + "')";
		// new General().msg(SQL);
		this.getSPResult(SQL);

	}

	//// Customer Search Start here

	class lsnrCustName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			try {
				String sname = custname.getText().trim();
				sname = "%" + sname + "%";
				String vcomp;
				vcomp = new gnConfig().getCompanyCode();
				String[] SCol = { "Type", "Code", "Name", "Mobile", "Addr1", "Addr2" };
				String sqlcust = "Select code, name, mobile, addr1 , addr2 from ms_customer_master where company_code = "
						+ vcomp + " " + " and name like '" + sname + "' ";
				int colno = 5;
				String vtype = "1";
				MyCustSearch(sqlcust, SCol, colno, vtype);
				// Search(sqlcust, SCol);
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
		}
	}

	

	
	
	class lsnrMobile implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			try {
				String sname = mobile.getText().trim();
				sname = sname + "%";
				String vcomp;
				vcomp = new gnConfig().getCompanyCode();
				String[] SCol = { "Type", "Code", "Name", "Mobile", "Addr1", "Addr2" };
				int colno = 5;
				String sqlcust = "Select code, name, mobile, addr1 , addr2 from ms_customer_master where company_code = "
						+ vcomp + " " + " and mobile like '" + sname + "' ";
				String vtype = "2";
				MyCustSearch(sqlcust, SCol, colno, vtype);
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
		}
	}

	
	public void MyCustSearch(String sqlsearch, String[] Col, int colno, String vselecttype)
			throws SQLException, ClassNotFoundException {
 		new gnTable().RemoveTableRows(promomodel);
		String vtype = "Customer";
		promotable = new gnTableModel().Tablemodel(promotable, promomodel, sqlsearch, Col, colno, "N", "Y", vtype);
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(promotable)));
		promotable.requestFocus();
		new gnTable().setTableColWidth(promotable, 1, 150);
		new gnTable().setTableColWidth(promotable, 2, 150);
		promotable.setBackground(Color.black);
		promotable.setForeground(Color.WHITE);
		promotable.setSelectionForeground(Color.white);
		promotable.setEditingRow(0);
		JViewport prt1101 = new JViewport();
		prt1101.setBackground(new Color(51, 255, 255));
		prt1101.add(promotable);
		prt1101.setVisible(true);
		promojsp.setViewport(prt1101);
		new gnTable().setFontBold(promotable, 14);
		Selectcustrow();
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		new gnLogger().loggerInfoEntry("POS", "Selecting New Customer");
		lblmsg.setText("Select Customer From List  .. ");
		int row = promotable.getRowCount();
		if (row == 0) {
			switch (vselecttype) {
			case "1":
				mobile.grabFocus();
				break;
			case "2":
				hm_addr1.grabFocus();
				break;
			}
		}
 	}

	
	
	public void Selectcustrow() {
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		promotable.grabFocus();
		promotable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		promotable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {

				int row = promotable.getSelectedRow();
				String vcustcode = (String) promotable.getValueAt(row, 1);
				String vcustname = (String) promotable.getValueAt(row, 2);
				String vcustmobile = (String) promotable.getValueAt(row, 3);
				String vaddr1 = (String) promotable.getValueAt(row, 4);
				String vaddr2 = (String) promotable.getValueAt(row, 5);
				custid.setText(vcustcode);
				custname.setText(vcustname);
				mobile.setText(vcustmobile);
				hm_addr1.setText(vaddr1);
				hm_addr2.setText(vaddr2);
				new gnTable().RemoveTableRows(promomodel);
				new gnLogger().loggerInfoEntry("POS", "Customer Search Over");
				scanItem_2.grabFocus();
				lblmsg.setText("Select Item From List Press Enter .. ");
			}
		});
	}

	class newcustLsne implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vmobileno = mobile.getText();
			if (vmobileno.length() == 0) {
				mobile.setText("0");
			}
			try {
				String vcode = "";
				String vname = "";
				String vmobile = "";
				String vaddr1 = "";
				String vaddr2 = "";
				String status = "Y";
				String vapplypromo = "Y";
				String vpromoStartdate = new gnConfig().date_ConverttoDBforamt(invdate.getText());

				String vvalue = custid.getText();
				if (vvalue.length() == 0) {
					// String status = new
					// gnSupplier().checkCustomerExists(custid.getText()) ;
					status = "N";
				} else {
					status = "Y";
				}
				switch (status) {
				case "N":
					vname = custname.getText().trim();
					vmobile = mobile.getText();
					vaddr1 = hm_addr1.getText();
					vaddr2 = hm_addr2.getText();
					custid.setText(new gnSupplier().getNewCustomerCode());
					vcode = custid.getText();
					new gnSupplier().SaveCustData(vcode, vname, vmobile, vaddr1, vaddr2, vapplypromo, vpromoStartdate);
					break;
				case "Y":
					vcode = custid.getText();
					vname = custname.getText().trim();
					vmobile = mobile.getText();
					vaddr1 = hm_addr1.getText();
					vaddr2 = hm_addr2.getText();
					new gnSupplier().updateCustData(vcode, vname, vmobile, vaddr1, vaddr2);
					scanItem_2.grabFocus();
					lblmsg.setText("Please Select Order Type <If Not Selected > and then Search Item..");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				scanItem_2.grabFocus();
				btnNewButton.setBackground(Color.cyan);
				btnNewButton.setBackground(Color.BLACK);
			}
		}
	}

	class articleComboLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vname = "code";
			String vcode = "0";
			String myarticle = comboArticle.getSelectedItem().toString().trim();
			try {
				vcode = new gnArticle().Article_getData(vname, myarticle);
			} catch (Throwable e) {
				e.printStackTrace();
				new General().msg(e.getLocalizedMessage());
			} finally {
				try {
					// showTableData(vcode, model);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}

	// resto Funtion Starts Here
	// Restaurant Related

	class holdLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			orderAdding = "N";
			int row = table.getRowCount();
			if (row > 0) {

				if (mobile.getText().length() == 0) {
					mobile.setText("0");
				}

				if (custid.getText().length() == 0) {
					custid.setText("0");
				}
				holdOrder();
				comboOrderType.setEnabled(false);
			}
		}
	}

	private void holdOrder() {
		try {

			nordertype.setFont(new Font("Tahoma", Font.BOLD, 16));
			if (custid.getText().length() == 0) {
				custid.setText("0");
			}

			if (mobile.getText().length() == 0) {
				mobile.setText("0");
			}

			String vstatus = validatetoken();
			if (vstatus == "Sucess") {
				insertTableOrder();
				new gnTable().RemoveTableRows(model);
			}
		} catch (Throwable e1) {
			e1.printStackTrace();
		} finally {
			try {
				comboOrderType.setSelectedItem("N/A");
				comboOrderType.setEnabled(true);
				orderno.setEnabled(true);
				orderno.setText(null);
				comboTable.setSelectedItem("0");
				custid.setText("0");
				comboTable.setVisible(false);
				btnNewButton.setEnabled(true);
				nordertype.setText(null);
				ntableno.setText(null);
				nordertype.setEditable(true);
				ntableno.setEditable(true);
				nordertype.setEnabled(true);
				ntableno.setEnabled(true);
				nordertype.setBackground(Color.WHITE);
				ntableno.setBackground(Color.WHITE);
				showTableHoldData();
				scanItem_2.grabFocus();

			} catch (Throwable e1) {
				e1.printStackTrace();
				new gnLogger().loggerInfoEntry("Order Hold Issue", e1.getMessage());
				new General().msg("Order Hold Issue:" + " " + e1.getLocalizedMessage());
			}
		}
	}

	public String insertTableOrder() throws Throwable {

		// dont Remove This Line : Batch_no is used to store Time and EAN Field
		// is used to store Mobile

		generateAndAssignKOT();

		pickDataForHoldOver();
		String vinvdate = invdate.getText();
		String vinvno = invno.getText();
		vinvdate = new gnConfig().date_ConverttoDBforamt(vinvdate);
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		String DBdetail = "Fail";
		String poshdr = "Insert into tmp_pos_sales_detail_resto (company_code ," + "site_code, " + " invDate ,"
				+ "invno," + "Article_code ," + "EAN ," + "customer_code ," + "qty," + "sales_price," + "MRP,"
				+ "Taxcode," + "Gross_amount, " + "Disc," + "hdr_disc ," + "net_amount , " + "Tax_amount , "
				+ "Promo_ind," + "promo_code," + "line_seq," + "CreatedBy, " + "Insert_status," + " Cashier_code, " // 22
				+ "Terminal_ID, shift , srno, tax_per, sales_type , "
				+ "batch_article, Batch_no, Expiry_date, cost, verticle, location ,"
				+ "state, statename, regdealer, mycompanyisgst, mygstno, mycompState, custGSTno ,"
				+ "cgst, sgst, igst , movementType, TaxableValue, mystatename, finyear , cogs,"
				+ " FreeArticle_Disc , Emp_disc, OrderType , tableno , KOT, taste , orderno , orderdate)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		prst = con1.prepareStatement(poshdr);
		int row = table.getRowCount();
		if (row > 0) {
			try {
				for (int k = 0; k < row; k++) {
					pd_seq = k + 1;
					prst.setString(1, vvcompnaycode);
					prst.setString(2, vvsitecode);
					prst.setString(3, Svinvdate);
					prst.setInt(4, vvinvno);
					prst.setString(5, table.getValueAt(k, 1).toString());
					prst.setString(6, mobile.getText()); // EAN FIELD IS USED TO
															// STORE MOBILE
					prst.setInt(7, vvcustid);
					prst.setString(8, (table.getValueAt(k, 3).toString()));
					prst.setDouble(9, Double.parseDouble(table.getValueAt(k, 4).toString()));
					prst.setDouble(10, Double.parseDouble(table.getValueAt(k, 5).toString()));

					prst.setString(11, (table.getValueAt(k, 12).toString()));
					prst.setDouble(12, Double.parseDouble(table.getValueAt(k, 6).toString()));
					prst.setDouble(13, Double.parseDouble(table.getValueAt(k, 9).toString()));
					prst.setDouble(14, Double.parseDouble(table.getValueAt(k, 8).toString()));
					prst.setDouble(15, Double.parseDouble(table.getValueAt(k, 11).toString()));
					prst.setDouble(16, Double.parseDouble(table.getValueAt(k, 10).toString()));
					prst.setString(17, "N");
					prst.setString(18, "N");
					prst.setInt(19, pd_seq);
					prst.setString(20, vvcashiercode);
					prst.setString(21, "Y");
					prst.setString(22, vvcashiercode);
					prst.setInt(23, vterminal);
					prst.setInt(24, vshift);
					// prst.setInt(25, k);
					prst.setString(25, comboTable.getSelectedItem().toString().trim());
					prst.setString(26, table.getValueAt(k, 12).toString());
					prst.setString(27, vvsales_type);
					prst.setString(28, "N"); // BatchArticle

					// prst.setString(29, table.getValueAt(k, 14).toString());
					// //BAtchno
					prst.setString(29, new General().getTime()); // batch no
																	// used fot
																	// table
																	// time

					prst.setString(30, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 15).toString()));
					String vproductrcost = new gnArticle().Article_getData(table.getValueAt(k, 1).toString(), "Cost");
					prst.setString(31, vproductrcost); // Hide cost column value
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
						Double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
						double vcgst = vcaltaxamt / 2;
						double vsgst = vcaltaxamt / 2;
						double vigst = 0.00;
						prst.setString(41, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
						prst.setString(42, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
						prst.setString(43, new gnMath().get2DecimaltValue(Double.toString(vigst)));
						prst.setString(44, vmovtype);
					}

					if ((vmy - voth != 0)) {
						double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
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
					vnet = Double.parseDouble(table.getValueAt(k, 11).toString());
					vtxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
					vtaxablevalue = vnet - vtxamt;
					prst.setString(45, new gnMath().get2DecimaltValue(Double.toString(vtaxablevalue)));
					prst.setString(46, vmystatename);
					prst.setString(47, new gnFinYear().getCurrentFinYear(invdate.getText()));
					double vtaxper = Double.parseDouble(table.getValueAt(k, 12).toString());

					String vvcost = new gnArticle().Article_getData(table.getValueAt(k, 1).toString(), "Cost");
					double vcost = Double.parseDouble(vvcost);
					double vqty = Double.parseDouble(table.getValueAt(k, 3).toString());
					Double vcogs = new gnMath().CalTax_Pur(vcost, vtaxper);
					Double vcostvalue = vcost - vcogs;
					vcostvalue = vqty * vcostvalue;
					prst.setString(48, Double.toString(vcostvalue));
					prst.setString(49, table.getValueAt(k, 16).toString()); // FreeARticleQty
					prst.setString(50, table.getValueAt(k, 7).toString()); // Manul

					// Resto
					prst.setString(51, table.getValueAt(k, 17).toString()); // orderType
					prst.setString(52, table.getValueAt(k, 18).toString()); // TableNo
					prst.setString(53, table.getValueAt(k, 19).toString()); // KOT
					prst.setString(54, table.getValueAt(k, 13).toString()); // Tasste
					prst.setString(55, orderno.getText()); // orderno
					prst.setString(56, invdate.getText()); // orderdate
					// End REsto && KOT

					prst.addBatch();
					// new General().msg("prst:"+ prst);
					TotalRecordinsert = TotalRecordinsert + 1;
					vvggross = vvggross + Double.parseDouble(table.getValueAt(k, 6).toString());
					vvdisc = vvdisc + (Double.parseDouble(table.getValueAt(k, 7).toString())
							+ Double.parseDouble(table.getValueAt(k, 8).toString()));
					TotalRecordinsert = TotalRecordinsert + 1;
					String status = "Sucess";
					if (++TotalRecordinsert % batchSize == 0) {
						prst.executeBatch();
						con1.commit();
						status = "Sucess";
					}
					prst.executeBatch(); // insert remaining records
					con1.commit();
					DBdetail = "Sucess";
 				}
			} catch (SQLException e) {
				new General().msg(e.getLocalizedMessage());
				con1.rollback();
				DBdetail = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
				}
				if (DBdetail == "Sucess") {
					new gnLogger().loggerDebugEntry("POS",
							"HOLD ORDER  ===>>." + " " + "Save Sucessfully " + "InvNo:" + "" + vvinvno);
					new General().Quickmsg("Order is On Hold Now & Printing KOT");
					printkot();
					comboOrderType.grabFocus();
					if (promoModuleActivated == "Y") {
					}
				}
			}
		}
		return DBdetail;
	}

	private void checkTableishold() throws ClassNotFoundException, SQLException {
		String vtablenoavailable = "Fail";
		String SQL = "Select distinct(Tableno)  from tmp_pos_sales_detail_resto where company_code = " + vcomp + " "
				+ "and site_code = " + vstore + " ";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vtablenoavailable = "Sucess";
			showTableHoldData();
			lblmsg.setText("Order List See Below Table Press (Enter) on Order For Final Billing");
		}
	}

	private void showTableHoldData() throws ClassNotFoundException, SQLException {

		// promojsp.removeAll();
		// promotable.removeAll();
		new gnTable().RemoveTableRows(promomodel);
		String col[] = { "Type", "OrderType", "KOT", "TableNo", "OrderNo", "Items", "Amount", "Mobile", "Customer",
				"StartOn", "Now" };
		String vtype = "Order";
		String vordertype = "TABLE";
		promomodel.setColumnIdentifiers(col);
		String SQL = "select   a.OrderType , a.KOT, a.TableNo , a.orderno,  count(a.TableNo) , "
				+ " sum(a.net_amount) , b.mobile, b.name , " + " Min(batch_no) , time(sysdate()) "
				+ " from  tmp_pos_sales_detail_resto a, ms_customer_master b" + " where a.company_code = " + vcomp
				+ " and a.site_code = " + vstore + " " + " and  ordertype = '" + vordertype + "'  "
				+ " and a.customer_code  = b.code and a.company_code = b.company_code "
				+ " Group by a.company_code, a.site_code ,  a.OrderType , a.tableno  ";

		String SQL1 = "select   a.OrderType , a.KOT, a.TableNo , a.orderno,  count(a.TableNo) , "
				+ " sum(a.net_amount) , b.mobile , b.name , " + " Min(batch_no) , time(sysdate()) "
				+ " from  tmp_pos_sales_detail_resto a, ms_customer_master b" + " where a.company_code = " + vcomp
				+ " and a.site_code = " + vstore + " " + " and    " + " ordertype <> '" + vordertype + "' "
				+ " and a.customer_code  = b.code and a.company_code = b.company_code "
				+ " Group by a.company_code, a.site_code ,  a.OrderType , a.orderno , b.mobile  ";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			promomodel.insertRow(0,
					new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10) });
		}
		rs1 = this.getSPResult(SQL1);
		while (rs1.next()) {
			promomodel.insertRow(0,
					new Object[] { vtype, rs1.getString(1), rs1.getString(2), rs1.getString(3), rs1.getString(4),
							rs1.getString(5), rs1.getString(6), rs1.getString(7), rs1.getString(8), rs1.getString(9),
							rs1.getString(10) });
		}
		promotable.setModel(promomodel);
		promotable.requestFocus();
		new gnTable().setTableColWidth(promotable, 1, 150);
		new gnTable().setTableColWidth(promotable, 2, 150);
		promotable.setBackground(Color.black);
		promotable.setForeground(Color.WHITE);
		promotable.setSelectionForeground(Color.white);
		promotable.setEditingRow(0);
		promotable.setEditingColumn(1);
		JViewport prt11011 = new JViewport();
		prt11011.setBackground(new Color(51, 255, 255));
		prt11011.add(promotable);
		prt11011.setVisible(true);
		promojsp.setViewport(prt11011);
		new gnTable().setFontBold(promotable, 14);
		SelectTAblerow();
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void SelectTAblerow() {
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		promotable.grabFocus();
		promotable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		promotable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String col[] = { "Type", "Order Type", "KOT", "TableNo", "Items", "Amount", "Mobile", "Customer",
						"StartOn", "Now" };

				int row = promotable.getSelectedRow();
				String vordertype = promotable.getValueAt(row, 1).toString();
				String vkotno = promotable.getValueAt(row, 2).toString();
				String vtableno = promotable.getValueAt(row, 3).toString();
				String vorderno = promotable.getValueAt(row, 4).toString();
				int vitemcount = Integer.parseInt(promotable.getValueAt(row, 5).toString());
				String vmobile = (promotable.getValueAt(row, 7).toString());
				try {
					showHoldBill(vordertype, vkotno, vtableno, vitemcount, vmobile, vorderno);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				new gnLogger().loggerInfoEntry("OrderSelect",
						"Final Bill For Payment ->" + vordertype + "->" + vkotno + "->" + vtableno);
			}
		});
		scanItem_2.grabFocus();

	}

	private void showHoldBill(String vordertype, String vkotno, String vtableno, int vitemcount, String vmobile,
			String vorderno) throws ClassNotFoundException, SQLException {
		int row = table.getRowCount();

		if (row > 0) {
			new General().msg("Complete Order First .. ");
			return;
		}

		if (row == 0) {
			String SQL = "";
			String Col[] = { "X", "Item", "Name", "Qty", "Rate", "MRP", "Gross", "Disc Item", "Bill Disc", "Disc",
					"Tax", "Amount", "Tax%", "Taste", "BatchNo", "ExpDate", "Free(Qty)/Disc", "Order", "Table", "KOT" };
			model.setColumnIdentifiers(Col);
			if (vordertype.equals("TABLE")) {
				SQL = "select a.Article_code , b.name , a.qty , a.Sales_price , a.mrp , a.Gross_Amount , "
						+ "0,   a.Hdr_disc , a.disc, a.Tax_amount, a.Net_Amount , a.Taxcode , a.taste, "
						+ " a.Batch_no , 0 as Expiry_date , a.FreeArticle_Disc , a.OrderType , a.TableNo , a.KOT , a.customer_code  "
						+ " from  tmp_pos_sales_detail_resto  a , msArticle_master b  " + " where a.Company_code = "
						+ vcomp + "  " + " and a.Site_code = " + vstore + "  "
						+ " and a.company_code  = b.company_code " + " and a.tableno =  " + vtableno
						+ "   and ordertype = '" + vordertype + "'  " + " and a.article_code = b.Article_code ";
			}
			if (!vordertype.equals("TABLE")) {
				SQL = "select a.Article_code , b.name , a.qty , a.Sales_price , a.mrp , a.Gross_Amount , "
						+ "0,   a.Hdr_disc , a.disc, a.Tax_amount, a.Net_Amount , a.Taxcode , a.Taste, "
						+ " a.Batch_no , 0 as Expiry_date , a.FreeArticle_Disc , a.OrderType , a.TableNo , a.KOT , a.customer_code  "
						+ " from  tmp_pos_sales_detail_resto  a , msArticle_master b  " + " where a.Company_code = "
						+ vcomp + "  " + " and a.Site_code = " + vstore + "  "
						+ " and a.company_code  = b.company_code " + " and   orderno = '" + vorderno
						+ "'  and ordertype = '" + vordertype + "'  " + " and a.article_code = b.Article_code     ";
			}
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				custid.setText(rs.getString(20));
				model.insertRow(0,
						new Object[] { new Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
								rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
								rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
								rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
								rs.getString(18), rs.getString(19) });

			}
			table.setModel(model);
			jsp.setWheelScrollingEnabled(true);
			JViewport prt = new JViewport();
			prt.setBackground(new Color(51, 255, 255));
			prt.add(table, Col);
			prt.setBackground(Color.WHITE);
			prt.setVisible(true);
			jsp.setViewport(prt);
			jsp.setVisible(true);
			jsp.setAutoscrolls(true);
			SelectrowforEdit();
			new gnTable().setTableBasics(table);
			selectedrow = table.getRowCount() - 1;
			new gnTable().setTablewidth(table, 2, 300);
			Double itemtotal = new gnTable().getTotal(table, 10);
			Tamount.setText(Double.toString(itemtotal));
			scanItem_2.grabFocus();
			calHdrDisocunt();
			removeRow(model, table);
			int vcount = table.getRowCount();
			records.setText(Integer.toString(vcount));
			table.getColumnModel().getColumn(2).setPreferredWidth(300);
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

			row = table.getRowCount();
			if (row == vitemcount) {
				new gnTable().RemoveTableRows(promomodel);
				removeTableInbfo(vordertype, vkotno, vtableno, vmobile, vorderno);
				printDirectKot = "N";
				comboOrderType.setSelectedItem(vordertype);
				comboTable.setSelectedItem(vtableno);
				nordertype.setBackground(Color.GREEN);
				ntableno.setBackground(Color.GREEN);
				nordertype.setFont(new Font("Tahoma", Font.BOLD, 10));
				ntableno.setText(vtableno);
				nordertype.setText(vordertype);
				nordertype.setEditable(false);
				ntableno.setEditable(false);
				orderno.setText(vorderno);
				comboTable.setEnabled(false);
				orderno.setEnabled(false);
				btnHold.setEnabled(true);
				comboOrderType.setEnabled(false);
				tokenno.setBackground(Color.GREEN);
				tokenno.setForeground(Color.BLUE);
				orderAdding = "Y";
				dipslayCustInfo();
			} else {
				table.setBackground(Color.RED);
				table.setForeground(Color.WHITE);
				new General().msg("Item Count Mismatch ..In Order Total Items Are" + vitemcount
						+ " and Dispaly items Are" + "" + row);
			}
		}
	}

	private void removeTableInbfo(String vordertype, String vkotno, String vtableno, String vmobile, String vorderno)
			throws SQLException {

		String SQL = "";
		if (vordertype.equals("TABLE")) {
			SQL = "Delete from tmp_pos_sales_detail_resto " + " where company_code = " + vcomp + " "
					+ "and site_code = " + vstore + "  and Tableno = " + vtableno + " " + " and  orderType = '"
					+ vordertype + "'    ";
			this.getResult(SQL);
		}

		if (!vordertype.equals("TABLE")) {
			SQL = "Delete from tmp_pos_sales_detail_resto " + " where company_code = " + vcomp + " "
					+ "and site_code = " + vstore + "  and Tableno = " + vtableno + " " + " and  orderType = '"
					+ vordertype + "'  and orderno = '" + vorderno + "'   ";
			this.getResult(SQL);
		}

	}

	private String getKotNo() {
		String vkotno = "";
		try {
			vkotno = new gnSeq().getSeqno("52", "TR");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return vkotno;
	}

	private void updateKotNo() {
		String vkotno = "";
		try {
			new gnSeq().updateSeqno("52", "TR");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private String validatetoken() {
		String status = "Sucess";

		String vtableno = comboTable.getSelectedItem().toString();
		String vordertype = comboOrderType.getSelectedItem().toString().trim();
		String vorderno = orderno.getText();

		status = checkOrderType();

		if (vorderno.equals("0") & vordertype.equals("COUNTER")) {
			new General().msg("Please Enter Order Number   ... ");
			status = "Fail";
			orderno.grabFocus();
		}

		if (vordertype.equals("HOME DELIVERY") & custid.getText().length() == 0) {
			new General().msg("Please Select Customer OR Create Customer ... ");
			custname.grabFocus();
			status = "Fail";
		}

		if (vorderno.equals("0") & vordertype.equals("HOME DELIVERY")) {
			new General().msg("Please Enter Order Number   ... ");
			status = "Fail";
			orderno.grabFocus();
		}

		if (vorderno.equals("0") & vordertype.equals("ZOMATO")) {
			new General().msg("Please Enter Order Number   ... ");
			status = "Fail";
			orderno.grabFocus();
		}

		if (vorderno.equals("0") & vordertype.equals("SWIGGY")) {
			new General().msg("Please Enter Order Number   ... ");
			status = "Fail";
			orderno.grabFocus();
		}

		if (vtableno.length() == 0 & vordertype.equals("TABLE")) {
			new General().msg("Please Select Table Number ... ");
			status = "Fail";
		}

		if (tokenno.getText().length() <= 0) {
			tokenno.grabFocus();
		}

		return status;
	}

	private String checkOrderType() {
		String vstatus = "Sucess";
		String vordertype = comboOrderType.getSelectedItem().toString().trim();

		switch (vordertype) {

		case "HOME DELIVERY":
			if (vordertype.equals("HOME DELIVERY") & custid.getText().length() == 0) {
				new General().msg("Please Select Customer    ... ");
				vstatus = "Fail";
				// custname.grabFocus();
			}
			break;

		case "N/A":
			new General().Quickmsg("Please Select Order Type N/A -is Not Order Type");
			vstatus = "Fail";
			nordertype.grabFocus();
			break;

		case "TABLE":
			if (comboTable.getSelectedItem().toString().trim().equals("0") & vordertype.equals("TABLE")) {
				new General().msg("Please Select Table   ... ");
				vstatus = "Fail";
				ntableno.grabFocus();
			}
			break;

		case "SWIGGY":
			if (orderno.getText().length() == 0 || orderno.getText().equals("0")) {
				new General().msg("Please Enter Order Number");
				orderno.grabFocus();
				vstatus = "Fail";
			}
			break;

		case "COUNTER":
			if (mobile.getText().length() == 0 || orderno.getText().equals("0")) {
				new General().Quickmsg("Please Select Customer");
				// custname.grabFocus();
				// custid.setText("0");
				vstatus = "Sucess";
			}
			break;

		case "ZOMATO":
			if (orderno.getText().length() == 0 || orderno.getText().equals("0")) {
				new General().msg("Please Enter Order Number");
				orderno.grabFocus();
				vstatus = "Fail";
			}
			break;
		}
		return vstatus;
	}

	public String pickDataForHoldOver() throws Throwable {

		String status = "Sucess";
		vvsitecode = vstore;
		vvcompnaycode = vcomp;
		vterminal = Integer.parseInt(terminalID.getText());
		Svinvdate = new gnConfig().date_ConverttoDBforamt(invdate.getText());
		vvcashiercode = cashiercode.getText();
		vvsales_type = "PS";
		vverticle = new gnHierarchy().getVerticleCode();
		vvinvoice_type = "RI";
		vvposting_type = "Y";

		if (custid.getText().length() > 0) {
			vvcustid = Integer.parseInt(custid.getText());
		}

		if (custid.getText().length() == 0) {
			vvcustid = 0;
		}

		vshift = Integer.parseInt(shift.getText());
		vvggross = 0.00;
		vvdisc = 0.00;
		vvnet = 0.00;
		// this.closeconn();

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
		vmycompanystate = vmycompanystate.trim();
		int vmy = Integer.parseInt(vmycompanystate);
		if ((vmy - voth == 0)) {
			vmovtype = "Intra-State";
		}
		if ((vmy - voth != 0)) {
			vmovtype = "Inter-State";
		}
		switch (invoiceMode) {
		case "I":
			new gnLogger().loggerInfoEntry("POS", "New Bill no Generated For Sales ..." + " " + invno.getText());
			break;
		case "E":
			vglcode = new gnSeq().getGlcode("5", "TR");
			break;
		}
		vvinvno = Integer.parseInt(invno.getText());
		switch (invoiceMode) {
		case "I":
			// status = insertPosDetailsForPromoExecution();
			break;
		case "E":
			// new gnLogger().loggerInfoEntry("POS", "POS Edit Bill :" +
			// invno.getText() + "Start Inserting");
			String vinvtype = "PS";
			// new gnEDMiddleWare().SalesModification(vinvtype, invno.getText(),
			// invdate.getText());
			// status = insertPosDetailsForPromoExecution();
			// new gnLogger().loggerInfoEntry("POS", "POS Edit Bill Completer
			// for invno:" + invno.getText());
			break;
		}
		return status;
	}

	private String checkKOTForWOHoldBillType() {
		String generateKOT = "Y";
		int row = table.getRowCount();
		int vkotno = Integer.parseInt(table.getValueAt(0, 19).toString());
		if (vkotno > 0) {
			generateKOT = "N";
		} else {
			generateKOT = "Y";
			generateAndAssignKOT();
		}
		return generateKOT;
	}

	private void generateAndAssignKOT() {
		tokenno.setText(getKotNo()); // replaed from to to scan level to here
		updateKotNo();
		int row = table.getRowCount();
		for (int k = 0; k < row; k++) {
			int vkotno = Integer.parseInt(table.getValueAt(k, 19).toString());

			if (vkotno == 0) {
				table.setValueAt(tokenno.getText(), k, 19);
			}

			if (vkotno > 0) {
				// table.setValueAt(tokenno.getText(), k, 19);
			}

		}
		// new General().Quickmsg("KOT Number Generated For Non Hold Bill...");
	}

	class keyPressedlsnr implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int value = e.getKeyCode();
			switch (value) {
			case 10:

				if (mergetable2.isFocusOwner()) {
					mergetable3.grabFocus();
				}

				if (mergetable3.isFocusOwner()) {
					mergetable1.grabFocus();
				}

				if (mergetable1.isFocusOwner()) {
					btnMerge.grabFocus();
				}

				if (btnMerge.isFocusOwner()) {
					try {
						mergeTableAction();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} finally {
						new General().msgDispose();
					}
				}

				if (custid.isFocusOwner()) {
					custname.grabFocus();
				}

				if (custname.isFocusOwner()) {
					mobile.grabFocus();
				}

				if (mobile.isFocusOwner()) {
					hm_addr1.grabFocus();
				}

				if (hm_addr1.isFocusOwner()) {
					hm_addr2.grabFocus();
				}

				if (hm_addr2.isFocusOwner()) {
					btnNewButton.grabFocus();
				}

				if (editqty.isFocusOwner()) {
					edittaste.grabFocus();
				}

				if (edittaste.isFocusOwner()) {
					editrate.grabFocus();
				}

				if (editrate.isFocusOwner()) {
					editdisc.grabFocus();
				}

				if (editdisc.isFocusOwner()) {
					editEnd.grabFocus();
				}

				if (btn_Payment.isFocusOwner()) {
					btn_Payment.doClick();
				}

				if (btn_Save.isFocusOwner()) {
					btn_Save.doClick();
				}

				if (btnHold.isFocusOwner()) {
					btnHold.doClick();
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

			if (btnMerge.isFocusOwner()) {
				btnMerge.setBackground(Color.yellow);
				btnMerge.setForeground(Color.BLACK);
				new gnFontSetting().setMyFontBold(btn_Payment, "F1", 14);
			}

			if (btnNewButton.isFocusOwner()) {

				btnNewButton.setBackground(Color.black);
				btnNewButton.setBackground(Color.white);
			}

			if (comboTable.isFocusOwner()) {
				comboTable.setPopupVisible(true);
			}

			if (comboOrderType.isFocusOwner()) {
				comboOrderType.setPopupVisible(true);
			}

			if (btn_Payment.isFocusOwner()) {
				btn_Payment.setBackground(Color.yellow);
				btn_Payment.setForeground(Color.BLACK);
				new gnFontSetting().setMyFontBold(btn_Payment, "F1", 14);
			}

			if (btnHold.isFocusOwner()) {
				btnHold.setBackground(Color.yellow);
				btnHold.setForeground(Color.BLACK);
				new gnFontSetting().setMyFontBold(btnHold, "F1", 14);
			}

			if (btn_Save.isFocusOwner()) {
				btn_Save.setBackground(Color.yellow);
				btn_Save.setForeground(Color.BLACK);
				new gnFontSetting().setMyFontBold(btn_Save, "F1", 14);
			}

		}

		@Override
		public void focusLost(FocusEvent e) {
			setStyleofmybuttons();
			// setButtonStyle();
		}
	}

	private void setStyleofmybuttons() {
		// In Single command Though automation
		int typeno = 1;
		new gnDecorate().SetSeqHdrButton(btn_Payment, typeno);
		new gnDecorate().SetSeqHdrButton(btn_Save, typeno);
		new gnDecorate().SetSeqHdrButton(btnHold, typeno);
	}

	private void displayList() throws ClassNotFoundException, SQLException {

		int row = promotable.getSelectedRow();
		String vordertype = promotable.getValueAt(row, 1).toString().trim();
		String vkotno = promotable.getValueAt(row, 2).toString().trim();
		String vtableno = promotable.getValueAt(row, 3).toString().trim();
		String vorderno = promotable.getValueAt(row, 4).toString().trim();
		String vmobile = promotable.getValueAt(row, 7).toString().trim();

		String[] Col = { "Type", "OrderType", "Table", "KOT", "Article", "Name", "Qty", "Rate", "Amount", "Mobile",
				"OrderTime", "Now" };
		String SQL = "";
		if (vordertype.equals("TABLE")) {
			// Kalyani
			SQL = "select  a.OrderType , a.TableNo , a.KOT , a.Article_code , b.name , a.qty , a.Sales_price,"
					+ " a.Net_Amount , a.EAN  , batch_no , time(sysdate()) "
					+ " from  tmp_pos_sales_detail_resto  a , msArticle_master b  " + " where a.Company_code = " + vcomp
					+ "  " + " and a.Site_code = " + vstore + "  " + " and a.company_code  = b.company_code "
					+ " and a.tableno =  " + vtableno + "   and ordertype = '" + vordertype + "'  "
					+ " and a.article_code = b.Article_code    ";
		}

		if (!vordertype.equals("TABLE")) {
			SQL = "select   a.OrderType , a.TableNo , a.KOT , a.Article_code , b.name , a.qty , a.Sales_price,"
					+ " a.Net_Amount , a.EAN, a.batch_no , time(sysdate())"
					+ " from  tmp_pos_sales_detail_resto  a , msArticle_master b  " + " where a.Company_code = " + vcomp
					+ "  " + " and a.Site_code = " + vstore + "  " + " and a.company_code  = b.company_code "
					+ "  and  EAN = " + vmobile + "    and  orderno = " + vorderno + "    and ordertype = '"
					+ vordertype + "'  " + " and a.article_code = b.Article_code     ";
		}

		new gnTable().RemoveTableRows(smodel);
		String vtype = "View Order List";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, Col, 11, "N", "Y", vtype);

		if (vordertype.equals("TABLE")) {
			new gnTable().setTableColWidth(stable, 5, 150);
			stable.setBackground(Color.BLACK);
			stable.setForeground(Color.green);
		}

		if (!vordertype.equals("TABLE")) {
			new gnTable().setTableColWidth(stable, 5, 150);
			stable.setBackground(Color.GREEN);
			stable.setForeground(Color.BLACK);
		}

		String vmsg = "View Data For Order Type" + " " + vordertype + " and Mobile Number " + vmobile;
		new General().msgsearch(sjsp, stable, vmsg, 1200, 400);

	}

	private void printkot() throws Throwable {

		String vordertype = comboOrderType.getSelectedItem().toString().trim();
		String vmobile = mobile.getText();
		String vtableno = comboTable.getSelectedItem().toString().trim();
		String vorderno = orderno.getText();
		String vorderdate = invdate.getText();
		new gnDocPrint().printKOT(vordertype, vtableno, vmobile, vorderno, vorderdate);
	}

	class tasteLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			table.setValueAt(taste.getText(), 0, 13);
		}
	}

	private void getPricePolicy() throws Throwable {

		String vpara900 = "900";
		String vpara901 = "901";
		String vpara902 = "902";
		String vpara903 = "903";
		String vpara904 = "904";
		String vpara905 = "905";
		String vpara906 = "906";

		vapplydiffPrice = new getConfigurationSetting().getSpecificConfiguration(vpara900);
		vaddSub = new getConfigurationSetting().getSpecificConfiguration(vpara906);
		vwalkinprice = new getConfigurationSetting().getSpecificConfiguration(vpara901);
		vswiggyprice = new getConfigurationSetting().getSpecificConfiguration(vpara902);
		vzomatoprice = new getConfigurationSetting().getSpecificConfiguration(vpara903);
		vcounterprice = new getConfigurationSetting().getSpecificConfiguration(vpara904);
		vtelephoneprice = new getConfigurationSetting().getSpecificConfiguration(vpara905);

		new General().msg("Apply Diff Prices   " + " " + vapplydiffPrice);
		// new General().msg("before Apply base price for counter " + "
		// "+vapplyBasePriceForCounter);

		// "N/A", "WALKIN", "COUNTER", "SWIGGY", "ZOMATO" }));
		vapplyBasePriceFor = "N";
		vapplyBasePriceForCounter = "N";
		vapplyBasePriceForWalkin = "N";
		vapplyBasePriceForSwiggy = "N";
		vapplyBasePriceForZomato = "N";
		vapplyBasePriceForTelephone = "N";

		switch (vtelephoneprice.toUpperCase()) {
		case "BASE":
			vapplyBasePriceFor = "HOME DELIVERY";
			vapplyBasePriceForTelephone = "Y";
			break;
		default:
			updateOtherPrice(vtelephoneprice, vaddSub, vapplyBasePriceFor);
			break;
		}

		switch (vzomatoprice.toUpperCase()) {
		case "BASE":
			vapplyBasePriceFor = "ZOMATO";
			vapplyBasePriceForZomato = "Y";
			break;
		default:
			updateOtherPrice(vzomatoprice, vaddSub, vapplyBasePriceFor);
			break;
		}

		switch (vswiggyprice.toUpperCase()) {
		case "BASE":
			vapplyBasePriceForSwiggy = "Y";
			vapplyBasePriceFor = "SWIGGY";
			break;
		default:
			updateOtherPrice(vswiggyprice, vaddSub, vapplyBasePriceFor);
			break;
		}

		switch (vwalkinprice.toUpperCase()) {
		case "BASE":
			vapplyBasePriceForWalkin = "Y";
			vapplyBasePriceFor = "WALKIN";
			break;

		default:
			updateOtherPrice(vwalkinprice, vaddSub, vapplyBasePriceFor);
			break;
		}

		switch (vcounterprice.toUpperCase()) {
		case "BASE":
			vapplyBasePriceForCounter = "Y";
			vapplyBasePriceFor = "COUNTER";
			break;

		default:
			updateOtherPrice(vcounterprice, vaddSub, vapplyBasePriceFor);
			break;

		}

		// new General().msg("Apply base price for counter " + "
		// "+vapplyBasePriceForCounter);
	}

	private void updateOtherPrice(String vprice, String vaddsub, String xvapplyBasePriceFor) throws Throwable {
		// new General().Quickmsg(xvapplyBasePriceFor);

		try {
			vcomp = new gnConfig().getCompanyCode();
			String SQL = "";
			String vverticle = new gnHierarchy().getVerticleCode();
			switch (vaddsub.trim().toUpperCase()) {
			case "ADD":
				SQL = "update msARticle_master set othersp = SalesPrice + '" + vprice + "' where company_code = '"
						+ vcomp + "' " + " and verticle = '" + vverticle + "' ";
				this.getResult(SQL);
				break;

			case "SUB":
				SQL = "update msARticle_master set othersp = SalesPrice - '" + vprice + "' where company_code = '"
						+ vcomp + "' " + " and verticle = '" + vverticle + "' ";
				this.getResult(SQL);
				break;
			}

			// SQL = "update msARticle_master set othersp = SalesPrice - 20
			// where company_code = '"+vcomp+"' "
			// + " and verticle = '"+vverticle+"' " ;
			// this.getResult(SQL);
			// new General().msg(SQL);

		} catch (Exception e) {
			new General().msg(e.getLocalizedMessage());
			new gnLogger().loggerInfoEntry("Priceupdateother", e.getLocalizedMessage());
		}

	}

	/// New for TextField

	class norderLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vinput = nordertype.getText();

			if (vinput.length() == 0) {
				nordertype.grabFocus();
				return;
			}

			if (vinput.length() > 0) {
				switch (vinput.toUpperCase()) {
				case "T":
					comboOrderType.setSelectedItem("TABLE");
					comboOrderType.setEnabled(false);
					ntableno.grabFocus();
					ntableno.setText(null);
					orderno.setVisible(false);
					orderno.setText("0");
					orderLsnr();
					ntableno.grabFocus();
					break;

				case "AC":
					comboOrderType.setSelectedItem("AC");
					comboOrderType.setEnabled(false);
					ntableno.grabFocus();
					ntableno.setText(null);
					orderno.setVisible(false);
					orderno.setText("0");
					orderLsnr();
					ntableno.grabFocus();
					break;

					
				case "H":
					comboOrderType.setSelectedItem("HOME DELIVERY");
					comboOrderType.setEnabled(false);
					orderLsnr();
					ntableno.setText("0");
					ntable.setVisible(false);
					break;

				case "C":
					comboOrderType.setSelectedItem("COUNTER");
					comboOrderType.setEnabled(false);
					orderLsnr();
					ntableno.setText("0");
					ntable.setVisible(false);
					break;

				case "Z":
					comboOrderType.setSelectedItem("ZOMATO");
					comboOrderType.setEnabled(false);
					orderno.setText("0");
					orderLsnr();
					ntableno.setText("0");
					ntable.setVisible(false);
					orderno.grabFocus();
					break;

				case "S":
					comboOrderType.setSelectedItem("SWIGGY");
					comboOrderType.setEnabled(false);
					orderLsnr();
					ntableno.setText("0");
					ntable.setVisible(false);
					orderno.grabFocus();
					break;
				}
			}
		}
	}

	///

	
	private void orderLsnr() {
		String vorderType = comboOrderType.getSelectedItem().toString().trim().toUpperCase();
		// "WalkIn", "Counter ", "Swiggy", "Zometo" }));

		// custid.setText("0");
		custname.setText(null);
		mobile.setText(null);
		hm_addr1.setText(null);
		hm_addr2.setText(null);
		custid.setText("0");

		switch (vorderType) {
		case "N/A":
			lblmsg.setText("Please Select Order Type N/A Not Allow .. ");
			btnHold.setEnabled(true);
			new gnTable().RemoveTableRows(promomodel);
			btnNewButton.setEnabled(true);
			break;

		case "TABLE":
			btnHold.setEnabled(true);
			comboTable.setEnabled(false);
			comboTable.setVisible(true);
			lblmsg.setText("Please Select Correct Table For Table Customer..");
			tokenno.setBackground(Color.white);
			tokenno.setForeground(Color.BLACK);
			orderno.setVisible(false);
			orderno.setText("0");
			mobile.setText("0");
			lblmsg.setText("New Bill For Walkin Customer Please Select Table Number.. ");
			btnNewButton.setEnabled(true);
			ntableno.grabFocus();
			break;

		case "HOME DELIVERY":
			btnHold.setEnabled(true);
			// comboTable.setSelectedItem("0");
			mobile.setText("0");
			comboTable.setSelectedItem("0");
			comboTable.setEnabled(false);
			comboTable.setVisible(false);
			lblmsg.setText("Please Select Or Create  Customer..");
			tokenno.setBackground(Color.white);
			tokenno.setForeground(Color.BLACK);
			orderno.setVisible(true);
			orderno.setText(getKotNo()); // replaed from to to scan level to
			btnHold.setEnabled(true);
			lblmsg.setText("New Bill For HOME Delivery Please Select Customer.. ");
			btnNewButton.setEnabled(true);
			scanItem_2.grabFocus();
			break;

		case "COUNTER":
			custname.setEnabled(true);
			comboTable.setVisible(false);
			comboTable.setEnabled(false);
			comboTable.setSelectedItem("0");
			orderno.setVisible(true);
			orderno.setEditable(false);
			orderno.setText(getKotNo()); // replaed from to to scan level to
			btnHold.setEnabled(true);
			lblmsg.setText("New Bill For Counter Customer <<Please Select/Create Customer >> .. ");
			btnNewButton.setEnabled(true);
			mobile.setText("0");
			// custname.grabFocus();
			scanItem_2.grabFocus();
			break;

		case "SWIGGY":
			custname.setEnabled(true);
			comboTable.setSelectedItem("0");
			comboTable.setEnabled(false);
			comboTable.setVisible(false);
			orderno.setEditable(true);
			orderno.setEnabled(true);
			orderno.setVisible(true);
			orderno.setText("0");
			mobile.setText("0");
			orderno.grabFocus();
			btnHold.setEnabled(true);
			lblmsg.setText("New Bill For SWIGGY Customer <<Please Select/Create Customer >>");
			btnNewButton.setEnabled(true);
			break;

		case "ZOMATO":
			comboTable.setSelectedItem("0");
			comboTable.setEnabled(false);
			comboTable.setVisible(false);
			custname.setEnabled(true);
			orderno.setEditable(true);
			orderno.setEnabled(true);
			orderno.setVisible(true);
			mobile.setText("0");
			orderno.setText("0");
			orderno.grabFocus();
			btnHold.setEnabled(true);
			lblmsg.setText("New Bill For ZOMATO Customer <<Please Select/Create Customer >>");
			btnNewButton.setEnabled(true);
			break;
		}
	}

	class nordernoLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vinput = orderno.getText();

			if (vinput.length() == 0) {
				orderno.grabFocus();
				orderno.setText(null);
				return;
			}

			if (vinput.length() > 0) {
				orderNoLsnr();
			}

		}
	}

	private void orderNoLsnr() {

		// "WalkIn", "Counter ", "Swiggy", "Zometo" }));
		String vorderno = orderno.getText();
		String vordertype = comboOrderType.getSelectedItem().toString().trim();
		switch (vordertype) {
		case "ZOMATO":
			if (vorderno.length() == 0 || orderno.getText().equals("0")) {
				new General().msg("Please Enter Order Number..");
				orderno.grabFocus();
				return;
			}
			break;

		case "SWIGGY":
			if (vorderno.length() == 0 || orderno.getText().equals("0")) {
				new General().msg("Please Enter Order Number..");
				orderno.grabFocus();
				return;
			}
			break;
		}
		scanItem_2.grabFocus();
	}

	class ntablenoLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vinput = ntableno.getText();
			comboTable.setSelectedItem(ntableno.getText());

			if (vinput.length() == 0) {
				ntableno.grabFocus();
				ntableno.setText(null);
				return;
			}

			if (vinput.length() > 0) {
				comboTable.setSelectedItem(ntableno.getText());
				tableLsnr();
			}
		}
	}

	private void tableLsnr() {
		// "TABLE", "Counter ", "Swiggy", "Zometo" }));

		String vtableno = comboTable.getSelectedItem().toString().trim().toUpperCase();
		int vvtable = Integer.parseInt(vtableno);

		
		if ( vvtable > 0  &  nordertype.getText().trim().toUpperCase() == "AC") {
			 comboOrderType.setSelectedItem("AC");
			 tokenno.setBackground(Color.white);
			 tokenno.setForeground(Color.BLACK);
			 scanItem_2.setEnabled(true);
		}


		if ( vvtable > 0  &  nordertype.getText().trim().toUpperCase() == "T") {
			 comboOrderType.setSelectedItem("TABLE");
			 tokenno.setBackground(Color.white);
			 tokenno.setForeground(Color.BLACK);
			 scanItem_2.setEnabled(true);
		}

		
		switch (vtableno) {
		case "0":
			scanItem_2.grabFocus();
			scanItem_2.setEnabled(true);
			tokenno.setBackground(Color.WHITE);
			tokenno.setForeground(Color.BLUE);
			break;
		}

		if (vvtable > 0) {
			HoldBill = "Y";
			try {
				checkTableishold();
				scanItem_2.grabFocus();
				scanItem_2.setEnabled(true);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		scanItem_2.grabFocus();
		scanItem_2.setEnabled(true);
	}

	private void cancelOrder(int row) throws Throwable {
		// String col[] = { "Type", "OrderType","KOT", "TableNo",
		// "OrderNo" , "Items", "Amount",
		// "Mobile", "Customer", "StartOn", "Now" };

		String vordertype = promotable.getValueAt(row, 1).toString();
		String vkotno = promotable.getValueAt(row, 2).toString();
		String vtableno = promotable.getValueAt(row, 3).toString();
		String vorderno = promotable.getValueAt(row, 4).toString();
		int vitemcount = Integer.parseInt(promotable.getValueAt(row, 5).toString());
		String vmobile = (promotable.getValueAt(row, 7).toString());

		printcancelOrder(vordertype, vkotno, vtableno, vmobile, vorderno);
		removeTableInbfo(vordertype, vkotno, vtableno, vmobile, vorderno);

		// checkTableishold() ;
		showTableHoldData();
		// showTableHoldData();
		comboOrderType.setSelectedItem("N/A");
		comboOrderType.setEnabled(true);
		nordertype.grabFocus();
	}

	private void printcancelOrder(String vordertype, String vkotno, String vtableno, String vmobile, String vorderno)
			throws Throwable {
		// String vordertype =
		// comboOrderType.getSelectedItem().toString().trim();
		// String vmobile = mobile.getText() ;
		// String vtableno = comboTable.getSelectedItem().toString().trim();
		// String vorderno = orderno.getText() ;
		String vorderdate = invdate.getText();
		new gnDocPrint().printCancelKOT(vordertype, vtableno, vmobile, vorderno, vorderdate);
	}

	private void mergeTableAction() throws SQLException {

		String vmergeinto = "";
		String vmergetableno1 = "";
		String vmergetableno2 = "";

		String vstatus = validateMerge();
		String vorderType = "TABLE";
		if (vstatus == "Sucess") {
			vmergeinto = mergetable1.getText();
			vmergetableno1 = mergetable2.getText();
			vmergetableno2 = mergetable3.getText();

			String SQL = "Update tmp_pos_sales_detail_resto set tableno =  " + vmergeinto + "  "
					+ "  where company_code = " + vcomp + " and  site_code = " + vstore + " " + "  and ordertype = '"
					+ vorderType + "' and tableno =  " + vmergetableno1 + " ";

			String SQL1 = "Update tmp_pos_sales_detail_resto set tableno =  " + vmergeinto + " "
					+ "  where company_code = " + vcomp + " and  site_code = " + vstore + " " + "  and ordertype = '"
					+ vorderType + "' and tableno =  " + vmergetableno2 + " ";

			this.getResult(SQL);
			this.getResult(SQL1);

			try {
				showTableHoldData();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				// Hpanel_3.add(mergetablepanel);
				Hpanel_3.remove(mergetablepanel);
			}

		}

	}

	private String validateMerge() {
		String vmergeinto = mergetable1.getText();
		String vmergetableno1 = mergetable2.getText();
		String vmergetableno2 = mergetable3.getText();
		String vstatus = "Sucess";

		int vinttable1 = Integer.parseInt(mergetable1.getText());
		int vinttable2 = Integer.parseInt(mergetable2.getText());
		int vinttable3 = Integer.parseInt(mergetable3.getText());

		if (vinttable1 == vinttable2) {
			new General().msg("Same Table Can not Merge...");
			vstatus = "fail";
		}

		if (vinttable2 == vinttable3) {
			new General().msg("Please check  table needs to be merged...?...");
			vstatus = "fail";
		}

		if (vmergeinto.length() == 0) {
			new General().msg("Table Number Missing (Merge Into Which Table ?) ");
			vstatus = "fail";
		}

		if (vmergetableno1.length() == 0 | mergetable2.getText().equals("0")) {
			new General().msg("Which table needs to be merged please mention ? ...");
			vstatus = "fail";
		}
		return vstatus;
	}

	private void mergePopup() {

		mergetablepanel = new JPanel();
		mergetablepanel.setBackground(Color.WHITE);
		mergetablepanel.setBounds(470, 1, 270, 119);
		Hpanel_3.add(mergetablepanel);
		mergetablepanel.setLayout(null);

		mergetable1 = new JTextField();
		mergetable1.setBounds(182, 47, 69, 31);
		mergetablepanel.add(mergetable1);
		mergetable1.setColumns(10);

		mergetable2 = new JTextField();
		mergetable2.setBounds(69, 30, 56, 22);
		mergetablepanel.add(mergetable2);
		mergetable2.setColumns(10);

		mergetable3 = new JTextField();
		mergetable3.setText("0");
		mergetable3.setBounds(69, 56, 56, 22);
		mergetablepanel.add(mergetable3);
		mergetable3.setColumns(10);

		JLabel lblMaxTable = new JLabel("Max 2 Table Megre Allow");
		lblMaxTable.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblMaxTable.setBounds(0, 0, 265, 16);
		mergetablepanel.add(lblMaxTable);

		JLabel lblNewLabel_23 = new JLabel("Table No");
		lblNewLabel_23.setBounds(185, 33, 66, 16);
		mergetablepanel.add(lblNewLabel_23);

		JLabel lblTableNo_1 = new JLabel("Table No");
		lblTableNo_1.setBounds(10, 33, 66, 16);
		mergetablepanel.add(lblTableNo_1);

		JLabel lblTableNo_2 = new JLabel("Table No");
		lblTableNo_2.setBounds(10, 59, 66, 16);
		mergetablepanel.add(lblTableNo_2);

		btnMerge = new JButton("Merge Table");
		btnMerge.setBounds(0, 94, 265, 25);
		mergetablepanel.add(btnMerge);

		lblNewLabel_24 = new JLabel("Addin");
		lblNewLabel_24.setIcon(null);
		lblNewLabel_24.setBounds(137, 30, 37, 50);
		mergetablepanel.add(lblNewLabel_24);

	}

	private void afterShortcutKeyExecute() throws ClassNotFoundException, SQLException {
		// new General().msg("item Search Callesd ");;
		new gnTable().RemoveTableRows(promomodel);
		scanItem_2.setEnabled(true);
		if (SelectionType == "Article") {
			scanItem_2.setEnabled(true);
		}
		String sname = "123XYZZ";
		;
		sname = "%" + sname + "%";
		String vverticlecode = new gnHierarchy().getVerticleCode();
		String vtype = "Article";
		String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
		String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Pk.Size", "UOM" };
		promomodel.setColumnIdentifiers(ACol);

		rs = this.getSPResult(SQL);
		while (rs.next()) {
			promomodel.addRow(new Object[] { vtype, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6) });
		}

		// promotable = new gnTableModel().ablemodel(promotable, promomodel,
		// SQL, ACol, 6, "N", "Y", vtype);
		promotable.setModel(promomodel);
		promotable.requestFocus();
		new gnTable().setTableColWidth(promotable, 1, 75);
		new gnTable().setTableColWidth(promotable, 2, 300);
		promotable.setBackground(Color.black);
		promotable.setForeground(Color.WHITE);
		promotable.setSelectionForeground(Color.white);
		promotable.setEditingRow(0);
		JViewport prt1101 = new JViewport();
		prt1101.add(promotable);
		prt1101.setVisible(true);
		promojsp.setViewport(prt1101);
		new gnTable().setFontBold(promotable, 14);
		scanItem_2.grabFocus();
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

}// Last

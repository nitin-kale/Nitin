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
import com.mysql.jdbc.Statement;

import RetailProduct.POS3_2.lsnrMobile;

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

public class POS extends getResultSet implements Runnable {

	// promo variables
	double vfreegivenqty = 0.0;
	String xvpromotypecode = "";

	private JScrollPane promojsp;
	private JTextField starttime;
	private JTextField endtime;
	private JTextField custamountPaid;
	JButton btnSavecust;
	private JTextField showqty;
	private String invoiceMode = "I";
	private JLabel lblNewLabel_10;
	private JTextField manualdisc;
	private JLabel lblNewLabel_11;
	private JTextField billhdrdiscper;
	private JTextField fgross;
	private JLabel lblNewLabel_13;
	private JTextField fdisc;
	private JTextField docno;
	private JTextField vsearchname;
	private JLabel lblNewLabel_15;

	String Promohdrdisc = "N";
	String xvmypromoArticle = "";
	double vmyfreeqty;
	double vallocatefreeqty = 0;
	double vbalfreeqty = 0;
	String SelectionType = "Article";
	JPanel panelbillInfotemp;
	String xvfreeQty = "";
	String vlocation;
	JWindow wnd;
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
	private JButton btnBcgrnd1;
	private JTextField scanqty;
	private JTextField rate;
	private JLabel lblNewLabel_5;
	private JTextField disc;
	private JButton btnNewdoctor;

	String vdrugType;
	JTextField patientName;
	//

	String VAccountPostingAmount;
	private Connection con1, con2, con3, con4, con5, con6, con7, con8;
	private String POS = "1";
	private String scannerAvailable = "N";
	private JButton btnDoctor;
	private JButton btnClose;
	String vfgross;
	String vfdisc;
	private String vallowPopWindow = "N";
	public java.sql.PreparedStatement prst = null;
	JButton btnSalesLike;
	JComboBox namecombo = new JComboBox();
	private String vtokenno;
	String vallowday;
	private int vmy;
	private int voth;
	int editrow;
	
	JLabel      editname;
	JLabel      editcode;
	JTextField  editqty;
  	JTextField  editrate;
	JTextField  editdisc;
   	JTextField  editbatchno ;
	JTextField  editexpdate ;

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
	private JPanel pos_hdr1;
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
	DefaultTableModel promomodel = new DefaultTableModel();

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

	private String Col[] = { "X", "Item", "Name", "Qty", "Rate", "MRP", "Gross", "Disc Item", "Bill Disc", "Disc",
			"Tax", "Amount", "Tax%", "Batch(Y/N)", "BatchNo", "ExpDate", "Free(Qty)/Disc" };

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
					return column == 0 || column == 3 || column == 4 || column == 7 || column == 12 || column == 14
							|| column == 15 ? true : false;
				case "N":
					return column == 0 || column == 3 || column == 7 || column == 12 || column == 14 || column == 15
							? true : false;
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
	public JFrame POSFrame;

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
					POS window = new POS();
					window.POSFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	public POS() throws Throwable {
		// this.closeconn();
		// setStandardData();
		// getPOSconfigValues();
		initialize();
		/// this.closeconn();

	}

	private void initialize() throws Throwable {
		POSFrame = new JFrame();
		POSFrame.setResizable(false);
		POSFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		POSFrame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 13));
		POSFrame.getContentPane().setBackground(Color.CYAN);
		POSFrame.getContentPane().setLayout(null);
		POSFrame.setTitle("Business Application - Stand Alone Store Edition");
		POSFrame.setOpacity(1.0f);
		POSFrame.setBackground(Color.DARK_GRAY);
		POSFrame.setAlwaysOnTop(true);
		POSFrame.setBounds(1, 0, 1356, 772);
		POSFrame.getContentPane().setEnabled(true);
		POSFrame.getContentPane().setBackground(Color.CYAN);
		POSFrame.getContentPane().setLayout(null);

		JPanel HeaderPanel = new JPanel();
		HeaderPanel.setBounds(0, 0, 957, 188);
		HeaderPanel.setBackground(Color.WHITE);
		HeaderPanel.setBorder(new LineBorder(new Color(255, 255, 255), 5, true));
		POSFrame.getContentPane().add(HeaderPanel);
		HeaderPanel.setLayout(null);

		JPanel Hpanel_2 = new JPanel();
		Hpanel_2.setForeground(new Color(128, 0, 128));
		Hpanel_2.setBackground(Color.WHITE);
		Hpanel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 51, 51)));
		Hpanel_2.setBounds(126, 0, 266, 136);
		HeaderPanel.add(Hpanel_2);
		Hpanel_2.setLayout(null);

		JLabel lbl_SiteCode = new JLabel("Branch Code");
		lbl_SiteCode.setBackground(new Color(128, 0, 128));
		lbl_SiteCode.setForeground(new Color(204, 255, 204));
		lbl_SiteCode.setBounds(12, 18, 102, 16);
		Hpanel_2.add(lbl_SiteCode);
		lbl_SiteCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_SiteCode.setHorizontalAlignment(SwingConstants.RIGHT);

		// Site_code = new JTextField();
		Site_code = new gnRoundTextField(20);
		Site_code.setForeground(Color.WHITE);
		Site_code.setBackground(Color.BLACK);
		Site_code.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		Site_code.setBounds(131, 11, 123, 28);
		Hpanel_2.add(Site_code);
		Site_code.setEditable(false);
		Site_code.setColumns(10);

		// invdate = new JTextField();
		invdate = new gnRoundTextField(20);
		invdate.setForeground(Color.WHITE);
		invdate.setBackground(Color.BLACK);
		invdate.setEditable(false);
		invdate.setBounds(131, 42, 123, 28);
		Hpanel_2.add(invdate);
		invdate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		invdate.setColumns(10);

		// invno = new JTextField();
		invno = new gnRoundTextField(20);
		invno.setText("0");
		invno.setForeground(Color.WHITE);
		invno.setBackground(Color.BLACK);
		invno.setBounds(131, 70, 123, 28);
		Hpanel_2.add(invno);
		invno.setEditable(false);
		invno.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		invno.setColumns(10);

		JLabel lblInvoiceNumber = new JLabel("Invoice Number");
		lblInvoiceNumber.setForeground(new Color(204, 255, 204));
		lblInvoiceNumber.setBounds(0, 76, 123, 16);
		Hpanel_2.add(lblInvoiceNumber);
		lblInvoiceNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInvoiceNumber.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblInvoiceDate = new JLabel("Invoice Date");
		lblInvoiceDate.setForeground(new Color(204, 255, 204));
		lblInvoiceDate.setBounds(12, 46, 107, 16);
		Hpanel_2.add(lblInvoiceDate);
		lblInvoiceDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInvoiceDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		String vsalesType = "Sales_Type";

		String vverticle = new gnHierarchy().getVerticleCode();
		String vsearch = "%%";
		String SQL11 = " call   master_getmasterData('" + vsalesType + "' , " + vverticle + ",  '" + vsearch + "')";

		Hpanel_3 = new gnRoundPanel();
		Hpanel_3.setForeground(new Color(255, 255, 204));
		Hpanel_3.setBackground(Color.WHITE);
		Hpanel_3.setBorder(null);
		Hpanel_3.setBounds(393, 0, 564, 107);
		HeaderPanel.add(Hpanel_3);
		Hpanel_3.setLayout(null);

		custname = new JTextField();
		custname.setBackground(Color.WHITE);
		custname.setText("Default");
		custname.setFont(new Font("Segoe UI", Font.BOLD, 11));
		custname.setForeground(Color.DARK_GRAY);
		custname.setBounds(78, 31, 262, 27);
		Hpanel_3.add(custname);
		custname.setColumns(10);
		ActionListener custname1 = new lsnrCustName();
		custname.addActionListener(custname1);

		custid = new JTextField();
		custid.setForeground(Color.DARK_GRAY);
		custid.setBackground(Color.WHITE);
		custid.setText("0");
		custid.setFont(new Font("Segoe UI", Font.BOLD, 14));
		custid.setBounds(340, 31, 41, 30);
		Hpanel_3.add(custid);
		custid.setColumns(10);
		/*
		 * new General().setNumerOnlyforJtext(custid); ActionListener lscust =
		 * new custls(); custid.addActionListener(lscust);
		 * custid.addKeyListener(new KeyAdapter() { public void
		 * keyReleased(KeyEvent e) { int keycode = e.getKeyCode(); //
		 * System.out.println(keycode); if (keycode == 117) { Cust_Search window
		 * = new Cust_Search(); window.frameCustomer.setVisible(true);
		 * frameCustomer.setAlwaysOnTop(true); } } });
		 */

		JLabel lblCustId = new JLabel("Customer");
		lblCustId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustId.setForeground(Color.DARK_GRAY);
		lblCustId.setBounds(0, 38, 66, 16);
		Hpanel_3.add(lblCustId);
		lblCustId.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblMobileNo = new JLabel("Mobile");
		lblMobileNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobileNo.setForeground(Color.DARK_GRAY);
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMobileNo.setBounds(-5, 65, 71, 16);
		Hpanel_3.add(lblMobileNo);

		mobile = new JTextField();
		mobile.setBackground(Color.WHITE);
		mobile.setEditable(true);
		mobile.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mobile.setForeground(Color.DARK_GRAY);
		mobile.setBounds(78, 59, 262, 27);
		Hpanel_3.add(mobile);
		mobile.setColumns(10);

		JLabel lblSearchBillNo = new JLabel("View Bill");
		lblSearchBillNo.setBounds(449, 112, 57, 18);
		Hpanel_3.add(lblSearchBillNo);
		lblSearchBillNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSearchBillNo.setForeground(Color.DARK_GRAY);

		billsearch = new JTextField();
		billsearch.setBounds(505, 107, 47, 27);
		Hpanel_3.add(billsearch);
		billsearch.setBackground(Color.WHITE);
		billsearch.setForeground(Color.DARK_GRAY);
		billsearch.setFont(new Font("Arial", Font.BOLD, 15));
		billsearch.setColumns(10);

		panelbillInfotemp = new JPanel();
		panelbillInfotemp.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelbillInfotemp.setBackground(Color.WHITE);
		panelbillInfotemp.setBounds(382, 0, 182, 73);
		Hpanel_3.add(panelbillInfotemp);
		panelbillInfotemp.setLayout(null);

		JLabel lblNewLabel_12 = new JLabel("Gross ");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setBounds(27, 17, 57, 20);
		panelbillInfotemp.add(lblNewLabel_12);
		lblNewLabel_12.setForeground(new Color(0, 0, 51));
		lblNewLabel_12.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));

		// fgross = new JTextField();
		fgross = new gnRoundTextField(20);
		fgross.setBackground(new Color(255, 255, 255));

		fgross.setBounds(85, 13, 79, 28);
		panelbillInfotemp.add(fgross);
		fgross.setEditable(false);
		fgross.setFont(new Font("Arial", Font.BOLD, 17));
		fgross.setColumns(10);

		lblNewLabel_13 = new JLabel("Discount");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(0, 45, 84, 20);
		panelbillInfotemp.add(lblNewLabel_13);
		lblNewLabel_13.setForeground(new Color(0, 0, 51));
		lblNewLabel_13.setFont(new Font("Arial Unicode MS", Font.BOLD, 15));

		// fdisc = new JTextField();
		fdisc = new gnRoundTextField(20);
		fdisc.setBackground(new Color(255, 255, 255));

		fdisc.setBounds(85, 41, 79, 28);
		panelbillInfotemp.add(fdisc);
		fdisc.setEditable(false);
		fdisc.setFont(new Font("Arial", Font.BOLD, 17));
		fdisc.setColumns(10);

		lblNewLabel_15 = new JLabel(" ");
		lblNewLabel_15.setForeground(Color.DARK_GRAY);
		lblNewLabel_15.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_15.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\simpleWhite3.png"));
		lblNewLabel_15.setBounds(-11, 0, 10, 136);
		Hpanel_3.add(lblNewLabel_15);

		billtimePanel = new JPanel();
		billtimePanel.setBounds(30, 0, 269, 27);
		Hpanel_3.add(billtimePanel);
		billtimePanel.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 0, 0)));
		billtimePanel.setBackground(Color.WHITE);
		billtimePanel.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Start Time");
		lblNewLabel_6.setForeground(new Color(0, 0, 153));
		lblNewLabel_6.setBounds(18, 6, 63, 16);
		billtimePanel.add(lblNewLabel_6);

		starttime = new JTextField();
		starttime.setForeground(Color.BLACK);
		starttime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		starttime.setBounds(84, 2, 49, 28);
		billtimePanel.add(starttime);
		starttime.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Finish Time");
		lblNewLabel_7.setForeground(new Color(0, 0, 153));
		lblNewLabel_7.setBounds(134, 6, 72, 16);
		billtimePanel.add(lblNewLabel_7);

		endtime = new JTextField();
		endtime.setForeground(Color.BLACK);
		endtime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		endtime.setBounds(204, 2, 63, 28);
		billtimePanel.add(endtime);
		endtime.setColumns(10);
		
				JLabel lblNewLabel_2 = new JLabel("Issue Token");
				lblNewLabel_2.setBounds(475, 65, 77, 20);
				Hpanel_3.add(lblNewLabel_2);
				lblNewLabel_2.setVisible(false);
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
				lblNewLabel_2.setForeground(Color.DARK_GRAY);
				
						tokenno = new JTextField();
						tokenno.setBounds(505, 87, 47, 16);
						Hpanel_3.add(tokenno);
						tokenno.setVisible(false);
						tokenno.setFont(new Font("Calibri", Font.BOLD, 13));
						tokenno.setForeground(Color.DARK_GRAY);
						tokenno.setBackground(Color.WHITE);
						tokenno.setColumns(10);
						
						addr1 = new JTextField();
						addr1.setBounds(78, 84, 262, 27);
						Hpanel_3.add(addr1);
						addr1.setColumns(10);
						
						JLabel lblNewLabel_1 = new JLabel("Address");
						lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
						lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
						lblNewLabel_1.setBounds(10, 89, 56, 16);
						Hpanel_3.add(lblNewLabel_1);
						
						btnSavecust = new JButton("Add Cust.-F5");
						btnSavecust.setBounds(340, 86, 107, 25);
						Hpanel_3.add(btnSavecust);

		/// Add Here //

		// Add Here//

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
		possplit.setBounds(1, 191, 1340, 540);
		possplit.setAutoscrolls(true);

		POSFrame.getContentPane().add(possplit);
		ActionListener lsprint = new ls();
		ActionListener lspayment = new ls();
		ActionListener l2 = new ls();

		btnDeclaration = new JButton("Declare Cash");
		btnDeclaration.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		btnDeclaration.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeclaration.setBounds(0, 296, 118, 36);
		choicepanel.add(btnDeclaration);
		btnDeclaration.setForeground(new Color(0, 0, 153));

		btn_SalesReturn = new JButton("Sales Return");
		btn_SalesReturn.setMnemonic('R');
		btn_SalesReturn.setHorizontalAlignment(SwingConstants.LEFT);
		btn_SalesReturn.setBounds(0, 170, 118, 44);
		choicepanel.add(btn_SalesReturn);
		ActionListener SR = new ls();
		btn_SalesReturn.addActionListener(SR);
		btn_SalesReturn.setForeground(new Color(0, 0, 153));
		btn_SalesReturn.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		btnCashWidrow = new JButton("Cash Withdraw");
		btnCashWidrow.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		btnCashWidrow.setHorizontalAlignment(SwingConstants.LEFT);
		btnCashWidrow.setBounds(0, 330, 118, 36);
		choicepanel.add(btnCashWidrow);
		btnCashWidrow.setForeground(new Color(0, 0, 153));

		btn_Deposit = new JButton("Float Cash");
		btn_Deposit.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		btn_Deposit.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Deposit.setBounds(0, 365, 118, 36);
		choicepanel.add(btn_Deposit);
		btn_Deposit.setForeground(new Color(0, 0, 153));

		btnDayEnd = new JButton("Day End");
		btnDayEnd.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnCloseDay2.png"));
		btnDayEnd.setMnemonic('E');
		btnDayEnd.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnDayEnd.setHorizontalAlignment(SwingConstants.LEFT);
		btnDayEnd.setBounds(0, 396, 118, 36);
		choicepanel.add(btnDayEnd);
		btnDayEnd.setForeground(new Color(0, 0, 153));
		btnDayEnd.addActionListener(lspayment);

		btnDayBegin = new JButton("Edit-Sales");
		btnDayBegin.setMnemonic('B');
		btnDayBegin.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnDayBegin.setHorizontalAlignment(SwingConstants.LEFT);
		btnDayBegin.setForeground(new Color(0, 0, 153));
		btnDayBegin.setBounds(0, 127, 118, 44);
		choicepanel.add(btnDayBegin);

		btnNewCustomer = new JButton("Customer");
		btnNewCustomer.setMnemonic('U');
		btnNewCustomer.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewCustomer.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnNewCustomer.setForeground(new Color(0, 0, 153));
		btnNewCustomer.setBounds(0, 80, 118, 48);
		choicepanel.add(btnNewCustomer);

		btnHold = new JButton("Bill Hold");
		btnHold.setBounds(0, 208, 118, 44);
		choicepanel.add(btnHold);
		btnHold.setHorizontalAlignment(SwingConstants.LEFT);
		btnHold.setForeground(new Color(0, 0, 153));
		btnHold.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnHold.setMnemonic('H');

		ActionListener bunhld = new UnholdLsnr();
		ActionListener hld = new holdLsnr();

		btnBillUnhold = new JButton("Bill UnHold");
		btnBillUnhold.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnBillUnhold.setHorizontalAlignment(SwingConstants.LEFT);
		btnBillUnhold.setBounds(0, 251, 118, 44);
		btnBillUnhold.addActionListener(bunhld);
		choicepanel.add(btnBillUnhold);

		btnClose = new JButton("Close");
		btnClose.setBounds(0, 432, 119, 36);
		choicepanel.add(btnClose);
		btnClose.setHorizontalAlignment(SwingConstants.LEFT);
		btnClose.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		btnClose.setMnemonic('C');

		// btnSalesLike = new JButton("Copy Bill");
		btnSalesLike = new gnRoundButton("Copy Bill-F10");
		btnSalesLike.setBounds(0, 37, 121, 44);
		choicepanel.add(btnSalesLike);
		btnSalesLike.setBackground(Color.CYAN);
		btnSalesLike.setForeground(Color.BLACK);
		btnSalesLike.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnSalesLike.setMnemonic('L');
		// POSFrame.getContentPane().add(choicepanel);

		btn_print = new JButton("Print");
		btn_print.setBounds(-2, -1, 123, 36);
		choicepanel.add(btn_print);
		btn_print.setIcon(null);
		btn_print.setSelectedIcon(new ImageIcon(POS.class.getResource("/RetailProduct/btnPrint2.png")));
		btn_print.setHorizontalAlignment(SwingConstants.LEFT);
		btn_print.setBackground(new Color(0, 255, 255));
		btn_print.setForeground(new Color(0, 0, 204));
		btn_print.setMnemonic('T');
		btn_print.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 17));
		btn_print.addActionListener(lsprint);

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

		jsp.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
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

		btnBcgrnd1 = new JButton(" ");
		btnBcgrnd1.setIcon(new ImageIcon(POS.class.getResource("/RetailProduct/ph9.png")));
		btnBcgrnd1.setBounds(0, 4, 266, 100);
		Hpanel_2.add(btnBcgrnd1);

		JPanel dispPanel = new JPanel();
		dispPanel.setBounds(0, 103, 266, 33);
		Hpanel_2.add(dispPanel);
		dispPanel.setBackground(new Color(0, 128, 0));
		// JPanel dispPanel = new gnRoundPanel();

		dispPanel.setBorder(null);
		dispPanel.setLayout(null);

		JLabel lblCashier = new JLabel("User");
		lblCashier.setBounds(0, 4, 28, 22);
		dispPanel.add(lblCashier);
		lblCashier.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCashier.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCashier.setForeground(Color.WHITE);

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
		lblNewLabel.setForeground(Color.WHITE);

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
		lblTerminalId.setForeground(Color.WHITE);

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

		//Edit Portion Removed From here 
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
		pos_hdr1 = new JPanel();
		pos_hdr1.setBackground(Color.WHITE);
		pos_hdr1.setBackground(new Color(102, 0, 102));
		pos_hdr1.setBounds(393, 0, 228, 136);
		pos_hdr1.setBorder(
				new TitledBorder(null, "Home Delivery", TitledBorder.CENTER, TitledBorder.TOP, null, Color.GREEN));
		pos_hdr1.setLayout(null);
		HeaderPanel.add(pos_hdr1);

		JLabel lblDate = new JLabel("Phone");
		lblDate.setFont(new Font("Calibri", Font.BOLD, 15));
		lblDate.setForeground(Color.WHITE);
		lblDate.setBounds(6, 7, 56, 16);
		pos_hdr1.add(lblDate);

		hm_Phone = new JTextField();
		hm_Phone.setBackground(new Color(102, 0, 102));
		hm_Phone.setForeground(new Color(0, 0, 153));
		hm_Phone.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_Phone.setToolTipText("Enter Phone Number  Max Char Allow 10");
		hm_Phone.setBounds(47, 6, 78, 22);
		pos_hdr1.add(hm_Phone);
		hm_Phone.setColumns(10);

		hm_custname = new JTextField();
		hm_custname.setBackground(Color.WHITE);
		hm_custname.setForeground(new Color(0, 0, 51));
		hm_custname.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_custname.setToolTipText("Enter Name  Max Chars Allow is 30");
		hm_custname.setBounds(16, 24, 205, 22);
		pos_hdr1.add(hm_custname);
		hm_custname.setColumns(10);

		hm_addr1 = new JTextField();
		hm_addr1.setBackground(Color.WHITE);
		hm_addr1.setForeground(new Color(0, 0, 51));
		hm_addr1.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_addr1.setToolTipText("Enter Address  Max Chars Allow is 30");
		hm_addr1.setBounds(16, 42, 205, 22);
		pos_hdr1.add(hm_addr1);
		hm_addr1.setColumns(10);

		hm_addr2 = new JTextField();
		hm_addr2.setBackground(Color.WHITE);
		hm_addr2.setForeground(new Color(0, 0, 51));
		hm_addr2.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_addr2.setToolTipText("Enter Address  Max Chars Allow is 30");
		hm_addr2.setBounds(16, 59, 205, 22);
		pos_hdr1.add(hm_addr2);
		hm_addr2.setColumns(10);

		homeDelivery = new JCheckBox("Deliver At");
		homeDelivery.setFont(new Font("Calibri", Font.BOLD, 15));
		homeDelivery.setForeground(Color.WHITE);
		homeDelivery.setBackground(new Color(153, 255, 255));
		homeDelivery.setBounds(126, 6, 87, 18);
		pos_hdr1.add(homeDelivery);

		hm_addr3 = new JTextField();
		hm_addr3.setBackground(Color.WHITE);
		hm_addr3.setForeground(new Color(0, 0, 51));
		hm_addr3.setFont(new Font("Calibri", Font.PLAIN, 12));
		hm_addr3.setToolTipText("Enter City  Max Chars Allow is 30");
		hm_addr3.setBounds(16, 77, 205, 22);
		pos_hdr1.add(hm_addr3);
		hm_addr3.setColumns(10);

		vsearchname = new JTextField();
		vsearchname.setBounds(16, 111, 27, 23);
		pos_hdr1.add(vsearchname);
		vsearchname.setColumns(10);
		pos_hdr1.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { homeDelivery, hm_Phone, hm_custname, hm_addr1, hm_addr2, hm_addr3, lblDate }));

		// panelscan = new JPanel();
		panelscan = new gnRoundPanel();

		panelscan.setBounds(124, 137, 833, 51);
		HeaderPanel.add(panelscan);
		panelscan.setBackground(new Color(255, 255, 240));
		panelscan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 255, 204), null));
		panelscan.setLayout(null);

		JLabel lblScanItem = new JLabel("Scan Item");
		lblScanItem.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScanItem.setForeground(Color.DARK_GRAY);
		lblScanItem.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblScanItem.setBounds(0, 21, 86, 16);
		panelscan.add(lblScanItem);

		scanItem_2 = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		scanItem_2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		scanItem_2.setBorder(BorderFactory.createLineBorder(Color.GREEN));

		scanItem_2.setToolTipText("Max code Length is 5 ");
		scanItem_2.setForeground(new Color(0, 0, 102));
		scanItem_2.setFont(new Font("Arial", Font.BOLD, 16));
		scanItem_2.setBounds(93, 14, 172, 30);
		panelscan.add(scanItem_2);
		scanItem_2.setColumns(10);
		scanqty = new gnRoundTextField(12);
		scanqty.setFont(new Font("Arial", Font.BOLD, 16));
		scanqty.setForeground(Color.BLACK);
		scanqty.setBackground(Color.WHITE);
		scanqty.setBounds(330, 14, 85, 30);
		panelscan.add(scanqty);
		scanqty.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Rate");
		lblNewLabel_4.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setBounds(433, -2, 68, 18);
		panelscan.add(lblNewLabel_4);

		rate = new gnRoundTextField(12);
		rate.setFont(new Font("Arial", Font.BOLD, 16));
		rate.setForeground(Color.BLACK);
		rate.setBackground(Color.WHITE);
		rate.setBounds(419, 14, 90, 30);
		panelscan.add(rate);
		rate.setColumns(10);

		lblNewLabel_5 = new JLabel("Discount Amount");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_5.setForeground(Color.DARK_GRAY);
		lblNewLabel_5.setBounds(483, 0, 165, 16);
		panelscan.add(lblNewLabel_5);

		disc = new gnRoundTextField(12);
		disc.setFont(new Font("Arial", Font.BOLD, 16));
		disc.setForeground(Color.BLACK);
		disc.setBackground(Color.WHITE);
		disc.setText("0");
		disc.setToolTipText("Please Enter Bill Level Disc.Amount If Applicable");
		disc.setBounds(513, 14, 141, 30);
		panelscan.add(disc);
		disc.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Qty");
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setBounds(344, -2, 68, 18);
		panelscan.add(lblNewLabel_3);

		lblNewLabel_11 = new JLabel("Discount %");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_11.setForeground(Color.DARK_GRAY);
		lblNewLabel_11.setBounds(631, 0, 112, 16);
		panelscan.add(lblNewLabel_11);

		// billhdrdiscper = new JTextField();
		billhdrdiscper = new gnRoundTextField(15);
		billhdrdiscper.setFont(new Font("Arial", Font.BOLD, 16));
		billhdrdiscper.setForeground(Color.BLACK);
		billhdrdiscper.setBackground(Color.WHITE);
		billhdrdiscper.setToolTipText("Please Enter Bill Level Disc% if Applicable ");
		billhdrdiscper.setBounds(657, 14, 98, 30);
		panelscan.add(billhdrdiscper);
		billhdrdiscper.setColumns(10);

		btnDoctor = new JButton("Doctor & Patient Info");
		btnDoctor.setBounds(758, 14, 46, 28);
		panelscan.add(btnDoctor);
		btnDoctor.setBackground(Color.BLACK);
		btnDoctor.setFont(new Font("Agency FB", Font.BOLD, 16));
		btnDoctor.setForeground(new Color(51, 0, 102));
		btnDoctor.addActionListener(lssave1);
		panelscan.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { scanItem_2, scanName22, scanqty, rate, disc }));

		btnImgComp = new JButton(" ");
		btnImgComp.setBounds(0, 0, 122, 107);
		HeaderPanel.add(btnImgComp);
		btnImgComp.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\mymainIcon6.ico"));
		btnImgComp.setIcon(new ImageIcon(POS.class.getResource("/RetailProduct/POS1.png")));
		btn_Save = new JButton("Save-F8");
		btn_Save.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_Save.setBounds(0, 137, 122, 51);
		HeaderPanel.add(btn_Save);
		btn_Save.setSelectedIcon(new ImageIcon(POS.class.getResource("/RetailProduct/btnApsave1.png")));
		btn_Save.setIcon(null);
		btn_Save.setBackground(new Color(0, 0, 102));
		btn_Save.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Save.setForeground(new Color(153, 255, 153));
		btn_Save.setMnemonic('S');
		btn_Save.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 19));

		JLabel lblSalesType = new JLabel("Sales Type");
		lblSalesType.setBounds(0, 111, 71, 24);
		HeaderPanel.add(lblSalesType);
		lblSalesType.setForeground(Color.DARK_GRAY);
		lblSalesType.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblSalesType.setHorizontalAlignment(SwingConstants.RIGHT);

		SalesType = new JComboBox<String>();
		SalesType.setBounds(72, 111, 50, 25);
		HeaderPanel.add(SalesType);
		SalesType.setEnabled(false);
		SalesType.setModel(new DefaultComboBoxModel(new String[] { "", "Sale", "Rent" }));
		SalesType.setForeground(Color.WHITE);
		SalesType.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 10));
		SalesType.setMaximumRowCount(20);
		SalesType.setBackground(Color.WHITE);
		new gnComp().fillCombo(SQL11, SalesType);
		btn_Save.addActionListener(lssave1);

		pmt = new JPanel();
		pmt.setBounds(958, 0, 383, 187);
		// jun25
		POSFrame.getContentPane().add(pmt);
		pmt.setBackground(Color.WHITE);
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
		lblTotalAmount.setForeground(Color.DARK_GRAY);

		// Tamount = new JTextField();
		Tamount = new gnRoundTextField(20);
		Tamount.setHorizontalAlignment(SwingConstants.RIGHT);
		Tamount.setEditable(false);
		Tamount.setText("0.00");
		Tamount.setForeground(new Color(204, 255, 255));
		Tamount.setBounds(232, 8, 149, 33);
		pmt.add(Tamount);
		Tamount.setBackground(Color.BLACK);
		Tamount.setFont(new Font("Segoe UI", Font.BOLD, 22));
		Tamount.setColumns(10);

		JLabel lblHeaderLevelDiscount = new JLabel("Bill Level Disc");
		lblHeaderLevelDiscount.setForeground(Color.DARK_GRAY);
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
		hdrDiscount.setBounds(232, 47, 149, 30);
		hdrDiscount.setText("0");
		pmt.add(hdrDiscount);

		JLabel lblNetPayableAmount = new JLabel("Net Amount ");
		lblNetPayableAmount.setBackground(Color.YELLOW);
		lblNetPayableAmount.setFont(new Font("Arial", Font.BOLD, 17));
		lblNetPayableAmount.setForeground(new Color(0, 0, 139));
		lblNetPayableAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNetPayableAmount.setBounds(117, 146, 115, 25);
		pmt.add(lblNetPayableAmount);

		// netAmount = new JFormattedTextField();
		netAmount = new gnRoundTextField(20);
		netAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		netAmount.setText("0.00");
		netAmount.setForeground(new Color(204, 255, 255));
		netAmount.setBackground(Color.BLACK);
		netAmount.setFont(new Font("Arial", Font.BOLD, 22));
		netAmount.setEditable(false);
		netAmount.setBounds(232, 141, 149, 30);
		pmt.add(netAmount);

		JLabel lblRoundingOffAmount = new JLabel("Round.Off");
		lblRoundingOffAmount.setForeground(Color.DARK_GRAY);
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
		froundAmt.setBounds(232, 107, 149, 30);
		froundAmt.setText("0.00");
		pmt.add(froundAmt);

		JLabel lblRecords_1 = new JLabel("Records");
		lblRecords_1.setBounds(12, 45, 86, 23);
		pmt.add(lblRecords_1);
		lblRecords_1.setForeground(Color.DARK_GRAY);
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
		lblNewLabel_9.setForeground(Color.DARK_GRAY);
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
		lblNewLabel_10.setForeground(Color.DARK_GRAY);
		lblNewLabel_10.setBounds(95, 80, 125, 23);
		pmt.add(lblNewLabel_10);

		// manualdisc = new JTextField();
		manualdisc = new gnRoundTextField(20);
		manualdisc.setHorizontalAlignment(SwingConstants.RIGHT);
		manualdisc.setForeground(new Color(204, 255, 255));
		manualdisc.setFont(new Font("Arial", Font.BOLD, 22));
		manualdisc.setBackground(Color.BLACK);
		manualdisc.setBounds(232, 77, 149, 30);
		pmt.add(manualdisc);
		manualdisc.setColumns(10);

		// btn_Payment = new JButton("Payment");
		btn_Payment = new gnRoundButton("Payment");
		btn_Payment.setText("Payment-F7");
		btn_Payment.setBounds(2, 142, 115, 38);
		pmt.add(btn_Payment);
		btn_Payment.setSelectedIcon(new ImageIcon(POS.class.getResource("/RetailProduct/btnPayment2.png")));
		btn_Payment.setBackground(new Color(204, 255, 204));
		btn_Payment.setForeground(Color.BLACK);
		btn_Payment.setHorizontalAlignment(SwingConstants.LEFT);
		btn_Payment.setMnemonic('P');
		btn_Payment.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));

		JLabel lblNewLabel_16 = new JLabel("-");
		lblNewLabel_16.setEnabled(false);
		lblNewLabel_16.setIcon(new ImageIcon(POS.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel_16.setBounds(2, 45, 381, 3);
		pmt.add(lblNewLabel_16);
		btn_Payment.addActionListener(l2);

		panelDoctorInfo = new JPanel();
		// panelDoctorInfo.setBounds(830, 162, 74, 48);
		panelDoctorInfo.setBounds(959, 0, 382, 188);
		POSFrame.getContentPane().add(panelDoctorInfo);
		panelDoctorInfo.setBackground(Color.WHITE);
		panelDoctorInfo.setBackground(new Color(102, 0, 102));
		panelDoctorInfo.setBorder(new TitledBorder(null, "Doctor & Patient Info", TitledBorder.CENTER, TitledBorder.TOP,
				null, Color.WHITE));
		panelDoctorInfo.setVisible(false);
		panelDoctorInfo.setLayout(null);

		//
		JLabel lbldocname = new JLabel("Doctor Name ");
		lbldocname.setBounds(2, 31, 111, 23);
		lbldocname.setBackground(new Color(102, 102, 102));
		lbldocname.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldocname.setFont(new Font("Cambria", Font.BOLD, 16));
		panelDoctorInfo.add(lbldocname);
		lbldocname.setForeground(Color.WHITE);

		docname = new JTextField();
		docname.setBounds(12, 50, 356, 35);
		docname.setEditable(true);
		docname.setText("");
		panelDoctorInfo.add(docname);
		docname.setBackground(new Color(240, 255, 255));
		docname.setFont(new Font("Cambria", Font.PLAIN, 13));
		docname.setColumns(10);

		JLabel PatName = new JLabel("Patient Name");
		PatName.setBounds(22, 87, 181, 16);
		PatName.setForeground(Color.WHITE);
		PatName.setHorizontalAlignment(SwingConstants.LEFT);
		PatName.setFont(new Font("Cambria", Font.BOLD, 16));
		panelDoctorInfo.add(PatName);

		patientName = new JTextField();
		patientName.setBounds(12, 100, 356, 35);
		// patientName.setForeground(new Color(153, 255, 153));
		patientName.setBackground(new Color(240, 255, 255));
		patientName.setFont(new Font("Cambria", Font.PLAIN, 13));
		patientName.setText(" ");
		panelDoctorInfo.add(patientName);

		btnNewdoctor = new JButton("New Doctor");
		btnNewdoctor.setBounds(244, 26, 120, 28);
		panelDoctorInfo.add(btnNewdoctor);

		pmtPanel = new JPanel();
		Pjsp_1 = new JScrollPane();
		Pjsp_1.setBounds(5, 104, 378, 83);
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
		Final_Tamt.setBounds(244, 2, 139, 32);
		Final_Tamt.setFont(new Font("Arial Black", Font.BOLD, 23));
		pmtPanel.add(Final_Tamt);
		Final_Tamt.setColumns(10);

		JLabel lblPaidAmount = new JLabel("Amount Paid");
		lblPaidAmount.setForeground(new Color(0, 0, 51));
		lblPaidAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPaidAmount.setBounds(128, 43, 107, 16);
		pmtPanel.add(lblPaidAmount);
		lblPaidAmount.setFont(new Font("Tahoma", Font.BOLD, 14));

		// Final_Pamt = new JTextField();
		Final_Pamt = new gnRoundTextField(20);
		Final_Pamt.setEditable(false);
		Final_Pamt.setBounds(244, 37, 139, 32);
		new General().setNumerOnlyforJtext(Final_Pamt);
		Final_Pamt.setDocument(new gnSetinputLimit(10));

		pmtPanel.add(Final_Pamt);
		Final_Pamt.setFont(new Font("Tahoma", Font.BOLD, 14));
		Final_Pamt.setColumns(10);

		JLabel lblPaymentDue = new JLabel("Due Amount");
		lblPaymentDue.setForeground(new Color(0, 0, 51));
		lblPaymentDue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPaymentDue.setBounds(140, 78, 95, 21);
		pmtPanel.add(lblPaymentDue);
		lblPaymentDue.setFont(new Font("Tahoma", Font.BOLD, 14));

		// Final_Damt = new JTextField();
		Final_Damt = new gnRoundTextField(20);
		Final_Damt.setEditable(false);
		Final_Damt.setBounds(244, 71, 139, 32);
		pmtPanel.add(Final_Damt);
		Final_Damt.setFont(new Font("Tahoma", Font.BOLD, 17));
		Final_Damt.setColumns(10);

		custamountPaid = new JTextField();
		custamountPaid.setFont(new Font("Arial", Font.BOLD, 17));
		custamountPaid.setBounds(5, 65, 85, 38);
		pmtPanel.add(custamountPaid);
		custamountPaid.setColumns(10);

		payCombo = new JComboBox();
		payCombo.setBackground(Color.WHITE);
		payCombo.setForeground(Color.DARK_GRAY);
		payCombo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		payCombo.setBounds(5, 18, 92, 27);
		pmtPanel.add(payCombo);

		JLabel lblNewLabel_8 = new JLabel("Payment Mode");
		lblNewLabel_8.setForeground(new Color(0, 0, 51));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(5, 2, 123, 16);
		pmtPanel.add(lblNewLabel_8);

		docno = new JTextField();
		docno.setText("0");
		docno.setEditable(false);
		docno.setBounds(89, 65, 42, 38);
		pmtPanel.add(docno);
		docno.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Enter Amount");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_14.setBounds(5, 47, 127, 16);
		pmtPanel.add(lblNewLabel_14);

		ptable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		ActionListener billlike = new lsSave();
		ActionListener mnname = new lsnritemName();
		ActionListener hm = new hmDel_lsnr();
		homeDelivery.addActionListener(hm);
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
		billsearch.addActionListener(lk999);

		custamountPaid.addActionListener(paymentinsertls);
		payCombo.addActionListener(paycomboLsnr);
		docname.addActionListener(docls);
		patientName.addActionListener(patls);
		btnNewdoctor.addActionListener(lssave1);
		scanqty.addActionListener(scanQty);
		rate.addActionListener(scanRate);
		billhdrdiscper.addActionListener(lsdiscper);
		disc.addActionListener(lsdiscamt);
		scanItem_2.addActionListener(itemcodeLsnr);
		btnClose.addActionListener(l2);
		btnClose.addActionListener(lssave1);
		btn_Payment.addActionListener(mypaycomboLsnr);
		btnSalesLike.addActionListener(billlike);
		
		ActionListener  necustLs = new newcustLsnr() ;
		btnSavecust.addActionListener(necustLs);
		
		ActionListener mobilels = new lsnrMobile();
		mobile.addActionListener(mobilels);

		
		decorate();

	}

	/// Start coding from Herea

	public void decorate() throws Throwable {

		new General().setNumerOnlyforJtext(mobile);
		mobile.setDocument(new gnSetinputLimit(10));

		varticle = "0";
		// promoSplit.remove(promojsp);
		// promojsp.setVisible(false);

		new gnApp().setFrameTitel(POSFrame);
		delTableRow(table, model, "POS");
		POSPayment(table, model, "POS");
		POSBillSave(table, model, "POS");
		POSPcopybill(table, model, "POS");

		setPaymentPanel();
		panelbillInfotemp.setVisible(false);
		possplit.setDividerLocation(0);
		pos_hdr1.setVisible(false);
		Hpanel_3.setBounds(393, 0, 564, 136);

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
		btnSalesLike.setVisible(true);
		billtimePanel.setVisible(false);
		this.checkInternet();
		chekcFreezeYear();

		btnDoctor.setVisible(false);
		vverticlecode = new gnHierarchy().getVerticleCode();
		String vpara714 = "714";
		String vframeclosable = new getConfigurationSetting().getSpecificConfiguration(vpara714);
		switch (vpara714) {
		case "N":
			POSFrame.setUndecorated(false);
			break;
		case "Y":
			POSFrame.setUndecorated(false);
			break;
		}

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
			new gnApp().setFrameTitel(POSFrame);
			new gnBackground().setBackground(btnBcgrnd1);
			conn = this.getConnection();
			vstore = new gnConfig().getStoreID();
			vcomp = new gnConfig().getCompanyCode();
			compName = new gnConfig().getCompany();
			vvcashiercode = new gnConfig().getUserCode();
			vverticlecode = new gnHierarchy().getVerticleCode();

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
			Site_code.setText(vstore);
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
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				invdate.setText("?");
				// scanItem_2.setVisible(false);
				// scanName22.setVisible(false);
				btnDayBegin.setVisible(false);
				btn_Payment.setVisible(false);
				btn_Save.setVisible(false);

				new gnBackground().setDiffBackground(btnBcgrnd1);
				// new gnBackground().setDiffBackground(btnBcgrnd4);
				break;
			}

			scanItem_2.grabFocus();
			custid.setText("0");
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

			Final_Damt.setForeground(Color.blue);

			new gnDecorate().setTextFieldBackgroud1(Tamount);
			new gnDecorate().DispField_Eatch(hm_Phone, 20);
			new gnDecorate().DispField_Eatch(hm_custname, 20);
			new gnDecorate().DispField_Eatch(hm_addr1, 20);
			new gnDecorate().DispField_Eatch(hm_addr2, 20);
			new gnDecorate().DispField_Eatch(hm_addr3, 20);
			String vvertname = this.verticlename;

			btn_print.setBackground(new Color(199, 21, 133));
			btn_print.setForeground(new Color(204, 255, 153));

			new gnDecorate().decorateBtn(btnDoctor, Color.BLUE, Color.WHITE);
			new gnStyleButtonSqr().getStyleButton(btnClose, new Color(178, 11, 112), Color.WHITE);

			hm_Phone.setEditable(false);
			hm_custname.setEditable(false);
			hm_addr1.setEditable(false);
			hm_addr2.setEditable(false);
			hm_addr3.setEditable(false);
			getScanDataForBilling();
			break;

		case "N":
			/// System.exit(0);
			POSFrame.dispose();
			break;
		}
		pos_hdr1.setVisible(false);
		varticle = "0";
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
			Site_code.setText(vstore);
			invdate.setText(new gnConfig().getDaybeginDate());
			scanItem_2.grabFocus();
			custid.setText("0");
			terminalID.setText(new gnConfig().getTerminalID());
			int vterminal = Integer.parseInt(terminalID.getText().toString());
			shift.setText((new gnConfig().getCashierShift(vcomp, Site_code.getText(),
					new gnConfig().date_ConverttoDBforamt(invdate.getText()), vterminal, vvcashiercode)));
			vvcashiercode = new gnConfig().getUserCode();
			cashiercode.setText(vvcashiercode);
			btn_Save.setEnabled(false);
			new gnLogger().loggerInfoEntry("POS", "Setting POS Type");
			setVerticlePOS();
			new gnLogger().loggerInfoEntry("POS", "Setting Configuration Types");
			setConfiguratin();

		}
	}

	class myitemcodeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent r) {
			String value = r.getActionCommand();
			int i = r.getID(); // Field id
			if (i == 1001) {
				if (vallowday == "N") {
					POSFrame.dispose();
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
							namesearch();
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

	private void namesearch() {

		String sname = scanItem_2.getText().trim();
		sname = "%" + sname + "%";
		String vType = "Article";
		String vtrantype = "POS";
		try {
			if (varticle != null && varticle.length() > 0) {
				String vpara716 = "716";
				// new General().msg(vpara716);
				String vallowpopupHelp = new getConfigurationSetting().getSpecificConfiguration(vpara716);
				switch (vallowpopupHelp) {
				case "Y":
					new gnAdmin().Search(vType, sname, varticle, vtrantype); // if
					break;
				case "N":
					promotable = new gnAdmin().Searchintabe(vType, sname, varticle, vtrantype);
					showArticleNameSearchResult(promotable);
					promotable.grabFocus();
					SelectionType = "Article";
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
		POSFrame.getContentPane().add(pmtPanel);
		pmtPanel.setBounds(959, 0, 382, 188);
		pmtPanel.setBackground(Color.WHITE);
		pmtPanel.setBorder(new MatteBorder(0, 2, 2, 0, (Color) new Color(64, 64, 64)));
		pmtPanel.setLayout(null);
		pmtPanel.setVisible(false);

	}

	void processPaymentNow() {
		try {
  			switch (promoModuleActivated.trim()) 
 			{
			 case "Y":
  				try
				{
 	 				String vdocno = invno.getText();
					String vdocdate = invdate.getText();
					new gnPromoGetInfo().refreshPromoTables(vdocno, vdocdate);
					startPromoApplyProcess();
				}
				catch(Exception e)
				{
					new General().msg(e.getLocalizedMessage());
				}
				break;
			}
   			
			switch (vallowPopWindow) // New Change for payment
			{
			case "N":
				pmt.setVisible(false);
				panelDoctorInfo.setVisible(false);
				panelbillInfotemp.setVisible(true); // New Addition on jun-2020
				// jun2020
				pmtPanel.setVisible(true); // original Line
				custamountPaid.grabFocus();
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
			discpercalculate() ;
		}
	}

private void discpercalculate()
{
	String vvdiscper = billhdrdiscper.getText();
	double vdiscper = Double.parseDouble(vvdiscper);
	double vdiscamt = 0.0;
	double vgross = 0.0;
	double vmygross = 0.0;
	try {
		int row = table.getRowCount();
		if (row > 0) {
			for (int i = 0; i < row; i++) {
				vgross = Double.parseDouble(table.getValueAt(i, 6).toString());
				vmygross = vmygross + vgross;
			}
			vdiscamt = (vmygross * vdiscper / 100);
			disc.setText(Double.toString(vdiscamt));
		}
			DistributeDiscountper(vvdiscper);
	} catch (Throwable e) {
		e.printStackTrace();
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
		proposeDiscount = Double.parseDouble(disc.getText());
		int row = table.getRowCount();
		if (row > 0) {
			for (int i = 0; i < row; i++) {
				vgross = Double.parseDouble(table.getValueAt(i, 6).toString());
				// vgross = Double.parseDouble(table.getValueAt(i,
				// 11).toString());
				vdiscamt = vgross * vdiscper / 100;
				issueDiscount = issueDiscount + vdiscamt;
				String vmydiscamt = new gnMath().get2DecimaltValue(Double.toString(vdiscamt));
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

	public void POSPcopybill(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg( "Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "copybill");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("copybill", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					btnSalesLike.doClick();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
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

	public void delTableRow(JTable table, DefaultTableModel model, String FieldName) {
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "CalAction");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					int row = table.getSelectedRow();
					String vremark = "Record Removed";
					updateAuditRecord(vremark, row);
					model.removeRow(row);
					removeRow(model, table);
		 				try {
			 					discpercalculate(); //Recalclate and distribute disc after row remove
							} catch (Throwable e1) {
								e1.printStackTrace();
						}
 					table.setEditingRow(row);
					Double v = new gnTable().getTotal(table, 10);
					Tamount.setText(Double.toString(v));
					int vcount = table.getRowCount();
					records.setText(Integer.toString(vcount));
					calHdrDisocunt();
					scanItem_2.grabFocus();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
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
		// Dpanel.setEnabled(false);
		// nameSearchPanel.setBounds(400, 166, 500, 500);
		// nameSearchPanel.setBounds(300, 20, 500, 500);
		// nameSearchPanel.setVisible(true);
		// nameSearchPanel.setAutoscrolls(true);
		// namejsp.setBounds(6, 6, 490, 490);
		// Dpanel.add(nameSearchPanel);
		// Dpanel.remove(jsp);
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

	/*
	 * private void FillArticle() throws ClassNotFoundException, SQLException {
	 * new gnTable().RemoveTableRows(Articlemodel); // String sname =
	 * quickSearch.getText(); String sname = "%" + sname + "%"; String
	 * ArticleCol[] = { "Name", "Sales Price", "Article", "Tax" };
	 * Articlemodel.setColumnIdentifiers(ArticleCol);
	 * Articletable.setModel(Articlemodel); String vverticlecode = new
	 * getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
	 * new gnPublicVariable().vstore); String SQL =
	 * "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " +
	 * vverticlecode + ")"; rs = this.getSPResult(SQL); while (rs.next()) {
	 * Articlemodel.addRow(new Object[] { rs.getString(2), rs.getString(4),
	 * rs.getString(1), rs.getString(8) }); Articletable.setModel(Articlemodel);
	 * new gnTable().setTableBasics(Articletable); new
	 * gnTable().setTablewidth(Articletable, 0, 150);
	 * Articletable.setGridColor(Color.gray); JViewport prt777 = new
	 * JViewport(); prt777.setBackground(Color.CYAN); prt777.add(Articletable,
	 * ArticleCol); prt777.setVisible(true); new
	 * gnTable().setFontBold(Articletable, 14); artjsp.setViewport(prt777); }
	 * Selectrow(); }
	 * 
	 */

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
				POSFrame.dispose();
			}

			if (value == "Day End") {
				try {
					POSFrame.dispose();
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
					POSFrame.dispose();
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
		prt1101.setBackground(new Color(51, 255, 255));
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

	private void showArticleBatchSearchResult(JTable mytable) {
		//new General().msg(" Batch Search Called ");;
		new gnTable().RemoveTableRows(promomodel);
		//scanItem_2.setEnabled(false);
		if (SelectionType == "Batch") {
			scanItem_2.setEnabled(false);
		}
		promotable = mytable;
		promotable.requestFocus();
		new gnTable().setTableColWidth(promotable, 1, 150);
		new gnTable().setTableColWidth(promotable, 5, 150);
		promotable.setBackground(Color.YELLOW);
		promotable.setForeground(Color.BLACK);
		promotable.setSelectionForeground(Color.white);
		promotable.setEditingRow(0);
		JViewport prt1101 = new JViewport();
		prt1101.setBackground(new Color(51, 255, 255));
		prt1101.add(promotable);
		prt1101.setVisible(true);
		promojsp.setViewport(prt1101);
  		SelectArticlerow();
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//new gnTable().RemoveTableRows(promomodel);
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
		new gnTable().RemoveTableRows(promomodel);
	}

	private void batchAction() {
		int row = promotable.getSelectedRow();
		String value = (String) promotable.getValueAt(row, 0).toString().trim();
		try {
			if (value == "Article") {
				varticle = promotable.getValueAt(row, 1).toString();
				showTableData(varticle, model);
				varticle = "0";
				scanItem_2.setEnabled(true);
				scanItem_2.grabFocus();
				new gnTable().RemoveTableRows(promomodel);
				afterShortcutKeyExecute();
			}

			if (value == "Batch") {
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
				afterShortcutKeyExecute();
 				captureCropDetails();
 			}

			if (value == "NoBatch") {
				int batchrow = promotable.getSelectedRow();
				promotable.setBackground(Color.BLACK);
				promotable.setForeground(Color.white);
				table.setValueAt(promotable.getValueAt(batchrow, 8), selectedrow, 14);
				table.setValueAt(promotable.getValueAt(batchrow, 9), selectedrow, 15);
				table.setValueAt(promotable.getValueAt(batchrow, 5), selectedrow, 4);
				table.setValueAt(promotable.getValueAt(batchrow, 6), selectedrow, 5);
				varticle = promotable.getValueAt(batchrow, 2).toString();
 				promomodel.setRowCount(0);
				new gnTable().RemoveTableRows(promomodel);
				scanItem_2.setEnabled(true);
				scanItem_2.grabFocus();
				QtychangeImapct(varticle, selectedrow);
				JViewport jk = new JViewport();
				promojsp.setViewport(jk);
				afterShortcutKeyExecute();
 				captureCropDetails();
			}

		} catch (Throwable e1) {
			e1.printStackTrace();
		}
		new gnTable().RemoveTableRows(promomodel);
		scanItem_2.grabFocus();
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
			if (value == "Pay") {
				try {
					pmt.setVisible(false);
					insertPaymentRow();
					pmtPanel.setVisible(true);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Copy Bill-F10") {
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
					POSFrame.dispose();
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
				String vtype3 = "PS";
				String SQL = "Call sale_getEditSalesData( '" + vtype3 + "', " + vcomp + " ,  " + vstore + "  , "
						+ vinvno + ", '" + vinvdate + "' )";
				showEditTableData(SQL, model);
			}
		}
	}

	public void callEditProcess(String vdocno, String vdocDate) throws Throwable {

		invoiceMode = "E";
		
		String vpara29 = "29" ;
		String veditAllow = new getConfigurationSetting().getSpecificConfiguration(vpara29);

		switch(veditAllow)
		{
			case "N" :
			new General().msg("Bill Edit Not Allow... You Can Only View Data ..p29");
		}
		invdate.setText(vdocDate);
		invno.setText(vdocno);
		String vinvno = invno.getText();
		String vinvdate = new gnConfig().date_ConverttoDBforamt(vdocDate);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vtype3 = "PS";
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
		btn_print.doClick();
		//printInvoice();
	}

	public void printInvoice() throws Throwable {
		new gnLogger().loggerInfoEntry("POS", "Printing Document Init..");
		String vinvno = invno.getText();
		String vinvdate = invdate.getText();
		if (vinvno.length() != 0) {
			String doctype = "POSINV";
			String vpara27 = "27";
			String printinvoice = new getConfigurationSetting().getSpecificConfiguration(vpara27);
 			switch (printinvoice) {
			case "Y":
				updateRounding();
  				new gnDocPrint().callprint(doctype, vinvno, vinvdate);
 				scanItem_2.grabFocus();
				break ;

			case "N":
				updateRounding();
				scanItem_2.grabFocus();
				new gnDocPrint().callprint(doctype, vinvno, vinvdate);
				scanItem_2.grabFocus();
				break ;

			}
			
		} else {
			new General().msg("Invoice Number Not Available For Printing...");
		}
		return;
	}

	public void initiateNewBill() throws Throwable {
		records.setText("0");
		;
		showqty.setText("0");
		;
		invoiceMode = "I";
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
		docname.setText("0");
		patientName.setText("No Data");
		patientName.setText(null);
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
			String sitecode = Site_code.getText();
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
			String sitecode = Site_code.getText();
			// invno.setText(null);
			int vccode = 0;
			custid.setText(Integer.toString(vccode));
			String reset = "                                ";
			// scanItem.setText(reset);
			scanItem_2.grabFocus();
			this.closeconn();
			new gnLogger().loggerInfoEntry("POS", "New Bill Init...");

		}

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

	// Kalyani
 	private void handleBatchZero(String varticle, String vbatchcontrol, String vtype) throws Throwable {
		// new General().msg("Processing now for zero batch Articles");
		String vcost = "0";
		String vsp = table.getValueAt(selectedrow, 4).toString();
		String vmrp = table.getValueAt(selectedrow, 5).toString();
		String vloc = "SL";
		String stockAvailabe = "";
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
				 SelectionType = "Batch" ;
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

	private void checkBatchforNonBatchItems(String varticle, String vbatchcontrol) throws Throwable 
	{
 		//new General().msg("checking for Non BAtch Items Mrp Check");
		String vcost = "0";
		String vsp = table.getValueAt(selectedrow, 4).toString();
		String vmrp = table.getValueAt(selectedrow, 5).toString();
		String vloc = "SL";
		String stockAvailabe = "";
		String vtype = "";
		String vaction = new gnBatch().IsBatchAvailableForIsBatchAvailableforMrpandSP(varticle, vmrp, vsp);
  		//new General().msg("Batch Available :"+ ""+vaction);
 		switch (vaction) 
  		{
		case "Y":
			stockAvailabe = new gnBatch().IsStockAvailabeForMrpandSP(varticle, vmrp, vsp);
	  		//new General().msg("Stock Available :"+ ""+stockAvailabe);
 			scanItem_2.setText("");
			scanItem_2.grabFocus();
			switch (stockAvailabe) {
			case "Y":
				vtype = "GZcase123";
				//new General().msg(vtype);
				handleBatchNonZero(varticle, vbatchcontrol, vtype);
				break;
			case "N":
				vtype = "GZcase0";
				//new General().msg(vtype);
 				handleBatchZero(varticle, vbatchcontrol, vtype);
				break;
			}
			break;
			
		case "N" :  // For New Batch
			table.setValueAt(0, selectedrow, 14);
			double mybatch = Double.parseDouble(table.getValueAt(selectedrow, 14).toString());
			if (mybatch <= 0) 
			{
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
		row = table.getRowCount();
		String vstorecode = Site_code.getText();
		String vcomp = new gnConfig().getCompanyCode();
		String vloc = "SL";
		String vpara811 = "811";
		// String vmaintainbatchforNonBatchItem = new
		// getConfigurationSetting().getInitialConfig(vpara811, vcomp,
		// vstorecode);
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
		String vstorecode = Site_code.getText();
		String vcomp = new gnConfig().getCompanyCode();
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
				 //checkBatchforNonBatchItems( varticle, vbatchcontrol) ;
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
		String vstorecode = Site_code.getText();
		String vcomp = new gnConfig().getCompanyCode();
		String batch[] = { "BatchArticlce", "Item Code", "name", "cost", "SalesPrice", "Mrp", "Batchno", "Manuf_date",
				"Exp.Date", "Bal_Qty" };
		String vloc = "SL";

		String vpara716 = "716";
		String vallowpopupHelp = new getConfigurationSetting().getSpecificConfiguration(vpara716);

		String vpara811 = "811";
		vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstorecode);
		//new General().msg("maintain batch"+""+vmaintainbatchforNonBatchItem) ;
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
						scanItem_2.grabFocus();
					}
				}
			} // Finally
				// captureCropDetails() ; ///commnted for furtilizer for batch
				// details popup in sames scrin on date 14.05.2020
			break;

		case "Y":
            //new General().msg("Non Batch Action Starts Now .."); 
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
		// new General().msg(value);
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
				switch (vmaintainbatchforNonBatchItem) {
				case "N":
					vtype = "POS";
					SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', " + vcomp + " , "
							+ vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
					//new General().msg(SQL);
					break;
				case "Y":
					rateDisable();
					// table.setEnabled(true);
					vtype = "POSFORBatchForNonBAtchItem"; // "POS" ;
					SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', " + vcomp + " , "
							+ vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
					// new General().msg(SQL);
					break;
				} // Switch
				table.setModel(model);
				// new General().msg(SQL);
				rs = null;
				rs = this.getSPResult(SQL);
				if (rs.next()) {
					String varticle = rs.getString(1);
					AutodiscArticle = rs.getString(1);
					String vsp = rs.getString(4);
					int varticlereturn = Integer.parseInt(rs.getString(1));
					if (varticlereturn > 0) {
						if (Double.parseDouble(vsp) == 0.0) {
 							new gnImageSound().playAlertSound();
							new gnImageSound().playAlertSound();
							new gnLogger().loggerInfoEntry("POS", "Please Update Price Master  ");
						}
						model.insertRow(0,
								new Object[] { new Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
										rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
										rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
										rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
										rs.getString(16) });
						QueryStatus = "Y";
						varticle = "0";
						new gnTable().setTableColWidth(table, 15, 100);
						vdrugType = rs.getString(1);
						vbatchArticle = rs.getString(13);
						selectedrow = 0;
						// new gnTable().RemoveTableRows(promomodel);
						CheckBatchArticle(value, vbatchArticle);
						new gnTable().setTablewidth(table, 2, 300);
						table.setModel(model);
						table.setRowHeight(30);
						btnSalesLike.setVisible(true);
						new gnLogger().loggerInfoEntry("POS",
								"Checking For Promo Applicablity For Article :" + varticle);
						table.setCursor(new Cursor(Cursor.HAND_CURSOR));
						varticle = "0";
						scanItem_2.setText(null);
						// scanItem_2.grabFocus();
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
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification);
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
   			String vpara717 = "717";
  			String popupPanelActivateForPriceEdit = new getConfigurationSetting().getSpecificConfiguration(vpara717);
  			switch(popupPanelActivateForPriceEdit)
  			{
  				case "Y":
  					popupWindowForQtyPrice();
  					editqty.grabFocus();
  					break ;

  			}
 		}
  		SelectrowforEdit();
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
		Double newtax = new gnMath().CalTax_Sales(newAmount, vtax);
		String vmytax = Double.toString(newtax);

		table.setValueAt(newqty, i, 3);
		String vmygross = Double.toString(newgross);
		vmygross = new gnMath().get2DecimaltValue(vmygross);
		table.setValueAt(vmygross, i, 6);

		vmynetamt = Double.toString(newAmount);
		vmynetamt = new gnMath().get2DecimaltValue(vmynetamt);
		table.setValueAt(vmynetamt, i, 11);

		table.setValueAt(new gnMath().get2DecimaltValue(vmytax), i, 10);

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
					// TODO Auto-generated catch block
					e.printStackTrace();
					new gnLogger().loggerInfoEntry("Sale", "Distribution Exception" + " " + e.getLocalizedMessage());
				}
			}
		}
	}

	public void calHdrDisocunt() {

		// private String Col[] = { "Romove", 1"Item", 2"Name", 3"Qty", 4"Rate",
		// 5"MRP",6 "Gross",7 "m.Disc",8 "Bill Disc",9 "Disc",10 "Tax" ,
		// 11"Amount",12 "Taxcode", 13"Batch Item", 14"BatchNo",15 "Exp.Date",16
		// "Free(Qty)/Disc" };

		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 2, 300);

			Double itemtotal = new gnTable().getTotal(table, 6);
			Tamount.setText(new gnMath().get2DecimaltValue(Double.toString(itemtotal))); // Gross
																							// Amount

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
			double vnetAmt = xTamount - fhdrDiscount - vmanualdisc;
			int vnetAmtnew = (int) Math.round(vnetAmt);
			double vroundamt = (vnetAmtnew - vnetAmt);
			// froundAmt.setText(Double.toString(vroundamt));
			froundAmt.setText(new gnMath().get2DecimaltValue(Double.toString(vroundamt)));
			netAmount.setText(Integer.toString(vnetAmtnew));
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
		// getInvoiceNumberOnScan() ;
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
							rs.getString(14), rs.getString(15), rs.getString(23) });
			vdoccode = rs.getString(19);
			docname.setText(rs.getString(20));
			patientName.setText(rs.getString(21));
			custid.setText(rs.getString(22));
			table.setModel(model);
		}
		
		String vpara29 = "29" ;
		String veditAllow = new getConfigurationSetting().getSpecificConfiguration(vpara29);
		switch(veditAllow)
		{
			case "N":
				table.setEnabled(false);
				table.setBackground(Color.BLACK);
				table.setForeground(Color.white);
				
				scanItem_2.setEnabled(false);
				btn_Payment.setVisible(false);
				btn_Save.setVisible(false);
				break;
			case "Y":
				table.setEnabled(true);
				table.setBackground(Color.white);
				table.setForeground(Color.blue);
 				scanItem_2.setEnabled(true);
				btn_Payment.setVisible(true);
				btn_Save.setVisible(true);
				break;
 		}
  		new gnTable().setTableBasics(table);
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
		SelectrowforEdit();
  		return "OK";
 	} // ShowEdit TableData
 
	
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
					// new General().msg("row" +" "+editrow);
					QtychangeImapct(vcode, editrow);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}

	
 
	public void SelectrowforEdit() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
 				popupWindowForQtyPrice();
				try {
				} catch (Throwable e1) {
					e1.printStackTrace();//
					new General().Quickmsg("Edit Qty->:" + " " + e1.getLocalizedMessage());
					new gnLogger().loggerInfoEntry("POS", "Edit Qty->:" + " " + e1.getLocalizedMessage());
				} finally {
					try {
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().Quickmsg("Edit Qty:" + " " + e1.getLocalizedMessage());
						new gnLogger().loggerInfoEntry("POS", "Edit Qty->:" + " " + e1.getLocalizedMessage());
					}
				}
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
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
									int rowcnt = table.getRowCount();
									if (rowcnt > 0) {
										String vremark = "Record Removed";
										updateAuditRecord(vremark, r);
										String vcode = table.getValueAt(r, 1).toString();
										new gnLogger().loggerInfoEntry("POS",
												"----------------------------------------------------------------");
										new gnLogger().loggerInfoEntry("POS",
												"Item Remove From Sales Bill - Item Code" + vcode);
										new gnLogger().loggerInfoEntry("POS",
												"----------------------------------------------------------------");
										modelName.removeRow(r);
									}
									break;
								case "Y":
									String vremark = "Record Removed";
									updateAuditRecord(vremark, r);
									String vcode = table.getValueAt(r, 1).toString();
									new gnLogger().loggerInfoEntry("POS",
											"----------------------------------------------------------------");
									new gnLogger().loggerInfoEntry("POS",
											"  Item Remove From Sales Bill - Item Code " + vcode);
									new gnLogger().loggerInfoEntry("POS",
											"----------------------------------------------------------------");
									modelName.removeRow(r);
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
  			 				try {
   			 					discpercalculate(); //Recalclate and distribute disc after row remove
 							} catch (Throwable e1) {
 								e1.printStackTrace();
							}

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
		//DefaultCellEditor nk = new gnTable().cellEdit(stable);
		//nk.addCellEditorListener(ChangeNotification3);
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer Search View");
		prt6.setScrollMode(0);
		prt6.add(stable, Col);
		sjsp.setViewport(prt6);
		//new General().msgsearch(sjsp, stable, "Select Customer Code", 800, 300);
		new gnLogger().loggerInfoEntry("POS", "Selecting New Customer");
		SelectCustrow();
	}

	///NKALYANI
	

	public void SelectCustrow() {
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = stable.getSelectedRow();
				String vtype = (String) stable.getValueAt(row, 2);
				varticle = (String) stable.getValueAt(row, 2);
				try {
					showCustData();
 				} catch (Throwable e1) {
					e1.printStackTrace();
				}  
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Customer Code", 800, 300);
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
		scanItem_2.grabFocus();
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
				scanItem_2.grabFocus();
				return;
			}

			if (dues <= 0 && (Tamt == FTamt))

				// new General().msg("Processing Payment Save Action") ;
				DBaction = "DBFail";
			vvsitecode = Site_code.getText();
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
		String poshdr = "Insert into pos_sales_detail (company_code ," + "site_code, " + " invDate ," + "invno,"
				+ "Article_code ," + "EAN ," + "customer_code ," + "qty," + "sales_price," + "MRP," + "Taxcode,"
				+ "Gross_amount, " + "Disc," + "hdr_disc ," + "net_amount , " + "Tax_amount , " + "Promo_ind,"
				+ "promo_code," + "line_seq," + "CreatedBy, " + "Insert_status," + " Cashier_code, " // 22
				+ "Terminal_ID, shift , srno, tax_per, sales_type , "
				+ "batch_article, Batch_no, Expiry_date, cost, verticle, location ,"
				+ "state, statename, regdealer, mycompanyisgst, mygstno, mycompState, custGSTno , cgst, sgst, igst , movementType, "
				+ "TaxableValue, mystatename, finyear , cogs, freeArticle_disc , emp_disc)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?, ?, ?,?,?,?,?,?,? ,?,?, ?,?,?,?,?,?,?) ";
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
				prst.setString(28, table.getValueAt(k, 13).toString());
				prst.setString(29, table.getValueAt(k, 14).toString());
				prst.setString(30, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 15).toString()));

				String vbatchno = table.getValueAt(k, 14).toString();

				String vproductrcost = new gnArticle().Article_getData(table.getValueAt(k, 1).toString(), "AvgCost");
				if (vproductrcost.length() == 0) {
					vproductrcost = "0.00";
				}

				String vpara811 = "811";
				// String vmaintainbatchforNonBatchItem = new
				// getConfigurationSetting().getInitialConfig(vpara811,
				// vcomp,vstore);
				switch (vmaintainbatchforNonBatchItem) {
				case "N":
					vproductrcost = new gnArticle().Article_getData(table.getValueAt(k, 1).toString(), "AvgCost");
					if (vproductrcost.length() == 0) {
						vproductrcost = "0.00";
					}
					break;
				case "Y":
					vproductrcost = new gnBatch().getCostOfgivenBatch(vbatchno);
					if (vproductrcost.length() == 0) {
						vproductrcost = "0.00";
					}
					break;
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
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				vvggross = vvggross + Double.parseDouble(table.getValueAt(k, 6).toString());
				vvdisc = vvdisc + (Double.parseDouble(table.getValueAt(k, 7).toString())
						+ Double.parseDouble(table.getValueAt(k, 8).toString())
						+ Double.parseDouble(table.getValueAt(k, 9).toString()));
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

				if (promoModuleActivated == "Y") {
					insertPromoData();
				}
				insertPosHdr();
				// new General().msg("Verticle is:"+vverticle);
				if (vverticle.equals("5")) {
					// new General().msg("Calling Crop Store Method..");
					insertCropmappingDetails();
				}
				updatePostingStatusForScanData();
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
 				boolean deliveryRequired = homeDelivery.isSelected();
				if (deliveryRequired) {
					insertHomeDelivery();
				}
				  paymentCollection();
 				  calculateGSTReturnData();
			}
		}
	}//// Insert Heade End

	
 
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
		String pmswiggy = "Swiggy";
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
			new General().msg("Payment Data Not Inserted Properly ... ");
		}
		if (DBaction == "Sucess") {
			//btn_print.doClick();
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
		i = i+1;
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


//Home Delivery Insert 	
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
				// invno.setText( new gnBillUnhold().vinvno) ;
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
					// HereNk
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
		// Nitin Kale
		new General().Quickmsg("Saving Bill Data..");
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vtokenno = tokenno.getText();
		int vrow = table.getRowCount();
		if (vrow > 0) {
			if (POS == "0") {
				// getCurrentTableInfo();
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
					+ " custname, postype , company_code, site_code," + " phone, email, token ,  TotalAmount  , invno)"// total
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?) ";
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
					prst.setString(29, invno.getText());
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

	private void showTableOrder(ResultSet rs) throws Throwable {
		int curRow = table.getRowCount();
		if (curRow > 0) {
			new General().msg("Save Current Order First");
			return;
		} else {

			// getInvoiceNumberOnScan() ;

			while (rs.next()) {
				model.setColumnIdentifiers(Col);
				model.addRow(new Object[] { " ", rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
						rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17), "0 ", rs.getString(18),
						rs.getString(20), rs.getString(19) });
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

	private void activateNormalPOS() {
		POS = "1";
		JspPanel.setBounds(0, 0, 950, 532);
		jsp.setBounds(0, 0, 1325, 560);
		Dpanel.add(jsp);
		pos_hdr1.setVisible(true);
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
	private JTextField addr1;

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

		vvsitecode = Site_code.getText();
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
				+ "TaxableValue, mystatename, finyear , cogs, FreeArticle_Disc , Emp_disc)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?, ?, ?,?,?,?,?,?,? ,?,?, ?,?,?,?,?,?,?) ";
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

				// private String Col[] = { "Romove", 1"Item", 2"Name", 3"Qty",
				// 4"Rate", 5"MRP",6 "Gross",7 "m.Disc",8 "Bill Disc",9
				// "Disc",10 "Tax" ,
				// 11"Amount",12 "Taxcode", 13"Batch Item", 14"BatchNo",15
				// "Exp.Date",16 "Free(Qty)/Disc" };

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
				prst.setString(26, table.getValueAt(k, 12).toString());
				prst.setString(27, vvsales_type);
				// private String Col[] = { "Romove", 1"Item", 2"Name", 3"Qty",
				// 4"Rate", 5"MRP",6 "Gross",7 "m.Disc",8 "Bill Disc",9
				// "Disc",10 "Tax" ,
				// 11"Amount",12 "Taxcode", 13"Batch Item", 14"BatchNo",15
				// "Exp.Date",16 "Free(Qty)/Disc" };
				prst.setString(28, table.getValueAt(k, 13).toString());
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
																		// disc

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

			con1.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
				// new General().msg("Insert item master for Promo");
			}
			if (DBdetail == "Sucess") {
				// new General().msg("End Inserting Temp Data..");
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
 		
		/*Process  after payment button pressed in pos screen
		1.Clear Data in table for Free Articles 
		2.insert table Data in Tmp_pos_sales_data_promo table 
		3. collect Data for Promo check SP- Promo_collectData
		3.0 this sp will do following TAsk 
		3.1 in table tmp_promo_check Article Code With Brand And Hiearchy Will Insert with sum(qty) 
		 	and sum(value) summary will be Created Here 
		3.2 in table tmp_promo_brandhierarchy Summary for Brand , Category, Subcategry Summary Data 
		 	will be Insert 
		3.3 update TotalBillValue column in table with Current Bil toalBillValue for BillLevel promo check 
		 	 	
		4. After Sucessfully Data collection ApplyPromotion Eceution start applyPromoNow() method
		4.1 baseaction() Methid (SP promo_baseAction) will remove from tmp_pos_sales_detail for all freeArticles 
		4.2 PromoApplyontable (SP promo_applyontAble) will Do Following Action
		4.2.1 delete all record from prommo_applyontable table 
		4.2.2 insert in table tmp_pos_sales_detail table all Screen Data with Brand And Hierarchy
 		*/

		MarkForRemoveFreePromo();   ///
		
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
  		
			
		/*	
			//Monthly Promo Apply Starts Here 
			String isCustomerApplyforMonthpromo =  new gnSupplier().isCustomerApplyforMonthlyPromo(custid.getText());
			switch(isCustomerApplyforMonthpromo)
			{
				case "Y":
					String vcurbilldate    = new gnConfig().Date_convertToApplformat(invdate.getText());
 					String vpromostartdate = new gnSupplier().getCustomerMonthlyPromoStartdate(custid.getText()) ;
 					new gnPromoCheck().newApplyMonthlyPromotion(custid.getText(), vcurbilldate , vpromostartdate)   ;
				break ;
			}
  			//End Promo Monthly End here 
		*/
			
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

	
	
	class newcustLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
 			String vmobileno = mobile.getText();
			if (vmobileno.length() ==0 )
			{
				mobile.setText("0");
			}
			try {
			String vcode = "";
			String vname = "";
			String vmobile = "";
			String vaddr1 = "";
			String vaddr2 = "";
			String status = "Y";
			String vapplypromo = "Y" ;
			String vpromoStartdate=   new gnConfig().date_ConverttoDBforamt(invdate.getText());
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
					vaddr1 = addr1.getText();
					vaddr2 = "";
					custid.setText(new gnSupplier().getNewCustomerCode());
					vcode = custid.getText();
					new gnSupplier().SaveCustData(vcode, vname, vmobile, vaddr1, vaddr2, vapplypromo , vpromoStartdate);
					break;
				case "Y":
					vcode = custid.getText();
					vname = custname.getText().trim();
					vmobile = mobile.getText();
					vaddr1 = addr1.getText();
					vaddr2 = "";
 					new gnSupplier().updateCustData(vcode, vname, vmobile, vaddr1, vaddr2 );
					scanItem_2.grabFocus();
 				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				scanItem_2.grabFocus();
				btnSavecust.setBackground(Color.cyan);
				btnSavecust.setBackground(Color.BLACK);
  			}
		}
	}

	
	
	
	private void afterShortcutKeyExecute() throws ClassNotFoundException, SQLException {
		// new General().msg("item Search Callesd ");;
			new gnTable().RemoveTableRows(promomodel);
		scanItem_2.setEnabled(true);
		if (SelectionType == "Article") {
			scanItem_2.setEnabled(true);
		}
	    String sname = "123XYZZ"; ;
	    sname = "%"+sname+"%";
		String vverticlecode = new gnHierarchy().getVerticleCode() ; 
			String vtype = "Article";
	    String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
	    String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Pk.Size", "UOM" };
	    promomodel.setColumnIdentifiers(ACol);
		    
	    rs = this.getSPResult(SQL) ;
	    while(rs.next())
	    {
	    	promomodel.addRow(new Object[]{vtype, rs.getString(1), rs.getString(2), rs.getString(3),
	    			rs.getString(4), rs.getString(5),rs.getString(6)});
	    }

	    //promotable = new gnTableModel().ablemodel(promotable, promomodel, SQL, ACol, 6, "N", "Y", vtype);
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
	
	
	
//Edit Panel Starts Here 
	
	
	///automibile popup
	 	// New
		private void popupPanel() {
			
			try{
			panelPriceEdit = new JPanel();
			panelPriceEdit.setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.GREEN, null, null));
			panelPriceEdit.setBounds(11, 519, 206, 50);
	 		panelPriceEdit.setLayout(null);
	 		panelPriceEdit.setBackground(Color.white);
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

			JLabel lblNewLabel_1522 = new JLabel("Disc");
			lblNewLabel_1522.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1522.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_1522.setBounds(12, 95, 56, 16);
			panelPriceEdit.add(lblNewLabel_1522);


			JLabel lblNewLabel_1523 = new JLabel("BatchNo");
			lblNewLabel_1523.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1523.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_1523.setBounds(12, 118, 56, 16);
			panelPriceEdit.add(lblNewLabel_1523);

			JLabel lblNewLabel_15235 = new JLabel("Exp.Date");
			lblNewLabel_15235.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_15235.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_15235.setBounds(12, 141, 56, 16);
			panelPriceEdit.add(lblNewLabel_15235);
			
			
			//JLabel lblNewLabel_153 = new JLabel("Batchno");
			//lblNewLabel_153.setHorizontalAlignment(SwingConstants.RIGHT);
			//lblNewLabel_153.setFont(new Font("Tahoma", Font.BOLD, 11));
			//lblNewLabel_153.setBounds(12, 164, 56, 16);
			//panelPriceEdit.add(lblNewLabel_153);

			//JLabel lblNewLabel_154 = new JLabel("ExpDate");
			//lblNewLabel_154.setHorizontalAlignment(SwingConstants.RIGHT);
			//lblNewLabel_154.setFont(new Font("Tahoma", Font.BOLD, 11));
			//lblNewLabel_154.setBounds(12, 185, 56, 16);
			//panelPriceEdit.add(lblNewLabel_154);

			//JLabel lblNewLabel_155 = new JLabel("Controller No");
			//lblNewLabel_155.setHorizontalAlignment(SwingConstants.RIGHT);
			//lblNewLabel_155.setFont(new Font("Tahoma", Font.BOLD, 11));
			//lblNewLabel_155.setBounds(8, 204, 56, 16);
			//panelPriceEdit.add(lblNewLabel_155);

			//JLabel lblNewLabel_156 = new JLabel("Expiry Date");
			//lblNewLabel_156.setHorizontalAlignment(SwingConstants.RIGHT);
			//lblNewLabel_156.setFont(new Font("Tahoma", Font.BOLD, 11));
			//lblNewLabel_156.setBounds(12, 186, 56, 16);
			//panelPriceEdit.add(lblNewLabel_156);

			editqty = new JTextField();
			editqty.setBounds(80, 42, 130, 30);
			editqty.setColumns(10);
			panelPriceEdit.add(editqty);

			editrate = new JTextField();
			editrate.setBounds(80, 65, 130, 30);
			editrate.setColumns(10);
			panelPriceEdit.add(editrate);

 
			
			editdisc = new JTextField();
			editdisc.setBounds(80, 94, 130, 30);
			editdisc.setColumns(10);
			panelPriceEdit.add(editdisc);

 
 			editbatchno = new JTextField();
			editbatchno.setBounds(80,  114, 130, 30);
			editbatchno.setColumns(10);
			panelPriceEdit.add(editbatchno);
			
			
			editexpdate = new JTextField();
			editexpdate.setBounds(80,  138, 130, 30);
			editexpdate.setColumns(10);
			panelPriceEdit.add(editexpdate);
	 		

			ActionListener editls = new editLsnr();
			editrate.addActionListener(editls);
			editqty.addActionListener(editls);
			editdisc.addActionListener(editls);
			editexpdate.addActionListener(editls);
			editbatchno.addActionListener(editls);
    		

			KeyListener ky1 = new keyPressedlsnr();
	   		editqty.addKeyListener(ky1); 
			editrate .addKeyListener(ky1);
 	 		editdisc .addKeyListener(ky1);
			editexpdate.addKeyListener(ky1); 
			editbatchno.addKeyListener(ky1);
 
			
			}
			catch(Exception e)
			{
				new General().msg(e.getLocalizedMessage());
			}
	 	}

		
		
		private void popupWindowForQtyPrice() {
		 
			popupPanel() ;
  			 // { "X", 1"Item", 
			//		2"Name", 3"Qty", 4"Rate", 5"MRP", 6"Gross", 7"Disc Item", 8"Bill Disc", 9"Disc",
			//		10"Tax", 11"Amount", 12"Tax%", 13"Batch(Y/N)", 14"BatchNo", 15"ExpDate", 16"Free(Qty)/Disc" };
 			editrow = table.getSelectedRow();
			String vqty = (table.getValueAt(editrow, 3).toString());
			String vrate = (String) table.getValueAt(editrow, 4);
			String vcode = (String) table.getValueAt(editrow, 1);
			String vname = (String) table.getValueAt(editrow, 2);
			String vdisc = (String) table.getValueAt(editrow, 7);
			String vbatchno = (String) table.getValueAt(editrow, 13);
	 		String vexpdate = (String) table.getValueAt(editrow, 14);
 
			try {
				editQtyPrice(vcode, vname, vqty, vrate, vdisc,  vbatchno , vexpdate );
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

		private void editQtyPrice(String vcode, String vname, String vqty, String vrate, String vdisc,  
			String vbatchno, String vexpdate ) {
	    	panelPriceEdit.setBounds(21, 86, 275, 100);
 			editcode.setText(vcode);
			editname.setText(vname);
			editrate.setText(vrate);
			editqty.setText(vqty);
			editdisc.setText(vdisc);
	 		editbatchno.setText(vbatchno);
	 		editexpdate.setText(vexpdate);
  	 		Dpanel.add(panelPriceEdit);
 	 		editqty.requestFocus();
			editqty.grabFocus();
			new General().msgPanel(panelPriceEdit, "Edit Price and Qty", 350, 350);
			new gnLogger().loggerInfoEntry("POS", "Edit Price and Qty Called");
		}

	
	
	
	
	
	

		class keyPressedlsnr implements KeyListener {
			@Override
			public void keyPressed(KeyEvent e) {
				int value = e.getKeyCode();
				// new General().Quickmsg("Key Pressed "+ value);
				switch (value) {
				case 10:

					if (editqty.isFocusOwner()) {
						editrate.grabFocus();
					}

					if (editrate.isFocusOwner()) {
						editdisc.grabFocus();
					}

					if (editdisc.isFocusOwner()) {
						editbatchno.grabFocus();
					}
					
					if (editbatchno.isFocusOwner()) {
						editexpdate.grabFocus();
					}
 	  
					if (editexpdate.isFocusOwner()) {
						new General().msgDispose();
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

	
	
		
		
//Customer Search Starts Here 
		
		
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
 				}
			});
		}

		
		
////Customer Search End here 		
	
	
	
}// Last

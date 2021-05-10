package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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
import java.sql.SQLException;
import java.sql.Time;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
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
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import RetailProduct.CustomerMaster.btnfocus;
import RetailProduct.CustomerMaster.keyPressedlsnr;
import RetailProduct.POS.editLsnr;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JSplitPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DropMode;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class GRNModule extends getResultSet {

	private Connection con, con1, con2, con3, con4, con5, con6, con7, con8;
	public static String EditMode = "N";
	String vmylinetax;
	String vfinyear;
	private JLabel lblNewLabel_10;
	private JTextField basePurchasePrice;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField discper;
	private JScrollPane njsp;
	private JPanel panel_1;
	private JPanel Dpanel;
	private JLabel lblNewLabel_35;
 
	private JTextField brandcode;
	private JTextField purrate;
	private JTextField purqty;
	private JPanel panelPriceEdit;
	private JTextField vpurchaseUOM;
	private JTextField vinnerqty;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JComboBox purchasetype;
	private JTextField pono;
	private JTextField podate;
	private JButton btnPrice;
	private JTextField totalqty;
	private JLabel lblNewLabel_24;
	private JTextField totaldisc;
	private JLabel lblNewLabel_25;
	private JTextField otherCharges;
	private JButton btnDayBook;
	private JTextField naration;
	private JLabel lblNewLabel_28;
	private JLabel Privoiusamt;
	private JLabel lblNewLabel_29;
	private JLabel lblNewLabel_30;
	private JLabel lblcost;
	private JLabel lblNewLabel_31;
	private JLabel lblqty;
	private JLabel jkkk;
	private JLabel lblmrp;
	private JLabel lblNewLabel_32;
	private JLabel lblsp;
	private JLabel lblNewLabel_33;
	private JLabel lblLC;
	private JTextField changerate;
	private JTextField changeqty;
	private JTextField chnagemrp;
	private JTextField chnagesp;
	private JButton btnCalc;
	private JLabel lblNewLabel_38;
	private JLabel lblNewLabel_39;
	private JLabel lblNewLabel_27;
	private JLabel lblNewLabel_40;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_41;
	private JTextField xbatchno;
	private JTextField xexpdate;

	JCheckBox chkbox1;
	String QueryStatus = "N";
	String calculateTaxonOthchrg = "N";
	// JSplitPane mysplit;
	int selectedrow;
	JLabel lastSupplier;
	String purchaseType1;
	JComboBox grntype;
	String vppono;
	String vpodate;
	JPanel popanel;
	JButton btnPayment;

	int editrow;
	JButton btnArticleInfo;
	JLabel editname;
	JLabel editcode;
	JComboBox puruom;

	JTextField editqty = new JTextField();
	JTextField edituom = new JTextField();
	JTextField editinnerqty = new JTextField();
	JTextField editrate = new JTextField();
	JTextField editdisc = new JTextField();
	JTextField editdiscper = new JTextField();
	JTextField editchesseno = new JTextField();
	JTextField editcontrollerno = new JTextField();
	JTextField editmotorno = new JTextField();
	JTextField editbatchno = new JTextField();
	JTextField editexpdate = new JTextField();
	JTextField editmrp = new JTextField();
	JTextField editsp = new JTextField();

	// JPanel panelPriceEdit ;

	private String vstore;
	private JTextField creditDays;
	private JTextField searchbrand;
	public static String varticle;
	private JButton btnPrint;
	public static JButton btnEdit;
	String vallow;
	private JButton btnAcEntry;
	private JTextField roundingamt;
	private JButton BtnInfo;
	private String vglcode;
	private String advdate;
	String vscheme;
	private String vadvno;
	private JLabel companyname;
	JCheckBox sez;
	JCheckBox importgoods;
	private JButton btnClose;
	private JButton btnSave;
	private JButton btnBarcode;
	private String vverticle;
	private String vcomp;
	private JTextField companycode;
	private JTextField mobile;
	private JTextField email;

	private JTextField statecode;
	private JRadioButton rb99;
	String vlocation = "SL";
	private JTextField statename;
	private JTextField regdlr;
	private JTextField advno;
	public static JTextField disc;
	JButton btnCalculator;

	private JTextField approvedby;
	private JTextField approvedate;
	private JCheckBox approve;
	int x;
	int y;

	// GST
	private String vmygstno;
	private String vmycompanystate;
	private String vmystatename;
	private String vmyCompanyisGST;

	private String vstate;
	private String vstatename;
	private String vregdlr;
	private String vcustGSTno;
	private String vmovtype;
	private Double vtaxamount;
	JLabel dispname;

	// approve related
	private String vapprove;
	private String vapprovedby;
	private String vapprovedate;
	private String vsgrnno;
	private String vstorecode;
	private String vgrnDate;
	private int vgrnno;
	private String vduedate;
	private int vpono;
	private String vtype = "WP";
	private int vvendor;
	private String vinvno;
	private String vinvDate;
	private Double vinvamt;
	private Double vcostvalue;
	String vmyarticle;
	private Double vothcharges;
	private Double vtotalamount;
	private String choice;
	private JCheckBox chrevcgrg;
	private String vreversechrg;
	private String vcreateBy = "Admin";
	private String vupdateDate;
	private int vcreditDays;
	private int TotalRecordinsert = 0;
	private String DBaction = "Fail";
	private String DBhdr = "Fail";
	private String DBdetail = "Fail";
	private String DBstock = "Fail";
	private String DBstockDetail = "Fail";
	private String DBsalesPrice = "Fail";
	private String DBean = "Fail";
	private JTextField vexpedtr;
	private JTextField vmafdate;
	private String vimport;
	private String vsez;
	Double vtaxablevalue;

	/// end table Varibales
	private JTextField scanName;
	public JInternalFrame internalFrame;
	JFrame GRNModuleFrame;
	private JTextField grndate;
	private JTextField grnno;
	private JTextField VendorCode;
	private JTextField VendorName;
	private JTextField InvoiceNumber;
	private JTextField InvoiceDate;
	private JTextField TotalAmount;
	private JTextField mytaxamount;
	private JLabel lblNewLabel_9;
	private JTextField purchasePostingAmount;

	private JTextField InvAmt;
	private JTextField scanItem;
	private JTextField records;
	private JTextField Storecode;
	private JTextField storename;
	private JTextField SupplierPayable;
	private JTextField Othcharges;
	// For Customer Search
	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();

	public String SCol[] = { "Type", "Customer code", "Name", "Phone", "Email", "Credit Days" };
	public JViewport prt6 = new JViewport();
	public JScrollPane sjsp;

	String PoCol[] = { "Type", "Article_code", "Name", "UOM", "InvQty", "Recd.Qty", "Rate", "Base Value ", "Line Disc.",
			"Disc", "PurValue", "Tax%", "Tax.Amt", "Pur.Incl Tax", "Oth.Chrg", "Landing Cost", "Bal Qty",
			"17 Batch_Control", "18 Batch No", "19 Expiry date", "POQty", "MRP", "SP", "LC-PerUnit", "FreeQty" };

	// For Item Name Search
	public DefaultTableModel nmodel = new DefaultTableModel();
	public JTable ntable = new JTable();
	public String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost" };

	DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {

			return column == 0 || column == 3 || column == 4 || column == 5 || column == 06 || column == 8
					|| column == 11 || column == 14 || column == 18 || column == 19 || column == 21 || column == 22
					|| column == 24 ? true : false;
		}
	};

	public DefaultTableModel pmodel = new DefaultTableModel();

	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			// return column == 0 || column == 3 || column == 4 || column == 06
			// || column==8 || column==11 || column == 18 || column == 19 true :
			// false;

			if (column == 0 || column == 3 || column == 4 || column == 5 || column == 06 || column == 8 || column == 11
					|| column == 14 || column == 18 || column == 19 || column == 21 || column == 22 || column == 24) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.BOLD, 12));
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 12));
			}

			if (column == 7 || column == 8 || column == 9 || column == 15) {

				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
			}

			if (Language == "H") {
				if (column == 2) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}

			if (column == 5) {
				componentt.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
				componentt.setBackground(Color.BLACK);
				componentt.setForeground(Color.yellow);

			}

			return componentt;
		}
	};

	///

	// public JTable ptable = new JTable() ;
	public JScrollPane jsp;

	public String[] Col = { "Article Code", "Article_Name", "Qty", "UOM", "Basic Cost", "Cost_value", "Transportation",
			"Manuf,cost", "Packing Cost", " Landing Cost" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GRNModule window = new GRNModule();
					window.GRNModuleFrame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
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
	public GRNModule() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		JFrame.setDefaultLookAndFeelDecorated(true);
		GRNModuleFrame = new JFrame();
		GRNModuleFrame.getContentPane().setBackground(Color.WHITE);
		GRNModuleFrame.setResizable(false);
		GRNModuleFrame.setAlwaysOnTop(true);
		GRNModuleFrame.setTitle("Business Application");
		// GRNModuleFrame.setBounds(0, 0, 1370, 697);
		GRNModuleFrame.setBounds(1, 90, 1370, 697);

		GRNModuleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GRNModuleFrame.getContentPane().setLayout(null);

		ActionListener abc = new lsBtn();
		String compName = new gnConfig().getCompany();

		/*
		 * internalFrame = new JInternalFrame(compName);
		 * internalFrame.setFrameIcon(new ImageIcon(GRNModule.class.getResource(
		 * "/RetailProduct/mymainlogo_2.png")));
		 * GRNModuleFrame.getContentPane().setBackground(new Color(51, 255,
		 * 255)); internalFrame.setBounds(0, 0, 1370, 768);
		 * GRNModuleFrame.getContentPane().add(internalFrame);
		 * GRNModuleFrame.getContentPane().setLayout(null);
		 */

		JPanel panel = new JPanel();
		panel.setToolTipText("GRN Basic Inforamtion Display Panel");
		panel.setForeground(new Color(240, 255, 255));
		panel.setBackground(new Color(255, 255, 255));

		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), " ", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 153)));
		panel.setBounds(12, 0, 541, 221);
		GRNModuleFrame.getContentPane().add(panel);
		panel.setLayout(null);

		VendorCode = new JTextField();

		VendorCode.setFont(new Font("Arial", Font.BOLD, 15));
		VendorCode.setForeground(new Color(0, 0, 51));
		VendorCode.setBackground(new Color(255, 255, 255));
		VendorCode.setToolTipText("Enter Vendor Vcode if you Know");
		VendorCode.setBounds(12, 108, 61, 30);
		panel.add(VendorCode);
		VendorCode.setColumns(10);
		ActionListener lscust = new lscust();
		VendorCode.addActionListener(lscust);

		VendorName = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		VendorName.setOpaque(false);
		// VendorName.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		// VendorName.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		VendorName.setFont(new Font("Arial", Font.BOLD, 15));
		VendorName.setForeground(new Color(0, 0, 51));
		VendorName.setBackground(new Color(255, 255, 255));

		VendorName.setToolTipText("Enter Start Latters to Search Supplier");
		VendorName.setBounds(75, 108, 289, 30);

		panel.add(VendorName);
		VendorName.setColumns(10);
		ActionListener supl = new lsnrCustName();
		VendorName.addActionListener(supl);

		JLabel lblVendorCode = new JLabel("*Supplier Code");
		lblVendorCode.setForeground(new Color(0, 0, 51));
		lblVendorCode.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lblVendorCode.setBounds(12, 80, 117, 25);
		panel.add(lblVendorCode);
		ActionListener grnsearch = new grnno();

		;

		JLabel lblCreditDaya = new JLabel("Cr.Days");
		lblCreditDaya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditDaya.setForeground(new Color(0, 0, 51));
		lblCreditDaya.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lblCreditDaya.setBounds(5, 146, 68, 16);
		panel.add(lblCreditDaya);

		creditDays = new JTextField();
		creditDays.setOpaque(false);
		creditDays.setToolTipText("Credit Days of Supplier");
		creditDays.setEditable(false);
		creditDays.setBackground(new Color(153, 255, 255));
		creditDays.setBounds(83, 142, 55, 25);
		panel.add(creditDays);
		creditDays.setFont(new Font("Tahoma", Font.BOLD, 12));
		creditDays.setForeground(new Color(0, 0, 102));
		creditDays.setColumns(10);

		mobile = new JTextField();
		mobile.setFont(new Font("Tahoma", Font.BOLD, 12));
		mobile.setForeground(new Color(0, 0, 102));
		mobile.setEditable(false);
		mobile.setBackground(new Color(153, 255, 255));
		mobile.setBounds(133, 142, 128, 25);
		panel.add(mobile);
		mobile.setColumns(10);

		email = new JTextField();
		email.setToolTipText("Supplier Email Address");
		email.setFont(new Font("Tahoma", Font.BOLD, 12));
		email.setForeground(new Color(0, 0, 102));
		email.setEditable(false);
		email.setBackground(new Color(153, 255, 255));
		email.setBounds(258, 165, 268, 25);
		panel.add(email);
		email.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("State ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(12, 169, 61, 16);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(0, 0, 51));
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));

		statecode = new JTextField();
		statecode.setToolTipText("Supplier Sate Code");
		statecode.setFont(new Font("Tahoma", Font.BOLD, 12));
		statecode.setForeground(new Color(0, 0, 102));
		statecode.setBounds(83, 165, 55, 25);
		panel.add(statecode);
		statecode.setEditable(false);
		statecode.setBackground(new Color(153, 255, 255));
		statecode.setColumns(10);

		statename = new JTextField();
		statename.setToolTipText("Supplier Name");
		statename.setFont(new Font("Tahoma", Font.BOLD, 12));
		statename.setForeground(new Color(0, 0, 102));
		statename.setBounds(137, 165, 124, 25);
		panel.add(statename);
		statename.setEditable(false);
		statename.setBackground(new Color(153, 255, 255));
		statename.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("GST Reg.Dlr");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNewLabel_5.setForeground(new Color(0, 0, 51));
		lblNewLabel_5.setBounds(248, 147, 82, 16);
		panel.add(lblNewLabel_5);

		regdlr = new JTextField();
		regdlr.setFont(new Font("Calibri", Font.PLAIN, 13));
		regdlr.setBounds(334, 146, 30, 21);
		panel.add(regdlr);
		regdlr.setEditable(false);
		regdlr.setBackground(new Color(255, 255, 255));
		regdlr.setColumns(10);

		chrevcgrg = new JCheckBox("Reverse Charge");
		chrevcgrg.setToolTipText("Reverse charge Applicable for Non GST Registered Supplier");
		chrevcgrg.setBackground(Color.WHITE);
		chrevcgrg.setFont(new Font("Arial", Font.BOLD, 11));
		chrevcgrg.setForeground(Color.BLACK);
		chrevcgrg.setBounds(373, 143, 153, 25);
		panel.add(chrevcgrg);

		JLabel lblGrnNumber = new JLabel("GR Number");
		lblGrnNumber.setBounds(359, 89, 89, 16);
		panel.add(lblGrnNumber);
		lblGrnNumber.setForeground(new Color(0, 0, 51));
		lblGrnNumber.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblGrnNumber.setHorizontalAlignment(SwingConstants.RIGHT);

		grnno = new JTextField();
		grnno.setEditable(false);
		grnno.setBounds(367, 108, 81, 30);
		panel.add(grnno);
		grnno.setForeground(Color.WHITE);
		grnno.setFont(new Font("Arial", Font.BOLD, 14));
		grnno.setBackground(new Color(0, 0, 102));
		grnno.setToolTipText("Goods Receive Number");
		grnno.setColumns(10);

		grndate = new JTextField();
		grndate.setBounds(442, 108, 93, 30);
		panel.add(grndate);
		grndate.setForeground(Color.WHITE);
		grndate.setFont(new Font("Arial", Font.BOLD, 14));
		grndate.setBackground(new Color(0, 0, 102));
		grndate.setEditable(false);
		grndate.setToolTipText("Goods Receive Date ");
		grndate.setColumns(10);

		grntype = new JComboBox();
		grntype.setToolTipText("Select Type Here If Goods Receive Against Purcase Order then Select WITH PO Option");
		grntype.setBackground(Color.WHITE);
		grntype.setForeground(Color.BLACK);
		grntype.setFont(new Font("Tahoma", Font.PLAIN, 12));
		grntype.setModel(new DefaultComboBoxModel(new String[] { "Without PO", "With PO" }));
		grntype.setBounds(141, 26, 128, 25);
		panel.add(grntype);

		lblNewLabel_18 = new JLabel("TYPE");
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_18.setBounds(12, 3, 56, 16);

		lblNewLabel_19 = new JLabel("Purchase Type");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setForeground(new Color(0, 0, 51));
		lblNewLabel_19.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblNewLabel_19.setBounds(141, 7, 98, 21);
		panel.add(lblNewLabel_19);

		purchasetype = new JComboBox();
		purchasetype.setToolTipText("Select Type Here If Cash Purchase then Select Cash Purchase OR Credit Purchase");
		purchasetype.setBackground(Color.WHITE);
		purchasetype.setForeground(Color.BLACK);
		purchasetype.setFont(new Font("Tahoma", Font.PLAIN, 12));
		purchasetype.setModel(new DefaultComboBoxModel(new String[] { "Credit Purchase", "Cash Purchase" }));
		purchasetype.setBounds(142, 70, 130, 25);
		panel.add(purchasetype);

		popanel = new JPanel();
		popanel.setBackground(Color.CYAN);
		popanel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 102), null, null, null));
		popanel.setToolTipText("PO NO Selection Panel");
		popanel.setBounds(337, 7, 198, 54);
		panel.add(popanel);
		popanel.setLayout(null);

		JLabel lblNewLabel_20 = new JLabel("PO.NO");
		lblNewLabel_20.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_20.setForeground(Color.DARK_GRAY);
		lblNewLabel_20.setBounds(5, 0, 56, 16);
		popanel.add(lblNewLabel_20);

		pono = new JTextField();
		pono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pono.setText("0");
		pono.setToolTipText("Press Enter to select PO.NO");
		pono.setBounds(5, 17, 78, 22);
		popanel.add(pono);
		pono.setColumns(10);

		JLabel lblNewLabel_21 = new JLabel("PO.Date");
		lblNewLabel_21.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_21.setForeground(Color.DARK_GRAY);
		lblNewLabel_21.setBounds(98, 0, 98, 16);
		popanel.add(lblNewLabel_21);

		podate = new JTextField();
		podate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		podate.setBackground(Color.WHITE);
		podate.setToolTipText("PO.Date ");
		podate.setEditable(false);
		podate.setBounds(95, 17, 78, 22);
		popanel.add(podate);
		podate.setColumns(10);

		lblNewLabel_28 = new JLabel("GR Date");
		lblNewLabel_28.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_28.setForeground(new Color(0, 0, 51));
		lblNewLabel_28.setBounds(460, 88, 69, 16);
		panel.add(lblNewLabel_28);

		lblNewLabel_38 = new JLabel("Payment Type");
		lblNewLabel_38.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		lblNewLabel_38.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_38.setForeground(new Color(0, 0, 51));
		lblNewLabel_38.setBounds(137, 51, 98, 22);
		panel.add(lblNewLabel_38);

		lblNewLabel_27 = new JLabel("Purchase Goods");
		lblNewLabel_27.setForeground(Color.BLACK);
		lblNewLabel_27.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_27.setBounds(14, 30, 124, 37);
		panel.add(lblNewLabel_27);

		lblNewLabel_40 = new JLabel("-");
		lblNewLabel_40.setIcon(new ImageIcon(GRNModule.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_40.setBounds(5, 7, 130, 73);
		panel.add(lblNewLabel_40);

		// searchbrand = new JTextField();
		searchbrand = new gnRoundTextField(12);
		searchbrand.setBounds(374, 190, 129, 28);
		panel.add(searchbrand);
		searchbrand.setHorizontalAlignment(SwingConstants.CENTER);
		searchbrand.setFont(new Font("Agency FB", Font.PLAIN, 18));
		searchbrand.setToolTipText("Select Brand To Add Items in Purchase ");
		searchbrand.setForeground(new Color(0, 102, 204));
		searchbrand.setColumns(10);

		brandcode = new JTextField();
		brandcode.setBounds(505, 190, 24, 28);
		panel.add(brandcode);
		brandcode.setBackground(Color.WHITE);
		brandcode.setEnabled(false);
		brandcode.setColumns(10);

		grnno.addActionListener(grnsearch);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { VendorName }));
		ActionListener aprv = new approve();
		ActionListener lkk = new lsBtn();

		sjsp = new JScrollPane();
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(0, 0, 1345, 156);
		// panel_2.add(sjsp);
		ActionListener lsart = new lsarticle();

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(245, 255, 250));
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(12, 219, 1346, 62);
		GRNModuleFrame.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		// scanItem = new JTextField();
		scanItem = new gnRoundTextField(12);
		scanItem.setOpaque(false);
		scanItem.setHorizontalAlignment(SwingConstants.LEFT);
		scanItem.setFont(new Font("Arial", Font.BOLD, 15));
		scanItem.setForeground(new Color(0, 0, 153));
		scanItem.setBackground(Color.white);
		scanItem.setDragEnabled(true);
		scanItem.setBounds(10, 18, 190, 28);
		scanItem.setToolTipText("Enter Item code if you know OR Search For Item Name");
		panel_5.add(scanItem);
		scanItem.setColumns(10);

		JLabel lblScanArticleHere = new JLabel("Search by Name");
		lblScanArticleHere.setBounds(0, 0, 130, 17);
		lblScanArticleHere.setFont(new Font("Arial", Font.BOLD, 13));
		lblScanArticleHere.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScanArticleHere.setForeground(new Color(0, 0, 153));
		panel_5.add(lblScanArticleHere);
		ActionListener grnsave = new lsBtn();

		// Othcharges = new JTextField();
		Othcharges = new gnRoundTextField(12);
		Othcharges.setBounds(808, 28, 77, 28);
		panel_5.add(Othcharges);
		Othcharges.setForeground(new Color(0, 0, 0));
		Othcharges.setHorizontalAlignment(SwingConstants.CENTER);
		Othcharges.setToolTipText("Enter Other Charges If Required ");
		Othcharges.setFont(new Font("Arial", Font.BOLD, 15));
		Othcharges.setBackground(new Color(255, 255, 255));
		Othcharges.setText("0.00");
		Othcharges.setColumns(10);

		JLabel lblNewLabel_22 = new JLabel("Oth.Charg");
		lblNewLabel_22.setForeground(new Color(0, 0, 153));
		lblNewLabel_22.setBounds(808, 8, 80, 17);
		lblNewLabel_22.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.LEFT);
		panel_5.add(lblNewLabel_22);

		// changerate = new JTextField();
		changerate = new gnRoundTextField(12);
		changerate.setToolTipText(
				"Enter Purchase Rate<Excl Tax%.> As per Supplier Invoice < Please check Supplier Rates [Rates are Inclusive of Tax OR Exclusive of Tax]");
		changerate.setHorizontalAlignment(SwingConstants.CENTER);
		changerate.setFont(new Font("Arial", Font.BOLD, 15));
		changerate.setForeground(new Color(0, 0, 153));
		changerate.setBackground(Color.WHITE);
		changerate.setBounds(272, 18, 66, 28);
		panel_5.add(changerate);
		changerate.setColumns(10);

		// changeqty = new JTextField();
		changeqty = new gnRoundTextField(12);
		changeqty.setToolTipText("Enter Actual Received Quantity");
		changeqty.setHorizontalAlignment(SwingConstants.CENTER);
		changeqty.setFont(new Font("Arial", Font.BOLD, 15));
		changeqty.setForeground(new Color(0, 0, 153));
		changeqty.setBackground(Color.WHITE);
		changeqty.setBounds(202, 18, 66, 28);
		panel_5.add(changeqty);
		changeqty.setColumns(10);

		// chnagemrp = new JTextField();
		chnagemrp = new gnRoundTextField(12);
		chnagemrp.setToolTipText("Enter MRP As per Supplier Invoice ");
		chnagemrp.setHorizontalAlignment(SwingConstants.CENTER);
		chnagemrp.setFont(new Font("Arial", Font.BOLD, 15));
		chnagemrp.setBounds(341, 18, 56, 28);
		panel_5.add(chnagemrp);
		chnagemrp.setColumns(10);

		// chnagesp = new JTextField();
		chnagesp = new gnRoundTextField(12);
		chnagesp.setToolTipText("Enter Sales Price In Case If you Want to Change");
		chnagesp.setHorizontalAlignment(SwingConstants.CENTER);
		chnagesp.setFont(new Font("Arial", Font.BOLD, 15));
		chnagesp.setBounds(401, 17, 56, 28);
		panel_5.add(chnagesp);
		chnagesp.setColumns(10);

		// btnClose = new JButton("Close ");
		btnClose = new gnRoundButton("Close ");
		btnClose.setBounds(1268, 0, 77, 62);
		panel_5.add(btnClose);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setSelectedIcon(null);
		btnClose.setIcon(null);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GRNModuleFrame.dispose();
			}
		});
		btnClose.setBackground(Color.WHITE);
		btnClose.setForeground(new Color(0, 0, 102));
		btnClose.setMnemonic('C');

		panel_1 = new JPanel();
		panel_1.setBounds(555, 0, 253, 60);
		panel_5.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Bill Discount", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Disc.Amt");
		lblNewLabel_7.setBounds(99, 10, 72, 17);
		panel_1.add(lblNewLabel_7);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setForeground(new Color(0, 0, 153));
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 13));

		// disc = new JTextField();
		disc = new gnRoundTextField(12);
		disc.setBounds(99, 27, 88, 29);
		panel_1.add(disc);
		disc.setForeground(new Color(0, 0, 0));
		disc.setBackground(new Color(255, 255, 255));
		disc.setHorizontalAlignment(SwingConstants.CENTER);
		disc.setToolTipText("Enter Discount Amount on Purchase Value");
		disc.setFont(new Font("Arial", Font.BOLD, 15));
		disc.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Disc%");
		lblNewLabel_11.setBounds(201, 10, 48, 15);
		panel_1.add(lblNewLabel_11);
		lblNewLabel_11.setForeground(new Color(0, 0, 153));
		lblNewLabel_11.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);

		// discper = new JTextField();
		discper = new gnRoundTextField(12);
		discper.setBounds(199, 27, 50, 28);
		panel_1.add(discper);
		discper.setToolTipText("Enter Discount % For giving discount on purchase value");
		discper.setHorizontalAlignment(SwingConstants.CENTER);
		discper.setFont(new Font("Arial", Font.BOLD, 15));
		discper.setColumns(10);

		// btnSave = new JButton("Save-F8");
		btnSave = new gnRoundButton("Save-F8");
		btnSave.setBounds(1177, 0, 92, 62);
		panel_5.add(btnSave);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setSelectedIcon(new ImageIcon(GRNModule.class.getResource("/RetailProduct/btnApsave1.png")));
		btnSave.setIcon(null);
		btnSave.setMnemonic('S');
		btnSave.setForeground(new Color(0, 0, 102));
		btnSave.setBackground(Color.WHITE);

		Dpanel = new JPanel();
		Dpanel.setBackground(Color.WHITE);
		Dpanel.setBounds(539, 0, 16, 62);
		panel_5.add(Dpanel);
		Dpanel.setLayout(null);
		btnSave.addActionListener(grnsave);
 
		// ActionListener btn = new lsBtn();
		// BtnInfo.addActionListener(grnsave);

		ActionListener bnd = new lsnrbrand();

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLUE);
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.CYAN, Color.RED));
		panel_6.setBounds(12, 31, 1345, -8);
		GRNModuleFrame.getContentPane().add(panel_6);
		panel_6.setLayout(null);

		companycode = new JTextField();
		companycode.setForeground(new Color(0, 0, 0));
		companycode.setFont(new Font("Calibri", Font.BOLD, 13));
		companycode.setBackground(new Color(255, 255, 255));
		companycode.setEditable(false);
		companycode.setBounds(105, 25, 83, 25);
		GRNModuleFrame.getContentPane().add(companycode);
		companycode.setColumns(10);

		companyname = new JLabel("");
		companyname.setFont(new Font("Calibri", Font.BOLD, 13));
		companyname.setBackground(new Color(240, 255, 240));
		companyname.setForeground(new Color(255, 255, 255));
		companyname.setBounds(192, 30, 342, 16);
		GRNModuleFrame.getContentPane().add(companyname);

		JPanel panel_3 = new JPanel();
		panel_3.setToolTipText("Supplier Bill Information Display Panel");
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(847, 25, 511, 192);
		GRNModuleFrame.getContentPane().add(panel_3);
		panel_3.setForeground(new Color(0, 0, 102));
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Supplier Payment Details",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 51, 51)));
		panel_3.setLayout(null);

		// TotalAmount = new JTextField();
		TotalAmount = new gnRoundTextField(12);
		TotalAmount.setBounds(14, 158, 128, 29);
		TotalAmount.setHorizontalAlignment(SwingConstants.CENTER);
		TotalAmount.setForeground(Color.WHITE);
		TotalAmount.setBackground(new Color(0, 0, 102));
		TotalAmount.setText("0.00");
		TotalAmount.setFont(new Font("Arial", Font.BOLD, 21));
		panel_3.add(TotalAmount);
		TotalAmount.setToolTipText("Total Amount Payable to Supplier");
		TotalAmount.setEditable(false);
		TotalAmount.setColumns(10);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(-16, 0, 17, 25);
		panel_3.add(btnNewButton_1);

		SupplierPayable = new JTextField();
		SupplierPayable.setBounds(345, 109, 150, 25);
		SupplierPayable.setForeground(Color.WHITE);
		SupplierPayable.setHorizontalAlignment(SwingConstants.RIGHT);
		SupplierPayable.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		SupplierPayable.setBackground(Color.BLACK);
		SupplierPayable.setText("0.00");
		SupplierPayable.setEditable(false);
		panel_3.add(SupplierPayable);
		SupplierPayable.setColumns(10);

		JLabel lblTotalAmount = new JLabel("Amount");
		lblTotalAmount.setBounds(28, 138, 98, 23);
		lblTotalAmount.setForeground(Color.DARK_GRAY);
		lblTotalAmount.setToolTipText("Rounding Amount");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalAmount.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(lblTotalAmount);

		JLabel lblSupplierPayment = new JLabel("Amt incl.Tax");
		lblSupplierPayment.setBounds(181, 114, 146, 16);
		lblSupplierPayment.setForeground(new Color(0, 0, 51));
		lblSupplierPayment.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblSupplierPayment.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblSupplierPayment);

		JLabel lblNoofRecords = new JLabel("Records");
		lblNoofRecords.setBounds(27, 30, 99, 35);
		lblNoofRecords.setForeground(Color.DARK_GRAY);
		lblNoofRecords.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_3.add(lblNoofRecords);
		lblNoofRecords.setHorizontalAlignment(SwingConstants.LEFT);

		// records = new JTextField();
		records = new gnRoundTextField(20);
		records.setToolTipText("No.Of Purchase Records ");

		records.setHorizontalAlignment(SwingConstants.CENTER);
		records.setForeground(Color.WHITE);
		records.setBounds(14, 55, 128, 27);
		records.setFont(new Font("Arial", Font.BOLD, 21));
		records.setBackground(Color.BLACK);
		panel_3.add(records);
		records.setText("0");
		records.setEditable(false);
		records.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Rounding Amt");
		lblNewLabel_8.setBounds(211, 167, 115, 16);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_8.setForeground(new Color(0, 0, 51));
		panel_3.add(lblNewLabel_8);

		roundingamt = new JTextField();
		roundingamt.setToolTipText("Rounding Diff Amount");
		roundingamt.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		roundingamt.setEditable(false);
		roundingamt.setBounds(345, 162, 150, 25);
		roundingamt.setForeground(Color.WHITE);
		roundingamt.setBackground(Color.BLACK);
		roundingamt.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(roundingamt);
		roundingamt.setColumns(10);

		JLabel lblNewLabel = new JLabel("Tax Amount");
		lblNewLabel.setBounds(211, 90, 115, 16);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 51));
		panel_3.add(lblNewLabel);

		mytaxamount = new JTextField();
		mytaxamount.setToolTipText("Tax Amount < Tax Calculated on After Discount Amount>");
		mytaxamount.setBackground(Color.BLACK);
		mytaxamount.setForeground(Color.WHITE);
		mytaxamount.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		mytaxamount.setHorizontalAlignment(SwingConstants.RIGHT);
		mytaxamount.setEditable(false);
		mytaxamount.setBounds(345, 83, 150, 25);
		panel_3.add(mytaxamount);
		mytaxamount.setColumns(10);

		lblNewLabel_9 = new JLabel("After Disc-Amt");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(170, 65, 156, 16);
		lblNewLabel_9.setForeground(new Color(0, 0, 51));
		lblNewLabel_9.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		panel_3.add(lblNewLabel_9);

		purchasePostingAmount = new JTextField();
		purchasePostingAmount.setToolTipText("Purchase Value After Deduction of Discount Amount");
		purchasePostingAmount.setBackground(Color.BLACK);
		purchasePostingAmount.setForeground(Color.WHITE);
		purchasePostingAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		purchasePostingAmount.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		purchasePostingAmount.setEditable(false);
		purchasePostingAmount.setBounds(345, 58, 150, 25);
		panel_3.add(purchasePostingAmount);
		purchasePostingAmount.setColumns(10);

		lblNewLabel_10 = new JLabel("Base Pur.Price");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNewLabel_10.setForeground(new Color(0, 0, 51));
		lblNewLabel_10.setBounds(181, 8, 160, 25);
		panel_3.add(lblNewLabel_10);

		// basePurchasePrice = new JTextField();
		basePurchasePrice = new gnRoundTextField(12);
		basePurchasePrice.setToolTipText("Bases Purchase Price without Tax ");
		basePurchasePrice.setBackground(Color.BLACK);
		basePurchasePrice.setForeground(Color.WHITE);
		basePurchasePrice.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		basePurchasePrice.setHorizontalAlignment(SwingConstants.RIGHT);
		basePurchasePrice.setEditable(false);
		basePurchasePrice.setBounds(345, 8, 150, 25);
		panel_3.add(basePurchasePrice);
		basePurchasePrice.setColumns(10);

		chkbox1 = new JCheckBox("Tax On Oth.Charges");
		chkbox1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chkbox1.setForeground(Color.DARK_GRAY);
		chkbox1.setBounds(17, 15, 128, 23);
		panel_3.add(chkbox1);

		JLabel lblNewLabel_23 = new JLabel("Total Qty");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_23.setForeground(Color.DARK_GRAY);
		lblNewLabel_23.setBounds(24, 90, 102, 16);
		panel_3.add(lblNewLabel_23);

		// totalqty = new JTextField();
		totalqty = new gnRoundTextField(20);
		totalqty.setToolTipText("Total Purchase Quantity");
		totalqty.setHorizontalAlignment(SwingConstants.CENTER);
		totalqty.setBackground(Color.BLACK);
		totalqty.setForeground(Color.WHITE);
		totalqty.setFont(new Font("Arial", Font.BOLD, 21));
		totalqty.setBounds(14, 105, 128, 27);
		panel_3.add(totalqty);
		totalqty.setColumns(10);

		lblNewLabel_24 = new JLabel("Total Disc.");
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_24.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_24.setForeground(new Color(0, 0, 51));
		lblNewLabel_24.setBounds(228, 39, 98, 16);
		panel_3.add(lblNewLabel_24);

		totaldisc = new JTextField();
		totaldisc.setToolTipText("Total Given Discount Amout");
		totaldisc.setBackground(Color.BLACK);
		totaldisc.setForeground(Color.WHITE);
		totaldisc.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		totaldisc.setEditable(false);
		totaldisc.setHorizontalAlignment(SwingConstants.RIGHT);
		totaldisc.setBounds(345, 34, 150, 25);
		panel_3.add(totaldisc);
		totaldisc.setColumns(10);

		lblNewLabel_25 = new JLabel("Other Charges");
		lblNewLabel_25.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_25.setForeground(new Color(0, 0, 51));
		lblNewLabel_25.setBounds(208, 141, 118, 16);
		panel_3.add(lblNewLabel_25);

		otherCharges = new JTextField();
		otherCharges.setToolTipText("Other Charges Amount will Add in Purchase Value<Incl Tax>");
		otherCharges.setBackground(Color.BLACK);
		otherCharges.setForeground(Color.WHITE);
		otherCharges.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		otherCharges.setEditable(false);
		otherCharges.setHorizontalAlignment(SwingConstants.RIGHT);
		otherCharges.setBounds(345, 136, 150, 25);
		panel_3.add(otherCharges);
		otherCharges.setColumns(10);

		lblNewLabel_39 = new JLabel("X");
		lblNewLabel_39.setIcon(new ImageIcon(GRNModule.class.getResource("/RetailProduct/Ph2.png")));
		lblNewLabel_39.setForeground(Color.WHITE);
		lblNewLabel_39.setBounds(153, 35, 9, 152);
		panel_3.add(lblNewLabel_39);

		JPanel panel_2 = new JPanel();
		panel_2.setToolTipText("Supplier Invoice Detail (Enter Suppier Invoice Details)");
		panel_2.setBounds(565, 25, 287, 190);
		panel_2.setBackground(Color.WHITE);
		GRNModuleFrame.getContentPane().add(panel_2);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Supplier Invoice Detail",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_2.setLayout(null);

		InvoiceDate = new JTextField();
		// InvoiceDate.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		// InvoiceDate.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		InvoiceDate.setFont(new Font("Calibri", Font.BOLD, 16));
		InvoiceDate.setForeground(Color.BLACK);
		InvoiceDate.setBackground(Color.WHITE);
		InvoiceDate.setBounds(141, 23, 128, 28);
		panel_2.add(InvoiceDate);
		InvoiceDate.setToolTipText("Enter Invoice Date of Vendor Invoice<date Format is [dd.mm.yyyy]");
		InvoiceDate.setColumns(10);

		InvAmt = new JTextField();
		// InvAmt.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		// InvAmt.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		InvAmt.setFont(new Font("Century Schoolbook", Font.BOLD, 16));
		InvAmt.setForeground(Color.BLACK);
		InvAmt.setBackground(Color.WHITE);
		InvAmt.setHorizontalAlignment(SwingConstants.LEFT);
		InvAmt.setBounds(141, 81, 128, 28);
		panel_2.add(InvAmt);
		InvAmt.setToolTipText("Enter Total Vendor Invoice Amount Here");
		InvAmt.setColumns(10);

		JLabel lblVendorInvoiceNumber = new JLabel("*Invoice Number");
		lblVendorInvoiceNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVendorInvoiceNumber.setForeground(new Color(0, 0, 51));
		lblVendorInvoiceNumber.setBounds(14, 56, 124, 16);
		panel_2.add(lblVendorInvoiceNumber);
		lblVendorInvoiceNumber.setFont(new Font("Tahoma", Font.BOLD, 13));

		InvoiceNumber = new JTextField();
		// InvoiceNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		// InvoiceNumber.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		InvoiceNumber.setFont(new Font("Calibri", Font.BOLD, 16));
		InvoiceNumber.setForeground(new Color(0, 0, 0));
		InvoiceNumber.setBackground(new Color(255, 255, 255));
		InvoiceNumber.setBounds(141, 52, 128, 28);
		panel_2.add(InvoiceNumber);
		InvoiceNumber.setToolTipText("Enter Vendor Invoce Number for Tally Account");
		InvoiceNumber.setColumns(10);

		JLabel lblInvoiceDate = new JLabel("Inv.Date");
		lblInvoiceDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInvoiceDate.setForeground(new Color(0, 0, 51));
		lblInvoiceDate.setBounds(33, 28, 105, 16);
		panel_2.add(lblInvoiceDate);
		lblInvoiceDate.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblInvoiceAmount = new JLabel("Inv. Amount");
		lblInvoiceAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInvoiceAmount.setForeground(new Color(0, 0, 51));
		lblInvoiceAmount.setBounds(24, 88, 114, 16);
		panel_2.add(lblInvoiceAmount);
		lblInvoiceAmount.setFont(new Font("Tahoma", Font.BOLD, 13));

		JLabel lblNewLabel_6 = new JLabel("Adj Adv.Payment");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setForeground(new Color(0, 0, 51));
		lblNewLabel_6.setBounds(15, 116, 123, 16);
		panel_2.add(lblNewLabel_6);

		advno = new JTextField();
		advno.setEnabled(false);
		advno.setEditable(false);
		advno.setFont(new Font("Calibri", Font.BOLD, 16));
		advno.setForeground(new Color(0, 0, 0));
		advno.setBackground(new Color(255, 255, 255));
		advno.setBounds(141, 110, 128, 22);
		panel_2.add(advno);
		advno.setColumns(10);

		JLabel lblNewLabel_34 = new JLabel("DD.MM.YYYY");
		lblNewLabel_34.setBounds(141, 27, 128, 16);
		panel_2.add(lblNewLabel_34);
		lblNewLabel_34.setForeground(Color.WHITE);

		JPanel panel_7 = new JPanel();
		panel_7.setVisible(false);
		panel_7.setBounds(0, 133, 287, 57);
		panel_2.add(panel_7);
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(64, 64, 64), new Color(255, 255, 255),
				new Color(255, 255, 255), new Color(0, 0, 0)));
		panel_7.setBackground(Color.WHITE);
		panel_7.setLayout(null);

		approve = new JCheckBox("Approve GR");
		approve.setForeground(Color.DARK_GRAY);
		approve.setEnabled(false);
		approve.setSelected(true);
		approve.setFont(new Font("Tahoma", Font.PLAIN, 11));
		approve.setBackground(Color.WHITE);
		approve.setBounds(8, 20, 91, 22);
		panel_7.add(approve);

		approvedby = new JTextField();
		approvedby.setForeground(Color.BLACK);
		approvedby.setFont(new Font("Calibri", Font.PLAIN, 13));
		approvedby.setBackground(Color.WHITE);
		approvedby.setEditable(false);
		approvedby.setBounds(103, 22, 71, 22);
		panel_7.add(approvedby);
		approvedby.setColumns(10);

		approvedate = new JTextField();
		approvedate.setForeground(Color.BLACK);
		approvedate.setBackground(Color.WHITE);
		approvedate.setEditable(false);
		approvedate.setBounds(176, 21, 83, 22);
		panel_7.add(approvedate);
		approvedate.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Approved By");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(93, 6, 83, 16);
		panel_7.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Approve Date");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(176, 6, 83, 16);
		panel_7.add(lblNewLabel_3);

		lblNewLabel_35 = new JLabel("DD.MM.YYYY");
		lblNewLabel_35.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_35.setBounds(12, 22, 65, 28);
		panel_2.add(lblNewLabel_35);
		approve.addActionListener(aprv);
		approve.addActionListener(aprv);

		JLabel lblStoreCode = new JLabel("Store Code");
		lblStoreCode.setBounds(0, 34, 73, 16);
		GRNModuleFrame.getContentPane().add(lblStoreCode);
		lblStoreCode.setForeground(new Color(255, 255, 255));
		lblStoreCode.setFont(new Font("Calibri", Font.BOLD, 14));
		lblStoreCode.setHorizontalAlignment(SwingConstants.RIGHT);

		Storecode = new JTextField();
		Storecode.setBounds(76, 31, 81, 19);
		GRNModuleFrame.getContentPane().add(Storecode);
		Storecode.setForeground(new Color(0, 0, 0));
		Storecode.setFont(new Font("Calibri", Font.BOLD, 13));
		Storecode.setBackground(new Color(255, 255, 255));
		Storecode.setEditable(false);
		Storecode.setVisible(false);
		Storecode.setColumns(10);

		storename = new JTextField();
		storename.setBounds(159, 31, 349, 19);
		GRNModuleFrame.getContentPane().add(storename);
		storename.setFont(new Font("Calibri", Font.BOLD, 13));
		storename.setForeground(new Color(0, 0, 0));
		storename.setBackground(new Color(255, 255, 255));
		storename.setEditable(false);
		storename.setVisible(false);
		storename.setColumns(10);

		btnPrint = new JButton("Print");
		btnPrint.setBounds(582, 617, 83, 30);
		GRNModuleFrame.getContentPane().add(btnPrint);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrint.setSelectedIcon(null);
		btnPrint.setIcon(null);
		btnPrint.setMnemonic('P');
		btnPrint.setForeground(new Color(0, 0, 102));
		btnPrint.setBackground(new Color(153, 204, 204));

		btnDayBook = new JButton("Day Book");
		btnDayBook.setBounds(665, 617, 96, 30);
		GRNModuleFrame.getContentPane().add(btnDayBook);
		btnDayBook.setToolTipText("Press Button To See Day Book <All Transaction Summary>");
		btnDayBook.setForeground(new Color(0, 0, 128));
		btnDayBook.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDayBook.setBackground(new Color(153, 204, 204));

		btnPrice = new JButton("Price Change");
		btnPrice.setBounds(762, 617, 115, 30);
		GRNModuleFrame.getContentPane().add(btnPrice);
		btnPrice.setToolTipText("Press Button <In Case If you want to change Price of   ITEMS>");
		btnPrice.setForeground(new Color(0, 0, 102));
		btnPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrice.setBackground(new Color(153, 204, 204));
		btnPrice.setMnemonic('G');

		btnArticleInfo = new JButton("Article Analytics");
		btnArticleInfo.setBounds(877, 617, 115, 30);
		GRNModuleFrame.getContentPane().add(btnArticleInfo);
		// btnArticleInfo = new gnRoundButton("Article Analytics");
		btnArticleInfo.setToolTipText(
				"To See Performance of any Item Please Click Here< Cursor Must be Place on Item in Table>");
		btnArticleInfo.setFont(new Font("Arial", Font.BOLD, 10));
		btnArticleInfo.setForeground(new Color(0, 0, 128));
		btnArticleInfo.setBackground(new Color(153, 204, 204));
		btnArticleInfo.setMnemonic('L');

		btnAcEntry = new JButton("Account Entry");
		btnAcEntry.setBounds(1088, 617, 115, 30);
		GRNModuleFrame.getContentPane().add(btnAcEntry);
		btnAcEntry.setToolTipText("Press Button - To Check Acccount Posted Entery For Purchase Transaction");
		btnAcEntry.setForeground(new Color(0, 0, 102));
		btnAcEntry.setFont(new Font("Arial", Font.BOLD, 12));
		btnAcEntry.setBackground(new Color(153, 204, 204));
		btnAcEntry.setMnemonic('A');
		btnAcEntry.setSelectedIcon(null);
		btnAcEntry.setIcon(null);

 		
		btnPayment = new JButton("Payment");
		btnPayment.setBounds(1204, 617, 90, 30);
		GRNModuleFrame.getContentPane().add(btnPayment);
		btnPayment.setToolTipText("Supplier Payment Module <Press Button For Supplier Payment>");
		btnPayment.setForeground(new Color(0, 0, 102));
		btnPayment.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPayment.setBackground(new Color(153, 204, 204));
		btnPayment.setMnemonic('Y');

		btnBarcode = new JButton("Gen.Barcode");
		btnBarcode.setBounds(991, 619, 96, 29);
		GRNModuleFrame.getContentPane().add(btnBarcode);
		// btnBarcode = new gnRoundButton("Gen.Barcode");
		btnBarcode.setToolTipText("Generate Barcode of Non Barcode Items");
		btnBarcode.setForeground(new Color(0, 0, 128));
		btnBarcode.setBackground(new Color(153, 204, 204));
		btnBarcode.setMnemonic('B');
		btnBarcode.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btnEdit = new JButton("Edit Purchase");
		btnEdit.setBounds(421, 618, 56, 27);
		GRNModuleFrame.getContentPane().add(btnEdit);
		btnEdit.setBackground(Color.BLACK);
		btnEdit.setForeground(Color.GREEN);
		btnEdit.setFont(new Font("Agency FB", Font.BOLD, 15));
		btnEdit.setMnemonic('E');
		btnEdit.addActionListener(grnsave);
		btnBarcode.addActionListener(abc);
		btnPayment.addActionListener(grnsave);
		btnAcEntry.addActionListener(grnsave);

		lblStoreCode.setVisible(false);

		scanItem.addActionListener(lsart);
		ActionListener ls7777 = new lsnritemName();
		ActionListener ssez = new sezlsnr();
		ActionListener adv = new advnoLsnr();
		ActionListener dic = new discLsnr();
		ActionListener othchg = new othchrgLsnr();
		ActionListener btdis = new lsBtn();
		ActionListener invdt = new invdateLsnr();
		InvoiceDate.addActionListener(invdt);

		ActionListener calLs = new calLsnr();
		ActionListener puruomLs = new puruomLsnr();
		ActionListener purqtyLs = new purqtyLsnr();
		ActionListener purrateLs = new xpurrateLsnr();
		ActionListener discp = new discLsnr1();
		ActionListener caldisc = new chkLsnr();
		ActionListener poLs = new polsnr();
		ActionListener grntypeLs = new purchaseType();
		advno.addActionListener(adv);
		chkbox1.addActionListener(caldisc);
		pono.addActionListener(poLs);
		grntype.addActionListener(grntypeLs);
		Othcharges.addActionListener(othchg);

		ActionListener discamtls = new discitemLsnr();

		FocusListener fsnl = new focusLsnr();
		VendorName.addFocusListener(fsnl);
		InvoiceDate.addFocusListener(fsnl);
		InvoiceNumber.addFocusListener(fsnl);
		InvAmt.addFocusListener(fsnl);

		KeyListener ky = new keyPressedlsnr();
		purchasetype.addKeyListener(ky);
		VendorName.addKeyListener(ky);
		InvoiceDate.addKeyListener(ky);
		InvoiceNumber.addKeyListener(ky);
		InvAmt.addKeyListener(ky);

		ActionListener purtypLs = new purtypeLsnr();
		purchasetype.addActionListener(purtypLs);

		ActionListener chngqty = new changeQtyLsnt();
		ActionListener chngrate = new changeRateLsnt();
		ActionListener chngmrp = new changeMRPLsnt();
		ActionListener chngsp = new changeSPLsnt();

		chnagemrp.addActionListener(chngmrp);
		chnagesp.addActionListener(chngsp);
		changerate.addActionListener(chngrate);
		changeqty.addActionListener(chngqty);

		btnArticleInfo.addActionListener(btdis);
		btnPrice.addActionListener(grnsave);
		btnDayBook.addActionListener(grnsave);
		btnPrint.addActionListener(grnsave);
		searchbrand.addActionListener(bnd);
		panel_5.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { scanItem, scanName, searchbrand, BtnInfo, btnBarcode }));

		//

		// PriceEdit put here

		panelPriceEdit = new JPanel();
		panelPriceEdit.setBackground(Color.CYAN);
		panelPriceEdit.setLayout(null);

		JLabel lblNewLabel_13 = new JLabel("Purchase UOM");
		lblNewLabel_13.setBounds(198, -3, 85, 27);
		panelPriceEdit.add(lblNewLabel_13);

		puruom = new JComboBox();
		puruom.setBounds(197, 19, 116, 22);
		panelPriceEdit.add(puruom);

		JLabel lblNewLabel_14 = new JLabel("Pur.Qty");
		lblNewLabel_14.setBounds(340, 2, 56, 16);
		panelPriceEdit.add(lblNewLabel_14);

		purqty = new JTextField();
		purqty.setBounds(325, 19, 78, 22);
		panelPriceEdit.add(purqty);
		purqty.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Purchase Rate");
		lblNewLabel_12.setBounds(426, -3, 96, 27);
		panelPriceEdit.add(lblNewLabel_12);

		purrate = new JTextField();
		purrate.setBounds(415, 19, 148, 22);
		panelPriceEdit.add(purrate);
		purrate.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Order in");
		lblNewLabel_15.setBounds(668, 5, 56, 16);
		panelPriceEdit.add(lblNewLabel_15);

		vpurchaseUOM = new JTextField();
		vpurchaseUOM.setEditable(false);
		vpurchaseUOM.setBounds(729, 2, 116, 22);
		panelPriceEdit.add(vpurchaseUOM);
		vpurchaseUOM.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Inner Units");
		lblNewLabel_16.setBounds(656, 25, 62, 16);
		panelPriceEdit.add(lblNewLabel_16);

		vinnerqty = new JTextField();
		vinnerqty.setEditable(false);
		vinnerqty.setBounds(729, 25, 116, 22);
		panelPriceEdit.add(vinnerqty);
		vinnerqty.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel(" ");
		lblNewLabel_17.setIcon(new ImageIcon(GRNModule.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel_17.setBounds(0, 0, 844, 49);
		panelPriceEdit.add(lblNewLabel_17);

		//

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setViewportBorder(new MatteBorder(3, 0, 3, 0, (Color) new Color(204, 255, 204)));
		// jsp.setBounds(20, 49, 1298, 210);
		jsp.setBounds(22, 281, 1345, 336);

		GRNModuleFrame.getContentPane().add(jsp);

		// mysplit.setBounds(12, 270, 1345, 215);

		// mysplit.setLeftComponent(panelPriceEdit);
		// mysplit.setRightComponent(jsp);

		JViewport prt = new JViewport();
		prt.setBorder(null);
		prt.setBackground(Color.CYAN);
		prt.add(table, Col);
		prt.setVisible(true);
		new gnTable().setFontBold(table, 14);
		prt.setBackground(Color.WHITE);
		jsp.setViewport(prt);

		njsp = new JScrollPane();
		njsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		njsp.setBounds(13, 647, 1344, 8);
		GRNModuleFrame.getContentPane().add(njsp);

		lblNewLabel_30 = new JLabel(" Pur.Price");
		lblNewLabel_30.setBounds(330, 659, 79, 16);
		GRNModuleFrame.getContentPane().add(lblNewLabel_30);
		lblNewLabel_30.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_30.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_30.setForeground(new Color(0, 0, 102));

		lblcost = new JLabel("0.00");
		lblcost.setBounds(421, 659, 56, 16);
		GRNModuleFrame.getContentPane().add(lblcost);
		lblcost.setHorizontalAlignment(SwingConstants.LEFT);
		lblcost.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblcost.setForeground(new Color(153, 51, 153));

		lblNewLabel_33 = new JLabel("LC");
		lblNewLabel_33.setBounds(463, 659, 26, 16);
		GRNModuleFrame.getContentPane().add(lblNewLabel_33);
		lblNewLabel_33.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_33.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_33.setForeground(new Color(0, 0, 102));

		lblLC = new JLabel("0.00");
		lblLC.setBounds(497, 659, 56, 16);
		GRNModuleFrame.getContentPane().add(lblLC);
		lblLC.setHorizontalAlignment(SwingConstants.LEFT);
		lblLC.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLC.setForeground(new Color(153, 51, 153));

		lblNewLabel_31 = new JLabel("Pur.Qty");
		lblNewLabel_31.setBounds(209, 659, 70, 16);
		GRNModuleFrame.getContentPane().add(lblNewLabel_31);
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_31.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_31.setForeground(new Color(0, 0, 102));

		lblqty = new JLabel("0.00");
		lblqty.setBounds(291, 659, 70, 16);
		GRNModuleFrame.getContentPane().add(lblqty);
		lblqty.setHorizontalAlignment(SwingConstants.LEFT);
		lblqty.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblqty.setForeground(new Color(153, 51, 153));

		dispname = new JLabel("Item Name");
		dispname.setBounds(23, 659, 199, 22);
		GRNModuleFrame.getContentPane().add(dispname);
		dispname.setForeground(new Color(0, 0, 102));
		dispname.setBackground(Color.BLACK);
		dispname.setFont(new Font("Tahoma", Font.BOLD, 11));

		lastSupplier = new JLabel("Previous Supplier Name");
		lastSupplier.setBounds(729, 659, 248, 20);
		GRNModuleFrame.getContentPane().add(lastSupplier);
		lastSupplier.setToolTipText("Previous Supplier Name");
		lastSupplier.setForeground(new Color(0, 0, 51));
		lastSupplier.setFont(new Font("Calibri", Font.BOLD, 14));

		lblNewLabel_29 = new JLabel("Prv.GR Amt");
		lblNewLabel_29.setBounds(1062, 659, 87, 16);
		GRNModuleFrame.getContentPane().add(lblNewLabel_29);
		lblNewLabel_29.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_29.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_29.setForeground(new Color(0, 0, 51));

		Privoiusamt = new JLabel("0.00");
		Privoiusamt.setBounds(1162, 659, 124, 19);
		GRNModuleFrame.getContentPane().add(Privoiusamt);
		Privoiusamt.setToolTipText("Previous GRN Amount");
		Privoiusamt.setFont(new Font("Arial Black", Font.BOLD, 14));
		Privoiusamt.setHorizontalAlignment(SwingConstants.LEFT);
		Privoiusamt.setForeground(Color.BLACK);

		lblNewLabel_32 = new JLabel("SP");
		lblNewLabel_32.setBounds(525, 659, 42, 16);
		GRNModuleFrame.getContentPane().add(lblNewLabel_32);
		lblNewLabel_32.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_32.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_32.setForeground(new Color(0, 0, 102));

		lblsp = new JLabel("0.00");
		lblsp.setBounds(571, 659, 50, 16);
		GRNModuleFrame.getContentPane().add(lblsp);
		lblsp.setHorizontalAlignment(SwingConstants.LEFT);
		lblsp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblsp.setForeground(new Color(153, 51, 153));

		jkkk = new JLabel("MRP");
		jkkk.setBounds(603, 659, 41, 16);
		GRNModuleFrame.getContentPane().add(jkkk);
		jkkk.setFont(new Font("Tahoma", Font.BOLD, 13));
		jkkk.setForeground(new Color(0, 0, 102));
		jkkk.setHorizontalAlignment(SwingConstants.RIGHT);

		lblmrp = new JLabel("0.00");
		lblmrp.setBounds(656, 659, 56, 16);
		GRNModuleFrame.getContentPane().add(lblmrp);
		lblmrp.setHorizontalAlignment(SwingConstants.LEFT);
		lblmrp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblmrp.setForeground(new Color(153, 51, 153));

		naration = new JTextField();
		naration.setBounds(85, 617, 331, 25);
		GRNModuleFrame.getContentPane().add(naration);
		naration.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
		naration.setForeground(Color.BLACK);
		naration.setColumns(10);

		JLabel lblNewLabel_26 = new JLabel("Narration");
		lblNewLabel_26.setBounds(12, 623, 406, 17);
		GRNModuleFrame.getContentPane().add(lblNewLabel_26);
		lblNewLabel_26.setFont(new Font("Tahoma", Font.PLAIN, 14));

		// xbatchno = new JTextField();
		xbatchno = new gnRoundTextField(10);
		xbatchno.setBounds(1231, 672, 80, 12);
		GRNModuleFrame.getContentPane().add(xbatchno);
		xbatchno.setColumns(10);

		lblNewLabel_1 = new JLabel("Batch No");
		lblNewLabel_1.setBounds(1241, 659, 77, 17);
		GRNModuleFrame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));

		lblNewLabel_41 = new JLabel("Exp.Date");
		lblNewLabel_41.setBounds(1310, 659, 70, 17);
		GRNModuleFrame.getContentPane().add(lblNewLabel_41);
		lblNewLabel_41.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_41.setFont(new Font("Tahoma", Font.BOLD, 13));

		// xexpdate = new JTextField();
		xexpdate = new gnRoundTextField(10);
		xexpdate.setBounds(1306, 677, 64, 8);
		GRNModuleFrame.getContentPane().add(xexpdate);
		xexpdate.setColumns(10);

		sez = new JCheckBox("SEZ ");
		sez.setBounds(565, 4, 73, 18);
		GRNModuleFrame.getContentPane().add(sez);
		sez.setForeground(Color.BLACK);
		sez.setBackground(Color.WHITE);
		sez.setToolTipText("Tick This Option If supply from SEZ Area");
		sez.setFont(new Font("Calibri", Font.PLAIN, 13));

		importgoods = new JCheckBox("Import Goods");
		importgoods.setBounds(641, 0, 89, 18);
		GRNModuleFrame.getContentPane().add(importgoods);
		importgoods.setForeground(Color.BLACK);
		importgoods.setToolTipText("Check This Option If Purchase From Other Country");
		importgoods.setFont(new Font("Calibri", Font.PLAIN, 13));
		importgoods.setBackground(Color.WHITE);

		rb99 = new JRadioButton("Rental Item Purchase");
		rb99.setBounds(762, -3, 75, 25);
		GRNModuleFrame.getContentPane().add(rb99);
		rb99.setForeground(new Color(0, 0, 51));

		btnCalculator = new JButton("Calculator");
		btnCalculator.setBounds(739, -2, 15, 25);
		GRNModuleFrame.getContentPane().add(btnCalculator);
		btnCalculator.setFont(new Font("Tahoma", Font.PLAIN, 8));

		 
		
		btnCalculator.addActionListener(calLs);
		importgoods.addActionListener(ssez);
		sez.addActionListener(ssez);

		// ActionListener tblact = new tblAction();
		// table.addAncestorListener((AncestorListener) tblact);

		// 3 pruom

		purrate.addActionListener(purrateLs);
		purqty.addActionListener(purqtyLs);
		puruom.addActionListener(puruomLs);
		ActionListener myxbatchno = new batchnoLsnr();
		ActionListener myxrxpdate = new expdateLsnr();
		xexpdate.addActionListener(myxrxpdate);
		xbatchno.addActionListener(myxbatchno);

		discper.addActionListener(discp);
		disc.addActionListener(discamtls);
 
		decorateComp();

	}

	/// Start Coding Here ///

	class batchnoLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			new General().Quickmsg("Update Batch Number .. ");
			table.setValueAt(xbatchno.getText(), selectedrow, 18);
		}
	}

	class expdateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new General().Quickmsg("Update Exp Date .. ");
			table.setValueAt(xexpdate.getText(), selectedrow, 19);

		}
	}

	class btnCallCalc implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Runtime run = Runtime.getRuntime();
			try {
				run.exec("calc");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	class changeQtyLsnt implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String value = table.getValueAt(selectedrow, 1).toString();

			String vqty = changeqty.getText();
			table.setValueAt(vqty, selectedrow, 4);
			table.setValueAt(vqty, selectedrow, 5);
			try {
				QtychangeImapct(value, selectedrow);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class changeRateLsnt implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String value = table.getValueAt(selectedrow, 1).toString();

			String vrate = changerate.getText();
			table.setValueAt(vrate, selectedrow, 6);

			String vqty = changeqty.getText();
			table.setValueAt(vqty, selectedrow, 4);
			table.setValueAt(vqty, selectedrow, 5);

			try {
				QtychangeImapct(value, selectedrow);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	class changeMRPLsnt implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String value = table.getValueAt(selectedrow, 1).toString();

			String vmrp = chnagemrp.getText();
			table.setValueAt(vmrp, selectedrow, 21);

			String vrate = changerate.getText();
			table.setValueAt(vrate, selectedrow, 6);

			String vqty = changeqty.getText();
			table.setValueAt(vqty, selectedrow, 4);
			table.setValueAt(vqty, selectedrow, 5);

			try {
				QtychangeImapct(value, selectedrow);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class changeSPLsnt implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vsp = chnagesp.getText();
			String value = table.getValueAt(selectedrow, 1).toString();
			table.setValueAt(vsp, selectedrow, 22);

			String vmrp = chnagemrp.getText();
			table.setValueAt(vmrp, selectedrow, 21);

			String vrate = changerate.getText();
			table.setValueAt(vrate, selectedrow, 6);

			String vqty = changeqty.getText();
			table.setValueAt(vqty, selectedrow, 4);
			table.setValueAt(vqty, selectedrow, 5);

			try {
				QtychangeImapct(value, selectedrow);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class purtypeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			VendorName.grabFocus();
		}
	}

	class keyPressedlsnr implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int value = e.getKeyCode();
			switch (value) {
			case 10:

				if (edituom.isFocusOwner()) {
					editinnerqty.requestFocus(true);
					editinnerqty.grabFocus();
				}

				if (editinnerqty.isFocusOwner()) {
					editqty.grabFocus();
				}

				if (editqty.isFocusOwner()) {
					editrate.grabFocus();
				}

				if (editrate.isFocusOwner()) {
					editmrp.grabFocus();
				}

				if (editmrp.isFocusOwner()) {
					editsp.grabFocus();
				}

				if (editsp.isFocusOwner()) {
					editdisc.grabFocus();
				}

				if (editdisc.isFocusOwner()) {
					editdiscper.grabFocus();
				}

				if (editdiscper.isFocusOwner()) {
					editbatchno.grabFocus();
				}

				if (editbatchno.isFocusOwner()) {
					editexpdate.grabFocus();
				}

				if (InvoiceDate.isFocusOwner()) {
					InvoiceNumber.grabFocus();
				}

				if (InvoiceNumber.isFocusOwner()) {
					InvAmt.grabFocus();
				}

				if (InvAmt.isFocusOwner()) {
					scanItem.grabFocus();
				}

				if (table.isFocusOwner()) {
					scanItem.grabFocus();
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

	class focusLsnr implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {

			if (VendorName.isFocusOwner()) {
				VendorName.setBackground(Color.darkGray);
				VendorName.setForeground(Color.WHITE);
			}

			if (InvoiceDate.isFocusOwner()) {
				InvoiceDate.setBackground(Color.darkGray);
				InvoiceDate.setForeground(Color.WHITE);

			}

			if (InvoiceNumber.isFocusOwner()) {
				InvoiceNumber.setBackground(Color.darkGray);
				InvoiceNumber.setForeground(Color.WHITE);
			}

			if (InvAmt.isFocusOwner()) {
				InvAmt.setBackground(Color.darkGray);
				InvAmt.setForeground(Color.WHITE);
			}
		}

		@Override
		public void focusLost(FocusEvent e) {

			VendorName.setBackground(Color.white);
			VendorName.setForeground(Color.BLACK);

			InvoiceDate.setBackground(Color.white);
			InvoiceDate.setForeground(Color.BLACK);

			InvoiceNumber.setBackground(Color.white);
			InvoiceNumber.setForeground(Color.BLACK);

			InvAmt.setBackground(Color.white);
			InvAmt.setForeground(Color.BLACK);

			// setButtonStyle() ;
		}
	}

	public void decorateComp() throws Throwable {

		//new General().msg("Wel Come to Purchase Module..");
		
		switch(EnableAccountingModule)
		{
		    case "Y" :
			btnAcEntry.setVisible(true);
			btnPayment.setVisible(true);
			break;
		    case "N" :	
 			btnAcEntry.setVisible(false);
			btnPayment.setVisible(false);
			break;
 		}
 		changerate.setVisible(false);
		changeqty.setVisible(false);
		chnagemrp.setVisible(false);
		chnagesp.setVisible(false);
		searchbrand.setVisible(false);
		brandcode.setVisible(false);
		new gnApp().setFrameTitel(GRNModuleFrame);
		GRNModuleFrame.setUndecorated(true);
		String FieldName = "";
		purtype(table, model, FieldName);
		rb99.setVisible(false);
		// btnProduct.setVisible(false);
		// btnBarcode.setVisible(false);
		popanel.setVisible(false);
		chekcFreezeYear();
		this.checkInternet();
		// lblNewLabel_9.setVisible(false);
		btnCalculator.setVisible(false);
		// purchasePostingAmount.setVisible(false);
		vfinyear = new gnFinYear().getReportingFinYear();

		// combopurqty
		String vmsname1 = "Pack_Form";
		String vverticle = new gnHierarchy().getVerticleCode();
		String vsearch = "%%";
		String SQL11 = "call master_getMasterData('" + vmsname1 + "' , " + vverticle + "   , '" + vsearch + "')";
		new gnComp().fillCombo(SQL11, puruom);
		puruom.setSelectedItem("NO");

		InvoiceDate.setText(" ");
		InvoiceNumber.setText(null);
		new gnLogger().loggerInfoEntry("GRN", "GR Process Starts");
		if (Language == "H") {
			VendorName.setFont(new Font("Shivaji02", Font.PLAIN, 16));
		}
		String vpara29 = "29";
		String vEditDocumentAllow = new getConfigurationSetting().getSpecificConfiguration(vpara29);
		switch (vEditDocumentAllow) {
		case "N":
			btnEdit.setVisible(false);
		}

		vallow = new gnDate().checkDayBegin();
		switch (vallow) {
		case "Y":
			int typeno = 2;
			new gnDecorate().SetSeqHdrButton(btnSave, typeno);
			new gnDecorate().SetSeqHdrButton(btnAcEntry, typeno);
			new gnDecorate().SetSeqHdrButton(btnPrice, typeno);
			new gnDecorate().SetSeqHdrButton(btnDayBook, typeno);
			new gnDecorate().SetSeqHdrButton(btnArticleInfo, typeno);
			new gnDecorate().SetSeqHdrButton(btnBarcode, typeno);
			new gnDecorate().SetSeqHdrButton(btnPrint, typeno);
			new gnDecorate().SetSeqHdrButton(btnArticleInfo, typeno);
			new gnDecorate().SetSeqHdrButton(btnPayment, typeno);

			companycode.setText(new gnConfig().getCompanyCode());
			vcomp = companycode.getText();
			Storecode.setText(new gnConfig().getStoreID());
			vstore = Storecode.getText();
			String vname = Storecode.getText();
			storename.setText(new gnConfig().getStorename(vname));
			companyname.setText(new gnConfig().getCompany());
			btnPrint.setEnabled(false);
			companycode.setVisible(false);
			companyname.setVisible(false);
			roundingamt.setText("0.00");
			grndate.setText(new gnConfig().getDaybeginDate());
			// btnUpdate.setEnabled(false);

			String vpara = "24";
			String vpara1 = "25";
			String vimportAllow = new getConfigurationSetting().getSpecificConfiguration(vpara);
			String vsezPurchaseAllow = new getConfigurationSetting().getSpecificConfiguration(vpara1);
			switch (vimportAllow) {
			case "N":
				importgoods.setVisible(false);
				break;
			}
			switch (vsezPurchaseAllow) {
			case "N":
				sez.setVisible(false);
				break;
			}

			switch (vcomp) {
			case "0":
				System.exit(0);
			}
			new gnComp().getAllComponents(GRNModuleFrame);
			OnDelKeyTableRow(table, model, "GRN");
			grnSave(table, model, "GRN");
			new gnField().moveDown(table);
			new gnField().closeform(btnSave, GRNModuleFrame);

			// btnBarcode.setEnabled(false);
			String Roleis = new gnConfig().getRoleName();
			if (Roleis == "MANAGER" || Roleis == "ADMIN") {
				BtnInfo.setVisible(true);
			}

			String vtype = "GR";
			String vallowDate = new gnDate().checkBackDateTrAllow(vtype, grndate.getText());
			switch (vallowDate) {
			case "N":
				btnEdit.setVisible(false);
				grndate.setBackground(Color.RED);
				grndate.setForeground(Color.WHITE);
				new General().Quickmsg("Back Date For Transaction is not Allow..");
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				grndate.setText("?");
				scanItem.setVisible(false);
				scanName.setVisible(false);
				searchbrand.setVisible(false);
				VendorName.setEditable(false);
				GRNModuleFrame.dispose();
				btnSave.setVisible(false);
				popupPanel();
				break;
			}
			break;
		case "N":
			break;
		}
		EditMode = "N";

	}

	class purchaseType implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			// "With PO" ;
			String vgrntype = grntype.getSelectedItem().toString();
			if (vgrntype == "With PO") {
				popanel.setVisible(true);
				/// nitin Kale

			} else {
				popanel.setVisible(false);
			}

		}
	}

	class puruomLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}

	private void setuom() {
		String vpuom = puruom.getSelectedItem().toString();
		int row = table.getSelectedRow();
		table.setValueAt(vpuom, row, 3);

	}

	class purqtyLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			setuom();
			String vpurqty = purqty.getText();
			int row = table.getSelectedRow();
			table.setValueAt(vpurqty, row, 4);
			try {
				String value = table.getValueAt(row, 1).toString();
				QtychangeImapct(value, row);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	class xpurrateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String vpurrate = purrate.getText();
			int row = table.getSelectedRow();
			table.setValueAt(vpurrate, row, 6);
			try {
				setuom();
				String value = table.getValueAt(row, 1).toString();
				QtychangeImapct(value, row);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	
	class calLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				Runtime rt = Runtime.getRuntime();
				Process pr = rt.exec("calc");
			} catch (IOException e) {
 				e.printStackTrace();
			}
		}
	}

	
	
	class invdateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {

				int count = InvoiceDate.getText().length();
				if (count == 4) {
					InvoiceDate.setText(new gnDate().getmefullDate(InvoiceDate.getText()));
				}
				// new selectdate().selectDate(todate);
			} catch (Exception e1) {
				new General().Quickmsg(e1.getMessage());
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {

				int count = InvoiceDate.getText().length();
				if (count != 10) {
					InvoiceDate.grabFocus();
				}

				if (count == 10) {
					InvoiceNumber.grabFocus();
				}

			}
		}
	}

	class chkLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean vcheck = chkbox1.isSelected();
			if (vcheck) {
				// calculateLineDiscount();
				calculateTaxonOthchrg = "Y";
				otherCharges.setBackground(Color.white);
				otherCharges.setForeground(Color.WHITE);
			} else {
				calculateTaxonOthchrg = "N";
				otherCharges.setBackground(Color.black);
				otherCharges.setForeground(Color.yellow);
			}
			try {
				RecalculateTableChanges();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				new General().msg(e.getLocalizedMessage());
			}
		}
	}

	private void RecalculateTableChanges() throws ClassNotFoundException, SQLException {
		// new General().msg(calculateTaxonOthchrg);
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			String value = table.getValueAt(i, 1).toString();
			QtychangeImapct(value, i);
		}
		resetFigures();
	}

	private void calculateLineDiscount() {

		double vdiscper = Double.parseDouble(discper.getText());
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			double vrate = Double.parseDouble(table.getValueAt(i, 5).toString());
			double vqty = Double.parseDouble(table.getValueAt(i, 3).toString());
			double vdiscamt = vrate * vdiscper / 100;
			double actualRate = vrate - vdiscamt;
			vdiscamt = vdiscamt * vqty;
			table.setValueAt(vdiscamt, i, 6);
			table.setValueAt(actualRate, i, 22);
		}
		recalculateData();
		set2DecimalValues();
		resetFigures();
	}

	class othchrgLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			Double vamt = Double.parseDouble(Othcharges.getText());
			if (vamt >= 0.00) {
				checkOthCharges();
				DistributeOthchrg();

				Othcharges.setBackground(Color.black);
				Othcharges.setForeground(Color.WHITE);
			} else {
				Othcharges.setBackground(Color.WHITE);
				Othcharges.setForeground(Color.black);

			}

		}
	}

	public void DistributeOthchrg() {
		// String PoCol[] = {"Type" , 1"Article_code" ,2 "Name" , 3"Pur,UOM" ,
		// 4"Qty" , 5"Units" , 6"Pur.Price" ,
		// 7"Base Value " , 8"Line Disc." ,9 "Disc", 10"BasePurValue",
		// , 11"Tax%" , 12"Tax.Amt" , 13 "Pur.Incl Tax" , 14"Oth.Chrg" ,15
		// "Landing Cost",
		// 16"Bal Qty", 17 "Batch_Control" ,18 "Batch No" ,19 "Expiry date"};

		new gnLogger().loggerInfoEntry("GRN", "Distributed Other Charges to Items Level Over");
		double vqty = 0.00;
		int row = table.getRowCount();
		if (row > 0) {
			for (int i = 0; i < row; i++) {
				double qty = Double.parseDouble(table.getValueAt(i, 5).toString());
				vqty = vqty + qty;
			}
		}
		Double vgivenoth = Double.parseDouble(Othcharges.getText().toString());
		Double vdistOth = vgivenoth / vqty;

		int row1 = table.getRowCount();
		if (row1 > 0) {
			for (int k = 0; k < row1; k++) {
				double qtyrow = Double.parseDouble(table.getValueAt(k, 5).toString());
				double vdiscamt = vdistOth * qtyrow;
				table.setValueAt(vdiscamt, k, 14);
			}
		}
		set2DecimalValues();
		recalculateData();
		lblNewLabel_9.setVisible(true);
		purchasePostingAmount.setVisible(true);
	}

	private void recalculateData() {
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
					new gnLogger().loggerInfoEntry("GRN", "Distribution Exception" + " " + e.getLocalizedMessage());
				}
			}
		}
	}

	class discLsnr1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			double vdisc = Double.parseDouble(discper.getText());
			double vvalue = Double.parseDouble(basePurchasePrice.getText());
			double vdiscamt = new gnMath().getRound2DecimaltValue(vvalue * vdisc / 100);
			disc.setText(Double.toString(vdiscamt));
			ActionListener discdistribute = new discLsnr();
			ActionEvent e = null;
			discdistribute.actionPerformed(e);
		}
	}

	class discLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vdiscper = discper.getText();
			DistributeDiscountper(vdiscper);
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
					vgross = Double.parseDouble(table.getValueAt(i, 7).toString());
					vmygross = vmygross + vgross;
				}
				double vmydidcper = (vdisamt / vmygross) * 100;
				vmydiscper = new gnMath().get2DecimaltValue(Double.toString(vmydidcper));
			}
			// new General().Quickmsg(vmydiscper);
			DistributeDiscountper(vmydiscper);
		}
	}

	public void DistributeDiscountper(String vvdiscper) {
		// String PoCol[] = {"Type" , 1"Article_code" ,2 "Name" , 3"Pur,UOM" ,
		// 4"Qty" , 5"Units" , 6"Pur.Price" ,
		// 7"Base Value " , 8"Line Disc." ,9 "Disc", 10"BasePurValue",
		// , 11"Tax%" , 12"Tax.Amt" , 13 "Pur.Incl Tax" , 14"Oth.Chrg" ,15
		// "Landing Cost",
		// 16"Bal Qty", 17 "Batch_Control" ,18 "Batch No" ,19 "Expiry date"};
		double vqty = 0.00;
		double vdiscper = Double.parseDouble(vvdiscper);
		double vgross = 0.00;
		double vdiscamt = 0.00;
		int row = table.getRowCount();
		if (row > 0) {
			for (int i = 0; i < row; i++) {
				vgross = Double.parseDouble(table.getValueAt(i, 7).toString());
				vdiscamt = vgross * vdiscper / 100;
				String vmydiscamt = new gnMath().get2DecimaltValue(Double.toString(vdiscamt));
				table.setValueAt(vmydiscamt, i, 9);
			}
		}
		new gnLogger().loggerInfoEntry("GRN", "Hdr Discount Distributed- Sucess");
		set2DecimalValues();
		recalculateData();
	}

	private void tableaction() {
		int r = table.getSelectedRow();
		new General().Quickmsg(table.getValueAt(r, 2).toString());

	}

	class tblAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			tableaction();
		}

	}

	private void set2DecimalValues() {

		// String PoCol[] = {"Type" , 1"Article_code" ,2 "Name" , 3"Pur,UOM" ,
		// 4"Qty" , 5"Units" , 6"Pur.Price" ,
		// 7"Base Value " , 8"Line Disc." ,9 "Disc", 10"BasePurValue",
		// , 11"Tax%" , 12"Tax.Amt" , 13 "Pur.Incl Tax" , 14"Oth.Chrg" ,15
		// "Landing Cost",
		// 16"Bal Qty", 17 "Batch_Control" ,18 "Batch No" ,19 "Expiry date"};

		int row1 = table.getRowCount();
		int i;
		for (int k = 0; k < row1; k++) {
			table.setValueAt(new gnMath().get2DecimaltValue(table.getValueAt(k, 7).toString()), k, 7);
			table.setValueAt(new gnMath().get2DecimaltValue(table.getValueAt(k, 10).toString()), k, 10);
			table.setValueAt(new gnMath().get2DecimaltValue(table.getValueAt(k, 9).toString()), k, 10);
			table.setValueAt(new gnMath().get2DecimaltValue(table.getValueAt(k, 10).toString()), k, 10);
			table.setValueAt(new gnMath().get2DecimaltValue(table.getValueAt(k, 12).toString()), k, 12);
			table.setValueAt(new gnMath().get2DecimaltValue(table.getValueAt(k, 13).toString()), k, 13);
			table.setValueAt(new gnMath().get2DecimaltValue(table.getValueAt(k, 15).toString()), k, 15);

		}
	}

	class advnoLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String vpartycode = VendorCode.getText();
			String vdoctype = "AD";
			String vcat = "S";
			try {
				new gnDncnAdv().getOpenAdvdncn(vpartycode, vdoctype, vcat);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				new gnLogger().loggerInfoEntry("GRN", "Advance Payment Exception" + " " + e1.getLocalizedMessage());
			} finally {
				advno.setText(new gnDncnAdv().rdocno);
				vadvno = new gnDncnAdv().rdocno;
				advdate = new gnDncnAdv().rdocdate;
				new gnDncnAdv().rdocdate = " ";
				new gnDncnAdv().rdocno = "";
			}
		}
	}

	class sezlsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean ischeck = importgoods.isSelected();
			boolean ischeck1 = sez.isSelected();

			if (ischeck) {
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
				importgoods.setSelected(false);
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

	private void chekcFreezeYear() {
		switch (isFinyearFreeze) {
		case "Y":
			btnEdit.setVisible(false);
			btnSave.setVisible(false);
			// btnUpdate.setVisible(false);
			// btnAcEntry.setVisible(false);
			btnPrint.setVisible(false);
			new General().Quickmsg("Accounting Year is Freezeed..You Can View Data Only..");
			break;
		}
	}

	public void OnDelKeyTableRow(JTable table, DefaultTableModel model, String FieldName) {
		// new General().Quickmsg("Comp is "+ fld +" "+"Value is"+ "
		// "+FieldName);
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
					// new General().Quickmsg("row Selected is:"+" "+row);
					model.removeRow(row);
					removeRow(model, table);
					int setrow = table.getRowCount();
					table.setEditingRow(setrow - 1);
					table.setFocusable(true);
					resetFigures();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	class grnno implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// fetchGrProcess() ;
		}
	}

	class grnno1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (vallow == "N") {
				GRNModuleFrame.dispose();
				new General().Quickmsg("Complete Day Begin First ...");
			}
			String status = new gnCheckArticle().checkVendorSelected(VendorCode, VendorName);
			if (status == "Sucess") {
				try {
					new gnGrn().get_Grno("GR");
				} catch (Throwable e1) {
					e1.printStackTrace();
					new General().Quickmsg("Grnno Search" + " " + e1.getMessage());
				} finally {
					grnno.setText(new gnGrn().rgrnno);
					String vname = "GRSearch";
					String vcomp = companycode.getText();
					String vstore = Storecode.getText();
					String vgrnno = grnno.getText();
					String SQL = "Call GR_Fetchwithoutpo( " + vgrnno + " , " + vcomp + ",  " + vstore + " )";
					try {
						showTable(SQL, vname, PoCol);
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().Quickmsg("Grn Data Fetch" + " " + e1.getMessage());
					}
				}
			}
		}
	}

	class lsarticle implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (vallow == "N") {
				GRNModuleFrame.dispose();
				new General().Quickmsg("Complete Day Begin First ...");
			}
			if (i == 1001)
				try {
					getvalueofscanarticle();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
		}
	}

	class polsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String action = "Fail";
			// action = validatepoEntry();
			String vvpono = pono.getText();
			if (vvpono.length() > 0) {
				try {
					showpoSearch();
				} catch (Throwable e1) {
					e1.printStackTrace();
					new gnLogger().loggerInfoEntry("GRN-PO", "PO Search Exception" + " " + e1.getMessage());
				} finally {
					try {
						vvpono = pono.getText();
						showPOForReceive();
					} catch (Throwable e1) {
						e1.printStackTrace();
						new gnLogger().loggerInfoEntry("GRN-PO", "Show PO Data Exception" + " " + e1.getMessage());
					}
				}
			}
		}
	}

	public void showpoSearch() throws Throwable {
		String Type = "POFORGR";
		try {
			new gnPO().getVendorPO("", Type);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			if (new gnPO().pono.length() > 0) {
				pono.setText(new gnPO().pono);
				podate.setText(new gnPO().poate);
				String vndorcode = new gnPO().vendor;
				VendorCode.setText(new gnPO().vendor);
				VendorName.setText(new gnPO().vendor);
				regdlr.setText(new gnPO().rregdlr);
				//
				new gnSupplier().setScanSupplier(VendorCode, VendorName, vndorcode);
				VendorCode.setText(new gnSupplier().rvendorcode);
				VendorName.setText(new gnSupplier().rvendorName);
				mobile.setText(new gnSupplier().rPhone);
				email.setText(new gnSupplier().rEmail);
				creditDays.setText(new gnSupplier().rcrdays);
				statecode.setText(new gnSupplier().rstatecode);
				statename.setText(new gnSupplier().rstatename);
				applyRevchrg();
				//
			}
		}
	}

	private void showPOForReceive() throws Throwable {
		new gnTable().RemoveTableRows(model);
		String vpono = pono.getText();
		String vpodate = "";
		vpodate = new gnConfig().date_ConverttoDBforamt(podate.getText());
		table.requestFocus();
		String vfinyear = new gnFinYear().getReportingFinYear();
		if (vpono.length() > 0) {
			String vcomp = companycode.getText();
			String vstorecode = Storecode.getText();
			String vtype = "GRNMODULEPO";
			String SQL = "call GR_get_FetchPO(  '" + vtype + "' ,  " + vcomp + ", " + vstorecode + ",   " + vpono
					+ "  ,  '" + vpodate + "'  , '" + vfinyear + "')";
			// new General().Quickmsg(SQL);
			vtype = "GR";
			showTable(SQL, vtype, PoCol);
			if (table.getRowCount() > 0) {
				scanItem.setVisible(false);
				searchbrand.setVisible(false);
			}
		}
	}

	private void getvalueofscanarticle() throws Throwable {
		// String vfinyear = new gnFinYear().getReportingFinYear();
		String vname = "GRModule";
		String vcomp = companycode.getText();
		String vstore = Storecode.getText();
		String action = checkVendorEntry();
		String vcode = scanItem.getText();
		if (vcode.length() > 0) {
			String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
					new gnPublicVariable().vstore);
			String SQL = "Call Transaction_getScanArticleDetails( '" + vname + "'  , '" + vcode + "', " + vcomp + " , "
					+ vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
			// new General().Quickmsg(SQL) ;
			String result = checkArticleExist(vcode);
			if (result == "Sucess") {
				vname = "GR";
				showTable(SQL, vname, PoCol);
			}
			if (QueryStatus == "N") {
				searchName();
			}
			QueryStatus = "N";
		}
	}

	private void calculateTax(int row) {

		// 8 Purchase Value
		// 13 Landing Cost
		// 14 TaxPer

		// Double vtaxamount= new gnMath().CalTax_Pur(Vamouunt, vper) ;
		// purchasePostingAmount
		// mytaxamount
		vmylinetax = "0.00";

	}

	private void showArticleofsearch(String vsearchItem) throws Throwable {
		// new
		// General().Quickmsg(vsearchItem+""+"Lenght"+""+vsearchItem.length());
		if (vsearchItem.length() > 0) {
			String action = checkVendorEntry();
			// InvoiceDate.setText(grndate.getText()) ;

			String vname = "GRModule";
			String vcomp = companycode.getText();
			String vstore = Storecode.getText();

			// String SQL = "Call GR_get_scanArticle("+vsearchItem+", "+vcomp+"
			// , "+vstore+")" ;
			String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
					new gnPublicVariable().vstore);
			if (vsearchItem.length() > 0 | vsearchItem != null | vsearchItem != "") {
				String SQL = "Call Transaction_getScanArticleDetails( '" + vname + "'  , " + vsearchItem + ", " + vcomp
						+ " , " + vstore + " , '" + vfinyear + "'  , " + vverticlecode + ")";
				String result = checkArticleExist(varticle);
				if (result == "Sucess") {
					new gnLogger().loggerInfoEntry("GRN", "Article code Selected is" + " " + varticle);
					vname = "GR";
					showTable(SQL, vname, PoCol);
				}
			}
		}
	}

	class approve implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				new gnApp().approveDocument(approve, approvedby, approvedate);
			} catch (Throwable e1) {
				e1.printStackTrace();
				new gnLogger().loggerInfoEntry("GRN", "Approval Exception" + " " + e1.getLocalizedMessage());
			}
		}
	}

	class lsnrbrand implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vbrandname = "%" + searchbrand.getText() + "%";
			String vtype = "Brand";
			String vverticle;
			String vverticlecode = "";
			try {
				new gnAdmin().showMasterTable(vtype, brandcode, searchbrand);
				vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
						new gnPublicVariable().vstore);
			} catch (Throwable e2) {
				e2.printStackTrace();
				new gnLogger().loggerInfoEntry("GRN", "Brand Selection Exception" + " " + e2.getLocalizedMessage());
			} finally {
				// String vbrandcode = new gnBrand().rbrandcode;
				String vbrandcode = brandcode.getText();
				String vcomp = companycode.getText();
				String vstore = Storecode.getText();
				vtype = "BrandModule";
				String SQL = "Call Transaction_getScanArticleDetails('" + vtype + "' , '" + vbrandcode + "' , " + vcomp
						+ " , " + vstore + " , '" + vfinyear + "'  , " + vverticlecode + ")";
				new General().msg(SQL);
				String vname = "GR";
				try {
					showTable(SQL, vname, PoCol);
					searchbrand.setText("");
					new gnLogger().loggerInfoEntry("GRN", "Brand Item Display Done");
				} catch (Throwable e1) {
					e1.printStackTrace();
					new gnLogger().loggerInfoEntry("GRN",
							"Brand Item Display Exception" + " " + e1.getLocalizedMessage());
					new General().msg(e1.getLocalizedMessage());
				}
			}
		}
	}

	public void fetchGrProcess() throws ClassNotFoundException, SQLException {
		if (vallow == "N") {
			new General().Quickmsg("Complete Day Begin First ...");
		}

		String status = new gnCheckArticle().checkVendorSelected(VendorCode, VendorName);
		if (status == "Sucess") {
			try {
				String vvendor = VendorCode.getText();
				new gnGrn().get_GrnoforVendor("GR", vvendor);
			} catch (Throwable e1) {
				e1.printStackTrace();
				new General().Quickmsg("Grnno Search" + " " + e1.getMessage());
			} finally {
				grnno.setText(new gnGrn().rgrnno);
				grndate.setText(new gnGrn().rgrndate);
				new gnGrn().rgrnno = null;
				if (grnno.getText().length() == 0) {
					reset();
				}
				if (grnno.getText().length() > 0) {
					String vname = "GRSearch";
					String vcomp = companycode.getText();
					String vstore = Storecode.getText();
					String vgrnno = grnno.getText();
					// String vvendor = VendorCode.getText() ;
					String vgrdate = new gnConfig().date_ConverttoDBforamt(grndate.getText());
					String SQL = "Call GR_Fetchwithoutpo( " + vgrnno + " ,   '" + vgrdate + "', " + vcomp + ",  "
							+ vstore + "  )";
					try {
						showTable(SQL, vname, PoCol);
						scanItem.setVisible(true);
						// scanName.setVisible(true);
						// searchbrand.setVisible(true);
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().Quickmsg("Grn Data Fetch" + " " + e1.getMessage());
					}
				}
			}
		}
	}

	class lsBtn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			// nitin

			if (value == "Price Change") {
				try {
					updatePrice window;
					window = new updatePrice();
					window.updatePriceFrame.setVisible(true);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			if (value == "Payment") {
				try {
					paymentVoucher window;
					window = new paymentVoucher();
					window.frmpaymentvoucher.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Edit Purchase") {
				new gnLogger().loggerInfoEntry("GRN", "Edit Purchase Option Seleted- Edit Process");
				EditMode = "Y";
				// btnEdit.setBackground(Color.BLUE);
				// btnEdit.setForeground(Color.WHITE);
				scanItem.setVisible(false);
				scanName.setVisible(false);
				searchbrand.setVisible(false);
				lsnrCustName abc = new lsnrCustName();
				abc.actionPerformed(e);
			}

			if (value == "Account Entry") {

				String vtype = "GRN";
				String vdocno = grnno.getText();
				String vdocdate = grndate.getText();
				try {
					new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
					new gnLogger().loggerInfoEntry("GRN", "User Clicked -View Account Entry Posting");
				} catch (Throwable e1) {
					e1.printStackTrace();
					new gnLogger().loggerInfoEntry("GRN",
							"View Account Entry Posting Exception" + " " + e1.getLocalizedMessage());
				}
			}

 
			
			
			if (value == "Article Analytics") {
				int row = table.getSelectedRow();
				varticlecode = table.getValueAt(row, 1).toString();
				varticlename = table.getValueAt(row, 2).toString();
				try {
					Artilce_otherInfo window;
					window = new Artilce_otherInfo();
					window.ArticleViewFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Gen.Barcode") {
				// new General().Quickmsg("Chek Printer ...");
				String vdocno = grnno.getText();
				String vdocdate = grndate.getText();
				String vdoctype = "GR";
				try {
					new gnBarcode().generate(vdocno, vdoctype, vdocdate);
				} catch (Throwable e1) {
					e1.printStackTrace();
					new gnLogger().loggerInfoEntry("GRN",
							"Barcode Generation Exception" + " " + e1.getLocalizedMessage());
					new General().msg(e1.getLocalizedMessage());
				}
				return;
			}

			
 
			if (value == "Close") {
				GRNModuleFrame.dispose();
				new gnLogger().loggerInfoEntry("GRN", "GRN Form Closed by user");
			}

			if (value == "Print") {
				// new General().Quickmsg("Printer is not connected...");
				btnPrint.setEnabled(true);
				try {
					callprint();
				} catch (Throwable e1) {
					e1.printStackTrace();
					new gnLogger().loggerInfoEntry("GRN", "GRN Printing Exception" + " " + e1.getLocalizedMessage());
				}
				btnPrint.setEnabled(false);
				// btnUpdate.setEnabled(false);
				btnSave.setEnabled(true);
				reset();
			}

			if (value == "Update") {
				String action = CheckBatchArticle();
				if (action == "Sucess") {
					try {
						callUpdateEvent();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
			}

			if (value == "Day Book") {
				try {
					vmyrow = 3;
					dayBook window;
					window = new dayBook();
					window.dayBookFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}

			}

			if (value == "Item") {
				try {
					ArticleBase_Master window;
					window = new ArticleBase_Master();
					window.articlebasemasterFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Save-F8") {
				try {
					btnPrint.setEnabled(true);
					String action = CheckBatchArticle();
					if (action == "Sucess") {
						String vpara811 = "811";
						String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811,
								vcomp, vstore);
						switch (vmaintainbatchforNonBatchItem) {
						case "Y":
							if (EditMode == "N")
							{
								GenerateBatchNow();
 							}
  							break;
						}
						String action1 = CheckCost();
						if (action1 == "Sucess") {
							callSaveEvent();
						}
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				}

			} // End Save

		}
	}

	private void callprint() throws Throwable {
		String vdocno = grnno.getText();
		String vdoctype = "GRN";
		new gnDocPrint().callprint(vdoctype, vdocno, grndate.getText());
	}

	/// Supplier
	class lsnrCustName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				String vtype = "Vendor";
				String sname = VendorName.getText().trim();
				sname = "%" + sname + "%";
				// stable = new gnSupplier().getSupplierintable(sname);
				// stable.grabFocus();
				// showSeatchintable(stable);
				new gnSupplier().getSupplier(sname);
				// new gnSupplier().getSupplierNew(sname , VendorCode ,
				// VendorName);
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				VendorCode.setText(new gnSupplier().rvendorcode);
				VendorName.setText(new gnSupplier().rvendorName);
				mobile.setText(new gnSupplier().rPhone);
				email.setText(new gnSupplier().rEmail);
				creditDays.setText(new gnSupplier().rcrdays);
				statecode.setText(new gnSupplier().rstatecode);
				statename.setText(new gnSupplier().rstatename);
				purtypeEffetc();
				new gnLogger().loggerInfoEntry("GRN", "Supplier Selected");
				try {
					applyRevchrg();
					if (EditMode == "Y") {
						// btnUpdate.setEnabled(false);
						fetchGrProcess();
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
					new gnLogger().loggerInfoEntry("GRN",
							"Supplier Selection  Exception" + " " + e1.getLocalizedMessage());
				} finally {
				}
			}
		}
	}

	class lscust implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (vallow == "N") {
				GRNModuleFrame.dispose();
				new General().Quickmsg("Complete Day Begin First ...");
			}
			System.out.println("Value" + value);
			if (i == 1001) {
				try {
					// setVendor(vVname) ;
					String vVname = VendorCode.getText();
					if (vVname.length() > 0) {
						new gnSupplier().setScanSupplier(VendorCode, VendorName, vVname);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					new gnLogger().loggerInfoEntry("GRN",
							"Supplier code Selection Exception" + " " + e1.getLocalizedMessage());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					new gnLogger().loggerInfoEntry("GRN",
							"Supplier code Selection Exception" + " " + e1.getLocalizedMessage());
				} catch (Throwable e1) {
					e1.printStackTrace();
					new gnLogger().loggerInfoEntry("GRN",
							"Supplier code Selection Exception" + " " + e1.getLocalizedMessage());
				} finally {
					//
					VendorCode.setText(new gnSupplier().rvendorcode);
					VendorName.setText(new gnSupplier().rvendorName);
					mobile.setText(new gnSupplier().rPhone);
					email.setText(new gnSupplier().rEmail);
					creditDays.setText(new gnSupplier().rcrdays);
					statecode.setText(new gnSupplier().rstatecode);
					statename.setText(new gnSupplier().rstatename);
					scanItem.grabFocus();
					try {
						applyRevchrg();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	public void showGrn(String vndorcode) throws Throwable {
		chekcFreezeYear();
		scanItem.setVisible(true);
		// scanName.setVisible(true);
		searchbrand.setVisible(false);
		btnEdit.setVisible(true);
		btnEdit.setEnabled(false);
		vallow = "Y";
		EditMode = "Y";
		// btnUpdate.setEnabled(false);
		btnEdit.setBackground(Color.red);
		btnEdit.setForeground(Color.WHITE);
		grndate.setBackground(Color.white);
		try {
			new gnSupplier().setScanSupplier(VendorCode, VendorName, vndorcode);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			VendorCode.setText(new gnSupplier().rvendorcode);
			VendorName.setText(new gnSupplier().rvendorName);
			mobile.setText(new gnSupplier().rPhone);
			email.setText(new gnSupplier().rEmail);
			creditDays.setText(new gnSupplier().rcrdays);
			statecode.setText(new gnSupplier().rstatecode);
			statename.setText(new gnSupplier().rstatename);
			grnno.setText(new gnGrn().rgrnno);
			grndate.setText(new gnGrn().rgrndate);
			try {
				applyRevchrg();
				String vname = "GRSearch";
				String vcomp = companycode.getText();
				String vstore = Storecode.getText();
				String vgrnno = grnno.getText();
				String vtype = "GRModule";
				// String vvendor = VendorCode.getText() ;
				String vgrdate = new gnConfig().date_ConverttoDBforamt(grndate.getText());
				String SQL = "Call GR_FetchGRData(  '" + vtype + "',   " + vcomp + ",  " + vstore + " , " + vgrnno
						+ " ,   '" + vgrdate + "' )";
				showTable(SQL, vname, PoCol);
				scanItem.setVisible(true);
				scanName.setVisible(true);
				searchbrand.setVisible(true);
				scanItem.grabFocus();
				new gnSupplier().rvendorName = "";
				new gnSupplier().rvendorcode = "";
				// fetchGrProcess() ;
			} catch (Throwable e) {
				e.printStackTrace();
				new gnLogger().loggerInfoEntry("GRN", "GRN Fetch Data  Exception" + " " + e.getLocalizedMessage());
			} finally {
				table.setBackground(Color.BLACK);
				table.setForeground(Color.white);
				table.setGridColor(Color.green);
			}
		}
	}

	/// supplier / Article related for diplay in table < based on name search >
	class lsnritemName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			searchName();
		}
	}

	/*
	 * private void searchName() { if (vallow == "N") {
	 * GRNModuleFrame.dispose(); new General().Quickmsg(
	 * "Complete Day Begin First ..."); } try { String vcomp = new
	 * gnConfig().getCompanyCode(); } catch (Throwable e2) {
	 * e2.printStackTrace(); } // String sname = scanName.getText().trim();
	 * String sname = scanItem.getText().trim(); sname = "%" + sname + "%"; try
	 * { String vtype = "Article"; String varticle1 = ""; String vtrantype1 =
	 * "GRWPO"; String status = checkGrnDate(); if (status == "Sucess") { new
	 * gnAdmin().rArticle = "0"; new gnAdmin().Search(vtype, sname, varticle1,
	 * vtrantype1);
	 * 
	 * String vpara716 = "716"; // new General().msg(vpara716); String
	 * vallowpopupHelp = new
	 * getConfigurationSetting().getSpecificConfiguration(vpara716); switch
	 * (vallowpopupHelp) { case "Y": new gnAdmin().Search(vtype, sname,
	 * varticle, vtrantype1); // if break; case "N": new gnAdmin().Search(vtype,
	 * sname, varticle, vtrantype1); //stable.requestFocus();
	 * //stable.grabFocus(); //showSeatchintable(stable); break; } } } catch
	 * (SQLException e1) { e1.printStackTrace(); new
	 * gnLogger().loggerInfoEntry("GRN", "Item Search by Name Exception" + " " +
	 * e1.getLocalizedMessage()); } catch (ClassNotFoundException e1) {
	 * e1.printStackTrace(); new gnLogger().loggerInfoEntry("GRN",
	 * "Item Search by Name Exception" + " " + e1.getLocalizedMessage()); }
	 * catch (Throwable e1) { e1.printStackTrace(); new
	 * gnLogger().loggerInfoEntry("GRN", "Item Search by Name Exception" + " " +
	 * e1.getLocalizedMessage()); } finally { try { if (new
	 * gnAdmin().rArticle.length() > 0 && new gnAdmin().rArticle != "" && new
	 * gnAdmin().rArticle != null) { showArticleofsearch(new
	 * gnAdmin().rArticle); new gnAdmin().rArticle = "0"; } } catch (Throwable
	 * e1) { e1.printStackTrace(); } } }
	 * 
	 */

	private void searchName() {

		if (vallow == "N") {
			GRNModuleFrame.dispose();
			new General().Quickmsg("Complete Day Begin First ...");
		}
		try {
			String vcomp = new gnConfig().getCompanyCode();
		} catch (Throwable e2) {
			e2.printStackTrace();
		}
		// String sname = scanName.getText().trim();
		String sname = scanItem.getText().trim();
		sname = "%" + sname + "%";
		try {
			String vtype = "Article";
			String varticle1 = "";
			String vtrantype1 = "GRWPO";
			String status = checkGrnDate();
			if (status == "Sucess") {

				new gnAdmin().rArticle = "0";
				new gnAdmin().Search(vtype, sname, varticle1, vtrantype1);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
			new gnLogger().loggerInfoEntry("GRN", "Item Search by Name Exception" + " " + e1.getLocalizedMessage());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			new gnLogger().loggerInfoEntry("GRN", "Item Search by Name Exception" + " " + e1.getLocalizedMessage());
		} catch (Throwable e1) {
			e1.printStackTrace();
			new gnLogger().loggerInfoEntry("GRN", "Item Search by Name Exception" + " " + e1.getLocalizedMessage());
		} finally {
			try {
				if (new gnAdmin().rArticle.length() > 0 && new gnAdmin().rArticle != ""
						&& new gnAdmin().rArticle != null) {
					showArticleofsearch(new gnAdmin().rArticle);
					new gnAdmin().rArticle = "0";
				}
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	private void applyRevchrg() throws Throwable {
		if (VendorCode.getText().length() > 0) {
			regdlr.setText(new gnGST().isSupplierGSTRegister(VendorCode.getText()));
		}
		String vvregdlr = regdlr.getText();
		String vvmygststatus = new gnGST().ismyComanyGSTRegister();
		chrevcgrg.setSelected(false);
		chrevcgrg.setEnabled(true);
		switch (vvregdlr) {
		case "N":
			switch (vvmygststatus) {
			case "Y":
				chrevcgrg.setSelected(true);
				chrevcgrg.setEnabled(false);
				new General().Quickmsg("Please Check - Reverse Charg is Applicable For this Supplier");
				new gnLogger().loggerInfoEntry("GRN",
						"Reverse Charge Applicable for this Transaction- Supplier is not GST Register");
			}
			break;
		}

		vscheme = new gnGST().getSupplierSchemecode(VendorCode.getText());
		switch (vscheme) {
		case "0":
			regdlr.setBackground(Color.BLACK);
			regdlr.setForeground(Color.WHITE);
			break;
		case "1":
			regdlr.setBackground(Color.YELLOW);
			regdlr.setForeground(Color.BLUE);
			break;
		case "2":
			regdlr.setBackground(Color.blue);
			regdlr.setForeground(Color.WHITE);
			break;
		}

	}

	private void checkOthCharges() {
		if (Othcharges.getText() == "0")// || Othcharges.getText() == "0.00" ||
		{
			// new General().Quickmsg("dsdsdsd oth chrg");
			purchasePostingAmount.setVisible(false);
			lblNewLabel_9.setVisible(false);
		}
	}

	class editLsnr111 implements ActionListener {
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
				new General().msgDispose();
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				try {
					// new General().Quickmsg("row" +" "+editrow);
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

	public void SelectrowforEditold() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				editrow = table.getSelectedRow();
				// mysplit.setDividerLocation(45);
				String vqty = (table.getValueAt(editrow, 5).toString());
				String vrate = (String) table.getValueAt(editrow, 6);
				String vcode = (String) table.getValueAt(editrow, 1);
				String vname = (String) table.getValueAt(editrow, 2);
				try {
					vpurchaseUOM.setText(new gnArticle().Article_getData(vcode, "PurchaseUOM"));
					vinnerqty.setText(new gnArticle().Article_getData(vcode, "innerqty"));
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

	private void GenerateBatchNow() {
 		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			try {
				mrpbatch_checkAndManage(i);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void mrpbatch_checkAndManage(int row) throws Throwable {
		selectedrow = row;
		String vmrp = "0";
		String vsp = "0";
		String vcost = "0";
		String vbatchno = "0";
		String varticle = "0";
		double vmybatchno = 0.00;
		varticle = table.getValueAt(selectedrow, 1).toString();
		vcost = table.getValueAt(selectedrow, 6).toString();
		vmrp = table.getValueAt(selectedrow, 21).toString();
		vsp = table.getValueAt(selectedrow, 22).toString();
		vbatchno = new gnBatch().checkBatchForPurchase(varticle, vmrp, vsp, vcost);
		vmybatchno = Double.parseDouble(vbatchno);
		if (vmybatchno > 0.0) {
			// table.setValueAt(vbatchno, selectedrow, 18);
			vbatchno = new gnBatch().getNewBatch();
			table.setValueAt(vbatchno, selectedrow, 18);
		} else {
			double mybatch = Double.parseDouble(table.getValueAt(selectedrow, 18).toString());
			if (mybatch <= 0) {
				vbatchno = new gnBatch().getNewBatch();
				table.setValueAt(vbatchno, selectedrow, 18);
			}
		}
	}

	public void showTable(String SQL, String type, String[] Colnames) throws Throwable {
		// String PoCol[] = {"Type" ,"Article_code" , "Name" , "Pur,UOM" , "Qty"
		// , "Units" , "Pur.Price" ,
		// "Base Value " , "Line Disc." , "Disc", "BasePurValue"
		// , "Tax%" , "Tax.Amt" , "Pur.Incl Tax" , "Oth.Chrg" , "Landing Cost",
		// "Bal Qty", "Batch_Control" , "Batch No" , "Expiry date" , "POQTY" ,
		// "MRP", "SP"};
		changeqty.setText(null);
		changerate.setText(null);
		chnagemrp.setText(null);
		chnagesp.setText(null);
		// mysplit.setDividerLocation(0);
		checkOthCharges();
		String vapprstatus = "";
		String status = checkGrnDate();
		((DefaultTableModel) model).setColumnIdentifiers(Colnames);
		table.setModel(model);
		table.setRowHeight(40);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		if (status == "Sucess") {
			// CheckBatchArticle();
			switch (type) {
			case "GR":
				rs = this.getSPResult(SQL);
				// new gnTable().tableColumnAdjust(table);
				while (rs.next()) {
					boolean vselection = chrevcgrg.isSelected();
					vmyarticle = rs.getString(1);
					model.insertRow(0,
							new Object[] { "DEL", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
									rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
									rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
									rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
									rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21),
									rs.getString(22), rs.getString(23), rs.getString(24) });
					QueryStatus = "Y";
					dispname.setText(rs.getString(2));
					setlastDetails();
					table.setModel(model);
					selectedrow = 0;
					table.setCursor(new Cursor(Cursor.HAND_CURSOR));
					new gnTable().setTableBasics(table);
					table.setRowHeight(35);
					table.getColumnModel().getColumn(0).getCellRenderer();
					table.setGridColor(Color.BLUE);
					table.setEnabled(true);
					removeRow(model, table);
					scanItem.setText("");
					if (table.getRowCount() > 0) {
						// btnUpdate.setEnabled(false);
						btnSave.setEnabled(true);
					}
				} // While
				break;

			case "GRSearch":
				rs = this.getSPResult(SQL);
				((DefaultTableModel) model).setColumnIdentifiers(Colnames);
				table.setModel(model);
				new gnTable().RemoveTableRows(model);
				while (rs.next()) {
					model.insertRow(0,
							new Object[] { "Update", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
									rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
									rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
									rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17),
									rs.getString(18), rs.getString(19), rs.getString(20), rs.getString(21),
									rs.getString(22), rs.getString(23), rs.getString(24) });
					new gnTable().setTableBasics(table);
					InvoiceNumber.setText(rs.getString(27));
					InvoiceDate.setText(rs.getString(28));
					InvAmt.setText(rs.getString(29));
					pono.setText(rs.getString(30));
					podate.setText(rs.getString(31));
					// new General().Quickmsg(rs.getString(30));
					table.setGridColor(Color.YELLOW);
					table.setCursor(new Cursor(Cursor.HAND_CURSOR));
					vapprstatus = rs.getString(31);
					approvedby.setText(rs.getString(33));
					approvedate.setText(rs.getString(34));
				} // End GrSearch

				if (table.getRowCount() > 0) {
					// btnUpdate.setEnabled(true);
					// btnSave.setEnabled(false);
				}
				switch (vapprstatus) {
				case "Y":
					approve.setSelected(true);
					btnSave.setEnabled(true);
					// btnUpdate.setEnabled(false);
					btnPrint.setEnabled(true);
					approve.setBackground(Color.GREEN);
					table.setShowGrid(true);
					table.setGridColor(Color.GREEN);
					approve.setEnabled(false);
					// table.setEnabled(false);
					btnBarcode.setEnabled(true);
					break;
				case "N":
					btnSave.setEnabled(false);
					// btnUpdate.setEnabled(true);
					btnPrint.setEnabled(false);
					approve.setSelected(false);
					table.setEnabled(true);
					break;
				}
				// }
				break;
			}
			new gnTable().setTableBasics(table);
			table.setAutoResizeMode(1);
			resetFigures();
			// String PoCol[] = { "Type", "Article_code", "Name", "Pur,UOM",
			// "Qty", "Units", "Unit PurPrice", "Base Value ",
			// "Line Disc.", "Disc", "BasePurValue", "Tax%", "Tax.Amt",
			// "Pur.Incl Tax", "Oth.Chrg", "Landing Cost",
			// "Bal Qty", "Batch_Control", "Batch No", "Expiry date" , "POQty"
			// };
			new gnTable().setTablewidth(table, 1, 70);
			new gnTable().setTablewidth(table, 0, 40);
			new gnTable().setTablewidth(table, 2, 400);
			new gnTable().setTablewidth(table, 5, 100);
			new gnTable().setTablewidth(table, 5, 100);
			new gnTable().setTablewidth(table, 6, 100);
			new gnTable().setTablewidth(table, 7, 100);
			new gnTable().setTablewidth(table, 8, 100);
			new gnTable().setTablewidth(table, 9, 100);
			new gnTable().setTablewidth(table, 11, 100);
			new gnTable().setTablewidth(table, 12, 100);
			new gnTable().setTablewidth(table, 13, 100);
			new gnTable().setTablewidth(table, 14, 100);
			new gnTable().setTablewidth(table, 15, 150);
			new gnTable().setTablewidth(table, 16, 20);
			new gnTable().setTablewidth(table, 17, 20);
			new gnTable().setTablewidth(table, 17, 20);

			new gnTable().setTablewidth(table, 3, 50);

			table.setCellSelectionEnabled(false);
			table.setRowSelectionAllowed(true);
			table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);

			ActionListener expdtr = new expDate();
			vexpedtr = new JTextField();
			vexpedtr.setBackground(Color.GREEN);
			table.getColumnModel().getColumn(16).setCellEditor(new DefaultCellEditor(vexpedtr));
			vexpedtr.addActionListener(expdtr);

			ActionListener mnfdtr = new manufDate();
			vmafdate = new JTextField();
			vmafdate.setBackground(Color.GREEN);
			table.getColumnModel().getColumn(15).setCellEditor(new DefaultCellEditor(vmafdate));
			vmafdate.addActionListener(mnfdtr);
			SelectrowforEdit();
			if (QueryStatus.equals("Y")) {
				popupWindowForQtyPrice();
			}

		}
	}// End Show Table

	private void setlastDetails() throws Throwable {
		// new General().Quickmsg(vmyarticle);
		String vsupplier = VendorCode.getText();

		String vtype = "LastDate";
		// lbldate.setText(new gnPurchase().getLastArticlePurchaseDetails(vtype,
		// vmyarticle, vsupplier));

		vtype = "LastQty";
		lblqty.setText(new gnPurchase().getLastArticlePurchaseDetails(vtype, vmyarticle, vsupplier));

		vtype = "Lastpurchaseprice";
		lblcost.setText(new gnPurchase().getLastArticlePurchaseDetails(vtype, vmyarticle, vsupplier));

		vtype = "Lastmrp";
		lblmrp.setText(new gnPurchase().getLastArticlePurchaseDetails(vtype, vmyarticle, vsupplier));

		vtype = "LastSP";
		lblsp.setText(new gnPurchase().getLastArticlePurchaseDetails(vtype, vmyarticle, vsupplier));

		vtype = "LastLC";
		lblLC.setText(new gnPurchase().getLastArticlePurchaseDetails(vtype, vmyarticle, vsupplier));

	}

	class expDate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row = table.getSelectedRow();
			// CellEditorListener hh ;
			String value = (String) table.getValueAt(row, 16);
			try {
				new selectdate().setTableCellDate(vexpedtr, table, row, 16);
			} catch (Throwable e) {
				e.printStackTrace();
				new gnLogger().loggerInfoEntry("GRN",
						"Expiry Date Selection Exception" + " " + e.getLocalizedMessage());
			} finally {
			}
		}
	}

	class manufDate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row = table.getSelectedRow();
			// CellEditorListener hh ;
			String value = (String) table.getValueAt(row, 15);
			try {
				new selectdate().setTableCellDate(vmafdate, table, row, 15);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				new gnLogger().loggerInfoEntry("GRN", "Manuf Date Selection Exception" + " " + e.getLocalizedMessage());
			} finally {
			}
		}
	}

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			// e.notifyAll();
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 1);
			try {
				QtychangeImapct(value, row);
			} catch (SQLException e1) {
				new General().Quickmsg("Qty Change" + "" + e1.getMessage());
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				new General().Quickmsg("Qty Change" + "" + e1.getMessage());
			}
		}
	};
	
 
	public String QtychangeImapct(String value, int i) throws SQLException, ClassNotFoundException {

		// String PoCol[] = { "Type", "Article_code", "Name", "UOM", "InvQty",
		// "Recd.Qty", "Rate", "Base Value ",
		// "Line Disc.", "Disc", "PurValue", "Tax%", "Tax.Amt", "Pur.Incl Tax",
		// "Oth.Chrg", "Landing Cost",
		// "Bal Qty", "Batch_Control", "Batch No", "Expiry date" , "POQty",
		// "MRP", "SP" , "LC-PerUnit" };

		String varticlepuom = "";
		String vpuruom = (String) table.getValueAt(i, 3).toString().trim();
		/*
		 * switch (vpuruom) { case "NO": String baseqty = (String)
		 * table.getValueAt(i, 4).toString(); //new General().Quickmsg(baseqty);
		 * //table.setValueAt(baseqty, i, 5); break;
		 * 
		 * case "No": baseqty = (String) table.getValueAt(i, 5).toString(); new
		 * General().Quickmsg(baseqty); table.setValueAt(baseqty, i, 5); break;
		 * 
		 * case "KG": String baseqty1 = (String) table.getValueAt(i,
		 * 4).toString(); new General().Quickmsg(baseqty);
		 * table.setValueAt(baseqty1, i, 5); break;
		 * 
		 * case "GM": String baseqty2 = (String) table.getValueAt(i,
		 * 4).toString(); //new General().Quickmsg(baseqty);
		 * //table.setValueAt(baseqty2, i, 5); break;
		 * 
		 * case "ML": String baseqty3 = (String) table.getValueAt(i,
		 * 4).toString(); //new General().Quickmsg(baseqty);
		 * //table.setValueAt(baseqty3, i, 5); break;
		 * 
		 * case "LT": String baseqty4 = (String) table.getValueAt(i,
		 * 4).toString(); //new General().Quickmsg(baseqty);
		 * table.setValueAt(baseqty4, i, 5); break;
		 * 
		 * case "LTR": String baseqty5 = (String) table.getValueAt(i,
		 * 4).toString(); //new General().Quickmsg(baseqty);
		 * table.setValueAt(baseqty5, i, 5); break;
		 * 
		 * 
		 * case "BOX": varticlepuom = new gnArticle().Article_getData(value,
		 * "PurchaseUOM"); if (varticlepuom.trim().equals("BOX")) { String
		 * innerQty = new gnArticle().Article_getData(value, "innerQty"); double
		 * vinnerqty = Double.parseDouble(innerQty); double mybaseqty =
		 * Double.parseDouble(table.getValueAt(i, 4).toString());
		 * table.setValueAt(mybaseqty * vinnerqty, i, 5); } break;
		 * 
		 * case "STRIPE": varticlepuom = new gnArticle().Article_getData(value,
		 * "PurchaseUOM"); if (varticlepuom.trim().equals("STRIPE")) { String
		 * innerQty = new gnArticle().Article_getData(value, "innerQty"); double
		 * vinnerqty = Double.parseDouble(innerQty); double mybaseqty =
		 * Double.parseDouble(table.getValueAt(i, 4).toString());
		 * table.setValueAt(mybaseqty * vinnerqty, i, 5); } break;
		 * 
		 * case "CARTON": varticlepuom = new gnArticle().Article_getData(value,
		 * "PurchaseUOM"); if (varticlepuom.trim().equals("CARTON")) { String
		 * innerQty = new gnArticle().Article_getData(value, "innerQty"); double
		 * vinnerqty = Double.parseDouble(innerQty); double mybaseqty =
		 * Double.parseDouble(table.getValueAt(i, 4).toString());
		 * table.setValueAt(mybaseqty * vinnerqty, i, 5); } break; }
		 */
		String curqty1 = (String) table.getValueAt(i, 5).toString();
		Double curqty = Double.parseDouble(curqty1);
		if (curqty <= 0) {
			table.setEditingRow(i);
			table.setGridColor(Color.YELLOW);
			table.setBackground(Color.red);
		}

		// String PoCol[] = {"Type" , 1"Article_code" ,2 "Name" , 3"Pur,UOM" ,
		// 4"Qty" , 5"Units" , 6"Pur.Price" ,
		// 7"Base Value " , 8"Line Disc." ,9 "Disc", 10"BasePurValue",
		// , 11"Tax%" , 12"Tax.Amt" , 13 "Pur.Incl Tax" , 14"Oth.Chrg" ,15
		// "Landing Cost",
		// 16"Bal Qty", 17 "Batch_Control" ,18 "Batch No" ,19 "Expiry date"};

		Double vqty = Double.parseDouble(table.getValueAt(i, 5).toString());
		Double vcost = Double.parseDouble(table.getValueAt(i, 6).toString());
		Double vlinedisc = Double.parseDouble(table.getValueAt(i, 8).toString());
		Double vdisc = Double.parseDouble(table.getValueAt(i, 9).toString());
		double vtotaldisc = vlinedisc + vdisc;

		Double vcostValue1 = (vqty * vcost);
		table.setValueAt(new gnMath().get2DecimaltValue(Double.toString(vcostValue1)), i, 7);

		Double vothchrg = Double.parseDouble(table.getValueAt(i, 14).toString());
		double vcharges = vothchrg;

		// here for other charges
		Double vcostValue = 0.00;
		if (calculateTaxonOthchrg == "N") {
			vcostValue = vcostValue1 - vtotaldisc; // other cherges not consider
													// for tax calculation
		}
		if (calculateTaxonOthchrg == "Y") {
			vcostValue = vcostValue1 - vtotaldisc + vothchrg; // other charges
																// consider for
																// tax
																// calcluation
		}

		// new General().Quickmsg("costvalue"+" " +vcostValue1 +"disc "+"
		// "+vtotaldisc +"purbase value "+" "+vcostValue);
		table.setValueAt(vcostValue, i, 0);

		table.setValueAt(vcostValue, i, 10);

		Double vtaxamount = new gnMath().CalTax_Pur(vcostValue, Double.parseDouble(table.getValueAt(i, 11).toString()));
		table.setValueAt(new gnMath().get2DecimaltValue(Double.toString(vtaxamount)), i, 12);

		vcostValue = vcostValue + vtaxamount;
		table.setValueAt(new gnMath().get2DecimaltValue(Double.toString(vcostValue)), i, 13);

		// here for other charges
		Double vlandingcost = 0.0;
		if (calculateTaxonOthchrg == "N") {
			vlandingcost = (vcostValue + vcharges); // Other Chnages included in
													// vcostvalue
			table.setValueAt(new gnMath().get2DecimaltValue(Double.toString(vlandingcost)), i, 15);
		}

		if (calculateTaxonOthchrg == "Y") {
			vlandingcost = (vcostValue);
			table.setValueAt(new gnMath().get2DecimaltValue(Double.toString(vlandingcost)), i, 15);
		}

		double vulc = vlandingcost / vqty;
		table.setValueAt(new gnMath().get2DecimaltValue(Double.toString(vulc)), i, 23);

		double vsp = Double.parseDouble(table.getValueAt(i, 22).toString());

		if (vsp < vulc) {
			new General().Quickmsg("Please Check Sales  Price is lower then Landing cost ");
			new gnImageSound().playAlertSound();
		}

		//
		// basePurchasePrice
		// totaldisc
		// purchasePostingAmount
		// mytaxamount
		// SupplierPayable --with tax
		// otherCharges
		// roundingamt
		// roundingamt
		//
		try {
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		set2DecimalValues();
		resetFigures();
		new gnLogger().loggerInfoEntry("GRN", "Item Edited" + "Line  " + i + "  Article" + value);
		String action = "Sucess";
		table.addNotify();
		try {
		} catch (Throwable e) {
			e.printStackTrace();
			new gnLogger().loggerInfoEntry("GRN", "Item Edit Exception" + " " + e.getLocalizedMessage());
		} finally {
			table.addNotify();
		}
		scanItem.grabFocus();
		return action;
	}

	public void removeRow(DefaultTableModel model, JTable table) {
		TableColumn Del = table.getColumnModel().getColumn(0);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setText("Remove");
		chkbox.setVisible(true);
		chkbox.setOpaque(true);
		chkbox.setToolTipText("Remove Row ");
		chkbox.setSelected(true);
		Del.setCellEditor(new DefaultCellEditor(chkbox));
		TableCellRenderer hdr = Del.getHeaderRenderer();
		table.getColumnModel().setColumnMargin(1);
		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int nn = e.getStateChange();
				if (nn == 2 && model == model) {
					int lastrow = table.getRowCount();
					int r = table.getSelectedRow();
					int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
					if (option == 0) {
						model.removeRow(r);
						resetFigures();
						scanItem.grabFocus();
						new gnLogger().loggerInfoEntry("GRN", "Item Removed");
					}
					return;
				}
			}
		});
	}

	public void resetFigures() {
		// String PoCol[] = {"Type" , 1"Article_code" ,2 "Name" , 3"Pur,UOM" ,
		// 4"Qty" , 5"Units" , 6"Pur.Price" ,
		// 7"Base Value " , 8"Line Disc." ,9 "Disc", 10"BasePurValue",
		// , 11"Tax%" , 12"Tax.Amt" , 13 "Pur.Incl Tax" , 14"Oth.Chrg" ,15
		// "Landing Cost",
		// 16"Bal Qty", 17 "Batch_Control" ,18 "Batch No" ,19 "Expiry date"};

		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		records.setText(RecordCount1);

		totalqty.setText(new gnMath().get2DecimaltValue(Double.toString(new gnTable().getTotal(table, 5))));
		basePurchasePrice.setText(new gnMath().get2DecimaltValue(Double.toString(new gnTable().getTotal(table, 7))));

		Double vbasepur = new gnTable().getTotal(table, 7);

		Double vlinedisc = new gnTable().getTotal(table, 8);
		Double vdisc = new gnTable().getTotal(table, 9);
		double vtotaldisc = vlinedisc + vdisc;
		double vnetbasepur = vbasepur - vtotaldisc;
		totaldisc.setText(new gnMath().get2DecimaltValue(Double.toString(vtotaldisc)));
		purchasePostingAmount.setText(new gnMath().get2DecimaltValue(Double.toString(vnetbasepur)));
		// purchasePostingAmount.setText(new
		// gnMath().get2DecimaltValue(Double.toString(new
		// gnTable().getTotal(table,10))));
		mytaxamount.setText(new gnMath().get2DecimaltValue(Double.toString(new gnTable().getTotal(table, 12))));
		SupplierPayable.setText(new gnMath().get2DecimaltValue(Double.toString(new gnTable().getTotal(table, 13))));
		otherCharges.setText(new gnMath().get2DecimaltValue(Double.toString(new gnTable().getTotal(table, 14))));

		Double vtamt = (new gnTable().getTotal(table, 15));
		int vnetAmtnew = (int) Math.round(vtamt);
		double vroundamt = (vnetAmtnew - vtamt);
		// roundingamt.setText(Double.toString(vroundamt));
		roundingamt.setText(new gnMath().get2DecimaltValue(Double.toString(vroundamt)));

		TotalAmount.setText(new gnMath().get2DecimaltValue(Double.toString(vnetAmtnew)));
		// InvAmt.setText(new gnMath().get2DecimaltValue(Double.toString(new
		// gnTable().getTotal(table, 13))));
	}

	public void setVendor(String vcode) throws SQLException, ClassNotFoundException {
		String vendorQuery = "Call  getScanCustomer(" + vcode + ")";
		rs = this.getSPResult(vendorQuery);
		rs.next();
		VendorName.setText(rs.getString(2));
		creditDays.setText(rs.getString(5));
	}

	public String checkVendorEntry() {
		String vcode = VendorCode.getText();
		String action = "Fail";
		if (vcode.length() == 0) {
			new General().Quickmsg("Select Vendor code First for Making GRN");

		}
		return action;
	}

	public String checkArticleExist(String value) {
		String Action = "Sucess";
		int rowCount = 0;
		int i = 0;
		rowCount = table.getRowCount();
		String Colname = "";
		for (i = 0; i < rowCount; i++) {
			Colname = table.getValueAt(i, 1).toString();
			if (Colname.equalsIgnoreCase(value)) {
				new General().Quickmsg("Article is Already Present ..in Table ");
				// Action = "Sucess" ;
				Action = "Fail";
			}
		}
		return Action;
	}

	public String CheckCost() {
		new gnLogger().loggerInfoEntry("GRN", "Validation for Data Entry");
		String Action = "Sucess";
		int rw = table.getRowCount();
		Double vcost = 0.00;
		Double vmrp = 0.00;
		Double vsp = 0.00;
		Double vqty = 0.00;
		Double vlinedisc = 0.00;
		String varticle = " ";

		// Double vtotal = Double.parseDouble(TotalAmount.getText()) ;
		Action = new gnTable().isAmountnegative(TotalAmount.getText());

		for (int k = 0; k < rw; k++) {

			// String PoCol[] = {"Type" , 1"Article_code" ,2 "Name" , 3"Pur,UOM"
			// , 4"Qty" , 5"Units" , 6"Pur.Price" ,
			// 7"Base Value " , 8"Line Disc." ,9 "Disc", 10"BasePurValue",
			// , 11"Tax%" , 12"Tax.Amt" , 13 "Pur.Incl Tax" , 14"Oth.Chrg" ,15
			// "Landing Cost",
			// 16"Bal Qty", 17 "Batch_Control" ,18 "Batch No" ,19 "Expiry
			// date"};
			try {
				vqty = Double.parseDouble(table.getValueAt(k, 5).toString());
				vcost = Double.parseDouble(table.getValueAt(k, 6).toString());
				vlinedisc = Double.parseDouble(table.getValueAt(k, 8).toString());
			} catch (Exception e) {
				new General().Quickmsg("Enter correct Value for qty/Cost/Mrp/Sales Price at row" + " " + k);
			}
			varticle = table.getValueAt(k, 1).toString();
			if (vqty <= 0.00) {
				new General().Quickmsg("Enter Correct Qty  for Item Code " + varticle);
				Action = "Fail";
			}

			if (vcost <= 0.00) {
				new General().Quickmsg("Enter Correct Cost   for Item Code " + varticle);
				Action = "Fail";
			}

			if (vlinedisc < 0.00) {
				new General().Quickmsg("Enter Correct Line Discount  for Item Code " + varticle);
				Action = "Fail";
			}
		}
		new gnLogger().loggerInfoEntry("GRN", "Validation for Data Entry Status" + " " + Action);
		return Action;

	}// cost check End

	public String CheckBatchArticle() {
		String Action = "Sucess";
		String mrpAction = "Sucess";
		String spAction = "Sucess";

		int rw = table.getRowCount();
		String vbatch = " ";
		String vExp = "";
		String vbatchno = " ";
		String varticle = "";
		double vmrpcnt = 0;
		double vspcnt = 0;
		// String PoCol[] = { "Type", "Article_code", "Name", "UOM", "InvQty",
		// "Recd.Qty", "Rate", "Base Value ",
		// "Line Disc.", "Disc", "PurValue", "Tax%", "Tax.Amt", "Pur.Incl Tax",
		// "Oth.Chrg", "Landing Cost",
		// "Bal Qty", "Batch_Control", "Batch No", "Expiry date" , "POQty",
		// "MRP", "SP" , "LC-PerUnit" };

		for (int k = 0; k < rw; k++) {
			vbatch = table.getValueAt(k, 17).toString();
			vExp = table.getValueAt(k, 19).toString();
			vbatchno = table.getValueAt(k, 18).toString();
			varticle = table.getValueAt(k, 1).toString();

			double vmymrp = Double.parseDouble(table.getValueAt(k, 21).toString());
			double vmysp = Double.parseDouble(table.getValueAt(k, 22).toString());
			
 
			if (vmymrp <= 0) {
				Action = "Fail";
				vmrpcnt = vmrpcnt + 1;
				new General().Quickmsg("Please check MRP");
 			}

			if (vmysp <= 0) {
				vspcnt = vspcnt + 1;
				Action = "Fail";
				new General().Quickmsg("Please check SP");
			}

			switch (vbatch) {
			case "Y":
				switch (vExp) {
				case "0":
					new General().Quickmsg("Enter Batch no and Expiry Date for Item Code " + varticle);
					new gnLogger().loggerInfoEntry("GRN", "Message - Batch Not Enter ");
					Action = "Fail";
					break;
				case "":
					new General().Quickmsg("Enter Batch no and Expiry Date for Item Code " + varticle);
					Action = "Fail";
					break;
				}
			}
		}

		if (vmrpcnt > 0) {
			mrpAction = "Fail";
			new General().msg("Please Check MRP .. Sales Price Can't  be Zero");
		}

		if (vspcnt > 0) {
			spAction = "Fail";
			new General().msg("Please Check Sales Price .. Sales Price Can't  be Zero");
		}

		Action = checkValidateExpDateAndBatchno();

		if (Action == "Fail" || mrpAction == "Fail" || spAction == "Fail") {
			Action = "Fail";
		}

		return Action;
	}// Method End

	private String checkValidateExpDateAndBatchno() {
		String status = "Sucess";

		int rw = table.getRowCount();
		String vbatch = " ";
		String vExp = "";
		String vbatchno = " ";
		String varticle = "";

		// String PoCol[] = {"Type" , 1"Article_code" ,2 "Name" , 3"Pur,UOM" ,
		// 4"Qty" , 5"Units" , 6"Pur.Price" ,
		// 7"Base Value " , 8"Line Disc." ,9 "Disc", 10"BasePurValue",
		// , 11"Tax%" , 12"Tax.Amt" , 13 "Pur.Incl Tax" , 14"Oth.Chrg" ,15
		// "Landing Cost",
		// 16"Bal Qty", 17 "Batch_Control" ,18 "Batch No" ,19 "Expiry date"};

		for (int k = 0; k < rw; k++) {
			vbatch = table.getValueAt(k, 17).toString();
			vExp = table.getValueAt(k, 19).toString().trim();
			vbatchno = table.getValueAt(k, 18).toString();
			varticle = table.getValueAt(k, 1).toString();
			if (vbatch.equals("Y")) {
				status = new General().checkDateLength(vExp, varticle, k);
				if (status == "Sucess") {
					status = new General().checkDateFormat(vExp, varticle, k);
				}
				if (status == "Sucess") {
					status = new General().checkValidBatch(vbatchno, varticle, k);
				}
			}
		}
		return status;
	}

	// =======================================Save Button Press Starts Here
	// ============================
	public String checkGrnDate() {
		String status = "Sucess";
		int d01 = grndate.getText().length();
		if (d01 == 0) {
			new General().Quickmsg("Enter Purchase Date");
			grndate.grabFocus();
			status = "Fail";
		}
		return status;
	}

	public void callSaveEvent() throws Throwable {
		resetFigures();
		String vparaRent = "Y";
		if (vparaRent == "Y") {
			boolean vrentpurchase = rb99.isSelected();
			if (vrentpurchase) {
				vlocation = "Rent";
			}
		}

		CheckBatchArticle();

		if (podate.getText().length() > 0) {
			vpodate = new gnConfig().date_ConverttoDBforamt(podate.getText());
		} else {
			vpodate = null;
		}

		vstorecode = Storecode.getText().trim();
		int d01 = grndate.getText().length();
		if (d01 == 0) {
			new General().Quickmsg("Enter Purchase Date");
			grndate.grabFocus();
			return;
		}

		if (EditMode == "N") {
			vgrnDate = new gnConfig().date_ConverttoDBforamt(grndate.getText().trim());
			grnno.setText(new gnSeq().getSeqno("7", "TR"));
			vglcode = new gnSeq().getGlcode("7", "TR");
			vgrnno = Integer.parseInt(grnno.getText());
		}

		if (EditMode == "Y") {
			vgrnDate = new gnConfig().date_ConverttoDBforamt(grndate.getText().trim());
			// grnno.setText(new gnSeq().getSeqno( "7", "TR")) ;
			vglcode = new gnSeq().getGlcode("7", "TR");
			vgrnno = Integer.parseInt(grnno.getText());
		}

		vpono = 000;
		vvendor = Integer.parseInt(VendorCode.getText().trim());

		if (purchasetype.getSelectedItem().toString().equalsIgnoreCase("Credit Purchase")) {
			int d1 = InvoiceDate.getText().length();
			if (d1 == 0) {
				new General().Quickmsg("Enter Supplier Invoice Date");
				InvoiceDate.grabFocus();
				return;
			}

			if (d1 != 10) {
				new General().Quickmsg(
						"Enter Correct Supplier Invoice Date  Format is <<dd.mm.yyyy>> Example ->  29.02.2017 ");
				InvoiceDate.grabFocus();
				return;
			}
		}

		int d = InvoiceNumber.getText().length();
		if (d == 0) {
			new General().Quickmsg("Enter Supplier Invoice Number ");
			InvoiceNumber.grabFocus();
			return;
		}
		vinvno = InvoiceNumber.getText().trim();

		vadvno = advno.getText();
		if (vadvno.length() == 0) {
			vadvno = "0";
		}

		vinvDate = new gnConfig().date_ConverttoDBforamt(InvoiceDate.getText().trim());

		vtype = "WP";

		String vgrtype = grntype.getSelectedItem().toString();
		switch (vgrtype) {
		case "With PO":
			vtype = "PO";
			vpono = Integer.parseInt(pono.getText());
			break;
		case "Without PO":
			vtype = "WP";
			break;
		}

		String vpurype = purchasetype.getSelectedItem().toString();
		switch (vpurype) {
		case "Credit Purchase":
			purchaseType1 = "CR";
			break;
		case "Cash Purchase":
			purchaseType1 = "CA";
			break;
		}

		int d2 = InvAmt.getText().length();
		if (d2 == 0) {
			new General().Quickmsg("Enter Supplier Invoice Amount");
			InvAmt.grabFocus();
			return;
		}
		vinvamt = Double.parseDouble(InvAmt.getText());
		vcostvalue = Double.parseDouble(SupplierPayable.getText());

		int d3 = Othcharges.getText().length();
		if (d3 == 0) {
			Othcharges.setText("0.00");
		}

		vothcharges = Double.parseDouble(Othcharges.getText());
		vtotalamount = Double.parseDouble(TotalAmount.getText());
		vcreateBy = new gnConfig().getUserCode();
		vupdateDate = new gnConfig().date_ConverttoDBforamt(grndate.getText().trim());// grndate.getText().trim();
		vcreditDays = Integer.parseInt(creditDays.getText().trim());
		vduedate = new gnConfig().date_ConverttoDBforamt(new gnConfig().get_duedate(vgrnDate, vcreditDays));
		vverticle = new gnHierarchy().getVerticleCode();
		vcomp = companycode.getText();

		vmygstno = new gnGST().getComanyGSTno();
		vmycompanystate = new gnGST().getmyState();
		vmystatename = new gnGST().getmystatename();
		vmyCompanyisGST = new gnGST().ismyComanyGSTRegister();

		vstate = new gnGST().getCustomerState(VendorCode.getText());
		vstatename = new gnGST().getCustomerStatename(VendorCode.getText());
		vregdlr = new gnGST().isCustmoerGSTRegister(VendorCode.getText());
		vcustGSTno = new gnGST().getCustomerGSTNO(VendorCode.getText());

		vstate = vstate.trim();
		vmycompanystate = vmycompanystate.trim();

		int vmy = Integer.parseInt(vmycompanystate.trim());
		int voth = Integer.parseInt(vstate.trim());

		boolean vimp = importgoods.isSelected();
		if (vimp) {
			vimport = "Y";
		} else {
			vimport = "N";
		}

		boolean vsz = sez.isSelected();
		if (vsz) {
			vsez = "Y";
		} else {
			vsez = "N";
		}

		if (vmy - voth == 0) {
			vmovtype = "Intra-State";
		}

		if (vmy - voth != 0) {
			vmovtype = "Inter-State";
		}

		boolean vselection = chrevcgrg.isSelected();

		if (vselection) {
			vreversechrg = "Y";
		} else {
			vreversechrg = "N";
		}

		boolean checkapprove = approve.isSelected();
		if (checkapprove) {
			vapprove = "Y";
			vapprovedby = approvedby.getText();
			vapprovedate = new gnConfig().date_ConverttoDBforamt(approvedate.getText());
		} else {
			vapprove = "N";
			vapprovedby = " ";
			vapprovedate = "";
		}
		insertintoGLmaster();
		if (EditMode == "Y") {
			String vvtype = "GRN";
			new gnEDMiddleWare().PurchaseModification(vvtype, grnno.getText(), grndate.getText());
			new gnLogger().loggerInfoEntry("GRN", "Edit Mode - Removing Privious Data Over");
		}
		insertgrnDetail();
	}

	private void insertintoGLmaster() throws Throwable {
		String vglcode = VendorCode.getText();
		String vglname = VendorName.getText();
		String vtype = "Y";
		new gnAccountbase().insertGlData(vglcode, vglname, vtype);
		new gnLogger().loggerInfoEntry("GRN", "New Gl Entry for Vendor -Complete");
	}

	private void updateTax() throws SQLException {
		String updateTaxthroughGRN = "Y";
		if (updateTaxthroughGRN == "Y") {
			String SQL = "call updateTaxusigPurchase(" + vcomp + " , " + vstore + " , " + vgrnno + " , '" + vgrnDate
					+ "')";
			this.getResult(SQL);
			try {
				this.getSPResult(SQL);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertgrnDetail() throws Throwable {
		prst = null;
		String varticle = "";
		final int batchSize = 5;
		int TotalRecordinsert = 0;
		this.closeconn();
		con = this.getConnection();
		con.setAutoCommit(false);
		String grndetail = "Insert into grn_detail(Site_code , " + "Grnno, Grn_date,  vendor , " + "Inv_no,"
				+ "Article_code, 	qty ,  UOM ,  cost ,  costValue, SalesPrice, MRP, "
				+ "Trans_cost, other_charges, hdrdisc, linedisc , "
				+ "Landing_cost  , Tax_per, Bal_qty, Ean_code, sr_no, Company_code, verticle,"
				+ "batch_control, manuf_date,  expiry_date, batch_no, mbq, location, reversecharge,"
				+ "cgst, sgst, igst, movementtype, taxablevalue, taxamount, po_no, poqty,  finyear  , invqty , lcperunit , freeqty,"
				+ " chassisno , motorno , controllerno ) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?, ? ,?,?,?,?,?,?,? ,?,?,?, ? ,? , ?, ?,?)";
		try {

			// String PoCol[] = { "Type", "Article_code", "Name", "UOM",
			// "InvQty", "Recd.Qty", "Rate", "Base Value ",
			// "Line Disc.", "Disc", "PurValue", "Tax%", "Tax.Amt", "Pur.Incl
			// Tax", "Oth.Chrg", "Landing Cost",
			// "Bal Qty", "Batch_Control", "Batch No", "Expiry date" , "POQty",
			// "MRP", "SP" , "LC-PerUnit" , "FreeQty" };

			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con.prepareStatement(grndetail);
				prst.setString(1, vstorecode);
				prst.setInt(2, vgrnno);
				prst.setString(3, vgrnDate);
				prst.setInt(4, vvendor);
				prst.setString(5, vinvno);
				varticle = table.getValueAt(k, 1).toString();
				prst.setString(6, (table.getValueAt(k, 1).toString()));// Article
				prst.setString(7, (table.getValueAt(k, 5).toString()));// Qty
				prst.setString(8, (table.getValueAt(k, 3).toString())); // uom
				prst.setDouble(9, (Double.parseDouble(table.getValueAt(k, 6).toString()))); // cost
				prst.setDouble(10,
						Double.parseDouble(new gnMath().get2DecimaltValue(table.getValueAt(k, 13).toString())));// costvalue
				prst.setString(11, (table.getValueAt(k, 22).toString())); // sp
				prst.setString(12, (table.getValueAt(k, 21).toString())); // mrp
				prst.setDouble(13, 0.00);// trans_cost
				prst.setDouble(14,
						(Double.parseDouble(new gnMath().get2DecimaltValue(table.getValueAt(k, 14).toString()))));// otherchrg

				prst.setDouble(15, (Double.parseDouble(table.getValueAt(k, 9).toString())));// hdrdisc
				prst.setDouble(16, (Double.parseDouble(table.getValueAt(k, 8).toString())));// linedisc
				prst.setDouble(17,
						(Double.parseDouble(new gnMath().get2DecimaltValue(table.getValueAt(k, 15).toString()))));// landingcost

				prst.setDouble(18, (Double.parseDouble(table.getValueAt(k, 11).toString())));// tax+per
				prst.setDouble(19, (Double.parseDouble(table.getValueAt(k, 16).toString())));// bal_qty
				prst.setString(20, "0");// Ean_code
				prst.setInt(21, k); // srno
				prst.setString(22, vcomp); // compnay
				prst.setString(23, vverticle); // verticle
				prst.setString(24, table.getValueAt(k, 17).toString()); // batcharticle
				String vbatch = table.getValueAt(k, 17).toString();
				switch (vbatch) {
				case "Y":
					prst.setString(25, "0"); // manuf
					prst.setString(26, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 19).toString())); // expiry
					prst.setString(27, table.getValueAt(k, 18).toString()); // batchno
					break;
				case "N":
					String vpara811 = "811";
					String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811,
							vcomp, vstorecode);
					// new General().Quickmsg("Maintain Batch For Non Batch
					// Items " + " "+vmaintainbatchforNonBatchItem);
					switch (vmaintainbatchforNonBatchItem) {
					case "N":
						prst.setString(25, "0000.00.00"); // manuf
						prst.setString(26, "0000.00.00"); // expiry
						prst.setString(27, "0"); // batch
						break;
					case "Y":
						prst.setString(25, "0000.00.00"); // manuf
						prst.setString(26, "0000.00.00"); // expiry
						prst.setString(27, table.getValueAt(k, 18).toString()); // batchno
						break;
					}
					break;
				}

				prst.setString(28, new gnArticle().Article_getData(varticle, "MBQ")); // mbq
				prst.setString(29, vlocation); // location
				prst.setString(30, vreversechrg); // revchrg

				if (vmovtype == "Intra-State") {
					Double vtaxper = Double.parseDouble(table.getValueAt(k, 11).toString());
					Double vcostvalue = Double.parseDouble(table.getValueAt(k, 13).toString());
					vtaxamount = Double.parseDouble(table.getValueAt(k, 12).toString());
					double vcgst = vtaxamount / 2;
					double vsgst = vtaxamount / 2;
					double vigst = 0.00;

					prst.setString(31, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
					prst.setString(32, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
					prst.setString(33, new gnMath().get2DecimaltValue(Double.toString(vigst)));

					prst.setString(34, vmovtype);
				}
				if (vmovtype == "Inter-State") {
					// String vper =
					// table.getValueAt(k,14).toString()+".00"+".00" ;
					Double vtaxper = Double.parseDouble(table.getValueAt(k, 11) + ".00".toString());
					Double vcostvalue = Double.parseDouble(table.getValueAt(k, 13).toString());
					vtaxamount = Double.parseDouble(table.getValueAt(k, 12).toString());
					// vtaxamount= new gnMath(). CalTax_Pur(vcostvalue,
					// vtaxper);

					double vcgst = 0.00;
					double vsgst = 0.00;
					double vigst = vtaxamount;

					prst.setString(31, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
					prst.setString(32, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
					prst.setString(33, new gnMath().get2DecimaltValue(Double.toString(vigst)));
					prst.setString(34, vmovtype);
				}
				vtaxablevalue = 0.00;
				double vnet = 0.0;
				double vtxamt;
				vnet = Double.parseDouble(table.getValueAt(k, 13).toString());
				vtaxablevalue = vnet - vtaxamount;
				prst.setString(35, new gnMath().get2DecimaltValue(Double.toString(vtaxablevalue)));
				prst.setString(36, Double.toString(vtaxamount));
				prst.setInt(37, vpono);
				prst.setString(38, table.getValueAt(k, 20).toString());
				prst.setString(39, new gnFinYear().getCurrentFinYear(grndate.getText()));
				prst.setString(40, table.getValueAt(k, 4).toString());
				prst.setString(41, table.getValueAt(k, 23).toString());
				prst.setString(42, table.getValueAt(k, 24).toString());
				prst.setString(43, "0"); // Chasissno
				prst.setString(44, "0"); // Motorno
				prst.setString(45, "0"); // Controllerno
				prst.addBatch();
				// new General().Quickmsg("PRST"+""+prst);
				TotalRecordinsert = TotalRecordinsert + 1;
				DBdetail = "Fail";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().Quickmsg("Grn Detaill" + e.getMessage());
			con.rollback();
			DBdetail = "Fail";
			new gnLogger().loggerInfoEntry("GRN", "Detail Data Exception" + " " + e.getLocalizedMessage());
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {
				insertgrnHdr();
			}
		}
	}

	public void insertgrnHdr() throws Throwable {
		if (DBdetail == "Sucess") {
			prst = null;
			final int batchSize = 10;
			int TotalRecordinsert = 0;
			con1 = this.getConnection();
			con1.setAutoCommit(false);
			String poshdr = "Insert into grn_hdr(Site_code , " + "Grnno, Grn_date,  po_no,   type  , vendor , "
					+ "Inv_no, Inv_date, Inv_amount ,  costValue, "
					+ " other_charges,Total_amount , updateDate, createBy , creditDays, Payment_no, "
					+ "Payment_date, due_date, Company_code, verticle, approvegrn, approvedby, approvedate, reversecharge ,"
					+ "ismyCompanyGst , mygstno, mystatecode, mystatename , regDealer , custGSTNo , state, statename , "
					+ "movementType, time,"
					+ " import, sezZone, advPaymentno , hdrDisc, glcode , updatedBy , roundingamt , finyear,"
					+ "paidAmount, dueAmount , purchaseType, narration, podate )"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?, ? , ?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,? ,?, ?,?, ?)";
			try {
				prst = con1.prepareStatement(poshdr);
				prst.setString(1, vstorecode);
				prst.setInt(2, vgrnno);
				prst.setString(3, vgrnDate);
				prst.setInt(4, vpono);
				prst.setString(5, vtype);
				prst.setInt(6, vvendor);
				prst.setString(7, vinvno);
				prst.setString(8, vinvDate);
				prst.setDouble(9, vinvamt);
				prst.setDouble(10, vcostvalue);
				prst.setString(11, otherCharges.getText());
				prst.setDouble(12, vtotalamount);
				prst.setString(13, vupdateDate);
				prst.setString(14, vcreateBy);
				prst.setInt(15, vcreditDays);
				prst.setInt(16, 0);
				prst.setInt(17, 0);
				prst.setString(18, vduedate);
				prst.setString(19, companycode.getText());
				prst.setString(20, vverticle);
				if (vapprove == "N") {
					prst.setString(21, vapprove);
					prst.setString(22, "Approval Pending");
					prst.setString(23, "0000.00.00");
				}

				if (vapprove == "Y") {
					prst.setString(21, vapprove);
					prst.setString(22, vapprovedby);
					prst.setString(23, vapprovedate);
				}
				prst.setString(24, vreversechrg);

				prst.setString(25, vmyCompanyisGST);
				prst.setString(26, vmygstno);
				prst.setString(27, vmycompanystate);
				prst.setString(28, vmystatename);
				prst.setString(29, vregdlr);
				prst.setString(30, vcustGSTno);
				prst.setString(31, vstate);
				prst.setString(32, vstatename);
				prst.setString(33, vmovtype);
				prst.setString(34, new General().getTime());
				prst.setString(35, vimport);
				prst.setString(36, vsez);
				prst.setString(37, vadvno);
				prst.setString(38, totaldisc.getText());
				prst.setString(39, vglcode);
				prst.setString(40, vcreateBy);
				prst.setString(41, roundingamt.getText());
				prst.setString(42, new gnFinYear().getCurrentFinYear(grndate.getText()));
				prst.setString(43, "0");
				prst.setString(44, Double.toString(vtotalamount));
				prst.setString(45, purchaseType1);
				prst.setString(46, naration.getText());
				prst.setString(47, vpodate);
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
				new General().Quickmsg("Header " + e.getMessage());
				con1.rollback();
				DBhdr = "Fail";
				new gnLogger().loggerInfoEntry("GRN", "Hdr Data Exception " + "" + e.getLocalizedMessage());
			} finally {
				if (prst != null) {
					prst.close();
				}
				if (DBhdr == "Sucess") {
					con.commit();
					con1.commit();
					updateTax();
					if (EditMode == "N") {
						new gnSeq().updateSeqno("7", "TR");
					}
					con.close();
					con1.close();
					new General().Quickmsg("Data Saved Sucessfully");
					new gnLogger().loggerInfoEntry("GRN", "Hdr & Detail Data Posted ");
					switch (vapprove) {
					case "Y":
						updateProcessForSaveEvent();
						calculateGSTReturnData();
						break;
					case "N":
						new General().Quickmsg("!!!Reminder!!! ...Approve Grn For Vendor Payment and Inventory Imapct");
						reset();
						break;
					}

				}
			}
		}
	}

	private void calculateGSTReturnData() throws Throwable {
		String vparty = VendorCode.getText();
		String vamount = TotalAmount.getText();
		String vdocdate = grndate.getText();
		String vdocno = grnno.getText();
		String vvdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String SQL = "call GRN_updateAvgCostForArticles(" + vcomp + ", " + vstore + " , " + vdocno + " , '" + vvdocdate
				+ "')";
		this.getSPResult(SQL);
		switch (PostGST_accountEntryAtSaveTime) {
		case "Y":
			new gnGSTMiddleWare().backend_DocgstGRNProcess(vparty, vdocno, vdocdate, vamount); // backend
			new gnLogger().loggerInfoEntry("GRN", "GST & Account Data Posted");
			break;
		}
		updateadvstatus();
		reset();
	}

	private void getApprovalStatus() throws ClassNotFoundException, SQLException {
		boolean checkapprovepo = approve.isSelected();
		// new General().QuickmsgBoolean(checkapprovepo);
		if (checkapprovepo = true) {
			vapprove = "Y";
			vapprovedby = approvedby.getText();
			vapprovedate = new gnConfig().date_ConverttoDBforamt(approvedate.getText());
			vcomp = companycode.getText();
			vstorecode = Storecode.getText();

		}
		if (checkapprovepo = false)
			vapprove = "N";
		vapprovedby = approvedby.getText();
		vapprovedate = new gnConfig().date_ConverttoDBforamt(approvedate.getText());
		vcomp = companycode.getText();
		vstorecode = Storecode.getText();
	}

	private void updateProcessForSaveEvent() throws Throwable {
		// new General().Quickmsg("Now REched in inv Imact process");
		if (DBhdr == "Sucess") {
			if (vapprove == "Y") {
				btnBarcode.setEnabled(true);
				applyInventoryPosting();
				updateApproveStatus();
			}
		}
	}

	// =======================================Update buttton Press Starts Here
	// ============================
	public void callUpdateEvent() throws Throwable {
		// new General().Quickmsg("Updating Records ..... ");
		resetFigures();
		vcomp = companycode.getText();
		vstorecode = Storecode.getText().trim();
		vgrnDate = new gnConfig().date_ConverttoDBforamt(grndate.getText().trim());
		vgrnno = Integer.parseInt(grnno.getText());
		vsgrnno = grnno.getText();
		vpono = 000;
		vtype = "WP";
		vvendor = Integer.parseInt(VendorCode.getText().trim());
		int d = InvoiceNumber.getText().length();
		if (d == 0) {
			new General().Quickmsg("Enter Supplier Invoice Number ");
			InvoiceNumber.grabFocus();
			return;
		}
		vinvno = InvoiceNumber.getText().trim();

		int d1 = InvoiceDate.getText().length();
		if (d1 == 0) {
			new General().Quickmsg("Enter Supplier Invoice Date");
			InvoiceDate.grabFocus();
			return;
		}
		vinvDate = new gnConfig().date_ConverttoDBforamt(InvoiceDate.getText().trim());

		int d2 = InvAmt.getText().length();
		if (d2 == 0) {
			new General().Quickmsg("Enter Supplier Invoice Amount");
			InvAmt.grabFocus();
			return;
		}
		vinvamt = Double.parseDouble(InvAmt.getText());
		vcostvalue = Double.parseDouble(SupplierPayable.getText());

		int d3 = Othcharges.getText().length();
		if (d3 == 0) {
			Othcharges.setText("0.00");
		}

		vothcharges = Double.parseDouble(Othcharges.getText());
		vtotalamount = Double.parseDouble(TotalAmount.getText());
		vcreateBy = new gnConfig().getUserCode();
		vupdateDate = new gnConfig().date_ConverttoDBforamt(grndate.getText().trim());// grndate.getText().trim();
		vcreditDays = Integer.parseInt(creditDays.getText().trim());
		vduedate = new gnConfig().date_ConverttoDBforamt(new gnConfig().get_duedate(vgrnDate, vcreditDays));
		vverticle = new gnHierarchy().getVerticleCode();
		vcomp = companycode.getText();
		boolean checkapprove = approve.isSelected();
		if (checkapprove) {
			vapprove = "Y";
			vapprovedby = approvedby.getText();
			vapprovedate = new gnConfig().date_ConverttoDBforamt(approvedate.getText());
		} else {
			vapprove = "N";
			vapprovedby = " ";
			vapprovedate = "";
		}
		ProceeUpdateAction();
	}

	private void ProceeUpdateAction() throws Throwable {
		// getApprovalStatus();

		if (vapprove == "N") {
			UpdategrnDetail();
			if (DBhdr == "Sucess") {
				reset();
			}
		}

		if (vapprove == "Y") {
			btnBarcode.setEnabled(true);
			// UpdategrnDetail();
			if (DBhdr == "Sucess") {
				applyInventoryPosting();
				updateApproveStatus();
			}
		}
	}

	private void applyInventoryPosting() throws Throwable {
		reduceInv();
		applySalesPriceInsert();
		// insertEanCode();
	}

	public void UpdategrnDetail() throws Throwable {
		// new General().Quickmsg("Inserting now detail ok .") ;
		prst = null;
		String vcomp = companycode.getText();
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String grndetail = "update  grn_detail set   "
				+ "qty = ?,   UOM  = ?, cost  = ?,   costValue = ?,   Salesprice= ?  , mrp =  ? , "
				+ " Trans_cost = ?,   other_charges = ? , linedisc = ?,  hdrDisc= ?, Landing_cost  = ?,"
				+ " Ean_code = ?,  Manuf_date = ?, Expiry_date =?,   Batch_no =  ?,  location = ? , mbq= ? "
				+ " where   company_code = ?  and  site_code = ?  and vendor = ?  and grnno = ? and  article_code = ? ";
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				String veancode = (String) table.getValueAt(k, 3);
				if (veancode != "0") {
					prst = con.prepareStatement(grndetail);

					prst.setString(1, (table.getValueAt(k, 3).toString()));
					prst.setString(2, (table.getValueAt(k, 4).toString()));
					prst.setString(3, (table.getValueAt(k, 5).toString()));
					prst.setString(4, table.getValueAt(k, 8).toString());
					prst.setString(5, table.getValueAt(k, 9).toString());
					prst.setString(6, (table.getValueAt(k, 10).toString()));
					prst.setString(7, (table.getValueAt(k, 11).toString()));
					prst.setString(8, (table.getValueAt(k, 12).toString()));
					prst.setString(9, (table.getValueAt(k, 6).toString()));
					prst.setString(10, (table.getValueAt(k, 7).toString()));
					prst.setString(11, (table.getValueAt(k, 13).toString()));
					String vmanf = table.getValueAt(k, 16).toString();
					String vexp = table.getValueAt(k, 17).toString();
					if (vmanf == "0") {
						prst.setString(12, "0000.00.00");
					} else {
						prst.setString(12, new gnConfig().date_ConverttoDBforamt((table.getValueAt(k, 15).toString())));
					}

					if (vexp == "0") {
						prst.setString(13, "0000.00.00");
					} else {
						prst.setString(13, new gnConfig().date_ConverttoDBforamt((table.getValueAt(k, 16).toString())));
					}
					prst.setString(14, (table.getValueAt(k, 18).toString()));
					prst.setString(15, (table.getValueAt(k, 20).toString()));
					prst.setString(16, (table.getValueAt(k, 22).toString()));
					prst.setString(17, vcomp);
					prst.setString(18, vstorecode);
					prst.setInt(19, vvendor);
					prst.setInt(20, vgrnno);
					prst.setString(21, (table.getValueAt(k, 1).toString()));
					prst.addBatch();
					TotalRecordinsert = TotalRecordinsert + 1;
					DBdetail = "Fail";
					if (++TotalRecordinsert % batchSize == 0) {
						prst.executeBatch();
						con.commit();
						DBdetail = "Sucess";
					}
					// new General().Quickmsg( "PRST "+" "+prst);
					prst.executeBatch();
					con.commit();
					DBdetail = "Sucess";
				}
			}
		} catch (SQLException e) {
			new General().Quickmsg("Grn Detail" + e.getMessage());
			e.getMessage();
			e.printStackTrace();
			con.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
				if (DBdetail == "Sucess") {
					updategrnHdr();
				}
			}
		}
	}

	public void updategrnHdr() throws Throwable {
		if (DBdetail == "Sucess") {
			prst = null;
			String vcomp = companycode.getText();
			String vstore = Storecode.getText();
			final int batchSize = 10;
			int TotalRecordinsert = 0;
			this.closeconn();
			Connection con1 = this.getConnection();
			con1.setAutoCommit(false);
			String poshdr = "update  grn_hdr set Inv_no = ?, " + "Inv_date =? ,   Inv_amount =? ,   costValue =?, "
					+ " other_charges=?,  Total_amount=? ,  updateDate =?, updatedby = ? "
					+ "  where Company_code=?  and  Site_code =?  and  Grnno=?  and  vendor =?";
			try {
				prst = con1.prepareStatement(poshdr);
				prst.setString(1, vinvno);
				prst.setString(2, vinvDate);
				prst.setDouble(3, vinvamt);
				prst.setDouble(4, vcostvalue);
				prst.setDouble(5, vothcharges);
				prst.setDouble(6, vtotalamount);
				prst.setString(7, vupdateDate);
				prst.setString(8, vcreateBy);
				prst.setString(9, vcomp);
				prst.setString(10, vstore);
				prst.setInt(11, vgrnno);
				prst.setInt(12, vvendor);
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBhdr = "Fail";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					con1.commit();
					DBhdr = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				con1.commit();
				DBhdr = "Sucess";
			} catch (SQLException e) {
				new General().Quickmsg("Grn Hdr" + e.getMessage());
				con1.rollback();
				DBhdr = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
				}
				if (con1 != null) {
					con1.close();
				}
				new General().Quickmsg("Grn Data Updated ...");
			}
		}
	}

	public String reduceInv() throws Throwable {

		String vstore = Storecode.getText();
		String varticle;
		String vtype = "Purchase";
		String vdate = vgrnDate;
		String vqty = "0";
		String vfinyear = new gnFinYear().getReportingFinYear();
		if (DBdetail == "Sucess" && DBhdr == "Sucess") {
			int rw = table.getRowCount();
			if (rw > 0) {
				String vtrntype = "Grn";
				String vstatus = " ";
				new gnLogger().loggerInfoEntry("GRN", "Inventory Update Starts Time " + System.currentTimeMillis());
				String SQL = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vgrnno + " , '"
						+ vgrnDate + "'  , '" + vfinyear + "')";
				// new General().msg(SQL);
				this.getSPResult(SQL);

				String SQL1 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vgrnno
						+ " , '" + vgrnDate + "'  ,  '" + vfinyear + "')";
				String r = this.getResult(SQL1);

				// Batch Management For Non Batch Items This is new Development
				String vpara811 = "811";
				String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
						vstorecode);
				switch (vmaintainbatchforNonBatchItem) {
				case "Y":
					String SQL2 = "call Inv_impact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vtrntype
							+ "',   " + vgrnno + " , '" + vgrnDate + "'  ,  '" + vfinyear + "')";
					String r1 = this.getResult(SQL2);
					break;
				}
				// End Batch Management For Non Batch Items This is new
				// Development

				DBstock = "Sucess";
				new gnLogger().loggerInfoEntry("GRN", "Inventory Update End Time " + System.currentTimeMillis());
				new gnLogger().loggerInfoEntry("GRN", "Inventrory Impact After GRN- Complete ");
			}
			// End Logic Change
		}
		return DBstock;
	}

	private void applySalesPriceInsert() throws Throwable {
		int row = table.getRowCount();
		for (int k = 0; k < row; k++) {
			String varticle = table.getValueAt(k, 1).toString();
			String vmrp = table.getValueAt(k, 21).toString();
			String vSP = table.getValueAt(k, 22).toString();
			String vcost = (table.getValueAt(k, 6).toString());
			String vlc = (table.getValueAt(k, 23).toString());

			// Insert New SalesPrice mrp and Landing Cost in SalesPrice table
			// and update ArticleMater
			new ApplySalesPrice_Action().SalesPriceInsert(vstorecode, varticle, vgrnDate, vmrp, vSP, vcost, vcomp,
					vverticle, vlc);
			// Insert New SalesPrice mrp and Landing Cost in SalesPrice table
			// and update ArticleMater

			DBsalesPrice = "Sucess";

			// update grnqty in po tables and po status
			String rpono = pono.getText();
			vpodate = new gnConfig().date_ConverttoDBforamt(podate.getText());
			new Applyupdates().update_grqty(varticle, vcost, rpono, vcomp, vstorecode, vpodate);
			new gnLogger().loggerInfoEntry("GRN", "New Sales Price Updated in Price Master");
		}
	}

	public void updateApproveStatus() throws Throwable {
		vcomp = companycode.getText();
		vstorecode = Storecode.getText();
		vsgrnno = grnno.getText();
		if (vapprove == "Y") {
			prst = null;
			final int batchSize = 1;
			int TotalRecordinsert = 0;
			Connection con1 = this.getConnection();
			con1.setAutoCommit(false);
			String Status = "Fail";
			String grnhdrupd = "update grn_hdr  set  " + "approvegrn = ?, " + "approvedby  = ? ," + " approvedate = ?  "
					+ "where grnno = ?  and Company_code = ?  and site_code = ? ";
			try {
				prst = con1.prepareStatement(grnhdrupd);
				prst.setString(1, vapprove);
				prst.setString(2, vapprovedby);
				prst.setString(3, vapprovedate);
				prst.setString(4, vsgrnno);
				prst.setString(5, vcomp);
				prst.setString(6, vstorecode);
				prst.addBatch();
				// new General().Quickmsg("PRST" +" "+prst);
				TotalRecordinsert = TotalRecordinsert + 1;
				DBhdr = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBhdr = "Sucess";
					con1.commit();
				}
				prst.executeBatch(); // insert remaining records
				con1.commit();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				con1.rollback();
				DBaction = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
				}
				if (con1 != null) {
					con1.close();
				}
				// new General().Quickmsg("Status Updated Sucessfully..");
			}
		}
	}

	private void reset() {

		changeqty.setText(null);
		changerate.setText(null);
		chnagemrp.setText(null);
		chnagesp.setText(null);
		lastSupplier.setText(VendorName.getText());
		VendorName.setText(null);
		VendorCode.setText(null);
		changerate.setText(null);
		changeqty.setText(null);
		chnagemrp.setText(null);
		chnagesp.setText(null);
		scanItem.setVisible(true);
		searchbrand.setVisible(true);
		Privoiusamt.setText(TotalAmount.getText());
		naration.setText("");
		// new General().Quickmsg("Grn Number is " + vgrnno) ;
		EditMode = "N";
		Othcharges.setText("0");
		discper.setText("0");
		basePurchasePrice.setText("0");
		totaldisc.setText("0");
		purchasePostingAmount.setText("0");
		mytaxamount.setText("0");
		SupplierPayable.setText("0");
		otherCharges.setText("0");
		roundingamt.setText("0");
		roundingamt.setText("0");
		new gnTable().RemoveTableRows(model);
		disc.setText(null);
		//

		// VendorCode.setText(null);
		// VendorName.setText(null);
		VendorCode.setEnabled(true);
		VendorName.setEnabled(true);
		statecode.setText(null);
		statename.setText(null);
		email.setText(null);
		mobile.setText(null);
		creditDays.setText(null);
		InvAmt.setText(null);
		disc.setText(null);
		InvoiceDate.setText(null);
		InvoiceNumber.setText(null);
		SupplierPayable.setText(null);
		Othcharges.setText(null);
		TotalAmount.setText(null);
		records.setText("0");
		totalqty.setText("0");
		VendorName.grabFocus();

		scanItem.setText(null);
		// scanName.setText(null);
		advno.setText(null);
		roundingamt.setText(null);
		btnEdit.setBackground(new Color(51, 255, 255));
		btnEdit.setForeground(new Color(0, 0, 153));
		btnEdit.setFont(new Font("Cambria", Font.BOLD, 12));
		scanItem.setVisible(true);
		// scanName.setVisible(true);
		searchbrand.setVisible(true);
		basePurchasePrice.setText("0");
		totaldisc.setText("0");
		purchasePostingAmount.setText("0");
		mytaxamount.setText("0");
		SupplierPayable.setText("0");
		otherCharges.setText("0");
		roundingamt.setText("0");
		totalqty.setText("0");
		records.setText("0");
		// mysplit.setDividerLocation(0);
		new gnTable().RemoveTableRows(model);
		new gnLogger().loggerInfoEntry("GRN", "Transaction Reset- Complete");
	}

	public void updateadvstatus() throws Throwable {

		if (vadvno.length() > 0) {
			String vadvdate = advdate;
			String vinvdate = grndate.getText();
			String vcat = "S";
			try {
				new gnDncnAdv().updateadvstatus(vadvdate, vinvdate, vadvno, vcat);
			} catch (Exception e) {
				new General().Quickmsg("Update AdvNumber Error" + e.getMessage());
			}
		}
	}

	private static class __Tmp {
		private static void __tmp() {
			javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}

	public void purtype(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg( "Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0), "myTable");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("myTable", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					purchasetype.grabFocus();
					purchasetype.showPopup();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void showSeatchintable(JTable mytable) throws Throwable {

		// stable = stable ;
		ntable = mytable;
		ntable.requestFocusInWindow();
		ntable.requestFocus();

		if (!ntable.isFocusOwner()) {
			ntable.requestFocusInWindow();
			ntable.grabFocus();
		}
		JViewport prt6 = new JViewport();
		njsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(ntable);
		njsp.setViewport(prt6);
		njsp.setFocusable(true);
		ntable.setEditingRow(0);
		ntable.setEditingColumn(1);
		ntable.setSelectionBackground(Color.black);
		stable.setSelectionForeground(Color.WHITE);

		Selectrow();
	}

	public void Selectrow() {
		ntable.setRequestFocusEnabled(true);
		ntable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		ntable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = ntable.getSelectedRow();
				String value = (String) ntable.getValueAt(row, 0);
				try {
					dispalyinfo(value, row);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
			}
		});
		// stable.setSurrendersFocusOnKeystroke(true);
		// new General().msgsearch(sjsp, stable, "Select Data", 950, 300);
	}

	private void dispalyinfo(String value, int row) throws Throwable {
		switch (value) {
		case "Vendor":
			VendorCode.setText(ntable.getValueAt(row, 1).toString());
			VendorName.setText(ntable.getValueAt(row, 2).toString());
			mobile.setText(ntable.getValueAt(row, 3).toString());
			email.setText(ntable.getValueAt(row, 4).toString());
			creditDays.setText(ntable.getValueAt(row, 5).toString());
			statecode.setText(ntable.getValueAt(row, 7).toString());
			statename.setText(ntable.getValueAt(row, 8).toString());
			regdlr.setText(ntable.getValueAt(row, 9).toString());
			new gnTable().RemoveTableRows(nmodel);
			purtypeEffetc();
			applyRevchrg();
			break;

		case "Article":
			scanItem.setText(ntable.getValueAt(row, 1).toString());
			new gnTable().RemoveTableRows(nmodel);
			getvalueofscanarticle();
			scanItem.grabFocus();
			// showArticleofsearch
			break;

		}
	}

	private void purtypeEffetc() {
		String vpurtype = purchasetype.getSelectedItem().toString();

		try {
			switch (vpurtype) {
			case "Cash Purchase":
				InvoiceNumber.setText("0");
				InvoiceDate.setText("0");
				InvAmt.setText("0");
				creditDays.setText("0");
				scanItem.grabFocus();
				break;
			case "Credit Purchase":
				InvoiceDate.grabFocus();
				break;
			}
		} catch (Exception e) {
			new General().msg(e.getLocalizedMessage());
		} finally {
		}
	}

	// New
	private void popupPanel() {

		try {
			panelPriceEdit = new JPanel();
			panelPriceEdit.setBackground(Color.white);
			// panelPriceEdit.setBorder(new BevelBorder(BevelBorder.RAISED,
			// Color.ORANGE, Color.GREEN, null, null));
			panelPriceEdit.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
					"Change Value and Press Enter", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 51)));

			panelPriceEdit.setBounds(11, 519, 206, 185);
			panelPriceEdit.setLayout(null);

			editcode = new JLabel();
			editcode.setBounds(1, 2, 10, 10);
			editcode.setText("");
			panelPriceEdit.add(editcode);

			editname = new JLabel();
			editname.setFont(new Font("Tahoma", Font.BOLD, 11));
			editname.setBounds(25, 1, 182, 22);
			panelPriceEdit.add(editname);

			//

			JLabel lblNewLabel_1451 = new JLabel("Pur.UOM");
			lblNewLabel_1451.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1451.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_1451.setBounds(12, 20, 56, 16);
			panelPriceEdit.add(lblNewLabel_1451);

			edituom = new gnRoundTextField(10);
			edituom.setEnabled(false);
			edituom.setBounds(80, 20, 45, 20);
			edituom.setColumns(10);
			panelPriceEdit.add(edituom);

			JLabel lblNewLabel_14521 = new JLabel("InnerQty");
			lblNewLabel_14521.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_14521.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_14521.setBounds(175, 20, 56, 16);
			panelPriceEdit.add(lblNewLabel_14521);

			editinnerqty = new gnRoundTextField(10);
			// editinnerqty.setEnabled(false);
			editinnerqty.setBounds(230, 20, 45, 20);
			editinnerqty.setColumns(10);
			panelPriceEdit.add(editinnerqty);

			//

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

			JLabel lblNewLabel_1522 = new JLabel("MRP");
			lblNewLabel_1522.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1522.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_1522.setBounds(12, 95, 56, 16);
			panelPriceEdit.add(lblNewLabel_1522);

			JLabel lblNewLabel_1523 = new JLabel("SP");
			lblNewLabel_1523.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1523.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_1523.setBounds(12, 118, 56, 16);
			panelPriceEdit.add(lblNewLabel_1523);

			JLabel lblNewLabel_15235 = new JLabel("Disc.Amt");
			lblNewLabel_15235.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_15235.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_15235.setBounds(12, 141, 56, 16);
			panelPriceEdit.add(lblNewLabel_15235);

			JLabel lblNewLabel_152351 = new JLabel("Disc%");
			lblNewLabel_152351.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_152351.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_152351.setBounds(12, 167, 56, 16);
			panelPriceEdit.add(lblNewLabel_152351);

			JLabel lblNewLabel_153 = new JLabel("Batch No");
			lblNewLabel_153.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_153.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_153.setBounds(12, 192, 56, 16);
			panelPriceEdit.add(lblNewLabel_153);

			JLabel lblNewLabel_154 = new JLabel("Exp.date");
			lblNewLabel_154.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_154.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_154.setBounds(12, 220, 56, 16);
			panelPriceEdit.add(lblNewLabel_154);

			JLabel lblNewLabel_155 = new JLabel("Press Enter For Change Impact");
			lblNewLabel_155.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_155.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblNewLabel_155.setBounds(8, 250, 250, 16);
			panelPriceEdit.add(lblNewLabel_155);

			// editqty = new JTextField();
			editqty = new gnRoundTextField(10);
			editqty.setBounds(80, 42, 130, 30);
			editqty.setColumns(10);
			panelPriceEdit.add(editqty);

			// editrate = new JTextField();
			editrate = new gnRoundTextField(10);
			editrate.setBounds(80, 65, 130, 30);
			editrate.setColumns(10);
			panelPriceEdit.add(editrate);

			// editmrp = new JTextField();
			editmrp = new gnRoundTextField(10);
			editmrp.setBounds(80, 91, 130, 30);
			editmrp.setColumns(10);
			panelPriceEdit.add(editmrp);

			// editsp = new JTextField();
			editsp = new gnRoundTextField(10);
			editsp.setBounds(80, 115, 130, 30);
			editsp.setColumns(10);
			panelPriceEdit.add(editsp);

			// editdisc = new JTextField();
			editdisc = new gnRoundTextField(10);
			editdisc.setBounds(80, 138, 130, 30);
			editdisc.setColumns(10);
			panelPriceEdit.add(editdisc);

			// editdiscper = new JTextField();
			editdiscper = new gnRoundTextField(10);
			editdiscper.setBounds(80, 166, 130, 25);
			editdiscper.setColumns(10);
			panelPriceEdit.add(editdiscper);

			// editbatchno = new JTextField();
			editbatchno = new gnRoundTextField(10);
			editbatchno.setBounds(80, 192, 130, 30);
			editbatchno.setColumns(10);
			panelPriceEdit.add(editbatchno);

			// editexpdate = new JTextField();
			editexpdate = new gnRoundTextField(10);
			editexpdate.setBounds(80, 220, 130, 30);
			editexpdate.setColumns(10);
			panelPriceEdit.add(editexpdate);
 
			ActionListener editls = new editLsnr();
			editrate.addActionListener(editls);
			editqty.addActionListener(editls);
			editdisc.addActionListener(editls);
			editexpdate.addActionListener(editls);
			editbatchno.addActionListener(editls);
 			editmrp.addActionListener(editls);
			editsp.addActionListener(editls);
			editdiscper.addActionListener(editls);

			
			ActionListener innerqtylsn = new innerqtyLsnr() ;
			editinnerqty.addActionListener(innerqtylsn);
			
			KeyListener ky1 = new keyPressedlsnr();

			editinnerqty.addKeyListener(ky1);
 			editqty.addKeyListener(ky1);
 			editqty.addKeyListener(ky1);
			editrate.addKeyListener(ky1);
			editdiscper.addKeyListener(ky1);
			editmrp.addKeyListener(ky1);
			editsp.addKeyListener(ky1);
			editdisc.addKeyListener(ky1);
			editexpdate.addKeyListener(ky1);
			editbatchno.addKeyListener(ky1);
 
		} catch (Exception e) {
			new General().msg(e.getLocalizedMessage());
		}
	}

	private void popupWindowForQtyPrice() {

		popupPanel();
		// Chnage for automobile
		// String PoCol[] = { "Type", 1"Article_code", 2"Name", 3"UOM",
		// 4"InvQty", 5"Recd.Qty", 6"Rate", 7"Base Value ", "Line Disc.",
		// 8"Disc", 9"PurValue", 10"Tax%", 11"Tax.Amt", 12"Pur.Incl Tax",
		// 13"Oth.Chrg", 14"Landing Cost", 15"Bal Qty",
		// 16"Chassis No", 17"Motor No", 18"Controll No", 19"POQty", 20"MRP",
		// 21"SP", 22"LC-PerUnit", 23"FreeQty" };

		editrow = table.getSelectedRow();
		String vqty = (table.getValueAt(editrow, 5).toString());
		String vrate = (String) table.getValueAt(editrow, 6);
		String vcode = (String) table.getValueAt(editrow, 1);
		String vname = (String) table.getValueAt(editrow, 2);
		String vdisc = (String) table.getValueAt(editrow, 8);

 
		String vbatchno = (String) table.getValueAt(editrow, 18);
		String vexpdate = (String) table.getValueAt(editrow, 19);

		String veditmrp = (String) table.getValueAt(editrow, 21);
		String veditsp = (String) table.getValueAt(editrow, 22);

		try {
			editQtyPrice(vcode, vname, vqty, vrate, vdisc, vbatchno, vexpdate, veditmrp, veditsp);
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

	private void editQtyPrice(String vcode, String vname, String vqty, String vrate, String vdisc, String vbatchno,
		
		String vexpdate, String vmrp, String vsp) {
		panelPriceEdit.setBounds(21, 86, 275, 150);

		editcode.setText(vcode);
		editname.setText(vname);
		editrate.setText(vrate);
		editqty.setText(vqty);
		editdisc.setText(vdisc);
		editexpdate.setText(vexpdate);
		editbatchno.setText(vbatchno);
		try {
			String vtype = "PurchaseUOM";
			edituom.setText(new gnArticle().Article_getData(vcode, vtype));
			vtype = "innerQty";
			editinnerqty.setText(new gnArticle().Article_getData(vcode, vtype));
		} catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
		}
 
		editmrp.setText(vmrp);
		editsp.setText(vsp);
 		editqty.grabFocus();
		Dpanel.add(panelPriceEdit);
		editqty.grabFocus();
 		new General().msgPanel(panelPriceEdit, "Edit Price and Qty", 300, 275);
		editqty.grabFocus();
  		new gnLogger().loggerInfoEntry("POS", "Edit Price and Qty Called");
	}

	class editLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			
			//new General().msg("OK");
			// Chnage for automobile
			// String PoCol[] = { "Type", 1"Article_code", 2"Name", 3"UOM",
			// 4"InvQty", 5"Recd.Qty", 6"Rate", 7"Base Value ", 8"Line Disc.",
			// 9"Disc", 10"PurValue", 11"Tax%", 12"Tax.Amt", 13"Pur.Incl Tax",
			// 14"Oth.Chrg", 15"Landing Cost", 16"Bal Qty",
			// 17"Chassis No", 18"Motor No", 19"Controll No", 20"POQty",
			// 21"MRP", 22"SP", 23"LC-PerUnit", 24"FreeQty" };

			String vnewqty = editqty.getText();
			double vvqty = Double.parseDouble(vnewqty);
			double vinnerqty = Double.parseDouble(editinnerqty.getText());
			double vmainqty = vvqty * vinnerqty;
			String vnewrate = editrate.getText();
			double vvnewrate = Double.parseDouble(vnewrate);

			if (editdiscper.getText().length() > 0) {
				double vdper = Double.parseDouble(editdiscper.getText());
				double vlinediscamt = (vvnewrate * vmainqty) * vdper / 100;
				editdisc.setText(Double.toString(vlinediscamt));
			}

			String vnewdisc = editdisc.getText();
			String vbatchno = editbatchno.getText();
 			String vexpdate = editexpdate.getText();
 			String vmrp = editmrp.getText();

			try {
				double vvmrp = Double.parseDouble(vmrp);
				String vmytype = "Markdown";
				String myarticle = editcode.getText();
				double vvmarkdon = Double.parseDouble(new gnArticle().Article_getData(myarticle, vmytype));
				double vnewsp = vvmrp - (vvmrp * vvmarkdon / 100);
				editsp.setText(Double.toString(vnewsp));
			} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}

			String vsp = editsp.getText();
 			table.setValueAt(vmainqty, editrow, 4);
			table.setValueAt(vmainqty, editrow, 5);
			table.setValueAt(vnewrate, editrow, 6);
 			table.setValueAt(vnewdisc, editrow, 8);
			table.setValueAt(vbatchno, editrow, 18);
			table.setValueAt(vexpdate, editrow, 19);
			table.setValueAt(vmrp, editrow, 21);
			table.setValueAt(vsp, editrow, 22);
			String vcode = editcode.getText();

			try {
 				if (editexpdate.isFocusOwner()) {
					new General().msgDispose();
				}
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				try {
					QtychangeImapct(vcode, editrow);
					scanItem.grabFocus();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void grnSave(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg( "Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0), "BillSave");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("BillSave", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					btnSave.doClick();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}
	
class innerqtyLsnr implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent arg0) {
 
 		editqty.grabFocus();
	}
 }
	
	
}// last

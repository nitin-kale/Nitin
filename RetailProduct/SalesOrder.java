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
import javax.swing.UIManager;

public class SalesOrder extends getResultSet {

	JFrame SalesOrderFrame;
	public String vpaymentmode;
	public Double vpaymentamount;
	private String vglcode;
	JButton btnShowInv;
	JLabel lblphone;
	JButton btnShowTemplate ;

	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField crdays;
	private JButton btnAdvance;
	private JTextField paymentduedate;
	private JTextField showInv;
	private JTextField dueamount;
	private JTextField advno;
	private JTextField disc;
	private JTextField tvalue;
	private JTextField roundingamt;
	private JLabel lblNewLabel_21;
	private JTextField scanqty;
	private JTextField rate;
	private JTextField discount;
	private JPanel panel_5;
	private JLabel lblNewLabel_1;
	private JTextField grossamt;
	private JTextField linedisc;
	private JTextField billdisc;
	private JTextField discper;
	private JPanel panel_7;
	private JTextField totalqty;
	private JPanel btnPanel;
	private JLabel lblNewLabel_27;
	private JTextField shipaddr1;
	private JTextField shipaddr2;

	// ====================For Payment Reference ==================
	public static String vpaytype;
	public static String vinvdate;

	public static String vinvno;
	public static String vnetamount;
	JButton btnReceipts;
	public static String vcustomer;
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
	String vdoctype2 = "";
	String vtaxtype = " ";
	String vcgst = "";
	String vsgst = "";
	String vigst = " ";
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
	private String DBdetail;
	private String DBhdr;
	private Double vvggross = 0.00;
	private Double vvdisc = 0.00;
	private JButton btnSave;
	private JButton btnBatch;
	private JButton btnPrint;
	private JButton btnClose;
	private JButton btnPayment;
	private JButton btnDeclare;
	private JButton btnCustomer;
	private JButton btnHold;
	private JButton btnUnhold;
	private JTextField scanarticle;
	private JTextField searchname;
	private String vcreditDays;

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
	private JPanel paymentPanel;
	private JPanel panel;
	private String vadvrcptno;
	private JTextField records;
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
	private JTextField SONO;
	private JTextField SODATE;
	private JPanel scanPanel;
	//
	private String vsalestype;
	private String vinvtype;
	private String vpostingtype;
 	private JRadioButton rbcashsale;
	private JRadioButton rbcrsale;

	public JTable stable = new JTable();
	public JScrollPane sjsp  ;
 	public JViewport prt6 = new JViewport();
	public DefaultTableModel smodel = new DefaultTableModel();
	private Double vdueamount;

	public DefaultTableModel pmodel = new DefaultTableModel();
	public String paycol[] = { "Romove", "Mode", "Amount", "Card" };
	public JScrollPane pjsp = new JScrollPane();
	public JTable ptable = new JTable();

	private JScrollPane jsp;
	public String poscol[] = { "Romove", "Item", "Name", "Qty", 
										  "UOM", "Inner Qty", "Rate", 
										  "MRP", "Gross", "Bill Disc",
										  "Disc", "Amount", "Tax%" };

	private Object[][] data = {
			// {"Boolean" , Boolean.FALSE};
			{ "String", "" }, { "String", "" }, { "String", " " }, { "Double", new Double(123.45) }, { "String", " " },
			{ "Double", new Double(123.45) }, { "Double", new Double(123.45) }, { "Double", new Double(123.45) },
			{ "Double", new Double(123.45) }, { "Double", new Double(123.45) }, { "Double", new Double(123.45) },
			{ "Double", new Double(123.45) }, { "Double", new Double(123.45) }, { "Double", new Double(123.45) },
			{ "Double", new Double(123.45) }, { "String", "" }, { "String", " " }, { "Date", new Date() },
			{ "Double", new Double(123.45) } };

	
	// public String poscol[] = {"Romove", 1"Item",2 "Name", 3"Qty" , 4 "UOM", 5
	// "Inner Qty" ,6 "Rate" , 7 "MRP", 8"Gross" ,9"Hdr Disc", 10"Disc" ,
	// 11"Amount", 12"Taxcode"  };

	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 3 || column == 4 || column == 5 || column == 6 || column == 10
					|| column == 15 || column == 16 || column == 17 || column == 18 ? true : false;
		}
	};

	//// Table Related
	public JTable table = new JTable(data, poscol) 
	{
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			// 3 4 5 6 9 10 15 16
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 4 || column == 5 || column == 6 
					|| column == 10 || column == 15
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

	//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesOrder window = new SalesOrder();
					window.SalesOrderFrame.setVisible(true);
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
	public SalesOrder() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		SalesOrderFrame = new JFrame();
		SalesOrderFrame.setBackground(Color.RED);
		SalesOrderFrame.getContentPane().setBackground(Color.WHITE);
		SalesOrderFrame.setResizable(false);
		SalesOrderFrame.setAlwaysOnTop(true);
		SalesOrderFrame.setBounds(1, 100, 1356, 712);
		SalesOrderFrame.setBounds(1, 100, 1356, 600);
		SalesOrderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SalesOrderFrame.getContentPane().setLayout(null);

 
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(4, 2, 2, 2, (Color) new Color(0, 255, 0)));
		panel.setBounds(0, 0, 1338, 242);
		SalesOrderFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 102));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new MatteBorder(1, 1, 0, 1, (Color) Color.DARK_GRAY));
		panel_1.setBounds(12, 52, 894, 124);
		panel.add(panel_1);
		panel_1.setLayout(null);

		paymentPanel = new JPanel();
		paymentPanel.setBorder(new TitledBorder(null, "Customer Payment  Information", TitledBorder.CENTER,
				TitledBorder.TOP, null, null));
		paymentPanel.setBounds(828, 31, 504, 101);
		ActionListener custno = new custcodeLsnr();
		ActionListener custname = new custnameLsnr();
 		ActionListener cr = new crdaysLsnr();

		lblNewLabel_21 = new JLabel("Select Customer Here ");
		lblNewLabel_21.setBounds(12, 13, 156, 16);
		panel_1.add(lblNewLabel_21);
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_21.setForeground(new Color(0, 0, 102));

		customercode = new JTextField();
		customercode.setBounds(14, 30, 63, 30);
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
		customername.setBounds(74, 30, 348, 30);
		panel_1.add(customername);
		customername.setToolTipText("Select Customer For Credit Sales");
		customername.setBackground(Color.WHITE);
		customername.addActionListener(custname);
		customername.setColumns(10);

		ActionListener btn = new BtnPressLsnr();

		JPanel mysearch = new MySearchPanel();
		panel_5 = mysearch;

		ActionListener article = new ArticlecodeLsnr();
		ActionListener nm = new articlenameLsnr();
		ActionListener show = new ShowInvLsnr();

		btnShowInv = new JButton("Show Order");
		btnShowInv.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnShowInv.setBounds(261, 65, 114, 30);
		btnShowInv.addActionListener(show);
		panel_1.add(btnShowInv);

		JLabel lblNewLabel_13 = new JLabel("Days");
		lblNewLabel_13.setBounds(16, 72, 39, 16);
		panel_1.add(lblNewLabel_13);
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_13.setForeground(new Color(0, 0, 51));
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));

		crdays = new JTextField();
		crdays.setBounds(13, 90, 58, 30);
		panel_1.add(crdays);
		crdays.setFont(new Font("Tahoma", Font.PLAIN, 12));
		crdays.setToolTipText("Enter Credit Period for  Credit Sales");
		crdays.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Delivery Date");
		lblNewLabel_14.setBounds(72, 71, 85, 16);
		panel_1.add(lblNewLabel_14);
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_14.setForeground(new Color(0, 0, 51));
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 12));

		paymentduedate = new JTextField();
		paymentduedate.setBounds(72, 90, 96, 30);
		panel_1.add(paymentduedate);
		paymentduedate.setToolTipText("Due Date Will Calculate Based on Credit Days And Current Billing Date");
		paymentduedate.setEditable(false);
		paymentduedate.setForeground(Color.BLACK);
		paymentduedate.setFont(new Font("Tahoma", Font.BOLD, 13));
		paymentduedate.setBackground(Color.WHITE);
		paymentduedate.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Due Amt.");
		lblNewLabel_16.setBounds(169, 71, 69, 16);
		panel_1.add(lblNewLabel_16);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_16.setForeground(new Color(0, 0, 51));
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 11));

		dueamount = new JTextField();
		dueamount.setText("0");
		dueamount.setBounds(169, 90, 69, 30);
		panel_1.add(dueamount);
		dueamount.setBackground(Color.WHITE);
		dueamount.setToolTipText("Customer Outstatnding Till Date");
		dueamount.setEditable(false);
		dueamount.setForeground(Color.BLACK);
		dueamount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		dueamount.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Shipping Address");
		lblNewLabel_8.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_8.setBounds(436, 13, 123, 16);
		panel_1.add(lblNewLabel_8);

		shipaddr1 = new JTextField();
		shipaddr1.setText("-");
		shipaddr1.setBounds(428, 30, 439, 30);
		panel_1.add(shipaddr1);
		shipaddr1.setColumns(10);

		shipaddr2 = new JTextField();
		shipaddr2.setText("-");
		shipaddr2.setBounds(428, 61, 439, 30);
		panel_1.add(shipaddr2);
		shipaddr2.setColumns(10);

		lblphone = new JLabel("-");
		lblphone.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblphone.setBounds(197, 13, 225, 16);
		panel_1.add(lblphone);
		
		lblstatus = new JLabel("Order");
		lblstatus.setBounds(239, 104, 56, 16);
		panel_1.add(lblstatus);
		
		JLabel lblNewLabel_9 = new JLabel("Mobile");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(383, 96, 56, 16);
		panel_1.add(lblNewLabel_9);
		
		mobile = new JTextField();
		mobile.setBounds(428, 93, 218, 30);
		panel_1.add(mobile);
		mobile.setColumns(10);

		//

		crdays.addActionListener(cr);

		scanPanel = new JPanel();
		scanPanel.setBounds(12, 177, 894, 62);
		panel.add(scanPanel);
		scanPanel.setBackground(new Color(153, 255, 255));
		scanPanel.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(64, 64, 64)));
		scanPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Scan Article");
		lblNewLabel.setBounds(22, 0, 132, 16);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		scanPanel.add(lblNewLabel);

		// scanarticle = new JTextField();
		scanarticle = new gnRoundTextField(20);
		scanarticle.setBounds(22, 17, 143, 33);
		scanarticle.setBackground(Color.WHITE);
		scanarticle.setForeground(new Color(0, 0, 51));
		scanarticle.setToolTipText("Scan Or Enter Item Code ");
		scanarticle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 16));
		scanPanel.add(scanarticle);
		scanarticle.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Name");
		lblNewLabel_10.setBounds(440, -3, 116, 22);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_10.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_10.setForeground(new Color(0, 0, 102));
		scanPanel.add(lblNewLabel_10);

		// searchname = new JTextField();
		searchname = new gnRoundTextField(20);
		searchname.setBounds(435, 17, 202, 32);

		searchname.setFont(new Font("Arial", Font.PLAIN, 16));
		searchname.setBackground(Color.WHITE);
		searchname.setForeground(new Color(0, 0, 51));
		searchname.setToolTipText("Enter Name Of Item To Search");
		scanPanel.add(searchname);
		searchname.setColumns(10);

		JLabel lblNewLabel_22 = new JLabel("Qty");
		lblNewLabel_22.setBounds(170, 0, 65, 16);
		lblNewLabel_22.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_22.setForeground(new Color(0, 0, 102));
		scanPanel.add(lblNewLabel_22);

		// scanqty = new JTextField();
		scanqty = new gnRoundTextField(20);
		scanqty.setBounds(172, 17, 70, 32);

		scanqty.setFont(new Font("Arial Black", Font.PLAIN, 18));
		scanqty.setBackground(Color.WHITE);
		scanqty.setForeground(new Color(0, 0, 51));
		scanPanel.add(scanqty);
		scanqty.setColumns(10);

		JLabel lblNewLabel_23 = new JLabel("Rate");
		lblNewLabel_23.setBounds(247, 0, 65, 16);
		lblNewLabel_23.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_23.setForeground(new Color(0, 0, 102));
		scanPanel.add(lblNewLabel_23);

		// rate = new JTextField();
		rate = new gnRoundTextField(20);
		rate.setBounds(247, 17, 70, 32);

		rate.setFont(new Font("Arial Black", Font.PLAIN, 18));
		rate.setBackground(Color.WHITE);
		rate.setForeground(new Color(0, 0, 51));
		scanPanel.add(rate);
		rate.setColumns(10);

		JLabel lblNewLabel_24 = new JLabel("Discount");
		lblNewLabel_24.setBounds(330, 0, 82, 16);
		lblNewLabel_24.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_24.setForeground(new Color(0, 0, 102));
		scanPanel.add(lblNewLabel_24);

		// discount = new JTextField();
		discount = new gnRoundTextField(20);
		discount.setBounds(328, 17, 98, 32);

		discount.setFont(new Font("Arial Black", Font.PLAIN, 18));
		discount.setBackground(Color.WHITE);
		discount.setForeground(new Color(0, 0, 51));
		scanPanel.add(discount);
		discount.setColumns(10);

		lblNewLabel_27 = new JLabel("Sales Order No");
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_27.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lblNewLabel_27.setBounds(0, 25, 176, 21);
		panel.add(lblNewLabel_27);

		SONO = new JTextField();
		SONO.setBounds(162, 25, 119, 27);
		panel.add(SONO);
		SONO.setHorizontalAlignment(SwingConstants.LEFT);
		SONO.setForeground(Color.WHITE);
		SONO.setToolTipText("Invoice No - Auto Generated Code");
		SONO.setFont(new Font("Arial", Font.BOLD, 16));
		SONO.setBackground(new Color(0, 0, 51));
		SONO.setEditable(false);
		SONO.setColumns(10);

		SODATE = new JTextField();
		SODATE.setBounds(288, 25, 116, 28);
		panel.add(SODATE);
		SODATE.setHorizontalAlignment(SwingConstants.LEFT);
		SODATE.setForeground(Color.WHITE);
		SODATE.setToolTipText("Billing Date");
		SODATE.setText(" ");
		SODATE.setFont(new Font("Arial", Font.BOLD, 16));
		SODATE.setBackground(new Color(0, 0, 51));
		SODATE.setEditable(false);
		SODATE.setColumns(10);

		btnPanel = new JPanel();
		btnPanel.setBounds(797, -4, 529, 50);
		panel.add(btnPanel);
		btnPanel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 51, 51)));
		btnPanel.setBackground(Color.WHITE);
		btnPanel.setLayout(null);

		btnSave = new JButton("Save");
		btnSave.setBounds(0, 13, 90, 32);
		btnPanel.add(btnSave);
		btnSave.setSelectedIcon(new ImageIcon("D:\\AKN\\ItemImage\\Save.png"));
		btnSave.setIcon(null);
		btnSave.setForeground(new Color(0, 51, 102));
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnSave.setMnemonic('S');

		btnPrint = new JButton("Print");
		btnPrint.setBounds(90, 13, 90, 32);
		btnPanel.add(btnPrint);
		btnPrint.setForeground(new Color(0, 51, 102));
		btnPrint.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnPrint.setMnemonic('P');

		btnCustomer = new JButton("Customer");
		btnCustomer.setBounds(181, 13, 110, 32);
		btnPanel.add(btnCustomer);
		btnCustomer.setForeground(new Color(0, 51, 102));
		btnCustomer.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnCustomer.setMnemonic('O');

		btnReceipts = new JButton("Receipts");
		btnReceipts.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnReceipts.setBounds(292, 13, 133, 32);
		btnPanel.add(btnReceipts);
		btnReceipts.setToolTipText("Select This Option if Customer Paid Payment ");
		btnReceipts.setMnemonic('R');

		btnClose = new JButton("Close");
		btnClose.setBounds(425, 13, 99, 32);
		btnPanel.add(btnClose);
		btnClose.setForeground(new Color(0, 51, 102));
		btnClose.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		btnClose.setMnemonic('C');

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(906, 85, 420, 62);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("Records");
		lblNewLabel_11.setBounds(12, 4, 92, 16);
		panel_3.add(lblNewLabel_11);
		lblNewLabel_11.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));
		lblNewLabel_11.setForeground(Color.BLACK);

		records = new JTextField();
		records.setBounds(13, 23, 84, 30);
		panel_3.add(records);
		records.setToolTipText("No.of Records in Current Bill");
		records.setHorizontalAlignment(SwingConstants.LEFT);
		records.setBackground(Color.WHITE);
		records.setForeground(new Color(0, 0, 51));
		records.setFont(new Font("Calibri", Font.BOLD, 14));
		records.setEditable(false);
		records.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Total Qty");
		lblNewLabel_15.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));
		lblNewLabel_15.setBounds(111, 4, 85, 16);
		panel_3.add(lblNewLabel_15);

		totalqty = new JTextField();
		totalqty.setBounds(111, 23, 85, 30);
		panel_3.add(totalqty);
		totalqty.setBackground(Color.WHITE);
		totalqty.setEditable(false);
		totalqty.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("SO Amount");
		lblNewLabel_12.setBounds(214, 0, 137, 25);
		panel_3.add(lblNewLabel_12);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_12.setForeground(Color.BLACK);
		lblNewLabel_12.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));

		Tamount = new JTextField();
		Tamount.setBounds(208, 23, 124, 30);
		panel_3.add(Tamount);
		Tamount.setToolTipText("Total Sales Amount");
		Tamount.setHorizontalAlignment(SwingConstants.LEFT);
		Tamount.setBackground(Color.WHITE);
		Tamount.setFont(new Font("Arial", Font.BOLD, 20));
		Tamount.setForeground(new Color(0, 0, 153));
		Tamount.setEditable(false);
		Tamount.setColumns(10);

		panel_7 = new JPanel();
		panel_7.setBounds(907, 177, 419, 60);
		panel.add(panel_7);
		panel_7.setBackground(Color.CYAN);
		panel_7.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_7.setLayout(null);

		JLabel lblNewLabel_25 = new JLabel("Disc %");
		lblNewLabel_25.setBounds(198, 0, 82, 24);
		panel_7.add(lblNewLabel_25);
		lblNewLabel_25.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_25.setForeground(Color.BLACK);

		// discper = new JTextField();
		discper = new gnRoundTextField(10);
		discper.setBounds(198, 22, 82, 32);
		panel_7.add(discper);
		discper.setFont(new Font("Arial Black", Font.PLAIN, 15));

		discper.setForeground(new Color(0, 0, 153));
		discper.setColumns(10);

		JLabel lblNewLabel_28 = new JLabel("Disc.Amt");
		lblNewLabel_28.setBounds(303, 0, 82, 22);
		panel_7.add(lblNewLabel_28);
		lblNewLabel_28.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_28.setForeground(Color.BLACK);

		// disc = new JTextField();
		disc = new gnRoundTextField(20);
		disc.setBounds(293, 24, 84, 30);
		panel_7.add(disc);
		disc.setToolTipText("In Case On Total Bill Value If You Want DISCOUNT To Customer Then Enter Here in Rs.");
		disc.setText(" ");
		disc.setBackground(Color.WHITE);
		disc.setHorizontalAlignment(SwingConstants.LEFT);
		disc.setForeground(new Color(0, 0, 51));
		disc.setFont(new Font("Arial Black", Font.PLAIN, 15));
		disc.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Order Discount");
		lblNewLabel_5.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblNewLabel_5.setBounds(78, 22, 126, 32);
		panel_7.add(lblNewLabel_5);
		
		 

		// btnEdit.addActionListener(btn);

		;

		jsp = new JScrollPane();
		jsp.setBounds(10, 242, 1328, 308);
		SalesOrderFrame.getContentPane().add(jsp);
		jsp.setViewportBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 550, 1326, 50);
		SalesOrderFrame.getContentPane().add(panel_6);
		panel_6.setBackground(Color.WHITE);
		panel_6.setBorder(new CompoundBorder());
		panel_6.setLayout(null);

		lblNewLabel_1 = new JLabel("Gross Amount");
		lblNewLabel_1.setBounds(12, 23, 137, 22);
		panel_6.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(Color.BLACK);

		//grossamt = new JTextField();
		grossamt = new gnRoundTextField(10);
 		grossamt.setBounds(133, 18, 137, 30);
		panel_6.add(grossamt);
		grossamt.setForeground(new Color(51, 0, 153));
		grossamt.setBackground(Color.WHITE);
		grossamt.setFont(new Font("Arial", Font.BOLD, 20));
		grossamt.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(289, 13, 1049, 41);
		panel_6.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_26 = new JLabel("Bill Discount");
		lblNewLabel_26.setBounds(68, 11, 91, 16);
		panel_4.add(lblNewLabel_26);
		lblNewLabel_26.setToolTipText("Bill Level Discount Given");
		lblNewLabel_26.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_26.setForeground(Color.BLACK);

		//billdisc = new JTextField();
		billdisc = new gnRoundTextField(10);
 		billdisc.setBounds(161, 5, 130, 30);
		panel_4.add(billdisc);
		billdisc.setForeground(new Color(0, 102, 153));
		billdisc.setToolTipText("Bill Level Given Discount");
		billdisc.setBackground(Color.WHITE);
		billdisc.setFont(new Font("Arial Black", Font.PLAIN, 14));
		billdisc.setColumns(10);

		JLabel lblNewLabel_19 = new JLabel("Value After Disc");
		lblNewLabel_19.setBounds(531, 9, 117, 16);
		panel_4.add(lblNewLabel_19);
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_19.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_19.setForeground(Color.BLACK);

		//tvalue = new JTextField();
		tvalue = new gnRoundTextField(10);
 		tvalue.setBounds(641, 5, 165, 30);
		panel_4.add(tvalue);
		tvalue.setToolTipText("Amount After Discount(LineLevel+Bill Level)");
		tvalue.setFont(new Font("Arial", Font.BOLD, 20));
		tvalue.setForeground(new Color(51, 102, 153));
		tvalue.setBackground(Color.WHITE);
		tvalue.setHorizontalAlignment(SwingConstants.LEFT);
		tvalue.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("Rounding Amt");
		lblNewLabel_20.setBounds(818, 9, 104, 16);
		panel_4.add(lblNewLabel_20);
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_20.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_20.setForeground(Color.BLACK);

		//roundingamt = new JTextField();
		roundingamt = new gnRoundTextField(10);
 		roundingamt.setBounds(921, 5, 116, 30);
		panel_4.add(roundingamt);
		roundingamt.setFont(new Font("Arial Black", Font.PLAIN, 14));
		roundingamt.setForeground(new Color(51, 102, 153));
		roundingamt.setBackground(Color.WHITE);
		roundingamt.setHorizontalAlignment(SwingConstants.LEFT);
		roundingamt.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Discount");
		lblNewLabel_2.setBounds(323, 13, 66, 16);
		panel_4.add(lblNewLabel_2);
		lblNewLabel_2.setToolTipText("Line Level Discount Given");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(Color.BLACK);

		//linedisc = new JTextField();
		linedisc = new gnRoundTextField(10);
 		linedisc.setBounds(391, 5, 131, 30);
		panel_4.add(linedisc);
		linedisc.setForeground(new Color(0, 102, 153));
		linedisc.setToolTipText("Line Level Given Discount");
		linedisc.setBackground(Color.WHITE);
		linedisc.setFont(new Font("Arial Black", Font.PLAIN, 14));
		linedisc.setColumns(10);
		
		sjsp = new JScrollPane();
		sjsp.setBounds(914, 242, 430, 308);
		//SalesOrderFrame.getContentPane().add(sjsp);
		

		
		
		
		ActionListener scanQty = new scanqtyLsnr();
		ActionListener scanRate = new scanrateLsnr();
		ActionListener Manuldisc = new scandiscLsnr();
		ActionListener dscls = new discLsnr();
 		FocusListener fls = new btnfocus();

		KeyListener kk = new keyPressedlsnr();
		scanqty.addActionListener(scanQty);
		rate.addActionListener(scanRate);
		discount.addActionListener(Manuldisc);
		searchname.addActionListener(nm);
		scanarticle.addActionListener(article);

		disc.addActionListener(dscls);
		btnClose.addActionListener(btn);
		btnReceipts.addFocusListener(fls);
		btnReceipts.addKeyListener(kk);
		btnReceipts.addActionListener(btn);
		btnCustomer.addFocusListener(fls);
		btnCustomer.addKeyListener(kk);
		btnCustomer.addActionListener(btn);
		btnPrint.addFocusListener(fls);
		btnPrint.addKeyListener(kk);
		btnPrint.addActionListener(btn);
		btnSave.addFocusListener(fls);
		btnSave.addKeyListener(kk);
		btnSave.addActionListener(btn);
		
		ActionListener   dscperLs = new discperLsnr() ;
		discper.addActionListener(dscperLs);
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

				if (btnPrint.isFocusOwner()) {
					btnPrint.doClick();
				}

				if (btnClose.isFocusOwner()) {
					btnClose.doClick();
				}

				if (btnCustomer.isFocusOwner()) {
					btnCustomer.doClick();
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

			if (btnPrint.isFocusOwner()) {
				btnPrint.setBackground(Color.yellow);
			}

			if (btnClose.isFocusOwner()) {
				btnClose.setBackground(Color.yellow);
			}

			if (btnCustomer.isFocusOwner()) {
				btnCustomer.setBackground(Color.yellow);
			}

			if (btnReceipts.isFocusOwner()) {
				btnReceipts.setBackground(Color.yellow);
			}

		}

		@Override
		public void focusLost(FocusEvent e) {

		}
	}

	private void decorate() throws Throwable {

	 
		new gnApp().setFrameTitel(SalesOrderFrame);
		SalesOrderFrame.setUndecorated(true);
		int typeno = 2;
		new gnDecorate().SetSeqHdrButton(btnSave, typeno);
		new gnDecorate().SetSeqHdrButton(btnPrint, typeno);
		new gnDecorate().SetSeqHdrButton(btnClose, typeno);
		new gnDecorate().SetSeqHdrButton(btnCustomer, typeno);
		new gnDecorate().SetSeqHdrButton(btnReceipts, typeno);
		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		try {

			gnProductDetails kk;
			kk = new gnProductDetails();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		chekcFreezeYear();
		this.checkInternet();
		if (Language == "H") {
			customername.setFont(new Font("Shivaji02", Font.PLAIN, 16));
		}
		new gnField().closeform(btnSave, SalesOrderFrame);

		String vpara29 = "29";
		String vEditDocumentAllow = new getConfigurationSetting().getSpecificConfiguration(vpara29);
		switch (vEditDocumentAllow) {
		case "N":
			// btnEdit.setVisible(false);
			break;
		}

		vallow = new gnDate().checkDayBegin();
		switch (vallow) {
		case "Y":
			delTableRow(table, model, "WS");
			vcomp = new gnConfig().getCompanyCode();
			SODATE.setText(new gnConfig().getDaybeginDate());
			new gnField().closeform(btnSave, SalesOrderFrame);
			new gnField().showInventory(btnSave, "INV");
			new gnField().showCalc(btnSave, "CAL");
			new gnField().moveDown(table);
			new gnField().closeform(btnSave, SalesOrderFrame);
			String vtype = "SALE";
			String vallowDate = new gnDate().checkBackDateTrAllow(vtype, SODATE.getText());
			switch (vallowDate) {
			case "N":

				SODATE.setBackground(Color.RED);
				SODATE.setForeground(Color.WHITE);
				new General().msg("Back Date For Transaction is not Allow..");
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				SODATE.setText("?");
				scanarticle.setVisible(false);
				searchname.setVisible(false);
				customername.setEditable(false);
				break;
			}

			if (vcomp == "0") {
				System.exit(0);
			}

			if (vcomp != "0") {

			}
			break;
		case "N":
			break;
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
  				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}
 	
	private void chekcFreezeYear() {
		switch (isFinyearFreeze) {
		case "Y":
			// btnEdit.setVisible(false);
			btnSave.setVisible(false);
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
 				e.printStackTrace();
			}
		}
	}

	
	class discperLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String vdiscper  = discper.getText();
				DistributeDiscountper(vdiscper) ;
 			} catch (Throwable e) {
 				e.printStackTrace();
			}
		}
	}


	
	public void DistributeDiscount() throws Throwable {
  		
		//public String poscol[] = { "0Romove", "1Item", "2Namee", "3Qty", 
		//		  "4 UOM", "5 Inner Qty", "6 Rate", 
		//		  "7 MRP", "8 Gross", "9 Bill Disc",
		//		  "10 Disc", "11 Amount", "12 Tax%" };

		double vdisamt = Double.parseDouble(disc.getText());
		double vgross = 0.0;
		double vmygross = 0.0;
		String vmydiscper = null;
			int row = table.getRowCount();
		if (row > 0) {
			for (int i = 0; i < row; i++) {
				vgross = Double.parseDouble(table.getValueAt(i, 8).toString());
					vmygross = vmygross + vgross;
			}
			double vmydidcper = (vdisamt / vmygross) * 100;
			vmydiscper = new gnMath().get2DecimaltValue(Double.toString(vmydidcper));
			discper.setText(vmydiscper);
		}
		try {
			DistributeDiscountper(vmydiscper);
			recalculateData() ;
		} catch (Throwable e) {
			e.printStackTrace();
		}
 	}

	public void DistributeDiscountper(String vvdiscper) throws Throwable 
 	{
 		//public String poscol[] = { "0Romove", "1Item", "2Namee", "3Qty", 
		//		  "4 UOM", "5 Inner Qty", "6 Rate", 
		//		  "7 MRP", "8 Gross", "9 Bill Disc",
		//		  "10 Disc", "11 Amount", "12 Tax%" };
  		double vqty = 0.00;
		double vdiscper = Double.parseDouble(vvdiscper);
		double vgross = 0.00;
		double proposeDiscount = 0.0;
		double issueDiscount = 0.0;
		double vdiscamt = 0.00;
	 	proposeDiscount = Double.parseDouble(disc.getText());
		int row = table.getRowCount();
		if (row > 0) {
			for (int i = 0; i < row; i++) {
				vgross = Double.parseDouble(table.getValueAt(i, 8).toString());
	 			vdiscamt = vgross * vdiscper / 100;
				issueDiscount = issueDiscount + vdiscamt;
 				String vmydiscamt = new gnMath().get2DecimaltValue(Double.toString(vdiscamt));
				table.setValueAt(vmydiscamt, i, 9);
 			}
 		} 	
		recalculateData() ;
  	}
	

	
	private void recalculateData() throws Throwable {
		int row1 = table.getRowCount();
		if (row1 > 0) {
			for (int k = 0; k < row1; k++) {
				String value = table.getValueAt(k, 1).toString();
				try {
					QtychangeImapct(value, k);
				} catch (ClassNotFoundException | SQLException e) {
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

	 
	
	class crdaysLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			int vcrdays = Integer.parseInt(crdays.getText());
			try {
				String vduedate = new gnConfig().get_duedate(new gnConfig().date_ConverttoDBforamt(SODATE.getText()),
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
				SalesOrderFrame.dispose();
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
					e.printStackTrace();
				}
			}
		}
	}

	 	
	class BtnPressLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Edit SO") {
				new gnLogger().loggerInfoEntry("Credit Sale", "Edit Credit Sales Option Selected..");
				EditMode = "Y";
				// btnEdit.setBackground(Color.BLUE);
				// btnEdit.setForeground(Color.WHITE);
				scanarticle.setVisible(false);
				searchname.setVisible(false);
				custnameLsnr abc = new custnameLsnr();
				abc.actionPerformed(e);
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
					new gnLogger().loggerInfoEntry("Sale Order",
							"Exception While Receipt transaction selection.." + " " + e1.getMessage());
				}
			}

			if (value == "Save") {
				new gnLogger().loggerInfoEntry("  Sale Order", "Data Validation  Process Starts....");
				String status = validate();
				if (status == "Sucess") {
					try {
						new gnLogger().loggerInfoEntry(" Sale Order", "Saving Data Process Starts....");
						PrepareToInsert();
					} catch (Throwable e1) {
						new General().msg(e1.getMessage());
						new gnLogger().loggerInfoEntry(" Sale Order",
								"Saving Data Process Exception...." + " " + e1.getMessage());
					}
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
			
		 
			if (value == "Close") {
				SalesOrderFrame.dispose();
			}

		}
	}

	class custcodeLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (vallow == "N") {
				SalesOrderFrame.dispose();
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
	
	
	
 	class custnameLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (vallow == "N") {
				SalesOrderFrame.dispose();
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

 	
 	
 	

	private void setcustomerGSTdetail() throws Throwable {
		String vcustcode = customercode.getText();
		try {
			if (vcustcode.length() > 0) {
				String vstatecode = new gnGST().getCustomerState(vcustcode);
				String vstatename = new gnGST().getCustomerStatename(vcustcode);
				String vregdlr =    new gnGST().isCustmoerGSTRegister(vcustcode);
  			}
		} catch (Exception e) {
			new gnLogger().loggerInfoEntry("Credit Sale",
					"Cust GST Related Master display ...." + " " + e.getMessage());
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
			SODATE.setText(new gnSale().rinvdate);
			SONO.setText(new gnSale().rinvno);
			new gnSale().rinvdate = null;
			new gnSale().rinvno = null;
			String vinvno = SONO.getText();

			if (vinvno.length() == 0) {
				reset();
			}

			if (vinvno.length() > 0) {
				String vinvdate = new gnConfig().date_ConverttoDBforamt(SODATE.getText());
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
		new gnLogger().loggerInfoEntry("Sale Order", "Edit Process Starts...");
 
		//new General().msg("Edititng Starts Now Level 2.. ");
 		EditMode = "Y";
		SODATE.setText(vdocDate);
		SONO.setText(vdocno);
		String vinvno = SONO.getText();
		String vinvdate = new gnConfig().date_ConverttoDBforamt(vdocDate);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vtype3 = "SO";
		String SQL = "Call sale_getEditSalesData( '" + vtype3 + "', " + vcomp + " ,  " + vstore + "  , " + vdocno
				+ ", '" + vinvdate + "' )";
		//new General().msg(SQL);
		ShowTableData(SQL, poscol);
 		scanarticle.setVisible(true);
		searchname.setVisible(true);
		setcustomerGSTdetail();
	}


	
	class ArticlecodeLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// String value = e.getActionCommand();
			if (vallow == "N") {
				SalesOrderFrame.dispose();
				new General().msg("Complete Day Open First ....");
				return;
			}

			String varticle = scanarticle.getText();
			String SQL = " ";
			if (varticle.length() > 0) {
				try {
					showArticleData(varticle);
		 		} catch (Throwable e1) {
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
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vpriceselection = "Normal Price";
		switch (vpriceselection) {
		case "Normal Price":
			vtype = "WS";
			String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
					new gnPublicVariable().vstore);
			SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , " + varticle + ", " + vcomp + " , "
					+ vstore + " , '" + vfinyear + "'  , " + vverticlecode + ")";
			new gnLogger().loggerInfoEntry("Credit Sale", "Article Scan..." + " " + varticle);
			ShowTableData(SQL, poscol);
			break;
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
				customercode.setText(rs.getString(13));
				customername.setText(rs.getString(14));
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
							rs.getString(10), rs.getString(11), rs.getString(12)});
							//vtaxamt, rs.getString(14),
							//rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18) });

			//String vmsname = "Location";
			//String vverticle = new gnHierarchy().getVerticleCode();
			//String vsearch = "%%";
			//String SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticle + " , '" + vsearch + "')";
			//table.getColumnModel().getColumn(18).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL1)));
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
			new gnTable().setTablewidth(table, 5, 150);
			removeRow(model, table);
			Double v = new gnTable().getTotal(table, 11);
			vdueamount = v;
			setHeaderTotal() ;
			resetFigures();
			scanarticle.setText("");
			scanarticle.grabFocus();
 		}
	}

	

	private void setHeaderTotal()
	{
		Double v = new gnTable().getTotal(table, 11);
		Tamount.setText(Double.toString(v));
		vdueamount = v;
		int vcount = table.getRowCount();
		records.setText(Integer.toString(vcount));
		Double v1 = new gnTable().getTotal(table, 3);
		totalqty.setText(Double.toString(v1));
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
 
		if (vrate <= 0.00) {
			// Action = "Fail";
			new General().msg("Please Check Cost  at Row" + "  " + i);
			// table.setValueAt("0", i, 6);
		}

		if (vqty <= 0.00) {
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
		 Result = "N";
		switch (Result) {
		case "N":
			vtaxamt = 0.00;
			break;
		case "Y":
			// table.setValueAt(vtaxamt, i, 13);
			break;
		}

		table.addNotify();
		vcheckMargin = "Y";
		setHeaderTotal() ;
 		resetFigures();
		scanarticle.setText("");
		scanarticle.grabFocus();
		new gnLogger().loggerInfoEntry("Credit Sale", "Data Edited" + " Line  " + i + "Value " + value);
	}

	public void resetFigures() throws Throwable {

		// {0"Romove", 1"Item", 2"Name", 3"Qty" , 4"UOM", 5"Inner Qty" , 6"Rate"
		// ,
		// 7"MRP", 8"Gross" ,9"Hdr Disc", 10"Disc" ,
		// 11"Amount", 12"Taxcode"

 
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		records.setText(RecordCount1);

		// New Part Added

		grossamt.setText(Double.toString(new gnTable().getTotal(table, 8)));
		linedisc.setText(Double.toString(new gnTable().getTotal(table, 10)));
		billdisc.setText(Double.toString(new gnTable().getTotal(table, 9)));

		tvalue.setText(Double.toString(new gnTable().getTotal(table, 11)));

		Double vtamt = (new gnTable().getTotal(table, 11));
		int vnetAmtnew = (int) Math.round(vtamt);
		double vroundamt = (vnetAmtnew - vtamt);

		// roundng Logic is Here
		roundingamt.setText(new gnMath().get2DecimaltValue(Double.toString(vroundamt)));
		Tamount.setText(new gnMath().get2DecimaltValue(Double.toString(vnetAmtnew)));
		new gnLogger().loggerInfoEntry("Credit Sale", "Reset Operation Done");
	}

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
	private JLabel lblstatus;
	private JTextField mobile;
 
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
			vbatchno = (String) stable.getValueAt(row, 6);
			vexpdate = (String) stable.getValueAt(row, 8);
			table.setValueAt(vbatchno, selectedrow, 15);
			table.setValueAt(vexpdate, selectedrow, 16);
			new gnTable().RemoveTableRows(smodel);
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
							records.setText(Integer.toString(vcount));
						}
					}
					return;
				}
			}
		});
	}

	private String validate() {
		new gnLogger().loggerInfoEntry("Credit Sale", "Validation Starts");
		String status = "Sucess";
 		vcustomer = customercode.getText();
   
 		
 		
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

		String status1 = new gnTable().isAmountnegative(Tamount.getText());
		String status2 = new gnTable().istableColValueNegative(table, 3);
		String status3 = new gnTable().istableColValueNegative(table, 6);
		Double vamt = Double.parseDouble(Tamount.getText());

		if (status1 == "Fail" || status2 == "Fail" || status3 == "Fail") {
			status = "Fail";
		}

		if (vamt == 0.00) {
			new General().msg("Enter  Invoice Qty For Billing ");
			status = "Fail";
		}
		
		if (mobile.getText().length() == 0 )
		{
			mobile.setText("0");
		}
		
		new gnLogger().loggerInfoEntry("Sale Order", "Validaion Over - Status is" + "" + status);
		return status;
	}

	private void PrepareToInsert() throws Throwable {

		if (EditMode == "N") {
			SONO.setText(new gnSeq().getSeqno("51", "TR"));
		}
		vinvno = SONO.getText();
		vsalestype = "SO";
		vinvtype = "SO";
		vglcode = new gnSeq().getGlcode("51", "TR");
		vpostingtype = "Y";

		try {
			new gnLogger().loggerInfoEntry("Sale Order", "Data Insert Process Start");
			vcustomer = customercode.getText();
			vuser = new gnConfig().getUserCode();
			vinvdate = new gnConfig().date_ConverttoDBforamt(SODATE.getText());
			vterminal = "0";
			vtime = new General().getTime();
			vverticle = new gnHierarchy().getVerticleCode();
			vnetamount = Tamount.getText();
			vcreditDays = crdays.getText();
			vpaytype = "Due";
			// End GST Field

		} catch (Exception e) {
			new General().msg("Prepare to insert :" + e.getLocalizedMessage());
		}
 		insertintoGLmaster();
 		if (EditMode == "Y") {
 			new General().Quickmsg("Edit Execution Starts ..");
			new gnEDMiddleWare().SOModification(vinvtype, SONO.getText(), SODATE.getText());
		}
		insertSODetails();
	}

	
	
	private void insertintoGLmaster() throws Throwable {
		String vglcode = customercode.getText();
		String vglname = customername.getText();
		String vtype = "N";
		new gnAccountbase().insertGlData(vglcode, vglname, vtype);
	}

	//// pos Details Start here
	public void insertSODetails() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		int pd_seq;
		DBdetail = "Fail";
		String poshdr = "Insert into so_detail (company_code ,"
				+ "site_code,  docType ,  docDate	,  docno,  Finyear ,    "
				+ "Party   , Line_seq , Article_code ,  qty , Rate,  Gross, Bill_disc, Disc ,   "
				+ "NetAmount , taxcode , verticle) "
 				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;

		prst = con1.prepareStatement(poshdr);
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				pd_seq = k + 1;
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vsalestype);
 				prst.setString(4, vinvdate);
 				prst.setString(5, vinvno);
 				prst.setString(6, new gnFinYear().getCurrentFinYear(SODATE.getText()));
 				prst.setString(7, vcustomer);
				prst.setInt( 8, pd_seq); // lineseq
 				prst.setString(9, table.getValueAt(k, 1).toString());
  				prst.setString(10, (table.getValueAt(k, 3).toString())); // invqty
   				prst.setDouble(11, Double.parseDouble(table.getValueAt(k, 6).toString())); // SP
				prst.setDouble(12, Double.parseDouble(table.getValueAt(k, 8).toString())); // Gross
				prst.setDouble(13, Double.parseDouble(table.getValueAt(k, 10).toString())); // disc
				prst.setDouble(14, Double.parseDouble(table.getValueAt(k, 9).toString())); // hdrdisc
				prst.setDouble(15, Double.parseDouble(table.getValueAt(k, 11).toString())); // netAmt
				prst.setString(16, table.getValueAt(k, 12).toString()); // tax_per
 				prst.setString(17, vverticle);
 				prst.addBatch();
				// new General().msg("Reahed...POs detail "+prst);
 				TotalRecordinsert = TotalRecordinsert + 1;
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
			new gnLogger().loggerInfoEntry("  Sale Order ", "Detail Data Exception" + " " + e.getMessage());
			new General().msg("Detail:" + e.getMessage());
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {
				insertSOHdr();
			}
		}
	}

	public void insertSOHdr() throws Throwable {
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con2 = this.getConnection();
		con2.setAutoCommit(false);
		DBhdr = "Fail";
		String poshdr = "Insert into SO_hdr(company_code , site_code,"
				+ " doctype ,   docno,   docDate ,  "
				+ " party , finyear , verticle , Gross, "
				+ " Discount,  Roundingamt, NetAmount,"
				+ " DeliveryDate,  remark , time , updateDate , Createdby ,"
 			 	+ " ShippingAddr1 , ShippingAddr2 ,   "
 				+ " status , InvCreated, SOTYPE , Mobile ) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
		try {
			prst = con2.prepareStatement(poshdr);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, vsalestype);
  			prst.setString(4, vinvno);
   			prst.setString(5, vinvdate);
   			prst.setString(6, vcustomer);
			prst.setString(7, new gnFinYear().getCurrentFinYear(SODATE.getText()));
			prst.setString(8, vverticle);
			prst.setDouble(9, Double.parseDouble(tvalue.getText()));
			prst.setDouble(10, vvdisc);
			prst.setString(11, roundingamt.getText());
			prst.setString(12, vnetamount);
			prst.setString(13, new gnConfig().date_ConverttoDBforamt(paymentduedate.getText()));
			prst.setString(14, "Manual Sales Order Generated..") ;
			prst.setString(15, new General().getTime());
   			prst.setString(16, vinvdate);
   			prst.setString(17, vuser);
   			prst.setString(18, shipaddr1.getText());
   			prst.setString(19, shipaddr1.getText());
   			prst.setString(20, "Open");
   			prst.setString(21, "N");
   			prst.setString(22, "NonWeb");
   			prst.setString(23, mobile.getText());
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
			new gnLogger().loggerInfoEntry("  Sale order ", "Hdr Data Exception" + " " + e.getMessage());
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
				new gnLogger().loggerInfoEntry("Sales Order", "Detail & Hdr Data  Save- Sucess");
				new General().msg("Sales Order Data Saved Status -->Sucess ");
				new gnSeq().updateSeqno("51", "TR");
				reset();
			}
		}
	}//// Insert Heade End

	
	
	private void callprint() throws Throwable {

		String vpara27 = "27";
		String printinvoice = new getConfigurationSetting().getSpecificConfiguration(vpara27);
		switch (printinvoice) {
		case "Y":
			new General().msg("Printing Invoice");
			String vinvno = SONO.getText();
			String doctype = "Credit-INV";
			new gnDocPrint().callprint(doctype, vinvno, SODATE.getText());
			new gnLogger().loggerInfoEntry("Credit Sale", "Printing Document");
		}
	}

	private void reset() {
		// invno.setText(null);
		new gnLogger().loggerInfoEntry("Credit Sale", "Transaction Complete- Sucess");
		EditMode = "N";
		customercode.setText("0");
		customername.setText(null);
		scanarticle.setVisible(true);
		searchname.setVisible(true);
		try {
			SODATE.setText(new gnConfig().getDaybeginDate());
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 		customercode.setText("0");
		customername.setText(null);
		;
		Tamount.setText("0");
		records.setText("0");
		crdays.setText("0");
		paymentduedate.setText("0");
		new gnTable().RemoveTableRows(pmodel);
		new gnTable().RemoveTableRows(model);
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

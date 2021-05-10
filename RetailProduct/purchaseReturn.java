package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

public class purchaseReturn extends getResultSet {

	Connection con, con1, con2, con3, con4, con5, con6, con7;
	String vfinyear;
	String EditMode = "N";
	JButton btnEdit;
	int selectedrow;
	String vstore;
	private JTextField approvedby;
	String tableEntry;
	private JTextField approvedate;
	private JTextField dnno;
	private JTextField dnamount;
	private JTextField dnexpdate;
	private JTextField dnstatus;
	private JButton btnGetBatch;
	private JTextField email;
	private JLabel lblNewLabel_6;
	private JTextField regdlr;
	private JCheckBox importPurchase;
	private JCheckBox sez;
	private JButton btnAcEntry;

	private String vapprove;
	private String vapprovedby;
	private String vapprovedate;
	private JInternalFrame internalFrame;
	private JPanel dnPanel;
	private JTextField creditDays;
	private String vglcode;

	String vdoctype2 = "";
	String vtaxtype = " ";
	String vcgst = "";
	String vsgst = "";
	String vigst = " ";
	String vdoctype;
	String vmethod;
	String vsalestype;
	String vdocdate;
	String vparty;
	String vdocdt;
	String Vscheme = "";
	public static String varticle;
	private String DNCNstatus;
	private String vsgrnno;
	private JButton btnPrint;
	private JButton btnClose;
	private JButton btnSave;
	private JButton btnUpdate;
	private String vverticle;
	private String vcomp;
	private Connection conDtl;
	private Connection conHead;

	// GST
	private String vmygstno;
	private String vmycompanystate;
	private String vmyCompanyisGST;

	private String vstate;
	private String vstatename;
	private String vregdlr;
	private String vcustGSTno;
	private String vmovtype;
	private Double vtaxamount;
	private String vreversechrg;
	JCheckBox chrevchrg;
	private String vimport;
	private String vsez;
	private String vmystatename;

	// GST End
	private String vstorecode;
	private String vgrnDate;
	private int vgrnno;
	private String vgrnno1;
	private String vduedate;
	private int vpono;
	private String vtype = "WP";
	private int vvendor;
	private String vinvno;
	private String vinvDate;
	private Double vinvamt;
	int vmy;
	int voth;

	private Double vcostvalue;
	private Double vothcharges;
	private Double vtotalamount;
	private JTextField companycode;
	private JTextField remark;
	private JPanel approvalpanel;
	private JCheckBox approve;

	private String vcreateBy;
	private String vupdateDate;
	private int vcreditDays;
	private int TotalRecordinsert = 0;
	private String DBaction = "Fail";
	private String DBhdr = "Fail";
	private String DBdetail = "Fail";
	private String DBstock = "Fail";

	/// end table Varibales
	private JTextField scanName;
	JFrame frmpurchaseReturn;
	private JTextField grndate;
	private JTextField grnno;
	String vallow;
	private JTextField VendorCode;
	private JTextField VendorName;
	private JTextField InvoiceNumber;
	private JTextField InvoiceDate;
	private JTextField TotalAmount;
	private JTextField InvAmt;
	private JTextField scanItem;
	private JTextField records;
	private JTextField Storecode;
	private JTextField storename;
	private JTextField SupplierPayable;
	private JTextField Othcharges;
	private JLabel Msg;
	// For Customer Search
	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public String SCol[] = { "Type", "Customer code", "Name", "Phone", "Email", "Credit Days" };
	public JViewport prt6 = new JViewport();
	public JScrollPane sjsp;

	// For Item Name Search
	public DefaultTableModel nmodel = new DefaultTableModel();
	public JTable ntable = new JTable();
	public String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost" };

	DefaultTableModel model = new DefaultTableModel() {
		/*
		 * Class[] types = new Class [] { //{"Article_code" , "Name" , "Qty" ,
		 * "UOM" , "cost" , "CostValue " ,"Trans.Chrg" , "Manuf.Chrg" ,
		 * "Packing Chrgs" , "Landing Cost", "Tax%"}; java.lang.String.class,
		 * java.lang.String.class, java.lang.Double.class,
		 * java.lang.String.class, java.lang.Double.class,
		 * java.lang.Double.class , java.lang.Double.class ,
		 * java.lang.Double.class , java.lang.Double.class,
		 * java.lang.Double.class, java.lang.Double.class,
		 * java.lang.Double.class };
		 * 
		 * @Override public Class getColumnClass(int columnIndex) { return types
		 * [columnIndex]; }
		 */
		@Override
		public boolean isCellEditable(int row, int column) {
			// 2 4 6 7 8 9 10 14 15 16 19
			return column == 0 || column == 3 || column == 5 || column == 7 || column == 8 || column == 9
					|| column == 10 || column == 11 || column == 15 || column == 16 || column == 17 || column == 19
							? true : false;
		}

		public boolean isCellEnabled(int row, int column) {
			// 2 4 6 7 8 9 10 14 15 16 19
			return column == 0 || column == 3 || column == 5 || column == 7 || column == 8 || column == 9
					|| column == 10 || column == 11 || column == 15 || column == 16 || column == 17 || column == 19
							? false : true;
		}

	};

	//// Table Related
	public DefaultTableModel pmodel = new DefaultTableModel();

	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 5 || column == 7 || column == 8 || column == 9 || column == 10
					|| column == 11 || column == 15 || column == 16 || column == 17 || column == 19) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(new Color(51, 51, 102));
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}
			if (column == 19) {
				componentt.setBackground(new Color(0, 51, 153));// .LIGHT_GRAY);
				componentt.setForeground(new Color(204, 255, 153));
				componentt.setFont(new Font("Calibri", Font.BOLD, 15));
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

	// public JTable ptable = new JTable() ;
	public JScrollPane jsp;

	public String PoCol[] = { "Type", "Article_code", "Name", "Qty", "UOM", "cost", "CostValue ", "sales Price", "MRP",
			"Trans.Chrg", "Manuf.Chrg", "Packing Chrgs", "Landing Cost", "Tax%", "Bal Qty", "Manuf.Date", "Expiry date",
			"Batch No", "Batch_Control", "Location", "EanCode" };

	// "1Type" ,2"Article_code" , 3"Name" , 4"Qty" , 5"UOM" , 6"cost" ,
	// "7CostValue " , 8 "sales Price" , 9"MRP" , 10"Trans.Chrg" ,11
	// "Manuf.Chrg" ,
	// 12"Packing Chrgs" , 13"Landing Cost", 14"Tax%" ,
	// 15"Bal Qty", 16"Manuf.Date" , 17 "Expiry date", 18 "Batch No" ,
	// 19"Batch_Control" , 20"Location" , 21 "EanCode"

	public String[] Col = { "Article Code", "Article_Name", "Qty", "UOM", "Basic Cost", "Cost_value", "Transportation",
			"Manuf,cost", "Packing Cost", " Landing Cost" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					purchaseReturn window = new purchaseReturn();
					window.frmpurchaseReturn.setVisible(true);
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
	public purchaseReturn() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frmpurchaseReturn = new JFrame();
		frmpurchaseReturn.setResizable(false);
		frmpurchaseReturn.setAlwaysOnTop(true);
		frmpurchaseReturn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmpurchaseReturn.getContentPane().setLayout(null);
 		frmpurchaseReturn.setTitle("Business Application");
		//frmpurchaseReturn.setBounds(0, 0, 1142, 660);
		frmpurchaseReturn.setBounds(1, 100, 1375, 600);
		frmpurchaseReturn.getContentPane().setLayout(null);
		frmpurchaseReturn.getContentPane().setBackground(Color.WHITE);

		String compName = new gnConfig().getCompany();
		
		
 
		/*
 		internalFrame = new JInternalFrame(compName);
 		internalFrame.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		internalFrame.setBounds(0, 0, 1370, 627);
		frmpurchaseReturn.getContentPane().add(internalFrame);
        */
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(new Color(0, 255, 255));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 0, 1345, 239);
		frmpurchaseReturn.getContentPane().add(panel);
		panel.setLayout(null);

		// VendorCode = new JTextField();
		VendorCode = new gnRoundTextField(20);
		VendorCode.setEditable(false);
		VendorCode.setFont(new Font("Calibri", Font.BOLD, 13));
		VendorCode.setBackground(Color.WHITE);
		VendorCode.setToolTipText("Enter Vendor Vcode if you Know");
		VendorCode.setBounds(174, 59, 70, 30);
		panel.add(VendorCode);
		VendorCode.setColumns(10);
		ActionListener lscust = new lscust();
		VendorCode.addActionListener(lscust);

		// VendorName = new JTextField() {
		// public void addNotify() {
		// super.addNotify();
		// requestFocus();
		// }
		// };

		VendorName = new gnRoundTextField(20) {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};

		VendorName.setFont(new Font("Calibri", Font.BOLD, 13));

		VendorName.setToolTipText("Enter Start Latters to Search Vendors");
		VendorName.setBounds(245, 59, 350, 30);
		panel.add(VendorName);
		VendorName.setColumns(10);
		ActionListener supl = new lsnrCustName();
		VendorName.addActionListener(supl);

		JLabel lblVendorCode = new JLabel("*Supplier ");
		lblVendorCode.setBackground(Color.WHITE);
		lblVendorCode.setFont(new Font("Calibri", Font.BOLD, 14));
		lblVendorCode.setForeground(Color.BLACK);
		lblVendorCode.setBounds(164, 40, 80, 16);
		panel.add(lblVendorCode);
		ActionListener apr = new approve();
		ActionListener prno1 = new prno();

		;
		ActionListener lkk = new lsBtn();

		email = new JTextField();
		email.setEditable(false);
		email.setFont(new Font("Calibri", Font.BOLD, 14));
		email.setForeground(Color.WHITE);
		email.setBackground(Color.WHITE);
		email.setBounds(174, 93, 421, 30);
		panel.add(email);
		email.setColumns(10);

		lblNewLabel_6 = new JLabel("GST Reg.Dlr");
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setBounds(285, 136, 78, 16);
		panel.add(lblNewLabel_6);

		regdlr = new JTextField();
		regdlr.setEditable(false);
		regdlr.setFont(new Font("Tahoma", Font.BOLD, 13));
		regdlr.setForeground(Color.WHITE);
		regdlr.setBackground(Color.WHITE);
		regdlr.setBounds(285, 152, 80, 22);
		panel.add(regdlr);
		regdlr.setColumns(10);

		chrevchrg = new JCheckBox("Reverse Charge Apply");
		chrevchrg.setBackground(Color.WHITE);
		chrevchrg.setFont(new Font("Tahoma", Font.PLAIN, 13));
		chrevchrg.setForeground(Color.BLACK);
		chrevchrg.setBounds(371, 151, 226, 25);
		panel.add(chrevchrg);

		JLabel lblCreditDaya = new JLabel("Credit Days");
		lblCreditDaya.setBackground(Color.WHITE);
		lblCreditDaya.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCreditDaya.setForeground(Color.BLACK);
		lblCreditDaya.setBounds(174, 136, 99, 16);
		panel.add(lblCreditDaya);

		creditDays = new JTextField();
		creditDays.setEditable(false);
		creditDays.setBackground(Color.WHITE);
		creditDays.setBounds(174, 151, 103, 22);
		panel.add(creditDays);
		creditDays.setText("0");
		creditDays.setFont(new Font("Tahoma", Font.BOLD, 13));
		creditDays.setForeground(Color.BLUE);
		creditDays.setColumns(10);

		importPurchase = new JCheckBox("Import Goods");
		importPurchase.setFont(new Font("Tahoma", Font.PLAIN, 13));
		importPurchase.setBackground(Color.WHITE);
		importPurchase.setForeground(Color.BLACK);
		importPurchase.setBounds(371, 132, 226, 25);
		panel.add(importPurchase);

		sez = new JCheckBox("SEZ Purchase");
		sez.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sez.setBackground(Color.WHITE);
		sez.setForeground(Color.BLACK);
		sez.setBounds(373, 171, 224, 25);
		panel.add(sez);

		lblNewLabel_7 = new JLabel("Purchase Return");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(12, 29, 120, 50);
		panel.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("-");
		lblNewLabel_8.setIcon(new ImageIcon(purchaseReturn.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_8.setBounds(12, 13, 120, 75);
		panel.add(lblNewLabel_8);

		JLabel lblGrnNumber = new JLabel("PR Number");
		lblGrnNumber.setBounds(409, 7, 80, 16);
		panel.add(lblGrnNumber);
		lblGrnNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrnNumber.setForeground(Color.BLACK);
		lblGrnNumber.setHorizontalAlignment(SwingConstants.LEFT);

		// grnno = new JTextField();
		grnno = new gnRoundTextField(20);

		grnno.setBounds(409, 25, 93, 31);
		panel.add(grnno);
		grnno.setFont(new Font("Calibri", Font.BOLD, 14));
		grnno.setForeground(new Color(0, 0, 51));
		grnno.setBackground(new Color(255, 255, 255));
		grnno.setEditable(false);
		grnno.setToolTipText("Purchase Return Number");
		grnno.setColumns(10);

		JLabel lblGrnDate = new JLabel("PR  Date");
		lblGrnDate.setBounds(506, 7, 89, 16);
		panel.add(lblGrnDate);
		lblGrnDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrnDate.setForeground(Color.BLACK);

		// grndate = new JTextField();
		grndate = new gnRoundTextField(20);
		grndate.setBounds(507, 25, 88, 31);
		panel.add(grndate);
		grndate.setEditable(false);
		grndate.setFont(new Font("Calibri", Font.BOLD, 13));
		grndate.setForeground(new Color(0, 0, 51));
		grndate.setBackground(new Color(255, 255, 255));
		grndate.setToolTipText("Goods Receive Date ");
		grndate.setColumns(10);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(598, 152, 507, 39);
		panel.add(panel_7);
		panel_7.setForeground(new Color(51, 0, 102));
		panel_7.setBackground(Color.CYAN);
		panel_7.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_7.setLayout(null);

		JLabel lblVendorInvoiceNumber = new JLabel("Ref.Grno");
		lblVendorInvoiceNumber.setBounds(12, 17, 70, 16);
		panel_7.add(lblVendorInvoiceNumber);
		lblVendorInvoiceNumber.setFont(new Font("Calibri", Font.BOLD, 14));
		lblVendorInvoiceNumber.setForeground(new Color(51, 0, 102));

		InvoiceNumber = new JTextField();
		InvoiceNumber.setBounds(86, 13, 80, 22);
		panel_7.add(InvoiceNumber);
		InvoiceNumber.setEnabled(false);
		InvoiceNumber.setBackground(Color.WHITE);
		InvoiceNumber.setText("0");
		InvoiceNumber.setToolTipText("Enter Vendor Invoce Number for Tally Account");
		InvoiceNumber.setColumns(10);

		JLabel lblInvoiceDate = new JLabel("Gr. Date");
		lblInvoiceDate.setBounds(167, 16, 56, 16);
		panel_7.add(lblInvoiceDate);
		lblInvoiceDate.setFont(new Font("Calibri", Font.BOLD, 13));
		lblInvoiceDate.setForeground(new Color(51, 0, 102));

		InvoiceDate = new JTextField();
		InvoiceDate.setBounds(220, 13, 80, 22);
		panel_7.add(InvoiceDate);
		InvoiceDate.setEditable(false);
		InvoiceDate.setBackground(Color.CYAN);
		InvoiceDate.setText("0");
		InvoiceDate.setToolTipText("Enter Invoice Date of Vendor Invoice<date Format is [dd.mm.yyyy]");
		InvoiceDate.setColumns(10);

		JLabel lblInvoiceAmount = new JLabel("Gr.Amount");
		lblInvoiceAmount.setBounds(324, 16, 70, 16);
		panel_7.add(lblInvoiceAmount);
		lblInvoiceAmount.setFont(new Font("Calibri", Font.BOLD, 14));
		lblInvoiceAmount.setForeground(new Color(51, 0, 102));

		InvAmt = new JTextField();
		InvAmt.setBounds(402, 13, 103, 22);
		panel_7.add(InvAmt);
		InvAmt.setEditable(false);
		InvAmt.setBackground(Color.CYAN);
		InvAmt.setText("0");
		InvAmt.setToolTipText("Enter Total Vendor Invoice Amount Here");
		InvAmt.setColumns(10);

		approvalpanel = new JPanel();
		approvalpanel.setBounds(12, 93, 159, 133);
		panel.add(approvalpanel);
		approvalpanel.setBackground(new Color(255, 255, 255));
		approvalpanel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				new BevelBorder(BevelBorder.LOWERED, null, null, null, null)));
		approvalpanel.setLayout(null);

		approve = new JCheckBox("Approve PR");
		approve.setBackground(Color.WHITE);
		approve.setSelected(true);
		approve.setForeground(Color.BLACK);
		approve.setFont(new Font("Calibri", Font.BOLD, 13));
		approve.setBounds(8, 0, 113, 25);
		approvalpanel.add(approve);
		approve.addActionListener(apr);

		approvedby = new JTextField();
		approvedby.setBackground(Color.WHITE);
		approvedby.setEnabled(false);
		approvedby.setBounds(8, 46, 138, 22);
		approvalpanel.add(approvedby);
		approvedby.setColumns(10);

		approvedate = new JTextField();
		approvedate.setBackground(Color.WHITE);
		approvedate.setEnabled(false);
		approvedate.setBounds(8, 86, 138, 22);
		approvalpanel.add(approvedate);
		approvedate.setColumns(10);

		JLabel lblNewLabel = new JLabel("Approved By");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel.setBounds(8, 27, 153, 16);
		approvalpanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Approve Date");
		lblNewLabel_1.setBounds(8, 68, 116, 16);
		approvalpanel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 13));

		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setBounds(174, 172, 99, 25);
		panel.add(lblRemark);
		lblRemark.setFont(new Font("Calibri", Font.BOLD, 14));
		lblRemark.setForeground(Color.BLACK);

		remark = new JTextField();
		remark.setFont(new Font("Tahoma", Font.PLAIN, 15));
		remark.setBackground(new Color(255, 255, 255));
		remark.setBounds(174, 196, 934, 30);
		panel.add(remark);
		remark.setColumns(10);

		dnPanel = new JPanel();
		dnPanel.setBounds(905, 0, 338, 131);
		panel.add(dnPanel);
		dnPanel.setBackground(Color.WHITE);
		dnPanel.setBorder(new TitledBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)), "Debit Note Details", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 102)));
		dnPanel.setVisible(false);
		dnPanel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("DN.No");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(12, 26, 77, 16);
		dnPanel.add(lblNewLabel_2);

		dnno = new JTextField();
		dnno.setForeground(new Color(0, 0, 0));
		dnno.setFont(new Font("Calibri", Font.BOLD, 14));
		dnno.setBackground(new Color(255, 255, 255));
		dnno.setEnabled(false);
		dnno.setBounds(93, 23, 91, 22);
		dnPanel.add(dnno);
		dnno.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Amount");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(0, 50, 89, 16);
		dnPanel.add(lblNewLabel_3);

		dnamount = new JTextField();
		dnamount.setForeground(new Color(0, 0, 0));
		dnamount.setFont(new Font("Calibri", Font.BOLD, 14));
		dnamount.setBackground(new Color(255, 255, 255));
		dnamount.setEnabled(false);
		dnamount.setBounds(93, 47, 91, 22);
		dnPanel.add(dnamount);
		dnamount.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Expiry Dt.");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 70, 79, 16);
		dnPanel.add(lblNewLabel_4);

		dnexpdate = new JTextField();
		dnexpdate.setForeground(new Color(0, 0, 0));
		dnexpdate.setFont(new Font("Calibri", Font.BOLD, 14));
		dnexpdate.setBackground(new Color(255, 255, 255));
		dnexpdate.setEnabled(false);
		dnexpdate.setBounds(93, 70, 91, 22);
		dnPanel.add(dnexpdate);
		dnexpdate.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Status");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_5.setBounds(14, 99, 75, 16);
		dnPanel.add(lblNewLabel_5);

		dnstatus = new JTextField();
		dnstatus.setForeground(new Color(0, 0, 0));
		dnstatus.setFont(new Font("Calibri", Font.BOLD, 14));
		dnstatus.setBackground(new Color(255, 255, 255));
		dnstatus.setEnabled(false);
		dnstatus.setBounds(93, 96, 91, 22);
		dnPanel.add(dnstatus);
		dnstatus.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(598, 6, 308, 131);
		panel.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		panel_3.setForeground(Color.GREEN);
		panel_3.setBorder(new CompoundBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Return Details", TitledBorder.LEADING,
						TitledBorder.TOP, null, new Color(0, 0, 0)),
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
						new MatteBorder(2, 2, 2, 2, (Color) new Color(102, 255, 204)))));
		panel_3.setLayout(null);

		TotalAmount = new JTextField();
		TotalAmount.setBackground(new Color(255, 255, 255));
		TotalAmount.setText("0.00");
		TotalAmount.setFont(new Font("Tahoma", Font.BOLD, 13));
		TotalAmount.setBounds(13, 87, 127, 30);
		panel_3.add(TotalAmount);
		TotalAmount.setToolTipText("Total Amount Payable to Supplier");
		TotalAmount.setEditable(false);
		TotalAmount.setColumns(10);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(-16, 0, 17, 25);
		panel_3.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(-16, 1, 17, 159);
		panel_3.add(btnNewButton_2);

		records = new JTextField();
		records.setBackground(new Color(255, 255, 255));
		records.setText("0");
		records.setEditable(false);
		records.setBounds(158, 87, 133, 30);
		panel_3.add(records);
		records.setColumns(10);

		SupplierPayable = new JTextField();
		SupplierPayable.setBackground(new Color(255, 255, 255));
		SupplierPayable.setText("0.00");
		SupplierPayable.setEditable(false);
		SupplierPayable.setBounds(13, 36, 123, 30);
		panel_3.add(SupplierPayable);
		SupplierPayable.setColumns(10);

		Othcharges = new JTextField();
		Othcharges.setBackground(new Color(255, 255, 255));
		Othcharges.setText("0.00");
		Othcharges.setEditable(false);
		Othcharges.setBounds(158, 36, 134, 30);
		panel_3.add(Othcharges);
		Othcharges.setColumns(10);

		JLabel lblNoofRecords = new JLabel("No.of Records");
		lblNoofRecords.setForeground(Color.DARK_GRAY);
		lblNoofRecords.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoofRecords.setHorizontalAlignment(SwingConstants.LEFT);
		lblNoofRecords.setBounds(158, 70, 124, 16);
		panel_3.add(lblNoofRecords);

		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setForeground(Color.DARK_GRAY);
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotalAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotalAmount.setBounds(13, 70, 111, 16);
		panel_3.add(lblTotalAmount);

		JLabel lblOtherCharges = new JLabel("Other charges");
		lblOtherCharges.setForeground(Color.DARK_GRAY);
		lblOtherCharges.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOtherCharges.setHorizontalAlignment(SwingConstants.LEFT);
		lblOtherCharges.setBounds(158, 20, 102, 16);
		panel_3.add(lblOtherCharges);

		JLabel lblSupplierPayment = new JLabel("Debit Amount");
		lblSupplierPayment.setForeground(Color.DARK_GRAY);
		lblSupplierPayment.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSupplierPayment.setHorizontalAlignment(SwingConstants.LEFT);
		lblSupplierPayment.setBounds(12, 22, 112, 16);
		panel_3.add(lblSupplierPayment);
		
				companycode = new JTextField();
				companycode.setBounds(653, 132, 57, 22);
				panel.add(companycode);
				companycode.setEditable(false);
				companycode.setFont(new Font("Tahoma", Font.PLAIN, 13));
				companycode.setForeground(Color.BLACK);
				companycode.setBackground(Color.WHITE);
				companycode.setColumns(10);
				
						Storecode = new JTextField();
						Storecode.setBounds(710, 136, 66, 19);
						panel.add(Storecode);
						Storecode.setFont(new Font("Tahoma", Font.PLAIN, 13));
						Storecode.setForeground(Color.BLACK);
						Storecode.setBackground(Color.WHITE);
						Storecode.setEditable(false);
						Storecode.setColumns(10);
						
								storename = new JTextField();
								storename.setBounds(778, 136, 220, 20);
								panel.add(storename);
								storename.setFont(new Font("Tahoma", Font.PLAIN, 13));
								storename.setForeground(Color.BLACK);
								storename.setBackground(Color.WHITE);
								storename.setEditable(false);
								storename.setColumns(10);
		grnno.addActionListener(prno1);

		sjsp = new JScrollPane();
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(0, 0, 1345, 156);
		// panel_2.add(sjsp);
		ActionListener lsart = new lsarticle();

		JPanel panel_5 = new JPanel();
		panel_5.setForeground(new Color(0, 255, 255));
		panel_5.setBackground(new Color(153, 255, 255));
		panel_5.setBorder(new LineBorder(new Color(204, 204, 204), 4, true));
		panel_5.setBounds(12, 239, 1120, 33);
		frmpurchaseReturn.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		// scanItem = new JTextField();
		scanItem = new gnRoundTextField(20);
		scanItem.setForeground(new Color(51, 51, 102));
		scanItem.setToolTipText("Enter Item code if you know");
		scanItem.setBounds(133, 0, 245, 33);
		panel_5.add(scanItem);
		scanItem.setColumns(10);

		JLabel lblScanArticleHere = new JLabel("Enter Article  ");
		lblScanArticleHere.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScanArticleHere.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblScanArticleHere.setForeground(new Color(199, 21, 133));
		lblScanArticleHere.setBounds(12, 0, 109, 33);
		panel_5.add(lblScanArticleHere);
		ActionListener grnsave = new lsBtn();
		ActionListener btnprn = new lsBtn();
		// scanName = new JTextField();
		scanName = new gnRoundTextField(20);
		scanName.setVisible(false);
		scanName.setToolTipText("Enter Name or start latters to search Items");
		scanName.setBounds(390, 0, 229, 33);
		panel_5.add(scanName);
		scanName.setColumns(10);

		btnGetBatch = new JButton("Get Batch Detail");
		btnGetBatch.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApBatch1.png"));
		btnGetBatch.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApBatch.png"));
		btnGetBatch.setBackground(new Color(51, 255, 255));
		btnGetBatch.setFont(new Font("Cambria", Font.BOLD, 13));
		btnGetBatch.setForeground(new Color(0, 0, 153));
		btnGetBatch.setMnemonic('B');
		btnGetBatch.setBounds(621, 2, 205, 28);
		panel_5.add(btnGetBatch);

		btnEdit = new JButton("Edit Pur.Return");
		btnEdit.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApEdit.png"));
		btnEdit.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApEdit1.png"));
		btnEdit.setMnemonic('E');
		btnEdit.setBackground(new Color(51, 255, 255));
		btnEdit.setFont(new Font("Cambria", Font.BOLD, 13));
		btnEdit.setForeground(new Color(0, 0, 153));
		btnEdit.setBounds(826, 2, 136, 28);
		panel_5.add(btnEdit);
		btnGetBatch.addActionListener(btnprn);
		btnEdit.addActionListener(grnsave);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.BLUE);
		panel_6.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.CYAN, Color.RED));
		panel_6.setBounds(12, 31, 1345, -8);
		frmpurchaseReturn.getContentPane().add(panel_6);
		panel_6.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(51, 255, 204), 5, true));
		panel_2.setBounds(12, 686, 1345, 20);
		frmpurchaseReturn.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		Msg = new JLabel("....");
		Msg.setBounds(42, 0, 838, 16);
		panel_2.add(Msg);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnSave.setBounds(1168, 245, 98, 27);
		frmpurchaseReturn.getContentPane().add(btnSave);
		btnSave.setSelectedIcon(new ImageIcon(purchaseReturn.class.getResource("/RetailProduct/btnApsave1.png")));
		btnSave.setIcon(new ImageIcon(purchaseReturn.class.getResource("/RetailProduct/btnApsave.png")));
		btnSave.setMnemonic('S');
		btnSave.setForeground(UIManager.getColor("Button.foreground"));
		btnSave.setBackground(UIManager.getColor("Button.background"));

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnUpdate.setBounds(1266, 573, 97, 27);
		frmpurchaseReturn.getContentPane().add(btnUpdate);
		btnUpdate.setSelectedIcon(new ImageIcon(purchaseReturn.class.getResource("/RetailProduct/btnApUpdate1.png")));
		btnUpdate.setIcon(new ImageIcon(purchaseReturn.class.getResource("/RetailProduct/btnApUpdate.png")));
		btnUpdate.setMnemonic('U');

		btnAcEntry = new JButton("Account Entry");
		btnAcEntry.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnAcEntry.setBounds(1149, 573, 117, 27);
		frmpurchaseReturn.getContentPane().add(btnAcEntry);
		btnAcEntry.setSelectedIcon(new ImageIcon(purchaseReturn.class.getResource("/RetailProduct/btnApACEntry1.png")));
		btnAcEntry.setIcon(new ImageIcon(purchaseReturn.class.getResource("/RetailProduct/btnApACEntry.png")));
		btnAcEntry.setMnemonic('A');

		btnPrint = new JButton("Print");
		btnPrint.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnPrint.setBounds(1051, 573, 97, 27);
		frmpurchaseReturn.getContentPane().add(btnPrint);
		btnPrint.setIcon(new ImageIcon(purchaseReturn.class.getResource("/RetailProduct/btnApPrint.png")));
		btnPrint.setSelectedIcon(new ImageIcon(purchaseReturn.class.getResource("/RetailProduct/btnApPrint1.png")));
		btnPrint.setMnemonic('P');
		btnPrint.setForeground(Color.DARK_GRAY);
		btnPrint.setBackground(Color.CYAN);

		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnClose.setBounds(1278, 245, 79, 27);
		frmpurchaseReturn.getContentPane().add(btnClose);
		btnClose.setIcon(new ImageIcon(purchaseReturn.class.getResource("/RetailProduct/btnApClose.png")));
		btnClose.setSelectedIcon(new ImageIcon(purchaseReturn.class.getResource("/RetailProduct/btnApClose1.png")));
		btnClose.setBackground(Color.CYAN);
		btnClose.setForeground(Color.DARK_GRAY);
		btnClose.setMnemonic('C');
		
				jsp = new JScrollPane();
				jsp.setBounds(12, 276, 1351, 295);
				frmpurchaseReturn.getContentPane().add(jsp);
				jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
				jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				
						JViewport prt = new JViewport();
						prt.setBackground(Color.WHITE);
						prt.add(table, Col);
						prt.setVisible(true);
						jsp.setViewport(prt);
		btnClose.addActionListener(btnprn);
		btnPrint.addActionListener(btnprn);
		btnAcEntry.addActionListener(grnsave);
		btnUpdate.addActionListener(btnprn);
		btnSave.addActionListener(grnsave);

		scanItem.addActionListener(lsart);
		ActionListener ls7777 = new lsnritemName();
		scanName.addActionListener(ls7777);
 
		decorateComp();
	}

	/// Start Coding Here ///
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

	public void decorateComp() throws Throwable {

		new gnApp().setFrameTitel(frmpurchaseReturn);
		frmpurchaseReturn.setUndecorated(true);
		scanName.setVisible(false);

		switch(EnableAccountingModule)
		{
		    case "Y" :
			btnAcEntry.setVisible(true);
 			break;
		    case "N" :	
 			btnAcEntry.setVisible(false);
 			break;
 		}
		
		chekcFreezeYear();
		this.checkInternet();
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

			int typecode = 2;
			new gnDecorate().SetSeqHdrButton(btnSave, typecode);
			new gnDecorate().SetSeqHdrButton(btnUpdate, typecode);
			new gnDecorate().SetSeqHdrButton(btnAcEntry, typecode);
			new gnDecorate().SetSeqHdrButton(btnPrint, typecode);
			new gnDecorate().SetSeqHdrButton(btnClose, typecode);

			vfinyear = new gnFinYear().getReportingFinYear();
 			new gnField().moveDown(table);
			new gnField().closeform(btnClose, frmpurchaseReturn);
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			Msg.setText(" Select  Correct Location For Purchase Return.   Incorrect Stock Location will impact inventory Mismatch");
			String vpara = "24";
			String vpara1 = "25";
			String vimportAllow = new getConfigurationSetting().getSpecificConfiguration(vpara);
			String vsezPurchaseAllow = new getConfigurationSetting().getSpecificConfiguration(vpara1);
			switch (vimportAllow) {
			case "N":
				importPurchase.setVisible(false);
				break;
			}

			switch (vsezPurchaseAllow) {
			case "N":
				sez.setVisible(false);
				break;
			}
			companycode.setText(new gnConfig().getCompanyCode());
			Storecode.setText(new gnConfig().getStoreID());
			storename.setText(new gnConfig().getStorename(vname));

			companycode.setVisible(false);
			Storecode.setVisible(false);
			storename.setVisible(false);
			
			
			String vname = Storecode.getText();
			grndate.setText(new gnConfig().getDaybeginDate());
 			new gnApp().ApprovalDisable(approve);
			grnno.setEditable(true);
			grnno.setEnabled(true);
			btnSave.setEnabled(true);
			btnUpdate.setEnabled(false);
			btnPrint.setEnabled(true);

			String vtype = "PR";
			String vallowDate = new gnDate().checkBackDateTrAllow(vtype, grndate.getText());
			switch (vallowDate) {
			case "N":
				btnEdit.setVisible(false);
				grndate.setBackground(Color.RED);
				grndate.setForeground(Color.WHITE);
				new General().msg("Back Date For Transaction is not Allow..");
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				grndate.setText("?");
				scanItem.setVisible(false);
				scanName.setVisible(false);
				// searchbrand.setVisible(false);
				VendorName.setEditable(false);
				btnSave.setVisible(false);
				break;
			}
			switch (vname) {
			case "0":
				System.exit(0);
			}
			break;
		}
	}

	private void chekcFreezeYear() {
		switch (isFinyearFreeze) {
		case "Y":
			btnEdit.setVisible(false);
			btnSave.setVisible(false);
			btnUpdate.setVisible(false);
			// btnAcEntry.setVisible(false);
			btnPrint.setVisible(false);
			new General().msg("Accounting Year is Freezeed..You Can View Data Only..");
			break;
		}
	}

	class approve implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			try {
				new exceptionLogger().writeToFile("Approval Document Listener Process");
				new gnApp().approveDocument(approve, approvedby, approvedate);
				new exceptionLogger().writeToFile("Status Changes Sucess");

			} catch (Throwable e1) {
				e1.printStackTrace();
				try {
					new exceptionLogger().writeToFile("Approval Document Listener Process");
					new exceptionLogger().writeToFile(e1.getLocalizedMessage());

				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
					try {
						new exceptionLogger().writeToFile(e2.getLocalizedMessage());
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}

				}

			}
		}
	}

	/// Supplier

	class lscust implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			if (vallow == "N") {
				frmpurchaseReturn.dispose();
			}

			if (i == 1001) {
				String vvendorcode = VendorCode.getText();

				try {
					if (vvendorcode.length() == 0) {
						new General().msg("Enter Vendor Code  OR Search by Name");
						return;
					} else {
						new gnSupplier().setScanSupplier(VendorCode, VendorName, vvendorcode);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					creditDays.setText(new gnSupplier().rcrdays);
				}
			}
		}
	}

	class prno implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vtype = "PR";
			if (grnno.getText().length() == 0) {
				try {
					new gnGrn().get_Grno(vtype);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					try {
						//vcomp = new gnConfig().getCompanyCode();
						vstorecode = vstore  ; // new gnConfig().getStoreID();
						grnno.setText(new gnGrn().rgrnno);
						grndate.setText(new gnGrn().rgrndate);
						String vprno = new gnGrn().rgrnno;
						String vdocdate = new gnConfig().date_ConverttoDBforamt(grndate.getText());
						String SQL = "Call PR_FetchPR(" + vprno + "  ,   '" + vdocdate + "',  " + vcomp + " , "
								+ vstorecode + " )";
						String vname = "PR";
						ShowForUpdate(SQL, vname, PoCol);
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	public void ShowForUpdate(String SQL, String type, String[] Colnames) throws Throwable {
		CheckBatchArticle();
		btnSave.setEnabled(false);
		btnPrint.setEnabled(false);
		btnUpdate.setEnabled(true);
		rs = this.getSPResult(SQL);
		((DefaultTableModel) model).setColumnIdentifiers(Colnames);
		new gnTable().RemoveTableRows(model);
		table.setModel(model);
		int i = 0;
		while (rs.next()) {
			model.addRow(new Object[] { "", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
					rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
					rs.getString(20) });
			VendorCode.setText(rs.getString(21));
			VendorName.setText(rs.getString(22));
			creditDays.setText(rs.getString(23));
			Othcharges.setText(rs.getString(29));
			table.setGridColor(Color.gray);
			String vapprstatus = rs.getString(32);
			/// Approval setting
			switch (vapprstatus) {
			case "Y":
				approve.setSelected(true);
				approvedby.setText(rs.getString(33));
				approvedate.setText(rs.getString(34));
				btnUpdate.setEnabled(false);
				btnSave.setEnabled(false);
				btnPrint.setEnabled(true);
				approve.setBackground(Color.GREEN);
				approve.setEnabled(false);
				table.setEnabled(false);
				table.setGridColor(Color.GREEN);
				showDNData();
				scanItem.setText(null);
				scanItem.setEditable(false);
				scanName.setEnabled(false);
				// searchbrand.setEnabled(false);
				break;
			case "N":
				btnSave.setEnabled(false);
				btnUpdate.setEnabled(true);
				approve.setSelected(false);
				approvedby.setText(rs.getString(33));
				approvedate.setText(rs.getString(34));
				table.setEnabled(true);
				break;
			}
			table.setModel(model);
			TableCellRenderer ss = table.getColumnModel().getColumn(0).getCellRenderer();
			String vmsname = "Location";
			String vverticle = new gnHierarchy().getVerticleCode();
			String vsearch = "%%";
			String SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticle + " , '" + vsearch + ")";
			table.getColumnModel().getColumn(19).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL1)));
		}
		resetFigures();
		new gnTable().setTablewidth(table, 1, 70);
		new gnTable().setTablewidth(table, 0, 40);
		new gnTable().setTablewidth(table, 2, 300);
		new gnTable().setTablewidth(table, 5, 150);
		new gnTable().setTablewidth(table, 6, 150);
		new gnTable().setTablewidth(table, 7, 150);
		new gnTable().setTablewidth(table, 8, 150);
		new gnTable().setTablewidth(table, 14, 125);
		new gnTable().setTablewidth(table, 15, 125);
		new gnTable().setTablewidth(table, 16, 125);
		new gnTable().setTablewidth(table, 17, 250);
		new gnTable().setTablewidth(table, 3, 50);
		new gnTable().setTablewidth(table, 19, 100);
		new gnTable().setTablewidth(table, 20, 100);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.DARK_GRAY);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
		rs.close();
	}// Show for Update

	class lsnrCustName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (vallow == "N") {
				frmpurchaseReturn.dispose();
				new General().msg("Complete Day Open First...");
			}
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			String sname = VendorName.getText().trim();
			sname = "%" + sname + "%";
			try {
				String vtype = "Vendor";
				JTextField txt = new JTextField();
				new gnSupplier().rvendorcode = "0";
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
				creditDays.setText(new gnSupplier().rcrdays);
				scanItem.grabFocus();
				try {
					applyRevchrg();
					if (EditMode == "Y") {
						StartdocEditProcess();
					}
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	private void StartdocEditProcess() throws Throwable {
		String vdoctype = "PR";
		String vparty = VendorCode.getText();
		new gnGrn().get_PrnoforVendor(vdoctype, vparty);
		grnno.setText(new gnGrn().rgrnno);
		grndate.setText(new gnGrn().rgrndate);
		new gnGrn().rgrnno = null;
		String vdocno = grnno.getText();
		String vdocdate = new gnConfig().date_ConverttoDBforamt(grndate.getText());
		if (vdocno.length() == 0) {
			refresh();
		}
		if (vdocno.length() > 0) {
			String SQL = "Call PR_FetchPR(" + vdocno + "  ,  '" + vdocdate + "' ,   " + vcomp + " , " + vstore + " )";
			String vname = "PR";
			// jul2020
			new gnTable().RemoveTableRows(model);
			showTable(SQL, vname, PoCol);
			showDNData();
			scanItem.setVisible(true);
			scanName.setVisible(true);
		}
	}

	public void showPR(String vvendor) throws Throwable {
		chekcFreezeYear();
		scanItem.setVisible(true);
		scanName.setVisible(true);

		btnEdit.setVisible(true);
		vallow = "Y";
		EditMode = "Y";
		btnUpdate.setEnabled(false);
		btnEdit.setBackground(Color.BLUE);
		btnEdit.setForeground(Color.WHITE);

		try {
			new gnSupplier().setScanSupplier(VendorCode, VendorName, vvendor);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			VendorCode.setText(new gnSupplier().rvendorcode);
			VendorName.setText(new gnSupplier().rvendorName);
			// Mobile.setText(new gnSupplier().rPhone);
			email.setText(new gnSupplier().rEmail);
			creditDays.setText(new gnSupplier().rcrdays);
			// statecode.setText(new gnSupplier().rstatecode);
			// statename.setText(new gnSupplier().rstatename);
			grnno.setText(new gnGrn().rgrnno);
			grndate.setText(new gnGrn().rgrndate);
		}

		String vdoctype = "PR";
		String vparty = vvendor;
		// TotalAmount.setText(new gnAdvance().ramount);
		new gnGrn().rgrnno = null;

		String vdocno = grnno.getText();
		String vdocdate = new gnConfig().date_ConverttoDBforamt(grndate.getText());

		if (vdocno.length() == 0) {
			refresh();
		}
		if (vdocno.length() > 0) {
			String SQL = "Call PR_FetchPR(" + vdocno + "  ,  '" + vdocdate + "' ,   " + vcomp + " , " + vstore + " )";
			String vname = "PR";
			showTable(SQL, vname, PoCol);
			showDNData();
			scanItem.setVisible(true);
			scanName.setVisible(true);
		}
	}

	private void applyRevchrg() throws Throwable {
		//
		regdlr.setText(new gnGST().isSupplierGSTRegister(VendorCode.getText()));
		String vvregdlr = regdlr.getText();
		String vvmygststatus = new gnGST().ismyComanyGSTRegister();
		chrevchrg.setSelected(false);
		chrevchrg.setEnabled(true);
		switch (vvregdlr) {
		case "N":
			switch (vvmygststatus) {
			case "Y":
				chrevchrg.setSelected(true);
				chrevchrg.setEnabled(false);
				new General().msg("Please Check - Reverse Charg is Applicable For this Supplier");
				scanItem.grabFocus();
				scanItem.addNotify();
			}
			break;
		}
		//

	}

	class lsarticle implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String SQL = " ";
			int i = e.getID(); // Field id
			if (i == 1001) {
				String action = checkVendorEntry();
				try {
					String vcode = scanItem.getText();
					String vname = "Article";
					//String vcomp = companycode.getText();
					//String vstore = Storecode.getText();
					String vfinyear = new gnFinYear().getReportingFinYear();
					String vtype = "PR";
					String vverticlecode = " ";
					if (vcode.length() == 0) {
						new General().msg("Enter Article code OR Search By Name");
						return;
					} else {
						String result = checkArticleExist(vcode);
						if (result == "Sucess")
							vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
									new gnPublicVariable().vstore);
						SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', " + vcomp
								+ " , " + vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
						tableEntry = "N";
						showTable(SQL, vname, PoCol);
						if (tableEntry == "N") {
							shownamesearch();
						}
						tableEntry = "N";
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class lsnritemName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
		}
	}

	private void shownamesearch() {
		String sname = scanItem.getText().trim();
		String vtrantype = "ALL";
		sname = "%" + sname + "%";
		String vType = "Article";
		String vtype = "ALL";
		String vverticlecode = " ";
		try {
			new gnAdmin().rArticle = "0";
			new gnAdmin().Search(vType, sname, varticle, vtrantype);
			vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
					new gnPublicVariable().vstore);
		} catch (Throwable e1) {
			e1.printStackTrace();
		} finally {
			String vname = "Article";
			//String vcomp = companycode.getText();
			//String vstore = Storecode.getText();
			// String SQL = "Call PURRET_get_scanArticle("+varticle+",
			// "+vcomp+", "+vstore+")" ;
			varticle = new gnAdmin().rArticle;
			String vtyp = "PR";
			String SQL = "Call Transaction_getScanArticleDetails( '" + vtyp + "'  , " + varticle + ", " + vcomp + " , "
					+ vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
			String result = checkArticleExist(varticle);
			if (result == "Sucess") {
				try {
					showTable(SQL, vname, PoCol);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}

	}

	private void checkBatchItems() throws ClassNotFoundException, SQLException {
		int row = table.getSelectedRow();
		selectedrow = row;
		String varticle = table.getValueAt(row, 1).toString();
		String vbatchArticle = table.getValueAt(row, 18).toString();
		String vloc = table.getValueAt(row, 19).toString();
		try {
			getBatchArticles(varticle, vbatchArticle, vloc);
			// new gnGetBatch().getBatchDetail(varticle, vbatchArticle, vloc );
		} catch (Throwable e1) {
			e1.printStackTrace();
		} finally {
		}
	}

	private void checkBatchforNonBatchItems(String varticle, String vbatchcontrol, String vloc) throws Throwable {
		// "1Type" ,2"Article_code" , 3"Name" , 4"Qty" , 5"UOM" , 6"cost" ,
		// "7CostValue " , 8 "sales Price" , 9"MRP" , 10"Trans.Chrg" ,11
		// "Manuf.Chrg" ,
		// 12"Packing Chrgs" , 13"Landing Cost", 14"Tax%" ,
		// 15"Bal Qty", 16"Manuf.Date" , 17 "Expiry date", 18 "Batch No" ,
		// 19"Batch_Control" , 20"Location" , 21 "EanCode"

		String vcost = table.getValueAt(selectedrow, 6).toString();
		String vsp = table.getValueAt(selectedrow, 7).toString();
		String vmrp = table.getValueAt(selectedrow, 8).toString();
		String vaction = new gnBatch().IsBatchAvailableForIsBatchAvailableforMrpandSP(varticle, vmrp, vsp);
		switch (vaction) {
		case "Y":
			String vaction1 = new gnBatch().IsMultiBatchForMRP_SalesPrice(varticle, vmrp, vsp, vcost);
			// vaction1 = "Y" ;
			switch (vaction1) {
			case "Y":
				try {
					String vtype = "ALLPluswithcost";
					new gnGetBatch().getBatchDetailForNonBathItems(vtype, varticle, vbatchcontrol, vloc);
				} catch (Exception e) {
					new General().msg(e.getLocalizedMessage());
				} finally {
					if (Double.parseDouble(new gnGetBatch().salesPrice) > 0) {
						table.setValueAt(new gnGetBatch().batchno, selectedrow, 17);
						table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 16);
						table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 7);
						table.setValueAt(new gnGetBatch().mrp, selectedrow, 8);
						table.setValueAt(new gnGetBatch().cost, selectedrow, 5);
						table.setValueAt(new gnGetBatch().bal_qty, selectedrow, 14);

						new gnGetBatch().resetValues();
						QtychangeImapct(varticle, selectedrow);
					}
				}
				break;
			case "N":
				// String vbatch = new gnBatch().getLowestBatch(varticle, vmrp,
				// vsp, vcost) ;
				// table.setValueAt(vbatch, selectedrow , 17) ;
				new General().msg("No Stock Available For Purchase Return..");
				model.removeRow(selectedrow);
				break;
			} // Iswitch
			break;
		case "N":
			// String vbatchno = new gnBatch().getNewBatch() ;
			// table.setValueAt(vbatchno, selectedrow , 17) ;
			new General().msg("No Stock Available For Purchase Return..");
			model.removeRow(selectedrow);
			break;

		}// Outer Switch
	}

	private void getBatchArticles(String varticle, String vbatchArticle, String vloc) throws Throwable {
		// "1Type" ,2"Article_code" , 3"Name" , 4"Qty" , 5"UOM" , 6"cost" ,
		// "7CostValue " , 8 "sales Price" , 9"MRP" , 10"Trans.Chrg" ,11
		// "Manuf.Chrg" ,
		// 12"Packing Chrgs" , 13"Landing Cost", 14"Tax%" ,
		// 15"Bal Qty", 16"Manuf.Date" , 17 "Expiry date", 18 "Batch No" ,
		// 19"Batch_Control" , 20"Location" , 21 "EanCode"

		String vstorecode = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		String vpara811 = "811";
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
				vstorecode);
		switch (vmaintainbatchforNonBatchItem) {
		case "N":
			try {
				new gnGetBatch().getBatchDetail(varticle, vbatchArticle, vloc);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				table.setValueAt(new gnGetBatch().cost, selectedrow, 6);
				table.setValueAt(new gnGetBatch().mrp, selectedrow, 8);
				table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 7);
				table.setValueAt(new gnGetBatch().manuf_date, selectedrow, 15);
				table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 16);
				table.setValueAt(new gnGetBatch().batchno, selectedrow, 17);
				table.setValueAt(new gnGetBatch().bal_qty, selectedrow, 14);
				new gnGetBatch().resetValues();
				try {
					QtychangeImapct(varticle, selectedrow);
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "Y":
			checkBatchforNonBatchItems(varticle, vbatchArticle, vloc);
		}
	}

	class lsBtn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);

			if (value == "Edit Pur.Return") {
				EditMode = "Y";
				btnEdit.setBackground(Color.BLUE);
				btnEdit.setForeground(Color.WHITE);
				scanItem.setVisible(false);
				scanName.setVisible(false);
				lsnrCustName abc = new lsnrCustName();
				abc.actionPerformed(e);
			}

			if (value == "Account Entry") {

				String vtype = "PR";
				String vdocno = grnno.getText();
				String vdocdate = grndate.getText();
				try {
					new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Get Batch Detail") {
				try {
					checkBatchItems();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Update") {
				try {
					callUpdateEvent();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Close") {
				frmpurchaseReturn.dispose();
			}

			if (value == "Print") {
				// new General().msg("Printer is not connected...");
				btnSave.setEnabled(true);
				btnPrint.setEnabled(false);
				scanItem.setText(null);
				scanItem.setEditable(true);
				scanName.setEnabled(true);
				// searchbrand.setEnabled(true);
				dnPanel.setVisible(false);
				try {

					callDebitnotPrint();
					// callprint();
				} catch (Throwable e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				new gnTable().RemoveTableRows(model);
				try {
					refresh();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
			if (value == "Upload") {
				try {
					callUpload();
				} catch (Exception e1) {
					new General().msg(e1.getMessage());
					e1.printStackTrace();
				}
			}

			if (value == "Save") {
				try {
					String action = CheckBatchArticle();
					if (action == "Sucess") {
						String action1 = CheckCost();
						if (action1 == "Sucess") {
							callSaveEvent();
							btnPrint.setEnabled(true);
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void showTable(String SQL, String type, String[] Colnames) throws Throwable {
		CheckBatchArticle();
		rs = this.getSPResult(SQL);
		((DefaultTableModel) model).setColumnIdentifiers(Colnames);
		table.setModel(model);
		int i = 0;
		while (rs.next()) {
			model.insertRow(0,
					new Object[] { "DEL", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
							rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
							"0" });
			table.setModel(model);
			// selectedrow = table.getRowCount()-1;
			selectedrow = 0;
			TableCellRenderer ss = table.getColumnModel().getColumn(0).getCellRenderer();
			TableColumn cell2 = table.getColumnModel().getColumn(2);
			String vmsname = "Location";
			String vverticle = new gnHierarchy().getVerticleCode();
			String vsearch = "%%";
			String SQL1 = "call master_getMasterData('" + vmsname + "' , " + vverticle + "  , '" + vsearch + "')";
			table.getColumnModel().getColumn(19).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL1)));

			String vvarticle = rs.getString(1);
			String vbatchArticle = rs.getString(18);
			String vloc = "SL";
			getBatchArticles(vvarticle, vbatchArticle, vloc);
			new gnTable().setTableBasics(table);
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			scanItem.setText(null);
			scanItem.grabFocus();
			tableEntry = "Y";
		}
		removeRow(model, table);
		resetFigures();
		new gnTable().setTablewidth(table, 1, 70);
		new gnTable().setTablewidth(table, 0, 40);
		new gnTable().setTablewidth(table, 2, 300);
		new gnTable().setTablewidth(table, 5, 150);
		new gnTable().setTablewidth(table, 6, 150);
		new gnTable().setTablewidth(table, 7, 150);
		new gnTable().setTablewidth(table, 8, 150);
		new gnTable().setTablewidth(table, 14, 125);
		new gnTable().setTablewidth(table, 15, 125);
		new gnTable().setTablewidth(table, 16, 125);
		new gnTable().setTablewidth(table, 17, 250);
		new gnTable().setTablewidth(table, 3, 50);
		new gnTable().setTablewidth(table, 19, 100);
		new gnTable().setTablewidth(table, 20, 100);
		table.setEnabled(true);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.gray);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
		selectRow();

	}// End Show Table

	private void selectRow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 1);
				try {
					// getValuesTodisplay(row);
				} catch (Throwable e1) {
					e1.printStackTrace();
					System.err.println(e1.getMessage());
				}
				try {
					// gnProductDetails window = new gnProductDetails();
					// window.ProductInfoframe.setVisible(true);
					// window.setValues();
				} catch (Throwable e1) {
					System.err.println(e1.getMessage());
				} finally {
					try {
						// new General().msg("Now Setting Values to My Table");
						// setValuesTotable(row);
					} catch (Throwable e1) {
						e1.printStackTrace();
						System.err.println(e1.getMessage());
					}
				}
			}
		});
	}

	private void getValuesTodisplay(int row) throws Throwable {
		new gnProductDetails().varticlecode = table.getValueAt(row, 1).toString();
		new gnProductDetails().varticlename = table.getValueAt(row, 2).toString();
		new gnProductDetails().vqty = table.getValueAt(row, 3).toString();
		new gnProductDetails().vuom = table.getValueAt(row, 4).toString();
		new gnProductDetails().vrate = table.getValueAt(row, 5).toString();
		new gnProductDetails().vnetamt = table.getValueAt(row, 6).toString();
		new gnProductDetails().vgrossamt = table.getValueAt(row, 6).toString();
		new gnProductDetails().vtransportamt = table.getValueAt(row, 9).toString();
		new gnProductDetails().vtransportper = "0.00";
		new gnProductDetails().vdiscper = "0.00";
		new gnProductDetails().vdiscamt = "0.00";
		new gnProductDetails().vtaxcode = table.getValueAt(row, 13).toString();
		new gnProductDetails().vcurstock = table.getValueAt(row, 14).toString();
		new gnProductDetails().vexpdate = table.getValueAt(row, 16).toString();
		new gnProductDetails().vbatchno = table.getValueAt(row, 17).toString();
		new gnProductDetails().vbatchitem = table.getValueAt(row, 18).toString();
		new gnProductDetails().vinnerQty = new gnProduct().getInnerQty(table.getValueAt(row, 1).toString());
		new gnProductDetails().vdiscamt = "0.00";
		new gnProductDetails().vdiscper = "0.00";
		new gnProductDetails().votherchrgamt = "0.00";
		new gnProductDetails().votherchrgper = "0.00";
		new gnProductDetails().vlocation = table.getValueAt(row, 19).toString();
		new gnProductDetails().row = row;
	}

	public void setValuesTotable(int row) throws Throwable {
		// new General().msg("Start Setting Now");
		table.setValueAt(new gnProductDetails().vqty, row, 3);
		table.setValueAt(new gnProductDetails().vrate, row, 5);
		table.setValueAt(new gnProductDetails().vtransportamt, row, 9);
		table.setValueAt(new gnProductDetails().vexpdate, row, 16);
		table.setValueAt(new gnProductDetails().vbatchno, row, 17);
		String value = (String) table.getValueAt(row, 1);
		QtychangeImapct(value, row);
		scanItem.grabFocus();
	}

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			e.notifyAll();
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 1);
			try {
				QtychangeImapct(value, row);
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;

	public String QtychangeImapct(String value, int i) throws Throwable {
		String vpara811 = "811";
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			double retqty = Double.parseDouble(table.getValueAt(i, 3).toString());
			double balqty = Double.parseDouble(table.getValueAt(i, 14).toString());
			if (retqty > balqty) {
				new General().msg("Please Check Return Qty is More then Bal Stock...");
				table.setValueAt("0", selectedrow, 3);
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
			}
		}

		String curqty1 = (String) table.getValueAt(i, 3).toString();
		String curcost = table.getValueAt(i, 5).toString();
		// Double curqty = 0.00 ;
		Double vcost = 0.00;
		Double vqty = 0.00;
		Double vmrp = 0.00;
		Double vsp = 0.00;

		if (curqty1.length() == 0) {
			table.setValueAt(1, i, 3);
		}

		if (curcost.length() == 0) {
			table.setValueAt(0, i, 5);
		}

		try {
			// curqty = Double.parseDouble(curqty1);
			vqty = Double.parseDouble(table.getValueAt(i, 3).toString());
		} catch (Exception e) {
			new General().msg("Enter Correct Qty");
			table.setValueAt(1, i, 3);
		}

		try {
			vmrp = Double.parseDouble(table.getValueAt(i, 8).toString());
		} catch (Exception e) {
			new General().msg("Enter Correct MRP");
			table.setValueAt(0, i, 8);
		}

		try {
			vsp = Double.parseDouble(table.getValueAt(i, 7).toString());
		} catch (Exception e) {
			new General().msg("Enter Correct Sales Price");
			table.setValueAt(0, i, 7);
		}

		try {
			vcost = Double.parseDouble(table.getValueAt(i, 5).toString());
		} catch (Exception e) {
			new General().msg("Enter Correct cost ");
			table.setValueAt(0, i, 5);
		}

		if (vqty == 0.00) {
			table.setEditingRow(i);
			table.setGridColor(Color.YELLOW);
			table.setBackground(Color.red);
		}

		if (vqty.isNaN()) {
			table.setValueAt(0, i, 3);
		}

		// vcost = Double.parseDouble( table.getValueAt(i,5).toString() );
		Double vtrans = Double.parseDouble(table.getValueAt(i, 9).toString());
		Double vmanuf = Double.parseDouble(table.getValueAt(i, 10).toString());
		Double vpacking = Double.parseDouble(table.getValueAt(i, 11).toString());
		Double vcostValue = vqty * vcost;
		table.setValueAt(vcostValue, i, 6);
		double vcharges = vtrans + vmanuf + vpacking;
		Othcharges.setText(Double.toString(vcharges));
		Double vlandingcost = vcostValue + vcharges;
		table.setValueAt(vlandingcost, i, 12);
		SupplierPayable.setText(Double.toString(new gnTable().getTotal(table, 6)));
		Double othchg1 = new gnTable().getTotal(table, 9);
		Double othchg2 = new gnTable().getTotal(table, 10);
		Double othchg3 = new gnTable().getTotal(table, 11);
		Double voth = othchg1 + othchg2 + othchg3;
		Othcharges.setText(Double.toString(voth));
		TotalAmount.setText(Double.toString(new gnTable().getTotal(table, 12)));
		// checkEan(i) ;
		// Checking Margin
		// new gnConfig().checkMargin((table.getValueAt(i,0).toString()),
		// (table.getValueAt(i,4).toString()) ,
		// (table.getValueAt(i,6).toString()) ,
		// (table.getValueAt(i,7).toString()));
		String action = "Sucess";
		table.addNotify();
		return action;
	}

	private void checkEan(int i) throws SQLException, ClassNotFoundException {
		String veancode = (String) table.getValueAt(i, 20);
		String varticlecode = (String) table.getValueAt(i, 1);
		if (veancode != "0") {
			String result = new gnApp().checkEancode(varticlecode, veancode);
			if (result == "Fail") {
				table.setValueAt(0, i, 20);
			}
		}
	}

	public void removeRow(DefaultTableModel model, JTable table) {
		TableColumn Del = table.getColumnModel().getColumn(0);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setText("DEL");
		chkbox.setVisible(true);
		chkbox.setOpaque(true);
		chkbox.setToolTipText("Del Row ");
		chkbox.setSelected(true);
		Del.setCellEditor(new DefaultCellEditor(chkbox));
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
					}
					return;
				}
			}
		});
	}

	public void resetFigures() {
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		records.setText(RecordCount1);
		SupplierPayable.setText(Double.toString(new gnTable().getTotal(table, 6)));
		TotalAmount.setText(Double.toString(new gnTable().getTotal(table, 10)));
		TotalAmount.setText(Double.toString(new gnTable().getTotal(table, 12)));
	}

	public String checkVendorEntry() {
		String vcode = VendorCode.getText();
		String action = "Fail";
		if (vcode.length() == 0) {
			new General().msg("Select Vendor code first for Making GRN");
			VendorCode.grabFocus();
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
			Colname = table.getValueAt(i, 0).toString();
			if (Colname.equalsIgnoreCase(value)) {
				new General().msg("Article is Already Present ..in Table ");
				Action = "Fail";
			}
		}
		return Action;
	}

	public String CheckCost() {
		String Action = "Sucess";
		int rw = table.getRowCount();
		Double vcost = 0.00;
		Double vmrp = 0.00;
		Double vsp = 0.00;
		String varticle = " ";

		Action = new gnTable().isAmountnegative(TotalAmount.getText());

		for (int k = 0; k < rw; k++) {
			Double vqty = Double.parseDouble(table.getValueAt(k, 3).toString());
			vcost = Double.parseDouble(table.getValueAt(k, 5).toString());
			vmrp = Double.parseDouble(table.getValueAt(k, 8).toString());
			vsp = Double.parseDouble(table.getValueAt(k, 7).toString());
			varticle = table.getValueAt(k, 1).toString();

			if (vqty <= 0.00) {
				new General().msg("Enter Correct Qty   for Item Code " + varticle);
				Action = "Fail";
			}

			if (vcost <= 0.00) {
				new General().msg("Enter correct Cost   for Item Code " + varticle);
				Action = "Fail";
			}

			if (vmrp <= 0.00) {
				new General().msg("Enter Correct MRP   for Item Code " + varticle);
				Action = "Fail";
			}

			if (vsp == 0.00) {
				new General().msg("Enter correct Sales Price   for Item Code " + varticle);
				Action = "Fail";
			}

		}
		return Action;
	}// cost check End

	public String CheckBatchArticle() {
		String Action = "Sucess";

		Double vamt = Double.parseDouble(TotalAmount.getText());
		String vbatch = " ";
		String vExp = "";
		String vbatchno = " ";
		String varticle = "";

		int rw = table.getRowCount();
		for (int k = 0; k < rw; k++) {
			vbatch = table.getValueAt(k, 18).toString();
			vExp = table.getValueAt(k, 16).toString();
			vbatchno = table.getValueAt(k, 17).toString();
			varticle = table.getValueAt(k, 1).toString();

			Double vcost = Double.parseDouble(table.getValueAt(k, 3).toString());
			Double vqty = Double.parseDouble(table.getValueAt(k, 5).toString());
			switch (vbatch) {
			case "Y":
				switch (vExp) {
				case "0":
					new General().msg("Enter Batch no and Expiry Date for Item Code " + varticle);
					Action = "Fail";
				}
			}
		}
		return Action;
	}// Method End

	public void showArticle(String value) throws Throwable {
		//String vcomp = companycode.getText();
		//String vstore = Storecode.getText();
		String SQL = "Call GR_get_scanArticle( '" + value + "' , " + vcomp + ", " + vstore + ")";
		String vname = "Article";
		String result = checkArticleExist(value);
		if (result == "Sucess")
			showTable(SQL, vname, PoCol);
	}

	public void callUpload() throws Exception {
		String vff = "D:\\Article_Master_Template.xls";
		new gnTable().RemoveTableRows(model);
		DefaultTableModel xmodel = model;
		xmodel.setColumnIdentifiers(PoCol);
		DefaultTableModel model = new exportToExcel().ReadExcelData(vff, xmodel);
		table.setModel(model);
		table.setEnabled(true);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.gray);
		new gnTable().setTablewidth(table, 1, 300);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
	}

	private void insertintoGLmaster() throws Throwable {
		String vglcode = VendorCode.getText();
		String vglname = VendorName.getText();
		String vtype = "Y";
		new gnAccountbase().insertGlData(vglcode, vglname, vtype);

	}

	public void callSaveEvent() throws Throwable {
		// new General().msg("Prepareing to isert ");
		resetFigures();
		CheckBatchArticle();
		vstorecode = Storecode.getText().trim();
		vgrnDate = new gnConfig().date_ConverttoDBforamt(grndate.getText().trim());

		if (EditMode == "N") {
			grnno.setText(new gnSeq().getSeqno("8", "TR"));
		}

		vglcode = new gnSeq().getGlcode("8", "TR");
		vgrnno = Integer.parseInt(grnno.getText());
		vpono = 000;
		vtype = "PR";

		int d = VendorCode.getText().length();
		if (d == 0) {
			new General().msg("Select Venor...");
			VendorCode.grabFocus();
		}
		vvendor = Integer.parseInt(VendorCode.getText().trim());

		int d5 = InvoiceNumber.getText().length();
		if (d5 == 0) {
			new General().msg("Enter Supplier Invoice Number ");
			InvoiceNumber.grabFocus();
			vinvno = "0";
		}
		vinvno = InvoiceNumber.getText().trim();

		int d1 = InvoiceDate.getText().length();
		if (d1 == 0) {
			new General().msg("Enter Supplier Invoice Date");
			InvoiceDate.grabFocus();
			vinvDate = "0000.00.00";
		}
		vinvDate = new gnConfig().date_ConverttoDBforamt(InvoiceDate.getText().trim());

		int d2 = InvAmt.getText().length();
		if (d2 == 0) {
			new General().msg("Enter Supplier Invoice Amount");
			InvAmt.grabFocus();
			vinvamt = 0.00;
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
		// vduedate = new gnConfig().date_ConverttoDBforamt(new gnConfig().
		// get_duedate(vgrnDate, vcreditDays)) ;
		vduedate = "0000.00.00";
		vverticle = new gnHierarchy().getVerticleCode();
		vcomp = companycode.getText();

		vmygstno = new gnGST().getComanyGSTno();
		vmycompanystate = new gnGST().getmyState().trim();
		// vmycompanystate = vmycompanystate.trim() ;
		vmystatename = new gnGST().getmystatename();
		vmyCompanyisGST = new gnGST().ismyComanyGSTRegister();

		vstate = new gnGST().getCustomerState(VendorCode.getText()).trim();
		// vstate = vstate.trim() ;
		vstatename = new gnGST().getCustomerStatename(VendorCode.getText());
		vregdlr = new gnGST().isCustmoerGSTRegister(VendorCode.getText());
		vcustGSTno = new gnGST().getCustomerGSTNO(VendorCode.getText());

		int vvmyState = Integer.parseInt(vmycompanystate);
		int vvstate = Integer.parseInt(vstate);

		// new General().msg("My State Code "+ vvmyState +"vcust State "+
		// vvstate);

		if (vvmyState - vvstate == 0) {
			vmovtype = "Intra-State";
		}

		if (vvmyState - vvstate != 0) {
			vmovtype = "Inter-State";
		}

		boolean isimport = importPurchase.isSelected();
		if (isimport) {
			vimport = "Y";
		} else {
			vimport = "N";
		}

		boolean isSEZ = sez.isSelected();
		if (isSEZ) {
			vsez = "Y";
		} else {
			vsez = "N";
		}

		boolean vselection = chrevchrg.isSelected();

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
			String vvtype = "PR";
			new gnEDMiddleWare().PRModification(vvtype, grnno.getText(), grndate.getText());
			// This Proces will call in above Mthos Only Now Please check
			// PRModificafication Below it is called There
			vvtype = "DN";
			new gnEDMiddleWare().DNModification(vvtype, dnno.getText(), grndate.getText());
		}

		insertPurRetDetail();
	}

	public void insertPurRetDetail() throws Throwable {
		prst = null;
		int vbatchSize = table.getRowCount();
		final int batchSize = vbatchSize;
		int TotalRecordinsert = 0;
		String vmanufdt = "0000.00.00";
		String vexpdate = "0000.00.00";
		this.closeconn();
		if (con3 != null) {
			con3.close();
		}
		con3 = this.getConnection();
		con3.setAutoCommit(false);

		// Type" , 1"Article_code" , 2"Name" , 3"Qty" ,4 "UOM" ,5 "cost" ,
		// 6"CostValue " , 7 "sales Price" , 8"MRP" , 9"Trans.Chrg" ,
		// 10"Manuf.Chrg" ,
		// 11"Packing Chrgs" , 12"Landing Cost", 13"Tax%" ,
		// 14"Bal Qty", 15 "Manuf.Date" ,16 "Expiry date", 17"Batch No" ,
		// 18"Batch_Control" ,19 "Location" , 20"EanCode"

		String prdetail = "Insert into pr_detail(Site_code , " + "prno, pr_date,  vendor , " + "Inv_no,"
				+ "  Article_code , 	qty ,  UOM ,  cost ,  costValue, SalesPrice, MRP, "
				+ " Trans_cost, Manuf_cost, packing_cost, other_charges, "
				+ "Landing_cost  , Tax_per, Bal_qty, Ean_code,sr_no, Company_code, verticle,"
				+ "location, batch_control, batch_no, manuf_date, expiry_date ,"
				+ "reversecharge, cgst, sgst, igst, movementtype, taxablevalue, taxamount , finyear)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,  ?,?,?,?,?,?,?,?)";
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con3.prepareStatement(prdetail);
				prst.setString(1, vstorecode);
				prst.setInt(2, vgrnno);
				prst.setString(3, vgrnDate);
				prst.setInt(4, vvendor);
				prst.setString(5, vinvno);
				prst.setString(6, (table.getValueAt(k, 1).toString()));
				prst.setString(7, (table.getValueAt(k, 3).toString()));
				prst.setString(8, (table.getValueAt(k, 4).toString())); // uom
				prst.setDouble(9, (Double.parseDouble(table.getValueAt(k, 5).toString())));
				prst.setDouble(10, (Double.parseDouble(table.getValueAt(k, 6).toString())));
				prst.setDouble(11, (Double.parseDouble(table.getValueAt(k, 7).toString())));
				prst.setDouble(12, (Double.parseDouble(table.getValueAt(k, 8).toString())));
				prst.setDouble(13, (Double.parseDouble(table.getValueAt(k, 9).toString())));
				prst.setDouble(14, (Double.parseDouble(table.getValueAt(k, 10).toString())));
				prst.setDouble(15, (Double.parseDouble(table.getValueAt(k, 11).toString())));
				prst.setDouble(16, 0.00);
				prst.setDouble(17, (Double.parseDouble(table.getValueAt(k, 12).toString())));
				prst.setDouble(18, (Double.parseDouble(table.getValueAt(k, 13).toString())));
				prst.setDouble(19, (Double.parseDouble(table.getValueAt(k, 14).toString())));
				prst.setDouble(20, (Double.parseDouble(table.getValueAt(k, 20).toString())));
				prst.setInt(21, k);
				prst.setString(22, vcomp);
				prst.setString(23, vverticle);
				prst.setString(24, table.getValueAt(k, 19).toString());
				prst.setString(25, table.getValueAt(k, 18).toString());
				prst.setString(26, table.getValueAt(k, 17).toString());
				String vbatchEnable = table.getValueAt(k, 18).toString();
				switch (vbatchEnable) {
				case "N":
					vmanufdt = "0000.00.00";
					vexpdate = "0000.00.00";
					prst.setString(27, vmanufdt);
					prst.setString(28, vexpdate);
					break;
				case "Y":
					vmanufdt = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 15).toString());
					vexpdate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 16).toString());
					prst.setString(27, vmanufdt);
					prst.setString(28, vexpdate);
				}

				prst.setString(29, vreversechrg);
				// + "reversecharge, cgst, sgst, igst, movementtype,
				// taxablevalue, taxamount)"

				Double vtaxper = 0.00;
				Double vcostvalue = 0.00;
				double vcgst = 0.00;
				double vsgst = 0.00;
				double vigst = 0.00;

				switch (vmovtype) {
				case "Intra-State":
					vtaxper = Double.parseDouble(table.getValueAt(k, 13).toString());
					vcostvalue = Double.parseDouble(table.getValueAt(k, 6).toString());
					vtaxamount = new gnMath().CalTax_Pur(vcostvalue, vtaxper);
					vcgst = vtaxamount / 2;
					vsgst = vtaxamount / 2;
					vigst = 0.00;
					prst.setString(30, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
					prst.setString(31, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
					prst.setString(32, new gnMath().get2DecimaltValue(Double.toString(vigst)));
					prst.setString(33, vmovtype);
					break;
				case "Inter-State":
					vtaxper = Double.parseDouble(table.getValueAt(k, 13).toString());
					vcostvalue = Double.parseDouble(table.getValueAt(k, 6).toString());
					vtaxamount = new gnMath().CalTax_Pur(vcostvalue, vtaxper);
					vcgst = 0.00;
					vsgst = 0.00;
					vigst = vtaxamount;
					prst.setString(30, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
					prst.setString(31, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
					prst.setString(32, new gnMath().get2DecimaltValue(Double.toString(vigst)));
					prst.setString(33, vmovtype);
				}

				double vtaxablevalue = 0;
				double vnet = 0.0;
				double vtxamt;
				vnet = Double.parseDouble(table.getValueAt(k, 6).toString());
				vtaxablevalue = vnet - vtaxamount;
				prst.setString(34, new gnMath().get2DecimaltValue(Double.toString(vtaxablevalue)));
				prst.setString(35, new gnMath().get2DecimaltValue(Double.toString(vtaxamount)));
				prst.setString(36, new gnFinYear().getCurrentFinYear(grndate.getText()));

				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBdetail = "Sucess";
				if (TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBhdr = "Sucess";
				}
				prst.executeBatch();
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg("Detail Error" + e.getMessage());
			System.out.println(e.getLocalizedMessage());
			con3.rollback();
			DBdetail = "Fail";
		} finally {
			if (DBdetail == "Sucess") {
				insertPurRetHdr();
			}
			if (prst != null) {
				prst.close();
			}
		}
	}

	public void insertPurRetHdr() throws Throwable {
		if (DBdetail == "Sucess") {
			prst = null;
			final int batchSize = 1;
			int TotalRecordinsert = 0;
			con2 = this.getConnection();
			con2.setAutoCommit(false);
			String Status = "Fail";
			String poshdr = "Insert into pr_hdr(Site_code , " + "Prno, Pr_date,  po_no,   type  , vendor , "
					+ "Inv_no, Inv_date, Inv_amount ,  costValue, "
					+ " other_charges,Total_amount , updateDate, createBy , creditDays, Payment_no,"
					+ " Payment_date, due_date, Company_code, verticle, Remark ,"
					+ "approvepr, approvedby, approvedate , reversecharge , import,SEZzone,"
					+ "ismycompanyGst , mygstno , mystatecode, mystatename,  "
					+ "  regDealer, custGSTno , state, statename, movementType, glcode, updatedby, finyear)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?,? , ?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				prst = con2.prepareStatement(poshdr);
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
				prst.setDouble(11, vothcharges);
				prst.setDouble(12, vtotalamount);
				prst.setString(13, vupdateDate);
				prst.setString(14, vcreateBy);
				prst.setInt(15, vcreditDays);
				prst.setInt(16, 0);
				prst.setInt(17, 0);
				prst.setString(18, vduedate);
				prst.setString(19, companycode.getText());
				prst.setString(20, vverticle);
				prst.setString(21, remark.getText());

				if (vapprove == "N") {
					prst.setString(22, vapprove);
					prst.setString(23, "Approval Pending");
					prst.setString(24, "0000.00.00");
				}
				if (vapprove == "Y") {
					prst.setString(22, vapprove);
					prst.setString(23, vapprovedby);
					prst.setString(24, vapprovedate);
				}

				prst.setString(25, vreversechrg);
				prst.setString(26, vimport);
				prst.setString(27, vsez);

				prst.setString(28, vmyCompanyisGST);
				prst.setString(29, vmygstno);
				prst.setString(30, vmycompanystate);
				prst.setString(31, vmystatename);
				prst.setString(32, vregdlr);
				prst.setString(33, vcustGSTno);
				prst.setString(34, vstate);
				prst.setString(35, vstatename);
				prst.setString(36, vmovtype);
				prst.setString(37, vglcode);
				prst.setString(38, vcreateBy);
				prst.setString(39, new gnFinYear().getCurrentFinYear(grndate.getText()));
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBhdr = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					// con2.commit();
					DBhdr = "Sucess";
				}
			} catch (SQLException e) {
				new General().msg("PR Header Error" + e.getMessage());
				con2.rollback();
				DBhdr = "Fail";
			} finally {
				if (DBhdr == "Sucess") {
					con3.commit();
					con2.commit();
					con3.close();
					con2.close();
					if (EditMode == "N") {
						new gnSeq().updateSeqno("8", "TR");
					}
					this.closeconn();
				}
				if (prst != null) {
					prst.close();
				}
				switch (vapprove) {
				case "Y":
					updateProcessForSaveEvent();
					// calculateGSTReturnData() ;
					break;
				case "N":
					new General().msg("Data Without Approval Inserted Sucessfully");
					new General().msg("!!!Reminder!!! ...Approve Document  For Vendor Payment and Inventory Imapct");
					refresh();
					break;
				}
			}
		}
	}

	private void calculateGSTReturnData() throws Throwable {
		// Debit Note Data Posting to Gst Return Data and Accounting and
		// drcrLedger
		vdoctype = "DN";
		vparty = VendorCode.getText();
		String vdocno = dnno.getText();
		String vdocdate = grndate.getText();
		String vamount = TotalAmount.getText();

		switch (PostGST_accountEntryAtSaveTime) {
		case "Y":
			// Debit Note Entries
			new gnGSTMiddleWare().gstDebitnoteProcess(vparty, vdocno, vdocdate, vamount);

			/// Purchase Return Entries
			vdocno = grnno.getText();
			new gnGSTMiddleWare().backend_DocgstPRProcess(vparty, vdocno, vdocdate, vamount);
		}
	}

	private void updateProcessForSaveEvent() throws Throwable {
		if (DBhdr == "Sucess") {
			if (vapprove == "Y") {
				generateDebitNote();
				updateInventoryAction();
				updateApproveStatus();
				// calculateGSTDNData();
				calculateGSTReturnData();
				btnSave.setEnabled(true);
				btnUpdate.setEnabled(false);
				dnPanel.setVisible(false);
				refresh();
			}
		}
	}

	public void callUpdateEvent() throws Throwable {
		// new General().msg("Updating Records ..... ");
		resetFigures();
		CheckBatchArticle();
		vcomp = companycode.getText();
		vstorecode = Storecode.getText().trim();
		vgrnDate = new gnConfig().date_ConverttoDBforamt(grndate.getText().trim());
		vgrnno = Integer.parseInt(grnno.getText());
		vsgrnno = grnno.getText();
		vpono = 000;
		vtype = "PR";
		vvendor = Integer.parseInt(VendorCode.getText().trim());
		int d = InvoiceNumber.getText().length();
		if (d == 0) {
			new General().msg("Enter Supplier Invoice Number ");
			InvoiceNumber.grabFocus();
			return;
		}
		vinvno = InvoiceNumber.getText().trim();

		int d1 = InvoiceDate.getText().length();
		if (d1 == 0) {
			new General().msg("Enter Supplier Invoice Date");
			InvoiceDate.grabFocus();
			return;
		}
		vinvDate = new gnConfig().date_ConverttoDBforamt(InvoiceDate.getText().trim());

		int d2 = InvAmt.getText().length();
		if (d2 == 0) {
			new General().msg("Enter Supplier Invoice Amount");
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
			UpdatePRDetail();
			if (DBhdr == "Sucess") {
				refresh();
				btnSave.setEnabled(true);
				btnUpdate.setEnabled(false);
			}
		}

		if (vapprove == "Y") {
			UpdatePRDetail();
			if (DBhdr == "Sucess") {
				generateDebitNote();
				updateInventoryAction();
				updateApproveStatus();
				// calculateGSTDNData();
				refresh();
				dnPanel.setVisible(false);
				btnSave.setEnabled(true);
				btnUpdate.setEnabled(false);
			}
		}
	}

	private void showDNData() throws Throwable {
		dnPanel.setVisible(true);
		this.closeconn();
		String dncomp = new gnConfig().getCompanyCode();
		String dnstore = new gnConfig().getStoreID();
		String vprno = grnno.getText();
		String SQL = "call  PR_getDebitnote(" + dncomp + ", " + dnstore + ", " + vprno + " ) ";
		rs1 = this.getSPResult(SQL);
		if (rs1.next()) {
			String vDataapprove = rs1.getString(1);
			switch (vDataapprove) {
			case "Y":
				dnno.setText(rs1.getString(2));
				dnamount.setText(rs1.getString(3));
				dnexpdate.setText(rs1.getString(4));
				dnstatus.setText(rs1.getString(5));
				dnPanel.setVisible(true);
				rs1.close();
			}
		} else {

		}
	}

	public String generateDebitNote() throws Throwable {
		String vtype = "DN";
		String Debitnoteno = "";
		// Debitnoteno = new gnSeq().getSeqno( "102", "TR") ;
		// new General().msg("Edit Mode is :"+" "+EditMode);
		String ValidateDate = new gnPayment().getValiduptoDate(vgrnDate);
		String validupto = new gnConfig().date_ConverttoDBforamt(ValidateDate);
		switch (EditMode) {
		case "N":
			Debitnoteno = new gnSeq().getSeqno("102", "TR");
			break;
		case "Y":
			Debitnoteno = dnno.getText();
			break;
		}
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		this.closeconn();
		con7 = this.getConnection();
		con7.setAutoCommit(false);
		String Status = "Fail";
		String dnnote = "Insert into payment_DNCN_master(company_code , "
				+ "site_code,    terminal, partycode , type  , " + " Document_no , Document_date , "
				+ "Amount  ,  Amount_consume , Consume_date , " + "Ref_tran_type  ,  Ref_doc_no ,  Ref_doc_date , "
				+ "Balance_amount  , Remark  , Status ,  "
				+ "cashier , shift, valid_upto, verticle, document_category, updatedate, updateby , finyear)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?, ?,? ,?)";
		try {
			prst = con7.prepareStatement(dnnote);
			prst.setString(1, vcomp);
			prst.setString(2, vstorecode);
			prst.setInt(3, 0);
			prst.setInt(4, vvendor);
			prst.setString(5, vtype);
			prst.setString(6, Debitnoteno);
			prst.setString(7, vgrnDate);
			prst.setDouble(8, vtotalamount);
			prst.setDouble(9, 0);
			prst.setDouble(10, 0);
			prst.setString(11, "PR");
			prst.setString(12, grnno.getText());
			prst.setString(13, vgrnDate);
			prst.setDouble(14, vtotalamount);
			prst.setString(15, "Auto Generated Debite Note By System for Purchase Return");
			prst.setString(16, "Open");
			prst.setString(17, vcreateBy);
			prst.setInt(18, 0);
			prst.setString(19, validupto);
			prst.setString(20, vverticle);
			prst.setString(21, "S");
			prst.setString(22, vgrnDate);
			prst.setString(23, vcreateBy);
			prst.setString(24, new gnFinYear().getCurrentFinYear(grndate.getText()));
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DNCNstatus = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				con7.commit();
				DNCNstatus = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			con7.commit();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			new General().msg("Debit Note Generation" + "" + e.getLocalizedMessage());
			con7.rollback();
			DNCNstatus = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con7 != null) {
				con7.close();
			}
			if (DNCNstatus == "Sucess") {

				if (EditMode == "N") {
					new gnSeq().updateSeqno("102", "TR");
				}
				dnno.setText(Debitnoteno);
				dnamount.setText(Double.toString(vtotalamount));
				dnexpdate.setText(ValidateDate);
				dnstatus.setText("Open");
				dnPanel.setVisible(true);
			}
		}
		return DNCNstatus;
	}
	//// end Debite Note

	public void UpdatePRDetail() throws Throwable {
		prst = null;
		String vcomp = companycode.getText();
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		// this.closeconn();
		con5 = this.getConnection();
		con5.setAutoCommit(false);
		String grndetail = "update  pr_detail set   "
				+ "qty = ?,   UOM  = ?, cost  = ?,   costValue = ?,   Salesprice= ?  , mrp =  ? , "
				+ " Trans_cost = ?,   Manuf_cost = ?,    packing_cost = ? , Landing_cost  = ?,"
				+ " Ean_code = ?,  Manuf_date = ?, Expiry_date =?,   Batch_no =  ?,  location = ?  "
				+ " where   company_code = ?  and  site_code = ?  and vendor = ?  and prno = ? and  article_code = ? ";
		//
		// Type" , 1"Article_code" ,2 "Name" , 3"Qty" ,4 "UOM" ,5 "cost" ,
		// 6"CostValue " , 7 "sales Price" , 8"MRP" , 9"Trans.Chrg" ,10
		// "Manuf.Chrg" ,
		// 11"Packing Chrgs" ,12 "Landing Cost",13 "Tax%" ,
		// 14"Bal Qty", 15"Manuf.Date" , 16"Expiry date", 17"Batch No" ,
		// 18"Batch_Control" , 19 "Location" , 20"EanCode"
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				String veancode = (String) table.getValueAt(k, 3);
				if (veancode != "0") {
					prst = con5.prepareStatement(grndetail);
					prst.setString(1, (table.getValueAt(k, 3).toString()));
					prst.setString(2, (table.getValueAt(k, 4).toString()));
					prst.setString(3, (table.getValueAt(k, 5).toString()));
					prst.setString(4, table.getValueAt(k, 6).toString());
					prst.setString(5, table.getValueAt(k, 7).toString());
					prst.setString(6, (table.getValueAt(k, 8).toString()));
					prst.setString(7, (table.getValueAt(k, 9).toString()));
					prst.setString(8, (table.getValueAt(k, 10).toString()));
					prst.setString(9, (table.getValueAt(k, 11).toString()));
					prst.setString(10, (table.getValueAt(k, 12).toString()));
					prst.setString(11, (table.getValueAt(k, 20).toString()));
					String vmanf = table.getValueAt(k, 15).toString();
					String vexp = table.getValueAt(k, 16).toString();
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
					prst.setString(15, (table.getValueAt(k, 19).toString()));
					prst.setString(16, vcomp);
					prst.setString(17, vstorecode);
					prst.setInt(18, vvendor);
					prst.setInt(19, vgrnno);
					prst.setString(20, (table.getValueAt(k, 1).toString()));
					prst.addBatch();
					TotalRecordinsert = TotalRecordinsert + 1;
					DBdetail = "Fail";
					if (++TotalRecordinsert % batchSize == 0) {
						prst.executeBatch();
						DBdetail = "Sucess";
					}
					// new General().msg( "PRST "+" "+prst);
					prst.executeBatch();
					DBdetail = "Sucess";
				}
			}
		} catch (SQLException e) {
			new General().msg("Grn Detail" + e.getMessage());
			e.getMessage();
			e.printStackTrace();
			con5.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {
				updatePRHdr();
			}
		}
	}

	public void updatePRHdr() throws Throwable {
		if (DBdetail == "Sucess") {
			prst = null;
			String vcomp = companycode.getText();
			String vstore = Storecode.getText();
			final int batchSize = 10;
			int TotalRecordinsert = 0;
			con6 = this.getConnection();
			con6.setAutoCommit(false);
			String poshdr = "update  pr_hdr set  Inv_no = ? , Inv_date = ?, " + " Inv_amount =? ,   costValue =?, "
					+ " other_charges=?,  Total_amount=? ,  updateDate =?, updatedby = ? "
					+ "  where Company_code=?  and  Site_code =?  and  prno=?  and  vendor =?";
			try {
				prst = con6.prepareStatement(poshdr);
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
					DBhdr = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DBhdr = "Sucess";
			} catch (SQLException e) {
				new General().msg("Grn Hdr" + e.getMessage());
				con6.rollback();
				DBhdr = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
				}

				if (DBhdr == "Sucess") {
					con5.commit();
					con6.commit();
					new General().msg("Purchase Return  Data Updated Sucessfully...");
					con5.close();
					con6.close();
				}
			}
		}
	}

	public void updateApproveStatus() throws Throwable {
		if (DNCNstatus == "Sucess") {
			vcomp = companycode.getText();
			vstorecode = Storecode.getText();
			String vdnno = dnno.getText();
			String vgrnno = grnno.getText();
			if (vapprove == "Y") {
				prst = null;
				final int batchSize = 1;
				int TotalRecordinsert = 0;
				Connection con1 = this.getConnection();
				con1.setAutoCommit(false);
				String Status = "Fail";
				String grnhdrupd = "update pr_hdr  set  " + "approvePr = ?, " + "approvedby  = ? ,"
						+ " approvedate = ? , DebitNoteno = ? "
						+ "where prno = ?  and Company_code = ?  and site_code = ? ";
				try {
					prst = con1.prepareStatement(grnhdrupd);
					prst.setString(1, vapprove);
					prst.setString(2, vapprovedby);
					prst.setString(3, vapprovedate);
					prst.setString(4, vdnno);
					prst.setString(5, vgrnno);
					prst.setString(6, vcomp);
					prst.setString(7, vstorecode);
					prst.addBatch();
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
					new General().msg("Status Updated Sucessfully..");
					// refresh();
				}
			}
		}
	}

	private void updateInventoryAction() throws Throwable {
		// Stock_in_hand_details();
		reduceInv();
		// new General().msg(" Data After Approval Updated Sucessfully...") ;
	}

	public String reduceInv() throws Throwable {
		String Action = "Fail";
		String vstore = vstorecode;
		String varticle;
		String vtype = "PurchaseReturn";
		vgrnDate = new gnConfig().date_ConverttoDBforamt(grndate.getText().trim());
		String vdate = vgrnDate;
		String vqty = "0";
		String vfinyear = new gnFinYear().getReportingFinYear();

		if (DBdetail == "Sucess" && DBhdr == "Sucess") {

			// New Procedure used now remove old logic of update inventpory
			// new General().msg("Reducing with new Logic ,,,now ");
			String vtrntype = "PR";
			String SQL = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vgrnno + " , '"
					+ vgrnDate + "' , '" + vfinyear + "')";
			// new General().msg(SQL);
			this.getSPResult(SQL);
			// End Logic Change

			// For Stock-in_detail New Procedure used now remove old logic of
			// update inventpory
			String vtrntype1 = "PR";
			String SQL1 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   " + vgrnno
					+ " , '" + vgrnDate + "' , '" + vfinyear + "')";
			this.getSPResult(SQL1);
			// End Logic Change

			String vpara811 = "811";
			String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
					vstore);
			switch (vmaintainbatchforNonBatchItem) {
			case "Y":
				vtrntype1 = "PR";
				SQL1 = "call   Inv_impact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   "
						+ vgrnno + " , '" + vgrnDate + "' , '" + vfinyear + "')";
				this.getSPResult(SQL1);
				break;
			}
			/*
			 * int rw = table.getRowCount(); for ( int k1 =0 ; k1 < rw ; k1++) {
			 * varticle = table.getValueAt(k1,1).toString(); vqty =
			 * table.getValueAt(k1,3).toString() ; String vlocation =
			 * table.getValueAt(k1,19).toString() ; String vinvtype = "0" ;
			 * String vbatchControlartilce = table.getValueAt(k1,
			 * 18).toString(); new applyInv_Action(). invAction(vstore ,
			 * varticle, vtype, vdate, vqty, vlocation , vcomp, vverticle ,
			 * vinvtype, vbatchControlartilce) ; Action = "Sucess" ; }
			 */
		}

		return Action;
	}

	private void refresh() throws Throwable {
		// new General().msg("Purchase Return Number is " + vgrnno) ;

		new gnTable().RemoveTableRows(model);
		EditMode = "N";
		grndate.setText(new gnConfig().getDaybeginDate());
		btnEdit.setBackground(new Color(51, 255, 255));
		btnEdit.setFont(new Font("Cambria", Font.BOLD, 13));
		btnEdit.setForeground(new Color(0, 0, 153));
		scanItem.setVisible(true);
		scanName.setVisible(true);

		approve.setSelected(false);
		approve.setBackground(Color.CYAN);
		approve.setEnabled(false);
		approve.setSelected(true);
		approvedby.setText(null);
		approvedate.setText(null);
		InvAmt.setText("0");
		InvoiceDate.setText("0");
		InvoiceNumber.setText("0");
		VendorCode.setText(null);
		VendorName.setText(null);
		// email.setText(null) ;
		// Mobile.setText(null) ;
		SupplierPayable.setText("0");
		Othcharges.setText("0");
		TotalAmount.setText("0");
		records.setText("0");
		creditDays.setText(null);
		scanItem.setText(null);
		scanItem.setEditable(true);
		scanName.setEnabled(true);
		// searchbrand.setEnabled(true);
		VendorName.grabFocus();

	}

	public void Stock_in_hand_details() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		String status;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String stockdetail = "Insert into stock_in_hand_details(Company_code, Site_code , "
				+ "Article_code,   Location ,   " + "supplier_code,   Batch_no, " + "Manuf_date, Expiry_date,"
				+ "Batch_qty,  bal_qty ,   cost ,  " + "SalesPrice, MRP,  " + " createDate, updateDate, verticle)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				String vbatchEnable = table.getValueAt(k, 18).toString();
				switch (vbatchEnable) {
				case "Y":
					String vvexpdate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 16).toString());
					String vlocation = table.getValueAt(k, 19).toString();
					String result = new gnConfig().batch_isBatchExist(vstorecode, table.getValueAt(k, 1).toString(),
							table.getValueAt(k, 17).toString(), vvexpdate, vlocation, vcomp);
					switch (result) {
					case "update":
						String varticle = table.getValueAt(k, 1).toString();
						String vbatchno = table.getValueAt(k, 17).toString();
						String vqty = table.getValueAt(k, 3).toString();
						String vloc = table.getValueAt(k, 19).toString();
						String vvexpdate1 = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 16).toString());
						String SQL = "call batch_Addstock( " + vqty + " , " + vstorecode + ",  " + varticle + " , "
								+ vbatchno + " , '" + vvexpdate1 + "', '" + vloc + "', " + vcomp + " , " + vverticle
								+ ")";
						this.getSPResult(SQL);
						break;
					case "insert":
						prst = con.prepareStatement(stockdetail);
						prst.setString(1, new gnConfig().getCompanyCode());
						prst.setString(2, vstorecode);
						prst.setString(3, (table.getValueAt(k, 1).toString()));
						prst.setString(4, (table.getValueAt(k, 19).toString()));
						prst.setString(5, VendorCode.getText());
						prst.setString(6, (table.getValueAt(k, 17).toString()));
						String vmnfDate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 15).toString());
						if (vmnfDate == "0") {
							vmnfDate = "0000.00.00";
						}
						prst.setString(7, vmnfDate);
						prst.setString(8, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 16).toString()));
						prst.setString(9, (table.getValueAt(k, 3).toString()));
						prst.setString(10, (table.getValueAt(k, 3).toString()));
						prst.setString(11, (table.getValueAt(k, 5).toString()));
						prst.setString(12, (table.getValueAt(k, 7).toString()));
						prst.setString(13, (table.getValueAt(k, 8).toString()));
						prst.setString(14, vgrnDate);
						prst.setString(15, vgrnDate);
						prst.setString(16, vverticle);
						prst.addBatch();
						TotalRecordinsert = TotalRecordinsert + 1;
						status = "Sucess";
						if (++TotalRecordinsert % batchSize == 0) {
							prst.executeBatch();
							status = "Sucess";
							con.commit();
						}
						prst.executeBatch(); // insert remaining records
						con.commit();
					}
					break;
				}
			} // for
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public void callDebitnotPrint() throws Throwable {
		String vinvno = grnno.getText();
		String doctype = "DN";
		new gnDocPrint().callprint(doctype, vinvno, grndate.getText());
		return;
	}

	private void callprint() throws Throwable {
		vcomp = companycode.getText();
		vstorecode = Storecode.getText();
		try {
			String vprno = grnno.getText();
			String SQL = "call printprn(" + vcomp + " , " + vstorecode + " , " + vprno + ")";

			this.getResult(SQL);
		} catch (Exception e) {
			new General().msg(e.getMessage());
		} finally {
			String vreport = "prnote.jasper";
			gnPrintMasters rpt = new gnPrintMasters();
			rpt.print(vreport);
			callDebitnotPrint();
		}
	}
}// last

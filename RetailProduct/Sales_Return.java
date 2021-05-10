package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

public class Sales_Return extends getResultSet {

	private Connection con1, con2, con3, con5, con7, con8, con9, con4;

	public static String EditMode = "N";
	String referInvoice = "N";
	private JButton btnUpdate;
	public static JButton btnEdit;
	private String vfinyear = "";
	String canIssueCN;
	String canIssueCash;

	private int selectedrow;
	private JButton btnGenerateCn;
	private JButton btnReturnCash;
	private JButton btnBatch;
	private String vstore;
	private String vcomp;
	String vallow;
	private String choice;
	int vmy;
	int voth;

	public DefaultTableModel Articlemodel = new DefaultTableModel();
	public JTable Articletable = new JTable();
	String vdoctype2 = "";
	String vtaxtype = " ";
	String vcgst = "";
	String vsgst = "";
	String vigst = " ";

	private String VCNvalidupto = "";
	public JFrame frameSalesReturn;
	public static String varticle1; // varticle1 will be updated by
									// gnAdmin.search module this return article
									// code
	private JTextField storecode;
	private String vverticle;
	private JTextField SRno;
	private JTextField paymentamt;
	JButton btnShow;
	private JTextField Scan_item;
	private JTextField Itemname;
	private JTextField returndate;
	private JTextField vendorcode;
	private JTextField invno;
	private JTextField invdate;
	private JTextField vendorname;
	private JTextField terminal;
	private JTextField shift;
	private JTextField cashier;
	private JTextField Tamount;
	private JComboBox comboRtype;
	private JPanel IteamScanPanel;
	private JButton btnSave;
	private JButton btnPrint;
	private JButton btnCancel;
	private String vcashier;
	JScrollPane ajsp;
	String vglcode;
	/// Tableinsert variables
	//// Pick Data for insert DB insert variable
	public String vvcashiercode = "nk002";
	public int vshift;

	public String vpaymentmode;
	public Double vpaymentamount;
	public java.sql.PreparedStatement prst = null;
	public String vvcompnaycode;
	public String vvsitecode;
	public int vterminal;
	public boolean process = true;
	public int vvinvno;
	public String Svinvdate;
	public Date Dinvdate;
	JSplitPane mySplit;
	// public String vvcashiercode;
	public String vvsales_type = "SR";
	public String vvinvoice_type = "RI";
	public String vvposting_type = "Y";
	public Double vvggross = 0.00;
	public Double vvdisc = 0.00;
	public Double vvnet = 0.00;
	public int vvcustid = 0;
	public int vean = 0;
	JPanel leftPanel;
	public String Status = "Sucess";
	public String vcompType;
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

	public String vinvoice_type = "RI";
	String vmystatename;
	public String vposting_type = "Y";
	public String HDRstatus = "Fail";
	public String DTLstatus = "Fail";
	public String DNCNstatus = "Sucess";
	public String PMTstatus = "Sucess";
	public String STKstatus = "Fail";

	// ===========GST
	private String vmygstno;
	private String vmycompanystate;
	private String vmyCompanyisGST;

	private String vstate;
	private String vstatename;
	private String vregdlr;
	private String vcustGSTno;
	private String vmovtype;

	// Payment RElated
	private JScrollPane pjsp;
	private JViewport prt5 = new JViewport();
	DefaultTableModel pmodel = new DefaultTableModel();
	JTable ptable = new JTable();
	String pcol[] = { "Payment Type ", " Amount ", "CN Number" };

	/// table related
	private JScrollPane jsp;
	private JViewport prt = new JViewport();
	private DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 4 || column == 5 || column == 0 || column == 17 || column == 14 || column == 15
					|| column == 17 ? true : false;
		}
	};
	private JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 4 || column == 5 || column == 17 || column == 14 || column == 15
					|| column == 17) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			} else {
				componentt.setBackground(Color.cyan);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}
			return componentt;
		}
	};

	public String Col[] = { "X", "Item", "Name", "Qty", "Rate", "MRP", "Gross", "Hdr Disc", "Disc", "Tax", "Amount",
			"Taxcode", "Batch Item", "BatchNo", "Exp.Date", "Cost" };

	public String Colitem[] = { "X", "Item", "Name", "Inv Qty", "Return Qty", "Rate", "MRP", "Gross", "Hdr Disc",
			"Disc", "Tax", "Amount", "Taxcode", "Batch Item", "BatchNo", "Exp.Date", "Cost", "location" };

	public String ACol[] = { "Item Code", "Name", "MRP", "Sales Price" };

	// SEarch ptable RElated
	private JScrollPane sjsp;
	private JTable stable = new JTable();
	private DefaultTableModel smodel = new DefaultTableModel();
	private String cus[] = { "Customer_code", "Name", "Invoice Number", "Invoice Date", "Net_Amount" };
	private JViewport prt7 = new JViewport();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sales_Return window = new Sales_Return();
					window.frameSalesReturn.setVisible(true);
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
	public Sales_Return() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {

		frameSalesReturn = new JFrame();
		frameSalesReturn.setTitle("Business Application");
		frameSalesReturn.setAlwaysOnTop(true);
		frameSalesReturn.setBounds(1, 100, 1350, 600);
		frameSalesReturn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameSalesReturn.getContentPane().setLayout(null);
		frameSalesReturn.getContentPane().setLayout(null);

		// JPanel hpanel1 = new JPanel();
		JPanel hpanel1 = new gnRoundPanel();

		hpanel1.setBackground(Color.WHITE);

		hpanel1.setBounds(12, 13, 1308, 192);
		frameSalesReturn.getContentPane().add(hpanel1);
		hpanel1.setLayout(null);

		JLabel lblStoreCode = new JLabel("Store Code");
		lblStoreCode.setForeground(Color.BLACK);
		lblStoreCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStoreCode.setFont(new Font("Cambria", Font.BOLD, 14));
		lblStoreCode.setBounds(12, 13, 83, 16);
		hpanel1.add(lblStoreCode);

		storecode = new JTextField();
		storecode = new gnRoundTextField(10);

		storecode.setForeground(new Color(51, 255, 51));
		storecode.setBackground(new Color(0, 0, 102));
		storecode.setEditable(false);
		storecode.setBounds(104, 10, 116, 25);
		hpanel1.add(storecode);
		storecode.setColumns(10);

		// SRno = new JTextField();
		SRno = new gnRoundTextField(10);

		SRno.setBackground(new Color(0, 0, 102));
		SRno.setFont(new Font("Tahoma", Font.BOLD, 15));
		SRno.setForeground(new Color(51, 255, 51));
		SRno.setEditable(false);
		SRno.setBounds(336, 10, 116, 25);
		hpanel1.add(SRno);
		SRno.setColumns(10);

		// returndate = new JTextField();
		returndate = new gnRoundTextField(10);

		returndate.setBackground(new Color(0, 0, 102));
		returndate.setFont(new Font("Tahoma", Font.BOLD, 13));
		returndate.setForeground(new Color(51, 255, 51));
		returndate.setEditable(false);
		returndate.setBounds(524, 10, 116, 25);
		hpanel1.add(returndate);
		returndate.setColumns(10);

		JLabel lblSalesReturn = new JLabel("SalesReturn No");
		lblSalesReturn.setForeground(Color.BLACK);
		lblSalesReturn.setFont(new Font("Cambria", Font.BOLD, 14));
		lblSalesReturn.setBounds(232, 13, 102, 16);
		hpanel1.add(lblSalesReturn);

		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.BLACK);
		lblDate.setFont(new Font("Cambria", Font.BOLD, 14));
		lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDate.setBounds(456, 13, 56, 16);
		hpanel1.add(lblDate);

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);

		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer Invoice Details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 51, 0)));
		panel.setBounds(95, 40, 802, 95);
		hpanel1.add(panel);
		panel.setLayout(null);

		vendorcode = new JTextField();
		vendorcode.setForeground(new Color(0, 0, 102));
		vendorcode.setBounds(506, 44, 42, 30);
		vendorcode.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		vendorcode.setBackground(Color.WHITE);
		vendorcode.setEnabled(false);
		vendorcode.setText("0");
		panel.add(vendorcode);
		vendorcode.setColumns(10);

		JLabel lblSupplier = new JLabel("Customer");
		lblSupplier.setBounds(273, 26, 70, 16);
		lblSupplier.setForeground(new Color(0, 0, 51));
		lblSupplier.setFont(new Font("Cambria", Font.BOLD, 15));
		lblSupplier.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblSupplier);

		invno = new JTextField();
		invno.setBounds(558, 44, 68, 30);
		invno.setForeground(new Color(0, 0, 102));
		invno.setBackground(Color.WHITE);
		invno.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		invno.setText("0");
		panel.add(invno);
		invno.setColumns(10);
		ActionListener bbc = new lsinv();
		invno.addActionListener(bbc);

		JLabel lblInvoiceNo = new JLabel("Inv.No");
		lblInvoiceNo.setBounds(535, 26, 67, 16);
		lblInvoiceNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInvoiceNo.setForeground(new Color(0, 0, 51));
		lblInvoiceNo.setFont(new Font("Cambria", Font.BOLD, 15));
		panel.add(lblInvoiceNo);

		JLabel lblInvdate = new JLabel("Inv.Date");
		lblInvdate.setBounds(619, 26, 67, 16);
		lblInvdate.setFont(new Font("Cambria", Font.BOLD, 15));
		lblInvdate.setForeground(new Color(0, 0, 51));
		lblInvdate.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblInvdate);

		invdate = new JTextField();
		invdate.setBounds(629, 44, 89, 30);
		invdate.setForeground(new Color(0, 0, 102));
		invdate.setBackground(Color.WHITE);
		invdate.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		invdate.setEditable(false);
		panel.add(invdate);
		invdate.setColumns(10);

		vendorname = new JTextField();
		vendorname.setBounds(272, 44, 231, 30);
		vendorname.setForeground(new Color(0, 0, 102));
		vendorname.setBackground(Color.WHITE);
		vendorname.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		vendorname.setText("0");
		vendorname.setToolTipText("Enter Supplier name to search Invoice Number");
		panel.add(vendorname);
		vendorname.setColumns(10);
		ActionListener kj1 = new lssupl();
		vendorname.addActionListener(kj1);

		JLabel lblReturnType = new JLabel("Ret Type");
		lblReturnType.setBounds(54, 26, 143, 16);
		lblReturnType.setForeground(new Color(0, 0, 51));
		lblReturnType.setFont(new Font("Cambria", Font.BOLD, 15));
		lblReturnType.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblReturnType);

		comboRtype = new JComboBox();
		comboRtype.setForeground(new Color(0, 0, 102));
		comboRtype.setBackground(Color.WHITE);
		comboRtype.setBounds(54, 44, 215, 30);
		comboRtype.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		comboRtype.setToolTipText(
				"Choose With Reference when Customer is having Invoice Copy >  If Not Then Select Without Reference option>");
		comboRtype.setModel(
				new DefaultComboBoxModel(new String[] { "With Invoice Reference", "Without Invoice Reference" }));
		panel.add(comboRtype);

		btnShow = new JButton("Show");
		btnShow.setBounds(720, 44, 70, 30);
		panel.add(btnShow);

		JComboBox comboSR = new JComboBox();
		comboSR.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		comboSR.setEnabled(false);
		comboSR.setBounds(12, 44, 42, 30);
		panel.add(comboSR);
		comboSR.setForeground(new Color(0, 0, 102));
		comboSR.setBackground(Color.WHITE);
		comboSR.setModel(new DefaultComboBoxModel(new String[] { "SR" }));
		 

		JLabel lblNewLabel = new JLabel("Financial Year");
		lblNewLabel.setBounds(975, 20, 92, 16);
		hpanel1.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);

		finyear = new JTextField();
		finyear.setBounds(1066, 17, 116, 22);
		hpanel1.add(finyear);
		finyear.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setBounds(646, 13, 54, 26);
		hpanel1.add(btnSave);
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Calibri", Font.BOLD, 13));
		btnSave.setBackground(Color.CYAN);
		btnSave.setEnabled(true);

		lblNewLabel_2 = new JLabel("Narration");
		lblNewLabel_2.setBounds(195, 139, 83, 22);
		hpanel1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.BLACK);

		narration = new JTextField();
		narration.setBounds(290, 135, 607, 30);
		hpanel1.add(narration);
		narration.setFont(new Font("Cambria", Font.BOLD, 14));
		narration.setColumns(10);
		// panel_2.add(sjsp);

		JPanel PaymentPanel = new JPanel();
		PaymentPanel.setBounds(898, 40, 380, 125);
		hpanel1.add(PaymentPanel);
		PaymentPanel.setBackground(Color.WHITE);
		PaymentPanel.setBorder(new TitledBorder(null, "Payment Details", TitledBorder.LEFT, TitledBorder.TOP, null,
				new Color(255, 200, 0)));
		PaymentPanel.setLayout(null);

		pjsp = new JScrollPane();
		pjsp.setBounds(31, 67, 330, 50);
		PaymentPanel.add(pjsp);

		JLabel lblSalesReturnAmount = new JLabel("Sales Return Amount");
		lblSalesReturnAmount.setBounds(31, 20, 123, 16);
		PaymentPanel.add(lblSalesReturnAmount);
		lblSalesReturnAmount.setFont(new Font("Calibri", Font.BOLD, 13));
		lblSalesReturnAmount.setForeground(Color.BLACK);
		lblSalesReturnAmount.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setBounds(178, 20, 56, 16);
		PaymentPanel.add(lblPayment);
		lblPayment.setFont(new Font("Calibri", Font.BOLD, 13));
		lblPayment.setForeground(Color.BLACK);

		Tamount = new gnRoundTextField(15);
		Tamount.setBounds(31, 37, 116, 28);
		PaymentPanel.add(Tamount);
		Tamount.setForeground(Color.BLUE);
		Tamount.setFont(new Font("Tahoma", Font.BOLD, 17));
		Tamount.setEditable(false);
		Tamount.setColumns(10);
		Tamount.setText("0.00");

		paymentamt = new gnRoundTextField(15);
		paymentamt.setBounds(151, 37, 116, 28);
		PaymentPanel.add(paymentamt);
		paymentamt.setForeground(Color.BLUE);
		paymentamt.setFont(new Font("Tahoma", Font.BOLD, 17));
		paymentamt.setText("0.00");
		paymentamt.setEditable(false);
		paymentamt.setColumns(10);

		btnEdit = new JButton("Edit Document");
		btnEdit.setBounds(703, 12, 128, 30);
		hpanel1.add(btnEdit);
		btnEdit.setSelectedIcon(new ImageIcon(Sales_Return.class.getResource("/RetailProduct/btnApEdit1.png")));
		btnEdit.setMnemonic('E');

		// JPanel panel_2 = new JPanel();
		JPanel panel_2 = new gnRoundPanel();

		panel_2.setBounds(12, 40, 92, 139);
		hpanel1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblTerminal = new JLabel("Terminal");
		lblTerminal.setBounds(12, 13, 71, 16);
		panel_2.add(lblTerminal);
		lblTerminal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTerminal.setForeground(new Color(0, 0, 102));
		lblTerminal.setFont(new Font("Cambria", Font.BOLD, 14));

		terminal = new JTextField();
		terminal.setBounds(11, 30, 63, 22);
		panel_2.add(terminal);
		terminal.setForeground(new Color(102, 0, 102));
		terminal.setBackground(Color.WHITE);
		terminal.setEditable(false);
		terminal.setColumns(10);

		JLabel lblCashier = new JLabel("Cashier ");
		lblCashier.setBounds(14, 52, 69, 16);
		panel_2.add(lblCashier);
		lblCashier.setForeground(new Color(0, 0, 102));
		lblCashier.setFont(new Font("Cambria", Font.BOLD, 14));
		lblCashier.setHorizontalAlignment(SwingConstants.LEFT);

		shift = new JTextField();
		shift.setBounds(10, 69, 64, 22);
		panel_2.add(shift);
		shift.setForeground(new Color(102, 0, 102));
		shift.setBackground(Color.WHITE);
		shift.setEditable(false);
		shift.setColumns(10);

		JLabel lblShit = new JLabel("Shit");
		lblShit.setBounds(12, 93, 71, 16);
		panel_2.add(lblShit);
		lblShit.setBackground(new Color(0, 0, 102));
		lblShit.setForeground(new Color(0, 0, 102));
		lblShit.setFont(new Font("Cambria", Font.BOLD, 14));
		lblShit.setHorizontalAlignment(SwingConstants.LEFT);

		cashier = new JTextField();
		cashier.setBounds(10, 110, 64, 22);
		panel_2.add(cashier);
		cashier.setForeground(new Color(102, 0, 102));
		cashier.setBackground(Color.WHITE);
		cashier.setEditable(false);
		cashier.setColumns(10);
		cashier.setText(vcashier);

		btnSave.setVisible(false);

		ActionListener cm1 = new lscombo();
		comboRtype.addActionListener(cm1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new MatteBorder(3, 3, 7, 3, (Color) new Color(102, 255, 204)));
		panel_1.setBounds(12, 205, 1310, 93);
		frameSalesReturn.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		ActionListener save = new lsBtn();
		ActionListener a1 = new lsBtn();

		// IteamScanPanel = new JPanel();
		IteamScanPanel = new gnRoundPanel();

		IteamScanPanel.setBackground(Color.WHITE);
		IteamScanPanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		IteamScanPanel.setBounds(8, 5, 651, 77);
		panel_1.add(IteamScanPanel);
		IteamScanPanel.setLayout(null);

		JLabel lblScanItem = new JLabel("Scan Item");
		lblScanItem.setBounds(17, 4, 64, 16);
		lblScanItem.setFont(new Font("Cambria", Font.BOLD, 14));
		IteamScanPanel.add(lblScanItem);

		// Scan_item = new JTextField()
		Scan_item = new gnRoundTextField(15);
		Scan_item.setBounds(12, 28, 135, 29);
		IteamScanPanel.add(Scan_item);
		Scan_item.setColumns(10);
		ActionListener itemscan = new lsnrItemScan();
		Scan_item.addActionListener(itemscan);
		ActionListener itemsearch = new lsItemNameimplements();
		Scan_item.setBackground(Color.WHITE);

		JLabel lblSearchByName = new JLabel("Search by Name");
		lblSearchByName.setBounds(162, 4, 107, 16);
		lblSearchByName.setFont(new Font("Cambria", Font.BOLD, 14));
		IteamScanPanel.add(lblSearchByName);

		// Itemname = new JTextField();
		Itemname = new gnRoundTextField(10);
		Itemname.setBounds(162, 28, 234, 29);
		IteamScanPanel.add(Itemname);
		Itemname.setColumns(10);
		Itemname.addActionListener(itemsearch);
		Itemname.setBackground(Color.WHITE);

		btnReturnCash = new JButton("Return Cash");
		btnReturnCash.setBounds(398, 24, 116, 33);
		IteamScanPanel.add(btnReturnCash);
		btnReturnCash.setMnemonic('R');
		btnReturnCash.setFont(new Font("Cambria", Font.BOLD, 15));
		btnReturnCash.setForeground(Color.BLACK);
		btnReturnCash.setToolTipText("System will allow to return cash to customer");

		btnGenerateCn = new JButton("Generate CN");
		btnGenerateCn.setBounds(512, 24, 127, 33);
		IteamScanPanel.add(btnGenerateCn);
		btnGenerateCn.setMnemonic('G');
		btnGenerateCn.setFont(new Font("Cambria", Font.BOLD, 15));
		btnGenerateCn.setForeground(Color.BLACK);
		btnGenerateCn.setToolTipText("System will Generate Credit note for Sales Return Amount");
	 
		ActionListener a2 = new lsBtn();

		sjsp = new JScrollPane();
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(0, 0, 1072, 141);

		jsp = new JScrollPane();
		jsp.setBounds(12, 327, 1308, 215);
		frameSalesReturn.getContentPane().add(jsp);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JViewport prt = new JViewport();
		prt.add(table);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		prt.setBackground(Color.white);
		jsp.setViewport(prt);

		btnBatch = new JButton("Batch Details");
		btnBatch.setBounds(904, 294, 103, 33);
		frameSalesReturn.getContentPane().add(btnBatch);
		btnBatch.setMnemonic('B');
		btnBatch.setFont(new Font("Calibri", Font.BOLD, 13));
		btnBatch.setBackground(Color.CYAN);
		btnBatch.setEnabled(true);

		btnPrint = new JButton("Print");
		btnPrint.setBounds(1008, 294, 97, 33);
		frameSalesReturn.getContentPane().add(btnPrint);
		btnPrint.setMnemonic('P');
		btnPrint.setFont(new Font("Calibri", Font.BOLD, 13));
		btnPrint.setBackground(Color.CYAN);

		btnAcEntry = new JButton("Account Entry");
		btnAcEntry.setBounds(1105, 294, 128, 33);
		frameSalesReturn.getContentPane().add(btnAcEntry);
		btnAcEntry.setFont(new Font("Calibri", Font.BOLD, 13));
		btnAcEntry.setMnemonic('A');

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(1235, 294, 85, 33);
		frameSalesReturn.getContentPane().add(btnCancel);
		btnCancel.setMnemonic('C');
		btnCancel.setFont(new Font("Calibri", Font.BOLD, 13));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameSalesReturn.dispose();
			}
		});
		btnCancel.setBackground(Color.CYAN);
		btnAcEntry.addActionListener(save);
		btnPrint.addActionListener(save);
		btnBatch.setVisible(true);
		btnBatch.addActionListener(save);
		prt.setVisible(true);

		/*
		 * leftPanel = new JPanel(); leftPanel.setBorder( new TitledBorder(null,
		 * "Enter Search Text", TitledBorder.LEADING, TitledBorder.TOP, null,
		 * null)); leftPanel.setBackground(new Color(255, 250, 240));
		 * leftPanel.setBounds(1, 250, 149, 266); leftPanel.setLayout(null);
		 * 
		 * quickSearch = new JTextField(); quickSearch.setVisible(false);
		 * quickSearch.setFont(new Font("Calibri", Font.BOLD, 14));
		 * quickSearch.setBounds(353, 29, 26, 27); leftPanel.add(quickSearch);
		 * quickSearch.setColumns(10);
		 * 
		 * ajsp = new JScrollPane();
		 * ajsp.setVerticalScrollBarPolicy(ScrollPaneConstants.
		 * VERTICAL_SCROLLBAR_ALWAYS); ajsp.setBounds(8, 59, 371, 401);
		 * leftPanel.add(ajsp);
		 * 
		 * mySplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel,
		 * jsp); mySplit.setOneTouchExpandable(true); mySplit.setSize(1300,
		 * 462); mySplit.setLocation(0, 187); mySplit.setDividerLocation(380);
		 * 
		 * frameSalesReturn.getContentPane().add(mySplit);
		 */

		KeyListener keyls = new keyLsnr();
  		btnSave.addActionListener(save);
		btnEdit.addActionListener(save);
		btnShow.addActionListener(save);
		btnGenerateCn.addActionListener(a2);
		btnReturnCash.addActionListener(a1);
		decorate();

	}

	public void decorate() throws Throwable {

		frameSalesReturn.setUndecorated(true);

		this.checkInternet();
		chekcFreezeYear();
	 	btnEdit.setVisible(false);
		Itemname.setText("s");
		showname();
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		finyear.setText(new gnFinYear().getReportingFinYear());
		vfinyear = finyear.getText();
		vallow = new gnDate().checkDayBegin();
		switch (vallow) {
		case "Y":
			String paravalue = "";
			int typeno = 1;
			new gnDecorate().SetSeqHdrButton(btnGenerateCn, typeno);
			new gnDecorate().SetSeqHdrButton(btnReturnCash, typeno);
			new gnDecorate().SetSeqHdrButton(btnAcEntry, typeno);
			new gnDecorate().SetSeqHdrButton(btnBatch, typeno);
			new gnDecorate().SetSeqHdrButton(btnCancel, typeno);
			new gnDecorate().SetSeqHdrButton(btnPrint, typeno);
			new gnDecorate().SetSeqHdrButton(btnAcEntry, typeno);
			new gnDecorate().SetSeqHdrButton(btnBatch, typeno);
			new gnDecorate().SetSeqHdrButton(btnCancel, typeno);
			new gnDecorate().SetSeqHdrButton(btnPrint, typeno);

			// frameSalesReturn.setUndecorated(true);

			new gnApp().setFrameTitel(frameSalesReturn);
			new gnField().showInventory(btnCancel, "INV");
			new gnField().showCalc(btnCancel, "CAL");
			delTableRow(table, model, "SR");
			new gnField().moveDown(table);
			new gnField().closeform(table, frameSalesReturn);

			vcomp = (new gnConfig().getCompanyCode());
			String vcompname = (new gnConfig().getCompany());
			storecode.setText(new gnConfig().getStoreID());
			switch (vcomp) {
			case "0":
				System.exit(0);
			}

			terminal.setText(new gnConfig().getTerminalID());
			int vterminal = Integer.parseInt(terminal.getText());
			returndate.setText(new gnConfig().getDaybeginDate());

			String vtype = "SR";
			String vallowDate = new gnDate().checkBackDateTrAllow(vtype, returndate.getText());
			switch (vallowDate) {
			case "N":
				// btnEdit.setVisible(false);
				returndate.setBackground(Color.RED);
				returndate.setForeground(Color.WHITE);
				new General().msg("Back Date For Transaction is not Allow..");
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				returndate.setText("?");
				Scan_item.setVisible(false);
				Itemname.setVisible(false);
				break;
			}
			String vdate = returndate.getText();
			cashier.setText(new gnConfig().getUserCode());
			String vcashier = cashier.getText();
			shift.setText(new gnConfig().getCashierShift(vcomp, vstore, vdate, vterminal, vcashier));
			// shift.setText((new
			// gnConfig().getCashierShift(Site_code.getText(), invdate.getText()
			// , vterminal , vvcashiercode)));
			vcomp = new gnConfig().getCompanyCode();
			vverticle = new gnHierarchy().getVerticleCode();
			String vpara501 = "501";
			new getConfigurationSetting().setBtnConfig(btnReturnCash, vpara501);
			String vpara502 = "502";
			new getConfigurationSetting().setBtnConfig(btnGenerateCn, vpara502);
			// Set Configuration//
			break;
		case "N":
			break;
		}

	}

	private void chekcFreezeYear() {
		switch (isFinyearFreeze) {
		case "Y":
			btnEdit.setVisible(false);
			btnSave.setVisible(false);
			btnGenerateCn.setVisible(false);
			btnReturnCash.setVisible(false);
			// btnUpdate.setVisible(false);
			// btnAcEntry.setVisible(false);
			// btnPrint.setVisible(false);
			new General().msg("Accounting Year is Freezeed..You Can View Data Only..");
			break;
		}
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
		public void keyPressed(KeyEvent arg0) {
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			try {
				FillArticle();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void FillArticle() throws ClassNotFoundException, SQLException {

		new gnTable().RemoveTableRows(Articlemodel);
		String sname = quickSearch.getText();
		sname = "%" + sname + "%";
		String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + ")";
		String ArticleCol[] = { "Name", "Sales Price", "Article" };
		rs = this.getSPResult(SQL);
		Articlemodel.setColumnIdentifiers(ArticleCol);
		Articletable.setModel(Articlemodel);
		while (rs.next()) {
			Articlemodel.addRow(new Object[] { rs.getString(2), rs.getString(4), rs.getString(1), });
			Articletable.setModel(Articlemodel);
			Articletable.getCellRenderer(1, 1);
			// Articletable.setDefaultRenderer(Object.class, new posRenderer());
			new gnTable().setTableBasics(Articletable);
			new gnTable().setTablewidth(Articletable, 0, 150);
			Articletable.setCellSelectionEnabled(true);

			Articletable.setRowSelectionAllowed(true);
			new gnTable().setTableBasics(Articletable);
			Articletable.setRowHeight(27);
			Articletable.setGridColor(Color.gray);
			JViewport prt777 = new JViewport();
			prt777.setBackground(Color.CYAN);
			prt777.add(Articletable, ArticleCol);
			prt777.setVisible(true);
			ajsp.setViewport(prt777);
			Articletable.requestFocus();
			SelectArticlerow();
		}
	}

	public void SelectArticlerow() {
		Articletable.requestFocus();
		Articletable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		Articletable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = Articletable.getSelectedRow();
				String vtype = (String) Articletable.getValueAt(row, 2);
				String varticle = (String) Articletable.getValueAt(row, 2);
				try {
					showTableData(varticle, model);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					mySplit.setDividerLocation(380);
				}
				new General().msgDispose();
			}
		});
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
					int row = table.getSelectedRow();
					model.removeRow(row);
					Double v = new gnTable().getTotal(table, 11);
					Tamount.setText(Double.toString(v));
					table.setEditingRow(row);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/// Listeners
	class lscombo implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			String vcombovalue = (String) comboRtype.getSelectedItem();
			if (vcombovalue == "With Invoice Reference") {
				vcompType = "IR";
				new General().msg("Enter Invoice Number or Search Invoice Number");
				invno.setBackground(Color.CYAN);
				invno.setForeground(Color.BLUE);
				new gnTable().RemoveTableRows(model);
				new gnTable().RemoveTableRows(smodel);
				new gnTable().RemoveTableRows(pmodel);
				invno.setEnabled(true);
				invno.grabFocus();
				vendorcode.setEnabled(false);
				vendorname.setEnabled(true);
				// Scan_item.setEnabled(false);
				// Itemname.setEnabled(false);
				// Itemname.setBackground(Color.CYAN);
				// Scan_item.setBackground(Color.CYAN);
				// vendorcode.setBackground(Color.WHITE);
				// vendorname.setBackground(Color.WHITE);
				Scan_item.setText(null);
				Itemname.setText(null);
				Tamount.setText("0.00");
				paymentamt.setText("0.00");
			}
			if (vcombovalue == "Without Invoice Reference") {
				vcompType = "WIR";
				invno.setText("0");
				invdate.setText("0");
				Tamount.setText("0.00");
				paymentamt.setText("0.00");
				new gnTable().RemoveTableRows(model);
				new gnTable().RemoveTableRows(smodel);
				new gnTable().RemoveTableRows(pmodel);
				vendorcode.setText("0");
				vendorcode.setEnabled(false);
				vendorname.setEnabled(false);
				invno.setEnabled(false);
				invno.setBackground(Color.CYAN);
				Scan_item.setEnabled(true);
				Itemname.setEnabled(true);
				Itemname.setBackground(Color.WHITE);
				Scan_item.setBackground(Color.WHITE);
				vendorcode.setBackground(Color.CYAN);
				vendorname.setBackground(Color.CYAN);
				Scan_item.grabFocus();
			}
		}
	}
	/// without PO Reference

	class lsnrItemScan implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (vallow == "N") {
				frameSalesReturn.dispose();
				new General().msg("Complete Open Day Function First...");
			}
			// System.out.println("Value" + value);
			// System.out.println("Field id" + i);
			if (i == 1001) {
				try {
					Tamount.setText("0.00");
					paymentamt.setText("0.00");
					showTableData(value, model);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	/// without PO Reference

	public String showTableData(String value, DefaultTableModel model) throws Throwable {
		String action = "Insert";
		Object row[] = {};
		model.setColumnIdentifiers(Colitem);
		vfinyear = new gnFinYear().getReportingFinYear();
		String vtype = "SR";
		String vverticlecode = new gnHierarchy().getVerticleCode();
		switch (referInvoice) {
		case "N":
			String SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , " + value + ", " + vcomp + " , "
					+ vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
			rs = this.getSPResult(SQL);
			if (rs.next()) {

				// public String Colitem[] = { "X", "Item", "Name", "Inv Qty",
				// "Return Qty", "Rate", "MRP", "Gross", "Hdr Disc",
				// "Disc", "Tax", "Amount", "Taxcode", "Batch Item", "BatchNo",
				// "Exp.Date", "Cost", "location" };

				String vcalTaxamount = new gnMath()
						.get2DecimaltValue(Double.toString(Double.parseDouble(rs.getString(10)) * -1.00));
				model.insertRow(0,
						new Object[] { "X", rs.getString(1), rs.getString(2), 0,
								Double.parseDouble(rs.getString(3)) * -1, rs.getString(4), rs.getString(5),
								Double.parseDouble(rs.getString(6)) * -1, rs.getString(7), rs.getString(8),
								Double.parseDouble(rs.getString(9)) * -1, vcalTaxamount, rs.getString(11),
								rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
								rs.getString(16) });
				String vmsname = "Location";
				String vsearch = "%%";
				String SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticlecode + "  , '" + vsearch
						+ "')";
				table.getColumnModel().getColumn(17)
						.setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL1)));
				new gnTable().setTablewidth(table, 2, 300);
				String vbatchArticle = rs.getString(12);
				new gnGetBatch().resetValues();
				CheckBatchArticle(value, vbatchArticle);
			}
			table.setModel(model);
			removeRow(model, table);
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			Double itemtotal = new gnTable().getTotal(table, 11);
			Tamount.setText(Double.toString(itemtotal));
			new gnTable().setTableBasics(table);
			// selectedrow = table.getRowCount() - 1;
			selectedrow = 0; //
			table.setValueAt("NoLoc", selectedrow, 17);
			table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification7);
			table.setGridColor(Color.BLUE);
			table.getColumnModel().getColumn(2).setPreferredWidth(300);
			break;

		case "Y":
			showTable(value);
			break;
		}
		return "OK";

	} // ShowTableData

	public CellEditorListener ChangeNotification7 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (table.getValueAt(row, 4).toString());
			QtychangeImapct(value, row);
			// QtychangeWPO(value, row);
		}
	};

	public void QtychangeWPO(String value, int i) {
		String retqty1 = (String) table.getValueAt(i, 4).toString();
		Double curqty = Double.parseDouble(retqty1);
		new General().msg("Qty is " + curqty);
		Double vvamt = 00.00;
		Double Csp = Double.parseDouble((String) table.getValueAt(i, 5));
		Double Cemp_disc = Double.parseDouble(table.getValueAt(i, 8).toString());
		Double Cdisc = Double.parseDouble(table.getValueAt(i, 9).toString());
		Double vtax = new gnMath().get2DecimaltValue(Double.parseDouble(table.getValueAt(i, 12).toString())); // Tax
		// new General().msg("Tax Value" + vtax);

		if (curqty > 0) {
			Double newqty = curqty * -1;
			Double newgross = (newqty * Csp);
			Double newAmount = (newgross - Cdisc - Cemp_disc);
			Double newtax = new gnMath().CalTax_Sales(newAmount, vtax);

			new General().msg("new Qty is " + newqty);
			table.setValueAt(newqty, i, 4);
			table.setValueAt(newgross, i, 7);
			table.setValueAt(newAmount, i, 11);
			table.setValueAt(newtax, i, 10);
			Double iTotal = new gnTable().getTotal(table, 11);
			Tamount.setText(Double.toString(iTotal));
			table.getColumnModel().getColumn(2).setPreferredWidth(300);
		}

		if (curqty < 0) {
			Double newqty = curqty;
			Double newgross = (newqty * Csp);
			Double newAmount = (newgross - Cdisc - Cemp_disc);
			// Double newtax = (newAmount*vtax/100) ;
			Double newtax = new gnMath().CalTax_Sales(newAmount, vtax);
			table.setValueAt(newqty, i, 4);
			table.setValueAt(newgross, i, 7);
			table.setValueAt(newAmount, i, 11);
			table.setValueAt(newtax, i, 10);
			Double iTotal = new gnTable().getTotal(table, 11);
			Tamount.setText(Double.toString(iTotal));
			table.getColumnModel().getColumn(2).setPreferredWidth(300);
		}

	}
	/// End Without PO reference

	public void showTable(String value) throws Exception {

		model.setColumnIdentifiers(Colitem);
		table.setModel(model);
		removeRow(model, table);
		new gnTable().setTableBasics(table);
		new gnTable().setTableColWidth(table, 2, 300);
		//mySplit.setDividerLocation(0);
		String vinvno = invno.getText();
		String vinvdate = new gnConfig().date_ConverttoDBforamt(invdate.getText());
		String SQL = "Call  SR_getInvDetails1( '" + vinvno + "'  , '" + vinvdate + "', '" + value + "' ,   " + vstore
				+ " , " + vcomp + " )";
		rs1 = this.getSPResult(SQL);
		while (rs1.next()) {
			// new General().msg("yes item found .. "+ " "+ rs1.getString(1));
			model.insertRow(0,
					new Object[] { "X", rs1.getString(1), rs1.getString(2), 0,
							Double.parseDouble(rs1.getString(3)) * -1, rs1.getString(4), rs1.getString(5),
							Double.parseDouble(rs1.getString(6)) * -1, rs1.getString(7), rs1.getString(8),
							Double.parseDouble(rs1.getString(9)) * -1, Double.parseDouble(rs1.getString(10)) * -1,
							rs1.getString(11), rs1.getString(12), rs1.getString(13), rs1.getString(14),
							rs1.getString(15), rs1.getString(16) });
			table.setEditingColumn(4);
			String vmsname = "Location";
			String verticle = new gnHierarchy().getVerticleCode();
			String vsearch = "%%";
			String SQL1 = "call master_getMasterData('" + vmsname + "'  , " + verticle + "  , '" + vsearch + "')";
			table.getColumnModel().getColumn(17).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL1)));
			table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification870);
			table.setValueAt("NoLoc", selectedrow, 17);
			QtychangeImapct(value, 0);
			// QtychangeWPO(value, 0);
			rs1.close();
		}
		if (!rs1.next()) {
			new General().msg("Article not found in given invoice please check invoice press on show Button..");
		}

	}

	public CellEditorListener ChangeNotification870 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 1);
			QtychangeImapct(value, row);
		}
	};

	// nk
	public void QtychangeImapct(String value, int i) {
		String retqty1 = (String) table.getValueAt(i, 4).toString();
		Double curqty = Double.parseDouble(retqty1);
		Double vvamt = 00.00;
		Double Csp = Double.parseDouble((String) table.getValueAt(i, 5));
		Double Cemp_disc = Double.parseDouble(table.getValueAt(i, 8).toString());
		Double Cdisc = Double.parseDouble(table.getValueAt(i, 9).toString());
		Double vtax = Double.parseDouble(table.getValueAt(i, 12).toString()); // Tax
		if (curqty >= 1) {
			Double newqty = (Double) ((curqty) * -1);
			Double newgross = (newqty * Csp);
			Double newAmount = (newgross - Cdisc - Cemp_disc);
			// Double newtax = (newAmount*vtax/100) ;
			Double newtax = new gnMath().CalTax_Sales(newAmount, vtax);

			table.setValueAt(newqty, i, 4);
			table.setValueAt(newgross, i, 7);
			table.setValueAt(newAmount, i, 11);
			table.setValueAt(newtax, i, 10);
			Double iTotal = new gnTable().getTotal(table, 11);
			Tamount.setText(Double.toString(iTotal));
			table.getColumnModel().getColumn(2).setPreferredWidth(300);
		}

		if (curqty < 0) {
			Double newqty = (Double) ((curqty));
			Double newgross = (newqty * Csp);
			Double newAmount = (newgross - Cdisc - Cemp_disc);
			// Double newtax = (newAmount*vtax/100) ;
			Double newtax = new gnMath().CalTax_Sales(newAmount, vtax);

			table.setValueAt(newqty, i, 4);
			table.setValueAt(newgross, i, 7);
			table.setValueAt(newAmount, i, 11);
			table.setValueAt(newtax, i, 10);
			Double iTotal = new gnTable().getTotal(table, 11);
			Tamount.setText(Double.toString(iTotal));
			table.getColumnModel().getColumn(2).setPreferredWidth(300);
		}

	}
	// End with invoice Reference

	public String CheckBatchControlArticle() {
		String Action = "Sucess";
		int rw = table.getRowCount();
		String vbatch = " ";
		String vExp = "";
		String vbatchno = " ";
		String varticle = "";
		for (int k = 0; k < rw; k++) {
			vbatch = table.getValueAt(k, 13).toString();
			vExp = table.getValueAt(k, 15).toString();
			vbatchno = table.getValueAt(k, 14).toString();
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

	// Start for with invoice Reference
	class lsinv implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vinv = invno.getText().trim();
			String vstorecode = storecode.getText();
			String SQL = "Call SR_getInvDetails(" + vinv + " , " + vstorecode + ", " + vcomp + ")";
			try {
				showTable(SQL);
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
				e1.printStackTrace();
			}
		}
	}

	class lsItemNameimplements implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			showname();
		}
	}

	private void showname() {
		String sname = Itemname.getText();
		sname = "%" + sname + "%";
		String vtrantype = "SalesReturn";
		String vType = "Article";
		try {
			// new gnAdmin().Search(vType, sname, varticle1 , vtrantype ) ;
			mySplit.setDividerLocation(300);
			leftPanel.setVisible(true);
			quickSearch.setText(Itemname.getText());
			FillArticle();
		} catch (Throwable e1) {
			new General().msg(e1.getMessage());
			;
		} finally {
			try {
				showTableData(varticle1, model);
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				new General().msg(e1.getMessage());
			}
		}

	}

	class lssupl implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			String vname = vendorname.getText();
			vname = "%" + vname + "%";
			String vstore;
			try {
				vstore = new gnConfig().getStoreID();
				String sql1 = "call SR_getcustomerInvoice('" + vname + "' , " + vcomp + ", " + vstore + ")";
				showcustomer(sql1);
			} catch (Throwable e2) {
				e2.printStackTrace();
				new General().msg(e2.getMessage());
			}
			try {
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			}
		}
	}

	class lsBtn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);

			if (value == "Edit Document") {
				try {
					startEditProccess();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Batch Details") {
				try {
					showBatchDetails();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Return Cash") {
				int tableRow = table.getRowCount();
				if (tableRow == 0) {
					new General().msg("No Data Selected <Select Article for Sales Return First>");
				} else {
					choice = "Cash";
					String vtype = "Cash";
					String vcnno = "0";
					String vamt = Tamount.getText();
					insertIntable(vtype, vamt, vcnno);
				}
			}

			if (value == "Generate CN") {
				choice = "CN";
				int tableRow = table.getRowCount();
				if (tableRow == 0) {
					new General().msg("No Data Selected <Select Article for Sales Return First>");
				} else {
					String vstorecode = storecode.getText();
					Scan_item.setEnabled(false);
					invno.setEnabled(false);
					String vtype = "CN";
					String vcnno;
					String vamt = Tamount.getText();
					try {
						if (EditMode == "N") {
							vcnno = new gnSeq().getSeqno("101", "TR");
							insertIntable(vtype, vamt, vcnno);
						}
						if (EditMode == "Y") {
							vcnno = "0";
							vtype = "EditCN";
							insertIntable(vtype, vamt, vcnno);
						}

					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
			}

			if (value == "Account Entry") {

				String vtype = "SR";
				String vdocno = SRno.getText();
				String vdocdate = returndate.getText();
				try {
					if (vdocno.length() > 0) {
						new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);
					}
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Show") {
				String vbillno = invno.getText();
				String vbilldate = null;
				try {
					vbilldate = invdate.getText();
					new gnSale().showinvoice(vbillno, vbilldate);
				} catch (ClassNotFoundException | SQLException e2) {
					e2.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Save") {
				String status = validate();
				if (status == "Sucess") {
					invno.setEnabled(false);
					// table.setEnabled(false) ;
					try {
						prepareToInsert();
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().msg(e1.getLocalizedMessage());
					}
				}
			}

			if (value == "Print") {
				try {
					String vtype = "SR";
					String vdocno = SRno.getText();
					String vdocdate = returndate.getText();
					if (vdocno.length() > 0) {
						callPrint();
					}
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Cancel") {
				frameSalesReturn.dispose();
			}
		}
	}

	public void startEditProccess() throws Throwable {
		btnEdit.setBackground(Color.GREEN);
		EditMode = "Y";
		chekcFreezeYear();
		String vinvtype = "SR";
		String vcustcode = vendorcode.getText();
		new gnSale().get_invnoForcustomer(vinvtype, vcustcode);
		showSR();
	}

	public void showSR() throws Throwable {
		btnEdit.setBackground(Color.blue);
		EditMode = "Y";
		// vallow= "Y";
		returndate.setText(new gnSale().rinvdate);
		SRno.setText(new gnSale().rinvno);
		vendorcode.setText(new gnSale().rcustcode);
		new gnSupplier().setScanSupplier(vendorcode, vendorname, vendorcode.getText());
		String vtype = "SR";
		String vdocno = SRno.getText();
		String vdocdate = new gnConfig().date_ConverttoDBforamt(returndate.getText());
		String SQL = "Call Doc_getEditData(" + vcomp + " , " + vstore + " , " + vdocno + ", '" + vdocdate + "' , '"
				+ vfinyear + "', '" + vtype + "')";
		showEditTableData(SQL, model);
		vtype = "CN";
		String SQL1 = "Call Doc_getEditData(" + vcomp + " , " + vstore + " , " + vdocno + ", '" + vdocdate + "' , '"
				+ vfinyear + "', '" + vtype + "')";
		rs = this.getSPResult(SQL1);
		if (!rs.next()) {
			canIssueCN = "Y";
			canIssueCash = "Y";
		} else {
			rs.first();
			String vpmtType = rs.getString(1);
			String vvamt = rs.getString(6);
			String vcnno = rs.getString(4);

			pmodel.setColumnIdentifiers(pcol);
			pmodel.addRow(new Object[] { vpmtType, vvamt, vcnno });
			paymentamt.setText(vvamt);
			ptable.setModel(pmodel);
			prt5 = new JViewport();
 			prt5.add(ptable, pcol);
			pjsp.setViewport(prt5);
			pjsp.repaint();

			switch (vpmtType) {
			case "CN":
				btnReturnCash.setEnabled(false);
				btnGenerateCn.setEnabled(true);
				canIssueCN = "Y";
				canIssueCash = "N";
				break;
			case "Cash":
				canIssueCN = "Y";
				canIssueCash = "Y";
				btnReturnCash.setEnabled(true);
				btnGenerateCn.setEnabled(false);
				break;
			}
		}
	}

	public String showEditTableData(String SQL, DefaultTableModel model) throws Throwable {
		String action = "Insert";
		Object row[] = {};
		model.setColumnIdentifiers(Colitem);
		table.setModel(model);
		table.setEditingColumn(4);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "Del", rs.getString(1), rs.getString(2), 0, Double.parseDouble(rs.getString(3)),
					rs.getString(4), rs.getString(5), Double.parseDouble(rs.getString(6)), rs.getString(7),
					rs.getString(8), Double.parseDouble(rs.getString(9)), Double.parseDouble(rs.getString(10)),
					rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
					rs.getString(16) });
			table.setModel(model);
			String vmsname = "Location";
			String verticle = new gnHierarchy().getVerticleCode();
			String vsearch = "%%";
			String SQL1 = "call master_getMasterData('" + vmsname + "'  , " + verticle + "  , '" + vsearch + "')";
			table.getColumnModel().getColumn(17).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL1)));
			Double itemtotal = new gnTable().getTotal(table, 11);
			Tamount.setText(Double.toString(itemtotal));
			new gnTable().setTableBasics(table);
			selectedrow = table.getRowCount() - 1;
			String vbatchArticle = rs.getString(12);
			new gnGetBatch().resetValues();
			new gnTable().setTablewidth(table, 2, 300);
			removeRow(model, table);
			table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification7);
			table.setGridColor(Color.BLUE);
		}
		this.closeconn();
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.setBackground(Color.white);
		prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(table, Col);
		prt.setBackground(Color.WHITE);
		jsp.setViewport(prt);
		prt.setVisible(true);
		return "OK";
	} // ShowTableData

	public String validate() {
		String status = "Sucess";
		int tableRow = table.getRowCount();
		if (tableRow == 0) {
			new General().msg("No Data Selected <Select Article for Sales Return First>");
			status = "Fail";
		}

		/*
		 * String vloc = table.getValueAt(tableRow, 17).toString() ; new
		 * General().msg(vloc); if (vloc == "NoLoc") { new General().msg(
		 * "Please Select Proper Location.."); status = "Fail"; }
		 */

		if (Double.parseDouble(Tamount.getText()) == 0.00) {
			new General().msg("No Return Qty Please check Return Qty..");
			status = "Fail";

		}
		status = CheckBatchControlArticle();

		Double vpmt = Double.parseDouble(paymentamt.getText().trim());
		Double vSRamt = Double.parseDouble(Tamount.getText().trim());
		double diff = vSRamt + vpmt;
		if (diff != 0.00) {
			new General().msg("Check Sales Return amount and Payment is not Matching..");
			status = "Fail";
		}
		return status;
	}

	public void callPrint() throws Throwable {
		// new General().msg("Printing Crediit Note ...");
		String vinvno = SRno.getText();
		if (ptable.getRowCount() > 0) {
			if (ptable.getValueAt(0, 0).toString() == "CN") {
				String doctype = "CN";
				new gnDocPrint().callprint(doctype, vinvno, returndate.getText());
			}
		}
		return;
	}

	public void insertIntable(String vpmtType, String vamt, String vcnno) {
		ptable.setEnabled(false);

		if (vpmtType == "EditCN") {
			Double vvamt = Double.parseDouble(vamt);
			vvamt = vvamt * -1;
			paymentamt.setText(Double.toString(vvamt));
			ptable.setValueAt(vvamt, 0, 1);
		}

		if (vpmtType == "CN") {
			Double vvamt = Double.parseDouble(vamt);
			vvamt = vvamt * -1;
			// vvamt = vvamt ;
			new gnTable().RemoveTableRows(pmodel);
			pmodel.setColumnIdentifiers(pcol);
			pmodel.addRow(new Object[] { vpmtType, vvamt, vcnno });
			paymentamt.setText(Double.toString(vvamt));
			ptable.setModel(pmodel);
			prt5 = new JViewport();
 			prt5.add(ptable, pcol);
			pjsp.setViewport(prt5);
			// prt5.setVisible(true);
			pjsp.repaint();

		}

		if (vpmtType == "Cash") {
			new gnTable().RemoveTableRows(pmodel);
			Double vvamt = Double.parseDouble(vamt);
			vvamt = vvamt * -1;
			pmodel.setColumnIdentifiers(pcol);
			pmodel.addRow(new Object[] { vpmtType, vamt, vcnno });
			paymentamt.setText(Double.toString(vvamt));
		}
		ptable.setModel(pmodel);
		prt5 = new JViewport();
 		prt5.add(ptable, pcol);
		pjsp.setViewport(prt5);
 		pjsp.repaint();
		new gnTable().setTableColWidth(table, 1, 300);
		int option = new General().msgInput("Save Transaction");
		if (option == 1) {
			paymentamt.setText("0.00");
			new gnTable().RemoveTableRows(pmodel);
		}
		if (option == 0) {
			btnSave.doClick();
		}
	}

	public void showcustomer(String SQL) throws Exception {
		rs = this.getSPResult(SQL);
		new gnTable().RemoveTableRows(smodel);
		while (rs.next()) {
			smodel.setColumnIdentifiers(cus);
			smodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5) });
			stable.setModel(smodel);
		}
		prt7 = new JViewport();
		prt7.setBackground(Color.CYAN);
		prt7.add(stable, pcol);
		new gnTable().setTableBasics(stable);
		sjsp.setViewport(prt7);
		prt7.setVisible(true);
		new gnTable().setTableColWidth(stable, 1, 300);
		sjsp.setPreferredSize(new Dimension(800, 500));
		jsp.setBorder(null);
		Selectrow();
	}

	public void Selectrow() {
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = stable.getSelectedRow();
				String value = (String) stable.getValueAt(row, 2);
				String vstorecode = storecode.getText();
				vendorcode.setText((String) stable.getValueAt(row, 0));
				vendorname.setText((String) stable.getValueAt(row, 1));
				invno.setText((String) stable.getValueAt(row, 2));
				try {
					invdate.setText(new gnConfig().Date_convertToApplformat(stable.getValueAt(row, 3).toString()));
				} catch (ClassNotFoundException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				referInvoice = "Y";
				// Old logic to display all items of invoice now this approach
				// is not used rather article of invoice will get sacan
				// new SP is SR_getInvDetails1
				// String SQL = "Call SR_getInvDetails(" + value + " , " +
				// vstorecode + ", " + vcomp + ")";
				// new General().msg(SQL);
				try {
					// showTable(SQL);
					new General().msgDispose();
					// stable.notify();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Data ", 800, 500);
		// new gnTable().setTableColWidth(stable, 1, 250);

	}

	/// ARticle Name Search
	public void showArticle(String SQL) throws Exception {
		rs = this.getSPResult(SQL);
		new gnTable().RemoveTableRows(smodel);
		while (rs.next()) {
			smodel.setColumnIdentifiers(ACol);
			smodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
			stable.setModel(smodel);
		}
		prt7 = new JViewport();
		prt7.setBackground(Color.CYAN);
		prt7.add(stable, pcol);
		sjsp.setViewport(prt7);
		prt7.setVisible(true);
		new gnTable().setTableColWidth(stable, 1, 300);
		stable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification19);
		new General().msgsearch(sjsp, stable, "Select Article  For Sales Return", 400, 400);

	}

	public CellEditorListener ChangeNotification19 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = stable.getSelectedRow();
			String value = (String) stable.getValueAt(row, 0);
			try {
				showTableData(value, model);
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	// End ARticle Name SEarch

	public void removeRow(DefaultTableModel xmodel, JTable xtable) {
		// new General().msg("I REached Here ") ;
		DefaultTableModel modelName = xmodel;
		JTable tableName = xtable;
		TableColumn Del = tableName.getColumnModel().getColumn(0);
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
				if (nn == 2 && modelName == model) {
					int lastrow = tableName.getRowCount();
					int r = tableName.getSelectedRow();
					int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
					if (option == 0) {
						modelName.removeRow(r);
						Double v = new gnTable().getTotal(xtable, 11);
						Tamount.setText(Double.toString(v));
					}
					return;
				}
			}
		});

	}

	private void calculateGSTReturnData() throws Throwable {
		// new General().msg("GST DAta insert now");
		String vdocno = SRno.getText();
		String vmethod = "SRRegular";
		String vsalestype = "SR";
		String vdoctype = "Cash-SR";
		String vdocdate = returndate.getText();
		String vparty = vendorcode.getText();
		Double vtam = Double.parseDouble(Tamount.getText()) * -1;
		String vamount = Double.toString(vtam);
		String vchoice = choice;

		String inv = reduceInv();

		switch (PostGST_accountEntryAtSaveTime) {
		case "Y":
			new gnGSTMiddleWare().backend_DocgstSRprocess(vparty, vdocno, vdocdate, vamount, vchoice);
			switch (choice) {
			case "CN":
				vdocno = (String) ptable.getValueAt(0, 2);
				new gnGSTMiddleWare().gstCreditnoteProcess(vparty, vdocno, vdocdate, vamount);
				break;
			}
		}
	}

	public void prepareToInsert() throws Throwable {
		vvsitecode = storecode.getText();
		vvcompnaycode = new gnConfig().getCompanyCode();
		vterminal = Integer.parseInt(terminal.getText());
		if (EditMode == "N") {
			SRno.setText(new gnSeq().getSeqno("10", "TR"));
			vglcode = new gnSeq().getGlcode("10", "TR");
		}
		vglcode = new gnSeq().getGlcode("10", "TR");
		vvinvno = Integer.parseInt(SRno.getText());
		Svinvdate = new gnConfig().date_ConverttoDBforamt(returndate.getText());
		vvcashiercode = cashier.getText();
		vvsales_type = "SR";
		vvinvoice_type = "RI";
		vvposting_type = "Y";
		vvcustid = Integer.parseInt(vendorcode.getText());
		vshift = Integer.parseInt(shift.getText());
		vvggross = 0.00;
		vvdisc = 0.00;
		vvnet = Double.parseDouble(Tamount.getText());
		String dncn = "Fail";

		// GST
		vmygstno = new gnGST().getComanyGSTno();
		vmycompanystate = new gnGST().getmyState();
		vmystatename = new gnGST().getmystatename();
		vmyCompanyisGST = new gnGST().ismyComanyGSTRegister();

		String vcustcode = vendorcode.getText();
		switch (vcustcode) {
		case "0":
			vstate = vmycompanystate;
			vstatename = vmystatename;
			vregdlr = "N";
			vcustGSTno = "0";
			break;
		default:
			vstate = new gnGST().getCustomerState(vendorcode.getText());
			vstatename = new gnGST().getCustomerStatename(vendorcode.getText());
			vregdlr = new gnGST().isCustmoerGSTRegister(vendorcode.getText());
			vcustGSTno = new gnGST().getCustomerGSTNO(vendorcode.getText());
			break;
		}

		vstate = vstate.trim();
		vmycompanystate = vmycompanystate.trim();
		vmy = Integer.parseInt(vmycompanystate.trim());
		voth = Integer.parseInt(vstate.trim());

		if (vmy - voth == 0) {
			vmovtype = "Intra-State";
		}

		if (vmy - voth != 0) {
			vmovtype = "Inter-State";
		}
		// End GST Field

		insertintoGLmaster();

		switch (EditMode) {
		case "Y":
			String vinvtype = "SR";
			new gnEDMiddleWare().SRModification(vinvtype, SRno.getText(), returndate.getText());
			if (ptable.getRowCount() > 0) {
				String vvtype = ptable.getValueAt(0, 0).toString();
				String cnno = ptable.getValueAt(0, 2).toString();
				String cndate = returndate.getText();
				switch (vvtype) {
				case "CN":
					new gnEDMiddleWare().CNModification(vvtype, cnno, cndate);
					break;
				}
			}
			insertPosDetails();
			break;

		case "N":
			insertPosDetails();
			break;
		}
	}

	private void insertintoGLmaster() throws Throwable {
		String vglcode = vendorcode.getText();
		String vglname = vendorname.getText();
		String vtype = "N";
		new gnAccountbase().insertGlData(vglcode, vglname, vtype);
	}

	//// pos Details Start here
	public String insertPosDetails() throws Throwable {
		// new General().msg("Pos Sales Detail insert Start now");
		prst = null;
		final int batchSize = 25;
		int TotalRecordinsert = 0;
		// new General().msg("Inserting detail Data ...");
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		String poshdr = "Insert into pos_sales_detail (company_code ," + "site_code, " + " invDate ," + "invno,"
				+ "Article_code ," + "EAN ," + "customer_code ," + "qty," + "sales_price," + "MRP," + "Taxcode,"
				+ "Gross_amount, " + "Disc," + "hdr_disc ," + "net_amount , " + "Tax_amount , " + "Promo_ind,"
				+ "promo_code," + "line_seq," + "CreatedBy, "
				+ "Insert_status, Cashier_code, Terminal_ID, shift , srno, sales_type, verticle, location , "
				+ "batch_article, cost , tax_per ,batch_no, expiry_date, emp_disc, "
				+ "state, statename, regdealer, mycompanyisgst, mygstno, "
				+ "mycompState, custGSTno , cgst, sgst, igst , movementType, "
				+ "TaxableValue , mystatename, finyear, cogs)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?, ?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,?,?,? ,?,?) ";
		prst = con1.prepareStatement(poshdr);
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				Double vqty = Double.parseDouble(table.getValueAt(k, 4).toString());
				if (vqty < 0) {
					pd_seq = k + 1;
					prst.setString(1, vvcompnaycode);
					prst.setString(2, vvsitecode);
					prst.setString(3, Svinvdate);
					prst.setInt(4, vvinvno);
					prst.setString(5, table.getValueAt(k, 1).toString());
					prst.setString(6, "0");
					prst.setInt(7, vvcustid);
					prst.setDouble(8, Double.parseDouble(table.getValueAt(k, 4).toString()));
					prst.setDouble(9, Double.parseDouble(table.getValueAt(k, 5).toString()));
					prst.setDouble(10, Double.parseDouble(table.getValueAt(k, 6).toString()));
					prst.setString(11, (table.getValueAt(k, 12).toString()));
					prst.setDouble(12, Double.parseDouble(table.getValueAt(k, 7).toString()));
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
					prst.setString(26, vvsales_type);
					prst.setString(27, vverticle);
					prst.setString(28, (table.getValueAt(k, 17).toString()));
					prst.setString(29, (table.getValueAt(k, 13).toString()));
					prst.setString(30, (table.getValueAt(k, 16).toString()));
					prst.setString(31, (table.getValueAt(k, 12).toString()));
					prst.setString(32, (table.getValueAt(k, 14).toString()));
					prst.setString(33, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 15).toString()));
					prst.setString(34, "0");
					// + "state, statename, regdealer, mycompanyisgst, mygstno,
					// mycompState, custGSTno , cgst, sgst, igst , movementType,
					// TaxableValue)"
					prst.setString(35, vstate);
					prst.setString(36, vstatename);
					prst.setString(37, vregdlr);
					prst.setString(38, vmyCompanyisGST);
					prst.setString(39, vmygstno);
					prst.setString(40, vmycompanystate);
					prst.setString(41, vcustGSTno);

					if (vmy - voth == 0) {
						double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
						double vcgst = vcaltaxamt / 2;
						double vsgst = vcaltaxamt / 2;
						double vigst = 0.00;
						// new General().msg("Tax is :" +""+vcgst+" "+vsgst+"
						// "+vigst) ;
						prst.setString(42, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
						prst.setString(43, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
						prst.setString(44, new gnMath().get2DecimaltValue(Double.toString(vigst)));
						prst.setString(45, vmovtype);
					}

					if (vmy - voth != 0) {
						double vcaltaxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
						double vcgst = 0.00;
						double vsgst = 0.00;
						double vigst = vcaltaxamt;

						prst.setString(42, new gnMath().get2DecimaltValue(Double.toString(vcgst)));
						prst.setString(43, new gnMath().get2DecimaltValue(Double.toString(vsgst)));
						prst.setString(44, new gnMath().get2DecimaltValue(Double.toString(vigst)));
						prst.setString(45, vmovtype);
					}
					double vtaxablevalue = 0;
					double vnet = 0.0;
					double vtxamt;
					vnet = Double.parseDouble(table.getValueAt(k, 11).toString());
					vtxamt = Double.parseDouble(table.getValueAt(k, 10).toString());
					vtaxablevalue = vnet - vtxamt;
					// new General().msg("Taxable value is :| "+ "
					// "+vtaxablevalue);
					prst.setString(46, new gnMath().get2DecimaltValue(Double.toString(vtaxablevalue)));
					prst.setString(47, vmystatename);
					prst.setString(48, new gnFinYear().getCurrentFinYear(returndate.getText()));

					// cogs

					double vtaxper = Double.parseDouble(table.getValueAt(k, 12).toString());
					double vcost = Double.parseDouble(table.getValueAt(k, 16).toString());
					double vqty1 = Double.parseDouble(table.getValueAt(k, 4).toString());
					// Double vcostvalue = vqty * vcost ;
					Double vcogs = new gnMath().CalTax_Pur(vcost, vtaxper);
					Double vcostvalue = vcost - vcogs;
					vcostvalue = vqty1 * vcostvalue;
					prst.setString(49, Double.toString(vcostvalue));

					prst.addBatch();
					TotalRecordinsert = TotalRecordinsert + 1;
					// for header table take below value
					vvggross = vvggross + Double.parseDouble(table.getValueAt(k, 6).toString());
					vvdisc = vvdisc + (Double.parseDouble(table.getValueAt(k, 9).toString())
							+ Double.parseDouble(table.getValueAt(k, 8).toString()));
					if (++TotalRecordinsert % batchSize == 0) {
						prst.executeBatch();
						DTLstatus = "Sucess";
					}
					prst.executeBatch(); // insert remaining records
					DTLstatus = "Sucess";
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			// new General().msg("POS Detail "+" "+e.getLocalizedMessage());
			con1.rollback();
			DTLstatus = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DTLstatus == "Sucess") {
				insertPosHdr();
			}
		}
		return DTLstatus;
	}
	//// Insert detail End

	/// insert pos header
	public String insertPosHdr() throws Throwable {
		// new General().msg("POS HDR Insert Start now ");
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con2 = this.getConnection();
		con2.setAutoCommit(false);
		String Status = "Fail";
		String poshdr = "Insert into pos_sales_hdr(company_code , " + "site_code, terminal_id ,  invno,   invDate ,  "
				+ "cashier_code, sales_type," + " Invoice_type, Posting_type, Gross_Amount,"
				+ " Discount, Net_Amount, customer_code, shift,"
				+ "ref_ret_type, ref_inv_no , ref_inv_date, verticle, time ,"
				+ "state, statename, regdealer, mycompanyisgst, mygstno,"
				+ " mycompState, custGSTno, movementtype, glcode , updateDate, Updateby,  "
				+ "mystatename, fineyear , narration)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?,  ?,?,?,?,?,?,?,?,?,?,?, ?,?)";
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
			prst.setString(16, invno.getText());

			if (invno.getText().toString().length() == 0) {
				invno.setText("0");
			}
			int vv = Integer.parseInt(invno.getText().toString());
			if (vv == 0) {
				prst.setString(17, "0000.00.00");
				prst.setString(15, "WIR");
			} else {
				prst.setString(17, invdate.getText());
				prst.setString(15, "IR");
			}
			prst.setString(18, vverticle);
			prst.setString(19, new General().getTime());

			prst.setString(20, vstate);
			prst.setString(21, vstatename);
			prst.setString(22, vregdlr);
			prst.setString(23, vmyCompanyisGST);
			prst.setString(24, vmygstno);
			prst.setString(25, vmycompanystate);
			prst.setString(26, vcustGSTno);
			prst.setString(27, vmovtype);
			prst.setString(28, vglcode);
			prst.setString(29, Svinvdate);
			prst.setString(30, vvcashiercode);
			prst.setString(31, vmystatename);
			prst.setString(32, new gnFinYear().getCurrentFinYear(returndate.getText()));
			prst.setString(33, narration.getText());
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			HDRstatus = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				HDRstatus = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			HDRstatus = "Sucess";
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con2.rollback();
			HDRstatus = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
				if (HDRstatus == "Sucess") {
					switch (choice) {
					case "CN":
						insertCN();
						calculateGSTReturnData();
						finalAction();
						break;
					case "Cash":
						insertPayment();
						calculateGSTReturnData();
						finalAction();
						break;
					}
				}
			}
		}
		return HDRstatus;
	}
	//// Insert Heade End

	public void insertPayment() throws Throwable {
		String mode = " ";
		int row = ptable.getRowCount();
		Double vcash = 0.00;
		Double vcc = 0.00;
		String pmode = "Cash";
		String pmCN = "CN";
		int vsrno = 0;
		int vsrno1 = 0;
		for (int k = 0; k < row; k++) {
			mode = ptable.getValueAt(k, 0).toString().trim();
			switch (mode) {
			case "Cash":
				vcash = vcash + (Double.parseDouble(ptable.getValueAt(k, 1).toString()));
				break;
			}
		}

		// new General().msg(vpaymentmode) ;
		prst = null;
		vpaymentmode = pmode;
		vpaymentamount = vcash;
		int vccno = vsrno;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con3 = this.getConnection();
		con3.setAutoCommit(false);
		String Status = "Fail";
		String pospayment = "Insert into  pos_Payments(company_code , " + "site_code,   invdate ,  invno,  "
				+ "cashier_code,   terminal_id , Payment_mode, Amount," + "Advance_Payment_Ind , TransactionType, "
				+ " Invoice_type, sales_type, Posting_type , currency, shift, srno, card_number , verticle, finyear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?)";
		prst = con3.prepareStatement(pospayment);
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
			prst.setString(10, "10");
			prst.setString(11, vvinvoice_type);
			prst.setString(12, vvsales_type);
			prst.setString(13, vvposting_type);
			prst.setString(14, "INR");
			prst.setInt(15, vshift);
			prst.setInt(16, vsrno);
			prst.setInt(17, vccno);
			prst.setString(18, vverticle);
			prst.setString(19, vfinyear);
			prst.setString(18, new gnFinYear().getCurrentFinYear(returndate.getText()));

			prst.addBatch();
			PMTstatus = "Fail";
			TotalRecordinsert = TotalRecordinsert + 1;
			PMTstatus = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				// con3.commit();
				PMTstatus = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			PMTstatus = "Sucess";

		} catch (SQLException e) {
			new General().msg("Sles Return Payment===>" + e.getMessage());
			con3.rollback();
			PMTstatus = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (PMTstatus == "Sucess") {
				// new General().msg("Credit Note Posting ...");
				try {

					switch (choice) {
					case "Cash":
						con1.commit();
						con2.commit();
						con3.commit();
						con1.close();
						con2.close();
						con3.close();
						break;
					case "CN":
						con1.commit();
						con2.commit();
						con4.commit();
						con1.close();
						con2.close();
						con4.close();
						break;
					}
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}
	// End Payment Insert

	// insert credit note details
	public String insertCN() throws Throwable {
		// new General().msg("Inserting CN Now");
		DNCNstatus = "Sucess";
		if (choice == "CN") {
			// new General().msg("Start inserting now..");
			getValidDate();
			DNCNstatus = "Fail";
			String vtype = "CN";
			String vdocno = (String) ptable.getValueAt(0, 2);
			prst = null;
			final int batchSize = 10;
			int TotalRecordinsert = 0;
			con4 = this.getConnection();
			con4.setAutoCommit(false);
			String poshdr = "Insert into payment_DNCN_master(company_code , "
					+ "site_code,    terminal, partycode , type  , " + " Document_no , Document_date , "
					+ "Amount  ,  Amount_consume , Consume_date , " + "Ref_tran_type  ,  Ref_doc_no ,  Ref_doc_date , "
					+ "Balance_amount  , Remark  , Status ,  "
					+ "cashier , shift, valid_upto, verticle  , document_category, updateDate, Updateby , finyear)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,?,?,? )";
			try {
				prst = con4.prepareStatement(poshdr);
				prst.setString(1, vvcompnaycode);
				prst.setString(2, vvsitecode);
				prst.setInt(3, vterminal);
				prst.setInt(4, vvcustid);
				prst.setString(5, vtype);
				prst.setString(6, vdocno);
				prst.setString(7, Svinvdate);
				prst.setDouble(8, vvnet);
				prst.setDouble(9, 0);
				prst.setDouble(10, 0);
				prst.setString(11, vvsales_type);
				prst.setInt(12, vvinvno);
				prst.setString(13, Svinvdate);
				prst.setDouble(14, vvnet);
				prst.setString(15, "Auto Generated Credit Note By System");
				prst.setString(16, "Open");
				prst.setString(17, vvcashiercode);
				prst.setInt(18, vshift);
				// new General().msg(VCNvalidupto);
				prst.setString(19, VCNvalidupto);
				prst.setString(20, vverticle);
				prst.setString(21, "C");
				prst.setString(22, Svinvdate);
				prst.setString(23, vvcashiercode);
				prst.setString(24, new gnFinYear().getCurrentFinYear(returndate.getText()));
				prst.addBatch();
				// new General().msg("PRST:" +" "+prst);
				TotalRecordinsert = TotalRecordinsert + 1;
				DNCNstatus = "Fail";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DNCNstatus = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DNCNstatus = "Sucess";
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				new General().msg("Credit Note Insert --->" + " " + e.getLocalizedMessage());
				con4.rollback();
				DNCNstatus = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
				}
				if (DNCNstatus == "Sucess") {
					switch (choice) {
					case "Cash":
						con1.commit();
						con2.commit();
						con3.commit();
						con1.close();
						con2.close();
						con3.close();
						break;
					case "CN":
						con1.commit();
						con2.commit();
						con4.commit();
						con1.close();
						con2.close();
						con4.close();
						break;
					}
				}
			}
		}
		return DNCNstatus;
	}
	//// end Credit note

	private void finalAction() throws Throwable {
		if (PMTstatus == "Sucess" && DTLstatus == "Sucess" && HDRstatus == "Sucess" && DNCNstatus == "Sucess") {

			if (EditMode == "N") {
				new gnSeq().updateSeqno("101", "TR");
				new gnSeq().updateSeqno("10", "TR");
			}
			new gnTable().RemoveTableRows(model);
			new gnTable().RemoveTableRows(pmodel);
			EditMode = "N";
			new General().msg("Sales Return Data Saved Sucessfully ...");
			vendorname.setText("default");
			Tamount.setText("0");
			vendorname.setText("0");
			paymentamt.setText("0");
			// lblSalesReturnAmount.setText("0");
			// lblPayment.setText("0");

			Itemname.setText(null);
			Scan_item.setText(null);
			referInvoice = "N";
			btnPrint.doClick();
			btnEdit.setBackground(Color.CYAN);
		}
	}

	public String reduceInv() throws Throwable {
		String Action = " ";
		String vtype = "SalesReturn";
		String varticle = " ";
		String vqty = "0.00";
		String vstore = vvsitecode;
		String vdate = Svinvdate;
		String vfinyear = new gnFinYear().getReportingFinYear();
		// New Procedure used now remove old logic of update inventpory
		String vtrntype = "SR";
		String SQL = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vvinvno + " , '"
				+ Svinvdate + "'  , '" + vfinyear + "')";
		this.getSPResult(SQL);

		String vtrntype1 = "SR";
		String SQL1 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   " + vvinvno
				+ " , '" + Svinvdate + "'   , '" + vfinyear + "')";
		this.getSPResult(SQL1);
		Action = "Sucess";
		// End Logic Change

		String vpara811 = "811";
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			vtrntype1 = "SR";
			SQL1 = "call Inv_impact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   " + vvinvno
					+ " , '" + Svinvdate + "'   , '" + vfinyear + "')";
			this.getSPResult(SQL1);
			Action = "Sucess";
			break;
		}

		return Action;
	}

	public void getValidDate() throws Throwable {
		String vpara = "808";
		String vdays = new getConfigurationSetting().getSpecificConfiguration(vpara);
		if (vdays == "Fail") {
			vdays = "30";
		}
		int vvdays = Integer.parseInt(vdays);
		String vgrnDate = new gnConfig().date_ConverttoDBforamt(returndate.getText().trim());
		VCNvalidupto = new gnConfig().date_ConverttoDBforamt(new gnConfig().get_duedate(vgrnDate, vvdays));
		new General().msg("Credit Note Valid Up To:" + " " + VCNvalidupto);
	}

	private void showBatchDetails() throws Throwable {
		int cnt = table.getRowCount();
		int row = table.getSelectedRow();
		if (cnt > 0) {
			String varticle = table.getValueAt(row, 1).toString();
			String vbatchArticle = table.getValueAt(row, 13).toString();
			String vloc = table.getValueAt(row, 17).toString();
			try {
				selectedrow = row;
				CheckBatchArticle(varticle, vbatchArticle);
				// new gnGetBatch().getBatchDetail(varticle, vbatchArticle,
				// vloc);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				new gnGetBatch().resetValues();
				QtychangeWPO(varticle, row);
			}
		}
	}

	private void checkBatchforNonBatchItems(String varticle, String vbatchcontrol) throws Throwable {
		// public String Colitem[] = { "X", "Item", "Name", "Inv Qty", "Return
		// Qty", "Rate", "MRP", "Gross", "Hdr Disc",
		// "Disc", "Tax", "Amount", "Taxcode", "Batch Item", "BatchNo",
		// "Exp.Date", "Cost", "location" };

		String vcost = "0";
		String vsp = table.getValueAt(selectedrow, 5).toString();
		String vmrp = table.getValueAt(selectedrow, 6).toString();
		String vloc = "SL";
		String vaction = new gnBatch().IsBatchAvailableForIsBatchAvailableforMrpandSP(varticle, vmrp, vsp);
		switch (vaction) {
		case "Y":
			vcost = new gnArticle().Article_getData(varticle, "Cost");
			String vaction1 = new gnBatch().IsMultiBatchForMRP_SalesPrice(varticle, vmrp, vsp, vcost);
			vaction1 = "Y";
			switch (vaction1) {
			case "Y":
				try {
					String vtype = "All";
					new gnGetBatch().getBatchDetailForNonBathItems(vtype, varticle, vbatchcontrol, vloc);
				} catch (Exception e) {
					new General().msg(e.getLocalizedMessage());
				} finally {
					if (Double.parseDouble(new gnGetBatch().salesPrice) > 0) {
						// table.setValueAt(new gnGetBatch().cost, selectedrow ,
						// 16);
						table.setValueAt(new gnGetBatch().mrp, selectedrow, 6);
						table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 5);
						// table.setValueAt(new gnGetBatch().expiry_date,
						// selectedrow, 15);
						table.setValueAt(new gnGetBatch().batchno, selectedrow, 14);
						new gnGetBatch().resetValues();
						QtychangeImapct(varticle, selectedrow);
					}
				}
				break;
			case "N":
				String vbatch = new gnBatch().getLowestBatch(varticle, vmrp, vsp, vcost);
				table.setValueAt(vbatch, selectedrow, 14);
				break;
			} // Iswitch
			break;
		case "N":
			String vbatchno = new gnBatch().getNewBatch();
			table.setValueAt(vbatchno, selectedrow, 14);
			break;

		}// Outer Switch
	}

	//// BAtch amd Multiple Price selection
	public String CheckBatchArticle(String varticle, String vbatchcontrol) throws Throwable {
		String status = "Sucess";
		String vloc = "SL";
		String vstorecode = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		String vpara811 = "811";
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
				vstorecode);
		switch (vmaintainbatchforNonBatchItem) {
		case "N":
			try {
				new gnGetBatch().getBatchDetail(varticle, vbatchcontrol, vloc);
			} catch (Exception e) {
				new General().msg("My Exception :" + " " + e.getLocalizedMessage());
			} finally {
				table.setValueAt(new gnGetBatch().cost, selectedrow, 16);
				table.setValueAt(new gnGetBatch().mrp, selectedrow, 6);
				table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 5);
				table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 15);
				table.setValueAt(new gnGetBatch().batchno, selectedrow, 14);
				new gnGetBatch().resetValues();
				QtychangeWPO(varticle, selectedrow);
			}
			break;
		case "Y":
			checkBatchforNonBatchItems(varticle, vbatchcontrol);
			break;
		} // Switch
		return status;
	}// Method End

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
		// nk.addCellEditorListener(ChangeNotification2);
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
				displayInfo(vtype, row);
				// QtychangeImapct(varticle , selectedrow);
				QtychangeWPO(varticle, selectedrow);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	};
	private JTextField quickSearch;
	private JButton btnAcEntry;
	private JTextField finyear;
	private JLabel lblNewLabel_2;
	private JTextField narration;

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
			table.setValueAt(vbatchno, selectedrow, 14);
			table.setValueAt(vexpdate, selectedrow, 15);
			table.setValueAt(vcost, selectedrow, 16);
			table.setValueAt(vmrp, selectedrow, 6);
			table.setValueAt(vsp, selectedrow, 5);
			new gnTable().RemoveTableRows(smodel);
			Scan_item.grabFocus();
			new General().msgDispose();
			break;
		case "N":
			vcost = (String) stable.getValueAt(row, 3);
			vsp = (String) stable.getValueAt(row, 4);
			vmrp = (String) stable.getValueAt(row, 5);
			vbatchno = (String) stable.getValueAt(row, 6);
			vmanufdate = (String) stable.getValueAt(row, 7);
			vexpdate = (String) stable.getValueAt(row, 8);
			table.setValueAt(vbatchno, selectedrow, 14);
			table.setValueAt(vexpdate, selectedrow, 15);
			table.setValueAt(vcost, selectedrow, 16);
			table.setValueAt(vmrp, selectedrow, 6);
			table.setValueAt(vsp, selectedrow, 5);
			new gnTable().RemoveTableRows(smodel);
			Scan_item.grabFocus();
			new General().msgDispose();
			break;
		}
	}
}// last

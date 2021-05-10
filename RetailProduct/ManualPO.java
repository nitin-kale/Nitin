package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;
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
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.border.CompoundBorder;

public class ManualPO extends getResultSet {

	public String vPOstatus;
	private String EditMode = "N";
	public String vspo;
	public String vallow;
	String BrandFor= "NONSO" ;
	JButton btnEdit;
	public String vcompcode;
	JComboBox comboBrand ;
	private JCheckBox approvepo;
	private JLabel lblNewLabel;
	JRadioButton rbBtnSOBrand ;
	private JTextField approvedby;
	private JLabel lblNewLabel_1;
	private JTextField approvedate;
	Connection con, con1, con2, con3, con4, con5, con6, con7;

	public static String varticle;
	private JPanel panel_3;
	private JPanel panel_7;
	private JPanel polikepanel;
	private JPanel brandpanel;
	private JPanel approvePanel;
	private String vcomp;
	private String vstore;
	private String vverticle;
	private JButton btnPopulate;
	private JComboBox combopostatus;
	private String vcform;
	private JButton btnBrand;
	private JButton btnSave;
	private JButton btnClose;
	private JButton btnPrint;
	private JCheckBox chkboxcform;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnUpdate;
	private JLabel lblSearchByName;
	private JButton btnNewButton;
	private JTextField companycode;
	private JTextField expirydate;
	private JLabel lblPoStatus;
	private JTextField leadtime;

	// approve related
	private String vapprovepo;
	private String vapprovedby;
	private String vapprovedate;
	// end Appeove

	/// Table variable to insert in DB
	private String vstorecode;
	private String vpoDate;
	private int vgrnno;
	private int vpono;
	private JTextField brandcode;
	private JTextField brandname;
	private JTextField likepo;
	private String vtype = "MP";
	private int vvendor;
	private Double vcostvalue;
	private String vcreateBy = "Admin";
	private String vupdateDate;
	private int TotalRecordinsert = 0;
	private String DBaction = "Fail";
	private String DBhdr = "Fail";
	private String DBdetail = "Fail";
	private int vcreditDays = 0;
	private Double vpoamount;
	/// end table Varibales

	JFrame frmPOApplication;
	public JInternalFrame internalFrame;
	private JTextField podate;
	private JTextField pono;
	private JTextField scanName;
	private JTextField VendorCode;
	private JTextField VendorName;
	private JTextField poAmount;
	private JTextField scanItem;
	private JTextField Mobile;
	private JTextField Email;
	private JTextField records;
	private JTextField Storecode;
	private JTextField storename;
	private JTextField creditDays;
	private JButton btnPurInfo;

	// gst
	private String vreversechrg;

	// For Customer Search
	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public String SCol[] = { "Type ", "Vendor Code", "Name", "Phone", "Email", "Credit Days", "Verticle",
			"Verticle Name", "Company_Code" };
	public String brandCol[] = { "Type ", "BrandCode", "Name", "Manuf", "verticle", "Verticle Name", };
	public JViewport prt6 = new JViewport();
	public JViewport prt = new JViewport();
	public JScrollPane sjsp;

	public String PoCol[] = { "Remove", "Article_code", "Name", "Qty", "UOM", "cost", "CostValue ", "Sales Price",
			"MRP", "Stock", "Tax%", "BatchEnable", "MBQ", "SaleQty" };

	public String[] Col = { "Article Code", "Article_Name", "Qty", "UOM", "Basic Cost", "Cost_value", "Transportation",
			"Manuf,cost", "Packing Cost", " Landing Cost" };

	// For Item Name Search
	public DefaultTableModel nmodel = new DefaultTableModel();
	public JTable ntable = new JTable();
	public String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost" };

	DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 5 || column == 7 || column == 8 || column == 3 ? true : false;
		}
	};

	//// Table Related
	public DefaultTableModel pmodel = new DefaultTableModel();

	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 5 || column == 7 || column == 8 || column == 3) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
			}

			if (Language == "H") {
				if (column == 2) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}

			if (column == 9 || column == 13) {
				componentt.setBackground(Color.BLACK);
				componentt.setForeground(Color.YELLOW);

			}
			return componentt;
		}
	};

	///

	// public JTable ptable = new JTable() ;
	public JScrollPane jsp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManualPO window = new ManualPO();
					window.frmPOApplication.setVisible(true);
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
	public ManualPO() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		JFrame.setDefaultLookAndFeelDecorated(true);
		frmPOApplication = new JFrame();
		frmPOApplication.getContentPane().setBackground(Color.WHITE);
		frmPOApplication.setResizable(false);
		frmPOApplication.setAlwaysOnTop(true);
		frmPOApplication.setTitle("Business Application");
		frmPOApplication.setBounds(1, 100, 1350, 600);
		frmPOApplication.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmPOApplication.getContentPane().setLayout(null);
		// frmPOApplication.addKeyListener(new gnField().);

		String compName = new gnConfig().getCompany();

		
 		/*
		internalFrame = new JInternalFrame(compName);
 		internalFrame.setBounds(0, 0, 1350, 750);
 		frmPOApplication.getContentPane().add(internalFrame);
		frmPOApplication.getContentPane().setLayout(null);
		*/
		
		ActionListener lsart = new lsarticle();
		ActionListener grnsave = new lsBtn();
		ActionListener cls = new lsBtn();
		ActionListener ls7777 = new lsnritemName();
		ActionListener lscust = new lscust();
		ActionListener supl = new lsnrCustName();
		ActionListener lkk = new lsBtn();

  
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 1334, 216);
		frmPOApplication.getContentPane().add(panel);
		panel.setLayout(null);

		// JPanel panel_4 = new JPanel();
		JPanel panel_4 = new gnRoundPanel();

		panel_4.setBackground(new Color(204, 255, 255));
		panel_4.setBorder(null);
		panel_4.setBounds(152, 25, 401, 189);
		panel.add(panel_4);
		panel_4.setLayout(null);
		ActionListener apo = new ponoLsne();

		;

		JLabel lblRecords = new JLabel("Records");
		lblRecords.setForeground(Color.WHITE);
		lblRecords.setBounds(598, 8, 56, 16);
		lblRecords.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(lblRecords);

		records = new JTextField();
		records.setBounds(666, 7, 31, 22);
		panel_4.add(records);
		records.setEditable(false);
		records.setColumns(10);

		chkboxcform = new JCheckBox("C-FORM");
		chkboxcform.setVisible(false);
		chkboxcform.setBounds(181, 147, 38, 25);
		panel_4.add(chkboxcform);
		chkboxcform.setForeground(Color.WHITE);

		chrevchrg = new JCheckBox("Reverse Charge Apply");
		chrevchrg.setBounds(223, 148, 170, 25);
		panel_4.add(chrevchrg);
		chrevchrg.setBackground(new Color(0, 0, 102));
		chrevchrg.setFont(new Font("Calibri", Font.BOLD, 15));
		chrevchrg.setForeground(Color.WHITE);

		JLabel lblVendorCode = new JLabel("Vendor Code");
		lblVendorCode.setBounds(25, 10, 76, 16);
		panel_4.add(lblVendorCode);
		lblVendorCode.setFont(new Font("Cambria", Font.BOLD, 13));
		lblVendorCode.setForeground(new Color(0, 0, 51));

		//VendorCode = new JTextField();
		VendorCode = new gnRoundTextField(10);
 		VendorCode.setBounds(23, 27, 66, 30);
		panel_4.add(VendorCode);
		VendorCode.setToolTipText("Enter Vendor Code & Enter");
		VendorCode.setColumns(10);
		// VendorCode.addActionListener(suplcode);
		VendorCode.addActionListener(lscust);
		VendorCode.grabFocus();

		VendorName = new gnRoundTextField(10) {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		VendorName.setBounds(92, 27, 255, 30);
		panel_4.add(VendorName);
		VendorName.setFont(new Font("SansSerif", Font.BOLD, 13));
		VendorName.setForeground(Color.BLACK);
		VendorName.setToolTipText("Enter Vendor Name OR  Press Enter  For Search");
		VendorName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("GST Reg.Dlr");
		lblNewLabel_3.setBounds(317, 9, 76, 16);
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(0, 0, 51));
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 13));

		regdlr = new JTextField();
		regdlr.setBounds(351, 28, 38, 29);
		panel_4.add(regdlr);
		regdlr.setBackground(Color.WHITE);
		regdlr.setEditable(false);
		regdlr.setColumns(10);

		lblNewLabel_2 = new JLabel("State");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(51, 63, 38, 16);
		panel_4.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_2.setForeground(Color.BLACK);

		//statecode = new JTextField();
		statecode = new gnRoundTextField(10);
 		statecode.setBounds(93, 60, 31, 30);
		panel_4.add(statecode);
		statecode.setBackground(Color.WHITE);
		statecode.setEditable(false);
		statecode.setColumns(10);

		//statename = new JTextField();
		statename = new gnRoundTextField(10);
 		statename.setBounds(123, 60, 266, 30);
		panel_4.add(statename);
		statename.setBackground(Color.WHITE);
		statename.setEditable(false);
		statename.setColumns(10);

		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setBounds(25, 96, 62, 16);
		panel_4.add(lblMobileNo);
		lblMobileNo.setFont(new Font("Cambria", Font.BOLD, 13));
		lblMobileNo.setForeground(Color.BLACK);
		lblMobileNo.setHorizontalAlignment(SwingConstants.RIGHT);

		//Mobile = new JTextField();
		Mobile = new gnRoundTextField(10);
 		Mobile.setBounds(92, 89, 297, 30);
		panel_4.add(Mobile);
		Mobile.setBackground(Color.WHITE);
		Mobile.setToolTipText("Mobile number of vendor");
		Mobile.setEditable(false);
		Mobile.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(51, 128, 38, 16);
		panel_4.add(lblEmail);
		lblEmail.setFont(new Font("Cambria", Font.BOLD, 13));
		lblEmail.setForeground(Color.BLACK);

		//Email = new JTextField();
		Email = new gnRoundTextField(10);
 		Email.setBounds(92, 118, 298, 30);
		panel_4.add(Email);
		Email.setBackground(Color.WHITE);
		Email.setToolTipText("Email Id of Vendor");
		Email.setEditable(false);
		Email.setColumns(10);

		JLabel lblCreditDaya = new JLabel("Credit Days");
		lblCreditDaya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditDaya.setBounds(16, 151, 73, 16);
		panel_4.add(lblCreditDaya);
		lblCreditDaya.setFont(new Font("Cambria", Font.BOLD, 13));
		lblCreditDaya.setForeground(Color.BLACK);

		//creditDays = new JTextField();
		creditDays = new gnRoundTextField(10);
 		creditDays.setBounds(93, 147, 84, 30);
		panel_4.add(creditDays);
		creditDays.setBackground(Color.WHITE);
		creditDays.setForeground(Color.BLACK);
		creditDays.setFont(new Font("Tahoma", Font.BOLD, 13));
		creditDays.setEditable(false);
		creditDays.setColumns(10);

		// panel_4.setFocusTraversalPolicy(new FocusTraversalOnArray(new
		// Component[]{ VendorCode , VendorName, lblpoDate, pono, podate,
		// lblGrnNumber, lblStoreCode, Storecode, storename, lblRecords,
		// lblPoAmount, records, poAmount, lblVendorCode, lblCreditDaya,
		// creditDays, lblMobileNo, Mobile, Email}));
		VendorCode.grabFocus();
		chkboxcform.setVisible(false);
		ActionListener suplcode = new lsnrCustName();
		ActionListener aprove = new approve();
		// pono.addActionListener(apo);
		ActionListener lt = new leadtime();

		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		panel_3.setBounds(911, 47, 423, 167);
		panel.add(panel_3);
		panel_3.setLayout(null);

		brandpanel = new JPanel();
		brandpanel.setForeground(Color.WHITE);
		brandpanel.setBackground(new Color(255, 0, 204));
		brandpanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null),
				"Create Po For Brand", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		brandpanel.setBounds(12, 13, 376, 86);
		panel_3.add(brandpanel);
		brandpanel.setLayout(null);

		brandname = new JTextField();
		brandname.setForeground(Color.BLACK);
		brandname.setBounds(30, 13, 15, 34);
		brandpanel.add(brandname);
		brandname.setColumns(10);

		JLabel lblPoForBrand = new JLabel("Select Brand");
		lblPoForBrand.setForeground(Color.WHITE);
		lblPoForBrand.setBounds(10, 60, 78, 16);
		brandpanel.add(lblPoForBrand);

		btnBrand = new JButton("Process");
		btnBrand.setFont(new Font("Cambria", Font.BOLD, 13));
		btnBrand.setMnemonic('R');
		btnBrand.setBounds(234, 55, 79, 30);
		brandpanel.add(btnBrand);
		btnBrand.setBackground(Color.CYAN);

		from = new JTextField();
		from.setForeground(Color.BLACK);
		from.setBounds(86, 25, 102, 25);
		brandpanel.add(from);
		from.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("To");
		lblNewLabel_5.setBounds(200, 26, 38, 25);
		brandpanel.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(Color.WHITE);

		to = new JTextField();
		to.setForeground(Color.BLACK);
		to.setBounds(224, 25, 89, 25);
		brandpanel.add(to);
		to.setColumns(10);

		brandcode = new JTextField();
		brandcode.setForeground(Color.BLACK);
		brandcode.setEnabled(false);
		brandcode.setBounds(12, 13, 15, 34);
		brandpanel.add(brandcode);
		brandcode.setToolTipText("Press Enter to show Brands");
		brandcode.setColumns(10);

		lblNewLabel_4 = new JLabel("From");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 28, 68, 16);
		brandpanel.add(lblNewLabel_4);
		
		comboBrand = new JComboBox();
		comboBrand.setBounds(86, 55, 140, 30);
		brandpanel.add(comboBrand);
		brandpanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { brandname, brandcode, btnBrand }));

		polikepanel = new JPanel();
		polikepanel.setBackground(new Color(255, 102, 204));
		polikepanel.setBorder(new TitledBorder(UIManager.getBorder("ToolBar.border"), "Create PO Like ",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		polikepanel.setBounds(12, 102, 376, 54);
		panel_3.add(polikepanel);
		polikepanel.setLayout(null);

		btnPopulate = new JButton("Populate");
		btnPopulate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPopulate.setMnemonic('O');
		btnPopulate.setBounds(180, 20, 108, 25);
		polikepanel.add(btnPopulate);
		btnPopulate.setBackground(Color.CYAN);

		likepo = new JTextField();
		likepo.setForeground(Color.BLACK);
		likepo.setToolTipText("Press Enter to show Po List");
		likepo.setBounds(110, 20, 69, 25);
		polikepanel.add(likepo);
		likepo.setColumns(10);

		JLabel lblSelectPoNo = new JLabel("Select PO No.");
		lblSelectPoNo.setForeground(Color.WHITE);
		lblSelectPoNo.setBounds(12, 24, 86, 16);
		polikepanel.add(lblSelectPoNo);

		panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setForeground(new Color(0, 0, 153));
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Options", TitledBorder.CENTER,
				TitledBorder.TOP, null, Color.BLACK));
		panel_7.setBounds(911, 0, 423, 52);
		panel.add(panel_7);
		panel_7.setLayout(null);

		JRadioButton rdbtnBrand = new JRadioButton("Brand");
		buttonGroup.add(rdbtnBrand);
		rdbtnBrand.setBackground(Color.WHITE);
		rdbtnBrand.setForeground(Color.BLACK);
		rdbtnBrand.setMnemonic('D');
		rdbtnBrand.setBounds(8, 18, 67, 25);
		panel_7.add(rdbtnBrand);
		rdbtnBrand.setSelected(true);

		JRadioButton rdbtnPoLike = new JRadioButton("PO Like");
		buttonGroup.add(rdbtnPoLike);
		rdbtnPoLike.setBackground(Color.WHITE);
		rdbtnPoLike.setForeground(Color.BLACK);
		rdbtnPoLike.setMnemonic('O');
		rdbtnPoLike.setBounds(316, 18, 77, 25);
		panel_7.add(rdbtnPoLike);
		
	    rbBtnSOBrand = new JRadioButton("PO-SO Brands");
	    buttonGroup.add(rbBtnSOBrand);
	    rbBtnSOBrand.setBackground(Color.WHITE);
		rbBtnSOBrand.setBounds(79, 18, 129, 25);
		panel_7.add(rbBtnSOBrand);

		companycode = new JTextField();
		companycode.setBounds(454, 0, 56, 25);
		panel.add(companycode);
		companycode.setBackground(Color.WHITE);
		companycode.setEditable(false);
		companycode.setColumns(10);

		Storecode = new JTextField();
		Storecode.setBounds(509, 0, 90, 25);
		panel.add(Storecode);
		Storecode.setEditable(false);
		Storecode.setBackground(Color.WHITE);
		Storecode.setColumns(10);

		storename = new JTextField();
		storename.setBounds(600, -1, 299, 25);
		panel.add(storename);
		storename.setEditable(false);
		storename.setBackground(Color.WHITE);
		storename.setColumns(10);

		// JPanel panel_8 = new JPanel();
		JPanel panel_8 = new gnRoundPanel();

		panel_8.setBounds(553, 25, 354, 189);
		panel.add(panel_8);
		panel_8.setBackground(Color.WHITE);
		panel_8.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setLayout(null);

		leadtime = new JTextField();
		leadtime.setFont(new Font("Tahoma", Font.BOLD, 12));
		leadtime.setBounds(124, 58, 218, 30);
		panel_8.add(leadtime);
		leadtime.setColumns(10);

		JLabel lblGrnNumber = new JLabel("PO Number");
		lblGrnNumber.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblGrnNumber.setForeground(Color.BLACK);
		lblGrnNumber.setBounds(12, 11, 98, 16);
		panel_8.add(lblGrnNumber);
		lblGrnNumber.setHorizontalAlignment(SwingConstants.LEFT);

		pono = new JTextField();
		pono.setFont(new Font("Tahoma", Font.BOLD, 12));
		pono.setBounds(12, 26, 98, 30);
		panel_8.add(pono);
		pono.setText("0");
		pono.setToolTipText("Purchase Order Number");
		pono.setColumns(10);
		podate = new JTextField();
		podate.setFont(new Font("Tahoma", Font.BOLD, 12));
		podate.setBounds(124, 26, 121, 30);
		panel_8.add(podate);
		podate.setEditable(false);
		podate.setToolTipText("Purchase Order Date ");
		podate.setColumns(10);

		JLabel lblpoDate = new JLabel("PO Date");
		lblpoDate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblpoDate.setForeground(Color.BLACK);
		lblpoDate.setBounds(126, 11, 75, 16);
		panel_8.add(lblpoDate);
		lblpoDate.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblLeadTime = new JLabel("Lead Time");
		lblLeadTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLeadTime.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblLeadTime.setForeground(Color.BLACK);
		lblLeadTime.setBounds(26, 64, 91, 16);
		panel_8.add(lblLeadTime);

		lblPoStatus = new JLabel("PO Status");
		lblPoStatus.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblPoStatus.setForeground(Color.BLACK);
		lblPoStatus.setBounds(256, 11, 98, 16);
		panel_8.add(lblPoStatus);
		lblPoStatus.setHorizontalAlignment(SwingConstants.LEFT);

		combopostatus = new JComboBox();
		combopostatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		combopostatus.setBounds(254, 26, 88, 30);
		panel_8.add(combopostatus);
		combopostatus.setModel(new DefaultComboBoxModel(new String[] { "Open", "Close" }));

		JLabel lblExpiryDate = new JLabel("Exp.Date");
		lblExpiryDate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblExpiryDate.setForeground(Color.BLACK);
		lblExpiryDate.setBounds(36, 99, 81, 16);
		panel_8.add(lblExpiryDate);
		lblExpiryDate.setHorizontalAlignment(SwingConstants.RIGHT);

		expirydate = new JTextField();
		expirydate.setFont(new Font("Tahoma", Font.BOLD, 12));
		expirydate.setBounds(124, 90, 218, 30);
		panel_8.add(expirydate);
		expirydate.setEditable(false);
		expirydate.setColumns(10);

		JLabel lblPoAmount = new JLabel("Po Amount");
		lblPoAmount.setBounds(0, 131, 117, 15);
		panel_8.add(lblPoAmount);
		lblPoAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPoAmount.setForeground(Color.BLACK);
		lblPoAmount.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));

		poAmount = new JTextField();
		poAmount.setBounds(124, 122, 218, 33);
		panel_8.add(poAmount);
		poAmount.setForeground(Color.BLACK);
		poAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		poAmount.setEditable(false);
		poAmount.setColumns(10);
		panel_8.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { leadtime, pono, podate, poAmount, lblPoStatus, combopostatus }));

		JLabel lblNewLabel_6 = new JLabel("Purchase Order");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_6.setBounds(15, 54, 125, 16);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel(" ");
		lblNewLabel_7.setIcon(new ImageIcon(ManualPO.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_7.setBounds(12, 0, 131, 104);
		panel.add(lblNewLabel_7);

		approvePanel = new JPanel();
		approvePanel.setBounds(0, 105, 140, 113);
		panel.add(approvePanel);
		approvePanel.setBackground(new Color(255, 255, 255));
		approvePanel.setBorder(null);
		approvePanel.setLayout(null);

		approvepo = new JCheckBox("Approve PO");
		approvepo.setBackground(Color.WHITE);
		approvepo.setForeground(Color.BLACK);
		approvepo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		approvepo.setBounds(8, 0, 109, 24);
		approvePanel.add(approvepo);

		lblNewLabel = new JLabel("Approved By");
		lblNewLabel.setBounds(29, 24, 78, 16);
		approvePanel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));

		approvedby = new JTextField();
		approvedby.setBounds(18, 40, 116, 22);
		approvePanel.add(approvedby);
		approvedby.setForeground(Color.BLACK);
		approvedby.setBackground(Color.WHITE);
		approvedby.setEditable(false);
		approvedby.setColumns(10);

		lblNewLabel_1 = new JLabel("Approve Date");
		lblNewLabel_1.setBounds(24, 62, 93, 16);
		approvePanel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 13));

		approvedate = new JTextField();
		approvedate.setBounds(16, 78, 118, 22);
		approvePanel.add(approvedate);
		approvedate.setForeground(Color.BLACK);
		approvedate.setBackground(Color.WHITE);
		approvedate.setEditable(false);
		approvedate.setColumns(10);
		approvepo.addActionListener(aprove);
		frmPOApplication.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { panel_8 }));
		leadtime.addActionListener(lt);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 258, 1344, 309);
		frmPOApplication.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 0, 1344, 309);
		panel_1.add(jsp);

		prt = new JViewport();
		prt.setBackground(new Color(204, 255, 255));
		prt.add(table, Col);
		prt.setVisible(true);
		prt.setBackground(Color.WHITE);
		jsp.setViewport(prt);

		sjsp = new JScrollPane();
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(0, 0, 1172, 158);
		ActionListener prn = new lsBtn();
		ActionListener upd = new lsBtn();

		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, -11, 97, 12);
		frmPOApplication.getContentPane().add(btnNewButton);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(204, 255, 255));
		panel_5.setBounds(0, 215, 1334, 45);
		frmPOApplication.getContentPane().add(panel_5);
		panel_5.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		panel_5.setLayout(null);

		scanItem = new JTextField();
		scanItem.setToolTipText("Enter Item code if you know");
		scanItem.setBounds(138, 0, 213, 43);
		panel_5.add(scanItem);
		scanItem.setColumns(10);

		JLabel lblScanArticleHere = new JLabel("Scan Article Here ");
		lblScanArticleHere.setHorizontalAlignment(SwingConstants.RIGHT);
		lblScanArticleHere.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblScanArticleHere.setForeground(new Color(51, 0, 0));
		lblScanArticleHere.setBounds(0, 12, 136, 19);
		panel_5.add(lblScanArticleHere);

		scanName = new JTextField();
		scanName.setToolTipText("Enter Name or start latters to search Items");
		scanName.setBounds(568, 0, 330, 42);
		panel_5.add(scanName);
		scanName.setColumns(10);

		lblSearchByName = new JLabel("Search By Name");
		lblSearchByName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSearchByName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearchByName.setBounds(452, 7, 116, 35);
		panel_5.add(lblSearchByName);
		
				btnClose = new JButton("Close");
				btnClose.setBounds(1231, 0, 103, 43);
				panel_5.add(btnClose);
				btnClose.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose1.png"));
				btnClose.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose.png"));
				btnClose.addActionListener(cls);
				btnClose.setBackground(Color.CYAN);
				btnClose.setForeground(Color.BLACK);
				btnClose.setMnemonic('C');
				
						btnSave = new JButton("Save");
						btnSave.setBounds(1136, 0, 97, 43);
						panel_5.add(btnSave);
						btnSave.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApsave1.png"));
						btnSave.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApsave.png"));
						btnSave.setMnemonic('S');
						btnSave.setForeground(UIManager.getColor("Button.darkShadow"));
						btnSave.setBackground(UIManager.getColor("Button.background"));
						btnSave.addActionListener(grnsave);
		
				btnPurInfo = new JButton("Priv.Purchase Rates ");
				btnPurInfo.setBounds(0, 570, 161, 30);
				frmPOApplication.getContentPane().add(btnPurInfo);
				btnPurInfo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
				btnPurInfo.setForeground(new Color(0, 0, 102));
				
						btnPurInfo.setMnemonic('R');
						
								btnBarcode = new JButton("Generate Barcode");
								btnBarcode.setBounds(161, 569, 147, 30);
								frmPOApplication.getContentPane().add(btnBarcode);
								btnBarcode.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
								btnBarcode.setForeground(new Color(0, 0, 102));
								btnBarcode.setMnemonic('B');
								
										btnEdit = new JButton("Edit Document");
										btnEdit.setBounds(309, 571, 167, 28);
										frmPOApplication.getContentPane().add(btnEdit);
										btnEdit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
										btnEdit.setForeground(new Color(0, 0, 102));
										btnEdit.setSelectedIcon(new ImageIcon(ManualPO.class.getResource("/RetailProduct/btnApEdit1.png")));
										btnEdit.setMnemonic('E');
										
												btnUpdate = new JButton("Update");
												btnUpdate.setBounds(476, 569, 126, 30);
												frmPOApplication.getContentPane().add(btnUpdate);
												btnUpdate.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApUpdate.png"));
												btnUpdate.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApUpdate1.png"));
												btnUpdate.setBackground(Color.CYAN);
												btnUpdate.setForeground(Color.BLACK);
												btnUpdate.setMnemonic('U');
												btnUpdate.setEnabled(false);
												
														btnPrint = new JButton("Print");
														btnPrint.setBounds(602, 569, 97, 30);
														frmPOApplication.getContentPane().add(btnPrint);
														btnPrint.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApPrint1.png"));
														btnPrint.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApPrint.png"));
														btnPrint.setMnemonic('P');
														btnPrint.setForeground(Color.BLACK);
														btnPrint.setBackground(Color.CYAN);
														btnPrint.addActionListener(prn);
												btnUpdate.addActionListener(upd);
										btnEdit.addActionListener(grnsave);
								btnBarcode.addActionListener(upd);
						btnPurInfo.addActionListener(upd);
		scanItem.addActionListener(lsart);
		scanName.addActionListener(ls7777);
		//internalFrame.setVisible(true);
		polikepanel.setVisible(false);
		brandpanel.setVisible(false);

		ActionListener rb2 = new rblsnr();
		ActionListener ponop = new lsBtn();
		ActionListener rb1 = new rblsnr();
 		ActionListener brnd = new lsnrbrand();
		ActionListener likepo1 = new lsnrpolike();
		ActionListener bnd = new lsBtn();

		btnPopulate.addActionListener(ponop);
		btnBrand.addActionListener(bnd);
		brandname.addActionListener(brnd);
		likepo.addActionListener(likepo1);

		rdbtnPoLike.addActionListener(rb2);
		rdbtnBrand.addActionListener(rb1);
		rbBtnSOBrand.addActionListener(rb1);
 		brandcode.addActionListener(brnd);
		VendorName.addActionListener(supl);
		decorate();
	}

	public void CallEditprocess(String vndorcode) throws Throwable {
		scanItem.setVisible(true);
		scanName.setVisible(true);
		decorate();
		btnEdit.setVisible(true);
		vallow = "Y";
		EditMode = "Y";
		btnUpdate.setEnabled(false);
		btnEdit.setBackground(Color.BLUE);
		btnEdit.setForeground(Color.WHITE);
		try {
			new gnSupplier().setScanSupplier(VendorCode, VendorName, vndorcode);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			VendorCode.setText(new gnSupplier().rvendorcode);
			VendorName.setText(new gnSupplier().rvendorName);
			Mobile.setText(new gnSupplier().rPhone);
			Email.setText(new gnSupplier().rEmail);
			creditDays.setText(new gnSupplier().rcrdays);
			statecode.setText(new gnSupplier().rstatecode);
			statename.setText(new gnSupplier().rstatename);
			pono.setText(new gnGrn().rgrnno);
			podate.setText(new gnGrn().rgrndate);

			//
			validatepoEntry();
			String vcomp = companycode.getText();
			String vstorecode = Storecode.getText();
			String vpono = pono.getText();
			String SQL = "call po_getPoDetail(" + vpono + " , " + vcomp + "," + vstorecode + ")";
			String SQL1 = "call po_getPoheader(" + vpono + " , " + vcomp + "," + vstorecode + ")";
			String vtype = "PO";
			new gnTable().RemoveTableRows(model);
			showHeader(SQL1, vtype);
			showTable(SQL, vtype, PoCol);
			disableForUpdate();
			scanItem.setVisible(true);
			scanName.setVisible(true);

		}
	}

	public void decorate() throws Throwable {
		
		brandcode.setVisible(false);
		brandname.setVisible(false);
   		frmPOApplication.setUndecorated(true);
 		
		String vmastername = "Brand" ;
 		new gnComp().fillMasterCombo(  comboBrand, vmastername);
  
		int typeno = 1;
		new gnDecorate().SetSeqHdrButton(btnSave, typeno);
		new gnDecorate().SetSeqHdrButton(btnPrint, typeno);
		new gnDecorate().SetSeqHdrButton(btnUpdate, typeno);
		new gnDecorate().SetSeqHdrButton(btnClose, typeno);
		new gnDecorate().SetSeqHdrButton(btnBarcode, typeno);
		new gnDecorate().SetSeqHdrButton(btnPurInfo, typeno);

		from.setText(new gnFinYear().getFirstDateofFinYear());
		to.setText(new gnFinYear().getLastDateofFinYear());

 
		
		 
		
		if (Language == "H") {
			VendorName.setFont(new Font("Shivaji02", Font.PLAIN, 16));
		}
		OnDelKeyTableRow(table, model, "GRN");
		new gnField().moveDown(table);

		btnUpdate.setVisible(false);
		vallow = new gnDate().checkDayBegin();
		switch (vallow) {
		case "Y":
			vcomp = new gnConfig().getCompanyCode();
			companycode.setText(new gnConfig().getCompanyCode());
			vstore = (new gnConfig().getStoreID());
			Storecode.setText(vstore);
			storename.setText(new gnConfig().getStorename(Storecode.getText()));
			podate.setText(new gnConfig().getDaybeginDate());

			approvepo.setSelected(true);
			approvepo.setEnabled(false);
			VendorCode.grabFocus();
			switch (vcomp) {
			case "0":
				System.exit(0);
			}

			new gnField().closeform(btnSave, frmPOApplication);
			new gnField().closeform(btnSave, frmPOApplication);
			new gnField().showCalc(btnSave, "CAL");

			new gnField().showFieldInfo(pono, "pono");
			new gnField().showFieldInfo(VendorCode, "vendor");
			new gnField().showFieldInfo(VendorName, "vendor");
			new gnField().showFieldInfo(brandcode, "brand");
			new gnField().showFieldInfo(likepo, "POLIKE");
			new gnField().showFieldInfo(scanName, "ITEMNAMESEARCH");
			new gnField().showFieldInfo(scanItem, "ARTICLECODE");
			new gnField().showFieldInfo(approvepo, "APPROVE");
			new gnField().showFieldInfo(approvedby, "APPROVE");
			new gnField().showFieldInfo(approvedate, "APPROVE");
 			new gnApp().setFrameTitel(frmPOApplication);
 			brandpanel.setVisible(true);
			leadtime.setText("7");
			setExpiryDate();
			btnUpdate.setEnabled(false);

		}
	}

	public void OnDelKeyTableRow(JTable table, DefaultTableModel model, String FieldName) {
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
					poAmount.setText(Double.toString(new gnTable().getTotal(table, 6)));
					// resetFigures() ;
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
			namesearch();
		}
	}

	private void namesearch() {
		String sname = scanItem.getText().trim();
		sname = "%" + sname + "%";
		String vType = "Article";
		String vtrantype = "ALL";
		try {
 			new gnAdmin().Search(vType, sname, varticle, vtrantype);
			// new showData().show(jsp, ntable, vtext, x, y);
		} catch (Throwable e1) {
			e1.printStackTrace();
			new General().msg(e1.getMessage());
		} finally {
			try {
				showArticle(new gnAdmin().rArticle);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class lsarticle implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("id " + i);
			if (i == 1001) {
				String status = "Fail";
				String action = checkVendorEntry();
				try {
					String vcode = scanItem.getText();
					if (vcode.length() == 0) {
						return;
					}
					String vname = "Article";
					String vcomp = companycode.getText();
					String vstore = Storecode.getText();
					String vfinyear = new gnFinYear().getReportingFinYear();
					String vtype = "PO";
					String vverticle = new gnHierarchy().getVerticleCode();
					String SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + vcode + "', " + vcomp
							+ " , " + vstore + " , '" + vfinyear + "' , " + vverticle + ")";
					// new General().msg(SQL);
					String result = new gnCheckArticle().checkArticleExist(table, vcode, 1);
					if (result == "Sucess") {
						showTable(SQL, vname, PoCol);
					}
					else
					{
						namesearch();
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	/// aRTICLE

	class approve implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			try {
				new gnApp().approveDocument(approvepo, approvedby, approvedate);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class rblsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
  			if ( value == "PO-SO Brands")
			{
  				BrandFor = "SO" ;
				polikepanel.setVisible(false);
				brandpanel.setVisible(true);
   				comboBrand.grabFocus();
 			}
			
			if (value == "Brand") {
 
				BrandFor = "NONSO" ;
 				polikepanel.setVisible(false);
				brandpanel.setVisible(true);
				comboBrand.grabFocus();
				//brandcode.grabFocus();
			}
			if (value == "PO Like") {
				polikepanel.setVisible(true);
				brandpanel.setVisible(false);
				likepo.grabFocus();
			}
		}
	}

	/// Supplier Search start here
	class lsnrCustName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			String sname = VendorName.getText().trim();
			sname = "%" + sname + "%";
			try {
				String vtype = "Vendor";
				new gnSupplier().getSupplier(sname);
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
			} catch (ClassNotFoundException e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				new General().msg(e1.getMessage());
			} finally {
				VendorCode.setText(new gnSupplier().rvendorcode);
				VendorName.setText(new gnSupplier().rvendorName);
				Mobile.setText(new gnSupplier().rPhone);
				Email.setText(new gnSupplier().rEmail);
				creditDays.setText(new gnSupplier().rcrdays);
				statecode.setText(new gnSupplier().rstatecode);
				statename.setText(new gnSupplier().rstatename);
				regdlr.setText(new gnSupplier().rregdlr);
				scanItem.grabFocus();
				String vreversechrg;
				try {
					vreversechrg = regdlr.getText();
					if (vreversechrg == "N") {
						int vchoice = new General().msgInput(
								"Supplier is not GST Register Dealer,  Reverse Charges will Apply<<Are You Sure  ?>>");
						switch (vchoice) {
						case 0:
							chrevchrg.setSelected(true);
						}
					}
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
				new gnSupplier().rregdlr = "";
				new gnSupplier().rstatecode = " ";
				new gnSupplier().rstatename = "";
			}
		}
	}

	class lsnrbrand implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			vmastersearchString = "%" + brandname.getText() + "%";
			String sname = "%" + brandname.getText() + "%";
			try {
				vverticle = new gnHierarchy().getVerticleCode();
				String vtype = "Brand";
				new gnAdmin().showMasterTable(vtype, brandcode, brandname);
			} catch (Throwable e2) {
				e2.printStackTrace();
			} finally {
				// brandcode.setText(new gnBrand().rbrandcode);
				// brandname.setText(new gnBrand().rName);
				// scanItem.grabFocus();
			}
		}

	}

	class lsnrpolike implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// new General().msg("Event Trigger for PO No");
			String poCol1[] = { "Type", "Vendor", "PO.No", "PO_Date", "PO_Type", "PO_Value" };
			String vvendor = VendorCode.getText();
			String vcomp = companycode.getText();
			String vstore = Storecode.getText();
			if (vvendor.length() == 0) {
				new General().msg("Select Vendor For PO Search");
				VendorCode.grabFocus();
				return;
			}
			String vtype = "VendorPO";
			// String SQL = "call po_getPONO('"+vvendor+"' , "+vcomp+",
			// "+vstore+")" ;
			try {
				new gnPO().getVendorPO(vvendor, vtype);
				// Search(SQL, poCol1 , vtype ) ;
			} catch (SQLException e1) {
				new General().msg("PO Seearch" + "" + e1.getMessage());
			} catch (ClassNotFoundException e1) {
				new General().msg("PO Seearch" + "" + e1.getMessage());
			} catch (Throwable e1) {
				new General().msg("PO Seearch" + "" + e1.getMessage());
			} finally {
				likepo.setText(new gnPO().pono);
				// scanItem.grabFocus();
			}
		}
	}

	class lscust implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			if (i == 1001) {
				String vVname = VendorCode.getText();
				try {
					new gnSupplier().setScanSupplier(VendorCode, VendorName, vVname);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					Mobile.setText(new gnSupplier().rPhone);
					Email.setText(new gnSupplier().rEmail);
					creditDays.setText(new gnSupplier().rcrdays);
				}
			}
		}
	}

	class leadtime implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String action = "Sucess";
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			try {
				// expirydate.setText(new gnConfig().get_duedate((new
				// gnConfig().date_ConverttoDBforamt(podate.getText())),
				// Integer.parseInt(leadtime.getText().toString())));
				setExpiryDate();
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void proceeBrandArticles() throws ClassNotFoundException, SQLException {
		String vname = "Brand";
		
		String vmastername = "Brand" ;
		String vdescription = comboBrand.getSelectedItem().toString().trim();
	  	brandcode.setText( new gnComp().getCodeOfMasterDescription(vmastername , vdescription)) ;
  		brandname.setText(vdescription) ; 
 		
 		
 		String vbrand = brandcode.getText();
		String vcomp = companycode.getText();
		String vstore = Storecode.getText();
		String vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
		String vto = new gnConfig().date_ConverttoDBforamt(to.getText());
		String vverticle = new gnHierarchy().getVerticleCode();
		String SQL = "" ;
 		switch(BrandFor)
 		{
 		
 		case "NONSO":
		SQL = "Call po_getBrandArticle('" + BrandFor + "' ,  '" + vbrand + "'," + vcomp + " , " + vstore + " , " + vverticle + ", '"
				+ vfrom + "', '" + vto + "')";
 		
 		case "SO":
		SQL = "Call po_getBrandArticle('" + BrandFor + "' , '" + vbrand + "'," + vcomp + " , " + vstore + " , " + vverticle + ", '"
				+ vfrom + "', '" + vto + "')";
  		}
		
		try {
			new gnTable().RemoveTableRows(model);
		    //new General().msg(SQL);
			showTable(SQL, vname, PoCol);
			scanItem.grabFocus();
			
			int row = table.getRowCount();
			if( row == 0)
			{
				new General().Quickmsg("No Data Available Please Check Selected Brand & Date Range ");
			}
			
		} catch (Throwable e1) {
			new General().msg(e1.getLocalizedMessage());
			e1.printStackTrace();
		}
 	}

	class lsBtn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id

			if (value == "Process") {
				try {
					proceeBrandArticles();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Priv.Purchase Rates ") {
				try {
					getInfoRecord();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Generate Barcode") {
				String vdocno = pono.getText();
				String vdoctype = "PO";
				try {
					if (vdocno.length() > 0) {
						// new gnBarcode().generate(vdocno, vdoctype);
					} else {
						new General().msg("Select Po No For Barcode Generation..");
						pono.grabFocus();
					}
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
				return;
			}

			if (value == "Populate") {
				String vname = "PO";
				String vpono = likepo.getText();
				String vcomp = companycode.getText();
				String vstore = Storecode.getText();
				String SQL = "call    po_getPoDetail('" + vpono + "' , " + vcomp + ", " + vstore + ") ";
				try {
					new gnTable().RemoveTableRows(model);
					showTable(SQL, vname, PoCol);
					scanItem.grabFocus();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
			if (value == "Close") {
				frmPOApplication.dispose();
			}

			if (value == "Print") {
				try {
					callprint();
				} catch (Throwable e2) {
					new General().msg(e2.getMessage());
				}
				btnSave.setEnabled(true);
				btnUpdate.setEnabled(false);
				btnPrint.setEnabled(false);
				EnableForInsert();
				new gnTable().RemoveTableRows(model);
				try {
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
			if (value == "Upload") {
				try {
					callUpload();
				} catch (Exception e1) {
					new General().msg("Mesage:" + e1.getLocalizedMessage());
				}
			}

			if (value == "Update") {

			}

			if (value == "Edit Document") {
				EditMode = "Y";
				lsnrCustName b = new lsnrCustName();
				b.actionPerformed(e);
				scanItem.setVisible(false);
				scanName.setVisible(false);
				ponoLsne c = new ponoLsne();
				c.actionPerformed(e);
			}

			if (value == "Save") {
				if (VendorCode.getText().length() == 0) {
					new General().msg("Select Vendor ..");
					VendorCode.grabFocus();
					return;
				}
				try {
					// remoZeroQty() ;
					callSaveEvent();
				} catch (Exception e1) {
					new General().msg("Mesage:" + e1.getLocalizedMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		}
	}

	private void remoZeroQty() {
		int row = table.getRowCount();
		double vpoqty = 0;
		for (int i = 0; i < row; i++) {
			vpoqty = Double.parseDouble(table.getValueAt(i, 3).toString());
			if (vpoqty == 0) {
				model.removeRow(i);
			}
		}
	}

	class ponoLsne implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String action = "Sucess";
			try {
				action = validatepoEntry();
			} catch (ClassNotFoundException e2) {
				new General().msg(e2.getLocalizedMessage());
			} catch (SQLException e2) {
				new General().msg(e2.getLocalizedMessage());
			} catch (Throwable e1) {
				new General().msg(e1.getLocalizedMessage());
			}
			action = "Sucess";
			if (action == "Sucess") {
				String vcomp = companycode.getText();
				String vstorecode = Storecode.getText();
				String vpono = pono.getText();
				String SQL = "call po_getPoDetail(" + vpono + " , " + vcomp + "," + vstorecode + ")";
				String SQL1 = "call po_getPoheader(" + vpono + " , " + vcomp + "," + vstorecode + ")";
				String vtype = "PO";
				try {
					new gnTable().RemoveTableRows(model);
					showHeader(SQL1, vtype);
					showTable(SQL, vtype, PoCol);
					disableForUpdate();
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
				}
			}
		}
	}

	public String validatepoEntry() throws Throwable {
		String action = "Sucess";
		String vscanpo = pono.getText();
		String vcomp = companycode.getText();
		String vstore = Storecode.getText();
		String SQL = "call    po_checkpoExist(" + vscanpo + " , " + vcomp + ", " + vstore + ")";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			int option = new General().msgInput("Invalid PO.No...Would you Like Search PO");
			if (option == 0) {

				showpoSearch();
				action = "Fail";
			}
		} else {
			String vstatus = rs.getString(2);
			vPOstatus = rs.getString(2);
			switch (vstatus) {
			case "Close":
				new General().msg("Status of Enter PO.NO is Closed , Goods Can't Reveive Against This PO");
				action = "Sucess";
			}
		}
		return action;
	}

	public void showpoSearch() {
		String vendorStatus = checkVendorEntry();
		if (vendorStatus == "Sucess") {
			String scode = VendorCode.getText();
			String vtype = "VendorOpenPO";
			try {
				new gnPO().getVendorPO(scode, vtype);
			} catch (Throwable e) {
				new General().msg("PO Search" + " " + e.getLocalizedMessage());
			} finally {
				pono.setText(new gnPO().pono);
				podate.setText(new gnPO().poate);
				switch (vPOstatus) {
				case "Open":
					scanItem.setVisible(true);
					scanName.setVisible(true);
					scanItem.grabFocus();
					btnSave.setEnabled(true);
					break;
				case "Close":
					scanItem.setVisible(false);
					scanName.setVisible(false);
					btnSave.setEnabled(false);
					break;
				}
			}
		}
	}

	private void showHeader(String SQL1, String vtype) throws ClassNotFoundException, SQLException {
		btnSave.setEnabled(true);
		btnUpdate.setEnabled(true);
		rs.close();
		rs = this.getSPResult(SQL1);
		if (vtype == "PO") {
			rs.next();
			VendorCode.setText(rs.getString(1));
			VendorName.setText(rs.getString(2));
			creditDays.setText(rs.getString(3));
			Mobile.setText(rs.getString(4));
			Email.setText(rs.getString(5));
			vcform = rs.getString(6);
			switch (vcform) {
			case "Y":
				chkboxcform.setSelected(true);
				break;
			case "N":
				chkboxcform.setSelected(false);
				break;
			}
			expirydate.setText(rs.getString(7));
			leadtime.setText(rs.getString(8));
			String vstatus = rs.getString(9);
			podate.setText(rs.getString(10));
			switch (vstatus) {
			case "Open":
				combopostatus.setSelectedItem("Open");
				combopostatus.setBackground(Color.WHITE);
				scanItem.setVisible(true);
				scanName.setVisible(true);
				btnSave.setEnabled(true);
				scanItem.grabFocus();
				break;
			case "Close":
				combopostatus.setSelectedItem("Close");
				combopostatus.setBackground(Color.RED);
				combopostatus.setEditable(false);
				btnSave.setEnabled(false);
				btnPrint.setEnabled(true);
				scanItem.setVisible(false);
				scanName.setVisible(false);
				btnSave.setEnabled(false);

				break;
			}
			// po Approve setting

			String vapprovepo = rs.getString(12);
			switch (vapprovepo) {
			case "Y":
				approvepo.setEnabled(false);
				btnUpdate.setEnabled(false);
				btnPrint.setEnabled(true);
				approvepo.setSelected(true);
				approvedby.setText(rs.getString(13));
				approvedate.setText(rs.getString(14));
				table.setEnabled(false);
				break;
			case "N":
				switch (vstatus) {
				case "Close":
					btnUpdate.setEnabled(false);
					table.setEnabled(false);
					break;
				case "Open":
					btnUpdate.setEnabled(true);
					approvepo.setEnabled(true);
					table.setEnabled(true);
					break;
				}
				btnPrint.setEnabled(true);
				approvepo.setSelected(false);
				approvedby.setText(null);
				approvedate.setText(null);
				break;
			}

		}
	}

	public void showTable(String SQLGetConfig, String type, String[] Colnames) throws Throwable {
		// new General().msg(SQLGetConfig);
		rs = this.getSPResult(SQLGetConfig);
		((DefaultTableModel) model).setColumnIdentifiers(Colnames);
		table.setModel(model);
		while (rs.next()) {
			model.insertRow(0,
					new Object[] { "DEL", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14) });
			table.getCellRenderer(1, 3);
			table.setDefaultRenderer(Object.class, new posRenderer());
			new gnTable().setTableBasics(table);
			TR_Purchase tr = new TR_Purchase();
			TableColumnModel tcm = table.getColumnModel();
			for (int c = 0; c < 9; c++) {
				TableColumn tc = tcm.getColumn(c);
				tc.setCellRenderer(tr);
			}
		}
		scanItem.setText("");
		new gnTable().setTablewidth(table, 1, 30);
		new gnTable().setTablewidth(table, 2, 300);
		new gnTable().setTablewidth(table, 3, 50);
		new gnTable().setTablewidth(table, 4, 50);
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		records.setText(RecordCount1);
		poAmount.setText(Double.toString(new gnTable().getTotal(table, 6)));
		removeRow(model, table);
		table.setCellSelectionEnabled(true);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.gray);
		scanItem.setText("");
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification);
	
		
		
		// cellEnter();
	}// End Show Table

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 1);
			QtychangeImapct(value, row);
		}
	};
	private JButton btnBarcode;
	private JLabel lblNewLabel_2;
	private JTextField statecode;
	private JTextField statename;
	private JTextField regdlr;
	private JCheckBox chrevchrg;
	private JTextField from;
	private JTextField to;
	private JLabel lblNewLabel_4;

	public String QtychangeImapct(String value, int i) {
		System.out.println("Item is " + value + "Row is" + i);
		String curqty1 = (String) table.getValueAt(i, 3).toString();
		Double curqty = Double.parseDouble(curqty1);
		if (curqty == 0) {
			table.setEditingRow(i);
			table.setGridColor(Color.YELLOW);
			table.setBackground(Color.red);
		}
		Double vqty = Double.parseDouble(table.getValueAt(i, 3).toString());
		Double vcost = Double.parseDouble(table.getValueAt(i, 5).toString());
		Double vcostValue = vqty * vcost;
		table.setValueAt(vcostValue, i, 6);
		poAmount.setText(Double.toString(new gnTable().getTotal(table, 6)));
		new gnTable().setTablewidth(table, 1, 70);
		new gnTable().setTablewidth(table, 2, 300);
		new gnTable().setTablewidth(table, 3, 50);
		new gnTable().setTablewidth(table, 4, 50);
		String action = "Sucess";
		scanItem.grabFocus();
		return action;
	}

	public void removeRow(DefaultTableModel xmodel, JTable xtable) {
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
						String RecordCount1 = Integer.toString((new gnTable().getRowCount(tableName)));
						records.setText(RecordCount1);
						poAmount.setText(Double.toString(new gnTable().getTotal(tableName, 6)));
					}
					return;
				}
			}
		});

	}

	public String checkVendorEntry() {
		String vcode = VendorCode.getText();
		String action = "Sucess";
		if (vcode.length() == 0) {
			new General().msg("Select Vendor Code ");
			action = "Fail";
		}
		return action;
	}

	/// This is for Specific Cell Event Important //
	private void cellEnter() {
		JTextField cell = new JTextField();
		final TableCellEditor cellEditor = new DefaultCellEditor(cell);
		table.getColumnModel().getColumn(3).setCellEditor(cellEditor);
		InputMap iMap = cell.getInputMap(JComponent.WHEN_FOCUSED);
		iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), KeyEvent.getKeyText(KeyEvent.VK_ENTER));
		ActionMap aMap = cell.getActionMap();
		aMap.put(KeyEvent.getKeyText(KeyEvent.VK_ENTER), new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {
					showmsg(value, row);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				new General().msgDispose();
			}
		});
	}

	private void showmsg(String value, int row) {
		new General().msg("Qty is Changed ");
	}

	public void showArticle(String value) throws Throwable {
		String vcomp = companycode.getText();
		String vstore = Storecode.getText();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vtype = "PO";
		String vverticle = new gnHierarchy().getVerticleCode();
		String SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', " + vcomp + " , "
				+ vstore + " , '" + vfinyear + "' , " + vverticle + ")";
		// new General().msg(SQL);
		String result = new gnCheckArticle().checkArticleExist(table, value, 1);
		String vname = "Article";
		// String result = checkArticleExist(value) ;
		if (result == "Sucess")
			showTable(SQL, vname, PoCol);
		new gnTable().RemoveTableRows(smodel);
		checkVendorEntry();
	}

	public void showCustData() {
		int row = stable.getSelectedRow();
		String vcode = (String) stable.getValueAt(row, 1);
		String vname = (String) stable.getValueAt(row, 2);
		String vmobile = (String) stable.getValueAt(row, 3);
		String vemail = (String) stable.getValueAt(row, 4);
		String vcredit = (String) stable.getValueAt(row, 5);
		VendorCode.setText(vcode);
		VendorName.setText(vname);
		Mobile.setText(vmobile);
		Email.setText(vemail);
		creditDays.setText(vcredit);
		new gnTable().RemoveTableRows(smodel);
	}

	public void callUpload() throws Exception {
		String vff = "D:\\Manual_PO.xls";
		DefaultTableModel xmodel = model;
		xmodel.setColumnIdentifiers(PoCol);
		new gnTable().RemoveTableRows(model);
		DefaultTableModel model = new exportToExcel().ReadExcelData(vff, xmodel);
		table.setModel(model);
		table.getCellRenderer(1, 3);
		table.setDefaultRenderer(Object.class, new posRenderer());
		TR_Purchase tr = new TR_Purchase();
		TableColumnModel tcm = table.getColumnModel();
		for (int c = 0; c < 11; c++) {
			TableColumn tc = tcm.getColumn(c);
			tc.setCellRenderer(tr);
		}
		table.setEnabled(true);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.gray);
		new gnTable().setTablewidth(table, 1, 300);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
	}

	public void callSaveEvent() throws Throwable {

		vstorecode = Storecode.getText().trim();
		vpoDate = podate.getText().trim();
		if (EditMode == "N") {
			pono.setText(new gnSeq().getSeqno("4", "TR"));
		}
		vpono = Integer.parseInt(pono.getText());
		vtype = "MP";
		vvendor = Integer.parseInt(VendorCode.getText().trim());
		vcreateBy = new gnConfig().getUserCode();
		vupdateDate = podate.getText().trim();
		vcreditDays = Integer.parseInt(creditDays.getText());
		vpoamount = Double.parseDouble(poAmount.getText());
		vverticle = new gnHierarchy().getVerticleCode();

		boolean vselection = chrevchrg.isSelected();

		if (vselection) {
			vreversechrg = "Y";
		} else {
			vreversechrg = "N";

		}

		boolean checkapprovepo = approvepo.isSelected();

		if (checkapprovepo) {
			vapprovepo = "Y";
			vapprovedby = approvedby.getText();
			vapprovedate = new gnConfig().date_ConverttoDBforamt(approvedate.getText());
		} else {
			vapprovepo = "N";
			vapprovedby = " ";
			vapprovedate = "";
		}
		boolean checked = chkboxcform.isSelected();
		if (checked) {
			vcform = "Y";
		} else {
			vcform = "N";
		}

		if (EditMode == "Y") {
			String vvtype = "PO";
			new gnEDMiddleWare().POModification(vvtype, pono.getText(), podate.getText());
		}

		insertPoDetail();
	}

	public void insertPoDetail() throws Throwable { // new
													// General().msg("Inserting
													// now detail ok .") ;
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		String poshdr1 = "Insert into po_detail(Site_code , " + "po_no, po_date,  vendor , "
				+ "  Article_code , 	orderqty , " + " UOM ,  Tax_per," + "cost ,  MRP, " + "SalesPrice, poValue, "
				+ "  other_charges, "
				+ "TotalAmount , Bal_qty, bal_po_qty, company_code, verticle, cform, mbq, reversecharge, finyear, saleQty)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?, ?)";
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				double vpoqty = Double.parseDouble(table.getValueAt(k, 3).toString());
				if (vpoqty > 0) {
					prst = con1.prepareStatement(poshdr1);
					prst.setString(1, vstorecode);
					prst.setInt(2, vpono);
					prst.setString(3, new gnConfig().date_ConverttoDBforamt(vpoDate));
					prst.setInt(4, vvendor);
					prst.setString(5, (table.getValueAt(k, 1).toString()));
					prst.setDouble(6, (Double.parseDouble(table.getValueAt(k, 3).toString())));
					prst.setString(7, (table.getValueAt(k, 4).toString())); // uom
					prst.setString(8, (table.getValueAt(k, 10).toString())); // tax
					prst.setDouble(9, (Double.parseDouble(table.getValueAt(k, 5).toString())));
					prst.setDouble(10, (Double.parseDouble(table.getValueAt(k, 8).toString())));
					prst.setDouble(11, (Double.parseDouble(table.getValueAt(k, 7).toString())));
					prst.setDouble(12, (Double.parseDouble(table.getValueAt(k, 6).toString())));
					prst.setDouble(13, 00);
					prst.setDouble(14, (Double.parseDouble(table.getValueAt(k, 6).toString())));
					prst.setDouble(15, (Double.parseDouble(table.getValueAt(k, 9).toString())));
					prst.setDouble(16, (Double.parseDouble(table.getValueAt(k, 3).toString())));
					prst.setString(17, companycode.getText());
					prst.setString(18, vverticle);
					prst.setString(19, vcform);
					prst.setString(20, (table.getValueAt(k, 12).toString()));
					prst.setString(21, vreversechrg);
					prst.setString(22, new gnFinYear().getCurrentFinYear(podate.getText()));
					prst.setString(23, (table.getValueAt(k, 13).toString()));
					prst.addBatch();
					TotalRecordinsert = TotalRecordinsert + 1;
					DBdetail = "Fail";
					if (++TotalRecordinsert % batchSize == 0) {
						prst.executeBatch();
						DBdetail = "Sucess";
					}
					prst.executeBatch(); // insert remaining records
					DBdetail = "Sucess";
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con1.rollback();
			DBdetail = "Fail";
			new General().msg("Po Detail Insert " + e.getMessage());
		} finally {
			if (prst != null) {
				prst.close();
				if (DBdetail == "Sucess") {
					insertPoHdr();
				}
			}
		}
	}

	public void insertPoHdr() throws Throwable {
		if (DBdetail == "Sucess") {
			// new General().msg("Inserting po Header now .") ;
			prst = null;
			final int batchSize = 1;
			int TotalRecordinsert = 0;
			con2 = this.getConnection();
			con2.setAutoCommit(false);
			String poshdr = "Insert into po_hdr(Site_code , " + "po_Date, po_no,  type  , vendor , creditDays, "
					+ "Povalue , other_charges , Total_amount ,  updateDate, createBy, Status , verticle, Company_code ,"
					+ " cform, po_expiryDate, leadtime, approvepo, approvedby, approvedate, reversecharge, finyear)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?, ?,?)";
			try {
				prst = con2.prepareStatement(poshdr);
				prst.setString(1, vstorecode);
				prst.setString(2, new gnConfig().date_ConverttoDBforamt(vpoDate));
				prst.setInt(3, vpono);
				prst.setString(4, vtype);
				prst.setInt(5, vvendor);
				prst.setDouble(6, vcreditDays);
				prst.setDouble(7, vpoamount);
				prst.setDouble(8, 0.00);
				prst.setDouble(9, vpoamount);
				prst.setString(10, new gnConfig().date_ConverttoDBforamt(vpoDate));
				prst.setString(11, vcreateBy);
				prst.setString(12, "Open");
				prst.setString(13, vverticle);
				prst.setString(14, companycode.getText());
				prst.setString(15, vcform);
				prst.setString(16, new gnConfig().date_ConverttoDBforamt(expirydate.getText()));
				prst.setString(17, leadtime.getText());
				if (vapprovepo == "N") {
					prst.setString(18, vapprovepo);
					prst.setString(19, "Approval Pending");
					prst.setString(20, "0000.00.00");
				}

				if (vapprovepo == "Y") {
					prst.setString(18, vapprovepo);
					prst.setString(19, vapprovedby);
					prst.setString(20, vapprovedate);
				}
				prst.setString(21, vreversechrg);
				prst.setString(22, new gnFinYear().getCurrentFinYear(podate.getText()));
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
				new General().msg("PO Hdr Insert" + " " + e.getLocalizedMessage());
			} finally {
				if (prst != null) {
					prst.close();
				}
				if (DBhdr == "Sucess") {
					con1.commit();
					con2.commit();
					con1.close();
					con2.close();
					if (vapprovepo == "Y") {
						resetSave();
						purchaseInfoRecord();
					}
					if (vapprovepo == "N") {
						resetSaveUpdate();
					}

				}
			}
		}
	}

	// ====================
	//// reset options
	public String resetSave() throws Throwable {
		String Action = " ";
		new gnTable().RemoveTableRows(model);
		new General().msg("PO Number is " + vpono);
		vstorecode = Storecode.getText().trim();

		if (EditMode == "N") {
			new gnSeq().updateSeqno("4", "TR");
		}

		VendorCode.setText(null);
		VendorName.setText(null);
		Email.setText(null);
		Mobile.setText(null);
		leadtime.setText(null);
		expirydate.setText(null);
		poAmount.setText(null);
		chkboxcform.setSelected(false);
		records.setText("0");
		creditDays.setText("0");
		btnPrint.setEnabled(true);
		new General().msg("1.Data Saved  Sucessfully. < Reminder !!!  Approve PO For Goods Receive>");
		Action = "Sucess";

		return Action;
	}

	public String resetSaveUpdate() throws Throwable {
		String Action = " ";
		new gnTable().RemoveTableRows(model);
		vstorecode = Storecode.getText().trim();
		VendorCode.setText(null);
		VendorName.setText(null);
		btnPrint.setEnabled(true);
		Email.setText(null);
		Mobile.setText(null);
		leadtime.setText(null);
		expirydate.setText(null);
		poAmount.setText(null);
		chkboxcform.setSelected(false);
		records.setText("0");
		creditDays.setText("0");
		new General().msg("2.Data Save and Approval Process Updated Sucessfully");
		Action = "Sucess";

		return Action;
	}

	public void resetupdate() throws SQLException {
		new gnTable().RemoveTableRows(model);
		VendorCode.setEnabled(true);
		VendorName.setEnabled(true);
		VendorCode.setEditable(true);
		VendorName.setEditable(true);
		Email.setText(null);
		VendorCode.setText(null);
		VendorName.setText(null);
		Mobile.setText(null);
		leadtime.setText(null);
		expirydate.setText(null);
		poAmount.setText(null);
		chkboxcform.setSelected(false);
		approvedby.setText(null);
		approvedate.setText(null);
		approvepo.setSelected(false);
		records.setText("0");
		creditDays.setText("0");
		new General().msg("3. Data Updated Sucessfully..");

	}

	public void disableForUpdate() {
		VendorName.setEditable(false);
		VendorCode.setEditable(false);
		chkboxcform.setEnabled(false);
	}

	public void EnableForInsert() {
		VendorName.setEditable(true);
		VendorCode.setEditable(true);
		chkboxcform.setEnabled(true);
		scanItem.setEnabled(true);
		scanName.setEnabled(true);
		panel_3.setVisible(true);
		panel_7.setVisible(true);
		Email.setText(null);
		VendorCode.setText(null);
		VendorName.setText(null);
		Mobile.setText(null);
		leadtime.setText(null);
		expirydate.setText(null);
		poAmount.setText(null);
		chkboxcform.setSelected(false);
		approvedby.setText(null);
		approvedate.setText(null);
		approvepo.setSelected(false);

	}

	private void purchaseInfoRecord() {
		try {
			String vtype = "PO";
			String vdate;
			vdate = new gnConfig().date_ConverttoDBforamt(vpoDate);
			String SQL = "Call    PO_PurchaseInfoRecord(" + vcomp + ", " + vstore + " , '" + vtype + "', " + vpono
					+ ", '" + vdate + "')";
			this.getSPResult(SQL);
		} catch (ClassNotFoundException | SQLException e) {
			new General().msg(e.getLocalizedMessage());
		}
	}

	private void callprint() throws Throwable {

		String vpono = pono.getText();
		String vdoctype = "PO";
		new gnDocPrint().callprint(vdoctype, vpono, podate.getText());
	}

	private void setExpiryDate() throws NumberFormatException, ClassNotFoundException, SQLException, Exception {
		expirydate.setText(new gnConfig().get_duedate((new gnConfig().date_ConverttoDBforamt(podate.getText())),
				Integer.parseInt(leadtime.getText().toString())));

	}

	private void getInfoRecord() throws Throwable {
		int row = table.getSelectedRow();
		if (row >= 0) {
			String vsupplier = VendorCode.getText();
			String varticle = table.getValueAt(row, 1).toString();
			new gnPO().getPurchaseInfoRecord(vsupplier, varticle);
		} else {
			new General().msg("Select Article Row  To View  Purchase Info Record ..");
		}

	}
}// last

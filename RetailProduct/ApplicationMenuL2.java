package RetailProduct;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

//
import com.mysql.jdbc.Connection;
import com.sun.glass.ui.Window;

//import RetailProduct.ApplicationMenu.menulsnr;

import java.awt.event.InputEvent;
import javax.swing.JToolBar;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.border.TitledBorder;

public class ApplicationMenuL2 extends gnPublicVariable {

	public static JFrame ApplicationFrameMenuL2;

	JToolBar toolBar;
	JMenuItem menuPriceupdate;
	JMenuItem mntmCreateUser;

	JMenuItem dbparam;
	JMenu menuSalesOrder;
	static String vverticlename;
	JMenuItem mnSOview ;
	static String vverticlecode;
	JMenu mnReports;
	JMenu WMS;
	JMenu mnProduction ;
	JMenuItem mnTemplate;
	JMenu DBManagement;
	JMenuItem itemUpload;
	JMenu mnGr ;
	JMenu mnGST;
	JMenu menuTools;
	JMenu onRentModule;
	JMenuItem mntmManufactror;
	JMenuItem mnfulush;
	JMenu gstMenu;
	JMenu payrecpt ;
	JButton TCreditSales;
	JButton TDayBook;

	JButton TSalesReturn;
	JMenuItem simplePOS;
	JMenuItem GRNWITHBOX;
	// JMenuItem bulkBreaking;
	JMenuItem ApplyChanges;
	JButton TPurchaseReturn;
	JMenu Poromotion;
	JButton TExpense;
	JMenu mnUserManagement;
	JMenu DBchangeManagment;
	JMenuItem priceList;
	JMenu mnStoreOperation;
	JMenu mnMasters;
	JMenu mnStkadj;
	JMenuItem msSalesOrder;
	JMenu mnTransactions;
	JMenuItem menugstr1;
	JMenuItem menugstr2;
	JMenuItem menugst4;
	JMenuItem GST3B;
	JPopupMenu popupHelp;

	JMenuItem mntmFinYear;
	JMenu othMaster;
	JButton TIncome;
	JButton TViewLedger;
	JButton TGSTData;
	JButton TPL;
	JButton TBS;
	JMenuItem quotationManagement;
	JButton TSalesView;
	JButton TScanItem;
	JButton TPurView;
	JButton TStockView;
	JButton TSuplLedger;
	JMenu mnSupplier;
	JButton TCustLedger;
	JMenu mnProductConfiguration;

	public String userCode = null;
	JMenuItem DrugMaster;
	JMenuItem SupplierSchedule;
	JMenu mnCustomer;
	JMenuItem dynamicMbq;
	JMenuItem Grnwithinclusivetax;
	JButton btn1004;
	JButton btn1003;
	JButton btn1002;

	JMenuItem purchaseInfoRecord;
	JMenuItem DoctorMaster;
	JMenuItem patientMaster;
	JMenuItem Viewfarm;
	JMenu Fertilizer;
	JMenu farmerview;
	JMenu stockTransfer;
	JButton BtnLupdate;
	JMenu schemaManagement;
	JMenu mnSales;
	JMenu Hierarchy;

	public static String MenuSelection = " ";
	JMenuItem importDB;
	JMenuItem Addnewconfig;
	JMenuItem myJournalVoucher;
	public static JButton btnMessage;
	JMenuItem mnSalesReturn;
	JMenuItem mnExit;
	JMenuItem quickMenu;

	JMenuItem mnLedgerOpbal;
	JMenuItem hie_level1;
	JMenuItem hie_level2;
	JMenuItem hie_level3;
	JMenuItem hie_level4;
	JMenuItem helpmodule;
	JMenuItem menuGeneralMaster;

	JMenu PO;
	JMenuItem grwithpo;
	JMenuItem barcode;
	JMenu mnreport;

	JMenuItem shelftalker ;
 
	JMenuItem mntmSupl;
	JMenuItem mntmcustInfo;
	JMenu muCreditSales;

	JLabel lblf12;
	JLabel lblf2;
	JMenu menuAccounting;
	JMenuItem mntmBankdetail;
	JMenu mnDayEndSummary;
	JMenu mnBank1;
	JMenuItem mntmBankDeposit;
	JMenuItem menuSalereturn;
	JMenuItem menuPurchasereturn;

	JPanel shortcutpanel;

	JButton btnSupplier;
	JMenuItem mntmvndrPayment;
	JMenuItem mntmInvPayment;
	JButton btnSale;
	JButton btnPriceupdate;
	JButton btnPur;
	JButton btnDaybegin;
	JButton btnArticle;
	JButton btnreceiptvou;
	JButton btnpaymentvoucher;
	JButton btnContra;
	JButton btndayend;

	JMenuItem mnwholesale;
	private JMenu menuVoucher;
	public static JPanel bpanel;
	private JMenu mnVAT;
	JMenu menuEdit;
	private JMenu mnIndent;
	JMenu mnProductDataCheck;
	JMenu mnDataSync;
	JMenu mnCustomHierarchy;
	JMenuItem mntmViewConfiguration;
	JMenuItem mntmCreateNewArticleQuick;
	JMenuItem mntmCreateNewArticle;
	JMenuItem mntmSupplySchedule;
	JMenuItem mntmInfoRecord;
	JMenuItem homeDelivery;

	JMenu mnAccounting;
	JMenu mnAttributes;
	// Importatnt

	// Db Parameters
	Connection conn = null;
	Statement st = null;
	static public java.sql.CallableStatement cs;
	static public java.sql.PreparedStatement prst;
	static public ResultSet rs;
	static public String value;
	static public String DefaultHierachySet;
	static public String MenuPress;
	static public String Auth;
	static private JMenu mnproduction;
	static private JButton btnImage;
	JMenu Article ;
	static private JMenuItem mntmAdvSuppl;
	static private JMenuItem mntmAdvCust;
	static private JMenu mntmBbSales;
	static private JMenu mntmWlSales;
	static JMenu mnDeclaration;
	static JMenu mnnudynamic;
	static JMenu mnPurord;
	static JMenuItem mntmGrwithpo;
	private JMenu PharmaMaster;
	// End Db Parametrs

	//

	// Menu rights Managment For

	static private JMenu MenuAdmin;
	static public JMenuBar menuStoreOps;
	static private JMenuItem mntmConfigure;
	static private JMenuItem mntmCreateHierarchyDefinations;
	static private JMenuItem mntmListToNewcompnay;
	static private JMenuItem mntmSPListToStores;
	static private JMenuItem mntmdeccash;
	static private JComponent base;
	static private JTextField sfromat;
	private JMenuItem RecordDataOnlyforBeershop;
	private JMenuItem menuItem_4;
	private JMenuItem menuItem_5;
	private JMenuItem mnSalesOrderFinshItem;
	private JMenuItem soConsolidation;
	private JMenuItem poforSO;
	private JMenuItem menuitemChangeFinyear;
	private JMenuItem msquotation;
	private JMenuItem menuItemMaster;
	/// Manu End

	/**
	 * Launch the application.
	 * 
	 * @wbp.parser.entryPoint
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationMenuL2 window = new ApplicationMenuL2();
					window.ApplicationFrameMenuL2.setVisible(true);
					Thread t1 = new Thread();
					t1.start();
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
	 * @throws SQLException
	 * @wbp.parser.entryPoint
	 * 
	 */

	public ApplicationMenuL2() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 * @wbp.parser.entryPoint
	 */
	/**
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {

		ApplicationFrameMenuL2 = new JFrame();
		ActionListener sl = new menulsnr();
		ApplicationFrameMenuL2.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		// ApplicationFrameMenu.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\AKN\\myProductImage\\mretoo6.png"));
		ApplicationFrameMenuL2.getContentPane().setBackground(new Color(255, 0, 153));
		ApplicationFrameMenuL2.setBackground(new Color(0, 0, 102));
		ApplicationFrameMenuL2.setResizable(false);
		ApplicationFrameMenuL2.setBounds(0, 0, 1360, 775);
		ApplicationFrameMenuL2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		base = (JComponent) ApplicationFrameMenuL2.getContentPane();
		// String compName = new gnConfig().getCompany();
		String compName = "...";
		ActionListener ls1 = new menulsnr();
		ApplicationFrameMenuL2.getContentPane().setLayout(null);
		menuStoreOps = new JMenuBar();
		menuStoreOps.setBounds(0, 0, 1360, 26);
		menuStoreOps.setBackground(new Color(0, 0, 50));
		menuStoreOps.setForeground(Color.WHITE);
		// menuStoreOps.transferFocusDownCycle();

		menuStoreOps.setFont(new Font("Calibri", Font.PLAIN, 16));
		ApplicationFrameMenuL2.getContentPane().add(menuStoreOps);
		menuStoreOps.setForeground(new Color(0, 0, 102));
		menuStoreOps.setBackground(new Color(12, 0, 102));

		MenuAdmin = new JMenu("Admin");
		MenuAdmin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		MenuAdmin.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/mymainIcon7.ico")));
		MenuAdmin.setHorizontalAlignment(SwingConstants.LEFT);
		MenuAdmin.setBackground(new Color(0, 0, 51));
		MenuAdmin.setForeground(new Color(0, 0, 102));

		MenuAdmin.setMnemonic('D');
		menuStoreOps.add(MenuAdmin);

		mnUserManagement = new JMenu("User Management");
		mnUserManagement.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));

		mnUserManagement.setMnemonic('U');
		MenuAdmin.add(mnUserManagement);

		JMenu mnNewMenu = new JMenu("User");
		mnNewMenu.setFont(new Font("Calibri", Font.PLAIN, 15));

		mnNewMenu.setMnemonic('U');
		mnUserManagement.add(mnNewMenu);

		mntmCreateUser = new JMenuItem("Create User");
		mntmCreateUser.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnNewMenu.add(mntmCreateUser);
		mntmCreateUser.addActionListener(ls1);

		JMenuItem mntmChangePassword = new JMenuItem("Change Password");
		mntmChangePassword.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnNewMenu.add(mntmChangePassword);
		mntmChangePassword.addActionListener(ls1);

		;

		mnCustomHierarchy = new JMenu("Custom Hierarchy");
		mnCustomHierarchy.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		MenuAdmin.add(mnCustomHierarchy);

		JMenuItem hierarchyDesc = new JMenuItem("Hierarchy Description");
		hierarchyDesc.setFont(new Font("Calibri", Font.PLAIN, 15));
		hierarchyDesc.addActionListener(ls1);
		mnCustomHierarchy.add(hierarchyDesc);

		JMenuItem hierarchyAssign = new JMenuItem("Hierarchy Assignment");
		hierarchyAssign.setFont(new Font("Calibri", Font.PLAIN, 15));
		hierarchyAssign.addActionListener(ls1);
		mnCustomHierarchy.add(hierarchyAssign);
		JMenu mnBackup = new JMenu("Backup");
		mnBackup.setIcon(null);
		mnBackup.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));

		MenuAdmin.add(mnBackup);
		/*
		 * JMenuItem mntmScheduleBackup = new JMenuItem("Schedule Backup");
		 * mntmScheduleBackup.setFont(new Font("Calibri", Font.PLAIN, 15));
		 * mnBackup.add(mntmScheduleBackup);
		 */
		JMenuItem mntmFullBackup = new JMenuItem("Full Backup");
		mntmFullBackup.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, InputEvent.CTRL_MASK));
		mntmFullBackup.addActionListener(ls1);
		mntmFullBackup.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnBackup.add(mntmFullBackup);

		mnProductConfiguration = new JMenu("Product Configuration");
		mnProductConfiguration.setIcon(null);
		mnProductConfiguration.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		MenuAdmin.add(mnProductConfiguration);

		mntmFinYear = new JMenuItem("Financial Year");
		mntmFinYear.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		mntmFinYear.addActionListener(ls1);
		mnProductConfiguration.add(mntmFinYear);

		JMenuItem FreezeFinyear = new JMenuItem("Freeze Financial Year");
		FreezeFinyear.addActionListener(ls1);
		FreezeFinyear.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		mnProductConfiguration.add(FreezeFinyear);

		menuitemChangeFinyear = new JMenuItem("Change Financial Year");
		menuitemChangeFinyear.addActionListener(ls1);
		menuitemChangeFinyear.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		mnProductConfiguration.add(menuitemChangeFinyear);

		mntmConfigure = new JMenuItem("Configure");
		mntmConfigure.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		mnProductConfiguration.add(mntmConfigure);
		mntmConfigure.addActionListener(ls1);

		JMenuItem mntmNumberSequences = new JMenuItem("Number Sequences");
		mnProductConfiguration.add(mntmNumberSequences);
		mntmNumberSequences.addActionListener(ls1);
		mntmNumberSequences.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));

		Addnewconfig = new JMenuItem("Add Config Parameter");
		Addnewconfig.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		Addnewconfig.addActionListener(ls1);
		mnProductConfiguration.add(Addnewconfig);

		JMenuItem TAXslab = new JMenuItem("Tax Slab Managment");
		TAXslab.addActionListener(ls1);
		TAXslab.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		mnProductConfiguration.add(TAXslab);

		mnGST = new JMenu("GST");
		mnGST.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		MenuAdmin.add(mnGST);

		JMenuItem mntmGSTtaxdist = new JMenuItem("GST Tax Distribution");
		mnGST.add(mntmGSTtaxdist);
		mntmGSTtaxdist.setFont(new Font("Calibri", Font.PLAIN, 15));

		mntmGSTtaxdist.addActionListener(ls1);

		JMenuItem mntmTaxCategory = new JMenuItem("GST Tax Category");
		mnGST.add(mntmTaxCategory);
		mntmTaxCategory.setFont(new Font("Calibri", Font.PLAIN, 15));
		mntmTaxCategory.addActionListener(ls1);

		DBManagement = new JMenu("DB Managment");
		DBManagement.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		MenuAdmin.add(DBManagement);

		ApplyChanges = new JMenuItem("Apply Updates");
		ApplyChanges.addActionListener(ls1);
		ApplyChanges.setFont(new Font("Calibri", Font.PLAIN, 15));
		DBManagement.add(ApplyChanges);

		mnfulush = new JMenuItem("Flush Data");
		mnfulush.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnfulush.addActionListener(ls1);

		dbparam = new JMenuItem("DB Parameters");
		dbparam.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		dbparam.addActionListener(ls1);
		MenuAdmin.add(dbparam);
		MenuAdmin.add(mnfulush);

		mnStoreOperation = new JMenu("Store Operation");
		// mnStoreOperation.setIcon(new
		// ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/arrow_right.jpg")));
		mnStoreOperation.setForeground(new Color(0, 0, 153));
		mnStoreOperation.setFont(new Font("Tahoma", Font.BOLD, 14));
		mnStoreOperation.setMnemonic(' ');
		menuStoreOps.add(mnStoreOperation);

		JMenu mnDaybegin = new JMenu("Day");
		mnDaybegin.setForeground(Color.WHITE);
		mnDaybegin.setBackground(new Color(0, 0, 128));
		mnDaybegin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnStoreOperation.add(mnDaybegin);

		JMenuItem mntmDayBegin = new JMenuItem("Day Begin");
		mntmDayBegin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mntmDayBegin.setForeground(new Color(0, 0, 102));
		mntmDayBegin.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnDaybegin.add(mntmDayBegin);
		mntmDayBegin.addActionListener(ls1);

		JMenuItem mntmDayEnd = new JMenuItem("Day End");
		mntmDayEnd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		mntmDayEnd.setForeground(new Color(0, 0, 153));
		mntmDayEnd.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnDaybegin.add(mntmDayEnd);
		mntmDayEnd.addActionListener(ls1);

		mnDeclaration = new JMenu("Declaration");
		mnDeclaration.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnStoreOperation.add(mnDeclaration);

		mntmdeccash = new JMenuItem("Cashier Declaration for POS");
		mntmdeccash.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnDeclaration.add(mntmdeccash);
		mntmdeccash.addActionListener(ls1);

		mnMasters = new JMenu("Masters");
		// mnMasters.setIcon(new
		// ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/arrow_right.jpg")));
		mnMasters.setForeground(new Color(0, 0, 153));
		mnMasters.setFont(new Font("Tahoma", Font.BOLD, 14));
		mnMasters.setMnemonic('M');
		menuStoreOps.add(mnMasters);

		JMenu mnNewMenu_1 = new JMenu("Company");
		mnNewMenu_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnMasters.add(mnNewMenu_1);

		JMenuItem mntmCompanyMaster = new JMenuItem("Company Master");
		mntmCompanyMaster.setFont(new Font("Calibri", Font.PLAIN, 15));
		mntmCompanyMaster.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, ActionEvent.CTRL_MASK));
		mntmCompanyMaster.setAccelerator(KeyStroke.getKeyStroke('C'));
		mnNewMenu_1.add(mntmCompanyMaster);
		mntmCompanyMaster.addActionListener(ls1);

		JMenu mnBranchsite = new JMenu("Branch/Site ");
		mnBranchsite.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnMasters.add(mnBranchsite);

		JMenuItem mntmCreateSite = new JMenuItem("Create Site");
		mntmCreateSite.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnBranchsite.add(mntmCreateSite);
		mntmCreateSite.addActionListener(ls1);

		mnSupplier = new JMenu("Supplier");
		mnSupplier.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnMasters.add(mnSupplier);

		JMenuItem mntmCreateSupplier = new JMenuItem("Create Supplier");
		mntmCreateSupplier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmCreateSupplier.setFont(new Font("Calibri", Font.PLAIN, 15));
		mntmCreateSupplier.addActionListener(ls1);
		mnSupplier.add(mntmCreateSupplier);

		SupplierSchedule = new JMenuItem("Supplier-Supply Schedule");
		SupplierSchedule.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_MASK));
		SupplierSchedule.addActionListener(ls1);
		mnSupplier.add(SupplierSchedule);

		mnCustomer = new JMenu("Customer");
		mnCustomer.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnMasters.add(mnCustomer);

		JMenuItem mntmCreateCustomer = new JMenuItem("Create Customer");
		mntmCreateCustomer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmCreateCustomer.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnCustomer.add(mntmCreateCustomer);
		mntmCreateCustomer.addActionListener(ls1);

		mnAttributes = new JMenu("Article Attributes");
		mnAttributes.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnMasters.add(mnAttributes);

		mntmManufactror = new JMenuItem("Manufacturar");
		mntmManufactror.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnAttributes.add(mntmManufactror);
		mntmManufactror.addActionListener(ls1);

		JMenuItem mntmBrand = new JMenuItem("Brand");
		mntmBrand.setFont(new Font("Calibri", Font.PLAIN, 15));
		mntmBrand.addActionListener(ls1);
		mnAttributes.add(mntmBrand);

		JMenu mnArticleitemMaster = new JMenu("Article/Item Master");
		mnArticleitemMaster.setIcon(null);
		mnArticleitemMaster.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnMasters.add(mnArticleitemMaster);

		// mntmCreateNewArticleQuick = new JMenuItem("Quick -Create New
		// Article-");
		// mntmCreateNewArticleQuick.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
		// 0));
		// mntmCreateNewArticleQuick.setFont(new Font("Calibri", Font.PLAIN,
		// 15));
		// mnArticleitemMaster.add(mntmCreateNewArticleQuick);
		// mntmCreateNewArticleQuick.addActionListener(ls1);

		JMenuItem mntmPriceUpdate = new JMenuItem("Update Price & Tax");
		mntmPriceUpdate.addActionListener(ls1);

		JMenuItem mapBarcode = new JMenuItem("Barcode Mapping");
		mapBarcode.addActionListener(ls1);
		mnArticleitemMaster.add(mapBarcode);
		mntmPriceUpdate.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnArticleitemMaster.add(mntmPriceUpdate);

		menuItemMaster = new JMenuItem("Item Master");
		menuItemMaster.addActionListener(ls1);
		mnArticleitemMaster.add(menuItemMaster);

		JMenuItem mntmassign = new JMenuItem("Assign Brand & Hierarchy");
		mnArticleitemMaster.add(mntmassign);
		mntmassign.addActionListener(ls1);
		mntmassign.setFont(new Font("Calibri", Font.PLAIN, 12));

		itemUpload = new JMenuItem("Item Upload Utility");
		itemUpload.addActionListener(ls1);
		mnArticleitemMaster.add(itemUpload);

		Poromotion = new JMenu("Promotion");
		Poromotion.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnMasters.add(Poromotion);

		JMenuItem createPromotion = new JMenuItem("Create Promotion");
		createPromotion.addActionListener(ls1);
		createPromotion.setFont(new Font("Calibri", Font.BOLD, 15));
		Poromotion.add(createPromotion);

		JMenuItem menupromoexcludeitemlist = new JMenuItem("Exclude Promo Item List");
		menupromoexcludeitemlist.addActionListener(ls1);
		menupromoexcludeitemlist.setFont(new Font("Calibri", Font.PLAIN, 15));
		Poromotion.add(menupromoexcludeitemlist);

		mnProduction = new JMenu("Production");
		mnMasters.add(mnProduction);

		mnTemplate = new JMenuItem("Create Template");
		mnTemplate.addActionListener(ls1);
		mnTemplate.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnProduction.add(mnTemplate);

		othMaster = new JMenu("Other Master");
		othMaster.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnMasters.add(othMaster);

		JMenuItem citymaster = new JMenuItem("City Master");
		citymaster.setFont(new Font("Calibri", Font.PLAIN, 15));
		citymaster.addActionListener(ls1);
		othMaster.add(citymaster);

		JMenuItem bankDetails = new JMenuItem("Bank Details");
		bankDetails.setFont(new Font("Calibri", Font.PLAIN, 15));
		bankDetails.addActionListener(ls1);
		othMaster.add(bankDetails);

		menuGeneralMaster = new JMenuItem("General Master");
		menuGeneralMaster.setFont(new Font("Calibri", Font.PLAIN, 15));
		menuGeneralMaster.addActionListener(ls1);
		othMaster.add(menuGeneralMaster);

		PharmaMaster = new JMenu("Pharma");
		PharmaMaster.setFont(new Font("Calibri", Font.PLAIN, 15));
		othMaster.add(PharmaMaster);

		DrugMaster = new JMenuItem("Drug Master");
		PharmaMaster.add(DrugMaster);
		DrugMaster.setFont(new Font("Calibri", Font.PLAIN, 15));

		DoctorMaster = new JMenuItem("Doctor Master");
		PharmaMaster.add(DoctorMaster);
		DoctorMaster.setFont(new Font("Calibri", Font.PLAIN, 15));

		patientMaster = new JMenuItem("Patient Master");
		PharmaMaster.add(patientMaster);
		patientMaster.setFont(new Font("Calibri", Font.PLAIN, 15));

		Fertilizer = new JMenu("Fertlizer");
		othMaster.add(Fertilizer);

		JMenuItem doseManagement = new JMenuItem("Drug Dose Management");
		doseManagement.addActionListener(ls1);
		Fertilizer.add(doseManagement);

		menuPriceupdate = new JMenuItem("Menu Price Update");
		menuPriceupdate.addActionListener(ls1);
		menuPriceupdate.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnMasters.add(menuPriceupdate);

		patientMaster.addActionListener(ls1);
		DoctorMaster.addActionListener(ls1);
		DrugMaster.addActionListener(ls1);

		mnTransactions = new JMenu("Transactions");
		mnTransactions.setIcon(null);
		// mnTransactions.setIcon(new
		// ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/arrow_right.jpg")));
		mnTransactions.setForeground(new Color(0, 0, 102));
		mnTransactions.setMnemonic('T');
		mnTransactions.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuStoreOps.add(mnTransactions);

		WMS = new JMenu("Warehouse");
		WMS.setForeground(new Color(0, 0, 102));
		WMS.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuStoreOps.add(WMS);

		JMenu wmsRepacking = new JMenu("Repacking");
		wmsRepacking.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		WMS.add(wmsRepacking);

		JMenuItem wmsRepackage = new JMenuItem("Repacking - Bulk to Chld Conversion");
		wmsRepackage.addActionListener(ls1);
		wmsRepackage.setFont(new Font("Calibri", Font.PLAIN, 15));
		wmsRepacking.add(wmsRepackage);

		JMenu wmsStockCheck = new JMenu("Stock Check");
		wmsStockCheck.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		WMS.add(wmsStockCheck);

		JMenuItem wmsStockchk1 = new JMenuItem("Physical Stock Entry");
		wmsStockchk1.addActionListener(ls1);
		wmsStockchk1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		wmsStockCheck.add(wmsStockchk1);

		JMenuItem wmsStockchk2 = new JMenuItem("Generate Stock Variance");
		wmsStockchk2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		wmsStockchk2.addActionListener(ls1);
		wmsStockCheck.add(wmsStockchk2);

		JMenuItem wmsStockchk3 = new JMenuItem("Stock Variance Posting");
		wmsStockchk3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		wmsStockchk3.addActionListener(ls1);
		wmsStockCheck.add(wmsStockchk3);

		JMenuItem wmsStockchk4 = new JMenuItem("Location Stock Transfer");
		wmsStockchk4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		wmsStockchk3.setFont(new Font("Calibri", Font.PLAIN, 15));
		wmsStockchk3.addActionListener(ls1);
		wmsStockCheck.add(wmsStockchk4);

		menuAccounting = new JMenu("Accounting");
		menuAccounting.setForeground(new Color(0, 0, 102));
		menuAccounting.setMnemonic('A');
		menuAccounting.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuStoreOps.add(menuAccounting);

		JMenuItem accCreateLedger = new JMenuItem("Create Ledger");
		accCreateLedger.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0));
		accCreateLedger.addActionListener(ls1);
		accCreateLedger.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		menuAccounting.add(accCreateLedger);

		mnLedgerOpbal = new JMenuItem("Ledger Opening Balance Entry");
		mnLedgerOpbal.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 0));
		menuAccounting.add(mnLedgerOpbal);
		mnLedgerOpbal.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		mnLedgerOpbal.addActionListener(ls1);

		mntmBankdetail = new JMenuItem("Bank Details");
		menuAccounting.add(mntmBankdetail);
		mntmBankdetail.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		mntmBankdetail.addActionListener(ls1);

		menuVoucher = new JMenu("Voucher");
		menuAccounting.add(menuVoucher);
		menuVoucher.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));

		JMenuItem PmtVoucher = new JMenuItem("Payment Voucher");
		PmtVoucher.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		menuVoucher.add(PmtVoucher);
		PmtVoucher.addActionListener(ls1);
		PmtVoucher.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));

		JMenuItem recptVoucher = new JMenuItem("Receipt Voucher");
		recptVoucher.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F11, 0));
		menuVoucher.add(recptVoucher);
		recptVoucher.addActionListener(ls1);
		recptVoucher.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));

		menuItem_4 = new JMenuItem("Expense Voucher");
		menuItem_4.addActionListener(ls1);
		menuItem_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		menuVoucher.add(menuItem_4);

		menuItem_5 = new JMenuItem("Income Voucher");
		menuItem_5.addActionListener(ls1);
		menuItem_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		menuVoucher.add(menuItem_5);

		mntmBankDeposit = new JMenuItem("Contra Entry");
		menuVoucher.add(mntmBankDeposit);
		mntmBankDeposit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0));
		mntmBankDeposit.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mntmBankDeposit.addActionListener(ls1);

		JMenuItem voucherEntryModule = new JMenuItem("Voucher Entry");
		menuVoucher.add(voucherEntryModule);
		voucherEntryModule.addActionListener(ls1);

		myJournalVoucher = new JMenuItem("Journal Voucher");
		menuVoucher.add(myJournalVoucher);
		myJournalVoucher.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, 0));
		myJournalVoucher.setFont(new Font("Calibri", Font.PLAIN, 15));
		myJournalVoucher.addActionListener(ls1);

		mnReports = new JMenu("View");
		mnReports.setForeground(new Color(0, 0, 102));
		mnReports.setMnemonic('V');
		mnReports.setFont(new Font("Tahoma", Font.BOLD, 14));
		menuStoreOps.add(mnReports);

		JMenuItem daybook = new JMenuItem("Day Book");
		daybook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD0, 0));
		daybook.setFont(new Font("Tahoma", Font.PLAIN, 15));
		daybook.addActionListener(ls1);
		mnReports.add(daybook);

		JMenu mnrpSales = new JMenu("Sales View");
		mnrpSales.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mnReports.add(mnrpSales);

		JMenuItem mntmDaily = new JMenuItem("Daily Sales & Margin");
		mntmDaily.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0));
		mntmDaily.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnrpSales.add(mntmDaily);
		mntmDaily.addActionListener(ls1);

		JMenu mnrppurchase = new JMenu("Purchase View");
		mnrppurchase.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mnReports.add(mnrppurchase);

		JMenuItem mntmDailyPurchase = new JMenuItem("Daily Purchase");
		mntmDailyPurchase.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0));
		mntmDailyPurchase.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnrppurchase.add(mntmDailyPurchase);

		JMenuItem PRSRView = new JMenuItem("SR-PR View");
		PRSRView.setFont(new Font("Calibri", Font.PLAIN, 15));
		PRSRView.addActionListener(ls1);
		mnrppurchase.add(PRSRView);
		mntmDailyPurchase.addActionListener(ls1);

		JMenu mnrpStock = new JMenu("Stock View");
		mnrpStock.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mnReports.add(mnrpStock);

		JMenuItem mntmstockCheck = new JMenuItem("Check Stock");
		mntmstockCheck.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0));
		mntmstockCheck.setFont(new Font("Calibri", Font.PLAIN, 15));
		mntmstockCheck.addActionListener(ls1);
		mnrpStock.add(mntmstockCheck);

		Article = new JMenu("Article View");
		Article.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mnReports.add(Article);

		JMenuItem viewArticleData = new JMenuItem("View Article Data");
		viewArticleData.setFont(new Font("Calibri", Font.PLAIN, 15));
		viewArticleData.addActionListener(ls1);
		Article.add(viewArticleData);

		JMenu mnSupplierView = new JMenu("Supplier View");
		mnSupplierView.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mnReports.add(mnSupplierView);

		mntmSupl = new JMenuItem("Supplier Info");
		mntmSupl.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, 0));
		mntmSupl.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnSupplierView.add(mntmSupl);
		mntmSupl.addActionListener(ls1);

		JMenu mncustview = new JMenu("Customer View");
		mncustview.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mnReports.add(mncustview);

		mntmcustInfo = new JMenuItem("Customer Sales Info");
		mntmcustInfo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0));
		mncustview.add(mntmcustInfo);
		mntmcustInfo.addActionListener(ls1);

		mnSOview = new JMenuItem("Sales Order View");
		mnSOview.addActionListener(ls1);
		mnReports.add(mnSOview);

		payrecpt = new JMenu("Accounting");
		payrecpt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mnReports.add(payrecpt);

		JMenuItem payreceiptview = new JMenuItem("Payment/Receipt/Contra");
		payreceiptview.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0));
		payreceiptview.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		payreceiptview.addActionListener(ls1);
		payrecpt.add(payreceiptview);

		JMenuItem menuItem = new JMenuItem("View Ledger Balances");
		menuItem.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		menuItem.addActionListener(ls1);
		payrecpt.add(menuItem);

		JMenuItem menuItem_1 = new JMenuItem("View Income/Expenses");
		menuItem_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		menuItem_1.addActionListener(ls1);
		payrecpt.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("P&L Account");
		menuItem_2.addActionListener(ls1);
		menuItem_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		payrecpt.add(menuItem_2);

		JMenuItem menuItem_3 = new JMenuItem("Balance Sheet");
		menuItem_3.addActionListener(ls1);
		menuItem_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		payrecpt.add(menuItem_3);

		farmerview = new JMenu("Farmer View");
		farmerview.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mnReports.add(farmerview);

		Viewfarm = new JMenuItem("View Farmer");
		Viewfarm.addActionListener(ls1);
		farmerview.add(Viewfarm);

		mnVAT = new JMenu(" VAT ");
		mnVAT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mnReports.add(mnVAT);

		JMenuItem mntmVAT1 = new JMenuItem(" VAT Payable View");
		mntmVAT1.setFont(new Font("Calibri", Font.PLAIN, 15));
		mntmVAT1.addActionListener(ls1);
		mnVAT.add(mntmVAT1);

		schemaManagement = new JMenu("View Schema");
		schemaManagement.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mnReports.add(schemaManagement);

		JMenuItem viewschma = new JMenuItem("View Data");
		viewschma.addActionListener(ls1);
		schemaManagement.add(viewschma);

		helpmodule = new JMenuItem("Help");
		helpmodule.setFont(new Font("Tahoma", Font.PLAIN, 15));
		helpmodule.addActionListener(ls1);
		mnReports.add(helpmodule);

		mnSales = new JMenu("Sales");
		// mnSales.setIcon(new
		// ImageIcon("D:\\AKN\\myProductImage\\menulogo.png"));
		mnSales.setMnemonic('s');
		mnSales.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnTransactions.add(mnSales);

		 
 		
		menuSalesOrder = new JMenu("Sales Order Managment");
		mnTransactions.add(menuSalesOrder);

		msquotation = new JMenuItem("Quotation");
		msquotation.addActionListener(ls1);
		msquotation.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		menuSalesOrder.add(msquotation);

		msSalesOrder = new JMenuItem("Sales Order");
		menuSalesOrder.add(msSalesOrder);
		msSalesOrder.addActionListener(ls1);
		msSalesOrder.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));

		mnSalesOrderFinshItem = new JMenuItem("Sales Order-Production");
		mnSalesOrderFinshItem.addActionListener(ls1);
		mnSalesOrderFinshItem.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		menuSalesOrder.add(mnSalesOrderFinshItem);

		soConsolidation = new JMenuItem("Sales Order Consolidation");
		soConsolidation.addActionListener(ls1);
		soConsolidation.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		menuSalesOrder.add(soConsolidation);

		poforSO = new JMenuItem("Generate Purchase Order");
		poforSO.addActionListener(ls1);
		poforSO.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		menuSalesOrder.add(poforSO);

		JMenuItem mnDeliveryChallan = new JMenuItem("Delivery Challan");
		menuSalesOrder.add(mnDeliveryChallan);
		mnDeliveryChallan.addActionListener(ls1);
		mnDeliveryChallan.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));

		JMenuItem mnDeliveryRejection = new JMenuItem("Delivery Rejection");
		mnDeliveryRejection.addActionListener(ls1);
		mnDeliveryRejection.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		menuSalesOrder.add(mnDeliveryRejection);

		JMenuItem mnBookInvaginstchallan = new JMenuItem("Book Invoice");
		mnBookInvaginstchallan.addActionListener(ls1);
		mnBookInvaginstchallan.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		menuSalesOrder.add(mnBookInvaginstchallan);

		onRentModule = new JMenu("Rented Sales Module");
		onRentModule.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnTransactions.add(onRentModule);

		JMenuItem rentsale = new JMenuItem("Book Rent Sales");
		rentsale.addActionListener(ls1);
		rentsale.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		onRentModule.add(rentsale);

		JMenuItem mntmNewMenuItem = new JMenuItem("Receive Rented Goods");
		mntmNewMenuItem.addActionListener(ls1);
		mntmNewMenuItem.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));

		onRentModule.add(mntmNewMenuItem);

		PO = new JMenu("Purchase Order");
		PO.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		// mntmAdvSuppl .setFont(new Font("Calibri", Font.PLAIN, 15));
		mnTransactions.add(PO);

		JMenuItem manualPO = new JMenuItem("Purchase Order");
		manualPO.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		manualPO.addActionListener(ls1);
		PO.add(manualPO);

		mnGr = new JMenu("Goods Receive");
		mnGr.setMnemonic('g');
		mnGr.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnTransactions.add(mnGr);

 
		GRNWITHBOX = new JMenuItem("Book Puchase-BOX");
		GRNWITHBOX.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		GRNWITHBOX.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		GRNWITHBOX.addActionListener(ls1);
		mnGr.add(GRNWITHBOX);

		barcode = new JMenuItem("Generate Barcode");
		barcode.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		barcode.addActionListener(ls1);
		mnGr.add(barcode);

 		
		shelftalker = new JMenuItem("Print ShelfTalkers");
		shelftalker.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		shelftalker.addActionListener(ls1);
		mnGr.add(shelftalker);

		dynamicMbq = new JMenuItem("Dynamic MBQ Generation");
		dynamicMbq.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		dynamicMbq.addActionListener(ls1);
		mnGr.add(dynamicMbq);

		purchaseInfoRecord = new JMenuItem("Purchase Info Record");
		purchaseInfoRecord.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		purchaseInfoRecord.addActionListener(ls1);
		mnGr.add(purchaseInfoRecord);

		JMenuItem mntmPosSales = new JMenuItem("POS");
		mntmPosSales.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		mntmPosSales.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mntmPosSales.addActionListener(ls1);
		mnSales.add(mntmPosSales);

		simplePOS = new JMenuItem("Simple Retail POS");
		simplePOS.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		simplePOS.addActionListener(ls1);
		mnSales.add(simplePOS);

		muCreditSales = new JMenu("Credit Sales");
		muCreditSales.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnSales.add(muCreditSales);

		mnwholesale = new JMenuItem("Book Credit Sales");
		mnwholesale.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mnwholesale.setFont(new Font("Calibri", Font.PLAIN, 15));
		mnwholesale.addActionListener(ls1);

		priceList = new JMenuItem("Maintain Price List");
		priceList.setFont(new Font("Calibri", Font.PLAIN, 15));
		priceList.addActionListener(ls1);
		muCreditSales.add(priceList);

		quotationManagement = new JMenuItem("Creatre Quotation");
		quotationManagement.setFont(new Font("Calibri", Font.PLAIN, 15));
		quotationManagement.addActionListener(ls1);
		muCreditSales.add(quotationManagement);
		muCreditSales.add(mnwholesale);

		homeDelivery = new JMenuItem("Home Delivery Management");
		homeDelivery.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		homeDelivery.addActionListener(ls1);
		mnSales.add(homeDelivery);

		RecordDataOnlyforBeershop = new JMenuItem("Scan Item For Sales");
		RecordDataOnlyforBeershop.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		RecordDataOnlyforBeershop.addActionListener(ls1);
		mnSales.add(RecordDataOnlyforBeershop);

		JMenuItem mntmwhsales = new JMenuItem("Sales");
		mntmwhsales.setFont(new Font("Calibri", Font.PLAIN, 15));
		mntmwhsales.addActionListener(ls1);

		menuSalereturn = new JMenuItem("Sales Return");
		menuSalereturn.addActionListener(ls1);
		menuSalereturn.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnTransactions.add(menuSalereturn);

 		
		menuPurchasereturn = new JMenuItem("Purchase Return");
		menuPurchasereturn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		menuPurchasereturn.addActionListener(ls1);
		menuPurchasereturn.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnTransactions.add(menuPurchasereturn);

		stockTransfer = new JMenu("Internal Stock Transfer");
		stockTransfer.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnTransactions.add(stockTransfer);

		JMenuItem stockout = new JMenuItem("Stock Out");
		stockout.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		stockout.addActionListener(ls1);
		stockTransfer.add(stockout);

		JMenuItem stockin = new JMenuItem("Stock In");
		stockin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		stockin.addActionListener(ls1);
		stockTransfer.add(stockin);

		//

		mnStkadj = new JMenu("Stock Check");
		mnStkadj.setMnemonic('A');
		mnStkadj.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnTransactions.add(mnStkadj);

		JMenuItem mntmAstk = new JMenuItem("Physical Stock Entry");
		mntmAstk.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		mnStkadj.add(mntmAstk);
		mntmAstk.addActionListener(ls1);

		JMenuItem mntmStockvariance = new JMenuItem("Generate Stock Variance");
		mntmStockvariance.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		mntmStockvariance.addActionListener(ls1);
		mnStkadj.add(mntmStockvariance);

		JMenuItem mntmPostingSV = new JMenuItem("Stock Variance Posting");
		mntmPostingSV.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		mnStkadj.add(mntmPostingSV);
		// ActionListener sv7 = new menulsnr();
		mntmPostingSV.addActionListener(ls1);

		JMenuItem mntmLoc = new JMenuItem("Location Stock Transfer");
		mntmLoc.addActionListener(ls1);
		mntmLoc.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		mnStkadj.add(mntmLoc);

		JMenuItem manualStockAdj = new JMenuItem("Stock Adjusment");
		manualStockAdj.addActionListener(ls1);
		manualStockAdj.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		mnTransactions.add(manualStockAdj);
		//

		gstMenu = new JMenu("GST");
		gstMenu.setForeground(new Color(0, 0, 102));
		// gstMenu.setIcon(new
		// ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/arrow_right.jpg")));
		gstMenu.setMnemonic('G');
		menuStoreOps.add(gstMenu);
		gstMenu.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));

		JMenu gstviewData = new JMenu("View GST Data");
		gstviewData.setFont(new Font("Calibri", Font.PLAIN, 15));
		gstMenu.add(gstviewData);

		JMenuItem viewReturns = new JMenuItem("View GST Return File Data");
		viewReturns.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD9, 0));
		viewReturns.addActionListener(ls1);
		viewReturns.setFont(new Font("Calibri", Font.PLAIN, 15));
		gstviewData.add(viewReturns);

		menugstr1 = new JMenuItem("GSTR 1");
		menugstr1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0));
		menugstr1.addActionListener(ls1);
		menugstr1.setFont(new Font("Calibri", Font.PLAIN, 15));
		gstviewData.add(menugstr1);

		menugstr2 = new JMenuItem("GSTR 2");
		menugstr2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0));
		menugstr2.addActionListener(ls1);
		menugstr2.setFont(new Font("Calibri", Font.PLAIN, 15));
		gstviewData.add(menugstr2);

		menugst4 = new JMenuItem("GSTR 4");
		menugst4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0));
		menugst4.addActionListener(sl);
		menugst4.setFont(new Font("Calibri", Font.PLAIN, 15));
		gstviewData.add(menugst4);

		GST3B = new JMenuItem("GSTR 3B");
		GST3B.addActionListener(ls1);
		GST3B.setFont(new Font("Calibri", Font.PLAIN, 15));
		gstviewData.add(GST3B);

		menuTools = new JMenu("Tools");
		menuTools.setForeground(new Color(0, 0, 102));
		menuTools.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		menuTools.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/mymainIcon8.ico")));
		menuStoreOps.add(menuTools);

		JMenuItem audit_GstAccount = new JMenuItem("Audit-GST and Accounting(Bulk Reposting");
		audit_GstAccount.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		audit_GstAccount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD1, 0));
		audit_GstAccount.addActionListener(ls1);
		menuTools.add(audit_GstAccount);

		JMenuItem Audit_SingleEntryAccountGST = new JMenuItem("Audit & Reposting(Single Entry)");
		Audit_SingleEntryAccountGST.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		Audit_SingleEntryAccountGST.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0));
		menuTools.add(Audit_SingleEntryAccountGST);
		Audit_SingleEntryAccountGST.addActionListener(ls1);

		JMenuItem audit_transactions = new JMenuItem("Audit-Transactions");
		audit_transactions.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		audit_transactions.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD3, 0));
		audit_transactions.addActionListener(ls1);
		menuTools.add(audit_transactions);

		JMenuItem Audit_Stock = new JMenuItem("Audit-Inventory");
		Audit_Stock.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		Audit_Stock.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD4, 0));
		Audit_Stock.addActionListener(ls1);
		menuTools.add(Audit_Stock);

		JMenuItem Audit_MasterData = new JMenuItem("Audit-Master Data & Others");
		Audit_MasterData.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		Audit_MasterData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0));
		Audit_MasterData.addActionListener(ls1);
		menuTools.add(Audit_MasterData);

		JMenuItem Audit_AccountPostingData = new JMenuItem("Account Posting Audit in Account Table");
		Audit_AccountPostingData.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		Audit_AccountPostingData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD6, 0));
		Audit_AccountPostingData.addActionListener(ls1);
		menuTools.add(Audit_AccountPostingData);

		mnreport = new JMenu("Reports");
		mnreport.setMnemonic('R');
		// mnreport.setIcon(new
		// ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/arrow_right.jpg")));
		mnreport.setForeground(new Color(0, 0, 102));
		mnreport.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		menuStoreOps.add(mnreport);

		JMenu mnSalesRep = new JMenu("Sales");
		mnreport.add(mnSalesRep);
		mnSalesRep.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));

		JMenuItem mntmSalesRep = new JMenuItem("Sales Reports");
		mnSalesRep.add(mntmSalesRep);
		mntmSalesRep.setFont(new Font("Calibri", Font.PLAIN, 15));
		mntmSalesRep.addActionListener(ls1);

		JMenu mnPurRep = new JMenu("Purchase");
		mnreport.add(mnPurRep);
		mnPurRep.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));

		JMenuItem mntmPur = new JMenuItem("Purchase Report");
		mnPurRep.add(mntmPur);
		mntmPur.setFont(new Font("Calibri", Font.PLAIN, 15));
		mntmPur.addActionListener(ls1);

		mnExit = new JMenuItem(
				"                                                                                                                                                                                                                                       Exit");
		mnExit.setHorizontalAlignment(SwingConstants.RIGHT);
		mnExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		mnExit.setIcon(null);
		mnExit.setFont(new Font("Calibri", Font.PLAIN, 15));
		menuStoreOps.add(mnExit);

		btnImage = new JButton("");
		btnImage.setBounds(1049, 52, 293, 172);
		btnImage.setSelectedIcon(null);
		btnImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// selectRow1() ;
			}
		});
		
		btnImage.setHorizontalAlignment(SwingConstants.RIGHT);
		btnImage.setBackground(new Color(153, 0, 153));
		ApplicationFrameMenuL2.getContentPane().add(btnImage);
		// btnDaybegin.addActionListener(btn);
		// btnDaybegin.addActionListener(btn);

		ActionListener btn = new btnLsnt();

		JButton btn1001 = new JButton(" ");
		btn1001.setBackground(new Color(255, 255, 204));
		btn1001.setBounds(0, 52, 1050, 172);
		btn1001.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/frame9.png")));
		ApplicationFrameMenuL2.getContentPane().add(btn1001);
		sfromat = new JTextField();
		sfromat.setBounds(934, 204, 116, 22);
		ApplicationFrameMenuL2.getContentPane().add(sfromat);
		sfromat.setColumns(10);
		JPanel panel10 = new JPanel();
		panel10.setBounds(0, 583, 1360, 92);
		ApplicationFrameMenuL2.getContentPane().add(panel10);
		panel10.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel10.setBackground(Color.WHITE);
		panel10.setLayout(null);

		btnArticle = new JButton("Create Item");
		btnArticle.setBounds(278, 1, 103, 36);
		btnArticle.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnArticle.setMnemonic('I');
		btnArticle.setForeground(new Color(0, 0, 51));
		btnArticle.setBackground(Color.CYAN);
		panel10.add(btnArticle);

		btnSupplier = new JButton("Supplier/Customer");
		btnSupplier.setBounds(110, 1, 165, 36);
		btnSupplier.setMnemonic('U');
		btnSupplier.setBackground(Color.CYAN);
		btnSupplier.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSupplier.setForeground(new Color(0, 0, 51));
		panel10.add(btnSupplier);

		btnPur = new JButton("Purchase");
		btnPur.setBounds(378, 1, 103, 36);
		btnPur.setBackground(Color.CYAN);
		btnPur.setForeground(new Color(0, 0, 51));
		btnPur.setMnemonic('P');
		panel10.add(btnPur);
		btnPur.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnSale = new JButton("Sales");
		btnSale.setBounds(482, 1, 101, 36);
		btnSale.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSale.setForeground(new Color(0, 0, 51));
		btnSale.setMnemonic('S');
		panel10.add(btnSale);

		btnreceiptvou = new JButton("Receipts");
		btnreceiptvou.setVisible(false);
		btnreceiptvou.setBounds(805, 0, 103, 36);
		btnreceiptvou.setMnemonic('R');
		btnreceiptvou.setBackground(Color.CYAN);
		btnreceiptvou.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnreceiptvou.setForeground(new Color(0, 0, 51));
		panel10.add(btnreceiptvou);

		btnpaymentvoucher = new JButton("Payments");
		btnpaymentvoucher.setVisible(false);
		btnpaymentvoucher.setBounds(907, 0, 103, 37);
		btnpaymentvoucher.setMnemonic('Y');
		btnpaymentvoucher.setBackground(Color.CYAN);
		btnpaymentvoucher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnpaymentvoucher.setForeground(new Color(0, 0, 51));
		panel10.add(btnpaymentvoucher);

		btnContra = new JButton("Contra");
		btnContra.setVisible(false);
		btnContra.setBounds(1010, 0, 91, 36);
		btnContra.setMnemonic('C');
		btnContra.setBackground(Color.CYAN);
		btnContra.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnContra.setForeground(new Color(0, 0, 51));
		panel10.add(btnContra);

		btndayend = new JButton("Close Day");
		btndayend.setBounds(706, 0, 97, 36);
		btndayend.setBackground(Color.CYAN);
		btndayend.setForeground(new Color(0, 0, 51));
		btndayend.setMnemonic('D');
		panel10.add(btndayend);
		btndayend.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnPriceupdate = new JButton("Price Change");
		btnPriceupdate.setBounds(583, 0, 121, 36);
		btnPriceupdate.setMnemonic('E');
		btnPriceupdate.setBackground(Color.CYAN);
		btnPriceupdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPriceupdate.setForeground(new Color(0, 0, 51));
		panel10.add(btnPriceupdate);

		btnDaybegin = new JButton("Open Day") {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};

		btnDaybegin.setBounds(12, 1, 100, 36);
		panel10.add(btnDaybegin);
		btnDaybegin.setMnemonic('O');
		btnDaybegin.setForeground(Color.BLACK);
		btnDaybegin.setBackground(new Color(102, 102, 153));
		btnDaybegin.setFont(new Font("Tahoma", Font.BOLD, 12));

		shortcutpanel = new JPanel();
		shortcutpanel.setBounds(12, 36, 1336, 19);
		panel10.add(shortcutpanel);
		shortcutpanel.setForeground(new Color(0, 0, 102));
		shortcutpanel.setBackground(Color.WHITE);
		shortcutpanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 51)));
		shortcutpanel.setLayout(null);

		lblf2 = new JLabel("F2- Open Day");
		lblf2.setBounds(12, 0, 129, 16);
		shortcutpanel.add(lblf2);
		lblf2.setForeground(new Color(0, 51, 0));
		lblf2.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblNewLabel_3 = new JLabel("F3- Supplier");
		lblNewLabel_3.setBounds(107, 0, 118, 16);
		shortcutpanel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblf4 = new JLabel("F4- Create Item");
		lblf4.setBounds(191, 0, 158, 16);
		shortcutpanel.add(lblf4);
		lblf4.setForeground(new Color(0, 0, 102));
		lblf4.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblf7 = new JLabel("F5- WholeSale");
		lblf7.setBounds(299, 0, 107, 16);
		shortcutpanel.add(lblf7);
		lblf7.setForeground(new Color(0, 0, 102));
		lblf7.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblf3 = new JLabel("F6- Sales Return");
		lblf3.setBounds(398, 0, 129, 16);
		shortcutpanel.add(lblf3);
		lblf3.setForeground(new Color(0, 0, 102));
		lblf3.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblf9 = new JLabel("F7- Purchase");
		lblf9.setBounds(539, 0, 129, 16);
		shortcutpanel.add(lblf9);
		lblf9.setForeground(new Color(0, 0, 102));
		lblf9.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblNewLabel_5 = new JLabel("F8- Purchase Return");
		lblNewLabel_5.setBounds(661, 0, 158, 16);
		shortcutpanel.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(new Color(0, 0, 102));
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblNewLabel_4 = new JLabel("F9- Contra  ");
		lblNewLabel_4.setBounds(806, 0, 118, 16);
		//shortcutpanel.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblNewLabel_1 = new JLabel("F10-Payment ");
		lblNewLabel_1.setBounds(936, 0, 129, 16);
		//shortcutpanel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));

		JLabel lblNewLabel_2 = new JLabel("F11-Receipt  ");
		lblNewLabel_2.setBounds(1092, 0, 129, 16);
		//shortcutpanel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));

		lblf12 = new JLabel("F12- Close Day");
		lblf12.setBounds(1233, 0, 107, 16);
		shortcutpanel.add(lblf12);
		lblf12.setForeground(new Color(51, 51, 102));
		lblf12.setFont(new Font("Arial", Font.BOLD, 12));

		// btnMessage = new JButton("Contact For Product Demo");
		btnMessage = new gnRoundButton("Contact For Product Demo");
		btnMessage.setHorizontalAlignment(SwingConstants.LEFT);
		btnMessage.setBounds(120, 60, 1228, 27);
		panel10.add(btnMessage);
		btnMessage.setBackground(Color.WHITE);
		btnMessage.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnMessage.setForeground(new Color(0, 0, 51));

		// BtnLupdate = new JButton("MERETOO");
		BtnLupdate = new gnRoundButton("MERETOO");
		BtnLupdate.setBounds(12, 60, 111, 27);
		panel10.add(BtnLupdate);

		BtnLupdate.setBackground(new Color(102, 51, 102));
		BtnLupdate.setIcon(null);
		BtnLupdate.setForeground(new Color(0, 51, 0));
		// BtnLupdate.setBackground(new Color(0, 51, 102));
		BtnLupdate.setFont(new Font("Arial", Font.BOLD, 13));

		BtnLupdate.addActionListener(ls1);

		btn1002 = new JButton(" ");
		btn1002.setBounds(-2, 227, 443, 353);
		btn1002.setBackground(new Color(51, 255, 204));
		btn1002.setSelectedIcon(null);
		btn1002.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/tmp3.png")));
		ApplicationFrameMenuL2.getContentPane().add(btn1002);

		btn1003 = new JButton("");
		btn1003.setBounds(439, 227, 463, 353);
		btn1003.setSelectedIcon(null);
		btn1003.setBackground(new Color(51, 255, 204));
		btn1003.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/tmp7.png")));
		ApplicationFrameMenuL2.getContentPane().add(btn1003);

		btn1004 = new JButton(" ");
		btn1004.setBounds(897, 227, 463, 353);
		btn1004.setBackground(new Color(0, 255, 204));
		btn1004.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/tmp9.png")));
		ApplicationFrameMenuL2.getContentPane().add(btn1004);

		toolBar = new JToolBar();
		toolBar.setForeground(Color.WHITE);
		toolBar.setBounds(0, 27, 1360, 25);
		toolBar.setFloatable(false);
		toolBar.setBackground(new Color(153, 102, 153));
		btndayend.addActionListener(btn);
		btnPriceupdate.addActionListener(btn);
		btnContra.addActionListener(btn);
		btnpaymentvoucher.addActionListener(btn);
		btnreceiptvou.addActionListener(btn);
		btnSale.addActionListener(btn);
		btnPur.addActionListener(btn);
		btnSupplier.addActionListener(btn);
		btnArticle.addActionListener(btn);
		btnDaybegin.addActionListener(btn);

		FocusListener fls = new btnfocus();
		btnDaybegin.addFocusListener(fls);
		btndayend.addFocusListener(fls);
		btnPur.addFocusListener(fls);
		btnSale.addFocusListener(fls);
		btnArticle.addFocusListener(fls);
		btnSupplier.addFocusListener(fls);
		btnreceiptvou.addFocusListener(fls);
		btnpaymentvoucher.addFocusListener(fls);
		btnContra.addFocusListener(fls);
		btnPriceupdate.addFocusListener(fls);

		KeyListener kk = new keyPressedlsnr();
		btnDaybegin.addKeyListener(kk);
		btndayend.addKeyListener(kk);
		btnPur.addKeyListener(kk);
		btnSale.addKeyListener(kk);
		btnArticle.addKeyListener(kk);
		btnSupplier.addKeyListener(kk);
		btnreceiptvou.addKeyListener(kk);
		btnpaymentvoucher.addKeyListener(kk);
		btnContra.addKeyListener(kk);
		btnPriceupdate.addKeyListener(kk);

		MouseListener kk1 = new mouseLsnr();

		btnDaybegin.addMouseListener(kk1);
		btndayend.addMouseListener(kk1);
		btnPur.addMouseListener(kk1);
		btnSale.addMouseListener(kk1);
		btnArticle.addMouseListener(kk1);
		btnSupplier.addMouseListener(kk1);
		btnreceiptvou.addMouseListener(kk1);
		btnpaymentvoucher.addMouseListener(kk1);
		btnContra.addMouseListener(kk1);
		btnPriceupdate.addMouseListener(kk1);
		activeToolBar();
		setStyleofmybuttons();
		decorate();
	}

	private void setStyleofmybuttons() {
		// In Single command Though automation
		int typeno = 1;
		new gnDecorate().SetSeqHdrButton(btnPriceupdate, typeno);
		new gnDecorate().SetSeqHdrButton(btnContra, typeno);
		new gnDecorate().SetSeqHdrButton(btnreceiptvou, typeno);
		new gnDecorate().SetSeqHdrButton(btnpaymentvoucher, typeno);
		new gnDecorate().SetSeqHdrButton(btnSupplier, typeno);
		new gnDecorate().SetSeqHdrButton(btnArticle, typeno);
		new gnDecorate().SetSeqHdrButton(btnSale, typeno);
		new gnDecorate().SetSeqHdrButton(btnPur, typeno);
		new gnDecorate().SetSeqHdrButton(btndayend, typeno);
		new gnDecorate().SetSeqHdrButton(btnDaybegin, typeno);

		new gnDecorate().SetSeqHdrButton(TSalesReturn, typeno);
		new gnDecorate().SetSeqHdrButton(TPurchaseReturn, typeno);
		new gnDecorate().SetSeqHdrButton(TExpense, typeno);
		new gnDecorate().SetSeqHdrButton(TIncome, typeno);
		new gnDecorate().SetSeqHdrButton(TViewLedger, typeno);
		new gnDecorate().SetSeqHdrButton(TGSTData, typeno);
		new gnDecorate().SetSeqHdrButton(TCreditSales, typeno);
		new gnDecorate().SetSeqHdrButton(TDayBook, typeno);
		new gnDecorate().SetSeqHdrButton(TPurView, typeno);
		new gnDecorate().SetSeqHdrButton(TStockView, typeno);
		new gnDecorate().SetSeqHdrButton(TSalesView, typeno);
		new gnDecorate().SetSeqHdrButton(TScanItem, typeno);

		JLabel lblNewLabel = new JLabel("Complete Retail Business Solution");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lblNewLabel.setBounds(23, 678, 1317, 29);
		ApplicationFrameMenuL2.getContentPane().add(lblNewLabel);

	}

	private void setButtonStyle() {

		btnDaybegin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btndayend.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPur.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSale.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnArticle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSupplier.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnreceiptvou.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnpaymentvoucher.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnContra.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPriceupdate.setCursor(new Cursor(Cursor.HAND_CURSOR));

		String btnStyle = new gnPublicVariable().appBtnStyle();
		switch (btnStyle) {
		case "1":
			btn1004.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/tmp9.png")));
			btn1003.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/tmp7.png")));
			btn1002.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/tmp3.png")));
			break;

		case "2":
			btndayend.setSelectedIcon(
					new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnCloseDay1.png")));
			btndayend.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnCloseDay2.png")));
			btnDaybegin.setSelectedIcon(
					new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnDaybegin1.png")));
			btnDaybegin.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnDaybegin.png")));
			btnSupplier.setSelectedIcon(
					new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnSupplier1.png")));
			btnSupplier.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnSupplier2.png")));
			btnArticle.setSelectedIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnItem1.png")));
			btnArticle.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnItem2.png")));
			btnPur.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnPurchase2.png")));
			btnPur.setSelectedIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnPurchase.png")));
			btnSale.setSelectedIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnsale1.png")));
			btnSale.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnSale2.png")));
			btnreceiptvou.setSelectedIcon(
					new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnRecceipts1.png")));
			btnreceiptvou.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnRecceipts2.png")));
			btnpaymentvoucher.setSelectedIcon(
					new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnPayment1.png")));
			btnpaymentvoucher
					.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnPayment2.png")));
			btnContra
					.setSelectedIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btncontra1.png")));
			btnContra.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btncontra2.png")));
			btnPriceupdate.setSelectedIcon(
					new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnPricechange1.png")));
			btnPriceupdate
					.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/btnPricechange2.png")));
			break;

		case "3":

			break;
		}

	}

	public void decorate() throws Throwable {

		// activeToolBar() ;

		URD();
		
 		switch(EnableAccountingModule)
		{
		    case "Y":
 			btnreceiptvou.setVisible(true);
			btnpaymentvoucher.setVisible(true);
			btnContra.setVisible(true);
			
		 
		}
		
		setButtonStyle();
  		vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		vverticlename = new getConfigurationSetting().getVerticleName(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		new gnPublicVariable().verticlecode = vverticlecode;
		new gnPublicVariable().verticlename = vverticlename;

		// Comf no 18 used to draw image here
		String applImageName = new gnPublicVariable().AppImage;
		btnImage.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/demologo12.jpg")));
		mnExit.addActionListener(e1 -> {
			try {
				ApplicationFrameMenuL2.dispose();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		});

		sfromat.setText(gnPublicVariable.format);
		sfromat.setVisible(false);
		new gnApplicationSetting().setAppDesign(ApplicationFrameMenuL2, gnPublicVariable.compcode,
				gnPublicVariable.storecode, btnMessage, btnImage);
		String vcheckDeclarationAllow = new gnPublicVariable().checkDeclarationAllow();
		if (vcheckDeclarationAllow == "N") {
			mntmdeccash.setVisible(false);
		}
		String menuadmin = gnPublicVariable.menuAdmin;
		mntmBankdetail.setVisible(false);
		if (menuadmin == "N") {
			MenuAdmin.setVisible(false);
		}

		String LAF = "Nimbus";
		// new gnPublicVariable();
		String vthemeType = gnPublicVariable.ThemeName;
		switch (vthemeType) {
		case "Theme1":
			new gnApp().setLAF(ApplicationFrameMenuL2, LAF);
			break;
		default:
			new gnApp().setLAF(ApplicationFrameMenuL2, LAF);
			break;
		}

		String vproduction = "Y";
		String sql = "Call Prod_checkProdUnit(" + gnPublicVariable.compcode + " , " + gnPublicVariable.vstore + ")";
		getResultSet rr = new getResultSet();
		try {
			rs = rr.getSPResult(sql);
			rs.next();
			vproduction = rs.getString(1);
			vproduction = "N";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		switch (vproduction) {
		case "Y":
			mnproduction.setVisible(false);
			break;
		case "N":
			// mnproduction.setVisible(false);
			break;
		}
		if (this.compcode.equals(this.vdemocomp) && this.ucode.equals(this.vdemouser)) {
			blockForDemo();
		}
		setVerticleType();
		setFormatType();
		setBranchType();
		setStoreModelType();
		setconditional();
		setOnlyForAdmin();
		setcompoanySetting();
		setbottomMessage();
	}

	public static void setbottomMessage() {
		btnMessage.setText("Contact For Product Demo");
		String vmeaagaseText = "Contact For Product Demo   ";
		vmeaagaseText = " " + vmeaagaseText + "      |   ".concat(vverticlename)
				.concat("    | Financial Year-" + ": " + new gnPublicVariable().currentFinYear);
		vmeaagaseText = " " + vmeaagaseText
				+ "        |".concat("   Day Begin Date Is : " + new gnPublicVariable().daybegindate);
		vmeaagaseText = " " + vmeaagaseText
				+ "        |".concat("  Product Key Valid Upto" + " :: " + new gnPublicVariable().expdate);
		vmeaagaseText = " " + vmeaagaseText
				+ " |".concat("ApplicationDrive:" + " :: " + new gnPublicVariable().ApplicationDrivename + "\\AKN");

		btnMessage.setText(vmeaagaseText);
		btnMessage.setEnabled(false);

	}

	private void URD() {

	    btnreceiptvou.setVisible(false);
		btnpaymentvoucher.setVisible(false);
		btnContra.setVisible(false);

		PO.setVisible(false);
		mnGr.setVisible(false);
 		Article.setVisible(false);
		PharmaMaster.setVisible(false);
  		helpmodule.setVisible(false);
		dynamicMbq.setVisible(false);
		purchaseInfoRecord.setVisible(false);
		shelftalker.setVisible(false);
 		GRNWITHBOX.setVisible(false);
		menuSalereturn.setVisible(false);
		menuPurchasereturn.setVisible(false);
 		menuSalesOrder.setVisible(false);
		mnSales.setVisible(false);
		mnSOview.setVisible(false);
 		payrecpt.setVisible(false);
		menuAccounting.setVisible(false);
		menuTools.setVisible(false);
		mnProduction.setVisible(false);
		WMS.setVisible(false);
 		menuPriceupdate.setVisible(false);
		mnTemplate.setVisible(false);
		menuSalesOrder.setVisible(false);
		mnCustomHierarchy.setVisible(false);
		  menuTools.setVisible(false);
		  WMS.setVisible(false);
		  //gstMenu.setVisible(false);
		  Poromotion.setVisible(false);
		  //itemUpload.setVisible(false);
		  schemaManagement.setVisible(false);
		  Poromotion.setVisible(false);

		mnStkadj.setVisible(false);
		homeDelivery.setVisible(false);
		RecordDataOnlyforBeershop.setVisible(false);
		quotationManagement.setVisible(false);
		priceList.setVisible(false);
		mntmCreateUser.setVisible(true);
		mnVAT.setVisible(false);
		ApplyChanges.setVisible(false);
		DBManagement.setVisible(false);
		onRentModule.setVisible(false);
		Fertilizer.setVisible(false);
		farmerview.setVisible(false);
		SupplierSchedule.setVisible(false);
		dynamicMbq.setVisible(false);
		purchaseInfoRecord.setVisible(false);
		mnfulush.setVisible(false);
		simplePOS.setVisible(false);
		BtnLupdate.setEnabled(false);
		mnStoreOperation.setVisible(false);
		mnTransactions.setVisible(true);
		mnreport.setVisible(false);
		DBManagement.setVisible(false);
		dbparam.setVisible(false);
		mnSupplier.setVisible(false);
		mnCustomer.setVisible(false);
		mnAttributes.setVisible(false);
		stockTransfer.setVisible(false);
		DBManagement.setVisible(false);
		onRentModule.setVisible(false);
		simplePOS.setVisible(false);
		BtnLupdate.setEnabled(false);
		mnVAT.setVisible(false);
		Poromotion.setVisible(false);

		
		TScanItem.setVisible(false);
 		onRentModule.setVisible(false);
		simplePOS.setVisible(false);
		BtnLupdate.setEnabled(false);
		schemaManagement.setVisible(false);
 
	}

	private void setOnlyForAdmin() {
		String vuser = new General().getUsercode();
		switch (vuser) {
		case "ADMIN":
			mnVAT.setVisible(false);
			menuSalesOrder.setVisible(true);
			simplePOS.setVisible(true);
			onRentModule.setVisible(true);
			btnreceiptvou.setVisible(true);
			btnpaymentvoucher.setVisible(true);
			schemaManagement.setVisible(true);
			btnContra.setVisible(true);
			TExpense.setVisible(true);
			TIncome.setVisible(true);
			ApplyChanges.setVisible(true);
			TViewLedger.setVisible(true);
			mnUserManagement.setVisible(true);
			helpmodule.setVisible(true);
			menuVoucher.setVisible(true);
			BtnLupdate.setEnabled(true);
			WMS.setVisible(true);
			// menuTools.setVisible(true);
			mnfulush.setVisible(true);
			onRentModule.setVisible(true);
			DBManagement.setVisible(true);
			mnStkadj.setVisible(true);
			stockTransfer.setVisible(false);
			purchaseInfoRecord.setVisible(true);
			dynamicMbq.setVisible(true);
			//Poromotion.setVisible(true);
			othMaster.setVisible(true);
			mnProductConfiguration.setVisible(true);
			mnSales.setVisible(true);
			gstMenu.setVisible(true);
			itemUpload.setVisible(true);
			mntmManufactror.setVisible(true);
			mnStoreOperation.setVisible(true);
			mnreport.setVisible(true);
			mnCustomHierarchy.setVisible(true);
			mnGST.setVisible(true);
			schemaManagement.setVisible(true);
			break;
		}
	}

	private void setcompoanySetting() {
		// new General().msg(compcode);
		switch (compcode) {
		case "9999":
			mnfulush.setVisible(true);
		}
	}

	private void setconditional() {
		if (promoModuleActivated == "N") {
			Poromotion.setVisible(false);
		}
	}

	private void setFormatType() throws ClassNotFoundException, SQLException {
		String vformat = new getConfigurationSetting().getFormatCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		switch (vformat) {
		case "1":
			stockTransfer.setVisible(false);
			break;
		case "3":
			stockTransfer.setVisible(false);
			break;
		}
	}

	private void setBranchType() throws ClassNotFoundException, SQLException {
		String vbranchType = "";
		vbranchType = new getConfigurationSetting().getBranchTypeCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		switch (vbranchType) {
		case "1":
			SupplierSchedule.setVisible(false);
			dynamicMbq.setVisible(false);
			purchaseInfoRecord.setVisible(false);
			schemaManagement.setVisible(true);
			break;
		case "2":
			SupplierSchedule.setVisible(false);
			dynamicMbq.setVisible(false);
			purchaseInfoRecord.setVisible(false);
			break;
		case "3":
			SupplierSchedule.setVisible(true);
			dynamicMbq.setVisible(true);
			purchaseInfoRecord.setVisible(true);
			stockTransfer.setVisible(true);
			break;
		case "0":
			new General().msg("Branch Type is not set , Please Set Proper Branch Type");
			System.exit(0);
			break;
		}
	}

	private void setVerticleType() {
		String vverticlecode = "";
		String vverticlename = "";
		String vCompanyverticlecode = "";
		try {
			vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
					new gnPublicVariable().vstore);
			vverticlename = new getConfigurationSetting().getVerticleName(new gnPublicVariable().vcomp,
					new gnPublicVariable().vstore);
			vCompanyverticlecode = new getConfigurationSetting().getCompanyVerticleCode(new gnPublicVariable().vcomp,
					new gnPublicVariable().vstore);
			if (!vverticlecode.equals(vCompanyverticlecode)) {
				// new General().msg("Company Verticle and Store Verticle Is Not
				// Same Please Check...");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		switch (vverticlecode) {
		case "5":
		
			URD();
  			Fertilizer.setVisible(true);
			farmerview.setVisible(true);
			stockTransfer.setVisible(false);
			break;

		case "2":
			URD();
 			PharmaMaster.setVisible(true);
			break;

		case "3":
			URD();
			menuPriceupdate.setVisible(true);
			TScanItem.setVisible(true);
			break;

		case "1":
			URD();
			mnGr.setVisible(true);
			PO.setVisible(true);
			menuPriceupdate.setVisible(true);
			TScanItem.setVisible(true);
			break;
 		}
 	}

	private void setStoreModelType() throws Throwable {
		String vpara = "35";
		String vstoremodel = new getConfigurationSetting().getSpecificConfiguration(vpara);
		switch (vstoremodel) {
		case "F":
			// menuAccounting.setVisible(false);
			break;
		}
	}

	private void blockForDemo() {
		// WMS.setVisible(false);
		menuTools.setVisible(false);
		mnfulush.setVisible(false);
		toolBar.setVisible(false);
		shortcutpanel.setVisible(false);
		// MenuAdmin.setVisible(false);
		mnStoreOperation.setVisible(false);
		mnTransactions.setVisible(false);
		menugst4.setVisible(false);
		menugstr1.setVisible(false);
		menugstr2.setVisible(false);
		GST3B.setVisible(false);
		// helpmodule.setVisible(false);
		mnreport.setVisible(false);
	}

	class keyPressedlsnr implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int value = e.getKeyCode();
			// new General().msg("Key Pressed "+ value);
			switch (value) {
			case 10:
				if (btnDaybegin.isFocusOwner()) {
					btnDaybegin.doClick();
				}

				if (btndayend.isFocusOwner()) {
					btndayend.doClick();
					btndayend.setBackground(Color.BLACK);
				}

				if (btnPur.isFocusOwner()) {
					btnPur.doClick();
				}

				if (btnSale.isFocusOwner()) {
					btnSale.doClick();
				}

				if (btnArticle.isFocusOwner()) {
					btnArticle.doClick();
				}

				if (btnSupplier.isFocusOwner()) {
					btnSupplier.doClick();
				}

				if (btnreceiptvou.isFocusOwner()) {
					btnreceiptvou.doClick();
				}

				if (btnpaymentvoucher.isFocusOwner()) {
					btnpaymentvoucher.doClick();
				}

				if (btnContra.isFocusOwner()) {
					btnContra.doClick();
				}

				if (btnPriceupdate.isFocusOwner()) {
					btnPriceupdate.doClick();
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

			if (btnDaybegin.isFocusOwner()) {
				btnDaybegin.setBackground(Color.yellow);
				btnDaybegin.setForeground(Color.BLACK);
				new gnFontSetting().setMyFontBold(btnDaybegin, "F1", 14);
			}

			if (btnSupplier.isFocusOwner()) {
				btnSupplier.setBackground(Color.yellow);
				btnSupplier.setForeground(Color.BLACK);
				new gnFontSetting().setMyFontBold(btnDaybegin, "F1", 10);
			}

			if (btndayend.isFocusOwner()) {
				btndayend.setBackground(Color.yellow);
				btndayend.setForeground(Color.BLACK);
			}

			if (btnPur.isFocusOwner()) {
				btnPur.setBackground(Color.yellow);
				btnPur.setForeground(Color.BLACK);
			}

			if (btnSale.isFocusOwner()) {
				btnSale.setBackground(Color.yellow);
				btnSale.setForeground(Color.BLACK);
			}

			if (btnArticle.isFocusOwner()) {
				btnArticle.setBackground(Color.yellow);
				btnArticle.setForeground(Color.BLACK);
			}

			if (btnreceiptvou.isFocusOwner()) {
				btnreceiptvou.setBackground(Color.yellow);
				btnreceiptvou.setForeground(Color.BLACK);

			}

			if (btnpaymentvoucher.isFocusOwner()) {
				btnpaymentvoucher.setBackground(Color.yellow);
				btnpaymentvoucher.setForeground(Color.BLACK);
			}

			if (btnContra.isFocusOwner()) {
				btnContra.setBackground(Color.yellow);
				btnContra.setForeground(Color.BLACK);
			}

			if (btnPriceupdate.isFocusOwner()) {
				btnPriceupdate.setBackground(Color.yellow);
				btnPriceupdate.setForeground(Color.BLACK);
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			setStyleofmybuttons();
			setButtonStyle();
		}
	}

	class mouseLsnr implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {

			if (btnDaybegin.isFocusOwner()) {
				btnDaybegin.setBackground(Color.yellow);
			}

		}

		@Override
		public void mouseExited(MouseEvent arg0) {

			new gnFontSetting().setMyFontBold(btnDaybegin, "F1", 9);
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {

		}

	}

	class menulsnr implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			value = e1.getActionCommand();
			MenuPress = value;
			try {
				callForm(value);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void activeToolBar() {

		TCreditSales = new JButton("Credit Sales");
		TCreditSales.setHorizontalAlignment(SwingConstants.LEFT);
		TCreditSales.setForeground(new Color(100, 20, 102));
		TCreditSales.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		// TCreditSales.setIcon(new
		// ImageIcon(ApplicationMenu.class.getResource("/RetailProduct/mymainIcon3.ico")));
		TCreditSales.setToolTipText("Book Credit Sales-WholeSale ");

		TSalesReturn = new JButton("Sales Return");
		TSalesReturn.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		TSalesReturn.setToolTipText("Sales Return ");

		TPurchaseReturn = new JButton("Pur.Return");
		TPurchaseReturn.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		TPurchaseReturn.setToolTipText("Purchase Return");

		TExpense = new JButton("Expense");
		TExpense.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		TExpense.setToolTipText("Expense Voucher");

		TIncome = new JButton("Income");
		TIncome.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		TIncome.setToolTipText("Income Voucher");

		TViewLedger = new JButton("View Ledger");
		TViewLedger.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		TViewLedger.setToolTipText("View Ledger Balance");

		TGSTData = new JButton("GST Data");
		TGSTData.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		TGSTData.setToolTipText("View GST Data");

		TSalesView = new JButton("Sales View");
		TSalesView.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		TSalesView.setToolTipText("View Sales Data");

		TPurView = new JButton("Purchase View");
		TPurView.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		TPurView.setToolTipText("View  Purchase Data");

		TStockView = new JButton("Stock View");
		TStockView.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		TStockView.setToolTipText("View  Stock Data");

		TScanItem = new JButton("Scan Items");
		TScanItem.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		TScanItem.setToolTipText("Scan Items and Book Sales Later ");

		TDayBook = new JButton("Day Book");
		TDayBook.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		TDayBook.setToolTipText("View Dailly Transactions ");

		toolBar.add(TCreditSales);
		toolBar.add(TPurchaseReturn);
		toolBar.add(TSalesReturn);
		toolBar.add(TDayBook);
		toolBar.add(TGSTData);
		toolBar.add(TSalesView);
		toolBar.add(TPurView);
		toolBar.add(TStockView);
		//toolBar.add(TExpense);
		//toolBar.add(TIncome);
		//toolBar.add(TViewLedger);
		//toolBar.add(TScanItem);

		ApplicationFrameMenuL2.getContentPane().add(toolBar);

		ActionListener TBtnLsitener = new TbtnLsnr();
		TSalesReturn.addActionListener(TBtnLsitener);
		TPurchaseReturn.addActionListener(TBtnLsitener);
		//TExpense.addActionListener(TBtnLsitener);
		//TIncome.addActionListener(TBtnLsitener);
		TViewLedger.addActionListener(TBtnLsitener);
		TGSTData.addActionListener(TBtnLsitener);
		TCreditSales.addActionListener(TBtnLsitener);
		TSalesView.addActionListener(TBtnLsitener);
		TPurView.addActionListener(TBtnLsitener);
		TStockView.addActionListener(TBtnLsitener);
		TScanItem.addActionListener(TBtnLsitener);
		TDayBook.addActionListener(TBtnLsitener);

	}

	class btnLsnt implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Sales") {
				try {

					switch (vverticlecode) {

					case "1":
						POS window = new POS();
						window.POSFrame.setVisible(true);
						break;

					case "5":
						window = new POS();
						window.POSFrame.setVisible(true);
						break;

					case "11": // automobile
						//POS11_1 window11;
						//window11 = new POS11_1();
						//window11.POSFrame11_1.setVisible(true);
						//break;

					case "3":
 						POS3_2 window3;
						window3 = new POS3_2();
						window3.POSFrame3_2.setVisible(true);
						break;

					case "15":

						POS15_1 window15;
						window15 = new POS15_1();
						window15.POSFrame15_1.setVisible(true);
						break;

					}

				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Price Change") {
				try {
					updatePrice window = new updatePrice();
					window.updatePriceFrame.setVisible(true);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Open Day") {

				try {

					DayBegin window;
					window = new DayBegin();
					window.DayBeginFrame.setVisible(true);

				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Payments") {

				try {
					paymentVoucher window;
					window = new paymentVoucher();
					window.frmpaymentvoucher.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Close Day") {
				try {
					dayEnd window = new dayEnd();
					window.frameDayEnd.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Contra") {
				try {
					bankTransactions window;
					window = new bankTransactions();
					window.frmBusinessApplication.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Receipts") {
				try {
					receiptVoucher window;
					window = new receiptVoucher();
					window.frmreceiptVoucher.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Supplier/Customer") {
				try {
					CustomerMaster window;
					window = new CustomerMaster();
					window.CustomerFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Create Item") {
				try {
					// Article_Master window = new Article_Master();
					// window.ArticleMasterFrame.setVisible(true);

					ArticleBase_Master window11 = new ArticleBase_Master();
					window11.articlebasemasterFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Purchase") {
				try {

					switch (vverticlecode) {
					
				  case "1":
						
						GRNModule window = new GRNModule();
						window.GRNModuleFrame.setVisible(true);
						break;

					case "2":
						
						GRNModule window2 = new GRNModule();
						window2.GRNModuleFrame.setVisible(true);
						break;

					case "3":

						 GRNModule window24 = new GRNModule();
						 window24.GRNModuleFrame.setVisible(true);
						 break ;

						// new General().msg("Opening GRn Module");
						// GRNModule11_1 window11 = new GRNModule11_1();
						// window11.GRNModuleFrame11_1.setVisible(true);

					case "4":

						GRNModule window4 = new GRNModule();
						window4.GRNModuleFrame.setVisible(true);
						break;

					case "5":

						GRNModule window5 = new GRNModule();
						window5.GRNModuleFrame.setVisible(true);
						break;

					case "6":
						GRNModule window6 = new GRNModule();
						window6.GRNModuleFrame.setVisible(true);
						break;

					case "7":
						GRNModule window7 = new GRNModule();
						window7.GRNModuleFrame.setVisible(true);
						break;

					case "8":
						GRNModule window8 = new GRNModule();
						window8.GRNModuleFrame.setVisible(true);
						break;

					case "9":
						GRNModule window9 = new GRNModule();
						window9.GRNModuleFrame.setVisible(true);
						break;

					case "10":
						GRNModule window10 = new GRNModule();
						window10.GRNModuleFrame.setVisible(true);
						break;

 
					case "12":
						GRNModule window12 = new GRNModule();
						window12.GRNModuleFrame.setVisible(true);
						break;

					case "13":
						GRNModule window13 = new GRNModule();
						window13.GRNModuleFrame.setVisible(true);
						break;

					case "14":
						GRNModule window14 = new GRNModule();
						window14.GRNModuleFrame.setVisible(true);
						break;

					case "15":
						GRNModule window15 = new GRNModule();
						window15.GRNModuleFrame.setVisible(true);
						break;

					case "16":
						GRNModule window16 = new GRNModule();
						window16.GRNModuleFrame.setVisible(true);
						break;
					}

				} catch (Exception e1) {
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class TbtnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			
			if (value == "Credit Sales") {
				creditSalesPOS window;
				try {
 					switch (vverticlecode) {
 					case "1":
						MenuSelection = "wsales";
						window = new creditSalesPOS();
						window.creditsalesFrame.setVisible(true);
						break;
 					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			if (value == "Day Book") {
 				dayBook window;
				try {
					window = new dayBook();
					window.dayBookFrame.setVisible(true);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			if (value == "Scan Items") {
				try {
					BeerShoppe_scanRecords window;
					window = new BeerShoppe_scanRecords();
					window.beearscanFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "GST Data") {
				try {
					GST_Reports window;
					window = new GST_Reports();
					window.GSTReportFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Pur.Return") {
				purchaseReturn window;
				try {
					window = new purchaseReturn();
					window.frmpurchaseReturn.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}

			}

			if (value == "Sales Return") {
				Sales_Return window;
				try {
					window = new Sales_Return();
					window.frameSalesReturn.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Expense") {
				ExpenseVoucher window;
				try {
					window = new ExpenseVoucher();
					window.frmExpenses.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Income") {
				IncomeVoucher window;
				try {
					window = new IncomeVoucher();
					window.frmIncome.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Sales View") {
				Daily_Sales_View window;
				try {
					window = new Daily_Sales_View();
					window.SalesViewFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Purchase View") {
				Daily_Purchase_View window;
				try {
					window = new Daily_Purchase_View();
					window.PurchaseViewFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Stock View") {
				CheckInventory window;
				try {
					window = new CheckInventory();
					window.frameInventoryApplication.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "View Ledger") {
				account_ViewLedger window;
				try {
					window = new account_ViewLedger();
					window.ledgerViewFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

		}
	}

	private void checkcompanyCreated() throws Throwable {
		String status = " ";
		status = new gnConfig().companycreated();
		switch (status) {
		case "N":
			Company_Master window = new Company_Master();
			window.CompanyFrame.setVisible(true);
			window.CompanyFrame.setAlwaysOnTop(true);
			break;
		}
	}

	public String getClickedMenu() {
		return MenuSelection;
	}

	// ====check config Table is Empty or not
	public String testConfig() throws Throwable {
		String process = "N";
		String Action = new gnConfig().checkConfigTable();
		if (Action == "Configuration Test Secussfull ") { // new
															// General().msg(Action);
			process = "Y";
		}
		if (Action != "Configuration Test Secussfull ") {
			new General().msg(Action);
			process = "N";
		}
		return process;
	}

	public void callForm(String value) throws Throwable {

		if (value == "Assign Brand & Hierarchy") {
			Article_AttriHie_Assignment window = new Article_AttriHie_Assignment();
			window.ArticleAttrHieFrame.setVisible(true);
		}

		if (value == "Sales Reports") {
			Report_Sales window = new Report_Sales();
			window.SalesReportframe.setVisible(true);
		}

		if (value == "Purchase Report") {
			Reports_Purchase window = new Reports_Purchase();
			window.purchsereportframe.setVisible(true);
		}

		if (value == "Customer Sales Info") {
			viewCustomer window = new viewCustomer();
			window.CustomerviewFrame.setVisible(true);
		}

		if (value == "Supplier Info") {
			viewSupplier window = new viewSupplier();
			window.supplierviewFrame.setVisible(true);

		}

		if (value == "Cashier Declaration for POS") {
			Declaration window = new Declaration();
			window.DeclarationFrame.setVisible(true);
		}

		if (value == "Configure") {
			store_configuration window = new store_configuration();
			window.storeconfigFrame.setVisible(true);

		}

		if (value == "Exclude Promo Item List") {
			PromoExcludeItemsList window = new PromoExcludeItemsList();
			window.promoItemExcludeFrame.setVisible(true);
		}

		if (value == "Daily Purchase") {
			Daily_Purchase_View window = new Daily_Purchase_View();
			window.PurchaseViewFrame.setVisible(true);
		}

		if (value == "Daily Sales & Margin") {
			Daily_Sales_View window = new Daily_Sales_View();
			window.SalesViewFrame.setVisible(true);
		}

		if (value == "Create Supplier") {
			CustomerMaster window = new CustomerMaster();
			window.CustomerFrame.setVisible(true);
		}

		if (value == "Create Customer") {
			CustomerMaster window = new CustomerMaster();
			window.CustomerFrame.setVisible(true);
		}

		if (value == "Change Password") {
			ChangePassword window = new ChangePassword();
			window.ChangePasswordFrame.setVisible(true);

		}
		if (value == "Company Master") {
			Company_Master window = new Company_Master();
			window.CompanyFrame.setVisible(true);
		}

		if (value == "Assignments to Group") {
			GroupAssignments window = new GroupAssignments();
			window.AssignmentGroupFrame.setVisible(true);
		}
		if (value == "Create Site") {
			Site_Master window = new Site_Master();
			window.SiteFrame.setVisible(true);
		}

 
		if (value == "Sales Return") {
			Sales_Return window = new Sales_Return();
			window.frameSalesReturn.setVisible(true);
		}

		if (value == "Purchase Return") {
			purchaseReturn window = new purchaseReturn();
			window.frmpurchaseReturn.setVisible(true);
		}

		if (value == "POS") {
			POS window = new POS();
			window.POSFrame.setVisible(true);
		}

		if (value == "Create User") {
			Create_User window = new Create_User();
			window.CreateUserFrame.setVisible(true);
		}

		if (value == "Day Begin") {
			DayBegin window = new DayBegin();
			window.DayBeginFrame.setVisible(true);
		}

		if (value == "DB Parameters") {
			DBParam window = new DBParam();
			window.myFrameDB.setVisible(true);
		}

		if (value == "Day End") {
			dayEnd window = new dayEnd();
			window.frameDayEnd.setVisible(true);
		}

		if (value == "Contra Entry") {
			bankTransactions window = new bankTransactions();
			window.frmBusinessApplication.setVisible(true);
		}

		if (value == "Check Stock") {
			CheckInventory window = new CheckInventory();
			window.frameInventoryApplication.setVisible(true);
		}

		if (value == "Category") {
			hie_Level_1 window = new hie_Level_1();
			window.Hie_frame_level1.setVisible(true);
		}

		if (value == "SubCategory") {
			hie_Level_2 window = new hie_Level_2();
			window.Hie_frame_level2.setVisible(true);
		}

		if (value == "Group") {
			Hie_frame_level3 window = new Hie_frame_level3();
			window.Hie_frame_level3.setVisible(true);
		}

		if (value == "SubGroup") {
			Hie_frame_level4 window = new Hie_frame_level4();
			window.Hie_frame_level4.setVisible(true);
		}

		if (value == "Assign Hierarchy") {
			hie_Assignment window = new hie_Assignment();
			window.hie_Assignment_frame.setVisible(true);
		}

		if (value == "View Hierarchy") {
			HierarchyTree window = new HierarchyTree();
			window.HierarchyTreeFrame.setVisible(true);
		}

		if (value == "Create Hierarchy Definations") {
			hie_Description_Initiate window = new hie_Description_Initiate();
			window.hie_Description.setVisible(true);
		}

		if (value == "Number Sequences") {
			numberSeq window = new numberSeq();
			window.numseqFrame.setVisible(true);
		}

		if (value == "Manufacturar") {
			createManuf window = new createManuf();
			window.frameManuf.setVisible(true);
		}

		if (value == "Brand") {

			CreateGeneralMaster window = new CreateGeneralMaster();
			window.masterFrame.setVisible(true);
			// createBrand window = new createBrand();
			// window.frameBrand.setVisible(true);
		}

		if (value == "Full Backup") {
			BackupDB db = new BackupDB();
			db.TakeBackup(new gnPublicVariable().DbBackupPath());
		}

		if (value == "Financial Year") {
			Finyear window = new Finyear();
			window.frameFinyear.setVisible(true);
		}

		if (value == "GST Tax Category") {
			TaxCategoty window = new TaxCategoty();
			window.TaxCategory.setVisible(true);

		}

		if (value == "GST Tax Distribution") {
			GST_Tax_distribution window = new GST_Tax_distribution();
			window.gstTaxDistribution.setVisible(true);
		}

		if (value == "View GST Return File Data") {
			GST_Reports window = new GST_Reports();
			window.GSTReportFrame.setVisible(true);
		}

		if (value == "GSTR 1") {
			GST_Filling_data window = new GST_Filling_data();
			window.gst_returnFile_data.setVisible(true);
		}

		if (value == "GSTR 2") {
			GST_Filling_GSTR2 window = new GST_Filling_GSTR2();
			window.gst_GSTR2_Frame.setVisible(true);

		}

		if (value == "GSTR 4") {
			GST_Filling_GSTR4 window = new GST_Filling_GSTR4();
			window.gst_GSTR4_Frame.setVisible(true);
		}

		if (value == "Receipt Voucher") {
			receiptVoucher window = new receiptVoucher();
			window.frmreceiptVoucher.setVisible(true);
		}

		if (value == "Payment Voucher") {
			paymentVoucher window = new paymentVoucher();
			window.frmpaymentvoucher.setVisible(true);
		}

		if (value == "Supplier Ledger") {
			MenuSelection = "SL";
			supplierLedger window = new supplierLedger();
			window.frameSuplLedger.setVisible(true);
		}

		if (value == "Customer Ledger") {
			MenuSelection = "CL";
			supplierLedger window = new supplierLedger();
			window.frameSuplLedger.setVisible(true);

		}

		if (value == "Book Credit Sales") {
			MenuSelection = "wsales";
			creditSalesPOS window;
			try {
				window = new creditSalesPOS();
				window.creditsalesFrame.setVisible(true);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}

		if (value == "Update Price & Tax") {
			updatePrice window = new updatePrice();
			window.updatePriceFrame.setVisible(true);
		}

		if (value == "P&L Account") {
			account_PLNew window = new account_PLNew();
			window.plFramenew.setVisible(true);
		}

		if (value == "View Ledger Balances") {
			account_ViewLedger window = new account_ViewLedger();
			window.ledgerViewFrame.setVisible(true);
		}

		if (value == "Income Voucher") {
			IncomeVoucher window = new IncomeVoucher();
			window.frmIncome.setVisible(true);
		}

		if (value == "Expense Voucher") {
			ExpenseVoucher window = new ExpenseVoucher();
			window.frmExpenses.setVisible(true);
		}

		if (value == "Create Ledger") {
			Expences_List_master window = new Expences_List_master();
			window.expenceFrame.setVisible(true);
		}

		if (value == "City Master") {
			CityMaster window = new CityMaster();
			window.frameCity.setVisible(true);
		}

		if (value == "View Income/Expenses") {
			viewExpIncome window = new viewExpIncome();
			window.incoFrame.setVisible(true);
			MenuSelection = "IE";
		}

		if (value == "Payment/Receipt/Contra") {
			viewExpIncome window = new viewExpIncome();
			window.incoFrame.setVisible(true);
			MenuSelection = "PRC";
		}

		if (value == "Balance Sheet") {
			account_BSNew window = new account_BSNew();
			window.bsFrameNew.setVisible(true);
		}

		if (value == "Bank Details") {
			bankMaster window = new bankMaster();
			window.frmBusinessApplication.setVisible(true);
		}

		if (value == "Day Book") {
			dayBook window = new dayBook();
			window.dayBookFrame.setVisible(true);
		}

		if (value == "MERETOO") {
			UpdateInfo window = new UpdateInfo();
			window.updateLFrame.setVisible(true);
		}

		if (value == "Purchase Order") {
			ManualPO window = new ManualPO();
			window.frmPOApplication.setVisible(true);
		}

		if (value == "Generate Barcode") {
			barcodePrinting window = new barcodePrinting();
			window.barcodeframe.setVisible(true);
		}

	 

		if (value == "Add Config Parameter") {
			CreateConfiguation window = new CreateConfiguation();
			window.Configframe.setVisible(true);
		}

		if (value == "Stock RollOver") {
			StockRollOver window = new StockRollOver();
			window.stockRollFrame.setVisible(true);
		}

		if (value == "Entry Reposting Module") {
			Acc_gstReposting window = new Acc_gstReposting();
			window.RepostingFrame.setVisible(true);
		}

		if (value == "Ledger Opening Balance Entry") {
			LedgerOpBalance window = new LedgerOpBalance();
			window.legeropbalframe.setVisible(true);
		}

		if (value == "Journal Voucher") {
			acc_gernoulEntry window = new acc_gernoulEntry();
			window.journalEntryFrame.setVisible(true);
		}
		if (value == "View Ledger ") {
			MenuSelection = "OL";
			supplierLedger window = new supplierLedger();
			window.frameSuplLedger.setVisible(true);

		}

		// Last Addition from Advance Module

		if (value == "Physical Stock Entry") {
			stockVoucher window = new stockVoucher();
			window.stockVoucherFrame.setVisible(true);
		}

		if (value == "Generate Stock Variance") {

			stockVariance window = new stockVariance();
			window.stockVarianceFrame.setVisible(true);

		}

		if (value == "Stock Variance Posting") {
			SVPosting window = new SVPosting();
			window.SVPosting.setVisible(true);
		}

		if (value == "Location Stock Transfer") {
			LocationStockTransfer window = new LocationStockTransfer();
			window.locationtrfFrame.setVisible(true);
		}

		if (value == "Drug Master") {

		}

		if (value == "Doctor Master") {
			medical_DoctorMaster window = new medical_DoctorMaster();
			window.Doctorframe.setVisible(true);
		}

		if (value == "Patient Master") {
			Medical_Patient_Master window = new Medical_Patient_Master();
			window.patientFrame.setVisible(true);
		}

		if (value == "Drug Dose Management") {

			CropandDoseManagment window = new CropandDoseManagment();
			window.cropdoseframe.setVisible(true);

			// farm_DrugDoseManagement window = new farm_DrugDoseManagement();
			// window.DrugDoseframe.setVisible(true);
		}

		if (value == "View Farmer") {
			farmerView window = new farmerView();
			window.framefarmview.setVisible(true);

		}

		if (value == "General Master") {
			CreateGeneralMaster window = new CreateGeneralMaster();
			window.masterFrame.setVisible(true);
		}

		if (value == "Stock Adjusment") {
			StockAdjustmentModule window = new StockAdjustmentModule();
			window.stockAdjFrame.setVisible(true);

		}
		if (value == "Stock In") {
			StockTransferTI window = new StockTransferTI();
			window.stockTransferIN.setVisible(true);

		}

		if (value == "Print ShelfTalkers") {
			shelfTalker window = new shelfTalker();
			window.shelftlkFrame.setVisible(true);

		}
		if (value == "Stock Out") {
			StockTransaferTO window = new StockTransaferTO();
			window.TOframe.setVisible(true);

		}

		if (value == "View Data") {
			Schema_viewer window = new Schema_viewer();
			window.Schemaframe.setVisible(true);
		}

		if (value == "Help") {
			helpModule window = new helpModule();
			window.Pdfframe.setVisible(true);
		}

		if (value == "Dynamic MBQ Generation") {
			MBQ_Dynamic_Generation window = new MBQ_Dynamic_Generation();
			window.mbqframe.setVisible(true);
		}

		if (value == "Supplier-Supply Schedule") {
			Supplier_Schedule window = new Supplier_Schedule();
			window.SupScheduleFrame.setVisible(true);
		}

		if (value == "Purchase Info Record") {
			supplierPurchaseInfo window = new supplierPurchaseInfo();
			window.purchaseInfoRecord.setVisible(true);
		}

		if (value == "Book Rent Sales") {
			RentedSalesModule window = new RentedSalesModule();
			window.rensalesFrame.setVisible(true);

		}

		if (value == "SR-PR View") {
			View_PRSR window = new View_PRSR();
			window.PRSRframe.setVisible(true);

		}

		if (value == "Home Delivery Management") {
			HomeDel_Dispatch window = new HomeDel_Dispatch();
			window.homeDel_dispatchFrame.setVisible(true);

		}

		if (value == "Create Promotion") {
			MeretooPromoMaster window = new MeretooPromoMaster();
			window.meretooPomotionFrame.setVisible(true);
		}

		if (value == "Quotation") {
			AutomobileQuotation window = new AutomobileQuotation();
			window.automQuotationframe.setVisible(true);
		}

		if (value == "Flush Data") {
			FlushData window = new FlushData();
			window.flushDataFrame.setVisible(true);

		}

		if (value == "Apply Updates") {
			ApplySPandTableChanges window = new ApplySPandTableChanges();
			window.frametableSp.setVisible(true);
		}

		if (value == "GSTR 3B") {

			GST_Filling_GSTR3B window = new GST_Filling_GSTR3B();
			window.GST3BReportFrame.setVisible(true);

		}

		if (value == "Voucher Entry") {

			acc_gernoulEntry window = new acc_gernoulEntry();
			window.journalEntryFrame.setVisible(true);
		}

	 

		if (value == "Menu Price Update") {
			RestoMenuPriceList window = new RestoMenuPriceList();
			window.menuPriceListFrame.setVisible(true);

		}

		if (value == "Item Upload Utility") {

			csvUploadUtility window = new csvUploadUtility();
			window.csvUploadFrame.setVisible(true);

			// Article_upload_utility window = new Article_upload_utility();
			// window.ArtcleUploadFrame.setVisible(true);

		}

		if (value == "Single Entry Reposting") {
			Acc_gstRepostingSingle window = new Acc_gstRepostingSingle();
			window.SingleRepostingFrame.setVisible(true);
		}

		if (value == "Item Master") {
			Article_Master window = new Article_Master();
			window.ArticleMasterFrame.setVisible(true);

		}

		if (value == "Barcode Mapping") {
			BarcodeMapping window = new BarcodeMapping();
			window.frameBarcodeMapping.setVisible(true);
		}

		if (value == "Audit-GST and Accounting(Bulk Reposting") {
			MenuSelection = "RunReposting";
			Acc_gstReposting window = new Acc_gstReposting();
			window.RepostingFrame.setVisible(true);

		}

		if (value == "Audit & Reposting(Single Entry)") {
			MenuSelection = "RunReposting";
			Acc_gstRepostingSingle window = new Acc_gstRepostingSingle();
			window.SingleRepostingFrame.setVisible(true);
		}

		if (value == "Audit-Transactions") {
			Acct_transactionAudit window = new Acct_transactionAudit();
			window.transactionAuditFrame.setVisible(true);
		}

		if (value == "Audit-Inventory") {
			StockRollOver window = new StockRollOver();
			window.stockRollFrame.setVisible(true);
		}

		if (value == "Audit-Product Setup") {

		}

		if (value == "Audit-Master Data & Others") {
			DataCheckUtility window = new DataCheckUtility();
			window.frameDataCheck.setVisible(true);
		}

		if (value == "Freeze Financial Year") {
			FreezeFinYear window = new FreezeFinYear();
			window.freezefinyearFrame.setVisible(true);
		}

		if (value == "Account Posting Audit in Account Table") {
			Account_Audit_Data window = new Account_Audit_Data();
			window.AccountDataAuditFrame.setVisible(true);
		}

		if (value == "Maintain Price List") {
			wSales_priceList window = new wSales_priceList();
			window.wspricelist.setVisible(true);

		}

		if (value == "Hierarchy Description") {
			hie_Description_Initiate window = new hie_Description_Initiate();
			window.hie_Description.setVisible(true);
		}

		if (value == "Hierarchy Assignment") {
			hie_Assignment window = new hie_Assignment();
			window.hie_Assignment_frame.setVisible(true);
		}

		if (value == "Simple Retail POS") {
			POSSimpleRetail window = new POSSimpleRetail();
			window.POSSimpleFrame.setVisible(true);
		}

		if (value == "Change Financial Year") {
			selectCompany window = new selectCompany();
			window.SelectComFrame.setVisible(true);
		}

		if (value == "Creatre Quotation") {
			wsale_quotations window = new wsale_quotations();
			window.framequotation.setVisible(true);

		}

		if (value == "Scan Item For Sales") {
			BeerShoppe_scanRecords window = new BeerShoppe_scanRecords();
			window.beearscanFrame.setVisible(true);
		}

		if (value == "Tax Slab Managment") {
			TaxSlabMaster window = new TaxSlabMaster();
			window.taxSlabFrame.setVisible(true);

		}

		if (value == "View Article Data") {
			Artilce_otherInfo window = new Artilce_otherInfo();
			window.ArticleViewFrame.setVisible(true);

		}

		if (value == "Repacking - Bulk to Chld Conversion") {
			RepackingModule window = new RepackingModule();
			window.RepackingFrame.setVisible(true);

		}

		if (value == "test") {
			roundingExample window = new roundingExample();
			window.frame.setVisible(true);
			// test101 window = new test101();
			// window.framenk.setVisible(true);
		}

		if (value == "Create Template") {
			ProductionTemplate window = new ProductionTemplate();
			window.prodTemplateFrame.setVisible(true);

		}

		if (value == "Sales Order View") {
			Daily_SO_View window = new Daily_SO_View();
			window.SOViewFrame.setVisible(true);
		}

		if (value == "Sales Order-Production") {

			ProductionOrder window = new ProductionOrder();
			window.prodOrderFrame.setVisible(true);
		}

		if (value == "Sales Order") {
			SalesOrder window;
			try {
				window = new SalesOrder();
				window.SalesOrderFrame.setVisible(true);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}

		if (value == "Sales Order Consolidation") {
			SalesOrder_Consolidation window = new SalesOrder_Consolidation();
			window.SOConsolidationFrame.setVisible(true);
		}

		if (value == "Generate Purchase Order") {

		}

		if (value == "Delivery Challan") {

		}

		if (value == "Delivery Rejection") {

		}

		if (value == "Book Invoice") {

		}

	}
}// last

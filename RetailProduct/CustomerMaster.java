package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.KeyboardFocusManager;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.xml.parsers.ParserConfigurationException;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class CustomerMaster extends getResultSet {

	JFrame CustomerFrame;
	private String vcomp;
	private JTextField talukaname;
	private JTextField talukacode;
	private JTextField totalland;
	private JTextField distname;
	private JTextField distcode;
	JPanel custoptionalPanel ;
	private JLabel lblNewLabel_5;
	private JTextField altername;
	private JTextField creditlimit;
	JLabel lblmonthpromo;
	private JScrollPane jsp;

	JPanel agropanel;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnCancel;
	private String btnType = "S";
	JLabel lblStore;
	JButton btnOpBal;
	private JCheckBox chkboxdelear;
	private String schemecode;
	private JTextField tindate;
	private JTextField cstdate;
	private JTextField companyname;
	private JTextField opbal;
	private JButton btnCity;
	String vdrcr;
	String vopbal;

	private JTextField Code;
	private JTextField Name;
	private JTextField ContactPerson;
	private JTextField Crdays;
	private JTextField addr1;
	private JTextField addr2;
	private JTextField addr3;
	private JTextField addr4;

	private JComboBox comboSupplierType;

	private JPanel h2panel;

	private JTextField tel;
	private JTextField mobile;
	private JTextField pincode;
	JComboBox scheme;
	private JTextField mobile2;
	private JTextField companycode;
	private JTextField storecode;
	private JTextField storename;
	private JLabel lblCstNumber;
	private JTextField cstno;
	private JTextField fssaino;
	private JLabel lblFssaiNo;
	private JButton btnSearch;
	private JTextField email;
	public JComboBox comboGroup;
	public JComboBox comboClass;
	public JComboBox comboType;
	public JComboBox comboSupplier = new JComboBox();
	public ResultSet rs;

	static KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
	static KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
	static KeyStroke ctrlTab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, KeyEvent.CTRL_DOWN_MASK);
	static Set<KeyStroke> keys = new HashSet<>();
	private JTextField typecode;
	private JTextField classcode;
	private JTextField groupcode;
	private JTextField custType;
	private JTextField custClass;
	private JTextField custGroup;

	/// Table Related

	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable();
	private String custCol[] = { " customer_code ", " Customer_name ", "Mobile_No", 
			"Email_id", "Credit Days", "State" };

	private JViewport prt;
	private JTextField TINNO;
	private JTextField state_code;
	private JTextField city_code;
	private JTextField state_name;
	private JTextField city_name;
	private JTextField gendername;
	private JTextField gendercode;
	private String DBStatus;
	private JComboBox drcr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// keys.add(enter);
					keys.add(tab);
					keys.add(ctrlTab);
					KeyboardFocusManager.getCurrentKeyboardFocusManager()
							.setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
					CustomerMaster window = new CustomerMaster();
					window.CustomerFrame.setVisible(true);
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
	public CustomerMaster() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @param <KeyStroke>
	 * @throws Throwable
	 */
	private <KeyStroke> void initialize() throws Throwable {
		CustomerFrame = new JFrame();
		CustomerFrame.setBackground(Color.RED);
		CustomerFrame.setFont(new Font("SansSerif", Font.PLAIN, 13));
		CustomerFrame.setAutoRequestFocus(false);
		CustomerFrame.setType(Type.POPUP);
		CustomerFrame.setResizable(false);
		CustomerFrame.setTitle("Business Application");
		CustomerFrame.setAlwaysOnTop(true);
		// CustomerFrame.setBounds(350, 50, 761, 696);
		CustomerFrame.setBounds(1, 90, 1350, 605);
		CustomerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CustomerFrame.getContentPane().setLayout(null);

		String name = new gnConfig().getCompany();
		CustomerFrame.getContentPane().setBackground(Color.WHITE);
		CustomerFrame.getContentPane().setLayout(null);

		JPanel hpanel = new JPanel();
		hpanel.setBounds(0, 13, 744, 592);
		hpanel.setBackground(Color.WHITE);
		hpanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 255, 204), null, null, null));
		CustomerFrame.getContentPane().add(hpanel);
		hpanel.setLayout(null);

		Code = new JTextField();
		Code.setBounds(23, 53, 37, 30);
		hpanel.add(Code);
		Code.setColumns(11);

		ActionListener lscncl = new lsnr();
		ActionListener ct = new city();

		Name = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};

		Name.setForeground(Color.WHITE);
		Name.setBackground(Color.DARK_GRAY);
		Name.setDocument(new gnSetinputLimit(50));
		Name.setFont(new Font("Arial Unicode MS", Font.BOLD, 13));
		Name.setToolTipText("Max Char Limit is 50 ");
		Name.setBounds(66, 53, 407, 30);
		hpanel.add(Name);
		Name.setColumns(50);
		Name.transferFocus();
		try {
			MaskFormatter mk = new MaskFormatter("###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		companycode = new JTextField();
		companycode.setEditable(false);
		companycode.setBackground(Color.WHITE);
		companycode.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		companycode.setBounds(23, 3, 58, 22);
		hpanel.add(companycode);
		companycode.setColumns(10);
		lblStore = new JLabel("Store");
		lblStore.setEnabled(false);
		lblStore.setForeground(new Color(0, 0, 102));
		lblStore.setFont(new Font("Calibri", Font.BOLD, 13));
		lblStore.setBounds(634, 8, 31, 10);
		hpanel.add(lblStore);

		storecode = new JTextField();
		storecode.setEnabled(false);
		storecode.setBackground(Color.WHITE);
		storecode.setFont(new Font("Calibri", Font.PLAIN, 13));
		storecode.setEditable(false);
		storecode.setBounds(670, 3, 21, 15);
		hpanel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setEnabled(false);
		storename.setBackground(Color.WHITE);
		storename.setFont(new Font("Calibri", Font.PLAIN, 13));
		storename.setEditable(false);
		storename.setBounds(701, 3, 31, 15);
		hpanel.add(storename);
		storename.setColumns(10);

		btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(CustomerMaster.class.getResource("/RetailProduct/search.png")));
		btnSearch.setBounds(475, 53, 31, 30);
		hpanel.add(btnSearch);

		companyname = new JTextField();
		companyname.setEditable(false);
		companyname.setBackground(Color.WHITE);
		companyname.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		companyname.setBounds(82, 0, 338, 25);
		hpanel.add(companyname);
		companyname.setColumns(10);

		lblNewLabel_5 = new JLabel("Alternate Name (If Required)");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(25, 84, 243, 16);
		hpanel.add(lblNewLabel_5);

		altername = new JTextField();
		altername.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		altername.setForeground(new Color(0, 0, 102));
		altername.setToolTipText("Enter Alternate Name If Required..");
		altername.setBounds(23, 101, 450, 30);
		hpanel.add(altername);
		altername.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Enter Party Name *");
		lblNewLabel_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(21, 31, 152, 22);
		hpanel.add(lblNewLabel_6);

		JPanel addressPanel = new JPanel();
		addressPanel.setBounds(12, 265, 722, 243);
		hpanel.add(addressPanel);
		addressPanel.setBorder(new TitledBorder(new LineBorder(new Color(130, 135, 144)), "Enter Address Details",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
		addressPanel.setBackground(Color.WHITE);
		addressPanel.setLayout(null);

		// addr1 = new JTextField();
		addr1 = new gnRoundTextField(20);
		addr1.setFont(new Font("Arial", Font.BOLD, 12));
		addr1.setBounds(369, 24, 275, 27);
		addr1.setDocument(new gnSetinputLimit(25));

		addr1.setToolTipText("Max Char limit is 25 ");
		addressPanel.add(addr1);
		addr1.setColumns(25);

		// addr2 = new JTextField();
		addr2 = new gnRoundTextField(20);
		addr2.setFont(new Font("Arial", Font.BOLD, 12));
		addr2.setBounds(369, 51, 275, 27);
		addr2.setDocument(new gnSetinputLimit(25));
		addr2.setToolTipText("Max Char limit is 25 ");
		addressPanel.add(addr2);
		addr2.setColumns(10);

		JLabel lblPinCode = new JLabel("Pin code");
		lblPinCode.setFont(new Font("Arial", Font.BOLD, 13));
		lblPinCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPinCode.setBounds(564, 150, 80, 9);
		addressPanel.add(lblPinCode);

		// MaskFormatter mf2 = new MaskFormatter("######");
		// pincode = new JTextField();
		pincode = new gnRoundTextField(20);
		pincode.setBackground(Color.WHITE);
		pincode.setFont(new Font("Calibri", Font.BOLD, 12));
		pincode.setBounds(650, 143, 72, 27);
		pincode.setToolTipText("Number field, Enter only numbers ");
		addressPanel.add(pincode);
		pincode.setColumns(10);

		city_code = new JTextField();
		city_code.setBounds(290, 41, 56, 16);
		addressPanel.add(city_code);
		city_code.setFont(new Font("Calibri", Font.PLAIN, 13));
		city_code.setEnabled(false);
		city_code.setBackground(Color.CYAN);
		city_code.setColumns(10);

		// city_name = new JTextField();
		city_name = new gnRoundTextField(20);
		city_name.setBounds(12, 35, 278, 28);
		addressPanel.add(city_name);
		city_name.setForeground(new Color(0, 0, 102));
		city_name.setFont(new Font("Arial", Font.BOLD, 12));
		city_name.setToolTipText("Press Enter To Select City");
		city_name.setBackground(Color.WHITE);
		city_name.setColumns(10);

		// talukaname = new JTextField();
		talukaname = new gnRoundTextField(20);
		talukaname.setBounds(12, 111, 278, 28);
		addressPanel.add(talukaname);
		talukaname.setForeground(new Color(0, 0, 102));
		talukaname.setFont(new Font("Arial", Font.BOLD, 12));
		talukaname.setToolTipText("Press Enter to Select ");
		talukaname.setBackground(Color.WHITE);
		talukaname.setColumns(10);

		// distname = new JTextField();
		distname = new gnRoundTextField(20);
		distname.setBounds(12, 141, 278, 28);
		addressPanel.add(distname);
		distname.setForeground(new Color(0, 0, 102));
		distname.setFont(new Font("Arial", Font.BOLD, 12));
		distname.setToolTipText("Press Enter to Select ");
		distname.setBackground(Color.WHITE);
		distname.setColumns(10);

		// state_name = new JTextField();
		state_name = new gnRoundTextField(20);
		state_name.setBounds(12, 80, 278, 28);
		addressPanel.add(state_name);
		state_name.setForeground(new Color(0, 0, 102));
		state_name.setFont(new Font("Arial", Font.BOLD, 12));
		state_name.setToolTipText("Press Enter To Select State");
		state_name.setBackground(Color.WHITE);
		state_name.setColumns(10);

		talukacode = new JTextField();
		talukacode.setBounds(290, 103, 56, 16);
		addressPanel.add(talukacode);
		talukacode.setText("0");
		talukacode.setBackground(Color.CYAN);
		talukacode.setColumns(10);

		distcode = new JTextField();
		distcode.setBounds(290, 132, 56, 16);
		addressPanel.add(distcode);
		distcode.setText("0");
		distcode.setEditable(false);
		distcode.setColumns(10);

		state_code = new JTextField();
		state_code.setBounds(290, 69, 56, 16);
		addressPanel.add(state_code);
		state_code.setFont(new Font("Calibri", Font.PLAIN, 13));
		state_code.setEnabled(false);
		state_code.setBackground(Color.CYAN);
		state_code.setColumns(10);

		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setBounds(18, 170, 328, 16);
		addressPanel.add(lblEmailId);
		lblEmailId.setForeground(new Color(0, 0, 153));
		lblEmailId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailId.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));

		email = new JTextField();
		email.setBounds(12, 188, 334, 30);
		addressPanel.add(email);
		email.setBackground(Color.CYAN);
		email.setFont(new Font("Segoe UI", Font.BOLD, 13));
		email.setToolTipText("Max Limit is 40 Char's");
		email.setColumns(10);
		
		custoptionalPanel = new JPanel();
		custoptionalPanel.setBackground(Color.WHITE);
		custoptionalPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		custoptionalPanel.setBounds(369, 170, 328, 60);
		addressPanel.add(custoptionalPanel);
		custoptionalPanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Date Of Birth");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(12, 0, 89, 16);
		custoptionalPanel.add(lblNewLabel_3);
		
		//dob = new JTextField();
		dob = new gnRoundTextField(10);
 		dob.setHorizontalAlignment(SwingConstants.LEFT);
		dob.setBounds(12, 18, 104, 32);
		custoptionalPanel.add(dob);
		dob.setColumns(10);
		
		lblmonthpromo = new JLabel("Apply For Month-Promo");
		lblmonthpromo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblmonthpromo.setBounds(116, 0, 167, 16);
		custoptionalPanel.add(lblmonthpromo);
		
		//applyforpromo = new JTextField();
		applyforpromo = new gnRoundTextField(10);
 		applyforpromo.setHorizontalAlignment(SwingConstants.CENTER);
		applyforpromo.setText("N");
		applyforpromo.setBounds(119, 18, 167, 32);
		custoptionalPanel.add(applyforpromo);
		applyforpromo.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("City");
		lblNewLabel_7.setBounds(12, 13, 56, 16);
		addressPanel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("State");
		lblNewLabel_9.setBounds(12, 61, 56, 16);
		addressPanel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Address");
		lblNewLabel_10.setBounds(435, 10, 56, 16);
		addressPanel.add(lblNewLabel_10);
		
				// addr3 = new JTextField();
				addr3 = new gnRoundTextField(20);
				addr3.setBounds(369, 80, 275, 28);
				addressPanel.add(addr3);
				addr3.setFont(new Font("Arial", Font.PLAIN, 14));
				addr3.setToolTipText("Max Char limit is 25 ");
				addr3.setDocument(new gnSetinputLimit(25));
				addr3.setColumns(10);
				
						// addr4 = new JTextField();
						addr4 = new gnRoundTextField(20);
						addr4.setBounds(369, 111, 275, 27);
						addr4.setBackground(Color.WHITE);
						addressPanel.add(addr4);
						//addr4.setEnabled(false);
						//addr4.setEditable(false);
						addr4.setFont(new Font("Arial", Font.BOLD, 12));
						addr4.setDocument(new gnSetinputLimit(25));
						addr4.setToolTipText("Max Char limit is 25 ");
						addr4.setColumns(10);
			 
		JLabel lblMobile = new JLabel("*Mobile");
		lblMobile.setBounds(23, 135, 78, 16);
		hpanel.add(lblMobile);
		lblMobile.setForeground(new Color(0, 0, 102));
		lblMobile.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblMobile.setHorizontalAlignment(SwingConstants.LEFT);

		// MaskFormatter mf14 = new MaskFormatter("##########");
		mobile = new JTextField();
		mobile.setBounds(24, 151, 189, 30);
		hpanel.add(mobile);
		mobile.setForeground(new Color(0, 0, 102));
		mobile.setFont(new Font("Arial", Font.BOLD, 12));
		mobile.setToolTipText("Number field,  Enter only numbers  required length is 10");
		mobile.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel(" ");
		lblNewLabel_8.setIcon(new ImageIcon(CustomerMaster.class.getResource("/RetailProduct/panel8.png")));
		lblNewLabel_8.setBounds(12, 24, 732, 2);
		hpanel.add(lblNewLabel_8);

		JLabel lblCrdays = new JLabel("Cr.Days");
		lblCrdays.setBounds(211, 133, 56, 16);
		hpanel.add(lblCrdays);
		lblCrdays.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrdays.setFont(new Font("Arial", Font.BOLD, 13));
		// Crdays = new JTextField();
		Crdays = new gnRoundTextField(20);
		Crdays.setBounds(219, 149, 94, 32);
		hpanel.add(Crdays);
		Crdays.setFont(new Font("Arial", Font.BOLD, 13));
		Crdays.setText("000");
		Crdays.setColumns(10);

		lblFssaiNo = new JLabel("fssai No.");
		lblFssaiNo.setBounds(324, 135, 94, 16);
		hpanel.add(lblFssaiNo);
		lblFssaiNo.setForeground(new Color(0, 0, 153));
		lblFssaiNo.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblFssaiNo.setHorizontalAlignment(SwingConstants.LEFT);

		fssaino = new JTextField();
		fssaino.setBounds(325, 151, 99, 30);
		hpanel.add(fssaino);
		fssaino.setBackground(Color.CYAN);
		fssaino.setText("0");
		fssaino.setColumns(10);

		btnCity = new JButton("Create City");
		btnCity.setBounds(598, 147, 115, 32);
		hpanel.add(btnCity);
		btnCity.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CityMaster window;
				try {
					window = new CityMaster();
					window.frameCity.setVisible(true);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCity.setForeground(Color.BLACK);

		JLabel lblNewLabel_1 = new JLabel("Credit Limit(Rs.)");
		lblNewLabel_1.setBounds(435, 134, 127, 16);
		hpanel.add(lblNewLabel_1);

		creditlimit = new JTextField();
		creditlimit.setBounds(426, 152, 160, 30);
		hpanel.add(creditlimit);
		creditlimit.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setBounds(113, 517, 85, 34);
		hpanel.add(btnSave);
		btnSave.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApsave1.png"));
		btnSave.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApsave.png"));
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnSave.setMnemonic('S');

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(199, 517, 118, 34);
		hpanel.add(btnUpdate);
		btnUpdate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnUpdate.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApUpdate1.png"));
		btnUpdate.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApUpdate1.png"));
		btnUpdate.setEnabled(false);
		btnUpdate.setMnemonic('U');

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(318, 517, 97, 34);
		hpanel.add(btnCancel);
		btnCancel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnCancel.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose.png"));
		btnCancel.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose1.png"));
		btnCancel.setMnemonic('C');

		btnOpBal = new JButton("Ledger Op.Bal Entry");
		btnOpBal.setBounds(417, 517, 213, 34);
		hpanel.add(btnOpBal);
		btnOpBal.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));

		h2panel = new JPanel();
		h2panel.setBounds(642, 516, 90, 35);
		hpanel.add(h2panel);
		h2panel.setVisible(false);
		h2panel.setBackground(new Color(153, 255, 255));
		h2panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, new Color(64, 64, 64), null, null));
		h2panel.setLayout(null);

		JLabel lblContactPerson = new JLabel("Contact Person ");
		lblContactPerson.setHorizontalAlignment(SwingConstants.LEFT);
		lblContactPerson.setForeground(new Color(0, 0, 153));
		lblContactPerson.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblContactPerson.setBounds(135, 25, 179, 16);
		h2panel.add(lblContactPerson);

		ContactPerson = new JTextField();
		ContactPerson.setBounds(135, 43, 237, 25);
		h2panel.add(ContactPerson);
		ContactPerson.setColumns(10);

		JLabel lblSupplierType = new JLabel("Supplier Type");
		lblSupplierType.setForeground(new Color(0, 0, 153));
		lblSupplierType.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblSupplierType.setBounds(12, 27, 111, 16);
		h2panel.add(lblSupplierType);

		comboSupplierType = new JComboBox();
		comboSupplierType.setFont(new Font("Calibri", Font.BOLD, 13));
		comboSupplierType.setBackground(new Color(51, 255, 255));
		comboSupplierType.setModel(new DefaultComboBoxModel(
				new String[] { "Manufacturar", "Distributor", "Local Supplier", "Import Supplier" }));
		comboSupplierType.setBounds(12, 45, 118, 22);
		h2panel.add(comboSupplierType);
		comboSupplierType.setSelectedIndex(2);

		lblCstNumber = new JLabel("CST Number");
		lblCstNumber.setForeground(new Color(0, 0, 153));
		lblCstNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblCstNumber.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblCstNumber.setBounds(159, 130, 92, 16);
		h2panel.add(lblCstNumber);
		lblCstNumber.setVisible(false);

		cstno = new JTextField();
		cstno.setBackground(Color.CYAN);
		cstno.setFont(new Font("Calibri", Font.BOLD, 13));
		cstno.setText("0");
		cstno.setBounds(159, 145, 92, 25);
		cstno.setVisible(false);
		h2panel.add(cstno);
		cstno.setColumns(10);

		JLabel lblDate_1 = new JLabel("Date");
		lblDate_1.setForeground(new Color(0, 0, 153));
		lblDate_1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblDate_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate_1.setBounds(252, 127, 34, 16);
		h2panel.add(lblDate_1);
		lblDate_1.setVisible(false);

		cstdate = new JTextField();
		cstdate.setBackground(Color.CYAN);
		cstdate.setBounds(252, 145, 82, 25);
		h2panel.add(cstdate);
		cstdate.setVisible(false);
		cstdate.setColumns(10);

		JLabel lblNewLabel = new JLabel("Op.Bal");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel.setBounds(-2, 124, 83, 12);
		h2panel.add(lblNewLabel);

		opbal = new JTextField();
		opbal.setBackground(Color.CYAN);
		opbal.setFont(new Font("Calibri", Font.BOLD, 13));
		opbal.setToolTipText("Enter Opening Bal of Party ");
		opbal.setText("0");
		opbal.setBounds(0, 140, 104, 30);
		h2panel.add(opbal);
		opbal.setColumns(10);

		drcr = new JComboBox();
		drcr.setFont(new Font("Calibri", Font.BOLD, 13));
		drcr.setModel(new DefaultComboBoxModel(new String[] { "Dr", "Cr" }));
		drcr.setBounds(109, 140, 49, 28);
		h2panel.add(drcr);

		JLabel lblTelephone = new JLabel("Telephone ");
		lblTelephone.setForeground(new Color(0, 0, 153));
		lblTelephone.setBounds(12, 81, 98, 16);
		h2panel.add(lblTelephone);
		lblTelephone.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelephone.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));

		JLabel lblMobile2 = new JLabel("Mobile 2");
		lblMobile2.setForeground(new Color(0, 0, 153));
		lblMobile2.setBounds(122, 81, 101, 16);
		h2panel.add(lblMobile2);
		lblMobile2.setHorizontalAlignment(SwingConstants.LEFT);
		lblMobile2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		// mf5 = new MaskFormatter("##########");
		tel = new JTextField();
		tel.setBounds(12, 96, 106, 30);
		h2panel.add(tel);
		tel.setBackground(Color.CYAN);
		tel.setFont(new Font("Calibri", Font.BOLD, 12));

		tel.setToolTipText("Number field Enter only numbers ");
		tel.setColumns(10);

		// MaskFormatter mf3 = new MaskFormatter("##########");
		mobile2 = new JTextField();
		mobile2.setBounds(122, 96, 96, 30);
		h2panel.add(mobile2);
		mobile2.setBackground(Color.CYAN);
		mobile2.setFont(new Font("Calibri", Font.BOLD, 12));
		mobile2.setToolTipText("Number field,  Enter only numbers ");
		mobile2.setColumns(10);

		JButton btnNewButton_1 = new JButton("Additional Supplier Information");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setForeground(new Color(0, 0, 102));
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		btnNewButton_1.setBounds(-2, 0, 46, 25);
		h2panel.add(btnNewButton_1);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(218, 81, 73, 16);
		h2panel.add(lblDate);
		lblDate.setForeground(new Color(0, 0, 153));
		lblDate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);

		tindate = new JTextField();
		tindate.setBounds(219, 98, 72, 28);
		h2panel.add(tindate);
		tindate.setBackground(Color.CYAN);
		tindate.setColumns(10);

		JPanel h1Panel = new JPanel();
		h1Panel.setBounds(359, 13, 235, 233);
		h2panel.add(h1Panel);
		h1Panel.setVisible(false);
		h1Panel.setBackground(new Color(153, 255, 255));
		h1Panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		h1Panel.setLayout(null);

		JLabel lblCustomerClass = new JLabel("Customer Class");
		lblCustomerClass.setBounds(34, 80, 127, 16);
		lblCustomerClass.setForeground(new Color(51, 0, 153));
		lblCustomerClass.setFont(new Font("Segoe UI", Font.BOLD, 13));
		h1Panel.add(lblCustomerClass);

		JLabel lblCustomerType = new JLabel("Customer Type");
		lblCustomerType.setBounds(34, 26, 140, 16);
		lblCustomerType.setForeground(new Color(51, 0, 153));
		lblCustomerType.setFont(new Font("Segoe UI", Font.BOLD, 13));
		h1Panel.add(lblCustomerType);

		JButton btnNewButton = new JButton("Attributes  For Customer");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 102));
		btnNewButton.setBackground(new Color(102, 255, 255));
		btnNewButton.setBounds(0, 0, 339, 25);
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		h1Panel.add(btnNewButton);

		typecode = new JTextField();
		typecode.setFont(new Font("Segoe UI", Font.BOLD, 13));
		typecode.setEditable(false);
		typecode.setBounds(243, 44, 51, 30);
		h1Panel.add(typecode);
		typecode.setColumns(10);

		classcode = new JTextField();
		classcode.setFont(new Font("Segoe UI", Font.BOLD, 13));
		classcode.setEditable(false);
		classcode.setBounds(241, 99, 51, 30);
		h1Panel.add(classcode);
		classcode.setColumns(10);

		groupcode = new JTextField();
		groupcode.setFont(new Font("Segoe UI", Font.BOLD, 13));
		groupcode.setEditable(false);
		groupcode.setBounds(241, 150, 51, 30);
		h1Panel.add(groupcode);
		groupcode.setColumns(10);

		JLabel lblCode_1 = new JLabel("Code");
		lblCode_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblCode_1.setBounds(246, 80, 43, 16);
		h1Panel.add(lblCode_1);

		JLabel lblCode_2 = new JLabel("Code");
		lblCode_2.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblCode_2.setBounds(243, 26, 56, 16);
		h1Panel.add(lblCode_2);

		JLabel lblCode_3 = new JLabel("Code");
		lblCode_3.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblCode_3.setBounds(241, 131, 56, 16);
		h1Panel.add(lblCode_3);

		custType = new JTextField();
		custType.setFont(new Font("Segoe UI", Font.BOLD, 13));
		custType.setBackground(Color.CYAN);
		custType.setForeground(Color.BLACK);
		custType.setToolTipText("Press Enter To Get Help");
		custType.setBounds(34, 40, 99, 30);
		h1Panel.add(custType);
		custType.setColumns(10);

		custClass = new JTextField();
		custClass.setFont(new Font("Segoe UI", Font.BOLD, 13));
		custClass.setBackground(Color.CYAN);
		custClass.setForeground(Color.BLACK);
		custClass.setToolTipText("Press Enter To Get Help");
		custClass.setBounds(34, 99, 91, 30);
		h1Panel.add(custClass);
		custClass.setColumns(10);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(0, 0, 204));
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblGender.setBounds(78, 178, 56, 16);
		h1Panel.add(lblGender);

		gendername = new JTextField();
		gendername.setFont(new Font("Segoe UI", Font.BOLD, 13));
		gendername.setText("Male<M>/Femal<F>");
		gendername.setEnabled(false);
		gendername.setEditable(false);
		gendername.setBounds(78, 196, 51, 30);
		h1Panel.add(gendername);
		gendername.setColumns(10);

		JLabel lblCode_4 = new JLabel("Code");
		lblCode_4.setForeground(new Color(0, 0, 204));
		lblCode_4.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblCode_4.setBounds(23, 178, 36, 16);
		h1Panel.add(lblCode_4);

		gendercode = new JTextField();
		gendercode.setFont(new Font("Segoe UI", Font.BOLD, 13));
		gendercode.setBackground(Color.CYAN);
		gendercode.setText("M");
		gendercode.setBounds(23, 196, 51, 30);
		h1Panel.add(gendercode);
		gendercode.setColumns(10);

		JLabel lblCustomerGroup = new JLabel("Customer Group");
		lblCustomerGroup.setBounds(34, 131, 127, 16);
		h1Panel.add(lblCustomerGroup);
		lblCustomerGroup.setForeground(new Color(51, 0, 153));
		lblCustomerGroup.setFont(new Font("Segoe UI", Font.BOLD, 13));

		custGroup = new JTextField();
		custGroup.setBounds(34, 150, 99, 30);
		h1Panel.add(custGroup);
		custGroup.setFont(new Font("Segoe UI", Font.BOLD, 13));
		custGroup.setForeground(Color.BLACK);
		custGroup.setBackground(Color.WHITE);
		custGroup.setToolTipText("Press Enter To Get Help");
		custGroup.setColumns(10);

		agropanel = new JPanel();
		agropanel.setBounds(590, 103, 127, 30);
		hpanel.add(agropanel);
		agropanel.setBorder(new MatteBorder(0, 3, 0, 4, (Color) Color.DARK_GRAY));
		agropanel.setBackground(Color.WHITE);
		agropanel.setLayout(null);

		totalland = new JTextField();
		totalland.setFont(new Font("Arial", Font.BOLD, 12));
		totalland.setBounds(79, 0, 36, 28);
		agropanel.add(totalland);
		totalland.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Total Land");
		lblNewLabel_2.setBounds(0, 5, 71, 16);
		agropanel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 11));

		JLabel lblIsSupplier = new JLabel("Is Supplier ?");
		lblIsSupplier.setBounds(13, 194, 91, 16);
		hpanel.add(lblIsSupplier);
		lblIsSupplier.setHorizontalAlignment(SwingConstants.CENTER);
		lblIsSupplier.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblIsSupplier.setForeground(new Color(0, 0, 102));

		JPanel panel777 = new JPanel();
		panel777.setBounds(9, 220, 656, 38);
		hpanel.add(panel777);
		panel777.setBackground(Color.WHITE);
		panel777.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(64, 64, 64)));
		panel777.setLayout(null);

		chkboxdelear = new JCheckBox("Registered Delear");
		chkboxdelear.setBackground(Color.WHITE);
		chkboxdelear.setBounds(114, 2, 128, 31);
		panel777.add(chkboxdelear);
		chkboxdelear.setForeground(new Color(0, 51, 102));
		chkboxdelear.setFont(new Font("Tahoma", Font.BOLD, 10));
		chkboxdelear.setSelected(true);
		comboSupplier.setBounds(12, 1, 54, 30);
		panel777.add(comboSupplier);
		comboSupplier.setFont(new Font("Segoe UI", Font.BOLD, 11));
		comboSupplier.setToolTipText("Note : Please Select  Y For Supplier  &  For Customer Select N");
		comboSupplier.setBackground(Color.WHITE);

		// JComboBox comboSupplier = new JComboBox();
		comboSupplier.setModel(new DefaultComboBoxModel(new String[] { "X", "Y", "N" }));

		scheme = new JComboBox();
		scheme.setBounds(250, 2, 126, 32);
		panel777.add(scheme);
		scheme.setBackground(Color.WHITE);
		scheme.setToolTipText("Select Type of Gst scheme");
		scheme.setForeground(new Color(102, 51, 153));
		scheme.setFont(new Font("Calibri", Font.BOLD, 14));
		scheme.setModel(new DefaultComboBoxModel(new String[] { "No Tax", "Composition", "Regular" }));

		JLabel lblTinNumber = new JLabel("GSTNO");
		lblTinNumber.setBounds(375, 10, 43, 16);
		panel777.add(lblTinNumber);
		lblTinNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTinNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTinNumber.setForeground(Color.BLUE);

		TINNO = new JTextField();
		TINNO.setBounds(425, 4, 143, 30);
		panel777.add(TINNO);
		TINNO.setToolTipText("Enter GSTIN Number of Party");
		TINNO.setFont(new Font("Calibri", Font.BOLD, 13));
		TINNO.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel(
				"Note [Is Supplier ?] : Please Select ( Y - For Supplier ) &  ( N- For Customer )");
		lblNewLabel_4.setBounds(127, 192, 522, 25);
		hpanel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(new Color(0, 0, 153));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		// lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));

		jsp = new JScrollPane();
		jsp.setBounds(743, 36, 601, 520);

		MaskFormatter mf5;
		String sql3 = "call getAllcity()";
		String sql4 = "call getAllState()";
		ActionListener lscusttype = new lsnrcustType();
		ActionListener lscustclass = new lsnrcustClass();
		ActionListener lscustgrp = new lsnrcustGroup();
		String SQL99 = "call getAllCustomerType()";

		jsp = new JScrollPane();
		jsp.setBounds(744, 0, 600, 592);
		// SearchPanel.add(jsp);

		JViewport prt = new JViewport();
		prt.add(table, custCol);
		prt.setVisible(true);
		jsp.setViewport(prt);
		ActionListener ls = new lsnr();
		ActionListener taluka = new talukaLsnr();

		ActionListener dist = new distLsnr();

		KeyListener ky = new keyPressedlsnr();
		Name.addKeyListener(ky);
		altername.addKeyListener(ky);

		FocusListener fsnl = new btnfocus();
		Name.addFocusListener(fsnl);
		altername.addFocusListener(fsnl);
		addr1.addKeyListener(ky);
		addr2.addKeyListener(ky);
		addr1.addFocusListener(fsnl);
		addr2.addFocusListener(fsnl);
		mobile.addKeyListener(ky);
		mobile.addFocusListener(fsnl);
		state_name.addKeyListener(ky);
		state_name.addFocusListener(fsnl);
		distname.addActionListener(dist);
		distname.addKeyListener(ky);
		distname.addFocusListener(fsnl);
		talukaname.addActionListener(taluka);
		talukaname.addKeyListener(ky);
		talukaname.addFocusListener(fsnl);
		city_name.addActionListener(ct);
		city_name.addKeyListener(ky);
		city_name.addFocusListener(fsnl);

		ActionListener sup1 = new venorcustLsnr();

		CustomerFrame.getContentPane().add(jsp);
		btnOpBal.addActionListener(ls);
		btnCancel.addActionListener(lscncl);
		btnCancel.addKeyListener(ky);
		btnUpdate.addActionListener(ls);
		btnUpdate.addKeyListener(ky);
		btnSave.addActionListener(ls);
		btnSave.addKeyListener(ky);

		ActionListener src = new lsnrName();
		btnSearch.addActionListener(src);
		ActionListener st = new state();
		state_name.addActionListener(st);

		lblNewLabel_4.setIcon(null);
		
		lblNewLabel_11 = new JLabel("Press <Enter> on field to get focus in next field");
		lblNewLabel_11.setBounds(185, 31, 334, 16);
		hpanel.add(lblNewLabel_11);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		TINNO.addKeyListener(ky);
		comboSupplier.addActionListener(sup1);
		custGroup.addActionListener(lscustgrp);
		custClass.addActionListener(lscustclass);
		custType.addActionListener(lscusttype);
		addr4.addKeyListener(ky);
		addr4.addFocusListener(fsnl);
		addr3.addKeyListener(ky);
		addr3.addFocusListener(fsnl);

		decorate();
		Cancel();
	}

	class venorcustLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vselection = comboSupplier.getSelectedItem().toString();
			switch (vselection) {
			case "N":
 				custoptionalPanel.setVisible(true);
				break;

			case "Y":
				custoptionalPanel.setVisible(false);
				break;
			}
		}
	}

	class keyPressedlsnr implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int value = e.getKeyCode();
			// new General().msg("Key Pressed "+ value);
			switch (value) {
			case 10:

				if (btnCancel.isFocusOwner()) {
					btnCancel.doClick();
				}

				if (btnSave.isFocusOwner()) {
					btnSave.doClick();
				}

				if (btnUpdate.isFocusOwner()) {
					btnUpdate.doClick();
				}

				if (Name.isFocusOwner()) {
					altername.grabFocus();
				}

				if (altername.isFocusOwner()) {
					mobile.grabFocus();
				}

				if (mobile.isFocusOwner()) {
					TINNO.grabFocus();
 				}

				if (TINNO.isFocusOwner())
				{
					city_name.grabFocus();
				}
				
				if (city_name.isFocusOwner()) {
					state_name.grabFocus();
				}

				if (talukaname.isFocusOwner()) {
					distname.grabFocus();
				}

				if (distname.isFocusOwner()) {
					state_name.grabFocus();
				}

				if (state_name.isFocusOwner()) {
					addr1.grabFocus();
				}

				if (addr1.isFocusOwner()) {
					addr2.grabFocus();
				}

				if (addr2.isFocusOwner()) {
					addr3.grabFocus();
				}

				
				if (addr4.isFocusOwner()) {
					addr4.grabFocus();
				}

				if (addr4.isFocusOwner()) {
					email.grabFocus();
				}

 				
				
				if (email.isFocusOwner()) {
					if (btnSave.isEnabled()) {
						btnSave.grabFocus();
					}

					if (btnUpdate.isEnabled()) {
						btnUpdate.grabFocus();
					}
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

			if (Name.isFocusOwner()) {
				Name.setBackground(Color.darkGray);
				Name.setForeground(Color.WHITE);
				//Name.setText(null);
			}

			if (altername.isFocusOwner()) {
				//altername.setText(null);
				altername.setBackground(Color.darkGray);
				altername.setForeground(Color.WHITE);
			}

			if (city_name.isFocusOwner()) {
				city_name.setBackground(Color.darkGray);
				city_name.setForeground(Color.WHITE);
				//city_name.setText(null);
			}

			if (talukaname.isFocusOwner()) {
				talukaname.setBackground(Color.darkGray);
				talukaname.setForeground(Color.WHITE);
				//talukaname.setText(null);
			}

			if (addr2.isFocusOwner()) {
				addr2.setBackground(Color.darkGray);
				addr2.setForeground(Color.WHITE);
				//addr2.setText(null);
			}

			if (addr1.isFocusOwner()) {
				addr1.setBackground(Color.darkGray);
				addr1.setForeground(Color.WHITE);
				//addr1.setText(null);
			}

			if (distname.isFocusOwner()) {
				distname.setBackground(Color.darkGray);
				distname.setForeground(Color.WHITE);
				//distname.setText(null);

			}

			if (state_name.isFocusOwner()) {
				state_name.setBackground(Color.darkGray);
				state_name.setForeground(Color.WHITE);
				//state_name.setText(null);
			}

			if (mobile.isFocusOwner()) {
				mobile.setBackground(Color.darkGray);
				mobile.setForeground(Color.WHITE);
				//mobile.setText(null);
			}

		}

		@Override
		public void focusLost(FocusEvent e) {

			Name.setBackground(Color.white);
			Name.setForeground(Color.BLACK);

			city_name.setBackground(Color.white);
			city_name.setForeground(Color.BLACK);

			altername.setBackground(Color.white);
			altername.setForeground(Color.BLACK);

			talukaname.setBackground(Color.white);
			talukaname.setForeground(Color.BLACK);

			addr2.setBackground(Color.white);
			addr2.setForeground(Color.BLACK);

			addr1.setBackground(Color.white);
			addr1.setForeground(Color.BLACK);

			distname.setBackground(Color.white);
			distname.setForeground(Color.BLACK);

			state_name.setBackground(Color.white);
			state_name.setForeground(Color.BLACK);

			mobile.setBackground(Color.white);
			mobile.setForeground(Color.BLACK);

			// setButtonStyle() ;
		}
	}

	private void decorate() throws Throwable {

		CustomerFrame.setUndecorated(true);
		custoptionalPanel.setVisible(false);
		lblmonthpromo.setVisible(false);
		applyforpromo.setVisible(false);
 		mobile.setDocument(new gnSetinputLimit(10));
 		altername.setDocument(new gnSetinputLimit(50));
  		mobile.setToolTipText("Enter 10 Digit Number");
   		new General().setNumerOnlyforJtext(mobile);
  		new General().setNumerOnlyforJtext(pincode);
    	addr4.setText("");
		addr3.setText("");
		//addr4.setVisible(false);
		//addr3.setVisible(false);
		agropanel.setVisible(false);
		city_code.setVisible(false);
		state_code.setVisible(false);
		talukacode.setVisible(false);
		distcode.setVisible(false);
		distname.setVisible(false);
		talukaname.setVisible(false);

		lblStore.setVisible(false);
		storename.setVisible(false);
		storecode.setVisible(false);

		if (Language == "H") {
			Name.setFont(new Font("Shivaji02", Font.PLAIN, 16));
		}
		btnType = "S";
		new gnApp().setFrameTitel(CustomerFrame);
		new gnField().closeform(btnSave, CustomerFrame);

		new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnUpdate, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnCancel, Color.BLUE, Color.WHITE);

		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		vcomp = new gnConfig().getCompanyCode();
		if (vcomp == "0") {
			System.exit(0);
		}
		storecode.setText(new gnConfig().getStoreID());
		storename.setText(new gnConfig().getStorename(storecode.getText()));
		tel.setText("0");
		mobile2.setText("0");
		altername.setText(null);
		pincode.setText("0");
		typecode.setText("0");
		classcode.setText("0");
		groupcode.setText("0");
		btnUpdate.setEnabled(false);
		String vverticle = new gnHierarchy().getVerticleCode();
		switch (vverticle) {
		case "5":
			distname.setVisible(true);
			talukaname.setVisible(true);
			break;
			
		case "1":
			lblmonthpromo.setVisible(true);
			applyforpromo.setVisible(true);
			break ;
		}
	}

	public void Cancel() {
		btnSave.setEnabled(true);
		Code.setText("0");
		Name.setText(" ");
		mobile.setText("");
		mobile2.setText("0");
		talukacode.setText("0");
		distcode.setText("0");
		totalland.setText("0");
		talukaname.setText("Taluka");
		distname.setText("Distinct");
		state_code.setText("0");
		city_code.setText("0");
		gendercode.setText("M");
		gendername.setText("Male");
		Crdays.setText("007");
		tel.setText("0");
		pincode.setText("0");
		email.setText("");
		custType.setText("None");
		cstdate.setText("0");
		tindate.setText("0");
		custClass.setText("None");
		custGroup.setText("None");
		typecode.setText("0");
		classcode.setText("0");
		groupcode.setText("0");
		cstno.setText("0");
		fssaino.setText("0");

		addr1.setText(" ");
		addr2.setText(" ");
		addr3.setText("-");
		addr4.setText(".");
		ContactPerson.setText(null);
		tel.setText("0");
		Crdays.setText("007");
		mobile.setText("0");
		mobile2.setText("0");
		state_name.setText(" ");
		city_name.setText(" ");
		TINNO.setText("0");
		pincode.setText("0");
		email.setText(null);

		new gnTable().RemoveTableRows(model);
	}

	public void showTable() {
		String Col[] = { "Master Name", "Code", "Description", "Referece", "Show", "Verticle" };
		model.setColumnIdentifiers(Col);
		table.setModel(model);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification1);
		new General().msgsearch(jsp, table, "Select Data", 500, 400);
	}

	public CellEditorListener ChangeNotification1 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 0);
			dispattributes(value, row);
		}
	};
	private JTextField dob;
	private JTextField applyforpromo;
	private JLabel lblNewLabel_11;

	public void dispattributes(String value, int row) {
		switch (value) {
		case "Cust_type":
			typecode.setText(table.getValueAt(row, 1).toString());
			custType.setText(table.getValueAt(row, 2).toString());
			new General().msgDispose();
			table.addNotify();
			break;
		case "Cust_class":
			classcode.setText(table.getValueAt(row, 1).toString());
			custClass.setText(table.getValueAt(row, 2).toString());
			table.addNotify();
			new General().msgDispose();
			break;
		case "Cust_group":
			groupcode.setText(table.getValueAt(row, 1).toString());
			custGroup.setText(table.getValueAt(row, 2).toString());
			table.addNotify();
			new General().msgDispose();
			break;
		case "City":
			city_code.setText(table.getValueAt(row, 1).toString());
			city_name.setText(table.getValueAt(row, 2).toString());
			table.addNotify();
			new General().msgDispose();
			break;
		case "state":
			state_code.setText(table.getValueAt(row, 1).toString());
			state_name.setText(table.getValueAt(row, 2).toString());
			table.addNotify();
			new General().msgDispose();
			break;

		}
	}

	class state implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			String value = e1.getActionCommand();
			int id = e1.getID(); // Field id
			new gnTable().RemoveTableRows(model);
			String vtype = "State";
			try {
				vmastersearchString = "%" + state_name.getText() + "%";
				table = new gnAdmin().showMasterTableinTable(vtype, vmastersearchString);
				viewData(table);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// showTable() ;
		}
	}

	class city implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			String value = e1.getActionCommand();
			int id = e1.getID(); // Field id
			new gnTable().RemoveTableRows(model);
			String vtype = "City";
			try {
				vmastersearchString = "%" + city_name.getText() + "%";
				table = new gnAdmin().showMasterTableinTable(vtype, vmastersearchString);
				viewData(table);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class distLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			String value = e1.getActionCommand();
			int id = e1.getID(); // Field id
			new gnTable().RemoveTableRows(model);
			String vtype = "City";
			try {
				vmastersearchString = "%" + distname.getText() + "%";
				table = new gnAdmin().showMasterTableinTable(vtype, vmastersearchString);
				viewData(table);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class talukaLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			String value = e1.getActionCommand();
			int id = e1.getID(); // Field id
			new gnTable().RemoveTableRows(model);
			String vtype = "City";
			try {
				vmastersearchString = "%" + talukaname.getText() + "%";
				table = new gnAdmin().showMasterTableinTable(vtype, vmastersearchString);
				viewData(table);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// showTable() ;
		}
	}

	class lsnrcustType implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			String value = e1.getActionCommand();
			int id = e1.getID(); // Field id
			System.out.println("Value is " + value);
			System.out.println("Field id" + id);
			try {
				new gnTable().RemoveTableRows(model);
				String vtype = "Cust_type";
				vmastersearchString = "%" + custType.getText() + "%";
				new gnAdmin().showMasterTable(vtype, typecode, custType);
				// model = new gnConfig(). getMasterTableData(model ,vtype ,
				// vtype) ;
				// showTable() ;
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}

		}
	}

	class lsnrcustGroup implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			String value = e1.getActionCommand();
			int id = e1.getID(); // Field id
			System.out.println("Value is " + value);
			System.out.println("Field id" + id);
			new gnTable().RemoveTableRows(model);
			String vtype = "Cust_group";
			try {
				vmastersearchString = "%" + custGroup.getText() + "%";
				new gnAdmin().showMasterTable(vtype, groupcode, custGroup);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class lsnrcustClass implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			String value = e1.getActionCommand();
			int id = e1.getID(); // Field id
			System.out.println("Value is " + value);
			System.out.println("Field id" + id);
			new gnTable().RemoveTableRows(model);
			String vtype = "Cust_class";
			try {
				vmastersearchString = "%" + custClass.getText() + "%";
				new gnAdmin().showMasterTable(vtype, classcode, custClass);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class lsnrName implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			String value = e1.getActionCommand();
			String sql = "" ;
			try {

				String vname = Name.getText();
				vname = "%" + vname + "%";
				String vcomp = companycode.getText();
				
				String vverticle = new  gnHierarchy().getVerticleCode() ;
				switch(vverticle)
				{
				
				    
					case "1" :
					     String custColgroc[] = {"Type","CustId" , "Name" , "Mobile" , "IsSupplier?"  } ;
						sql = "select code, name, mobile , isSupplier from "
								+ "ms_customer_master where company_code = "+vcomp+" ";
						String vtype = "CUSTOMER";
						table = new gnTableModel().Tablemodel(table, model, sql, custColgroc, 4, "N", "Y", vtype);
					    break ; 	
				    default:
					sql = "call Tb_getbothsuplCustomer('" + vname + "' ," + vcomp + ")";
					vtype = "CUSTOMER";
					table = new gnTableModel().Tablemodel(table, model, sql, custCol, 6, "N", "Y", vtype);
				    break ;
				}
 				viewData(table);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}// lsrname

	public void selectRow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				Name.removeAll();
				int row = table.getSelectedRow();
				String value = table.getValueAt(row, 0).toString().trim();
				String vcode = table.getValueAt(row, 1).toString().trim();
				String vdesc = table.getValueAt(row, 2).toString().trim();
				try {
					switch (value) {
					case "CUSTOMER":
						showCustomer(vcode);
						break;

					case "City":
						city_code.setText(vcode);
						city_name.setText(vdesc);
						new gnTable().RemoveTableRows(model);
						state_name.grabFocus();
						break;

					case "State":
						state_code.setText(vcode);
						state_name.setText(vdesc);
						addr1.grabFocus();
						new gnTable().RemoveTableRows(model);
						break;
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void showCustomer(String value) throws SQLException, ClassNotFoundException {
		btnSave.setEnabled(false);
		btnUpdate.setEnabled(true);
		btnType = "U";
		String vcomp = companycode.getText();
		// disable();
		String sql1 = "call  Cus_getscancustomer( '" + value + "', " + vcomp + ")";
		rs = this.getSPResult(sql1);
		while (rs.next()) {
			Code.setText(rs.getString(1));
			Name.setText(rs.getString(2));
			String viscustomer = rs.getString(3);
			// String vsupplierType = rs.getNString(26);
			// switch (vsupplierType)
			// {
			// case "Manufacturar":
			// comboSupplier.setSelectedIndex(0);
			// break;
			// case "Distributor":
			// comboSupplier.setSelectedIndex(1);
			// break;
			// case "Local Supplier" : comboSupplier.setSelectedIndex(2) ;
			// break ;
			// case "Import Supplier" : comboSupplier.setSelectedIndex(3) ;
			// break ;
			// }
			addr1.setText(rs.getString(7));
			addr2.setText(rs.getString(8));
			addr3.setText(rs.getString(9));
			addr4.setText(rs.getString(10));
			city_code.setText(rs.getString(11));
			city_name.setText(rs.getString(12));
			state_code.setText(rs.getString(13));
			state_name.setText(rs.getString(14));
			tel.setText(rs.getString(15));
			mobile.setText(rs.getString(16));
			mobile2.setText(rs.getString(17));
			pincode.setText(rs.getString(18));
			email.setText(rs.getString(19));
			classcode.setText(rs.getString(20));
			custClass.setText(rs.getString(21));
			typecode.setText(rs.getString(22));
			custType.setText(rs.getString(23));
			groupcode.setText(rs.getString(24));
			custGroup.setText(rs.getString(25));
			ContactPerson.setText(rs.getString(5));
			Crdays.setText(rs.getString(6));
			fssaino.setText(rs.getString(28));

			String vdelear = rs.getString(29);
			talukacode.setText(rs.getString(30));
			talukaname.setText(rs.getString(31));
			totalland.setText(rs.getString(32));
			distcode.setText(rs.getString(33));
			distname.setText(rs.getString(34));
			altername.setText(rs.getString(35));

			switch (vdelear) {
			case "Y":
				chkboxdelear.setSelected(true);
				TINNO.setText(rs.getString(4));
				cstno.setText(rs.getString(27));
				break;
			case "N":
				chkboxdelear.setSelected(false);
				TINNO.setText(rs.getString(4));
				cstno.setText(rs.getString(27));
				break;
			}

		}
	}

	private void disable() {

		Code.setEnabled(false);
		// Name.setEnabled(false);
		// comboSupplier.setEnabled(false);
		// city_code.setEnabled(false);
		// city_name.setEnabled(false);
		// state_code.setEnabled(false);
		// state_name.setEnabled(false);
		// classcode.setEnabled(false);
		// custClass.setEnabled(false);
		// typecode.setEnabled(false);
		// custType.setEnabled(false);
		// groupcode.setEnabled(false);
		// custGroup.setEnabled(false);
		// fssaino.setEnabled(false);
		// chkboxdelear.setEnabled(false);
		// TINNO.setEnabled(false);
		// cstno.setEnabled(false);

	}

	private void enabled() {

		Code.setEnabled(true);
		Name.setEnabled(true);
		comboSupplier.setEnabled(true);
		city_code.setEnabled(true);
		city_name.setEnabled(true);
		state_code.setEnabled(true);
		state_name.setEnabled(true);
		classcode.setEnabled(true);
		custClass.setEnabled(true);
		typecode.setEnabled(true);
		custType.setEnabled(true);
		groupcode.setEnabled(true);
		custGroup.setEnabled(true);
		fssaino.setEnabled(true);
		chkboxdelear.setEnabled(true);
		TINNO.setEnabled(true);
		cstno.setEnabled(true);

	}

	class lsnr implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			String value = e1.getActionCommand();
			int id = e1.getID(); // Field id
			System.out.println("Value is " + value);
			System.out.println("Field id" + id);

			if (value == "Update") {
				try {
					String status = pickData();
					if (status == "Sucess") {
						updateCust();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			if (value == "Ledger Op.Bal Entry") {
				try {
					LedgerOpBalance window;
					window = new LedgerOpBalance();
					window.legeropbalframe.setVisible(true);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			if (value == "Save") {
				try {
					String status = "";
					String status1 = validateDelear();
					// new General().msg("Validate result is "+" "+status1);
					if (status1 == "sucess") {
						status = pickData();
						// new General().msg("pick data result is "+" "+status);
						if (status == "Sucess") {
							getcustomerCode();
							collectData();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			if (value == "Cancel") {
				CustomerFrame.dispose();
			}
		}
	}// lsnr

	private String validateDelear() {
		String status = "sucess";
		
		String vsupcust = comboSupplier.getSelectedItem().toString() ;

		if (mobile.getText().length() == 10) 
		{
  			String vmobile =mobile.getText() ; 
			status = checkPatyExist(vmobile) ;
  		}

		
		if (vsupcust == "X")
		{
			new General().msg("Select Supplier/Customer <Y->Supplier> <N-->Customer> ");
			comboSupplier.grabFocus();
			status = "Fail" ;
		}
		
		if (Name.getText().length() == 0) {
			new General().msg("Enter Supplier Name");
			status = "Fail";
			Name.grabFocus();
 		}

		if (mobile.getText().length() == 0) {
			new General().msg("Enter Supplier Mobile Number");
			status = "Fail";
			mobile.grabFocus();
		}
		
		if (mobile.getText().length() != 10) {
			new General().msg("Please Enter correct  Mobile Number 10 Digit");
			mobile.grabFocus();
 			status = "Fail";
		}
		 
		boolean vdelear = chkboxdelear.isSelected();
		// new General().msg("Value of delear is" + vdelear);
		if (TINNO.getText().length() == 0 && vdelear == true) {
			new General().msg("Enter GSTIN NO for Registered Delear");
			status = "Fail";
			TINNO.grabFocus();
 		}

		if (city_name.getText().length() == 0) {
			new General().msg("Select City First ... ");
			status = "Fail";
			city_name.grabFocus();
		}
		if (state_name.getText().length() == 0) {
			new General().msg("Select State First...");
			state_name.grabFocus();
 			status = "Fail";
		}
		if (addr1.getText().length() == 0) {
			addr1.setText("-");
 		}

		if (addr2.getText().length() == 0) {
			addr2.setText("-");
 		}

		if (addr3.getText().length() == 0) {
			addr3.setText("-");
 		}
		if (addr4.getText().length() == 0) {
			addr3.setText("-");
 		}

		
		if (dob.getText().length()  >  0)
		{
			if (dob.getText().length()  != 10 )
			{
				status = "Fail";
				new General().msg("Please Enter Corrent Birth Date <Format is DD.MM.YYYY>");
 			}
		}
  
   	return status;
	}

private String checkPatyExist(String vmobile)
{
	String status = "sucess" ;
	try {
	String SQL = "Select Name from ms_customer_master where company_code = "+vcomp+" and "
			  +  "   mobile = "+vmobile+" " ;
	new General().msg(SQL);
  	rs = this.getSPResult(SQL) ;
 	if (rs.next())
	{
		new General().msg("Party is Available For this Mobile Number:"+" Name-->"+ rs.getString(1));
		status = "Fail" ;
	}
 	} catch (ClassNotFoundException | SQLException e) {
 		e.printStackTrace();
 		new General().msg(e.getLocalizedMessage());
	}
	return status ;
}
	
	
	public String pickData() {
		// new General().msg("Checking Pick Data Process..");
		String status = "";
		String vname = Name.getText();
		String result = new General().checkLength(vname, 50);
		if (result == "Pass") {
			Name.setBackground(Color.WHITE);
			status = "Sucess";
		}
		if (result != "Pass") {
			new General().msg("check Length Of Filed Name .. Max char allow is 30");
			Name.grabFocus();
			Name.setBackground(Color.white);
			status = "Fail";
		}

		String vaddr1 = addr1.getText();
		String result1 = new General().checkLength(vaddr1, 25);
		if (result == "Pass") {
			addr1.setBackground(Color.WHITE);
			status = "Sucess";

		}
		if (result1 != "Pass") {
			new General().msg("check Length Of Filed Address line  1 .. Max char allow is 25");
			addr1.grabFocus();
			addr1.setBackground(Color.white);
			status = "Fail";
		}
		String vaddr2 = addr2.getText();
		String result2 = new General().checkLength(vaddr2, 25);
		if (result == "Pass") {
			addr2.setBackground(Color.WHITE);
			status = "Sucess";
		}
		if (result2 != "Pass") {
			new General().msg("check Length Of Filed Address Line 2 .. Max char allow is 25");
			addr2.grabFocus();
			addr2.setBackground(Color.white);
			status = "Fail";
		}
		String vaddr3 = addr3.getText();
		String result3 = new General().checkLength(vaddr3, 25);
		if (result == "Pass") {
			addr3.setBackground(Color.WHITE);
			status = "Sucess";
		}
		if (result3 != "Pass") {
			new General().msg("check Length Of Filed Address Line 3 .. Max char allow is 25");
			addr3.grabFocus();
			addr3.setBackground(Color.white);
			status = "Fail";
		}
		String vaddr4 = addr4.getText();
		String result4 = new General().checkLength(vaddr4, 25);
		if (result == "Pass") {
			addr4.setBackground(Color.WHITE);
			status = "Sucess";
		}
		if (result4 != "Pass") {
			new General().msg("check Length Of Filed Address Line 4  .. Max char allow is 25");
			addr4.grabFocus();
			addr4.setBackground(Color.white);
			status = "Fail";
		}

		String vSupplierType = (String) comboSupplierType.getSelectedItem();
		String visSupplier = (String) comboSupplier.getSelectedItem();

		// Customer Attributes
		String vcustType = custType.getText().trim();
		String vcustClass = custClass.getText().trim();
		String vcustGroup = custGroup.getText().trim();

		String vtypecode = typecode.getText().trim();
		String vclasscode = classcode.getText().trim();
		String vgropcode = groupcode.getText().trim();

		// Integer fields
		// int vcode = Integer.parseInt(Code.getText().trim()) ;
		String vmobile = (mobile.getText().trim());
		String vmobile2 = (mobile2.getText().trim());
		String vtelephone = (tel.getText().trim());
		String vpincode = (pincode.getText().trim());

		///// Is Supplier Logic is here
		if (visSupplier == "Y" || visSupplier == "B") {
			String vcontactPerson = ContactPerson.getText();
			String MaxLength = new General().checkLength(vcontactPerson, 30);
			if (MaxLength == "Pass") {
				ContactPerson.setBackground(Color.WHITE);
				status = "Sucess";

			}
			if (MaxLength != "Pass") {
				new General().msg("check Length Of Filed Contact Person  .. Max char allow is 30 Chars");
				ContactPerson.grabFocus();
				ContactPerson.setBackground(Color.RED);
				status = "Fail";
			}
			int vcrdays = Integer.parseInt(Crdays.getText().trim());
			if (vcrdays == 0) {
				new General().msg("Credit Days for Supplier is <0> Please Check...");
				Crdays.grabFocus();
				status = "Fail";
			}
		}
		if (visSupplier == "C") {
			String vcontactPerson = "  ";
			int vcrdays = 0;
		}

		// new General().msg("Final Status of Pickdata Process is " + " "+status
		// );
		return status;

	}

	public void getcustomerCode() throws ClassNotFoundException, SQLException {
		String vcustcode = " ";
		vcomp = companycode.getText();
		String SQL = "call getcustomerCode(" + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vcustcode = rs.getString(1);
			if (vcustcode != "0") {
				Code.setText(vcustcode);
			}
			switch (vcustcode) {
			case "0":
				Code.setText("1");
				break;
			}
		}
	}

	public void collectData() throws Throwable {
		vcomp = companycode.getText();
		String status1 = "Sucess";
		boolean vdelear = chkboxdelear.isSelected();
		int vcode = Integer.parseInt(Code.getText().toString());
		String vregDelear = "N";
		if (vdelear) {
			vregDelear = "Y";
		}

		String vSchemetype = (String) scheme.getSelectedItem();
		switch (vSchemetype) {
		case "No Tax":
			schemecode = "0";
			break;
		case "Composition":
			schemecode = "1";
			break;
		case "Regular":
			schemecode = "2";
			break;
		}
		String vname = Name.getText();
		String viscustomer = comboSupplier.getSelectedItem().toString();
		String vsuplyType = comboSupplierType.getSelectedItem().toString();
		String vaddr1 = addr1.getText();
		String vaddr2 = addr2.getText();
		String vaddr3 = addr3.getText();
		String vaddr4 = addr4.getText();
		String vcitycode = city_code.getText();
		String vcityname = city_name.getText();
		String vstatecode = state_code.getText();
		String vstatename = state_name.getText();
		String vtel = (tel.getText().toString());

		String vtotalland = totalland.getText();

		if (totalland.getText().length() == 0) {
			vtotalland = "0";
		}

		String vtalukacode = talukacode.getText();
		String vtalukaname = talukaname.getText();

		String vdistcode = distcode.getText();
		String vdistname = distname.getText();

		String vmobile = (mobile.getText());
		String vmobile2 = (mobile2.getText());
		String vpincode = (pincode.getText());
		String vemail = email.getText();
		String vclasscode = classcode.getText();
		String vclassname = custClass.getText();
		String vtypecode = typecode.getText();
		String vtypename = custType.getText();
		String vgroupcode = groupcode.getText();
		String vgroupname = custGroup.getText();
		String vtinno = TINNO.getText().toString();
		String vcontactperson = ContactPerson.getText();
		int vcrdays = Integer.parseInt(Crdays.getText().toString());
		vdrcr = drcr.getSelectedItem().toString();
		vopbal = opbal.getText();
		if (vopbal.length() == 0) {
			vopbal = "0";
		}
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String poshdr = "Insert into ms_customer_master(Code, " + "Name, Gender , Addr1 , Addr2 , Addr3 , Addr4 , "
				+ "city , city_name , state , state_name , " + " tel , mobile , mobile1 , pincode , Email ,"
				+ "IsSupplier , creditDays, contact_person ," + " GSTNO , cust_class , class_name ,"
				+ " cust_type, Type_name , cust_group,  group_name ,"
				+ " Supplier_type , company_code, Site_code, verticle,  fssaino, reg_delear ,  gstdate, opbal, drcr, scheme,"
				+ "  talukacode , talukaname, totalland , distcode , distname , alternatename,"
				+ "  dob , applymonthlyPromo)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con1.prepareStatement(poshdr);
			prst.setInt(1, vcode);
			prst.setString(2, vname);
			prst.setString(3, "M");
			prst.setString(4, vaddr1);
			prst.setString(5, vaddr2);
			prst.setString(6, vaddr3);
			prst.setString(7, vaddr4);
			prst.setString(8, vcitycode);
			prst.setString(9, vcityname);
			prst.setString(10, vstatecode);
			prst.setString(11, vstatename);
			prst.setString(12, vtel);
			prst.setString(13, vmobile);
			prst.setString(14, vmobile2);
			prst.setString(15, vpincode);
			prst.setString(16, vemail);
			prst.setString(17, viscustomer);
			prst.setInt(18, vcrdays);
			prst.setString(19, vcontactperson);
			prst.setString(20, vtinno);
			prst.setString(21, vclasscode);
			prst.setString(22, vclassname);
			prst.setString(23, vtypecode);
			prst.setString(24, vtypename);
			prst.setString(25, vgroupcode);
			prst.setString(26, vgroupname);
			prst.setString(27, vsuplyType);
			prst.setString(28, vcomp);
			prst.setString(29, storecode.getText());
			prst.setString(30, new gnHierarchy().getVerticleCode());
			prst.setString(31, fssaino.getText());
			prst.setString(32, vregDelear);
			prst.setString(33, new gnConfig().date_ConverttoDBforamt(tindate.getText()));
			prst.setString(34, vopbal);
			prst.setString(35, vdrcr);
			prst.setString(36, schemecode);
			prst.setString(37, vtalukacode);
			prst.setString(38, vtalukaname);
			prst.setString(39, vtotalland);
			prst.setString(40, vdistcode);
			prst.setString(41, vdistname);
			prst.setString(42, altername.getText());
			
			if (dob.getText().length() == 0 )
			{
 				prst.setString(43, "000.00.00");
			}
			
			if (dob.getText().length() == 10 )
			{
				
 				prst.setString(43, new gnConfig().date_ConverttoDBforamt(dob.getText()));
			}
			
			prst.setString(44, applyforpromo.getText());
 			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBStatus = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBStatus = "Sucess";
				con1.commit();
				new General().msg("Data Saved Sucessfully ..");
			}
			prst.executeBatch(); // insert remaining records
			con1.commit();
			new General().msg("Data Saved Sucessfully ..");
		} catch (SQLException e) {
			new General().msg(e.getLocalizedMessage());
			con1.rollback();
			DBStatus = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con1 != null) {
				con1.close();

				if (btnType == "S") {
					// MakeEntryinGLMAST();
					insertGLMast();
					if (vcode == 1) {
						insertDefaultCustomer();
					}
				}
				Cancel();
 			}
		}
	}

	private void updateCust() throws Throwable {

		String vcode = Code.getText();
		vcomp = companycode.getText();
		String SQL = "Call N_upCust(" + vcomp + ", " + vcode + ")";
		String r = this.getResult(SQL);
		if (r == "Sucess") {
			collectData();
		}
		btnType = "S";
		btnUpdate.setEnabled(false);
		btnSave.setEnabled(true);
	}

	private void insertGLMast() throws Throwable {
		String vcode = Code.getText();
		String vname = Name.getText();
		String vtype = "";
		String viscustomer = comboSupplier.getSelectedItem().toString();
		switch (viscustomer) {
		case "Y":
			vtype = "Y";
			break;
		case "N":
			vtype = "N";
			break;
		}
		new gnAccountbase().insertGlData(vcode, vname, vtype);
	}

	public void MakeEntryinGLMAST() throws Throwable {
		vcomp = companycode.getText();
		String vcode = Code.getText();
		String status1 = "Sucess";
		String vname = Name.getText();
		String Accgrp_code = "";
		String Accgrp_name = " ";
		String accsubgrp_code = "0";
		String accsubgrp_name = "-";
		String drcrtype = "";

		String viscustomer = comboSupplier.getSelectedItem().toString();
		switch (viscustomer) {
		case "Y":
			accsubgrp_code = "0";
			accsubgrp_name = "-";
			Accgrp_code = "8";
			Accgrp_name = "Sundry Creditors";
			drcrtype = "Cr";

			break;

		case "N":
			accsubgrp_code = "0";
			accsubgrp_name = "-";
			Accgrp_code = "20";
			Accgrp_name = "Sundry Debtors";
			drcrtype = "Dr";
			break;
		}
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String glmast = "Insert into    ms_accounts_gl(GLCode, "
				+ "GLName, Acc_subgroup, Acc_group , drcrtype, groupname, subgroupname, company_code, site_code,"
				+ "finyear , opening_bal, opening_drcrTYpe)" + "values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con1.prepareStatement(glmast);
			prst.setString(1, vcode);
			prst.setString(2, vname);
			prst.setString(3, accsubgrp_code);
			prst.setString(4, Accgrp_code);
			prst.setString(5, drcrtype);
			prst.setString(6, Accgrp_name);
			prst.setString(7, accsubgrp_name);
			prst.setString(8, vcomp);
			prst.setString(9, storecode.getText());
			prst.setString(10, new gnFinYear().getReportingFinYear());
			prst.setString(11, vopbal);
			prst.setString(12, vdrcr);
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBStatus = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBStatus = "Sucess";
				con1.commit();
				new General().msg("GL Entry Posted ..");
			}
			prst.executeBatch(); // insert remaining records
			con1.commit();
			new General().msg("GL Entry Posted Sucessfully ..");
		} catch (SQLException e) {
			new General().msg(e.getLocalizedMessage());
			con1.rollback();
			DBStatus = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con1 != null) {
				con1.close();
			}
		}
	}

	public void insertDefaultCustomer() throws Throwable {
		new General().msg("Creating Default Record ..");
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String poshdr = "Insert into ms_customer_master(Company_code , Code, " + "Name,  Site_code, verticle)"
				+ "values(?,?,?,?,?)";
		try {
			prst = con1.prepareStatement(poshdr);
			prst.setString(1, vcomp);
			prst.setString(2, "0");
			prst.setString(3, "Default");
			prst.setString(4, "0");
			prst.setString(5, new gnHierarchy().getVerticleCode());
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBStatus = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBStatus = "Sucess";
				con1.commit();
				new General().msg("Default Data Saved Sucessfully ..");
			}
			prst.executeBatch(); // insert remaining records
			con1.commit();
			new General().msg("Default Data Saved Sucessfully ..");
		} catch (SQLException e) {
			new General().msg(e.getLocalizedMessage());
			con1.rollback();
			DBStatus = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con1 != null) {
				con1.close();
				Cancel();
			}
		}
	}

	private void viewData(JTable table) throws ClassNotFoundException, SQLException {
		table = table;
		// model.setColumnIdentifiers(custCol);
		// new gnTable().RemoveTableRows(model);
		// table.setModel(model);
		new gnTable().setTablewidth(table, 2, 300);
		new gnTable().setTablewidth(table, 1, 100);
		new gnTable().setTablewidth(table, 0, 5);
		table.setEnabled(true);
		table.setGridColor(Color.gray);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.blue);
		table.setAutoCreateRowSorter(true);
		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.CYAN);
		prt1.add(table, custCol);
		prt1.setVisible(true);
		jsp.setViewport(prt1);
		new gnFontSetting().setMyFont(table, "F2", 12);
		table.requestFocusInWindow();
		table.requestFocus();
		selectRow();
	}
}// Last

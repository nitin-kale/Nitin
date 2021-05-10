package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.CompoundBorder;
import com.toedter.calendar.JDateChooser;

public class Company_Master extends getResultSet {
	public JFrame CompanyFrame;

	private JLabel lblDate;
	private JLabel lblDefaultCurrency;
	JDateChooser dateChooser;
	JPanel licpanel;
	private JTextField vatdate;
	private JLabel lblDefaultLanguage;
	String vlickey;

	JButton btnCreate;
	private JComboBox comboLang;
	JComboBox taxscheme;
	JComboBox invformat;
	String schemeType;
	JPanel panel;
	JPanel fert_Panel;
	private JTextField hno;
	private JTextField hname;
	private JTextField name;
	private JTextField compcode;
	private JTextField vatno;
	private JTextField email;
	private JTextField lic1;
	private JTextField lic2;
	private JTextField addr1;
	private JTextField addr2;
	private JTextField addr3;
	private JTextField addr4;
	private JFormattedTextField phone;
	private JFormattedTextField pincode;
	private JFormattedTextField fax;
	private JTextField citycode;
	private JTextField cityname;
	private JTextField statecode;
	private JTextField statename;
	private JTextField countrycode;
	private JTextField countryname;
	private JTextField seg_code;
	private JTextField vert_code;
	private JTextField segmentname;
	private JTextField verticlename;
	JCheckBox regdealer;
	// ==
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnCancel;

	// ===
	public JScrollPane jsp;
	public JTable table = new JTable();
	public DefaultTableModel model = new DefaultTableModel();
	// public String Col[] = { "Type", " code" , "Name" , "Reg.Number", "Phone"
	// , "Verticle"} ;
	public String Col[] = { "Type", " code", "Name" };
	private JTextField turnover;
	private JTextField inslicno;
	private JTextField seedlicno;
	private JTextField fertlicno;
	private JTextField mylickey;
	private JButton btnK;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						Company_Master window;
						window = new Company_Master();
						window.CompanyFrame.setVisible(true);
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (Exception e) {
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
	public Company_Master() throws Throwable {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		CompanyFrame = new JFrame();
		// CompanyFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(Company_Master.class.getResource("/RetailProduct/mymain.png")));
		CompanyFrame.getContentPane().setForeground(Color.CYAN);
		CompanyFrame.setResizable(false);
		CompanyFrame.setType(Type.POPUP);
		CompanyFrame.setTitle("Business Application");
		CompanyFrame.setBounds(350, 90, 613, 564);
		CompanyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CompanyFrame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.CYAN, null));
		panel.setBounds(0, 0, 595, 531);
		CompanyFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCompanyCode = new JLabel("Company Code");
		lblCompanyCode.setBounds(12, 13, 104, 16);
		panel.add(lblCompanyCode);

		JLabel lblCompanyName = new JLabel("Company Name");
		lblCompanyName.setBounds(12, 38, 90, 16);
		panel.add(lblCompanyName);

		name = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};

		name.setFont(new Font("SansSerif", Font.BOLD, 13));
		name.setBounds(112, 32, 268, 25);
		panel.add(name);
		name.setColumns(10);
		ActionListener con = new Company();
		name.addActionListener(con);

		compcode = new JTextField();
		compcode.setFont(new Font("SansSerif", Font.PLAIN, 13));
		compcode.setBounds(112, 10, 77, 22);
		compcode.setEnabled(false);
		panel.add(compcode);
		compcode.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(12, 260, 595, 231);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnAddress = new JButton("Address");
		btnAddress.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAddress.setEnabled(false);
		btnAddress.setBounds(0, 3, 583, 22);
		panel_1.add(btnAddress);

		JLabel lblPhone = new JLabel("Phone ");
		lblPhone.setBounds(94, 166, 41, 16);
		panel_1.add(lblPhone);
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblFaxNo = new JLabel("Fax No");
		lblFaxNo.setBounds(94, 188, 41, 16);
		panel_1.add(lblFaxNo);

		JLabel lblEmialId = new JLabel("Email");
		lblEmialId.setBounds(94, 206, 41, 16);
		panel_1.add(lblEmialId);
		lblEmialId.setHorizontalAlignment(SwingConstants.RIGHT);

		addr1 = new JTextField();
		addr1.setDocument(new gnSetinputLimit(35));
 		addr1.setBounds(76, 38, 217, 25);
		panel_1.add(addr1);
		addr1.setColumns(10);

		addr2 = new JTextField();
		addr2.setDocument(new gnSetinputLimit(35));
		addr2.setBounds(76, 62, 217, 25);
		panel_1.add(addr2);
		addr2.setColumns(10);

		addr3 = new JTextField();
		addr3.setDocument(new gnSetinputLimit(30));
 		addr3.setBounds(76, 85, 217, 25);
		panel_1.add(addr3);
		addr3.setColumns(10);

		addr4 = new JTextField();
		addr3.setDocument(new gnSetinputLimit(30));
 		addr4.setBounds(76, 107, 217, 25);
		panel_1.add(addr4);
		addr4.setColumns(10);

		pincode = new JFormattedTextField();
		pincode.setBounds(76, 131, 97, 25);
		panel_1.add(pincode);

		JLabel lblPinCode = new JLabel("Pin Code");
		lblPinCode.setBounds(8, 134, 56, 16);
		panel_1.add(lblPinCode);
		lblPinCode.setFont(new Font("SansSerif", Font.PLAIN, 11));
		lblPinCode.setHorizontalAlignment(SwingConstants.RIGHT);

		phone = new JFormattedTextField();
		phone.setBounds(147, 160, 146, 25);
		panel_1.add(phone);
		phone.setFont(new Font("SansSerif", Font.PLAIN, 13));

		fax = new JFormattedTextField();
		fax.setBounds(147, 183, 146, 25);
		panel_1.add(fax);
		fax.setFont(new Font("SansSerif", Font.PLAIN, 13));

		email = new JTextField();
		email.setBounds(147, 206, 146, 25);
		panel_1.add(email);
		email.setFont(new Font("SansSerif", Font.PLAIN, 13));
		email.setColumns(10);

		citycode = new JTextField();
		citycode.setEditable(false);
		citycode.setBounds(360, 38, 41, 25);
		panel_1.add(citycode);
		citycode.setColumns(10);

		cityname = new JTextField();
		cityname.setBounds(403, 38, 168, 25);
		panel_1.add(cityname);
		cityname.setColumns(10);
		ActionListener city = new City();
		cityname.addActionListener(city);

		statecode = new JTextField();
		statecode.setEditable(false);
		statecode.setBounds(360, 62, 41, 25);
		panel_1.add(statecode);
		statecode.setColumns(10);

		statename = new JTextField();
		statename.setBounds(403, 62, 168, 25);
		panel_1.add(statename);
		statename.setColumns(10);
		ActionListener state = new State();
		statename.addActionListener(state);

		countrycode = new JTextField();
		countrycode.setEditable(false);
		countrycode.setBounds(360, 85, 41, 25);
		panel_1.add(countrycode);
		countrycode.setColumns(10);

		JLabel lblCityCode = new JLabel("City code");
		lblCityCode.setBounds(305, 41, 56, 16);
		panel_1.add(lblCityCode);

		JLabel lblStateCode = new JLabel("State Code");
		lblStateCode.setBounds(293, 65, 68, 16);
		panel_1.add(lblStateCode);

		JLabel lblCountry = new JLabel("Country");
		lblCountry.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCountry.setBounds(303, 88, 56, 16);
		panel_1.add(lblCountry);

		countryname = new JTextField();
		countryname.setBounds(403, 85, 168, 25);
		panel_1.add(countryname);
		countryname.setColumns(10);
		ActionListener cnt = new Country();
		countryname.addActionListener(cnt);

		JPanel panel_2 = new JPanel();
		panel_2.setVisible(false);
		panel_2.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_2.setBounds(305, 131, 266, 94);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblSegment = new JLabel("Segment");
		lblSegment.setBounds(10, 13, 56, 16);
		panel_2.add(lblSegment);

		JLabel lblVerticle = new JLabel("Verticle");
		lblVerticle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVerticle.setBounds(10, 33, 56, 16);
		panel_2.add(lblVerticle);

		seg_code = new JTextField();
		seg_code.setEnabled(false);
		seg_code.setText("1");
		seg_code.setBounds(72, 10, 34, 22);
		panel_2.add(seg_code);
		seg_code.setColumns(10);

		vert_code = new JTextField();
		vert_code.setText("1");
		vert_code.setEditable(false);
		vert_code.setBounds(72, 33, 34, 22);
		panel_2.add(vert_code);
		vert_code.setColumns(10);

		segmentname = new JTextField();
		segmentname.setEnabled(false);
		segmentname.setText("Retail");
		segmentname.setBounds(106, 10, 148, 25);
		panel_2.add(segmentname);
		segmentname.setColumns(10);

		verticlename = new JTextField();
		verticlename.setBounds(106, 33, 148, 25);
		panel_2.add(verticlename);
		verticlename.setColumns(10);

		/*
		 * JLabel lblHierarchy = new JLabel("Hierarchy");
		 * lblHierarchy.setBounds(10, 65, 56, 16); panel_2.add(lblHierarchy);
		 * 
		 * hno = new JTextField(); hno.setBackground(Color.WHITE);
		 * hno.setText("1"); hno.setBounds(72, 62, 34, 22); panel_2.add(hno);
		 * hno.setColumns(10);
		 * 
		 * hname = new JTextField(); hname.setBackground(Color.WHITE);
		 * hname.setText(null); hname.setBounds(106, 62, 148, 25);
		 * panel_2.add(hname); hname.setColumns(10);
		 */
		JLabel lblLine = new JLabel("Addr 1");
		lblLine.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblLine.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLine.setBounds(10, 38, 56, 16);
		panel_1.add(lblLine);

		JLabel lblLine_1 = new JLabel("Line 2");
		lblLine_1.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblLine_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLine_1.setBounds(12, 62, 56, 16);
		panel_1.add(lblLine_1);

		JLabel lblLine_2 = new JLabel("Line 3");
		lblLine_2.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblLine_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLine_2.setBounds(12, 85, 56, 16);
		panel_1.add(lblLine_2);

		JLabel lblLine_3 = new JLabel("Line 4");
		lblLine_3.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblLine_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLine_3.setBounds(12, 110, 56, 16);
		panel_1.add(lblLine_3);

		btnCancel = new JButton("Cancel");
		btnCancel.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose1.png"));
		btnCancel.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose.png"));
		btnCancel.setBounds(317, 493, 97, 38);
		panel.add(btnCancel);
		btnCancel.setMnemonic('C');

		btnUpdate = new JButton("Update");
		btnUpdate.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApUpdate1.png"));
		btnUpdate.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApUpdate.png"));
		btnUpdate.setBounds(213, 493, 97, 38);
		panel.add(btnUpdate);
		btnUpdate.setMnemonic('U');
		btnUpdate.setEnabled(false);
		// Dtable.add(jsp);

		btnSave = new JButton("Save");
		btnSave.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApsave1.png"));
		btnSave.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApsave.png"));
		btnSave.setBounds(112, 493, 97, 38);
		panel.add(btnSave);
		btnSave.setMnemonic('S');

		lblDefaultCurrency = new JLabel("Default Currency");
		lblDefaultCurrency.setBounds(392, 13, 113, 16);
		panel.add(lblDefaultCurrency);

		JComboBox comboCurr = new JComboBox();
		comboCurr.setEditable(true);
		comboCurr.setForeground(new Color(0, 0, 204));
		comboCurr.setEnabled(false);
		comboCurr.setModel(new DefaultComboBoxModel(new String[] { "INR" }));
		comboCurr.setBounds(504, 10, 63, 22);
		panel.add(comboCurr);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "GST Details",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 128)));
		panel_3.setBounds(0, 59, 595, 200);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Prv.TurnOver");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel.setBounds(12, 64, 76, 16);
		panel_3.add(lblNewLabel);

		turnover = new JTextField();
		turnover.setText("0");
		turnover.setBounds(80, 59, 137, 25);
		panel_3.add(turnover);
		turnover.setColumns(10);

		taxscheme = new JComboBox();
		taxscheme.setModel(new DefaultComboBoxModel(new String[] { "No Tax", "Composite Scheme", "Regular Scheme" }));
		taxscheme.setBounds(432, 32, 137, 22);
		panel_3.add(taxscheme);
		ActionListener schm = new schemeLsnr();
		taxscheme.addActionListener(schm);

		JLabel lblNewLabel_1 = new JLabel("Scheme");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_1.setBounds(383, 37, 56, 16);
		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Invoice Format");
		lblNewLabel_2.setBounds(0, 96, 120, 16);
		panel_3.add(lblNewLabel_2);

		invformat = new JComboBox();
		invformat.setModel(new DefaultComboBoxModel(new String[] { "Taxable Invocie", "Non Taxable Invoice" }));
		invformat.setBounds(91, 93, 126, 22);
		panel_3.add(invformat);

		JLabel lblLicenceIfAny = new JLabel("GST NO");
		lblLicenceIfAny.setBounds(22, 38, 47, 16);
		panel_3.add(lblLicenceIfAny);
		lblLicenceIfAny.setFont(new Font("Calibri", Font.BOLD, 12));
		// compcode.addActionListener(con);

		vatno = new JTextField();
		vatno.setBounds(80, 34, 137, 25);
		panel_3.add(vatno);
		vatno.setForeground(Color.BLUE);
		vatno.setFont(new Font("SansSerif", Font.PLAIN, 13));
		vatno.setColumns(10);

		lblDate = new JLabel("Date");
		lblDate.setBounds(220, 37, 41, 16);
		panel_3.add(lblDate);
		lblDate.setFont(new Font("Calibri", Font.BOLD, 12));

		vatdate = new JTextField();
		vatdate.setBounds(255, 34, 116, 25);
		panel_3.add(vatdate);
		vatdate.setColumns(10);

		regdealer = new JCheckBox("GST Reg. Company");
		regdealer.setForeground(new Color(0, 0, 0));
		regdealer.setBackground(Color.WHITE);
		regdealer.setSelected(true);
		regdealer.setBounds(12, 10, 144, 25);
		panel_3.add(regdealer);

		fert_Panel = new JPanel();
		fert_Panel.setBounds(239, 70, 367, 130);
		panel_3.add(fert_Panel);
		fert_Panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Insecticides Lic No");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(12, 13, 108, 16);
		fert_Panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Seed Lic. No");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(12, 42, 108, 16);
		fert_Panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Fertilizer Lic No");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(12, 71, 108, 16);
		fert_Panel.add(lblNewLabel_5);

		inslicno = new JTextField();
		inslicno.setBounds(136, 10, 214, 22);
		fert_Panel.add(inslicno);
		inslicno.setColumns(10);

		seedlicno = new JTextField();
		seedlicno.setBounds(136, 39, 218, 22);
		fert_Panel.add(seedlicno);
		seedlicno.setColumns(10);

		fertlicno = new JTextField();
		fertlicno.setBounds(136, 68, 214, 22);
		fert_Panel.add(fertlicno);
		fertlicno.setColumns(10);

		lblDefaultLanguage = new JLabel("Default Language");
		lblDefaultLanguage.setBounds(388, 38, 104, 16);
		panel.add(lblDefaultLanguage);

		comboLang = new JComboBox();
		comboLang.setEditable(true);
		comboLang.setForeground(new Color(0, 0, 204));
		comboLang.setEnabled(false);
		comboLang.setModel(new DefaultComboBoxModel(new String[] { "Eng" }));
		comboLang.setBounds(504, 35, 63, 22);
		panel.add(comboLang);

		btnCreate = new JButton("Create New Company");
		btnCreate.setMnemonic('N');
		btnCreate.setBounds(421, 493, 162, 38);
		panel.add(btnCreate);

		jsp = new JScrollPane();
		jsp.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.ORANGE));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 0, 583, 94);
		ActionListener btn = new Btn();
		btnSave.addActionListener(btn);
		btnCancel.addActionListener(btn);
		btnUpdate.addActionListener(btn);
		btnCreate.addActionListener(btn);

		ActionListener chkbx = new checkBoxLsnr();
		regdealer.addActionListener(chkbx);

		// ActionListener hls = new hierLsnr() ;
		// hname.addActionListener(hls);
		// hno.addActionListener(hls);

		reset();
		setDefault();

	}

	class schemeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int indx = taxscheme.getSelectedIndex();
			switch (indx) {
			case 0:
				schemeType = "0";
				break;
			case 1:
				schemeType = "1";
				break;
			case 2:
				schemeType = "2";
				break;
			}
		}

	}

	class checkBoxLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			setGstSetting();
		}

	}

	void setGstSetting() {
		boolean vgstreg = regdealer.isSelected();
		if (!vgstreg) {
			vatno.setEditable(false);
			vatdate.setEditable(false);
			turnover.setEditable(false);
		}
	}

	private void setDefault() throws Throwable {
		name.setEditable(false);
		btnCreate.setVisible(false);
		switch (ifc) {
		case "N":
			vlickey = "0";
			// licpanel.setVisible(true);
			break;
		case "Y":
			vlickey = "0";
			// licpanel.setVisible(false);
			break;
		}

		inslicno.setText("0");
		seedlicno.setText("0");
		fertlicno.setText("0");
		fert_Panel.setVisible(false);
		String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);

		switch (vverticlecode) {
		case "5":
			fert_Panel.setVisible(true);
		}

		btnCreate.setVisible(false);
		compcode.setEditable(false);
		compcode.setEnabled(false);
		name.setEnabled(false);
		name.setEditable(false);
		btnSave.setVisible(false);
		btnSave.setEnabled(false);
		btnUpdate.setEnabled(true);

		if (myvcomp.trim().equals("9999") & (ucode.trim().equals("ADMIN"))) {
			btnSave.setVisible(false);
			btnCreate.setVisible(true);
		}

		compcode.setText(new gnConfig().getCompanyCode());
		CompanyFrame.setUndecorated(false);

		new gnApp().setFrameTitel(CompanyFrame);
		new gnField().closeform(panel, CompanyFrame);
		String vcomp = compcode.getText();

		new gnStyleButton().getStyleButton(btnCancel, new Color(0, 151, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnSave, new Color(120, 51, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnUpdate, new Color(120, 51, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnCreate, new Color(120, 51, 112), Color.WHITE);
		enable();
		showData(vcomp);

	}

	class Company implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String sql = " ";
			String type = " ";
			String vcomp = " ";
			try {
				vcomp = new gnConfig().getCompanyCode();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
			if (vcomp == "0") {
				type = "Company";
				try {
					new gnAdmin().setcompany(compcode, name);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
			try {
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				type = "Company";
				vcomp = compcode.getText();
				try {
					showData(vcomp);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class Country implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String vcode = "%" + value + "%";
			String type = "Country";
			try {
				vmastersearchString = "%" + countryname.getText() + "%";
				new gnAdmin().showMasterTable(type, countrycode, countryname);
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
		}
	}

	class State implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String vcode = "%" + value + "%";
			String type = "State";
			try {
				vmastersearchString = "%" + statename.getText() + "%";
				new gnAdmin().showMasterTable(type, statecode, statename);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class City implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String type = "City";
			try {
				vmastersearchString = "%" + cityname.getText() + "%";
				new gnAdmin().showMasterTable(type, citycode, cityname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	private void validatehierarchy() {
		if (hno.getText() != vert_code.getText()) {
			new General().msg("Select Correct Hierarchy Which is Matching To Your Verticle");
			hno.setText(null);
			hname.setText(null);
		}
	}

	private void enable() {
		citycode.setEditable(false);
		vatno.setEditable(true);
		turnover.setEditable(true);
		cityname.setEditable(true);
		statecode.setEditable(false);
		countryname.setEditable(true);
		// hno.setEditable(false);
		// hname.setEditable(false);
		name.setEditable(true);
		// segmentname.setEditable(true);
		// seg_code.setEditable(true);
		// vert_code.setEditable(true);
		// verticlename.setEditable(true);
		addr1.setEditable(true);
		addr2.setEditable(true);
		addr3.setEditable(true);
		addr4.setEditable(true);
		pincode.setEditable(true);
		vatno.setEditable(true);
		// lic1.setEditable(true) ;
		// lic2.setEditable(true) ;
		vatdate.setEditable(true);

	}

	class Btn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			if (value == "Cancel") {
				CompanyFrame.dispose();
			}
			if (value == "Update") {
				try {
					UpdateRecord();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Create New Company") {
				String status = new General().checkCompCreatepermission();
				if (status == "Sucess") {
					btnCreate.setVisible(true);
					compcode.setEditable(true);
					compcode.setEnabled(true);
					compcode.setText(null);
					compcode.grabFocus();
					name.setEnabled(true);
					name.setEditable(true);
					btnSave.setVisible(true);
					btnSave.setEnabled(true);
					btnUpdate.setEnabled(false);
					try {
						reset();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			if (value == "Save") {
				try {
					String vstatus = validate();
					if (vstatus == "Sucess") {
						prepareToinsert();
					}
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg("Save :" + e1.getMessage());
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void showData(String value) throws SQLException, ClassNotFoundException {
		String sql1 = "call  Tbl_getAllCompanyData(" + value + ")";
		rs = this.getSPResult(sql1);
		if (rs.next()) {
			compcode.setText(rs.getString(1));
			name.setText(rs.getString(2));
			vatno.setText(rs.getString(3));
			phone.setText(rs.getString(4));
			fax.setText(rs.getString(5));
			email.setText(rs.getString(6));
			addr1.setText(rs.getString(7));
			addr2.setText(rs.getString(8));
			addr3.setText(rs.getString(9));
			addr4.setText(rs.getString(10));
			countrycode.setText(rs.getString(11));
			countrycode.setEnabled(false);
			countryname.setText(rs.getString(12));
			statecode.setText(rs.getString(13));
			statename.setText(rs.getString(14));
			citycode.setText(rs.getString(15));
			cityname.setText(rs.getString(16));
			// seg_code.setText(rs.getString(17)) ;
			// segmentname.setText(rs.getString(18)) ;
			// vert_code.setText(rs.getString(19)) ;
			// verticlename.setText(rs.getString(20)) ;
			pincode.setText(rs.getString(21));
			turnover.setText(rs.getString(22));
			taxscheme.setSelectedIndex(1);
			invformat.setSelectedIndex(1);
			// vatdate.setText(rs.getString(25));
			inslicno.setText(rs.getString(26));
			seedlicno.setText(rs.getString(27));
			fertlicno.setText(rs.getString(28));

			// btnSave.setEnabled(false);
			// btnUpdate.setEnabled(true);

			// hno.setEditable(false);
			// hname.setEditable(false);
			citycode.setEditable(false);
			cityname.setEditable(false);
			statecode.setEditable(false);
			countryname.setEditable(false);
			statename.setEditable(false);
			// seg_code.setEditable(false);
			name.setEditable(true);
			// segmentname.setEditable(true);
			vatdate.setEditable(false);
			// vert_code.setEditable(true);
			// verticlename.setEditable(true);
			addr1.setEditable(true);
			addr2.setEditable(true);
			addr3.setEditable(true);
			addr4.setEditable(true);
			pincode.setEditable(true);
			vatno.setEditable(true);
		} else {
			new General().msg("No Data Found...");
		}
	}

	public String UpdateRecord() throws Throwable {

		String vtaxschm = "";
		vtaxschm = taxscheme.getSelectedItem().toString();
		switch (vtaxschm) {
		// "No Tax", "Composite Scheme", "Regular Scheme"
		case "No Tax":
			vtaxschm = "0";
			break;
		case "Composite Scheme":
			vtaxschm = "1";
			break;
		case "Regular Scheme":
			vtaxschm = "2";
			break;
		}
		String vgst = "";
		boolean vregdlr = regdealer.isSelected();
		if (vregdlr) {
			vgst = "Y";
		} else {
			vgst = "N";
		}

		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		// this.closeconn();
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String company = "Update   ms_company_master  set  "
				+ " Phone =?,   Fax= ? ,  email=?   , taxScheme = ? , addr1 = ? , addr2 = ? , addr3 = ? , addr4= ? ,"
				+ "taxscheme = ? , GstRegistered = ? , GSTNO = ? ,  state = ? , statename = ? , city =?,  verticle = ? , verticle_name = ? ,"
				+ "instlicno = ? , seedlicno = ? , fertlicno = ?" + "where company_code = ? ";
		try {
			prst = con.prepareStatement(company);
			prst.setString(1, phone.getText());
			prst.setString(2, fax.getText());
			prst.setString(3, email.getText());
			prst.setString(4, schemeType);
			prst.setString(5, addr1.getText());
			prst.setString(6, addr2.getText());
			prst.setString(7, addr3.getText());
			prst.setString(8, addr4.getText());
			prst.setString(9, vtaxschm);
			prst.setString(10, vgst);
			prst.setString(11, vatno.getText());
			prst.setString(12, statecode.getText());
			prst.setString(13, statename.getText());
			prst.setString(14, citycode.getText());
			prst.setString(15, "0");
			prst.setString(16, "No Verticle");
			prst.setString(17, inslicno.getText());
			prst.setString(18, seedlicno.getText());
			prst.setString(19, fertlicno.getText());
			prst.setString(20, compcode.getText());
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con.commit();
				new General().msg("Data Updated Sucessfully");
			}
			prst.executeBatch();
			con.commit();
			new General().msg("Data Updated Sucessfully");
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
			reset();
			enable();
			btnSave.setEnabled(true);
			btnUpdate.setEnabled(false);
		}
		return status;
	}

	private String validate() {
		String status = "Sucess";
		vlickey = "0";

		/*
		 * if (ifc == "N") { String vlickey1 = mylickey.getText(); if
		 * (vlickey1.length() == 0) { new General().msg(
		 * "Enter Valid Product Key  ..") ; mylickey.grabFocus(); status =
		 * "Fail"; } String vcomp = compcode.getText(); vlickey = vlickey1 ;
		 * //status = new General().getValidateKeyParameter(vlickey1, vcomp);
		 * //vlickey = new General().convertPassword(vlickey1); }
		 */

		if (name.getText().length() == 0) {
			new General().msg("Enter Company Name  ..");
			name.grabFocus();
			status = "Fail";
		}

		boolean vregdlr = regdealer.isSelected();
		if (vregdlr & vatno.getText().length() == 0) {
			new General().msg("Please Enter  Reg, Details ..");
			vatno.grabFocus();
			status = "Fail";
		}

		if (addr1.getText().length() == 0) {
			new General().msg("Select Address 1 Information..");
			addr1.grabFocus();
			status = "Fail";
		}

		if (addr2.getText().length() == 0) {
			new General().msg("Select Address 2  Information..");
			addr2.grabFocus();
			status = "Fail";
		}

		if (addr3.getText().length() == 0) {
			new General().msg("Select Address 3  Information..");
			addr3.grabFocus();
			status = "Fail";
		}

		if (addr4.getText().length() == 0) {
			new General().msg("Select Address  4 Information..");
			addr4.grabFocus();
			status = "Fail";
		}

		if (statecode.getText().length() == 0) {
			new General().msg("Select State Information..");
			statename.grabFocus();
			status = "Fail";
		}
		if (citycode.getText().length() == 0) {
			new General().msg("Select city Information..");
			cityname.grabFocus();
			status = "Fail";
		}

		if (countrycode.getText().length() == 0) {
			new General().msg("Select country Information..");
			countryname.grabFocus();
			status = "Fail";
		}
		return status;
	}

	public String prepareToinsert() throws Throwable {
		String vtaxschm = "";
		vtaxschm = taxscheme.getSelectedItem().toString();
		switch (vtaxschm) {
		// "No Tax", "Composite Scheme", "Regular Scheme"
		case "No Tax":
			vtaxschm = "0";
			break;
		case "Composite Scheme":
			vtaxschm = "1";
			break;
		case "Regular Scheme":
			vtaxschm = "2";
			break;
		}
		String vgst = "";
		boolean vregdlr = regdealer.isSelected();
		if (vregdlr) {
			vgst = "Y";
		} else {
			vgst = "N";
		}
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String company = "INSERT INTO  ms_company_master ( Group_comp_code , "
				+ "company_code , Company_Name , GSTNO ,    Phone ,   Fax ,"
				+ "Email  ,  Addr1 ,   Addr2 ,    Addr3 ,  Addr4 ,     Country ,"
				+ "Region ,   State , City , Default_Currency ,  Segment ,"
				+ "Verticle ,   Pincode , DefaultLanguage, GSTdate , hno, hname, " + "verticle_name, segment_name, "
				+ "turnover, taxscheme, invoiceType, GstRegistered, statename, instLicno , seedlicno, fertlicno, lickey ) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
		try {
			prst = con.prepareStatement(company);
			prst.setString(1, "0");
			prst.setString(2, compcode.getText());
			prst.setString(3, name.getText());
			prst.setString(4, vatno.getText());
			prst.setString(5, phone.getText());
			prst.setString(6, fax.getText());
			prst.setString(7, email.getText());
			prst.setString(8, addr1.getText());
			prst.setString(9, addr2.getText());
			prst.setString(10, addr3.getText());
			prst.setString(11, addr4.getText());
			prst.setString(12, countrycode.getText());
			prst.setString(13, "0");
			prst.setString(14, statecode.getText());
			prst.setString(15, citycode.getText());
			prst.setString(16, "INR");
			prst.setString(17, "1");
			prst.setString(18, "0");
			prst.setString(19, pincode.getText());
			prst.setString(20, "ENG");
			prst.setString(21, new gnConfig().date_ConverttoDBforamt(vatdate.getText()));
			prst.setString(22, "0");
			prst.setString(23, "No Hierarchy");
			prst.setString(24, "No Verticle");
			prst.setString(25, "Retail");
			prst.setString(26, turnover.getText());
			prst.setString(27, vtaxschm);
			prst.setString(28, invformat.getSelectedItem().toString());
			prst.setString(29, vgst);
			prst.setString(30, statename.getText());
			prst.setString(31, inslicno.getText());
			prst.setString(32, seedlicno.getText());
			prst.setString(33, fertlicno.getText());
			prst.setString(34, vlickey);
 			prst.addBatch();
 			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con.commit();
			}
			prst.executeBatch();
			con.commit();

		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con.rollback();
			status = "Fail";
		} finally {
			if (status == "Sucess") {
				new General().msg("Data Saved Sucessfully");

				if (SiteAutomationActivate == "Y") {
					procesAutoEntryMethod();
				}
			}
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
			}

		}
		return status;
	}
	// Insert defalt Site

	private void procesAutoEntryMethod() throws Throwable {
		insertSite();
		new gnSiteAutomation().doOtherAutomationActivity(compcode.getText(), compcode.getText(), name.getText());
		reset();
		CompanyFrame.dispose();
	}

	public void insertDefaultCustomer() throws Throwable {
		new General().msg("<==Creating Default Customer Record ==>");
		String DBStatus = "";
		String vcomp = compcode.getText();
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String poshdr = "Insert into ms_customer_master(Company_code , Code, "
				+ "Name,  Site_code, verticle, IsSupplier , reg_delear , Scheme, state, state_name, city, city_name)"
				+ "values(?,?,?,?,?, ?,?,?, ?,?,?,?)";
		try {
			prst = con1.prepareStatement(poshdr);
			prst.setString(1, vcomp);
			prst.setString(2, "0");
			prst.setString(3, "Default Customer");
			prst.setString(4, vcomp);
			prst.setString(5, "1");
			prst.setString(6, "N");
			prst.setString(7, "N");
			prst.setString(8, "0");
			prst.setString(9, statecode.getText());
			prst.setString(10, statename.getText());
			prst.setString(11, citycode.getText());
			prst.setString(12, cityname.getText());
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
			new General().msg("DEfault Data Saved Sucessfully ..");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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

	private void insertNumSeq() throws Throwable {
		String vcomp = compcode.getText();
		String vstore = compcode.getText();
		String vstartDate = new gnFinYear().getFirstDateofFinYear();
		String vendDate = new gnFinYear().getLastDateofFinYear();
		String SQL7 = "call num_updateNewStore(" + vcomp + ", " + vstore + ",  '" + vstartDate + "' ,  '" + vendDate
				+ "')";
		this.getSPResult(SQL7);
		String SQL9 = "call   num_InsertNewStore(" + vcomp + ", " + vstore + ")";
		this.getSPResult(SQL9);
	}

	private void insertConfig() throws ClassNotFoundException, SQLException {
		new General().msg("Creating Default Configuration For  This Company --> Branch");
		String vcomp = compcode.getText();
		String SQL = "call  conf_addConfigDetails(" + vcomp + ", " + vcomp + ")";
		this.getSPResult(SQL);
	}

	private String insertSite() throws SQLException, ClassNotFoundException, IOException {
		new General().msg("Creating New Site For This Company..");
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		// this.closeconn();
		String status = "Fail";
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String company = "INSERT INTO  ms_site_master  (  Company_Code  , "
				+ "Site_code  , Name  , Add_Line1  , Add_Line2  , Add_Line3  , Add_Line4  ,"
				+ " Phone_No_1  , Phone_NO_2  , Country  ,State  ,City  , Area  ,LandMark  ,"
				+ " Fax_Number  , Email_ID  , VAT_NO  ,Regs_No  ,Format  ,Class  ,Type  ,"
				+ "Segment  , Verticle  , B2BSalesAllow  , NegativeInvAllow  , Openiing_Date  ,"
				+ " DailyOpentime  ,DailyClosetime  , Pincode  , mySite  ," + " DefaultCurrency , city_name , lickey)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con1.prepareStatement(company);
			prst.setString(1, compcode.getText());
			prst.setString(2, compcode.getText());
			prst.setString(3, name.getText());
			prst.setString(4, addr1.getText());
			prst.setString(5, addr2.getText());
			prst.setString(6, addr3.getText());
			prst.setString(7, addr4.getText());
			prst.setString(8, phone.getText());
			prst.setString(9, phone.getText());
			prst.setString(10, countrycode.getText());
			prst.setString(11, statecode.getText());
			prst.setString(12, citycode.getText());
			prst.setString(13, "");
			prst.setString(14, "");
			prst.setString(15, fax.getText());
			prst.setString(16, email.getText());
			prst.setString(17, vatno.getText());
			prst.setString(18, vatno.getText());
			prst.setString(19, "2");
			prst.setString(20, "B");
			prst.setString(21, "2");
			prst.setString(22, "1");
			prst.setString(23, vert_code.getText());

			// String vb2b = allowb2b.getSelectedItem().toString() ;
			// new General().msg( vb2b);
			// prst.setString(24, vb2b ) ;
			prst.setString(24, "Y");

			// String vallowneg = allownegative.getSelectedItem().toString();
			// new General().msg( vallowneg );
			prst.setString(25, "Y");

			prst.setString(26, "0000.00.00");
			prst.setString(27, "08AM");
			prst.setString(28, "09PM");
			prst.setString(29, pincode.getText());

			// String vmydefault = mydefault.getSelectedItem().toString();
			// new General().msg( vmydefault );
			prst.setString(30, "N");
			prst.setString(31, "INR");
			prst.setString(32, cityname.getText());
			prst.setString(33, vlickey);

			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con1.commit();
			}
			prst.executeBatch();
			con1.commit();
			//new General().Quickmsg("Data Saved Sucessfully" + "Store code " + compcode.getText());
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con1.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con1 != null) {
				con1.close();
			}
		}
		return status;
	}
	//

	private void reset() throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		if (vcomp == "0") {
			compcode.setText(null);
		}
		name.setText(null);
		vatno.setText("0");
		vatdate.setText(null);
		verticlename.setText("Retail");
		phone.setText("0");
		fax.setText("0");
		email.setText(" ");
		addr1.setText(null);
		inslicno.setText("0");
		seedlicno.setText("0");
		fertlicno.setText("0");

		addr2.setText(" ");
		addr3.setText(" ");
		addr4.setText(" ");
		countrycode.setText(" ");
		countryname.setText(" ");
		statecode.setText("0");
		statename.setText(" ");
		citycode.setText("0");
		cityname.setText(" ");
		pincode.setText("0");

	}
}// Last

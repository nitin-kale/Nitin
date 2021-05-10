package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;

public class Site_Master extends getResultSet {

	JFrame SiteFrame;

	private JComboBox allownegative;
	private JComboBox allowb2b;
	JLabel comptypelbl;
	private JComboBox mydefault;
	JPanel MiddlePanel;
	JPanel RightPanel;
	private JTextField opdate;
	private JTextField companyname;
	private JTextField hno;
	private JTextField hname;

	JPanel hpanel;

	private JTextField sitecode;
	private JTextField name;
	private JTextField vatno;
	private JTextField regno;
	private JTextField addr1;
	private JTextField addr2;
	private JTextField addr3;
	private JTextField addr4;
	private JTextField email;
	private JTextField landmark;
	private JTextField area;

	public JComboBox comboCompany;
	private JTextField compcode;
	private JTextField countrycode;
	private JTextField countryname;
	private JTextField statecode;
	private JTextField statename;
	private JTextField citycode;
	private JTextField cityname;
	private JTextField segmentcode;
	private JTextField segmentname;
	private JTextField verticlecode;
	private JTextField verticlename;
	private JTextField typecode;
	private JTextField typename;
	private JTextField formatcode;
	private JTextField formatname;
	private JTextField classcode;
	private JTextField classname;
	private JTextField phone1;
	private JTextField phone2;
	private JTextField fax;
	private JTextField pincode;
	private JTextField currencycode;
	private JTextField currencyname;
	private JTextField optime;
	private JTextField cltime;

	// ==
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnUpdate;
	JPanel SidePanel;
	// ===
	public JScrollPane jsp;
	public JTable table = new JTable();
	public DefaultTableModel model = new DefaultTableModel();
	public String Col[] = { "Type", " Code", "Name" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Site_Master window = new Site_Master();
					window.SiteFrame.setVisible(true);
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
	public Site_Master() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		SiteFrame = new JFrame();
		SiteFrame.getContentPane().setBackground(Color.CYAN);
		SiteFrame.setResizable(false);
		SiteFrame.setType(Type.UTILITY);
		SiteFrame.setTitle("Business Application ");
		SiteFrame.setBounds(275, 90, 674, 546);
		SiteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SiteFrame.getContentPane().setLayout(null);
		ActionListener st = new site();

		SidePanel = new JPanel();
		SidePanel.setBackground(Color.WHITE);
		SidePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		SidePanel.setBounds(0, 130, 168, 168);
		SiteFrame.getContentPane().add(SidePanel);
		SidePanel.setLayout(null);

		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCountry.setBounds(42, 31, 99, 16);
		SidePanel.add(lblCountry);

		JLabel lblState = new JLabel("State");
		lblState.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblState.setBounds(45, 79, 96, 16);
		SidePanel.add(lblState);

		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCity.setBounds(45, 128, 109, 16);
		SidePanel.add(lblCity);

		countrycode = new JTextField();
		countrycode.setText("IND");
		countrycode.setForeground(SystemColor.desktop);
		countrycode.setFont(new Font("Calibri", Font.BOLD, 13));
		countrycode.setEditable(false);
		countrycode.setBounds(7, 28, 30, 22);
		SidePanel.add(countrycode);
		countrycode.setColumns(10);

		countryname = new JTextField();
		countryname.setText("India");
		countryname.setToolTipText("Press enter to select data.");
		countryname.setForeground(SystemColor.desktop);
		countryname.setFont(new Font("Calibri", Font.BOLD, 13));
		countryname.setBounds(7, 52, 147, 22);
		SidePanel.add(countryname);
		countryname.setColumns(10);
		ActionListener cntr = new Country();
		countryname.addActionListener(cntr);

		statecode = new JTextField();
		statecode.setForeground(SystemColor.desktop);
		statecode.setFont(new Font("Calibri", Font.BOLD, 13));
		statecode.setEditable(false);
		statecode.setBounds(7, 76, 35, 22);
		SidePanel.add(statecode);
		statecode.setColumns(10);

		statename = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		statename.setToolTipText("Press enter to select data.");
		statename.setForeground(SystemColor.desktop);
		statename.setFont(new Font("Calibri", Font.BOLD, 13));
		statename.setBounds(7, 99, 150, 22);
		SidePanel.add(statename);
		statename.setColumns(10);
		ActionListener state = new State();
		statename.addActionListener(state);

		citycode = new JTextField();
		citycode.setForeground(SystemColor.desktop);
		citycode.setFont(new Font("Calibri", Font.BOLD, 13));
		citycode.setEditable(false);
		citycode.setBounds(7, 125, 35, 22);
		SidePanel.add(citycode);
		citycode.setColumns(10);

		cityname = new JTextField();
		cityname.setToolTipText("Press enter to select data.");
		cityname.setForeground(SystemColor.desktop);
		cityname.setFont(new Font("Calibri", Font.BOLD, 13));
		cityname.setBounds(7, 146, 147, 22);
		SidePanel.add(cityname);
		cityname.setColumns(10);
		SidePanel.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { countrycode, countryname, statecode, statename, citycode, cityname }));
		ActionListener city = new City();
		cityname.addActionListener(city);

		MiddlePanel = new JPanel();
		MiddlePanel.setBackground(Color.WHITE);
		MiddlePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		MiddlePanel.setBounds(169, 128, 216, 170);
		SiteFrame.getContentPane().add(MiddlePanel);
		MiddlePanel.setLayout(null);

		addr1 = new JTextField();
		addr1.setForeground(SystemColor.desktop);
		addr1.setDocument(new gnSetinputLimit(20));
		addr1.setFont(new Font("Calibri", Font.BOLD, 13));
		addr1.setBounds(12, 41, 185, 22);
		MiddlePanel.add(addr1);
		addr1.setColumns(10);
		addr1.setToolTipText("Max Char Limit is 20 ");

		addr2 = new JTextField();
		addr2.setForeground(SystemColor.desktop);
		addr2.setToolTipText("Max Char Limit is 20 ");
		addr2.setDocument(new gnSetinputLimit(20));
		addr2.setFont(new Font("Calibri", Font.BOLD, 13));
		addr2.setBounds(12, 64, 185, 22);
		MiddlePanel.add(addr2);
		addr2.setColumns(10);

		addr3 = new JTextField();
		addr3.setForeground(SystemColor.desktop);
		addr3.setToolTipText("Max Char Limit is 20 ");
		addr3.setFont(new Font("Calibri", Font.BOLD, 13));
		addr3.setDocument(new gnSetinputLimit(20));
		addr3.setBounds(12, 89, 185, 22);
		MiddlePanel.add(addr3);
		addr3.setColumns(10);

		addr4 = new JTextField();
		addr4.setForeground(SystemColor.desktop);
		addr4.setToolTipText("Max Char Limit is 20 ");
		addr4.setDocument(new gnSetinputLimit(20));
		addr4.setFont(new Font("Calibri", Font.BOLD, 13));
		addr4.setBounds(12, 112, 185, 22);
		MiddlePanel.add(addr4);
		addr4.setColumns(10);

		JLabel lblPincode = new JLabel("PinCode");
		lblPincode.setBounds(60, 137, 56, 16);
		MiddlePanel.add(lblPincode);

		JButton btnAddress = new JButton("Address");
		btnAddress.setForeground(Color.BLACK);
		btnAddress.setBackground(Color.CYAN);
		btnAddress.setBounds(0, 0, 225, 16);
		MiddlePanel.add(btnAddress);
		btnAddress.setEnabled(false);

		pincode = new JTextField();
		pincode.setForeground(SystemColor.desktop);
		pincode.setFont(new Font("Calibri", Font.BOLD, 13));
		pincode.setBounds(109, 134, 86, 22);
		MiddlePanel.add(pincode);
		pincode.setColumns(10);
		MiddlePanel.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { addr1, addr2, addr3, addr4, pincode }));

		RightPanel = new JPanel();
		RightPanel.setBackground(Color.WHITE);
		RightPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		RightPanel.setBounds(386, 128, 282, 174);
		SiteFrame.getContentPane().add(RightPanel);
		RightPanel.setLayout(null);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblEmail.setBounds(12, 68, 39, 16);
		RightPanel.add(lblEmail);

		email = new JTextField();
		email.setForeground(SystemColor.desktop);
		email.setFont(new Font("Calibri", Font.BOLD, 13));
		email.setBounds(55, 65, 211, 22);
		RightPanel.add(email);
		email.setColumns(10);

		JLabel lblPhone = new JLabel("Mobile");
		lblPhone.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(12, 22, 39, 16);
		RightPanel.add(lblPhone);

		JLabel lblPhone_1 = new JLabel("Phone ");
		lblPhone_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone_1.setFont(new Font("SansSerif", Font.PLAIN, 12));
		lblPhone_1.setBounds(12, 46, 39, 16);
		RightPanel.add(lblPhone_1);

		JLabel lblLandMark = new JLabel("Land Mark");
		lblLandMark.setForeground(SystemColor.textHighlight);
		lblLandMark.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblLandMark.setHorizontalAlignment(SwingConstants.CENTER);
		lblLandMark.setBounds(55, 84, 199, 16);
		RightPanel.add(lblLandMark);

		landmark = new JTextField();
		landmark.setForeground(SystemColor.desktop);
		landmark.setFont(new Font("Calibri", Font.BOLD, 13));
		landmark.setBounds(55, 100, 211, 22);
		RightPanel.add(landmark);
		landmark.setColumns(10);

		JLabel lblArea = new JLabel("Area");
		lblArea.setBackground(Color.WHITE);
		lblArea.setForeground(Color.BLACK);
		lblArea.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblArea.setHorizontalAlignment(SwingConstants.CENTER);
		lblArea.setBounds(55, 120, 211, 16);
		RightPanel.add(lblArea);

		area = new JTextField();
		area.setForeground(SystemColor.desktop);
		area.setFont(new Font("Calibri", Font.BOLD, 13));
		area.setBounds(55, 135, 211, 22);
		RightPanel.add(area);
		area.setColumns(10);

		phone1 = new JTextField();
		phone1.setForeground(SystemColor.desktop);
		phone1.setFont(new Font("Calibri", Font.BOLD, 13));
		phone1.setBounds(55, 18, 116, 22);
		RightPanel.add(phone1);
		phone1.setColumns(10);

		phone2 = new JTextField();
		phone2.setForeground(SystemColor.desktop);
		phone2.setFont(new Font("Calibri", Font.BOLD, 13));
		phone2.setBounds(55, 41, 116, 22);
		RightPanel.add(phone2);
		phone2.setColumns(10);

		JLabel lblFax = new JLabel("Fax");
		lblFax.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFax.setBounds(171, 46, 31, 16);
		RightPanel.add(lblFax);

		fax = new JTextField();
		fax.setForeground(SystemColor.desktop);
		fax.setFont(new Font("Calibri", Font.BOLD, 13));
		fax.setBounds(204, 43, 62, 22);
		RightPanel.add(fax);
		fax.setColumns(10);

		JPanel Botm_Panel = new JPanel();
		Botm_Panel.setBackground(Color.CYAN);
		Botm_Panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		Botm_Panel.setBounds(0, 300, 668, 156);
		SiteFrame.getContentPane().add(Botm_Panel);
		Botm_Panel.setLayout(null);

		JLabel lblSegment = new JLabel("Segment");
		lblSegment.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSegment.setBounds(10, 17, 63, 16);
		Botm_Panel.add(lblSegment);
		lblSegment.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblVerticle = new JLabel("Verticle");
		lblVerticle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVerticle.setBounds(4, 40, 69, 16);
		Botm_Panel.add(lblVerticle);
		lblVerticle.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblSiteType = new JLabel("Site Type");
		lblSiteType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSiteType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSiteType.setBounds(4, 105, 69, 16);
		Botm_Panel.add(lblSiteType);

		JLabel lblSiteClass = new JLabel("Site Class");
		lblSiteClass.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSiteClass.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSiteClass.setBounds(-2, 85, 75, 16);
		Botm_Panel.add(lblSiteClass);

		JLabel lblFormat = new JLabel("Format");
		lblFormat.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFormat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFormat.setBounds(25, 126, 48, 16);
		Botm_Panel.add(lblFormat);

		segmentcode = new JTextField();
		segmentcode.setEditable(false);
		segmentcode.setBounds(83, 14, 43, 22);
		Botm_Panel.add(segmentcode);
		segmentcode.setColumns(10);

		segmentname = new JTextField();
		segmentname.setToolTipText("Press enter to select data");
		segmentname.setBounds(126, 15, 147, 22);
		Botm_Panel.add(segmentname);
		segmentname.setColumns(10);
		ActionListener seg = new Segment();
		segmentname.addActionListener(seg);

		verticlecode = new JTextField();
		verticlecode.setEditable(false);
		verticlecode.setBounds(83, 38, 43, 22);
		Botm_Panel.add(verticlecode);
		verticlecode.setColumns(10);

		verticlename = new JTextField();
		verticlename.setBounds(126, 38, 147, 22);
		Botm_Panel.add(verticlename);
		verticlename.setColumns(10);
		ActionListener vert = new Verticle();
		verticlename.addActionListener(vert);

		typecode = new JTextField();
		typecode.setEditable(false);
		typecode.setBounds(83, 103, 43, 22);
		Botm_Panel.add(typecode);
		typecode.setColumns(10);

		typename = new JTextField();
		typename.setToolTipText("Press enter to select data.");
		typename.setBounds(126, 103, 147, 22);
		Botm_Panel.add(typename);
		typename.setColumns(10);
		ActionListener type = new SType();
		typename.addActionListener(type);

		formatcode = new JTextField();
		formatcode.setEditable(false);
		formatcode.setBounds(83, 125, 43, 22);
		Botm_Panel.add(formatcode);
		formatcode.setColumns(10);

		formatname = new JTextField();
		formatname.setToolTipText("Press enter to select data.");
		formatname.setBounds(126, 125, 147, 22);
		Botm_Panel.add(formatname);
		formatname.setColumns(10);
		ActionListener fmt = new Format();
		formatname.addActionListener(fmt);

		classcode = new JTextField();
		classcode.setEditable(false);
		classcode.setBounds(83, 82, 43, 22);
		Botm_Panel.add(classcode);
		classcode.setColumns(10);

		classname = new JTextField();
		classname.setToolTipText("Press enter to select data.");
		classname.setBounds(126, 82, 147, 22);
		Botm_Panel.add(classname);
		classname.setColumns(10);
		ActionListener cls = new SClass();
		classname.addActionListener(cls);

		allowb2b = new JComboBox();
		allowb2b.setBounds(389, 38, 50, 22);
		Botm_Panel.add(allowb2b);
		allowb2b.setModel(new DefaultComboBoxModel(new String[] { "No", "Yes" }));
		allowb2b.setFont(new Font("Tahoma", Font.BOLD, 11));
		allowb2b.setVisible(false);

		allownegative = new JComboBox();
		allownegative.setBounds(389, 21, 50, 22);
		Botm_Panel.add(allownegative);
		allownegative.setModel(new DefaultComboBoxModel(new String[] { "No", "Yes" }));
		allownegative.setVisible(false);

		JLabel lblDefaultCurrency = new JLabel(" Currency");
		lblDefaultCurrency.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDefaultCurrency.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDefaultCurrency.setBounds(-2, 64, 75, 16);
		Botm_Panel.add(lblDefaultCurrency);

		currencycode = new JTextField();
		currencycode.setEditable(false);
		currencycode.setBounds(83, 61, 43, 22);
		Botm_Panel.add(currencycode);
		currencycode.setColumns(10);

		currencyname = new JTextField();
		currencyname.setToolTipText("Press enter to select data.");
		currencyname.setBounds(126, 61, 147, 22);
		Botm_Panel.add(currencyname);
		currencyname.setColumns(10);
		ActionListener cur = new Currency();
		currencyname.addActionListener(cur);

		mydefault = new JComboBox();
		mydefault.setModel(new DefaultComboBoxModel(new String[] { "Y", "N" }));
		mydefault.setBounds(389, 58, 50, 22);
		Botm_Panel.add(mydefault);
		mydefault.setVisible(false);

		JLabel lblNewLabel = new JLabel("Hiearchy");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(307, 96, 89, 16);
		Botm_Panel.add(lblNewLabel);
		// lblNewLabel.setVisible(false);

		hno = new JTextField();
		// hno.setEditable(false);
		hno.setBounds(400, 93, 62, 22);
		Botm_Panel.add(hno);
		hno.setColumns(10);
		// hno.setVisible(false);

		JLabel lblNewLabel_1 = new JLabel("Hierarchy Name");
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(266, 123, 130, 16);
		Botm_Panel.add(lblNewLabel_1);
		// lblNewLabel_1.setVisible(false);

		hname = new JTextField();
		hname.setToolTipText("Press enter to select data.");
		// hname.setEditable(false);
		hname.setBounds(400, 120, 147, 22);
		Botm_Panel.add(hname);
		hname.setColumns(10);

		JLabel lblOpeingDate = new JLabel("Opeing Date");
		lblOpeingDate.setBounds(459, 17, 97, 16);
		Botm_Panel.add(lblOpeingDate);
		lblOpeingDate.setForeground(Color.BLACK);
		lblOpeingDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOpeingDate.setHorizontalAlignment(SwingConstants.RIGHT);

		opdate = new JTextField();
		opdate.setBounds(567, 17, 89, 22);
		Botm_Panel.add(opdate);
		opdate.setBackground(new Color(0, 0, 51));
		opdate.setFont(new Font("Calibri", Font.BOLD, 12));
		opdate.setForeground(new Color(51, 255, 102));
		opdate.setColumns(10);

		JLabel lblDailyOpTime = new JLabel("Op.Time");
		lblDailyOpTime.setBounds(459, 41, 97, 16);
		Botm_Panel.add(lblDailyOpTime);
		lblDailyOpTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDailyOpTime.setForeground(Color.BLACK);
		lblDailyOpTime.setFont(new Font("Tahoma", Font.PLAIN, 12));

		optime = new JTextField();
		optime.setBounds(568, 40, 88, 22);
		Botm_Panel.add(optime);
		optime.setFont(new Font("Calibri", Font.BOLD, 12));
		optime.setForeground(new Color(51, 255, 102));
		optime.setText("8 AM");
		optime.setBackground(new Color(0, 0, 51));
		optime.setColumns(10);

		JLabel lblDailyClosingTime = new JLabel("Closing Time");
		lblDailyClosingTime.setBounds(459, 65, 97, 16);
		Botm_Panel.add(lblDailyClosingTime);
		lblDailyClosingTime.setForeground(Color.BLACK);
		lblDailyClosingTime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDailyClosingTime.setHorizontalAlignment(SwingConstants.RIGHT);

		cltime = new JTextField();
		cltime.setBounds(568, 60, 88, 22);
		Botm_Panel.add(cltime);
		cltime.setFont(new Font("Calibri", Font.BOLD, 12));
		cltime.setForeground(new Color(51, 255, 102));
		cltime.setText("10 PM");
		cltime.setBackground(new Color(0, 0, 51));
		cltime.setColumns(10);
		// hname.setVisible(false);
		ActionListener bt = new Btn();
		// String vcomp = (new gnConfig().getCompanyCode());
		// new General().msg(vcomp);
		// if (vcomp != "Fail")
		// {
		// compcode.setText(vcomp) ;
		// }
		// switch(vcomp)
		// {
		// case "Fail" :
		// System.exit(0);
		// break;
		// }
		JPanel Dpanel = new JPanel();
		Dpanel.setBounds(0, 457, 668, 131);
		SiteFrame.getContentPane().add(Dpanel);
		Dpanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 668, 47);
		Dpanel.add(panel);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), null));
		panel.setLayout(null);

		btnSave = new JButton("Save");
		btnSave.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApsave.png"));
		btnSave.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApsave1.png"));
		btnSave.setBounds(195, 9, 97, 30);
		panel.add(btnSave);
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(Color.CYAN);
		btnSave.setMnemonic('S');

		btnUpdate = new JButton("Update");
		btnUpdate.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApUpdate1.png"));
		btnUpdate.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApUpdate.png"));
		btnUpdate.setBounds(293, 9, 97, 30);
		panel.add(btnUpdate);
		btnUpdate.setBackground(Color.CYAN);
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setMnemonic('U');
		btnUpdate.setEnabled(false);

		btnCancel = new JButton("Cancel");
		btnCancel.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose1.png"));
		btnCancel.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose.png"));
		btnCancel.setBounds(391, 9, 97, 30);
		panel.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SiteFrame.dispose();
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.CYAN);
		btnCancel.setMnemonic('C');

		btnCreate = new JButton("Create New Site");
		btnCreate.setMnemonic('N');
		btnCreate.setBounds(488, 9, 168, 25);
		panel.add(btnCreate);
		btnUpdate.addActionListener(bt);
		btnSave.addActionListener(bt);
		btnCreate.addActionListener(bt);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 13, 668, 124);
		// Dpanel.add(jsp);

		hpanel = new JPanel();
		hpanel.setForeground(new Color(0, 0, 51));
		hpanel.setBackground(Color.BLACK);
		hpanel.setBorder(
				new TitledBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 0)), null),
						"Create New Branch", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		hpanel.setBounds(0, 0, 668, 125);
		SiteFrame.getContentPane().add(hpanel);
		hpanel.setLayout(null);

		JLabel lblVatNo = new JLabel("GST NO");
		lblVatNo.setBounds(447, 60, 84, 16);
		lblVatNo.setFont(new Font("Calibri", Font.BOLD, 14));
		lblVatNo.setForeground(Color.WHITE);
		hpanel.add(lblVatNo);
		lblVatNo.setHorizontalAlignment(SwingConstants.LEFT);

		vatno = new JTextField();
		vatno.setBounds(439, 77, 192, 30);
		vatno.setFont(new Font("Calibri", Font.BOLD, 14));
		vatno.setBackground(Color.WHITE);
		vatno.setForeground(Color.BLACK);
		hpanel.add(vatno);
		vatno.setColumns(10);

		JLabel lblRegNo = new JLabel("Reg No");
		lblRegNo.setBounds(481, 32, 60, 16);
		lblRegNo.setFont(new Font("Calibri", Font.BOLD, 14));
		lblRegNo.setForeground(Color.WHITE);
		hpanel.add(lblRegNo);
		lblRegNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegNo.setVisible(false);

		regno = new JTextField();
		regno.setBounds(543, 31, 20, 22);
		regno.setText("0");
		hpanel.add(regno);
		regno.setColumns(10);
		regno.setVisible(false);

		companyname = new JTextField();
		companyname.setBounds(12, 28, 362, 30);
		companyname.setForeground(Color.BLACK);
		companyname.setFont(new Font("Calibri", Font.BOLD, 14));
		companyname.setBackground(Color.WHITE);
		companyname.setEnabled(false);
		hpanel.add(companyname);
		companyname.setColumns(10);

		compcode = new JTextField();
		compcode.setBounds(380, 28, 48, 30);
		compcode.setForeground(Color.BLACK);
		compcode.setFont(new Font("Calibri", Font.BOLD, 14));
		compcode.setBackground(Color.WHITE);
		compcode.setEnabled(false);
		hpanel.add(compcode);
		compcode.setColumns(10);
		ActionListener cmp = new Company();
		compcode.addActionListener(cmp);

		JLabel lblName = new JLabel("Branch Name");
		lblName.setBounds(12, 60, 166, 16);
		lblName.setForeground(Color.WHITE);
		hpanel.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);

		name = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		name.setBounds(12, 77, 362, 30);
		name.setForeground(Color.BLACK);
		name.setBackground(Color.WHITE);
		name.setDocument(new gnSetinputLimit(50));
		name.setToolTipText("Max Char Limit is 50 ");
		hpanel.add(name);
		name.setFont(new Font("Calibri", Font.BOLD, 14));
		name.setColumns(20);

		sitecode = new JTextField();
		sitecode.setBounds(382, 77, 48, 30);
		sitecode.setForeground(Color.BLACK);
		sitecode.setBackground(Color.WHITE);
		hpanel.add(sitecode);
		sitecode.setFont(new Font("Calibri", Font.BOLD, 14));
		sitecode.setColumns(10);
		sitecode.setEnabled(true);
		JLabel lblCompanyCode = new JLabel("Company ");
		lblCompanyCode.setBounds(12, 13, 64, 16);
		lblCompanyCode.setForeground(Color.WHITE);
		hpanel.add(lblCompanyCode);
		lblCompanyCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCompanyCode.setHorizontalAlignment(SwingConstants.RIGHT);

		comptypelbl = new JLabel(" ");
		comptypelbl.setFont(new Font("Cambria", Font.BOLD, 14));
		comptypelbl.setHorizontalAlignment(SwingConstants.LEFT);
		comptypelbl.setForeground(Color.WHITE);
		comptypelbl.setBounds(380, 91, 251, 16);
		hpanel.add(comptypelbl);
		name.addActionListener(st);

		ActionListener siteccd = new sitecodeLsnr();
		sitecode.addActionListener(siteccd);

		ActionListener hls = new hierLsnr();
		hname.addActionListener(hls);
		hno.addActionListener(hls);

		new General().msg("Site Creation is Important Activity Please Select Proper Data");

		setDefault();
		 decorateComp();
	}

	/// Start codeing Here

	class hierLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				getHierarchy();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void getHierarchy() throws Throwable {
		// new gnAdmin().hierarchy_getHierarchyData(hno, hname);
		new gnAdmin().getHierarchyDescOfGivenVerticle(verticlecode.getText(), hno, hname);
		hno.setEditable(false);
		hname.setEditable(false);
	}

	public void decorateComp() throws Throwable {

		new gnLogger().loggerInfoEntry("POS", "Verticle Selection  -Start");
		String vompveticlename = new gnHierarchy().getVerticleName();
		verticlename.setEnabled(true);
		verticlename.setEditable(true);
		new gnLogger().loggerInfoEntry("POS", "Verticle Selection  -Sucess");

		comptypelbl.setText(vompveticlename);
		new gnApp().setFrameTitel(SiteFrame);
		SiteFrame.setUndecorated(false);
		new gnField().closeform(hpanel, SiteFrame);
		new gnField().closeform(MiddlePanel, SiteFrame);
		new gnField().closeform(RightPanel, SiteFrame);
		new gnDecorate().DispField_Eatch(classcode, 20);
		new gnDecorate().DispField_Eatch(classname, 20);
		new gnDecorate().DispField_Eatch(formatcode, 20);
		new gnDecorate().DispField_Eatch(classcode, 20);
		new gnDecorate().DispField_Eatch(classname, 20);
		new gnDecorate().DispField_Eatch(typecode, 20);
		new gnDecorate().DispField_Eatch(typename, 20);
		new gnDecorate().DispField_Eatch(optime, 20);
		new gnDecorate().DispField_Eatch(cltime, 20);
		new gnDecorate().DispField_Eatch(addr1, 20);
		new gnDecorate().DispField_Eatch(addr2, 20);
		new gnDecorate().DispField_Eatch(addr4, 20);
		new gnDecorate().DispField_Eatch(addr3, 20);
		new gnDecorate().DispField_Eatch(pincode, 20);
		new gnDecorate().DispField_Eatch(sitecode, 20);
		new gnDecorate().DispField_Eatch(name, 20);
		new gnDecorate().DispField_Eatch(compcode, 20);
		new gnDecorate().DispField_Eatch(phone1, 20);
		new gnDecorate().DispField_Eatch(phone2, 20);
		new gnDecorate().DispField_Eatch(fax, 20);
		new gnDecorate().DispField_Eatch(email, 20);
		new gnDecorate().DispField_Eatch(landmark, 20);
		new gnDecorate().DispField_Eatch(area, 20);
		new gnDecorate().DispField_Eatch(statecode, 20);
		new gnDecorate().DispField_Eatch(countrycode, 20);
		new gnDecorate().DispField_Eatch(citycode, 20);
		new gnDecorate().DispField_Eatch(cityname, 20);
		new gnDecorate().DispField_Eatch(countryname, 20);
		new gnDecorate().DispField_Eatch(statename, 20);
		new gnDecorate().DispField_Eatch(verticlecode, 20);
		new gnDecorate().DispField_Eatch(verticlename, 20);
		new gnDecorate().DispField_Eatch(segmentname, 20);
		new gnDecorate().DispField_Eatch(currencyname, 20);
		new gnDecorate().DispField_Eatch(segmentcode, 20);
		new gnDecorate().DispField_Eatch(currencycode, 20);
		new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnCancel, Color.BLUE, Color.WHITE);
		new gnDecorate().decorateBtn(btnUpdate, Color.MAGENTA, Color.WHITE);

	}

	private void setDefault() throws Throwable {

		// new General().msg("Setting Default Data ");
		segmentcode.setEditable(false);
		segmentname.setEditable(false);
		// verticlecode.setEditable(false);

		verticlename.setEnabled(true);
		verticlename.setEditable(true);

		String vcomp = new gnConfig().getCompanyCode();
		String vcompname = new gnConfig().getCompany();
		String vstorecode = new gnConfig().getStorecode();
		sitecode.setText(vstorecode);
		name.setText(new gnConfig().getStoreName());
		compcode.setText(vcomp);
		companyname.setText(vcompname);
		segmentcode.setText(new gnHierarchy().getSegmentCode());
		segmentname.setText(new gnHierarchy().getSegmentName());
		verticlecode.setText(new gnHierarchy().getVerticleCode());
		verticlename.setText(new gnHierarchy().getVerticleName());
		hno.setText(new gnHierarchy().getmySiteHierarchyNo());
		hname.setText(new gnHierarchy().getmySiteHierarchyName());

		compcode.setEnabled(false);
		sitecode.setEnabled(false);
		name.setEnabled(false);
		btnUpdate.setEnabled(true);
		btnSave.setEnabled(false);
		btnSave.setVisible(false);
		btnCreate.setVisible(false);

		if (myvcomp.trim().equals("9999") & (ucode.trim().equals("ADMIN"))) {
			btnSave.setVisible(false);
			btnCreate.setVisible(true);
		}

		verticlename.setEnabled(true);
		verticlename.setEditable(true);

		// new General().msg("Setting Default Data before done");

		showData(vstorecode);

		// new General().msg("Setting Default Data done");

		new gnLogger().loggerInfoEntry("POS", "Site Data Defult Data Set -Sucess");

	}

	private void checkforNewstoreEntry() {
		String vsiteentry = sitecode.getText().trim();
		new General().msg(vsiteentry);

		switch (vsiteentry) {
		case "9999":
			btnSave.setEnabled(false);
			btnUpdate.setEnabled(true);
			break;
		default:
			btnSave.setEnabled(true);
			btnUpdate.setEnabled(false);
			break;
		}

	}

	class sitecodeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			checkforNewstoreEntry();
		}
	}

	class Company implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			try {
				new gnAdmin().setcompanyAllData(compcode, companyname, segmentcode, segmentname, verticlecode,
						verticlename, hno, hname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	public void showTable_comp(String sql, String type) throws Throwable {
		// String sql = "Call Tb_getAllCompnayData() " ;
		new gnTable().RemoveTableRows(model);
		rs = this.getSPResult(sql);
		String[] cl = { "Type", "Company_code", "Company_Name", " VATNO", "Phone", "Segment", "Segment_Name",
				"Verticle", "Verticle_Name" };
		model.setColumnIdentifiers(cl);
		while (rs.next()) {
			model.addRow(new Object[] { type, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			// model.addRow(new Object[]{type , rs.getString(1),
			// rs.getString(2), rs.getString(3), rs.getString(4),
			// rs.getString(5) });
			table.setModel(model);
			new gnTable().setTablewidth(table, 1, 100);
			new gnTable().setTablewidth(table, 2, 300);
		}
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		table.setEnabled(true);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.gray);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.black);
		table.setSelectionBackground(Color.CYAN);

		JViewport prt = new JViewport();
		prt.add(table, Col);
		prt.setVisible(true);
		jsp.setViewport(prt);

		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification1);
		String vmsg = "Select Data For " + type;
		new General().msgsearch(jsp, table, vmsg, 700, 300);

	}// End Show Table

	public CellEditorListener ChangeNotification1 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 0);
			compcode.setText(table.getValueAt(row, 1).toString());
			companyname.setText(table.getValueAt(row, 2).toString());
			segmentcode.setText(table.getValueAt(row, 5).toString());
			segmentname.setText(table.getValueAt(row, 6).toString());
			verticlecode.setText(table.getValueAt(row, 7).toString());
			verticlename.setText(table.getValueAt(row, 8).toString());
			new General().msgDispose();
		}
	};
	private JButton btnCreate;

	class site implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String vcomp;
			String vtype = "Site";
			try {
				new gnSite().showSite(vtype, sitecode, name);
				btnUpdate.setEnabled(true);
				showData(sitecode.getText());
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
		}
	}

	class Btn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			if (value == "Update") {
				try {
					preparetoUpdate();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Create New Site") {
				checkpermission();
			}

			if (value == "Save") {
				String status = validate();
				if (status == "Sucess") {
					try {
						prepareToinsert();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	private void checkpermission() {
		String status = new General().checkSiteCreatepermission();
		if (status == "Sucess") {
			btnCreate.setVisible(true);
			compcode.setEditable(false);
			compcode.setEnabled(false);
			compcode.grabFocus();
			sitecode.setEditable(true);
			sitecode.setEnabled(true);
			name.setEditable(true);
			name.setEnabled(true);
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

	class Country implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String vcode = "%" + value + "%";
			String vtype = "Country";
			try {
				vmastersearchString = "%" + countryname.getText() + "%";
				new gnAdmin().showMasterTable(vtype, countrycode, countryname);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
			String vtype = "State";
			try {
				vmastersearchString = "%" + statename.getText() + "%";
				new gnAdmin().showMasterTable(vtype, statecode, statename);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class City implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String vcode = "%" + value + "%";
			String vtype = "City";
			try {
				vmastersearchString = "%" + cityname.getText() + "%";
				new gnAdmin().showMasterTable(vtype, citycode, cityname);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class Segment implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String vcode = "%" + value + "%";
			String vtype = "Segment";
			try {

				vmastersearchString = "%" + segmentname.getText() + "%";
				new gnAdmin().showMasterTable(vtype, segmentcode, segmentname);

			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class Verticle implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String vcode = "%" + value + "%";
			String vtype = "Verticle";
			try {
				vmastersearchString = "%" + verticlename.getText() + "%";
				new gnAdmin().showMasterTable(vtype, verticlecode, verticlename);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class Format implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String vcode = "%" + value + "%";
			String vtype = "Format";
			try {
				vmastersearchString = "%" + formatname.getText() + "%";
				new gnAdmin().showMasterTable(vtype, formatcode, formatname);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class SType implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String vcode = "%" + value + "%";
			String vtype = "Type";
			try {
				vmastersearchString = "%" + typename.getText() + "%";
				new gnAdmin().showMasterTable(vtype, typecode, typename);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class SClass implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String vcode = "%" + value + "%";
			String vtype = "Class";
			try {
				vmastersearchString = "%" + classname.getText() + "%";
				new gnAdmin().showMasterTable(vtype, classcode, classname);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class Currency implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String vcode = "%" + value + "%";
			String vtype = "Currency";
			try {
				vmastersearchString = "%" + currencyname.getText() + "%";
				new gnAdmin().showMasterTable(vtype, currencycode, currencyname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	public void reset() {
		classname.setEditable(true);
		classcode.setEditable(true);
		formatname.setEditable(true);
		formatcode.setEditable(true);
		citycode.setEditable(true);
		cityname.setEditable(true);
		// segmentname.setText(rs.getString(24)) ;
		if (compcode.getText().length() == 0) {
			segmentname.setEditable(true);
			segmentcode.setEditable(true);
			verticlename.setEditable(true);
			verticlecode.setEditable(true);
		}

		statename.setEditable(true);
		statecode.setEditable(true);
		countryname.setEditable(true);
		countrycode.setEditable(true);
		addr4.setEditable(true);
		addr3.setEditable(true);
		addr2.setEditable(true);
		addr1.setEditable(true);
		regno.setEditable(true);
		vatno.setEditable(true);
		name.setEditable(true);
		sitecode.setEditable(true);
		compcode.setEditable(true);
		typecode.setEditable(true);
		typename.setEditable(true);
		currencycode.setEditable(true);
		currencyname.setEditable(true);
		opdate.setEnabled(true);
		// compcode.setText(null);
		sitecode.setText(null);
		name.setText(null);
		vatno.setText(null);
		phone1.setText(null);
		phone2.setText(null);
		email.setText(null);
		fax.setText(null);
		regno.setText(null);
		addr1.setText(null);
		addr2.setText(null);
		addr3.setText(null);
		addr4.setText(null);
		countrycode.setText(null);
		countryname.setText(null);
		statecode.setText(null);
		statename.setText(null);
		citycode.setText(null);
		cityname.setText(null);
		if (compcode.getText().length() == 0) {
			segmentcode.setText(null);
			segmentcode.setEnabled(false);
			segmentname.setText(null);
			segmentname.setEnabled(false);
			verticlecode.setText(null);
			verticlecode.setEnabled(false);
			verticlename.setText(null);
			verticlename.setEnabled(true);
			verticlename.setEditable(true);

		}
		formatcode.setText(null);
		formatname.setText(null);
		classcode.setText(null);
		classname.setText(null);
		verticlecode.setText(null);
		verticlename.setText(null);
		segmentcode.setText(null);
		segmentname.setText(null);
		typecode.setText(null);
		typename.setText(null);
		btnSave.setEnabled(false);
		opdate.setText(null);
		currencycode.setText(null);
		currencyname.setText(null);
		name.grabFocus();

	}

	private String validate() {
		String status = "Sucess";
		if (sitecode.getText().length() == 0) {
			new General().msg("Enter Site code ...");
			status = "Fail";
		}

		if (name.getText().length() == 0) {
			new General().msg("Enter Store Name ...");
			status = "Fail";
		}

		if (vatno.getText().length() == 0) {
			new General().msg("Enter GST  Details  ...");
			status = "Fail";
		}

		if (addr1.getText().length() == 0) {
			new General().msg("Enter Full Address    All Lines...");
			status = "Fail";
		}

		if (addr2.getText().length() == 0) {
			new General().msg("Enter Full Address    All Lines ...");
			status = "Fail";
		}

		if (addr3.getText().length() == 0) {
			new General().msg("Enter Full Address    All Lines...");
			status = "Fail";
		}

		if (addr4.getText().length() == 0) {
			new General().msg("Enter Full Address    All Lines...");
			status = "Fail";
		}

		if (pincode.getText().length() == 0) {
			new General().msg("Enter Pin Code ...");
			status = "Fail";
		}

		if (phone1.getText().length() == 0) {
			new General().msg("Enter Mobile No ...");
			status = "Fail";
		}

		if (countrycode.getText().length() == 0) {
			new General().msg("Select Country  code ...");
			status = "Fail";
		}

		if (statecode.getText().length() == 0) {
			new General().msg("Select State   code ...");
			status = "Fail";
		}

		if (citycode.getText().length() == 0) {
			new General().msg("Select City  code ...");
			status = "Fail";
		}
		if (verticlecode.getText().length() == 0) {
			new General().msg("Select Verticle  code ...");
			status = "Fail";
		}
		if (segmentcode.getText().length() == 0) {
			new General().msg("Select Segment   code ...");
			status = "Fail";
		}

		if (formatcode.getText().length() == 0) {
			new General().msg("Select Store Format Type   ...");
			status = "Fail";
		}

		if (typecode.getText().length() == 0) {
			new General().msg("Select Store Type   ...");
			status = "Fail";
		}

		if (currencycode.getText().length() == 0) {
			new General().msg("Select Default Currency    ...");
			status = "Fail";
		}

		if (classcode.getText().length() == 0) {
			new General().msg("Select Class of Store    ...");
			status = "Fail";
		}

		return status;
	}

	public void showData(String value) throws SQLException, ClassNotFoundException {
		String vcomp = compcode.getText();
		String sql3 = "Call Tbl_getSiteData(" + value + " , " + vcomp + ")";
		rs = this.getSPResult(sql3);
		if (rs.next()) {
			compcode.setText(rs.getString(1));
			sitecode.setText(rs.getString(2));
			name.setText(rs.getString(3));
			vatno.setText(rs.getString(4));
			regno.setText(rs.getString(5));
			phone1.setText(rs.getString(6));
			phone2.setText(rs.getString(7));
			fax.setText(rs.getString(8));
			email.setText(rs.getString(9));
			addr1.setText(rs.getString(10));
			addr2.setText(rs.getString(11));
			addr3.setText(rs.getString(12));
			addr4.setText(rs.getString(13));
			pincode.setText(rs.getString(16));
			countrycode.setText(rs.getString(17));
			countryname.setText(rs.getString(18));
			statecode.setText(rs.getString(19));
			statename.setText(rs.getString(20));
			citycode.setText(rs.getString(21));
			cityname.setText(rs.getString(22));
			segmentcode.setText(rs.getString(23));
			verticlecode.setText(rs.getString(25));
			verticlename.setText(rs.getString(26));
			formatcode.setText(rs.getString(27));
			formatname.setText(rs.getString(28));
			classcode.setText(rs.getString(29));
			classname.setText(rs.getString(30));

			classname.setEditable(false);
			classcode.setEditable(false);
			formatname.setEditable(false);
			formatcode.setEditable(false);
			citycode.setEditable(false);
			verticlename.setEditable(false);
			verticlecode.setEditable(false);
			cityname.setEditable(false);
			segmentname.setText(rs.getString(24));
			segmentname.setEditable(false);
			segmentcode.setEditable(false);
			statename.setEditable(false);
			statecode.setEditable(false);
			countryname.setEditable(false);
			countrycode.setEditable(false);
			// addr4.setEditable(false);
			// addr3.setEditable(false);
			// addr2.setEditable(false);
			// addr1.setEditable(false);
			// regno.setEditable(false);
			// vatno.setEditable(false);
			// name.setEditable(false);
			// sitecode.setEditable(false);
			compcode.setEditable(false);
			// typecode.setEditable(false);
			// typename.setEditable(false);
			// currencycode.setEditable(false);
			// currencyname.setEditable(false);
			opdate.setEnabled(false);

			typecode.setText(rs.getString(31));
			typename.setText(rs.getString(32));
			btnSave.setEnabled(false);

			opdate.setText(rs.getString(33));

			currencycode.setText(rs.getString(34));
			currencyname.setText(rs.getString(35));

			landmark.setText(rs.getString(36));
			area.setText(rs.getString(37));
			allowb2b.setSelectedItem(rs.getString(38));
			allownegative.setSelectedItem(rs.getString(39));
			mydefault.setSelectedItem(rs.getString(40));
		} else {
			new General().msg("No Data Found For This Store Code");
		}
	}

	public void preparetoUpdate() throws ClassNotFoundException, SQLException, IOException {
		String vallownegative = allownegative.getSelectedItem().toString();
		String vallowb2b = allowb2b.getSelectedItem().toString();
		// String vmydefault = mydefault.getSelectedItem().toString() ;
		String vmydefault = "Y"; // mydefault.getSelectedItem().toString() ;

		String vstorecode = sitecode.getText();
		String vcomp = compcode.getText();
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		// this.closeconn();
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String company = "update ms_site_master  set "
				+ " Phone_No_1= ?  , Phone_NO_2  = ?,  Fax_Number  = ?, Email_ID = ?,  landmark = ?, area= ?, pincode = ?, "
				+ " B2BSalesAllow = ? , NegativeInvAllow= ?  , mySite= ?  ,  format = ?  , "
				+ "Add_Line1 = ?  , Add_Line2 = ? , Add_Line3  = ?, Add_Line4 = ? ,"
				+ "State= ?  ,City= ?, VAT_NO = ? , city_name = ? , verticle = ?  , hierarchyno = ? , hname = ?"
				+ " where site_code = ?  and company_code = ?";

		try {
			prst = con.prepareStatement(company);
			prst.setString(1, phone1.getText());
			prst.setString(2, phone2.getText());
			prst.setString(3, fax.getText());
			prst.setString(4, email.getText());
			prst.setString(5, landmark.getText());
			prst.setString(6, area.getText());
			prst.setString(7, pincode.getText());
			prst.setString(8, vallownegative);
			prst.setString(9, vallowb2b);
			prst.setString(10, vmydefault);
			prst.setString(11, formatcode.getText());

			prst.setString(12, addr1.getText());
			prst.setString(13, addr2.getText());
			prst.setString(14, addr3.getText());
			prst.setString(15, addr4.getText());
			prst.setString(16, citycode.getText());
			prst.setString(17, statecode.getText());
			prst.setString(18, vatno.getText());
			prst.setString(19, cityname.getText());
			prst.setString(20, verticlecode.getText());
			prst.setString(21, hno.getText());
			prst.setString(22, hname.getText());
			prst.setString(23, vstorecode);
			prst.setString(24, vcomp);
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
			btnUpdate.setEnabled(false);
			reset();
			btnSave.setEnabled(true);
		}

		if (prst != null) {
			prst.close();
		}
		if (con != null) {
			con.close();
		}
	}

	public String prepareToinsert() throws SQLException, ClassNotFoundException, IOException {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		// this.closeconn();
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String company = "INSERT INTO  ms_site_master  (  Company_Code  , "
				+ "Site_code  , Name  , Add_Line1  , Add_Line2  , Add_Line3  , Add_Line4  ,"
				+ " Phone_No_1  , Phone_NO_2  , Country  ,State  ,City  , Area  ,LandMark  ,"
				+ " Fax_Number  , Email_ID  , VAT_NO  ,Regs_No  ,Format  ,Class  ,Type  ,"
				+ "Segment  , Verticle  , B2BSalesAllow  , NegativeInvAllow  , Openiing_Date  ,"
				+ " DailyOpentime  ,DailyClosetime  , Pincode  , mySite  ," + " DefaultCurrency  )"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(company);
			prst.setString(1, compcode.getText());
			prst.setString(2, sitecode.getText());
			prst.setString(3, name.getText());
			prst.setString(4, addr1.getText());
			prst.setString(5, addr2.getText());
			prst.setString(6, addr3.getText());
			prst.setString(7, addr4.getText());
			prst.setString(8, phone1.getText());
			prst.setString(9, phone2.getText());
			prst.setString(10, countrycode.getText());
			prst.setString(11, statecode.getText());
			prst.setString(12, citycode.getText());
			prst.setString(13, area.getText());
			prst.setString(14, landmark.getText());
			prst.setString(15, fax.getText());
			prst.setString(16, email.getText());
			prst.setString(17, vatno.getText());
			prst.setString(18, regno.getText());
			prst.setString(19, formatcode.getText());
			prst.setString(20, classcode.getText());
			prst.setString(21, typecode.getText());
			prst.setString(22, segmentcode.getText());
			prst.setString(23, verticlecode.getText());

			// String vb2b = allowb2b.getSelectedItem().toString() ;
			// new General().msg( vb2b);
			// prst.setString(24, vb2b ) ;
			prst.setString(24, "Y");

			// String vallowneg = allownegative.getSelectedItem().toString();
			// new General().msg( vallowneg );
			prst.setString(25, "Y");

			prst.setString(26, new gnConfig().date_ConverttoDBforamt(opdate.getText()));
			prst.setString(27, optime.getText());
			prst.setString(28, cltime.getText());
			prst.setString(29, pincode.getText());

			// String vmydefault = mydefault.getSelectedItem().toString();
			// new General().msg( vmydefault );
			prst.setString(30, "N");

			prst.setString(31, currencycode.getText());
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
			new General().msg("Data Saved Sucessfully");
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
				try {
					siteautomation();
				} catch (Throwable e) {
					e.printStackTrace();
				}
				reset();
			}
			if (con != null) {
				con.close();
			}
		}
		return status;
	}

	private void siteautomation() throws Throwable {

		if (SiteAutomationActivate == "Y") {
			String vmynewstorecode = sitecode.getText();
			String vmycomcode = compcode.getText();
			String vmystorename = name.getText();
			new gnSiteAutomation().doOtherAutomationActivity(vmycomcode, vmynewstorecode, vmystorename);
		} else {
			new General().msg("[Follow Next Step]  <A.Create New User >  < B.  Create Financial Year >");
			new General()
					.msg("[Follow Next Step]  <C.Set configuration for new store>  < B. Number Series for new store>");
		}
	}

}// last

package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.border.LineBorder;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MeretooPromoMaster extends getResultSet {

	Connection con, con1, con2, con3, con4, con5, con6, con7;

	JFrame meretooPomotionFrame;
	private JTextField from;
	private JTextField to;
	private JTextField catname;
	private JTextField promoType;
	JButton btnUpdate;
	JLabel lbldiscamt;
	JComboBox active;
	JLabel lbldiscper;
	private JTextField catcode;
	private JTextField typecode;
	private JTextField code;
	private JTextField name;
	private JTextField type;
	private JTextField purchase;
	private JTextField discper;
	private JTextField discamt;

	JComboBox caption;
	JButton btnAdd;
	JScrollPane jsp;
	JComboBox condition;
	JComboBox inclusive;
	private JTextField createDate;
	private JTextField target;

	JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 7 || column == 11 || column == 12 || column == 13 || column == 14) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(new Color(51, 51, 102));
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 11));
			}

			if (column == 15 || column == 16 || column == 17 || column == 18) {
				componentt.setBackground(Color.darkGray);
				componentt.setForeground(Color.YELLOW);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));

			}

			if (column == 8) {
				componentt.setBackground(new Color(0, 51, 153));// .LIGHT_GRAY);
				componentt.setForeground(new Color(204, 255, 153));
				componentt.setFont(new Font("Calibri", Font.BOLD, 15));
			}

			return componentt;
		}
	};
	///

	DefaultTableModel model = new DefaultTableModel();
	private JTextField freeqty;
	private JTextField freearticle;

	JButton btnClose;
	JButton btnClear;
	JButton btnSave;
	JButton btnRunning;
	JButton btnShow;
	JButton btnArticle;
	JButton btnBrand;
	JButton btnBillLevel;

	String vcomp;
	String vstore;
	String DBhdr;
	private JTextField freename;
	private JTextField purchaseto;
	private JLabel lblNewLabel_23;
	JPanel freepanel;
	JPanel discpanel;
	private JLabel lblNewLabel_24;
	private JTextField promono;
	private JLabel lblNewLabel_25;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeretooPromoMaster window = new MeretooPromoMaster();
					window.meretooPomotionFrame.setVisible(true);
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
	public MeretooPromoMaster() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		meretooPomotionFrame = new JFrame();
		meretooPomotionFrame.setAlwaysOnTop(true);
		meretooPomotionFrame.setBounds(1, 100, 1350, 600);
		meretooPomotionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		meretooPomotionFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(MeretooPromoMaster.class.getResource("/RetailProduct/mymainlogo_5.png")));
		lblNewLabel.setBounds(0, 0, 158, 153);
		meretooPomotionFrame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PROMOTION MODULE");
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setIcon(null);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(279, 0, 894, 30);
		meretooPomotionFrame.getContentPane().add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 200, 0), null),
				"Promotion Period", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel.setBounds(157, 61, 289, 94);
		meretooPomotionFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("From ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(82, 24, 44, 16);
		panel.add(lblNewLabel_2);

		from = new JTextField();
		from.setBounds(127, 21, 116, 30);
		panel.add(from);
		from.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("To Date");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(70, 59, 56, 16);
		panel.add(lblNewLabel_3);

		to = new JTextField();
		to.setBounds(127, 52, 116, 30);
		panel.add(to);
		to.setColumns(10);

		lblNewLabel_24 = new JLabel("Promo NO");
		lblNewLabel_24.setBounds(6, 21, 65, 16);
		panel.add(lblNewLabel_24);

		promono = new JTextField();
		promono.setFont(new Font("SansSerif", Font.BOLD, 12));
		promono.setBounds(4, 46, 67, 28);
		panel.add(promono);
		promono.setColumns(10);

		lblNewLabel_25 = new JLabel(" -");
		lblNewLabel_25.setIcon(new ImageIcon(MeretooPromoMaster.class.getResource("/RetailProduct/panel10.png")));
		lblNewLabel_25.setBounds(70, 17, 7, 71);
		panel.add(lblNewLabel_25);

		JLabel lblNewLabel_4 = new JLabel("Promo Caption");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_4.setBounds(452, 48, 103, 16);
		meretooPomotionFrame.getContentPane().add(lblNewLabel_4);

		caption = new JComboBox();
		caption.setBounds(557, 41, 255, 30);
		meretooPomotionFrame.getContentPane().add(caption);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 51)));
		panel_1.setBounds(443, 70, 714, 83);
		meretooPomotionFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Promo Category");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_5.setBounds(5, 20, 104, 16);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Promo Type");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_6.setBounds(22, 46, 82, 16);
		panel_1.add(lblNewLabel_6);

		catname = new JTextField();
		catname.setBounds(116, 13, 286, 30);
		panel_1.add(catname);
		catname.setColumns(10);

		promoType = new JTextField();
		promoType.setFont(new Font("SansSerif", Font.BOLD, 13));
		promoType.setBounds(116, 39, 286, 30);
		panel_1.add(promoType);
		promoType.setColumns(10);

		catcode = new JTextField();
		catcode.setEditable(false);
		catcode.setBounds(404, 12, 42, 30);
		panel_1.add(catcode);
		catcode.setColumns(10);

		typecode = new JTextField();
		typecode.setEditable(false);
		typecode.setBounds(404, 39, 42, 30);
		panel_1.add(typecode);
		typecode.setColumns(10);

		freename = new JTextField();
		freename.setVisible(false);
		freename.setBounds(116, 66, 87, 16);
		panel_1.add(freename);
		freename.setEditable(false);
		freename.setColumns(10);

		JRadioButton rb1 = new JRadioButton("Promotion Apply On SalesPrice");
		rb1.setEnabled(false);
		rb1.setSelected(true);
		buttonGroup.add(rb1);
		rb1.setForeground(new Color(0, 0, 102));
		rb1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		rb1.setBounds(468, 6, 203, 18);
		panel_1.add(rb1);

		JRadioButton rb2 = new JRadioButton("Promotion Apply On MRP");
		rb2.setEnabled(false);
		buttonGroup.add(rb2);
		rb2.setForeground(new Color(0, 0, 102));
		rb2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 12));
		rb2.setBounds(469, 21, 182, 18);
		panel_1.add(rb2);

		btnUpdate = new JButton("Update Data");
		btnUpdate.setBounds(466, 46, 182, 28);
		panel_1.add(btnUpdate);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(544, 70, 479, 83);
		meretooPomotionFrame.getContentPane().add(panel_2);

		JSplitPane mysplit = new JSplitPane();
		mysplit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mysplit.setBounds(0, 155, 1326, 400);
		mysplit.setDividerLocation(75);
		meretooPomotionFrame.getContentPane().add(mysplit);

		JPanel mainpanel = new JPanel();
		mysplit.setLeftComponent(mainpanel);
		mainpanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		mainpanel.setBackground(Color.WHITE);
		mainpanel.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Code");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_7.setBounds(6, 6, 55, 16);
		mainpanel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Name");
		lblNewLabel_8.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_8.setBounds(101, 6, 55, 16);
		mainpanel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Type");
		lblNewLabel_9.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_9.setBounds(268, 6, 55, 16);
		mainpanel.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("ConditionOn");
		lblNewLabel_10.setForeground(new Color(0, 0, 102));
		lblNewLabel_10.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_10.setBounds(339, 6, 94, 16);
		mainpanel.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Buying Condition");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setForeground(new Color(0, 0, 51));
		lblNewLabel_11.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_11.setBounds(414, 6, 108, 16);
		mainpanel.add(lblNewLabel_11);

		JLabel lblNewLabel_14 = new JLabel("Inclusive");
		lblNewLabel_14.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_14.setBounds(908, 6, 74, 16);
		mainpanel.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("Active");
		lblNewLabel_15.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_15.setBounds(1058, 8, 55, 16);
		mainpanel.add(lblNewLabel_15);

		code = new JTextField();
		code.setFont(new Font("SansSerif", Font.BOLD, 12));
		code.setBounds(6, 34, 44, 28);
		mainpanel.add(code);
		code.setColumns(10);

		name = new JTextField();
		name.setFont(new Font("SansSerif", Font.BOLD, 12));
		name.setBounds(45, 34, 198, 28);
		mainpanel.add(name);
		name.setColumns(10);

		type = new JTextField();
		type.setBounds(240, 34, 122, 28);
		mainpanel.add(type);
		type.setColumns(10);

		condition = new JComboBox();
		condition.setModel(new DefaultComboBoxModel(new String[] { "Qty", "Value", "Card" }));
		condition.setBounds(361, 34, 64, 26);
		mainpanel.add(condition);

		purchase = new JTextField();
		purchase.setFont(new Font("SansSerif", Font.BOLD, 12));
		purchase.setBounds(424, 34, 88, 28);
		mainpanel.add(purchase);
		purchase.setColumns(10);

		inclusive = new JComboBox();
		inclusive.setModel(new DefaultComboBoxModel(new String[] { "N/A", "Y", "N" }));
		inclusive.setBounds(907, 35, 64, 26);
		mainpanel.add(inclusive);

		active = new JComboBox();
		active.setModel(new DefaultComboBoxModel(new String[] { "Y", "N" }));
		active.setBounds(1058, 36, 55, 26);
		mainpanel.add(active);

		JLabel lblNewLabel_17 = new JLabel("Target");
		lblNewLabel_17.setForeground(new Color(51, 51, 153));
		lblNewLabel_17.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_17.setBounds(979, 6, 55, 16);
		mainpanel.add(lblNewLabel_17);

		target = new JTextField();
		target.setBounds(979, 34, 74, 28);
		mainpanel.add(target);
		target.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("Range -From");
		lblNewLabel_20.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_20.setBounds(424, 22, 88, 16);
		mainpanel.add(lblNewLabel_20);

		JLabel lblNewLabel_21 = new JLabel("Buying Condition");
		lblNewLabel_21.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_21.setBounds(523, 6, 94, 16);
		mainpanel.add(lblNewLabel_21);

		JLabel lblNewLabel_22 = new JLabel("TO");
		lblNewLabel_22.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setBounds(533, 22, 55, 16);
		mainpanel.add(lblNewLabel_22);

		purchaseto = new JTextField();
		purchaseto.setFont(new Font("SansSerif", Font.BOLD, 12));
		purchaseto.setBounds(513, 34, 108, 28);
		mainpanel.add(purchaseto);
		purchaseto.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnSave.setForeground(new Color(0, 0, 153));
		btnSave.setBounds(1125, 34, 70, 28);
		mainpanel.add(btnSave);
		btnSave.setMnemonic('S');

		btnClear = new JButton("Clear");
		btnClear.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnClear.setForeground(new Color(0, 0, 153));
		btnClear.setBounds(1191, 34, 70, 28);
		mainpanel.add(btnClear);
		btnClear.setMnemonic('R');

		btnClose = new JButton("Close");
		btnClose.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnClose.setForeground(new Color(0, 0, 153));
		btnClose.setBounds(1256, 34, 62, 28);
		mainpanel.add(btnClose);
		btnClose.setMnemonic('C');

		btnAdd = new JButton("Add");
		btnAdd.setBounds(1256, 0, 62, 28);
		mainpanel.add(btnAdd);
		btnAdd.setMnemonic('A');

		freepanel = new JPanel();
		freepanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		freepanel.setBackground(Color.WHITE);
		freepanel.setBounds(622, 6, 147, 62);
		mainpanel.add(freepanel);
		freepanel.setLayout(null);

		JLabel lblNewLabel_19 = new JLabel("Free Article");
		lblNewLabel_19.setBounds(6, 0, 75, 16);
		freepanel.add(lblNewLabel_19);

		freearticle = new JTextField();
		freearticle.setBounds(6, 28, 87, 28);
		freepanel.add(freearticle);
		freearticle.setColumns(10);

		JLabel lblNewLabel_18 = new JLabel("Free Qty");
		lblNewLabel_18.setBounds(86, 0, 55, 16);
		freepanel.add(lblNewLabel_18);
		lblNewLabel_18.setFont(new Font("SansSerif", Font.BOLD, 10));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);

		freeqty = new JTextField();
		freeqty.setBounds(96, 28, 45, 28);
		freepanel.add(freeqty);
		freeqty.setColumns(10);

		discpanel = new JPanel();
		discpanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		discpanel.setBackground(Color.CYAN);
		discpanel.setBounds(768, 6, 128, 62);
		mainpanel.add(discpanel);
		discpanel.setLayout(null);

		lbldiscper = new JLabel("Disc%");
		lbldiscper.setBounds(0, 0, 55, 16);
		discpanel.add(lbldiscper);
		lbldiscper.setHorizontalAlignment(SwingConstants.CENTER);
		lbldiscper.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbldiscper.setForeground(new Color(0, 0, 255));

		lbldiscamt = new JLabel("DiscAmt");
		lbldiscamt.setBounds(67, 0, 55, 16);
		discpanel.add(lbldiscamt);
		lbldiscamt.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbldiscamt.setForeground(new Color(0, 0, 255));

		discper = new JTextField();
		discper.setBounds(10, 28, 58, 28);
		discpanel.add(discper);
		discper.setColumns(10);

		discamt = new JTextField();
		discamt.setBounds(67, 28, 62, 28);
		discpanel.add(discamt);
		discamt.setColumns(10);

		jsp = new JScrollPane();
		mysplit.setRightComponent(jsp);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel lblNewLabel_16 = new JLabel("Create Date");
		lblNewLabel_16.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_16.setBounds(228, 40, 80, 16);
		meretooPomotionFrame.getContentPane().add(lblNewLabel_16);

		createDate = new JTextField();
		createDate.setFont(new Font("SansSerif", Font.BOLD, 12));
		createDate.setBounds(309, 34, 122, 30);
		meretooPomotionFrame.getContentPane().add(createDate);
		createDate.setColumns(10);

		btnRunning = new JButton("Running Promotions");
		btnRunning.setForeground(new Color(51, 51, 153));
		btnRunning.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnRunning.setBounds(1155, 6, 171, 28);
		meretooPomotionFrame.getContentPane().add(btnRunning);

		btnShow = new JButton("Show For Given Dates");
		btnShow.setForeground(new Color(51, 51, 153));
		btnShow.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnShow.setBounds(1155, 34, 171, 28);
		meretooPomotionFrame.getContentPane().add(btnShow);
		btnShow.setMnemonic('o');

		btnArticle = new JButton("Show For  Article");
		btnArticle.setForeground(new Color(51, 51, 153));
		btnArticle.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnArticle.setBounds(1155, 60, 171, 28);
		meretooPomotionFrame.getContentPane().add(btnArticle);

		btnBrand = new JButton("Show For Brand");
		btnBrand.setForeground(new Color(51, 51, 153));
		btnBrand.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnBrand.setBounds(1155, 86, 171, 28);
		meretooPomotionFrame.getContentPane().add(btnBrand);

		btnBillLevel = new JButton("Show Bill Level Promo");
		btnBillLevel.setForeground(new Color(51, 51, 153));
		btnBillLevel.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnBillLevel.setBounds(1155, 115, 171, 28);
		meretooPomotionFrame.getContentPane().add(btnBillLevel);

		lblNewLabel_23 = new JLabel(" ");
		lblNewLabel_23.setIcon(new ImageIcon(MeretooPromoMaster.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel_23.setBounds(197, 0, 976, 30);
		meretooPomotionFrame.getContentPane().add(lblNewLabel_23);

		ActionListener promocat = new promocatLsnr();
		ActionListener promotype = new promotypeLsnr();
		ActionListener nameLs = new nameLsnr();
		ActionListener frname = new freeartLsnr();
		ActionListener btnLs = new btnLsnr();

		name.addActionListener(nameLs);

		catname.addActionListener(promocat);
		promoType.addActionListener(promotype);
		btnAdd.addActionListener(btnLs);
		btnClose.addActionListener(btnLs);
		btnClear.addActionListener(btnLs);
		btnSave.addActionListener(btnLs);
		btnShow.addActionListener(btnLs);
		btnRunning.addActionListener(btnLs);
		btnUpdate.addActionListener(btnLs);
		btnBillLevel.addActionListener(btnLs);
		btnArticle.addActionListener(btnLs);
		btnBrand.addActionListener(btnLs);
		freearticle.addActionListener(frname);
		decorate();

	}

	// Start Codeing Here

	private void decorate() throws Throwable {
		
		meretooPomotionFrame.setUndecorated(true);
		
		btnUpdate.setVisible(false);
		createDate.setText(new General().getDate());
		from.setText(new General().getDate());
		to.setText(new General().getDate());

		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStorecode();
		new gnApp().setFrameTitel(meretooPomotionFrame);
		String vcaption = "PromoCaption";
		String vmsname = "PROMOCaptions";
		String vverticle = new gnHierarchy().getVerticleCode();
		String vsearch = "%%";
		String SQL1 = "call master_getMasterData('" + vmsname + "' , " + vverticle + " , '" + vsearch + "')";
		new gnComp().fillCombo2(SQL1, caption);

		freepanel.setVisible(false);
		discpanel.setVisible(false);
	}

	class promocatLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			try {
				String vname = "PROMOCATEGORY";
				vmastersearchString = "%" + catname.getText() + "%";
				new gnAdmin().showMasterTable(vname, catcode, catname);
				promoType.grabFocus();
				vmastersearchString = "%%";
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class promotypeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String vname = "PROMOTYPES";
				freeqty.setText("0");
				discper.setText("0");
				target.setText("0");
				discamt.setText("0");
				purchase.setText("0");
				freearticle.setEnabled(false);
				freeqty.setEnabled(false);
				condition.setEnabled(true);
				discper.setEnabled(true);
				discamt.setEnabled(true);
				btnAdd.setVisible(false);

				discpanel.setBounds(622, 6, 147, 62);
				discpanel.setVisible(true);
				freepanel.setVisible(false);
				vmastersearchString = "%" + promoType.getText() + "%";
				lbldiscamt.setText("Disc.Amt");
				lbldiscper.setText("Disc%");

				new gnAdmin().showMasterTable(vname, typecode, promoType);
				switch (typecode.getText()) {
				
				case "10":
					type.setText("Month");
					nameEnable();
					name.grabFocus();
					condition.setSelectedItem("Value");
					condition.setEnabled(false);
					freearticle.setEnabled(true);
					freeqty.setEnabled(true);
					discper.setEnabled(false);
					discamt.setEnabled(true);
					freepanel.setVisible(false);
					discpanel.setVisible(true);
					break;
				
				
				case "1":
					type.setText("Article");
					nameEnable();
					name.grabFocus();
					condition.setSelectedItem("Qty");
					condition.setEnabled(false);
					freearticle.setEnabled(true);
					freeqty.setEnabled(true);
					discper.setEnabled(true);
					discamt.setEnabled(false);
					freepanel.setVisible(false);
					discpanel.setVisible(true);
					break;

				case "2":
					type.setText("Article");
					nameEnable();
					name.grabFocus();
					condition.setSelectedItem("Qty");
					condition.setEnabled(true);
					freearticle.setEnabled(false);
					freeqty.setEnabled(false);
					discper.setEnabled(false);
					discamt.setEnabled(true);
					freepanel.setVisible(false);
					discpanel.setVisible(true);
					break;

				case "3":
					type.setText("BillLevel");
					// nameEnable() ;
					// name.grabFocus();
					condition.setSelectedItem("Value");
					condition.setEnabled(false);
					freearticle.setEnabled(false);
					freeqty.setEnabled(false);
					discper.setEnabled(true);
					discamt.setEnabled(false);
					freepanel.setVisible(false);
					discpanel.setVisible(true);
					break;

				case "4":
					type.setText("Article-SplRate");
					lbldiscamt.setText("Max.Qty");
					lbldiscper.setText("Spl.Rate");
					nameEnable();
					name.grabFocus();
					condition.setSelectedItem("Value");
					condition.setEnabled(false);
					freearticle.setEnabled(false);
					freeqty.setEnabled(false);
					discper.setEnabled(true);
					discamt.setEnabled(true);
					freepanel.setVisible(false);
					discpanel.setVisible(true);
					break;

				case "5":
					type.setText("Article");
					nameEnable();
					name.grabFocus();
					condition.setSelectedItem("Qty");
					condition.setEnabled(false);
					freearticle.setEnabled(true);
					freeqty.setEnabled(true);
					discper.setEnabled(true);
					discamt.setEnabled(false);
					freepanel.setVisible(true);
					discpanel.setVisible(false);
					break;

				case "6":
					type.setText("Article");
					nameEnable();
					name.grabFocus();
					condition.setSelectedItem("Qty");
					condition.setEnabled(false);
					freearticle.setEnabled(true);
					freeqty.setEnabled(true);
					discper.setEnabled(true);
					discamt.setEnabled(false);
					freepanel.setVisible(true);
					discpanel.setVisible(false);
					break;

				case "7":
					type.setText("Brand");
					nameEnable();
					name.grabFocus();
					condition.setSelectedItem("Value");
					condition.setEnabled(false);
					freearticle.setEnabled(false);
					freeqty.setEnabled(false);
					discper.setEnabled(true);
					discamt.setEnabled(false);
					freepanel.setVisible(false);
					discpanel.setVisible(true);
					break;

				case "8":
					type.setText("Category");
					nameEnable();
					name.grabFocus();
					condition.setSelectedItem("Value");
					condition.setEnabled(false);
					freearticle.setEnabled(false);
					freeqty.setEnabled(false);
					discper.setEnabled(true);
					discamt.setEnabled(false);
					freepanel.setVisible(false);
					discpanel.setVisible(true);
					break;

				case "9":
					type.setText("SubCategory");
					nameEnable();
					name.grabFocus();
					condition.setSelectedItem("Value");
					condition.setEnabled(false);
					freearticle.setEnabled(false);
					freeqty.setEnabled(false);
					discper.setEnabled(true);
					discamt.setEnabled(false);
					freepanel.setVisible(false);
					discpanel.setVisible(true);
					break;
				}
			} catch (Throwable e1) {
				e1.printStackTrace();
			}

		}
	}

	class freeartLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				showfreename();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void showfreename() throws Throwable {
		String vtypecode = typecode.getText();
		switch (vtypecode) {
		case "1":
			vname = "%" + freename.getText() + "%";
			new gnAdmin().articleNameSearch(vname, freearticle, freename);
			break;
		}

	}

	class nameLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				showname();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			// btnUpdate.setVisible(false);

			String activeFlag = active.getSelectedItem().toString().trim();

			if (value == "Add") {
				String status = validate();
				if (status == "Sucess") {
					addRecord();
					btnAdd.setEnabled(false);
					checkAddbtnvisiblity();
				}
			}

			if (value == "Close") {
				meretooPomotionFrame.dispose();
			}

			if (value == "Clear") {
				reset();
			}

			if (value == "Save") {
				String status = validate();
				if (status == "Sucess") {
					addRecord();
					try {
						int r = table.getRowCount();
						if (r > 0) {
							SaveAction();
						}
					} catch (ClassNotFoundException | SQLException | IOException e1) {
						e1.printStackTrace();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
			}

			if (value == "Update Data") {
				try {
					// updateData() ;
					deactivatePromo();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Running Promotions") {
				String vtype = "Date";
				String vfrom = "";
				String vto = "";
				String vpromoCode = "";
				try {
					String vdate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
					String vcode = "";
					String SQL = "Call Promo_Management('" + vtype + "' , " + vcomp + " , " + vstore + " , '" + vfrom
							+ "' , '" + vto + "' , " + "'" + vpromoCode + "' , '" + vdate + "' ,  '" + vcode
							+ "'    , '" + activeFlag + "')";
					showTable(SQL);
					if (table.getRowCount() > 0) {
						btnUpdate.setVisible(true);
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Show For Given Dates") {
				try {
					String vtype = "DateRange";
					String vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
					String vto = new gnConfig().date_ConverttoDBforamt(to.getText());
					String vpromoCode = "";
					String vcode = "";
					String vdate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
					String SQL = "Call Promo_Management('" + vtype + "' , " + vcomp + " , " + vstore + " , '" + vfrom
							+ "' , '" + vto + "' , " + "'" + vpromoCode + "' , '" + vdate + "' ,  '" + vcode + "' , '"
							+ activeFlag + "')";
					showTable(SQL);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Show For  Article") {
				String vtype = "Article";
				String vfrom = "";
				String vto = "";
				String vpromoCode = "";
				String vcode = code.getText();
				try {
					String vdate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
					String SQL = "Call Promo_Management('" + vtype + "' , " + vcomp + " , " + vstore + " , '" + vfrom
							+ "' , '" + vto + "' , " + "'" + vpromoCode + "' , '" + vdate + "' ,  '" + vcode + "' ,  '"
							+ activeFlag + "')";
					showTable(SQL);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Show For Brand") {
				String vtype = "Brand";
				String vfrom = "";
				String vto = "";
				String vpromoCode = "";
				String vcode = code.getText();
				try {
					String vdate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
					String SQL = "Call Promo_Management('" + vtype + "' , " + vcomp + " , " + vstore + " , '" + vfrom
							+ "' , '" + vto + "' , " + "'" + vpromoCode + "' , '" + vdate + "' ,  '" + vcode + "' , '"
							+ activeFlag + "')";
					showTable(SQL);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Show Bill Level Promo") {
				String vtype = "BillLevel";
				String vfrom = "";
				String vto = "";
				String vpromoCode = "";
				String vcode = code.getName();
				try {
					String vdate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
					String SQL = "Call Promo_Management('" + vtype + "' , " + vcomp + " , " + vstore + " , '" + vfrom
							+ "' , '" + vto + "' , " + "'" + vpromoCode + "' , '" + vdate + "' ,  '" + vcode + "' , '"
							+ activeFlag + "')";
					showTable(SQL);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

		}
	}

	private void deactivatePromo() throws ClassNotFoundException, SQLException {
		// new General().msg("Updating Information .. ");
		String vpromono = "";
		String vactive = "";
		String vdate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
		int row = table.getRowCount();
		for (int k = 0; k < row; k++) {
			vactive = table.getValueAt(k, 20).toString();
			vpromono = table.getValueAt(k, 9).toString();
			// new General().msg("Updating Information .Data is " + " "+vactive
			// + " "+vpromono);
			if (vactive.trim().equalsIgnoreCase("N")) {
				new gnPromoGetInfo().deactivatePromo(vpromono, vdate);
			}
		}
		new General().Quickmsg("Promo Updated sucessfully..");
		new gnTable().RemoveTableRows(model);

	}

	private void updateData() throws ClassNotFoundException, SQLException, IOException {
		// new General().msg("Updating REcords...");
		// String[] col = { "Create Date" , "FromDate" , "TO" , "Caption" ,
		// "Cat" , "Cat.Name" , "TypeCode" , "PromoName" , "Type" ,
		// "Promocode" , "Code" , "Name" , "CondOn" , "ConFrom" , "condTo" ,
		// "FreeArticle" , "FreeQty" , "Disc%" , "DiscAmt" ,
		// "User" , "Active" , "Target" } ;
		String DBdetail = "Fail";
		prst = null;
		final int batchSize = 5;
		int TotalRecordinsert = 0;
		String varticle = "0";
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		String promocheck = "Update  ms_promo_master  set "
				+ " fromdate = ?   , todate = ?,  purcondFrom = ? , PurcondTo= ? , freeqty = ? , discper = ?,  discamt= ? , active = ? , target = ?  "
				+ "  where Company_code = ?  and  site_code = ?  and  promocode = ?  ";
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con1.prepareStatement(promocheck);
				prst.setString(1, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 1).toString()));// fromdate
				prst.setString(2, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 2).toString()));// todate
				prst.setString(3, (table.getValueAt(k, 13).toString()));// purcongfrom
				prst.setString(4, (table.getValueAt(k, 14).toString()));// Purconfto
				prst.setString(5, (table.getValueAt(k, 16).toString()));// freeqty
				prst.setString(6, (table.getValueAt(k, 17).toString()));// discper
				prst.setString(7, (table.getValueAt(k, 18).toString()));// discamt
				prst.setString(8, (table.getValueAt(k, 20).toString()));// active
				prst.setString(9, (table.getValueAt(k, 21).toString()));// target
				prst.setString(10, vcomp);// compcode
				prst.setString(11, vstore);// storecd
				prst.setString(12, (table.getValueAt(k, 9).toString()));// promocode
				prst.addBatch();
				// new General().msg("PRST"+prst) ;
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
			con1.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				if (DBdetail == "Sucess") {
					con1.commit();
					new gnImageSound().playSound();
					new General().Quickmsg("Data Updated Sucessfully");
					new gnTable().RemoveTableRows(model);
					new gnImageSound().playSound();
				}
				prst.close();
			}
		}

	}

	private void showTable(String SQL) throws ClassNotFoundException, SQLException {

		new gnTable().RemoveTableRows(model);
		String[] col = { "Create Date", "FromDate", "TO", "Caption", "Cat", "Cat.Name", "TypeCode", "PromoName", "Type",
				"Promocode", "Code", "Name", "CondOn", "ConFrom", "condTo", "FreeArticle", "FreeQty", "Disc%",
				"DiscAmt", "User", "Active", "Target" };
		int colno = 22;
		model.setColumnIdentifiers(col);
		table = new gnTableModel().Tablemodel(table, model, SQL, col, colno, "N", "N", "N");
		new gnTable().setTableColWidth(table, 7, 250);
		new gnTable().setTableColWidth(table, 11, 300);
		JViewport prt1 = new JViewport();
		prt1.add(table);
		prt1.setVisible(true);
		jsp.setViewport(prt1);
	}

	private String validate() {
		String status = "Sucess";

		if (from.getText().length() == 0) {
			new General().msg("Enter Promotion Period..");
			status = "Fail";
			from.grabFocus();
		}

		if (to.getText().length() == 0) {
			new General().msg("Enter Promotion Period..");
			status = "Fail";
			to.grabFocus();
		}

		if (createDate.getText().length() == 0) {
			new General().msg("Enter Promotion Period..");
			status = "Fail";
			createDate.grabFocus();
		}

		if (typecode.getText().length() == 0.) {
			new General().msg("Select Promottion Type..");
			status = "Fail";
			promoType.grabFocus();

		}

		if (catcode.getText().length() == 0.) {
			new General().msg("Select Promottion Category..");
			status = "Fail";
			catname.grabFocus();
		}

		if (purchase.getText().equals("0") || purchase.getText().length() == 0 ) {
			new General().msg("Enter Buying Condition ..");
			status = "Fail";
			purchase.grabFocus();
		}

		String vprtype = typecode.getText();
		switch (vprtype) {
		
		case "10":

			if (code.getText().length() == 0) {
				new General().msg("Select Name..");
				name.grabFocus();
				status = "Fail";
			}

			if (purchase.getText().length() == 0 || purchase.getText().equals("0")) {
				new General().Quickmsg("Enter Purchase Condition For How Many Month ? ... ");
				purchase.grabFocus();
				status = "Fail";
			}

			
			
			if (discamt.getText().length() == 0 || discamt.getText().equals("0")) {
				new General().msg("Enter Discount Amount ... ");
				discamt.grabFocus();
				status = "Fail";
			}
            
			if (target.getText().length() == 0 || target.getText().equals("0")) {
				new General().msg("Enter Target Bill Amount Per Month Purchase  ... ");
				target.grabFocus();
				status = "Fail";
			}

			break ;
			
		case "1":
			if (code.getText().length() == 0) {
				new General().msg("Select Name..");
				name.grabFocus();
				status = "Fail";
			}
			if (discper.getText().length() == 0) {
				new General().msg("Enter Discount % ... ");
				discper.grabFocus();
				status = "Fail";
			}
			break;

		case "2":
			if (code.getText().length() == 0) {
				new General().msg("Select Name..");
				name.grabFocus();
				status = "Fail";
			}
			if (discamt.getText().length() == 0) {
				new General().msg("Enter Discount Amount... ");
				discamt.grabFocus();
				status = "Fail";
			}
			break;

		case "3":
			if (from.getText().length() == 0) {
				new General().msg("Enter Purchase Condition ... ");
				from.grabFocus();
				status = "Fail";
			}
			if (to.getText().length() == 0) {
				new General().msg("Enter Purchase Condition ... ");
				to.grabFocus();
				status = "Fail";
			}
			if (discper.getText().length() == 0) {
				new General().msg("Enter Discount % For Bill Level Discount... ");
				discper.grabFocus();
				status = "Fail";
			}
			break;

		case "6":
			if (freearticle.getText().length() == 0) {
				new General().msg("Select Free Article ... ");
				freearticle.grabFocus();
				freearticle.setEditable(true);
				freearticle.setEnabled(true);
				status = "Fail";

			}
			break;

		case "5":
			if (freearticle.getText().length() == 0) {
				new General().msg("Select Free Article ... ");
				freearticle.grabFocus();
				freearticle.setEditable(true);
				freearticle.setEnabled(true);
				status = "Fail";

			}
			break;
		}

		return status;

	}

	private void GenerateSeq() throws Throwable {

		promono.setText(new gnSeq().getSeqno("902", "MS"));
		new General().msg("Promo No is :" + " " + promono.getText());
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			table.setValueAt(promono.getText(), i, 1);
		}
	}

	private void SaveAction() throws Throwable {
		// {"Remove" , 1"PromoNo" ,2 "From" , 3"TO" ,4 "Type" ,
		// 5"Code", 6"Name" , 7"ConditionOn" ,8 "Pur.Conditionfrom" ,9
		// "Pur.Condition to"
		// 10"FreeArticle", 11"FreeQty" , 12"Disc%" 13,"DiscAmt" ,14"Inclusive",
		// 15"Target" , 16"Active" } ;
		GenerateSeq();
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con2 = this.getConnection();
		con2.setAutoCommit(false);
		String Status = "Fail";

		String poshdr = "Insert into Ms_Promo_master( Company_code ,  Site_code , InsertDate,   PromoCaption , "
				+ "PromoCatCode , PromoCategory ,  PromoTypeCode , PromoType , Type , PromoCode , srno ,  code, Name , FromDate ,  "
				+ "ToDate ,  CondtionOn,  purCondFrom ,  purcondTo, FreeArticle,  FreeQty ,  Discper , Discamt ,  "
				+ "IncludeItems ,   TargetValue ,  Active,    User,  UpdateDate, Time, "
				+ "CardType , ServiceProvider, serviceProviderName )"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int row = table.getRowCount();
			for (int i = 0; i < row; i++) {
				prst = con2.prepareStatement(poshdr);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, new gnConfig().date_ConverttoDBforamt(createDate.getText()));
				prst.setString(4, caption.getSelectedItem().toString());
				prst.setString(5, catcode.getText());
				prst.setString(6, catname.getText());
				prst.setString(7, typecode.getText());
				prst.setString(8, promoType.getText());
				prst.setString(9, table.getValueAt(i, 4).toString());
				prst.setString(10, table.getValueAt(i, 1).toString());
				prst.setInt(11, i);
				prst.setString(12, table.getValueAt(i, 5).toString());
				prst.setString(13, table.getValueAt(i, 6).toString());
				prst.setString(14, new gnConfig().date_ConverttoDBforamt(table.getValueAt(i, 2).toString()));
				prst.setString(15, new gnConfig().date_ConverttoDBforamt(table.getValueAt(i, 3).toString()));
				prst.setString(16, table.getValueAt(i, 7).toString());
				prst.setString(17, table.getValueAt(i, 8).toString());
				prst.setString(18, table.getValueAt(i, 9).toString());
				prst.setString(19, table.getValueAt(i, 10).toString());
				prst.setString(20, table.getValueAt(i, 11).toString());
				prst.setString(21, table.getValueAt(i, 12).toString());
				prst.setString(22, table.getValueAt(i, 13).toString());
				prst.setString(23, table.getValueAt(i, 14).toString());
				prst.setString(24, table.getValueAt(i, 15).toString());
				prst.setString(25, table.getValueAt(i, 16).toString());
				prst.setString(26, new gnConfig().getUsercode());
				prst.setString(27, "0000.00.00");
				prst.setString(28, new General().getTime());
				prst.setString(29, " ");
				prst.setString(30, " ");
				prst.setString(31, " ");
				prst.addBatch();
				// new General().msg("PRST"+""+prst);
				TotalRecordinsert = TotalRecordinsert + 1;
				DBhdr = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBhdr = "Sucess";
				}
			} // for
		} catch (SQLException e) {
			new General().msg("Promo Insert Error" + e.getMessage());
			con2.rollback();
			DBhdr = "Fail";
		} finally {
			if (DBhdr == "Sucess") {
				con2.commit();
				con2.close();
				this.closeconn();
				new General().msg("Data Saved Sucessfully...");
				reset();
				new gnSeq().updateSeqno("902", "MS");
			}
			if (prst != null) {
				prst.close();
			}
		}
	}

	private void checkAddbtnvisiblity() {
		switch (typecode.getText()) {
		case "4":
			btnAdd.setEnabled(true);
			break;
		case "5":
			btnAdd.setEnabled(true);
			break;
		case "12":
			btnAdd.setEnabled(true);
			break;
		}
	}

	private void addRecord() {
		String Col[] = { "Remove", "PromoNo", "From", "TO", "Type", "Code", "Name", "ConditionOn", "Pur.Cond.From",
				"Pur.Cond.TO", "FreeArticle", "FreeQty", "Disc%", "DiscAmt", "Inclusive", "Target", "Active" };

		String vcondition = condition.getSelectedItem().toString();
		String vincl = inclusive.getSelectedItem().toString();
		String vactive = "Y";
		model.setColumnIdentifiers(Col);
		model.addRow(new Object[] { "", "0", from.getText(), to.getText(), type.getText(), code.getText(),
				name.getText(), vcondition, purchase.getText(), purchaseto.getText(), freearticle.getText(),
				freeqty.getText(), discper.getText(), discamt.getText(), vincl, target.getText(), "Y" });
		table.setModel(model);
		new gnTable().setTableBasics(table);
		table.setRowHeight(30);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setGridColor(Color.orange);
		removeRow(model, table);
		new gnTable().setTableColWidth(table, 6, 300);
		JViewport prt1 = new JViewport();
		prt1.add(table, Col);
		prt1.setVisible(true);
		jsp.setViewport(prt1);
		SelectArticlerow();
	}

	public void SelectArticlerow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 4);
				try {

					switch (value) {
					case "Article":
						String varticle = (String) table.getValueAt(row, 5);
						String vvarticlename = (String) table.getValueAt(row, 6);
						varticlecode = varticle;
						varticlename = vvarticlename;
						Artilce_otherInfo window = new Artilce_otherInfo();
						window.ArticleViewFrame.setVisible(true);
					}

				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				new General().msgDispose();
			}
		});
	}

	private void showname() throws Throwable {
		String vname = "";
		String vtype = type.getText().trim();
		switch (vtype) {

		case "Month":
			vname = "Brand";
			String vsearch = name.getText();
			vmastersearchString = "%" + vsearch + "%";
			new gnAdmin().showMasterTable(vname, code, name);
			break;
			
		
		case "Article-SplRate":
			vname = "%" + vname + "%";
			new gnAdmin().articleNameSearch(vname, code, name);
			switch (typecode.getText()) {
			case "5":
				freearticle.setText(code.getText());
				freearticle.setEnabled(false);
				break;
			}
			break;

		case "Article":
			vname = name.getText();
			vname = "%" + vname + "%";
			new gnAdmin().articleNameSearch(vname, code, name);
			switch (typecode.getText()) {
			case "5":
				freearticle.setText(code.getText());
				freearticle.setEnabled(false);
				break;
			}
			break;

		case "Brand":
			vname = "Brand";
			vsearch = name.getText();
			vmastersearchString = "%" + vsearch + "%";
			new gnAdmin().showMasterTable(vname, code, name);
			break;

		case "Category":
			vname = "Category";
			String vvsearch = name.getText();
			vmastersearchString = "%" + vvsearch + "%";
			try {
				new gnHierarchy().getHierarchyInfo(vname, vmastersearchString);
			} catch (Exception e) {
				new General().msg(e.getLocalizedMessage());
			} finally {
				code.setText(new gnHierarchy().code);
				name.setText(new gnHierarchy().name);
			}
			break;

		case "SubCategory":
			vname = "SubCategory";
			vvsearch = name.getText();
			vmastersearchString = "%" + vvsearch + "%";
			try {
				new gnHierarchy().getHierarchyInfo(vname, vmastersearchString);
			} catch (Exception e) {
				new General().msg(e.getLocalizedMessage());
			} finally {
				code.setText(new gnHierarchy().code);
				name.setText(new gnHierarchy().name);
			}
			break;

		}

		purchase.grabFocus();
	}

	private void nameDisable() {
		code.setText("0");
		name.setText("N/A");
		code.setEnabled(false);
		name.setEnabled(false);
		type.setEnabled(false);
	}

	private void nameEnable() {
		code.setText("");
		name.setText("");
		code.setEnabled(false);
		name.setEnabled(true);
		type.setEnabled(false);

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
					}
					return;
				}
			}
		});
	}

	private void reset() {
		target.setText("0");
		promoType.setEnabled(true);
		catname.setEnabled(true);
		new gnTable().RemoveTableRows(model);
		name.setText("");
		purchase.setText("0");
		purchaseto.setText("0");
		discper.setText("0");
		discamt.setText("0");
		target.setText("");
		freearticle.setText("0");
		freeqty.setText("0");
		code.setText("0");

	}
}// Last

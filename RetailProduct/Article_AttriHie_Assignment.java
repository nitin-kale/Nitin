package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.mysql.jdbc.Connection;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import javax.swing.JSlider;

public class Article_AttriHie_Assignment extends getResultSet {

	JFrame ArticleAttrHieFrame;
	private JTextField companycode;
	private JTextField Companyname;
	private String vcomp;
	JTabbedPane tabpane;
	private String vstore;
	private String vcompname;
	private String vrole;
	JScrollPane bjsp;
	JComboBox location;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
	private Connection con1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_2;
	private JTextField name;
	private JLabel lblNewLabel_3;
	private JLabel choicename;
	private JTextField assignname;
	private JTextField assigncode;
	private JButton btnAssign;
	private JScrollPane jsp;
	private String vchoice;
	private String SQL;
	private JButton btnUpdate;

	private String vcode;
	private String vname;
	private String vbrand;
	private String vcategory;
	private String vsubcat;
	private String vgroup;
	private String vsubgroup;

	private DefaultTableModel bmodel = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 2 || column == 3 || column == 4 ? true : false;
		}
	};

	private JTable btable = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 2 || column == 3 || column == 4) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setFont(new Font("Calibri", Font.BOLD, 12));
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 12));
			}
			return componentt;
		}
	};

	///

	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 1 || column == 2 || column == 3) {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			} else {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setFont(new Font("Calibri", Font.BOLD, 15));
			}
			return componentt;
		}
	};
	private String[] col = { "Remove", "Article Code", "Name", "Short Name", "UOM", "SalesPrice", "MRP", "Cost",
			"Tax code" };
	private JButton btnAssigntoLine;
	private JButton btnClose;
	private JButton btnNewBrad;
	private JTextField scanitem;
	private JTextField bitemcode;
	private JTextField bsearchname;
	private JLabel lblNewLabel_7;
	private JButton BtnExpport;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Article_AttriHie_Assignment window = new Article_AttriHie_Assignment();
					window.ArticleAttrHieFrame.setVisible(true);
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
	public Article_AttriHie_Assignment() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		ArticleAttrHieFrame = new JFrame();
		ArticleAttrHieFrame.getContentPane().setBackground(Color.WHITE);
		ArticleAttrHieFrame.setAlwaysOnTop(true);
		ArticleAttrHieFrame.setBounds(1, 100, 1350, 600);
		
		ArticleAttrHieFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ArticleAttrHieFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Update Article Inforation");
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setBounds(966, 5, 317, 25);
		ArticleAttrHieFrame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBorder(new LineBorder(new Color(204, 255, 204), 0, true));
		panel.setBounds(0, 30, 1320, 142);
		// ArticleAttrHieFrame.getContentPane().add(panel);
		panel.setLayout(null);
		ActionListener nm = new nameLsnr();

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBorder(new TitledBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)),
				"Select For Assignment", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_2.setBounds(538, 0, 771, 113);
		panel.add(panel_2);
		panel_2.setLayout(null);

		ActionListener rb = new rbLsnr();

		rb1 = new JRadioButton("Brand");
		rb1.setBackground(Color.WHITE);
		buttonGroup.add(rb1);
		rb1.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		rb1.setForeground(Color.BLACK);
		rb1.addActionListener(rb);
		rb1.setBounds(8, 33, 74, 18);
		panel_2.add(rb1);

		rb2 = new JRadioButton("Hierarchy");
		rb2.setBackground(Color.WHITE);
		buttonGroup.add(rb2);
		rb2.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		rb2.setForeground(Color.BLACK);
		rb2.addActionListener(rb);
		rb2.setBounds(8, 56, 103, 18);
		panel_2.add(rb2);

		// btnNewBrad = new JButton("New");
		btnNewBrad = new gnRoundButton("New");
		btnNewBrad.setFont(new Font("Segoe Script", Font.PLAIN, 13));
		btnNewBrad.setBounds(87, 32, 74, 25);
		panel_2.add(btnNewBrad);

		rb3 = new JRadioButton("Tax Slab");
		rb3.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		rb3.setBackground(Color.WHITE);
		rb3.setForeground(Color.BLACK);
		buttonGroup.add(rb3);
		rb3.addActionListener(rb);
		rb3.setBounds(8, 79, 103, 25);
		panel_2.add(rb3);

		lblNewLabel_3 = new JLabel("Assign");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(178, 34, 55, 24);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.DARK_GRAY);

		choicename = new JLabel("choice");
		choicename.setBounds(231, 35, 191, 23);
		panel_2.add(choicename);
		choicename.setForeground(Color.DARK_GRAY);
		choicename.setFont(new Font("Segoe UI", Font.PLAIN, 16));

		assignname = new JTextField();
		assignname.setBounds(178, 56, 259, 28);
		panel_2.add(assignname);
		assignname.setFont(new Font("Segoe UI", Font.BOLD, 13));
		assignname.setColumns(10);

		assigncode = new JTextField();
		assigncode.setBounds(434, 56, 45, 28);
		panel_2.add(assigncode);
		assigncode.setForeground(Color.WHITE);
		assigncode.setBackground(Color.WHITE);
		assigncode.setEditable(false);
		assigncode.setColumns(10);

		// btnAssigntoLine = new JButton("Assign To Selected Item");
		btnAssigntoLine = new gnRoundButton("Assign To Selected Item");
		btnAssigntoLine.setForeground(new Color(0, 102, 153));
		btnAssigntoLine.setBackground(new Color(51, 255, 204));
		btnAssigntoLine.setBounds(513, 15, 233, 28);
		panel_2.add(btnAssigntoLine);
		btnAssigntoLine.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		btnAssigntoLine.setMnemonic('I');

		// btnAssign = new JButton("Assign to All");
		btnAssign = new gnRoundButton("Assign  to All");
		btnAssign.setForeground(new Color(0, 102, 153));
		btnAssign.setBackground(new Color(51, 255, 204));
		btnAssign.setBounds(513, 52, 233, 28);
		panel_2.add(btnAssign);
		btnAssign.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		btnAssign.setMnemonic('A');

		JLabel lblNewLabel_8 = new JLabel("Click Option to uopdate Data");
		lblNewLabel_8.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(9, 8, 203, 16);
		panel_2.add(lblNewLabel_8);

		ActionListener btn = new btnLsnr();
		btnNewBrad.addActionListener(btn);

		JPanel batchPanel = new JPanel();
		batchPanel.setBackground(Color.WHITE);
		batchPanel.setBounds(604, 44, 285, 81);

		tabpane = new JTabbedPane(JTabbedPane.TOP);
		tabpane.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		tabpane.setForeground(new Color(102, 102, 153));
		tabpane.setBackground(Color.WHITE);
		tabpane.setBounds(0, 37, 1326, 525);
		ArticleAttrHieFrame.getContentPane().add(tabpane);
		tabpane.add("Brand & Hierarchy", panel);
		tabpane.add("Batch Price Edit", batchPanel);
		batchPanel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.WHITE);
		panel_3.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(102, 255, 153)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 0, 1321, 98);
		batchPanel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Scan Article");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(38, 13, 89, 16);
		panel_3.add(lblNewLabel_5);

		// bitemcode = new JTextField();
		bitemcode = new gnRoundTextField(20);
		bitemcode.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bitemcode.setBounds(132, 10, 270, 30);
		panel_3.add(bitemcode);
		bitemcode.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Search By Name");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setBounds(12, 50, 115, 16);
		panel_3.add(lblNewLabel_6);

		// bsearchname = new JTextField();
		bsearchname = new gnRoundTextField(20);
		bsearchname.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		bsearchname.setBounds(132, 47, 270, 30);
		panel_3.add(bsearchname);
		bsearchname.setColumns(10);

		// JButton btnbatchUpdate = new JButton("Update Batch Details")
		JButton btnbatchUpdate = new gnRoundButton("Update Batch Details");
		btnbatchUpdate.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnbatchUpdate.setMnemonic('B');
		btnbatchUpdate.setForeground(Color.WHITE);
		btnbatchUpdate.setBackground(new Color(0, 0, 102));
		btnbatchUpdate.setBounds(1083, 43, 226, 37);
		panel_3.add(btnbatchUpdate);

		lblNewLabel_7 = new JLabel("Select Loction ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setForeground(new Color(51, 0, 0));
		lblNewLabel_7.setBounds(436, 24, 123, 16);
		panel_3.add(lblNewLabel_7);

		location = new JComboBox();
		location.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		location.setBounds(436, 45, 141, 30);
		panel_3.add(location);

		bjsp = new JScrollPane();
		bjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		bjsp.setBounds(0, 99, 1309, 303);
		batchPanel.add(bjsp);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(12, 142, 1297, 269);
		panel.add(jsp);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 10, 514, 100);
		panel.add(panel_1);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)));
		panel_1.setLayout(null);

		lblNewLabel_2 = new JLabel("Search Items By Name");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblNewLabel_2.setBounds(12, 55, 147, 16);
		panel_1.add(lblNewLabel_2);

		// name = new JTextField();
		name = new gnRoundTextField(20);

		name.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		name.setBounds(171, 46, 250, 30);
		name.addActionListener(nm);
		panel_1.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Scan Item Here");
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(46, 20, 113, 16);
		panel_1.add(lblNewLabel_4);

		// scanitem = new JTextField()
		scanitem = new gnRoundTextField(20) {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		scanitem.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));

		scanitem.setBounds(171, 13, 250, 30);
		panel_1.add(scanitem);
		scanitem.setColumns(10);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(954, 112, 90, 28);
		panel.add(btnUpdate);
		btnUpdate.setForeground(new Color(0, 0, 153));
		btnUpdate.setFont(new Font("Calibri", Font.BOLD, 15));
		btnUpdate.setMnemonic('U');

		btnClose = new JButton("Close");
		btnClose.setBounds(1047, 110, 90, 33);
		panel.add(btnClose);
		btnClose.setForeground(new Color(0, 0, 153));
		btnClose.setFont(new Font("Calibri", Font.BOLD, 15));

		BtnExpport = new JButton("Export");
		BtnExpport.setBounds(1141, 110, 168, 33);
		panel.add(BtnExpport);
		BtnExpport.setMnemonic('E');
		BtnExpport.addActionListener(btn);
		btnClose.addActionListener(btn);

		JLabel lblNewLabel_1 = new JLabel("Company");
		lblNewLabel_1.setBounds(12, 11, 70, 16);
		ArticleAttrHieFrame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.BLACK);

		companycode = new JTextField();
		companycode.setBounds(88, 6, 73, 28);
		ArticleAttrHieFrame.getContentPane().add(companycode);
		companycode.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		companycode.setForeground(Color.BLACK);
		companycode.setBackground(Color.WHITE);
		companycode.setEditable(false);
		companycode.setColumns(10);

		Companyname = new JTextField();
		Companyname.setBounds(158, 6, 368, 28);
		ArticleAttrHieFrame.getContentPane().add(Companyname);
		Companyname.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		Companyname.setForeground(Color.BLACK);
		Companyname.setBackground(Color.WHITE);
		Companyname.setEditable(false);
		Companyname.setColumns(10);

		ActionListener asgn = new assignLsnr();
		ActionListener immls = new itemLsnr();

		btnAssign.addActionListener(btn);
		btnAssigntoLine.addActionListener(btn);
		assignname.addActionListener(asgn);
		btnUpdate.addActionListener(btn);
		scanitem.addActionListener(immls);

		ActionListener bitcode = new bitemLsnr();
		bitemcode.addActionListener(bitcode);

		ActionListener batchupd = new updateBatchLsnr();
		btnbatchUpdate.addActionListener(batchupd);

		decorate();

	}

	class updateBatchLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				updateBatchDetails();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class bitemLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vname = bitemcode.getText();
			try {
				showArticleBatchData(vname);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class bnameLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String status = validanameentry();
			if (status == "Sucess") {
				String vname = bsearchname.getText();
				vname = "%" + vname + "%";
			}
		}
	}

	private void updateBatchDetails() throws Throwable {
		String vstore = new gnConfig().getStoreID();
		String vverticlecode = new gnHierarchy().getVerticleCode();
		String vfinyear = new gnFinYear().getReportingFinYear();

		String vcode = "";
		String vbatchno = "";
		String vmrp = "";
		String vsp = "";
		String vcost = "";
		String vlocation = location.getSelectedItem().toString();
		int row = btable.getRowCount();
		if (row > 0) {
			// {"Article", "Name", "Pur.Price" , "MRP" , "SalesPrice" ,
			// "BatchNo", "Stock" , "ExpiryDate"} ;

			for (int i = 0; i < row; i++) {
				vcode = btable.getValueAt(i, 0).toString();
				vbatchno = btable.getValueAt(i, 5).toString();
				vcost = btable.getValueAt(i, 2).toString();
				vmrp = btable.getValueAt(i, 3).toString();
				vsp = btable.getValueAt(i, 4).toString();
				vverticlecode = vbatchno;
				String vtype = "UpdateBatchForArticle";
				String SQL = "Call batch_getInfo('" + vtype + "'  , " + vcomp + ", '" + vstore + "' ,   " + vcode
						+ ",  '" + vfinyear + "', " + vverticlecode + " , " + vmrp + " , " + vsp + ", " + vcost + " , '"
						+ vlocation + "')";
				// new General().msg(SQL);
				this.getResult(SQL);
			}
		}
		new General().msg("Records Updated sucessfully ..");
		new gnTable().RemoveTableRows(bmodel);

	}

	private void showArticleBatchData(String vcode) throws Throwable {
		new gnTable().RemoveTableRows(bmodel);
		String colitem[] = { "Article", "Name", "Pur.Price", "MRP", "SalesPrice", "BatchNo", "Stock", "ExpiryDate" };
		bmodel.setColumnIdentifiers(colitem);
		btable.setModel(bmodel);
		String vstore = new gnConfig().getStoreID();
		String vverticlecode = new gnHierarchy().getVerticleCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vmrp = "0";
		String vcost = "0";
		String vsp = "0";
		String vlocation = location.getSelectedItem().toString();
		String vtype = "ALLBATCHOFARTICLE";
		String SQL = "Call batch_getInfo('" + vtype + "'  , " + vcomp + ", '" + vstore + "' ,   " + vcode + ",  '"
				+ vfinyear + "', " + vverticlecode + " , " + vmrp + " , " + vsp + ", " + vcost + " , '" + vlocation
				+ "')";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			bmodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
		}
		btable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		if (btable.getRowCount() > 0) {
			new gnTable().setTablewidth(btable, 1, 700);
			new gnTable().setTablewidth(btable, 2, 100);
			new gnTable().setTablewidth(btable, 3, 100);
			new gnTable().setTablewidth(btable, 4, 100);
			new gnTable().setTablewidth(btable, 5, 100);
			new gnTable().setTablewidth(btable, 6, 100);
			new gnTable().setTablewidth(btable, 7, 100);
			new gnTable().setTableBasics(btable);
			btable.setRowHeight(30);
			new gnFontSetting().setMyFontBold(btable, "F1", 14);
		}
		JViewport prt1 = new JViewport();
		prt1.setBackground(new Color(204, 255, 255));
		prt1.add(btable, colitem);
		prt1.setVisible(true);
		bjsp.setViewport(prt1);

	}

	private void decorate() throws Throwable {

		
		ArticleAttrHieFrame.setUndecorated(true);
		
		new gnDecorate().decorateBtn(BtnExpport, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnClose, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnAssigntoLine, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnAssign, Color.darkGray, Color.WHITE);

		new gnDecorate().DispField_Eatch(assigncode, 12);
		new gnDecorate().DispField_Eatch(assignname, 12);
		new gnDecorate().DispField_Eatch(name, 12);
		new gnDecorate().DispField_Eatch(Companyname, 12);
		new gnDecorate().DispField_Eatch(companycode, 10);

		String vmsname = "Location";
		String verticle = new gnHierarchy().getVerticleCode();
		String Search = "%%";
		String SQL1 = "call master_getMasterData('" + vmsname + "' , " + verticle + "    , '" + Search + "')";
		new gnComp().fillCombo(SQL1, location);

		vrole = new gnConfig().getRoleName();
		vcomp = new gnConfig().getCompanyCode();
		vcompname = new gnConfig().getCompany();
		companycode.setText(vcomp);
		Companyname.setText(vcompname);
		if (vcomp == "0") {
			ArticleAttrHieFrame.dispose();
			name.setEnabled(false);
			assignname.setEnabled(false);
			assigncode.setEnabled(false);
		}
		if (vrole.toUpperCase() != "MANAGER") {
			ArticleAttrHieFrame.dispose();

		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			// new General().msg(value);

			if (value == "New") {
				try {
					// createBrand window;
					// window = new createBrand();
					// window.frameBrand.setVisible(true);
					CreateGeneralMaster window = new CreateGeneralMaster();
					window.masterFrame.setVisible(true);

				} catch (Throwable e1) {
					e1.printStackTrace();
				}

			}

			if (value == "Export") {
				// new General().msg("Exporting Data Now ..");
				new Export_Table_Data_to_Excel().exportTable(table);
			}

			if (value == "Assign To Selected Item") {
				assignToRow();
			}
			if (value == "Assign  to All") {
				assignToAll();
			}

			if (value == "Update") {
				try {
					UpdateRecords();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Close") {
				ArticleAttrHieFrame.dispose();
			}

		}
	}

	private String validanameentry() {
		String status = "Sucess";
		String vname = name.getText();
		if (vname.length() <= 3) {
			new General().msg("Please Enter Search Name at leat 4 chars..");
			status = "Fail";
			name.grabFocus();
		}
		return status;

	}

	class nameLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String status = validanameentry();
			if (status == "Sucess") {
				String vname = name.getText();
				vname = "%" + vname + "%";
				try {
					String vtype = "Brand";
					showArticleData(vname, vtype);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class rbLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			switch (value) {
			case "Tax Slab":
				vchoice = "3";
				choicename.setText("Tax Slab Applicable");
				break;
			case "Brand":
				vchoice = "1";
				choicename.setText("Brand");
				break;
			case "Hierarchy":
				vchoice = "2";
				choicename.setText("Hierarchy");
				choicename.setForeground(Color.WHITE);
				break;
			}
		}
	}

	class assignLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			showchoice();
		}
	}

	private void showchoice() {
		String sname = assignname.getText();
		sname = "%" + sname + "%";
		switch (vchoice) {

		case "3":
			try {
				// new gnBrand().getBrandInfo(sname);
				String vtype = "TaxSlab";
				vmastersearchString = "%" + assignname.getText() + "%";
				new gnAdmin().showMasterTable(vtype, assigncode, assignname);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {

			}
			break;

		case "1":
			try {
				// new gnBrand().getBrandInfo(sname);
				String vtype = "Brand";
				vmastersearchString = "%" + assignname.getText() + "%";
				new gnAdmin().showMasterTable(vtype, assigncode, assignname);

			} catch (Throwable e) {
				e.printStackTrace();
			} finally {

			}
			break;

		case "2":
			try {
				String vvhno = new gnHierarchy().getmySiteHierarchyNo();
				String vverticle = new gnHierarchy().getVerticleCode();
				String vsegment = new gnHierarchy().getSegmentCode();
				// new gnHierarchy().showArticleHierarchy(sname, vvhno,
				// vsegment, vverticle);
				new gnHierarchy().showArticleHierarchy(sname);

			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				vcode = new gnHierarchy().code;
				vname = new gnHierarchy().name;
				assignname.setText(vname);
				assigncode.setText(vcode);
				vsubcat = vcode;
				vcategory = new gnHierarchy().vArticle_category;
				vgroup = new gnHierarchy().vArticle_group;
				vsubgroup = new gnHierarchy().vArticle_subGroup;
				// new General().msg("before Retrurn Value :"+ " "+ new
				// gnHierarchy().vArticle_subGroup);
				// new General().msg("Retrurn Value :"+ " "+vsubgroup);

			}
			break;
		}
	}

	private void assignToRow() {
		int row = table.getSelectedRow();
		int i = 0;
		switch (vchoice) {

		case "1":
			table.setValueAt(assigncode.getText(), row, 8);
			table.setValueAt(assignname.getText(), row, 21);
			break;

		case "2":
			table.setValueAt(vcategory, row, 9);
			table.setValueAt(vsubcat, row, 10);
			table.setValueAt(vgroup, row, 11);
			table.setValueAt(vsubgroup, row, 12);
			table.setValueAt(assignname.getText(), row, 22);
			break;

		case "3":
			table.setValueAt(assigncode.getText(), row, 20);
			break;

		}

	}

	private void assignToAll() {
		int row = table.getRowCount();
		int i = 0;
		switch (vchoice) {
		case "1":
			for (i = 0; i < row; i++) {
				table.setValueAt(assigncode.getText(), i, 8);
				table.setValueAt(assignname.getText(), i, 21);
			}
			break;

		case "2":
			for (i = 0; i < row; i++) {
				table.setValueAt(vcategory, i, 9);
				table.setValueAt(vsubcat, i, 10);
				table.setValueAt(vgroup, i, 11);
				table.setValueAt(vsubgroup, i, 12);
				table.setValueAt(assignname.getText(), i, 22);
			}
			break;

		case "3":
			for (i = 0; i < row; i++) {
				table.setValueAt(assigncode.getText(), i, 20);
			}
			break;
		}

	}

	class itemLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vname = scanitem.getText();
			String vtype = "brandAssign";
			try {
				showArticleData(vname, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void showArticleData(String vname, String vtype) throws ClassNotFoundException, SQLException {

		new gnTable().RemoveTableRows(model);
		String colitem[] = { "Article", "Name", "POSName", "Uom", "SalesPrice", "MRP", "Cost", "Tax", "Brand",
				"Category", "SubCategory", "Group", "SubGroup", "MBQ", "InnerPack", "Trading Article", "BatchArticle",
				"EANItem", "Class", "MrpBase", "ApplyTaxSlab", "BrandName", "SubGroup" };
		model.setColumnIdentifiers(colitem);
		table.setModel(model);
		// String vtype = "Brand" ;
		String vverticlecode = new gnHierarchy().getVerticleCode();
		String SQL = "Call  article_getDataForupdate('" + vtype + "'  ,  " + vcomp + ", '" + vname + "' , "
				+ vverticlecode + ")";

		rs = this.getSPResult(SQL);
		while (rs.next()) {

			model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
					rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),
					rs.getString(20), rs.getString(21), rs.getString(22), rs.getString(23) });
		}

		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 1, 30);
			new gnTable().setTablewidth(table, 2, 300);
			new gnTable().setTablewidth(table, 3, 300);
			new gnTable().setTablewidth(table, 4, 50);
			new gnTable().setTableBasics(table);
		}
		JViewport prt = new JViewport();
		prt.setBackground(new Color(204, 255, 255));
		prt.add(table, colitem);
		prt.setVisible(true);
		jsp.setViewport(prt);

	}

	public void UpdateRecords() throws Throwable {
		// new General().msg("Updating Records...");
		String DBdetail = "Fail";
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		String varticle = "0";

		// String colitem[] = {0"Article", 1"Name", 2"POSName", 3"Uom",
		// 4"SalesPrice",
		// 5"MRP", 6"Cost" ,7"Tax", 8"Brand", 9"Category" ,
		// 10"SubCategory" , 11"Group", 12"SubGroup", 13"MBQ", 14"InnerPack",
		// 15"Trading Article", 16"BatchArticle", 17"EANItem", 18"Class",
		// 19"MrpBase"} ;

		con1 = (Connection) this.getConnection();
		con1.setAutoCommit(false);
		String article = "Update  msArticle_master  set "
				+ "Name=? ,   pos_name = ? ,  UOM=? ,  SalesPrice = ?  , mrp = ?  , " // 1
				+ "cost = ? ,    Tax_code = ? ,   Tax_Per = ?  , "
				+ "brand  = ? , Article_category = ? , Article_subCategory = ? , Article_group  = ? ,"
				+ "Article_SubGroup  = ? , mbq  = ? , Inner_Pack_qty = ? , Trading_Article = ?, "
				+ "Batch_control_Article = ?   , Article_Class  = ?, MRPBaseArticle = ? , ApplyTaxSlab = ? ,  brandName =? , subCatname = ? "
				+ " where Company_code = ?   and  article_code = ?";

		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				varticle = table.getValueAt(k, 0).toString();
				prst = con1.prepareStatement(article);
				prst.setString(1, (table.getValueAt(k, 1).toString()));
				prst.setString(2, (table.getValueAt(k, 2).toString()));
				prst.setString(3, (table.getValueAt(k, 3).toString()));
				prst.setString(4, (table.getValueAt(k, 4).toString()));
				prst.setString(5, (table.getValueAt(k, 5).toString()));
				prst.setString(6, (table.getValueAt(k, 6).toString()));
				prst.setString(7, (table.getValueAt(k, 7).toString()));
				prst.setString(8, (table.getValueAt(k, 7).toString()));
				prst.setString(9, (table.getValueAt(k, 8).toString()));
				prst.setString(10, (table.getValueAt(k, 9).toString()));
				prst.setString(11, (table.getValueAt(k, 10).toString()));
				prst.setString(12, (table.getValueAt(k, 11).toString()));
				prst.setString(13, (table.getValueAt(k, 12).toString()));
				prst.setString(14, (table.getValueAt(k, 13).toString()));
				prst.setString(15, (table.getValueAt(k, 14).toString()));
				prst.setString(16, (table.getValueAt(k, 15).toString()));
				prst.setString(17, (table.getValueAt(k, 16).toString()));
				// prst.setString(18, (table.getValueAt(k, 17).toString())) ;
				prst.setString(18, (table.getValueAt(k, 18).toString()));
				prst.setString(19, (table.getValueAt(k, 19).toString()));

				prst.setString(20, (table.getValueAt(k, 20).toString()));
				prst.setString(21, (table.getValueAt(k, 21).toString()));
				prst.setString(22, (table.getValueAt(k, 22).toString()));

				prst.setString(23, vcomp);
				prst.setString(24, varticle);
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
				prst.close();
			}
			if (DBdetail == "Sucess") {
				con1.commit();
				syncStockArticle();
				new General().msg("Data Updated Sucessfully");
				new gnTable().RemoveTableRows(model);
			}
		}
	}

	private void syncStockArticle() throws Throwable {
		// Only Insert Selected Records in Sales Price able

		// "Article", "Name", "POSName", "Uom", "SalesPrice",
		// "MRP", "Cost" ,"Tax","Brand", "Category" ,
		// "SubCategory" , "Group", "SubGroup", "MBQ","InnerPack",
		// "Trading Article","BatchArticle", "EANItem","Class", "MrpBase" ,
		// "ApplyTaxSlab" , "BrandName" , "SubGroup"} ;

		String vloc = "SL";
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();

		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			String varticle = table.getValueAt(i, 0).toString();
			String vmrp = table.getValueAt(i, 6).toString();
			String vcost = table.getValueAt(i, 7).toString();
			String vSP = table.getValueAt(i, 5).toString();
			String vtax = table.getValueAt(i, 8).toString();
			String VLC = "0";
			if (vcost.length() > 0 & vtax.length() > 0) {
				VLC = new gnMath().getLandingCost(vcost, vtax);
			}

			String vverticle = new gnHierarchy().getVerticleCode();
			String vgrnDate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
			new ApplySalesPrice_Action().SalesPriceInsert(vstore, varticle, vgrnDate, vmrp, vSP, vcost, vcomp,
					vverticle, VLC);
		}

		// End Sales Price Update

		// new General().msg(vstore);
		// String vverticlecode = new
		// getConfigurationSetting().getVerticleCode(new
		// gnPublicVariable().vcomp,new gnPublicVariable().vstore);
		// String SQL7 = "call SalesPrice_updateInsert("+vcomp+", "+vstore+" ,
		// "+vverticlecode+")" ;
		// this.getSPResult(SQL7) ;

		// Sync Stock in Tablle for Article master
		// String SQL5 = "call Stock_syncStockArticle("+vcomp+", '"+vloc+"')";
		// this.getSPResult(SQL5) ;
		// Sync Stock in Tablle for Article master

		// Sync Ean Master Table
		// String SQL55 = "call EAN_InsertEan("+vcomp+")";
		// this.getSPResult(SQL55) ;

	}
}// Last

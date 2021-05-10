package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.mysql.jdbc.Connection;
import javax.swing.ImageIcon;

public class stockVoucher extends getResultSet {

	JFrame stockVoucherFrame;
	private Connection con, con1, con2, con3, con4, con5, con6, con7, con8;
	private JTextField sitecode;
	private String vfinyear;
	private String DBdetail;
	private String EntryCheck;
	private String vallow;
	private JButton btnShow;
	private JTextField scstatus;
	private JButton btnVariance;
	private String DBhdr;
	private JTextField sitename;
	private JTextField scno;
	private JTextField scno_1;
	private JTextField scdate;
	private JTextField records;
	private JTextField scanitem;
	private JTextField searchname;
	private JTextField searchbrand;
	private JTextField companycode;
	private JTextField companyname;
	private JTextField locationname;
	private JComboBox combobatch;
	private int selectedrow;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnClose;
	private JPanel optionPanel;
	private JTextField showname;

	//// save and update Fields
	private String vcomp;
	private String vstore;
	private String vscno;
	private String vscdate;
	private String vlocation;
	private String vupdatedate;
	private String vcreatedate;
	private String vcreatedby;
	private String vupdatedby;
	private String vstatus;
	private JComboBox location;
	public JInternalFrame internalFrame;
	/// Article Model

	String articlecol[] = { "Remove", "Article code", "Name", "Physical Qty", "UOM", "Batch Control", "Batch No",
			" Manuf. Date", "Batch.Exp.Date", "Cost", "Mrp", "SalesPrice", "Location" };
	JScrollPane jsp = new JScrollPane();

	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) { // 0 3 4 5 7 8 13
																// 14 15
																// 0 3 6 7 8 9
																// 10 11
			return column == 0 || column == 3 || column == 6 || column == 7 || column == 8 || column == 9
					|| column == 10 || column == 11 ? true : false;
		}
	};
	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);

			if (getValueAt(roww, 5).toString().equalsIgnoreCase("N")) {
				componentt.setBackground(Color.cyan);
			} else if (getValueAt(roww, 5).toString().equalsIgnoreCase("Y")) {
				componentt.setBackground(Color.GREEN);
			}

			if (column == 0 || column == 3 || column == 6 || column == 7 || column == 8 || column == 9 || column == 10
					|| column == 11) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
			}
			return componentt;
		}
	};

	// BAtch Related
	DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	String batch[] = { "BatchArticlce", "Item Code", "name", "cost", "SalesPrice", "Mrp", "Batchno", "Manuf_date",
			"Exp.Date" };
	JScrollPane sjsp = new JScrollPane();

	///
	//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					stockVoucher window = new stockVoucher();
					window.stockVoucherFrame.setVisible(true);
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
	public stockVoucher() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		stockVoucherFrame = new JFrame();
		stockVoucherFrame.getContentPane().setBackground(Color.WHITE);
		stockVoucherFrame.setTitle("Business Application");
		stockVoucherFrame.setAutoRequestFocus(false);
		stockVoucherFrame.setAlwaysOnTop(true);
		stockVoucherFrame.getContentPane().setForeground(Color.GREEN);
		stockVoucherFrame.setBounds(1, 100, 1376, 600);
		stockVoucherFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		stockVoucherFrame.getContentPane().setLayout(null);

		ActionListener article = new lsarticlecode();
		ActionListener batch = new showbyBatchControl();
		ActionListener nam = new showbyname();
		ActionListener exp = new btn();
		ActionListener varince = new btn();

		/*
		 * internalFrame = new JInternalFrame(
		 * "Stock check Module- Physical Stock Entry ");
		 * internalFrame.setBounds(0, 0, 1360, 728);
		 * stockVoucherFrame.getContentPane().add(internalFrame);
		 * stockVoucherFrame.getContentPane().setLayout(null);
		 */

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1358, 542);
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) Color.GREEN));
		stockVoucherFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblBranchCode = new JLabel("Branch Code");
		lblBranchCode.setBounds(672, 16, 87, 16);
		panel.add(lblBranchCode);

		sitecode = new JTextField();
		sitecode.setFont(new Font("Segoe UI", Font.BOLD, 13));
		sitecode.setBackground(Color.WHITE);
		sitecode.setEditable(false);
		sitecode.setBounds(754, 13, 87, 22);
		panel.add(sitecode);
		sitecode.setColumns(10);

		sitename = new JTextField();
		sitename.setBackground(Color.WHITE);
		sitename.setEditable(false);
		sitename.setForeground(new Color(153, 51, 153));
		sitename.setFont(new Font("Segoe UI", Font.BOLD, 13));
		sitename.setBounds(841, 13, 261, 22);
		panel.add(sitename);
		sitename.setColumns(10);

		JLabel lblSvNo = new JLabel("Stock Check No");
		lblSvNo.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblSvNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSvNo.setBounds(184, 65, 129, 16);
		panel.add(lblSvNo);

		scno = new JTextField();
		scno_1 = new gnRoundTextField(10);
		scno_1.setBackground(Color.BLACK);
		scno_1.setForeground(Color.WHITE);

		scno_1.setBounds(184, 81, 129, 30);
		panel.add(scno_1);
		ActionListener sc = new StockCheckno();
		scno_1.addActionListener(sc);
		scno_1.setColumns(10);

		JLabel lblSvdate = new JLabel("Stock Check Date");
		lblSvdate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblSvdate.setBounds(336, 65, 143, 16);
		lblSvdate.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblSvdate);

		// scdate = new JTextField();
		scdate = new gnRoundTextField(10);
		scdate.setBackground(Color.BLACK);
		scdate.setForeground(Color.WHITE);

		scdate.setEditable(false);
		scdate.setBounds(334, 81, 129, 30);
		panel.add(scdate);
		scdate.setColumns(10);

		JLabel lblNewLabel = new JLabel("Company");
		lblNewLabel.setBounds(220, 16, 56, 16);
		panel.add(lblNewLabel);

		companycode = new JTextField();
		companycode.setFont(new Font("Segoe UI", Font.BOLD, 13));
		companycode.setBackground(Color.WHITE);
		companycode.setEditable(false);
		companycode.setBounds(301, 13, 87, 22);
		panel.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setBackground(Color.WHITE);
		companyname.setForeground(new Color(153, 51, 153));
		companyname.setEditable(false);
		companyname.setFont(new Font("Segoe UI", Font.BOLD, 13));
		companyname.setBounds(388, 13, 261, 22);
		panel.add(companyname);
		companyname.setColumns(10);

		sjsp = new JScrollPane();
		sjsp.setBounds(12, 531, 1332, 122);
		// panel.add(sjsp);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		// JPanel panel_1 = new JPanel();
		JPanel panel_1 = new gnRoundPanel();

		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(null);
		panel_1.setBounds(12, 140, 1332, 72);
		panel.add(panel_1);
		panel_1.setLayout(null);

		// scanitem = new JTextField();
		scanitem = new gnRoundTextField(10);

		scanitem.setFont(new Font("Arial Black", Font.BOLD, 16));
		scanitem.setBounds(178, 30, 225, 30);
		panel_1.add(scanitem);
		scanitem.setColumns(10);

		JLabel lblScanItemHere = new JLabel("Scan Item Here");
		lblScanItemHere.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblScanItemHere.setBounds(178, 5, 168, 16);
		panel_1.add(lblScanItemHere);

		// searchname = new JTextField();
		searchname = new gnRoundTextField(10);

		searchname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		searchname.setBounds(410, 30, 267, 30);
		panel_1.add(searchname);
		ActionListener name = new lsnritemName();
		searchname.addActionListener(name);
		searchname.setColumns(10);

		JLabel lblSearchByName = new JLabel("Search By Name");
		lblSearchByName.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblSearchByName.setBounds(415, 5, 194, 16);
		panel_1.add(lblSearchByName);
		ActionListener brnd = new lsnrbrand();
		ActionListener btnls = new btn();

		JLabel lblNoofRecords = new JLabel("No.of Records");
		lblNoofRecords.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNoofRecords.setBounds(1182, 7, 150, 16);
		panel_1.add(lblNoofRecords);

		records = new JTextField();
		records.setBounds(1183, 30, 101, 30);
		panel_1.add(records);
		records.setFont(new Font("Tahoma", Font.PLAIN, 14));
		records.setForeground(new Color(153, 51, 204));
		records.setEditable(false);
		records.setColumns(10);
		 
		optionPanel = new JPanel();
		optionPanel.setBorder(new TitledBorder(null, "Data Filter  Options", TitledBorder.CENTER, TitledBorder.TOP,
				null, new Color(51, 51, 51)));
		optionPanel.setBounds(808, 65, 536, 72);
		panel.add(optionPanel);
		optionPanel.setVisible(false);
		optionPanel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Serach by Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(12, 13, 99, 16);
		optionPanel.add(lblNewLabel_3);

		showname = new JTextField();
		showname.setBounds(12, 33, 198, 22);
 
		showname.addActionListener(nam);
		optionPanel.add(showname);
		showname.setColumns(10);

		button = new JButton("");
		button.setEnabled(false);
		button.setBounds(222, 13, 10, 53);
		optionPanel.add(button);

		JLabel lblNewLabel_5 = new JLabel("Batch Article");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(384, 16, 79, 16);
		optionPanel.add(lblNewLabel_5);

		JButton button_2 = new JButton("");
		button_2.setEnabled(false);
		button_2.setBounds(378, 17, 10, 49);
		optionPanel.add(button_2);

		JLabel lblNewLabel_6 = new JLabel("Brand- Filter");
		lblNewLabel_6.setBounds(239, 13, 127, 16);
		optionPanel.add(lblNewLabel_6);

		searchbrand = new JTextField();
		searchbrand.setBounds(239, 33, 133, 22);
		optionPanel.add(searchbrand);
		searchbrand.addActionListener(brnd);
		searchbrand.setColumns(10);

		combobatch = new JComboBox();
		combobatch.setModel(new DefaultComboBoxModel(new String[] { "N", "Y" }));
		combobatch.setBounds(394, 36, 69, 22);
  		combobatch.addActionListener(batch);
		optionPanel.add(combobatch);

		brandcode = new JTextField();
		brandcode.setEnabled(false);
		brandcode.setEditable(false);
		brandcode.setBounds(476, 13, 49, 22);
		optionPanel.add(brandcode);
		brandcode.setColumns(10);

		brandname = new JTextField();
		brandname.setEnabled(false);
		brandname.setEditable(false);
		brandname.setBounds(476, 36, 49, 22);
		optionPanel.add(brandname);
		brandname.setColumns(10);
		searchbrand.setVisible(true);

		scstatus = new JTextField();
		scstatus.setBackground(Color.BLACK);
		scstatus.setForeground(Color.WHITE);
		scstatus.setFont(new Font("Verdana", Font.BOLD, 13));
		scstatus.setEnabled(false);
		scstatus.setBounds(491, 81, 103, 30);
		panel.add(scstatus);
		scstatus.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setBounds(701, 212, 97, 25);
		panel.add(btnSave);
		btnSave.addActionListener(btnls);
		btnSave.setMnemonic('S');

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(796, 212, 97, 25);
		panel.add(btnUpdate);
		btnUpdate.setMnemonic('U');

		btnVariance = new JButton("Generate Stock Variance ");
		btnVariance.setBounds(894, 212, 177, 25);
		panel.add(btnVariance);

		jsp = new JScrollPane();
		jsp.setBounds(12, 239, 1323, 290);
		panel.add(jsp);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		JLabel lblNewLabel_2 = new JLabel("Stock Check Module");
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_2.setBounds(12, 46, 123, 54);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setIcon(new ImageIcon(stockVoucher.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_4.setBounds(12, 13, 160, 124);
		panel.add(lblNewLabel_4);

		lblNewLabel_7 = new JLabel(" Status");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_7.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_7.setBounds(491, 65, 103, 16);
		panel.add(lblNewLabel_7);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(51, 51, 51)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(184, 4, 1160, 54);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
				btnClose = new JButton("Close");
				btnClose.setIcon(new ImageIcon(stockVoucher.class.getResource("/RetailProduct/delete.png")));
				btnClose.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
				btnClose.setBounds(1041, 0, 119, 41);
				panel_2.add(btnClose);
				btnClose.setMnemonic('C');
				btnClose.addActionListener(btnls);

		btnShow = new JButton("Get Batch & Price Details");
		btnShow.setBounds(481, 212, 219, 25);
		panel.add(btnShow);
		btnShow.setMnemonic('B');

		JLabel lblNewLabel_1 = new JLabel("Stock Location");
		lblNewLabel_1.setBounds(617, 65, 82, 16);
		panel.add(lblNewLabel_1);

		location = new JComboBox();
		location.setBounds(617, 83, 87, 22);
		panel.add(location);
		location.setModel(new DefaultComboBoxModel(new String[] { "SL" }));

		locationname = new JTextField();
		locationname.setBounds(617, 105, 181, 22);
		panel.add(locationname);
		locationname.setEditable(false);
		locationname.setText("Salable Inventory ");
		locationname.setHorizontalAlignment(SwingConstants.LEFT);
		locationname.setColumns(10);
		btnShow.addActionListener(btnls);
		btnVariance.addActionListener(varince);
		btnUpdate.addActionListener(btnls);
  		scanitem.addActionListener(article);

		decorate();
		checkOpenStockcheckno();
	}

	public void decorate() throws Throwable {

		
		new gnApp().setFrameTitel(stockVoucherFrame);
		stockVoucherFrame.setUndecorated(true);
		
		new gnDecorate().decorateField(sitecode);
		new gnDecorate().decorateField(sitename);
		new gnDecorate().decorateField(scdate);
		new gnDecorate().decorateField(locationname);

		//
		vallow = new gnDate().checkDayBegin();
		switch (vallow) {
		case "Y":
			companycode.setText(new gnConfig().getCompanyCode());
			companyname.setText(new gnConfig().getCompany());
			sitecode.setText(new gnConfig().getStoreID());
			vstore = sitecode.getText();
			vcomp = companycode.getText();
			sitename.setText(new gnConfig().getStorename(vstore));
			btnUpdate.setEnabled(false);
			vfinyear = new gnFinYear().getReportingFinYear();
			scdate.setText(new gnConfig().getDaybeginDate());
			String vmsname = "Location";
			String vverticle = new gnHierarchy().getVerticleCode();
			String vsearch = "%%";
			String SQL1 = "call master_getMasterData('" + vmsname + "' , " + vverticle + "  , '" + vsearch + "')";
			new gnComp().fillCombo(SQL1, location);
			switch (vstore) {
			case "0":
				System.exit(0);
			}

			String vrole = new gnConfig().getRoleName().toUpperCase();
			switch (vrole) {
			case "MANAGER":
				//btnSCCancel.setEnabled(true);
				btnVariance.setEnabled(true);
				break;
			case "CASHIER":
				//btnSCCancel.setEnabled(false);
				btnVariance.setEnabled(false);
				break;
			}
		}
	}

	private void checkOpenStockcheckno() throws Throwable {
		vscno = new gnStockcheck().getOpenStock();
		if (vscno != "0" && new gnStockcheck().rscstatus != "Close") {
			scno_1.setText(vscno);
			scdate.setText(new gnStockcheck().rscdate);
			scstatus.setText(new gnStockcheck().rscstatus);
			String vcomp = companycode.getText();
			String vstore = sitecode.getText();
			String vscno = scno_1.getText();
			String SQL = "Call SC_FetchStockcheckData( " + vscno + " , " + vcomp + ",  " + vstore + ", '" + vfinyear
					+ "' )";
			// new General().msg(SQL);
			showTable(SQL, articlecol);
			btnSave.setEnabled(false);
			btnUpdate.setEnabled(true);
			optionPanel.setVisible(true);
		}
	}

	class lsarticlecode implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (i == 1001) {
				String vtype = checkSCtype();
				switch (vtype) {
				case "New":
					try {
						NewStockcheck();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
					break;
				case "Current":
					try {
						CurrentStockcheck();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
					break;
				}
			}
		}
	}

	private String checkSCtype() {
		String vsctype = "New";
		vscno = scno_1.getText();
		if (vscno.length() == 0) {
			vsctype = "New";
		} else {
			vsctype = "Current";
		}

		return vsctype;
	}

	private void CurrentStockcheck() throws Throwable {
		new gnTable().RemoveTableRows(model);
		String varticle = scanitem.getText().trim();
		vscno = scno_1.getText();
		vcomp = companycode.getText();
		vstore = sitecode.getText();
		String SQL = "Call   SC_FetchforArticle(  " + vscno + " ,  " + vcomp + " ,  " + vstore + " , " + varticle
				+ "  , '" + vfinyear + "')";
		new gnTable().RemoveTableRows(model);
		showTable(SQL, articlecol);
		if (table.getRowCount() == 0) {
			NewStockcheck();
		}
		if (table.getRowCount() > 0) {
			int option = new General().msgInput("Artcle is Alrady Enter in Stock Check ...Would you like to Add ..? ");
			if (option == 0) {
				NewStockcheck();
			}
		}
	}

	private void NewStockcheck() throws Throwable {
		EntryCheck = "Check";
		String vcode = scanitem.getText();
		if (vcode.length() == 0) {
			new General().msg("Enter Or Search Article Code");
			return;
		}
		// String vname= "Article";
		String vcomp = companycode.getText();
		String vloc = location.getSelectedItem().toString();
		String SQL = "Call sc_scanatricle(" + vcode + " , " + vcomp + " , '" + vloc + "')";
		showTable(SQL, articlecol);
	}

	class showbyBatchControl implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String vbatch = combobatch.getSelectedItem().toString();
			String vscno = scno.getText();
			if (vscno.length() == 0) {
				new General().msg("Select Stock Check No ...");
				return;
			}
			vcomp = companycode.getText();
			vstore = sitecode.getText();
			String SQL = "Call   SC_FetchbyBatch(  " + vscno + " ,  " + vcomp + " ,  " + vstore + " , '" + vbatch
					+ "' , '" + vfinyear + "' )";
			try {
				new gnTable().RemoveTableRows(model);
				showTable(SQL, articlecol);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class showbyname implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String vname = "%" + showname.getText() + "%";
			String vscno = scno.getText();
			if (vscno.length() == 0) {
				new General().msg("Select Stock Check No ...");
				return;
			}
			vcomp = companycode.getText();
			vstore = sitecode.getText();
			String SQL = "Call   SC_FetchbyName(  " + vscno + " ,  " + vcomp + " ,  " + vstore + " , '" + vname + "' )";
			try {
				new gnTable().RemoveTableRows(model);
				showTable(SQL, articlecol);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class lsnrbrand implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vbrandname = "%" + searchbrand.getText() + "%";
			String vtype = "Brand";
			String vverticle;
			String vscno = scno.getText();
			if (vscno.length() == 0) {
				new General().msg("Select Stock Check No ...");
				return;
			}
			try {
				// new gnBrand().getBrandInfo(vbrandname);
				new gnAdmin().showMasterTable(vtype, brandcode, searchbrand);

			} catch (Throwable e2) {
				e2.printStackTrace();
			} finally {
				vscno = scno.getText();
				// String vbrandcode = new gnBrand().rbrandcode;
				String vbrandcode = brandcode.getText();
				;
				vcomp = companycode.getText();
				vstore = sitecode.getText();
				new gnTable().RemoveTableRows(model);
				String SQL = "Call   SC_FetchBrandArticles(  " + vscno + " ,  " + vcomp + " ,  " + vstore + " , '"
						+ vbrandcode + "' ,'" + vfinyear + "' )";
				try {
					showTable(SQL, articlecol);
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
			String vcomp;
			try {
				vcomp = new gnConfig().getCompanyCode();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String sname = searchname.getText().trim();
			sname = "%" + sname + "%";
			String vtype = "Article";
			String varticle1 = "";
			String vtrantype1 = "ALL";
			try {
				new gnAdmin().Search(vtype, sname, varticle1, vtrantype1);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				String vcode = new gnAdmin().rArticle;
				vcomp = new gnConfig().getCompanyCode();
				String vloc = location.getSelectedItem().toString();
				String SQL = "Call sc_scanatricle(" + vcode + " , " + vcomp + " , '" + vloc + "')";
				showTable(SQL, articlecol);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class StockCheckno implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				new gnStockcheck().getStockCheckNo();
			} catch (Throwable e1) {
				e1.printStackTrace();
				new General().msg("Sc No Search" + " " + e1.getMessage());
			} finally {
				scno.setText(new gnStockcheck().rscno);
				scdate.setText(new gnStockcheck().rscdate);
				String vcomp = companycode.getText();
				String vstore = sitecode.getText();
				String vscno = scno.getText();
				if (vscno.length() > 0) {
					try {
						String SQL = "Call SC_FetchStockcheckData( " + vscno + " , " + vcomp + ",  " + vstore + ", '"
								+ vfinyear + "' )";
						showTable(SQL, articlecol);
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().msg("Stock Check Data Fetch" + " " + e1.getMessage());
					}
				}
			}
		}
	}

	class btn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (value == "Get Batch & Price Details") {
				try {
					showBatchPriceHelp();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Close") {
				stockVoucherFrame.dispose();
			}

			if (value == "Export To Excel") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

			if (value == "Generate Stock Variance ") {
				stockVariance window;
				try {
					window = new stockVariance();
					window.stockVarianceFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
					new General().msg("stock variance calling: " + " " + e1.getLocalizedMessage());
				}
			}

			if (value == "Save") {
				try {
					callSaveEvent();
				} catch (Throwable e1) {
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

		}
	}

	private void showBatchPriceHelp() throws Throwable {
		int row = table.getSelectedRow();
		String vbatchcontrol = (String) table.getValueAt(row, 5);
		String varticle = (String) table.getValueAt(row, 1);
		selectedrow = row;
		String vloc = location.getSelectedItem().toString();
		// CheckBatchArticle(vbatchcontrol , varticle ) ;
		try {
			new gnGetBatch().getBatchDetail(varticle, vbatchcontrol, vloc);
		} catch (Exception e) {
			new General().msg(e.getMessage());
		} finally {
 			table.setValueAt(new gnGetBatch().batchno, selectedrow, 6);
			table.setValueAt(new gnGetBatch().manuf_date, selectedrow, 7);
			table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 8);
			table.setValueAt(new gnGetBatch().cost, selectedrow, 9);
			table.setValueAt(new gnGetBatch().mrp, selectedrow, 10);
			table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 11);
			new gnGetBatch().resetValues();
		}
	}

	public void showTable(String SQL, String[] Colnames) throws Throwable {
		rs = this.getSPResult(SQL);
		((DefaultTableModel) model).setColumnIdentifiers(Colnames);
		table.setModel(model);
		while (rs.next()) {
			model.addRow(new Object[] { "Remove", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10), rs.getString(11), rs.getString(12) });
			table.setModel(model);
			new gnTable().setTableBasics(table);
 			new gnTable().setTablewidth(table, 0, 20);
			new gnTable().setTablewidth(table, 2, 300);
			new gnTable().setTablewidth(table, 1, 100);
		}
		new gnTable().removeRow(model, table);
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		records.setText(RecordCount1);
		table.setEnabled(true);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.gray);
		table.setBackground(Color.white);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		JViewport prt6 = new JViewport();
		nk.addCellEditorListener(ChangeNotification);
		prt6.setToolTipText("Stock Check Data Panel");
		prt6.add(table, articlecol);
		prt6.setVisible(true);
		jsp.setViewport(prt6);
	}// End Show Table

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String vbatchcontrol = (String) table.getValueAt(row, 5);
			String varticle = (String) table.getValueAt(row, 1);
			try {
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	};

	public String CheckBatchArticle(String vbatchcontrol, String varticle) throws Throwable {
		String vcomp = companycode.getText();
		String vloc = (String) location.getSelectedItem();
		String status = "Sucess";
		String vstorecode = sitecode.getText();
		switch (vbatchcontrol) {
		case "Y":
			String SQL1 = "Call sv_getbatchprices(" + vstorecode + " ,   " + varticle + ", " + vcomp + ", '" + vloc
					+ "' , '" + vfinyear + "')";
			showSearch(SQL1, batch);
			break;
		case "N":
			String SQL2 = "Call sv_getnonBatchprices(" + vstorecode + " ,   " + varticle + " , " + vcomp + ",  '" + vloc
					+ "' , '" + vfinyear + "')";
			showSearch(SQL2, batch);
			break;
		}
		return status;
	}// Method End

	public void showSearch(String SQL, String[] Colnames) throws Throwable {
		// new General().msg(SQL);
		new gnTable().RemoveTableRows(smodel);
		rs = this.getSPResult(SQL);
		((DefaultTableModel) smodel).setColumnIdentifiers(Colnames);
		stable.setModel(smodel);
		String vtype = "Select ";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, Colnames, 9, "N", "N", vtype);
		new gnTable().setTablewidth(stable, 2, 300);
		new gnTable().setTablewidth(stable, 2, 50);
		stable.setEnabled(true);
		stable.setCellSelectionEnabled(false);
		stable.setRowSelectionAllowed(true);
		stable.setGridColor(Color.yellow);
		stable.setForeground(Color.blue);
		stable.setBackground(Color.white);
		DefaultCellEditor nk = new gnTable().cellEdit(stable);
		JViewport prt66 = new JViewport();
		nk.addCellEditorListener(ChangeNotification1);
		prt66.add(stable, Colnames);
		prt66.setVisible(true);
		sjsp.setViewport(prt66);
		new General().msgsearch(sjsp, stable, "Select Article ", 1000, 250);
	}// End Search Table

	public CellEditorListener ChangeNotification1 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = stable.getSelectedRow();
			String vtype = (String) stable.getValueAt(row, 0);
			String varticle = (String) stable.getValueAt(row, 1);
			try {
				displayInfo(vtype, row);
				new General().msgDispose();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	};
	private JButton button;
	private JTextField brandcode;
	private JTextField brandname;
	private JLabel lblNewLabel_7;

	public void displayInfo(String vtype, int row) {
		// new General().msg(vtype);
		String vmrp = " ";
		String vcost = " ";
		String vsp = " ";
		String vexpdate = " ";
		String vmanufdate = " ";
		String vbatchno = " ";
		// search table//{"BatchArticlce" , "Item Code" , "name" , "cost"
		// ,"SalesPrice" ,
		// "Mrp" , "Batchno" , "Manuf_date" , "Exp.Date" } ;

		// table // String articlecol[] = {"Deletete" , "Itemcode" , "Item Name"
		// , "Physical Qty" ,"UOM" ,
		// "Batch Control" ,
		// 6 ."BAtchNo" , "Batch Manuf Date" ,"BatchExpDate",
		// "Cost" , "Mrp" , "SalesPrice"} ;
		switch (vtype) {
		case "Y":
			vcost = (String) stable.getValueAt(row, 3);
			vsp = (String) stable.getValueAt(row, 4);
			vmrp = (String) stable.getValueAt(row, 5);
			vbatchno = (String) stable.getValueAt(row, 6);
			vmanufdate = (String) stable.getValueAt(row, 7);
			vexpdate = (String) stable.getValueAt(row, 8);
			table.setValueAt(vbatchno, selectedrow, 6);
			table.setValueAt(vmanufdate, selectedrow, 7);
			table.setValueAt(vexpdate, selectedrow, 8);
			table.setValueAt(vcost, selectedrow, 9);
			table.setValueAt(vmrp, selectedrow, 10);
			table.setValueAt(vsp, selectedrow, 11);
		case "N":
			vcost = (String) stable.getValueAt(row, 3);
			vsp = (String) stable.getValueAt(row, 4);
			vmrp = (String) stable.getValueAt(row, 5);
			vbatchno = (String) stable.getValueAt(row, 6);
			vmanufdate = (String) stable.getValueAt(row, 7);
			vexpdate = (String) stable.getValueAt(row, 8);
			table.setValueAt(vbatchno, selectedrow, 6);
			table.setValueAt(vmanufdate, selectedrow, 7);
			table.setValueAt(vexpdate, selectedrow, 8);
			table.setValueAt(vcost, selectedrow, 9);
			table.setValueAt(vmrp, selectedrow, 10);
			table.setValueAt(vsp, selectedrow, 11);
		}
	}

	private void generateSCno() throws Throwable {
		vscno = new gnSeq().getSeqno("9", "TR");
		scno_1.setText(vscno);
		vcomp = companycode.getText();
		vstore = sitecode.getText();
		String scnoPresent = "Call   SC_checkScnoPresnt(" + vcomp + " ,  " + vstore + " ,   " + vscno + " , '"
				+ vfinyear + "' )";
		rs = this.getSPResult(scnoPresent);
		if (rs.next()) {
			vstatus = "Y";
			new General().msg("Stock Check Number is Alrady Present In Stock Tables. Contact System Admin");
			return;
		}
		scdate.setText(new General().getDate());
	}

	private void updateSCno() throws Throwable {
		new gnSeq().updateSeqno("9", "TR");
	}

	private String dataValidation() throws Throwable {
		String action = "Sucess";
		if (table.getRowCount() == 0) {
			new General().msg("No Data Found For Save...");
			action = "Fail";
		}
		return action;
	}

	private void callSaveEvent() throws Throwable {
		String action = dataValidation();
		if (action == "Sucess") {
			generateSCno();
			vcomp = companycode.getText();
			vstore = sitecode.getText();
			vscno = scno_1.getText();
			vscdate = new gnConfig().date_ConverttoDBforamt(scdate.getText());
			vlocation = location.getSelectedItem().toString();
			vupdatedate = new gnConfig().date_ConverttoDBforamt(scdate.getText());
			vcreatedate = new gnConfig().date_ConverttoDBforamt(scdate.getText());
			vcreatedby = new gnConfig().getUserCode();
			vupdatedby = new gnConfig().getUserCode();
			new gnStockcheck().performRemoveAction(vscno);
			InsertSCDetail();
		}
	}

	public void InsertSCDetail() throws Throwable {
		// new General().msg("Inserting grn detail now ") ;
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		con = (Connection) this.getConnection();
		con.setAutoCommit(false);
		String grndetail = "Insert into     tmp_sc_physicalstockentry_detail(company_code,    Site_code , "
				+ "Stock_check_no ,   stock_check_date,   Article_code , " + "name,   physical_qty ,  UOM,"
				+ "Batcharticle,   batch_no,  manuf_date,   expiry_date,"
				+ "cost ,  SalesPrice,    MRP , location, srno , FinYear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con.prepareStatement(grndetail);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vscno);
				prst.setString(4, vscdate);
				prst.setString(5, (table.getValueAt(k, 1).toString()));
				prst.setString(6, (table.getValueAt(k, 2).toString()));
				prst.setString(7, (table.getValueAt(k, 3).toString()));
				prst.setString(8, (table.getValueAt(k, 4).toString()));
				prst.setString(9, (table.getValueAt(k, 5).toString()));
				prst.setString(10, (table.getValueAt(k, 6).toString()));
				String vbatch = table.getValueAt(k, 5).toString();
				switch (vbatch) {
				case "N":
					prst.setString(11, "0000.00.00");
					prst.setString(12, "0000.00.00");
					break;
				case "Y":
					prst.setString(11, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 7).toString()));
					prst.setString(12, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 8).toString()));
					break;
				}
				prst.setString(13, (table.getValueAt(k, 9).toString()));
				prst.setString(14, (table.getValueAt(k, 10).toString()));
				prst.setString(15, (table.getValueAt(k, 11).toString()));
				prst.setString(16, (table.getValueAt(k, 12).toString()));
				prst.setInt(17, k);
				prst.setString(18, vfinyear);
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBdetail = "Fail";
				// new General().msg("PRST" + "" + prst);
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg("Stock Check Detaill" + e.getMessage());
			con.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {
				insertSCHdr();
			}
		}
	}

	public void insertSCHdr() throws Throwable {
		if (DBdetail == "Sucess") {
			prst = null;
			final int batchSize = 10;
			int TotalRecordinsert = 0;
			con1 = (Connection) this.getConnection();
			con1.setAutoCommit(false);
			String SChdr = "Insert into sc_physicalstockentry_hdr( company_code , Site_code , "
					+ "Stock_check_no , Stock_check_date , " + "status ,  Stock_check_type , createdBy , Finyear) "
					+ "values(?,?,?,?,?,?,?,?)";
			try {
				prst = con1.prepareStatement(SChdr);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vscno);
				prst.setString(4, vscdate);
				prst.setString(5, "Open");
				prst.setString(6, "0");
				prst.setString(7, vcreatedby);
				prst.setString(8, vfinyear);
				prst.addBatch();
				// new General().msg("Statement:"+" "+prst);
				TotalRecordinsert = TotalRecordinsert + 1;
				DBhdr = "Fail";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBhdr = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DBhdr = "Sucess";
			} catch (SQLException e) {
				new General().msg("Stock Check Header " + e.getMessage());
				con1.rollback();
				DBhdr = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
				}
				if (DBhdr == "Sucess") {
					con.commit();
					con1.commit();
					new General().msg("Data Inserted Sucessfully");
					con.close();
					con1.close();
					updateSCno();
					btnSave.setEnabled(false);
					btnUpdate.setEnabled(true);
					vscno = scno_1.getText();
					new gnStockcheck().performActionOnDetailTable(vscno);
					reset();
				}
			}
		}
	}

	private void callUpdateEvent() throws Throwable {
		String action = dataValidation();
		if (action == "Sucess") {
			vcomp = companycode.getText();
			vstore = sitecode.getText();
			vscno = scno_1.getText();
			vscdate = new gnConfig().date_ConverttoDBforamt(scdate.getText());
			vlocation = location.getSelectedItem().toString();
			vupdatedate = new gnConfig().date_ConverttoDBforamt(scdate.getText());
			vcreatedate = new gnConfig().date_ConverttoDBforamt(scdate.getText());
			vcreatedby = new gnConfig().getUserCode();
			vupdatedby = new gnConfig().getUserCode();
			new gnStockcheck().performRemoveAction(vscno);
			UpdateSCDetail();
		}
	}

	public void UpdateSCDetail() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		con = (Connection) this.getConnection();
		con.setAutoCommit(false);
		String grndetail = "Insert into     tmp_sc_physicalstockentry_detail(company_code,    Site_code , "
				+ "Stock_check_no ,   stock_check_date,   Article_code , " + "name,   physical_qty ,  UOM,"
				+ "Batcharticle,   batch_no,  manuf_date,   expiry_date,"
				+ "cost ,  SalesPrice,    MRP , location,srno , finyear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con.prepareStatement(grndetail);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vscno);
				prst.setString(4, vscdate);
				prst.setString(5, (table.getValueAt(k, 1).toString()));
				prst.setString(6, (table.getValueAt(k, 2).toString()));
				prst.setString(7, (table.getValueAt(k, 3).toString()));
				prst.setString(8, (table.getValueAt(k, 4).toString()));
				prst.setString(9, (table.getValueAt(k, 5).toString()));
				prst.setString(10, (table.getValueAt(k, 6).toString()));
				String vbatch = table.getValueAt(k, 5).toString();
				switch (vbatch) {
				case "N":
					prst.setString(11, "0000.00.00");
					prst.setString(12, "0000.00.00");
					break;
				case "Y":
					prst.setString(11, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 7).toString()));
					prst.setString(12, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 8).toString()));
					break;
				}
				prst.setString(13, (table.getValueAt(k, 9).toString()));
				prst.setString(14, (table.getValueAt(k, 10).toString()));
				prst.setString(15, (table.getValueAt(k, 11).toString()));
				prst.setString(16, location.getSelectedItem().toString());
				prst.setInt(17, k);
				prst.setString(18, vfinyear);
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBdetail = "Fail";
				// new General().msg("PRST" + "" + prst);
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg("Grn Detaill" + e.getMessage());
			con.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {
				con.commit();
				con.close();
				vscno = scno_1.getText();
				new gnStockcheck().performActionOnDetailTable(vscno);
				reset1();
			}
		}
	}

	private void reset1() {
		// scno.setText(null);
		// scstatus.setText(null);
		new gnTable().RemoveTableRows(model);
		// records.setText(null);
	}

	private void reset() {

		scno_1.setText(null);
		scstatus.setText(null);
		new gnTable().RemoveTableRows(model);
		records.setText(null);
	}
}// last

package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
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
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.mysql.jdbc.Connection;
import javax.swing.ImageIcon;

public class SVPosting extends getResultSet {

	JFrame SVPosting;
	private Connection con, con1, con2, con3, con4, con5, con6, con7, con8;
	private JTextField sitecode;
	private String FileterChoice;
	private JLabel locationlbl;
	private String vfinyear;
	private String DBdetail;
	private JButton btnShow;
	private JTextField scstatus;
	private JButton btnExport;
	private String DBhdr;
	private JTextField sitename;
	private JTextField scno;
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
	private JButton btnSCCancel;
	private JButton btnShowSV;
	private JButton btnSVPosting;
	private JTextField showname;

	private JPanel optionPanel;

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
			" Manuf. Date", "Batch.Exp.Date", "Cost", "Mrp", "SalesPrice" };

	String variancecol[] = { "Remove", "Article code", "Name", "Physical Qty", "System Bal.Stock", "Diff", "UOM",
			"Avg.Cost", "Cost", "SalesPrice", "Mrp", "Batch Control", "Batch No", " Manuf. Date", "Batch.Exp.Date",
			"Location" };
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
			if (column == 0 || column == 3 || column == 6 || column == 7 || column == 8 || column == 9 || column == 10
					|| column == 11) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
			} else {
				// componentt.setBackground(new Color(0,51,153))
				// ;//.LIGHT_GRAY);
				// componentt.setForeground(new Color(204,255,153));

				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);

				// componentt.setBackground(Color.magenta);
				// componentt.setForeground(Color.WHITE);

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
					SVPosting window = new SVPosting();
					window.SVPosting.setVisible(true);
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
	public SVPosting() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		JFrame.setDefaultLookAndFeelDecorated(true);
		SVPosting = new JFrame();
		SVPosting.setAutoRequestFocus(false);
		SVPosting.setAlwaysOnTop(true);
		SVPosting.getContentPane().setForeground(Color.GREEN);
		SVPosting.setBounds(0, 100, 1376, 600);
		SVPosting.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SVPosting.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1361, 587);
		panel.setBorder(new LineBorder(new Color(153, 204, 204), 8));
		SVPosting.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblSvNo = new JLabel("Stock Check No");
		lblSvNo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblSvNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSvNo.setBounds(207, 74, 111, 16);
		panel.add(lblSvNo);

		scno = new JTextField();
		scno.setBounds(207, 96, 123, 28);
		panel.add(scno);
		ActionListener sc = new StockCheckno();
		scno.addActionListener(sc);
		scno.setColumns(10);

		JLabel lblSvdate = new JLabel("Stock Check Date");
		lblSvdate.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblSvdate.setBounds(342, 74, 132, 16);
		lblSvdate.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblSvdate);

		scdate = new JTextField();
		scdate.setEditable(false);
		scdate.setBounds(339, 96, 87, 28);
		panel.add(scdate);
		scdate.setColumns(10);

		locationlbl = new JLabel("Stock Location");
		locationlbl.setBounds(617, 81, 82, 16);
		panel.add(locationlbl);

		location = new JComboBox();
		location.setModel(new DefaultComboBoxModel(new String[] { "SL" }));
		location.setBounds(530, 78, 87, 22);
		panel.add(location);

		locationname = new JTextField();
		locationname.setEditable(false);
		locationname.setText("Salable Inventory ");
		locationname.setHorizontalAlignment(SwingConstants.LEFT);
		locationname.setBounds(530, 102, 189, 22);
		panel.add(locationname);
		locationname.setColumns(10);

		sjsp = new JScrollPane();
		sjsp.setBounds(12, 531, 1332, 122);
		// panel.add(sjsp);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBorder(new LineBorder(new Color(51, 204, 204), 5, true));
		panel_1.setBounds(12, 168, 1330, 40);
		panel.add(panel_1);
		panel_1.setLayout(null);

		scanitem = new JTextField();
		scanitem.setFont(new Font("Arial Black", Font.BOLD, 16));
		scanitem.setBounds(32, 6, 6, 27);
		panel_1.add(scanitem);
		scanitem.setColumns(10);
		scanitem.setVisible(false);

		JLabel item = new JLabel("Scan Item Here");
		item.setVisible(false);
		item.setBounds(6, 13, 14, 16);
		panel_1.add(item);

		searchname = new JTextField();
		searchname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		searchname.setBounds(61, 7, 6, 27);
		searchname.setVisible(false);
		panel_1.add(searchname);
		ActionListener name = new lsnritemName();
		searchname.addActionListener(name);
		searchname.setColumns(10);

		JLabel name1 = new JLabel("Search By Name");
		name1.setBounds(46, 13, 14, 16);
		name1.setVisible(false);
		panel_1.add(name1);
		ActionListener brnd = new lsnrbrand();
		ActionListener btnls = new btn();
		ActionListener vranshow = new btn();
		ActionListener vcalvar = new btn();
		ActionListener svpost = new btn();
		ActionListener svshow = new btn();

		JLabel lblNewLabel_1 = new JLabel(
				"Check All Differences. If Changes Are Required(New Addition/Updation),  Please Change Through Stock Check  Module.  Once SV Posted Stock check Will be Closed.");
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(72, 13, 980, 16);
		panel_1.add(lblNewLabel_1);

		btnExport = new JButton("Export To Excel");
		btnExport.setBounds(1052, 7, 121, 25);
		panel_1.add(btnExport);

		btnSCCancel = new JButton("Cancel Stock Check");
		btnSCCancel.setBounds(1175, 6, 143, 25);
		panel_1.add(btnSCCancel);

		ActionListener abc = new btnCancelStock();
		ActionListener exp = new btn();
		ActionListener btnprocee = new btn();
		ActionListener varince = new btn();

		optionPanel = new JPanel();
		optionPanel.setBackground(new Color(204, 255, 255));
		optionPanel.setBorder(new TitledBorder(null, "Data Filter Options", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 51, 153)));
		optionPanel.setBounds(859, 81, 483, 81);
		panel.add(optionPanel);
		optionPanel.setVisible(false);
		optionPanel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Serach by Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(12, 17, 99, 16);
		optionPanel.add(lblNewLabel_3);

		showname = new JTextField();
		showname.setBounds(12, 37, 185, 32);
		ActionListener nam = new showbyname();
		showname.addActionListener(nam);
		optionPanel.add(showname);
		showname.setColumns(10);

		button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBackground(new Color(0, 0, 153));
		button.setEnabled(false);
		button.setBounds(209, 13, 4, 56);
		optionPanel.add(button);

		JLabel lblNewLabel_5 = new JLabel("Batch Article");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(346, 17, 79, 16);
		optionPanel.add(lblNewLabel_5);

		JButton button_2 = new JButton("");
		button_2.setBackground(new Color(0, 0, 153));
		button_2.setEnabled(false);
		button_2.setBounds(346, 13, 4, 56);
		optionPanel.add(button_2);

		JLabel lblNewLabel_6 = new JLabel("Brand- Filter");
		lblNewLabel_6.setBounds(225, 17, 109, 16);
		optionPanel.add(lblNewLabel_6);

		searchbrand = new JTextField();
		searchbrand.setBounds(225, 37, 109, 32);
		optionPanel.add(searchbrand);
		searchbrand.addActionListener(brnd);
		searchbrand.setColumns(10);

		combobatch = new JComboBox();
		combobatch.setModel(new DefaultComboBoxModel(new String[] { "N", "Y" }));
		combobatch.setBounds(356, 37, 69, 32);
		ActionListener batch = new showbyBatchControl();
		combobatch.addActionListener(batch);
		optionPanel.add(combobatch);

		btnCalVariance = new JButton("Calculate  Variance ");
		btnCalVariance.setBounds(449, 13, 20, 25);
		optionPanel.add(btnCalVariance);
		btnCalVariance.setEnabled(false);

		btnShowVariance = new JButton("Show Variance");
		btnShowVariance.setBounds(427, 13, 20, 25);
		optionPanel.add(btnShowVariance);
		btnShowVariance.setEnabled(false);

		btnShow = new JButton("Get Batch & Price Details");
		btnShow.setBounds(437, 41, 14, 25);
		optionPanel.add(btnShow);
		btnShow.setEnabled(false);
		btnShow.setMnemonic('B');

		brandcode = new JTextField();
		brandcode.setBounds(128, 14, 30, 22);
		optionPanel.add(brandcode);
		brandcode.setColumns(10);

		brandname = new JTextField();
		brandname.setBounds(169, 14, 30, 22);
		optionPanel.add(brandname);
		brandname.setColumns(10);
		btnShow.setVisible(false);
		btnShow.addActionListener(btnls);
		btnShowVariance.addActionListener(vranshow);
		btnCalVariance.addActionListener(vcalvar);
		searchbrand.setVisible(true);

		scstatus = new JTextField();
		scstatus.setFont(new Font("Verdana", Font.BOLD, 14));
		scstatus.setEnabled(false);
		scstatus.setBounds(430, 95, 72, 28);
		panel.add(scstatus);
		scstatus.setColumns(10);

		jsp = new JScrollPane();
		jsp.setBounds(12, 213, 1330, 361);
		panel.add(jsp);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 102)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(175, 16, 1167, 48);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Company");
		lblNewLabel.setBounds(12, 16, 56, 16);
		panel_2.add(lblNewLabel);

		companycode = new JTextField();
		companycode.setBounds(69, 13, 87, 30);
		panel_2.add(companycode);
		companycode.setBackground(Color.WHITE);
		companycode.setEditable(false);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setBounds(156, 13, 261, 30);
		panel_2.add(companyname);
		companyname.setBackground(Color.WHITE);
		companyname.setForeground(new Color(153, 51, 153));
		companyname.setEditable(false);
		companyname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		companyname.setColumns(10);

		JLabel lblBranchCode = new JLabel("Branch Code");
		lblBranchCode.setBounds(433, 16, 87, 16);
		panel_2.add(lblBranchCode);

		sitecode = new JTextField();
		sitecode.setBounds(513, 13, 87, 30);
		panel_2.add(sitecode);
		sitecode.setBackground(Color.WHITE);
		sitecode.setEditable(false);
		sitecode.setColumns(10);

		sitename = new JTextField();
		sitename.setBounds(600, 13, 261, 30);
		panel_2.add(sitename);
		sitename.setBackground(Color.WHITE);
		sitename.setEditable(false);
		sitename.setForeground(new Color(153, 51, 153));
		sitename.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sitename.setColumns(10);

		btnClose = new JButton("Close");
		btnClose.setIcon(new ImageIcon(SVPosting.class.getResource("/RetailProduct/delete.png")));
		btnClose.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnClose.setBounds(1029, 0, 126, 37);
		panel_2.add(btnClose);
		btnClose.setMnemonic('C');
		btnClose.addActionListener(btnls);

		lblNewLabel_2 = new JLabel("Stock Check Module");
		lblNewLabel_2.setBounds(12, 67, 151, 30);
		panel.add(lblNewLabel_2);

		lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setIcon(new ImageIcon(SVPosting.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_4.setBounds(12, 0, 151, 167);
		panel.add(lblNewLabel_4);

		btnSVPosting = new JButton("Post Stock Voucher");
		btnSVPosting.setBounds(175, 137, 175, 25);
		panel.add(btnSVPosting);
		btnSVPosting.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));

		btnShowSV = new JButton("Show Stock Vouchers");
		btnShowSV.setBounds(351, 137, 157, 25);
		panel.add(btnShowSV);
		btnShowSV.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));

		btnProcess = new JButton("Get Process OverView");
		btnProcess.setBounds(509, 137, 197, 25);
		panel.add(btnProcess);

		btnSave = new JButton("Save");
		btnSave.setBounds(707, 137, 97, 25);
		panel.add(btnSave);
		btnSave.addActionListener(btnls);
		btnSave.setMnemonic('S');

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(859, 65, 97, 25);
		panel.add(btnUpdate);
		btnUpdate.setMnemonic('U');

		JLabel lblNoofRecords = new JLabel("No.of Records");
		lblNoofRecords.setBounds(760, 75, 87, 16);
		panel.add(lblNoofRecords);

		records = new JTextField();
		records.setBounds(774, 99, 55, 25);
		panel.add(records);
		records.setFont(new Font("Tahoma", Font.BOLD, 14));
		records.setForeground(new Color(153, 51, 204));
		records.setEditable(false);
		records.setColumns(10);
		btnUpdate.addActionListener(btnls);
		btnProcess.addActionListener(btnprocee);
		btnShowSV.addActionListener(svshow);
		btnSVPosting.addActionListener(svpost);
		ActionListener article = new lsarticlecode();
		scanitem.addActionListener(article);

		btnSCCancel.setMnemonic('S');
		btnSCCancel.addActionListener(abc);
		btnExport.addActionListener(exp);
		decorate();
		// checkOpenStockcheckno();
	}

	public void decorate() throws Throwable {

		new gnApp().setFrameTitel(SVPosting);
		SVPosting.setUndecorated(true);

		new gnDecorate().decorateField(sitecode);
		new gnDecorate().decorateField(sitename);
		new gnDecorate().decorateField(scdate);
		new gnDecorate().decorateField(locationname);
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		sitecode.setText(new gnConfig().getStoreID());
		vfinyear = new gnFinYear().getReportingFinYear();
		String vstore = sitecode.getText();
		sitename.setText(new gnConfig().getStorename(vstore));
		scanitem.setEnabled(false);
		btnSave.setVisible(false);
		btnUpdate.setVisible(false);
		scanitem.setBackground(Color.CYAN);
		searchname.setEnabled(false);
		searchname.setBackground(Color.CYAN);
		locationlbl.setVisible(false);
		location.setVisible(false);
		locationname.setVisible(false);
		switch (vstore) {
		case "0":
			System.exit(0);
		}

		String vrole = new gnConfig().getRoleName().toUpperCase();
		switch (vrole) {
		case "MANAGER":
			btnSCCancel.setEnabled(true);
			btnSVPosting.setEnabled(true);
			btnShowSV.setEnabled(false);
			break;
		case "CASHIER":
			btnSCCancel.setEnabled(false);
			btnSVPosting.setEnabled(false);
			btnShowSV.setEnabled(true);
			break;
		}
	}

	private void checkOpenStockcheckno() throws Throwable {
		vscno = new gnStockcheck().getOpenStock();
		if (vscno != "0") {
			scno.setText(vscno);
			scdate.setText(new gnStockcheck().rscdate);
			scstatus.setText(new gnStockcheck().rscstatus);
			String vcomp = companycode.getText();
			String vstore = sitecode.getText();
			String vscno = scno.getText();
			String SQL = "Call SC_FetchStockcheckData( " + vscno + " , " + vcomp + ",  " + vstore + " )";
			showTable(SQL, articlecol);
			btnSave.setEnabled(false);
			btnUpdate.setEnabled(false);
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
		vscno = scno.getText();
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
		vscno = scno.getText();
		vcomp = companycode.getText();
		vstore = sitecode.getText();
		String SQL = "Call   SC_FetchforArticle(  " + vscno + " ,  " + vcomp + " ,  " + vstore + " , " + varticle
				+ " )";
		new General().msg(SQL);
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
		String vcode = scanitem.getText();
		// String vname= "Article";
		String vcomp = companycode.getText();
		String SQL = "Call sc_scanatricle(" + vcode + " , " + vcomp + ")";
		// String result = checkArticleExist(vcode) ;
		showTable(SQL, articlecol);
	}

	private void ShowSV() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vscno = scno.getText();
		if (vscno.length() == 0) {
			new General().msg("Select Stock Check Number ..");
			return;
		}
		String SQL = "Call   SC_PostSVForNonBatch( " + vcomp + " ,  " + vstore + " ,  " + vscno + " , '" + vfinyear
				+ "')";
		// showVarianceTable(SQL, variancecol) ;
		optionPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				"Variance Data Filter  Options", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 50, 51)));
		table.setEnabled(false);
		FileterChoice = "Variance";
		optionPanel.setVisible(true);
	}

	private void closeStockcheck() throws SQLException {
		String SQL4 = "Call  SC_CloseStockCheck(" + vcomp + " ,  " + vstore + " ,   " + vscno + " , '" + vfinyear
				+ "')";
		String status4 = this.getResult(SQL4);
	}

	private void PostSV() throws Throwable {
		new General().msg("SV Posting Will Take fue minitues ..");

		// Steps Invlove
		// ==============Non BAtch Articles =====
		// Check In SC_stockvariance_hdr table Stock no should not present if
		// not present then follow below steps
		// 1.Insert Data From Tmp_sc_Stockvariance_hdr to sc_stockvariance_hdr
		// 2.Insert Data From tmp_stockVariance_detl to SC_stockvariance_detail;
		// 3.Filter Data For Non Batch Processing Post Stock diff In respective
		// Field Of Stock_in_hand Table
		// 4.Calculate New Bal_Qty After SV Posting.
		// ===========BAtch ARticles ============
		// 5.Filter Data For Batch Article ACtion Required in Following way
		// 5.1 Sum Article wise Qty and Apply in Stock Check and update Bal_qty
		// Field at Header Level
		// 5.2 For Batch Details Update Stock_in_hand_details in Following Way
		// 5.2.1

		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vscno = scno.getText();
		vscno = scno.getText();
		String vstatus = "";
		if (vscno.length() == 0) {
			new General().msg("Select Stock Check Number ..");
			return;
		}
		String scnoPresent = "Call   SC_checkScnoPresnt(" + vcomp + " ,  " + vstore + " ,   " + vscno + " , '"
				+ vfinyear + "')";
		rs = this.getSPResult(scnoPresent);
		if (rs.next()) {
			vstatus = "Y";
			new General().msg("Stock Check Number is Alrady Present In Stock  Table Hdr/Detail Remove Data First ");
			return;
		} else {
			vstatus = "N";
		}
		if (vstatus == "N") {

			String SQL2 = "Call  sc_insertFromscheaderTOscvariancehdr( " + vcomp + " ,  " + vstore + " ,   " + vscno
					+ " , '" + vfinyear + "' )";
			String status2 = this.getResult(SQL2);

			/// Non Batch Article Sv Posting
			String trnType = "SVPlus";
			String vdocdate = new gnConfig().date_ConverttoDBforamt(scdate.getText());
			String SQL3 = "call Stock_Post_sv( " + vcomp + " ,  " + vstore + " ,  '" + trnType + "' , " + vscno + " , '"
					+ vdocdate + "', '" + vfinyear + "' )";
			this.getSPResult(SQL3);

			String trnType1 = "SVMinus";
			String SQL4 = "call Stock_Post_sv( " + vcomp + " ,  " + vstore + " ,  '" + trnType1 + "' , " + vscno
					+ " , '" + vdocdate + "'  , '" + vfinyear + "')";
			this.getSPResult(SQL4);

			/// Batch Article Sv Posting
			String trnType5 = "SVPlus";
			String SQL5 = "call Stock_Post_sv_batch( " + vcomp + " ,  " + vstore + " ,  '" + trnType5 + "' , " + vscno
					+ " , '" + vdocdate + "' , '" + vfinyear + "')";
			this.getSPResult(SQL5);

			String trnType6 = "SVMinus";
			String SQL6 = "call Stock_Post_sv_batch( " + vcomp + " ,  " + vstore + " ,  '" + trnType6 + "' , " + vscno
					+ " , '" + vdocdate + "' , '" + vfinyear + "')";
			this.getSPResult(SQL6);

			closeStockcheck();
			String status = "Sucess";
			if (status == "Sucess") {
				int option = new General().msgInput("Would you Like View Stock Variance Data .. ");
				if (option == 0) {
					// ShowSV() ;
					scno.setEnabled(false);
					scstatus.setText("Close");
				}
				btnSVPosting.setEnabled(false);
				btnShowSV.setEnabled(true);
				scno.setEnabled(false);
				scno.setEditable(true);
				scno.setBackground(Color.cyan);
				new gnTable().RemoveTableRows(model);
			}
		}
	}

	public void showVarianceTable(String SQL, String[] Colnames) throws Throwable {
		rs = this.getSPResult(SQL);
		((DefaultTableModel) model).setColumnIdentifiers(Colnames);
		table.setModel(model);
		new gnTable().RemoveTableRows(model);
		while (rs.next()) {
			model.addRow(new Object[] { "-", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
					rs.getString(15) });
			table.setModel(model);
			String vbatchArticle = rs.getString(5);
			String value = rs.getString(1);
			table.setRowSelectionAllowed(true);
			new gnTable().setTablewidth(table, 0, 20);
			new gnTable().setTablewidth(table, 2, 300);
			new gnTable().setTablewidth(table, 1, 100);
			// selectedrow = table.getRowCount()-1;
		}
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		records.setText(RecordCount1);
		table.setEnabled(true);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.YELLOW);
		table.setBackground(Color.white);
		// DefaultCellEditor nk = new gnTable().cellEdit(table) ;
		// nk.addCellEditorListener(ChangeNotification);
		JViewport prt6 = new JViewport();
		prt6.setToolTipText("Stock Variance Data Panel");
		prt6.add(table, articlecol);
		prt6.setVisible(true);
		jsp.setViewport(prt6);
	}// End Show Table

	class btnCancelStock implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id

			if (value == "Cancel Stock Check")
				;
			{
				int option = new General().msgInput(
						"Stock Check Cancel Option will Close Stock check without Processing  Further Action. Are You sure");
				if (option == 0) {
					try {
						new gnStockcheck().closeOpenStock(scno.getText());
						scno.setText(null);
						scstatus.setText(null);
						scdate.setText(null);
						new gnTable().RemoveTableRows(model);
						btnSave.setEnabled(true);
						btnUpdate.setEnabled(false);
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
			}

		}
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
			String SQL = "Call   SC_FetchvariancebyBatch(  " + vscno + " ,  " + vcomp + " ,  " + vstore + " , '"
					+ vbatch + "', '" + vfinyear + "' )";
			try {
				new gnTable().RemoveTableRows(model);
				// showTable(SQL, articlecol) ;
				showVarianceTable(SQL, variancecol);
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
			String SQL = "Call   SC_FetchvariancebyName(  " + vscno + " ,  " + vcomp + " ,  " + vstore + " , '" + vname
					+ "' , '" + vfinyear + "')";
			try {
				new gnTable().RemoveTableRows(model);
				// showTable(SQL, articlecol) ;
				showVarianceTable(SQL, variancecol);
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
				new gnAdmin().showMasterTable(vtype, brandcode, brandname);
			} catch (Throwable e2) {
				e2.printStackTrace();
			} finally {
				vscno = scno.getText();
				// String vbrandcode = new gnBrand().rbrandcode;
				String vbrandcode = brandcode.getText();
				vcomp = companycode.getText();
				vstore = sitecode.getText();
				String SQL = "Call   SC_FetchvarianceBrandArticles(  " + vscno + " ,  " + vcomp + " ,  " + vstore
						+ " , '" + vbrandcode + "' , '" + vfinyear + "')";
				try {
					new gnTable().RemoveTableRows(model);
					showVarianceTable(SQL, variancecol);
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
				String SQL = "Call sc_scanatricle(" + vcode + " , " + vcomp + ")";
				showTable(SQL, articlecol);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
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
				scstatus.setText(new gnStockcheck().rscstatus);
				String vcomp = companycode.getText();
				String vstore = sitecode.getText();
				String vscno = scno.getText();

				if (vscno.length() > 0) {
					try {
						String SQL = "Call  SC_ShowStockvarinace( " + vcomp + " ,  " + vstore + " ,  " + vscno + "  , '"
								+ vfinyear + "' )";
						new gnTable().RemoveTableRows(model);
						showVarianceTable(SQL, variancecol);
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().msg("Stock Variance  Data Fetch" + " " + e1.getMessage());
					}
				}
			}
		}
	}

	private void showProcessView() throws MalformedURLException, IOException {
		String InfoText = "                                                    PROCESS  STEPS                       "
				+ System.lineSeparator() + " "
				+ "Stock check Process is Important in Organation to Varify and  Correct Physical and System Stock.  "
				+ System.lineSeparator() + ""
				+ "Before Start Stock Ceck Make Sure All Transaction Related to Inventory is Completed.   "
				+ System.lineSeparator() + " " + "1.Select Proper Stock Location For Stock Check.     "
				+ System.lineSeparator() + " " + "2.Arrange Physical Inventory for Counting. " + System.lineSeparator()
				+ "" + "3.Scan OR Enter Article Code < You can Take Item Search Help.   " + System.lineSeparator() + ""
				+ "4.After Scaning Over, Calculate Stock Variance and Check difference.  " + System.lineSeparator() + ""
				+ "5.If Any correction is required you can Do through Stock chek Module. " + System.lineSeparator() + ""
				+ "6.Enter Same Stock no and  Correct Physical Entry. " + System.lineSeparator() + "";
		String Heading = "Stock check Process Overview ";
		new showHelp().showHelp(InfoText, Heading);

	}

	class btn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id

			if (value == "Get Process OverView") {
				try {
					showProcessView();
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Post Stock Voucher") {
				new General().msg("Posting SV Now");
				try {
					PostSV();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Show Stock Vouchers") {
				try {
					ShowSV();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Close") {
				SVPosting.dispose();
			}

			if (value == "Export To Excel") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

		}
	}

	private void showBatchPriceHelp() throws Throwable {
		int row = table.getSelectedRow();
		String vbatchcontrol = (String) table.getValueAt(row, 5);
		String varticle = (String) table.getValueAt(row, 1);
		CheckBatchArticle(vbatchcontrol, varticle);
	}

	public void showTable(String SQL, String[] Colnames) throws Throwable {
		// CheckBatchArticle();
		rs = this.getSPResult(SQL);
		((DefaultTableModel) model).setColumnIdentifiers(Colnames);
		table.setModel(model);
		while (rs.next()) {
			model.addRow(new Object[] { "Remove", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10), rs.getString(11) });
			table.setModel(model);
			new gnTable().setTableBasics(table);

			String vbatchArticle = rs.getString(5);
			String value = rs.getString(1);
			new gnTable().setTablewidth(table, 0, 20);
			selectedrow = table.getRowCount() - 1;
			// CheckBatchArticle(vbatchArticle,value ) ;
			new gnTable().setTablewidth(table, 2, 300);
			new gnTable().setTablewidth(table, 1, 100);
		}
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
		prt6.setToolTipText("Data Panel");
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
				// CheckBatchArticle(vbatchcontrol , varticle ) ;
				// selectedrow = row ;
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
			String SQL = "Call sv_getbatchprices(" + vstorecode + " ,   " + varticle + ", " + vcomp + ", '" + vloc
					+ "' , '" + vfinyear + "')";
			showSearch(SQL, batch);
			break;
		case "N":
			String SQL1 = "Call sv_getnonBatchprices(" + vstorecode + " ,   " + varticle + " , " + vcomp + ",  '" + vloc
					+ "' , '" + vfinyear + "' )";
			showSearch(SQL1, batch);
			break;
		}
		return status;
	}// Method End

	public void showSearch(String SQL, String[] Colnames) throws Throwable {
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
		JViewport prt6 = new JViewport();
		nk.addCellEditorListener(ChangeNotification1);
		prt6.setToolTipText("Scrollpane Port");
		prt6.add(stable, Colnames);
		prt6.setVisible(true);
		sjsp.setViewport(prt6);
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
	private JButton btnShowVariance;
	private JButton btnCalVariance;
	private JButton btnProcess;
	private JTextField brandcode;
	private JTextField brandname;
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;

	public void displayInfo(String vtype, int row) {
		new General().msg(vtype);
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
		vscno = new gnSeq().getSeqno("103", "TR");
		scno.setText(vscno);
		scdate.setText(new General().getDate());
	}

	private void updateSCno() throws Throwable {
		new gnSeq().updateSeqno("103", "TR");
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
			vscno = scno.getText();
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
				+ "cost ,  SalesPrice,    MRP , location,srno , Finyear) "
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
					+ "Stock_check_no , Stock_check_date , " + "status ,  Stock_check_type , createdBy , finyear) "
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
				TotalRecordinsert = TotalRecordinsert + 1;
				DBhdr = "Fail";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBhdr = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DBhdr = "Sucess";
			} catch (SQLException e) {
				new General().msg("Header " + e.getMessage());
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
					vscno = scno.getText();
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
			vscno = scno.getText();
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
				+ "cost ,  SalesPrice,    MRP , location,srno, finyear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?)";
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
				vscno = scno.getText();
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

		scno.setText(null);
		scstatus.setText(null);
		new gnTable().RemoveTableRows(model);
		records.setText(null);
	}
}// last

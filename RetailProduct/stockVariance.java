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

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.mysql.jdbc.Connection;
import javax.swing.ImageIcon;

public class stockVariance extends getResultSet {

	JFrame stockVarianceFrame;
	private Connection con, con1, con2, con3, con4, con5, con6, con7, con8;
	private JTextField sitecode;
	private String FileterChoice;
	private JLabel locationlbl;
	private String vfinyear;
	private String DBdetail;
	private JButton btnShow;
	private JButton btnSVposting;
	private JTextField scstatus;
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
					stockVariance window = new stockVariance();
					window.stockVarianceFrame.setVisible(true);
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
	public stockVariance() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {

		stockVarianceFrame = new JFrame();
		stockVarianceFrame.setAutoRequestFocus(false);
		stockVarianceFrame.setAlwaysOnTop(true);
		stockVarianceFrame.getContentPane().setForeground(Color.GREEN);
		// stockVarianceFrame.setBounds(0, 0, 1376, 765);
		stockVarianceFrame.setBounds(1, 100, 1376, 600);

		stockVarianceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		stockVarianceFrame.getContentPane().setLayout(null);
		// stockVarianceFrame.getContentPane().add(internalFrame);
		stockVarianceFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1361, 587);
		panel.setBorder(new LineBorder(new Color(255, 255, 204), 8, true));
		stockVarianceFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblBranchCode = new JLabel("Branch Code");
		lblBranchCode.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblBranchCode.setBounds(804, 19, 99, 16);
		panel.add(lblBranchCode);

		sitecode = new JTextField();
		sitecode.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		sitecode.setBackground(Color.WHITE);
		sitecode.setEditable(false);
		sitecode.setBounds(897, 16, 87, 30);
		panel.add(sitecode);
		sitecode.setColumns(10);

		sitename = new JTextField();
		sitename.setBackground(Color.WHITE);
		sitename.setEditable(false);
		sitename.setForeground(new Color(153, 51, 153));
		sitename.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		sitename.setBounds(984, 16, 261, 30);
		panel.add(sitename);
		sitename.setColumns(10);

		JLabel lblSvNo = new JLabel("Stock Check No");
		lblSvNo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblSvNo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSvNo.setBounds(258, 68, 111, 16);
		panel.add(lblSvNo);

		scno = new JTextField();
		scno.setBounds(254, 88, 99, 28);
		panel.add(scno);
		ActionListener sc = new StockCheckno();
		scno.addActionListener(sc);
		scno.setColumns(10);

		JLabel lblSvdate = new JLabel("Stock Check Date");
		lblSvdate.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblSvdate.setBounds(369, 68, 108, 16);
		lblSvdate.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblSvdate);

		scdate = new JTextField();
		scdate.setEditable(false);
		scdate.setBounds(365, 88, 112, 28);
		panel.add(scdate);
		scdate.setColumns(10);

		JLabel lblNoofRecords = new JLabel("No.of Records");
		lblNoofRecords.setBounds(660, 117, 87, 16);
		panel.add(lblNoofRecords);

		records = new JTextField();
		records.setFont(new Font("Tahoma", Font.BOLD, 14));
		records.setForeground(new Color(153, 51, 204));
		records.setEditable(false);
		records.setBounds(747, 117, 55, 25);
		panel.add(records);
		records.setColumns(10);

		JLabel lblNewLabel = new JLabel("Company");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblNewLabel.setBounds(310, 16, 87, 19);
		panel.add(lblNewLabel);

		companycode = new JTextField();
		companycode.setHorizontalAlignment(SwingConstants.LEFT);
		companycode.setBackground(Color.WHITE);
		companycode.setEditable(false);
		companycode.setBounds(403, 13, 87, 30);
		panel.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setHorizontalAlignment(SwingConstants.LEFT);
		companyname.setBackground(Color.WHITE);
		companyname.setForeground(new Color(153, 51, 153));
		companyname.setEditable(false);
		companyname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		companyname.setBounds(490, 13, 261, 30);
		panel.add(companyname);
		companyname.setColumns(10);

		locationlbl = new JLabel("Stock Location");
		locationlbl.setBounds(747, 68, 82, 16);
		panel.add(locationlbl);

		location = new JComboBox();
		// location.setModel(new DefaultComboBoxModel(new String[] {"SL"}));
		location.setBounds(660, 65, 87, 22);
		panel.add(location);

		locationname = new JTextField();
		locationname.setEditable(false);
		locationname.setText("Salable Inventory ");
		locationname.setHorizontalAlignment(SwingConstants.LEFT);
		locationname.setBounds(660, 89, 189, 22);
		panel.add(locationname);
		locationname.setColumns(10);

		sjsp = new JScrollPane();
		sjsp.setBounds(12, 531, 1332, 122);
		// panel.add(sjsp);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(51, 204, 204), 5, true));
		panel_1.setBounds(12, 177, 1342, 86);
		panel.add(panel_1);
		panel_1.setLayout(null);

		scanitem = new JTextField();
		scanitem.setFont(new Font("Arial Black", Font.BOLD, 16));
		scanitem.setBounds(13, 32, 93, 27);
		panel_1.add(scanitem);
		scanitem.setColumns(10);
		scanitem.setVisible(false);

		JLabel item = new JLabel("Scan Item Here");
		item.setVisible(false);
		item.setBounds(12, 13, 94, 16);
		panel_1.add(item);

		searchname = new JTextField();
		searchname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		searchname.setBounds(110, 33, 103, 27);
		searchname.setVisible(false);
		panel_1.add(searchname);
		ActionListener name = new lsnritemName();
		searchname.addActionListener(name);
		searchname.setColumns(10);

		JLabel name1 = new JLabel("Search By Name");
		name1.setBounds(111, 13, 102, 16);
		name1.setVisible(false);
		panel_1.add(name1);
		ActionListener brnd = new lsnrbrand();
		ActionListener btnls = new btn();

		btnShowVariance = new JButton("Show Variance");
		btnShowVariance.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		btnShowVariance.setEnabled(false);
		btnShowVariance.setBounds(389, 28, 158, 44);
		ActionListener vranshow = new btn();
		btnShowVariance.addActionListener(vranshow);
		panel_1.add(btnShowVariance);

		btnCalVariance = new JButton("Calculate  Variance ");
		btnCalVariance.setForeground(new Color(0, 0, 153));
		btnCalVariance.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnCalVariance.setBounds(225, 28, 163, 44);
		ActionListener vcalvar = new btn();
		btnCalVariance.addActionListener(vcalvar);
		panel_1.add(btnCalVariance);

		optionPanel = new JPanel();
		optionPanel.setBounds(550, 7, 493, 72);
		panel_1.add(optionPanel);
		optionPanel.setBackground(new Color(153, 255, 255));
		optionPanel.setBorder(new TitledBorder(null, "Data Filter  Options", TitledBorder.CENTER, TitledBorder.TOP,
				null, new Color(0, 0, 153)));
		optionPanel.setVisible(false);
		optionPanel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Serach by Name");
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(12, 17, 147, 16);
		optionPanel.add(lblNewLabel_3);

		showname = new JTextField();
		showname.setBounds(12, 37, 147, 30);

		optionPanel.add(showname);
		showname.setColumns(10);

		button = new JButton("");
		button.setBackground(new Color(0, 0, 153));
		button.setEnabled(false);
		button.setBounds(171, 17, 4, 56);
		optionPanel.add(button);

		JLabel lblNewLabel_6 = new JLabel("Brand- Filter");
		lblNewLabel_6.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_6.setBounds(187, 17, 127, 16);
		optionPanel.add(lblNewLabel_6);

		searchbrand = new JTextField();
		searchbrand.setBounds(187, 37, 133, 30);
		optionPanel.add(searchbrand);
		searchbrand.addActionListener(brnd);
		searchbrand.setColumns(10);

		brandcode = new JTextField();
		brandcode.setEnabled(false);
		brandcode.setEditable(false);
		brandcode.setBounds(322, 22, 79, 22);
		optionPanel.add(brandcode);
		brandcode.setColumns(10);

		brandname = new JTextField();
		brandname.setEnabled(false);
		brandname.setEditable(false);
		brandname.setBounds(322, 45, 79, 22);
		optionPanel.add(brandname);
		brandname.setColumns(10);
		
				JLabel lblNewLabel_5 = new JLabel("Batch Article");
				lblNewLabel_5.setBounds(406, 25, 79, 16);
				optionPanel.add(lblNewLabel_5);
				lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
				
						combobatch = new JComboBox();
						combobatch.setBounds(416, 45, 69, 22);
						optionPanel.add(combobatch);
						combobatch.setFont(new Font("Tahoma", Font.BOLD, 13));
						combobatch.setModel(new DefaultComboBoxModel(new String[] { "N", "Y" }));
						
								JButton button_2 = new JButton("");
								button_2.setBounds(406, 17, 4, 56);
								optionPanel.add(button_2);
								button_2.setBackground(new Color(0, 0, 153));
								button_2.setEnabled(false);
						optionPanel.setFocusTraversalPolicy(
								new FocusTraversalOnArray(new Component[] { showname, searchbrand, combobatch }));
						
								 

		btnSVposting = new JButton("Post Stock Variance");
		btnSVposting.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		btnSVposting.setBounds(1066, 28, 183, 44);
		panel_1.add(btnSVposting);
 		searchbrand.setVisible(true);
 
		ActionListener exp = new btn();
		ActionListener btnprocee = new btn();
		ActionListener varince = new btn();
		ActionListener nam = new showbyname();
		ActionListener batch = new showbyBatchControl();

		scstatus = new JTextField();
		scstatus.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		scstatus.setEnabled(false);
		scstatus.setBounds(482, 87, 87, 28);
		panel.add(scstatus);
		scstatus.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setBounds(902, 262, 97, 25);
		panel.add(btnSave);
		btnSave.addActionListener(btnls);
		btnSave.setMnemonic('S');

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(999, 262, 97, 25);
		panel.add(btnUpdate);
		btnUpdate.setMnemonic('U');

		jsp = new JScrollPane();
		jsp.setBounds(12, 291, 1342, 283);
		panel.add(jsp);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.DARK_GRAY));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(193, 13, 1144, 48);
		panel.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel_1 = new JLabel("Stcok Check Module");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(12, 68, 131, 16);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setIcon(new ImageIcon(stockVariance.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_2.setBounds(12, 0, 131, 149);
		panel.add(lblNewLabel_2);

		btnShow = new JButton("Get Batch & Price Details");
		btnShow.setBounds(1168, 139, 48, 25);
		panel.add(btnShow);
		btnShow.setEnabled(false);
		btnShow.setMnemonic('B');
		
				btnClose = new JButton("Close");
				btnClose.setIcon(new ImageIcon(stockVariance.class.getResource("/RetailProduct/delete.png")));
				btnClose.setBounds(1200, 68, 137, 44);
				panel.add(btnClose);
				btnClose.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
				btnClose.setMnemonic('C');
				btnClose.addActionListener(btnls);
		btnShow.setVisible(false);
		btnShow.addActionListener(btnls);
		btnUpdate.addActionListener(btnls);
		panel.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { scno, location, scanitem, searchname }));
		ActionListener article = new lsarticlecode();
		scanitem.addActionListener(article);
		showname.addActionListener(nam);
		btnSVposting.addActionListener(exp);
		combobatch.addActionListener(batch);
		 decorate();
		// checkOpenStockcheckno();
	}

	public void decorate() throws Throwable {

		new gnApp().setFrameTitel(stockVarianceFrame);
		stockVarianceFrame.setUndecorated(true);
		
		new gnDecorate().decorateField(sitecode);
		new gnDecorate().decorateField(sitename);
		new gnDecorate().decorateField(scdate);
		new gnDecorate().decorateField(locationname);
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		sitecode.setText(new gnConfig().getStoreID());
		String vstore = sitecode.getText();
		vfinyear = new gnFinYear().getReportingFinYear();
		sitename.setText(new gnConfig().getStorename(vstore));
		btnUpdate.setEnabled(false);
		btnSave.setEnabled(false);
		scanitem.setEnabled(false);
		btnSave.setVisible(false);
		btnUpdate.setVisible(false);
		btnShowVariance.setEnabled(false);
		scanitem.setBackground(Color.CYAN);
		searchname.setEnabled(false);
		searchname.setBackground(Color.CYAN);
		locationlbl.setVisible(true);
		location.setVisible(true);
		locationname.setVisible(false);

		switch (vstore) {
		case "0":
			System.exit(0);
		}

		String vrole = new gnConfig().getRoleName().toUpperCase();
		switch (vrole) {
		case "MANAGER":
			// btnSCCancel.setEnabled(true);
			btnSVposting.setEnabled(true);
			break;
		case "CASHIER":
			// btnSCCancel.setEnabled(false);
			btnSVposting.setEnabled(false);
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
		// new General().msg(SQL);
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

	private void callShowVariance() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vscno = scno.getText();
		if (vscno.length() == 0) {
			new General().msg("Select Stock Check Number ..");
			return;
		}
		String vloc = location.getSelectedItem().toString();
		String SQL = "Call  SC_ShowStockvarinace( " + vcomp + " ,  " + vstore + " ,  " + vscno + ", '" + vfinyear
				+ "' )";
		// new General().msg(SQL);
		showVarianceTable(SQL, variancecol);
		optionPanel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				"Variance Data Filter  Options", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 50, 51)));
		table.setEnabled(false);
		FileterChoice = "Variance";
		optionPanel.setVisible(true);
	}

	private void calculateVariance() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vscno = scno.getText();
		vscno = scno.getText();
		if (vscno.length() == 0) {
			new General().msg("Select Stock Check Number ..");
			return;
		}
		String vloc = location.getSelectedItem().toString();
		// new General().msg(vloc);

		String SQL9 = "Call  SC_GenerateVariance ( " + vcomp + " ,  " + vstore + " ,   " + vscno + "  , '" + vloc
				+ "' , '" + vfinyear + "')";
		// new General().msg(SQL9);
		String status = this.getResult(SQL9);

		/*
		 * String SQL1 = "Call   sc_flush_stockVariance()" ; //new
		 * General().msg(SQL1); this.getResult(SQL1) ;
		 * 
		 * 
		 * String SQL = "Call  SC_GenerateVarianceforNonBatch( "+vcomp+" ,  "
		 * +vstore+" ,   "+vscno+" )" ; //new General().msg(SQL); String status
		 * = this.getResult(SQL) ;
		 * 
		 * String SQL2 = "Call  SC_GenerateVarianceforBatch( "+vcomp+" ,  "
		 * +vstore+" ,   "+vscno+" )" ; //new General().msg(SQL2); String
		 * status2 = this.getResult(SQL2) ;
		 * 
		 * String SQL3 = "Call  SC_GenerateVarianceforBatch1( "+vcomp+" ,  "
		 * +vstore+" ,  "+vscno+" )" ; String status3 = this.getResult(SQL3) ;
		 */

		String status2 = "Sucess";
		String status3 = "Sucess";

		if (status == "Sucess" && status2 == "Sucess" && status3 == "Sucess") {
			int option = new General().msgInput("Would you Like View Stock Variance Data .. ");
			if (option == 0) {
				callShowVariance();
			}
			btnCalVariance.setEnabled(false);
			btnShowVariance.setEnabled(true);
			scno.setEnabled(false);
			scno.setEditable(true);
			scno.setBackground(Color.cyan);
		}
	}

	public void showVarianceTable(String SQL, String[] Colnames) throws Throwable {
		// CheckBatchArticle();
		rs = this.getSPResult(SQL);
		((DefaultTableModel) model).setColumnIdentifiers(Colnames);
		table.setModel(model);
		new gnTable().RemoveTableRows(model);
		while (rs.next()) {
			model.addRow(new Object[] { "Remove", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
					rs.getString(15) });
			table.setModel(model);
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
					+ vbatch + "' , '" + vfinyear + "')";
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
						+ " , '" + vbrandcode + "', '" + vfinyear + "' )";
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
						String SQL = "Call SC_FetchStockcheckData( " + vscno + " , " + vcomp + ",  " + vstore + ", '"
								+ vfinyear + "' )";
						new gnTable().RemoveTableRows(model);
						showTable(SQL, articlecol);
						FileterChoice = "Physical";
						optionPanel.setBorder(new TitledBorder(
								new BevelBorder(BevelBorder.RAISED, null, null, null, null), "Data Filter  Options",
								TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().msg("Stock Check Data Fetch" + " " + e1.getMessage());
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
			if (value == "Get Batch & Price Details") {
				try {
					showBatchPriceHelp();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Get Process OverView") {
				try {
					showProcessView();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Calculate  Variance ") {
				try {
					calculateVariance();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Show Variance") {
				try {
					callShowVariance();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Post Stock Variance") {
				try {
					SVPosting window = new SVPosting();
					window.SVPosting.setVisible(true);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Close") {
				stockVarianceFrame.dispose();
			}

			if (value == "Export To Excel") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

			if (value == "Generate Stock Variance ") {
				// new General().msg("Under Development..");
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
			location.addItem(rs.getString(12));
			location.setEnabled(false);
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
					+ "' , '" + vfinyear + "')";
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
	private JTextField brandcode;
	private JTextField brandname;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

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
				+ "cost ,  SalesPrice,    MRP , location,srno, finyear) "
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
				prst.setString(11, new gnFinYear().getReportingFinYear());
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
				prst.setString(8, new gnFinYear().getReportingFinYear());
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
				+ "cost ,  SalesPrice,    MRP , location,srno) " + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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

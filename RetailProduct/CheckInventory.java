package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.ImageIcon;

public class CheckInventory extends getResultSet {

	Connection con, con1, con2;
	private JTextField brandname;
	JInternalFrame internalFrame;
	JButton btnVarient;
	private JTextField date;
	JButton btnShowBatchforAll;
	JButton btnArticleBatch;
	String reportType;
	JButton btnStock;
	String tableEntry = "N";
	private JTextField company;
	private JButton btnBatch;
	JButton btnClose;
	String vcode = "0"; // This is used when code needs to pass to store
						// procedure view_StockData procesure
	private String vstorecode;
	private JComboBox location;
	private String vgrnDate;
	private String vselectedLoc;
	private int vgrnno;
	private String vtype = "WP";
	private int vvendor;
	private String vinvno;
	private String vinvDate;
	private Double vinvamt;
	private Double vcostvalue;
	private Double vothcharges;
	private Double vtotalamount;
	private String vcreateBy = "Admin";
	private String vupdateDate;
	private int TotalRecordinsert = 0;
	private String DBaction = "Fail";
	private String DBhdr = "Fail";
	private String DBdetail = "Fail";
	private String DBstock = "Fail";
	private JTextField scanName;
	String vfinyear;
	//

	private JButton btnBrand;
	private JButton btnSubGroup;
	private JButton btnGroup;
	private JButton btnCategory;
	private JButton btnSubCategory;
	private JButton btnArticleitem;
	private JButton btnExportToExcel;

	/// end table Varibales

	JFrame frameInventoryApplication;
	private JTextField grndate;
	private JTextField grnno;
	private JTextField InvoiceNumber;
	private JTextField InvoiceDate;
	private JTextField TotalAmount;
	private JTextField InvAmt;
	private String vcomp;
	private String vstore;
	JButton btnExpiry;
	JButton btnExpdays;
	JPanel panel_1;
	private JTextField scanItem;
	private JTextField records;
	private JTextField Storecode;
	private JTextField storename;
	private JTextField SupplierPayable;
	private JTextField Othcharges;
	// For Customer Search
	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public JViewport prt6 = new JViewport();
	public JScrollPane sjsp;
	public JScrollPane jsp;
	String vverticle = "";

	// For Item Name Search
	public DefaultTableModel nmodel = new DefaultTableModel();
	public JTable ntable = new JTable();
	public String SCol[] = { "Customer code", "Name", "Phone", "Email" };
	public String ACol[] = { "Item Code", "Name", "MRP", "Sales Price" };
	public String AdetailCol[] = { "Item Code", "Name", "Op.Stock", "Purchase", "Pur.Return", "Sales", "Sales Return",
			"TO", "TI", "Stk.Adj.+", "Stk.Adj -", "Loc.Trf", "Balance Stock" };
	public String PoCol[] = { "Article_code", "Name", "Balance Qty", "UOM", "Cost", "cost value ", "MRP", "Sales price",
			"Batch_Control" };
	public String batchCol[] = { "Article_code", "Name" };

	DefaultTableModel model = new DefaultTableModel() {
		/*
		 * Class[] types = new Class [] { //{"Article_code" , "Name" , "Qty" ,
		 * "UOM" , "cost" , "CostValue " ,"Trans.Chrg" , "Manuf.Chrg" ,
		 * "Packing Chrgs" , "Landing Cost", "Tax%"}; java.lang.String.class,
		 * java.lang.String.class, java.lang.Double.class,
		 * java.lang.String.class, java.lang.Double.class,
		 * java.lang.Double.class , java.lang.Double.class ,
		 * java.lang.Double.class , java.lang.Double.class,
		 * java.lang.Double.class, java.lang.Double.class };
		 * 
		 * @Override public Class getColumnClass(int columnIndex) { return types
		 * [columnIndex]; }
		 */
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 1 || column == 3 || column == 4 || column == 5 || column == 6 || column == 7
					? false : true;
		}
	};

	//// Table Related
	public DefaultTableModel pmodel = new DefaultTableModel();

	public JTable table = new JTable();
	/*
	 * { public Component prepareRenderer(TableCellRenderer rendererr, int roww,
	 * int column) { Component componentt = super.prepareRenderer(rendererr,
	 * roww, column); if (column == 0 || column==1|| column ==3 || column ==4 ||
	 * column ==5|| column ==6 || column ==7 ) {
	 * componentt.setBackground(Color.DARK_GRAY);
	 * componentt.setForeground(Color.white
	 * 
	 * componentt.setCursor(getCursor()); componentt.setFont(new Font("Calibri",
	 * Font.PLAIN, 13)); } else { componentt.setBackground(Color.);
	 * componentt.setForeground(Color.BLUE); componentt.setFont(new
	 * Font("Calibri", Font.BOLD, 14));
	 * 
	 * } if (roww == 0 ) { componentt.setBackground(Color.BLACK);
	 * componentt.setForeground(Color.WHITE); componentt.setCursor(getCursor());
	 * componentt.setFont(new Font("Calibri", Font.BOLD, 14)); } return
	 * componentt; } };
	 */

	///

	// public JTable ptable = new JTable() ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckInventory window = new CheckInventory();
					window.frameInventoryApplication.setVisible(true);
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
	public CheckInventory() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frameInventoryApplication = new JFrame();
		frameInventoryApplication.setResizable(false);
		frameInventoryApplication.setAlwaysOnTop(true);
		frameInventoryApplication.setTitle("Business Application");
		//frameInventoryApplication.setBounds(1, 100, 1350, 700);
		frameInventoryApplication.setBounds(1, 100, 1350, 600);
 		frameInventoryApplication.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameInventoryApplication.getContentPane().setLayout(null);

		/*
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.RED);
		desktopPane.setBounds(0, 0, 1350, 750);
		frameInventoryApplication.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

 		internalFrame = new JInternalFrame(compName);
		internalFrame.setBounds(0, 0, 1350, 750);
		//frameInventoryApplication.getContentPane().add(internalFrame);

        */

		String compName = new gnConfig().getCompany();
		
 
		frameInventoryApplication.setBackground(Color.WHITE);
  		frameInventoryApplication.setLayout(null);

		
		// JPanel panel = new JPanel();
		JPanel panel = new gnRoundPanel();

		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLACK);
		panel.setBorder(new MatteBorder(0, 9, 0, 0, (Color) new Color(148, 0, 211)));
		panel.setBounds(0, 0, 1250, 109);
		frameInventoryApplication.add(panel);
		panel.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(153, 255, 102)));
		panel_4.setBounds(444, 0, 767, 51);
		panel.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblStoreCode = new JLabel("Store Code");
		lblStoreCode.setFont(new Font("Calibri", Font.BOLD, 14));
		lblStoreCode.setBounds(109, 0, 85, 16);
		panel_4.add(lblStoreCode);

		Storecode = new JTextField();
		Storecode.setBackground(Color.WHITE);
		Storecode.setFont(new Font("Arial", Font.BOLD, 14));
		Storecode.setEditable(false);
		Storecode.setBounds(96, 20, 49, 27);
		panel_4.add(Storecode);
		Storecode.setColumns(10);
		Storecode.setText(new gnConfig().getStoreID());

		storename = new JTextField();
		storename.setBackground(Color.WHITE);
		storename.setFont(new Font("Arial", Font.BOLD, 14));
		storename.setEditable(false);
		storename.setBounds(146, 20, 387, 27);
		panel_4.add(storename);
		storename.setColumns(10);
		String vname = Storecode.getText();
		storename.setText(new gnConfig().getStorename(vname));

		JLabel lblCompany = new JLabel("Company ");
		lblCompany.setFont(new Font("Calibri", Font.BOLD, 14));
		lblCompany.setBounds(12, 1, 85, 16);
		panel_4.add(lblCompany);

		company = new JTextField();
		company.setBackground(Color.WHITE);
		company.setFont(new Font("Arial", Font.BOLD, 14));
		company.setForeground(new Color(51, 0, 153));
		company.setEditable(false);
		company.setBounds(12, 20, 72, 27);
		company.setText(new gnConfig().getCompanyCode());
		panel_4.add(company);
		company.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Fin.Year");
		lblNewLabel_2.setBounds(699, 0, 56, 16);
		panel_4.add(lblNewLabel_2);

		finyear = new JTextField();
		finyear.setBounds(651, 21, 116, 22);
		panel_4.add(finyear);
		finyear.setColumns(10);
		ActionListener bnd = new BtnView();
		ActionListener cat = new BtnView();
		ActionListener subcat = new BtnView();
		ActionListener grp = new BtnView();
		ActionListener subgrp = new BtnView();
		ActionListener Item = new BtnView();

		JLabel lblStockAavailbaleAs = new JLabel("Stock Aavailbale As On Date");
		lblStockAavailbaleAs.setFont(new Font("Calibri", Font.BOLD, 13));
		lblStockAavailbaleAs.setBounds(276, 0, 167, 16);
		panel.add(lblStockAavailbaleAs);

		date = new JTextField();
		date.setFont(new Font("Arial", Font.BOLD, 13));
		date.setBackground(Color.WHITE);
		date.setEditable(false);
		date.setBounds(275, 19, 116, 27);
		date.setText(new General().getDate());
		panel.add(date);
		date.setColumns(10);

		brandname = new JTextField();
		brandname.setFont(new Font("Arial", Font.BOLD, 14));
		brandname.setBounds(446, 70, 210, 30);
		panel.add(brandname);
		brandname.setColumns(10);

		JLabel lblEnterNameOf = new JLabel("Enter Name Of Search String");
		lblEnterNameOf.setFont(new Font("Calibri", Font.BOLD, 13));
		lblEnterNameOf.setForeground(new Color(51, 0, 102));
		lblEnterNameOf.setBounds(446, 51, 171, 16);
		panel.add(lblEnterNameOf);

		JLabel lblNewLabel = new JLabel("Select Location");
		lblNewLabel.setBounds(668, 51, 113, 16);
		panel.add(lblNewLabel);

		location = new JComboBox();
		location.setFont(new Font("Agency FB", Font.PLAIN, 17));
		location.setBackground(Color.WHITE);
		location.setMaximumRowCount(20);
		ActionListener loclsnr = new LocLsnr();
		location.addActionListener(loclsnr);
		location.setBounds(668, 72, 103, 30);
		panel.add(location);

		expdays = new JTextField();
		expdays.setFont(new Font("Arial", Font.BOLD, 14));
		expdays.setBounds(350, 72, 87, 30);
		panel.add(expdays);
		expdays.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Exp in Days");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_1.setBounds(351, 51, 83, 16);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("Inventry Data");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setForeground(new Color(128, 0, 128));
		lblNewLabel_4.setBounds(33, 19, 126, 54);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel(" ");
		lblNewLabel_5.setIcon(new ImageIcon(CheckInventory.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_5.setBounds(33, 13, 132, 83);
		panel.add(lblNewLabel_5);

		btnClose = new JButton("Close ");
		btnClose.setBounds(1159, 51, 79, 49);
		panel.add(btnClose);
		btnClose.setIcon(new ImageIcon(CheckInventory.class.getResource("/RetailProduct/btnClose.png")));
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameInventoryApplication.dispose();
			}
		});
		btnClose.setForeground(Color.DARK_GRAY);
		btnClose.setMnemonic('C');

		// panel_1 = new JPanel();
		panel_1 = new gnRoundPanel();

		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new MatteBorder(5, 0, 4, 4, (Color) new Color(51, 255, 204)));
		panel_1.setBounds(0, 192, 1213, 353);
		// frameInventoryApplication.add(panel_1);
		panel_1.setLayout(null);

		jsp = new JScrollPane();
		jsp.setBounds(121, 192, 1213, 353);

		// btnBrand = new JButton("Brand");
		btnBrand = new gnRoundButton("Brand");
		btnBrand.setForeground(new Color(0, 0, 153));
		btnBrand.setBackground(new Color(204, 255, 255));
		btnBrand.setFont(new Font("Arial", Font.BOLD, 13));
		btnBrand.setBounds(27, 75, 160, 30);
		panel_1.add(btnBrand);
		btnBrand.setMnemonic('B');

		// btnCategory = new JButton("Category");
		btnCategory = new gnRoundButton("Category");
		btnCategory.setForeground(new Color(0, 0, 153));
		btnCategory.setBackground(new Color(204, 255, 255));
		btnCategory.setFont(new Font("Arial", Font.BOLD, 13));
		btnCategory.setBounds(27, 168, 160, 30);
		panel_1.add(btnCategory);
		btnCategory.setMnemonic('Y');

		// btnSubCategory = new JButton("Sub Category");
		btnSubCategory = new gnRoundButton("Sub Category");
		btnSubCategory.setForeground(new Color(0, 0, 153));
		btnSubCategory.setBackground(new Color(204, 255, 255));
		btnSubCategory.setFont(new Font("Arial", Font.BOLD, 13));
		btnSubCategory.setBounds(27, 200, 160, 30);
		panel_1.add(btnSubCategory);
		btnSubCategory.setMnemonic('S');

		// btnGroup = new JButton("Group");
		btnGroup = new gnRoundButton("Group");
		btnGroup.setForeground(new Color(0, 0, 153));
		btnGroup.setBackground(new Color(204, 255, 255));
		btnGroup.setFont(new Font("Arial", Font.BOLD, 13));
		btnGroup.setBounds(27, 105, 160, 30);
		panel_1.add(btnGroup);
		btnGroup.setMnemonic('G');

		// btnSubGroup = new JButton("Sub Group");
		btnSubGroup = new gnRoundButton("Sub Group");
		btnSubGroup.setForeground(new Color(0, 0, 153));
		btnSubGroup.setBackground(new Color(204, 255, 255));
		btnSubGroup.setFont(new Font("Arial", Font.BOLD, 13));
		btnSubGroup.setBounds(27, 136, 160, 30);
		panel_1.add(btnSubGroup);
		btnSubGroup.setMnemonic('O');

		// btnArticleitem = new JButton("Article/Item");
		btnArticleitem = new gnRoundButton("Article/Item");
		btnArticleitem.setForeground(new Color(0, 0, 153));
		btnArticleitem.setBackground(new Color(204, 255, 255));
		btnArticleitem.setFont(new Font("Arial", Font.BOLD, 13));
		btnArticleitem.setBounds(27, 13, 160, 30);
		panel_1.add(btnArticleitem);
		btnArticleitem.setMnemonic('A');
		btnArticleitem.addActionListener(subgrp);
		btnSubGroup.addActionListener(subgrp);
		btnGroup.addActionListener(grp);
		btnSubCategory.addActionListener(subcat);
		btnCategory.addActionListener(cat);
		btnBrand.addActionListener(bnd);

		sjsp = new JScrollPane();
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(0, 0, 793, 133);
		// panel_2.add(sjsp);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 255, 255));
		panel_5.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(51, 255, 204), new Color(51, 255, 204),
				new Color(51, 255, 255), new Color(0, 255, 255)));
		panel_5.setBounds(0, 108, 1334, 33);
		frameInventoryApplication.add(panel_5);
		panel_5.setLayout(null);

		scanItem = new JTextField();
		scanItem.setFont(new Font("Arial", Font.BOLD, 17));
		scanItem.setToolTipText("Enter Item code if you know");
		scanItem.setBounds(113, 0, 109, 30);
		panel_5.add(scanItem);
		scanItem.setColumns(10);

		JLabel lblScanArticleHere = new JLabel("Scan Article ");
		lblScanArticleHere.setFont(new Font("Cambria", Font.BOLD, 14));
		lblScanArticleHere.setForeground(new Color(0, 0, 153));
		lblScanArticleHere.setBounds(33, 5, 79, 16);
		panel_5.add(lblScanArticleHere);

		scanName = new JTextField();
		scanName.setForeground(new Color(0, 0, 102));
		scanName.setFont(new Font("Arial", Font.BOLD, 17));
		scanName.setToolTipText("Enter Name or start latters to search Items");
		scanName.setBounds(348, 0, 261, 31);
		panel_5.add(scanName);
		scanName.setColumns(10);

		btnExportToExcel = new JButton("Export To Excel");
		btnExportToExcel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExportToExcel.setMnemonic('E');
		btnExportToExcel.setBounds(975, 0, 128, 30);
		ActionListener exp = new BtnView();
		btnExportToExcel.addActionListener(exp);
		panel_5.add(btnExportToExcel);

		btnBatch = new JButton("Batch Details");
		btnBatch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBatch.setMnemonic('D');
		ActionListener exp1 = new BtnView();
		btnBatch.addActionListener(exp1);
		btnBatch.setBounds(866, 0, 109, 30);
		panel_5.add(btnBatch);

		lblNewLabel_3 = new JLabel("Search Here");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_3.setBounds(265, 5, 79, 16);
		panel_5.add(lblNewLabel_3);

		btnStockRoll = new JButton("Stock Audit");
		btnStockRoll.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStockRoll.setBounds(1103, 0, 151, 30);
		panel_5.add(btnStockRoll);

		btnShowStockReq = new JButton("Show Stock Requirement");
		btnShowStockReq.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnShowStockReq.setBounds(688, 1, 177, 29);
		panel_5.add(btnShowStockReq);

		JViewport prt = new JViewport();
		prt.setBackground(new Color(0, 255, 255));
		prt.add(table, PoCol);
		prt.setVisible(true);
		jsp.setViewport(prt);
		new gnTable().setFontBold(table, 11);

		JSplitPane mySplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel_1, jsp);

		btnExpiry = new JButton("Exp. Stock");
		btnExpiry.setForeground(new Color(0, 0, 153));
		btnExpiry.setBackground(new Color(204, 255, 255));
		btnExpiry.setFont(new Font("Arial", Font.BOLD, 13));
		btnExpiry.setBounds(27, 231, 160, 30);
		btnExpiry.addActionListener(subgrp);
		panel_1.add(btnExpiry);

		btnExpdays = new JButton("Exp.in Days");
		btnExpdays.setForeground(new Color(0, 0, 153));
		btnExpdays.setBackground(new Color(204, 255, 255));
		btnExpdays.setFont(new Font("Arial", Font.BOLD, 13));
		btnExpdays.setBounds(27, 263, 160, 30);
		btnExpdays.addActionListener(subgrp);
		panel_1.add(btnExpdays);

		// btnVarient = new JButton( "Attribute Stock");
		btnVarient = new gnRoundButton("Attribute  Stock");

		btnVarient.setBackground(new Color(204, 255, 255));
		btnVarient.setFont(new Font("Arial", Font.BOLD, 13));
		btnVarient.setForeground(new Color(0, 0, 153));
		btnVarient.setBounds(27, 44, 160, 30);
		panel_1.add(btnVarient);

		// btnStock = new JButton("Stock Requirement");
		btnStock = new gnRoundButton("Stock Requirement");
		btnStock.setForeground(new Color(0, 0, 153));
		btnStock.setBackground(new Color(204, 255, 255));
		btnStock.setFont(new Font("Arial", Font.BOLD, 12));
		btnStock.setBounds(27, 366, 160, 30);
		panel_1.add(btnStock);

		// btnShowBatchforAll = new JButton("All Article-Batchwise");
		btnShowBatchforAll = new gnRoundButton("All Article-Batchwise");
		btnShowBatchforAll.setFont(new Font("Arial", Font.BOLD, 12));
		btnShowBatchforAll.setForeground(new Color(0, 0, 153));
		btnShowBatchforAll.setBackground(new Color(204, 255, 255));
		btnShowBatchforAll.setBounds(27, 302, 160, 30);
		panel_1.add(btnShowBatchforAll);

		// btnArticleBatch = new JButton("BatchInfo For Article");
		btnArticleBatch = new gnRoundButton("BatchInfo For Article");
		btnArticleBatch.setFont(new Font("Arial", Font.BOLD, 12));
		btnArticleBatch.setForeground(new Color(0, 0, 153));
		btnArticleBatch.setBackground(new Color(204, 255, 255));
		btnArticleBatch.setBounds(27, 334, 160, 30);
		panel_1.add(btnArticleBatch);

		JLabel lblNewLabel_6 = new JLabel(" ");
		lblNewLabel_6.setIcon(new ImageIcon(CheckInventory.class.getResource("/RetailProduct/ph3.png")));
		lblNewLabel_6.setBounds(-2, 0, 22, 490);
		panel_1.add(lblNewLabel_6);

		mySplit.setBounds(1, 145, 1333, 453);
		mySplit.setDividerLocation(200);
		mySplit.setContinuousLayout(true);
		frameInventoryApplication.add(mySplit);

		lblNewLabel_7 = new JLabel(" ");
		lblNewLabel_7.setIcon(new ImageIcon(CheckInventory.class.getResource("/RetailProduct/graphics4.png")));
		lblNewLabel_7.setBounds(1262, 32, 72, 109);
		frameInventoryApplication.add(lblNewLabel_7);

		ActionListener lsart = new lsarticle();
		scanItem.addActionListener(lsart);

		ActionListener ls7777 = new lsnritemName();
		scanName.addActionListener(ls7777);
		btnVarient.addActionListener(grp);

		ActionListener btnReqLs = new btnReq();
		btnShowBatchforAll.addActionListener(btnReqLs);
		btnArticleBatch.addActionListener(btnReqLs);
		btnStock.addActionListener(btnReqLs);
		btnStockRoll.addActionListener(btnReqLs);
		btnShowStockReq.addActionListener(btnReqLs);
		//internalFrame.setVisible(true);
		decorate();
	}

	private void showRequirementForLevels() throws ClassNotFoundException, SQLException {
		int row = table.getSelectedRow();
		String vtype = "";
		String vname = table.getValueAt(row, 0).toString();
		String vcode = table.getValueAt(row, 4).toString();
		switch (vname) {
		case "Brand":
			vtype = "BrandRequired";
			break;

		case "Category":
			vtype = "CategoryRequired";
			break;

		case "SubCategory":
			vtype = "SubCategoryRequired";
			break;

		case "Group":
			vtype = "GroupRequired";
			break;

		case "SubGroup":
			vtype = "SubGroupRequired";
			break;
		}
		generateRequirementForBrand(vtype, vcode);

	}

	class btnReq implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (value == "Show Stock Requirement") {
				try {
					showRequirementForLevels();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Stock Audit") {
				try {
					StockRollOver window;
					window = new StockRollOver();
					window.stockRollFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Stock Requirement") {
				try {
					String vvtype = "AllITEMRequirement";
					String vvcode = "0";
					generateRequirementForBrand(vvtype, vvcode);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
					new General().msg(e1.getMessage());
				}
			}

			if (value == "All Article-Batchwise") {
				String vcomp = company.getText();
				String vstore = Storecode.getText();
				String vdate = date.getText();
				String vname = brandname.getText();
				vname = "%" + vname + "%";
				vcode = "0";
				String vtype = "ALLBATCHITEM";
				reportType = "ALLBATCHITEM";
				String Col[] = { "Type ", "Article Code", "Name", "Stock Location", "Cost", "MRP", "SalesPrice",
						"Batch.No", "Expiry Date", "Stock In Hand", "Value" };
				String SQL = "call view_StockData1( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname
						+ "' ,  '" + vselectedLoc + "' , '" + vfinyear + "' , " + vcode + "  , " + vverticle + ") ";
				// new General().msg(SQL);
				vtype = "BatchItems";
				try {

					Search(SQL, Col, vtype, 10);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}

			}

			if (value == "BatchInfo For Article") {
				String vcomp = company.getText();
				String vstore = Storecode.getText();
				String vdate = date.getText();
				vcode = scanItem.getText();
				vname = "%%";
				String vtype = "BathForArticle";
				reportType = "BathForArticle";
				String Col[] = { "Type ", "Article Code", "  Name", "Stock Location", "Batch.No", "Expiry Date",
						"Stock In Hand", "Value" };
				String SQL = "call view_StockData1( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname
						+ "' ,  '" + vselectedLoc + "' , '" + vfinyear + "' , " + vcode + "  , " + vverticle + ") ";
				// new General().msg(SQL);
				vtype = "BathForArticle";
				try {

					if (vcode.length() > 0) {
						Search(SQL, Col, vtype, 7);
					} else {
						new General().msg("Select Article First....");
						scanItem.grabFocus();
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}

			}
		}
	}

	private void generateRequirementForBrand(String vvtype, String vvcode) throws ClassNotFoundException, SQLException {
		String vcomp = company.getText();
		String vstore = Storecode.getText();
		String vdate = date.getText();
		String vname = scanName.getText();
		vcode = scanItem.getText();
		vcode = vvcode;
		vname = "%" + vname + "%";
		String vtype = vvtype;
		String Col[] = { "Type ", "Code", " Name", "Location", "MBQ", "Stock In Hand", "RO Level", "Shelf",
				"Stock Required" };
		String SQL = "call view_StockData1( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname + "' ,  '"
				+ vselectedLoc + "' , '" + vfinyear + "' ,  '" + vcode + "'  , " + vverticle + ") ";
 		Search(SQL, Col, vtype, 8);
	}

	class lsnritemName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				if (reportType.length() > 2) {
					getPerticularcode();
				} else {
					shownamesearch();
				}
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	private void getPerticularcode() throws Throwable {
		String vcode = "";
		String vname = "";
		String vtype = "";
		String SQL = "";
		vname = "%" + scanName.getText() + "%";
		vmastersearchString = "%" + scanName.getText() + "%";
		switch (reportType) {
		case "Brand":
			vtype = reportType;
			new gnAdmin().showMasterTable(vtype, scanItem, scanName);
			break;
		case "Group":
			vtype = reportType;
			new gnHierarchy().getHierarchyInfo(vtype, vname);
			scanItem.setText(new gnHierarchy().code);
			scanName.setText(new gnHierarchy().name);
			break;
		case "SubGroup":
			vtype = reportType;
			new gnHierarchy().getHierarchyInfo(vtype, vname);
			scanItem.setText(new gnHierarchy().code);
			scanName.setText(new gnHierarchy().name);
			break;
		case "Category":
			vtype = reportType;
			new gnHierarchy().getHierarchyInfo(vtype, vname);
			scanItem.setText(new gnHierarchy().code);
			scanName.setText(new gnHierarchy().name);
			break;
		case "SubCat":
			vtype = reportType;
			new gnHierarchy().getHierarchyInfo(vtype, vname);
			scanItem.setText(new gnHierarchy().code);
			scanName.setText(new gnHierarchy().name);
			break;
		}

		showForParticular();

	}

	private void showForParticular() throws Throwable {
		String vcomp = company.getText();
		String vstore = Storecode.getText();
		String vdate = date.getText();
		String vname = scanName.getText();
		vcode = scanItem.getText();
		vname = "%" + vname + "%";
		String vtype = reportType;
		String Col[] = { "Type ", "Company ", "Store", "Date", "Code", " Name", "Stock Location", "Stock In Hand",
				"Value" };
		String SQL = "call view_StockData1( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname + "' ,  '"
				+ vselectedLoc + "' , '" + vfinyear + "' , '" + vcode + "'  , " + vverticle + ") ";
		new General().msg(SQL);
		try {
			Search(SQL, Col, reportType, 8);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		reportType = "";
	}

	private void decorate() throws Throwable {
		// scanName.setVisible(false);
		frameInventoryApplication.setUndecorated(true);
		btnStock.setVisible(false);
		new gnApp().setFrameTitel(frameInventoryApplication);
		new gnField().closeform(btnClose, frameInventoryApplication);
		vfinyear = new gnFinYear().getReportingFinYear();
		finyear.setText(vfinyear);
		vverticle = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);

		String vmsname = "Location";
		String vverticle = new gnHierarchy().getVerticleCode();
		// frameInventoryApplication.setIconImage(Toolkit.getDefaultToolkit().getImage(Loginwindow.class.getResource("/RetailProduct/mymain.png")));
		String vsearch = "%%";
		String SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticle + " , '" + vsearch + "')";
		new gnComp().fillCombo(SQL1, location);
		vselectedLoc = "SL";
		expdays.setText("0");
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();

		new gnDecorate().decorateBtn(btnExpdays, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnExpiry, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnBrand, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnBatch, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnArticleitem, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnCategory, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnSubCategory, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnGroup, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnSubGroup, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnStock, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnShowBatchforAll, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnStockRoll, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnShowStockReq, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnStockRoll, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnArticleBatch, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnVarient, Color.MAGENTA, Color.WHITE);

		new gnStyleButtonSqr().getStyleButton(btnShowBatchforAll, new Color(178, 11, 112), Color.WHITE);

		new gnDecorate().decorateBtn(btnExportToExcel, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnClose, Color.BLUE, Color.WHITE);

		/*
		 * new gnStyleButtonSqr().getStyleButton(btnShowBatchforAll,new
		 * Color(178, 11, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnArticleBatch,new Color(178, 11,
		 * 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnArticleitem,new Color(178, 11,
		 * 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnGroup,new Color(178, 11, 112) ,
		 * Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnSubGroup,new
		 * Color(178, 11, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnSubCategory,new Color(178, 11,
		 * 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnCategory,new Color(178, 11, 112)
		 * , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnSubCategory,new Color(178, 11,
		 * 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnBrand,new Color(178, 11, 112) ,
		 * Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnArticleitem,new Color(178, 11,
		 * 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnExpdays,new Color(178, 11, 112)
		 * , Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnExpiry,new
		 * Color(178, 11, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnBatch,new Color(178, 11, 112) ,
		 * Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnExportToExcel,new Color(178, 11,
		 * 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnClose,new Color(178, 11, 112) ,
		 * Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnStock,new
		 * Color(178, 11, 112) , Color.WHITE) ;
		 */

	}

	private void shownamesearch() {
		String sname = scanName.getText().trim();
		String varticle1 = "";
		try {
			String vType = "Article";
			String vtrantype = "POS";
			sname = "%" + sname + "%";
			if (tableEntry == "N") {
				new gnAdmin().Search(vType, sname, varticle1, vtrantype);
			}
		} catch (Throwable e2) {
			e2.printStackTrace();
		} finally {
			try {
				varticle1 = new gnAdmin().rArticle;
				// new General().msg(varticle1);
				if (varticle1.length() != 0) {
					new gnTable().RemoveTableRows(model);
					showArticle(varticle1);
				}
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}

	}

	public void showArticle(String value) throws Throwable {
		String vtype = "StockViewArticle";
		String vname = "bb";
		vfinyear = finyear.getText();

		try {
			String SQL = "call view_StockData( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname
					+ "' ,  '" + vselectedLoc + "' , '" + vfinyear + "' , '" + value + "'  , " + vverticle + ") ";
			vname = "Article";
			tableEntry = "N";
			showTable(SQL, vname, PoCol);
		} catch (Exception e3) {
			new General().msg(e3.getLocalizedMessage());
		} finally {
			if (tableEntry == "N") {
				// shownamesearch() ;
			}
			tableEntry = "N";
		}
	}

	class lsarticle implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vtype = "StockViewArticle";
			if (i == 1001) {
				try {
					String vcode = scanItem.getText();
					String vname = "Article"; // nitink
					// String SQL ="call view_StockData( '"+vtype+"' , "+vcomp+"
					// , "+vstore+" , '"+vname+"' , '"+vselectedLoc+"' ,
					// '"+vfinyear+"' , "+vcode+" ) ";
					// new General().msg(SQL);
					// showTable(SQL, vname, PoCol) ;
					showArticle(vcode);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private void showExpiryStock() {
		String vtype = "ExpiryStock";
		vfinyear = finyear.getText();
		String vname = "";
		String SQL = "call view_StockData( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname + "' ,  '"
				+ vselectedLoc + "' , '" + vfinyear + "' , " + vcode + "  , " + vverticle + ") ";
		// String SQL ="call view_ExpiryStock("+vcomp+", "+vstore+" ,
		// '"+vselectedLoc+"')" ;
		String Col[] = { "Type ", "Company ", "Store", "Article", "Name", "Stock Qty", "Batch", "Expiry Date", "Cost",
				"Value" };
		vtype = "Expiry";
		try {
			Search(SQL, Col, vtype, 9);
		} catch (Exception e) {
			new General().msg("Stock Batch: " + e.getLocalizedMessage());
		}
	}

	class LocLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			vselectedLoc = location.getSelectedItem().toString();
		}
	}

	private String checkDays() {
		String Status = "Sucess";
		int vdays = Integer.parseInt(expdays.getText());
		if (vdays == 0) {
			Status = "Fail";
			new General().msg("Enter Days To Calculate Expiry Stock ");
			expdays.grabFocus();
		}
		return Status;
	}

	private void showExpirynearDays() throws Exception {

		String status = checkDays();
		if (status == "Sucess") {
			int vdays = Integer.parseInt(expdays.getText());
			String vcurdate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
			String vdate = new gnConfig().date_ConverttoDBforamt(new gnConfig().calculateExpiryDate(vcurdate, vdays));
			vfinyear = finyear.getText();
			String SQL = "call view_ExpiryStockindays(" + vcomp + ", " + vstore + " ,  '" + vselectedLoc + "'  , '"
					+ vdate + "' ,  '" + vfinyear + "')";
			// new General().msg(SQL);
			String Col[] = { "Type ", "Company ", "Store", "Article", "Name", "Stock Qty", "Batch", "Expiry Date",
					"Cost", "Value" };
			String vtype = "Expiry";
			try {
				Search(SQL, Col, vtype, 9);
			} catch (Exception e) {
				new General().msg("Stock Batch: " + e.getLocalizedMessage());
			}
		}
	}

	class BtnView implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			vfinyear = finyear.getText();
			scanName.setText(null);
			scanItem.setText("0");
			if (value == "Attribute  Stock") {
				String vcomp = company.getText();
				String vstore = Storecode.getText();
				String vdate = date.getText();
				String vname = brandname.getText();
				vname = "%" + vname + "%";
				String vtype = "Varient";
				String SQL = "call view_StockData( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname
						+ "' ,  '" + vselectedLoc + "' , '" + vfinyear + "' , " + vcode + "  , " + vverticle + ") ";
				// new General().msg(SQL);
				String Col[] = { "Type ", "Code", "Name", "UOM", "BrandName", "SubGRoup", "Size", "Color", "Material",
						"Stock In Hand", "Value", "BatchArticle" };
				vtype = "Varients";
				try {
					Search(SQL, Col, vtype, 11);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Exp. Stock") {
				showExpiryStock();
			}

			if (value == "Exp.in Days") {
				try {
					showExpirynearDays();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Batch Details") {
				try {
					showBatchDetails();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Export To Excel") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

			if (value == "Brand") {
				String vcomp = company.getText();
				String vstore = Storecode.getText();
				String vdate = date.getText();
				String vname = brandname.getText();
				vname = "%" + vname + "%";
				String vtype = "Brand";
				reportType = "Brand";
				String Col[] = { "Type ", "Company ", "Store", "Date", "Brand Code", "Brand Name", "Stock Location",
						"Stock In Hand", "Value" };
				String SQL = "call view_StockData( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname
						+ "' ,  '" + vselectedLoc + "' , '" + vfinyear + "' , " + vcode + "  , " + vverticle + ") ";
				vtype = "Brand";
				try {
					Search(SQL, Col, vtype, 8);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Category") {
				String vcomp = company.getText();
				String vstore = Storecode.getText();
				String vname = brandname.getText();
				vname = "%" + vname + "%";
				String vtype = "Category";
				reportType = "Category";
				String SQL = "call view_StockData( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname
						+ "' ,  '" + vselectedLoc + "' , '" + vfinyear + "' , " + vcode + " , " + vverticle + " ) ";
				// String SQL ="call view_CategoryStock("+vcomp+", "+vstore+" ,
				// '"+vname+"' ,'"+vselectedLoc+"')" ;
				String Col[] = { "Type ", "Company ", "Store", "Date", "Cat Code", " Name", "Stock Location",
						"Stock In Hand", "Value" };
				try {
					Search(SQL, Col, vtype, 8);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Sub Category") {
				String vcomp = company.getText();
				String vstore = Storecode.getText();
				String vname = brandname.getText();
				vname = "%" + vname + "%";
				String vtype = "SubCat";
				reportType = "SubCat";
				String SQL = "call view_StockData( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname
						+ "' ,  '" + vselectedLoc + "' , '" + vfinyear + "' , " + vcode + " , " + vverticle + " ) ";
				String Col[] = { "Type ", "Company ", "Store", "Date", "SubCat Code", " Name", "Stock Location",
						"Stock In Hand", "Value" };
				vtype = "SubCategory";
				try {
					Search(SQL, Col, vtype, 8);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Group") {
				String vcomp = company.getText();
				String vstore = Storecode.getText();
				String vname = brandname.getText();
				vname = "%" + vname + "%";
				String vtype = "Group";
				reportType = "Group";
				String SQL = "call view_StockData( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname
						+ "' ,  '" + vselectedLoc + "' , '" + vfinyear + "' , " + vcode + " , " + vverticle + " ) ";
				String Col[] = { "Type ", "Company ", "Store", "Date", "Group Code", " Name", "Stock Location",
						"Stock In Hand", "Value" };
				vtype = "Group";
				try {
					Search(SQL, Col, vtype, 8);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Sub Group") {
				String vcomp = company.getText();
				String vstore = Storecode.getText();
				String vname = brandname.getText();
				vname = "%" + vname + "%";
				String vtype = "SubGroup";
				reportType = "SubGroup";
				String SQL = "call view_StockData( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname
						+ "' ,  '" + vselectedLoc + "' , '" + vfinyear + "' , " + vcode + " , " + vverticle + " ) ";
				String Col[] = { "Type ", "Company ", "Store", "Date", "SubGroup", " Name", "Stock Location",
						"Stock In Hand", "Value" };
				vtype = "SubGroup";
				try {
					Search(SQL, Col, vtype, 8);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Article/Item") {
				String vcomp = company.getText();
				String vstore = Storecode.getText();
				String vname = brandname.getText();
				vname = "%" + vname + "%";
				String vtype = "ArticleNameWise";
				String SQL = "call view_StockData( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname
						+ "' ,  '" + vselectedLoc + "' , '" + vfinyear + "' , " + vcode + " , " + vverticle + " ) ";
				// new General().msg(SQL);
				String Col[] = { "Article Code", " Name", "Date", "Stock Location", "Stock In Hand", "Value",
						"ShelfName" };
				vtype = "Article";
				try {
					Search(SQL, Col, vtype, 7);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void Search(String SQL, String[] Col, String vtype, int noCol) throws SQLException, ClassNotFoundException {
		// new General().msg(SQL);
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(Col);
		if (vtype != "Article") {
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, noCol, "N", "Y", vtype);
		}

		if (vtype == "Article") {
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, noCol, "N", "N", vtype);
			new gnTable().setTableColWidth(table, 1, 300);
			table.setEnabled(true);
			table.setCellSelectionEnabled(true);
		}
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JViewport prt = new JViewport();
		new gnTable().setTableColWidth(table, 5, 300);
		prt.setBackground(Color.CYAN);
		prt.add(table, Col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		table.setCellSelectionEnabled(true);
		table.setEnabled(true);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification7);
		Selectrow();
	}

	public void Selectrow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {
					display(value, row);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
	}

	private void display(String value, int row) {

		String vcomp = company.getText();
		String vstore = Storecode.getText();
		String vdate = date.getText();
		String vname = brandname.getText();
		vname = "%" + vname + "%";
		vcode = "0";
		String vtype = "";
		vcode = table.getValueAt(row, 4).toString();
		String SQL = "";
		String Col[] = { "Type ", "Article Code", "Name", "Stock Location", "Stock In Hand" };
		switch (value) {
		case "Category":
			vtype = "CategoryItems";
			break;
		case "SubCategory":
			vtype = "SubCategoryItems";
			break;
		case "Group":
			vtype = "GroupItems";
			break;
		case "SubGroup":
			vtype = "SubGroupItems";
			break;
		}
		SQL = "call view_StockData1( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname + "' ,  '"
				+ vselectedLoc + "' , '" + vfinyear + "' , " + vcode + "  , " + vverticle + ") ";
		// new General().msg(SQL);
		try {
			Search(SQL, Col, vtype, 4);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	private void showBatchDetails() throws Throwable {
		int row = table.getSelectedRow();
		String varticle = table.getValueAt(row, 0).toString();
		String vbatchArticle = new gnArticleContent().CheckBatchArticle(varticle);
		String vloc = location.getSelectedItem().toString();
		try {
			new gnGetBatch().getBatchDetail(varticle, vbatchArticle, vloc);
		} catch (Throwable e1) {
			e1.printStackTrace();
		} finally {
			new gnGetBatch().resetValues();
		}
	}

	public void showTable(String SQLGetdata, String type, String[] Colnames) throws Throwable {
		new gnTable().RemoveTableRows(model);
		rs = this.getSPResult(SQLGetdata);
		((DefaultTableModel) model).setColumnIdentifiers(Colnames);
		table.setModel(model);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		if (rs.next()) {
			model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			table.setModel(model);
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			new gnTable().setTablewidth(table, 0, 50);
			new gnTable().setTablewidth(table, 1, 300);
			new gnTable().setTablewidth(table, 3, 40);
			new gnTable().setTablewidth(table, 5, 50);
			table.setEnabled(true);
			table.setRowSelectionInterval(0, 1);
			table.setGridColor(Color.gray);
			table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
			tableEntry = "Y";
			scanItem.setText("0");
		}

	}// End Show Table

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 0);// nitin
			String vtype = "ShowDetails";
			String vname = "";
			String sqldetails = "call view_StockData('" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname
					+ "' ,  '" + vselectedLoc + "' , '" + vfinyear + "' , " + value + ", " + vverticle + "  ) ";
			try {
				AdetailSearch(sqldetails, AdetailCol);
			} catch (SQLException e1) {
				new General().msg(e1.getLocalizedMessage());
			} catch (ClassNotFoundException e1) {
				new General().msg(e1.getLocalizedMessage());
			}
		}
	};

	private void showDetails() {
		int row = table.getSelectedRow();
		String value = (String) table.getValueAt(row, 0);// nitin
		String vtype = "ShowDetails";
		String vname = "";
		vfinyear = finyear.getText();
		String sqldetails = "call view_StockData( '" + vtype + "' ,   " + vcomp + "  , " + vstore + " ,  '" + vname
				+ "' ,  '" + vselectedLoc + "' , '" + vfinyear + "' , " + value + " , " + vverticle + " ) ";

		// String sqldetails = " call inventory_getdetailsforArtilce("+value+",
		// "+vcomp+" ,"+vstore+", '"+vselectedLoc+"' )" ;
		try {
			AdetailSearch(sqldetails, AdetailCol);
		} catch (SQLException e1) {
			new General().msg(e1.getLocalizedMessage());
		} catch (ClassNotFoundException e1) {
			new General().msg(e1.getLocalizedMessage());
		}

	}

	/// artile detail

	public void AdetailSearch(String sqlsearch, String[] Col) throws SQLException, ClassNotFoundException {
		// new General().msg("adetailsearch:"+sqlsearch);
		new gnTable().RemoveTableRows(nmodel);
		nmodel.setColumnIdentifiers(AdetailCol);
		ntable.setModel(nmodel);
		ntable = new gnTableModel().Tablemodel(ntable, nmodel, sqlsearch, AdetailCol, 13, "N", "N", "N");
		new gnTable().setTablewidth(ntable, 1, 300);
		new General().msgsearch(sjsp, ntable, "Inventory Details", 900, 200);
		ntable.setBackground(Color.WHITE);
	}

	public void ASearch(String sqlsearch, String[] Col, String Type) throws SQLException, ClassNotFoundException {
		new gnTable().RemoveTableRows(nmodel);
		nmodel.setColumnIdentifiers(ACol);
		ntable = new gnTableModel().Tablemodel(ntable, nmodel, sqlsearch, Col, 5, "N", "Y", Type);
		new gnTable().setTablewidth(ntable, 2, 300);
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(ntable)));
		ntable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification4);
		prt6.setToolTipText("Scrollpane Port");
		prt6.add(ntable, ACol);
		prt6.setVisible(true);
		sjsp.setViewport(prt6);
		new General().msgsearch(sjsp, ntable, "Select Record", 600, 500);
	}

	public CellEditorListener ChangeNotification4 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
		}

		public void editingStopped(ChangeEvent e) {
			int row = ntable.getSelectedRow();
			String value = (String) ntable.getValueAt(row, 0);
			try {
				displayInfo(value, row);
				new General().msgDispose();
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
		}
	};

	private void displayInfo(String value, int row) throws Throwable {
		switch (value) {
		case "Article":
			String varticle = (String) ntable.getValueAt(row, 1);
			new gnTable().RemoveTableRows(nmodel);
			new General().msgDispose();
			ntable.addNotify();
			showArticle(varticle);
			break;
		}
	}

	public CellEditorListener ChangeNotification7 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String vchoice = table.getValueAt(row, 0).toString().trim();
			String value = (String) table.getValueAt(row, 4);// nitin
			System.out.println(vchoice);
			showInventoryDetails(vchoice, value);
		}
	};
	private JTextField expdays;
	private JTextField finyear;
	private JLabel lblNewLabel_3;
	private JButton btnStockRoll;
	private JButton btnShowStockReq;
	private JLabel lblNewLabel_7;

	private void showInventoryDetails(String vchoice, String value) {
		vfinyear = finyear.getText();
		switch (vchoice) {
		case "Article":
			String sqldetails = " call  inventory_getdetailsforArtilce(" + value + ", " + vcomp + " ," + vstore + ", '"
					+ vselectedLoc + "' , '" + vfinyear + "' )";
			try {
				AdetailSearch(sqldetails, AdetailCol);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}

	}
}// last

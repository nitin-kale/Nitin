package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import RetailProduct.Daily_Sales_View.searchLsnr;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

public class Daily_Purchase_View extends getResultSet {

	JFrame PurchaseViewFrame;
	JInternalFrame internalFrame;
	private String vfinyear;
	private JTextField fromdate;
	private JTextField todate;
	String reportType;
	private JButton BtnBrand;
	String vcode;

	private JButton btnDaily;
	private JButton btnDate;
	private JButton btnManuf;
	JButton btnMonthItem;
	String vverticle = "";
	private JButton btnClass;
	private JButton btnMonth;
	private JButton btnArticle;
	private JButton BtnCancel;
	private JButton btnPur;
	private JButton btnExport;
	private JButton btnCancel;
	public String vfromdate;
	public String vtodate;
	public String vsitecode;
	public String vcompcode;
	public String vbtnchoice = "";

	private JViewport prt1 = new JViewport();
	private JViewport prt2 = new JViewport();

	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2 || column == 3 || column == 4 || column == 5) {
				// componentt.setBackground(Color.WHITE);
				// componentt.setForeground(Color.BLUE);
				// componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}
			if (Language == "H") {
				if (column == 4) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}
			return componentt;
		}
	};
	private JScrollPane jsp;

	private DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public JScrollPane sjsp;
	private JLabel lblCompanyCode;
	private JTextField compcode;
	private JLabel lblStore;
	private JTextField sitecode;
	private JTextField sitename;
	private JPanel leftPanel;
	private JTextField finyear;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_1;
	private JTextField searchname;
	private JTextField code;
	private JButton btnshowSubcat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Daily_Purchase_View window = new Daily_Purchase_View();
					window.PurchaseViewFrame.setVisible(true);
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

	public Daily_Purchase_View() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */

	private void initialize() throws Throwable {
		PurchaseViewFrame = new JFrame();
		PurchaseViewFrame.setTitle("Business Application - Stand Alone Store Edition");
		PurchaseViewFrame.setResizable(false);
		PurchaseViewFrame.setAlwaysOnTop(true);
		//PurchaseViewFrame.setBounds(1, 90, 1350, 703);
		PurchaseViewFrame.setBounds(1, 90, 1350, 605);
		
		PurchaseViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		PurchaseViewFrame.getContentPane().setLayout(null);

		/*
		internalFrame = new JInternalFrame("Purchase View ");
		internalFrame.setBounds(0, 0, 1350, 730);
		PurchaseViewFrame.getContentPane().add(internalFrame);
		PurchaseViewFrame.getContentPane().setLayout(null);
		*/
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 1334, 131);
		PurchaseViewFrame.getContentPane().add(panel);
		panel.setLayout(null);
		ActionListener dt1 = new fromdateLsnr();
		ActionListener dt2 = new todateLsnr();
		ActionListener bt23 = new Btn();

		lblCompanyCode = new JLabel("Company ");
		lblCompanyCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompanyCode.setForeground(new Color(0, 0, 153));
		lblCompanyCode.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblCompanyCode.setBounds(199, 2, 88, 16);
		panel.add(lblCompanyCode);

		compcode = new JTextField();
		compcode.setBackground(Color.WHITE);
		compcode.setForeground(Color.BLACK);
		compcode.setFont(new Font("Arial", Font.PLAIN, 15));
		compcode.setEditable(false);
		compcode.setBounds(220, 18, 116, 30);
		panel.add(compcode);
		compcode.setColumns(10);

		lblStore = new JLabel("Store");
		lblStore.setForeground(new Color(0, 0, 153));
		lblStore.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblStore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStore.setBounds(320, 2, 56, 16);
		panel.add(lblStore);

		sitecode = new JTextField();
		sitecode.setBackground(Color.WHITE);
		sitecode.setForeground(Color.BLACK);
		sitecode.setFont(new Font("Arial", Font.PLAIN, 15));
		sitecode.setEditable(false);
		sitecode.setBounds(342, 18, 116, 30);
		panel.add(sitecode);
		sitecode.setColumns(10);

		sitename = new JTextField();
		sitename.setBackground(Color.WHITE);
		sitename.setForeground(Color.BLACK);
		sitename.setFont(new Font("Arial", Font.PLAIN, 15));
		sitename.setEditable(false);
		sitename.setBounds(458, 18, 282, 30);
		panel.add(sitename);
		sitename.setColumns(10);

		JLabel lblNewLabel = new JLabel("Financial Year");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(1072, 2, 116, 16);
		panel.add(lblNewLabel);

		finyear = new JTextField();
		finyear.setFont(new Font("Arial", Font.BOLD, 16));
		finyear.setBounds(1072, 18, 116, 30);
		panel.add(finyear);
		finyear.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Daily_Purchase_View.class.getResource("/RetailProduct/graphics1.png")));
		btnNewButton.setBounds(1212, 2, 122, 129);
		panel.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("Purchase Data");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(0, 0, 153));
		lblNewLabel_2.setBounds(31, 35, 146, 60);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setIcon(new ImageIcon(Daily_Purchase_View.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_3.setBounds(22, 2, 133, 129);
		panel.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 255, 204)));
		panel_1.setBounds(218, 47, 997, 84);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)), "Enter Date ",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(0, 0, 522, 84);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblFromDate = new JLabel("From Date");
		lblFromDate.setBounds(12, 25, 116, 16);
		panel_2.add(lblFromDate);
		lblFromDate.setForeground(new Color(0, 0, 102));
		lblFromDate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblFromDate.setHorizontalAlignment(SwingConstants.LEFT);

		fromdate = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		fromdate.setBounds(12, 46, 116, 25);
		panel_2.add(fromdate);

		fromdate.setBackground(Color.WHITE);
		fromdate.setForeground(new Color(0, 51, 102));
		fromdate.setFont(new Font("Arial", Font.PLAIN, 15));
		fromdate.addActionListener(dt1);
		fromdate.setColumns(10);

		JLabel lblToDate = new JLabel("To Date");
		lblToDate.setBounds(140, 25, 116, 16);
		panel_2.add(lblToDate);
		lblToDate.setForeground(new Color(0, 0, 102));
		lblToDate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));

		todate = new JTextField();
		todate.setBounds(140, 46, 116, 25);
		panel_2.add(todate);
		todate.setBackground(Color.WHITE);
		todate.setFont(new Font("Arial", Font.PLAIN, 15));
		todate.setForeground(new Color(0, 51, 102));
		todate.addActionListener(dt2);
		todate.setColumns(10);
		ActionListener bt24 = new Btn();

		btnExport = new JButton("Export To Excel");
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExport.setMnemonic('E');
		btnExport.setBackground(Color.CYAN);
		btnExport.setBounds(1088, 132, 137, 28);
		ActionListener bt28 = new Btn();
		btnExport.addActionListener(bt28);
		PurchaseViewFrame.getContentPane().add(btnExport);

		btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(Daily_Purchase_View.class.getResource("/RetailProduct/btnApClose.png")));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseViewFrame.dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setMnemonic('C');
		btnCancel.setBackground(Color.CYAN);
		btnCancel.setBounds(1225, 132, 109, 28);
		PurchaseViewFrame.getContentPane().add(btnCancel);

		jsp = new JScrollPane();
		jsp.setViewportBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), new Color(0, 255, 0), null,
						new Color(255, 0, 255)), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		jsp.setBounds(236, 161, 1320, 338);
		// PurchaseViewFrame.getContentPane().add(jsp);

		leftPanel = new JPanel();
		leftPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Press Button To View Data",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		leftPanel.setBackground(new Color(102, 0, 102));
		leftPanel.setBounds(10, 161, 1098, 338);
		// PurchaseViewFrame.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);

		btnDaily = new JButton("Category Purchase");
		btnDaily.setForeground(Color.BLACK);
		btnDaily.setBounds(12, 183, 185, 30);
		leftPanel.add(btnDaily);
		btnDaily.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDaily.setMnemonic('T');
		btnDaily.setBackground(new Color(204, 255, 255));

		BtnBrand = new JButton("SubCat Purchase");
		BtnBrand.setForeground(Color.BLACK);
		BtnBrand.setBounds(12, 214, 185, 30);
		leftPanel.add(BtnBrand);
		BtnBrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BtnBrand.setMnemonic('S');
		BtnBrand.setBackground(new Color(204, 255, 255));

		btnPur = new JButton("Brand Purchase");
		btnPur.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPur.setForeground(Color.BLACK);
		btnPur.setBounds(12, 88, 185, 30);
		leftPanel.add(btnPur);
		btnPur.setBackground(new Color(204, 255, 255));
		btnPur.setMnemonic('B');

		btnManuf = new JButton("Group Purchase");
		btnManuf.setForeground(Color.BLACK);
		btnManuf.setBounds(12, 120, 185, 30);
		leftPanel.add(btnManuf);
		btnManuf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnManuf.setMnemonic('G');
		btnManuf.setBackground(new Color(204, 255, 255));

		btnClass = new JButton("SubGroup Purchase");
		btnClass.setForeground(Color.BLACK);
		btnClass.setBounds(12, 151, 185, 30);
		leftPanel.add(btnClass);
		btnClass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnClass.setMnemonic('O');
		btnClass.setBackground(new Color(204, 255, 255));

		btnArticle = new JButton("Article /Item Purchase");
		btnArticle.setForeground(Color.BLACK);
		btnArticle.setBounds(12, 247, 185, 30);
		leftPanel.add(btnArticle);
		btnArticle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnArticle.setMnemonic('A');
		btnArticle.setBackground(new Color(204, 255, 255));

		//internalFrame.setVisible(true);
		JSplitPane mySplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, jsp);

		btnDate = new JButton("Date Wise Purchase");
		btnDate.setBackground(new Color(204, 255, 255));
		btnDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDate.setForeground(Color.BLACK);
		btnDate.setMnemonic('D');
		btnDate.setBounds(12, 57, 185, 30);
		leftPanel.add(btnDate);

		btnMonth = new JButton("Month Wise Purchase");
		btnMonth.setBackground(new Color(204, 255, 255));
		// btnMonth.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMonth.setForeground(Color.BLACK);
		btnMonth.setMnemonic('M');
		btnMonth.setBounds(12, 24, 185, 30);
		leftPanel.add(btnMonth);

		btnMonthItem = new JButton("Month Wise-Item Purchase");
		btnMonthItem.setBackground(new Color(204, 255, 255));
		// btnMonthItem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMonthItem.setForeground(Color.BLACK);
		btnMonthItem.setMnemonic('I');
		btnMonthItem.setBounds(12, 281, 185, 30);
		leftPanel.add(btnMonthItem);

		btnNewButton_2 = new JButton(" ");
		btnNewButton_2
				.setSelectedIcon(new ImageIcon(Daily_Purchase_View.class.getResource("/RetailProduct/frame11.png")));
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setIcon(null);
		btnNewButton_2.setBounds(4, 14, 197, 518);
		leftPanel.add(btnNewButton_2);
		mySplit.setBounds(1, 162, 1333, 466);
		mySplit.setDividerLocation(200);
		mySplit.setContinuousLayout(true);
		PurchaseViewFrame.getContentPane().add(mySplit);

		lblNewLabel_1 = new JLabel("Search Here");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1.setBounds(111, 140, 79, 16);
		PurchaseViewFrame.getContentPane().add(lblNewLabel_1);

		searchname = new JTextField();
		searchname.setFont(new Font("Calibri", Font.BOLD, 14));
		searchname.setBounds(209, 132, 292, 28);
		PurchaseViewFrame.getContentPane().add(searchname);
		searchname.setColumns(10);

		code = new JTextField();
		code.setBounds(503, 132, 64, 28);
		PurchaseViewFrame.getContentPane().add(code);
		code.setColumns(10);

		btnshowSubcat = new JButton("Show SubCategory");
		btnshowSubcat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnshowSubcat.setBounds(579, 135, 172, 25);
		PurchaseViewFrame.getContentPane().add(btnshowSubcat);
		btnArticle.addActionListener(bt23);
		btnMonthItem.addActionListener(bt23);
		btnClass.addActionListener(bt23);
		btnManuf.addActionListener(bt23);
		btnPur.addActionListener(bt23);
		BtnBrand.addActionListener(bt23);
		btnshowSubcat.addActionListener(bt23);
		btnDaily.addActionListener(bt23);
		btnDate.addActionListener(bt23);
		btnMonth.addActionListener(bt23);
		ActionListener srch = new searchLsnr();
		searchname.addActionListener(srch);
		decorate();
		new gnFontSetting().setUIFont(new javax.swing.plaf.FontUIResource("Arial", Font.ITALIC, 12));
		new gnFontSetting().setUIFont1(new FontUIResource(new Font("Arial", 0, 20)));
	}

	private void decorate() throws Throwable {
		PurchaseViewFrame.setUndecorated(true);
		new gnApp().setFrameTitel(PurchaseViewFrame);
		vverticle = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		new gnField().closeform(fromdate, PurchaseViewFrame);
		new gnDecorate().DispField_Eatch(fromdate, 20);
		new gnDecorate().DispField_Eatch(todate, 20);
		new gnDecorate().decorateBtn(btnExport, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnCancel, Color.BLUE, Color.WHITE);
		new gnDecorate().decorateBtn(btnDaily, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnManuf, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(BtnBrand, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnClass, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnArticle, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnPur, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnMonthItem, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnMonth, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnDate, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnMonthItem, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnPur, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnManuf, Color.darkGray, Color.WHITE);

		/*
		 * new gnDecorate().decorateBtn(btnManuf, new Color(120, 151, 112),
		 * Color.WHITE) ; new gnDecorate().decorateBtn(BtnBrand, new Color(120,
		 * 151, 112), Color.WHITE) ; new gnDecorate().decorateBtn(btnClass, new
		 * Color(120, 151, 112), Color.WHITE) ; new
		 * gnDecorate().decorateBtn(btnArticle, new Color(120, 151, 112),
		 * Color.WHITE) ; new gnDecorate().decorateBtn(btnPur, new Color(120,
		 * 151, 112), Color.WHITE) ; new gnDecorate().decorateBtn(btnMonthItem,
		 * new Color(120, 151, 112), Color.WHITE) ; new
		 * gnDecorate().decorateBtn(btnMonth, new Color(120, 151, 112),
		 * Color.WHITE) ; new gnDecorate().decorateBtn(btnDate, new Color(120,
		 * 151, 112), Color.WHITE) ; new gnDecorate().decorateBtn(btnMonthItem,
		 * new Color(120, 151, 112), Color.WHITE) ; new
		 * gnDecorate().decorateBtn(btnPur, new Color(120, 151, 112),
		 * Color.WHITE) ; new gnDecorate().decorateBtn(btnManuf, new Color(120,
		 * 151, 112), Color.WHITE) ;
		 * 
		 * /* new gnStyleButtonSqr().getStyleButton(btnDaily,new Color(178, 11,
		 * 112) , Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnMonth,
		 * new Color(120, 151, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(BtnBrand, new Color(131, 211, 112),
		 * Color.BLACK) ; new gnStyleButtonSqr().getStyleButton(btnClass, new
		 * Color(56, 189, 112) , Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnArticle,new Color(178, 11, 112)
		 * , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnMonthItem,new Color(178, 11,
		 * 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnManuf,new Color(178, 11, 112) ,
		 * Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnPur,new
		 * Color(178, 11, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnDate,new Color(178, 11, 112) ,
		 * Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnExport,new
		 * Color(178, 11, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnCancel,new Color(178, 11, 112) ,
		 * Color.WHITE) ;
		 */

		sitecode.setText(new gnConfig().getStoreID());
		compcode.setText(new gnConfig().getCompanyCode());
		sitename.setText(new gnConfig().getStorename(sitecode.getText().toString()));
		finyear.setText(new gnFinYear().getReportingFinYear());
		vfinyear = finyear.getText();
		fromdate.setText(new gnFinYear().getFirstDateofFinYear());
		todate.setText(new gnFinYear().getLastDateofFinYear());
		btnMonth.doClick();

	}

	class searchLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				getPerticularcode();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void getPerticularcode() throws Throwable {
		String vcode = "";
		String vname = "";
		String vtype = "";
		String SQL = "";
		vname = "%" + searchname.getText() + "%";
		vmastersearchString = "%" + searchname.getText() + "%";
		switch (reportType) {
		case "Brand":
			vtype = reportType;
			btnshowSubcat.setVisible(false);
			new gnAdmin().showMasterTable(vtype, code, searchname);
			break;
		case "Group":
			vtype = reportType;
			btnshowSubcat.setVisible(false);
			new gnHierarchy().getHierarchyInfo(vtype, vname);
			code.setText(new gnHierarchy().code);
			searchname.setText(new gnHierarchy().name);
			break;
		case "SubGroup":
			vtype = reportType;
			btnshowSubcat.setVisible(false);
			new gnHierarchy().getHierarchyInfo(vtype, vname);
			code.setText(new gnHierarchy().code);
			searchname.setText(new gnHierarchy().name);
			break;
		case "Category":
			vtype = reportType;
			btnshowSubcat.setVisible(true);
			new gnHierarchy().getHierarchyInfo(vtype, vname);
			code.setText(new gnHierarchy().code);
			searchname.setText(new gnHierarchy().name);
			break;
		case "SubCategory":
			vtype = reportType;
			btnshowSubcat.setVisible(false);
			new gnHierarchy().getHierarchyInfo(vtype, vname);
			code.setText(new gnHierarchy().code);
			searchname.setText(new gnHierarchy().name);
			break;
		}

		showForParticular();

	}

	private void showForParticular() throws Throwable {
		String SQL = "";
		String vtype = "";
		// String Col[] = { "Type" , "Company", "Store Code" , "Code" , "Name" ,
		// "Qty", "Purchase Value" } ;
		int ColNo = 0;
		vtype = reportType;
		String vcode = code.getText();
		SQL = "Call   view_PurchaseData1( '" + vtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
				+ vtodate + "'  , " + vverticle + " , '" + vcode + "')";
		// new General().msg(SQL);
		ColNo = 6;
		// vtype = "Brand Wise Sales" ;
		String colpur[] = { "Type", "Code", "Name", "Qty", "Amount", "PR.Qty", "PR.Amount", "Net Qty ", "Net Amount" };
		showView(SQL, colpur, ColNo, vtype);

	}

	class fromdateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				fromdate.setText(new gnDate().getmefullDate(fromdate.getText()));

			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
			}
		}
	}

	class todateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				todate.setText(new gnDate().getmefullDate(todate.getText()));
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {

			}
		}
	}

	public void getDates() throws ClassNotFoundException, SQLException {

		vfromdate = new gnConfig().date_ConverttoDBforamt(fromdate.getText().trim());
		vtodate = new gnConfig().date_ConverttoDBforamt(todate.getText().trim());
		vcompcode = (compcode.getText());
		vsitecode = (sitecode.getText());

		if (vfromdate.length() != 10) {
			new General().msg("Select Date ..");
			fromdate.grabFocus();
		}

		if (vtodate.length() != 10) {
			new General().msg("Select Date ..");
			todate.grabFocus();
		}

	}

	public void showView(String SQL, String Col[], int colno, String vtype) throws Throwable {
		String vstatus = new gnFinYear().checkDateRanegforFinyear(fromdate.getText(), todate.getText());

		if (vstatus == "Sucess") {
			new gnTable().RemoveTableRows(model);
			table = null;
			table = new JTable() {
				public void addNotify() {
					super.addNotify();
					requestFocus();
				}
			};
			new gnTable().RemoveTableRows(model);
			model.setColumnIdentifiers(Col);
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, colno, "N", "Y", vtype);
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			new gnTable().setTableBasics(table);
			JViewport prt = new JViewport();
			prt.setBackground(Color.CYAN);
			prt.add(table, Col);
			prt.setVisible(true);
			jsp.setViewport(prt);
			table.requestFocus();
			new gnFontSetting().setMyFontBold(table, "F1", 14);
			if (table.getRowCount() > 0) {
				Selectrow();
			}
		}
	}

	public void Selectrow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {
					display(row, value);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
					// new General().msgDispose();
			}
		});
	}

	private void display(int row, String value) throws Throwable {
		String vmonthno = " ";
		String vvtype = "";
		String SQL2 = " ";
		int ColNo = 0;
		String vtype = "";
		String colpur[] = { "Type", "Article", "Name", "Qty", "Amount", "PR.Qty", "PR.Amount", "Net Qty ",
				"Net Amount" };

		switch (value) {
		case "Group":
			vcode = table.getValueAt(row, 1).toString();
			vvtype = "GroupItems";
			SQL2 = "Call   view_PurchaseData1('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate
					+ "', '" + vtodate + "' ,  '" + vverticle + "' , '" + vcode + "')";
			ColNo = 8;
			vtype = "GroupItems";
			vfromdate = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
			vtodate = new gnConfig().date_ConverttoDBforamt(todate.getText());

			try {
				showView(SQL2, colpur, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				new General().msg(e.getLocalizedMessage());
			}
			break;

		case "SubGroup":
			vcode = table.getValueAt(row, 1).toString();
			vvtype = "SubGroupItems";
			SQL2 = "Call   view_PurchaseData1('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate
					+ "', '" + vtodate + "' ,  '" + vverticle + "' , '" + vcode + "')";
			// new General().msg(SQL2);
			ColNo = 8;
			vtype = "SubGroupItems";
			try {
				showView(SQL2, colpur, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				new General().msg(e.getLocalizedMessage());
			}
			break;

		case "Category":
			vcode = table.getValueAt(row, 1).toString();
			vvtype = "CategoryItems";
			SQL2 = "Call   view_PurchaseData1('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate
					+ "', '" + vtodate + "' ,  '" + vverticle + "' , '" + vcode + "')";
			// new General().msg(SQL2);
			ColNo = 8;
			vtype = "CategoryItems";
			try {
				showView(SQL2, colpur, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				new General().msg(e.getLocalizedMessage());
			}
			break;

		case "SubCategory":
			vcode = table.getValueAt(row, 1).toString();
			vvtype = "SubCategoryItems";
			SQL2 = "Call   view_PurchaseData1('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate
					+ "', '" + vtodate + "' ,  '" + vverticle + "' , '" + vcode + "')";
			// new General().msg(SQL2);
			ColNo = 8;
			vtype = "SubCatItems";
			try {
				showView(SQL2, colpur, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				new General().msg(e.getLocalizedMessage());
			}
			break;

		case "Brand":
			vcode = table.getValueAt(row, 1).toString();
			vvtype = "BrandItems";
			SQL2 = "Call   view_PurchaseData1('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate
					+ "', '" + vtodate + "' ,  '" + vverticle + "' , '" + vcode + "')";
			// new General().msg(SQL2);
			ColNo = 8;
			vtype = "BrandItems";
			try {
				showView(SQL2, colpur, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				new General().msg(e.getLocalizedMessage());
			}
			break;

		case "Month":
			vmonthno = table.getValueAt(row, 1).toString();
			vvtype = "MonthDates";
			SQL2 = "Call   view_PurchaseData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vmonthno
					+ "' ,'" + vfinyear + "' , " + vverticle + " )";
			// new General().msg(SQL2);
			String Col1[] = { "Type", "Date", "Amount" };
			ColNo = 2;
			vtype = "Date";
			try {
				showView(SQL2, Col1, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				new General().msg(e.getLocalizedMessage());
			}
			break;

		case "Date":
			vmonthno = new gnConfig().date_ConverttoDBforamt(table.getValueAt(row, 1).toString());

			vvtype = "SupplierPurchase";
			SQL2 = "Call   view_PurchaseData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate
					+ "' ,'" + vfinyear + "' , " + vverticle + ")";
			// new General().msg(SQL2);
			String Col2[] = { "Type", "Grnno", "Date", "Supplier Code", "Supplier Name", "GST.No", "Amount" };
			ColNo = 6;
			vtype = "SupplierPurchase";
			try {
				showView(SQL2, Col2, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				new General().msg(e.getMessage());
			}
			break;

		case "SupplierPurchase":
			String vdocno = table.getValueAt(row, 1).toString();
			String vdocdate = (table.getValueAt(row, 2).toString());
			String vsuplier = (table.getValueAt(row, 3).toString());
			new gnEdit().ShowGRN(vsuplier, vdocno, vdocdate);
			break;

		}

	}

	class Btn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String SQL = "";
			String checkFinyearDates = "";
			try {
				getDates();
			} catch (ClassNotFoundException | SQLException e2) {
				new General().msg(e2.getMessage());
			} catch (Throwable e1) {
				new General().msg(e1.getMessage());
			}

			String vvendor = "0";

			if (value == "Show SubCategory") {
				reportType = "SubCatForCategory";
				try {
					showForParticular();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			if (value == "Export To Excel") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

			if (value == "Month Wise Purchase") {
				try {
					vbtnchoice = "M";
					String vvtype = "Month";
					SQL = "Call   view_PurchaseData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "' , " + vverticle + ")";
					String Col[] = { "Type", "Month.No", "Month", "Qty", "Gross", "Disc", "AfterDis", "Tax",
							"Otherchrg", "Purchasevalue", "PR.Qty", "PR.Amt", "Net Pur.Qty", "Net Pur value" };
					int ColNo = 13;
					String vtype = "Month";
					showView(SQL, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getMessage());
				} catch (SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Date Wise Purchase") {
				try {
					String vvtype = "Date";
					SQL = "Call   view_PurchaseData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "', " + vverticle + " )";
					String Col[] = { "Type", "Date", "Qty", "Gross", "Disc", "Afterdisc", "Tax", "Oth.chrg",
							"Purchase.Amt.", "PR.Qty", "PR.Amt", "Net Pur Qty", "Net Pur.Amt" };
					int ColNo = 12;
					String vtype = "Date";
					showView(SQL, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getMessage());
				} catch (SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Brand Purchase") {
				try {
					String vvtype = "Brand";
					reportType = "Brand";
					SQL = "Call   view_PurchaseData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					String Col[] = { "Type", "Brand Code", "Brand Name", "Pur.Qty", "Purchase Amount", "PR.Qty",
							"PR.Amt", "NetQty", "Net Purchase" };
					int ColNo = 8;
					String vtype = "Brand";
					showView(SQL, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getMessage());
				} catch (SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Category Purchase") {
				try {
					String vvtype = "Category";
					reportType = "Category";
					SQL = "Call   view_PurchaseData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "' ,  " + vverticle + ")";
					String Col[] = { "Type", "Category Code", "Name", "Pur.Qty", "Purchase Amount", "PR.Qty", "PR.Amt",
							"NetQty", "Net Pur.Amt" };
					int ColNo = 8;
					String vtype = "Category";
					showView(SQL, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getMessage());
				} catch (SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "SubCat Purchase") {
				try {
					String vvtype = "SubCategory";
					reportType = "SubCategory";
					SQL = "Call   view_PurchaseData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "' , " + vverticle + " )";
					String Col[] = { "Type", "SubCategory Code", "Name", "Pur.Qty", "Purchase Amount", "PR.Qty",
							"PR.Amt", "NetQty", "Net Pur.Amt" };
					int ColNo = 8;
					String vtype = "Subcategory";
					// String vstatus = checkFinyearDates = new
					// gnFinYear().checkDateRanegforFinyear(vfromdate, vtodate)
					// ;
					showView(SQL, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getMessage());
				} catch (SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Group Purchase") {
				try {
					String vvtype = "Group";
					reportType = "Group";
					SQL = "Call   view_PurchaseData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "', " + vverticle + " )";
					String Col[] = { "Type", "Group Code", "Name", "Pur.Qty", "Purchase Amount", "PR.Qty", "PR.Amt",
							"NetQty", "Net Pur.Amt" };
					int ColNo = 8;
					String vtype = "Group";
					showView(SQL, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getMessage());
				} catch (SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "SubGroup Purchase") {
				try {
					String vvtype = "SubGroup";
					reportType = "SubGroup";
					SQL = "Call   view_PurchaseData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "', " + vverticle + " )";
					String Col[] = { "Type", "SubGroup Code", "Name", "Pur.Qty", "Purchase Amount", "PR.Qty", "PR.Amt",
							"NetQty", "Net Pur.Amt" };
					int ColNo = 8;
					String vtype = "SubGroup";
					showView(SQL, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getMessage());
				} catch (SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Month Wise-Item Purchase") {
				String vvtype = "MonthwiseItem";
				SQL = "Call   view_PurchaseData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate
						+ "' ,'" + vtodate + "' , " + vverticle + ")";
				String Col[] = { "Type", "Month", "Article Code", "Name", "Pur.Qty", "Purchase Amount", "PR.Qty",
						"PR.Value", "Net Purchase Qty", "Net Pur.Amt" };
				int ColNo = 9;
				String vtype = "MonthWise Item Purchase";
				try {
					showView(SQL, Col, ColNo, vtype);
					SQL = null;
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getLocalizedMessage());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Article /Item Purchase") {
				try {
					String vvtype = "Article";
					SQL = "Call   view_PurchaseData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "' , " + vverticle + ")";
					String Col[] = { "Type", "Article Code", "Name", "Qty", "Purchase Amount", "PR.Qty", "PR Amount",
							"Net Qty", "Net Purchase" };
					int ColNo = 8;
					String vtype = "Product Wise Purchase";
					showView(SQL, Col, ColNo, vtype);
					SQL = null;
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getMessage());
				} catch (SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}//
	}
}// last

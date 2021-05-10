package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
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
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import RetailProduct.Article_AttriHie_Assignment.assignLsnr;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class Daily_Sales_View extends getResultSet {

	JFrame SalesViewFrame;
	JInternalFrame internalFrame;
	JLabel mylabel;
	JButton btnshowSubcat;
	JLabel lblimage ;
	String reportType;
	String graphType;
	private JTextField fromdate;
	JButton btnCategory;
	JButton btnGroup;
	JButton btnAudit;
	JButton btnTopArticle;
	JButton btnH;
	JButton btnmySubGroup;
	JButton bthH1;
	JButton btnX;
	String vverticle;
	JButton btnSubGroup;
	JButton btnSubCat;
	JButton btnShortDecl;
	// private PieChart chart =null;
	// private LineChart lchart = null ;
	private JTextField todate;
	JPanel leftPanel;
	JSplitPane mySplit3;
	// private ObservableList<PieChart.Data> pieChartData =
	// FXCollections.observableArrayList();

	private JButton BtnBrand;
	// JFXPanel chartPanel;
	// JFXPanel chartPanel1;
	// XYChart.Series series = new XYChart.Series();
	// XYChart xychart1;
	JPanel chartPanel;
	JPanel chartPanel1;

	private JButton btnDaily;
	private JButton btnMonth;
	private JButton btnClass;
	private JButton btnArticle;
	JButton btnArticleDetail;
	private JButton BtnCancel;
	private JButton btnExport;
	private JButton btnCancel;
	public String vfromdate;
	public String vtodate;
	public String vsitecode;
	public String vcompcode;

	private JViewport prt1 = new JViewport();
	private JViewport prt2 = new JViewport();

	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2 || column == 3 || column == 4 || column == 5) {
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
	JPanel chartPanel11;
	private DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public JScrollPane sjsp;
	private JLabel lblCompanyCode;
	private JTextField compcode;
	private JLabel lblStore;
	private JTextField sitecode;
	private String vfinyear;
	private JTextField sitename;
	// JFXPanel bigchart = new JFXPanel() ;
	private JLabel lblNewLabel;
	private JTextField finyear;
	private JButton btnNewButton;
	private JButton btnGraph;
	private JButton btnpiaChart;
	private JButton btnbarGraph;
	private JButton btnLineChart;
	private JTextField searchname;
	private JTextField code;
	private JButton btnPaymentMode;
	private JButton btncnopen;
	private JButton btncnclose;
	private JButton btnuseSales;
	private JButton btnCashierShortExcess;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JPanel panel_1;
	private JTextField mytotalsale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Daily_Sales_View window = new Daily_Sales_View();
					window.SalesViewFrame.setVisible(true);
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
	public Daily_Sales_View() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		SalesViewFrame = new JFrame();
		SalesViewFrame.setTitle("Business Application - Stand Alone Store Edition");
		SalesViewFrame.setResizable(false);
		SalesViewFrame.setAlwaysOnTop(true);
		SalesViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SalesViewFrame.setBounds(1, 90, 1350, 656);
		//SalesViewFrame.setBounds(1, 90, 1350, 600);
		
		SalesViewFrame.getContentPane().setLayout(null);

		/*
		internalFrame = new JInternalFrame("Sales View ");
		SalesViewFrame.getContentPane().setBackground(Color.WHITE);
		internalFrame.setForeground(Color.GREEN);
		internalFrame.setBounds(0, 0, 1350, 750);
		SalesViewFrame.getContentPane().add(internalFrame);
		SalesViewFrame.getContentPane().setLayout(null);
*/
		JPanel panel = new JPanel();
		panel.setBounds(198, 0, 1038, 43);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 255, 204)));
		SalesViewFrame.getContentPane().add(panel);
		panel.setLayout(null);
		ActionListener dt1 = new fromdateLsnr();
		ActionListener dt2 = new todateLsnr();
		ActionListener bt22 = new Btn();

		lblCompanyCode = new JLabel("Company ");
		lblCompanyCode.setFont(new Font("Cambria", Font.BOLD, 14));
		lblCompanyCode.setForeground(new Color(0, 0, 102));
		lblCompanyCode.setBounds(12, 0, 70, 16);
		panel.add(lblCompanyCode);

		compcode = new JTextField();
		compcode.setForeground(Color.BLACK);
		compcode.setBackground(Color.WHITE);
		compcode.setFont(new Font("Calibri", Font.BOLD, 14));
		compcode.setEditable(false);
		compcode.setBounds(12, 18, 116, 25);
		panel.add(compcode);
		compcode.setColumns(10);

		lblStore = new JLabel("Store");
		lblStore.setFont(new Font("Cambria", Font.BOLD, 14));
		lblStore.setForeground(new Color(0, 0, 102));
		lblStore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStore.setBounds(221, 0, 56, 16);
		panel.add(lblStore);

		sitecode = new JTextField();
		sitecode.setForeground(Color.BLACK);
		sitecode.setBackground(Color.WHITE);
		sitecode.setFont(new Font("Calibri", Font.BOLD, 14));
		sitecode.setEditable(false);
		sitecode.setBounds(243, 18, 116, 25);
		panel.add(sitecode);
		sitecode.setColumns(10);

		sitename = new JTextField();
		sitename.setForeground(Color.BLACK);
		sitename.setBackground(Color.WHITE);
		sitename.setFont(new Font("Calibri", Font.BOLD, 14));
		sitename.setEditable(false);
		sitename.setBounds(362, 18, 282, 25);
		panel.add(sitename);
		sitename.setColumns(10);

		lblNewLabel = new JLabel("Financial Year");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setBounds(823, 0, 91, 16);
		panel.add(lblNewLabel);

		finyear = new JTextField();
		finyear.setFont(new Font("Arial", Font.PLAIN, 17));
		finyear.setBounds(823, 18, 116, 25);
		panel.add(finyear);
		finyear.setColumns(10);

		btnExport = new JButton("Export To Excel");
		btnExport.setBounds(1080, 104, 143, 35);
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExport.setMnemonic('E');
		btnExport.setBackground(Color.CYAN);
		btnExport.addActionListener(bt22);
		SalesViewFrame.getContentPane().add(btnExport);

		// chartPanel = new JFXPanel();
		chartPanel = new JPanel();
		chartPanel.setBounds(1, 415, 1300, 226);
		chartPanel.setVisible(false);
		chartPanel.setBorder(new MatteBorder(1, 4, 1, 4, (Color) new Color(0, 0, 153)));
		chartPanel.setBackground(new Color(255, 255, 255));
		chartPanel.setLayout(null);

		// chartPanel1 = new JFXPanel();
		chartPanel1 = new JPanel();
		chartPanel1.setBounds(415, 415, 600, 226);
		chartPanel1.setVisible(false);
		chartPanel1.setBorder(new MatteBorder(1, 4, 1, 4, (Color) new Color(0, 0, 153)));
		chartPanel1.setBackground(new Color(255, 255, 255));

		jsp = new JScrollPane();
		jsp.setViewportBorder(new CompoundBorder(
				new BevelBorder(BevelBorder.RAISED, new Color(255, 255, 0), new Color(0, 0, 0), new Color(255, 0, 255),
						new Color(255, 255, 255)),
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP,
						null, new Color(0, 0, 0))));
		jsp.setBounds(1, 103, 1000, 299);

		leftPanel = new JPanel();
		leftPanel.setBackground(new Color(153, 0, 153));
		leftPanel.setBorder(new TitledBorder(null, "Press Button To  View Data", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(255, 255, 204)));
		leftPanel.setBounds(1, 103, 1000, 299);
		// SalesViewFrame.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);

		btnMonth = new JButton("Month Wise Sales");
		btnMonth.setForeground(new Color(0, 0, 51));
		btnMonth.setToolTipText("Month wise Sales");
		btnMonth.setBounds(6, 26, 185, 25);
		leftPanel.add(btnMonth);
		btnMonth.setFont(new Font("Arial", Font.BOLD, 13));
		btnMonth.setMnemonic('M');
		btnMonth.setBackground(Color.WHITE);

		btnArticle = new JButton("Article /Product  Sales");
		btnArticle.setForeground(new Color(0, 0, 51));
		btnArticle.setBounds(6, 269, 185, 25);
		leftPanel.add(btnArticle);
		btnArticle.setFont(new Font("Arial", Font.BOLD, 13));
		btnArticle.setMnemonic('A');
		btnArticle.setBackground(Color.WHITE);

		btnDaily = new JButton("Daily Sales");
		btnDaily.setForeground(new Color(0, 0, 51));
		btnDaily.setBounds(6, 52, 185, 25);
		leftPanel.add(btnDaily);
		btnDaily.setFont(new Font("Arial", Font.BOLD, 13));
		btnDaily.setMnemonic('D');
		btnDaily.setBackground(Color.WHITE);

		BtnBrand = new JButton("Brand Wise Sales");
		BtnBrand.setForeground(new Color(0, 0, 51));
		BtnBrand.setBounds(6, 110, 185, 25);
		leftPanel.add(BtnBrand);
		BtnBrand.setFont(new Font("Arial", Font.BOLD, 13));
		BtnBrand.setMnemonic('B');
		BtnBrand.setBackground(Color.WHITE);

		JSplitPane mySplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, jsp);
		mySplit.setBounds(0, 138, 1334, 485);

		btnCategory = new JButton("Category wise Sales");
		btnCategory.setBackground(Color.WHITE);
		btnCategory.setFont(new Font("Arial", Font.BOLD, 13));
		btnCategory.setForeground(new Color(0, 0, 51));
		btnCategory.setMnemonic('O');
		btnCategory.setBounds(6, 187, 185, 25);
		leftPanel.add(btnCategory);

		btnSubCat = new JButton("SubCat Wise Sales");
		btnSubCat.setBackground(Color.WHITE);
		btnSubCat.setFont(new Font("Arial", Font.BOLD, 13));
		btnSubCat.setForeground(new Color(0, 0, 51));
		btnSubCat.setMnemonic('S');
		btnSubCat.setBounds(6, 213, 185, 25);
		leftPanel.add(btnSubCat);

		btnGroup = new JButton("Group Wise Sales");
		btnGroup.setBackground(Color.WHITE);
		btnGroup.setFont(new Font("Arial", Font.BOLD, 13));
		btnGroup.setForeground(new Color(0, 0, 51));
		btnGroup.setMnemonic('G');
		btnGroup.setBounds(6, 137, 185, 25);
		leftPanel.add(btnGroup);

		btnSubGroup = new JButton("SubGroup Wise Sales");
		btnSubGroup.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		btnSubGroup.setForeground(new Color(0, 0, 102));
		btnSubGroup.setMnemonic('U');
		btnSubGroup.setBounds(6, 236, 185, -111);
		leftPanel.add(btnSubGroup);

		btnX = new JButton("Schedule-X");
		btnX.setBounds(6, 534, 185, 25);
		leftPanel.add(btnX);

		btnmySubGroup = new JButton("Sub Group");
		btnmySubGroup.setForeground(new Color(0, 0, 51));
		btnmySubGroup.setBackground(Color.WHITE);
		btnmySubGroup.setFont(new Font("Arial", Font.BOLD, 13));
		btnmySubGroup.setBounds(6, 164, 185, 25);
		leftPanel.add(btnmySubGroup);

		btnAudit = new JButton("Audit Trail");
		btnAudit.setForeground(new Color(0, 0, 51));
		btnAudit.setBackground(Color.WHITE);
		btnAudit.setFont(new Font("Arial", Font.BOLD, 13));
		btnAudit.setBounds(6, 295, 185, 25);
		leftPanel.add(btnAudit);

		btnArticleDetail = new JButton("Article-Detail View");
		btnArticleDetail.setBackground(Color.WHITE);
		btnArticleDetail.setForeground(new Color(0, 0, 51));
		btnArticleDetail.setFont(new Font("Arial", Font.BOLD, 13));
		btnArticleDetail.setBounds(6, 78, 185, 31);
		leftPanel.add(btnArticleDetail);

		btnPaymentMode = new JButton("Payment Summary");
		btnPaymentMode.setForeground(new Color(0, 0, 51));
		btnPaymentMode.setBackground(Color.WHITE);
		btnPaymentMode.setFont(new Font("Arial", Font.BOLD, 13));
		btnPaymentMode.setBounds(6, 321, 185, 25);
		leftPanel.add(btnPaymentMode);

		btncnopen = new JButton("Open Credit Notes");
		btncnopen.setForeground(new Color(0, 0, 51));
		btncnopen.setBackground(Color.WHITE);
		btncnopen.setFont(new Font("Arial", Font.BOLD, 13));
		btncnopen.setBounds(6, 348, 185, 25);
		leftPanel.add(btncnopen);

		btncnclose = new JButton("Closed Credit Notes");
		btncnclose.setForeground(new Color(0, 0, 51));
		btncnclose.setBackground(Color.WHITE);
		btncnclose.setFont(new Font("Arial", Font.BOLD, 13));
		btncnclose.setBounds(6, 375, 185, 25);
		leftPanel.add(btncnclose);

		btnuseSales = new JButton("User Wise Sales");
		btnuseSales.setForeground(new Color(0, 0, 51));
		btnuseSales.setBackground(Color.WHITE);
		btnuseSales.setFont(new Font("Arial", Font.BOLD, 13));
		btnuseSales.setBounds(6, 400, 185, 25);
		leftPanel.add(btnuseSales);

		btnCashierShortExcess = new JButton("Cashier Wise Declaration");
		btnCashierShortExcess.setForeground(new Color(0, 0, 139));
		btnCashierShortExcess.setBackground(Color.WHITE);
		btnCashierShortExcess.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnCashierShortExcess.setBounds(6, 425, 185, 25);
		leftPanel.add(btnCashierShortExcess);

		btnShortDecl = new JButton("Check Short Declaration");
		btnShortDecl.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 12));
		btnShortDecl.setForeground(new Color(0, 0, 139));
		btnShortDecl.setBackground(Color.WHITE);
		btnShortDecl.setBounds(6, 451, 185, 25);
		leftPanel.add(btnShortDecl);
		
		btnTopArticle = new JButton("Top Sale Articles");
		btnTopArticle.setBounds(6, 240, 185, 25);
		leftPanel.add(btnTopArticle);
		mySplit.setDividerLocation(200);
		mySplit.setContinuousLayout(true);
		SalesViewFrame.getContentPane().add(mySplit);

		btnpiaChart = new JButton("Show Pia Chart");
		btnpiaChart.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnpiaChart.setBounds(806, 105, 121, 34);
		SalesViewFrame.getContentPane().add(btnpiaChart);

		btnbarGraph = new JButton("Show Bar Chart");
		btnbarGraph.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnbarGraph.setBounds(927, 105, 153, 34);
		SalesViewFrame.getContentPane().add(btnbarGraph);

		btnLineChart = new JButton("Show Line Chart");
		btnLineChart.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLineChart.setBounds(667, 104, 137, 35);
		SalesViewFrame.getContentPane().add(btnLineChart);

		searchname = new JTextField();
		searchname.setFont(new Font("Calibri", Font.BOLD, 14));
		searchname.setBounds(198, 109, 231, 30);
		SalesViewFrame.getContentPane().add(searchname);
		searchname.setColumns(10);

		code = new JTextField();
		code.setBounds(434, 109, 45, 30);
		SalesViewFrame.getContentPane().add(code);
		code.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Search Here");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1.setBounds(109, 116, 83, 16);
		SalesViewFrame.getContentPane().add(lblNewLabel_1);

		btnshowSubcat = new JButton("Show SubCategory");
		btnshowSubcat.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnshowSubcat.setBounds(496, 102, 159, 37);
		SalesViewFrame.getContentPane().add(btnshowSubcat);

		mylabel = new JLabel(" -----");
		mylabel.setForeground(new Color(0, 0, 102));
		mylabel.setFont(new Font("Calibri", Font.BOLD, 14));
		mylabel.setHorizontalAlignment(SwingConstants.RIGHT);
		mylabel.setBounds(0, 113, 96, 16);
		SalesViewFrame.getContentPane().add(mylabel);

		btnNewButton = new JButton("");
		btnNewButton.setBounds(1248, 1, 86, 79);
		SalesViewFrame.getContentPane().add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(Daily_Sales_View.class.getResource("/RetailProduct/graphics1.png")));

		lblNewLabel_2 = new JLabel("Sales Data");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 19));
		lblNewLabel_2.setBounds(28, 31, 121, 30);
		SalesViewFrame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setIcon(new ImageIcon(Daily_Sales_View.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_3.setBounds(12, 0, 137, 112);
		SalesViewFrame.getContentPane().add(lblNewLabel_3);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 128)), "Enter Date",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(198, 43, 1038, 62);
		SalesViewFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblFromDate = new JLabel("From Date");
		lblFromDate.setBounds(83, 13, 118, 16);
		panel_1.add(lblFromDate);
		lblFromDate.setFont(new Font("Arial", Font.BOLD, 13));
		lblFromDate.setForeground(new Color(0, 0, 153));
		lblFromDate.setHorizontalAlignment(SwingConstants.LEFT);

		fromdate = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		fromdate.setBounds(83, 29, 116, 25);
		panel_1.add(fromdate);
		fromdate.setFont(new Font("Arial", Font.BOLD, 15));

		fromdate.addActionListener(dt1);
		fromdate.setColumns(10);

		JLabel lblToDate = new JLabel("To Date");
		lblToDate.setBounds(203, 13, 115, 16);
		panel_1.add(lblToDate);
		lblToDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblToDate.setFont(new Font("Arial", Font.BOLD, 13));
		lblToDate.setForeground(new Color(0, 0, 153));

		todate = new JTextField();
		todate.setBounds(202, 29, 116, 25);
		panel_1.add(todate);
		todate.setFont(new Font("Arial", Font.BOLD, 15));
		todate.addActionListener(dt2);
		todate.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Total Sales Amount");
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));
		lblNewLabel_4.setBounds(516, 12, 183, 16);
		panel_1.add(lblNewLabel_4);
		
		mytotalsale = new JTextField();
		mytotalsale.setFont(new Font("Tahoma", Font.BOLD, 14));
		mytotalsale.setBounds(526, 30, 154, 24);
		panel_1.add(mytotalsale);
		mytotalsale.setColumns(10);

		bthH1 = new JButton("Schedule-H1");
		bthH1.setBounds(283, 624, 185, 25);
		SalesViewFrame.getContentPane().add(bthH1);
		bthH1.setForeground(new Color(0, 0, 139));
		bthH1.setBackground(Color.WHITE);
		bthH1.setFont(new Font("Cambria", Font.BOLD, 13));

		btnH = new JButton("Schedule-H");
		btnH.setBounds(467, 624, 185, 25);
		SalesViewFrame.getContentPane().add(btnH);
		btnH.setForeground(new Color(0, 0, 139));
		btnH.setBackground(Color.WHITE);

		btnCancel = new JButton("Cancel");
		btnCancel.setIcon(new ImageIcon(Daily_Sales_View.class.getResource("/RetailProduct/btnApClose.png")));
		btnCancel.setBounds(1225, 104, 97, 35);
		SalesViewFrame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalesViewFrame.dispose();
			}
		});

		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setMnemonic('C');
		btnCancel.setBackground(Color.CYAN);
		
				btnClass = new JButton("Article Class - Contribution");
				btnClass.setBounds(10, 624, 185, 25);
				SalesViewFrame.getContentPane().add(btnClass);
				btnClass.setForeground(new Color(0, 0, 51));
				btnClass.setFont(new Font("Arial", Font.BOLD, 13));
				btnClass.setMnemonic('N');
				btnClass.setBackground(Color.WHITE);
				
						//internalFrame.setVisible(true);
						btnClass.addActionListener(bt22);
		btnH.addActionListener(bt22);
		bthH1.addActionListener(bt22);

		// JSplitPane mySplit1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
		// mySplit, chartPanel);
		// nitin
		// mySplit1.setBounds(1, 105, 1333, 590);
		// mySplit1.setDividerLocation(250);
		// mySplit1.setContinuousLayout(true);
		// mySplit1.setOneTouchExpandable(true);
		// SalesViewFrame.getContentPane().add(mySplit1);
		/*
		 * mySplit3 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, chartPanel ,
		 * chartPanel11) ; mySplit3.setDividerLocation(500);
		 * mySplit3.setContinuousLayout(true);
		 * mySplit3.setOneTouchExpandable(true);
		 * SalesViewFrame.getContentPane().add(mySplit3);
		 */
		btnshowSubcat.addActionListener(bt22);
		BtnBrand.addActionListener(bt22);
		btnDaily.addActionListener(bt22);
		btnArticle.addActionListener(bt22);
		btnMonth.addActionListener(bt22);
		btnSubCat.addActionListener(bt22);
		btnAudit.addActionListener(bt22);
		btnCategory.addActionListener(bt22);
		btnGroup.addActionListener(bt22);
		btnSubGroup.addActionListener(bt22);
		btnuseSales.addActionListener(bt22);
		btnCashierShortExcess.addActionListener(bt22);
		btnShortDecl.addActionListener(bt22);
		btnTopArticle.addActionListener(bt22);
		btnArticleDetail.addActionListener(bt22);
		btnX.addActionListener(bt22);
		btncnopen.addActionListener(bt22);
		btncnclose.addActionListener(bt22);

		btnmySubGroup.addActionListener(bt22);
		btnpiaChart.addActionListener(bt22);
		btnbarGraph.addActionListener(bt22);
		btnLineChart.addActionListener(bt22);
		btnPaymentMode.addActionListener(bt22);
		ActionListener srch = new searchLsnr();
		searchname.addActionListener(srch);
		decorate();
	}

	class fromdateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				fromdate.setText(new gnDate().getmefullDate(fromdate.getText()));
				// new selectdate().selectDate(fromdate );
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
				// new selectdate().selectDate(todate);
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
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
		// new General().msg(fromdate + " "+ todate+" "+vcompcode+""+vsitecode);
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
			mylabel.setText("Brand");
			btnshowSubcat.setVisible(false);
			vtype = reportType;
			new gnAdmin().showMasterTable(vtype, code, searchname);
			break;
		case "Group":
			mylabel.setText("Group");
			btnshowSubcat.setVisible(false);
			vtype = reportType;
			new gnHierarchy().getHierarchyInfo(vtype, vname);
			code.setText(new gnHierarchy().code);
			searchname.setText(new gnHierarchy().name);
			break;
		case "SubGroup":
			mylabel.setText("Sub Group");
			btnshowSubcat.setVisible(false);
			vtype = reportType;
			new gnHierarchy().getHierarchyInfo(vtype, vname);
			code.setText(new gnHierarchy().code);
			searchname.setText(new gnHierarchy().name);
			break;
		case "Category":
			mylabel.setText("Category");
			btnshowSubcat.setVisible(true);
			mylabel.setText("Category");
			vtype = reportType;
			new gnHierarchy().getHierarchyInfo(vtype, vname);
			code.setText(new gnHierarchy().code);
			searchname.setText(new gnHierarchy().name);
			break;
		case "SubCategory":
			btnshowSubcat.setVisible(false);
			mylabel.setText("SubCategory");
			vtype = reportType;
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
		String Col[] = { "Type", "Company", "Store Code", "Code", "Name", "Qty", "Sales Amount", "Purchase Cost", "RGM",
				"Margin" };
		int ColNo = 0;
		vtype = reportType;
		String vcode = code.getText();
		SQL = "Call   view_SalesData1( '" + vtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
				+ vtodate + "'  , " + vverticle + " , '" + vcode + "')";
		ColNo = 9;
		// vtype = "Brand Wise Sales" ;
		showView(SQL, Col, ColNo, vtype);

	}

	private void decorate() throws Throwable {
		SalesViewFrame.setUndecorated(true);
		btnshowSubcat.setVisible(false);
		bthH1.setVisible(false);
		btnH.setVisible(false);
		btnX.setVisible(false);
		String vverticlecode = "";
		vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		vverticle = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		switch (vverticlecode) {
		case "2":
			bthH1.setVisible(true);
			btnH.setVisible(true);
			btnX.setVisible(true);
			break;
		}

		new gnApp().setFrameTitel(SalesViewFrame);
		new gnField().closeform(btnExport, SalesViewFrame);
		new gnDecorate().DispField_Eatch(fromdate, 20);
		new gnDecorate().DispField_Eatch(todate, 20);

		new gnDecorate().decorateBtn(btnExport, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnCancel, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnpiaChart, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnbarGraph, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnLineChart, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnshowSubcat, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnuseSales, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnCashierShortExcess, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnShortDecl, new Color(125, 151, 112), Color.WHITE);

		new gnDecorate().decorateBtn(btnshowSubcat, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnDaily, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnMonth, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(BtnBrand, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnClass, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnArticle, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnCategory, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnSubCat, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnGroup, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnSubGroup, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(bthH1, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnH, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnX, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnmySubGroup, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnAudit, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnArticleDetail, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnPaymentMode, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btncnopen, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btncnclose, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btncnclose, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnTopArticle, new Color(120, 151, 112), Color.WHITE);
		
		 
		/*
		 * new gnStyleButtonSqr().getStyleButton( btnArticleDetail,new
		 * Color(178, 11, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnPaymentMode ,new Color(178, 11,
		 * 112) , Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btncnopen
		 * ,new Color(178, 11, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btncnclose ,new Color(178, 11, 112)
		 * , Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnuseSales ,
		 * new Color(178, 11, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnCashierShortExcess , new
		 * Color(178, 11, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnShortDecl, new Color(178, 11,
		 * 112) , Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnAudit,
		 * new Color(178, 11, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnshowSubcat,new Color(178, 11,
		 * 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnmySubGroup,new Color(178, 11,
		 * 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnDaily,new Color(178, 11, 112) ,
		 * Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnMonth, new
		 * Color(120, 151, 112) , Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(BtnBrand, new Color(131, 211, 112),
		 * Color.BLACK) ; new gnStyleButtonSqr().getStyleButton(btnClass, new
		 * Color(56, 189, 112) , Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnArticle,new Color(178, 11, 112)
		 * , Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnCategory,
		 * new Color(120, 151, 112) , Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnSubCat, new Color(131, 211,
		 * 112), Color.BLACK) ; new gnStyleButtonSqr().getStyleButton(btnGroup,
		 * new Color(56, 189, 112) , Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnSubGroup, new Color(56, 189,
		 * 112) , Color.BLACK) ; new gnStyleButtonSqr().getStyleButton(bthH1,new
		 * Color(178, 11, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnH,new Color(178, 11, 112) ,
		 * Color.WHITE) ;
		 */

		new gnStyleButtonSqr().getStyleButton(btnExport, new Color(178, 11, 112), Color.WHITE);
		new gnStyleButtonSqr().getStyleButton(btnCancel, new Color(178, 11, 112), Color.WHITE);
		new gnStyleButtonSqr().getStyleButton(btnpiaChart, new Color(178, 11, 112), Color.WHITE);
		new gnStyleButtonSqr().getStyleButton(btnbarGraph, new Color(178, 11, 112), Color.WHITE);
		new gnStyleButtonSqr().getStyleButton(btnLineChart, new Color(178, 11, 112), Color.WHITE);

		sitecode.setText(new gnConfig().getStoreID());
		if (sitecode.getText() == "0") {
			System.exit(0);
		}
		compcode.setText(new gnConfig().getCompanyCode());
		sitename.setText(new gnConfig().getStorename(sitecode.getText().toString()));
		// fromdate.setText(new General().getDate());
		// todate.setText(new General().getDate());
		finyear.setText(new gnFinYear().getReportingFinYear());
		vfinyear = finyear.getText();
		fromdate.setText(new gnFinYear().getFirstDateofFinYear());
		todate.setText(new gnFinYear().getLastDateofFinYear());
		btnMonth.doClick();
	}

	
	
	class Btn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vcustomer = "0";

			try {
				getDates();
			} catch (ClassNotFoundException | SQLException e2) {
				e2.printStackTrace();
			}

			if (value == "Show SubCategory") {
				try {
					String vtype = "SubCatOfCategory";
					reportType = "SubCatOfCategory";
					showForParticular();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Show Line Chart") {
				graphType = "LineChart";
				try {
					showChart(reportType);
				} catch (NumberFormatException | ClassNotFoundException | SQLException | IOException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Show Pia Chart") {
				graphType = "PiaChart";
				try {
					showChart(reportType);
				} catch (NumberFormatException | ClassNotFoundException | SQLException | IOException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Show Bar Chart") {
				graphType = "BarChart";
				try {
					showChart(reportType);
				} catch (NumberFormatException | ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Schedule-H1") {
				String vvtype = "Schedule-H1";
				String SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
						+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
				String Col[] = { "Type", "InvNo", "Invdate", "Article", "Name", "DrugType", "Content", "Batch Item",
						"Qty", "Sales Amount", "DoctorName", "Patient Name" };
				int ColNo = 11;
				String vtype = "Schedule-H";
				try {
					showView(SQL, Col, ColNo, vtype);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Schedule-H") {
				String vvtype = "Schedule-H";
				String SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
						+ vfromdate + "' ,'" + vtodate + "' , " + vverticle + ")";
				String Col[] = { "Type", "InvNo", "Invdate", "Article", "Name", "DrugType", "Content", "Batch Item",
						"Qty", "Sales Amount", "DoctorName", "Patient Name" };
				int  ColNo = 11;
				String vtype = "Schedule-H";
				try {
					showView(SQL, Col, ColNo, vtype);
					int totalcolno = 9;
					getsalesTotal(totalcolno);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Schedule-X") {
				String vvtype = "Schedule-X";
				String SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
						+ vfromdate + "' ,'" + vtodate + "' ,  " + vverticle + ")";
				String Col[] = { "Type", "InvNo", "Invdate", "Article", "Name", "DrugType", "Content", "Batch Item",
						"Qty", "Sales Amount", "DoctorName", "Patient Name" };
				int ColNo = 11;
				String vtype = "Schedule-X";
				try {
					showView(SQL, Col, ColNo, vtype);
					int totalcolno = 9;
					getsalesTotal(totalcolno);
  				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Article-Detail View") {
				String vvtype = "Detailview";
				String SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
						+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
				String Col[] = { "Type", "Customre", "Cust.Name", "Inv.No", "Inv.Date", "Article", "Name", "Qty",
						"Gross", "Disc", "NetAmount" };
				int ColNo = 10;
				String vtype = "Detail View";
				try {
					showView(SQL, Col, ColNo, vtype);
					int totalcolno = 10;
					getsalesTotal(totalcolno);

				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			if (value == "Daily Sales") {
				try {
					String vvtype = "Daily";
					String SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					String Col[] = { "Type", "Sales Date", "Qty", "Gross Amount", "Discount", "Sales Value", "SR.Qty",
							"SR.Amt", "Net Sale Qty", "Net Sales Value", "RGM", "Margin%", };
					int ColNo = 11;
					String vtype = "Daily Sales";
					showView(SQL, Col, ColNo, vtype);
					int totalcolno = 9;
					getsalesTotal(totalcolno);
 				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Audit Trail") {
				String vvtype = "Audit";
				reportType = "Audit";
				String SQL2 = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
						+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
				String Col[] = { "Type", "Transaction", "DocNo", "DocDate", "Article", "Name", "Qty", "Rate", "Disc",
						"Value", "User", "Remark", "Time" };
				int ColNo = 12;
				String vtype = "Data Audit ";
				try {
					showView(SQL2, Col, ColNo, vtype);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			if (value == "Payment Summary") {
				String vvtype = "PaymentSummary";
				reportType = vvtype;
				try {
					String SQL2 = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					String Col[] = { "Type", "Date", "Payment Mode", "Amount", "SR.Amount(Cash Refund)",
							"Net Collecction" };
					int ColNo = 5;
					String vtype = "Paymentsummary";
					showView(SQL2, Col, ColNo, vtype);
					int totalcolno = 5;
					getsalesTotal(totalcolno);
 				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Closed Credit Notes") {
				String vvtype = "CloseCN";
				reportType = "CloseCN";
				try {
					String SQL2 = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					// new General().msg(SQL2);
					String Col[] = { "Type", "PartyCode", "Name", "CN.No", "Credit Note Date", "CN Amount",
							"Consume Amount", "Balance Amount" };
					int ColNo = 7;
					String vtype = "CloseCN";
					showView(SQL2, Col, ColNo, vtype);
					int totalcolno = 7;
					getsalesTotal(totalcolno);
 				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Open Credit Notes") {
				String vvtype = "OpenCN";
				reportType = "OpenCN";
				try {
					String SQL2 = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					// new General().msg(SQL2);
					String Col[] = { "Type", "PartyCode", "Name", "CN.No", "CreditNote Date", "CN Amount",
							"Consume Amount", "Balance Amount" };
					int ColNo = 7;
					String vtype = "OpenCN";
					showView(SQL2, Col, ColNo, vtype);
					int totalcolno = 7;
					getsalesTotal(totalcolno);

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "User Wise Sales") {
				String vvtype = "UserWiseSales";
				reportType = vvtype;
				try {
					String SQL2 = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					String Col[] = { "Type", "Date", "UserCode", "Qty", "Sales Amount", "Disc", "Sales Amt", "SR.Qty",
							"SR.Amt", "Net Sale Qty", "Net Sale Value", "RGM", "Margin" };
					int ColNo = 12;
					String vtype = "UserWise";
					showView(SQL2, Col, ColNo, vtype);
					int totalcolno = 10;
					getsalesTotal(totalcolno);

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}

			}

			if (value == "Check Short Declaration") {
				String vvtype = "Short";
				reportType = "Cashier";
				try {
					String vcashiercode = "0";
					String SQL2 = "Call   view_SalesData1( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + " , '" + vcashiercode + "')";
					String Col[] = { "Type", "No", "Date", "Shift", "Terminal", "CashierCode", "Name", "Sales Amt",
							"Declare Amt", "Excess/Short" };
					int ColNo = 9;
					String vtype = "Cashier Short Amt";
					showView(SQL2, Col, ColNo, vtype);
					int totalcolno = 9;
					getsalesTotal(totalcolno);
 				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Cashier Wise Declaration") {
				String vvtype = "CashierwiseDeclaration";
				reportType = "Cashier";
				try {
					String vcashiercode = "0";
					String SQL2 = "Call   view_SalesData1( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + " , '" + vcashiercode + "')";
					String Col[] = { "Type", "No", "Date", "Shift", "Terminal", "CashierCode", "Name", "Sales Amt",
							"Declare Amt", "Excess/Short" };
					int ColNo = 9;
					String vtype = "Cashier Declaration";
					showView(SQL2, Col, ColNo, vtype);
					int totalcolno = 8;
					getsalesTotal(totalcolno);
 				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}

			}

			if (value == "Brand Wise Sales") {
				String vvtype = "Brand";
				reportType = "Brand";
				try {
					String SQL2 = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					String Col[] = { "Type", "Brand Code", "Brand Name", "Qty", "Sales Amount", "Disc", "Sales Amt",
							"Purchase Cost", "SR.Qty", "SR.Amt", "Net Sale Qty", "Net Sale Value", "RGM", "Margin" };
					int ColNo = 13;
					String vtype = "Brand";
					showView(SQL2, Col, ColNo, vtype);
					int totalcolno = 11;
					getsalesTotal(totalcolno);
 				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Month Wise Sales") {
				try {
					String vvtype = "Month";
					reportType = "Month";
					String SQL3 = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					String Col[] = { "Type", "Month.No", "Month", "Qty", "Amount", "Discount", "SalesAmt", "SR.Qty",
							"SR.Amt", "NetSale Qty", "Net Sales Amount", "RGM", "Margin" };
					int ColNo = 12;
					String vtype = "Month";
					showView(SQL3, Col, ColNo, vtype);
					int totalcolno = 10;
					getsalesTotal(totalcolno);
 				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Article Class - Contribution") {
				try {
					String vvtype = "Class";
					reportType = "Class";
					String SQL3 = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "' , " + vverticle + ")";
					String Col[] = { "Type", "Company", "Store Code", "Class", "Class.Name", "Qty", "Sales Amount",
							"Purchase", "Rgm", "Margin" };
					int ColNo = 9;
					String vtype = "Article Class - Contribution";
					showView(SQL3, Col, ColNo, vtype);
					int totalcolno = 6;
					getsalesTotal(totalcolno);
 				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Article /Product  Sales") {
				try {
					String vvtype = "Article";
					reportType = "Article";
					String SQL3 = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					String Col[] = { "Type", "Article Code", "Name", "Qty", "Gross Amount", "Manual Disc", "Promo Disc",
							"Net Amount", "Purchase Cost", "SR Qty", "SR Amt", "NetQty", "Net Sale", "RGM", "Margin%",
							"Shelf Code", "Current Stock", "MBQ" };
					int ColNo = 17;
					String vtype = "Article Sales";
					showView(SQL3, Col, ColNo, vtype);
					int totalcolno = 12;
					getsalesTotal(totalcolno);
 				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			//

			
			
			

			if (value == "Top Sale Articles") {
				try {
					String vvtype = "TopArticle";
					reportType = "TopArticle";
					String vlimit = searchname.getText() ;
					if (vlimit.length() == 0 )
					{
						vlimit = "50" ;
					}
					String SQL3 = "Call   view_SalesData1( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + " , '" + vlimit + "')";
					String Col[] = { "Type", "Article Code", "Name", "Qty", "Gross Amount", "Manual Disc", "Promo Disc",
							"Net Amount", "Purchase Cost", "SR Qty", "SR Amt", "NetQty", "Net Sale", "RGM", "Margin%",
							"Shelf Code", "Current Stock", "MBQ" };
					int ColNo = 17;
					String vtype = "Top ArticleSales";
					showView(SQL3, Col, ColNo, vtype);
					int totalcolno = 12;
					getsalesTotal(totalcolno);
 				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			//

			if (value == "Category wise Sales") {
				try {
					String vvtype = "Category";
					reportType = "Category";
					String SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "' , " + vverticle + ")";
					String Col[] = { "Type", "Category Code", "Name", "Qty", "Gross", "Disc", "Sales Amt",
							"Purchase Cost", "SR.Qty", "SR.Amount", "Net Qty", "Net Amount", "RGM", "Margin%" };
					int ColNo = 13;
					String vtype = "Category";
					showView(SQL, Col, ColNo, vtype);
					int totalcolno = 11;
					getsalesTotal(totalcolno);

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "SubCat Wise Sales") {
				try {
					String vvtype = "SubCategory";
					reportType = "SubCategory";
					String SQL2 = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "' , " + vverticle + ")";
					String Col[] = { "Type", "SubCatCode", "Name", "Qty", "Gross", "Disc", "Sales Amt", "Purchase Cost",
							"SR.Qty", "SR.Amount", "Net Qty", "Net Amount", "RGM", "Margin%" };
					int ColNo = 13;
					String vtype = "SubCategory";
					showView(SQL2, Col, ColNo, vtype);
					int totalcolno = 11;
					getsalesTotal(totalcolno);

				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Group Wise Sales") {
				try {
					String vvtype = "Group";
					reportType = "Group";
					String SQL3 = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					String Col[] = { "Type", "SubCatCode", "Name", "Qty", "Gross", "Disc", "Sales Amt", "Purchase Cost",
							"SR.Qty", "SR.Amount", "Net Qty", "Net Amount", "RGM", "Margin%" };
					int ColNo = 11;
					String vtype = "Group";
					showView(SQL3, Col, ColNo, vtype);
					int totalcolno = 9;
					getsalesTotal(totalcolno);
 				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Sub Group") {
				try {
					String vvtype = "SubGroup";
					reportType = "SubGroup";
					String SQL3 = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					String Col[] = { "Type", "SubCatCode", "Name", "Qty", "Gross", "Disc", "Sales Amt", "Purchase Cost",
							"SR.Qty", "SR.Amount", "Net Qty", "Net Amount", "RGM", "Margin%" };
					int ColNo = 11;
					String vtype = "SubGroup";
					showView(SQL3, Col, ColNo, vtype);
					int totalcolno = 9;
					getsalesTotal(totalcolno);
 				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Export To Excel") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}
		}//
	}

	public void showView(String SQL, String Col[], int colno, String vtype) throws Throwable {
		// new General().msg(SQL) ;
		String vstatus = new gnFinYear().checkDateRanegforFinyear(fromdate.getText(), todate.getText());
		if (vstatus == "Sucess") {
			new gnTable().RemoveTableRows(model);
			// new General().msg("See Table is Emplty ..");
			table = null;
			table = new JTable() {
				public void addNotify() {
					super.addNotify();
					requestFocus();
				}
			};
 			model.setColumnIdentifiers(Col);
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, colno, "N", "Y", vtype);
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			table.setFont(new Font("Helvitica", 13, 13));
			JViewport prt = new JViewport();
			prt.setBackground(Color.CYAN);
			prt.add(table, Col);
			prt.setVisible(true);
			jsp.setViewport(prt);
			jsp.requestFocus();
			new gnFontSetting().setMyFontBold(table, "F1", 14);
			if (table.getRowCount() > 0) 
			{
				table.setShowHorizontalLines(false);
				table.setShowGrid(false);
				//table.setRowSelectionInterval(1, 2);
				table.setRowHeight(28);
				Selectrow();
				new gnTable().setTableBasics(table);
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
		switch (value) {
		case "Brand":
			vvtype = "BrandItems";
			vmonthno = table.getValueAt(row, 1).toString();
			SQL2 = "Call   view_SalesData1('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate
					+ "' ,'" + vtodate + "' , " + vverticle + " , " + vmonthno + ")";
			String Col71[] = { "Type", "Article", "Name", "Qty", "Gross", "Disc", "SalesAmt", "Pur.Cost", "SR.Qty",
					"SR.Amt", "Net Qty", "Net Sales Amt", "RGM", "Margin", "Shelf", "Stock", "MBQ", "" };
			ColNo = 17;
			vtype = "BrandItems";
			try {
				new General().msg(SQL2);
				showView(SQL2, Col71, ColNo, vtype);
				int totalcolno = 7;
				getsalesTotal(totalcolno);
 			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "Category":
			vvtype = "CategoryItems";
			vmonthno = table.getValueAt(row, 1).toString();
			SQL2 = "Call   view_SalesData1('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate
					+ "' ,'" + vtodate + "' , " + vverticle + " , " + vmonthno + ")";
			String Col72[] = { "Type", "Article", "Name", "Qty", "Gross", "Disc", "Sales", "Purchase", "SR.Qty",
					"SR.Amt", "Net Qty", "Net Sales Amt", "RGM", "Margin", "Shelf", "Stock", "MBQ", "" };
			ColNo = 17;
			vtype = "CategoryItems";
			try {
				showView(SQL2, Col72, ColNo, vtype);
				int totalcolno = 11;
				getsalesTotal(totalcolno);
 			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "SubCategory":
			vvtype = "SubCategoryItems";
			vmonthno = table.getValueAt(row, 1).toString();
			SQL2 = "Call   view_SalesData1('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate
					+ "' ,'" + vtodate + "' , " + vverticle + " , " + vmonthno + ")";
			String Col73[] = { "Type", "Article", "Name", "Qty", "Gross", "Disc", "Sales", "Purchase", "SR.Qty",
					"SR.Amt", "Net Qty", "Net Sales Amt", "RGM", "Margin", "Shelf", "Stock", "MBQ", "" };
			ColNo = 17;
			vtype = "SubCattems";
			try {
				showView(SQL2, Col73, ColNo, vtype);
				int totalcolno = 11;
				getsalesTotal(totalcolno);
 			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "Group":
			vvtype = "GroupItems";
			vmonthno = table.getValueAt(row, 1).toString();
			SQL2 = "Call   view_SalesData1('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate
					+ "' ,'" + vtodate + "' , " + vverticle + " , " + vmonthno + ")";
			String Col74[] = { "Type", "Article", "Name", "Qty", "Gross", "Disc", "Sales", "Purchase", "SR.Qty",
					"SR.Amt", "Net Qty", "Net Sales Amt", "RGM", "Margin", "Shelf", "Stock", "MBQ", "" };
			ColNo = 17;
			vtype = "GroupItems";
			try {
				showView(SQL2, Col74, ColNo, vtype);
				int totalcolno = 11;
				getsalesTotal(totalcolno);
 			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "SubGroup":
			vvtype = "SubGroupItems";
			vmonthno = table.getValueAt(row, 1).toString();
			SQL2 = "Call   view_SalesData1('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate
					+ "' ,'" + vtodate + "' , " + vverticle + " , " + vmonthno + ")";
			String Col75[] = { "Type", "Article", "Name", "Qty", "Gross", "Disc", "Sales", "Purchase", "SR.Qty",
					"SR.Amt", "Net Qty", "Net Sales Amt", "RGM", "Margin", "Shelf", "Stock", "MBQ", "" };
			ColNo = 17;
			vtype = "SubGroupItems";
			try {
				showView(SQL2, Col75, ColNo, vtype);
				int totalcolno = 11;
				getsalesTotal(totalcolno);
 			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

			
			
		case "Month":
			vmonthno = table.getValueAt(row, 1).toString();
			vvtype = "MonthDates";
			SQL2 = "Call   view_SalesData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vmonthno + "' ,'"
					+ vfinyear + "' , " + vverticle + ")";
			String Col1[] = { "Type", "Date", "Qty", "Gross", "Disc", "Amount", "SR.Qty", "SR.Value", "Net Sale Qty",
					"Net Sales Value", "RGM", "Margin" };
			ColNo = 11;
			vtype = "Date";
			try {
				//new General().msg(SQL2); //NitinAug
				showView(SQL2, Col1, ColNo, vtype);
				int totalcolno = 9;
				getsalesTotal(totalcolno);
 			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "Date":
			vmonthno = new gnConfig().date_ConverttoDBforamt(table.getValueAt(row, 1).toString());
			vvtype = "BillWise";
			SQL2 = "Call   view_SalesData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vmonthno + "' ,'"
					+ vfinyear + "' , " + vverticle + ")";
			String Col2[] = { "Type", "Invno", "Date", "Customer", "Name", "GSTIN", "Amount" };
			ColNo = 6;
			vtype = "BillWise";
			try {
				showView(SQL2, Col2, ColNo, vtype);
				int totalcolno = 6;
				getsalesTotal(totalcolno);
 			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "BillWise":
			String vdocno = table.getValueAt(row, 1).toString();
			String vdocdate = (table.getValueAt(row, 2).toString());
			try {
				// new gnSale().showinvoice(vdocno, vdocdate);
				new gnEdit().showSales(vdocno, vdocdate);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}

	}

	
	
	
	private void showChart(String vvtype  ) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		String title = "";
	 	String col[] = { "Name", "Amount" };
		String SQL = "";
		//reportType = vvtype ;
		title = vvtype+"Wise Report";
   			SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + ")";
			rs = this.getSPResult(SQL);
			switch (graphType) {
			case "PiaChart":
				File graph = new View_pieChart().drawPieChart(rs, title, col, vvtype);
				setImage(graph , "") ;
				break;
			case "BarChart":
				new View_BarChart(rs, title, title, vvtype);
				break;
			case "LineChart":
				new View_LineChart(rs, title, title, vvtype);
				break;
			}
  	}
	

	
	
	
	
	private void showChartBKP() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		String title = "";
		String vvtype = "Brand";
		String col[] = { "Name", "Amount" };
		String SQL = "";
		
		if (reportType == "Brand") {
			vvtype = "Brand";
			title = "Brand Wise Sales";
			SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + ")";
			rs = this.getSPResult(SQL);
			switch (graphType) {
			case "PiaChart":
				File graph = new View_pieChart().drawPieChart(rs, title, col, vvtype);
				setImage(graph , "") ;
				break;
			case "BarChart":
				new View_BarChart(rs, title, title, vvtype);
				break;
			case "LineChart":
				new View_LineChart(rs, title, title, vvtype);
				break;
			}
		}

		if (reportType == "Category") {
			vvtype = "Category";
			title = "Category Wise Sales";
			SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + ")";
			rs = this.getSPResult(SQL);
			// new General().msg(graphType);
			switch (graphType) {
			case "PiaChart":
				File graph = new View_pieChart().drawPieChart(rs, title, col, vvtype);
				break;
			case "BarChart":
				new View_BarChart(rs, title, title, vvtype);
				break;
			case "LineChart":
				new View_LineChart(rs, title, title, vvtype);
				break;
			}
		}

		if (reportType == "SubCategory") {
			vvtype = "SubCategory";
			title = "Sub Category Wise Sales";
			SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + ")";
			rs = this.getSPResult(SQL);
			// new General().msg(graphType);
			switch (graphType) {
			case "PiaChart":
				File graph = new View_pieChart().drawPieChart(rs, title, col, vvtype);
				break;
			case "BarChart":
				new View_BarChart(rs, title, title, vvtype);
				break;
			case "LineChart":
				new View_LineChart(rs, title, title, vvtype);
				break;
			}
		}

		if (reportType == "Group") {
			vvtype = "Group";
			title = "Group  Wise Sales";
			SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + ")";
			rs = this.getSPResult(SQL);
			// new General().msg(graphType);
			switch (graphType) {
			case "PiaChart":
				File graph = new View_pieChart().drawPieChart(rs, title, col, vvtype);
				break;
			case "BarChart":
				new View_BarChart(rs, title, title, vvtype);
				break;
			case "LineChart":
				new View_LineChart(rs, title, title, vvtype);
				break;
			}
		}

		if (reportType == "SubGroup") {
			vvtype = "SubGroup";
			title = "Sub Group  Wise Sales";
			SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + ")";
			rs = this.getSPResult(SQL);
			// new General().msg(graphType);
			switch (graphType) {
			case "PiaChart":
				File graph = new View_pieChart().drawPieChart(rs, title, col, vvtype);
				break;
			case "BarChart":
				new View_BarChart(rs, title, title, vvtype);
				break;
			case "LineChart":
				new View_LineChart(rs, title, title, vvtype);
				break;
			}
		}

		if (reportType == "Month") {
			vvtype = "Month";
			title = "Month Wise Sales";
			SQL = "Call   view_SalesData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + ")";
			rs = this.getSPResult(SQL);
			switch (graphType) {
			case "piaChart":
				new View_pieChart().drawPieChart(rs, title, col, vvtype);
				break;
			case "barChart":
				new View_BarChart(rs, title, title, vvtype);
				break;
			case "LineChart":
				new View_LineChart(rs, title, title, vvtype);
				break;
			}
		}

	}
	
	
	

	private void setImage(File imgfile , String vimg)
	{
  	 	  ImageIcon ii = new ImageIcon(imgfile.toString() );
  	 	  int x = ii.getIconWidth() ;
 	 	  int y = ii.getIconHeight();
 	 	//  jsp.setBounds(1, 103, 1000, 299) ;
  	 	  //imagePanel.removeAll();
  	 	  lblimage = new JLabel(ii);
   	 	  lblimage.setBounds(1,1, x, 299);
  	 	   JViewport prt111 = new JViewport();
 	  	   prt111.setBackground(Color.CYAN);
 	   	   prt111.setVisible(true);
 	  	   prt111.add(lblimage);
 	   	   jsp.setViewport(prt111);
 	       jsp.revalidate();
 	       jsp.repaint();
 		   jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
 		   jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
 		   jsp.setAutoscrolls(true);
 	       jsp.setVisible(true);
 	}
	
	
private void getsalesTotal(int colno)
{
	mytotalsale.setText("0");
	mytotalsale.setText(Double.toString(new gnTable().getTotal(table, colno)));
}
	
	
}// last

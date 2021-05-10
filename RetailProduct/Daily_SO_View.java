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

public class Daily_SO_View extends getResultSet {

	JFrame SOViewFrame;
	JInternalFrame internalFrame;
	JLabel mylabel;
	JButton btnshowSubcat;
	JButton btnConsolidation ;
	String reportType;
	String graphType;
	private JTextField fromdate;
  	JButton btnItemWise ;
  	String vverticle;
 	JButton btnSubCat;
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
	private JTextField compcode;
	private JTextField sitecode;
	private String vfinyear;
	private JTextField sitename;
	// JFXPanel bigchart = new JFXPanel() ;
	private JLabel lblNewLabel;
	private JTextField finyear;
	private JButton btnImage;
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
	private JButton btnChannel;
	private JButton btnPendingSO;
	private JButton btnComplete;
	private JButton btnCity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Daily_SO_View window = new Daily_SO_View();
					window.SOViewFrame.setVisible(true);
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
	public Daily_SO_View() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		SOViewFrame = new JFrame();
		SOViewFrame.getContentPane().setBackground(new Color(204, 255, 255));
		SOViewFrame.setTitle("Business Application - Stand Alone Store Edition");
		SOViewFrame.setResizable(false);
		SOViewFrame.setAlwaysOnTop(true);
		SOViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SOViewFrame.setBounds(1, 90, 1350, 656);

		/*
		internalFrame = new JInternalFrame("Sales View ");
		SalesViewFrame.getContentPane().setBackground(Color.WHITE);
		internalFrame.setForeground(Color.GREEN);
		internalFrame.setBounds(0, 0, 1350, 750);
		SalesViewFrame.getContentPane().add(internalFrame);
		SalesViewFrame.getContentPane().setLayout(null);
*/
		SOViewFrame.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(198, 0, 562, 43);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(0, 2, 0, 2, (Color) new Color(0, 255, 204)));
		SOViewFrame.getContentPane().add(panel);
		panel.setLayout(null);
		ActionListener dt1 = new fromdateLsnr();
		ActionListener dt2 = new todateLsnr();
		ActionListener bt22 = new Btn();

		sitename = new JTextField();
		sitename.setHorizontalAlignment(SwingConstants.CENTER);
		sitename.setForeground(new Color(102, 0, 102));
		sitename.setBackground(Color.WHITE);
		sitename.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));
		sitename.setEditable(false);
		sitename.setBounds(0, 0, 559, 43);
		panel.add(sitename);
		sitename.setColumns(10);

		btnExport = new JButton("Export To Excel");
		btnExport.setBounds(1080, 104, 143, 35);
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExport.setMnemonic('E');
		btnExport.setBackground(Color.CYAN);
		btnExport.addActionListener(bt22);
		SOViewFrame.getContentPane().add(btnExport);

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

		btnMonth = new JButton("Month Wise");
		btnMonth.setForeground(new Color(51, 0, 153));
		btnMonth.setToolTipText("Month wise Sales");
		btnMonth.setBounds(6, 26, 185, 25);
		leftPanel.add(btnMonth);
		btnMonth.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnMonth.setMnemonic('M');
		btnMonth.setBackground(Color.WHITE);

		btnArticle = new JButton("Article /Product");
		btnArticle.setForeground(new Color(51, 0, 153));
		btnArticle.setBounds(6, -55, 185, 25);
		leftPanel.add(btnArticle);
		btnArticle.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnArticle.setMnemonic('A');
		btnArticle.setBackground(Color.WHITE);

		btnDaily = new JButton("Date Wise Orders");
		btnDaily.setForeground(new Color(51, 0, 153));
		btnDaily.setBounds(6, 52, 185, 25);
		leftPanel.add(btnDaily);
		btnDaily.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnDaily.setMnemonic('D');
		btnDaily.setBackground(Color.WHITE);

		BtnBrand = new JButton("Brand Wise");
		BtnBrand.setForeground(new Color(51, 0, 153));
		BtnBrand.setBounds(6, 79, 185, 25);
		leftPanel.add(BtnBrand);
		BtnBrand.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		BtnBrand.setMnemonic('B');
		BtnBrand.setBackground(Color.WHITE);

	 
		JSplitPane mySplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, jsp);
		mySplit.setBounds(0, 138, 1334, 485);

 
		btnSubCat = new JButton("SubCat Wise");
		btnSubCat.setBackground(Color.WHITE);
		btnSubCat.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnSubCat.setForeground(new Color(51, 0, 153));
		btnSubCat.setMnemonic('S');
		btnSubCat.setBounds(6, 104, 185, 25);
		leftPanel.add(btnSubCat);

	 
   
		btnArticleDetail = new JButton("Order List");
		btnArticleDetail.setBackground(Color.WHITE);
		btnArticleDetail.setForeground(new Color(51, 0, 153));
		btnArticleDetail.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnArticleDetail.setBounds(6, 131, 185, 31);
		leftPanel.add(btnArticleDetail);
		
 		
		btnChannel = new JButton("Channel Wise");
		btnChannel.setForeground(new Color(51, 0, 153));
		btnChannel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnChannel.setBounds(6, 163, 185, 30);
		leftPanel.add(btnChannel);
		
		btnPendingSO = new JButton("Pending SO");
		btnPendingSO.setForeground(new Color(51, 0, 102));
		btnPendingSO.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnPendingSO.setBounds(6, 224, 185, 30);
		leftPanel.add(btnPendingSO);
		
		btnComplete = new JButton("Complete SO");
		btnComplete.setForeground(new Color(51, 0, 102));
		btnComplete.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnComplete.setBounds(6, 253, 185, 30);
		leftPanel.add(btnComplete);

 		
		
		btnCity = new JButton("City Wise");
		btnCity.setForeground(new Color(102, 0, 102));
		btnCity.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
 		btnCity.setBounds(6, 195, 185, 30);
		leftPanel.add(btnCity);
		
		btnItemWise = new JButton("Item Wise List");
		btnItemWise.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnItemWise.setToolTipText("Sales Order Item List --> Purchase Planning ");
		btnItemWise.setBounds(6, 286, 185, 25);
		leftPanel.add(btnItemWise);
		
		btnConsolidation = new JButton("SO Consolidation");
 		btnConsolidation.setBounds(6, 312, 185, 25);
		leftPanel.add(btnConsolidation);
  
 
		mySplit.setDividerLocation(200);
		mySplit.setContinuousLayout(true);
		SOViewFrame.getContentPane().add(mySplit);

		 
		 
		 

		searchname = new JTextField();
		searchname.setBounds(198, 109, 231, 30);
		searchname.setFont(new Font("Calibri", Font.BOLD, 14));
		SOViewFrame.getContentPane().add(searchname);
		searchname.setColumns(10);

		code = new JTextField();
		code.setBounds(429, 109, 50, 30);
		SOViewFrame.getContentPane().add(code);
		code.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Search Here");
		lblNewLabel_1.setBounds(118, 113, 83, 16);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		SOViewFrame.getContentPane().add(lblNewLabel_1);

		btnshowSubcat = new JButton("Show SubCategory");
		btnshowSubcat.setBounds(496, 102, 159, 37);
		btnshowSubcat.setFont(new Font("Tahoma", Font.BOLD, 11));
		SOViewFrame.getContentPane().add(btnshowSubcat);

		mylabel = new JLabel(" -----");
		mylabel.setBounds(0, 113, 96, 16);
		mylabel.setForeground(new Color(0, 0, 102));
		mylabel.setFont(new Font("Calibri", Font.BOLD, 14));
		mylabel.setHorizontalAlignment(SwingConstants.RIGHT);
		SOViewFrame.getContentPane().add(mylabel);

		btnImage = new JButton("");
		btnImage.setBounds(760, 1, 574, 103);
		SOViewFrame.getContentPane().add(btnImage);
		btnImage.setIcon(new ImageIcon(Daily_Sales_View.class.getResource("/RetailProduct/graphics1.png")));

		lblNewLabel_2 = new JLabel("SO Data");
		lblNewLabel_2.setBounds(34, 50, 121, 30);
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 19));
		SOViewFrame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setBounds(0, 0, 133, 112);
		lblNewLabel_3.setIcon(new ImageIcon(Daily_Sales_View.class.getResource("/RetailProduct/mdf7.jpg")));
		SOViewFrame.getContentPane().add(lblNewLabel_3);

		panel_1 = new JPanel();
		panel_1.setBounds(198, 43, 562, 62);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 128)), "Enter Date",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		SOViewFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblFromDate = new JLabel("From Date");
		lblFromDate.setBounds(83, 13, 118, 16);
		panel_1.add(lblFromDate);
		lblFromDate.setFont(new Font("Arial", Font.BOLD, 13));
		lblFromDate.setForeground(new Color(0, 0, 153));
		lblFromDate.setHorizontalAlignment(SwingConstants.LEFT);

		/*
		fromdate = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		*/

		
		fromdate = new gnRoundTextField(10) {
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

		//todate = new JTextField();
		todate = new gnRoundTextField(10);
 		todate.setBounds(202, 29, 116, 25);
		panel_1.add(todate);
		todate.setFont(new Font("Arial", Font.BOLD, 15));
		todate.addActionListener(dt2);
		todate.setColumns(10);
		
				compcode = new JTextField();
				compcode.setBounds(463, 29, 36, 25);
				panel_1.add(compcode);
				compcode.setVisible(false);
				compcode.setForeground(Color.BLACK);
				compcode.setBackground(Color.WHITE);
				compcode.setFont(new Font("Calibri", Font.BOLD, 14));
				compcode.setEditable(false);
				compcode.setColumns(10);
				
						sitecode = new JTextField();
						sitecode.setBounds(502, 29, 49, 25);
						panel_1.add(sitecode);
						sitecode.setVisible(false);
						sitecode.setForeground(Color.BLACK);
						sitecode.setBackground(Color.WHITE);
						sitecode.setFont(new Font("Calibri", Font.BOLD, 14));
						sitecode.setEditable(false);
						sitecode.setColumns(10);
						
								lblNewLabel = new JLabel("Financial Year");
								lblNewLabel.setBounds(341, 11, 91, 16);
								panel_1.add(lblNewLabel);
								lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 14));
								lblNewLabel.setForeground(new Color(0, 0, 102));
								
										finyear = new JTextField();
										finyear.setBounds(341, 29, 116, 25);
										panel_1.add(finyear);
										finyear.setFont(new Font("Arial", Font.PLAIN, 17));
										finyear.setColumns(10);

 		 
 	 
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(1225, 104, 97, 35);
		btnCancel.setIcon(new ImageIcon(Daily_Sales_View.class.getResource("/RetailProduct/btnApClose.png")));
		SOViewFrame.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SOViewFrame.dispose();
			}
		});

		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setMnemonic('C');
		btnCancel.setBackground(Color.CYAN);
	  
		 

		//internalFrame.setVisible(true);
	 	btnshowSubcat.addActionListener(bt22);
		BtnBrand.addActionListener(bt22);
		btnItemWise.addActionListener(bt22);
		btnChannel.addActionListener(bt22);
		btnPendingSO.addActionListener(bt22);
		btnComplete.addActionListener(bt22);
		btnCity.addActionListener(bt22);
 		
		btnDaily.addActionListener(bt22);
		btnArticle.addActionListener(bt22);
		btnMonth.addActionListener(bt22);
		btnSubCat.addActionListener(bt22);
	  	btnArticleDetail.addActionListener(bt22);
	  	btnConsolidation.addActionListener(bt22);
		 
  		ActionListener srch = new searchLsnr();
		searchname.addActionListener(srch);
		decorate();
	}

	class fromdateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				fromdate.setText(new gnDate().getmefullDate(fromdate.getText()));
 			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
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
 		showView(SQL, Col, ColNo, vtype);
 	}

	private void decorate() throws Throwable {
		btnshowSubcat.setVisible(false);
 		String vverticlecode = "";
		vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		vverticle = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		switch (vverticlecode) {
		case "2":
 			break;
		}

		new gnApp().setFrameTitel(SOViewFrame);
		new gnField().closeform(btnExport, SOViewFrame);
		new gnDecorate().DispField_Eatch(fromdate, 20);
		new gnDecorate().DispField_Eatch(todate, 20);

		new gnDecorate().decorateBtn(btnExport, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnCancel, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnshowSubcat, new Color(125, 151, 112), Color.WHITE);
	 
		new gnDecorate().decorateBtn(btnshowSubcat, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnDaily, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnMonth, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(BtnBrand, new Color(120, 151, 112), Color.WHITE);
	 	new gnDecorate().decorateBtn(btnArticle, new Color(120, 151, 112), Color.WHITE);
 		new gnDecorate().decorateBtn(btnSubCat, new Color(120, 151, 112), Color.WHITE);
 		new gnDecorate().decorateBtn(btnArticleDetail, new Color(120, 151, 112), Color.WHITE);
  		new gnDecorate().decorateBtn(btnChannel, new Color(120, 151, 112), Color.WHITE);
	    new gnDecorate().decorateBtn(btnPendingSO, new Color(120, 151, 112), Color.WHITE);
	    new gnDecorate().decorateBtn(btnComplete, new Color(120, 151, 112), Color.WHITE);
	    new gnDecorate().decorateBtn(btnCity, new Color(120, 151, 112), Color.WHITE);

		
		 
		new gnStyleButtonSqr().getStyleButton(btnExport, new Color(178, 11, 112), Color.WHITE);
		new gnStyleButtonSqr().getStyleButton(btnCancel, new Color(178, 11, 112), Color.WHITE);
	 
		sitecode.setText(new gnConfig().getStoreID());
		if (sitecode.getText() == "0") {
			System.exit(0);
		}
		compcode.setText(new gnConfig().getCompanyCode());
		sitename.setText(new gnConfig().getStorename(sitecode.getText().toString()));
		vcompcode = (compcode.getText());
		vsitecode = (sitecode.getText());
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

	         if (value == "SO Consolidation")
	         {
 					String vvtype = "SOConsolidationData" ;
					String SQL = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					String Col[] = { "Type", "Level" , "From", "To" , "Article" , "Name" ,"Qty" , "Bal_Qty" ,
							"Band" , "SubCat"};
					int ColNo = 9;
					String vtype = "SOConsolidationData";
					try {
						showView(SQL, Col, ColNo, vtype);
					} catch (Throwable e1) {
	 					e1.printStackTrace();
					}
 	         }

	         
	         
			if (value == "Order List") 
			{
				String vvtype = "OrderList";
				String SQL = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
						+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
				String Col[] = { "Type", "Sr.No", "Customre", "Name", "City", "OrderNo", "OrderDate",   
								  "Article", "Name", "Qty",
								  "Rate", "Gross", "Disc", "NetAmount" };
				int ColNo = 13;
				String vtype = "OrerList";
				try {
					showView(SQL, Col, ColNo, vtype);
				} catch (Throwable e1) {
 					e1.printStackTrace();
				}

			}

			if (value == "Date Wise Orders") {
				try {
					String vvtype = "DateWiseOrder";
					String SQL = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					
					String Col[] = { "Type", "Customer" , "Name",  "City", "Order No", "Order Date",  "Time" ,
							    "DeliveryDate",  "Type",  "Gross",  "Discount", "Order Value", "Status"};
					int ColNo = 12;
					String vtype = "Orders";
					showView(SQL, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Month Wise") {
				try {
					String vvtype = "Month";
					reportType = "Month";
					String SQL3 = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					
					String Col[] = { "Type",  "Month", "Order-Count" ,
							  "Gross", "Discount", "orderValue",  };
					int ColNo = 5;
					String vtype = "Month";
					showView(SQL3, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
 			
		 
			if (value == "Brand Wise") {
				String vvtype = "Brand";
				reportType = "Brand";
				try {
					String SQL2 = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					
					String Col[] = { "Type", "Code" , "BrandName", "Qty", "Gross", "Disc", "Order Value" };
					int ColNo = 6;
					String vtype = "Brand";
					showView(SQL2, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

  
			if (value == "Item Wise List") {
				try {
					String vvtype = "Article";
					reportType = "Article";
					String SQL3 = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "'  , " + vverticle + ")";
					
					String Col[] = { "Type", "Article Code", "Name", "TotalQty", "Gross", "Disc", 
 							"Amount",  "Current Stock", "Brand" , "SubCategory"};
					int ColNo = 9;
					String vtype = "Article Sales";
					showView(SQL3, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Pending SO") {
				try {
					String vvtype = "Pending";
					reportType = "PendingSO";
					String SQL2 = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "' , " + vverticle + ")";
 					String Col[] = { "Type", "City", "OrderNo" , "OrderDate" , "Order Amount" , "Status"};
 					int ColNo = 5;
					String vtype = "City";
					showView(SQL2, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			if (value == "Complete SO") {
				try {
					String vvtype = "Complete";
					reportType = "CompleteSO";
					String SQL2 = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "' , " + vverticle + ")";
					
					String Col[] = { "Type", "City", "OrderNo" , "OrderDate" , "Order Amount" , "Status"};
					int ColNo = 5;
					String vtype = "City";
					showView(SQL2, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			
			
			if (value == "City Wise") {
				try {
					String vvtype = "Citywise";
					reportType = "City";
					String SQL2 = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "' , " + vverticle + ")";
					
					String Col[] = { "Type", "City",      "Order Value"   };
					int ColNo = 2;
					String vtype = "City";
					showView(SQL2, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			

			
			if (value == "Channel Wise") {
				try {
					String vvtype = "ChannelWise";
					reportType = "Channel";
					String SQL2 = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "' , " + vverticle + ")";
					
					String Col[] = { "Type", "Channel",      "Order Value"   };
					int ColNo = 2;
					String vtype = "Channel";
					showView(SQL2, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			//

 
			
			
			
			if (value == "SubCat Wise") {
				try {
					String vvtype = "SubCategory";
					reportType = "SubCategory";
					String SQL2 = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '"
							+ vfromdate + "' ,'" + vtodate + "' , " + vverticle + ")";
					String Col[] = { "Type", "Code", "Name", "Qty", "Gross", "Disc", "Order Amt" } ;
 					int ColNo = 6;
					String vtype = "SubCategory";
					showView(SQL2, Col, ColNo, vtype);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
  
			
			
			if (value == "Export To Excel") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}
		}//
	}

	
	
	public void showView(String SQL, String Col[], int colno, String vtype) throws Throwable {
		//new General().msg(SQL) ;
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
 			model.setColumnIdentifiers(Col);
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, colno, "N", "Y", vtype);
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
 			JViewport prt = new JViewport();
			prt.setBackground(Color.CYAN);
			prt.add(table, Col);
			prt.setVisible(true);
			jsp.setViewport(prt);
			jsp.requestFocus();
			new gnFontSetting().setMyFontBold(table, "F1", 12);
			if (table.getRowCount() > 0) 
			{
				table.setShowHorizontalLines(false);
				table.setShowGrid(false);
 				table.setRowHeight(28);
				//Selectrow();
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
				} 
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
				//new General().msg(SQL2);
				showView(SQL2, Col71, ColNo, vtype);
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
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

 
		case "Month":
			vmonthno = table.getValueAt(row, 1).toString();
			vvtype = "MonthDates";
			SQL2 = "Call   view_SOData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vmonthno + "' ,'"
					+ vfinyear + "' , " + vverticle + ")";
			String Col1[] = { "Type", "Date", "Qty", "Gross", "Disc", "Amount", "SR.Qty", "SR.Value", "Net Sale Qty",
					"Net Sales Value", "RGM", "Margin" };
			ColNo = 11;
			vtype = "Date";
			try {
				//new General().msg(SQL2); //NitinAug
				showView(SQL2, Col1, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "Date":
			vmonthno = new gnConfig().date_ConverttoDBforamt(table.getValueAt(row, 1).toString());
			vvtype = "SOWise";
			SQL2 = "Call   view_SOData('" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vmonthno + "' ,'"
					+ vfinyear + "' , " + vverticle + ")";
			String Col2[] = { "Type", "Invno", "Date", "Customer", "Name", "GSTIN", "Amount" };
			ColNo = 6;
			vtype = "SOWise";
			try {
				showView(SQL2, Col2, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "SOWise":
			String vdocno = table.getValueAt(row, 1).toString();
			String vdocdate = (table.getValueAt(row, 2).toString());
			try {
				 new gnSale().showinvoice(vdocno, vdocdate);
				//new gnEdit().showSales(vdocno, vdocdate);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}

	}

	private void showChart() throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		String title = "";
		String vvtype = "Brand";
		String col[] = { "Name", "Amount" };
		String SQL = "";

		if (reportType == "Brand") {
			vvtype = "Brand";
			title = "Brand Wise";
			SQL = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + ")";
			rs = this.getSPResult(SQL);
			switch (graphType) {
			case "PiaChart":
				int colname = 2;
				int colvalue = 6;
				File graph = new View_pieChart().drawPieChart(rs, title, col , vvtype);
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
			title = "Sub Category Wise";
			SQL = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + ")";
			rs = this.getSPResult(SQL);
			// new General().msg(graphType);
			switch (graphType) {
			case "PiaChart":
				int colname = 2;
				int colvalue = 6;
				File graph = new View_pieChart().drawPieChart(rs, title, col , vvtype);
				//btnImage.setIcon(new ImageIcon(Daily_Sales_View.class.getResource(graph.toString())));
 				break;
			case "BarChart":
				new View_BarChart(rs, title, title, vvtype);
				break;
			case "LineChart":
				new View_LineChart(rs, title, title, vvtype);
				break;
			}
		}


		if (reportType == "City") {

			vvtype = "Citywise";
 			title = "City Wise";
			SQL = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + ")";
			rs = this.getSPResult(SQL);
			// new General().msg(graphType);
			switch (graphType) {
			case "PiaChart":
				File graph = new View_pieChart().drawPieChart(rs, title, col , vvtype);
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
			title = "Month Wise";
			SQL = "Call   view_SOData( '" + vvtype + "', " + vcompcode + "," + vsitecode + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + ")";
			rs = this.getSPResult(SQL);
			switch (graphType) {
			case "piaChart":
		 		File graph = new View_pieChart().drawPieChart(rs, title, col , vvtype);
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
}// last

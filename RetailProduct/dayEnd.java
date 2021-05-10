package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class dayEnd extends getResultSet {

	JFrame frameDayEnd;
	JPanel panel_2;
	private JButton btnDayEnd;
	private JButton btnCancel;
	private JButton btnshow;
 	private JRadioButton rbcashrecorded;
	private JRadioButton rbcash;

	String vsalesDate;
	String vcomp;
	String vstore;
 	private JTextField companycode;
	private JTextField companyname;
	private JTextField crpaidamount;
	private JTextField totalcrsales;
	private JTextField paidamount;
	private JTextField b2bsales;
	private JTextField wsales;
	private JTextField diffamt;
 	private JTextField salesamount;
	private JTextField sramount;
	private JTextField tcollection;
	private JTextField cashreturn;
	private JTextField netsales;
	private JTextField netcollection;
	private JTextField cnamount;
	private JTextField storecode;
	private JTextField storename;
	private JTextField begindate;
	private JTextField enddate;

	public JInternalFrame internalFrame;
 
	private JScrollPane jsp;
  
	JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2 || column == 3) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			}
			return componentt;
		}
	};

	DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) { // 0 3 4 5 7 8 13
																// 14 15
			return column == 0 || column == 3 || column == 4 || column == 8 || column == 13 || column == 14 ? true
					: false;
		}
	};
 	String Col[] = { "Transaction", "Type", "No.of.Records", "Amount" };
 	private JScrollPane pjsp;
	JTable ptable = new JTable();
	DefaultTableModel pmodel = new DefaultTableModel();
	String decCol[] = { "Declaration_date", "Cashier_code", "Terminal", "Shift", "Sales_Amount", "Declare_Amount",
			"Withdraw Amt", "Opening  Cash", "Diff_amount" };
 
	// for cashier wise and shift wise sales Data
	JTable stable = new JTable();
 	DefaultTableModel smodel = new DefaultTableModel();
	private JScrollPane sjsp;
	public String shiftCol[] = { "Store code", "Date", "Terminal", "Cashier", "Shift", "Amount", "FloatCash" };


  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dayEnd window = new dayEnd();
					window.frameDayEnd.setVisible(true);
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
	public dayEnd() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frameDayEnd = new JFrame();
		frameDayEnd.setAlwaysOnTop(true);
		frameDayEnd.setTitle("Business Application");
		frameDayEnd.setBounds(1, 99, 1370, 600);
		frameDayEnd.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameDayEnd.getContentPane().setLayout(null);
		frameDayEnd.getContentPane().setBackground(Color.WHITE);
		frameDayEnd.getContentPane().setLayout(null);

		/*
		internalFrame = new JInternalFrame("Day End ");
		internalFrame.setEnabled(false);
 		internalFrame.setBounds(0, 0, 1171, 599);
		frameDayEnd.getContentPane().add(internalFrame);
        */
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(100, 31, 1240, 71);
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		frameDayEnd.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblDayEndDate = new JLabel("Day End Date");
		lblDayEndDate.setBounds(25, 10, 120, 20);
		lblDayEndDate.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		panel.add(lblDayEndDate);

		// enddate = new JTextField();
		enddate = new gnRoundTextField(20);
		enddate.setToolTipText("Day Close Date");
		enddate.setBounds(25, 28, 120, 30);
		enddate.setFont(new Font("Segoe UI", Font.BOLD, 16));
		panel.add(enddate);
		enddate.setColumns(10);

		// btnDayEnd = new JButton("Day End");
		btnDayEnd = new gnRoundButton("Day End");
		btnDayEnd.setToolTipText("Press Day End Button To Close Running Day");
		btnDayEnd.setBounds(171, 30, 96, 30);
		btnDayEnd.setBackground(new Color(0, 0, 102));
		btnDayEnd.setForeground(Color.WHITE);
		btnDayEnd.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnDayEnd.setMnemonic('D');
		panel.add(btnDayEnd);
		ActionListener ls2 = new lsnrBtn();
		btnDayEnd.addActionListener(ls2);

		// JPanel panel_1 = new JPanel();
		JPanel panel_1 = new gnRoundPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(4, 109, 830, 256);
		frameDayEnd.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(12, 27, 391, 219);
		panel_1.add(jsp);
		ActionListener ls1 = new lsnrBtn();

		pjsp = new JScrollPane();
		pjsp.setBounds(406, 27, 412, 219);
		panel_1.add(pjsp);

		// JButton btnNewButton = new JButton("Transactions For The Day");
		JButton btnNewButton = new gnRoundButton("Transactions For The Day");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		btnNewButton.setForeground(new Color(0, 102, 102));
		btnNewButton.setBounds(12, 4, 391, 25);
		panel_1.add(btnNewButton);

		// JButton btnNewButton_1 = new JButton("Cashier Wise Declare
		// Collection");
		JButton btnNewButton_1 = new gnRoundButton("Cashier Wise Declare Collection");
		btnNewButton_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(406, 4, 412, 25);
		panel_1.add(btnNewButton_1);

		// JPanel botm_panel = new JPanel();
		JPanel botm_panel = new gnRoundPanel();
		botm_panel.setBackground(Color.WHITE);
		botm_panel.setBounds(4, 364, 816, 44);
		frameDayEnd.getContentPane().add(botm_panel);
		botm_panel.setLayout(null);

		JButton btnDeclaration = new JButton("Declaration");
		btnDeclaration.setHorizontalAlignment(SwingConstants.LEFT);
		btnDeclaration.setBounds(414, 2, 156, 25);
		botm_panel.add(btnDeclaration);
		btnDeclaration.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));

		JButton btnFloat = new JButton("Float Cash");
		String vpara701 = "701";
		new getConfigurationSetting().setBtnConfig(btnFloat, vpara701);
 		btnFloat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cashDeposit_Withdraw window;
				try {
					window = new cashDeposit_Withdraw();
					window.cashdepost_wdrw.setVisible(true);
 				} catch (Throwable e) {
 					e.printStackTrace();
				}
  			}
		});
 		btnFloat.setBounds(305, 2, 97, 25);
		botm_panel.add(btnFloat);

		
		JButton btnRefresh = new JButton("Refresh Declaration");
		btnRefresh.setHorizontalAlignment(SwingConstants.LEFT);
		btnRefresh.setBounds(573, 2, 206, 25);
		botm_panel.add(btnRefresh);
		btnRefresh.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		
		JButton btnCheckClosingBal = new JButton("Check Closing Bal");
		btnCheckClosingBal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CashFlow_Mini window;
				try {
					window = new CashFlow_Mini();
					window.cashFlowFrameMini.setVisible(true);
 				} catch (Throwable e1) {
 					e1.printStackTrace();
				}
 			}
		});
		btnCheckClosingBal.setBounds(147, 2, 158, 25);
		botm_panel.add(btnCheckClosingBal);
 		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					getDeclarationData();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnDeclaration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Declaration window;
				try {
					window = new Declaration();
					window.DeclarationFrame.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		JButton btnCashierWiseAnd = new JButton("Cashier Wise  Shift  wise Sales For the Day");
		btnCashierWiseAnd.setEnabled(false);
		btnCashierWiseAnd.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		btnCashierWiseAnd.setBounds(4, 409, 830, 25);
		frameDayEnd.getContentPane().add(btnCashierWiseAnd);

		// btnCancel = new JButton("Close");
		btnCancel = new gnRoundButton("Close");
		btnCancel.setFont(new Font("Arial", Font.BOLD, 16));
		btnCancel.setBounds(885, 503, 207, 49);
		frameDayEnd.getContentPane().add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameDayEnd.dispose();
			}
		});
		btnCancel.setMnemonic('C');
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(new Color(153, 255, 204));

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Credit Sales Details ", TitledBorder.CENTER, TitledBorder.TOP, null,
				Color.DARK_GRAY));
		panel_2.setBounds(842, 151, 307, 401);
		// frameDayEnd.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 255, 255));
		panel_3.setBorder(new TitledBorder(null, "Declare Cash For Credit Sales", TitledBorder.CENTER, TitledBorder.TOP,
				null, new Color(0, 51, 153)));
		panel_3.setBounds(6, 22, 295, 108);
		panel_2.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Total Amount  Paid");
		lblNewLabel.setBounds(18, 51, 121, 16);
		panel_3.add(lblNewLabel);

		crpaidamount = new JTextField();
		crpaidamount.setBounds(135, 48, 116, 22);
		panel_3.add(crpaidamount);
		crpaidamount.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Enter Here");
		lblNewLabel_3.setBounds(135, 31, 75, 16);
		panel_3.add(lblNewLabel_3);

		rbcash = new JRadioButton("");
		rbcash.setEnabled(false);
		rbcash.setSelected(true);
		rbcash.setBounds(12, 27, 25, 25);
		panel_3.add(rbcash);

		btnshow = new JButton("Show");
		btnshow.setBounds(224, 77, 65, 25);
		ActionListener shw = new LsnrShow();
		btnshow.addActionListener(shw);
		panel_3.add(btnshow);

		JLabel lblNewLabel_6 = new JLabel("Diff. Amount");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(28, 79, 97, 16);
		panel_3.add(lblNewLabel_6);

		diffamt = new JTextField();
		diffamt.setBounds(135, 78, 87, 23);
		panel_3.add(diffamt);
		diffamt.setColumns(10);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(102, 255, 255));
		panel_4.setBorder(new TitledBorder(null, "Total Credit Sales", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		panel_4.setBounds(6, 142, 295, 126);
		panel_2.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Total Sales");
		lblNewLabel_1.setBounds(79, 26, 72, 16);
		panel_4.add(lblNewLabel_1);

		totalcrsales = new JTextField();
		totalcrsales.setBackground(new Color(51, 255, 255));
		totalcrsales.setEditable(false);
		totalcrsales.setBounds(173, 23, 106, 22);
		panel_4.add(totalcrsales);
		totalcrsales.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Amout Paid Against Sales");
		lblNewLabel_2.setBounds(26, 57, 155, 16);
		panel_4.add(lblNewLabel_2);

		paidamount = new JTextField();
		paidamount.setEditable(false);
		paidamount.setBounds(173, 54, 106, 22);
		panel_4.add(paidamount);
		paidamount.setColumns(10);

		rbcashrecorded = new JRadioButton("");
		rbcashrecorded.setEnabled(false);
		rbcashrecorded.setSelected(true);
		rbcashrecorded.setBounds(20, 35, 25, 25);
		panel_4.add(rbcashrecorded);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Credit Sales Break Up", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 51, 153)));
		panel_5.setBounds(6, 276, 295, 96);
		panel_2.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("B2B Sales");
		lblNewLabel_4.setBounds(82, 29, 67, 16);
		panel_5.add(lblNewLabel_4);

		b2bsales = new JTextField();
		b2bsales.setBackground(new Color(51, 255, 255));
		b2bsales.setEditable(false);
		b2bsales.setText("0");
		b2bsales.setBounds(161, 26, 116, 22);
		panel_5.add(b2bsales);
		b2bsales.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("WholeSale Sales");
		lblNewLabel_5.setBounds(50, 57, 99, 16);
		panel_5.add(lblNewLabel_5);

		wsales = new JTextField();
		wsales.setBackground(new Color(51, 255, 255));
		wsales.setEditable(false);
		wsales.setText("0");
		wsales.setBounds(161, 60, 116, 22);
		panel_5.add(wsales);
		wsales.setColumns(10);

		companycode = new JTextField();
		companycode.setBounds(340, 0, 56, 28);
		frameDayEnd.getContentPane().add(companycode);
		companycode.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		companycode.setBackground(Color.WHITE);
		companycode.setEditable(false);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setBounds(397, 0, 310, 28);
		frameDayEnd.getContentPane().add(companyname);
		companyname.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		companyname.setBackground(Color.WHITE);
		companyname.setEditable(false);
		companyname.setColumns(10);

		JLabel lblStore = new JLabel("Store ");
		lblStore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStore.setBounds(705, 6, 56, 22);
		frameDayEnd.getContentPane().add(lblStore);
		lblStore.setFont(new Font("Segoe UI", Font.PLAIN, 11));

		storecode = new JTextField();
		storecode.setBounds(765, 3, 56, 28);
		frameDayEnd.getContentPane().add(storecode);
		storecode.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		storecode.setBackground(Color.WHITE);
		storecode.setEditable(false);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setBounds(822, 3, 327, 28);
		frameDayEnd.getContentPane().add(storename);
		storename.setBackground(Color.WHITE);
		storename.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		storename.setForeground(Color.BLACK);
		storename.setEditable(false);
		storename.setColumns(10);

		JLabel lblDayBeginDate = new JLabel("  Open Date");
		lblDayBeginDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDayBeginDate.setBounds(87, 2, 100, 25);
		frameDayEnd.getContentPane().add(lblDayBeginDate);
		lblDayBeginDate.setFont(new Font("Cambria", Font.BOLD, 15));

		begindate = new JTextField();
		begindate.setForeground(Color.GREEN);
		begindate.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		begindate.setBounds(191, 0, 118, 28);
		frameDayEnd.getContentPane().add(begindate);
		begindate.setBackground(new Color(0, 0, 102));
		begindate.setEditable(false);
		begindate.setColumns(10);

		JLabel creditnote = new JLabel("Credit Note Issue");
		creditnote.setBounds(842, 111, 132, 16);
		frameDayEnd.getContentPane().add(creditnote);
		creditnote.setFont(new Font("SansSerif", Font.BOLD, 14));

		cnamount = new JTextField();
		cnamount.setBounds(981, 104, 128, 31);
		frameDayEnd.getContentPane().add(cnamount);
		cnamount.setFont(new Font("Tahoma", Font.BOLD, 16));
		cnamount.setForeground(Color.DARK_GRAY);
		cnamount.setEditable(false);
		cnamount.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Day End");
		lblNewLabel_7.setBounds(16, 54, 84, 30);
		frameDayEnd.getContentPane().add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));

		JLabel lblNewLabel_8 = new JLabel(" ");
		lblNewLabel_8.setBounds(0, 3, 100, 93);
		frameDayEnd.getContentPane().add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(dayEnd.class.getResource("/RetailProduct/mdf7.jpg")));

		JLabel lblNewLabel_9 = new JLabel(" ");
		lblNewLabel_9.setBackground(Color.WHITE);
		lblNewLabel_9.setIcon(new ImageIcon(dayEnd.class.getResource("/RetailProduct/demologo10.jpg")));
		lblNewLabel_9.setBounds(842, 228, 307, 138);
		frameDayEnd.getContentPane().add(lblNewLabel_9);

		sjsp = new JScrollPane();
		sjsp.setBounds(4, 434, 830, 118);
		frameDayEnd.getContentPane().add(sjsp);
		JViewport prt7 = new JViewport();
		prt7.setToolTipText("Cashier & Shift Wise Sales Recorded For The DAY");
		prt7.add(stable, shiftCol);
		prt7.setVisible(true);
		sjsp.setViewport(prt7);
		
				JPanel panel_6 = new JPanel();
				panel_6.setBounds(846, 147, 494, 68);
				frameDayEnd.getContentPane().add(panel_6);
				panel_6.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)), "Sales Detail",
						TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_6.setBackground(new Color(255, 255, 255));
				panel_6.setLayout(null);
				
						JLabel lblTotalSalesFor = new JLabel("Sales Amount");
						lblTotalSalesFor.setBounds(21, 11, 116, 16);
						panel_6.add(lblTotalSalesFor);
						lblTotalSalesFor.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
						lblTotalSalesFor.setForeground(Color.BLUE);
						
								salesamount = new JTextField();
								salesamount.setToolTipText("Total Sales Amount");
								salesamount.setBounds(21, 28, 116, 40);
								panel_6.add(salesamount);
								salesamount.setBackground(Color.WHITE);
								salesamount.setFont(new Font("Segoe UI", Font.BOLD, 16));
								salesamount.setEditable(false);
								salesamount.setColumns(10);
								
										JLabel lblSalesReturn = new JLabel("Sales Return");
										lblSalesReturn.setBounds(136, 13, 91, 16);
										panel_6.add(lblSalesReturn);
										lblSalesReturn.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
										
												sramount = new JTextField();
												sramount.setToolTipText("Total Sales Return Amount");
												sramount.setBounds(138, 28, 116, 40);
												panel_6.add(sramount);
												sramount.setBackground(Color.WHITE);
												sramount.setFont(new Font("Arial", Font.PLAIN, 17));
												sramount.setEditable(false);
												sramount.setColumns(10);
												
														JLabel lblNetSales = new JLabel("Net Sales");
														lblNetSales.setBounds(256, 11, 91, 16);
														panel_6.add(lblNetSales);
														lblNetSales.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
														lblNetSales.setForeground(Color.DARK_GRAY);
														
																netsales = new JTextField();
																netsales.setToolTipText("Net Sales After Sales Return");
																netsales.setBounds(256, 29, 114, 39);
																panel_6.add(netsales);
																netsales.setFont(new Font("Arial", Font.PLAIN, 17));
																netsales.setBackground(Color.WHITE);
																netsales.setColumns(10);
																
																		JPanel panel_7 = new JPanel();
																		panel_7.setBounds(841, 379, 499, 69);
																		frameDayEnd.getContentPane().add(panel_7);
																		panel_7.setBackground(Color.WHITE);
																		panel_7.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)), "Collection",
																				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
																		panel_7.setLayout(null);
																		
																				JLabel lblTotalCollection = new JLabel("Total Collection");
																				lblTotalCollection.setBounds(12, 13, 104, 16);
																				panel_7.add(lblTotalCollection);
																				lblTotalCollection.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
																				lblTotalCollection.setForeground(Color.DARK_GRAY);
																				
																						tcollection = new JTextField();
																						tcollection.setToolTipText("Total Cash Collection Amount");
																						tcollection.setBounds(13, 29, 116, 39);
																						panel_7.add(tcollection);
																						tcollection.setBackground(Color.WHITE);
																						tcollection.setFont(new Font("Arial", Font.PLAIN, 17));
																						tcollection.setEditable(false);
																						tcollection.setColumns(10);
																						
																								JLabel lblCashReturn = new JLabel("Cash Return ");
																								lblCashReturn.setBounds(128, 13, 103, 16);
																								panel_7.add(lblCashReturn);
																								lblCashReturn.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
																								
																										cashreturn = new JTextField();
																										cashreturn.setToolTipText("Cash Return To Customer (Sales Return With Cash Return)");
																										cashreturn.setBounds(130, 29, 116, 39);
																										panel_7.add(cashreturn);
																										cashreturn.setBackground(Color.WHITE);
																										cashreturn.setFont(new Font("Arial", Font.PLAIN, 17));
																										cashreturn.setEditable(false);
																										cashreturn.setColumns(10);
																										
																												JLabel lblNetCollection = new JLabel("Net Collection");
																												lblNetCollection.setBounds(248, 13, 102, 16);
																												panel_7.add(lblNetCollection);
																												lblNetCollection.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
																												lblNetCollection.setForeground(Color.DARK_GRAY);
																												
																														netcollection = new JTextField();
																														netcollection.setToolTipText("Net Cash Collection Amount");
																														netcollection.setBounds(246, 29, 116, 39);
																														panel_7.add(netcollection);
																														netcollection.setFont(new Font("Segoe UI", Font.BOLD, 16));
																														netcollection.setBackground(Color.WHITE);
																														netcollection.setColumns(10);
 		decorate();
		setStandardData();

	}
	private void decorate() throws Throwable {

		new gnApp().setFrameTitel(frameDayEnd);
  		//frameDayEnd.setUndecorated(true);
		new gnField().closeform(panel_2, frameDayEnd);
		// panel_2.setVisible(false);

	}

 
	class lsnrBtn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String result;
			String result1;
			String result2;

			if (value == "Day End") {
				String vpara = "704";
				String vdeclAllow = " ";
				// String scanDataCheck= "Sucess";
				String scanDataCheck = null;
				try {
					scanDataCheck = ScanDatapostingDone();
				} catch (ClassNotFoundException | SQLException e3) {
					e3.printStackTrace();
				}
				if (scanDataCheck == "Sucess") {
					try {
						vdeclAllow = new getConfigurationSetting().getSpecificConfiguration(vpara);
						// new General().msg("Values "+" "+vdeclAllow);
					} catch (Throwable e2) {
						e2.printStackTrace();
					}
					try {
						result1 = checkDaybegin();
						if (result1 == "Sucess") {
							switch (vdeclAllow) {
							case "Y":
								checkDeclaration();
								break;
							case "N":
								updateDeclaration();
								updateDayend();
								break;
							}
						}
					} catch (SQLException e1) {
						new General().msg(e1.getMessage());
					} catch (ClassNotFoundException e1) {
						new General().msg(e1.getMessage());
					} catch (Throwable e1) {
						new General().msg(e1.getMessage());
					}
				}
			} // DayEnd

		}
	}

	private String ScanDatapostingDone() throws ClassNotFoundException, SQLException {
		String status = "Sucess";
		String vtype = "CheckPosting";
		String varticle = "0";
		String vname = "0";
		String vqty = "0";
		String vrate = "0";
		String vterminal = "0";
		String vuid = new General().getUsercode();
		String vtime = new General().getTime();
		String vdate = new gnConfig().date_ConverttoDBforamt(begindate.getText());
		String SQL = "call scanItem_billData( '" + vtype + "' ,  " + vcomp + " ," + vstore + " , " + varticle + " , '"
				+ vname + "' , '" + vdate + "' , " + vqty + " , " + vrate + " , " + vterminal + " , '" + vuid + "' , '"
				+ vtime + "')";
		rs = this.getSPResult(SQL);

		int row = 0;
		if (rs.next()) {
			row = Integer.parseInt(rs.getString(1));
			if (row > 0) {
				status = "Fail ";
				new General()
						.msg("Scan  Item Data Not Posted  in Sales Module .. Please Complete Sales Process First ... ");
			}
		}
		return status;
	}

	private void checkDeclaration() throws Throwable {
		String result;
		String result1;
		String result2;

		result = checkdecl();
		if (result == "Sucess") {
			result2 = validate();

			if (result2 == "Sucess") {
				new gnDecorate().setBusyCursor(frameDayEnd);
				updateDeclaration();
				updateDayend();
				new gnDecorate().setDefaultCursor(frameDayEnd);

			}
		}
	}

	public void setStandardData() throws Throwable {
 	 	companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		String vcomp = companycode.getText();
		switch (vcomp) {
		case "0":
			new General().msg("No Company Found..");
			System.exit(0);
		}
		storecode.setText(new gnConfig().getStoreID());
		storename.setText(new gnConfig().getStorename(storecode.getText()));
		String vcode = storecode.getText();
		String vdate1 = "";
		begindate.setText(new gnConfig().getDaybeginDate());
		vdate1 = begindate.getText();
		String vstorecode = storecode.getText();
		vcomp = companycode.getText();
		String vdate = new gnConfig().date_ConverttoDBforamt(begindate.getText()); // begindate.getText();
		// String sql = "call day_getallTransaction('"+vdate+"' , "+vcomp+",
		// "+vstorecode+") " ;
		String sql = "call  day_getTransactionforDay( '" + vdate + "' , '" + vdate + "',  " + vcomp + ", " + vstorecode
				+ ") ";
		model.setColumnIdentifiers(Col);
		new gnTableModel().Tablemodel(table, model, sql, Col, 4, "N", "N", "N");
		new gnTable().setTablewidth(table, 0, 150);
		new gnTable().setTablewidth(table, 1, 250);
		new gnTable().setTablewidth(table, 2, 130);
		new gnTable().setTablewidth(table, 3, 130);
		JViewport prt = new JViewport();
		prt.setToolTipText("All Transaction For The DAY");
		prt.add(table, Col);
		prt.setVisible(true);
		jsp.setViewport(prt);

		table.setRowHeight(22);
		new gnFontSetting().setMyFont(stable, "F1", 16);
		
		getDeclarationData();
		String SQLshift = "Call day_getCashierwiseSales(" + vstorecode + " , '" + vdate + "' , " + vcomp + ")";
		smodel.setColumnIdentifiers(shiftCol);
		stable.setBackground(Color.WHITE);
		new gnTableModel().Tablemodel(stable, smodel, SQLshift, shiftCol, 7, "N", "N", "N");
		new gnTable().setTablewidth(table, 0, 130);

		// End ACtual Casher wise shift wise End
		int row = table.getRowCount();
		// new General().msgint(row) ;
		setAmount();
		if (row == 0) {
			new General().msg("No Sales Data Found For The Day.. ");
		}
		// new General().msg("Vdate1 value is "+ vdate1);
		if (vdate1 == "1") {
			begindate.setText(null);
			enddate.setEnabled(false);
			btnDayEnd.setEnabled(false);
		}
		getCRDetails();
 	}

	
	
	class LsnrShow implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				// getCRcollection() ;
			} catch (Throwable e) {
	 			e.printStackTrace();
			}
		}
	}

	private void getCRcollection() throws Throwable {
		vsalesDate = new gnConfig().date_ConverttoDBforamt(begindate.getText());
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL2 = "Call   day_day_cr_getcollection(" + vcomp + " , " + vstore + " , '" + vsalesDate + "')"; // Total
 		rs = this.getSPResult(SQL2);
		if (!rs.next()) {
			paidamount.setText("0.00");
		} else {
			paidamount.setText(rs.getString(1));
		}
		double vdeclamt = Double.parseDouble(crpaidamount.getText());
		double vcollected = Double.parseDouble(paidamount.getText());
		double vdiff = vdeclamt - vcollected;
		if (vdiff < 0.00) {
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			diffamt.setBackground(Color.red);
			diffamt.setForeground(Color.WHITE);
			rbcash.setSelected(false);
		} else {
			diffamt.setText(Double.toString(vdiff));
			diffamt.setBackground(Color.WHITE);
			diffamt.setForeground(Color.BLACK);
			rbcash.setSelected(true);

		}
	}

	private void getCRDetails() throws Throwable {
		vsalesDate = new gnConfig().date_ConverttoDBforamt(begindate.getText());
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();

		String SQL1 = "Call   day_cr_gettotalSales(" + vcomp + " , " + vstore + " , '" + vsalesDate + "')"; // Total
 		String SQL3 = "Call  day_cr_getB2BSales(" + vcomp + " , " + vstore + " , '" + vsalesDate + "')"; // Breakup
 		String SQL4 = "Call  day_cr_getWsaleSales(" + vcomp + " , " + vstore + " , '" + vsalesDate + "')"; // Breakup
 
		// Total Cr Sales
		rs = this.getSPResult(SQL1);
		if (!rs.next()) {
			totalcrsales.setText("0.00");
		} else {
			totalcrsales.setText(rs.getString(1));
		}
		rs.close();
		// End Total Cr Sales

		// Total B2b Sales
		rs = this.getSPResult(SQL3);
		if (!rs.next()) {
			b2bsales.setText("0.00");
		} else {
			b2bsales.setText(rs.getString(1));
		}
		rs.close();

		// Total wsales Sales
		rs = this.getSPResult(SQL4);
		if (!rs.next()) {
			wsales.setText("0.00");
		} else {
			wsales.setText(rs.getString(1));
		}
		rs.close();
	}

	private void getDeclarationData() throws SQLException, ClassNotFoundException {
		// =======Declaration
		String vstorecode = storecode.getText();
		String vcomp = companycode.getText();
		String vtype = "ALL";
		String vuser = "ALL ";
		new gnTable().RemoveTableRows(pmodel);
		String vdate = new gnConfig().date_ConverttoDBforamt(begindate.getText()); // begindate.getText();
		String SQLdecl = "call day_getDeclarationData(    '" + vtype + "' , " + vcomp + " ,    " + vstorecode + " , '"
				+ vdate + "'  , '" + vuser + "')";
		rs = this.getSPResult(SQLdecl);
		pmodel.setColumnIdentifiers(decCol);
		new gnTableModel().Tablemodel(ptable, pmodel, SQLdecl, decCol, 9, "N", "N", "N");
		JViewport prt1 = new JViewport();
		prt1.setToolTipText("Cashier Wise Declaration Data Panel");
		prt1.add(ptable, decCol);
		prt1.setVisible(true);
		pjsp.setViewport(prt1);
		// End Declaration

	}

	public void setAmount() throws SQLException {
		salesamount.setText("0.00");
		sramount.setText("0.00");
		netsales.setText("0.00");
		tcollection.setText("0.00");
		cashreturn.setText("0.00");
		cnamount.setText("0.00");
		netcollection.setText("0.00");
		Double vdeclamt = 0.00;
		int drow = ptable.getRowCount();
		int srow = 3;

		/// For Sales
		Double vsalesamt = Double.parseDouble(table.getValueAt(0, 3).toString());
		Double vsramount = Double.parseDouble(table.getValueAt(1, 3).toString());
		Double vnetamount = vsalesamt + vsramount;
		salesamount.setText(Double.toString(vsalesamt));
		sramount.setText(Double.toString(vsramount));
		netsales.setText(Double.toString(vnetamount));

		// For Payments
		Double vtcollection = Double.parseDouble(table.getValueAt(14, 3).toString());
		Double vcashreturn = Double.parseDouble(table.getValueAt(2, 3).toString());
		Double vcnamount = Double.parseDouble(table.getValueAt(5, 3).toString());
		Double vnetcollection = vtcollection + vcashreturn;// - vcnamount ;

		tcollection.setText(Double.toString(vtcollection));
		cashreturn.setText(Double.toString(vcashreturn));
		cnamount.setText(Double.toString(vcnamount));
		netcollection.setText(Double.toString(vnetcollection));

		for (int i = 0; i < drow; i++) {
			vdeclamt = vdeclamt + Double.parseDouble(ptable.getValueAt(i, 4).toString());
		}
		salesamount.setText(Double.toString(vsalesamt));
	}

	public String checkDaybegin() {
		String vresult = "Sucess";
		String vvdate = begindate.getText();
		switch (vvdate) {
		case "1":
			vresult = "Fail";
			new General().msg(" Complete Day Begin first ...");
			break;
		}
		return vresult;
	}

	public String checkdecl() throws SQLException, ClassNotFoundException {
		String result = "Sucess";
		String vvdate = new gnConfig().date_ConverttoDBforamt(begindate.getText());
		String vvstore = storecode.getText();
		String vcomp = companycode.getText();
		String SQL1 = "call  day_checkDeclaration(" + vvstore + " ,  '" + vvdate + "' , " + vcomp + ")";
		rs = this.getSPResult(SQL1);
		rs.next();
		String flag = rs.getString(1);
		switch (flag) {
		case "N":
			new General().msg("Declaration is not done ..Complete Declaration first");
			result = "Fail";
			break;
		}
		return result;
	}

	public String validate() throws SQLException, ClassNotFoundException {
		//
		String result = "Sucess";
		String vvdate = new gnConfig().date_ConverttoDBforamt(begindate.getText());
		String vvstore = storecode.getText();
		String vcomp = companycode.getText();
		String SQL = "call day_DeclnotdoneforShift(" + vvstore + " , '" + vvdate + "' ," + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			new General().msg(
					"Declaration for Cashier  " + rs.getString(4) + " and Shift  " + rs.getString(5) + " Is not done");
			result = "Fail";
		}
		return result;
	}

	public void updateDayend() throws Throwable {

		enddate.setText(new gnConfig().getDaybeginDate());
		enddate.setEnabled(false);
		btnDayEnd.setEnabled(false);
		table.setEnabled(false);
		ptable.setEnabled(false);
		table.setBackground(Color.CYAN);
		ptable.setBackground(Color.CYAN);
		String vvdate = new gnConfig().date_ConverttoDBforamt(enddate.getText());
		String vvstore = storecode.getText();
		String vcomp = companycode.getText();
		String SQL2 = "call  day_updateDayend(" + vvstore + " ,  '" + vvdate + "' , " + vcomp + ")";
		// new General().msg(SQL2);
		this.getSPResult(SQL2);
		new gnTable().RemoveTableRows(model);
		new gnTable().RemoveTableRows(pmodel);
		new gnTable().RemoveTableRows(smodel);
		salesamount.setText("0.00");
		sramount.setText("0.00");
		netsales.setText("0.00");
		tcollection.setText("0.00");
		cashreturn.setText("0.00");
		cnamount.setText("0.00");
		netcollection.setText("0.00");
		// Damount.setText("0.00");

		// captureclosingStockVale();
		new BackupDB().TakeBackup(new gnApplicationSetting().DatabaseBackupPath);
		new General().Quickmsg("Day Closed Sucessfully...");

		btnCancel.doClick();

	}

	private void captureclosingStockVale() throws ClassNotFoundException, SQLException {
		String vvdate = new gnConfig().date_ConverttoDBforamt(begindate.getText());
		vstore = storecode.getText();
		String vcomp = companycode.getText();
		String SQL = "Call stock_dailyclStock( " + vcomp + ", " + vstore + " ,  '" + vvdate + "' )";
		this.getSPResult(SQL);
	}

	public void updateDeclaration() throws SQLException, ClassNotFoundException {
		String vvdate = new gnConfig().date_ConverttoDBforamt(begindate.getText());
		String vvstore = storecode.getText();
		String SQL1 = "call  day_updateDeclaration(" + vvstore + " ,  '" + vvdate + "')";
		this.getSPResult(SQL1);
	}
}// last

package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JSlider;

public class viewCustomer extends getResultSet {

	JFrame CustomerviewFrame;
	JPanel panel;
	private String vcomp;
	JPanel panelItemSearch;
	JRadioButton rb716;
	private String vstore;
	private JTextField storecode;
	private JTextField storename;
	private JTextField code;
	JRadioButton rb101;
	JRadioButton rb105;
	JRadioButton rb102;
	JRadioButton rb103;
	String vcode;
	private JTextField name;
	private JTextField phone;
	JRadioButton rb12;
	JRadioButton rb11;
	String vfinyear;
	private JTextField fromdate;
	private JTextField todate;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField searchcode;
	private JTextField searchname;
	private JRadioButton rbgrn;
	private JRadioButton rbsubgroup;
	private JRadioButton rbbrand;
	private JButton btnShow;
	private JRadioButton rbdue;
	private JRadioButton rbdueinv;
	private JRadioButton rbpayment;
	private JScrollPane jsp;
	private JButton btnExport;

	private String vendor;
	private String SQL;
	private String vfromdate;
	private String vtodate;
	private JPanel panel_5;
	JPanel panel_3;

	DefaultTableModel model = new DefaultTableModel();
	public JTable table = new JTable();
	private JLabel lblNewLabel_7;
	private JTextField Amount;
	private JTextField records;
	private JLabel lblNewLabel_8;
	private JRadioButton rbpmode;
	private JRadioButton rbgroup;
	private JRadioButton rbcategory;
	private JRadioButton rbsubcat;
	JPanel panel_4;
	private JTextField finyear;
	private JButton btnClose;
	private JTextField searchItemName;
	private JTextField searchitemcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewCustomer window = new viewCustomer();
					window.CustomerviewFrame.setVisible(true);
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
	public viewCustomer() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		CustomerviewFrame = new JFrame();
		CustomerviewFrame.getContentPane().setBackground(Color.CYAN);
		CustomerviewFrame.setResizable(false);
		CustomerviewFrame.setAlwaysOnTop(true);
		CustomerviewFrame.setBounds(10, 10, 1350, 720);
		CustomerviewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CustomerviewFrame.getContentPane().setLayout(null);
		ActionListener rb = new RbLsnr();
		ActionListener dt1 = new fromdateLsnr();
		ActionListener dt2 = new todateLsnr();

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(1, 7, 1, 1, (Color) new Color(102, 51, 153)));
		panel.setBounds(1, 0, 1260, 146);
		CustomerviewFrame.getContentPane().add(panel);
		panel.setLayout(null);

		storecode = new JTextField();
		storecode.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		storecode.setBackground(Color.CYAN);
		storecode.setEditable(false);
		storecode.setBounds(200, 0, 76, 28);
		panel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		storename.setBackground(Color.CYAN);
		storename.setBounds(274, 0, 320, 28);
		panel.add(storename);
		storename.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new MatteBorder(2, 0, 0, 0, (Color) Color.GREEN));
		panel_1.setBounds(190, 33, 723, 39);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Customer");
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 14));
		lblNewLabel_2.setBounds(23, 17, 66, 16);
		panel_1.add(lblNewLabel_2);

		code = new JTextField();
		code.setBackground(Color.WHITE);
		code.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		code.setBounds(90, 10, 78, 30);
		panel_1.add(code);
		code.setColumns(10);

		name = new JTextField();
		name.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		name.setBounds(168, 10, 300, 30);
		panel_1.add(name);
		name.setColumns(10);
		ActionListener supl = new suplLsnr();
		name.addActionListener(supl);

		JLabel lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_3.setBounds(488, 16, 47, 16);
		panel_1.add(lblNewLabel_3);

		phone = new JTextField();
		phone.setFont(new Font("Cambria", Font.BOLD, 14));
		phone.setEditable(false);
		phone.setBackground(Color.WHITE);
		phone.setBounds(537, 7, 174, 30);
		panel_1.add(phone);
		phone.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Fin Year");
		lblNewLabel_9.setFont(new Font("Cambria", Font.BOLD, 14));
		lblNewLabel_9.setBounds(599, 10, 55, 16);
		panel.add(lblNewLabel_9);

		finyear = new JTextField();
		finyear.setBackground(Color.CYAN);
		finyear.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		finyear.setBounds(655, 4, 96, 28);
		panel.add(finyear);
		finyear.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(200, 73, 1048, 73);
		panel.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new MatteBorder(2, 3, 0, 0, (Color) new Color(51, 204, 204)),
				"Select Period", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_2.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("From");
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(44, 13, 55, 16);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("To");
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(157, 13, 20, 16);
		panel_2.add(lblNewLabel_5);

		fromdate = new JTextField();
		fromdate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		fromdate.setBounds(43, 32, 96, 30);
		panel_2.add(fromdate);
		fromdate.setColumns(10);

		todate = new JTextField();
		todate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		todate.setBounds(152, 32, 95, 30);
		panel_2.add(todate);
		todate.setColumns(10);

		panelItemSearch = new JPanel();
		panelItemSearch.setBounds(259, 13, 232, 60);
		panel_2.add(panelItemSearch);
		panelItemSearch.setBorder(
				new TitledBorder(null, "Search Item Here", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelItemSearch.setLayout(null);

		searchItemName = new JTextField();
		searchItemName.setBounds(12, 25, 216, 22);
		panelItemSearch.add(searchItemName);
		searchItemName.setColumns(10);

		searchitemcode = new JTextField();
		searchitemcode.setEnabled(false);
		searchitemcode.setBounds(132, 0, 96, 22);
		panelItemSearch.add(searchitemcode);
		searchitemcode.setColumns(10);

		lblNewLabel_7 = new JLabel("Records");
		lblNewLabel_7.setBounds(527, 11, 55, 16);
		panel_2.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_7.setForeground(Color.BLACK);

		lblNewLabel_8 = new JLabel("Amount");
		lblNewLabel_8.setBounds(623, 13, 145, 16);
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_8.setForeground(Color.BLACK);

		// records = new JTextField();
		records = new gnRoundTextField(20);

		records.setFont(new Font("Arial", Font.BOLD, 13));
		records.setBounds(527, 34, 84, 26);
		panel_2.add(records);
		records.setColumns(10);

		// Amount = new JTextField();
		Amount = new gnRoundTextField(20);

		Amount.setFont(new Font("Arial", Font.BOLD, 13));
		Amount.setBounds(626, 34, 142, 26);
		panel_2.add(Amount);
		Amount.setColumns(10);

		btnExport = new JButton("Export To Excel");
		btnExport.setBounds(780, 29, 147, 31);
		panel_2.add(btnExport);
		btnExport.setMnemonic('E');
		btnExport.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));

		btnClose = new JButton("Close");
		btnClose.setBounds(928, 29, 108, 31);
		panel_2.add(btnClose);
		btnClose.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		btnClose.setIcon(new ImageIcon(viewCustomer.class.getResource("/RetailProduct/delete.png")));
		btnClose.setMnemonic('C');

		JLabel lblNewLabel_10 = new JLabel("Customer Data");
		lblNewLabel_10.setBounds(33, 44, 126, 39);
		panel.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNewLabel_10.setForeground(Color.BLACK);

		JLabel lblNewLabel_11 = new JLabel(" ");
		lblNewLabel_11.setBounds(22, 10, 132, 110);
		panel.add(lblNewLabel_11);
		lblNewLabel_11.setIcon(new ImageIcon(viewCustomer.class.getResource("/RetailProduct/mdf7.jpg")));

		panel_5 = new JPanel();
		panel_5.setBounds(925, 33, 313, 41);
		panel.add(panel_5);
		panel_5.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(153, 153, 153), new Color(0, 0, 102)));
		panel_5.setLayout(null);

		btnShow = new JButton("Show Data");
		btnShow.setBounds(195, 6, 113, 28);
		panel_5.add(btnShow);
		btnShow.setMnemonic('S');

		searchname = new JTextField();
		searchname.setBounds(100, 6, 97, 28);
		panel_5.add(searchname);
		searchname.setColumns(10);

		searchcode = new JTextField();
		searchcode.setBounds(48, 6, 55, 28);
		panel_5.add(searchcode);
		searchcode.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Select ");
		lblNewLabel_6.setBounds(6, 12, 55, 16);
		panel_5.add(lblNewLabel_6);

		fromdate.addActionListener(dt1);
		todate.addActionListener(dt2);

		panel_4 = new JPanel();
		panel_4.setForeground(new Color(0, 0, 51));
		panel_4.setBackground(new Color(253, 245, 230));
		panel_4.setBounds(6, 149, 1092, 311);
		// CustomerviewFrame.getContentPane().add(panel_4);
		panel_4.setBorder(new TitledBorder(new MatteBorder(3, 2, 3, 2, (Color) new Color(0, 0, 0)), "Customer Sales",
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.DARK_GRAY));

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(246, 149, 1092, 405);
		// CustomerviewFrame.getContentPane().add(jsp);

		JSplitPane mySplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel_4, jsp);
		mySplit.setBounds(1, 148, 1350, 539);
		mySplit.setDividerLocation(200);
		mySplit.setContinuousLayout(true);
		mySplit.setEnabled(false);
		CustomerviewFrame.getContentPane().add(mySplit);

		rbbrand = new JRadioButton("Brand");
		rbbrand.setBackground(Color.WHITE);
		rbbrand.setBounds(25, 57, 149, 18);
		rbbrand.setMnemonic('B');
		buttonGroup.add(rbbrand);
		rbbrand.setForeground(new Color(0, 0, 51));
		rbbrand.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		rbbrand.addActionListener(rb);
		panel_4.setLayout(null);
		panel_4.add(rbbrand);

		rbsubgroup = new JRadioButton("Sub Group");
		rbsubgroup.setBackground(Color.WHITE);
		rbsubgroup.setBounds(25, 149, 149, 18);
		buttonGroup.add(rbsubgroup);
		rbsubgroup.setMnemonic('U');
		rbsubgroup.setForeground(new Color(0, 0, 51));
		rbsubgroup.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		rbsubgroup.addActionListener(rb);
		panel_4.add(rbsubgroup);

		rbgrn = new JRadioButton("Invoice");
		rbgrn.setBackground(Color.WHITE);
		rbgrn.setBounds(25, 172, 149, 18);
		buttonGroup.add(rbgrn);
		rbgrn.setMnemonic('I');
		rbgrn.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		rbgrn.setForeground(new Color(0, 0, 51));
		rbgrn.addActionListener(rb);
		panel_4.add(rbgrn);

		rbgroup = new JRadioButton("Group");
		rbgroup.setBackground(Color.WHITE);
		rbgroup.setBounds(25, 126, 149, 18);
		rbgroup.setMnemonic('G');
		rbgroup.setForeground(new Color(0, 0, 51));
		rbgroup.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		buttonGroup.add(rbgroup);
		rbgroup.addActionListener(rb);
		panel_4.add(rbgroup);

		rbcategory = new JRadioButton("Category");
		rbcategory.setBackground(Color.WHITE);
		rbcategory.setBounds(25, 80, 149, 18);
		rbcategory.setMnemonic('T');
		buttonGroup.add(rbcategory);
		rbcategory.setForeground(Color.GRAY);
		rbcategory.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		rbcategory.addActionListener(rb);
		panel_4.add(rbcategory);

		rbsubcat = new JRadioButton("SubCatwise");
		rbsubcat.setBackground(Color.WHITE);
		rbsubcat.setBounds(25, 103, 149, 18);
		rbsubcat.setMnemonic('S');
		buttonGroup.add(rbsubcat);
		rbsubcat.setForeground(new Color(0, 0, 51));
		rbsubcat.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		rbsubcat.addActionListener(rb);
		panel_4.add(rbsubcat);

		panel_3 = new JPanel();
		panel_3.setBounds(0, 400, 199, 124);
		panel_3.setBackground(new Color(253, 245, 230));
		panel_4.add(panel_3);
		panel_3.setBorder(new TitledBorder(null, "Customer Payment", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 153)));
		panel_3.setLayout(null);

		rbdue = new JRadioButton("Customer Due Payments");
		rbdue.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		buttonGroup.add(rbdue);
		rbdue.setForeground(new Color(0, 0, 51));
		rbdue.setBounds(29, 27, 171, 18);
		rbdue.addActionListener(rb);
		panel_3.add(rbdue);

		rbpayment = new JRadioButton("Paid Invoice");
		rbpayment.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		buttonGroup.add(rbpayment);
		rbpayment.setForeground(new Color(0, 0, 51));
		rbpayment.setBounds(29, 57, 157, 18);
		rbpayment.addActionListener(rb);
		panel_3.add(rbpayment);

		rbpmode = new JRadioButton("Payment Details");
		rbpmode.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 13));
		buttonGroup.add(rbpmode);
		rbpmode.setBounds(29, 92, 157, 18);
		rbpmode.addActionListener(rb);
		panel_3.add(rbpmode);

		rb11 = new JRadioButton("Customer Purchase");
		rb11.setBackground(Color.WHITE);
		rb11.setBounds(25, 26, 166, 18);
		rb11.setMnemonic('C');
		buttonGroup.add(rb11);
		rb11.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		rb11.setForeground(new Color(0, 0, 51));
		rb11.addActionListener(rb);
		panel_4.add(rb11);

		rb101 = new JRadioButton("Month Wise");
		rb101.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		rb101.setBackground(Color.WHITE);
		rb101.setBounds(25, 200, 149, 25);
		buttonGroup.add(rb101);
		rb101.setForeground(new Color(0, 0, 51));
		panel_4.add(rb101);

		rb102 = new JRadioButton("Date Wise Summary");
		rb102.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		rb102.setBackground(Color.WHITE);
		rb102.setBounds(25, 229, 166, 25);
		buttonGroup.add(rb102);
		rb102.setForeground(new Color(0, 0, 51));
		panel_4.add(rb102);

		rb103 = new JRadioButton("Detail View");
		rb103.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		rb103.setBackground(Color.WHITE);
		rb103.setBounds(25, 257, 149, 25);
		buttonGroup.add(rb103);
		rb103.setForeground(new Color(0, 0, 51));
		panel_4.add(rb103);

		rb12 = new JRadioButton("Receipts");
		rb12.setBackground(Color.WHITE);
		rb12.setBounds(25, 287, 149, 25);
		panel_4.add(rb12);
		buttonGroup.add(rb12);
		rb12.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		rb12.setForeground(new Color(0, 0, 51));

		rb105 = new JRadioButton("Article/Items");
		rb105.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		rb105.setBackground(Color.WHITE);
		rb105.setBounds(25, 317, 149, 25);
		buttonGroup.add(rb105);
		rb105.setForeground(new Color(0, 0, 51));
		panel_4.add(rb105);

		rb716 = new JRadioButton("Check Bills For Article");
		rb716.setBackground(Color.WHITE);
		rb716.setBounds(25, 347, 166, 25);
		buttonGroup.add(rb716);
		rb716.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		rb716.setForeground(new Color(0, 0, 51));
		panel_4.add(rb716);

		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon(viewCustomer.class.getResource("/RetailProduct/graphics4.png")));
		lblNewLabel.setBounds(1258, 0, 93, 146);
		CustomerviewFrame.getContentPane().add(lblNewLabel);
		rb12.addActionListener(rb);

		rb101.addActionListener(rb);
		rb102.addActionListener(rb);
		rb103.addActionListener(rb);
		rb105.addActionListener(rb);
		rb716.addActionListener(rb);

		ActionListener btn = new btnLsnr();
		ActionListener itmnamels = new itemSearchLs();
		searchItemName.addActionListener(itmnamels);
		btnClose.addActionListener(btn);
		btnExport.addActionListener(btn);
		decorate();
	}

	class itemSearchLs implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String sname = searchItemName.getText();
			sname = "%" + sname + "%";
			try {
				new gnAdmin().articleNameSearch(sname, searchitemcode, searchItemName);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				try {
					showIteminbills();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void showIteminbills() throws Throwable {
		String vverticle = new gnHierarchy().getVerticleCode();
		String vcode = searchitemcode.getText();
		String vtype = "CheckItemInBills";
		String vcustomer = code.getText();
		int colno = 0;
		int colsum = 0;
		vfromdate = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
		vtodate = new gnConfig().date_ConverttoDBforamt(todate.getText());
		String Colmain[] = { "Type", "Date", "Bill.No", "Gross ", "Discount", "Net Amount" };
		SQL = "Call    view_CustomerView1('" + vtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
				+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
		colno = 5;
		colsum = 5;
		showTableData(SQL, Colmain, vtype, colno, colsum);
		panelItemSearch.setVisible(false);
		searchitemcode.setText("");
		searchItemName.setText(null);

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

	private void decorate() throws Throwable {
		panelItemSearch.setVisible(false);

		panel_3.setVisible(false);
		new gnStyleButton().getStyleButton(btnExport, Color.blue, Color.WHITE);
		new gnStyleButton().getStyleButton(btnClose, Color.blue, Color.WHITE);

		new gnApp().setFrameTitel(CustomerviewFrame);
		new gnField().closeform(panel, CustomerviewFrame);
		new gnDecorate().DispField_Eatch(code, 16);
		new gnDecorate().DispField_Eatch(name, 16);
		new gnDecorate().DispField_Eatch(searchcode, 16);
		new gnDecorate().DispField_Eatch(searchname, 16);
		new gnDecorate().DispField_Eatch(fromdate, 16);
		new gnDecorate().DispField_Eatch(todate, 16);
		new gnDecorate().DispField_Eatch(storecode, 16);
		new gnDecorate().DispField_Eatch(storename, 16);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		storecode.setText(vstore);
		storename.setText(new gnConfig().getStorename(vstore));
		panel_5.setVisible(false);
		finyear.setText(new gnFinYear().getReportingFinYear());
		vfinyear = finyear.getText();
		fromdate.setText(new gnFinYear().getFirstDateofFinYear());
		todate.setText(new gnFinYear().getLastDateofFinYear());
		vfromdate = fromdate.getText();
		vtodate = todate.getText();
		showallCustomer();
	}

	private void showallCustomer() throws Throwable {
		// ActionForChoice(vcho) ;
		String vtype = "CustomerALL";
		vfromdate = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
		vtodate = new gnConfig().date_ConverttoDBforamt(todate.getText());
		String vverticle = new gnHierarchy().getVerticleCode();
		vendor = "0";
		String vcode = "0";
		SQL = "call view_CustomerView1('" + vtype + "' ,  " + vcomp + ", " + vstore + ",  '" + vfromdate + "'  , '"
				+ vtodate + "' , " + vverticle + ", " + vcode + ", " + vendor + ")";
		// new General().msg(SQL);
		String saleswithSR[] = { "Type", "Code", "Name", "Qty", "Gross", "Discount", "Amount", "SR.Qty", "SR.Amt",
				"Net Qty", "Net Sales", "RGM", "Margin" };
		int colno = 12;
		int colsum = 12;
		showTableData(SQL, saleswithSR, vtype, colno, colsum);

	}

	class suplLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String vname = name.getText();
			vname = "%" + vname + "%";
			try {
				new gnSupplier().getCustomer(vname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				code.setText(new gnSupplier().rcustcode);
				name.setText(new gnSupplier().rcustName);
				phone.setText(new gnSupplier().rPhone);
			}
		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Close") {
				CustomerviewFrame.dispose();
			}

			if (value == "Export To Excel") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

		}
	}

	class RbLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String choice = e.getActionCommand();
			try {
				ActionForChoice(choice);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public String validate() {
		String status = "Sucess";

		if (code.getText().length() == 0) {
			status = "Fail";
			new General().msg("Select Customer  Code  ..");
			name.grabFocus();

		}
		if (fromdate.getText().length() == 0) {
			status = "Fail";
			new General().msg("Select Dates ..");
		}
		if (todate.getText().length() == 0) {
			status = "Fail";
			new General().msg("Select Dates ..");

		}

		return status;
	}

	private void ActionForChoice(String choice) throws Throwable {
		String status = validate();
		if (status == "Sucess") {
			vendor = code.getText();
			vfromdate = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
			vtodate = new gnConfig().date_ConverttoDBforamt(todate.getText());
			String vtype = " ";
			String vtrtype = "PUR";
			String Col[] = { "Name", "Grnno", "GrnDate", "Amount", "Suppl. Inv.No", "Suppl. Inv.date", "Cr.Days",
					"Due Date", "Type", "PO" };

			String Col1[] = { "Name", "Grnno", "GrnDate", "Amount", "Suppl. Inv.No", "Suppl. Inv.date", "Cr.Days",
					"Due Date", "Payment No", "Payment Date" };

			String Col2[] = { "Name", "Payment No", "Payment Date", "Sr.No", "Payment Menthod", "Chq/DD NO",
					"Chq/DD Date", "Total Amount", "Paid Amount", "Bank", "Type" };

			String Col3[] = { "Type", "Name", "Inv.no", "Inv.Date", "Time", "Cashier", " Sales Type", "Gross",
					"Discount", "Net Amount" };
			// String Col4[] = { "Company" , "Branch" , "Date" , "Code" , "Name"
			// , "Sales Amount" , "Pur.Cost" , "RGM" , "Margin"} ;
			// new General().msg(choice);
			String supl[] = { "Type", "Customer", "Name", "Gross", "Discount", "SaleAmount", "SR.Amt", "NetSalesAmt" };
			String Col4[] = { "Date", "Code", "Name", "Total Amount" };
			String Col8[] = { "Party", "Doctype", "Doc.No", "Doc Date", "Amount", "Payment Type", "Instrument No",
					"Instr.Date" };
			// String ColBrand[] = { "Code" , "Name" , "Total Amount" };
			String ColBrand[] = { "Type", "Code", "Name", "Qty", "Gross", "Discount", "Net  Amount" };

			String vcode = "0";
			String vcustomer = code.getText();
			vtype = "";
			String vvendor = "0";
			vfromdate = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
			vtodate = new gnConfig().date_ConverttoDBforamt(todate.getText());
			String vverticle = new gnHierarchy().getVerticleCode();

			String Colmain[] = { "Type", "Code", "Name", "Gross", "Qty", "Disc", "Sales Amt.", "Purchase Amt", "SR.Qty",
					"SR.Value", "Net Sales Qty", "Net Sales Amt", "RGM", "Margin" };
			int colno = 0;
			int colsum = 0;

			switch (choice) {
			case "Check Bills For Article":
				panelItemSearch.setVisible(true);
				searchItemName.grabFocus();
				break;

			case "Article/Items":
				vtype = "Article";
				String Col45[] = { "Type", "Article Code", "Name", "Qty", "Gross Amount", "Manual Disc", "Promo Disc",
						"Net Amount", "Purchase Cost", "SR Qty", "SR Amt", "NetQty", "Net Sale", "RGM", "Margin%",
						"Shelf", "Current Stock", "MBQ" };
				SQL = "Call    view_CustomerView1('" + vtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
						+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
				int ColNo = 17;
				colsum = 12;
				showTableData(SQL, Col45, vtype, ColNo, colsum);
				break;

			case "Brand":
				vtype = "Brand";
				SQL = "Call    view_CustomerView1('" + vtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
						+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
				colno = 13;
				colsum = 11;
				showTableData(SQL, Colmain, vtype, colno, colsum);
				break;

			case "Category":
				vtype = "Category";
				SQL = "Call    view_CustomerView1('" + vtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
						+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
				colno = 13;
				colsum = 11;
				showTableData(SQL, Colmain, vtype, colno, colsum);

				break;

			case "SubCatwise":
				vtype = "Subcategory";
				SQL = "Call    view_CustomerView1('" + vtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
						+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
				colno = 13;
				colsum = 11;
				showTableData(SQL, Colmain, vtype, colno, colsum);
				break;

			case "Group":
				vtype = "Group";
				SQL = "Call    view_CustomerView1('" + vtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
						+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
				colno = 13;
				colsum = 11;
				showTableData(SQL, Colmain, vtype, colno, colsum);
				break;

			case "Sub Group":
				vtype = "SubGroup";
				SQL = "Call    view_CustomerView1('" + vtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
						+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
				colno = 13;
				colsum = 11;
				showTableData(SQL, Colmain, vtype, colno, colsum);
				break;

			case "Invoice":
				vtype = "Invoice";
				SQL = "call   view_SalesInvoices(" + vcomp + ", " + vstore + ", '" + vfromdate + "'  , '" + vtodate
						+ "' ,  " + vendor + ")";
				colno = 9;
				colsum = 9;
				showTableData(SQL, Col3, vtype, colno, colsum);
				break;

			case "Receipts":
				SQL = "call view_CustomerView('" + vtype + "' ,  " + vcomp + ", " + vstore + ", '" + vendor + "'  , '"
						+ vfromdate + "'  , '" + vtodate + "' )";
				vtype = "Receipts";
				colno = 5;
				colsum = 5;
				showTableData(SQL, Col8, vtype, colno, colsum);
				break;

			// nitinhere new addtit
			case "Month Wise":
				String vmycol[] = { "Type ", "Month", "MonthName", "Qty ", "Gross", "Discount", "Net Amount", "SR.Qty",
						"SR.Amt", "Net Qty", "Net Sales Amt" };
				vtype = "MonthWiseForcustomer";
				SQL = "Call    view_CustomerView1('" + vtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
						+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
				vtype = "MonthWise";
				colno = 10;
				colsum = 10;
				showTableData(SQL, vmycol, vtype, colno, colsum);
				break;

			case "Date Wise Summary":
				vtype = "DatehWisesummary";
				String vmycol1[] = { "Type ", "Inv.Date", "Qty ", "Gross", "Discount", "Net Amount", "SRQty", "SRAmt",
						"NetQty", "NetSalesAmt" };
				SQL = "Call    view_CustomerView1('" + vtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
						+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
				colno = 9;
				colsum = 9;
				showTableData(SQL, vmycol1, vtype, colno, colsum);
				break;

			case "Detail View":
				vtype = "DetailView";
				String vmycol11[] = { "Type ", "Inv.Date", "Inv.No", "Article", "Name", "Qty ", "Gross", "Discount",
						"Net Amount" };
				SQL = "Call    view_CustomerView1('" + vtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
						+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
				vtype = "DetailView";
				colno = 8;
				colsum = 8;
				showTableData(SQL, vmycol11, vtype, colno, colsum);

				// above new addition

			}
		}
	}

	private void showTableData(String SQL, String Col[], String vtype, int vcolno, int colforsum) throws Throwable {
		// new General().msg(SQL);
		// new General().msg(vtype);

		String vstatus = new gnFinYear().checkDateRanegforFinyear(fromdate.getText(), todate.getText());
		if (vstatus == "Sucess") {
			new gnTable().RemoveTableRows(model);
			rs = this.getSPResult(SQL);
			((DefaultTableModel) model).setColumnIdentifiers(Col);
			table.setModel(model);

			table = new gnTableModel().Tablemodel(table, model, SQL, Col, vcolno, "N", "Y", vtype);
			Amount.setText(Double.toString(new gnTable().getTotal(table, colforsum)));
			String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
			records.setText(RecordCount1);
			table.setCellSelectionEnabled(true);
			table.setRowSelectionAllowed(true);
			table.setGridColor(Color.green);
			table.setBackground(Color.white);
			table.setForeground(Color.BLUE);
			JViewport prt = new JViewport();
			prt.setBackground(new Color(104, 255, 255));
			prt.add(table, Col);
			prt.setVisible(true);
			jsp.setViewport(prt);
			new gnTable().setFontBold(table, 11);
			if (table.getRowCount() > 0) {
				Selectrow();
			}
		}
	}// End Show Table

	public void Selectrow() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.requestFocus();
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				// new General().msg(value);
				try {
					display(row, value);
					// new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
			}
		});
	}

	private void display(int row, String value) throws Throwable {
		String vmonthno = "0";
		String vvtype = "";
		String SQL2 = " ";
		int ColNo = 0;
		String vcustomer = code.getText();
		String vtype = "";
		String vvendor = "0";
		vfromdate = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
		vtodate = new gnConfig().date_ConverttoDBforamt(todate.getText());
		String vverticle = new gnHierarchy().getVerticleCode();
		switch (value) {
		//
		case "CheckItemInBills":
			row = table.getSelectedRow();
			String vdocdate = table.getValueAt(row, 1).toString();
			String vdocno = table.getValueAt(row, 2).toString();
			new gnEdit().showSales(vdocno, vdocdate);
			break;

		case "Brand":
			vvtype = "BrandItems";
			vcode = table.getValueAt(row, 1).toString();
			SQL2 = "Call    view_CustomerView1('" + vvtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
			String Col71[] = { "Type", "Article", "Name", "Qty", "Gross", "Disc", "Sales", "Purchase", "RGM", "Margin",
					"SR.Qty", "SR.Value", "Net Sales Value", "RGM", "Margin", "Shelf", "Stock", "MBQ" };
			ColNo = 17;
			vtype = "BrandItems";
			try {
				showView(SQL2, Col71, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "Category":
			vvtype = "CategoryItems";
			vcode = table.getValueAt(row, 1).toString();
			SQL2 = "Call    view_CustomerView1('" + vvtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
			String Col72[] = { "Type", "Article", "Name", "Qty", "Gross", "Disc", "Sales", "Purchase", "RGM", "Margin",
					"SR.Qty", "SR.Value", "Net Sales Value", "RGM", "Margin", "Shelf", "Stock", "MBQ", "" };
			ColNo = 17;
			vtype = "CategoryItems";
			try {
				showView(SQL2, Col72, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "SubCategory":
			vvtype = "SubCategoryItems";
			vcode = table.getValueAt(row, 1).toString();
			SQL2 = "Call    view_CustomerView1('" + vvtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
			String Col73[] = { "Type", "Article", "Name", "Qty", "Gross", "Disc", "Sales", "Purchase", "RGM", "Margin",
					"SR.Qty", "SR.Value", "Net Sales Value", "RGM", "Margin", "Shelf", "Stock", "MBQ", "" };
			ColNo = 17;
			vtype = "SubcatItems";
			try {
				showView(SQL2, Col73, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "Group":
			vvtype = "GroupItems";
			vcode = table.getValueAt(row, 1).toString();
			SQL2 = "Call    view_CustomerView1('" + vvtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
			String Col74[] = { "Type", "Article", "Name", "Qty", "Gross", "Disc", "Sales", "Purchase", "RGM", "Margin",
					"SR.Qty", "SR.Value", "Net Sales Value", "RGM", "Margin", "Shelf", "Stock", "MBQ" };
			ColNo = 17;

			vtype = "GroupItems";
			try {
				showView(SQL2, Col74, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "SubGroup":
			vvtype = "SubGroupItems";
			vcode = table.getValueAt(row, 1).toString();
			SQL2 = "Call    view_CustomerView1('" + vvtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + " , " + vcode + " , " + vcustomer + ")";
			String Col75[] = { "Type", "Article", "Name", "Qty", "Gross", "Disc", "Sales", "Purchase", "RGM", "Margin",
					"SR.Qty", "SR.Value", "Net Sales Value", "RGM", "Margin", "Shelf", "Stock", "MBQ" };
			ColNo = 17;
			vtype = "SubGroupItems";
			try {
				showView(SQL2, Col75, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		//
		case "CustomerALL":
			vendor = table.getValueAt(row, 1).toString();
			vvtype = "MonthForAll";
			SQL2 = "Call   view_CustomerView1('" + vvtype + "', " + vcomp + "," + vstore + ", '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + " , " + vmonthno + " ,  " + vendor + ")";
			// new General().msg(SQL2);
			String Col1[] = { "Type", "Month", "Month Name", "Qty", "Gross", "Disc", "Amount", "SR.Qty", "SR.Amt",
					"NetQty", "NetSales.Amt", "RGM", "Margin" };
			ColNo = 12;
			vtype = "Month";
			try {
				showView(SQL2, Col1, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "Month":
			vvtype = "MonthDates";
			vmonthno = table.getValueAt(row, 1).toString();
			SQL2 = "Call   view_CustomerView1('" + vvtype + "', " + vcomp + "," + vstore + ",  '" + vfromdate + "' ,'"
					+ vtodate + "' , " + vverticle + " , " + vmonthno + " ,  " + vendor + ")";
			String Col2[] = { "Type", "Date", "Qty", "Gross", "Disc", "Sales", "SR.Qty", "SR. Amt", "NetQty",
					"Net Sales" };
			ColNo = 9;
			vtype = "Date";
			try {
				showView(SQL2, Col2, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "Date":
			vvtype = "SALE";
			vmonthno = new gnConfig().date_ConverttoDBforamt(table.getValueAt(row, 1).toString());
			SQL2 = "Call   view_CustomerView('" + vvtype + "', " + vcomp + "," + vstore + ", " + vvendor + " ,  '"
					+ vmonthno + "' ,'" + vfinyear + "' )";
			String Col4[] = { "Type", "Name", "BillNo", "Date", "Gross Amount", "Discount", "Net Amount" };
			ColNo = 6;
			vtype = "Invno";
			try {
				showView(SQL2, Col4, ColNo, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "Invno":
			vdocno = table.getValueAt(row, 2).toString();
			vdocdate = (table.getValueAt(row, 3).toString());
			try {
				// new gnSale().showinvoice(vdocno, vdocdate);
				new gnEdit().showSales(vdocno, vdocdate);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}

	}

	public void showView(String SQL, String Col[], int colno, String vtype) throws Throwable {
		String vstatus = new gnFinYear().checkDateRanegforFinyear(fromdate.getText(), todate.getText());
		if (vstatus == "Sucess") {
			new gnTable().RemoveTableRows(model);
			// new General().msg(SQL);
			model.setColumnIdentifiers(Col);
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, colno, "N", "Y", vtype);
			new gnTable().setTableBasics(table);
			JViewport prt = new JViewport();
			prt.add(table, Col);
			prt.setVisible(true);
			table.setGridColor(Color.yellow);
			table.setBackground(Color.BLACK);
			table.setForeground(Color.WHITE);
			jsp.setViewport(prt);
			if (table.getRowCount() > 0) {
				Selectrow();
			}
		}
	}
}// last

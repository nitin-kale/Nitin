package RetailProduct;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

public class viewSupplier extends getResultSet {

	JFrame supplierviewFrame;
	JPanel panel;
	private String vcomp;
	String vcode = "";
	JRadioButton rb711;
	JRadioButton rb16;
	private String vfinyear;
	private String vstore;
	private JTextField storename;
	String vvendor = " ";

	private JTextField code;
	JPanel panel_3;
	JRadioButton rb11;
	private JTextField name;
	private JTextField phone;
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
	JPanel panel_4;

	private String vendor;
	private String SQL;
	private String vfromdate;
	private String vtodate;
	private JPanel panel_5;
	JRadioButton rb12;

	DefaultTableModel model = new DefaultTableModel();
	public JTable table = new JTable();
	private JTextField Amount;
	private JTextField records;
	private JLabel lblNewLabel_8;
	private JRadioButton rbpmode;
	private JRadioButton rbgroup;
	private JRadioButton rbcategory;
	private JRadioButton rbsubcat;
	private JTextField finyear;
	private JLabel lblNewLabel_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewSupplier window = new viewSupplier();
					window.supplierviewFrame.setVisible(true);
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
	public viewSupplier() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		supplierviewFrame = new JFrame();
		supplierviewFrame.setResizable(false);
		supplierviewFrame.setAlwaysOnTop(true);
		supplierviewFrame.setBounds(10, 10, 1350, 720);
		supplierviewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		supplierviewFrame.getContentPane().setLayout(null);
		ActionListener rb = new RbLsnr();

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(1, 7, 1, 1, (Color) new Color(75, 0, 130)));
		panel.setBounds(0, 0, 1338, 133);
		supplierviewFrame.getContentPane().add(panel);
		panel.setLayout(null);

		storename = new JTextField();
		storename.setEditable(false);
		storename.setForeground(Color.BLACK);
		storename.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		storename.setBackground(Color.WHITE);
		storename.setBounds(302, 0, 409, 31);
		panel.add(storename);
		storename.setColumns(10);

		// JPanel panel_1 = new JPanel();
		JPanel panel_1 = new gnRoundPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new MatteBorder(2, 3, 0, 0, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(231, 36, 1027, 93);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Party");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 14));
		lblNewLabel_2.setBounds(35, 9, 36, 16);
		panel_1.add(lblNewLabel_2);

		code = new JTextField();
		code.setForeground(new Color(0, 0, 102));
		code.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		code.setBounds(73, 3, 95, 28);
		panel_1.add(code);
		code.setColumns(10);

		name = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		name.setForeground(new Color(0, 0, 102));
		name.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		name.setBounds(168, 3, 314, 28);
		panel_1.add(name);
		name.setColumns(10);
		ActionListener supl = new suplLsnr();
		name.addActionListener(supl);

		JLabel lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 14));
		lblNewLabel_3.setBounds(503, 9, 47, 16);
		panel_1.add(lblNewLabel_3);

		phone = new JTextField();
		phone.setForeground(new Color(0, 0, 102));
		phone.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		phone.setEditable(false);
		phone.setBackground(Color.WHITE);
		phone.setBounds(551, 3, 95, 28);
		panel_1.add(phone);
		phone.setColumns(10);

		JPanel panel_2 = new JPanel();

		panel_2.setBounds(12, 38, 672, 50);
		panel_1.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new MatteBorder(3, 0, 0, 1, (Color) new Color(255, 222, 173)));
		panel_2.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("From");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(56, 2, 55, 16);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("To");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(168, 2, 20, 16);
		panel_2.add(lblNewLabel_5);

		fromdate = new JTextField();
		fromdate.setForeground(new Color(0, 0, 153));
		fromdate.setFont(new Font("Arial", Font.BOLD, 15));
		fromdate.setBounds(56, 18, 96, 28);
		panel_2.add(fromdate);
		fromdate.setColumns(10);

		todate = new JTextField();
		todate.setForeground(new Color(0, 0, 153));
		todate.setFont(new Font("Arial", Font.BOLD, 15));
		todate.setBounds(167, 18, 95, 28);
		panel_2.add(todate);
		todate.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Records");
		lblNewLabel_7.setBounds(339, 0, 55, 16);
		panel_2.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Cambria", Font.BOLD, 14));

		// records = new JTextField();
		records = new gnRoundTextField(20);
		records.setBounds(341, 18, 104, 30);
		panel_2.add(records);
		records.setFont(new Font("Arial", Font.BOLD, 15));
		records.setColumns(10);

		lblNewLabel_8 = new JLabel("Amount");
		lblNewLabel_8.setBounds(524, -2, 55, 16);
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Cambria", Font.BOLD, 14));

		// Amount = new JTextField();
		Amount = new gnRoundTextField(15);

		Amount.setBounds(526, 18, 110, 30);
		panel_2.add(Amount);
		Amount.setFont(new Font("Arial", Font.BOLD, 15));
		Amount.setColumns(10);
		btnExport = new JButton("Export To Excel");
		btnExport.setBounds(1151, 68, 158, 28);
		panel_1.add(btnExport);

		panel_5 = new JPanel();
		panel_5.setBounds(699, 25, 316, 55);
		panel_1.add(panel_5);
		panel_5.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(153, 153, 153), new Color(0, 0, 102)));
		panel_5.setLayout(null);

		btnShow = new JButton("Show Data");
		btnShow.setBounds(104, 26, 113, 28);
		panel_5.add(btnShow);
		btnShow.setMnemonic('S');

		searchname = new JTextField();
		searchname.setBounds(94, 0, 221, 28);
		panel_5.add(searchname);
		searchname.setColumns(10);

		searchcode = new JTextField();
		searchcode.setBounds(42, 0, 55, 28);
		panel_5.add(searchcode);
		searchcode.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Select ");
		lblNewLabel_6.setBounds(0, 6, 55, 16);
		panel_5.add(lblNewLabel_6);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { name, fromdate, todate }));

		ActionListener dt1 = new fromdateLsnr();
		ActionListener dt2 = new todateLsnr();
		ActionListener btn = new btnLsnr();

		JLabel lblNewLabel_1 = new JLabel("Fin.Year");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_1.setBounds(719, 4, 64, 21);
		panel.add(lblNewLabel_1);

		finyear = new JTextField();
		finyear.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		finyear.setBounds(781, 2, 94, 29);
		panel.add(finyear);
		finyear.setColumns(10);

		JLabel lblNewLabel = new JLabel("Supplier Data");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lblNewLabel.setBounds(53, 58, 106, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_9 = new JLabel(" ");
		lblNewLabel_9.setIcon(new ImageIcon(viewSupplier.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_9.setBounds(35, 0, 132, 133);
		panel.add(lblNewLabel_9);

		JLabel lblNewLabel_11 = new JLabel(" ");
		lblNewLabel_11.setIcon(new ImageIcon(viewSupplier.class.getResource("/RetailProduct/graphics4.png")));
		lblNewLabel_11.setBounds(1257, 0, 81, 129);
		panel.add(lblNewLabel_11);

		panel_4 = new JPanel();
		panel_4.setForeground(new Color(0, 0, 102));
		panel_4.setBackground(new Color(204, 255, 255));
		panel_4.setBounds(1, 243, 237, 288);
		// supplierviewFrame.getContentPane().add(panel_4);
		panel_4.setBorder(new TitledBorder(new MatteBorder(3, 1, 3, 3, (Color) new Color(0, 0, 0)), "Purchase",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(64, 64, 64)));

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(1, 245, 1300, 438);
		// supplierviewFrame.getContentPane().add(jsp);

		JSplitPane mySplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel_4, jsp);
		mySplit.setBackground(new Color(253, 245, 230));
		mySplit.setOneTouchExpandable(true);
		mySplit.setSize(1338, 544);
		mySplit.setLocation(0, 145);
		mySplit.setEnabled(false);
		mySplit.setDividerLocation(230);
		mySplit.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		supplierviewFrame.getContentPane().add(mySplit);

		rbbrand = new JRadioButton("Brand");
		rbbrand.setBounds(31, 94, 164, 25);
		rbbrand.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rbbrand.setForeground(Color.DARK_GRAY);
		buttonGroup.add(rbbrand);
		rbbrand.addActionListener(rb);
		panel_4.setLayout(null);
		panel_4.add(rbbrand);

		rbsubgroup = new JRadioButton("Sub Group");
		rbsubgroup.setBounds(31, 217, 164, 25);
		buttonGroup.add(rbsubgroup);
		rbsubgroup.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rbsubgroup.setForeground(Color.DARK_GRAY);
		rbsubgroup.addActionListener(rb);
		panel_4.add(rbsubgroup);

		rbgrn = new JRadioButton("GRN");
		rbgrn.setBounds(31, 64, 164, 25);
		buttonGroup.add(rbgrn);
		rbgrn.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rbgrn.setForeground(Color.DARK_GRAY);
		rbgrn.addActionListener(rb);
		panel_4.add(rbgrn);

		rbgroup = new JRadioButton("Group");
		rbgroup.setBounds(31, 187, 164, 25);
		buttonGroup.add(rbgroup);
		rbgroup.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rbgroup.setForeground(Color.DARK_GRAY);
		rbgroup.addActionListener(rb);
		panel_4.add(rbgroup);

		rbcategory = new JRadioButton("Category");
		rbcategory.setBounds(31, 124, 164, 25);
		rbcategory.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rbcategory.setForeground(Color.DARK_GRAY);
		rbcategory.addActionListener(rb);
		buttonGroup.add(rbcategory);
		panel_4.add(rbcategory);

		rbsubcat = new JRadioButton("SubCatwise");
		rbsubcat.setBounds(31, 157, 164, 25);
		rbsubcat.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rbsubcat.setForeground(Color.DARK_GRAY);
		rbsubcat.addActionListener(rb);
		buttonGroup.add(rbsubcat);
		panel_4.add(rbsubcat);

		panel_3 = new JPanel();
		panel_3.setBounds(21, 382, 194, 132);
		panel_3.setBackground(new Color(255, 255, 240));
		panel_4.add(panel_3);
		panel_3.setBorder(
				new TitledBorder(null, "Payment", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 51)));
		panel_3.setLayout(null);

		rbdue = new JRadioButton("Supplier Due Amount");
		rbdue.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		buttonGroup.add(rbdue);
		rbdue.setForeground(new Color(0, 0, 51));
		rbdue.setBounds(8, 28, 171, 18);
		rbdue.addActionListener(rb);
		panel_3.add(rbdue);

		rbpayment = new JRadioButton("Paid Grns");
		rbpayment.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		buttonGroup.add(rbpayment);
		rbpayment.setForeground(new Color(0, 0, 51));
		rbpayment.setBounds(8, 58, 157, 18);
		rbpayment.addActionListener(rb);
		panel_3.add(rbpayment);

		rbpmode = new JRadioButton("Payment Details");
		rbpmode.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 15));
		buttonGroup.add(rbpmode);
		rbpmode.setBounds(8, 93, 157, 18);
		rbpmode.addActionListener(rb);
		panel_3.add(rbpmode);

		rb11 = new JRadioButton("Supplier Purchase");
		rb11.setBounds(31, 34, 164, 25);
		buttonGroup.add(rb11);
		rb11.addActionListener(rb);
		rb11.setForeground(Color.DARK_GRAY);
		rb11.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		panel_4.add(rb11);

		rb12 = new JRadioButton("Payments");
		rb12.setBounds(31, 250, 164, 25);
		buttonGroup.add(rb12);
		rb12.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rb12.setForeground(Color.DARK_GRAY);
		rb12.setBackground(Color.CYAN);
		rb12.addActionListener(rb);
		panel_4.add(rb12);

		rb16 = new JRadioButton("Receipt Qty Diffrence");
		rb16.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rb16.setBounds(31, 280, 164, 25);
		rb16.setForeground(Color.DARK_GRAY);
		buttonGroup.add(rb16);
		rb16.addActionListener(rb);
		panel_4.add(rb16);

		rb711 = new JRadioButton("Debit Note Details");
		rb711.setForeground(Color.DARK_GRAY);
		rb711.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		buttonGroup.add(rb711);
		rb711.setBounds(31, 310, 162, 25);
		rb711.addActionListener(rb);
		panel_4.add(rb711);

		lblNewLabel_10 = new JLabel(" ");
		lblNewLabel_10.setIcon(new ImageIcon(viewSupplier.class.getResource("/RetailProduct/Ph2.png")));
		lblNewLabel_10.setBounds(0, 13, 22, 525);
		panel_4.add(lblNewLabel_10);
		panel_4.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { rbbrand, rbsubgroup, rbgrn, rbgroup,
				rbcategory, rbsubcat, rbdue, rbpayment, rbpmode, rb11 }));

		fromdate.addActionListener(dt1);
		todate.addActionListener(dt2);
		btnExport.addActionListener(btn);

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

	private void decorate() throws Throwable {
		panel_3.setVisible(false);
		new gnApp().setFrameTitel(supplierviewFrame);
		new gnField().closeform(panel, supplierviewFrame);
		new gnDecorate().DispField_Eatch(code, 16);
		new gnDecorate().DispField_Eatch(name, 16);
		new gnDecorate().DispField_Eatch(searchcode, 16);
		new gnDecorate().DispField_Eatch(searchname, 16);
		new gnDecorate().DispField_Eatch(fromdate, 16);
		new gnDecorate().DispField_Eatch(todate, 16);
		new gnDecorate().DispField_Eatch(storename, 16);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		storename.setText(new gnConfig().getStorename(vstore));
		panel_5.setVisible(false);
		finyear.setText(new gnFinYear().getReportingFinYear());
		vfinyear = finyear.getText();
		fromdate.setText(new gnFinYear().getFirstDateofFinYear());
		todate.setText(new gnFinYear().getLastDateofFinYear());

		showallSupplier();
	}

	class suplLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String vname = name.getText();
			vname = "%" + vname + "%";
			try {
				new gnSupplier().getSupplier(vname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				name.setText(new gnSupplier().rvendorName);
				code.setText(new gnSupplier().rvendorcode);
				phone.setText(new gnSupplier().rPhone);
			}
		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
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
			new General().msg("Select Vendor/Supplier Code  ..");

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

	private void showallSupplier() throws Throwable {
		// ActionForChoice(vcho) ;
		String vtype = "SupplierALL";
		vendor = "0";
		vfromdate = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
		vtodate = new gnConfig().date_ConverttoDBforamt(todate.getText());
		SQL = "call view_supplierView('" + vtype + "' ,  " + vcomp + ", " + vstore + ", " + vendor + ", '" + vfromdate
				+ "'  , '" + vtodate + "')";
		String supl1[] = { "Type", "Supplier", "Name", "Pur Qty", "Pur Amount", "PR.Qty", "PR.Amount", "Net Qty",
				"Net Amount" };
		int colno = 8;
		int sumcol = 8;
		showTableData(SQL, supl1, vtype, colno, sumcol);
	}

	private void ActionForChoice(String choice) throws Throwable {
		String status = validate();

		if (status == "Sucess") {
			vendor = code.getText();
			vfromdate = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
			vtodate = new gnConfig().date_ConverttoDBforamt(todate.getText());
			String vtype = " ";
			String vtrtype = "PUR";
			String ColBrand[] = { "Type", "Code", "Name", "Qty", "Pur Amount", "PR.Qty", "Pr.Amt", "Net Qty",
					"Net.Amount" };
			String supl[] = { "Type", "Supplier", "Name", "Amount" };
			String Col4[] = { "Date", "Code", "Name", "Total Amount" };
			int colno = 0;
			int sumcol = 0;

			switch (choice) {

			case "Debit Note Details":
				vtype = "DebitNote";
				SQL = "call view_supplierView('" + vtype + "' , " + vcomp + ", " + vstore + ", " + vendor + ", '"
						+ vfromdate + "'  , '" + vtodate + "')";
				String Col136[] = { "Tppe", "Supplier", "Name", "Debit.Note.Date", "Debit Note No", "Amount",
						"Ref.DocType", "Ref.DocNo", "Ref.Doc.Date" };
				colno = 8;
				sumcol = 5;
				showTableData(SQL, Col136, vtype, colno, sumcol);
				// showTableData(SQL , Col16 , vtype ) ;

				break;

			case "Receipt Qty Diffrence":
				vtype = "QtyDiffrence";
				SQL = "call view_supplierView('" + vtype + "' , " + vcomp + ", " + vstore + ", " + vendor + ", '"
						+ vfromdate + "'  , '" + vtodate + "')";
				String Col16[] = { "Tppe", "Supplier", "Name", "Article", "Item Name", "InvNo", "InvDate", "InvQty",
						"ReceivedQty", "Rate", "Base Price", "Taxamt", "Value", "GR.No", "GR.Date" };
				colno = 14;
				sumcol = 11;
				showTableData(SQL, Col16, vtype, colno, sumcol);
				// showTableData(SQL , Col16 , vtype ) ;
				break;

			case "Supplier Purchase":
				vtype = "Supplier";
				SQL = "call view_supplierView('" + vtype + "' , " + vcomp + ", " + vstore + ", " + vendor + ", '"
						+ vfromdate + "'  , '" + vtodate + "')";
				String supl1[] = { "Type", "Supplier", "Name", "Pur Qty", "Pur Amount", "PR.Qty", "PR.Amount",
						"Net Qty", "Net Amount" };
				colno = 8;
				sumcol = 8;
				showTableData(SQL, supl1, vtype, colno, sumcol);
				break;

			case "Supplier Due Amount":
				vtype = "Due";
				String Col[] = { "Name", "Grnno", "GrnDate", "Amount", "Suppl. Inv.No", "Suppl. Inv.date", "Cr.Days",
						"Due Date", "Type", "PO" };
				colno = 9;
				sumcol = 3;
				SQL = "call view_supplierView('" + vtype + "' , " + vcomp + ", " + vstore + ", " + vendor + ", '"
						+ vfromdate + "'  , '" + vtodate + "')";
				showTableData(SQL, Col, vtype, colno, sumcol);
				break;

			case "Paid Grns":
				vtype = "Paid";
				SQL = "call   view_supplierView('" + vtype + "' , " + vcomp + ", " + vstore + ", " + vendor + ", '"
						+ vfromdate + "'  , '" + vtodate + "' , '" + vtrtype + "')";
				String Col1[] = { "Name", "Grnno", "GrnDate", "Amount", "Suppl. Inv.No", "Suppl. Inv.date", "Cr.Days",
						"Due Date", "Payment No", "Payment Date" };
				colno = 9;
				sumcol = 3;
				showTableData(SQL, Col1, vtype, colno, sumcol);
				break;

			case "Payment Details":
				vtype = "Pmode";
				SQL = "call   view_supplierView('" + vtype + "' , " + vcomp + ", " + vstore + ", " + vendor + ", '"
						+ vfromdate + "'  , '" + vtodate + "' , '" + vtrtype + "')";
				String Col2[] = { "Name", "Payment No", "Payment Date", "Sr.No", "Payment Menthod", "Chq/DD NO",
						"Chq/DD Date", "Total GR Amount", "Paid Amount", "Bank", "Type" };
				colno = 10;
				sumcol = 8;
				showTableData(SQL, Col2, vtype, colno, sumcol);
				break;

			case "GRN":
				vtype = "GRN";
				SQL = "call   view_supplierView('" + vtype + "' , " + vcomp + ", " + vstore + ", " + vendor + ", '"
						+ vfromdate + "'  , '" + vtodate + "')";
				// new General().msg(SQL);
				String Col44[] = { "Type", "Supplier", "Name", "GR No", "Date", "Gross", "Disc", "Tax", "Net",
						"Oth.chrg", "LandingPrice" };
				colno = 10;
				sumcol = 10;
				showTableData(SQL, Col44, vtype, colno, sumcol);
				break;

			case "Brand":
				vtype = "Brand";
				SQL = "Call view_supplierView('" + vtype + "' , " + vcomp + ", " + vstore + ", " + vendor + " ,  '"
						+ vfromdate + "'  , '" + vtodate + "' )";
				colno = 8;
				sumcol = 8;
				showTableData(SQL, ColBrand, vtype, colno, sumcol);
				break;

			case "Group":
				vtype = "Group";
				SQL = "Call  view_supplierView('" + vtype + "', " + vcomp + ", " + vstore + ",  " + vendor + " ,  '"
						+ vfromdate + "'  , '" + vtodate + "' )";
				colno = 8;
				sumcol = 8;
				showTableData(SQL, ColBrand, vtype, colno, sumcol);
				break;

			case "Sub Group":
				vtype = "SubGroup";
				SQL = "Call  view_supplierView('" + vtype + "' , " + vcomp + ", " + vstore + ",  " + vendor + " ,  '"
						+ vfromdate + "'  , '" + vtodate + "' )";
				colno = 8;
				sumcol = 8;
				showTableData(SQL, ColBrand, vtype, colno, sumcol);
				break;

			case "Category":
				vtype = "Category";
				SQL = "Call  view_supplierView('" + vtype + "' , " + vcomp + ", " + vstore + ",  " + vendor + " , '"
						+ vfromdate + "'  , '" + vtodate + "' )";
				colno = 8;
				sumcol = 8;
				showTableData(SQL, ColBrand, vtype, colno, sumcol);
				break;

			case "SubCatwise":
				vtype = "Subcategory";
				SQL = "Call  view_supplierView('" + vtype + "' , " + vcomp + ", " + vstore + ",  " + vendor + " , '"
						+ vfromdate + "'  , '" + vtodate + "' )";
				colno = 8;
				sumcol = 8;
				showTableData(SQL, ColBrand, vtype, colno, sumcol);
				break;

			case "Payments":
				vtype = "Payments";
				SQL = "Call  view_supplierView('" + vtype + "' , " + vcomp + ", " + vstore + ",  " + vendor + " , '"
						+ vfromdate + "'  , '" + vtodate + "' )";
				String Col8[] = { "Party", "Doctype", "Doc.No", "Doc Date", "Amount", "Payment Type", "Instrument No",
						"Instr.Date" };
				colno = 7;
				sumcol = 4;
				showTableData(SQL, Col8, vtype, colno, sumcol);
				break;
			}
		}
	}

	private void showTableData(String SQL, String Col[], String vtype, int colno, int colsum) throws Throwable {
		// new General().msg(SQL);
		new gnTable().RemoveTableRows(model);
		String vstatus = new gnFinYear().checkDateRanegforFinyear(fromdate.getText(), todate.getText());
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, colno, "N", "Y", vtype);
		Amount.setText(Double.toString(new gnTable().getTotal(table, colsum)));
		if (table.getRowCount() > 0) {
			table.requestFocusInWindow();
			table.requestFocus();
			new gnTable().setTablewidth(table, 1, 30);
			new gnTable().setTablewidth(table, 2, 300);
			// new gnTable().setTablewidth(table,3,50);
			// new gnTable().setTablewidth(table,4,50);
			String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
			records.setText(RecordCount1);
			new gnTable().setTableBasics(table);
			table.setCellSelectionEnabled(false);
			table.setRowSelectionAllowed(true);
			JViewport prt = new JViewport();
			prt.setBackground(new Color(104, 255, 255));
			prt.setBackground(Color.WHITE);
			prt.add(table, Col);
			prt.setVisible(true);
			jsp.setViewport(prt);
			jsp.setViewport(prt);
			new gnTable().setFontBold(table, 12);
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
		String vmonthno = " ";
		String vvtype = "";
		String SQL2 = " ";
		String vtype = "";
		int colno = 3;
		int sumcol = 3;
		vvendor = code.getText();

		String ColBrand[] = { "Type", "Code", "Name", "Qty", "Pur Amount", "PR.Qty", "Pr.Amt", "Net Qty",
				"Net.Amount" };

		switch (value.trim()) {

		case "Brand":
			vcode = table.getValueAt(row, 1).toString();
			vvtype = "BrandItems";
			SQL = "Call   view_supplierView1('" + vvtype + "', " + vcomp + "," + vstore + ",  " + vvendor + ",  '"
					+ vfromdate + "' ,'" + vtodate + "' , " + vcode + ", '" + vfinyear + "' )";
			colno = 8;
			sumcol = 8;
			vtype = "BrandItems";
			showTableData(SQL, ColBrand, vtype, colno, sumcol);
			break;

		case "Category":
			vcode = table.getValueAt(row, 1).toString();
			vvtype = "CategoryItems";
			SQL = "Call   view_supplierView1('" + vvtype + "', " + vcomp + "," + vstore + ",  " + vvendor + ",  '"
					+ vfromdate + "' ,'" + vtodate + "' , " + vcode + ", '" + vfinyear + "' )";
			colno = 8;
			sumcol = 8;
			vtype = "CatIItems";
			showTableData(SQL, ColBrand, vtype, colno, sumcol);
			break;

		case "Subcategory":
			vcode = table.getValueAt(row, 1).toString();
			vvtype = "SubCategoryItems";
			SQL = "Call   view_supplierView1('" + vvtype + "', " + vcomp + "," + vstore + ",  " + vvendor + ",  '"
					+ vfromdate + "' ,'" + vtodate + "' , " + vcode + ", '" + vfinyear + "' )";
			// new General().msg(SQL);
			colno = 8;
			sumcol = 8;
			vtype = "SubCatItems";
			showTableData(SQL, ColBrand, vtype, colno, sumcol);
			break;

		case "Group":
			vcode = table.getValueAt(row, 1).toString();
			vvtype = "GroupItems";
			SQL = "Call   view_supplierView1('" + vvtype + "', " + vcomp + "," + vstore + ",  " + vvendor + ",  '"
					+ vfromdate + "' ,'" + vtodate + "' , " + vcode + ", '" + vfinyear + "' )";
			colno = 8;
			sumcol = 8;
			vtype = "GroupItems";
			showTableData(SQL, ColBrand, vtype, colno, sumcol);
			break;

		case "SubGroup":
			vcode = table.getValueAt(row, 1).toString();
			vvtype = "SubGroupItems";
			SQL = "Call   view_supplierView1('" + vvtype + "', " + vcomp + "," + vstore + ",  " + vvendor + ",  '"
					+ vfromdate + "' ,'" + vtodate + "' , " + vcode + ", '" + vfinyear + "' )";
			colno = 8;
			sumcol = 8;
			vtype = "SubGroupItems";
			showTableData(SQL, ColBrand, vtype, colno, sumcol);
			break;

		case "SupplierALL":
			vvendor = table.getValueAt(row, 1).toString();
			vvtype = "Month";
			SQL2 = "Call   view_supplierView('" + vvtype + "', " + vcomp + "," + vstore + ",  " + vvendor + ",  '"
					+ vfromdate + "' ,'" + vtodate + "' )";
			String Col1[] = { "Type", "Month No", "Month", "Amount" };
			colno = 3;
			sumcol = 3;
			vtype = "Month";
			try {
				showView(SQL2, Col1, colno, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		case "Supplier":
			vvendor = table.getValueAt(row, 1).toString();
			vvtype = "Month";
			SQL2 = "Call   view_supplierView('" + vvtype + "', " + vcomp + "," + vstore + ",  " + vvendor + ",  '"
					+ vfinyear + "' ,'" + vfinyear + "' )";
			String Col111[] = { "Type", "Month No", "Month", "Amount" };
			colno = 3;
			sumcol = 3;
			vtype = "Month";
			try {
				showView(SQL2, Col111, colno, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "Month":
			vvtype = "MonthDates";
			vmonthno = table.getValueAt(row, 1).toString();
			SQL2 = "Call   view_SupplierView('" + vvtype + "', " + vcomp + "," + vstore + ", " + vvendor + " ,  '"
					+ vmonthno + "' ,'" + vfinyear + "' )";
			String Col2[] = { "Type", "Date", "Gross", "Disc", "Tax .Amt", "Net Price", "Other charg",
					"Landing Price" };
			colno = 7;
			sumcol = 3;
			vtype = "Date";
			try {
				showView(SQL2, Col2, colno, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "Date":
			vvtype = "Pur";
			vmonthno = new gnConfig().date_ConverttoDBforamt(table.getValueAt(row, 1).toString());
			SQL2 = "Call   view_SupplierView('" + vvtype + "', " + vcomp + "," + vstore + ", " + vvendor + " ,  '"
					+ vmonthno + "' ,'" + vfinyear + "' )";
			String Col4[] = { "Type", "Supplier", "Name", "GR No", "Date", "Gross", "Disc", "Tax", "Net", "Oth.chrg",
					"LandingPrice" };
			colno = 10;
			sumcol = 10;
			vtype = "GRN";
			try {
				showView(SQL2, Col4, colno, vtype);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "GRN":
			String vdocno = table.getValueAt(row, 3).toString();
			String vdocdate = (table.getValueAt(row, 4).toString());
			String vsuplier = (table.getValueAt(row, 1).toString());
			try {
				new gnEdit().ShowGRN(vsuplier, vdocno, vdocdate);
				// new gnGrn().viewGrn(vdocno, vdocdate);
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
			model.setColumnIdentifiers(Col);
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, colno, "N", "Y", vtype);
			new gnTable().setTableBasics(table);
			JViewport prt = new JViewport();
			prt.add(table, Col);
			prt.setVisible(true);
			jsp.setViewport(prt);
			if (table.getRowCount() > 0) {
				Selectrow();
			}
		}
	}
}// last

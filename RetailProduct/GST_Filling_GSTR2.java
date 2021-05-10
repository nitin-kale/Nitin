package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class GST_Filling_GSTR2 {

	JFrame gst_GSTR2_Frame;
	private JTextField fromdate;
	private JTextField todate;
	private JTextField finyear;
	private JTextField compname;
	private JTextField isgst;
	private JTextField gstno;
	private JTextField statecode;
	private JButton btnExport;
	private JTextField statename;
	JPanel lpanel;
	JPanel rpanel;
	JButton btngst1;
	JButton btngst2;
	JButton btngst3;
	JButton btngst4;
	JButton btngst5;
	JButton btngst6;
	JButton btngst7;
	JButton btngst8;
	JButton btngst9;
	JButton btngst10;

	JScrollPane jsp;
	String vcomp;
	String vstore;

	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	String SQL;
	String col[];
	String colforchoice7[];
	String colforchoice10[];
	JScrollPane jsp1;
	JTable table1 = new JTable();
	DefaultTableModel model1 = new DefaultTableModel();

	private JRadioButton rb3;
	private JRadioButton rb4;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb5;
	private JRadioButton rb6;
	private JRadioButton rb7;
	private JRadioButton rb8;
	private JRadioButton rb9;
	private JRadioButton rb10;
	private JRadioButton rb11;

	private String choice = "1";

	private JLabel lblNewLabel_9;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField scheme;
	private JLabel lblNewLabel_5;
	private JTextField schedule;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GST_Filling_GSTR2 window = new GST_Filling_GSTR2();
					window.gst_GSTR2_Frame.setVisible(true);
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
	public GST_Filling_GSTR2() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		gst_GSTR2_Frame = new JFrame();
		gst_GSTR2_Frame.getContentPane().setBackground(new Color(153, 0, 102));
		gst_GSTR2_Frame.setBackground(Color.WHITE);
		gst_GSTR2_Frame.setAlwaysOnTop(true);
		gst_GSTR2_Frame.setBounds(0, 1, 1375, 760);
		gst_GSTR2_Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gst_GSTR2_Frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("GST Return File Data");
		lblNewLabel.setBounds(251, 0, 1081, 25);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(204, 255, 153));
		lblNewLabel.setBackground(new Color(255, 218, 185));
		gst_GSTR2_Frame.getContentPane().add(lblNewLabel);

		lpanel = new JPanel();
		lpanel.setBorder(null);
		lpanel.setBackground(new Color(255, 255, 255));
		lpanel.setBounds(1, 1, 199, 522);
		lpanel.setVisible(false);

		rpanel = new JPanel();
		rpanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "GST - Return File Data",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 0, 128)));
		rpanel.setBackground(new Color(0, 255, 255));
		// rpanel.setBounds(201, 115, 1131, 408);
		rpanel.setBounds(1, 115, 1360, 408);

		// gst_returnFile_data.getContentPane().add(rpanel);
		rpanel.setLayout(null);

		jsp = new JScrollPane();
		// jsp.setBounds(12, 13, 1120, 361);
		jsp.setBounds(1, 1, 1143, 361);

		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		rpanel.add(jsp);

		JSplitPane mysplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lpanel, rpanel);
		lpanel.setLayout(null);

		lblNewLabel_9 = new JLabel("Inward Supply- GSTR2");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel_9.setBounds(12, 27, 183, 16);
		lpanel.add(lblNewLabel_9);

		rb1 = new JRadioButton("B2B Invoices");
		rb1.setMnemonic('B');
		buttonGroup.add(rb1);
		rb1.setBackground(Color.WHITE);
		rb1.setForeground(Color.DARK_GRAY);
		rb1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rb1.setBounds(12, 52, 187, 25);
		lpanel.add(rb1);

		rb2 = new JRadioButton("Reverse charge TaxPayable");
		rb2.setMnemonic('R');
		buttonGroup.add(rb2);
		rb2.setBackground(Color.WHITE);
		rb2.setForeground(Color.DARK_GRAY);
		rb2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rb2.setBounds(12, 79, 187, 25);
		lpanel.add(rb2);

		rb3 = new JRadioButton("Imports/SEZ");
		rb3.setMnemonic('I');
		buttonGroup.add(rb3);
		rb3.setBackground(Color.WHITE);
		rb3.setForeground(Color.DARK_GRAY);
		rb3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rb3.setBounds(12, 109, 187, 25);
		lpanel.add(rb3);

		rb4 = new JRadioButton("Nil Rated/ composition supply");
		rb4.setMnemonic('N');
		buttonGroup.add(rb4);
		rb4.setBackground(Color.WHITE);
		rb4.setForeground(Color.DARK_GRAY);
		rb4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		rb4.setBounds(12, 139, 187, 25);
		lpanel.add(rb4);

		rb5 = new JRadioButton("DNCN Amendment");
		rb5.setMnemonic('D');
		buttonGroup.add(rb5);
		rb5.setForeground(Color.DARK_GRAY);
		rb5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rb5.setBackground(Color.WHITE);
		rb5.setBounds(12, 169, 187, 25);
		lpanel.add(rb5);

		rb7 = new JRadioButton("ISD Credit Received");
		rb7.setMnemonic('C');
		buttonGroup.add(rb7);
		rb7.setForeground(Color.DARK_GRAY);
		rb7.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rb7.setBackground(Color.WHITE);
		rb7.setBounds(12, 199, 187, 25);
		lpanel.add(rb7);

		rb8 = new JRadioButton("TDS/TCS Credit Recd");
		rb8.setMnemonic('T');
		buttonGroup.add(rb8);
		rb8.setForeground(Color.DARK_GRAY);
		rb8.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rb8.setBackground(Color.WHITE);
		rb8.setBounds(12, 229, 187, 25);
		lpanel.add(rb8);

		rb9 = new JRadioButton("Advance Paid- Reverse Charg");
		rb9.setMnemonic('A');
		buttonGroup.add(rb9);
		rb9.setForeground(Color.DARK_GRAY);
		rb9.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		rb9.setBackground(Color.WHITE);
		rb9.setBounds(12, 259, 187, 25);
		lpanel.add(rb9);

		rb10 = new JRadioButton("Adjustment of Advance");
		rb10.setMnemonic('O');
		buttonGroup.add(rb10);
		rb10.setForeground(Color.DARK_GRAY);
		rb10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		rb10.setBackground(Color.WHITE);
		rb10.setBounds(12, 289, 183, 25);
		lpanel.add(rb10);

		rb11 = new JRadioButton("List of Documents");
		rb11.setMnemonic('L');
		rb11.setVisible(false);
		rb11.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		buttonGroup.add(rb11);
		rb11.setBackground(Color.WHITE);
		rb11.setForeground(Color.DARK_GRAY);
		rb11.setBounds(12, 319, 187, 25);
		lpanel.add(rb11);

		JLabel lblNewLabel_10 = new JLabel(" ");
		lblNewLabel_10.setIcon(new ImageIcon(GST_Filling_GSTR2.class.getResource("/RetailProduct/resouce/panel1.png")));
		lblNewLabel_10.setBounds(0, 0, 210, 406);
		lpanel.add(lblNewLabel_10);
		gst_GSTR2_Frame.getContentPane().add(mysplit);
		mysplit.setBounds(1, 115, 1350, 408);
		mysplit.setDividerLocation(200);
		mysplit.setContinuousLayout(true);

		// JSplitPane mySplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
		// leftPanel, jsp);

 
		JLabel lblNewLabel_1 = new JLabel("From Date");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_1.setBounds(35, 41, 68, 16);
		gst_GSTR2_Frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Financial Year");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(25, 16, 88, 16);
		gst_GSTR2_Frame.getContentPane().add(lblNewLabel_2);

		fromdate = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		fromdate.setBounds(111, 38, 88, 22);
		gst_GSTR2_Frame.getContentPane().add(fromdate);
		fromdate.setColumns(10);

		finyear = new JTextField();
		finyear.setEditable(false);
		finyear.setBounds(110, 13, 66, 22);
		gst_GSTR2_Frame.getContentPane().add(finyear);
		finyear.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Company");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(619, 35, 56, 16);
		gst_GSTR2_Frame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("GSTIN");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(609, 60, 66, 16);
		gst_GSTR2_Frame.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("State");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(619, 83, 56, 16);
		gst_GSTR2_Frame.getContentPane().add(lblNewLabel_8);

		compname = new JTextField();
		compname.setBackground(new Color(0, 255, 255));
		compname.setEditable(false);
		compname.setForeground(new Color(128, 0, 0));
		compname.setFont(new Font("Calibri", Font.BOLD, 12));
		compname.setBounds(681, 35, 330, 22);
		gst_GSTR2_Frame.getContentPane().add(compname);
		compname.setColumns(10);

		isgst = new JTextField();
		isgst.setBackground(new Color(0, 255, 255));
		isgst.setEditable(false);
		isgst.setForeground(new Color(128, 0, 0));
		isgst.setFont(new Font("Calibri", Font.BOLD, 12));
		isgst.setBounds(681, 57, 26, 22);
		gst_GSTR2_Frame.getContentPane().add(isgst);
		isgst.setColumns(10);

		gstno = new JTextField();
		gstno.setBackground(new Color(0, 255, 255));
		gstno.setEditable(false);
		gstno.setForeground(new Color(128, 0, 0));
		gstno.setFont(new Font("Calibri", Font.BOLD, 12));
		gstno.setBounds(708, 57, 303, 22);
		gst_GSTR2_Frame.getContentPane().add(gstno);
		gstno.setColumns(10);

		statecode = new JTextField();
		statecode.setBackground(new Color(0, 255, 255));
		statecode.setEditable(false);
		statecode.setForeground(new Color(128, 0, 0));
		statecode.setFont(new Font("Calibri", Font.BOLD, 12));
		statecode.setBounds(680, 80, 27, 22);
		gst_GSTR2_Frame.getContentPane().add(statecode);
		statecode.setColumns(10);

		statename = new JTextField();
		statename.setBackground(new Color(0, 255, 255));
		statename.setEditable(false);
		statename.setForeground(new Color(128, 0, 0));
		statename.setFont(new Font("Calibri", Font.BOLD, 12));
		statename.setBounds(708, 80, 303, 22);
		gst_GSTR2_Frame.getContentPane().add(statename);
		statename.setColumns(10);

		jsp1 = new JScrollPane();
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(1, 536, 1350, 179);
		gst_GSTR2_Frame.getContentPane().add(jsp1);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(204, 255, 204)));
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(1, 0, 208, 111);
		gst_GSTR2_Frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("To Date");
		lblNewLabel_3.setBounds(42, 69, 46, 16);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 14));

		todate = new JTextField();
		todate.setBounds(110, 65, 86, 22);
		panel.add(todate);
		todate.setColumns(10);

		btnExport = new JButton("Export To Excel");
		btnExport.setMnemonic('E');
		btnExport.setBounds(1223, 11, 128, 46);
		gst_GSTR2_Frame.getContentPane().add(btnExport);

		JLabel lblNewLabel_4 = new JLabel("GST - Scheme");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_4.setBounds(293, 20, 83, 16);
		gst_GSTR2_Frame.getContentPane().add(lblNewLabel_4);

		scheme = new JTextField();
		scheme.setBackground(Color.WHITE);
		scheme.setForeground(new Color(128, 0, 128));
		scheme.setEditable(false);
		scheme.setBounds(381, 16, 203, 26);
		gst_GSTR2_Frame.getContentPane().add(scheme);
		scheme.setColumns(10);

		lblNewLabel_5 = new JLabel("Return File Schedule");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(233, 44, 143, 16);
		gst_GSTR2_Frame.getContentPane().add(lblNewLabel_5);

		schedule = new JTextField();
		schedule.setBackground(Color.WHITE);
		schedule.setEditable(false);
		schedule.setFont(new Font("Calibri", Font.BOLD, 14));
		schedule.setBounds(381, 44, 203, 22);
		gst_GSTR2_Frame.getContentPane().add(schedule);
		schedule.setColumns(10);

		btnClose = new JButton("Close");
		btnClose.setIcon(new ImageIcon(GST_Filling_GSTR2.class.getResource("/RetailProduct/delete.png")));
		btnClose.setMnemonic('C');
		btnClose.setBounds(1222, 62, 129, 56);
		gst_GSTR2_Frame.getContentPane().add(btnClose);
		ActionListener rbls = new rblsnr();
		rb3.addActionListener(rbls);
		rb4.addActionListener(rbls);
		rb1.addActionListener(rbls);
		rb2.addActionListener(rbls);
		rb5.addActionListener(rbls);
		rb7.addActionListener(rbls);
		rb8.addActionListener(rbls);
		rb9.addActionListener(rbls);
		rb10.addActionListener(rbls);
		rb11.addActionListener(rbls);

		ActionListener btnls = new btnlsnr();
  		ActionListener frmLsnr = new fromdateLsnr();
		ActionListener toLsnr = new todateLsnr();
		fromdate.addActionListener(frmLsnr);
		todate.addActionListener(toLsnr);
		btnExport.addActionListener(btnls);
		btnClose.addActionListener(btnls);

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

		new gnApp().setFrameTitel(gst_GSTR2_Frame);
		new gnField().closeform(lpanel, gst_GSTR2_Frame);
		new gnField().closeform(rpanel, gst_GSTR2_Frame);

		new gnStyleButton().getStyleButton(btnClose, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnExport, new Color(156, 211, 112), Color.WHITE);
		new gnDecorate().DispField_Beval_int(gstno, 10);
		new gnDecorate().DispField_Beval_int(compname, 10);
		new gnDecorate().decorateField(compname);
		new gnDecorate().DispField_Beval_int(isgst, 10);
		new gnDecorate().DispField_Beval_int(gstno, 10);
		new gnDecorate().DispField_Beval_int(statecode, 10);
		new gnDecorate().DispField_Beval_int(statename, 10);
		compname.setText(new gnConfig().getCompany());
		isgst.setText(new gnGST().ismyComanyGSTRegister());
		gstno.setText(new gnGST().getComanyGSTno());
		statecode.setText(new gnGST().getmyState());
		finyear.setText(new gnFinYear().getReportingFinYear());
		statename.setText(new gnGST().getmystatename());
		scheme.setText(new gnGST().gst_getmytaxscheme());
		fromdate.setText(new gnFinYear().getFirstDateofFinYear());
		todate.setText(new gnFinYear().getLastDateofFinYear());

		// statename.setText(new gnGST());

		String vschmetype = new gnGST().gst_getmytaxschemecode();
		lpanel.setVisible(true);
 	}

	class btnlsnr implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String value = e.getActionCommand();


			if (value == "Close") {
				gst_GSTR2_Frame.dispose();
			}

			if (value == "Export To Excel") {
				exportData();
			}
		}
	}

	void showReportSection(String SQL, String[] colreport) throws ClassNotFoundException, SQLException {
		model1.setColumnIdentifiers(colreport);
		table1 = new gnTableModel().Tablemodel4(table1, model1, SQL, colreport, 4, "N", "N", "N");

		table1.setModel(model1);
		new gnTable().setTableBasics(table1);
		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.WHITE);
		prt1.add(table1, colreport);
		prt1.setVisible(true);
		jsp1.setViewport(prt1);
	}

	void showSupplierInvoiceDetail() throws Throwable {
		String colreport1[] = { "Supplier", "Name", "Invoice No", "Invoice Date", "Amount", "Gr.No", "Gr.Date",
				"Gr.Amount" };
		String vfrom = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
		String vto = new gnConfig().date_ConverttoDBforamt(todate.getText());
		String vstore = new gnConfig().getStoreID();
		String SQL = "call GST_getSupplierInvoiceDetails(" + vcomp + ", " + vstore + " , '" + vfrom + "' , '" + vto
				+ "' )";
		// new General().msg(SQL);
		model1.setColumnIdentifiers(colreport1);
		table1 = new gnTableModel().Tablemodel(table1, model1, SQL, colreport1, 8, "N", "N", "N");
		table1.setModel(model1);
		new gnTable().setTableBasics(table1);
		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.WHITE);
		prt1.add(table1, colreport1);
		prt1.setVisible(true);
		jsp1.setViewport(prt1);
	}

	class rblsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			boolean vrb1 = rb1.isSelected();
			boolean vrb2 = rb2.isSelected();
			boolean vrb3 = rb3.isSelected();
			boolean vrb4 = rb4.isSelected();
			boolean vrb5 = rb5.isSelected();
			// boolean vrb6 = rb6.isSelected();
			boolean vrb7 = rb7.isSelected();
			boolean vrb8 = rb8.isSelected();
			boolean vrb9 = rb9.isSelected();
			boolean vrb10 = rb10.isSelected();
			boolean vrb11 = rb11.isSelected();

			if (vrb1) {
				choice = "1";
			}

			if (vrb2) {
				choice = "2";
			}

			if (vrb3) {
				choice = "3";
			}

			if (vrb4) {
				choice = "4";
			}

			if (vrb5) {
				choice = "5";
			}

			if (vrb7) {
				choice = "7";
			}

			if (vrb8) {
				choice = "8";
			}

			if (vrb9) {
				choice = "9";
			}

			if (vrb10) {
				choice = "10";
			}

			try {
				callAction();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	void callAction() throws Throwable {

		showTableData();

	}

	private void showTableData() throws Throwable {
		String vstatus = new gnFinYear().checkDateRanegforFinyear(fromdate.getText(), todate.getText());
		if (vstatus == "Sucess") {
			String vrepsection;
			String vtype;
			String col[] = { "Type", "TableNO", "Title", "Supplier GSTIN No", "Inv.No", "Inv.Date", "Inv.Amt",
					"TaxRate", "Taxable Value", "IGST", "CGST", "SGST", "Place of Supply", "Reverse Chrg", "ITC<Y/N>",
					"IGST", "CGST", "SGST", "Cess" };

			String colforchoice4[] = { "Type", "TableNO", "Title", "GSTIN-Recipient", "Inv/Adv Recpt.No",
					"Inv/Adv Doc.Date", "Note/Refund Vou.No", "Note/Refund Vou Date", "Doc.Type", "Reason",
					"Place of supply", "Doc Value", "Rate", "Taxable Value", "Cess", "Pre GST" };

			String colforchoice5[] = { "Type", "TableNO", "Title", "UR Type", "Note Refund Voucher No",
					"Note/Refund.Date", "Doc.Type", "Inv/Adv.Recpt.No", "Inv/Adv.Rcpt Date", "Reason",
					"Place of supply", "Doc Value", "Rate", "Taxable Value", "Cess", "Pre GST" };

			String colchoice7[] = { "Type", "TableNo", "Title", "Export Type", "Inv.No", "InvDate", "Inv Value",
					"PortCode", "Shipping.Bill.No", "Ship.BillDate", "Tax Rate", "Taxable Value", "IGST" };

			String colchoice9[] = { "Type", "Table", "Title", "Rate", "Gross Amount:", "PlaceofSupply", "IGST", "CGST",
					"SGST", "Cess" };

			String colchoice4[] = { "Type", "Table", "Title", "Nil Rated", "Expm", "Non GST" };

			model.setColumnIdentifiers(col);
			String vfrom = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
			String vto = new gnConfig().date_ConverttoDBforamt(todate.getText());
			vcomp = new gnConfig().getCompanyCode();
			switch (choice) {
			case "1":
				vrepsection = choice;
				new gnTable().RemoveTableRows(model);
				vtype = "Inward Invoice Exclude Rev.chrg";
				SQL = "call GST_Data_GSTR2(" + vcomp + " ,'" + vfrom + "', '" + vto + "' ,'" + vrepsection + "')";
				// new General().msg(SQL);
				table = new gnTableModel().Tablemodel(table, model, SQL, col, 17, "N", "Y", vtype);
				showSupplierInvoiceDetail();
				break;

			case "2":
				vrepsection = choice;
				new gnTable().RemoveTableRows(model);
				vtype = "Reverse Charg TaxPayable";
				SQL = "call GST_Data_GSTR2(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				// new General().msg(SQL);
				table = new gnTableModel().Tablemodel(table, model, SQL, col, 17, "N", "Y", vtype);
				break;

			case "3":
				vrepsection = choice;
				new gnTable().RemoveTableRows(model);
				vtype = "Import/SEZ";
				SQL = "call GST_Data_GSTR2(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				table = new gnTableModel().Tablemodel(table, model, SQL, col, 17, "N", "Y", vtype);
				break;

			case "4":
				vrepsection = choice;
				new gnTable().RemoveTableRows(model);
				vtype = "Nil/Exempted";
				SQL = "call GST_Data_GSTR2(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				table = new gnTableModel().Tablemodel(table, model, SQL, colchoice4, 5, "N", "Y", vtype);
				break;

			case "9":
				new gnTable().RemoveTableRows(model);
				vrepsection = choice;
				vtype = "Supl.Advance";
				SQL = "call GST_Data_GSTR2(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				table = new gnTableModel().Tablemodel6(table, model, SQL, colchoice9, 9, "N", "Y", vtype);
				break;

			case "10":
				new gnTable().RemoveTableRows(model);
				vrepsection = choice;
				vtype = "Supl.Adv.Adjustment";
				SQL = "call GST_Data_GSTR2(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				table = new gnTableModel().Tablemodel5(table, model, SQL, colchoice4, 5, "N", "Y", vtype);
				break;
			}
			table.setModel(model);
			new gnTable().setTableBasics(table);
			JViewport prt = new JViewport();
			prt.setBackground(Color.WHITE);
			prt.add(table, col);
			prt.setVisible(true);
			jsp.setViewport(prt);
		}
	}

	private void exportData() {
		new Export_Table_Data_to_Excel().exportTable(table);
	}
}// Last

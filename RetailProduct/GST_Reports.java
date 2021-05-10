package RetailProduct;

import java.awt.Color;
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
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;

public class GST_Reports {

	JFrame GSTReportFrame;
	private JTextField from;
	private JTextField to;
	JPanel lpanel;
	JPanel rpanel;
	JScrollPane jsp;
	JButton btnTaxExport;
	JInternalFrame internalFrame;
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();

	JTable stable = new JTable();
	DefaultTableModel smodel = new DefaultTableModel();

	JPanel panel;

	String vmode;
	int btnno = 0;

	JButton btnSales;
	JButton btnPurchase;
	JButton btnSalesret;
	JButton btnExport;
	JButton btnPurRet;
	JButton btnReverse;
	JButton btncustAdv;
	JButton btnSuplAdv;
	JButton btnDrnote;
	JButton btnCrnote;
	JButton btnTax;

	JButton btnPurTax;

	JButton btnpurtax;
	JButton btnsaletax;
	JButton btntaxalldoc;

	JButton btnSalIntra;
	JButton btnSaleInter;
	JButton btnintrapur;
	JButton btninterpur;
	JScrollPane jsp1;

	String vfrom;
	String vto;
	String vcomp;

	String vtype = "";

	private JLabel label;
	private JTextField scheme;
	private JLabel label_1;
	private JTextField schedule;
	private JTextField companyname;
	private JLabel label_3;
	private JTextField isgst;
	private JTextField gstno;
	private JLabel label_4;
	private JTextField statecode;
	private JTextField statename;
	private JTextField txbalval;
	private JTextField tvalue;
	private JTextField taxamt;
	private JTextField tigst;
	private JTextField tsgst;
	private JTextField tcgst;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GST_Reports window = new GST_Reports();
					window.GSTReportFrame.setVisible(true);
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
	public GST_Reports() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		GSTReportFrame = new JFrame();
		GSTReportFrame.setResizable(false);
		GSTReportFrame.setAlwaysOnTop(true);
		//GSTReportFrame.setBounds(1, 100, 1350, 702);
		GSTReportFrame.setBounds(1, 100, 1350, 611);
		
		GSTReportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GSTReportFrame.getContentPane().setLayout(null);
 		GSTReportFrame.getContentPane().setBackground(Color.WHITE);
  		GSTReportFrame.getContentPane().setForeground(Color.WHITE);
 		GSTReportFrame.getContentPane().setLayout(null);

	
		/*
		internalFrame = new JInternalFrame("");
		internalFrame.setForeground(new Color(51, 0, 153));
 		internalFrame.setBackground(Color.WHITE);
		internalFrame.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
 		internalFrame.setBounds(0, 0, 1340, 665);
   		GSTReportFrame.getContentPane().add(internalFrame);
         */
 
		// lpanel = new JPanel();
		lpanel = new gnRoundPanel();

		lpanel.setBorder(new MatteBorder(3, 1, 2, 3, (Color) new Color(0, 0, 204)));
		lpanel.setBackground(Color.WHITE);
		lpanel.setBounds(1, 1, 199, 408);
		lpanel.setVisible(true);

		rpanel = new JPanel();
		rpanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "GST -Data", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(128, 0, 128)));
		rpanel.setBackground(Color.CYAN);
		rpanel.setBounds(1, 115, 1300, 408);
		rpanel.setLayout(null);

		jsp = new JScrollPane();
		jsp.setViewportBorder(
				new BevelBorder(BevelBorder.RAISED, Color.YELLOW, Color.MAGENTA, Color.BLUE, new Color(0, 0, 51)));
		jsp.setBounds(6, 0, 1121, 280);
		rpanel.add(jsp);

		JSplitPane mysplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lpanel, rpanel);
		mysplit.setEnabled(false);
		mysplit.setBounds(1, 153, 1340, 468);

		jsp1 = new JScrollPane();
		jsp1.setBounds(6, 304, 1116, 149);
		rpanel.add(jsp1);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel lblNewLabel = new JLabel("Tax Break up");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 11));
		lblNewLabel.setBounds(16, 282, 153, 16);
		rpanel.add(lblNewLabel);

		btnTaxExport = new JButton("Export Tax Data");
		btnTaxExport.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnTaxExport.setBounds(140, 282, 190, 25);
		rpanel.add(btnTaxExport);
		lpanel.setLayout(null);

		// btnSales = new JButton("Sales");
		btnSales = new gnRoundButton("Sales");
		btnSales.setBackground(new Color(255, 255, 255));
		btnSales.setBounds(12, 0, 175, 25);
		btnSales.setMnemonic('S');
		btnSales.setForeground(new Color(0, 0, 0));
		btnSales.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnSales);

		// btnTax = new JButton("Sales-BillWise Details");
		btnTax = new gnRoundButton("Sales-BillWise Details");

		btnTax.setBackground(new Color(255, 255, 255));
		btnTax.setBounds(12, 26, 175, 25);
		btnTax.setForeground(new Color(0, 0, 0));
		btnTax.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnTax);

		// btnSalesret = new JButton("Sales Return");
		btnSalesret = new gnRoundButton("Sales Return");

		btnSalesret.setBackground(new Color(255, 255, 255));
		btnSalesret.setBounds(12, 50, 175, 25);
		btnSalesret.setForeground(new Color(0, 0, 0));
		btnSalesret.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnSalesret);

		btnCrnote = new JButton("Credit Note");
		btnCrnote.setBackground(new Color(255, 255, 255));
		btnCrnote.setBounds(12, 74, 175, 25);
		btnCrnote.setForeground(new Color(0, 0, 0));
		btnCrnote.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnCrnote);

		btnSalIntra = new JButton("Intra-State Sales");
		btnSalIntra.setBackground(new Color(255, 255, 255));
		btnSalIntra.setBounds(12, 123, 175, 25);
		btnSalIntra.setForeground(new Color(0, 0, 0));
		btnSalIntra.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnSalIntra);

		btnSaleInter = new JButton("Inter State Sales");
		btnSaleInter.setBackground(new Color(255, 255, 255));
		btnSaleInter.setBounds(12, 148, 175, 25);
		btnSaleInter.setForeground(new Color(0, 0, 0));
		btnSaleInter.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnSaleInter);

		btncustAdv = new JButton("Customer Advance");
		btncustAdv.setBackground(new Color(255, 255, 255));
		btncustAdv.setBounds(12, 98, 175, 25);
		btncustAdv.setForeground(new Color(0, 0, 0));
		btncustAdv.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btncustAdv);

		btnPurchase = new JButton("Purchase");
		btnPurchase.setBackground(new Color(255, 255, 255));
		btnPurchase.setBounds(12, 175, 175, 25);
		btnPurchase.setMnemonic('P');
		btnPurchase.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnPurchase);

		btnPurRet = new JButton("Purchase Return");
		btnPurRet.setBackground(new Color(255, 255, 255));
		btnPurRet.setBounds(12, 229, 175, 25);
		btnPurRet.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnPurRet);

		btnReverse = new JButton("Rev. Charge-Purchase");
		btnReverse.setBackground(new Color(255, 255, 255));
		btnReverse.setBounds(12, 255, 175, 25);
		btnReverse.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnReverse);

		btnSuplAdv = new JButton("Supplier Advance");
		btnSuplAdv.setBackground(new Color(255, 255, 255));
		btnSuplAdv.setBounds(12, 307, 175, 25);
		btnSuplAdv.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnSuplAdv);

		btnDrnote = new JButton("Debit Note");
		btnDrnote.setBackground(new Color(255, 255, 255));
		btnDrnote.setBounds(12, 282, 175, 25);
		btnDrnote.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnDrnote);

		btnPurTax = new JButton("BillWise-Purchase");
		btnPurTax.setBackground(new Color(255, 255, 255));
		btnPurTax.setBounds(12, 201, 175, 25);
		btnPurTax.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnPurTax);

		btnintrapur = new JButton("Intra-Sate Purchase");
		btnintrapur.setBackground(new Color(255, 255, 255));
		btnintrapur.setBounds(12, 330, 175, 25);
		btnintrapur.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btnintrapur);

		btninterpur = new JButton("Inter State Purchase");
		btninterpur.setBackground(new Color(255, 255, 255));
		btninterpur.setBounds(12, 355, 175, 25);
		btninterpur.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lpanel.add(btninterpur);

		JButton btnNewButton = new JButton(" ");
		btnNewButton.setBounds(0, 0, 9, 527);
		btnNewButton.setIcon(new ImageIcon(GST_Reports.class.getResource("/RetailProduct/panel.png")));
		lpanel.add(btnNewButton);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnpurtax = new JButton("Purchase Tax Summary");
		btnpurtax.setBackground(new Color(255, 255, 255));
		btnpurtax.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnpurtax.setBounds(12, 408, 177, 25);
		lpanel.add(btnpurtax);

		btnsaletax = new JButton("Sales Tax Summary");
		btnsaletax.setBackground(new Color(255, 255, 255));
		btnsaletax.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		btnsaletax.setBounds(12, 381, 175, 25);
		lpanel.add(btnsaletax);

		btntaxalldoc = new JButton("Tax Sumry For All Docs");
		btntaxalldoc.setBackground(new Color(255, 255, 255));
		btntaxalldoc.setFont(new Font("Arial", Font.PLAIN, 12));
		btntaxalldoc.setBounds(12, 434, 175, 25);
		lpanel.add(btntaxalldoc);

		GSTReportFrame.getContentPane().add(mysplit);
		mysplit.setDividerLocation(200);
		mysplit.setContinuousLayout(true);

		label = new JLabel("GST - Scheme");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(219, 36, 127, 16);
		label.setForeground(new Color(0, 0, 102));
		label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		GSTReportFrame.getContentPane().add(label);

		scheme = new JTextField();
		scheme.setFont(new Font("MS Gothic", Font.BOLD, 13));
		scheme.setBounds(355, 30, 273, 30);
		scheme.setText((String) null);
		scheme.setForeground(new Color(0, 0, 139));
		scheme.setEditable(false);
		scheme.setColumns(10);
		scheme.setBackground(Color.WHITE);
		GSTReportFrame.getContentPane().add(scheme);

		label_1 = new JLabel("Return File Schedule");
		label_1.setBounds(206, 65, 144, 16);
		label_1.setForeground(new Color(0, 0, 102));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		GSTReportFrame.getContentPane().add(label_1);

		schedule = new JTextField();
		schedule.setForeground(new Color(0, 0, 139));
		schedule.setBounds(355, 55, 273, 30);
		schedule.setFont(new Font("MS Gothic", Font.BOLD, 13));
		schedule.setEditable(false);
		schedule.setColumns(10);
		schedule.setBackground(Color.WHITE);
		GSTReportFrame.getContentPane().add(schedule);

		companyname = new JTextField();
		companyname.setHorizontalAlignment(SwingConstants.LEFT);
		companyname.setBounds(354, 0, 348, 30);
		companyname.setText((String) null);
		companyname.setForeground(new Color(0, 0, 139));
		companyname.setFont(new Font("Arial", Font.BOLD, 14));
		companyname.setEditable(false);
		companyname.setColumns(10);
		companyname.setBackground(Color.WHITE);
		GSTReportFrame.getContentPane().add(companyname);
		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 102));
		panel.setBounds(675, 86, 649, 71);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 51, 51)), "Total ",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 51, 153)));
		GSTReportFrame.getContentPane().add(panel);

		label_3 = new JLabel("GSTIN");
		label_3.setBounds(284, 97, 62, 16);
		label_3.setForeground(new Color(0, 0, 102));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		GSTReportFrame.getContentPane().add(label_3);

		isgst = new JTextField();
		isgst.setBounds(355, 86, 26, 30);
		isgst.setText((String) null);
		isgst.setForeground(new Color(0, 0, 139));
		isgst.setFont(new Font("MS Gothic", Font.BOLD, 13));
		isgst.setEditable(false);
		isgst.setColumns(10);
		isgst.setBackground(Color.WHITE);
		GSTReportFrame.getContentPane().add(isgst);

		gstno = new JTextField();
		gstno.setBounds(384, 87, 244, 30);
		gstno.setText((String) null);
		gstno.setForeground(new Color(0, 0, 139));
		gstno.setFont(new Font("MS Gothic", Font.BOLD, 13));
		gstno.setEditable(false);
		gstno.setColumns(10);
		gstno.setBackground(Color.WHITE);
		GSTReportFrame.getContentPane().add(gstno);

		label_4 = new JLabel("State");
		label_4.setBounds(294, 124, 52, 16);
		label_4.setForeground(new Color(0, 0, 102));
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		GSTReportFrame.getContentPane().add(label_4);

		statecode = new JTextField();
		statecode.setBounds(355, 116, 27, 30);
		statecode.setText((String) null);
		statecode.setForeground(new Color(0, 0, 139));
		statecode.setFont(new Font("MS Gothic", Font.BOLD, 13));
		statecode.setEditable(false);
		statecode.setColumns(10);
		statecode.setBackground(Color.WHITE);
		GSTReportFrame.getContentPane().add(statecode);

		statename = new JTextField();
		statename.setBounds(384, 116, 244, 30);
		statename.setForeground(new Color(0, 0, 139));
		statename.setFont(new Font("MS Gothic", Font.BOLD, 13));
		statename.setEditable(false);
		statename.setColumns(10);
		statename.setBackground(Color.WHITE);
		GSTReportFrame.getContentPane().add(statename);
		panel.setLayout(null);

		// tvalue = new JTextField();
		tvalue = new gnRoundTextField(20);
		tvalue.setBounds(12, 29, 91, 29);
		panel.add(tvalue);
		tvalue.setBackground(Color.WHITE);
		tvalue.setEditable(false);
		tvalue.setFont(new Font("Tahoma", Font.BOLD, 13));
		tvalue.setForeground(new Color(0, 51, 102));
		tvalue.setColumns(10);

		// txbalval = new JTextField();
		txbalval = new gnRoundTextField(20);
		txbalval.setBounds(121, 29, 95, 29);
		panel.add(txbalval);
		txbalval.setBackground(Color.WHITE);
		txbalval.setEditable(false);
		txbalval.setFont(new Font("Tahoma", Font.BOLD, 13));
		txbalval.setForeground(new Color(0, 51, 102));
		txbalval.setColumns(10);

		// taxamt = new JTextField();
		taxamt = new gnRoundTextField(20);
		taxamt.setBounds(228, 29, 91, 29);
		panel.add(taxamt);
		taxamt.setBackground(Color.WHITE);
		taxamt.setEditable(false);
		taxamt.setFont(new Font("Tahoma", Font.BOLD, 13));
		taxamt.setForeground(new Color(0, 51, 102));
		taxamt.setColumns(10);

		// tcgst = new JTextField();
		tcgst = new gnRoundTextField(20);
		tcgst.setBounds(331, 29, 103, 29);
		panel.add(tcgst);
		tcgst.setBackground(Color.WHITE);
		tcgst.setEditable(false);
		tcgst.setFont(new Font("Tahoma", Font.BOLD, 13));
		tcgst.setForeground(new Color(0, 51, 102));
		tcgst.setColumns(10);

		// tsgst = new JTextField();
		tsgst = new gnRoundTextField(20);
		tsgst.setBounds(446, 29, 89, 29);
		panel.add(tsgst);
		tsgst.setBackground(Color.WHITE);
		tsgst.setEditable(false);
		tsgst.setFont(new Font("Tahoma", Font.BOLD, 13));
		tsgst.setForeground(new Color(0, 51, 102));
		tsgst.setColumns(10);

		// tigst = new JTextField();
		tigst = new gnRoundTextField(20);

		tigst.setBounds(547, 29, 83, 29);
		panel.add(tigst);
		tigst.setBackground(Color.WHITE);
		tigst.setEditable(false);
		tigst.setFont(new Font("Tahoma", Font.BOLD, 13));
		tigst.setForeground(new Color(0, 51, 102));
		tigst.setColumns(10);

		lblNewLabel_1 = new JLabel("Value");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setBounds(12, 13, 55, 16);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Taxable Val");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setBounds(123, 13, 93, 16);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Tax Amt");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_3.setBounds(230, 13, 89, 16);
		panel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("CGST Tax");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setBounds(343, 13, 91, 16);
		panel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("SGST Tax");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setForeground(new Color(0, 0, 102));
		lblNewLabel_5.setBounds(446, 13, 89, 16);
		panel.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("IGST Tax");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setForeground(new Color(0, 0, 102));
		lblNewLabel_6.setBounds(555, 13, 75, 16);
		panel.add(lblNewLabel_6);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 56, 206, 93);
		panel_1.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(204, 255, 204)));
		panel_1.setBackground(new Color(204, 51, 153));
		GSTReportFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel fromdate = new JLabel("From ");
		fromdate.setBounds(12, 32, 45, 16);
		panel_1.add(fromdate);
		fromdate.setHorizontalAlignment(SwingConstants.RIGHT);
		fromdate.setForeground(Color.WHITE);
		fromdate.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel todate = new JLabel("To");
		todate.setBounds(22, 61, 35, 16);
		panel_1.add(todate);
		todate.setHorizontalAlignment(SwingConstants.RIGHT);
		todate.setForeground(Color.WHITE);
		todate.setFont(new Font("Tahoma", Font.BOLD, 14));

		from = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		from.setBounds(66, 26, 116, 22);
		panel_1.add(from);

		from.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		from.setColumns(10);

		to = new JTextField();
		to.setBounds(66, 55, 116, 22);
		panel_1.add(to);
		to.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		to.setColumns(10);

		btnExport = new JButton("Export Data");
		btnExport.setMnemonic('E');
		btnExport.setBounds(924, 7, 160, 45);
		GSTReportFrame.getContentPane().add(btnExport);
		btnExport.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnExport.setBackground(Color.WHITE);

		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnClose.setIcon(new ImageIcon(GST_Reports.class.getResource("/RetailProduct/delete.png")));
		btnClose.setMnemonic('C');
		btnClose.setBounds(1086, 7, 144, 45);
		GSTReportFrame.getContentPane().add(btnClose);

		JLabel lblNewLabel_7 = new JLabel("GST DATA");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(40, 17, 112, 27);
		GSTReportFrame.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel(" ");
		lblNewLabel_8.setIcon(new ImageIcon(GST_Reports.class.getResource("/RetailProduct/panel12.png")));
		lblNewLabel_8.setBounds(1, 2, 200, 57);
		GSTReportFrame.getContentPane().add(lblNewLabel_8);

		ActionListener btn = new btnLsnr();

		btnpurtax.addActionListener(btn);
		btnsaletax.addActionListener(btn);
		btntaxalldoc.addActionListener(btn);

		btnSales.addActionListener(btn);
		btnPurchase.addActionListener(btn);
		btnSalesret.addActionListener(btn);
		btnPurRet.addActionListener(btn);
		btnReverse.addActionListener(btn);
		btncustAdv.addActionListener(btn);
		btnSuplAdv.addActionListener(btn);
		btnDrnote.addActionListener(btn);
		btnCrnote.addActionListener(btn);
		btnTax.addActionListener(btn);
		btnPurTax.addActionListener(btn);
		btnSalIntra.addActionListener(btn);
		btnSaleInter.addActionListener(btn);
		btnintrapur.addActionListener(btn);
		btninterpur.addActionListener(btn);
		btnClose.addActionListener(btn);
		btnExport.addActionListener(btn);
		btnTaxExport.addActionListener(btn);
 
		ActionListener frmLsnr = new fromLsnr();
		ActionListener toLsnr = new toLsnr();
		to.addActionListener(toLsnr);
		from.addActionListener(frmLsnr);
		decorate();

	}

	public void Selectrow(JButton btnname) {
		btnname.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		btnname.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					String vname = btnname.getText();
					setButtonAction(vname);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
					// new General().msgDispose();
			}
		});
		// stable.setSurrendersFocusOnKeystroke(true);
		// new General().msgsearch(sjsp, stable, "Select Data ", 950, 300);
	}

	class fromLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				from.setText(new gnDate().getmefullDate(from.getText()));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class toLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				to.setText(new gnDate().getmefullDate(to.getText()));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void decorate() throws Throwable {

		GSTReportFrame.setUndecorated(true);
 		
		panel.setVisible(false);
  		from.setText(new gnFinYear().getFirstDateofFinYear());
		to.setText(new gnFinYear().getLastDateofFinYear());

		new gnApp().setFrameTitel(GSTReportFrame);
		new gnField().closeform(lpanel, GSTReportFrame);
		new gnField().closeform(rpanel, GSTReportFrame);

		// new gnApp().setCompanyTitle(internalFrame);
		companyname.setText(new gnConfig().getCompany());
		gstno.setText(new gnGST().getComanyGSTno());

 		isgst.setText(new gnGST().ismyComanyGSTRegister());
		statecode.setText(new gnGST().getmyState());
		statename.setText(new gnGST().getmystatename());
		scheme.setText(new gnGST().gst_getmytaxscheme());
		String vschmetype = new gnGST().gst_getmytaxschemecode();
		switch (vschmetype) {
		case "0":
			schedule.setText("No Return File");
			break;
		case "1":
			schedule.setText("Quatarly  Return File");
			break;
		case "2":
			schedule.setText("Monthly  Return File");
		}
		Selectrow(btnSales);
		Selectrow(btnSaleInter);
		Selectrow(btnTax);
		Selectrow(btnReverse);
		Selectrow(btnSalesret);
		Selectrow(btnCrnote);
		Selectrow(btnSalIntra);
		Selectrow(btncustAdv);
		Selectrow(btnPurchase);
		Selectrow(btnPurRet);
		Selectrow(btnSuplAdv);
		Selectrow(btnDrnote);
		Selectrow(btnPurTax);
		Selectrow(btnintrapur);
		Selectrow(btninterpur);
		Selectrow(btnSaleInter);
		// 120, 151, 112
		new gnDecorate().decorateBtn(btnintrapur, new Color(153, 51, 153), Color.WHITE);
		new gnDecorate().decorateBtn(btnPurTax, new Color(153, 51, 153), Color.black);
		new gnDecorate().decorateBtn(btnDrnote, new Color(153, 51, 153), Color.WHITE);
		new gnDecorate().decorateBtn(btnSuplAdv, new Color(153, 51, 153), Color.WHITE);
		new gnDecorate().decorateBtn(btnSales, new Color(153, 51, 153), Color.WHITE);
		new gnDecorate().decorateBtn(btnSaleInter, new Color(120, 151, 112), Color.BLUE);
		new gnDecorate().decorateBtn(btninterpur, new Color(153, 51, 153), Color.BLUE);
		new gnDecorate().decorateBtn(btnSales, new Color(153, 51, 153), Color.BLUE);
		new gnDecorate().decorateBtn(btnSaleInter, new Color(153, 51, 153), Color.black);
		new gnDecorate().decorateBtn(btnTax, new Color(153, 51, 153), Color.black);
		new gnDecorate().decorateBtn(btnReverse, new Color(153, 51, 153), Color.BLUE);
		new gnDecorate().decorateBtn(btnSalesret, new Color(153, 51, 153), Color.WHITE);
		new gnDecorate().decorateBtn(btnCrnote, new Color(153, 51, 153), Color.WHITE);
		new gnDecorate().decorateBtn(btnPurRet, new Color(153, 51, 153), Color.WHITE);
		new gnDecorate().decorateBtn(btnPurchase, new Color(153, 51, 153), Color.black);
		new gnDecorate().decorateBtn(btncustAdv, new Color(153, 51, 153), Color.WHITE);
		new gnDecorate().decorateBtn(btnSalIntra, new Color(153, 51, 153), Color.black);
		new gnDecorate().decorateBtn(btnSaleInter, new Color(153, 51, 153), Color.WHITE);
		new gnDecorate().decorateBtn(btnTaxExport, new Color(153, 51, 153), Color.WHITE);
		new gnDecorate().decorateBtn(btnpurtax, new Color(153, 51, 153), Color.black);
		new gnDecorate().decorateBtn(btnsaletax, new Color(153, 51, 153), Color.WHITE);
		new gnDecorate().decorateBtn(btntaxalldoc, new Color(153, 51, 153), Color.WHITE);

		/*
		 * new gnStyleButtonSqr().getStyleButton(btnPurTax,new Color(178, 11,
		 * 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btnDrnote,new Color(178, 11, 112) ,
		 * Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnSuplAdv, new
		 * Color(153,51,153) , Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnPurchase, new Color(131, 211,
		 * 112), Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnSales,new Color(178, 11, 112) ,
		 * Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnSaleInter,
		 * new Color(153,51,153) , Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnTax, new Color(131, 211, 112),
		 * Color.BLACK) ; new gnStyleButtonSqr().getStyleButton(btnReverse,new
		 * Color(178, 11, 112) , Color.WHITE) ; new
		 * gnStyleButtonSqr().getStyleButton(btncustAdv, new Color(153,51,153) ,
		 * Color.BLACK) ; new gnStyleButtonSqr().getStyleButton(btnPurchase, new
		 * Color(131, 211, 112), Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnSalesret,new Color(178, 11, 112)
		 * , Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btnCrnote, new
		 * Color(153,51,153) , Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnPurRet, new Color(131, 211,
		 * 112), Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnintrapur,new Color(178, 11, 112)
		 * , Color.WHITE) ; new gnStyleButtonSqr().getStyleButton(btncustAdv,
		 * new Color(153,51,153) , Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnPurchase, new Color(131, 211,
		 * 112), Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnSaleInter, new Color(153,51,153)
		 * , Color.BLACK) ; new gnStyleButtonSqr().getStyleButton(btnSalIntra,
		 * new Color(131, 211, 112), Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnTaxExport, new Color(131, 211,
		 * 112), Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btnsaletax, new Color(153,51,153) ,
		 * Color.BLACK) ; new gnStyleButtonSqr().getStyleButton(btnpurtax, new
		 * Color(131, 211, 112), Color.BLACK) ; new
		 * gnStyleButtonSqr().getStyleButton(btntaxalldoc, new Color(131, 211,
		 * 112), Color.BLACK) ;
		 */

		btnPurTax.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDrnote.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSuplAdv.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPurchase.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSales.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSaleInter.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTax.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnReverse.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btncustAdv.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPurchase.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSalesret.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCrnote.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPurRet.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnintrapur.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btncustAdv.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPurchase.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSaleInter.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSalIntra.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTaxExport.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnsaletax.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnpurtax.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btntaxalldoc.setCursor(new Cursor(Cursor.HAND_CURSOR));

		new gnStyleButton().getStyleButton(btnClose, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnExport, new Color(156, 211, 112), Color.WHITE);

	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			setButtonAction(value);
		}
	}

	private void setButtonAction(String value) {
		switch (value) {

		case "Purchase Tax Summary":
			vtype = "PurTax";
			break;
		case "Sales Tax Summary":
			vtype = "SaleTax";
			break;
		case "Tax Sumry For All Docs":
			vtype = "AllDoc";
			break;
		case "Export Tax Data":
			exportData1();
			break;

		case "Export Data":
			exportData();
			break;
		case "Sales":
			btnno = 1;
			vtype = "SALE";
			break;
		case "Sales-BillWise Details":
			btnno = 2;
			vtype = "SalesBillWise";
			break;
		case "Sales Return":
			btnno = 3;
			vtype = "SR";
			break;
		case "Credit Note":
			btnno = 4;
			vtype = "CN";
			break;
		case "Intra-State Sales":
			btnno = 5;
			vtype = "IntraSales";
			break;
		case "Inter State Sales":
			btnno = 6;
			vtype = "InterSales";
			break;
		case "Customer Advance":
			btnno = 7;
			vtype = "CustAdv";
			break;

		// Purchase
		case "Close":
			GSTReportFrame.dispose();
			break;
		case "Purchase":
			btnno = 8;
			vtype = "Purchase";
			break;

		case "Purchase Return":
			btnno = 9;
			vtype = "PR";
			break;

		case "Rev. Charge-Purchase":
			btnno = 10;
			vtype = "RevPurchase";
			break;

		case "Supplier Advance":
			btnno = 11;
			vtype = "SuplAdv";
			break;

		case "BillWise-Purchase":
			btnno = 12;
			vtype = "PurchaseBillWise";
			break;

		case "Debit Note":
			btnno = 13;
			vtype = "DN";
			break;

		case "Intra-Sate Purchase":
			btnno = 14;
			vtype = "IntraPur";
			break;

		case "Inter State Purchase":
			btnno = 15;
			vtype = "InterPur";
			break;
		}
		try {
			String vstatus = new gnFinYear().checkDateRanegforFinyear(from.getText(), to.getText());
			if (vstatus == "Sucess") {
				processRequest(vtype);
			}
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void processRequest(String vtype) throws Throwable {

		vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
		vto = new gnConfig().date_ConverttoDBforamt(to.getText());
		vcomp = new gnConfig().getCompanyCode();
		String SQL = "";
		String col1[] = { "Type", "Date", "Tax Rate", "Doc Value", "Value", "Taxable Value", "Tax Amount", "CGST",
				"SGST", "IGST" };
		String col2[] = { "Type", "Date", "Tax Rate", "Invoice No", "Doc Value", "Value", "Taxable Value", "Tax Amount",
				"CGST", "SGST", "IGST" };
		String col3[] = { "Type", "Company", "GSTNO", "DocType", "Month", "Year", "TaxRate", "TaxableValue",
				"TaxPayable", "CGST", "SGST", "IGST" };

		String vstore = new gnConfig().getStorecode();
		new gnTable().RemoveTableRows(model);
		switch (vtype) {
		// Purchase
		case "PurTax":
			vtype = "Purchase";
			SQL = "call GST_TaxSummary( '" + vtype + "' , " + vcomp + ",  " + vstore + " , '" + vfrom + "', '" + vto
					+ "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col3, 11, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;

		case "SaleTax":
			vtype = "SALE";
			SQL = "call GST_TaxSummary( '" + vtype + "' , " + vcomp + ",  " + vstore + " , '" + vfrom + "', '" + vto
					+ "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col3, 11, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;
		case "AllDoc":
			vtype = "ALL";
			SQL = "call GST_TaxSummary( '" + vtype + "' , " + vcomp + ",  " + vstore + " , '" + vfrom + "', '" + vto
					+ "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col3, 11, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;

		case "IntraPur":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			// String col1[] = {"Type" , "Date" , "Tax Rate" , "Doc Value" ,
			// "Value" , "Taxable Value" , "Tax Amount" , "CGST" , "SGST" ,
			// "IGST" } ;
			new gnTable().RemoveTableRows(smodel);
			break;

		case "InterPur":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;

		case "Purchase":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			showPurchaseTaxBreakup();
			break;

		case "PurchaseBillWise":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col2, 10, "N", "Y", vtype);
			vmode = "B";
			showPurchaseTaxBreakup();
			break;

		case "PR":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;

		case "DN":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;

		case "SuplAdv":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;

		case "RevPurchase":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;

		// Prchase

		case "SALE":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			showSalesTaxBreakup();
			break;
		case "SalesBillWise":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col2, 10, "N", "Y", vtype);
			vmode = "B";
			showSalesTaxBreakup();
			break;
		case "SR":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;
		case "CN":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;
		case "IntraSales":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;
		case "InterSales":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;
		case "CustAdv":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;

		}
		table.setModel(model);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		new gnTable().setTableBasics(table);
		JViewport prt = new JViewport();
		prt.setBackground(Color.WHITE);
		prt.add(table, col1);
		prt.setVisible(true);
		jsp.setViewport(prt);
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);

		new gnTable().setFontBold(table, 11);
		panel.setVisible(true);
		switch (vmode) {
		case "C":
			  
					
			tvalue.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 4))));
			txbalval.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 5))));
			taxamt.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 6))));
			tcgst.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 7))));
			tsgst.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 8))));
			tigst.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 9))));
			break;
		case "B":
			tvalue.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 5))));
			txbalval.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 6))));
			taxamt.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 7))));
			tcgst.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 8))));
			tsgst.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 9))));
			tigst.setText(new gnMath().get2DecimaltValue(Double.toString(new gnTable().getTotal(table, 10))));
			break;
		}
		if (table.getRowCount() > 0) {
			Selectrow();
		}
	}

	public void Selectrow() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.requestFocus();
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {
					display(row, value);
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
		int ColNo = 0;
		String vtype = "";

		switch (value) {
		case "SalesBillWise":
			String vdocno = table.getValueAt(row, 3).toString();
			String vdocdate = (table.getValueAt(row, 1).toString());
			new gnSale().showinvoice(vdocno, vdocdate);
			break;
		case "PurchaseBillWise":
			vdocno = table.getValueAt(row, 3).toString();
			vdocdate = (table.getValueAt(row, 1).toString());
			try {
				new gnGrn().viewGrn(vdocno, vdocdate);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	private void exportData() {
		new Export_Table_Data_to_Excel().exportTable(table);

	}

	private void exportData1() {
		new Export_Table_Data_to_Excel().exportTable(stable);

	}

	private void showSalesTaxBreakup() throws ClassNotFoundException, SQLException {
		String coltax[] = { "Type", "Tax%", "Doc Value", "Taxable Value", "Tax Amount", "CGST", "SGST", "IGST" };
		new gnTable().RemoveTableRows(smodel);
		String vtype = "Tax-SaleBreakup";
		String SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, coltax, 7, "N", "Y", vtype);

		stable.setModel(smodel);
		new gnTable().setTableBasics(stable);
		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.WHITE);
		prt1.add(stable, coltax);
		prt1.setVisible(true);
		jsp1.setViewport(prt1);

	}

	private void showPurchaseTaxBreakup() throws ClassNotFoundException, SQLException {

		String coltax[] = { "Type", "Tax%", "Doc Value", "Taxable Value", "Tax Amount", "CGST", "SGST", "IGST" };
		new gnTable().RemoveTableRows(smodel);
		String vtype = "Tax-PurBreakup";
		String SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, coltax, 7, "N", "Y", vtype);

		stable.setModel(smodel);
		new gnTable().setTableBasics(stable);
		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.WHITE);
		prt1.add(stable, coltax);
		prt1.setVisible(true);
		jsp1.setViewport(prt1);
	}
}// Last

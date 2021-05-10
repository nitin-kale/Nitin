package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.NumberFormatter;

import RetailProduct.POS.discitemLsnr;
import RetailProduct.POS.discperLsnr;
import RetailProduct.POS.expDate;
import RetailProduct.POS.myitemcodeLsnr;
import RetailProduct.POS.qtyLsnr;
import RetailProduct.POS.spLsnr;
import RetailProduct.viewCustomer.suplLsnr;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class RentedSalesModule extends getResultSet {

	JFrame rensalesFrame;

	//
	double vfreegivenqty = 0.0;
	String xvpromotypecode = "";
	String Promohdrdisc = "N";
	String xvmypromoArticle = "";
	String xvfreeQty = "";
	String vlocation;
	String vprompTypecode = "";
	JComboBox<String> SalesType;
	String xvarticle = "0";
	String xvapply = "";
	double vmanualdisc = 0.0;
	int paycount = 0;
	String xvdiscper = "";
	String xvdiscamt = "";
	String xvfrom;
	String xvbillqty;
	String xvfreeArticle;
	String xvbillvalue;
	String xvto;

	//
	JSplitPane mysplit;
	JPanel upperPanel;
	JPanel lowerPanel;
	JTabbedPane tabbedPane;
	private JTextField docdate;
	public boolean process = true;
	String vallowday = "N";
	String QueryStatus = "N";
	String promoArticle;
	private JTextField docno;
	private JTextField doctype;
	private JTextField custname;
	private JTextField custcode;
	private JTextField eventdate;
	private JTextField eventdesc;
	private JTextField venue;
	private JTextField narration;
	private JTextField scanitem;
	private JTextField chnageqty;
	private JTextField changerate;
	private JTextField billhdrdiscper;
	private JTextField disc;

	String varticle;
	int selectedrow;
	String vcomp;
	String vstore;
	String vfinyear;
	String vallow;
	String vverticle;
	JScrollPane jsp;
	private JTextField phone;
	private JTextField returndate;

	private String Col[] = { "Romove", "Item", "Name", "Qty", "Rate", "MRP", "Gross", "Manual.Disc", "Bill Disc",
			"Disc", "Tax", "Amount", "Taxcode", "Batch Item", "BatchNo", "Return Date", "Free(Qty)/Disc" };

	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			String vpara715 = "715";
			String vpara811 = "811";
			try {
				String allow = new getConfigurationSetting().getSpecificConfiguration(vpara715);
				switch (allow) {
				case "Y":
					return column == 0 || column == 3 || column == 4 || column == 7 || column == 12 || column == 14
							|| column == 15 ? true : false;
				case "N":
					return column == 0 || column == 3 || column == 7 || column == 12 || column == 14 || column == 15
							? true : false;
				}

				//
				String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811,
						compcode, vstore);
				switch (vmaintainbatchforNonBatchItem) {
				case "Y":
					if (getValueAt(row, 16).toString().equalsIgnoreCase("0")
							|| getValueAt(row, 14).toString().equalsIgnoreCase("")) {
						return column == 0 || column == 3 || column == 4 || column == 7 || column == 12 || column == 14
								|| column == 15 ? true : false;
					}
				}
				//

			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return process;
		}
	};

	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 4 || column == 7 || column == 12 || column == 14
					|| column == 15) {
				componentt.setBackground(Color.BLACK);
				componentt.setForeground(Color.WHITE);
				componentt.setCursor(getCursor());
				// componentt.setFont(new Font("Cambria", Font.PLAIN, 13));
				componentt.setFont(new Font("Century Schoolbook", Font.BOLD, 13));
			} else {
				componentt.setBackground(Color.DARK_GRAY);
				componentt.setForeground(Color.WHITE);
				componentt.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 11));

				if (getValueAt(roww, 13).toString().equalsIgnoreCase("N")) {
					componentt.setBackground(Color.CYAN);
					componentt.setForeground(Color.BLACK);
					componentt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
				} else if (getValueAt(roww, 13).toString().equalsIgnoreCase("Y")) {
					componentt.setBackground(Color.DARK_GRAY);
					componentt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
				}

				if (roww == 0) {
					componentt.setBackground(Color.BLACK);
					componentt.setForeground(Color.WHITE);
					componentt.setCursor(getCursor());
					componentt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
				}
			}
			if (Language == "H") {
				if (column == 2) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}

			if (getValueAt(roww, 16).toString().equalsIgnoreCase("discpercnt")) {
				componentt.setBackground(Color.DARK_GRAY);
				componentt.setForeground(Color.WHITE);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			}

			if (getValueAt(roww, 16).toString().equalsIgnoreCase("NB")) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			}

			if (getValueAt(roww, 16).toString().equalsIgnoreCase("discamt")) {
				componentt.setBackground(Color.gray);
				componentt.setForeground(Color.WHITE);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			}

			if (getValueAt(roww, 16).toString().equalsIgnoreCase("Branddisc")) {
				componentt.setBackground(Color.blue);
				componentt.setForeground(Color.WHITE);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			}

			if (getValueAt(roww, 16).toString().equalsIgnoreCase("Groupdisc")) {
				componentt.setBackground(Color.DARK_GRAY);
				componentt.setForeground(Color.WHITE);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			}

			if (getValueAt(roww, 16).toString().equalsIgnoreCase("SubGroupdisc")) {
				componentt.setBackground(Color.MAGENTA);
				componentt.setForeground(Color.WHITE);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			}

			if (getValueAt(roww, 16).toString().equalsIgnoreCase("FreeArticle")) {
				componentt.setBackground(Color.yellow);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			}

			if (getValueAt(roww, 16).toString().equalsIgnoreCase("BillLevel")) {
				componentt.setBackground(Color.BLUE);
				componentt.setForeground(Color.white);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			}
			return componentt;
		}
	};
	private JTextField netAmount;
	private JTextField manualdisc;
	private JTextField hdrDiscount;
	private JTextField Tamount;
	private JTextField record;
	private JTextField showqty;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RentedSalesModule window = new RentedSalesModule();
					window.rensalesFrame.setVisible(true);
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
	public RentedSalesModule() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		rensalesFrame = new JFrame();
		rensalesFrame.setAlwaysOnTop(true);
		rensalesFrame.setBounds(1, 1, 1350, 750);
		rensalesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		rensalesFrame.getContentPane().setLayout(null);

		mysplit = new JSplitPane();
		mysplit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		mysplit.setBounds(0, 0, 1320, 699);
		rensalesFrame.getContentPane().add(mysplit);

		upperPanel = new JPanel();
		mysplit.setLeftComponent(upperPanel);
		upperPanel.setLayout(null);

		JPanel up1Panel = new JPanel();
		up1Panel.setBounds(0, 0, 199, 101);
		upperPanel.add(up1Panel);
		up1Panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Doc.Date");
		lblNewLabel.setBounds(12, 13, 56, 16);
		up1Panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Doc.No");
		lblNewLabel_1.setBounds(12, 42, 56, 16);
		up1Panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Doc.Type");
		lblNewLabel_2.setBounds(12, 71, 56, 16);
		up1Panel.add(lblNewLabel_2);

		docdate = new JTextField();
		docdate.setEditable(false);
		docdate.setBounds(75, 10, 116, 25);
		up1Panel.add(docdate);
		docdate.setColumns(10);

		docno = new JTextField();
		docno.setEditable(false);
		docno.setBounds(75, 39, 116, 25);
		up1Panel.add(docno);
		docno.setColumns(10);

		doctype = new JTextField();
		doctype.setEditable(false);
		doctype.setText("Rent");
		doctype.setBounds(75, 68, 116, 25);
		up1Panel.add(doctype);
		doctype.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Rented Sales Module");
		lblNewLabel_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_3.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(327, 0, 168, 16);
		upperPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Customer");
		lblNewLabel_4.setBounds(200, 32, 56, 16);
		upperPanel.add(lblNewLabel_4);

		custname = new JTextField();
		custname.setBounds(266, 29, 230, 25);
		upperPanel.add(custname);
		custname.setColumns(10);

		custcode = new JTextField();
		custcode.setEditable(false);
		custcode.setBounds(495, 28, 56, 25);
		upperPanel.add(custcode);
		custcode.setColumns(10);

		JPanel up2Panel = new JPanel();
		up2Panel.setBorder(new LineBorder(new Color(0, 51, 0), 1, true));
		up2Panel.setBounds(553, 0, 561, 128);
		// upperPanel.add(up2Panel);
		up2Panel.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Event Date");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(25, 13, 93, 16);
		up2Panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Event Description");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(12, 42, 106, 16);
		up2Panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Venue");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(62, 66, 56, 16);
		up2Panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Narration");
		lblNewLabel_8.setBounds(62, 95, 56, 16);
		up2Panel.add(lblNewLabel_8);

		eventdate = new JTextField();
		eventdate.setBounds(133, 10, 116, 25);
		up2Panel.add(eventdate);
		eventdate.setColumns(10);

		eventdesc = new JTextField();
		eventdesc.setBounds(133, 39, 420, 25);
		up2Panel.add(eventdesc);
		eventdesc.setColumns(10);

		venue = new JTextField();
		venue.setBounds(133, 66, 420, 25);
		up2Panel.add(venue);
		venue.setColumns(10);

		narration = new JTextField();
		narration.setBounds(133, 95, 420, 25);
		up2Panel.add(narration);
		narration.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Goods Receive Date");
		lblNewLabel_15.setBounds(275, 13, 116, 16);
		up2Panel.add(lblNewLabel_15);

		returndate = new JTextField();
		returndate.setBounds(390, 10, 116, 25);
		up2Panel.add(returndate);
		returndate.setColumns(10);

		JPanel up3Panel = new JPanel();
		up3Panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 204, 51)));
		up3Panel.setBounds(0, 132, 1318, 37);
		upperPanel.add(up3Panel);
		up3Panel.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("Scan Item ");
		lblNewLabel_9.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(12, 10, 78, 16);
		up3Panel.add(lblNewLabel_9);

		scanitem = new JTextField();
		scanitem.setBounds(83, 0, 160, 37);
		up3Panel.add(scanitem);
		scanitem.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Qty");
		lblNewLabel_10.setBounds(289, 11, 31, 16);
		up3Panel.add(lblNewLabel_10);

		chnageqty = new JTextField();
		chnageqty.setBounds(332, 0, 66, 37);
		up3Panel.add(chnageqty);
		chnageqty.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Ratel");
		lblNewLabel_11.setBounds(410, 11, 56, 16);
		up3Panel.add(lblNewLabel_11);

		changerate = new JTextField();
		changerate.setBounds(467, 0, 78, 37);
		up3Panel.add(changerate);
		changerate.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Disc.%");
		lblNewLabel_12.setBounds(557, 11, 56, 16);
		up3Panel.add(lblNewLabel_12);

		billhdrdiscper = new JTextField();
		billhdrdiscper.setBounds(614, 0, 56, 37);
		up3Panel.add(billhdrdiscper);
		billhdrdiscper.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Disc Amt");
		lblNewLabel_13.setBounds(684, 10, 56, 16);
		up3Panel.add(lblNewLabel_13);

		disc = new JTextField();
		disc.setBounds(752, 0, 78, 37);
		up3Panel.add(disc);
		disc.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(1119, 2, 97, 36);
		up3Panel.add(btnSave);

		JButton btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(1221, 0, 97, 38);
		up3Panel.add(btnClose);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 181, 1318, 450);
		upperPanel.add(jsp);

		JLabel lblNewLabel_14 = new JLabel("Phone");
		lblNewLabel_14.setBounds(200, 63, 56, 16);
		upperPanel.add(lblNewLabel_14);

		phone = new JTextField();
		phone.setBounds(266, 60, 116, 25);
		upperPanel.add(phone);
		phone.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Gross");
		lblNewLabel_17.setBounds(1157, 13, 56, 16);
		upperPanel.add(lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel("Manual Disc.");
		lblNewLabel_18.setBounds(1126, 38, 72, 16);
		upperPanel.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("Bill Discount");
		lblNewLabel_19.setBounds(1126, 63, 72, 16);
		upperPanel.add(lblNewLabel_19);

		manualdisc = new JTextField();
		manualdisc.setBounds(1202, 35, 116, 22);
		upperPanel.add(manualdisc);
		manualdisc.setColumns(10);

		hdrDiscount = new JTextField();
		hdrDiscount.setBounds(1202, 60, 116, 22);
		upperPanel.add(hdrDiscount);
		hdrDiscount.setColumns(10);

		Tamount = new JTextField();
		Tamount.setBounds(1202, 10, 116, 22);
		upperPanel.add(Tamount);
		Tamount.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Bill Value");
		lblNewLabel_16.setBounds(1134, 105, 66, 25);
		upperPanel.add(lblNewLabel_16);
		lblNewLabel_16.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));

		netAmount = new JTextField();
		netAmount.setBounds(1202, 104, 116, 25);
		upperPanel.add(netAmount);
		netAmount.setColumns(10);

		froundAmt = new JTextField();
		froundAmt.setBounds(1202, 81, 116, 22);
		upperPanel.add(froundAmt);
		froundAmt.setColumns(10);

		JLabel lblNewLabel_22 = new JLabel("Ronding Amt.");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_22.setBounds(1114, 85, 84, 16);
		upperPanel.add(lblNewLabel_22);

		JLabel lblNewLabel_20 = new JLabel("Records");
		lblNewLabel_20.setBounds(940, 104, 56, 16);
		upperPanel.add(lblNewLabel_20);

		record = new JTextField();
		record.setBounds(996, 93, 39, 37);
		upperPanel.add(record);
		record.setColumns(10);

		showqty = new JTextField();
		showqty.setBounds(1066, 93, 50, 37);
		upperPanel.add(showqty);
		showqty.setColumns(10);

		JLabel lblNewLabel_21 = new JLabel("Qty");
		lblNewLabel_21.setBounds(1038, 109, 31, 16);
		upperPanel.add(lblNewLabel_21);

		JPanel pmtPanel = new JPanel();
		pmtPanel.setBackground(Color.WHITE);
		pmtPanel.setBorder(new LineBorder(Color.DARK_GRAY, 6, true));
		pmtPanel.setBounds(612, 0, 318, 600);

		lowerPanel = new JPanel();
		mysplit.setRightComponent(lowerPanel);
		lowerPanel.setLayout(null);
		mysplit.setDividerLocation(350);
		mysplit.setDividerSize(8);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 13, 1324, 600);
		lowerPanel.add(tabbedPane);

		JPanel showsHistory = new JPanel();
		showsHistory.setBorder(
				new TitledBorder(null, "History Sales View", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		showsHistory.setBounds(600, 35, 695, 160);
		showsHistory.setLayout(null);

		JPanel pendingHistory = new JPanel();
		pendingHistory.setBorder(
				new TitledBorder(null, "Pending Return Item List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pendingHistory.setBounds(600, 35, 695, 160);
		pendingHistory.setLayout(null);

		JPanel inventoryPanel = new JPanel();
		inventoryPanel
				.setBorder(new TitledBorder(null, "Check Stock", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		inventoryPanel.setBounds(600, 35, 695, 160);
		inventoryPanel.setLayout(null);

		tabbedPane.add("Payment Details ", pmtPanel);
		pmtPanel.setLayout(null);

		JLabel lblNewLabel_23 = new JLabel("Select Payment Mode");
		lblNewLabel_23.setBounds(12, 28, 137, 16);
		pmtPanel.add(lblNewLabel_23);

		JComboBox payCombo = new JComboBox();
		payCombo.setBounds(12, 57, 123, 22);
		pmtPanel.add(payCombo);

		custamountPaid = new JTextField();
		custamountPaid.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 12));
		custamountPaid.setBounds(147, 57, 116, 22);
		pmtPanel.add(custamountPaid);
		custamountPaid.setColumns(10);

		JLabel lblNewLabel_24 = new JLabel("Amount");
		lblNewLabel_24.setBounds(147, 28, 56, 16);
		pmtPanel.add(lblNewLabel_24);

		JLabel lblNewLabel_25 = new JLabel("Doc.No");
		lblNewLabel_25.setBounds(281, 28, 56, 16);
		pmtPanel.add(lblNewLabel_25);

		Final_Tamt = new JTextField();
		Final_Tamt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		Final_Tamt.setBounds(507, 25, 116, 31);
		pmtPanel.add(Final_Tamt);
		Final_Tamt.setColumns(10);

		Final_Pamt = new JTextField();
		Final_Pamt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		Final_Pamt.setBounds(507, 57, 116, 31);
		pmtPanel.add(Final_Pamt);
		Final_Pamt.setColumns(10);

		Final_Damt = new JTextField();
		Final_Damt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		Final_Damt.setBounds(507, 94, 116, 31);
		pmtPanel.add(Final_Damt);
		Final_Damt.setColumns(10);

		JLabel lblNewLabel_26 = new JLabel("Net Payable");
		lblNewLabel_26.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_26.setBounds(408, 28, 94, 16);
		pmtPanel.add(lblNewLabel_26);

		JLabel lblNewLabel_27 = new JLabel("Paid Amount");
		lblNewLabel_27.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_27.setBounds(408, 60, 94, 16);
		pmtPanel.add(lblNewLabel_27);

		JLabel lblNewLabel_28 = new JLabel("Due Amount");
		lblNewLabel_28.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_28.setBounds(408, 97, 94, 16);
		pmtPanel.add(lblNewLabel_28);

		JScrollPane Pjsp_1 = new JScrollPane();
		Pjsp_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		Pjsp_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Pjsp_1.setBounds(12, 127, 611, 106);
		pmtPanel.add(Pjsp_1);
		tabbedPane.add("Event Detail ", up2Panel);
		tabbedPane.add("Show Sales Histrory", showsHistory);
		tabbedPane.add("Show Pending Items", pendingHistory);
		tabbedPane.add("Check Stock", inventoryPanel);
		ActionListener supl = new suplLsnr();
		custname.addActionListener(supl);

		ActionListener itemcodeLsnr = new myitemcodeLsnr();
		scanitem.addActionListener(itemcodeLsnr);

		ActionListener lsdiscper = new discperLsnr();
		billhdrdiscper.addActionListener(lsdiscper);

		ActionListener lsdiscamt = new discitemLsnr();
		disc.addActionListener(lsdiscamt);

		decorate();
	}

	private void chekcFreezeYear() {
		switch (isFinyearFreeze) {
		case "Y":
			new General().msg("Accounting Year is Freezeed..You Can View Data Only..");
			break;
		}
	}

	private void rateEnable() {
		changerate.setText(null);
		changerate.setEnabled(true);
	}

	private void rateDisable() {
		changerate.setText(null);
		changerate.setEnabled(false);
		;
	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(rensalesFrame);
		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		vverticle = new gnHierarchy().getVerticleCode();

		//
		String vpara811 = "811";
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			rateDisable();
		}
		// SalesType.setSelectedItem("Sale");
		// btnSalesLike.setVisible(false);
		// btnpay.setVisible(false);
		this.checkInternet();
		chekcFreezeYear();
		// new gnField().showCalc(internalFrame, "CAL");
		// new gnField().showInventory(internalFrame, "INV");
		// new gnField().showCalc(internalFrame, "CAL");
		// new gnField().moveDown(table);
		// delTableRow(table, model, "POS");
		vverticle = new gnHierarchy().getVerticleCode();

		String vpara714 = "714";
		String vframeclosable = new getConfigurationSetting().getSpecificConfiguration(vpara714);
		switch (vpara714) {
		case "N":
			rensalesFrame.setUndecorated(false);
			break;
		case "Y":
			rensalesFrame.setUndecorated(true);
			break;
		}

		// btnDeclaration.setEnabled(false);
		// btn_SalesReturn.setEnabled(false);
		// new General().msg("Decorate is Runnig") ;
		// vdoccode = "0";
		// docname.setText();
		// patientName.setText();
		vallowday = new gnDate().checkDayBegin();
		switch (vallowday) {
		case "Y":

			// invno.setText(new gnSeq().getSeqno("5", "TR"));
			// new gnLogger().loggerInfoEntry("POS", "New Bill no Generated For
			// Sales ..."+" "+invno.getText()) ;
			// vglcode = new gnSeq().getGlcode("5", "TR");

			// POSFrame.setUndecorated(true);

			// PaymentWindow Popup Allow Config
			docdate.setText(new gnConfig().getDaybeginDate());
			String vtype = "SALE";
			String vallowDate = new gnDate().checkBackDateTrAllow(vtype, docdate.getText());
			switch (vallowDate) {
			case "N":
				docdate.setBackground(Color.RED);
				docdate.setForeground(Color.WHITE);
				new General().msg("Back Date For Transaction is not Allow..");
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				docdate.setText("?");
				// scanItem_2.setVisible(false);
				// scanName22.setVisible(false);
				break;
			}

			scanitem.grabFocus();
			new gnDecorate().DispField_Beval_int(Tamount, 1);
			new gnDecorate().DispField_Beval_int(netAmount, 1);
			new gnDecorate().DispField_Beval_int(hdrDiscount, 1);
			new gnDecorate().DispField_Beval_int(manualdisc, 1);
			new gnDecorate().setTextFieldBackgroud1(netAmount);
			new gnDecorate().setTextFieldBackgroud(netAmount);
			new gnDecorate().setTextFieldBackgroud1(hdrDiscount);
			new gnDecorate().setTextFieldBackgroud1(manualdisc);
			new gnDecorate().DispField_Beval_int(manualdisc, 1);
			new gnDecorate().setTextFieldBackgroud(manualdisc);
			new gnDecorate().setTextFieldBackgroud1(Tamount);
			String vvertname = this.verticlename;

			break;
		case "N":
			/// System.exit(0);
			rensalesFrame.dispose();
			break;
		}

		//

	}

	class myitemcodeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent r) {
			String value = r.getActionCommand();
			int i = r.getID(); // Field id
			if (i == 1001) {
				if (vallowday == "N") {
					rensalesFrame.dispose();
					new General().msg("Complete Day Begin First...");
					return;
				}
				String result = ValidateItem(value);
				if (result == "Sucess")
					try {
						value = value.trim();
						QueryStatus = "N";
						try {
							String nn1 = showTableData(value, model);
						} catch (Exception rr) {
							rr.printStackTrace();
						}
						// new General().msg(QueryStatus);
						if (QueryStatus == "N") {
							namesearch();
						}
						QueryStatus = "N";
					} catch (SQLException e1) {
						new General().msg(e1.getMessage());
						e1.printStackTrace();
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().msg("ShowTableData search/Scan Item" + " " + e1.getMessage());
					}
				return;
			} // Item Scan
		}
	}

	private void namesearch() {
		String sname = scanitem.getText().trim();
		sname = "%" + sname + "%";
		String vType = "Article";
		String vtrantype = "POS";
		try {
			if (varticle != null && varticle.length() > 0) {
				new gnAdmin().Search(vType, sname, varticle, vtrantype);
			}
		} catch (ClassNotFoundException | SQLException e1) {
			new General().msg(e1.getLocalizedMessage());
			e1.printStackTrace();
			try {
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
		} catch (Throwable e1) {
			e1.printStackTrace();
		} finally {
			try {
				// setSearchArticle() ;
				varticle = new gnAdmin().rArticle;
				if (varticle != "0") {
					showTableData(varticle, model);
					new gnAdmin().rArticle = "0";
					// scanName22.setText("");
					scanitem.grabFocus();
				}
				varticle = "0";
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class discperLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vdiscper = billhdrdiscper.getText();
			try {
				DistributeDiscountper(vdiscper);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class discitemLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			double vdisamt = Double.parseDouble(disc.getText());
			double vgross = 0.0;
			double vmygross = 0.0;
			String vmydiscper = null;
			// { "Romove", "Item", "Name", "Qty", "Rate", "MRP", "Gross", "Bill
			// Disc", "Disc", "Tax" ,
			// "Amount", "Taxcode", "Batch Item", "BatchNo", "Return Date",
			// "Free(Qty)/Disc" };
			int row = table.getRowCount();
			if (row > 0) {
				for (int i = 0; i < row; i++) {
					vgross = Double.parseDouble(table.getValueAt(i, 6).toString());
					vmygross = vmygross + vgross;
				}
				double vmydidcper = (vdisamt / vmygross) * 100;
				vmydiscper = new gnMath().get2DecimaltValue(Double.toString(vmydidcper));
			}
			new General().msg(vmydiscper);
			try {
				DistributeDiscountper(vmydiscper);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void DistributeDiscountper(String vvdiscper) throws Throwable {
		double vqty = 0.00;
		double vdiscper = Double.parseDouble(vvdiscper);
		double vgross = 0.00;
		double vdiscamt = 0.00;
		// { "Romove", "Item", "Name", "Qty", "Rate", "MRP", "Gross", "Bill
		// Disc", "Disc", "Tax" ,
		// "Amount", "Taxcode", "Batch Item", "BatchNo", "Return Date",
		// "Free(Qty)/Disc" };
		int row = table.getRowCount();
		if (row > 0) {
			for (int i = 0; i < row; i++) {
				vgross = Double.parseDouble(table.getValueAt(i, 6).toString());
				vdiscamt = vgross * vdiscper / 100;
				String vmydiscamt = new gnMath().get2DecimaltValue(Double.toString(vdiscamt));

				switch (Promohdrdisc) {
				case "Y":

					if (vprompTypecode == "3") {
						table.setValueAt(vmydiscamt, i, 8);
					} else {
						table.setValueAt(vmydiscamt, i, 9);
					}

					// QtychangeImapct(value, k);
					break;

				case "N":
					// QtychangeImapct(value, k);
					table.setValueAt(vmydiscamt, i, 7);
					break;
				}

			}
		}
		new gnLogger().loggerInfoEntry("GRN", "Hdr Discount Distributed- Sucess");
		recalculateData();
		calHdrDisocunt();
	}

	public void DistributeDiscountperForBillLevel(String vvdiscper) throws Throwable {
		double vqty = 0.00;
		double vdiscper = Double.parseDouble(vvdiscper);
		double vgross = 0.00;
		double vdisc1 = 0.00;
		double vdisc2 = 0.00;

		double vdiscamt = 0.00;
		// { "Romove", "Item", "Name", "Qty", "Rate", "MRP", "Gross", "Bill
		// Disc", "Disc", "Tax" ,
		// "Amount", "Taxcode", "Batch Item", "BatchNo", "Return Date",
		// "Free(Qty)/Disc" };
		int row = table.getRowCount();
		if (row > 0) {
			for (int i = 0; i < row; i++) {
				vgross = Double.parseDouble(table.getValueAt(i, 6).toString());
				vdisc1 = Double.parseDouble(table.getValueAt(i, 7).toString());
				vdisc2 = Double.parseDouble(table.getValueAt(i, 9).toString());
				vgross = vgross - vdisc1 - vdisc2;
				vdiscamt = vgross * vdiscper / 100;
				String vmydiscamt = new gnMath().get2DecimaltValue(Double.toString(vdiscamt));
				switch (Promohdrdisc) {
				case "Y":

					if (vprompTypecode == "3") {
						table.setValueAt(vmydiscamt, i, 8);
					} else {
						table.setValueAt(vmydiscamt, i, 9);
					}
					// QtychangeImapct(value, k);
					break;
				case "N":
					// QtychangeImapct(value, k);
					table.setValueAt(vmydiscamt, i, 7);
					break;
				}
			}
		}
		new gnLogger().loggerInfoEntry("GRN", "Hdr Discount Distributed- Sucess");
		recalculateData();
		calHdrDisocunt();
	}

	private void recalculateData() throws Throwable {
		new gnLogger().loggerInfoEntry("GRN", "Recalculation After Data Edit Over");
		int row1 = table.getRowCount();
		if (row1 > 0) {
			for (int k = 0; k < row1; k++) {
				String value = table.getValueAt(k, 1).toString();
				try {
					QtychangeImapct(value, k);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					new gnLogger().loggerInfoEntry("Sale", "Distribution Exception" + " " + e.getLocalizedMessage());
				}
			}
		}
	}

	public String showTableData(String value, DefaultTableModel model) throws Throwable {
		model.setColumnIdentifiers(Col);
		promoArticle = value;
		String neginvallow = "Y";
		String action = "Insert";
		String value1 = value;
		value1 = value;
		Object row[] = {};
		String SQL = "";
		String vtype = "";
		String vbatchArticle = null;
		neginvallow = checkAllowNegInv(value1);
		if (neginvallow == "Y") {
			String vpara707 = "707";
			String para707 = new getConfigurationSetting().getSpecificConfiguration(vpara707);
			switch (para707) {
			case "Y":
				action = checkArticleExist(value1);
				break;
			}
			if (action == "Insert") {
				new gnLogger().loggerInfoEntry("POS", "Item Scan is :" + value);
				// String vverticlecode = new gnHierarchy().getVerticleCode();
				String vpara811 = "811";
				String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
						vstore);
				switch (vmaintainbatchforNonBatchItem) {
				case "N":
					vtype = "POS";
					SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', " + vcomp + " , "
							+ vstore + " , '" + vfinyear + "' , " + vverticle + ")";
					new General().msg(SQL);
					break;
				case "Y":
					// rateDisable();
					// table.setEnabled(true);
					vtype = "POSFORBatchForNonBAtchItem"; // "POS" ;
					SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', " + vcomp + " , "
							+ vstore + " , '" + vfinyear + "' , " + vverticle + ")";
					// new General().msg(SQL);
					break;
				}
				table.setModel(model);
				rs = this.getSPResult(SQL);
				if (rs.next()) {
					String varticle = rs.getString(1);
					// AutodiscArticle = rs.getString(1);
					String vsp = rs.getString(4);
					int varticlereturn = Integer.parseInt(rs.getString(1));
					if (varticlereturn > 0) {
						if (Double.parseDouble(vsp) == 0.0) {
							// new General().Quickmsg("Please Update Price
							// Master ");
							new gnImageSound().playAlertSound();
							new gnImageSound().playAlertSound();
							new gnLogger().loggerInfoEntry("POS", "Please Update Price Master  ");
						}
						model.insertRow(0,
								new Object[] { new Boolean(false), rs.getString(1), rs.getString(2), rs.getString(3),
										rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
										rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),
										rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15),
										rs.getString(16) });
						QueryStatus = "Y";
						vbatchArticle = rs.getString(13);
						selectedrow = 0;
						CheckBatchArticle(value, vbatchArticle);
						new gnTable().setTablewidth(table, 2, 300);
						table.setModel(model);
						new gnLogger().loggerInfoEntry("POS",
								"Checking For Promo Applicablity For Article :" + varticle);
						table.setCursor(new Cursor(Cursor.HAND_CURSOR));
						varticle = "0";
						scanitem.setText(null);
						scanitem.grabFocus();
						// SelectrowforEdit();
					} // End if
				} // end While Rs

				Double itemtotal = new gnTable().getTotal(table, 6);
				Tamount.setText(Double.toString(itemtotal));
				Double vtotalqty = new gnTable().getTotal(table, 3);
				showqty.setText(Double.toString(vtotalqty));

				Double vmanualdisc = new gnTable().getTotal(table, 7);
				manualdisc.setText(Double.toString(vmanualdisc));

				Double vhdrdiscamt = new gnTable().getTotal(table, 8);
				Double vhdrdiscamt1 = new gnTable().getTotal(table, 9);
				vhdrdiscamt = vhdrdiscamt + vhdrdiscamt1;
				hdrDiscount.setText(Double.toString(vhdrdiscamt));
				calHdrDisocunt();
				// checkperBillLine();
				removeRow(model, table);
				new gnTable().setTableBasics(table);

				int vcount = table.getRowCount();
				record.setText(Integer.toString(vcount));
				table.getColumnModel().getColumn(2).setPreferredWidth(300);
				table.setRowHeight(27);
				table.setGridColor(Color.DARK_GRAY);
				table.setSelectionBackground(Color.blue);
				table.setSelectionForeground(Color.WHITE);

				// Promo Handling
				switch (promoModuleActivated) {
				case "Y":
					int nrow = table.getSelectedRow();
					String vqty = table.getValueAt(nrow, 3).toString();
					String vamt = table.getValueAt(nrow, 11).toString();
					// promoGatway(nrow, promoArticle, vqty, vamt,
					// "Article");
					vamt = netAmount.getText();
					// promoGatway(nrow, promoArticle, vqty, vamt,
					// "BillLevel");
					// pickDataForInsertforpromo() ;
					break;
				}
				// End Promo Handling
				DefaultCellEditor nk = new gnTable().cellEdit(table);
				nk.addCellEditorListener(ChangeNotification);
				table.setGridColor(Color.BLACK);
				this.closeconn();
				// switch (vverticlecode) {
				// case "7":
				// QtychangeImapct(value, taxslabrow);
				// break;

				// case "14":
				// QtychangeImapct(value, taxslabrow);
				// break;
				// }

			}
		}

		JViewport prt = new JViewport();
		prt.setForeground(Color.RED);
		prt.setBackground(new Color(51, 255, 255));
		prt.add(table, Col);
		prt.setBackground(Color.WHITE);
		prt.setVisible(true);
		jsp.setViewport(prt);
		jsp.setVisible(true);
		return "OK";

	} // ShowTableData

	public void calHdrDisocunt() {

		// private String Col[] = { "Romove", 1"Item", 2"Name", 3"Qty", 4"Rate",
		// 5"MRP",6 "Gross",7 "m.Disc",8 "Bill Disc",9 "Disc",10 "Tax" ,
		// 11"Amount",12 "Taxcode", 13"Batch Item", 14"BatchNo",15 "Exp.Date",16
		// "Free(Qty)/Disc" };
		double fhdrDiscount = 0;
		new gnTable().setTablewidth(table, 2, 300);

		Double itemtotal = new gnTable().getTotal(table, 6);
		Tamount.setText(new gnMath().get2DecimaltValue(Double.toString(itemtotal))); // Gross
																						// Amount

		Double vtotalqty = new gnTable().getTotal(table, 3);
		showqty.setText(new gnMath().get2DecimaltValue(Double.toString(vtotalqty)));

		Double vhdrdiscamt = new gnTable().getTotal(table, 8);
		Double vhdrdiscamt1 = new gnTable().getTotal(table, 9);
		vhdrdiscamt = vhdrdiscamt + vhdrdiscamt1;
		hdrDiscount.setText(new gnMath().get2DecimaltValue(Double.toString(vhdrdiscamt)));

		Double vmanualdisc = new gnTable().getTotal(table, 7);
		manualdisc.setText(new gnMath().get2DecimaltValue(Double.toString(vmanualdisc)));

		Double xTamount = Double.parseDouble(Tamount.getText());
		// new General().msg("Gross Value is :" + " "+xTamount) ;
		xTamount = Double.parseDouble(new gnMath().get2DecimaltValue(Double.toString(xTamount)));
		// new General().msg("Gross Value is :" + " "+xTamount) ;
		fhdrDiscount = Double.parseDouble(hdrDiscount.getText());
		vmanualdisc = Double.parseDouble(manualdisc.getText());
		double vnetAmt = xTamount - fhdrDiscount - vmanualdisc;
		int vnetAmtnew = (int) Math.round(vnetAmt);
		double vroundamt = (vnetAmtnew - vnetAmt);
		froundAmt.setText(Double.toString(vroundamt));
		netAmount.setText(Integer.toString(vnetAmtnew));
	}

	public String RecalculateAfterPormo(int i) throws Throwable {

		// private String Col[] = { "Romove", 1"Item", 2"Name", 3"Qty", 4"Rate",
		// 5"MRP",6 "Gross",7 "m.Disc",8 "Bill Disc",9 "Disc",10 "Tax" ,
		// 11"Amount",12 "Taxcode", 13"Batch Item", 14"BatchNo",15 "Exp.Date",16
		// "Free(Qty)/Disc" };

		String value = table.getValueAt(i, 1).toString();
		new gnLogger().loggerInfoEntry("POS", "User Editing Data Either for qty /  Rate /Discount for row" + " " + i);
		String vmyamount = "";
		String vtaxrate = "";
		String curqty1 = (String) table.getValueAt(i, 3).toString();
		double curqty = Double.parseDouble((curqty1));

		if (curqty == 0.0) {
			new General().msg(
					"< Qty > Can not be <0> {Do you Want to Remove Row.... Click On First Column in same Row.. ..}");
			table.setValueAt(1, i, 3);
			table.setEditingRow(i);
			table.setGridColor(Color.YELLOW);
		}

		String Csp1 = (String) table.getValueAt(i, 4);
		Double Csp = Double.parseDouble((String) Csp1);
		String Cemp_disc1 = (String) table.getValueAt(i, 7).toString();
		Double Cemp_disc = Double.parseDouble(Cemp_disc1);
		String Cdisc1 = (String) table.getValueAt(i, 8).toString();
		Double Cdisc = Double.parseDouble(Cdisc1);
		String Cdisc2 = (String) table.getValueAt(i, 9).toString();
		Double Cdisc22 = Double.parseDouble(Cdisc2);

		// Double vtax = Double.parseDouble(table.getValueAt(i, 11).toString());
		Double newqty = curqty;
		Double newgross = newqty * Csp;

		Double newAmount = (newgross - Cdisc - Cemp_disc - Cdisc22);
		table.setValueAt(newAmount, i, 11);

		// private String Col[] = { "Romove", 1"Item", 2"Name", 3"Qty", 4"Rate",
		// 5"MRP",6 "Gross",7 "m.Disc",8 "Bill Disc",9 "Disc",10 "Tax" ,
		// 11"Amount",12 "Taxcode", 13"Batch Item", 14"BatchNo",15 "Exp.Date",16
		// "Free(Qty)/Disc" };

		Double vtax = Double.parseDouble(table.getValueAt(i, 12).toString());
		Double newtax = new gnMath().CalTax_Sales(newAmount, vtax);
		table.setValueAt(newqty, i, 3);
		table.setValueAt(newgross, i, 6);
		table.setValueAt(newAmount, i, 11);
		table.setValueAt(newtax, i, 10);

		Double iTotal = new gnTable().getTotal(table, 11);
		Tamount.setText(Double.toString(iTotal));
		String action = "Updated";
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		new gnLogger().loggerInfoEntry("POS",
				" Editing Data Over for qty /  Rate /Discount for row" + " " + i + "Artilce " + value);

		/*
		 * // Calcuate Margin Vloilation rule// String vcheckMargin = "Y"; if
		 * (vcheckMargin == "Y") { String varticle = table.getValueAt(i,
		 * 1).toString(); // String vcost = table.getValueAt(i, 15).toString();
		 * String vcost = table.getModel().getValueAt(i, 15).toString(); String
		 * vsp = table.getValueAt(i, 4).toString(); String status = new
		 * gnMath().checkMargin(varticle, vcost, vsp); }
		 */
		// End Margin Calcultion
		scanitem.grabFocus();
		calHdrDisocunt();
		action = ValidateItemEntry();
		return action;

	}

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			// System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 1);
			try {

				QtychangeImapct(value, row);
			} catch (Throwable e2) {
				e2.printStackTrace();
				new gnLogger().loggerInfoEntry("POS", "Edit Qty or Rate->:" + " " + e2.getLocalizedMessage());
			}
			// String vbatchcontrol = (String) table.getValueAt(row, 12);
			try {
			} catch (Throwable e1) {
				new General().msg(e1.getMessage());
				e1.printStackTrace();
				new gnLogger().loggerInfoEntry("POS", "Edit Qty->:" + " " + e1.getLocalizedMessage());
			}
		}
	};
	private JTextField froundAmt;
	private JTextField custamountPaid;
	private JTextField Final_Tamt;
	private JTextField Final_Pamt;
	private JTextField Final_Damt;

	public void removeRow(DefaultTableModel xmodel, JTable xtable) {
		// new General().msg("I REached Here ") ;
		String vauthallow = "N";
		DefaultTableModel modelName = xmodel;
		JTable tableName = xtable;
		TableColumn Del = tableName.getColumnModel().getColumn(0);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setSelected(false);
		chkbox.setVisible(true);
		chkbox.setMargin(new Insets(0, 16, 0, 0));
		chkbox.setIconTextGap(0);
		chkbox.setBackground(new Color(255, 255, 255, 0));
		chkbox.setText("R");
		new gnLogger().loggerInfoEntry("POS", "Remove Item From Sales Table  ");
		Del.setCellRenderer(new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Del.setCellEditor(new DefaultCellEditor(chkbox));
				return chkbox;
			}
		});
		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int nn = e.getStateChange();
				if (nn == 2 && modelName == model) {
					int lastrow = tableName.getRowCount();
					if (lastrow > 0) {
						int r = tableName.getSelectedRow();
						int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
						if (option == 0) {
							// modelName.removeRow(r);
							String vpara714 = "714";
							try {
								String vframeclosable = new getConfigurationSetting()
										.getSpecificConfiguration(vpara714);
								switch (vframeclosable) {
								case "Y":
									int rowcnt = table.getRowCount();
									if (rowcnt > 1) {
										String vremark = "Record Removed";
										// updateAuditRecord(vremark, r) ;
										modelName.removeRow(r);
									}
									break;
								case "N":
									String vremark = "Record Removed";
									// updateAuditRecord(vremark, r) ;
									modelName.removeRow(r);
									break;
								}
							} catch (Throwable e1) {
								e1.printStackTrace();
							}

							Double v = new gnTable().getTotal(table, 10);
							Tamount.setText(Double.toString(v));
							int vcount = table.getRowCount();
							record.setText(Integer.toString(vcount));
							new gnLogger().loggerInfoEntry("POS",
									"Recalculating Billing Data After Row Remove Row No" + " " + r);
							calHdrDisocunt();
							new gnLogger().loggerInfoEntry("POS", "Article Billing Process Over");
							scanitem.grabFocus();
						}
					}
					return;
				}
				if (modelName == model && nn == 2) {
					int option = new General().msgInput(" Payment Row Will be Deleted Are You Sure ?");

					if (option == 0) {
						int q = tableName.getSelectedRow();
						modelName.removeRow(q);
					}
					return;
				}
				return;
			}
		});
	}

	public String CheckBatchArticle(String varticle, String vbatchcontrol) throws Throwable {
		// new General().msgDispose();
		String status = "Sucess";
		String vcost = "0";
		String vstorecode = vstore;
		String vcomp = new gnConfig().getCompanyCode();
		String vloc = "SL";
		String batch[] = { "BatchArticlce", "Item Code", "name", "cost", "SalesPrice", "Mrp", "Batchno", "Manuf_date",
				"Exp.Date", "Bal_Qty" };
		String vpara811 = "811";
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
				vstorecode);
		switch (vmaintainbatchforNonBatchItem) {
		case "N":
			try {
				new gnGetBatch().getBatchDetail(varticle, vbatchcontrol, vloc);
			} catch (Exception r) {
				new General().msg("My Exception :" + " " + r.getLocalizedMessage());
			} finally {
				if (Double.parseDouble(new gnGetBatch().salesPrice) > 0) {
					table.setValueAt(new gnGetBatch().batchno, selectedrow, 14);
					table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 15);
					table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 4);
					table.setValueAt(new gnGetBatch().mrp, selectedrow, 5);
					new gnGetBatch().resetValues();
					QtychangeImapct(varticle, selectedrow);
				}
			}
			break;
		case "Y":
			checkBatchforNonBatchItems(varticle, vbatchcontrol);
			break;
		}
		return status;
	}// Method End

	private void checkBatchforNonBatchItems(String varticle, String vbatchcontrol) throws Throwable {
		String vcost = "0";
		String vsp = table.getValueAt(selectedrow, 4).toString();
		String vmrp = table.getValueAt(selectedrow, 5).toString();
		String vloc = "SL";
		String stockAvailabe = "";
		String vtype = "";
		String vaction = new gnBatch().IsBatchAvailableForIsBatchAvailableforMrpandSP(varticle, vmrp, vsp);
		switch (vaction) {
		case "Y":
			stockAvailabe = new gnBatch().IsStockAvailabeForMrpandSP(varticle, vmrp, vsp);
			// new General().msg("Stock Available " +""+stockAvailabe);
			switch (stockAvailabe) {
			case "Y":
				vtype = "GZcase123";
				handleBatchNonZero(varticle, vbatchcontrol, vtype);
				break;
			case "N":
				vtype = "GZCase0";
				handleBatchZero(varticle, vbatchcontrol, vtype);
				break;
			}
			break;
		case "N": // For New Batch
			table.setValueAt(0, selectedrow, 14);
			double mybatch = Double.parseDouble(table.getValueAt(selectedrow, 14).toString());
			if (mybatch <= 0) {
				table.setValueAt("NB", selectedrow, 16);
				String vbatchno = new gnBatch().getNewBatch();
				table.setValueAt(vbatchno, selectedrow, 14);
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				// rateEnable();
				// rate.grabFocus();
				// table.setEnabled(false);
			}
			break;
		}
	}

	private void handleBatchZero(String varticle, String vbatchcontrol, String vtype) throws Throwable {
		// new General().msg("Processing now for zero batch Articles");
		String vcost = "0";
		String vsp = table.getValueAt(selectedrow, 4).toString();
		String vmrp = table.getValueAt(selectedrow, 5).toString();
		String vloc = "SL";
		String stockAvailabe = "";
		stockAvailabe = new gnBatch().IsStockAvailabeForMrpandSP(varticle, vmrp, vsp);
		vtype = "GZCase0";
		vcost = new gnArticle().Article_getData(varticle, "Cost");
		try {
			new gnGetBatch().getBatchDetailForNonBathItems(vtype, varticle, vbatchcontrol, vloc);
		} catch (Exception r) {
			new General().msg(r.getLocalizedMessage());
		} finally {
			table.setValueAt(new gnGetBatch().batchno, selectedrow, 14);
			table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 15);
			table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 4);
			table.setValueAt(new gnGetBatch().mrp, selectedrow, 5);
			new gnGetBatch().resetValues();
			QtychangeImapct(varticle, selectedrow);
		}
	}

	private void handleBatchNonZero(String varticle, String vbatchcontrol, String vtype) throws Throwable {
		String vcost = "0";
		String vsp = table.getValueAt(selectedrow, 4).toString();
		String vmrp = table.getValueAt(selectedrow, 5).toString();
		String vloc = "SL";
		String stockAvailabe = "";
		stockAvailabe = new gnBatch().IsStockAvailabeForMrpandSP(varticle, vmrp, vsp);
		// vtype = "GZCase0" ;
		// new General().msg("Running case0 option" + vtype);
		vcost = new gnArticle().Article_getData(varticle, "Cost");
		String vaction1 = new gnBatch().IsMultiBatchForMRP_SalesPriceForSale(varticle, vmrp, vsp, vcost);
		// new General().msg(vaction1);
		switch (vaction1) {
		case "Y":
			try {
				new gnGetBatch().getBatchDetailForNonBathItems(vtype, varticle, vbatchcontrol, vloc);
			} catch (Exception r) {
				new General().msg(r.getLocalizedMessage());
			} finally {
				table.setValueAt(new gnGetBatch().batchno, selectedrow, 14);
				table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 15);
				table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 4);
				table.setValueAt(new gnGetBatch().mrp, selectedrow, 5);
				new gnGetBatch().resetValues();
				QtychangeImapct(varticle, selectedrow);
			}
			break;
		case "N":
			String vbatch = new gnBatch().getLowestBatchNonZero(varticle, vmrp, vsp, vcost);
			table.setValueAt(vbatch, selectedrow, 14);
			break;
		}
	}

	public String checkArticleExist(String value) {
		new gnLogger().loggerInfoEntry("POS", "Checking in Table Article is Exist or not");
		int rowCount = 0;
		int i = 0;
		String action = "Insert";
		rowCount = table.getRowCount();
		String Colname = "";
		for (i = 0; i < rowCount; i++) {
			Colname = table.getValueAt(i, 1).toString();
			if (Colname.equalsIgnoreCase(value)) {
				String curqty1 = (String) table.getValueAt(i, 3).toString();
				double curqty = Double.parseDouble(curqty1);
				double newqty = curqty + 1.0;
				table.setValueAt(newqty, i, 3);
				try {
					QtychangeImapct(value, i);
					varticle = "0";
					QueryStatus = "Y";
					scanitem.setText(null);
					scanitem.grabFocus();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
		return action;
	}

	public String QtychangeImapct(String value, int i) throws Throwable {
		// new General().msg("Row Edit is" + " "+ i) ;
		new gnLogger().loggerInfoEntry("POS",
				"User Editing Data Either for qty /  Rate /Discount for row" + " " + i + "Artilce " + value);
		String vmyamount = "";
		String vtaxrate = "";
		String curqty1 = (String) table.getValueAt(i, 3).toString();
		double curqty = Double.parseDouble((curqty1));
		if (curqty == 0.0) {
			new General().msg(
					"< Qty > Can not be <0> {Do you Want to Remove Row.... Click On First Column in same Row.. ..}");
			table.setValueAt(1, i, 3);
			table.setEditingRow(i);
			table.setGridColor(Color.YELLOW);
		}

		String Csp1 = (String) table.getValueAt(i, 4);
		Double Csp = Double.parseDouble((String) Csp1);

		// Manul Disc
		String Cemp_disc1 = (String) table.getValueAt(i, 7).toString();
		Double Cemp_disc = Double.parseDouble(Cemp_disc1);

		String Cdisc1 = (String) table.getValueAt(i, 8).toString();
		Double Cdisc = Double.parseDouble(Cdisc1);

		String Cdisc2 = (String) table.getValueAt(i, 9).toString();
		Double Cdisc22 = Double.parseDouble(Cdisc2);

		// Double vtax = Double.parseDouble(table.getValueAt(i, 11).toString());
		Double newqty = curqty;
		Double newgross = newqty * Csp;

		Double newAmount = (newgross - Cdisc - Cemp_disc - Cdisc22);

		/*
		 * // For Tax Slab// switch (vverticlecode) { case "7":
		 * 
		 * // new General().msg("checking for tax Slab ..."); vmyamount =
		 * (String) table.getValueAt(i, 11).toString(); //vtaxrate =
		 * initialCheckForTaxSlab(value, vmyamount); table.setValueAt(vtaxrate,
		 * i, 12); break; case "14": // new General().msg(
		 * "checking for tax Slab ..."); vmyamount = (String)
		 * table.getValueAt(i, 11).toString(); //vtaxrate =
		 * initialCheckForTaxSlab(value, vmyamount); table.setValueAt(vtaxrate,
		 * i, 12); break; }
		 */
		Double vtax = Double.parseDouble(table.getValueAt(i, 12).toString());
		Double newtax = new gnMath().CalTax_Sales(newAmount, vtax);
		String vmytax = Double.toString(newtax);

		// {"Romove","Item","Name","Qty" ,"Rate" ,"MRP", "Gross" , "Maual disc"
		// , "Hdr Disc", "Disc"
		// ,"Tax", "Amount","Taxcode" ,
		// "Batch Item" ,"BatchNo", "Exp.Date" , "Cost", "DrugType" , "Content"
		// ,
		// "freeQty"};

		table.setValueAt(newqty, i, 3);
		String vmygross = Double.toString(newgross);
		table.setValueAt(new gnMath().get2DecimaltValue(vmygross), i, 6);

		String vmynetamt = Double.toString(newAmount);
		table.setValueAt(new gnMath().get2DecimaltValue(vmynetamt), i, 11);
		table.setValueAt(new gnMath().get2DecimaltValue(vmytax), i, 10);

		Double itemtotal = new gnTable().getTotal(table, 6);
		String vmyitemtotal = Double.toString(itemtotal);
		// new General().msg("Grosss"+ " "+vmyitemtotal) ;
		Tamount.setText(new gnMath().get2DecimaltValue(vmyitemtotal)); // Gross
																		// Amount

		Double vtotalqty = new gnTable().getTotal(table, 3);
		showqty.setText(Double.toString(vtotalqty));

		// manualdisc.setText("0");
		Double vmanualdisc = new gnTable().getTotal(table, 7);
		manualdisc.setText(new gnMath().get2DecimaltValue(Double.toString(vmanualdisc)));

		// hdrDiscount.setText("0");
		Double vpromodisc1 = new gnTable().getTotal(table, 8);
		Double vpromodisc2 = new gnTable().getTotal(table, 9);
		Double vhdrdiscamt = vpromodisc2 + vpromodisc1;
		String vmyhdrdisc = Double.toString(vhdrdiscamt);
		hdrDiscount.setText(new gnMath().get2DecimaltValue(vmyhdrdisc));
		new gnTable().setTablewidth(table, 2, 300);
		String action = "Updated";
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		String vremark = "Qty/Rate/Disc Change";
		// updateAuditRecord(vremark , i) ;

		new gnLogger().loggerInfoEntry("POS",
				" Editing Data Over for qty /  Rate /Discount for row" + " " + i + "Artilce " + value);

		// Calcuate Margin Vloilation rule//
		/*
		 * String vcheckMargin = "Y"; if (vcheckMargin == "Y") { String varticle
		 * = table.getValueAt(i, 1).toString(); // String vcost =
		 * table.getValueAt(i, 15).toString(); String vcost =
		 * table.getModel().getValueAt(i, 15).toString(); String vsp =
		 * table.getValueAt(i, 4).toString(); String status = new
		 * gnMath().checkMargin(varticle, vcost, vsp); } // End Margin
		 * Calcultion
		 */
		scanitem.grabFocus();
		calHdrDisocunt();
		switch (promoModuleActivated) {
		case "Y":
			break;
		}
		action = ValidateItemEntry();
		return action;

	}

	public String ValidateItemEntry() {
		String Action = "Sucess";

		// String Action1 = new gnTable().isAmountnegative(netAmount.getText())
		// ;
		String Action2 = new gnTable().istableColValueNegative(table, 3);
		String Action3 = new gnTable().istableColValueNegative(table, 4);
		if (Action2 == "Fail" || Action3 == "Fail") {
			Action = "Fail";
			new gnLogger().loggerInfoEntry("POS", "Bill Data Valiadtion for Item Value Negative found ...");
		}
		return Action;
	}

	private String checkAllowNegInv(String varticle) throws Throwable {
		String vallowyn = "";
		String vallow = "";
		double vqty = 0.00;
		vallow = new getConfigurationSetting().AllowNegInv();
		int vl = varticle.length();
		// new General().msg("Article Length" + " "+vl);
		if (varticle != "0") {
			vqty = new gnStockcheck().getArticleStock(varticle, "SL");
		}
		switch (vallow) {
		case "Y":
			vallowyn = "Y";
			break;
		case "N":
			if (vqty <= 0.00) {
				new General().msg("Negative Inventory Not Allow");
				vallowyn = "N";
			}
			break;
		}
		return vallowyn;
	}

	public String ValidateItem(String value) {
		String result = "Sucess";
		if (value.length() == ' ') {
			result = "Sucess";
		}

		if (value.length() == 0) {
			result = "Sucess";
		}
		return result;
	}

	class suplLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String vname = custname.getText();
			vname = "%" + vname + "%";
			try {
				new gnSupplier().getCustomer(vname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				custcode.setText(new gnSupplier().rcustcode);
				custname.setText(new gnSupplier().rcustName);
				phone.setText(new gnSupplier().rPhone);
			}
		}
	}
}// Last

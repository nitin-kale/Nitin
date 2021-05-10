package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Connection;

public class wsale_quotations extends getResultSet {

	JFrame framequotation;
	Connection con5, con7;
	private JTextField companycode;
	private JTextField companyname;
	private JTextField storecode;
	private JTextField storename;
	private JTextField quotno;
	private JTextField quotdate;
	private JTextField customercode;
	private JTextField customername;
	private JTextField phone;
	private JTextField email;
	private JTextField validupto;
	private JTextField advance;
	private JTextField searchname;
	private JTextField searchbrand;

	// =====
	private JScrollPane jsp;
	private JButton btnSave;
	private JButton btnClose;
	private JButton btnUpdate;
	private JCheckBox terms;
	private JCheckBox pricelist;
	private JComboBox selection;
	private JTextPane txtpane;
	private String PricelistApply;
	private String vcomp;
	private String vstore;
	private String vcustomer;
	private String vlevel;
	private JButton btnPriceList;
	private JComboBox status;
	// For nsert
	private String vquotationdate;
	private String vquotationno;
	private String DBhdr;
	private String DBdetail;
	private String vpaymentterm;
	private String vadvance;
	private String termandcondition;
	private String vcreatedby;
	private String vupdatedate;
	private String vupdateddby;
	private String vvalidupto;
	private String vamount;
	private String mode = "Save";

	private String[] Col = { "Remove", "Article code", "Name", "Cost", "UOM", "Slab Qty From", "Slab Qty To",
			"Box Inner Qty", "Markup", "Discount", "New Sales Price", "MRP", "Old SP", "MRP base Article ",
			"Batch Article", "Cust Code", "Level" };

	DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 3 || column == 4 || column == 5 || column == 6 || column == 7 || column == 8
					|| column == 9 || column == 10 || column == 11 ? true : false;
		}
	};

	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 4 || column == 5 || column == 6 || column == 7 || column == 8
					|| column == 9 || column == 10 || column == 11) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
			} else {
				componentt.setBackground(Color.cyan);
				componentt.setForeground(Color.BLACK);
			}
			if (column == 4 || column == 7 || column == 8) {
				componentt.setBackground(new Color(0, 51, 153));// .LIGHT_GRAY);
				componentt.setForeground(new Color(204, 255, 153));
			}
			return componentt;
		}
	};
	private JLabel lblNewLabel_13;
	private JTextField records;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wsale_quotations window = new wsale_quotations();
					window.framequotation.setVisible(true);
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
	public wsale_quotations() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		framequotation = new JFrame();
		framequotation.setResizable(false);
		framequotation.setAlwaysOnTop(true);
		framequotation.setBounds(100, 50, 1200, 670);
		framequotation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framequotation.getContentPane().setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(0, 0, 1200, 670);
		framequotation.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 23, 1184, 177);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Company");
		lblNewLabel_1.setBounds(22, 13, 55, 16);
		panel.add(lblNewLabel_1);

		companycode = new JTextField();
		companycode.setBackground(new Color(102, 255, 255));
		companycode.setEditable(false);
		companycode.setBounds(78, 7, 70, 26);
		panel.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setBackground(Color.CYAN);
		// companyname.setBackground(new Color(51, 255, 255));
		companyname.setEditable(false);
		companyname.setBounds(149, 7, 282, 26);
		panel.add(companyname);
		companyname.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Branch");
		lblNewLabel_2.setBounds(22, 43, 55, 16);
		panel.add(lblNewLabel_2);

		storecode = new JTextField();
		storecode.setBackground(new Color(102, 255, 255));
		storecode.setEditable(false);
		storecode.setBounds(78, 37, 70, 26);
		panel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setBackground(Color.CYAN);
		storename.setEditable(false);
		storename.setBounds(149, 37, 282, 26);
		panel.add(storename);
		storename.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(12, 7, 429, 71);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Customer Information", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 102)));
		panel_2.setBounds(443, 13, 439, 158);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Customer");
		lblNewLabel_5.setBounds(6, 22, 55, 16);
		panel_2.add(lblNewLabel_5);

		customercode = new JTextField();
		customercode.setBounds(66, 16, 84, 26);
		panel_2.add(customercode);
		ActionListener custcd = new custcodeLsnr();
		customercode.addActionListener(custcd);
		customercode.setColumns(10);

		customername = new JTextField();
		customername.setToolTipText("Press Enter To Select Customer <Put Here Start chars to filter Fast>");
		customername.setBounds(148, 16, 273, 26);
		ActionListener custnm = new custnameLsnr();
		customername.addActionListener(custnm);
		panel_2.add(customername);
		customername.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Phone");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(99, 74, 51, 16);
		panel_2.add(lblNewLabel_6);

		phone = new JTextField();
		phone.setBackground(new Color(51, 255, 255));
		phone.setEditable(false);
		phone.setBounds(149, 68, 152, 26);
		panel_2.add(phone);
		phone.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setBounds(112, 48, 38, 16);
		panel_2.add(lblNewLabel_7);

		email = new JTextField();
		email.setBackground(new Color(0, 255, 255));
		email.setEditable(false);
		email.setBounds(149, 42, 218, 26);
		panel_2.add(email);
		email.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Payment Terms");
		lblNewLabel_8.setBounds(62, 99, 88, 16);
		panel_2.add(lblNewLabel_8);

		selection = new JComboBox();
		selection.setToolTipText("Choose Option For Payment Terms");
		selection.setModel(new DefaultComboBoxModel(new String[] { "Cash On Delivery", "Advance Payment" }));
		selection.setBounds(148, 94, 142, 26);
		panel_2.add(selection);

		JLabel lblNewLabel_10 = new JLabel("Advance %");
		lblNewLabel_10.setBounds(292, 99, 75, 16);
		panel_2.add(lblNewLabel_10);

		advance = new JTextField();
		advance.setText("0");
		advance.setToolTipText("Enter Advance in % Here");
		advance.setBounds(353, 93, 55, 28);
		panel_2.add(advance);
		advance.setColumns(10);

		pricelist = new JCheckBox("Select Price From Price List");
		pricelist.setForeground(new Color(0, 102, 153));
		pricelist.setBackground(new Color(255, 153, 204));
		pricelist.setHorizontalAlignment(SwingConstants.RIGHT);
		pricelist.setBounds(6, 127, 181, 18);
		ActionListener prs = new pricelistLsnr();
		pricelist.addActionListener(prs);
		panel_2.add(pricelist);

		JLabel lblNewLabel_14 = new JLabel("Quotation Amount");
		lblNewLabel_14.setForeground(new Color(0, 0, 153));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setBounds(210, 127, 113, 16);
		panel_2.add(lblNewLabel_14);

		amount = new JTextField();
		amount.setBackground(Color.CYAN);
		amount.setEditable(false);
		amount.setBounds(328, 121, 93, 28);
		panel_2.add(amount);
		amount.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Qutotation No");
		lblNewLabel_3.setBounds(22, 77, 82, 16);
		panel.add(lblNewLabel_3);

		quotno = new JTextField();
		quotno.setToolTipText("System Will Generate This Number After  Data Save");
		quotno.setBounds(106, 77, 122, 26);
		panel.add(quotno);
		ActionListener qno = new QuotationLsnr();
		quotno.addActionListener(qno);
		quotno.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Date");
		lblNewLabel_4.setBounds(273, 83, 37, 16);
		panel.add(lblNewLabel_4);

		quotdate = new JTextField();
		quotdate.setToolTipText("Date Of Raising Quotation");
		quotdate.setBounds(309, 77, 122, 26);
		panel.add(quotdate);
		quotdate.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Valid Upto");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(224, 111, 76, 16);
		panel.add(lblNewLabel_9);

		validupto = new JTextField();
		validupto.setToolTipText("Enter Quotation Valid up to Date , After This Date Same Prices will not Applicable");
		validupto.setBounds(309, 105, 122, 26);
		panel.add(validupto);
		validupto.setColumns(10);

		terms = new JCheckBox("Terms & Condition");
		terms.setToolTipText("Click Here To Enter Terms & Conditions ");
		terms.setBounds(889, 12, 199, 18);
		ActionListener trm = new termLsnr();
		terms.addActionListener(trm);
		panel.add(terms);

		txtpane = new JTextPane();
		txtpane.setToolTipText("Enter Any Remark or Terms And Conditons For This Deal");
		txtpane.setEnabled(false);
		txtpane.setBounds(889, 35, 282, 125);
		panel.add(txtpane);

		JLabel lblNewLabel_15 = new JLabel("Status");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_15.setBounds(246, 139, 55, 16);
		panel.add(lblNewLabel_15);

		status = new JComboBox();
		status.setModel(new DefaultComboBoxModel(new String[] { "Open", "Close" }));
		status.setBounds(309, 134, 122, 26);
		panel.add(status);

		JLabel lblNewLabel = new JLabel("Customer Quotation ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(516, 0, 154, 16);
		internalFrame.getContentPane().add(lblNewLabel);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Item Details ", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 153)));
		panel_3.setBounds(0, 224, 1188, 356);
		internalFrame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(17, 20, 1154, 330);
		panel_3.add(jsp);

		btnSave = new JButton("Save");
		btnSave.setBounds(376, 582, 90, 28);
		ActionListener btn = new btnLsnr();
		btnSave.addActionListener(btn);

		internalFrame.getContentPane().add(btnSave);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(470, 582, 90, 28);
		btnUpdate.addActionListener(btn);

		internalFrame.getContentPane().add(btnUpdate);

		btnClose = new JButton("Close");
		btnClose.setBounds(562, 582, 90, 28);
		btnClose.addActionListener(btn);

		internalFrame.getContentPane().add(btnClose);

		JLabel lblNewLabel_11 = new JLabel("Search By Name");
		lblNewLabel_11.setBounds(10, 201, 106, 16);
		internalFrame.getContentPane().add(lblNewLabel_11);

		searchname = new JTextField();
		searchname.setToolTipText("Search By Name < Enter Start Chars For Fast Filter");
		searchname.setBounds(113, 195, 186, 28);
		ActionListener srnm = new searchnameLsnr();
		searchname.addActionListener(srnm);

		internalFrame.getContentPane().add(searchname);
		searchname.setColumns(10);

		searchbrand = new JTextField();
		searchbrand.setToolTipText(
				"Select ARticle for Specific Brand < Enter Start Chars For Brand for Faster Filtering>");
		searchbrand.setBounds(429, 195, 260, 28);
		ActionListener srbrnm = new searchbrandLsnr();
		searchbrand.addActionListener(srbrnm);

		internalFrame.getContentPane().add(searchbrand);
		searchbrand.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Search By Brand");
		lblNewLabel_12.setBounds(337, 201, 91, 16);
		internalFrame.getContentPane().add(lblNewLabel_12);

		lblNewLabel_13 = new JLabel("Records");
		lblNewLabel_13.setBounds(1000, 201, 55, 16);
		internalFrame.getContentPane().add(lblNewLabel_13);

		records = new JTextField();
		records.setForeground(new Color(253, 245, 230));
		records.setEditable(false);
		records.setBackground(new Color(0, 0, 153));
		records.setBounds(1062, 195, 122, 28);
		internalFrame.getContentPane().add(records);
		records.setColumns(10);

		btnPriceList = new JButton("Update Price List");
		btnPriceList.addActionListener(btn);
		btnPriceList.setBounds(1026, 582, 145, 28);
		internalFrame.getContentPane().add(btnPriceList);

		brandcode = new JTextField();
		brandcode.setEnabled(false);
		brandcode.setEditable(false);
		brandcode.setBounds(694, 198, 36, 28);
		internalFrame.getContentPane().add(brandcode);
		brandcode.setColumns(10);
		internalFrame.setVisible(true);
		decorate();

	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(framequotation);
		new gnDecorate().DispField_Eatch(advance, 10);
		new gnDecorate().DispField_Eatch(companycode, 10);
		new gnDecorate().DispField_Eatch(companyname, 10);
		new gnDecorate().DispField_Eatch(customercode, 10);
		new gnDecorate().DispField_Eatch(customername, 10);
		new gnDecorate().DispField_Eatch(email, 10);
		new gnDecorate().DispField_Eatch(phone, 10);
		new gnDecorate().DispField_Eatch(searchname, 10);
		new gnDecorate().DispField_Eatch(searchbrand, 10);

		vcomp = new gnConfig().getCompanyCode();
		companycode.setText(vcomp);
		if (vcomp == "0") {
			System.exit(0);
		}
		companyname.setText(new gnConfig().getCompany());
		vstore = new gnConfig().getStoreID();
		storecode.setText(vstore);
		storename.setText(new gnConfig().getStorename(vstore));
		companycode.setEnabled(false);
		storecode.setEnabled(false);
		new General().setDate(quotdate);
		quotdate.setEnabled(false);
		btnSave.setEnabled(true);
		btnUpdate.setEnabled(false);

	}

	class QuotationLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String vstatus = validatecustomer();
			if (vstatus == "Sucess") {
				String vcustcode = customercode.getText();
				try {
					new gnQuotation().getQuotation(vcustcode);
				} catch (Throwable e1) {
					e1.printStackTrace();
					new General().msg("Quotation : " + e1.getMessage());
				} finally {
					quotno.setText(new gnQuotation().vquotationno);
					quotdate.setText(new gnQuotation().vquotationdate);
					validupto.setText(new gnQuotation().vvalidupto);
					email.setText(new gnQuotation().vemail);
					phone.setText(new gnQuotation().vphone);
					amount.setText(new gnQuotation().vamount);
					advance.setText(new gnQuotation().vadvance);
					String vpterm = new gnQuotation().vpaymentterm;
					selection.setSelectedItem(vpterm);
					txtpane.setText(new gnQuotation().vterms);
					String vquotstatus = new gnQuotation().vstatus;
					new General().msg(vquotstatus);
					status.setSelectedItem(new gnQuotation().vstatus);
					switch (vquotstatus) {
					case "Close":
						status.setEnabled(false);
						status.setEditable(false);
						status.setBackground(Color.RED);
						btnUpdate.setEnabled(false);
						btnSave.setEnabled(false);
						table.setEnabled(false);
						break;
					case "Open":
						btnSave.setEnabled(false);
						table.setEnabled(true);
						selection.setEditable(false);
						btnUpdate.setEnabled(true);
						customercode.setEditable(false);
						customername.setEditable(false);
						advance.setEditable(false);
					}
					new gnQuotation().vquotationno = " ";
					new gnQuotation().vquotationdate = " ";
					new gnQuotation().vvalidupto = " ";
					new gnQuotation().vstatus = " ";
				}
				// populate items //
				try {
					vquotationno = quotno.getText();
					vcomp = companycode.getText();
					vstore = storecode.getText();
					vcustomer = customercode.getText();
					String SQL = "Call  wsales_getQuotationDetetails(" + vcomp + " , " + vstore + ", " + vcustcode
							+ ", " + vquotationno + ")";
					new gnTable().RemoveTableRows(model);
					table.setGridColor(Color.YELLOW);
					showTable(SQL, Col);
					mode = "Update";
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class custcodeLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vcode = customercode.getText().trim();
			if (vcode.length() == 0) {
				new General().msg("Select Customer Code ..");
				return;
			}
			// sname = "%"+sname+"%" ;
			try {
				new gnSupplier().setScanCustomer(customercode, customername, vcode);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
			}
		}
	}

	class custnameLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String sname = customername.getText().trim();
			sname = "%" + sname + "%";
			try {
				new gnSupplier().getCustomer(sname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				customercode.setText(new gnSupplier().rcustcode);
				customername.setText(new gnSupplier().rcustName);
			}
		}
	}

	class pricelistLsnr implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			boolean vpricelist = pricelist.isSelected();
			if (vpricelist) {
				int option = new General().msgInput(
						"All Prices will  Show From PriceList  Master For This Customer .. If Prices not maintain for This Customer Please Maintain Price For this Customer. Would You Like To Maintain ");
				if (option == 0) {
					try {
						wSales_priceList window;
						window = new wSales_priceList();
						window.wspricelist.setVisible(true);
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
				PricelistApply = "Y";
			}
		}
	}

	class termLsnr implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			boolean vterm = terms.isSelected();

			if (vterm) {
				txtpane.setEnabled(true);
			} else {
				txtpane.setEnabled(false);
			}
		}
	}

	private String validatecustomer() {
		String status = "Sucess";

		vcustomer = customercode.getText();
		if (vcustomer.length() == 0) {
			new General().msg("Select Customer For  Populate Records..");
			status = "Fail";
		}
		return status;
	}

	class searchbrandLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String sname = searchbrand.getText().trim();
			sname = "%" + sname + "%";
			String status = validatecustomer();
			vlevel = "Article";
			String SQL = " ";
			if (status == "Sucess") {
				try {
					String vmastertype = "Brand";
					// new gnBrand().getBrandInfo(sname)
					new gnAdmin().showMasterTable(vmastertype, brandcode, searchbrand);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					String vbrandcode = brandcode.getText();
					String vbndname = searchbrand.getText();
					String vdisp = vbrandcode + "-" + vbndname;
					brandcode.setText("");
					searchbrand.setText("");
					vcomp = companycode.getText();
					vstore = storecode.getText();
					if (PricelistApply == "Y") {
						SQL = "Call  wsale_getBRandAticlesforWsale(" + vcomp + " , " + vstore + " ,'" + vbrandcode
								+ "', " + vcustomer + ", '" + vlevel + "')";
					} else {
						SQL = "Call  wsale_getBRandAticlesRegularPrice(" + vcomp + " , " + vcustomer + " , '"
								+ vbrandcode + "' )";
					}
					try {
						showTable(SQL, Col);
						customercode.setEnabled(false);
						customername.setEnabled(false);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	class searchnameLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String sname = searchname.getText().trim();
			sname = "%" + sname + "%";
			String vtype = "Article";
			String vtrantype1 = "ALL";
			String status = validatecustomer();
			if (status == "Sucess") {
				vlevel = "Article";
				String varticle1 = " ";
				String SQL = " ";
				try {
					new gnAdmin().Search(vtype, sname, varticle1, vtrantype1);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					// searchname.setText(new gnAdmin().rArticlename);
					vcomp = companycode.getText();
					vstore = storecode.getText();
					String varticle = new gnAdmin().rArticle;
					if (PricelistApply == "Y") {
						SQL = "call wsale_getAticlesforWsale(" + vcomp + ", " + vstore + " , " + varticle + " , "
								+ vcustomer + ", '" + vlevel + "')";
						new General().msg(SQL);
					} else {
						SQL = "call wsale_getAticlesRegularPrice(" + vcomp + ", " + varticle + " , " + vcustomer + ")";
					}
					try {
						rs = new getResultSet().getSPResult(SQL);
						if (!rs.next()) {
							int option = new General().msgInput(
									"Price list is not maintained for this Article Would you Like to Maintain Price List..");
							if (option == 0) {
								wSales_priceList window;
								window = new wSales_priceList();
								window.wspricelist.setVisible(true);
								return;
							}
						}
						showTable(SQL, Col);
						// btnSave.setEnabled(false);
						// btnUpdate.setEnabled(true);
						customercode.setEnabled(false);
						customername.setEnabled(false);

					} catch (ClassNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}

	private void showTable(String SQL, String Col[]) throws ClassNotFoundException, SQLException {
		// new General().msg(SQL);
		// new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(Col);
		table.setModel(model);
		rs = this.getSPResult(SQL);

		while (rs.next()) {
			model.addRow(new Object[] { "Remove", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
					rs.getString(15), rs.getString(16) });
			table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new gnComp().generateWsaleBox()));
		}
		removeRow(model, table);
		new gnTable().setTableColWidth(table, 2, 200);
		new gnTable().setTableColWidth(table, 10, 100);
		table.setModel(model);
		table.setRowHeight(25);
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		Double vamt = new gnTable().getTotal(table, 10);
		amount.setText(Double.toString(vamt));
		records.setText(RecordCount1);

		JViewport prt6 = new JViewport();
		jsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(table, Col);
		prt6.setBackground(Color.white);
		jsp.setViewport(prt6);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification);

	}

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 1);
			QtyChangeImpact(row);
		}
	};
	private JTextField amount;
	private JTextField brandcode;

	public void removeRow(DefaultTableModel model, JTable table) {
		TableColumn Del = table.getColumnModel().getColumn(0);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setText("Remove");
		chkbox.setVisible(true);
		chkbox.setOpaque(true);
		chkbox.setToolTipText("Remove Row ");
		chkbox.setSelected(true);
		Del.setCellEditor(new DefaultCellEditor(chkbox));
		TableCellRenderer hdr = Del.getHeaderRenderer();
		table.getColumnModel().setColumnMargin(1);
		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int nn = e.getStateChange();
				if (nn == 2 && model == model) {
					int lastrow = table.getRowCount();
					if (lastrow > 1) {
						int r = table.getSelectedRow();
						int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
						if (option == 0) {
							model.removeRow(r);
							resetFigures();
						}
					}
					return;
				}
			}
		});
	}

	public void resetFigures() {
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		records.setText(RecordCount1);
		amount.setText(Double.toString(new gnTable().getTotal(table, 10)));

	}

	private void QtyChangeImpact(int row) {
		// "Remove" , 1"Article code" ,2 "Name" , 3"Cost" ,4 "UOM", 5"Slab Qty
		// From", 6 "Slab Qty To",
		// 7"Box Inner Qty" , 8"Markup" , 9"Discount", 10"New Sales Price",
		// 11"MRP" , 12"Old SP",
		// 13"MRP base Article " ,14 "Batch Article" , 15"Cust Code", 16"Level"
		// };

		// new General().msg("Reached At row is :"+ row);
		String vvarticle = table.getValueAt(row, 1).toString();
		String vname = table.getValueAt(row, 2).toString();
		String vcost = table.getValueAt(row, 3).toString();
		String vuom = table.getValueAt(row, 4).toString();

		switch (vuom) {
		case "NO":
			table.setValueAt(1, row, 7);
			table.addNotify();
			break;
		case "Box":
			if (table.getValueAt(row, 7).toString() == "1") {
				String vinnerqty = table.getValueAt(row, 7).toString();
				new General().msg("Please Check Inner Qty For Box, .Inner Qty is " + " " + vinnerqty);
			}
			break;
		case "Carton":
			if (table.getValueAt(row, 7).toString() == "1") {
				String vinnerqty = table.getValueAt(row, 7).toString();
				new General().msg("Please Check Inner Qty For  Carton, .Inner Qty is " + " " + vinnerqty);
			}
			break;
		}

		// new SP
		double xmarkup = Double.parseDouble(table.getValueAt(row, 8).toString());
		double xcost = Double.parseDouble(table.getValueAt(row, 3).toString());
		double xinnerqty = Double.parseDouble(table.getValueAt(row, 7).toString());
		double xdisc = Double.parseDouble(table.getValueAt(row, 9).toString());
		double xcostvalue = (xcost * xinnerqty);
		double xnewsp = xcostvalue + (xcostvalue * xmarkup / 100);
		double vnewSP1 = (xnewsp) - xdisc;
		String vnewSP = Double.toString(vnewSP1);
		table.setValueAt(vnewSP, row, 10);

		// End New SP

		String vmarkup = table.getValueAt(row, 8).toString();
		String vmrp = table.getValueAt(row, 11).toString();
		String voldsp = table.getValueAt(row, 12).toString();
		String vmrpbase = table.getValueAt(row, 13).toString();
		String vbatcharticle = table.getValueAt(row, 14).toString();
		String vcust = table.getValueAt(row, 15).toString();
		String vlevel = table.getValueAt(row, 16).toString();
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			System.out.println(e.getActionCommand());

			if (value == "Close") {
				framequotation.dispose();
			}
			if (value == "Update Price Lsit") {
				try {
					// updateRecordsToPriceList();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Update") {
				String status = validate();
				if (status == "Sucess") {
					try {
						prepareToupdate();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
			}

			if (value == "Save") {
				try {
					String status = validate();
					if (status == "Sucess") {
						prepareToInsert();
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private String validate() {
		String status = "Sucess";

		if (table.getRowCount() == 0) {
			new General().msg("No Data Available ...");
			status = "Fail";
		}

		if (validupto.getText().length() == 0) {
			new General().msg("Enter Valid Up To Date ... ");
			status = "Fail";
		}

		if (selection.getSelectedItem().toString() == "Advance") {
			if (advance.getText().length() == 0) {
				new General().msg("Enter Advance ,  You Have Selected ADVANCE PAYMENT OPTION");
				// advance.setText("0");
				// new General().msg("Enter Valid Up To Date ... ");
				status = "Fail";
			}
		}

		if (txtpane.getText().length() == 0) {
			txtpane.setText("No Other Terms & Cond. Apply");
		}
		return status;
	}

	private void prepareToupdate() throws Throwable {

		String SQL = " ";
		String vcomp = companycode.getText();
		String vstore = storecode.getText();
		String vquotationo = quotno.getText();
		String vcustcode = customercode.getText();
		SQL = "Call   wSales_updateQuotation(" + vcomp + " , " + vstore + ",  '" + vcustcode + "', '" + vquotationno
				+ "')";
		// Remove records for quotation from hdr
		String status = this.getResult(SQL);

		prepareToInsert();

	}

	private void prepareToInsert() throws Throwable {
		vcomp = companycode.getText();
		vstore = storecode.getText();
		vquotationdate = new gnConfig().date_ConverttoDBforamt(quotdate.getText());
		vcreatedby = new gnConfig().getUserCode();
		// Generate quotation //
		if (mode == "Save") {
			quotno.setText(new gnSeq().getSeqno("105", "TR"));
		}
		vquotationno = quotno.getText();
		new General().msg(" Quotation No is :" + " " + vquotationno);
		//
		vamount = amount.getText();
		DBhdr = "Fail";
		DBdetail = "Fail";
		vpaymentterm = selection.getSelectedItem().toString();
		vadvance = advance.getText();
		termandcondition = txtpane.getText();
		vupdatedate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
		vupdateddby = new gnConfig().getUserCode();
		vvalidupto = new gnConfig().date_ConverttoDBforamt(validupto.getText());
		InsertQuotationDetail();

	}

	private void InsertQuotationDetail() throws Throwable {
		prst = null;
		String vcomp = companycode.getText();
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con5 = (Connection) this.getConnection();
		con5.setAutoCommit(false);
		String wsaleprlist = "Insert into  wsales_Quotation_detail(company_code , "
				+ "site_code,          quotation_no ,        quotation_date,       valid_upto,  "
				+ " customercode  ,  srno,              article_code ,         name,       cost,     UOM, "
				+ "  innerQty,       SlabFrom,     SlabTo ,     Markup ,    Discount ,     SalesPrice ,"
				+ "oldSP,    MRP ,    Markdown ,      MRPBASEARTICLE ,      batch_article , " + "createdby)"
				+ "values(?,?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// nitin
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con5.prepareStatement(wsaleprlist);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vquotationno);
				prst.setString(4, vquotationdate);
				prst.setString(5, vvalidupto);
				prst.setString(6, vcustomer);
				prst.setInt(7, k);
				prst.setString(8, table.getValueAt(k, 1).toString());
				prst.setString(9, table.getValueAt(k, 2).toString());
				prst.setString(10, table.getValueAt(k, 3).toString());
				prst.setString(11, table.getValueAt(k, 4).toString());
				prst.setString(12, table.getValueAt(k, 7).toString());
				prst.setString(13, table.getValueAt(k, 5).toString());
				prst.setString(14, table.getValueAt(k, 6).toString());
				prst.setString(15, table.getValueAt(k, 8).toString());
				prst.setString(16, table.getValueAt(k, 9).toString());
				prst.setString(17, table.getValueAt(k, 10).toString());
				prst.setString(18, table.getValueAt(k, 12).toString());
				prst.setString(19, table.getValueAt(k, 11).toString());
				prst.setString(20, "0");
				prst.setString(21, table.getValueAt(k, 13).toString());
				prst.setString(22, table.getValueAt(k, 14).toString());
				prst.setString(23, vcreatedby);
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBdetail = "Fail";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
				}
				prst.executeBatch();
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg("W Sales Price List  Detail" + e.getMessage());
			e.getMessage();
			e.printStackTrace();
			con5.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {
				InsertQuotationHdr();
			}
		}
	}

	private void InsertQuotationHdr() throws Throwable {
		prst = null;
		String vcomp = companycode.getText();
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con7 = (Connection) this.getConnection();
		con7.setAutoCommit(false);
		String wqthdr = "Insert into  wsales_Quotation_hdr(company_code , "
				+ "site_code,          quotation_no ,        quotation_date,       valid_upto,  "
				+ " customercode  ,  createdby ,    amount  ,   advance,     payment_term ,    terms ,    "
				+ "status , updatedby, updatedate)" + "values(?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?)";
		// {"Remove" , 1"Article code" , 2"Name" , 3"Cost" , 4"UOM", 5"Slab Qty
		// From",
		// 6 "Slab Qty To", 7"Box Inner Qty" , 8"Markup" , 9"Discount",
		// 10"New Sales Price", 11"MRP" , 12 "Old SP", 13 "MRP base Article " ,
		// 14 "Batch Article" , 15 "Customercode", 16"Level"};
		try {
			prst = con7.prepareStatement(wqthdr);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, vquotationno);
			prst.setString(4, vquotationdate);
			prst.setString(5, vvalidupto);
			prst.setString(6, vcustomer);
			prst.setString(7, vcreatedby);
			prst.setString(8, vamount);
			prst.setString(9, vadvance);
			prst.setString(10, vpaymentterm);
			prst.setString(11, termandcondition);
			prst.setString(12, "Open");
			switch (mode) {
			case "Save":
				prst.setString(13, "");
				prst.setString(14, "0000.00.00");
				break;
			case "Update":
				prst.setString(13, vcreatedby);
				prst.setString(14, new gnConfig().date_ConverttoDBforamt(new General().getDate()));
				break;
			}
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBhdr = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr = "Sucess";
			}
			prst.executeBatch();
			DBhdr = "Sucess";
		} catch (SQLException e) {
			new General().msg("W Sales Price List  Hdr" + e.getMessage());
			e.getMessage();
			e.printStackTrace();
			con7.rollback();
			DBhdr = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") {
				con5.commit();
				con7.commit();
				new General().msg("Data Saved Sucessfully.. ");
				con5.close();
				con7.close();
				if (mode == "Save") {
					new gnSeq().updateSeqno("105", "TR");
				}
				reset();
			}
		}
	}

	private void reset() {
		new gnTable().RemoveTableRows(model);
		quotno.setText(" ");
		quotdate.setText(" ");
		validupto.setText(" ");
		advance.setText("0");
		txtpane.setText(" ");
		customercode.setText(" ");
		customername.setText(" ");
		records.setText("");
		customercode.setEnabled(true);
		customername.setEnabled(true);
		customercode.setEditable(true);
		customername.setEditable(true);
		amount.setText("0");
		btnSave.setEnabled(true);
		btnUpdate.setEnabled(false);
		mode = "Save";
		status.setEnabled(true);
		status.setEditable(true);
		advance.setEnabled(true);

	}
}// Last

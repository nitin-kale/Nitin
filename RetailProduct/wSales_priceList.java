package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.mysql.jdbc.Connection;

public class wSales_priceList extends getResultSet {

	JFrame wspricelist;
	private Connection con, con1, con2, con5;
	private JInternalFrame internalFrame;
	private String vcustomer;

	private JPanel custpanel;

	private JPanel SelectionPanel;
	private JPanel boxPanel;

	private JLabel heading;

	private JTextField companycode;
	private JTextField companyname;
	private JTextField storecode;
	private JTextField storename;
	private String trantype;
	private String vcomp;
	private String vstore;
	private JTextField code;
	private JTextField name;
	private JTextField margin;
	private JButton btnSave;
	private String vlevel;
	private JButton btnUpdate;
	private JButton btnClose;
	private JButton btnProcess;
	private JComboBox level;
	private JComboBox uom;
	private JRadioButton rbmarkup;
	private JRadioButton rbmarkdown;
	private String vcreatedate;
	private String vcreatedby;
	private String DBdetail;
	private String vMenu;
	private String vmaintainLevel;
	private JScrollPane jsp;
	private String queryIndicator;

	private String[] Col = { "Remove", "Article", "Name", "UOM", "Box Inner Qty", "Cost", "Markup", "MRP", "Markdown",
			"Discount", "New Sales Price", "Old SP", "MRPBase Article", "Batch Article", "Cust Code", "Type" };

	DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 3 || column == 4 || column == 5 || column == 6 || column == 7 || column == 8
					|| column == 9 || column == 10 ? true : false;
		}
	};

	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 4 || column == 5 || column == 6 || column == 7 || column == 8
					|| column == 9 || column == 10) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
			} else {
				componentt.setBackground(Color.cyan);
				componentt.setForeground(Color.BLACK);
			}
			if (column == 10) {
				componentt.setBackground(new Color(0, 51, 153));// .LIGHT_GRAY);
				componentt.setForeground(new Color(204, 255, 153));
			}
			return componentt;
		}
	};

	private JLabel lblNewLabel_4;
	private JTextField records;
	private JPanel boxpanel;
	private JButton btnAdd;
	private JLabel lblNewLabel_5;
	private JTextField boxqty;
	private JTextField slbqtyfrom;
	private JLabel lblNewLabel_7;
	private JTextField slbqtyto;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField discount;
	private JTextField searchname;
	private JLabel lblNewLabel_10;
	private JTextField customercode;
	private JTextField customername;
	private JTextField vpricedate;
	private JTextField searchbrand;
	private JTextField markdown;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField bandcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wSales_priceList window = new wSales_priceList();
					window.wspricelist.setVisible(true);
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
	public wSales_priceList() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		wspricelist = new JFrame();
		wspricelist.setTitle("Business Application");
		wspricelist.setResizable(false);
		wspricelist.setAlwaysOnTop(true);
		wspricelist.setBounds(1, 1, 1200, 750);
		wspricelist.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		wspricelist.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1200, 750);
		wspricelist.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		internalFrame = new JInternalFrame("Maintain Price  ");
		internalFrame.setForeground(new Color(204, 255, 255));
		internalFrame.setBounds(0, 0, 1200, 750);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 1178, 29);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		heading = new JLabel("Maintain Sales Price For WholeSale");
		heading.setFont(new Font("Tahoma", Font.BOLD, 14));
		heading.setBackground(new Color(51, 0, 51));
		heading.setForeground(new Color(0, 51, 51));
		heading.setBounds(449, 7, 367, 16);
		panel.add(heading);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 255, 255));
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(0, 31, 1178, 158);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel company = new JLabel("Company");
		company.setBounds(12, 13, 61, 16);
		panel_1.add(company);

		companycode = new JTextField();
		companycode.setBounds(73, 10, 61, 25);
		panel_1.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setBounds(137, 10, 249, 25);
		panel_1.add(companyname);
		companyname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Branch");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(12, 40, 56, 16);
		panel_1.add(lblNewLabel_1);

		storecode = new JTextField();
		storecode.setBounds(73, 37, 61, 25);
		panel_1.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setBounds(137, 37, 249, 25);
		panel_1.add(storename);
		storename.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 255, 255));
		panel_3.setBorder(new TitledBorder(null, "Show Articles For", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(51, 0, 102)));
		panel_3.setBounds(229, 61, 164, 60);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		level = new JComboBox();
		level.setBounds(20, 22, 124, 22);
		level.setModel(new DefaultComboBoxModel(new String[] { "Article" }));
		panel_3.add(level);

		SelectionPanel = new JPanel();
		SelectionPanel.setBackground(new Color(0, 255, 255));
		SelectionPanel.setBorder(new TitledBorder(null, "Select Infornmation For Price Management ",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		SelectionPanel.setBounds(398, 13, 442, 139);
		panel_1.add(SelectionPanel);
		SelectionPanel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Select");
		lblNewLabel_2.setBounds(23, 59, 43, 16);
		SelectionPanel.add(lblNewLabel_2);

		code = new JTextField();
		code.setBounds(70, 55, 60, 22);
		code.setFont(new Font("Tahoma", Font.PLAIN, 14));
		code.setForeground(new Color(51, 0, 153));
		code.setBackground(new Color(102, 255, 255));
		code.setEditable(false);
		SelectionPanel.add(code);
		code.setColumns(10);

		name = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		name.setBounds(131, 56, 295, 22);
		SelectionPanel.add(name);
		name.setColumns(10);
		ActionListener nm = new codeLsnr();
		name.addActionListener(nm);

		JLabel lblNewLabel_3 = new JLabel("Markup % Margin");
		lblNewLabel_3.setBounds(130, 89, 107, 16);
		SelectionPanel.add(lblNewLabel_3);

		margin = new JTextField();
		margin.setBounds(242, 84, 60, 22);
		SelectionPanel.add(margin);
		margin.setColumns(10);

		btnProcess = new JButton("Process");
		btnProcess.setBounds(336, 108, 97, 25);
		btnProcess.setMnemonic('P');
		ActionListener prs = new processLsnr();
		btnProcess.addActionListener(prs);
		SelectionPanel.add(btnProcess);

		custpanel = new JPanel();
		custpanel.setBorder(new MatteBorder(1, 2, 1, 2, (Color) new Color(255, 255, 204)));
		custpanel.setBounds(8, 27, 425, 27);
		SelectionPanel.add(custpanel);
		custpanel.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("Customer");
		lblNewLabel_11.setBounds(6, 6, 55, 16);
		custpanel.add(lblNewLabel_11);

		customercode = new JTextField();
		customercode.setBounds(63, 1, 61, 23);
		custpanel.add(customercode);
		customercode.setColumns(10);
		ActionListener cust = new custcodeLsnr();
		customercode.addActionListener(cust);

		customername = new JTextField();
		customername.setBounds(123, 1, 296, 23);
		custpanel.add(customername);
		customername.setColumns(10);

		vpricedate = new JTextField();
		vpricedate.setEditable(false);
		vpricedate.setBounds(314, 6, 116, 22);
		SelectionPanel.add(vpricedate);
		vpricedate.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("MarkDown% ");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setBounds(135, 109, 107, 16);
		SelectionPanel.add(lblNewLabel_12);

		markdown = new JTextField();
		markdown.setBounds(243, 109, 59, 22);
		SelectionPanel.add(markdown);
		markdown.setColumns(10);

		rbmarkup = new JRadioButton("Markup");
		buttonGroup.add(rbmarkup);
		ActionListener rb = new rbLsner();
		rbmarkup.addActionListener(rb);
		rbmarkup.setBackground(new Color(51, 255, 255));
		rbmarkup.setBounds(33, 85, 97, 22);
		SelectionPanel.add(rbmarkup);

		rbmarkdown = new JRadioButton("MarkDown");
		buttonGroup.add(rbmarkdown);
		ActionListener rb1 = new rbLsner();
		rbmarkdown.addActionListener(rb1);
		rbmarkdown.setBackground(new Color(0, 255, 255));
		rbmarkdown.setSelected(true);
		rbmarkdown.setBounds(33, 108, 97, 22);

		SelectionPanel.add(rbmarkdown);
		ActionListener custname = new custnameLsnr();
		customername.addActionListener(custname);

		SelectionPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { name, margin, btnProcess }));

		boxpanel = new JPanel();
		boxpanel.setBorder(new TitledBorder(null, "Box Level", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		boxpanel.setBackground(new Color(204, 255, 255));
		boxpanel.setBounds(840, 10, 332, 142);
		panel_1.add(boxpanel);
		boxpanel.setLayout(null);

		btnAdd = new JButton("Add Record For Box");
		btnAdd.setMnemonic('A');
		btnAdd.setBounds(181, 111, 145, 25);
		boxpanel.add(btnAdd);
		ActionListener add = new btnaddLsnr();
		btnAdd.addActionListener(add);

		lblNewLabel_5 = new JLabel("Inner Qty");
		lblNewLabel_5.setBounds(12, 45, 64, 16);
		boxpanel.add(lblNewLabel_5);

		boxqty = new JTextField();
		boxqty.setBounds(76, 42, 48, 22);
		boxpanel.add(boxqty);
		boxqty.setColumns(10);

		uom = new JComboBox();
		uom.setModel(new DefaultComboBoxModel(new String[] { "NO", "Box", "Carton" }));
		uom.setBounds(12, 16, 112, 22);
		ActionListener um = new uomLsnr();
		uom.addActionListener(um);
		boxpanel.add(uom);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(
				new TitledBorder(null, "Slab", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(59, 59, 59)));
		panel_5.setBounds(156, 6, 170, 89);
		boxpanel.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Qty From");
		lblNewLabel_6.setBounds(6, 20, 56, 16);
		panel_5.add(lblNewLabel_6);

		slbqtyfrom = new JTextField();
		slbqtyfrom.setText("0");
		slbqtyfrom.setBounds(67, 17, 31, 22);
		panel_5.add(slbqtyfrom);
		slbqtyfrom.setColumns(10);

		slbqtyto = new JTextField();
		slbqtyto.setText("0");
		slbqtyto.setBounds(122, 18, 31, 22);
		panel_5.add(slbqtyto);
		slbqtyto.setColumns(10);

		lblNewLabel_8 = new JLabel("to");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(98, 20, 23, 16);
		panel_5.add(lblNewLabel_8);

		lblNewLabel_9 = new JLabel("Discount Rs.");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(6, 48, 87, 16);
		panel_5.add(lblNewLabel_9);

		discount = new JTextField();
		discount.setText("0");
		discount.setBounds(97, 45, 56, 24);
		panel_5.add(discount);
		discount.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(0, 651, 1178, 29);
		internalFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(464, 0, 97, 25);
		ActionListener sv = new btnLsnr();
		btnSave.addActionListener(sv);
		panel_2.add(btnSave);

		btnUpdate = new JButton("Update");
		btnUpdate.setMnemonic('U');
		btnUpdate.setBounds(565, 0, 97, 25);
		btnUpdate.addActionListener(sv);
		panel_2.add(btnUpdate);

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(666, 0, 97, 25);
		btnClose.addActionListener(sv);
		panel_2.add(btnClose);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(0, 215, 1178, 430);
		internalFrame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(16, 6, 1145, 410);
		panel_4.add(jsp);

		searchname = new JTextField();
		searchname.setEnabled(false);
		searchname.setBounds(251, 188, 201, 24);
		internalFrame.getContentPane().add(searchname);
		searchname.setColumns(10);
		ActionListener srchname = new searchnameLsnr();
		searchname.addActionListener(srchname);

		lblNewLabel_10 = new JLabel("Search By Name");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_10.setBounds(133, 192, 114, 16);
		internalFrame.getContentPane().add(lblNewLabel_10);

		lblNewLabel_4 = new JLabel("Records");
		lblNewLabel_4.setBounds(1044, 189, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel_4);

		records = new JTextField();
		records.setBounds(1097, 189, 67, 22);
		internalFrame.getContentPane().add(records);
		records.setFont(new Font("Tahoma", Font.PLAIN, 13));
		records.setForeground(new Color(51, 0, 153));
		records.setEditable(false);
		records.setColumns(10);

		JLabel lblNewLabel = new JLabel("Search By Brand");
		lblNewLabel.setBounds(478, 192, 104, 16);
		internalFrame.getContentPane().add(lblNewLabel);
		searchbrand = new JTextField();
		searchbrand.setBounds(582, 188, 319, 24);
		ActionListener srcbnd = new searchbrandLsnr();
		searchbrand.addActionListener(srcbnd);
		searchbrand.setColumns(10);

		internalFrame.getContentPane().add(searchbrand);

		JButton btnUpdatePricelist = new JButton("Update Price List");
		btnUpdatePricelist.setBounds(10, 188, 138, 25);
		internalFrame.getContentPane().add(btnUpdatePricelist);

		bandcode = new JTextField();
		bandcode.setEditable(false);
		bandcode.setBounds(903, 189, 116, 22);
		internalFrame.getContentPane().add(bandcode);
		bandcode.setColumns(10);
		internalFrame.setVisible(true);

		decorate();
	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(wspricelist);
		new gnField().closeform(internalFrame, wspricelist);
		new gnDecorate().DispField_Eatch(companycode, 12);
		new gnDecorate().DispField_Eatch(companyname, 12);
		new gnDecorate().DispField_BevalRaised(companycode);
		new gnDecorate().DispField_BevalRaised(companyname);
		new gnDecorate().DispField_BevalRaised(storecode);
		new gnDecorate().DispField_BevalRaised(storename);
		new gnDecorate().DispField_BevalRaised(records);
		new gnDecorate().DispField_BevalRaised(code);
		new gnDecorate().DispField_BevalRaised(name);
		new gnDecorate().DispField_BevalRaised(margin);
		new gnField().showCalc(internalFrame, "CAL");

		vcomp = new gnConfig().getCompanyCode();
		companycode.setText(vcomp);
		if (vcomp == "0") {
			System.exit(0);
		}
		vpricedate.setText(new General().getDate());
		companyname.setText(new gnConfig().getCompany());
		vstore = new gnConfig().getStoreID();
		storecode.setText(vstore);
		storename.setText(new gnConfig().getStorename(vstore));
		companycode.setEnabled(false);
		companyname.setEnabled(false);
		storecode.setEnabled(false);
		storename.setEnabled(false);
		boxpanel.setVisible(false);
		boxqty.setText("1");
		boxqty.setEnabled(false);
		margin.setEnabled(false);
		markdown.setEnabled(false);
		vMenu = new gnConfig().getmenuPressed();
		// new General().msg(vmenu);
		switch (vMenu) {
		case "Whole Sales Price List":
			custpanel.setVisible(true);
			customercode.setText("0");
			trantype = "0";
			break;
		case "Customer Price List":
			custpanel.setVisible(true);
			customercode.setText("");
			heading.setText("Customer - Maintain Customer Price List ");
			trantype = "1";
			break;
		}
	}

	class rbLsner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			boolean choice = rbmarkup.isSelected();
			if (choice) {
				margin.setEnabled(true);
				markdown.setEnabled(false);
				queryIndicator = "UP";
				markdown.setText("0");
			} else {
				queryIndicator = "DOWN";
				margin.setEnabled(false);
				markdown.setEnabled(true);
				margin.setText("0");
			}

		}
	}

	class uomLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			String vuom = uom.getSelectedItem().toString();
			switch (vuom) {
			case "NO":
				boxqty.setText("1");
				boxqty.setEnabled(false);
				break;
			case "Box":
				boxqty.setText("");
				boxqty.setEnabled(true);
				break;
			case "Carton":
				boxqty.setText("");
				boxqty.setEnabled(true);
				break;
			}
		}
	}

	private String validatecustomer() {
		String status = "Sucess";

		switch (vMenu) {
		case "Whole Sales Price List":
			customercode.setText("0");
			vcustomer = "0"; // customercode.getText() ;
			break;
		case "Customer Price List":
			vcustomer = customercode.getText();
			if (vcustomer.length() == 0) {
				new General().msg("Select Customer For  Populate Records..");
				status = "Fail";
			}
			break;
		}
		return status;
	}

	class searchbrandLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			codeLsnr jk = new codeLsnr();
			String value = e.getActionCommand();
			String sname = searchbrand.getText().trim();
			sname = "%" + sname + "%";
			String status = validatecustomer();
			if (status == "Sucess") {
				vlevel = "Article";
				try {
					sname = "Brand";
					new gnAdmin().showMasterTable(sname, bandcode, searchbrand);
					// new gnBrand().getBrandInfo(sname);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					// String vbrandcode = (new gnBrand().rbrandcode);
					String vbrandcode = bandcode.getText();
					// String vbndname = (new gnBrand().rName);
					// String vdisp = vbrandcode+"-"+vbndname ;
					// searchbrand.setText(vdisp);
					btnSave.setEnabled(false);
					btnUpdate.setEnabled(true);
					vcomp = companycode.getText();
					vstore = storecode.getText();
					String SQL = "Call  wsale_getBRandAticlesforWsale(" + vcomp + " , " + vstore + " , '" + vbrandcode
							+ "', '" + vcustomer + "', '" + vlevel + "')";
					try {
						showTable(SQL, Col);
						btnSave.setEnabled(false);
						btnUpdate.setEnabled(true);
						btnSave.setEnabled(false);
						btnUpdate.setEnabled(true);
						customercode.setEnabled(false);
						customername.setEnabled(false);
						code.setText("");
						name.setText("");
						margin.setText("");
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
				try {
					new gnAdmin().Search(vtype, sname, varticle1, vtrantype1);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					searchname.setText(new gnAdmin().rArticlename);
					vcomp = companycode.getText();
					vstore = storecode.getText();
					String varticle = new gnAdmin().rArticle;
					String SQL = "call wsale_getAticlesforWsale(" + vcomp + ", " + vstore + " , " + varticle + " , "
							+ vcustomer + ", '" + vlevel + "')";
					// new General().msg(SQL);
					new gnTable().RemoveTableRows(model);
					try {
						showTable(SQL, Col);
						btnSave.setEnabled(false);
						btnUpdate.setEnabled(true);
						customercode.setEnabled(false);
						customername.setEnabled(false);
						code.setText("");
						name.setText("");
						margin.setText("");
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	class custcodeLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vcode = customercode.getText().trim();
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

	private class codeLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String sname = name.getText().trim();
			sname = "%" + sname + "%";
			String vselection = level.getSelectedItem().toString();
			String SQL = " ";
			String vtype = "Article";
			String vtrantype1 = "ALL";
			String varticle1 = " ";
			switch (vselection) {
			case "Article":
				try {
					new gnAdmin().Search(vtype, sname, varticle1, vtrantype1);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					code.setText(new gnAdmin().rArticle);
					name.setText(new gnAdmin().rArticlename);
					switch (trantype) {
					case "0":
						// check article is already present or not //

					}
					new gnAdmin().rArticle = "";
					new gnAdmin().rArticlename = " ";
				}
				break;
			case "Brand":
				try {
					sname = "Brand";
					new gnAdmin().showMasterTable(sname, bandcode, searchbrand);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					code.setText(new gnBrand().rbrandcode);
					name.setText(new gnBrand().rName);
				}
				break;
			}
		}
	}

	private String validateProcess() {
		String status = "Sucess";
		if (name.getText().length() == 0 || code.getText().length() == 0) {
			String vselection = level.getSelectedItem().toString();
			new General().msg("Select  Name for " + " " + vselection);
			status = "Fail";
		}

		boolean choice = rbmarkup.isSelected();

		if (margin.getText().length() == 0 && rbmarkup.isSelected()) {
			new General().msg("Enter Markup % ...");
			status = "Fail";
		}

		if (markdown.getText().length() == 0 && rbmarkdown.isSelected()) {
			new General().msg("Enter Markdown% ...");
			status = "Fail";
		}

		return status;
	}

	class processLsnr implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			try {
				String process_status = validateProcess();
				if (process_status == "Sucess") {
					customercode.setEnabled(false);
					customername.setEnabled(false);
					String vselection = level.getSelectedItem().toString();
					String vtype = vselection;
					String vcode = code.getText();
					String vcust = customercode.getText();
					vlevel = "Article";
					if (vtype == "Article") {
						String status = new gnCheckArticle().checkArticleExist(table, vcode, 1);
						if (status == "Sucess") {
							String SQL = "Call  wsale_checkArticlePresent(" + vcomp + " , " + vstore + " , '" + vcust
									+ "'  , " + vcode + ")";
							rs = new getResultSet().getSPResult(SQL);
							if (rs.next()) {
								int option = new General().msgInput(
										"Article is Alrady Present in Price List.., Would you Like to Show Data ");
								if (option == 0) {
									String SQL2 = "call wsale_getAticlesforWsale(" + vcomp + ", " + vstore + " , "
											+ vcode + " , " + vcust + ", '" + vlevel + "')";
									// new General().msg(SQL2);
									showTable(SQL2, Col);
									table.setGridColor(Color.RED);
									btnSave.setEnabled(false);
									btnUpdate.setEnabled(true);
								}
							} else {
								process();
							}
						}
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void process() throws ClassNotFoundException, SQLException {
		String vselection = level.getSelectedItem().toString();
		String vtype = vselection;
		vlevel = "Article";
		String vcode = code.getText();
		String vmargin = margin.getText();
		String vmarkdown = markdown.getText();

		String vcustcode = customercode.getText();
		// new General().msg(vcustcode);
		if (vcustcode.length() == 0) {
			vcustcode = "0";
		}
		String SQL = " ";
		switch (vtype) {
		case "Article":
			SQL = "Call wsalePrice_setForArticlePrice( " + vcomp + "  , " + vcode + ",  '" + vmargin + "'  ," + " '"
					+ vcustcode + "', '" + vlevel + "' , '" + vmarkdown + "' , '" + queryIndicator + "')";
			break;
		case "Brand":
			SQL = "Call wsalePrice_setForBrandPrice( " + vcomp + " , " + vcode + ", '" + vmargin + "' ," + " '"
					+ vcustcode + "' , '" + vlevel + "' , '" + vmarkdown + "' , '" + queryIndicator + "')";
			break;
		case "Group":
			SQL = "Call wsalePrice_setForGroupPrice( " + vcomp + " , " + vcode + ", '" + vmargin + "' , " + " '"
					+ vcustcode + "', '" + vlevel + "', '" + vmarkdown + "' , '" + queryIndicator + "')";
			break;
		case "Sub Group":
			SQL = "Call wsalePrice_setForGroupPrice( " + vcomp + " , " + vcode + ", '" + vmargin + "' , '" + vcustcode
					+ "', '" + vlevel + "', " + "'" + vmarkdown + "' , '" + queryIndicator + "')";
			break;
		}
		// new General().msg(SQL);
		showTable(SQL, Col);
		code.setText("");
		name.setText("");
		margin.setText("");
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
					rs.getString(15) });
			// table.getColumnModel().getColumn(3).setCellEditor(new
			// DefaultCellEditor(new gnComp().generateWsaleBox()));
		}
		new gnTable().removeRow(model, table);
		new gnTable().setTableColWidth(table, 2, 200);
		table.setModel(model);
		table.setRowHeight(25);
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		records.setText(RecordCount1);
		JViewport prt6 = new JViewport();
		jsp.setViewport(null);
		prt6.setToolTipText("Price List Data");
		prt6.setScrollMode(0);
		prt6.add(table, Col);
		jsp.setViewport(prt6);
	}

	class btnaddLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
			int row = table.getSelectedRow();
			if (row == -1) {
				new General().msg("Selet  Article From Table First ...");
				return;
			}
			String vname = table.getValueAt(row, 2).toString();
			int option = new General()
					.msgInput("Article Selected For  Box Level Setting is  :  " + vname + "        " + "Are you sure");
			if (option == 0) {
				String vstatus = validateAddrow();
				if (vstatus == "Sucess") {
					addrow(row);
				}
			}
		}
	}

	private String validateAddrow() {
		String status = "Sucess";
		if (boxqty.getText().length() == 0) {
			new General().msg("Enter Inner Qty of Box/Carton ");
			status = "Fail";
		}

		if (slbqtyfrom.getText().length() == 0) {
			slbqtyfrom.setText("0");
		}
		if (slbqtyto.getText().length() == 0) {
			slbqtyto.setText("0");
		}
		if (discount.getText().length() == 0) {
			discount.setText("0");
		}
		return status;
	}

	private void addrow(int row) {
		// "Remove" , "Article code" , "Name" , "Cost" , "UOM", "Slab Qty From",
		// "Slab Qty To", "Box Inner Qty" ,
		// 8"Markup" , 9"New Sales Price", 10"MRP" , 11"Old SP", 12 "MRP base
		// Article " , 13"Batch Article" };
		String vvarticle = table.getValueAt(row, 1).toString();
		String vname = table.getValueAt(row, 2).toString();
		String vcost = table.getValueAt(row, 3).toString();
		String vuom = uom.getSelectedItem().toString();
		String vslabfrom = slbqtyfrom.getText();
		String vslabto = slbqtyto.getText();
		String vinnerqty = boxqty.getText();
		String vdisc = discount.getText();
		// new SP
		double xmarkup = Double.parseDouble(table.getValueAt(row, 8).toString());
		double xcost = Double.parseDouble(table.getValueAt(row, 3).toString());
		double xinnerqty = Double.parseDouble(vinnerqty);
		double xdisc = Double.parseDouble(vdisc);
		double xcostvalue = (xcost * xinnerqty);
		double xnewsp = xcostvalue + (xcostvalue * xmarkup / 100);
		double vnewSP1 = (xnewsp) - xdisc;
		String vnewSP = Double.toString(vnewSP1);
		// End New SP
		String vmarkup = table.getValueAt(row, 8).toString();
		String vmrp = table.getValueAt(row, 11).toString();
		String voldsp = table.getValueAt(row, 12).toString();
		String vmrpbase = table.getValueAt(row, 13).toString();
		String vbatcharticle = table.getValueAt(row, 14).toString();
		String vcust = table.getValueAt(row, 15).toString();
		String vlevel = table.getValueAt(row, 16).toString();
		model.setColumnIdentifiers(Col);
		model.addRow(new Object[] { "Remove", vvarticle, vname, vcost, vuom, vslabfrom, vslabto, vinnerqty, vmarkup,
				vdisc, vnewSP, vmrp, voldsp, vmrpbase, vbatcharticle, vcust, vlevel });
		table.setModel(model);
		table.setVisible(true);
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		records.setText(RecordCount1);
		new gnTable().setTableColWidth(table, 2, 200);
		new gnTable().removeRow(model, table);
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			System.out.println(e.getActionCommand());

			if (value == "Close") {
				wspricelist.dispose();
			}
			if (value == "Update") {
				try {
					updateRecords();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (value == "Save") {
				try {
					prepareToInsert();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}

			}
		}
	}

	private void updateRecords() throws Throwable {
		int row = table.getRowCount();
		vcomp = companycode.getText();
		vstore = storecode.getText();

		String vendDate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
		String vactive = "N";
		String vupdatedby = new gnConfig().getUserCode();
		String vcust = customercode.getText();
		String SQL = "Call wsale_updateStatusnonActive(" + vcomp + ", " + vstore + ",  '" + vactive + "', '" + vendDate
				+ "' , '" + vupdatedby + "' , " + vcust + ", '" + vlevel + "')";
		String records = this.getResult(SQL);
		vcomp = companycode.getText();
		vstore = storecode.getText();
		vcreatedate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
		vcreatedby = new gnConfig().getUserCode();
		vmaintainLevel = level.getSelectedItem().toString();
		insertPrices();
	}

	private void prepareToInsert() throws Throwable {

		vcomp = companycode.getText();
		vstore = storecode.getText();
		vcreatedate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
		vcreatedby = new gnConfig().getUserCode();
		vmaintainLevel = level.getSelectedItem().toString();
		insertPrices();
	}

	public void insertPrices() throws Throwable {
		prst = null;
		String vcomp = companycode.getText();
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con5 = (Connection) this.getConnection();
		con5.setAutoCommit(false);
		String wsaleprlist = "Insert into  wsales_priceList(company_code , "
				+ "site_code,    create_date ,    Maintain_level ,    " + "     Article_code , "
				+ "name ,  UOM ,   innerqty,   cost,  markup ,   MRP , markdown,   Discount , SalesPrice  ,   "
				+ "  oldsp   , MrpBaseArticle  ,              Batch_article  ,    customercode,   "
				+ "createdby ,    startdate, active)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
		// "Remove" , 1"Article" , 2"Name" , 3"UOM", 4"Box Inner Qty", 5 "Cost"
		// ,
		// 6"Markup" ,7 "MRP" , 8"Markdown" , 9"Discount",
		// 10"New Sales Price" ,11 "Old SP", 12"MRPBase Article", 13"Batch
		// Article",
		// 14"Cust Code", 15"Type"
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con5.prepareStatement(wsaleprlist);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vcreatedate);
				prst.setString(4, "Article");
				prst.setString(5, table.getValueAt(k, 1).toString());
				prst.setString(6, (table.getValueAt(k, 2).toString()));
				prst.setString(7, (table.getValueAt(k, 3).toString()));
				prst.setString(8, (table.getValueAt(k, 4).toString()));
				prst.setString(9, (table.getValueAt(k, 5).toString()));
				prst.setString(10, (table.getValueAt(k, 6).toString()));
				prst.setString(11, (table.getValueAt(k, 7).toString()));
				prst.setString(12, (table.getValueAt(k, 8).toString()));
				prst.setString(13, (table.getValueAt(k, 9).toString()));
				prst.setString(14, (table.getValueAt(k, 10).toString()));
				prst.setString(15, (table.getValueAt(k, 11).toString()));
				prst.setString(16, (table.getValueAt(k, 12).toString()));
				prst.setString(17, (table.getValueAt(k, 13).toString()));
				prst.setString(18, (table.getValueAt(k, 14).toString()));
				prst.setString(19, vcreatedby);
				prst.setString(20, vcreatedate);
				prst.setString(21, "Y");
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
			new General().msg("W Sales Price List " + e.getMessage());
			e.getMessage();
			e.printStackTrace();
			con5.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {
				con5.commit();
				new General().msg("Data Saved Sucessfully.. ");
				reset();
			}
		}
	}

	private void reset() {
		new gnTable().RemoveTableRows(model);
		customercode.setEnabled(true);
		customername.setEnabled(true);
		customercode.setText(" ");
		customername.setText(" ");
		code.setText(" ");
		name.setText(" ");
		margin.setText(" ");
		slbqtyfrom.setText("0");
		records.setText("0");
		slbqtyto.setText("0");
		btnSave.setEnabled(true);
		btnUpdate.setEnabled(false);
		searchbrand.setText(" ");
		searchname.setText(" ");
		discount.setText("0");
		boxqty.setText("1");
		boxqty.setEnabled(false);
		uom.setSelectedIndex(0);
	}
}// Last

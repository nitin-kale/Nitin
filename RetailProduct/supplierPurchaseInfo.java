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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class supplierPurchaseInfo extends getResultSet {

	JButton btnClose;
	JButton btnView;
	JButton btnSave;
	JButton btnDetail;
	JButton btnSchedule;
	JPanel optionPanel1;
	JPanel optionPanel2;
	JPanel optionPanel3;

	private String vcomp;
	private String vstore;
	JFrame purchaseInfoRecord;
	private JTextField suppliercode;
	private JTextField suppliername;
	private JTextField scanItem;
	private JTextField searchname;
	private JTextField email;
	private JTextField phone;
	private JLabel lblNewLabel_6;
	private JTextField creditDays;

	private DefaultTableModel smodel = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 1 || column == 2 ? false : true;
		}
	};

	private JTable stable = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 1 || column == 2) {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
			} else {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.blue);
			}
			return componentt;
		}
	};

	private DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 3 || column == 4 || column == 5 ? true : false;
		}
	};

	private JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 4 || column == 5) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
			}
			return componentt;
		}
	};

	private JScrollPane jsp;
	private JScrollPane sjsp;

	private JLabel lblNewLabel_7;
	private JTextField records;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supplierPurchaseInfo window = new supplierPurchaseInfo();
					window.purchaseInfoRecord.setVisible(true);
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
	public supplierPurchaseInfo() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		purchaseInfoRecord = new JFrame();
		purchaseInfoRecord.setAlwaysOnTop(true);
		purchaseInfoRecord.setBounds(1, 1, 1360, 755);
		purchaseInfoRecord.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		purchaseInfoRecord.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 23, 1342, 82);
		panel.setBackground(new Color(0, 255, 255));
		purchaseInfoRecord.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Supplier ");
		lblNewLabel_1.setBounds(12, 13, 56, 16);
		panel.add(lblNewLabel_1);

		ActionListener btnls = new btnLsnr();
		ActionListener suplr = new supLsnr();
		ActionListener artcle = new lsarticle();
		ActionListener name = new lsnritemName();

		suppliercode = new JTextField();
		suppliercode.setBounds(68, 6, 116, 26);
		panel.add(suppliercode);
		suppliercode.setColumns(10);

		suppliername = new JTextField();
		suppliername.setFont(new Font("Tahoma", Font.BOLD, 12));
		suppliername.setBounds(184, 6, 285, 26);
		panel.add(suppliername);
		suppliername.setColumns(10);

		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.BOLD, 12));
		email.setEnabled(false);
		email.setBounds(184, 33, 285, 22);
		panel.add(email);
		email.setColumns(10);

		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.BOLD, 12));
		phone.setEnabled(false);
		phone.setBounds(184, 56, 134, 22);
		panel.add(phone);
		phone.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(146, 36, 38, 16);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Phone");
		lblNewLabel_5.setBounds(146, 59, 38, 16);
		panel.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Cr.Days");
		lblNewLabel_6.setBounds(324, 58, 56, 16);
		panel.add(lblNewLabel_6);

		creditDays = new JTextField();
		creditDays.setEnabled(false);
		creditDays.setBounds(384, 55, 85, 22);
		panel.add(creditDays);
		creditDays.setColumns(10);

		lblNewLabel_7 = new JLabel("Records");
		lblNewLabel_7.setBounds(485, 58, 56, 16);
		panel.add(lblNewLabel_7);

		records = new JTextField();
		records.setEnabled(false);
		records.setBounds(542, 55, 116, 22);
		panel.add(records);
		records.setColumns(10);

		JLabel lblNewLabel = new JLabel("Supplier Purchase Info Record");
		lblNewLabel.setBounds(0, 0, 1342, 24);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		purchaseInfoRecord.getContentPane().add(lblNewLabel);

		btnSave = new JButton("Save");
		btnSave.setBounds(255, 672, 97, 25);
		btnSave.setMnemonic('S');
		purchaseInfoRecord.getContentPane().add(btnSave);

		btnView = new JButton("View");
		btnView.setBounds(481, 106, 97, 25);
		btnView.setMnemonic('V');
		purchaseInfoRecord.getContentPane().add(btnView);

		btnClose = new JButton("Close");
		btnClose.setBounds(352, 672, 97, 25);
		purchaseInfoRecord.getContentPane().add(btnClose);

		btnDetail = new JButton("Get Details");
		btnDetail.setMnemonic('D');
		btnDetail.setBounds(578, 106, 97, 25);
		purchaseInfoRecord.getContentPane().add(btnDetail);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 133, 675, 537);
		purchaseInfoRecord.getContentPane().add(jsp);

		JLabel lblNewLabel_2 = new JLabel("Scan Item");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 110, 65, 16);
		purchaseInfoRecord.getContentPane().add(lblNewLabel_2);

		scanItem = new JTextField();
		scanItem.setFont(new Font("Tahoma", Font.BOLD, 13));
		scanItem.setBounds(75, 107, 126, 24);
		purchaseInfoRecord.getContentPane().add(scanItem);
		scanItem.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Search By Name");
		lblNewLabel_3.setBounds(203, 110, 97, 16);
		purchaseInfoRecord.getContentPane().add(lblNewLabel_3);

		searchname = new JTextField();
		searchname.setFont(new Font("Calibri", Font.BOLD, 13));
		searchname.setBounds(297, 106, 173, 25);
		purchaseInfoRecord.getContentPane().add(searchname);
		searchname.setColumns(10);

		optionPanel1 = new JPanel();
		optionPanel1.setBorder(new TitledBorder(null, "Supplier Schedule", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 51)));
		optionPanel1.setBounds(687, 133, 649, 531);

		optionPanel2 = new JPanel();
		optionPanel2.setBorder(new TitledBorder(null, "Supplier Schedule", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 51)));
		optionPanel2.setBounds(687, 133, 649, 531);

		optionPanel3 = new JPanel();
		optionPanel3.setBorder(new TitledBorder(null, "Supplier Schedule", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 51)));
		optionPanel3.setBounds(687, 133, 649, 531);

		purchaseInfoRecord.getContentPane().add(optionPanel1);
		optionPanel1.setLayout(null);
		purchaseInfoRecord.getContentPane().add(optionPanel2);
		purchaseInfoRecord.getContentPane().add(optionPanel3);

		btnSchedule = new JButton("Supply Schedule");
		btnSchedule.setMnemonic('S');
		btnSchedule.setBounds(686, 105, 132, 27);
		purchaseInfoRecord.getContentPane().add(btnSchedule);
		btnView.addActionListener(btnls);
		btnSave.addActionListener(btnls);
		btnClose.addActionListener(btnls);
		btnDetail.addActionListener(btnls);
		btnSchedule.addActionListener(btnls);
		suppliername.addActionListener(suplr);
		scanItem.addActionListener(artcle);
		searchname.addActionListener(name);
		decorate();

	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(purchaseInfoRecord);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		optionPanel1.setVisible(false);
		optionPanel2.setVisible(false);
		optionPanel3.setVisible(false);
	}

	class supLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vname = suppliername.getText();
			vname = "%" + vname + "%";
			try {
				new gnSupplier().getSupplier(vname);
			} catch (Throwable e) {
				new General().msg(e.getLocalizedMessage());
			} finally {
				suppliercode.setText(new gnSupplier().rvendorcode);
				suppliername.setText(new gnSupplier().rvendorName);
				phone.setText(new gnSupplier().rPhone);
				email.setText(new gnSupplier().rEmail);
				creditDays.setText(new gnSupplier().rcrdays);
			}
		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String value = e.getActionCommand();
			if (value == "Supply Schedule") {
				optionPanel1.setVisible(true);
				try {
					ProcessSchedule();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Save") {

			}
			if (value == "Close") {
				purchaseInfoRecord.dispose();
			}
			if (value == "Get Details") {
				try {
					getInfoRecord();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (value == "View") {
				btnSave.setEnabled(false);
				viewdata();
			}
		}
	}

	private void ProcessSchedule() throws ClassNotFoundException, SQLException {
		optionPanel1.setBounds(687, 133, 649, 531);
		sjsp = new JScrollPane();
		sjsp.setBounds(1, 1, 648, 530);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		optionPanel1.add(sjsp);
		String vsupplier = suppliercode.getText();
		String SQL = "Call Supplier_getSchedule(" + vcomp + ", " + vsupplier + ")";

		String pcol[] = { "Type", "code", "name", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "Leadtime",
				"CreditDays" };
		smodel.setColumnIdentifiers(pcol);

		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, pcol, 12, "N", "N", "N");
		stable.setModel(smodel);
		stable.setModel(smodel);
		stable.setRowHeight(25);
		new gnTable().setTableColWidth(stable, 2, 300);
		new gnTable().setTableColWidth(stable, 10, 70);
		new gnTable().setTableColWidth(stable, 11, 80);

		JViewport prt7 = new JViewport();
		sjsp.setViewport(null);
		prt7.setToolTipText(" Supplier Item Supply Schedule For Po Generation");
		prt7.setScrollMode(0);
		prt7.add(stable, pcol);
		sjsp.setViewport(prt7);
	}

	class lsnritemName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String sname = searchname.getText().trim();
			sname = "%" + sname + "%";
			String vType = "Article";
			String vtrantype = "ALL";
			String varticle = " ";
			try {
				new gnAdmin().Search(vType, sname, varticle, vtrantype);
				// new showData().show(jsp, ntable, vtext, x, y);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				try {
					varticle = new gnAdmin().rArticle;
					// new gnTable().RemoveTableRows(model);
					showArticle(varticle);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class lsarticle implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("id " + i);
			if (i == 1001) {
				String status = "Fail";
				String action = checkVendorEntry();
				try {
					String vcode = scanItem.getText();
					if (vcode.length() == 0) {
						return;
					}
					new gnTable().RemoveTableRows(model);
					String SQL = "Call purinfo_getArticlescan( " + vcomp + ", " + vcode + ")";
					btnSave.setEnabled(true);
					showTableData(SQL);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private void viewdata() {
		String vsupplier = suppliercode.getText();
		String SQL = "Call     po_getAllPurInfoRecord(" + vcomp + ", " + vstore + ", " + vsupplier + ")";
		try {
			new gnTable().RemoveTableRows(model);
			viewData(SQL);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void showArticle(String varticle) {
		String SQL = "Call purinfo_getArticlescan( " + vcomp + ", " + varticle + ")";
		try {
			showTableData(SQL);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showTableData(String SQL) throws Throwable {
		String pcol[] = { "Remove", "Article", "Name", "Cost", "Mrp", "SP" };
		model.setColumnIdentifiers(pcol);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "Remove", rs.getString(1), rs.getString(2), "0", "0", "0" });
		}
		table.setModel(model);
		table.setRowHeight(25);
		rs.close();
		removeRow(model, table);
		new gnTable().setTableColWidth(table, 2, 300);
		JViewport prt6 = new JViewport();
		jsp.setViewport(null);
		prt6.setToolTipText("Purchase Info Record");
		prt6.setScrollMode(0);
		prt6.add(table, pcol);
		jsp.setViewport(prt6);
	}

	public void viewData(String SQL) throws Throwable {
		String pcol[] = { "Remove", "Article", "Name", "No.of Times Supply Cost", "Avg.Cost" };
		model.setColumnIdentifiers(pcol);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "Remove", rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) });
		}
		table.setModel(model);
		table.setRowHeight(25);
		rs.close();
		removeRow(model, table);
		new gnTable().setTableColWidth(table, 2, 300);
		JViewport prt6 = new JViewport();
		jsp.setViewport(null);
		prt6.setToolTipText("Purchase Info Record");
		prt6.setScrollMode(0);
		prt6.add(table, pcol);
		jsp.setViewport(prt6);
	}

	private void getInfoRecord() throws Throwable {
		int row = table.getSelectedRow();
		if (row >= 0) {
			String vsupplier = suppliercode.getText();
			String varticle = table.getValueAt(row, 1).toString();
			new gnPO().getPurchaseInfoRecord(vsupplier, varticle);
		} else {
			new General().msg("Select Article Row  To View  Purchase Info Record ..");
		}

	}

	public void removeRow(DefaultTableModel xmodel, JTable xtable) {
		DefaultTableModel modelName = xmodel;
		JTable tableName = xtable;
		TableColumn Del = tableName.getColumnModel().getColumn(0);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setText("DEL");
		chkbox.setVisible(true);
		chkbox.setOpaque(true);
		chkbox.setToolTipText("Del Row ");
		chkbox.setSelected(true);
		Del.setCellEditor(new DefaultCellEditor(chkbox));
		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int nn = e.getStateChange();
				if (nn == 2 && modelName == model) {
					int lastrow = tableName.getRowCount();
					int r = tableName.getSelectedRow();
					int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
					if (option == 0) {
						modelName.removeRow(r);
						String RecordCount1 = Integer.toString((new gnTable().getRowCount(tableName)));
						records.setText(RecordCount1);
					}
					return;
				}
			}
		});
	}

	public String checkVendorEntry() {
		String vcode = suppliercode.getText();
		String action = "Sucess";
		if (vcode.length() == 0) {
			new General().msg("Select Vendor Code ");
			action = "Fail";
		}
		return action;
	}
}// Last

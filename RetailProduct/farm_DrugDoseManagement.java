package RetailProduct;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

import javax.swing.AbstractAction;
import javax.swing.JButton;

public class farm_DrugDoseManagement extends getResultSet {

	String vcomp;
	String vbranch;
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable();

	DefaultTableModel billmodel = new DefaultTableModel();
	JTable billtable = new JTable();

	DefaultTableModel Dosemodel = new DefaultTableModel();
	JTable Dosetable = new JTable();

	JScrollPane jsp;

	String Edit = "N";;
	JFrame DrugDoseframe;
	private JTextField farmername;
	private JTextField farmercode;
	private JLabel lblNewLabel_1;
	private JTextField craftname;
	private JTextField craftcode;
	private JLabel lblNewLabel_2;
	private JTextField seasonname;
	private JTextField seasoncode;
	private JLabel lblNewLabel_3;
	private JTextField totalland;
	private JLabel lblNewLabel_4;
	private JTextField frommonth;
	private JTextField tomonth;
	private JLabel lblNewLabel_5;
	private JPanel billpanel;
	private JScrollPane billjsp;
	private JPanel panel_1;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField billno;
	private JTextField billdate;
	private JLabel lblNewLabel_8;
	private JTextField itemcode;
	private JTextField itemname;
	private JLabel lblNewLabel_9;
	private JTextField qty;
	private JLabel lblNewLabel_10;
	private JTextField uom;
	private JScrollPane dosejsp;
	private JButton btnAdd;
	private JLabel lblNewLabel_11;
	private JTextField contentname;
	private JTextField contentcode;
	private JButton btnView;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					farm_DrugDoseManagement window = new farm_DrugDoseManagement();
					window.DrugDoseframe.setVisible(true);
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
	public farm_DrugDoseManagement() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		DrugDoseframe = new JFrame();
		DrugDoseframe.setAlwaysOnTop(true);
		DrugDoseframe.setBounds(10, 10, 1287, 700);
		DrugDoseframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		DrugDoseframe.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Select Farmer");
		lblNewLabel.setBounds(12, 13, 89, 16);
		DrugDoseframe.getContentPane().add(lblNewLabel);

		farmername = new JTextField();
		farmername.setToolTipText("Press Enter to Select Farmer");
		farmername.setBounds(103, 10, 283, 27);
		DrugDoseframe.getContentPane().add(farmername);
		farmername.setColumns(10);

		farmercode = new JTextField();
		farmercode.setEditable(false);
		farmercode.setBounds(388, 10, 62, 27);
		DrugDoseframe.getContentPane().add(farmercode);
		farmercode.setColumns(10);

		lblNewLabel_1 = new JLabel("Crop Details");
		lblNewLabel_1.setBounds(22, 52, 79, 16);
		DrugDoseframe.getContentPane().add(lblNewLabel_1);

		craftname = new JTextField();
		craftname.setBounds(103, 49, 283, 25);
		DrugDoseframe.getContentPane().add(craftname);
		craftname.setColumns(10);

		craftcode = new JTextField();
		craftcode.setEnabled(false);
		craftcode.setEditable(false);
		craftcode.setBounds(388, 49, 62, 25);
		DrugDoseframe.getContentPane().add(craftcode);
		craftcode.setColumns(10);

		lblNewLabel_2 = new JLabel("Season");
		lblNewLabel_2.setBounds(32, 81, 69, 16);
		DrugDoseframe.getContentPane().add(lblNewLabel_2);

		seasonname = new JTextField();
		seasonname.setBounds(103, 74, 283, 25);
		DrugDoseframe.getContentPane().add(seasonname);
		seasonname.setColumns(10);

		seasoncode = new JTextField();
		seasoncode.setEnabled(false);
		seasoncode.setEditable(false);
		seasoncode.setBounds(388, 74, 62, 25);
		DrugDoseframe.getContentPane().add(seasoncode);
		seasoncode.setColumns(10);

		lblNewLabel_3 = new JLabel("Area");
		lblNewLabel_3.setBounds(30, 110, 56, 16);
		DrugDoseframe.getContentPane().add(lblNewLabel_3);

		totalland = new JTextField();
		totalland.setBounds(103, 107, 69, 25);
		DrugDoseframe.getContentPane().add(totalland);
		totalland.setColumns(10);

		lblNewLabel_4 = new JLabel("For Month");
		lblNewLabel_4.setBounds(30, 139, 71, 16);
		DrugDoseframe.getContentPane().add(lblNewLabel_4);

		frommonth = new JTextField();
		frommonth.setBounds(103, 136, 67, 25);
		DrugDoseframe.getContentPane().add(frommonth);
		frommonth.setColumns(10);

		tomonth = new JTextField();
		tomonth.setBounds(101, 167, 71, 25);
		DrugDoseframe.getContentPane().add(tomonth);
		tomonth.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(603, 0, 654, 280);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Crop Details",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		DrugDoseframe.getContentPane().add(panel);
		panel.setLayout(null);

		jsp = new JScrollPane();
		jsp.setBounds(12, 36, 630, 238);
		panel.add(jsp);

		lblNewLabel_5 = new JLabel("Select Item From List ");
		lblNewLabel_5.setBounds(12, 476, 196, 16);
		DrugDoseframe.getContentPane().add(lblNewLabel_5);

		billpanel = new JPanel();
		billpanel.setBounds(0, 494, 607, 148);
		DrugDoseframe.getContentPane().add(billpanel);
		billpanel.setLayout(null);

		billjsp = new JScrollPane();
		billjsp.setBounds(12, 13, 583, 122);
		billpanel.add(billjsp);

		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(451, 10, 149, 91);
		DrugDoseframe.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lblNewLabel_6 = new JLabel("BillNo");
		lblNewLabel_6.setBounds(12, 13, 56, 16);
		panel_1.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Bill Date");
		lblNewLabel_7.setBounds(12, 38, 56, 16);
		panel_1.add(lblNewLabel_7);

		billno = new JTextField();
		billno.setBounds(69, 10, 68, 25);
		panel_1.add(billno);
		billno.setColumns(10);

		billdate = new JTextField();
		billdate.setBounds(69, 35, 68, 25);
		panel_1.add(billdate);
		billdate.setColumns(10);

		btnView = new JButton("View Bill");
		btnView.setBounds(40, 65, 97, 25);
		panel_1.add(btnView);

		dosejsp = new JScrollPane();
		dosejsp.setBounds(12, 280, 1245, 183);
		DrugDoseframe.getContentPane().add(dosejsp);

		btnAdd = new JButton("Add Record");
		btnAdd.setMnemonic('A');
		btnAdd.setBounds(366, 242, 114, 25);
		DrugDoseframe.getContentPane().add(btnAdd);

		btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(479, 244, 97, 25);
		DrugDoseframe.getContentPane().add(btnSave);

		JPanel dosePanel = new JPanel();
		dosePanel.setBounds(184, 114, 407, 115);
		DrugDoseframe.getContentPane().add(dosePanel);
		dosePanel.setLayout(null);

		lblNewLabel_8 = new JLabel("Item ");
		lblNewLabel_8.setBounds(0, 0, 69, 16);
		dosePanel.add(lblNewLabel_8);
		lblNewLabel_8.setForeground(Color.DARK_GRAY);
		lblNewLabel_8.setBackground(Color.DARK_GRAY);

		itemname = new JTextField();
		itemname.setBounds(0, 19, 312, 25);
		dosePanel.add(itemname);
		itemname.setEnabled(false);
		itemname.setEditable(false);
		itemname.setForeground(new Color(0, 0, 102));
		itemname.setColumns(10);

		contentname = new JTextField();
		contentname.setBounds(0, 54, 312, 22);
		dosePanel.add(contentname);
		contentname.setEditable(false);
		contentname.setForeground(new Color(0, 0, 102));
		contentname.setColumns(10);

		lblNewLabel_11 = new JLabel("Content");
		lblNewLabel_11.setBounds(0, 40, 56, 16);
		dosePanel.add(lblNewLabel_11);

		itemcode = new JTextField();
		itemcode.setBounds(313, 19, 82, 25);
		dosePanel.add(itemcode);
		itemcode.setEnabled(false);
		itemcode.setEditable(false);
		itemcode.setForeground(new Color(0, 0, 102));
		itemcode.setColumns(10);

		contentcode = new JTextField();
		contentcode.setBounds(311, 54, 79, 22);
		dosePanel.add(contentcode);
		contentcode.setEditable(false);
		contentcode.setForeground(new Color(0, 0, 102));
		contentcode.setColumns(10);

		qty = new JTextField();
		qty.setBounds(50, 77, 69, 22);
		dosePanel.add(qty);
		qty.setColumns(10);

		lblNewLabel_9 = new JLabel("Qty");
		lblNewLabel_9.setBounds(10, 80, 38, 16);
		dosePanel.add(lblNewLabel_9);

		lblNewLabel_10 = new JLabel("UOM");
		lblNewLabel_10.setBounds(127, 83, 38, 16);
		dosePanel.add(lblNewLabel_10);

		uom = new JTextField();
		uom.setBounds(158, 77, 56, 22);
		dosePanel.add(uom);
		uom.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("To Month");
		lblNewLabel_12.setBounds(30, 171, 56, 16);
		DrugDoseframe.getContentPane().add(lblNewLabel_12);

		ActionListener farmls = new farmerLsnr();
		farmername.addActionListener(farmls);

		// ActionListener billdtls = new billdateLsnr();
		// billdate.addActionListener(billdtls);

		ActionListener adddtls = new addLsnr();
		btnAdd.addActionListener(adddtls);

		ActionListener savels = new saveLsnr();
		btnSave.addActionListener(savels);

		ActionListener lsbillno = new billnoLsnr();
		billno.addActionListener(lsbillno);

		decorate();
	}

	private void decorate() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vbranch = new gnConfig().getStoreID();
		new gnTable().setTableBasics(Dosetable);
		new gnTable().setTableBasics(billtable);
		new gnTable().setTableBasics(table);
	}

	class billnoLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			//
			String vcust = farmercode.getText();
			try {
				new gnInvoice().getCustomerInvno(vcust);
			} catch (Throwable e2) {
				e2.printStackTrace();
			} finally {
				try {
					String vbillno = new gnInvoice().invno;
					String vbilldate = new gnInvoice().invdate;

					billno.setText(vbillno);
					billdate.setText(vbilldate);
					showBillDetails();
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
				}
			}
			//

		}
	}

	class saveLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String status = validate();
			if (status == "Sucess") {
				try {
					callSaveEvent();
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private String validate() {
		String status = "Sucess";

		if (Dosetable.getRowCount() == 0) {
			new General().msg("No  Records Are Avalibale To Save, Add Records for Dose Tratment");
			status = "Fail";
		}

		if (farmercode.getText().length() == 0) {
			new General().msg("Please Select Farmer to Process Transaction");
			farmername.grabFocus();
			status = "Fail";
		}

		return status;
	}

	private void callSaveEvent() throws ClassNotFoundException, SQLException, IOException {

		// String col[] = {"Remove","Season" , "Name" , "Craft" , "Craft Name" ,
		// "Article" , "Name" , "Qty" , "Uom", "Content", "Cont.Name", "Land",
		// "From", "TO"};

		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		Connection con = this.getConnection();
		con.setAutoCommit(false);

		String grndetail = "Insert into   farm_carfdrug_mapping(Company_code, branch_code, Farmercode, farmername, assign_date,"
				+ " seasoncode, seasonname, craftcode, craftName, article_code, Name,  qty, uom,"
				+ " content_code, content_name, land, frommonth , tomonth )"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int row = Dosetable.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con.prepareStatement(grndetail);

				prst.setString(1, vcomp);
				prst.setString(2, vbranch);
				prst.setString(3, farmercode.getText());
				prst.setString(4, farmername.getText());
				prst.setString(5, new gnConfig().date_ConverttoDBforamt(new General().getDate()));

				prst.setString(6, Dosetable.getValueAt(k, 1).toString());
				prst.setString(7, Dosetable.getValueAt(k, 2).toString());
				prst.setString(8, Dosetable.getValueAt(k, 3).toString());
				prst.setString(9, Dosetable.getValueAt(k, 4).toString());
				prst.setString(10, Dosetable.getValueAt(k, 5).toString());
				prst.setString(11, Dosetable.getValueAt(k, 6).toString());
				prst.setString(12, Dosetable.getValueAt(k, 7).toString());
				prst.setString(13, Dosetable.getValueAt(k, 8).toString());
				prst.setString(14, Dosetable.getValueAt(k, 9).toString());
				prst.setString(15, Dosetable.getValueAt(k, 10).toString());
				prst.setString(16, Dosetable.getValueAt(k, 11).toString());
				prst.setString(17, Dosetable.getValueAt(k, 12).toString());
				prst.setString(18, Dosetable.getValueAt(k, 13).toString());

				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					con.commit();
				}
				prst.executeBatch(); // insert remaining records
				con.commit();
			}
		} catch (SQLException e) {
			new General().msg("GL Creation Master " + e.getMessage());
			con.rollback();
		} finally {
			if (prst != null) {
				prst.close();
				new General().msg("Data Saved SucessFully");
				setDefault();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	private void setDefault() {

		new gnTable().RemoveTableRows(Dosemodel);
		new gnTable().RemoveTableRows(billmodel);
		new gnTable().RemoveTableRows(model);
		farmername.setText(null);
		farmercode.setText(null);
		contentcode.setText(null);
		contentname.setText(null);
		frommonth.setText(null);
		tomonth.setText(null);
		totalland.setText(null);
		itemcode.setText(null);
		itemname.setText(null);
		qty.setText(null);
		uom.setText(null);
		craftname.setText(null);
		craftcode.setText(null);
		seasoncode.setText(null);
		seasonname.setText(null);
	}

	class addLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			addRecordtoTable();
		}
	}

	private void addRecordtoTable() {

		String col[] = { "Remove", "Season", "Name", "Craft", "Craft Name", "Article", "Name", "Qty", "Uom", "Content",
				"Cont.Name", "Land", "From", "TO" };
		Dosemodel.setColumnIdentifiers(col);
		Dosetable.setModel(Dosemodel);
		Dosemodel.addRow(
				new Object[] { "", seasoncode.getText(), seasonname.getText(), craftcode.getText(), craftname.getText(),
						itemcode.getText(), itemname.getText(), qty.getText(), uom.getText(), contentcode.getText(),
						contentname.getText(), totalland.getText(), frommonth.getText(), tomonth.getText() });
		new General().removeRow(Dosemodel, Dosetable);
		JViewport prt666 = new JViewport();
		dosejsp.setViewport(null);
		prt666.setToolTipText("Farmer ScrollPaneport");
		prt666.setScrollMode(0);
		prt666.add(Dosetable, col);
		dosejsp.setViewport(prt666);
	}

	class billdateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				showBillDetails();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void showBillDetails() throws ClassNotFoundException, SQLException {
		String vdocno = billno.getText();
		String vdocdate = new gnConfig().date_ConverttoDBforamt(billdate.getText());
		String SQL = "call  farm_viewBillDataForDrug(" + vcomp + " , " + vbranch + ", " + vdocno + " , '" + vdocdate
				+ "')";
		new gnTable().RemoveTableRows(billmodel);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			String col[] = { "Article", "Name", "Qty", "UOM", "Content", "Content Name" };
			billmodel.insertRow(0, new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6) });
			billmodel.setColumnIdentifiers(col);
			billtable.setModel(billmodel);
			new General().removeRow(billmodel, billtable);
			JViewport prt66 = new JViewport();
			billjsp.setViewport(null);
			prt66.setToolTipText("Farmer ScrollPaneport");
			prt66.setScrollMode(0);
			prt66.add(billtable, col);
			billjsp.setViewport(prt66);
			SelectBillRow();
		}
	}

	public void SelectBillRow() {
		billtable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		billtable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = billtable.getSelectedRow();
					String value = (String) billtable.getValueAt(row, 2);
					displayBillData(row);
					// new General().msgDispose()
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				new General().msgDispose();
			}
		});
	}

	private void displayBillData(int row) {

		itemcode.setText(billtable.getValueAt(row, 0).toString());
		itemname.setText(billtable.getValueAt(row, 1).toString());
		qty.setText(billtable.getValueAt(row, 2).toString());
		uom.setText(billtable.getValueAt(row, 3).toString());
		contentcode.setText(billtable.getValueAt(row, 4).toString());
		contentname.setText(billtable.getValueAt(row, 5).toString());
	}

	class farmerLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vname = farmername.getText().toString();
			vname = "%" + vname + "%";
			String vtype = "Farmer";
			try {

				// new gnFarmer().getFarmerDetail(vtype, vname);
				new gnSupplier().getCustomer(vname);

			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				farmercode.setText(new gnSupplier().rcustcode);
				farmername.setText(new gnSupplier().rcustName);
				try {
					showData();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void showData() throws ClassNotFoundException, SQLException {
		String vfarmercode = farmercode.getText();
		String col[] = { "Remove", "Farmer", "Name", "Season", "Season Name", "Crop", "CropName", "Land", "From",
				"ToMonth" };
		model.setColumnIdentifiers(col);
		String SQL = "call  farm_getFarmerCraftData(" + vcomp + " , " + vbranch + ", " + vfarmercode + ")";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.insertRow(0, new Object[] { "", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			table.setModel(model);
			new General().removeRow(model, table);
			new General().msg(rs.getString(1));
			JViewport prt6 = new JViewport();
			prt6.setToolTipText("Farmer ScrollPaneport");
			prt6.setScrollMode(0);
			prt6.add(table, col);
			jsp.setViewport(prt6);
			Selectrow();
		}
	}

	public void Selectrow() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String value = (String) table.getValueAt(row, 2);
					displayData(row);
					// new General().msgDispose()
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				new General().msgDispose();
			}
		});
	}

	private void displayData(int row) {
		// String col[] = {"Remove", "Farmer" , "Name" , "Season" , "Season
		// Name" , "Craft" , "CraftName" , "Land" , "From" , "ToMonth" } ;
		seasoncode.setText(table.getValueAt(row, 3).toString());
		seasonname.setText(table.getValueAt(row, 4).toString());
		craftcode.setText(table.getValueAt(row, 5).toString());
		craftname.setText(table.getValueAt(row, 6).toString());
		totalland.setText(table.getValueAt(row, 7).toString());
		frommonth.setText(table.getValueAt(row, 8).toString());
		tomonth.setText(table.getValueAt(row, 9).toString());
		// model.removeRow(row);
		// Edit = "Y";
	}
}

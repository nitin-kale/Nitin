package RetailProduct;

import java.awt.Component;
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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

public class CropandDoseManagment extends getResultSet {

	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable();
	String Edit = "N";

	DefaultTableModel dosemodel = new DefaultTableModel();
	JTable dosetable = new JTable();
	JScrollPane dosejsp;

	DefaultTableModel billmodel = new DefaultTableModel();
	JTable billtable = new JTable();
	// JScrollPane billjsp ;

	JScrollPane mappingJsp;
	DefaultTableModel mappingmodel = new DefaultTableModel();
	JTable mappingtable = new JTable();

	JFrame cropdoseframe;
	JButton btnSaveCrop;
	private JTextField farmername;
	private JTextField farmercode;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField seasonname;
	private JTextField seasoncode;
	private JTextField cropname;
	private JTextField cropcode;
	private JTextField totalArea;
	private JTextField frommonth;
	private JTextField tomonth;

	JScrollPane jsp;
	private JLabel lblNewLabel_6;
	private JTextField billno;
	private JTextField billdate;
	private JScrollPane billjsp;
	private JLabel lblNewLabel_7;
	private JTextField mseasonname;
	private JTextField mseasoncode;
	private JLabel lblNewLabel_8;
	private JTextField mcropname;
	private JTextField mcropcode;
	private JLabel lblNewLabel_9;
	private JTextField mfrommonth;
	private JTextField mtomonth;
	private JLabel lblNewLabel_10;
	private JTextField area;
	private JLabel lblNewLabel_11;
	private JTextField name;
	private JLabel lblNewLabel_12;
	private JTextField contentname;
	private JLabel lblNewLabel_13;
	private JTextField qty;
	private JTextField uom;
	private JTextField itemcode;
	private JTextField contentcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					CropandDoseManagment window = new CropandDoseManagment();
					window.cropdoseframe.setVisible(true);
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
	public CropandDoseManagment() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		cropdoseframe = new JFrame();
		cropdoseframe.setAlwaysOnTop(true);
		cropdoseframe.setBounds(10, 10, 1250, 650);
		cropdoseframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cropdoseframe.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Select Farmer");
		lblNewLabel.setBounds(12, 25, 103, 16);
		cropdoseframe.getContentPane().add(lblNewLabel);

		farmername = new JTextField();
		farmername.setBounds(104, 22, 198, 27);
		cropdoseframe.getContentPane().add(farmername);
		farmername.setColumns(10);

		farmercode = new JTextField();
		farmercode.setBounds(304, 22, 82, 27);
		cropdoseframe.getContentPane().add(farmercode);
		farmercode.setColumns(10);

		JTabbedPane tbpanel = new JTabbedPane(JTabbedPane.TOP);
		JPanel cropPanel = new JPanel();
		cropPanel.setBorder(new MatteBorder(3, 3, 1, 5, (Color) new Color(0, 0, 0)));
		cropPanel.setBackground(Color.WHITE);
		JPanel dosePanel = new JPanel();
		dosePanel.setBackground(Color.WHITE);
		dosePanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.RED, null));

		tbpanel.addTab("Crop Info", cropPanel);
		tbpanel.addTab("Dose Treatment", dosePanel);
		dosePanel.setLayout(null);

		dosejsp = new JScrollPane();
		dosejsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		dosejsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		dosejsp.setBounds(6, 216, 714, 225);
		dosePanel.add(dosejsp);

		lblNewLabel_6 = new JLabel("Selecct Bill No");
		lblNewLabel_6.setBounds(19, 30, 97, 16);
		dosePanel.add(lblNewLabel_6);

		billno = new JTextField();
		billno.setBounds(122, 24, 122, 28);
		dosePanel.add(billno);
		billno.setColumns(10);

		billdate = new JTextField();
		billdate.setBounds(247, 24, 122, 28);
		dosePanel.add(billdate);
		billdate.setColumns(10);

		billjsp = new JScrollPane();
		billjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		billjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		billjsp.setBounds(6, 53, 708, 163);
		dosePanel.add(billjsp);

		JPanel mappingpanel = new JPanel();
		mappingpanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GREEN, Color.MAGENTA));
		mappingpanel.setBackground(Color.CYAN);
		mappingpanel.setBounds(715, 6, 499, 188);
		dosePanel.add(mappingpanel);
		mappingpanel.setLayout(null);

		lblNewLabel_7 = new JLabel("Season");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(6, 18, 55, 16);
		mappingpanel.add(lblNewLabel_7);

		mseasonname = new JTextField();
		mseasonname.setForeground(Color.BLACK);
		mseasonname.setBounds(60, 12, 199, 28);
		mappingpanel.add(mseasonname);
		mseasonname.setColumns(10);

		mseasoncode = new JTextField();
		mseasoncode.setForeground(Color.BLACK);
		mseasoncode.setBounds(256, 12, 43, 28);
		mappingpanel.add(mseasoncode);
		mseasoncode.setColumns(10);

		lblNewLabel_8 = new JLabel("Crop");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(6, 46, 55, 16);
		mappingpanel.add(lblNewLabel_8);

		mcropname = new JTextField();
		mcropname.setForeground(Color.BLACK);
		mcropname.setBounds(60, 42, 199, 28);
		mappingpanel.add(mcropname);
		mcropname.setColumns(10);

		mcropcode = new JTextField();
		mcropcode.setForeground(Color.BLACK);
		mcropcode.setBounds(256, 42, 43, 28);
		mappingpanel.add(mcropcode);
		mcropcode.setColumns(10);

		lblNewLabel_9 = new JLabel("Month");
		lblNewLabel_9.setBounds(307, 18, 43, 16);
		mappingpanel.add(lblNewLabel_9);

		mfrommonth = new JTextField();
		mfrommonth.setForeground(Color.BLACK);
		mfrommonth.setBounds(354, 12, 61, 28);
		mappingpanel.add(mfrommonth);
		mfrommonth.setColumns(10);

		mtomonth = new JTextField();
		mtomonth.setForeground(Color.BLACK);
		mtomonth.setBounds(416, 12, 61, 28);
		mappingpanel.add(mtomonth);
		mtomonth.setColumns(10);

		lblNewLabel_10 = new JLabel("Area");
		lblNewLabel_10.setBounds(307, 46, 55, 16);
		mappingpanel.add(lblNewLabel_10);

		area = new JTextField();
		area.setEnabled(false);
		area.setEditable(false);
		area.setBounds(354, 40, 61, 28);
		mappingpanel.add(area);
		area.setColumns(10);

		lblNewLabel_11 = new JLabel("Item");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setBounds(6, 96, 55, 16);
		mappingpanel.add(lblNewLabel_11);

		name = new JTextField();
		name.setEnabled(false);
		name.setBounds(60, 90, 239, 28);
		mappingpanel.add(name);
		name.setColumns(10);

		lblNewLabel_12 = new JLabel("Content");
		lblNewLabel_12.setBounds(6, 121, 55, 16);
		mappingpanel.add(lblNewLabel_12);

		contentname = new JTextField();
		contentname.setEnabled(false);
		contentname.setBounds(60, 115, 239, 28);
		mappingpanel.add(contentname);
		contentname.setColumns(10);

		lblNewLabel_13 = new JLabel("Qty");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(6, 149, 55, 16);
		mappingpanel.add(lblNewLabel_13);

		qty = new JTextField();
		qty.setBounds(60, 143, 78, 28);
		mappingpanel.add(qty);
		qty.setColumns(10);

		uom = new JTextField();
		uom.setBounds(137, 143, 61, 28);
		mappingpanel.add(uom);
		uom.setColumns(10);

		JButton btnAdd = new JButton("Add Record");
		btnAdd.setBounds(201, 143, 142, 28);
		mappingpanel.add(btnAdd);

		itemcode = new JTextField();
		itemcode.setEnabled(false);
		itemcode.setBounds(296, 90, 47, 28);
		mappingpanel.add(itemcode);
		itemcode.setColumns(10);

		contentcode = new JTextField();
		contentcode.setEnabled(false);
		contentcode.setBounds(296, 115, 48, 28);
		mappingpanel.add(contentcode);
		contentcode.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(1107, 193, 107, 36);
		dosePanel.add(btnSave);

		mappingJsp = new JScrollPane();
		mappingJsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mappingJsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		mappingJsp.setBounds(715, 226, 499, 215);
		dosePanel.add(mappingJsp);

		cropPanel.setLayout(null);

		lblNewLabel_1 = new JLabel("Season");
		lblNewLabel_1.setBounds(12, 27, 76, 16);
		cropPanel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Crop Detail");
		lblNewLabel_2.setBounds(12, 56, 76, 16);
		cropPanel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Area Plant");
		lblNewLabel_3.setBounds(12, 90, 76, 16);
		cropPanel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Month From");
		lblNewLabel_4.setBounds(12, 125, 76, 16);
		cropPanel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Month To");
		lblNewLabel_5.setBounds(12, 161, 76, 16);
		cropPanel.add(lblNewLabel_5);

		seasonname = new JTextField();
		seasonname.setBounds(107, 24, 206, 25);
		cropPanel.add(seasonname);
		seasonname.setColumns(10);

		seasoncode = new JTextField();
		seasoncode.setBounds(313, 24, 53, 25);
		cropPanel.add(seasoncode);
		seasoncode.setColumns(10);

		cropname = new JTextField();
		cropname.setBounds(107, 53, 206, 25);
		cropPanel.add(cropname);
		cropname.setColumns(10);

		cropcode = new JTextField();
		cropcode.setBounds(313, 53, 53, 25);
		cropPanel.add(cropcode);
		cropcode.setColumns(10);

		totalArea = new JTextField();
		totalArea.setBounds(107, 87, 116, 25);
		cropPanel.add(totalArea);
		totalArea.setColumns(10);

		frommonth = new JTextField();
		frommonth.setBounds(107, 122, 116, 25);
		cropPanel.add(frommonth);
		frommonth.setColumns(10);

		tomonth = new JTextField();
		tomonth.setBounds(107, 158, 116, 25);
		cropPanel.add(tomonth);
		tomonth.setColumns(10);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(386, 13, 655, 376);
		cropPanel.add(jsp);

		btnSaveCrop = new JButton("Save Crop Details");
		btnSaveCrop.setBounds(6, 402, 156, 28);
		cropPanel.add(btnSaveCrop);
		tbpanel.setBounds(12, 115, 1220, 477);
		cropdoseframe.getContentPane().add(tbpanel);

		ActionListener lscrplsnr = new cropLsnr();
		ActionListener lsseason = new seasonLsnr();
		ActionListener lstomnth = new toonthLsnr();
		ActionListener lsfrom = new frommonthLsnr();
		ActionListener lsframer = new farmenrLsnr();

		ActionListener lsbtncrop = new btncropsaveLsnr();
		btnSaveCrop.addActionListener(lsbtncrop);

		farmername.addActionListener(lsframer);
		seasonname.addActionListener(lsseason);
		cropname.addActionListener(lscrplsnr);
		frommonth.addActionListener(lsfrom);
		tomonth.addActionListener(lstomnth);

		ActionListener lsbillno = new billnoLsnr();
		billno.addActionListener(lsbillno);

		ActionListener lsadd = new addLsnr();
		btnAdd.addActionListener(lsadd);

		ActionListener lssave = new saveLsnr();
		btnSave.addActionListener(lssave);

		decorate();

	}

	private void decorate() throws Throwable {

		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		new gnApp().setFrameTitel(cropdoseframe);

	}

	// Starts here Crop Manegement

	class btncropsaveLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				insertCropDetails();
				showData();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class farmenrLsnr implements ActionListener {
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
				// btnView.doClick();
				try {
					showData();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	class cropLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vtype = "Crop";
			try {
				new gnAdmin().showMasterTable(vtype, cropcode, cropname);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class seasonLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vtype = "Season";
			try {
				new gnAdmin().showMasterTable(vtype, seasoncode, seasonname);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class toonthLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vtype = "Month";
			try {
				new gnAdmin().showMasterTable(vtype, tomonth, tomonth);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class frommonthLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vtype = "Month";
			try {
				new gnAdmin().showMasterTable(vtype, frommonth, frommonth);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void showData() throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		new gnTable().RemoveTableRows(dosemodel);

		String vfarmercode = farmercode.getText();
		String col[] = { "Remove", "Farmer", "Name", "Season", "Season Name", "Craft", "CraftName", "Land", "From",
				"ToMonth" };

		model.setColumnIdentifiers(col);
		dosemodel.setColumnIdentifiers(col);
		String SQL = "call  farm_getFarmerCraftData(" + vcomp + " , " + vstore + ", '" + vfarmercode + "')";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.insertRow(0, new Object[] { "", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			dosemodel
					.insertRow(0,
							new Object[] { "", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
									rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
									rs.getString(9) });
			table.setModel(model);
			dosetable.setModel(dosemodel);

			new gnTable().setTableBasics(table);
			new gnTable().setTableBasics(dosetable);

			JViewport prt6 = new JViewport();
			prt6.setToolTipText("Farmer ScrollPaneport");
			prt6.setScrollMode(0);
			prt6.add(table, col);
			jsp.setViewport(prt6);
			jsp.setVisible(true);
			table.grabFocus();

			// dose

			JViewport prt66 = new JViewport();
			prt66.setToolTipText("Farmer ScrollPaneport");
			prt66.setScrollMode(0);
			prt66.add(dosetable, col);
			dosejsp.setViewport(prt66);
			dosejsp.setVisible(true);
			// End dose

			Selectrow1();

		}
	}

	private void insertCropDetails() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String grndetail = "Insert into  ms_farmercarft_master(Company_code, branch_code, Farmercode, seasoncode, "
				+ " seasonname, craftcode, craftName, landArea, Frommonth , tomonth )" + "values(?,?,?,?,?,?,?,?,?,? )";
		try {
			prst = con.prepareStatement(grndetail);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, farmercode.getText());
			prst.setString(4, seasoncode.getText());
			prst.setString(5, seasonname.getText());
			prst.setString(6, cropcode.getText());
			prst.setString(7, cropname.getText());
			prst.setString(8, totalArea.getText());
			prst.setString(9, frommonth.getText());
			prst.setString(10, tomonth.getText());
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				con.commit();
			}
			prst.executeBatch(); // insert remaining records
			con.commit();

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
		// farmercode.setText(null);
		// farmername.setText(null);
		frommonth.setText(null);
		tomonth.setText(null);
		seasoncode.setText(null);
		seasonname.setText(null);
		cropname.setText(null);
		cropcode.setText(null);
		farmername.grabFocus();

	}

	private void updateData() throws Throwable {
		String vcode = farmercode.getText();
		String SQL = "call farm_updateFarmcraft(" + vcomp + ", " + vstore + " , " + vcode + ")";
		this.getResult(SQL);
	}

	// Dose Management

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

	private void showBillDetails() throws ClassNotFoundException, SQLException {
		String vdocno = billno.getText();
		String vdocdate = new gnConfig().date_ConverttoDBforamt(billdate.getText());
		String SQL = "call  farm_viewBillDataForDrug(" + vcomp + " , " + vstore + ", " + vdocno + " , '" + vdocdate
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
		name.setText(billtable.getValueAt(row, 1).toString());
		qty.setText(billtable.getValueAt(row, 2).toString());
		uom.setText(billtable.getValueAt(row, 3).toString());
		contentcode.setText(billtable.getValueAt(row, 4).toString());
		contentname.setText(billtable.getValueAt(row, 5).toString());
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
		mappingmodel.setColumnIdentifiers(col);
		mappingtable.setModel(mappingmodel);
		mappingmodel.addRow(new Object[] { "", mseasoncode.getText(), mseasonname.getText(), mcropcode.getText(),
				mcropname.getText(), itemcode.getText(), name.getText(), qty.getText(), uom.getText(),
				contentcode.getText(), contentname.getText(), area.getText(), frommonth.getText(), tomonth.getText() });
		new General().removeRow(mappingmodel, mappingtable);
		JViewport prt666 = new JViewport();
		mappingJsp.setViewport(null);
		prt666.setToolTipText("Farmer ScrollPaneport");
		prt666.setScrollMode(0);
		prt666.add(mappingtable, col);
		mappingJsp.setViewport(prt666);
	}

	public void Selectrow1() {
		dosetable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		dosetable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = dosetable.getSelectedRow();
					String value = (String) dosetable.getValueAt(row, 2);
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
		mseasoncode.setText(dosetable.getValueAt(row, 3).toString());
		mseasonname.setText(dosetable.getValueAt(row, 4).toString());
		mcropcode.setText(dosetable.getValueAt(row, 5).toString());
		mcropname.setText(dosetable.getValueAt(row, 6).toString());
		area.setText(dosetable.getValueAt(row, 7).toString());
		mfrommonth.setText(dosetable.getValueAt(row, 8).toString());
		mtomonth.setText(dosetable.getValueAt(row, 9).toString());
		// model.removeRow(row);
		// Edit = "Y";
	}

	class saveLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				callSaveEvent();
			} catch (ClassNotFoundException | SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
			int row = mappingtable.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con.prepareStatement(grndetail);

				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, farmercode.getText());
				prst.setString(4, farmername.getText());
				prst.setString(5, new gnConfig().date_ConverttoDBforamt(new General().getDate()));

				prst.setString(6, mappingtable.getValueAt(k, 1).toString());
				prst.setString(7, mappingtable.getValueAt(k, 2).toString());
				prst.setString(8, mappingtable.getValueAt(k, 3).toString());
				prst.setString(9, mappingtable.getValueAt(k, 4).toString());
				prst.setString(10, mappingtable.getValueAt(k, 5).toString());
				prst.setString(11, mappingtable.getValueAt(k, 6).toString());
				prst.setString(12, mappingtable.getValueAt(k, 7).toString());
				prst.setString(13, mappingtable.getValueAt(k, 8).toString());
				prst.setString(14, mappingtable.getValueAt(k, 9).toString());
				prst.setString(15, mappingtable.getValueAt(k, 10).toString());
				prst.setString(16, mappingtable.getValueAt(k, 11).toString());
				prst.setString(17, mappingtable.getValueAt(k, 12).toString());
				prst.setString(18, mappingtable.getValueAt(k, 13).toString());

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

}// Last

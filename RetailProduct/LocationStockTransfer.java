package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Connection;
import javax.swing.ImageIcon;

public class LocationStockTransfer extends getResultSet {

	JFrame locationtrfFrame;
	private Connection con1, con2, con3;
	private JTextField storecode;
	private String DBdetail;
	private String DBhdr;
	int selectedrow;
	private JTextField storename;
	private JTextField code;
	private JTextField search;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox from;
	private JComboBox toloc;
	private JRadioButton rbbrand;
	private JRadioButton rbarticle;
	private JScrollPane jsp;
	private String Choice = " ";
	private String vcomp;
	private String vstore;
	private JButton btnGetbatch;
	private JButton btnClose;
	private JButton btnSave;
	private String vtrfdate;
	private String vtrfno;
	private String vfinyear;

	private String Col[] = { "Remove", "Article", "Name", "UOM", "Cost", "SalesPrice", "MRP", "Bal.Qty", "From Loc.",
			"TrfQty", "TO Loc.", "Batch Article", "BatchNO", "Manuf.Date", "Expiry date" };

	// {"Remove" , 1"Article",2 "Name" , 3"UOM" , 4"Cost" , 5"SalesPrice" , 6
	// "MRP" ,
	// 7 "Bal.Qty" , 8 "From Loc." , 9 "Tramsfer Qty" , 10"TO Loc." , 11"Batch
	// Article" ,
	// 12 "BatchNO" , 13 "Manuf.Date" , 14 "Expiry date" } ;

	DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 9 || column == 12 || column == 13 || column == 14 ? true : false;
		}
	};

	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 9 || column == 12 || column == 13 || column == 14) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(new Color(51, 51, 102));
				componentt.setCursor(getCursor());
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
			}

			if (getValueAt(roww, 11).toString().equalsIgnoreCase("N")) {
				componentt.setBackground(Color.cyan);
			} else if (getValueAt(roww, 11).toString().equalsIgnoreCase("Y")) {
				componentt.setBackground(Color.GREEN);
			}

			if (column == 9 || column == 12 || column == 13 || column == 14) {
				componentt.setBackground(Color.white);
				// componentt.setForeground(new Color(204,255,153));
			}

			return componentt;
		}
	};
	private JTextField date;
	///

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocationStockTransfer window = new LocationStockTransfer();
					window.locationtrfFrame.setVisible(true);
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
	public LocationStockTransfer() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		locationtrfFrame = new JFrame();
		locationtrfFrame.setResizable(false);
		locationtrfFrame.setAlwaysOnTop(true);
		locationtrfFrame.setBounds(100, 100, 1232, 600);
		locationtrfFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		locationtrfFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Location To Location Stock Transfer");
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(445, 6, 395, 20);
		locationtrfFrame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 37, 821, 176);
		locationtrfFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Branch ");
		lblNewLabel_1.setBounds(12, 13, 55, 16);
		panel.add(lblNewLabel_1);

		storecode = new JTextField();
		storecode.setEditable(false);
		storecode.setBounds(77, 7, 122, 28);
		panel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setEditable(false);
		storename.setBounds(199, 7, 315, 28);
		panel.add(storename);
		storename.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBorder(new TitledBorder(null, "Select Location For Stock Transfer", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 51, 102)));
		panel_1.setBounds(6, 41, 635, 90);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("From Loc.");
		lblNewLabel_2.setBounds(181, 32, 55, 16);
		panel_1.add(lblNewLabel_2);

		ActionListener rbls = new rbLsnr();
		ActionListener btn = new btnLsnr();

		from = new JComboBox();
		from.setModel(new DefaultComboBoxModel(new String[] { "SL" }));
		from.setBounds(248, 27, 133, 26);
		panel_1.add(from);

		JLabel lblNewLabel_3 = new JLabel("To Loc.");
		lblNewLabel_3.setBounds(415, 32, 55, 16);
		panel_1.add(lblNewLabel_3);

		toloc = new JComboBox();
		toloc.setModel(new DefaultComboBoxModel(new String[] { "SL" }));
		toloc.setBounds(464, 27, 148, 26);
		panel_1.add(toloc);

		rbarticle = new JRadioButton("Article");
		rbarticle.addActionListener(rbls);
		buttonGroup.add(rbarticle);
		rbarticle.setBounds(18, 16, 115, 18);
		panel_1.add(rbarticle);

		rbbrand = new JRadioButton("Brand");
		rbbrand.addActionListener(rbls);
		buttonGroup.add(rbbrand);
		rbbrand.setBounds(18, 46, 115, 18);
		panel_1.add(rbbrand);

		JLabel lblNewLabel_4 = new JLabel("Enter Code");
		lblNewLabel_4.setBounds(32, 143, 76, 16);
		panel.add(lblNewLabel_4);

		code = new JTextField();
		code.setForeground(new Color(0, 0, 51));
		code.setFont(new Font("SansSerif", Font.BOLD, 15));
		ActionListener codeLs = new CodeLsnr();
		code.addActionListener(codeLs);
		code.setBounds(97, 135, 159, 35);
		panel.add(code);
		code.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Search By Name");
		lblNewLabel_5.setForeground(new Color(0, 0, 51));
		lblNewLabel_5.setBounds(268, 143, 99, 16);
		panel.add(lblNewLabel_5);

		search = new JTextField();
		search.setFont(new Font("SansSerif", Font.BOLD, 15));
		search.setBounds(365, 135, 276, 35);
		ActionListener srch = new SearchLsnr();
		search.addActionListener(srch);
		panel.add(search);
		search.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Date");
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_6.setForeground(SystemColor.activeCaptionText);
		lblNewLabel_6.setBounds(586, 13, 40, 16);
		panel.add(lblNewLabel_6);

		date = new JTextField();
		date.setBackground(SystemColor.controlHighlight);
		date.setEditable(false);
		date.setFont(new Font("SansSerif", Font.BOLD, 14));
		date.setBounds(631, 7, 122, 28);
		panel.add(date);
		date.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.addActionListener(btn);
		btnSave.setMnemonic('S');
		btnSave.setBounds(540, 516, 90, 28);
		locationtrfFrame.getContentPane().add(btnSave);

		btnClose = new JButton("Close");
		btnClose.addActionListener(btn);
		btnClose.setMnemonic('C');
		btnClose.setBounds(630, 516, 90, 28);
		locationtrfFrame.getContentPane().add(btnClose);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(12, 222, 1208, 288);
		locationtrfFrame.getContentPane().add(jsp);

		btnGetbatch = new JButton("Get Batch Details");

		btnGetbatch.setMnemonic('G');
		btnGetbatch.addActionListener(btn);
		btnGetbatch.setBounds(1046, 181, 174, 28);
		locationtrfFrame.getContentPane().add(btnGetbatch);

		lblNewLabel_7 = new JLabel(" ");
		lblNewLabel_7
				.setIcon(new ImageIcon(LocationStockTransfer.class.getResource("/RetailProduct/stocktransfer.jpg")));
		lblNewLabel_7.setBounds(894, 13, 326, 143);
		locationtrfFrame.getContentPane().add(lblNewLabel_7);
		decorate();
	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(locationtrfFrame);
		new gnDecorate().DispField_BevalRaised(jsp);
		new gnDecorate().DispField_Eatch(code, 10);
		new gnDecorate().DispField_Eatch(search, 10);
		vfinyear = new gnFinYear().getReportingFinYear();
		vcomp = new gnConfig().getCompanyCode();
		rbarticle.setSelected(true);
		if (vcomp == "0") {
			locationtrfFrame.dispose();
			return;

		}
		vstore = new gnConfig().getStoreID();
		storecode.setText(vstore);
		storename.setText(new gnConfig().getStorename(vstore));
		String vmsname = "Location";
		String verticle = new gnHierarchy().getVerticleCode();
		String Search = "%%";
		String SQL1 = "call master_getMasterData('" + vmsname + "' , " + verticle + "    , '" + Search + "')";
		new gnComp().fillCombo(SQL1, from);
		new gnComp().fillCombo(SQL1, toloc);
		Choice = "Article";
		date.setText(new General().getDate());
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Close") {
				locationtrfFrame.dispose();
			}

			if (value == "Save") {
				try {
					PrepareToInsert();
				} catch (Throwable e1) {
					e1.printStackTrace();
					new General().msg("Save==>" + e1.getLocalizedMessage());
				}
			}

			if (value == "Get Batch Details") {
				showBatch();
			}

		}
	}

	private void showBatch() {
		// {"Remove" , 1"Article",2 "Name" , 3"UOM" , 4"Cost" , 5"SalesPrice" ,
		// 6 "MRP" ,
		// 7 "Bal.Qty" , 8 "From Loc." , 9 "Tramsfer Qty" , 10"TO Loc." ,
		// 11"Batch Article" ,
		// 12 "BatchNO" , 13 "Manuf.Date" , 14 "Expiry date" } ;
		int row = table.getSelectedRow();
		String varticle = table.getValueAt(row, 1).toString();
		String vbatchArticle = table.getValueAt(row, 11).toString();
		String vloc = table.getValueAt(row, 8).toString();
		selectedrow = row;
		try {
			CheckBatchArticle(varticle, vbatchArticle, vloc);
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
	}

	private void checkBatchforNonBatchItems(String varticle, String vbatchcontrol) throws Throwable {
		// {"Remove" , 1"Article",2 "Name" , 3"UOM" , 4"Cost" , 5"SalesPrice" ,
		// 6 "MRP" ,
		// 7 "Bal.Qty" , 8 "From Loc." , 9 "Tramsfer Qty" , 10"TO Loc." ,
		// 11"Batch Article" ,
		// 12 "BatchNO" , 13 "Manuf.Date" , 14 "Expiry date" } ;
		String vcost = "0";
		String vsp = table.getValueAt(selectedrow, 5).toString();
		String vmrp = table.getValueAt(selectedrow, 6).toString();
		String vloc = from.getSelectedItem().toString();
		String vaction = new gnBatch().IsBatchAvailableForIsBatchAvailableforMrpandSP(varticle, vmrp, vsp);
		switch (vaction) {
		case "Y":
			vcost = new gnArticle().Article_getData(varticle, "Cost");
			String vaction1 = new gnBatch().IsMultiBatchForMRP_SalesPrice(varticle, vmrp, vsp, vcost);
			switch (vaction1) {
			case "Y":
				try {
					String vtype = "AllPlus";
					new gnGetBatch().getBatchDetailForNonBathItems(vtype, varticle, vbatchcontrol, vloc);
				} catch (Exception e) {
					new General().msg(e.getLocalizedMessage());
				} finally {
					if (Double.parseDouble(new gnGetBatch().salesPrice) > 0) {
						table.setValueAt(new gnGetBatch().cost, selectedrow, 4);
						table.setValueAt(new gnGetBatch().mrp, selectedrow, 6);
						table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 5);
						table.setValueAt(new gnGetBatch().manuf_date, selectedrow, 13);
						table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 14);
						table.setValueAt(new gnGetBatch().batchno, selectedrow, 12);
						table.setValueAt(new gnGetBatch().bal_qty, selectedrow, 7);
						new gnGetBatch().resetValues();
						QtychangeImapct(varticle, selectedrow);
					}
				}
				break;
			case "N":
				String vbatch = new gnBatch().getLowestBatch(varticle, vmrp, vsp, vcost);
				table.setValueAt(vbatch, selectedrow, 12);
				break;
			} // Iswitch
			break;
		case "N":
			String vbatchno = new gnBatch().getNewBatch();
			table.setValueAt(vbatchno, selectedrow, 12);
			break;
		}// Outer Switch
	}

	public String CheckBatchArticle(String varticle, String vbatchcontrol, String vvloc) throws Throwable {

		// new General().msg("REached Here and Batch Type = "+"" +vbatchcontrol
		// +" "+varticle + " "+vvloc);
		String status = "Sucess";
		String vloc = vvloc;
		String vstorecode = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		String vpara811 = "811";
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
				vstorecode);
		switch (vmaintainbatchforNonBatchItem) {
		case "N":
			try {
				new gnGetBatch().getBatchDetail(varticle, vbatchcontrol, vloc);
			} catch (Exception e) {
				new General().msg("My Exception :" + " " + e.getLocalizedMessage());
			} finally {
				//
				table.setValueAt(new gnGetBatch().cost, selectedrow, 4);
				table.setValueAt(new gnGetBatch().mrp, selectedrow, 6);
				table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 5);
				table.setValueAt(new gnGetBatch().manuf_date, selectedrow, 13);
				table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 14);
				table.setValueAt(new gnGetBatch().batchno, selectedrow, 12);
				table.setValueAt(new gnGetBatch().bal_qty, selectedrow, 7);
				//
				new gnGetBatch().resetValues();
				// QtychangeWPO(varticle, selectedrow);
			}
			break;
		case "Y":
			// new General().msg("Maintained Batch for non BAtchItems = "+""
			// +vbatchcontrol +" "+varticle );
			checkBatchforNonBatchItems(varticle, vbatchcontrol);
			break;
		} // Switch
		return status;
	}// Method End

	/*
	 * private void getArtileBatch(String varticle , String vbatchArticle ,
	 * String vloc) { //{"Remove" , 1"Article",2 "Name" , 3"UOM" , 4"Cost" ,
	 * 5"SalesPrice" , 6 "MRP" , // 7 "Bal.Qty" , 8 "From Loc." , 9
	 * "Tramsfer Qty" , 10"TO Loc." , 11"Batch Article" , // 12 "BatchNO" , 13
	 * "Manuf.Date" , 14 "Expiry date" } ;
	 * 
	 * try { new gnGetBatch().getBatchDetail(varticle, vbatchArticle, vloc); }
	 * catch (Throwable e1) { e1.printStackTrace() ; } finally {
	 * table.setValueAt(new gnGetBatch().cost,selectedrow , 4);
	 * table.setValueAt(new gnGetBatch().mrp, selectedrow , 6);
	 * table.setValueAt(new gnGetBatch().salesPrice, selectedrow , 5);
	 * table.setValueAt(new gnGetBatch().manuf_date, selectedrow , 13);
	 * table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 14);
	 * table.setValueAt(new gnGetBatch().batchno, selectedrow , 12);
	 * table.setValueAt(new gnGetBatch().bal_qty, selectedrow , 7); }
	 * 
	 * }
	 */

	class rbLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			boolean vpay = rbbrand.isSelected();
			if (vpay) {
				Choice = "Brand";
			} else {
				Choice = "Article";
			}
		}
	}

	class SearchLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String vcheck = checkSelection();
			String vname = search.getText();
			vname = "%" + vname + "%";
			if (vcheck == "Sucess") {
				switch (Choice) {
				case "Article":
					String vtrantype = "ALL";
					String vType = "Article";
					String varticle = "";
					try {
						new gnAdmin().Search(vType, vname, varticle, vtrantype);
					} catch (Throwable e1) {
						e1.printStackTrace();
					} finally {
						code.setText(new gnAdmin().rArticle);
						new gnAdmin().rArticle = " ";
						try {
							ProcessRequest();
						} catch (Throwable e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					break;

				case "Brand":
					break;
				}

			}
		}
	}

	class CodeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String vcheck = checkSelection();
			if (vcheck == "Sucess") {
				try {
					ProcessRequest();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	private String validateEntry() {
		String vstatus = "Sucess";

		String varticle = code.getText();
		if (varticle.length() == 0) {
			new General().msg("Enter Or Select Code First ..");
			vstatus = "Fail";
		}
		return vstatus;
	}

	private String checkSelection() {
		String vstatus = "Sucess";
		if (from.getSelectedItem().toString() == toloc.getSelectedItem().toString()) {
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new General().msg(" !!! Check From Location & TO Location is Same..!!!");
			vstatus = "Fail";
		}
		return vstatus;
	}

	private void ProcessRequest() throws Throwable {
		String SQL = null;
		String vfromloc;
		String vtoloc;
		switch (Choice) {
		case "Article":
			String vstatus = validateEntry();
			if (vstatus == "Sucess") {
				String varticle = code.getText();
				vfromloc = from.getSelectedItem().toString();
				vtoloc = toloc.getSelectedItem().toString();
				String vtype = "LocTrf";
				SQL = "Call   Loc_get_scanArticle( '" + vtype + "', " + varticle + ",  " + vcomp + " , " + vstore
						+ " ,  '" + vfromloc + "' , '" + vtoloc + "')";
				showTable(SQL, Col);
				code.setText(" ");
			}
			break;

		case "Brand":
			String brand = code.getText();
			vfromloc = from.getSelectedItem().toString();
			vtoloc = toloc.getSelectedItem().toString();
			showTable(SQL, Col);
			code.setText(" ");
			break;
		}

	}

	public void showTable(String SQL, String[] Colnames) throws Throwable {
		rs = this.getSPResult(SQL);
		((DefaultTableModel) model).setColumnIdentifiers(Colnames);
		table.setModel(model);
		int i = 0;
		while (rs.next()) {
			model.insertRow(0,
					new Object[] { "DEL", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14) });
			table.setModel(model);
			TableCellRenderer ss = table.getColumnModel().getColumn(0).getCellRenderer();
			TableColumn cell2 = table.getColumnModel().getColumn(2);
			String vmsname = "Location";
			// selectedrow = table.getRowCount() - 1;
			selectedrow = 0;
			String varticle = rs.getString(1);
			String vbatcharticle = rs.getString(11);
			String vvloc = from.getSelectedItem().toString();
			CheckBatchArticle(varticle, vbatcharticle, vvloc);

			// String verticle = new gnHierarchy().getVerticleCode() ;
			// String Search = "%%" ;
			// String SQL1 = "call master_getMasterData('"+vmsname+"' ,
			// "+verticle+" , '"+Search+"')" ;
			// table.getColumnModel().getColumn(8).setCellEditor(new
			// DefaultCellEditor(new gnTable().generateBox(SQL1)));
			// table.getColumnModel().getColumn(10).setCellEditor(new
			// DefaultCellEditor(new gnTable().generateBox(SQL1)));

			CheckBatchArticle(); /// Check of BatchType = "Y"

		}
		removeRow(model, table);
		// resetFigures();
		new gnTable().setTablewidth(table, 1, 70);
		new gnTable().setTablewidth(table, 0, 40);
		new gnTable().setTablewidth(table, 2, 300);
		new gnTable().setTablewidth(table, 5, 150);
		new gnTable().setTablewidth(table, 6, 150);
		new gnTable().setTablewidth(table, 7, 150);
		new gnTable().setTablewidth(table, 8, 150);
		new gnTable().setTablewidth(table, 9, 150);
		new gnTable().setTablewidth(table, 10, 155);
		new gnTable().setTablewidth(table, 14, 155);
		new gnTable().setTablewidth(table, 12, 155);
		table.setGridColor(Color.BLUE);

		table.setEnabled(true);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.gray);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
		JViewport prt = new JViewport();
		prt.setBackground(new Color(204, 204, 204));
		prt.add(table, Col);
		prt.setVisible(true);
		jsp.setViewport(prt);

	}// End Show Table

	public String CheckBatchArticle() {
		String Action = "Sucess";
		int rw = table.getRowCount();
		String vbatch = " ";
		String vExp = "";
		String vbatchno = " ";
		String varticle = "";
		for (int k = 0; k < rw; k++) {
			vbatch = table.getValueAt(k, 11).toString();
			vExp = table.getValueAt(k, 14).toString();
			vbatchno = table.getValueAt(k, 12).toString();
			varticle = table.getValueAt(k, 1).toString();
			switch (vbatch) {
			case "Y":
				switch (vExp) {
				case "0":
					new General().msg("Enter Batch no and Expiry Date for Item Code " + varticle);
					Action = "Fail";
				}
			}
		}
		return Action;
	}// Method End

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			e.notifyAll();
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 1);
			try {
				QtychangeImapct(value, row);
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	};
	private JLabel lblNewLabel_7;

	public String QtychangeImapct(String value, int i) throws SQLException, ClassNotFoundException {
		System.out.println("Item is " + value + "Row is" + i);
		String curqty1 = (String) table.getValueAt(i, 7).toString();
		Double curqty = Double.parseDouble(curqty1);
		if (curqty < 0) {
			table.setEditingRow(i);
			table.setGridColor(Color.YELLOW);
			table.setBackground(Color.red);
		}
		Double vbalqty = Double.parseDouble(table.getValueAt(i, 7).toString());
		Double vtrfqty = Double.parseDouble(table.getValueAt(i, 9).toString());

		if (vbalqty < 0.0) {
			new General().msg("Bal Qty For  Item is  < 0 ");
			table.setValueAt(0, i, 9);
		}
		if (vtrfqty > vbalqty) {
			new General().msg(" Stock Can not Transfer More then Bal Qty Please Check ");
			table.setValueAt(0, i, 9);
		}

		String action = "Sucess";
		table.addNotify();
		return action;
	}

	public void removeRow(DefaultTableModel model, JTable table) {
		TableColumn Del = table.getColumnModel().getColumn(0);
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
				if (nn == 2 && model == model) {
					int lastrow = table.getRowCount();
					int r = table.getSelectedRow();
					int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
					if (option == 0) {
						model.removeRow(r);
						// resetFigures();
					}
					return;
				}
			}
		});
	}

	private String validate() {
		String result = "Sucess";
		double vbalqty = 00.00;
		double vtrfqty = 00.00;
		int rw = table.getRowCount();
		for (int i = 0; i < rw; i++) {
			vtrfqty = Double.parseDouble(table.getValueAt(i, 9).toString());
			vbalqty = Double.parseDouble(table.getValueAt(i, 7).toString());
			String varticle = (table.getValueAt(i, 1).toString());
			if (vtrfqty > vbalqty) {
				result = "Fail";
				new General().msg("Transfer Qty Can not be > Bal.Stock  Please Check For Article ==>" + "" + varticle);
			}
		}
		return result;
	}

	private void PrepareToInsert() throws Throwable {
		String vstatus = CheckBatchArticle();
		String vcheck = validate();
		if (vstatus == "Sucess" && vcheck == "Sucess") {
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vtrfdate = new gnConfig().date_ConverttoDBforamt(date.getText());
			vtrfno = new gnSeq().getLoctrfNo();
			int vvtrfno = Integer.parseInt(vtrfno);
			new General().msg("Location Transfer Number is :" + " " + vtrfno);
			if (vvtrfno > 0) {
				insertLocTransfer();
			} else {
				new General().msg("<Check For Location Transfer Number..> Number Not Generated");
				new gnImageSound().playAlertSound();
				return;
			}
		}
	}

	public void insertLocTransfer() throws Throwable {
		prst = null;
		int vbatchSize = table.getRowCount();
		final int batchSize = vbatchSize;
		int TotalRecordinsert = 0;
		String vmanufdt = "0";
		String vexpdate = "0";
		con3 = (Connection) this.getConnection();
		con3.setAutoCommit(false);
		String prdetail = "Insert into  locationtransfer(Company_code , Site_code  ,"
				+ "Trf_date  ,  Article_code  ,  cost,    mrp,      salesPrice ,    bal_qty ,"
				+ "From_loc,    trf_qty,    to_loc,      batchArticle , batchno,    manuf_date,    expiry_date, srno, trf_no , finyear , userid , time)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?)";
		// {"Remove" , 1"Article",2 "Name" , 3"UOM" , 4"Cost" , 5"SalesPrice" ,
		// 6 "MRP" ,
		// 7 "Bal.Qty" , 8 "From Loc." , 9 "Tramsfer Qty" , 10"TO Loc." ,
		// 11"Batch Article" ,
		// 12 "BatchNO" , 13 "Manuf.Date" , 14 "Expiry date" } ;
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con3.prepareStatement(prdetail);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vtrfdate);
				prst.setString(4, (table.getValueAt(k, 1).toString()));
				prst.setString(5, (table.getValueAt(k, 4).toString()));
				prst.setString(6, (table.getValueAt(k, 6).toString()));
				prst.setString(7, (table.getValueAt(k, 5).toString()));
				prst.setString(8, (table.getValueAt(k, 7).toString()));
				prst.setString(9, (table.getValueAt(k, 8).toString()));
				prst.setString(10, (table.getValueAt(k, 9).toString()));
				prst.setString(11, (table.getValueAt(k, 10).toString()));
				prst.setString(12, (table.getValueAt(k, 11).toString()));
				prst.setString(13, (table.getValueAt(k, 12).toString()));
				String vbatcharticle = (table.getValueAt(k, 11).toString());
				switch (vbatcharticle) {
				case "Y":
					prst.setString(14, new gnConfig().date_ConverttoDBforamt((table.getValueAt(k, 13).toString())));
					prst.setString(15, new gnConfig().date_ConverttoDBforamt((table.getValueAt(k, 14).toString())));
					break;
				case "N":
					prst.setString(14, "0000.00.00");
					prst.setString(15, "0000.00.00");
					break;
				}
				prst.setInt(16, k);
				prst.setString(17, vtrfno);
				prst.setString(18, vfinyear);
				prst.setString(19, new General().getUsercode());
				prst.setString(20, new General().getTime());
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBdetail = "Sucess";
				if (TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
				}
				prst.executeBatch();
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg("Detail Error" + e.getMessage());
			System.out.println(e.getLocalizedMessage());
			con3.rollback();
			DBdetail = "Fail";
		} finally {
			if (DBdetail == "Sucess") {
				con3.commit();
				con3.close();
				reduceinv();
			}
			if (prst != null) {
				prst.close();
			}
		}
	}

	private void reduceinv() throws Throwable {
		String vtrntype = "FromLoc";
		String SQL = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vtrfno + " , '"
				+ vtrfdate + "'  , '" + vfinyear + "')";
		this.getSPResult(SQL);

		String vtrntype1 = "ToLoc";
		String SQL1 = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   " + vtrfno + " , '"
				+ vtrfdate + "' , '" + vfinyear + "')";
		this.getSPResult(SQL1);

		//
		// Stock for batch updated
		String vtrntype2 = "FromLoc";
		String SQL2 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype2 + "',   " + vtrfno + " , '"
				+ vtrfdate + "' , '" + vfinyear + "')";
		// new General().msg(SQL2);
		this.getSPResult(SQL2);

		String vtrntype3 = "ToLoc";
		String SQL3 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype3 + "',   " + vtrfno + " , '"
				+ vtrfdate + "' , '" + vfinyear + "')";
		this.getSPResult(SQL3);
		// new General().msg(SQL3);

		//// For Non Batch Items
		String vpara811 = "811";
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			vtrntype2 = "FromLoc";
			SQL2 = "call Inv_impact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vtrntype2 + "',   " + vtrfno
					+ " , '" + vtrfdate + "' , '" + vfinyear + "')";
			this.getSPResult(SQL2);
			break;
		}

		vpara811 = "811";
		vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			vtrntype3 = "ToLoc";
			SQL3 = "call Inv_impact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vtrntype3 + "',   " + vtrfno
					+ " , '" + vtrfdate + "' , '" + vfinyear + "')";
			this.getSPResult(SQL3);
			break;
		}

		new gnTable().RemoveTableRows(model);
		new General().Quickmsg("Data Saved Sucessfully");

	}

}// Last

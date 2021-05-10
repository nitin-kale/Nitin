package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class StockTransaferTO extends getResultSet {

	JFrame TOframe;
	JInternalFrame internalFrame;
	private JTextField storecode;
	private JTextField storename;
	private JTextField tostore;
	private JTextField tostorename;
	private JTextField tono;
	private JButton btnBatch;
	private JTextField todate;
	private String DBhdr;
	private String DBdetail;
	private String DBStock1;
	private String DBStock2;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton crb1;
	private JRadioButton crb2;
	private JRadioButton crb3;
	private JTextField records;
	private JTextField amount;
	private JPanel optionPanel;
	private JTextField scanitem;
	private JTextField searchname;
	private JButton btnSave;
	private JButton btnPrint;
	private JButton btnClose;
	private Connection con, con1, con2, con3;
	private String vcomp;
	private String vstore;
	private String vtostore;
	private String vtodate;
	private String vamount;
	private String vtype = "TO";
	private String vtono;
	private String vverticle;

	private JScrollPane jsp;

	// for Item
	String toCol[] = { "Del", "Item Code", "Name", "Sent Qty", "UOM", "Cost", "SalesPrice", "MRP", " Bal_Stock",
			"Tax_per", "Batch No", "Manuf.Date", "Expiry Date", "Batch_Control", "Total Value", "Location" };

	// "1Item Code" ,2"Name" , 3"Sent Qty" , 4 "UOM" , 5"Cost", 6 "SalesPrice"
	// ,7 "MRP" ,
	// " 8 Bal_Stock" , 9"Tax_per" , 10 "Batch No" , 11 "Manuf.Date" , 12"Expiry
	// Date", 13"Batch_Control" ,
	// 14"Total Value", 15"Location"
	DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 3 || column == 10 || column == 11 || column == 12 || column == 15 ? true
					: false;
		}
	};

	JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);

			if (column == 0 || column == 3 || column == 10 || column == 11 || column == 12 || column == 15) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setCursor(getCursor());
			}
			if (column == 15) {
				componentt.setBackground(new Color(0, 51, 153));// .LIGHT_GRAY);
				componentt.setForeground(new Color(204, 255, 153));
			}

			return componentt;
		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockTransaferTO window = new StockTransaferTO();
					window.TOframe.setVisible(true);
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
	public StockTransaferTO() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		TOframe = new JFrame();
		TOframe.setResizable(false);
		TOframe.setBounds(2, 4, 1350, 720);
		TOframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		TOframe.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Stock Transfer Module ");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		lblNewLabel.setBounds(501, 0, 234, 28);
		TOframe.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 29, 464, 148);
		TOframe.getContentPane().add(panel);
		panel.setLayout(null);

		storecode = new JTextField();
		storecode.setBackground(new Color(51, 255, 255));
		storecode.setEditable(false);
		storecode.setBounds(106, 6, 75, 28);
		panel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setBackground(new Color(102, 255, 255));
		storename.setEditable(false);
		storename.setBounds(182, 6, 276, 28);
		panel.add(storename);
		storename.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Sending Branch");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_1.setBounds(6, 12, 94, 16);
		panel.add(lblNewLabel_1);

		tostore = new JTextField();
		tostore.setFont(new Font("Calibri", Font.PLAIN, 11));
		tostore.setBounds(105, 34, 86, 28);
		panel.add(tostore);
		tostore.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Receiving Branch");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_2.setBounds(6, 40, 106, 16);
		panel.add(lblNewLabel_2);

		tostorename = new JTextField();
		tostorename.setFont(new Font("Calibri", Font.PLAIN, 11));
		tostorename.setBounds(192, 34, 266, 28);
		ActionListener tostr = new ReceiveStoreLsnr();
		tostorename.addActionListener(tostr);
		panel.add(tostorename);
		tostorename.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 61, 452, 81);
		panel.add(panel_1);
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("TO.NO");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_3.setBounds(34, 12, 43, 16);
		panel_1.add(lblNewLabel_3);

		tono = new JTextField();
		tono.setBounds(99, 6, 112, 28);
		panel_1.add(tono);
		tono.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Transfer Date");
		lblNewLabel_4.setBounds(17, 40, 75, 16);
		panel_1.add(lblNewLabel_4);

		todate = new JTextField();
		todate.setBackground(new Color(0, 255, 255));
		todate.setEditable(false);
		todate.setBounds(99, 34, 112, 28);
		panel_1.add(todate);
		todate.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Records");
		lblNewLabel_5.setBounds(212, 12, 55, 16);
		panel_1.add(lblNewLabel_5);

		records = new JTextField();
		records.setBackground(new Color(0, 255, 255));
		records.setEditable(false);
		records.setBounds(261, 6, 121, 28);
		panel_1.add(records);
		records.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Amount");
		lblNewLabel_6.setBounds(212, 40, 55, 16);
		panel_1.add(lblNewLabel_6);

		amount = new JTextField();
		amount.setBackground(new Color(0, 255, 255));
		amount.setEditable(false);
		amount.setBounds(260, 34, 122, 28);
		panel_1.add(amount);
		amount.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 177, 1326, 44);
		TOframe.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		ActionListener batch = new BTNlsnr();

		JLabel lblNewLabel_7 = new JLabel("Scan Item");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_7.setForeground(new Color(0, 51, 153));
		lblNewLabel_7.setBounds(35, 12, 76, 16);
		panel_2.add(lblNewLabel_7);
		ActionListener itm = new scanItemLsnr();

		JLabel lblNewLabel_8 = new JLabel("Search By Name");
		lblNewLabel_8.setForeground(new Color(0, 51, 153));
		lblNewLabel_8.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_8.setBounds(321, 12, 125, 16);
		panel_2.add(lblNewLabel_8);

		searchname = new JTextField();
		searchname.setBounds(443, 4, 292, 32);
		panel_2.add(searchname);
		searchname.setColumns(10);

		scanitem = new JTextField();
		scanitem.setBounds(110, 4, 191, 32);
		panel_2.add(scanitem);
		scanitem.addActionListener(itm);
		scanitem.setColumns(10);

		btnBatch = new JButton("Get Batch Details");
		btnBatch.setBounds(1162, 7, 158, 28);
		panel_2.add(btnBatch);
		btnBatch.setMnemonic('G');
		btnBatch.addActionListener(batch);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(12, 218, 1320, 433);
		TOframe.getContentPane().add(jsp);

		ActionListener btn = new BTNlsnr();

		btnSave = new JButton("Save");
		btnSave.addActionListener(btn);
		btnSave.setMnemonic('S');
		btnSave.setBounds(377, 653, 90, 28);
		TOframe.getContentPane().add(btnSave);

		btnPrint = new JButton("Print");
		btnPrint.addActionListener(btn);
		btnPrint.setMnemonic('P');
		btnPrint.setBounds(472, 653, 90, 28);
		TOframe.getContentPane().add(btnPrint);

		btnClose = new JButton("Close");
		btnClose.addActionListener(btn);
		btnClose.setMnemonic('C');
		btnClose.setBounds(574, 653, 90, 28);
		TOframe.getContentPane().add(btnClose);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBorder(new TitledBorder(null, "Select Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(472, 29, 142, 148);
		TOframe.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		ActionListener rb = new rbLsnr();
		rb1 = new JRadioButton("With Indent");
		buttonGroup.add(rb1);
		rb1.addActionListener(rb);
		rb1.setBounds(24, 28, 115, 18);
		panel_3.add(rb1);

		rb2 = new JRadioButton("WithOut Indent");
		rb2.addActionListener(rb);
		buttonGroup.add(rb2);
		rb2.setBounds(24, 56, 115, 18);
		panel_3.add(rb2);

		optionPanel = new JPanel();
		optionPanel.setBackground(UIManager.getColor("Button.background"));
		optionPanel.setVisible(false);
		optionPanel.setBorder(new TitledBorder(null, "Select Option", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 153)));
		optionPanel.setBounds(613, 68, 152, 113);
		TOframe.getContentPane().add(optionPanel);
		optionPanel.setLayout(null);

		crb1 = new JRadioButton("Brand");
		buttonGroup_1.add(crb1);
		crb1.setBounds(17, 21, 115, 18);
		optionPanel.add(crb1);

		crb2 = new JRadioButton("Sub Group");
		buttonGroup_1.add(crb2);
		crb2.setBounds(17, 51, 115, 18);
		optionPanel.add(crb2);

		crb3 = new JRadioButton("Article Class");
		buttonGroup_1.add(crb3);
		crb3.setBounds(17, 81, 115, 18);
		optionPanel.add(crb3);

		internalFrame = new JInternalFrame("");
		internalFrame.setBounds(6, 1, 1332, 28);
		internalFrame.setVisible(false);
		TOframe.getContentPane().add(internalFrame);
		internalFrame.setVisible(true);
		decorate();
	}

	class rbLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			boolean rb1selected = rb1.isSelected();
			if (rb1selected) {
				new General().msg("Indent Part is umder Development ");
				optionPanel.setVisible(false);
			}
			boolean rb2selected = rb2.isSelected();
			if (rb2selected) {
				optionPanel.setVisible(true);
			}

		}
	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(TOframe);
		new gnField().showInventory(internalFrame, "INV");
		new gnField().showCalc(internalFrame, "CAL");
		new gnDecorate().decorateField(scanitem);
		new gnDecorate().decorateField(searchname);
		new gnDecorate().DispField_Eatch(tono, 10);
		new gnDecorate().DispField_Eatch(todate, 10);
		new gnDecorate().DispField_Eatch(storecode, 10);
		new gnDecorate().DispField_Eatch(storename, 10);
		new gnDecorate().DispField_Eatch(tostore, 10);
		new gnDecorate().DispField_Eatch(tostorename, 10);
		new gnDecorate().DispField_Eatch(amount, 10);
		new gnDecorate().DispField_Eatch(records, 10);

		vstore = new gnConfig().getStoreID();
		vcomp = new gnConfig().getCompanyCode();
		storecode.setText(vstore);
		storename.setText(new gnConfig().getStorename(vstore));
		todate.setText(new General().getDate());
		btnPrint.setEnabled(false);

	}

	class BTNlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			if (value == "Close") {
				TOframe.dispose();
			}

			if (value == "Get Batch Details") {
				// "1Item Code" ,2"Name" , 3"Sent Qty" , 4 "UOM" , 5"Cost", 6
				// "SalesPrice" ,7 "MRP" ,
				// " 8 Bal_Stock" , 9"Tax_per" , 10 "Batch No" , 11 "Manuf.Date"
				// , 12"Expiry Date", 13"Batch_Control" ,
				// 14"Total Value", 15"Location"
				int row = table.getSelectedRow();
				String varticle = table.getValueAt(row, 1).toString();
				String vbatchcontrol = table.getValueAt(row, 13).toString();
				String vloc = table.getValueAt(row, 15).toString();

				try {
					new gnGetBatch().getBatchDetail(varticle, vbatchcontrol, vloc);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					if (new gnGetBatch().cost != null) {
						table.setValueAt(new gnGetBatch().cost, row, 5);
						table.setValueAt(new gnGetBatch().salesPrice, row, 6);
						table.setValueAt(new gnGetBatch().mrp, row, 7);
						table.setValueAt(new gnGetBatch().batchno, row, 10);
						table.setValueAt(new gnGetBatch().expiry_date, row, 12);
						table.setValueAt(new gnGetBatch().bal_qty, row, 8);

					}
				}
			}

			if (value == "Print") {
				new General().msg("Under Process");

			}

			if (value == "Save") {
				try {
					String status = validate();
					if (status == "Sucess") {
						prepareToInsert();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class ReceiveStoreLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String sname = tostorename.getText();
			sname = "%" + sname + "%";
			try {
				new gnToTi().getsite(sname);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				tostore.setText(new gnToTi().rsitecode);
				tostorename.setText(new gnToTi().rName);
				new gnToTi().rsitecode = " ";
				new gnToTi().rName = " ";
			}
		}
	}

	class scanItemLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("id " + i);
			if (i == 1001)
				try {
					String vcode = scanitem.getText();
					String check = checkCode(vcode);
					if (check == "Sucess") {
						getvalueofscanarticle(vcode);
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
		}
	}

	private String checkCode(String vcode) {
		String status = "Sucess";

		if (vcode.length() > 0) {
			status = "Sucess";
		} else {
			new General().msg("Enter Article Code ..");
			scanitem.grabFocus();
			status = "Fail";
		}
		return status;
	}

	private void getvalueofscanarticle(String vcode) throws Throwable {
		String action = checkStoreEntry();
		String SQL = "Call   TO_getscanitem(" + vcode + ", " + vcomp + " , " + vstore + ")";
		showTable(SQL, toCol);
	}

	public String checkStoreEntry() {
		String vcode = tostorename.getText();
		String action = "Fail";
		if (vcode.length() == 0) {
			new General().msg("Select  Receiving Store For Making TO");
		}
		return action;
	}

	public void showTable(String SQL, String[] Colnames) throws Throwable {
		CheckBatchArticle();
		rs = this.getSPResult(SQL);
		((DefaultTableModel) model).setColumnIdentifiers(Colnames);
		table.setModel(model);
		while (rs.next()) {
			model.addRow(new Object[] { "DEL", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
					rs.getString(15) });
			table.setModel(model);
			table.getColumnModel().getColumn(0).getCellRenderer();
			table.setGridColor(Color.BLUE);
			table.setEnabled(true);
			removeRow(model, table);
			String vmsname = "Location";
			String vverticle = new gnHierarchy().getVerticleCode();
			String SQL1 = "call master_getMasterData('" + vmsname + "'   , '" + vverticle + "')";
			table.getColumnModel().getColumn(15).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL1)));
			new gnTable().setTableBasics(table);

		}
		resetFigures();
		new gnTable().setTablewidth(table, 1, 70);
		new gnTable().setTablewidth(table, 0, 40);
		new gnTable().setTablewidth(table, 2, 300);
		new gnTable().setTablewidth(table, 3, 150);
		new gnTable().setTablewidth(table, 4, 75);
		new gnTable().setTablewidth(table, 5, 150);
		new gnTable().setTablewidth(table, 6, 150);
		new gnTable().setTablewidth(table, 7, 125);
		new gnTable().setTablewidth(table, 8, 125);
		new gnTable().setTablewidth(table, 9, 125);
		new gnTable().setTablewidth(table, 10, 250);
		new gnTable().setTablewidth(table, 11, 300);
		new gnTable().setTablewidth(table, 12, 300);
		new gnTable().setTablewidth(table, 13, 150);
		new gnTable().setTablewidth(table, 14, 300);
		new gnTable().setTablewidth(table, 15, 150);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(table, toCol);
		prt.setVisible(true);
		jsp.setViewport(prt);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
	}// End Show Table

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
				new General().msg("Qty Change" + "" + e1.getMessage());
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				new General().msg("Qty Change" + "" + e1.getMessage());
			}
		}
	};
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	public String QtychangeImapct(String value, int i) throws SQLException, ClassNotFoundException {
		String curqty1 = (String) table.getValueAt(i, 3).toString();
		Double curqty = Double.parseDouble(curqty1);
		if (curqty == 0) {
			table.setEditingRow(i);
			table.setGridColor(Color.YELLOW);
			table.setBackground(Color.red);
		}
		// "1Item Code" ,2"Name" , 3"Sent Qty" , 4 "UOM" , 5"Cost", 6
		// "SalesPrice" ,7 "MRP" ,
		// " 8 Bal_Stock" , 9"Tax_per" , 10 "Batch No" , 11 "Manuf.Date" ,
		// 12"Expiry Date", 13"Batch_Control" ,
		// 14"Total Value", 15"Location"
		Double vqty = Double.parseDouble(table.getValueAt(i, 3).toString());
		Double vcost = Double.parseDouble(table.getValueAt(i, 5).toString());
		Double vcostValue = vqty * vcost;
		table.setValueAt(vcostValue, i, 14);
		amount.setText(Double.toString(new gnTable().getTotal(table, 14)));
		String action = "Sucess";
		table.addNotify();
		try {
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			table.addNotify();
		}
		return action;
	}

	public String CheckBatchArticle() {
		String Action = "Sucess";
		int rw = table.getRowCount();
		String vbatch = " ";
		String vExp = "";
		String vbatchno = " ";
		String varticle = "";
		for (int k = 0; k < rw; k++) {
			vbatch = table.getValueAt(k, 13).toString();
			vExp = table.getValueAt(k, 12).toString();
			vbatchno = table.getValueAt(k, 10).toString();
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
					int r = table.getSelectedRow();
					int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
					if (option == 0) {
						model.removeRow(r);
						resetFigures();
					}
					return;
				}
			}
		});
	}

	public void resetFigures() {
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		records.setText(RecordCount1);
		amount.setText(Double.toString(new gnTable().getTotal(table, 14)));
	}

	private String validate() {

		String vstatus = "Sucess";

		vstatus = CheckBatchArticle();
		int row = table.getRowCount();
		if (row > 0) {
			boolean d2 = tostore.getText().isEmpty();
			if (d2 == true) {
				new General().msg("Select Stock Receiving  Branch...");
				tostorename.grabFocus();
				vstatus = "Fail";
			}
		}
		return vstatus;
	}

	public void prepareToInsert() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		// new General().msg(vcomp) ;
		vstore = storecode.getText();
		vtostore = tostore.getText();
		tono.setText(new gnSeq().getSeqno("2", "TR"));
		vtodate = new gnConfig().date_ConverttoDBforamt(todate.getText());
		vamount = amount.getText();
		vtype = "TO";
		vtono = tono.getText();
		vverticle = new gnHierarchy().getVerticleCode();
		insertTODetail();
	}

	/// Insert Stock Transfer Out Detail Data to Table
	public String insertTODetail() throws Throwable {
		// new General().msg("Inserting To Detail now ") ;
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		DBdetail = "Fail";
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		String grndetail = "Insert into Stock_transfer_in_detail(Site_code , "
				+ "Type,  TI_no, Ti_date,  othStore,  to_no ,"
				+ " Article_code , 	batch_control ,   UOM ,  to_qty ,  qty ,"
				+ " pending_qty , cost ,  TotalValue, SalesPrice, MRP , "
				+ " bal_qty,  tax_per , batch_no ,  remark, location, Supplier, company_code, verticle, "
				+ "manuf_date,  expiry_date, to_date, srno) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,?,  ?,?,?,?)";
		try {
			int row1 = table.getRowCount();
			for (int k = 0; k < row1; k++) {
				prst = con1.prepareStatement(grndetail);
				prst.setString(1, vstore);
				prst.setString(2, vtype);
				prst.setString(3, " 0");
				prst.setString(4, " 0000.00.00");
				prst.setString(5, vtostore);
				prst.setString(6, vtono);
				prst.setString(7, (table.getValueAt(k, 1).toString())); // Article
				prst.setString(8, (table.getValueAt(k, 13).toString())); // batch
																			// control
				prst.setString(9, (table.getValueAt(k, 4).toString())); // uom
				prst.setString(10, (table.getValueAt(k, 3).toString())); // toqty
				prst.setString(11, "0"); // tiqty
				prst.setString(12, (table.getValueAt(k, 3).toString())); // pendingQty
				prst.setString(13, (table.getValueAt(k, 5).toString())); // cost
				prst.setString(14, (table.getValueAt(k, 14).toString())); // Totalvalue
				prst.setString(15, (table.getValueAt(k, 6).toString())); // salesprice
				prst.setString(16, (table.getValueAt(k, 7).toString())); // mrp
				String vbalqty = (table.getValueAt(k, 8).toString()); // balqty
				if (vbalqty.isEmpty()) {
					vbalqty = "0.00";
				}
				prst.setString(17, vbalqty); // balqty
				prst.setString(18, (table.getValueAt(k, 9).toString())); // tax_per
				prst.setString(19, (table.getValueAt(k, 10).toString())); // batchno
				String vmanufdate = (table.getValueAt(k, 12).toString()); // exp_date
				prst.setString(20, "Stock Transfer From Store On Request"); // remark
				prst.setString(21, table.getValueAt(k, 15).toString()); // location
				prst.setString(22, "0"); // Supplier
				prst.setString(23, vcomp);
				prst.setString(24, vverticle);
				prst.setString(25, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 11).toString()));
				prst.setString(26, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 12).toString()));
				prst.setString(27, vtodate);
				prst.setInt(28, k);
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
					// con1.commit();
				}
				prst.executeBatch(); // insert remaining records
				DBdetail = "Sucess";
				// con1.commit();
			}
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con1.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {
				insertTOHdr();
			}
		}
		return DBdetail;
	}
	/// End Insert Details

	public String insertTOHdr() throws Throwable {
		// new General().msg("Inserting To Hdr now ") ;
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con2 = this.getConnection();
		con2.setAutoCommit(false);
		String status = "Fail";
		String stktranferinhdr = "Insert into stock_transfer_in_hdr(Site_code , "
				+ "Type, Ti_no,  Ti_date , othStore,  to_no , to_date,  Stock_value, company_code, verticle) "
				+ "values(?,?,?,?,?,?,?,?,?,? )";
		try {
			prst = con2.prepareStatement(stktranferinhdr);
			prst.setString(1, vstore);
			prst.setString(2, vtype);
			prst.setString(3, "0");
			prst.setString(4, "0000.00.00");
			;
			prst.setString(5, vtostore);
			prst.setString(6, vtono);
			prst.setString(7, vtodate);
			prst.setString(8, vamount);
			prst.setString(9, vcomp);
			prst.setString(10, vverticle);
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBhdr = "Sucess";
		} catch (SQLException e) {
			new General().msg("Stock Transfer Hdr Table " + e.getMessage());
			con2.rollback();
			DBhdr = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") {
				con1.commit();
				con2.commit();
				con1.close();
				con2.close();
				reduceInv();
				new gnSeq().updateSeqno("2", "TR");
				new XML_createTOFile().createTOFile("TO", vtono, vtostore, todate.getText());
				new gnTable().RemoveTableRows(model);
				new General().msg("Data Saved Sucessfully ");
				records.setText("0");
				amount.setText("0");
				btnPrint.setEnabled(true);
			}
		}
		return status;
	}

	public String reduceInv() throws Throwable {
		String Action = "Fail";
		// String vstore = vtostore;
		String varticle;
		String vtype = "TO";
		String vdate = vtodate;
		String vqty = "0";

		int rw = table.getRowCount();

		if (rw > 0) {
			// New Procedure used now remove old logic of update inventpory
			try {
				String vtrntype = "TO";
				String vfinyear = new gnFinYear().getReportingFinYear();

				String SQL = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vtono + " , '"
						+ vtodate + "' , '" + vfinyear + "')";
				this.getSPResult(SQL);

				String vtrntype1 = "TO";
				String SQL1 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   " + vtono
						+ " , '" + vtodate + "'  , '" + vfinyear + "')";
				this.getSPResult(SQL1);
				Action = "Sucess";

				String vpara811 = "811";
				String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
						vstore);
				switch (vmaintainbatchforNonBatchItem) {
				case "Y":
					vtrntype1 = "TO";
					SQL1 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   " + vtono
							+ " , '" + vtodate + "'  , '" + vfinyear + "')";
					this.getSPResult(SQL1);
					Action = "Sucess";
					break;
				}

				// End Logic Change
			} catch (Exception e) {
				new General().msg(e.getLocalizedMessage());
			}
		}

		/*
		 * this is Old Logic for Inventory update for ( int k1 =0 ; k1 < rw ;
		 * k1++) { //"1Item Code" ,2"Name" , 3"Sent Qty" , 4 "UOM" , 5"Cost", 6
		 * "SalesPrice" ,7 "MRP" , //" 8 Bal_Stock" , 9"Tax_per" , 10 "Batch No"
		 * , 11 "Manuf.Date" , 12"Expiry Date", 13"Batch_Control" , // 14
		 * "Total Value", 15"Location" varticle =
		 * table.getValueAt(k1,1).toString(); vqty = table.getValueAt(k1,
		 * 3).toString() ; String vloc = table.getValueAt(k1,15).toString() ;
		 * String vcomp = new gnConfig().getCompanyCode() ; String vbatcharticle
		 * = table.getValueAt(k1,13).toString() ; String vinvtype = "0" ; new
		 * applyInv_Action(). invAction(vstore, varticle, vtype, vdate, vqty,
		 * vloc, vcomp, vverticle, vinvtype, vbatcharticle) ; DBStock1 =
		 * "Sucess" ; }
		 */
		return Action;
	}
	// End Stock_in_hand_table

	public void Stock_in_hand_details() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String stockdetail = "Insert into stock_in_hand_details(Company_code, Site_code , "
				+ "Article_code,   Location ,   " + "supplier_code,   Batch_no, " + "Manuf_date, Expiry_date,"
				+ "Batch_qty,  bal_qty ,   cost ,  " + "SalesPrice, MRP,  " + " createDate, updateDate, verticle)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// "1Item Code" ,2"Name" , 3"Sent Qty" , 4 "UOM" , 5"Cost", 6
		// "SalesPrice" ,7 "MRP" ,
		// " 8 Bal_Stock" , 9"Tax_per" , 10 "Batch No" , 11 "Manuf.Date" ,
		// 12"Expiry Date", 13"Batch_Control" ,
		// 14"Total Value", 15"Location"
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				String vbatchEnable = table.getValueAt(k, 13).toString();
				switch (vbatchEnable) {
				case "Y":
					String varticle = (table.getValueAt(k, 1).toString());
					String vbatch = (table.getValueAt(k, 10).toString());
					String vvexpdate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 12).toString());
					String vloc = (table.getValueAt(k, 15).toString());
					String result = new gnConfig().batch_isBatchExist(vstore, varticle, vbatch, vvexpdate, vloc, vcomp);
					switch (result) {
					case "update":
						String varticle1 = table.getValueAt(k, 1).toString();
						String vbatchno = table.getValueAt(k, 10).toString();
						String vqty = table.getValueAt(k, 3).toString();
						String vloc1 = (table.getValueAt(k, 15).toString());
						String vvexpdate1 = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 12).toString());
						String SQL = "call batch_Addstock( " + vqty + " , " + vstore + ",  " + varticle1 + " , "
								+ vbatchno + " , '" + vvexpdate1 + "', '" + vloc1 + "', " + vcomp + " , " + vverticle
								+ ")";
						this.getSPResult(SQL);
						break;
					case "insert":
						prst = con.prepareStatement(stockdetail);
						prst.setString(1, new gnConfig().getCompanyCode());
						prst.setString(2, vstore);
						prst.setString(3, (table.getValueAt(k, 1).toString()));
						prst.setString(4, (table.getValueAt(k, 15).toString()));
						prst.setString(5, "0");
						prst.setString(6, (table.getValueAt(k, 10).toString()));
						String vmnfDate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 11).toString());
						if (vmnfDate == "0") {
							vmnfDate = "0000.00.00";
						}
						prst.setString(7, vmnfDate);
						prst.setString(8, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 12).toString()));
						prst.setString(9, (table.getValueAt(k, 3).toString()));
						prst.setString(10, (table.getValueAt(k, 3).toString()));
						prst.setString(11, (table.getValueAt(k, 5).toString()));
						prst.setString(12, (table.getValueAt(k, 6).toString()));
						prst.setString(13, (table.getValueAt(k, 7).toString()));
						prst.setString(14, vtodate);
						prst.setString(15, vtodate);
						prst.setString(16, vverticle);
						prst.addBatch();
						TotalRecordinsert = TotalRecordinsert + 1;
						DBStock2 = "Fail";
						if (++TotalRecordinsert % batchSize == 0) {
							prst.executeBatch();
							con.commit();
							DBStock2 = "Sucess";
						}
						prst.executeBatch(); // insert remaining records
						con.commit();
						DBStock2 = "Sucess";
					}
					break;
				}
			} // for
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con.rollback();
			DBStock2 = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
				new General().msg("Data Saved Sucessfully..");
				new gnTable().RemoveTableRows(model);
			}
		}
	}
}// Last

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
import com.sun.glass.ui.Cursor;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class StockAdjustmentModule extends getResultSet {

	JFrame stockAdjFrame;
	private Connection con1, con2, con3;
	private JTextField storecode;
	private String DBdetail;
	String inventroyType = "";

	private String DBhdr;
	JComboBox adjtype;
	int selectedrow;
	String vtrtype;
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

	private String Col[] = { "Remove", "Article", "Name", "UOM", "Cost", "SalesPrice", "MRP", "Bal.Qty", "Type",
			"Reason", "Adj.Qty", "Batch Article", "BatchNO", "Expiry date" };

	// private String Col[] = {"Remove" , 1"Article", 2"Name" , 3"UOM" , 4"Cost"
	// ,5"SalesPrice" , 6"MRP" ,
	// 7"Bal.Qty" , 8"Type", 9"Reason" , 10 "Adj.Qty" ,11 "Batch Article" ,
	// 12"BatchNO" , 13"Expiry date" } ;

	DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 1 || column == 2 || column == 3 || column == 7 ? false : true;
		}
	};

	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 1 || column == 2 || column == 3 || column == 7) {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setForeground(new Color(51, 51, 102));
				componentt.setCursor(getCursor());
			} else {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLACK);
			}

			if (column == 9 || column == 8 || column == 10) {
				componentt.setBackground(Color.DARK_GRAY);
				componentt.setForeground(Color.YELLOW);
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
					StockAdjustmentModule window = new StockAdjustmentModule();
					window.stockAdjFrame.setVisible(true);
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
	public StockAdjustmentModule() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		stockAdjFrame = new JFrame();
		stockAdjFrame.getContentPane().setBackground(Color.WHITE);
		stockAdjFrame.setResizable(false);
		stockAdjFrame.setAlwaysOnTop(true);
		stockAdjFrame.setBounds(1, 100, 1350, 600);
		stockAdjFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		stockAdjFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Stock Adjustment Module");
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(445, 6, 395, 20);
		stockAdjFrame.getContentPane().add(lblNewLabel);

		// JPanel panel = new JPanel()
		JPanel panel = new gnRoundPanel();
		panel.setBackground(Color.WHITE);

		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 37, 1320, 215);
		stockAdjFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Branch ");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setBounds(64, 3, 55, 16);
		panel.add(lblNewLabel_1);

		storecode = new JTextField();
		storecode.setBackground(Color.WHITE);
		storecode.setEnabled(false);
		storecode.setFont(new Font("Arial", Font.BOLD, 13));
		storecode.setBounds(129, -3, 122, 28);
		panel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setBackground(Color.WHITE);
		storename.setEnabled(false);
		storename.setFont(new Font("Arial", Font.BOLD, 13));
		storename.setBounds(251, -3, 315, 28);
		panel.add(storename);
		storename.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(64, 64, 64)));
		panel_1.setBounds(12, 64, 1184, 70);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("From Location");
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_2.setBounds(143, 5, 132, 21);
		panel_1.add(lblNewLabel_2);

		ActionListener rbls = new rbLsnr();
		ActionListener btn = new btnLsnr();

		from = new JComboBox();
		from.setBackground(Color.WHITE);
		from.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		from.setModel(new DefaultComboBoxModel(new String[] { "SL" }));
		from.setBounds(142, 27, 133, 26);
		panel_1.add(from);

		toloc = new JComboBox();
		toloc.setModel(new DefaultComboBoxModel(new String[] { "SL" }));
		toloc.setBounds(640, 27, 148, 26);
		panel_1.add(toloc);

		rbarticle = new JRadioButton("Article");
		rbarticle.setBackground(Color.WHITE);
		rbarticle.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		rbarticle.addActionListener(rbls);
		buttonGroup.add(rbarticle);
		rbarticle.setBounds(8, 35, 115, 18);
		panel_1.add(rbarticle);

		rbbrand = new JRadioButton("Brand");
		rbbrand.setBackground(Color.WHITE);
		rbbrand.setEnabled(false);
		rbbrand.addActionListener(rbls);
		buttonGroup.add(rbbrand);
		rbbrand.setBounds(8, 12, 115, 18);
		panel_1.add(rbbrand);

		lblNewLabel_8 = new JLabel("[ Select Proper Location For Stock Adjustment ]");
		lblNewLabel_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(281, 32, 310, 16);
		panel_1.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Not Requoired");
		lblNewLabel_9.setBounds(640, 7, 56, 16);
		panel_1.add(lblNewLabel_9);
		ActionListener codeLs = new CodeLsnr();
		ActionListener srch = new SearchLsnr();

		JLabel lblNewLabel_6 = new JLabel("Date");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setForeground(SystemColor.activeCaptionText);
		lblNewLabel_6.setBounds(267, 38, 40, 16);
		panel.add(lblNewLabel_6);

		date = new JTextField();
		date.setBackground(Color.WHITE);
		date.setEditable(false);
		date.setFont(new Font("Arial", Font.BOLD, 13));
		date.setBounds(312, 32, 122, 28);
		panel.add(date);
		date.setColumns(10);

		lblNewLabel_3 = new JLabel("SV Posting No");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(12, 32, 113, 16);
		panel.add(lblNewLabel_3);

		svno = new JTextField();
		svno.setBackground(Color.WHITE);
		svno.setFont(new Font("Arial", Font.BOLD, 13));
		svno.setEditable(false);
		svno.setBounds(127, 30, 121, 28);
		panel.add(svno);
		svno.setColumns(10);

		// JPanel panel_2 = new JPanel();
		JPanel panel_2 = new gnRoundPanel();
		panel_2.setBounds(12, 140, 1184, 65);
		panel.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		panel_2.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Type");
		lblNewLabel_7.setBounds(12, 2, 56, 16);
		panel_2.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));

		adjtype = new JComboBox();
		adjtype.setBackground(Color.WHITE);
		adjtype.setBounds(12, 23, 87, 35);
		panel_2.add(adjtype);
		adjtype.setFont(new Font("Tahoma", Font.BOLD, 13));
		adjtype.setModel(new DefaultComboBoxModel(new String[] { "NoAction", "Add", "Reduce" }));

		JLabel lblNewLabel_4 = new JLabel("Enter Code");
		lblNewLabel_4.setBounds(119, 3, 119, 16);
		panel_2.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));

		// code = new JTextField();
		code = new gnRoundTextField(20);
		code.setBounds(116, 23, 122, 35);
		panel_2.add(code);
		code.setForeground(new Color(0, 0, 51));
		code.setFont(new Font("SansSerif", Font.BOLD, 15));
		code.addActionListener(codeLs);
		code.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Search By Name");
		lblNewLabel_5.setBounds(250, 3, 154, 16);
		panel_2.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_5.setForeground(new Color(0, 0, 51));

		// search = new JTextField();
		search = new gnRoundTextField(30);
		search.setBounds(250, 23, 218, 35);
		panel_2.add(search);

		search.setFont(new Font("SansSerif", Font.BOLD, 15));
		search.addActionListener(srch);
		search.setColumns(10);

		JLabel lblreason = new JLabel("Narration");
		lblreason.setBounds(489, 3, 76, 16);
		panel_2.add(lblreason);
		lblreason.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));

		// reason = new JTextField();
		reason = new gnRoundTextField(20);
		reason.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));

		reason.setBounds(479, 23, 409, 35);
		panel_2.add(reason);
		reason.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setBackground(Color.WHITE);
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnSave.addActionListener(btn);
		btnSave.setMnemonic('S');
		btnSave.setBounds(1031, 252, 97, 33);
		stockAdjFrame.getContentPane().add(btnSave);

		btnClose = new JButton("Close");
		btnClose.setBackground(Color.WHITE);
		btnClose.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnClose.addActionListener(btn);
		btnClose.setMnemonic('C');
		btnClose.setBounds(1130, 252, 90, 33);
		stockAdjFrame.getContentPane().add(btnClose);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(12, 285, 1320, 269);
		stockAdjFrame.getContentPane().add(jsp);

		btnGetbatch = new JButton("Get Batch Details");
		btnGetbatch.setBackground(Color.WHITE);
		btnGetbatch.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnGetbatch.setBounds(866, 252, 162, 33);
		stockAdjFrame.getContentPane().add(btnGetbatch);

		btnGetbatch.setMnemonic('G');
		btnGetbatch.addActionListener(btn);
		decorate();
	}

	private void decorate() throws Throwable {
		
		stockAdjFrame.setUndecorated(true);
		
		
		toloc.setVisible(false);
		new gnApp().setFrameTitel(stockAdjFrame);
		new gnDecorate().DispField_BevalRaised(jsp);
		new gnDecorate().DispField_Eatch(code, 10);
		new gnDecorate().DispField_Eatch(search, 10);
		vfinyear = new gnFinYear().getReportingFinYear();
		vcomp = new gnConfig().getCompanyCode();
		rbarticle.setSelected(true);
		if (vcomp == "0") {
			stockAdjFrame.dispose();
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
		date.setText(new gnConfig().getDaybeginDate());

		String vallowday = new gnDate().checkDayBegin();
		switch (vallowday) {
		case "N":
			btnSave.setVisible(false);
			stockAdjFrame.dispose();
			break;
		case "Y":
			String vtype = "SALE";
			String vallowDate = new gnDate().checkBackDateTrAllow(vtype, date.getText());
			switch (vallowDate) {
			case "N":
				btnSave.setVisible(false);
				break;
			}
			break;
		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Close") {
				stockAdjFrame.dispose();
			}

			if (value == "Save") {
				try {
					String status = validateEntry();
					if (status == "Sucess") {
						PrepareToInsert();
					}
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
		// private String Col[] = {"Remove" , 1"Article", 2"Name" , 3"UOM" ,
		// 4"Cost" ,5"SalesPrice" , 6"MRP" ,
		// 7"Bal.Qty" , 8"Type", 9"Reason" , 10 "Adj.Qty" ,11 "Batch Article" ,
		// 12"BatchNO" , 13"Expiry date" } ;
		int row = table.getSelectedRow();
		selectedrow = row;
		String varticle = table.getValueAt(row, 1).toString();
		String vbatchArticle = table.getValueAt(row, 11).toString();
		String vloc = from.getSelectedItem().toString().trim();
		try {
			String vtype = "";

			inventroyType = table.getValueAt(row, 8).toString();
			switch (inventroyType.trim()) {
			case "Add":
				vtype = "Allwithcost";
				CheckBatchArticle(varticle, vbatchArticle, vloc, vtype);
				break;
			case "Reduce":
				vtype = "AllPluswithcost";
				CheckBatchArticle(varticle, vbatchArticle, vloc, vtype);
				break;
			}
		} catch (Throwable e1) {
			e1.printStackTrace();
		} finally {
		}

	}

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
			// String vcheck = checkSelection() ;
			String vcheck = "Sucess";
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
			// String vcheck = checkSelection() ;
			String vcheck = "Sucess";
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
		double cnt = 0;
		String varticle = code.getText();
		if (varticle.length() == 0) {
			new General().msg("Enter Or Select Code First ..");
			vstatus = "Fail";
		}

		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			String vstock = table.getValueAt(selectedrow, 10).toString();
			if (vstock.equals("0")) {
				cnt = cnt + 1;
				new General().msg("Enter Correct Adjustment Qty  At  Row .." + " " + i);
			}
		}

		if (cnt >= 1) {
			vstatus = "Fail";
		}

		String vstorecode = "";
		try {
			vstorecode = new gnConfig().getStoreID();
			String vcomp = new gnConfig().getCompanyCode();
			String vpara811 = "811";
			String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
					vstorecode);
			switch (vmaintainbatchforNonBatchItem) {
			case "Y":
				cnt = 0;
				int row1 = table.getRowCount();
				for (int j = 0; j < row1; j++) {
					String vstock = table.getValueAt(selectedrow, 12).toString();
					if (vstock.equals("0")) {
						cnt = cnt + 1;
						new General().msg("No Batch Selected Please Select Batch  At  Row .." + " " + j);
						vstatus = "Fail";
					}
				}
				break;
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				vtoloc = "SL"; // toloc.getSelectedItem().toString() ;
				String vadjtype = adjtype.getSelectedItem().toString();
				if (vadjtype != "NoAction") {
					String vtype = "Adj";
					SQL = "Call   Loc_get_scanArticle( '" + vtype + "' ,   " + varticle + ",  " + vcomp + " , " + vstore
							+ " ,  '" + vfromloc + "' , '" + vtoloc + "')";
					showTable(SQL, Col);
					code.setText(" ");
				}
			}
			break;
		}

	}

	public void showTable(String SQL, String[] Colnames) throws Throwable {
		// new General().msg(SQL);
		String varticle = "";
		String vbatcharticle = "";
		rs = this.getSPResult(SQL);
		((DefaultTableModel) model).setColumnIdentifiers(Colnames);
		table.setModel(model);
		int i = 0;

		// private String Col[] = {"Remove" , 1"Article", 2"Name" , 3"UOM" ,
		// 4"Cost" ,5"SalesPrice" , 6"MRP" ,
		// 7"Bal.Qty" ,8 "Adj.Qty" ,9 "Batch Article" ,
		// 10"BatchNO" , 11"Expiry date" } ;
		while (rs.next()) {
			String vmyadjtype = adjtype.getSelectedItem().toString();
			model.insertRow(0,
					new Object[] { "DEL", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), vmyadjtype, rs.getString(9),
							rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13) });
			table.setModel(model);
			TableCellRenderer ss = table.getColumnModel().getColumn(0).getCellRenderer();
			TableColumn cell2 = table.getColumnModel().getColumn(2);
			varticle = rs.getString(1);
			vbatcharticle = rs.getString(11);
			selectedrow = 0;
			// selectedrow = table.getRowCount()-1;
		}
		String vmsname = "STOCKADJREASON";
		new gnComp().FillMasterNameinTable(vmsname, table, 9);
		vmsname = "STOCKADJTYPE";
		// new gnComp().FillMasterNameinTable(vmsname, table, 8);
		String vvloc = from.getSelectedItem().toString();
		// CheckBatchArticle(varticle , vbatcharticle , vvloc) ;
		checkBatchApplicablity(varticle, vbatcharticle, vvloc);
		CheckBatchArticle();
		adjtype.setSelectedIndex(0);
		removeRow(model, table);
		// resetFigures();
		new gnTable().setTablewidth(table, 1, 70);
		new gnTable().setTablewidth(table, 0, 40);
		new gnTable().setTablewidth(table, 2, 300);
		new gnTable().setTablewidth(table, 5, 175);
		new gnTable().setTablewidth(table, 6, 75);
		new gnTable().setTablewidth(table, 7, 75);
		new gnTable().setTablewidth(table, 8, 100);
		new gnTable().setTablewidth(table, 9, 200);
		new gnTable().setTablewidth(table, 10, 155);
		new gnTable().setTablewidth(table, 11, 25);
		new gnTable().setTablewidth(table, 12, 150);
		new gnTable().setTablewidth(table, 13, 150);

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
		new gnTable().setFont(table, 16);

	}// End Show Table

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			e.notifyAll();
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 1);
			String vtype = "";
			String vbatchcontrol = (String) table.getValueAt(row, 11);
			String vvloc = from.getSelectedItem().toString();
			try {
				QtychangeImapct(value, row);
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	private void checkBatchApplicablity(String value, String vbatchcontrol, String vvloc) throws Throwable {
		String vtype = "";
		inventroyType = adjtype.getSelectedItem().toString();
		switch (inventroyType.trim()) {
		case "Add":
			vtype = "Allwithcost";
			CheckBatchArticle(value, vbatchcontrol, vvloc, vtype);
			break;
		case "Reduce":
			vtype = "AllPluswithcost";
			CheckBatchArticle(value, vbatchcontrol, vvloc, vtype);
			break;
		}

	}

	//// BAtch amd Multiple Price selection
	public String CheckBatchArticle(String varticle, String vbatchcontrol, String vvloc, String vtype)
			throws Throwable {
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
				table.setValueAt(new gnGetBatch().cost, selectedrow, 4);
				table.setValueAt(new gnGetBatch().mrp, selectedrow, 6);
				table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 5);
				table.setValueAt(new gnGetBatch().batchno, selectedrow, 12);
				table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 13);
				table.setValueAt(new gnGetBatch().bal_qty, selectedrow, 7);
				new gnGetBatch().resetValues();
				// QtychangeWPO(varticle, selectedrow);
			}
			break;
		case "Y":
			checkBatchforNonBatchItems(varticle, vbatchcontrol, vtype);
			break;
		} // Switch
		return status;
	}// Method End

	private void checkBatchforNonBatchItems(String varticle, String vbatchcontrol, String vtype) throws Throwable {
		String vcost = "0";
		vcost = table.getValueAt(selectedrow, 4).toString();
		String vsp = table.getValueAt(selectedrow, 5).toString();
		String vmrp = table.getValueAt(selectedrow, 6).toString();
		String vloc = from.getSelectedItem().toString();
		String vaction = "";

		switch (inventroyType) {
		case "Add":
			// vaction = new gnBatch(). IsBatchAvailableForCostMrpSP(varticle,
			// vmrp, vsp, vcost);
			vaction = new gnBatch().IsBatchAvailableForIsBatchAvailableforMrpandSP(varticle, vmrp, vsp);
			break;
		case "Reduce":
			vaction = new gnBatch().IsBatchAvailableForIsBatchAvailableforMrpandSP(varticle, vmrp, vsp);
			break;
		}
		// new General().msg(vaction);
		switch (vaction) {
		case "Y":
			String vaction1 = new gnBatch().IsMultiBatchForMRP_SalesPrice(varticle, vmrp, vsp, vcost);
			vaction1 = "Y";
			switch (vaction1) {
			case "Y":
				try {
					new gnGetBatch().getBatchDetailForNonBathItems(vtype, varticle, vbatchcontrol, vloc);
				} catch (Exception e) {
					new General().msg(e.getLocalizedMessage());
				} finally {

					if (Double.parseDouble(new gnGetBatch().salesPrice) > 0) {
						table.setValueAt(new gnGetBatch().cost, selectedrow, 4);
						table.setValueAt(new gnGetBatch().mrp, selectedrow, 6);
						table.setValueAt(new gnGetBatch().salesPrice, selectedrow, 5);
						table.setValueAt(new gnGetBatch().batchno, selectedrow, 12);
						table.setValueAt(new gnGetBatch().expiry_date, selectedrow, 13);
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

	public String CheckBatchArticle() {
		String Action = "Sucess";
		int rw = table.getRowCount();
		String vbatch = " ";
		String vExp = "";
		String vbatchno = " ";
		String varticle = "";
		for (int k = 0; k < rw; k++) {
			vbatch = table.getValueAt(k, 11).toString();
			vExp = table.getValueAt(k, 13).toString();
			vbatchno = table.getValueAt(k, 12).toString();
			varticle = table.getValueAt(k, 1).toString();
			if (vExp.isEmpty()) {
				vExp = "0";
			}
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

	private JTextField reason;
	private JLabel lblNewLabel_3;
	private JTextField svno;
	private JLabel lblNewLabel_8;

	public String QtychangeImapct(String value, int i) throws SQLException, ClassNotFoundException {
		// private String Col[] = {"Remove" , 1"Article", 2"Name" , 3"UOM" ,
		// 4"Cost" ,5"SalesPrice" , 6"MRP" ,
		// 7"Bal.Qty" , 8"Type", 9"Reason" , 10 "Adj.Qty" ,11 "Batch Article" ,
		// 12"BatchNO" , 13"Expiry date" } ;
		String action = "Sucess";
		String stocktype = table.getValueAt(i, 8).toString();

		switch (stocktype) {
		case "NoAction":
			new General().msg("Please Select Correct Adjustment Type ..at row " + " " + i + "Column Type");
			break;
		case "Reduce":
			double vreduceqty = Double.parseDouble(table.getValueAt(selectedrow, 10).toString());
			double vbalqty = Double.parseDouble(table.getValueAt(selectedrow, 7).toString());
			if (vreduceqty > vbalqty) {
				new General().msg("Please Check Stock Adj Qty is Hiegher then Balance Stock ");
				table.setValueAt("0", selectedrow, 10);
			}
			break;
		}
		// System.out.println("Item is "+value + "Row is"+ i);
		String curqty1 = (String) table.getValueAt(i, 10).toString();
		Double curqty = Double.parseDouble(curqty1);
		if (curqty < 0) {
			table.setEditingRow(i);
			table.setGridColor(Color.YELLOW);
			table.setBackground(Color.red);
		}
		Double vbalqty = Double.parseDouble(table.getValueAt(i, 7).toString());
		Double vtrfqty = Double.parseDouble(table.getValueAt(i, 10).toString());
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
		int row = table.getRowCount();
		if (row <= 0) {
			result = "Fail";
			new General().msg("No Data Available....");
		}
		double vbalqty = 00.00;
		double vtrfqty = 00.00;
		int rw = table.getRowCount();
		for (int i = 0; i < rw; i++) {
			// vtrfqty = Double.parseDouble( table.getValueAt(i, 9).toString())
			// ;
			// vbalqty = Double.parseDouble( table.getValueAt(i, 7).toString())
			// ;
			// String varticle = ( table.getValueAt(i, 1).toString()) ;
			// if (vtrfqty > vbalqty )
			// {
			// result = "Fail" ;
			// new General().msg("Transfer Qty Can not be > Bal.Stock Please
			// Check For Article ==>"+""+varticle) ;
			// }
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
			vtrfno = new gnSeq().getSeqno("12", "TR");
			new General().msg("Stock Voucher No:" + vtrfno);
			svno.setText(vtrfno);
			int vvtrfno = Integer.parseInt(vtrfno);
			if (vvtrfno > 0) {
				insertSVposting();
			} else {
				new General().msg("<Check For Location Transfer Number..> Number Not Generated");
				new gnImageSound().playAlertSound();
				return;
			}
		}
	}

	public void insertSVposting() throws Throwable {
		vtrtype = "StockAdj";
		prst = null;
		int vbatchSize = table.getRowCount();
		final int batchSize = vbatchSize;
		int TotalRecordinsert = 0;
		String vmanufdt = "0";
		String vexpdate = "0";
		con3 = (Connection) this.getConnection();
		con3.setAutoCommit(false);
		String prdetail = "Insert into   sc_stockVoucherPosting(Company_code , Site_code  , Type,"
				+ "svno , svdate, srno,    Article_code  ,  Name,  batchArticle , batchno , expirydate ,     balqty ,"
				+ "  AdjQty , Location, Cost, Mrp, SalesPrice,     StockCheckNo , StockcheckDate , "
				+ "  CreatedBy , CreateDate , time ,  finyear , Action , Reason  )"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {

				String vinvaction = table.getValueAt(k, 8).toString();
				double vsvqty = Double.parseDouble((table.getValueAt(k, 10).toString()));
				switch (vinvaction) {
				case "Reduce":
					vsvqty = vsvqty * -1;
				}

				prst = con3.prepareStatement(prdetail);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vtrtype);
				prst.setString(4, vtrfno);
				prst.setString(5, vtrfdate);
				prst.setInt(6, k);

				// private String Col[] = {"Remove" , 1"Article", 2"Name" ,
				// 3"UOM" , 4"Cost" ,5"SalesPrice" , 6"MRP" ,
				// 7"Bal.Qty" , 8"Type", 9"Reason" , 10 "Adj.Qty" ,11 "Batch
				// Article" ,
				// 12"BatchNO" , 13"Expiry date" } ;

				prst.setString(7, (table.getValueAt(k, 1).toString()));
				prst.setString(8, (table.getValueAt(k, 2).toString()));
				prst.setString(9, (table.getValueAt(k, 11).toString()));

				String vbatcharticle = (table.getValueAt(k, 11).toString());
				// new General().msg(vbatcharticle);
				switch (vbatcharticle) {
				case "Y":
					prst.setString(10, table.getValueAt(k, 12).toString());
					prst.setString(11, new gnConfig().date_ConverttoDBforamt((table.getValueAt(k, 13).toString())));
					break;
				case "N":
					// new General().msg(vbatcharticle);
					prst.setString(10, table.getValueAt(k, 12).toString());
					prst.setString(11, "0000.00.00");
					break;
				}
				prst.setString(12, (table.getValueAt(k, 7).toString()));
				prst.setDouble(13, vsvqty);
				prst.setString(14, from.getSelectedItem().toString());
				prst.setString(15, (table.getValueAt(k, 4).toString())); // Cost
				prst.setString(16, (table.getValueAt(k, 5).toString())); // mrp
				prst.setString(17, (table.getValueAt(k, 6).toString())); // SP
				prst.setString(18, "0"); // ScNo
				prst.setString(19, "0000.00.00"); // ScDateow
				prst.setString(20, super.ucode);
				prst.setString(21, vtrfdate);
				prst.setString(22, new General().getTime());
				prst.setString(23, vfinyear);
				prst.setString(24, (table.getValueAt(k, 8).toString())); // adjtype
																			// //Action
				prst.setString(25, (table.getValueAt(k, 9).toString())); // Reason
				prst.addBatch();
				// new General().msg("prst"+""+prst) ;
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
				new General().Quickmsg("Data Saved Sucessfully...");
				con3.commit();
				con3.close();
				new gnSeq().updateSeqno("12", "TR");
				postSV();
				reset();
			}
			if (prst != null) {
				prst.close();
			}
		}
	}

	private void reset() {
		new gnTable().RemoveTableRows(model);
		code.setText(null);
		search.setText(null);

	}

	private void postSV() throws Throwable {
		try {
			/// Non Batch Article Sv Posting

			String vdocdate = new gnConfig().date_ConverttoDBforamt(date.getText());
			String vsvno = svno.getText();

			String trnType = "SVPlus";
			String SQL3 = "call Stock_PostAdj_sv( " + vcomp + " ,  " + vstore + " ,  '" + trnType + "' , " + vsvno
					+ " , '" + vdocdate + "', '" + vfinyear + "' )";
			// new General().msg(SQL3);
			this.getSPResult(SQL3);

			String trnType1 = "SVMinus";
			String SQL4 = "call Stock_PostAdj_sv( " + vcomp + " ,  " + vstore + " ,  '" + trnType1 + "' , " + vsvno
					+ " , '" + vdocdate + "'  , '" + vfinyear + "')";
			// new General().msg(SQL4);
			this.getSPResult(SQL4);

			/// Batch Article Sv Posting
			String trnType5 = "SVPlus";
			String SQL5 = "call Stock_PostAdj_sv_batch( " + vcomp + " ,  " + vstore + " ,  '" + trnType5 + "' , "
					+ vsvno + " , '" + vdocdate + "' , '" + vfinyear + "')";
			this.getSPResult(SQL5);

			String trnType6 = "SVMinus";
			String SQL6 = "call Stock_PostAdj_sv_batch( " + vcomp + " ,  " + vstore + " ,  '" + trnType6 + "' , "
					+ vsvno + " , '" + vdocdate + "' , '" + vfinyear + "')";
			this.getSPResult(SQL6);

			/// NonBatch Article Sv Posting
			String vpara811 = "811";
			String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
					vstore);
			switch (vmaintainbatchforNonBatchItem) {
			case "Y":

				String trnType66 = "SVPlus";
				String SQL66 = "call Stock_PostAdj_sv_NonbatchItem( " + vcomp + " ,  " + vstore + " ,  '" + trnType66
						+ "' , " + vsvno + " , '" + vdocdate + "' , '" + vfinyear + "')";
				// new General().msg(SQL66);
				this.getSPResult(SQL66);

				String trnType67 = "SVMinus";
				String SQL67 = "call Stock_PostAdj_sv_NonbatchItem( " + vcomp + " ,  " + vstore + " ,  '" + trnType67
						+ "' , " + vsvno + " , '" + vdocdate + "' , '" + vfinyear + "')";
				// new General().msg(SQL67);
				this.getSPResult(SQL67);
				break;
			}
		} catch (Exception e) {
			new General().msg(e.getMessage());
		}
	}
}// Last

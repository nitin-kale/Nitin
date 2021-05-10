package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.border.MatteBorder;

public class store_configuration extends getResultSet {
	private JButton btnSave;
	private JLabel lblNewLabel;
	JButton btnReload;
	private JTextField totalparam;
	private JLabel lblNewLabel_1;
	private JTextField storeparam;
	private JButton btnUpdate;
	private JButton btnClose;
	public String vcomp;
	public String vstore;
	JInternalFrame internalFrame;
	JPasswordField mycode = new JPasswordField();
	public String vcompname;
	private JComboBox configOption;
	JFrame storeconfigFrame;
	private JTextField companycode;
	private JTextField storecode;
	private JTextField storename;
	private JTextField companyname;
	private JButton Msg;
	private String ConfigType;
	private JEditorPane edtpane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	////
	public JScrollPane jsp;
	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2 || column == 3) {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			} else {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}
			return componentt;

		}
	};

	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			// 2 4 6 7 8 9 10 14 15 16 19
			return column == 0 || column == 1 || column == 2 || column == 3 ? false : true;
		}

	};

	public JScrollPane sjsp;
	public JTable stable;
	public DefaultTableModel smodel = new DefaultTableModel();

	///
	// public String[] Col ={" Module" , "Config.No" ,"Parameter" , "Default
	/// Value" , "Set Value" };
	// String[] SCol = {"Store Code" , "Store Name" } ;

	private String vradiovalue;
	private JLabel lblSetConfigurationFor;
	private JButton btnInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					store_configuration window = new store_configuration();
					window.storeconfigFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
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
	public store_configuration() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		storeconfigFrame = new JFrame();
		storeconfigFrame.setTitle("Business Application");
		storeconfigFrame.setBackground(new Color(153, 255, 255));
		storeconfigFrame.setResizable(false);
		storeconfigFrame.setAlwaysOnTop(true);
		//storeconfigFrame.setBounds(10, 60, 1200, 606);
		storeconfigFrame.setBounds(1, 100, 1350, 600);
		
		storeconfigFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		storeconfigFrame.getContentPane().setLayout(null);
		storeconfigFrame.getContentPane().setEnabled(false);
		storeconfigFrame.getContentPane().setForeground(new Color(51, 255, 153));
		storeconfigFrame.getContentPane().setBackground(Color.WHITE);


		/*
		internalFrame = new JInternalFrame("Store Configuration Module");
 		internalFrame.setBounds(0, 0, 1200, 620);
		storeconfigFrame.getContentPane().add(internalFrame);
         */
		
		
		JLabel lblCompanyCode = new JLabel("Company Code");
		lblCompanyCode.setBounds(12, 17, 95, 16);
		lblCompanyCode.setFont(new Font("Calibri", Font.BOLD, 14));
		storeconfigFrame.getContentPane().add(lblCompanyCode);

		companycode = new JTextField();
		companycode.setBounds(110, 13, 62, 25);
		companycode.setBackground(Color.WHITE);
		companycode.setFont(new Font("Calibri", Font.BOLD, 13));
		storeconfigFrame.getContentPane().add(companycode);
		companycode.setColumns(10);

		ActionListener cmp = new Company();
		ActionListener opt = new optioLsnr();
		ActionListener vbtn = new Btn();

		companycode.addActionListener(cmp);
		companycode.setEnabled(false);

		JLabel lblStoreCode = new JLabel("Store code");
		lblStoreCode.setBounds(39, 43, 68, 16);
		lblStoreCode.setFont(new Font("Calibri", Font.BOLD, 14));
		storeconfigFrame.getContentPane().add(lblStoreCode);

		storecode = new JTextField();
		storecode.setBounds(110, 40, 62, 25);
		storecode.setBackground(Color.WHITE);
		storecode.setFont(new Font("Calibri", Font.BOLD, 13));
		storeconfigFrame.getContentPane().add(storecode);
		storecode.setColumns(10);
		ActionListener str = new store();
		storecode.addActionListener(str);

		storename = new JTextField();
		storename.setBounds(174, 40, 275, 25);
		storename.setBackground(Color.WHITE);
		storename.setFont(new Font("Calibri", Font.BOLD, 13));
		storename.setEditable(false);
		storeconfigFrame.getContentPane().add(storename);
		storename.setColumns(10);

		companyname = new JTextField();
		companyname.setBounds(174, 13, 275, 25);
		companyname.setBackground(Color.WHITE);
		companyname.setFont(new Font("Calibri", Font.BOLD, 13));
		companyname.setEditable(false);
		storeconfigFrame.getContentPane().add(companyname);
		companyname.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 132, 1344, 422);
		panel_1.setBorder(new MatteBorder(1, 10, 1, 10, (Color) new Color(51, 255, 255)));
		panel_1.setBackground(new Color(102, 255, 255));
		storeconfigFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		jsp = new JScrollPane();
		jsp.setBounds(29, 0, 1274, 409);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_1.add(jsp);

		sjsp = new JScrollPane();
		sjsp.setBounds(0, 0, 1184, 425);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		lblSetConfigurationFor = new JLabel("Set Configuration For");
		lblSetConfigurationFor.setBounds(487, 17, 143, 16);
		lblSetConfigurationFor.setHorizontalAlignment(SwingConstants.LEFT);

		configOption = new JComboBox();
		configOption.setFont(new Font("Tahoma", Font.PLAIN, 13));
		configOption.setBounds(477, 33, 163, 30);
		configOption.setMaximumRowCount(15);
		configOption.addActionListener(opt);

		storeconfigFrame.getContentPane().add(configOption);
		storeconfigFrame.getContentPane().add(lblSetConfigurationFor);

		Msg = new JButton("");
		Msg.setBounds(37, 69, 1259, 25);
		Msg.setFont(new Font("Cambria", Font.BOLD, 13));
		Msg.setForeground(new Color(0, 0, 153));
		Msg.setEnabled(false);
		Msg.setBackground(new Color(204, 255, 204));
		// model = new DefaultTableModel();
		// table = new JTable();
		storeconfigFrame.getContentPane().add(Msg);

		edtpane = new JEditorPane();
		edtpane.setBounds(898, 0, 203, 79);
		edtpane.setForeground(new Color(0, 255, 153));
		edtpane.setBackground(new Color(0, 51, 153));
		storeconfigFrame.getContentPane().add(edtpane);

		lblNewLabel = new JLabel("Total Parameters");
		lblNewLabel.setBounds(722, 14, 106, 16);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 13));
		storeconfigFrame.getContentPane().add(lblNewLabel);

		totalparam = new JTextField();
		totalparam.setBounds(830, 11, 62, 22);
		totalparam.setForeground(new Color(0, 0, 102));
		totalparam.setFont(new Font("Calibri", Font.BOLD, 13));
		storeconfigFrame.getContentPane().add(totalparam);
		totalparam.setColumns(10);

		lblNewLabel_1 = new JLabel("Parameter Enter For Store");
		lblNewLabel_1.setBounds(676, 37, 158, 16);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 13));
		storeconfigFrame.getContentPane().add(lblNewLabel_1);

		storeparam = new JTextField();
		storeparam.setBounds(830, 34, 62, 22);
		storeparam.setForeground(new Color(0, 0, 102));
		storeparam.setFont(new Font("Calibri", Font.BOLD, 13));
		storeparam.setEnabled(false);
		storeconfigFrame.getContentPane().add(storeparam);
		storeparam.setColumns(10);

		// btnSave = new JButton("Save");
		btnSave = new gnRoundButton("Save");
		btnSave.setBackground(Color.WHITE);
		btnSave.setBounds(531, 100, 97, 30);
		storeconfigFrame.getContentPane().add(btnSave);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setMnemonic('S');
		btnSave.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApsave1.png"));
		btnSave.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApsave.png"));

		// btnUpdate = new JButton("Update");
		btnUpdate = new gnRoundButton("Update");
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(630, 100, 97, 30);
		storeconfigFrame.getContentPane().add(btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setMnemonic('U');
		btnUpdate.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApUpdate1.png"));
		btnUpdate.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApUpdate.png"));

		// btnClose = new JButton("Close");
		btnClose = new gnRoundButton("Close");
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(730, 100, 97, 30);
		storeconfigFrame.getContentPane().add(btnClose);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setMnemonic('C');
		btnClose.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose1.png"));
		btnClose.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose.png"));

		// btnReload = new JButton("Reload Configuration");
		btnReload = new gnRoundButton("Reload Configuration");
		btnReload.setBackground(Color.WHITE);
		btnReload.setBounds(830, 100, 170, 30);
		storeconfigFrame.getContentPane().add(btnReload);
		btnReload.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReload.setForeground(new Color(0, 0, 102));
		btnReload.setMnemonic('R');

		// btnInfo = new JButton("GET Information");
		btnInfo = new gnRoundButton("GET Information");
		btnInfo.setBackground(Color.WHITE);
		btnInfo.setBounds(1006, 100, 170, 30);
		storeconfigFrame.getContentPane().add(btnInfo);
		btnInfo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInfo.setForeground(new Color(0, 0, 102));
		btnInfo.setMnemonic('I');
		btnInfo.addActionListener(vbtn);
		btnReload.addActionListener(vbtn);
		btnClose.addActionListener(vbtn);
		btnUpdate.addActionListener(vbtn);
		btnSave.addActionListener(vbtn);
		edtpane.setVisible(false);
 		validateUser();
		// decorateComp();
	}

	private void validateUser() {
		String action = "Sucess";
		JPanel panel = new JPanel();
		mycode.setBackground(Color.WHITE);
		mycode.setFont(new Font("Calibri", Font.BOLD, 13));
		mycode.setBounds(1, 2, 275, 23);
		mycode.setColumns(10);
		ActionListener cb = new codeLsnr();
		mycode.addActionListener(cb);
		mycode.grabFocus();
		panel.setBackground(Color.black);
		panel.add(mycode);
		mycode.requestFocus();
		mycode.grabFocus();
		new General().msgPanel(panel, "Enter Config Key Code", 50, 50);
	}

	class codeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String value = mycode.getText().trim();
			new General().msgDispose();
			switch (value) {
			case "123":
				try {
					decorateComp();
				} catch (Throwable e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

	public void setDefault() throws Throwable {
		String vuser = new gnConfig().getUserCode().toUpperCase();
		new gnApp().setFrameTitel(storeconfigFrame);
		new gnField().closeform(btnSave, storeconfigFrame);
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		storecode.setText(new gnConfig().getStoreID());
		storename.setText(new gnConfig().getStorename(storecode.getText()));
		vcomp = companycode.getText();
		vstore = storecode.getText();
		if (vcomp != "0") {
			companycode.setEnabled(false);
			storecode.setEnabled(true);
		}
		switch (vcomp) {
		case "0":
			companycode.setEnabled(true);
			storecode.setEnabled(true);
		}
	}

	public void decorateComp() throws Throwable {

		String vuser = new gnConfig().getUserCode().toUpperCase();
		new gnApp().setFrameTitel(storeconfigFrame);
		new gnField().closeform(btnSave, storeconfigFrame);
		storeconfigFrame.setUndecorated(true);
		
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		storecode.setText(new gnConfig().getStoreID());
		storename.setText(new gnConfig().getStorename(storecode.getText()));
		vcomp = companycode.getText();
		vstore = storecode.getText();
		if (vcomp != "0") {
			companycode.setEnabled(false);
			storecode.setEnabled(true);
		}
		switch (vcomp) {
		case "0":
			companycode.setEnabled(true);
			storecode.setEnabled(true);
		}

		String SQL = "call config_getDistinctconfig()";
		try {
			new gnComp().fillCombo(SQL, configOption);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		int typecode = 1;
		new gnDecorate().SetSeqHdrButton(btnUpdate, typecode);
		new gnDecorate().SetSeqHdrButton(btnClose, typecode);
		new gnDecorate().SetSeqHdrButton(btnSave, typecode);
		new gnDecorate().SetSeqHdrButton(btnReload, typecode);
		new gnDecorate().SetSeqHdrButton(btnInfo, typecode);

		new gnDecorate().DispField_Eatch(companycode, 20);
		new gnDecorate().DispField_Eatch(companyname, 100);
		new gnDecorate().DispField_Eatch(storecode, 20);
		new gnDecorate().DispField_Eatch(storename, 20);
		new gnDecorate().DispField_Eatch(totalparam, 20);
		new gnDecorate().DispField_Eatch(storeparam, 20);
		new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnUpdate, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnClose, Color.BLUE, Color.WHITE);
 	}

	
	class Btn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			System.out.println(" Btn Events Reached ");
			int i = e.getID(); // Field Id

			if (value == "Close") {
				storeconfigFrame.dispose();
			}

			if (value == "Reload Configuration") {
				try {
					ReloadConfig();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Save") {

				try {
					String status = checkTableData();
					if (status == "Sucess") {
						SaveNewConfig();
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Update") {
				try {
					String status = checkTableData();
					if (status == "Sucess") {
						UpdateConfig();
					}
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "GET Information") {
				int row = table.getSelectedRow();
				String vinfo;
				try {
					String status = checkTableData();
					if (status == "Sucess") {
						String vpara = table.getValueAt(row, 1).toString();
						String Title = table.getValueAt(row, 2).toString();
						Title = "Config.Parameter :  " + " " + Title;
						Title.format(Title, "WRAP");
						vinfo = new gnApp().getParameterInfo(vpara);
						new showHelp().showHelp(vinfo, Title);
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	private String checkTableData() {
		String status = "Sucess";
		int row = table.getRowCount();
		if (row > 0) {
			status = "Sucess";
		}
		if (row == 0) {
			status = "Fail";
			new General().msg("No Data Found For Action...");
		}
		return status;
	}

	class store implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			System.out.println("Reached ");
			int i = e.getID(); // Field Id
			try {
				vcomp = companycode.getText();
				vstore = storecode.getText();
				new gnAdmin().setstore(storecode, storename, vcomp);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				try {
					new gnAdmin().checkParameters(vcomp, vstore, totalparam, storeparam);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	class Company implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			System.out.println("Reached ");
			int i = e.getID(); // Field Id
			try {
				new gnAdmin().setcompany(companycode, companyname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class optioLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			ProcessAction();
		}
	}

	private void ApplyOtherSetting() {

	}

	private void ProcessAction() {

		String vst = CheckStoreCode();
		if (vst == "Sucess") {
			String choice = " ";
			try {
				choice = checkConfigExist();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			switch (choice) {
			case "New":
				String value = configOption.getSelectedItem().toString().trim();
				String SQL = "call  Config_getDefaultconfig('" + value + "')";
				try {
					showConfig(SQL);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case "Update":
				String value1 = configOption.getSelectedItem().toString().trim();
				String vcomp = companycode.getText();
				String vstore = storecode.getText();
				String SQL1 = "call  config_getExistingconfig('" + value1 + "', " + vcomp + " , " + vstore + ")";
				try {
					updateConfig(SQL1);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			}// switch
		}

	}

	private String CheckStoreCode() {
		String status = "Sucess";
		if (storecode.getText().length() == 0) {
			status = "Fail";
			new gnImageSound().playSound();
			new General().msg("!!!... Select Store code ...!!!");
		}
		return status;
	}

	private String checkConfigExist() throws ClassNotFoundException, SQLException {
		String status = "Sucess";
		ConfigType = configOption.getSelectedItem().toString();
		String vcomp = companycode.getText();
		String vstore = storecode.getText();
		String SQL = "call  config_getExistingconfig('" + ConfigType + "', " + vcomp + " , " + vstore + ")";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			status = "Update";
		} else {
			status = "New";
		}
		return status;
	}

	private void updateConfig(String SQL) throws ClassNotFoundException, SQLException {
		btnSave.setEnabled(false);
		btnUpdate.setEnabled(true);
		Msg.setText("Change Configuration As Per Business Process...");
		String[] Col = { " Module", "Config.No", "Parameter", "Default Value", "Set Value" };
		model.setColumnIdentifiers(Col);
		new gnTable().RemoveTableRows(model);
		new gnTable().setTableBasics(table);
		rs = this.getSPResult(SQL);
  		while (rs.next()) {
				model.addRow(new Object[] { rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7) });
				table.setModel(model);

		/*		
				if (ConfigType == "Others") {
					table.removeAll();
					TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
					table.setDefaultEditor(String.class, DefaultEditor);
					table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(companycode));
				}

				if (ConfigType == "Purchase") {
					table.removeAll();
					TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
					table.setDefaultEditor(String.class, DefaultEditor);
					table.getColumnModel().getColumn(4)
							.setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
				}

				if (ConfigType == "Purchase Return") {
					table.removeAll();
					TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
					table.setDefaultEditor(String.class, DefaultEditor);
 					table.getColumnModel().getColumn(4)
							.setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
				}

				if (ConfigType == "Authorization") {
					table.removeAll();
					TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
					table.setDefaultEditor(String.class, DefaultEditor);
					table.getColumnModel().getColumn(4)
							.setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
					new gnTable().setTableBasics(table);

				}

				if (ConfigType == "Sales Return") {
					table.removeAll();
					TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
					table.setDefaultEditor(String.class, DefaultEditor);
					table.getColumnModel().getColumn(4)
							.setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
					new gnTable().setTableBasics(table);
				}

				if (ConfigType == "B2B") {
					table.removeAll();
					TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
					table.setDefaultEditor(String.class, DefaultEditor);
					table.getColumnModel().getColumn(4)
							.setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
					new gnTable().setTableBasics(table);

				}

				if (ConfigType == "POS") {
					table.removeAll();
					TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
					table.setDefaultEditor(String.class, DefaultEditor);
					table.getColumnModel().getColumn(4)
							.setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
					new gnTable().setTableBasics(table);
				}

				if (ConfigType == "Application") {
					table.removeAll();
					TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
					table.setDefaultEditor(String.class, DefaultEditor);
					table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
					new gnTable().setTableBasics(table);
				}
		*/
				
				table.setCellSelectionEnabled(false);
				table.setRowSelectionAllowed(true);
				new gnTable().setTableColWidth(table, 3, 250);
				table.setGridColor(Color.BLUE);
				table.setForeground(Color.BLACK);
				table.setBackground(Color.CYAN);

		
  		}
 			
			JViewport prt = new JViewport();
			prt.setBackground(Color.CYAN);
			prt.add(table, Col);
			prt.setVisible(true);
			jsp.setViewport(prt);
		
	}

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			e.notifyAll();
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 1);
			getFileAndDir(row);
		}
	};

	private void showConfig(String SQL) throws ClassNotFoundException, SQLException {
		// new General().msg("Show configuration");
		btnSave.setEnabled(true);
		btnUpdate.setEnabled(false);
		Msg.setText("Set New  Configuration  For Store As Per Business Process...");
		String[] Col = { " Module", "Config.No", "Parameter", "Default Value", "Set Value" };
		model.setColumnIdentifiers(Col);
		new gnTable().RemoveTableRows(model);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5) });
			table.setModel(model);
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));

			if (ConfigType == "Others") {
				table.removeAll();
				TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
				table.setDefaultEditor(String.class, DefaultEditor);
				table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(companycode));
			}

			if (ConfigType == "Purchase") {
				table.removeAll();
				TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
				table.setDefaultEditor(String.class, DefaultEditor);
				table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			}

			if (ConfigType == "Purchase Return") {
				table.removeAll();
				TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
				table.setDefaultEditor(String.class, DefaultEditor);

				table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			}

			if (ConfigType == "Authorization") {
				table.removeAll();
				TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
				table.setDefaultEditor(String.class, DefaultEditor);

				table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			}

			if (ConfigType == "Sales Return") {
				table.removeAll();
				TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
				table.setDefaultEditor(String.class, DefaultEditor);
				table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			}

			if (ConfigType == "B2B") {
				table.removeAll();
				TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
				table.setDefaultEditor(String.class, DefaultEditor);
				table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			}

			if (ConfigType == "POS") {
				table.removeAll();
				TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
				table.setDefaultEditor(String.class, DefaultEditor);
				table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			}

			if (ConfigType == "Application") {
				table.removeAll();
				TableCellEditor DefaultEditor = table.getDefaultEditor(String.class);
				table.setDefaultEditor(String.class, DefaultEditor);
				table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
			}

			table.setCellSelectionEnabled(false);
			table.setRowSelectionAllowed(true);
			table.setGridColor(Color.gray);
			table.setForeground(Color.BLACK);
		}
		// setEditor() ;
		TR_Purchase tr = new TR_Purchase();
		TableColumnModel tcm = table.getColumnModel();
		for (int c = 0; c < 3; c++) {
			TableColumn tc = tcm.getColumn(c);
			tc.setCellRenderer(tr);
		}

		new gnTable().setTableColWidth(table, 4, 600);
		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.CYAN);
		prt1.add(table, Col);
		prt1.setVisible(true);
		jsp.setViewport(prt1);
	}

	/// Table insert and Update Start HEre

	private String ReloadConfig() throws SQLException, ClassNotFoundException, IOException {
		String status = "Sucess";
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String updconfig = " Delete from  ms_store_configuration   where  " + "Company_code = ?  AND Store_code = ?";
		try {
			prst = con1.prepareStatement(updconfig);
			prst.setString(1, companycode.getText());
			prst.setString(2, storecode.getText());
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con1.commit();
			}
			prst.executeBatch(); // insert remaining records
			con1.commit();
			status = "Sucess";
		} catch (SQLException e) {
			new General().msg("error:" + e.getMessage());
			con1.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (status == "Sucess") {
				new General().msg("Removed Data  Sucessfully");
				new gnTable().RemoveTableRows(model);
				ProcessAction();
			}
			if (con1 != null) {
				con1.close();
			}
		}
		return status;
	}

	private String UpdateConfig() throws SQLException, ClassNotFoundException, IOException {
		String status = "Sucess";
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String updconfig = " Update  ms_store_configuration   set  "
				+ "value = ?  where company_code = ?  and Store_code = ? and no = ? ";
		try {
			int row = table.getRowCount();
			for (int i = 0; i < row; i++) {
				prst = con1.prepareStatement(updconfig);
				prst.setString(1, table.getValueAt(i, 4).toString());
				prst.setString(2, companycode.getText());
				prst.setString(3, storecode.getText());
				prst.setString(4, table.getValueAt(i, 1).toString());
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				status = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					status = "Sucess";
					con1.commit();
				}
				prst.executeBatch(); // insert remaining records
				con1.commit();
				status = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg("error:" + e.getMessage());
			con1.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (status == "Sucess") {
				new General().msg("Configuration Updated Sucessfully");
				new gnTable().RemoveTableRows(model);
			}
			if (con1 != null) {
				con1.close();
			}
		}
		return status;
	}

	private String SaveNewConfig() throws SQLException, ClassNotFoundException, IOException {
		String status = "Sucess";
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String Status = "Fail";
		String poshdr = "Insert into ms_store_configuration(company_code, store_code , "
				+ "module , no , parameter ,  default_value, value, description) " + "values(?,?,?,?,?,?,?,?)";
		try {
			int row = table.getRowCount();
			for (int i = 0; i < row; i++) {
				prst = con1.prepareStatement(poshdr);
				prst.setString(1, companycode.getText());
				prst.setString(2, storecode.getText());
				prst.setString(3, table.getValueAt(i, 0).toString());
				prst.setString(4, table.getValueAt(i, 1).toString());
				prst.setString(5, table.getValueAt(i, 2).toString());
				prst.setString(6, table.getValueAt(i, 3).toString());
				prst.setString(7, table.getValueAt(i, 4).toString());
				prst.setString(8, table.getValueAt(i, 2).toString());

				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				status = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					status = "Sucess";
					con1.commit();
				}
				prst.executeBatch(); // insert remaining records
				con1.commit();
			}
		} catch (SQLException e) {
			new General().msg("Header " + e.getMessage());
			con1.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
				new gnTable().RemoveTableRows(model);
			}
			if (status == "Sucess") {
				new General().msg("Configuration Saved Sucessfully");
			}
			if (con1 != null) {
				con1.close();
			}
		}
		return status;
	}

	private void getFileAndDir(int row) {
		GetFileName file = new GetFileName();
		String vname = file.getFile();
		vname.replace("'\'", "'//'");
		// vname.replaceAll(vname, "//") ;
		new General().msg(vname);
		table.setValueAt(vname, row, 4);
		table.notify();
	}

	private void setEditor() {

		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			String YN = table.getValueAt(i, 3).toString();
			if (YN == "Y" || YN == "N") {
				table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			}
		}
	}
}// Last

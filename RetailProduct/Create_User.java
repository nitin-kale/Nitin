package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.ImageIcon;

public class Create_User extends getResultSet {
	private JTextField companycode;
	private JTextField storecode;
	private JTextField companyname;
	private JTextField storename;
	//
	private String verticlecode;
	private String verticlename;
	private String segmentcode;
	JInternalFrame internalFrame;
	private String segmentname;
	//

	public JFrame CreateUserFrame;
	public JTextField userCode;
	public JComboBox comboRole1 = new JComboBox<String>();
	public MaskFormatter f;
	private AbstractButton rolename;
	public JTextField name;
	private JButton btnClose;
	private JButton btnCancel;
	private JButton btnUpdate;
	private JButton btnChangePassword;
	private JComboBox activatecode1;

	String isview = "NO";

	/// Table insert variable
	private String vcode; // = userCode.getText();
	private String vname;// = name.getText();
	private String vpwd;// =password.getName();
	private String vcrdate;// = createDate.getText() ;
	private String vupddate;// = updateDate.getText() ;
	private String vpwdexpdate;// = pwexpDate.getText() ;
	private String vrole;// = rolecode.getText();
	private String vrolename;// = rolename.getText();

	// End Table Variables

	public JPasswordField password;
	public JTextField createDate;
	public JTextField updateDate;
	private JButton btnSave;
	public JTextField pwexpDate;

	public JPanel mainPanel;
	// private JTextField activecode;
	private JTextField rolecode;
	private JTextField roledescription;

	String vcomp ;
	String vvstore ;
	// ===
	public JScrollPane jsp;
	public JTable table = new JTable();
	public DefaultTableModel model = new DefaultTableModel();
	public String Col[] = { "Type", "user code ", "Name", " Password Expity Date", "Role  ", "Status", };

	public JScrollPane sjsp = null;
	public JTable stable = new JTable();
	public DefaultTableModel smodel = new DefaultTableModel();
	public String RolCol[] = { "Type", "Code ", "Name", };
	public String Com[] = { "Type", "Company_code", "Company_Name", "VATNO", "Phone", "Segment", "Segment_name",
			"Verticle", "Verticle_name" };

	/**
	 * /** Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Create_User window = new Create_User();
					window.CreateUserFrame.setVisible(true);
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
	public Create_User() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	@SuppressWarnings("unchecked")
	private void initialize() throws Throwable {
		CreateUserFrame = new JFrame();
		CreateUserFrame.setAlwaysOnTop(true);
		CreateUserFrame.setResizable(false);
		CreateUserFrame.setType(Type.UTILITY);
		CreateUserFrame.setTitle("Business Application");
		CreateUserFrame.setBounds(260, 170, 571, 300);
		CreateUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		CreateUserFrame.getContentPane().setLayout(null);

		internalFrame = new JInternalFrame("Business Application - User Management");
		internalFrame.setClosable(true);
		internalFrame.getContentPane().setEnabled(false);
		internalFrame.getContentPane().setBackground(Color.CYAN);
		internalFrame.setBounds(0, 0, 567, 267);
		CreateUserFrame.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.BLUE, null));
		mainPanel.setBounds(0, 0, 571, 187);
		internalFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JLabel lblUserCode = new JLabel("User Code");
		lblUserCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserCode.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblUserCode.setBounds(12, 28, 103, 16);
		mainPanel.add(lblUserCode);

		userCode = new JTextField();
		userCode.setToolTipText("User code is 10 Chars <Dont Enter more then 10 Chars including space>");
		userCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		userCode.setBounds(127, 26, 97, 22);
		mainPanel.add(userCode);
		userCode.setColumns(10);

		ActionListener lsnr1 = new lsnr();
		userCode.addActionListener(lsnr1);

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(52, 49, 56, 16);
		mainPanel.add(lblName);

		name = new JTextField(10);
		name.setFont(new Font("Tahoma", Font.BOLD, 12));
		name.setToolTipText("Name - 20 Chars Long");
		name.setBounds(127, 49, 149, 22);
		mainPanel.add(name);
		name.setColumns(20);
		ActionListener lsnr5 = new userlsnr();
		name.addActionListener(lsnr5);
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setBounds(52, 77, 63, 16);
		mainPanel.add(lblPassword);

		password = new JPasswordField();
		password.setFont(new Font("Tahoma", Font.BOLD, 12));
		password.setToolTipText("Password - 8 Chars long");
		password.setColumns(8);
		password.setBounds(127, 74, 149, 22);
		mainPanel.add(password);

		JPanel sidePanel = new JPanel();
		sidePanel.setBackground(Color.WHITE);
		sidePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 255), null));
		sidePanel.setBounds(288, 0, 260, 187);
		mainPanel.add(sidePanel);
		sidePanel.setLayout(null);

		JLabel lblCreatedOn = new JLabel("Created On");
		lblCreatedOn.setBounds(62, 104, 78, 16);
		lblCreatedOn.setFont(new Font("Verdana", Font.PLAIN, 13));
		sidePanel.add(lblCreatedOn);

		JLabel lblUpdatedOn = new JLabel("Updated On");
		lblUpdatedOn.setBounds(62, 130, 78, 16);
		lblUpdatedOn.setFont(new Font("Verdana", Font.PLAIN, 13));
		sidePanel.add(lblUpdatedOn);

		// createDate = new JFormattedTextField(new General().setDateFormat());
		createDate = new JTextField();
		createDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		createDate.setBounds(140, 99, 109, 22);
		createDate.setEditable(false);
		sidePanel.add(createDate);
		createDate.setColumns(10);

		// updateDate = new JFormattedTextField(new General().setDateFormat());
		updateDate = new JTextField();
		updateDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		updateDate.setBounds(140, 125, 109, 22);
		updateDate.setEditable(false);
		sidePanel.add(updateDate);
		updateDate.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(12, 153, 237, 22);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBackground(Color.CYAN);
		sidePanel.add(panel);
		panel.setLayout(null);

		pwexpDate = new JTextField();
		pwexpDate.setBackground(new Color(153, 255, 255));
		pwexpDate.setEditable(false);
		pwexpDate.setBounds(127, 0, 110, 22);
		panel.add(pwexpDate);
		pwexpDate.setColumns(10);

		JLabel lblPasswordExpiryDate = new JLabel("Password Expiry Date");
		lblPasswordExpiryDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPasswordExpiryDate.setBounds(0, 3, 123, 16);
		panel.add(lblPasswordExpiryDate);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(0, 0, 271, 99);
		sidePanel.add(panel_3);
		panel_3.setLayout(null);

		companycode = new JTextField();
		companycode.setFont(new Font("Tahoma", Font.BOLD, 12));
		companycode.setEditable(false);
		companycode.setBounds(12, 6, 76, 22);
		panel_3.add(companycode);
		companycode.setColumns(10);

		storecode = new JTextField();
		storecode.setFont(new Font("Tahoma", Font.BOLD, 12));
		storecode.setEditable(false);
		storecode.setBounds(12, 51, 76, 22);
		panel_3.add(storecode);
		storecode.setColumns(10);

		companyname = new JTextField();
		companyname.setBounds(12, 28, 226, 22);
		panel_3.add(companyname);
		companyname.setColumns(10);
		ActionListener cmp = new compLsnr();
		companyname.addActionListener(cmp);

		storename = new JTextField();
		storename.setBounds(12, 74, 229, 22);
		panel_3.add(storename);
		storename.setColumns(10);
		ActionListener str = new storeLsnr();
		storename.addActionListener(str);

		JLabel lblAssignStoreCode = new JLabel("Assign Store Code");
		lblAssignStoreCode.setBounds(90, 54, 117, 16);
		panel_3.add(lblAssignStoreCode);
		lblAssignStoreCode.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblAssignCompanyCode = new JLabel("Assign Company Code");
		lblAssignCompanyCode.setBounds(106, 9, 127, 16);
		panel_3.add(lblAssignCompanyCode);

		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon(Create_User.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel.setBounds(0, -1, 259, 185);
		panel_3.add(lblNewLabel);

		/*
		 * activecode = new JTextField(); activecode.setBounds(130, 27, 48, 22);
		 * sidePanel.add(activecode); activecode.setColumns(10);
		 */
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, new Color(255, 0, 0)));
		panel_1.setBounds(3, 128, 283, 56);
		mainPanel.add(panel_1);
		panel_1.setLayout(null);

		rolecode = new JTextField();
		rolecode.setFont(new Font("Tahoma", Font.BOLD, 12));
		rolecode.setBounds(127, 4, 49, 22);
		panel_1.add(rolecode);
		rolecode.setColumns(10);
		ActionListener rl = new Rolelsnr();
		rolecode.addActionListener(rl);

		JLabel lblAssignRole = new JLabel("Assign Role");
		lblAssignRole.setBounds(33, 7, 82, 16);
		panel_1.add(lblAssignRole);

		JLabel lblRoleDescription = new JLabel("Role Description");
		lblRoleDescription.setBounds(12, 30, 103, 16);
		panel_1.add(lblRoleDescription);

		roledescription = new JTextField();
		roledescription.setFont(new Font("Tahoma", Font.BOLD, 12));
		roledescription.setBounds(127, 27, 116, 22);
		panel_1.add(roledescription);
		roledescription.setColumns(10);

		JLabel lblActive = new JLabel("Active");
		lblActive.setBounds(205, 7, 39, 16);
		panel_1.add(lblActive);

		activatecode1 = new JComboBox();
		activatecode1.setBounds(244, 4, 39, 22);
		panel_1.add(activatecode1);
		activatecode1.setModel(new DefaultComboBoxModel(new String[] { "Y", "N" }));
		// mainPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new
		// Component[]{lblUserCode, createDate, userCode, lblCreatedOn,
		// lblUpdatedOn, updateDate, name, lblName, lblPassword, password,
		// sidePanel}));
		String Sql2 = "call getAllRole()";
		String SQL1 = "Call master.getAllDepartment()";

		ActionListener lsnr2 = new lsnr();

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 0, 559, 209);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(0, 186, 561, 47);
		internalFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setBounds(239, 11, 97, 30);
		panel_2.add(btnClose);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBounds(64, 11, 78, 30);
		panel_2.add(btnSave);
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(Color.CYAN);

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(143, 11, 97, 30);
		panel_2.add(btnUpdate);
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBackground(Color.CYAN);
		btnUpdate.setEnabled(false);
		// Dpanel.add(jsp);

		btnChangePassword = new JButton("Change Password");
		btnChangePassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChangePassword.setBounds(372, 11, 177, 30);
		panel_2.add(btnChangePassword);
		btnChangePassword.setBackground(Color.CYAN);
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePassword window;
				try {
					window = new ChangePassword();
					window.ChangePasswordFrame.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnCancel = new JButton("Cancel Record");
		btnCancel.setBounds(240, 11, 131, 30);
		// panel_2.add(btnCancel);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.CYAN);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					clearRecord();
				} catch (Exception e) {
					e.printStackTrace();
				}
				userCode.setText(null);
				try {
					enabledFields();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					try {
						UpdateUser();
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					enabledFields();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnSave.addActionListener(lsnr2);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateUserFrame.dispose();
			}
		});
		// CreateUserFrame.setFocusTraversalPolicy(new FocusTraversalOnArray(new
		// Component[]{CreateUserFrame.getContentPane(),
		// internalFrame.getContentPane(), lblUserCode, createDate, lblPassword,
		// updateDate, sidePanel, internalFrame, lblCreatedOn, lblUpdatedOn,
		// name, lblName, password, btnSave, btnCancel, btnUpdate, userCode,
		// mainPanel}));
		internalFrame.setVisible(true);
		decorateComp();
		setDateForNewRecord();
		checkUser();
	}

	private void checkUser() throws Throwable {
		String vuser = new gnConfig().getUserCode();
		String vcomp = new gnConfig().getCompanyCode();
		if (vcomp != "9999") {
			companycode.setText(new gnConfig().getCompanyCode());
			companyname.setText(new gnConfig().getCompany());
			storecode.setText(new gnConfig().getStoreID());
			storename.setText(new gnConfig().getStorename(storecode.getText()));
			storename.setEnabled(true);
			companyname.setEnabled(true);
		}
		switch (vcomp) {
		case "9999":
			storename.setEnabled(true);
			companyname.setEnabled(true);

			break;
		}
	}

	class compLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String vname = companyname.getText();
			vname = "%" + vname + "%";
			// String SQL = "call tb_getAllcompany('"+vname+"')" ;
			String vtype = "Company";
			String SQL = "call Tb_getAllCompnayData()";
			try {
				new gnTable().RemoveTableRows(model);
				table = new gnTableModel().Tablemodel(table, model, SQL, Com, 8, "N", "Y", vtype);
				showTable(table, Com, vtype);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class storeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String vcomp = companycode.getText();
			String vtype = "Store";
			String SQL = "call  Tb_getallSite(" + vcomp + ")";
			new gnTable().RemoveTableRows(model);
			try {
				table = new gnTableModel().Tablemodel(table, model, SQL, RolCol, 2, "N", "Y", vtype);
				showTable(table, RolCol, vtype);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	
	public void showTable(JTable table, String[] Col, String vtype) throws Throwable {
		JViewport prt = new JViewport();
		prt.add(table, Col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification);
		new General().msgsearch(jsp, table, "Select Data For" + " " + vtype, 700, 200);
	}// End Show Table

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 0);
			String col1 = (String) table.getValueAt(row, 1);
			table.addNotify();
			new General().msgDispose();
			// btnSave.setEnabled(false);
			try {
				showtData(value, col1, row);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	public void showtData(String value, String col1, int row) throws Exception {
		switch (value) {

		case "Company":
			companycode.setText(table.getValueAt(row, 1).toString());
			companyname.setText(table.getValueAt(row, 2).toString());
			segmentcode = (table.getValueAt(row, 5).toString());
			segmentname = (table.getValueAt(row, 6).toString());
			verticlecode = (table.getValueAt(row, 7).toString());
			verticlename = (table.getValueAt(row, 8).toString());
			break;
		case "Store":
			storecode.setText(table.getValueAt(row, 1).toString());
			storename.setText(table.getValueAt(row, 2).toString());
			break;

		case "User":
 			
			userCode.setText((String) table.getValueAt(row, 1));
			String ucode = userCode.getText();

			if (!ucode.toUpperCase().equals("ADMIN"))
			{
			String ss = "call Tbl_getUserData('" + ucode + "'  , '" + vcomp + "' , '" + vstore + "')";
			// clearRecord() ;
 			ResultSet rs1 = this.getSPResult(ss);
			rs1.first();
			userCode.setText(rs1.getString(1));
			name.setText(rs1.getString(2).trim());
			password.setText(rs1.getString(3));
 			rolecode.setText(rs1.getString(4));
			roledescription.setText(rs1.getString(5));
 			createDate.setText(rs1.getString(7));
			updateDate.setText(rs1.getString(8));
 			String vactive = rs1.getString(6);

 			switch (vactive) {
			case "Y":
				activatecode1.setSelectedItem("Y");
				activatecode1.setBackground(Color.WHITE);

				break;
			case "N":
				activatecode1.setSelectedItem("N");
				activatecode1.setBackground(Color.red);
				break;
			}

			}  //If End 
			else
			{
				new General().msg("User Admin is System Admin You Can Not Change Info..");
				btnUpdate.setEnabled(false);
				return ;
			}
			
			break;
 			case "Role":
			int row1 = table.getSelectedRow();
			rolecode.setText(table.getValueAt(row, 1).toString());
			roledescription.setText(table.getValueAt(row, 2).toString());
			break;
		}

	}

	class Rolelsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String SQL = "call user_getAllRoles()";
			new gnTable().RemoveTableRows(model);
			model.setColumnIdentifiers(RolCol);
			try {
				String vtype = "Role";
				table = new gnTableModel().Tablemodel(table, model, SQL, RolCol, 2, "N", "Y", vtype);
				showTable(table, RolCol, vtype);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	class userlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
 			model.setColumnIdentifiers(Col);
			new gnTable().RemoveTableRows(model);

			//nitin
			String sql = "Call  Tb_getalluser('"+vcomp+"' , '"+vstore+"')";
			model.setColumnIdentifiers(Col);
			try {
				btnSave.setEnabled(false);
				btnUpdate.setEnabled(true);
				userCode.setEnabled(false);
				password.setEnabled(false);
				name.setEnabled(false);
				String vtype = "User";
				new gnTable().RemoveTableRows(model);
				table = new gnTableModel().Tablemodel(table, model, sql, Col, 5, "N", "Y", vtype);
				showTable(table, Col, vtype);
			} catch (ClassNotFoundException | SQLException e1) {
				new General().msg(e1.getLocalizedMessage());
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class lsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);

			if (i == 1001 && value == "Save") {
				try {
					String vcheck = checkforAdmin();
					if (vcheck == "Sucess") {
						String status = validateEntery();
						if (status == "Sucess") {
							getEnterDataForSave();
						}
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
			if (i == 1001) {
				try {
					// clearRecord() ;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (value != null) {
				}
			}
		}
	}

	public void decorateComp() throws Throwable {

		new gnApp().setFrameTitel(CreateUserFrame);
		new gnField().closeform(internalFrame, CreateUserFrame);

		new gnDecorate().DispField_Eatch(rolecode, 20);
		new gnDecorate().DispField_Eatch(roledescription, 10);
		new gnDecorate().DispField_Eatch(pwexpDate, 20);
		new gnDecorate().DispField_Eatch(userCode, 10);
		new gnDecorate().DispField_Eatch(name, 10);
		new gnDecorate().DispField_Eatch(password, 10);

		new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnClose, Color.BLUE, Color.WHITE);
		new gnDecorate().decorateBtn(btnChangePassword, Color.BLUE, Color.WHITE);
		new gnDecorate().decorateBtn(btnUpdate, Color.BLUE, Color.WHITE);
 		try {
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
 			switch (vcomp) {
			case "0":
				storename.setEnabled(true);
				companyname.setEnabled(true);
				break;
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setDateForNewRecord() throws Throwable {
		new General().setDate(createDate);
		new General().setDate(updateDate);
		String vpara = "803";
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();

		// new General().msg("comp "+vcomp+"Store "+vstore);
		int vvdays = 0;
		if (vstore != "0") {
			String SQL = " call CONF_getSpecificvalue('" + vpara + "'  , " + vstore + " , " + vcomp + ")";
			String vdays = new getConfigurationSetting().getSpecificConfiguration(vpara);
			vvdays = Integer.parseInt(vdays);
		}
		if (vstore == "0") {
			vvdays = 30;
		}
		String vdate = createDate.getText();
		String cvdate = new gnConfig().date_ConverttoDBforamt(vdate);
		String vduedate = (new gnConfig().get_duedate(cvdate, vvdays));
		pwexpDate.setText(vduedate);

	}

	public void clearRecord() throws Exception {
		enabledFields();
		userCode.setText(null);
		name.setText(null);
		password.setText(null);
		// pwexpDate.setText(null);
		// createDate.setText(null);
		// updateDate.setText(null);
		rolecode.setText(null);
		roledescription.setText(null);
		activatecode1.setSelectedIndex(0);
		// setDateForNewRecord();
	}

	public void disableFields() {
		btnSave.setEnabled(false);
		name.setEnabled(false);
		password.setEnabled(false);
		createDate.setEnabled(false);
		updateDate.setEnabled(false);
		pwexpDate.setEnabled(false);
	}

	public void enabledFields() throws Exception { // clearRecord();
		btnSave.setEnabled(true);
		name.setEnabled(true);
		password.setEnabled(true);
		createDate.setEnabled(true);
		updateDate.setEnabled(true);
		pwexpDate.setEnabled(true);
	}

	private String checkforAdmin() {
		String status = "Sucess";
		vcode = userCode.getText();
		switch (vcode.toUpperCase()) {
		case "ADMIN":
			status = "Fail";
			new General().msg("Admin User Is Already Created...Please Change User Code");
		}

		return status;
	}

	private String validateEntery() throws ClassNotFoundException, SQLException, IOException {
		String status = "Sucess";
		vcode = userCode.getText();
		vname = name.getText().trim();
		vpwd = new General().convertPassword(password.getText());
		String vpwd1 = password.getText();
		vrole = rolecode.getText();
		vrolename = roledescription.getText();

		if (vcode.length() == 0) {
			new General().msg("Enter User code");
			status = "Fail";
		}

		if (vcode.length() > 8) {
			new General().msg(" User Code Lenght Allow is 8 Chars, Change User Code");

			status = "Fail";
		}

		if (vname.length() == 0) {
			new General().msg("Enter User Name");
			status = "Fail";
		}

		if (vpwd.length() == 0) {
			new General().msg("Enter User Password ");
			status = "Fail";
		}

		if (vpwd1.length() > 8) {
			new General().msg(" Password Lenght Allow is 8 Chars, Change Password");
			status = "Fail";
		}

		if (vrole.length() == 0) {
			new General().msg("Select User Role");
			status = "Fail";
		}

		if (vrolename.length() == 0) {
			new General().msg("Select User Role");
			status = "Fail";
		}
		return status;
	}

	public void getEnterDataForSave() throws Throwable {
		vcode = userCode.getText();
		vname = name.getText().trim();
		vpwd = new General().convertPassword(password.getText());
		vcrdate = new gnConfig().date_ConverttoDBforamt(createDate.getText());
		vupddate = new gnConfig().date_ConverttoDBforamt(updateDate.getText());
		vpwdexpdate = new gnConfig().date_ConverttoDBforamt(pwexpDate.getText());
		vrole = rolecode.getText();
		vrolename = roledescription.getText();
		segmentcode = "1";
		segmentname = "Retail";
		verticlecode = new getConfigurationSetting().getVerticleCode(companycode.getText(), storecode.getText());
		verticlename = new getConfigurationSetting().getVerticleName(companycode.getText(), storecode.getText());
		prepareToinsert();
	}

	public String prepareToinsert() throws Throwable {
		// new General().msg(" Inserting User Record to DB");
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String user = "INSERT INTO  user_master  (ucode, name ,password,  "
				+ "pw_expiry_date , active_status , createdate , "
				+ "updateDate, assignRole,  role_name, company_code, company_name,"
				+ " store_code, store_name, segmentcode, segmentname, verticlecode, verticlename)"
				+ "values(?,?,?,?,?,?,?,?,?, ? ,?,?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(user);
			prst.setString(1, vcode);
			prst.setString(2, vname.trim().toUpperCase());
			prst.setString(3, vpwd);
			prst.setString(4, vpwdexpdate);
			prst.setString(5, activatecode1.getSelectedItem().toString());
			prst.setString(6, vcrdate);
			prst.setString(7, vupddate);
			prst.setString(8, vrole);
			prst.setString(9, vrolename);
			prst.setString(10, companycode.getText());
			prst.setString(11, companyname.getText());
			prst.setString(12, storecode.getText());
			prst.setString(13, storename.getText());
			prst.setString(14, segmentcode);
			prst.setString(15, segmentname);
			prst.setString(16, verticlecode);
			prst.setString(17, verticlename);
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con.commit();
				// new General().msg("Data Saved Sucessfully");
			}
			prst.executeBatch();
			con.commit();
			new General().msg("Data Saved Sucessfully");
			clearRecord();
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return status;
	}

	/// Update
	public String UpdateUser() throws Throwable {
		// new General().msg(" Updating User Data ..");
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String user = "update user_master  set   " + " active_status = ?,  "
				+ "updateDate = ?, assignRole = ?,  role_name = ?  where ucode = ? ";

		try {
			prst = con.prepareStatement(user);
			prst.setString(1, activatecode1.getSelectedItem().toString());
			prst.setString(2, new gnConfig().date_ConverttoDBforamt(new General().getDate()));
			prst.setString(3, rolecode.getText());
			prst.setString(4, roledescription.getText());
			prst.setString(5, userCode.getText());
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con.commit();
				// new General().msg("Data Saved Sucessfully");
			}
			prst.executeBatch();
			con.commit();
			new General().msg("Data Updated Sucessfully");
			clearRecord();
			enabledFields();
			btnUpdate.setEnabled(false);
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return status;
	}
}// last

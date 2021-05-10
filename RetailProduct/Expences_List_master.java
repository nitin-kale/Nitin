package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class Expences_List_master extends getResultSet {

	JFrame expenceFrame;
	private JTextField expcode;
	private JTextField expname;
	private JTextField grpcode;
	private JTextField subgrpcode;
	private JTextField grpname;
	private JTextField subgrpname;
	private String vglcode;
	private String vglname;
	String vcomp;
	String vstore;
	String vfinyear;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnAdd;
	private JButton Msg;
	private JButton btnView;
	private JInternalFrame internalFrame;
	private JTextField taxcode;

	///

	public DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable();
	public String add[] = { "Remove", "ExpCode", "Name", "GroupCode", "Grp. Name", "Sub.Grp.Code", "Sub Group Name",
			"Tax Code" };
	public String Col[] = { "Remove", "ExpCode", "Name", "GroupCode", "Grp. Name", "Sub.Grp.Code", "Sub Group Name" };

	private JScrollPane jsp;

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public JViewport prt1 = new JViewport();
	public JViewport prt2 = new JViewport();
	public JScrollPane sjsp;

	public DefaultTableModel vmodel = new DefaultTableModel();
	public JTable vtable = new JTable();
	public JScrollPane vjsp;

	///

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Expences_List_master window = new Expences_List_master();
					window.expenceFrame.setVisible(true);
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
	public Expences_List_master() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		expenceFrame = new JFrame();
		expenceFrame.setTitle("Business Application - Stand Alone Application");
		expenceFrame.setAlwaysOnTop(true);
		expenceFrame.setBounds(250, 100, 850, 600);
		expenceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		expenceFrame.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 850, 600);
		expenceFrame.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		internalFrame = new JInternalFrame(" ");
		internalFrame.setBounds(0, 0, 850, 600);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(2, 0, 3, 0));
		panel.setBounds(0, 0, 822, 143);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(0, 0, 822, 143);
		panel.add(panel_2);
		panel_2.setLayout(null);
		ActionListener sub = new subGroup();

		btnAdd = new JButton("Add Record");
		btnAdd.setMnemonic('A');
		btnAdd.setBounds(647, 92, 112, 25);
		panel_2.add(btnAdd);

		JLabel lblExpenceCode = new JLabel("Gl Name");
		lblExpenceCode.setFont(new Font("Arial", Font.BOLD, 13));
		lblExpenceCode.setBounds(-14, 6, 91, 16);
		panel_2.add(lblExpenceCode);
		lblExpenceCode.setHorizontalAlignment(SwingConstants.RIGHT);

		expcode = new JTextField();
		expcode.setBounds(85, 3, 80, 22);
		panel_2.add(expcode);
		expcode.setEditable(false);
		expcode.setColumns(10);

		expname = new JTextField();
		expname.setBounds(166, 3, 419, 22);
		panel_2.add(expname);
		expname.setToolTipText("Enter Name of Ledger ");
		expname.setColumns(10);

		JLabel lblNewLabel = new JLabel("Under Head");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(12, 35, 100, 16);
		panel_2.add(lblNewLabel);

		JLabel lblAccountGroup = new JLabel("Account Group ");
		lblAccountGroup.setFont(new Font("Arial", Font.BOLD, 13));
		lblAccountGroup.setBounds(22, 58, 118, 16);
		panel_2.add(lblAccountGroup);
		lblAccountGroup.setHorizontalAlignment(SwingConstants.RIGHT);

		grpcode = new JTextField();
		grpcode.setBounds(144, 55, 80, 22);
		panel_2.add(grpcode);
		grpcode.setColumns(10);

		grpname = new JTextField();
		grpname.setFont(new Font("Calibri", Font.BOLD, 13));
		grpname.setBounds(230, 55, 231, 22);
		panel_2.add(grpname);
		grpname.setColumns(10);

		JLabel lblAccountSubgroup = new JLabel("Account SubGroup");
		lblAccountSubgroup.setFont(new Font("Arial", Font.BOLD, 13));
		lblAccountSubgroup.setBounds(12, 87, 125, 16);
		panel_2.add(lblAccountSubgroup);
		lblAccountSubgroup.setHorizontalAlignment(SwingConstants.RIGHT);

		subgrpcode = new JTextField();
		subgrpcode.setText("0");
		subgrpcode.setBounds(143, 82, 81, 22);
		panel_2.add(subgrpcode);
		subgrpcode.setToolTipText("Press Enter Key To Get Help");
		subgrpcode.setColumns(10);

		subgrpname = new JTextField();
		subgrpname.setText(" ");
		subgrpname.setBounds(230, 82, 231, 22);
		panel_2.add(subgrpname);
		subgrpname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("||");
		lblNewLabel_1.setBounds(85, 38, 56, 16);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tax Code");
		lblNewLabel_2.setBounds(587, 6, 56, 16);
		panel_2.add(lblNewLabel_2);

		taxcode = new JTextField();
		taxcode.setToolTipText("Tax code is applicable for all expense items and assets");
		taxcode.setText("0");
		taxcode.setBounds(643, 3, 116, 22);
		panel_2.add(taxcode);
		taxcode.setColumns(10);
		subgrpcode.addActionListener(sub);
		ActionListener ad = new Add();
		btnAdd.addActionListener(ad);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(0, 169, 822, 356);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 0, 822, 356);
		panel_1.add(jsp);

		vjsp = new JScrollPane();
		vjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		vjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		vjsp.setBounds(0, 0, 822, 356);

		sjsp = new JScrollPane();
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(0, 0, 822, 356);

		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.CYAN);
		prt1.add(stable, Col);
		prt1.setVisible(true);
		sjsp.setViewport(prt1);

		btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(540, 143, 97, 25);
		internalFrame.getContentPane().add(btnSave);
		ActionListener sav = new Save();
		btnSave.addActionListener(sav);

		btnCancel = new JButton("Cencel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				expenceFrame.dispose();
			}
		});
		btnCancel.setMnemonic('C');
		btnCancel.setBounds(732, 143, 90, 25);
		internalFrame.getContentPane().add(btnCancel);

		Msg = new JButton("...");
		Msg.setEnabled(false);
		Msg.setBounds(0, 143, 542, 25);
		internalFrame.getContentPane().add(Msg);

		btnView = new JButton("View");
		btnView.setMnemonic('V');
		btnView.setBounds(637, 143, 97, 25);
		ActionListener vie = new View();
		btnView.addActionListener(vie);

		internalFrame.getContentPane().add(btnView);
		internalFrame.setVisible(true);
		ActionListener grp = new GroupLsnr();
		grpname.addActionListener(grp);

		decorate();
	}

	private void decorate() throws Throwable {
		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		new gnApp().setFrameTitel(expenceFrame);
		new gnField().closeform(internalFrame, expenceFrame);
		new gnDecorate().DispField_Eatch(grpname, 20);
		new gnDecorate().DispField_Eatch(subgrpname, 20);
		new gnDecorate().DispField_Eatch(expname, 20);
		new gnDecorate().DispField_Eatch(subgrpcode, 15);
		new gnDecorate().DispField_Eatch(grpcode, 15);
		new gnDecorate().DispField_Eatch(expcode, 25);
		new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnCancel, Color.BLUE, Color.WHITE);
		new gnDecorate().decorateBtn(btnView, Color.BLUE, Color.WHITE);
		new gnApp().setFrameTitel(expenceFrame);
		new gnApp().setCompanyTitle(internalFrame);
		subgrpcode.setText("0");
		subgrpname.setText("-");

	}

	private String viewInfo() {
		String Status = "Sucess";
		int row = table.getRowCount();
		if (row > 0) {
			new General().msg("Save Table Data First ");
			Status = "Fail";
		}
		return Status;
	}

	private void showView(String vgrpcode) throws ClassNotFoundException, SQLException {
		vmodel.setColumnIdentifiers(add);
		// String SQL = "call expences_getData()";
		String vtype = "GL";
		String vsearchString = "";
		vsearchString = "%" + vsearchString + "%";
		String add[] = { "Gl", "Name", "Op.bal", "Op.Drcr", "Group", "Name" };
		vmodel.setColumnIdentifiers(add);
		String SQL = "call Account_getSEarchDetails('" + vtype + "' , " + vcomp + "  ,  " + vstore + "    , '"
				+ vsearchString + "'  ,   '" + vfinyear + "' )";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vmodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(7), rs.getString(8) });
			vtable.setModel(vmodel);
			vtable.setEnabled(false);
			JViewport prt5 = new JViewport();
			prt5.add(vtable, add);
			prt5.setVisible(true);
			jsp.setViewport(prt5);
			jsp.setVisible(true);
			new gnTable().setTableBasics(vtable);
		}
	}

	class View implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String Status = viewInfo();
			if (Status == "Sucess") {
				try {
					new gnTable().RemoveTableRows(vmodel);
				
					String vgrpcode = grpcode.getText() ; 
					showView(vgrpcode); //nitinhere
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getLocalizedMessage());
				}
			}
		}
	}

	class Save implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			Msg.setText("Generating Numbers....");
			try {
				String check = check();
				if (check == "Sucess") {
					String ok = generateSeq();
					if (ok == "OK") {
						prepareToInsertDf();
						prepareToInsert();
					}
				}
			} catch (ClassNotFoundException | SQLException e1) {
				new General().msg(e1.getLocalizedMessage());
			} catch (Throwable e1) {
				new General().msg(e1.getLocalizedMessage());
			}
		}
	}

	private String check() {
		String check = "Sucess";
		int row = table.getRowCount();
		if (row != 0) {
			check = "Sucess";
		} else {
			new General().msg("No Record Found To Save Data");
			check = "Fail";
		}
		return check;
	}

	class Add implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String[] Col = { "Type", "Sub Group Code", "Name" };
			String action = "Fail";
			String Status = validateRecord();
			if (Status == "Sucess") {
				JViewport prt = new JViewport();
				prt.setBackground(Color.CYAN);
				prt.add(table, Col);
				prt.setVisible(true);
				jsp.setViewport(prt);
				addRecord();
			}
		}
	}

	public String validateRecord() {
		String Status = "Sucess";
		int d1 = expname.getText().length();
		if (d1 == 0) {
			new General().msg("Enter Legder  Name..!!");
			expname.grabFocus();
			Status = "Fail";
		}
		int d2 = subgrpname.getText().length();
		if (d2 == 0) {
			subgrpname.setText("-");
			Status = "Sucess";
			subgrpcode.setText("0");
		}
		int d3 = grpname.getText().length();
		if (d3 == 0) {
			new General().msg("Select Account Group For Ledger...!!");
			;
			// subgrpcode.grabFocus();
			grpname.grabFocus();
			Status = "Fail";
		}
		return Status;
	}

	private void addRecord() {

		model.setColumnIdentifiers(add);
		model.addRow(new Object[] { " ", " ", expname.getText(), grpcode.getText(), grpname.getText(),
				subgrpcode.getText(), subgrpname.getText(), taxcode.getText() });
		table.setModel(model);
		new General().removeRow(model, table);

		subgrpcode.setText(null);
		subgrpname.setText("");
		expname.setText(null);
		Msg.setText("...");

	}

	class GroupLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String[] Col = { "Type", "Account Group Code", "Account Name" };
			String action = "Fail";
			String vgrp = grpname.getText();
			vgrp = "%" + vgrp + "%";
			String vtype = "Group";
			// NKK
			// String SQL = "call Account_getgroup("+vcomp+" , "+vstore+",
			// '"+vgrp+"' , '"+vfinyear+"')" ;
			String SQL = "call  Account_getSEarchDetails( '" + vtype + "',  " + vcomp + " , " + vstore + ",     '"
					+ vgrp + "'   , '" + vfinyear + "')";
			try {
				showGroup(SQL, vtype, Col);
				Msg.setText("Press Add Record Button to Add Record to Table");
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void showGroup(String SQL, String vtype, String[] Col) throws ClassNotFoundException, SQLException {
		// new General().msg(SQL);
		new gnTable().RemoveTableRows(smodel);
		smodel.setColumnIdentifiers(Col);
		stable = new gnTableModel().Tablemodel2(stable, smodel, SQL, Col, 2, "N", "Y", vtype);
		Selectrow();
	}

	public void Selectrow() {
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = stable.getSelectedRow();
					String value = (String) stable.getValueAt(row, 0);
					grpcode.setText(stable.getValueAt(row, 1).toString());
					grpname.setText(stable.getValueAt(row, 2).toString());
					new General().msgDispose();
					// dispalyinfo(value, row) ;
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		// stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Data ", 450, 400);
	}

	public CellEditorListener ChangeNotification7 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = stable.getSelectedRow();
			String value = (String) stable.getValueAt(row, 0);
			grpcode.setText(stable.getValueAt(row, 1).toString());
			grpname.setText(stable.getValueAt(row, 2).toString());
			new General().msgDispose();
		}
	};

	class subGroup implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String[] Col = { "Type", "Sub Group Code", "Account Name" };
			String action = "Fail";
			String vgrp = grpcode.getText();
			String vtype = "SubGroup";
			String SQL = "call  Account_getSubgroup(" + vgrp + ")";
			try {
				show(SQL, vtype, Col);
				Msg.setText("Press Add Record Button to Add Record to Table");
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void show(String SQL, String vtype, String[] Col) throws ClassNotFoundException, SQLException {
		// new General().msg(SQL);
		new gnTable().RemoveTableRows(smodel);
		smodel.setColumnIdentifiers(Col);
		stable = new gnTableModel().Tablemodel2(stable, smodel, SQL, Col, 2, "N", "Y", vtype);
		selectsubgrouprow();
	}

	public void selectsubgrouprow() {
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = stable.getSelectedRow();
					String value = (String) stable.getValueAt(row, 0);
					subgrpcode.setText(stable.getValueAt(row, 1).toString());
					subgrpname.setText(stable.getValueAt(row, 2).toString());
					new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Data ", 450, 400);
	}

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = stable.getSelectedRow();
			String value = (String) stable.getValueAt(row, 0);
			subgrpcode.setText(stable.getValueAt(row, 1).toString());
			subgrpname.setText(stable.getValueAt(row, 2).toString());
			new General().msgDispose();
		}
	};

	private String generateSeq() throws Throwable {
		String ok = "OK";
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			String Seqno = new gnSeq().getSeqno("903", "MS");
			table.setValueAt(Seqno, i, 1);
			new gnSeq().updateSeqno("903", "MS");
			Msg.setText("Saving Data ....Wait...");
		}
		return ok;
	}

	private void prepareToInsertDf() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String grndetail = "Insert into  ms_accounts_gl_df(glcode, glname , " + "acc_group ,groupname , acc_subgroup ,"
				+ " subgroupname, drcrtype, taxcode , company_code , Site_code)" + "values(?,?,?,?,?,?,?,? , ?,?)";
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				String vgrp = table.getValueAt(k, 3).toString();
				prst = con.prepareStatement(grndetail);
				prst.setInt(1, Integer.parseInt(table.getValueAt(k, 1).toString().trim()));
				prst.setString(2, table.getValueAt(k, 2).toString().trim());
				prst.setInt(3, Integer.parseInt(table.getValueAt(k, 3).toString().trim()));
				prst.setString(4, table.getValueAt(k, 4).toString().trim());
				prst.setInt(5, Integer.parseInt(table.getValueAt(k, 5).toString()));
				prst.setString(6, table.getValueAt(k, 6).toString().trim());
				prst.setString(7, new gnAccounting().getDrCrOFgroup(vgrp));
				prst.setString(8, table.getValueAt(k, 7).toString().trim());
				prst.setString(9, vcomp);
				prst.setString(10, vstore);

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
			}
			if (con != null) {
				con.close();
			}
		}
	}

	private void prepareToInsert() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String grndetail = "Insert into  ms_accounts_gl(glcode, glname , " + "acc_group ,groupname , acc_subgroup ,"
				+ " subgroupname, drcrtype, company_code, site_code , finyear  )" + "values(?,?,?,?,?,?,?,?,?,?)";
		// public String add[] = { "Remove", "ExpCode" , "Name" , "GroupCode"
		// ,"Grp. Name", "Sub.Grp.Code", "Sub Group Name" };

		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				String vgrp = table.getValueAt(k, 3).toString();
				prst = con.prepareStatement(grndetail);
				prst.setInt(1, Integer.parseInt(table.getValueAt(k, 1).toString()));
				prst.setString(2, table.getValueAt(k, 2).toString());
				prst.setInt(3, Integer.parseInt(table.getValueAt(k, 3).toString()));
				prst.setString(4, table.getValueAt(k, 4).toString());
				prst.setInt(5, Integer.parseInt(table.getValueAt(k, 5).toString()));
				prst.setString(6, table.getValueAt(k, 6).toString());
				prst.setString(7, new gnAccounting().getDrCrOFgroup(vgrp));
				prst.setString(8, vcomp);
				prst.setString(9, vstore);
				prst.setString(10, vfinyear);
				// prst.setString(11, table.getValueAt(k, 7).toString());
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

				String vgroupcode = grpcode.getText().trim();
				switch (vgroupcode) {
				case "12":
					insert_ifBank();
				default:
					new gnTable().RemoveTableRows(model);
					subgrpcode.setText("0");
					subgrpname.setText("-");
					grpcode.setText("");
					grpname.setText("");
					expname.setText(null);
					Msg.setText("...");
				}
			}
			if (con != null) {
				con.close();
			}
		}
	}

	void insert_ifBank() {
		String vgroupcode = grpcode.getText().trim();
		switch (vgroupcode) {
		case "12":
			try {
				new General().msg("Inserting Bank...");
				insertbankDetail();
			} catch (Throwable e) {
				new General().msg(e.getMessage());
			}
		}
	}

	public void insertbankDetail() throws Throwable {
		int row = table.getRowCount();
		prst = null;
		String status = "";
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String Status = "Fail";
		String pospayment = "Insert into  ms_bank_master( bank_code , " + "Bank_name, company_code, account_number) "
				+ "values(?,?,?,?)";
		try {
			for (int k = 0; k < row; k++) {
				prst = con.prepareStatement(pospayment);
				prst.setInt(1, Integer.parseInt(table.getValueAt(k, 1).toString()));
				prst.setString(2, table.getValueAt(k, 2).toString());
				prst.setString(3, new gnConfig().getCompanycode());
				prst.setString(4, "0");

				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				status = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					con.commit();
					status = "Sucess";
					new General().msg("Bank Record Updated Status ->Sucess");
				}
				prst.executeBatch(); // insert remaining records
				con.commit();
			}
		} catch (SQLException e) {
			new General().msg("Bank :" + e.getMessage());
			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
			}
			bankMaster window = new bankMaster();
			window.frmBusinessApplication.setVisible(true);

			new gnTable().RemoveTableRows(model);
			subgrpcode.setText("0");
			subgrpname.setText("-");
			grpcode.setText("");
			grpname.setText("");
			expname.setText(null);
			Msg.setText("...");
		}
	}
}// Last

package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jfree.util.Log;

import com.jidesoft.swing.ComboBoxSearchable;
import com.mysql.jdbc.Connection;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class CreateGeneralMaster extends getResultSet {

	JFrame masterFrame;
	private JTextField name;
	private JTextField code;
	private JScrollPane jsp;
	private String SaveStatus = "Sucess";
	String btnShowClickedl = "Y";
	String DBhdr;
	JButton btnnewmaster;
	JButton btnShowAll;
	Connection con1;
	JPanel panel_2;
	String newMaster = "N";

	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 2 || column == 3 || column == 4 ? false : true;
		}
	};;
	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2 || column == 3 || column == 4) {
				componentt.setBackground(Color.white);
				componentt.setForeground(Color.BLUE);

				componentt.setCursor(getCursor());
				// componentt.setFont(new Font("ARIAL", Font.PLAIN, 12));
			} else {
				componentt.setBackground(Color.white);
				componentt.setForeground(Color.BLUE);
				// componentt.setFont(new Font("Calibri", Font.BOLD, 15));
			}
			return componentt;
		}
	};

	JButton btnSave;
	JButton btnClose;
	JPanel panel;

	String Edit = "N";
	JComboBox MasterCombo;
	JComboBox SubCategoryCombo;
	private JTextField userDefineCode;

	String vcode;
	String vmastertable;
	String vuserDefinedCode;
	String vverticlecode;
	String vname;
	String vcategory = "General";
	String vsubcategory;
	private JTextField verticlename;
	private JTextField verticlecode;
	private JButton btnDel;
	private JButton btnAssigntoall;
	private JButton btnAssign;
	private JButton btnShow;
	private JButton btnUpdate;
	private JTextField mastername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateGeneralMaster window = new CreateGeneralMaster();
					window.masterFrame.setVisible(true);
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
	public CreateGeneralMaster() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		masterFrame = new JFrame();
		masterFrame.getContentPane().setBackground(Color.WHITE);
		masterFrame.setResizable(false);
		masterFrame.setAlwaysOnTop(true);
		//masterFrame.setBounds(100, 50, 972, 600);
		masterFrame.setBounds(1 , 100, 1350, 600);
		
		masterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		masterFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("  Create General Master Inforamtion");
		lblNewLabel.setBackground(new Color(0, 0, 102));
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(423, 0, 252, 25);
		masterFrame.getContentPane().add(lblNewLabel);

		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(204, 255, 255));
		panel.setBorder(new TitledBorder(null, "Enter Master Details", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(264, 28, 1047, 124);
		masterFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_2.setBounds(12, 23, 56, 16);
		panel.add(lblNewLabel_2);

		name = new JTextField();
		name.setToolTipText("Enter Master Information Here-Max Length 30 Char ");
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(12, 41, 285, 27);
		panel.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Master Code");
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_3.setBounds(474, 23, 123, 16);
		panel.add(lblNewLabel_3);

		code = new JTextField();
		code.setToolTipText("Auto System Generated Code");
		code.setEditable(false);
		code.setBounds(474, 41, 90, 27);
		panel.add(code);
		code.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("User Define Code");
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_5.setBounds(309, 23, 123, 16);
		panel.add(lblNewLabel_5);

		userDefineCode = new JTextField();
		userDefineCode.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		userDefineCode.setToolTipText("Enter User Defined Code Is Required Length is 8 Char");
		userDefineCode.setBounds(298, 41, 173, 27);
		panel.add(userDefineCode);
		userDefineCode.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Select Verticle");
		lblNewLabel_6.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_6.setBounds(12, 71, 144, 16);
		panel.add(lblNewLabel_6);

		verticlename = new JTextField();
		verticlename.setFont(new Font("Tahoma", Font.PLAIN, 14));
		verticlename.setText("All Verticle");
		verticlename.setBounds(12, 86, 256, 27);
		panel.add(verticlename);
		verticlename.setColumns(10);

		verticlecode = new JTextField();
		verticlecode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		verticlecode.setText("0");
		verticlecode.setBounds(268, 86, 31, 27);
		panel.add(verticlecode);
		verticlecode.setColumns(10);

		btnAssigntoall = new JButton("Assign To All");
		btnAssigntoall.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnAssigntoall.setBounds(308, 87, 163, 26);
		panel.add(btnAssigntoall);

		btnAssign = new JButton("AssignToRow");
		btnAssign.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnAssign.setBounds(472, 87, 144, 25);
		panel.add(btnAssign);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 23, 252, 532);
		masterFrame.getContentPane().add(panel_1);
		panel_1.setBorder(new MatteBorder(1, 1, 0, 6, (Color) new Color(0, 255, 204)));
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Select Master Type");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_1.setBounds(12, 217, 149, 16);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);

		MasterCombo = new JComboBox();
		MasterCombo.setFont(new Font("Tahoma", Font.BOLD, 13));
		// ComboBoxSearchable searchable = new ComboBoxSearchable(MasterCombo);
		AutoCompleteDecorator.decorate(MasterCombo);
		MasterCombo.setSelectedItem("");

		MasterCombo.setEditable(true);
		MasterCombo.setBackground(Color.WHITE);
		MasterCombo.setBounds(12, 235, 229, 30);
		panel_1.add(MasterCombo);
		MasterCombo.setMaximumRowCount(20);

		JLabel lblNewLabel_4 = new JLabel("Select Master Category");
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_4.setBounds(12, 152, 229, 16);
		panel_1.add(lblNewLabel_4);

		SubCategoryCombo = new JComboBox();
		SubCategoryCombo.setFont(new Font("Tahoma", Font.BOLD, 13));
		SubCategoryCombo.setMaximumRowCount(10);
		SubCategoryCombo.setBounds(12, 174, 229, 30);
		panel_1.add(SubCategoryCombo);

		panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 200, 0), new Color(0, 255, 0)),
						"Create New Master", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(24, 304, 196, 199);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		mastername = new JTextField();
		mastername.setBounds(12, 70, 161, 22);
		panel_2.add(mastername);
		mastername.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Master Name");
		lblNewLabel_7.setBounds(12, 53, 133, 16);
		panel_2.add(lblNewLabel_7);

		btnnewmaster = new JButton("Create New Master");
		btnnewmaster.setBounds(24, 278, 196, 25);
		panel_1.add(btnnewmaster);

		JLabel lblNewLabel_8 = new JLabel(" ");
		lblNewLabel_8.setBounds(0, 0, 241, 134);
		panel_1.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setIcon(new ImageIcon(CreateGeneralMaster.class.getResource("/RetailProduct/mymainlogo_5.png")));

		jsp = new JScrollPane();
		jsp.setBounds(251, 182, 1060, 372);
		masterFrame.getContentPane().add(jsp);

		btnSave = new JButton("Save");
		btnSave.setBounds(571, 155, 92, 25);
		masterFrame.getContentPane().add(btnSave);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setMnemonic('S');

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(857, 155, 97, 25);
		masterFrame.getContentPane().add(btnClose);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnShowAll = new JButton("Show All");
		btnShowAll.setMnemonic('A');
		btnShowAll.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnShowAll.setBounds(760, 155, 97, 25);
		masterFrame.getContentPane().add(btnShowAll);

		btnDel = new JButton("Delete");
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDel.setMnemonic('D');
		btnDel.setBounds(664, 155, 97, 25);
		masterFrame.getContentPane().add(btnDel);

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setMnemonic('U');
		btnUpdate.setBounds(487, 155, 85, 25);
		masterFrame.getContentPane().add(btnUpdate);

		btnShow = new JButton("Show");
		btnShow.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnShow.setBounds(408, 155, 78, 25);
		masterFrame.getContentPane().add(btnShow);
		btnShow.setMnemonic('W');

		ActionListener subcatlsnr = new SubcatLsnr();
		SubCategoryCombo.addActionListener(subcatlsnr);

		ActionListener btLsnr = new btnLsnr();

		ActionListener masLsnr = new masterLsnr();
		MasterCombo.addActionListener(masLsnr);

		btnClose.addActionListener(btLsnr);
		btnSave.addActionListener(btLsnr);
		btnShowAll.addActionListener(btLsnr);
		btnDel.addActionListener(btLsnr);
		btnAssigntoall.addActionListener(btLsnr);
		btnAssign.addActionListener(btLsnr);
		btnUpdate.addActionListener(btLsnr);
		btnnewmaster.addActionListener(btLsnr);

		ActionListener ver = new vertname();
		verticlename.addActionListener(ver);
		btnShow.addActionListener(btLsnr);
		decorate();

	}

	private void decorate() throws Throwable {

		masterFrame.setUndecorated(true);
		verticlename.setText(new gnHierarchy().getVerticleName());
		verticlecode.setText(new gnHierarchy().getVerticleCode());
		btnnewmaster.setVisible(false);
		panel_2.setVisible(false);
		btnDel.setVisible(false);
		btnShowAll.setVisible(false);
		/*
		 * panel_2.setVisible(false); btnAssign.setVisible(false);
		 * btnnewmaster.setVisible(false); btnShow.setVisible(false);
		 * btnAssigntoall.setVisible(false); btnDel.setVisible(false);
		 * 
		 * btnSave.setVisible(false); btnUpdate.setVisible(false);
		 * SubCategoryCombo.setVisible(false); MasterCombo.setVisible(false);
		 */

		String SQL1 = "call tbl_getAllMastersubCategory()";
		new gnComp().fillCombo(SQL1, SubCategoryCombo);

		String vuser = ucode.toUpperCase();
		// new General().msg(vuser);
		switch (vuser) {
		case "ADMIN":
			btnnewmaster.setVisible(true);
			panel_2.setVisible(true);
			btnDel.setVisible(true);
			btnShowAll.setVisible(false);
 		}
		new gnApp().setFrameTitel(masterFrame);
		new gnField().closeform(panel, masterFrame);

	}

	class vertname implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				new gnAdmin().setverticle(verticlecode, verticlename, verticlecode, verticlename);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class SubcatLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vname = SubCategoryCombo.getSelectedItem().toString();
			String SQL = "call tbl_getAllMasterData('" + vname + "')";
			try {
				MasterCombo.removeAllItems();
				new gnComp().fillCombo(SQL, MasterCombo);
				Log.info("Master Table Category Selected...");
			} catch (ClassNotFoundException | SQLException e) {
				new General().msg(e.getMessage());
			} finally {
			}
		}
	}

	class masterLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			 btnShow.doClick();
		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Create New Master") {
				newMaster = "Y";
				panel_2.setVisible(true);
			}

			if (value == "AssignToRow") {
				String vtype = "S";
				assignmentProcess(vtype);
			}

			if (value == "Assign To All") {
				String vtype = "ALL";
				assignmentProcess(vtype);
			}

			if (value == "Delete") {
				try {
					DelAction();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Show") {
				try {
					showMasterData();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Update") {
				try {
					updateAction();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Show All") {
				try {
					showAllMasterData();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Close") {
				masterFrame.dispose();
			}

			if (value == "Save") {
				try {
					generateNo();
				} catch (ClassNotFoundException | SQLException e2) {
					e2.printStackTrace();
					new General().msg(e2.getMessage());
				}
				String result;
				try {
					result = validate();
					if (result == "Sucess") {
						callSaveEvent();
					}
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (IOException e1) {
					new General().msg(e1.getMessage());
				}
			} // Save End Here
		}
	}

	private String validate() throws ClassNotFoundException, SQLException {
		getData();

		if (mastername.getText().length() == 0) {
			SaveStatus = "Fail";
			new General().msg("Master Name Is Empty...Please Press Enter Or Press Show Button");
		}

		if (name.getText().length() == 0) {
			SaveStatus = "Fail";
			new General().msg("Please Enter Name...");
			name.grabFocus();
		}

		if (code.getText().length() == 0) {
			new General().msg("Please Enter Code..");
			code.grabFocus();
			SaveStatus = "Fail";
		}

		if (vverticlecode.length() == 0) {
			new General().msg("Please Select Verticle Info..");
			verticlename.grabFocus();
			SaveStatus = "Fail";
		}

		new General().msg(SaveStatus);
		return SaveStatus;
	}

	private void getData() throws ClassNotFoundException, SQLException {
		generateNo();
		vcode = code.getText();
		vuserDefinedCode = userDefineCode.getText();
		vname = name.getText();
		vsubcategory = SubCategoryCombo.getSelectedItem().toString();
		// vmastertable = MasterCombo.getSelectedItem().toString() ;
		vmastertable = mastername.getText().trim();
		vverticlecode = verticlecode.getText();

	}

	private void generateNo() throws ClassNotFoundException, SQLException {
		// String vname = MasterCombo.getSelectedItem().toString();
		String vname = mastername.getText().trim();
		String SQL = "Select coalesce(max(Mas_line_seq),0) from master_table where master_name = '" + vname + "'  ";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			int vno = Integer.parseInt(rs.getString(1));
			vno = vno + 1;
			code.setText(Integer.toString(vno));
			if (userDefineCode.getText().length() == 0) {
				userDefineCode.setText(Integer.toString(vno));
			}
		}
	}

	private void callSaveEvent() throws SQLException, ClassNotFoundException, IOException {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con1 = (Connection) this.getConnection();
		con1.setAutoCommit(false);
		String SQL = "Insert into master_table( Category , sub_Category, Master_name, code, Description,  Mas_line_seq , "
				+ " ShowAllow, Active , newEntryAllow , verticle)" + " values(?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con1.prepareStatement(SQL);
			prst.setString(1, vcategory);
			prst.setString(2, vsubcategory);
			prst.setString(3, vmastertable);
			prst.setString(4, vuserDefinedCode);
			prst.setString(5, vname);
			prst.setString(6, vcode);
			prst.setString(7, "Y");
			prst.setString(8, "Y");
			prst.setString(9, "Y");
			prst.setString(10, verticlecode.getText());
			prst.addBatch();
			// new General().msg("PRST"+" "+prst);
			TotalRecordinsert = TotalRecordinsert + 1;
			DBhdr = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBhdr = "Sucess";
		} catch (SQLException e) {
			new General().msg("Master - Table Info Saving Issue " + e.getMessage());
			con1.rollback();
			DBhdr = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") {
				con1.commit();
				con1.close();
				reset();
				new General().msg("Data Inserted Sucessfully");
			}
		}
	}

	private void reset() {
		name.setText(null);
		code.setText(null);
		userDefineCode.setText(null);
		verticlename.setText(null);
		new gnTable().RemoveTableRows(model);

	}

	private void showAllMasterData() throws ClassNotFoundException, SQLException {
		String Col1[] = { "Category", "Master", "Code", "Description", "Seq", "Active", "Verticle" };
		model.setColumnIdentifiers(Col1);
		new gnTable().RemoveTableRows(model);
		String vmastername = "%%";
		String SQL = "call master_getAllMasterData('" + vmastername + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7) });
		}
		table.setModel(model);
		new gnTable().setTableBasics(table);
		table.setGridColor(Color.GREEN);
		new gnTable().setTableColWidth(table, 1, 50);
		table.setRowHeight(25);
		JViewport prt = new JViewport();
		// prt.setBackground(Color.CYAN);
		prt.add(table, Col1);
		prt.setVisible(true);
		jsp.setViewport(prt);
		new gnFontSetting().setMyFont(table, "F2", 16);

	}

	private void showMasterData() throws ClassNotFoundException, SQLException {

		String vmasname = MasterCombo.getSelectedItem().toString();
		mastername.setText(vmasname);
		String vmastername = mastername.getText();
		String vverticle = verticlecode.getText();
		String Col1[] = { "Category", "Master", "Code", "Description", "Seq", "Active", "Verticle" };
		model.setColumnIdentifiers(Col1);
		new gnTable().RemoveTableRows(model);
		// String SQL = "call master_getAllMasterData('"+vmastername+"')" ;
		String SQL = "call master_getAllMasterDataforVerticle('" + vmastername + "', " + vverticle + ")";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7) });
		}
		table.setModel(model);
		new gnTable().setTableBasics(table);
		table.setGridColor(Color.GREEN);
		new gnTable().setTableColWidth(table, 1, 50);
		table.setRowHeight(25);
		JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(table, Col1);
		prt.setVisible(true);
		jsp.setViewport(prt);
		new gnFontSetting().setMyFont(table, "F2", 14);
	}

	private void DelAction() throws SQLException, ClassNotFoundException {
		int row = table.getSelectedRow();

		String vmastername = table.getValueAt(row, 1).toString();
		String vcode = table.getValueAt(row, 2).toString();
		String SQL = "delete from master_table where master_name = '" + vmastername + "'  and  code = '" + vcode
				+ "'  ";
		this.getResult(SQL);
		showAllMasterData();
	}

	private void assignmentProcess(String vtype) {
		String applyValue = " ";
		int Col = 0;
		int Row = 0;
		switch (vtype) {
		case "ALL":
			applyValue = verticlecode.getText();
			Col = 6;
			new gnTable().AssignToAll(table, Col, applyValue);
			table.repaint();
			break;
		case "S":
			applyValue = verticlecode.getText();
			Col = 6;
			Row = table.getSelectedRow();
			new gnTable().AssignToSelectdRow(table, Row, Col, applyValue);
			table.repaint();
			break;
		}
	}

	private void updateAction() throws SQLException {
		String vverticle = "";
		String mastername = "";
		String vActive = "";
		String vmascode = "";
		int cnt = table.getRowCount();
		try {
			for (int i = 0; i <= cnt; i++) {
				// new General().Quickmsg("record Processing :"+ " "+ i);
				mastername = table.getValueAt(i, 1).toString();
				vmascode = table.getValueAt(i, 2).toString();
				vverticle = table.getValueAt(i, 6).toString();
				vActive = table.getValueAt(i, 5).toString();
				new gnMasterTable().updateTableInfo(mastername, vActive, vverticle, vmascode);
			}
			new General().Quickmsg("Update Status --> Sucess...");
		} catch (Exception r) {
			new General().msg("General Master U?/pdate Satatus" + r.getLocalizedMessage());
		}
	}

}// Last

package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class hie_Level_1 extends getResultSet {
	// Prepare to insert in table Variable
	private String vcompcode;
	JInternalFrame internalFrame;

	private String vsegment;
	private String vverticle;
	private String vhcode;
	private String vhname;
	private String vnode;
	private String vlevel;
	private String vhno;
	private boolean vdefaultHierarchy;
	private String vdf = "N";
	//
	private String Rvsegmentcode;
	private String Rverticlecode;
	private String Rhno;
	private String xhname;
	private JCheckBox chDefault;

	//
	JFrame Hie_frame_level1;
	private JTextField companycode;
	private JTextField segmentcode;
	private JTextField verticlecode;
	private JTextField segmentname;
	private JTextField verticlename;
	private JTextField nodetype;
	private JTextField nodename;
	private JTextField hierarchyno;
	private JTextField level;
	private JTextField hierarchycode;
	private JTextField hierarchyname;
	private JTextField comanyname;

	//
	private String Col[] = { "company_code", "Segment", "Verticle", "Hierarchyno", "Level", "Code", "Name",
			"Node Type" };
	private JTable table = new JTable();

	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane jsp;
	private JViewport prt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hie_Level_1 window = new hie_Level_1();
					window.Hie_frame_level1.setVisible(true);
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
	public hie_Level_1() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		Hie_frame_level1 = new JFrame();
		Hie_frame_level1.setAlwaysOnTop(true);
		Hie_frame_level1.setTitle("Business Application");
		Hie_frame_level1.setBounds(280, 50, 850, 650);
		Hie_frame_level1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Hie_frame_level1.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 850, 650);
		Hie_frame_level1.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		internalFrame = new JInternalFrame("Hierarchy Level 1");
		internalFrame.setBounds(0, 0, 850, 650);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.GREEN, null));
		panel.setBounds(0, 0, 822, 143);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(344, 13, 466, 123);
		panel.add(panel_3);
		panel_3.setBorder(
				new TitledBorder(null, "Hierarchy Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(null);

		JLabel lblHierarchyCode = new JLabel("Hierarchy Code");
		lblHierarchyCode.setBounds(26, 45, 96, 16);
		panel_3.add(lblHierarchyCode);

		JLabel lblName = new JLabel("Hierarchy Name");
		lblName.setBounds(26, 68, 96, 16);
		panel_3.add(lblName);

		hierarchycode = new JTextField();
		hierarchycode.setFont(new Font("Tahoma", Font.BOLD, 13));
		hierarchycode.setBounds(118, 42, 51, 22);
		panel_3.add(hierarchycode);
		hierarchycode.setColumns(10);

		hierarchyname = new JTextField();
		hierarchyname.setFont(new Font("Tahoma", Font.BOLD, 14));
		hierarchyname.setBounds(118, 65, 336, 22);
		panel_3.add(hierarchyname);
		hierarchyname.setColumns(10);
		// hierarchyno.setText("1") ;

		nodename = new JTextField();
		nodename.setEnabled(false);
		nodename.setBounds(163, 88, 89, 22);
		panel_3.add(nodename);
		nodename.setColumns(10);
		nodename.setText("Parenet Node");

		nodetype = new JTextField();
		nodetype.setEnabled(false);
		nodetype.setBounds(118, 88, 44, 22);
		panel_3.add(nodetype);
		nodetype.setColumns(10);
		nodetype.setText("Parent");

		JLabel lblLevel = new JLabel("Node Type");
		lblLevel.setBounds(49, 91, 63, 16);
		panel_3.add(lblLevel);

		JLabel lblParenetCode = new JLabel("Parent code");
		lblParenetCode.setBounds(259, 91, 78, 16);
		panel_3.add(lblParenetCode);

		parenet_code = new JTextField();
		parenet_code.setEnabled(false);
		parenet_code.setEnabled(false);
		parenet_code.setBounds(338, 88, 116, 22);
		panel_3.add(parenet_code);
		parenet_code.setColumns(10);

		JButton btnCreateLevel = new JButton("Create Next Level");
		btnCreateLevel.setMnemonic('N');
		btnCreateLevel.setForeground(Color.BLACK);
		btnCreateLevel.setBackground(Color.CYAN);
		btnCreateLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hie_Level_2 window;
				try {
					window = new hie_Level_2();
					window.Hie_frame_level2.setVisible(true);
				} catch (SQLException e) {
					new General().msg(e.getMessage());
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCreateLevel.setBounds(170, 43, 284, 21);
		panel_3.add(btnCreateLevel);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(-39, 13, 387, 123);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblSegment = new JLabel("Segment");
		lblSegment.setBounds(47, 36, 51, 16);
		panel_2.add(lblSegment);

		JLabel lblVerticle = new JLabel("Verticle");
		lblVerticle.setBounds(57, 58, 49, 16);
		panel_2.add(lblVerticle);

		segmentcode = new JTextField();
		segmentcode.setEnabled(false);
		segmentcode.setBounds(110, 33, 44, 22);
		panel_2.add(segmentcode);
		segmentcode.setColumns(10);
		segmentcode.setText("0");

		verticlecode = new JTextField();
		verticlecode.setBackground(Color.WHITE);
		verticlecode.setEnabled(false);
		verticlecode.setBounds(110, 55, 44, 22);
		panel_2.add(verticlecode);
		verticlecode.setColumns(10);
		verticlecode.setText("0");

		segmentname = new JTextField();
		segmentname.setEnabled(false);
		segmentname.setBounds(156, 33, 219, 22);
		panel_2.add(segmentname);
		segmentname.setColumns(10);

		verticlename = new JTextField();
		verticlename.setBackground(Color.WHITE);
		verticlename.setBounds(156, 55, 219, 22);
		panel_2.add(verticlename);
		verticlename.setColumns(10);

		companycode = new JTextField();
		companycode.setEnabled(false);
		companycode.setEnabled(false);
		companycode.setBounds(110, 12, 44, 22);
		panel_2.add(companycode);
		companycode.setColumns(10);
		comanyname = new JTextField();
		comanyname.setEnabled(false);
		comanyname.setBounds(156, 12, 219, 22);
		panel_2.add(comanyname);
		comanyname.setColumns(10);

		JLabel lblCompanyCode = new JLabel("Company");
		lblCompanyCode.setBounds(43, 15, 63, 16);
		panel_2.add(lblCompanyCode);

		JLabel lblHierarchyNo = new JLabel("Hierarchy");
		lblHierarchyNo.setBounds(43, 82, 63, 16);
		panel_2.add(lblHierarchyNo);

		hierarchyno = new JTextField();
		hierarchyno.setBackground(Color.WHITE);
		hierarchyno.setEditable(false);
		hierarchyno.setEnabled(false);
		hierarchyno.setBounds(110, 79, 43, 22);
		panel_2.add(hierarchyno);
		hierarchyno.setColumns(10);

		// hierarchyno.addActionListener(hno);

		hname = new JTextField();
		hname.setBackground(Color.WHITE);
		hname.setEditable(false);
		hname.setEnabled(false);
		hname.setBounds(156, 79, 219, 22);
		panel_2.add(hname);
		hname.setColumns(10);

		level = new JTextField();
		level.setBounds(110, 101, 44, 22);
		panel_2.add(level);
		level.setEnabled(false);
		level.setColumns(10);
		level.setText("1");

		JLabel lblLevel_1 = new JLabel("Level");
		lblLevel_1.setBounds(69, 104, 34, 16);
		panel_2.add(lblLevel_1);

		chDefault = new JCheckBox("Default Hiearchy");
		chDefault.setBounds(166, 100, 209, 25);
		panel_2.add(chDefault);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.RED));
		panel_1.setBounds(0, 170, 822, 402);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(12, 0, 822, 402);
		panel_1.add(jsp);

		JButton btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBackground(Color.CYAN);
		btnSave.setForeground(Color.BLACK);
		btnSave.setBounds(628, 144, 97, 25);
		internalFrame.getContentPane().add(btnSave);
		ActionListener btn = new Btnlsnr();
		btnSave.addActionListener(btn);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.addActionListener(btn);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.CYAN);
		btnCancel.setBounds(725, 144, 97, 25);
		internalFrame.getContentPane().add(btnCancel);

		JButton btnViewHierarchy = new JButton("View Hierarchy");
		btnViewHierarchy.setMnemonic('V');
		btnViewHierarchy.setForeground(Color.BLACK);
		btnViewHierarchy.setBackground(Color.CYAN);
		btnViewHierarchy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HierarchyTree window;
				try {
					window = new HierarchyTree();
					window.HierarchyTreeFrame.setVisible(true);
				} catch (SQLException e) {
					new General().msg(e.getMessage());
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnViewHierarchy.setBounds(505, 144, 127, 25);
		internalFrame.getContentPane().add(btnViewHierarchy);
		internalFrame.setVisible(true);

		ActionListener seg = new segmentnlsnr();
		segmentname.addActionListener(seg);

		ActionListener hcode = new Hcodenlsnr();
		hierarchycode.addActionListener(hcode);

		ActionListener hno = new Hnonlsnr();
		ActionListener hname1 = new hnameLsnr();

		ActionListener vert = new verticlelsnr();
		verticlename.addActionListener(vert);
		verticlecode.addActionListener(vert);

		hname.addActionListener(hname1);
		hierarchyno.addActionListener(hname1);

		setDefaultValue();
		// showData_ArticleCategory();
	}

	public void setDefaultValue() throws Throwable {
		String vcomp = "";
		new gnApp().setFrameTitel(Hie_frame_level1);
		new gnField().closeform(internalFrame, Hie_frame_level1);
		comanyname.setText(new gnConfig().getCompany());
		companycode.setText(new gnConfig().getCompanyCode());
		verticlecode.setText(new gnHierarchy().getVerticleCode());
		verticlename.setText(new gnHierarchy().getVerticleName());
		segmentcode.setText(new gnHierarchy().getSegmentCode());
		segmentname.setText("Retail");
		hierarchyno.setText(new gnHierarchy().getHierarchyNo());
		hname.setText(new gnHierarchy().getHierarchyName());
		chDefault.setSelected(true);
		chDefault.setEnabled(false);
		chDefault.setText("Selected Dafault Hierarchy");
		vcomp = companycode.getText().toUpperCase();
		switch (vcomp) {
		case "0":
			verticlecode.setEnabled(true);
			// companycode.setEnabled(true);
			segmentcode.setEnabled(false);
			hierarchyno.setEnabled(false);
			hname.setEnabled(false);
		}
	}

	class verticlelsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				String vname = "Verticle";
				new gnAdmin().setverticle(verticlecode, verticlename, hierarchyno, hname);
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				try {
					showData_ArticleCategory();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class hnameLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			try {
				showhierarchyName();
				showData_ArticleCategory();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	class Hnonlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			try {
				String vname = hierarchyname.getText();
				vname = "%" + vname + "%";
				showData_ArticleCategory();
			} catch (SQLException | ReflectiveOperationException e1) {
				new General().msg(e1.getLocalizedMessage());
				e1.printStackTrace();
			}
		}
	}

	class Hcodenlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			try {
				checkHierarchyCode(value);
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class segmentnlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				String vname = "Segment";
				new gnAdmin().showMasterTable(vname, segmentcode, segmentname);
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	private String checkHierarchyCode(String vcode) throws SQLException, ClassNotFoundException {
		String status = "Sucess";
		getFieldValue();
		new General().msg("Verticle code is " + Rverticlecode);
		String SQL = "call  Hie_Check_cat_available(" + vcode + " ," + Rvsegmentcode + ", " + Rverticlecode + ", "
				+ Rhno + " )";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			new General().msg("Hierarchy code   " + vcode
					+ "     is already used .. Enter Any Other Nubmber please Check Table Below");
			status = "Fail";
			hierarchycode.grabFocus();
		}
		return status;
	}

	private void getFieldValue() {
		Rvsegmentcode = segmentcode.getText().trim();
		Rverticlecode = verticlecode.getText().trim();
		Rhno = hierarchyno.getText().trim();

	}

	public void showhierarchyName() throws SQLException, ClassNotFoundException {
		String vname = "HierarhcyName";
		String hname[] = { "Type", "Code", "Description" };
		String vtext = "";
		vtext = "%%";
		new gnTable().RemoveTableRows(model);
		getFieldValue();
		String SQL = "Call     hie_gethierarchyNo(" + Rvsegmentcode + ", " + Rverticlecode + ", '" + vtext + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "Hierarchy", rs.getString(1), rs.getString(2) });
			table.setModel(model);
		}
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification9);
		int rw = table.getRowCount();
		if (rw > 0) {
			new gnTable().setTableColWidth(table, 2, 250);
		}
		table.setGridColor(Color.gray);
		JViewport prt = new JViewport();
		prt.add(table, Col);
		prt.setVisible(true);
		jsp.setViewport(prt);
	}

	public void showData_ArticleCategory() throws SQLException, ClassNotFoundException {
		String vname = "Segment";
		String Seg[] = { "Master Name", "Code", "Description" };
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(Col);
		getFieldValue();
		String vtext = "";
		vtext = "%%";
		if (Rhno.length() > 0) {
			String SQL = "Call     hie_level1_getdata('" + vtext + "' ,  " + Rvsegmentcode + ", " + Rverticlecode + ", "
					+ Rhno + ")";
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
				table.setModel(model);
			}
			table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification9);
			int rw = table.getRowCount();
			if (rw > 0) {
				new gnTable().setTableColWidth(table, 6, 250);
			}
			table.setRowHeight(25);
			table.setBackground(Color.DARK_GRAY);
			table.setForeground(Color.white);
			table.setGridColor(Color.orange);
			table.setSelectionBackground(Color.yellow);
			table.setSelectionForeground(Color.blue);

			JViewport prt = new JViewport();
			prt.add(table, Col);
			prt.setVisible(true);
			jsp.setViewport(prt);
		}
	}

	private void displayInfo(String value, int row) throws SQLException, ClassNotFoundException {
		switch (value) {
		case "Segment":
			segmentcode.setText(table.getValueAt(row, 1).toString());
			segmentname.setText(table.getValueAt(row, 2).toString());
			break;
		case "Verticle":
			verticlecode.setText(table.getValueAt(row, 1).toString());
			verticlename.setText(table.getValueAt(row, 2).toString());
			break;
		case "Hierarchy":
			hierarchyno.setText(table.getValueAt(row, 1).toString());
			hname.setText(table.getValueAt(row, 2).toString());
			showData_ArticleCategory();
			break;

		}
	}

	public CellEditorListener ChangeNotification9 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 0);
			try {
				displayInfo(value, row);
			} catch (Exception e1) {
				new General().msg(e1.getLocalizedMessage());
				e1.printStackTrace();
			}
		}
	};
	private JTextField parenet_code;
	private JTextField hname;

	class Btnlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);

			if (value == "Cancel") {
				Hie_frame_level1.dispose();
			}
			if (value == "Save") {
				try {
					prepareAction();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	} // Listener end

	public void prepareAction() throws Exception {

		vcompcode = companycode.getText();
		vsegment = segmentcode.getText();
		String action = new General().getLength(segmentcode,
				"Enter Segmentcode OR Just Press Enter To Take help on Name");
		if (action == "Fail") {
			return;
		}
		vverticle = verticlecode.getText();
		String action1 = new General().getLength(verticlecode,
				"Enter Verticle  OR Just Press Enter To Take help on  Name");
		if (action1 == "Fail") {
			return;
		}
		vhcode = hierarchycode.getText();
		String action2 = new General().getLength(hierarchycode,
				"Enter Hierarchy Code See in Table and get Max Number +1 as a Code for Hierarchy Code");
		if (action2 == "Fail") {
			showData_ArticleCategory();
			return;
		}
		vhname = hierarchyname.getText();
		String action3 = new General().getLength(hierarchyname, "Enter Hierarchy Name , Name can not be Blank..");
		if (action3 == "Fail") {
			return;
		}
		vnode = nodetype.getText();
		vlevel = level.getText();
		vhno = hierarchyno.getText();
		xhname = hname.getText();

		insertHierarchy();
		hierarchyname.setText(null);
		hierarchycode.setText(null);
		vdefaultHierarchy = chDefault.isSelected();
		if (vdefaultHierarchy == true) {
			vdf = "Y";
		}
		showData_ArticleCategory();
	}

	/// Insert Stock Transfer In Detail Data to Table
	public String insertHierarchy() throws Exception {
		// new General().msg("Stock transfer deail data insertin progress");
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String hie = "Insert into msArticle_category(Company_code , "
				+ "Segment, Verticle , hierarchyNo, level, code , "
				+ "name,  nodeType ,levelMappedName, hierarchy_name, Default_Hierarchy) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(hie);
			prst.setString(1, "0");
			prst.setString(2, vsegment);
			prst.setString(3, vverticle);
			prst.setString(4, vhno);
			prst.setString(5, vlevel);
			prst.setString(6, vhcode);
			prst.setString(7, vhname);
			prst.setString(8, vnode);
			prst.setString(9, "0");
			prst.setString(10, xhname);
			prst.setString(11, vdf);
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con.commit();
			}
			prst.executeBatch(); // insert remaining records
			con.commit();
			new General().msg("Data Save Sucessfully");

		} catch (SQLException e) {
			new General().msg(e.getMessage() + "<Message : Max Lenght Allow is 30 Chars For Hierarchy Name>");
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

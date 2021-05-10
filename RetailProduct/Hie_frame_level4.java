package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
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
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Hie_frame_level4 extends getResultSet {

	JFrame Hie_frame_level4;
	JInternalFrame internalFrame;
	//
	private String Rvsegmentcode;
	private String Rverticlecode;
	private String Rhno;
	//
	private String vcompcode;
	private String vsegment;
	private String vverticle;
	private String vhcode;
	private String vhname;
	private String vnode;
	private String vlevel;
	private String vhno;
	private String vparentcode;
	private String vparentRef;
	private String vparentRef1;

	//
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
	private JTextField parenet_code;
	private JButton btnMessage;

	private JTextField comanyname;

	//
	private String lvl1[] = { "Parent Level", "company_code", "Segment", "Verticle", "Hierarchyno", "Level", "Code",
			"Name", "Node Type", "Category", "Sub Cat.", "Group" };
	private String lvl2[] = { "Third  Level", "company_code", "Segment", "Verticle", "Hierarchyno", "Level", "Code",
			"Name", "Node Type", "Category", "SubCategrory" };

	private JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);

			if (column == 0 || column == 1 || column == 2 || column == 3 || column == 4 || column == 6 || column == 7) {
				componentt.setForeground(Color.gray);
				componentt.setCursor(getCursor());
			}
			if (column == 6 || column == 7) // || column ==3 || column ==5 ||
											// column ==8 || column ==9 ||
											// column ==14 )
			{
				// componentt.setBackground(Color.white);
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setFont(new General().getFont(11));
				componentt.setCursor(getCursor());

			}
			return componentt;
		}
	};

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
					Hie_frame_level4 window = new Hie_frame_level4();
					window.Hie_frame_level4.setVisible(true);
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
	public Hie_frame_level4() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		Hie_frame_level4 = new JFrame();
		Hie_frame_level4.setAlwaysOnTop(true);
		Hie_frame_level4.setTitle("Business Application");
		Hie_frame_level4.setBounds(280, 50, 850, 650);
		Hie_frame_level4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Hie_frame_level4.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 850, 650);
		Hie_frame_level4.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		internalFrame = new JInternalFrame("Hierarchy Level 4");
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
		ActionListener hcode1 = new Hcodenlsnr();
		hierarchycode.addActionListener(hcode1);

		hierarchyname = new JTextField();
		hierarchyname.setFont(new Font("Tahoma", Font.BOLD, 14));
		hierarchyname.setBounds(118, 65, 336, 22);
		panel_3.add(hierarchyname);
		hierarchyname.setColumns(10);

		nodename = new JTextField();
		nodename.setEnabled(false);
		nodename.setBounds(163, 88, 89, 22);
		panel_3.add(nodename);
		nodename.setColumns(10);
		nodename.setText("Last  Node");

		nodetype = new JTextField();
		nodetype.setEnabled(false);
		nodetype.setBounds(118, 88, 44, 22);
		panel_3.add(nodetype);
		nodetype.setColumns(10);
		nodetype.setText("Last");

		JLabel lblLevel = new JLabel("Node Type");
		lblLevel.setBounds(49, 91, 63, 16);
		panel_3.add(lblLevel);

		JLabel lblParenetCode = new JLabel("Parent code");
		lblParenetCode.setBounds(34, 16, 78, 16);
		panel_3.add(lblParenetCode);

		parenet_code = new JTextField();
		parenet_code.setToolTipText("Press Enter to Select Parent code from List");
		parenet_code.setEnabled(true);
		parenet_code.setBounds(118, 10, 51, 22);
		panel_3.add(parenet_code);
		parenet_code.setColumns(10);
		ActionListener parent = new Parentcodelsnr();
		parenet_code.addActionListener(parent);
		parenet_code.setText("0");

		JButton btnViewHierarchy = new JButton("View Hierarchy");
		btnViewHierarchy.setMnemonic('V');
		btnViewHierarchy.setBackground(Color.CYAN);
		btnViewHierarchy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HierarchyTree window;
				try {
					window = new HierarchyTree();
					window.HierarchyTreeFrame.setVisible(true);
				} catch (SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewHierarchy.setBounds(264, 87, 188, 25);
		panel_3.add(btnViewHierarchy);

		parentname = new JTextField();
		parentname.setEditable(false);
		parentname.setBounds(170, 10, 284, 22);
		panel_3.add(parentname);
		parentname.setColumns(10);

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

		verticlecode = new JTextField();
		verticlecode.setEnabled(false);
		verticlecode.setBounds(110, 55, 44, 22);
		panel_2.add(verticlecode);
		verticlecode.setColumns(10);

		segmentname = new JTextField();
		segmentname.setEditable(false);
		segmentname.setToolTipText("Press Enter to Select Code from list");
		segmentname.setBounds(156, 33, 219, 22);
		panel_2.add(segmentname);
		segmentname.setColumns(10);
		ActionListener seg = new segmentnlsnr();
		segmentname.addActionListener(seg);

		verticlename = new JTextField();
		verticlename.setEditable(false);
		verticlename.setToolTipText("Press Enter to Select Code from list");
		verticlename.setBounds(156, 55, 219, 22);
		panel_2.add(verticlename);
		verticlename.setColumns(10);

		companycode = new JTextField();
		companycode.setEnabled(false);
		companycode.setBounds(110, 12, 44, 22);
		panel_2.add(companycode);
		companycode.setColumns(10);
		companycode.setText(new gnConfig().getCompanyCode());
		comanyname = new JTextField();
		comanyname.setEditable(false);
		comanyname.setBounds(156, 12, 219, 22);
		panel_2.add(comanyname);
		comanyname.setColumns(10);
		comanyname.setText(new gnConfig().getCompany());

		JLabel lblCompanyCode = new JLabel("Company");
		lblCompanyCode.setBounds(43, 15, 63, 16);
		panel_2.add(lblCompanyCode);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.RED));
		panel_1.setBounds(0, 170, 822, 402);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 0, 822, 402);
		panel_1.add(jsp);

		JButton btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBackground(Color.CYAN);
		btnSave.setBounds(628, 144, 97, 25);
		internalFrame.getContentPane().add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setBackground(Color.CYAN);
		btnCancel.setBounds(725, 144, 97, 25);
		internalFrame.getContentPane().add(btnCancel);

		btnMessage = new JButton("");
		btnMessage.setEnabled(false);
		btnMessage.setForeground(Color.BLACK);
		btnMessage.setBackground(Color.CYAN);
		btnMessage.setBounds(0, 144, 348, 25);
		internalFrame.getContentPane().add(btnMessage);
		internalFrame.setVisible(true);
		segmentcode.setText("0");
		verticlecode.setText("0");

		JLabel lblHierarchyNo = new JLabel("Hierarchy");
		lblHierarchyNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHierarchyNo.setBounds(41, 79, 63, 16);
		panel_2.add(lblHierarchyNo);

		hierarchyno = new JTextField();
		hierarchyno.setEnabled(false);
		hierarchyno.setBounds(110, 78, 44, 22);
		panel_2.add(hierarchyno);
		hierarchyno.setColumns(10);
		hierarchyno.setText("1");

		hname = new JTextField();
		hname.setEnabled(false);
		hname.setEditable(false);
		hname.setBounds(156, 78, 220, 22);
		panel_2.add(hname);
		hname.setColumns(10);

		JLabel lblLevel_1 = new JLabel("Level");
		lblLevel_1.setBounds(67, 102, 34, 16);
		panel_2.add(lblLevel_1);

		level = new JTextField();
		level.setBounds(110, 102, 44, 19);
		panel_2.add(level);
		level.setEnabled(false);
		level.setColumns(10);
		level.setText("4");

		JLabel lblSearchByName = new JLabel("Search By Name");
		lblSearchByName.setBounds(360, 148, 97, 16);
		internalFrame.getContentPane().add(lblSearchByName);

		searchname = new JTextField();
		searchname.setBounds(456, 145, 173, 24);

		ActionListener vert = new verticlelsnr();
		verticlecode.addActionListener(vert);
		verticlename.addActionListener(vert);

		ActionListener btn = new Btnlsnr();
		btnSave.addActionListener(btn);

		btnCancel.addActionListener(btn);

		internalFrame.getContentPane().add(searchname);
		searchname.setColumns(10);

		setDefaultValue();
		// showData_ArticleSubGroup();

	}

	public void setDefaultValue() throws Throwable {
		new gnApp().setFrameTitel(Hie_frame_level4);
		new gnField().closeform(internalFrame, Hie_frame_level4);

		String vcomp = "";
		comanyname.setText(new gnConfig().getCompany());
		companycode.setText(new gnConfig().getCompanyCode());
		segmentcode.setText(new gnHierarchy().getSegmentCode());
		segmentname.setText("Retail");
		verticlecode.setText(new gnHierarchy().getVerticleCode());
		verticlename.setText(new gnHierarchy().getVerticleName());
		hierarchyno.setText(new gnHierarchy().getHierarchyNo());
		hname.setText(new gnHierarchy().getHierarchyName());
		vcomp = companycode.getText().toUpperCase();
		switch (vcomp) {
		case "0":
			verticlecode.setEnabled(true);
		}
	}

	class verticlelsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			try {
				String vname = "Verticle";
				new gnAdmin().setverticle(verticlecode, verticlename, hierarchyno, hname);
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					showData_ArticleSubGroup();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class segmentnlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			try {
				getSegmentData();
			} catch (SQLException | ClassNotFoundException e1) {
				new General().msg(e1.getMessage());
			}
		}
	}

	class Parentcodelsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			try {
				showData_ArticleGroup();
				btnMessage.setText("Message  : Select  Code From List OR <You can Assign Hierarchy Later Also>");
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class Btnlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			if (value == "Cancel") {
				Hie_frame_level4.dispose();
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

	private void getFieldValue() {
		Rvsegmentcode = segmentcode.getText().trim();
		Rverticlecode = verticlecode.getText().trim();
		Rhno = hierarchyno.getText().trim();
	}

	private String checkHierarchyCode(String vcode) throws SQLException, ClassNotFoundException {
		String status = "Sucess";
		showData_ArticleSubGroup();
		// String SQL = "call Hie_Check_Subgroup_available("+vcode+")" ;
		String SQL = "call  Hie_Check_Subgroup_available(" + vcode + " ," + Rvsegmentcode + ", " + Rverticlecode + ", "
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

	public void showData_ArticleGroup() throws SQLException, ClassNotFoundException {

		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(lvl2);
		String vname = "Segment";
		String vtext = searchname.getText();
		vtext = "%" + vtext + "%";

		getFieldValue();
		String SQL = "Call     hie_level3_getdata( '" + vtext + "',    " + Rvsegmentcode + ", " + Rverticlecode + ", "
				+ Rhno + ")";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "Group", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10) });
			table.setModel(model);
		}
		// table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification9);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification9);

		table.setGridColor(Color.gray);
		new gnTable().setTableColWidth(table, 7, 250);
		JViewport prt = new JViewport();
		prt.add(table, lvl2);
		prt.setVisible(true);
		jsp.setViewport(prt);
	}

	public void showData_ArticleSubGroup() throws SQLException, ClassNotFoundException {
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(lvl1);
		String vname = "Segment";
		getFieldValue();
		String vtext = searchname.getText();
		vtext = "%" + vtext + "%";
		String SQL = "Call     hie_level4_getdata( '" + vtext + "' , " + Rvsegmentcode + ", " + Rverticlecode + ", "
				+ Rhno + ")";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "Sub Group", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10), rs.getString(11) });
			table.setModel(model);
		}
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification9);
		table.setGridColor(Color.gray);
		int vrow = table.getRowCount();
		if (vrow > 0) {
			new gnTable().setTableColWidth(table, 7, 250);
		}
		JViewport prt = new JViewport();
		prt.add(table, lvl1);
		prt.setVisible(true);
		jsp.setViewport(prt);
	}

	private void getSegmentData() throws SQLException, ClassNotFoundException {
		btnMessage.setText("Message  : Select  Code From the Below List  Double Click On Attached  Code");
		String Seg[] = { "Master Name", "Code", "Description" };
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(Seg);
		String vname = "Segment";
		String vtext = segmentname.getText();
		vtext = "%" + vtext + "%";

		String SQL = "Call master_getSegment('" + vtext + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "Segment", rs.getString(1), rs.getString(2) });
			table.setModel(model);
		}
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification9);
		table.setGridColor(Color.gray);
		JViewport prt = new JViewport();
		prt.add(table, Seg);
		prt.setVisible(true);
		jsp.setViewport(prt);
	}

	private void getVerticleData() throws SQLException, ClassNotFoundException {
		btnMessage.setText("Message  : Select  Code From the Below List  Double Click On Attached  Code");
		String Seg[] = { "Master Name", "Code", "Description" };
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(Seg);
		String vname = "Verticle";
		String vtext = segmentname.getText();
		vtext = "%" + vtext + "%";
		String SQL = "Call master_getVerticle('" + vtext + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "Verticle", rs.getString(1), rs.getString(2) });
			table.setModel(model);
		}
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification9);
		table.setGridColor(Color.gray);
		JViewport prt = new JViewport();
		prt.add(table, Seg);
		prt.setVisible(true);
		jsp.setViewport(prt);
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
	private JTextField searchname;
	private JTextField hname;
	private JTextField parentname;

	private void displayInfo(String value, int row) throws SQLException, ClassNotFoundException {
		switch (value) {
		case "Segment":
			segmentcode.setText(table.getValueAt(row, 1).toString());
			segmentname.setText(table.getValueAt(row, 2).toString());
			btnMessage.setText("..");
			break;
		case "Verticle":
			verticlecode.setText(table.getValueAt(row, 1).toString());
			verticlename.setText(table.getValueAt(row, 2).toString());
			btnMessage.setText("..");
			showData_ArticleSubGroup();
			break;
		case "Group":
			parenet_code.setText(table.getValueAt(row, 6).toString());
			vparentRef = (table.getValueAt(row, 9).toString());
			vparentRef1 = (table.getValueAt(row, 10).toString());
			parentname.setText(table.getValueAt(row, 7).toString());
			showData_ArticleSubGroup();
		}
	}

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
			showData_ArticleGroup();
			btnMessage.setText("Message : Enter Hierarchy code < Max code +1 from below Table List>");

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
		vparentcode = parenet_code.getText();
		String action4 = new General().getLength(parenet_code,
				"Select Parent code  Press Enter To Select Parent Code..");
		if (action4 == "Fail") {
			btnMessage.setText(
					"Message :  Select  Code From Below Table to Atatched as  Parent Code for this Hierarchy ");
			showData_ArticleGroup();
			return;
		}
		insertHierarchy();
		hierarchyname.setText(null);
		hierarchycode.setText(null);
		// parenet_code.setText("0");
		showData_ArticleSubGroup();
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
		String hie = "Insert into     msarticle_subgroup(Company_code , "
				+ "Segment, Verticle , hierarchyNo, level, code , "
				+ "name,  nodeType ,levelMappedName, Parent_1, Parent_2, Parent_3) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?)";
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
			prst.setString(10, vparentRef);
			prst.setString(11, vparentRef1);
			prst.setString(12, vparentcode);

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
			btnMessage.setText("..");
		} catch (SQLException e) {
			new General().msg(e.getMessage() + "<Max Lenght Allow is 30 Chars For Hierarchy Name>");
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
	/// End Insert

}// last

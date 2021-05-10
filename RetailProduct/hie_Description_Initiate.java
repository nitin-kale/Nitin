package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
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
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class hie_Description_Initiate extends getResultSet {

	// Prepare to insert in table Variable
	private String vcompcode;
	private JButton btnNewButton;
	private String vsegment;
	private String vverticle;
	private String vhcode;
	private String vhname;
	private String vnode;
	private String vlevel;
	private String vhno;
	private JCheckBox chDefault;
	private boolean vdefaultHierarchy;
	private String vdf = "N";
	private String Rvsegmentcode;
	private String Rverticlecode;
	private String Rhno;
	private String xhname;
	//
	private JButton btnSave;
	private JButton btnCancel;

	//

	JFrame hie_Description;
	private JTextField companycode;
	private JTextField companyname;
	private JTextField segmentcode;
	private JTextField segmentname;
	private JTextField verticlecode;
	private JTextField verticlename;
	private JTextField hierarchyno;
	private JTextField hname;

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
					hie_Description_Initiate window = new hie_Description_Initiate();
					window.hie_Description.setVisible(true);
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
	public hie_Description_Initiate() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		hie_Description = new JFrame();
		hie_Description.setResizable(false);
		hie_Description.setTitle("Business Application");
		hie_Description.setAlwaysOnTop(true);
		hie_Description.setBounds(350, 100, 700, 427);
		hie_Description.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		hie_Description.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 700, 400);
		hie_Description.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Hierarchy Description");
		internalFrame.setBounds(0, 0, 700, 400);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.CYAN, Color.BLACK));
		panel.setBounds(0, 0, 672, 126);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCompanyCode = new JLabel("Company Code");
		lblCompanyCode.setBounds(12, 13, 95, 16);
		panel.add(lblCompanyCode);

		companycode = new JTextField();
		companycode.setEnabled(false);
		companycode.setBounds(103, 10, 61, 22);
		panel.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setEnabled(false);
		companyname.setBounds(167, 10, 229, 22);
		panel.add(companyname);
		companyname.setColumns(10);

		JLabel lblSegment = new JLabel("Segment");
		lblSegment.setBounds(37, 42, 56, 16);
		panel.add(lblSegment);

		segmentcode = new JTextField();
		segmentcode.setBounds(103, 39, 61, 22);
		panel.add(segmentcode);
		segmentcode.setEnabled(false);
		segmentcode.setColumns(10);
		ActionListener seg1 = new segmentnlsnr();
		segmentcode.addActionListener(seg1);

		segmentname = new JTextField();
		segmentname.setEnabled(false);
		segmentname.setBounds(167, 39, 229, 22);
		panel.add(segmentname);
		segmentname.setColumns(10);
		ActionListener seg = new segmentnlsnr();
		segmentname.addActionListener(seg);

		JLabel lblVerticle = new JLabel("Verticle");
		lblVerticle.setBounds(47, 62, 56, 16);
		panel.add(lblVerticle);

		verticlecode = new JTextField();
		verticlecode.setBounds(103, 63, 61, 22);
		panel.add(verticlecode);
		verticlecode.setColumns(10);
		ActionListener vert1 = new verticlelsnr();
		verticlecode.addActionListener(vert1);
		verticlecode.setEnabled(false);

		verticlename = new JTextField();
		verticlename.setBackground(Color.WHITE);
		verticlename.setBounds(167, 63, 229, 22);
		panel.add(verticlename);
		verticlename.setColumns(10);

		JLabel lblHierarchyNo = new JLabel("Hierarchy No");
		lblHierarchyNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHierarchyNo.setBounds(0, 89, 95, 16);
		panel.add(lblHierarchyNo);

		hierarchyno = new JTextField();
		hierarchyno.setBackground(Color.WHITE);
		hierarchyno.setBounds(103, 88, 61, 22);
		panel.add(hierarchyno);
		hierarchyno.setColumns(10);

		hname = new JTextField();
		hname.setBackground(Color.WHITE);
		hname.setBounds(167, 88, 229, 22);
		panel.add(hname);
		hname.setColumns(10);

		chDefault = new JCheckBox("Default Hierarchy For My Company ");
		chDefault.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		chDefault.setForeground(Color.DARK_GRAY);
		chDefault.setBackground(Color.WHITE);
		chDefault.setBounds(404, 87, 260, 25);
		panel.add(chDefault);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 154, 672, 212);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 0, 672, 199);
		panel_1.add(jsp);

		btnSave = new JButton("Save");
		btnSave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int vkey = e.getKeyCode();
				if (vkey == 10) {
					btnSave.doClick();
				}
			}
		});

		btnSave.setMnemonic('S');
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(Color.CYAN);
		btnSave.setBounds(478, 128, 97, 25);
		ActionListener abc = new Btnlsnr();
		btnSave.addActionListener(abc);

		internalFrame.getContentPane().add(btnSave);

		btnCancel = new JButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.CYAN);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hie_Description.dispose();
			}
		});
		btnCancel.setBounds(575, 128, 97, 25);
		internalFrame.getContentPane().add(btnCancel);

		btnNewButton = new JButton(
				"!!! Default hierarchy created for each verticle. Assign one of the hierarchy to your company !!!");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(0, 128, 479, 25);

		ActionListener vert = new verticlelsnr();
		verticlename.addActionListener(vert);
		verticlecode.addActionListener(vert1);
		verticlecode.setEnabled(false);

		internalFrame.getContentPane().add(btnNewButton);
		internalFrame.setVisible(true);

		decorate();
		setDefault();
		showData_HierarchyDescription();
	}

	// Start Coding Here

	private void decorate() throws ClassNotFoundException, SQLException {
		new gnDecorate().DispField_Eatch(verticlecode, 20);
		new gnDecorate().DispField_Eatch(verticlename, 20);
		new gnDecorate().DispField_Eatch(segmentcode, 20);
		new gnDecorate().DispField_Eatch(segmentname, 10);
		new gnDecorate().DispField_Beval_int(hname, 1);
		new gnDecorate().DispField_Beval_int(hierarchyno, 1);
		new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnCancel, Color.BLUE, Color.WHITE);

	}

	private void setDefault() throws Throwable {
		String vcomp = "";
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		segmentcode.setText(new gnHierarchy().getSegmentCode());
		segmentname.setText("Retail");
		verticlecode.setText(new gnHierarchy().getVerticleCode());
		verticlename.setText(new gnHierarchy().getVerticleName());
		hname.setText(new gnHierarchy().getHierarchyName());
		hierarchyno.setText(new gnHierarchy().getHierarchyNo());
		vcomp = companycode.getText().toUpperCase();

		btnSave.setVisible(false);
		String vuser = new gnConfig().getUserCode().toUpperCase();
		switch (vuser) {
		case "ADMIN":
			btnSave.setVisible(true);
			break;
		}
	}

	public void showData_HierarchyDescription() throws SQLException, ClassNotFoundException {
		new gnTable().RemoveTableRows(model);
		String Col[] = { "Type", "Segment", "Segment_Name", "verticle", "Verticle_Name", "HierarchyNo",
				"Hierarchy_Name", "Default_hierarchy" };
		model.setColumnIdentifiers(Col);
		String vtype = "ALL";
		String vverticle = "";
		String SQL = "Call     hieDesc_getallData( '" + vtype + "' , '" + vverticle + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "View", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6) });
			table.setModel(model);
		}
		table.setGridColor(Color.white);
		table.setBackground(Color.DARK_GRAY);
		table.setBackground(Color.WHITE);
		table.setSelectionBackground(Color.DARK_GRAY);
		table.setSelectionForeground(Color.white);
		int rw = table.getRowCount();
		if (rw > 0) {
			new gnTable().setTableColWidth(table, 3, 200);
			new gnTable().setTableColWidth(table, 6, 225);
			new gnTable().setTableColWidth(table, 4, 300);
		}
		JViewport prt = new JViewport();
		prt.add(table, Col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		new gnTable().setTableBasics(table);
	}

	class segmentnlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				getSegmentData();
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	class verticlelsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				getVerticleData();
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
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

	private void getSegmentData() throws SQLException, ClassNotFoundException {
		String Seg[] = { "Master Name", "Code", "Description" };
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(Seg);
		String vname = "Segment";
		String SQL = "Call master_getmasterData('" + vname + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "Segment", rs.getString(1), rs.getString(2) });
			table.setModel(model);
		}
		table.setGridColor(Color.gray);
		JViewport prt = new JViewport();
		prt.add(table, Seg);
		prt.setVisible(true);
		jsp.setViewport(prt);
	}

	private void getVerticleData() throws Throwable {
		String vtype = "Verticle";
		// new gnAdmin().showMasterTable(vtype, verticlecode, verticlename);
		new gnAdmin().setverticle(verticlecode, verticlename, hierarchyno, hname);
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
		vhno = hierarchyno.getText();
		xhname = hname.getText();
		String action2 = new General().getLength(hname, "Enter Hiearchy Name And No");
		if (action1 == "Fail") {
			return;
		}
		vdefaultHierarchy = chDefault.isSelected();
		new General().msgBoolean(vdefaultHierarchy);
		if (vdefaultHierarchy == true) {
			vdf = "Y";
		}

		insertHierarchyDescription();

		hname.setText(null);
		hierarchyno.setText(null);
	}

	public String insertHierarchyDescription() throws Exception {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String hie = "Insert into Hierarchy_Description(Company_code , " + "Segment , " + "Verticle , "
				+ "hierarchyNo , " + "Hierarchy_name ," + "Segment_name  , " + "Verticle_name ,  "
				+ "Default_hierarchy )" + "values(?,?,?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(hie);
			prst.setString(1, "0");
			prst.setString(2, vsegment);
			prst.setString(3, vverticle);
			prst.setString(4, vhno);
			prst.setString(5, xhname);
			prst.setString(6, segmentname.getText());
			prst.setString(7, verticlename.getText());
			prst.setString(8, vdf);
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
			showData_HierarchyDescription();
		} catch (SQLException e) {
			new General().msg(e.getMessage() + "<Message : Max Lenght Allow is 30 Chars For All Name>");
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

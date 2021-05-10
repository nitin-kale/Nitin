package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window.Type;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class createManuf extends getResultSet {

	JFrame frameManuf;
	private JTextField manufcode;
	private JTextField manufname;
	private JTextField verticlecode;
	private JTextField verticlename;
	private JButton btnMsg;
	private JTextField companycode;
	JInternalFrame internalFrame;
	private JTextField companyname;
	JButton btnCancel;

	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane jsp;
	private JViewport prt;
	private JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createManuf window = new createManuf();
					window.frameManuf.setVisible(true);
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
	public createManuf() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frameManuf = new JFrame();
		frameManuf.setTitle("Business Application");
		frameManuf.setType(Type.UTILITY);
		frameManuf.setBackground(Color.CYAN);
		frameManuf.setAlwaysOnTop(true);
		frameManuf.setBounds(250, 100, 600, 600);
		frameManuf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameManuf.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 600, 600);
		frameManuf.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		internalFrame = new JInternalFrame("Create Manufractorar ");
		internalFrame.setBounds(0, 0, 600, 600);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(0, 0, 572, 146);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblManufcode = new JLabel("Manuf_code");
		lblManufcode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblManufcode.setBounds(6, 47, 80, 16);
		panel.add(lblManufcode);

		manufcode = new JTextField();
		manufcode.setBounds(87, 44, 80, 22);
		panel.add(manufcode);
		manufcode.setColumns(10);

		manufname = new JTextField();
		manufname.setBounds(166, 44, 292, 22);
		panel.add(manufname);
		manufname.setColumns(10);

		verticlecode = new JTextField();
		verticlecode.setBounds(87, 73, 80, 22);
		panel.add(verticlecode);
		verticlecode.setColumns(10);
		ActionListener seg1 = new verticlelsnr();
		verticlecode.addActionListener(seg1);

		verticlename = new JTextField();
		verticlename.setBounds(166, 73, 292, 22);
		panel.add(verticlename);
		verticlename.setColumns(10);
		ActionListener seg = new verticlelsnr();
		verticlename.addActionListener(seg);

		JLabel lblVerticle = new JLabel("Verticle");
		lblVerticle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVerticle.setBounds(30, 73, 56, 16);
		panel.add(lblVerticle);

		JLabel lblNewLabel = new JLabel("Company");
		lblNewLabel.setBounds(17, 19, 56, 16);
		panel.add(lblNewLabel);

		companycode = new JTextField();
		companycode.setEnabled(true);
		companycode.setEditable(true);
		companycode.setBounds(86, 16, 81, 22);
		panel.add(companycode);
		companycode.setColumns(10);
		ActionListener compcd = new Company();
		companycode.addActionListener(compcd);

		companyname = new JTextField();
		companyname.setEnabled(false);
		companyname.setEditable(false);
		companyname.setBounds(168, 16, 290, 22);
		panel.add(companyname);
		companyname.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 177, 572, 352);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 0, 572, 352);
		panel_1.add(jsp);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(0, 145, 572, 32);
		internalFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.CYAN);
		btnSave.setBounds(262, 0, 97, 32);
		ActionListener sv = new btnLsnr();
		btnSave.addActionListener(sv);
		panel_2.add(btnSave);
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.CYAN);
		btnCancel.setBounds(356, 0, 97, 32);
		btnCancel.addActionListener(sv);
		panel_2.add(btnCancel);

		JButton btnAssign = new JButton("Assign Brand");
		btnAssign.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent arg0) {
				createBrand window = null;
				try {
					window = new createBrand();
					window.frameBrand.setVisible(true);
					window = new createBrand();
				} catch (SQLException e) {
					new General().msg(e.getMessage());
				} catch (ClassNotFoundException e) {
					new General().msg(e.getMessage());
				} catch (Throwable e) {
					new General().msg(e.getMessage());
				}
			}
		});
		btnAssign.setForeground(Color.BLACK);
		btnAssign.setBackground(Color.CYAN);
		btnAssign.setBounds(452, 0, 120, 32);
		panel_2.add(btnAssign);

		btnMsg = new JButton("..");
		btnMsg.setEnabled(false);
		btnMsg.setBounds(0, 0, 264, 32);
		panel_2.add(btnMsg);
		internalFrame.setVisible(true);
		decorate();
		setDefault();
		show();
	}

	private void decorate() {
		manufcode.setEditable(false);
		try {
			new gnApp().setFrameTitel(frameManuf);
			frameManuf.setUndecorated(false);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void setDefault() throws Throwable {

		String vcomp = new gnConfig().getCompanyCode();
		companycode.setText(vcomp);
		companyname.setText(new gnConfig().getCompany());
		verticlecode.setText(new gnHierarchy().getVerticleCode());
		verticlename.setText(new gnHierarchy().getVerticleName());
		new gnApp().setFrameTitel(frameManuf);
		new gnField().closeform(internalFrame, frameManuf);

		if (vcomp != "0") {
			verticlecode.setEnabled(false);
			verticlename.setEditable(false);
			companycode.setEditable(false);
			companycode.setEnabled(false);
		}

	}

	private void show() throws Throwable {
		btnMsg.setText("<For Verticle Press Enter and get Help >");
		String vcomp = companycode.getText();
		String vverticle = verticlecode.getText();
		String vsegment = new gnHierarchy().getSegmentCode();
		String vname = "%%";
		String SQL = "Call ms_getManuf('" + vname + "' , " + vsegment + " , " + vverticle + ",  " + vcomp + ")";
		String Manuf[] = { "Manuf.Code", "Name ", "VerticleCode", "Verticle Name" };
		showData(SQL, Manuf);
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
			} finally {
				try {
					show();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		}
	}

	class verticlelsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				new gnAdmin().setverticle(verticlecode, verticlename, verticlecode, verticlename);
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
			} catch (ClassNotFoundException e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				new General().msg(e1.getMessage());
			} finally {
				try {
					show();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class btnLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (value == "Cancel") {
				frameManuf.dispose();
			}
			if (value == "Save") {
				try {
					prepareToinsert();
				} catch (SQLException e1) {
					new General().msg("Messgae:" + e1.getMessage());
				} catch (ClassNotFoundException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		}
	}

	private void showData(String sql, String[] manuf) throws SQLException, ClassNotFoundException {
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(manuf);
		String vname = "Verticle";
		rs = this.getSPResult(sql);
		if (rs.next()) {
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
				table.setModel(model);
			}
			table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification9);
			table.setGridColor(Color.gray);
			JViewport prt = new JViewport();
			prt.add(table, manuf);
			prt.setVisible(true);
			jsp.setViewport(prt);
		} else {
			new General().msg("No Record Found..");
		}
	}

	private void getVerticleData() throws SQLException, ClassNotFoundException {
		String Seg[] = { "Master Name", "Code", "Description" };
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(Seg);
		String vname = "Verticle";
		String SQL = "Call master_getmasterData('" + vname + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "Verticle", rs.getString(1), rs.getString(2) });
			table.setModel(model);
		}
		// table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification9);
		DefaultCellEditor nk3 = new gnTable().cellEdit(table);
		nk3.addCellEditorListener(ChangeNotification9);
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

	private void displayInfo(String value, int row) throws SQLException {
		switch (value) {
		case "Verticle":
			verticlecode.setText(table.getValueAt(row, 1).toString());
			verticlename.setText(table.getValueAt(row, 2).toString());
			break;
		}
	}

	private void prepareToinsert() throws Throwable {
		String status = "Fail";
		status = validate();
		if (status == "Sucess") {

			if (companycode.getText() == "0") {
				manufcode.setText(new gnSeq().getSeqno("901", "MS"));
				insertDataforStandard();
				new gnSeq().updateSeqno("901", "MS");
				show();
				manufname.setText(null);
			}

			if (companycode.getText().length() > 1) {
				manufcode.setText(new gnSeq().getSeqno("901", "MS"));
				insertDataforCompany();
				new gnSeq().updateSeqno("901", "MS");
				insertDataforStandard();
				show();
				manufname.setText(null);
			}
		}
	}

	private String validate() {
		String status = "Sucess";

		if (manufname.getText().length() == 0) {
			new General().msg("Enter Name of  Manuf..");
			status = "Fail";
		}
		return status;
	}

	public String insertDataforCompany() throws Throwable {
		String status = "Fail";
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String hie = "Insert into ms_Manuf_master(Manuf_code , " + "Name, Verticlecode ,verticlename, company_code) "
				+ "values(?,?,?,?,?)";
		try {
			prst = con.prepareStatement(hie);
			prst.setString(1, manufcode.getText());
			prst.setString(2, manufname.getText());
			prst.setString(3, verticlecode.getText());
			prst.setString(4, verticlename.getText());
			prst.setString(5, companycode.getText());
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
			if (status == "Sucess") {
				new General().msg("Data Save Sucessfully");
			}
		}

		return status;
	}

	public String insertDataforStandard() throws Throwable {
		String action = validate();
		String status = "Fail";
		if (action == "Sucess") {
			// manufcode.setText( new gnSeq().getSeqno("901", "MS")) ;
			prst = null;
			final int batchSize = 10;
			int TotalRecordinsert = 0;
			Connection con = this.getConnection();
			con.setAutoCommit(false);
			String hie = "Insert into ms_Manuf_master(Manuf_code , "
					+ "Name, Verticlecode ,verticlename, company_code) " + "values(?,?,?,?,?)";
			try {
				prst = con.prepareStatement(hie);
				prst.setString(1, manufcode.getText());
				prst.setString(2, manufname.getText());
				prst.setString(3, verticlecode.getText());
				prst.setString(4, verticlename.getText());
				prst.setString(5, "0");
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
				// verticlecode.setText(null);
				// verticlename.setText(null);
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
				if (status == "Sucess") {
					new General().msg("Data Save Sucessfully");
				}
			}
		}
		return status;
	}

}// last

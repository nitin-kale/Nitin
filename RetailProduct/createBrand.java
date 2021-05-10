package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
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
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class createBrand extends getResultSet {

	// LookAndFeelDemo lf = new LookAndFeelDemo() ;

	JFrame frameBrand;
	private JTextField brandcode;
	JButton btnCancel;
	JButton btnSave;
	private JTextField manufcode;
	private JTextField manufname;
	JInternalFrame internalFrame;
	private JTextField markdown;
	private JTextField markup;
	private JTextField companycode;
	private JTextField companyname;
	private JTextField discount;
	String vverticle;
	private JTextField brandname;
	private JTextField verticlecode;
	private JTextField verticlename;
	private JButton btnMsg;
	private String vcomp;

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
					createBrand window = new createBrand();
					window.frameBrand.setVisible(true);

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
	public createBrand() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		// lf.initLookAndFeel();
		frameBrand = new JFrame();
		frameBrand.setTitle("Business Application");
		frameBrand.setType(Type.UTILITY);
		frameBrand.setBackground(Color.CYAN);
		frameBrand.setAlwaysOnTop(true);
		frameBrand.setBounds(250, 100, 729, 600);
		frameBrand.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameBrand.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.DARK_GRAY);
		desktopPane.setBounds(0, 0, 711, 600);
		frameBrand.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		internalFrame = new JInternalFrame("Create Brand Information");
		internalFrame.setBounds(0, 0, 711, 600);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 496, 146);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 255, 204));
		panel_3.setBorder(new TitledBorder(
				new CompoundBorder(
						new BevelBorder(BevelBorder.RAISED, new Color(240, 240, 240), new Color(255, 255, 255),
								new Color(105, 105, 105), new Color(160, 160, 160)),
						new LineBorder(new Color(180, 180, 180), 6)),
				"Create New Brand", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_3.setBounds(12, 26, 483, 114);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblManufcode = new JLabel("Brand_code");
		lblManufcode.setBounds(0, 74, 80, 16);
		panel_3.add(lblManufcode);
		lblManufcode.setFont(new Font("Calibri", Font.BOLD, 13));
		lblManufcode.setBackground(Color.LIGHT_GRAY);
		lblManufcode.setHorizontalAlignment(SwingConstants.RIGHT);

		brandcode = new JTextField();
		brandcode.setBounds(81, 73, 80, 22);
		panel_3.add(brandcode);
		brandcode.setFont(new Font("Calibri", Font.BOLD, 14));
		brandcode.setEditable(false);
		brandcode.setColumns(10);

		brandname = new JTextField();
		brandname.setBounds(160, 73, 243, 22);
		panel_3.add(brandname);
		brandname.setFont(new Font("Calibri", Font.BOLD, 14));
		brandname.setToolTipText("Enter Brand Here");
		brandname.setColumns(10);

		JLabel lblManufcode_1 = new JLabel("Manuf.Code");
		lblManufcode_1.setBounds(0, 27, 80, 16);
		panel_3.add(lblManufcode_1);
		lblManufcode_1.setFont(new Font("Calibri", Font.BOLD, 13));
		lblManufcode_1.setHorizontalAlignment(SwingConstants.RIGHT);

		manufcode = new JTextField();
		manufcode.setBounds(81, 24, 80, 22);
		panel_3.add(manufcode);
		manufcode.setFont(new Font("Calibri", Font.BOLD, 14));
		manufcode.setText("0");
		manufcode.setToolTipText("Press Enter For Help To Assign Code");
		manufcode.setColumns(10);

		manufname = new JTextField();
		manufname.setBounds(160, 24, 243, 22);
		panel_3.add(manufname);
		manufname.setFont(new Font("Calibri", Font.BOLD, 14));
		manufname.setToolTipText("Press Enter to Get Help");
		manufname.setColumns(10);

		JLabel lblVerticle = new JLabel("Verticle");
		lblVerticle.setBounds(21, 48, 56, 16);
		panel_3.add(lblVerticle);
		lblVerticle.setFont(new Font("Calibri", Font.BOLD, 13));
		lblVerticle.setHorizontalAlignment(SwingConstants.RIGHT);

		verticlecode = new JTextField();
		verticlecode.setBounds(81, 45, 80, 22);
		panel_3.add(verticlecode);
		verticlecode.setFont(new Font("Calibri", Font.BOLD, 14));
		verticlecode.setColumns(10);

		verticlename = new JTextField();
		verticlename.setToolTipText("Press enter to select respecctive verticle<Your Business Category>");
		verticlename.setBounds(160, 45, 243, 22);
		panel_3.add(verticlename);
		verticlename.setFont(new Font("Calibri", Font.BOLD, 14));
		verticlename.setColumns(10);

		JLabel lblNewLabel = new JLabel("Company");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel.setBounds(33, 3, 56, 16);
		panel.add(lblNewLabel);

		companycode = new JTextField();
		companycode.setFont(new Font("Calibri", Font.BOLD, 14));
		companycode.setBounds(93, 1, 80, 22);
		panel.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setFont(new Font("Calibri", Font.BOLD, 14));
		companyname.setBounds(172, 1, 323, 22);
		panel.add(companyname);
		companyname.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 177, 683, 352);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 0, 683, 352);
		panel_1.add(jsp);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 145, 683, 32);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		internalFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		btnMsg = new JButton("..");
		btnMsg.setIcon(null);
		btnMsg.setEnabled(false);
		btnMsg.setForeground(Color.DARK_GRAY);
		btnMsg.setBackground(Color.CYAN);
		btnMsg.setFont(new Font("Calibri", Font.BOLD, 15));
		btnMsg.setBounds(0, 0, 493, 32);
		panel_2.add(btnMsg);

		btnSave = new JButton("Save");
		btnSave.setBounds(494, 0, 89, 32);
		panel_2.add(btnSave);
		btnSave.setMnemonic('S');
		btnSave.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApsave1.png"));
		btnSave.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApsave.png"));
		btnSave.setFont(new Font("Calibri", Font.BOLD, 15));

		btnCancel = new JButton("Close");
		btnCancel.setBounds(586, 0, 97, 32);
		panel_2.add(btnCancel);
		btnCancel.setMnemonic('C');
		btnCancel.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose1.png"));
		btnCancel.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose.png"));
		btnCancel.setFont(new Font("Calibri", Font.BOLD, 15));
		btnCancel.setForeground(Color.BLACK);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(495, 6, 188, 140);
		internalFrame.getContentPane().add(panel_4);
		panel_4.setBackground(new Color(51, 0, 153));
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pricing Policy",
				TitledBorder.CENTER, TitledBorder.TOP, null, Color.GREEN));
		panel_4.setLayout(null);

		JLabel lblMarkdown = new JLabel("MarkDown%");
		lblMarkdown.setForeground(Color.WHITE);
		lblMarkdown.setFont(new Font("Cambria", Font.BOLD, 13));
		lblMarkdown.setBounds(33, 34, 83, 16);
		panel_4.add(lblMarkdown);

		markdown = new JTextField();
		markdown.setFont(new Font("Calibri", Font.BOLD, 15));
		markdown.setText("0");
		markdown.setToolTipText("Markdown% will be used to calculate Sales Price Automatically  For MRP Base Articles");
		markdown.setBounds(116, 31, 42, 22);
		panel_4.add(markdown);
		markdown.setColumns(10);

		JLabel lblMarkup = new JLabel("MarkUp%");
		lblMarkup.setForeground(Color.WHITE);
		lblMarkup.setFont(new Font("Cambria", Font.BOLD, 13));
		lblMarkup.setBounds(43, 56, 62, 16);
		panel_4.add(lblMarkup);

		markup = new JTextField();
		markup.setFont(new Font("Calibri", Font.BOLD, 15));
		markup.setText("0");
		markup.setToolTipText(
				"Markup% will be used to calculate Sales Price Automatically for Non MRP Base Articel < Formula will be Cost+Markup% = Sales Price >");
		markup.setBounds(116, 53, 42, 22);
		panel_4.add(markup);
		markup.setColumns(10);

		JLabel lblSalesDiscount = new JLabel("Sales Discount");
		lblSalesDiscount.setForeground(Color.WHITE);
		lblSalesDiscount.setFont(new Font("Cambria", Font.BOLD, 13));
		lblSalesDiscount.setBounds(23, 79, 95, 16);
		panel_4.add(lblSalesDiscount);

		discount = new JTextField();
		discount.setFont(new Font("Calibri", Font.BOLD, 15));
		discount.setText("0");
		discount.setToolTipText("This Discount will be Apply Automatically on Sales Price while Billing ");
		discount.setBounds(116, 76, 42, 22);
		panel_4.add(discount);
		discount.setColumns(10);
		internalFrame.setVisible(true);
		ActionListener sv = new btnLsnr();

		ActionListener vert = new verticlelsnr();
		ActionListener mnf1 = new manufsnr();
		ActionListener mnf = new manufsnr();

		verticlecode.addActionListener(vert);
		manufname.addActionListener(mnf);
		manufcode.addActionListener(mnf1);
		btnCancel.addActionListener(sv);
		btnSave.addActionListener(sv);

		// ActionListener cmpcd = new Company() ;
		// ActionListener cmp = new Company() ;
		// companyname.addActionListener(cmp);
		// companycode.addActionListener(cmpcd);

		setDefault();
		showBrand();

	}

	private void setDefault() throws Throwable {
		new gnApp().setFrameTitel(frameBrand);
		frameBrand.setUndecorated(false);
		new gnField().closeform(internalFrame, frameBrand);

		vcomp = new gnConfig().getCompanyCode();
		companycode.setText(vcomp);
		companyname.setText(new gnConfig().getCompany());
		verticlecode.setText(new gnHierarchy().getVerticleCode());

		vverticle = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		String vverticlename = new getConfigurationSetting().getVerticleName(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		verticlename.setText(vverticlename);

		manufcode.setText("1");
		manufname.setText("None");

		String vuser = this.ucode;
		if (vuser == "ADMIN") {
			verticlename.setEditable(true);
			companycode.setEnabled(false);
			companycode.setEditable(false);
			companyname.setEnabled(false);
			// verticlename.setText("");
		}

	}

	class Company implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			System.out.println("Reached ");
			int i = e.getID(); // Field Id
			try {
				new gnAdmin().setcompanyAllData(companycode, companyname, companycode, companyname, companycode,
						companyname, companycode, companyname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				companycode.setText(new gnAdmin().rcompcode);
				companyname.setText(new gnAdmin().rcompname);
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
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				try {
					showBrand();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private void show() throws Throwable {
		String vname = manufname.getText();
		vname = "%" + vname + "%";
		String vverticle = verticlecode.getText();
		String vsegment = new gnHierarchy().getSegmentCode();
		String vcomp = companycode.getText();
		String SQL = "Call ms_getManuf('" + vname + "' , " + vsegment + " , " + vverticle + " , " + vcomp + " )";
		String Manuf[] = { "Type ", "Manuf.Code", "Name ", "VerticleCode", "Verticle Name" };
		String Type = "Manuf";
		// new General().msg(SQL);
		showData(SQL, Manuf, Type);
		btnMsg.setText("<Help For Manufacturar  Press Enter and get Help >");
	}

	private void showBrand() throws Throwable {
		String vname = brandname.getText();
		vname = "%" + vname + "%";
		String vvert = verticlecode.getText();
		String vmanuf = manufcode.getText();
		String SQL = "Call ms_getOnlyBrand('" + vname + "' ,  " + vverticle + ")";
		String brnd[] = { "Type ", "Brand Code", "Name ", "Manuf_code", "VerticleCode", "Verticle Name", "Markup%",
				"MarkDown%", "Sales Discount%" };
		String Type = "Brand";
		showData(SQL, brnd, Type);
		btnMsg.setText(" Create new brand if not available ");
	}

	class manufsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				show();
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class btnLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (value == "Close") {
				frameBrand.dispose();
			}

			if (value == "Save") {
				try {
					prepareToInsert();
				} catch (SQLException e1) {
					new General().msg("Messgae:" + e1.getMessage());
					btnMsg.setText("Data Save Sucessfully");
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private void showData(String sql, String[] manuf, String Type)
			throws SQLException, ClassNotFoundException, ParserConfigurationException {
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(manuf);
		String vname = Type;
		rs = this.getSPResult(sql);
		if (rs.next()) {
			if (Type == "Manuf") {
				while (rs.next()) {
					model.addRow(
							new Object[] { vname, rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
					table.setModel(model);
					new gnTable().setTableColWidth(table, 3, 30);
				}
			}
			if (Type == "Brand") {
				while (rs.next()) {
					model.addRow(new Object[] { vname, rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
					table.setModel(model);
					new gnTable().setTableColWidth(table, 3, 50);
				}
			}
			table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification9);
			table.setGridColor(Color.yellow);
			table.setBackground(Color.DARK_GRAY);
			table.setForeground(Color.WHITE);
			JViewport prt = new JViewport();
			prt.add(table, manuf);
			prt.setVisible(true);
			jsp.setViewport(prt);
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
		case "Manuf":
			verticlecode.setText(table.getValueAt(row, 3).toString());
			verticlename.setText(table.getValueAt(row, 4).toString());
			manufcode.setText(table.getValueAt(row, 1).toString());
			manufname.setText(table.getValueAt(row, 2).toString());
			break;
		}
	}

	private void prepareToInsert() throws Throwable {
		String status = "Fail";
		status = validate();
		if (status == "Sucess") {
			if (companycode.getText().length() > 1) {
				// brandcode.setText( new gnSeq().getSeqno("902", "MS")) ;
				brandcode.setText(new gnSeq().getBrandSeq());
				insertDataforCompany();
				brandname.setText(null);
				brandcode.setText(null);
				markup.setText("0");
				markdown.setText("0");
				discount.setText("0");
				showBrand();
			}
		}
	}

	private String validate() {
		String status = "Sucess";
		if (verticlename.getText().length() == 0) {
			new General().msg("Select Proper Verticle ..");
			status = "Fail";
			verticlename.grabFocus();
		}
		if (manufname.getText().length() == 0) {
			new General().msg("Select Manuf. Details..");
			status = "Fail";
			manufname.grabFocus();
		}

		if (brandname.getText().length() == 0) {
			new General().msg("Enter Brand Name ..");
			status = "Fail";
			brandname.grabFocus();
		}
		return status;
	}

	public void insertDataforCompany() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String hie = "Insert into ms_brand_master(brand_code , "
				+ "Name, manuf_code, Verticlecode ,verticlename, markup, markdown, discount_per , company_code) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(hie);
			prst.setString(1, brandcode.getText());
			prst.setString(2, brandname.getText());
			prst.setString(3, manufcode.getText());
			prst.setString(4, verticlecode.getText());
			prst.setString(5, verticlename.getText());
			prst.setString(6, markup.getText());
			prst.setString(7, markdown.getText());
			prst.setString(8, discount.getText());
			prst.setString(9, "0");
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
			status = "Sucess";
		} catch (SQLException e) {
			new General().msg(e.getMessage() + "<: Brand Entry Level>");
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
				// new gnSeq().updateSeqno("902", "MS") ;
				new General().msg(" Data Save Sucessfully");
			}
		}
	}

	public void insertDataforStandard() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String hie = "Insert into ms_brand_master(brand_code , "
				+ "Name, manuf_code, Verticlecode ,verticlename, markup, markdown, discount_per , company_code) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(hie);
			prst.setString(1, brandcode.getText());
			prst.setString(2, brandname.getText());
			prst.setString(3, manufcode.getText());
			prst.setString(4, verticlecode.getText());
			prst.setString(5, verticlename.getText());
			prst.setString(6, "0");
			prst.setString(7, "0");
			prst.setString(8, "0");
			prst.setString(9, "0");
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
			}
		}
	}

}// last

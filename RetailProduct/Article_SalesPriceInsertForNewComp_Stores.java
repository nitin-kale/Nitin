package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Article_SalesPriceInsertForNewComp_Stores extends getResultSet {

	JFrame frameSalespriceInsert;
	private JTextField df_companycode;
	private JTextField df_companyname;
	private JTextField df_verticlecode;
	private JTextField df_verticlename;
	private JTextField df_segmentcode;
	private JTextField df_segmentname;
	private JTextField df_hno;
	private JTextField df_hname;
	private JPanel panel_2;
	private JButton BtnAll;
	private JButton btnSave;
	private JButton btnCancel;

	private JScrollPane jsp;
	public DefaultTableModel model = new DefaultTableModel();
	public JTable table = new JTable();

	// For Stores Selections //
	private JScrollPane sjsp;
	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public String store[] = { "Select", "Store Code", "Name", "Verticle", "Segment", "State", "Country", "City" };

	// End Stores

	public String Col[] = { "Type", "Company code", "Name", "Store Code", "Store Name", "Title", "Count", "Status" };
	public JViewport prt6 = new JViewport();
	private JTextField df_state;
	private JLabel msg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Article_SalesPriceInsertForNewComp_Stores window = new Article_SalesPriceInsertForNewComp_Stores();
					window.frameSalespriceInsert.setVisible(true);
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
	public Article_SalesPriceInsertForNewComp_Stores() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frameSalespriceInsert = new JFrame();
		frameSalespriceInsert.setResizable(false);
		frameSalespriceInsert.setAlwaysOnTop(true);
		frameSalespriceInsert.setBounds(10, 30, 1325, 675);
		frameSalespriceInsert.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1319, 139);
		panel.setBorder(UIManager.getBorder("DesktopIcon.border"));
		frameSalespriceInsert.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 492, 136);
		panel_1.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
				"Select Company  For Sales Price Insert", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 153)));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Compnay");
		lblNewLabel.setBounds(12, 20, 56, 16);
		panel_1.add(lblNewLabel);

		JLabel verticlecode = new JLabel("Verticle");
		verticlecode.setBounds(12, 43, 56, 16);
		panel_1.add(verticlecode);
		verticlecode.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel_1 = new JLabel("segment");
		lblNewLabel_1.setBounds(12, 63, 56, 16);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel_2 = new JLabel("Hierarchy");
		lblNewLabel_2.setBounds(12, 83, 56, 16);
		panel_1.add(lblNewLabel_2);

		df_hno = new JTextField();
		df_hno.setBounds(72, 80, 66, 22);
		panel_1.add(df_hno);
		df_hno.setEditable(false);
		df_hno.setColumns(10);

		df_segmentcode = new JTextField();
		df_segmentcode.setBounds(72, 60, 66, 22);
		panel_1.add(df_segmentcode);
		df_segmentcode.setEditable(false);
		df_segmentcode.setColumns(10);

		df_verticlecode = new JTextField();
		df_verticlecode.setEnabled(false);
		df_verticlecode.setEditable(false);
		df_verticlecode.setBounds(72, 40, 66, 22);
		panel_1.add(df_verticlecode);
		df_verticlecode.setColumns(10);

		df_companycode = new JTextField();
		df_companycode.setBounds(72, 17, 64, 22);
		df_companycode.setEditable(false);
		df_companycode.setEnabled(false);
		panel_1.add(df_companycode);
		df_companycode.setColumns(10);
		ActionListener dfcomp = new df_Company();
		df_companycode.addActionListener(dfcomp);

		df_companyname = new JTextField();
		df_companyname.setEditable(false);
		df_companyname.setBounds(139, 17, 341, 22);
		panel_1.add(df_companyname);
		df_companyname.setColumns(10);
		df_companycode.setEditable(false);
		df_companycode.setEnabled(false);

		df_verticlename = new JTextField();
		df_verticlename.setEditable(false);
		df_verticlename.setBounds(139, 40, 341, 22);
		panel_1.add(df_verticlename);
		df_verticlename.setColumns(10);

		df_segmentname = new JTextField();
		df_segmentname.setEditable(false);
		df_segmentname.setBounds(139, 60, 341, 22);
		panel_1.add(df_segmentname);
		df_segmentname.setColumns(10);

		df_hname = new JTextField();
		df_hname.setEditable(false);
		df_hname.setBounds(139, 80, 341, 22);
		panel_1.add(df_hname);
		df_hname.setColumns(10);

		df_state = new JTextField();
		df_state.setForeground(new Color(0, 0, 153));
		df_state.setEnabled(false);
		df_state.setEditable(false);
		df_state.setColumns(10);
		df_state.setBounds(71, 106, 409, 18);
		panel_1.add(df_state);

		JLabel lblNewLabel_8 = new JLabel("State");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(12, 107, 56, 16);
		panel_1.add(lblNewLabel_8);

		panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(102, 255, 204), null, null, null),
						"Select Stores For Sales Price Insert", TitledBorder.CENTER, TitledBorder.TOP, null,
						new Color(0, 0, 153)));
		panel_2.setBounds(493, 0, 492, 136);
		panel.add(panel_2);
		panel_2.setLayout(null);

		sjsp = new JScrollPane();
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(4, 24, 488, 110);
		panel_2.add(sjsp);

		BtnAll = new JButton("Insert Data");
		BtnAll.setMnemonic('I');
		BtnAll.setBounds(1093, 111, 136, 25);
		panel.add(BtnAll);
		ActionListener btnpress = new btn();
		BtnAll.addActionListener(btnpress);

		btnCancel = new JButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.setBounds(1232, 111, 87, 25);
		btnCancel.addActionListener(btnpress);
		panel.add(btnCancel);

		msg = new JLabel("--");
		msg.setBounds(997, 31, 284, 16);
		panel.add(msg);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 139, 1319, 503);
		frameSalespriceInsert.getContentPane().add(jsp);
		Decorate();
	}

	private void Decorate() throws Throwable {
		new gnApp().setFrameTitel(frameSalespriceInsert);
		new gnDecorate().DispField_Eatch(df_companyname, 20);
		new gnDecorate().DispField_Eatch(df_companycode, 20);
		new gnDecorate().DispField_Eatch(df_verticlecode, 20);
		new gnDecorate().DispField_Eatch(df_verticlename, 20);
		new gnDecorate().DispField_Eatch(df_segmentcode, 20);
		new gnDecorate().DispField_Eatch(df_segmentname, 20);
		new gnDecorate().DispField_Eatch(df_state, 20);
		new gnDecorate().DispField_Eatch(df_hno, 20);
		new gnDecorate().DispField_Eatch(df_hname, 20);
		new gnApp().setFrameTitel(frameSalespriceInsert);
		;
		String vcomp = new gnConfig().getCompanyCode();
		df_companycode.setText(vcomp);
		df_companyname.setText(new gnConfig().getCompany());
		df_segmentcode.setText(new gnHierarchy().getSegmentCode());
		df_segmentname.setText(new gnHierarchy().getSegmentName());
		df_verticlecode.setText(new gnHierarchy().getVerticleCode());
		df_verticlename.setText(new gnHierarchy().getVerticleName());
		df_hno.setText(new gnHierarchy().getHierarchyNo());
		df_hname.setText(new gnHierarchy().getHierarchyName());
		switch (vcomp) {
		case "0":
			df_companycode.setEditable(true);
			df_companycode.setEnabled(true);
			break;
		}
		showdata();
	}

	class df_Company implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			System.out.println("Reached ");
			int i = e.getID(); // Field Id
			try {
				new gnAdmin().setcompanyAllData(df_companycode, df_companyname, df_segmentcode, df_segmentname,
						df_verticlecode, df_verticlename, df_hno, df_hname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				String vdfcompcode = df_companycode.getText();
				if (vdfcompcode != "0") {
					df_verticlecode.setEnabled(false);
					df_verticlecode.setEditable(false);
					df_state.setText("");
				}
				switch (vdfcompcode) {
				case "0":
					df_verticlecode.setEnabled(true);
					// df_verticlecode.setEditable(true);
					df_state.setText("No State");
					break;
				}
				try {
					showdata();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private void showdata() throws ClassNotFoundException, SQLException {
		String vdfcompcode = df_companycode.getText();
		Action();
		String vtype = "Stores";
		String Sql1 = "Call tb_getAllSite(" + vdfcompcode + ")";
		showStores(Sql1, store, vtype);

	}

	class btn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			System.out.println("Reached ");
			System.out.println(value);
			String status = "Sucess";
			if (value == "Cancel") {
				frameSalespriceInsert.dispose();
			}

			if (value == "Insert Data") {
				msg.setText("Data Upload Will Take Some Time");
				status = validate();
				if (status == "Sucess") {
					try {
						PrepareToInsert();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	}

	private String validate() {
		// new General().msg("Validating ...");
		String status = "Sucess";
		String vdf_verticle = df_verticlecode.getText().trim();
		String vdf_compcode = df_companycode.getText().trim();
		if (vdf_compcode == "0") {
			new General().msg("Default Company Can Not Allow for Sales Price Entry ..");
			status = "Fail";
		}

		int article = table.getRowCount();
		int stores = stable.getRowCount();
		if (stores == 0) {
			new General().msg("No Stores Are Available ..check Stores Ares Created For This Company or not");
			status = "Fail";
		}

		if (article == 0) {
			new General().msg("No Articles Are Availabe .. check Article Are Created For This Compnay Or Not ");
			status = "Fail";
		}

		return status;
	}

	private void Action() throws ClassNotFoundException, SQLException {
		int option = new General()
				.msgInput("Data Will Be Copy From Source Compnay and Verticle To New compnay, Are You Sure ?");
		if (option == 0) {
			String vdfcomp = df_companycode.getText();
			String vdfverticle = df_verticlecode.getText();
			String SQL5 = "Call Article_showNewcompanyREcords(" + vdfcomp + " , " + vdfverticle + ")";
			String Col[] = { "Type", "Company_Code", "Company_Name", "Verticle", "Article_Code", "Name", "POS_NAME",
					"Tax_code", "Tax_per", "Markup", "MarkDown", "Margin", "Cost", "Mrp", "SalesPrice", "Basecost",
					"Basemrp", "Basesp" };
			String vtype = "ArticleCopy";
			showTable(SQL5, Col, vtype);
		}
	}

	private void showStores(String SQL, String store[], String vtype) throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(smodel);
		smodel.setColumnIdentifiers(store);
		rs = this.getSPResult(SQL);
		stable.setModel(smodel);
		stable.setBackground(Color.BLUE);
		stable.setForeground(Color.WHITE);
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, store, 7, "Y", "Y", vtype);
		new gnTable().AddCheckBoxToTable(smodel, stable, 0);
		stable.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
		new gnTable().setTableColWidth(stable, 1, 50);
		new gnTable().setTableColWidth(stable, 2, 300);
		JViewport prt1 = new JViewport();
		prt1.add(stable, store);
		prt1.setVisible(true);
		sjsp.setViewport(prt1);

		int row = stable.getRowCount();
		for (int i = 0; i < row; i++) {
			stable.setValueAt("Y", i, 0);
		}
	}

	private void showTable(String SQL, String Col[], String vtype) throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(Col);
		rs = this.getSPResult(SQL);
		table.setModel(model);
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 17, "N", "Y", vtype);
		new gnTable().setTableColWidth(table, 1, 100);
		new gnTable().setTableColWidth(table, 2, 200);
		new gnTable().setTableColWidth(table, 5, 300);
		new gnTable().setTableColWidth(table, 6, 200);
		new gnTable().setTableBasics(table);
		JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(table, Col);
		prt.setVisible(true);
		jsp.setViewport(prt);
	}

	private void PrepareToInsert() throws ClassNotFoundException, SQLException {
		int row = stable.getRowCount();
		String Allow = " ";
		String vstore = " ";
		for (int i = 0; i < row; i++) {
			Allow = stable.getValueAt(i, 0).toString();
			if (Allow == null) {
				new General().msg("Select Stores for Price Upload ");
			}

			if (Allow == "Y") {
				vstore = stable.getValueAt(i, 1).toString();
				String vcomp = df_companycode.getText();
				insertSalesPrice(vcomp, vstore);
			}

		}
	}

	private void insertSalesPrice(String vcomp, String vstore) throws ClassNotFoundException, SQLException {

		String vstartDate = new General().getDate();
		vstartDate = new gnConfig().date_ConverttoDBforamt(vstartDate);

		String SQL7 = "call  SalesPrice_updateInsert(" + vcomp + ", " + vstore + ")";
		// msg.setText("Data Uplaoding for Store ..wait.."+" "+vstore);
		this.getSPResult(SQL7);

		// Sync Stock in Tablle for Article master
		String vloc = "SL";
		String SQL5 = "call  Stock_syncStockArticle(" + vcomp + ", '" + vloc + "')";
		// msg.setText("Data Sync is in Progress for Store.."+" "+vstore);
		this.getSPResult(SQL5);
		// Sync Stock in Tablle for Article master

		new gnTable().RemoveTableRows(model);
		new General().msg("New Article Sales Price Inserted For Stores...");
		// msg.setText("Data Uploaded Sucessfully for" +" "+vstore);

	}

}// Last

package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

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
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class BulkConvesionTeamplate extends getResultSet {

	JFrame frmBullkConversion;
	private JTextField scanItem;

	public DefaultTableModel model = new DefaultTableModel();
	public DefaultTableModel pmodel = new DefaultTableModel();
	public JTable table = new JTable();
	public JTable ptable = new JTable();
	public JScrollPane jsp;
	public JScrollPane pjsp;
	public java.sql.PreparedStatement prst = null;
	/// TAble columns
	public String Col[] = { "Article_code", "name", "UOM", "Trading_Article", "Cost", "SalesPrice", "Article_type",
			"MarkDown", "Markup", "Active" };
	public String[] BCol = { "Article_code ", "name", "Qty", "UOM", "SalesPrice" };
	private JTextField BulkArticle_name;
	private JTextField consumeqty;
	private JTextField uom;
	private JTextField pksize;
	private JTextField processloss;

	//// Save Data to DB for that Require all Variable
	public String vparentcode;
	public String vbulkarticlename;
	public String vparenetuom;
	public Double vprocessloss;
	public Double vconsumeqty;

	// Declare variable to collect table data

	public String vchildarticle;
	public String vchildname;
	public Double vchildqty;
	public String vchilduom;
	public int TotalRecordinsert = 0;

	//// End Save part

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BulkConvesionTeamplate window = new BulkConvesionTeamplate();
					window.frmBullkConversion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BulkConvesionTeamplate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBullkConversion = new JFrame();
		frmBullkConversion.setType(Type.UTILITY);
		frmBullkConversion.setAlwaysOnTop(true);
		frmBullkConversion.setTitle("Business Application");
		frmBullkConversion.setBounds(350, 150, 617, 500);
		frmBullkConversion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBullkConversion.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 800, 450);
		frmBullkConversion.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Bulk Conversion Master");
		internalFrame.setBounds(0, 0, 800, 450);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel Hpanel = new JPanel();
		Hpanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, null, Color.RED, null));
		Hpanel.setBounds(0, 0, 580, 93);
		internalFrame.getContentPane().add(Hpanel);
		Hpanel.setLayout(null);

		JLabel lblBulkArticleCode = new JLabel("Bulk Article Code");
		lblBulkArticleCode.setBounds(12, 13, 113, 16);
		Hpanel.add(lblBulkArticleCode);

		scanItem = new JTextField();
		scanItem.setToolTipText("Enter Bulk Article code Or Enter Name and Press Search Button");
		scanItem.setBounds(114, 9, 69, 24);
		Hpanel.add(scanItem);
		scanItem.setColumns(10);
		ActionListener lk = new btnlsnr();
		scanItem.addActionListener(lk);

		JButton btnNewButton = new JButton("B1");
		btnNewButton.setIcon(new ImageIcon("D:\\JAVA\\myProductImage\\search.png"));
		btnNewButton.setBounds(184, 9, 35, 25);
		Hpanel.add(btnNewButton);

		BulkArticle_name = new JTextField();
		BulkArticle_name.setBounds(114, 36, 240, 24);
		Hpanel.add(BulkArticle_name);
		BulkArticle_name.setColumns(10);

		consumeqty = new JTextField();
		consumeqty.setToolTipText("Enter Qty Needs to consume to produce Child Article");
		consumeqty.setBounds(114, 60, 74, 20);
		Hpanel.add(consumeqty);
		consumeqty.setColumns(10);

		JLabel lblConsumeParent = new JLabel("Consume Parent");
		lblConsumeParent.setBounds(12, 62, 102, 16);
		Hpanel.add(lblConsumeParent);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(46, 40, 56, 16);
		Hpanel.add(lblName);

		uom = new JTextField();
		uom.setEditable(false);
		uom.setBounds(244, 59, 56, 22);
		Hpanel.add(uom);
		uom.setColumns(10);

		JLabel lblUom = new JLabel("UOM");
		lblUom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUom.setBounds(184, 62, 48, 16);
		Hpanel.add(lblUom);

		JLabel lblPackSize = new JLabel("Pack Size");
		lblPackSize.setBounds(312, 62, 56, 16);
		Hpanel.add(lblPackSize);

		pksize = new JTextField();
		pksize.setEditable(false);
		pksize.setBounds(376, 59, 56, 22);
		Hpanel.add(pksize);
		pksize.setColumns(10);

		JLabel lblProcessLossPercentage = new JLabel("Process Loss Percentage");
		lblProcessLossPercentage.setBounds(231, 13, 149, 16);
		Hpanel.add(lblProcessLossPercentage);

		processloss = new JTextField();
		processloss.setToolTipText("Enter Process Loss Percentage ");
		processloss.setBounds(376, 10, 56, 22);
		Hpanel.add(processloss);
		processloss.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(471, 58, 97, 25);
		Hpanel.add(btnSave);
		ActionListener kk = new btnlsnr();
		btnSave.addActionListener(kk);

		JPanel Apanel = new JPanel();
		Apanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, Color.GREEN, null, null));
		Apanel.setBounds(0, 93, 580, 321);
		internalFrame.getContentPane().add(Apanel);
		Apanel.setLayout(null);

		JScrollPane jsp_1 = new JScrollPane();
		jsp_1.setBounds(0, 13, 578, 188);
		Apanel.add(jsp_1);
		jsp_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JViewport prt = new JViewport();
		prt.add(table, BCol);
		prt.setVisible(true);
		jsp_1.setViewport(prt);

		JScrollPane pjsp_1 = new JScrollPane();
		pjsp_1.setBounds(0, 203, 580, 118);
		Apanel.add(pjsp_1);
		pjsp_1.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, null));
		pjsp_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pjsp_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.WHITE);
		prt1.add(ptable, Col);
		prt1.setVisible(true);
		pjsp_1.setViewport(prt1);

		internalFrame.setVisible(true);
	}

	public void getBulkArticleName() throws SQLException, ClassNotFoundException {
		String vbulk = scanItem.getText();
		String Sql1 = "Call  GetScanArticleOnlyName(" + vbulk + ")";
		rs = this.getSPResult(Sql1);
		rs.next();
		BulkArticle_name.setText(rs.getString(1));
		pksize.setText(rs.getString(2));
		uom.setText(rs.getString(3));

	}

	public void showTableBulk(String SQLGetConfig, String type, String[] Colnames) throws Throwable {
		new gnTable().RemoveTableRows(pmodel);
		rs = this.getSPResult(SQLGetConfig);
		pmodel.setColumnIdentifiers(Colnames);
		while (rs.next()) {
			pmodel.addRow(
					new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10) });
			ptable.setModel(pmodel);
			new gnTable().setTablewidth(ptable, 1, 300);
			new gnTable().setTablewidth(ptable, 2, 50);
			new gnTable().setTablewidth(ptable, 3, 50);
		}
		this.closeconn();
		ptable.setEnabled(true);
		ptable.setCellSelectionEnabled(false);
		ptable.setRowSelectionAllowed(true);
		ptable.setGridColor(Color.gray);
		ptable.getColumnModel().getColumn(1).setPreferredWidth(300);
		ptable.getColumnModel().getColumn(3).setPreferredWidth(100);
		// table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
	}// End Show Table

	public void showTable(String SQLGetConfig, String[] BCol) throws SQLException, ClassNotFoundException {
		new gnTable().RemoveTableRows(model);
		rs = this.getSPResult(SQLGetConfig);
		model.setColumnIdentifiers(BCol);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5) });
			table.setModel(model);
			new gnTable().setTablewidth(table, 1, 300);
			new gnTable().setTablewidth(table, 2, 50);
			new gnTable().setTablewidth(table, 3, 50);
		}
		this.closeconn();
		table.setEnabled(true);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.gray);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		// table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
	}// End Show Table

	public void SaveData() throws ClassNotFoundException, SQLException, IOException {
		// Step 1 get all Enter Data As per Table Structure
		// header Data and user enter data in textfields
		// collect Header Field in variables

		vparentcode = scanItem.getText();
		vbulkarticlename = BulkArticle_name.getText();
		vparenetuom = uom.getText();
		vprocessloss = Double.parseDouble(processloss.getText().toString());
		vconsumeqty = Double.parseDouble(consumeqty.getText().toString());

		int row = table.getRowCount();
		if (row > 0)

			for (int i = 0; i < row; i++) {
				vchildarticle = table.getValueAt(i, 0).toString();
				vchildname = table.getValueAt(i, 1).toString();
				vchildqty = Double.parseDouble(table.getValueAt(i, 2).toString());
				vchilduom = table.getValueAt(i, 3).toString();
				// new General().msg(vchildarticle+vchildname+vchilduom) ;
				Insert_into_DB_BulkConverion();
			}
	}

	public void Insert_into_DB_BulkConverion() throws ClassNotFoundException, SQLException, IOException {
		// Connection con ;
		// Connection con = this.getConnection();
		prst = null;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String SQL = "INSERT INTO bulk_conversion_template" + "(Parenet_code, parent_name, consume_qty, "
				+ "Parenet_UOM, process_loss, ChildArticlecode, child_name,Product_qty,UOM) VALUES"
				+ "(?,?,?,?,?,?,?,?,?)";
		try {

			prst = con.prepareStatement(SQL);
			prst.setString(1, vparentcode);
			prst.setString(2, vbulkarticlename);
			prst.setDouble(3, vconsumeqty);
			prst.setString(4, vparenetuom);
			prst.setDouble(5, vprocessloss);
			prst.setString(6, vchildarticle);
			prst.setString(7, vchildname);
			prst.setDouble(8, vchildqty);
			prst.setString(9, vchilduom);

			int count = prst.executeUpdate();
			TotalRecordinsert = TotalRecordinsert + 1;
			con.commit();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con.rollback();
		} finally {
			if (prst != null) {
				prst.close();
				new General().msg("Total Record inseted is " + TotalRecordinsert);
			}
			if (con != null) {
				con.close();
			}

		}

	}// n

	class btnlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value     :" + value);

			if (value == "Save") {
				try {
					SaveData();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			if (i == 1001) // This for to populate all child article when
							// parenet is enter on enter key event
			{
				String name = scanItem.getText();
				String sql1 = "Call  Bulk_GetAllChildCode(" + name + ")";
				try {
					showTable(sql1, BCol);
					getBulkArticleName();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			if (value == "B1") {
				String sql = "Call  Bulk_GetAllBulkCode()";
				String name = "Bulk";
				try {
					showTableBulk(sql, name, Col);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
}// Last

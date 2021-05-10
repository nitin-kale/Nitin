package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class MBQ_Dynamic_Generation extends getResultSet {

	JFrame mbqframe;
	java.sql.Connection con1;
	JLabel storecode;
	JPanel leftPanel;
	JPanel rightPanel;
	JScrollPane jsp;
	JRadioButton rb1;
	JRadioButton rb2;
	JButton btnCalculate;
	boolean rbchoice;
	String rbname;
	String vbrand;
	String vname;

	private JTextField QuickSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel_1;
	private JTextField fromdate;
	private JTextField todate;

	public DefaultTableModel mmodel = new DefaultTableModel();
	public JTable mtable = new JTable();

	String vcomp;
	String vstore;
	String vstorename;
	private JTextField records;
	private JLabel label;
	private JTextField mbq;
	private JLabel label_1;
	private JTextField rop;
	private JLabel label_2;
	private JTextField dayscover;
	private JLabel label_3;
	JRadioButton rbch1;
	JRadioButton rbch2;
	String DBdetail;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField brandname;
	private JTextField brandcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MBQ_Dynamic_Generation window = new MBQ_Dynamic_Generation();
					window.mbqframe.setVisible(true);
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
	public MBQ_Dynamic_Generation() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		mbqframe = new JFrame();
		mbqframe.getContentPane().setBackground(new Color(0, 255, 255));
		mbqframe.setBounds(1, 1, 1350, 750);
		mbqframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mbqframe.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(0, 27, 453, 61);
		mbqframe.getContentPane().add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBounds(0, 0, 449, 61);
		panel.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Enter Dates For Sales Period", TitledBorder.CENTER, TitledBorder.TOP,
				null, new Color(128, 0, 0)));
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("From");
		lblNewLabel_3.setBounds(49, 25, 34, 16);
		panel_1.add(lblNewLabel_3);

		fromdate = new JTextField();
		fromdate.setBounds(79, 19, 122, 28);
		panel_1.add(fromdate);
		fromdate.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("To");
		lblNewLabel_4.setBounds(220, 25, 25, 16);
		panel_1.add(lblNewLabel_4);

		todate = new JTextField();
		todate.setBounds(242, 19, 122, 28);
		panel_1.add(todate);
		todate.setColumns(10);

		btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(353, 19, 90, 28);
		panel_1.add(btnCalculate);
		btnCalculate.setMnemonic('C');

		JLabel lblNewLabel = new JLabel("Dynamic Generation Of Max Required Stock Calculation");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel.setBounds(0, 0, 1332, 26);
		mbqframe.getContentPane().add(lblNewLabel);

		leftPanel = new JPanel();
		leftPanel.setBackground(new Color(255, 255, 224));
		leftPanel.setBounds(29, 1, 1103, 610);
		// mbqframe.getContentPane().add(leftPanel);
		leftPanel.setLayout(null);

		rightPanel = new JPanel();
		rightPanel.setBackground(new Color(0, 255, 255));
		rightPanel.setBounds(200, 93, 1103, 610);
		// mbqframe.getContentPane().add(rightPanel);
		rightPanel.setLayout(null);

		JSplitPane mySplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);

		jsp = new JScrollPane();
		jsp.setToolTipText("Item Wise Avg Sales and MBQ");
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(12, 20, 1145, 584);
		rightPanel.add(jsp);

		JLabel lblNewLabel_5 = new JLabel("Records");
		lblNewLabel_5.setBounds(568, 6, 55, 16);
		rightPanel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 12));

		records = new JTextField();
		records.setBounds(617, 0, 122, 28);
		rightPanel.add(records);
		records.setFont(new Font("SansSerif", Font.BOLD, 13));
		records.setBackground(Color.CYAN);
		records.setColumns(10);

		rb1 = new JRadioButton("Brand");
		rb1.setForeground(new Color(0, 0, 102));
		buttonGroup.add(rb1);
		rb1.setBackground(new Color(255, 255, 224));
		rb1.setBounds(8, 38, 127, 25);
		leftPanel.add(rb1);

		rb2 = new JRadioButton("All Articles");
		rb2.setForeground(new Color(0, 0, 102));
		buttonGroup.add(rb2);
		rb2.setBackground(new Color(255, 255, 224));
		rb2.setBounds(8, 68, 127, 25);
		leftPanel.add(rb2);

		QuickSearch = new JTextField();
		QuickSearch.setFont(new Font("Calibri", Font.BOLD, 14));
		QuickSearch.setBounds(1, 156, 149, 25);
		leftPanel.add(QuickSearch);
		QuickSearch.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(0, 118, 149, 9);
		leftPanel.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Search By Name");
		lblNewLabel_1.setBounds(0, 140, 149, 16);
		leftPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("View Data Option");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel_2.setBounds(0, 0, 149, 16);
		leftPanel.add(lblNewLabel_2);
		mySplit.setBounds(10, 93, 1300, 612);
		mySplit.setDividerLocation(150);
		mbqframe.getContentPane().add(mySplit);

		storecode = new JLabel("Branch");
		storecode.setBounds(0, 8, 241, 18);
		mbqframe.getContentPane().add(storecode);

		label = new JLabel("Max Stock ");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Calibri", Font.BOLD, 15));
		label.setBounds(601, 30, 72, 16);
		mbqframe.getContentPane().add(label);

		mbq = new JTextField();
		mbq.setToolTipText("Max Stock Required for Required Days Cover");
		mbq.setColumns(10);
		mbq.setBounds(677, 27, 72, 22);
		mbqframe.getContentPane().add(mbq);

		label_1 = new JLabel("ROP");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Calibri", Font.BOLD, 15));
		label_1.setBounds(617, 48, 56, 16);
		mbqframe.getContentPane().add(label_1);

		rop = new JTextField();
		rop.setToolTipText("Stock Reorder Point ");
		rop.setColumns(10);
		rop.setBounds(677, 45, 72, 22);
		mbqframe.getContentPane().add(rop);

		label_2 = new JLabel("Stock Days Cover");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(563, 69, 120, 16);
		mbqframe.getContentPane().add(label_2);

		dayscover = new JTextField();
		dayscover.setColumns(10);
		dayscover.setBounds(677, 66, 72, 22);
		mbqframe.getContentPane().add(dayscover);

		label_3 = new JLabel("Days");
		label_3.setBounds(757, 69, 56, 16);
		mbqframe.getContentPane().add(label_3);

		rbch1 = new JRadioButton("Apply to Selectd Record");
		buttonGroup_1.add(rbch1);
		rbch1.setForeground(Color.BLACK);
		rbch1.setFont(new Font("Calibri", Font.BOLD, 15));
		rbch1.setBounds(814, 27, 175, 25);
		mbqframe.getContentPane().add(rbch1);

		rbch2 = new JRadioButton("Apply to All");
		buttonGroup_1.add(rbch2);
		rbch2.setForeground(Color.BLACK);
		rbch2.setFont(new Font("Calibri", Font.BOLD, 15));
		rbch2.setBounds(814, 55, 127, 25);
		mbqframe.getContentPane().add(rbch2);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Calibri", Font.BOLD, 14));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setMnemonic('S');
		btnSave.setBounds(999, 53, 90, 35);
		mbqframe.getContentPane().add(btnSave);

		brandname = new JTextField();
		brandname.setBounds(1101, 27, 116, 22);
		mbqframe.getContentPane().add(brandname);
		brandname.setColumns(10);

		brandcode = new JTextField();
		brandcode.setBounds(1101, 66, 116, 22);
		mbqframe.getContentPane().add(brandcode);
		brandcode.setColumns(10);

		ActionListener dt1 = new fromdateLsnr();
		ActionListener dt2 = new todateLsnr();
		fromdate.addActionListener(dt1);
		todate.addActionListener(dt2);

		ActionListener btnls = new btnLsnr();
		btnCalculate.addActionListener(btnls);
		btnSave.addActionListener(btnls);

		ActionListener srch = new SearchLsnr();
		QuickSearch.addActionListener(srch);

		ActionListener rbch = new rbchLsnr();
		rbch1.addActionListener(rbch);
		rbch2.addActionListener(rbch);

		ActionListener rb = new rbLsnr();
		rb1.addActionListener(rb);
		rb2.addActionListener(rb);

		decorate();

	}

	private void decorate() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vstorename = new gnConfig().getStorename(vstore);
		storecode.setText(vstorename);
	}

	class rbLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			rbname = "";
			rbchoice = rb1.isSelected();
			if (rbchoice) {
				rbname = "Brand";
				try {
					searchBrand();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				rbname = "ALL";
				new General().msg(rbname);
			}
			performAction();
		}
	}

	private void searchBrand() throws Throwable {
		String sname = QuickSearch.getText();
		sname = "%" + sname + "%";
		try {

			// new gnBrand().getBrandInfo(sname);
			String vtype = "Brand";
			new gnAdmin().showMasterTable(vtype, brandcode, brandname);
		} catch (Exception e) {

		} finally {
			// vbrand = new gnBrand().rbrandcode;
			vbrand = brandcode.getText();
		}
	}

	private void performAction() {
		String vtype = " ";
		String SQL = "";
		switch (rbname) {
		case "Brand":
			vtype = rbname;
			vname = " ";
			SQL = "Call  MBQ_showData(" + vcomp + "  , " + vstore + " , '" + vtype + "' ,  '" + vbrand + "'  , '"
					+ vname + "')";
			break;
		case "ALL":
			vbrand = "0";
			vtype = rbname;
			vname = " ";
			SQL = "Call  MBQ_showData(" + vcomp + "  , " + vstore + " , '" + vtype + "' ,  '" + vbrand + "'  , '"
					+ vname + "')";
			break;
		case "Search":
			vbrand = "0";
			vtype = rbname;
			vname = QuickSearch.getText();
			vname = "%" + vname + "%";
			SQL = "Call  MBQ_showData(" + vcomp + "  , " + vstore + " , '" + vtype + "' ,  '" + vbrand + "'  , '"
					+ vname + "')";
			break;
		}
		try {
			// new General().msg(SQL);
			showData(SQL);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			new General().msg(e.getLocalizedMessage());
		}
	}

	class rbchLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			rbname = "";
			boolean rbchoice = rbch1.isSelected();
			if (rbchoice) {
				rbname = "Selected";
			} else {
				rbname = "All";
			}
			ProcessRequest();
		}
	}

	private void ProcessRequest() {
		switch (rbname) {
		case "All":
			ApplyActionForAll();
			break;
		case "Selected":
			ApplyAction();
			break;
		}
	}

	private void ApplyAction() {
		int row = mtable.getSelectedRow();
		// {"Article" , "1Name" , "2Supply Sorce" , "3Code", 4"MBQ" , 5"ROP",
		// "Avg Sales Qty per Day" , "Days Cover" };
		mtable.setValueAt(mbq.getText(), row, 4);
		mtable.setValueAt(rop.getText(), row, 5);
		mtable.setValueAt(dayscover.getText(), row, 7);
	}

	private void ApplyActionForAll() {
		int row = mtable.getRowCount();
		for (int i = 0; i < row; i++) {
			// {"Article" , "Name" , "Supply Sorce" , "Code", "MBQ" , "ROP",
			// "Avg Sales Qty per Day" , "Days Cover" };
			mtable.setValueAt(mbq.getText(), i, 4);
			mtable.setValueAt(rop.getText(), i, 5);
			mtable.setValueAt(dayscover.getText(), i, 7);
		}
	}

	class SearchLsnr implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			rbname = "Search";
			performAction();
		}

	}

	private void showData(String SQL) throws ClassNotFoundException, SQLException {

		new gnTable().RemoveTableRows(mmodel);
		String Col[] = { "Article", "Name", "Supply Sorce", "Code", "MBQ", "ROP", "Avg Sales Qty per Day", "Days Cover",
				"Fromdate", "To", "salesQty", "salesValue", "salesDays" };
		rs = this.getSPResult(SQL);
		mmodel.setColumnIdentifiers(Col);
		mtable.setModel(mmodel);
		while (rs.next()) {
			String varticle = rs.getString(1);
			String status = new gnCheckArticle().checkArticleExist(mtable, varticle, 0);
			if (status == "Sucess") {
				mmodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13) });
			}
			mtable.setModel(mmodel);
			mtable.getCellRenderer(1, 3);
			mtable.setDefaultRenderer(Object.class, new posRenderer());
			new gnTable().setTableBasics(mtable);
			TR_Purchase tr = new TR_Purchase();
			TableColumnModel tcm = mtable.getColumnModel();
			for (int c = 0; c < 4; c++) {
				TableColumn tc = tcm.getColumn(c);
				tc.setCellRenderer(tr);
			}
		}
		new gnTable().setTablewidth(mtable, 1, 300);
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(mtable)));
		records.setText(RecordCount1);
		mtable.setGridColor(Color.gray);
		DefaultCellEditor nk = new gnTable().cellEdit(mtable);
		JViewport prt64 = new JViewport();
		prt64.setBackground(Color.CYAN);
		prt64.add(mtable, Col);
		prt64.setVisible(true);
		jsp.setViewport(prt64);

	}

	private void calculate() throws ClassNotFoundException, SQLException {
		String vstatus = "Sucess";
		try {
			String vtrntype = "MBQ";
			String vfrom = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
			String vto = new gnConfig().date_ConverttoDBforamt(todate.getText());

			String SQL = "call   MBQ_calculateAvgSales(" + vcomp + " , " + vstore + ", '" + vtrntype + "' ,'" + vfrom
					+ "' , '" + vto + "' )";
			this.getSPResult(SQL);

		} catch (Exception e) {
			new General().msg(e.getMessage());
			vstatus = "Fail";
		} finally {
			if (vstatus == "Sucess") {
				new General().msg("Data Calculated sucessfully...Use View Options  to View Data");
			}
		}

	}

	class btnLsnr implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Save") {
				try {
					UpdateMbq();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
			if (value == "Calculate") {
				int vv = new General().msgInput("MBQ Generation Process Will Over write Old MBQ , Are you Sure ? ");
				if (vv == 0) {
					try {
						calculate();
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		}
	}

	class fromdateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				new selectdate().selectDate(fromdate);
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
			}
		}
	}

	class todateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				new selectdate().selectDate(todate);
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
			}
		}
	}

	public void UpdateMbq() throws Throwable {

		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		// String Col[] = {"Article" , "Name" , "Supply Sorce" , "Code",
		// "MBQ" , "ROP", "Avg Sales Qty per Day" , "Days Cover" };

		String poshdr1 = "Insert into tmp_ms_site_article_master( Company_code, Site_code , "
				+ "Article_code ,  name, supplySource, code, mbq ,  ro ,  dayscover)" + "values(?,?,?,?,?,?,?,?,?)";
		try {
			int row = mtable.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con1.prepareStatement(poshdr1);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, (mtable.getValueAt(k, 0).toString()));
				prst.setString(4, (mtable.getValueAt(k, 1).toString()));
				prst.setString(5, (mtable.getValueAt(k, 2).toString()));
				prst.setString(6, (mtable.getValueAt(k, 3).toString()));
				prst.setString(7, (mtable.getValueAt(k, 4).toString()));
				prst.setString(8, (mtable.getValueAt(k, 5).toString()));
				prst.setString(9, (mtable.getValueAt(k, 7).toString()));
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBdetail = "Fail";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con1.rollback();
			DBdetail = "Fail";
			new General().msg("MBQ  Detail Insert Level " + e.getMessage());
		} finally {
			if (prst != null) {
				prst.close();
				if (DBdetail == "Sucess") {
					con1.commit();
					con1.close();

					insertUpdate();

					this.closeconn();
					new General().msg("Data Saved Sucessfully.. ");
					new gnTable().RemoveTableRows(mmodel);

				}
			}
		}
	}

	private void insertUpdate() throws ClassNotFoundException, SQLException {

		String vtrntype = "MBQ";
		String SQL = "Call mbq_update( " + vcomp + " ,  " + vstore + " ,  '" + vtrntype + "' )";
		this.getSPResult(SQL);

	}
}// Last

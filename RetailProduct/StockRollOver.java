package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.SwingConstants;

/*
+243890019091  sudhir
*/
public class StockRollOver extends getResultSet {

	JFrame stockRollFrame;
	private JTextField fromdate;
	private JTextField todate;
	String QueryStatus = "N";
	private JTextField storename;
	private JScrollPane jsp;
	private JButton btnExport;
	private JButton btnUpdate;
	private JButton btnClose;
	private JButton btnCalculate;
	private JComboBox location;
	String vtrntype;
	String vcomp;
	String vstore;
	String SQL;
	public JScrollPane sjsp;

	public DefaultTableModel nmodel = new DefaultTableModel();
	public JTable ntable = new JTable();

	JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 4 || column == 8 || column == 13 || column == 14) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				// componentt.setFont(new Font("Cambria", Font.PLAIN, 13));
				componentt.setFont(new Font("Cambria", Font.CENTER_BASELINE | Font.ITALIC, 12));

			} else {
				componentt.setBackground(Color.cyan);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Cambria", Font.BOLD | Font.ROMAN_BASELINE, 12));
			}
			if (Double.parseDouble(getValueAt(roww, 15).toString().trim()) != Double
					.parseDouble(getValueAt(roww, 16).toString().trim())) {

				componentt.setBackground(Color.RED);
				componentt.setForeground(Color.WHITE);
				componentt.setFont(new Font("Calibri", Font.BOLD, 15));
			}

			if (Language == "H") {
				if (column == 1) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}

			return componentt;
		}
	};

	DefaultTableModel model = new DefaultTableModel();
	private JButton btnShow;
	private JTextField finyear;
	private JTextField calculateClosing;
	private JTextField currentClosing;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField record;
	private JTextField scanItem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockRollOver window = new StockRollOver();
					window.stockRollFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					new General().msg(e.getLocalizedMessage());
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Throwable
	 */
	public StockRollOver() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		stockRollFrame = new JFrame();
		stockRollFrame.setAlwaysOnTop(true);
		stockRollFrame.setBounds(1, 1, 1350, 700);
		stockRollFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		stockRollFrame.getContentPane().setLayout(null);

		ActionListener btn = new btnLsnr();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.LIGHT_GRAY, null));
		panel.setBounds(0, 0, 1332, 72);
		stockRollFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("From Date");
		lblNewLabel.setBounds(12, 43, 86, 16);
		panel.add(lblNewLabel);

		fromdate = new JTextField();
		fromdate.setBounds(79, 40, 116, 22);
		panel.add(fromdate);
		fromdate.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setBounds(199, 46, 25, 16);
		panel.add(lblNewLabel_1);

		todate = new JTextField();
		todate.setBounds(222, 43, 116, 22);
		panel.add(todate);
		todate.setColumns(10);

		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(btn);
		btnCalculate.setMnemonic('T');
		btnCalculate.setBounds(577, 43, 97, 25);
		panel.add(btnCalculate);

		btnClose = new JButton("Close");
		btnClose.addActionListener(btn);
		btnClose.setMnemonic('C');
		btnClose.setBounds(673, 43, 97, 25);
		panel.add(btnClose);

		btnExport = new JButton("Export To Excel");
		btnExport.addActionListener(btn);
		btnExport.setMnemonic('E');
		btnExport.setBounds(769, 43, 121, 25);
		panel.add(btnExport);

		storename = new JTextField();
		storename.setEnabled(false);
		storename.setEditable(false);
		storename.setBounds(79, 8, 279, 22);
		panel.add(storename);
		storename.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Branch");
		lblNewLabel_2.setBounds(11, 11, 56, 16);
		panel.add(lblNewLabel_2);

		location = new JComboBox();
		location.setMaximumRowCount(10);
		location.setBounds(398, 43, 147, 22);
		panel.add(location);

		JLabel lblNewLabel_3 = new JLabel("Location");
		lblNewLabel_3.setBounds(344, 46, 56, 16);
		panel.add(lblNewLabel_3);

		btnShow = new JButton("Show");
		btnShow.setMnemonic('S');
		btnShow.addActionListener(btn);
		btnShow.setBounds(891, 43, 97, 25);
		panel.add(btnShow);

		btnUpdate = new JButton("Update");
		btnUpdate.setMnemonic('U');
		btnUpdate.setBounds(1235, 47, 97, 25);
		panel.add(btnUpdate);

		JLabel lblNewLabel_4 = new JLabel("Stock RollOver - Audit");
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_4.setBounds(673, 8, 185, 22);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Fin.Year");
		lblNewLabel_5.setBounds(380, 11, 56, 16);
		panel.add(lblNewLabel_5);

		finyear = new JTextField();
		finyear.setFont(new Font("Cambria", Font.BOLD, 14));
		finyear.setBounds(443, 8, 75, 22);
		panel.add(finyear);
		finyear.setColumns(10);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 103, 1332, 481);
		stockRollFrame.getContentPane().add(jsp);

		calculateClosing = new JTextField();
		calculateClosing.setForeground(new Color(51, 51, 102));
		calculateClosing.setHorizontalAlignment(SwingConstants.CENTER);
		calculateClosing.setFont(new Font("Cambria", Font.BOLD, 16));
		calculateClosing.setBounds(1086, 610, 118, 45);
		stockRollFrame.getContentPane().add(calculateClosing);
		calculateClosing.setColumns(10);

		currentClosing = new JTextField();
		currentClosing.setForeground(new Color(51, 51, 102));
		currentClosing.setHorizontalAlignment(SwingConstants.CENTER);
		currentClosing.setFont(new Font("Cambria", Font.BOLD, 16));
		currentClosing.setBounds(1216, 610, 116, 45);
		stockRollFrame.getContentPane().add(currentClosing);
		currentClosing.setColumns(10);

		lblNewLabel_6 = new JLabel("Calculate Closing Qty");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(1076, 589, 142, 16);
		stockRollFrame.getContentPane().add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Cur. Closing Qty");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(1216, 589, 116, 16);
		stockRollFrame.getContentPane().add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("Total Items");
		lblNewLabel_8.setBounds(0, 589, 105, 16);
		stockRollFrame.getContentPane().add(lblNewLabel_8);

		record = new JTextField();
		record.setBounds(0, 611, 116, 44);
		stockRollFrame.getContentPane().add(record);
		record.setColumns(10);

		scanItem = new JTextField();
		scanItem.setBounds(94, 71, 297, 37);
		stockRollFrame.getContentPane().add(scanItem);
		scanItem.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Search ");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		lblNewLabel_9.setBounds(0, 71, 90, 30);
		stockRollFrame.getContentPane().add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel(
				"Calculation Process Will Take Couple of Minutes ..<<.Press Calculate Button >> & Please Wait..");
		lblNewLabel_10.setForeground(new Color(0, 0, 153));
		lblNewLabel_10.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblNewLabel_10.setBounds(406, 71, 719, 30);
		stockRollFrame.getContentPane().add(lblNewLabel_10);
		btnUpdate.addActionListener(btn);

		ActionListener jkjk = new lsarticle();
		scanItem.addActionListener(jkjk);

		decorate();

	}

	class lsarticle implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (i == 1001)
				try {
					getvalueofscanarticle();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
		}
	}

	private void getvalueofscanarticle() throws Throwable {
		// String vfinyear = new gnFinYear().getReportingFinYear();
		String vname = "GRModule";
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vcode = scanItem.getText();
		if (vcode.length() > 0) {
			String vverticlecode = new gnHierarchy().getVerticleCode();
			String vtype = "Article";
			String SQL = "call  Stock_showRollOver('" + vtype + "' , '" + vcode + "')";
			QueryStatus = "N";
			show(SQL);
			if (QueryStatus == "N") {
				searchName();
			}
			QueryStatus = "N";
		}
	}

	private void searchName() {
		String status = "";
		String vcode = "";
		try {
			String vcomp = new gnConfig().getCompanyCode();
		} catch (Throwable e2) {
			e2.printStackTrace();
		}
		// String sname = scanName.getText().trim();
		String sname = scanItem.getText().trim();
		sname = "%" + sname + "%";
		try {
			String vtype = "Article";
			String varticle1 = "";
			String vtrantype1 = "GRWPO";
			new gnAdmin().rArticle = "0";
			new gnAdmin().Search(vtype, sname, varticle1, vtrantype1);
		} catch (SQLException e1) {
			e1.printStackTrace();
			new gnLogger().loggerInfoEntry("GRN", "Item Search by Name Exception" + " " + e1.getLocalizedMessage());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			new gnLogger().loggerInfoEntry("GRN", "Item Search by Name Exception" + " " + e1.getLocalizedMessage());
		} catch (Throwable e1) {
			e1.printStackTrace();
			new gnLogger().loggerInfoEntry("GRN", "Item Search by Name Exception" + " " + e1.getLocalizedMessage());
		} finally {
			try {
				vcode = new gnAdmin().rArticle;
				String vtype = "Article";
				String SQL = "call  Stock_showRollOver('" + vtype + "' , '" + vcode + "')";
				new gnAdmin().rArticle = "0";
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	private void decorate() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		storename.setText(new gnConfig().getStorename(vstore));
		storename.setEnabled(true);
		storename.setEditable(false);
		fromdate.setText(new gnFinYear().getFirstDateofFinYear());
		todate.setText(new gnFinYear().getLastDateofFinYear());
		todate.setEditable(false);
		fromdate.setEditable(false);
		finyear.setText(new gnFinYear().getReportingFinYear());
		finyear.setEditable(false);
		String vmsname = "Location";
		String vverticle = new gnHierarchy().getVerticleCode();
		String search = "%%";
		String SQL1 = "call master_getMasterData('" + vmsname + "' , " + vverticle + "  , '" + search + "')";

		new gnComp().fillCombo(SQL1, location);
		calculateClosing.setEditable(false);
		currentClosing.setEditable(false);
		record.setEditable(false);
		btnUpdate.setEnabled(false);

	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Calculate") {
				try {
					String vstatus = new gnFinYear().checkDateRanegforFinyear(fromdate.getText(), todate.getText());
					if (vstatus == "Sucess") {
						Process();
					}
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Update") {
				try {
					if (table.getRowCount() > 0) {
						StartUpdateProcess();
					}
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Show") {
				new gnDecorate().setBusyCursor(stockRollFrame);
				// show() ;
			}

			if (value == "Close") {
				stockRollFrame.dispose();
			}

			if (value == "Export To Excel") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

		}
	}

	private void StartUpdateProcess() throws Throwable {

		Double vcalculatedClosing = Double.parseDouble(calculateClosing.getText());
		Double vcurrentClosing = Double.parseDouble(currentClosing.getText());
		String vmatch = "Y";

		if (!vcurrentClosing.equals(vcalculatedClosing)) {
			vmatch = "N";
		}
		String vstatus = new gnFinYear().checkDateRanegforFinyear(fromdate.getText(), todate.getText());
		if (vstatus == "Sucess") {
			new General().Quickmsg("Stock Correction Starts ...");
			new gnDecorate().setBusyCursor(stockRollFrame);
			String vloc = location.getSelectedItem().toString();
			SQL = "call Stock_rolloverCorrectStock(" + vcomp + ", " + vstore + ", '" + vloc + "')";
			try {
				this.getSPResult(SQL);
				new gnDecorate().setDefaultCursor(stockRollFrame);
				new gnImageSound().playSound();
				new General().Quickmsg("Updated Sucessfully......");
				new gnImageSound().playSound();
				new gnImageSound().playSound();
			} catch (ClassNotFoundException | SQLException e) {
				new General().msg(e.getMessage());
			}
		}
	}

	private void Process() throws Throwable {
		String vfrom = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
		String vto = new gnConfig().date_ConverttoDBforamt(todate.getText());
		String vloc = location.getSelectedItem().toString();

		String vfinyear = finyear.getText();

		String vstatus = new gnFinYear().checkDateRanegforFinyear(fromdate.getText(), todate.getText());
		if (vstatus == "Sucess") {
			new gnDecorate().setBusyCursor(stockRollFrame);
			SQL = "call Stock_rolloverCreateTable(" + vcomp + ", " + vstore + ", '" + vloc + "' , '" + vfinyear + "')";
			this.getSPResult(SQL);

			vtrntype = "AdjAdd";
			SQL = "Call  Stock_rollover(" + vcomp + ", " + vstore + ",   '" + vtrntype + "' ,  '" + vloc + "' , '"
					+ vfrom + "', '" + vto + "') ";
			// new General().msg(SQL);
			this.getSPResult(SQL);

			vtrntype = "AdjReduce";
			SQL = "Call  Stock_rollover(" + vcomp + ", " + vstore + ",   '" + vtrntype + "' ,  '" + vloc + "' , '"
					+ vfrom + "', '" + vto + "') ";
			// new General().msg(SQL);
			this.getSPResult(SQL);

			vtrntype = "FromLoc";
			SQL = "Call  Stock_rollover(" + vcomp + ", " + vstore + ",   '" + vtrntype + "' ,  '" + vloc + "' , '"
					+ vfrom + "', '" + vto + "') ";
			// new General().msg(SQL);
			this.getSPResult(SQL);

			vtrntype = "ToLoc";
			SQL = "Call  Stock_rollover(" + vcomp + ", " + vstore + ",   '" + vtrntype + "' ,  '" + vloc + "' , '"
					+ vfrom + "', '" + vto + "') ";
			// new General().msg(SQL);
			this.getSPResult(SQL);

			vtrntype = "Sales";
			SQL = "Call  Stock_rollover(" + vcomp + ", " + vstore + ",   '" + vtrntype + "' ,  '" + vloc + "' , '"
					+ vfrom + "', '" + vto + "') ";
			// new General().msg(SQL);
			this.getSPResult(SQL);

			vtrntype = "SR";
			SQL = "Call  Stock_rollover(" + vcomp + ", " + vstore + ",   '" + vtrntype + "' ,  '" + vloc + "' , '"
					+ vfrom + "', '" + vto + "') ";
			// this.getSPResult(SQL) ;
			this.getResult(SQL);

			vtrntype = "PR";
			SQL = "Call  Stock_rollover(" + vcomp + ", " + vstore + ",   '" + vtrntype + "' ,  '" + vloc + "' , '"
					+ vfrom + "', '" + vto + "') ";
			this.getSPResult(SQL);

			vtrntype = "GR";

			SQL = "Call  Stock_rollover(" + vcomp + ", " + vstore + ",   '" + vtrntype + "' ,  '" + vloc + "' , '"
					+ vfrom + "', '" + vto + "') ";
			this.getSPResult(SQL);

			SQL = "call Stock_RollupdCurrentStock(" + vcomp + ", " + vstore + "  ,   '" + vloc + "' ,    '" + vfinyear
					+ "' ) ";
			this.getSPResult(SQL);

			String vtype = "ALL";
			String vcode = "0";
			String SQL = "Call Stock_showRollOver( '" + vtype + "' , '" + vcode + "' )";

			show(SQL);
		}
	}

	private void show(String SQL) throws ClassNotFoundException, SQLException {
		// String SQL = "Call Stock_showRollOver()" ;
		String[] col = { "Article", "Name", "Trading Article", "Locaion", "Batch Item", "Op.Bal", "Purchase",
				"Pur.Return", "Sale", "Sales Retun", "TI", "TO", "LocTrf", "Adj+", "Adj-", "Closing Bal",
				"Current Bal.Stock" };
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(col);
		this.getSPResult(SQL);
		table = new gnTableModel().Tablemodel(table, model, SQL, col, 17, "N", "N", "N");

		if (table.getRowCount() > 0) {
			QueryStatus = "Y";
		} else {
			QueryStatus = "N";
		}

		JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(table, col);
		prt.setBackground(Color.white);
		prt.setVisible(true);
		selectRow();
		jsp.setViewport(prt);
		new gnDecorate().setDefaultCursor(stockRollFrame);

		currentClosing.setText(Double.toString(new gnTable().getTotal(table, 15)));
		calculateClosing.setText(Double.toString(new gnTable().getTotal(table, 16)));
		record.setText(Double.toString(new gnTable().getRowCount(table)));

		Double vcalculatedClosing = Double.parseDouble(calculateClosing.getText());
		Double vcurrentClosing = Double.parseDouble(currentClosing.getText());
		String vmatch = "Y";
		if (!vcurrentClosing.equals(vcalculatedClosing)) {
			vmatch = "N";
			btnUpdate.setEnabled(true);
		}

	}

	public void selectRow() {
		String AdetailCol[] = { "Item Code", "Name", "Op.Stock", "Purchase", "Pur.Return", "Sales", "Sales Return",
				"TO", "TI", "Stk.Adj.+", "Stk.Adj -", "Loc.Trf", "Balance Stock" };
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				String vloc = location.getSelectedItem().toString();
				String sqldetails = " call  inventory_getdetailsforArtilce(" + value + ", " + vcomp + " ," + vstore
						+ ", '" + vloc + "' )";
				try {
					AdetailSearch(sqldetails, AdetailCol);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}

	public void AdetailSearch(String sqlsearch, String[] Col) throws SQLException, ClassNotFoundException {

		sjsp = new JScrollPane();
		sjsp.setBounds(10, 10, 200, 200);
		new gnTable().RemoveTableRows(nmodel);
		nmodel.setColumnIdentifiers(Col);
		ntable.setModel(nmodel);
		ntable = new gnTableModel().Tablemodel(ntable, nmodel, sqlsearch, Col, 13, "N", "N", "N");
		new gnTable().setTablewidth(ntable, 1, 300);
		new General().msgsearch(sjsp, ntable, "Inventory Details", 900, 200);
		ntable.setBackground(Color.WHITE);
	}
}// Last

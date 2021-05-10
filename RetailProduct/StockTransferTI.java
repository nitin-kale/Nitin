package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

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
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class StockTransferTI extends getResultSet {
	// Table insert Variables
	private String vfromstore;
	private String vtostore;
	private String vreceivedate;
	private String vtransferdate;
	private String vamount;
	private String vtiNumber;
	private String vtono;
	private String vtype;
	private String DBhdr;
	private String verticle;
	private String DBdetail;
	private String DBStock2;
	private JInternalFrame internalFrame;

	private Connection con, con1, con2, con3;

	/// End Table insert Variables

	JFrame stockTransferIN;
	private JTextField fromstorecode;
	private JTextField tostorecode;
	private JTextField fromstorename;
	private JTextField tostorename;
	private JTextField transferdate;
	private JTextField receivedate;
	private JTextField TINO;
	private JTextField count;
	private JTextField value;
	private JTextField TONO;
	private JButton btnUploadFile;
	private String vcomp;
	private String vstore;
	private JButton btnClose;
	private JButton btnSave;
	private JButton btnPrint;

	JScrollPane jsp = new JScrollPane();

	// for Item
	String scandetail[] = { "-", "Item Code", "Name", "Sent Qty", "Receive Qty", "UOM", "Cost", "SalesPrice", "MRP",
			" Bal_Stock", "Tax_per", "Batch No", "Manuf.Date", "Expiry Date", "Batch_Control", "Total Value",
			"Location" };

	// String scandetail[] = { 1"Item Code" ,2"Name" , 3"Sent Qty" ,4 "Receive
	// Qty" ,5 "UOM" , 6"Cost",
	// 7"SalesPrice" , 8"MRP" , 9" Bal_Stock" , 10"Tax_per" , 11"Batch No" ,
	// 12"Manuf.Date" ,
	// 13"Expiry Date", 14"Batch_Control" ,15 "Total Value", 16 "Location" };

	DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 4 ? true : false;
		}
	};

	JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);

			if (column == 4) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setCursor(getCursor());
			}
			if (column == 4) {
				componentt.setBackground(new Color(0, 51, 152));// .LIGHT_GRAY);
				componentt.setForeground(new Color(204, 255, 153));
			}
			if (column == 15) {
				componentt.setBackground(new Color(110, 151, 152));// .LIGHT_GRAY);
				componentt.setForeground(new Color(204, 255, 153));
			}

			return componentt;
		}
	};

	// For Search Item and TO number
	DefaultTableModel model1 = new DefaultTableModel();
	JTable table1 = new JTable();
	JScrollPane sjsp = new JScrollPane();

	//
	String item[] = { "Type", "Item Code", "Name", "SalesPrice", "Cost" };
	String TO[] = { "Sender Store", "TO Number", "Date", "Status" };
	String site[] = { "Head", "Store", "Name", "Phone1", "Phone2" };
	//

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockTransferTI window = new StockTransferTI();
					window.stockTransferIN.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					e.printStackTrace();
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
	public StockTransferTI() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		stockTransferIN = new JFrame();
		stockTransferIN.setTitle("Business Application");
		stockTransferIN.setResizable(false);
		stockTransferIN.setBounds(0, 10, 1378, 700);
		stockTransferIN.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		stockTransferIN.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1400, 700);
		stockTransferIN.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		internalFrame = new JInternalFrame("Stock Transfer IN < From Other Stores>");
		internalFrame.setBounds(0, 0, 1400, 700);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(6, 0, 929, 113);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblToStore = new JLabel("Stock Recive Store");
		lblToStore.setBounds(6, 37, 114, 16);
		lblToStore.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblToStore);

		tostorecode = new JTextField();
		tostorecode.setBounds(128, 34, 56, 22);
		tostorecode.setToolTipText("Stock Receive Store Code ");
		tostorecode.setEditable(false);
		panel.add(tostorecode);
		tostorecode.setColumns(10);

		tostorename = new JTextField();
		tostorename.setBounds(181, 34, 272, 22);
		tostorename.setEditable(false);
		panel.add(tostorename);
		tostorename.setColumns(10);

		JLabel lblNewLabel = new JLabel("Stock Receive Date");
		lblNewLabel.setBounds(0, 61, 120, 16);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel);

		receivedate = new JTextField();
		receivedate.setBounds(128, 58, 116, 22);
		receivedate.setToolTipText("Stock Receive Date ");
		receivedate.setEditable(false);
		panel.add(receivedate);
		receivedate.setColumns(10);
		String vfromstore = tostorecode.getText();

		JLabel lblTransferInNo = new JLabel("Transfer IN No");
		lblTransferInNo.setBounds(24, 13, 96, 16);
		lblTransferInNo.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblTransferInNo);

		TINO = new JTextField();
		TINO.setBounds(128, 10, 116, 22);
		TINO.setToolTipText("Transfer IN Number ");
		TINO.setEditable(false);
		panel.add(TINO);
		TINO.setColumns(10);
		ActionListener to = new tonoLsnr();

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(465, 0, 460, 113);
		panel_3.setBorder(new TitledBorder(null, "Stock Sending Branch", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 153)));
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblToNumber = new JLabel("TO Number");
		lblToNumber.setBounds(18, 20, 75, 16);
		panel_3.add(lblToNumber);

		TONO = new JTextField();
		TONO.setBounds(92, 17, 116, 22);
		panel_3.add(TONO);
		TONO.setToolTipText("Enter TO number ");
		TONO.addActionListener(to);
		TONO.setColumns(10);

		JLabel lblFromStore = new JLabel("From Store ");
		lblFromStore.setBounds(18, 44, 75, 16);
		panel_3.add(lblFromStore);
		lblFromStore.setHorizontalAlignment(SwingConstants.RIGHT);

		fromstorecode = new JTextField();
		fromstorecode.setBounds(92, 41, 72, 22);
		panel_3.add(fromstorecode);
		fromstorecode.setEditable(false);
		fromstorecode
				.setToolTipText("Enter Stock Transfer Store code Or Search <Enter Name in Name field and Press Enter>");
		fromstorecode.setColumns(10);

		fromstorename = new JTextField();
		fromstorename.setBounds(166, 41, 238, 22);
		panel_3.add(fromstorename);
		fromstorename.setBackground(Color.CYAN);
		fromstorename.setEditable(false);
		fromstorename.setColumns(10);

		transferdate = new JTextField();
		transferdate.setBounds(92, 65, 75, 22);
		panel_3.add(transferdate);
		transferdate.setBackground(Color.CYAN);
		transferdate.setEditable(false);
		transferdate.setToolTipText("Stock Transfer Date of Stock Sender Store");
		transferdate.setColumns(10);

		JLabel lblStockTransferDate = new JLabel("Transfer Date ");
		lblStockTransferDate.setBounds(6, 68, 91, 16);
		panel_3.add(lblStockTransferDate);
		lblStockTransferDate.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblIndent = new JLabel("Indent No.");
		lblIndent.setBounds(176, 68, 75, 16);
		panel_3.add(lblIndent);

		indentno = new JTextField();
		indentno.setEditable(false);
		indentno.setBackground(Color.CYAN);
		indentno.setBounds(238, 65, 116, 22);
		panel_3.add(indentno);
		indentno.setColumns(10);

		JLabel lblCount = new JLabel("Count");
		lblCount.setBounds(249, 61, 46, 16);
		panel.add(lblCount);

		count = new JTextField();
		count.setBounds(292, 58, 38, 22);
		panel.add(count);
		count.setColumns(10);

		JLabel lblValue = new JLabel("Value");
		lblValue.setBounds(333, 61, 38, 16);
		panel.add(lblValue);

		value = new JTextField();
		value.setBounds(367, 58, 86, 22);
		panel.add(value);
		value.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.MAGENTA, null));
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(6, 114, 1339, 483);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(460, 7, 2, 2);
		panel_1.add(scrollPane);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 0, 1338, 473);
		panel_1.add(jsp);
		ActionListener nk001 = new lsnrBtn();

		btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(708, 600, 97, 25);
		btnSave.addActionListener(nk001);
		internalFrame.getContentPane().add(btnSave);

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.addActionListener(nk001);
		btnClose.setBounds(904, 600, 97, 25);
		internalFrame.getContentPane().add(btnClose);

		btnPrint = new JButton("Print");
		btnPrint.setMnemonic('P');
		btnPrint.addActionListener(nk001);
		btnPrint.setBounds(807, 600, 97, 25);
		internalFrame.getContentPane().add(btnPrint);

		btnReceiveAll = new JButton("Receive All");
		btnReceiveAll.addActionListener(nk001);
		btnReceiveAll.setMnemonic('R');
		btnReceiveAll.setBounds(936, 88, 97, 25);
		internalFrame.getContentPane().add(btnReceiveAll);

		sjsp = new JScrollPane();
		sjsp.setToolTipText("Enter Starting Name Of Store and Press Enter to Search Store ");
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(12, 0, 1346, 132);
		// panel_2.add(sjsp);
		internalFrame.setVisible(true);
		decorate();
	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(stockTransferIN);
		new gnField().showInventory(internalFrame, "INV");
		new gnField().showCalc(internalFrame, "CAL");
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		tostorename.setText(new gnConfig().getStorename(vstore));
		tostorecode.setText(vstore);
		btnPrint.setEnabled(false);
		receivedate.setText(new General().getDate());

	}

	class tonoLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				new gnToTi().getTo();
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				TONO.setText(new gnToTi().rtono);
				fromstorecode.setText(new gnToTi().rSendingBranch);
				transferdate.setText(new gnToTi().rtodate);
				fromstorename.setText(new gnToTi().rsendingbrname);
				new gnToTi().rtono = " ";
				new gnToTi().rtono = " ";
				new gnToTi().rtodate = " ";
				new gnToTi().rsendingbrname = " ";
				new gnToTi().rSendingBranch = " ";
				String vtono = TONO.getText();
				String SQL = "Call   TO_getTOArticleForReceive(" + vcomp + ", " + vstore + ", " + vtono + ")";
				try {
					showTable(SQL, scandetail);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// Btn Listener
	class lsnrBtn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);

			if (value == "Receive All") {
				if (table.getRowCount() > 0) {
					int row = table.getRowCount();
					for (int k = 0; k < row; k++) {
						try {
							System.out.println(table.getValueAt(k, 3).toString());
							table.setValueAt(table.getValueAt(k, 3).toString(), k, 4);

							QtychangeImapct(table.getValueAt(k, 1).toString(), k);
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}
			}

			if (value == "Close") {
				stockTransferIN.dispose();
			}

			if (value == "Save") {
				try {
					prepareToInsert();
				} catch (Exception e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void showTable(String SQL, String scandetail[]) throws SQLException, ClassNotFoundException {
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(scandetail);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "O ", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
					rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14),
					rs.getString(15), rs.getString(16) });
			table.setModel(model);
			count.setText(Integer.toString(new gnTable().getRowCount(table)));
			value.setText(Double.toString(new gnTable().getTotal(table, 15)));
			new gnTable().setTableBasics(table);

		}
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification9);
		Double iTotal = new gnTable().getTotal(table, 15);
		value.setText(Double.toString(iTotal));
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.CYAN);
		header.setForeground(Color.BLACK);
		rs.close();
		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 2, 300);
		}
		table.setGridColor(Color.gray);
		JViewport prt = new JViewport();
		prt.add(table, scandetail);
		prt.setVisible(true);
		jsp.setViewport(prt);
	}

	public CellEditorListener ChangeNotification9 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 1);
			try {
				QtychangeImapct(value, row);
			} catch (Exception e1) {
				new General().msg(e1.getLocalizedMessage());
				e1.printStackTrace();
			}
		}
	};
	private JTextField indentno;
	private JButton btnReceiveAll;

	/// Qty chnage Impact
	public String QtychangeImapct(String value1, int i) throws Exception {
		Double curqty = Double.parseDouble(table.getValueAt(i, 4).toString());
		Double Csp = Double.parseDouble(table.getValueAt(i, 6).toString());
		Double newqty = curqty;
		Double newgross = newqty * Csp;
		table.setValueAt(newqty, i, 4);
		// table.setValueAt(Csp, i,6);
		table.setValueAt(newgross, i, 15);
		Double iTotal = new gnTable().getTotal(table, 15);
		value.setText(Double.toString(iTotal));
		String action = "Sucess";
		return action;
	}

	/// End Qty chnage Impact

	public void prepareToInsert() throws Throwable {
		int row = table.getRowCount();
		if (row > 0) {
			boolean d2 = fromstorecode.getText().isEmpty();
			if (d2 == true) {
				new General().msg("Enter  Stock Sending Store code ...");
				fromstorecode.grabFocus();
			}
			vfromstore = fromstorecode.getText();
			vcomp = new gnConfig().getCompanyCode();
			vtostore = tostorecode.getText();
			vreceivedate = receivedate.getText();
			vreceivedate = new gnConfig().date_ConverttoDBforamt(vreceivedate);
			boolean d1 = transferdate.getText().isEmpty();
			if (d1 == true) {
				transferdate.setText("0000.00.00");
			}

			vtransferdate = transferdate.getText();
			vtransferdate = new gnConfig().date_ConverttoDBforamt(vtransferdate);
			verticle = this.getVerticleCode();
			// new General().msg(vtransferdate);
			vamount = value.getText();
			TINO.setText(new gnSeq().getSeqno("1", "TR"));
			vtype = "TI";
			vtiNumber = TINO.getText();
			vtono = TONO.getText();
			insertTIDetail();
			new General().msg("TI  Number is :" + vtiNumber);
			new gnSeq().updateSeqno("1", "TR");
		}
	}

	/// Insert Stock Transfer In Detail Data to Table
	public String insertTIDetail() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		DBdetail = "Fail";
		con1 = this.getConnection();
		con1.setAutoCommit(false);
		// String scandetail[] = { 1"Item Code" ,2"Name" , 3"Sent Qty" ,4
		// "Receive Qty" ,5 "UOM" , 6"Cost",
		// 7"SalesPrice" , 8"MRP" , 9" Bal_Stock" , 10"Tax_per" , 11"Batch No" ,
		// 12"Manuf.Date" ,
		// 13"Expiry Date", 14"Batch_Control" ,15 "Total Value", 16 "Location"
		// };

		String grndetail = "Insert into Stock_transfer_in_detail(Site_code , "
				+ "Type,  TI_no, Ti_date,  othStore,  to_no ,"
				+ " Article_code , 	batch_control ,   UOM ,  to_qty ,  qty ,"
				+ " pending_qty , cost ,  TotalValue, SalesPrice, MRP , " + " bal_qty,  tax_per , batch_no , "
				+ " remark, location, Supplier, company_code, verticle, manuf_date, expiry_date, to_date, srno) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {

			int row1 = table.getRowCount();
			for (int k = 0; k < row1; k++) {
				prst = con1.prepareStatement(grndetail);
				prst.setString(1, vtostore);
				prst.setString(2, vtype);
				prst.setString(3, vtiNumber);
				prst.setString(4, vreceivedate);
				prst.setString(5, vfromstore);
				prst.setString(6, vtono);
				prst.setString(7, (table.getValueAt(k, 1).toString())); // Article
				prst.setString(8, (table.getValueAt(k, 14).toString())); // batch
																			// control
				prst.setString(9, (table.getValueAt(k, 5).toString())); // uom
				prst.setString(10, (table.getValueAt(k, 3).toString())); // toqty
				prst.setString(11, (table.getValueAt(k, 4).toString())); // tiqty
				Double vpendingqty = Double.parseDouble(table.getValueAt(k, 3).toString())
						- Double.parseDouble(table.getValueAt(k, 4).toString());
				prst.setDouble(12, vpendingqty); // pendingQty
				prst.setString(13, (table.getValueAt(k, 6).toString())); // cost
				prst.setString(14, (table.getValueAt(k, 15).toString())); // costvalue
				prst.setString(15, (table.getValueAt(k, 7).toString())); // salesprice
				prst.setString(16, (table.getValueAt(k, 8).toString())); // mrp
				String vbalqty = (table.getValueAt(k, 9).toString()); // balqty
				if (vbalqty.isEmpty()) {
					vbalqty = "0.00";
				}
				prst.setString(17, vbalqty); // balqty
				prst.setString(18, (table.getValueAt(k, 10).toString())); // tax_per
				prst.setString(19, (table.getValueAt(k, 11).toString())); // batchno
				// String vmanufdate = (table.getValueAt(k,12).toString()) ;
				// //exp_date
				prst.setString(20, "Stock Receive At Stores"); // remark
				prst.setString(21, table.getValueAt(k, 16).toString()); // location
				prst.setString(22, "0");
				prst.setString(23, vcomp);
				prst.setString(24, verticle);
				prst.setString(25, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 12).toString()));
				prst.setString(26, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 13).toString()));
				prst.setString(27, vtransferdate);
				prst.setInt(28, k);
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con1.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
				insertTIHdr();
			}
			if (DBdetail == "Sucess") {
				insertTIHdr();
			}
		}
		return DBdetail;
	}
	/// End Insert Details

	public String insertTIHdr() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		DBhdr = "Fail";
		con2 = this.getConnection();
		con2.setAutoCommit(false);
		String status = "Fail";
		String stktranferinhdr = "Insert into stock_transfer_in_hdr(Site_code , "
				+ "Type, Ti_no,  Ti_date , othStore,  to_no ," + " to_date,  Stock_value, company_code, verticle) "
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con2.prepareStatement(stktranferinhdr);
			prst.setString(1, vtostore);
			prst.setString(2, vtype);
			prst.setString(3, vtiNumber);
			prst.setString(4, vreceivedate);
			prst.setString(5, vfromstore);
			prst.setString(6, vtono);
			prst.setString(7, vtransferdate);
			prst.setString(8, vamount);
			prst.setString(9, vcomp);
			prst.setString(10, verticle);
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBhdr = "Sucess";
		} catch (SQLException e) {
			new General().msg("Stock Transfer Hdr Table " + e.getMessage());
			con2.rollback();
			DBhdr = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") {
				con1.commit();
				con2.commit();
				con1.close();
				con2.close();
				new General().msg("TI  Number is :" + vtiNumber);
				new gnSeq().updateSeqno("1", "TR");
				updateTINO_to_TONO();
				reduceInv();
				// Stock_in_hand_details();
			}
		}
		return status;
	}

	private void updateTINO_to_TONO() throws ClassNotFoundException, SQLException {
		String SQL = "call  TO_updateTINO( " + vtiNumber + "  , '" + vreceivedate + "',  " + vfromstore + "  ,  "
				+ vtono + " ,  " + vcomp + " )";
		this.getSPResult(SQL);
	}

	/// Add Inventiry to Stock_in_hand_table
	public String reduceInv() throws Throwable {
		String Action = "Fail";
		String vstore = vtostore;
		String varticle;
		String vtype = "TI";
		String vdate = vreceivedate;
		String vcomp = new gnConfig().getCompanyCode();
		String vqty = "0";
		int rw = table.getRowCount();
		if (rw > 0) {
			String vtrntype = "TI";
			String SQL = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vtiNumber + " , '"
					+ vdate + "')";
			this.getSPResult(SQL);

			String vtrntype1 = "TI";
			String SQL1 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vtiNumber
					+ " , '" + vdate + "')";
			this.getSPResult(SQL1);

			String vpara811 = "811";
			String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
					vstore);
			switch (vmaintainbatchforNonBatchItem) {
			case "Y":
				vtrntype1 = "TI";
				SQL1 = "call Inv_impact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   "
						+ vtiNumber + " , '" + vdate + "')";
				this.getSPResult(SQL1);
				break;
			}

		}
		Action = "Sucess";

		/*
		 * Old Logic for ( int k1 =0 ; k1 < rw ; k1++) { varticle =
		 * table.getValueAt(k1,1).toString(); vqty =
		 * table.getValueAt(k1,4).toString() ; String vloc =
		 * table.getValueAt(k1,16).toString() ; String vcomp = new
		 * gnConfig().getCompanyCode() ; String vverticle = new
		 * gnHierarchy().getVerticleCode() ; String vinvtype = "0" ; String
		 * vbatch = table.getValueAt(k1,14).toString() ; new applyInv_Action().
		 * invAction(vstore , varticle, vtype, vdate, vqty, vloc, vcomp,
		 * vverticle, vinvtype, vbatch) ; Action = "Sucess" ; }
		 */
		return Action;
	}
	// End Stock_in_hand_table

	public void Stock_in_hand_details() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		String vverticle = " ";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String stockdetail = "Insert into stock_in_hand_details(Company_code, Site_code , "
				+ "Article_code,   Location ,   " + "supplier_code,   Batch_no, " + "Manuf_date, Expiry_date,"
				+ "Batch_qty,  bal_qty ,   cost ,  " + "SalesPrice, MRP,  " + " createDate, updateDate, verticle)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				String vbatchEnable = table.getValueAt(k, 13).toString();
				switch (vbatchEnable) {

				// String scandetail[] = { 1"Item Code" ,2"Name" , 3"Sent Qty" ,
				// 4 "Receive Qty" ,5 "UOM" , 6"Cost",
				// 7"SalesPrice" , 8"MRP" , 9" Bal_Stock" , 10"Tax_per" ,
				// 11"Batch No" , 12"Manuf.Date" ,
				// 13"Expiry Date", 14"Batch_Control" ,
				// 15 "Total Value", 16 "Location" };

				case "Y":
					String varticle = (table.getValueAt(k, 1).toString());
					String vbatch = (table.getValueAt(k, 11).toString());
					String vvexpdate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 13).toString());
					String vloc = (table.getValueAt(k, 16).toString());
					String result = new gnConfig().batch_isBatchExist(vstore, varticle, vbatch, vvexpdate, vloc, vcomp);
					switch (result) {
					case "update":
						String varticle1 = table.getValueAt(k, 1).toString();
						String vbatchno = table.getValueAt(k, 11).toString();
						String vqty = table.getValueAt(k, 4).toString();
						String vloc1 = (table.getValueAt(k, 16).toString());
						String vvexpdate1 = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 13).toString());
						vverticle = new gnHierarchy().getVerticleCode();
						String SQL = "call batch_Addstock( " + vqty + " , " + vstore + ",  " + varticle1 + " , "
								+ vbatchno + " , '" + vvexpdate1 + "', '" + vloc1 + "', " + vcomp + " , " + vverticle
								+ ")";
						this.getSPResult(SQL);
						break;
					case "insert":
						prst = con.prepareStatement(stockdetail);
						prst.setString(1, vcomp);
						prst.setString(2, vstore);
						prst.setString(3, (table.getValueAt(k, 1).toString()));
						prst.setString(4, (table.getValueAt(k, 16).toString()));
						prst.setString(5, "0");
						prst.setString(6, (table.getValueAt(k, 11).toString()));
						String vmnfDate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 12).toString());
						if (vmnfDate == "0") {
							vmnfDate = "0000.00.00";
						}
						prst.setString(7, vmnfDate);
						prst.setString(8, new gnConfig().date_ConverttoDBforamt(table.getValueAt(k, 13).toString()));
						prst.setString(9, (table.getValueAt(k, 4).toString()));
						prst.setString(10, (table.getValueAt(k, 4).toString()));
						prst.setString(11, (table.getValueAt(k, 6).toString()));
						prst.setString(12, (table.getValueAt(k, 7).toString()));
						prst.setString(13, (table.getValueAt(k, 8).toString()));
						prst.setString(14, vreceivedate);
						prst.setString(15, vreceivedate);
						prst.setString(16, vverticle);
						prst.addBatch();
						TotalRecordinsert = TotalRecordinsert + 1;
						DBStock2 = "Fail";
						if (++TotalRecordinsert % batchSize == 0) {
							prst.executeBatch();
							con.commit();
							DBStock2 = "Sucess";
						}
						prst.executeBatch(); // insert remaining records
						con.commit();
						DBStock2 = "Sucess";
					}
					break;
				}
			} // for
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con.rollback();
			DBStock2 = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
				new General().msg("Data Saved Sucessfully..");
				new gnTable().RemoveTableRows(model);
			}
		}
	}
}// last

package RetailProduct;

import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import RetailProduct.POS.expDate;
import RetailProduct.POS.qtyLsnr;
import RetailProduct.POS.spLsnr;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class BeerShoppe_scanRecords extends getResultSet {

	JFrame beearscanFrame;
	JLabel mylbl;
	private JTextField scandate;
	String QueryStatus;
	private JTextField scanitem;
	private JTextField totalQty;
	private JTextField totalAmount;
	JButton btnBarcode;
	JButton btnPriceChange;
	JButton btnPostSales;

	JScrollPane promojsp;
	JScrollPane jsp;
	JButton btnClose;
	String vallowday;
	String varticle = "0";
	String SelectionType;
	int selectedrow = 0;
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable();

	DefaultTableModel promomodel = new DefaultTableModel();
	JTable promotable = new JTable();

	String vcomp;
	String vstore;
	String vscandate;
	private JLabel lblNewLabel_4;
	private JTextField records;
	private JLabel lblNewLabel_5;
	private JTextField terminal;
	private JButton btnCloseDay;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BeerShoppe_scanRecords window = new BeerShoppe_scanRecords();
					window.beearscanFrame.setVisible(true);
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
	public BeerShoppe_scanRecords() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		beearscanFrame = new JFrame();
		beearscanFrame.getContentPane().setBackground(Color.WHITE);
		beearscanFrame.setBounds(1, 1, 1350, 730);
		beearscanFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		beearscanFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		// JPanel panel = new gnRoundPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 662, 71);
		beearscanFrame.getContentPane().add(panel);
		panel.setLayout(null);

		mylbl = new JLabel(" ");
		mylbl.setForeground(new Color(0, 0, 102));
		mylbl.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		mylbl.setHorizontalAlignment(SwingConstants.CENTER);
		mylbl.setBounds(138, 0, 331, 35);
		panel.add(mylbl);

		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(452, 10, 82, 16);
		panel.add(lblNewLabel);

		scandate = new JTextField();
		scandate.setFont(new Font("Tahoma", Font.BOLD, 14));
		scandate.setEditable(false);
		scandate.setBounds(546, 0, 116, 35);
		panel.add(scandate);
		scandate.setColumns(10);

		lblNewLabel_5 = new JLabel("Terminal");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_5.setBounds(451, 46, 98, 16);
		panel.add(lblNewLabel_5);

		terminal = new JTextField();
		terminal.setFont(new Font("Tahoma", Font.BOLD, 15));
		terminal.setBounds(546, 36, 116, 35);
		panel.add(terminal);
		terminal.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Scan Billng Items");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(148, 36, 159, 35);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel(" ");
		lblNewLabel_8.setIcon(new ImageIcon(BeerShoppe_scanRecords.class.getResource("/RetailProduct/scner2.jpg")));
		lblNewLabel_8.setBounds(0, 0, 126, 110);
		panel.add(lblNewLabel_8);

		jsp = new JScrollPane();
		jsp.setViewportBorder(new BevelBorder(BevelBorder.RAISED, Color.GREEN, null, Color.MAGENTA, null));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 111, 662, 536);
		beearscanFrame.getContentPane().add(jsp);

		// scanitem = new JTextField();
		scanitem = new gnRoundTextField(20);
		scanitem.setFont(new Font("Tahoma", Font.BOLD, 13));
		scanitem.setBounds(142, 72, 518, 33);
		beearscanFrame.getContentPane().add(scanitem);
		scanitem.setColumns(10);

		promojsp = new JScrollPane();
		promojsp.setViewportBorder(new TitledBorder(
				new CompoundBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 0), null),
						new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), new Color(64, 64, 64),
								new Color(255, 0, 255), new Color(0, 0, 255))),
				"", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		promojsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		promojsp.setBounds(665, 65, 655, 620);
		beearscanFrame.getContentPane().add(promojsp);

		JLabel lblNewLabel_2 = new JLabel("Total Qty");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(293, 663, 88, 16);
		beearscanFrame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));

		// totalQty = new JTextField();
		totalQty = new gnRoundTextField(020);

		totalQty.setBounds(393, 650, 65, 35);
		beearscanFrame.getContentPane().add(totalQty);
		totalQty.setFont(new Font("Arial", Font.BOLD, 16));
		totalQty.setForeground(Color.DARK_GRAY);
		totalQty.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Amount");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(457, 663, 76, 16);
		beearscanFrame.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 16));

		// totalAmount = new JTextField();
		totalAmount = new gnRoundTextField(20);

		totalAmount.setBounds(539, 650, 114, 35);
		beearscanFrame.getContentPane().add(totalAmount);
		totalAmount.setFont(new Font("Arial", Font.BOLD, 16));
		totalAmount.setForeground(Color.DARK_GRAY);
		totalAmount.setColumns(10);

		// btnClose = new JButton("Close");
		btnClose = new gnRoundButton("Close");
		btnClose.setBackground(Color.WHITE);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setMnemonic('C');
		btnClose.setBounds(1223, 1, 97, 34);
		beearscanFrame.getContentPane().add(btnClose);

		// btnPostSales = new JButton("Post Sales Data");
		btnPostSales = new gnRoundButton("Post Sales Data");
		btnPostSales.setBackground(Color.WHITE);
		btnPostSales.setForeground(new Color(0, 0, 153));
		btnPostSales.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPostSales.setBounds(778, 0, 175, 36);
		beearscanFrame.getContentPane().add(btnPostSales);

		// btnDayOpen = new JButton("Open Day");
		btnBarcode = new gnRoundButton("BARCODE");
		btnBarcode.setText("BARCODE");
		//btnBarcode.setVisible(false);
		btnBarcode.setBackground(Color.WHITE);
		btnBarcode.setForeground(new Color(0, 0, 153));
		btnBarcode.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBarcode.setBounds(668, 0, 114, 36);
		beearscanFrame.getContentPane().add(btnBarcode);

		// btnPriceChange = new JButton("Price Change");
		btnPriceChange = new gnRoundButton("Price Change");
		btnPriceChange.setBackground(Color.WHITE);
		btnPriceChange.setForeground(new Color(0, 0, 153));
		btnPriceChange.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPriceChange.setBounds(953, 0, 142, 36);
		beearscanFrame.getContentPane().add(btnPriceChange);

		// btnCloseDay = new JButton("Close Day");
		btnCloseDay = new gnRoundButton("Close Day");
		btnCloseDay.setBackground(Color.WHITE);
		btnCloseDay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnCloseDay.setBounds(1099, 0, 122, 34);
		beearscanFrame.getContentPane().add(btnCloseDay);

		JLabel lblNewLabel_6 = new JLabel("My Item List");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(674, 42, 108, 23);
		beearscanFrame.getContentPane().add(lblNewLabel_6);
		
				lblNewLabel_4 = new JLabel("Records");
				lblNewLabel_4.setBounds(24, 663, 56, 16);
				beearscanFrame.getContentPane().add(lblNewLabel_4);
				lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
				
						//records = new JTextField();
						records = new gnRoundTextField(20);
 						records.setBounds(82, 650, 116, 35);
						beearscanFrame.getContentPane().add(records);
						records.setFont(new Font("Tahoma", Font.BOLD, 14));
						records.setColumns(10);

		ActionListener itm = new myitemcodeLsnr();
		scanitem.addActionListener(itm);

		ActionListener btnmng = new btnlsnt();
		btnClose.addActionListener(btnmng);
		btnCloseDay.addActionListener(btnmng);
		btnPostSales.addActionListener(btnmng);
		btnBarcode.addActionListener(btnmng);
		btnPriceChange.addActionListener(btnmng);

		decorate();
	}

	private void decorate() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		mylbl.setText(new gnConfig().getCompanyname());
		terminal.setText(new gnConfig().getTerminalID());
		vallowday = new gnDate().checkDayBegin();
		switch (vallowday) {
		case "Y":
			new gnApp().setFrameTitel(beearscanFrame);
			scandate.setText(new General().getBegindate());
			getScanItemData();
			namesearch();
			break;
		case "N":
			new General().msg("Complete Day Begin First...");
			beearscanFrame.dispose();
			break;
		}
	}

	class btnlsnt implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (value == "Close") {
				beearscanFrame.dispose();
			}
			if (value == "Post Sales Data") {
				beearscanFrame.dispose();
				try {
					POS window;
					window = new POS();
					window.POSFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
					new General().msg("Scan Item:" + " " + e1.getLocalizedMessage());
				}
			}
			 
			if (value == "BARCODE") {
				try {
					
					BarcodeMapping window = new BarcodeMapping();
					window.frameBarcodeMapping.setVisible(true);

 				} catch (Exception e22) {
					e22.printStackTrace();
				} catch (Throwable e11) {
					e11.printStackTrace();
				}
			}

			if (value == "Price Change") {
				try {
					updatePrice window = new updatePrice();
					window.updatePriceFrame.setVisible(true);
				} catch (Exception e3) {
					e3.printStackTrace();
				} catch (Throwable e5) {
					e5.printStackTrace();
				}
			}

			if (value == "Close Day") {
				beearscanFrame.dispose();
				try {
					dayEnd window = new dayEnd();
					window.frameDayEnd.setVisible(true);
				} catch (Exception e4) {
					e4.printStackTrace();
				} catch (Throwable e6) {
					e6.printStackTrace();
				}
			}
		}
	}

	class myitemcodeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent r) {
			String value = r.getActionCommand();
			int i = r.getID(); // Field id
			if (i == 1001) {
				if (vallowday == "N") {
					beearscanFrame.dispose();
					new General().msg("Complete Day Begin First...");
					return;
				}
				String result = ValidateItem(value);
				if (result == "Sucess")
					try {
						value = value.trim();
						QueryStatus = "N";
						try {
							String nn1 = showTableData(value, model);
						} catch (Exception rr) {
							rr.printStackTrace();
						}
						// new General().msg(QueryStatus);
						if (QueryStatus == "N") {
							namesearch();
						}
						QueryStatus = "N";
					} catch (SQLException e1) {
						new General().msg(e1.getMessage());
						e1.printStackTrace();
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().msg("ShowTableData search/Scan Item" + " " + e1.getMessage());
					}
				return;
			} // Item Scan
		}
	}

	private void namesearch() {
		String sname = scanitem.getText().trim();
		sname = "%" + sname + "%";
		String vType = "Article";
		String vtrantype = "POS";
		try {
			if (varticle != null && varticle.length() > 0) {
				// new General().msg(varticle);
				promotable = new gnAdmin().Searchintabe(vType, sname, varticle, vtrantype);
				showArticleNameSearchResult(promotable);
				promotable.grabFocus();
				SelectionType = "Article";
			}
		} catch (ClassNotFoundException | SQLException e1) {
			new General().msg(e1.getLocalizedMessage());
			e1.printStackTrace();
			try {
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
		} catch (Throwable e1) {
			e1.printStackTrace();
		} finally {
			try {
				// setSearchArticle() ; //Not in use forevert dont uncomment it
				String vpara716 = "716";
				String vallowpopupHelp = new getConfigurationSetting().getSpecificConfiguration(vpara716);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	public String ValidateItem(String value) {
		String result = "Sucess";
		if (value.length() == ' ') {
			result = "Sucess";
		}

		if (value.length() == 0) {
			result = "Sucess";
		}
		return result;
	}

	public String showTableData(String value, DefaultTableModel model) throws Throwable {

		String Col[] = { "Item Code", "Name", "Qty", "Rate", "Value", "PostingStatus" };
		new gnTable().RemoveTableRows(promomodel);
		model.setColumnIdentifiers(Col);
		String action = "Insert";
		String value1 = value;
		value1 = value;
		Object row[] = {};
		String SQL = "";
		String vtype = "";
		String vbatchArticle = null;
		String vfinyear = new gnFinYear().getReportingFinYear();
		if (action == "Insert") {
			new gnLogger().loggerInfoEntry("POS", "Item Scan is :" + value);
			String vverticlecode = new gnHierarchy().getVerticleCode();
			String vpara811 = "811";
			vtype = "POS";
			SQL = "Call Transaction_getScanArticleDetails( '" + vtype + "'  , '" + value + "', " + vcomp + " , "
					+ vstore + " , '" + vfinyear + "' , " + vverticlecode + ")";
			// new General().msg(SQL);
			table.setModel(model);
			rs = this.getSPResult(SQL);
			if (rs.next()) {
				String varticle = rs.getString(1);
				int varticlereturn = Integer.parseInt(rs.getString(1));
				if (varticlereturn > 0) {
					model.insertRow(0, new Object[] { rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5), "N" });
					QueryStatus = "Y";
					vbatchArticle = rs.getString(13);
					selectedrow = 0;
					insertDataintable();
					new gnTable().RemoveTableRows(promomodel);
					new gnTable().setTablewidth(table, 2, 300);
					table.setModel(model);
					//new gnLogger().loggerInfoEntry("POS", "Checking For Promo Applicablity For Article :" + varticle);
					table.setCursor(new Cursor(Cursor.HAND_CURSOR));
					varticle = "0";
					scanitem.setText(null);
					// scanItem_2.grabFocus();
				} // End if
			} // end While Rs

			new gnTable().setTableColWidth(table, 0, 50 );
 			new gnTable().setTableColWidth(table, 1, 300 );
			new gnTable().setTableColWidth(table, 2, 50 );
			new gnTable().setTableColWidth(table, 3, 100 );
			new gnTable().setTableColWidth(table, 4, 100 );
 			
			Double itemtotal = new gnTable().getTotal(table, 4);
			totalAmount.setText(Double.toString(itemtotal));
			Double vtotalqty = new gnTable().getTotal(table, 2);
			totalQty.setText(Double.toString(vtotalqty));
			// removeRow(model, table);
			new gnTable().setTableBasics(table);
			int vcount = table.getRowCount();
			records.setText(Integer.toString(vcount));
			table.getColumnModel().getColumn(1).setPreferredWidth(300);
			table.setRowHeight(27);
			table.setGridColor(Color.DARK_GRAY);
			table.setSelectionBackground(Color.blue);
			table.setSelectionForeground(Color.WHITE);
			JViewport prt11011 = new JViewport();
			prt11011.setBackground(new Color(51, 255, 255));
			prt11011.add(table);
			prt11011.setVisible(true);
			jsp.setViewport(prt11011);
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			scanitem.grabFocus();
			new gnFontSetting().setMyFont(table, "F1", 16);
		}

		return "OK";

	} // ShowTableData

	private void showArticleNameSearchResult(JTable mytable) {
		// new gnTable().RemoveTableRows(promomodel);
		scanitem.setEnabled(true);
		if (SelectionType == "Article") {
			scanitem.setEnabled(true);
		}
		promotable = mytable;
		promotable.requestFocus();
		new gnTable().setTableColWidth(promotable, 1, 30);
		new gnTable().setTableColWidth(promotable, 2, 300);
		promotable.setBackground(Color.black);
		promotable.setForeground(Color.WHITE);
		promotable.setSelectionForeground(Color.white);
		promotable.setEditingRow(0);
		JViewport prt1101 = new JViewport();
		prt1101.setBackground(new Color(51, 255, 255));
		prt1101.add(promotable);
		prt1101.setVisible(true);
		promojsp.setViewport(prt1101);
		SelectArticlerow();
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		// new gnTable().RemoveTableRows(promomodel);

	}

	public void SelectArticlerow() {
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		promotable.grabFocus();
		promotable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		promotable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = promotable.getSelectedRow();
					varticle = promotable.getValueAt(row, 1).toString();
					showTableData(varticle, model);
					varticle = "0";
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
		scanitem.grabFocus();
	}

	private void insertDataintable() throws ClassNotFoundException, SQLException {
		selectedrow = 0;
		String vtype = "SalesData";
		String varticle = table.getValueAt(selectedrow, 0).toString();
		String vname = table.getValueAt(selectedrow, 1).toString();
		String vqty = table.getValueAt(selectedrow, 2).toString();
		String vrate = table.getValueAt(selectedrow, 3).toString();
		String vterminal = terminal.getText();
		String vuid = new General().getUsercode();
		String vtime = new General().getTime();
		String vdate = new gnConfig().date_ConverttoDBforamt(scandate.getText());
		String SQL = "call scanItem_billData( '" + vtype + "' ,  " + vcomp + " ," + vstore + " , " + varticle + " , '"
				+ vname + "' , '" + vdate + "' , " + vqty + " , " + vrate + " , " + vterminal + " , '" + vuid + "' , '"
				+ vtime + "')";
		this.getSPResult(SQL);
	}

	private void getScanItemData() throws ClassNotFoundException, SQLException {
		selectedrow = 0;
		String Col[] = { "Item Code", "Name", "Qty", "Rate", "Value", "PostingStatus" };
		model.setColumnIdentifiers(Col);
		String vtype = "GetAllScandata";
		String vdate = new gnConfig().date_ConverttoDBforamt(scandate.getText());
		String varticle = "0";
		String vname = "0";
		String vqty = "0";
		String vrate = "0";
		String vterminal = "0";
		String vuid = new General().getUsercode();
		String vtime = new General().getTime();
		String SQL = "call scanItem_billData( '" + vtype + "' ,  " + vcomp + " ," + vstore + " , " + varticle + " , '"
				+ vname + "' , '" + vdate + "' , " + vqty + " , " + vrate + " , " + vterminal + " , '" + vuid + "' , '"
				+ vtime + "')";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.insertRow(0, new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6) });
			QueryStatus = "Y";
		}
		table.setModel(model);
		if (table.getRowCount() > 0) {
			Double itemtotal = new gnTable().getTotal(table, 4);
			totalAmount.setText(Double.toString(itemtotal));
			Double vtotalqty = new gnTable().getTotal(table, 2);
			totalQty.setText(Double.toString(vtotalqty));
			// removeRow(model, table);
			new gnTable().setTableBasics(table);
			int vcount = table.getRowCount();
			records.setText(Integer.toString(vcount));
			table.getColumnModel().getColumn(1).setPreferredWidth(300);
			table.setRowHeight(27);
			table.setGridColor(Color.DARK_GRAY);
			table.setSelectionBackground(Color.blue);
			table.setSelectionForeground(Color.WHITE);
		}
		JViewport prt11011 = new JViewport();
		prt11011.setBackground(new Color(51, 255, 255));
		prt11011.add(table);
		prt11011.setVisible(true);
		jsp.setViewport(prt11011);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		scanitem.grabFocus();

	}
}// Last

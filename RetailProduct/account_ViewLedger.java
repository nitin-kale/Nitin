package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import RetailProduct.gnComboMultiFields.btnShow;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import javax.swing.JToolBar;
import javax.swing.border.CompoundBorder;

public class account_ViewLedger extends getResultSet {

	JFrame ledgerViewFrame;
	JPanel panel;
	JScrollPane jsp;
	JButton btnRight;
	JButton btnLeft;
	String vaccode1;
	JButton btnCashbook;
	JButton btnBankbook;

	private JTextField finyear;
	JButton btnexp3;
	JLabel compname;
	private JTextField from;
	private JTextField to;
	String vfrom;
	String vto;
	String vtype;

	String vfinyear;
	String vaccode;
	String vcomp;
	String vstore;
	JButton btnPL;
	JButton btnBS;
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel tbmodel = new DefaultTableModel();

	JTable tbtable = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2 || column == 3 || column == 4 || column == 5) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.DARK_GRAY);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Cambria", Font.HANGING_BASELINE | Font.BOLD, 13));

			}
			return componentt;
		}
	};

	JScrollPane tbjsp;
 	JTable stable = new JTable();
 	DefaultTableModel smodel = new DefaultTableModel();
	JScrollPane sjsp;
	private JTextField debitbal;
	private JTextField creditbal;
	private JButton btnClose;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnBack;
	private JTextField stime;
	private JTextField etime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					account_ViewLedger window = new account_ViewLedger();
					window.ledgerViewFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
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
	public account_ViewLedger() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		ledgerViewFrame = new JFrame();
		ledgerViewFrame.getContentPane().setBackground(Color.WHITE);
		ledgerViewFrame.getContentPane().setLayout(null);
		ledgerViewFrame.setBounds(1, 100,  1360, 708);
		ledgerViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ledgerViewFrame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { table }));

		panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(0, 70, 1342, 558);
		ledgerViewFrame.getContentPane().add(panel);
		panel.setLayout(null);

		jsp = new JScrollPane();
		jsp.setBounds(0, 41, 890, 257);
		panel.add(jsp);

		sjsp = new JScrollPane();
		sjsp.setViewportBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new BevelBorder(BevelBorder.RAISED, null, null, null, null)));
		sjsp.setBounds(-13, 299, 890, 247);
		panel.add(sjsp);

		tbjsp = new JScrollPane();
		tbjsp.setBounds(891, 41, 451, 506);
		panel.add(tbjsp);

		lblNewLabel_4 = new JLabel("Trial Balance");
		lblNewLabel_4.setBounds(891, -1, 451, 43);
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setForeground(new Color(0, 0, 153));
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Ledger Detail View");
		lblNewLabel_5.setBounds(0, 0, 304, 40);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(new Color(0, 0, 153));
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		panel.add(lblNewLabel_5);

		btnBack = new JButton("Show Ledger");
		btnBack.setBounds(317, 17, 136, 25);
		panel.add(btnBack);

		btnPL = new JButton("View Profit & Loss Account");
		btnPL.setBounds(452, 17, 217, 25);
		panel.add(btnPL);

		btnBS = new JButton("View Balance Sheet");
		btnBS.setBounds(669, 17, 210, 25);
		panel.add(btnBS);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 255));
		panel_1.setBorder(new LineBorder(new Color(153, 255, 255), 7, true));
		panel_1.setBounds(0, 627, 1342, 44);
		ledgerViewFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		debitbal = new JTextField();
		debitbal.setFont(new Font("Cambria", Font.BOLD, 15));
		debitbal.setHorizontalAlignment(SwingConstants.CENTER);
		debitbal.setBounds(1074, 0, 122, 36);
		panel_1.add(debitbal);
		debitbal.setColumns(10);

		creditbal = new JTextField();
		creditbal.setFont(new Font("Cambria", Font.BOLD, 15));
		creditbal.setHorizontalAlignment(SwingConstants.CENTER);
		creditbal.setBounds(1208, 0, 122, 36);
		panel_1.add(creditbal);
		creditbal.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Total");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 15));
		lblNewLabel_3.setBounds(1026, 9, 56, 16);
		panel_1.add(lblNewLabel_3);
		
		stime = new JTextField();
		stime.setBounds(26, 7, 116, 22);
		panel_1.add(stime);
		stime.setColumns(10);
		
		etime = new JTextField();
		etime.setBounds(154, 7, 116, 22);
		panel_1.add(etime);
		etime.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Fin.Year");
		lblNewLabel_1.setBounds(10, 3, 47, 16);
		ledgerViewFrame.getContentPane().add(lblNewLabel_1);

		finyear = new gnRoundTextField(15);
		finyear.setBounds(62, 0, 93, 28);
		ledgerViewFrame.getContentPane().add(finyear);
		finyear.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("From");
		lblNewLabel_2.setBounds(10, 40, 36, 16);
		ledgerViewFrame.getContentPane().add(lblNewLabel_2);

		from = new gnRoundTextField(15);
		from.setBounds(46, 38, 122, 28);
		ledgerViewFrame.getContentPane().add(from);
		from.setColumns(10);

		to = new gnRoundTextField(15);
		to.setBounds(174, 38, 122, 28);
		ledgerViewFrame.getContentPane().add(to);
		to.setColumns(10);

		btnexp3 = new JButton("Export ");
		btnexp3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Export_Table_Data_to_Excel().exportTable(table);
			}
		});
		btnexp3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		btnexp3.setForeground(new Color(0, 0, 102));
		btnexp3.setMnemonic('E');
		btnexp3.setBounds(1097, 13, 112, 56);
		ledgerViewFrame.getContentPane().add(btnexp3);

		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 16));
		btnClose.setForeground(new Color(0, 0, 102));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ledgerViewFrame.dispose();
			}
		});
		btnClose.setIcon(new ImageIcon(account_ViewLedger.class.getResource("/RetailProduct/delete.png")));
		btnClose.setMnemonic('C');
		btnClose.setBounds(1221, 13, 121, 56);
		ledgerViewFrame.getContentPane().add(btnClose);

		JLabel lblNewLabel = new JLabel("Ledger View  &  Trial  Balance");
		lblNewLabel.setBounds(-621, 0, 846, 25);
		// panel_2.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(0, 0, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 18));

		compname = new JLabel(" ");
		compname.setHorizontalAlignment(SwingConstants.CENTER);
		compname.setForeground(new Color(0, 51, 0));
		compname.setFont(new Font("Calibri", Font.BOLD, 13));
		compname.setBounds(452, 34, 311, 16);
		ledgerViewFrame.getContentPane().add(compname);

		lblNewLabel_6 = new JLabel("View Ledger Balance &  Trial Balance");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setForeground(new Color(0, 51, 0));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(403, 6, 397, 16);
		ledgerViewFrame.getContentPane().add(lblNewLabel_6);

 
		ActionListener btls = new btnLsnr();
		btnBack.addActionListener(btls);
		btnPL.addActionListener(btls);
		btnBS.addActionListener(btls);

		decorate();
	}

	
///Stat Coding Here 
	
	private void decorate() throws Throwable {
		
		ledgerViewFrame.setUndecorated(true);
		new gnWaitWindow().callWaitWindow(2000);
 		btnBack.setVisible(false);
		new General().Quickmsg("Generating Data Please Wait...");
		new gnDecorate().setHandCursor(ledgerViewFrame);
		new gnStyleButton().getStyleButton(btnClose, Color.DARK_GRAY, Color.WHITE);
		new gnStyleButton().getStyleButton(btnexp3, Color.gray, Color.WHITE);
 		new gnDecorate().decorateBtn(btnPL, new Color(120, 151, 112), Color.GREEN);
		new gnDecorate().decorateBtn(btnBS, new Color(120, 151, 112), Color.GREEN);
 		new gnStyleButtonSqr().getStyleButton(btnPL, new Color(131, 211, 112), Color.white);
		new gnStyleButtonSqr().getStyleButton(btnBS, new Color(131, 211, 112), Color.white);
		new gnApp().setFrameTitel(ledgerViewFrame);
		new gnField().closeform(panel, ledgerViewFrame);

		vfinyear = new gnFinYear().getReportingFinYear();
  		from.setText(new gnFinYear().getFirstDateofFinYear());
		to.setText(new gnFinYear().getLastDateofFinYear());
		finyear.setText(new gnFinYear().getReportingFinYear());
		vfinyear = new gnFinYear().getReportingFinYear();

		vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
		vto = new gnConfig().date_ConverttoDBforamt(to.getText());
		vcomp = new gnConfig().getCompanyCode();
		compname.setText(new gnConfig().getCompanyname());
		vstore = new gnConfig().getStoreID();

		isledgerRun = "N";

		new gnField().moveDown(stable);
		new gnField().moveLeft(table);
		new gnField().moveRight(tbtable);
		new gnField().moveUp(table);
		
		stime.setText(new General().getTime());
		String vfinyear = new gnFinYear().getReportingFinYear();
		new gnAccountbase().insertAllSupplierandCustinglmast();

		if (isledgerRun == "N") {
			new gnImageSound().playSound();
			try 
			{   
 				new gnAccountbase().Calculate_glClosingBalancesForSite(vfrom, vto, vfinyear);
	 			new gnAccountbase().Calculate_Group_ClosingBalancesForSite(vfrom, vto, vfinyear);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			} 
			catch (Throwable e) 
			{
					e.printStackTrace();
			}
   		}

		isledgerRun = "Y";
	  		new gnAccountbase().GenerateTB();
		
   		
 		
		vtype = "ALL";
		vaccode = "0";
 		from.setEnabled(false);
		ActionListener tols = new toLsnr();
		to.addActionListener(tols);
		getYealyData();

	}

	
	
	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String value = e.getActionCommand();
			String vtype = "";
			String SQL = "";

			if (value == "View Profit & Loss Account") {
				try {
					viewPL();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "View Balance Sheet") {
				try {
					viewBS();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Show Ledger") {
				try {
					getYealyData();
					lblNewLabel_5.setText("Ledger Detail View");
					btnBack.setVisible(false);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private void viewPL() throws Throwable {
		account_PLNew window = new account_PLNew();
		window.plFramenew.setVisible(true);

	}

	private void viewBS() throws Throwable {
		account_BSNew window = new account_BSNew();
		window.bsFrameNew.setVisible(true);

	}
 
	class toLsnr implements ActionListener {
 		@Override
		public void actionPerformed(ActionEvent arg0) {
 			try {
				vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
				vto = new gnConfig().date_ConverttoDBforamt(to.getText());
				vaccode = "0";
				new gnAccountbase().Calculate_glClosingBalancesForSite(vfrom, vto, vfinyear);
				new gnAccountbase().Calculate_Group_ClosingBalancesForSite(vfrom, vto, vfinyear);
				new gnAccountbase().GenerateTB();
				new gnTable().RemoveTableRows(model);
				new gnTable().RemoveTableRows(tbmodel);
				new gnTable().RemoveTableRows(smodel);

				getYealyData();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void getYealyData() throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		String col[] = { "Head", "Code", "Name", "Op.Bal", "DrcrType", "Debit", "Credit", "Cl.Bal", "DrcrType" };
		model.setColumnIdentifiers(col);
		table.setModel(model);
		vaccode = "0";
		vtype = "ALL";
		String SQL = "Call   Account_viewAllaccountForSite('" + vtype + "' , " + vcomp + " , " + vstore + "  , '"
				+ vfrom + "' , '" + vto + "' , " + vaccode + ", '" + vfinyear + "')";
 		new gnTableModel().Tablemodel(table, model, SQL, col, 9, "N", "N", "");
		JViewport prt = new JViewport();
		prt.setBackground(Color.WHITE);
		prt.add(table, col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		table.setRowHeight(25);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		new gnTable().setTablewidth(table, 2, 120);
		new gnTable().setTableBasics(table);
		table.setFont(new Font("Arial", 15, 15));
		table.setBackground(Color.WHITE);
		table.setForeground(Color.black);
		new gnFontSetting().setMyFontBold(table, "F!", 12);
		table.requestFocus();
		selectRow();
		showTBData();
		new gnDecorate().setDefaultCursor(ledgerViewFrame);
	}

	private void showTBData() throws ClassNotFoundException, SQLException {

		new gnTable().RemoveTableRows(tbmodel);

		String tbCol[] = { "Fin.Year", "Ledger Code", "Name", "Debit", "Credit" };
		String SQL = "Call   Account_getTBDataForSite( " + vcomp + " , " + vstore + " , '" + vfinyear + "')";
		// new General().msg(SQL);
		new gnTableModel().Tablemodel(tbtable, tbmodel, SQL, tbCol, 5, "N", "N", "");
		JViewport prt9 = new JViewport();
		prt9.setBackground(Color.WHITE);
		prt9.add(tbtable, tbCol);
		prt9.setVisible(true);
		tbjsp.setViewport(prt9);
		tbtable.setRowHeight(25);
		tbtable.setCursor(new Cursor(Cursor.HAND_CURSOR));

		if (tbtable.getRowCount() > 0) {
			new gnTable().setTablewidth(tbtable, 2, 250);
			new gnTable().setTableBasics(tbtable);
		}
		tbtable.requestFocus();
		debitbal.setText(Double.toString(new gnTable().getTotal(tbtable, 3)));
		creditbal.setText(Double.toString(new gnTable().getTotal(tbtable, 4)));
		 
		creditbal.setText(new gnMath().get2DecimaltValue(creditbal.getText()));
 		debitbal.setText(new gnMath().get2DecimaltValue(debitbal.getText()));
		
		tbtable.setBackground(Color.WHITE);
		tbtable.setForeground(Color.black);
		new gnFontSetting().setMyFontBold(tbtable, "F!", 12);
 		etime.setText(new General().getTime());
 	}

	private void selectRow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 2);
				try {
					display(row, value);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void display(int row, String value) throws Throwable {
		String vmonthno = " ";
		String SQL2 = " ";
		int ColNo = 0;
		vtype = "Month";
		vaccode = table.getValueAt(row, 2).toString();
		vaccode1 = table.getValueAt(row, 1).toString();
		SQL2 = "Call    Account_viewAllaccountForSite('" + vtype + "' , " + vcomp + " ," + vstore + " , '" + vfrom
				+ "' , '" + vto + "' , '" + vaccode + "'  , '" + vfinyear + "')";
		String col[] = { "Type", "Code", "Name", "Op.Bal", "DrcrType", "Debit", "Credit", "Cl.Bal", "DrcrType" };
		ColNo = 8;
		vtype = "Details";
		showView(SQL2, col, ColNo, vtype);
	}

	public void showView(String SQL, String Col[], int colno, String vtype)
			throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(smodel);
		smodel.setColumnIdentifiers(Col);
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, Col, colno, "N", "Y", vtype);
		stable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		new gnTable().setTableBasics(stable);
		JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(stable, Col);
		prt.setVisible(true);
		sjsp.setViewport(prt);
		if (stable.getRowCount() > 0) {
			selectRowForLedger();
			stable.setBackground(Color.WHITE);
			stable.setForeground(Color.black);
			new gnFontSetting().setMyFontBold(stable, "F!", 12);
 		}
	}

	private void selectRowForLedger() {
		stable.requestFocus();
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = stable.getSelectedRow();
				String value = (String) stable.getValueAt(row, 1);
				supplierLedger window;
				try {
					switch (vaccode1) {
					case "8":
						saccLedCode = (String) stable.getValueAt(row, 1);
						saccLedName = (String) stable.getValueAt(row, 2);
						saccLedopbal = (String) stable.getValueAt(row, 3);
						saccLedopbaldrcr = (String) stable.getValueAt(row, 4);
						saccLedclbal = (String) stable.getValueAt(row, 7);
						saccLedclbaldrcr = (String) stable.getValueAt(row, 8);
						ledgerType = "Supplier"; // Public Variable Set
						mylabel = "Party Ledger";
						String vreporttitle = "Party Ledger";
						getBook(saccLedCode, saccLedName, vreporttitle);
						// window = new supplierLedger();
						// window.frameSuplLedger.setVisible(true);
						break;

					case "20":
						saccLedCode = (String) stable.getValueAt(row, 1);
						saccLedName = (String) stable.getValueAt(row, 2);
						saccLedopbal = (String) stable.getValueAt(row, 3);
						saccLedopbaldrcr = (String) stable.getValueAt(row, 4);
						saccLedclbal = (String) stable.getValueAt(row, 7);
						saccLedclbaldrcr = (String) stable.getValueAt(row, 8);
						ledgerType = "Supplier"; // Public Variable Set
						mylabel = "Party Ledger";
						vreporttitle = "Party Ledger";
						getBook(saccLedCode, saccLedName, vreporttitle);
						break;

					case "15":
						saccLedCode = (String) stable.getValueAt(row, 1);
						saccLedName = (String) stable.getValueAt(row, 2);
						saccLedopbal = (String) stable.getValueAt(row, 3);
						saccLedopbaldrcr = (String) stable.getValueAt(row, 4);
						saccLedclbal = (String) stable.getValueAt(row, 7);
						saccLedclbaldrcr = (String) stable.getValueAt(row, 8);
						ledgerType = "Supplier"; // Public Variable Set
						mylabel = "Stock Ledger";
						vreporttitle = "Stock  Ledger";
						getBook(saccLedCode, saccLedName, vreporttitle);
						break;

					case "12":
						saccLedCode = (String) stable.getValueAt(row, 1);
						saccLedName = (String) stable.getValueAt(row, 2);
						saccLedopbal = (String) stable.getValueAt(row, 3);
						saccLedopbaldrcr = (String) stable.getValueAt(row, 4);
						saccLedclbal = (String) stable.getValueAt(row, 7);
						saccLedclbaldrcr = (String) stable.getValueAt(row, 8);
						vreporttitle = "Bank Book";
						mylabel = "Bank Book";
						getBook(saccLedCode, saccLedName, vreporttitle);
						break;

					case "14":
						saccLedCode = (String) stable.getValueAt(row, 1);
						saccLedName = (String) stable.getValueAt(row, 2);
						saccLedopbal = (String) stable.getValueAt(row, 3);
						saccLedopbaldrcr = (String) stable.getValueAt(row, 4);
						saccLedclbal = (String) stable.getValueAt(row, 7);
						saccLedclbaldrcr = (String) stable.getValueAt(row, 8);
						vreporttitle = "Cash Register";
						mylabel = "Cash Register";
						getBook(saccLedCode, saccLedName, vreporttitle);
						break;

					case "21":
						saccLedCode = (String) stable.getValueAt(row, 1);
						saccLedName = (String) stable.getValueAt(row, 2);
						saccLedopbal = (String) stable.getValueAt(row, 3);
						saccLedopbaldrcr = (String) stable.getValueAt(row, 4);
						saccLedclbal = (String) stable.getValueAt(row, 7);
						saccLedclbaldrcr = (String) stable.getValueAt(row, 8);
						vreporttitle = "Sales Register";
						mylabel = "Sales Register";
						getBook(saccLedCode, saccLedName, vreporttitle);
						break;

					case "24":
						saccLedCode = (String) stable.getValueAt(row, 1);
						saccLedName = (String) stable.getValueAt(row, 2);
						saccLedopbal = (String) stable.getValueAt(row, 3);
						saccLedopbaldrcr = (String) stable.getValueAt(row, 4);
						saccLedclbal = (String) stable.getValueAt(row, 7);
						saccLedclbaldrcr = (String) stable.getValueAt(row, 8);
						vreporttitle = "Purchase  Register";
						mylabel = "Purchase  Register"; // set to public
						lblNewLabel_5.setText(vreporttitle);
						getBook(saccLedCode, saccLedName, vreporttitle);
						break;

					case "25":
						saccLedCode = (String) stable.getValueAt(row, 1);
						saccLedName = (String) stable.getValueAt(row, 2);
						saccLedopbal = (String) stable.getValueAt(row, 3);
						saccLedopbaldrcr = (String) stable.getValueAt(row, 4);
						saccLedclbal = (String) stable.getValueAt(row, 7);
						saccLedclbaldrcr = (String) stable.getValueAt(row, 8);
						vreporttitle = "Expense  Register";
						lblNewLabel_5.setText(vreporttitle);
						getBook(saccLedCode, saccLedName, vreporttitle);
						break;

					case "26":
						saccLedCode = (String) stable.getValueAt(row, 1);
						saccLedName = (String) stable.getValueAt(row, 2);
						saccLedopbal = (String) stable.getValueAt(row, 3);
						saccLedopbaldrcr = (String) stable.getValueAt(row, 4);
						saccLedclbal = (String) stable.getValueAt(row, 7);
						saccLedclbaldrcr = (String) stable.getValueAt(row, 8);
						vreporttitle = "Expense  Register";
						lblNewLabel_5.setText(vreporttitle);
						getBook(saccLedCode, saccLedName, vreporttitle);
						break;

					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void getBook(String vglcode, String vglcodename, String vtitle) throws Throwable {
		try {
			new gnLedgerData().GenerateLedgerReport(vglcode, vglcodename, vtitle, from.getText(), to.getText());
		} catch (Exception e) {
			new General().msg(e.getMessage());
		} finally {
			ledgerType = "OtherLedger";
		}
	}
}// Last

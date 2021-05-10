package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.jfree.chart.ChartPanel;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

public class supplierLedger extends getResultSet {

	JFrame frameSuplLedger;
	JButton btnExport;
	JInternalFrame internalFrame;
	private JTextField VendorCode;
	private JTextField VendorName;
	private JTextField from;
	private JTextField to;
	JSplitPane possplit;
	JButton btnopbal;
	JButton btnclbal;
	JButton btnMonth;
	JButton btnPayment;
	JButton btnReceipt;
	String graphType;
	String reportType;

	Double vinitopbal = 0.00;
	String vinitdrcr = "";
	String fdate = "";
	String Ldate = "";

	JScrollPane jsp;
	JScrollPane rjsp;
	JButton btnView;
	private JTextField opbal;
	private JTextField clbal;
	private JButton btnPrint;
	private JButton btnClose;
	private String vcomp;
	private String vstore;
	private String menuchoice;
	private String rbchoice;
	String vparty;

	Double vdebit = 0.00;
	Double vcredit = 0.00;
	Double vopbal = 0.00;
	Double vclbal = 0.00;

	Double Prvvdebit = 0.00;
	Double Prvvcredit = 0.00;
	Double Prvvopbal = 0.00;
	Double Prvvclbal = 0.00;
	Double Prvopbal = 0.00;

	JTable rtable = new JTable();
	DefaultTableModel rmodel = new DefaultTableModel();

	JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2 || column == 3 || column == 4 || column == 5) {
				// componentt.setBackground(Color.WHITE);
				// componentt.setForeground(Color.BLUE);
				// componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}

			return componentt;
		}
	};

	DefaultTableModel model = new DefaultTableModel();

	JTable stable = new JTable();
	DefaultTableModel smodel = new DefaultTableModel();

	String col[] = { "Date", "Particular", "Bank", "Type", "V.No", "Debit", "Credit" };
	private JTextField debittotal;
	private JTextField credittotal;
	private JLabel lblNewLabel_7;
	private JButton btnBreakup;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supplierLedger window = new supplierLedger();
					window.frameSuplLedger.setVisible(true);
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
	public supplierLedger() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frameSuplLedger = new JFrame();
		frameSuplLedger.setResizable(false);
		frameSuplLedger.setBounds(1, 1, 1221, 668);
		frameSuplLedger.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameSuplLedger.getContentPane().setLayout(null);

		internalFrame = new JInternalFrame("");
		internalFrame.setBounds(1, 1, 1350, 725);
		internalFrame.getContentPane().setBackground(Color.WHITE);
		internalFrame.setBackground(Color.WHITE);
		frameSuplLedger.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Ledger");
		lblNewLabel_1.setBounds(174, 54, 89, 16);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		internalFrame.getContentPane().add(lblNewLabel_1);

		VendorCode = new JTextField();
		VendorCode.setBounds(270, 46, 100, 30);
		VendorCode.setEditable(false);
		internalFrame.getContentPane().add(VendorCode);
		VendorCode.setColumns(10);

		VendorName = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		VendorName.setBounds(367, 46, 325, 30);

		VendorName.setFont(new Font("SansSerif", Font.BOLD, 12));
		VendorName.setForeground(new Color(0, 0, 102));
		internalFrame.getContentPane().add(VendorName);
		VendorName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Dates");
		lblNewLabel_2.setBounds(189, 23, 74, 16);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		internalFrame.getContentPane().add(lblNewLabel_2);

		from = new JTextField();
		from.setBounds(271, 19, 95, 27);
		from.setEditable(false);
		internalFrame.getContentPane().add(from);
		from.setColumns(10);

		to = new JTextField();
		to.setBounds(363, 19, 116, 27);
		internalFrame.getContentPane().add(to);
		to.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Op.Bal");
		lblNewLabel_3.setBounds(714, 51, 55, 21);
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		internalFrame.getContentPane().add(lblNewLabel_3);

		// opbal = new JTextField();
		opbal = new gnRoundTextField(20);
		opbal.setBackground(Color.WHITE);
		opbal.setBounds(765, 48, 105, 27);
		opbal.setFont(new Font("Arial", Font.BOLD, 14));
		opbal.setText("0.00");
		opbal.setEditable(false);
		internalFrame.getContentPane().add(opbal);
		opbal.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Closing Bal.");
		lblNewLabel_4.setBounds(928, 48, 96, 28);
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_4.setForeground(new Color(0, 51, 51));
		internalFrame.getContentPane().add(lblNewLabel_4);

		// clbal = new JTextField();
		clbal = new gnRoundTextField(20);
		clbal.setBackground(Color.WHITE);
		clbal.setBounds(1014, 48, 107, 27);
		clbal.setFont(new Font("Arial", Font.BOLD, 13));
		clbal.setEditable(false);
		internalFrame.getContentPane().add(clbal);
		clbal.setColumns(10);

		jsp = new JScrollPane();
		jsp.setBounds(0, 177, 922, 150);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		rjsp = new JScrollPane();
		rjsp.setBounds(0, 300, 922, 300);
		rjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		rjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// internalFrame.getContentPane().add(jsp);

		possplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, jsp, rjsp);
		possplit.setOneTouchExpandable(true);
		possplit.setVisible(true);
		possplit.setBounds(0, 115, 1202, 453);
		possplit.setAutoscrolls(true);
		possplit.setDividerLocation(300);
		internalFrame.getContentPane().add(possplit);

		btnView = new JButton("View");
		btnView.setBounds(1, 83, 90, 30);
		btnView.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnView.setMnemonic('V');
		internalFrame.getContentPane().add(btnView);

		btnPrint = new JButton("Print");
		btnPrint.setBounds(87, 83, 90, 30);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPrint.setMnemonic('P');
		internalFrame.getContentPane().add(btnPrint);

		btnClose = new JButton("Close");
		btnClose.setBounds(711, 83, 90, 30);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClose.setMnemonic('C');
		internalFrame.getContentPane().add(btnClose);

		// btnopbal = new JButton("Cr");
		btnopbal = new gnRoundButton("Cr");
		btnopbal.setEnabled(false);
		btnopbal.setBounds(869, 48, 47, 28);
		btnopbal.setBackground(Color.WHITE);
		internalFrame.getContentPane().add(btnopbal);

		// btnclbal = new JButton("-");
		btnclbal = new gnRoundButton("-");
		btnclbal.setBounds(1123, 49, 47, 27);
		btnclbal.setFont(new Font("Arial", Font.BOLD, 13));
		btnclbal.setEnabled(false);
		btnclbal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		internalFrame.getContentPane().add(btnclbal);

		debittotal = new JTextField();
		debittotal.setBounds(471, 567, 122, 28);
		debittotal.setForeground(new Color(0, 0, 153));
		debittotal.setEditable(false);
		debittotal.setFont(new Font("SansSerif", Font.BOLD, 14));
		internalFrame.getContentPane().add(debittotal);
		debittotal.setColumns(10);

		credittotal = new JTextField();
		credittotal.setBounds(605, 567, 122, 28);
		credittotal.setForeground(new Color(0, 0, 102));
		credittotal.setEditable(false);
		credittotal.setFont(new Font("SansSerif", Font.BOLD, 15));
		internalFrame.getContentPane().add(credittotal);
		credittotal.setColumns(10);

		JLabel lblNewLabel = new JLabel("Total");
		lblNewLabel.setBounds(387, 574, 55, 16);
		internalFrame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(1, 0, 55, 76);
		lblNewLabel_5.setIcon(new ImageIcon(supplierLedger.class.getResource("/RetailProduct/graphics4.png")));
		internalFrame.getContentPane().add(lblNewLabel_5);

		btnPayment = new JButton("Payment");
		btnPayment.setIcon(null);
		btnPayment.setBounds(184, 83, 90, 30);
		btnPayment.setFont(new Font("Tahoma", Font.BOLD, 11));
		internalFrame.getContentPane().add(btnPayment);

		btnReceipt = new JButton("Receipts");
		btnReceipt.setBounds(274, 83, 90, 30);
		btnReceipt.setFont(new Font("Tahoma", Font.BOLD, 11));
		internalFrame.getContentPane().add(btnReceipt);

		btnMonth = new JButton("Month Wise");
		btnMonth.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMonth.setBounds(364, 83, 122, 30);
		internalFrame.getContentPane().add(btnMonth);

		lblNewLabel_7 = new JLabel(" ");
		lblNewLabel_7.setIcon(new ImageIcon(supplierLedger.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel_7.setBounds(11, 22, 708, 60);
		internalFrame.getContentPane().add(lblNewLabel_7);

		btnBreakup = new JButton("Month/DocType");
		btnBreakup.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBreakup.setBounds(485, 83, 126, 30);
		internalFrame.getContentPane().add(btnBreakup);

		lblNewLabel_6 = new JLabel("View Ledger Info");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setForeground(new Color(0, 0, 102));
		lblNewLabel_6.setBounds(66, 0, 180, 16);
		internalFrame.getContentPane().add(lblNewLabel_6);

		btnExport = new JButton("Export");
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExport.setMnemonic('E');
		btnExport.setBounds(612, 83, 97, 30);
		internalFrame.getContentPane().add(btnExport);
		internalFrame.getContentPane().setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { VendorName, from, to, btnView, btnPrint, btnClose }));
		internalFrame.setVisible(true);
		ActionListener nam = new customername();
		VendorName.addActionListener(nam);
		ActionListener btn = new btnLsnr();
		btnView.addActionListener(btn);
		btnMonth.addActionListener(btn);
		btnBreakup.addActionListener(btn);
		btnClose.addActionListener(btn);
		btnPrint.addActionListener(btn);
		btnReceipt.addActionListener(btn);
		btnPayment.addActionListener(btn);
		btnExport.addActionListener(btn);
		ActionListener frmLsnr = new fromdateLsnr();
		ActionListener toLsnr = new todateLsnr();
		from.addActionListener(frmLsnr);
		to.addActionListener(toLsnr);

		decorate();
	}

	class fromdateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				from.setText(new gnDate().getmefullDate(from.getText()));
				// new selectdate().selectDate(fromdate );
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

				to.setText(new gnDate().getmefullDate(to.getText()));
				String vfinyear = new gnFinYear().getReportingFinYear();
				String vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
				String vto = new gnConfig().date_ConverttoDBforamt(to.getText());
				new gnAccountbase().Calculate_glClosingBalancesForSite(vfrom, vto, vfinyear);
				new gnAccountbase().Calculate_Group_ClosingBalancesForSite(vfrom, vto, vfinyear);
				// new selectdate().selectDate(todate);
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
			}
		}
	}

	private void decorate() throws Throwable {

		String vfinyear = new gnFinYear().getReportingFinYear();
  		new gnApp().setFrameTitel(frameSuplLedger);
		new gnApp().setCompanyTitle(internalFrame);
		new gnField().closeform(internalFrame, frameSuplLedger);

		VendorCode.setText(this.saccLedCode);
		VendorName.setText(this.saccLedName);

		menuchoice = new gnConfig().getmenuPressed();
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		from.setText(new gnFinYear().getFirstDateofFinYear());
		to.setText(new gnFinYear().getLastDateofFinYear());
		String vfrom = from.getText();
		String vto = to.getText();
		if (isledgerRun == "N") {
			new gnAccountbase().Calculate_glClosingBalancesForSite(vfrom, vto, vfinyear);
			new gnAccountbase().Calculate_Group_ClosingBalancesForSite(vfrom, vto, vfinyear);
		}
		isledgerRun = "Y";

		int typecode = 11;
		new gnDecorate().SetSeqHdrButton(btnView, typecode);
		new gnDecorate().SetSeqHdrButton(btnClose, typecode);
		new gnDecorate().SetSeqHdrButton(btnPrint, typecode);
		new gnDecorate().SetSeqHdrButton(btnPayment, typecode);
		new gnDecorate().SetSeqHdrButton(btnReceipt, typecode);
		new gnDecorate().SetSeqHdrButton(btnMonth, typecode);
		new gnDecorate().SetSeqHdrButton(btnBreakup, typecode);
		new gnDecorate().SetSeqHdrButton(btnExport, typecode);
 		rbchoice = "S";
 		switch (menuchoice) {
		case "SL":
			rbchoice = "S";
			btnReceipt.setVisible(false);
			btnPayment.setVisible(true);
 			break;
		case "CL":
			rbchoice = "C";
 			btnReceipt.setVisible(true);
			btnPayment.setVisible(false);
 			break;
		case "OL":
			rbchoice = "O";
 			break;
		}
 		switch (ledgerType) {
		case "Supplier":
			btnView.doClick();
 			break;
		case "OtherLedger":
			showotherLedger();
 			break;

		}
	}

	class customername implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			System.out.println(value);
			String sname = VendorName.getText();
			if (sname.length() == 0) {
				sname = " ";
				// new General().msg("Select Party code ...");
				// return;
			}
			sname = "%" + sname + "%";
			try {
				switch (rbchoice) {
				case "C":
					new gnSupplier().getCustomer(sname);
					break;
				case "S":
					new gnSupplier().getSupplier(sname);
					break;
				case "O":
					String vtype = "GL";
					new gnAccountSearch().showAccountSearchFor(sname, vtype);
					break;

				}
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				try {
					VendorCode.setText(new gnSupplier().rcustcode);
					VendorName.setText(new gnSupplier().rcustName);
					switch (rbchoice) {
					case "O":
						VendorCode.setText(new gnAccountSearch().vcode);
						VendorName.setText(new gnAccountSearch().vname);
						break;
					}

				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (value == "Close") {
				frameSuplLedger.dispose();
			}

			if (value == "Month/DocType") {
				String vtype = "GL";
				try {
					showSummary(vtype);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Month Wise") {
				String vtype = "GLMONTH";
				try {
					showSummary(vtype);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (value == "Export") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

			if (value == "Payment") {
				paymentVoucher window;
				try {
					// paymentVoucher window;
					window = new paymentVoucher();
					window.frmpaymentvoucher.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Receipts") {
				receiptVoucher window;
				try {
					window = new receiptVoucher();
					window.frmreceiptVoucher.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Print") {
				try {
					// callPrintAction();
					callPrint();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "View") {
				try {
					btnView.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					String status = validate();
					if (status == "Sucess") {
						reset();
						showTable();
					}
					btnView.setCursor(Cursor.getDefaultCursor());
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
					new General().msg("Ledger Data query" + "" + e1.getMessage());
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

		}
	}

	private String validate() {
		String status = "Sucess";
		vparty = VendorCode.getText();
		if (vparty.length() == 0) {
			status = "Fail";
			VendorName.grabFocus();
			new General().msg("Select Party ..");

		}
		return status;
	}

	private void showTable() throws Throwable {
		vparty = VendorCode.getText();
		String vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
		String vto = new gnConfig().date_ConverttoDBforamt(to.getText());
		String SQL = "";
		String vstatus = new gnFinYear().checkDateRanegforFinyear(from.getText(), to.getText());
		if (vstatus == "Sucess") {
			model.setColumnIdentifiers(col);
			new gnTable().RemoveTableRows(model);
			switch (rbchoice) {
			case "C":
				SQL = "Call led_getLedgerData(" + vcomp + "  , " + vstore + "  , '" + vparty + "' , '" + vfrom + "' , '"
						+ vto + "' )";
				break;
			case "S":
				SQL = "Call led_getLedgerData(" + vcomp + "  , " + vstore + "  , '" + vparty + "' , '" + vfrom + "' , '"
						+ vto + "' )";
				break;
			case "O":
				// String col[] = {"Date" , "Particular" , "Bank", "Type",
				// "V.No" , "Debit" , "Credit" } ;
				SQL = "Call account_getledgerData(" + vcomp + "  , " + vstore + "  , '" + vparty + "' , '" + vfrom
						+ "' , '" + vto + "' )";
				break;
			}
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7) });
			}
			table.setModel(model);
			debittotal.setText(Double.toString(new gnTable().getTotal(table, 5)));
			credittotal.setText(Double.toString(new gnTable().getTotal(table, 6)));
			JViewport prt6 = new JViewport();
			jsp.setViewport(null);
			prt6.setToolTipText(" Ledger ");
			prt6.setScrollMode(0);
			prt6.add(table, col);
			prt6.setAutoscrolls(true);
			prt6.setBackground(Color.WHITE);
			jsp.setViewport(prt6);
			try {
			} catch (Throwable e) {
				e.printStackTrace();
			}
			opbal.setText(new gnAccountbase().get_GLOpeniingAmountForSite(vparty));
			btnopbal.setText(new gnAccountbase().getFinalDrcrtype());
			clbal.setText(new gnAccountbase().get_GLClosingAmountForSite(vparty));
			btnclbal.setText(new gnAccountbase().getFinalDrcrtype());

			String vtype = "GL";
			showSummary(vtype);
			Selectrow();
		}
	}

	public void Selectrow() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.requestFocus();
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				try {
					display(row);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				;
			}
		});
	}

	private void display(int row) throws Throwable {
		// {"Date" , "Particular" , "Bank", "Type", "V.No" , "Debit" , "Credit"
		// } ;
		String vdocdate = table.getValueAt(row, 0).toString();
		String vdocno = table.getValueAt(row, 4).toString();
		String vdoctype = table.getValueAt(row, 1).toString();
		String vparty = VendorCode.getText();
		switch (vdoctype) {
		case "Sales":
			new gnEdit().showSales(vdocno, vdocdate);
			break;
		case "Purchase":
			new gnEdit().ShowGRN(vparty, vdocno, vdocdate);
			break;
		case "Payment":
			vdoctype = "PV";
			new gnEdit().showExpIncome(vdocno, vdocdate, vdoctype);
			break;
		case "Payment Receipt":
			vdoctype = "RV";
			new gnEdit().showExpIncome(vdocno, vdocdate, vdoctype);
			break;
		}
		frameSuplLedger.dispose();
	}

	private void callPrintAction() throws Throwable {
		new General().msg("Reched Here in Mehtod");
		String vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
		String vto = new gnConfig().date_ConverttoDBforamt(to.getText());
		String vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vpartycode = VendorCode.getText();
		String vvopbal = opbal.getText();
		String voptype = btnopbal.getText();
		String vvclbal = clbal.getText();
		String vcltype = btnclbal.getText();
		String vTotalDr = debittotal.getText();
		String vTotalCr = credittotal.getText();
		try {
			String SQL = "call printLedger (" + vcomp + "  , " + vstore + "  , " + vpartycode + " ,  '" + vfrom
					+ "'  , '" + vto + "'  , " + vvopbal + "  , '" + voptype + "' , " + vvclbal + "  ,'" + vcltype
					+ "' , " + vTotalDr + "  ,  " + vTotalCr + " ) ";
			this.getSPResult(SQL);
		} catch (Exception e) {
			new General().msg(e.getMessage());
		} finally {
			callPrint();
		}
	}

	private void callPrint() throws Throwable {
		String vreport = "defaultLedgerPrint.jasper";
		// String vreport = new gnApplicationSetting().Print_poFormat() ;
		gnPrintMasters rpt = new gnPrintMasters();
		rpt.print(vreport);

	}

	private void reset() {
		Prvvdebit = 0.00;
		Prvvcredit = 0.00;
		Prvvopbal = 0.00;
		Prvvclbal = 0.00;
		opbal.setText("");
		vdebit = 0.00;
		vcredit = 0.00;
		vopbal = 0.00;
		vclbal = 0.00;
		clbal.setText("");
		fdate = "";
		Ldate = "";
	}

	public void showLedgerReport() {
		isledgerRun = "Y";
	}

	private void showotherLedger() throws Throwable {
		String[] col = { "DocType", "V.No", "V.Date", "Ledger Code", "Description", "Credit", "Debit", "PaymentMode",
				"InstrumentNo", "InstrumentDate", "Narration" };
		table = mytable;
		JViewport prt11 = new JViewport();
		prt11.setBackground(Color.WHITE);
		prt11.add(table, col);
		prt11.setVisible(true);
		jsp.setViewport(prt11);
		table.setRowHeight(25);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		new gnTable().setTablewidth(table, 0, 30);
		new gnTable().setTablewidth(table, 1, 30);
		new gnTable().setTablewidth(table, 2, 30);
		new gnTable().setTablewidth(table, 3, 70);
		new gnTable().setTablewidth(table, 4, 300);
		new gnTable().setTablewidth(table, 5, 50);
		new gnTable().setTablewidth(table, 6, 60);
		new gnTable().setTablewidth(table, 7, 60);
		new gnTable().setTablewidth(table, 8, 60);
		new gnTable().setTablewidth(table, 9, 60);
		new gnTable().setTablewidth(table, 10, 300);
		new gnTable().setTableBasics(table);
 		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLACK);
		table.setGridColor(Color.yellow);
		table.setSelectionForeground(Color.YELLOW);
		debittotal.setText(Double.toString(new gnTable().getTotal(table, 5)));
		credittotal.setText(Double.toString(new gnTable().getTotal(table, 6)));
		vparty = VendorCode.getText();
		opbal.setText(new gnAccountbase().get_GLOpeniingAmountForSite(vparty));
		btnopbal.setText(new gnAccountbase().getFinalDrcrtype());
		clbal.setText(new gnAccountbase().get_GLClosingAmountForSite(vparty));
		btnclbal.setText(new gnAccountbase().getFinalDrcrtype());
		table.requestFocus();
		new gnFontSetting().setMyFontBold(table, "F1", 12);
		selectRow();
 		// view_LedgerData
		String vtype = "GL";
		showSummary(vtype);
	}

	private void selectRow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 2);
				try {
					showAccountEntry(row);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void showAccountEntry(int row) throws Throwable {
		String vtype = table.getValueAt(row, 0).toString();
		String vdocno = table.getValueAt(row, 1).toString();
		String vdocdate = table.getValueAt(row, 2).toString();
		new gnAccountbase().showAccouuntEntry(vtype, vdocno, vdocdate);

		vtype = "GLMONTHFORGL";
		showSummary(vtype);
	}

	public void showSummary(String vtype1) throws Throwable {
		int colno = 0;
		String vledgercode = "";
		String vfrom = "";
		String vto = "";
		String SQL = "";
		switch (vtype1) {
		case "GL":
			String[] col1 = { "Month", "DocType", "Ledger", "Name", "Credit", "Debit" };
			colno = 6;
			vledgercode = VendorCode.getText();
			vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
			vto = new gnConfig().date_ConverttoDBforamt(to.getText());
			SQL = "call 	view_LedgerData( '" + vtype1 + "' , " + vledgercode + ", " + vcomp + " , " + vstore + " , '"
					+ vfrom + "', '" + vto + "')";
			// new General().msg(SQL);
			showDocTypeWiseSummary(SQL, col1, vtype1, colno);
			break;

		case "GLMONTH":
			String[] col2 = { "Month", "Ledger", "Name", "Credit", "Debit" };
			colno = 5;
			vledgercode = VendorCode.getText();
			vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
			vto = new gnConfig().date_ConverttoDBforamt(to.getText());
			SQL = "call 	view_LedgerData( '" + vtype1 + "' , " + vledgercode + ", " + vcomp + " , " + vstore + " , '"
					+ vfrom + "', '" + vto + "')";
			showDocTypeWiseSummary(SQL, col2, vtype1, colno);
			showChart(vledgercode);
			break;

		case "GLMONTHFORGL":
			String[] col22 = { "Month", "Ledger", "Name", "Credit", "Debit" };
			colno = 5;
			int row = table.getSelectedRow();

			vledgercode = table.getValueAt(row, 3).toString();
			String vname = table.getValueAt(row, 4).toString();
			new General().Quickmsg("Showing Monthly Data Date Ledger - " + " " + vname);
			vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
			vto = new gnConfig().date_ConverttoDBforamt(to.getText());
			vtype1 = "GLMONTH";
			SQL = "call 	view_LedgerData( '" + vtype1 + "' , " + vledgercode + ", " + vcomp + " , " + vstore + " , '"
					+ vfrom + "', '" + vto + "')";
			showDocTypeWiseSummary(SQL, col22, vtype1, colno);
			showChart(vledgercode);
			break;

		}

	}

	private void showDocTypeWiseSummary(String SQL, String[] col, String vtype, int colno) throws Throwable {
		new gnTable().RemoveTableRows(rmodel);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		new gnTableModel().Tablemodel(rtable, rmodel, SQL, col, colno, "N", "N", "");
		JViewport prt111 = new JViewport();
		prt111.setBackground(Color.WHITE);
		prt111.add(rtable, col);
		prt111.setVisible(true);
		rjsp.setViewport(prt111);
		rtable.setRowHeight(25);
		rtable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		new gnTable().setTablewidth(rtable, 0, 30);
		new gnTable().setTablewidth(rtable, 1, 30);
		new gnTable().setTablewidth(rtable, 2, 30);
		new gnTable().setTablewidth(rtable, 3, 150);
		new gnTable().setTablewidth(rtable, 4, 30);
		new gnTable().setTableBasics(stable);
 		rtable.setBackground(Color.WHITE);
		rtable.setForeground(Color.BLACK);
		rtable.setGridColor(Color.yellow);
		rtable.setSelectionForeground(Color.YELLOW);
		new gnFontSetting().setMyFontBold(rtable, "F1", 12);
 		//
	}

	private void showChart(String vcode) throws Throwable {
		String title = "";
		String vvtype = "";
		String col[] = { "Name", "Amount" };
		String SQL = "";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
		String vto = new gnConfig().date_ConverttoDBforamt(to.getText());
		String vledgercode = vcode;
		graphType = "BarChart";
		reportType = "GLCHART";
		if (reportType == "GLCHART") {
			vvtype = "GLMONTH";
			title = "Month  Wise Sales";
			SQL = "Call   view_LedgerData( '" + vvtype + "',  " + vledgercode + " ,  " + vcomp + "," + vstore + ", '"
					+ vfrom + "' ,'" + vto + "' )";
			rs = this.getSPResult(SQL);

			try {
				switch (graphType) {
				case "PiaChart":
					File graph = new View_pieChart().drawPieChart(rs, title, col, vvtype);
					break;
				case "BarChart":
					new View_BarChart(rs, title, title, vvtype);
					break;
				case "LineChart":
					new View_LineChart(rs, title, title, vvtype);
					break;
				}
			} catch (Exception e) {
				new General().msg(e.getLocalizedMessage());
			} finally {
				// label.setIcon(new ImageIcon(ProductPath+"Pie_Chart.jpeg"));
			}
		}

	}
}// Last

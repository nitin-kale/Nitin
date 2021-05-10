package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
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
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class Declaration extends getResultSet {
	/// Table Varibale to insert Data
	private String xvstorecode;
	private String xvbegindate;
	private JTextField companycode;
	private JTextField companyname;
	private String xvterminal1;
	private String xvcashier;
	JButton btnEdit;
	String allowEdit = "N";
	String EditMode = "N";
	private String vstore;
	private String vcomp;
	private String xvshift;
	private int TotalRecordinsert = 0;
	private Double xvdamt;
	private Double xvwamt;
	private Double xvdecl_amt;
	private Double xvsales;
	private Double xvproposedDecl;
	String vfinyear;
	JButton btnNotes;
	private Double xtotal;
	private Double xvtotal;
	private Integer xvdeclno;
	private String vdeclno;
	private String vpaymentmode;
	private String vmodename;
	/// End Here

	private JTextField shift;
	private JTextField declno;
	private JTextField damt;
	private JTextField wamt;
	private JTextField shiftstatus;
	private JTextField salesamount;
	JFrame DeclarationFrame;
	private JTextField storename;
	private JTextField terminalID;
	private JTextField begindate;
	JPanel HPanel;
	private JTextField cashiercode;
	private JTextField currency;
	private JTextField currencynane;
	private JTextField storecode;

	private String vcash;
	private String vcreditnote;
	private String vcreditcard;
	private String vloyaltypoints;
	private String vcoupon;

	private String vcashier;
	/// Noted
	public JScrollPane jsp;
	public JViewport prt = new JViewport();
	public JTable table = new JTable();
	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 1 || column == 2 || column == 4 ? false : true;
		}
	};

	public String Col[] = { "Denomination", "Name", "Currency", "Enter Qty", "Total Value" };
	private JTextField cashbreakup;
	private JTextField declare_amount;
	private JButton btnComplete;
	/// Coins

	// Payment Mode wise Declare Amount
	private JScrollPane njsp;
	public JViewport prt1 = new JViewport();
	public JTable table1 = new JTable();
	public DefaultTableModel model1 = new DefaultTableModel();
	public String Payment[] = { "Payment Mode", "Name", "Amount" };

	// End Payment Mode wise

	/**
	 * 
	 * /** Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Declaration window = new Declaration();
					window.DeclarationFrame.setVisible(true);
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
	public Declaration() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		DeclarationFrame = new JFrame();
		DeclarationFrame.setAlwaysOnTop(true);
		DeclarationFrame.setResizable(false);
		DeclarationFrame.setType(Type.UTILITY);
		DeclarationFrame.setBackground(Color.CYAN);
		DeclarationFrame.setTitle("Business Application");
		DeclarationFrame.setBounds(450, 100, 663, 550);
		DeclarationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		DeclarationFrame.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 657, 550);
		DeclarationFrame.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Cahier Declaration");
		internalFrame.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		internalFrame.setBackground(Color.CYAN);
		internalFrame.setBounds(0, 0, 663, 550);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		HPanel = new JPanel();
		HPanel.setBackground(Color.CYAN);
		HPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		HPanel.setBounds(0, 0, 651, 108);
		internalFrame.getContentPane().add(HPanel);
		HPanel.setLayout(null);

		storecode = new JTextField();
		storecode.setEnabled(false);
		storecode.setBounds(122, 24, 71, 22);
		HPanel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setEnabled(false);
		storename.setForeground(new Color(0, 0, 255));
		storename.setBounds(193, 23, 338, 24);
		HPanel.add(storename);
		storename.setColumns(10);

		terminalID = new JTextField();
		terminalID.setEditable(false);
		terminalID.setBounds(318, 48, 78, 25);
		HPanel.add(terminalID);
		terminalID.setColumns(10);

		begindate = new JTextField();
		begindate.setFont(new Font("Tahoma", Font.PLAIN, 11));
		begindate.setEditable(false);
		begindate.setBackground(new Color(245, 245, 220));
		begindate.setBounds(122, 50, 71, 25);
		HPanel.add(begindate);
		begindate.setColumns(10);

		cashiercode = new JTextField();
		cashiercode.setEditable(false);
		cashiercode.setBackground(new Color(240, 255, 255));
		cashiercode.setBounds(122, 73, 71, 25);
		HPanel.add(cashiercode);
		cashiercode.setColumns(10);

		shift = new JTextField();
		shift.setEditable(false);
		shift.setBounds(476, 46, 55, 25);
		HPanel.add(shift);
		shift.setColumns(10);

		JLabel lblShiftStatus = new JLabel("Shift Status");
		lblShiftStatus.setForeground(Color.BLUE);
		lblShiftStatus.setBounds(406, 79, 71, 16);
		HPanel.add(lblShiftStatus);

		shiftstatus = new JTextField();
		shiftstatus.setEditable(false);
		shiftstatus.setBounds(476, 73, 58, 25);
		HPanel.add(shiftstatus);
		shiftstatus.setColumns(10);
		shiftstatus.setText("Open");

		JLabel lblTerminal = new JLabel("Terminal");
		lblTerminal.setBounds(261, 51, 56, 16);
		HPanel.add(lblTerminal);

		JLabel lblShift = new JLabel("Shift");
		lblShift.setBounds(436, 49, 56, 16);
		HPanel.add(lblShift);

		JLabel lblStoreCode = new JLabel("Store Code");
		lblStoreCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStoreCode.setBounds(38, 23, 78, 16);
		HPanel.add(lblStoreCode);

		JLabel lblDecrationDate = new JLabel("Declaration Date");
		lblDecrationDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDecrationDate.setBounds(12, 52, 104, 16);
		HPanel.add(lblDecrationDate);

		JLabel lblCashierCode = new JLabel("Cashier Code");
		lblCashierCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCashierCode.setBounds(23, 76, 93, 16);
		HPanel.add(lblCashierCode);

		JLabel lblDeclarationNumber = new JLabel("Declaration Number");
		lblDeclarationNumber.setBounds(204, 76, 113, 16);
		HPanel.add(lblDeclarationNumber);

		declno = new JTextField();
		declno.setBounds(319, 72, 75, 25);
		HPanel.add(declno);
		declno.setForeground(Color.MAGENTA);
		declno.setFont(new Font("Tahoma", Font.BOLD, 15));
		declno.setEnabled(false);
		declno.setColumns(10);

		JLabel lblNewLabel = new JLabel("Company");
		lblNewLabel.setBounds(60, 0, 56, 16);
		HPanel.add(lblNewLabel);

		companycode = new JTextField();
		companycode.setEnabled(false);
		companycode.setBounds(122, 2, 71, 22);
		HPanel.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setEnabled(false);
		companyname.setBounds(193, 2, 338, 22);
		HPanel.add(companyname);
		companyname.setColumns(10);

		JPanel CurrPanel = new JPanel();
		CurrPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		CurrPanel.setBackground(Color.CYAN);
		CurrPanel.setBounds(0, 111, 651, 42);
		internalFrame.getContentPane().add(CurrPanel);
		CurrPanel.setLayout(null);

		currency = new JTextField();
		currency.setFont(new Font("Tahoma", Font.PLAIN, 18));
		currency.setBounds(122, 11, 49, 24);
		CurrPanel.add(currency);
		currency.setColumns(10);
		currency.setText("INR");

		declare_amount = new JTextField();
		declare_amount.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		declare_amount.setEditable(false);
		declare_amount.setBounds(474, 6, 86, 32);
		CurrPanel.add(declare_amount);
		declare_amount.setColumns(10);
		declare_amount.setText("0.00");

		salesamount = new JTextField();
		salesamount.setEditable(false);
		salesamount.setText("0");
		salesamount.setBounds(228, 6, 116, 32);
		CurrPanel.add(salesamount);
		salesamount.setColumns(10);

		JLabel lblSales = new JLabel("Sales");
		lblSales.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSales.setBounds(171, 19, 56, 16);
		CurrPanel.add(lblSales);

		JLabel lblCurrency = new JLabel("Currency");
		lblCurrency.setBounds(67, 17, 56, 16);
		CurrPanel.add(lblCurrency);

		JLabel lblDeclareAmount = new JLabel("Declare Amount");
		lblDeclareAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDeclareAmount.setBounds(356, 17, 116, 16);
		CurrPanel.add(lblDeclareAmount);
		String vcurrency = currency.getText().trim();

		JPanel rsPanel = new JPanel();
		rsPanel.setBackground(new Color(0, 255, 255));
		rsPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		rsPanel.setBounds(0, 153, 663, 334);
		internalFrame.getContentPane().add(rsPanel);
		rsPanel.setLayout(null);

		jsp = new JScrollPane();
		jsp.setBounds(0, 161, 659, 167);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		rsPanel.add(jsp);

		prt = new JViewport();
		prt.add(table, Col);
		prt.setVisible(true);
		jsp.setViewport(prt);

		btnNotes = new JButton("Declare Collection Here");
		btnNotes.setEnabled(false);
		btnNotes.setForeground(new Color(0, 0, 255));
		btnNotes.setBackground(new Color(51, 0, 102));
		btnNotes.setBounds(0, 0, 649, 17);
		rsPanel.add(btnNotes);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(0, 17, 659, 146);
		rsPanel.add(panel);
		panel.setLayout(null);

		String vvalue = "0.00";
		ActionListener ls1 = new lsnr();
		ActionListener ls2 = new lsnr();
		ActionListener ls3 = new lsnr();

		cashbreakup = new JTextField();
		cashbreakup.setText("0.00");
		cashbreakup.setEditable(false);
		cashbreakup.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cashbreakup.setBounds(535, 57, 112, 28);
		panel.add(cashbreakup);
		cashbreakup.setColumns(10);

		JLabel lblBreakUp = new JLabel("Cash Break Up Amount ");
		lblBreakUp.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblBreakUp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBreakUp.setBounds(341, 63, 147, 16);
		panel.add(lblBreakUp);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(414, 0, 233, 44);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblCashDeposit = new JLabel("Cash Deposit");
		lblCashDeposit.setBounds(0, 0, 86, 16);
		panel_1.add(lblCashDeposit);

		JLabel lblCashWithdraw = new JLabel("Cash Withdraw");
		lblCashWithdraw.setBounds(122, 0, 99, 16);
		panel_1.add(lblCashWithdraw);

		damt = new JTextField();
		damt.setText("0");
		damt.setEditable(false);
		damt.setBounds(0, 22, 116, 25);
		panel_1.add(damt);
		damt.setColumns(10);

		wamt = new JTextField();
		wamt.setText("0");
		wamt.setEditable(false);
		wamt.setBounds(122, 22, 111, 25);
		panel_1.add(wamt);
		wamt.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 354, 140);
		panel.add(panel_2);
		panel_2.setLayout(null);

		njsp = new JScrollPane();
		njsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		njsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		njsp.setBounds(6, 0, 345, 134);
		panel_2.add(njsp);

		btnEdit = new JButton("Edit Declaration");
		btnEdit.setBounds(400, 89, 259, 25);
		panel.add(btnEdit);
		btnEdit.setVisible(false);
		// ActionListener editlsnr = new editDecl() ;
		// btnEdit.addActionListener(editlsnr);

		btnComplete = new JButton("Complete?");
		btnComplete.setBounds(399, 115, 260, 25);
		panel.add(btnComplete);
		btnComplete.setVisible(false);
		btnComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					checkbreak();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
		internalFrame.setVisible(true);
		decorate();
		setDefault();
	}

	private String checkRolePermission() {
		String vrole = new General().getRoleName();
		String allowpermition = "Fail";
		if (vrole == "Manager" || vrole == "Admin") {
			allowpermition = "Sucess";
		}
		return allowpermition;
	}

	private String checkDayend() throws Throwable {
		String status = "Sucess";
		String vcomp = new gnConfig().getCompanycode();
		String vstore = new gnConfig().getStorecode();
		String vallow = new gnDate().checkDayBegin();
		switch (vallow) {
		case "Y":
			allowEdit = "Y";
			break;
		case "N":
			status = "Fail";
			allowEdit = "N";
			new General().msg("Day End Is Over , You Can't Edit Declaration Now ... ");
			break;
		}
		return status;
	}

	private void getDeclarationData() throws SQLException, ClassNotFoundException {
		// =======Declaration
		String decCol[] = { "Type", "Decl.No", "Declaration_date", "Cashier_code", "Terminal", "Shift", "Sales_Amount",
				"Declare_Amount", "Withdraw Amt", "Opening  Cash", "Diff_amount" };
		String vtype = "ForUser";
		String vstorecode = storecode.getText();
		String vcomp = companycode.getText();
		String vuser = new General().getUsercode();

		new gnTable().RemoveTableRows(model);
		String vdate = new gnConfig().date_ConverttoDBforamt(begindate.getText()); // begindate.getText();
		String SQLdecl = "call day_getDeclarationData(    '" + vtype + "' , " + vcomp + " ,    " + vstorecode + " , '"
				+ vdate + "'  , '" + vuser + "')";
		rs = this.getSPResult(SQLdecl);
		model.setColumnIdentifiers(decCol);
		vtype = "Declaration";
		new gnTableModel().Tablemodel(table, model, SQLdecl, decCol, 10, "N", "Y", vtype);
		prt.add(table, decCol);
		jsp.setViewport(prt);
		// End Declaration

		selectRowForEdit();
	}

	public void selectRowForEdit() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				new General().msg(value);
				try {

					if (value == "Declaration") {
						EditMode = "Y";
						btnNotes.setText("Edit Declaration..");
						table.setGridColor(Color.green);
						declno.setText(table.getValueAt(row, 1).toString());
						terminalID.setText(table.getValueAt(row, 4).toString());
						shift.setText(table.getValueAt(row, 5).toString());
						shift.setBackground(Color.black);
						shift.setForeground(Color.green);
						declno.setBackground(Color.black);
						declno.setForeground(Color.green);
						terminalID.setBackground(Color.black);
						terminalID.setForeground(Color.green);
						HPanel.setBackground(Color.white);

						// display(row, value) ;

					}

				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
					// new General().msgDispose();
			}
		});
	}

	class editDecl implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				String status = checkDayend();
				if (status == "Sucess") {
					declno.setEnabled(true);
					declno.setBackground(Color.black);
					declno.setForeground(Color.green);
					declno.grabFocus();
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(DeclarationFrame);
		vfinyear = new gnFinYear().getReportingFinYear();
	}

	private void setDefault() throws Throwable {
		companycode.setText(new gnConfig().getCompanyCode());
		if (vcomp == "0") {
			System.exit(0);
		}
		companyname.setText(new gnConfig().getCompany());
		storecode.setText(new gnConfig().getStoreID());
		storename.setText(new gnConfig().getStorename(vstore));
		vstore = storecode.getText();
		vcomp = companycode.getText();
		terminalID.setText(new gnConfig().getTerminalID());
		begindate.setText(new gnConfig().getDaybeginDate());
		int vterminal = Integer.parseInt(terminalID.getText().toString());
		cashiercode.setText(new gnConfig().getUserCode());
		shift.setText((new gnConfig().getCashierShift(vcomp, vstore,
				new gnConfig().date_ConverttoDBforamt(begindate.getText()), vterminal, cashiercode.getText())));
		new gnApp().setFrameTitel(DeclarationFrame);
		vcashier = new gnConfig().getUserCode();
		cashiercode.setText(vcashier);
		if (vcomp != "0") {
			checkSalesMadebycashier();
			paymentEntery();
		}
		getDeclarationData();

	}

	public String checkSalesMadebycashier() throws SQLException, ClassNotFoundException {
		String Action = "Sucess";
		xvstorecode = storecode.getText().trim();
		xvbegindate = new gnConfig().date_ConverttoDBforamt(begindate.getText()); // begindate.getText().trim();
		xvterminal1 = terminalID.getText().trim();
		xvcashier = cashiercode.getText().trim();
		xvshift = shift.getText().trim();
		String result = getSalesAmount(xvstorecode, xvbegindate, xvterminal1, xvcashier, xvshift);
		if (result == "Sucess") {
			String sqll = "call checkDeclarationisRequired( " + xvstorecode + ",  '" + xvbegindate + "'    , "
					+ xvterminal1 + " , '" + xvcashier + "'  , " + xvshift + "  )";
			rs = this.getSPResult(sqll);
			if (rs.next()) {
				new General().msg("Cashier Declaration is Alrady done for shift -->" + xvshift);
				Action = "Fail";
				// System.exit(0);
				return Action;
			}
		}
		return Action;
	}

	public String getSalesAmount(String vstorecode, String vdate, String vterminal, String vcashier, String vshift)
			throws SQLException, ClassNotFoundException {
		String Action = "Fail";
		String vamt;
		String sql = "Call  getSalesAmount( " + vstorecode + " , '" + vdate + "' ,  " + vterminal + ",  '" + vcashier
				+ "' ,   " + vshift + " )";
		rs = this.getSPResult(sql);
		if (!rs.next()) {
			new General().Quickmsg("Sales for this cashier and shift is not recorded on terminal for this store");
			new General().msg("Declaration is not required...close Declaration window and do dayend..");
			updateDeclaration();
			DeclarationFrame.dispose();
 		} else if (rs.first()) {
			Action = "Sucess";
			rs.close();
		}
		return Action;
	}

	
	public void showTable() throws SQLException, ClassNotFoundException {
		btnComplete.setVisible(true);
		new gnTable().RemoveTableRows(model);
		String sql = " Call getDenominationData()";
		rs = this.getSPResult(sql);
		model.setColumnIdentifiers(Col);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5) });
			table.setModel(model);
			new gnTable().setTablewidth(table, 0, 100);
			new gnTable().setTablewidth(table, 1, 100);
			new gnTable().setTablewidth(table, 2, 100);
			new gnTable().setTablewidth(table, 3, 200);
			new gnTable().setTablewidth(table, 4, 300);
		}
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		table.setEnabled(true);
		table.setCellSelectionEnabled(false);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.gray);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification);

	}// End ShowTable

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 3);
			QtychangeImapct(value, row);
		}
	};

	public String QtychangeImapct(String value, int i) {
		System.out.println("Item is " + value + "Row is" + i);
		String curqty1 = (String) table.getValueAt(i, 3).toString();
		double curqty = Double.parseDouble(curqty1);
		Double vqty = Double.parseDouble(table.getValueAt(i, 3).toString());
		Double vname = Double.parseDouble(table.getValueAt(i, 1).toString());
		Double vtotalvalue = vqty * vname;
		table.setValueAt(vtotalvalue, i, 4);
		Double iTotal = new gnTable().getTotal(table, 4);
		// new General().msgDouble(iTotal);
		cashbreakup.setText(Double.toString(iTotal));
		new gnTable().setTablewidth(table, 0, 100);
		new gnTable().setTablewidth(table, 1, 100);
		new gnTable().setTablewidth(table, 2, 100);
		new gnTable().setTablewidth(table, 3, 200);
		new gnTable().setTablewidth(table, 4, 300);
		String action = "Sucess";
		return action;
		// Update Row Qty and Values
	}

	class lsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			calculate_declareamount();
		}
	}

	public void checkbreak() throws Throwable {
		String vcheck = "Fail";
		double vbreakupamount = Double.parseDouble(cashbreakup.getText().trim());
		double vcashamount = Double.parseDouble(table1.getValueAt(0, 2).toString());
		if (vbreakupamount != vcashamount) {
			new General().msg("Enter Cash Amount  &  Cash Breakup is not Matching .. Please check");
			vcheck = "Fail";
			return;
		}
		if (vbreakupamount == vcashamount) {
			validateDeclaration();
		}
	}

	public String getSalesdata(String vstorecode, String vdate, String vterminal, String vcashier, String vshift)
			throws SQLException, ClassNotFoundException {
		String Action = "Fail";
		String vamt;
		String sql = "Call  getSalesAmount( " + vstorecode + " , '" + vdate + "' ,  " + vterminal + ",  '" + vcashier
				+ "' ,   " + vshift + " )";
		rs = this.getSPResult(sql);
		if (rs.first()) {
			salesamount.setText(rs.getString(2));
			Action = "Sucess";
		}
		return Action;
	}

	public void validateDeclaration() throws Throwable {
		String action = "Fail";
		xvstorecode = storecode.getText().trim();
		xvbegindate = new gnConfig().date_ConverttoDBforamt(begindate.getText());// begindate.getText().trim();
		xvterminal1 = terminalID.getText().trim();
		xvcashier = cashiercode.getText().trim();
		xvshift = shift.getText().trim();
		String Action = getSalesdata(xvstorecode, xvbegindate, xvterminal1, xvcashier, xvshift);
		if (Action == "Fail") {
			return;
		}
		xvdamt = Double.parseDouble(damt.getText().toString());
		xvwamt = Double.parseDouble(wamt.getText().toString());
		xvdecl_amt = Double.parseDouble(declare_amount.getText().toString());
		xvsales = Double.parseDouble(salesamount.getText().toString());
		xvproposedDecl = (xvsales + xvdamt);
		xtotal = xvdecl_amt + xvwamt;
		xvtotal = xtotal - xvproposedDecl;
		insertDeclarationHeader();
		DeclarationFrame.dispose();

		/*
		 * if (xvtotal >= 0.00 ) { new General().Quickmsg(
		 * "No Diffrence Found ... "); action = "Save" ;
		 * insertDeclarationHeader() ; DeclarationFrame.dispose(); }
		 * 
		 * if (xvtotal < 0.00 ) { new General().msg(
		 * " Check Sales Amount and Declare Amount is Mismatch ..") ; action =
		 * "Save" ; }
		 */
	}

	public void insertDetails() throws ClassNotFoundException, SQLException, IOException {
		int row = table1.getRowCount();
		for (int i = 0; i < row; i++) {
			vpaymentmode = (String) table1.getValueAt(i, 0).toString().trim();
			vmodename = (String) table1.getValueAt(i, 1);
			vcash = table1.getValueAt(i, 2).toString();
			// Double vvcash = Double.parseDouble(vcash) ;
			// if (vvcash > 0.00)
			// {
			insertDeclarationDetail();
			// }
		}
	}

	public void insertDeclarationHeader() throws Throwable {
		switch (EditMode) {
		case "N":
			vdeclno = new gnSeq().getSeqno("11", "TR");
			// new General().msg(vdeclno) ;
			declno.setText(vdeclno);
			break;
		case "Y":
			vdeclno = declno.getText();
			editProcess();
			break;
		}
		xvdeclno = Integer.parseInt(vdeclno);
		prst = null;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String SQL = "INSERT INTO  cashier_declaration_hdr (site_code ," + "declaration_date , billing_date , "
				+ "declaration_no,  shift , terminal_id ," + " cashier_code ," + "declare_amount, Sales_amount , "
				+ "withdraw , deposit,  diff_amount , company_code , finyear) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(SQL);
			prst.setString(1, xvstorecode);
			prst.setString(2, xvbegindate);
			prst.setString(3, xvbegindate);
			prst.setInt(4, xvdeclno);
			prst.setString(5, xvshift);
			prst.setString(6, xvterminal1);
			prst.setString(7, xvcashier);
			prst.setDouble(8, xvdecl_amt);
			prst.setDouble(9, xvsales);
			prst.setDouble(10, xvwamt);
			prst.setDouble(11, xvdamt);
			prst.setDouble(12, xvtotal);
			prst.setString(13, companycode.getText());
			prst.setString(14, vfinyear);

			int count = prst.executeUpdate();
			con.commit();
			btnComplete.setVisible(false);
			new General().msg(" Data saved Sucessfully...");
		} catch (SQLException e) {
			new General().msg("hdr:" + e.getMessage());
			con.rollback();
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
				switch (EditMode) {
				case "N":
					new gnSeq().updateSeqno("11", "TR");
					break;
				case "Y":
					break;
				}
			}
			// updateDeclaration();
			insertDetails();
			updateDeclaration();
		}
	}

	public void insertDeclarationDetail() throws ClassNotFoundException, SQLException, IOException {
		prst = null;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String SQL = "INSERT INTO   cashier_declaration_detail (Site_code , " + "invdate ," + "shift ,"
				+ "Declaration_NO ," + "Declaration_date ," + "Terminal_ID ," + "Cashier_code ," + "PaymentMode ,"
				+ "name ," + "Currency ," + "Conversion_Rate ," + "Declare_Amount, company_code ,  finyear)  VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(SQL);
			prst.setString(1, xvstorecode);
			prst.setString(2, xvbegindate);
			prst.setString(3, xvshift);
			prst.setInt(4, xvdeclno);
			prst.setString(5, xvbegindate);
			prst.setString(6, xvterminal1);
			prst.setString(7, xvcashier);
			prst.setString(8, vpaymentmode);
			prst.setString(9, vmodename);
			prst.setString(10, "INR");
			prst.setString(11, "1");
			prst.setString(12, vcash);
			prst.setString(13, companycode.getText());
			prst.setString(14, vfinyear);
			int count = prst.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			new General().msg("detail:" + e.getMessage());
			con.rollback();
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}

	public void calculate_declareamount() {
		declare_amount.setText("0.00");
		double vcash = Double.parseDouble(table1.getValueAt(0, 2).toString());
		double vcc = Double.parseDouble(table1.getValueAt(1, 2).toString());
		double vchq = Double.parseDouble(table1.getValueAt(2, 2).toString());
		double vdeclAmount = vcash + vcc + vchq;
		declare_amount.setText(Double.toString(vdeclAmount));
	}

	public void getdwAmount(String vstorecode, String vdate, String vterminal, String vcashier, String vshift,
			String xtype) throws SQLException, ClassNotFoundException {
		// new General().msg("Take Amount deposit and withdraw here ") ;
		String vamt;
		String vtype;
		String sql = "Call  getdwAmount( " + vstorecode + " , '" + vdate + "' ,  " + vterminal + ",  '" + vcashier
				+ "' ,   " + vshift + "  ,'" + xtype + "')";
		// new General().msg(sql);
		rs = this.getSPResult(sql);
		damt.setText("0");

		while (rs.next()) {
			vtype = rs.getString(1).trim();
			vamt = rs.getString(2).trim();
			damt.setText(rs.getString(2).trim());
		}
	}

	public void getdwAmount1(String vstorecode, String vdate, String vterminal, String vcashier, String vshift,
			String xtype) throws SQLException, ClassNotFoundException {
		// new General().msg("Take Amount deposit and withdraw here ") ;
		String vamt;
		String vtype;
		String sql = "Call  getdwAmount( " + vstorecode + " , '" + vdate + "' ,  " + vterminal + ",  '" + vcashier
				+ "' ,   " + vshift + "  ,'" + xtype + "')";
		// new General().msg(sql);

		rs = this.getSPResult(sql);
		wamt.setText("0");
		while (rs.next()) {
			vtype = rs.getString(1).trim();
			vamt = rs.getString(2).trim();
			wamt.setText(rs.getString(2).trim());
		}
	}

	public void paymentEntery() throws SQLException, ClassNotFoundException {
		String SQL = "call decl_getPaymentModes()";
		rs = this.getSPResult(SQL);
		model1.setColumnIdentifiers(Payment);
		while (rs.next()) {
			model1.addRow(new Object[] { rs.getString(1), rs.getString(2), 0 });
		}
		table1.setModel(model1);
		table1.setRowHeight(22);
		JViewport prt7 = new JViewport();
		prt7.add(table1, Col);
		prt7.setVisible(true);
		njsp.setViewport(prt7);
		DefaultCellEditor nk = new gnTable().cellEdit(table1);
		nk.addCellEditorListener(ChangeNotification1);
	}

	public CellEditorListener ChangeNotification1 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table1.getSelectedRow();
			String value = (String) table1.getValueAt(row, 0);
			try {
				calculate_declareamount();
				showTable();
				if (table.getRowCount() == 0) {
					showTable();
				}
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	};

	private void editProcess() throws ClassNotFoundException, SQLException {
		String vtype = "Remove";
		String vstorecode = storecode.getText();
		String vcomp = companycode.getText();
		String vuser = declno.getText();
		;
		String vdate = new gnConfig().date_ConverttoDBforamt(begindate.getText()); // begindate.getText();
		String SQL = "call day_getDeclarationData(    '" + vtype + "' , " + vcomp + " ,    " + vstorecode + " , '"
				+ vdate + "'  , '" + vuser + "')";
		this.getResult(SQL);
	}

	public void updateDeclaration() throws SQLException, ClassNotFoundException {
		String vvdate = new gnConfig().date_ConverttoDBforamt(begindate.getText());
		String vvstore = storecode.getText();
		String SQL1 = "call  day_updateDeclaration(" + vvstore + " ,  '" + vvdate + "')";
		this.getSPResult(SQL1);
		reset();
		getDeclarationData();
	}

	private void reset() {
		EditMode = "N";

	}

}// Last

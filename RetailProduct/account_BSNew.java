package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class account_BSNew extends getResultSet {

	JFrame bsFrameNew;
	private JTextField from;
	private JTextField to;
	JButton btnAsset;
	JButton btnlib;
	String vmycode = "";
	String vclosingStock;
	String vdirectIncome;
	String vfinyear;
	JTable vtable = new JTable();

	String vsalesret;
	String vsales;
	String vdirectExp;
	String vpurchaseret;
	String vpurchase;
	String GFside;
	Double netpur = 0.00;
	Double netSales = 0.00;
	String vgl;
	String vgroup;
	String vopbal;
	Double vgrossprofit;
	Double totalLBal = 0.00;
	Double totalRBal = 0.00;
	String vindirectIncome;
	String vindirectExp;
	Double vvindirectIncm = 0.00;
	Double vvindirectexp = 0.00;
	Double vfinalLeft = 0.00;
	Double vfinalRight = 0.00;
	Double vnetprofit = 0.00;
	Double vnetloss = 0.00;
	JInternalFrame internalFrame;

	JScrollPane rjsp;
	JScrollPane ljsp;
	JScrollPane vjsp = new JScrollPane();

	JTable ltable = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(new Color(0, 0, 102));
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.PLAIN, 15));
			}
			/*
			 * if (roww == 0 ) { componentt.setBackground(Color.BLACK);
			 * componentt.setForeground(Color.WHITE);
			 * componentt.setCursor(getCursor()); componentt.setFont(new
			 * Font("Calibri", Font.BOLD, 14)); }
			 */
			return componentt;
		}
	};

	DefaultTableModel lmodel = new DefaultTableModel();
	DefaultTableModel vmodel = new DefaultTableModel();

	JTable rtable = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.PLAIN, 15));
			}
			/*
			 * if (roww == 0 ) { componentt.setBackground(Color.BLACK);
			 * componentt.setForeground(Color.WHITE);
			 * componentt.setCursor(getCursor()); componentt.setFont(new
			 * Font("Calibri", Font.BOLD, 14)); }
			 */
			return componentt;
		}
	};

	DefaultTableModel rmodel = new DefaultTableModel();

	String vcapital;
	String vsundrycr;
	String vfixedasset;
	String vbank;
	String vcash;
	String vcurassest;
	String vduty;
	String vcurlib;
	String vsundrydr;

	Double bs_colRtotal = 0.00;
	Double bs_colLtotal = 0.00;
	Double bs_tableRtotal = 0.00;
	Double bs_tableLtotal = 0.00;
	Double bs_netAmt;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnBack;
	private JButton btnBcgrnd;
	private JButton btnClose;
	private JLabel compname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					account_BSNew window = new account_BSNew();
					window.bsFrameNew.setVisible(true);
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
	public account_BSNew() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		bsFrameNew = new JFrame();
		bsFrameNew.setIconImage(
				Toolkit.getDefaultToolkit().getImage(account_BSNew.class.getResource("/RetailProduct/mymain.png")));
		bsFrameNew.setResizable(false);
		bsFrameNew.setAlwaysOnTop(true);
		bsFrameNew.setBounds(1, 1, 1350, 750);
		bsFrameNew.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		bsFrameNew.getContentPane().setLayout(null);

		internalFrame = new JInternalFrame("");

		internalFrame.setBounds(0, 0, 1350, 717);
		bsFrameNew.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel basepanel = new JPanel();
		basepanel.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(0, 255, 153)));
		basepanel.setBackground(new Color(0, 0, 102));
		basepanel.setBounds(0, 0, 1350, 744);
		internalFrame.getContentPane().add(basepanel);
		basepanel.setLayout(null);

		from = new gnRoundTextField(15);
		from.setFont(new Font("Tahoma", Font.BOLD, 13));

		from.setBounds(71, 13, 116, 22);

		from.setForeground(new Color(0, 0, 102));
		basepanel.add(from);
		from.setColumns(10);

		to = new gnRoundTextField(15);
		to.setFont(new Font("Tahoma", Font.BOLD, 13));
		to.setBounds(71, 37, 116, 22);
		basepanel.add(to);
		to.setColumns(10);

		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setBounds(31, 13, 39, 16);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		basepanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setBounds(31, 37, 25, 16);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 15));
		basepanel.add(lblNewLabel_1);

		ljsp = new JScrollPane();
		ljsp.setBounds(10, 97, 579, 564);
		basepanel.add(ljsp);

		rjsp = new JScrollPane();
		rjsp.setBounds(590, 95, 740, 564);
		rjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		basepanel.add(rjsp);

		JLabel lblNewLabel_2 = new JLabel("Balance Sheet ");
		lblNewLabel_2.setBounds(427, 28, 332, 22);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 22));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(102, 255, 153));
		basepanel.add(lblNewLabel_2);

		compname = new JLabel(" ");
		compname.setBounds(437, 49, 282, 16);
		compname.setForeground(new Color(0, 255, 204));
		compname.setHorizontalAlignment(SwingConstants.CENTER);
		compname.setFont(new Font("Calibri", Font.BOLD, 14));
		basepanel.add(compname);

		btnNewButton = new JButton("Liability");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ltable.requestFocus();
			}
		});
		btnNewButton.setMnemonic('L');
		btnNewButton.setBounds(12, 69, 582, 25);
		btnNewButton.setBackground(new Color(102, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 102));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 16));
		basepanel.add(btnNewButton);

		btnNewButton_1 = new JButton("Assets");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rtable.requestFocus();
			}
		});
		btnNewButton_1.setMnemonic('A');
		btnNewButton_1.setBounds(590, 69, 740, 25);
		btnNewButton_1.setBackground(new Color(102, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 102));
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 16));
		basepanel.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("Total");
		lblNewLabel_3.setBounds(393, 664, 56, 16);
		lblNewLabel_3.setForeground(Color.WHITE);
		basepanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Total");
		lblNewLabel_4.setBounds(1165, 664, 56, 16);
		lblNewLabel_4.setForeground(Color.WHITE);
		basepanel.add(lblNewLabel_4);

		btnlib = new JButton(" ");
		btnlib.setBounds(461, 660, 128, 25);
		basepanel.add(btnlib);

		btnAsset = new JButton("");
		btnAsset.setBounds(1203, 660, 127, 25);
		basepanel.add(btnAsset);

		btnBack = new JButton("Back");
		btnBack.setBounds(899, 36, 69, 25);
		btnBack.setMnemonic('B');
		btnBack.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\arrow_right.jpg"));
		basepanel.add(btnBack);

		btnBcgrnd = new JButton(" ");
		btnBcgrnd.setBounds(10, 7, 1187, 63);
		basepanel.add(btnBcgrnd);

		btnClose = new JButton("Close");
		btnClose.setBounds(1198, 7, 140, 63);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bsFrameNew.dispose();

			}
		});
		btnClose.setIcon(new ImageIcon(account_BSNew.class.getResource("/RetailProduct/delete.png")));
		btnClose.setMnemonic('C');
		basepanel.add(btnClose);
		internalFrame.setVisible(true);
		ActionListener txfield = new toLsnr();
		to.addActionListener(txfield);
		// ActionListener frmlsn= new fromLsnr();
		// from.addActionListener(frmlsn);
		ActionListener btnbk = new btnBackLsnr();
		btnBack.addActionListener(btnbk);

		decorate();
	}

	private void decorate() throws Throwable {
		new gnField().moveLeft(rtable);
		new gnField().moveLeft(ltable);
		vfinyear = new gnFinYear().getReportingFinYear();
		compname.setText(new gnConfig().getCompanyname());
		new gnStyleButton().getStyleButton(btnClose, Color.blue, Color.WHITE);
		new gnApp().setFrameTitel(bsFrameNew);
		new gnApp().setCompanyTitle(internalFrame);
		new gnField().closeform(internalFrame, bsFrameNew);
		new gnBackground().setBackground(btnBcgrnd);
		// internalFrame.setFrameIcon(new
		// ImageIcon(account_BSNew.class.getResource("/RetailProduct/Logo15.png")));

		from.setText(new gnFinYear().getFirstDateofFinYear());
		to.setText(new gnFinYear().getLastDateofFinYear());
		from.addActionListener(e -> {
			try {
				from.setText(new gnDate().getmefullDate(from.getText()));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		to.addActionListener(e1 -> {
			try {
				to.setText(new gnDate().getmefullDate(to.getText()));
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		showBSData();
	}

	class btnBackLsnr implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			String col1[] = { "Particular", "    ", "Amount", };
			rmodel.setColumnIdentifiers(col1);
			rtable.setModel(rmodel);
			rtable.setModel(rmodel);
			rtable.setRowHeight(25);
			new gnTable().setTableBasics(rtable);
			JViewport prt1 = new JViewport();
			prt1.setBackground(Color.WHITE);
			prt1.add(rtable, col1);
			prt1.setVisible(true);
			rjsp.setViewport(prt1);

		}

	}

	/*
	 * class fromLsnr implements ActionListener {
	 * 
	 * @Override public void actionPerformed(ActionEvent arg0) { try {
	 * from.setText(new gnDate().getmefullDate(from.getText())); } catch
	 * (Throwable e) { e.printStackTrace(); } } }
	 */

	class toLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				to.setText(new gnDate().getmefullDate(to.getText()));
				showBSData();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void showBSData() throws Throwable {
		new gnTable().RemoveTableRows(rmodel);
		new gnTable().RemoveTableRows(lmodel);
		String vstatus = new gnFinYear().checkDateRanegforFinyear(from.getText(), to.getText());
		if (vstatus == "Sucess") {
			nowcalculate();
			GenerateBalanceSheet();
		}
	}

	/// Pl Calculation

	private void nowcalculate() throws Throwable {

		String col[] = { "Particular", "    ", "Amount", };
		lmodel.setColumnIdentifiers(col);
		ltable.setModel(lmodel);
		JViewport prt = new JViewport();
		prt.setBackground(Color.WHITE);
		prt.add(ltable, col);
		prt.setVisible(true);
		ljsp.setViewport(prt);
		ltable.setRowHeight(25);
		new gnTable().setTableBasics(ltable);

		String col1[] = { "Particular", "    ", "Amount", };
		rmodel.setColumnIdentifiers(col1);
		rtable.setModel(rmodel);
		rtable.setModel(rmodel);
		rtable.setRowHeight(25);
		new gnTable().setTableBasics(rtable);
		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.WHITE);
		prt1.add(rtable, col1);
		prt1.setVisible(true);
		rjsp.setViewport(prt1);

		String vfrom = from.getText();
		String vto = to.getText();
		rtable.setRowSelectionAllowed(true);
		ltable.setRowSelectionAllowed(true);

		// GeneralData in Closing Data For Gl /Group/SubGroup in
		// Ms_account_gl/Group and subgroup tabls
		// based on This Data Balance Sheet Data Will Show
		// Calculate Closing of last year and assin opening balances
		String vfinyear = new gnFinYear().getReportingFinYear();

		vfrom = from.getText();
		vto = to.getText();
		if (isledgerRun == "N") {
			new gnAccountbase().Calculate_glClosingBalancesForSite(vfrom, vto, vfinyear);
			new gnAccountbase().Calculate_Group_ClosingBalancesForSite(vfrom, vto, vfinyear);
		}
		isledgerRun = "Y";
		// 1. Get Op Stock
		vopbal = new gnAccountbase().get_groupOpeningAmountForSite("15");
		if (vopbal == null) {
			vopbal = "0.00";
		}
		lmodel.addRow(new Object[] { "Opening Stock", " ", vopbal });
		lmodel.addRow(new Object[] { "", " ", "" });

		String vdrcrtype = "";
		String vcode = " ";
		String vname = "";
		String vclosingbal = "";

		// Income side Populae from table directily new logic
		String vtype = "Income";
		rs = new gnAccountbase().getAccountClosingDataForSite(vtype);

		while (rs.next()) {
			vcode = rs.getString(1);
			vname = rs.getString(2);
			vclosingbal = rs.getString(5);
			vdrcrtype = rs.getString(6);
			if (Double.parseDouble(vclosingbal) > 0) {
				setIncomevalueintable(vcode, vname, vclosingbal, vdrcrtype);
			}
		}
		//

		// Expenses side Populae from table directily new logic
		vtype = "Expences";
		rs1 = new gnAccountbase().getAccountClosingDataForSite(vtype);
		while (rs1.next()) {
			vcode = rs1.getString(1);
			vname = rs1.getString(2);
			vclosingbal = rs1.getString(5);
			vdrcrtype = rs1.getString(6);
			if (Double.parseDouble(vclosingbal) > 0) {
				setExpensevalueintable(vcode, vname, vclosingbal, vdrcrtype);
			}
		}
		//

		// Get closing Stock
		vclosingStock = "0";
		vclosingStock = new gnAccountbase().get_groupClosingAmountForSite("15");

		if (vclosingStock == null) {
			vclosingStock = "0.00";
		}

		String vdrcrType = new gnAccountbase().getFinalDrcrtype();
		switch (vdrcrType) {
		case "Cr":
			lmodel.addRow(new Object[] { "Closing Stock Value", "", vclosingStock });
			totalLBal = totalLBal + Double.parseDouble(vclosingStock);
			break;
		case "Dr":
			rmodel.addRow(new Object[] { "Closing Stock Value", "", vclosingStock });
			totalRBal = totalRBal + Double.parseDouble(vclosingStock);
			break;
		}
		//

		rmodel.addRow(new Object[] { "=====", "", "----------------" });
		lmodel.addRow(new Object[] { "=====", "", "=========" });

		rmodel.addRow(new Object[] { "Total", " ", totalRBal });
		lmodel.addRow(new Object[] { "Total", " ", totalLBal });

		rmodel.addRow(new Object[] { "=====", "", "-----------------" });
		lmodel.addRow(new Object[] { "=====", "", "=========" });
		if (totalRBal > totalLBal) {

			Double vrbal = (double) Math.round(totalRBal - totalLBal);
			lmodel.addRow(new Object[] { "Net Profit", "=====> ", vrbal });
			vnetprofit = vrbal;
		}

		if (totalLBal > totalRBal) {

			Double vlbal = (double) Math.round(totalLBal - totalRBal);
			rmodel.addRow(new Object[] { "Net Loss", "=====> ", vlbal });
			vnetloss = vlbal;

		}

		if (totalRBal == totalLBal) {
			rmodel.addRow(new Object[] { "Net Loss", "=====> ", "0" });
			vnetprofit = 0.00;
		}
		SelectrowLtable();
		SelectrowRtable();
	}

	private void setIncomevalueintable(String vvcode, String vvname, String vvclosingbal, String vvdrcrtype) {

		switch (vvdrcrtype) {
		case "Dr":
			lmodel.addRow(new Object[] { vvname, " ", vvclosingbal });
			totalLBal = totalLBal + Double.parseDouble(vvclosingbal);
			break;
		case "Cr":
			rmodel.addRow(new Object[] { vvname, " ", vvclosingbal });
			totalRBal = totalRBal + Double.parseDouble(vvclosingbal);
			break;
		}
	}

	private void setExpensevalueintable(String vvcode, String vvname, String vvclosingbal, String vvdrcrtype) {

		switch (vvdrcrtype) {
		case "Cr":
			rmodel.addRow(new Object[] { vvname, "", vvclosingbal });
			totalRBal = totalRBal + Double.parseDouble(vvclosingbal);
			break;
		case "Dr":
			lmodel.addRow(new Object[] { vvname, " ", vvclosingbal });
			totalLBal = totalLBal + Double.parseDouble(vvclosingbal);
			break;
		}
	}

	//// Balance Sheet from Herer
	private void GenerateBalanceSheet() {
		new gnTable().RemoveTableRows(rmodel);
		new gnTable().RemoveTableRows(lmodel);
		try {
			getBalanceSheet();
		} catch (Throwable e) {
			e.printStackTrace();
			new General().msg(e.getLocalizedMessage());
		}
	}

	private void getBalanceSheet() throws Throwable {
		totalRBal = 0.00;
		totalLBal = 0.00;
		String vfrom = from.getText();
		String vto = to.getText();
		String col2[] = { "Particular", "    ", "Amount", };

		String vdrcrtype = "";
		String vcode = " ";
		String vname = "";
		String vclosingbal = "";

		// Income side Populae from table directily new logic
		String vtype = "Asset";
		rs = new gnAccountbase().getAccountClosingDataForSite(vtype);

		while (rs.next()) {
			vcode = rs.getString(1);
			vname = rs.getString(2);
			vclosingbal = rs.getString(5);
			vdrcrtype = rs.getString(6);
			if (Double.parseDouble(vclosingbal) >= 0) {
				BalsetIncomevalueintable(vcode, vname, vclosingbal, vdrcrtype);
			}
		}
		//

		// Expenses side Populae from table directily new logic

		vtype = "Liabilities";
		rs1 = new gnAccountbase().getAccountClosingDataForSite(vtype);
		while (rs1.next()) {
			vcode = rs1.getString(1);
			vmycode = vcode;
			vname = rs1.getString(2);
			vclosingbal = rs1.getString(5);
			vdrcrtype = rs1.getString(6);

			if (Double.parseDouble(vclosingbal) >= 0) {
				BalsetExpensevalueintable(vcode, vname, vclosingbal, vdrcrtype);
			}
		}

		//
		// P%L Set in Balance Sheet
		// new General().msg("Asset Total"+ totalRBal +" "+"Lib"+" "+totalLBal);

		if (vnetprofit >= 0) {
			// lmodel.addRow(new Object[] {"P&L Account Net Profit", " ",
			// vnetprofit});
			// totalRBal = totalRBal+(vnetprofit) ;

			lmodel.addRow(new Object[] { "P&L Account Net Profit", " ", vnetprofit });
			totalLBal = totalLBal + (vnetprofit);

		}

		if (vnetloss > 0) {
			// rmodel.addRow(new Object[] {"P&L Account Net Loss", " ",
			// vnetloss});
			// totalLBal = totalLBal+(vnetloss) ;

			rmodel.addRow(new Object[] { "P&L Account Net Loss", " ", vnetloss });
			totalRBal = totalRBal + (vnetloss);

		}

		// P&L End
		/*
		 * if (totalLBal == totalRBal) { //new General().msg("Asset Total"+
		 * totalRBal +"   "+"Lib"+" "+totalLBal+" ====>"+"No Profit-NoLoss"); //
		 * rmodel.addRow(new Object[] {"c/f Capital Account", " ",
		 * totalRBal-totalLBal}); }
		 * 
		 * if (totalRBal > totalLBal) { //new General().msg("Asset Total"+
		 * totalRBal +"   "+"Lib"+" "+totalLBal); // lmodel.addRow(new Object[]
		 * {"c/f Capital Account", " ", totalRBal-totalLBal}); }
		 * 
		 * if (totalLBal > totalRBal) { // rmodel.addRow(new Object[] {
		 * "c/d Capital Account", " ", totalLBal-totalRBal}); }
		 */
		setfinalvalue();
	}

	private void setfinalvalue() {
		// Math. round(
		// btnAsset.setText( Double.toString(Math. round(new
		// gnTable().getTotal(rtable, 2))));
		// btnlib.setText( Double.toString(Math. round(new
		// gnTable().getTotal(ltable, 2))));

		btnAsset.setText(Double.toString(Math.round(totalLBal)));
		btnlib.setText(Double.toString(Math.round(totalRBal)));

	}

	private void BalsetIncomevalueintable(String vvcode, String vvname, String vvclosingbal, String vvdrcrtype) {

		switch (vvdrcrtype) {

		case "Cr":
			lmodel.addRow(new Object[] { vvname, " ", vvclosingbal });
			totalLBal = totalLBal + Double.parseDouble(vvclosingbal);
			break;
		case "Dr":
			rmodel.addRow(new Object[] { vvname, " ", vvclosingbal });
			totalRBal = totalRBal + Double.parseDouble(vvclosingbal);
			break;
		}

	}

	private void BalsetExpensevalueintable(String vvcode, String vvname, String vvclosingbal, String vvdrcrtype) {
		// new General().msg(vvcode);

		switch (vvdrcrtype) {
		case "Cr":
			lmodel.addRow(new Object[] { vvname, "", vvclosingbal });
			totalLBal = totalLBal + Double.parseDouble(vvclosingbal);
			break;
		case "Dr":

			switch (vmycode) {
			case "7":
				lmodel.addRow(new Object[] { vvname, " ", vvclosingbal });
				totalLBal = totalLBal - Double.parseDouble(vvclosingbal);
				break;
			default:
				rmodel.addRow(new Object[] { vvname, " ", vvclosingbal });
				totalRBal = totalRBal + Double.parseDouble(vvclosingbal);
				break;
			}
			break;
		}
	}
	// End Pl Calculation

	public void SelectrowRtable() {
		rtable.requestFocus();
		rtable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		rtable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = rtable.getSelectedRow();
				String value = (String) rtable.getValueAt(row, 0);
				try {
					display(row, value);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
	}

	public void SelectrowLtable() {
		ltable.requestFocus();
		ltable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		ltable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = ltable.getSelectedRow();
				String value = (String) ltable.getValueAt(row, 0);
				try {
					display(row, value);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
	}

	private void display(int row, String value) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		new gnTable().RemoveTableRows(vmodel);

		String vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
		String vto = new gnConfig().date_ConverttoDBforamt(to.getText());
		String vtype = "Month";

		String SQL = "Call    Account_viewAllaccountForSite('" + vtype + "' , " + vcomp + " ," + vstore + " , '" + vfrom
				+ "' , '" + vto + "' , '" + value + "'  , '" + vfinyear + "')";
		String col[] = { "Code", "Name", "Op.Bal", "DrcrType", "Debit", "Credit", "Cl.Bal", "DrcrType" };
		vmodel.setColumnIdentifiers(col);
		vtable.setModel(vmodel);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vmodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
		}
		JViewport prt7 = new JViewport();
		prt7.setBackground(Color.WHITE);
		prt7.add(vtable, col);
		prt7.setVisible(true);
		rjsp.setViewport(prt7);
		vtable.setRowHeight(25);
	}

}// Last

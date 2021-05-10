package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class account_PLNew extends getResultSet {

	JFrame plFramenew;
	private JTextField from;
	private JTextField to;
	String vclosingStock;
	String vdirectIncome;
	String vsalesret;
	String vsales;
	String vdirectExp;
	String vpurchaseret;
	JButton btnClose;
	String vpurchase;
	String GFside;
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
	Double netpur = 0.00;
	Double netSales = 0.00;

	JInternalFrame internalFrame;

	JScrollPane rjsp;
	JScrollPane ljsp;
	JTable ltable = new JTable() {
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

	DefaultTableModel lmodel = new DefaultTableModel();

	JTable rtable = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			}

			return componentt;
		}
	};

	DefaultTableModel rmodel = new DefaultTableModel();
	private JButton btnBcgrnd;
	private JLabel compname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					account_PLNew window = new account_PLNew();
					window.plFramenew.setVisible(true);
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
	public account_PLNew() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		plFramenew = new JFrame();
		plFramenew.setResizable(false);
		plFramenew.setAlwaysOnTop(true);
		plFramenew.setBounds(1, 1, 1350, 750);
		plFramenew.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		plFramenew.getContentPane().setLayout(null);

		internalFrame = new JInternalFrame("");
		internalFrame.setBounds(0, 0, 1350, 750);
		plFramenew.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel basepanel = new JPanel();
		basepanel.setBorder(new MatteBorder(7, 7, 7, 7, (Color) new Color(102, 255, 102)));
		basepanel.setBackground(new Color(0, 0, 51));
		basepanel.setBounds(0, 0, 1350, 750);
		internalFrame.getContentPane().add(basepanel);
		basepanel.setLayout(null);

		from = new gnRoundTextField(15);
		from.setFont(new Font("Tahoma", Font.BOLD, 13));

		from.setBounds(71, 24, 116, 22);
		basepanel.add(from);
		from.setColumns(10);

		to = new gnRoundTextField(15);
		to.setFont(new Font("Tahoma", Font.BOLD, 13));
		to.setBounds(71, 48, 116, 22);
		basepanel.add(to);
		to.setColumns(10);

		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setBounds(31, 24, 39, 16);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		basepanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setBounds(31, 48, 25, 16);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 15));
		basepanel.add(lblNewLabel_1);

		ljsp = new JScrollPane();
		ljsp.setBounds(12, 97, 582, 505);
		basepanel.add(ljsp);

		rjsp = new JScrollPane();
		rjsp.setBounds(590, 97, 735, 505);
		rjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		basepanel.add(rjsp);

		JLabel lblNewLabel_2 = new JLabel(" PROFIT AND LOSS  ACCOUNT ");
		lblNewLabel_2.setBounds(427, 28, 324, 16);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(153, 255, 153));
		basepanel.add(lblNewLabel_2);

		compname = new JLabel(" ");
		compname.setHorizontalAlignment(SwingConstants.CENTER);
		compname.setForeground(new Color(0, 255, 204));
		compname.setFont(new Font("Cambria", Font.BOLD, 14));
		compname.setBounds(437, 51, 358, 16);
		basepanel.add(compname);

		JButton btnNewButton = new JButton("Expenses");
		btnNewButton.setBounds(12, 72, 582, 25);
		btnNewButton.setBackground(new Color(102, 255, 255));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(0, 0, 51));
		basepanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Income");
		btnNewButton_1.setBounds(590, 72, 735, 25);
		btnNewButton_1.setBackground(new Color(102, 255, 255));
		btnNewButton_1.setForeground(new Color(0, 0, 51));
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 18));
		basepanel.add(btnNewButton_1);

		btnBcgrnd = new JButton(" ");
		btnBcgrnd.setBounds(12, 10, 1177, 60);
		basepanel.add(btnBcgrnd);

		btnClose = new JButton("Close");
		btnClose.setBounds(1189, 10, 136, 60);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				plFramenew.dispose();
			}
		});
		btnClose.setIcon(new ImageIcon(account_PLNew.class.getResource("/RetailProduct/delete.png")));
		btnClose.setMnemonic('C');
		basepanel.add(btnClose);
		internalFrame.setVisible(true);
		ActionListener txfield = new toLsnr();
		to.addActionListener(txfield);
		// ActionListener frmlsn= new fromLsnr();
		// from.addActionListener(frmlsn);

		decorate();
	}

	private void decorate() throws Throwable {
		new gnStyleButton().getStyleButton(btnClose, Color.blue, Color.WHITE);
		compname.setText(new gnConfig().getCompanyname());

		new gnApp().setFrameTitel(plFramenew);
		new gnField().closeform(internalFrame, plFramenew);
		new gnApp().setCompanyTitle(internalFrame);
		new gnBackground().setBackground(btnBcgrnd);
		from.setText(new gnFinYear().getFirstDateofFinYear());
		to.setText(new gnFinYear().getLastDateofFinYear());

		from.addActionListener(e -> {
			try {
				from.setText(new gnDate().getmefullDate(from.getText()));
			} catch (Exception e1) {
				new General().msg(e1.getLocalizedMessage());
			}
		});
		showPLData();
	}

	class toLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				to.setText(new gnDate().getmefullDate(to.getText()));
				new gnTable().RemoveTableRows(rmodel);
				new gnTable().RemoveTableRows(lmodel);
				showPLData();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void showPLData() throws Throwable {
		String vstatus = new gnFinYear().checkDateRanegforFinyear(from.getText(), to.getText());
		if (vstatus == "Sucess") {
			nowcalculate();
		}

	}

	private void nowcalculate() throws Throwable {

		String col[] = { "Particular", "    ", "Amount", };
		lmodel.setColumnIdentifiers(col);
		ltable.setModel(lmodel);
		JViewport prt = new JViewport();
		// prt.setBackground(Color.WHITE);
		prt.add(ltable, col);
		prt.setVisible(true);
		ljsp.setViewport(prt);
		ltable.setBackground(Color.WHITE);
		ltable.setForeground(Color.blue);
		ltable.setRowHeight(20);
		ltable.requestFocus();
		new gnTable().setTableBasics(ltable);
		new gnFontSetting().setMyFontBold(table, "F1", 25);

		// RTable Statrd here

		String col1[] = { "Particular", "    ", "Amount", };
		rmodel.setColumnIdentifiers(col1);
		rtable.setModel(rmodel);
		rtable.setModel(rmodel);
		rtable.setBackground(Color.WHITE);
		rtable.setForeground(Color.blue);
		rtable.setRowHeight(20);
		rtable.requestFocus();
		new gnTable().setTableBasics(rtable);
		new gnFontSetting().setMyFontBold(rtable, "F1", 16);

		JViewport prt1 = new JViewport();
		// prt1.setBackground(Color.WHITE);
		prt1.add(rtable, col1);
		prt1.setVisible(true);
		rjsp.setViewport(prt1);
		String vfrom = from.getText();
		String vto = to.getText();
		String vfinyear = new gnFinYear().getReportingFinYear();
		vfrom = from.getText();
		vto = to.getText();
		if (isledgerRun == "N") {

			new gnAccountbase().Calculate_glClosingBalancesForSite(vfrom, vto, vfinyear);
			new gnAccountbase().Calculate_Group_ClosingBalancesForSite(vfrom, vto, vfinyear);
		}
		isledgerRun = "Y";

		//

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
			totalRBal = totalRBal + (Double.parseDouble(vclosingStock));
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
		}

		if (totalLBal > totalRBal) {

			Double vlbal = (double) Math.round(totalLBal - totalRBal);
			rmodel.addRow(new Object[] { "Net Loss", "=====> ", vlbal });

		}

		if (totalRBal == totalLBal) {
			rmodel.addRow(new Object[] { "Net Profit & Loss  ", "=====> ", "0" });
		}

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
}// Last

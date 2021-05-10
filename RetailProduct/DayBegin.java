package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
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
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import javax.swing.JTabbedPane;

public class DayBegin extends getResultSet implements KeyListener {

	private static final Object DELETE = "Delete";
	JFrame DayBeginFrame;
	private JTextField systemdate;
	private JTextField sitecode;
	private JTextField terminalid;
	private JTextField beginDate;
	private JTextField sitename;
	JButton btnConfirm;
	String begincheck = "Fail";

	JButton btnBcgrnd;
	private JInternalFrame internalFrame;
	public static String reopen = "N";
	private JButton btnDayEnd;
	JButton btnSync;
	JLabel msg;
	// ===
	public JScrollPane jsp;
	public String Col[] = { "Store code", "Name", "BeginDate", "Begin Flag", "End Date ", "EndFlag",
			"Declaration Complete" };
	private JTextField companycode;
	private JTextField companyname;

	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 1 || column == 2 || column == 3 || column == 4 || column == 5 || column == 6
					? true : false;
		}
	};

	//// Table Related
	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 3 || column == 4 || column == 5 || column == 6) {
				componentt.setBackground(Color.cyan);
				componentt.setForeground(Color.black);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.BOLD, 12));

			} else {
				componentt.setBackground(Color.white);
				componentt.setForeground(Color.BLUE);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}
			return componentt;
		}
	};

	private JTextField finyear;
	private JLabel lblNewLabel_3;
	private JButton btnFloat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DayBegin window = new DayBegin();
					window.DayBeginFrame.setVisible(true);
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
	public DayBegin() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {

		DayBeginFrame = new JFrame();
		DayBeginFrame.setType(Type.UTILITY);
		DayBeginFrame.setResizable(false);
		DayBeginFrame.setAlwaysOnTop(true);
		DayBeginFrame.setTitle("Business Application");
		DayBeginFrame.setBounds(400, 125, 600, 466);
		DayBeginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		DayBeginFrame.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 600, 421);
		DayBeginFrame.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		internalFrame = new JInternalFrame("Day Begin Function");
		internalFrame.getContentPane().setBackground(Color.CYAN);
		internalFrame.setBounds(0, 0, 588, 421);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 102));
		panel.setForeground(Color.RED);
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(0, 51, 153), new Color(255, 255, 255),
				SystemColor.window, null));
		panel.setBounds(0, 0, 572, 122);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblTerminalId = new JLabel("Terminal ID");
		lblTerminalId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTerminalId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTerminalId.setForeground(Color.WHITE);
		lblTerminalId.setBounds(2, 56, 88, 16);
		panel.add(lblTerminalId);

		JLabel lblStoreCode = new JLabel("Store Code ");
		lblStoreCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStoreCode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStoreCode.setForeground(Color.WHITE);
		lblStoreCode.setBounds(2, 32, 88, 16);
		panel.add(lblStoreCode);

		JLabel lblSystemDate = new JLabel("System Date");
		lblSystemDate.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSystemDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSystemDate.setForeground(Color.WHITE);
		lblSystemDate.setBounds(382, 29, 94, 16);
		panel.add(lblSystemDate);

		systemdate = new JTextField();
		systemdate.setHorizontalAlignment(SwingConstants.LEFT);
		systemdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		systemdate.setForeground(Color.BLUE);
		systemdate.setEditable(false);
		systemdate.setBounds(479, 26, 88, 22);
		panel.add(systemdate);
		systemdate.setColumns(10);
		new General().setDate(systemdate);

		sitecode = new JTextField();
		sitecode.setForeground(Color.WHITE);
		sitecode.setFont(new Font("Tahoma", Font.BOLD, 13));
		sitecode.setBackground(new Color(102, 0, 153));
		sitecode.setBounds(94, 29, 52, 22);
		panel.add(sitecode);
		sitecode.setColumns(10);
		sitecode.setEnabled(false);

		terminalid = new JTextField();
		terminalid.setForeground(Color.WHITE);
		terminalid.setFont(new Font("Cambria", Font.BOLD, 11));
		terminalid.setBackground(new Color(51, 51, 102));
		terminalid.setBounds(94, 53, 52, 22);
		panel.add(terminalid);
		terminalid.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(0, 77, 585, 43);
		panel.add(panel_1);
		panel_1.setLayout(null);

		// beginDate = new JTextField()
		beginDate = new gnRoundTextField(20)

		{
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		beginDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		beginDate.setBounds(204, 7, 133, 30);
		panel_1.add(beginDate);
		beginDate.setColumns(10);

		// btnConfirm = new JButton("Open Day");
		btnConfirm = new gnRoundButton("Open Day");
		btnConfirm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int vkey = e.getKeyCode();
				if (vkey == 10) {
					btnConfirm.setBackground(Color.magenta);
					btnConfirm.setForeground(Color.WHITE);
					btnConfirm.doClick();
				}
			}
		});

		btnConfirm.setForeground(Color.DARK_GRAY);
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnConfirm.setMnemonic('O');
		btnConfirm.setBackground(Color.WHITE);
		btnConfirm.setBounds(337, 7, 105, 30);
		panel_1.add(btnConfirm);

		// btnDayEnd = new JButton("Day End");
		btnDayEnd = new gnRoundButton("Day  End");
		btnDayEnd.setForeground(Color.DARK_GRAY);
		btnDayEnd.setMnemonic('D');
		btnDayEnd.setBackground(Color.WHITE);
		btnDayEnd.setBounds(445, 7, 128, 30);
		panel_1.add(btnDayEnd);
		JLabel lblNewLabel = new JLabel("Enter Day Open Date");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 9, 180, 25);
		panel_1.add(lblNewLabel);

		lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setIcon(null);
		lblNewLabel_3.setBounds(31, 0, 542, 43);
		panel_1.add(lblNewLabel_3);
		ActionListener abc = new lsnr();
		btnConfirm.addActionListener(abc);
		btnDayEnd.addActionListener(abc);

		sitename = new JTextField();
		sitename.setForeground(Color.WHITE);
		sitename.setFont(new Font("Tahoma", Font.BOLD, 13));
		sitename.setBackground(new Color(102, 0, 153));
		sitename.setBounds(147, 29, 223, 22);
		panel.add(sitename);
		sitename.setColumns(10);
		sitename.setEnabled(false);

		JLabel lblDdmmyyyyDateFormat = new JLabel("[DD.MM.YYYY Date Format]");
		lblDdmmyyyyDateFormat.setFont(new Font("Arial Narrow", Font.BOLD, 13));
		lblDdmmyyyyDateFormat.setForeground(Color.WHITE);
		lblDdmmyyyyDateFormat.setBounds(183, 55, 215, 16);
		panel.add(lblDdmmyyyyDateFormat);

		JLabel lblCompany = new JLabel("Company");
		lblCompany.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompany.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCompany.setForeground(Color.WHITE);
		lblCompany.setBounds(12, 10, 78, 16);
		panel.add(lblCompany);

		companycode = new JTextField();
		companycode.setEnabled(false);
		companycode.setForeground(Color.WHITE);
		companycode.setFont(new Font("Tahoma", Font.BOLD, 13));
		companycode.setBackground(new Color(102, 0, 153));
		companycode.setBounds(94, 7, 52, 22);
		panel.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setEnabled(false);
		companyname.setForeground(Color.WHITE);
		companyname.setFont(new Font("Tahoma", Font.BOLD, 13));
		companyname.setBackground(new Color(102, 0, 153));
		companyname.setBounds(147, 7, 223, 22);
		panel.add(companyname);
		companyname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Fin.Year");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(382, 9, 94, 16);
		panel.add(lblNewLabel_1);

		finyear = new JTextField();
		finyear.setHorizontalAlignment(SwingConstants.LEFT);
		finyear.setForeground(new Color(0, 0, 153));
		finyear.setFont(new Font("Tahoma", Font.BOLD, 11));
		finyear.setBounds(479, 6, 88, 22);
		panel.add(finyear);
		finyear.setColumns(10);

		btnBcgrnd = new JButton(" ");
		btnBcgrnd.setIcon(new ImageIcon(DayBegin.class.getResource("/RetailProduct/panel2.png")));
		btnBcgrnd.setBackground(new Color(204, 51, 153));
		btnBcgrnd.setBounds(0, 2, 585, 75);
		panel.add(btnBcgrnd);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(452, 67, 5, 5);
		panel.add(tabbedPane);

		JPanel dpanel = new JPanel();
		dpanel.setBounds(0, 152, 572, 222);
		internalFrame.getContentPane().add(dpanel);
		dpanel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 37, 572, 198);
		dpanel.add(panel_2);
		panel_2.setLayout(null);

		jsp = new JScrollPane();
		jsp.setBounds(0, 13, 572, 172);
		panel_2.add(jsp);

		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\panel2.png"));
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(0, 0, 572, 185);
		panel_2.add(lblNewLabel_2);

		msg = new JLabel("msg");
		msg.setBackground(Color.WHITE);
		msg.setFont(new Font("Tahoma", Font.BOLD, 14));
		msg.setHorizontalAlignment(SwingConstants.CENTER);
		msg.setForeground(new Color(0, 0, 102));
		msg.setBounds(145, 2, 291, 38);
		dpanel.add(msg);

		btnSync = new JButton("Sync Data");
		btnSync.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSync.setMnemonic('S');
		btnSync.setBounds(438, 0, 134, 38);
		ActionListener synclsnr = new syncLsnr();
		btnSync.addActionListener(synclsnr);
		dpanel.add(btnSync);
		
		btnFloat = new JButton("Issue Float Cash");
		btnFloat.setForeground(Color.BLACK);
		btnFloat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
 		btnFloat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashDeposit_Withdraw window;
				try {
					window = new cashDeposit_Withdraw();
					window.cashdepost_wdrw.setVisible(true);
 				} catch (Throwable e1) {
 					e1.printStackTrace();
				}
  			}
		});
		btnFloat.setBounds(0, -1, 147, 38);
		dpanel.add(btnFloat);

		// JButton btnDayBeginDate = new JButton("Day Begin Date is Important
		// For Billing. Please Make Sure Correct Date is Enter For Billing ");
		JButton btnDayBeginDate = new gnRoundButton(
				"Day Begin Date is Important For Billing. Please Make Sure Correct Date is Enter For Billing ");
		btnDayBeginDate.setHorizontalAlignment(SwingConstants.LEFT);
		btnDayBeginDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		new gnFontSetting().setMyFont(btnDayBeginDate, "F1", 14);
		btnDayBeginDate.setBounds(0, 120, 572, 34);
		internalFrame.getContentPane().add(btnDayBeginDate);
		btnDayBeginDate.setForeground(Color.BLACK);
		btnDayBeginDate.setBackground(Color.WHITE);
		internalFrame.setVisible(true);

		ActionListener dt1 = new fromdateLsnr();
		beginDate.addActionListener(dt1);

		ActionListener finls = new finLsnr();
		finyear.addActionListener(finls);

		decorate();
		String vfinyear = new gnFinYear().getReportingFinYear();
		showTable(vfinyear);
	}

	class syncLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				syncStockArticle();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class fromdateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				beginDate.setText(new gnDate().getmefullDate(beginDate.getText()));
				// fromdateLsnr
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
			}
		}
	}

	private void decorate() throws Throwable {
		new gnBackground().setBackground(btnBcgrnd);
		new gnApp().setFrameTitel(DayBeginFrame);
		internalFrame.addKeyListener(this);
		new gnField().closeform(internalFrame, DayBeginFrame);
		new gnField().closeform(internalFrame, DayBeginFrame);
		beginDate.setText(new General().getDate());
		msg.setText("Please Check Open Date And Confirm");
		String vcurFinyear = new gnFinYear().getReportingFinYear();
		finyear.setText(vcurFinyear);

		new gnDecorate().decorateBtn(btnDayEnd, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnSync, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnConfirm, new Color(120, 151, 112), Color.WHITE);

		// new gnStyleButtonSqr().getStyleButton(btnConfirm,new Color(178, 11,
		// 112) , Color.WHITE) ;
		// new gnStyleButtonSqr().getStyleButton(btnDayEnd, new Color(178, 11,
		// 112) , Color.white) ;
		// new gnStyleButtonSqr().getStyleButton(btnSync, new Color(131, 211,
		// 112), Color.white) ;

		btnDayEnd.setFont(new Font("Tahoma", Font.BOLD, 14));
		// btnConfirm.setFont(new Font("Agency FB", Font.BOLD, 20));
 
		String vpara701 = "701";
		new getConfigurationSetting().setBtnConfig(btnFloat, vpara701);

 
		
	}

	public void keyTyped(KeyEvent input) {
		char key = input.getKeyChar();
		new General().msg("Value is" + " " + key);
		if (key == 'x')
			System.exit(0);
	}

	public void keyPressed(KeyEvent txt) {
		// do nothing
	}

	public void keyReleased(KeyEvent txt) {
		// do nothing
	}

	protected void showTable(String vfinyear) throws Throwable {
		this.checkInternet();
		new gnApp().setFrameTitel(DayBeginFrame);
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		sitecode.setText(new gnConfig().getStoreID());
		String vcomp = companycode.getText();
		String vstore = sitecode.getText();
		new gnApp().setFrameTitel(DayBeginFrame);
		switch (vcomp) {
		case "0":
			new General().msg("No Company Found..");
			System.exit(0);
		}
		sitename.setText(new gnConfig().getStorename(vcomp));
		new gnTable().RemoveTableRows(model);
		String sql = "Call  Tb_GetDaybeginTableData(" + vcomp + ", " + vstore + " , '" + vfinyear + "')";
		// new General().Devmsg(sql);
		model.setColumnIdentifiers(Col);
		table.setModel(model);
		table.requestFocus();
		table.changeSelection(0, 2, true, true);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		new gnTableModel().Tablemodel(table, model, sql, Col, 7, "N", "N", "N");
		new gnTable().setTablewidth(table, 1, 400);
		new gnTable().setTablewidth(table, 2, 250);
		new gnTable().setTablewidth(table, 4, 250);
		new gnTable().setTableBasics(table);
		JViewport prt = new JViewport();
		prt.add(table, Col);
		prt.setVisible(true);
		prt.setBackground(Color.WHITE);
		jsp.setViewport(prt);
		new gnTable().setTableBasics(table);
		new gnTable().setFontBold(table, 16);
	}

	class finLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vfinyear = finyear.getText();
			try {
				showTable(vfinyear);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class lsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			if (value == "Day  End") {
				try {
					dayEnd window;
					window = new dayEnd();
					window.frameDayEnd.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Open Day") {
				try {
					Daybegindate = beginDate.getText();
					String vcheck = new General().checkProduct(compcode, myvstore); //
					switch (vcheck) {
					case "Fail":
						new General().msg("Product Key Is Expire...For New Key Contact Us.");
						DayBeginFrame.dispose();
						break;
					case "Sucess":
						String status = validate();
						if (status == "Sucess") {
							msg.setText("Validation Completed , Processing Other Data Please Wait...");
							confim();
						}
					}
				} catch (Exception e2) {
					new General().msg("confirmnk" + e2.getMessage());
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}

		private String validate() throws Throwable {
			String status = "Sucess";
			String venterDate = beginDate.getText();

			String seqAvailable = new gnSeq().checkSeqAvailableforFinyear();
			String seqforGroup = new gnSeq().checkSeqAvailableforGroups();
			String seqforSubgroup = new gnSeq().checkSeqAvailableforSubGroup();
			String seqforGL = new gnSeq().checkSeqAvailableforGL();

			
			String allow = checkFinyear();
 			switch (allow) {
			case "N":
				new General().msg("Finyear Data Not Available..");
				status = "Fail";
				DayBeginFrame.dispose();
			}

			switch (seqforGroup) {
			case "N":
				new General().msg("Account Groups Data Not Available Please Check  ");
				DayBeginFrame.dispose();
				status = "Fail";
				break;
			case "Y":
				status = "Sucess";
				break;
			}

			switch (seqforSubgroup) {
			case "N":
				new General().msg("Account Sub Group Data Not Aailable Please Check ");
				DayBeginFrame.dispose();
				status = "Fail";
				break;
			case "Y":
				status = "Sucess";
				break;
			}

			switch (seqforGL) {
			case "N":
				new General().msg("Account GL Data Not Available Please Check .. ");
				DayBeginFrame.dispose();
				status = "Fail";
				break;
			case "Y":
				status = "Sucess";
				break;
			}

			switch (seqAvailable) {
			case "N":
				new General().msg("Number  sequence is not available, Please Create Sequence.... ");
				DayBeginFrame.dispose();
				status = "Fail";
				break;
			case "Y":
				status = "Sucess";
				break;
			}

 
			//finyear check was here 
			
			if (venterDate.length() != 10) {
				new General().msg("Check Enter Date, Please Enter Date in <DD.MM.YYYY Format>");
				status = "Fail";
			}

			if (venterDate.length() > 10) {
				new General().msg("Check Enter Date, Please Enter Date in <DD.MM.YYYY Format>");
				status = "Fail";
			}

			return status;
		}

		public void confim() throws Throwable {
			String result = "Fail";
			String vvdate = beginDate.getText();
			String action3 = new General().getLength(beginDate, "Enter Day Begin Date");
			if (action3 == "Fail") {
				beginDate.grabFocus();
				return;
			}
			String vresult = checkDayEnd();
			if (vresult == "Sucess") {
				int option = 0;

				if (option == 0) {
					msg.setText("Checking Sales For Day");
					String action = CheckSalesAndDayEnd();
				}
			}
		}

		public String checkDayEnd() throws Throwable {
			String vresult = "Sucess";
			String vendflag = "";
			String vbegindate = new gnConfig().date_ConverttoDBforamt(new gnConfig().getDaybeginDate());

			// new General().msg(vbegindate);
			String vstorecode = sitecode.getText();
			String vcomp = companycode.getText();
			String SQL = "call day_checkDayEnd(" + vstorecode + " , '" + vbegindate + "' , " + vcomp + ")";
			rs = new getResultSet().getSPResult(SQL);
			if (rs.next())
				vendflag = rs.getString(3);
			// new General().msg(vendflag);
			switch (vendflag) {
			case "N":
				new General().msg("Day End Is Not Done.. Complete Day End ");
				vresult = "Fail";
				break;
			}
			return vresult;
		}

		public String CheckSalesAndDayEnd() throws Throwable {
			// new General().msg("Reached Here");
			String Action = "Sucess";
			Double vamt = 0.00;
			String vend = " ";
			String vcode = new gnConfig().getStoreID();
			String vdate = new gnConfig().getDaybeginDate();
			msg.setText("Checking Day Begin Status");

			if (vdate != "1") {
				msg.setText("Day Begin is in Progress");
				CheckReopenAllow();
				// doDayBegin();
			}
			switch (vdate) {
			case "1":
				// new General().msg("Do DayBegin Always As a Good Practice.");
				break;
			}
			return Action;
		}

		private String checkFinyear() throws Throwable {
			String allow = "Y";
			String vdate = beginDate.getText();
			String result = new gnFinYear().isDateBelongstocurfinyear(vdate);
			String vcurFinyear = new gnFinYear().getCurrentFinYear(beginDate.getText());
			String vsetFinyear = new gnFinYear().getReportingFinYear();
			if (result != "Sucess") {
				new General().msg("Enter date is not  belongs to Current Financial Year" + " Begin Date Fin Year is "
						+ " " + vcurFinyear + "  " + "& Current Fin Year is" + " " + vsetFinyear);
				allow = "N";
			}
			return allow;
		}

		private void CheckReopenAllow() throws Throwable {
			// new General().msg("Wel Come ..");
			String result = "Sucess";
			String vendflag = "";
			String vdate = beginDate.getText();
			String vstorecode = sitecode.getText();
			String vcomp = companycode.getText();

			String vbegindate = new gnConfig().date_ConverttoDBforamt(beginDate.getText());
			String SQL = "call day_checkDayEnd(" + vstorecode + " , '" + vbegindate + "' , " + vcomp + ")";
			rs = new getResultSet().getSPResult(SQL);

			if (!rs.next()) {
				// new General().msg("Niitn First Option : Inserting Day Begin
				// Date ");
				doDayBegin();
			} else
			// if (rs.next())
			{
				vendflag = rs.getString(3);
				switch (vendflag) {
				case "N":
					// new General().msg("Niitn : Day End Is Not Done.. Complete
					// Day End ");
					result = "Fail";
					break;

				case "Y":
					// new General().msg("Niitn : Checking Allow Day Reopn ");
					String allow = ReOpenAllow();
					switch (allow) {
					case "Y":
						// new General().msg("Niitn : Allow Sucess Now Doing Day
						// begin ");
						doDayBegin();
						break;
					}
					break;
				}
			}

		}

		private String ReOpenAllow() throws Throwable {
			String vpara28 = "28";
			String vreopenDaybeginDate = new getConfigurationSetting().getSpecificConfiguration(vpara28);
			switch (vreopenDaybeginDate) {
			case "N":
				new General().msg(
						"Reopen Back Dates Transaction Is not Allow Please change in Configuration for Parater 28 to Y");
			}
			return vreopenDaybeginDate;
		}

		private void doDayBegin() throws Throwable {
			String vvcompnaycode = new gnConfig().getCompanyCode();
			String vstore = sitecode.getText();
			String vbeginDate = new gnConfig().date_ConverttoDBforamt(beginDate.getText());
			String SQL = "Call day_RemDate(" + vvcompnaycode + ", " + vstore + " , '" + vbeginDate + "')";
			new getResultSet().getSPResult(SQL);
			prst = null;
			final int batchSize = 10;
			int TotalRecordinsert = 0;
			Connection con = new getResultSet().getConnection();
			con.setAutoCommit(false);
			String status = "Fail";
			msg.setText("Updating DayBegin Data");
			String daybegin = "Insert into daybeginend (company_code , "
					+ "site_code,    begin_date , begin_flag, Declaration_done, End_date , End_flag, AllowTransaction ,  finyear)"
					+ "values(?,?,?,?,?,?,?,?, ?)";
			try {
				prst = con.prepareStatement(daybegin);
				prst.setString(1, vvcompnaycode);
				prst.setString(2, vstore);
				prst.setString(3, vbeginDate);
				prst.setString(4, "Y");
				prst.setString(5, "N");
				prst.setString(6, null);
				prst.setString(7, "N");
				prst.setString(8, "Y");
				prst.setString(9, new gnFinYear().getReportingFinYear());
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				status = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					con.commit();
					status = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				con.commit();
			} catch (SQLException e) {
 				new General().msg(e.getLocalizedMessage());
				con.rollback();
				status = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
					new gnImageSound().playSound();
					msg.setText("Done");
					daybegindate = beginDate.getText();
					//ApplicationMenu.btnDayBeginDate.setText("Day Begin Date Is : " + daybegindate);
					ApplicationMenu.setbottomMessage() ;
					begincheck = "Sucess";
					new General().Quickmsg("Update Price Master..");
					// syncStockArticle();
					new General().Quickmsg("Day Begin is Sucessfully Done.. You Can Start Your Work...");
					DayBeginFrame.dispose();
				}
				if (con != null) {
					con.close();
				}
			}
		}
	}

	private void syncStockArticle() throws Throwable {
		String vfinyear = new gnFinYear().getReportingFinYear();
		msg.setText("Item Sync is in Progress");
		String vloc = "SL";
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);

		String SQL7 = "call  SalesPrice_updateInsert(" + vcomp + ", " + vstore + "   , " + vverticlecode + ")";
 
		msg.setText("Sales Price Sync Over...");

		// Sync Stock in Tablle for Article master
		String SQL5 = "call  Stock_syncStockArticle(" + vcomp + ",  " + vstore + " , '" + vloc + "' , '" + vfinyear
				+ "'   , " + vverticlecode + ")";
		this.getSPResult(SQL5);
		msg.setText("Stock Article sysnc ..Over ");

		// Sync Stock in Tablle for Article master

		// Sync Ean Master Table
		String SQL55 = "call  EAN_InsertEan(" + vcomp + ")";
		this.getSPResult(SQL55);
		msg.setText("Ean Sync Over .....");

		// Insert Supplier and Customer in Glmaster Table
		// new gnAccountbase().Account_InsertSupplierCust() ;
		// msg.setText("Supplier Accoun Sync Over .....");
		msg.setText("Sync Process Completed.......");
		new gnImageSound().playSound();
		new gnImageSound().playSound();

	}
	
	
}// Last

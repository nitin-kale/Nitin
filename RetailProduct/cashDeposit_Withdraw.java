package RetailProduct;

//
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
//
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class cashDeposit_Withdraw extends getResultSet {

	JFrame cashdepost_wdrw;
	private JTextField Store_code;
	private String vcomp;;
	private JTextField storename;
	private JTextField terminalID;
	private JTextField beginDate;
	private JTextField cashiercode;
	private JTextField damount;
	private JTextField wamount;
	private JButton btnSave;
	private JButton btnView;
	private String Type;
	private int TotalRecordinsert;

	///
	public DefaultTableModel dmodel = new DefaultTableModel();
	public DefaultTableModel wmodel = new DefaultTableModel();

	public JTable dtable = new JTable();
	public JTable wtable = new JTable();
	public JScrollPane djsp;
	public JScrollPane wjsp;
	public JViewport wprt = new JViewport();
	public JViewport dprt = new JViewport();
	////
	//// table data save varibale
	private String vstore;
	private String vcashier ;
	private String vdate;
	private int vterminal;
	private Double vamount;
	private JTextField shift;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;

	////
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cashDeposit_Withdraw window = new cashDeposit_Withdraw();
					window.cashdepost_wdrw.setVisible(true);
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
	public cashDeposit_Withdraw() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		cashdepost_wdrw = new JFrame();
		cashdepost_wdrw.getContentPane().setBackground(Color.WHITE);
		cashdepost_wdrw.setTitle("Business Application");
		cashdepost_wdrw.setResizable(false);
		cashdepost_wdrw.setAlwaysOnTop(true);
		cashdepost_wdrw.setBounds(400, 150, 633, 557);
		cashdepost_wdrw.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cashdepost_wdrw.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 255, 255));
		panel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 255, 0))));
		panel.setBounds(0, 51, 622, 191);
		cashdepost_wdrw.getContentPane().add(panel);
		panel.setLayout(null);

		Store_code = new JTextField();
		Store_code.setBackground(Color.WHITE);
		Store_code.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		Store_code.setEditable(false);
		Store_code.setBounds(125, 12, 63, 24);
		panel.add(Store_code);
		Store_code.setColumns(10);

		storename = new JTextField();
		storename.setBackground(Color.WHITE);
		storename.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		storename.setEditable(false);
		storename.setBounds(188, 12, 383, 24);
		panel.add(storename);
		storename.setColumns(10);

		//terminalID = new JTextField();
		terminalID = new gnRoundTextField(10);
 		terminalID.setBackground(Color.WHITE);
		terminalID.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		terminalID.setEditable(false);
		terminalID.setBounds(98, 66, 90, 24);
		panel.add(terminalID);
		terminalID.setColumns(10);

		//cashiercode = new JTextField();
		cashiercode = new gnRoundTextField(10);
 		cashiercode.setBackground(Color.WHITE);
		cashiercode.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		cashiercode.setBounds(318, 66, 106, 24);
		panel.add(cashiercode);
		cashiercode.setColumns(10);
		//cashiercode.setText(vcashier);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(
				new BevelBorder(BevelBorder.LOWERED, Color.BLUE, Color.RED, Color.DARK_GRAY, Color.LIGHT_GRAY));
		panel_2.setBackground(new Color(0, 0, 204));
		panel_2.setForeground(Color.BLUE);
		panel_2.setBounds(76, 93, 383, 68);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JButton btnDepositAmount = new JButton("Enter Float Cash");
		btnDepositAmount.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnDepositAmount.setBounds(0, 0, 185, 25);
		btnDepositAmount.setForeground(new Color(0, 0, 102));
		btnDepositAmount.setBackground(Color.WHITE);
		panel_2.add(btnDepositAmount);

		// damount = new JTextField();
		damount = new gnRoundTextField(10);
		damount.setFont(new Font("SansSerif", Font.BOLD, 18));
		damount.setBounds(0, 25, 158, 43);
		panel_2.add(damount);
		damount.setColumns(10);
		ActionListener dls = new Dlsnr();
		damount.addActionListener(dls);
		new General().setNumerOnlyforJtext(damount);

		JButton btnCashWidhdrawAmount = new JButton("Cash Pickup Amount");
		btnCashWidhdrawAmount.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnCashWidhdrawAmount.setBackground(Color.WHITE);
		btnCashWidhdrawAmount.setForeground(new Color(0, 0, 102));
		btnCashWidhdrawAmount.setBounds(182, 0, 201, 25);
		panel_2.add(btnCashWidhdrawAmount);

		// wamount = new JTextField();
		wamount = new gnRoundTextField(10);

		wamount.setFont(new Font("SansSerif", Font.BOLD, 17));
		wamount.setBounds(208, 25, 175, 43);
		panel_2.add(wamount);
		wamount.setColumns(10);
		new General().setNumerOnlyforJtext(wamount);

		lblNewLabel_6 = new JLabel(" ");
		lblNewLabel_6.setIcon(new ImageIcon(cashDeposit_Withdraw.class.getResource("/RetailProduct/rs.png")));
		lblNewLabel_6.setBounds(170, 25, 22, 43);
		panel_2.add(lblNewLabel_6);

		ActionListener wls = new Wlsnr();
		wamount.addActionListener(wls);

		JLabel lblCashierShift = new JLabel("Shift");
		lblCashierShift.setHorizontalAlignment(SwingConstants.LEFT);
		lblCashierShift.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblCashierShift.setForeground(new Color(0, 0, 153));
		lblCashierShift.setBounds(200, 49, 90, 16);
		panel.add(lblCashierShift);

		shift = new JTextField();
		shift = new gnRoundTextField(10);
 		shift.setBackground(Color.WHITE);
		shift.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		shift.setBounds(200, 66, 106, 24);
		panel.add(shift);
		shift.setColumns(10);

		JLabel lblNewLabel = new JLabel("Store Code");
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(23, 15, 90, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Terminal");
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(98, 49, 91, 16);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cashier");
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(320, 49, 91, 16);
		panel.add(lblNewLabel_2);
		// shift.setText((new gnConfig().getCashierShift(Site_code.getText(),
		// new gnConfig().date_ConverttoDBforamt(invdate.getText()) , vterminal
		// , vvcashiercode)));

		// JPanel panel_1 = new JPanel();
		JPanel panel_1 = new gnRoundPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 284, 633, 227);
		cashdepost_wdrw.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		ActionListener sv = new savelsnr();
		ActionListener vw = new savelsnr();

		wjsp = new JScrollPane();
		wjsp.setBounds(12, 131, 596, 87);
		panel_1.add(wjsp);

		djsp = new JScrollPane();
		djsp.setBounds(12, 32, 596, 86);
		panel_1.add(djsp);

		lblNewLabel_3 = new JLabel("Float cash issue to cashier");
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_3.setBounds(12, 13, 225, 16);
		panel_1.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Cash Pick up from cashier");
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_4.setBounds(12, 116, 265, 16);
		panel_1.add(lblNewLabel_4);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnSave.setBounds(290, 245, 97, 38);
		cashdepost_wdrw.getContentPane().add(btnSave);
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(Color.CYAN);

		btnView = new JButton("View");
		btnView.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnView.setBounds(388, 245, 97, 38);
		cashdepost_wdrw.getContentPane().add(btnView);
		btnView.setForeground(Color.BLACK);
		btnView.setBackground(Color.CYAN);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		btnCancel.setBounds(483, 245, 126, 38);
		cashdepost_wdrw.getContentPane().add(btnCancel);
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setBackground(Color.CYAN);

		lblNewLabel_5 = new JLabel("Float Cash & Cash Pickup");
		lblNewLabel_5.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(12, 10, 273, 28);
		cashdepost_wdrw.getContentPane().add(lblNewLabel_5);
		
				JButton btnDate = new JButton("Date ");
				btnDate.setBounds(311, 13, 97, 25);
				cashdepost_wdrw.getContentPane().add(btnDate);
				btnDate.setForeground(Color.BLUE);
				btnDate.setBackground(Color.WHITE);
				btnDate.setEnabled(false);
				
						beginDate = new JTextField();
						beginDate.setBounds(409, 13, 123, 24);
						cashdepost_wdrw.getContentPane().add(beginDate);
						beginDate.setColumns(10);
 		
		ActionListener cn = new savelsnr();
		btnCancel.addActionListener(cn);
		btnView.addActionListener(vw);
		btnSave.addActionListener(sv);
		
		decorate();
	 
	}


	public void decorate() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore  = new gnConfig().getStoreID() ;
 		Store_code.setText(vstore) ;
 		storename.setText(new gnConfig().getStorename(vstore));
		beginDate.setText(new gnConfig().getDaybeginDate());
		vdate  = new gnConfig().date_ConverttoDBforamt(beginDate.getText());
 		terminalID.setText(new gnConfig().getTerminalID());
		int vterminal = Integer.parseInt(terminalID.getText().toString());
		shift.setText((new gnConfig().getCashierShift(vcomp, vstore,
				new gnConfig().date_ConverttoDBforamt(beginDate.getText()), vterminal, cashiercode.getText())));
		cashiercode.setText(ucode);
		switch (vstore) {
		case "0":
			System.exit(0);
		}
	}

	
	class savelsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			  
			
			if (value  == "View")
			{
				try {
					showData() ;
				} catch (ClassNotFoundException | SQLException e1) {
 					e1.printStackTrace();
				}
			}
			
			if (value == "Save") {
				btnSave.setBackground(Color.RED);
				try {
					saveData();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
			 		new General().msg(e1.getLocalizedMessage());
					e1.printStackTrace();
				}
			}
			
			
			if (value == "Cancel") {
				cashdepost_wdrw.dispose();
			}
		}
	}

	private void showData() throws ClassNotFoundException, SQLException
	{
		String vtype = "FlotCash" ; 
 		String SQL = "select   site_code,   Terminal ,cashier_code, date_format(Date,'"+"%d.%m.%Y"+"') date , Amount, shift from "
				+ "cash_deposit_withdraw where date = '"+vdate+"' "
			   + "and company_code = '"+vcomp+"' and site_code = '"+vstore+"'  and type = '"+vtype+"' " ;
 		showFlowCash(SQL);
 		 
 		vtype = "Cashpickup" ;
 		SQL = "select   site_code,   Terminal ,cashier_code, date_format(Date,'"+"%d.%m.%Y"+"') date , Amount, shift from "
				+ "cash_deposit_withdraw where date = '"+vdate+"' "
				+ " and company_code = '"+vcomp+"' and site_code = '"+vstore+"'  and type = '"+vtype+"' " ;
  		showCashPickup(SQL) ;
	}

	
	private void showFlowCash(String SQL) throws ClassNotFoundException, SQLException
	{
 		String Col[] = { "Store code", "Terminal", "cashier", "Date", "Amount", "Shift" };
 		dmodel.setColumnIdentifiers(Col);
  		dtable = new gnTableModel().Tablemodel(dtable, dmodel, SQL, Col, 6, "N", "N", "N") ;
  		dtable.setModel(dmodel);
		dprt.setBackground(Color.WHITE);
		dprt.add(dtable, Col);
		dprt.setVisible(true);
		djsp.setViewport(dprt);
 	}

	private void showCashPickup(String SQL) throws ClassNotFoundException, SQLException
	{
 		String Col[] = { "Store code", "Terminal", "cashier", "Date", "Amount", "Shift" };
 		wmodel.setColumnIdentifiers(Col);
  		wtable = new gnTableModel().Tablemodel(wtable, wmodel, SQL, Col, 6, "N", "N", "N") ;
  		wtable.setModel(wmodel);
		wprt.setBackground(Color.WHITE);
		wprt.add(wtable, Col);
		wprt.setVisible(true);
		wjsp.setViewport(wprt);
 	}

	
 	
	private void removeData()
	{
		String SQL = "Delete from cash_deposit_withdraw where company_code = '"+vcomp+"' "
				+ "and site_code  = '"+vstore+"' and date = '"+vdate+"' " ;
		try {
			this.getResult(SQL) ;
		} catch (SQLException e) {
 			e.printStackTrace();
		}
	}
	
	private  void saveData() throws ClassNotFoundException, SQLException, IOException {
		int drow = dtable.getRowCount();
		int wrow = wtable.getRowCount();
		if (drow == 0 && wrow == 0) {
			new General().msg("Data Not found for Insert Data Action");
			return;
		}
		
		//removeData() ;
		
		if (drow > 0) {
			Type = "FlotCash";
			String SQL = "INSERT INTO cash_deposit_withdraw"
					+ "(company_code , site_code, Date , Type , Amount , Terminal ,cashier_code, shift) VALUES" + "(?,?,?,?,?,?,?,?)";
			Insert_into_DB(Type, SQL, dtable);
		}
		if (wrow > 0) {
			Type = "Cashpickup";
			String SQL = "INSERT INTO cash_deposit_withdraw"
					+ "(company_code , site_code, Date , Type , Amount , Terminal ,cashier_code, shift) VALUES" + "(?,?,?,?,?,?,?,?)";
			Insert_into_DB(Type, SQL, wtable);
		}
		new gnTable().RemoveTableRows(dmodel);
		new gnTable().RemoveTableRows(wmodel);
		damount.setText("0");
		wamount.setText("0");
	}

	
	public void Insert_into_DB(String Type, String SQL, JTable passtable)
			throws ClassNotFoundException, SQLException, IOException {
		prst = null;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		prst = con.prepareStatement(SQL);
		final int batchSize = 10;
		try {
			TotalRecordinsert = 0;
			int drow = passtable.getRowCount();
			for (int k = 0; k < drow; k++) {
				prst.setString(1, vcomp);
 				prst.setString(2, vstore);
				prst.setString(3, vdate );
				prst.setString(4, Type);
				prst.setDouble(5, Double.parseDouble(passtable.getValueAt(k, 4).toString()));
				prst.setInt(6, Integer.parseInt(passtable.getValueAt(k, 1).toString()));
				prst.setString(7, passtable.getValueAt(k, 2).toString());
				prst.setString(8, passtable.getValueAt(k, 5).toString());
				prst.addBatch();
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					new General().msg("Batch is Processing for " + TotalRecordinsert);
					con.commit();
				}
			}
			prst.executeBatch(); // insert remaining records
			con.commit();
			new General().msg("Total Record inseted is " + TotalRecordinsert);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
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

	
	
	class Dlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value     :" + value);
			String a = cashiercode.getText();
			if (a == "") {
				new General().msg("Enter Cashier Code First");
				return;
			}
			showTable_dep(value);
		}
	}

	public void showTable_dep(String value) {
		String Col[] = { "Store code", "Terminal", "cashier", "Date", "Amount", "Shift" };
		Class[] CClass = { String.class, Integer.class, String.class, String.class, Double.class };
		String vstorecode = Store_code.getText().trim();
		String vterminal = terminalID.getText().trim();
		String vcashier = cashiercode.getText().trim();
		String vdate = beginDate.getText().trim();
		String vdamount = (damount.getText().trim());
		String vshift = (shift.getText().trim());

  		dmodel.setColumnIdentifiers(Col);
 		dmodel.insertRow(0, new Object[] { vstorecode, vterminal, vcashier, vdate, new Integer(vdamount), vshift });
		dtable.setModel(dmodel);
		dprt.setBackground(Color.WHITE);
		dprt.add(dtable, Col);
		dprt.setVisible(true);
		djsp.setViewport(dprt);
	}

	public void showTable_wid(String value) {
		String Col[] = { "Store code", "Terminal", "cashier", "Date", "Amount", "shift" };

		String vstorecode = Store_code.getText().trim();
		String vterminal = terminalID.getText().trim();
		String vcashier = cashiercode.getText().trim();
		String vdate = beginDate.getText().trim();
		String vwamount = wamount.getText().trim();
		String vshift = (shift.getText().trim());

		wmodel.setColumnIdentifiers(Col);
		wmodel.insertRow(0, new Object[] { vstorecode, vterminal, vcashier, vdate, vwamount, vshift });
		wtable.setModel(wmodel);
		wprt.setBackground(Color.WHITE);
		wprt.add(wtable, Col);
		wprt.setVisible(true);
		wjsp.setViewport(wprt);
	}

	class Wlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value     :" + value);
			String a = cashiercode.getText();
			if (a.length() == 0 ) {
				new General().msg("Enter Cashier Code First");
				return;
			}
 			showTable_wid(value);
		}
	}
	
	
 }// Last

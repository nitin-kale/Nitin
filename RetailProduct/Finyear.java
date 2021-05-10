package RetailProduct;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class Finyear extends getResultSet {
	JPanel panel;
	JButton btnView;
	JButton btnSave;
	JButton btnClose;
	String vcomp;
	String vstore;
	String SQL;
	JScrollPane jsp;
	String vcompname;
	JLabel msg;
	String vstorename;
	

	JButton btnChangeFinYear;
	JButton btnFreezefinYear;
	

	public JTable table = new JTable();
	public DefaultTableModel model = new DefaultTableModel();

	public JTable mtable = new JTable();
	public DefaultTableModel mmodel = new DefaultTableModel();

	JFrame frameFinyear;
	private JTextField from;
	private JTextField to;
	private JLabel lblNewLabel_1;
	JCheckBox ch1;
	private JTextField finyear;
	private JTextField mycompname;
	private JTextField mystorename;
	private JTextField mycompcode;
	private JTextField mystorecode;
	JScrollPane jsp1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finyear window = new Finyear();
					window.frameFinyear.setVisible(true);
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
	public Finyear() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frameFinyear = new JFrame();
		frameFinyear.setAlwaysOnTop(true);
		frameFinyear.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frameFinyear.setBounds(450, 100, 549, 548);
		frameFinyear.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameFinyear.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 252, 531, 45);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, Color.BLACK));
		frameFinyear.getContentPane().add(panel);
		panel.setLayout(null);

		btnView = new JButton("View");
		btnView.setFont(new Font("Cambria", Font.BOLD, 16));
		btnView.setMnemonic('V');
		btnView.setBounds(336, 6, 70, 28);
		panel.add(btnView);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Cambria", Font.BOLD, 16));
		btnSave.setMnemonic('S');
		btnSave.setBounds(249, 6, 90, 28);
		panel.add(btnSave);

		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Cambria", Font.BOLD, 16));
		btnClose.setMnemonic('C');
		btnClose.setBounds(402, 6, 90, 28);
		panel.add(btnClose);

		msg = new JLabel(" ");
		msg.setForeground(new Color(0, 0, 51));
		msg.setFont(new Font("Cambria", Font.BOLD, 14));
		msg.setBounds(12, 6, 155, 28);
		panel.add(msg);

		JLabel lblNewLabel = new JLabel("Financial Year Setting ");
		lblNewLabel.setBounds(0, 0, 504, 26);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 17));
		lblNewLabel.setBackground(new Color(0, 0, 102));
		frameFinyear.getContentPane().add(lblNewLabel);

		jsp = new JScrollPane();
		jsp.setToolTipText("Create New Financial Year <Enter Proper Dates & Financial Year>");
		jsp.setBounds(0, 295, 531, 195);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frameFinyear.getContentPane().add(jsp);

		jsp1 = new JScrollPane();
		jsp1.setBounds(0, 217, 432, 165);
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel Companylbl = new JLabel("Compnay");
		Companylbl.setFont(new Font("Tahoma", Font.BOLD, 13));
		Companylbl.setHorizontalAlignment(SwingConstants.RIGHT);
		Companylbl.setBounds(10, 35, 65, 16);
		frameFinyear.getContentPane().add(Companylbl);

		JLabel lblNewLabel_3 = new JLabel("Branch");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(0, 64, 75, 16);
		frameFinyear.getContentPane().add(lblNewLabel_3);

		mycompname = new JTextField();
		mycompname.setForeground(SystemColor.inactiveCaption);
		mycompname.setEditable(false);
		mycompname.setBackground(Color.WHITE);
		mycompname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mycompname.setBounds(79, 26, 207, 30);
		frameFinyear.getContentPane().add(mycompname);
		mycompname.setColumns(10);

		mystorename = new JTextField();
		mystorename.setForeground(SystemColor.inactiveCaption);
		mystorename.setEditable(false);
		mystorename.setBackground(Color.WHITE);
		mystorename.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mystorename.setBounds(79, 57, 207, 30);
		frameFinyear.getContentPane().add(mystorename);
		mystorename.setColumns(10);

		mycompcode = new JTextField();
		mycompcode.setForeground(SystemColor.inactiveCaption);
		mycompcode.setEditable(false);
		mycompcode.setBackground(Color.WHITE);
		mycompcode.setBounds(286, 26, 64, 30);
		frameFinyear.getContentPane().add(mycompcode);
		mycompcode.setColumns(10);

		mystorecode = new JTextField();
		mystorecode.setForeground(SystemColor.inactiveCaption);
		mystorecode.setEditable(false);
		mystorecode.setBackground(Color.WHITE);
		mystorecode.setBounds(286, 57, 64, 30);
		frameFinyear.getContentPane().add(mystorecode);
		mystorecode.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("Create New Financial Year <Enter Proper Dates & Financial Year>");
		panel_1.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 102)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 119, 531, 132);
		frameFinyear.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		ch1 = new JCheckBox("Current Fin.Year");
		ch1.setToolTipText("Check If Enter Financial Year Is Current Financial Year");
		ch1.setBounds(252, 93, 181, 30);
		panel_1.add(ch1);
		ch1.setBackground(Color.WHITE);
		ch1.setForeground(new Color(0, 0, 102));
		ch1.setFont(new Font("Cambria", Font.BOLD, 16));
		
				lblNewLabel_1 = new JLabel("Fin.Year");
				lblNewLabel_1.setBounds(46, 27, 102, 16);
				panel_1.add(lblNewLabel_1);
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 14));
				
						//finyear = new JTextField();
						finyear = new gnRoundTextField(1);
						finyear.setBounds(46, 42, 122, 30);
						panel_1.add(finyear);
						
						finyear.setToolTipText("Enter Financial Year For Example -->20-21");
						finyear.setFont(new Font("Cambria", Font.BOLD, 17));
						finyear.setColumns(10);
						
								JLabel lblNewLabel_2 = new JLabel("Example-->20-21 For 2020-2021");
								lblNewLabel_2.setBounds(46, 71, 387, 26);
								panel_1.add(lblNewLabel_2);
								lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
								
										JLabel l1 = new JLabel("From");
										l1.setBounds(180, 23, 102, 19);
										panel_1.add(l1);
										l1.setFont(new Font("Arial Black", Font.BOLD, 14));
										l1.setHorizontalAlignment(SwingConstants.LEFT);
										// frameFinyear.getContentPane().add(jsp);

										from = new JTextField();
										from.setBounds(180, 42, 122, 30);
										panel_1.add(from);
										from.setToolTipText("Enter First Date of fin Year <for Example 01.04.2020>");
										from.setForeground(new Color(0, 0, 51));
										from.setFont(new Font("Cambria", Font.BOLD, 17));
										from.setColumns(10);
										
												JLabel l2 = new JLabel("To");
												l2.setBounds(309, 24, 79, 16);
												panel_1.add(l2);
												l2.setFont(new Font("Arial Black", Font.BOLD, 14));
												l2.setHorizontalAlignment(SwingConstants.LEFT);
												
														to = new JTextField();
														to.setBounds(309, 42, 122, 30);
														panel_1.add(to);
														to.setToolTipText("Enter Last Date of Fin Year < For Example 31.03.2021 >");
														to.setForeground(new Color(0, 0, 51));
														to.setFont(new Font("Cambria", Font.BOLD, 17));
														to.setColumns(10);
														
														JLabel lblNewLabel_4 = new JLabel("Create New Financial Year ");
														lblNewLabel_4.setForeground(SystemColor.inactiveCaptionText);
														lblNewLabel_4.setBounds(46, 7, 168, 16);
														panel_1.add(lblNewLabel_4);
		
		btnChangeFinYear = new JButton("Change Fin Year");
		btnChangeFinYear.setToolTipText("When Current Financial Year Data Ener Then Change Financial Year ");
		btnChangeFinYear.setBackground(new Color(0, 0, 51));
		btnChangeFinYear.setForeground(Color.WHITE);
		btnChangeFinYear.setFont(new Font("Tahoma", Font.BOLD, 13));
 		btnChangeFinYear.setBounds(389, 13, 142, 38);
		frameFinyear.getContentPane().add(btnChangeFinYear);
		 
		 
		 
		btnFreezefinYear = new JButton("Freeze Fin Year");
		btnFreezefinYear.setToolTipText("When Current Financial Year Data Ener Then Change Financial Year ");
		btnFreezefinYear.setBackground(new Color(0, 0, 51));
		btnFreezefinYear.setForeground(Color.WHITE);
		btnFreezefinYear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnFreezefinYear.setBounds(389, 60, 142, 46);
		frameFinyear.getContentPane().add(btnFreezefinYear);

		ActionListener btn1 = new btnLsnr();
		btnSave.addActionListener(btn1);
		btnView.addActionListener(btn1);
		btnClose.addActionListener(btn1);
		btnChangeFinYear.addActionListener(btn1);
		btnFreezefinYear.addActionListener(btn1);
		
		ActionListener strname = new storeLsnr();
		mystorename.addActionListener(strname);

		decorate();
	}

	public void decorate() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vcompname = new gnConfig().getCompany();
		vstore = new gnConfig().getStoreID();
		vstorename = new gnConfig().getStoreName();

		mycompcode.setText(vcomp);
		mycompname.setText(vcompname);
		mystorecode.setText(vstore);
		mystorename.setText(vstorename);

		mycompcode.setEnabled(true);
		mycompname.setEnabled(true);
		mystorecode.setEnabled(true);
		mystorename.setEnabled(true);

		switch (vcomp) {
		case "9999":
			mystorename.setEnabled(true);
		}

		new gnApp().setFrameTitel(frameFinyear);
		new gnField().closeform(panel, frameFinyear);
		String Status = checkDayEnd();
		if (Status == "Sucess") {
			ProcessViewAction();
		} else {
			ProcessViewAction();
			table.setEnabled(false);
			btnSave.setEnabled(false);
			btnView.setEnabled(false);
			btnClose.setEnabled(false);
			table.setGridColor(Color.yellow);
			table.setRowHeight(15);
		}
	}

	class storeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String vcomp = mycompcode.getText();
			String vtype = "Store";
			String SQL = "call  Tb_getallSite(" + vcomp + ")";
			new gnTable().RemoveTableRows(model);
			try {
				String RolCol[] = { "Type", "Code ", "Name", };
				mtable = new gnTableModel().Tablemodel(mtable, mmodel, SQL, RolCol, 2, "N", "Y", vtype);
				showTable(mtable, RolCol, vtype);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void showTable(JTable table, String[] Col, String vtype) throws Throwable {
		JViewport prt1 = new JViewport();
		prt1.add(table, Col);
		prt1.setVisible(true);
		jsp1.setViewport(prt1);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification);
		new General().msgsearch(jsp1, table, "Select Data For" + " " + vtype, 700, 200);
	}// End Show Table

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = mtable.getSelectedRow();
			String value = (String) mtable.getValueAt(row, 0);
			String col1 = (String) mtable.getValueAt(row, 1);
			mtable.addNotify();
			new General().msgDispose();
			// btnSave.setEnabled(false);
			try {
				showtData(value, col1, row);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	public void showtData(String value, String col1, int row) throws Exception {
		switch (value) {
		case "Company":
			mycompcode.setText(mtable.getValueAt(row, 1).toString());
			mycompname.setText(mtable.getValueAt(row, 2).toString());
			break;
		case "Store":
			mystorecode.setText(mtable.getValueAt(row, 1).toString());
			mystorename.setText(mtable.getValueAt(row, 2).toString());
			btnView.doClick();
			break;
		}
	}

	public String checkDayEnd() throws Throwable {
		String vresult = "Sucess";
		String vendflag = "";
		String vbegindate = new gnConfig().date_ConverttoDBforamt(new gnConfig().getDaybeginDate());
		String SQL = "call day_checkDayEnd(" + vstore + " , '" + vbegindate + "' , " + vcomp + ")";
		// new General().Devmsg(SQL);
		rs = new getResultSet().getSPResult(SQL);
		if (rs.next())
			vendflag = rs.getString(3);
		switch (vendflag) {
		case "N":
			new General().Quickmsg("Day End Is Not Done.. Complete Day End ");
			vresult = "Fail";
			break;
		}
		rs.close();
 		return vresult;
	}

	
	
	class btnLsnr implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			
			
			if (value == "Freeze Fin Year" )
			{
 				try {
 					FreezeFinYear window;
  					window = new FreezeFinYear();
					window.freezefinyearFrame.setVisible(true);
 				} catch (Throwable e1) {
 					e1.printStackTrace();
				}
  			}

			
			
			if (value == "Change Fin Year" )
			{
 				try {
 					selectCompany window;
  					window = new selectCompany();
					window.SelectComFrame.setVisible(true);
 				} catch (Throwable e1) {
 					e1.printStackTrace();
				}
 
			}
			
			if (value == "Close") {
				frameFinyear.dispose();
			}

			if (value == "View") {
				try {
					ProcessViewAction();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getLocalizedMessage());
				}
			}

			if (value == "Save") {
				try {

					String status = validate();
					if (status == "Sucess") {
						ProcessSaveAction();
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
	}

	private String validate() {
		String status = "Sucess";

		String vfinyear = finyear.getText();
		if (vfinyear.length() == 0) {
			status = "Fail";
			new General().msg("Please Check Enter <<Fin Year >>");
			finyear.grabFocus();
		}

		String vfrom = from.getText();
		if (vfrom.length() != 10) {
			status = "Fail";
			new General().msg("Please Check Enter <<From Date >>");
			from.grabFocus();

		}

		String vto = to.getText();
		if (vto.length() != 10) {
			status = "Fail";
			new General().msg("Please Enter  <<TO Date >>");
			to.grabFocus();

		}
		return status;
	}

	private void ProcessViewAction() throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		vcomp = mycompcode.getText();
		vstore = mystorecode.getText();
		SQL = "Call  Fin_getAllData(" + vcomp + "," + vstore + " )";
		// rs = this.getSPResult(SQL) ;
		String Col[] = { "Company", "Fin.Year", "Start Date", "End Date", "Cur.Fin.Yr", "Freeze Fin Year",
				"Freeze Date" };
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 7, "N", "N", "N");
		table.setModel(model);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JViewport prt = new JViewport();
		prt.add(table, Col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		table.requestFocus();
		selectRow();
	}

	private void selectRow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				// String Col[] = { "Company", "Fin.Year", "Start Date" , "End
				// Date" , "Cur.Fin.Yr" } ;
				from.setText(table.getValueAt(row, 2).toString());
				to.setText(table.getValueAt(row, 3).toString());
				finyear.setText(table.getValueAt(row, 1).toString());
				String vselected = table.getValueAt(row, 4).toString();
				switch (vselected) {
				case "Y":
					ch1.setSelected(true);
					break;
				case "N":
					ch1.setSelected(false);
					break;
				}
				try {
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void ProcessSaveAction() throws Throwable {
		msg.setText("Processing Wait..");
		String vcomp = mycompcode.getText();
		String vstore = mystorecode.getText();
		String vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
		String vto = new gnConfig().date_ConverttoDBforamt(to.getText());
		String vvfrom = from.getText();
		String vvto = to.getText();

		boolean iscuurentFinyear = ch1.isSelected();
		SQL = "call fin_RemoveRecord(" + vcomp + ",   " + vstore + ",  '" + vfrom + "','" + vto + "')";
		this.getSPResult(SQL);
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		String status = "Fail";
		String vcufinyr = "";
		boolean vcurfinyear = ch1.isSelected();
		if (vcurfinyear) {
			vcufinyr = "Y";
		}
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String vfreezeyear = "N";
		String hie = "Insert into finyearcontrol(company_code ,  Finyear , Start_date , End_date, "
				+ "current_fin_year, store_code, FreezeYear)" + "values(?,?,?,?,?,?, ?)";
		try {
			prst = con.prepareStatement(hie);
			prst.setString(1, vcomp);
			prst.setString(2, finyear.getText());
			prst.setString(3, new gnConfig().date_ConverttoDBforamt(from.getText()));
			prst.setString(4, new gnConfig().date_ConverttoDBforamt(to.getText()));
			prst.setString(5, vcufinyr);
			prst.setString(6, vstore);
			prst.setString(7, vfreezeyear);
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con.commit();
			}
			prst.executeBatch(); // insert remaining records
			con.commit();
			new gnImageSound().playSound();
			new gnImageSound().playSound();
			status = "Sucess";
		} catch (SQLException e) {
			new General().msg(e.getMessage() + "<: Insert at Fin year Level>");
			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
			}
			if (status == "Sucess") {
				new gnImageSound().playSound();
				new gnImageSound().playSound();
				// new General().msg("Data Save Sucessfully");
				String visfinyear = " ";
				if (iscuurentFinyear) {
					visfinyear = "Y";
				} else {
					visfinyear = "N";
				}
			
				SQL = "call fin_setDefaultvalueN(" + vcomp + ", '" + vfrom + "','" + vto + "' ,'" + visfinyear + "')";
				this.getSPResult(SQL);
				rs.close();
				this.closeconn();
				btnView.doClick();

				new gnDecorate().setBusyCursor(frameFinyear);
				new gnImageSound().playSound();
				new gnImageSound().playSound();
				
				//calculatePrvYearClosingsAndAssignOpening();
				//calculateCurrentYearClosings(vfrom, vto);
				
				new gnDecorate().setDefaultCursor(frameFinyear);
				new General().msg("Process Complete Sucessfully ...   ");
  			}
		}
	}

 
	public void calculatePrvYearClosingsAndAssignOpening() throws Throwable {
		String status = checkDayEnd();
		//new gnDecorate().setBusyCursor(frameFinyear);
		new Account_CloseFinYear().calculateGl_GroupBalancesForYear();
		new Account_CloseFinYear().AssignOpeningGl_GroupBalancesForYear();
		new Account_CloseFinYear().AssignClosingStockNewFinYear();
		//new gnDecorate().setDefaultCursor(frameFinyear);
	}

	public void calculateCurrentYearClosings(String vfrom, String vto) throws Throwable {

		String vfinyear = new gnFinYear().getReportingFinYear();
		new gnAccountbase().Calculate_glClosingBalancesForSite(vfrom, vto, vfinyear);
		new gnAccountbase().Calculate_Group_ClosingBalancesForSite(vfrom, vto, vfinyear);
 	}

	
}// Last

package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class bankMaster extends getResultSet {

	JFrame frmBusinessApplication;
	private JTextField bankcode;
	public JTextField companycode;
	private JTextField companyname;
	JInternalFrame internalFrame;
	private JTextField bankname;
	private JTextField acnumber;
	private JTextField opdate;
	private JTextField opbal;
	private JTextField city;
	private JTextField clbal;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnUpdate;
	private JCheckBox chckbxNewCheckBox;

	///
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	JScrollPane jsp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bankMaster window = new bankMaster();
					window.frmBusinessApplication.setVisible(true);
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
	public bankMaster() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frmBusinessApplication = new JFrame();
		frmBusinessApplication.setAlwaysOnTop(true);
		frmBusinessApplication.setTitle("Business Application");
		frmBusinessApplication.setBounds(350, 100, 700, 450);
		frmBusinessApplication.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBusinessApplication.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 700, 450);
		frmBusinessApplication.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		internalFrame = new JInternalFrame("Bank Master");
		internalFrame.setBounds(0, 0, 700, 450);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 198, 672, 178);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 0, 672, 178);
		panel.add(jsp);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-2, 169, 674, 29);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(480, 2, 97, 29);
		btnUpdate.setEnabled(false);
		panel_1.add(btnUpdate);
		ActionListener upd = new lsnrGrno();
		btnUpdate.addActionListener(upd);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(577, 2, 97, 29);
		panel_1.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBusinessApplication.dispose();
			}
		});
		btnCancel.setMnemonic('C');

		btnSave = new JButton("Save");
		btnSave.setBounds(415, 1, 66, 30);
		panel_1.add(btnSave);
		btnSave.setSelectedIcon(new ImageIcon("D:\\AKN\\ItemImage\\Save.png"));
		btnSave.setIcon(null);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					boolean vmybank = chckbxNewCheckBox.isSelected();
					insertData();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
		btnSave.setMnemonic('S');
		btnSave.setEnabled(true);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(12, 36, 660, 132);
		internalFrame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		chckbxNewCheckBox = new JCheckBox("My Bank");
		chckbxNewCheckBox.setToolTipText("Check If This Bank is Your Bank ");
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(529, 7, 123, 16);
		panel_3.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setForeground(Color.BLUE);

		acnumber = new JTextField();
		acnumber.setBounds(108, 32, 116, 22);
		panel_3.add(acnumber);
		acnumber.setColumns(10);

		opdate = new JTextField();
		opdate.setBounds(326, 36, 116, 22);
		panel_3.add(opdate);
		opdate.setColumns(10);

		city = new JTextField();
		city.setBounds(108, 54, 116, 22);
		panel_3.add(city);
		city.setColumns(10);

		JLabel lblDateOfAc = new JLabel("A/c Opening Dt.");
		lblDateOfAc.setBounds(236, 37, 95, 16);
		panel_3.add(lblDateOfAc);

		JLabel lblAccountNumber = new JLabel("Account No");
		lblAccountNumber.setBounds(35, 37, 66, 16);
		panel_3.add(lblAccountNumber);

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(40, 58, 56, 16);
		panel_3.add(lblCity);
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblBankCode = new JLabel("Bank Code");
		lblBankCode.setBounds(35, 12, 66, 16);
		panel_3.add(lblBankCode);
		lblBankCode.setHorizontalAlignment(SwingConstants.RIGHT);

		bankcode = new JTextField();
		bankcode.setBackground(Color.WHITE);
		bankcode.setBounds(108, 10, 116, 22);
		panel_3.add(bankcode);
		bankcode.setColumns(10);

		bankname = new JTextField();
		bankname.setBackground(Color.WHITE);
		bankname.setBounds(225, 10, 263, 22);
		panel_3.add(bankname);
		bankname.setColumns(10);

		JLabel lblOpeningBalance = new JLabel("Opening Balance");
		lblOpeningBalance.setBounds(153, 95, 111, 16);
		panel_3.add(lblOpeningBalance);
		lblOpeningBalance.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOpeningBalance.setForeground(Color.BLACK);
		lblOpeningBalance.setHorizontalAlignment(SwingConstants.RIGHT);

		opbal = new JTextField();
		opbal.setBounds(277, 90, 111, 25);
		panel_3.add(opbal);
		opbal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		opbal.setText("0.00");
		opbal.setColumns(10);

		JLabel lblClosingBal = new JLabel("Cl .Bal");
		lblClosingBal.setBounds(396, 95, 51, 16);
		panel_3.add(lblClosingBal);
		lblClosingBal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClosingBal.setForeground(Color.BLACK);

		clbal = new JTextField();
		clbal.setBounds(441, 90, 148, 25);
		panel_3.add(clbal);
		clbal.setEditable(false);
		clbal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		clbal.setText("0.00");
		clbal.setColumns(10);

		JLabel lblNewLabel = new JLabel("Company");
		lblNewLabel.setBounds(54, 13, 56, 16);
		internalFrame.getContentPane().add(lblNewLabel);

		companycode = new JTextField();
		companycode.setBounds(120, 10, 106, 22);
		internalFrame.getContentPane().add(companycode);
		companycode.setColumns(10);
		companycode.setEnabled(false);
		ActionListener cmpny = new Company();
		companycode.addActionListener(cmpny);
		companyname = new JTextField();
		companyname.setEnabled(false);
		companyname.setEditable(false);
		companyname.setBounds(227, 10, 269, 22);
		internalFrame.getContentPane().add(companyname);
		companyname.setColumns(10);
		internalFrame.setVisible(true);
		populateBanks();
		decorate();
	}

	class Company implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			try {
				new gnAdmin().setcompany(companycode, companyname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				try {
					populateBanks1();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	private void decorate() throws Throwable {
		bankcode.setEditable(false);
		bankname.setEditable(false);
		new gnApp().setFrameTitel(frmBusinessApplication);
		new gnField().closeform(internalFrame, frmBusinessApplication);
		new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnUpdate, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnCancel, Color.BLUE, Color.WHITE);
		new gnDecorate().DispField_Beval(acnumber);
		new gnDecorate().DispField_Beval(bankname);
		new gnDecorate().DispField_Beval(opbal);
		new gnDecorate().DispField_Beval(clbal);
		new gnDecorate().DispField_Beval(city);
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		String vcomp = companycode.getText();
		switch (vcomp) {
		case "0":
			companycode.setEnabled(true);
			btnSave.setEnabled(true);
		}
		btnSave.setEnabled(false);
	}

	public void populateBanks() throws Throwable {
		new gnTable().RemoveTableRows(model);
		String Col[] = { "Bank_code", "Name", "City", "Ac Number", "Date of A/c Open", "Op.Bal", "Cl.Bal", "My Bank" };
		model.setColumnIdentifiers(Col);
		table.setModel(model);
		// String vcomp = companycode.getText() ;
		String vcomp = new gnConfig().getCompanyCode();
		String vtype = "";
		String SQL1 = "call bank_getAllBankData(" + vcomp + ")";
		table = new gnTableModel().Tablemodel(table, model, SQL1, Col, 8, "N", "N", vtype);
		new gnTable().setTableColWidth(table, 1, 200);
		JViewport prt7 = new JViewport();
		prt7.add(table, Col);
		prt7.setVisible(true);
		jsp.setViewport(prt7);
		// table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification1);
		Selectrow();
	}

	public void Selectrow() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = table.getSelectedRow();
					String value = (String) table.getValueAt(row, 2);
					showdata(row);
					// new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				new General().msgDispose();
			}
		});
	}

	public void populateBanks1() throws Throwable {
		new gnTable().RemoveTableRows(model);
		String Col[] = { "Bank_code", "Name", "City", "Ac Number", "Date of A/c Open", "Op.Bal", "Cl.Bal", "My Bank" };
		model.setColumnIdentifiers(Col);
		table.setModel(model);
		String vcomp = companycode.getText();
		// String vcomp = new gnConfig().getCompanyCode() ;
		String vtype = "";
		String SQL1 = "call bank_getAllBankData(" + vcomp + ")";
		table = new gnTableModel().Tablemodel(table, model, SQL1, Col, 8, "N", "N", vtype);
		new gnTable().setTableColWidth(table, 1, 200);
		JViewport prt7 = new JViewport();
		prt7.add(table, Col);
		prt7.setVisible(true);
		jsp.setViewport(prt7);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification1);
	}

	private void update(String SQL) throws Throwable {
		this.getSPResult(SQL);
		populateBanks();
	}

	class lsnrGrno implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String defvalue = " ";
			int i = e.getID(); // Field id
			try {
				String vbankcode = bankcode.getText();
				String vcity = city.getText();
				String vcomp = companycode.getText();
				String vacno = acnumber.getText();
				String vdate = new gnConfig().date_ConverttoDBforamt(opdate.getText());
				String vopbal = opbal.getText();
				boolean vdef = chckbxNewCheckBox.isSelected();
				if (vdef) {
					defvalue = "Y";
				} else {
					defvalue = "N";
				}
				String SQL = "Call bank_updateDefaultBank( " + vcomp + " , '" + vbankcode + "' ,  '" + vcity + "' , "
						+ vacno + "  , '" + vdate + "' , " + vopbal + " ,  '" + defvalue + "')";
				update(SQL);
				btnUpdate.setEnabled(false);
				btnSave.setEnabled(false);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void showdata(int row) {
		btnSave.setEnabled(false);
		btnUpdate.setEnabled(true);
		String Col[] = { "Bank_code", "Name", "Ac Number", "Date of A/c Open", "Op.Bal", "Cl.Bal" };
		// {"Bank_code" , "Name" , "City", "Ac Number" , "Date of A/c Open"
		// ,"Op.Bal" ,"Cl.Bal" , "My Bank"};
		btnSave.setEnabled(false);
		btnUpdate.setEnabled(true);
		btnUpdate.setBackground(Color.blue);
		bankcode.setText(null);
		bankname.setText(null);
		acnumber.setText(null);
		opdate.setText(null);
		city.setText(null);
		opbal.setText(null);
		clbal.setText(null);

		bankcode.setText(table.getValueAt(row, 0).toString());
		bankname.setText(table.getValueAt(row, 1).toString());
		city.setText(table.getValueAt(row, 2).toString());
		acnumber.setText(table.getValueAt(row, 3).toString());
		opdate.setText(table.getValueAt(row, 4).toString());
		opbal.setText(table.getValueAt(row, 5).toString());
		clbal.setText(table.getValueAt(row, 6).toString());
		String vmybank = (table.getValueAt(row, 7).toString());
		switch (vmybank) {
		case "Y":
			chckbxNewCheckBox.setSelected(true);
			break;
		case "N":
			chckbxNewCheckBox.setSelected(false);
			break;
		}
	}

	public void insertData() throws Throwable {

		String status;
		String Col[] = { "Bank_code", "Name", "Ac Number", "Date of A/c Open", "Op.Bal", "Cl.Bal" };
		String vbankcode = bankcode.getText();
		String vname = bankname.getText();
		String vacno = acnumber.getText();
		String vcity = city.getText();
		String vopdate = opdate.getText();
		String vopbal = opbal.getText();
		String vclbal = clbal.getText();
		String vmybank1 = " ";
		boolean vmybank = chckbxNewCheckBox.isSelected();
		new General().msg("Selectred " + vmybank);
		if (vmybank) {
			vmybank1 = "Y";
		} else {
			vmybank1 = "N";
		}
		/// Insert
		int row = table.getRowCount();
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String Status = "Fail";
		String pospayment = "Insert into  ms_bank_master( bank_code , " + "Bank_name,  city , Account_number,  "
				+ "Date_of_ac_openiing,  op_balance , closing_balance, myBank, company_code) "
				+ "values(?,?,?,?,?,?,?,?,?)";
		prst = con.prepareStatement(pospayment);
		try {
			prst.setString(1, vbankcode);
			prst.setString(2, vname);
			prst.setString(3, vcity);
			prst.setString(4, vacno);
			prst.setString(5, vopdate);
			prst.setString(6, vopbal);
			prst.setString(7, vclbal);
			prst.setString(8, vmybank1);
			prst.setString(9, companycode.getText());
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
			populateBanks();
		} catch (SQLException e) {
			new General().msg("Bank :" + e.getMessage());
			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
			}
		}
		// End Insert

	}// End of

	/// for bank search
	public CellEditorListener ChangeNotification1 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 2);
			try {
				showdata(row);
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	};

}// last

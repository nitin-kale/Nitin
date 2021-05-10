package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import RetailProduct.CustomerMaster.keyPressedlsnr;
 
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CustAppoinment  extends getResultSet{

	JFrame custAppoinmentFrame;
	private Connection con1, con2 ;
 	private JTextField custid;
	private JTextField name;
	JComboBox comboStatus ;
	JButton btnSave ;
	private JTextField mobile;
	private JTextField addr1;
	private JTextField addr2;
	String DBhdr;
	JButton btnSaveCust ;
	private JTextField bookdate;
	private JTextField fromtime;
	private JTextField totime;
	JScrollPane jsp ;
 	JTable  table = new JTable();

 	
	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 1 || column == 2|| column == 3 || column == 2 || column == 4 || column == 9 || column == 1 || column == 2 || column == 5
					|| column == 6 || column == 7 || column == 10 ? false : true;
		}
	};

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustAppoinment window = new CustAppoinment();
					window.custAppoinmentFrame.setVisible(true);
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
	 * @throws Throwable 
	 */
	public CustAppoinment() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Throwable 
	 */
	private void initialize() throws Throwable {
		custAppoinmentFrame = new JFrame();
		custAppoinmentFrame.setAlwaysOnTop(true);
		custAppoinmentFrame.getContentPane().setBackground(Color.WHITE);
		custAppoinmentFrame.setBounds(100, 100, 809, 560);
		custAppoinmentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		custAppoinmentFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Appoinments");
		lblNewLabel.setBounds(188, 0, 109, 29);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		custAppoinmentFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cust ID");
		lblNewLabel_1.setBounds(22, 40, 56, 16);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		custAppoinmentFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(22, 74, 56, 16);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		custAppoinmentFrame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Mobile");
		lblNewLabel_3.setBounds(22, 108, 56, 16);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		custAppoinmentFrame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setBounds(22, 148, 56, 16);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		custAppoinmentFrame.getContentPane().add(lblNewLabel_4);
		
		custid = new JTextField();
		custid.setBounds(90, 37, 120, 30);
		custAppoinmentFrame.getContentPane().add(custid);
		custid.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		name.setBounds(90, 71, 398, 30);
		custAppoinmentFrame.getContentPane().add(name);
		name.setColumns(10);
		
		mobile = new JTextField();
		mobile.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		mobile.setBounds(90, 105, 398, 30);
		custAppoinmentFrame.getContentPane().add(mobile);
		mobile.setColumns(10);
		
		addr1 = new JTextField();
		addr1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		addr1.setBounds(90, 145, 398, 30);
		custAppoinmentFrame.getContentPane().add(addr1);
		addr1.setColumns(10);
		
		addr2 = new JTextField();
		addr2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		addr2.setBounds(90, 174, 398, 30);
		custAppoinmentFrame.getContentPane().add(addr2);
		addr2.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new MatteBorder(3, 0, 3, 0, (Color) Color.DARK_GRAY));
		panel.setBounds(0, 210, 488, 76);
		custAppoinmentFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Book Date");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(12, 13, 79, 16);
		panel.add(lblNewLabel_5);
		
		bookdate = new JTextField();
		bookdate.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		bookdate.setBounds(95, 10, 116, 30);
		panel.add(bookdate);
		bookdate.setColumns(10);
		
		fromtime = new JTextField();
		fromtime.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		fromtime.setBounds(95, 42, 116, 30);
		panel.add(fromtime);
		fromtime.setColumns(10);
		
		totime = new JTextField();
		totime.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		totime.setBounds(254, 42, 58, 30);
		panel.add(totime);
		totime.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Time");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(27, 45, 56, 16);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Till");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(213, 45, 29, 16);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("Status");
		lblNewLabel_9.setBounds(289, 24, 69, 16);
		panel.add(lblNewLabel_9);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		
		comboStatus = new JComboBox();
		comboStatus.setBounds(320, 42, 116, 26);
		panel.add(comboStatus);
		comboStatus.setModel(new DefaultComboBoxModel(new String[] {"Booked", "Cancel"}));
		
		jsp = new JScrollPane();
		jsp.setBounds(0, 329, 791, 186);
		custAppoinmentFrame.getContentPane().add(jsp);
		
		btnSave = new JButton("Save Appoinment");
		btnSave.setMnemonic('S');
		btnSave.setBounds(530, 292, 149, 36);
		custAppoinmentFrame.getContentPane().add(btnSave);
		
		JButton btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(682, 293, 97, 35);
		custAppoinmentFrame.getContentPane().add(btnClose);
		
		JLabel lblNewLabel_8 = new JLabel(" ");
		lblNewLabel_8.setIcon(new ImageIcon(CustAppoinment.class.getResource("/RetailProduct/spaimage3.jpg")));
		lblNewLabel_8.setBounds(500, 0, 291, 291);
		custAppoinmentFrame.getContentPane().add(lblNewLabel_8);
		
		btnSaveCust = new JButton("Save Customer");
 		btnSaveCust.setBounds(244, 34, 130, 29);
		custAppoinmentFrame.getContentPane().add(btnSaveCust);
 
		ActionListener lsmobile = new lsnrMobile();
		ActionListener lscustname = new lsnrCustName();
		ActionListener lsnewcust = new newcustLsne();
		ActionListener lsbtn = new btnLsnr() ;
		btnSaveCust.addActionListener(lsnewcust);
  		mobile.addActionListener(lsmobile);
		name.addActionListener(lscustname);
		btnSave.addActionListener(lsbtn);
  		ActionListener dtLsnr = new dateLsnr() ;
		bookdate.addActionListener(dtLsnr);
		

		KeyListener ky = new keyPressedlsnr();
		custid.addKeyListener(ky);
		name.addKeyListener(ky);
		mobile.addKeyListener(ky);
		addr1.addKeyListener(ky);
		addr2.addKeyListener(ky);
		bookdate.addKeyListener(ky);
		fromtime.addKeyListener(ky);
		totime.addKeyListener(ky);
		comboStatus.addKeyListener(ky);
		comboStatus.addKeyListener(ky);
 		
		decorate();
	}
	
	private void decorate() throws Throwable
	{

		new gnApp().setFrameTitel(custAppoinmentFrame);
		name.setDocument(new gnSetinputLimit(50));
		addr1.setDocument(new gnSetinputLimit(30));
		addr2.setDocument(new gnSetinputLimit(30));
 		bookdate.setText(new General().getDate());
		viewAppointmentbyDate() ;
	}
 	
	class lsnrCustName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			try {
				String sname = name.getText().trim();
				sname = "%" + sname + "%";
				String vcomp;
				vcomp = new gnConfig().getCompanyCode();
				String[] SCol = { "Type", "Code", "Name", "Mobile", "Addr1", "Addr2" };
				String sqlcust = "Select code, name, mobile, addr1 , addr2 from ms_customer_master where company_code = "
						+ vcomp + " " + " and name like '" + sname + "' ";
				int colno = 5;
				MyCustSearch(sqlcust, SCol, colno);
				// Search(sqlcust, SCol);
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
		}
	}

	class lsnrMobile implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			try {
				String sname = mobile.getText().trim();
				sname = sname + "%";
				String vcomp;
				vcomp = new gnConfig().getCompanyCode();
 				String[] SCol = { "Type", "Code", "Name", "Mobile", "Addr1", "Addr2" };
 				
				int colno = 5;
				String sqlcust = "Select code, name, mobile, addr1 , addr2 from ms_customer_master where company_code = "
						+ vcomp + " " + " and mobile like '" + sname + "' ";
				MyCustSearch(sqlcust, SCol, colno);
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
		}
	}

	public void MyCustSearch(String sqlsearch, String[] Col, int colno) throws SQLException, ClassNotFoundException {

		new gnTable().RemoveTableRows(model);
		String vtype = "Customer";
		table = new gnTableModel().Tablemodel(table, model, sqlsearch, Col, colno, "N", "Y", vtype);
		String RecordCount1 = Integer.toString((new gnTable().getRowCount(table)));
		table.requestFocus();
		new gnTable().setTableColWidth(table, 1, 150);
		new gnTable().setTableColWidth(table, 2, 150);
		table.setBackground(Color.black);
		table.setForeground(Color.WHITE);
		table.setSelectionForeground(Color.white);
		table.setEditingRow(0);
		JViewport prt1101 = new JViewport();
		prt1101.setBackground(new Color(51, 255, 255));
		prt1101.add(table);
		prt1101.setVisible(true);
		jsp.setViewport(prt1101);
		new gnTable().setFontBold(table, 14);
		Selectcustrow();
		table.requestFocus(true);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		new gnLogger().loggerInfoEntry("POS", "Selecting New Customer");
	 
	}

	public void Selectcustrow() {
		table.requestFocus(true);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		table.grabFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {

				int row = table.getSelectedRow();
				String vcustcode = (String) table.getValueAt(row, 1);
				String vcustname = (String) table.getValueAt(row, 2);
				String vcustmobile = (String) table.getValueAt(row, 3);
				String vaddr1 = (String) table.getValueAt(row, 4);
				String vaddr2 = (String) table.getValueAt(row, 5);
				custid.setText(vcustcode);
				name.setText(vcustname);
				mobile.setText(vcustmobile);
				addr1.setText(vaddr1);
				addr2.setText(vaddr2);
				new gnTable().RemoveTableRows(model);
				new gnLogger().loggerInfoEntry("Appoinment", "Customer Search Over");
				bookdate.grabFocus();
			}
		});
	}

	

	class newcustLsne implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {


			try {
 			String vcode = "";
			String vname = "";
			String vmobile = "";
			String vaddr1 = "";
			String vaddr2 = "";
			String status = "Y";
			String vapplypromo = "Y" ;
			String vpromoStartdate=   new gnConfig().date_ConverttoDBforamt(bookdate.getText());
 				String vvalue = custid.getText();
				if (vvalue.length() == 0) {
					// String status = new
					// gnSupplier().checkCustomerExists(custid.getText()) ; 
					status = "N";
				} else {
					status = "Y";
				}
				switch (status) {
				case "N":
					vname =  name.getText().trim();
					vmobile = mobile.getText();
					vaddr1 =  addr1.getText();
					vaddr2 =  addr2.getText();
					custid.setText(new gnSupplier().getNewCustomerCode());
					vcode = custid.getText();
					new gnSupplier().SaveCustData(vcode, vname, vmobile, vaddr1, vaddr2, vapplypromo , vpromoStartdate);
 					break;
				case "Y":
					vcode = custid.getText();
					vname =  name.getText().trim();
					vmobile = mobile.getText();
					vaddr1 =  addr1.getText();
					vaddr2 = addr2.getText();
					new gnSupplier().updateCustData(vcode, vname, vmobile, vaddr1, vaddr2);
  				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
			}
		}
	}

	
	
class btnLsnr  implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent e) {
 
 		String value  = e.getActionCommand() ;
  		if (value  == "Close")
 		{
  			custAppoinmentFrame.dispose();
 		}
 
 		if (value  == "Save Appoinment")
 		{
 			try {
 
 				String result  = validate();
 				if (result == "Sucess")
 				{
 					saveAppoinment() ;
 				}		
			} catch (Throwable e1) {
 				e1.printStackTrace();
			}
 		}
  		
	}
 }
	

	
private String validate()
{
	String status = "Sucess" ;
	
	if ( custid.getText().length() == 0 )
	{
		status = "Fail" ;
		new General().Quickmsg("Select Customer ..");
		name.grabFocus();
 	}
	
	if ( name.getText().length() == 0 )
	{
		status = "Fail" ;
		new General().Quickmsg("Select Customer ..");
		name.grabFocus();
 	}

	if ( mobile.getText().length() == 0 )
	{
		status = "Fail" ;
		new General().Quickmsg("Select Customer ..");
		mobile.grabFocus();

	}

	if ( addr1.getText().length() == 0 )
	{
		status = "Fail" ;
		new General().Quickmsg("Enter Address ..");
		addr1.grabFocus();

	}

	if ( addr2.getText().length() == 0 )
	{
		status = "Fail" ;
		new General().Quickmsg("Enter Address ..");
		addr2.grabFocus();

	}


	if ( bookdate.getText().length() == 0 )
	{
		status = "Fail" ;
		new General().Quickmsg("Enter date ..");
		bookdate.grabFocus();

	}


	if ( totime.getText().length() == 0 )
	{
		status = "Fail" ;
		new General().Quickmsg("Enter time ..");
		totime.grabFocus();

	}

	if ( fromtime.getText().length() == 0 )
	{
		status = "Fail" ;
		new General().Quickmsg("Enter time ..");
		fromtime.grabFocus();
 	}
    return status ;	
 }

private void saveAppoinment() throws Throwable {
 	String vcomp = new gnConfig().getCompanyCode() ;
	String vstore = new gnConfig().getStoreID() ;
	prst = null;
	final int batchSize = 1;
	int TotalRecordinsert = 0;
	con2 = this.getConnection();
	con2.setAutoCommit(false);
	String Status = "Fail";
	String poshdr = "Insert into  cust_appoinments(company_code , site_code, "
			+ " code ,  Name,   Mobile , Addr1 ,  Addr2 , bookdate ,dayName,  "
 			+ " fromtime , Totime , status )"
 			+ "values(?,?,?,?,?,?,?,?,?,?,?,? )";
	try {
		prst = con2.prepareStatement(poshdr);
		prst.setString(1, vcomp);
		prst.setString(2, vstore);
		prst.setString(3, custid.getText());
		prst.setString(4,   name.getText()  );
		prst.setString(5,  mobile.getText());
		prst.setString(6,  addr1.getText());
		prst.setString(7,  addr2.getText());
		prst.setString(8,  new gnConfig().date_ConverttoDBforamt(bookdate.getText()));
		prst.setString(9,  "Sun");
		prst.setString(10,  fromtime.getText());
		prst.setString(11,  totime.getText());
		prst.setString(12,  comboStatus.getSelectedItem().toString().trim());
 	 	prst.addBatch();
 		TotalRecordinsert = TotalRecordinsert + 1;
		DBhdr = "Fail";
		if (++TotalRecordinsert % batchSize == 0) {
			prst.executeBatch();
			con2.commit();
 			DBhdr = "Sucess";
		}
		prst.executeBatch(); // insert remaining records
  		DBhdr = "Sucess";
		con2.commit();
 	} catch (SQLException e) {
	 	new General().msg(e.getLocalizedMessage());
 		con2.rollback();
 		DBhdr = "Fail";
	} finally {
		if (prst != null) {
 			prst.close();
 			viewData() ;
		}
		if (DBhdr == "Sucess") { 
  			new General().msg("Data Save Sucessfully ... ");
   	}
	}
 }//Insert Appoinment End



private void viewData()
{
	String vform= "%d.%m.%Y" ;
 	String[] Col1 = { "Type", "Code", "Name", "Mobile", "Addr1", "Addr2" , "Date", "From","Till" ,"Status" };
 	String SQL  = "Select  code, name, mobile, addr1, addr2 , "
			+ " date_Format(bookDate,  '"+vform+"' ) ,  fromtime , Totime , status   "
			+ "from cust_appoinments where company_code  = '"+vcomp+"' and site_code = '"+vstore+"' " ;
	//new General().msg(SQL);
 	int colno = 9 ;
	try {
		MyCustSearch(SQL, Col1, colno);
	} catch (ClassNotFoundException | SQLException e) {
 		e.printStackTrace();
 		new General().msg("Appointment View Data"+ " "+e.getLocalizedMessage());
	}
 }



class dateLsnr implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			viewAppointmentbyDate() ;
		} catch (ClassNotFoundException | SQLException e) {
 			e.printStackTrace();
		}
	}
 }



private void viewAppointmentbyDate() throws ClassNotFoundException, SQLException
{
	
	String vdate = new gnConfig().date_ConverttoDBforamt(bookdate.getText());
	String vform= "%d.%m.%Y" ;
 	String[] Col1 = { "Type", "Code", "Name", "Mobile", "Addr1", "Addr2" , "Date", "From","Till" ,"Status" };
 	String SQL  = "Select  code, name, mobile, addr1, addr2 , "
			+ " date_Format(bookDate,  '"+vform+"' ) ,  fromtime , Totime , status   "
			+ "from cust_appoinments"
			+ "  where company_code  = '"+vcomp+"' and site_code = '"+vstore+"'  and "
		    + "  bookdate = '"+vdate+"' " ;
	//new General().msg(SQL);
 	int colno = 9 ;
	try {
		MyCustSearch(SQL, Col1, colno);
	} catch (ClassNotFoundException | SQLException e) {
 		e.printStackTrace();
 		new General().msg("Appointment View Data"+ " "+e.getLocalizedMessage());
	}
 }




class keyPressedlsnr implements KeyListener {
	@Override
	public void keyPressed(KeyEvent e) {
		int value = e.getKeyCode();
		// new General().msg("Key Pressed "+ value);
		switch (value) {
		case 10:
 

			if (custid.isFocusOwner()) {
			      name.grabFocus();
			}
 
 
			if (name.isFocusOwner()) {
			      mobile.grabFocus();
			}

			if (mobile.isFocusOwner()) {
				addr1.grabFocus();
			}

			 if (addr1.isFocusOwner()) {
				addr2.grabFocus();
			}

			if (addr2.isFocusOwner()) {
					bookdate.grabFocus();
			}

			if (bookdate.isFocusOwner()) {
				fromtime.grabFocus();
			}

			if (fromtime.isFocusOwner()) {
				totime.grabFocus();
			}

			if (totime.isFocusOwner()) {
				comboStatus.grabFocus();
				comboStatus.showPopup();
			}

			if (comboStatus.isFocusOwner()) {
				btnSave.grabFocus();
			}
 
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}


}//Last 

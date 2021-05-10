package RetailProduct;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CashFlow_Mini  extends getResultSet{

	JFrame cashFlowFrameMini;
	private JTextField opcash;
	private JTextField clbal;
	private JScrollPane jsp ;
	String vdaybegindate ;
	String vtrndate;
	JTable table = new JTable();
 	DefaultTableModel mymodel = new DefaultTableModel();
	//public JTable table ;

	String vcomp;
	String vstore ;
	String vfinyear ;
	private JLabel lblNewLabel_1;
	private JTextField trdate;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashFlow_Mini window = new CashFlow_Mini();
					window.cashFlowFrameMini.setVisible(true);
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
	public CashFlow_Mini() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Throwable 
	 */
	private void initialize() throws Throwable {
		cashFlowFrameMini = new JFrame();
		cashFlowFrameMini.setAlwaysOnTop(true);
		cashFlowFrameMini.getContentPane().setBackground(Color.WHITE);
		cashFlowFrameMini.setBounds(100, 100, 454, 585);
		cashFlowFrameMini.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cashFlowFrameMini.getContentPane().setLayout(null);
		
		JLabel lblEnterOpcash = new JLabel("Enter Op.Cash ");
		lblEnterOpcash.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterOpcash.setBounds(12, 72, 173, 16);
		cashFlowFrameMini.getContentPane().add(lblEnterOpcash);
		
		//opcash = new JTextField();
		opcash = new gnRoundTextField(1);
 		opcash.setBounds(12, 92, 216, 32);
		cashFlowFrameMini.getContentPane().add(opcash);
		opcash.setColumns(10);
		
		jsp = new JScrollPane();
		jsp.setToolTipText("Cash Flow Statement");
		jsp.setBounds(12, 127, 412, 338);
		cashFlowFrameMini.getContentPane().add(jsp);
		
		JButton btnExport = new JButton("Export");
		btnExport.setMnemonic('E');
		btnExport.setBounds(240, 92, 97, 32);
		cashFlowFrameMini.getContentPane().add(btnExport);
		
		JLabel lblNewLabel = new JLabel("Closing Balance");
		lblNewLabel.setBounds(12, 499, 97, 16);
		cashFlowFrameMini.getContentPane().add(lblNewLabel);
		
		//clbal = new JTextField();
		clbal = new gnRoundTextField(1);
 		clbal.setEnabled(false);
		clbal.setFont(new Font("Tahoma", Font.BOLD, 15));
		clbal.setBounds(105, 488, 173, 39);
		cashFlowFrameMini.getContentPane().add(clbal);
		clbal.setColumns(10);
		
		JButton btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(339, 92, 85, 32);
		cashFlowFrameMini.getContentPane().add(btnClose);
		
		lblNewLabel_1 = new JLabel("Transaction Date:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(12, 13, 116, 16);
		cashFlowFrameMini.getContentPane().add(lblNewLabel_1);
		
		trdate = new JTextField();
		trdate.setBounds(12, 30, 135, 29);
		cashFlowFrameMini.getContentPane().add(trdate);
		trdate.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setIcon(new ImageIcon(CashFlow_Mini.class.getResource("/RetailProduct/rs.png")));
		lblNewLabel_2.setBounds(290, 488, 56, 39);
		cashFlowFrameMini.getContentPane().add(lblNewLabel_2);
	
		ActionListener xbtnLsnr = new btnLsnr();
		btnClose.addActionListener(xbtnLsnr);
		btnExport.addActionListener(xbtnLsnr);
		
		
		ActionListener xoplsnr= new oplsnr() ;
		opcash.addActionListener(xoplsnr);
		
		decorate();
	}
	
	
private void decorate() throws Throwable	
{
 
	vcomp =  new gnConfig().getCompanyCode() ;
	vstore = new gnConfig().getStoreID() ;
	vdaybegindate =  new gnConfig().getDaybeginDate();
  	trdate.setText(vdaybegindate);
	vtrndate =  new gnConfig().date_ConverttoDBforamt(trdate.getText())   ;
 }


class oplsnr implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent e) {
  		try {
  			vtrndate =  new gnConfig().date_ConverttoDBforamt(trdate.getText())   ;
   			getStructure() ;
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  	}
 }

 

private void  getStructure() throws ClassNotFoundException, SQLException
{
	 
	int row  = table.getRowCount() ;
	if (row > 0 )
	{
		new gnTable().RemoveTableRows(mymodel);
 	}
   	
		String vno  = "1";
		String vname = "Opening Bal" ;
	 	setFigures(vno , vname) ;
 	
	  vno  = "2";
	  vname = "Cash Sales(+)" ;
 	  setFigures(vno , vname) ;
 	  table.setValueAt(getCashSales(), 1, 2);


	  vno  = "3";
	  vname = "Cash Purchase(-)" ;
 	  setFigures(vno , vname) ;
  	  table.setValueAt(getCashPurchase(), 2, 2);

  	  vno  = "4";
	  vname = "Cash Expenses(-)" ;
 	  setFigures(vno , vname) ;
 	  table.setValueAt(getCashExpenses(), 3, 2);

	  vno  = "5";
	  vname = "Closing Cash" ;
 	  setFigures(vno , vname) ;
 	  calculateClosingBal();
}



private void setFigures(String vno, String vname ) throws ClassNotFoundException, SQLException
{
	String vpaymentmode = "Cash" ;
	String SQL="" ;
	switch(vno)
	{
	   case "1" :
   	   mymodel.addRow(new Object[]{vno , vname, opcash.getText()	});
  	   break ;

	   default :
	   	   mymodel.addRow(new Object[]{vno , vname, 0	});
	  	   break ;
  	}
 	String Col1[] = {"Sr.No" , "Name" , "Amount" } ;
 	mymodel.setColumnIdentifiers(Col1);
  	table.setModel(mymodel);
  	JViewport prt7 = new JViewport();
  	prt7.add(table,  Col1);
	prt7.setVisible(true);
	jsp.setViewport(prt7);
	jsp.setVisible(true);

}


class  btnLsnr implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent e) {
 
 		String value = e.getActionCommand() ;
 		
 		if (value  == "Close")
 		{
 			cashFlowFrameMini.dispose();
 		}
 		

 		if (value  == "Export")
 		{
 			new Export_Table_Data_to_Excel().exportTable(table);
  		}

 		
 		
	}
 }
	

private String getCashPurchase() throws ClassNotFoundException, SQLException
{
	String vamt = "0" ;
	String vpurtype = "CA" ;
  	String SQL = "select coalesce(sum(total_amount),0) from grn_hdr where company_code = "+vcomp+" "
	+ " and site_code = "+vstore+" "
	+ " and purchaseType = '"+vpurtype+"'   and Grn_date =   '"+vtrndate+"' ";
   	rs = this.getSPResult(SQL) ;
  	if (rs.next())
  	{
  		vamt = rs.getString(1) ;
  	}
	return vamt ;
 }


private String getCashExpenses() throws ClassNotFoundException, SQLException
{
	String vamt = "0" ;
    String vdoctype = "EX" ;
    String vpaymentmode = "Cash" ;

    String SQL =  " select coalesce(sum(amount),0) from bank_transaction where company_code = "+vcomp+" "
    + " and site_code = "+vstore+"  and docType = '"+vdoctype+"' "
    + " and Payment_type = '"+vpaymentmode+"' and Transaction_date= '"+vtrndate+"' ";
   	rs = this.getSPResult(SQL) ;
  	if (rs.next())
  	{
  		vamt = rs.getString(1) ;
  	}
 	return vamt ;
 }



private String getCashIncomes()
{
	String vamt = "0" ;
	
	return vamt ;
	
}


private String getCashSales() throws ClassNotFoundException, SQLException
{
	String vamt = "0" ;
    String vmode = "Cash" ;
    String SQL = " select coalesce(sum(amount),0) from pos_payments where company_code = "+vcomp+" "
    + "and site_code = "+vstore+" and payment_Mode = '"+vmode+"'   and invdate= '"+vtrndate+"' ";
   	rs = this.getSPResult(SQL) ;
  	if (rs.next())
  	{
  		vamt = rs.getString(1) ;
  	}
 	return vamt ;
	
}



private void calculateClosingBal()
{
	

	double vopbal = Double.parseDouble(opcash.getText());
	double vsale =  Double.parseDouble(table.getValueAt(1, 2).toString());
	double vpurchase =  Double.parseDouble(table.getValueAt(2, 2).toString());
	double vexp =  Double.parseDouble(table.getValueAt(3, 2).toString());
	
	double vclosingAmt = vopbal + vsale-vpurchase - vexp;
	table.setValueAt(vclosingAmt, 4, 2);
    clbal.setText(Double.toString(vclosingAmt));
	
}
}//Last 

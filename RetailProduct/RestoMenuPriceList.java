package RetailProduct;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class RestoMenuPriceList extends getResultSet {

	JFrame menuPriceListFrame;
	private JTextField scanItem_2;
	JButton btnSave;
	JButton btnClose;
 	JScrollPane jsp ;
 	public DefaultTableModel model = new DefaultTableModel();
 	String vcomp ;
	String vstore ;
	JScrollPane promojsp;
 	private JTextField articlecode;
	JTable promotable = new JTable();
	public DefaultTableModel promomodel = new DefaultTableModel() ;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestoMenuPriceList window = new RestoMenuPriceList();
					window.menuPriceListFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	public RestoMenuPriceList() throws ReflectiveOperationException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	private void initialize() throws ReflectiveOperationException, SQLException {
		menuPriceListFrame = new JFrame();
		menuPriceListFrame.setBounds(100, 100, 682, 605);
		menuPriceListFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menuPriceListFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Price List");
		lblNewLabel.setBounds(164, 13, 256, 16);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		menuPriceListFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Item");
		lblNewLabel_1.setBounds(27, 52, 72, 16);
		menuPriceListFrame.getContentPane().add(lblNewLabel_1);
		
		scanItem_2 = new JTextField();
		scanItem_2.setBounds(97, 49, 345, 31);
		menuPriceListFrame.getContentPane().add(scanItem_2);
		scanItem_2.setColumns(10);
		
		articlecode = new JTextField();
		articlecode.setBounds(444, 49, 99, 31);
		articlecode.setEnabled(false);
		articlecode.setEditable(false);
		menuPriceListFrame.getContentPane().add(articlecode);
		articlecode.setColumns(10);
		
 		
		jsp = new JScrollPane();
		jsp.setBounds(27, 100, 625, 146);
		menuPriceListFrame.getContentPane().add(jsp);
		
		promojsp = new JScrollPane();
		promojsp.setBounds(27, 294, 625, 253);
		menuPriceListFrame.getContentPane().add(promojsp);
		
		btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(370, 245, 97, 42);
		menuPriceListFrame.getContentPane().add(btnSave);
		
 		
		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(479, 245, 97, 42);
		menuPriceListFrame.getContentPane().add(btnClose);
		
		ActionListener artlsnr = new articleLsnr();
		scanItem_2.addActionListener(artlsnr);
 
		ActionListener btnLs = new btnLsnr() ;
		btnSave.addActionListener(btnLs);
		btnClose.addActionListener(btnLs);
		decorate() ;
	}
	
	
	
	private void decorate() throws ReflectiveOperationException, SQLException
	{
		vcomp = new gnConfig().getCompanycode() ;
		vstore = new  gnConfig().getStorecode() ;
		insertBulkRecordFirstTime() ;
	}

	private String  checkArticleAvailableinMenuPriceList() throws ClassNotFoundException, SQLException
	{
   		String status = "N" ;
 		String varticle = articlecode.getText();
  		String SQL = "Select  article_code   from  menupricelist where company_code =  "+vcomp+" and "
  				+ " site_code = "+vstore+" and article_code = "+varticle+" " ;
   		rs = this.getSPResult(SQL) ;
  		if (rs.next())
  		{
    		  status = "Y" ;
   		}
   		return status ;
   }
	

	
	private String  checkPriceListTableEmpty() throws ClassNotFoundException, SQLException
	{
   		String status = "N" ;
 		String varticle = articlecode.getText();
  		String SQL = "Select  coalesce(count(*),0)   from  menupricelist where company_code =  "+vcomp+" and "
  				+ " site_code = "+vstore+"   " ;
   		rs = this.getSPResult(SQL) ;
  		if (rs.next())
  		{
    		  
  			status = rs.getString(1) ;
  			switch(status)
  			{
  			case "0" :
  				status = "Y" ;
  			}
   		}
   		return status ;
   }

	
	private void insertrow() throws ClassNotFoundException, SQLException
	{
		
		new gnTable().RemoveTableRows(model);
 		String vtype = "restoordertype" ;
  	    String sname = scanItem_2.getText().trim();
  		sname = "%" + sname + "%";
	  	String col[] = {"description" , "SalesPrice" };
  		String SQL = "Select  description   from master_table "
  				+ "  where   master_name =  '"+vtype+"' " ;
 	         model.setColumnIdentifiers(col);
		    rs = this.getSPResult(SQL) ;
		    while(rs.next())
		    {
		    	 model.addRow(new Object[]{  rs.getString(1),  "0" });
		    }
	   		 table.setModel(model);
	 	     table.requestFocus();
			//new gnTable().setTableColWidth(promotable, 1, 75);
			//new gnTable().setTableColWidth(promotable, 2, 300);
			 table.setBackground(Color.black);
			 table.setForeground(Color.WHITE);
			 table.setSelectionForeground(Color.white);
			 table.setEditingRow(0);
			JViewport prt11011 = new JViewport();
	 		prt11011.add(table);
			prt11011.setVisible(true);
			 jsp.setViewport(prt11011);
	 		new gnTable().setFontBold(table, 14);
			SelectArticlerow();
			 table.requestFocus(true);
			 table.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}


	

	private void insertrowFromPriceList() throws ClassNotFoundException, SQLException
	{
		new gnTable().RemoveTableRows(model);
 		String vtype = "restoordertype" ;
 		String varticle = articlecode.getText() ;
  	    String sname = scanItem_2.getText().trim();
  		sname = "%" + sname + "%";
	  	String col[] = {"orderType" , "SalesPrice" };
  		String SQL = "Select  ordertype  ,   SalesPrice   from  menupricelist "
  				+ "  where   company_code = "+vcomp+" and site_code = "+vstore+" "
  						+ "  and article_code = "+varticle+"  " ;
 	         model.setColumnIdentifiers(col);
		    rs = this.getSPResult(SQL) ;
		    while(rs.next())
		    {
		    	 model.addRow(new Object[]{  rs.getString(1),rs.getString(2) });
		    }
	   		 table.setModel(model);
	 	     table.requestFocus();
			//new gnTable().setTableColWidth(promotable, 1, 75);
			//new gnTable().setTableColWidth(promotable, 2, 300);
			 table.setBackground(Color.black);
			 table.setForeground(Color.WHITE);
			 table.setSelectionForeground(Color.white);
			 table.setEditingRow(0);
			JViewport prt11011 = new JViewport();
	 		prt11011.add(table);
			prt11011.setVisible(true);
			 jsp.setViewport(prt11011);
	 		new gnTable().setFontBold(table, 14);
			SelectArticlerow();
			 table.requestFocus(true);
			 table.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	
	class articleLsnr  implements ActionListener {
 		@Override
		public void actionPerformed(ActionEvent arg0) {
  			try {
				namesearch() ;
			} catch (ClassNotFoundException | SQLException e) {
 				e.printStackTrace();
			}
		}
 	}
	
	private void namesearch() throws ClassNotFoundException, SQLException {
	 	    
		    new gnTable().RemoveTableRows(promomodel);
		    String sname = scanItem_2.getText().trim();
	  		sname = "%" + sname + "%";
	  		String varticleType = "11" ;
  	  		String col[] = {"Type" , "MenuItemcode", "MenuName" };
	  		String SQL = "Select  Article_code, Name from msArticle_master "
	  				+ "  where company_code = "+vcomp+"  and article_type = "+varticleType+"  and name like  '"+sname+"' " ;
  	  	    String vtype = "Menu Item" ;
  	  	    //new General().msg(SQL);
 	        promomodel.setColumnIdentifiers(col);
  		    rs = this.getSPResult(SQL) ;
  		    while(rs.next())
  		    {
  		    	promomodel.addRow(new Object[]{vtype, rs.getString(1), rs.getString(2)});
  		    }
   	   		promotable.setModel(promomodel);
  	 	    promotable.requestFocus();
  			//new gnTable().setTableColWidth(promotable, 1, 75);
  			new gnTable().setTableColWidth(promotable, 2, 300);
  			promotable.setBackground(Color.black);
  			promotable.setForeground(Color.WHITE);
  			promotable.setSelectionForeground(Color.white);
  			promotable.setEditingRow(0);
  			JViewport prt1101 = new JViewport();
  	 		prt1101.add(promotable);
  			prt1101.setVisible(true);
  			promojsp.setViewport(prt1101);
  	 		new gnTable().setFontBold(promotable, 14);
  			SelectArticlerow();
  			promotable.requestFocus(true);
  			promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
 	}

	
	
	public void SelectArticlerow() {
		promotable.requestFocus(true);
		promotable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		promotable.grabFocus();
		promotable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		promotable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = promotable.getSelectedRow() ;
				articlecode.setText(promotable.getValueAt(row, 1).toString());
				scanItem_2.setText(promotable.getValueAt(row, 2).toString());
				checkForPrice() ;
  			}
		});
		scanItem_2.grabFocus();
	}
 
private void checkForPrice()
{
	try {
		String isavailable  = checkArticleAvailableinMenuPriceList() ;
 		switch(isavailable)
		{
			case "N" :
				insertrow() ;
			break ;
			
		    case "Y" :
		    	insertrowFromPriceList() ;
		    	break ;
		}
	} catch (ClassNotFoundException | SQLException e) {
 		e.printStackTrace();
}
}	
	
	
 class btnLsnr implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
 		
		String value  = e.getActionCommand() ;
		
		if (value == "Close")
		{
			menuPriceListFrame.dispose();
		}
		
		if (value  == "Save")
		{
			try {
				saveAction() ;
			} catch (ClassNotFoundException | SQLException e1) {
 				e1.printStackTrace();
			}
		}
	}
	 
 }

 
 

private void saveAction() throws ClassNotFoundException, SQLException
{
		String isavailable  = checkArticleAvailableinMenuPriceList() ;
		switch(isavailable)
		{
			case "N" :
				insertNewRecord() ;
			     break ;
			
		    case "Y" :
 		    	updatePrice() ;
		    	break ;
		}

}





private void updatePrice() throws SQLException
{
	int row = table.getRowCount() ;
	String varticle = articlecode.getText() ;
	
	for (int i = 0 ; i < row ; i++)
	{
		String vordertype = table.getValueAt(i, 0).toString().trim() ;
		String vsp = table.getValueAt(i, 1).toString().trim() ;
	 	
		String SQL = "update menupriceList set salesprice= "+vsp+" , mrp = "+vsp+"  "
				+ "  where company_code = "+vcomp+" and site_code = "+vstore+" "
						+ "  and article_code = "+varticle+" and orderType= '"+vordertype+"'   "  ;
		this.getResult(SQL);
  	}
	new General().Quickmsg(" Price Updated sucessfully..");
 }


private void insertNewRecord() throws SQLException
{
	int row = table.getRowCount() ;
	String varticle = articlecode.getText() ;
	
	for (int i = 0 ; i < row ; i++)
	{
		String vordertype = table.getValueAt(i, 0).toString().trim() ;
		String vsp = table.getValueAt(i, 1).toString().trim() ;
	 	
		String SQL = "insert into menupriceList(company_code , site_code,"
				+ " ordertype, article_code, salesprice, mrp) "
				+ "values("+vcomp+" , "+vstore+", '"+vordertype+"', "+varticle+", "+vsp+" , "+vsp+") ";
 		this.getResult(SQL);
 	}
	new General().Quickmsg("New Price Updated ");
 }




private void insertBulkRecordFirstTime()
{
 	try {
		String isEmpty = checkPriceListTableEmpty();
 		switch(isEmpty)
		{
				case "Y" :
					//syncsdata() ;
					break ;
				case "N" :
					break ;
		}
 	
 	} catch (ClassNotFoundException | SQLException e) {
 		e.printStackTrace();
	}
}


private void syncsdata() throws ClassNotFoundException, SQLException
{
	int row = 0;
	String varticleType = "11" ;
	String vtype = "restoordertype" ;
 	String SQL  = "select Article_code, salesPrice , othersp from msArticle_master "
			+ " where  company_code = "+vcomp+"   and  article_type  =  "+varticleType+" " ;
 	rs = this.getSPResult(SQL);
  	while(rs.next())
	{
		String varticle= rs.getString(1) ;
		String vsp=  rs.getString(2) ;
		String vothersp=  rs.getString(3) ;
		new General().Quickmsg(varticle);
		bulkRowInsertNow(varticle , vsp) ;
	}
 }



private  void bulkRowInsertNow(String varticle , String vsp) throws ClassNotFoundException, SQLException
{
	String varticleType = "11" ;
	String vtype = "restoordertype" ;

 	String SQL1  = "select description  from  master_table "
			+ " where  master_name = '"+vtype+"'  " ;
 	rs1 = this.getSPResult(SQL1);
	while(rs1.next())
	{
		String vorderType = rs1.getString(1) ;
		String vdisc = "0" ;
			 String SQL9 = " insert into menupricelist(company_code, site_code , orderType, Article_code , "
		 		+ " salesPrice , mrp) values("+vcomp+" , "+vstore+" , '"+vorderType+"' ,"
		 				+ "  "+varticle+" , "+vsp+", "+vsp+" ) ";
		this.getResult(SQL9) ; 		
		}
 }


 


}//Last 




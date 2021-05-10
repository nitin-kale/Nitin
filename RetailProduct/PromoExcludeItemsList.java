package RetailProduct;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import RetailProduct.RestoMenuPriceList.articleLsnr;

import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.JButton;

public class PromoExcludeItemsList  extends getResultSet{

	JFrame promoItemExcludeFrame;

	JScrollPane jsp ;
	JScrollPane promojsp;
	JScrollPane njsp;

	String vcomp ;
	String vstore ;
 
	JTable  table = new JTable();
	public DefaultTableModel model = new DefaultTableModel();
 	JTable promotable = new JTable();
 	public DefaultTableModel promomodel = new DefaultTableModel() ;
 	private JTextField name;
 	
 	JTable ntable = new JTable();
 	public DefaultTableModel nmodel = new DefaultTableModel() ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromoExcludeItemsList window = new PromoExcludeItemsList();
					window.promoItemExcludeFrame.setVisible(true);
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
	public PromoExcludeItemsList() throws ReflectiveOperationException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ReflectiveOperationException 
	 */
	private void initialize() throws ReflectiveOperationException, SQLException {
		promoItemExcludeFrame = new JFrame();
		promoItemExcludeFrame.setAlwaysOnTop(true);
		promoItemExcludeFrame.setBounds(100, 100, 1063, 569);
		promoItemExcludeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		promoItemExcludeFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Item By Name");
		lblNewLabel.setBounds(24, 13, 193, 16);
		promoItemExcludeFrame.getContentPane().add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(24, 33, 410, 30);
		promoItemExcludeFrame.getContentPane().add(name);
		name.setColumns(10);
		
		jsp = new JScrollPane();
		jsp.setBounds(24, 84, 514, 169);
		promoItemExcludeFrame.getContentPane().add(jsp);
		
 		
		promojsp = new JScrollPane();
		promojsp.setBounds(24, 282, 514, 229);
		promoItemExcludeFrame.getContentPane().add(promojsp);
 		
		njsp = new JScrollPane();
		njsp.setBounds(550, 84, 483, 427);
		promoItemExcludeFrame.getContentPane().add(njsp);
		
		JButton btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(441, 253, 97, 30);
		promoItemExcludeFrame.getContentPane().add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(550, 54, 97, 25);
		promoItemExcludeFrame.getContentPane().add(btnDelete);
		
		ActionListener artlsnr = new articleLsnr();
		name.addActionListener(artlsnr);
		
		ActionListener btnlsnr = new btnLsnnr() ;
		btnSave.addActionListener(btnlsnr);
		btnDelete.addActionListener(btnlsnr);
		decorate() ;
	}

	
	
	private void decorate() throws ReflectiveOperationException, SQLException
	{
		vcomp = new gnConfig().getCompanycode() ;
		vstore = new  gnConfig().getStorecode() ;
		ShowExcludeItemList() ;
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
		    String sname = name.getText().trim();
	  		sname = "%" + sname + "%";
	  		String varticleType = "11" ;
  	  		String col[] = {"Type" , "mcode", "Name" };
	  		String SQL = "Select  Article_code, Name from msArticle_master "
	  				+ "  where company_code = "+vcomp+"    and name like  '"+sname+"' " ;
  	  	    String vtype = "Exclude Item" ;
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
				String vcode = promotable.getValueAt(row, 1).toString() ;
				String vname = promotable.getValueAt(row, 2).toString() ;
				try {
					addItem(vcode , vname);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   			}
		});
		name.grabFocus();
	}

	

	private void addItem(String vcode , String vname) throws ClassNotFoundException, SQLException {
 	    
  	  	String col1[] = {"Type" , "mcode", "Name" };
 	         model.setColumnIdentifiers(col1);
 	         String vtype = "Exclude" ;
 		     model.addRow(new Object[]{vtype, vcode, vname});
 	   		 table.setModel(model);
	 	     table.requestFocus();
			//new gnTable().setTableColWidth(promotable, 1, 75);
			  new gnTable().setTableColWidth(table, 2, 300);
			 table.setBackground(Color.black);
			 table.setForeground(Color.WHITE);
			 table.setSelectionForeground(Color.white);
			 table.setEditingRow(0);
			JViewport prt11011 = new JViewport();
	 		prt11011.add( table);
			prt11011.setVisible(true);
			jsp.setViewport(prt11011);
	 		new gnTable().setFontBold( table, 14);
 	}

class btnLsnnr implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent e) {
 
 		String value  = e.getActionCommand() ;
 		
 		if (value == "Save")
 		{
  			try {
				callSaveEvent() ;
			} catch (ClassNotFoundException | SQLException e1) {
 				e1.printStackTrace();
			}
 		}
 		
 		
 		if (value == "Close")
 		{
 			promoItemExcludeFrame.dispose();	
 		}

 		if (value == "Delete")
 		{
 			
 			try {
				deleteRecord();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 		}
  		
	}
 }
	

private  void callSaveEvent() throws ClassNotFoundException, SQLException
{

	String vcode ="" ;
	int row = table.getRowCount() ;
	for(int i =0 ; i < row ; i++)
	{
        vcode = table.getValueAt(i, 1).toString() ; //getArticlecode here
 		deleteifExist(vcode) ;
        String vtype = "ExcludeMonthPromoItem" ;
		String vexclude = "Y" ;
		String SQL9 = " insert into ms_promomonthly_exclude_item(company_code, site_code ,   Article_code , "
			 		+ " Exclude, type ) values("+vcomp+" , "+vstore+" , "+vcode+" ,"
			 				+ "  '"+vexclude+"'  , '"+vtype+"') ";
			this.getResult(SQL9) ; 		
 	}
  	new General().Quickmsg("Item Added ->Sucess ...");
	ShowExcludeItemList() ;

}


private void deleteRecord() throws SQLException, ClassNotFoundException
{
	int row = ntable.getSelectedRow() ;
	String vcode  = ntable.getValueAt(row, 1).toString() ;
	
	String SQL = "Delete from ms_promomonthly_exclude_item  where  company_code = "+vcomp+"  "
			+ " and site_code = "+vstore+"  and article_code = "+vcode+" " ;
	this.getResult(SQL) ;
	ShowExcludeItemList() ;
			
}

private void deleteifExist(String vcode) throws SQLException
{
	String SQL = "Delete from ms_promomonthly_exclude_item  "
			+ " where company_code = "+vcomp+"   and site_code = "+vstore+"  and "
			+ " article_code = "+vcode+" " ;
	
	this.getResult(SQL) ;
}

private void ShowExcludeItemList() throws ClassNotFoundException, SQLException {
	    
    new gnTable().RemoveTableRows(nmodel);
	String vtype = "ExcludeMonthPromoItem" ;
	String vexclude = "Y" ;
  	String col[] = {"Type" , "code", "Name" };
		String SQL = "Select  a.Article_code, b.Name "
				+ " from ms_promomonthly_exclude_item a , msArticle_master b   "
				+ "  where a.company_code = "+vcomp+"   and a.site_code = "+vstore+"  and "
				+ "   a.exclude = '"+vexclude+"' and a.type = '"+vtype+"' "
				+ "  and a.company_code = b.company_code and a.Article_code = b.Article_code " ;
 		vtype = "Exclude Item" ;
         nmodel.setColumnIdentifiers(col);
	    rs = this.getSPResult(SQL) ;
	    while(rs.next())
	    {
	    	nmodel.addRow(new Object[]{vtype, rs.getString(1), rs.getString(2)});
	    }
  		ntable.setModel(nmodel);
	    ntable.requestFocus();
		//new gnTable().setTableColWidth(promotable, 1, 75);
		new gnTable().setTableColWidth(ntable, 2, 300);
		ntable.setBackground(Color.black);
		ntable.setForeground(Color.WHITE);
		ntable.setSelectionForeground(Color.white);
		ntable.setEditingRow(0);
		JViewport prt117 = new JViewport();
		prt117.add(ntable);
		prt117.setVisible(true);
		njsp.setViewport(prt117);
		new gnTable().setFontBold(ntable, 14);
		SelectArticlerow();
		ntable.requestFocus(true);
		ntable.setCursor(new Cursor(Cursor.HAND_CURSOR));
}
}//Last 

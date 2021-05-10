package RetailProduct;

import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class gnProductionTemplate extends getResultSet{

	
	
	public String vuser;
	public String sql;
	public String type;
	public String vcomp;
	public String vstore;
 	public JTable vtable = new JTable();
	public DefaultTableModel vmodel = new DefaultTableModel();
	public JScrollPane sjsp = new JScrollPane();
	public JTextField vcompcode;
	public JTextField vcompname;

	public static String rarticle_code;
	public static String rarticle_name;
	private String SQL;


	private void getDefaultData() throws Throwable
	{
		vcomp = new gnConfig().getCompanyCode();
		vstore  = new gnConfig().getStoreID() ; 

	}


	
	public String isTemplateExistForFinishItem(String varticle) throws Throwable
	{
		getDefaultData() ;
		String status  = "Sucess" ;
 		String SQL = "Select distinct(finishitemcode) as code  from prod_template where company_code = '"+vcomp+"' "
				+ " and site_code  = '"+vstore+"' and finishitemcode = '"+varticle+"' " ;
		rs = this.getSPResult(SQL) ;
		if (!rs.next())
		{
			status = "Fail" ;
			new General().msg("Finish Item Not Available in Template ... ");
		}
 		return status  ;
	}



	public String getTemplateName(String varticle) throws Throwable
	{
		getDefaultData() ;
   		String vname  = "NA" ;
		String vtype = "GetTemplateNameforFinishItem" ;
 		String SQL = "call Template_getData( '"+vtype+"' , '"+vcomp+"' , '"+vstore+"', '"+varticle+"' , '"+vname+"')" ;
 	   // new General().msg(SQL);
 		rs = this.getSPResult(SQL) ;
	    if (rs.next())
	    {
	    	vname = rs.getString(1) ;
	    }
	    return vname ;
 	}	 
	
	

}//Last 



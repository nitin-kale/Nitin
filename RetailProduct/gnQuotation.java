package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnQuotation {

	public static String vcustcode;
	public static String vcustname;
	public static String vemail;
	public static String vphone;
	public static String vquotationno;;
	public static String vquotationdate;
	public static String vvalidupto;
	public static String vstatus;
	public static String vamount;
	public static String vadvance;
	public static String vpaymentterm;
	public static String vterms;

	private String vcomp;
	private String vstore;

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	String SCol[] = { "Type ", "Cust code", "Cust Name", "Quotation No", "Date", "Valid Upto", "Status", "Amount",
			"Email", "Phone", "Advance", "Payment_term", "Terms" };

	
	String SautoCol[] = { "Type ", "Cust code", "Cust Name", "Quotation No", "Date", "Valid Upto", "Status", "Amount",
			"Email", "Phone", "Advance", "Payment_term", "Terms" };

	public JScrollPane sjsp = new JScrollPane();

		

	
 
	public JTable getautomobileQuotationIntable(String custcode) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
 		String sautocol[] = {"Type" , "QuotationNo", "Date", "Veichleno" , "Name" , 
				                "Model", "Color", "Power" , "price"} ;
 		String vformat = "%d.%m.%Y" ;
 		String vstatus = "C" ;
		String SQL = "Select Qno , date_format(qdate , '"+vformat+"') as qdate , article_code, article_name , "
				+ " model , color, power,  price  "
				+ " from ms_quotation_master where  company_code = " + vcomp + " and  site_code =  "+vstore+" "
				+ " and customer =  "+custcode+"   and status <> '"+vstatus+"'  " ;
		
		//String SQL = "call  wsales_getcustomerQuotations('" + custcode + "' , " + vcomp + ", " + vstore + ")";
		
		smodel.setColumnIdentifiers(sautocol);
		String type = "Quotation";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, sautocol, 8, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		// DefaultCellEditor nk = new gnTable().cellEdit2(stable) ;
		// nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select Data ", 900, 300);
		return stable ;
		
		//Selectrow();
	}

	

	public JTable getautomobileQuotationforInvoiceIntable(String vdocno , String vdocdate) throws Throwable {
		 
		vcomp = new gnConfig().getCompanyCode();
		 vstore = new gnConfig().getStoreID();
		 vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate) ;
         String vloc = "SL" ;
		 String sautocol[] = { "Romove", "Item", "Name", "Qty", "UOM", "Inner Qty", "Rate", "MRP",
				                    "Gross", "Bill Disc",  "Disc", "Amount", "Tax%", "Tax Amount", 
				                    "Chassisno", "MotorNo", "ControllerNo", "Cost", "Location" };
  		String SQL = "Select a.article_code, a.article_name ,  "
				+ "  1, b.uom , 1, a.price , b.mrp, a.gross , 0, a.discount , a.netAmt ,"
				+ "  b.tax_code , 0, 0,0,0 , b.cost, '"+vloc+"'  "
				+ "  from ms_quotation_master a  , msARticle_master b "
				+ "  where  a.company_code = " + vcomp + " and  a.site_code =  "+vstore+" "
				+ "  and qno =  "+vdocno+"   and qdate  = '"+vdocdate+"' "
				+ "  and a.company_code = b.company_code and a.article_code = b.article_code" ;
  		//new General().msg(SQL);
  		smodel.setColumnIdentifiers(sautocol);
		String type = "Quotation";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, sautocol, 18, "Y", "N", type);
		new gnTable().setTableColWidth(stable, 2, 300);
  		return stable ;
 	}

	
	
	
	
	
	
	
	
	
	// Quotation Data For Enter QuotationNo
	public void getQuotationForInvoce() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call  wsales_getQuotationsSearch( " + vcomp + ", " + vstore + ")";
		smodel.setColumnIdentifiers(SCol);
		String type = "Quotation";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 12, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		// DefaultCellEditor nk = new gnTable().cellEdit2(stable) ;
		// nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select Data ", 900, 300);
		Selectrow();
	}

	// Customer Specific Quotation Search
	public void getQuotation(String custcode) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call  wsales_getcustomerQuotations('" + custcode + "' , " + vcomp + ", " + vstore + ")";
		smodel.setColumnIdentifiers(SCol);
		String type = "Quotation";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 12, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		// DefaultCellEditor nk = new gnTable().cellEdit2(stable) ;
		// nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select Data ", 900, 300);
		Selectrow();
	}

	public void Selectrow() {
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = stable.getSelectedRow();
				String value = (String) stable.getValueAt(row, 0);
				try {
					dispalyinfo(value, row); // showCustData();
					new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Data ", 900, 300);
	}

	public CellEditorListener ChangeNotification3 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = stable.getSelectedRow();
			String value = (String) stable.getValueAt(row, 0);
			try {
				dispalyinfo(value, row); // showCustData();
				new General().msgDispose();
			} catch (Exception e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	};

	private void dispalyinfo(String value, int row) throws Throwable {
		switch (value) {
		// "Type " , "Cust code" , "Cust Name" , "Quotation No" , "Date" ,
		// "Valid Upto" , "Status", "Amount" , "Email", "Phone" } ;
		case "Quotation":
			vcustcode = (stable.getValueAt(row, 1).toString());
			vcustname = (stable.getValueAt(row, 2).toString());
			vquotationno = (stable.getValueAt(row, 3).toString());
			vquotationdate = (stable.getValueAt(row, 4).toString());
			vvalidupto = (stable.getValueAt(row, 5).toString());
			vstatus = (stable.getValueAt(row, 6).toString());
			vamount = (stable.getValueAt(row, 7).toString());
			vemail = (stable.getValueAt(row, 8).toString());
			vphone = (stable.getValueAt(row, 9).toString());
			vadvance = (stable.getValueAt(row, 10).toString());
			vpaymentterm = (stable.getValueAt(row, 11).toString());
			vterms = (stable.getValueAt(row, 12).toString());
			new gnTable().RemoveTableRows(smodel);
			break;
		}
	}

}

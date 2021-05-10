package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnStockcheck extends getResultSet {
	private String vcomp;
	private String vstore;
	public static String rscno;
	public static String vfinyear = "";

	public static String rscdate;
	public static String rscstatus;

	public JTable vtable = new JTable();
	public DefaultTableModel vmodel = new DefaultTableModel();
	public JScrollPane sjsp = new JScrollPane();

	public String getOpeningStockValue(String vdate) throws Throwable {
		String value = "";
		vcomp = new gnConfig().getCompanyCode();
		vdate = new gnConfig().calculateManufDate(vdate, 1);
		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		String SQL = "Call Stok_getopstockvalue(" + vcomp + " , '" + vdate + "')";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			value = rs.getString(1);
			// value="0.00";
		} else {
			value = "0.00";
		}
		return value;
	}

	public String getStockOnDate(String vdate) throws Throwable {
		String value = "";
		vcomp = new gnConfig().getCompanyCode();
		String vdate1 = new gnConfig().date_ConverttoDBforamt(vdate);
		String SQL = "Call Stok_getopstockvalue(" + vcomp + " , '" + vdate1 + "')";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			value = rs.getString(1);
		} else {
			String vcurdate = new General().getDate();
			if (vcurdate == vdate) {
				SQL = "Call Stock_getCurrentStock(" + vcomp + ")";
				// new General().msg(SQL);
				rs1 = this.getSPResult(SQL);
				if (rs1.next()) {
					value = rs1.getString(1);
				} else {
					value = "0";
				}
			}
		}
		return value;
	}

	public double getArticleStock(String varticle, String vloc) throws Throwable {
		double vqty = 0.00;
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
 		if (varticle.length() != 0) {
		String SQL = "call Stock_getArticleStock("+vcomp+" , " + vstore + " , '" + varticle + "' , '" + vloc
					+ "' )";
 			rs = this.getSPResult(SQL);
			if (!rs.next()) 
			{
				 
			} else {
				String vvqty = rs.getString(2);
				vqty = Double.parseDouble(vvqty);
			}
		}
		return vqty;
	}

	public void getStockCheckNo() throws Throwable {
		String no = "0";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		String SQL = "call  SC_getOpenStockCheck(" + vcomp + " , " + vstore + " ,  '" + vfinyear + "')";
		String vtype = "Stock Check";
		String ACol[] = { "Type", "Stock Check No", "Date", "Status", "Created By" };
		vtable = new gnTableModel().Tablemodel(vtable, vmodel, SQL, ACol, 4, "N", "Y", vtype);
		// vtable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification101);
		// new General().msgsearch(sjsp,vtable, "Select Stock Check No" , 600,
		// 200);
		Selectrow();

	}

	public void Selectrow() {
		vtable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		vtable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = vtable.getSelectedRow();
				String value = (String) vtable.getValueAt(row, 0);
				try {
					rscno = (vtable.getValueAt(row, 1).toString());
					rscdate = (vtable.getValueAt(row, 2).toString());
					rscstatus = (vtable.getValueAt(row, 3).toString());
					// dispalyinfo(value, row) ; // showCustData();
					new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		vtable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, vtable, "Select Data ", 600, 300);
	}

	public CellEditorListener ChangeNotification101 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = vtable.getSelectedRow();
			String value = (String) vtable.getValueAt(row, 0);
			try {
				rscno = (vtable.getValueAt(row, 1).toString());
				rscdate = (vtable.getValueAt(row, 2).toString());
				rscstatus = (vtable.getValueAt(row, 3).toString());
				new General().msgDispose();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
			new General().msgDispose();
		}
	};

	public String getOpenStock() throws Throwable {
		String no = "0";
		vfinyear = new gnFinYear().getReportingFinYear();
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call  SC_getOpenStockCheck(" + vcomp + " , " + vstore + ", '" + vfinyear + "')";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			no = rs.getString(1);
			rscno = rs.getString(1);
			rscdate = rs.getString(2);
			rscstatus = rs.getString(3);
			new General().msg("Privious Stock Check is Still Open< Stock Check Number is " + " " + no + "> ");
		}
		return no;
	}

	public String closeOpenStock(String vstockcheckno) throws Throwable {
		String status = "Sucess";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		String SQL = "call  SC_closeOpenStockCheck(" + vcomp + " , " + vstore + ", '" + vstockcheckno + "', '"
				+ vfinyear + "')";
		this.getSPResult(SQL);
		new General().msg("Stock Check Closed ...Any Action Can't  Perform On  This Stock Check  Now..");
		return status;
	}

	public void performRemoveAction(String vscno) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "Call SC_flush_tmp_data()";
		this.getSPResult(SQL);

	}

	public void performActionOnDetailTable(String vscno) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();

		vfinyear = new gnFinYear().getReportingFinYear();
		String SQL1 = "call SC_physicaldetailrm(" + vcomp + ", " + vstore + " , '" + vscno + "' , '" + vfinyear + "') ";
		// String SQL2 = "Call SC_insertGroupingDetailData()" ;
		// new General().msg( "Processing SQL for Remove REcords for detail and
		// insert new "+" "+SQL1);
		this.getResult(SQL1);

		// this.getResult(SQL2) ;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}// last

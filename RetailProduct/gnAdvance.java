package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class gnAdvance extends getResultSet {

	String vcomp;
	String vstore;
	String vdoctype;
	String vdocno;
	String vdocdate;
	String vfinyear;
	String SQL;
	public static String rdocno;
	public static String rdocdate;
	public static String ramount;

	public static String rpaymode;
	public static String rbankcode;
	public static String rbankname;
	public static String rinstumentno;
	public static String rinstrumentdate;

	private JTable table = new JTable();
	private JTable stable = new JTable();
	private DefaultTableModel smodel = new DefaultTableModel();
	private JScrollPane sjsp = new JScrollPane();

	public String getPaymentmode(String vtype, String vdocno, String vdocdate) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		SQL = " call Bank_getPaymentModeDetail('" + vtype + "',  " + vcomp + "   , " + vstore + " , " + vdocno + " , '"
				+ vdocdate1 + "' , '" + vfinyear + "' )";
		this.getSPResult(SQL);
		while (rs.next()) {
			rpaymode = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return rpaymode;
	}

	public void getBankRelatedDetails(String vtype, String vdocno, String vdocdate) throws Throwable {
		vfinyear = new gnFinYear().getReportingFinYear();
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		// rpaymode = getPaymentmode(vtype, vdocno , vdocdate) ;
		SQL = " call Bank_getPaymentModeDetail('" + vtype + "',  " + vcomp + "   , " + vstore + " , " + vdocno + " , '"
				+ vdocdate1 + "' , '" + vfinyear + "' )";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			rpaymode = rs.getString(1);
			rbankcode = rs.getString(2);
			rbankname = rs.getString(3);
			rinstumentno = rs.getString(4);
			rinstrumentdate = rs.getString(5);
			// new General().msg(rpaymode+" "+rbankcode+ " "+rbankname+ "
			// "+rinstumentno + " "+ rinstrumentdate);
		}
		rs.close();
		this.closeconn();
	}

	public void getadvanceDocumentList(String vtype, String vparty) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String col[] = { "Type", "Doc.No", "Doc.Date", "Mode", "Instrumentno", "Inst.Date", "Amount", "GL code",
				"GlName" };
		new gnTable().RemoveTableRows(smodel);
		smodel.setColumnIdentifiers(col);
		String SQL = "call voucher_viewData('" + vtype + "', " + vcomp + ", " + vstore + ", " + vparty + ")";
		new General().msg(SQL);
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col, 8, "N", "Y", vtype);
		stable.setModel(smodel);
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
				}
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Data ", 900, 300);
	}

	private void dispalyinfo(String value, int row) {
		switch (value) {
		case "PV":

			// "Type" , "Doc.No" , "Doc.Date" , "Mode" , "Instrumentno" ,
			// "Inst.Date" , "Amount" , "GL code" , "GlName"} ;
			rdocno = stable.getValueAt(row, 1).toString();
			rdocdate = stable.getValueAt(row, 2).toString();
			rpaymode = stable.getValueAt(row, 3).toString();
			rinstumentno = stable.getValueAt(row, 4).toString();
			rinstrumentdate = stable.getValueAt(row, 5).toString();
			ramount = stable.getValueAt(row, 6).toString();
			// rbankcode= stable.getValueAt(row, 7).toString();
			// rbankname= stable.getValueAt(row, 8).toString();
			break;
		case "RV":
			// "Type" , "Doc.No" , "Doc.Date" , "Mode" , "Instrumentno" ,
			// "Inst.Date" , "Amount" , "GL code" , "GlName"} ;
			rdocno = stable.getValueAt(row, 1).toString();
			rdocdate = stable.getValueAt(row, 2).toString();
			rpaymode = stable.getValueAt(row, 3).toString();
			rinstumentno = stable.getValueAt(row, 4).toString();
			rinstrumentdate = stable.getValueAt(row, 5).toString();
			ramount = stable.getValueAt(row, 6).toString();
			// rbankcode= stable.getValueAt(row, 7).toString();
			// rbankname= stable.getValueAt(row, 8).toString();
			break;

		case "SAD":
			// "Type" , "Doc.No" , "Doc.Date" , "Mode" , "Instrumentno" ,
			// "Inst.Date" , "Amount" , "GL code" , "GlName"} ;
			rdocno = stable.getValueAt(row, 1).toString();
			rdocdate = stable.getValueAt(row, 2).toString();
			rpaymode = stable.getValueAt(row, 3).toString();
			rinstumentno = stable.getValueAt(row, 4).toString();
			rinstrumentdate = stable.getValueAt(row, 5).toString();
			ramount = stable.getValueAt(row, 6).toString();
			// rbankcode= stable.getValueAt(row, 7).toString();
			// rbankname= stable.getValueAt(row, 8).toString();
			break;

		case "CAD":
			// "Type" , "Doc.No" , "Doc.Date" , "Mode" , "Instrumentno" ,
			// "Inst.Date" , "Amount" , "GL code" , "GlName"} ;
			rdocno = stable.getValueAt(row, 1).toString();
			rdocdate = stable.getValueAt(row, 2).toString();
			rpaymode = stable.getValueAt(row, 3).toString();
			rinstumentno = stable.getValueAt(row, 4).toString();
			rinstrumentdate = stable.getValueAt(row, 5).toString();
			ramount = stable.getValueAt(row, 6).toString();
			// rbankcode= stable.getValueAt(row, 7).toString();
			// rbankname= stable.getValueAt(row, 8).toString();
			break;

		}

	}

}// Last

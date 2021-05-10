package RetailProduct;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class gnSale extends getResultSet {

	private String vcomp;
	private String vstore;
	private String type;
	private String status;
	private String SQL;
	private String vfinyear;
	public static String rinvno;
	public static String rinvdate;
	public static String rcustcode;
	public static String rcustname;

	public String pcol[] = { "Type", "Customer", "Name", "Inv.No", "Inv Date", "Amount" };
	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();

	public JScrollPane sjsp = new JScrollPane();

	private void getStandard() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		if (vcomp == "0") {
			new General().msg("No Company is Selected...");
		}
	}

	public void showinvoice(String vbillno, String vbilldate) throws Throwable {
		getStandard();
		vbilldate = new gnConfig().date_ConverttoDBforamt(vbilldate);
		String sqlbill = "call   Invoice_getScanInvoice(" + vbillno + " , '" + vbilldate + "' , " + vstore + ", "
				+ vcomp + ")";
		String SR[] = { "Item code", "Name", "Qty", "Rate", "MRP", "Gross", "Hdr_disc", "Disc", "Tax_Amt", "Total_Amt",
				"Tax_code", "Site_code", "Invno", "Invdate" };
		new gnTable().RemoveTableRows(smodel);
		smodel.setColumnIdentifiers(SR);
		stable = new gnTableModel().Tablemodel(stable, smodel, sqlbill, SR, 14, "N", "N", "N");
		new gnTable().setTableColWidth(stable, 0, 100);
		new gnTable().setTableColWidth(stable, 1, 250);
		new gnTable().setTableColWidth(stable, 0, 75);
		new gnTable().setTableColWidth(stable, 0, 100);
		stable.setBackground(Color.BLACK);
		stable.setForeground(Color.WHITE);
		stable.setGridColor(Color.YELLOW);
		stable.setEnabled(true);
		stable.setRowSelectionAllowed(true);
		if (stable.getRowCount() > 0) {
			String vmsg = " View Bill ---> Bill No :" + stable.getValueAt(0, 12);
			new General().msgsearch(sjsp, stable, vmsg, 1100, 500);

		}
	}

	public void get_invnoForcustomer(String vinvtype, String vcustcode) throws Throwable {
		getStandard();
		switch (vinvtype) {
		case "WS":
			type = "WS";
			SQL = "call  SAL_invsearchForcust(" + vcomp + ", " + vstore + ", " + vcustcode + ", '" + vinvtype + "'  , '"
					+ vfinyear + "')";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, pcol, 5, "N", "Y", type);
			break;

		case "PS":
			type = "PS";
			SQL = "call  SAL_invsearchForcust(" + vcomp + ", " + vstore + ", " + vcustcode + ", '" + vinvtype + "' , '"
					+ vfinyear + "')";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, pcol, 5, "N", "Y", type);
			break;

		case "B2B":
			type = "B2B";
			SQL = "call  SAL_invsearchForcust(" + vcomp + ", " + vstore + ", " + vcustcode + ", '" + vinvtype + "' ,  '"
					+ vfinyear + "')";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, pcol, 5, "N", "Y", type);
			break;

		case "SR":
			type = "SR";
			SQL = "call  SAL_invsearchForcust(" + vcomp + ", " + vstore + ", " + vcustcode + ", '" + vinvtype + "')";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, pcol, 5, "N", "Y", type);
			break;

		}

		new gnTable().setTableColWidth(stable, 2, 300);
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

	private void dispalyinfo(String value, int row) throws Throwable {
		switch (value) {
		case "WS":
			rinvno = stable.getValueAt(row, 3).toString();
			rinvdate = stable.getValueAt(row, 4).toString();
			new gnTable().RemoveTableRows(smodel);
			break;
		case "PS":
			rinvno = stable.getValueAt(row, 3).toString();
			rinvdate = stable.getValueAt(row, 4).toString();
			new gnTable().RemoveTableRows(smodel);
			break;
		case "B2B":
			rinvno = stable.getValueAt(row, 3).toString();
			rinvdate = stable.getValueAt(row, 4).toString();
			new gnTable().RemoveTableRows(smodel);
			break;
		case "SR":
			rinvno = stable.getValueAt(row, 3).toString();
			rinvdate = stable.getValueAt(row, 4).toString();
			rcustcode = stable.getValueAt(row, 1).toString();
			rcustname = stable.getValueAt(row, 2).toString();
			new gnTable().RemoveTableRows(smodel);
			break;

		}
	}

}// Last

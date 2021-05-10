package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnGrn extends getResultSet {

	private String vcomp;
	private String vstore;
	private String type;
	private String status;
	private String SQL;
	public static String rgrnno;
	public static String rgrndate;
	public static String rpono;
	public static String rpodate;

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();

	public JScrollPane sjsp = new JScrollPane();
	private String[] GRCol = { "Type", "Vendor", "Name", "Grn No", "Grn Date", "Amount", "Po_no", "Company",
			"Storecode", "Approve GRN" };
	private String[] GRCol1 = { "Type", "Vendor", "Name", "Grn No", "Grn Date", "Amount", "Po_no", "Company",
			"Storecode", "Approve GRN", "POdate" };

	private String[] PRCol = { "Type", "Vendor", "Name", "Grn No", "Grn Date", "Amount", "Company", "Storecode",
			"Approve GRN" };

	public void viewGrn(String vdocno, String vdocdate) throws Throwable {
		getStandard();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vvtype = "VIEWGRN";
		String vverticle = new gnHierarchy().getVerticleCode();
		SQL = "Call  view_PurchaseData('" + vvtype + "', " + vcomp + "," + vstore + ", '" + vdocno + "' ,'" + vdocdate
				+ "'  , " + vverticle + " )";
		String PoCol[] = { "Type", "Article_code", "Name", "Qty", "UOM", "cost", "Line Discount", "Disc", "CostValue ",
				"sales Price", "MRP", "Trans.Chrg", "Oth.Chrg", "Landing Cost", "Tax%", "Bal Qty", "Manuf.Date",
				"Expiry date", "Batch No", "Batch_Control", "Location", "EanCode", "MBQ", "InvNo", "Name" };
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, PoCol, 24, "N", "Y", vvtype);
		new gnTable().setTableColWidth(stable, 2, 250);
		new General().msgsearch(sjsp, stable, "View Purchase  Data " + " " + vdocno, 1300, 300);

	}

	private void getStandard() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		if (vcomp == "0") {
			new General().msg("No Company is Selected...");
		}
	}

	public void get_PrnoforVendor(String grntype, String vvendor) throws Throwable {
		getStandard();
		switch (grntype) {
		case "PR":
			type = "PR";
			SQL = "call  PR_PRsearchForvendor(" + vcomp + ", " + vstore + ", " + vvendor + ")";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, PRCol, 8, "N", "Y", type);
			break;
		}
		new gnTable().setTableColWidth(stable, 2, 300);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, GRCol);
		sjsp.setViewport(prt6);
		Selectrow();
	}

	public void get_GrnoforVendor(String grntype, String vvendor) throws Throwable {
		getStandard();
		// new General().msg(grntype);
		switch (grntype) {
		case "GR":
			type = "GR";
			SQL = "call  Gr_grsearchForvendor(" + vcomp + ", " + vstore + ", " + vvendor + ")";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, GRCol, 9, "N", "Y", type);
			break;
		case "GRPO":
			type = "GRPO";
			SQL = "call  GR_GrwithpoSEarchForVendor(" + vcomp + ", " + vstore + ", " + vvendor + ")";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, GRCol1, 10, "N", "Y", type);
			break;
		}

		new gnTable().setTableColWidth(stable, 2, 300);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, GRCol);
		sjsp.setViewport(prt6);
		Selectrow();
	}

	public void getPodetails(String vgrno, String vgrdate) throws Throwable {
		getStandard();
		vgrdate = new gnConfig().date_ConverttoDBforamt(vgrdate);
		String SQL = "call GR_getPodetails(" + vcomp + "  , " + vstore + " , " + vgrno + "  , '" + vgrdate + "' )";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			rpono = rs.getString(1);
			rpodate = rs.getString(2);
		}
		rs.close();
		this.closeconn();

	}

	public void get_Grno(String grntype) throws Throwable {
		getStandard();
		// new General().msg(grntype);
		switch (grntype) {
		case "GRPO":
			type = "GR";
			SQL = "call  Grpo_grsearch(" + vcomp + ", " + vstore + ")";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, GRCol, 9, "N", "Y", type);
			break;
		case "GR":
			type = "GR";
			SQL = "call  Gr_grsearch(" + vcomp + ", " + vstore + ")";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, GRCol, 9, "N", "Y", type);
			break;
		case "PR":
			type = "PR";
			SQL = "call  PR_PRsearch(" + vcomp + ", " + vstore + ")";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, GRCol, 9, "N", "Y", type);
			break;

		}

		new gnTable().setTableColWidth(stable, 2, 300);
		// DefaultCellEditor nk = new gnTable().cellEdit2(stable) ;
		// nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, GRCol);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select Data ", 700, 500);
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
		case "GR":
			rgrnno = stable.getValueAt(row, 3).toString();
			rgrndate = stable.getValueAt(row, 4).toString();
			new gnTable().RemoveTableRows(smodel);
			break;
		case "PR":
			rgrnno = stable.getValueAt(row, 3).toString();
			rgrndate = stable.getValueAt(row, 4).toString();
			new gnTable().RemoveTableRows(smodel);
			break;
		case "GRPO":
			rgrnno = stable.getValueAt(row, 3).toString();
			rgrndate = stable.getValueAt(row, 4).toString();
			rpono = stable.getValueAt(row, 6).toString();
			rpodate = stable.getValueAt(row, 10).toString();

			new gnTable().RemoveTableRows(smodel);
			break;

		}
	}

	private String checkGrnExist(String vpono) {

		String vtype = "GR";
		// String sqlaName = "call Grpo_grsearch("+vcomp+", "+vstorecode+",
		// "+vvendor+")";
		String[] GRCol = { "Type", "Vendor", "Name", "Grn No", "Grn Date", "Amount", "Po_no", "Company", "Storecode",
				"Approve GRN" };

		// SQL = "call GRN_check"

		return status;
	}

	public static void main(String[] args) {

	}

}// Last

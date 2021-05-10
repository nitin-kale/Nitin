package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnPO extends getResultSet {

	public static String pono;
	public static String poate;
	public static String vendor;
	public static String vendorname;
	public static String email;
	public static String phone;
	public static String crdays;
	public static String potype;
	public static String postatus;
	public static String poamt;
	public static String leadtime;
	public static String expdate;
	public static String approvestatus;
	public static String approveby;
	public static String approvedate;
	public static String rstatecode;
	public static String rstatename;
	public static String rregdlr;

	private String vcomp;
	private String vstore;

	private String vcost = "0.00";
	private String vmrp = "0.00";
	private String vsp = "0.00";

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public JScrollPane sjsp = new JScrollPane();

	String SCol[] = { "Type ", "Comp", "Store", "PO No", "PO Date", "Vendor", "Name", "Credit Days", "PO Type",
			"Amount", "PO Status", "Lead time", "Exp.Date", "Phone", "Email", "ApprovePO", "Appr.By", "Appr Date",
			"State", "Name", "GST.Reg.Dlr" };

	public String checkpoExist(String vpono) throws Throwable {
		String action = "Sucess";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call    po_checkpoExist(" + vpono + " , " + vcomp + ", " + vstore + ")";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			int option = new General().msgInput("Invalid PO.No...Would you Like Search PO");
			if (option == 0) {
				// showpoSearch();
				action = "Fail";
			}
		} else {
			String vstatus = rs.getString(2);
			switch (vstatus) {
			case "Close":
				new General().msg("Status of Enter PO.NO is Closed , Goods is Received against This PO");
				action = "Fail";
			}
		}
		rs.close();
		this.closeconn();
		return action;
	}

	public void getPurchaseInfoRecord(String vsupplier, String varticle) throws Throwable {
		String SQL = "";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String pcol[] = { "Type", "Supplier", "Article", "Name", "Cost", "Mrp", "SP", "Last PO Date" };
		smodel.setColumnIdentifiers(pcol);
		String type = "Info";
		new gnTable().RemoveTableRows(smodel);
		SQL = "call  po_getPurInfoRecord(" + vcomp + ", " + vstore + " , " + vsupplier + " , " + varticle + ")";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, pcol, 7, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 3, 300);
		DefaultCellEditor nk = new gnTable().cellEdit(stable);
		nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Purchase Info Record");
		prt6.setScrollMode(0);
		prt6.add(stable, pcol);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select Purchase Record", 700,
		// 200);
		Selectrow();

	}

	public void getVendorPO(String sname, String vtype) throws Throwable {
		/// new General().msg(vtype);
		String SQL = "";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		smodel.setColumnIdentifiers(SCol);
		new gnTable().RemoveTableRows(smodel);
		switch (vtype) {
		case "VendorPO":
			SQL = "call  po_getVendorPOSearch('" + sname + "' , " + vcomp + ", " + vstore + ")";
			break;
		case "VendorOpenPO":
			SQL = "call  po_getVendorOpenPO('" + sname + "' , " + vcomp + ", " + vstore + ")";
			break;
		case "POFORGR":
			SQL = "call  po_getpoforgrn( " + vcomp + ", " + vstore + ")";
			break;

		}
		String type = "PO";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 20, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 6, 300);
		DefaultCellEditor nk = new gnTable().cellEdit(stable);
		nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select PO NO From List <Click
		// on row to select Record", 1100, 500);
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
		case "PO":
			pono = stable.getValueAt(row, 3).toString();
			poate = stable.getValueAt(row, 4).toString();
			// new General().msg(poate);
			vendor = stable.getValueAt(row, 5).toString();
			vendorname = stable.getValueAt(row, 6).toString();
			email = stable.getValueAt(row, 14).toString();
			phone = stable.getValueAt(row, 13).toString();
			crdays = stable.getValueAt(row, 7).toString();
			potype = stable.getValueAt(row, 8).toString();
			postatus = stable.getValueAt(row, 10).toString();
			poamt = stable.getValueAt(row, 9).toString();
			leadtime = stable.getValueAt(row, 11).toString();
			expdate = stable.getValueAt(row, 12).toString();
			approvestatus = stable.getValueAt(row, 15).toString();
			approveby = stable.getValueAt(row, 16).toString();
			approvedate = stable.getValueAt(row, 17).toString();
			rstatecode = stable.getValueAt(row, 18).toString();
			rstatename = stable.getValueAt(row, 19).toString();
			rregdlr = stable.getValueAt(row, 20).toString();
			break;
		case "Info":
			vcost = stable.getValueAt(row, 4).toString();
			vmrp = stable.getValueAt(row, 5).toString();
			vsp = stable.getValueAt(row, 6).toString();
			break;
		}

	}

}// last

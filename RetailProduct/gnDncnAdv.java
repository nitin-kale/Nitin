package RetailProduct;

import javax.swing.DefaultCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnDncnAdv extends getResultSet {

	public static String rpartycode = " ";
	public static String rpartynameName = " ";
	public static String rdocno = " ";
	public static String rdocdate = " ";
	public static String rdoctype = " ";
	public static String rdoc_category = " ";
	public static String ramount = " ";
	public static String rconsumenamt = " ";
	String SQL;

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	String SCol[] = { "Type", "PartyCode", "Name", "Reg.Dlr", "Type", "Doc.Cat", "DocNo", "Doc.Date", "Amount",
			"Consume" };

	public JScrollPane sjsp = new JScrollPane();

	public void getOpenAdvdncn(String vparty, String vdoctype, String vcat) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call  Adv_getOpenAdvDetails(" + vcomp + ", " + vstore + ", " + vparty + ", '" + vdoctype + "' ,'"
				+ vcat + "')";
		smodel.setColumnIdentifiers(SCol);
		String type = "Advcndn";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 9, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		DefaultCellEditor nk = new gnTable().cellEdit2(stable);
		nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		new General().msgsearch(sjsp, stable, "Select Data ", 1000, 300);
	}

	public void getCloseAdvdncn(String vparty, String vdoctype, String vcat) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call  Adv_getOpenAdvDetails(" + vcomp + ", " + vstore + ", " + vparty + ", '" + vdoctype + "' ,'"
				+ vcat + "')";
		smodel.setColumnIdentifiers(SCol);
		String type = "Advcndn";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 9, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		DefaultCellEditor nk = new gnTable().cellEdit2(stable);
		nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		new General().msgsearch(sjsp, stable, "Select Data ", 1000, 300);
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

		case "Advcndn":
			rpartycode = (stable.getValueAt(row, 1).toString());
			rpartynameName = (stable.getValueAt(row, 2).toString());
			rdoctype = (stable.getValueAt(row, 4).toString());
			rdoc_category = (stable.getValueAt(row, 5).toString());
			rdocno = (stable.getValueAt(row, 6).toString());
			ramount = (stable.getValueAt(row, 8).toString());
			rconsumenamt = (stable.getValueAt(row, 9).toString());
			rdocdate = (stable.getValueAt(row, 7).toString());
			break;
		}
	}

	public void updateadvstatus(String advdate, String invdate, String advno, String vcat) throws Throwable {
		// new General().msg("Reached"+""+advdate+ " "+invdate+" "+advno+ "
		// "+vcat);
		try {
			int advmon = Integer.parseInt(new gnGST().getmonth(advdate));
			int curmon = Integer.parseInt(new gnGST().getmonth(invdate));
			String vinvdate = new gnConfig().date_ConverttoDBforamt(invdate);
			String vcomp = new gnConfig().getCompanyCode();
			String vstore = new gnConfig().getStoreID();
			String vdocno = advno;
			String vdoctype = "AD";
			String updatewhat = " ";
			if ((advmon - curmon == 0)) {
				updatewhat = "C";
				SQL = "call  custAdv_updateCurrentStatus(" + vcomp + " , " + vstore + "  , " + vdocno + " , '"
						+ vdoctype + "', '" + vcat + "' , '" + updatewhat + "'  ,'" + vinvdate + "')";
				this.getResult(SQL);
				rs.close();
				this.closeconn();
				// new General().msg( SQL);
			} else {
				updatewhat = "N";
				SQL = "call  custAdv_updateCurrentStatus(" + vcomp + " , " + vstore + "  , " + vdocno + " , '"
						+ vdoctype + "', '" + vcat + "', '" + updatewhat + "' ,'" + vinvdate + "')";
				this.getResult(SQL);
				rs.close();
				this.closeconn();
 			}
		} catch (Exception e) {
			new General().msg(e.getMessage() + "" + SQL);
 		}
	}

}// last

//

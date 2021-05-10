package RetailProduct;

import javax.swing.DefaultCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnToTi {

	public static String rsitecode = " ";
	public static String rName = " ";

	public static String rSendingBranch;
	public static String rtono;
	public static String rtodate;
	public static String rsendingbrname;
	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	String SCol[] = { "Type ", "Brancj  Code", "Name", };

	public JScrollPane sjsp = new JScrollPane();

	public void getTo() throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "Call  to_getTOdetail(" + vcomp + " , " + vstore + ")";
		String type = "TO";
		String toCol[] = { "Type", "FromBranch", "Name", "TO.NO", "TODate", "Value", "TI-NO", "TI-DATE" };
		smodel.setColumnIdentifiers(SCol);
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, toCol, 8, "N", "N", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		DefaultCellEditor nk = new gnTable().cellEdit2(stable);
		nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, toCol);
		sjsp.setViewport(prt6);
		new General().msgsearch(sjsp, stable, "Select Data ", 700, 500);
	}

	public void getsite(String sname) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "Call  Tb_getallSite(" + vcomp + ")";
		String type = "Site";
		smodel.setColumnIdentifiers(SCol);
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 2, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		DefaultCellEditor nk = new gnTable().cellEdit2(stable);
		nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		new General().msgsearch(sjsp, stable, "Select Data ", 700, 500);
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

		case "Site":
			rsitecode = (stable.getValueAt(row, 1).toString());
			rName = (stable.getValueAt(row, 2).toString());
			new gnTable().RemoveTableRows(smodel);
			break;

		case "TO":
			rSendingBranch = (stable.getValueAt(row, 1).toString());
			rtono = (stable.getValueAt(row, 3).toString());
			rsendingbrname = (stable.getValueAt(row, 2).toString());
			rtodate = (stable.getValueAt(row, 4).toString());
			new gnTable().RemoveTableRows(smodel);
			break;

		}
	}

}// last

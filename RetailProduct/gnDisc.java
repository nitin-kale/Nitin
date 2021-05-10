package RetailProduct;

import javax.swing.DefaultCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnDisc {

	public static String rdisc = " ";

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	String SCol[] = { "Type ", "Disc Description", "Article", "Disc%" };

	public JScrollPane sjsp = new JScrollPane();

	public void getDiscountInfo(String varticle) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "call  disc_getArticledisc(  " + vcomp + " ,  " + varticle + ")";
		smodel.setColumnIdentifiers(SCol);
		String type = "Disc";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 3, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		DefaultCellEditor nk = new gnTable().cellEdit2(stable);
		nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		new General().msgsearch(sjsp, stable, "Select Discount % ", 700, 500);
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
		case "Disc":
			rdisc = (stable.getValueAt(row, 3).toString());
			// new General().msg("disc%"+""+rdisc);
			break;
		}
		new gnTable().RemoveTableRows(smodel);
	}

}// last

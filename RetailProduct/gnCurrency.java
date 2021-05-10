package RetailProduct;

import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnCurrency extends getResultSet {

	public static String rcurcode = " ";
	public static String rcurName = " ";

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	String SCol[] = { "Type ", "Currencye", "Name" };

	public JScrollPane sjsp = new JScrollPane();

	public String getRate(String vbase, String vothcur) throws ClassNotFoundException, SQLException {
		String vrate = "";
		String SQL = "Call currency_getRate('" + vbase + "', '" + vothcur + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vrate = rs.getString(1);

		}
		rs.close();
		this.closeconn();
		return vrate;
	}

	public String getunit(String vbase, String vothcur) throws ClassNotFoundException, SQLException {
		String vunit = "";
		String SQL = "Call currency_getRate('" + vbase + "', '" + vothcur + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vunit = rs.getString(2);

		}
		rs.close();
		this.closeconn();
		return vunit;
	}

	public void getCurrency() throws Throwable {

		String vcomp = new gnConfig().getCompanyCode();
		String type = "Currency";
		String SQL = "Call master_getMasterData('" + type + "')";
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

		case "Currency":

			rcurcode = (stable.getValueAt(row, 1).toString());
			rcurName = (stable.getValueAt(row, 2).toString());
			new gnTable().RemoveTableRows(smodel);
			break;
		}
	}

}// last

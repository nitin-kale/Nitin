package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class gnAccountSearch {

	public static String vcode;
	public static String vname;

	public static String vopbal;
	public static String vopdrcr;

	public static String vclbal;
	public static String vcldrcr;

	private String col[] = { "Type", "Code", "Name", "Op.Bal", "Drcr", "Curr.Bal", "Drcr" };

	public DefaultTableModel model = new DefaultTableModel();
	public JTable table = new JTable();
	public JScrollPane jsp = new JScrollPane();

	public void showAccountSearchFor(String vname, String vtype) throws Throwable {
		model.setColumnIdentifiers(col);
		new gnTable().RemoveTableRows(model);
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "Call   Account_getSEarchDetails( '" + vtype + "' , " + vcomp + "," + vcomp + " ,'" + vname
				+ "'  , '" + vfinyear + "')";
		table = new gnTableModel().Tablemodel(table, model, SQL, col, 6, "N", "Y", vtype);
		JViewport prt6 = new JViewport();
		jsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(table, col);
		jsp.setViewport(prt6);
		table.requestFocus();
		Selectrow();
	}

	public void Selectrow() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {
					dispalyinfo(value, row);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
		table.requestDefaultFocus();
		new General().msgsearch(jsp, table, "Select Data ", 950, 300);
	}

	private void dispalyinfo(String value, int row) {

		vcode = table.getValueAt(row, 1).toString();
		vname = table.getValueAt(row, 2).toString();
		vopbal = table.getValueAt(row, 3).toString();
		vopdrcr = table.getValueAt(row, 4).toString();
		vclbal = table.getValueAt(row, 5).toString();
		vcldrcr = table.getValueAt(row, 6).toString();

	}

}

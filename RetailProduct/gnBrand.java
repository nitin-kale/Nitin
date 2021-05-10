package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnBrand {

	private JTextField brandcode;
	private JTextField Name;
	private JTextField manuf;
	private JTextField verticle;
	private JTextField verticlename;

	public static String rbrandcode = " ";
	public static String rName = " ";
	public static String rmanuf = " ";
	public static String rverticle = " ";
	public static String rverticlename = " ";

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	String SCol[] = { "Type ", "BrandCode", "Name", "Manuf", "verticle", "Verticle Name" };

	public JScrollPane sjsp = new JScrollPane();

	public void NogetBrandInfo(String sname) throws Throwable {
		String vverticle1 = new gnHierarchy().getVerticleCode();
		String SQL = "call  ms_getonlyBrand('" + sname + "' , " + vverticle1 + ")";
		smodel.setColumnIdentifiers(SCol);
		String type = "Brand";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 5, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 2, 300);
		// DefaultCellEditor nk = new gnTable().cellEdit2(stable) ;
		// nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
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
					dispalyinfo(value, row);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Data ", 950, 300);

	}

	private void dispalyinfo(String value, int row) throws Throwable {
		switch (value) {

		case "Brand":
			rbrandcode = (stable.getValueAt(row, 1).toString());
			rName = (stable.getValueAt(row, 2).toString());
			rmanuf = (stable.getValueAt(row, 3).toString());
			rverticle = (stable.getValueAt(row, 4).toString());
			rverticlename = (stable.getValueAt(row, 5).toString());
			// new General().msg(rbrandcode);
			new gnTable().RemoveTableRows(smodel);
			break;
		}
	}

}// last

package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class gnDoctor {

	public static String vvdoccode;
	public static String vvdocname;
	public static String vphone;
	public static String vcitycode;
	public static String vcityname;
	public static String vdegree;
	public static String vaddr1;
	public static String vaddr2;
	public static String vaddr3;
	public static String vmobile1;
	public static String vmobile2;
	public static String vhospitalname;
	public static String vcomp;
	public String vstore;
	public JTable table = new JTable();
	public DefaultTableModel vmodel = new DefaultTableModel();
	public JScrollPane sjsp = new JScrollPane();

	public void getDocname(String vstring) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		new gnTable().RemoveTableRows(vmodel);
		String vtype = "Doctor";
		String SQL = "call  medical_getDocDetails('" + vstring + "' , " + vcomp + ",  " + vstore + ")";
		// new General().msg(SQL);
		String ACol[] = { "Type", "Doc", "Name", "City", "CityName", "Phone", "Degree", "Hos.Name", "Addr1", "Addr2",
				"Addr3", "Mobile1", "Mobile2" };
		table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 12, "N", "Y", vtype);
		if (table.getRowCount() > 0) {
			table.setEnabled(true);
			new gnTable().setTableColWidth(table, 2, 250);
			selectOption();
		}

	}

	public void selectOption() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {
					display(row, value);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				// new General().msgDispose();
			}
		});
		new gnTable().setTableColWidth(table, 1, 250);
		new General().msgsearch(sjsp, table, "Select Data ", 800, 300);
	}

	private void display(int row, String value) {
		vvdoccode = (String) table.getValueAt(row, 1);
		vvdocname = (String) table.getValueAt(row, 2);
		vcitycode = (String) table.getValueAt(row, 3);
		vcityname = (String) table.getValueAt(row, 4);
		vphone = (String) table.getValueAt(row, 5);
		vdegree = (String) table.getValueAt(row, 6);
		vhospitalname = (String) table.getValueAt(row, 7);
		vaddr1 = (String) table.getValueAt(row, 8);
		vaddr2 = (String) table.getValueAt(row, 9);
		vaddr3 = (String) table.getValueAt(row, 10);
		vmobile1 = (String) table.getValueAt(row, 11);
		vmobile2 = (String) table.getValueAt(row, 12);
		new General().msgDispose();
	}

}// Last

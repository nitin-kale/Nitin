package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

public class gnPatient {

	public static String vpatientcode;
	public static String vpatientname;
	public static String vphone;
	public static String vward;
	public static String vbuilding;
	public static String vroomno;
	public static String vbedno;
	public static String vdoccode;
	public static String vdocname;

	public static String vcomp;
	public String vstore;
	public JTable table = new JTable();
	public DefaultTableModel vmodel = new DefaultTableModel();
	public JScrollPane sjsp = new JScrollPane();

	public void getPatientname(String vstring) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		new gnTable().RemoveTableRows(vmodel);
		String vtype = "Patient";
		String SQL = "call medical_getPateintDetails('" + vstring + "' , " + vcomp + ",  " + vstore + ")";
		// new General().msg(SQL);
		String ACol[] = { "Type", "Patient", "Name", "Phone", "Doc", "Doctorname", "Building", "Ward", "Room", "Bed" };
		table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 9, "N", "Y", vtype);
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
		vpatientcode = (String) table.getValueAt(row, 1);
		vpatientname = (String) table.getValueAt(row, 2);
		vphone = (String) table.getValueAt(row, 3);
		// {"Type", "Patient" , "Name" , "Phone", "Doc" ,
		// "Doctorname","Building" , "Ward" , "Room" , "Bed"};
		vdoccode = (String) table.getValueAt(row, 4);
		vdocname = (String) table.getValueAt(row, 5);
		vbuilding = (String) table.getValueAt(row, 6);
		vward = (String) table.getValueAt(row, 7);
		vroomno = (String) table.getValueAt(row, 8);
		vbedno = (String) table.getValueAt(row, 9);
		new General().msgDispose();
	}

}// Last

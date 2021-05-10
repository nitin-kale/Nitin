package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnBank {

	public static String rbankcode;
	public static String rbankname;

	public static String raccountno;
	public static String ropbal;
	public static String rclbal;
	public static String rcity;

	public static String rpaymentmode;
	public static String rinstrumentno;
	public static String rinstrumentDate;

	private String type = "BANK";
	private String vcomp;
	private String vstore;
	private String vfinyear;
	private String SQL;

	private String bankCol[] = { "Type", "GL Code", "Name", "Op.Bal", "Drcr", "Curr.Bal", "DrcrType" };

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public JScrollPane sjsp = new JScrollPane();

	public void getbankDetail(String vtype, String vname) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		vtype = vtype.toUpperCase();
		switch (vtype) {
		case "BANK":
			String vgroup = "12";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "'  , '"
					+ vname + "')";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 6, "N", "Y", vtype);
			new gnTable().setTableColWidth(stable, 2, 300);
			break;
		}

		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, bankCol);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select Bank <Click on row to
		// select Record>", 700, 200);
		Selectrow();
	}

	public void Selectrow() {
		stable.requestFocus();
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

	private void dispalyinfo(String value, int row) throws Throwable {
		switch (value) {
		case "BANK":
			rbankcode = stable.getValueAt(row, 1).toString();
			rbankname = stable.getValueAt(row, 2).toString();
			raccountno = stable.getValueAt(row, 4).toString();
			// ropbal = stable.getValueAt(row, 1).toString() ;
			rclbal = stable.getValueAt(row, 5).toString();
			rcity = stable.getValueAt(row, 3).toString();
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}// last

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

public class gnBillUnhold {

	public static String vcustomer;
	public static String vtokeanno;
	public static String vcustcode;
	public static String vphone;
	public static String vemail;
	public static String vamount;
	public static String vinvno;

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	String SCol[] = { "Type ", "Custode", "Name", "Amount", "Tel", "Email", "Token", "Invno" };

	public JScrollPane sjsp = new JScrollPane();

	
	public void getHoldBill() throws Throwable {

		new General().Quickmsg("Select Token No To Get Bill Data On Screen..");
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call  resto_getHoldBills(" + vcomp + " , " + vstore + ")";
		// new General().msg(SQL) ;
		smodel.setColumnIdentifiers(SCol);
		stable.setModel(smodel);
		String type = "Unhold";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 6, "N", "Y", type);
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
					dispalyinfo(value, row); // showCustData();
					new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		stable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, stable, "Select Data ", 700, 300);
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

		case "Unhold":
			vcustomer = (stable.getValueAt(row, 2).toString());
			vcustcode = (stable.getValueAt(row, 1).toString());
			vamount = (stable.getValueAt(row, 3).toString());
			vphone = (stable.getValueAt(row, 4).toString());
			vemail = (stable.getValueAt(row, 5).toString());
			vtokeanno = (stable.getValueAt(row, 6).toString());
			// vinvno = (stable.getValueAt(row,7).toString());
			new gnTable().RemoveTableRows(smodel);
			break;
		}
	}

}// last

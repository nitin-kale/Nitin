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

public class gnFarmer {

	public static String rfarmercode;
	public static String rfarmername;
	public static String rphoneno;
	public static String radharno;
	public static String rcitycode;
	public static String rcityname;
	public static String rtalukacode;
	public static String rtalukaname;
	public static String rdistcode;
	public static String rdistname;
	public static String rtotalLand;

	private String type = "Farmer";
	private String vcomp;
	private String vstore;
	private String vfinyear;
	private String SQL;

	private String farmCol[] = { "Type", "Code", "Name", "Phone", "AdharCardno", "City", "CityName ", "Taluka",
			"TalukaName", "Dist", "District Name", "Total Land" };

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public JScrollPane sjsp = new JScrollPane();

	public void getFarmerDetail(String vtype, String vname) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		vtype = vtype.toUpperCase();
		switch (vtype) {
		case "FARMER":
			SQL = "call  Farm_getfarmerHelp  (" + vcomp + " , " + vstore + " ,   '" + vname + "')";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, farmCol, 11, "N", "Y", vtype);
			new gnTable().setTableColWidth(stable, 2, 300);
			break;
		}

		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Farmer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, farmCol);
		sjsp.setViewport(prt6);
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
		case "FARMER":

			// private String farmCol[] = {"Type" , "Code", "Name", "Phone" ,
			// "AdharCardno" , "City" , "CityName " , "Taluka" , "TalukaName",
			// "Dist", "District Name" , "Total Land" } ;

			rfarmercode = stable.getValueAt(row, 1).toString();
			rfarmername = stable.getValueAt(row, 2).toString();
			rphoneno = stable.getValueAt(row, 3).toString();
			radharno = stable.getValueAt(row, 4).toString();
			rcitycode = stable.getValueAt(row, 5).toString();
			rcityname = stable.getValueAt(row, 6).toString();
			rtalukacode = stable.getValueAt(row, 7).toString();
			rtalukaname = stable.getValueAt(row, 8).toString();
			rdistcode = stable.getValueAt(row, 9).toString();
			rdistname = stable.getValueAt(row, 10).toString();

			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}// last

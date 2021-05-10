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

public class gnAccountGetGLofGivenGroup {

	public static String vcode;
	public static String vname;

	public static String vopbal;
	public static String vopdrcr;

	public static String vclbal;
	public static String vcldrcr;
	public static String vtaxcode;

	private String type = "BANK";
	private String vcomp;
	private String vstore;
	private String vfinyear;
	private String SQL;

	private String bankCol[] = { "Type", "Code", "Name", "Op.Bal", "DrCr", "Curr.Bal", "Drcr", "Acc.GrpCode",
			"Acc.Group", "Taxcode" };

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public JScrollPane sjsp = new JScrollPane();

	
	
	public void getAllGLofGroup(String vtype, String vname) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		vtype = vtype.toUpperCase();
		String vgroup = "";
		switch (vtype) {
		case "CASH":
			vgroup = "12";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "' , '"
					+ vname + "' )";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "BANK":
			vgroup = "12";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "' , '"
					+ vname + "' )";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "SUPPLIER":
			vgroup = "8";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "' , '"
					+ vname + "' )";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "CUSTOMER":
			vgroup = "20";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "' , '"
					+ vname + "' )";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "EXPENSES":
			vgroup = "12";
			SQL = "call  account_getGlForMultiGRoup('" + vtype + "', " + vcomp + " , " + vstore + " , '" + vfinyear
					+ "' , '" + vname + "' )";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "INCOME":
			vgroup = "12";
			SQL = "call  account_getGlForMultiGRoup('" + vtype + "', " + vcomp + " , " + vstore + " , '" + vfinyear
					+ "' , '" + vname + "' )";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "CAPITAL":
			vgroup = "12";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "' , '"
					+ vname + "' )";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;

		case "ASSET":
			vgroup = "11";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "' , '"
					+ vname + "' )";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;

		case "PV":
			vgroup = "12";
			SQL = "call  account_getGlForMultiGRoup('" + vtype + "', " + vcomp + " , " + vstore + " , '" + vfinyear
					+ "' , '" + vname + "' )";
			/// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "RV":
			vgroup = "12";
			SQL = "call  account_getGlForMultiGRoup('" + vtype + "', " + vcomp + " , " + vstore + " , '" + vfinyear
					+ "' , '" + vname + "' )";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		}
		new gnTable().setTableColWidth(stable, 2, 300);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, bankCol);
		sjsp.setViewport(prt6);
		Selectrow();
	}


	
	
	public JTable  getAllGLofGroupinTable(String vtype, String vname) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		vtype = vtype.toUpperCase();
		String vgroup = "";
		switch (vtype) {
		case "CASH":
			vgroup = "12";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "' , '"
					+ vname + "' )";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "BANK":
			vgroup = "12";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "' , '"
					+ vname + "' )";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "SUPPLIER":
			vgroup = "8";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "' , '"
					+ vname + "' )";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "CUSTOMER":
			vgroup = "20";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "' , '"
					+ vname + "' )";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "EXPENSES":
			vgroup = "12";
			SQL = "call  account_getGlForMultiGRoup('" + vtype + "', " + vcomp + " , " + vstore + " , '" + vfinyear
					+ "' , '" + vname + "' )";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "INCOME":
			vgroup = "12";
			SQL = "call  account_getGlForMultiGRoup('" + vtype + "', " + vcomp + " , " + vstore + " , '" + vfinyear
					+ "' , '" + vname + "' )";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "CAPITAL":
			vgroup = "12";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "' , '"
					+ vname + "' )";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;

		case "ASSET":
			vgroup = "11";
			SQL = "call  account_getGlHelp(" + vgroup + ", " + vcomp + " , " + vstore + " , '" + vfinyear + "' , '"
					+ vname + "' )";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;

		case "PV":
			vgroup = "12";
			SQL = "call  account_getGlForMultiGRoup('" + vtype + "', " + vcomp + " , " + vstore + " , '" + vfinyear
					+ "' , '" + vname + "' )";
			/// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		case "RV":
			vgroup = "12";
			SQL = "call  account_getGlForMultiGRoup('" + vtype + "', " + vcomp + " , " + vstore + " , '" + vfinyear
					+ "' , '" + vname + "' )";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, bankCol, 9, "N", "Y", vtype);
			break;
		}
		new gnTable().setTableColWidth(stable, 2, 300);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, bankCol);
		sjsp.setViewport(prt6);
 		return stable ;
		
		//Selectrow();
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

		vcode = stable.getValueAt(row, 1).toString();
		vname = stable.getValueAt(row, 2).toString();
		vopbal = stable.getValueAt(row, 3).toString();
		vopdrcr = stable.getValueAt(row, 4).toString();
		vclbal = stable.getValueAt(row, 5).toString();
		vcldrcr = stable.getValueAt(row, 6).toString();
		vtaxcode = stable.getValueAt(row, 9).toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}// last

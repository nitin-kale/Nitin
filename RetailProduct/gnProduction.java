package RetailProduct;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnProduction extends getResultSet {

	public String vuser;
	public String sql;
	public String type;
	public String vcomp;
	public JTable vtable = new JTable();
	public DefaultTableModel vmodel = new DefaultTableModel();
	public JScrollPane sjsp = new JScrollPane();
	public JTextField vcompcode;
	public JTextField vcompname;

	public static String rarticle_code;
	public static String rarticle_name;
	private String SQL;

	
	
	
	
	public void getItemDetail(String sname, String varticleType) throws Throwable {
		new gnTable().RemoveTableRows(vmodel);
		vcomp = new gnConfig().getCompanyCode();
		String vtype = "Article";
		SQL = "call  production_getsearchItem(" + vcomp + " , " + varticleType + " , '" + sname + "')";
		// new General().msg(SQL);
		String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Trading Article",
				"Article Type" };
		vtable = new gnTableModel().Tablemodel(vtable, vmodel, SQL, ACol, 8, "N", "Y", vtype);
		vtable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification101);
		vtable.setEnabled(true);
		JViewport prt11 = new JViewport();
		prt11.add(vtable, ACol);
		prt11.setVisible(true);
		sjsp.setViewport(prt11);
		new General().msgsearch(sjsp, vtable, "Select Article", 800, 500);
	}

	public CellEditorListener ChangeNotification101 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = vtable.getSelectedRow();
			String value = (String) vtable.getValueAt(row, 0);
			try {
				rarticle_code = vtable.getValueAt(row, 1).toString();
				rarticle_name = vtable.getValueAt(row, 2).toString();
				new General().msgDispose();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
			new General().msgDispose();
		}
	};

	public static void main(String[] args) {

		
	}

}

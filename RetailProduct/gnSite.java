package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class gnSite extends getResultSet {

	public static String format = "";
	public static String formatname;
	private String vcomp;
	private String vstore;
	private String value;
	public JTextField code;
	public JTextField name;
	String vuser;
	public JTable vtable = new JTable();
	public DefaultTableModel vmodel = new DefaultTableModel();
	public JScrollPane sjsp = new JScrollPane();

	private void getDefault() throws Throwable {
		vcomp = this.compcode;
		vstore = this.storecode;

	}

	public void Site_getFormat() throws Throwable {
		format = this.format;
	}

	public void showSite(String Name, JTextField vcode, JTextField vname) throws Throwable {
		code = vcode;
		name = vname;
		vcomp = new gnConfig().getCompanyCode();
		sjsp.setBounds(0, 0, 1184, 425);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		vuser = new gnConfig().getUserCode().toUpperCase();
		new gnTable().RemoveTableRows(vmodel);
		String Col[] = { " Type ", "Code ", "Description" };
		String SQL = "Call  Tb_getallSite(" + vcomp + ")";
		vmodel.setColumnIdentifiers(Col);
		new gnTable().RemoveTableRows(vmodel);
		vtable = new gnTableModel().Tablemodel(vtable, vmodel, SQL, Col, 2, "N", "Y", Name);
		// DefaultCellEditor nk = new gnTable().cellEdit(vtable) ;
		// nk.addCellEditorListener(ChangeNotification101);
		JViewport prt11 = new JViewport();
		prt11.add(vtable, Col);
		prt11.setVisible(true);
		sjsp.setViewport(prt11);
		// new General().msgsearch(sjsp,vtable , "Select Data For "+ Name,
		// 400,400);
		SelectMasterRow();
	}

	public void SelectMasterRow() {
		vtable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		vtable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {

				int row = vtable.getSelectedRow();
				String value = (String) vtable.getValueAt(row, 0);
				try {
					code.setText(vtable.getValueAt(row, 1).toString());
					name.setText(vtable.getValueAt(row, 2).toString());
					new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		vtable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, vtable, "Select Data ", 700, 500);

	}

}

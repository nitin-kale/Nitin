package RetailProduct;

import javax.swing.DefaultCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnArticleContent extends getResultSet {

	public static String rcontent = " ";
	public static String rarticle_code = " ";
	public static String rarticle_name = " ";
	public static String rarticle_batchArticle = " ";

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	String SCol[] = { "Type ", "Content", "Article", "Name", "UOM", "MRP", "Sales Price", "Cost", "Margin",
			"Bal.Stock" };

	public JScrollPane sjsp = new JScrollPane();

	public String CheckBatchArticle(String varticle) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vbatchArticle = "";
		String SQL = "call  article_checkBatchArticle( " + vcomp + " , " + varticle + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vbatchArticle = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return vbatchArticle;
	}

	public String getArticleContent(String varticle) throws Throwable {
		String vcontent = " ";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "call  cont_GetArticleContent(" + vcomp + ", " + varticle + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vcontent = rs.getString(1);
		} else {
			new General().msg("No Content Updated ...");
		}
		rs.close();
		this.closeconn();
		return vcontent;
	}

	public void getItemsofContent(String vcontent) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String SQL = "call  cont_getContentItems(" + vcomp + ", " + vstore + " , '" + vcontent + "')";
		smodel.setColumnIdentifiers(SCol);
		String type = "Content";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 9, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 3, 300);
		DefaultCellEditor nk = new gnTable().cellEdit2(stable);
		nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("my Paneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		new General().msgsearch(sjsp, stable, "Select Data ", 700, 500);
	}

	public void getContent(String varticle) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vcontent = " ";
		vcontent = getArticleContent(varticle);
		String SQL = "call  cont_getContentItems(" + vcomp + ", " + vstore + " , '" + vcontent + "')";
		smodel.setColumnIdentifiers(SCol);
		String type = "Content";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 9, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 3, 300);
		DefaultCellEditor nk = new gnTable().cellEdit2(stable);
		nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("my Paneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		new General().msgsearch(sjsp, stable, "Item Content Data ", 700, 500);
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

		case "Content":
			rcontent = (stable.getValueAt(row, 1).toString());
			rarticle_code = (stable.getValueAt(row, 2).toString());
			rarticle_name = (stable.getValueAt(row, 3).toString());
			new gnTable().RemoveTableRows(smodel);
			break;
		}
	}

}// last

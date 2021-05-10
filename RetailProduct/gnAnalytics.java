package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class gnAnalytics extends getResultSet {

	JTable atable = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 1 || column == 2 || column == 3 || column == 4 || column == 5 || column == 6 || column == 7
					|| column == 8 || column == 9) {
				componentt.setBackground(Color.cyan);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
			} else {
				componentt.setBackground(new Color(100, 51, 153));// .LIGHT_GRAY);
				componentt.setForeground(new Color(204, 255, 153));

				// componentt.setBackground(Color.magenta);
				// componentt.setForeground(Color.WHITE);
			}
			return componentt;
		}
	};

	JTable atable2 = new JTable();
	JTable atable1 = new JTable();
	JTable atable3 = new JTable();

	DefaultTableModel amodel = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 ? true : false;
		}
	};

	JScrollPane jsp;

	// String ACol[] = { "Transaction" , "From Date" , "TO Date" , "Article" ,
	// "Name", "Qty", "Cost Value", "Sales Value" ,"Margin%" , "RGM" , "Title" ,
	// "Title Name" } ;
	String ACol[] = { "Transaction", "From Date", "TO Date", "Article", "Name", "Qty", "Cost Value", "Sales Value",
			"Margin%", "RGM" };

	private String vcomp;
	private String vstore;
	private String vdate;
	private String Wstartdate;
	private String Mstartdate;
	private String Qstartdate;
	private String Hstartdate;
	private String Ystartdate;
	private String SQL;
	private String type;
	private String transactionType;
	public String xvarticle;
	public String xvendor;

	private void getStandard() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdate = new General().getDate();
		// vdate = "2017.01.01";

		Wstartdate = new gnConfig().date_ConverttoDBforamt(new gnConfig().calculateManufDate(vdate, 7));
		Mstartdate = new gnConfig().date_ConverttoDBforamt(new gnConfig().calculateManufDate(vdate, 30));
		Qstartdate = new gnConfig().date_ConverttoDBforamt(new gnConfig().calculateManufDate(vdate, 90));
		Hstartdate = new gnConfig().date_ConverttoDBforamt(new gnConfig().calculateManufDate(vdate, 180));
		Ystartdate = new gnConfig().date_ConverttoDBforamt(new gnConfig().calculateManufDate(vdate, 360));
	}

	public void gnAnalytics() {
		jsp = new JScrollPane();
		jsp.setBounds(0, 0, 1345, 431);
		atable = new JTable();
		atable.setEnabled(true);

	}

	public void getAnalytics(String varticle, String varticlename, String vendor) throws Throwable {
		xvarticle = varticle;
		xvendor = vendor;
		Vendor_Article_Purchase(varticle, vendor);
	}

	public void Vendor_Article_Purchase(String varticle, String vendor) throws Throwable {
		// new General().msg("Main Method Called");
		getStandard();
		type = "Yearly Total Item Purchase";
		analy_getArticlePurchase(varticle, Ystartdate, vdate, type);

		/// Vendor Purchase
		type = "Yearly Purchase From Vendor ";
		analy_getVendorItemPurchase(vendor, Ystartdate, vdate, type, varticle);

		new gnTable().setTableColWidth(atable, 0, 200);
		new gnTable().setTableColWidth(atable, 4, 200);
		atable.setCellSelectionEnabled(false);
		atable.setRowSelectionAllowed(true);
		atable.setGridColor(Color.gray);
		atable.setRowHeight(27);

	}

	public void analy_getArticlePurchase(String varticle, String Wstartdate, String endDate, String vtype)
			throws ClassNotFoundException, SQLException {
		// new General().msg("get Article Purchase Method Called");
		endDate = new gnConfig().date_ConverttoDBforamt(endDate);
		SQL = "call  analy_get_ItemPurchase(" + vcomp + ", " + vstore + ",  '" + Wstartdate + "' , '" + endDate + "' ,"
				+ varticle + ")";
		// new General().msg(SQL);
		transactionType = vtype;
		atable = new gnTableModel().Tablemodel(atable, amodel, SQL, ACol, 9, "N", "Y", transactionType);
	}

	public void analy_getVendorItemPurchase(String vendor, String Wstartdate, String endDate, String vtype,
			String varticle) throws Throwable {

		// new General().msg("get Vendor Article Purchase Method Called");

		endDate = new gnConfig().date_ConverttoDBforamt(endDate);
		SQL = "call  analy_get_VendorItemPurchase(" + vcomp + ", " + vstore + ",  '" + Wstartdate + "' , '" + endDate
				+ "', " + varticle + ",  '" + vendor + "')";
		// new General().msg(SQL);
		transactionType = vtype;
		atable = new gnTableModel().Tablemodel(atable, amodel, SQL, ACol, 9, "N", "Y", transactionType);
		// showData();
		selectData();
	}

	private void showData() throws IOException {
		String vmessage = "";
		int row = atable.getRowCount();
		for (int i = 0; i < row; i++) {

			vmessage = "FromDate" + " " + atable.getValueAt(i, 1)
					+ "                                                                                                "
					+ "ToDate" + " " + atable.getValueAt(i, 2)
					+ "                                                                                                                       "
					+ "ArticleCode" + " " + atable.getValueAt(i, 3)
					+ "                                                                                                "
					+ "Name" + " " + atable.getValueAt(i, 4)
					+ "                                                                                                        "
					+ "Qty" + " " + atable.getValueAt(i, 5)
					+ "                                                                                                            "
					+ "NetSales" + " " + atable.getValueAt(i, 6)
					+ "                                                                                                    "
					+ "SalesPrice" + " " + atable.getValueAt(i, 7) + "";
			new showHelp().showHelp(vmessage, "Purchase Trend");
		}
	}

	public void selectData() {
		int row1 = atable.getRowCount();
		atable.setRequestFocusEnabled(true);
		new General().msg("Table Row Count is" + " " + row1);
		atable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		atable.getActionMap().put("enter", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int row = atable.getSelectedRow();
				String value = (String) atable.getValueAt(row, 0);
				try {
					ProcessRequest(value, row);
				} catch (Throwable e) {
					e.printStackTrace();
				}
				// new General().msgDispose();
			}
		});
		JScrollPane jsp = new JScrollPane();
		new General().msgsearch(jsp, atable, "View Purchase Data Anlytics For  Article" + " " + xvarticle, 1000, 300);
	}

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			e.notifyAll();
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = atable.getSelectedRow();
			String value = (String) atable.getValueAt(row, 0);
			try {
				ProcessRequest(value, row);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	};

	public void ProcessRequest(String value, int row) throws Throwable {
		switch (value) {
		case "Yearly Total Item Purchase":
			showItemPurchasePeriodBreakup(xvarticle);
			new General().msgDispose();
			break;
		case "Yearly Purchase From Vendor ":
			showIVendorPurchasePeriodBreakup(xvarticle, xvendor);
			new General().msgDispose();
			break;
		}
	}

	public void showItemPurchasePeriodBreakup(String varticle) throws Throwable {
		gnAnalytics();
		new General().msgDispose();
		new gnTable().RemoveTableRows(amodel);
		atable = analy_perioedBasedArticlePurchase(varticle);
		atable.setModel(amodel);
		new gnTable().setTableColWidth(atable, 0, 200);
		new gnTable().setTableColWidth(atable, 4, 200);
		JScrollPane jsp = new JScrollPane();
		new General().msgsearch(jsp, atable, "View Data Anlytics For  Article Purchase Breakup" + " " + varticle, 1000,
				300);
		atable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);

	}

	public void showIVendorPurchasePeriodBreakup(String xvarticle, String xvendor) throws Throwable {
		gnAnalytics();
		new gnTable().RemoveTableRows(amodel);
		atable = analy_periodBasedVendorArticlePurchase(xvarticle, xvendor);
		atable.setModel(amodel);
		new gnTable().setTableColWidth(atable, 0, 200);
		new gnTable().setTableColWidth(atable, 4, 200);
		JScrollPane jsp = new JScrollPane();
		new General().msgsearch(jsp, atable, "View Data Anlytics For  Vendor Purchase Breakup" + " " + xvarticle, 1000,
				300);
		atable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);

	}

	/// ==========Purchase =========================================

	/// Will call from outside if required//
	// Item Level //
	public JTable analy_perioedBasedArticlePurchase(String varticle) throws Throwable {
		getStandard();
		type = "Weekly Item Purchase ";
		analy_getArticlePurchase(varticle, Wstartdate, vdate, type);
		type = "Quarterly Item Purchase ";
		analy_getArticlePurchase(varticle, Qstartdate, vdate, type);
		type = "Half Yearly  Item Purchase ";
		analy_getArticlePurchase(varticle, Hstartdate, vdate, type);
		type = "Yearly Item Purchase ";
		analy_getArticlePurchase(varticle, Ystartdate, vdate, type);
		return atable;
	}

	// Vendor Purchase
	public JTable analy_periodBasedVendorArticlePurchase(String vendor, String varticle) throws Throwable {
		getStandard();
		type = "Weekly Vendor Purchase ";
		analy_getVendorItemPurchase(vendor, Wstartdate, vdate, type, varticle);
		type = "Quarterly Vendor Purchase ";
		analy_getVendorItemPurchase(vendor, Qstartdate, vdate, type, varticle);
		type = "Half Yearly  Vendor Purchase ";
		analy_getVendorItemPurchase(vendor, Hstartdate, vdate, type, varticle);
		type = "Yearly  Vendor Purchase ";
		analy_getVendorItemPurchase(vendor, Ystartdate, vdate, type, varticle);
		return atable;
	}
	/// Will call from outside if required//

	// =============Stock =====================

	public void analy_ArticleStock(String varticle) throws ClassNotFoundException, SQLException {
		analy_getStock(varticle, "All");
		analy_getStock(varticle, "SL");

	}

	public void analy_getStock(String varticle, String Location) throws ClassNotFoundException, SQLException {
		String locname = Location;
		switch (locname) {
		case "All":
			SQL = "call  analy_getAllLocationStock(" + vcomp + ", " + vstore + ", " + varticle + ")";
			transactionType = "Stock" + "-" + "All Locatgion";
			atable = new gnTableModel().Tablemodel(atable, amodel, SQL, ACol, 11, "N", "Y", transactionType);
			break;
		case "SL":
			SQL = "call  analy_getLocationStock(" + vcomp + ", " + vstore + ", " + varticle + ",  '" + locname + "')";
			transactionType = "Stock" + "-" + "locname";
			atable = new gnTableModel().Tablemodel(atable, amodel, SQL, ACol, 11, "N", "Y", transactionType);
			break;
		}
	}

}// last

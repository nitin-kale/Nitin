package RetailProduct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnGetBatch {

	JPanel panel;
	private JTable table;
	public static JFrame frame;

	private String vcomp;
	private String vstore;
	public static String manuf_date;
	public static String expiry_date;
	public static String bal_qty;
	public static String batchno = "0";
	public static String cost;
	public static String mrp;
	public static String salesPrice;
	String vbatchv;
	private JTable stable = new JTable();
	private JScrollPane sjsp = new JScrollPane();
	public DefaultTableModel smodel = new DefaultTableModel();
	int vrw;

	public String getBatchDetail(String varticle, String vbatchcontrol, String vloc) throws Throwable {
		// new General().msgDispose();
		String status = "Sucess";
		String vstorecode = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		// String vloc = "SL" ;
		String batch[] = { "BatchArticle", "Item Code", "name", "cost", "SalesPrice", "Mrp", "Location", "Batchno",
				"Manuf_date", "Exp.Date", "Bal_Qty" };
		switch (vbatchcontrol) {
		case "Y":
			String SQL = "Call sv_getbatchprices(" + vstorecode + " ,    '" + varticle + "', " + vcomp + ", '" + vloc
					+ "'   , '" + vfinyear + "')";
			showSearch(SQL, batch);
			break;
		case "N":
			String SQL1 = "Call sv_getnonBatchprices(" + vstorecode + " ,   '" + varticle + "' , " + vcomp + ", '" + vloc
					+ "'  ,  '" + vfinyear + "')";
			//new General().msg(SQL1);
			showSearch(SQL1, batch);
			break;
		}
		return status;
	}// Method End

	public JTable getBatchDetailintable(String varticle, String vbatchcontrol, String vloc) throws Throwable {
		// new General().msgDispose();
		String status = "Sucess";
		String vstorecode = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vhead = "Batch";
		// String vloc = "SL" ;
		String batch[] = { "Type", "BatchArticle", "Item Code", "name", "cost", "SalesPrice", "Mrp", "Location",
				"Batchno", "Manuf_date", "Exp.Date", "Bal_Qty" };
		switch (vbatchcontrol) {
		case "Y":
			String SQL = "Call sv_getbatchprices(" + vstorecode + " ,    '" + varticle + "', " + vcomp + ", '" + vloc
					+ "'   , '" + vfinyear + "')";
			// new General().msg(SQL);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, batch, 11, "N", "Y", vhead);
			stable.setBackground(Color.BLACK);
			stable.setForeground(Color.white);
			// showSearch(SQL ,batch) ;
			break;
		case "N":
			vhead = "NoBatch";
			String SQL1 = "Call sv_getnonBatchprices(" + vstorecode + " ,   '" + varticle + "' , " + vcomp + ", '" + vloc
					+ "'  ,  '" + vfinyear + "')";
			// new General().msg(SQL1);
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL1, batch, 11, "N", "Y", vhead);
			stable.setBackground(Color.BLACK);
			stable.setForeground(Color.white);
			// showSearch(SQL1 ,batch) ;
			break;
		}
		if (stable.getRowCount() > 0) {
			new gnTable().setTablewidth(stable, 3, 300);
			new gnTable().setTablewidth(stable, 10, 150);
		}

		// if (stable.getRowCount() == 1)
		// {
		// new gnTable().RemoveTableRows(smodel);
		// }
 		return stable;
	}// Method End

	public JTable getBatchDetailForNonBathItemsInTable(String vtype, String varticle, String vbatchcontrol, String vloc)
			throws Throwable {
		// new General().msgDispose();
		String stattus = "Sucess";
		String vstorecode = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		// String vloc = "SL" ;
		String vhead = "Batch";
		String batch[] = { "Type", "BatchArticle", "Item Code", "name", "cost", "SalesPrice", "Mrp", "Location",
				"Batchno", "Manuf_date", "Exp.Date", "Bal_Qty" };
		switch (vbatchcontrol) {
		case "Y":
			String SQL = "Call sv_getbatchprices(" + vstorecode + " ,    " + varticle + ", " + vcomp + ", '" + vloc
					+ "'   , '" + vfinyear + "')";
			stable = new gnTableModel().Tablemodel(stable, smodel, SQL, batch, 11, "N", "Y", vhead);
			break;
		case "N":
			String vpara811 = "811";
			String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
					vstorecode);
			switch (vmaintainbatchforNonBatchItem) {
			case "N":
				String SQL1 = "Call sv_getnonBatchprices(" + vstorecode + " ,   " + varticle + " , " + vcomp + ", '"
						+ vloc + "'  ,  '" + vfinyear + "')";
				stable = new gnTableModel().Tablemodel(stable, smodel, SQL1, batch, 11, "N", "Y", vhead);
				break;

			case "Y":
				String SQL11 = "Call sv_getbatchpricesForNonBatchItem(  '" + vtype + "' ,  " + vstorecode + " ,   "
						+ varticle + " , " + vcomp + ", '" + vloc + "'  ,  '" + vfinyear + "')";
				// new General().msg(SQL11);
				// showSearch(SQL11 ,batch) ;
				stable = new gnTableModel().Tablemodel(stable, smodel, SQL11, batch, 11, "N", "Y", vhead);
				break;
			}
			break;
		}

		if (stable.getRowCount() > 0) {
			new gnTable().setTablewidth(stable, 3, 300);
			new gnTable().setTablewidth(stable, 10, 150);
		}

		return stable;
	}// Method End

	public String getBatchDetailForNonBathItems(String vtype, String varticle, String vbatchcontrol, String vloc)
			throws Throwable {
		// new General().msgDispose();
		String status = "Sucess";
		String vstorecode = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		// String vloc = "SL" ;
		String batch[] = { "BatchArticle", "Item Code", "name", "cost", "SalesPrice", "Mrp", "Location", "Batchno",
				"Manuf_date", "Exp.Date", "Bal_Qty" };
		switch (vbatchcontrol) {
		case "Y":
			String SQL = "Call sv_getbatchprices(" + vstorecode + " ,    " + varticle + ", " + vcomp + ", '" + vloc
					+ "'   , '" + vfinyear + "')";
			showSearch(SQL, batch);
			break;
		case "N":
			String vpara811 = "811";
			String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
					vstorecode);
			switch (vmaintainbatchforNonBatchItem) {
			case "N":
				String SQL1 = "Call sv_getnonBatchprices(" + vstorecode + " ,   " + varticle + " , " + vcomp + ", '"
						+ vloc + "'  ,  '" + vfinyear + "')";
				showSearch(SQL1, batch);
				break;
			case "Y":
				String SQL11 = "Call sv_getbatchpricesForNonBatchItem('" + vtype + "' ,  " + vstorecode + " ,   "
						+ varticle + " , " + vcomp + ", '" + vloc + "'  ,  '" + vfinyear + "')";
				// new General().msg(SQL11);
				// showSearch(SQL11 ,batch) ;
				showSearch(SQL11, batch);
				break;
			}
			break;
		}

		return status;
	}// Method End

	public void showSearch(String SQL, String[] Colnames) throws Throwable {
		resetValues();
		// new General().msg(SQL);
		new gnTable().RemoveTableRows(smodel);
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, Colnames, 11, "N", "N", "N");
		if (stable.getRowCount() > 0) {
			new gnTable().setTablewidth(stable, 2, 300);
			new gnTable().setTablewidth(stable, 1, 100);
		}
		Selectrow();
	}// End Search Table

	public void Selectrow() throws Throwable {
		String vstore = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		String vmaintainbatchforNonBatchItem = null;
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = stable.getSelectedRow();
				String vtype = (String) stable.getValueAt(row, 0);
				String varticle = (String) stable.getValueAt(row, 1);
				try {
					displayInfo(vtype, row);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				new General().msgDispose();
				// new General().msgDisposeNew();
			}
		});

		if (stable.getRowCount() > 0) {
			vbatchv = (String) stable.getValueAt(0, 0);
			vrw = stable.getRowCount();
			switch (vbatchv) {
			case "N":
				try {
					String vpara811 = "811"; // this Parameter for BAtch
												// Managment for Non BAtch Items
					vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
							vstore);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				switch (vmaintainbatchforNonBatchItem) {
				case "Y":
					new General().msgsearch(sjsp, stable, "Select  Sales Price  ", 900, 300);
					// msgsearchNew(sjsp, stable, "Select Sales Price " ,
					// 1100,400 );
					break;

				case "N":
					if (vrw > 1) {
						new General().msgsearch(sjsp, stable, "Select  Sales Price  ", 900, 300);
						// msgsearchNew(sjsp, stable, "Select Sales Price " ,
						// 1100,400 );
					}
					break;
				}
				break;
			case "Y":
				new General().msgsearch(sjsp, stable, "Select Batch ", 900, 300);
				// msgsearchNew(sjsp, stable, "Select Sales Price " , 1100,400
				// );
				break;
			}
		}
		new gnTable().setTableColWidth(stable, 1, 250);
	}

	// Megsearchnew from General
	public void msgsearchNew(JScrollPane jsp, JTable vtable, String vtext, int x, int y) throws Throwable {
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBackground(Color.white);
		jsp.setFocusable(true);
		table = null;
		table = new JTable();
		table = vtable;
		JViewport prt = new JViewport();
		prt.setBackground(Color.WHITE);
		prt.add(table);
		table.setFocusable(true);
		prt.setVisible(true);
		jsp.setViewport(prt);
		frame = new JFrame();
		try {
			new gnApp().setFrameTitel(frame);
		} catch (Throwable e) {

		}

		int row = table.getRowCount();
		if (row > 0) {
			jsp.setPreferredSize(new Dimension(x, y));
			jsp.setBorder(BorderFactory.createRaisedBevelBorder());
			table.requestFocus();
			table.setFocusable(true);
			table.grabFocus();
			frame.setVisible(false);
			String choice = "N";
			switch (choice) {
			case "N":
				frame = new JFrame();
				frame.setBounds(100, 200, x, y);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setAlwaysOnTop(true);
				frame.setFocusableWindowState(true);
				panel = new JPanel();
				panel.setPreferredSize(new Dimension(x, y));
				table.setFocusable(true);
				table.setFocusCycleRoot(true);
				table.grabFocus();

				panel.add(jsp);
				frame.add(panel);
				frame.setAlwaysOnTop(true);
				frame.setVisible(true);
				table.grabFocus();
				frame.pack();
				break;
			}
		} else {
			new General().Quickmsg("!!!!! No Record Found...!!!!!");
		}

	}

	// End MsgSearchnew here

	public void displayInfo(String vtype, int row) throws Throwable {
		String vstore = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		if (stable.getRowCount() > 0) {
			switch (vtype) {
			case "Y":
				cost = (String) stable.getValueAt(row, 3);
				salesPrice = (String) stable.getValueAt(row, 4);
				mrp = (String) stable.getValueAt(row, 5);
				batchno = (String) stable.getValueAt(row, 7);
				manuf_date = (String) stable.getValueAt(row, 8);
				expiry_date = (String) stable.getValueAt(row, 9);
				bal_qty = (String) stable.getValueAt(row, 10);
				new gnTable().RemoveTableRows(smodel);
				break;

			case "N":

				String vpara811 = "811";
				String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
						vstore);
				// new General().msg("Maintain Batch For Non Batch Items " + "
				// "+vmaintainbatchforNonBatchItem);
				switch (vmaintainbatchforNonBatchItem) {
				case "Y":
					cost = (String) stable.getValueAt(row, 3);
					salesPrice = (String) stable.getValueAt(row, 4);
					mrp = (String) stable.getValueAt(row, 5);
					batchno = (String) stable.getValueAt(row, 7);
					manuf_date = (String) stable.getValueAt(row, 8);
					expiry_date = (String) stable.getValueAt(row, 9);
					bal_qty = (String) stable.getValueAt(row, 10);
					// new gnTable().RemoveTableRows(smodel);
					break;

				case "N":
					if (vrw > 1) {
						cost = (String) stable.getValueAt(row, 3);
						salesPrice = (String) stable.getValueAt(row, 4);
						mrp = (String) stable.getValueAt(row, 5);
						batchno = (String) stable.getValueAt(row, 7);
						manuf_date = (String) stable.getValueAt(row, 8);
						expiry_date = (String) stable.getValueAt(row, 9);
						bal_qty = (String) stable.getValueAt(row, 10);
						new gnTable().RemoveTableRows(smodel);
					}
					break;
				}
				break;
			}
		}

		new gnTable().RemoveTableRows(smodel);
	}

	public CellEditorListener ChangeNotification2 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = stable.getSelectedRow();
			String vtype = (String) stable.getValueAt(row, 0);
			String varticle = (String) stable.getValueAt(row, 1);
			try {
				displayInfo(vtype, row);
				// QtychangeImapct(varticle , selectedrow);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	};

	public void resetValues() {
		vcomp = "0";
		vstore = "0";
		manuf_date = "0";
		expiry_date = "0";
		batchno = "0";
		cost = "0.00";
		mrp = "0.00";
		salesPrice = "0.00";
		bal_qty = "0.00";
	}

}// Last

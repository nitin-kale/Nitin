package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

public class gnInvoice extends getResultSet {

	;
	public static String customercode;
	public static String invno;
	public static String invdate;
	public static String Invtype;

	private String vcomp;
	private String vstore;

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	public JScrollPane sjsp = new JScrollPane();

	String SCol[] = { "Type ", "Customer", "Invoice No", "Invoice Date", "Inv.Type", "Amount", "Payment Status",
			"Cr.Days", "Due Date", "Payment No" };

	public void getCustomerInvno(String vCust) throws Throwable {
		/// new General().msg(vtype);
		String SQL = "";
		// vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		// vto = new gnConfig().date_ConverttoDBforamt(vto);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		smodel.setColumnIdentifiers(SCol);
		new gnTable().RemoveTableRows(smodel);
		SQL = "call  Inv_getCustInvoiceNo(  " + vcomp + ", " + vstore + " , '" + vCust + "')";
		String type = "Invoice";
		// new General().msg(SQL);
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 8, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 6, 300);
		// DefaultCellEditor nk = new gnTable().cellEdit(stable) ;
		// nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select Invoice NO From List
		// <Click on row to select Record", 1100, 500);
		Selectrow();

	}

	public void getInvno(String vtype, String vfrom, String vto) throws Throwable {
		/// new General().msg(vtype);
		String SQL = "";
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		smodel.setColumnIdentifiers(SCol);
		new gnTable().RemoveTableRows(smodel);
		switch (vtype) {
		case "B2B":
			SQL = "call  Inv_getInvoiceNo(  " + vcomp + ", " + vstore + " ,   '" + vfrom + "' ,  '" + vto + "' ,   '"
					+ vtype + "'  , )";
			break;
		case "WS":
			SQL = "call  Inv_getInvoiceNo(  " + vcomp + ", " + vstore + " , '" + vfrom + "' ,  '" + vto + "' ,   '"
					+ vtype + "')";
			break;
		case "RI":
			SQL = "call  Inv_getInvoiceNo(  " + vcomp + ", " + vstore + " , '" + vfrom + "' ,  '" + vto + "' ,   '"
					+ vtype + "')";
			break;
		case "SR":
			SQL = "call  Inv_getInvoiceNo(  " + vcomp + ", " + vstore + " ,   '" + vfrom + "' ,  '" + vto + "' ,  '"
					+ vtype + "')";
		case "ALL":
			SQL = "call  Inv_getInvoiceNo(  " + vcomp + ", " + vstore + " , '" + vfrom + "' ,  '" + vto + "' ,   '"
					+ vtype + "')";
			break;
		}
		String type = "Invoice";
		// new General().msg(SQL);
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, SCol, 8, "N", "Y", type);
		new gnTable().setTableColWidth(stable, 6, 300);
		// DefaultCellEditor nk = new gnTable().cellEdit(stable) ;
		// nk.addCellEditorListener(ChangeNotification3);
		JViewport prt6 = new JViewport();
		sjsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, SCol);
		sjsp.setViewport(prt6);
		// new General().msgsearch(sjsp, stable, "Select Invoice NO From List
		// <Click on row to select Record", 1100, 500);
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
		new General().msgsearch(sjsp, stable, "Select Data ", 900, 300);
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
		case "Invoice":
			customercode = stable.getValueAt(row, 1).toString();
			invno = stable.getValueAt(row, 2).toString();
			invdate = stable.getValueAt(row, 3).toString();
			Invtype = stable.getValueAt(row, 4).toString();

			break;
		}

	}

	public void printInvoice(File file) {

		/*
		 * try { FileOutputStream output = new FileOutputStream(file);
		 * XWPFDocument doc = new XWPFDocument(); CTBody body =
		 * doc.getDocument().getBody(); if(!body.isSetSectPr()) {
		 * body.addNewSectPr(); }
		 * 
		 * CTSectPr section = body.getSectPr(); if(!section.isSetPgSz()) {
		 * //section.addNewPgSz() ; } CTPageSz pageSize = section.getPgSz();
		 * pageSize.setOrient(STPageOrientation.PORTRAIT);
		 * 
		 * int value = 4000+(gui.model.getRowCount()*1000);
		 * 
		 * pageSize.setW(BigInteger.valueOf(4050));
		 * pageSize.setH(BigInteger.valueOf(value));
		 * 
		 * CTPageMar pageMar = section.addNewPgMar();
		 * pageMar.setLeft(BigInteger.valueOf(400L));
		 * pageMar.setTop(BigInteger.valueOf(0L));
		 * pageMar.setRight(BigInteger.valueOf(0L));
		 * pageMar.setBottom(BigInteger.valueOf(0L));
		 * 
		 * XWPFParagraph para = doc.createParagraph();
		 * para.setAlignment(ParagraphAlignment.LEFT); XWPFRun run =
		 * para.createRun(); para.setWordWrap(true); run.setBold(true);
		 * run.setFontSize(10); run.setText("          "+address.shopName);
		 * run.addBreak(); run.setText("                        "
		 * +address.phoneNo); run.addBreak(); run.setText("   "
		 * +address.description); run.addBreak(); para = doc.createParagraph();
		 * para.setAlignment(ParagraphAlignment.LEFT); run = para.createRun();
		 * para.setWordWrap(true); run.setFontSize(10); run.setText(
		 * "Invoice No."+invoiceno); run.addBreak(); run.setText("Type: "
		 * +table); run.addBreak(); run.setText("Customer Name: "+name+"    "
		 * +tempObj); run.addBreak(); run.setText(
		 * "--------------------------------------------------------");
		 * run.addBreak(); run.setText(
		 * "Product              Qty          Price          Total");
		 * run.addBreak(); run.setText(
		 * "--------------------------------------------------------");
		 * run.addBreak();
		 * 
		 * String temp = null; for(int i = 0 ; i < gui.table.getRowCount();
		 * i++){ temp = gui.table.getValueAt(i, 1).toString(); String quanstr =
		 * gui.table.getValueAt(i, 2)+""; String unitPricestr =
		 * gui.table.getValueAt(i, 3)+""; String totalstr
		 * =gui.table.getValueAt(i, 4)+"";
		 * 
		 * run.setText(temp);run.addBreak(); run.setText(
		 * "                            "+quanstr+"          "+unitPricestr+
		 * "          "+totalstr); run.addBreak(); } double subTotal =
		 * tableTotalCounter(); run.setText(
		 * "--------------------------------------------------------");run.
		 * addBreak(); run.setText("Discount: "+dis+"%");run.addBreak();
		 * run.setText("Sub total: "+(subTotal -
		 * (subTotal*dis/100)));run.addBreak(); run.setText("Cash: "
		 * +cash);run.addBreak(); run.setText("Balance: "+(cash-(subTotal -
		 * (subTotal*dis/100)))); run.addBreak(); doc.write(output);
		 * output.close();
		 * 
		 * } catch (FileNotFoundException e1) { // TODO Auto-generated catch
		 * block System.out.println("Exception"); e1.printStackTrace(); }catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); System.out.println("Exception"); }
		 * 
		 * if(confirmation("Print invoice?","Confirmation")==0){ Desktop desktop
		 * = Desktop.getDesktop(); try { desktop.print(new File(FILE)); } catch
		 * (IOException e) { e.printStackTrace(); } }
		 * 
		 */
	}

}// last

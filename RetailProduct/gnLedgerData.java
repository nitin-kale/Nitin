package RetailProduct;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

public class gnLedgerData extends getResultSet {

	String vfrom;
	String vto;
	String vcomp;
	String vstore;
	String vfinyear;
	String SQL = " ";
	String vtype;
	double NsaccLedopbal = 0.00;
	double NsaccLedclbal = 0.00;

	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	JScrollPane jsp = new JScrollPane();

	private void generateBookData(String vglcode, String vglcodename, String vreporttitle)
			throws ClassNotFoundException, SQLException {

		NsaccLedopbal = Double.parseDouble(saccLedopbal);
		NsaccLedclbal = Double.parseDouble(saccLedclbal);

		if (saccLedopbaldrcr.length() == 0) {
			NsaccLedopbal = 0.00;
			saccLedopbaldrcr = "-";
		}

		if (saccLedopbaldrcr.isEmpty()) {
			NsaccLedopbal = 0.00;
			saccLedopbaldrcr = "-";
		}

		if (saccLedclbaldrcr.length() == 0) {
			NsaccLedclbal = 0.00;
			saccLedclbaldrcr = "-";
		}

		if (saccLedclbaldrcr.isEmpty()) {
			NsaccLedclbal = 0.00;
			saccLedclbaldrcr = "-";
		}

		// saccLedopbaldrcr
		// saccLedclbal
		// saccLedclbaldrcr

		vtype = "ALL";
		SQL = "call Account_Gen_Register( '" + vtype + "' , " + vcomp + " ," + vstore + "  , '" + vfrom + "' , '" + vto
				+ "', " + "'" + vfinyear + "' ,'" + vglcode + "' , '" + vglcodename + "' ,  '" + vreporttitle + "'  ,"
				+ " " + NsaccLedopbal + "  , '" + saccLedopbaldrcr + "'   ,  " + NsaccLedclbal + "  , '"
				+ saccLedclbaldrcr + "' )";
		// new General().msg(SQL);
		this.getSPResult(SQL);
	}

	public JTable GenerateLedgerReport(String vglcode, String vglcodename, String vreporttitle, String vfromdate,
			String vtodate) throws Throwable {

		vfrom = new gnConfig().date_ConverttoDBforamt(vfromdate);
		vto = new gnConfig().date_ConverttoDBforamt(vtodate);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStorecode();
		vfinyear = new gnFinYear().getReportingFinYear();

		try {
			generateBookData(vglcode, vglcodename, vreporttitle);
			vtype = "GETDATA";
			String[] col = { "DocType", "V.No", "V.Date", "Ledger Code", "Description", "Credit", "Debit",
					"PaymentMode", "InstrumentNo", "InstrumentDate", "Narration" };

			SQL = "call Account_Gen_Register( '" + vtype + "' , " + vcomp + " ," + vstore + "  , '" + vfrom + "' , '"
					+ vto + "', '" + vfinyear + "' ," + " " + vglcode + "   , '" + vglcodename + "' , '" + vreporttitle
					+ "' ," + " " + NsaccLedopbal + "  , '" + saccLedopbaldrcr + "'   ,  " + NsaccLedclbal + "  , '"
					+ saccLedclbaldrcr + "' )";

			// new General().msg(SQL);
			mytable = showBook(vtype, SQL, col);
			ledgerType = "OtherLedger";
			supplierLedger window;
			window = new supplierLedger();
			window.frameSuplLedger.setVisible(true);
			mylabel = "Ledger"; // set to public
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
		ledgerType = "OtherLedger";
		return table;
	}

	public JTable showBook(String vtype, String SQL, String[] col) throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(col);
		table.setModel(model);
		new gnTableModel().Tablemodel(table, model, SQL, col, 11, "N", "N", "");
		// new General().msg(SQL);
		JViewport prt11 = new JViewport();
		prt11.setBackground(Color.WHITE);
		prt11.add(table, col);
		prt11.setVisible(true);
		jsp.setViewport(prt11);
		table.setRowHeight(25);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		new gnTable().setTablewidth(table, 2, 120);
		new gnTable().setTableBasics(table);
		table.setFont(new Font("Arial", 15, 15));
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.requestFocus();
		// new General().msgsearch(jsp, table, "Select Data ", 900, 300 );
		return table;
	}

}

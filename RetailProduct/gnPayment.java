package RetailProduct;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class gnPayment {

	private String vcomp;
	private String vstore;
	private String type;
	private String supplier;
	private String customer;
	private String SQL;

	// Comman
	private String Col[] = { "Type", "Party Code", "Document No", "Document Date", "Amount", "Amount Consume",
			"Balance_Amount", "Status" };

	private String Gr[] = { "Remove", "Doc.Type", "Grn no", "Grn Date", "Due Date", "Credit Days", "Inv no", "Inv Date",
			"Grn Amount", };

	private String searchGr[] = { "Doc.Type", "Grn no", "Grn Date", "Due Date", "Credit Days", "DueAmount", "Inv no",
			"Inv Date", "Grn Amount", "Grn Approve" };

	private String pay[] = { "Remove", "PaymentMode", "Payment Type", "Amount", "Number", "Date", "Ac.No", "Bank",
			"Bank Name" };

	private JTable table = new JTable();
	private DefaultTableModel model = new DefaultTableModel();

	private void getCompDetails() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
	}

	public JTable getDataFor(String vtype, String vsupplier, String vdocCat) throws Throwable {
		getCompDetails();
		type = vtype;
		supplier = vsupplier;
		new gnTable().RemoveTableRows(model);
		switch (type) {
		case "Due Grns":
			model.setColumnIdentifiers(searchGr);
			SQL = "call  payment_getdueGrn(" + supplier + " , " + vstore + " , " + vcomp + ")";
			// new General().msg(SQL);
			table = new gnTableModel().Tablemodel(table, model, SQL, searchGr, 10, "N", "N", type);
			break;
		case "DN":
			model.setColumnIdentifiers(Col);
			SQL = "call Payment_dncndetails( '" + type + "' , " + vstore + " , " + supplier + ", " + vcomp + " , '"
					+ vdocCat + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, 8, "N", "N", type);
			break;
		case "CN":
			model.setColumnIdentifiers(Col);
			SQL = "call Payment_dncndetails( '" + type + "' , " + vstore + " , " + supplier + ", " + vcomp + "  , '"
					+ vdocCat + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, 8, "N", "N", type);
			break;
		case "AD":
			model.setColumnIdentifiers(Col);
			SQL = "call Payment_dncndetails( '" + type + "' , " + vstore + " , " + supplier + ", " + vcomp + " , '"
					+ vdocCat + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, 8, "N", "N", type);
			break;
		case "History":
			// model.setColumnIdentifiers(Col);
			String col1[] = { "Payment History", "Branch Code", "Bank Code", "Party Code", "Grn Amount", "PaidAmount",
					"Payment_no", "Payment_date", "Payment_mode", "payment_type", "chq_DD_NO", "CHQ_DD_DATE" };
			model.setColumnIdentifiers(col1);
			String SQL = "call payment_gethistory(" + supplier + ", " + vcomp + ", " + vstore + " )";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 11, "N", "Y", type);
			break;
		}
		// searchmodel.addRow(new Object[]{rs.getString(1), rs.getString(2),
		// rs.getString(3), rs.getString(4) ,rs.getString(5) ,rs.getString(6) ,
		// rs.getString(7) , rs.getString(8)});
		return table;
	}

	// For Credit Sales Customer
	public JTable getCustomerDataFor(String vtype, String vcustomer) throws Throwable {
		getCompDetails();
		type = vtype;
		customer = vcustomer;
		new gnTable().RemoveTableRows(model);
		switch (type) {
		case "Credit Sales - Invoice":
			// new General().msg("Firing Query");
			String custInv[] = { "Doc.Type", "Invno", "Inv Date", "Due Date", "Credit Days", "Sales Type",
					"Invoice Amount", "Invoice Status", "Recipt.Adv.No" };
			model.setColumnIdentifiers(searchGr);
			SQL = "call  payment_getdueInvoice( " + vcomp + " , " + vstore + " , " + customer + ")";
			// new General().msg(SQL);
			table = new gnTableModel().Tablemodel(table, model, SQL, custInv, 9, "N", "N", type);
			break;
		case "DN":
			model.setColumnIdentifiers(Col);
			SQL = "call Payment_dncndetails( '" + type + "' , " + vstore + " , " + customer + ", " + vcomp + ")";
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, 8, "N", "N", type);
			break;
		case "CN":
			model.setColumnIdentifiers(Col);
			SQL = "call Payment_dncndetails( '" + type + "' , " + vstore + " , " + customer + ", " + vcomp + ")";
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, 8, "N", "N", type);
			break;
		case "AD":
			model.setColumnIdentifiers(Col);
			SQL = "call Payment_dncndetails( '" + type + "' , " + vstore + " , " + customer + ", " + vcomp + ")";
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, 8, "N", "N", type);
			break;
		case "History":
			// model.setColumnIdentifiers(Col);
			String col1[] = { "Payment History", "Branch Code", "Bank Code", "Party Code", "Inv.Amount", "PaidAmount",
					"Payment_no", "Payment_date", "Payment_mode", "payment_type", "chq_DD_NO", "CHQ_DD_DATE" };
			model.setColumnIdentifiers(col1);
			String SQL = "call payment_gethistory(" + customer + ", " + vcomp + ", " + vstore + " )";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 11, "N", "Y", type);
			break;
		}
		// searchmodel.addRow(new Object[]{rs.getString(1), rs.getString(2),
		// rs.getString(3), rs.getString(4) ,rs.getString(5) ,rs.getString(6) ,
		// rs.getString(7) , rs.getString(8)});
		return table;
	}

	public String getValiduptoDate(String vdocdate) throws Throwable {
		// new General().msg("document date passed for valida"+ " "+vdocdate);
		// String vdocdate = new gnConfig().Date_convertToApplformat(vdocdate1);
		String vpara = "808";
		// String vstore = new gnConfig().getStoreID() ;
		// String vcomp= new gnConfig().getCompanyCode() ;
		// String SQL = " call CONF_getSpecificvalue('"+vpara+"', "+vstore+" ,
		// "+vcomp+")";
		String vdays = new getConfigurationSetting().getSpecificConfiguration(vpara);
		if (vdays == "Fail") {
			vdays = "30";
		}
		int vvdays = Integer.parseInt(vdays);
		String ValiduptoDate = new gnConfig().get_duedate(vdocdate, vvdays);
		// new General().msg("Returan Valida date "+ " "+ValiduptoDate);
		return ValiduptoDate;
	}

	public static void main(String[] args) throws Throwable {
		gnPayment pmt = new gnPayment();
		pmt.getCompDetails();
	}

}

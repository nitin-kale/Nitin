package RetailProduct;

public class gnSalesReport extends getResultSet {

	private String vcomp;
	private String vstore;
	private String rerportname;
	private String SQL;
	private String reportTitle;

	public void callSalesReport(String vrepotype, String vfromdate, String vtodate, String vcode) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		switch (vrepotype) {
		case "2":
			rerportname = "SalesReport.jasper";
			reportTitle = "Date Wise Sales Summary";
			SQL = "Call  Repo_SalesReport(" + vcomp + "  , " + vstore + " ,  '" + vfromdate + "'  , '" + vtodate
					+ "' , " + vrepotype + " , '" + reportTitle + "' , " + vcode + ")";
			new General().msg(SQL);
			this.getResult(SQL);
			break;

		case "3":
			rerportname = "SalesReport.jasper";
			reportTitle = "Credit Sales  Summary";
			SQL = "Call Repo_SalesReport(" + vcomp + "  , " + vstore + " ,  '" + vfromdate + "'  , '" + vtodate + "' , "
					+ vrepotype + " , '" + reportTitle + "' , " + vcode + ")";
			new General().msg(SQL);
			this.getResult(SQL);
			break;

		case "4":
			rerportname = "Pur_brandwise_report.jasper";
			reportTitle = "Brand Wise Sales Report";
			SQL = "Call repo_SalesReport(" + vcomp + "  , " + vstore + " ,  '" + vfromdate + "'  , '" + vtodate + "' , "
					+ vrepotype + " , '" + reportTitle + "' , " + vcode + ")";
			new General().msg(SQL);
			this.getResult(SQL);
			break;

		case "5":
			rerportname = "Pur_articlewise_report.jasper";
			reportTitle = "Article Wise Sales   Report";
			SQL = "Call repo_SalesReport(" + vcomp + "  , " + vstore + " ,  '" + vfromdate + "'  , '" + vtodate + "' , "
					+ vrepotype + " , '" + reportTitle + "' , " + vcode + ")";
			new General().msg(SQL);
			this.getResult(SQL);
			break;

		case "6":
			rerportname = "SalesReport_customer1.jasper";
			reportTitle = "Customer Wise Due Payments ";
			SQL = "Call    Repo_SalesReport_customer(" + vcomp + "  , " + vstore + " ,  '" + vfromdate + "'  , '"
					+ vtodate + "' , " + vrepotype + " , '" + reportTitle + "' , " + vcode + ")";
			new General().msg(SQL);
			this.getResult(SQL);
			break;

		case "7":
			rerportname = "SalesReport_customer1.jasper";
			reportTitle = "Customer Wise Payment Report";
			SQL = "Call   Repo_SalesReport_customer(" + vcomp + "  , " + vstore + " ,  '" + vfromdate + "'  , '"
					+ vtodate + "' , " + vrepotype + " , '" + reportTitle + "' , " + vcode + ")";
			new General().msg(SQL);
			this.getResult(SQL);
			break;
		}

		gnPrintMasters rpt = new gnPrintMasters();
		rpt.print(rerportname);
	}

}// Last

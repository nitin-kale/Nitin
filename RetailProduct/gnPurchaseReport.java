package RetailProduct;

public class gnPurchaseReport extends getResultSet {

	private String vcomp;
	private String vstore;
	private String rerportname;
	private String SQL;
	private String reportTitle;

	public void callPurchaseReport(String vrepotype, String vfromdate, String vtodate, String vcode) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		switch (vrepotype) {
		case "2":
			rerportname = "Pur_date_wise_report.jasper";
			reportTitle = "Date Wise Purchase";
			SQL = "Call repo_PurchaseReports(" + vcomp + "  , " + vstore + " ,  '" + vfromdate + "'  , '" + vtodate
					+ "' , " + vrepotype + " , '" + reportTitle + "' , " + vcode + ")";
			// new General().msg(SQL);
			this.getResult(SQL);
			rs.close();
			this.closeconn();

			break;

		case "3":
			rerportname = "Pur_date_wise_report.jasper";
			reportTitle = "Supplier Wise Purchase Report";
			SQL = "Call repo_PurchaseReports(" + vcomp + "  , " + vstore + " ,  '" + vfromdate + "'  , '" + vtodate
					+ "' , " + vrepotype + " , '" + reportTitle + "' , " + vcode + ")";
			// new General().msg(SQL);
			this.getResult(SQL);
			rs.close();
			this.closeconn();
			break;

		case "4":
			rerportname = "Pur_brandwise_report.jasper";
			reportTitle = "BrandPurchase Report";
			SQL = "Call repo_PurchaseReports(" + vcomp + "  , " + vstore + " ,  '" + vfromdate + "'  , '" + vtodate
					+ "' , " + vrepotype + " , '" + reportTitle + "' , " + vcode + ")";
			// new General().msg(SQL);
			this.getResult(SQL);
			rs.close();
			this.closeconn();
			break;

		case "5":
			rerportname = "Pur_articlewise_report.jasper";
			reportTitle = "Article Purchase  Report";
			SQL = "Call repo_PurchaseReports(" + vcomp + "  , " + vstore + " ,  '" + vfromdate + "'  , '" + vtodate
					+ "' , " + vrepotype + " , '" + reportTitle + "' , " + vcode + ")";
			// new General().msg(SQL);
			this.getResult(SQL);
			rs.close();
			this.closeconn();
			break;

		}
		gnPrintMasters rpt = new gnPrintMasters();
		rpt.print(rerportname);
	}

}// Last

package RetailProduct;

public class gnCloseFinyear extends getResultSet {

	String vcomp;
	String vstore;
	String vfinyear;

	private void setStandard() throws Throwable {
		vfinyear = new gnFinYear().getReportingFinYear();
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
	}

	public String CheckFinyearStockDataPresent(String vvfinyear) throws Throwable {
		setStandard();
		int row = 0;
		String status = "Fail";
		String SQL = "Call account_Stock_checkDataPresentForSite(" + vcomp + " , " + vstore + "  , '" + vvfinyear
				+ "' )";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			row = Integer.parseInt(rs.getString(1));
			if (row == 0) {
				status = "Sucess";
			}
		}
		rs.close();
		this.closeconn();
		return status;
	}

}// Last

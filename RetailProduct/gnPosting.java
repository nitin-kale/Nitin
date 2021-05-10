package RetailProduct;

public class gnPosting extends getResultSet {

	public void postGstEntries(String vinvno, String vtranType, String vmethod, String vdocdate) throws Throwable {
		try {
			String vdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
			String vcomp = new gnConfig().getCompanyCode();
			String vstore = new gnConfig().getStoreID();
			String SQL = "call GST_Sales_ReturnFileData(" + vcomp + " , " + vstore + " , " + vinvno + " ,  '"
					+ vtranType + "' ,   '" + vmethod + "' , '" + vdate + "')";
			this.getResult(SQL);
		} catch (Exception e) {
			new General().msg("GST Entry Posting Problem..." + e.getLocalizedMessage());
		}

	}

	public void postSundrydrcr(String vinvno, String vdocdate, String vdocType) throws Throwable {
		try {

			// new General().msg("drcrLedgerReached");
			String vcomp = new gnConfig().getCompanyCode();
			String vstore = new gnConfig().getStoreID();
			String vfinyear = new gnFinYear().getCurrentFinYear(vdocdate);
			vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
			String SQL1 = "Call Led_LedgerEntry(" + vcomp + " , " + vstore + " , " + vinvno + " , '" + vdocdate
					+ "'  ,'" + vdocType + "' , '" + vfinyear + "' )";
			this.getSPResult(SQL1);
		} catch (Exception e) {
			new General().msg("Sundryr/Dr/Cr Entry Posting Problem..." + e.getLocalizedMessage());
		}

	}

}// Last

package RetailProduct;

public class gnUtility extends getResultSet {

	String SQL = " ";

	public void syncLedgerCount() throws Throwable {
		String vfinyear = new gnFinYear().getReportingFinYear();
		SQL = "call account_insertAllCusandSup( " + vcomp + " , " + vstore + " ,  '" + vfinyear + "' )";
		new General().msg(SQL);
		this.getResult(SQL);
		new gnFinYear().InsertAccountBaseMaster();
		new General().Quickmsg("Ledger Count Sysnc in df and gl Table--Sucess");

	}

	public void syncGlNames() throws Throwable {
		SQL = "call  account_glNameSync( " + vcomp + " , " + vstore + " )";
		this.getResult(SQL);
		new General().Quickmsg("Ledger Name Sync--Sucess");

	}

}// Last

package RetailProduct;

import java.sql.ResultSet;
import java.sql.SQLException;

public class gnRepostSingleEntry extends getResultSet {

	// This Modul is usd only for Single Entry ACcount Posting
	// GST and drcr Ledgr ntry will not Post though this Module

	String SQL = "";
	String Col[] = { "Tr.Type", "Doc Type", "Doc.Date", "Doc. No.", "Party Code", "Party Name", "Transaction Amount" };
	String Col1[] = { "Doc.Type", "TR.Type", "Doc.Date", "Doc. No.", "Bankcode", "Name", "Other Bankcode",
			"Transaction Amount", "Payment Mode", "Chq/DD N0", "Chq/dd Date" };
	String vcomp = "";
	String vstore = " ";
	String vfrom = "";
	String vto = "";
	int i = 0;

	String vdocno = "";
	String vdocdate = "";
	String vdoctype = "";
	String vpartycode = "";
	String vamount = "";

	String vpmode = "";
	String vchqno = "";
	String vchqdate = "";
	String vtrtype = "";
	String trtype = "";
	String vbankcode = "";

	public void processPostingEntries(String vtype, String vdocno, String vdocdate) throws Throwable {
		// This Modul is usd only for Single Entry ACcount Posting
		// GST and drcr Ledgr ntry will not Post though this Module
		switch (vtype) {
		case "GRN":
			PurchaseAccountReposting(vtype, vdocno, vdocdate);
			break;

		case "PR":
			// PRGSTDataReposting(vtype , vdocno, vdocdate);
			// DNGSTDataReposting(vtype , vdocno, vdocdate) ; //Debit note
			// Posting
			PRAccountReposting(vtype, vdocno, vdocdate);
			break;

		case "SALE":
			// saleGSTDataReposting(vtype , vdocno, vdocdate) ;
			POSSalesAccountReposting(vtype, vdocno, vdocdate);
			break;

		case "SR":
			// SRGSTDataReposting(vtype , vdocno, vdocdate) ; ; //Sales Return
			// GST File Data
			// CNGSTDataReposting(vtype , vdocno, vdocdate) ; ; //Credit note
			// Posting
			SRAccountReposting(vtype, vdocno, vdocdate);
			; // Accounting Posring
			break;

		case "RV":
			ReceiptAccountReposting(vtype, vdocno, vdocdate);
			break;

		case "PV":
			PaymentAccountReposting(vtype, vdocno, vdocdate);
			break;

		case "CO":
			CONAccountReposting(vtype, vdocno, vdocdate);
			;
			break;

		case "SAD":
			// SuplAdvGSTDataReposting(vtype , vdocno, vdocdate) ;;
			// SuplAdvAccountReposting(vtype , vdocno, vdocdate) ;;

			break;

		case "CAD":
			// CustAdvGSTDataReposting(vtype , vdocno, vdocdate) ;
			// CustAdvAccountReposting(vtype , vdocno, vdocdate) ;
			break;

		case "EX":
			ExpenseAccountReposting(vtype, vdocno, vdocdate);
			break;

		case "IN":
			IncomeAccountReposting(vtype, vdocno, vdocdate);
			break;

		}
	}

	// ===========Single Account Entry Reposting=====

	private void PurchaseAccountReposting(String vtype, String vdocno, String vdocdate) throws Throwable {
		// new General().msg("Purchase Account Posting...");
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		// vmethod = "GRRegular" ;
		vdoctype = "GRN";
		// new gnPosting().postGstEntries(vdocno , vdoctype , vmethod ,
		// vdocdate);
		// new gnPosting().postSundrydrcr(vdocno , vdocdate ,vdoctype);
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call    AcctDocPosting_purchaseData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	private void POSSalesAccountReposting(String vtype, String vdocno, String vdocdate) throws Throwable {
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		// vmethod = "SALRegular" ;
		// vsalestype = "PS" ;
		// new gnPosting().postGstEntries(vdocno, vsalestype, vmethod,
		// vdocdate);
		vdoctype = "SAL";
		new gnPosting().postSundrydrcr(vdocno, vdocdate, vdoctype);
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call    AcctDocPosting_POSSalesData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	private void SRAccountReposting(String vtype, String vdocno, String vdocdate) throws Throwable // Accounting
																									// Posring
	{
		isledgerRun = "N";
		String vmethod = "SRRegular";
		String vsalestype = "SR";
		vdoctype = "Cash-SR";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vvamount = "";
		// new gnPosting().postGstEntries(vdocno, vsalestype , vmethod ,
		// vdocdate );
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call    AcctDocPosting_SRData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
	}

	private void PRAccountReposting(String vtype, String vdocno, String vdocdate) throws Throwable {

		isledgerRun = "N";
		String vsalestype = "PR";
		String vmethod = "PRRegular";
		vdoctype = "Pur.Return";

		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		// new gnPosting().postGstEntries(vdocno, vdoctype , vmethod ,
		// vdocdate);
		vdoctype = "DN";

		// gstDebitnoteProcess old posting method

		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call    AcctDocPosting_PRData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
	}

	private void PaymentAccountReposting(String vtype, String vdocno, String vdocdate) throws Throwable {
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call    AcctDocPosting_PaymentData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		// new General().msg(SQL);
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
	}

	private void ReceiptAccountReposting(String vtype, String vdocno, String vdocdate) throws Throwable {

		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();

		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call    AcctDocPosting_ReceiptData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	private void CONAccountReposting(String vtype, String vdocno, String vdocdate) throws Throwable {
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = "CO";
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call    AcctDocPosting_CONData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	private void ExpenseAccountReposting(String vtype, String vdocno, String vdocdate) throws Throwable {
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call    AcctDocPosting_ExpenseData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		// new General().msg(SQL);
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
	}

	private void IncomeAccountReposting(String vtype, String vdocno, String vdocdate) throws Throwable {
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call    AcctDocPosting_IncomeData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		// new General().msg(SQL);
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
	}

}// Last

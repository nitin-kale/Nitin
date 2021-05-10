package RetailProduct;

import java.sql.SQLException;

public class gnGSTMiddleWare extends getResultSet {

	String vcomp;
	String vstore;
	String vdocdate = "";
	String vdocdt = "";
	String vcgst = "";
	String vsgst = "";
	String vigst = " ";
	String vdoctype2 = "";
	String vtaxtype = " ";
	String vdocno = "";
	String vmethod;
	String vsalestype;
	String vdoctype;

	// BackEnd Doc Posting
	// backend_DocgstGRNProcess
	// backend_DocgstPOSSalesProcess //For Pos Sales and Credit Sales
	// backend_DocgstPRProcess //PR Data is not Required in GST REturn DAta
	// Debit note is there
	// backend_DocgstSRprocess //SR Data is not Required in GST REturn DAta
	// Credit note is there
	// backend_DocgstExpenseProcess //Not for Regular Voucher for Other Purchase
	// Like Expenses right not not in use
	// backend_DocgstSuplAdvanceProcess
	// backend_DocgstCustAdvanceProcess
	// backend_DocaccountPaymentPosting
	// backend_DocaccountReceiptPosting
	// backend_DocaccountContraPosting
	// gstDebitnoteProcess // Back End Entry but not like above
	// gstCreditnoteProcess // Back End Entry but not like above

	// Not Through Back End handled using Old Logic only
	// Expense Voucher // Posted through new gnBridge().processEntryPosting
	// Mthod
	// Income Voucher // Posted through new gnBridge().processEntryPosting Mthod

	public void backend_DocgstGRNProcess(String vparty, String vdocno, String vdocdate, String vamount)
			throws Throwable {
		try {
			isledgerRun = "N";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
			vmethod = "GRRegular";
			vdoctype = "GRN";
			new gnPosting().postGstEntries(vdocno, vdoctype, vmethod, vdocdate);
			new gnPosting().postSundrydrcr(vdocno, vdocdate, vdoctype);
			String vscheme = "";
			String Vmyscheme = new gnGST().gst_getmytaxschemecode();
			switch (Vmyscheme) {
			case "1":
				vscheme = "C";
				break;
			case "2":
				vscheme = "R";
				break;
			case "0":
				vscheme = "N";
				break;
			}

			
			String SQL = "call    AcctDocPosting_purchaseData( " + vcomp + "  , " + vstore + "  ,    " + vdocno
					+ "  , '" + vdocdate1 + "'  , '" + vscheme + "'  )";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();
 		} catch (Exception e1) {
			new General().msg("Purchase Posting Problem..." + e1.getLocalizedMessage());
		}

	}

	public void backend_DocgstPOSSalesProcess(String vparty, String vdocno, String vdocdate, String vamount)
			throws Throwable {
		// This is used for posting of accounting entry in the backgroud not
		// from front end both credit sales and retial sales
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		vmethod = "SALRegular";
		vsalestype = "PS";
		new gnPosting().postGstEntries(vdocno, vsalestype, vmethod, vdocdate);
		vdoctype = "SAL";
		new gnPosting().postSundrydrcr(vdocno, vdocdate, vdoctype);
		
		String vscheme = "";
		String Vmyscheme = new gnGST().gst_getmytaxschemecode();
		switch (Vmyscheme) {
		case "1":
			vscheme = "C";
			break;
		case "2":
			vscheme = "R";
			break;
		case "0":
			vscheme = "N";
			break;
		}
		
		String SQL = "call AcctDocPosting_POSSalesData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();


		
		String SQL1 = "call AcctDocPosting_POSalesPaymentData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL1);
		rs.close();
		this.closeconn();

	}

	public void backend_DocgstSRprocess(String vparty, String vdocno, String vdocdate, String vamount, String vchoice)
			throws Throwable {

		vmethod = "SRRegular";
		vsalestype = "SR";
		vdoctype = "Cash-SR";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vvamount = "";
		isledgerRun = "N";
		new gnPosting().postGstEntries(vdocno, vsalestype, vmethod, vdocdate);

		String vscheme = "";
		String Vmyscheme = new gnGST().gst_getmytaxschemecode();
		switch (Vmyscheme) {
		case "1":
			vscheme = "C";
			break;
		case "2":
			vscheme = "R";
			break;
		case "0":
			vscheme = "N";
			break;
		}
		try {
			String SQL = "call    AcctDocPosting_SRData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
					+ vdocdate1 + "'  , '" + vscheme + "'  )";
			// new General().msg(SQL);
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			new General().msg(e.getMessage());
		}
	}

	public void gstCreditnoteProcess(String vparty, String vdocno, String vdocdate, String vamount) throws Throwable {
		isledgerRun = "N";
		vmethod = "CNRegular";
		vdoctype = "CN";
		// new gnPosting().postGstEntries(vdocno , vdoctype , vmethod ,
		// vdocdate);
		new gnPosting().postSundrydrcr(vdocno, vdocdate, vdoctype);
	}

	public void backend_DocgstPRProcess(String vparty, String vdocno, String vdocdate, String vamount)
			throws Throwable {
		vsalestype = "PR";
		vmethod = "PRRegular";

		vdoctype = "Pur.Return";
		isledgerRun = "N";

		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		new gnPosting().postGstEntries(vdocno, vdoctype, vmethod, vdocdate);
		vdoctype = "DN";

		// gstDebitnoteProcess old posting method

		String vscheme = "";
		String Vmyscheme = new gnGST().gst_getmytaxschemecode();
		switch (Vmyscheme) {
		case "1":
			vscheme = "C";
			break;
		case "2":
			vscheme = "R";
			break;
		case "0":
			vscheme = "N";
			break;
		}
		String SQL = "call    AcctDocPosting_PRData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		// new General().msg(SQL);
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void gstDebitnoteProcess(String vparty, String vdocno, String vdocdate, String vamount) throws Throwable {
		vmethod = "DNRegular";
		vdoctype = "DN";
		isledgerRun = "N";
		new gnPosting().postGstEntries(vdocno, vdoctype, vmethod, vdocdate);
		new gnPosting().postSundrydrcr(vdocno, vdocdate, vdoctype);
	}

	public void backend_DocgstCustAdvanceProcess(String vparty, String vdocno, String vdocdate, String vamount,
			String vdoctype1) throws Throwable {
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vsalestype = "C";
		vmethod = "CAD";
		new gnPosting().postGstEntries(vdocno, vsalestype, vmethod, vdocdate);
		vdoctype = "CAD";
		new gnPosting().postSundrydrcr(vdocno, vdocdate, vdoctype);
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";
		String Vmyscheme = new gnGST().gst_getmytaxschemecode();
		switch (Vmyscheme) {
		case "1":
			vscheme = "C";
			break;
		case "2":
			vscheme = "R";
			break;
		case "0":
			vscheme = "N";
			break;
		}
		String SQL = "call    AcctDocPosting_CustAdvData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void backend_DocgstSuplAdvanceProcess(String vparty, String vdocno, String vdocdate, String vamount,
			String vdoctype1) throws Throwable {
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vsalestype = "S";
		vmethod = "SAD";
		new gnPosting().postGstEntries(vdocno, vsalestype, vmethod, vdocdate);
		vdoctype = "SAD";
		new gnPosting().postSundrydrcr(vdocno, vdocdate, vdoctype);
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";
		String Vmyscheme = new gnGST().gst_getmytaxschemecode();
		switch (Vmyscheme) {
		case "1":
			vscheme = "C";
			break;
		case "2":
			vscheme = "R";
			break;
		case "0":
			vscheme = "N";
			break;
		}
		String SQL = "call    AcctDocPosting_suplAdvData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		// new General().msg(SQL);
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void backend_DocothertExpenseProcess(String vdocno, String vdocdate, String vamount) throws Throwable {

		// This Method is for Other Purcase Like Expense not for Expense Regular
		// Voucher

		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vsalestype = "C";
		vmethod = "CAD";
		vdoctype = "EXO";

		// new gnPosting().postSundrydrcr(vdocno , vdocdate ,vdoctype);

		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";
		String Vmyscheme = new gnGST().gst_getmytaxschemecode();
		switch (Vmyscheme) {
		case "1":
			vscheme = "C";
			break;
		case "2":
			vscheme = "R";
			break;
		case "0":
			vscheme = "N";
			break;
		}
		String SQL = "call     AcctDocPosting_OtherExpenseData( " + vcomp + "  , " + vstore + "  ,    " + vdocno
				+ "  , '" + vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	// P:ayment Receipt Contra Income Posting

	public void backend_DocaccountPaymentPosting(String vdocno, String vdocdate, String vamount) throws Throwable {
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vsalestype = "C";
		vmethod = "CAD";
		// new gnPosting().postGstEntries(vdocno, vsalestype , vmethod ,
		// vdocdate);
		vdoctype = "PV";
		new gnPosting().postSundrydrcr(vdocno, vdocdate, vdoctype);

		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";
		String Vmyscheme = new gnGST().gst_getmytaxschemecode();
		switch (Vmyscheme) {
		case "1":
			vscheme = "C";
			break;
		case "2":
			vscheme = "R";
			break;
		case "0":
			vscheme = "N";
			break;
		}
		String SQL = "call    AcctDocPosting_PaymentData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void backend_DocaccountExpensePosting(String vdocno, String vdocdate, String vamount) throws Throwable {
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vsalestype = "C";
		vmethod = "EX";
		// new gnPosting().postGstEntries(vdocno, vsalestype , vmethod ,
		// vdocdate);
		vdoctype = "EX";
		// new gnPosting().postSundrydrcr(vdocno , vdocdate ,vdoctype);

		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";

		String Vmyscheme = new gnGST().gst_getmytaxschemecode();
		switch (Vmyscheme) {
		case "1":
			vscheme = "C";
			break;
		case "2":
			vscheme = "R";
			break;
		case "0":
			vscheme = "N";
			break;
		}
		String SQL = "call    AcctDocPosting_ExpenseData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
	}

	public void backend_DocaccountIncomePosting(String vdocno, String vdocdate, String vamount) throws Throwable {
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vsalestype = "C";
		vmethod = "IN";
		// new gnPosting().postGstEntries(vdocno, vsalestype , vmethod ,
		// vdocdate);
		vdoctype = "IN";
		// new gnPosting().postSundrydrcr(vdocno , vdocdate ,vdoctype);

		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";

		String Vmyscheme = new gnGST().gst_getmytaxschemecode();
		switch (Vmyscheme) {
		case "1":
			vscheme = "C";
			break;
		case "2":
			vscheme = "R";
			break;
		case "0":
			vscheme = "N";
			break;
		}
		String SQL = "call    AcctDocPosting_IncomeData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
	}

	public void backend_DocaccountReceiptPosting(String vdocno, String vdocdate, String vamount) throws Throwable {

		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vsalestype = "C";
		vmethod = "CAD";
		// new gnPosting().postGstEntries(vdocno, vsalestype , vmethod ,
		// vdocdate);
		vdoctype = "RV";
		new gnPosting().postSundrydrcr(vdocno, vdocdate, vdoctype);

		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";
		String Vmyscheme = new gnGST().gst_getmytaxschemecode();
		switch (Vmyscheme) {
		case "1":
			vscheme = "C";
			break;
		case "2":
			vscheme = "R";
			break;
		case "0":
			vscheme = "N";
			break;
		}
		String SQL = "call    AcctDocPosting_ReceiptData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void backend_DocaccountContraPosting(String vdocno, String vdocdate, String vamount) throws Throwable {
		isledgerRun = "N";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vsalestype = "C";
		vmethod = "CAD";
		// new gnPosting().postGstEntries(vdocno, vsalestype , vmethod ,
		// vdocdate);
		vdoctype = "CO";
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String vscheme = "";
		String Vmyscheme = new gnGST().gst_getmytaxschemecode();
		switch (Vmyscheme) {
		case "1":
			vscheme = "C";
			break;
		case "2":
			vscheme = "R";
			break;
		case "0":
			vscheme = "N";
			break;
		}
		String SQL = "call    AcctDocPosting_CONData( " + vcomp + "  , " + vstore + "  ,    " + vdocno + "  , '"
				+ vdocdate1 + "'  , '" + vscheme + "'  )";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	// End Payment Receipt Contra Income Posting
	// End BackEnd Doc Posting

}// Last

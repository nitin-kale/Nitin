package RetailProduct;

import java.sql.SQLException;

public class gnBridge extends getResultSet {

	String vdocno;
	String vdocdate;
	String vdoctype;
	String vvparty;
	String vvamount;
	String vDrglcode;
	String vCrglcode;

	// Gst Reposting Of Entries
	// Bulk GST Entry Posting for Purcahse sales PR SR Debit note and credit
	// note ==============

	public void PurchaseOnlyBulkGSTReposting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call   GST_OnlyPurchase_ReturnFileData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto
				+ "')";
		this.getSPResult(SQL);
		new General().Quickmsg("GST & DrcrLedger Posting Over..");
	}

	public void PROnlyBulkGSTReposting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call   GST_OnlyPR_ReturnFileData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto + "')";
		this.getSPResult(SQL);
		new General().Quickmsg("GST & Drcr Ledger Posting Over..");
		rs.close();
		this.closeconn();

	}

	public void DNOnlyBulkGSTReposting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call   GST_OnlyDN_ReturnFileData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().Quickmsg("GST Posting Over..");

	}

	////// Sales
	public void SALESonlyBulkGSTReposting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call   GST_OnlySales_ReturnFileData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto
				+ "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void SRonlyBulkGSTReposting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call   GST_OnlySR_ReturnFileData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void CNOnlyBulkGSTReposting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call   GST_OnlyCN_ReturnFileData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().Quickmsg("GST Posting Over..");

	}

	public void SuplAdvOnlyBulkGSTReposting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call   GST_OnlySuplAdv_ReturnFileData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto
				+ "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().Quickmsg("GST Posting Over..");

	}

	public void CustAdvOnlyBulkGSTReposting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call   GST_OnlyCustAdv_ReturnFileData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto
				+ "')";
		// this.getSPResult(SQL) ;
		new General().Quickmsg("GST Posting Over..");
	}
	// End Gst Reposting Of Entries

	// Bulk Account Posting Start here
	public void PurchaseAcounting_BulkPosting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call   AcctBulkPosting_purchaseData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto
				+ "' , '" + vscheme + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().msg(" Accounting Entries Reposted..Sucessfully..");
	}

	public void POSSalesAcounting_BulkPosting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call   AcctBulkPosting_POSSalesData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto
				+ "' , '" + vscheme + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().msg(" Accounting Entries Reposted..Sucessfully..");
	}

	public void SRAcounting_BulkPosting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call   AcctBulkPosting_SRData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto + "' , '"
				+ vscheme + "')";
		this.getSPResult(SQL);
		new General().msg(" Accounting Entries Reposted..Sucessfully..");
		rs.close();
		this.closeconn();

	}

	public void PRAcounting_BulkPosting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call   AcctBulkPosting_PRData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto + "' , '"
				+ vscheme + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().msg(" Accounting Entries Reposted..Sucessfully..");
	}

	public void PaymentAcounting_BulkPosting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call   AcctBulkPosting_PaymentData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto
				+ "' , '" + vscheme + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().msg(" Accounting Entries Reposted..Sucessfully..");
	}

	public void ReceiptAcounting_BulkPosting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call   AcctBulkPosting_ReceiptData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto
				+ "' , '" + vscheme + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().msg(" Accounting Entries Reposted..Sucessfully..");
	}

	public void CONAcounting_BulkPosting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call   AcctBulkPosting_CONData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto + "' , '"
				+ vscheme + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().msg(" Accounting Entries Reposted..Sucessfully..");
	}

	public void ExpenseAcounting_BulkPosting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call   AcctBulkPosting_ExpenseData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto
				+ "' , '" + vscheme + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().msg(" Accounting Entries Reposted..Sucessfully..");
	}

	public void IncomeAcounting_BulkPosting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call   AcctBulkPosting_IncomeData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto
				+ "' , '" + vscheme + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().msg(" Accounting Entries Reposted..Sucessfully..");
	}

	public void SuplAdvAcounting_BulkPosting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call   AcctBulkPosting_SuplAdvData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto
				+ "' , '" + vscheme + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().msg(" Accounting Entries Reposted..Sucessfully..");
	}

	public void CustAdvAcounting_BulkPosting(String vfrom, String vto) throws Throwable {
		vfrom = new gnConfig().date_ConverttoDBforamt(vfrom);
		vto = new gnConfig().date_ConverttoDBforamt(vto);
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		String vscheme = "";
		vscheme = new gnGST().getMyGSTypeName();
		String SQL = "call   AcctBulkPosting_CustAdvData(" + vcomp + ", " + vstore + ", '" + vfrom + "', '" + vto
				+ "' , '" + vscheme + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
		new General().msg(" Accounting Entries Reposted..Sucessfully..");
	}
	// End Bulk Account Posting

	// Old Posting Logic is here--Account Reposting Statrs Here Till End

	public void processOtherPosting(String vdrgl, String vcrgl, String Pdoctype, String Pdocno, String Pdocdate,
			String vamount, String vnaration) throws Throwable {
		vDrglcode = vdrgl;
		vCrglcode = vcrgl;
		isledgerRun = "N";
		new gnAccounting().post_OtherVoucher(vDrglcode, vCrglcode, Pdoctype, Pdocno, Pdocdate, vamount, vnaration);
	}

	/*
	 * //=========Single Transaction Posting ===
	 * 
	 * 
	 * 
	 * public void processEntryPosting(String vparty , String Pdoctype , String
	 * Pdocno, String Pdocdate, String vamount) throws Throwable { isledgerRun =
	 * "N" ; String vcomp = new gnConfig().getCompanycode() ; String vstore =
	 * new gnConfig().getStoreID(); String vfinyear = new
	 * gnFinYear().getReportingFinYear() ; String vtype = "" ; String SQL = "" ;
	 * 
	 * // new General().msg("Process Account Entry Posting Passed Parameter is "
	 * + " "+Pdoctype + " "+Pdocno + " "+ Pdocdate + " "+vamount);
	 * switch(Pdoctype) { case "CASH-PURCHASE": vDrglcode = "1*088" ; vCrglcode
	 * = "1061" ; vtype = "PS" ; new
	 * gnAccounting().post_CashPurchasEntry(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount); break;
	 * 
	 * case "GRN": //new General().msg("Account posting Reached party is "+" "
	 * +vparty); vDrglcode = "1088" ; vCrglcode = vparty ; vtype = "GRN" ; new
	 * gnAccounting().post_PurchasCreditEntry(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount);
	 * 
	 * break;
	 * 
	 * 
	 * ///Sales Start From Here case "Retail" : vDrglcode = "1061" ; vCrglcode =
	 * "1071"; new gnAccounting().post_CashSalesEntry(vDrglcode, vCrglcode,
	 * Pdoctype, Pdocno, Pdocdate, vamount); break;
	 * 
	 * case "CREDIT-SALE" : vDrglcode = vparty ; vCrglcode = "1071"; new
	 * gnAccounting().post_CreditSalesEntry(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount); break;
	 * 
	 * //======= case "PR" : vDrglcode = vparty; vCrglcode = "1089" ; new
	 * gnAccounting().post_PurchasRetEntry(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount); break;
	 * 
	 * case "SR" : vDrglcode = "1072" ; vCrglcode = vparty ; new
	 * gnAccounting().post_SalesRetEntry(vDrglcode, vCrglcode, Pdoctype, Pdocno,
	 * Pdocdate, vamount); break;
	 * 
	 * case "Cash-SR" : vDrglcode = "1072" ; vCrglcode = "1061" ; new
	 * gnAccounting().post_CashSalesRetEntry(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount); break;
	 * 
	 * //Customer and Supplier Advance case "SUP-CASHPAY" : vDrglcode = vparty ;
	 * vCrglcode = "1061" ; new gnAccounting().post_AdvPaymentVoucher(vDrglcode,
	 * vCrglcode, Pdoctype, Pdocno, Pdocdate, vamount); break;
	 * 
	 * case "SUP-BANKPAY" : vDrglcode = vparty ; new General().msg(
	 * "Bank Selected is "+" "+vbankgl + " "+"And Party is :"+"-->"+vparty) ;
	 * vCrglcode = vbankgl ; new
	 * gnAccounting().post_AdvPaymentVoucher(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount); break;
	 * 
	 * case "CUS-CASHPAY" : vDrglcode = "1061" ; vCrglcode = vparty ; new
	 * gnAccounting().post_AdvReceiptVoucher(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount); break;
	 * 
	 * case "CUS-BANKPAY" : vDrglcode = new gnPublicVariable().vbankgl ;
	 * vCrglcode = vparty ; new gnAccounting().post_AdvReceiptVoucher(vDrglcode,
	 * vCrglcode, Pdoctype, Pdocno, Pdocdate, vamount); break;
	 * 
	 * //Payment & REceipts
	 * 
	 * case "PV-CASHPAY" : vDrglcode = vparty ; vCrglcode = "1061" ; new
	 * gnAccounting().post_PaymentVoucher(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount); break;
	 * 
	 * case "PV-BANKPAY" : vDrglcode = vparty ; vCrglcode = new
	 * gnPublicVariable().vbankgl ; new General().msg(vDrglcode + " "+
	 * vCrglcode); new gnAccounting().post_PaymentVoucher(vDrglcode, vCrglcode,
	 * Pdoctype, Pdocno, Pdocdate, vamount); break;
	 * 
	 * case "EX-CASHPAY" : vDrglcode = vparty ; vCrglcode = "1061" ; //new
	 * General().msg(vDrglcode + " "+ vCrglcode); new
	 * gnAccounting().post_ExpenseVoucher(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount); break;
	 * 
	 * case "EX-BANKPAY" : vDrglcode = vparty ; vCrglcode = new
	 * gnPublicVariable().vbankgl ; new
	 * gnAccounting().post_ExpenseVoucher(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount); break;
	 * 
	 * case "IN-CASHPAY" : vDrglcode = "1061" ; vCrglcode = vparty ; new
	 * gnAccounting().post_IncomeVoucher(vDrglcode, vCrglcode, Pdoctype, Pdocno,
	 * Pdocdate, vamount); break;
	 * 
	 * case "IN-BANKPAY" : vDrglcode = new gnPublicVariable().vbankgl ;
	 * vCrglcode = vparty ; new gnAccounting().post_IncomeVoucher(vDrglcode,
	 * vCrglcode, Pdoctype, Pdocno, Pdocdate, vamount); break;
	 * 
	 * 
	 * case "RV-CASHPAY" : vDrglcode = "1061" ; vCrglcode = vparty ; //new
	 * General().msg("Processing for CAsh Code 1061"+ " "+new
	 * gnPublicVariable().vbankgl); new
	 * gnAccounting().post_ReceiptVoucher(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount);
	 * 
	 * break;
	 * 
	 * case "RV-BANKPAY" : vDrglcode = new gnPublicVariable().vbankgl; vCrglcode
	 * = vparty ; new gnAccounting().post_ReceiptVoucher(vDrglcode, vCrglcode,
	 * Pdoctype, Pdocno, Pdocdate, vamount);
	 * 
	 * case "Contra": break; } }
	 * 
	 * //=========end Transaction Posting ===== //========Purchase Related Tax
	 * and Reverse charges =========== public void PurchaseTaxPosting(String
	 * vtaxtype , String Pdoctype , String Pdocno, String Pdocdate, String
	 * vamount) throws Throwable { isledgerRun = "N" ; //new
	 * General().msg(vtaxtype); switch(vtaxtype) { case "CGST" : vDrglcode =
	 * "1003" ; break ; case "SGST" : vDrglcode = "1004" ; break ; case "IGST" :
	 * vDrglcode = "1005" ; break ; } String vnaration = " "; new
	 * gnAccounting().post_purchaseTax(vDrglcode, vCrglcode, Pdoctype, Pdocno,
	 * Pdocdate, vamount , vnaration); }
	 * 
	 * public void ReversechrgTaxPosting(String vtaxtype , String Pdoctype ,
	 * String Pdocno, String Pdocdate, String vamount) throws Throwable {
	 * isledgerRun = "N" ; switch(vtaxtype) { case "CGST" : vCrglcode = "1006" ;
	 * break ; case "SGST" : vCrglcode = "1007" ; break ; case "IGST" :
	 * vCrglcode = "1008" ; break ; } String vnaration =
	 * "Tax Paid on Reverse Charge Purchase"; new
	 * gnAccounting().post_SalesTax(vDrglcode, vCrglcode, Pdoctype, Pdocno,
	 * Pdocdate, vamount , vnaration); }
	 * 
	 * 
	 * public void Reverse_ReversechrgTaxPosting(String vtaxtype , String
	 * Pdoctype , String Pdocno, String Pdocdate, String vamount) throws
	 * Throwable { isledgerRun = "N" ; switch(vtaxtype) { case "CGST" :
	 * vDrglcode = "1006" ; break ; case "SGST" : vDrglcode = "1007" ; break ;
	 * case "IGST" : vDrglcode = "1008" ; break ; } String vnaration =
	 * "Tax Reversal Due to Purchase Return "; new
	 * gnAccounting().post_purchaseTax(vDrglcode, vCrglcode, Pdoctype, Pdocno,
	 * Pdocdate, vamount , vnaration); }
	 * 
	 * 
	 * 
	 * public void PurchaseRetTaxPosting(String vtaxtype , String Pdoctype ,
	 * String Pdocno, String Pdocdate, String vamount) throws Throwable {
	 * isledgerRun = "N" ; // new General().msg(vtaxtype); switch(vtaxtype) {
	 * case "CGST" : vCrglcode = "1003" ; break ; case "SGST" : vCrglcode =
	 * "1004" ; break ; case "IGST" : vCrglcode = "1005" ; break ; } String
	 * vnaration = "Purchase Tax Return Due ti Returns"; new
	 * gnAccounting().post_SalesTax(vDrglcode, vCrglcode, Pdoctype, Pdocno,
	 * Pdocdate, vamount , vnaration); }
	 * 
	 * 
	 * 
	 * 
	 * public void RefundTaxPosting(String vtaxtype , String Pdoctype , String
	 * Pdocno, String Pdocdate, String vamount) throws Throwable { isledgerRun =
	 * "N" ; vDrglcode = "1065" ; String vnaration = "Reveser charg Refund" ;
	 * new gnAccounting().post_purchaseTax(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount , vnaration); }
	 * 
	 * 
	 * public void Reverse_RefundTaxPosting(String vtaxtype , String Pdoctype ,
	 * String Pdocno, String Pdocdate, String vamount) throws Throwable {
	 * isledgerRun = "N" ; vCrglcode = "1065" ; String vnaration =
	 * "Revese Tax Refund - Due to Purchase Return" ; new
	 * gnAccounting().post_SalesTax(vDrglcode, vCrglcode, Pdoctype, Pdocno,
	 * Pdocdate, vamount , vnaration); }
	 * 
	 * 
	 * 
	 * 
	 * ///Sales public void SalesTaxPosting(String vtaxtype , String Pdoctype ,
	 * String Pdocno, String Pdocdate, String vamount) throws Throwable {
	 * isledgerRun = "N" ; // new General().msg(vtaxtype); switch(vtaxtype) {
	 * case "CGST" : vCrglcode = "1006" ; break ; case "SGST" : vCrglcode =
	 * "1007" ; break ; case "IGST" : vCrglcode = "1008" ; break ; } String
	 * vnaration = "Tax Payable"; new gnAccounting().post_SalesTax(vDrglcode,
	 * vCrglcode, Pdoctype, Pdocno, Pdocdate, vamount , vnaration); }
	 * 
	 * 
	 * public void SalesRetTaxPosting(String vtaxtype , String Pdoctype , String
	 * Pdocno, String Pdocdate, String vamount) throws Throwable { isledgerRun =
	 * "N" ; // new General().msg(vtaxtype); switch(vtaxtype) { case "CGST" :
	 * vDrglcode = "1006" ; break ; case "SGST" : vDrglcode = "1007" ; break ;
	 * case "IGST" : vDrglcode = "1008" ; break ; } String vnaration =
	 * "Tax Reversal due to Sales Return"; new
	 * gnAccounting().post_purchaseTax(vDrglcode, vCrglcode, Pdoctype, Pdocno,
	 * Pdocdate, vamount , vnaration); }
	 * 
	 * 
	 * 
	 * 
	 * ///=====Stock Entry Posting ====== public void
	 * postStockAddAccountEntry(String Pdoctype , String Pdocno, String
	 * Pdocdate, String vamount) throws Throwable { isledgerRun = "N" ;
	 * vDrglcode = "1063" ; String vnaration =
	 * "Stock Added Due Purchase/ Sales return/ Adjustment"; //new
	 * gnAccounting().post_SalesTax(vDrglcode, vCrglcode, Pdoctype, Pdocno,
	 * Pdocdate, vamount , vnaration); new
	 * gnAccounting().post_addStockEntry(vDrglcode, vCrglcode, Pdoctype, Pdocno,
	 * Pdocdate, vamount , vnaration);
	 * 
	 * 
	 * }
	 * 
	 * public void postStockSubAccountEntry( String Pdoctype , String Pdocno,
	 * String Pdocdate, String vamount) throws Throwable { isledgerRun = "N" ;
	 * vCrglcode = "1063" ; String vnaration =
	 * "Stock Reduced Due To Sales / Purchase Return/ Stock Adj. "; // new
	 * gnAccounting().post_purchaseTax(vDrglcode, vCrglcode, Pdoctype, Pdocno,
	 * Pdocdate, vamount , vnaration); new
	 * gnAccounting().post_StockRedudeEntry(vDrglcode, vCrglcode, Pdoctype,
	 * Pdocno, Pdocdate, vamount , vnaration);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void ContraEntryPosting(String trtype , String vbankcode, String
	 * vparty , String vdocType, String vdocno, String vdocdate, String vamount)
	 * throws Throwable {
	 * 
	 * //Not in User This Old Logic Now Backend Posting is Happeing when
	 * transaction save based on bankTRansaction table
	 * 
	 * isledgerRun = "N" ; String vnaration=""; String Pdoctype = "CON" ; switch
	 * (trtype) { case "W" : switch(vdocType) { case "Cash": vCrglcode =
	 * vbankcode ; vDrglcode = "1061" ; vnaration = "Cash Widraw From Bank . ";
	 * new gnAccounting().post_OtherVoucher( vDrglcode , vCrglcode , Pdoctype ,
	 * vdocno , vdocdate , vamount , vnaration) ; break; case "NoCash":
	 * vDrglcode = "0" ; vCrglcode = vbankcode ; //Only Single Entry impact
	 * vnaration = "Widraw Amount From Bank With chq/dd "; new
	 * gnAccounting().post_SalesTax( vDrglcode , vCrglcode , Pdoctype , vdocno ,
	 * vdocdate , vamount , vnaration) ; break; } break ;
	 * 
	 * case "D" : switch(vdocType) { case "Cash": vDrglcode = vbankcode ;
	 * vCrglcode = "1061" ; vnaration = "Cash Deposited in Bank. "; new
	 * gnAccounting().post_OtherVoucher( vDrglcode , vCrglcode , Pdoctype ,
	 * vdocno , vdocdate , vamount , vnaration) ; break; case "NoCash":
	 * vDrglcode = vbankcode ; //Only Single Entry impact vCrglcode = "0" ;
	 * vnaration = "Amount Deposited using chq/dd option. "; new
	 * gnAccounting().post_purchaseTax( vDrglcode , vCrglcode , Pdoctype ,
	 * vdocno , vdocdate , vamount , vnaration) ; break; } break;
	 * 
	 * case "T" : vCrglcode = vbankcode ; vDrglcode = vparty ; vnaration =
	 * "Bank to Bank Transfer . "; new gnAccounting().post_OtherVoucher(
	 * vDrglcode , vCrglcode , Pdoctype , vdocno , vdocdate , vamount ,
	 * vnaration) ; break; } }
	 * 
	 * 
	 */

}// Last

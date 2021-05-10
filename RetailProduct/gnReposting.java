package RetailProduct;

import java.sql.ResultSet;
import java.sql.SQLException;

public class gnReposting extends getResultSet {

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

	public void processPostingEntries(String from, String to, String vtype) throws Throwable {

		switch (vtype) {

		case "GRN":
			BulkPurchaseGSTDataReposting(from, to); // DrcrLedger Entries
			BulkPurchaseAccountReposting(from, to);
			break;

		case "PR":
			BulkPRGSTDataReposting(from, to); // GST Data Only
			BulkDNGSTDataReposting(from, to); // Debit note Posting & Ledger
												// Data
			BulkPRAccountReposting(from, to);
			break;

		case "SALE":
			BulksaleGSTDataReposting(from, to);
			BulkPOSSalesAccountReposting(from, to);
			break;

		case "SR":
			BulkSRGSTDataReposting(from, to); // Sales Return GST File Data /
												// Ledger Data
			BulkCNGSTDataReposting(from, to); // Credit note Posting
			BulkSRAccountReposting(from, to); // Accounting Posring
			break;

		case "RV":
			BulkReceiptAccountReposting(from, to);
			break;

		case "PV":
			BulkPaymentAccountReposting(from, to);
			break;

		case "CO":
			BulkCONAccountReposting(from, to);
			break;

		case "SAD":
			BulkSuplAdvGSTDataReposting(from, to);
			BulkSuplAdvAccountReposting(from, to);
			break;

		case "CAD":
			BulkCustAdvGSTDataReposting(from, to);
			BulkCustAdvAccountReposting(from, to);
			break;

		case "IN":
			BulkIncomeAccountReposting(from, to);
			break;

		case "EX":
			BulkExpenseAccountReposting(from, to);
			break;

		}
	}

	// ===========Sale Bulk GST and Account Reposting=====
	private void BulkExpenseAccountReposting(String from, String to) throws Throwable {
		new General().Quickmsg("Posting Expens Account Entries ..");
		new gnBridge().ExpenseAcounting_BulkPosting(vfrom, vto);

	}

	private void BulkIncomeAccountReposting(String from, String to) throws Throwable {
		new General().Quickmsg("Posting Income Account Entries ..");
		new gnBridge().IncomeAcounting_BulkPosting(vfrom, vto);
	}

	private void BulkSuplAdvGSTDataReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting GST Entries ..");
		new gnBridge().SuplAdvOnlyBulkGSTReposting(vfrom, vto);
	}

	private void BulkSuplAdvAccountReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting Account Entries ..");
		new gnBridge().SuplAdvAcounting_BulkPosting(vfrom, vto);
	}

	private void BulkCustAdvGSTDataReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting GST Entries ..");
		new gnBridge().CustAdvOnlyBulkGSTReposting(vfrom, vto);
	}

	private void BulkCustAdvAccountReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting Account Entries ..");
		new gnBridge().CustAdvAcounting_BulkPosting(vfrom, vto);
	}

	private void BulkPRGSTDataReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting GST Entries  & Ledger Entries  For Purchase Return ..");
		new gnBridge().PROnlyBulkGSTReposting(vfrom, vto);
	}

	private void BulkDNGSTDataReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting Debit Note Details - For Purchase Return..");
		new gnBridge().DNOnlyBulkGSTReposting(vfrom, vto);
	}

	private void BulkPRAccountReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting Account Entries  For Purchase Return");
		new gnBridge().PRAcounting_BulkPosting(vfrom, vto);
	}

	private void BulkSRGSTDataReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting GSTt Entries ..");
		new gnBridge().SRonlyBulkGSTReposting(vfrom, vto);
	}

	private void BulkSRAccountReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting Account Entries ..");
		new gnBridge().SRAcounting_BulkPosting(vfrom, vto);
	}

	private void BulkCNGSTDataReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting Debit Note Details ..");
		new gnBridge().CNOnlyBulkGSTReposting(vfrom, vto);
	}

	private void BulkPurchaseGSTDataReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting GSTt Entries ..");
		new gnBridge().PurchaseOnlyBulkGSTReposting(vfrom, vto);
	}

	private void BulkPurchaseAccountReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting Account Entries ..");
		new gnBridge().PurchaseAcounting_BulkPosting(vfrom, vto);
	}

	private void BulksaleGSTDataReposting(String vfrom, String vto) throws Throwable {
		// new gnRepostingMiddleware().SalesModification( vdoctype, vdocno ,
		// vdocdate);
		new General().Quickmsg("Posting GSTt Entries ..");
		new gnBridge().SALESonlyBulkGSTReposting(vfrom, vto);
	}

	private void BulkPOSSalesAccountReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting Account Entries ..");
		new gnBridge().POSSalesAcounting_BulkPosting(vfrom, vto);
	}

	private void BulkPaymentAccountReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting Account Entries ..");
		new gnBridge().PaymentAcounting_BulkPosting(vfrom, vto);
	}

	private void BulkReceiptAccountReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting Account Entries ..");
		new gnBridge().ReceiptAcounting_BulkPosting(vfrom, vto);
	}

	private void BulkCONAccountReposting(String vfrom, String vto) throws Throwable {
		new General().Quickmsg("Posting Account Entries ..");
		new gnBridge().CONAcounting_BulkPosting(vfrom, vto);
	}

}// Last

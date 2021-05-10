package RetailProduct;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class gnAccounting extends getResultSet {

	private Connection con2, con3;

	private String vcomp;
	private String vstore;
	private String vdoctype;
	private String vdocno;
	private String vdocdate;
	private String vmyTransactionType;

	private String Dr_glcode;
	private String Dr_glcodename;
	private String Dr_vgrpcode;
	private String Dr_vgrpname;
	private String Dr_vsubgrpcode;
	private String Dr_vsubgrpname;
	private String dr_amt;
	private String Dr_voutype;
	private String vnaration = "";

	private String Cr_glcode;
	private String Cr_glcodename;
	private String Cr_vgrpcode;
	private String Cr_vgrpname;
	private String Cr_vsubgrpcode;
	private String Cr_vsubgrpname;
	private String cr_amt;
	private String Cr_voutype;

	private String DrType = "Dr";
	private String CrType = "Cr";

	public void postDoubleEntryForAll(String vdrgl, String vcrgl, String Pdoctype, String Pdocno, String Pdocdate,
			String vamount, String vvnaration) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = Pdoctype;

		Dr_glcode = vdrgl;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = Pdoctype;

		// Credit Entry Party Credit
		Cr_glcode = vcrgl;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		Cr_voutype = Pdoctype;
		vnaration = vvnaration;
		postnow();
	}

	public void postSingleCreditEntry(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno,
			String Pdocdate, String vamount, String vvnaration) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = Pdoctype;

		// ----Account -- Party Debit Purchase Return Ac Cr

		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		Cr_voutype = " ";
		vnaration = vvnaration;
		insertCreditEntry();
	}

	public void postSingleDebitEntry(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno,
			String Pdocdate, String vamount, String vvnaration) throws Throwable {
		// new General().msg("Now preparing Data fo purchase Passing" ) ;
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = Pdoctype;

		// ----Account -- Party Debit Purchase Return Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = Pdoctype;
		vnaration = vvnaration;
		insertDebitEntry();
	}

	// =======================
	public String getGlname(String vglcode) throws Throwable {
		String glname = "";
		String vcomp = new gnConfig().getCompanycode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vstore = new gnConfig().getStoreID();
		String SQL = "Call  Account_getGlInfo( " + vcomp + " , " + vstore + " , " + vglcode + " , '" + vfinyear + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			glname = rs.getString(2);
		}
		rs.close();
		this.closeconn();
		return glname;

	}

	public String getGroupname(String vglcode) throws Throwable {
		String vgrpname = "";
		String vcomp = new gnConfig().getCompanycode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vstore = new gnConfig().getStoreID();

		String SQL = "Call  Account_getGlInfo(" + vcomp + " , " + vstore + " , " + vglcode + " , '" + vfinyear + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vgrpname = rs.getString(6);
		}
		rs.close();
		this.closeconn();
		return vgrpname;
	}

	public String getGroupCode(String vglcode) throws Throwable {
		String vgrpcode = "";
		String vcomp = new gnConfig().getCompanycode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vstore = new gnConfig().getStoreID();

		String SQL = "Call  Account_getGlInfo( " + vcomp + " , " + vstore + " , " + vglcode + " , '" + vfinyear + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vgrpcode = rs.getString(4);
		}
		rs.close();
		this.closeconn();
		return vgrpcode;

	}

	public String getsubGroupCode(String vglcode) throws Throwable {
		String vsubgrpcode = "";
		String vcomp = new gnConfig().getCompanycode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vstore = new gnConfig().getStoreID();

		String SQL = "Call  Account_getGlInfo(" + vcomp + " , " + vstore + " , " + vglcode + " , '" + vfinyear + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vsubgrpcode = rs.getString(3);
		}
		rs.close();
		this.closeconn();
		return vsubgrpcode;

	}

	public String getsubGroupname(String vglcode) throws Throwable {
		String vsubgrpcodename = "";
		String vcomp = new gnConfig().getCompanycode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vstore = new gnConfig().getStoreID();

		String SQL = "Call  Account_getGlInfo( " + vcomp + " , " + vstore + " , " + vglcode + " , '" + vfinyear + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vsubgrpcodename = rs.getString(7);
		}
		rs.close();
		this.closeconn();
		return vsubgrpcodename;
	}

	public String getdrcrofGL(String vglcode) throws Throwable {
		String vdrcr = "";
		String vcomp = new gnConfig().getCompanycode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vstore = new gnConfig().getStoreID();
		String SQL = "Call  Account_getGlInfo( " + vcomp + " , " + vstore + " , " + vglcode + " , '" + vfinyear + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vdrcr = rs.getString(8);
		}
		rs.close();
		this.closeconn();
		return vdrcr;
	}

	public String getDrCrOFgroup(String vgroup) throws Throwable {
		String vdrcr = " ";
		String vcomp = new gnConfig().getCompanycode();
		String vstore = new gnConfig().getStoreID();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String SQL = "Call  Account_getdrcrofGroup('" + vgroup + "'  , " + vcomp + " , " + vstore + " , '" + vfinyear
				+ "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vdrcr = rs.getString(1);
		} else {
			vdrcr = "-";
		}
		rs.close();
		this.closeconn();
		return vdrcr;
	}

	/// Posting from here

	public void post_CashSalesEntry(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno, String Pdocdate,
			String vamount) throws Throwable {
		// Cash Purchase
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vexcltransactionAmount;
		// cr_amt = vamount;

		vmyTransactionType = "PS";
		// ----Account -- Sales Account & Cash A/c
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		// new General().msg(Dr_glcodename);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "Cash Sales";

		// new General().msg(vcomp+" "+vstore+" "+vdoctype+" "+vdocno+"
		// "+vdocdate+" "+dr_amt+" "+Dr_glcode+" "+Dr_glcodename+"
		// "+Dr_vsubgrpcode+" "+Dr_vsubgrpname+" "+Dr_vgrpcode+Dr_vgrpname) ;
		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		Cr_voutype = "Sales";
		vnaration = "Being Goods Sold in cash " + "" + Cr_glcodename;
		postnow();
	}

	public void post_CreditSalesEntry(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno,
			String Pdocdate, String vamount) throws Throwable {
		// Cash Purchase
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		// cr_amt = vamount;
		cr_amt = vexcltransactionAmount;

		vmyTransactionType = "WS";

		// ----Account -- Sales Account & party Ac Cr
		// vDrglcode = vDrglcode ;
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "";

		// Credit Entry Party Credit
		// vCrglcode = "1071";
		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		Cr_voutype = "Credit Sales";
		vnaration = "Being Goods Sold  on Credit  by supplier" + "" + Dr_glcodename;
		postnow();
	}

	public void post_SalesRetEntry(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno, String Pdocdate,
			String vamount) throws Throwable {
		// Cash Purchase
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		// dr_amt = vamount;
		dr_amt = vexcltransactionAmount;
		cr_amt = vamount;
		vmyTransactionType = "SR";

		// ----Account -- Sales Account & party Ac Cr
		// vDrglcode = "1072" ;
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "Sales Return";

		// Credit Entry Party Credit
		vCrglcode = vCrglcode;
		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		Cr_voutype = "Credit Note";
		vnaration = "Being Goods Return by Customer" + "" + Dr_glcodename;
		postnow();
	}

	public void post_CashSalesRetEntry(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno,
			String Pdocdate, String vamount) throws Throwable {
		// Cash Purchase
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		// dr_amt = vamount;
		dr_amt = vexcltransactionAmount;

		cr_amt = vamount;
		vmyTransactionType = "SR";

		// ----Account -- Sales Account & party Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "Sales Return";

		// Credit Entry Party Credit
		vCrglcode = vCrglcode;
		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		Cr_voutype = "Return Cash";
		vnaration = "Being  Sales Return  ";
		postnow();
	}

	public void post_CashPurchasEntry(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno,
			String Pdocdate, String vamount) throws Throwable {
		// Cash Purchase
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = "GRN";

		// ----Account -- purchase ac Dr party Ac Cr
		// vDrglcode = "1088" ;
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "Credit Purchase";

		// Credit Entry Party Credit
		// vCrglcode = "1061" ;
		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		Cr_voutype = "";
		vnaration = "Being Goods Purchase on Credit  by supplier" + "" + Cr_glcodename;
		postnow();
	}

	public void post_PurchasCreditEntry(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno,
			String Pdocdate, String vamount) throws Throwable {

		// new General().msg("Purchase Posting "+ " "+vDrglcode+ " "+
		// vCrglcode);
		// this is for credit Paurchase
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		// dr_amt = vamount;
		dr_amt = vexcltransactionAmount;
		cr_amt = vamount;
		vmyTransactionType = "GRN";

		// ----Account -- purchase ac Dr party Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "Credit Purchase";

		// Credit Entry Party Credit
		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		Cr_voutype = "";
		vnaration = "Being Goods Purchase on Credit  from  supplier" + "" + Cr_glcodename;
		postnow();
	}

	public void post_PurchasRetEntry(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno,
			String Pdocdate, String vamount) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		// cr_amt = vamount;
		cr_amt = vexcltransactionAmount;
		new General().msg("Excl Amount is" + " -->" + cr_amt);
		vmyTransactionType = "PR";

		// ----Account -- Party Debit Purchase Return Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "Debit  Note";

		// vCrglcode = "1088" ;
		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		Cr_voutype = "Goods Return";
		vnaration = "Being Goods Retrun  to Supplier" + "" + Dr_glcodename;

		postnow();
	}

	public void post_AdvPaymentVoucher(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno,
			String Pdocdate, String vamount) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = "SAD";

		// ----Account -- Party Debit Purchase Return Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "Supplier Advance";

		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		switch (vdoctype) {
		case "SUP-CASHPAY":
			Cr_voutype = "Cash Payment";
			break;
		case "SUP-BANKPAY":
			Cr_voutype = "Bank Payment";
		}
		vnaration = "Adance paid to supplier for purchase to" + "" + Dr_glcodename;

		postnow();
	}

	public void post_AdvReceiptVoucher(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno,
			String Pdocdate, String vamount) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = "CAD";

		// ----Account -- Party Debit Purchase Return Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "Customer Advance";

		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		switch (vdoctype) {
		case "CUS-CASHPAY":
			Cr_voutype = "Cash Received";
			break;
		case "CUS-BANKPAY":
			Cr_voutype = "Bank Receipts";
		}
		vnaration = "Adance Receipt from customer for Sales";

		postnow();
	}

	public void post_ExpenseVoucher(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno, String Pdocdate,
			String vamount) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = "EX";
		// ----Account -- Party Debit Purchase Return Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "Expenses Paid ";

		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		switch (vdoctype) {
		case "SUP-CASHPAY":
			Cr_voutype = "Cash Payment";
			break;
		case "SUP-BANKPAY":
			Cr_voutype = "Bank Payment";
		}
		vnaration = "Expense Payment made to Party" + "   " + Dr_glcodename;

		postnow();
	}

	public void post_PaymentVoucher(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno, String Pdocdate,
			String vamount) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = "PV";
		// ----Account -- Party Debit Purchase Return Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "Supplier Payents";

		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		switch (vdoctype) {
		case "SUP-CASHPAY":
			Cr_voutype = "Cash Payment";
			break;
		case "SUP-BANKPAY":
			Cr_voutype = "Bank Payment";
		}
		vnaration = "Payment made to Party" + "   " + Dr_glcodename;

		postnow();
	}

	public void post_ReceiptVoucher(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno, String Pdocdate,
			String vamount) throws Throwable {

		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = "RV";

		// ----Account -- Party Debit Purchase Return Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "Customer Payments ";

		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		switch (vdoctype) {
		case "RV-CASHPAY":
			Cr_voutype = "Cash Received";
			break;
		case "RV-BANKPAY":
			Cr_voutype = "Bank Receipts";
		}
		vnaration = "Adance Receipt from customer for Sales";

		postnow();
	}

	public void post_IncomeVoucher(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno, String Pdocdate,
			String vamount) throws Throwable {

		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = "IN";

		// ----Account -- Party Debit Purchase Return Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = "Customer Payments ";

		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		switch (vdoctype) {
		case "RV-CASHPAY":
			Cr_voutype = "Cash Received";
			break;
		case "RV-BANKPAY":
			Cr_voutype = "Bank Receipts";
		}
		vnaration = "Income Received ";

		postnow();
	}

	public void post_OtherVoucher(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno, String Pdocdate,
			String vamount, String vvnaration) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = Pdoctype;

		// ----Account -- Party Debit Purchase Return Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = Pdoctype;

		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		Cr_voutype = " ";
		vnaration = vvnaration;
		postnow();
	}

	// Stock Posting

	public void post_addStockEntry(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno, String Pdocdate,
			String vamount, String vvnaration) throws Throwable {
		// new General().msg("Now preparing Data fo purchase Passing" ) ;
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = Pdoctype;

		// ----Account -- Party Debit Purchase Return Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = Pdoctype;
		vnaration = vvnaration;
		PassPurTaxtEntry();
	}

	public void post_StockRedudeEntry(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno,
			String Pdocdate, String vamount, String vvnaration) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = Pdoctype;

		// ----Account -- Party Debit Purchase Return Ac Cr

		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		Cr_voutype = " ";
		vnaration = vvnaration;
		PassSalesTaxEntry();

	}

	// End Stock Posting

	/// Tax Posting

	public void post_SalesTax(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno, String Pdocdate,
			String vamount, String vvnaration) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = Pdoctype;

		// ----Account -- Party Debit Purchase Return Ac Cr

		Cr_glcode = vCrglcode;
		Cr_glcodename = getGlname(Cr_glcode);
		Cr_vsubgrpcode = getsubGroupCode(Cr_glcode);
		Cr_vsubgrpname = getsubGroupname(Cr_glcode);
		Cr_vgrpcode = getGroupCode(Cr_glcode);
		Cr_vgrpname = getGroupname(Cr_glcode);
		Cr_voutype = " ";
		vnaration = vvnaration;
		PassSalesTaxEntry();

	}

	public void PassSalesTaxEntry() throws Throwable {
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con3 = (Connection) this.getConnection();
		con3.setAutoCommit(false);
		String DBhdr1 = "Fail";
		String poshdr = "Insert into account_gen_gournal (company_code , " + "site_code,  doctype , voutype ,"
				+ " docno, docdate, glcode," + " glname, amount, type , " + " acc_grpcode, acc_grpname, acc_subgrpcode,"
				+ "acc_subgrpname, naration, myTransactionType , srno , paymentmode, instrumentno, instrumentDate , finyear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? , ?,?,? ,?)";
		try {
			prst = con3.prepareStatement(poshdr);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, vdoctype);
			prst.setString(4, Cr_voutype);
			prst.setString(5, vdocno);
			prst.setString(6, new gnConfig().date_ConverttoDBforamt(vdocdate));
			prst.setString(7, Cr_glcode);
			prst.setString(8, Cr_glcodename);
			prst.setString(9, cr_amt);
			prst.setString(10, CrType);
			prst.setString(11, Cr_vgrpcode);
			prst.setString(12, Cr_vgrpname);
			prst.setString(13, Cr_vsubgrpcode);
			prst.setString(14, Cr_vsubgrpname);
			prst.setString(15, vnaration);
			prst.setString(16, vmyTransactionType);
			if (vmyTransactionType == "CON") {
				prst.setString(17, "1");
			} else {
				prst.setString(17, "0");
			}
			prst.setString(18, this.vpaymenmode);
			prst.setString(19, this.vchqddno);
			prst.setString(20, this.vchqdddate);
			prst.setString(21, new gnFinYear().getCurrentFinYear(vdocdate));
			prst.addBatch();

			TotalRecordinsert = TotalRecordinsert + 1;
			DBhdr1 = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr1 = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBhdr1 = "Sucess";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con3.rollback();
			DBhdr1 = "Fail";
			new General().msg("Journal Credit Detail:" + e.getMessage());
			System.out.println(e.getMessage());

		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr1 == "Sucess") {
				con3.commit();
				con3.close();
				refresh();
			}
		}
	}//// Sales tax Posting to table

	public void post_purchaseTax(String vDrglcode, String vCrglcode, String Pdoctype, String Pdocno, String Pdocdate,
			String vamount, String vvnaration) throws Throwable {
		// new General().msg("Now preparing Data fo purchase Passing" ) ;
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdoctype = Pdoctype;
		vdocno = Pdocno;
		vdocdate = Pdocdate;
		dr_amt = vamount;
		cr_amt = vamount;
		vmyTransactionType = Pdoctype;

		// ----Account -- Party Debit Purchase Return Ac Cr
		Dr_glcode = vDrglcode;
		Dr_glcodename = getGlname(Dr_glcode);
		Dr_vsubgrpcode = getsubGroupCode(Dr_glcode);
		Dr_vsubgrpname = getsubGroupname(Dr_glcode);
		Dr_vgrpcode = getGroupCode(Dr_glcode);
		Dr_vgrpname = getGroupname(Dr_glcode);
		Dr_voutype = Pdoctype;
		vnaration = vvnaration;
		PassPurTaxtEntry();
	}

	public String PassPurTaxtEntry() throws Throwable {
		// new General().msg("Now preparing Data fo purchase Passing" ) ;
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con2 = (Connection) this.getConnection();
		con2.setAutoCommit(false);
		String DBhdr = "Fail";
		String poshdr = "Insert into account_gen_gournal (company_code , " + "site_code,  doctype , voutype  ,"
				+ " docno, docdate  , glcode ," + "glname ,  amount ,   type  , "
				+ "acc_grpcode ,  acc_grpname , acc_subgrpcode ,"
				+ "acc_subgrpname, naration, myTransactionType, srno, paymentmode, instrumentno, instrumentDate, Finyear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con2.prepareStatement(poshdr);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, vdoctype);
			prst.setString(4, Dr_voutype);
			prst.setString(5, vdocno);
			prst.setString(6, new gnConfig().date_ConverttoDBforamt(vdocdate));
			prst.setString(7, Dr_glcode);
			prst.setString(8, Dr_glcodename);
			prst.setString(9, dr_amt);
			prst.setString(10, DrType);
			prst.setString(11, Dr_vgrpcode);
			prst.setString(12, Dr_vgrpname);
			prst.setString(13, Dr_vsubgrpcode);
			prst.setString(14, Dr_vsubgrpname);
			prst.setString(15, vnaration);
			prst.setString(16, vmyTransactionType);
			if (vmyTransactionType == "CON") {
				prst.setString(17, "1");
			} else {
				prst.setString(17, "0");
			}
			prst.setString(18, this.vpaymenmode);
			prst.setString(19, this.vchqddno);
			prst.setString(20, this.vchqdddate);
			prst.setString(21, new gnFinYear().getCurrentFinYear(vdocdate));

			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBhdr = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBhdr = "Sucess";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con2.rollback();
			DBhdr = "Fail";
			new General().msg("Journal Debit entery:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") {
				con2.commit();
				con2.close();
			}
		}
		return DBhdr;
	}//// Insert Debit Entry

	private void postnow() throws Throwable {
		PassDebitEntry();
	}

	/// ==================================Main Section Nitin===================

	public String PassDebitEntry() throws Throwable {
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con2 = (Connection) this.getConnection();
		con2.setAutoCommit(false);
		String DBhdr = "Fail";
		String poshdr = "Insert into account_gen_gournal (company_code , " + "site_code,  doctype , voutype  ,"
				+ " docno, docdate  , glcode ," + "glname ,  amount ,   type  , "
				+ "acc_grpcode ,  acc_grpname , acc_subgrpcode ,"
				+ "acc_subgrpname, naration, myTransactionType,srno , paymentmode, instrumentno, instrumentDate, finyear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con2.prepareStatement(poshdr);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, vdoctype);
			prst.setString(4, Dr_voutype);
			prst.setString(5, vdocno);
			prst.setString(6, new gnConfig().date_ConverttoDBforamt(vdocdate));
			prst.setString(7, Dr_glcode);
			prst.setString(8, Dr_glcodename);
			prst.setString(9, dr_amt);
			prst.setString(10, DrType);
			prst.setString(11, Dr_vgrpcode);
			prst.setString(12, Dr_vgrpname);
			prst.setString(13, Dr_vsubgrpcode);
			prst.setString(14, Dr_vsubgrpname);
			prst.setString(15, vnaration);
			prst.setString(16, vmyTransactionType);
			prst.setString(17, "1");
			prst.setString(18, this.vpaymenmode);
			prst.setString(19, this.vchqddno);
			prst.setString(20, this.vchqdddate);
			prst.setString(21, new gnFinYear().getCurrentFinYear(vdocdate));
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBhdr = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBhdr = "Sucess";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con2.rollback();
			DBhdr = "Fail";
			new General().msg("Journal Debit entery:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") {
				PassCreditEntry();
				// con2.commit();
				// con2.close();
			}
		}
		return DBhdr;
	}//// Insert Debit Entry

	public void PassCreditEntry() throws Throwable {
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con3 = (Connection) this.getConnection();
		con3.setAutoCommit(false);
		String DBhdr1 = "Fail";
		String poshdr = "Insert into account_gen_gournal (company_code , " + "site_code,  doctype , voutype ,"
				+ " docno, docdate, glcode," + " glname, amount, type , " + " acc_grpcode, acc_grpname, acc_subgrpcode,"
				+ "acc_subgrpname, naration, myTransactionType,srno, paymentmode, instrumentno, instrumentDate , Finyear) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?)";
		try {
			prst = con3.prepareStatement(poshdr);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, vdoctype);
			prst.setString(4, Cr_voutype);
			prst.setString(5, vdocno);
			prst.setString(6, new gnConfig().date_ConverttoDBforamt(vdocdate));
			prst.setString(7, Cr_glcode);
			prst.setString(8, Cr_glcodename);
			prst.setString(9, cr_amt);
			prst.setString(10, CrType);
			prst.setString(11, Cr_vgrpcode);
			prst.setString(12, Cr_vgrpname);
			prst.setString(13, Cr_vsubgrpcode);
			prst.setString(14, Cr_vsubgrpname);
			prst.setString(15, vnaration);
			prst.setString(16, vmyTransactionType);
			prst.setString(17, "0");
			prst.setString(18, this.vpaymenmode);
			prst.setString(19, this.vchqddno);
			prst.setString(20, this.vchqdddate);
			prst.setString(21, new gnFinYear().getCurrentFinYear(vdocdate));
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBhdr1 = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr1 = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBhdr1 = "Sucess";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con3.rollback();
			DBhdr1 = "Fail";
			new General().msg("Journal Credit Detail:" + e.getMessage());
			System.out.println(e.getMessage());

		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr1 == "Sucess") {
				con2.commit();
				con3.commit();
				con2.close();
				con3.close();
				refresh();
				// new General().msg("Document Posted sucessfully");
			}
		}
	}//// End Entry

	public void insertCreditEntry() throws Throwable {
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con3 = (Connection) this.getConnection();
		con3.setAutoCommit(false);
		String DBhdr1 = "Fail";
		String poshdr = "Insert into account_gen_gournal (company_code , " + "site_code,  doctype , voutype ,"
				+ " docno, docdate, glcode," + " glname, amount, type , " + " acc_grpcode, acc_grpname, acc_subgrpcode,"
				+ "acc_subgrpname, naration, myTransactionType, Finyear, srno) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con3.prepareStatement(poshdr);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, vdoctype);
			prst.setString(4, Cr_voutype);
			prst.setString(5, vdocno);
			prst.setString(6, new gnConfig().date_ConverttoDBforamt(vdocdate));
			prst.setString(7, Cr_glcode);
			prst.setString(8, Cr_glcodename);
			prst.setString(9, cr_amt);
			prst.setString(10, CrType);
			prst.setString(11, Cr_vgrpcode);
			prst.setString(12, Cr_vgrpname);
			prst.setString(13, Cr_vsubgrpcode);
			prst.setString(14, Cr_vsubgrpname);
			prst.setString(15, vnaration);
			prst.setString(16, vmyTransactionType);
			prst.setString(17, new gnFinYear().getCurrentFinYear(vdocdate));
			prst.setString(18, "0");

			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBhdr1 = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr1 = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBhdr1 = "Sucess";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con3.rollback();
			DBhdr1 = "Fail";
			new General().msg("Journal Credit Detail:" + e.getMessage());
			System.out.println(e.getMessage());

		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr1 == "Sucess") {
				con3.commit();
				con3.close();
				refresh();
			}
		}
	}//// Sales tax Posting to table

	public String insertDebitEntry() throws Throwable {
		// new General().msg("Now preparing Data fo purchase Passing" ) ;
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con2 = (Connection) this.getConnection();
		con2.setAutoCommit(false);
		String DBhdr = "Fail";
		String poshdr = "Insert into account_gen_gournal (company_code , " + "site_code,  doctype , voutype  ,"
				+ " docno, docdate  , glcode ," + "glname ,  amount ,   type  , "
				+ "acc_grpcode ,  acc_grpname , acc_subgrpcode ,"
				+ "acc_subgrpname, naration, myTransactionType , FinYear, srno) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?)";
		try {
			prst = con2.prepareStatement(poshdr);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, vdoctype);
			prst.setString(4, Dr_voutype);
			prst.setString(5, vdocno);
			prst.setString(6, new gnConfig().date_ConverttoDBforamt(vdocdate));
			prst.setString(7, Dr_glcode);
			prst.setString(8, Dr_glcodename);
			prst.setString(9, dr_amt);
			prst.setString(10, DrType);
			prst.setString(11, Dr_vgrpcode);
			prst.setString(12, Dr_vgrpname);
			prst.setString(13, Dr_vsubgrpcode);
			prst.setString(14, Dr_vsubgrpname);
			prst.setString(15, vnaration);
			prst.setString(16, vmyTransactionType);
			prst.setString(17, new gnFinYear().getCurrentFinYear(vdocdate));
			prst.setString(18, "1");
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			DBhdr = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBhdr = "Sucess";
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con2.rollback();
			DBhdr = "Fail";
			new General().msg("Journal Debit entery:" + e.getMessage());
			System.out.println(e.getMessage());
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") {
				con2.commit();
				con2.close();
			}
		}
		return DBhdr;
	}//// Insert Debit Entry

	// ============================================================
	private void refresh() {
		vcomp = "";
		vstore = "";
		vdoctype = "";
		vdocno = "";
		vdocdate = "";
		vmyTransactionType = "";
		Dr_glcode = "";
		Dr_glcodename = "";
		Dr_vgrpcode = "";
		Dr_vgrpname = "";
		Dr_vsubgrpcode = "";
		Dr_vsubgrpname = "";
		dr_amt = "";
		Dr_voutype = "";
		vnaration = "";

		Cr_glcode = "";
		Cr_glcodename = "";
		Cr_vgrpcode = "";
		Cr_vgrpname = "";
		Cr_vsubgrpcode = "";
		Cr_vsubgrpname = "";
		cr_amt = "";
		Cr_voutype = "";

	}

}// Last

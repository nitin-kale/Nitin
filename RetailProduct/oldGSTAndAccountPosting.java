package RetailProduct;

public class oldGSTAndAccountPosting extends getResultSet {

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

	public oldGSTAndAccountPosting() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * 
	 * 
	 * //+++++++++Old Logic from front EndPosting ========================
	 * public void gstGRNProcess(String vparty, String vdocno, String vdocdate,
	 * String vamount) throws Throwable { isledgerRun = "N" ; vcomp = new
	 * gnConfig().getCompanyCode() ; vstore = new gnConfig().getStoreID();
	 * vmethod = "GRRegular" ; vdoctype = "GRN" ; new
	 * gnPosting().postGstEntries(vdocno , vdoctype , vmethod , vdocdate);
	 * //vdoctype= "GR" ; new gnPosting().postSundrydrcr(vdocno , vdocdate
	 * ,vdoctype); vdoctype = "GRN" ; String vvamount = new
	 * gnGST_getInclusiveExclusiveAmount().Purchase_getExclusiveAmount(vdocno,
	 * vdocdate, vdoctype) ; vexcltransactionAmount = vvamount ; //new
	 * General().msg(vvamount);
	 * 
	 * String Vmyscheme = new gnGST().gst_getmytaxschemecode();
	 * switch(Vmyscheme) { case "2" : new gnBridge().processEntryPosting(vparty
	 * , vdoctype, vdocno, vdocdate, vamount); new
	 * gnBridge().postStockAddAccountEntry(vdoctype, vdocno, vdocdate,
	 * vvamount); break ;
	 * 
	 * case "1" : vexcltransactionAmount = vamount ; new
	 * gnBridge().processEntryPosting(vparty , vdoctype, vdocno, vdocdate,
	 * vamount); new gnBridge().postStockAddAccountEntry(vdoctype, vdocno,
	 * vdocdate, vamount); break ;
	 * 
	 * case "0" : vexcltransactionAmount = vamount ; new
	 * gnBridge().processEntryPosting(vparty , vdoctype, vdocno, vdocdate,
	 * vamount); new gnBridge().postStockAddAccountEntry(vdoctype, vdocno,
	 * vdocdate, vamount); break ;
	 * 
	 * } //Tax Posting Start From Here switch(Vmyscheme ) { case "2" : String
	 * Vscheme = new gnGST().getSupplierSchemecode(vparty); switch(Vscheme) {
	 * case "2" : vcgst = new gnAccountbase().getCgstTaxamt(vdoctype, vdocno,
	 * vdocdate); vtaxtype = "CGST" ; new gnBridge().PurchaseTaxPosting(vtaxtype
	 * , vdoctype, vdocno, vdocdate, vcgst);
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; new gnBridge().PurchaseTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vsgst);
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; new gnBridge().PurchaseTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vigst); break ;
	 * 
	 * case "1" :
	 * 
	 * vcgst = new gnAccountbase().getCgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "CGST" ; new gnBridge().PurchaseTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vcgst);
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; new gnBridge().PurchaseTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vsgst);
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; new gnBridge().PurchaseTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vigst);
	 * 
	 * break ;
	 * 
	 * 
	 * case "0" : //Post Reverse Charge in this Case input tax gl wil not impact
	 * rather output tax will impact and refung gl will impact
	 * 
	 * vcgst = new gnAccountbase().getCgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "CGST" ; new gnBridge().ReversechrgTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vcgst);
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; new gnBridge().ReversechrgTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vsgst);
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; new gnBridge().ReversechrgTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vigst);
	 * 
	 * Double vtaxcgst = Double.parseDouble(vcgst); Double vtaxsgst =
	 * Double.parseDouble(vsgst); Double vtaxigst = Double.parseDouble(vigst);
	 * Double vtaxamt1 = vtaxcgst+vtaxigst+vtaxsgst ; String vrevchrgTaxamt =
	 * Double.toString(vtaxamt1) ; new gnBridge(). RefundTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vrevchrgTaxamt); break ; } break; case "1" :
	 * Vscheme = new gnGST().getSupplierSchemecode(vparty); // new
	 * General().msg(Vscheme); switch(Vscheme) { case "0" : //Post Reverse
	 * Charge in this Case input tax gl wil not impact rather output tax will
	 * impact and refung gl will impact
	 * 
	 * vcgst = new gnAccountbase().getCgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "CGST" ; new gnBridge().ReversechrgTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vcgst);
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; new gnBridge().ReversechrgTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vsgst);
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; new gnBridge().ReversechrgTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vigst);
	 * 
	 * Double vtaxcgst = Double.parseDouble(vcgst); Double vtaxsgst =
	 * Double.parseDouble(vsgst); Double vtaxigst = Double.parseDouble(vigst);
	 * Double vtaxamt1 = vtaxcgst+vtaxigst+vtaxsgst ; String vrevchrgTaxamt =
	 * Double.toString(vtaxamt1) ; new gnBridge(). RefundTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vrevchrgTaxamt); break ; } break; } }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public void gstPOSSalesProcess(String vparty, String vdocno, String
	 * vdocdate, String vamount) throws Throwable { //This is used front end not
	 * in use now in case any problem use this isledgerRun = "N" ; // new
	 * General().msg(vdocno+" "+vdocdate+ " "+vamount); vcomp = new
	 * gnConfig().getCompanyCode() ; vstore = new gnConfig().getStoreID();
	 * vmethod = "SALRegular" ; vsalestype = "PS" ;
	 * 
	 * //new General().msg("Posting GST Entry Now") ; new
	 * gnPosting().postGstEntries(vdocno, vsalestype, vmethod, vdocdate);
	 * 
	 * String vvamount = new
	 * gnGST_getInclusiveExclusiveAmount().Sales_getExclusiveAmount(vdocno,
	 * vdocdate, vdoctype) ; vexcltransactionAmount = vvamount;
	 * 
	 * String Vscheme = new gnGST().gst_getmytaxschemecode(); switch(Vscheme) {
	 * case "2" : new gnBridge().processEntryPosting(vparty, vsalestype, vdocno,
	 * vdocdate, vamount); vdoctype = "SALE" ; String vStockamount = new
	 * gnAccountbase().getCogs(vdoctype, vdocno, vdocdate) ; vdoctype = "PS" ;
	 * new gnBridge().postStockSubAccountEntry(vdoctype, vdocno, vdocdate,
	 * vStockamount); break ;
	 * 
	 * case "1" : vexcltransactionAmount = vamount ; new
	 * gnBridge().processEntryPosting(vparty, vsalestype, vdocno, vdocdate,
	 * vamount); vdoctype = "SALE" ; vStockamount = new
	 * gnAccountbase().getCogs(vdoctype, vdocno, vdocdate) ; vdoctype = "PS" ;
	 * new gnBridge().postStockSubAccountEntry(vdoctype, vdocno, vdocdate,
	 * vStockamount); break ;
	 * 
	 * case "0" : vexcltransactionAmount = vamount ; new
	 * gnBridge().processEntryPosting(vparty, vsalestype, vdocno, vdocdate,
	 * vamount); vdoctype = "SALE" ; vStockamount = new
	 * gnAccountbase().getCogs(vdoctype, vdocno, vdocdate) ; vdoctype = "PS" ;
	 * new gnBridge().postStockSubAccountEntry(vdoctype, vdocno, vdocdate,
	 * vStockamount); break ; }
	 * 
	 * //Tax Posting Start From Here switch(Vscheme) { case "2" : vdoctype =
	 * "SALE" ; vsalestype = "PS" ;
	 * 
	 * vcgst = new gnAccountbase().getCgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "CGST" ; if (Double.parseDouble(vcgst) > 0.00) { new
	 * gnBridge().SalesTaxPosting(vtaxtype , vsalestype, vdocno, vdocdate,
	 * vcgst); }
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; if (Double.parseDouble(vsgst) > 0.00) { new
	 * gnBridge().SalesTaxPosting(vtaxtype , vsalestype, vdocno, vdocdate,
	 * vsgst); }
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; if (Double.parseDouble(vigst) > 0.00) { new
	 * gnBridge().SalesTaxPosting(vtaxtype , vsalestype, vdocno, vdocdate,
	 * vigst); } break ;
	 * 
	 * case "0" : break ;
	 * 
	 * case "1" : break ; } //End Tax Posting Start From Here }
	 * 
	 * 
	 * 
	 * public void gstCreditSaleProcess(String vparty, String vdocno, String
	 * vdocdate, String vamount) throws Throwable { isledgerRun = "N" ; vcomp =
	 * new gnConfig().getCompanyCode() ; vstore = new gnConfig().getStoreID();
	 * vmethod = "SALRegular" ; vsalestype = "WS" ; vdoctype = "SAL" ; new
	 * gnPosting().postGstEntries(vdocno, vsalestype, vmethod, vdocdate); new
	 * gnPosting().postSundrydrcr(vdocno , vdocdate ,vdoctype);
	 * 
	 * vdoctype = "SALE" ; String vStockamount = new
	 * gnAccountbase().getCogs(vdoctype, vdocno, vdocdate) ;
	 * 
	 * vdoctype = "WS" ; new gnBridge().postStockSubAccountEntry(vdoctype,
	 * vdocno, vdocdate, vStockamount); /// Journal Leger Posting vdoctype =
	 * "CREDIT-SALE" ;
	 * 
	 * String vvamount = new
	 * gnGST_getInclusiveExclusiveAmount().Sales_getExclusiveAmount(vdocno,
	 * vdocdate, vdoctype) ; vexcltransactionAmount = vvamount ; //new
	 * General().msg(vvamount); new gnBridge().processEntryPosting(vparty,
	 * vdoctype, vdocno, vdocdate , vamount);
	 * 
	 * 
	 * 
	 * //Tax Posting Start From Here String Vscheme = new
	 * gnGST().gst_getmytaxschemecode(); // new General().msg(Vscheme);
	 * switch(Vscheme) { case "2" : vdoctype = "SALE" ;
	 * 
	 * vcgst = new gnAccountbase().getCgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "CGST" ; if (Double.parseDouble(vcgst) > 0.00) { new
	 * gnBridge().SalesTaxPosting(vtaxtype , vsalestype, vdocno, vdocdate,
	 * vcgst); }
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; if (Double.parseDouble(vsgst) > 0.00) { new
	 * gnBridge().SalesTaxPosting(vtaxtype , vsalestype, vdocno, vdocdate,
	 * vsgst); }
	 * 
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; if (Double.parseDouble(vigst) > 0.00) { new
	 * gnBridge().SalesTaxPosting(vtaxtype , vsalestype, vdocno, vdocdate,
	 * vigst); } break ;
	 * 
	 * case "0" : break ;
	 * 
	 * case "1" : break ;
	 * 
	 * 
	 * } //End Tax Posting Start From Here
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * public void gstSRprocess(String vparty, String vdocno, String vdocdate,
	 * String vamount , String vchoice) throws Throwable { vmethod = "SRRegular"
	 * ; vsalestype = "SR" ; vdoctype = "Cash-SR" ; String vvamount="" ;
	 * isledgerRun = "N" ; new gnPosting().postGstEntries(vdocno, vsalestype ,
	 * vmethod , vdocdate ); vvamount = new
	 * gnGST_getInclusiveExclusiveAmount().SR_getExclusiveAmount(vdocno,
	 * vdocdate, vdoctype) ; vexcltransactionAmount = vvamount ; String
	 * vStockamount = new gnAccountbase().getCogs(vsalestype, vdocno, vdocdate)
	 * ; new gnBridge().postStockAddAccountEntry(vsalestype, vdocno, vdocdate,
	 * vStockamount); switch(vchoice) { case "Cash" : new
	 * gnBridge().processEntryPosting(vparty, vdoctype, vdocno, vdocdate,
	 * vamount); break; case "CN" : new gnBridge().processEntryPosting(vparty,
	 * vsalestype, vdocno, vdocdate, vamount); break; }
	 * 
	 * 
	 * //Tax Posting Start From Here String Vscheme = new
	 * gnGST().gst_getmytaxschemecode(); switch(Vscheme) { case "2" : vdoctype2
	 * = "SR" ;
	 * 
	 * vcgst = new gnAccountbase().getCgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * Double vvcgst = Double.parseDouble(vcgst)*-1 ; vcgst =
	 * Double.toString(vvcgst) ; if (vvcgst > 0 ) { vtaxtype = "CGST" ; new
	 * gnBridge().SalesRetTaxPosting(vtaxtype , vsalestype, vdocno, vdocdate,
	 * vcgst); }
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * Double vvsgst = Double.parseDouble(vsgst)*-1 ; vsgst =
	 * Double.toString(vvsgst) ; if (vvsgst > 0 ) { vtaxtype = "SGST" ; new
	 * gnBridge().SalesRetTaxPosting(vtaxtype , vsalestype, vdocno, vdocdate,
	 * vsgst); }
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * Double vvigst = Double.parseDouble(vigst)*-1 ; vigst =
	 * Double.toString(vvigst) ; if (vvigst > 0 ) { vtaxtype = "IGST" ; new
	 * gnBridge().SalesRetTaxPosting(vtaxtype , vsalestype, vdocno, vdocdate,
	 * vigst); } break ;
	 * 
	 * case "0" : break ;
	 * 
	 * case "1" : break ;
	 * 
	 * } //End Tax Posting Start From Here
	 * 
	 * //vdoctype = "SR" ; //new
	 * gnGLBalSumPosting().GLBalanceSummaryPosting(vdoctype, vdocno, vdocdate);
	 * 
	 * }//End SR Process
	 * 
	 * 
	 * 
	 * 
	 * public void gstPRProcess(String vparty, String vdocno, String vdocdate,
	 * String vamount) throws Throwable { vsalestype = "PR" ; vmethod =
	 * "PRRegular" ; vdoctype = "Pur.Return" ; isledgerRun = "N" ; new
	 * gnPosting().postGstEntries(vdocno , vdoctype , vmethod , vdocdate);
	 * 
	 * String vvamount = new
	 * gnGST_getInclusiveExclusiveAmount().PR_getExclusiveAmount(vdocno,
	 * vdocdate, vdoctype) ; vexcltransactionAmount = vvamount ; new
	 * gnBridge().postStockSubAccountEntry(vsalestype, vdocno, vdocdate,
	 * vvamount); new gnBridge().processEntryPosting(vparty, vsalestype, vdocno,
	 * vdocdate, vamount);
	 * 
	 * // //Tax Posting Start From Here String Vmyscheme = new
	 * gnGST().gst_getmytaxschemecode(); //String Vmyscheme = new
	 * gnGST().ismyComanyGSTRegister() ; switch(Vmyscheme) { case "2" : String
	 * Vscheme = new gnGST().getSupplierSchemecode(vparty); switch(Vscheme) {
	 * case "2" : vdoctype2 = "PR" ; vcgst = new
	 * gnAccountbase().getCgstTaxamt(vdoctype2, vdocno, vdocdate); vtaxtype =
	 * "CGST" ; new gnBridge().PurchaseRetTaxPosting(vtaxtype , vsalestype,
	 * vdocno, vdocdate, vcgst);
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; new gnBridge().PurchaseRetTaxPosting(vtaxtype ,
	 * vsalestype, vdocno, vdocdate, vsgst);
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; new gnBridge().PurchaseRetTaxPosting(vtaxtype ,
	 * vsalestype, vdocno, vdocdate, vigst); break ;
	 * 
	 * case "1" : vdoctype2 = "PR" ;
	 * 
	 * vcgst = new gnAccountbase().getCgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "CGST" ; new gnBridge().PurchaseRetTaxPosting(vtaxtype ,
	 * vsalestype, vdocno, vdocdate, vcgst);
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; new gnBridge().PurchaseRetTaxPosting(vtaxtype ,
	 * vsalestype, vdocno, vdocdate, vsgst);
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; new gnBridge().PurchaseRetTaxPosting(vtaxtype ,
	 * vsalestype, vdocno, vdocdate, vigst); break ;
	 * 
	 * 
	 * case "0" : //Post Reverse Charge in this Case input tax gl wil not impact
	 * rather output tax will impact and refung gl will impact vdoctype2 = "PR"
	 * ; vcgst = new gnAccountbase().getCgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "CGST" ; new gnBridge().Reverse_ReversechrgTaxPosting(vtaxtype
	 * , vdoctype2, vdocno, vdocdate , vcgst);
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; new gnBridge().Reverse_ReversechrgTaxPosting(vtaxtype
	 * , vdoctype2, vdocno, vdocdate, vsgst);
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; new gnBridge().Reverse_ReversechrgTaxPosting(vtaxtype
	 * , vdoctype2, vdocno, vdocdate, vigst);
	 * 
	 * Double vtaxcgst = Double.parseDouble(vcgst); Double vtaxsgst =
	 * Double.parseDouble(vsgst); Double vtaxigst = Double.parseDouble(vigst);
	 * Double vtaxamt1 = vtaxcgst+vtaxigst+vtaxsgst ; String vrevchrgTaxamt =
	 * Double.toString(vtaxamt1) ; new gnBridge().
	 * Reverse_RefundTaxPosting(vtaxtype , vdoctype2, vdocno, vdocdate,
	 * vrevchrgTaxamt); break ; } case "1" : Vscheme = new
	 * gnGST().getSupplierSchemecode(vparty); // new General().msg(Vscheme);
	 * switch(Vscheme) { case "0" : //Post Reverse Charge in this Case input tax
	 * gl wil not impact rather output tax will impact and refung gl will impact
	 * vdoctype2 = "PR" ; vcgst = new gnAccountbase().getCgstTaxamt(vdoctype2,
	 * vdocno, vdocdate); vtaxtype = "CGST" ; new
	 * gnBridge().Reverse_ReversechrgTaxPosting(vtaxtype , vdoctype2, vdocno,
	 * vdocdate , vcgst);
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; new gnBridge().Reverse_ReversechrgTaxPosting(vtaxtype
	 * , vdoctype2, vdocno, vdocdate, vsgst);
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; new gnBridge().Reverse_ReversechrgTaxPosting(vtaxtype
	 * , vdoctype2, vdocno, vdocdate, vigst);
	 * 
	 * Double vtaxcgst = Double.parseDouble(vcgst); Double vtaxsgst =
	 * Double.parseDouble(vsgst); Double vtaxigst = Double.parseDouble(vigst);
	 * Double vtaxamt1 = vtaxcgst+vtaxigst+vtaxsgst ; String vrevchrgTaxamt =
	 * Double.toString(vtaxamt1) ; new gnBridge().
	 * Reverse_RefundTaxPosting(vtaxtype , vdoctype2, vdocno, vdocdate,
	 * vrevchrgTaxamt); break ; } break; } //Gl Summary Posting in
	 * ms_accounts_glDateWise
	 * 
	 * //vdoctype = "PR" ; //new
	 * gnGLBalSumPosting().GLBalanceSummaryPosting(vdoctype, vdocno, vdocdate);
	 * 
	 * }
	 * 
	 * 
	 * public void gstCreditnoteProcess(String vparty, String vdocno, String
	 * vdocdate, String vamount) throws Throwable { isledgerRun = "N" ; vmethod
	 * = "CNRegular" ; vdoctype = "CN" ; new gnPosting().postGstEntries(vdocno ,
	 * vdoctype , vmethod , vdocdate); new gnPosting().postSundrydrcr(vdocno ,
	 * vdocdate , vdoctype); }
	 * 
	 * 
	 * public void gstDebitnoteProcess(String vparty, String vdocno, String
	 * vdocdate, String vamount) throws Throwable { vmethod = "DNRegular" ;
	 * vdoctype= "DN" ; isledgerRun = "N" ; new
	 * gnPosting().postGstEntries(vdocno , vdoctype , vmethod , vdocdate); new
	 * gnPosting().postSundrydrcr(vdocno , vdocdate , vdoctype);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public void gstCustAdvanceProcess(String vparty, String vdocno, String
	 * vdocdate, String vamount, String vdoctype1) throws Throwable {
	 * isledgerRun = "N" ; vsalestype = "C" ; vmethod = "CAD" ; new
	 * gnPosting().postGstEntries(vdocno, vsalestype , vmethod , vdocdate);
	 * vdoctype = "CAD" ; new gnPosting().postSundrydrcr(vdocno , vdocdate
	 * ,vdoctype); new gnBridge().processEntryPosting(vparty , vdoctype1,
	 * vdocno, vdocdate, vamount);
	 * 
	 * //Tax Posting Start From Here String Vscheme = new
	 * gnGST().gst_getmytaxschemecode(); switch(Vscheme) { case "2" : vdoctype =
	 * "AD" ; vsalestype = "CAD" ; String vadvtype = "C" ; vcgst = new
	 * gnAccountbase().getAdvCgstTaxamt(vdoctype, vdocno, vdocdate , vadvtype);
	 * vtaxtype = "CGST" ; if (Double.parseDouble(vcgst) > 0.00) { new
	 * gnBridge().SalesTaxPosting(vtaxtype , vsalestype, vdocno, vdocdate,
	 * vcgst); }
	 * 
	 * vsgst = new gnAccountbase().getAdvSgstTaxamt(vdoctype, vdocno, vdocdate,
	 * vadvtype); vtaxtype = "SGST" ; if (Double.parseDouble(vsgst) > 0.00) {
	 * new gnBridge().SalesTaxPosting(vtaxtype , vsalestype, vdocno, vdocdate,
	 * vsgst); } vigst = new gnAccountbase().getAdvIgstTaxamt(vdoctype, vdocno,
	 * vdocdate , vadvtype); vtaxtype = "IGST" ; if (Double.parseDouble(vigst) >
	 * 0.00) { new gnBridge().SalesTaxPosting(vtaxtype , vsalestype, vdocno,
	 * vdocdate, vigst); } break ; case "0" : break ; case "1" : break ; } //End
	 * Tax Posting Start From Here }
	 * 
	 * 
	 * public void gstSuplAdvanceProcess(String vparty, String vdocno, String
	 * vdocdate, String vamount, String vdoctype1) throws Throwable {
	 * isledgerRun = "N" ; vsalestype = "S" ; vmethod = "SAD" ; new
	 * gnPosting().postGstEntries(vdocno, vsalestype , vmethod , vdocdate);
	 * vdoctype = "SAD" ; new gnPosting().postSundrydrcr(vdocno , vdocdate
	 * ,vdoctype); new gnBridge().processEntryPosting(vparty , vdoctype1,
	 * vdocno, vdocdate, vamount); // //Tax Posting Start From Here String
	 * Vmyscheme = new gnGST().gst_getmytaxschemecode();
	 * 
	 * 
	 * //String Vmyscheme = new gnGST().ismyComanyGSTRegister() ;
	 * switch(Vmyscheme) { case "2" : String Vscheme = new
	 * gnGST().getSupplierSchemecode(vparty); // new General().msg(Vscheme);
	 * switch(Vscheme) { case "2" : vdoctype2 = "AD" ; vdoctype = "SAD" ; vcgst
	 * = new gnAccountbase().getAdvCgstTaxamt(vdoctype2, vdocno, vdocdate ,
	 * vsalestype); vtaxtype = "CGST" ; new
	 * gnBridge().PurchaseTaxPosting(vtaxtype , vdoctype, vdocno, vdocdate,
	 * vcgst);
	 * 
	 * vsgst = new gnAccountbase().getAdvSgstTaxamt(vdoctype2, vdocno, vdocdate,
	 * vsalestype); vtaxtype = "SGST" ; new
	 * gnBridge().PurchaseTaxPosting(vtaxtype , vdoctype, vdocno, vdocdate,
	 * vsgst);
	 * 
	 * vigst = new gnAccountbase().getAdvIgstTaxamt(vdoctype2, vdocno, vdocdate,
	 * vsalestype); vtaxtype = "IGST" ; new
	 * gnBridge().PurchaseTaxPosting(vtaxtype , vdoctype, vdocno, vdocdate,
	 * vigst); break ;
	 * 
	 * case "1" : vdoctype2 = "AD" ; vdoctype = "SAD" ; vcgst = new
	 * gnAccountbase().getCgstTaxamt(vdoctype2, vdocno, vdocdate); vtaxtype =
	 * "CGST" ; new gnBridge().PurchaseTaxPosting(vtaxtype , vdoctype, vdocno,
	 * vdocdate, vcgst);
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; new gnBridge().PurchaseTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vsgst);
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; new gnBridge().PurchaseTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vigst); break ;
	 * 
	 * case "0" : //Post Reverse Charge in this Case input tax gl wil not impact
	 * rather output tax will impact and refung gl will impact vdoctype2 = "AD"
	 * ; vdoctype = "SAD" ; vcgst = new gnAccountbase().getCgstTaxamt(vdoctype2,
	 * vdocno, vdocdate); vtaxtype = "CGST" ; new
	 * gnBridge().ReversechrgTaxPosting(vtaxtype , vdoctype, vdocno, vdocdate,
	 * vcgst);
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; new gnBridge().ReversechrgTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vsgst);
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; new gnBridge().ReversechrgTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vigst);
	 * 
	 * Double vtaxcgst = Double.parseDouble(vcgst); Double vtaxsgst =
	 * Double.parseDouble(vsgst); Double vtaxigst = Double.parseDouble(vigst);
	 * Double vtaxamt1 = vtaxcgst+vtaxigst+vtaxsgst ; String vrevchrgTaxamt =
	 * Double.toString(vtaxamt1) ; new gnBridge(). RefundTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vrevchrgTaxamt); break ; } break; case "1" :
	 * Vscheme = new gnGST().getSupplierSchemecode(vparty); // new
	 * General().msg(Vscheme); switch(Vscheme) { case "0" : //Post Reverse
	 * Charge in this Case input tax gl wil not impact rather output tax will
	 * impact and refung gl will impact vdoctype2 = "AD" ; vdoctype = "SAD" ;
	 * vcgst = new gnAccountbase().getCgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "CGST" ; new gnBridge().ReversechrgTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vcgst);
	 * 
	 * vsgst = new gnAccountbase().getSgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "SGST" ; new gnBridge().ReversechrgTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vsgst);
	 * 
	 * vigst = new gnAccountbase().getIgstTaxamt(vdoctype2, vdocno, vdocdate);
	 * vtaxtype = "IGST" ; new gnBridge().ReversechrgTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vigst);
	 * 
	 * Double vtaxcgst = Double.parseDouble(vcgst); Double vtaxsgst =
	 * Double.parseDouble(vsgst); Double vtaxigst = Double.parseDouble(vigst);
	 * Double vtaxamt1 = vtaxcgst+vtaxigst+vtaxsgst ; String vrevchrgTaxamt =
	 * Double.toString(vtaxamt1) ; new gnBridge(). RefundTaxPosting(vtaxtype ,
	 * vdoctype, vdocno, vdocdate, vrevchrgTaxamt); break ; } break; }
	 * //vdoctype = "PV" ; //new
	 * gnGLBalSumPosting().GLBalanceSummaryPosting(vdoctype, vdocno, vdocdate);
	 * }
	 * 
	 */

}

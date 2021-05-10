package RetailProduct;

public class gnRepostingMiddleware extends getResultSet {

	String vcomp;
	String vstore;
	String vdoctype;
	String vdocdate;
	String vdocno;
	String vcheck;
	String vallow;
	String vsalestype;
	String SQL;

	public void POModification(String vvtype, String vdocno, String vvdocdate) throws Throwable {
		switch (vvtype) {
		case "PO":
			vdoctype = "PO";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			SQL = "Call  DocRepost_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
					+ vdocdate + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();
			break;
		}
	}

	public void PurchaseModification(String vvtype, String vdocno, String vvdocdate) throws Throwable {
		vdoctype = "GRN";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  DocRepost_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
				+ vdocdate + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void PRModification(String vvtype, String vdocno, String vvdocdate) throws Throwable {

		switch (vvtype) {

		case "PR":
			vdoctype = "PR";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			SQL = "Call  DocRepost_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
					+ vdocdate + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();
			break;
		}

	}

	public void DNModification(String vvtype, String vdocno, String vvdocdate) throws Throwable {
		switch (vvtype) {
		case "DN":
			vdoctype = "DN";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			SQL = "Call  DocRepost_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
					+ vdocdate + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();
		}
	}

	public void SalesModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {
		vdoctype = "";

		switch (vvdoctype) {
		case "WS":
			vdoctype = "WS";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			break;

		case "PS":
			vdoctype = "PS";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			break;

		case "B2B":
			vdoctype = "B2B";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			break;
		}
		String vdoctype1 = "SALE";
		SQL = "Call  DocRepost_process(" + vcomp + " , " + vstore + " , '" + vdoctype1 + "' ," + vdocno + ", '"
				+ vdocdate + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	private void SRModification() {

	}

	private void CNModification() {

	}

	public void SuplADVModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {
		vdoctype = "SAD";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  DocRepost_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
				+ vdocdate + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void CustADVModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {

		vdoctype = "CAD";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  DocRepost_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
				+ vdocdate + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void PaymentVoucherModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {

		vdoctype = "PV";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  DocRepost_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
				+ vdocdate + "')";
		this.getSPResult(SQL);

	}

	public void PaymentReceiptModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {

		vdoctype = "RV";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  DocRepost_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
				+ vdocdate + "')";
		this.getSPResult(SQL);
	}

	public void ContraEntryModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {

		vdoctype = "CON";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  DocRepost_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
				+ vdocdate + "')";
		this.getSPResult(SQL);
	}

}

//

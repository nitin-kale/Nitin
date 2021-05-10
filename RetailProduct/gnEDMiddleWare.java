package RetailProduct;

public class gnEDMiddleWare extends getResultSet {

	String vcomp;
	String vstore;
	String vdoctype;
	String vdocdate;
	String vfinyear;
	String vdocno;
	String vcheck;
	String vallow;
	String vsalestype;
	String SQL;

	

	public void SOModification(String vvtype, String vdocno, String vvdocdate) throws Throwable {
		switch (vvtype) {
		case "SO":
			isledgerRun = "N";
			vdoctype = "SO";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
					+ vdocdate + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();
			break;
		}
	}

	
	public void ExpenseOtherModification(String vvtype, String vdocno, String vvdocdate) throws Throwable {
		switch (vvtype) {
		case "EXO":
			isledgerRun = "N";
			vdoctype = "EXO";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
					+ vdocdate + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();
			break;
		}
	}

	public void POModification(String vvtype, String vdocno, String vvdocdate) throws Throwable {
		switch (vvtype) {
		case "PO":
			isledgerRun = "N";
			vdoctype = "PO";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
					+ vdocdate + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();
			break;
		}
	}

	
	
	public void PurchaseModification(String vvtype, String vdocno, String vvdocdate) throws Throwable {

		// new General().msg(vvtype + " "+vdocno+ " "+vvdocdate);
		switch (vvtype) {
		case "GRN":
			isledgerRun = "N";
			vdoctype = "GRN";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
					+ vdocdate + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();

			String SQL1 = "call    Inv_Revsalimpact(" + vcomp + " , " + vstore + ",  '" + vdoctype + "',   " + vdocno
					+ " , '" + vdocdate + "' ,  '" + currentFinYear + "')";
			this.getSPResult(SQL1);
			rs.close();
			this.closeconn();

			SQL = "call    Inv_Reversalimpact_batch(" + vcomp + " , " + vstore + ",  '" + vdoctype + "',   " + vdocno
					+ " , '" + vdocdate + "' ,  '" + currentFinYear + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();

			String vpara811 = "811";
			String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
					vstore);
			switch (vmaintainbatchforNonBatchItem) {
			case "Y":
				SQL = "call    Inv_Reversalimpact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vdoctype + "',   "
						+ vdocno + " , '" + vdocdate + "' ,  '" + currentFinYear + "')";
				this.getSPResult(SQL);
				rs.close();
				this.closeconn();
				break;
			}

			break;

		}
	}

	public void PRModification(String vvtype, String vdocno, String vvdocdate) throws Throwable {
		switch (vvtype) {
		case "PR":
			isledgerRun = "N";
			vdoctype = "PR";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
					+ vdocdate + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();

			String SQL1 = "call    Inv_Revsalimpact(" + vcomp + " , " + vstore + ",  '" + vdoctype + "',   " + vdocno
					+ " , '" + vdocdate + "' ,  '" + currentFinYear + "')";
			this.getSPResult(SQL1);
			rs.close();
			this.closeconn();

			SQL = "call    Inv_Reversalimpact_batch(" + vcomp + " , " + vstore + ",  '" + vdoctype + "',   " + vdocno
					+ " , '" + vdocdate + "' ,  '" + currentFinYear + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();

			String vpara811 = "811";
			String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
					vstore);
			switch (vmaintainbatchforNonBatchItem) {
			case "Y":
				SQL = "call    Inv_Reversalimpact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vdoctype + "',   "
						+ vdocno + " , '" + vdocdate + "' ,  '" + currentFinYear + "')";
				this.getSPResult(SQL);
				rs.close();
				this.closeconn();
				break;
			}

			// vvtype = "DN" ;
			// DNModification(vvtype , vdocno , vvdocdate) ;
			break;
		}
	}

	public void DNModification(String vvtype, String vdocno, String vvdocdate) throws Throwable {
		switch (vvtype) {
		case "DN":
			isledgerRun = "N";
			vdoctype = "DN";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
					+ vdocdate + "')";
			// new General().msg(SQL);
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();

		}
	}

	public void SalesModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {
		vdoctype = "";
		switch (vvdoctype) {
		case "WS":
			isledgerRun = "N";
			vdoctype = "WS";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			break;

		case "PS":
			isledgerRun = "N";
			vdoctype = "PS";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			break;

		case "B2B":
			isledgerRun = "N";
			vdoctype = "B2B";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			break;
		}

		String vdoctype1 = "SALE";
		SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype1 + "' ," + vdocno + ", '" + vdocdate
				+ "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

		SQL = "call    Inv_Revsalimpact(" + vcomp + " , " + vstore + ",  '" + vdoctype + "',   " + vdocno + " , '"
				+ vdocdate + "' ,  '" + currentFinYear + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

		SQL = "call    Inv_Reversalimpact_batch(" + vcomp + " , " + vstore + ",  '" + vdoctype + "',   " + vdocno
				+ " , '" + vdocdate + "' ,  '" + currentFinYear + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

		String vpara811 = "811"; // this Parameter for BAtch Managment for Non
									// BAtch Items
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			SQL = "call    Inv_Reversalimpact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vdoctype + "',   "
					+ vdocno + " , '" + vdocdate + "' ,  '" + currentFinYear + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();
			break;
		}

	}

	public void SRModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {

		vdoctype = "";
		switch (vvdoctype) {
		case "SR":
			isledgerRun = "N";
			vdoctype = "SR";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			break;
		}
		SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '" + vdocdate
				+ "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

		SQL = "call    Inv_Revsalimpact(" + vcomp + " , " + vstore + ",  '" + vdoctype + "',   " + vdocno + " , '"
				+ vdocdate + "' ,  '" + currentFinYear + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

		SQL = "call    Inv_Reversalimpact_batch(" + vcomp + " , " + vstore + ",  '" + vdoctype + "',   " + vdocno
				+ " , '" + vdocdate + "' ,  '" + currentFinYear + "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

		String vpara811 = "811"; // this Parameter for BAtch Managment for Non
									// BAtch Items
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			SQL = "call    Inv_Reversalimpact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vdoctype + "',   "
					+ vdocno + " , '" + vdocdate + "' ,  '" + currentFinYear + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();
			break;
		}

		// new General().msg("DocEd Process Compated");
	}

	public void CNModification(String vvtype, String vdocno, String vvdocdate) throws Throwable {
		switch (vvtype) {
		case "CN":
			isledgerRun = "N";
			vdoctype = "CN";
			vcomp = new gnConfig().getCompanyCode();
			vstore = new gnConfig().getStoreID();
			vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
			SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '"
					+ vdocdate + "')";
			this.getSPResult(SQL);
			rs.close();
			this.closeconn();

		}
	}

	public void SuplADVModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {
		vdoctype = "SAD";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		isledgerRun = "N";
		SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '" + vdocdate
				+ "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void CustADVModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {
		isledgerRun = "N";
		vdoctype = "CAD";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '" + vdocdate
				+ "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void ExpenseVoucherModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {
		isledgerRun = "N";
		vdoctype = "EX";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '" + vdocdate
				+ "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void IncomeVoucherModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {
		isledgerRun = "N";
		vdoctype = "IN";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '" + vdocdate
				+ "')";
		this.getSPResult(SQL);
	}

	public void PaymentVoucherModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {
		isledgerRun = "N";
		vdoctype = "PV";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '" + vdocdate
				+ "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
	}

	public void JVVoucherModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {
		isledgerRun = "N";
		vdoctype = "JV";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '" + vdocdate
				+ "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void PaymentReceiptModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {

		isledgerRun = "N";
		vdoctype = "RV";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '" + vdocdate
				+ "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();

	}

	public void ContraEntryModification(String vvdoctype, String vdocno, String vvdocdate) throws Throwable {
		isledgerRun = "N";
		vdoctype = "CON";
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vvdocdate);
		SQL = "Call  Doced_process(" + vcomp + " , " + vstore + " , '" + vdoctype + "' ," + vdocno + ", '" + vdocdate
				+ "')";
		this.getSPResult(SQL);
		rs.close();
		this.closeconn();
	}

}

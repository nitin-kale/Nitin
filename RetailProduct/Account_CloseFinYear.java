package RetailProduct;

public class Account_CloseFinYear extends getResultSet {

	String vcomp;
	String vstore;
	String vfinyear;

	private void setStandard() throws Throwable {
		vfinyear = new gnFinYear().getReportingFinYear();
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
	}

	private String validate() throws Throwable {
		setStandard();
		String status = "Sucess";
		String vcurrentFinyear = new gnFinYear().getReportingFinYear();
		if (vcurrentFinyear.length() == 0) {
			status = "Fail";
		}
		return status;
	}

	public String calculateGl_GroupBalancesForYear() throws Throwable {
		setStandard();
		String status = "Sucess";
		status = validate();
		if (status == "Sucess") {
			String CurrentFinyearFirstDate = new gnFinYear().getFirstDateofFinYear();
			String LastDateofPrvFinyear = new gnConfig().calculateManufDate(CurrentFinyearFirstDate, 1);
			String vfinyear = new gnFinYear().getFinyearofGivenDate(LastDateofPrvFinyear);
			String vfdate = new gnFinYear().getFirstDateofPrvfinyear(LastDateofPrvFinyear);
			String ldate = new gnFinYear().getLastDateofPrvfinyear(LastDateofPrvFinyear);

			if (vfinyear.length() != 0) {
				new gnAccountbase().Calculate_glClosingBalancesForSite(vfdate, ldate, vfinyear);
				new gnAccountbase().Calculate_Group_ClosingBalancesForSite(vfdate, ldate, vfinyear);
				new gnAccountbase().Account_SubGroup_ClosingForSite(vfdate, ldate, vfinyear);
				new gnAccountbase().GenerateTB();
			} else {
				System.out.println("No Record For Prv Financial Year");
			}
		}
		return status;
	}

	public String AssignOpeningGl_GroupBalancesForYear() throws Throwable {
		setStandard();
		String status = "Sucess";
		status = validate();
		if (status == "Sucess") {

			String CurrentFinyearFirstDate = new gnFinYear().getFirstDateofFinYear();
			String LastDateofPrvFinyear = new gnConfig().calculateManufDate(CurrentFinyearFirstDate, 1);
			String vfinyear = new gnFinYear().getFinyearofGivenDate(LastDateofPrvFinyear);
			String vclosingfinyear = new gnFinYear().getFinyearofGivenDate(LastDateofPrvFinyear);
			String vopeningfinyear = new gnFinYear().getReportingFinYear();

			// new General().msg("Closing Finyear "+ " "+vclosingfinyear +" and
			// " + "Opening Finyear"+ " "+vopeningfinyear);

			if (vclosingfinyear.length() > 1 && vopeningfinyear.length() > 1) {
				String SQL = "Call Account_GLOpBal_AssignmentForSite( " + vcomp + "  , " + vstore + "  , '"
						+ vclosingfinyear + "' , '" + vopeningfinyear + "')";
				// new General().msg(SQL);
				String SQL1 = "Call Account_GroupOpBal_AssignmentForSite( " + vcomp + "  , " + vstore + "  , '"
						+ vclosingfinyear + "' , '" + vopeningfinyear + "')";
				// new General().msg(SQL1);
				String SQL2 = "Call Account_SubGroupOpBal_AssignmentForSite( " + vcomp + "  , " + vstore + "  , '"
						+ vclosingfinyear + "' , '" + vopeningfinyear + "')";
				// new General().msg(SQL2);

				this.getSPResult(SQL);
				new gnImageSound().playSound();
				new gnImageSound().playSound();
				rs.close();
				this.closeconn();

				// new General().msg(SQL1);
				this.getSPResult(SQL1);
				new gnImageSound().playSound();
				new gnImageSound().playSound();
				rs.close();
				this.closeconn();

				// new General().msg(SQL2);
				this.getSPResult(SQL2);
				new gnImageSound().playAlertSound();
				new gnImageSound().playSound();
				new gnImageSound().playSound();
				new gnImageSound().playSound();
				rs.close();
				this.closeconn();

			}
		}
		return status;
	}

	public String AssignClosingStockNewFinYear() throws Throwable {
		setStandard();
		String status = "Sucess";

		String CurrentFinyearFirstDate = new gnFinYear().getFirstDateofFinYear();
		String LastDateofPrvFinyear = new gnConfig().calculateManufDate(CurrentFinyearFirstDate, 1);
		String vfinyear = new gnFinYear().getFinyearofGivenDate(LastDateofPrvFinyear);

		String vclosingfinyear = new gnFinYear().getFinyearofGivenDate(LastDateofPrvFinyear);
		String vopeningfinyear = new gnFinYear().getReportingFinYear();

		status = new gnCloseFinyear().CheckFinyearStockDataPresent(vopeningfinyear);

		if (status == "Sucess") {
			try {
				// Insert if no Stock data availabe for new finyear
				String SQL = "call  Account_Stock_OpStockAssignForSite(" + vcomp + ", " + vstore + ",  '"
						+ vclosingfinyear + "'   , '" + vopeningfinyear + "')";
				this.getSPResult(SQL);
				rs.close();
				this.closeconn();
			} catch (Exception w) {
				System.out.println(w.getMessage());
			}
		}

		if (status == "Fail") {
			// update Stock op balance for new finyear because data present for
			// new finyear in stock_in_hand Table
			String SQL = "call  Account_StockUpdate_OpStockAssignForSite(" + vcomp + ", " + vstore + ",  '"
					+ vclosingfinyear + "'  , '" + vopeningfinyear + "')";
			String SQL1 = "call Account_BatchStockUpdate_OpStockAssignForSite(" + vcomp + ", " + vstore + ",  '"
					+ vclosingfinyear + "'  , '" + vopeningfinyear + "')";
			this.getSPResult(SQL);
			this.getSPResult(SQL1);
			rs.close();
			this.closeconn();
		}
		return status;
	}

}// LAst

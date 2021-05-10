package RetailProduct;

import java.sql.SQLException;
import java.util.Date;

public class gnFinYear extends getResultSet {

	String vcomp;
	String vstore;
	String vfinyear;
	String SQL;

	public static String vstartdate;
	public static String vxfinyear;
	public static String venddate;
	int vmon;
	int vyear;
	int vyear1;

	String vvyear;
	String vvyear1;

	String vpart1 = "";
	String vpart2 = "";

	
	/*
	public void checkAndPostAccountBaseMasters() throws Throwable {
		int row = 0;
		String vfinyear = getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();

		String vtype = "GroupCount";
		String vtype1 = "SubGroupCount";
		String vtype2 = "GLCount";
		String Status = "";
		int row1 = 0;
		int row2 = 0;
		int row3 = 0;

		String SQL1 = "call Account_getRecordCount('" + vtype + "', " + vcomp + ", " + vstore + " , '" + vfinyear
				+ "')";
		String SQL2 = "call Account_getRecordCount('" + vtype1 + "', " + vcomp + ", " + vstore + " , '" + vfinyear
				+ "')";
		String SQL3 = "call Account_getRecordCount('" + vtype2 + "', " + vcomp + ", " + vstore + " , '" + vfinyear
				+ "')";
		rs1 = this.getSPResult(SQL1);
		rs2 = this.getSPResult(SQL2);
		rs3 = this.getSPResult(SQL3);

		if (rs1.next()) {
			row1 = Integer.parseInt(rs1.getString(1));
		}

		if (rs2.next()) {
			row2 = Integer.parseInt(rs2.getString(1));
		}
		if (rs3.next()) {
			row3 = Integer.parseInt(rs3.getString(1));
		}
		if (row1 == 0 || row2 == 0 || row3 == 0) {
			InsertAccountBaseMaster();
			closeFinYear();
		}
		if (row1 > 0 || row2 > 0 || row3 > 0) {
			new General().Quickmsg("Account Masters For --> Group/SubGroup/GL is Present for This Company/Site/Finyear ");
		}
	}
	
	*/
	
 	public String getprvFinyearFreezeStatus() throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vfinyearFeezeStatus = "";
		String Status = "Sucess";
		String vfinyear = getPriviousFinyear();
		if (Status == "Sucess") {
			SQL = "Call fin_getFinYearData(" + vcomp + " , " + myvstore + "  , '" + vfinyear + "')";
			// new General().msg(SQL);
			rs = this.getSPResult(SQL);
			if (rs.next()) {
				vfinyearFeezeStatus = rs.getString(2);
				vfinyearFeezeStatus = vfinyearFeezeStatus.trim();
				// new General().msg("Finyear Freeze Satus is :"+ "
				// "+vfinyearFeezeStatus);
				this.closeconn();
			}
		}
		return vfinyearFeezeStatus;
	}

	public String getFinyearFreezeStatus() throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vfinyearFeezeStatus = "";
		String Status = "Sucess";
		if (Status == "Sucess") {
			SQL = "Call fin_getReportingFinYear(" + vcomp + " , " + myvstore + ")";
			// new General().msg(SQL);
			rs = this.getSPResult(SQL);
			if (rs.next()) {
				vfinyearFeezeStatus = rs.getString(2);
				vfinyearFeezeStatus = vfinyearFeezeStatus.trim();
				// new General().msg("Finyear Freeze Satus is :"+ "
				// "+vfinyearFeezeStatus);
				this.closeconn();
			}
		}
		return vfinyearFeezeStatus;
	}

	public String getFinyearFreezeDate() throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String vfinyearFeezeDate = "";
		// String Status = checkfinYear() ;
		// vdate = new gnConfig().date_ConverttoDBforamt();
		String Status = "Sucess";
		if (Status == "Sucess") {
			SQL = "Call fin_getReportingFinYear(" + vcomp + " , " + myvstore + ")";
			rs = this.getSPResult(SQL);
			if (rs.next()) {
				vfinyearFeezeDate = rs.getString(3);
				this.closeconn();
			}
		}
		return vfinyearFeezeDate;
	}

	public String getFinyearofTodaysDate(String vdate) {
		
		String fix = "20";
		new General().msg(vdate);
		int vmon = Integer.parseInt(vdate.substring(3, 5));
		int vyear = Integer.parseInt(vdate.substring(7, 10));
        
		new General().Quickmsg("Month: "+ vmon + "Year : "+ vyear);
        
 		if (vmon >= 4) {
			vyear = vyear;
			vvyear = Integer.toString(vyear);
 			vyear1 = vyear + 1;
			System.out.println(vyear1);
 			vpart1 = vvyear; // vvyear.substring(3,4);
			vpart2 = Integer.toString(vyear1);
 			vfinyear = vpart1 + "-" + vpart2;
 			vstartdate = "01.04." + fix + vvyear;
			venddate = "31.03." + fix + vyear1;
			vxfinyear = vpart1 + "-" + vpart2;
 			new General().Quickmsg("Financial Year :"+ " "+vxfinyear);
  			new gnLogger().loggerInfoEntry("New Compnay Created", vxfinyear + " "+ vdate + vcomp + vstore);
  		} else {
			vyear = vyear - 1;
			vvyear = Integer.toString(vyear);
 			vyear1 = vyear + 1;

 			System.out.println(vyear1);
 			vpart1 = vvyear; // vvyear.substring(3,4);
			vpart2 = Integer.toString(vyear1);

			vfinyear = vpart1 + "-" + vpart2;

			vstartdate = "01.04." + fix + vvyear;
			venddate = "31.03." + fix + vyear1;
			vxfinyear = vpart1 + "-" + vpart2;
 			new General().Quickmsg("Financial Year :"+ " "+vxfinyear);

 			new gnLogger().loggerInfoEntry("New Compnay Created", vxfinyear + " "+ vdate + vcomp + vstore);
 			//System.out.println(vstartdate);
			//System.out.println(venddate);
			//System.out.println(vxfinyear);

		}

		return vfinyear;

	}

	public void setSelectedFinForSelectedCompany(String vfinyear) throws ClassNotFoundException, SQLException {
		if (vfinyear.length() == 1) {
			new General().msg("Create Financial  Year ,,");
		}

		if (vfinyear.length() == 5) {
			String SQL = "Call  Account_setAutoFinyear(" + myvcomp + " , " + myvstore + "  , '" + vfinyear + "')";
			// new General().Devmsg(SQL);
			this.getSPResult(SQL);
			currentFinYear = vfinyear;
		}
		rs.close();
		this.closeconn();
	}

	public String getLowestFinyear() throws Throwable {
		String vfinyear = "";
		String SQL = "Select    date_format(min(start_date), '%d.%m.%Y') from finyearcontrol";
		// new General().Devmsg(SQL);
		rs = this.getSPResult(SQL);
		rs.next();
		String vdate = rs.getString(1);
		// new General().msg(vdate);
		new gnConfig().Date_convertToApplformat(vdate);
		vfinyear = new gnFinYear().getFinyearofGivenDate(vdate);
		// new General().msg(vfinyear);
		this.closeconn();
		return vfinyear;

	}

	public String getPriviousFinyear() throws Throwable {
		String vprvfinyear = "";
		String CurrentFinyearFirstDate = new gnFinYear().getFirstDateofFinYear();
		String LastDateofPrvFinyear = new gnConfig().calculateManufDate(CurrentFinyearFirstDate, 1);
		String vfinyear = new gnFinYear().getFinyearofGivenDate(LastDateofPrvFinyear);
		String vclosingfinyear = new gnFinYear().getFinyearofGivenDate(LastDateofPrvFinyear);
		String vopeningfinyear = new gnFinYear().getReportingFinYear();
		vprvfinyear = vclosingfinyear;
		new General().msg("Prv.Fin Year :" + " " + vprvfinyear);
		return vprvfinyear;
	}

	public String getFirstDateofFinYear() throws Throwable {
		String fdate = " ";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "call fin_getFirstDate(" + vcomp + " , " + myvstore + ")";
		// new General().Devmsg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			fdate = rs.getString(1);
		} else {
			new General().msg("Fin Year Data Mismatch Please Check..Current Fin Year");
		}
		// new General().msg(fdate);
		rs.close();
		this.closeconn();

		return fdate;
	}

	public String getLastDateofFinYear() throws Throwable {
		String fdate = " ";
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "call fin_getLastDate(" + vcomp + " , " + myvstore + ")";
		// new General().Devmsg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			fdate = rs.getString(1);
		} else {
			new General().msg("Fin Year Data Mismatch Please Check..Current Fin Year");
		}
		// new General().msg(fdate);
		rs.close();
		this.closeconn();

		return fdate;
	}

	public String checkDateRanegforFinyear(String vdate1, String vdate2) throws Throwable {
		String status1 = "";
		String status2 = "";
		String status = "Sucess";
		String vfinyear = getReportingFinYear();
		status1 =  isDateBelongstocurfinyear(vdate1);
		status2 =  isDateBelongstocurfinyear(vdate2);

		if (status1 == "Fail" || status2 == "Fail") {
			status = "Fail";
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new General().msg(
					"Please Check Date Range ==> Dates Are Not Belongs  To Current Financial Year" + " " + vfinyear);
		}
		return status;
	}

	public String isDateBelongstocurfinyear(String vdate) throws Throwable {
		String result = "NORESULT";
		String vno;
		int vvno;
 		String vcomp = new gnConfig().getCompanyCode();
		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		// SQL = "Call fin_checkfinYear('"+vdate+"')" ;
		SQL = "Call fin_checkfinYear(  " + vcomp + " ,    '" + vdate + "' , " + myvstore + ")";
  		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vno = rs.getString(1);
			vvno = Integer.parseInt(vno);
			switch (vvno) {
			case 0:
				result = "Fail";
				break;
			case 1:
				result = "Sucess";
			}
		}
		return result;

	}

	public String checkfinYear(String vdate) throws Throwable {

		String result = "Fail";
		String vno;
		int vvno;
		String vcomp = new gnConfig().getCompanyCode();
		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		SQL = "Call fin_checkfinYear(  " + vcomp + " ,    '" + vdate + "' , " + myvstore + ")";
		// new General().Devmsg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vno = rs.getString(1);
			vvno = Integer.parseInt(vno);
			switch (vvno) {
			case 0:
				result = "Fail";
				// System.exit(0);
				break;
			case 1:
				result = "Sucess";
			}
		}
		return result;
	}

	public String getCurrentFinYear(String vdate) throws Throwable {

		String vcomp = new gnConfig().getCompanyCode();

		// String Status = checkfinYear() ;
		String Status = "Sucess";

		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		if (Status == "Sucess") {
			SQL = "Call fin_getFinYear(" + vcomp + " , '" + vdate + "' , " + myvstore + ")";
			// new General().Devmsg(SQL);
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				vfinyear = rs.getString(1);
			}
			return vfinyear;
		} else {
			new General().msg("Financial Year Not Set Please Set Financial Year  .. ..");
			vfinyear = "00-00";
			return vfinyear;
		}

	}

	public String getFinyearofGivenDate(String vdate) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		String Status = "Sucess";
		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		if (Status == "Sucess") {
			SQL = "Call fin_getFinYear(" + vcomp + " , '" + vdate + "' , " + myvstore + ")";
			// new General().msg(SQL);
			rs = this.getSPResult(SQL);
			if (rs.next()) {
				vfinyear = rs.getString(1);
				rs.close();
				this.closeconn();

			} else {
				vfinyear = "0";
			}
			return vfinyear;
		} else {
			new General().msg("Financial Year Not Set Please Set Financial Year  .. ..");
			vfinyear = "00-00";
			return vfinyear;
		}
	}

	public String getFirstDateofPrvfinyear(String vdate) throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		// String Status = checkfinYear() ;
		String Status = "Sucess";
		String fdate = "";
		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		if (Status == "Sucess") {
			SQL = "Call fin_getFinYear(" + vcomp + " , '" + vdate + "' , " + myvstore + ")";
			// new General().msg("Finy year Methos " + " "+SQL);
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				fdate = rs.getString(2);
			}
		}
		return fdate;
	}

	public String getLastDateofPrvfinyear(String vdate) throws Throwable {

		String vcomp = new gnConfig().getCompanyCode();

		// String Status = checkfinYear() ;
		String Status = "Sucess";
		String fdate = "";
		vdate = new gnConfig().date_ConverttoDBforamt(vdate);
		if (Status == "Sucess") {
			SQL = "Call fin_getFinYear(" + vcomp + " , '" + vdate + "' , " + myvstore + ")";
			// new General().msg("Finy year Methos " + " "+SQL);
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				fdate = rs.getString(3);
			}
		}
		this.closeconn();
		return fdate;
	}

	public String getReportingFinYear() throws Throwable {
		String vcomp = new gnConfig().getCompanyCode();
		// String Status = checkfinYear() ;
		// vdate = new gnConfig().date_ConverttoDBforamt();
		String Status = "Sucess";
		if (Status == "Sucess") {
			SQL = "Call fin_getReportingFinYear(" + vcomp + " , " + myvstore + ")";
			rs = this.getSPResult(SQL);
			if (rs.next()) {
				vfinyear = rs.getString(1);
				this.closeconn();
			}
			return vfinyear;
		} else {
			new General().msg("Financial Year Not Set Please Set FinYear  .. ..");
			vfinyear = "00-00";
			return vfinyear;
		}
	}

	public String getiniFinYear(String vcomp, String vstore) throws Throwable {

		String Status = "Sucess";
		if (Status == "Sucess") {
			SQL = "Call fin_getReportingFinYear(" + vcomp + " , " + myvstore + ")";
			rs = this.getSPResult(SQL);
			if (rs.next()) {
				vfinyear = rs.getString(1);
				rs.close();
				this.closeconn();
			}
			return vfinyear;
		} else {
			new General().msg("Financial Year Not Set Please Set FinYear  .. ..");
			vfinyear = "00-00";
			return vfinyear;
		}
	}
	
	 
	
   

	public String checkDayEnd() throws Throwable {
		String vresult = "Sucess";
		String vendflag = "";
		String vbegindate = new gnConfig().date_ConverttoDBforamt(new gnConfig().getDaybeginDate());
		String SQL = "call day_checkDayEnd(" + vstore + " , '" + vbegindate + "' , " + vcomp + ")";
		// new General().Devmsg(SQL);
		rs = new getResultSet().getSPResult(SQL);
		if (rs.next())
			vendflag = rs.getString(3);
		switch (vendflag) {
		case "N":
			new General().Quickmsg("Day End Is Not Done.. Complete Day End ");
			vresult = "Fail";
			break;
		}
		rs.close();
 		return vresult;
	}


	public void closeFinYear() throws Throwable {
		String vfdate = getFirstDateofFinYear();
		String vldate = getLastDateofFinYear();
 		String vstartDate = new gnConfig().date_ConverttoDBforamt(vfdate);
		String vendDate = new gnConfig().date_ConverttoDBforamt(vldate);
  		
		 new General().Quickmsg("(gnFinyear-Closefinyear())->Inserting Account Base Master GL/Group/subbgroup");
		 InsertAccountBaseMaster(); //new Addition here removed from selectCompany and put here 

		 new General().Quickmsg("gnFinyear-Closefinyear())-> Calculating Previous year closing balances ");
 		 calculatePrvYearClosingsAndAssignOpening();


		 new General().Quickmsg("gnFinyear-Closefinyear())-> Assigning prv closing to current year and Calculating Current closing ");
  		 calculateCurrentYearClosings(vstartDate, vendDate);

	}


	public String InsertAccountBaseMaster() throws Throwable {
		String status = "Sucess";
		String vfinyear = getReportingFinYear();
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
 		String vtype1 = "Group";
		SQL = "call Account_FinAccountInsert('" + vtype1 + "' , " + vcomp + " , " + vstore + " ,  '" + vfinyear + "' )";
		this.getSPResult(SQL);
		String vtype2 = "SubGroup";
		SQL = "call Account_FinAccountInsert('" + vtype2 + "' , " + vcomp + " , " + vstore + " ,  '" + vfinyear + "' )";
		this.getSPResult(SQL);
		String vtype3 = "GL";
		SQL = "call Account_FinAccountInsert('" + vtype3 + "' , " + vcomp + " , " + vstore + " ,  '" + vfinyear + "' )";
		this.getSPResult(SQL);
 		new gnLogger().loggerInfoEntry("gnFinyear", "Account Base MAser Created..");
		return status;
	}
 

	public void calculatePrvYearClosingsAndAssignOpening() throws Throwable {
  		String status = checkDayEnd();
 		new Account_CloseFinYear().calculateGl_GroupBalancesForYear();
 		new gnLogger().loggerInfoEntry("gnFinyear", "Calculate Closing Balances For Prv year.");
 
 		new Account_CloseFinYear().AssignOpeningGl_GroupBalancesForYear();
 		new gnLogger().loggerInfoEntry("gnFinyear", "Assigniing Op.Balances for current fin year.");
 		 
 		new Account_CloseFinYear().AssignClosingStockNewFinYear();
 		new gnLogger().loggerInfoEntry("gnFinyear", "Assigniing Closing Stock as op Stock  for current fin year.");

 		//new gnDecorate().setDefaultCursor(frameFinyear);
	}

 	 
	public void calculateCurrentYearClosings(String vfrom, String vto) throws Throwable {
 		String vfinyear = new gnFinYear().getReportingFinYear();
 		new gnAccountbase().Calculate_glClosingBalancesForSite(vfrom, vto, vfinyear);
 		new gnLogger().loggerInfoEntry("gnFinyear", "Calculating GL  Current fin year closing Balances .");
 
 		new gnAccountbase().Calculate_Group_ClosingBalancesForSite(vfrom, vto, vfinyear);
 		new gnLogger().loggerInfoEntry("gnFinyear", "Calculating Group Current fin year closing Balances .");
 	}

 }

package RetailProduct;

import java.sql.SQLException;

public class gnEdit extends getResultSet {

	
	
	public String getDocType(String vdocno, String vdocdate, String vtype) throws Throwable {
		String vdoctype = "";
		String vcomp = new gnConfig().getCompanycode();
		String vstore = new gnConfig().getStoreID();
		String vfinyear = new gnFinYear().getReportingFinYear();
		String SQL = "Call Sales_getdocType(" + vcomp + ", " + vstore + ", " + vdocno + ", '" + vdocdate + "' , '"
				+ vtype + "' , '" + vfinyear + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vdoctype = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return vdoctype;
	}

	
	public void ShowGRN(String vparty, String vdocno, String vdocdate) throws Throwable {
		try {
			String vtype = "Purchase";
			String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
			String vdoctype = getDocType(vdocno, vdocdate1, vtype);
			String vverticle = new gnHierarchy().getVerticleCode() ;
 			//switch (vdoctype) 
			//{
			//case "WP":
 				switch(vverticle)
				{
 		 
					default :
						new gnGrn().rgrnno = vdocno;
						new gnGrn().rgrndate = vdocdate;
						GRNModule window = new GRNModule();
						window.GRNModuleFrame.setVisible(true);
						window.EditMode = "Y";
						window.showGrn(vparty);
						window = null;
						break;
 				}
  			//break ;	
			//case "PO":
			//	new gnGrn().rgrnno = vdocno;
			//	new gnGrn().rgrndate = vdocdate;
			//	GRNModule window1 = new GRNModule();
			//	window1.GRNModuleFrame.setVisible(true);
			//	window1.EditMode = "Y";
			//	window1.GRNModuleFrame.setVisible(true);
			//	window1.showGrn(vparty);
			//	break;
			//}
		} catch (Exception e) {
			e.printStackTrace();
			new General().msg(e.getMessage());
		}
	}


	
	public void showSalesOrder(String vdocno, String vdocdate) throws Throwable {
		try {
			String vtype = "SO";
			String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
			//String vdoctype = getDocType(vdocno, vdocdate1, vtype);
			switch (vtype) {
			case "SO":
				//new General().msg("Edititng Starts Now .. ");
				SalesOrder window = new SalesOrder();
				window.SalesOrderFrame.setVisible(true);
 				window.callEditProcess(vdocno, vdocdate);
   				break;
  			}
		} catch (Exception e) {
			if (e.getMessage().length() > 0)
			{
				new General().msg(e.getMessage());
			}
			System.out.println(e.getMessage());
			new gnLogger().loggerInfoEntry("gnEdit", e.getLocalizedMessage());
		}
	}

	
	public void showSales(String vdocno, String vdocdate) throws Throwable {
		try {
			String vtype = "Sales";
			String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
			String vdoctype = getDocType(vdocno, vdocdate1, vtype);
			String vverticle = new gnHierarchy().getVerticleCode() ;
 			switch(vverticle)
			{
 			case "1" : 
			switch (vdoctype) {
			case "PS":
				POS window = new POS();
				window.POSFrame.setVisible(true);
				window.callEditProcess(vdocno, vdocdate);
				window = null;
				break;

			case "WS":
				new ApplicationMenu().MenuSelection = "wsales";
				creditSalesPOS window1 = new creditSalesPOS();
				window1.creditsalesFrame.setVisible(true);
				window1.callEditProcess(vdocno, vdocdate);
				window1 = null;
				break;
			case "B2B":
				new ApplicationMenu().MenuSelection = "B2B";
				creditSalesPOS window2 = new creditSalesPOS();
				window2.creditsalesFrame.setVisible(true);
				window2.callEditProcess(vdocno, vdocdate);
				window1 = null;
				break;
 			}
			
		    break ;
			 case  "3" :
					POS3_1 window = new POS3_1();
					window.POSFrame3_1.setVisible(true);
					window.callEditProcess(vdocno, vdocdate);
					window = null;
					break;

			 case  "5" :
					POS window5 = new POS();
					window5.POSFrame.setVisible(true);
					window5.callEditProcess(vdocno, vdocdate);
					window5 = null;
 					break;
  			
					
		} //Mainswitch
		
		} catch (Exception e) {
			if (e.getMessage().length() > 0)
			{
				new General().msg(e.getMessage());
			}
			System.out.println(e.getMessage());
			new gnLogger().loggerInfoEntry("gnEdit", e.getLocalizedMessage());
		}
	}

	public void ShowSR(String vparty, String vdocno, String vdocdate) throws Throwable {
		try {
			String vtype = "SR";
			String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
			String vdoctype = getDocType(vdocno, vdocdate1, vtype);
			switch (vdoctype) {
			case "SR":
				Sales_Return window = new Sales_Return();
				window.EditMode = "Y";
				window.frameSalesReturn.setVisible(true);
				new gnSale().rinvdate = vdocdate;
				new gnSale().rinvno = vdocno;
				new gnSale().rcustcode = vparty;
				// new gnSale().rcustname
				window.showSR();
				break;
			}
		} catch (Exception e) {
			new General().msg(e.getMessage());
		}
	}

	public void showExpIncome(String vdocno, String vdocdate, String vdoctype) throws Throwable {

		try {
			switch (vdoctype) {

			case "JV":
				String vparty222 = "A";
				new gnVoucher().editPVRVvoucherData(vdoctype, vparty222, vdocno, vdocdate);
				acc_gernoulEntry window55 = new acc_gernoulEntry();
				window55.journalEntryFrame.setVisible(true);
				window55.callEditProcess();
				break;

			case "EX":
				String vparty3 = "A";
				new gnVoucher().editPVRVvoucherData(vdoctype, vparty3, vdocno, vdocdate);
				ExpenseVoucher window7 = new ExpenseVoucher();
				window7.frmExpenses.setVisible(true);
				window7.callEditProcess();
				window7 = null;
				break;

			/*
			 * case "EXO" : String vparty33 = "VCA" ; //new
			 * gnVoucher().editPVRVvoucherData(vdoctype , vparty33 , vdocno ,
			 * vdocdate) ; new gnVoucher().vdocno = vdocno ; new
			 * gnVoucher().vdocdate= vdocdate ; Asset_Expenses window897 = new
			 * Asset_Expenses(); window897.myMainframe.setVisible(true);
			 * window897.callEditProcess(); window7 = null; break ;
			 */
			case "IN":
				String vparty2 = "A";
				new gnVoucher().editPVRVvoucherData(vdoctype, vparty2, vdocno, vdocdate);
				IncomeVoucher window = new IncomeVoucher();
				window.frmIncome.setVisible(true);
				window.callEditProcess();
				window = null;
				break;

			case "PV":
				String vparty = "A";
				new gnVoucher().editPVRVvoucherData(vdoctype, vparty, vdocno, vdocdate);
				paymentVoucher window5 = new paymentVoucher();
				window5.frmpaymentvoucher.setVisible(true);
				window5.callEditProcess();
				window5 = null;
				break;

			case "RV":
				String vparty1 = "A";
				new gnVoucher().editPVRVvoucherData(vdoctype, vparty1, vdocno, vdocdate);
				receiptVoucher window77 = new receiptVoucher();
				window77.frmreceiptVoucher.setVisible(true);
				window77.callEditProcess();
				window77 = null;
				break;

			case "CON":
				String vparty22 = "A";
				new gnVoucher().editCONvoucherData(vdoctype, vparty22, vdocno, vdocdate);
				bankTransactions window9 = new bankTransactions();
				window9.frmBusinessApplication.setVisible(true);
				window9.callEditProcess();
				break;

			}
		} catch (Exception e) {
			new General().msg(e.getLocalizedMessage());
		}

	}

 	
	public void ShowPR(String vparty, String vdocno, String vdocdate) throws Throwable {
		try {
			String vtype = "PR";
			String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
			String vdoctype = getDocType(vdocno, vdocdate1, vtype);
			switch (vdoctype) {
			case "PR":
				new gnGrn().rgrnno = vdocno;
				new gnGrn().rgrndate = vdocdate;
				purchaseReturn window = new purchaseReturn();
				window.frmpurchaseReturn.setVisible(true);
				window.showPR(vparty);
				window = null;
				break;
			}
		} catch (Exception e) {
			new General().msg(e.getMessage());
		}
	}

	public void ShowPO(String vparty, String vdocno, String vdocdate) throws Throwable {
		try {
			String vtype = "PO";
			String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
			String vdoctype = getDocType(vdocno, vdocdate1, vtype);
			switch (vdoctype) {
			case "MP":
				new gnGrn().rgrnno = vdocno;
				new gnGrn().rgrndate = vdocdate;
				ManualPO window = new ManualPO();
				window.frmPOApplication.setVisible(true);
				window.CallEditprocess(vparty);
				break;

			}
		} catch (Exception e) {
			new General().msg(e.getMessage());
		}
	}

	public void ShowAdvance(String vparty, String vdocno, String vdocdate, String vdoctype, String vamount)
			throws Throwable {
		try {
			String vdocdate1 = new gnConfig().date_ConverttoDBforamt(vdocdate);
			String callEvent = "R";
			switch (vdoctype) {
			case "SAD":
				new gnAdvance().rdocno = vdocno;
				new gnAdvance().rdocdate = vdocdate;
				new gnAdvance().ramount = vamount;

				new gnAdvance().getBankRelatedDetails(vdoctype, vdocno, vdocdate);

				// Ws_Advance_payment window = new Ws_Advance_payment();
				// window.ws_advance.setVisible(true);
				// window.StartdocEditProcess(vparty, vdoctype, callEvent);
				break;

			case "CAD":
				new gnAdvance().rdocno = vdocno;
				new gnAdvance().rdocdate = vdocdate;
				new gnAdvance().ramount = vamount;

				new gnAdvance().getBankRelatedDetails(vdoctype, vdocno, vdocdate);

				// Ws_Advance_payment window1 = new Ws_Advance_payment();
				// window1.ws_advance.setVisible(true);
				// window1.StartdocEditProcess(vparty, vdoctype, callEvent);
				break;
			}
		} catch (Exception e) {
			new General().msg(e.getMessage());
		}
	}

}// Last

package RetailProduct;

public class gnDocPrint extends getResultSet {

	private String vcomp;
	private String vstore;


	public void printKOTForDirectInvoice(String doctype, String docno, String vdocdate  ) throws Throwable
	{
		try{
    //907	KOTPRINTONInvoicePrinter	KOTPRINTONInvoicePrinter	EPSON	Y
    //908	KOT PRINTER NAME	KOT PRINTER NAME	0	EPSON
    //909	KOTHOLDPRINTNAME	KOTHOLDPRINTNAME	KOT.Jasper	KOT.Jasper
    //910	KOTWITHOUTHOLDPRINT 		
 		      vcomp = new gnConfig().getCompanyCode();
		      vstore = new gnConfig().getStoreID();
		      vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
 		  	
			String vpara907 = "907" ;
	 		String vpara908 = "908" ;
	 		String vpara909 = "909" ;
	 		String vpara910 = "910" ;
	 		String vpara911= "911" ;
	 	 	
 		    String  vkotandInvocieONSamePrinter =  new getConfigurationSetting().getSpecificConfiguration(vpara907);
		    String  vkotprintername =  new getConfigurationSetting().getSpecificConfiguration(vpara908);
		    String  vkotholdreport =  new getConfigurationSetting().getSpecificConfiguration(vpara909);
		    String  vkotDirectReport=  new getConfigurationSetting().getSpecificConfiguration(vpara910);
  		    String  printKOT = new getConfigurationSetting().getSpecificConfiguration(vpara911);
    		 
 
  		    //new General().msg("Direct KOT REPORT NAME" +""+vkotDirectReport);
    	        switch(printKOT)
   	        {
   	          case "Y" : 
   	          String vreport = vkotDirectReport ;
  			  gnPrintMasters rpt = new gnPrintMasters();
   			  switch(vkotandInvocieONSamePrinter.trim())
  			  {
  			  	  case "Y" : 
   			  		  rpt.print(vreport);
   			  		  rpt = null;
 	 			  break ;
  			  	  case "N":
    			  	  rpt.printKOT(vreport , vkotprintername);
    			  	  rpt = null;
   	  			  break ;
   			  }	
   			 break;
   	     }	 
		} catch (Exception e) {
			new General().msg("POS Invoice PRINT " + e.getMessage());
		}
  	}
	
	
	
	
	
	public void printKOT(String vordertype , String vtableno , String vmobile , String vorderno , String vorderdate  ) throws Throwable
	{
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
 		String vpara907 = "907" ;
 		String vpara908 = "908" ;
 		String vpara909 = "909" ;
 		String vpara910 = "910" ;
 		
		String  vkotandInvocieONSamePrinter =  new getConfigurationSetting().getSpecificConfiguration(vpara907);
	    
		String  vkotprintername =  new getConfigurationSetting().getSpecificConfiguration(vpara908);
	    String  vkotholdreport =  new getConfigurationSetting().getSpecificConfiguration(vpara909);
	    String  vkotDirectReport=  new getConfigurationSetting().getSpecificConfiguration(vpara910);
    		    
	    String vpara911 = "911" ;
		String  printKOT = new getConfigurationSetting().getSpecificConfiguration(vpara911);
 		    try 
		    {
	 		    switch(printKOT)
		        {
	 	        case "Y":
 	 	        //new General().msg(vkotholdreport);	
	 	        String SQL = "call  printKOT(" + vcomp + " , " + vstore + " ,  '"+ vordertype+"', "
						+ " '"+vmobile+"' , '"+ vtableno+"' ,  '"+ vorderno+"' ,  '"+vorderdate+"'  )";
 				this.getSPResult(SQL) ;
				break ;
		      }    
	        } catch (Exception e) {
			  new General().Quickmsg("KOT Print " + e.getLocalizedMessage());
		     } 
 		    finally 
		    {
  		    	String vreport = vkotholdreport ; // "KOTPrint.jasper";
  		    	switch(printKOT)
		        {
 				    case "Y":
		 			switch(vkotandInvocieONSamePrinter.trim())
					{
						case "Y" :
					  		//new General().Quickmsg("Printing on  Invoice Printer");
		 					gnPrintMasters rpt = new gnPrintMasters();
		  					rpt.print(vreport);
		  					rpt = null;
						    break ;
		
						case "N" :
					  		//new General().Quickmsg("Printing on  Nework Printer");
   							gnPrintMasters rpt11 = new gnPrintMasters();
		  					rpt11.printKOT(vreport , vkotprintername);
		  					rpt11 = null;
						    break ;
		 			}
		 			break ;
	 				case "N" :
					new General().Quickmsg("KOT Printing is Disabled Please Check Config File ..");
					break ;
		}
  		}
  	}


	
	
	public void printCancelKOT(String vordertype , String vtableno , String vmobile , String vorderno , String vorderdate  ) throws Throwable
	{
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
 		String vpara907 = "907" ;
 		String vpara908 = "908" ;
 		String vpara909 = "909" ;
 		String vpara910 = "910" ;
 		
		String  vkotandInvocieONSamePrinter =  new getConfigurationSetting().getSpecificConfiguration(vpara907);
	    String  vkotprintername =  new getConfigurationSetting().getSpecificConfiguration(vpara908);
	    String  vkotholdreport =  new getConfigurationSetting().getSpecificConfiguration(vpara909);
	    String  vkotDirectReport=  new getConfigurationSetting().getSpecificConfiguration(vpara910);
    		    
	    String vpara911 = "911" ;
		String  printKOT = new getConfigurationSetting().getSpecificConfiguration(vpara911);
 		    try 
		    {
	 		    switch(printKOT)
		        {
	 	        case "Y":
	 			
	 	        //new General().msg(vkotholdreport);	
	 	        String SQL = "call  printKOTCancel(" + vcomp + " , " + vstore + " ,  '"+ vordertype+"', "
						+ " '"+vmobile+"' , '"+ vtableno+"' ,  '"+ vorderno+"' ,  '"+vorderdate+"'  )";
 				this.getSPResult(SQL) ;
				break ;
		      }    
	        } catch (Exception e) {
			  new General().Quickmsg("KOT Print " + e.getLocalizedMessage());
		     } 
 		    finally 
		    {
  		    	String vreport = vkotholdreport ; // "KOTPrint.jasper";
  		    	switch(printKOT)
		        {
			 
				    case "Y":
		 			switch(vkotandInvocieONSamePrinter.trim())
					{
						case "Y" :
					  		//new General().Quickmsg("Printing on  Invoice Printer");
		 					gnPrintMasters rpt = new gnPrintMasters();
		  					rpt.print(vreport);
		  					rpt = null;
						break ;
		
						case "N" :
				 	        //new General().msg(vkotprintername);	
 							gnPrintMasters rpt1 = new gnPrintMasters();
		  					rpt1.printKOT(vreport , vkotprintername);
		  					rpt = null;
						break ;
		 			}
		 			break ;
	 				case "N" :
					new General().Quickmsg("KOT Printing is Disabled Please Check Config File ..");
					break ;
		}
  		}
  	}

	
	
	
	
	
	public void callprint(String doctype, String docno, String vdocdate) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		switch (doctype) {
 
		case "RV":
			try {
				String SQL = "call   printPaymentReceipt(" + vcomp + " , " + vstore + " , " + docno + ",  '" + vdocdate + "', '" + doctype + "')";
				this.getSPResult(SQL);
				this.closeconn();
			} catch (Exception e) {
				new General().msg("Receipt Voucher" + e.getMessage());
			} finally {
				String vreport = "PaymentReceipt.jasper";
				gnPrintMasters rpt = new gnPrintMasters();
				rpt.print(vreport);
				rpt = null;
 			}
			break;

 
			
		case "PV":
			try {
				String SQL = "call   printPaymentReceipt(" + vcomp + " , " + vstore + " , " + docno + ",  '" + vdocdate + "', '" + doctype + "')";
				this.getSPResult(SQL);
				this.closeconn();
			} catch (Exception e) {
				new General().msg("Payment Voucher" + e.getMessage());
			} finally {
				String vreport = "PaymentReceipt.jasper";
				gnPrintMasters rpt = new gnPrintMasters();
				rpt.print(vreport);
				rpt = null;
 			}
			break;

		
		case "GRN":
			try {
				String SQL = "call printgrn(" + vcomp + " , " + vstore + " , " + docno + ")";
				this.getResult(SQL);
				this.closeconn();

			} catch (Exception e) {
				new General().msg("GNDOCPRINT" + e.getMessage());
			} finally {
				// String vreport = "mygrn.jasper";
				String vreport = new gnPublicVariable().PrintGRNFormat;
				gnPrintMasters rpt = new gnPrintMasters();
				rpt.print(vreport);
				rpt = null;

				String isregister = new gnGST().ismyComanyGSTRegister();
				if (isregister == "Y") {
					String vreport1 = "gst_taxData.jasper";
					// String vreport = new gnPublicVariable().PrintGRNFormat ;
					gnPrintMasters rpt1 = new gnPrintMasters();
					rpt1.print(vreport1);
					rpt = null;
				}

			}
			break;

		case "CN":
			try {
				String SQL = "call   printdncn(" + vcomp + " , " + vstore + " , " + docno + ",  '" + doctype + "')";
				// new General().msg(SQL) ;
				this.getResult(SQL);
				this.closeconn();
			} catch (Exception e) {
				new General().msg("SR Raising CN" + e.getMessage());
			} finally {
				String vreport = "dncnreport.jasper";
				// String vreport = new gnPublicVariable().Print_invoiceFormat()
				// ;
				gnPrintMasters rpt = new gnPrintMasters();
				rpt.print(vreport);
			}
			break;

		case "CUSTADV":
			try {
				String SQL = "call   printdncn(" + vcomp + " , " + vstore + " , " + docno + ",  '" + doctype + "')";
				this.getResult(SQL);
				this.closeconn();
			} catch (Exception e) {
				new General().msg("Debit note DN" + e.getMessage());
			} finally {
				String vreport = "dncnreport.jasper";
				gnPrintMasters rpt = new gnPrintMasters();
				rpt.print(vreport);
				rpt = null;
			}
			break;

		case "DN":
			try {
				String SQL = "call   printdncn(" + vcomp + " , " + vstore + " , " + docno + ",  '" + doctype + "')";
				this.getResult(SQL);
				// this.closeconn();
			} catch (Exception e) {
				new General().msg("Debit note DN" + e.getMessage());
			} finally {
				String vreport = "dncnreport.jasper";
				gnPrintMasters rpt = new gnPrintMasters();
				rpt.print(vreport);
				rpt = null;
			}
			break;

		case "SUPLADV":
			try {
				String SQL = "call   printdncn(" + vcomp + " , " + vstore + " , " + docno + ",  '" + doctype + "')";
				this.getSPResult(SQL);
				this.closeconn();
			} catch (Exception e) {
				new General().msg("Debit note DN" + e.getMessage());
			} finally {
				String vreport = "dncnreport.jasper";
				gnPrintMasters rpt = new gnPrintMasters();
				rpt.print(vreport);
				rpt = null;

			}
			break;

		case "POSINV":
			try {
				String SQL = "call   printposinvoice(" + vcomp + " , " + vstore + " , " + docno + ", '" + vdocdate
						+ "')";
 				this.getSPResult(SQL);
				 String vreport = new gnPublicVariable().Print_invoiceFormat();
 				    //vreport = "FarmTrolly.jasper" ;
 				    //vreport = "HardwareNew.jasper" ;
     		        //vreport = "RestoCashMemo.jasper" ;
				    //vreport = "posInvoice.jasper" ;
 			        //vreport = "NonTaxablePosInvoice.jasper" ;
 			        //vreport = "TaxableInvoice1.jasper" ;
				    //vreport = "TaxableInvoice2.jasper" ;
   			        gnPrintMasters rpt = new gnPrintMasters();
				    rpt.Invoiceprint(vreport, docno, vdocdate);
    			} catch (Exception e) {
				new General().msg("POS Invoice PRINT " + e.getMessage());
			}
			break;
			
			

		case "Credit-INV":
			try {
				String SQL = "call   printposinvoice(" + vcomp + " , " + vstore + " , " + docno + "  , '" + vdocdate
						+ "')";
				this.getResult(SQL);
				String vreport = new gnPublicVariable().CreditSalesFormat;
				gnPrintMasters rpt = new gnPrintMasters();
				rpt.print(vreport);
				rpt = null;
			} catch (Exception e) {
				new General().msg("Credit Sales Invoice PRINT " + e.getMessage());
			}
			break;

			
		case "AutoQ":

			try {

			String SQL56 = "call   printquot11automobile(" + vcomp + " , " + vstore + " , " + docno + "  , '" + vdocdate
			+ "')";
 			this.getResult(SQL56);
			this.closeconn();
 			} catch (Exception e) {
				new General().msg("PO" + e.getMessage());
			} finally {
				 String vreport = "AshwamedhQ.jasper";
				//String vreport = new gnPublicVariable().Print_poFormat();
				gnPrintMasters rpt = new gnPrintMasters();
				rpt.print(vreport);
				rpt = null;
			}

			break ;
 			
		case "PO":
			try {
				String SQL = "call printpo(" + vcomp + " , " + vstore + " , " + docno + ")";
				this.getResult(SQL);
				this.closeconn();

			} catch (Exception e) {
				new General().msg("PO" + e.getMessage());
			} finally {
				// String vreport = "po.jasper";
				String vreport = new gnPublicVariable().Print_poFormat();
				gnPrintMasters rpt = new gnPrintMasters();
				rpt.print(vreport);
				rpt = null;
			}
			break;
		case "MyDoc":
			String vreport = "testmarathi.jasper";
			gnPrintMasters rpt = new gnPrintMasters();
			rpt.print(vreport);
			rpt = null;
			break;
		}

	}

}// last
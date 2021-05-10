package RetailProduct;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.view.JasperViewer;

import org.apache.log4j.Logger;

public class gnPrintMasters extends getResultSet {
	private static String jasperFileName;
	private String vcomp = null;
	private String vstore = null;
	HashMap hm = null;
	private String jasperFile = null;
	private Connection conn = null;
	JasperViewer jv = null;

	@SuppressWarnings("deprecation")

	
	public void Invoiceprint(String jsperFileName, String vdocno, String vdocdate) throws Throwable {

 		org.apache.log4j.BasicConfigurator.resetConfiguration();
		File myfile;
 		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		try {
			conn = this.getConnection();
			jasperFile = jsperFileName;
 			String ReportPath = this.ReportEexutionPath();
			jasperFileName = (ReportPath + jasperFile);
			//new General().msg(jasperFileName);
			myfile = new File(jasperFileName);
			if (myfile.exists()) 
			{
				//new General().msg(jasperFileName + "" +"File Found");
 				hm = new HashMap();
				hm.put("vcomp", vcomp);
 				try {
 			  		//JasperReport rep = JasperCompileManager.compileReport(jasperFileName);
 			  		JasperReport rep = (JasperReport) JRLoader.loadObject(new File(jasperFileName));
   					//new General().msg(jasperFileName + "" +"Report Loaded");
     				JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(rep, hm, conn);
   					//new General().msg(jasperFileName + "" +"JRPRINT RUN");
     				String printFileName = JasperFillManager.fillReportToFile(jasperFileName, hm, conn);
   					String vpdfFile = "posinvoice" + vdocno + ".pdf";
    					

   					String pdfFileName = ProductPath + "MyReports//MyReports//Output//" + vpdfFile;
					JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
  					
					
					//TExt Export 
					
					String vtextfile = "invoice" + ".txt"; // TExt Print
		  			String txtFileName = ProductPath + "MyReports//MyReports//Output//invoice.txt" ;

					JRTextExporter exporter = new JRTextExporter();
					exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 80);
					exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 40);
					exporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, new Float(2.55));// 6.55
																									// //6
					exporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, new Float(11.9)); // 11//10
					exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
					exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, txtFileName);
					exporter.exportReport();
					// End Text Export
					
					
					new gnLogger().loggerInfoEntry("POS", "Report Generated in " + (System.currentTimeMillis() ) + "ms");
 					String vpara27 = "27";
					vpara27 = new getConfigurationSetting().getSpecificConfiguration(vpara27);
 					switch(vpara27)
					{
						case "Y" :
							new gnFile().PrintFile(pdfFileName);
							break ;
						
						case "N":
 							jv = new JasperViewer(printFileName, false, false);
							jv.setAlwaysOnTop(true);
							jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							jv.setDefaultCloseOperation(jv.getState());
							jv.setSize(500, 500);
							jv.setTitle("View Report ");
							jv.setAutoRequestFocus(true);
							jv.setVisible(true);
							break ;
 					}
   				} catch (Exception e) {
					new General().msg("Print Document"+ e.getLocalizedMessage());
 	 			}
				finally{
 					jasperFileName = null;
 	 			}
			} else {
				new General().msg(jsperFileName + " " + "Report File Not Available...Please Check Reports Directory");
			}
		} catch (Exception e) {
		}
	}


	
	

	public void printKOT(String jsperFileName , String vprintername) throws Throwable {

		 
   		org.apache.log4j.BasicConfigurator.configure();
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		try {
			conn = this.getConnection();
			jasperFile = jsperFileName;
			String ReportPath = this.ReportEexutionPath();
			jasperFileName = (ReportPath + jasperFile);
			//new General().Quickmsg("Report is " +""+jasperFileName +" and Printer is ->"+ vprintername);
 			hm = new HashMap();
			hm.put("vcomp", vcomp);
	  		//JasperReport jasperMasterReport = JasperCompileManager.compileReport(jasperFileName);
 			//JasperReport rep = (JasperReport) JRLoader.loadObject(new File(jasperFileName));
      		JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFileName, hm, conn);
			String printFileName = JasperFillManager.fillReportToFile(jasperFileName, hm, conn);
  
			new gnLogger().loggerInfoEntry("POS", "Report Generated in " + (System.currentTimeMillis() ) + "ms");

			// Export pdf file
			String pdfFileName = ProductPath + "MyReports//MyReports//Output//printDoc.pdf";
  			JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
 
  			String vpara27 = "27";
			String vprintInvoice = new getConfigurationSetting().getSpecificConfiguration(vpara27);
 			switch(vprintInvoice.trim().toUpperCase())
			{
				case "Y" :
			 		new gnFile().pdfboxPrint(pdfFileName , vprintername); //Current Working 
 			 		//new gnFile().PrintKOTFile(pdfFileName , vprintername); //Old 
			 	 	break ;
			 	 	
 				case "N" :
 					jv = new JasperViewer(printFileName, false, false);
					jv.setAlwaysOnTop(true);
					jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					jv.setDefaultCloseOperation(jv.getState());
					jv.setSize(500, 500);
					jv.setTitle("Report View");
					jv.setVisible(true);
					jv.setAutoRequestFocus(true);
					jprint = null;
					jasperFileName = null;
					vcomp = null;
					vstore = null;
					hm = null;
					jasperFile = null;
					break ;
 			}//Switch
   	} catch (Exception e) {
   		new General().msg("gnPrintFile Error" +""+e.getLocalizedMessage());
   		
   	}
	}

	

	public void print(String jsperFileName) throws Throwable {
		// This Method is for Non Invoice Printing Documents
 		org.apache.log4j.BasicConfigurator.configure();
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		try {
			conn = this.getConnection();
			jasperFile = jsperFileName;
			String ReportPath = this.ReportEexutionPath();
			jasperFileName = (ReportPath + jasperFile);
			//new General().msg(jasperFileName);
			hm = new HashMap();
			hm.put("vcomp", vcomp);
		  		
			//JRSaver.saveObject(jasperFileName.toJasperPrint(),  "fullPath/yourReport.jrprint");
			JasperReport rep = (JasperReport) JRLoader.loadObject(new File(jasperFileName));
 			JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(rep, hm, conn);
			String printFileName = JasperFillManager.fillReportToFile(jasperFileName, hm, conn);
  
			new gnLogger().loggerInfoEntry("POS", "Report Generated in " + (System.currentTimeMillis() ) + "ms");

			// Export pdf file
			String pdfFileName = ProductPath + "MyReports//MyReports//Output//PrintDoc.pdf";
			//String docFileName = ProductPath + "MyReports//MyReports//Output//printDoc.doc";
 			JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
  			
 			
			String vpara27 = "27";
			vpara27 = new getConfigurationSetting().getSpecificConfiguration(vpara27);
				
			switch(vpara27)
			{
				case "Y" :
			    new gnFile().PrintFile(pdfFileName);
			    break ;
				
				case "N" :
 					jv = new JasperViewer(printFileName, false, false);
					jv.setAlwaysOnTop(true);
					jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					jv.setDefaultCloseOperation(jv.getState());
					jv.setSize(500, 500);
					jv.setTitle("Report View");
					jv.setVisible(true);
					jv.setAutoRequestFocus(true);
					jprint = null;
					jasperFileName = null;
					vcomp = null;
					vstore = null;
					hm = null;
					jasperFile = null;
 			}
   	} catch (Exception e) {
	    
   		new General().msg(e.getMessage());	
	    new gnLogger().loggerInfoEntry("Printing Issue:", e.getMessage());
     }
	}

	
	
	public void printBarcode(String jsperFileName) throws Throwable {
		// This Method is for Non Invoice Printing Documents
 		org.apache.log4j.BasicConfigurator.configure();
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		try {
			conn = this.getConnection();
			jasperFile = jsperFileName;
			String ReportPath = this.ReportEexutionPath();
			jasperFileName = (ReportPath + jasperFile);
			//new General().msg(jasperFileName);
			hm = new HashMap();
			hm.put("vcomp", vcomp);
		  		
			//JRSaver.saveObject(jasperFileName.toJasperPrint(),  "fullPath/yourReport.jrprint");
			//JasperReport rep = JasperCompileManager.compileReport(jasperFileName);
 			JasperReport rep = (JasperReport) JRLoader.loadObject(new File(jasperFileName));
  			JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(rep, hm, conn);
			String printFileName = JasperFillManager.fillReportToFile(jasperFileName, hm, conn);
  
			/*
			int offsetX = 10;
			int offsetY =  10;
			JRPrintServiceExporter exporter = new JRPrintServiceExporter(); 
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint); 
			exporter.setParameter(JRExporterParameter.OFFSET_X, offsetX); 
			exporter.setParameter(JRExporterParameter.OFFSET_Y, offsetY); 
 			exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, true); 
			exporter.exportReport();
			*/
 
			// Export pdf file
			String pdfFileName = ProductPath + "MyReports//MyReports//Output//BarcodePrint.pdf";
			//String docFileName = ProductPath + "MyReports//MyReports//Output//printDoc.doc";
 			JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
			new gnLogger().loggerInfoEntry("POS", "Report Generated in " + (System.currentTimeMillis() ) + "ms");
 			
 			
			String vpara27 = "27";
			vpara27 = new getConfigurationSetting().getSpecificConfiguration(vpara27);
				
			switch(vpara27)
			{
				case "Y" :
			    new gnFile().PrintFile(pdfFileName);
			    break ;
				
				case "N" :
 					jv = new JasperViewer(printFileName, false, false);
					jv.setAlwaysOnTop(true);
					jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					jv.setDefaultCloseOperation(jv.getState());
					jv.setSize(500, 500);
					jv.setTitle("Report View");
					jv.setVisible(true);
					jv.setAutoRequestFocus(true);
					jprint = null;
					jasperFileName = null;
					vcomp = null;
					vstore = null;
					hm = null;
					jasperFile = null;
 			}
   	} catch (Exception e) {
	    
   		new General().msg(e.getMessage());	
	    new gnLogger().loggerInfoEntry("Printing Issue:", e.getMessage());
     }
	}

	
	
	
  
	
	
	public void homeDel_addrPrint(String jsperFileName) throws Throwable {
		org.apache.log4j.BasicConfigurator.configure();
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		try {
			conn = this.getConnection();
			jasperFile = jsperFileName;
			String ReportPath = new gnApplicationSetting().ReportEexutionPath();
			// jasperFileName = (ReportPath +jasperFile);
			jasperFileName = ("D:/Java/myReports/myReports/src/" + jsperFileName);
			// new General().msg(jsperFileName);
			hm = new HashMap();
			hm.put("vcomp", vcomp);

			JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFileName, hm, conn);
			// String printFileName =
			// JasperFillManager.fillReportToFile(jasperFileName, hm, conn) ;

			// TExt Print
			String txtFileName = ("D:/AKN/myReports/myReports/output/homeDelAddress.txt");
			JRTextExporter exporter = new JRTextExporter();
			exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 80);
			exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 40);
			exporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, new Float(2.55));// 6.55
																							// //6
			exporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, new Float(11.9)); // 11//10
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, txtFileName);
			exporter.exportReport();
			
			new gnFile().PrintFile(txtFileName);
			// End TExt file

			/*
			 * //Pdf File Generation and Print String pdfFileName =
			 * "D://AKN//MyReports//MyReports//Output//document.pdf" ;
			 * JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
			 * new gnFile().PrintFile(pdfFileName); //End Pdf File Generation
			 * and Print
			 */
			/*
			 * //JAsper Viewer JasperViewer jv=new JasperViewer(pdfFileName,
			 * false, false); jv.setAlwaysOnTop(true);
			 * jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			 * jv.setDefaultCloseOperation(jv.getState()); jv.setSize(500, 500);
			 * jv.setTitle("View Report "); jv.setVisible(true);
			 * jv.setAutoRequestFocus(true); jv.setVisible(false);
			 */

			/*
			 * // Rtf File Exort
			 * 
			 * String rtfFileName =
			 * "D://AKN//MyReports//MyReports//Output//document.rtf" ;
			 * JRRtfExporter rtfExporter = new JRRtfExporter();
			 * rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT,
			 * jprint);
			 * rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,
			 * rtfFileName); rtfExporter.exportReport(); //End Ref Export
			 */

		} catch (Exception e) {
		}
	}

	// String printFileName =
	// JasperFillManager.fillReportToFile(jasperFileName, hm, conn) ;
	/*
	 * String vtextfile = "posinvoice"+vdocno+".txt" ; //TExt Print //String
	 * txtFileName = ("D:/AKN/myReports/myReports/output/nkposinvoice.txt");
	 * String txtFileName = ("D:/AKN/myReports/myReports/output/"+vtextfile);
	 * 
	 * JRTextExporter exporter = new JRTextExporter();
	 * exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 80);
	 * exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 40);
	 * exporter.setParameter(JRTextExporterParameter.CHARACTER_WIDTH, new
	 * Float(2.55));//6.55 //6
	 * exporter.setParameter(JRTextExporterParameter.CHARACTER_HEIGHT, new
	 * Float(11.9)); //11//10
	 * exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
	 * exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, txtFileName);
	 * exporter.exportReport(); new gnFile().PrintFile(txtFileName); // End TExt
	 * file
	 */

	 
	
}// last

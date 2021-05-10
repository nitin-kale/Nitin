package RetailProduct;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.print.PrintService;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;

public class gnFile {

	String vcomp;
	String vstore;
	String filePath;
	File selectedFile;

	public String getFile1(JPanel jsp) {
		String filePath = " ";
		File vfile1 = new File("D:\\akn\\uploadFile\\ArticleUpload.xls");
		JFileChooser fileChooser = new JFileChooser();
		FileFilter filter = new FileNameExtensionFilter("My SQL DB File", "SQL");
		fileChooser.addChoosableFileFilter(filter);
		fileChooser.setDialogTitle("Select File ");
		fileChooser.setBackground(Color.white);
		fileChooser.setCurrentDirectory(vfile1);
		int returnValue = fileChooser.showOpenDialog(jsp);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String filename = selectedFile.getAbsolutePath();
			String ext2 = FilenameUtils.getExtension(filename);
			if (!ext2.toUpperCase().equals("SQL")) {
				new General().msg("Wrong File Selected Please Select SQL File");
			} else {
				filePath = filename;
			}
		}

		return filePath;
	}

	public String getFile(JScrollPane jsp) {
		String filePath = " ";
		File vfile1 = new File("D:\\akn\\uploadFile\\ArticleUpload.xls");
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Select File For Upload Article Master");
		fileChooser.setBackground(Color.white);
		fileChooser.setCurrentDirectory(vfile1);
		int returnValue = fileChooser.showOpenDialog(jsp);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String filename = selectedFile.getAbsolutePath();
			filePath = filename;
		}

		return filePath;
	}

	
	
	
	public void openFile() throws IOException {
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = fileChooser.getSelectedFile();
			String filename = selectedFile.getAbsolutePath();
			filePath = filename;
		}
		Desktop dt = Desktop.getDesktop();
		dt.print(selectedFile);
		// dt.open(new File(filePath));
	}

	
	
	public void PrintFile(String flname) throws IOException {
		selectedFile = new File(flname);
		//new General().Quickmsg(selectedFile.toString());
		String filename = selectedFile.getAbsolutePath();
		filePath = filename;
		Desktop dt = Desktop.getDesktop();
		try {
			dt.print(selectedFile);
			new gnLogger().loggerInfoEntry("Printing", "Sucess");
 		} catch (Exception e) {
			new General().msg(e.getMessage());
			new gnLogger().loggerInfoEntry("Printing Issue", e.getLocalizedMessage());
		}
	}

public  String CheckPrinterAvailable(String myprinterName)
{
	String vfound = "NO" ;
	PrintService[] jk = new PrinterService().getPrintServices() ;
	String vprintername = myprinterName ;
	vfound = new PrinterService().findPrinter(vprintername , jk) ;
 	switch(vfound)
		{
				case "YES" :
					//new General().Quickmsg("Network Printer Found...File Can Print" + " "+myprinterName);
					break;
				case "NO" :
					new General().msg("Network Printer Not Found..."+ " "+myprinterName);
					break;
 		}
	return vfound;
 }
	
	
public void pdfboxPrint(String flname , String myprinterName) throws PrinterException, IOException
{
	
	        String vprinerAvailable  = new gnFile().CheckPrinterAvailable(myprinterName);
  		    String pdfFile =  flname;
		    PDDocument document = null;
  			//PrintService[] jk = new PrinterService().getPrintServices() ;
			//String vprintername = myprinterName ;
			//String vfound = new PrinterService().findPrinter(vprintername , jk) ;
 			//switch(vfound.toUpperCase())
 			//{
 			//case "YES" :
	 		 try 
			 {
				document = PDDocument.load(pdfFile);
	 		    PrinterJob printJob = PrinterJob.getPrinterJob();
			    printJob.setJobName(new File(pdfFile).getName());
			    PrintService[] printService = PrinterJob.lookupPrintServices();
			    boolean printerFound = false;
			    for (int i = 0; !printerFound && i < printService.length; i++) 
			    {
			        if (printService[i].getName().indexOf(myprinterName) != -1) 
			        {
			            printJob.setPrintService(printService[i]);
			            printerFound = true;
	  					//new General().msg("(gnfile)Network Printer Found:" + myprinterName);
 			        }
			    }
			     document.silentPrint(printJob);
		 		 new gnLogger().loggerInfoEntry("Printing", "Sucess");
 		    } catch(Exception e)
		    {
		    	new General().msg(e.getLocalizedMessage());
 		    	new gnLogger().loggerInfoEntry("Printing Fail", e.getLocalizedMessage());
		    }
 		    finally {
 		      if (document != null) {
		    	  document.close();
		      }
		    }
		  
	 		 
	 	  //break ;
 		  //case "NO":
		  //	new General().msg("Network Printer Not Found XXX..."+ " "+myprinterName);
		  //   break; 
		  //}//Switch
 }
	
	
	
	public void PrintKOTFile(String flname , String myprinterName) throws Throwable {
        new General().msg("Printing KOT FILE  option2");
 		selectedFile = new File(flname);
 		String filename = selectedFile.getAbsolutePath();
		filePath = filename;
  		String vpara912 = "912" ;
		String  voption =  new getConfigurationSetting().getSpecificConfiguration(vpara912);
 		try {
 			PrintService[] jk = new PrinterService().getPrintServices() ;
  			new gnLogger().loggerInfoEntry("Printer SErvice Array", jk.toString());
 			String vprintername = myprinterName ;
			String vfound = new PrinterService().findPrinter(vprintername , jk) ;
 			switch(vfound.toUpperCase())
 			{
 				case "YES" :
  					new General().msg("Network Printer Found:" + vprintername);
					new PrinterService().printPdf(vprintername, selectedFile , voption) ;
		  			new gnLogger().loggerInfoEntry("Printer Found - Name is ", vprintername);
 					break ;
	 			case "NO" :
	 				new General().msg("Printer Not Found .. "+" "+vprintername );	
		  			new gnLogger().loggerInfoEntry("Printer Not Found <X> Name is ", vprintername);
 	 				break ;
	 			}
  			new gnLogger().loggerInfoEntry("Printing", "Sucess");
 		} catch (Exception e) {
		
 			new General().msg(e.getMessage());
			new gnLogger().loggerInfoEntry("Printing Issue", e.getLocalizedMessage());
		}
	}
	
	
}
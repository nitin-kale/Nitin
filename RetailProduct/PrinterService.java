package RetailProduct;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;

public class PrinterService implements Printable {

	
	public List<String> getPrinters() {
		DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		PrintService printServices[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
		List<String> printerList = new ArrayList<String>();
		for (PrintService printerService : printServices) {
			printerList.add(printerService.getName());
			System.out.println(printerService.getName());
		}
		return printerList;
	}

	@Override
	public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
		if (page > 0) { /* We have only one page, and 'page' is zero-based */
			return NO_SUCH_PAGE;
		}
		/*
		 * User (0,0) is typically outside the imageable area, so we must
		 * translate by the X and Y values in the PageFormat to avoid clipping
		 */
		Graphics2D g2d = (Graphics2D) g;
		g2d.translate(pf.getImageableX(), pf.getImageableY());
		/* Now we perform our rendering */
		g.setFont(new Font("Roman", 0, 8));
		g.drawString("Hello world !", 0, 10);
		return PAGE_EXISTS;
	}

	
	public void printPdf(String printerName, File vpdf  , String voption) {
		// find the printService of name printerName
 		//new General().msg("file Name is :" + "" +vpdf.toString());
		try {
			
 		DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
 
 		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);

		PrintService service = findPrintService(printerName, printService);
		DocPrintJob job = service.createPrintJob();
 		switch(voption)
		{
		
		case "1" :
		FileInputStream fis1=new FileInputStream(vpdf);
	    Doc doc1=new SimpleDoc(fis1, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
 	    PrintRequestAttributeSet attrib=new HashPrintRequestAttributeSet();
	    attrib.add(new Copies(1));
 	    job.print(doc1, attrib);
 	      
 	    break ;  
 	      
 	    
		case "2" :
			
 		FileInputStream fis=new FileInputStream(vpdf);
  	    Doc pdfDoc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
 	    DocPrintJob printJob = service.createPrintJob();
 	    printJob.print(pdfDoc, new HashPrintRequestAttributeSet());
 	    fis.close();
  	    break ;
 
		case "3" :
			FileInputStream fis3=new FileInputStream(vpdf);
		    Doc doc3=new SimpleDoc(fis3, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
 			byte[] bytes;
 			bytes = vpdf.toString().getBytes("CP437");
  			doc3 = new SimpleDoc(bytes, flavor, null);
			job.print(doc3, null);
			break ;
		}	
			
		} catch (Exception e) {
 			e.printStackTrace();
		}
	}

	 
	
	
	private static PrintService findPrintService(String printerName, PrintService[] services) {
		for (PrintService service : services) {
			System.out.println(service.getName());
 			if (service.getName().equalsIgnoreCase(printerName)) {
				//new General().Quickmsg(printerName + " " + "found");
				//System.out.println(service.getName());
				return service;
			}
		}
		return null;
	}

	

	public String  findPrinter(String printerName, PrintService[] services) {
		String found  = "NO" ;
		for (PrintService service : services) {
			if (service.getName().equalsIgnoreCase(printerName)) {
				//new General().Quickmsg(printerName + " " + "found"+" "+printerName);
				found = "YES";
 			}
		}
		return found;
	}


	
	
	public static  PrintService[] getPrintServices() {
		DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		PrintService printServices[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
 		return printServices ;
	}

	 	
	
//=============
	
	public void printBytes(String printerName, byte[] bytes) {

 		DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
		PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
		PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
		PrintService service = findPrintService(printerName, printService);
		DocPrintJob job = service.createPrintJob();
		try {
			Doc doc = new SimpleDoc(bytes, flavor, null);
			job.print(doc, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	public void printnow() {
		PrinterService printerService = new PrinterService();
		//System.out.println(printerService.getPrinters());
	 	//printerService.printString("Microsoft XPS Document Writer, Fax",
			//	"\n\n Meretoo Software Solutions \n   GST NO: ZjhjhjhSSSS \n  1010  Gulab jamun\n\n\n\n\n\n\n\n\n\n\n\n\n");
 		// cut that paper!
		byte[] cutP = new byte[] { 0x1d, 'V', 1 };
		printerService.printBytes("HP LaserJet P1007", cutP);
	}



	
public static void main(String[] args)
{

	
 	//File vpdf =  new File("D://printDoc.pdf");
	//String vname  = "HP LaserJet P1007" ;
	//String voption = "1" ;
	//PrinterService abc =  new PrinterService();
	//abc.printPdf( vname ,  vpdf , voption);
	//abc.printnow();
	
}
	




}
package RetailProduct;

import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.PrintJobAttributeSet;
import javax.print.event.PrintJobAdapter;
import javax.print.event.PrintJobEvent;

public class GenerateInvoice {

	public static void printInvoice(String invoice) {
		try {

			invoice = "                               Nitin Kale  /n"
					+ "                               C-6 Sai Palace Pune /n"
					+ "=========================================/n"
					+ " Name             Qty             Rate          Value /n"
					+ "===========================================/n"
					+ " Amul               20               20.00          400.00/n";

			new General().msg(invoice);
			Printable mPrinter = null;
			Boolean bFoundPrinter = false;

			PrintService[] printServices = PrinterJob.lookupPrintServices();
			for (PrintService printService : printServices) {
				String sPrinterName = printService.getName();
				new General().msg(sPrinterName);
				if (sPrinterName.equals("Microsoft XPS Document Writer")) {
					mPrinter = (Printable) printService;
					bFoundPrinter = true;
				}
			}
			String testData = invoice + "\f";
			InputStream is = new ByteArrayInputStream(testData.getBytes());
			new General().msg(is.toString());
			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;

			PrintService service = PrintServiceLookup.lookupDefaultPrintService();
			System.out.println(service);

			DocPrintJob job = service.createPrintJob();
			Doc doc = new SimpleDoc(is, flavor, null);

			PrintJobWatcher pjDone = new PrintJobWatcher(job);
			PrintJobAttributeSet vatt1 = job.getAttributes();
			new General().msg("Attri" + " " + vatt1.toArray().toString());
			job.print(doc, null);
			pjDone.waitForDone();
			is.close();
		} catch (PrintException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static class PrintJobWatcher {
		boolean done = false;

		PrintJobWatcher(DocPrintJob job) {
			// Add a listener to the print job
			job.addPrintJobListener(new PrintJobAdapter() {
				public void printJobCanceled(PrintJobEvent pje) {
					allDone();
				}

				public void printJobCompleted(PrintJobEvent pje) {
					allDone();
				}

				public void printJobFailed(PrintJobEvent pje) {
					allDone();
				}

				public void printJobNoMoreEvents(PrintJobEvent pje) {
					allDone();
				}

				void allDone() {
					synchronized (PrintJobWatcher.this) {
						done = true;
						PrintJobWatcher.this.notify();
					}
				}
			});
		}

		public synchronized void waitForDone() {
			try {
				while (!done) {
					wait();
				}
			} catch (InterruptedException e) {
			}
		}
	}

}
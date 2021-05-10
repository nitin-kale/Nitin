package RetailProduct;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import javax.swing.JFrame;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRTextExporterParameter;
import net.sf.jasperreports.view.JasperViewer;

// import com.mycompany.helper.* ;
// import com.mycompany.dbi.*;

public class ReportGenerator {
	private static String jrxmlFileName;
	private static String jasperFileName;
	private static String pdfFileName;
	private static String htmlFileName;
	private static String txtFileName;
	private File htmlFileName1;
	private String vcomp;
	private String vstore;
	HashMap hm = null;

	@SuppressWarnings("deprecation")
	public void printInvoice(String vinvno) throws Throwable {
		org.apache.log4j.BasicConfigurator.configure();
		// vcomp = new gnConfig().getCompanyCode() ;
		// vstore = new gnConfig().getStoreID() ;
		vcomp = "1000";
		vstore = "1001";

		try {
			System.out.println("Start Report Creation ....");

			File txtFileName1 = new File("D:/java/myReports/myReports/output/invoice.txt");
			jasperFileName = ("D:/java/myReports/myReports/src/invoice.jasper");
			jrxmlFileName = ("D:/ava/myReports/myReports/source/ninvoice.jrxml");
			pdfFileName = ("D:/java/myReports/myReports/output/invoice.pdf");
			txtFileName = ("D:/java/myReports/myReports/output/invoice.txt");

			// JasperCompileManager.compileReportToFile(jrxmlFileName,
			// jasperFileName);

			String dbUrl = "jdbc:mysql://localhost/master";
			String dbDriver = "com.mysql.jdbc.Driver";
			String dbUname = "root";
			String dbPwd = "aayushi7";

			Class.forName(dbDriver);
			Connection conn = DriverManager.getConnection(dbUrl, dbUname, dbPwd);

			hm = new HashMap();
			hm.put("vinvno", vinvno);
			hm.put("vcomp", vcomp);
			hm.put("vstore", vstore);

			// new General().msg("Map Data"+" "+hm);

			System.out.println("Generating  reports to jasper file foramt");
			JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFileName, hm, conn);
			String printFileName = JasperFillManager.fillReportToFile(jasperFileName, hm, conn);

			// JasperPrintManager.printReport(printFileName, true);

			// TExt file Export
			JRTextExporter exporter = new JRTextExporter();
			exporter.setParameter(JRTextExporterParameter.PAGE_WIDTH, 80);
			exporter.setParameter(JRTextExporterParameter.PAGE_HEIGHT, 40);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, txtFileName);
			exporter.exportReport();

			JasperPrintManager.printReport(txtFileName, true);

			// Jasper Viewer
			/// ==================================
			JasperViewer jv = new JasperViewer(printFileName, false, false);
			jv.setAlwaysOnTop(true);
			jv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jv.setSize(900, 800);
			jv.setFitPageZoomRatio();
			jv.setTitle("Invoice Print For Invoice Number " + " " + vinvno);
			jv.setVisible(true);
			// ==================================

			// Export pdf file
			// JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
			// ==================================
			System.out.println("Done exporting reports Finishedf");
		} catch (Exception e) {
			System.out.print("Exceptiion" + e);
		}
	}

	public static void main(String[] args) throws Throwable {
		ReportGenerator rp = new ReportGenerator();
		rp.printInvoice("2017");
	}

}

package RetailProduct;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Report_master_table {
	public Connection conn;
	private static String jrxmlFileName;
	private static String jasperFileName;
	private static String pdfFileName;
	private HashMap kk;

	public void report() {
		jasperFileName = "D:/JAVA/MyReports/MyReports123/bin/invoice.jasper";
		jrxmlFileName = "D:/JAVA//MyReports/MyReports/bin/invoice.jrxml";
		pdfFileName = "D:/JAVA/MyReports/MyReports/bin/invoice.pdf";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/master", "root", "Aayushi7");
			// JasperCompileManager.compileReportToFile(jrxmlFileName,
			// jasperFileName);
			kk = new HashMap();
			kk.put("ID", "123");
			kk.put("DATENAME", "April 2006");
			JasperCompileManager.compileReportToFile(jrxmlFileName, jasperFileName);
			JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFileName, kk, conn);
			JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
			JasperExportManager.exportReportToPdfFile(jprint, pdfFileName);
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Report_master_table h = new Report_master_table();
		h.report();
	}

}

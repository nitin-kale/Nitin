package RetailProduct;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XML_createTOFile extends getResultSet {
	Connection con;
	String vcomp;
	String vstore;
	String vdocno;
	String vtostore;

	public void createTOFile(String vtype, String vdocno, String vtostore, String vdocdate) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocno = vdocno;
		vtostore = vtostore;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.newDocument();
		Element results = doc.createElement("TO");
		doc.appendChild(results);

		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		String SQL = "Call  xml_getDetail(" + vcomp + " , " + vstore + ", " + vdocno + " , '" + vtype + "' , '"
				+ vdocdate + "')";
		rs = this.getSPResult(SQL);
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCount = rsmd.getColumnCount();

		while (rs.next()) {
			Element row = doc.createElement("Row");
			results.appendChild(row);
			for (int i = 1; i <= colCount; i++) {
				String columnName = rsmd.getColumnName(i);
				String value = rs.getString(i);
				Element node = doc.createElement(columnName);
				node.appendChild(doc.createTextNode(value.toString()));
				row.appendChild(node);
			}
		}
		DOMSource domSource = new DOMSource(doc);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		File ToFile = new File("d://AKN//Files//TO//TO" + vdocno.concat("_").concat(vtostore).concat(".xml"));
		new General().msg("TO XML File Generated Is" + " " + ToFile);
		Result result = new StreamResult(ToFile);
		Source source = new DOMSource(doc);
		transformer.transform(source, result);
		this.closeconn();
		rs.close();
		// ToFile.deleteOnExit();
		// zipFile();
	}

	private void zipFile() throws IOException {
		File f = new File("d://AKN//Files//TO//TO" + vdocno.concat("_").concat(vtostore).concat(".zip"));
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
		ZipEntry e = new ZipEntry("d://AKN//Files//TO//TO" + vdocno.concat("_").concat(vtostore).concat(".xml"));
		out.putNextEntry(e);
		out.closeEntry();
		out.close();
		File g = new File("d://AKN//Files//TO//TO" + vdocno.concat("_").concat(vtostore).concat(".xml"));
		if (g.exists()) {
			g.delete();
		}
	}

	public static void main(String args[]) {

	}

}// Last

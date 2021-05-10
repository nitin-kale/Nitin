package RetailProduct;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class gnBarcode extends getResultSet {

	private String vcomp;
	private String vstore;

	public void GenerateBarcode(String vtype, String vprnfilename) throws ClassNotFoundException, SQLException {
		switch (vtype) {

		case "Repack":
			String vname = "GetBarcodeDate";
			String SQL = "call gnBarcode('" + vname + "')";
			rs = this.getSPResult(SQL);
			printBarcodeFile(vtype, rs, vprnfilename);
			break;
		}
	}

	private void printBarcodeFile(String vtype, ResultSet rs1, String vprnfile) {

		Pattern p = Pattern.compile("\\{.*?\\}");
		Matcher m = p.matcher(vprnfile);
		StringBuffer result = new StringBuffer();
		while (m.find()) {
			String key = vprnfile.substring(m.start() + 1, m.end() - 1);
			// String replacement = lookupVariable(key);
			// m.appendReplacement(result,
			// Matcher.quoteReplacement(replacement));
		}
		m.appendTail(result);
	}

	public void generate(String vdocno, String vdoctype, String vdocdate) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
		try {
			String SQL = "call PrintForData1(" + vcomp + " ,  " + vstore + ",  " + vdocno + ",  '" + vdoctype + "'  , '"
					+ vdocdate + "' )";
			// new General().msg(SQL);
			this.getResult(SQL);
			rs.close();
			this.closeconn();
		} catch (Exception e1) {

			// new General().msg(e1.getMessage());
		} finally {
			String SQL1 = "call  PrintForData()";
			// new General().msg(SQL1);
			this.getSPResult(SQL1);
			String Filename = new gnPublicVariable().Print_BarcodeFormat();
			// new General().msg(Filename);
			gnPrintMasters br = new gnPrintMasters();
			br.print(Filename);
		}
	}
}

package RetailProduct;

import javax.swing.JTable;
import javax.swing.JTextField;

public class gnCheckArticle {

	public String checkVendorSelected(JTextField vendorcode, JTextField vendorname) {
		String status = "Sucess";
		if (vendorcode.getText().length() == 0 && vendorname.getText().length() == 0) {
			new General().msg("No vendor is selected, Select Vendor ");
			status = "Fail";
		}
		return status;
	}

	public String checkArticleExist(JTable table, String varticle, int colposition) {
		String Action = "Sucess";
		int rowCount = 0;
		int i = 0;
		rowCount = table.getRowCount();
		String Colname = "";
		for (i = 0; i < rowCount; i++) {
			Colname = table.getValueAt(i, colposition).toString();
			if (Colname.equalsIgnoreCase(varticle)) {
				new General().msg("Already Present ..in Table ");
				Action = "Fail";
			}
		}
		return Action;
	}
}

package RetailProduct;

import java.awt.Component;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class gnFontSetting extends getResultSet {

	public static void setUIFont1(FontUIResource f) {
		Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				FontUIResource orig = (FontUIResource) value;
				Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
				UIManager.put(key, new FontUIResource(font));
			}
		}
	}

	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
		}
	}

	public void setMyFontBold(Component obj, String fontName, int size) {
		size = 14;
		switch (fontName) {
		case "F1":
			// (new Font("Tahoma", Font.PLAIN, 15
			// obj.setFont(new Font("Segoe UI Semibold", Font.BOLD, size));
			obj.setFont(new Font("Tahoma", Font.BOLD, size));
			break;
		case "F2":
			// obj.setFont(new Font("Microsoft Sans Serif", Font.BOLD, size));
			obj.setFont(new Font("Microsoft Sans Serif", Font.BOLD, size));
			break;
		case "F3":
			// obj.setFont(new Font("Segoe UI", Font.BOLD, size));
			obj.setFont(new Font("Tahoma", Font.BOLD, size));
			break;
		case "F4":
			// obj.setFont(new Font("Arial", Font.BOLD, size));
			obj.setFont(new Font("Tahoma", Font.BOLD, size));
			break;
		case "F5":
			// obj.setFont(new Font("Arial Black", Font.BOLD, 13));
			obj.setFont(new Font("Tahoma", Font.BOLD, size));
			break;
		case "F6":
			// obj.setFont(new Font("Arial Narrow", Font.BOLD, 13));
			obj.setFont(new Font("Tahoma", Font.BOLD, size));
			break;
		case "F7":
			// obj.setFont(new Font("MS Gothic", Font.BOLD, size));
			obj.setFont(new Font("Tahoma", Font.BOLD, size));
			break;
		case "F8":
			// obj.setFont(new Font("Agency FB", Font.BOLD,size));
			obj.setFont(new Font("Tahoma", Font.BOLD, size));
			break;

		}
	}

	public void setMyFont(Component obj, String fontName, int size) {
		size = 14;
		switch (fontName) {
		case "F1":
			obj.setFont(new Font("Tahoma", Font.PLAIN, size));
		case "F2":
			obj.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, size));
			// obj.setFont(new Font("Tahoma", Font.PLAIN, size));
			break;

		case "F3":
			// obj.setFont(new Font("Segoe UI", Font.PLAIN, size));
			obj.setFont(new Font("Tahoma", Font.PLAIN, size));
			break;
		case "F4":
			// obj.setFont(new Font("Arial", Font.PLAIN, size));
			obj.setFont(new Font("Tahoma", Font.PLAIN, size));
			break;
		case "F5":
			// obj.setFont(new Font("Arial Black", Font.PLAIN, 13));
			obj.setFont(new Font("Tahoma", Font.PLAIN, size));
			break;
		case "F6":
			// obj.setFont(new Font("Arial Narrow", Font.PLAIN, 13));
			obj.setFont(new Font("Tahoma", Font.PLAIN, size));
			break;
		case "F7":
			// obj.setFont(new Font("MS Gothic", Font.PLAIN, size));
			obj.setFont(new Font("Tahoma", Font.PLAIN, size));
			break;
		case "F8":
			// obj.setFont(new Font("Agency FB", Font.PLAIN, size));
			obj.setFont(new Font("Tahoma", Font.PLAIN, size));
			break;

		}
	}

	/*
	 * 
	 * public void setLabelPlainFont(Component obj ) { obj.setFont(new
	 * Font(myFontName, Font.PLAIN, myFontSize)); }
	 * 
	 * 
	 * public void setLableBoldFont(Component obj) { obj.setFont(new
	 * Font(myFontName, Font.BOLD, myFontSize)); }
	 * 
	 * 
	 * 
	 * public void setTextFieldPlainFont(Component obj ) { obj.setFont(new
	 * Font(myFontName, Font.PLAIN, myFontSize)); }
	 * 
	 * 
	 * public void setTextFieldBoldFont(Component obj) { obj.setFont(new
	 * Font(myFontName, Font.BOLD, myFontSize)); }
	 * 
	 * public void setButtonFieldBoldFont(Component obj) { obj.setFont(new
	 * Font(myFontName, Font.BOLD, myFontSize)); }
	 * 
	 * public void setButtonPlainFont(Component obj ) { obj.setFont(new
	 * Font(myFontName, Font.PLAIN, myFontSize)); }
	 * 
	 * 
	 * public void setSize(Component obj , int myDefineSize) { obj.setFont(new
	 * Font(myFontName, Font.PLAIN, myDefineSize)); }
	 * 
	 */

}

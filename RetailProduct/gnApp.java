package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.RootPaneContainer;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;

public class gnApp extends getResultSet {

	public static Color renk;

	public static Component findComponentUnderGlassPaneAt(Point p, Component top) {
		Component c = null;

		if (top.isShowing()) {
			if (top instanceof RootPaneContainer)
				c = ((RootPaneContainer) top).getLayeredPane().findComponentAt(
						SwingUtilities.convertPoint(top, p, ((RootPaneContainer) top).getLayeredPane()));
			// else
			// c = ((Container) top).findComponentAt(p);
		}

		return c;
	}

	public void setScreen(JFrame frame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		frame.setBounds(0, 1, screenWidth, screenHeight);

	}

	public Color setcolor(Component c) {
		renk = JColorChooser.showDialog(null, "Select the background color", renk);
		c.setBackground(renk);
		return renk;
	}

	public void setLAFJt(JFrame frane, String no, String theme) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		//
		Properties props = new Properties();
		props.put("logoString", "AKN");
		props.put("licenseKey", "ANK-2020-220");
		props.put("menuSelectionBackgroundColor", "180 240 197");

		props.put("buttonColor", "240 230 254");

		props.put("windowTitleForegroundColor", "0 0 0");
		props.put("windowTitleBackgroundColor", "240 240 240");
		props.put("windowTitleColorLight", "218 254 230");
		props.put("windowTitleColorDark", "180 240 150");
		props.put("windowBorderColor", "210 254 230");

		// set your theme

		switch (no) {
		case "1":
			GraphiteLookAndFeel.setCurrentTheme(props);
			com.jtattoo.plaf.graphite.GraphiteLookAndFeel.setTheme(theme, "", "AKN");
			UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel"); // Good
																						// ****
			break;
		case "2":
			com.jtattoo.plaf.aluminium.AluminiumLookAndFeel.setCurrentTheme(props);
			com.jtattoo.plaf.aluminium.AluminiumLookAndFeel.setTheme(theme, "", "AKN");
			UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
			break;
		case "3":
			com.jtattoo.plaf.fast.FastLookAndFeel.setCurrentTheme(props);
			com.jtattoo.plaf.fast.FastLookAndFeel.setTheme(theme, "", "AKN");
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel"); // Good**
			break;
		case "4":
			// com.jtattoo.plaf.acryl.AcrylLookAndFeel.setCurrentTheme(props);
			com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme(theme, "AKN", "AKN");
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel"); // Good*
			break;

		}
	}

	public void setLAF(JFrame frame, String LAF) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {

		UIManager.put("nimbusBase", new Color(51, 98, 140));

		/*
		 * UIManager.put("nimbusBlueGrey", new Color(235,240,240));
		 * UIManager.put("control", new Color(240,240,240));
		 * UIManager.put("nimbusSelectionBackground", new Color(57,105,138));
		 * UIManager.put("nimbusBorder", new Color(146,151,161));
		 * UIManager.put("menu", new Color(237,239,242));
		 * UIManager.put("Table.contentMargins", new Insets (0,0,0,0));
		 * UIManager.put("Button[Default+Focused].backgroundPainter",0);
		 * UIManager.put("[Enabled+Focused+Sorted].backgroundPainter", 1);
		 */

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if (LAF.equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {

		}
		// LookAndFeel ss = UIManager.getLookAndFeel();
		// String ss1 = ss.getName() ;
		// SwingUtilities.updateComponentTreeUI(frame);
	}

	public String getParameterInfo(String vpara) throws ClassNotFoundException, SQLException {
		String vinfo = " ";
		String SQL = "call  getParameterInfo('" + vpara + "')";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			vinfo = "No Information Available..Soon We Will Update This Info";
		} else {
			vinfo = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return vinfo;
	}

	public String checkEancode(String varticle, String veancode) throws SQLException, ClassNotFoundException {
		String result = "Sucess";
		if (veancode.length() > 15) {
			new General().msg("Ean Code Length is > 15 Char not allow");
			result = "Fail";
		}
		String SQL = "call Ean_checkEancode(" + varticle + ",   '" + veancode + "')";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			result = "Fail";
  			new General().msg("Ean code is already assign with  Article code :" + rs.getString(1));
		}
		rs.close();
		this.closeconn();
		return result;
	}

	public String checkValidCN(String vtype, String vcustid, String vdocno, String vamt) throws Throwable {
		String result = "Sucess";
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		new General().msg("Checking CN note Details");
		switch (vtype) {
		case "Credit Note":
			vtype = "CN";
			break;
		}
		String SQL = "Call  CN_checkValidCN('" + vtype + "' , " + vcustid + " , '" + vdocno + "' , '" + vamt + "'   , "
				+ vcomp + " , " + vstore + ")";
		new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Wrong Amount or Document No");
			result = "Fail";
		}
		rs.close();
		this.closeconn();
		return result;
	}

	public void ApprovalDisable(JCheckBox approve) throws Throwable {
		String vuserRole = new gnConfig().getRoleName();
		if (vuserRole == "SUPERVISOR" || vuserRole == "CASHIER") {
			approve.setSelected(false);
			approve.setEnabled(false);
		}
	}

	public void approveDocument(JCheckBox approve, JTextField approveby, JTextField approvedate) throws Throwable {

		String vuserRole = new gnConfig().getRoleName();
		boolean check = false;

		switch (vuserRole.toUpperCase()) {
		case "ADMIN":
			check = approve.isSelected();
			if (check == true) {
				approveby.setText(new gnConfig().getUserCode());
				approvedate.setText(new General().getDate());
			}
			if (check == false) {
				approveby.setText(" ");
				approvedate.setText(null);
			}
			break;
		case "MANAGER":
			check = approve.isSelected();
			if (check == true) {
				approveby.setText(new gnConfig().getUserCode());
				approvedate.setText(new General().getDate());
			}
			if (check == false) {
				approveby.setText(" ");
				approvedate.setText(null);
			}
			break;
		case "SUPERVISOR":
			new General().msg("Permission is not granted for  Document Approvals ... ");
			approve.setSelected(false);
			break;
		case "CASHIER":
			new General().msg("Permission is not granted for  Document Approvals ... ");
			approve.setSelected(false);
			break;
		}
	}

	public void setFrameTitel(JFrame frame) throws Throwable {
		// String verticlename = new ApplicationMenu().getVerticleName() ;
		String mode = "Business Application ";
		String Edition = "Stand Alone Branch Edition- ";
		// frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Loginwindow.class.getResource("/RetailProduct/meretoologo.png")));
		String vpara = "809";

		String vpara805 = "805"; // No of Lines per Bill
		int para805 = Integer.parseInt(new getConfigurationSetting().getSpecificConfiguration(vpara805));

		//frame.setTitle(new getConfigurationSetting().getSpecificConfiguration(vpara));
		frame.setFont(new Font("Cambria", Font.BOLD, 16));
		//frame.setIconImage(
		//		Toolkit.getDefaultToolkit().getImage(Loginwindow.class.getResource("/RetailProduct/mymain.png")));
		// frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Loginwindow.class.getResource("/RetailProduct/mymainIcon7.ICO")));
		frame.setFocusableWindowState(true);

	}

	public String getCompanyLogo() throws Throwable {
		String paravalue = "";
		String Filename = "";
		// paravalue = new gnApplicationSetting().MyCompanyLogo;
		return paravalue;
	}

	public void setCompanyTitle(JInternalFrame frame) throws Throwable {
		String vstore = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		if (vcomp != "0") {
			String vcompname = this.getCompanyname();
			frame.setTitle(vcompname);
			String vpara = "2";
			String SQL = " call CONF_getSpecificvalue('" + vpara + "', " + vstore + " , " + vcomp + ")";
			rs = this.getSPResult(SQL);
			if (rs.next()) {
				String paravalue = rs.getString(1);
				paravalue = paravalue + "\\" + "logo.png";
				if (vcomp != "0") {
					// frame.setIconImage(Toolkit.getDefaultToolkit().getImage(paravalue));
					frame.setIconifiable(true);
					// frame.setFrameIcon(new ImageIcon(paravalue));
				}
			}
			rs.close();
			this.closeconn();
		}

	}

	public void setImage(JComponent btn) throws Throwable {
		((AbstractButton) btn).setIcon(new ImageIcon(new gnPublicVariable().ClientLogo()));

	}

	public static void main(String[] args) {
	}
}

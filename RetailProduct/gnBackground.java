package RetailProduct;

import java.awt.Component;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class gnBackground extends getResultSet {

	public void loginSetBackGround(JLabel cmt) throws ClassNotFoundException, SQLException {
		String vday = new gnDate().getDayName(new General().getDate());
		vday = vday.substring(0, 3);
		switch (vday) {
		case "Mon":
			cmt.setIcon(new ImageIcon(Loginwindow.class.getResource("/RetailProduct/panel.png")));
			break;
		case "Tue":
			cmt.setIcon(new ImageIcon(Loginwindow.class.getResource("/RetailProduct/back1.png")));
			break;
		case "Wed":
			cmt.setIcon(new ImageIcon(Loginwindow.class.getResource("/RetailProduct/panel11.png")));
			break;
		case "Thu":
			cmt.setIcon(new ImageIcon(Loginwindow.class.getResource("/RetailProduct/panel12.png")));
			break;

		case "Fri":
			cmt.setIcon(new ImageIcon(Loginwindow.class.getResource("/RetailProduct/panel10.png")));
			break;

		case "Sat":
			cmt.setIcon(new ImageIcon(Loginwindow.class.getResource("/RetailProduct/panel3.png")));
			break;

		case "Sun":
			cmt.setIcon(new ImageIcon(Loginwindow.class.getResource("/RetailProduct/back1.png")));
			break;

		}

	}

	public void setBackground(JButton btn) {
		String vpath = new gnPublicVariable().ProductImagePath;
		String vimgname = new gnPublicVariable().PanelBackgroundImage;
		vimgname = vpath + vimgname;

		// new General().msg(vpath);
		// new General().msg(vimgname);

		if (vimgname.length() != 0) {
			btn.setIcon(new ImageIcon(vimgname));

		}
	}

	public void setLblBackground(JLabel lbl) {
		String vpath = new gnPublicVariable().ProductImagePath;
		String vimgname = vpath + new gnPublicVariable().PanelBackgroundImage;
		// new General().msg(vimgname);
		if (vimgname.length() != 0) {
			lbl.setIcon(new ImageIcon(vimgname));
		}
	}

	public void setDiffBackground(JButton btn) {
		String vpath = new gnPublicVariable().ProductImagePath;
		String vimgname = vpath + new gnPublicVariable().PanelBackgroundImage;
		// String vimgname = new gnApplicationSetting().PanelBackgroundImage ;
		// new General().msg(vimgname);
		if (vimgname.length() != 0) {
			btn.setIcon(new ImageIcon(vpath + "back2.png"));
		}
	}

}// Last

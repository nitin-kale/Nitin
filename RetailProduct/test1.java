package RetailProduct;

import java.awt.Toolkit;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class test1 {

	public test1() {

		JFrame frame = new JFrame();
		JLabel lbl = new JLabel();
		frame.setBounds(1, 1, 200, 300);
		lbl.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\anim1.gif"));

		frame.setBounds(100, 100, 200, 300);
		frame.add(lbl);
		frame.setVisible(true);

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

		String vcomp = "9999";
		String vstore = "5557";
		String vstorename = "XXXX";

		gnMath ll = new gnMath();
		ll.get2DecimaltValue("4.94562");
		ll.get2DecimaltValue(4.945223);

	}

}

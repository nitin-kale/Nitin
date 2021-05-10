package RetailProduct;

import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class gnMsg extends TimerTask {

	JPanel panel;
	public static JFrame frame = new JFrame();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		show("Wel Come Nitn Kale");

	}

	public void show(String msg) {
		JLabel lbl = null;
		lbl = new JLabel();
		frame.setBounds(350, 250, 300, 200);
		lbl.setText(null);
		lbl.setText(msg);
		frame.add(lbl);
		lbl.setBounds(5, 12, 100, 20);
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
		frame.setTitle("Parameter Description");

	}

}// Last

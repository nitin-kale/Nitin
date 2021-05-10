package RetailProduct;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingWorker;

//
public class gnWaitWindow extends Thread {
	JWindow window = new JWindow();

	public void callWaitWindow(int xtime) {
		window.getContentPane().add(new JLabel("<...Wait...>"));
		window.setBounds(350, 350, 100, 100);
		window.setAlwaysOnTop(true);
		window.setBackground(Color.BLACK);
		window.setForeground(Color.WHITE);

		window.setVisible(true);
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
			@Override
			protected Void doInBackground() throws Exception {
				Thread.sleep(xtime);
				return null;
			}

			protected void done() {
				window.dispose();
			}
		};
		worker.execute();
	}
}

// End Here

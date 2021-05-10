package RetailProduct;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.Timer;

public class gnBackup implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Timer timer = new Timer(20000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					new BackupDB().TakeBackup(new gnPublicVariable().DbBackupPath());
				} catch (IOException | InterruptedException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		timer.setRepeats(false); // Only execute once
		timer.start();
	}

}
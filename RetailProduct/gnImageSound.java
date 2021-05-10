package RetailProduct;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class gnImageSound {

	public void setColorPanel(JLabel lbl) {

	}

	public void playSound() {
		try {
			String FilePath = new gnPublicVariable().ProductImagePath;
			FilePath = FilePath.concat("/Sound/NewSms.wav");
			// AudioInputStream audioInputStream =
			// AudioSystem.getAudioInputStream(new
			// File(FilePath).getAbsoluteFile());
			// Clip clip = AudioSystem.getClip();
			// AudioFormat gg = clip.getFormat() ;
			// clip.open(audioInputStream);
			// clip.start();
		} catch (Exception ex) {
			new General().msg(ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void playAlertSound() {
		try {
			String FilePath = new gnPublicVariable().ProductImagePath;
			FilePath = FilePath.concat("/Sound/ALARM.wav");
			File myfile = new File(FilePath);
			// AudioInputStream audioInputStream =
			// AudioSystem.getAudioInputStream(new
			// File(FilePath).getAbsoluteFile());
			// Clip clip = AudioSystem.getClip();
			// AudioFormat gg = clip.getFormat() ;
			// clip.open(audioInputStream);
			// clip.start();
		} catch (Exception ex) {
			new General().msg(ex.getMessage());
			ex.printStackTrace();
		}
	}

}

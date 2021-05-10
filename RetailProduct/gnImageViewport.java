package RetailProduct;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JViewport;

class gnImageViewport extends JViewport {
	Paint texture;

	public gnImageViewport() {
		BufferedImage image = loadImage();
		int w = image.getWidth() / 2;
		int h = image.getHeight() / 2;
		Rectangle2D r = new Rectangle2D.Double(0, 0, w, h);
		texture = new TexturePaint(image, r);
	}

	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		int w = getWidth();
		int h = getHeight();
		g2.setPaint(texture);
		g2.fillRect(0, 0, w, h);
	}

	private BufferedImage loadImage() {
		BufferedImage image = null;
		String fileName = "/RetailProduct/clientLogo.png";
		// btnLogo.setIcon(new
		// ImageIcon(Loginwindow.class.getResource("/RetailProduct/clientLogo.png")));
		try {
			URL url = getClass().getResource(fileName);
			image = ImageIO.read(url);
		} catch (MalformedURLException mue) {
			System.out.println("url: " + mue.getMessage());
		} catch (Exception ioe) {
			System.out.println("read: " + ioe.getMessage());
		}
		return image;
	}
}
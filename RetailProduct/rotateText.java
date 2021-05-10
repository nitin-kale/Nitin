package RetailProduct;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;

public class rotateText {

	private JFrame frame;

	@SuppressWarnings("null")
	private void rorate() {
		Graphics2D g = null;
		Graphics2D g2d = (Graphics2D) g;
		// g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		// RenderingHints.VALUE_ANTIALIAS_ON);
		String s = "Wel Come To Meretoo Software Solutions ";

		Font font = new Font("Courier", Font.PLAIN, 12);
		g2d.translate(20, 20);

		FontRenderContext frc = g2d.getFontRenderContext();
		GlyphVector gv = font.createGlyphVector(frc, s);
		int length = gv.getNumGlyphs();
		Rectangle2D barra = new Rectangle2D.Double(0, 0, 700, 500);
		g2d.draw(barra);
		for (int i = 0; i < length; i++) {
			Point2D p = gv.getGlyphPosition(i);
			AffineTransform at = AffineTransform.getTranslateInstance(p.getX(), p.getY());
			at.rotate((double) i / (double) (length - 1) * Math.PI / 3);

			java.awt.Shape glyph = gv.getGlyphOutline(i);
			java.awt.Shape transformedGlyph = at.createTransformedShape(glyph);
			g2d.fill(transformedGlyph);
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rotateText window = new rotateText();
					window.frame.setVisible(true);
					window.rorate();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public rotateText() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

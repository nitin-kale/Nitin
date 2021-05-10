package RetailProduct;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JTextField;

public class gnRoundButton extends JButton {
	private Shape shape;

	public gnRoundButton(String size) {
		super(size);
		setOpaque(false);
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 4, getHeight() - 1, 15, 15);
		g.draw3DRect(0, 02, getWidth() - 4, getHeight() - 1, true);
		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 4, getHeight() - 1, 15, 15);
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 4, getHeight() - 4, 15, 15);
		}
		return shape.contains(x, y);
	}

}

package RetailProduct;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

import javafx.scene.paint.Color;

public class gnRoundTextField extends JTextField {
	private Shape shape;

	public gnRoundTextField(int size) {
		super(size);
		setOpaque(false);
		 
	}

	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
  		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
 		super.paintComponent(g);
	}

	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
  		
	}

	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}

}

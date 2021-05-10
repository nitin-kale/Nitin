package RetailProduct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

class gnStyleButtonSqr extends BasicButtonUI {

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		AbstractButton button = (AbstractButton) c;
		button.setOpaque(false);
		// button.setBorder(new MatteBorder(5, 15, 5, 15, Color.cyan));
		button.setBorder(new EmptyBorder(15, 15, 15, 15));

	}

	@Override
	public void paint(Graphics g, JComponent c) {
		AbstractButton b = (AbstractButton) c;
		paintBackground(g, b, b.getModel().isPressed() ? 3 : 6);
		super.paint(g, c);
	}

	public void paintBackground(Graphics g, JComponent c, int yOffset) {
		Dimension size = c.getSize();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// g.setColor(c.getBackground().yellow);
		g.setColor(c.getBackground().darker());
		g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 15, 10);
		g.setColor(c.getBackground());
		g.fillRoundRect(0, yOffset, size.width, size.height + yOffset, 15, 10);
	}

	public JButton getStyleButton(JButton myButton, Color clr, Color clr1) {

		myButton.setUI(new gnStyleButtonSqr());
		myButton.setBackground(clr);
		myButton.setForeground(clr1);
		return myButton;
	}

}

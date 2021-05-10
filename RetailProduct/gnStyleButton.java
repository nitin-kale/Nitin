package RetailProduct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

class gnStyleButton extends BasicButtonUI {

	private Color orgback;
	private Color orgfore;

	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		AbstractButton button = (AbstractButton) c;
		button.setOpaque(false);
		// button.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null,
		// null, null));
		button.setBorder(new EmptyBorder(15, 15, 15, 15));

	}

	@Override
	public void paint(Graphics g, JComponent c) {
		AbstractButton b = (AbstractButton) c;
		// paintBackground(g, b, b.getModel().isPressed() ? 3 : 6);
		b.getModel().setRollover(true);
		paintCircle(g, b, b.getModel().isPressed() ? 0 : 6);

		super.paint(g, c);
	}

	private void paintCircle(Graphics g, JComponent c, int yOffset) {
		Dimension size = c.getSize();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(c.getBackground().darker());
		g2.fillOval(0, yOffset, size.width, size.height + 0);
		g2.setColor(c.getBackground());
	}

	public JButton getStyleButton(JButton myButton, Color clr, Color clr1) {

		myButton.setUI(new gnStyleButton());
		myButton.setBackground(clr);
		myButton.setForeground(clr1);
		orgfore = myButton.getBackground();
		orgback = myButton.getForeground();

		return myButton;
	}

	public JButton getStyleButtonRound(JButton myButton, Color clr, Color clr1) {

		myButton.setUI(new gnStyleButton());
		myButton.setBackground(clr);
		myButton.setForeground(clr1);
		orgfore = myButton.getBackground();
		orgback = myButton.getForeground();

		return myButton;

	}

}

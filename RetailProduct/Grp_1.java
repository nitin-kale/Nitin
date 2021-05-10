package RetailProduct;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.AncestorEvent;

public class Grp_1 extends JPanel implements KeyListener, ActionListener {

	int x = 40;
	int y = 40;
	int x1 = 40;
	int y1 = 40;

	int speed = 1;

	public JPanel showGui() {
		Grp_1 grp = new Grp_1();
		grp.setBackground(Color.WHITE);
		grp.add(new JButton("Click Me"));

		// JPanel panel = new JPanel() ;
		panel.setBounds(20, 20, 500, 500);

		JFrame f = new JFrame("Original");
		f.setSize(500, 500);
		f.setLocation(250, 110);
		panel.add(grp);
		f.add(panel);
		// f.setVisible(true);
		grp.addKeyListener(grp);
		Timer t = new Timer(5, grp);
		t.start();
		grp.repaint();
		return panel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	JPanel panel = new JPanel() {
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.fillRect(x1, y1, 40, 40);

			g.setColor(Color.BLUE);
			g.drawString("Nitin Kale", x, y);
			ImageIcon img = new ImageIcon("D://AKN//MyProductImage//logo.png");
			img.paintIcon(this, g, x, y);
		}
	};

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Instantiating MyFrames, the class with Frame and Panel

				Grp_1 grp = new Grp_1();
				grp.showGui();
			}
		});
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_1)
			;
		{
			System.out.println("ffffff");
			x = x - 20;
			new General().msg("Right Key Pressed");
			repaint();
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void ancestorAdded(AncestorEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void ancestorMoved(AncestorEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void ancestorRemoved(AncestorEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		x = x + speed;
		x1 = x1 + speed - 1;

		if (x > 460) {
			speed = speed - 2;
		}
		if (x <= 0) {
			speed = speed + 1;
		}
		repaint();
	}
}
//

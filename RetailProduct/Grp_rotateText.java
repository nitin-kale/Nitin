package RetailProduct;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Grp_rotateText extends JPanel {

	public Grp_rotateText() {
		// RotatingTextPanel textPanel = new RotatingTextPanel();
		// RotationWrangler wrangler = textPanel.wrangler;
		JFrame f = new JFrame("click on white");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// f.getContentPane().add(wrangler.getTextPanel(), "North");
		// f.getContentPane().add(textPanel);

		String s = "Tomorrow, and tomorrow, and tomorrow, " + "creeps in this petty pace from day to day, "
				+ "to the last syllable of recorded time; ... " + "It is a tale told by an idiot, full of "
				+ "sound and fury signifying nothing.";
		MarqueePanel mp = new MarqueePanel(s, 32);

		// f.getContentPane().add(wrangler.getInputPanel(), "South");
		f.setSize(400, 400);
		f.setLocation(200, 200);
		f.setVisible(true);
		// return textPanel ;
		mp.start();
	}

	public static void main(String[] args) {

		Grp_rotateText gg = new Grp_rotateText();

	}

}

class MarqueePanel extends JPanel implements ActionListener {

	private static final int RATE = 12;
	private final Timer timer = new Timer(1000 / RATE, this);
	private final JLabel label = new JLabel();
	private final String s;
	private final int n;
	private int index;

	public MarqueePanel(String s, int n) {
		if (s == null || n < 1) {
			throw new IllegalArgumentException("Null string or n < 1");
		}
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			sb.append(' ');
		}
		this.s = sb + s + sb;
		this.n = n;
		label.setFont(new Font("Serif", Font.ITALIC, 36));
		label.setText(sb.toString());
		this.add(label);
		start();
	}

	public void start() {
		timer.start();
	}

	public void stop() {
		timer.stop();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		index++;
		if (index > s.length() - n) {
			index = 0;
		}
		label.setText(s.substring(index, index + n));
	}
}

class RotatingTextPanel extends JPanel {
	double theta;
	boolean showBounds;
	String text;
	int x, y;
	Font font;
	RotationWrangler wrangler;

	public RotatingTextPanel() {
		theta = 0;
		showBounds = false;
		text = "";
		x = y = 0;
		font = new Font("lucida sans regular", Font.PLAIN, 18);
		wrangler = new RotationWrangler(this);
		addMouseListener((MouseListener) wrangler);
		setBackground(Color.white);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setFont(font);
		g2.rotate(theta, x, y);
		g2.drawString(text, x, y);
		System.out.println("text = " + text + "\tx = " + x + "\ty = " + y);
		if (showBounds) {
			FontRenderContext frc = g2.getFontRenderContext();
			float textWidth = (float) font.getStringBounds(text, frc).getWidth();
			LineMetrics lm = font.getLineMetrics(text, frc);
			float ascent = lm.getAscent();
			float descent = lm.getDescent();
			float height = ascent + descent;
			Double r = new Rectangle.Double(x, y - ascent, textWidth, height);
			g2.setPaint(Color.red);
			g2.draw(r);
		}
	}

	public void setLocation(Point p) {
		x = p.x;
		y = p.y;
		text = wrangler.getText();
		repaint();
	}

	public void setShowBounds(boolean isVisible) {
		showBounds = isVisible;
	}

	public void setAngle(int degrees) {
		theta = Math.toRadians(degrees);
	}
}

class RotationWrangler extends MouseAdapter {
	RotatingTextPanel textPanel;
	JTextField textField;

	public RotationWrangler(RotatingTextPanel rtp) {
		textPanel = rtp;
	}

	public void mousePressed(MouseEvent e) {
		textPanel.setLocation(e.getPoint());
	}

	public String getText() {
		return textField.getText();
	}

	public JPanel getTextPanel() {
		textField = new JTextField("hello world", 6);
		JPanel panel = new JPanel();
		panel.add(new JLabel("enter string"));
		panel.add(textField);
		return panel;
	}

	public JPanel getInputPanel() {
		final JCheckBox boundsBox = new JCheckBox("show bounds");
		boundsBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textPanel.setShowBounds(boundsBox.isSelected());
			}
		});
		final SpinnerNumberModel model = new SpinnerNumberModel(0, -180, 180, 10);
		JSpinner spinner = new JSpinner(model);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				int angle = model.getNumber().intValue();
				textPanel.setAngle(angle);
			}
		});
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(2, 2, 2, 2);
		gbc.weightx = 1.0;
		panel.add(boundsBox, gbc);
		gbc.anchor = gbc.EAST;
		panel.add(new JLabel("angle"), gbc);
		gbc.anchor = gbc.WEST;
		panel.add(spinner, gbc);
		return panel;
	}
}
package RetailProduct;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Grp_test extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grp_test window = new Grp_test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Grp_test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// JPanel panel = new JPanel();
		// panel.setBounds(12, 13, 500, 500);

		// frame.getContentPane().add(panel);
		frame.setVisible(true);

		decorate();
	}

	private void decorate() {

		Grp_1 grp = new Grp_1();
		JPanel panel = grp.showGui();
		panel.setBounds(12, 13, 500, 500);
		panel.add(grp);
		panel.addKeyListener(grp);
		panel.setBounds(12, 13, 500, 500);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		Timer t = new Timer(1, grp);
		t.start();
		grp.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

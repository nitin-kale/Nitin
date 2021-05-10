package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class hindiTest {

	private JFrame frame;
	private JTextField name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hindiTest window = new hindiTest();
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
	public hindiTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Jalgaon");
		lblNewLabel.setToolTipText("Jalgaon");
		lblNewLabel.setFont(new Font("Shivaji02", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 34, 140, 45);
		frame.getContentPane().add(lblNewLabel);

		name = new JTextField();
		name.setFont(new Font("Shivaji02", Font.BOLD, 17));
		name.setBounds(56, 42, 291, 28);
		frame.getContentPane().add(name);
		name.setColumns(10);
	}
}

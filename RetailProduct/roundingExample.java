package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class roundingExample {

	JFrame frame;
	private JTextField mynumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					roundingExample window = new roundingExample();
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
	public roundingExample() {
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

		JLabel lblNewLabel = new JLabel("Enter Number");
		lblNewLabel.setBounds(52, 13, 107, 16);
		frame.getContentPane().add(lblNewLabel);

		mynumber = new JTextField();
		mynumber.setBounds(179, 10, 116, 22);
		frame.getContentPane().add(mynumber);
		mynumber.setColumns(10);

		JButton btnShow = new JButton("Show");

		btnShow.setBounds(52, 57, 97, 25);
		frame.getContentPane().add(btnShow);

		ActionListener lk = new btnlsnr();
		btnShow.addActionListener(lk);

	}

	class btnlsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			show();
		}
	}

	private void show() {

		Double vmynumber = Double.parseDouble(mynumber.getText());
		Double myvalue = 0.0;

		String value = new gnMath().get2DecimaltValue(mynumber.getText());
		new General().msg(value);

		new General().msg("No is :" + new gnMath().get2DecimaltValue(Double.parseDouble(mynumber.getText())));

		new General().msg(Double.toString(new gnMath().getRound2DecimaltValue(Double.parseDouble(mynumber.getText()))));

	}
}// Last

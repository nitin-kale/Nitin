package RetailProduct;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class myFramenitin {

	public JFrame frame;
	public JTextField num1;
	public JTextField num2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myFramenitin window = new myFramenitin();
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
	public myFramenitin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 562, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 501, 162);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblEnterNumber = new JLabel("Enter Number 1");
		lblEnterNumber.setBounds(0, 13, 131, 16);
		panel.add(lblEnterNumber);

		num1 = new JTextField();
		num1.setBounds(144, 10, 116, 22);
		panel.add(num1);
		num1.setColumns(10);

		JLabel lblEnterNumber_1 = new JLabel("Enter Number 2");
		lblEnterNumber_1.setBounds(10, 42, 96, 16);
		panel.add(lblEnterNumber_1);

		num2 = new JTextField();
		num2.setBounds(144, 45, 116, 22);
		panel.add(num2);
		num2.setColumns(10);

		JButton btnCalculate = new JButton("Calculate ");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// int xnum1 = Integer.parstInt(num1.getText()
			}
		});
		btnCalculate.setBounds(76, 107, 97, 25);
		panel.add(btnCalculate);
	}
}

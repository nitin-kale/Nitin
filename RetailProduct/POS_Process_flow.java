package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class POS_Process_flow {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POS_Process_flow window = new POS_Process_flow();
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
	public POS_Process_flow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setBackground(Color.CYAN);
		frame.setBounds(100, 100, 709, 431);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 679, 800);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("D:\\JAVA\\RetailProduct\\Document\\Pos_Process.png"));
		btnNewButton.setBounds(12, 0, 561, 229);
		panel.add(btnNewButton);

		JLabel lblPosProcessIs = new JLabel("POS Process is important Process for Business. ");
		lblPosProcessIs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblPosProcessIs.setForeground(Color.BLUE);
		lblPosProcessIs.setBounds(12, 242, 579, 16);
		panel.add(lblPosProcessIs);
	}
}

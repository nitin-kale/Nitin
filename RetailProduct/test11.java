package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;

public class test11 {

	private JFrame frametest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test11 window = new test11();
					window.frametest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test11() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frametest = new JFrame();
		frametest.getContentPane().setBackground(Color.WHITE);
		frametest.setBounds(1, 10, 1350, 950);
		frametest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frametest.getContentPane().setLayout(null);
		
		JScrollPane mainjsp = new JScrollPane();
		mainjsp.setBounds(0, 37, 1332, 695);
		mainjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mainjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		frametest.getContentPane().add(mainjsp);
		
		JScrollPane scrollPane = new JScrollPane();
		mainjsp.setRowHeaderView(scrollPane);
	}
}

package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;

public class showData {

	public JFrame frame;
	private JScrollPane jsp;
	private JPanel panel;

	public void show(JScrollPane jsp, JTable table, String vtext, int x, int y) {
		new General().msg(" Reached at showData.show Metod ");

		// jsp = new JScrollPane() ;
		jsp.setVisible(true);
		JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(table);
		prt.setVisible(true);
		jsp.setViewport(prt);
		table.setEnabled(true);

		frame.setBounds(0, 0, 700, 700);
		panel.setBounds(0, 0, 700, 700);
		jsp.setBounds(0, 0, 690, 690);

		jsp.setVisible(true);
		panel.add(jsp);
		frame.getContentPane().add(panel);
		frame.setVisible(true);

	}

	/*
	 * public static void msgJsp(JScrollPane jsp, String vtext) { dialog = new
	 * JDialog(); dialog.setAlwaysOnTop(true);
	 * JOptionPane.showConfirmDialog(dialog, jsp, vtext, 2,2, null) ;
	 * dialog.pack(); dialog.setDefaultCloseOperation(1);
	 * 
	 * }
	 */

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showData window = new showData();
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
	public showData() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 526, 440);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 0, 508, 382);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		jsp = new JScrollPane();
		jsp.setBounds(0, 0, 496, 366);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	}
}

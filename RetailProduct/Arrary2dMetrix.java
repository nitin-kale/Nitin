package RetailProduct;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Arrary2dMetrix {

	JButton btnShow;
	JScrollPane jsp;
	private final int START_X = 20;
	private final int START_Y = 40;
	private final int ROWS = 12;
	private final int COLS = 8;
	private final int BOX_WIDTH = 20;
	private final int BOX_HEIGHT = 20;

	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arrary2dMetrix window = new Arrary2dMetrix();
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
	public Arrary2dMetrix() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 519, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(12, 57, 499, 185);
		frame.getContentPane().add(jsp);

		btnShow = new JButton("Show");
		btnShow.setBounds(12, 19, 97, 25);
		frame.getContentPane().add(btnShow);

		ActionListener jk = new btnshowLs();
		btnShow.addActionListener(jk);
	}

	class btnshowLs implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			show2dmetrix();
		}
	}

	private void show2dmetrix() {

		String[][][] demo2d = { { { "Red", "Blue", "Red", "Blue", "Red", "Blue", "Red", "Blue", "Red" },
				{ "40", "45", "50", "55", "60", "65", "70", "75", "80" },
				{ "40", "45", "50", "55", "60", "65", "70", "75", "80" } } };
		String[] demo2d1 = { "Red", "Blue", "Red", "Blue", "Red", "Blue", "Red", "Blue", "Red" };
		table = new JTable(demo2d, demo2d1);
		// model.setColumnIdentifiers(demo2d);
		// model.addRow(new Object[][] { {"Y", "Y","Y", "Y","Y", "Y","Y",
		// "Y","Y" } , {"nitin" , "Kalyani"} });
		// table.setModel(model);
		JViewport prt6 = new JViewport();
		prt6.add(table, demo2d);
		prt6.setVisible(true);
		jsp.setViewport(prt6);

	}

}// Last

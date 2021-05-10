package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class gnComboMultiFields {

	JComboBox mycombo;
	JButton btnShow;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gnComboMultiFields window = new gnComboMultiFields();
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
	public gnComboMultiFields() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		mycombo = new JComboBox();
		mycombo.setBounds(132, 39, 254, 35);
		frame.getContentPane().add(mycombo);

		btnShow = new JButton("Show");
		btnShow.setBounds(26, 44, 97, 25);
		frame.getContentPane().add(btnShow);

		ActionListener hh = new btnShow();
		btnShow.addActionListener(hh);
	}

	class btnShow implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String mylist[] = { "Code", "Name" };

			DefaultTableModel model = new DefaultTableModel();
			JTable table = new JTable();
			model.setColumnIdentifiers(mylist);
			model.addRow(new Object[] { "1" + " " + "Nitin" });
			model.addRow(new Object[] { "2" + " " + "Kale" });
			table.setModel(model);
			JScrollPane jsp = new JScrollPane();
			jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			jsp.setBounds(6, 368, 484, 142);

			JViewport prt = new JViewport();
			prt.setBackground(Color.WHITE);
			prt.add(table, mylist);
			prt.setVisible(true);
			jsp.setViewport(prt);
			table.requestFocus();
			// mycombo.add(jsp);
			mycombo.addItem("1" + " " + "India");

		}
	}

}//

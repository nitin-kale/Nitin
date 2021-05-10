package RetailProduct;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ListCellRenderer;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.itextpdf.awt.geom.Dimension;

import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class test101 extends getResultSet {

	JFrame framenk;
	JComboBox<JScrollPane> combo;
	public JScrollPane jsp;
	JPopupMenu mypopup;

	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test101 window = new test101();
					window.framenk.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public test101() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		framenk = new JFrame();
		framenk.setAlwaysOnTop(true);
		framenk.setBounds(100, 100, 615, 300);
		framenk.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framenk.getContentPane().setLayout(null);

		combo = new JComboBox<JScrollPane>();
		combo.setEditable(true);
		combo.setBounds(254, 44, 331, 75);
		framenk.getContentPane().add(combo);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(26, 79, 219, 119);
		framenk.getContentPane().add(jsp);

		JButton btnShow = new JButton("Show");
		btnShow.setBounds(323, 0, 97, 25);
		framenk.getContentPane().add(btnShow);
		ActionListener lsb = new lsBtn();
		btnShow.addActionListener(lsb);
		decorate();
	}

	private void decorate() throws ClassNotFoundException, SQLException {
		String sname = "%%";
		String vtype = "Article";
		String vverticlecode = "1";
		String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + compcode + "  , " + vverticlecode + " )";
		new General().msg(SQL);
		String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
				"Taxcode", "SubGrooup", "Brand", "Pk.Size", "UOM" };
		table = new gnTableModel().Tablemodel(table, model, SQL, ACol, 12, "N", "Y", vtype);

		JViewport prt = new JViewport();
		prt.add(table, ACol);
		prt.setVisible(true);
		jsp.setViewport(prt);
		// jsp.setBounds(1 , 1, 1300 , 700);
		combo.setEditable(true);

		ComboBoxRenderer renderer = new ComboBoxRenderer();
		combo.setRenderer(renderer);
		// jsp.setBounds(1 , 1, 1300 , 700);
		combo.setMaximumRowCount(3);
		combo.repaint();

		mypopup = new JPopupMenu();
		mypopup.setBounds(1, 1, 3000, 700);
		// framenk.getContentPane().add(mypopup);
		mypopup.setVisible(true);
		mypopup.add(jsp);

	}

	class lsBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			action();
		}
	}

	private void action() {

	}
}

class ComboBoxRenderer extends JLabel implements ListCellRenderer {

	public ComboBoxRenderer() {
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		Component jsp = null;
		try {
			jsp = new test101().mypopup;
			jsp.setBounds(1, 1, 1300, 700);
			list.add(jsp);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return jsp;
	}

}
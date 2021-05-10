package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

public class gnSearchForm extends getResultSet {

	JFrame gnSearchForm;
	private JTextField Stext;
	public JTable table = new JTable();
	public JScrollPane jsp = new JScrollPane();
	public DefaultTableModel model = new DefaultTableModel();
	public JViewport prt = new JViewport();
	public String col[] = { "Code", "Name" };
	public JInternalFrame internalFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gnSearchForm window = new gnSearchForm();
					window.gnSearchForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gnSearchForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		gnSearchForm = new JFrame();
		gnSearchForm.setAlwaysOnTop(true);
		gnSearchForm.setType(Type.UTILITY);
		gnSearchForm.setTitle("Business Application");
		gnSearchForm
				.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JAVA\\Images\\ICONS\\04\\PNG\\Search1.png"));
		gnSearchForm.setBounds(275, 100, 700, 600);
		gnSearchForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gnSearchForm.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.CYAN);
		desktopPane.setBounds(0, 0, 700, 600);
		gnSearchForm.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Search Window ");
		internalFrame.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		internalFrame.setBounds(0, 0, 700, 600);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel Hpanel = new JPanel();
		Hpanel.setBackground(Color.WHITE);
		Hpanel.setToolTipText("Enter Starting Name for Search ");
		Hpanel.setBorder(new LineBorder(new Color(255, 0, 255), 1, true));
		Hpanel.setBounds(12, 13, 659, 129);
		internalFrame.getContentPane().add(Hpanel);
		Hpanel.setLayout(null);

		JLabel lblSearchString = new JLabel("Search String ");
		lblSearchString.setForeground(Color.BLACK);
		lblSearchString.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSearchString.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearchString.setBounds(25, 25, 110, 16);
		Hpanel.add(lblSearchString);

		Stext = new JTextField();
		Stext.setBounds(137, 23, 215, 22);
		Hpanel.add(Stext);
		Stext.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setMnemonic('S');
		btnSearch.setIcon(new ImageIcon("D:\\JAVA\\Images\\ICONS\\04\\PNG\\search.png"));
		btnSearch.setBounds(364, 23, 115, 22);
		ActionListener ls1 = new lsnr();
		btnSearch.addActionListener(ls1);
		Hpanel.add(btnSearch);

		JPanel dataPanel = new JPanel();
		dataPanel.setBorder(new LineBorder(Color.BLUE, 3, true));
		dataPanel.setBounds(12, 150, 659, 365);
		internalFrame.getContentPane().add(dataPanel);
		dataPanel.setLayout(null);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(12, 13, 635, 339);
		// dataPanel.add(jsp);
		internalFrame.setVisible(true);

		prt = new JViewport();
		prt.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
		prt.add(table, col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		table.setBackground(Color.white);
		table.setRowSelectionAllowed(true);
		table.setCellSelectionEnabled(false);
		dataPanel.add(jsp);

		prt.setVisible(true);

	}

	public class lsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String value1 = e.getActionCommand();
			int i = e.getID();

			String value = Stext.getText();
			String SQL = "Call  getSearchArticleName('" + value + "')";
			try {
				getSearchData("CityMaster", SQL);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(value1);
			System.out.println(value);
			return;
		}
	}

	public String getSearchData(String xName, String SQL) throws ClassNotFoundException {
		String name = " ";
		new General().msg(xName);
		String col[] = { "Code", "Name" };
		// internalFrame.setTitle(xName);
		gnSearchForm.repaint();
		model.setColumnIdentifiers(col);
		try {
			String value2 = Stext.getText();
			value2 = "%" + value2 + "%";
			String SQL1 = "call master.getSearchCustomerName('" + value2 + "')";
			ResultSet rs = this.getSPResult(SQL1);
			while (rs.next()) {
				model.addRow(new Object[] { rs.getString(1), rs.getString(2) });
			}
			new General().msgVector(model.getDataVector());
			table.setModel(model);
			new gnTable().setTablewidth(table, 1, 300);
			table.setCellSelectionEnabled(true);
			table.setRowSelectionAllowed(true);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return name;

	}
} // last

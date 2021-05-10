package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class GroupAssignments extends getResultSet {

	JFrame AssignmentGroupFrame;
	private JTextField SelectText;
	public JComboBox<String> comboFunction = new JComboBox();
	public JComboBox comboGroupName = new JComboBox();
	public JComboBox comboSerach = new JComboBox();
	public JPanel topright = new JPanel();
	public JPanel sitepanel = new JPanel();
	public JPanel topleft = new JPanel();

	public JTable table = new JTable();
	public DefaultTableModel model = new DefaultTableModel();
	public JScrollPane jsp = new JScrollPane();
	public JScrollPane jsp2 = new JScrollPane();
	public JScrollPane jsp1 = new JScrollPane();

	public JViewport prt = new JViewport();
	public JViewport prt1 = new JViewport();
	public JViewport prt2 = new JViewport();
	public String[] col = { "Site Code", "Site Name", "Select" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupAssignments window = new GroupAssignments();
					window.AssignmentGroupFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GroupAssignments() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AssignmentGroupFrame = new JFrame();
		AssignmentGroupFrame.setTitle("Business Application - Group Assignments");
		AssignmentGroupFrame.setType(Type.UTILITY);
		AssignmentGroupFrame.setBounds(275, 150, 595, 550);
		AssignmentGroupFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		AssignmentGroupFrame.getContentPane().setLayout(null);

		JPanel topleft = new JPanel();
		topleft.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		topleft.setBounds(12, 13, 229, 87);
		AssignmentGroupFrame.getContentPane().add(topleft);
		topleft.setLayout(null);

		JLabel lblFunction = new JLabel("Function");
		lblFunction.setBounds(12, 13, 56, 16);
		topleft.add(lblFunction);

		comboFunction = new JComboBox();
		comboFunction.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String fn = comboFunction.getSelectedItem().toString();
				String SQL = "call master.getSelectedGroupName('" + fn + "')";
				try {
					new gnComp().fillCombo(SQL, comboGroupName);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		comboFunction.setModel(new DefaultComboBoxModel(new String[] { "Site", "Item" }));
		comboFunction.setBounds(83, 10, 126, 22);
		topleft.add(comboFunction);
		ActionListener nk1 = new lsnr();
		comboFunction.addActionListener(nk1);

		JLabel lblGroupName = new JLabel("Group Name");
		lblGroupName.setBounds(0, 48, 77, 16);
		topleft.add(lblGroupName);

		comboGroupName = new JComboBox();
		comboGroupName.setEditable(false);
		comboGroupName.setModel(new DefaultComboBoxModel(new String[] { "Fildata" }));
		comboGroupName.setBounds(83, 45, 126, 22);
		topleft.add(comboGroupName);

		topright = new JPanel();
		topright.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		topright.setBounds(240, 13, 325, 280);
		AssignmentGroupFrame.getContentPane().add(topright);
		topright.setLayout(null);
		topright.setVisible(false);
		JLabel lblSearchOn = new JLabel("Search On");
		lblSearchOn.setBounds(64, 16, 65, 16);
		topright.add(lblSearchOn);

		comboSerach = new JComboBox();
		comboSerach.setFont(new Font("SansSerif", Font.BOLD, 12));
		comboSerach.setModel(new DefaultComboBoxModel(
				new String[] { "Category", "Sub Category", "Brand", "Manufacturer ", "Class", "Size", "Color" }));
		comboSerach.setBounds(132, 13, 131, 22);
		topright.add(comboSerach);
		ActionListener nk5 = new lsnr1();
		comboSerach.addActionListener(nk5);

		jsp1 = new JScrollPane();
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(10, 86, 303, 160);
		topright.add(jsp1);

		JLabel lblPrice = new JLabel("Price Range");
		lblPrice.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblPrice.setBounds(54, 45, 74, 16);
		topright.add(lblPrice);

		JFormattedTextField price1 = new JFormattedTextField();
		price1.setBounds(132, 40, 74, 22);
		topright.add(price1);

		JFormattedTextField price2 = new JFormattedTextField();
		price2.setBounds(218, 40, 95, 22);
		topright.add(price2);

		JButton btnClickOnTo = new JButton("Click on to Selecte Items");
		btnClickOnTo.setBounds(10, 247, 303, 25);
		topright.add(btnClickOnTo);

		JLabel lblSearchForSelected = new JLabel("Search For Selected ");
		lblSearchForSelected.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblSearchForSelected.setBounds(10, 69, 129, 16);
		topright.add(lblSearchForSelected);

		SelectText = new JTextField();
		SelectText.setBounds(133, 66, 180, 22);
		topright.add(SelectText);
		SelectText.setColumns(10);

		sitepanel = new JPanel();
		sitepanel.setBounds(12, 306, 553, 187);
		AssignmentGroupFrame.getContentPane().add(sitepanel);
		sitepanel.setLayout(null);

		jsp2 = new JScrollPane();
		jsp2.setBounds(0, 0, 541, 182);
		sitepanel.add(jsp2);
		jsp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		prt.setBackground(Color.CYAN);
		prt.add(table, col);
		prt.setVisible(true);
		jsp2.setViewport(prt);
		table.setBackground(Color.white);
		table.setRowSelectionAllowed(true);
		table.setCellSelectionEnabled(false);
		sitepanel.setVisible(false);

	}

	public class lsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i = e.getID();
			String value = e.getActionCommand();

			System.out.println(i);
			System.out.println(value);
			try {
				calltoGet();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public class lsnr1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i1 = e.getID();
			String value1 = e.getActionCommand();
			System.out.println(i1);
			System.out.println(value1);
			try {
				getSelectedName();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void getSelectedName() throws SQLException {
		String FName = new gnComp().getComboValue(comboSerach);
		System.out.println("Return Name is : " + FName);
		if (FName == "Category") {
			topright.setVisible(false);
		}
	}

	public void calltoGet() throws SQLException, ClassNotFoundException {
		String FName = new gnComp().getComboValue(comboFunction);
		System.out.println("Return Name is : " + FName);

		if (FName == "Site") {
			topright.setVisible(false);
			sitepanel.setVisible(true);
			String SQL7 = "Call getAllSite()";
			rs = this.getSPResult(SQL7);
			int row = rs.getRow();

			new gnTable().DesignTable(col, table, model, rs);
			table.setDefaultRenderer(Object.class, new MyRenderer());
			new gnTable().AddCheckBoxToTable(model, table, 2);
		}

		if (FName == "Item") {
			topright.setVisible(true);
			topright.repaint();
			sitepanel.setVisible(false);
		}

	}

}// Last
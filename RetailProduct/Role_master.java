package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class Role_master {

	JFrame RoleFrame;
	private JTextField roleName;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Role_master window = new Role_master();
					window.RoleFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Role_master() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		RoleFrame = new JFrame();
		RoleFrame.setResizable(false);
		RoleFrame.setAutoRequestFocus(false);
		RoleFrame.setAlwaysOnTop(true);
		RoleFrame.setTitle("Business Application");
		RoleFrame.setType(Type.UTILITY);
		RoleFrame.setBounds(100, 100, 602, 300);
		RoleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		RoleFrame.getContentPane().setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Roles Creation");
		internalFrame.setBounds(-12, 0, 596, 272);
		RoleFrame.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.MAGENTA, null));
		mainPanel.setBounds(0, 0, 580, 196);
		internalFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);

		JLabel lblRoleNumber = new JLabel("Role Code");
		lblRoleNumber.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblRoleNumber.setBounds(51, 12, 68, 16);
		mainPanel.add(lblRoleNumber);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(63, 42, 56, 16);
		mainPanel.add(lblName);

		JLabel lblFunction = new JLabel("Function");
		lblFunction.setFont(new Font("Verdana", Font.BOLD, 13));
		lblFunction.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFunction.setBounds(35, 71, 84, 16);
		mainPanel.add(lblFunction);

		JLabel lblActive = new JLabel("Active");
		lblActive.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblActive.setBounds(73, 102, 46, 16);
		mainPanel.add(lblActive);

		JFormattedTextField roleCode = new JFormattedTextField();
		roleCode.setBounds(133, 10, 68, 22);
		mainPanel.add(roleCode);

		roleName = new JTextField();
		roleName.setBounds(133, 39, 182, 22);
		mainPanel.add(roleName);
		roleName.setColumns(10);

		JComboBox comboFunction = new JComboBox();
		comboFunction.setModel(new DefaultComboBoxModel(new String[] { "Master Data Managment", "Purchase Management",
				"Store Operations ", "Warehouse Operations ", "Finance and Accounts", "Administrator ",
				"Inventory Managment ", "Stock Check ", "Goods Receive ", "Stock Transfer " }));
		comboFunction.setBounds(133, 68, 182, 22);
		mainPanel.add(comboFunction);

		JComboBox comboStatus = new JComboBox();
		comboStatus.setModel(new DefaultComboBoxModel(new String[] { "Yes", "No" }));
		comboStatus.setBounds(133, 100, 58, 22);
		mainPanel.add(comboStatus);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 30, 572, 184);
		RoleFrame.getContentPane().add(desktopPane);
		internalFrame.setVisible(true);
	}
}

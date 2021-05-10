package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Authorize extends getResultSet {

	JFrame frameauth;
	private JTextField usercode;
	private JPasswordField pwd;
	public String Action;
	public static String ReturnValue = "Fail";
	private JButton btnCancel;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Authorize window = new Authorize();
					window.frameauth.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Authorize() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameauth = new JFrame();
		frameauth.setAlwaysOnTop(true);
		frameauth.setTitle("User Window");
		frameauth.setType(Type.UTILITY);
		frameauth.setBounds(450, 250, 366, 246);
		frameauth.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameauth.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1, 255);
		frameauth.getContentPane().add(desktopPane);

		JInternalFrame internalFrame = new JInternalFrame("Authorization");
		internalFrame.setBounds(0, 0, 353, 204);
		frameauth.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		panel.setBounds(-11, 0, 360, 182);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblUserCode = new JLabel("Authorized By");
		lblUserCode.setEnabled(false);
		lblUserCode.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserCode.setBounds(26, 34, 113, 16);
		panel.add(lblUserCode);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setEnabled(false);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(56, 67, 82, 16);
		panel.add(lblPassword);

		usercode = new JTextField();
		usercode.setBounds(150, 32, 162, 22);
		panel.add(usercode);
		usercode.setColumns(10);

		btnOk = new JButton("Ok");
		btnOk.setMnemonic('O');
		btnOk.setBounds(150, 129, 97, 25);
		panel.add(btnOk);
		ActionListener ls1 = new als();
		btnOk.addActionListener(ls1);

		JLabel lblReason = new JLabel("Reason");
		lblReason.setForeground(Color.MAGENTA);
		lblReason.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReason.setHorizontalAlignment(SwingConstants.RIGHT);
		lblReason.setBounds(57, 96, 82, 16);
		panel.add(lblReason);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "New Installation Data Upload", "Customer Said Not Required", "Product Expiry ",
						"Wrong Product Picked ", "MRP Not Found in Master ", "Product is Damage " }));
		comboBox.setBounds(150, 94, 191, 22);
		panel.add(comboBox);

		btnCancel = new JButton("Cancel");
		btnCancel.setMnemonic('C');
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frameauth.dispose();
			}
		});
		btnCancel.setBounds(244, 129, 97, 25);
		panel.add(btnCancel);

		pwd = new JPasswordField();
		pwd.setBounds(150, 65, 162, 22);
		panel.add(pwd);
		frameauth.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { usercode, btnOk }));
		internalFrame.setVisible(true);
		decorateComp();
	}

	public void decorateComp() {
		new gnDecorate().DispField_Eatch(usercode, 20);
		new gnDecorate().DispField_Eatch(pwd, 100);
		new gnDecorate().decorateBtn(btnOk, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnCancel, Color.BLUE, Color.WHITE);
	}

	class als implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value =  " + value);
			// System.out.println("Field id"+i);
			if (value == "Ok") {
				try {
					userValidation1();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	} // LAse Actionlstener

	public String userValidation1() throws Throwable {
		@SuppressWarnings("deprecation")
		String vpwd = pwd.getText().trim();
		String vpwd1 = new General().convertPassword(vpwd);
		String vcode = usercode.getText().trim();
		// String vcomp = new gnConfig().getCompanyCode() ;
		// String vstore = new gnConfig().getStoreID() ;
		String vcomp = "0";
		String vstore = "0";
		String SQL = "Call  validateUser('" + vcode + "' ,'" + vpwd1 + "'  , " + vcomp + " ," + vstore + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			Action = "Sucess";
			new General().msg(Action);
			frameauth.dispose();
			ReturnValue = Action;
			new ApplicationMenu().Auth = "Sucess";
		} else {
			new General().msg("You are Not authorized");
			ReturnValue = "Fail";
		}

		return ReturnValue;

	}

}// Last of class

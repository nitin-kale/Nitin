package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class ChangePassword extends getResultSet {

	JFrame ChangePasswordFrame;
	JPanel panel;
	private JTextField ucode;
	private JPasswordField oldpwd;
	private JTextField name;
	private JPasswordField newpwd;
	private JFormattedTextField expDate;
	private JTextField createDate;
	private JTextField companycode;
	private JTextField storecode;
	private JTextField storename;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword window = new ChangePassword();
					window.ChangePasswordFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Throwable
	 */
	public ChangePassword() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		ChangePasswordFrame = new JFrame();
		ChangePasswordFrame.setAlwaysOnTop(true);
		ChangePasswordFrame.setTitle("Business Application - Password Managment");
		ChangePasswordFrame.setType(Type.UTILITY);
		ChangePasswordFrame.setResizable(false);
		ChangePasswordFrame.setBounds(310, 175, 450, 269);
		ChangePasswordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ChangePasswordFrame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.MAGENTA);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(0, 0, 444, 198);
		ChangePasswordFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblUserCode = new JLabel("User Code");
		lblUserCode.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserCode.setForeground(Color.BLACK);
		lblUserCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserCode.setBounds(12, 67, 100, 16);
		panel.add(lblUserCode);

		ucode = new JTextField();
		ucode.setToolTipText("User code max char allow is 10");
		ucode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ucode.setBounds(123, 65, 116, 22);
		panel.add(ucode);
		ucode.setColumns(10);

		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOldPassword.setForeground(Color.BLACK);
		lblOldPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOldPassword.setBounds(12, 93, 100, 16);
		panel.add(lblOldPassword);

		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewPassword.setForeground(Color.BLACK);
		lblNewPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewPassword.setBounds(12, 116, 104, 16);
		panel.add(lblNewPassword);

		oldpwd = new JPasswordField();
		oldpwd.setToolTipText("Password Filed Max char Allow is 8");
		oldpwd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		oldpwd.setBounds(123, 90, 116, 22);
		panel.add(oldpwd);

		newpwd = new JPasswordField();
		newpwd.setToolTipText("Password Filed Max char Allow is 8");
		newpwd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newpwd.setBounds(123, 113, 116, 22);
		panel.add(newpwd);

		JButton btnPasswordManagement = new JButton("Password Management ");
		btnPasswordManagement.setBackground(new Color(204, 255, 255));
		btnPasswordManagement.setEnabled(false);
		btnPasswordManagement.setForeground(Color.BLACK);
		btnPasswordManagement.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPasswordManagement.setBounds(0, 0, 444, 26);
		panel.add(btnPasswordManagement);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 148, 420, 37);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPasswoedExpiryDate = new JLabel("Passwoed Expiry Date ");
		lblPasswoedExpiryDate.setBounds(12, 10, 147, 16);
		panel_2.add(lblPasswoedExpiryDate);
		lblPasswoedExpiryDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPasswoedExpiryDate.setHorizontalAlignment(SwingConstants.RIGHT);

		expDate = new JFormattedTextField();
		expDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		expDate.setToolTipText("Password Expiry Date < Change password before this Date>");
		expDate.setEditable(false);
		expDate.setBounds(159, 7, 104, 25);
		panel_2.add(expDate);

		JButton btnYyymmdd = new JButton("DD.MM.YYYY");
		btnYyymmdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnYyymmdd.setEnabled(false);
		btnYyymmdd.setBounds(263, 7, 147, 25);
		panel_2.add(btnYyymmdd);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDate.setBounds(250, 67, 32, 16);
		panel.add(lblDate);

		createDate = new JTextField();
		createDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		createDate.setEditable(false);
		createDate.setBounds(294, 64, 102, 22);
		panel.add(createDate);
		createDate.setColumns(10);
		new General().setDate(createDate);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBounds(0, 27, 444, 37);
		panel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel = new JLabel("Company");
		lblNewLabel.setBounds(0, 0, 56, 16);
		panel_3.add(lblNewLabel);

		companycode = new JTextField();
		companycode.setBackground(Color.WHITE);
		companycode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		companycode.setEnabled(false);
		companycode.setBounds(0, 15, 56, 20);
		panel_3.add(companycode);
		companycode.setColumns(10);
		ActionListener cmp = new Company();
		companycode.addActionListener(cmp);

		JLabel lblNewLabel_1 = new JLabel("Store");
		lblNewLabel_1.setBounds(68, 0, 56, 16);
		panel_3.add(lblNewLabel_1);

		storecode = new JTextField();
		storecode.setBackground(Color.WHITE);
		storecode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		storecode.setEnabled(false);
		storecode.setBounds(57, 16, 64, 20);
		panel_3.add(storecode);
		storecode.setColumns(10);
		ActionListener stor = new Store();
		storecode.addActionListener(stor);

		storename = new JTextField();
		storename.setBackground(Color.WHITE);
		storename.setFont(new Font("Tahoma", Font.PLAIN, 14));
		storename.setEditable(false);
		storename.setBounds(121, 16, 323, 20);
		panel_3.add(storename);
		storename.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Store Name");
		lblNewLabel_2.setBounds(121, 0, 162, 16);
		panel_3.add(lblNewLabel_2);
		ActionListener ls1 = new ls();

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 255, 255));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(0, 200, 444, 36);
		ChangePasswordFrame.getContentPane().add(panel_1);

		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClose.setBounds(243, 6, 97, 25);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangePasswordFrame.dispose();
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnClose);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(147, 6, 97, 25);
		panel_1.add(btnUpdate);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setMnemonic('U');
		btnUpdate.addActionListener(ls1);
		Decorate();
	}

	private void Decorate() throws Throwable {
		new gnDecorate().DispField_Eatch(ucode, 20);
		new gnDecorate().DispField_Eatch(oldpwd, 20);
		new gnDecorate().DispField_Eatch(newpwd, 20);
		new gnDecorate().DispField_Eatch(companycode, 20);
		new gnDecorate().DispField_Eatch(storecode, 20);
		new gnDecorate().DispField_Eatch(storename, 20);
		new gnDecorate().DispField_Eatch(createDate, 20);
		new gnApp().setFrameTitel(ChangePasswordFrame);
		new gnField().closeform(panel, ChangePasswordFrame);
		String vcomp = new gnConfig().getCompanyCode();
		String vstorecode = new gnConfig().getStoreID();
		String vstorename = new gnConfig().getStorename(vstorecode);
		companycode.setText(vcomp);
		storecode.setText(vstorecode);
		storename.setText(vstorename);
		switch (vcomp) {
		case "0":
			companycode.setEditable(true);
			companycode.setEnabled(true);
			storecode.setEnabled(true);
			break;
		}
		if (vcomp != "0") {
			companycode.setEditable(false);
			companycode.setEnabled(false);
			storecode.setEnabled(false);
		}
	}

	class Company implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			try {
				new gnAdmin().setcompany(companycode, name);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class Store implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			try {
				String vcomp = companycode.getText();
				new gnAdmin().setstore(storecode, storename, vcomp);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class ls implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			if (value == "Update") {
				try {

					String vstatus = validateEntery();
					if (vstatus == "Sucess") {
						ProcessResuest();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

		} // ls
	}// ls

	public void setDateForNewRecord() throws Throwable {
		new General().setDate(createDate);
		String vpara = "803";
 		String vdays = new getConfigurationSetting().getSpecificConfiguration(vpara);
		int vvdays = Integer.parseInt(vdays);
		String vdate = createDate.getText();
		String cvdate = new gnConfig().date_ConverttoDBforamt(vdate);
		String vduedate = (new gnConfig().get_duedate(cvdate, vvdays));
		expDate.setText(vduedate);

	}

	private String validateEntery() throws ClassNotFoundException, SQLException, IOException {
		String status = "Sucess";
		String vcode = ucode.getText();
		String vpwd = new General().convertPassword(newpwd.getText());
		String vpwd1 = newpwd.getText();

		if (vcode.length() == 0) {
			new General().msg("Enter User code");
			status = "Fail";
		}

		if (vcode.length() > 8) {
			new General().msg(" User Code Lenght Allow is 8 Chars, Change User Code");

			status = "Fail";
		}

		if (vname.length() == 0) {
			new General().msg("Enter User Name");
			status = "Fail";
		}

		if (vpwd.length() == 0) {
			new General().msg("Enter User Password ");
			status = "Fail";
		}

		if (vpwd1.length() > 8) {
			new General().msg(" Password Lenght Allow is 8 Chars, Change Password");
			status = "Fail";
		}
		return status;
	}

	public void ProcessResuest() throws Throwable {
		String vcomp = companycode.getText();
		String vstore = storecode.getText();

		String vucode = new gnComp().getText(ucode);
		String vopwd = new General().convertPassword(oldpwd.getText().trim());
		String vnpwd = new General().convertPassword(newpwd.getText().trim());
		setDateForNewRecord();
		if (vnpwd.length() <= 0) {
			new General().msg("New Password Can not be Null .. Please Enter New Password");
			return;
		}
		String expdt = new gnConfig().date_ConverttoDBforamt(createDate.getText());
		String SQL = "Call     validateUser('" + vucode + "' ,'" + vopwd + "', " + vcomp + " , " + vstore + ")";
		String SQL2 = "Call  updateUserPassword('" + vucode + "' ,'" + vnpwd + "', '" + expdt + "' , " + vcomp + " , "
				+ vstore + ")";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("User Code OR Passwaord is Wrong.. Retry");
		} else {
			expDate.setText(expdt);
			rs = this.getSPResult(SQL2);
			new General().msg("Password Updated sucessfully.");
			ucode.setText(null);
			oldpwd.setText(null);
			newpwd.setText(null);
		}
	}

}// last

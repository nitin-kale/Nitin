package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateInfo extends getResultSet {

	JFrame updateLFrame;
	private JTextField compname;
	private JTextField branchname;
	private JTextField compcode;
	private JTextField branchcode;
	private JPasswordField plkey;
	private JTextField expdate;
	JButton btnexp;
	String vuser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateInfo window = new UpdateInfo();
					window.updateLFrame.setVisible(true);
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
	public UpdateInfo() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		updateLFrame = new JFrame();
		updateLFrame.getContentPane().setBackground(Color.WHITE);
		updateLFrame.setAlwaysOnTop(true);
		updateLFrame.setBounds(200, 250, 633, 287);
		updateLFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updateLFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(UpdateInfo.class.getResource("/RetailProduct/mymain1.png.jpg")));
		lblNewLabel.setBounds(0, 0, 151, 160);
		updateLFrame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Company");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(169, 46, 69, 16);
		updateLFrame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Branch");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(163, 78, 69, 16);
		updateLFrame.getContentPane().add(lblNewLabel_2);

		compname = new JTextField();
		compname.setBounds(249, 44, 278, 30);
		updateLFrame.getContentPane().add(compname);
		compname.setColumns(10);

		branchname = new JTextField();
		branchname.setBounds(249, 72, 280, 30);
		updateLFrame.getContentPane().add(branchname);
		branchname.setColumns(10);

		compcode = new JTextField();
		compcode.setEditable(false);
		compcode.setBounds(528, 44, 68, 30);
		updateLFrame.getContentPane().add(compcode);
		compcode.setColumns(10);

		branchcode = new JTextField();
		branchcode.setEditable(false);
		branchcode.setBounds(528, 70, 68, 30);
		updateLFrame.getContentPane().add(branchcode);
		branchcode.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Product Key");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(144, 128, 94, 16);
		updateLFrame.getContentPane().add(lblNewLabel_3);

		plkey = new JPasswordField();
		plkey.setCaretColor(Color.darkGray);
		plkey.setFont(new Font("SansSerif", Font.BOLD, 16));
		plkey.setEchoChar('X');
		plkey.setEditable(false);
		plkey.setBounds(249, 126, 278, 30);
		updateLFrame.getContentPane().add(plkey);
		plkey.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Expiry Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(159, 160, 79, 16);
		updateLFrame.getContentPane().add(lblNewLabel_4);

		expdate = new JTextField();
		expdate.setBounds(249, 157, 116, 30);
		updateLFrame.getContentPane().add(expdate);
		expdate.setColumns(10);

		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setMnemonic('G');
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnGenerate.setBounds(528, 125, 75, 30);
		updateLFrame.getContentPane().add(btnGenerate);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setMnemonic('U');
		btnUpdate.setBounds(249, 204, 97, 25);
		updateLFrame.getContentPane().add(btnUpdate);

		JButton btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(354, 204, 97, 25);
		updateLFrame.getContentPane().add(btnClose);

		JLabel lblNewLabel_5 = new JLabel(" ");
		lblNewLabel_5.setIcon(new ImageIcon(UpdateInfo.class.getResource("/RetailProduct/Anim3.gif")));
		lblNewLabel_5.setBounds(163, 0, 411, 38);
		updateLFrame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Complete");
		lblNewLabel_6.setForeground(new Color(0, 0, 153));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(0, 157, 136, 16);
		updateLFrame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Retail Business Solution");
		lblNewLabel_7.setForeground(new Color(0, 0, 153));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(0, 173, 151, 16);
		updateLFrame.getContentPane().add(lblNewLabel_7);

		btnexp = new JButton("Update Exp.Date");
		btnexp.setBounds(361, 158, 120, 30);
		updateLFrame.getContentPane().add(btnexp);

		ActionListener btnls = new btmLsnr();
		btnClose.addActionListener(btnls);
		btnUpdate.addActionListener(btnls);
		btnGenerate.addActionListener(btnls);
		btnexp.addActionListener(btnls);

		ActionListener cmpls = new compLsnr();
		ActionListener brls = new branchLsnr();
		compname.addActionListener(cmpls);
		branchname.addActionListener(brls);
		decorate();

	}

	private void decorate() throws Throwable {
		
 		new gnApp().setFrameTitel(updateLFrame);
		vuser = new gnConfig().getUserCode();
		expdate.setVisible(false);
		switch (vuser) {
		case "ADMIN":
			branchname.setEnabled(true);
			compname.setEnabled(true);
			expdate.setVisible(true);
			break;
		}
	}

	class btmLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String value = e.getActionCommand();

			if (value == "Close") {
				updateLFrame.dispose();
			}

			if (value == "Generate") {
				String vcomp = compcode.getText();
				String vstore = branchcode.getText();
				String vstatus = new gnlcoalsqliconnection().checkCompandStore(vcomp, vstore);
				if (vstatus == "Sucess") {
					plkey.setText(new gnlcoalsqliconnection().gennk(vcomp, vstore));
				}
			}

			if (value == "Update Exp.Date") {
				try {
					switch (vuser) {
					case "ADMIN":
						new General().updateLKeyExpProcess(compcode.getText(), branchcode.getText(), expdate.getText());
					}
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Update") {
				try {
					try {
						new General().updateLKeyProcess(compcode.getText(), branchcode.getText(), plkey.getText());
					} catch (ClassNotFoundException | IOException e1) {
 						e1.printStackTrace();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}
	}

	class compLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				new gnAdmin().setcompany(compcode, compname);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class branchLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vcomp = compcode.getText();
			try {
				if (vcomp.length() > 0) {
					new gnAdmin().setstore(branchcode, branchname, vcomp);
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

}// Last

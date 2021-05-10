package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class IssueToken {

	JFrame frameToken;
	private JTextField tokenno;
	public static String vtokenno = "0";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueToken window = new IssueToken();
					window.frameToken.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IssueToken() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameToken = new JFrame();
		frameToken.setType(Type.UTILITY);
		frameToken.setAlwaysOnTop(true);
		frameToken.setBounds(450, 250, 361, 215);
		frameToken.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameToken.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 39, 316, 124);
		frameToken.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Token Number");
		lblNewLabel_1.setBounds(12, 39, 101, 16);
		panel.add(lblNewLabel_1);

		tokenno = new JTextField();
		tokenno.setFont(new Font("SansSerif", Font.PLAIN, 17));
		tokenno.setForeground(new Color(0, 0, 102));
		tokenno.setBounds(106, 29, 135, 36);
		panel.add(tokenno);
		tokenno.setColumns(10);

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vtokenno = tokenno.getName();
				frameToken.dispose();
			}
		});
		btnOk.setMnemonic('O');
		btnOk.setBounds(116, 83, 90, 28);
		panel.add(btnOk);

		JLabel lblNewLabel = new JLabel("Issue Token No");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(26, 13, 144, 25);
		frameToken.getContentPane().add(lblNewLabel);
	}

}//

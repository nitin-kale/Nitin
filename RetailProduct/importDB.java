package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.border.BevelBorder;
import java.awt.Window.Type;

public class importDB extends getResultSet {

	JFrame importFrame;
	private JTextField dbname;
	private JTextField importdbname;
	JPanel panel;
	JLabel msg;
	JButton btnImport;
	JButton btnClose;
	JButton btnSelect;

	String vdbname;
	String vimportdbname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					importDB window = new importDB();
					window.importFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public importDB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		importFrame = new JFrame();
		importFrame.setType(Type.UTILITY);
		importFrame.setAlwaysOnTop(true);
		importFrame.setBounds(250, 270, 700, 249);
		importFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		importFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, null, Color.DARK_GRAY, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 698, 177);
		importFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("DataBase Name");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(40, 41, 109, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Import DataBase File");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(10, 80, 139, 16);
		panel.add(lblNewLabel_1);

		dbname = new JTextField();
		dbname.setFont(new Font("Cambria", Font.BOLD, 13));
		dbname.setToolTipText("Destination Database Name Where Data Will be Imported");
		dbname.setBounds(151, 32, 396, 35);
		panel.add(dbname);
		dbname.setColumns(10);

		importdbname = new JTextField();
		importdbname.setBackground(Color.WHITE);
		importdbname.setEditable(false);
		importdbname.setForeground(new Color(0, 0, 153));
		importdbname.setFont(new Font("Cambria", Font.PLAIN, 12));
		importdbname.setToolTipText("Import DataBase Name  Select File From Local File System");
		importdbname.setText("importdbname");
		importdbname.setBounds(152, 64, 395, 35);
		panel.add(importdbname);
		importdbname.setColumns(10);

		btnImport = new JButton("Import");
		btnImport.setFont(new Font("Cambria", Font.BOLD, 13));
		btnImport.setMnemonic('I');
		btnImport.setBounds(333, 139, 97, 25);
		panel.add(btnImport);

		btnSelect = new JButton("Select File");
		btnSelect.setForeground(new Color(51, 51, 0));
		btnSelect.setFont(new Font("Cambria", Font.BOLD, 13));
		btnSelect.setMnemonic('S');
		btnSelect.setBounds(549, 71, 109, 25);
		panel.add(btnSelect);

		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Cambria", Font.BOLD, 13));
		btnClose.setMnemonic('C');
		btnClose.setBounds(431, 139, 97, 25);
		panel.add(btnClose);

		JLabel lblNewLabel_2 = new JLabel("Import DataBase Utility");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_2.setBounds(0, 0, 456, 25);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Select  SQL File Example   <<DatabaseFileName.SQL>>");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setBounds(151, 99, 330, 16);
		panel.add(lblNewLabel_3);
		msg = new JLabel("--");
		msg.setBounds(30, 175, 371, 16);
		importFrame.getContentPane().add(msg);

		ActionListener btnaction = new btnLsnr();
		btnSelect.addActionListener(btnaction);
		btnImport.addActionListener(btnaction);
		btnClose.addActionListener(btnaction);

	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String value = e.getActionCommand();
			if (value == "Select File") {
				String selectFileName = new gnFile().getFile1(panel);
				importdbname.setText(selectFileName);

			}

			if (value == "Import") {
				String status = validate();
				if (status == "Sucess") {
					try {
						startImportProcess();
					} catch (IOException | InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						new General().msg(e1.getMessage());
					}
				}
			}

			if (value == "Close") {
				importFrame.dispose();
			}

		}

	}

	private String validate() {
		String status = "Sucess";
		if (dbname.getText().length() == 0) {
			new General().msg("Please Enter Database Name  ..");
			dbname.grabFocus();
			status = "Fail";
		}
		if (importdbname.getText().length() == 0) {
			new General().msg("Please Select Import File ..");
			status = "Fail";
		}
		return status;
	}

	private void startImportProcess() throws IOException, InterruptedException {
		new General().Quickmsg("Importing Process Start Please Wait...");
		vdbname = dbname.getText();
		vimportdbname = importdbname.getText();
		String available = checkDBExists(vdbname);
		switch (available) {
		case "Sucess":
			new General().msg(vdbname + "  " + "Database Available..");
			importNow();
			break;

		case "Fail":
			new General().msg(vdbname + "  " + "Database Not Available..");
			int i = new General().msgInput("Would you like to create Database" + " " + vdbname);
			if (i == 0) {
				try {
					new General().Quickmsg("Creating Database Please Wait...");
					CreateDabase(vdbname);
					new General().Quickmsg("Database Created Sucessfully...");
					importNow();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		}

	}

	private void importNow() throws IOException, InterruptedException {
		Runtime backup = Runtime.getRuntime();
		new gnImageSound().playSound();
		new gnImageSound().playSound();
		String action = DBpath + "mysql    -uroot  -paayushi7   " + vdbname + "    <     " + vimportdbname + " ";
		new General().msg(action);
		new gnImageSound().playSound();
		new gnImageSound().playSound();

		Process pr1 = backup.exec(action);

		int processComplete = pr1.waitFor();
		if (processComplete == 0) {
			new gnImageSound().playSound();
			new gnImageSound().playSound();
			String status = "Sucess";
			new General().msg("Database Imported Sucessfully...");
		} else {
			new General().msg("DB Backupt Fail ..");
			String status = "Fail";
		}

	}

}// Last

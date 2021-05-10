package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class DBParam extends getResultSet {

	JFrame myFrameDB;
	//
	private JTextField dbuser;
	private JPasswordField pwd;
	private JComboBox comboDBname;
	private JTextField dbpath;
	private JTextField driver;
	private JTextField url;

	private String vdbuser;
	private String vpwd;
	private String vdbname;
	private String vdbpath;
	private String vdriver;
	private String vurl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DBParam window = new DBParam();
					window.myFrameDB.setVisible(true);
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
	 * @throws IOException
	 */
	public DBParam() throws SQLException, ClassNotFoundException, IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private void initialize() throws SQLException, ClassNotFoundException, IOException {
		myFrameDB = new JFrame();
		myFrameDB.setAlwaysOnTop(true);
		myFrameDB.setTitle("Business Application");
		myFrameDB.setBounds(100, 100, 556, 300);
		myFrameDB.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrameDB.getContentPane().setLayout(null);

		dbuser = new JTextField();
		dbuser.setBounds(102, 30, 155, 22);
		myFrameDB.getContentPane().add(dbuser);
		dbuser.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.setEnabled(false);
		btnSave.setBounds(76, 217, 97, 25);
		ActionListener abc = new Btnlsnr();
		btnSave.addActionListener(abc);
		myFrameDB.getContentPane().add(btnSave);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.setBounds(185, 217, 97, 25);
		myFrameDB.getContentPane().add(btnUpdate);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(294, 217, 97, 25);
		myFrameDB.getContentPane().add(btnCancel);
		ActionListener ls1 = new lsnr();

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(12, 13, 514, 202);
		myFrameDB.getContentPane().add(panel);
		panel.setLayout(null);

		dbpath = new JTextField();
		dbpath.setFont(new Font("SansSerif", Font.BOLD, 13));
		dbpath.setBounds(92, 117, 383, 30);
		panel.add(dbpath);
		dbpath.setColumns(10);

		JLabel lblDbPath = new JLabel("DB Path");
		lblDbPath.setBounds(15, 119, 56, 16);
		panel.add(lblDbPath);
		lblDbPath.setFont(new Font("SansSerif", Font.BOLD, 14));

		JLabel lblDriver = new JLabel("Driver");
		lblDriver.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblDriver.setBounds(29, 88, 38, 16);
		panel.add(lblDriver);

		driver = new JTextField();
		driver.setFont(new Font("Arial", Font.BOLD, 13));
		driver.setBounds(91, 87, 384, 30);
		panel.add(driver);
		driver.setColumns(10);

		JLabel lblUrl = new JLabel("URL");
		lblUrl.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblUrl.setBounds(40, 148, 29, 16);
		panel.add(lblUrl);

		JLabel lblDbName = new JLabel("DB Name");
		lblDbName.setBounds(266, 21, 60, 16);
		panel.add(lblDbName);
		lblDbName.setFont(new Font("SansSerif", Font.PLAIN, 14));

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(7, 42, 72, 20);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("SansSerif", Font.PLAIN, 15));

		JLabel lblDbUser = new JLabel("DB User");
		lblDbUser.setBounds(23, 21, 52, 16);
		panel.add(lblDbUser);
		lblDbUser.setFont(new Font("SansSerif", Font.PLAIN, 14));

		url = new JTextField();
		url.setFont(new Font("SansSerif", Font.BOLD, 13));
		url.setBounds(91, 147, 384, 30);
		panel.add(url);
		url.setColumns(10);

		pwd = new JPasswordField();
		pwd.setBounds(91, 42, 155, 22);
		panel.add(pwd);

		comboDBname = new JComboBox();
		comboDBname.setEnabled(false);
		comboDBname.setBounds(333, 19, 157, 22);
		panel.add(comboDBname);
		new gnComp().getDBName(comboDBname);
		comboDBname.setSelectedItem("master");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBorder(new LineBorder(Color.GRAY, 1, true));
		panel_1.setBounds(0, 75, 514, 127);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton btn_Filepicker = new JButton("GetFile");
		btn_Filepicker.setBounds(484, 44, 18, 32);
		panel_1.add(btn_Filepicker);
		btn_Filepicker.setEnabled(false);
		// FrameDB.getContentPane().setFocusTraversalPolicy(new
		// FocusTraversalOnArray(new Component[]{dbuser, btnSave, btnUpdate,
		// btnCancel, pwd}));
		btn_Filepicker.addActionListener(ls1);

		// setData();
		setConfigParameters();
	}

	class Btnlsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			if (value == "Save") {
				try {
					prepareToInsert();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

	class lsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			System.out.println("Value" + value);
			System.out.println("Field id" + i);
			if (value == "GetFile") {
				String Name = new GetFileName().getFile();
				setPath(Name);
			}
		}
	}

	public void setPath(String Name) {
		dbpath.setText(Name);
	}

	public void setConfigParameters() {

		// baseurl
		// login
		// password
		// dbname
		// driver
		// url =
		// myterminal
		// nodeType

		dbuser.setText(this.login);
		pwd.setText("*******");
		dbpath.setText(super.DBpath);
		url.setText(this.baseurl);
		driver.setText(new getResultSet().driver);

		dbuser.setEditable(false);
		pwd.setEditable(false);
		dbpath.setEditable(false);
		url.setEditable(false);
		driver.setEditable(false);

	}

	public void setData() throws SQLException, ClassNotFoundException {
		String SQL = "call db_getparameters()";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			dbuser.setText(rs.getString(1));
			pwd.setText(rs.getString(2));
			comboDBname.setName(rs.getString(3));
			dbpath.setText(rs.getString(4));
			url.setText(rs.getString(5));
			driver.setText(rs.getString(6));
			rs.close();
			dbuser.setEditable(false);
			pwd.setEditable(false);
			dbpath.setEditable(false);
			url.setEditable(false);
			driver.setEditable(false);
		}

	}

	private void prepareToInsert() throws Throwable {
		vdbuser = dbuser.getText();
		vpwd = new General().convertPassword(pwd.getText());
		vdbname = comboDBname.getSelectedItem().toString();
		// new General().msg("Database Seleccted is "+ vdbname);
		vdbpath = dbpath.getText();
		vdriver = driver.getText();
		vurl = url.getText();

		insertData();
	}

	public String insertData() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		// this.closeconn();
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String company = "INSERT INTO  dbparam  (Dbuser , password , Dbname , path , url ," + "driver)"
				+ "values(?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(company);
			prst.setString(1, vdbuser);
			prst.setString(2, vpwd);
			prst.setString(3, vdbname);
			prst.setString(4, vdbpath);
			prst.setString(5, vurl);
			prst.setString(6, vdriver);

			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con.commit();
			}
			prst.executeBatch();
			con.commit();
			new General().msg("Data Saved Sucessfully");
			// showTable();
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
				this.closeconn();

			}
		}
		return status;
	}

}// last
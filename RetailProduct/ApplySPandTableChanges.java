package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ScrollPaneConstants;

public class ApplySPandTableChanges extends getResultSet {

	JFrame frametableSp;
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable();
	JScrollPane jsp;
	JButton btnApply;
	JButton btnchangeDB;

	String volddbname;

	String filename;
	Runtime rt = Runtime.getRuntime();

	private String jspcol[] = { "Name" };
	JRadioButton rb1;
	JRadioButton rb2;
	JPanel panel;
	String Choice = "";
	private String vcomp;
	private String vstore;
	private JTextField mydbname;
	private JTextField myfilename;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_4;
	private JTextField records;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplySPandTableChanges window = new ApplySPandTableChanges();
					window.frametableSp.setVisible(true);
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
	public ApplySPandTableChanges() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frametableSp = new JFrame();
		frametableSp.setBounds(150, 100, 548, 478);
		frametableSp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frametableSp.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 566, 133);
		frametableSp.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\backGround7.jpg"));
		lblNewLabel.setBounds(-108, 0, 118, 143);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("DB Name");
		lblNewLabel_2.setBounds(29, 13, 56, 16);
		panel.add(lblNewLabel_2);

		rb1 = new JRadioButton("Table Level Add/Update");
		rb1.setMnemonic('T');
		buttonGroup.add(rb1);
		rb1.setBounds(313, 50, 184, 25);
		panel.add(rb1);

		rb2 = new JRadioButton("SP Level Add/Update");
		rb2.setMnemonic('S');
		buttonGroup.add(rb2);
		rb2.setBounds(313, 80, 184, 25);
		panel.add(rb2);

		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\backGround7.jpg"));
		lblNewLabel_1.setBounds(281, 0, 254, 130);
		panel.add(lblNewLabel_1);

		mydbname = new JTextField();
		mydbname.setForeground(new Color(0, 0, 102));
		mydbname.setFont(new Font("Calibri", Font.BOLD, 14));
		mydbname.setBounds(87, 10, 182, 22);
		panel.add(mydbname);
		mydbname.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Script File For Update");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_3.setBounds(12, 42, 160, 16);
		panel.add(lblNewLabel_3);

		myfilename = new JTextField();
		myfilename.setForeground(new Color(0, 0, 102));
		myfilename.setFont(new Font("Calibri", Font.BOLD, 14));
		myfilename.setBounds(12, 60, 257, 22);
		panel.add(myfilename);
		myfilename.setColumns(10);

		btnApply = new JButton("Apply Changes");
		btnApply.setMnemonic('A');
		btnApply.setFont(new Font("Calibri", Font.BOLD, 14));
		btnApply.setBounds(131, 105, 151, 25);
		panel.add(btnApply);

		btnchangeDB = new JButton("Change DB");
		btnchangeDB.setBounds(172, 37, 97, 25);
		panel.add(btnchangeDB);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 158, 530, 275);
		frametableSp.getContentPane().add(jsp);

		lblNewLabel_4 = new JLabel("No.of Records");
		lblNewLabel_4.setBounds(307, 139, 80, 16);
		frametableSp.getContentPane().add(lblNewLabel_4);

		records = new JTextField();
		records.setBounds(402, 136, 116, 22);
		frametableSp.getContentPane().add(records);
		records.setColumns(10);

		ActionListener rblsnr = new rbLsnr();
		rb1.addActionListener(rblsnr);
		rb2.addActionListener(rblsnr);

		// ActionListener fllsnr = new filenameLsnr();
		// myfilename.addActionListener(fllsnr);

		ActionListener btnsnr = new btnLsnr();
		btnApply.addActionListener(btnsnr);
		btnchangeDB.addActionListener(btnsnr);

		decorate();
	}

	private void decorate() throws Throwable {
		btnchangeDB.setEnabled(false);
		myfilename.setEditable(false);
		new gnApp().setFrameTitel(frametableSp);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		mydbname.setText(this.dbname);
		volddbname = this.dbname;
		show();
	}

	private void hide() {
		btnApply.setVisible(false);
		btnchangeDB.setVisible(false);
		rb1.setVisible(false);
		rb2.setVisible(false);
	}

	private void show() {
		btnApply.setVisible(true);
		btnchangeDB.setVisible(true);
		rb1.setVisible(true);
		rb2.setVisible(true);

	}

	class filenameLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String status = validate();
			if (status == "Sucess") {
				String Name = new gnFile().getFile1(panel);
				myfilename.setText(Name);
				Choice = null;
			}
		}
	}

	private String validate() {
		String status = "Sucess";
		if (Choice.length() == 0) {
			status = "Fail";
			new General().msg("No Choice Selected for Changes Apply, Please Select Choice First");
		}
		return status;

	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Change DB") {
 
				String filePath = ApplicationDrivename + "AKN//bin//myConfigRun.ini";
				new General().msg(filePath);
				String search = "dbname";
				String vdbname = mydbname.getText();
				new General().msg(vdbname + " " + "New DB Name will set in Config file ...");
				new gnUpdaeConfigFile().modifyFile(filePath, volddbname, vdbname);
			}

			if (value == "Apply Changes") {
				try {
					runScript();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}
	}

	private void runScript() throws ClassNotFoundException, SQLException, IOException {

		String status = checkSQLFileExist();
		if (status == "Sucess") {
			new General().Quickmsg("Applying Changes Please Wait....");
			switch (Choice) {
			case "2":
				removeSP();
				applyChangesusingBatchFile();
				break;
			case "1":
				applyChangesusingBatchFile();
				break;
			}
		}
	}

	private void removeSP() throws ClassNotFoundException, SQLException, IOException {
		String vname = mydbname.getText().trim();
		String SQL = " Delete from mysql.proc where db like '" + vname + "'  ";
		new General().Quickmsg(SQL);
		this.getResult(SQL);
		showSP();
		new General().Quickmsg("Check All Procedures are Removed...");
	}

	public String applyChangesusingBatchFile() throws IOException {

		String scriptname = "";
		File vScriptFile = null;
		String flname = "";
		String status = "Sucess";
		try {
			File vbatchfile = null;
			switch (Choice) {
			case "1":
				flname = "D_ApplyTableChanges.exe";
				break;
			case "2":
				flname = "D_ApplySPChanges.exe";
				break;
			}
			vbatchfile = new File(ProductPath, "bin");
			vbatchfile = new File(vbatchfile, flname);
			new General().msg(vbatchfile.toString());
			if (vbatchfile.exists()) {
				Process pr = rt.exec("cmd /C start  " + vbatchfile + " ");
				int processComplete = pr.waitFor();
				if (processComplete == 0) {
					new General().Quickmsg("Changes Applied Sucessfully");
					new gnImageSound().playSound();
					switch (Choice) {
					case "1":
						TableAction();
						break;
					case "2":
						showSP();
						break;
					}
					status = "Sucess";
				} else {
					new General().msg("Changes Can not Apply Please check...");
					new gnImageSound().playAlertSound();
					new gnImageSound().playAlertSound();
					new gnImageSound().playAlertSound();
					status = "Fail";
				}
			}
		} catch (Exception e) {
			new General().msg(e.getMessage());
		}
		return status;
	}

	private String checkSQLFileExist() {
		// ProductScriptPath = ApplicationDrivename+ProductScriptPath;
		// new General().msg(ProductScriptPath);
		String status = "Sucess";
		String scriptname = "";
		File vScriptFile = null;
		switch (Choice) {
		case "1":
			scriptname = "ApplyTableChanges.SQL";
			vScriptFile = new File(ProductScriptPath);
			vScriptFile = new File(vScriptFile, scriptname);
			break;
		case "2": 
			scriptname = "ApplySPChanges.SQL";
			vScriptFile = new File(ProductScriptPath);
			vScriptFile = new File(vScriptFile, scriptname);
			break;
		}

		if (!vScriptFile.exists()) {
			status = "Fail";
			new General().msg("------>>" + " " + vScriptFile + " " + "File Not Found Please Check...");
		}
		return status;
	}

	class rbLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean selected;
			selected = rb1.isSelected();
			if (selected) {
				Choice = "1";
				try {
					myfilename.setText(ProductScriptPath + "\\ApplyTableChanges.SQL");
					TableAction();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			selected = rb2.isSelected();
			if (selected) {
				Choice = "2";
				try {
					myfilename.setText(ProductScriptPath + "ApplySPChanges.SQL");
					showSP();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void TableAction() throws SQLException, ClassNotFoundException, IOException {
		new gnTable().RemoveTableRows(model);
		rs = new TableInfo().getTables();
		model.setColumnIdentifiers(jspcol);
		table.setModel(model);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString(3) });
			table.setRowHeight(25);
			table.setBackground(Color.white);
			table.setForeground(Color.BLUE);
		}
		records.setText(Integer.toString(table.getRowCount()));
		JViewport prt1 = new JViewport();
		prt1.add(table, jspcol);
		jsp.setViewport(prt1);
		jsp.setVisible(true);
		rs.close();
	}

	private void showSP() throws SQLException, ClassNotFoundException, IOException {
		new gnTable().RemoveTableRows(model);
		rs = new TableInfo().getProcedure();
		model.setColumnIdentifiers(jspcol);
		table.setModel(model);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString(3) });
			table.setRowHeight(25);
			table.setBackground(Color.white);
			table.setForeground(Color.BLUE);
			records.setText(Integer.toString(table.getRowCount()));
		}
		JViewport prt1 = new JViewport();
		prt1.add(table, jspcol);
		jsp.setViewport(prt1);
		jsp.setVisible(true);
		rs.close();
		Selectrow();
	}

	public void Selectrow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {
					if (Choice == "2") {
						display(row, value);
					}

					if (Choice == "1") {
						display(row, value);
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
					// new General().msgDispose();
			}
		});
		// new gnTable().setTableColWidth(table, 1, 250);
	}

	private void display(int row, String value)
			throws ClassNotFoundException, SQLException, MalformedURLException, IOException {

		// new General().msg(value);
		// new General().msg("Choice is:"+" "+Choice);

		switch (Choice) {
		case "2":
			new TableInfo().getPocedureContent(value);
			break;

		case "1":
			getFieldsDetails(value);
			break;
		}
	}

	private void getFieldsDetails(String tablename) throws SQLException, ClassNotFoundException, IOException {
		String col[] = { "Name", "Type", "Width", "", "" };
		new gnTable().RemoveTableRows(model);
		rs = new TableInfo().getField(tablename);
		model.setColumnIdentifiers(col);
		table.setModel(model);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString(4), rs.getString(6), rs.getString(7) });
			table.setRowHeight(25);
			table.setBackground(Color.white);
			table.setForeground(Color.BLUE);
		}
		records.setText(Integer.toString(table.getRowCount()));
		JViewport prt1 = new JViewport();
		prt1.add(table, col);
		jsp.setViewport(prt1);
		jsp.setVisible(true);
		rs.close();
	}
}// Last
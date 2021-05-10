package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class CityMaster extends getResultSet {

	JFrame frameCity;
	JPanel panel;
	private JTextField citycode;
	private JTextField name;
	JComboBox state;
	JScrollPane jsp;
	JButton btnSave;
	JButton btnView;
	JButton btnClose;
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CityMaster window = new CityMaster();
					window.frameCity.setVisible(true);
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
	public CityMaster() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frameCity = new JFrame();
		frameCity.setAlwaysOnTop(true);
		frameCity.setIconImage(
				Toolkit.getDefaultToolkit().getImage(CityMaster.class.getResource("/RetailProduct/mymain.png")));
		frameCity.getContentPane().setBackground(Color.WHITE);
		frameCity.setBounds(300, 250, 529, 373);
		frameCity.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameCity.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 4, 3, (Color) new Color(0, 153, 204)));
		panel.setBackground(new Color(153, 255, 255));
		panel.setBounds(0, 0, 513, 102);
		frameCity.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblcitycode = new JLabel("Code");
		lblcitycode.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblcitycode.setForeground(Color.BLACK);
		lblcitycode.setBounds(317, 50, 56, 16);
		panel.add(lblcitycode);

		citycode = new JTextField();
		citycode.setBounds(307, 68, 66, 30);
		panel.add(citycode);
		citycode.setColumns(10);

		JLabel lblNewLabel = new JLabel("City Name");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(96, 50, 180, 16);
		panel.add(lblNewLabel);

		name = new JTextField();
		name.setBounds(96, 68, 209, 30);
		panel.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("State");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(96, 3, 161, 16);
		panel.add(lblNewLabel_1);

		state = new JComboBox();
		state.setFont(new Font("Tahoma", Font.BOLD, 12));
		state.setBackground(Color.WHITE);
		state.setBounds(96, 21, 209, 30);
		panel.add(state);

		lblNewLabel_3 = new JLabel("City Master");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBounds(0, 43, 84, 31);
		panel.add(lblNewLabel_3);

		lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setIcon(new ImageIcon(CityMaster.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_2.setBounds(0, 3, 84, 95);
		panel.add(lblNewLabel_2);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 130, 513, 198);
		frameCity.getContentPane().add(jsp);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setBounds(219, 104, 97, 25);
		frameCity.getContentPane().add(btnSave);
		btnSave.setForeground(Color.DARK_GRAY);
		btnSave.setMnemonic('S');

		btnView = new JButton("View");
		btnView.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnView.setBounds(316, 104, 97, 25);
		frameCity.getContentPane().add(btnView);
		btnView.setMnemonic('V');

		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClose.setBounds(414, 104, 85, 25);
		frameCity.getContentPane().add(btnClose);
		btnClose.setMnemonic('C');
		ActionListener lsbtn = new btnLsnr();
		ActionListener lscomb = new comboLsnr();
		state.addActionListener(lscomb);
		btnClose.addActionListener(lsbtn);
		btnView.addActionListener(lsbtn);
		btnSave.addActionListener(lsbtn);
		decorate();
	}

	private void decorate() throws Throwable {

		new gnApp().setFrameTitel(frameCity);
		new gnField().closeform(panel, frameCity);
		String vmsname = "State";
		String vverticle = new gnHierarchy().getVerticleCode();
		String vname = "%%";
		String SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticle + " , '" + vname + "')";
		new gnComp().fillNameCombo(SQL1, state);

	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Save") {
				try {
					saveEvent();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "View") {

			}

			if (value == "Close") {
				frameCity.dispose();
			}
		}
	}

	class comboLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = state.getSelectedItem().toString();
			new gnTable().RemoveTableRows(model);
			String vverticle = new gnHierarchy().getVerticleCode();
			String SQL = "call N_master_getCityforState('" + value + "' )";
			try {
				showCity(SQL);
				// citycode.setText("");
				// citycode.setText(new General().getMastermaxseq("City"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void showCity(String SQL) throws ClassNotFoundException, SQLException {
		String col[] = { "Code", "Name" };
		table = new gnTableModel().Tablemodel(table, model, SQL, col, 2, "N", "N", "N");
		JViewport prt1 = new JViewport();
		new gnTable().setTableBasics(table);
		prt1.setBackground(Color.WHITE);
		prt1.add(table, col);
		prt1.setVisible(true);
		jsp.setViewport(prt1);
	}

	public String saveEvent() throws SQLException, ClassNotFoundException, IOException {

		citycode.setText("");
		citycode.setText(new General().getMastermaxseq("City"));
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		// this.closeconn();
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String company = "INSERT INTO  master_table(  Category  , "
				+ " sub_category, Master_name , code , description , showAllow, parent_ref1 , ACtive , Mas_line_seq , verticle)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(company);
			prst.setString(1, "General");
			prst.setString(2, "Reference");
			prst.setString(3, "City");
			prst.setString(4, citycode.getText());
			prst.setString(5, name.getText());
			prst.setString(6, "Y");
			prst.setString(7, state.getSelectedItem().toString());
			prst.setString(8, "Y");
			prst.setString(9, citycode.getText());
			prst.setString(10, "0");

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
			}
		}
		return status;
	}
}// LAst

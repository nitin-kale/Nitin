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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class GST_Tax_distribution extends getResultSet {

	JFrame gstTaxDistribution;
	JPanel panel;
	private JTextField igst;
	private JTextField cgst;
	private JTextField sgst;
	JButton btnClose;
	JButton btnSave;
	JButton btnUpdate;

	Connection con1;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GST_Tax_distribution window = new GST_Tax_distribution();
					window.gstTaxDistribution.setVisible(true);
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
	public GST_Tax_distribution() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		gstTaxDistribution = new JFrame();
		gstTaxDistribution.getContentPane().setBackground(new Color(0, 255, 255));
		gstTaxDistribution.setAlwaysOnTop(true);
		gstTaxDistribution.setBounds(250, 250, 282, 215);
		gstTaxDistribution.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gstTaxDistribution.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("GST Tax % Distribution");
		lblNewLabel.setBounds(0, 0, 266, 29);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		gstTaxDistribution.getContentPane().add(lblNewLabel);

		panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.DARK_GRAY, Color.MAGENTA));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 25, 257, 149);
		gstTaxDistribution.getContentPane().add(panel);
		panel.setLayout(null);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(88, 119, 97, 25);
		panel.add(btnUpdate);
		btnUpdate.setMnemonic('U');

		btnClose = new JButton("Close");
		btnClose.setBounds(166, 119, 88, 25);
		panel.add(btnClose);
		btnClose.setMnemonic('C');

		btnSave = new JButton("Save");
		btnSave.setBounds(0, 119, 88, 25);
		panel.add(btnSave);
		btnSave.setMnemonic('S');

		JLabel lblNewLabel_1 = new JLabel("IGST");
		lblNewLabel_1.setBounds(56, 32, 56, 16);
		panel.add(lblNewLabel_1);

		igst = new JTextField();
		igst.setBounds(97, 33, 67, 22);
		panel.add(igst);
		igst.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("%");
		lblNewLabel_4.setBounds(169, 36, 56, 16);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_2 = new JLabel("CGST");
		lblNewLabel_2.setBounds(56, 61, 56, 16);
		panel.add(lblNewLabel_2);

		cgst = new JTextField();
		cgst.setBounds(97, 58, 67, 22);
		panel.add(cgst);
		cgst.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("%");
		lblNewLabel_5.setBounds(169, 61, 56, 16);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_3 = new JLabel("SGST");
		lblNewLabel_3.setBounds(56, 90, 56, 16);
		panel.add(lblNewLabel_3);

		sgst = new JTextField();
		sgst.setBounds(97, 84, 67, 22);
		panel.add(sgst);
		sgst.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("%");
		lblNewLabel_6.setBounds(169, 90, 56, 16);
		panel.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel(" ");
		lblNewLabel_7.setIcon(new ImageIcon(GST_Tax_distribution.class.getResource("/RetailProduct/panel11.png")));
		lblNewLabel_7.setBounds(0, 0, 254, 120);
		panel.add(lblNewLabel_7);

		ActionListener btnls = new btnLsnt();
		btnSave.addActionListener(btnls);
		btnClose.addActionListener(btnls);
		btnUpdate.addActionListener(btnls);

		decorate();
		showData();

	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(gstTaxDistribution);
		new gnField().closeform(panel, gstTaxDistribution);

	}

	class btnLsnt implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			switch (value) {

			case "Update":
				try {
					updateAction();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;

			case "Close":
				gstTaxDistribution.dispose();
				break;

			case "Save":
				try {
					SaveAction();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					e1.printStackTrace();
				}
				break;
			}
		}
	}

	private void showData() throws ClassNotFoundException, SQLException {
		String SQL = "call  GST_getTaxDist()";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			igst.setText(rs.getString(1));
			cgst.setText(rs.getString(2));
			sgst.setText(rs.getString(3));
			btnSave.setEnabled(false);
		}

	}

	private String validate() {
		String status = "Sucess";

		if (cgst.getText().length() == 0) {
			new General().msg("Enter  CGST%..");
			status = "Fail";
		}

		if (igst.getText().length() == 0) {
			new General().msg("Enter  IGST%..");
			status = "Fail";
		}

		if (sgst.getText().length() == 0) {
			new General().msg("Enter  SGST%..");
			status = "Fail";
		}

		return status;

	}

	void SaveAction() throws ClassNotFoundException, SQLException, IOException {
		String result = validate();
		if (result == "Sucess") {
			insertRecord();
		}
	}

	public String insertRecord() throws SQLException, ClassNotFoundException, IOException {
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String company = "INSERT INTO   ms_gst_taxdistribution (  IGST  , " + " CGST ,  SGST  )" + "values(?,?,?)";
		try {
			prst = con.prepareStatement(company);
			prst.setString(1, igst.getText().trim());
			prst.setString(2, cgst.getText().trim());
			prst.setString(3, sgst.getText().trim());
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
			cgst.setText("");
			sgst.setText("");
			igst.setText("");
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return status;
	}

	void updateAction() throws ClassNotFoundException, SQLException, IOException {
		String result = validate();
		if (result == "Sucess") {
			updateRecord();
		}
	}

	void updateRecord() throws SQLException, ClassNotFoundException, IOException {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		// this.closeconn();
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String company = "update ms_gst_taxdistribution set " + " IGST= ?  , CGST  = ?,  SGST  = ? ";

		try {
			prst = con.prepareStatement(company);
			prst.setString(1, igst.getText());
			prst.setString(2, cgst.getText());
			prst.setString(3, sgst.getText());
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con.commit();
				new General().msg("Data Updated Sucessfully");
			}
			prst.executeBatch();
			con.commit();
			new General().msg("Data Updated Sucessfully");
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con.rollback();
			status = "Fail";
		} finally {
			cgst.setText("");
			sgst.setText("");
			igst.setText("");
		}

		if (prst != null) {
			prst.close();
		}
		if (con != null) {
			con.close();
		}
	}
}// Last

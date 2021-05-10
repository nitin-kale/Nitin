package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

public class TaxCategoty extends getResultSet {

	JFrame TaxCategory;
	private JTextField name;
	private JTextField taxper;
	private JScrollPane jsp;
	private JButton btnSave;
	private JButton btnADD;
	private JButton btnView;
	private JButton btnClose;
	private Connection con, con1, con2;
	private String DBdetail;
	JPanel gstImagePanel;
	JRadioButton rb3;
	JRadioButton rb1;
	JRadioButton rb2;
	JButton btngstImage;
	String choice;

	private String[] col = { "Remove", "Code", "Name", "Tax Percentage", "Type" };
	public JTable table = new JTable();
	public DefaultTableModel model = new DefaultTableModel();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rb4;
	private JLabel lblNewLabel_3;
	private JTextField code;
	private JRadioButton rb5;
	private JRadioButton rb6;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxCategoty window = new TaxCategoty();
					window.TaxCategory.setVisible(true);
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
	public TaxCategoty() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		TaxCategory = new JFrame();
		TaxCategory.getContentPane().setForeground(new Color(0, 0, 128));
		TaxCategory.getContentPane().setBackground(new Color(173, 216, 230));
		TaxCategory.setAlwaysOnTop(true);
		TaxCategory.setBackground(new Color(153, 204, 204));
		TaxCategory.setBounds(1, 1, 1360, 750);
		TaxCategory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		TaxCategory.getContentPane().setLayout(null);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 103, 546, 558);
		TaxCategory.getContentPane().add(jsp);

		name = new JTextField();
		name.setBounds(129, 44, 306, 22);
		TaxCategory.getContentPane().add(name);
		name.setColumns(10);

		taxper = new JTextField();
		taxper.setBounds(440, 44, 56, 22);
		TaxCategory.getContentPane().add(taxper);
		taxper.setColumns(10);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Agency FB", Font.BOLD, 13));
		lblNewLabel.setBounds(170, 24, 129, 16);
		TaxCategory.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tax");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_1.setBounds(440, 30, 27, 16);
		TaxCategory.getContentPane().add(lblNewLabel_1);

		btnADD = new JButton("ADD");
		btnADD.setMnemonic('A');
		btnADD.setFont(new Font("Calibri", Font.BOLD, 13));
		btnADD.setBounds(338, 79, 97, 25);
		ActionListener btnAd = new addLsnr();
		btnADD.addActionListener(btnAd);

		TaxCategory.getContentPane().add(btnADD);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBackground(new Color(0, 0, 128));
		btnNewButton.setBounds(545, 0, 13, 705);
		TaxCategory.getContentPane().add(btnNewButton);

		btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(212, 667, 97, 25);
		btnSave.addActionListener(btnAd);

		TaxCategory.getContentPane().add(btnSave);

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(321, 667, 97, 25);
		btnClose.addActionListener(btnAd);
		TaxCategory.getContentPane().add(btnClose);

		btnView = new JButton("View");
		btnView.setFont(new Font("Calibri", Font.BOLD, 13));
		btnView.setMnemonic('V');
		btnView.setBounds(440, 79, 97, 25);
		btnView.addActionListener(btnAd);
		TaxCategory.getContentPane().add(btnView);

		JLabel lblNewLabel_2 = new JLabel("GST TYPES");
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel_2.setBounds(575, 13, 112, 16);
		TaxCategory.getContentPane().add(lblNewLabel_2);

		rb1 = new JRadioButton("CGST");
		rb1.setFont(new Font("Calibri", Font.BOLD, 14));
		rb1.setBackground(new Color(135, 206, 235));
		buttonGroup.add(rb1);
		rb1.setBounds(566, 32, 127, 25);
		TaxCategory.getContentPane().add(rb1);

		rb2 = new JRadioButton("SGST");
		rb2.setFont(new Font("Calibri", Font.BOLD, 14));
		rb2.setBackground(new Color(135, 206, 235));
		buttonGroup.add(rb2);
		rb2.setBounds(697, 32, 127, 25);
		TaxCategory.getContentPane().add(rb2);

		rb3 = new JRadioButton("IGST");
		rb3.setFont(new Font("Calibri", Font.BOLD, 14));
		rb3.setBackground(new Color(135, 206, 235));
		buttonGroup.add(rb3);
		rb3.setBounds(828, 32, 127, 25);
		TaxCategory.getContentPane().add(rb3);

		gstImagePanel = new JPanel();
		gstImagePanel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		gstImagePanel.setBounds(558, 103, 772, 602);
		TaxCategory.getContentPane().add(gstImagePanel);
		gstImagePanel.setLayout(null);

		btngstImage = new JButton("");
		btngstImage.setBounds(-12, 0, 784, 602);
		gstImagePanel.add(btngstImage);

		rb4 = new JRadioButton("Credit Adjustment");
		rb4.setBackground(new Color(135, 206, 235));
		buttonGroup.add(rb4);
		rb4.setBounds(1004, 32, 160, 25);
		TaxCategory.getContentPane().add(rb4);

		lblNewLabel_3 = new JLabel("Code");
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_3.setBounds(12, 25, 85, 16);
		TaxCategory.getContentPane().add(lblNewLabel_3);

		code = new JTextField();
		code.setBounds(12, 44, 116, 22);
		TaxCategory.getContentPane().add(code);
		code.setColumns(10);

		rb5 = new JRadioButton("Goods");
		rb5.setBackground(new Color(173, 216, 230));
		rb5.setForeground(new Color(0, 0, 128));
		rb5.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonGroup_1.add(rb5);
		rb5.setBounds(12, 69, 127, 25);
		TaxCategory.getContentPane().add(rb5);

		rb6 = new JRadioButton("Service");
		rb6.setBackground(new Color(173, 216, 230));
		rb6.setForeground(new Color(0, 0, 128));
		rb6.setFont(new Font("Calibri", Font.BOLD, 13));
		buttonGroup_1.add(rb6);
		rb6.setBounds(139, 69, 127, 25);
		TaxCategory.getContentPane().add(rb6);

		lblNewLabel_4 = new JLabel("HSN CODE/SAC Code Entry");
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setBounds(0, 0, 485, 16);
		TaxCategory.getContentPane().add(lblNewLabel_4);

		ActionListener rbls = new rbLsnr();
		rb1.addActionListener(rbls);
		rb2.addActionListener(rbls);
		rb3.addActionListener(rbls);
		rb4.addActionListener(rbls);

		decorate();

	}

	public void decorate() throws Throwable {

		new gnApp().setFrameTitel(TaxCategory);
		// btngstImage.setIcon(new
		// ImageIcon("D:\\AKN\\myProductImage\\GSTSTRUCTURE.png"));
		btngstImage.setIcon(new ImageIcon(POS.class.getResource("/RetailProduct/GSTSTRUCTURE.png")));

	}

	class rbLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			boolean ch1 = rb1.isSelected();
			boolean ch2 = rb2.isSelected();
			boolean ch3 = rb3.isSelected();
			boolean ch4 = rb4.isSelected();

			if (ch1) {
				choice = "CGST";
				new gnField().showFieldInfo(rb1, "CGST");
			}
			if (ch2) {
				choice = "SGST";
				new gnField().showFieldInfo(rb2, "SGST");
			}
			if (ch3) {
				choice = "IGST";
				new gnField().showFieldInfo(rb3, "IGST");

			}
			if (ch4) {
				choice = "Credit";
				new gnField().showFieldInfo(rb4, "Credit");
				// btngstImage.setIcon(new
				// ImageIcon("D:\\AKN\\myProductImage\\GSTcollection.png"));
				btngstImage.setIcon(new ImageIcon(POS.class.getResource("/RetailProduct/GSTcollection.png")));

			}

			showDetails(choice);
		}
	}

	private void showDetails(String vchoice) {
		switch (vchoice) {
		case "CGST":
			break;
		case "SGST":
			break;
		case "IGST":
			break;
		}

	}

	class addLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				switch (value) {
				case "ADD":
					addRecordToTable();
					break;
				case "Close":
					TaxCategory.dispose();
					break;
				case "View":
					viewData();
					break;
				case "Save":
					saveData();
					break;
				}
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	private void viewData() throws ClassNotFoundException, SQLException {
		btnADD.setEnabled(false);
		btnSave.setEnabled(false);
		new gnTable().RemoveTableRows(model);
		String vtaxcat = name.getText().trim();
		vtaxcat = "%" + vtaxcat + "%";
		String SQL = "call  Gst_getTaxData('" + vtaxcat + "')";
		model.setColumnIdentifiers(col);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { "X", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
			table.setModel(model);
		}
		JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(table, col);
		prt.setVisible(true);
		jsp.setViewport(prt);

	}

	private String validate() {
		String status = "Sucess";

		if (code.getText().length() == 0) {
			new General().msg("Enter code..");
			new gnImageSound().playAlertSound();
			status = "Fail";
		}

		if (name.getText().length() == 0) {
			new General().msg("Enter Tax Category Name..");
			new gnImageSound().playAlertSound();
			status = "Fail";
		}

		if (taxper.getText().length() == 0) {
			new General().msg("Select Tax %..");
			new gnImageSound().playAlertSound();
			status = "Fail";
		}

		if (rb5.isSelected() == false & rb6.isSelected() == false) {
			new General().msg("Select GST Type ..");
			new gnImageSound().playAlertSound();
			status = "Fail";
		}

		return status;
	}

	private void saveData() throws ClassNotFoundException, SQLException, IOException {

		if (table.getRowCount() > 0) {
			insertData();
		} else {
			new General().msg("No Data Avaibale ..");

		}
	}

	public void insertData() throws ClassNotFoundException, SQLException, IOException {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con = this.getConnection();
		con.setAutoCommit(false);
		String vgroup = "Retail";
		String taxGST = "Insert into    mstax_category(code , name,  taxper, type )   values(?,  ?,  ?,  ?) ";

		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con.prepareStatement(taxGST);
				prst.setString(1, table.getValueAt(k, 1).toString());
				prst.setString(2, table.getValueAt(k, 2).toString());
				prst.setString(3, table.getValueAt(k, 3).toString());
				prst.setString(4, table.getValueAt(k, 4).toString());
				// prst.setString(5, vgroup);

				// prst.setString(4, vgroup);
				prst.addBatch();
				DBdetail = "Fail";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
				}
				prst.executeBatch();
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg("GST Tax Category" + e.getMessage());
			e.getMessage();
			con.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBdetail == "Sucess") {
				con.commit();
				con.close();
				new General().msg("Data Saved sucessfully..");
				new gnTable().RemoveTableRows(model);
				taxper.setText(null);
				name.setText(null);
				code.setText(null);
			}
		}
	}

	private void addRecordToTable() {
		String vgsttype = "";
		String status = validate();
		if (status == "Sucess") {
			boolean vgoods = rb5.isSelected();
			if (vgoods) {
				vgsttype = "G";
			}
			boolean vservice = rb6.isSelected();
			if (vservice) {
				vgsttype = "S";
			}

			model.setColumnIdentifiers(col);
			model.addRow(new Object[] { "X", code.getText(), name.getText(), taxper.getText(), vgsttype });
			table.setModel(model);
			JViewport prt = new JViewport();
			prt.setBackground(Color.CYAN);
			prt.add(table, col);
			prt.setVisible(true);
			jsp.setViewport(prt);
		}
	}
}// Last

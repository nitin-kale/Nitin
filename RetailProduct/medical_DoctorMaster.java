package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Connection;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class medical_DoctorMaster extends getResultSet {

	JFrame Doctorframe;
	JComboBox degreeCombo;
	String saveStatus;
	JPanel panel;
	private String vcomp;
	private String vstore;
	private String DBhdr;
	private JTextField docname;
	Connection con1;
	private JTextField doccode;
	private JTextField citycode;
	private JTextField cityname;
	private JTextField phonenumber;
	private JTextField line1;
	private JTextField line2;
	private JTextField line3;
	private JTextField mobileno1;
	private JTextField mobileno2;
	private JTextField hospitalname;
	private String Edit = "N";

	private int vphone;
	private int vmobile1;
	private int vmobile2;
	private int vdoccode;
	private String vdocname;
	private String vdocdegree;
	private String vcitycode;
	private String vcityname;
	private String vhospitalname;
	private String vaddr1;
	private String vaddr2;
	private String vaddr3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					medical_DoctorMaster window = new medical_DoctorMaster();
					window.Doctorframe.setVisible(true);
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
	public medical_DoctorMaster() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		Doctorframe = new JFrame();
		Doctorframe.getContentPane().setBackground(new Color(245, 245, 245));
		Doctorframe.setAlwaysOnTop(true);
		Doctorframe.setBounds(140, 50, 783, 586);
		Doctorframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Doctorframe.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Doctor Information");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 765, 16);
		Doctorframe.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("* Doctor Code");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 39, 120, 16);
		Doctorframe.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("* Doctor Name");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_2.setBounds(126, 39, 120, 16);
		Doctorframe.getContentPane().add(lblNewLabel_2);

		JComboBox docCombo = new JComboBox();
		docCombo.setEnabled(false);
		docCombo.setModel(new DefaultComboBoxModel(new String[] { "Dr." }));
		docCombo.setBounds(126, 58, 53, 22);
		Doctorframe.getContentPane().add(docCombo);

		docname = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		docname.setToolTipText("Length of Doctor Name is  100 Chars");
		docname.setBounds(181, 58, 371, 26);
		Doctorframe.getContentPane().add(docname);
		docname.setColumns(10);

		doccode = new JTextField();
		doccode.setText("0");
		doccode.setEditable(false);
		doccode.setBounds(12, 58, 97, 26);
		Doctorframe.getContentPane().add(doccode);
		doccode.setColumns(10);

		panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBorder(new LineBorder(new Color(204, 255, 255), 1, true));
		panel.setBounds(12, 83, 540, 251);
		Doctorframe.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("* City");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(12, 48, 90, 16);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("* Phone Number");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(12, 16, 96, 16);
		panel.add(lblNewLabel_4);

		citycode = new JTextField();
		citycode.setEditable(false);
		citycode.setText(" ");
		citycode.setBounds(114, 45, 59, 26);
		panel.add(citycode);
		citycode.setColumns(10);

		cityname = new JTextField();
		cityname.setBounds(175, 45, 342, 26);
		panel.add(cityname);
		cityname.setColumns(10);

		phonenumber = new JTextField();
		phonenumber.setText("0");
		phonenumber.setBounds(114, 13, 182, 26);
		panel.add(phonenumber);
		phonenumber.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(
				new BevelBorder(BevelBorder.RAISED, new Color(253, 245, 230), new Color(139, 0, 139), null, null),
				"Other Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 102)));
		panel_1.setBounds(0, 82, 540, 168);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setBounds(12, 72, 56, 16);
		panel_1.add(lblNewLabel_5);

		line1 = new JTextField();
		line1.setToolTipText("Length of Address is 50 Chars Only ");
		line1.setBounds(12, 89, 269, 26);
		panel_1.add(line1);
		line1.setColumns(10);

		line2 = new JTextField();
		line2.setToolTipText("Length of Address is 50 Chars Only ");
		line2.setBounds(12, 112, 269, 26);
		panel_1.add(line2);
		line2.setColumns(10);

		line3 = new JTextField();
		line3.setToolTipText("Length of Address is 50 Chars Only ");
		line3.setBounds(12, 135, 269, 26);
		panel_1.add(line3);
		line3.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Mobile No1");
		lblNewLabel_6.setBounds(307, 72, 142, 16);
		panel_1.add(lblNewLabel_6);

		mobileno1 = new JTextField();
		mobileno1.setText("0");
		mobileno1.setBounds(301, 89, 148, 26);
		panel_1.add(mobileno1);
		mobileno1.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Mobile No2");
		lblNewLabel_7.setBounds(307, 115, 142, 16);
		panel_1.add(lblNewLabel_7);

		mobileno2 = new JTextField();
		mobileno2.setText("0");
		mobileno2.setBounds(301, 135, 148, 26);
		panel_1.add(mobileno2);
		mobileno2.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Hospial Name");
		lblNewLabel_8.setBounds(12, 23, 128, 16);
		panel_1.add(lblNewLabel_8);

		hospitalname = new JTextField();
		hospitalname.setToolTipText("Length of Hospital Name  is 100 Chars Only ");
		hospitalname.setBounds(12, 41, 437, 28);
		panel_1.add(hospitalname);
		hospitalname.setColumns(10);

		JLabel DocDegree = new JLabel("* Degree");
		DocDegree.setBounds(334, 16, 56, 16);
		panel.add(DocDegree);

		degreeCombo = new JComboBox();
		degreeCombo.setModel(new DefaultComboBoxModel(new String[] { "MBBS", "MS", "MD" }));
		degreeCombo.setBounds(389, 13, 128, 22);
		panel.add(degreeCombo);

		JButton btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(360, 331, 97, 25);
		Doctorframe.getContentPane().add(btnSave);

		JButton btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(455, 331, 97, 25);
		Doctorframe.getContentPane().add(btnClose);

		JScrollPane jsp = new JScrollPane();
		jsp.setBounds(12, 362, 741, 173);
		Doctorframe.getContentPane().add(jsp);

		JLabel image = new JLabel(" ");
		image.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\doctors1.jpg"));
		image.setBounds(559, 58, 194, 275);
		Doctorframe.getContentPane().add(image);
		ActionListener btnls = new btnLsnr();
		ActionListener btnCity = new CityLsnr();
		ActionListener docnamelsnr = new docLsnr();
		btnSave.addActionListener(btnls);
		btnClose.addActionListener(btnls);
		cityname.addActionListener(btnCity);
		docname.addActionListener(docnamelsnr);
		decorate();
	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(Doctorframe);
		new gnField().closeform(panel, Doctorframe);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();

	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (value == "Save") {
				String check;
				try {
					check = validate();
					if (check == "Sucess") {
						switch (Edit) {
						case "N":
							callSaveEvent();
							break;
						case "Y":
							removeRecord();
							callSaveEvent();
							break;
						}
					}
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (IOException e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Close") {
				Doctorframe.dispose();
			}

		}
	}

	private String validate() throws ClassNotFoundException, SQLException {
		saveStatus = "Sucess";
		getData();
		if (vdocname.length() == 0) {
			new General().msg("Enter Doctor Name..");
			docname.grabFocus();
			saveStatus = "Fail";
		}

		if (vcitycode.length() == 0) {
			new General().msg("Enter City information..");
			cityname.grabFocus();
			saveStatus = "Fail";
		}

		if (vcityname.length() == 0) {
			new General().msg("Enter City information..");
			cityname.grabFocus();
			saveStatus = "Fail";
		}

		if (Integer.toString(vmobile1).length() == 0) {
			vmobile1 = 0;
		}

		if (Integer.toString(vmobile2).length() == 0) {
			vmobile2 = 0;
		}

		return saveStatus;
	}

	private void getData() throws ClassNotFoundException, SQLException {

		if (Edit == "N") {
			generateNo();
		}
		try {
			vphone = Integer.parseInt(phonenumber.getText());
			vmobile1 = Integer.parseInt(mobileno1.getText());
			vmobile2 = Integer.parseInt(mobileno2.getText());
			vdoccode = Integer.parseInt(doccode.getText());
		} catch (Exception e) {
			new General().msg("Please Enter Number Only in Number Fileds");
			saveStatus = "Fail";
		}
		vdocname = docname.getText();
		vdocdegree = degreeCombo.getSelectedItem().toString();
		vcitycode = citycode.getText();
		vcityname = cityname.getText();
		vhospitalname = hospitalname.getText();
		vaddr1 = line1.getText();
		vaddr2 = line2.getText();
		vaddr3 = line3.getText();
	}

	private void removeRecord() throws SQLException {

		String vremovecode = doccode.getText();
		String SQL = "call medical_removeRecord(" + vcomp + " , " + vstore + ", " + vremovecode + ")";
		this.getResult(SQL);
	}

	private void callSaveEvent() throws ClassNotFoundException, SQLException, IOException {

		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con1 = (Connection) this.getConnection();
		con1.setAutoCommit(false);
		String SQL = "Insert into ms_doctor_master(Company_code , Site_code , "
				+ "doctor_code , doctor_name , city_code, city_name,"
				+ " phone, mobile1, mobile2, degree, addr1, addr2, addr3 , hospital_name )"
				+ " values(?,?, ?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con1.prepareStatement(SQL);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setInt(3, vdoccode);
			prst.setString(4, vdocname);
			prst.setString(5, vcitycode);
			prst.setString(6, vcityname);
			prst.setInt(7, vphone);
			prst.setInt(8, vmobile1);
			prst.setInt(9, vmobile2);
			prst.setString(10, vdocdegree);
			prst.setString(11, vaddr1);
			prst.setString(12, vaddr2);
			prst.setString(13, vaddr3);
			prst.setString(14, vhospitalname);
			prst.addBatch();
			new General().msg("Msg" + " " + prst);
			TotalRecordinsert = TotalRecordinsert + 1;
			DBhdr = "Fail";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				DBhdr = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			DBhdr = "Sucess";
		} catch (SQLException e) {
			new General().msg("Master - Doctor Info Saving Issue " + e.getMessage());
			con1.rollback();
			DBhdr = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") {
				con1.commit();
				con1.close();
				reset();
				new General().msg("Data Inserted Sucessfully");
			}
		}
	}

	private void generateNo() throws ClassNotFoundException, SQLException {
		String SQL = "Select coalesce(max(doctor_code),0) from ms_doctor_master where company_code = " + vcomp
				+ " and  site_code = " + vstore + " ";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			int vno = Integer.parseInt(rs.getString(1));
			vno = vno + 1;
			doccode.setText(Integer.toString(vno));
		}
	}

	class CityLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field Id
			System.out.println(value);
			System.out.println(i);
			String vcode = "%" + value + "%";
			String type = "City";
			try {
				new gnAdmin().showMasterTable(type, citycode, cityname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class docLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vstring = docname.getText();
			vstring = "%" + vstring + "%";
			try {
				new gnDoctor().getDocname(vstring);
			} catch (Throwable e) {
				new General().msg(e.getLocalizedMessage());
			} finally {
				doccode.setText(new gnDoctor().vvdoccode);
				docname.setText(new gnDoctor().vvdocname);
				phonenumber.setText(new gnDoctor().vphone);
				degreeCombo.setSelectedItem(new gnDoctor().vdegree);
				hospitalname.setText(new gnDoctor().vhospitalname);
				mobileno1.setText(new gnDoctor().vmobile1);
				mobileno2.setText(new gnDoctor().vmobile2);
				line1.setText(new gnDoctor().vaddr1);
				line2.setText(new gnDoctor().vaddr2);
				line3.setText(new gnDoctor().vaddr3);
				citycode.setText(new gnDoctor().vcitycode);
				cityname.setText(new gnDoctor().vcityname);
				Edit = "Y";
			}
		}
	}

	private void reset() {
		docname.setText(null);
		doccode.setText(null);
		citycode.setText(null);
		cityname.setText(null);
		line1.setText(null);
		line2.setText(null);
		line3.setText(null);
		mobileno1.setText("0");
		mobileno2.setText("0");
		hospitalname.setText(null);
		phonenumber.setText("0");
	}

}// Last

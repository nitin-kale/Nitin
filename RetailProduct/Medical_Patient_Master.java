package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.mysql.jdbc.Connection;

import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class Medical_Patient_Master extends getResultSet {

	private String vcomp;
	private String vstore;
	private String Edit = "N";
	Connection con1;
	public JFrame patientFrame;
	private JTextField patientid;
	JPanel panel;
	private JTextField patientname;
	private JTextField phonenumber;
	private JButton btnSave;
	private JButton btnClose;
	private JButton btnAdd;
	private JTextField docname;
	private JTextField doccode;
	private JTextField wardno;
	private JTextField buildingno;
	private JTextField roomno;
	private JTextField bedno;

	String saveStatus;
	String DBhdr;
	private String vpatientname;
	private int vpatientid;
	private int vphone;
	private int vdoccode;
	private String vward;
	private String vroom;
	private String vbuilding;
	private String vbedno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medical_Patient_Master window = new Medical_Patient_Master();
					window.patientFrame.setVisible(true);
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
	public Medical_Patient_Master() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		patientFrame = new JFrame();
		patientFrame.getContentPane().setBackground(new Color(255, 255, 255));
		patientFrame.setBackground(new Color(51, 255, 255));
		patientFrame.setResizable(false);
		patientFrame.setAlwaysOnTop(true);
		patientFrame.setBounds(300, 70, 515, 461);
		patientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		patientFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Patient Information");
		lblNewLabel.setBounds(0, 0, 497, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 14));
		patientFrame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("* Patient ID");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 33, 84, 16);
		patientFrame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("* Name");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_2.setBounds(34, 65, 45, 16);
		patientFrame.getContentPane().add(lblNewLabel_2);

		patientid = new JTextField();
		patientid.setBounds(92, 30, 116, 27);
		patientFrame.getContentPane().add(patientid);
		patientid.setColumns(10);

		patientname = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		patientname.setBounds(91, 62, 289, 27);
		patientFrame.getContentPane().add(patientname);
		patientname.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("* Phone");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_3.setBounds(23, 103, 56, 16);
		patientFrame.getContentPane().add(lblNewLabel_3);

		phonenumber = new JTextField();
		phonenumber.setBounds(92, 97, 133, 27);
		patientFrame.getContentPane().add(phonenumber);
		phonenumber.setColumns(10);

		panel = new JPanel();
		panel.setBackground(new Color(102, 255, 255));
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(255, 255, 255)),
				"Other Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 51, 102)));
		panel.setBounds(0, 220, 497, 175);
		patientFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Ward No");
		lblNewLabel_4.setBounds(30, 39, 55, 16);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Building No");
		lblNewLabel_5.setBounds(21, 66, 64, 16);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Room No");
		lblNewLabel_6.setBounds(30, 92, 55, 16);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_9 = new JLabel("Bed No");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setBounds(30, 120, 55, 16);
		panel.add(lblNewLabel_9);

		wardno = new JTextField();
		wardno.setBounds(91, 33, 122, 28);
		panel.add(wardno);
		wardno.setColumns(10);

		buildingno = new JTextField();
		buildingno.setBounds(91, 60, 122, 28);
		panel.add(buildingno);
		buildingno.setColumns(10);

		roomno = new JTextField();
		roomno.setBounds(91, 86, 122, 28);
		panel.add(roomno);
		roomno.setColumns(10);

		bedno = new JTextField();
		bedno.setBounds(91, 114, 122, 28);
		panel.add(bedno);
		bedno.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Cambria", Font.BOLD, 13));
		btnSave.setMnemonic('S');
		btnSave.setBounds(317, 394, 90, 28);
		patientFrame.getContentPane().add(btnSave);

		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Cambria", Font.BOLD, 13));
		btnClose.setMnemonic('C');
		btnClose.setBounds(407, 394, 90, 28);
		patientFrame.getContentPane().add(btnClose);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 204), null),
				"Doctor Info", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(6, 128, 491, 94);
		patientFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("* Doctor  ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_7.setBounds(6, 31, 66, 16);
		panel_1.add(lblNewLabel_7);

		docname = new JTextField();
		docname.setBounds(84, 25, 248, 28);
		panel_1.add(docname);
		docname.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Doctor");
		lblNewLabel_8.setBounds(37, 60, 42, 16);
		panel_1.add(lblNewLabel_8);

		doccode = new JTextField();
		doccode.setEnabled(false);
		doccode.setEditable(false);
		doccode.setBounds(84, 54, 122, 28);
		panel_1.add(doccode);
		doccode.setColumns(10);

		btnAdd = new JButton("Create New Doctor Info");
		btnAdd.setFont(new Font("Cambria", Font.BOLD, 13));
		btnAdd.setMnemonic('N');
		btnAdd.setBounds(305, 60, 180, 28);
		panel_1.add(btnAdd);

		ActionListener btnlsn = new btnLsnr();
		ActionListener doclsn = new docLsnr();
		ActionListener patientlsn = new patientLsnr();

		btnSave.addActionListener(btnlsn);
		btnClose.addActionListener(btnlsn);
		btnAdd.addActionListener(btnlsn);
		docname.addActionListener(doclsn);
		patientname.addActionListener(patientlsn);
		decorate();
	}

	private void decorate() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		new gnApp().setFrameTitel(patientFrame);
		new gnField().closeform(panel, patientFrame);

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
			}
		}
	}

	class patientLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vtext = patientname.getText();
			vtext = "%" + vtext + "%";
			try {
				new gnPatient().getPatientname(vtext);
			} catch (Throwable e) {
				new General().msg(e.getLocalizedMessage());
			} finally {

				patientid.setText(new gnPatient().vpatientcode);
				patientname.setText(new gnPatient().vpatientname);
				phonenumber.setText(new gnPatient().vphone);
				doccode.setText(new gnPatient().vdoccode);
				docname.setText(new gnPatient().vdocname);
				wardno.setText(new gnPatient().vward);
				buildingno.setText(new gnPatient().vbuilding);
				roomno.setText(new gnPatient().vroomno);
				bedno.setText(new gnPatient().vbedno);
				Edit = "Y";
			}

		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (value == "Close") {
				patientFrame.dispose();
			}

			if (value == "Save") {
				String result = null;
				try {
					result = validate();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
					new General().msg(e1.getMessage());
				}
				if (result == "Sucess") {
					switch (Edit) {
					case "Y":
						try {
							removeRecord();
							callSaveEvent();
						} catch (SQLException e1) {
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						break;

					case "N":
						try {
							callSaveEvent();
						} catch (ClassNotFoundException | SQLException | IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}

			if (value == "Create New Doctor Info") {
				try {
					medical_DoctorMaster window;
					window = new medical_DoctorMaster();
					window.Doctorframe.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

		}
	}

	private String validate() throws ClassNotFoundException, SQLException {
		saveStatus = "Sucess";
		getData();

		if (vpatientname.length() == 0) {
			new General().msg("Enter Patient Inforamtion..");
			patientname.grabFocus();
			saveStatus = "Fail";
		}

		if (Integer.toString(vphone).length() == 0) {
			new General().msg("Enter phone no.if not available enter 0.");
			phonenumber.grabFocus();
			saveStatus = "Fail";
		}

		if (Integer.toString(vdoccode).length() == 0) {
			new General().msg("Enter Doctor Information if Not Available Seleve No Available Option from List..");
			docname.grabFocus();
			saveStatus = "Fail";
		}

		return saveStatus;
	}

	private void getData() throws ClassNotFoundException, SQLException {

		if (Edit == "N") {
			generateNo();
		}
		try {
			vpatientid = Integer.parseInt(patientid.getText());
			vpatientname = patientname.getText();
			vphone = Integer.parseInt(phonenumber.getText());
			vdoccode = Integer.parseInt(doccode.getText());
			vward = wardno.getText();
			vroom = roomno.getText();
			vbuilding = buildingno.getText();
			vbedno = bedno.getText();
		} catch (Exception e) {
			new General().msg("Please Enter Number Only in Number Fileds");
			saveStatus = "Fail";
		}
	}

	private void generateNo() throws ClassNotFoundException, SQLException {
		String SQL = "Select coalesce(max(patient_code),0) from ms_patient_master where company_code = " + vcomp
				+ " and  site_code = " + vstore + " ";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			int vno = Integer.parseInt(rs.getString(1));
			vno = vno + 1;
			patientid.setText(Integer.toString(vno));
		}
	}

	private void removeRecord() throws SQLException {

		String vremovecode = patientid.getText();
		String SQL = "call medical_removePatientRecord(" + vcomp + " , " + vstore + ", " + vremovecode + ")";
		this.getResult(SQL);
	}

	private void callSaveEvent() throws ClassNotFoundException, SQLException, IOException {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		con1 = (Connection) this.getConnection();
		con1.setAutoCommit(false);
		String SQL = "Insert into ms_Patient_master(Company_code , Site_code , "
				+ "doctor_code , patient_code , name,  phone,  ward, building, bedno, roomno)"
				+ " values(?,?,?,?,?,?,?,?,?,? )";
		try {
			prst = con1.prepareStatement(SQL);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setInt(3, vdoccode);
			prst.setInt(4, vpatientid);
			prst.setString(5, vpatientname);
			prst.setInt(6, vphone);
			prst.setString(7, vward);
			prst.setString(8, vbuilding);
			prst.setString(9, vbedno);
			prst.setString(10, vroom);
			prst.addBatch();
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

	private void reset() {
		patientid.setText(null);
		patientname.setText(null);
		phonenumber.setText("0");
		wardno.setText(null);
		bedno.setText(null);
		buildingno.setText(null);
		roomno.setText(null);
	}

}// Last

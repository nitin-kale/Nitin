package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class FreezeFinYear extends getResultSet {

	JFrame freezefinyearFrame;
	private JTextField compcode;
	private JTextField compname;
	private JTextField storecode;
	private JTextField storename;
	private JTextField finyear;
	JButton btnCheck;
	JButton btnFreeze;
	private JLabel lblNewLabel_6;

	JScrollPane jsp;
	public JTable table = new JTable();
	public DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					FreezeFinYear window = new FreezeFinYear();
					window.freezefinyearFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
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
	public FreezeFinYear() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		freezefinyearFrame = new JFrame();
		freezefinyearFrame.setAlwaysOnTop(true);
		freezefinyearFrame.getContentPane().setBackground(Color.WHITE);
		freezefinyearFrame.setBounds(380, 110, 537, 511);
		freezefinyearFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		freezefinyearFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Company");
		lblNewLabel.setBounds(10, 56, 67, 16);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		freezefinyearFrame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Store");
		lblNewLabel_1.setBounds(10, 80, 67, 16);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		freezefinyearFrame.getContentPane().add(lblNewLabel_1);

		compcode = new JTextField();
		compcode.setBounds(89, 53, 51, 25);
		compcode.setEditable(false);
		compcode.setFont(new Font("Tahoma", Font.BOLD, 12));
		freezefinyearFrame.getContentPane().add(compcode);
		compcode.setColumns(10);

		compname = new JTextField();
		compname.setBounds(140, 53, 264, 25);
		compname.setBackground(Color.WHITE);
		compname.setEditable(false);
		compname.setFont(new Font("Tahoma", Font.BOLD, 12));
		freezefinyearFrame.getContentPane().add(compname);
		compname.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Freeze Financial Year");
		lblNewLabel_2.setBounds(12, 0, 507, 22);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(0, 0, 51));
		lblNewLabel_2.setIcon(null);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		freezefinyearFrame.getContentPane().add(lblNewLabel_2);

		storecode = new JTextField();
		storecode.setBounds(89, 82, 51, 25);
		storecode.setEditable(false);
		storecode.setFont(new Font("Tahoma", Font.BOLD, 12));
		freezefinyearFrame.getContentPane().add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setBounds(140, 82, 264, 25);
		storename.setBackground(Color.WHITE);
		storename.setEditable(false);
		storename.setFont(new Font("Tahoma", Font.BOLD, 12));
		freezefinyearFrame.getContentPane().add(storename);
		storename.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setBounds(22, 30, 456, 22);
		lblNewLabel_3.setIcon(new ImageIcon(FreezeFinYear.class.getResource("/RetailProduct/Anim4.gif")));
		freezefinyearFrame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(
				"** Note: Once Fin. Year Freeze, User can not Add/Modify/Delete Any Transaction ");
		lblNewLabel_4.setBounds(51, 109, 456, 16);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_4.setIcon(null);
		freezefinyearFrame.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Freeze Financial Year");
		lblNewLabel_5.setBounds(10, 141, 130, 16);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		freezefinyearFrame.getContentPane().add(lblNewLabel_5);

		finyear = new JTextField();
		finyear.setBounds(140, 133, 116, 32);
		finyear.setBackground(Color.WHITE);
		finyear.setEditable(false);
		finyear.setFont(new Font("Arial", Font.BOLD, 15));
		freezefinyearFrame.getContentPane().add(finyear);
		finyear.setColumns(10);

		jsp = new JScrollPane();
		jsp.setBounds(10, 180, 509, 273);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		freezefinyearFrame.getContentPane().add(jsp);

		btnFreeze = new JButton("Freeze Now");
		btnFreeze.setBounds(287, 155, 111, 25);
		btnFreeze.setEnabled(false);
		freezefinyearFrame.getContentPane().add(btnFreeze);

		btnCheck = new JButton("Year End");
		btnCheck.setBounds(287, 127, 111, 25);
		btnCheck.setMnemonic('V');
		freezefinyearFrame.getContentPane().add(btnCheck);

		lblNewLabel_6 = new JLabel(" ");
		lblNewLabel_6.setBounds(0, 0, 519, 466);
		lblNewLabel_6.setIcon(new ImageIcon(FreezeFinYear.class.getResource("/RetailProduct/panel1.png")));
		freezefinyearFrame.getContentPane().add(lblNewLabel_6);

		ActionListener btn = new btnLsnr();
		btnCheck.addActionListener(btn);
		btnFreeze.addActionListener(btn);

		Decorate();
	}

	private void Decorate() throws Throwable {

		compcode.setText(vcomp);
		compname.setText(new gnConfig().getCompanyname());
		storecode.setText(vstore);
		storename.setText(new gnConfig().getStoreName());
		finyear.setText(new gnFinYear().getReportingFinYear());
		ProcessViewAction();
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Year End") {
				try {

					String status = validateprv();
					if (status == "Sucess") {
						String status1 = validatecurrent();
						if (status1 == "Sucess") {
							performYearEnd();
						}
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
					new General().msg(e1.getLocalizedMessage());
				}
			}

			if (value == "Freeze Now") {
				try {
					FreezeFinYear();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
					new General().msg(e1.getMessage());
				}
			}

		}
	}

	public void FreezeFinYear() throws SQLException, ClassNotFoundException {
		vcomp = compcode.getText();
		vstore = storecode.getText();
		String vfreezefinyear = finyear.getText();
		String vdate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
		String SQL = "Call Account_FreezeYear(" + vcomp + ",  " + vstore + " , '" + vfreezefinyear + "' , '" + vdate
				+ "')";
		this.getResult(SQL);
	}

	private String validateprv() throws Throwable {
		String Status = "Sucess";
		String vprvFinYearStatus = new gnFinYear().getprvFinyearFreezeStatus();
		switch (vprvFinYearStatus) {
		case "N":
			new General().msg(
					"Please Check Privious Year Financial Year  Is Not Freezed ..Please Freeze Privious Year First");
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			Status = "Fail";
			break;
		}
		return Status;
	}

	private String validatecurrent() {
		String Status = "Sucess";
		String FreezeStatus = " ";
		try {
			FreezeStatus = new gnFinYear().getFinyearFreezeStatus();
			switch (FreezeStatus) {
			case "Y":
				new General().msg("Financial Year  Is Already Freezed ...");
				new gnImageSound().playAlertSound();
				new gnImageSound().playAlertSound();
				Status = "Fail";
				break;
			}
		} catch (Throwable e) {
			e.printStackTrace();
			new General().msg(e.getLocalizedMessage());
		}
		new General().msg("Return Status is :" + " " + Status);
		return Status;
	}

	private void performYearEnd() throws Throwable {
		btnCheck.setBackground(Color.BLUE);
		btnCheck.setForeground(Color.WHITE);
		new gnDecorate().setBusyCursor(freezefinyearFrame);
		new gnFinYear().closeFinYear();
		btnCheck.setBackground(Color.CYAN);
		btnCheck.setForeground(Color.BLACK);
		new gnDecorate().setDefaultCursor(freezefinyearFrame);
		new General().Quickmsg("Year End Process  Complete Sucessfully...You Can Freeze Year Now");
		btnFreeze.setEnabled(true);

	}

	private void ProcessViewAction() throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		vcomp = compcode.getText();
		vstore = storecode.getText();

		String SQL = "Call  Fin_getAllData(" + vcomp + "," + vstore + " )";
		// rs = this.getSPResult(SQL) ;
		String Col[] = { "Company", "Fin.Year", "Start Date", "End Date", "Cur.Fin.Yr", "Freeze Fin Year",
				"Freeze Date" };
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 7, "N", "N", "N");
		table.setModel(model);
		JViewport prt = new JViewport();
		prt.add(table, Col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		table.requestFocus();

	}

}// last

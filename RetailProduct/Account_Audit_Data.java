package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

public class Account_Audit_Data extends getResultSet {

	JFrame AccountDataAuditFrame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField finyear;
	private JTextField freezeStatus;
	private JTextField prvfinyear;
	private JTextField prvfreezeStatus;
	private JTextField compname;
	private JTextField storename;
	JScrollPane jsp;
	JRadioButton rb1;
	JRadioButton rb2;
	JRadioButton rb3;
	JRadioButton rb4;
	JRadioButton rb5;
	JRadioButton rb6;
	JButton btnAudit;
	JButton btnExport;
	JButton btnClose;
	String Choice = "";
	JLabel myLabel;

	public DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Account_Audit_Data window = new Account_Audit_Data();
					window.AccountDataAuditFrame.setVisible(true);
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
	public Account_Audit_Data() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		AccountDataAuditFrame = new JFrame();
		AccountDataAuditFrame.getContentPane().setBackground(Color.WHITE);
		AccountDataAuditFrame.setBackground(Color.WHITE);
		AccountDataAuditFrame.setAlwaysOnTop(true);
		AccountDataAuditFrame.setBounds(10, 10, 1350, 700);
		AccountDataAuditFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		AccountDataAuditFrame.getContentPane().setLayout(null);

		rb1 = new JRadioButton("Account Entry Posted in GL-Summary");
		rb1.setBounds(496, 0, 322, 25);
		buttonGroup.add(rb1);
		rb1.setBackground(Color.WHITE);
		rb1.setForeground(Color.DARK_GRAY);
		rb1.setFont(new Font("Arial", Font.BOLD, 12));
		AccountDataAuditFrame.getContentPane().add(rb1);

		rb3 = new JRadioButton("Account Entry Posted in Gl-Group - Summary");
		rb3.setBounds(496, 45, 322, 25);
		buttonGroup.add(rb3);
		rb3.setBackground(Color.WHITE);
		rb3.setForeground(Color.DARK_GRAY);
		rb3.setFont(new Font("Arial", Font.BOLD, 12));
		AccountDataAuditFrame.getContentPane().add(rb3);

		rb5 = new JRadioButton("Account Entry Posting in SubGroup -Summary");
		rb5.setBounds(496, 90, 322, 25);
		buttonGroup.add(rb5);
		rb5.setBackground(Color.WHITE);
		rb5.setForeground(Color.DARK_GRAY);
		rb5.setFont(new Font("Arial", Font.BOLD, 12));
		AccountDataAuditFrame.getContentPane().add(rb5);

		rb2 = new JRadioButton("Account Entry Posted in GL-Detail");
		rb2.setBounds(496, 22, 322, 25);
		buttonGroup.add(rb2);
		rb2.setBackground(Color.WHITE);
		rb2.setForeground(Color.DARK_GRAY);
		rb2.setFont(new Font("Arial", Font.BOLD, 12));
		AccountDataAuditFrame.getContentPane().add(rb2);

		rb4 = new JRadioButton("Account Entry Group in GL-Group-Detail");
		rb4.setBounds(496, 68, 322, 25);
		buttonGroup.add(rb4);
		rb4.setBackground(Color.WHITE);
		rb4.setForeground(Color.DARK_GRAY);
		rb4.setFont(new Font("Arial", Font.BOLD, 12));
		AccountDataAuditFrame.getContentPane().add(rb4);

		rb6 = new JRadioButton("Account Entry Posting in SubGroup - Detail");
		rb6.setBounds(496, 114, 322, 25);
		buttonGroup.add(rb6);
		rb6.setBackground(Color.WHITE);
		rb6.setForeground(Color.DARK_GRAY);
		rb6.setFont(new Font("Arial", Font.BOLD, 12));
		AccountDataAuditFrame.getContentPane().add(rb6);

		myLabel = new JLabel(" ");
		myLabel.setVisible(false);
		myLabel.setBounds(404, 0, 832, 139);
		myLabel.setIcon(new ImageIcon(Account_Audit_Data.class.getResource("/RetailProduct/panel1.png")));
		AccountDataAuditFrame.getContentPane().add(myLabel);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 145, 1332, 510);
		AccountDataAuditFrame.getContentPane().add(jsp);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.ORANGE, Color.DARK_GRAY));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 13, 407, 125);
		AccountDataAuditFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Running Fin Year");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(42, 65, 97, 16);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Fin Freeze Status");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(42, 93, 110, 16);
		panel.add(lblNewLabel_3);

		finyear = new JTextField();
		finyear.setFont(new Font("Arial", Font.BOLD, 13));
		finyear.setBounds(145, 62, 64, 22);
		panel.add(finyear);
		finyear.setColumns(10);

		freezeStatus = new JTextField();
		freezeStatus.setFont(new Font("Arial", Font.BOLD, 13));
		freezeStatus.setBounds(145, 88, 64, 22);
		panel.add(freezeStatus);
		freezeStatus.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Prv.Fin Year");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(263, 65, 76, 16);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Prv.Freeze Status");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(231, 93, 110, 16);
		panel.add(lblNewLabel_5);

		prvfinyear = new JTextField();
		prvfinyear.setFont(new Font("Arial", Font.BOLD, 13));
		prvfinyear.setBounds(340, 62, 55, 22);
		panel.add(prvfinyear);
		prvfinyear.setColumns(10);

		prvfreezeStatus = new JTextField();
		prvfreezeStatus.setFont(new Font("Arial", Font.BOLD, 13));
		prvfreezeStatus.setBounds(340, 90, 55, 22);
		panel.add(prvfreezeStatus);
		prvfreezeStatus.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Company");
		lblNewLabel_6.setBounds(14, 13, 64, 16);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Branch");
		lblNewLabel_7.setBounds(22, 30, 56, 16);
		panel.add(lblNewLabel_7);

		compname = new JTextField();
		compname.setBounds(93, 10, 302, 22);
		panel.add(compname);
		compname.setColumns(10);

		storename = new JTextField();
		storename.setBounds(93, 36, 302, 22);
		panel.add(storename);
		storename.setColumns(10);

		btnAudit = new JButton("Do Audit");
		btnAudit.setMnemonic('D');
		btnAudit.setBounds(1235, 39, 97, 36);
		AccountDataAuditFrame.getContentPane().add(btnAudit);

		btnExport = new JButton("Export");
		btnExport.setMnemonic('E');
		btnExport.setBounds(1235, 76, 97, 36);
		AccountDataAuditFrame.getContentPane().add(btnExport);

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(1235, 112, 97, 36);
		AccountDataAuditFrame.getContentPane().add(btnClose);

		ActionListener btnls = new btnLsnr();
		btnAudit.addActionListener(btnls);
		btnClose.addActionListener(btnls);
		btnExport.addActionListener(btnls);

		ActionListener rbl = new rbLsnr();
		rb1.addActionListener(rbl);
		rb2.addActionListener(rbl);
		rb3.addActionListener(rbl);
		rb4.addActionListener(rbl);
		rb5.addActionListener(rbl);
		rb6.addActionListener(rbl);

		Decorate();
	}

	private void Decorate() throws Throwable {
		new gnApp().setFrameTitel(AccountDataAuditFrame);
		myLabel.setEnabled(false);
		myLabel.setEnabled(true);
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String value = e.getActionCommand();

			if (value == "Do Audit") {
				try {
					processAction();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Close") {
				AccountDataAuditFrame.dispose();
			}

			if (value == "Export") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}
		}
	}

	private void processAction() throws Throwable {

		btnAudit.setBackground(Color.BLACK);
		btnAudit.setForeground(Color.WHITE);
		new General().Quickmsg("Processing Request ..Please Wait.");
		new gnDecorate().setBusyCursor(AccountDataAuditFrame);

		String vcurfinyear = new gnFinYear().getReportingFinYear();
		String vprvinyear = new gnFinYear().getPriviousFinyear();

		String SQL = "call   Acc_AUDIT_GL_Data( " + vcomp + " ," + vstore + " ,'" + vcurfinyear + "', '" + vprvinyear
				+ "')";
		String SQL1 = "call   Acc_AUDIT_Group_Data( " + vcomp + " ," + vstore + " ,'" + vcurfinyear + "', '"
				+ vprvinyear + "')";
		// String SQL2 = "call Acc_AUDIT_SubGroup_Data( "+vcomp+" ,"+vstore+"
		// ,'"+vcurfinyear+"', '"+vprvinyear+"')" ;
		// new General().msg(SQL);
		this.getSPResult(SQL);
		this.getSPResult(SQL1);
		new gnDecorate().setDefaultCursor(AccountDataAuditFrame);
		btnAudit.setBackground(Color.CYAN);
		btnAudit.setForeground(Color.BLACK);
		myLabel.setVisible(true);
		new General().Quickmsg("Data Calculation Completed");
	}

	class rbLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			boolean vrb1 = rb1.isSelected();
			boolean vrb2 = rb2.isSelected();
			boolean vrb3 = rb3.isSelected();
			boolean vrb4 = rb4.isSelected();
			boolean vrb5 = rb5.isSelected();
			boolean vrb6 = rb6.isSelected();

			if (vrb1) {
				Choice = "lbl1";
			}

			if (vrb2) {
				Choice = "lbl2";
				Choice = "GLDetail";
			}

			if (vrb3) {
				Choice = "lbl3";
			}

			if (vrb4) {
				Choice = "lbl4";
				Choice = "GroupDetail";

			}

			if (vrb5) {
				Choice = "lbl5";
			}

			if (vrb6) {
				Choice = "lbl6";
				Choice = "SubGroupDetail";
			}

			try {
				showData();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}

		}
	}

	private void showData() throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		String colDetail[] = { "Type", "Code", "Name", "Finyear", "OP.Amount", "OpDrcr", "Debit", "Credit",
				"Closing Amt", "Closing Drcr", "Acc.Creditt", "Acc Debit", "Prv.Year Cloisng ", "Prv.Year Drcr" };
		model.setColumnIdentifiers(colDetail);
		String SQL = "call  Acc_AUDIT_Get_Data('" + Choice + "', " + vcomp + ", " + vstore + " )";
		// new General().msg(SQL);
		table = new gnTableModel().Tablemodel(table, model, SQL, colDetail, 14, "N", "N", "N");
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.white);
		table.setGridColor(Color.orange);
		// table.setFont( "Arial", 15, 15);

		JViewport prt = new JViewport();
		prt.add(table, colDetail);
		prt.setVisible(true);
		prt.setBackground(Color.WHITE);
		jsp.setViewport(prt);

	}

}// Last

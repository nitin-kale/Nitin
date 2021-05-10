package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GST_Filling_data {

	JFrame gst_returnFile_data;
	private JTextField fromdate;
	private JTextField todate;
	private JTextField finyear;
	private JTextField compname;
	private JTextField isgst;
	private JTextField gstno;
	private JTextField statecode;
	private JButton btnExport;
	private JTextField statename;
	JPanel lpanel;
	JPanel rpanel;
	JButton btngst1;
	JButton btngst2;
	JButton btngst3;
	JButton btngst4;
	JButton btngst5;
	JButton btngst6;
	JButton btngst7;
	JButton btngst8;
	JButton btngst9;
	JButton btngst10;

	JScrollPane jsp;
	String vcomp;
	String vstore;

	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	String SQL;
	String col[];
	String colforchoice7[];
	String colforchoice10[];
	JScrollPane jsp1;
	JTable table1 = new JTable();
	DefaultTableModel model1 = new DefaultTableModel();

	private JRadioButton rb3;
	private JRadioButton rb4;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb5;
	private JRadioButton rb6;
	private JRadioButton rb7;
	private JRadioButton rb8;
	private JRadioButton rb9;
	private JRadioButton rb10;
	private JRadioButton rb11;

	private String choice = "1";

	private JLabel lblNewLabel_9;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField scheme;
	private JLabel lblNewLabel_5;
	private JTextField schedule;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GST_Filling_data window = new GST_Filling_data();
					window.gst_returnFile_data.setVisible(true);
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
	public GST_Filling_data() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		gst_returnFile_data = new JFrame();
		gst_returnFile_data.getContentPane().setBackground(new Color(153, 0, 102));
		gst_returnFile_data.setBackground(Color.WHITE);
		gst_returnFile_data.setAlwaysOnTop(true);
		gst_returnFile_data.setBounds(0, 1, 1375, 760);
		gst_returnFile_data.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gst_returnFile_data.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("GST Return File Data");
		lblNewLabel.setBounds(251, 0, 1081, 25);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(204, 255, 204));
		lblNewLabel.setBackground(new Color(255, 218, 185));
		gst_returnFile_data.getContentPane().add(lblNewLabel);

		lpanel = new JPanel();
		lpanel.setBorder(null);
		lpanel.setBackground(new Color(102, 0, 102));
		lpanel.setBounds(1, 1, 199, 522);
		lpanel.setVisible(false);

		rpanel = new JPanel();
		rpanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "GST - Return File Data",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(128, 0, 128)));
		rpanel.setBackground(new Color(0, 255, 255));
		// rpanel.setBounds(201, 115, 1131, 408);
		rpanel.setBounds(1, 115, 1360, 408);

		// gst_returnFile_data.getContentPane().add(rpanel);
		rpanel.setLayout(null);

		jsp = new JScrollPane();
		// jsp.setBounds(12, 13, 1120, 361);
		jsp.setBounds(1, 1, 1143, 392);

		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		rpanel.add(jsp);

		JSplitPane mysplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lpanel, rpanel);
		mysplit.setBounds(1, 115, 1350, 408);
		lpanel.setLayout(null);

		lblNewLabel_9 = new JLabel("Sales- GSTR1");
		lblNewLabel_9.setForeground(Color.BLACK);
		lblNewLabel_9.setBackground(new Color(102, 0, 102));
		lblNewLabel_9.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_9.setBounds(12, 27, 127, 16);
		lpanel.add(lblNewLabel_9);

		rb1 = new JRadioButton("B2B");
		rb1.setMnemonic('B');
		buttonGroup.add(rb1);
		rb1.setBackground(Color.WHITE);
		rb1.setForeground(new Color(0, 0, 102));
		rb1.setFont(new Font("Cambria", Font.BOLD, 13));
		rb1.setBounds(12, 52, 179, 25);
		lpanel.add(rb1);

		rb2 = new JRadioButton("B2C-Large Sale");
		rb2.setMnemonic('L');
		buttonGroup.add(rb2);
		rb2.setBackground(Color.WHITE);
		rb2.setForeground(new Color(0, 0, 102));
		rb2.setFont(new Font("Cambria", Font.BOLD, 13));
		rb2.setBounds(12, 79, 179, 25);
		lpanel.add(rb2);

		rb3 = new JRadioButton("B2C-Small Sale");
		rb3.setMnemonic('S');
		buttonGroup.add(rb3);
		rb3.setBackground(Color.WHITE);
		rb3.setForeground(new Color(0, 0, 102));
		rb3.setFont(new Font("Cambria", Font.BOLD, 13));
		rb3.setBounds(12, 109, 179, 25);
		lpanel.add(rb3);

		rb4 = new JRadioButton("CN/DN/RV- Reg TaxPayer");
		rb4.setMnemonic('C');
		buttonGroup.add(rb4);
		rb4.setBackground(Color.WHITE);
		rb4.setForeground(new Color(0, 0, 102));
		rb4.setFont(new Font("Cambria", Font.BOLD, 13));
		rb4.setBounds(12, 139, 179, 25);
		lpanel.add(rb4);

		rb5 = new JRadioButton("CN/DN/RV- Non.Reg TaxPayer");
		rb5.setMnemonic('D');
		buttonGroup.add(rb5);
		rb5.setForeground(new Color(0, 0, 102));
		rb5.setFont(new Font("Cambria", Font.BOLD, 13));
		rb5.setBackground(Color.WHITE);
		rb5.setBounds(12, 169, 179, 25);
		lpanel.add(rb5);

		rb7 = new JRadioButton("Export");
		rb7.setMnemonic('E');
		buttonGroup.add(rb7);
		rb7.setForeground(new Color(0, 0, 102));
		rb7.setFont(new Font("Cambria", Font.BOLD, 13));
		rb7.setBackground(Color.WHITE);
		rb7.setBounds(12, 199, 179, 25);
		lpanel.add(rb7);

		rb8 = new JRadioButton("Advance");
		rb8.setMnemonic('A');
		buttonGroup.add(rb8);
		rb8.setForeground(new Color(0, 0, 102));
		rb8.setFont(new Font("Cambria", Font.BOLD, 13));
		rb8.setBackground(Color.WHITE);
		rb8.setBounds(12, 229, 179, 25);
		lpanel.add(rb8);

		rb9 = new JRadioButton("Advance-Adjustment");
		buttonGroup.add(rb9);
		rb9.setForeground(new Color(0, 0, 102));
		rb9.setFont(new Font("Cambria", Font.BOLD, 13));
		rb9.setBackground(Color.WHITE);
		rb9.setBounds(12, 263, 179, 25);
		lpanel.add(rb9);

		rb10 = new JRadioButton("Nil Rated Supply");
		buttonGroup.add(rb10);
		rb10.setForeground(new Color(0, 0, 102));
		rb10.setFont(new Font("Cambria", Font.BOLD, 13));
		rb10.setBackground(Color.WHITE);
		rb10.setBounds(12, 302, 179, 25);
		lpanel.add(rb10);

		rb11 = new JRadioButton("List of Documents");
		rb11.setFont(new Font("Cambria", Font.BOLD, 13));
		buttonGroup.add(rb11);
		rb11.setBackground(Color.WHITE);
		rb11.setForeground(new Color(0, 0, 102));
		rb11.setBounds(12, 332, 179, 25);
		lpanel.add(rb11);

		JLabel lblNewLabel_10 = new JLabel(" ");
		lblNewLabel_10.setIcon(new ImageIcon(GST_Filling_data.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel_10.setBounds(0, 0, 199, 406);
		lpanel.add(lblNewLabel_10);

		gst_returnFile_data.getContentPane().add(mysplit);
		mysplit.setDividerLocation(200);
		mysplit.setContinuousLayout(true);

		// JSplitPane mySplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
		// leftPanel, jsp);

 
		JLabel lblNewLabel_2 = new JLabel("Financial Year");
		lblNewLabel_2.setBounds(12, 16, 101, 16);
		lblNewLabel_2.setForeground(new Color(51, 0, 153));
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD, 14));
		gst_returnFile_data.getContentPane().add(lblNewLabel_2);

		finyear = new JTextField();
		finyear.setBounds(110, 13, 66, 22);
		finyear.setEditable(false);
		gst_returnFile_data.getContentPane().add(finyear);
		finyear.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Company");
		lblNewLabel_6.setBounds(810, 38, 56, 16);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		gst_returnFile_data.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("GSTIN");
		lblNewLabel_7.setBounds(800, 63, 66, 16);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		gst_returnFile_data.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("State");
		lblNewLabel_8.setBounds(810, 86, 56, 16);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		gst_returnFile_data.getContentPane().add(lblNewLabel_8);

		compname = new JTextField();
		compname.setBounds(872, 38, 279, 22);
		compname.setBackground(new Color(0, 255, 255));
		compname.setEditable(false);
		compname.setForeground(new Color(128, 0, 0));
		compname.setFont(new Font("Calibri", Font.BOLD, 12));
		gst_returnFile_data.getContentPane().add(compname);
		compname.setColumns(10);

		isgst = new JTextField();
		isgst.setBounds(872, 60, 26, 22);
		isgst.setBackground(new Color(0, 255, 255));
		isgst.setEditable(false);
		isgst.setForeground(new Color(128, 0, 0));
		isgst.setFont(new Font("Calibri", Font.BOLD, 12));
		gst_returnFile_data.getContentPane().add(isgst);
		isgst.setColumns(10);

		gstno = new JTextField();
		gstno.setBounds(899, 60, 253, 22);
		gstno.setBackground(new Color(0, 255, 255));
		gstno.setEditable(false);
		gstno.setForeground(new Color(128, 0, 0));
		gstno.setFont(new Font("Calibri", Font.BOLD, 12));
		gst_returnFile_data.getContentPane().add(gstno);
		gstno.setColumns(10);

		statecode = new JTextField();
		statecode.setBounds(871, 83, 27, 22);
		statecode.setBackground(new Color(0, 255, 255));
		statecode.setEditable(false);
		statecode.setForeground(new Color(128, 0, 0));
		statecode.setFont(new Font("Calibri", Font.BOLD, 12));
		gst_returnFile_data.getContentPane().add(statecode);
		statecode.setColumns(10);

		statename = new JTextField();
		statename.setBounds(899, 83, 253, 22);
		statename.setBackground(new Color(0, 255, 255));
		statename.setEditable(false);
		statename.setForeground(new Color(128, 0, 0));
		statename.setFont(new Font("Calibri", Font.BOLD, 12));
		gst_returnFile_data.getContentPane().add(statename);
		statename.setColumns(10);

		jsp1 = new JScrollPane();
		jsp1.setBounds(1, 536, 1350, 179);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		gst_returnFile_data.getContentPane().add(jsp1);

		JPanel panel = new JPanel();
		panel.setBounds(1, 0, 209, 111);
		panel.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(204, 255, 204)));
		panel.setBackground(new Color(102, 0, 102));
		gst_returnFile_data.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("From Date");
		lblNewLabel_1.setBounds(12, 42, 88, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(51, 0, 153));
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 14));

		JLabel lblNewLabel_3 = new JLabel("To Date");
		lblNewLabel_3.setBounds(22, 73, 56, 16);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(51, 0, 153));
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 14));

		todate = new JTextField();
		todate.setBounds(90, 70, 100, 22);
		panel.add(todate);
		todate.setColumns(10);

		fromdate = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		fromdate.setBounds(90, 39, 100, 22);
		panel.add(fromdate);
		fromdate.setColumns(10);

		btnNewButton_1 = new JButton(" ");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setIcon(new ImageIcon(GST_Filling_data.class.getResource("/RetailProduct/backgrnd4.jpg")));
		btnNewButton_1.setBounds(0, 0, 209, 111);
		// btnNewButton_1.setIcon(new
		// ImageIcon("D:\\AKN\\myProductImage\\backgrnd5.jpg"));
		panel.add(btnNewButton_1);

		btnExport = new JButton("Export To Excel");
		btnExport.setMnemonic('E');
		btnExport.setBounds(1223, 56, 128, 55);
		gst_returnFile_data.getContentPane().add(btnExport);

		JLabel lblNewLabel_4 = new JLabel("GST - Scheme");
		lblNewLabel_4.setBounds(507, 56, 83, 16);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 14));
		gst_returnFile_data.getContentPane().add(lblNewLabel_4);

		scheme = new JTextField();
		scheme.setBounds(595, 52, 203, 26);
		scheme.setBackground(Color.WHITE);
		scheme.setForeground(new Color(128, 0, 128));
		scheme.setEditable(false);
		gst_returnFile_data.getContentPane().add(scheme);
		scheme.setColumns(10);

		lblNewLabel_5 = new JLabel("Return File Schedule");
		lblNewLabel_5.setBounds(447, 80, 143, 16);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Century Schoolbook", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		gst_returnFile_data.getContentPane().add(lblNewLabel_5);

		schedule = new JTextField();
		schedule.setBounds(595, 80, 203, 22);
		schedule.setBackground(Color.WHITE);
		schedule.setEditable(false);
		schedule.setFont(new Font("Calibri", Font.BOLD, 14));
		gst_returnFile_data.getContentPane().add(schedule);
		schedule.setColumns(10);

		btnNewButton = new JButton(" ");
		btnNewButton.setBounds(203, 0, 1018, 111);
		gst_returnFile_data.getContentPane().add(btnNewButton);

		btnClose = new JButton("Close");
		btnClose.setIcon(new ImageIcon(GST_Filling_data.class.getResource("/RetailProduct/delete.png")));
		btnClose.setMnemonic('C');
		btnClose.setBounds(1223, 0, 128, 54);
		gst_returnFile_data.getContentPane().add(btnClose);
		ActionListener rbls = new rblsnr();
		rb3.addActionListener(rbls);
		rb4.addActionListener(rbls);
		rb1.addActionListener(rbls);
		rb2.addActionListener(rbls);
		rb5.addActionListener(rbls);
		rb7.addActionListener(rbls);
		rb8.addActionListener(rbls);
		rb9.addActionListener(rbls);
		rb10.addActionListener(rbls);
		rb11.addActionListener(rbls);

		 ActionListener btnls = new btnlsnr();
		//btngst1.addActionListener(btnls);
		//btngst2.addActionListener(btnls);

		ActionListener frmLsnr = new fromdateLsnr();
		ActionListener toLsnr = new todateLsnr();
		fromdate.addActionListener(frmLsnr);
		todate.addActionListener(toLsnr);

		decorate();
		btnExport.addActionListener(btnls);
		btnClose.addActionListener(btnls);
	}

	class fromdateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				fromdate.setText(new gnDate().getmefullDate(fromdate.getText()));
				// new selectdate().selectDate(fromdate );
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
			}
		}
	}

	class todateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				todate.setText(new gnDate().getmefullDate(todate.getText()));
				// new selectdate().selectDate(todate);
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
 				e1.printStackTrace();
			} finally {
			}
		}
	}

	private void decorate() throws Throwable {
		new General().setDate(fromdate);
		new General().setDate(todate);
		lpanel.setVisible(true);
 		fromdate.setText(new gnFinYear().getFirstDateofFinYear());
		todate.setText(new gnFinYear().getLastDateofFinYear());

		new gnApp().setFrameTitel(gst_returnFile_data);
		new gnField().closeform(lpanel, gst_returnFile_data);
		new gnField().closeform(rpanel, gst_returnFile_data);

		new gnBackground().setBackground(btnNewButton);
		new gnStyleButton().getStyleButton(btnClose, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnExport, new Color(156, 211, 112), Color.WHITE);

		new gnDecorate().DispField_Beval_int(gstno, 10);
		new gnDecorate().DispField_Beval_int(compname, 10);
		new gnDecorate().decorateField(compname);
		new gnDecorate().DispField_Beval_int(isgst, 10);
		new gnDecorate().DispField_Beval_int(gstno, 10);
		new gnDecorate().DispField_Beval_int(statecode, 10);
		new gnDecorate().DispField_Beval_int(statename, 10);
		compname.setText(new gnConfig().getCompany());
		isgst.setText(new gnGST().ismyComanyGSTRegister());
		gstno.setText(new gnGST().getComanyGSTno());
		statecode.setText(new gnGST().getmyState());
		statename.setText(new gnGST().getmystatename());
		finyear.setText(new gnFinYear().getReportingFinYear());
		scheme.setText(new gnGST().gst_getmytaxscheme());
		String vschmetype = new gnGST().gst_getmytaxschemecode();

		/*
		vschmetype = "1" ;
		switch (vschmetype) {
		case "0":
			btngst1.setEnabled(false);
			btngst2.setEnabled(false);
			btngst3.setEnabled(false);
			btngst4.setEnabled(false);
			btngst5.setEnabled(false);
			btngst6.setEnabled(false);
			btngst7.setEnabled(false);
			btngst8.setEnabled(false);
			btngst9.setEnabled(false);
			btngst10.setEnabled(false);
			rb3.setEnabled(false);
			rb4.setEnabled(false);
			rb1.setEnabled(false);
			rb2.setEnabled(false);
			schedule.setText("No Return File");
			break;

		case "1":
			btngst1.setVisible(false);
			btngst2.setVisible(true);
			btngst3.setVisible(false);
			btngst4.setVisible(true);
			btngst5.setVisible(false);
			btngst6.setVisible(false);
			btngst7.setVisible(false);
			btngst8.setVisible(false);
			btngst9.setVisible(false);
			btngst10.setVisible(false);

			schedule.setText("Quatarly  Return File");
			break;

		case "2":

			btngst1.setVisible(true);
			btngst2.setVisible(true);
			btngst3.setVisible(false);
			btngst4.setVisible(true);
			btngst5.setVisible(false);
			btngst6.setVisible(false);
			btngst7.setVisible(false);
			btngst8.setVisible(false);
			btngst9.setVisible(false);
			btngst10.setVisible(false);
			schedule.setText("Monthly  Return File");
			break;
 		}

		*/
	}

	class btnlsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (value == "GSTR1") {
				String vreport = "GSTR1";
				String SQL = "call Gst_getSectionData( '" + vreport + "')";
				String[] colreport = { "GST Report Type", "Section", "Section Name", "Description" };
				try {
					lpanel.setVisible(true);
					showReportSection(SQL, colreport);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (value == "GSTR 2") {
				String vreport = "GST 2";
				String SQL = "call Gst_getSectionData(" + vreport + ")";
				String[] colreport = { "GST Report Type", "Section", "Section Name", "Description" };
				try {
					showReportSection(SQL, colreport);
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Export To Excel") {
				exportData();
			}

			if (value == "Close") {
				gst_returnFile_data.dispose();
			}

		}
	}

	void showReportSection(String SQL, String[] colreport) throws Throwable {

		String vstatus = new gnFinYear().checkDateRanegforFinyear(fromdate.getText(), todate.getText());
		if (vstatus == "Sucess") {
			model1.setColumnIdentifiers(colreport);
			table1 = new gnTableModel().Tablemodel4(table1, model1, SQL, colreport, 4, "N", "N", "N");
 			table1.setModel(model1);
			new gnTable().setTableBasics(table1);
			JViewport prt1 = new JViewport();
			prt1.setBackground(Color.WHITE);
			prt1.add(table1, colreport);
			prt1.setVisible(true);
			jsp1.setViewport(prt1);
		}
	}

	class rblsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			boolean vrb1 = rb1.isSelected();
			boolean vrb2 = rb2.isSelected();
			boolean vrb3 = rb3.isSelected();
			boolean vrb4 = rb4.isSelected();
			boolean vrb5 = rb5.isSelected();
			// boolean vrb6 = rb6.isSelected();
			boolean vrb7 = rb7.isSelected();
			boolean vrb8 = rb8.isSelected();
			boolean vrb9 = rb9.isSelected();
			boolean vrb10 = rb10.isSelected();
			boolean vrb11 = rb11.isSelected();

			if (vrb1) {
				choice = "1";
			}

			if (vrb2) {
				choice = "2";
			}

			if (vrb3) {
				choice = "3";
			}

			if (vrb4) {
				choice = "4";
			}

			if (vrb5) {
				choice = "5";
			}

			if (vrb7) {
				choice = "7";
			}

			if (vrb8) {
				choice = "8";
			}

			if (vrb9) {
				choice = "9";
			}

			if (vrb10) {
				choice = "10";
			}

			try {
				callAction();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	void callAction() throws Throwable {

		showTableData();

	}

	private void showTableData() throws Throwable {
		String vstatus = new gnFinYear().checkDateRanegforFinyear(fromdate.getText(), todate.getText());
		if (vstatus == "Sucess") {
			String vrepsection;
			String vtype;
			String col[] = { "Type", "TableNO", "Title", "Recipient GSTIN No", "Inv.No", "Inv.Date", "Inv.Amt",
					"Place of Supply", "Reverse Chrg", "Inv.Type", "ECom GSTIN", "TaxRate", "Taxable Value", "Cess",
					"IGST", "CGST", "SGST" };

			String colforchoice4[] = { "Type", "TableNO", "Title", "GSTIN-Recipient", "Inv/Adv Recpt.No",
					"Inv/Adv Doc.Date", "Note/Refund Vou.No", "Note/Refund Vou Date", "Doc.Type", "Reason",
					"Place of supply", "Doc Value", "Rate", "Taxable Value", "Cess", "Pre GST" };

			String colforchoice5[] = { "Type", "TableNO", "Title", "UR Type", "Note Refund Voucher No",
					"Note/Refund.Date", "Doc.Type", "Inv/Adv.Recpt.No", "Inv/Adv.Rcpt Date", "Reason",
					"Place of supply", "Doc Value", "Rate", "Taxable Value", "Cess", "Pre GST" };

			String colchoice7[] = { "Type", "TableNo", "Title", "Export Type", "Inv.No", "InvDate", "Inv Value",
					"PortCode", "Shipping.Bill.No", "Ship.BillDate", "Tax Rate", "Taxable Value", "IGST" };

			String colchoice8[] = { "Type", "Table", "Title", "PlaceofSupply", "Taxrate", "Docvalue", "Cess" };

			String colchoice10[] = { "Type", "Table", "Title", "Nil Rated", "Expm", "Non GST" };

			model.setColumnIdentifiers(col);
			String vfrom = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
			String vto = new gnConfig().date_ConverttoDBforamt(todate.getText());
			vcomp = new gnConfig().getCompanyCode();
			switch (choice) {
			case "1":
				vrepsection = choice;
				new gnTable().RemoveTableRows(model);
				vtype = "B2B";
				SQL = "call GST_Data_GSTR1(" + vcomp + " ,'" + vfrom + "', '" + vto + "' ,'" + vrepsection + "')";
				table = new gnTableModel().Tablemodel16(table, model, SQL, col, 16, "N", "Y", vtype);
				break;

			case "2":
				vrepsection = choice;
				new gnTable().RemoveTableRows(model);
				vtype = "B2CL";
				SQL = "call GST_Data_GSTR1(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				table = new gnTableModel().Tablemodel16(table, model, SQL, col, 16, "N", "Y", vtype);
				break;

			case "3":
				vrepsection = choice;
				new gnTable().RemoveTableRows(model);
				vtype = "B2CS";
				SQL = "call GST_Data_GSTR1(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				table = new gnTableModel().Tablemodel16(table, model, SQL, col, 16, "N", "Y", vtype);
				break;

			case "4":
				new gnTable().RemoveTableRows(model);
				vrepsection = choice;
				vtype = "CDNR";
				SQL = "call GST_Data_GSTR1(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				table = new gnTableModel().Tablemodel15(table, model, SQL, colforchoice4, 15, "N", "Y", vtype);
				break;

			case "5":
				new gnTable().RemoveTableRows(model);
				vrepsection = choice;
				vtype = "CDNUR";
				SQL = "call GST_Data_GSTR1(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				table = new gnTableModel().Tablemodel15(table, model, SQL, colforchoice5, 15, "N", "Y", vtype);
				break;

			case "7":
				new gnTable().RemoveTableRows(model);
				vrepsection = choice;
				vtype = "export/SEZ";
				SQL = "call GST_Data_GSTR1(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				table = new gnTableModel().Tablemodel12(table, model, SQL, colchoice7, 12, "N", "Y", vtype);
				break;

			case "8":
				new gnTable().RemoveTableRows(model);
				vrepsection = choice;
				vtype = "Cust.Advance";
				SQL = "call GST_Data_GSTR1(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				table = new gnTableModel().Tablemodel6(table, model, SQL, colchoice8, 6, "N", "Y", vtype);
				break;

			case "9":
				new gnTable().RemoveTableRows(model);
				vrepsection = choice;
				vtype = "Cust.Adv.Adjustment";
				SQL = "call GST_Data_GSTR1(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				table = new gnTableModel().Tablemodel6(table, model, SQL, colchoice8, 6, "N", "Y", vtype);
				break;

			case "10":
				new gnTable().RemoveTableRows(model);
				vrepsection = choice;
				vtype = "Zero Rated";
				SQL = "call GST_Data_GSTR1(" + vcomp + " ,'" + vfrom + "', '" + vto + "' , '" + vrepsection + "')";
				table = new gnTableModel().Tablemodel5(table, model, SQL, colchoice10, 5, "N", "Y", vtype);
				break;
			}
			table.setModel(model);
			new gnTable().setTableBasics(table);
			JViewport prt = new JViewport();
			prt.setBackground(Color.WHITE);
			prt.add(table, col);
			prt.setVisible(true);
			jsp.setViewport(prt);
		}
	}

	private void exportData() {
		new Export_Table_Data_to_Excel().exportTable(table);
	}
}// Last

package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Reports_Purchase {

	JFrame purchsereportframe;
	private JTextField storecode;
	private JTextField storename;
	private JTextField fromdate;
	private JTextField todate;
	private JTextField code;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnPrint;
	private JButton btnGenerate;
	private JRadioButton rbpur4;
	private JRadioButton rbpur3;
	private JRadioButton rbpur2;
	private JRadioButton rngrprint;
	private JRadioButton rbpurchase1;
	private String vcomp;
	private String vstore;
	private JPanel panel_3;
	private String doctype;
	private String docno;
	private String rbchoice;
	private String SQL;
	private String vfromdate;
	private String vtodate;
	private String vcode;
	private String vdocdate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reports_Purchase window = new Reports_Purchase();
					window.purchsereportframe.setVisible(true);
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
	public Reports_Purchase() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		purchsereportframe = new JFrame();
		purchsereportframe.setAlwaysOnTop(true);
		purchsereportframe.setBounds(250, 100, 695, 349);
		purchsereportframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		purchsereportframe.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Purchase Report");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(172, 0, 158, 16);
		purchsereportframe.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 28, 665, 283);
		purchsereportframe.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Branch");
		lblNewLabel_1.setBounds(23, 17, 56, 16);
		panel.add(lblNewLabel_1);

		storecode = new JTextField();
		storecode.setBounds(67, 14, 116, 30);
		storecode.setEditable(false);
		storecode.setBackground(new Color(0, 255, 255));
		panel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setBounds(180, 14, 268, 30);
		storename.setEditable(false);
		storename.setBackground(new Color(0, 255, 255));
		panel.add(storename);
		storename.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 255, 255));
		panel_1.setBounds(437, 48, 222, 229);
		panel_1.setBorder(new TitledBorder(null, "Select Report Type", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 51, 153)));
		panel.add(panel_1);
		panel_1.setLayout(null);

		ActionListener rb = new rbLsnr();
		ActionListener rb1 = new rb1Lsnr();
		ActionListener lscode = new codeLsnr();

		rngrprint = new JRadioButton("GR Print");
		rngrprint.addActionListener(rb1);
		rngrprint.setFont(new Font("SansSerif", Font.BOLD, 13));
		buttonGroup.add(rngrprint);
		rngrprint.setBounds(16, 28, 127, 25);
		panel_1.add(rngrprint);

		rbpurchase1 = new JRadioButton("Date wise Purchase Summary");
		rbpurchase1.addActionListener(rb);
		buttonGroup.add(rbpurchase1);
		rbpurchase1.setBounds(16, 54, 189, 25);
		panel_1.add(rbpurchase1);

		rbpur2 = new JRadioButton("Supplier Wise Purchase");
		rbpur2.addActionListener(rb);
		buttonGroup.add(rbpur2);
		rbpur2.setBounds(16, 79, 189, 25);
		panel_1.add(rbpur2);

		rbpur3 = new JRadioButton("Brand Wise Purchase");
		rbpur3.addActionListener(rb);
		buttonGroup.add(rbpur3);
		rbpur3.setBounds(16, 105, 160, 25);
		panel_1.add(rbpur3);

		rbpur4 = new JRadioButton("Article Purchase");
		rbpur4.addActionListener(rb);
		buttonGroup.add(rbpur4);
		rbpur4.setBounds(16, 131, 127, 25);
		panel_1.add(rbpur4);

		ActionListener btn = new BtnLsnr();

		btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(btn);
		btnGenerate.setBounds(136, 240, 97, 25);
		panel.add(btnGenerate);

		btnPrint = new JButton("Print");
		btnPrint.addActionListener(btn);
		btnPrint.setBounds(234, 240, 97, 25);
		panel.add(btnPrint);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_2.setBounds(33, 132, 392, 55);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Select ");
		lblNewLabel_4.setBounds(26, 13, 44, 16);
		panel_2.add(lblNewLabel_4);

		code = new JTextField();
		code.setBounds(70, 6, 116, 30);
		code.addActionListener(lscode);
		panel_2.add(code);
		code.setColumns(10);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Enter Dates For Report Generation", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_3.setBounds(23, 45, 402, 75);
		panel.add(panel_3);
		panel_3.setLayout(null);

		fromdate = new JTextField();
		fromdate.setBounds(48, 24, 116, 30);
		panel_3.add(fromdate);
		fromdate.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("From ");
		lblNewLabel_2.setBounds(17, 31, 32, 16);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("TO");
		lblNewLabel_3.setBounds(176, 31, 23, 16);
		panel_3.add(lblNewLabel_3);

		todate = new JTextField();
		todate.setBounds(200, 24, 116, 30);
		panel_3.add(todate);
		todate.setColumns(10);

		ActionListener dt1 = new fromdateLsnr();
		ActionListener dt2 = new todateLsnr();
		fromdate.addActionListener(dt1);
		todate.addActionListener(dt2);

		decorate();
	}

	class fromdateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				new selectdate().selectDate(fromdate);
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
				new selectdate().selectDate(todate);
			} catch (Exception e1) {
				new General().msg(e1.getMessage());
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
			}
		}
	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(purchsereportframe);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		storecode.setText(vstore);
		storename.setText(new gnConfig().getStorename(vstore));
		new gnDecorate().DispField_Eatch(code, 10);
		new gnDecorate().DispField_Eatch(fromdate, 10);
		new gnDecorate().DispField_Eatch(todate, 10);
		fromdate.setText(new General().getDate());
		todate.setText(new General().getDate());

	}

	private String checkCodeEntry() {
		vcode = code.getText();
		String vstatus = "Sucess";
		switch (rbchoice) {
		case "1":
			if (vcode.length() == 0) {
				new General().msg("Select GRN No ");
				vstatus = "Fail";
			}
			break;
		case "2":
			code.setText("0");
			break;
		case "3":
			if (vcode.length() == 0) {
				new General().msg("Select Suplier ");
				vstatus = "Fail";
			}
			break;
		case "4":
			code.setText("0");
			break;
		case "5":
			code.setText("0");
			break;

		}
		return vstatus;
	}

	class BtnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (value == "Generate") {
				String vstatus = checkCodeEntry();
				if (vstatus == "Sucess") {
					try {
						vfromdate = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
						vtodate = new gnConfig().date_ConverttoDBforamt(todate.getText());
					} catch (ClassNotFoundException e2) {
						e2.printStackTrace();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					vcode = code.getText();
					switch (rbchoice) {
					case "1":
						printgrn();
						break;
					case "2":
						try {
							new gnPurchaseReport().callPurchaseReport(rbchoice, vfromdate, vtodate, vcode);
						} catch (Throwable e1) {
							e1.printStackTrace();
						}
						break;
					case "3":
						try {
							new gnPurchaseReport().callPurchaseReport(rbchoice, vfromdate, vtodate, vcode);
						} catch (Throwable e1) {
							e1.printStackTrace();
						}
						break;
					case "4":
						try {
							new gnPurchaseReport().callPurchaseReport(rbchoice, vfromdate, vtodate, vcode);
						} catch (Throwable e1) {
							e1.printStackTrace();
						}
						break;
					case "5":
						try {
							new gnPurchaseReport().callPurchaseReport(rbchoice, vfromdate, vtodate, vcode);
						} catch (Throwable e1) {
							e1.printStackTrace();
						}

						break;
					}
				}
			}
		}
	}

	private void printgrn() {
		String vdoctype = "GRN";
		String vdocno = code.getText();
		try {
			new gnDocPrint().callprint(vdoctype, vdocno, vdocdate);
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
	}

	class codeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			switch (rbchoice) {
			case "1":
				String type = "GR";
				try {
					new gnGrn().get_Grno(type);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					code.setText(new gnGrn().rgrnno);
					vdocdate = new gnGrn().rgrndate;
				}
				break;
			case "3":
				String vname = code.getText();
				vname = "%" + vname + "%";
				try {
					new gnSupplier().getSupplier(vname);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					code.setText(new gnSupplier().rvendorcode);
				}
				break;
			}

		}
	}

	class rb1Lsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			ActionnonDates(value);
		}
	}

	private void ActionnonDates(String value) {
		if (value == "GR Print") {
			rbchoice = "1";

		}
	}

	class rbLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			Action(value);
		}
	}

	private void Action(String value) {
		String status = validate();
		code.setText(null);
		if (status == "Sucess") {
			if (value == ("Date wise Purchase Summary")) {
				rbchoice = "2";
			}
			if (value == "Supplier Wise Purchase") {
				rbchoice = "3";

			}
			if (value == "Brand Wise Purchase") {
				rbchoice = "4";

			}
			if (value == "Article Purchase") {
				rbchoice = "5";

			}
		}
	}

	private String validate() {
		String vstatus = "Sucess";
		String vfrom = fromdate.getText();
		String vtodate = todate.getText();
		if (vfrom.length() == 0 || vtodate.length() == 0) {
			vstatus = "Fail";
			new General().msg("Enter Dates For Report Generation ..");
		}
		return vstatus;
	}

}// last

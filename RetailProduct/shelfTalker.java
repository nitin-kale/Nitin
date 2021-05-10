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
import javax.swing.border.TitledBorder;

public class shelfTalker extends getResultSet {

	JFrame shelftlkFrame;
	private JTextField code;
	private JTextField name;
	private JTextField searchcode;
	private JTextField searchname;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rbsubgroup;
	private JRadioButton rbbrand;
	private JButton btnGenerate;
	private JButton btnPrint;
	private String vcomp;
	private String vstore;

	private JRadioButton rbArticle;
	private String choice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shelfTalker window = new shelfTalker();
					window.shelftlkFrame.setVisible(true);
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
	public shelfTalker() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		shelftlkFrame = new JFrame();
		shelftlkFrame.setAlwaysOnTop(true);
		shelftlkFrame.setBounds(450, 250, 450, 231);
		shelftlkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		shelftlkFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Shelf Talker Printing");
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(121, 5, 193, 16);
		shelftlkFrame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Shelf Talker - Information ", TitledBorder.CENTER, TitledBorder.TOP,
				null, new Color(0, 51, 153)));
		panel.setBounds(0, 34, 432, 146);
		shelftlkFrame.getContentPane().add(panel);
		panel.setLayout(null);

		code = new JTextField();
		code.setBounds(84, 47, 89, 28);
		panel.add(code);
		code.setColumns(10);

		name = new JTextField();
		name.setBounds(172, 47, 254, 28);
		ActionListener nm = new lsnritemName();
		name.addActionListener(nm);
		panel.add(name);
		name.setColumns(10);

		searchcode = new JTextField();
		searchcode.setEditable(false);
		searchcode.setBounds(84, 74, 89, 28);
		ActionListener srchnm = new searchnameLsnr();
		searchcode.addActionListener(srchnm);
		panel.add(searchcode);
		searchcode.setColumns(10);

		searchname = new JTextField();
		searchname.setBounds(172, 74, 254, 30);
		searchname.addActionListener(srchnm);
		panel.add(searchname);
		searchname.setColumns(10);

		btnGenerate = new JButton("Generate Talkers");
		btnGenerate.setMnemonic('G');
		btnGenerate.setBounds(179, 111, 141, 25);
		ActionListener btn1 = new btnLsnr();
		btnGenerate.addActionListener(btn1);
		panel.add(btnGenerate);

		rbbrand = new JRadioButton("For Brand");
		rbbrand.setForeground(new Color(0, 0, 102));
		rbbrand.setFont(new Font("Calibri", Font.BOLD, 12));
		buttonGroup.add(rbbrand);
		ActionListener rb = new btnRBLsnr();
		rbbrand.addActionListener(rb);
		rbbrand.setBounds(115, 17, 115, 18);
		panel.add(rbbrand);

		btnPrint = new JButton("Print");
		btnPrint.setMnemonic('P');
		btnPrint.setBounds(319, 109, 90, 28);
		btnPrint.addActionListener(btn1);
		panel.add(btnPrint);

		rbArticle = new JRadioButton("For Article");
		rbArticle.setForeground(new Color(0, 0, 102));
		rbArticle.setFont(new Font("Calibri", Font.BOLD, 12));
		buttonGroup.add(rbArticle);
		rbArticle.addActionListener(rb);
		rbArticle.setBounds(12, 18, 115, 18);
		panel.add(rbArticle);

		JLabel lblNewLabel_1 = new JLabel("Article");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setBounds(44, 53, 55, 16);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Brand");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setBounds(44, 80, 55, 16);
		panel.add(lblNewLabel_2);
		decorate();
	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(shelftlkFrame);
		code.setEnabled(false);
		name.setEnabled(false);
		searchcode.setEnabled(false);
		searchname.setEnabled(false);
		new gnDecorate().decorateField(code);
		new gnDecorate().decorateField(searchcode);
		new gnDecorate().decorateField(name);
		new gnDecorate().decorateField(searchname);

	}

	class lsnritemName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String sname = name.getText().trim();
			sname = "%" + sname + "%";
			try {
				String vtype = "Article";
				String varticle1 = "";
				String vtrantype1 = "ALL";
				new gnAdmin().Search(vtype, sname, varticle1, vtrantype1);
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				try {
					code.setText(new gnAdmin().rArticle);
					name.setText(new gnAdmin().rArticlename);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class btnRBLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			boolean vbrand = rbbrand.isSelected();
			if (vbrand) {
				choice = "Brand";
				code.setText(" ");
				name.setText(" ");
				code.setEnabled(false);
				name.setEnabled(false);
				code.setBackground(Color.cyan);
				name.setBackground(Color.cyan);
				searchcode.setText(" ");
				searchname.setText(" ");
				searchcode.setEnabled(true);
				searchname.setEnabled(true);
				searchcode.setBackground(Color.white);
				searchname.setBackground(Color.white);
			} else {
				choice = "Article";
				code.setText(" ");
				name.setText(" ");
				code.setEnabled(true);
				name.setEnabled(true);
				code.setBackground(Color.WHITE);
				name.setBackground(Color.white);
				searchcode.setBackground(Color.cyan);
				searchname.setBackground(Color.cyan);
				searchcode.setEnabled(false);
				searchname.setEnabled(false);
			}
		}
	}

	class searchnameLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String vname = searchname.getText();
			vname = "%" + vname + "%";
			switch (choice) {
			case "Brand":
				try {

					// new gnBrand().getBrandInfo(vname);
					new gnAdmin().showMasterTable(choice, searchcode, searchname);

				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					// searchcode.setText(new gnBrand().rbrandcode);
					// searchname.setText(new gnBrand().rName);
				}
				break;
			}
		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String SQL = " ";
			String vtype = " ";
			String vcode = " ";

			if (value == "Generate Talkers") {
				try {
					vcomp = new gnConfig().getCompanyCode();
				} catch (Throwable e2) {
					e2.printStackTrace();
				}
				// new General().msg("chioce is "+ choice);

				switch (choice) {
				case "Brand":
					vcode = searchcode.getText();
					vtype = "Brand";
					SQL = "call  shelfTalker_print(" + vcomp + " ,  '" + vcode + "'  , '" + vtype + "')";
					break;
				case "Article":
					vcode = code.getText();
					vtype = "Article";
					SQL = "call  shelfTalker_print(" + vcomp + " ,  " + vcode + "  , '" + vtype + "')";
					break;
				}
				try {
					// new General().msg(SQL);
					getResultSet t = new getResultSet();
					t.getResult(SQL);
					btnPrint.doClick();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			//// Option Print Talkers is here
			if (value == "Print") {
				try {
					String vreport = "shtalk1.jasper";
					gnPrintMasters rp = new gnPrintMasters();
					rp.print(vreport);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				return;
			}

		}
	}
}// Last

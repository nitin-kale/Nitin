package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;

public class viewExpIncome {

	JFrame incoFrame;
	JPanel panel;
	private JTextField from;
	private JTextField to;
	JLabel branchNameLbl;
	private JTextField total;
	JButton btnView;
	JButton btnExport;
	JButton btnClose;
	JScrollPane jsp;
	private JRadioButton rb2;
	private JRadioButton rb1;
	private JRadioButton rb6;
	private JRadioButton rb3;
	private JRadioButton rb4;
	private JRadioButton rb5;
	private JRadioButton rb7;

	private String choice;
	private String vcomp;
	private String vstore;
	private String vtrType = "";
	private String vdoctype = "";

	private final ButtonGroup buttonGroup = new ButtonGroup();
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	private JPanel panel_1;
	private JLabel lblNewLabel_4;
	private JTextField finyear;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewExpIncome window = new viewExpIncome();
					window.incoFrame.setVisible(true);
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
	public viewExpIncome() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		incoFrame = new JFrame();
		incoFrame.setResizable(false);
		// incoFrame.setBounds(250, 100, 810, 511);
		incoFrame.setBounds(5, 215, 1350, 509);
		incoFrame.setBounds(1, 90, 1350, 605);

		incoFrame.getContentPane().setBackground(Color.WHITE);
		incoFrame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new CompoundBorder(null, new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0),
				new Color(255, 255, 0), new Color(0, 0, 255), null)));
		panel.setBounds(0, 0, 1338, 195);
		incoFrame.getContentPane().add(panel);
		panel.setLayout(null);

		btnView = new JButton("View");
		btnView.setFont(new Font("Cambria", Font.BOLD, 13));
		btnView.setMnemonic('V');
		btnView.setBounds(493, 162, 97, 33);
		panel.add(btnView);

		btnExport = new JButton("Export");
		btnExport.setFont(new Font("Cambria", Font.BOLD, 13));
		btnExport.setMnemonic('E');
		btnExport.setBounds(595, 162, 97, 33);
		panel.add(btnExport);

		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Cambria", Font.BOLD, 13));
		btnClose.setMnemonic('C');
		btnClose.setBounds(882, 10, 148, 52);
		panel.add(btnClose);

		panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 3, (Color) new Color(0, 51, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 184, 195);
		panel.add(panel_1);
		panel_1.setLayout(null);

		rb1 = new JRadioButton("Expenses");
		rb1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		rb1.setMnemonic('X');
		rb1.setBounds(23, 3, 153, 22);
		panel_1.add(rb1);
		rb1.setSelected(true);
		buttonGroup.add(rb1);
		rb1.setBackground(Color.WHITE);

		rb2 = new JRadioButton("Income");
		rb2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		rb2.setMnemonic('I');
		rb2.setBounds(23, 27, 153, 22);
		panel_1.add(rb2);
		buttonGroup.add(rb2);
		rb2.setBackground(Color.WHITE);
		rb2.setSelected(true);

		rb3 = new JRadioButton("Payments");
		rb3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		rb3.setMnemonic('P');
		rb3.setBounds(23, 53, 153, 22);
		panel_1.add(rb3);
		buttonGroup.add(rb3);
		rb3.setBackground(Color.WHITE);

		rb4 = new JRadioButton("Receipts");
		rb4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		rb4.setMnemonic('R');
		rb4.setBounds(23, 80, 153, 22);
		panel_1.add(rb4);
		buttonGroup.add(rb4);
		rb4.setBackground(Color.WHITE);

		rb5 = new JRadioButton("Contra");
		rb5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		rb5.setMnemonic('N');
		rb5.setBounds(23, 107, 153, 22);
		panel_1.add(rb5);
		buttonGroup.add(rb5);
		rb5.setBackground(Color.WHITE);

		rb6 = new JRadioButton("Supplier Advance");
		buttonGroup.add(rb6);
		rb6.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		rb6.setBackground(Color.WHITE);
		rb6.setMnemonic('S');
		rb6.setBounds(23, 134, 153, 22);
		panel_1.add(rb6);

		rb7 = new JRadioButton("Member Advance");
		buttonGroup.add(rb7);
		rb7.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		rb7.setMnemonic('U');
		rb7.setBounds(23, 161, 153, 25);
		panel_1.add(rb7);

		JLabel lblNewLabel_6 = new JLabel(" ");
		lblNewLabel_6.setBounds(0, 3, -2, 192);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_6.setIcon(new ImageIcon(viewExpIncome.class.getResource("/RetailProduct/Ph2.png")));

		JLabel lblNewLabel_5 = new JLabel("Financial Year");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(688, 1, 104, 25);
		panel.add(lblNewLabel_5);

		finyear = new JTextField();
		finyear.setHorizontalAlignment(SwingConstants.CENTER);
		finyear.setForeground(Color.WHITE);
		finyear.setBackground(new Color(0, 0, 51));
		finyear.setFont(new Font("Arial", Font.BOLD, 18));
		finyear.setBounds(698, 29, 82, 33);
		panel.add(finyear);
		finyear.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(new MatteBorder(3, 1, 1, 1, (Color) new Color(102, 204, 102)), "Enter Date",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(64, 64, 64)));
		panel_2.setBounds(196, 56, 1118, 96);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setBounds(72, 23, 97, 21);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

		to = new JTextField();
		to.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		to.setBounds(192, 44, 116, 30);
		panel_2.add(to);
		to.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setBounds(192, 25, 77, 16);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial Narrow", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);

		from = new JTextField();
		from.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		from.setBounds(72, 44, 116, 30);
		panel_2.add(from);
		from.setColumns(10);

		branchNameLbl = new JLabel("branchname");
		branchNameLbl.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		branchNameLbl.setForeground(new Color(0, 51, 102));
		branchNameLbl.setBounds(196, 29, 316, 30);
		panel.add(branchNameLbl);

		lblNewLabel_7 = new JLabel("Branch");
		lblNewLabel_7.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		lblNewLabel_7.setBounds(196, 0, 295, 30);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_3 = new JLabel("View & Edit Data");
		lblNewLabel_3.setBounds(206, 167, 203, 16);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(0, 0, 51));
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 194, 1338, 359);
		incoFrame.getContentPane().add(jsp);

		JLabel lblNewLabel_2 = new JLabel("Total");
		lblNewLabel_2.setFont(new Font("Agency FB", Font.BOLD, 21));
		lblNewLabel_2.setBounds(1107, 566, 47, 16);
		incoFrame.getContentPane().add(lblNewLabel_2);

		total = new JTextField();
		total.setFont(new Font("Arial", Font.BOLD, 18));
		total.setBounds(1161, 558, 143, 34);
		incoFrame.getContentPane().add(total);
		total.setColumns(10);

		lblNewLabel_4 = new JLabel("sign");
		lblNewLabel_4.setIcon(new ImageIcon(viewExpIncome.class.getResource("/RetailProduct/rs.gif")));
		lblNewLabel_4.setBounds(1306, 569, 16, 16);
		incoFrame.getContentPane().add(lblNewLabel_4);
		incoFrame.setAlwaysOnTop(true);
		incoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ActionListener btn = new btnLsnr();
		btnView.addActionListener(btn);
		btnExport.addActionListener(btn);
		btnClose.addActionListener(btn);
		ActionListener rbBtb = new rbBtnLsnr();
		rb1.addActionListener(rbBtb);
		rb2.addActionListener(rbBtb);
		rb3.addActionListener(rbBtb);
		rb4.addActionListener(rbBtb);
		rb5.addActionListener(rbBtb);
		rb6.addActionListener(rbBtb);
		rb7.addActionListener(rbBtb);

		decorate();
	}

	void decorate() throws Throwable {

		rb7.setVisible(false);
		rb6.setVisible(false);
		incoFrame.setUndecorated(true);
		new gnApp().setFrameTitel(incoFrame);
		new gnField().closeform(panel, incoFrame);
		new gnStyleButton().getStyleButton(btnClose, Color.blue, Color.WHITE);
		new gnStyleButton().getStyleButton(btnView, Color.blue, Color.WHITE);
		new gnStyleButton().getStyleButton(btnExport, Color.blue, Color.WHITE);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStorecode();
		branchNameLbl.setText(new gnConfig().getStoreName());
		from.setText(new gnFinYear().getFirstDateofFinYear());
		to.setText(new gnFinYear().getLastDateofFinYear());
		finyear.setText(new gnFinYear().getReportingFinYear());

		String vchoice = new ApplicationMenu().MenuSelection;
		switch (vchoice) {
		case "IE":
			rb1.setVisible(true);
			rb2.setVisible(true);
			rb3.setVisible(true);
			rb4.setVisible(true);
			rb5.setVisible(true);
			rb6.setVisible(true);
			rb7.setVisible(true);
			break;
		case "PRC":
			rb1.setVisible(true);
			rb2.setVisible(true);
			rb3.setVisible(true);
			rb4.setVisible(true);
			rb5.setVisible(true);
			rb6.setVisible(true);
			rb7.setVisible(true);
			break;

		}
	}

	class rbBtnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (value == "View") {
				try {
					processViewAction();
				} catch (ClassNotFoundException | SQLException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}

			if (value == "Export") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

			if (value == "Close") {
				incoFrame.dispose();
			}

		}
	}

	void processViewAction() throws Throwable {

		boolean vch1 = rb1.isSelected();
		boolean vch2 = rb2.isSelected();
		boolean vch3 = rb3.isSelected();
		boolean vch4 = rb4.isSelected();
		boolean vch5 = rb5.isSelected();
		boolean vch6 = rb6.isSelected();
		boolean vch7 = rb7.isSelected();

		if (vch1) {

			choice = "E";
			vtrType = "EX";
			vdoctype = "Edit Expense";
		}

		if (vch2) {
			choice = "I";
			vtrType = "IN";
			vdoctype = "Edit Income";
		}

		if (vch3) {
			choice = "P";
			vtrType = "PV";
		}

		if (vch4) {
			choice = "P";
			vtrType = "RV";
		}

		if (vch5) {
			choice = "P";
			vtrType = "CO";
		}

		if (vch6) {
			choice = "SAD";
			vtrType = "SAD";
		}

		if (vch7) {
			choice = "CAD";
			vtrType = "CAD";
		}

		String vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
		String vto = new gnConfig().date_ConverttoDBforamt(to.getText());
		String SQL = "call N_viewExpInc(" + vcomp + " , " + vstore + " , '" + vfrom + "' , '" + vto + "' , '" + vtrType
				+ "')";
		showTableData(SQL, vtrType);

	}

	private void showTableData(String SQL, String vtrType) throws Throwable {
		new gnTable().RemoveTableRows(model);
		String vstatus = new gnFinYear().checkDateRanegforFinyear(from.getText(), to.getText());
		if (vstatus == "Sucess") {
			String col[] = { "Type", "Doc,No", "Doc.Date", "Glcode", "Name", "Amount", "DrCr Type" };
			model.setColumnIdentifiers(col);
			table.setModel(model);
			table = new gnTableModel().Tablemodel(table, model, SQL, col, 6, "N", "Y", vtrType);
			JViewport prt = new JViewport();
			prt.setBackground(Color.CYAN);
			prt.add(table, col);
			prt.setVisible(true);
			prt.setBackground(Color.WHITE);
			jsp.setViewport(prt);
			new gnTable().setFont(table, 15);
			new gnTable().setTableBasics(table);
			double vtotal = new gnTable().getTotal(table, 5);
			total.setText(Double.toString(vtotal));
			selectRow();
		}
	}

	public void selectRow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			String vdocdate;
			String vdocno;

			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				vdocno = (String) table.getValueAt(row, 1);
				vdocdate = table.getValueAt(row, 2).toString();
				try {

					if (vtrType == "CO") {
						vtrType = "CON";
						new gnAccountbase().showAccouuntEntry(vtrType, vdocno, vdocdate);
						new gnEdit().showExpIncome(vdocno, vdocdate, vtrType);
					} else {
						new gnAccountbase().showAccouuntEntry(vtrType, vdocno, vdocdate);
						new gnEdit().showExpIncome(vdocno, vdocdate, vtrType);
					}

				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}
}

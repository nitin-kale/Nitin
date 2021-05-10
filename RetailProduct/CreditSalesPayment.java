package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class CreditSalesPayment {

	private JFrame customerpaymentFrame;
	private JPanel panel;
	private JLabel lblNewLabel_3;
	private JTextField invamt;

	JComboBox currency;

	public DefaultTableModel model = new DefaultTableModel();
	// public String paycol[] = {"Romove", "Mode", "Amount", "Card" } ;
	public JScrollPane jsp = new JScrollPane();
	public static JTable table;
	private JTextField payamount;
	private JLabel lblNewLabel_2;
	private JTextField dueamt;
	private String vdueamt;
	JRadioButton rb;
	private String vpayamt;
	private String vinvamt;
	public static String status;
	public static Double vduepayment;
	private JButton btnAdd;
	JButton BtnCur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreditSalesPayment window = new CreditSalesPayment();
					window.customerpaymentFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreditSalesPayment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		customerpaymentFrame = new JFrame();
		customerpaymentFrame.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		customerpaymentFrame.setType(Type.UTILITY);
		customerpaymentFrame.setResizable(false);
		customerpaymentFrame.setAlwaysOnTop(true);
		customerpaymentFrame.setBounds(250, 250, 800, 350);
		customerpaymentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		customerpaymentFrame.getContentPane().setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setBounds(0, 0, 800, 322);
		customerpaymentFrame.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 28, 776, 257);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);

		lblNewLabel_3 = new JLabel("Bill Amount");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_3.setBounds(6, 9, 90, 27);
		panel.add(lblNewLabel_3);

		invamt = new JTextField();
		invamt.setFont(new Font("SansSerif", Font.BOLD, 15));
		invamt.setEditable(false);
		invamt.setForeground(new Color(153, 255, 204));
		invamt.setBackground(new Color(0, 0, 102));
		invamt.setBounds(98, 2, 105, 38);
		panel.add(invamt);
		invamt.setColumns(10);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(6, 48, 650, 199);

		panel.add(jsp);

		JLabel lblNewLabel_1 = new JLabel("Payment");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(196, 11, 66, 22);
		panel.add(lblNewLabel_1);

		payamount = new JTextField();
		payamount.setFont(new Font("SansSerif", Font.BOLD, 15));
		payamount.setEditable(false);
		payamount.setBackground(new Color(0, 0, 102));
		payamount.setForeground(new Color(153, 255, 255));
		payamount.setBounds(265, 3, 122, 38);
		panel.add(payamount);
		payamount.setColumns(10);

		lblNewLabel_2 = new JLabel("Due Amt.");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_2.setBounds(387, 14, 55, 16);
		panel.add(lblNewLabel_2);

		dueamt = new JTextField();
		dueamt.setFont(new Font("SansSerif", Font.BOLD, 15));
		dueamt.setEditable(false);
		dueamt.setForeground(new Color(204, 255, 153));
		dueamt.setBackground(new Color(0, 0, 102));
		dueamt.setBounds(436, 3, 134, 38);
		panel.add(dueamt);
		dueamt.setColumns(10);

		JButton btnOk = new JButton("Ok");
		btnOk.setMnemonic('O');
		ActionListener btn = new btnok();
		btnOk.addActionListener(btn);
		btnOk.setBounds(668, 173, 90, 28);
		panel.add(btnOk);

		btnAdd = new JButton("Add Row");
		btnAdd.setMnemonic('A');
		btnAdd.addActionListener(btn);

		btnAdd.setBounds(668, 149, 90, 28);
		panel.add(btnAdd);

		CurrencyPanel = new JPanel();
		CurrencyPanel.setBorder(new TitledBorder(null, "Select Currency ", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(128, 0, 128)));
		CurrencyPanel.setBounds(6, 48, 752, 69);
		panel.add(CurrencyPanel);
		CurrencyPanel.setLayout(null);
		CurrencyPanel.setVisible(false);

		currency = new JComboBox();
		currency.setBounds(120, 36, 101, 26);
		CurrencyPanel.add(currency);

		rate = new JTextField();
		rate.setEditable(false);
		rate.setBounds(233, 35, 82, 28);
		CurrencyPanel.add(rate);
		rate.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Rate");
		lblNewLabel_4.setBounds(243, 19, 55, 16);
		CurrencyPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Base Currency");
		lblNewLabel_5.setBounds(19, 19, 81, 16);
		CurrencyPanel.add(lblNewLabel_5);

		basecur = new JTextField();
		basecur.setBounds(16, 35, 92, 28);
		CurrencyPanel.add(basecur);
		basecur.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Payment Cur.");
		lblNewLabel_6.setBounds(120, 19, 92, 16);
		CurrencyPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Cur. Amount");
		lblNewLabel_7.setBounds(314, 19, 111, 16);
		CurrencyPanel.add(lblNewLabel_7);

		curAmount = new JTextField();
		curAmount.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		curAmount.setEditable(false);
		curAmount.setText("curAmount");
		curAmount.setBounds(314, 35, 122, 28);
		CurrencyPanel.add(curAmount);
		curAmount.setColumns(10);

		curPaid = new JTextField();
		curPaid.setBounds(441, 35, 122, 28);
		CurrencyPanel.add(curPaid);
		curPaid.setColumns(10);

		CurDue = new JTextField();
		CurDue.setBounds(563, 35, 122, 28);
		CurrencyPanel.add(CurDue);
		CurDue.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Paid Amount");
		lblNewLabel_8.setBounds(441, 19, 82, 16);
		CurrencyPanel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Due Amount");
		lblNewLabel_9.setBounds(574, 19, 68, 16);
		CurrencyPanel.add(lblNewLabel_9);

		BtnCur = new JButton("Add");
		BtnCur.setMnemonic('D');
		BtnCur.setBounds(683, 35, 63, 28);
		CurrencyPanel.add(BtnCur);
		BtnCur.addActionListener(btn);

		btnShow = new JButton("Show");
		btnShow.setMnemonic('S');
		btnShow.setBounds(683, 6, 61, 28);
		btnShow.addActionListener(btn);
		CurrencyPanel.add(btnShow);

		rb = new JRadioButton("Not Base currency");
		rb.setBounds(597, 13, 115, 18);
		panel.add(rb);

		JLabel lblNewLabel = new JLabel("Customer Payment Module");
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(196, 0, 260, 16);
		internalFrame.getContentPane().add(lblNewLabel);
		internalFrame.setVisible(true);

		ActionListener rblr = new rbLsnr();
		rb.addActionListener(rblr);

		ActionListener cmbls = new cmbLsnr();
		currency.addActionListener(cmbls);

		ActionListener curpd = new curpdLsnr();
		curPaid.addActionListener(curpd);

	}

	/// Start Coding From Here ////

	class curpdLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			double vcurPaid = Double.parseDouble(curPaid.getText());
			double vcurAmount = Double.parseDouble(curAmount.getText());
			double vdue = vcurAmount - vcurPaid;
			CurDue.setText(Double.toString(vdue));
		}
	}

	class cmbLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// btnShow.doClick();
		}
	}

	private void perform() throws ClassNotFoundException, SQLException {
		String vchoice = currency.getSelectedItem().toString().trim();
		// new General().msg("Choice Selected is" + " "+vchoice);
		String vbase = basecur.getText().trim();
		// new General().msg("Choice Selected is" + " "+vbase);
		rate.setText(new gnCurrency().getRate(vbase, vchoice));
		double vrate = Double.parseDouble(rate.getText());
		double vinvamt = Double.parseDouble(dueamt.getText());
		double vcurrencyamt = (vinvamt * vrate);
		vcurrencyamt = (vcurrencyamt);
		curAmount.setText(Double.toString(vcurrencyamt));
		curAmount.setEditable(false);
	}

	class rbLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			boolean v = rb.isSelected();
			jsp.setBounds(6, 133, 650, 114);
			CurrencyPanel.setVisible(true);
			try {
				// AcceptOtherCurrecy();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void AcceptOtherCurrecy() throws Throwable {
		String vbase = currency.getSelectedItem().toString();
		String vothcur = basecur.getText();
		String vrate = new gnCurrency().getRate(vbase, vothcur);

		double vvrate = Double.parseDouble(vrate);
		double vpaidamt = Double.parseDouble(curPaid.getText());
		double vamt = vpaidamt * vvrate;

		model.addRow(new Object[] { " ", "Cash ", vamt, "  " });
		table.setModel(model);

		new gnTable().setCellMask(table, 3);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.YELLOW);
		table.setRowHeight(25);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLUE);
		table.setValueAt("Cash", 0, 1);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification1);
		new gnTable().AddCheckBoxToTable(model, table, 0);
		removeRow(model, table);
		JViewport prt6 = new JViewport();
		prt6.setToolTipText("Payment  Data ");
		String paycol[] = { "Remove", "Type", "Ammount", "Cars" };
		prt6.add(table, paycol);
		jsp.setViewport(prt6);
		CalculatePayment();

	}

	public void custpayment(String payCur, JTable xtable, DefaultTableModel pmodel, String paycol[], String billamt)
			throws ClassNotFoundException, SQLException {
		basecur.setText(payCur);
		String type = "Currency";
		// String SQL = "Call master_getMasterData('"+type+"')" ;
		String vsearch = "%%";
		String vverticle = new gnHierarchy().getVerticleCode();
		String SQL1 = "call master_getMasterData('" + type + "'  , " + vverticle + " , '" + vsearch + "')";

		new gnComp().fillCombo(SQL1, currency);
		if (payCur != "INR") {
			jsp.setBounds(6, 133, 650, 114);
			CurrencyPanel.setVisible(true);
			try {
				AcceptOtherCurrecy();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		model = pmodel;
		table = xtable;
		new gnImageSound().playSound();
		vinvamt = billamt;
		invamt.setText(billamt);
		pmodel.setColumnIdentifiers(paycol);
		pmodel.addRow(new Object[] { " ", "  ", "0", "  " });
		// pmodel.addRow(new Object[] {" ", " ", "0", " "});
		// pmodel.addRow(new Object[] {" ", " ", "0", " "});
		table.setModel(pmodel);
		String vtype1 = "PaymentMode";
		SQL1 = "call master_getMasterData('" + vtype1 + "'  , " + vverticle + " , '" + vsearch + "')";
		// String SQL1 = " call master_getMasterData('"+vtype1+"' ,
		// "+vverticle+" , '"+vsearch+"')";
		table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new gnComp().generateBox(SQL1)));
		new gnTable().setCellMask(table, 3);
		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.YELLOW);
		table.setRowHeight(25);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.BLUE);
		table.setValueAt("Cash", 0, 1);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification1);
		new gnTable().AddCheckBoxToTable(pmodel, table, 0);
		removeRow(pmodel, table);
		JViewport prt6 = new JViewport();
		prt6.setToolTipText("Payment  Data ");
		prt6.add(table, paycol);
		jsp.setViewport(prt6);
		customerpaymentFrame.setVisible(true);
		panel.setVisible(true);
		CalculatePayment();
	}

	public void removeRow(DefaultTableModel xmodel, JTable xtable) {
		// new General().msg("I REached Here ") ;
		String vauthallow = "N";
		DefaultTableModel modelName = xmodel;
		JTable tableName = xtable;

		TableColumn Del = tableName.getColumnModel().getColumn(0);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setSelected(false);
		chkbox.setVisible(true);
		chkbox.setMargin(new Insets(0, 16, 0, 0));
		chkbox.setIconTextGap(0);
		chkbox.setBackground(new Color(255, 255, 255, 0));
		chkbox.setText("");
		Del.setCellRenderer(new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Del.setCellEditor(new DefaultCellEditor(chkbox));
				// chkbox.setSelected(((Boolean)value).booleanValue()) ;
				return chkbox;
			}
		});

		// Del.setCellEditor(new DefaultCellEditor(chkbox));

		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int nn = e.getStateChange();

				if (nn == 2) {
					int option = new General().msgInput(" Payment Row Will be Deleted Are You Sure ?");

					if (option == 0) {
						int q = tableName.getSelectedRow();
						modelName.removeRow(q);
						try {
							CalculatePayment();
						} catch (ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
						}
					}
					return;
				}
				return;
			}
		});
	}

	class btnok implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (value == "Ok") {
				getmyPatmentTable();
				customerpaymentFrame.dispose();
				status = "Sucess";
				vduepayment = Double.parseDouble(dueamt.getText());
			}
			if (value == "Add Row") {
				model.addRow(new Object[] { " ", "  ", "0", "  " });
			}

			if (value == "Add") {
				try {
					AcceptOtherCurrecy();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if (value == "Show") {
				try {
					perform();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
	}

	public JTable getmyPatmentTable() {
		return table;
	}

	public CellEditorListener ChangeNotification1 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int nrow = table.getSelectedRow();
			// String nvalue = (String) table.getValueAt(nrow, 2);
			// String vresult = "Sucess" ;
			try {
				CalculatePayment();
			} catch (ClassNotFoundException | SQLException e1) {
				new General().msg(e1.getLocalizedMessage());
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	};
	private JPanel CurrencyPanel;
	private JTextField rate;
	private JTextField basecur;
	private JTextField curAmount;
	private JTextField curPaid;
	private JTextField CurDue;
	private JButton btnShow;

	public void CalculatePayment() throws ClassNotFoundException, SQLException {
		// public String paycol[] = {"Romove", "Mode", "Amount", "Card" } ;

		Double xpayamt = Double.parseDouble(vinvamt);
		Double v = new gnTable().getTotal(table, 2);
		payamount.setText(Double.toString(v));
		Double xdue = xpayamt - v;
		dueamt.setText(Double.toString(xdue));
	}
}// Last

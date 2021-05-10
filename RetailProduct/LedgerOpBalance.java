package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class LedgerOpBalance extends getResultSet {

	JFrame legeropbalframe;
	private JTextField code;
	private JTextField name;
	private JTextField opbal;
	private JButton btnSave;
	private JButton btnClose;
	private JScrollPane jsp;
	private String vfinyear;
	private String vcomp;
	private String vstore;
	private JTextField finyear;
	private JComboBox drcrtype;

	private JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.DARK_GRAY);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Cambria", Font.BOLD | Font.BOLD, 13));
			}

			if (column == 3 || column == 4 || column == 5 || column == 6 || column == 7 || column == 8) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.black);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Cambria", Font.HANGING_BASELINE | Font.BOLD, 13));
			}

			if (column == 3 || column == 2 || column == 1) {
				componentt.setBackground(Color.DARK_GRAY);
				componentt.setForeground(Color.YELLOW);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Cambria", Font.HANGING_BASELINE | Font.BOLD, 15));
			}

			return componentt;
		}
	};
	private DefaultTableModel model = new DefaultTableModel();
	private JTextField groupname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LedgerOpBalance window = new LedgerOpBalance();
					window.legeropbalframe.setVisible(true);
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
	public LedgerOpBalance() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		legeropbalframe = new JFrame();
		legeropbalframe.getContentPane().setBackground(Color.WHITE);
		legeropbalframe.setBackground(new Color(0, 255, 255));
		legeropbalframe.setAlwaysOnTop(true);
		//legeropbalframe.setBounds(100, 250, 1200, 573);
		legeropbalframe.setBounds(1, 90, 1350, 605);
 		legeropbalframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		legeropbalframe.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 0, 1136, 156);
		legeropbalframe.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ledger Opening Balance Entry");
		lblNewLabel.setBackground(new Color(102, 0, 153));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setBounds(0, 0, 1113, 26);
		panel.add(lblNewLabel);

		JButton btnNewButton = new JButton(" ");
		btnNewButton.setEnabled(false);
		btnNewButton.setBackground(new Color(51, 0, 153));
		btnNewButton.setBounds(0, 23, 515, 3);
		panel.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Ledger Code");
		lblNewLabel_1.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(0, 51, 102));
		lblNewLabel_1.setBounds(28, 61, 90, 16);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Op.Balance");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_3.setBounds(28, 92, 90, 16);
		panel.add(lblNewLabel_3);

		drcrtype = new JComboBox();
		drcrtype.setModel(new DefaultComboBoxModel(new String[] { "Dr", "Cr" }));
		drcrtype.setBounds(197, 88, 68, 26);
		panel.add(drcrtype);

		code = new JTextField();
		code.setBounds(122, 56, 80, 28);
		panel.add(code);
		code.setColumns(10);

		name = new JTextField();
		name.setFont(new Font("Cambria", Font.BOLD, 15));
		name.setBounds(197, 56, 297, 28);
		panel.add(name);
		name.setColumns(10);

		opbal = new JTextField();
		opbal.setBounds(120, 87, 80, 28);
		panel.add(opbal);
		opbal.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Note:Please Enter Correct Amount & Select Correct Debit or Credit Type");
		lblNewLabel_2.setFont(new Font("Segoe Print", Font.BOLD, 12));
		lblNewLabel_2.setBounds(6, 116, 464, 16);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("Fin.Year");
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD, 15));
		lblNewLabel_4.setBounds(60, 33, 68, 16);
		panel.add(lblNewLabel_4);

		finyear = new JTextField();
		finyear.setBounds(121, 28, 80, 28);
		panel.add(finyear);
		finyear.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Group");
		lblNewLabel_5.setBounds(511, 34, 55, 16);
		panel.add(lblNewLabel_5);

		groupname = new JTextField();
		groupname.setFont(new Font("Cambria", Font.BOLD, 15));
		groupname.setBounds(492, 56, 454, 28);
		panel.add(groupname);
		groupname.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setBounds(778, 116, 90, 37);
		panel.add(btnSave);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSave.setMnemonic('S');
		
				btnClose = new JButton("Close");
				btnClose.setBounds(866, 116, 90, 37);
				panel.add(btnClose);
				btnClose.setFont(new Font("Tahoma", Font.BOLD, 13));
				btnClose.setMnemonic('C');
 
		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 166, 1350, 439);
		legeropbalframe.getContentPane().add(jsp);
		ActionListener btnchioce = new btnLsnr();
		btnClose.addActionListener(btnchioce);
		btnSave.addActionListener(btnchioce);

		decorate();

	}

	private void decorate() throws Throwable {

		new gnApp().setFrameTitel(legeropbalframe);
 		legeropbalframe.setUndecorated(true);
 		
 		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();

		finyear.setText(vfinyear);
		finyear.setBackground(Color.BLACK);
		finyear.setForeground(Color.WHITE);
		finyear.setEditable(false);
		opbal.setText("0.00");
		showData();
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Save") {
				String status = validate();
				if (status == "Sucess") {
					try {
						SaveAction();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			}

			if (value == "Close") {
				legeropbalframe.dispose();
			}
		}
	}

	private String validate() {
		String status = "Sucess";

		String vcode = code.getText();
		if (vcode.length() == 0) {
			new General().msg("Enter Code::");
			code.grabFocus();
			status = "Fail";
		}

		vcode = name.getText();
		if (vcode.length() == 0) {
			new General().msg("Enter Name::");
			name.grabFocus();
			status = "Fail";
		}

		vcode = opbal.getText();
		if (vcode.length() == 0) {
			opbal.setText("0");
		}
		return status;
	}

	private void showData() throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		String col[] = { "Gl Code", "Name", "Op.Bal", "Op.Bal Drcr", "Cl.Bal", "ClDrcr", "Group", "Grp.Name" };
		model.setColumnIdentifiers(col);
		String vtype = "GL";
		String vglname = "";
		vglname = "%" + vglname + "%";
		String SQL = "call Account_getSEarchDetails( '" + vtype + "', " + vcomp + " , " + vstore + " , '" + vglname
				+ "' ,   '" + vfinyear + "' )";
		// new General().msg(SQL) ;
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
		}
		table.setModel(model);
		table.requestFocus();
		new gnField().moveDown(table);
		JViewport prt6 = new JViewport();
		jsp.setViewport(prt6);
		prt6.setBackground(Color.white);
		prt6.setToolTipText("ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(table, col);
		new gnTable().setTableBasics(table);
		selectRow();
	}

	private void selectRow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				groupname.setText(table.getValueAt(row, 7).toString());
				code.setText(table.getValueAt(row, 0).toString());
				name.setText(table.getValueAt(row, 1).toString());
				opbal.setText(table.getValueAt(row, 2).toString());
				String drcr = table.getValueAt(row, 3).toString();
				switch (drcr) {
				case "Dr":
					drcrtype.setSelectedItem("Dr");
					break;
				case "Cr":
					drcrtype.setSelectedItem("Cr");
					break;
				}
				try {
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					opbal.grabFocus();
				}
			}

		});
	}

	private void SaveAction() throws ClassNotFoundException, SQLException {
		String vcode = code.getText();
		String vname = name.getText();
		String vopbal = opbal.getText();
		String vdrcr = drcrtype.getSelectedItem().toString();
		String SQL = "call Account_updateInitailOpBalance(" + vcomp + " , " + vstore + ", " + vcode + ", " + vopbal
				+ " , '" + vdrcr + "' , '" + vfinyear + "')";
		this.getSPResult(SQL);
		// new General().msg("Data Updated Sucessfully");
		code.setText("");
		name.setText("");
		groupname.setText("");
		showData();
	}
}// Last

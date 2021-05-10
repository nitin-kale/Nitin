package RetailProduct;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class Cust_Search<Ret_value> extends getResultSet {
	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 1 ? false : true;
		}
	};

	public JTable table = new JTable();
	public String[] Col = { "Cust_code", "Cust_Name" };
	public JPanel Hpanel;
	public JScrollPane jsp1;
	JFrame frameCustomer;
	public String Ret_value;

	public int code = 0;
	public String name;
	public String mobile;
	public String Email;

	protected Window frameauth;
	private JTextField Cust_name;

	POS POS;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				UIManager.getInstalledLookAndFeels();
				try {
					Cust_Search window = new Cust_Search();
					window.frameCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cust_Search() {
		initialize();
	}

	private void initialize() {
		frameCustomer = new JFrame();
		frameCustomer.setAutoRequestFocus(false);
		frameCustomer.setAlwaysOnTop(true);
		frameCustomer.setTitle("Business Application ");
		frameCustomer.setType(Type.UTILITY);
		frameCustomer.setBounds(200, 200, 649, 406);
		frameCustomer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		frameCustomer.getContentPane().add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Serach Customer");
		internalFrame.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		internalFrame.setBounds(0, 0, 633, 361);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel Hpanel = new JPanel();
		Hpanel.setBackground(Color.WHITE);
		Hpanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Hpanel.setBounds(0, 0, 629, 91);
		internalFrame.getContentPane().add(Hpanel);
		Hpanel.setLayout(null);

		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setBounds(22, 13, 112, 16);
		Hpanel.add(lblCustomerName);

		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobileNumber.setBounds(22, 31, 94, 16);
		Hpanel.add(lblMobileNumber);

		Cust_name = new JTextField();
		Cust_name.setBounds(146, 10, 202, 22);
		Hpanel.add(Cust_name);
		Cust_name.setColumns(10);

		JFormattedTextField Mobile = new JFormattedTextField();
		Mobile.setBounds(146, 31, 202, 22);
		Hpanel.add(Mobile);

		JButton btnSearch = new JButton("Search");
		ActionListener ls = new ls();
		btnSearch.addActionListener(ls);
		btnSearch.setBounds(349, 9, 97, 25);
		Hpanel.add(btnSearch);

		Cust_name = new JTextField();
		Cust_name.setBounds(146, 10, 202, 22);
		Hpanel.add(Cust_name);
		Cust_name.setColumns(10);

		JScrollPane jsp1 = new JScrollPane();
		jsp1.setViewportBorder(new LineBorder(UIManager.getColor("Tree.selectionBackground"), 1, true));
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(10, 104, 607, 191);

		JViewport prt = new JViewport();
		prt.setBackground(UIManager.getColor("TextPane.disabledBackground"));
		prt.add(table, Col);
		prt.setVisible(true);
		jsp1.setViewport(prt);
		table.setBackground(Color.white);
		table.setDefaultRenderer(Object.class, new MyRenderer());
		prt.setVisible(true);
		internalFrame.getContentPane().add(jsp1);
		internalFrame.setVisible(true);
	}

	public String showTableData(String value1) throws SQLException, ClassNotFoundException {
		DefaultTableModel model = new DefaultTableModel();
		table.setBounds(11, 36, 758, 500);
		String Col[] = { "Type", "Customer_no", "Name", "Mobile", "Email" };
		Object row[] = {};
		model.setColumnIdentifiers(Col);
		String SQL = "call master.getSearchCustomerName('" + value1 + "')";
		ResultSet rs = this.getSPResult(SQL);
		int r = 0;
		int rowcnt = model.getRowCount();
		while (rs.next()) {
			int col = rs.getInt(1);
			model.addRow(new Object[] { " ", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4) });
			table.setModel(model);
			setTablewidth(table);
			cellEditDisable(table);
			TableColumn custid = table.getColumnModel().getColumn(1);
		}
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int r = table.getSelectedRow();
				try {
					setCustDetail(table, r);
					frameCustomer.dispose();
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				int j = table.getSelectedRow();
				try {
					setCustDetail(table, j);
					frameCustomer.dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		});

		return Ret_value;
	}

	private boolean isCellEditable(int r, int col) {
		return false;
	}

	public void setCustDetail(JTable table, int r) throws Throwable {
		System.out.println("Reached here in the class to disply cust fields");

		String code1 = (String) table.getValueAt(r, 1);
		code = Integer.parseInt(code1);
		System.out.println("Before Calling Call Value of code is : " + code);
		new POS().dispCustInfo(code);

	}

	public boolean cellEditDisable(JTable table) {

		table.setFocusable(false);
		table.setRowSelectionAllowed(true);
		return false;
	}

	public void setTablewidth(JTable table) {
		table.setRowHeight(30);
		table.setRowMargin(4);
		table.setDefaultRenderer(Object.class, new MyRenderer());
		TableColumnModel columnModel = table.getColumnModel();
		int wd = columnModel.getColumn(0).getWidth();
		columnModel.getColumn(0).setPreferredWidth(wd);
		columnModel.getColumn(2).setPreferredWidth(wd + 150);
		columnModel.getColumn(3).setPreferredWidth(wd);
		table.setRowSelectionAllowed(true);
		table.setBackground(Color.white);

	}

	class ls implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// message(null, "Reached in class ls ");
			System.out.println("Reached at actionlistener");
			String btnvalue = e.getActionCommand();
			int i = e.getID(); // Field Id
			String value1 = Cust_name.getText();
			value1 = "%" + value1 + "%";

			System.out.println(btnvalue);
			System.out.println(value1);
			System.out.println(i);
			if (i == 1001 && btnvalue == "Search")
				try {
					showTableData(value1);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			return;
		}
	}
}

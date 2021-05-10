package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class HomeDel_Dispatch extends getResultSet {

	JFrame homeDel_dispatchFrame;
	private JTextField sitecode;
	private JTextField sitename;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	boolean rbchoice;
	String rbname;
	JButton btnPrint;
	JEditorPane edtpane;
	JButton btnClose;
	private JButton btnAddrPrint;
	JButton btnUpdate;
	JRadioButton rb2;
	JRadioButton rb1;
	String vcomp;
	String vstore;

	String[] colhdr = { "Cust Code", "Customer Name", "Invno", "Inv.Date", "Bill Time", "Amount", "Phone", "Status" };

	String[] colDetail = { "Invno", "Inv.Date", "Bill Time", "Article", "Name", "Qty", "Amount", "Status" };

	String[] colcust = { "Cust.Code", "Name", "Addr1", "Addr2", "Addr3", "Addr4", "Phone", "Email" };

	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable();
	JScrollPane jsp1;
	JScrollPane jsp;

	private DefaultTableModel smodel = new DefaultTableModel();
	private JTable stable = new JTable();
	private JTextField custname;
	private JTextField custcode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeDel_Dispatch window = new HomeDel_Dispatch();
					window.homeDel_dispatchFrame.setVisible(true);
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
	public HomeDel_Dispatch() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		homeDel_dispatchFrame = new JFrame();
		homeDel_dispatchFrame.setAlwaysOnTop(true);
		homeDel_dispatchFrame.setBounds(250, 15, 930, 716);
		homeDel_dispatchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		homeDel_dispatchFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(new Color(51, 255, 255));
		panel.setBounds(0, 36, 588, 119);
		homeDel_dispatchFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Branch");
		lblNewLabel_1.setBounds(12, 13, 56, 16);
		panel.add(lblNewLabel_1);

		sitecode = new JTextField();
		sitecode.setBounds(62, 10, 116, 28);
		panel.add(sitecode);
		sitecode.setColumns(10);

		sitename = new JTextField();
		sitename.setBounds(177, 10, 277, 28);
		panel.add(sitename);
		sitename.setColumns(10);

		JPanel delPanel = new JPanel();
		delPanel.setBackground(new Color(51, 255, 255));
		delPanel.setBounds(466, 0, 122, 119);
		delPanel.setBorder(
				new TitledBorder(null, "Delivery Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(delPanel);
		delPanel.setLayout(null);

		rb1 = new JRadioButton("Pending");
		rb1.setToolTipText("View All Pending Home Delivery ");
		buttonGroup.add(rb1);
		rb1.setBounds(8, 22, 94, 25);
		delPanel.add(rb1);

		rb2 = new JRadioButton("Complete");
		rb2.setToolTipText("Completed Home Delivery ");
		buttonGroup.add(rb2);
		rb2.setBounds(8, 52, 94, 25);
		delPanel.add(rb2);

		custname = new JTextField();
		custname.setBounds(187, 59, 267, 28);
		panel.add(custname);
		custname.setColumns(10);

		custcode = new JTextField();
		custcode.setBounds(62, 59, 122, 28);
		panel.add(custcode);
		custcode.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Select Customer If Required", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel_1.setBounds(37, 41, 424, 72);
		panel.add(panel_1);

		JLabel lblNewLabel = new JLabel("Home Delivery - Dispatch");
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 6, 420, 29);
		homeDel_dispatchFrame.getContentPane().add(lblNewLabel);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 183, 912, 177);
		homeDel_dispatchFrame.getContentPane().add(jsp);

		jsp1 = new JScrollPane();
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(0, 386, 912, 295);
		homeDel_dispatchFrame.getContentPane().add(jsp1);

		btnUpdate = new JButton("Update Status");
		btnUpdate.setToolTipText("Update Status once Delivery is Dispatch to Customer");
		btnUpdate.setMnemonic('U');
		btnUpdate.setBounds(361, 154, 124, 29);
		homeDel_dispatchFrame.getContentPane().add(btnUpdate);

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(485, 154, 103, 29);
		homeDel_dispatchFrame.getContentPane().add(btnClose);

		JLabel lblNewLabel_2 = new JLabel("Home Deliveries ");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 168, 175, 16);
		homeDel_dispatchFrame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Invoice Details For Cross Verifications");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 369, 224, 16);
		homeDel_dispatchFrame.getContentPane().add(lblNewLabel_3);

		btnPrint = new JButton("Print Invoice Copy");
		btnPrint.setMnemonic('P');
		btnPrint.setBounds(454, 357, 134, 29);
		homeDel_dispatchFrame.getContentPane().add(btnPrint);

		edtpane = new JEditorPane();
		edtpane.setVisible(false);
		edtpane.setForeground(new Color(0, 0, 102));
		edtpane.setBackground(new Color(0, 204, 204));
		edtpane.setBounds(606, 37, 306, 146);
		homeDel_dispatchFrame.getContentPane().add(edtpane);

		btnAddrPrint = new JButton("Address Print");
		btnAddrPrint.setBounds(591, 357, 134, 28);
		homeDel_dispatchFrame.getContentPane().add(btnAddrPrint);

		ActionListener btnls = new btnLsnr();
		ActionListener rb = new rbLsnr();
		ActionListener cust = new lsnrCustName();
		rb1.addActionListener(rb);
		rb2.addActionListener(rb);
		btnUpdate.addActionListener(btnls);
		btnClose.addActionListener(btnls);
		btnPrint.addActionListener(btnls);
		custname.addActionListener(cust);
		btnAddrPrint.addActionListener(btnls);

		decorate();

	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(homeDel_dispatchFrame);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		sitecode.setText(vstore);
		sitename.setText(new gnConfig().getStorename(vstore));
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (value == "Close") {
				homeDel_dispatchFrame.dispose();
			}

			if (value == "Address Print") {
				try {
					printAddress();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Update Status") {

				try {
					int row = stable.getRowCount();
					if (row > 0) {
						int choice = new General().msgInput("Are you Sure .. Have Completed Delivery ?");
						new General().msg("Choice is" + " " + choice);
						switch (choice) {
						case 0:
							updateStatus();
							break;
						}
					} else {
						new gnImageSound().playAlertSound();
						new gnImageSound().playAlertSound();
						new General().msg("check  Article  .. Select Invoice First ");
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					new General().msg(e1.getLocalizedMessage());
				}
			}
			if (value == "Print Invoice Copy") {
				try {
					printInvoice();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}
	}

	public void printInvoice() throws Throwable {

		if (stable.getRowCount() > 0) {
			String vinvno = stable.getValueAt(0, 0).toString();
			String vinvdate = stable.getValueAt(0, 1).toString();
			String doctype = "POSINV";
			new gnDocPrint().callprint(doctype, vinvno, vinvdate);
		} else {
			new General().msg("No Data Found.. Select Data For Delivery");
		}
		return;
	}

	class lsnrCustName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String sname = custname.getText().trim();
			sname = "%" + sname + "%";
			String vcomp;
			try {
				new gnSupplier().getCustomer(sname);
			} catch (Throwable e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} finally {
				custcode.setText(new gnSupplier().rcustcode);
				custname.setText(new gnSupplier().rcustName);
			}
		}
	}

	class rbLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			String vcust = custcode.getText();
			String[] colhdr = { "Cust Code", "Customer Name", "Invno", "Inv.Date", "Bill Time", "Amount", "Phone",
					"Status" };

			rbchoice = rb1.isSelected();
			if (rbchoice) {

				rbname = "Pending";
				String SQL = "call homeDel_getDeliveries(" + vcomp + " ,  " + vstore + ",  " + vcust + " , '" + rbname
						+ "')";
				try {
					showDelivery(SQL, colhdr);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			rbchoice = rb2.isSelected();
			if (rbchoice) {
				rbname = "Complete";
				String SQL = "call homeDel_getDeliveries(" + vcomp + " ,  " + vstore + " , " + vcust + " , '" + rbname
						+ "')";
				try {
					showDelivery(SQL, colhdr);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	private void showDelivery(String SQL, String[] col) throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(col);
		new gnTableModel().Tablemodel(table, model, SQL, col, 8, "N", "N", "N");
		table.setModel(model);
		if (table.getRowCount() > 0) {
			table.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(new gnComp().generateStatus()));
		}
		new gnTable().setTableBasics(table);
		table.setRowHeight(25);
		new gnTable().setTableColWidth(table, 1, 300);
		JViewport prt7 = new JViewport();
		jsp.setViewport(null);
		prt7.setToolTipText("Home Delivery - Dispatch");
		prt7.setScrollMode(0);
		prt7.add(table, col);
		jsp.setViewport(prt7);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification4);

	}

	public CellEditorListener ChangeNotification4 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			// System.out.println("The user canceled editing.");
			table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification4);

			// String[] colhdr = {"Cust Code" , "Customer Name" , "Invno",
			// "Inv.Date" ,
			// "Bill Time" ,"Amount" , "Phone" , "Status" } ;

		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String vinvno = table.getValueAt(row, 2).toString().trim();
			String vcust = table.getValueAt(row, 0).toString().trim();
			String vinvdate = "";
			try {
				vinvdate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(row, 3).toString().trim());
			} catch (ClassNotFoundException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				String[] colDetail = { "Invno", "Inv.Date", "Bill Time", "Article", "Name", "Qty", "Amount", "Status" };
				String SQL = "Call homeDel_getPendingDetails(" + vcomp + " , " + vstore + " , " + vcust + " , " + vinvno
						+ " , '" + vinvdate + "' )";
				showInvDetails(SQL, colDetail);
			} catch (Throwable e1) {
				e1.printStackTrace();
				new General().msg("home Delivery ShowArticle" + " " + e1.getMessage());
			}
		}
	};

	private void showInvDetails(String SQL, String[] col) throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(smodel);
		smodel.setColumnIdentifiers(col);
		String[] colDetail = { "Invno", "Inv.Date", "Bill Time", "Article", "Name", "Qty", "Amount", "Status" };
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, col, 8, "N", "N", "N");
		stable.setModel(smodel);
		new gnTable().setTableBasics(stable);
		stable.setRowHeight(25);
		new gnTable().setTableColWidth(stable, 4, 300);
		JViewport prt5 = new JViewport();
		jsp1.setViewport(null);
		prt5.setToolTipText("Home Delivery - Dispatch");
		prt5.setScrollMode(0);
		prt5.add(stable, col);
		jsp1.setViewport(prt5);
		stable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification4);
	}

	private void updateStatus() throws ClassNotFoundException, SQLException {
		String SQL = " ";
		String vcust = custcode.getText();
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			// { 0"Cust Code" , 1"Customer Name" , 2"Invno", 3"Inv.Date" ,
			// 4"Bill Time" , 5"Amount" , 6"Phone" , 7"Status" } ;
			String vinvno = table.getValueAt(i, 2).toString();
			String vinvdate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(i, 3).toString());
			String vdelDate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
			String vdelTime = new General().getTime();
			String vstatus = table.getValueAt(i, 7).toString();
			SQL = "Call homeDel_updateStatus( " + vcomp + " , " + vstore + "  , " + vcust + "  , " + vinvno + " , '"
					+ vinvdate + "' ,  '" + vdelDate + "' ,  '" + vdelTime + "' , '" + vstatus + "' )";
			this.getSPResult(SQL);
		}
		new General().msg("Data Updated  Sucessfully ..");
		new gnTable().RemoveTableRows(model);
		new gnTable().RemoveTableRows(smodel);
		custcode.setText("0");
		custname.setText("Default");
		rb1.setSelected(false);
		rb2.setSelected(false);
	}

	private void printAddress() throws ClassNotFoundException, SQLException {
		// String[] colDetail= {"Invno", "Inv.Date" , "Bill Time" , "Article"
		// ,"Name" , "Qty", "Amount", "Status" } ;
		String vcust = custcode.getText();
		int row = stable.getRowCount();
		String vinvno = stable.getValueAt(0, 0).toString();
		String vinvdate = new gnConfig().date_ConverttoDBforamt(stable.getValueAt(0, 1).toString());
		String vaddrsource = "D";
		String SQL = "call  Print_homeDel_Address( " + vcomp + " , " + vstore + "  , " + vcust + " , " + vinvno
				+ "  , '" + vinvdate + "', '" + vaddrsource + "')";
		new General().msg(SQL);
		this.getSPResult(SQL);
		PrintAddr();
	}

	private void PrintAddr() {
		if (stable.getRowCount() > 0) {
			// String vinvno = stable.getValueAt(0,0).toString() ;
			String doctype = "POSINV";
			try {
				// new gnDocPrint().callprint(doctype,vinvno);

				String vreport = "homeDel_addrPrint.jasper";
				// String vreport = new
				// gnApplicationSetting().Print_invoiceFormat() ;
				gnPrintMasters rpt = new gnPrintMasters();
				rpt.homeDel_addrPrint(vreport);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			new General().msg("No Data Found.. Select Data For Delivery");
		}
		return;
	}

}// Last

package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Supplier_Schedule extends getResultSet {

	JFrame SupScheduleFrame;
	private JTextField suppliercode;
	private JTextField suppliername;
	private JTextField email;
	private JTextField phone;
	boolean rbchoice;
	String rbname = "0";
	private JTextField creditDays;
	private JLabel lblNewLabel_4;
	private JTextField scanItem;
	private JTextField searchname;
	JRadioButton rb2;
	java.sql.Connection con2;
	String DBhdr;
	JScrollPane jsp;
	JButton btnSave;
	JButton btnView;
	JPanel scanPanel;
	JButton btnClose;
	JRadioButton rb1;
	String vcomp;
	String vstore;

	private DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 1 || column == 2 ? false : true;
		}
	};

	private JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 1 || column == 2) {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
			} else {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.blue);
			}
			return componentt;
		}
	};
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField brandcode;
	private JTextField brandname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supplier_Schedule window = new Supplier_Schedule();
					window.SupScheduleFrame.setVisible(true);
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
	public Supplier_Schedule() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		SupScheduleFrame = new JFrame();
		SupScheduleFrame.setAlwaysOnTop(true);
		SupScheduleFrame.setBounds(180, 40, 872, 700);
		SupScheduleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SupScheduleFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 28, 483, 122);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SupScheduleFrame.getContentPane().add(panel);
		panel.setLayout(null);

		suppliercode = new JTextField();
		suppliercode.setBounds(78, 13, 116, 26);
		panel.add(suppliercode);
		suppliercode.setColumns(10);

		suppliername = new JTextField();
		suppliername.setBounds(200, 13, 271, 26);
		panel.add(suppliername);
		suppliername.setColumns(10);

		email = new JTextField();
		email.setEditable(false);
		email.setBounds(200, 36, 271, 26);
		panel.add(email);
		email.setColumns(10);

		phone = new JTextField();
		phone.setEditable(false);
		phone.setBounds(200, 60, 141, 26);
		panel.add(phone);
		phone.setColumns(10);

		creditDays = new JTextField();
		creditDays.setEditable(false);
		creditDays.setBounds(433, 60, 38, 26);
		panel.add(creditDays);
		creditDays.setColumns(10);

		JLabel lblNewLabel = new JLabel("Supplier");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel.setBounds(28, 18, 56, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email ");
		lblNewLabel_1.setBounds(156, 41, 38, 16);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Phone");
		lblNewLabel_2.setBounds(156, 65, 38, 16);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Cr.Days");
		lblNewLabel_3.setBounds(374, 63, 56, 16);
		panel.add(lblNewLabel_3);

		btnView = new JButton("View");
		btnView.setBounds(387, 91, 90, 28);
		panel.add(btnView);
		btnView.setMnemonic('V');

		lblNewLabel_4 = new JLabel("Supplier - Supply Schedule");
		lblNewLabel_4.setBounds(0, 0, 726, 27);
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		SupScheduleFrame.getContentPane().add(lblNewLabel_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(495, 29, 233, 122);
		panel_1.setBorder(new TitledBorder(null, "Supply Schedule Maintain Level", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		SupScheduleFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		rb1 = new JRadioButton("Brand");
		buttonGroup.add(rb1);
		rb1.setBounds(23, 27, 63, 18);
		panel_1.add(rb1);

		rb2 = new JRadioButton("All Brand");
		buttonGroup.add(rb2);
		rb2.setFont(new Font("SansSerif", Font.BOLD, 11));
		rb2.setBounds(93, 27, 115, 18);
		panel_1.add(rb2);

		brandcode = new JTextField();
		brandcode.setEnabled(false);
		brandcode.setEditable(false);
		brandcode.setBounds(33, 60, 33, 22);
		panel_1.add(brandcode);
		brandcode.setColumns(10);

		brandname = new JTextField();
		brandname.setEnabled(false);
		brandname.setEditable(false);
		brandname.setBounds(69, 60, 137, 22);
		panel_1.add(brandname);
		brandname.setColumns(10);

		scanPanel = new JPanel();
		scanPanel.setBounds(0, 148, 726, 33);
		scanPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 153, 153), null));
		SupScheduleFrame.getContentPane().add(scanPanel);
		scanPanel.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Code");
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_5.setForeground(new Color(0, 51, 102));
		lblNewLabel_5.setBounds(34, 8, 30, 16);
		scanPanel.add(lblNewLabel_5);

		scanItem = new JTextField();
		scanItem.setFont(new Font("SansSerif", Font.BOLD, 14));
		scanItem.setBounds(73, 1, 122, 30);
		scanPanel.add(scanItem);
		scanItem.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Search by Name");
		lblNewLabel_6.setBounds(263, 8, 97, 16);
		scanPanel.add(lblNewLabel_6);

		searchname = new JTextField();
		searchname.setFont(new Font("SansSerif", Font.BOLD, 12));
		searchname.setBounds(357, 1, 233, 30);
		scanPanel.add(searchname);
		searchname.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(48, 616, 90, 33);
		SupScheduleFrame.getContentPane().add(btnSave);

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(144, 616, 90, 33);
		SupScheduleFrame.getContentPane().add(btnClose);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 217, 848, 401);
		SupScheduleFrame.getContentPane().add(jsp);

		ActionListener btnlsn = new btnLsnr();
		ActionListener suplsn = new supLsnr();
		ActionListener brnd = new lsnrbrand();
		ActionListener rb = new rblsnr();

		btnSave.addActionListener(btnlsn);
		btnClose.addActionListener(btnlsn);
		btnView.addActionListener(btnlsn);
		suppliername.addActionListener(suplsn);
		searchname.addActionListener(brnd);
		rb1.addActionListener(rb);
		rb2.addActionListener(rb);

		decorate();

	}

	private void decorate() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		scanPanel.setVisible(false);
		rb1.setVisible(false);
	}

	class rblsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

			rbchoice = rb1.isSelected();
			if (rbchoice) {
				rbname = "Brand";
				scanPanel.setVisible(true);
			}
			rbchoice = rb2.isSelected();
			if (rbchoice) {
				scanPanel.setVisible(false);
				rbname = "All Brand";
				showAllBrand();
			}

		}
	}

	private void sreachBrand() {
		String vbrandname = "%" + searchname.getText() + "%";
		String vtype = "Brand";
		String vverticle;
		try {

			// new gnBrand().getBrandInfo(vbrandname);
			new gnAdmin().showMasterTable(vtype, brandcode, brandname);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// String vbrandcode = new gnBrand().rbrandcode;
			String vbrandcode = brandcode.getText();

			String vsupplier = suppliercode.getText();
			String SQL = "Call     SupSch_getBrand(" + vcomp + " , " + vstore + " , " + vbrandcode + ", " + vsupplier
					+ ")";
			new General().msg(SQL);
			try {
				new gnTable().RemoveTableRows(model);
				String vtype1 = "New";
				ViewSchedule(SQL, vtype1);
				new gnBrand().rbrandcode = "0";
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	private void showAllBrand() {
		String vstatus = new gnSupplier().checkVendorSelected(suppliername);
		if (vstatus == "Sucess") {
			new gnTable().RemoveTableRows(model);
			String vsupplier = suppliercode.getText();
			String SQL = "Call     SupSch_getAllBrand(" + vcomp + " , " + vstore + " , " + vsupplier + ")";
			try {
				String vtype1 = "New";
				ViewSchedule(SQL, vtype1);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class lsnrbrand implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id

			if (rbname == "0") {
				new General().msg("Select  Schedule Maintain Level ..");
				return;
			}
			switch (rbname) {
			case "Brand":
				String vstatus = new gnSupplier().checkVendorSelected(suppliername);
				if (vstatus == "Sucess") {
					sreachBrand();
				}
				break;
			// case "All Brand" : showAllBrand() ;
			// break;

			}
		}
	}

	class supLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vname = suppliername.getText();
			vname = "%" + vname + "%";
			try {
				new gnSupplier().getSupplier(vname);
			} catch (Throwable e) {
				new General().msg(e.getLocalizedMessage());
			} finally {
				suppliercode.setText(new gnSupplier().rvendorcode);
				suppliername.setText(new gnSupplier().rvendorName);
				phone.setText(new gnSupplier().rPhone);
				email.setText(new gnSupplier().rEmail);
				creditDays.setText(new gnSupplier().rcrdays);
			}
		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (value == "Close") {
				SupScheduleFrame.dispose();
			}

			if (value == "View") {
				String checkVendor = new gnSupplier().checkVendorSelected(suppliername);
				if (checkVendor == "Sucess") {
					try {
						new gnTable().RemoveTableRows(model);
						String vsupplier = suppliercode.getText();
						String SQL = "Call Supplier_getSchedule(" + vcomp + ", " + vsupplier + ")";
						String vtype1 = "View";
						ViewSchedule(SQL, vtype1);
					} catch (ClassNotFoundException | SQLException e1) {
						new General().msg(e1.getLocalizedMessage());
					}

				}
			}

			if (value == "Save") {
				applyCellValue();
				String status = validate();
				if (status == "Sucess") {
					try {
						ProcesSaveEvent();
					} catch (Throwable e1) {
						e1.printStackTrace();
						new General().msg(e1.getLocalizedMessage());
					}
				}
			}
		}
	}

	private void ViewSchedule(String SQL, String vtype1) throws ClassNotFoundException, SQLException {
		try {
			String pcol[] = { "Type", "code", "name", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "Leadtime",
					"CreditDays" };
			model.setColumnIdentifiers(pcol);
			table = new gnTableModel().Tablemodel(table, model, SQL, pcol, 12, "N", "N", "N");

			table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			table.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			table.getColumnModel().getColumn(7).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			table.getColumnModel().getColumn(8).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));
			table.getColumnModel().getColumn(9).setCellEditor(new DefaultCellEditor(new gnComp().generateYNBox()));

			table.setModel(model);
			new gnTable().setTableBasics(table);
			table.setRowHeight(25);
			new gnTable().setTableColWidth(table, 2, 300);
			new gnTable().setTableColWidth(table, 10, 70);
			new gnTable().setTableColWidth(table, 11, 80);

			JViewport prt7 = new JViewport();
			jsp.setViewport(null);
			prt7.setToolTipText(" Supplier Item Supply Schedule For Po Generation");
			prt7.setScrollMode(0);
			prt7.add(table, pcol);
			jsp.setViewport(prt7);
		} catch (Exception e) {
			new General().msg(e.getMessage());
		} finally {
			if (vtype1 == "View") {
				if (table.getRowCount() > 0) {
					int row = table.getRowCount();
					String vtype = table.getValueAt(row - 1, 0).toString();
					setRbSelection(vtype);
				}
			}
		}
	}

	private void setRbSelection(String vtype) {
		switch (vtype) {
		case "Brand":
			rb1.setSelected(true);
			rb1.setBackground(Color.GREEN);
		}
	}

	private void applyCellValue() {
		for (int i = 3; i <= 9; i++) {
			new gnTable().applyCellValue(table, i, "N");
		}

		for (int i = 10; i <= 11; i++) {
			new gnTable().applyCellValue(table, i, "0");
		}

	}

	private String validate() {
		String status = "Sucess";
		if (suppliername.getText().length() == 0) {
			new General().msg("Select Supplier ...");
			status = "Fail";
		}

		if (table.getRowCount() <= 0) {
			new General().msg("No Records Found For Save ...");
			status = "Fail";
		}
		return status;
	}

	public void ProcesSaveEvent() throws Throwable {
		String vsql = "Call supsch_rRecords()"; // Remove tmp table data and
												// insert new records ;
		this.getResult(vsql);
		prst = null;
		final int batchSize = 5;
		int TotalRecordinsert = 0;
		con2 = this.getConnection();
		con2.setAutoCommit(false);
		String supschedle = "Insert   into  ms_supplier_schedule_tmp(company_code, Site_code , "
				+ " supplier,  Type , code,  name,  Mon, tue, wed, thu, fri, sat, sun, leadtime, creditdays)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int row = table.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con2.prepareStatement(supschedle);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, suppliercode.getText());
				prst.setString(4, table.getValueAt(k, 0).toString());
				prst.setString(5, table.getValueAt(k, 1).toString());
				prst.setString(6, table.getValueAt(k, 2).toString());
				prst.setString(7, table.getValueAt(k, 3).toString());
				prst.setString(8, (table.getValueAt(k, 4).toString()));
				prst.setString(9, table.getValueAt(k, 5).toString());
				prst.setString(10, table.getValueAt(k, 6).toString());
				prst.setString(11, table.getValueAt(k, 7).toString());
				prst.setString(12, table.getValueAt(k, 8).toString());
				prst.setString(13, table.getValueAt(k, 9).toString());
				prst.setString(14, table.getValueAt(k, 10).toString());
				prst.setString(15, table.getValueAt(k, 11).toString());
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBhdr = "Fail";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBhdr = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DBhdr = "Sucess";
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			con2.rollback();
			DBhdr = "Fail";
			new General().msg("Supply Schedule " + " " + e.getLocalizedMessage());
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") {
				con2.commit();
				con2.close();
				reset();
			}
		}

	}

	private void reset() {
		new gnTable().RemoveTableRows(model);
		suppliercode.setText(null);
		suppliername.setText(null);
		new General().msg("Data Saved Sucessfully ");
	}
}// Last

package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JTextArea;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import RetailProduct.store_configuration.codeLsnr;
import java.awt.Toolkit;

public class CreateConfiguation extends getResultSet {

	JFrame Configframe;
	JScrollPane jsp;
	private JTextField module;
	JScrollPane ljsp;
	String Mode = "I";
	JButton btnDel;
	private JTextField no;
	private JTextField parameter;
	private JTextField value;
	JPasswordField mycode = new JPasswordField();
	JComboBox option;
	JInternalFrame internalFrame;
	JTextArea description;

	JButton btnSave;
	JButton btnClose;

	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2 || column == 3) {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			} else {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}
			return componentt;

		}
	};

	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			// 2 4 6 7 8 9 10 14 15 16 19
			return column == 0 || column == 1 || column == 2 || column == 3 ? false : true;
		}

	};
	private JButton btnUpload;
	private JTextField maxno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateConfiguation window = new CreateConfiguation();
					window.Configframe.setVisible(true);
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
	public CreateConfiguation() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		Configframe = new JFrame();
		Configframe.setTitle("Meretoo Product Configuration");
		Configframe.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CreateConfiguation.class.getResource("/RetailProduct/mymain.png")));
		Configframe.setResizable(false);
		Configframe.setAlwaysOnTop(true);
		Configframe.setBounds(0, 1, 1350, 616);
		Configframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Configframe.getContentPane().setLayout(null);

		internalFrame = new JInternalFrame(" ");
		internalFrame.setBounds(0, 0, 1332, 616);
		Configframe.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		option = new JComboBox();
		option.setBounds(12, 28, 186, 22);
		internalFrame.getContentPane().add(option);

		JLabel lblNewLabel = new JLabel("Select Type");
		lblNewLabel.setBounds(12, 13, 136, 16);
		internalFrame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 63, 862, 140);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Module");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_1.setBounds(12, 13, 56, 16);
		panel.add(lblNewLabel_1);

		module = new JTextField();
		module.setBounds(74, 10, 133, 33);
		panel.add(module);
		module.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("No");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_2.setBounds(12, 48, 56, 16);
		panel.add(lblNewLabel_2);

		no = new JTextField();
		no.setBounds(74, 45, 133, 33);
		panel.add(no);
		no.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Parameter");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_3.setBounds(12, 76, 60, 16);
		panel.add(lblNewLabel_3);

		parameter = new JTextField();
		parameter.setBounds(74, 75, 252, 33);
		panel.add(parameter);
		parameter.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Value");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setFont(new Font("Calibri", Font.BOLD, 13));
		lblNewLabel_4.setBounds(12, 111, 56, 16);
		panel.add(lblNewLabel_4);

		value = new JTextField();
		value.setBounds(74, 108, 252, 32);
		panel.add(value);
		value.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(336, 0, 533, 140);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Description");
		lblNewLabel_5.setBounds(0, 0, 77, 16);
		panel_1.add(lblNewLabel_5);

		description = new JTextArea();
		description.setBounds(10, 25, 496, 102);
		panel_1.add(description);
		panel.setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { module, no, parameter, value, description }));

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 239, 1314, 302);
		internalFrame.getContentPane().add(jsp);

		btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(459, 203, 97, 38);
		internalFrame.getContentPane().add(btnSave);

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(640, 203, 97, 38);
		internalFrame.getContentPane().add(btnClose);

		btnDel = new JButton("Delete");
		btnDel.setMnemonic('D');
		btnDel.setBounds(553, 203, 90, 38);
		internalFrame.getContentPane().add(btnDel);

		btnUpload = new JButton("Upload Config Data");
		btnUpload.setVisible(false);
		btnUpload.setMnemonic('U');
		btnUpload.setBounds(732, 203, 142, 38);
		internalFrame.getContentPane().add(btnUpload);
		
		JLabel lblNewLabel_6 = new JLabel("Max Parameter No :");
		lblNewLabel_6.setBounds(266, 31, 136, 16);
		internalFrame.getContentPane().add(lblNewLabel_6);
		
		maxno = new JTextField();
		maxno.setFont(new Font("Tahoma", Font.BOLD, 15));
		maxno.setBounds(399, 28, 116, 25);
		internalFrame.getContentPane().add(maxno);
		maxno.setColumns(10);
		internalFrame.setVisible(true);
		ActionListener btn = new btnLsnr();
		btnClose.addActionListener(btn);
		btnSave.addActionListener(btn);
		btnDel.addActionListener(btn);
		btnUpload.addActionListener(btn);

		validateUser();
		ActionListener optn = new optionLsnr();
		option.addActionListener(optn);

	}

	private void validateUser() {
		String action = "Sucess";
		JPanel panel = new JPanel();
		mycode.setBackground(Color.WHITE);
		mycode.setFont(new Font("Calibri", Font.BOLD, 13));
		mycode.setBounds(1, 2, 275, 23);
		panel.add(mycode);
		mycode.setColumns(10);
		ActionListener cb = new codeLsnr();
		mycode.addActionListener(cb);
		mycode.grabFocus();
		panel.setBackground(Color.black);
		new General().msgPanel(panel, "Enter Config Key Code", 50, 50);
		panel.setVisible(true);
		mycode.grabFocus();
	}

	class codeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String value = mycode.getText();
			new General().msgDispose();
			switch (value) {
			case "123321":
				try {
					decorate();
				} catch (Throwable e) {
					new General().msg(e.getMessage());
				}
				break;
			}
		}
	}

	private void decorate() throws Throwable {

		
		String SQL = "Select Max(no) from ms_configuration_master" ;
		String vmaxno = "0" ;
		rs = this.getSPResult(SQL);
		if (rs.next())
		{
			vmaxno = rs.getString(1);
			maxno.setText(vmaxno);
		}
	
		
		new gnApp().setFrameTitel(Configframe);
		new gnField().closeform(internalFrame, Configframe);
		internalFrame.setTitle("Create OR Edit  Configuration Parameter");

		new gnDecorate().decorateBtn(btnUpload, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnClose, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnSave, new Color(10, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnDel, new Color(120, 151, 112), Color.WHITE);

		new gnStyleButtonSqr().getStyleButton(btnUpload, new Color(178, 11, 112), Color.WHITE);
		new gnStyleButtonSqr().getStyleButton(btnClose, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnSave, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnDel, new Color(56, 189, 112), Color.BLACK);

		SQL = "call config_getDistinctconfig()";
		try {
			new gnComp().fillCombo(SQL, option);
		} catch (ClassNotFoundException | SQLException e) {
			new General().msg(e.getMessage());
		}
	}

	class optionLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = option.getSelectedItem().toString();
			String SQL = "call  Config_getDefaultconfig('" + value + "')";
			try {
				refresh();
				module.setText(value);
				showConfig(SQL);
			} catch (ClassNotFoundException | SQLException e1) {
				new General().msg(e1.getMessage());
			}

		}
	}

	private void showConfig(String SQL) throws ClassNotFoundException, SQLException {
		btnSave.setEnabled(true);
		String[] Col = { " Module", "Config.No", "Parameter", "Default Value", "Set Value", "Description" };
		model.setColumnIdentifiers(Col);
		new gnTable().RemoveTableRows(model);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6) });
			table.setModel(model);
			new gnTable().setTableBasics(table);

		}

		new gnTable().setTableColWidth(table, 0, 100);
		new gnTable().setTableColWidth(table, 1, 60);
		new gnTable().setTableColWidth(table, 2, 200);
		new gnTable().setTableColWidth(table, 3, 300);
		new gnTable().setTableColWidth(table, 4, 300);

		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.CYAN);
		prt1.add(table);
		prt1.setVisible(true);
		jsp.setViewport(prt1);
		Selectrow();

	}

	public void Selectrow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value1 = (String) table.getValueAt(row, 0);
				try {
					module.setText(table.getValueAt(row, 0).toString());
					no.setText(table.getValueAt(row, 1).toString());
					parameter.setText(table.getValueAt(row, 2).toString());
					value.setText(table.getValueAt(row, 4).toString());
					description.setText(table.getValueAt(row, 5).toString());
					module.setEnabled(false);
					no.setEnabled(false);
					Mode = "U";
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Upload Config Data") {
				try {
					startUploadProcess();
				} catch (FileNotFoundException | SQLException e1) {
					new General().msg(e1.getLocalizedMessage());
				}
			}

			if (value == "Delete") {
				try {
					RemoveConfig();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Save") {
				if (no.getText().length() > 0) {
					switch (Mode) {
					case "U":
						try {
							UpdateConfig();
						} catch (ClassNotFoundException | SQLException | IOException e1) {
							new General().msg(e1.getMessage());
						}
						break;

					case "I":
						try {
							SaveNewConfig();
						} catch (ClassNotFoundException | SQLException | IOException e1) {
							new General().msg(e1.getMessage());
						}
						break;

					/*
					 * case "F": try { //RemoveAllConfig() ;
					 * //UploadConfigfile(); } catch (ClassNotFoundException |
					 * SQLException | IOException e1) { new
					 * General().msg(e1.getMessage()); } break;
					 */

					}
				}
			}

			if (value == "Close") {
				Configframe.dispose();
			}

		}
	}

	private void startUploadProcess() throws FileNotFoundException, SQLException {

		Mode = "F";
		String vfile = null;
		String status = "Sucess";
		vfile = new gnFile().getFile(jsp);
		if (vfile.isEmpty()) {
			status = "Fail";
			return;
		}
		String vtype = "Configuration";
		try {
			if (status == "Sucess") {
				new General().msg("Selected File  is" + " " + vfile);
				RemoveAllConfig();
				new ImportCsv().readCsvUsingLoad(vtype, vfile);
			} else {
				new General().msg("No File Selected Please Select File ...");
			}
		} catch (ClassNotFoundException | IOException e) {
			new General().msg(e.getMessage());
		}
		try {
			decorate();
		} catch (Throwable e) {
			new General().msg(e.getLocalizedMessage());
		}
	}

	private String RemoveConfig() throws SQLException, ClassNotFoundException, IOException {
		String status = "Sucess";
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String updconfig = " Delete from  ms_configuration_master   where  " + "no = ? ";
		try {
			prst = con1.prepareStatement(updconfig);
			prst.setString(1, no.getText().trim());
			prst.addBatch();
			// new General().msg("PRST"+" "+prst);
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con1.commit();
			}
			prst.executeBatch(); // insert remaining records
			con1.commit();
			status = "Sucess";
		} catch (SQLException e) {
			new General().msg("error:" + e.getMessage());
			con1.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (status == "Sucess") {
				new General().msg("Record Removed Sucessfully");
				refresh();
			}
			if (con1 != null) {
				con1.close();
			}
		}
		return status;
	}

	private String RemoveAllConfig() throws SQLException, ClassNotFoundException, IOException {
		// new General().msg("REmove is REached..");
		String status = "Sucess";
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		// this.closeconn();
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String updconfig = " Delete from  ms_configuration_master  ";
		try {
			prst = con1.prepareStatement(updconfig);
			// prst.setString(1 , no.getText().trim());
			prst.addBatch();
			new General().msg("PRST" + " " + prst);
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con1.commit();
			}
			prst.executeBatch(); // insert remaining records
			con1.commit();
			status = "Sucess";
		} catch (SQLException e) {
			new General().msg("error:" + e.getMessage());
			con1.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (status == "Sucess") {
				UploadConfigfile();
			}
			if (con1 != null) {
				con1.close();
			}
		}
		return status;
	}

	private String UpdateConfig() throws SQLException, ClassNotFoundException, IOException {
		String status = "Sucess";
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String updconfig = " Update  ms_configuration_master   set  "
				+ "value = ?, parameter = ?   , Description = ? where module =  ? and no = ? ";
		try {
			prst = con1.prepareStatement(updconfig);
			prst.setString(1, value.getText());
			prst.setString(2, parameter.getText());
			prst.setString(3, description.getText());
			prst.setString(4, module.getText().trim());
			prst.setString(5, no.getText().trim());
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				// new General().msg("PRST"+' '+prst);
				prst.executeBatch();
				status = "Sucess";
				con1.commit();
			}
			// new General().msg("PRST"+' '+prst);
			prst.executeBatch(); // insert remaining records
			con1.commit();
			status = "Sucess";
		} catch (SQLException e) {
			new General().msg("error:" + e.getMessage());
			con1.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (status == "Sucess") {
				new General().msg("Configuration Updated Sucessfully");
				refresh();
			}
			if (con1 != null) {
				con1.close();
			}
		}
		return status;
	}

	private String UploadConfigfile() throws SQLException, ClassNotFoundException, IOException {
		String status = "Sucess";
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String Status = "Fail";
		String poshdr = "Insert into ms_configuration_master( module , no, "
				+ " parameter ,  default_value, value,  description) " + "values(?,?,?,?,?,?)";
		try {
			int row = table.getRowCount();
			for (int i = 0; i < row; i++) {
				prst = con1.prepareStatement(poshdr);
				prst.setString(1, table.getValueAt(i, 0).toString());
				prst.setString(2, table.getValueAt(i, 1).toString());
				prst.setString(3, table.getValueAt(i, 2).toString());
				prst.setString(4, table.getValueAt(i, 3).toString());
				prst.setString(5, table.getValueAt(i, 4).toString());
				// prst.setString(6 , table.getValueAt(i, 5).toString() );
				prst.setString(6, table.getValueAt(i, 6).toString());

				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				status = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					status = "Sucess";
					con1.commit();
				}
				prst.executeBatch(); // insert remaining records
				con1.commit();
			}
		} catch (SQLException e) {
			new General().msg("Configuration 23303" + e.getMessage());
			con1.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
				new gnTable().RemoveTableRows(model);
			}
			if (status == "Sucess") {
				new General().msg("Configuration Saved Sucessfully");
			}
			if (con1 != null) {
				con1.close();
			}
		}
		return status;
	}

	private String SaveNewConfig() throws SQLException, ClassNotFoundException, IOException {
		String status = "Sucess";
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String Status = "Fail";
		String poshdr = "Insert into ms_configuration_master(module, no , "
				+ "parameter ,  default_value, value,   Description) " + "values(?,?,?,?,?,?)";
		try {
			prst = con1.prepareStatement(poshdr);
			prst.setString(1, module.getText().trim());
			prst.setString(2, no.getText());
			prst.setString(3, parameter.getText());
			prst.setString(4, value.getText());
			prst.setString(5, value.getText());
			// prst.setString(6 , "Y");
			prst.setString(6, description.getText().trim());
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con1.commit();
			}
			prst.executeBatch(); // insert remaining records
			con1.commit();
		} catch (SQLException e) {
			new General().msg("Header " + e.getMessage());
			con1.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
				new gnTable().RemoveTableRows(model);
			}
			if (status == "Sucess") {
				new General().msg("New Parameter Added Sucessfully");
				refresh();
			}
			if (con1 != null) {
				con1.close();
			}
		}
		return status;
	}

	private void refresh() {
		Mode = "I";
		module.setEnabled(true);
		no.setEnabled(true);
		new gnTable().RemoveTableRows(model);
		module.setText(null);
		no.setText(null);
		parameter.setText(null);
		value.setText(null);
		description.setText(null);

	}
}// Last

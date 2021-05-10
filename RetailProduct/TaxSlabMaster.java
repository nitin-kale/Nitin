package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultCellEditor;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.SwingConstants;

public class TaxSlabMaster extends getResultSet {

	JFrame taxSlabFrame;
	private JTextField verticle;
	private JTextField verticlename;

	JScrollPane jsp;
	JButton btnSave;
	JButton btnClose;
	JButton btnAdd;

	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	private JTextField record;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaxSlabMaster window = new TaxSlabMaster();
					window.taxSlabFrame.setVisible(true);
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
	public TaxSlabMaster() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		taxSlabFrame = new JFrame();
		taxSlabFrame.setAlwaysOnTop(true);
		taxSlabFrame.getContentPane().setBackground(new Color(0, 255, 204));
		taxSlabFrame.setBounds(370, 200, 450, 300);
		taxSlabFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		taxSlabFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Verticle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 47, 56, 16);
		taxSlabFrame.getContentPane().add(lblNewLabel);

		verticle = new JTextField();
		verticle.setEditable(false);
		verticle.setBounds(62, 44, 45, 25);
		taxSlabFrame.getContentPane().add(verticle);
		verticle.setColumns(10);

		verticlename = new JTextField();
		verticlename.setForeground(new Color(0, 0, 102));
		verticlename.setFont(new Font("Tahoma", Font.BOLD, 14));
		verticlename.setBounds(108, 44, 198, 25);
		taxSlabFrame.getContentPane().add(verticlename);
		verticlename.setColumns(10);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 72, 432, 138);
		taxSlabFrame.getContentPane().add(jsp);

		btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(167, 217, 97, 25);
		taxSlabFrame.getContentPane().add(btnSave);

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(264, 217, 97, 25);
		taxSlabFrame.getContentPane().add(btnClose);

		btnAdd = new JButton("Add Record");
		btnAdd.setMnemonic('A');
		btnAdd.setBounds(306, 45, 114, 25);
		taxSlabFrame.getContentPane().add(btnAdd);

		JLabel lblNewLabel_1 = new JLabel("Records");
		lblNewLabel_1.setBounds(32, 220, 56, 16);
		taxSlabFrame.getContentPane().add(lblNewLabel_1);

		record = new JTextField();
		record.setEditable(false);
		record.setBounds(85, 217, 56, 22);
		taxSlabFrame.getContentPane().add(record);
		record.setColumns(10);

		lblNewLabel_2 = new JLabel("Slab Wise Tax Management");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 432, 25);
		taxSlabFrame.getContentPane().add(lblNewLabel_2);

		ActionListener btn = new btnLsnr();
		btnSave.addActionListener(btn);
		btnAdd.addActionListener(btn);
		btnClose.addActionListener(btn);

		ActionListener vertnm = new vertLsner();
		verticlename.addActionListener(vertnm);

		decorate();

	}

	// Start Coding Here

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(taxSlabFrame);
		verticle.setText(new gnHierarchy().getVerticleCode());
		verticlename.setText(new gnHierarchy().getVerticleName());
	}

	class vertLsner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String vname = "Verticle";
				new gnAdmin().showMasterTable(vname, verticle, verticlename);
				show();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String value = e.getActionCommand();

			if (value == "Add Record") {
				addRecord();
			}

			if (value == "Close") {
				taxSlabFrame.dispose();

			}

			if (value == "Save") {
				String status = validate();
				if (status == "Sucess") {
					try {
						SaveAction();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

		}
	}

	private void addRecord() {
		String col[] = { "Remove", "From-Amt", "To-Amt", "Tax%", };
		model.setColumnIdentifiers(col);
		model.addRow(new Object[] { "Del ", " ", " ", " " });
		table.setModel(model);
		table.setGridColor(Color.yellow);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setSelectionBackground(Color.BLUE);
		table.setSelectionForeground(Color.WHITE);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JViewport prt = new JViewport();
		prt.add(table, col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		jsp.setVisible(true);
		removeRow(model, table);
	}

	private String validate() {
		String status = "Sucess";
		int row = table.getRowCount();
		if (row == 0) {
			status = "Fail";
			new General().msg("No Data Available ...Please Check ");
		}

		if (verticle.getText().length() == 0) {
			status = "Fail";
			new General().msg("Select Verticle.. ");
			verticlename.grabFocus();
		}

		return status;
	}

	public void show() throws ClassNotFoundException, SQLException {
		String vverticle = verticle.getText();
		String vtype = "Show";
		String col[] = { "Remove", "From-Amt", "To-Amt", "Tax%", };
		model.setColumnIdentifiers(col);
		String SQL = " call taxSlab_DataManagement(" + vverticle + "   , '" + vtype + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {

			model.addRow(new Object[] { "Del ", rs.getString(1), rs.getString(2), rs.getString(3) });
			table.setModel(model);
		}

		table.setGridColor(Color.yellow);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setSelectionBackground(Color.BLUE);
		table.setSelectionForeground(Color.WHITE);
		JViewport prt = new JViewport();
		prt.add(table, col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		jsp.setVisible(true);
		removeRow(model, table);

	}

	private void SaveAction() throws ClassNotFoundException, SQLException, IOException {
		String vverticle = verticle.getText();

		String vtype = "Delete";
		String SQL = " call taxSlab_DataManagement(" + vverticle + "   , '" + vtype + "')";
		this.getSPResult(SQL);
 		//
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);

		String hie = "Insert into ms_TaxSlab_Master(verticle," + " Name , fromamt ,  toamt , taxcode) "
				+ "values(?,?,?,?,?)";
 		int row = table.getRowCount();
 			try {
  			for (int i = 0; i < row; i++) 
 			{

 				prst = con.prepareStatement(hie);
				prst.setString(1, verticle.getText());
				prst.setString(2, verticlename.getText());
				prst.setString(3, table.getValueAt(i, 1).toString().trim());
				prst.setString(4, table.getValueAt(i, 2).toString().trim());
				prst.setString(5, table.getValueAt(i, 3).toString().trim());
				prst.addBatch();
				//new General().msg("Prst" + " " + prst);
				TotalRecordinsert = TotalRecordinsert + 1;
				status = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					status = "Sucess";
					con.commit();
				}
				prst.executeBatch(); // insert remaining records
				con.commit();
				status = "Sucess";
 			}
 			} catch (SQLException e) {
				new General().msg(e.getMessage() + "<: Tax Slab Entry Level>");
				con.rollback();
				status = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
				}
				if (con != null) {
					con.close();
				}
			}

			if (status == "Sucess") {
				new General().msg(" Data Save Sucessfully");
			}
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
		new gnLogger().loggerInfoEntry("TaxSlab", "Remove Item From TAxSlab Table  ");
		Del.setCellRenderer(new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Del.setCellEditor(new DefaultCellEditor(chkbox));
				return chkbox;
			}
		});

		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int nn = e.getStateChange();
				if (nn == 2 && modelName == model) {
					int lastrow = tableName.getRowCount();
					if (lastrow > 0) {
						int r = tableName.getSelectedRow();
						int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
						if (option == 0) {
							if (vauthallow == "Y") {
								Authorize window = new Authorize();
								window.frameauth.setVisible(true);
								window.frameauth.setAlwaysOnTop(true);
								modelName.removeRow(r);
								new gnLogger().loggerInfoEntry("POS", "Remove Item From Sales Table  Row" + " " + r);
							}
							modelName.removeRow(r);
							int vcount = table.getRowCount();
							record.setText(Integer.toString(vcount));
							new gnLogger().loggerInfoEntry("POS",
									"Recalculating Billing Data After Row Remove Row No" + " " + r);
							new gnLogger().loggerInfoEntry("POS", "Article Billing Process Over");
						}
					}
					return;
				}
				if (modelName == model && nn == 2) {
					int option = new General().msgInput(" Payment Row Will be Deleted Are You Sure ?");

					if (option == 0) {
						int q = tableName.getSelectedRow();
						modelName.removeRow(q);
					}
					return;
				}
				return;
			}
		});
	}

}// Last

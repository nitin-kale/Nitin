package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window.Type;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class ms_Master_table_view extends getResultSet {
	public JTable Xtable;
	public JTable table;

	JScrollPane Jsp5 = new JScrollPane();
	public String col[] = { "Master_name", "Sub_category", "Category" };
	public String value;
	public DefaultTableModel catmodel = new DefaultTableModel();
	public String cat[] = { "Click to Select" };
	public DefaultTableModel Xmodel;
	public DefaultTableModel subcatmodel = new DefaultTableModel();
	public String subcat[] = { "Select <SubCategory>" };
	DefaultTableModel mastermodel = new DefaultTableModel();
	String masterName[] = { "Select <Master>" };

	public DefaultTableModel datamodel = new DefaultTableModel();
	public String col5[] = { "Master_name", "code", "Description", "Parent_Ref1", "ShowAllow", "Active" };

	public JTable cattable = new JTable();
	public JTable datatable = new JTable() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 1 || column == 2 || column == 3 || column == 4 || column == 5 || column == 6
					|| column == 7 || column == 8 ? false : true;
		}
	};

	public JScrollPane jsp1;

	public JViewport prt = new JViewport();
	public JViewport prt1 = new JViewport();
	public JViewport prt5 = new JViewport();
	public JViewport xprt;
	JFrame MasterTableFrame;
	public JPanel subcatpanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ms_Master_table_view window = new ms_Master_table_view();
					window.MasterTableFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ms_Master_table_view() throws SQLException, ClassNotFoundException {
		initialize();
	}

	private void initialize() throws SQLException, ClassNotFoundException {
		MasterTableFrame = new JFrame();
		MasterTableFrame.setType(Type.POPUP);
		MasterTableFrame.setResizable(false);
		MasterTableFrame.setTitle("Business Application");
		MasterTableFrame.setBounds(50, 100, 1044, 600);
		MasterTableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		MasterTableFrame.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(00, 00, 1100, 600);
		MasterTableFrame.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Matable Table View ");
		internalFrame.setBounds(0, 0, 1037, 600);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel CatPanel = new JPanel();
		CatPanel.setBounds(0, 13, 243, 499);
		internalFrame.getContentPane().add(CatPanel);
		CatPanel.setLayout(null);

		JScrollPane jsp1 = new JScrollPane();
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setViewportBorder(new MatteBorder(1, 1, 2, 2, (Color) Color.green));
		jsp1.setBounds(0, 0, 244, 499);
		CatPanel.add(jsp1);
		internalFrame.setVisible(true);

		// Category Display
		String SQL = "call master.getAllMasterName()";
		displayCategory(catmodel, cattable, SQL);
		JViewport prt = new JViewport();
		if (cattable.getRowCount() > 0) {
			showTable(cattable, prt, jsp1);
			prt.add(cattable, cat);
		}

		JPanel DataPanel = new JPanel();
		DataPanel.setBounds(246, 13, 785, 499);
		internalFrame.getContentPane().add(DataPanel);
		DataPanel.setLayout(null);

		Jsp5 = new JScrollPane();
		Jsp5.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Jsp5.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		Jsp5.setBounds(0, 0, 773, 499);
		DataPanel.add(Jsp5);
		Jsp5.setViewport(prt5);
		prt5.add(datatable, col5);
	}

	// ==============Show All MasterName
	public void displayCategory(DefaultTableModel Xmodel, JTable Xtable, String SQL)
			throws SQLException, ClassNotFoundException {
		Xmodel.setColumnIdentifiers(col);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			Xmodel.addRow(new Object[] { rs.getString(1), rs.getString(3), rs.getString(3) });
		}
		Xtable.setModel(Xmodel);
		new gnTable().setTablewidth(Xtable, 0, 60);
		Xtable.setCellSelectionEnabled(true);
	}

	public void showTable(JTable Xtable, JViewport xprt, JScrollPane xjsp) {
		xjsp.setViewportView(xprt);
		xprt.setBackground(Color.cyan);
		xprt.setVisible(true);
		Xtable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
		DefaultCellEditor nk = new gnTable().cellEdit(Xtable);
		nk.addCellEditorListener(ChangeNotification);
		Xtable.setBackground(Color.white);

	}

	// ==========================Show Details for dataTable =====
	public void showDataTable(JTable datatable, JViewport xprt, JScrollPane Jsp5) {
		prt5.setBackground(Color.cyan);
		prt5.setVisible(true);
		new gnTable().setTablewidth(datatable, 0, 10);
		// datatable.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
		DefaultCellEditor nk = new gnTable().cellEdit(datatable);
		nk.addCellEditorListener(ChangeNotification);

		prt5.add(datatable, col5);
		new gnTable().setTableMarginHeight(datatable, 22, 1);
		new gnTable().setTableColWidth(datatable, 0, 105);
	}

	public void displayData(DefaultTableModel Xmodel, JTable Xtable, String SQL)
			throws SQLException, ClassNotFoundException { // String col5[] =
															// {"Master_name",
															// "code",
															// "Description",
															// "Parent_Ref1" ,
															// "ShowAllow" ,
															// "Active" } ;
		Xmodel.setColumnIdentifiers(col5);
		rs = this.getSPResult(SQL);
		rs.first();
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			Xmodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6) });
		}
		Xtable.setModel(Xmodel);
		Xtable.setCellSelectionEnabled(true);
		// System.out.println(Xmodel.getDataVector());
		return;
	}

	public void callDataPart(String value) throws SQLException, ClassNotFoundException {
		String SQL16 = "call master.getAllMasterDetail('" + value + "')";
		int row = datatable.getRowCount();
		if (row > 0) {
			new gnTable().RemoveTableRows(datamodel);
		}
		displayData(datamodel, datatable, SQL16);
		showDataTable(datatable, prt5, Jsp5);
	}

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
		}

		public void editingStopped(ChangeEvent e) {
			int row = cattable.getSelectedRow();
			value = (String) cattable.getValueAt(row, 0);
			try {
				callDataPart(value);
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

}// last

package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class Schema_viewer extends getResultSet {

	JFrame Schemaframe;

	private JProgressBar prgbar;
	private JButton btnAll;
	private JButton btnOne;
	private JButton btnExport;
	private JButton btnExecute;
	JComboBox comboBox;

	private JComboBox type;
	private JComboBox operator;
	private JComboBox left;
	private JComboBox right;
	private String ncol[];
	private HashMap hm = new HashMap();
	private JScrollPane jsp;
	private JScrollPane pjsp;
	private JScrollPane sjsp;
	private String vcomp;
	private String vstore;
	private String QueryString = "";
	private String FinalQueryString = "";
	private String FinalQuery = "";
	private JLabel disptablename;

	private ResultSet rs, rs1, rs2, rs3;
	private String XColString[] = null;
	private String jspcol[] = { "Name" };
	private String pjspcol[] = { "Name" };
	private String sjspcol[] = { "Remove", "Selected Column Name" };

	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 ? true : false;
		}
	};

	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0) {
				componentt.setBackground(Color.cyan);
				componentt.setForeground(Color.BLACK);
				// componentt.setBackground(Color.WHITE);
				// componentt.setForeground(Color.BLUE);
				// componentt.setCursor(getCursor());
			}
			return componentt;
		}
	};

	public DefaultTableModel pmodel = new DefaultTableModel();
	public JTable ptable = new JTable();

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();

	public DefaultTableModel qmodel = new DefaultTableModel();
	public JTable qtable = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schema_viewer window = new Schema_viewer();
					window.Schemaframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Schema_viewer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Schemaframe = new JFrame();
		Schemaframe.setBounds(1, 0, 1358, 768);
		Schemaframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Schemaframe.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 51, 153));
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 1346, 27);
		Schemaframe.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Dynamic Query  Builder");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 51, 153));
		lblNewLabel.setBounds(563, 6, 218, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Database");
		lblNewLabel_1.setBounds(10, 31, 55, 16);
		Schemaframe.getContentPane().add(lblNewLabel_1);

		comboBox = new JComboBox();
		comboBox.setBounds(67, 26, 106, 26);
		Schemaframe.getContentPane().add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("Type");
		lblNewLabel_2.setBounds(197, 31, 55, 16);
		Schemaframe.getContentPane().add(lblNewLabel_2);

		type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] { "Table", "Procudure", "View", "Function" }));
		type.setBounds(224, 26, 145, 26);
		ActionListener typ = new typeLsnr();
		type.addActionListener(typ);
		Schemaframe.getContentPane().add(type);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Select ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_1.setBounds(0, 59, 231, 265);
		Schemaframe.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(6, 16, 219, 243);
		panel_1.add(jsp);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(234, 59, 335, 265);
		Schemaframe.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		pjsp = new JScrollPane();
		pjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pjsp.setBounds(6, 6, 323, 253);
		panel_2.add(pjsp);

		btnOne = new JButton(">");
		btnOne.setBounds(581, 115, 55, 28);
		ActionListener btn = new btnLsnr();
		btnOne.addActionListener(btn);
		Schemaframe.getContentPane().add(btnOne);

		btnAll = new JButton(">>");
		btnAll.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAll.setBounds(581, 155, 55, 28);
		btnAll.addActionListener(btn);
		Schemaframe.getContentPane().add(btnAll);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(647, 59, 477, 265);
		Schemaframe.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		sjsp = new JScrollPane();
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(6, 6, 465, 253);
		panel_3.add(sjsp);

		JPanel condition = new JPanel();
		condition.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		condition.setBounds(0, 326, 1334, 46);
		Schemaframe.getContentPane().add(condition);
		condition.setLayout(null);

		left = new JComboBox();
		left.setBackground(Color.WHITE);
		left.setMaximumRowCount(40);
		left.setBounds(6, 6, 357, 26);
		condition.add(left);

		operator = new JComboBox();
		operator.setModel(new DefaultComboBoxModel(new String[] { "=", ">", "<", ">=", "<=" }));
		operator.setBounds(393, 6, 72, 26);
		condition.add(operator);

		right = new JComboBox();
		right.setBackground(Color.WHITE);
		right.setBounds(477, 6, 357, 26);
		condition.add(right);

		btnShow = new JButton("Show Query");
		btnShow.addActionListener(btn);
		btnShow.setBounds(873, 12, 131, 28);
		condition.add(btnShow);

		btnExecute = new JButton("Execute Query");
		btnExecute.addActionListener(btn);
		btnExecute.setBounds(1007, 12, 112, 28);
		condition.add(btnExecute);

		btnExport = new JButton("Export To Excel");
		btnExport.addActionListener(btn);
		btnExport.setBounds(1117, 12, 127, 28);
		condition.add(btnExport);

		btnClose = new JButton("Close");
		btnClose.addActionListener(btn);
		btnClose.setBounds(1244, 12, 90, 28);
		condition.add(btnClose);

		btnLone = new JButton("<");
		btnLone.addActionListener(btn);
		btnLone.setBounds(581, 195, 55, 28);
		Schemaframe.getContentPane().add(btnLone);

		btnLall = new JButton("<<");
		btnLall.addActionListener(btn);
		btnLall.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnLall.setBounds(581, 235, 55, 28);
		Schemaframe.getContentPane().add(btnLall);

		dataPanel = new JPanel();
		dataPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dataPanel.setBounds(10, 384, 1324, 333);
		Schemaframe.getContentPane().add(dataPanel);
		dataPanel.setLayout(null);

		qjsp = new JScrollPane();
		qjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		qjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qjsp.setBounds(6, 6, 1312, 321);
		dataPanel.add(qjsp);

		tfield = new JTextField();
		tfield.setBounds(736, 25, 122, 28);
		Schemaframe.getContentPane().add(tfield);
		tfield.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Fields");
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_3.setBounds(860, 31, 70, 16);
		Schemaframe.getContentPane().add(lblNewLabel_3);

		btnFrame = new JButton("Frames");
		btnFrame.setBounds(1141, 59, 90, 28);
		btnFrame.setVisible(false);
		Schemaframe.getContentPane().add(btnFrame);

		prgbar = new JProgressBar();
		prgbar.setBounds(1136, 286, 198, 19);
		Schemaframe.getContentPane().add(prgbar);

		disptablename = new JLabel("..");
		disptablename.setBackground(new Color(102, 255, 255));
		disptablename.setForeground(new Color(0, 0, 102));
		disptablename.setBounds(381, 31, 311, 16);
		Schemaframe.getContentPane().add(disptablename);
		try {
			decorate();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(Schemaframe);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		comboBox.addItem(this.dbname);
	}

	// Btn Press Action ========
	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Frames") {
				showFrames();
			}

			if (value == "Close") {
				new gnTable().RemoveTableRows(model);
				new gnTable().RemoveTableRows(pmodel);
				new gnTable().RemoveTableRows(smodel);
				new gnTable().RemoveTableRows(qmodel);
				left.removeAllItems();
				right.removeAllItems();
				tfield.setText("");
			}

			if (value == "Show Query") {
				Formquery();
				try {
					new showHelp().showHelp(FinalQueryString, "Check Query");
					// new showHelp().showEdtHelp(FinalQueryString, "Check
					// Query");
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Execute Query") {
				Formquery();
				try {
					showQuery(XColString);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

			
			
			if (value == "Export To Excel") {
				new Export_Table_Data_to_Excel().exportTable(qtable);
			}

			if (value == ">") {
				processBtnoneAction();
				int vcol = new gnTable().getRowCount(stable);
				tfield.setText(Integer.toString(vcol));
				prgbar.setValue(vcol);
			}

			if (value == ">>") {
				processBtnAllAction();
				int vcol = new gnTable().getRowCount(stable);
				tfield.setText(Integer.toString(vcol));
				prgbar.setValue(vcol);

			}

			if (value == "<") {
				int r = stable.getSelectedRow();
				smodel.removeRow(r);
				int vcol = new gnTable().getRowCount(stable);
				tfield.setText(Integer.toString(vcol));
				prgbar.setValue(vcol);

			}
			if (value == "<<") {
				new gnTable().RemoveTableRows(smodel);
				new gnTable().RemoveTableRows(pmodel);
				QueryString = " ";
				FinalQueryString = " ";
				hm.clear();
				left.removeAllItems();
				right.removeAllItems();
				int vcol = new gnTable().getRowCount(stable);
				tfield.setText(Integer.toString(vcol));
				prgbar.setValue(vcol);
			}
		}
	}

	private void showFrames() {
		// Collect all active frames in a array
		Frame[] activeframes = Frame.getFrames();

		for (int i = 0; i < activeframes.length; i++) {
			String title = activeframes[i].getTitle();
			smodel.addRow(new Object[] { "X ", title });
			boolean isVisible = activeframes[i].isVisible();
			smodel.setColumnIdentifiers(sjspcol);
			stable.setModel(smodel);
			stable.setModel(smodel);
			JViewport prt11 = new JViewport();
			prt11.add(stable, sjspcol);
			sjsp.setViewport(prt11);
			sjsp.setVisible(true);
			stable.setRowHeight(25);
			new gnTable().setTablewidth(stable, 0, 5);
			new gnTable().setTablewidth(stable, 1, 300);
		}
	}

	private void processBtnoneAction() {
		String vtablename = table.getValueAt(table.getSelectedRow(), 0).toString();
		hm.put(vtablename, "Table");
		String vfilename = ptable.getValueAt(ptable.getSelectedRow(), 0).toString();
		String vfield = vtablename + "." + vfilename;

		String status = new gnCheckArticle().checkArticleExist(stable, vfield, 1);

		if (status == "Sucess") {
			smodel.setColumnIdentifiers(sjspcol);
			stable.setModel(smodel);
			smodel.addRow(new Object[] { "X ", vfield });
			stable.setModel(smodel);
			JViewport prt11 = new JViewport();
			prt11.add(stable, sjspcol);
			sjsp.setViewport(prt11);
			sjsp.setVisible(true);
			stable.setRowHeight(25);
			new gnTable().setTablewidth(stable, 0, 5);
			new gnTable().setTablewidth(stable, 1, 300);
			left.addItem(vfield);
			right.addItem(vfield);
			right.setVisible(true);
			left.setVisible(true);
		}
	}

	private void processBtnAllAction() {
		new gnTable().RemoveTableRows(smodel);
		int row = ptable.getRowCount();
		String vtablename = table.getValueAt(table.getSelectedRow(), 0).toString();
		hm.put(vtablename, "Table");
		for (int i = 0; i < row; i++) {
			String vfilename = ptable.getValueAt(i, 0).toString();
			String vfield = vtablename + "." + vfilename;
			smodel.setColumnIdentifiers(sjspcol);
			stable.setModel(smodel);
			smodel.addRow(new Object[] { "X ", vfield });
			left.addItem(vfield);
			right.addItem(vfield);
			stable.setModel(smodel);
		}
		JViewport prt11 = new JViewport();
		prt11.add(stable, sjspcol);
		sjsp.setViewport(prt11);
		sjsp.setVisible(true);
		stable.setRowHeight(25);
		right.setVisible(true);
		left.setVisible(true);
		new gnTable().setTablewidth(stable, 0, 5);
		new gnTable().setTablewidth(stable, 1, 300);
	}

	private void Formquery() {
		FinalQueryString = " ";
		QueryString = " ";
		XColString = null;
		@SuppressWarnings("rawtypes")
		Vector<String> ColString = new Vector();
		ColString.removeAllElements();
		String Frombuilder = " From  ";
		String vtable = "";
		String vq = "Select   ";
  		int row = stable.getRowCount();
		for (int i = 0; i < row; i++) {
			if (i == 0) {
				QueryString = QueryString + " " + stable.getValueAt(i, 1);
			} else {
				QueryString = QueryString + " ," + stable.getValueAt(i, 1);
			}
			ColString.add(stable.getValueAt(i, 1).toString());

			/*
			 * if ( (row - i) == 1) { ColString.add( " ' " +stable.getValueAt(i,
			 * 1)+ " ' " ); } else { ColString.add( " ' "+stable.getValueAt(i,
			 * 1) + " ' ") ; }
			 */
		}

		FinalQueryString = vq + " " + QueryString;
		Set set = hm.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Entry) it.next();
			System.out.println(me.getKey() + ": value :" + me.getValue());
			vtable = me.getKey().toString();
			Frombuilder = Frombuilder + " " + vtable + "";
		}
		FinalQueryString = FinalQueryString + " " + Frombuilder;
		XColString = ColString.toArray(new String[ColString.size()]);
		new General().msg(FinalQueryString);
	}

	private void showQuery(String ColString[]) throws ClassNotFoundException, SQLException {

		int vcol = new gnTable().getRowCount(stable);
		tfield.setText(Integer.toString(vcol));
		new gnTable().RemoveTableRows(qmodel);
		String SQL = FinalQueryString;
		String[] qcol = { "Article", "Sales Priced", "MRP", "Cost" };
		String vtype = "Result ";
		qtable = new gnTableModel().Tablemodel(qtable, qmodel, SQL, ColString, vcol, "N", "N", vtype);
		qmodel.setColumnIdentifiers(ColString);
 		qtable.setRowHeight(25);
		qtable.setBackground(Color.white);
		qtable.setForeground(Color.BLUE);
		qtable.setModel(qmodel);
		JViewport prt17 = new JViewport();
		prt17.add(qtable, qcol);
		qjsp.setViewport(prt17);
		qjsp.setVisible(true);
		/// REset Values
		// hm.clear();
		left.removeAllItems();
		right.removeAllItems();
 	}

	// ==============Type ACtion Section
	class typeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vtype = type.getSelectedItem().toString();
			switch (vtype) {
			case "Table":
				try {
					TableAction();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case "Procedure":
				try {
					ProcedureAction();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;

			case "View":
				break;
			}

		}
	}

	private void ProcedureAction() throws SQLException, ClassNotFoundException, IOException {
		new gnTable().RemoveTableRows(model);
		rs = new TableInfo().getProcedure();
		model.setColumnIdentifiers(jspcol);
		table.setModel(model);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString("PROCEDURE_NAME") });
			table.setRowHeight(25);
			table.setBackground(Color.white);
			table.setForeground(Color.BLUE);
		}
		JViewport prt1 = new JViewport();
		prt1.add(table, jspcol);
		jsp.setViewport(prt1);
		jsp.setVisible(true);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification);
		rs.close();
	}

	private void TableAction() throws SQLException, ClassNotFoundException, IOException {
		new gnTable().RemoveTableRows(model);
		rs = new TableInfo().getTables();
		model.setColumnIdentifiers(jspcol);
		table.setModel(model);
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString(3) });
			table.setRowHeight(25);
			table.setBackground(Color.white);
			table.setForeground(Color.BLUE);
		}
		JViewport prt1 = new JViewport();
		prt1.add(table, jspcol);
		jsp.setViewport(prt1);
		jsp.setVisible(true);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification);
		rs.close();
	}

	public CellEditorListener ChangeNotification = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String tablename = (String) table.getValueAt(row, 0);
			try {
				showLevel2(tablename);
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
			try {
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	};

	private JButton btnShow;
	private JButton btnLone;
	private JButton btnLall;
	private JPanel dataPanel;
	private JScrollPane qjsp;
	private JTextField tfield;
	private JButton btnClose;
	private JButton btnFrame;

	private void showLevel2(String tablename) throws SQLException, ClassNotFoundException, IOException {

		new gnTable().RemoveTableRows(pmodel);
		rs1 = new TableInfo().getField(tablename);
		disptablename.setText(tablename);
		pmodel.setColumnIdentifiers(pjspcol);
		ptable.setModel(pmodel);
		while (rs1.next()) {
			pmodel.addRow(new Object[] { rs1.getString(4) });
			ptable.setRowHeight(25);
			ptable.setBackground(Color.white);
			ptable.setForeground(Color.BLUE);
		}
		JViewport prt2 = new JViewport();
		prt2.add(ptable, pjspcol);
		pjsp.setViewport(prt2);
		pjsp.setVisible(true);
		// DefaultCellEditor nk = new gnTable().cellEdit(ptable) ;
		// nk.addCellEditorListener(ChangeNotification1);
		rs1.close();
	}
}// Last

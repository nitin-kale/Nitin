package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

public class gnTable extends getResultSet {

	JFrame MessageFrame;
	JPanel panel;
	private JTable table;
	private JTable ptable;
	public DefaultTableModel model = new DefaultTableModel();
	public DefaultTableModel modelName;
	public JTable tableName;

	public JComponent setFontBold(JComponent myfield, int size) {
		// myButton.setFont(new Font("Agency FB", Font.BOLD, size));
		// myfield.setFont(new Font("Arial", Font.BOLD, 14));
		myfield.setFont(new Font("MS Gothic", Font.BOLD, size));
		myfield.setFont(new Font("Microsoft Sans Serif", Font.BOLD, size));
		myfield.setFont(new Font("Segoe UI Semibold", Font.BOLD, size));
		return myfield;
	}

	public JComponent setFont(JComponent myButton, int size) {
		// myButton.setFont(new Font("Arial", Font.PLAIN, size));
		myButton.setFont(new Font("MS Gothic", Font.PLAIN, size));
		myButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, size));
		myButton.setFont(new Font("Segoe UI Semibold", Font.PLAIN, size));

		return myButton;
	}

	public void setJSPBasic(JScrollPane jsp) {
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
	}

	public void setTableBasics(JTable table) {
		
		table.getTableHeader().setReorderingAllowed(false);
		table.setAutoCreateRowSorter(true);
 		JTableHeader tableHeader = table.getTableHeader();

 		new gnFontSetting().setMyFont(table, "F1", 11);
		table.setEnabled(true);
		table.changeSelection(0, 1, false, false);
 		table.setRowSelectionAllowed(true);
		table.setGridColor(Color.blue);
		table.setBackground(Color.WHITE);
		
		 table.setRowHeight(30);
	     table.setBackground(Color.white);
	     table.setForeground(Color.black);
 	     table.setOpaque(false);
 
 	     //table.getTableHeader().setDefaultRenderer(new gntableHeaderRend());
 	   
  	     tableHeader.updateUI();
	
	}

	private void decorateHeader(JTable table, int fontSize) {
		JTableHeader tableHeader = table.getTableHeader();
		Font font = new Font("Verdana", Font.BOLD, fontSize);
		table.setFont(font);
		tableHeader.setBackground(Color.WHITE);
		tableHeader.setForeground(Color.BLACK);
		tableHeader.setDoubleBuffered(true);
		tableHeader
				.setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, Color.DARK_GRAY, Color.GREEN, Color.BLUE));
		tableHeader.setFont(new Font("Agency FB", Font.PLAIN, fontSize));

	}

	private void decorateHeaderBold(JTable table, int fontSize) {
		JTableHeader tableHeader = table.getTableHeader();
		Font font = new Font("Verdana", Font.BOLD, fontSize);
		table.setFont(font);
		tableHeader.setBackground(Color.WHITE);
		tableHeader.setForeground(Color.BLACK);
		tableHeader.setDoubleBuffered(true);
		tableHeader
				.setBorder(new BevelBorder(BevelBorder.RAISED, Color.YELLOW, Color.DARK_GRAY, Color.GREEN, Color.BLUE));
		tableHeader.setFont(new Font("Agency FB", Font.BOLD, 16));
	}

	public void tableColumnAdjust(JTable table) {
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int column = 0; column < table.getColumnCount(); column++) {
			TableColumn tableColumn = table.getColumnModel().getColumn(column);
			int preferredWidth = tableColumn.getMinWidth();
			int maxWidth = tableColumn.getMaxWidth();

			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer cellRenderer = table.getCellRenderer(row, column);
				Component c = table.prepareRenderer(cellRenderer, row, column);
				int width = c.getPreferredSize().width + table.getIntercellSpacing().width;
				preferredWidth = Math.max(preferredWidth, width);

				// We've exceeded the maximum width, no need to check other rows

				if (preferredWidth >= maxWidth) {
					preferredWidth = maxWidth;
					break;
				}
			}

			tableColumn.setPreferredWidth(preferredWidth);
		}
	}

	public boolean isCellEditable(int row, int column) { // 2 4 6 7 8 9 10 14 15
															// 16

		return column == 2 || column == 4 || column == 6 || column == 7 || column == 8 || column == 9 || column == 10
				|| column == 14 || column == 15 || column == 16 || column == 20 ? true : false;
	}

	public void AssignToSelectdRow(JTable table, int row, int Col, String applyValue) {
		table.setValueAt(applyValue, row, Col);
	}

	public void AssignToAll(JTable table, int Col, String applyValue) {
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			table.setValueAt(applyValue, i, Col);
		}
	}

	public void applyCellValue(JTable table, int Col, String applyValue) {
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			String vcolvalue = table.getValueAt(i, Col).toString();
			if (vcolvalue == null) {
				table.setValueAt(applyValue, i, Col);
			}
		}
	}

	public String cal_Expirydate(JTable table, int i, int manufdate) throws Exception {
		String vvdate = " ";
		String vbatchcontrol = table.getValueAt(i, 14).toString();
		switch (vbatchcontrol) {
		case "Y":
			String vmanufDate = table.getValueAt(i, manufdate).toString().trim();
			int vshelfLife = new gnConfig().shelf_getShelfLife(table.getValueAt(i, 1).toString());
			vvdate = new gnConfig().calculateExpiryDate(vmanufDate, vshelfLife);
		}
		return vvdate;
	}

	public String cal_manfdate(JTable table, int i, int expdate) throws Exception {
		String vvdate = " ";
		// new General().msg("Calculating Manuf Dates now ") ;
		// 12 mannuf 13 expiry 14 batch
		String vbatchcontrol = table.getValueAt(i, 14).toString();
		switch (vbatchcontrol) {
		case "Y":
			String expdate1 = table.getValueAt(i, expdate).toString().trim();
			int vshelfLife = new gnConfig().shelf_getShelfLife(table.getValueAt(i, 1).toString());
			vvdate = new gnConfig().calculateManufDate(expdate1, vshelfLife);
		}
		return vvdate;
	}

	public void setCellMask(JTable table, int col) {
		JFormattedTextField ftext = new JFormattedTextField();
		MaskFormatter mask;
		try {
			mask = new MaskFormatter("####");
			mask.install(ftext);
			table.getColumnModel().getColumn(col).setCellEditor(new DefaultCellEditor(ftext));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void removeRow(DefaultTableModel model, JTable table) {
		TableColumn Del = table.getColumnModel().getColumn(0);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setText("DEL");
		chkbox.setVisible(true);
		chkbox.setOpaque(true);
		chkbox.setToolTipText("Del Row ");
		chkbox.setSelected(true);
		Del.setCellEditor(new DefaultCellEditor(chkbox));

		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int nn = e.getStateChange();
				if (nn == 2 && model == model) {
					int lastrow = table.getRowCount();
					int r = table.getSelectedRow();
					int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
					if (option == 0) {
						model.removeRow(r);
					}
					return;
				}
			}
		});

	}

	public JComboBox<String> generateBox(String SQL) { // used when In Table for
														// Cell ComboBox Needs
														// to Apply
		JComboBox<String> bx = null;
		try {
			ResultSet rs = this.getSPResult(SQL);
			bx = new JComboBox<String>();
			while (rs.next()) {
				bx.addItem(rs.getString(1));
			}
		} catch (Exception x) {
			System.out.println(x.getMessage());
		}
		return bx;
	}

	public JComboBox<String> generateNameBox(String SQL) { // used when In Table
															// for Cell ComboBox
															// Needs to Apply
		JComboBox<String> bx = null;
		try {
			ResultSet rs = this.getSPResult(SQL);
			bx = new JComboBox<String>();
			while (rs.next()) {
				bx.addItem(rs.getString(2));
			}
		} catch (Exception x) {
			System.out.println(x.getMessage());
		}
		return bx;
	}

	public void AddCheckBoxToTable(DefaultTableModel xmodel, JTable xtable, int col) {
		DefaultTableModel modelName = xmodel;
		JTable tableName = xtable;
		TableColumn Add = tableName.getColumnModel().getColumn(col);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setSelected(false);
		chkbox.setMargin(new Insets(0, 16, 0, 0));
		chkbox.setIconTextGap(0);
		chkbox.setBackground(new Color(255, 255, 255, 0));
		Add.setCellEditor(new DefaultCellEditor(chkbox));

	}

	public JTable DesignTable(String[] col, JTable table, DefaultTableModel model, ResultSet rs) throws SQLException {
		// new General().msg("I am here in this design class") ;
		model.setColumnIdentifiers(col);
		table.removeAll();
		while (rs.next()) {
			model.addRow(new Object[] { rs.getString(1), rs.getString(2), " " });
		}
		System.out.println(model.getDataVector());
		table.setModel(model);
		return table;
	}

	public void RemoveTableRows(DefaultTableModel xmodel) {
		DefaultTableModel modelName = xmodel;
		int rowCount = modelName.getRowCount();
		if (rowCount > 0) {
			modelName.setRowCount(0);
			return;
		}
	}

	public void setTablewidth(JTable tableName, int col, int width) {
		tableName.setRowHeight(25);
		tableName.setRowMargin(2);
		TableColumnModel columnModel1 = tableName.getColumnModel();
		columnModel1.getColumn(col).setPreferredWidth(width);
		tableName.setGridColor(Color.blue);
		tableName.setBackground(Color.CYAN);
		tableName.setForeground(Color.BLUE);
	}

	public void setTableMarginHeight(JTable tableName, int hgt, int margin) {
		tableName.setRowHeight(hgt);
		tableName.setRowMargin(margin);
	}

	public DefaultCellEditor cellEdit(JTable table) {
		DefaultCellEditor singleclick = new DefaultCellEditor(new JTextField());
		singleclick.setClickCountToStart(1);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.setDefaultEditor(table.getColumnClass(i), singleclick);
		}
		return singleclick;
	}

	public DefaultCellEditor cellEdit2(JTable table) {
		DefaultCellEditor singleclick = new DefaultCellEditor(new JTextField());
		singleclick.setClickCountToStart(2);
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.setDefaultEditor(table.getColumnClass(i), singleclick);
		}
		return singleclick;
	}

	public void setTableColWidth(JTable tableName, int col, int width) {
		TableColumnModel columnModel1 = tableName.getColumnModel();
		int row = tableName.getRowCount();
		if (row > 0) {
			columnModel1.getColumn(col).setPreferredWidth(width);
		}
	}

	public void setTableColor(JTable tableName, Color clr1, Color clr2, Color clr3) {
		tableName.setBackground(clr1);
		tableName.setForeground(clr2);
		tableName.setGridColor(clr3);
	}

	public CellEditorListener cellEditor(JTable table) {
		CellEditorListener ChangeNotification = new CellEditorListener() {
			public void editingCanceled(ChangeEvent e) {
				System.out.println("The user canceled editing.");
			}

			public void editingStopped(ChangeEvent e) {
				// int row =ntable.getSelectedRow() ;
				// String value = (String) table.getValueAt(row, 0);
				try {
					// showArticle(value) ;
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		};
		return ChangeNotification;
	}

	public double getNegTotal(JTable tableName, int col) {
		int max;
		int i = 0;
		max = tableName.getRowCount();
		Double vamount = 0.00;
		for (i = 0; i <= max - 1; i++) {
			String Xvamount1 = (String) tableName.getValueAt(i, col).toString();
			if (Double.parseDouble(Xvamount1) < 0) {
				vamount = vamount + Double.parseDouble(Xvamount1);
			}
		}
		return vamount;
	}

	public double getTotal(JTable tableName, int col) {
		int max;
		int i = 0;
		max = tableName.getRowCount();
		Double vamount = 0.00;
		for (i = 0; i <= max - 1; i++) {
			String Xvamount1 = (String) tableName.getValueAt(i, col).toString();
			if (Xvamount1.isEmpty()) {
				Xvamount1 = "0";
			}
			vamount = vamount + Double.parseDouble(Xvamount1);

		}
		return vamount;
	}

	public int getRowCount(JTable tableName) {
		int vcount = 0;
		vcount = tableName.getRowCount();
		return vcount;
	}

	public String istableColValueNegative(JTable table, int Col) {
		String status = "Sucess";
		int row = table.getRowCount();
		Double vcolvalue = 0.00;
		int i = 0;
		for (i = 0; i < row; i++) {
			try {
				vcolvalue = Double.parseDouble(table.getValueAt(i, Col).toString());
			} catch (Exception e) {
				new General()
						.Quickmsg("Please Enter Correct Value  at Row" + "  " + i + " " + "Column is:" + " " + Col);
			}
			if (vcolvalue <= 0.00) {
				status = "Fail";
				// Action = "Fail";
				new General().Quickmsg("Please Check Col Value at Row" + "  " + i + " " + "Column is:" + " " + Col);
				// table.setValueAt("0", i, 6);
			}
		}
		return status;
	}

	public String isAmountnegative(String Amount) {
		String Action = "Sucess";
		Double vAmount = Double.parseDouble(Amount);
		if (vAmount <= 0.00) {
			Action = "Fail";
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new General().msg("Please Check Total Value");
			new gnImageSound().playAlertSound();
		}
		vAmount = 0.00;
		Amount = "";
		return Action;
	}

	public static void main(String[] args) {
	}

}

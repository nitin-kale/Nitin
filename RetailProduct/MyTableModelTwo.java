package RetailProduct;

import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class MyTableModelTwo extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private Object[][] data;
	private String[] columnNames;

	public MyTableModelTwo(Object[][] data) {
		this.data = data;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndes, int columnIndex) {
		return true;
	}

	@Override
	public String getColumnName(int index) {
		return columnNames[index];
	}

	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = value;
		fireTableCellUpdated(rowIndex, columnIndex);
	}

	public MyTableModelTwo(String[] columnNames, Object[][] data) {
		this.columnNames = columnNames;
		this.data = data;
	}
}

class MyTableTwo extends JPanel implements TableModelListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private Object[][] data;
	private JTextField t;

	public MyTableTwo(int noElements, String[] columnNames) {
		data = new Object[noElements][columnNames.length];
		t = new JTextField();
		MyTableModelTwo m = new MyTableModelTwo(columnNames, data);
		table = new JTable(m);
		table.getModel().addTableModelListener(this);
		setLayout(new GridLayout(1, 0));
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
	}

	public JTextField returnT6() {
		return t;
	}
}

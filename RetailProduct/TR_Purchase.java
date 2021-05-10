package RetailProduct;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class TR_Purchase extends DefaultTableCellRenderer {
	private int row, col;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// Save row and column information for use in setValue().

		this.row = row;
		this.col = column;
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}

	protected void setValue(Object v) {
		super.setValue(v);
		if (col == 2 || col == 4)
		// if (col == 2 || col == 4 || col == 6 || col == 7 || col == 8 )

		{
			setForeground(Color.BLUE);
			setBackground(Color.white);
			return;
		}

		if (v == null)
			return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

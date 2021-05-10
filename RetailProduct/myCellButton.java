package RetailProduct;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class myCellButton extends JPanel implements TableCellRenderer {
	public Component getTableCellRendererComponent(final JTable table, Object value, boolean isSelected,
			boolean hasFocus, int row, int column) {
		this.add(new JButton("Press Me"));
		return this;
	}
}

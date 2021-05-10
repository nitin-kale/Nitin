package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

class posRenderer implements TableCellRenderer {
	public DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JTextField editor = new JTextField();
		if (value != null)
			editor.setText(value.toString());
		Font font = new Font("times Toamn", Font.BOLD, 12);
		editor.setBackground((row % 2 == 0) ? Color.white : Color.CYAN);
		editor.setFont(font);
		editor.setSelectedTextColor((row % 2 == 0) ? Color.blue : Color.DARK_GRAY);
		editor.setVisible(true);
		editor.setEditable(false);

		return editor;
	}

	public static void main(String[] args) {
	}

}// LAST

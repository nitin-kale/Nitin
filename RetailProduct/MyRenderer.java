package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

class MyRenderer implements TableCellRenderer {
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		JTextField editor = new JTextField();
		if (value != null)
			editor.setText(value.toString());
		Font font = new Font("times Toamn", Font.BOLD, 14);
		editor.setBackground((row % 2 == 0) ? Color.white : Color.CYAN);
		editor.setFont(font);
		// editor.setBackground(Color.WHITE);
		editor.setSelectedTextColor((row % 2 == 0) ? Color.blue : Color.DARK_GRAY);
		editor.setVisible(true);
		editor.setEditable(false);
		return editor;
	}

	public static void main(String[] args) {
	}
}

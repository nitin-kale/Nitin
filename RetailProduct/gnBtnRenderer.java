package RetailProduct;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

public class gnBtnRenderer extends JButton implements TableCellRenderer {

	public gnBtnRenderer() {
		// SEt button property
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row,
			int col) {
		setText((obj == null) ? "" : obj.toString());
		return this;
	}

}

class gnButtonEditor extends DefaultCellEditor {

	protected JButton btn;
	protected JButton btn1;

	protected String lbl;
	protected Boolean clicked;

	public gnButtonEditor(JTextField txt) {
		super(txt);
		btn = new JButton();
		btn.setOpaque(true);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fireEditingStopped();
			}
		});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, int row, int col) {
		lbl = ((obj == null) ? "" : obj.toString());
		btn.setText(lbl);

		clicked = true;
		return btn;
	}

	@Override
	public Object getCellEditorValue() {
		if (clicked) {
			new General().msg(lbl);
		}
		clicked = false;
		return btn;
	}

	@Override
	public boolean stopCellEditing() {
		clicked = false;
		return super.stopCellEditing();
	}

	@Override
	public void fireEditingStopped() {
		clicked = false;
		try {

			new POS().AddcaptureCropDetails();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
package RetailProduct;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class pMenu {

	static Component xcomp;

	public JPopupMenu pmenu(Component comp) {
		xcomp = comp;
		JPopupMenu popmenu = new JPopupMenu();
		((Component) popmenu).setLocation(44, 120);
		addPopup(comp, popmenu);
		JMenuItem File = new JMenuItem("Set color");
		JMenuItem Print = new JMenuItem("Print");
		JMenuItem Copy = new JMenuItem("Copy");
		JMenuItem Close = new JMenuItem("Close");
		ActionListener btnLsnr = new btn();
		File.addActionListener(btnLsnr);
		Print.addActionListener(btnLsnr);
		Copy.addActionListener(btnLsnr);
		Close.addActionListener(btnLsnr);

		popmenu.add(File);
		popmenu.add(Print);
		popmenu.add(Copy);
		popmenu.add(Close);

		return popmenu;
	}

	class btn implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (value == "Set color") {
				new General().msg(value);
				new gnApp().setcolor(xcomp);
			}

		}

	}

	private static void addPopup(Component component, final JPopupMenu popmenu) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {

				popmenu.show(e.getComponent(), e.getX(), e.getY());
				// new gnApp().setcolor(xcomp) ;

			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

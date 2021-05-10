package RetailProduct;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class MySearchPanel extends JPanel {

	/**
	 * Create the panel.
	 */

	JPanel hpanel;

	public JPanel DesignPanlel() {
		setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		setBackground(Color.WHITE);
		setLayout(null);
		JPanel mpanel = new JPanel();
		mpanel.setBounds(12, 13, 325, 174);

		JPanel hpanel = new JPanel();
		hpanel.setBackground(Color.CYAN);
		hpanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.ORANGE, Color.MAGENTA));
		hpanel.setBounds(12, 13, 325, 174);
		mpanel.add(hpanel);
		hpanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(12, 13, 56, 16);
		hpanel.add(lblNewLabel);

		JComboBox subgroup = new JComboBox();
		subgroup.setModel(new DefaultComboBoxModel(
				new String[] { "Socks", "T-Shirts", "Trousers", "Shirts", "Belt", "Perfumes" }));
		subgroup.setBounds(51, 10, 97, 22);
		hpanel.add(subgroup);

		JLabel brand = new JLabel("Brand");
		brand.setBounds(12, 47, 40, 16);
		hpanel.add(brand);

		JComboBox brandcombo = new JComboBox();
		brandcombo.setModel(new DefaultComboBoxModel(new String[] { "Vimal", "Reliance", "Arrow" }));
		brandcombo.setBounds(51, 44, 97, 22);
		hpanel.add(brandcombo);

		JButton btnSearch = new JButton("Search");
		btnSearch.setMnemonic('S');
		btnSearch.setBounds(228, 149, 97, 25);
		hpanel.add(btnSearch);

		JScrollPane myjsp = new JScrollPane();
		myjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		myjsp.setBounds(12, 200, 325, 223);
		hpanel.add(myjsp);
		mpanel.add(hpanel);
		return mpanel;

	}
}

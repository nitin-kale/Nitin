package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Artilce_otherInfo extends getResultSet {

	JFrame ArticleViewFrame;
	JScrollPane salejsp;
	JScrollPane purjsp;

	String vcomp;
	String vstore;
	String vverticle;
	String vfinyear;
	int editrow;

	private JTextField unitcost;
	private JTextField batcharticle;
	private JTextField basecost;
	private JTextField basesp;
	private JTextField unitsp;
	private JTextField innerqty;
	public static JPanel helpPanel;
	private JLabel lblNewLabel_1;
	private JTextField basemrp;
	private JLabel lblNewLabel_3;
	private JTextField unitmrp;
	private JLabel lblNewLabel_5;
	private JTextField taxcode;
	private JLabel lblNewLabel_6;
	private JTextField applytaxslab;
	private JLabel lblNewLabel_11;
	private JTextField mbq;
	private JLabel lblNewLabel_12;
	private JTextField articlecode;
	private JTextField articlename;
	private JSplitPane mymainsplit;
	private JSplitPane myInnerSplit;

	JTable purtable = new JTable();
	JTable saletable = new JTable();

	DefaultTableModel purmodel = new DefaultTableModel();
	DefaultTableModel salemodel = new DefaultTableModel();
	private JTextField purchaseuom;
	private JTextField articleclass;
	private JTextField packsize;
	private JTextField uom;
	private JTextField brandname;
	private JTextField subcatname;
	private JLabel lblNewLabel_18;
	private JTextField hsncode;
	private JLabel lblNewLabel_19;
	private JTextField avgcost;
	private JTextField avgrgm;
	private JTextField avgmargin;
	private JTextField turnover;
	private JTextField articlesales;
	private JTextField contribution;
	private JTextField noofpur;
	private JTextField noofsales;
	private JTextField articlepurchase;
	private JLabel lblNewLabel_28;
	private JTextField salesqty;
	private JLabel lblNewLabel_29;
	private JTextField purqty;
	private JLabel lblNewLabel_30;
	private JTextField purtaxamt;
	private JLabel lblNewLabel_31;
	private JTextField outputtaxamt;
	private JLabel lblNewLabel_32;
	private JLabel lblNewLabel_33;
	private JTextField minpurprice;
	private JTextField maxpurprice;
	private JLabel lblNewLabel_34;
	private JTextField salesdiscount;
	private JButton btnSupply;
	JButton btnClose;
	JPopupMenu popup = new JPopupMenu("Help");
	private JTextField group;
	private JTextField subgroup;
	private JPanel pnl2;
	private JPanel pnl3;
	private JTextField category;
	private JLabel lblNewLabel_38;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Artilce_otherInfo window = new Artilce_otherInfo();
					window.ArticleViewFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Throwable
	 */
	public Artilce_otherInfo() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		ArticleViewFrame = new JFrame();
		ArticleViewFrame.setAlwaysOnTop(true);
		ArticleViewFrame.setBounds(10, 10, 1352, 600);
		ArticleViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ArticleViewFrame.getContentPane().setLayout(null);

		lblNewLabel_12 = new JLabel("Article Code");
		lblNewLabel_12.setBounds(12, 0, 77, 29);
		ArticleViewFrame.getContentPane().add(lblNewLabel_12);

		articlecode = new JTextField();
		articlecode.setBounds(93, 3, 116, 26);
		ArticleViewFrame.getContentPane().add(articlecode);
		articlecode.setColumns(10);

		articlename = new JTextField();
		articlename.setBounds(210, 3, 228, 26);
		ArticleViewFrame.getContentPane().add(articlename);
		articlename.setColumns(10);

		helpPanel = new gnRoundPanel();
		helpPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.ORANGE, null));
		helpPanel.setBounds(22, 30, 1300, 236);
		ArticleViewFrame.getContentPane().add(helpPanel);
		helpPanel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Batch Article");
		lblNewLabel_4.setBounds(454, 211, 71, 16);
		helpPanel.add(lblNewLabel_4);

		batcharticle = new JTextField();
		batcharticle.setHorizontalAlignment(SwingConstants.LEFT);
		batcharticle.setFont(new Font("Dialog", Font.BOLD, 13));
		batcharticle.setEditable(false);
		batcharticle.setBounds(523, 205, 116, 28);
		helpPanel.add(batcharticle);
		batcharticle.setColumns(10);

		lblNewLabel_5 = new JLabel("Tax");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setBounds(40, 210, 56, 16);
		helpPanel.add(lblNewLabel_5);

		taxcode = new JTextField();
		taxcode.setFont(new Font("Dialog", Font.BOLD, 13));
		taxcode.setEditable(false);
		taxcode.setHorizontalAlignment(SwingConstants.CENTER);
		taxcode.setBounds(108, 208, 71, 22);
		helpPanel.add(taxcode);
		taxcode.setColumns(10);

		lblNewLabel_6 = new JLabel("ApplyTaxSlab");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(302, 211, 89, 16);
		helpPanel.add(lblNewLabel_6);

		applytaxslab = new JTextField();
		applytaxslab.setFont(new Font("Dialog", Font.BOLD, 13));
		applytaxslab.setEditable(false);
		applytaxslab.setHorizontalAlignment(SwingConstants.LEFT);
		applytaxslab.setBounds(403, 209, 35, 22);
		helpPanel.add(applytaxslab);
		applytaxslab.setColumns(10);

		lblNewLabel_11 = new JLabel("MBQ");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setBounds(164, 211, 56, 16);
		helpPanel.add(lblNewLabel_11);

		mbq = new JTextField();
		mbq.setFont(new Font("Dialog", Font.BOLD, 13));
		mbq.setEditable(false);
		mbq.setHorizontalAlignment(SwingConstants.CENTER);
		mbq.setBounds(223, 209, 90, 22);
		helpPanel.add(mbq);
		mbq.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Class");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_13.setBounds(-200, 18, 56, 16);
		helpPanel.add(lblNewLabel_13);

		JButton btnNewButton = new JButton(" Inforamtion");
		btnNewButton.setBounds(680, 0, 552, 16);
		helpPanel.add(btnNewButton);

		JPanel pnl1 = new JPanel();
		pnl1.setBackground(new Color(0, 0, 102));
		pnl1.setForeground(new Color(0, 0, 102));
		pnl1.setBorder(
				new TitledBorder(null, "Basic Details", TitledBorder.LEADING, TitledBorder.TOP, null, Color.ORANGE));
		pnl1.setBounds(17, 18, 183, 192);
		helpPanel.add(pnl1);
		pnl1.setLayout(null);

		JLabel lblNewLabel_14 = new JLabel("Pack Size");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_14.setForeground(Color.WHITE);
		lblNewLabel_14.setBounds(22, 27, 56, 16);
		pnl1.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("UOM");
		lblNewLabel_15.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_15.setForeground(Color.WHITE);
		lblNewLabel_15.setBounds(22, 51, 56, 16);
		pnl1.add(lblNewLabel_15);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);

		uom = new JTextField();
		uom.setBounds(84, 44, 89, 28);
		pnl1.add(uom);
		uom.setFont(new Font("Dialog", Font.BOLD, 13));
		uom.setEditable(false);
		uom.setColumns(10);

		packsize = new JTextField();
		packsize.setBounds(84, 19, 89, 28);
		pnl1.add(packsize);
		packsize.setFont(new Font("Dialog", Font.BOLD, 13));
		packsize.setEditable(false);
		packsize.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Pur.Rate");
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(11, 74, 67, 16);
		pnl1.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);

		lblNewLabel_3 = new JLabel("MRP");
		lblNewLabel_3.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(-5, 107, 83, 16);
		pnl1.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel_9 = new JLabel("Sales Price");
		lblNewLabel_9.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(-11, 131, 89, 16);
		pnl1.add(lblNewLabel_9);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);

		lblNewLabel_18 = new JLabel("HSNCODE");
		lblNewLabel_18.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setBounds(7, 157, 71, 16);
		pnl1.add(lblNewLabel_18);
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);

		hsncode = new JTextField();
		hsncode.setBounds(84, 149, 89, 28);
		pnl1.add(hsncode);
		hsncode.setColumns(10);

		unitsp = new JTextField();
		unitsp.setBounds(84, 124, 89, 28);
		pnl1.add(unitsp);
		unitsp.setFont(new Font("Calibri", Font.BOLD, 14));
		unitsp.setEditable(false);
		unitsp.setColumns(10);

		unitmrp = new JTextField();
		unitmrp.setBounds(84, 99, 89, 28);
		pnl1.add(unitmrp);
		unitmrp.setFont(new Font("Dialog", Font.BOLD, 13));
		unitmrp.setEditable(false);
		unitmrp.setColumns(10);

		unitcost = new JTextField();
		unitcost.setBounds(84, 70, 89, 28);
		pnl1.add(unitcost);
		unitcost.setFont(new Font("Dialog", Font.BOLD, 13));
		unitcost.setEditable(false);
		unitcost.setColumns(10);

		pnl2 = new JPanel();
		pnl2.setBorder(new TitledBorder(null, "Purchase UOM", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(59, 59, 59)));
		pnl2.setBounds(456, 18, 214, 171);
		helpPanel.add(pnl2);
		pnl2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Purchase UOM");
		lblNewLabel.setBounds(26, 34, 83, 16);
		pnl2.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);

		purchaseuom = new JTextField();
		purchaseuom.setBounds(119, 28, 84, 28);
		pnl2.add(purchaseuom);
		purchaseuom.setFont(new Font("Dialog", Font.BOLD, 13));
		purchaseuom.setEditable(false);
		purchaseuom.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Inner Qty");
		lblNewLabel_10.setBounds(36, 59, 71, 16);
		pnl2.add(lblNewLabel_10);
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);

		innerqty = new JTextField();
		innerqty.setBounds(120, 55, 83, 28);
		pnl2.add(innerqty);
		innerqty.setFont(new Font("Dialog", Font.BOLD, 13));
		innerqty.setEditable(false);
		innerqty.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Purchase Price");
		lblNewLabel_7.setBounds(6, 87, 101, 16);
		pnl2.add(lblNewLabel_7);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);

		basecost = new JTextField();
		basecost.setBounds(119, 82, 84, 28);
		pnl2.add(basecost);
		basecost.setFont(new Font("Dialog", Font.BOLD, 13));
		basecost.setEditable(false);
		basecost.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Sales Price");
		lblNewLabel_8.setBounds(11, 112, 96, 16);
		pnl2.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);

		basesp = new JTextField();
		basesp.setBounds(119, 107, 84, 28);
		pnl2.add(basesp);
		basesp.setFont(new Font("Dialog", Font.BOLD, 13));
		basesp.setEditable(false);
		basesp.setColumns(10);

		lblNewLabel_1 = new JLabel("MRP");
		lblNewLabel_1.setBounds(51, 140, 56, 16);
		pnl2.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);

		basemrp = new JTextField();
		basemrp.setBounds(119, 134, 84, 28);
		pnl2.add(basemrp);
		basemrp.setFont(new Font("Dialog", Font.BOLD, 13));
		basemrp.setEditable(false);
		basemrp.setColumns(10);

		pnl3 = new JPanel();
		pnl3.setBackground(new Color(0, 0, 51));
		pnl3.setBorder(new TitledBorder(null, "Brand & Hierarchy Detail", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.YELLOW));
		pnl3.setBounds(197, 18, 252, 192);
		helpPanel.add(pnl3);
		pnl3.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("Brand");
		lblNewLabel_16.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_16.setForeground(Color.WHITE);
		lblNewLabel_16.setBounds(22, 30, 71, 16);
		pnl3.add(lblNewLabel_16);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel_35 = new JLabel("Group");
		lblNewLabel_35.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_35.setForeground(Color.WHITE);
		lblNewLabel_35.setBounds(22, 57, 71, 16);
		pnl3.add(lblNewLabel_35);
		lblNewLabel_35.setHorizontalAlignment(SwingConstants.RIGHT);

		brandname = new JTextField();
		brandname.setBounds(100, 26, 119, 28);
		pnl3.add(brandname);
		brandname.setFont(new Font("Dialog", Font.BOLD, 13));
		brandname.setEditable(false);
		brandname.setColumns(10);

		group = new JTextField();
		group.setBounds(100, 51, 119, 28);
		pnl3.add(group);
		group.setColumns(10);

		JLabel lblNewLabel_36 = new JLabel("Sub Group");
		lblNewLabel_36.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_36.setForeground(Color.WHITE);
		lblNewLabel_36.setBounds(13, 81, 80, 16);
		pnl3.add(lblNewLabel_36);
		lblNewLabel_36.setHorizontalAlignment(SwingConstants.RIGHT);

		subgroup = new JTextField();
		subgroup.setBounds(100, 75, 119, 28);
		pnl3.add(subgroup);
		subgroup.setColumns(10);

		JLabel lblNewLabel_37 = new JLabel("Category");
		lblNewLabel_37.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_37.setForeground(Color.WHITE);
		lblNewLabel_37.setBounds(13, 107, 80, 16);
		pnl3.add(lblNewLabel_37);
		lblNewLabel_37.setHorizontalAlignment(SwingConstants.RIGHT);

		category = new JTextField();
		category.setBounds(100, 99, 119, 28);
		pnl3.add(category);
		category.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Sub Category");
		lblNewLabel_17.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setBounds(10, 133, 83, 16);
		pnl3.add(lblNewLabel_17);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);

		subcatname = new JTextField();
		subcatname.setBounds(100, 125, 119, 28);
		pnl3.add(subcatname);
		subcatname.setFont(new Font("Dialog", Font.BOLD, 13));
		subcatname.setEditable(false);
		subcatname.setColumns(10);

		articleclass = new JTextField();
		articleclass.setBounds(100, 151, 119, 28);
		pnl3.add(articleclass);
		articleclass.setHorizontalAlignment(SwingConstants.LEFT);
		articleclass.setFont(new Font("Dialog", Font.BOLD, 13));
		articleclass.setEditable(false);
		articleclass.setColumns(10);

		lblNewLabel_38 = new JLabel("Class");
		lblNewLabel_38.setFont(new Font("Calibri", Font.BOLD, 12));
		lblNewLabel_38.setForeground(Color.WHITE);
		lblNewLabel_38.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_38.setBounds(23, 157, 70, 16);
		pnl3.add(lblNewLabel_38);

		JPanel panelnk = new JPanel();
		panelnk.setBounds(680, 18, 552, 216);
		helpPanel.add(panelnk);
		panelnk.setLayout(null);

		JLabel lblNewLabel_22 = new JLabel("Total TurnOver");
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_22.setBounds(51, 5, 134, 16);
		panelnk.add(lblNewLabel_22);

		lblNewLabel_28 = new JLabel("Sales Qty");
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_28.setBounds(69, 24, 116, 16);
		panelnk.add(lblNewLabel_28);

		JLabel lblNewLabel_23 = new JLabel("Sales Value");
		lblNewLabel_23.setBounds(33, 49, 152, 16);
		panelnk.add(lblNewLabel_23);
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel_26 = new JLabel("Sales No.Times");
		lblNewLabel_26.setBounds(33, 69, 152, 16);
		panelnk.add(lblNewLabel_26);
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel_24 = new JLabel("Cont %. to Sales ");
		lblNewLabel_24.setBounds(43, 95, 142, 16);
		panelnk.add(lblNewLabel_24);
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel_20 = new JLabel("Avg.RGM");
		lblNewLabel_20.setBounds(61, 121, 124, 16);
		panelnk.add(lblNewLabel_20);
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel_21 = new JLabel("Avg.Margin%");
		lblNewLabel_21.setBounds(51, 149, 134, 16);
		panelnk.add(lblNewLabel_21);
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.RIGHT);

		lblNewLabel_34 = new JLabel("Sales Discount");
		lblNewLabel_34.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_34.setBounds(51, 174, 134, 16);
		panelnk.add(lblNewLabel_34);

		turnover = new JTextField();
		turnover.setBounds(197, 0, 108, 28);
		panelnk.add(turnover);
		turnover.setForeground(new Color(0, 0, 102));
		turnover.setFont(new Font("Dialog", Font.BOLD, 13));
		turnover.setColumns(10);

		salesqty = new JTextField();
		salesqty.setBounds(197, 25, 108, 28);
		panelnk.add(salesqty);
		salesqty.setForeground(new Color(0, 0, 102));
		salesqty.setColumns(10);

		articlesales = new JTextField();
		articlesales.setBounds(197, 47, 108, 28);
		panelnk.add(articlesales);
		articlesales.setForeground(new Color(0, 0, 102));
		articlesales.setFont(new Font("Dialog", Font.BOLD, 13));
		articlesales.setColumns(10);

		noofsales = new JTextField();
		noofsales.setBounds(197, 70, 109, 28);
		panelnk.add(noofsales);
		noofsales.setForeground(new Color(0, 0, 102));
		noofsales.setColumns(10);

		contribution = new JTextField();
		contribution.setBounds(197, 93, 108, 28);
		panelnk.add(contribution);
		contribution.setForeground(new Color(0, 0, 102));
		contribution.setFont(new Font("Dialog", Font.BOLD, 13));
		contribution.setColumns(10);

		avgrgm = new JTextField();
		avgrgm.setBounds(197, 119, 108, 28);
		panelnk.add(avgrgm);
		avgrgm.setForeground(new Color(0, 0, 102));
		avgrgm.setFont(new Font("Dialog", Font.BOLD, 13));
		avgrgm.setColumns(10);

		avgmargin = new JTextField();
		avgmargin.setBounds(197, 147, 108, 28);
		panelnk.add(avgmargin);
		avgmargin.setForeground(new Color(0, 0, 102));
		avgmargin.setFont(new Font("Dialog", Font.BOLD, 13));
		avgmargin.setColumns(10);

		salesdiscount = new JTextField();
		salesdiscount.setBounds(197, 172, 108, 28);
		panelnk.add(salesdiscount);
		salesdiscount.setForeground(new Color(0, 0, 102));
		salesdiscount.setColumns(10);

		purqty = new JTextField();
		purqty.setBounds(435, 5, 89, 28);
		panelnk.add(purqty);
		purqty.setForeground(new Color(0, 51, 51));
		purqty.setColumns(10);

		articlepurchase = new JTextField();
		articlepurchase.setBounds(435, 32, 89, 28);
		panelnk.add(articlepurchase);
		articlepurchase.setForeground(new Color(0, 51, 51));
		articlepurchase.setColumns(10);

		avgcost = new JTextField();
		avgcost.setBounds(435, 57, 89, 25);
		panelnk.add(avgcost);
		avgcost.setForeground(new Color(0, 51, 51));
		avgcost.setFont(new Font("Dialog", Font.BOLD, 13));
		avgcost.setEditable(false);
		avgcost.setColumns(10);

		noofpur = new JTextField();
		noofpur.setBounds(435, 79, 87, 28);
		panelnk.add(noofpur);
		noofpur.setForeground(new Color(0, 51, 51));
		noofpur.setColumns(10);

		minpurprice = new JTextField();
		minpurprice.setBounds(435, 103, 86, 28);
		panelnk.add(minpurprice);
		minpurprice.setForeground(new Color(0, 51, 51));
		minpurprice.setColumns(10);

		maxpurprice = new JTextField();
		maxpurprice.setBounds(435, 129, 86, 28);
		panelnk.add(maxpurprice);
		maxpurprice.setForeground(new Color(0, 51, 51));
		maxpurprice.setColumns(10);

		purtaxamt = new JTextField();
		purtaxamt.setBounds(435, 157, 86, 28);
		panelnk.add(purtaxamt);
		purtaxamt.setForeground(new Color(0, 51, 153));
		purtaxamt.setColumns(10);

		outputtaxamt = new JTextField();
		outputtaxamt.setBounds(433, 180, 89, 28);
		panelnk.add(outputtaxamt);
		outputtaxamt.setForeground(new Color(0, 51, 153));
		outputtaxamt.setColumns(10);

		lblNewLabel_29 = new JLabel("Purchase Qty");
		lblNewLabel_29.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_29.setBounds(274, 5, 149, 16);
		panelnk.add(lblNewLabel_29);

		JLabel lblNewLabel_27 = new JLabel("Purchase Value");
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_27.setBounds(266, 32, 157, 16);
		panelnk.add(lblNewLabel_27);

		lblNewLabel_19 = new JLabel("Avg.Pur.Price");
		lblNewLabel_19.setBounds(274, 54, 149, 16);
		panelnk.add(lblNewLabel_19);
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel_25 = new JLabel("Puchase No.Times");
		lblNewLabel_25.setBounds(241, 79, 182, 16);
		panelnk.add(lblNewLabel_25);
		lblNewLabel_25.setHorizontalAlignment(SwingConstants.RIGHT);

		lblNewLabel_32 = new JLabel("Min.Pur Price");
		lblNewLabel_32.setBounds(260, 101, 163, 16);
		panelnk.add(lblNewLabel_32);
		lblNewLabel_32.setHorizontalAlignment(SwingConstants.RIGHT);

		lblNewLabel_33 = new JLabel("Max Pur Price");
		lblNewLabel_33.setBounds(260, 129, 163, 16);
		panelnk.add(lblNewLabel_33);
		lblNewLabel_33.setHorizontalAlignment(SwingConstants.RIGHT);

		lblNewLabel_30 = new JLabel("InPut Tax Amt");
		lblNewLabel_30.setBounds(260, 157, 163, 16);
		panelnk.add(lblNewLabel_30);
		lblNewLabel_30.setHorizontalAlignment(SwingConstants.RIGHT);

		lblNewLabel_31 = new JLabel("Output Tax Amt");
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_31.setBounds(274, 180, 149, 16);
		panelnk.add(lblNewLabel_31);

		btnSupply = new JButton("Supplied By");
		btnSupply.setBounds(0, 188, 116, 28);
		panelnk.add(btnSupply);

		myInnerSplit = new JSplitPane();
		myInnerSplit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		myInnerSplit.setDividerLocation(150);
		myInnerSplit.setBounds(12, 269, 1320, 273);
		ArticleViewFrame.getContentPane().add(myInnerSplit);

		purjsp = new JScrollPane();
		purjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		purjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		myInnerSplit.setLeftComponent(purjsp);

		salejsp = new JScrollPane();
		salejsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		salejsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		myInnerSplit.setRightComponent(salejsp);

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(1060, 0, 90, 28);
		ArticleViewFrame.getContentPane().add(btnClose);

		ActionListener lnname = new nameLsnr();
		articlename.addActionListener(lnname);

		ActionListener btnl = new btnLsnr();
		btnClose.addActionListener(btnl);
		btnSupply.addActionListener(btnl);
		
		decorate();
	}
	
	// Start here

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String value = e.getActionCommand();
			if (value == "Supplied By") {
				showPurchase("SupplierList");
			}

			if (value == "Show Suppliers") {
				showPurchase("SupplierList");
			}

			if (value == "Close") {
				ArticleViewFrame.dispose();
			}

		}

	}

	private void decorate() throws Throwable {

		articlecode.setText(vmyarticlecode);
		articlename.setText(varticlename);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStorecode();
		vfinyear = new gnFinYear().getReportingFinYear();
		vverticle = new gnHierarchy().getVerticleCode();
		new gnApp().setFrameTitel(ArticleViewFrame);

		showPurchase("Month");
		showSales("Month");
		setValues();

		JButton showSupplier = new JButton("Show Suppliers");
		JButton showCustomers = new JButton("Show Customers");

		new gnDecorate().decorateBtn(showSupplier, Color.magenta, Color.WHITE);
		new gnDecorate().decorateBtn(showCustomers, Color.magenta, Color.WHITE);

		ActionListener jk = new btnLsnr();
		showSupplier.addActionListener(jk);

		popup.add(showSupplier);
		popup.add(showCustomers);

		MouseListener msls = new mouseLsnr();
		purtable.addMouseListener(msls);
	}

	class mouseLsnr implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			popup.setVisible(false);

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	private void setValues() throws Throwable {
		String vtype = "";
		String varticlecode = articlecode.getText();
		purchaseuom.setText(new gnArticle().Article_getData(varticlecode, "PurchaseUOM"));
		basecost.setText(new gnArticle().Article_getData(varticlecode, "baseCost"));
		basesp.setText(new gnArticle().Article_getData(varticlecode, "baseSP"));
		basemrp.setText(new gnArticle().Article_getData(varticlecode, "basemrp"));
		uom.setText(new gnArticle().Article_getData(varticlecode, "uom"));
		packsize.setText(new gnArticle().Article_getData(varticlecode, "packsize"));
		brandname.setText(new gnArticle().Article_getData(varticlecode, "Brandname"));
		subcatname.setText(new gnArticle().Article_getData(varticlecode, "subCatname"));
		hsncode.setText(new gnArticle().Article_getData(varticlecode, "HSNCODE"));
		avgcost.setText(new gnArticle().Article_getData(varticlecode, "avgcost"));
		unitmrp.setText(new gnArticle().Article_getData(varticlecode, "mrp"));
		unitsp.setText(new gnArticle().Article_getData(varticlecode, "salesPrice"));
		unitcost.setText(new gnArticle().Article_getData(varticlecode, "cost"));
		innerqty.setText(new gnArticle().Article_getData(varticlecode, "innerqty"));
		applytaxslab.setText(new gnArticle().Article_getData(varticlecode, "Applytaxslab"));
		taxcode.setText(new gnArticle().Article_getData(varticlecode, "taxcode"));
		batcharticle.setText(new gnArticle().Article_getData(varticlecode, "batchArticle"));
		mbq.setText(new gnArticle().Article_getData(varticlecode, "MBQ"));
		articleclass.setText(new gnArticle().Article_getData(varticlecode, "class"));

		String vcatcode = new gnArticle().Article_getData(varticlecode, "Catcode");
		String vsubcatcode = new gnArticle().Article_getData(varticlecode, "SubCatcode");
		String vgroupcode = new gnArticle().Article_getData(varticlecode, "Groupcode");
		String vsubgroupcode = new gnArticle().Article_getData(varticlecode, "subgroupcode");

		category.setText(new gnHierarchy().getNameofgivenCode("catname", vcatcode));
		subcatname.setText(new gnHierarchy().getNameofgivenCode("subcatname", vsubcatcode));
		group.setText(new gnHierarchy().getNameofgivenCode("groupname", vgroupcode));
		subgroup.setText(new gnHierarchy().getNameofgivenCode("subgroupname", vsubgroupcode));

		int salesRow = saletable.getRowCount();
		// 6 7 8 9 12 sale
		if (salesRow > 0) {
			double vsalesqty = 0.00;
			double vsalesvalue = 0.00;
			double vsalesrgm = 0.00;
			double vsalesmargin = 0.00;
			double vsalestaxamt = 0.00;
			for (int i = 0; i < salesRow; i++) {
				vsalesqty = vsalesqty + Double.parseDouble(saletable.getValueAt(i, 6).toString());
				vsalesvalue = vsalesvalue + Double.parseDouble(saletable.getValueAt(i, 7).toString());
				vsalesrgm = vsalesrgm + Double.parseDouble(saletable.getValueAt(i, 8).toString());
				vsalesmargin = vsalesmargin + Double.parseDouble(saletable.getValueAt(i, 9).toString());
				vsalestaxamt = vsalestaxamt + Double.parseDouble(saletable.getValueAt(i, 12).toString());
			}
			vsalesrgm = vsalesrgm / salesRow;
			vsalesmargin = vsalesmargin / salesRow;
			salesqty.setText(new gnMath().get2DecimaltValue(Double.toString(vsalesqty)));
			articlesales.setText(new gnMath().get2DecimaltValue(Double.toString(vsalesvalue)));
			avgrgm.setText(new gnMath().get2DecimaltValue(Double.toString(vsalesrgm)));
			avgmargin.setText(new gnMath().get2DecimaltValue(Double.toString(vsalesmargin)));
			outputtaxamt.setText(new gnMath().get2DecimaltValue(Double.toString(vsalestaxamt)));

			vtype = "ViewArticle-Count";
			noofsales.setText(new gnArticle().Article_getSalesData(articlecode.getText(), vtype));
			vtype = "ViewArticle-CompTurnOver";
			turnover.setText(
					new gnMath().get2DecimaltValue(new gnArticle().Article_getSalesData(articlecode.getText(), vtype)));
			vtype = "ViewArticle-Discount";
			salesdiscount.setText(
					new gnMath().get2DecimaltValue(new gnArticle().Article_getSalesData(articlecode.getText(), vtype)));

			double vtrunover = Double.parseDouble(turnover.getText());
			double vcontri = (100 * vsalesvalue) / vtrunover;
			contribution.setText(new gnMath().get2DecimaltValue(Double.toString(vcontri)));

		}

		// Purchase
		int purRow = purtable.getRowCount();

		if (purRow > 0) {

			// 6,7,10 //Purchase
			double vpurqty = 0.00;
			double vpurvalue = 0.00;
			double vpurtax = 0.00;
			for (int i = 0; i < purRow; i++) {
				vpurqty = vpurqty + Double.parseDouble(purtable.getValueAt(i, 7).toString());
				vpurvalue = vpurvalue + Double.parseDouble(purtable.getValueAt(i, 6).toString());
				vpurtax = vpurtax + Double.parseDouble(purtable.getValueAt(i, 10).toString());
			}

			purqty.setText(new gnMath().get2DecimaltValue(Double.toString(vpurqty)));
			articlepurchase.setText(new gnMath().get2DecimaltValue(Double.toString(vpurvalue)));
			purtaxamt.setText(new gnMath().get2DecimaltValue(Double.toString(vpurtax)));

			vtype = "ViewArticle-Count";
			noofpur.setText(new gnArticle().Article_getPurchaseData(articlecode.getText(), vtype));

			vtype = "ViewArticle-MINPRICE";
			minpurprice.setText(new gnArticle().Article_getPurchaseData(articlecode.getText(), vtype));

			vtype = "ViewArticle-MAXPRICE";
			maxpurprice.setText(new gnArticle().Article_getPurchaseData(articlecode.getText(), vtype));
		}

	}

	class nameLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vname = articlename.getText();
			vname = "%" + vname + "%";
			try {
				new gnAdmin().articleNameSearch(vname, articlecode, articlename);
				showPurchase("Month");
				showSales("Month");
				setValues();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void showPurchase(String vtype) {
		String SQL = "";
		String vreporttype = "";
		String varticle = articlecode.getText();
		switch (vtype) {
		case "Month":
			vreporttype = "ViewArticle-Month";
			String col[] = { "Type", "Article", "Name", "Month", "Month", "Year", "Amount", "Qty", "Tax",
					"Taxable value", "Taxamount", "CSGT", "SGST", "IGST" };
			SQL = "call  view_PurchaseData('" + vreporttype + "' , " + vcomp + " , " + vstore + " , '" + vfinyear
					+ "', '" + varticle + "' , " + vverticle + ")";
			int colno = 13;
			try {
				showPurcaseTable(vtype, SQL, col, colno);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "DATE":
			vreporttype = "ViewArticle-DATE";
			String col1[] = { "Type", "Article", "Name", "DATE", "Amount", "Qty", "Tax", "Taxable value", "Taxamount",
					"CSGT", "SGST", "IGST" };
			SQL = "call  view_PurchaseData('" + vreporttype + "' , " + vcomp + " , " + vstore + " , '" + vfinyear
					+ "', '" + varticle + "' , " + vverticle + ")";
			// new General().msg(SQL);
			colno = 11;
			try {
				showPurcaseTable(vtype, SQL, col1, colno);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "SupplierList":
			vreporttype = "ViewArticle-Supplier";
			String col2[] = { "Type", "Code", "Supplier", "Article", "Name", "Month", "Month", "Year", "Amount", "Qty",
					"Tax", "Taxable value", "Taxamount", "CSGT", "SGST", "IGST" };
			SQL = "call  view_PurchaseData('" + vreporttype + "' , " + vcomp + " , " + vstore + " , '" + vfinyear
					+ "', '" + varticle + "' , " + vverticle + ")";
			// new General().msg(SQL);
			colno = 15;
			try {
				showPurcaseTable(vtype, SQL, col2, colno);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		}
	}

	private void showPurcaseTable(String vtype, String SQL, String[] col, int colno)
			throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(purmodel);
		purmodel.setColumnIdentifiers(col);
		rs = super.getSPResult(SQL);
		purtable = new gnTableModel().Tablemodel(purtable, purmodel, SQL, col, colno, "N", "Y", vtype);
		JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(purtable, col);
		prt.setVisible(true);
		prt.setBackground(Color.WHITE);
		purjsp.setViewport(prt);
		purtable.setRowHeight(25);
		purtable.setBackground(Color.DARK_GRAY);
		purtable.setForeground(Color.WHITE);
		Selectpurrow();
	}

	public void Selectpurrow() {
		purtable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		purtable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				editrow = purtable.getSelectedRow();
				String vname = (String) purtable.getValueAt(editrow, 0);
				// vvertilce will tra here as month for parameter passing to SP
				vverticle = (String) purtable.getValueAt(purtable.getSelectedRow(), 3);
				try {
					displayPur(vname);
				} catch (Throwable e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
				} catch (Throwable e1) {
					e1.printStackTrace();//
					new General().msg("Article View->:" + " " + e1.getLocalizedMessage());
					new gnLogger().loggerInfoEntry("Article View",
							"Selection in table->:" + " " + e1.getLocalizedMessage());
				}
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
	}

	private void displayPur(String vtype) throws Throwable {
		switch (vtype) {
		case "Month":
			String vtype1 = "DATE";
			showPurchase(vtype1);
			break;

		case "SupplierList":
			String vsupplier = purtable.getValueAt(editrow, 1).toString();
			String vsuppliername = purtable.getValueAt(editrow, 2).toString();
			viewSupplier window = new viewSupplier();
			window.supplierviewFrame.setVisible(true);
			break;

		}
	}

	// Start Sales here
	private void showSales(String vtype) {
		String SQL = "";
		String vreporttype = "";
		String varticle = articlecode.getText();
		switch (vtype) {
		case "Month":
			vreporttype = "ViewArticle-Month";
			String col[] = { "Type", "Article", "Name", "Month", "Month", "Year", "Qty", "Amount", "RGM", "Margin%",
					"Tax", "Taxable value", "Taxamount", "CSGT", "SGST", "IGST" };
			SQL = "call  view_SalesData('" + vreporttype + "' , " + vcomp + " , " + vstore + " , '" + vfinyear + "', '"
					+ varticle + "' , " + vverticle + ")";
			// new General().msg(SQL);
			int colno = 15;
			try {
				showSalesTable(vtype, SQL, col, colno);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;

		case "DATE":
			vreporttype = "ViewArticle-DATE";
			String col1[] = { "Type", "Article", "Name", "DATE", "Qty", "Amount", "RGM", "Margin%", "Tax",
					"Taxable value", "Taxamount", "CSGT", "SGST", "IGST" };
			SQL = "call  view_SalesData('" + vreporttype + "' , " + vcomp + " , " + vstore + " , '" + vfinyear + "', '"
					+ varticle + "' , " + vverticle + ")";
			// new General().msg(SQL);
			colno = 13;
			try {
				showSalesTable(vtype, SQL, col1, colno);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	private void showSalesTable(String vtype, String SQL, String[] col, int colno)
			throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(salemodel);
		salemodel.setColumnIdentifiers(col);
		rs = super.getSPResult(SQL);
		saletable = new gnTableModel().Tablemodel(saletable, salemodel, SQL, col, colno, "N", "Y", vtype);
		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.CYAN);
		prt1.add(saletable, col);
		prt1.setVisible(true);
		prt1.setBackground(Color.WHITE);
		salejsp.setViewport(prt1);
		saletable.setBackground(Color.darkGray);
		saletable.setForeground(Color.ORANGE);

		Selectsalerow();
	}

	public void Selectsalerow() {
		saletable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		saletable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int editrow = saletable.getSelectedRow();
				String vname = (String) saletable.getValueAt(editrow, 0);
				// vvertilce will tra here as month for parameter passing to SP
				vverticle = (String) saletable.getValueAt(saletable.getSelectedRow(), 3);
				displaySale(vname);
				try {
				} catch (Throwable e1) {
					e1.printStackTrace();//
					new General().msg("Sale Article View->:" + " " + e1.getLocalizedMessage());
					new gnLogger().loggerInfoEntry("Article View",
							"Sale Selection in table->:" + " " + e1.getLocalizedMessage());
				}
			}
		});
		saletable.setSurrendersFocusOnKeystroke(true);
	}

	private void displaySale(String vtype) {
		switch (vtype) {
		case "Month":
			String vtype1 = "DATE";
			showSales(vtype1);
			break;
		}
	}
}// Last

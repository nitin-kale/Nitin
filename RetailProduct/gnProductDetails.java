package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.AbstractAction;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class gnProductDetails extends getResultSet {

	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable();
	JPanel panel;
	static JPanel panel_1;

	public static String varticlecode;
	public static String varticlename;
	public static String vinnerQty;
	public static String vcurstock;
	public static String vuom;
	public static String vbatchitem;
	public static String vqty;
	public static String vrate;
	public static String vgrossamt;
	public static String vnetamt;
	public static String vdiscamt;
	public static String vdiscper;
	public static String vbatchno;
	public static String vexpdate;
	public static String vtransportamt;
	public static String votherchrgamt;
	public static String vtransportper;
	public static String votherchrgper;
	public static String vtaxcode;
	public static String vlocation;
	public static int row;

	JFrame ProductInfoframe;
	public static JTextField articlecode;
	public static JTextField name;
	public static JTextField uom;
	public static JTextField innerqty;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	public static JTextField rate;
	public static JTextField expirydate;
	public static JTextField taxcode;
	public static JTextField curstock;
	public static JTextField batchno;
	public static JTextField qty;
	public static JTextField disper;
	public static JTextField discamt;
	public static JTextField transportcost;
	public static JTextField othcharges;
	public static JTextField transportper;
	public static JTextField othchrgper;
	public static JTextField grossamt;
	public static JTextField netamount;
	public static JTextField batchitem;
	JLabel lblbatchno;
	JLabel lblexpdate;
	private JButton btnClose;
	JScrollPane jsp;
	static JPanel panel_2;
	private JTextField location;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gnProductDetails window = new gnProductDetails();
					window.ProductInfoframe.setVisible(true);
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
	public gnProductDetails() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		ProductInfoframe = new JFrame();
		ProductInfoframe.setAlwaysOnTop(true);
		ProductInfoframe.setType(Type.POPUP);
		ProductInfoframe.setBounds(100, 10, 496, 549);
		ProductInfoframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ProductInfoframe.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setForeground(Color.ORANGE);
		panel.setBackground(Color.CYAN);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel.setBounds(0, 0, 490, 516);
		ProductInfoframe.getContentPane().add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 102));
		panel_1.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(102, 255, 153)));
		panel_1.setBounds(6, 0, 484, 124);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Pack Qty");
		lblNewLabel_4.setBounds(159, 83, 56, 16);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Cambria", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_4);

		innerqty = new JTextField();
		innerqty.setBounds(208, 84, 43, 22);
		panel_1.add(innerqty);
		innerqty.setEditable(false);
		innerqty.setColumns(10);

		JLabel lblNewLabel_18 = new JLabel("Batch Item");
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setBounds(256, 83, 66, 16);
		lblNewLabel_18.setFont(new Font("Cambria", Font.PLAIN, 12));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel_18);

		batchitem = new JTextField();
		batchitem.setBounds(316, 84, 30, 25);
		batchitem.setEditable(false);
		panel_1.add(batchitem);
		batchitem.setColumns(10);

		JLabel lblNewLabel_19 = new JLabel("Location");
		lblNewLabel_19.setBounds(349, 83, 55, 16);
		lblNewLabel_19.setForeground(Color.WHITE);
		lblNewLabel_19.setFont(new Font("Cambria", Font.PLAIN, 12));
		panel_1.add(lblNewLabel_19);

		location = new JTextField();
		location.setBounds(402, 84, 34, 28);
		panel_1.add(location);
		location.setColumns(10);

		articlecode = new JTextField();
		articlecode.setBounds(256, 16, 169, 22);
		panel_1.add(articlecode);
		articlecode.setEditable(false);
		articlecode.setColumns(10);

		JLabel lblNewLabel = new JLabel("Current Stock");
		lblNewLabel.setBounds(20, 10, 85, 35);
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 12));

		curstock = new JTextField();
		curstock.setBounds(99, 16, 70, 22);
		panel_1.add(curstock);
		curstock.setEditable(false);
		curstock.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Article Code");
		lblNewLabel_1.setBounds(162, 19, 92, 16);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Cambria", Font.PLAIN, 12));

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(30, 50, 57, 16);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Cambria", Font.PLAIN, 12));

		name = new JTextField();
		name.setBounds(97, 47, 339, 30);
		panel_1.add(name);
		name.setFont(new Font("Cambria", Font.BOLD, 13));
		name.setEditable(false);
		name.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("UOM");
		lblNewLabel_3.setBounds(21, 83, 62, 16);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Cambria", Font.PLAIN, 12));

		uom = new JTextField();
		uom.setBounds(99, 84, 48, 22);
		panel_1.add(uom);
		uom.setEditable(false);
		uom.setColumns(10);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(6, 368, 484, 142);
		panel.add(jsp);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(51, 255, 153), 3));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(6, 122, 484, 220);
		panel.add(panel_2);
		panel_2.setLayout(null);

		qty = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		qty.setBounds(112, 13, 116, 25);
		panel_2.add(qty);
		qty.setFont(new Font("Cambria", Font.BOLD, 12));
		qty.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("* Qty");
		lblNewLabel_9.setBounds(12, 17, 90, 16);
		panel_2.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);

		rate = new JTextField();
		rate.setBounds(112, 41, 116, 25);
		panel_2.add(rate);
		rate.setFont(new Font("Cambria", Font.BOLD, 12));
		rate.setColumns(10);

		lblNewLabel_6 = new JLabel("* Rate");
		lblNewLabel_6.setBounds(18, 44, 89, 16);
		panel_2.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblNewLabel_10 = new JLabel("DisCount%");
		lblNewLabel_10.setBounds(12, 100, 90, 16);
		panel_2.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);

		disper = new JTextField();
		disper.setBounds(112, 97, 116, 25);
		panel_2.add(disper);
		disper.setFont(new Font("Cambria", Font.BOLD, 12));
		disper.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Disc.Amount");
		lblNewLabel_11.setBounds(18, 127, 90, 16);
		panel_2.add(lblNewLabel_11);
		lblNewLabel_11.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);

		discamt = new JTextField();
		discamt.setBounds(112, 125, 116, 25);
		panel_2.add(discamt);
		discamt.setFont(new Font("Cambria", Font.BOLD, 12));
		discamt.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Batch No");
		lblNewLabel_8.setBounds(18, 155, 90, 16);
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);

		batchno = new JTextField();
		batchno.setBounds(112, 154, 116, 25);
		panel_2.add(batchno);
		batchno.setFont(new Font("Cambria", Font.BOLD, 12));
		batchno.setColumns(10);

		lblNewLabel_7 = new JLabel("Expiry Date");
		lblNewLabel_7.setBounds(18, 187, 90, 16);
		panel_2.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);

		expirydate = new JTextField();
		expirydate.setBounds(112, 184, 116, 25);
		panel_2.add(expirydate);
		expirydate.setFont(new Font("Cambria", Font.PLAIN, 13));
		expirydate.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Transport %");
		lblNewLabel_14.setBounds(250, 14, 81, 16);
		panel_2.add(lblNewLabel_14);
		lblNewLabel_14.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);

		transportper = new JTextField();
		transportper.setBounds(334, 11, 116, 25);
		panel_2.add(transportper);
		transportper.setFont(new Font("Cambria", Font.PLAIN, 13));
		transportper.setColumns(10);

		JLabel lblNewLabel_15 = new JLabel("Other Chrg%");
		lblNewLabel_15.setBounds(250, 73, 80, 16);
		panel_2.add(lblNewLabel_15);
		lblNewLabel_15.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);

		othchrgper = new JTextField();
		othchrgper.setBounds(334, 70, 116, 25);
		panel_2.add(othchrgper);
		othchrgper.setFont(new Font("Cambria", Font.PLAIN, 13));
		othchrgper.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Transport Exp.");
		lblNewLabel_12.setBounds(240, 41, 90, 16);
		panel_2.add(lblNewLabel_12);
		lblNewLabel_12.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);

		transportcost = new JTextField();
		transportcost.setBounds(334, 41, 116, 25);
		panel_2.add(transportcost);
		transportcost.setFont(new Font("Cambria", Font.PLAIN, 13));
		transportcost.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Other Charges");
		lblNewLabel_13.setBounds(240, 107, 90, 16);
		panel_2.add(lblNewLabel_13);
		lblNewLabel_13.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.RIGHT);

		othcharges = new JTextField();
		othcharges.setBounds(334, 104, 116, 25);
		panel_2.add(othcharges);
		othcharges.setFont(new Font("Cambria", Font.PLAIN, 13));
		othcharges.setColumns(10);

		lblNewLabel_5 = new JLabel("Tax");
		lblNewLabel_5.setBounds(240, 139, 90, 16);
		panel_2.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);

		taxcode = new JTextField();
		taxcode.setEnabled(false);
		taxcode.setEditable(false);
		taxcode.setBounds(334, 136, 116, 25);
		panel_2.add(taxcode);
		taxcode.setFont(new Font("Cambria", Font.PLAIN, 13));
		taxcode.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Gross Amt.");
		lblNewLabel_16.setBounds(45, 70, 63, 16);
		panel_2.add(lblNewLabel_16);

		grossamt = new JTextField();
		grossamt.setEnabled(false);
		grossamt.setEditable(false);
		grossamt.setFont(new Font("Cambria", Font.BOLD, 12));
		grossamt.setBounds(112, 69, 116, 25);
		panel_2.add(grossamt);
		grossamt.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("Net Amount");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17.setFont(new Font("Cambria", Font.BOLD, 13));
		lblNewLabel_17.setBounds(250, 187, 81, 16);
		panel_2.add(lblNewLabel_17);

		netamount = new JTextField();
		netamount.setEnabled(false);
		netamount.setEditable(false);
		netamount.setBounds(334, 184, 116, 25);
		panel_2.add(netamount);
		netamount.setColumns(10);

		lblbatchno = new JLabel("-");
		lblbatchno.setBounds(12, 155, 21, 16);
		panel_2.add(lblbatchno);

		lblexpdate = new JLabel("New label");
		lblexpdate.setBounds(12, 187, 12, 16);
		panel_2.add(lblexpdate);

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(381, 344, 109, 25);
		panel.add(btnClose);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { qty }));
		ActionListener btncls = new LsnrClose();
		btnClose.addActionListener(btncls);
		// KeyListener lskey1 = new lskey();
		// qty.addKeyListener(lskey1);;
		ActionListener itmLsnr = new qtyLsnr();
		qty.addActionListener(itmLsnr);

		ActionListener rateLs = new rateLsnr();
		rate.addActionListener(rateLs);

		ActionListener disperls = new disperLsnr();
		disper.addActionListener(disperls);

		ActionListener discamtLs = new discamtLsnr();
		discamt.addActionListener(discamtLs);

		ActionListener batchLs = new batchLsnr();
		batchno.addActionListener(batchLs);

		ActionListener trper = new transperLsnr();
		ActionListener tramt = new transcostLsnr();
		transportper.addActionListener(trper);
		transportcost.addActionListener(tramt);

		ActionListener othper = new otherPerLsnr();
		ActionListener othchrg = new otherchrgLsnr();

		othchrgper.addActionListener(othper);
		othcharges.addActionListener(othchrg);
		decorate();

	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(ProductInfoframe);
		ProductInfoframe.setDefaultLookAndFeelDecorated(false);
		// ProductInfoframe.setUndecorated(true);
		new gnField().closeform(panel, ProductInfoframe);

	}

	public static JPanel getPanel2() {

		return panel_1;
	}

	class qtyLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			rate.grabFocus();
		}
	}

	class rateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			Double vgross = Double.parseDouble(rate.getText()) * Double.parseDouble(qty.getText());
			grossamt.setText(Double.toString(vgross));
			disper.grabFocus();
		}
	}

	class disperLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (grossamt.getText().length() == 0) {
				grossamt.setText("0.00");
				Double vgross = Double.parseDouble(grossamt.getText());
				Double vdiscamt = vgross * (Double.parseDouble(disper.getText())) / 100;
				discamt.setText(new gnMath().get2DecimaltValue(Double.toString(vdiscamt)));
				// discamt.setEditable(false);
				batchno.grabFocus();
			}
		}
	}

	class discamtLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			if (discamt.getText().length() > 0) {
				Double vgross = Double.parseDouble(grossamt.getText());
				disper.setText("0.00");
				batchno.grabFocus();
			}
		}
	}

	class batchLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				getBatchDetail(varticlecode, vbatchitem, vlocation);
			} catch (Throwable e1) {
				new General().msg(e1.getMessage());
			}
		}
	}

	public String getBatchDetail(String varticle, String vbatchcontrol, String vloc) throws Throwable {
		String status = "Sucess";
		String vstorecode = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		String vfinyear = new gnFinYear().getReportingFinYear();
		switch (vbatchcontrol) {
		case "Y":
			String SQL = "Call sv_getbatchprices(" + vstorecode + " ,    " + varticle + ", " + vcomp + ", '" + vloc
					+ "'   , '" + vfinyear + "')";
			showBatchDetails(SQL);
			break;
		case "N":
			String SQL1 = "Call sv_getnonBatchprices(" + vstorecode + " ,   " + varticle + " , " + vcomp + ", '" + vloc
					+ "'  ,  '" + vfinyear + "')";
			showBatchDetails(SQL1);
			break;
		}
		return status;
	}

	private void showBatchDetails(String SQL) throws ClassNotFoundException, SQLException {
		// String batch[]= {"BatchArticle" , "Item Code" , "name" , "cost"
		// ,"SalesPrice" ,
		// "Mrp" , "Location", "Batchno" , "Manuf_date" , "Exp.Date" ,"Bal_Qty"}
		// ;
		String batch[] = { "cost", "SalesPrice", "Mrp", "Batchno", "Exp.Date", "Bal_Qty" };
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			model.setColumnIdentifiers(batch);
			// model.addRow(new Object[] {rs.getString(1),rs.getString(2),
			// rs.getString(3), rs.getString(4), rs.getString(5),
			// rs.getString(6), rs.getString(7), rs.getString(8),
			// rs.getString(9), rs.getString(10), rs.getString(11)});
			model.addRow(new Object[] { rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(8),
					rs.getString(10), rs.getString(11) });
		}
		rs.close();
		this.closeconn();
		table.setModel(model);
		new gnTable().setTableBasics(table);
		JViewport prt = new JViewport();
		prt.setBackground(Color.WHITE);
		prt.add(table, batch);
		prt.setVisible(true);
		jsp.setViewport(prt);
		table.requestFocus();
		Selectbatch();
	}

	public void Selectbatch() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				try {
					if (batchitem.getText().equals("Y")) {
						batchno.setText(table.getValueAt(row, 3).toString());
						expirydate.setText(table.getValueAt(row, 4).toString());
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				} finally {
					new gnTable().RemoveTableRows(model);
					transportper.grabFocus();
				}
			}
		});
	}

	class transperLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (netamount.getText().length() == 0) {
				netamount.setText("0.00");
				Double vnet = Double.parseDouble(netamount.getText());
				Double vtransportamt = vnet * (Double.parseDouble(transportper.getText())) / 100;
				transportcost.setText(Double.toString(vtransportamt));
				othchrgper.grabFocus();
			}
		}
	}

	class transcostLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			transportper.setText("0");
			othchrgper.grabFocus();
		}
	}

	class otherPerLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			Double vnet = Double.parseDouble(netamount.getText());
			Double votherchrgamt = vnet * (Double.parseDouble(othchrgper.getText())) / 100;
			othcharges.setText(Double.toString(votherchrgamt));
			othcharges.grabFocus();
		}
	}

	class otherchrgLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			btnClose.doClick();
		}
	}

	class lskey implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int keycd = e.getKeyCode();
			String fieldname = e.getComponent().getName();
			switch (keycd) {
			case 10:
				rate.grabFocus();
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {

		}

		@Override
		public void keyTyped(KeyEvent arg0) {

		}
	}

	class LsnrClose implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				getValues();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ProductInfoframe.dispose();
		}
	}

	private void getValues() throws Throwable {
		vqty = qty.getText();
		vrate = rate.getText();
		vbatchno = batchno.getText();
		vexpdate = expirydate.getText();
		vdiscamt = discamt.getText();
		vdiscper = disper.getText();
		vtransportamt = transportcost.getText();
		vtransportper = transportper.getText();
		votherchrgper = othchrgper.getText();
		votherchrgamt = othcharges.getText();
		new purchaseReturn().setValuesTotable(row);

	}

	public void setValues() {
		discamt.setText(vdiscamt);
		disper.setText(vdiscper);
		innerqty.setText(vinnerQty);
		articlecode.setText(varticlecode);
		name.setText(varticlename);
		uom.setText(vuom);
		curstock.setText(vcurstock);
		qty.setText(vqty);
		rate.setText(vrate);
		batchno.setText(vbatchno);
		expirydate.setText(vexpdate);
		batchitem.setText(vbatchitem);
		location.setText(vlocation);
		transportcost.setText(vtransportamt);
		Double vgrs = Double.parseDouble(vrate) * Double.parseDouble(vqty);
		grossamt.setText(new gnMath().get2DecimaltValue(Double.toString(vgrs)));
		netamount.setText(Double.toString(vgrs));
		taxcode.setText(vtaxcode);
	}

}// Last
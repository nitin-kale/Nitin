package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.businessrefinery.barcode.Barcode;
import com.businessrefinery.barcode.jasper.BarcodeFactory;
import com.businessrefinery.barcode.jasper.IRenderer;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

public class barcodePrinting extends getResultSet {

	JFrame barcodeframe;
	JPanel panel;
	private JTextField articlecode;
	private JTextField name;
	private JTextField eancode;
	private JRadioButton rbean;
	private JRadioButton rbarticle;
	private JButton btnGenerate;
	JRadioButton rbrepack;
	String vsp;
	JComboBox barcodetype;
	private JButton btnPrint;
	private JButton btnBarcode;

	private String barcodefor;
	private int vqty;
	private String vname;
	private String vmrp;

	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_2;
	private JTextField qty;
	private JTextField mrp;
	String vchoice;
	private JTextField reqno;
	private JTextField reqdate;

	JScrollPane jsp;
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	private JTextField sp;
	private JTextField bestbefore;
	private JTextField prebarcodeitem;
	private JLabel lblNewLabel_10;
	private JTextField selectoption;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					barcodePrinting window = new barcodePrinting();
					window.barcodeframe.setVisible(true);
				} catch (Exception e) {
					new General().msg(e.getLocalizedMessage());
				} catch (Throwable e) {
					new General().msg(e.getLocalizedMessage());
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Throwable
	 */
	public barcodePrinting() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		barcodeframe = new JFrame();
		barcodeframe.setTitle("Business Application");
		barcodeframe.setIconImage(
				Toolkit.getDefaultToolkit().getImage(barcodePrinting.class.getResource("/RetailProduct/mymain.png")));
		barcodeframe.setBounds(250, 100, 803, 539);
		barcodeframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		barcodeframe.getContentPane().setLayout(null);

		// panel = new JPanel();
		panel = new gnRoundPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 26, 516, 171);
		barcodeframe.getContentPane().add(panel);
		panel.setLayout(null);
		ActionListener btn = new btnLsnr();

		articlecode = new JTextField();
		articlecode.setBackground(Color.WHITE);
		articlecode.setEditable(false);
		articlecode.setBounds(156, 25, 55, 28);
		panel.add(articlecode);
		articlecode.setColumns(10);

		name = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		name.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		name.setToolTipText("Enter Search String OR  Press Enter ");
		name.setText(" ");
		name.setBounds(210, 25, 202, 28);
		ActionListener nm = new lsnritemName();
		name.addActionListener(nm);
		panel.add(name);
		name.setColumns(100);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Select Option",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel_2.setBounds(3, 4, 150, 158);
		panel.add(panel_2);
		panel_2.setLayout(null);

		rbarticle = new JRadioButton("For Article Code");
		rbarticle.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		rbarticle.setForeground(new Color(0, 0, 102));
		rbarticle.setBackground(Color.WHITE);
		buttonGroup.add(rbarticle);
		rbarticle.setSelected(true);
		ActionListener rb = new btnRBLsnr();
		rbarticle.addActionListener(rb);
		rbarticle.setBounds(11, 78, 131, 18);
		panel_2.add(rbarticle);

		rbean = new JRadioButton("For Ean Code");
		rbean.setEnabled(false);
		rbean.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		rbean.setForeground(new Color(0, 0, 102));
		rbean.setBackground(Color.WHITE);
		buttonGroup.add(rbean);
		rbean.setBounds(11, 101, 115, 18);
		panel_2.add(rbean);

		rbrepack = new JRadioButton("Repacking Item");
		rbrepack.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		rbrepack.setForeground(new Color(0, 0, 102));
		rbrepack.setBackground(Color.WHITE);
		rbrepack.setBounds(11, 124, 127, 25);
		panel_2.add(rbrepack);
		buttonGroup.add(rbrepack);
		
		JLabel lblNewLabel_11 = new JLabel("Enter Option(1/2/3)");
		lblNewLabel_11.setBounds(11, 28, 127, 16);
		panel_2.add(lblNewLabel_11);
		
		selectoption = new JTextField()
		{
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		selectoption.setFont(new Font("Tahoma", Font.BOLD, 16));
	 	selectoption.setBounds(11, 43, 127, 26);
		panel_2.add(selectoption);
		selectoption.setColumns(10);
 		rbean.addActionListener(rb);

		JLabel lblNewLabel = new JLabel("BARCODE PRINTIGN MODULE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(0, 6, 773, 16);
		barcodeframe.getContentPane().add(lblNewLabel);

		btnBarcode = new JButton("");
		btnBarcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		// btnBarcode.setIcon(new ImageIcon("D:\\barcode.gif"));
		btnBarcode.setBounds(149, 253, 407, 84);
		barcodeframe.getContentPane().add(btnBarcode);

		qty = new JTextField();
		qty.setText("0");
		qty.setBounds(421, 64, 73, 22);
		panel.add(qty);
		qty.setColumns(10);
		lblNewLabel_2 = new JLabel("Qty");
		lblNewLabel_2.setBounds(424, 49, 30, 16);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 12));

		JLabel lblNewLabel_3 = new JLabel("MRP");
		lblNewLabel_3.setBounds(394, 90, 55, 16);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 12));

		mrp = new JTextField();
		mrp.setText("0");
		mrp.setBounds(421, 105, 73, 22);
		panel.add(mrp);
		mrp.setColumns(10);

		eancode = new JTextField();
		eancode.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		eancode.setBounds(156, 57, 256, 28);
		panel.add(eancode);
		eancode.setColumns(10);
		eancode.setEnabled(false);

		JPanel repackPanel = new JPanel();
		repackPanel.setBackground(Color.WHITE);
		repackPanel.setBorder(new TitledBorder(
				new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(255, 0, 0), new Color(0, 0, 0),
						new Color(255, 0, 255)),
				"Enter Repacking  Request Information", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		repackPanel.setBounds(156, 86, 256, 76);
		panel.add(repackPanel);
		repackPanel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Request No");
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_1.setBounds(13, 22, 97, 16);
		repackPanel.add(lblNewLabel_1);

		reqno = new JTextField();
		reqno.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		reqno.setBounds(97, 19, 101, 25);
		reqno.setForeground(Color.DARK_GRAY);
		repackPanel.add(reqno);
		reqno.setColumns(10);

		reqdate = new JTextField();
		reqdate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		reqdate.setBounds(97, 46, 101, 25);
		reqdate.setForeground(Color.DARK_GRAY);
		repackPanel.add(reqdate);
		reqdate.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Req.Date");
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_4.setBounds(23, 50, 88, 16);
		repackPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel("SP");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setBounds(421, 127, 33, 16);
		panel.add(lblNewLabel_6);

		sp = new JTextField();
		sp.setText("0");
		sp.setBounds(420, 140, 74, 22);
		panel.add(sp);
		sp.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Barcode Item");
		lblNewLabel_9.setBounds(421, 4, 83, 16);
		panel.add(lblNewLabel_9);

		prebarcodeitem = new JTextField();
		prebarcodeitem.setToolTipText("Please Note  BarCode Will Print Only For Non BarCoded Items \r\nFor Example Grocessary Repacking Items. For FMCG Items Where Barcode is Alrady Printed Barcode Will Not Print ");
		prebarcodeitem.setEditable(false);
		prebarcodeitem.setBounds(424, 25, 70, 28);
		panel.add(prebarcodeitem);
		prebarcodeitem.setColumns(10);

		lblNewLabel_10 = new JLabel("Press Enter To Select Article");
		lblNewLabel_10.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_10.setBounds(156, 6, 186, 16);
		panel.add(lblNewLabel_10);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 336, 773, 150);
		barcodeframe.getContentPane().add(jsp);

		//btnGenerate = new JButton("Generate");
		btnGenerate = new gnRoundButton("Generate");
 		btnGenerate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnGenerate.setBounds(557, 279, 118, 44);
		barcodeframe.getContentPane().add(btnGenerate);
		btnGenerate.setMnemonic('G');

		//btnPrint = new JButton("Print");
		btnPrint = new gnRoundButton("Print");
 		btnPrint.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnPrint.setBounds(676, 279, 97, 44);
		barcodeframe.getContentPane().add(btnPrint);
		btnPrint.setMnemonic('P');

		JLabel lblNewLabel_5 = new JLabel(" ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setIcon(new ImageIcon(barcodePrinting.class.getResource("/RetailProduct/barcodeprinter.jpg")));
		lblNewLabel_5.setBounds(519, 26, 254, 171);
		barcodeframe.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("Best Before");
		lblNewLabel_7.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_7.setBounds(207, 215, 90, 16);
		barcodeframe.getContentPane().add(lblNewLabel_7);

		bestbefore = new JTextField();
		bestbefore.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		bestbefore.setBounds(297, 210, 116, 30);
		barcodeframe.getContentPane().add(bestbefore);
		bestbefore.setColumns(10);
		
				JLabel lblNewLabel_8 = new JLabel("Type");
				lblNewLabel_8.setBounds(11, 196, 126, 16);
				barcodeframe.getContentPane().add(lblNewLabel_8);
				lblNewLabel_8.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
				
						barcodetype = new JComboBox();
						barcodetype.setBounds(10, 213, 127, 27);
						barcodeframe.getContentPane().add(barcodetype);
						barcodetype.setBackground(Color.WHITE);
						barcodetype.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
						barcodetype.setModel(new DefaultComboBoxModel(new String[] {"S38x38(2up)", "S38x25(2up)", "S75x75"}));
						
						JLabel lblNewLabel_12 = new JLabel("(Size in mm)");
						lblNewLabel_12.setBounds(55, 196, 82, 16);
						barcodeframe.getContentPane().add(lblNewLabel_12);
		btnPrint.addActionListener(btn);
		btnGenerate.addActionListener(btn);
		ActionListener datLsnr = new dateLsnr();
		reqdate.addActionListener(datLsnr);
		rbrepack.addActionListener(rb);

		KeyListener kys = new keyPressedlsnr();
		qty.addKeyListener(kys);
		mrp.addKeyListener(kys);
		sp.addKeyListener(kys);
		bestbefore.addKeyListener(kys);
		
		ActionListener selectoptls = new selectoptionLsnr();
		selectoption.addActionListener(selectoptls);

		decorate();
	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(barcodeframe);
		new gnField().closeform(panel, barcodeframe);

	}

	class dateLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vreqno = reqno.getText();
			String vdate = reqdate.getText();
			try {
				showRepackingItems();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	class lsnritemName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String sname = name.getText().trim();
			sname = "%" + sname + "%";
			try {
				String vtype = "Article";
				String varticle1 = "";
				String vtrantype1 = "ALL";
				new gnAdmin().Search(vtype , sname , varticle1 , vtrantype1);
			} catch (SQLException e1) {
				new General().msg(e1.getLocalizedMessage());
			} catch (ClassNotFoundException e1) {
				new General().msg(e1.getLocalizedMessage());
			} catch (Throwable e1) {
				new General().msg(e1.getLocalizedMessage());
			} finally {
				try {
					articlecode.setText(new gnAdmin().rArticle);
					String EanArticle = new gnArticle().Article_getData(articlecode.getText(), "isEanArticle");
					prebarcodeitem.setText(EanArticle);
					name.setText(new gnAdmin().rArticlename);
					qty.grabFocus();
					mrp.setText(new gnArticle().Article_getData(articlecode.getText(), "MRP"));
					sp.setText(new gnArticle().Article_getData(articlecode.getText(), "SalesPrice"));
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
				}
			}
		}
	}

	class btnRBLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			boolean vrepack = rbrepack.isSelected();
 			rbbuttonsetting() ;
		}
	}

	
private void rbbuttonsetting()
{
	boolean vrepacking = rbrepack.isSelected() ;
	
	if (vrepacking)
	{
 		vchoice = "R";
		new General().Quickmsg("Repacking Item Barcode Printing Seleccted...Please Enter Request No & Date");
		reqno.grabFocus();
	}

	
	boolean vean = rbean.isSelected() ;
	if (vean)
	{
 		vchoice = "E";
		name.setEnabled(false);
		eancode.setEnabled(true);
		eancode.grabFocus();
	}
	
	boolean vproduct = rbarticle.isSelected() ;
	if (vproduct)
	{
  		vchoice = "P";
		name.setEnabled(true);
		name.grabFocus();
		eancode.setEnabled(false);
  	}
}
	
	
	private void process() {
		if (vchoice == null) {
			new General().msg("Select Option First .. ");
			return;
		}

		
		switch (vchoice) {
		case "E":
			barcodefor = eancode.getText();
			vname = name.getText();
			vmrp = mrp.getText();
			vsp = sp.getText();
			vqty = Integer.parseInt(qty.getText());
			vqty = vqty + 1;
			break;
		case "P":
			barcodefor = articlecode.getText();
			vname = name.getText();
			vsp = sp.getText();
			vmrp = mrp.getText();
			vqty = Integer.parseInt(qty.getText());
			vqty = vqty + 1;
			break;
		}
	}

	private void show() throws Exception {
		Barcode barcode = new Barcode();
		switch (vchoice) {
		case "E":
			// BarcodeFactory ft = new BarcodeFactory();
			barcode.setDisplayText(true);
			barcode.setCode(barcodefor);
			barcode.drawImage2File(ApplicationDrivename+"barcode.gif");
			barcode.setBarcodeHeight(25);
			barcode.setBarcodeWidth(35);
			barcode.setBarcodeUnit(100);
			new General().Quickmsg("Barcode Generated ...");
			btnBarcode.setIcon(new ImageIcon(ApplicationDrivename+"barcode.gif"));
			break;

		case "P":
			// BarcodeFactory ft = new BarcodeFactory();
			barcode.setDisplayText(true);
			barcode.setCode(barcodefor);
			barcode.drawImage2File(ApplicationDrivename+"barcode.gif");
			barcode.setBarcodeHeight(25);
			barcode.setBarcodeWidth(35);
			barcode.setBarcodeUnit(100);
			new General().Quickmsg("Barcode Generated ...");
			btnBarcode.setIcon(new ImageIcon(ApplicationDrivename+"barcode.gif"));
			break;
		}
	}

	private String validate() 
	{
		String status = "Sucess";
 		String EanArticle;
  		try {
			EanArticle = new gnArticle().Article_getData(articlecode.getText(), "isEanArticle");
		    switch (EanArticle) {
			case "Y":
				status = "Fail";
				new General().Quickmsg("Pre Painted Barcode Article .. ");
  				break;
			}
		} catch (ClassNotFoundException | SQLException e) {
		}

		if (bestbefore.getText().length() == 0) {
			new General().msg("Please Enter Best Bwfore Date..");
			bestbefore.grabFocus();
			status = "Fail";
		}
		
		
 		return status;
 }

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Generate") {
				String status;
				status = validate();
				if (status == "Sucess") {
					switch (vchoice) {
					case "E":
						try {
							process();
							show();
							GenerateAndPrint();
						} catch (Throwable e1) {
							e1.printStackTrace();
						}
						break;

					case "P":
						try {
							process();
							show();
							GenerateAndPrint();
						} catch (Throwable e1) {
							e1.printStackTrace();
						}
						break;

					case "R":
						try {
							GenerateForRepack();
						} catch (Throwable e1) {
							e1.printStackTrace();
						}
						break;
					}
				}
			}

			if (value == "Print") {
				gnPrintMasters br = new gnPrintMasters();
				try {
 					String vbarcodetype = barcodetype.getSelectedItem().toString();
 					switch (vbarcodetype.trim()) {
					case "S38x38(2up)":
						 PrintBarcodeFrmat = "mybarcode.jasper";
   						  br.printBarcode(PrintBarcodeFrmat);
						break;
					case "S38x38":
						String vbarcodefilename = "S38x38.Jasper";
						  br.printBarcode(PrintBarcodeFrmat);
 					case "S38x25(2up)":
						  vbarcodefilename = "S38x25.Jasper";
						  br.printBarcode(PrintBarcodeFrmat);
 					case "S75x75":
						  vbarcodefilename = "S75x75.Jasper";
						  br.printBarcode(PrintBarcodeFrmat);
  					}
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
					e1.printStackTrace();
				}
				return;
			}
		}
	}

	private void GenerateForRepack() throws Throwable {
		int row = table.getRowCount();
		if (row > 0) {
			String SQL = "delete from tmp_barcode_print";
			this.getResult(SQL);
			btnBarcode.setText("Generating Barcode For Repakcing Items ...");
			for (int i = 0; i <= row - 1; i++) {
				// String[] col = { "Article" , "Name" , "Packing" , "UOM" ,
				// "ReceivedQty" , "Packing Date" , "Sales Price", "MRP" ,
				// "Batch Item" , "BatchNo" , "Expiry Date" } ;
 				articlecode.setText(table.getValueAt(i, 0).toString());
				String EanArticle = new gnArticle().Article_getData(articlecode.getText(), "isEanArticle");
				prebarcodeitem.setText(EanArticle);
				name.setText(table.getValueAt(i, 1).toString());
				barcodefor = articlecode.getText();
				// new General().msg(barcodefor);
				String vqty = table.getValueAt(i, 4).toString();
				String vmrp = table.getValueAt(i, 7).toString();
				String vsp = table.getValueAt(i, 6).toString();
				String vname = table.getValueAt(i, 1).toString();
				String vadr1 = new gnConfig().getcompanyAdd1();
				String vadr2 = new gnConfig().getcompanyAdd2();
				vadr1 = vadr1 + "," + vadr2;
				String vadr3 = new gnConfig().getcompanyAdd3();
				String vadr4 = new gnConfig().getcompanyAdd4();
				vadr2 = vadr3 + "," + vadr4;
				String vphone = new gnConfig().getcompanyphone();
				String vemail = new gnConfig().getcompanyemail();
				String vpksize = new gnArticle().Article_getData(articlecode.getText(), "PACKSIZE");
				String vuom = new gnArticle().Article_getData(articlecode.getText(), "UOM");

				String vpackdate = new General().getDate();
				int shelflife = Integer.parseInt(new gnArticle().Article_getData(articlecode.getText(), "shelfLife"));
				String vexp = new gnConfig().get_duedate(vpackdate, shelflife);
				if (shelflife > 0) {
					bestbefore.setText(vexp);
				}
				String vexpdate = bestbefore.getText();
				String vmon = new gnDate().getMonthName(new General().getDate());
				String vyear = new gnDate().getYear(new General().getDate());
				String vsite = new gnConfig().getStoreName();
				String vparent = new gnArticle().Article_getData(articlecode.getText(), "ParentArticle");
				String vbrand = new gnArticle().Article_getData(articlecode.getText(), "BRANDNAME");
				String vcontent = new gnArticle().Article_getData(articlecode.getText(), "Content");
				try {
					SQL = "call printBarcodeData(" + barcodefor + " , '" + vname + "'  , " + vmrp + " , " + vqty
							+ " , '" + vsite + "'  , '" + vadr1 + "' , '" + vadr2 + "' ," + " '" + vadr3 + "' , '"
							+ vadr4 + "' , '" + vphone + "' ,'" + vemail + "' ,'" + vpksize + "' ,'" + vuom + "' , '"
							+ vmon + "' , '" + vyear + "' ," + "   '" + vparent + "'  ,  '" + vbrand + "' , '"
							+ vcontent + "'  , '" + vpackdate + "' ," + vsp + "   ,  '" + vexpdate + "' )";
					// new General().msg(SQL);

					EanArticle = new gnArticle().Article_getData(articlecode.getText(), "isEanArticle");
					switch (EanArticle) {
					case "N":
						this.getResult(SQL);
						break;
					case "Y":
						new General().Quickmsg("Pre Painted Barcode Article .. ");
						new gnImageSound().playAlertSound();
						new gnImageSound().playAlertSound();
						new gnImageSound().playAlertSound();
						break;
					}
				} catch (Exception e) {
					new General().msg(e.getLocalizedMessage());
				}
			} // End For Loop
			btnBarcode.setText(" Ready To Print Barcode ...");
			btnPrint.doClick();
		}

	} // End Method

	private void GenerateAndPrint() throws Throwable {
 		try{
		String SQL = "delete from tmp_barcode_print";
 		this.getResult(SQL);

		String EanArticle = new gnArticle().Article_getData(articlecode.getText(), "isEanArticle");
		switch (EanArticle) {
		case "Y":
			new General().Quickmsg("Pre Printed Barcode Article Barcode.. ");
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			break;

		case "N":
			SQL = "delete from tmp_barcode_print";
  			this.getResult(SQL);
			String vadr1 = new gnConfig().getcompanyAdd1().trim();
 			String vadr2 = new gnConfig().getcompanyAdd2().trim();
  			vadr1 = vadr1 + "," + vadr2;
    		String vadr3 = new gnConfig().getcompanyAdd3().trim();
			String vadr4 = new gnConfig().getcompanyAdd4().trim();
 			vadr2 = vadr3 + "," + vadr4;
  			String vphone = new gnConfig().getcompanyphone();
   			String vemail = new gnConfig().getcompanyemail();
			String vpksize = new gnArticle().Article_getData(articlecode.getText(), "PACKSIZE");
			String vuom = new gnArticle().Article_getData(articlecode.getText(), "UOM");
 
			String vpackdate = new General().getDate();
			//int shelflife = Integer.parseInt(new gnArticle().Article_getData(articlecode.getText(), "shelfLife"));
			//String vexp = new gnConfig().get_duedate(vpackdate, shelflife);
  			//if (shelflife > 0) {
			//	bestbefore.setText(vexp);
			//}
			String vexpdate = bestbefore.getText();
			String vmon = new gnDate().getMonthName(new General().getDate());
  			String vyear = new gnDate().getYear(new General().getDate());
   			String vsite = new gnConfig().getStoreName();
  			String vparent = new gnArticle().Article_getData(articlecode.getText(), "ParentArticle");
			String vbrand = new gnArticle().Article_getData(articlecode.getText(), "BRANDNAME");
			String vcontent = new gnArticle().Article_getData(articlecode.getText(), "Content");
  			try {
				SQL = "call printBarcodeData(" + barcodefor + " , '" + vname + "'  , " + vmrp + " , " + vqty + " , '"
						+ vsite + "'  , '" + vadr1 + "' , '" + vadr2 + "' ," + " '" + vadr3 + "' , '" + vadr4 + "' , '"
						+ vphone + "' ,'" + vemail + "' ,'" + vpksize + "' ,'" + vuom + "' , '" + vmon + "' , '" + vyear
						+ "' ," + "   '" + vparent + "'  ,  '" + vbrand + "' , '" + vcontent + "'  , '" + vpackdate
						+ "',   " + vsp + "  ,  '" + vexpdate + "')";
 				this.getSPResult(SQL);
			} catch (Exception e) {
				new General().msg(e.getLocalizedMessage());
			} // End Try catch
			break;
		} // end Switch

 		}catch(Exception e)
 		{
 			new General().msg(e.getLocalizedMessage());
 		}
 		finally{
 			btnPrint.doClick();
 		}
	}

	private void showRepackingItems() throws ClassNotFoundException, SQLException {
		String vreqno = reqno.getText();
		String vreqdate = new gnConfig().date_ConverttoDBforamt(reqdate.getText());
		String varticle = "0";
		String vtype = "GetItemsForBarcodePrinting";
		String SQL = "call repack_getData('" + vtype + "' , " + vcomp + " , " + vstore + "  , " + varticle + "  , "
				+ vreqno + " , '" + vreqdate + "')";
		String[] col = { "Article", "Name", "Packing", "UOM", "ReceivedQty", "Packing Date", "Sales Price", "MRP",
				"Batch Item", "BatchNo", "Expiry Date" };
		int colno = 11;
		new gnTable().RemoveTableRows(model);
		table = new gnTableModel().Tablemodel(table, model, SQL, col, colno, "N", "N", "N");
		// removeRow(model, table) ;
		JViewport jvp3 = new JViewport();
		jvp3.add(table);
		jsp.setViewport(jvp3);
		jsp.setVisible(true);
	}

	class keyPressedlsnr implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int value = e.getKeyCode();
			// new General().msg("Key Pressed "+ value);
			switch (value) {
			case 10:
				if (qty.isFocusOwner()) {
					mrp.grabFocus();
		 		}

				if (mrp.isFocusOwner()) {
					sp.grabFocus();
		 		}
		
				if (sp.isFocusOwner()) {
					bestbefore.grabFocus();
				}

				if (bestbefore.isFocusOwner()) {
					btnGenerate.doClick();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {

		}

		@Override
		public void keyTyped(KeyEvent arg0) {

		}
	}
	
	
class selectoptionLsnr implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
 
		String value = selectoption.getText() ;
		switch(value)
		{
		   case "1" :
			rbarticle.setSelected(true);
			name.grabFocus();
			rbbuttonsetting() ;
			break ;
		   case "2" :
			rbean.setSelected(true);
			eancode.grabFocus();
			rbbuttonsetting() ;
 			break ;
		   case "3" :
			rbrepack.setSelected(true);
			reqno.grabFocus();
			rbbuttonsetting() ;
 			break ;
 		}
 	}
 }
}// last

package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

public class ArticleBase_Master extends getResultSet {

	JFrame articlebasemasterFrame;
	
	
	public String vArticle_category;
	public String vArticle_subcategory;
	public String vArticle_group;
	public String vArticle_subGroup;
	JButton btnAddean;
	JButton btngeneral;
	JButton btnPrice;
	JButton btnHierarchy;
	
	//REsto Price Related
	
	String vapplydiffPrice = "N" ;
	String vapplyBasePriceFor = "COUNTER" ;		
	String vaddSub = "ADD" ;
	String vwalkinprice = "";
 	String vcounterprice = "";
 	String vzomatoprice = "";
	String vswiggyprice = "";
	String vtelephoneprice = "";
	String vapplyBasePriceForCounter = "N" ;
	String vapplyBasePriceForWalkin = "N" ; 
	String vapplyBasePriceForSwiggy = "N" ; 
	String vapplyBasePriceForZomato = "N" ; 
	String vapplyBasePriceForTelephone = "N" ; 
	JCheckBox checkboxbrand ;

	//REsto Price Related
	//Variabled 
	
	JButton btnSave;
	JButton btnClose;
	JScrollPane jsp;

	JTable dtable = new JTable();
	DefaultTableModel dmodel = new DefaultTableModel();

 	
	String vdate = "";
	String varticlecode = "";
	String varticlename = "";
	String varticleshortname = "";
	String vpksize = "";
	String vuom = "";
	String vtaxcode = "";
	String vmrp= "";
	String vsp= "";
    String vshortcutkey = "" ; 
	String varticletypecode = "";
	String vhsncode = "" ;
	String vbarcode = "" ;
	
	String visbarcodeitem ;
	String vistaxslabitem ;
	String visbatchtem ;

	String vbrandname= "" ;
	String vbrandcode= "";
 	String vcolorcode = "";
	String vmodelcode = "";
	String vpowercode = "";
	String vsizecode = "";
	String vfitcode = "";
	String vmaterialcode = "";

	String vcomp ;
	String vstore;
 	String vverticle ="" ;
	String vhierarchyno = "";
 	//End Vaiable 

	
	//DEfaultfields 
	String vsubcatname= "None";
	String vsubcatcode = "0";
   	String vcategorycode= "0" ;
   	String vgroupcode= "0" ;
   	String vsubgroupcode= "0" ;
   	String vmbq = "0";
   	String vrolevel = "0";
   	String vshelflife = "0" ;
   	String vreqshelflife = "0" ;
   	
	String vshelf = "N" ;
 	String vcontent = "N" ;
 	String vcontent_code = "N" ;
 	String vdrugtype = "N" ;

 	//End DEfault fileds 
	
	private JTextField articlename;
	private JTextField shortname;
	private JTextField packsize;
	private JTextField sp;
	JPanel extrapanel;
	JCheckBox taxslabapplicable;
	JCheckBox barcodeitem;
	JCheckBox batchitem;

	private JTextField mrp;
	private JTextField tax;
	private JTextField uom;
	private JTextField articletype;
	private JTextField atypecode;
	private JTextField articlecode;
	private JTextField shortcutkey;
	private JTextField colorname;
	private JTextField colorcode;
	private JTextField sizename;
	private JTextField sizecode;
	private JTextField modelname;
	private JTextField modelcode;
	private JTextField powername;
	private JTextField powercode;
	private JTextField materialname;
	private JTextField materialcode;
	private JTextField fitname;
	private JTextField fitcode;
	private JTextField brandname;
	private JTextField brandcode;
	private JCheckBox additionalinfo;
	private JTextField barcode;
	private JTextField hsncode;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JTextField searchname;
	private JLabel lblNewLabel_20;
	private JTextField subcatname;
	private JTextField subcatcode;
	private JLabel lblNewLabel_21;
	private JTextField mbq;
	private JLabel lblNewLabel_22;
	private JTextField rolevel;
	private JLabel lblNewLabel_23;
	private JTextField shelflife;
	private JLabel lblNewLabel_24;
	private JTextField reqshelflife;
	private JPanel panelBrand;
	private JButton btnChild;
	private JTextField innerqty;
	private JTextField markdown;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticleBase_Master window = new ArticleBase_Master();
					window.articlebasemasterFrame.setVisible(true);
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
	 * @throws Throwable 
	 */
	public ArticleBase_Master() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Throwable 
	 */
	private void initialize() throws Throwable {
		articlebasemasterFrame = new JFrame();
		articlebasemasterFrame.setAlwaysOnTop(true);
		articlebasemasterFrame.getContentPane().setBackground(Color.CYAN);
		articlebasemasterFrame.setBounds(100, 100, 997, 588);
		articlebasemasterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		articlebasemasterFrame.getContentPane().setLayout(null);
		
		articlename = new JTextField()
		{
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		articlename.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		articlename.setBounds(12, 21, 382, 30);
		articlebasemasterFrame.getContentPane().add(articlename);
		articlename.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name(50 Chars)");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 4, 116, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Short Name (30 chars)");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_1.setBounds(12, 52, 184, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel_1);
		
		shortname = new JTextField();
		shortname.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		shortname.setBounds(12, 68, 382, 30);
		articlebasemasterFrame.getContentPane().add(shortname);
		shortname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Pack Size");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_2.setBounds(22, 108, 70, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel_2);
		
		packsize = new JTextField();
		packsize.setBounds(97, 96, 227, 30);
		articlebasemasterFrame.getContentPane().add(packsize);
		packsize.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("SalesPrice");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_3.setBounds(22, 195, 70, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel_3);
		
		sp = new JTextField();
		sp.setBounds(97, 188, 227, 30);
		articlebasemasterFrame.getContentPane().add(sp);
		sp.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("MRP");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_4.setBounds(54, 165, 38, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel_4);
		
		mrp = new JTextField();
		mrp.setBounds(97, 158, 227, 30);
		articlebasemasterFrame.getContentPane().add(mrp);
		mrp.setColumns(10);
		
		tax = new JTextField();
		tax.setBounds(97, 215, 227, 30);
		articlebasemasterFrame.getContentPane().add(tax);
		tax.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tax");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_5.setBounds(25, 224, 60, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel_5);
		
		jsp = new JScrollPane();
		jsp.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		jsp.setBounds(12, 382, 955, 161);
		articlebasemasterFrame.getContentPane().add(jsp);
		
		uom = new JTextField();
		uom.setFont(new Font("Tahoma", Font.BOLD, 13));
		uom.setBounds(97, 128, 227, 30);
		articlebasemasterFrame.getContentPane().add(uom);
		uom.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("UOM");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_6.setBounds(54, 137, 38, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Article Type");
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNewLabel_7.setBounds(397, 54, 131, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel_7);
		
		articletype = new JTextField();
		articletype.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		articletype.setText("Normal");
		articletype.setBounds(397, 68, 259, 30);
		articlebasemasterFrame.getContentPane().add(articletype);
		articletype.setColumns(10);
		
		atypecode = new JTextField();
		atypecode.setEditable(false);
		atypecode.setText("1");
		atypecode.setBounds(663, 65, 24, 30);
		articlebasemasterFrame.getContentPane().add(atypecode);
		atypecode.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Article Code");
		lblNewLabel_8.setBounds(397, 4, 92, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel_8);
		
		articlecode = new JTextField();
		articlecode.setFont(new Font("Tahoma", Font.BOLD, 15));
		articlecode.setForeground(Color.GREEN);
		articlecode.setBackground(Color.DARK_GRAY);
		articlecode.setBounds(398, 21, 116, 30);
		articlebasemasterFrame.getContentPane().add(articlecode);
		articlecode.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Shortcut Key");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(12, 316, 77, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel_9);
		
		shortcutkey = new JTextField();
		shortcutkey.setBounds(97, 309, 227, 30);
		articlebasemasterFrame.getContentPane().add(shortcutkey);
		shortcutkey.setColumns(10);
		
		extrapanel = new JPanel();
		extrapanel.setBorder(new TitledBorder(null, "Item Additional Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		extrapanel.setBackground(Color.CYAN);
		extrapanel.setBounds(708, 31, 259, 119);
		articlebasemasterFrame.getContentPane().add(extrapanel);
		extrapanel.setLayout(null);
		
		colorname = new JTextField();
		colorname.setBounds(57, 23, 148, 22);
		extrapanel.add(colorname);
		colorname.setColumns(10);
		
		colorcode = new JTextField();
		colorcode.setText("0");
		colorcode.setBounds(209, 23, 38, 22);
		extrapanel.add(colorcode);
		colorcode.setColumns(10);
		
		sizename = new JTextField();
		sizename.setBounds(57, 47, 148, 22);
		extrapanel.add(sizename);
		sizename.setColumns(10);
		
		sizecode = new JTextField();
		sizecode.setText("0");
		sizecode.setBounds(209, 47, 38, 22);
		extrapanel.add(sizecode);
		sizecode.setColumns(10);
		
	 
		 
		JLabel lblNewLabel_10 = new JLabel("Color");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(12, 26, 56, 16);
		extrapanel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_13 = new JLabel("Size");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_13.setBounds(12, 50, 56, 16);
		extrapanel.add(lblNewLabel_13);
		
		materialname = new JTextField();
		materialname.setBounds(57, 70, 148, 22);
		extrapanel.add(materialname);
		materialname.setColumns(10);
		
		materialcode = new JTextField();
		materialcode.setText("0");
		materialcode.setBounds(209, 70, 38, 22);
		extrapanel.add(materialcode);
		materialcode.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Material");
		lblNewLabel_14.setBounds(12, 73, 50, 16);
		extrapanel.add(lblNewLabel_14);
		
		fitname = new JTextField();
		fitname.setBounds(57, 94, 148, 22);
		extrapanel.add(fitname);
		fitname.setColumns(10);
		
		fitcode = new JTextField();
		fitcode.setText("0");
		fitcode.setBounds(209, 94, 38, 22);
		extrapanel.add(fitcode);
		fitcode.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Fit");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setBounds(12, 97, 44, 16);
		extrapanel.add(lblNewLabel_15);
		
		brandcode = new JTextField();
		brandcode.setText("0");
		brandcode.setBounds(209, 165, 38, 22);
		extrapanel.add(brandcode);
		brandcode.setColumns(10);
		
		subcatcode = new JTextField();
		subcatcode.setText("0");
		subcatcode.setBounds(209, 194, 38, 22);
		extrapanel.add(subcatcode);
		subcatcode.setColumns(10);
		
		
 		
		barcodeitem = new JCheckBox("Barcode Item");
		barcodeitem.setBackground(Color.CYAN);
		barcodeitem.setBounds(563, 262, 113, 25);
		articlebasemasterFrame.getContentPane().add(barcodeitem);
		
		batchitem = new JCheckBox("Enable Batch Management");
		batchitem.setBackground(Color.CYAN);
		batchitem.setBounds(563, 286, 184, 25);
		articlebasemasterFrame.getContentPane().add(batchitem);
		
		taxslabapplicable = new JCheckBox("Tax Slab Applicable");
		taxslabapplicable.setBackground(Color.CYAN);
		taxslabapplicable.setBounds(563, 307, 160, 25);
		articlebasemasterFrame.getContentPane().add(taxslabapplicable);
		
 		
		additionalinfo = new JCheckBox("Additional Info");
		additionalinfo.setBounds(708, 4, 113, 25);
		articlebasemasterFrame.getContentPane().add(additionalinfo);
		
		barcode = new JTextField();
		barcode.setBounds(97, 280, 227, 30);
		articlebasemasterFrame.getContentPane().add(barcode);
		barcode.setColumns(10);
		
		hsncode = new JTextField();
		hsncode.setBounds(97, 248, 227, 30);
		articlebasemasterFrame.getContentPane().add(hsncode);
		hsncode.setColumns(10);
		
		lblNewLabel_17 = new JLabel("HSNCODE");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_17.setBounds(22, 255, 70, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("BARCODE");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_18.setBounds(22, 287, 70, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel_18);
		
		btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(563, 344, 97, 25);
		articlebasemasterFrame.getContentPane().add(btnSave);
		
 		
	    btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(661, 344, 97, 25);
		articlebasemasterFrame.getContentPane().add(btnClose);
		
		lblNewLabel_19 = new JLabel("Search By Name");
		lblNewLabel_19.setBounds(13, 337, 484, 16);
		articlebasemasterFrame.getContentPane().add(lblNewLabel_19);
		
		searchname = new JTextField();
		searchname.setBounds(12, 351, 485, 30);
		articlebasemasterFrame.getContentPane().add(searchname);
		searchname.setColumns(10);
		
		panelBrand = new JPanel();
		panelBrand.setBorder(new MatteBorder(3, 4, 3, 4, (Color) new Color(0, 0, 0)));
		panelBrand.setBackground(Color.WHITE);
		panelBrand.setBounds(328, 121, 227, 226);
		articlebasemasterFrame.getContentPane().add(panelBrand);
		panelBrand.setLayout(null);
		
		JLabel lblNewLabel_16 = new JLabel("Brand");
		lblNewLabel_16.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		lblNewLabel_16.setBounds(19, 19, 56, 16);
		panelBrand.add(lblNewLabel_16);
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
		
		brandname = new JTextField();
		brandname.setBounds(87, 13, 126, 28);
		panelBrand.add(brandname);
		brandname.setText("No Brand");
		brandname.setColumns(10);
		
		lblNewLabel_20 = new JLabel("SubCategory");
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_20.setBounds(12, 48, 73, 16);
		panelBrand.add(lblNewLabel_20);
		lblNewLabel_20.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		
		subcatname = new JTextField();
		subcatname.setBounds(85, 45, 128, 22);
		panelBrand.add(subcatname);
		subcatname.setText("No Hierarchy");
		subcatname.setColumns(10);
		
		lblNewLabel_23 = new JLabel("Shelf Life");
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_23.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		lblNewLabel_23.setBounds(30, 80, 56, 16);
		panelBrand.add(lblNewLabel_23);
		
		shelflife = new JTextField();
		shelflife.setBounds(93, 77, 120, 22);
		panelBrand.add(shelflife);
		shelflife.setText("0");
		shelflife.setColumns(10);
		
		lblNewLabel_24 = new JLabel("Req.ShelfLife");
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_24.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		lblNewLabel_24.setBounds(12, 105, 75, 16);
		panelBrand.add(lblNewLabel_24);
		
		reqshelflife = new JTextField();
		reqshelflife.setBounds(93, 102, 120, 22);
		panelBrand.add(reqshelflife);
		reqshelflife.setText("0");
		reqshelflife.setColumns(10);
		
		lblNewLabel_21 = new JLabel("MBQ");
		lblNewLabel_21.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		lblNewLabel_21.setBounds(34, 129, 50, 16);
		panelBrand.add(lblNewLabel_21);
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.RIGHT);
		
		mbq = new JTextField();
		mbq.setBounds(93, 126, 120, 22);
		panelBrand.add(mbq);
		mbq.setText("0");
		mbq.setColumns(10);
		
		lblNewLabel_22 = new JLabel("RO LEVEL");
		lblNewLabel_22.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_22.setBounds(19, 155, 71, 16);
		panelBrand.add(lblNewLabel_22);
		
		rolevel = new JTextField();
		rolevel.setBounds(93, 152, 120, 22);
		panelBrand.add(rolevel);
		rolevel.setText("0");
		rolevel.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("InnerQty");
		lblNewLabel_11.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_11.setBounds(19, 175, 67, 16);
		panelBrand.add(lblNewLabel_11);
		
		innerqty = new JTextField();
		innerqty.setText("1");
		innerqty.setBounds(93, 172, 120, 22);
		panelBrand.add(innerqty);
		innerqty.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("MarkDown%");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		lblNewLabel_12.setBounds(12, 198, 74, 15);
		panelBrand.add(lblNewLabel_12);
		
		markdown = new JTextField();
		markdown.setText("0");
		markdown.setBounds(93, 194, 120, 22);
		panelBrand.add(markdown);
		markdown.setColumns(10);
		
		checkboxbrand = new JCheckBox("Brand & Hierarchy");
		checkboxbrand.setBounds(332, 99, 228, 25);
		articlebasemasterFrame.getContentPane().add(checkboxbrand);
		
		btnAddean = new JButton("Add EAN");
		btnAddean.setBounds(870, 344, 97, 25);
		articlebasemasterFrame.getContentPane().add(btnAddean);
		
 		
		btngeneral = new JButton("Brand");
		btngeneral.setBounds(851, 195, 116, 25);
		articlebasemasterFrame.getContentPane().add(btngeneral);
		
		btnPrice = new JButton("Price Change");
 		btnPrice.setBounds(759, 344, 116, 25);
		articlebasemasterFrame.getContentPane().add(btnPrice);
		
		btnHierarchy = new JButton("Hierarchy");
		btnHierarchy.setBounds(851, 220, 116, 25);
		articlebasemasterFrame.getContentPane().add(btnHierarchy);
 
		
		btnChild = new JButton("Child Mapping");
		btnChild.setBounds(851, 246, 113, 25);
		articlebasemasterFrame.getContentPane().add(btnChild);
 	
		
		ActionListener btnls =  new btnLsnr();
 				
		btnSave.addActionListener(btnls);
		btnClose.addActionListener(btnls);
		btnHierarchy.addActionListener(btnls);
		btngeneral.addActionListener(btnls);
		btnPrice.addActionListener(btnls);
		btnAddean.addActionListener(btnls);
		btnChild.addActionListener(btnls);
		
		ActionListener  artuomls =  new ArticleUom();
		uom.addActionListener(artuomls);

		ActionListener  arttaxls =  new ArticleTax();
		tax.addActionListener(arttaxls);

		ActionListener  arttypels =  new ArticleType();
		articletype.addActionListener(arttypels);
 		
		ActionListener  artcolorls =  new ArticleColor();
		colorname.addActionListener(artcolorls);
		
		ActionListener  artsizels =  new ArticleSize();
		sizename.addActionListener(artcolorls);
		
		ActionListener  artsearchls =  new seasrchnameLsnr();
		searchname.addActionListener(artsearchls);
 		
		ActionListener  chkextrainfo =  new extrainfoLsnr();
		additionalinfo.addActionListener(chkextrainfo);
		
		KeyListener kk = new  keyPressedlsnr();
		
		subcatname.addKeyListener(kk);
		shelflife.addKeyListener(kk);
		reqshelflife.addKeyListener(kk);
		mbq.addKeyListener(kk);
		rolevel.addKeyListener(kk);
 		articlename.addKeyListener(kk);
		shortname.addKeyListener(kk);
 		articletype.addKeyListener(kk);
		packsize.addKeyListener(kk);
  		uom.addKeyListener(kk);
		tax.addKeyListener(kk);
		mrp.addKeyListener(kk);
		sp.addKeyListener(kk);
		barcode.addKeyListener(kk);
		hsncode.addKeyListener(kk);
		colorname.addKeyListener(kk);
		materialname.addKeyListener(kk);
		fitname.addKeyListener(kk);
		sizename.addKeyListener(kk);
		shortcutkey.addKeyListener(kk);
  		
		ActionListener xnamels = new namels();
		articlename.addActionListener(xnamels);
		brandname.addKeyListener(kk);

		
		ActionListener  brandinfo =  new brandinfoLsnr();
		checkboxbrand.addActionListener(brandinfo);

		ActionListener  branLsnr =  new ArticleBrand();
		brandname.addActionListener(branLsnr);
		
		ActionListener  subcatLsnr =  new ArticleHierarchy() ;
		subcatname.addActionListener(subcatLsnr);
		
		decorate();
		
	}
 	
private void decorate() throws Throwable
{

		btngeneral.setVisible(false);
		btnChild.setVisible(false);
		btnHierarchy.setVisible(false);

	  panelBrand.setVisible(false);
	  articlename.setDocument(new gnSetinputLimit(50));
	  shortname.setDocument(new gnSetinputLimit(30));
	  articlename.setText(articlename.getText().toUpperCase());
	  shortname.setText(articlename.getText().toUpperCase());
 	  extrapanel.setVisible(false);
 	  vcomp  = new gnConfig().getCompanyCode();
	  vstore = new gnConfig().getStoreID();
 	  vverticle = new gnHierarchy().getVerticleCode();
	  vhierarchyno = new gnHierarchy().getHierarchyNo();

	  switch(vverticle)
	  {
	  case "1":
		  additionalinfo.setVisible(false);
 		  articletype.setEnabled(false);
		  break ;
 	  case "3" :
		  additionalinfo.setVisible(false);
  		  articletype.setEnabled(true);
		  break ;
	  case "15" :
		  additionalinfo.setVisible(false);
 		  articletype.setEnabled(true);
		  break ;
	  case "7" :
		  additionalinfo.setVisible(true);
 		  articletype.setEnabled(true);
		  break ;
 	  default :
		  articletype.setEnabled(false);
		  break ;
 	  }

}


class btnLsnr implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent e) {
 
 		String value = e.getActionCommand();
 		if(value == "Save")
 		{
 			
 			
  			String satus = validate();
 			if (satus == "Sucess")
 			{
  				try 
 				{
  	 				satus = checkBarcodeExist();

  	 				if (satus == "Sucess")
  	 				{
					articlecode.setText(new gnSeq().getSeqno("906", "MS"));
					varticlecode = articlecode.getText() ;
					callSaveEvent();
  	 				}	
 				} catch (Throwable e2) 
 			
 				
 				{
 					e2.printStackTrace();
				}  
    		}		
 		}

 		if(value == "Close")
 		{
 			articlebasemasterFrame.dispose();
 		}

		
		if (value == "Child Mapping")
		{
 			try {
 				RepackingModule window;
  				window = new RepackingModule();
				window.RepackingFrame.setVisible(true);
 			} catch (Throwable e1) {
 				e1.printStackTrace();
			}
  		}
	
		
		if (value == "Hierarchy" )
		{
	 		try {
	 			hie_Assignment window;
 	 			window = new hie_Assignment();
				window.hie_Assignment_frame.setVisible(true);
 			} catch (Throwable e1) {
 				e1.printStackTrace();
			}
  		}
		
		if (value == "Price Change" )
		{
 			try {
 				updatePrice window;
  				window = new updatePrice();
				window.updatePriceFrame.setVisible(true);
 			} catch (Throwable e1) {
 				e1.printStackTrace();
			}
  		}

		
		if (value == "Brand" )
		{
 			try {
 				CreateGeneralMaster window;
  				window = new CreateGeneralMaster();
				window.masterFrame.setVisible(true);
 			} catch (Throwable e1) {
 				e1.printStackTrace();
			}
  		}
 
 		if(value == "Add EAN")
 		{
			BarcodeMapping window = new BarcodeMapping();
			window.frameBarcodeMapping.setVisible(true);
   	
 		}

 		
	}
 }




private String  validate()
{
	
	//new General().Quickmsg("Validating Now...");
	String status = "Sucess" ;
	varticlecode = "";
	  
	  
	if (barcode.getText().length() >0 )
	{
		barcodeitem.setSelected(true);
	}
	else
	{
		barcodeitem.setSelected(false);
 	}
	  
	  vdate = new General().getDate();
	  vbarcode = barcode.getText();
	  vhsncode =  hsncode.getText();
	  varticlename = articlename.getText();
	  varticleshortname = shortname.getText();
	  vpksize = packsize.getText();
	  vuom = uom.getText();
	  vtaxcode = tax.getText();
	  vmrp= mrp.getText() ;
	  vsp= sp.getText();
      vshortcutkey = shortcutkey.getText(); 
	  varticletypecode = atypecode.getText();
	  
		vbrandname= brandname.getText() ;
		vbrandcode= brandcode.getText();
	 	String vcolorcode = colorcode.getText();
		String vmodelcode = "";
		String vpowercode = "";
		String vsizecode =  sizecode.getText();
		String vfitcode = fitcode.getText();
		String vmaterialcode = materialcode.getText();

		  vsubcatname=  subcatname.getText() ;
		  vsubcatcode =  subcatcode.getText();
	   	  //vcategorycode= "0";
	   	  //vgroupcode=  "0";
	   	  //vsubgroupcode= "0" ;
	   	  vmbq =  mbq.getText();
	   	  vrolevel =  rolevel.getText();
	   	  vshelflife =  shelflife.getText();
	   	  vreqshelflife =  reqshelflife.getText();
 		
		  if (varticlename.length()==0)
		  {
			  status = "Fail";
			  articlename.grabFocus();
			  new General().msg("Enter Name .. ");
		  }
		  


		  if (varticleshortname.length()==0)
		  {
			  status = "Fail";
			  shortname.grabFocus();
			  new General().msg("Enter Short  Name .. ");
		  }

		  if(vuom.length() == 0 )
		  {
			  status = "Fail";
			  uom.grabFocus();
			  new General().msg("Select uom .. ");
			  
		  }
		  
		  if (vmrp.length()==0)
		  {
			  mrp.setText("0");
	 	  }

		  if (vsp.length()==0)
		  {
			  mrp.setText("0");
	 	  }


		  if (vtaxcode.length()==0)
		  {
			  status = "Fail";
			  tax.grabFocus();
			  new General().msg("Enter Tax Code .. ");
	  	  }

		

		  if (varticletypecode.length()==0)
		  {
			  status = "Fail";
			  articletype.grabFocus();
			  new General().msg("Select Article Type  .. ");
	  	  }

	  
	  boolean xisbarcodeitem =		barcodeitem.isSelected();

	  if(xisbarcodeitem)
	  {
		  visbarcodeitem = "Y";
	  }
	  else
	  {
		  visbarcodeitem = "N";
 	  }
	  
	  boolean xisbatchitem = batchitem.isSelected();
	  if (xisbatchitem)
	  {
		  visbatchtem= "Y";  
	  }
	  else
	  {
		  visbatchtem= "N";  
		  
	  }
	  
	  boolean xistaxslabitem = taxslabapplicable.isSelected();
 
	  if(xistaxslabitem)
	  {
		  vistaxslabitem = "Y" ;
		  
	  }
	  else
	  {
		  vistaxslabitem = "N" ;
	  }
  
		//new General().msg("Validating Status is ..."+" "+ status);
	  
	  
 	  return status;
  }



public String callSaveEvent() throws Throwable {
	

	//new General().msg("Saving Data Now  ..." );

	prst = null;
	final int batchSize = 10;
	int TotalRecordinsert = 0;
	// this.closeconn();
	String status = "Fail";
	Connection con = this.getConnection();
	con.setAutoCommit(false);
	String hie = "INSERT INTO  msarticle_master ( Company_code , Article_code ,Item_code ,"
			+ " Name ,POS_NAME ,Auto_Generate_Name ," + " UOM ,DefaultEAN ,DefaultVendor ,"
			+ "DefaultLocation , SalesUOM ,Article_Type ," + "Article_Class ,Trading_Article , MRPBaseArticle ,"
			+ "Article_category ,Article_subCategory ,Article_Group ," + "Article_SubGroup , "
			+ "Tax_code ,Tax_Per ,"
			+ "Manuf ,Brand , Markup ," + "MarkDown ,Margin ,MRP ," + "cost ,SalesPrice,Pack_Type ,"
			+ "PackSiZe , Pack_Form ,Active ," + "ParentArticle ,ProcessLoss_per ,Inner_Pack_size ,"
			+ "Inner_Pack_qty ,Color ,Size ," + "Fit ,Fabric ,Style ,"
			+ "Pattern ,Batch_control_Article ,Max_ShelfLife ,"
			+ "Min_shelfLife , ShelfLife_In_days_Month ,Verticle ,"
			+ "CreatedBy ,CreateDate ,segment ,hierarchyno ," + " basecost, basemrp, basesp, srno, mbq, "
			+ "rolevel, ean_article, content, hsncode, drugType , " + "content_code, PurchaseUOM, "
			+ "MaintainInventory, brandname, subCatname , ApplyTaxSlab, Description , "
			+ "shelf , LC)"
			+ "values(?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
			+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	try {
		prst = con.prepareStatement(hie);
		prst.setString(1, vcomp);
		prst.setString(2, varticlecode);
		prst.setString(3, varticlecode);
		prst.setString(4, varticlename);
		prst.setString(5, varticleshortname);
		prst.setString(6, varticleshortname);
		prst.setString(7, vuom);
		prst.setString(8, vbarcode);
		prst.setString(9, "0");
		prst.setString(10, "SL");
		prst.setString(11, vuom);
		prst.setString(12, varticletypecode);
		prst.setString(13, "B");
		prst.setString(14, "Y");
		prst.setString(15, "Y");
		prst.setString(16, vcategorycode);
		prst.setString(17, vsubcatcode);
		prst.setString(18, vgroupcode);
		prst.setString(19, vsubgroupcode);
		prst.setString(20, vtaxcode);
		prst.setString(21, vtaxcode);
		prst.setString(22, "0");
		prst.setString(23, brandcode.getText());
		prst.setString(24, "0");
		prst.setString(25, markdown.getText());
		prst.setString(26, "0" );
		prst.setString(27, vmrp);
		prst.setString(28, "0");
		prst.setString(29, vsp);
		prst.setString(30, "0");
		prst.setString(31, vpksize);
		prst.setString(32, "0");
		prst.setString(33, "Y");
		prst.setString(34, varticlecode);
		prst.setString(35, "0");
		prst.setString(36, "0");
		prst.setString(37, innerqty.getText()); //InnerPakcQty
		prst.setString(38, vcolorcode);
		prst.setString(39, vsizecode);
		prst.setString(40, vfitcode);
		prst.setString(41, vmaterialcode);
		prst.setString(42, "0");
		prst.setString(43, "0");
		prst.setString(44, visbatchtem);
		prst.setString(45, "0");
		prst.setString(46, "0");
		prst.setString(47, "D");
		prst.setString(48, vverticle);
		prst.setString(49, ucode);
		prst.setString(50, vdate);
		prst.setString(51, "0");
		prst.setString(52, vhierarchyno);
		prst.setString(53, "0");
		prst.setString(54, vmrp);
		prst.setString(55, vsp);
		prst.setString(56, "1");
		prst.setString(57, "0");
		prst.setString(58, "0");
		prst.setString(59, visbarcodeitem);
		prst.setString(60, vcontent);
		prst.setString(61, vhsncode);
		prst.setString(62, "0");
		prst.setString(63, "0");
		prst.setString(64, vuom);
		prst.setString(65, "Y");
		prst.setString(66, brandname.getText());
		prst.setString(67, vsubcatname);
		prst.setString(68, vistaxslabitem);
		prst.setString(69, vshortcutkey);
		prst.setString(70, "0");
		prst.setString(71, "0");
		prst.addBatch();
		TotalRecordinsert = TotalRecordinsert + 1;
		if (++TotalRecordinsert % batchSize == 0) {
			prst.executeBatch();
			status = "Sucess";
			con.commit();
		}
		prst.executeBatch();
		con.commit();
 			new General().Quickmsg("Data Saved Sucessfully");
			new gnSeq().updateSeqno("906", "MS");
			reset();
  	} catch (SQLException e) {
		new General().msg(e.getMessage());
		con.rollback();
		status = "Fail";
	} finally {
		if (prst != null) {
			prst.close();
		}
		if (con != null) {
			con.close();
 			String SQL55 = "call  EAN_InsertEan(" + vcomp + ")";
 			this.getSPResult(SQL55);
	 }
	}
	return status;
}






class ArticleModel implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String value = e.getActionCommand();
		int i = e.getID(); // Field id
		// System.out.println("Value" +value) ;
		// System.out.println("Field id"+i);
		String vtype = "VECH_MODEL";
		try {
	         vmastersearchString = "%" + modelname.getText() + "%";
			 table = new gnAdmin().showMasterTableinTable(vtype,  vmastersearchString);
             viewData(table);
			//vmastersearchString = "%" + modelname.getText() + "%";
			//new gnAdmin().showMasterTable(vtype, modelcode, modelname);
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}


class ArticlePower implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String value = e.getActionCommand();
		int i = e.getID(); // Field id
		// System.out.println("Value" +value) ;
		// System.out.println("Field id"+i);
		String vtype = "POWER";
		try {

	         vmastersearchString = "%" + powername.getText() + "%";
			 table = new gnAdmin().showMasterTableinTable(vtype,  vmastersearchString);
             viewData(table);
 			 //vmastersearchString = "%" + powername.getText() + "%";
			//new gnAdmin().showMasterTable(vtype, powercode, powername);
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}


class ArticleUom implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String value = e.getActionCommand();
		int i = e.getID(); // Field id
		String vtype = "Uom";
		try {
				vmastersearchString = "%" + uom.getText() + "%";
			table = new gnAdmin().showMasterTableinTable(vtype,  vmastersearchString);
			viewData(table);
			} catch (Throwable e1) {
			e1.printStackTrace();
		}
	}
}


class ArticleColor implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String value = e.getActionCommand();
		int i = e.getID(); // Field id
		String vtype = "Color";
		try {
			vmastersearchString = "%" + colorname.getText() + "%";
			    table = new gnAdmin().showMasterTableinTable(vtype,  vmastersearchString);
			viewData(table);
			} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

class ArticleHierarchy implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String value = e.getActionCommand();
		int i = e.getID(); // Field id
		try {
			String vtext = subcatname.getText();
			vtext = "%" + vtext + "%";
			showHierarchy(vtext);
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
	}
}


public void showHierarchy(String vsearchname) throws Throwable {
	try {
		// new gnHierarchy().showHierarchy(vsearchname);
		new gnHierarchy().showArticleHierarchy(vsearchname);
		String vname = "SubCategory";
		// new gnHierarchy().getHierarchyInfo(vname, vsearchname );
	} catch (Throwable e) {
		e.printStackTrace();
	} finally {

		if (new gnHierarchy().vArticle_subcategory.length() > 0) {
			subcatcode.setText(new gnHierarchy().vArticle_subcategory);
			subcatname.setText(new gnHierarchy().vArticle_subCatname);
			String vvsubcatcode = subcatcode.getText();
			new gnHierarchy().getSubcatLevels(vvsubcatcode);
			vcategorycode = new gnHierarchy().vArticle_category;
			vsubcatcode = new gnHierarchy().vArticle_subcategory;
			vgroupcode = new gnHierarchy().vArticle_group;
			vsubgroupcode = new gnHierarchy().vArticle_subGroup;
  
		}
	}
}




class ArticleBrand implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String value = e.getActionCommand();
		int i = e.getID(); // Field id
		String vtype = "Brand";
		try {
			vmastersearchString = "%" + brandname.getText() + "%";
			    table = new gnAdmin().showMasterTableinTable(vtype,  vmastersearchString);
			viewData(table);
			} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}





class ArticleTax implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String value = e.getActionCommand();
		int i = e.getID(); // Field id
		String vtype = "Tax";
		try {
			// new gnAdmin().showTax(vtype, tax_code, tax_per);
			         vmastersearchString = "%" + tax.getText() + "%";
					 table = new gnAdmin().showMasterTableinTable(vtype,  vmastersearchString);
				     viewData(table);
			} catch (Throwable e1) {
 			e1.printStackTrace();
		}
	}
}
 


class ArticleType implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String value = e.getActionCommand();
		int i = e.getID(); // Field id
		String vtype = "ARTICLE_TYPE";
		try {
			// new gnAdmin().showTax(vtype, tax_code, tax_per);
			         vmastersearchString = "%" + articletype.getText() + "%";
					 table = new gnAdmin().showMasterTableinTable(vtype,  vmastersearchString);
				     viewData(table);
			} catch (Throwable e1) {
 			e1.printStackTrace();
		}
	}
}
 

class ArticleSize implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String value = e.getActionCommand();
		int i = e.getID(); // Field id
 		String vtype = "Size";
		try {
			vmastersearchString = "%" + sizename.getText() + "%";
			 table = new gnAdmin().showMasterTableinTable(vtype,  vmastersearchString);
		     viewData(table);
 		} catch (Throwable e1) {
 			e1.printStackTrace();
		}
	}
}


 




private void viewData(JTable table) throws ClassNotFoundException, SQLException
{
		String[] custCol = { "Type", "Code", "Description" };
		dtable = table;
		new gnTable().setTablewidth(table, 2, 300);
		new gnTable().setTablewidth(table, 1, 300);
		new gnTable().setTablewidth(table, 0, 75);
		dtable.setEnabled(true);
		dtable.setGridColor(Color.gray);
		dtable.setEditingRow(0);
		dtable.setEditingColumn(1);
		dtable.setBackground(Color.WHITE);
		dtable.setForeground(Color.blue);
		dtable.setAutoCreateRowSorter(true);
		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.CYAN);
		prt1.add(dtable, custCol);
		prt1.setVisible(true);
		jsp.setViewport(prt1);
		new gnFontSetting().setMyFont(table, "F2", 12);
		dtable.requestFocusInWindow();
		dtable.requestFocus();
		selectRow();

}




public void selectRow() {
	dtable.requestFocus();
	dtable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
	dtable.getActionMap().put("enter", new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
				int row = dtable.getSelectedRow();
			String value =   dtable.getValueAt(row, 0).toString().trim();
			String vcode =   dtable.getValueAt(row, 1).toString().trim();
			String vdesc =   dtable.getValueAt(row, 2).toString().trim();
				try {
					switch(value.toUpperCase())
					{
					case "UOM" :
						uom.setText(vdesc);
						mrp.grabFocus();
						break ;
					case "TAX" :
						tax.setText(vdesc);
						hsncode.grabFocus();
						break ;
						
					case "ARTICLE_TYPE" :
						atypecode.setText(vcode);
						articletype.setText(vdesc);
						packsize.grabFocus();
						break ;
							
						 
					case "BRAND" :
					brandcode.setText(vcode);
					brandname.setText(vdesc);
					break ;
						
					case "COLOR" :
						colorname.setText(vdesc);
						colorcode.setText(vcode) ;
						break ;
					
					case "MODEL" :
						modelcode.setText(vcode);
 						modelname.setText(vdesc);
						vmodelcode = vcode ;
  						break ;
					
					case "POWER" :
						powername.setText(vdesc);
						powercode.setText(vcode);
 						vpowercode = vcode ;
						break ;
					
					}
			} catch (Throwable e1) {
				e1.printStackTrace();
				new gnLogger().loggerInfoEntry("Article-Create", e1.getMessage());
			}
				finally{
					new gnTable().RemoveTableRows(dmodel);
				}
		}
	});
}



//Search Related 

class seasrchnameLsnr implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent arg0) {
 			try {
				doAction();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 	}
}

private void doAction() throws ClassNotFoundException, SQLException {
	String SQL = "";
	String vsearch = "";
	String vtype = "";
	vsearch = searchname.getText();
	vtype = "NewArticle";
	vsearch = "%" + vsearch + "%";
	showArticleData(vsearch, vtype);
}

private void showArticleData(String vname, String vtype) throws ClassNotFoundException, SQLException {

	//String[] newcol = { "Article Code", "Name", "HSNCODE", "PkSize", "UOM", "SalesPrice", "MRP", "Cost", "Tax code",
	//		"Batch(Y/N)", "Brand", "Brand Name", "Subcatcode", "SubCatName" };

	String[] newcol = { "Article Code", "Name", "HSNCODE", "PkSize", "UOM", "SalesPrice"};
	 
	// String vtype = "Article" ;
	new gnTable().RemoveTableRows(dmodel);
	model.setColumnIdentifiers(newcol);
	table.setModel(dmodel);
	String vverticlecode = new gnHierarchy().getVerticleCode();
	String SQL = "Call  article_getDataForupdate('" + vtype + "', " + compcode + ", '" + vname + "' , "
			+ vverticlecode + ")";
	new gnTableModel().Tablemodel(table, model, SQL, newcol, 6, "N", "N", "N");

	JViewport prt766 = new JViewport();
	prt766.setBackground(new Color(204, 255, 255));
	prt766.add(table, newcol);
	prt766.setVisible(true);
	jsp.setViewport(prt766);
	table.requestFocus();
	table.grabFocus();
	table.setSelectionBackground(Color.WHITE);
	table.setSelectionForeground(Color.BLACK);
	new gnTable().setTablewidth(table, 1, 450);
	new gnTable().setTablewidth(table, 2, 10);
	new gnTable().setTablewidth(table, 3, 10);
	new gnTable().setTablewidth(table, 4, 10);
	new gnTable().setTablewidth(table, 5, 70);
	
	new gnTable().setTableBasics(table);

	selectDisplayItem();

}

public void selectDisplayItem() {
	table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
	table.requestFocus();
	table.getActionMap().put("enter", new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			int row = table.getSelectedRow();
			try {
				showitem(row);
			} catch (Throwable e1) {
				new General().msg(e1.getLocalizedMessage());
			}
			;
		}
	});
}

private void showitem(int row) throws Throwable {
	super.vmyarticlecode = table.getValueAt(row, 0).toString();
	super.varticlename = table.getValueAt(row, 1).toString();
	// new General().msg(super.vmyarticlecode);
	// new General().msg(super.varticlename);
	try {
		Artilce_otherInfo window;
		window = new Artilce_otherInfo();
		window.ArticleViewFrame.setVisible(true);
	} catch (Exception e) {
		e.printStackTrace();
		new General().msg("Error:" + " " + e.getStackTrace());
	}
}


class extrainfoLsnr implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent arg0) {
   		  boolean vcheckflag = additionalinfo.isSelected() ;
 		  if (vcheckflag)
 		  {
 		     extrapanel.setVisible(true);
 		  }
 		  else
 		  {
  		     extrapanel.setVisible(false);
  		  }
 		
	}
 }


class brandinfoLsnr implements ActionListener{
	@Override
public void actionPerformed(ActionEvent arg0) {
		
		boolean vcheck = checkboxbrand.isSelected() ;
		if(vcheck)
		{
	 		panelBrand.setVisible(true);
			btngeneral.setVisible(true);
			btnChild.setVisible(true);
			btnHierarchy.setVisible(true);

		}
		else
		{
	 		panelBrand.setVisible(false);
			btngeneral.setVisible(false);
			btnChild.setVisible(false);
			btnHierarchy.setVisible(false);

		}
	}
}




class keyPressedlsnr implements KeyListener {
	@Override
	public void keyPressed(KeyEvent e) {
		int value = e.getKeyCode();
		// new General().msg("Key Pressed "+ value);
		switch (value) {
		case 10:

			if (articlename.isFocusOwner()) {
				shortname.grabFocus();
				shortname.setText(articlename.getText());
			}

			if (shortname.isFocusOwner()) {
				if (articletype.isEnabled())
				{
					articletype.grabFocus();
					
				}
				else
				{
					packsize.grabFocus();
 				}
    		}

 			
			if (articletype.isFocusOwner()) {
				articletype.setText(null);
				packsize.grabFocus();
				
			}
			
			
			if (packsize.isFocusOwner()) {
				uom.grabFocus();
			}

			if (uom.isFocusOwner()) {
				mrp.grabFocus();
			}
			
			
			if (mrp.isFocusOwner()) {
 				sp.grabFocus();
 				sp.setText(mrp.getText());
   			}

			if (sp.isFocusOwner()) {
  				tax.grabFocus();
  			}
			
			
			if (tax.isFocusOwner()) {
				hsncode.grabFocus();
 			}
  
			if (hsncode.isFocusOwner()) {
			
				barcode.grabFocus();
			}


			if (barcode.isFocusOwner()) {
				
				shortcutkey.grabFocus();
 			}

			
			if (shortcutkey.isFocusOwner())
			{
				if (panelBrand.isVisible()) {
					brandname.grabFocus();
				}
				else
				{
					btnSave.grabFocus();
				}
 			}
   			
			if (brandname.isFocusOwner()) {
				
				subcatname.grabFocus();
 			}
			
			if (subcatname.isFocusOwner()) {
 				shelflife.grabFocus();
 			}
			
			if (shelflife.isFocusOwner()) {
 				reqshelflife.grabFocus();
 			}

			
			if (reqshelflife.isFocusOwner()) {
 			     mbq.grabFocus();
 			}

			if (mbq.isFocusOwner()) {
 				rolevel.grabFocus();
 			}

			if (rolevel.isFocusOwner()) {
				
				btnSave.grabFocus();
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

class namels implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String value = e.getActionCommand();
		int i = e.getID(); // Field id
		nameCopy_check();
	}
}


private String nameCopy_check() {
	String action = "Sucess";
	articlename.setText(articlename.getText().toUpperCase());
	String vname = (articlename.getText().trim());
	// new General().msg(vname);
	String vaction = new General().checkLength(vname, 30);
	if (vaction == "Pass") {
		shortname.setText(vname);
		shortname.setText(shortname.getText().toUpperCase());
 	}

	else {
		shortname.setText(vname.substring(1, 30));
		new General().Quickmsg("Correct Short Name to 30char");
		shortname.grabFocus();
	}
	return action;

}


private void reset()
{
	
	panelBrand.setVisible(false);
	articlename.setText(null);
	shortname.setText(null);
	shortcutkey.setText(null);
	uom.setText(null);
	sp.setText(null);
	mrp.setText(null);
	packsize.setText(null);
	barcode.setText(null);
	hsncode.setText(null);
	tax.setText(null);
	
	
	String verticle = new  gnHierarchy().getVerticleCode() ;

	try {
 	switch(vverticle)
	{
			case "3" :
 			getPricePolicy() ;
  			break ;
		
	}
 	
	} catch (Throwable e) {
			e.printStackTrace();
	}

}



///Resto price polocy 


private void getPricePolicy() throws Throwable
{
	String vpara900 = "900" ;
	String vpara901 = "901" ;
	String vpara902 = "902" ;
	String vpara903 = "903" ;
	String vpara904 = "904" ;
	String vpara905 = "905" ;
	String vpara906 = "906" ;
	
   	vapplydiffPrice =   new getConfigurationSetting().getSpecificConfiguration(vpara900);
  	vaddSub = new getConfigurationSetting().getSpecificConfiguration(vpara906);
  	vwalkinprice =  new getConfigurationSetting().getSpecificConfiguration(vpara901);
  	vswiggyprice =   new getConfigurationSetting().getSpecificConfiguration(vpara902);
   	vzomatoprice =  new getConfigurationSetting().getSpecificConfiguration(vpara903);
  	vcounterprice =   new getConfigurationSetting().getSpecificConfiguration(vpara904);
    vtelephoneprice =  new getConfigurationSetting().getSpecificConfiguration(vpara905);

	//  new General().msg("counter set value in config is  " + " "+vcounterprice);
 	 // new General().msg("before Apply base price for counter " + " "+vapplyBasePriceForCounter);

	  //"N/A", "WALKIN", "COUNTER", "SWIGGY", "ZOMATO" }));
  	  vapplyBasePriceFor = "N" ;
 	  vapplyBasePriceForCounter = "N" ;
	  vapplyBasePriceForWalkin = "N" ; 
	  vapplyBasePriceForSwiggy = "N" ; 
	  vapplyBasePriceForZomato = "N" ; 
	  vapplyBasePriceForTelephone = "N" ; 

  	switch(vtelephoneprice.toUpperCase())
	  {
	  	case "BASE" :
 	  		vapplyBasePriceFor = "HOME DELIVERY" ;
 	  		vapplyBasePriceForTelephone = "Y" ;
 	  		break ;
 	  	default : 
 	  		updateOtherPrice(vtelephoneprice , vaddSub , vapplyBasePriceFor) ;	
 	  	    break ;
	  }
 
	  switch(vzomatoprice.toUpperCase())
	  {
	  	case "BASE" :
 	  		vapplyBasePriceFor = "ZOMATO" ;
 	  		vapplyBasePriceForZomato ="Y" ;
 	  		break ;
 	  	default : 
 	  		updateOtherPrice(vzomatoprice , vaddSub  ,vapplyBasePriceFor) ;	
 	  		break ;
 	  }
 

	  switch(vswiggyprice.toUpperCase())
	  {
	  	case "BASE" :
	  		vapplyBasePriceForSwiggy = "Y" ;
 	  		vapplyBasePriceFor = "SWIGGY" ;
 	  		break ;
	  	default : 
	  		updateOtherPrice(vswiggyprice , vaddSub ,vapplyBasePriceFor) ;	
	  		break ;
  	  }

	  
	  switch(vwalkinprice.toUpperCase())
	  {
	  	case "BASE" :
	  		vapplyBasePriceForWalkin = "Y" ;
 	  		vapplyBasePriceFor = "WALKIN" ;
 	  		break ;

	  	default : 
	  		updateOtherPrice(vwalkinprice , vaddSub ,vapplyBasePriceFor) ;	
 	  	    break ;
 	  }
	  
	  
  	  switch(vcounterprice.toUpperCase())
	  {
	  	case "BASE" :
	  		vapplyBasePriceForCounter = "Y" ;
 	  		vapplyBasePriceFor = "COUNTER" ;
 	  		break ;
 	  		
	  	default : 
  	  		updateOtherPrice(vcounterprice , vaddSub ,vapplyBasePriceFor) ;		
 	  	    break ;

	  }
	
  	  //new General().msg("Apply base price for counter " + " "+vapplyBasePriceForCounter);
  }



private void updateOtherPrice(String vprice , String vaddsub , String xvapplyBasePriceFor) throws Throwable
{
	//new General().Quickmsg(xvapplyBasePriceFor);
	
    try{ 
 	vcomp = new gnConfig().getCompanyCode();
 	String SQL = "" ;
	String vverticle = new gnHierarchy().getVerticleCode() ;
	switch(vaddsub.trim().toUpperCase())
	{
		case "ADD" :
		SQL = "update msARticle_master set othersp = SalesPrice + '"+vprice+"' where company_code = '"+vcomp+"' "
				+ " and verticle = '"+vverticle+"' " ;
		this.getResult(SQL);
		break;

		case "SUB" :
			SQL = "update msARticle_master set othersp = SalesPrice - '"+vprice+"' where company_code = '"+vcomp+"' "
					+ " and verticle = '"+vverticle+"' " ;
			this.getResult(SQL);
 			break;
 	}
	
	
	//SQL = "update msARticle_master set othersp = SalesPrice - 20  where company_code = '"+vcomp+"' "
	//		+ " and verticle = '"+vverticle+"' " ;
	//this.getResult(SQL);
 	//new General().msg(SQL);

}catch(Exception e)
{
     new General().msg(e.getLocalizedMessage());
     new gnLogger().loggerInfoEntry("Priceupdateother", e.getLocalizedMessage());
}
}


private String  checkBarcodeExist() throws ClassNotFoundException, SQLException
{
 	String vbarcode  = barcode.getText() ;
	String varticle = "";
	String status = "Sucess" ;
	if (vbarcode.length() > 0 )
	{
 		String SQL = "Select article_code, EAN_CODE from ms_EAN_Master "
				+ "  where ean_code = '"+vbarcode+"' " ;
		rs = this.getSPResult(SQL);
		if (rs.next())
		{
			varticle = rs.getString(1);
			String vname = "Name" ;
			String vartname = new gnArticle().Article_getData(varticle, vname) ;
			new General().msg("Please Check Barcode<This Barcode is Already Assign To> "+ varticle +"-->"+ vartname);
			status = "Fail" ;
		}
 	}

	return status ;
}



}//Last 

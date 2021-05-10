package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.border.CompoundBorder;
import javax.swing.ImageIcon;
import com.toedter.calendar.JCalendar;
import javax.swing.JTabbedPane;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.border.MatteBorder;

public class Article_Master extends getResultSet {

	JFrame ArticleMasterFrame;

	private JLabel lblNewLabel_12;
	private JTextField stime;
	JLabel lblNewLabel_27 ;
	private JLabel lblNewLabel_13;
	private JTextField etime;
	JLabel lblCostPrice;
	JLabel lblMrp;
 	private JPanel brandAndHierarchyPanel;
	private JLabel lblNewLabel_16;
	private JTextField Dname;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel hiepanel;
	private JLabel lblNewLabel_15;
	private JTextField dcatcode;
	private JTextField dcatname;
	private JLabel lblNewLabel_17;
	private JTextField dsubcatcode;
	private JTextField dsubcatname;
	private JLabel lblNewLabel_18;
	private JTextField dgroupcode;
	private JTextField dgroupname;
	private JLabel lblNewLabel_19;
	private JTextField dsubgroupcode;
	private JTextField dsubgroupname;
	private JButton btnHierarchy;
	private JTextField description;
	private JLabel lblNewLabel_22;
	private JTextField shelfcode;
	private JTextField Shelfname;
	private JLabel MateralLbl;
	private JTextField varcount;
	private JComboBox articletype;
	private JTextField a_type_name;
	private JTextField a_type_code;

	private JTextField companycode;
	private JTextField name;
	JComboBox tax_code;
	JComboBox brand;
	private JTextField shortname;
	private JTextField autoname;
	private JTextField pksize;
	private JTextField eancode;
	JComboBox uom;
	private JTextField articleCode;
	private JTextField supplier_code;
	private JTextField supplier_name;
	private JTextField innerpackqty;
	private JTextField cost;
	private JTextField mrp;
	private JTextField salesprice;
	private JTextField markdown_per;
	private JTextField salesmargin_per;
	private JTextField parentcode;
	private JTextField processloss;
	private JTextField defualtLocation;
	private JTextField fitcode;
	private JTextField colorcode;
	private JTextField sizecode;
	private JTextField stylecode;
	private JTextField patterncode;
	private JTextField fabriccode;
	private JTextField colorName;
	private JTextField sizeName;
	private JTextField fitName;
	private JTextField styleName;
	private JTextField patternName;
	private JTextField fabricName;
	private JTextField markup_per;
	private JTextField manufcode;
	private JTextField brandcode;
	private JTextField manufname;
	private JTextField rolevel;
	private JTextField hsncode;
	private JTextField content_code;
	private JTextField Puom_cost;
	private JTextField Puom_mrp;
	private JTextField Puom_sp;
	private JTextField drugCode;
	private JTextField DrugType;
	private JTextField discount;
	private JTextField mbq;
	private JTextField brandname; 
	private JTextField a_type_code1;
	private JTextField a_type_name1;
	private JTextField a_class_code;
	private JTextField a_class_name;
	private JTextField a_packform_code;
	private JTextField a_packform_name;
	private JTextField a_packtype_code;
	private JTextField a_packtype_name;
	private JTextField segmentcode;
	private JTextField segmentname;
	private JTextField verticlecode;
	private JTextField verticlename;
	private JTextField hierarchycode;
	private JTextField hierarchyname;
	private JTextField Hierarchyno;
	private JTextField hname;
	private JTextField minshelflife;
	private JTextField maxshelflife;
	private JTextField parentname;

	String vdescription;
	String vshelfcode;
	String Selectiondone = "N";
	String vchoice;
	String VLC;
	private String vmntInv;;
	String vapplytaxslab = "N";
	String vpurUOM;
	String vsaleUOM;
	String eanarticle = "Y";
	String dropdownAction = "N";

	JRadioButton rb2;
	JRadioButton rb1;
	int varientLastno;
	JTabbedPane tabpane;
	JPanel DrugPanel;
	JPanel topleft;

	private JButton btnupdateBrand;
	private JButton btnHindi;
	private JButton btnAddEanCode;
	private JButton btnSalesPrice;
	private JButton btnAdd;
	private JButton btnSave;
	private JButton btnBrand;
	private JButton btnCancel;
	private JButton btnAdditionalFillInfo;
	private JButton btnSaveVarient;
	private JButton btnConvertRates;
	private JButton btnSlab;
	private JButton btnDiscgrp;
	private JButton btnCreateArticleLike;

	JCheckBox applytaxslab;
	String vpuruom;

	JPanel varPanel;
	JComboBox varsize;
	JComboBox varcolor;
	JComboBox varpattern;
	JComboBox varmymaterial;
	JLabel lblFabric;
	JCheckBox checkMntInventory;

	private JPanel optionPanel;
	private JPanel panel_9;
	private JPanel panel_5;
	private JPanel bulkpanel;

	public static JTable discTable;

	// For Varient Panel //
	JScrollPane vjsp = new JScrollPane();
	JTable vtable = new JTable();
	DefaultTableModel vmodel = new DefaultTableModel();
	JScrollPane djsp;
	JTable dtable = new JTable();
	DefaultTableModel dmodel = new DefaultTableModel();

	String vCol[] = { "Type", "Generic Item Name", "Size", "Color", "Pattern", "Fit", "Cost", "MRP", "Sales Price",
			"UOM" };

	/// Table insert Variables
	private String ucode;
	private JPanel panel_2;
	private String vcomp; // = companycode.getText();
	private String vhierarchyno; // = Hierarchyno.getText() ;
	private String vsegment; // = segmentcode.getText() ;
	private String vverticle; // = verticlecode.getText() ;
	private String vdate;
	private String varticlecode; // = articleCode.getText() ;
	private String vitemcode; // = articleCode.getText() ;
	private String vname; // = name.getText();
	private String vposname; // = shortname.getText();
	private String vautoname; // = autoname.getText();
	private String vean; // eancode.getText();
	private String vsupplier;
	private String vlocation;
	private String vsalesUom;
	private String vcontent;
	private String varticleType;
	private String varticleClass;

	private String vcost; // = cost.getText() ;
	private String vmrp; // = mrp.getText() ;
	private String vsalesprice; // = salesprice.getText() ;
	private String vmarkdown; // = markdown_per.getText() ;
	private String vmarkup; // = markup_per.getText();
	private String vmargin; // = salesmargin_per.getText() ;

	private String vtaxcode; // = tax_code.getText();
	private String vtaxper; // = tax_per.getText( ) ;
	private String vmanuf; // = manufcode.getText();
	private String vbrand; // = brandcode.getText();

	private String vuom; // = uom.getText();
	private String vpacksize; // = pksize.getText();
	private String vpackform; // = a_packform_code.getText();
	private String vpacktype; // = a_packtype_code.getText();

	private String vparentcode; // = parentcode.getText() ;
	private String vprocessloss; // = processloss.getText();
	private String vactive = "Y";

	private String vinnerpacksize; // = innerpksize.getText() ;
	private String vinnerpackqty; // = innerpackqty.getText() ;

	private String vfit;// = fitcode.getText() ;
	private String vcolor;// = colorcode.getText() ;
	private String vsize;// = sizecode.getText() ;
	private String vstyle;// = stylecode.getText() ;
	private String vpattern; // = patterncode.getText() ;
	private String vfabric; // = fabriccode.getText() ;
	private String vorderin; // = combopurqty.getSelectedItem().toString() ;
	JPanel fashin2Pnael;

	private String vmaxshelflife;
	private String vminshelflife;
	private String vmrpbase;
	private String vtradingarticle;
	private String vbatchcontrol;
	JInternalFrame internalFrame;
	/// End Table insert Variables

	private String Rvsegmentcode;
	private String Rverticlecode;
	private String Rhno;

	private JCheckBox chkTradingArticle;
	private JCheckBox checkean;
	private JCheckBox chkBatchControl;
	public JComboBox combopurqty;
	public JCheckBox chkMrpArticle;

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	// ---------
	
	public String vArticle_category;
	public String vArticle_subcategory;
	public String vArticle_group;
	public String vArticle_subGroup;

	public JTable table = new JTable();
	public JScrollPane sjsp;
	public DefaultTableModel model = new DefaultTableModel();

	public String[] Col = { "Article code", "Name", "Ean Code", "MRP", "SalesPrice" };
	public String[] Colsup = { "Supplier code", "Name", "Mobile", "Email", "Tin_No" };
	public String[] Colattr = { "Sub_category", "Master_name", "Code", "Description", "Reference " };
	public String[] ColTax = { "Company_code", "Tax_code", "Tex_Percentage", "From", "TO" };

	private JLabel lblMaxShelfLife;
	private JLabel lblRequiredShelfLife;
	private JLabel lblDays;
	private JLabel lblHierarhcy;
	private JLabel lblUom;

	// ---
	// -----

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Article_Master window = new Article_Master();
					window.ArticleMasterFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
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
	public Article_Master() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		ArticleMasterFrame = new JFrame();
		ArticleMasterFrame.setAlwaysOnTop(true);
		ArticleMasterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// ArticleMasterFrame.setBounds(1, 100, 1350, 717);
		ArticleMasterFrame.setBounds(1, 100, 1350, 600);
		ArticleMasterFrame.getContentPane().setLayout(null);

		/*
		 * internalFrame = new JInternalFrame("Item Master");
		 * ArticleMasterFrame.getContentPane().setBackground(UIManager.getColor(
		 * "CheckBox.background")); internalFrame.setBounds(0, 0, 1350, 700);
		 * ArticleMasterFrame.getContentPane().add(internalFrame);
		 */

		topleft = new JPanel();
		topleft.setBounds(0, 0, 1322, 357);
		topleft.setBackground(Color.WHITE);
		topleft.setToolTipText("Article Code and Name< Short Name Enter Correct>");
		topleft.setBorder(new TitledBorder(null, "Article Master", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ArticleMasterFrame.getContentPane().add(topleft);
		topleft.setLayout(null);

		JLabel lblCompanyCode = new JLabel("Company Code ");
		lblCompanyCode.setBounds(418, 3, 111, 16);
		lblCompanyCode.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblCompanyCode.setHorizontalAlignment(SwingConstants.RIGHT);
		topleft.add(lblCompanyCode);

		companycode = new JTextField();
		companycode.setBounds(529, 0, 111, 22);
		companycode.setForeground(Color.BLACK);
		companycode.setFont(new Font("Calibri", Font.PLAIN, 13));
		companycode.setEnabled(false);
		topleft.add(companycode);
		companycode.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.BLACK);
		lblName.setBounds(25, 35, 117, 16);
		lblName.setFont(new Font("Segoe UI Semibold", Font.BOLD, 17));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		topleft.add(lblName);

		name = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		name.setBounds(25, 52, 391, 30);
		name.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));

		name.setDocument(new gnSetinputLimit(50));

		name.setToolTipText("Allow 50 Charactores only");
		topleft.add(name);
		name.setColumns(10);

		JLabel lblShortName = new JLabel("Short Name For Bill Printing On Small Invoice Format");
		lblShortName.setForeground(Color.BLACK);
		lblShortName.setBounds(25, 82, 364, 16);
		lblShortName.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		lblShortName.setHorizontalAlignment(SwingConstants.LEFT);
		topleft.add(lblShortName);

		shortname = new JTextField();
		shortname.setBounds(25, 97, 391, 30);
		shortname.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		name.setDocument(new gnSetinputLimit(30));
		shortname.setToolTipText("Allow 30 Chars for Billing Purpose ");
		topleft.add(shortname);
		shortname.setColumns(10);

		JLabel lblSegment = new JLabel("Segment");
		lblSegment.setBounds(945, 6, 58, 16);
		topleft.add(lblSegment);
		lblSegment.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		String Vsegment = "Segment";
		String Vverticle = "Verticle";

		supplier_code = new JTextField();
		supplier_code.setBounds(94, 17, 28, 22);
		supplier_code.setFont(new Font("Calibri", Font.PLAIN, 13));
		supplier_code.setBackground(Color.CYAN);
		topleft.add(supplier_code);
		supplier_code.setColumns(10);

		supplier_name = new JTextField();
		supplier_name.setBounds(122, 17, 106, 22);
		supplier_name.setFont(new Font("Calibri", Font.PLAIN, 13));
		supplier_name.setBackground(Color.CYAN);
		supplier_name.setEditable(false);
		topleft.add(supplier_name);
		supplier_name.setColumns(10);

		segmentcode = new JTextField();
		segmentcode.setBounds(1002, 3, 27, 22);
		segmentcode.setForeground(Color.BLACK);
		segmentcode.setFont(new Font("Calibri", Font.PLAIN, 13));
		segmentcode.setEditable(false);
		segmentcode.setBackground(Color.CYAN);
		topleft.add(segmentcode);
		segmentcode.setColumns(10);

		segmentname = new JTextField();
		segmentname.setBounds(1041, 3, 101, 22);
		segmentname.setForeground(Color.BLACK);
		segmentname.setFont(new Font("Calibri", Font.PLAIN, 13));
		segmentname.setBackground(Color.CYAN);
		segmentname.setEditable(false);
		topleft.add(segmentname);
		segmentname.setColumns(10);

		defualtLocation = new JTextField();
		defualtLocation.setBounds(230, 17, 40, 22);
		defualtLocation.setFont(new Font("Calibri", Font.PLAIN, 13));
		topleft.add(defualtLocation);
		defualtLocation.setBackground(Color.CYAN);
		defualtLocation.setEditable(false);
		defualtLocation.setColumns(10);

		varPanel = new JPanel();
		varPanel.setBounds(897, 291, 413, 59);
		varPanel.setBackground(Color.WHITE);
		topleft.add(varPanel);
		varPanel.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("Select  Size and Color ");
		lblNewLabel_11.setForeground(new Color(0, 0, 51));
		lblNewLabel_11.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(1, 0, 186, 16);
		varPanel.add(lblNewLabel_11);

		varpattern = new JComboBox();
		varpattern.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		varpattern.setBounds(122, 29, 92, 22);
		varPanel.add(varpattern);

		JLabel lblNewLabel_24 = new JLabel("Pattern");
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_24.setBounds(120, 13, 85, 16);
		varPanel.add(lblNewLabel_24);

		MateralLbl = new JLabel("Material");
		MateralLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		MateralLbl.setHorizontalAlignment(SwingConstants.LEFT);
		MateralLbl.setBounds(1, 13, 86, 16);
		varPanel.add(MateralLbl);

		varmymaterial = new JComboBox();
		varmymaterial.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		varmymaterial.setBounds(1, 29, 120, 22);
		varPanel.add(varmymaterial);

		JLabel lblNewLabel_10 = new JLabel("Color");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_10.setBounds(221, 13, 56, 16);
		varPanel.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));

		varcolor = new JComboBox();
		varcolor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		varcolor.setBounds(217, 29, 120, 22);
		varPanel.add(varcolor);

		JLabel lblNewLabel_9 = new JLabel("Size");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setBounds(339, 13, 56, 16);
		varPanel.add(lblNewLabel_9);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 13));

		varsize = new JComboBox();
		varsize.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		varsize.setBounds(339, 29, 56, 22);
		varPanel.add(varsize);
		varmymaterial.setVisible(true);

		JPanel salesPricePanel = new JPanel();
		salesPricePanel.setBounds(25, 129, 407, 215);
		topleft.add(salesPricePanel);
		salesPricePanel.setBackground(new Color(255, 255, 255));
		salesPricePanel.setBorder(new MatteBorder(2, 1, 1, 1, (Color) new Color(0, 255, 0)));
		salesPricePanel.setLayout(null);

		lblMrp = new JLabel("MRP");
		lblMrp.setBounds(119, 92, 85, 16);
		salesPricePanel.add(lblMrp);
		lblMrp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMrp.setHorizontalAlignment(SwingConstants.LEFT);
		lblMrp.setForeground(Color.DARK_GRAY);

		mrp = new JTextField();
		mrp.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		mrp.setBounds(119, 107, 100, 30);
		salesPricePanel.add(mrp);
		mrp.setColumns(10);

		JLabel lblSalesPrice = new JLabel("Sales Price ");
		lblSalesPrice.setBounds(119, 44, 100, 16);
		salesPricePanel.add(lblSalesPrice);
		lblSalesPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSalesPrice.setForeground(Color.DARK_GRAY);
		lblSalesPrice.setHorizontalAlignment(SwingConstants.LEFT);

		salesprice = new JTextField();
		salesprice.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		salesprice.setBounds(119, 59, 100, 30);
		salesPricePanel.add(salesprice);
		salesprice.setColumns(10);

		JLabel lblArticleType = new JLabel("Article Type");
		lblArticleType.setForeground(Color.DARK_GRAY);
		lblArticleType.setBounds(12, 0, 85, 16);
		salesPricePanel.add(lblArticleType);
		lblArticleType.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));

		JLabel lblNewLabel_1 = new JLabel("HSN Code");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setBounds(232, 92, 171, 16);
		salesPricePanel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));

		hsncode = new JTextField();
		hsncode.setBounds(231, 108, 172, 25);
		salesPricePanel.add(hsncode);
		hsncode.setToolTipText("Enter HSN Code ");
		hsncode.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		hsncode.setColumns(10);

		JLabel lblPackSize = new JLabel("Pack size ");
		lblPackSize.setForeground(Color.DARK_GRAY);
		lblPackSize.setBounds(12, 44, 89, 16);
		salesPricePanel.add(lblPackSize);
		lblPackSize.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPackSize.setHorizontalAlignment(SwingConstants.LEFT);

		// pksize = new JTextField();
		pksize = new gnRoundTextField(20);
		pksize.setBounds(12, 60, 82, 30);
		salesPricePanel.add(pksize);
		pksize.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		pksize.setBackground(Color.WHITE);
		pksize.setToolTipText("Enter Pack size For Exmaple 200 GM  then Enter Here 200  and Selected UOM for GM");
		pksize.setColumns(10);

		lblUom = new JLabel(" Item UOM");
		lblUom.setForeground(Color.DARK_GRAY);
		lblUom.setBounds(12, 90, 89, 16);
		salesPricePanel.add(lblUom);
		lblUom.setHorizontalAlignment(SwingConstants.LEFT);
		lblUom.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblTaxPercentage = new JLabel("Tax%");
		lblTaxPercentage.setForeground(Color.DARK_GRAY);
		lblTaxPercentage.setBounds(12, 137, 89, 16);
		salesPricePanel.add(lblTaxPercentage);
		lblTaxPercentage.setHorizontalAlignment(SwingConstants.LEFT);
		lblTaxPercentage.setFont(new Font("Tahoma", Font.BOLD, 12));

		uom = new JComboBox();
		uom.setForeground(Color.DARK_GRAY);
		uom.setBackground(Color.WHITE);
		uom.setBounds(12, 107, 82, 27);
		salesPricePanel.add(uom);

		tax_code = new JComboBox();
		tax_code.setForeground(Color.DARK_GRAY);
		tax_code.setBackground(Color.WHITE);
		tax_code.setBounds(12, 157, 82, 25);
		salesPricePanel.add(tax_code);

		articletype = new JComboBox();
		articletype.setForeground(Color.DARK_GRAY);
		articletype.setBackground(Color.WHITE);
		articletype.setBounds(12, 20, 391, 25);
		salesPricePanel.add(articletype);

		JLabel lblNewLabel_7 = new JLabel("Brand");
		lblNewLabel_7.setForeground(Color.DARK_GRAY);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(231, 45, 56, 16);
		salesPricePanel.add(lblNewLabel_7);

		brand = new JComboBox();
		brand.setForeground(Color.DARK_GRAY);
		brand.setBackground(Color.WHITE);
		brand.setBounds(231, 65, 172, 25);
		salesPricePanel.add(brand);
		// BasicPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new
		// Component[]{uom, pksize, tax_per, hsncode, cost, mrp, salesprice,
		// eancode, checkean}));

		checkean = new JCheckBox("EANCODE");
		checkean.setForeground(Color.DARK_GRAY);
		checkean.setBackground(new Color(255, 255, 255));
		checkean.setBounds(137, 191, 82, 21);
		salesPricePanel.add(checkean);
		checkean.setSelected(true);
		checkean.setFont(new Font("Calibri", Font.BOLD, 13));

		chkBatchControl = new JCheckBox("Batch Control Enable");
		chkBatchControl.setBounds(12, 189, 158, 22);
		salesPricePanel.add(chkBatchControl);
		chkBatchControl.setBackground(new Color(255, 255, 255));
		chkBatchControl.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
		chkBatchControl.setForeground(Color.DARK_GRAY);

		applytaxslab = new JCheckBox("Apply Tax Slab");
		applytaxslab.setBounds(219, 188, 108, 25);
		salesPricePanel.add(applytaxslab);
		applytaxslab.setBackground(new Color(255, 255, 255));
		applytaxslab.setToolTipText("Please Check If  <This Article Comes Under Tax Slab As Per Govt.Rule>");
		applytaxslab.setForeground(Color.DARK_GRAY);
		applytaxslab.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));

		btnSlab = new JButton("Tax Slab");
		btnSlab.setBounds(324, 188, 83, 25);
		salesPricePanel.add(btnSlab);
		btnSlab.setFont(new Font("Segoe UI Semibold", Font.BOLD, 11));
		btnSlab.setToolTipText(
				"Check Tax Slab For Your Business Type. If No Slab Mention Means -> Your Business Type Does Not Applicable For Diff Tax Slab For Diff Sales Value.");
		
		lblNewLabel_27 = new JLabel("ShortCutKey");
		lblNewLabel_27.setFont(new Font("SimSun", Font.BOLD, 13));
		lblNewLabel_27.setBounds(231, 137, 100, 16);
		salesPricePanel.add(lblNewLabel_27);
		
 		
		shortkey = new JTextField();
		shortkey.setBounds(231, 152, 172, 27);
		salesPricePanel.add(shortkey);
		shortkey.setColumns(10);
		
		 		
				lblCostPrice = new JLabel("Pur.Price");
				lblCostPrice.setBounds(119, 136, 85, 16);
				salesPricePanel.add(lblCostPrice);
				lblCostPrice.setFont(new Font("Tahoma", Font.BOLD, 13));
				lblCostPrice.setForeground(Color.DARK_GRAY);
				lblCostPrice.setHorizontalAlignment(SwingConstants.LEFT);
				
						cost = new JTextField();
						cost.setBounds(119, 152, 100, 30);
						salesPricePanel.add(cost);
						cost.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
						cost.setBackground(Color.CYAN);
						cost.setColumns(10);
						salesPricePanel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{articletype , pksize, uom, tax_code ,  salesprice, mrp,   cost, brand, hsncode, shortkey, btnSave}));
 
		panel_8 = new JPanel();
		panel_8.setBounds(435, 291, 463, 59);
		panel_8.setBackground(Color.CYAN);
		topleft.add(panel_8); 
		panel_8.setBorder(new MatteBorder(3, 0, 1, 0, (Color) new Color(255, 0, 255)));
		panel_8.setLayout(null);

		btnCancel = new JButton("Close");
		btnCancel.setBounds(92, 13, 89, 30);
		btnCancel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		panel_8.add(btnCancel);
		btnCancel.setForeground(new Color(0, 0, 0));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArticleMasterFrame.dispose();
			}
		});
		btnCancel.setMnemonic('C');
		btnCancel.setBackground(Color.CYAN);

		btnSave = new JButton("Save");
		btnSave.setBounds(12, 13, 80, 30);
		panel_8.add(btnSave);
		btnSave.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		btnSave.setForeground(new Color(0, 0, 0));
		btnSave.setMnemonic('S');
		btnSave.setBackground(Color.CYAN);

		btnAdditionalFillInfo = new JButton("Fill Additional Information");
		btnAdditionalFillInfo.setBounds(184, 13, 210, 29);
		panel_8.add(btnAdditionalFillInfo);
		btnAdditionalFillInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabpane.setVisible(true);
			}
		});
		btnAdditionalFillInfo.setFont(new Font("Segoe UI", Font.ITALIC, 14));

		JPanel dispArticlePanel = new JPanel();
		dispArticlePanel.setBackground(Color.WHITE);
		dispArticlePanel.setBounds(435, 52, 875, 236);
		dispArticlePanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		topleft.add(dispArticlePanel);
		dispArticlePanel.setLayout(null);

		djsp = new JScrollPane();
		djsp.setViewportBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 204)));
		djsp.setBounds(0, 39, 875, 197);
		dispArticlePanel.add(djsp);

		lblNewLabel_16 = new JLabel("Search By Name");
		lblNewLabel_16.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_16.setBounds(345, 6, 219, 16);
		dispArticlePanel.add(lblNewLabel_16);

		Dname = new JTextField();
		Dname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Dname.setToolTipText("Type Item Name Or Brand Name And Press Enter");
		Dname.setBounds(573, 0, 175, 35);
		dispArticlePanel.add(Dname);
		Dname.setColumns(10);

		rb1 = new JRadioButton("Search By Name");
		rb1.setBackground(Color.WHITE);
		rb1.setFont(new Font("Arial Narrow", Font.BOLD, 14));
		rb1.setSelected(true);
		buttonGroup.add(rb1);
		rb1.setBounds(8, 4, 127, 25);
		dispArticlePanel.add(rb1);

		rb2 = new JRadioButton("By Brand");
		rb2.setBackground(Color.WHITE);
		rb2.setEnabled(false);
		buttonGroup.add(rb2);
		rb2.setBounds(58, 5, 127, 25);
		dispArticlePanel.add(rb2);

		btnDiscgrp = new JButton("Disc.Group");
		btnDiscgrp.setBounds(760, 2, 107, 30);
		dispArticlePanel.add(btnDiscgrp);
		btnDiscgrp.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnDiscgrp.setMnemonic('G');

		lblNewLabel_12 = new JLabel("S.Time");
		lblNewLabel_12.setBounds(172, 0, 45, 16);
		dispArticlePanel.add(lblNewLabel_12);

		stime = new JTextField();
		stime.setBounds(172, 13, 80, 22);
		dispArticlePanel.add(stime);
		stime.setColumns(10);

		lblNewLabel_13 = new JLabel("E.time");
		lblNewLabel_13.setBounds(264, 0, 81, 16);
		dispArticlePanel.add(lblNewLabel_13);

		etime = new JTextField();
		etime.setBounds(256, 13, 89, 22);
		dispArticlePanel.add(etime);
		etime.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel(" ");
		lblNewLabel_20.setBounds(12, 0, 0, 323);
		lblNewLabel_20.setIcon(new ImageIcon(Article_Master.class.getResource("/RetailProduct/ph10.png")));
		topleft.add(lblNewLabel_20);

		autoname = new JTextField();
		autoname.setBounds(35, 13, 28, 9);
		topleft.add(autoname);
		autoname.setFont(new Font("Calibri", Font.PLAIN, 13));
		autoname.setForeground(Color.WHITE);
		autoname.setBackground(new Color(0, 204, 204));
		autoname.setEditable(false);
		autoname.setColumns(10);

		JLabel lblArticleCode = new JLabel("Article Code");
		lblArticleCode.setBounds(282, 3, 121, 16);
		topleft.add(lblArticleCode);
		lblArticleCode.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblArticleCode.setHorizontalAlignment(SwingConstants.LEFT);
		// String Sql= "call master_getmasterData('"+Vverticle+"')";

		articleCode = new JTextField();
		articleCode.setBounds(282, 18, 121, 30);
		topleft.add(articleCode);
		articleCode.setFont(new Font("Arial Black", Font.BOLD, 16));
		articleCode.setForeground(new Color(0, 0, 153));
		articleCode.setColumns(10);

		btnupdateBrand = new JButton("Update Brand/Hie.");
		btnupdateBrand.setBackground(new Color(153, 204, 204));
		btnupdateBrand.setBounds(1012, 21, 160, 30);
		topleft.add(btnupdateBrand);
		btnupdateBrand.setForeground(new Color(0, 0, 51));
		btnupdateBrand.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalesPrice = new JButton("Update SalesPrice");
		btnSalesPrice.setBounds(691, 21, 160, 30);
		topleft.add(btnSalesPrice);
		btnSalesPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSalesPrice.setMnemonic('U');
		btnSalesPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Article_SalesPriceInsertForNewComp_Stores window;
					// window = new Article_SalesPriceInsertForNewComp_Stores();
					// window.frameSalespriceInsert.setVisible(true);
					updatePrice window = new updatePrice();
					window.updatePriceFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalesPrice.setForeground(new Color(0, 0, 51));
		btnSalesPrice.setBackground(new Color(153, 204, 204));

		btnHierarchy = new JButton("Hierarchy");
		btnHierarchy.setBackground(new Color(153, 204, 204));
		btnHierarchy.setBounds(852, 21, 160, 30);
		topleft.add(btnHierarchy);
		btnHierarchy.setForeground(new Color(0, 0, 51));
		btnHierarchy.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnBrand = new JButton("Other Masters");
		btnBrand.setBackground(new Color(153, 204, 204));
		btnBrand.setBounds(433, 21, 109, 30);
		topleft.add(btnBrand);
		btnBrand.setForeground(new Color(0, 0, 51));
		btnBrand.setMnemonic('B');
		btnBrand.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btnAddEanCode = new JButton("Add Ean Code");
		btnAddEanCode.setBounds(542, 21, 143, 30);
		topleft.add(btnAddEanCode);
		btnAddEanCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddEanCode.setForeground(new Color(0, 0, 51));
		btnAddEanCode.setBackground(new Color(153, 204, 204));

		btnCreateArticleLike = new JButton("Create Article Like ");
		btnCreateArticleLike.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreateArticleLike.setBounds(1172, 21, 127, 30);
		topleft.add(btnCreateArticleLike);
		btnCreateArticleLike.setMnemonic('L');
		btnCreateArticleLike.setForeground(new Color(0, 0, 51));
		btnCreateArticleLike.setBackground(new Color(153, 204, 204));

		btnCreateArticleLike.setVisible(false);

		 
		JPanel PurchaseuomPanel = new JPanel();
		PurchaseuomPanel.setBorder(
				new TitledBorder(null, "MainPurain Purchase UOM ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PurchaseuomPanel.setBounds(559, 35, 428, 164);
		// topleft.add(PurchaseuomPanel);
		PurchaseuomPanel.setLayout(null);

		JLabel lblPurchaseQtyIn = new JLabel("Purchase UOM");
		lblPurchaseQtyIn.setBounds(207, 13, 97, 16);
		PurchaseuomPanel.add(lblPurchaseQtyIn);
		lblPurchaseQtyIn.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblPurchaseQtyIn.setHorizontalAlignment(SwingConstants.RIGHT);

		combopurqty = new JComboBox();
		combopurqty.setBounds(217, 29, 87, 25);
		PurchaseuomPanel.add(combopurqty);
		combopurqty.setFont(new Font("Calibri", Font.PLAIN, 13));
		combopurqty.setModel(new DefaultComboBoxModel(new String[] { " " }));

		JLabel lblIneerPackQty = new JLabel("Inner Qty");
		lblIneerPackQty.setBounds(319, 13, 76, 16);
		PurchaseuomPanel.add(lblIneerPackQty);
		lblIneerPackQty.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));

		innerpackqty = new JTextField();
		innerpackqty.setBounds(317, 31, 64, 25);
		PurchaseuomPanel.add(innerpackqty);
		innerpackqty.setFont(new Font("Tahoma", Font.BOLD, 14));
		innerpackqty.setForeground(new Color(0, 0, 153));
		innerpackqty.setColumns(10);

		DrugPanel = new JPanel();
		DrugPanel.setBounds(983, 61, 279, 73);
		// topleft.add(DrugPanel);
		DrugPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(51, 0, 102), null),
				"Drug/Dose Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		DrugPanel.setLayout(null);
		// drugType.setModel(new DefaultComboBoxModel(new String[] {"Y", "N"}));

		JLabel lblNewLabel_2 = new JLabel("Drug Type");
		lblNewLabel_2.setBounds(6, 48, 70, 16);
		DrugPanel.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel("Content");
		lblNewLabel.setBounds(13, 23, 56, 16);
		DrugPanel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 153));

		content_code = new JTextField();
		content_code.setBounds(65, 23, 37, 22);
		content_code.setText("0");
		DrugPanel.add(content_code);
		content_code.setEditable(false);
		content_code.setColumns(10);

		content = new JTextField();
		content.setBounds(102, 23, 169, 22);
		DrugPanel.add(content);
		content.setToolTipText("Enter Product Content  This Filed Will be used for Search ");
		content.setColumns(10);
		drugCode = new JTextField();
		drugCode.setBounds(65, 45, 37, 22);
		drugCode.setText("0");
		drugCode.setEditable(false);
		DrugPanel.add(drugCode);
		drugCode.setColumns(10);

		DrugType = new JTextField();
		DrugType.setBounds(102, 45, 169, 22);
		DrugPanel.add(DrugType);
		DrugType.setColumns(10);

		panel_2 = new JPanel();
		panel_2.setBounds(1100, 169, 222, 92);
		// topleft.add(panel_2);
		panel_2.setBackground(Color.CYAN);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);

		panel_2.setVisible(false);

		topleft.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { name, shortname }));

		sjsp = new JScrollPane();
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setBounds(12, 0, 494, 303);
		// Dpanel.add(sjsp);

		JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(table, Col);
		prt.setVisible(true);
		sjsp.setViewport(prt);

		optionPanel = new JPanel();
		optionPanel.setBorder(new LineBorder(new Color(192, 192, 192), 4, true));
		optionPanel.setBackground(new Color(240, 248, 255));
		optionPanel.setBounds(135, 512, 828, 77);
		// ArticleMasterFrame.getContentPane().add(optionPanel);
		optionPanel.setLayout(null);

		vjsp = new JScrollPane();
		vjsp.setBounds(12, 13, 1293, 222);
		optionPanel.add(vjsp);
		vjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		vjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(0, 237, 97, 36);
		optionPanel.add(btnAdd);
		btnAdd.setMnemonic('A');

		btnSaveVarient = new JButton("Save Varients");
		btnSaveVarient.setBounds(96, 237, 124, 36);
		optionPanel.add(btnSaveVarient);
		btnSaveVarient.setMnemonic('V');

		tabpane = new JTabbedPane(JTabbedPane.TOP);
		tabpane.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		tabpane.setBackground(new Color(51, 102, 153));
		tabpane.setBounds(0, 352, 1322, 245);
		ArticleMasterFrame.getContentPane().add(tabpane);

		tabpane.add("Purchase UOM & Price", PurchaseuomPanel);

		brandAndHierarchyPanel = new JPanel();
		brandAndHierarchyPanel.setBackground(Color.WHITE);
		brandAndHierarchyPanel.setBorder(new TitledBorder(null, "Brand & Hierarchy Management", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		brandAndHierarchyPanel.setBounds(600, 35, 695, 160);
		// topleft.add(brandAndHierarchyPanel);
		brandAndHierarchyPanel.setLayout(null);
		tabpane.add("Brand & Hierarchy", brandAndHierarchyPanel);

		// String SQLsegment= "call master_getmasterData('"+Vsegment+"')";

		JLabel lblVerticle = new JLabel("Verticle");
		lblVerticle.setBounds(738, 13, 68, 16);
		brandAndHierarchyPanel.add(lblVerticle);
		lblVerticle.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
		lblVerticle.setHorizontalAlignment(SwingConstants.RIGHT);

		verticlecode = new JTextField();
		verticlecode.setBounds(748, 28, 51, 30);
		brandAndHierarchyPanel.add(verticlecode);
		verticlecode.setFont(new Font("Calibri", Font.PLAIN, 13));
		verticlecode.setEnabled(false);
		verticlecode.setEditable(false);
		verticlecode.setBackground(Color.CYAN);
		verticlecode.setColumns(10);

		verticlename = new JTextField();
		verticlename.setEditable(false);
		verticlename.setBounds(798, 28, 171, 30);
		brandAndHierarchyPanel.add(verticlename);
		verticlename.setEnabled(false);
		verticlename.setFont(new Font("Calibri", Font.PLAIN, 13));
		verticlename.setBackground(Color.WHITE);
		verticlename.setColumns(10);

		lblHierarhcy = new JLabel("Hierarhcy");
		lblHierarhcy.setBounds(967, 13, 86, 16);
		brandAndHierarchyPanel.add(lblHierarhcy);
		lblHierarhcy.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));

		Hierarchyno = new JTextField();
		Hierarchyno.setBounds(966, 28, 51, 30);
		brandAndHierarchyPanel.add(Hierarchyno);
		Hierarchyno.setBackground(Color.CYAN);
		Hierarchyno.setColumns(10);

		hname = new JTextField();
		hname.setBounds(1017, 30, 169, 30);
		brandAndHierarchyPanel.add(hname);
		// hname.setEditable(false);
		hname.setFont(new Font("Calibri", Font.PLAIN, 13));
		hname.setBackground(Color.WHITE);
		hname.setColumns(10);

		hierarchycode = new JTextField();
		hierarchycode.setBounds(451, 33, 51, 25);
		brandAndHierarchyPanel.add(hierarchycode);
		hierarchycode.setEnabled(false);
		hierarchycode.setToolTipText("Press Enter to Select Hiearchy ");
		hierarchycode.setBackground(Color.CYAN);
		hierarchycode.setColumns(10);

		hierarchyname = new JTextField();
		hierarchyname.setBounds(501, 33, 185, 25);
		brandAndHierarchyPanel.add(hierarchyname);
		hierarchyname.setEnabled(true);
		hierarchyname.setEditable(true);
		hierarchyname.setToolTipText("Enter name and Search Or Press Ener To See All Entries");
		hierarchyname.setColumns(10);

		JLabel lblNewLabel_14 = new JLabel("Sub Category");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel_14.setBounds(345, 39, 94, 16);
		brandAndHierarchyPanel.add(lblNewLabel_14);

		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(35, 59, 71, 16);
		brandAndHierarchyPanel.add(lblBrand);
		lblBrand.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblBrand.setHorizontalAlignment(SwingConstants.RIGHT);

		brandcode = new JTextField();
		brandcode.setBounds(118, 55, 51, 22);
		brandAndHierarchyPanel.add(brandcode);
		brandcode.setFont(new Font("Calibri", Font.PLAIN, 13));
		brandcode.setText("0");
		brandcode.setToolTipText("Press Enter to Select Brand");
		brandcode.setBackground(Color.CYAN);
		brandcode.setColumns(10);

		brandname = new JTextField();
		brandname.setBounds(168, 55, 171, 25);
		brandAndHierarchyPanel.add(brandname);
		brandname.setFont(new Font("Calibri", Font.PLAIN, 13));
		brandname.setText(" ");
		brandname.setBackground(Color.WHITE);
		brandname.setToolTipText("Enter Brand Name for Search");
		brandname.setColumns(10);

		hiepanel = new JPanel();
		hiepanel.setBackground(Color.WHITE);
		hiepanel.setBorder(new TitledBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 255, 0)), "Hierarchy",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
		hiepanel.setBounds(758, 59, 428, 143);
		brandAndHierarchyPanel.add(hiepanel);
		hiepanel.setLayout(null);

		lblNewLabel_18 = new JLabel("Group");
		lblNewLabel_18.setBounds(12, 15, 141, 16);
		lblNewLabel_18.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_18.setForeground(Color.DARK_GRAY);
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.RIGHT);
		hiepanel.add(lblNewLabel_18);

		dgroupcode = new JTextField();
		dgroupcode.setBounds(155, 13, 40, 30);
		hiepanel.add(dgroupcode);
		dgroupcode.setColumns(10);

		dgroupname = new JTextField();
		dgroupname.setBounds(196, 13, 175, 30);
		hiepanel.add(dgroupname);
		dgroupname.setColumns(10);

		lblNewLabel_19 = new JLabel("SubGroup");
		lblNewLabel_19.setBounds(37, 48, 116, 16);
		lblNewLabel_19.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_19.setForeground(Color.DARK_GRAY);
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.RIGHT);
		hiepanel.add(lblNewLabel_19);

		dsubgroupcode = new JTextField();
		dsubgroupcode.setText("0");
		dsubgroupcode.setBounds(155, 42, 40, 30);
		hiepanel.add(dsubgroupcode);
		dsubgroupcode.setColumns(10);

		dsubgroupname = new JTextField();
		dsubgroupname.setBounds(196, 44, 175, 30);
		hiepanel.add(dsubgroupname);
		dsubgroupname.setColumns(10);

		lblNewLabel_15 = new JLabel("Category");
		lblNewLabel_15.setBounds(47, 78, 106, 16);
		lblNewLabel_15.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_15.setForeground(Color.DARK_GRAY);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
		hiepanel.add(lblNewLabel_15);

		dcatcode = new JTextField();
		dcatcode.setBounds(155, 74, 40, 30);
		hiepanel.add(dcatcode);
		dcatcode.setColumns(10);

		dcatname = new JTextField();
		dcatname.setBounds(196, 74, 175, 30);
		hiepanel.add(dcatname);
		dcatname.setColumns(10);

		lblNewLabel_17 = new JLabel("Sub Categegory");
		lblNewLabel_17.setBounds(12, 105, 141, 16);
		lblNewLabel_17.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_17.setForeground(Color.DARK_GRAY);
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		hiepanel.add(lblNewLabel_17);

		dsubcatcode = new JTextField();
		dsubcatcode.setBounds(155, 102, 40, 30);
		hiepanel.add(dsubcatcode);
		dsubcatcode.setColumns(10);

		dsubcatname = new JTextField();
		dsubcatname.setBounds(196, 102, 175, 30);
		hiepanel.add(dsubcatname);
		dsubcatname.setColumns(10);

		JLabel lblArticleClass = new JLabel("Article Class");
		lblArticleClass.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblArticleClass.setBounds(20, 116, 86, 16);
		brandAndHierarchyPanel.add(lblArticleClass);
		lblArticleClass.setHorizontalAlignment(SwingConstants.RIGHT);

		a_class_code = new JTextField();
		a_class_code.setBounds(118, 109, 51, 22);
		brandAndHierarchyPanel.add(a_class_code);
		a_class_code.setBackground(Color.CYAN);
		a_class_code.setColumns(10);

		JLabel lblPackForm = new JLabel("Pack Form ");
		lblPackForm.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblPackForm.setBounds(367, 105, 75, 16);
		brandAndHierarchyPanel.add(lblPackForm);
		lblPackForm.setHorizontalAlignment(SwingConstants.RIGHT);

		a_packform_code = new JTextField();
		a_packform_code.setBounds(454, 96, 51, 25);
		brandAndHierarchyPanel.add(a_packform_code);
		a_packform_code.setBackground(Color.CYAN);
		a_packform_code.setColumns(10);

		a_class_name = new JTextField();
		a_class_name.setBounds(168, 108, 171, 25);
		brandAndHierarchyPanel.add(a_class_name);
		a_class_name.setBackground(Color.WHITE);
		a_class_name.setColumns(10);

		a_packform_name = new JTextField();
		a_packform_name.setBounds(504, 97, 182, 25);
		brandAndHierarchyPanel.add(a_packform_name);
		a_packform_name.setBackground(Color.WHITE);
		a_packform_name.setColumns(10);

		JLabel lblNewLabel_21 = new JLabel(" Description");
		lblNewLabel_21.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_21.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_21.setBounds(12, 142, 91, 29);
		brandAndHierarchyPanel.add(lblNewLabel_21);

		description = new JTextField();
		description.setToolTipText("Enter Any Special Note Related To This Article");
		description.setBounds(115, 135, 618, 36);
		brandAndHierarchyPanel.add(description);
		description.setColumns(10);

		fashin2Pnael = new JPanel();
		fashin2Pnael.setBounds(1198, 0, 119, 171);
		brandAndHierarchyPanel.add(fashin2Pnael);
		fashin2Pnael.setLayout(null);

		JLabel lblStyle = new JLabel("Style");
		lblStyle.setBounds(33, 19, 56, 16);
		lblStyle.setFont(new Font("Segoe UI", Font.BOLD, 13));
		fashin2Pnael.add(lblStyle);
		lblStyle.setHorizontalAlignment(SwingConstants.RIGHT);

		stylecode = new JTextField();
		stylecode.setBounds(155, 19, 49, 25);
		fashin2Pnael.add(stylecode);
		stylecode.setBackground(Color.WHITE);
		stylecode.setColumns(10);

		styleName = new JTextField();
		styleName.setBounds(98, 19, 56, 25);
		styleName.setBackground(Color.WHITE);
		styleName.setEditable(false);
		fashin2Pnael.add(styleName);
		styleName.setColumns(10);

		JLabel lblFit = new JLabel("Fit");
		lblFit.setBounds(33, 48, 56, 16);
		lblFit.setFont(new Font("Segoe UI", Font.BOLD, 13));
		fashin2Pnael.add(lblFit);
		lblFit.setHorizontalAlignment(SwingConstants.RIGHT);

		fitcode = new JTextField();
		fitcode.setBounds(155, 46, 49, 25);
		fashin2Pnael.add(fitcode);
		fitcode.setBackground(Color.WHITE);
		fitcode.setColumns(10);

		fitName = new JTextField();
		fitName.setBounds(99, 46, 55, 25);
		fitName.setBackground(Color.WHITE);
		fitName.setEditable(false);
		fashin2Pnael.add(fitName);
		fitName.setColumns(10);

		lblFabric = new JLabel("Material");
		lblFabric.setBounds(-50, 85, 50, 16);
		fashin2Pnael.add(lblFabric);
		lblFabric.setFont(new Font("Dialog", Font.BOLD, 12));
		lblFabric.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblManufactorar = new JLabel("Manufacturar");
		lblManufactorar.setBounds(0, 70, 93, 16);
		fashin2Pnael.add(lblManufactorar);
		lblManufactorar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblManufactorar.setHorizontalAlignment(SwingConstants.RIGHT);

		manufcode = new JTextField();
		manufcode.setBounds(98, 71, 57, 25);
		manufcode.setEditable(false);
		fashin2Pnael.add(manufcode);
		manufcode.setToolTipText("Press Enter To Select Manuf.");
		manufcode.setBackground(Color.WHITE);
		manufcode.setColumns(10);

		manufname = new JTextField();
		manufname.setBounds(155, 71, 49, 25);
		fashin2Pnael.add(manufname);
		manufname.setColumns(10);

		JLabel lblNewLabel_25 = new JLabel("Material");
		lblNewLabel_25.setBounds(33, 97, 56, 16);
		fashin2Pnael.add(lblNewLabel_25);
		lblNewLabel_25.setFont(new Font("Segoe UI", Font.BOLD, 13));

		fabriccode = new JTextField();
		fabriccode.setBounds(98, 93, 55, 25);
		fashin2Pnael.add(fabriccode);
		fabriccode.setBackground(Color.WHITE);
		fabriccode.setColumns(10);

		fabricName = new JTextField();
		fabricName.setBounds(155, 93, 49, 25);
		fashin2Pnael.add(fabricName);
		fabricName.setColumns(10);

		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(54, 124, 35, 16);
		fashin2Pnael.add(lblColor);
		lblColor.setFont(new Font("Segoe UI", Font.BOLD, 13));

		colorcode = new JTextField();
		colorcode.setBounds(99, 122, 54, 25);
		fashin2Pnael.add(colorcode);
		colorcode.setBackground(Color.WHITE);
		colorcode.setColumns(10);

		JLabel lblSize = new JLabel("Size");
		lblSize.setBounds(54, 152, 35, 16);
		fashin2Pnael.add(lblSize);
		lblSize.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSize.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblPattern = new JLabel("Pattern");
		lblPattern.setBounds(33, 3, 56, 16);
		fashin2Pnael.add(lblPattern);
		lblPattern.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblPattern.setHorizontalAlignment(SwingConstants.RIGHT);

		sizecode = new JTextField();
		sizecode.setBounds(99, 150, 54, 20);
		fashin2Pnael.add(sizecode);
		sizecode.setBackground(Color.WHITE);
		sizecode.setColumns(10);

		sizeName = new JTextField();
		sizeName.setBounds(155, 150, 49, 20);
		fashin2Pnael.add(sizeName);
		sizeName.setColumns(10);

		patterncode = new JTextField();
		patterncode.setBounds(98, 0, 55, 17);
		fashin2Pnael.add(patterncode);
		patterncode.setBackground(Color.WHITE);
		patterncode.setColumns(10);

		patternName = new JTextField();
		patternName.setBounds(155, 1, 49, 16);
		fashin2Pnael.add(patternName);
		patternName.setColumns(10);

		colorName = new JTextField();
		colorName.setBounds(155, 122, 49, 25);
		fashin2Pnael.add(colorName);
		colorName.setColumns(10);

		JLabel lblPackType = new JLabel("Pack Type");
		lblPackType.setBounds(365, 72, 76, 16);
		brandAndHierarchyPanel.add(lblPackType);
		lblPackType.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblPackType.setHorizontalAlignment(SwingConstants.RIGHT);

		a_packtype_code = new JTextField();
		a_packtype_code.setBounds(453, 65, 51, 25);
		brandAndHierarchyPanel.add(a_packtype_code);
		a_packtype_code.setBackground(Color.CYAN);
		a_packtype_code.setColumns(10);

		a_packtype_name = new JTextField();
		a_packtype_name.setBounds(503, 65, 183, 25);
		brandAndHierarchyPanel.add(a_packtype_name);
		a_packtype_name.setBackground(Color.WHITE);
		a_packtype_name.setColumns(10);

		lblNewLabel_22 = new JLabel("Shelf/Location");
		lblNewLabel_22.setBounds(12, 90, 94, 16);
		brandAndHierarchyPanel.add(lblNewLabel_22);
		lblNewLabel_22.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.RIGHT);

		shelfcode = new JTextField();
		shelfcode.setBounds(118, 81, 51, 25);
		brandAndHierarchyPanel.add(shelfcode);
		shelfcode.setText("0");
		shelfcode.setEnabled(false);
		shelfcode.setColumns(10);

		Shelfname = new JTextField();
		Shelfname.setBounds(168, 81, 171, 25);
		brandAndHierarchyPanel.add(Shelfname);
		Shelfname.setColumns(10);

		a_type_name = new JTextField();
		a_type_name.setText("Normal");
		a_type_name.setBounds(168, 28, 171, 25);
		brandAndHierarchyPanel.add(a_type_name);
		a_type_name.setColumns(10);

		a_type_code = new JTextField();
		a_type_code.setEditable(false);
		a_type_code.setText("1");
		a_type_code.setBounds(116, 28, 53, 25);
		brandAndHierarchyPanel.add(a_type_code);
		a_type_code.setColumns(10);

		lblNewLabel_26 = new JLabel("Article Type");
		lblNewLabel_26.setBounds(20, 34, 75, 16);
		brandAndHierarchyPanel.add(lblNewLabel_26);

		// tabpane.add("Size & Color Info", panel_2) ;
		tabpane.add("Create Varient -Fashion", optionPanel);
		tabpane.add("Drug Type-Pharma", DrugPanel);

		btnConvertRates = new JButton("Convert Prices");
		btnConvertRates.setBounds(381, 26, 126, 29);
		PurchaseuomPanel.add(btnConvertRates);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(188, 56, 351, 154);
		PurchaseuomPanel.add(panel);
		panel.setLayout(null);

		Puom_cost = new JTextField();
		Puom_cost.setBounds(112, 30, 111, 25);
		panel.add(Puom_cost);
		Puom_cost.setToolTipText("Enter  Purchase Price For Purchase UOM");
		Puom_cost.setFont(new Font("Cambria", Font.BOLD, 14));
		Puom_cost.setText("0.00");
		Puom_cost.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Pur Price");
		lblNewLabel_4.setBounds(114, 13, 85, 16);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));

		JLabel lblNewLabel_5 = new JLabel("MRP");
		lblNewLabel_5.setBounds(113, 55, 110, 16);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(new Color(0, 0, 102));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));

		JLabel lblNewLabel_6 = new JLabel("Sales Price");
		lblNewLabel_6.setBounds(113, 100, 110, 16);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setForeground(new Color(0, 0, 102));
		lblNewLabel_6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);

		Puom_mrp = new JTextField();
		Puom_mrp.setBounds(113, 69, 110, 25);
		panel.add(Puom_mrp);
		Puom_mrp.setToolTipText("Enter MRP For Define UOM");
		Puom_mrp.setFont(new Font("Cambria", Font.BOLD, 14));
		Puom_mrp.setText("0.00");
		Puom_mrp.setColumns(10);

		Puom_sp = new JTextField();
		Puom_sp.setBounds(113, 119, 110, 25);
		panel.add(Puom_sp);
		Puom_sp.setToolTipText("Enter Sales Price Define UOM");
		Puom_sp.setFont(new Font("Cambria", Font.BOLD, 14));
		Puom_sp.setText("0.00");

		optionPanel.setLayout(null);

		JLabel lblNewLabel_23 = new JLabel("No.Of Varients");
		lblNewLabel_23.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
		lblNewLabel_23.setBounds(245, 247, 113, 16);
		optionPanel.add(lblNewLabel_23);

		varcount = new JTextField();
		varcount.setBounds(365, 237, 116, 36);
		optionPanel.add(varcount);
		varcount.setColumns(10);

		ActionListener btn1 = new BtnLsnr();
		ActionListener cr = new createLike();
		ActionListener namels = new namels();
		ActionListener style = new ArticleStyle();
		ActionListener ptrn = new ArticlePattern();
		ActionListener fab = new ArticleFabric();
		ActionListener clr = new ArticleColor();
		ActionListener fit = new ArticleFit();
		ActionListener size = new ArticleSize();
		ActionListener btnvar = new btnSaveVarients();
		ActionListener cnt = new ContentType();
		ActionListener puruomls = new PurchaseUom();
		ActionListener ad = new Addbtn();
		ActionListener Atype = new ArticleType();
		ActionListener Aclss = new ArticleClass();
		ActionListener pform = new packForm();
		ActionListener ptype = new packType();
		ActionListener parent = new ArticleParent();
		ActionListener parent1 = new ArticleParent();
		ActionListener um = new ArticleUom();
		ActionListener lsmrp = new mrpLsnr();

		ActionListener cost1 = new costLsnr();
		ActionListener mrpbse = new mrpbase();
		ActionListener drgLsnr = new drugLsnr();

		ActionListener tax = new ArticleTax();
		ActionListener manuf = new ArticleManuf();
		ActionListener bnd = new ArticleBrand();
		ActionListener bndnm = new brandname();
		ActionListener hir = new ArticleHierarchy();
		ActionListener ean = new eanLsnr();
		name.addActionListener(namels);

		ActionListener addvartotable = new addVarienrtotableLsnr();

		ActionListener vrt = new Verticle();
		ActionListener hirLsnr = new hieLsnr();
		ActionListener hir1 = new ArticleHierarchy();
		btnSaveVarient.addActionListener(btnvar);
		btnAdd.addActionListener(ad);

		// Key Focus amd Key Listener
		KeyListener ky = new keyPressedlsnr();

		name.addKeyListener(ky);
		shortname.addKeyListener(ky);

		FocusListener fsnl = new btnfocus();
		name.addFocusListener(fsnl);
		shortname.addFocusListener(fsnl);
		btnSave.addActionListener(btn1);
		btnSave.addKeyListener(ky);
		btnCancel.addKeyListener(ky);
		btnSave.addKeyListener(ky);
		btnCancel.addKeyListener(ky);
		mrp.addActionListener(lsmrp);
		mrp.addKeyListener(ky);
		salesprice.addKeyListener(ky);
		mrp.addFocusListener(fsnl);
		salesprice.addFocusListener(fsnl);
		content.addActionListener(cnt);
		DrugType.addActionListener(drgLsnr);
		combopurqty.addActionListener(puruomls);
		btnConvertRates.addActionListener(btn1);
		btnConvertRates.addKeyListener(ky);
		btnConvertRates.addFocusListener(fsnl);

		articletype.addActionListener(Atype);
		// a_type_name.addActionListener(Atype);
		// a_type_name.addKeyListener(ky);
		// a_type_name.addFocusListener(fsnl);
		// a_type_code.addActionListener(Atype);
		ActionListener dnameLsn = new dnameLsnr();
		Dname.addActionListener(dnameLsn);

		ActionListener Shel = new ShelfLsnr();

		ActionListener materialLs = new maretialDropdoenLsnr();
		varmymaterial.addActionListener(materialLs);

		varsize.addActionListener(addvartotable); // clas addVarienrtotableLsnr
		// varpattern.addActionListener(addvartotable); //clas
		// addVarienrtotableLsnr
		// varcolor.addActionListener(addvartotable); //clas
		// addVarienrtotableLsnr
		// tax_code.addActionListener(tax);
		tax_code.addKeyListener(ky);
		tax_code.addFocusListener(fsnl);
		// uom.addActionListener(um);
		uom.addKeyListener(ky);
		uom.addFocusListener(fsnl);
		pksize.addKeyListener(ky);
		pksize.addFocusListener(fsnl);
		hsncode.addKeyListener(ky);

		Puom_sp.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(441, 12, 869, 310);
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Optional Parameter",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 102)));
		// topleft.add(panel_6);
		panel_6.setBackground(Color.CYAN);
		panel_6.setLayout(null);

		eancode = new JTextField();
		eancode.setBounds(18, 113, 133, 22);
		panel_6.add(eancode);
		eancode.setFont(new Font("Calibri", Font.PLAIN, 13));
		eancode.setToolTipText("Enter EAN Code Here ");
		eancode.setColumns(10);

		chkMrpArticle = new JCheckBox("Mrp Base Article", true);
		chkMrpArticle.setBounds(8, 51, 131, 17);
		panel_6.add(chkMrpArticle);
		chkMrpArticle.setFont(new Font("Calibri", Font.PLAIN, 13));
		chkMrpArticle.setToolTipText("MRP Base Article - Product MRP is Printed and Store Can not Sales More then MRP");
		chkMrpArticle.setForeground(Color.MAGENTA);

		chkTradingArticle = new JCheckBox("Allow Sales", true);
		chkTradingArticle.setBounds(8, 73, 126, 20);
		panel_6.add(chkTradingArticle);
		chkTradingArticle.setFont(new Font("Calibri", Font.PLAIN, 13));
		chkTradingArticle.setForeground(Color.MAGENTA);

		checkMntInventory = new JCheckBox("Maintain Inventory");
		checkMntInventory.setBounds(8, 93, 143, 25);
		panel_6.add(checkMntInventory);
		checkMntInventory.setSelected(true);
		checkMntInventory.setToolTipText("Check Box If Inventory For This Item");

		panel_5 = new JPanel();
		panel_5.setBackground(Color.CYAN);
		panel_5.setBounds(301, 13, 116, 126);
		panel_6.add(panel_5);
		panel_5.setBorder(UIManager.getBorder("List.focusCellHighlightBorder"));
		panel_5.setLayout(null);

		lblMaxShelfLife = new JLabel("Shelf Life");
		lblMaxShelfLife.setBounds(14, 20, 67, 16);
		panel_5.add(lblMaxShelfLife);

		maxshelflife = new JTextField();
		maxshelflife.setBounds(73, 17, 37, 22);
		panel_5.add(maxshelflife);
		maxshelflife.setColumns(10);

		lblRequiredShelfLife = new JLabel("Req.Shelf Life");
		lblRequiredShelfLife.setBounds(2, 41, 67, 16);
		panel_5.add(lblRequiredShelfLife);

		minshelflife = new JTextField();
		minshelflife.setBounds(73, 38, 37, 22);
		panel_5.add(minshelflife);
		minshelflife.setColumns(10);

		lblDays = new JLabel("Days");
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDays.setBounds(73, 1, 27, 16);
		panel_5.add(lblDays);
		lblDays.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblMbq = new JLabel("Max Stock ");
		lblMbq.setBounds(-38, 65, 109, 16);
		panel_5.add(lblMbq);
		lblMbq.setHorizontalAlignment(SwingConstants.RIGHT);

		mbq = new JTextField();
		mbq.setBounds(73, 62, 37, 22);
		panel_5.add(mbq);
		mbq.setText("0");
		mbq.setColumns(10);

		JLabel lblReorderLevel = new JLabel("Reorder");
		lblReorderLevel.setBounds(-10, 86, 79, 16);
		panel_5.add(lblReorderLevel);
		lblReorderLevel.setHorizontalAlignment(SwingConstants.RIGHT);

		rolevel = new JTextField();
		rolevel.setBounds(73, 97, 37, 22);
		panel_5.add(rolevel);
		rolevel.setText("0");
		rolevel.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Level");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(14, 102, 56, 16);
		panel_5.add(lblNewLabel_8);

		panel_9 = new JPanel();
		panel_9.setBackground(Color.CYAN);
		panel_9.setBounds(152, 13, 143, 127);
		panel_6.add(panel_9);
		panel_9.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_9.setLayout(null);

		JLabel lblSalesMargin = new JLabel("Sales Margin%");
		lblSalesMargin.setBounds(0, 73, 90, 16);
		panel_9.add(lblSalesMargin);

		salesmargin_per = new JTextField();
		salesmargin_per.setBounds(94, 70, 48, 22);
		panel_9.add(salesmargin_per);
		salesmargin_per.setToolTipText("Targeted Sales Margin ");
		salesmargin_per.setColumns(10);

		discount = new JTextField();
		discount.setBounds(94, 92, 48, 22);
		panel_9.add(discount);
		discount.setText("0.00");
		discount.setColumns(10);

		JLabel lblSalesDisc = new JLabel("Sales Disc%");
		lblSalesDisc.setBounds(12, 95, 78, 16);
		panel_9.add(lblSalesDisc);

		markup_per = new JTextField();
		markup_per.setBounds(94, 41, 49, 22);
		panel_9.add(markup_per);
		markup_per.setColumns(10);

		markdown_per = new JTextField();
		markdown_per.setBounds(94, 18, 49, 22);
		panel_9.add(markdown_per);
		markdown_per.setToolTipText("Mark Down Percentage on MRP to Calculate Sales Price");
		markdown_per.setColumns(10);

		JLabel lblMarkDown = new JLabel("Mark Down%");
		lblMarkDown.setBounds(9, 24, 81, 16);
		panel_9.add(lblMarkDown);

		JLabel lblMarkUp = new JLabel("Mark Up%");
		lblMarkUp.setBounds(26, 44, 64, 16);
		panel_9.add(lblMarkUp);

		bulkpanel = new JPanel();
		bulkpanel.setBounds(764, 13, 273, 73);
		panel_6.add(bulkpanel);
		bulkpanel.setBackground(new Color(204, 255, 204));
		bulkpanel.setBorder(new TitledBorder(null, "Assign Parent code for  Child Articles", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		bulkpanel.setLayout(null);
		bulkpanel.setVisible(false);

		JLabel lblParentArticleCode = new JLabel("Parent Code");
		lblParentArticleCode.setBounds(12, 30, 78, 16);
		bulkpanel.add(lblParentArticleCode);

		parentcode = new JTextField();
		parentcode.setBounds(0, 45, 39, 22);
		bulkpanel.add(parentcode);
		parentcode.setBackground(Color.WHITE);
		parentcode.setColumns(10);

		parentname = new JTextField();
		parentname.setBounds(38, 45, 154, 22);
		bulkpanel.add(parentname);
		parentname.setBackground(Color.WHITE);
		parentname.setColumns(10);

		processloss = new JTextField();
		processloss.setText("0.00");
		processloss.setBounds(189, 45, 39, 22);
		bulkpanel.add(processloss);
		processloss.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Proc.Loss");
		lblNewLabel_3.setBounds(172, 30, 56, 16);
		bulkpanel.add(lblNewLabel_3);
		tabpane.add("Additinal Info", panel_6);
		chkMrpArticle.addActionListener(mrpbse);

		parentname.addActionListener(parent);
		parentcode.addActionListener(parent);
		Puom_sp.addKeyListener(ky);
		Puom_sp.addFocusListener(fsnl);
		Puom_mrp.addKeyListener(ky);
		Puom_mrp.addFocusListener(fsnl);
		Puom_cost.addKeyListener(ky);
		Puom_cost.addFocusListener(fsnl);
		btnHierarchy.addActionListener(btn1);
		btnupdateBrand.addActionListener(btn1);

		btnAddEanCode.addActionListener(btn1);
		btnAddEanCode.addKeyListener(ky);
		btnAddEanCode.addKeyListener(ky);
		btnBrand.setVisible(true);
		btnBrand.addActionListener(btn1);
		btnBrand.addKeyListener(ky);
		btnBrand.addKeyListener(ky);

		btnCreateArticleLike.addActionListener(cr);
		Shelfname.addActionListener(Shel);
		a_packtype_name.addKeyListener(ky);
		a_packtype_name.addActionListener(ptype);
		colorName.addActionListener(clr);
		patternName.addActionListener(ptrn);
		sizeName.addActionListener(size);
		fabricName.addActionListener(fab);
		fabricName.addKeyListener(ky);
		fabricName.addFocusListener(fsnl);
		fabriccode.addActionListener(fab);
		manufname.addKeyListener(ky);
		manufcode.addActionListener(manuf);
		a_class_name.addKeyListener(ky);
		a_class_name.addKeyListener(ky);
		a_packform_name.addKeyListener(ky);
		brandname.addActionListener(bndnm);
		brandname.addKeyListener(ky);
		brandname.addFocusListener(fsnl);
		brandcode.addActionListener(bnd);
		hierarchyname.addActionListener(hir1);
		hierarchyname.addKeyListener(ky);
		hierarchyname.addFocusListener(fsnl);
		hname.addActionListener(hirLsnr);
		hname.addKeyListener(ky);
		hname.addFocusListener(fsnl);
		verticlename.addActionListener(vrt);
		verticlename.addKeyListener(ky);
		verticlename.addFocusListener(fsnl);
		verticlecode.addActionListener(vrt);
		a_packform_name.addActionListener(pform);
		a_class_name.addActionListener(Aclss);
		fitcode.addActionListener(fit);
		stylecode.addActionListener(style);

		btnSlab.addActionListener(btn1);
		btnSlab.addKeyListener(ky);
		btnSlab.addKeyListener(ky);
		checkean.addActionListener(ean);

		ActionListener brndcmb = new brandComboLsnr();
		brand.addActionListener(brndcmb);

		cost.addActionListener(cost1);
		cost.addKeyListener(ky);
		cost.addFocusListener(fsnl);

		decorate();

	}
	/// ===============Start focus and key Listener Coding here

	class brandComboLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			setbrand();
		}
	}

	private void setbrand() {
		String vname = brand.getSelectedItem().toString();
		brandname.setText(vname);
		String vmastername = "BRAND";
		try {
			String vcode = new gnComp().getCodeOfMasterDescription(vmastername, vname);
			brandcode.setText(vcode);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void decorate() throws Throwable {
		// new gnComp().mytestcombo(comboTest) ;

		ArticleMasterFrame.setUndecorated(true);
		DrugPanel.setVisible(false);
		optionPanel.setVisible(false);
		// a_type_code.setVisible(false);
		// a_type_name.setVisible(false);
		new gnApp().setFrameTitel(ArticleMasterFrame);
		new gnField().closeform(tabpane, ArticleMasterFrame);

		tabpane.setVisible(false);
		a_type_name.setEnabled(true);
		String vpara812 = "812";
		String vsetvalue = new getConfigurationSetting().getSpecificConfiguration(vpara812);
		switch (vsetvalue) {
		case "Y":
			tabpane.setVisible(true);
			btnAdditionalFillInfo.setVisible(false);
		case "N":
			tabpane.setVisible(false);
			btnAdditionalFillInfo.setVisible(true);
		}

		String vuser = new General().getUsercode();
		switch (vuser) {
		case "ADMIN":
			btnBrand.setVisible(true);
			btnHierarchy.setVisible(true);
		}

		name.setText(name.getText().toUpperCase());
		shortname.setText(name.getText().toUpperCase());
		rb1.setVisible(false);
		rb2.setVisible(false);
		btnDiscgrp.setVisible(false);
		autoname.setVisible(false);
		DrugPanel.setVisible(false);
		eancode.setVisible(false);
		// checkean.setVisible(false);
		fashin2Pnael.setVisible(false);
		applytaxslab.setVisible(false);
		btnSlab.setVisible(false);
		lblFabric.setVisible(false);
		fabriccode.setVisible(false);
		fabricName.setVisible(false);
		lblNewLabel_27.setVisible(false); //shortcutkey
		shortkey.setVisible(false);

		// combopurqty
		String vmsname1 = "Pack_Form";
		String vverticle = new gnHierarchy().getVerticleCode();
		String Search = "%%";
		String SQL11 = "call master_getMasterData('" + vmsname1 + "' , " + vverticle + " , '" + Search + "')";
		new gnComp().fillCombo(SQL11, combopurqty);
		combopurqty.setSelectedItem("NO");

		String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		String vverticlename = new getConfigurationSetting().getVerticleName(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		verticlecode.setText(vverticlecode);
		verticlename.setText(vverticlename);
		verticlename.setEnabled(true);
		switch (vverticlecode) {

		
 
		case "7":
			applytaxslab.setVisible(true);
			applytaxslab.setSelected(true);
			btnSlab.setVisible(true);
			lblFabric.setVisible(true);
			fabriccode.setVisible(true);
			fabricName.setVisible(true);
			DrugPanel.setVisible(false);
			optionPanel.setVisible(true);
			String vmsname = "";
			String vsearch = "%%";

			vmsname = "Color";
			String SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticlecode + " , '" + vsearch + "')";
			new gnComp().fillCombo(SQL1, varcolor);

			vmsname = "Pattern";
			SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticlecode + " , '" + vsearch + "')";
			new gnComp().fillCombo(SQL1, varpattern);
			varpattern.setSelectedIndex(0);

			vmsname = "Fabric";
			SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticlecode + " , '" + vsearch + "')";
			new gnComp().fillCombo(SQL1, varmymaterial);
			varmymaterial.setSelectedIndex(0);

			vmsname = "Size";
			SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticlecode + " , '" + vsearch + "')";
			new gnComp().fillCombo(SQL1, varsize);

			break;

		case "14":
			applytaxslab.setVisible(true);
			btnSlab.setVisible(true);

			vmsname = "Size";
			vsearch = "%%";
			SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticlecode + " , '" + vsearch + "')";
			new gnComp().fillCombo(SQL1, varsize);

			vmsname = "Color";
			SQL1 = "call master_getMasterData('" + vmsname + "'  , " + vverticlecode + " ,  '" + vsearch + "')";
			new gnComp().fillCombo(SQL1, varcolor);
			break;

		case "5":
			DrugPanel.setVisible(true);
			optionPanel.setVisible(false);
			break;
		case "2":
			DrugPanel.setVisible(true);
			optionPanel.setVisible(false);
			break;
		}
		if (Language == "H") {
			name.setFont(new Font("Shivaji02", Font.PLAIN, 16));
			shortname.setFont(new Font("Shivaji02", Font.PLAIN, 16));
		}
		if (vverticlename.toUpperCase() == "AUTOMOBILE") {
			btnDiscgrp.setVisible(true);
		}
		processloss.setVisible(false);
		bulkpanel.setVisible(false);
		panel_2.setVisible(false);
		varPanel.setVisible(false);
		panel_5.setVisible(true);

		int typeno = 1;
		new gnDecorate().SetSeqHdrButton(btnSave, typeno);
		new gnDecorate().SetSeqHdrButton(btnHierarchy, typeno);
		new gnDecorate().SetSeqHdrButton(btnupdateBrand, typeno);
		new gnDecorate().SetSeqHdrButton(btnCancel, typeno);
		new gnDecorate().SetSeqHdrButton(btnAdd, typeno);
		new gnDecorate().SetSeqHdrButton(btnAddEanCode, typeno);
		new gnDecorate().SetSeqHdrButton(btnBrand, typeno);
		new gnDecorate().SetSeqHdrButton(btnSalesPrice, typeno);
		new gnDecorate().SetSeqHdrButton(btnCreateArticleLike, typeno);
		new gnDecorate().SetSeqHdrButton(btnSaveVarient, typeno);

		new gnTable().RemoveTableRows(vmodel);

		supplier_code.setVisible(false);
		supplier_name.setVisible(false);
		segmentcode.setVisible(false);
		segmentname.setVisible(false);
		segmentname.setVisible(false);
		defualtLocation.setVisible(false);
		setDefaultValue();

		String vmastername = "UOM";
		new gnComp().setMasterDataIncombo(vmastername, uom);

		vmastername = "Tax";
		new gnComp().setMasterDataIncombo(vmastername, tax_code);

		vmastername = "ARticle_Type";
		new gnComp().fillMasterCombo(articletype, vmastername);

		vmastername = "BRAND";
		new gnComp().fillMasterCombo(brand, vmastername);

		AutoCompleteDecorator.decorate(articletype);
 		AutoCompleteDecorator.decorate(uom);
  		AutoCompleteDecorator.decorate(tax_code);
		AutoCompleteDecorator.decorate(brand);
		
		
		switch(verticlecode.getText())
		{
				case  "15" :
			    articletype.setSelectedItem("ServiceArticle");
 			    break ;
				case  "3" :
				articletype.setSelectedItem("Kitchen Item");
				break ;
 		}
		
	}

	class maretialDropdoenLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vmaterialcode = varmymaterial.getSelectedItem().toString();
			fabriccode.setText(vmaterialcode);
			fabricName.setText(vmaterialcode);
		}
	}

	class dnameLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean vrb = rb1.isSelected();
			if (vrb) {
				vchoice = "Name";
			} else {
				vchoice = "Brand";
			}
			try {
				doAction();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void doAction() throws ClassNotFoundException, SQLException {
		String SQL = "";
		String vsearch = "";
		String vtype = "";
		vsearch = Dname.getText();
		vtype = "NewArticle";
		vsearch = "%" + vsearch + "%";
		showArticleData(vsearch, vtype);
	}

	private void showArticleData(String vname, String vtype) throws ClassNotFoundException, SQLException {

		String[] newcol = { "Article Code", "Name", "HSNCODE", "PkSize", "UOM", "SalesPrice", "MRP", "Cost", "Tax code",
				"Batch(Y/N)", "Brand", "Brand Name", "Subcatcode", "SubCatName" };
		// String vtype = "Article" ;
		new gnTable().RemoveTableRows(dmodel);
		dmodel.setColumnIdentifiers(newcol);
		dtable.setModel(dmodel);
		String vverticlecode = new gnHierarchy().getVerticleCode();
		String SQL = "Call  article_getDataForupdate('" + vtype + "', " + compcode + ", '" + vname + "' , "
				+ vverticlecode + ")";
		new gnTableModel().Tablemodel(dtable, dmodel, SQL, newcol, 14, "N", "N", "N");

		JViewport prt766 = new JViewport();
		prt766.setBackground(new Color(204, 255, 255));
		prt766.add(dtable, newcol);
		prt766.setVisible(true);
		djsp.setViewport(prt766);
		dtable.requestFocus();
		dtable.grabFocus();
		dtable.setSelectionBackground(Color.WHITE);
		dtable.setSelectionForeground(Color.BLACK);
		new gnTable().setTablewidth(dtable, 1, 300);
		new gnTable().setTablewidth(dtable, 2, 50);
		new gnTable().setTablewidth(dtable, 3, 70);
		new gnTable().setTablewidth(dtable, 4, 50);
		new gnTable().setTableBasics(dtable);

		selectDisplayItem();

	}

	public void selectDisplayItem() {
		dtable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		dtable.requestFocus();
		dtable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = dtable.getSelectedRow();
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
		super.vmyarticlecode = dtable.getValueAt(row, 0).toString();
		super.varticlename = dtable.getValueAt(row, 1).toString();
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

	
	
	class keyPressedlsnr implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int value = e.getKeyCode();
			// new General().msg("Key Pressed "+ value);
			switch (value) {
			case 10:

				if (name.isFocusOwner()) {
					shortname.grabFocus();
				}

				if (shortname.isFocusOwner()) {
					articletype.grabFocus();
 				}

				if (articletype.isFocusOwner()) {
					pksize.grabFocus();
 				}
				
				
				if (pksize.isFocusOwner()) {
					uom.grabFocus();
				}

				if (uom.isFocusOwner()) {
					tax_code.grabFocus();
				}

				
				
				if (tax_code.isFocusOwner()) {
					salesprice.grabFocus();
					
					cost.setText("");
					cost.grabFocus();
 					switch(verticlecode.getText())
					{
 					case "3" :
						 salesprice.grabFocus();
 					case "9" :
 						 salesprice.grabFocus();
						 break ; 
  					case "11" :
						salesprice.grabFocus();
 						break ; 
					}
 				}

				
				if (salesprice.isFocusOwner()) {
					//articletype.grabFocus();
   					mrp.setText(salesprice.getText());
					Puom_cost.setText("0.01");
					Puom_mrp.setText(mrp.getText());
					Puom_sp.setText(salesprice.getText());
 					converttoBoxPrice();
					brand.grabFocus();
					
 				}

				
				if (cost.isFocusOwner()) {
					brandname.grabFocus();
				}

				if (mrp.isFocusOwner()) {
 					cost.setText("0.01");
					cost.grabFocus();
				}

 
 
				if (brand.isFocusOwner()) {
					hsncode.grabFocus();
				}

				if (hsncode.isFocusOwner()) {

					btnSave.grabFocus();
					btnSave.setBackground(Color.BLUE);
					btnSave.setForeground(Color.YELLOW);
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

	// Focus Lisener Class Start here

	class btnfocus implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {

			new gnDecorate().decorateBtn(btnSave, Color.DARK_GRAY, Color.WHITE);

			if (hsncode.isFocusOwner()) {
				new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
			}

			if (brandname.isFocusOwner()) {
				new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
			}

			if (hierarchyname.isFocusOwner()) {
				new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
			}

			if (a_class_name.isFocusOwner()) {
				new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
			}

			if (a_packform_name.isFocusOwner()) {
				new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
			}

			if (a_packtype_name.isFocusOwner()) {
				new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
			}

			if (btnSave.isFocusOwner()) {
				new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
			}

			if (btnCancel.isFocusOwner()) {
				new gnDecorate().decorateBtn(btnCancel, Color.MAGENTA, Color.WHITE);
			}

			if (btnBrand.isFocusOwner()) {
				new gnDecorate().decorateBtn(btnBrand, Color.MAGENTA, Color.WHITE);
			}

			if (btnAddEanCode.isFocusOwner()) {
				new gnDecorate().decorateBtn(btnAddEanCode, Color.MAGENTA, Color.WHITE);
			}

			if (name.isFocusOwner()) {
				name.setBackground(Color.darkGray);
				name.setForeground(Color.WHITE);

			}

			if (brandname.isFocusOwner()) {
				brandname.setBackground(Color.darkGray);
				brandname.setForeground(Color.WHITE);

			}

			if (fabricName.isFocusOwner()) {
				fabricName.setBackground(Color.darkGray);
				fabricName.setForeground(Color.WHITE);

			}

			if (a_type_name.isFocusOwner()) {
				a_type_name.setBackground(Color.darkGray);
				a_type_name.setForeground(Color.WHITE);
			}

			if (shortname.isFocusOwner()) {
				shortname.setBackground(Color.darkGray);
				shortname.setForeground(Color.WHITE);

			}

			if (verticlename.isFocusOwner()) {
				verticlename.setBackground(Color.darkGray);
				verticlename.setForeground(Color.WHITE);
			}

			if (hname.isFocusOwner()) {
				hname.setBackground(Color.darkGray);
				hname.setForeground(Color.WHITE);
			}

			if (hierarchyname.isFocusOwner()) {
				hierarchyname.setBackground(Color.darkGray);
				hierarchyname.setForeground(Color.WHITE);
			}

			if (pksize.isFocusOwner()) {
				pksize.setBackground(Color.darkGray);
				pksize.setForeground(Color.WHITE);
			}

			if (uom.isFocusOwner()) {
				uom.setBackground(Color.darkGray);
				uom.setForeground(Color.WHITE);
			}

			if (tax_code.isFocusOwner()) {
				tax_code.setBackground(Color.darkGray);
				tax_code.setForeground(Color.WHITE);
			}

			if (Puom_mrp.isFocusOwner()) {
				Puom_mrp.setBackground(Color.darkGray);
				Puom_mrp.setForeground(Color.WHITE);
			}

			if (salesprice.isFocusOwner()) {
				Puom_sp.setBackground(Color.darkGray);
				Puom_sp.setForeground(Color.WHITE);
			}

			if (Puom_cost.isFocusOwner()) {
				Puom_cost.setBackground(Color.darkGray);
				Puom_cost.setForeground(Color.WHITE);
			}

		}

		@Override
		public void focusLost(FocusEvent e) {

			name.setBackground(Color.white);
			name.setForeground(Color.BLACK);
			shortname.setBackground(Color.white);
			shortname.setForeground(Color.BLACK);
			hierarchyname.setBackground(Color.white);
			hierarchyname.setForeground(Color.BLACK);
			hname.setBackground(Color.white);
			hname.setForeground(Color.BLACK);
			pksize.setBackground(Color.white);
			pksize.setForeground(Color.BLACK);

			Puom_cost.setBackground(Color.white);
			Puom_cost.setForeground(Color.BLACK);

			Puom_mrp.setBackground(Color.white);
			Puom_mrp.setForeground(Color.BLACK);

			Puom_sp.setBackground(Color.white);
			Puom_sp.setForeground(Color.BLACK);

			uom.setBackground(Color.white);
			uom.setForeground(Color.BLACK);

			a_type_name.setBackground(Color.white);
			a_type_name.setForeground(Color.BLACK);

			brandname.setBackground(Color.white);
			brandname.setForeground(Color.BLACK);

			a_class_name.setBackground(Color.white);
			a_class_name.setForeground(Color.BLACK);

			a_packform_name.setBackground(Color.white);
			a_packform_name.setForeground(Color.BLACK);

			a_packtype_name.setBackground(Color.white);
			a_packtype_name.setForeground(Color.BLACK);

			manufname.setBackground(Color.white);
			manufname.setForeground(Color.BLACK);

			if (verticlecode.getText() == "7") {
				fabricName.setBackground(Color.white);
				fabricName.setForeground(Color.BLACK);
			}

			new gnDecorate().decorateBtn(btnSave, Color.cyan, Color.black);
			new gnDecorate().decorateBtn(btnHierarchy, Color.cyan, Color.black);
			new gnDecorate().decorateBtn(btnupdateBrand, Color.cyan, Color.black);
			new gnDecorate().decorateBtn(btnCancel, Color.cyan, Color.black);
			new gnDecorate().decorateBtn(btnAddEanCode, Color.cyan, Color.black);
			new gnDecorate().decorateBtn(btnBrand, Color.cyan, Color.black);

			verticlename.setBackground(Color.white);
			verticlename.setForeground(Color.BLACK);

			tax_code.setBackground(Color.white);
			tax_code.setForeground(Color.BLACK);

			cost.setBackground(Color.white);
			cost.setForeground(Color.BLACK);

			salesprice.setBackground(Color.white);
			salesprice.setForeground(Color.BLACK);

			mrp.setBackground(Color.white);
			mrp.setForeground(Color.BLACK);
		}
	}

	// Start code Here
	class Verticle implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			// System.out.println("Reached ");
			int i = e.getID(); // Field Id
			try {
				new gnAdmin().setverticle(verticlecode, verticlename, Hierarchyno, hname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class hieLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			// System.out.println("Reached ");
			int i = e.getID(); // Field Id
			try {
				// new gnAdmin().hierarchy_getHierarchyData(Hierarchyno, hname);
				new gnAdmin().getHierarchyDescOfGivenVerticle(verticlecode.getText(), Hierarchyno, hname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	public void setDefaultValue() throws Throwable {

		dsubgroupcode.setText(null);
		dsubgroupname.setText(null);
		brandname.setText(null);
		hierarchyname.setText(null);
		a_class_name.setText(null);
		dgroupcode.setText(null);
		dgroupname.setText(null);
		shelfcode.setText("0");
		Shelfname.setText(null);
		dcatcode.setText("");
		dcatname.setText("");

		dsubcatcode.setText("");
		dsubcatname.setText("");

		vArticle_category = "0"; // new gnHierarchy().vArticle_category ;
		vArticle_subcategory = "0"; // new gnHierarchy().vArticle_subcategory;
		vArticle_group = "0"; // new gnHierarchy().vArticle_group ;
		vArticle_subGroup = "0";// new gnHierarchy().vArticle_subGroup ;
		name.setDocument(new gnSetinputLimit(60));
		shortname.setDocument(new gnSetinputLimit(29));
		etime.setText(new General().getTime());
		companycode.setText(new gnConfig().getCompanyCode());
		segmentcode.setText(new gnHierarchy().getSegmentCode());
		segmentname.setText("Retail");
		Hierarchyno.setText(new gnHierarchy().getHierarchyNo());
		hname.setText(new gnHierarchy().getHierarchyName());
		verticlecode.setText(new gnPublicVariable().verticlecode);
		verticlename.setText(new gnPublicVariable().verticlename);
		hierarchycode.setText("0");
		mbq.setText("0");
		rolevel.setText("0");
		autoname.setText(" ");
		defualtLocation.setText("SL");
		// Other Non Mandatory Filed Value default as 0
		chkTradingArticle.setSelected(true);
		chkBatchControl.setSelected(false);
		combopurqty.setSelectedIndex(0);

		eancode.setText("0");
		shortname.setText(null);
		// autoname.setText(null);
		supplier_code.setText("0");
		supplier_name.setText("Default  Supplier");
		innerpackqty.setText("1");
		cost.setText("0.00");
		mrp.setText("0.00");
		salesprice.setText("0");
		markdown_per.setText("0.00");
		markup_per.setText("0.00");
		salesmargin_per.setText("0.00");
		parentcode.setText("0");

		// processloss.setText("0.00");

		fitcode.setText("0");
		colorcode.setText("0");
		sizecode.setText("0");
		stylecode.setText("0");
		patterncode.setText("0");
		fabriccode.setText("0");
		colorName.setText(" ");
		sizeName.setText(" ");
		fitName.setText(" ");
		styleName.setText(" ");
		patternName.setText(" ");
		fabricName.setText(" ");
		manufcode.setText("0");
		// hsncode.setText("0");
		name.grabFocus();
		// brandcode.setText("0");
		manufname.setText("None");
		brandname.setText("");
		a_type_code.setText("1");
		a_type_name.setText("Normal");
		brandcode.setText("0");
		brandname.setText(null);
		a_class_code.setText("0");
		a_class_name.setText(null);
		a_packform_code.setText("0");
		a_packform_name.setText(null);
		a_packtype_code.setText("0");
		a_packtype_name.setText(null);
		maxshelflife.setText("0");
		minshelflife.setText("0");
		a_class_code.setText("0");
		Puom_cost.setText("0");
		Puom_mrp.setText("0");
		Puom_sp.setText("0");

		String vcomp = companycode.getText();
		switch (vcomp) {
		}

		String vbypassothers = "Y"; // Will come from Configuration PArameter
		if (vbypassothers == "Y") {
			manufcode.setText("0");
			manufname.setText("None");
			manufname.setEnabled(false);
			manufcode.setEnabled(false);
			manufcode.setBackground(Color.cyan);
			manufname.setBackground(Color.cyan);
		}
		new gnDecorate().setDefaultCursor(topleft);
	}

	class drugLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vtype = "DrugType";
			try {
				vmastersearchString = "%" + DrugType.getText() + "%";
				new gnAdmin().showMasterTable(vtype, drugCode, DrugType);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				setTradingArticleFlag();
			}
			//
		}
	}

	private void setTradingArticleFlag() {

		try {
			String vmastername = "Article_Type";
			String vname = articletype.getSelectedItem().toString().trim();
			String vcode;
			vcode = new gnComp().getCodeOfMasterDescription(vmastername, vname);
			a_type_code.setText(vcode);
			a_type_name.setText(vname);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String varticleType = a_type_code.getText();
		switch (varticleType) {
		case "1":
			chkTradingArticle.setSelected(true);
			// varientPanel.setVisible(false);
			bulkpanel.setVisible(false);
			panel_2.setVisible(false);
			break;
			
		case "9":
			chkTradingArticle.setSelected(true);
 			bulkpanel.setVisible(false);
			panel_2.setVisible(false);
			break;
			

		case "2":
			// varientPanel.setVisible(true);
			// panel_2.setVisible(true);
			varPanel.setVisible(true);
			// nkk
			tabpane.setSelectedComponent(optionPanel);

			// panel_2.setVisible(true);
			// panel_2.requestFocus();
			// panel_2.grabFocus();
			chkTradingArticle.setSelected(false);
			new gnImageSound().playSound();
			break;
		case "3":
			chkTradingArticle.setSelected(true);
			// bulkpanel.setVisible(true);
			panel_2.setVisible(true);
			new General().msgPanel(bulkpanel, "Select Information ", 300, 100);
			break;
		case "4":
			chkTradingArticle.setSelected(true);
			// varientPanel.setVisible(true);
			bulkpanel.setVisible(true);
			panel_2.setVisible(false);
			break;
		case "5":
			chkTradingArticle.setSelected(true);
			// varientPanel.setVisible(false);
			bulkpanel.setVisible(true);
			new General().msgPanel(bulkpanel, "Select Information ", 300, 100);
			panel_2.setVisible(false);
			break;
		case "6":
			chkTradingArticle.setSelected(false);
			// varientPanel.setVisible(false);
			bulkpanel.setVisible(false);
			panel_2.setVisible(false);
			break;
		case "7":
			chkTradingArticle.setSelected(true);
			bulkpanel.setVisible(false);
			// varientPanel.setVisible(false);
			panel_2.setVisible(false);
			break;
		case "8":
			chkTradingArticle.setSelected(false);
			// varientPanel.setVisible(false);
			bulkpanel.setVisible(false);
			panel_2.setVisible(false);
			break;
 
		case "0":
			chkTradingArticle.setSelected(false);
			bulkpanel.setVisible(false);
			// varientPanel.setVisible(false);
			panel_2.setVisible(false);
			break;
		}
	}

	private void setFieldSettingForArticleType() throws ClassNotFoundException, SQLException {
		String vmastername = "Article_Type";
		String vname = articletype.getSelectedItem().toString().trim();
		String vcode;
		vcode = new gnComp().getCodeOfMasterDescription(vmastername, vname);
		switch (vcode) {

		case "1": // Kitchen Item
			cost.setText("0");
 			mrp.setText("0");
			cost.setVisible(true); 
 			mrp.setVisible(true);
 			lblCostPrice.setVisible(true);
		    lblMrp.setVisible(true);
 			break;


		case "2":  //Generic
			cost.setText("0");
 			mrp.setText("0");
			cost.setVisible(true); 
 			mrp.setVisible(true);
 			lblCostPrice.setVisible(true);
		    lblMrp.setVisible(true);
 			break;

		case "3":  //Varient
			cost.setText("0");
 			mrp.setText("0");
			cost.setVisible(true); 
 			mrp.setVisible(true);
 			lblCostPrice.setVisible(true);
		    lblMrp.setVisible(true);
 			break;

		case "4":  //BULK
			cost.setText("0");
 			mrp.setText("0");
			cost.setVisible(true); 
 			mrp.setVisible(true);
 			lblCostPrice.setVisible(true);
		    lblMrp.setVisible(true);
 			break;

		case "5":  //Child
			cost.setText("0");
 			mrp.setText("0");
			cost.setVisible(true); 
 			mrp.setVisible(true);
 			lblCostPrice.setVisible(true);
		    lblMrp.setVisible(true);
 			break;

		case "6":  //Child
			cost.setText("0");
 			mrp.setText("0");
			cost.setVisible(true); 
 			mrp.setVisible(true);
 			lblCostPrice.setVisible(true);
		    lblMrp.setVisible(true);
 			break;

		case "7":  //Child
			cost.setText("0");
 			mrp.setText("0");
			cost.setVisible(true); 
 			mrp.setVisible(true);
 			lblCostPrice.setVisible(true);
		    lblMrp.setVisible(true);
 			break;

 			
		case "8":  //Child
			cost.setText("0");
 			mrp.setText("0");
			cost.setVisible(true); 
 			mrp.setVisible(true);
 			lblCostPrice.setVisible(true);
		    lblMrp.setVisible(true);
 			break;

		case "9": // SErvice Article
 			cost.setText("0.01");
 			mrp.setText("0.01");
			cost.setEnabled(false); 
 			mrp.setEnabled(false);
  			break;

		case "10": // SErvice Article
 			cost.setText("0");
 			mrp.setText("0");
			cost.setVisible(false); 
 			mrp.setVisible(false);
 			lblCostPrice.setVisible(false);
		    lblMrp.setVisible(false);
 			break;
 			
		case "11": // Kitchen Item
 			cost.setText("0.01");
 			mrp.setText("0.01");
			cost.setEnabled(false); 
 			mrp.setEnabled(false);
 			break;
  		}
	}

	class ArticleType implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vtype = "Article_Type";
			try {
				String vmastername = "Article_Type";
				String vname = articletype.getSelectedItem().toString().trim();
				String vcode;
				vcode = new gnComp().getCodeOfMasterDescription(vmastername, vname);
				a_type_code.setText(vcode);
				a_type_name.setText(vname);
 				setFieldSettingForArticleType();
 				// Nitin
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				setTradingArticleFlag();
			}
		}
	}

	class ShelfLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vtype = "Shelf";
			try {
				vmastersearchString = "%%";
				new gnAdmin().showMasterTable(vtype, shelfcode, Shelfname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				// Article_type_setting() ;
				setTradingArticleFlag();
			}
		}
	}

	class ContentType implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String vtype = "Content";
			try {
				vmastersearchString = "%" + content.getText() + "%";
				new gnAdmin().showMasterTable(vtype, content_code, content);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				setTradingArticleFlag();
			}
		}
	}

	// fashion//

	class addVarienrtotableLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			dropdownAction = "Y";
			process_articleType2();
			// generateVarientNameDropdown() ;
		}
	}

	class generaeNameLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			generateVarientNameDropdown();
		}
	}

	// Fashion//
	class btnSaveVarients implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vposname = name.getText();
			String varticleType = a_type_code.getText();
			switch (varticleType) {
			case "2":
				try {
					new General().Quickmsg("Generating Names..For Varients...");
					// generateVarientNameDropdown() ;
					varientToInsert2();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				String status = validateVarients();
				if (status == "Sucess") {
					try {
						insert_varent_EanCode();
					} catch (Exception e1) {
						e1.printStackTrace();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
				break;

			case "4":
				try {
					varientToInsert4();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				String status1 = validateVarients();
				new General().msg("Child Validation" + " " + status1);
				if (status1 == "Sucess") {
					try {
						insert_Child_EanCode();
					} catch (Exception e1) {
						e1.printStackTrace();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
				break;
			}// switch
		}
	}

	// Fashion//
	private String validateVarients() {
		String status = "Sucess";

		int row = vtable.getRowCount();
		if (row == 0) {
			new General().msg("No Records To Save");
			status = "Fail";
		}
		int vlength1 = vtable.getValueAt(0, 14).toString().length();
		if (vlength1 == 0) {
			new General().msg("Save Parent Code First...");
			status = "Fail";
		}
		for (int i = 0; i < row; i++) {
			int vlength = vtable.getValueAt(i, 15).toString().length();
			if (vlength == 0) {
				int option = new General().msgInput(
						"No Information is Filled for Varient at  Line No  " + i + "  " + "Do you Want to Remove Row");
				if (option == 0) {
					vtable.remove(i);
				}
				status = "Fail";
			}
		}
		for (int i = 0; i < row; i++) {
			int vlength = vtable.getValueAt(i, 15).toString().length();
			if (vlength > 15) {
				new General().msg("Lenght of Short Name Is more than 15 Chars Please Change at Line no " + i + 1);
				status = "Fail";
			}
		}
		return status;
	}

	class Addbtn implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String varticleType = a_type_code.getText();
			switch (varticleType) {
			case "2":
				dropdownAction = "N";
				process_articleType2();
				break;
			case "4":
				process_articleType4();
				break;
			}
		}
	}

	// fashion//
	private void process_articleType2() {
		String vCol[] = { "Del", "Type", "varient Name", "Size", "Color", "Pattern", "Material", "Fit", "Style",
				"Long  Name", "Varient Code", "Cost", "MRP", "Sales Price", "Parent Code", "Short Name" };
		vmodel.setColumnIdentifiers(vCol);
		vtable.setModel(vmodel);
		String vmsname = "";
		String vverticle = "";
		String SQL3 = "";

		switch (dropdownAction) {
		case "Y":

			String mypattern = varpattern.getSelectedItem().toString();
			String mymaterial = fabriccode.getText();
			String vmysize = varsize.getSelectedItem().toString();
			String mycolor = varcolor.getSelectedItem().toString();
			String vrntName = "";
			String vpattern = "";

			vrntName = name.getText().concat("-").concat("-").concat(vmysize).concat("-").concat(mycolor) + "("
					+ mypattern + ")" + mymaterial;
			// vrntName =
			// name.getText().concat(vmysize).concat(mycolor).concat(mymaterial).concat(mypattern);
			// vmodel.addRow(new Object[] { " ", "Varients", name.getText(),
			// vmysize , mycolor, mypattern, mymaterial , " ", " ", vrntName,"
			// ",cost.getText(), mrp.getText(), salesprice.getText(), " ",
			// shortname.getText()});
			vmodel.addRow(new Object[] { " ", "Varients", name.getText(), vmysize, mycolor, mypattern,
					fabriccode.getText(), "  ", "  ", vrntName, " ", cost.getText(), mrp.getText(),
					salesprice.getText(), " ", shortname.getText() });
			vtable.setModel(vmodel);
			varcount.setText(Integer.toString(vtable.getRowCount()));
			break;

		case "N":
			vmodel.addRow(new Object[] { " ", "Varients", name.getText(), "  ", "  ", "0", fabriccode.getText(), "  ",
					"  ", " ", " ", cost.getText(), mrp.getText(), salesprice.getText(), " ", " " });
			vtable.setModel(vmodel);
			vmsname = "Size";
			vverticle = new gnHierarchy().getVerticleCode();
			vmastersearchString = "%%";
			SQL3 = "call master_getMasterData('" + vmsname + "' , " + vverticle + ")";
			vtable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL3)));

			vmsname = "Size";
			vverticle = new gnHierarchy().getVerticleCode();
			vmastersearchString = "%%";
			SQL3 = "call master_getMasterData('" + vmsname + "' , " + vverticle + ")";
			vtable.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL3)));

			vmsname = "Color";
			vmastersearchString = "%%";
			vverticle = new gnHierarchy().getVerticleCode();
			SQL3 = "call master_getMasterData('" + vmsname + "' , " + vverticle + ")";
			vtable.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL3)));

			vmsname = "Pattern";
			vverticle = new gnHierarchy().getVerticleCode();
			vmastersearchString = "%%";
			SQL3 = "call master_getMasterData('" + vmsname + "' , " + vverticle + ")";
			vtable.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL3)));
			break;
		}

		vtable.setModel(vmodel);
		vtable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		vtable.setRowHeight(22);
		new gnTable().setTableBasics(vtable);
		new gnTable().setTableColWidth(vtable, 2, 150);
		new gnTable().setTableColWidth(vtable, 9, 250);
		new General().removeRow(vmodel, vtable);
		varcount.setText(Integer.toString(vtable.getRowCount()));
		DefaultCellEditor nk = new gnTable().cellEdit(vtable);
		nk.addCellEditorListener(ChangeNotification1);
		JViewport prt101 = new JViewport();
		prt101.setBackground(Color.white);
		prt101.add(vtable, vCol);
		prt101.setVisible(true);
		vjsp.setViewport(prt101);
		// }
	}

	// fashion//
	public CellEditorListener ChangeNotification1 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
			System.out.println("The user canceled editing.");
		}

		public void editingStopped(ChangeEvent e) {
			int nrow = vtable.getSelectedRow();
			int ncol = vtable.getSelectedColumn();
			try {
				String varticleType = a_type_code.getText();
				switch (varticleType) {
				case "2":
					getColumnProcess(nrow, ncol);
					break;
				case "4":
					getColumnProcess4(nrow, ncol);
					break;
				}
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};

	// fashion//
	private void getColumnProcess(int nrow, int ncol) throws Throwable {
		String vtype = "";
		switch (ncol) {
		case 3:
			vtype = "Size";
			vmastersearchString = "%" + sizeName.getText() + "%";
			new gnAdmin().showMasterTable(vtype, sizecode, sizeName);
			getAttribute(vtype, nrow, ncol);
			break;

		case 4:
			vtype = "Color";
			vmastersearchString = "%" + colorName.getText() + "%";
			new gnAdmin().showMasterTable(vtype, colorcode, colorName);
			getAttribute(vtype, nrow, ncol);
			break;
		case 5:
			vtype = "Pattern";
			vmastersearchString = "%" + patternName.getText() + "%";
			new gnAdmin().showMasterTable(vtype, patterncode, patternName);
			getAttribute(vtype, nrow, ncol);
			break;
		/*
		 * case 6: vtype = "Fabric" ; new gnAdmin().showMasterTable(vtype,
		 * fabriccode, fabricName); getAttribute(vtype, nrow, ncol); break; case
		 * 7: vtype = "Fit" ; new gnAdmin().showMasterTable(vtype, fitcode,
		 * fitName); getAttribute(vtype, nrow, ncol); break; case 8: vtype =
		 * "Style" ; new gnAdmin().showMasterTable(vtype, stylecode, styleName);
		 * getAttribute(vtype, nrow, ncol); break;
		 */
		}
	}

	// fashion//
	private void generateVarientName(int nrow, int ncol) {

		// "Del", "Type", "varient Name", "Size" , "Color",
		// "Material", "Pattern", "Fit" , "Style",
		// "Long Name", "Varient Code", "Cost", "MRP",
		// "Sales Price", "Parent Code", "Short Name"};

		String vrntName = "";
		vtable.setValueAt("", nrow, 8);
		vrntName = vtable.getValueAt(nrow, 2) + " " + vtable.getValueAt(nrow, 3) + " " + vtable.getValueAt(nrow, 4)
				+ " " + vtable.getValueAt(nrow, 5);
		vtable.setValueAt(vrntName, nrow, 9);
		String vposName = vtable.getValueAt(nrow, 2).toString();
		if (vposName.length() > 25) {
			vposName = vposName.substring(1, 25);
		}
		vtable.setValueAt(vposName, nrow, 15);
	}

	private void generateVarientNameDropdown() {

		// "Del", "Type", "varient Name", "Size" , "Color",
		// "Material", "Pattern", "Fit" , "Style",
		// "Long Name", "Varient Code", "Cost", "MRP",
		// "Sales Price", "Parent Code", "Short Name"};

		int nrow = vtable.getRowCount();

		if (nrow > 0) {
			for (int i = 0; i < nrow; i++) {
				String vrntName = "";
				vtable.setValueAt("", nrow, 8);
				vrntName = vtable.getValueAt(nrow, 2) + " " + vtable.getValueAt(nrow, 3) + " "
						+ vtable.getValueAt(nrow, 4) + " " + vtable.getValueAt(nrow, 5);
				vtable.setValueAt(vrntName, nrow, 9);
				String vposName = vtable.getValueAt(nrow, 2).toString();
				if (vposName.length() > 25) {
					vposName = vposName.substring(1, 25);
				}
				vtable.setValueAt(vposName, nrow, 16);
			}
		}
	}

	// Grocessary//
	private void process_articleType4() {
		// String status = validate();
		// if (status == "Sucess")
		// {
		String vCol[] = { "Del", "Type", "Child Item Name", "PackSize", "UOM", "PackForm", "Article Class",
				"Packed Type", "Item Name", "Product Code", "Cost", "MRP", "Sales Price", "Tax%", "Parent Code",
				"Short Name" };
		vmodel.setColumnIdentifiers(vCol);
		vmodel.addRow(new Object[] { " ", "Child", " ", "  ", uom.getSelectedItem().toString(),
				a_packform_code.getText(), a_class_code.getText(), a_packtype_code.getText(), " ", " ", cost.getText(),
				mrp.getText(), salesprice.getText(), tax_code.getSelectedItem().toString(), " ", " " });
		vtable.setModel(vmodel);
		vtable.setRowHeight(22);
		new gnTable().setTableBasics(vtable);
		new gnTable().setTableColWidth(vtable, 2, 150);
		new gnTable().setTableColWidth(vtable, 8, 250);
		new General().removeRow(vmodel, vtable);
		DefaultCellEditor nk = new gnTable().cellEdit(vtable);
		nk.addCellEditorListener(ChangeNotification1);
		JViewport prt101 = new JViewport();
		prt101.setBackground(Color.CYAN);
		prt101.add(vtable, vCol);
		prt101.setVisible(true);
		vjsp.setViewport(prt101);
		// }
	}

	private JPanel panel_8;
	private JTextField content;

	// Grocessary
	private void getColumnProcess4(int nrow, int ncol) throws Throwable {
		String vtype = "";
		switch (ncol) {
		case 5: // "PackForm", "UOM", "Article Class", "Packed Type"
			vtype = "Pack_Form";
			vmastersearchString = "%" + a_packform_name.getText() + "%";
			new gnAdmin().showMasterTable(vtype, a_packform_code, a_packform_name);
			getAttribute(vtype, nrow, ncol);
			break;
		case 4:
			vtype = "UOM";
			vmastersearchString = "%" + uom.getSelectedItem().toString() + "%";
			// new gnAdmin().showMasterTable(vtype, uom, uom);
			getAttribute(vtype, nrow, ncol);
			break;
		case 6:
			vtype = "Article_Class";
			vmastersearchString = "%" + a_class_name.getText() + "%";
			new gnAdmin().showMasterTable(vtype, a_class_code, a_class_name);
			getAttribute(vtype, nrow, ncol);
			break;
		case 7:
			vtype = "Pack_Type";
			vmastersearchString = "%" + a_packtype_name.getText() + "%";
			new gnAdmin().showMasterTable(vtype, a_packtype_code, a_packtype_name);
			getAttribute(vtype, nrow, ncol);
			break;
		}
	}

	// fashion//
	private void getAttribute(String vtype, int nrow, int ncol) {
		switch (vtype) {

		case "UOM":
			// new General().msg(sizecode.getText()+ ""+nrow+""+ncol);
			vtable.setValueAt(uom.getSelectedItem().toString(), nrow, ncol);
			sizecode.setText("0");
			sizeName.setText(null);
			generateChildName(nrow, ncol);
			// generateVarshortName(nrow, ncol) ;
			break;

		case "Pack_Type":
			// new General().msg(sizecode.getText()+ ""+nrow+""+ncol);
			vtable.setValueAt(a_packtype_code.getText(), nrow, ncol);
			sizecode.setText("0");
			sizeName.setText(null);
			generateChildName(nrow, ncol);
			// generateVarshortName(nrow, ncol) ;
			break;

		case "Pack_Form":
			// new General().msg(sizecode.getText()+ ""+nrow+""+ncol);
			vtable.setValueAt(a_packform_code.getText(), nrow, ncol);
			sizecode.setText("0");
			sizeName.setText(null);
			generateChildName(nrow, ncol);
			// generateVarshortName(nrow, ncol) ;
			break;
		case "Article_Class":
			// new General().msg(sizecode.getText()+ ""+nrow+""+ncol);
			vtable.setValueAt(a_class_code.getText(), nrow, ncol);
			sizecode.setText("0");
			sizeName.setText(null);
			generateChildName(nrow, ncol);
			// generateVarshortName(nrow, ncol) ;
			break;

		case "Size":
			// new General().msg(sizecode.getText()+ ""+nrow+""+ncol);
			vtable.setValueAt(sizecode.getText(), nrow, ncol);
			sizecode.setText("0");
			sizeName.setText(null);
			generateVarientName(nrow, ncol);
			// generateVarshortName(nrow, ncol) ;
			break;
		case "Color":
			vtable.setValueAt(colorcode.getText(), nrow, ncol);
			colorcode.setText("0");
			colorName.setText(null);
			generateVarientName(nrow, ncol);
			// generateVarshortName(nrow, ncol) ;
			break;
		case "Fabric":
			vtable.setValueAt(fabriccode.getText(), nrow, ncol);
			fabriccode.setText("0");
			fabricName.setText(null);
			generateVarientName(nrow, ncol);
			// generateVarshortName(nrow, ncol) ;
			break;
		case "Pattern":
			vtable.setValueAt(patterncode.getText(), nrow, ncol);
			patterncode.setText("0");
			patternName.setText(null);
			generateVarientName(nrow, ncol);
			// generateVarshortName(nrow, ncol) ;
			break;
		case "Fit":
			vtable.setValueAt(fitcode.getText(), nrow, ncol);
			fitcode.setText("0");
			fitName.setText(null);
			generateVarientName(nrow, ncol);
			// generateVarshortName(nrow, ncol) ;
			break;
		case "Style":
			vtable.setValueAt(stylecode.getText(), nrow, ncol);
			stylecode.setText("0");
			styleName.setText(null);
			generateVarientName(nrow, ncol);
			// generateVarshortName(nrow, ncol) ;
			break;
		}
	}

	// Bulk child //
	private void generateChildName(int nrow, int ncol) {

		// "Del", "Type", "varient Name", "Size" , "Color",
		// "Fabric", "Pattern", "Fit" , "Style",
		// "Long Name", "Varient Code", "Cost", "MRP",
		// "Sales Price", "Parent Code", "Short Name"};

		String vrntName = "";
		vtable.setValueAt("", nrow, 8);
		vrntName = vtable.getValueAt(nrow, 2) + " " + vtable.getValueAt(nrow, 3) + " " + vtable.getValueAt(nrow, 4)
				+ " " + vtable.getValueAt(nrow, 5) + " " + vtable.getValueAt(nrow, 6) + " " + vtable.getValueAt(nrow, 7)
				+ " " + vtable.getValueAt(nrow, 8);
		vtable.setValueAt(vrntName, nrow, 8);
		String vposName = vtable.getValueAt(nrow, 2).toString();
		if (vposName.length() > 25) {
			vposName = vposName.substring(1, 25);
		}
		vtable.setValueAt(vposName, nrow, 15);
	}

	public void generateArticleCode() throws Throwable {
		String vtype = "MS";
		String vtran = "906";
		articleCode.setText(new gnSeq().getSeqno(vtran, vtype));
		new General().Quickmsg("Article code is " + articleCode.getText());
	}

	class eanLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			boolean vcheck = checkean.isSelected();
			if (vcheck) {
				eanarticle = "Y";
				eancode.setEnabled(true);
				new General().msg("Enter EAN code ..");
			} else {
				eanarticle = "N";
				eancode.setEnabled(false);
				eancode.setText("0");
			}
		}
	}

	class costLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// baseprice.setText(new gnMath().get_exclCost(cost.getText(),
			// tax_per.getText()));
			boolean vmrp1 = chkMrpArticle.isSelected();
			if (vmrp1 == false) {
				salesprice.setText(new gnMath().get_markupSP(cost.getText(), markup_per.getText()));
				mrp.setText(new gnMath().get_markupSP(cost.getText(), markup_per.getText()));
				// basemrp.setText(new gnMath().get_exclMrp(mrp.getText() ,
				// tax_per.getText()));
			}
		}
	}

	class mrpLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			boolean vmrp1 = chkMrpArticle.isSelected();
			if (vmrp1 == true) {
				salesprice.setText(new gnMath().get_markdownSP(mrp.getText(), markdown_per.getText()));
				// basemrp.setText(new gnMath().get_exclMrp(mrp.getText() ,
				// tax_per.getText()));
			}
		}
	}

	class mrpbase implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			boolean vmrp1 = chkMrpArticle.isSelected();
			if (vmrp1 == true) {
				markup_per.setEnabled(false);
				markdown_per.setEnabled(true);
			}
			if (vmrp1 == false) {
				markup_per.setEnabled(true);
				markdown_per.setEnabled(false);
			}

		}
	}

	class createLike implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String vposname = name.getText();
			vposname = "%" + vposname + "%";
			String Col5[] = { "type", "article_code", "Name", "UOM", "MRPBaseArticle", "Trading_Article", "Verticle",
					"Verticle_name", "Article_SubGroup", "Name" };
			String Col555[] = { "type", "article_code", "Name", "UOM" };

			String vcomp = "";
			try {
				vcomp = companycode.getText();
				String SQL = "Call  Article_getCreateLike('" + vposname + "', " + vcomp + ")";
				// new General().msg(SQL);
				showArticleTable(SQL, Col555);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
			try {
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	public void showArticleTable(String SQL, String[] Colnames9) throws Throwable {
		// new General().msg(SQL);
		String vtype = "Article";
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(Colnames9);
		table = new gnTableModel().Tablemodel(table, model, SQL, Colnames9, 3, "N", "Y", vtype);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification9);
		new General().msgsearch(sjsp, table, "Select Article  Code", 1000, 400);
		new gnTable().setTableColWidth(table, 7, 400);
		new gnTable().setTableColWidth(table, 9, 400);
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
		name.setText(name.getText().toUpperCase());
		String vname = (name.getText().trim());
		// new General().msg(vname);
		String vaction = new General().checkLength(vname, 29);
		if (vaction == "Pass") {
			shortname.setText(vname);
			shortname.setText(shortname.getText().toUpperCase());

		}

		else {
			shortname.setText(vname.substring(1, 29));
			new General().msg("Correct Short Name to 29 char");
			shortname.grabFocus();
		}
		return action;

	}

	private String subStr(String vshortname, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	class BtnLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id

			if (value == "Add Ean Code") {
				// super.vmyarticlecode = articleCode.getText() ;
				BarcodeMapping window = new BarcodeMapping();
				window.frameBarcodeMapping.setVisible(true);
			}

			if (value == "Other Masters") {
				try {
					CreateGeneralMaster window = new CreateGeneralMaster();
					window.masterFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Convert Prices") {
				converttoBoxPrice();
			}

			if (value == "Tax Slab") {
				try {
					TaxSlabMaster window;
					window = new TaxSlabMaster();
					window.taxSlabFrame.setVisible(true);
					window.show();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Update Brand/Hie.") {
				try {
					Article_AttriHie_Assignment window;
					window = new Article_AttriHie_Assignment();
					window.ArticleAttrHieFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Hierarchy") {
				try {
					hie_Assignment window;
					window = new hie_Assignment();
					window.hie_Assignment_frame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Save") {
				try {
					
 					setbrand();
					String status = validate();
					if (status == "Sucess") {
						String varticleType = a_type_code.getText();
						switch (varticleType) {
						case "1":
							prepareToInsert();
							break;
						case "2":
							prepareToInsert();
							break;

						case "3":
							prepareToInsert();
							break;
						case "4":
							prepareToInsert();
							break;
						case "5":
							prepareToInsert();
							break;
						case "6":
							prepareToInsert();
							break;
						case "7":
							prepareToInsert();
							break;
						case "8":
							prepareToInsert();
							break;

						case "9":
							prepareToInsert();
							break;

						case "10":
							prepareToInsert();
							break;

						case "11":
							prepareToInsert();
							break;

						}
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	private void converttoBoxPrice() {
		String vinnerQty = innerpackqty.getText();

		String vpurUomCOST = cost.getText();
		String vpurUomMRP = mrp.getText();
		String vpurUomSP = salesprice.getText();
		new gnUomPriceConvert().getBoxPrices(vinnerQty, vpurUomCOST, vpurUomMRP, vpurUomSP);

		Puom_cost.setText(new gnUomPriceConvert().vunitcost);
		Puom_mrp.setText(new gnUomPriceConvert().vunitmrp);
		Puom_sp.setText(new gnUomPriceConvert().vunitsp);
	}

	public void setautoname(String vtext) {
		autoname.setText(null);
		vautoname = autoname.getText() + " " + vtext;
		autoname.setText(vautoname);
	}

	private void getFieldValue() {
		Rvsegmentcode = segmentcode.getText().trim();
		Rverticlecode = verticlecode.getText().trim();
		Rhno = Hierarchyno.getText().trim();
	}

	class ArticleParent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				String vtext = parentname.getText();
				vtext = "%" + vtext + "%";
				new gnAdmin().showParent(vtext, parentcode, parentname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				new General().msgDispose();
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
				// vmastersearchString = "%" + tax_code.getText() + "%";
				// new gnAdmin().showMasterTable(vtype, tax_code, tax_per);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class ArticlePattern implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String vtype = "Pattern";
			try {
				vmastersearchString = "%" + patternName.getText() + "%";
				new gnAdmin().showMasterTable(vtype, patterncode, patternName);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class ArticleStyle implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String vtype = "Style";
			try {
				vmastersearchString = "%" + styleName.getText() + "%";
				new gnAdmin().showMasterTable(vtype, stylecode, styleName);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class ArticleFabric implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String vtype = "Fabric";
			try {
				vmastersearchString = "%" + fabricName.getText() + "%";
				new gnAdmin().showMasterTable(vtype, fabriccode, fabricName);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
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
				vmastersearchString = "%" + colorName.getText() + "%";
				new gnAdmin().showMasterTable(vtype, colorcode, colorName);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class ArticleFit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String vtype = "Fit";
			try {
				vmastersearchString = "%" + fitName.getText() + "%";
				new gnAdmin().showMasterTable(vtype, fitcode, fitName);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class ArticleSize implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String vtype = "Size";
			try {
				vmastersearchString = "%" + sizeName.getText() + "%";
				new gnAdmin().showMasterTable(vtype, sizecode, sizeName);
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
				// vmastersearchString = "%" + uom.getText() + "%";
				// new gnAdmin().showMasterTable(vtype, uom, uom);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class PurchaseUom implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			innerpackqty.setEnabled(true);
			innerpackqty.setEditable(true);
			try {
				vpuruom = combopurqty.getSelectedItem().toString().trim();
				switch (vpuruom) {
				case "NO":
					innerpackqty.setText("1");
					innerpackqty.setEditable(false);
					break;
				}
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class ArticleClass implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String vtype = "Article_Class";
			try {
				vmastersearchString = "%" + a_class_name.getText() + "%";
				new gnAdmin().showMasterTable(vtype, a_class_code, a_class_name);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	class packType implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String vtype = "Pack_Type";
			try {
				vmastersearchString = "%" + a_packtype_name.getText() + "%";
				new gnAdmin().showMasterTable(vtype, a_packtype_code, a_packtype_name);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}

		}
	}

	class packForm implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String vtype = "Pack_Form";
			try {
				vmastersearchString = "%" + a_packform_name.getText() + "%";
				new gnAdmin().showMasterTable(vtype, a_packform_code, a_packform_name);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}
	/// End Listeners

	class brandname implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String sname = brandname.getText();
			sname = "%" + sname + "%";
			try {
				// new gnBrand().getBrandInfo(sname);
				// String vtype = "Brand";
				// vmastersearchString = "%" + brandname.getText() + "%";
				// new General().msg(vmastersearchString);
				// new gnAdmin().showMasterTable(vtype, brandcode, brandname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
			}

		}

	}

	class ArticleManuf implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String vtype = "%%";
			try {
				showManufTable(vtype);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void showManufTable(String Name) throws Throwable {
		new gnTable().RemoveTableRows(model);
		String vsegment = segmentcode.getText();
		String vverticle = verticlecode.getText();
		String Col[] = { " Type ", "ManufCode ", "Name", "Verticle Code", "Verticle NameMarkdown" };
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = " call   ms_getManuf('" + Name + "' , '" + vsegment + "' , " + vverticle + " , " + vcomp + ")";
		// new General().msg(SQL);
		model.setColumnIdentifiers(Col);
		String vtype = "Manufacturer";
		table = new gnTableModel().Tablemodel4(table, model, SQL, Col, 4, "N", "Y", vtype);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification9);
		new General().msgsearch(sjsp, table, "Select Brand Information  ", 650, 500);
	}

	class ArticleBrand implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			// System.out.println("Value" +value) ;
			// System.out.println("Field id"+i);
			String vtype = manufcode.getText();
			try {
				showBrandTable(vtype);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void showBrandTable(String Name) throws Throwable {
		new gnTable().RemoveTableRows(model);
		String Col[] = { " Type ", "BrandCode ", "Name", "Markup", "Markdown", "Discount%", "Manuf_Code", "Verticle",
				"Verticle Name" };
		String vverticle = verticlecode.getText();
		String SQL = " call   ms_getBrandReferenceManuf('" + Name + "'  ," + vverticle + ")";
		model.setColumnIdentifiers(Col);
		String vtype = "Brand";
		table = new gnTableModel().Tablemodel8(table, model, SQL, Col, 8, "N", "Y", vtype);
		new gnTable().setTableColWidth(table, 2, 200);
		DefaultCellEditor nk = new gnTable().cellEdit(table);
		nk.addCellEditorListener(ChangeNotification9);
		new General().msgsearch(sjsp, table, "Select Brand Information  ", 900, 500);

	}

	public void showTable(String SQL, String[] Colnames) throws Throwable {
		String vtype = "Tax";
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(Colnames);
		table = new gnTableModel().Tablemodel2(table, model, SQL, Colnames, 2, "N", "Y", vtype);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification9);
		new General().msgsearch(sjsp, table, "Select Tax  Code", 400, 400);
	}

	/*
	 * public void showParent(String vsearchname) throws Throwable { new
	 * gnTable().RemoveTableRows(model) ; getFieldValue(); vcomp = new
	 * gnConfig().getCompanyCode(); String SQL = "call Bulk_GetAllBulkCode('"
	 * +vsearchname+"' , "+vcomp+"  )" ; String Col[] = {"Type" ,"Article_code"
	 * , "Name" , "Uom" , "Trading_article" , "cost" , "SalesPrice" ,
	 * "Article_type" , } ; new gnTable().RemoveTableRows(model) ;
	 * model.setColumnIdentifiers(Col); String vtype = "Parent code" ; table =
	 * new gnTableModel().Tablemodel(table, model, SQL, Col, 7, "N", "Y", vtype)
	 * ; table.getDefaultEditor(String.class).addCellEditorListener(
	 * ChangeNotification9); if (table.getRowCount() > 0) { new
	 * gnTable().setTablewidth(table,2,250); new
	 * gnTable().setTablewidth(table,4,250); new
	 * gnTable().setTablewidth(table,6,250); //new
	 * gnTable().setTablewidth(table,8,250); } new General().msgsearch(sjsp,
	 * table, "Select Para/nt Code ", 400,400 ); }
	 */

	public CellEditorListener ChangeNotification9 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
		}

		public void editingStopped(ChangeEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 0);
			try {
				// rs.close();
				displayInfo(value, row);
				table.addNotify();
			} catch (Exception e1) {
				new General().msg(e1.getLocalizedMessage());
				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	};
	private JLabel lblNewLabel_26;
	private JTextField shortkey;

	
	class ArticleHierarchy implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			try {
				String vtext = hierarchyname.getText();
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
				hierarchycode.setText(new gnHierarchy().vArticle_subcategory);
				hierarchyname.setText(new gnHierarchy().vArticle_subCatname);
				String vsubgroupcode = hierarchycode.getText();
				new gnHierarchy().getSubcatLevels(vsubgroupcode);
 				vArticle_category = new gnHierarchy().vArticle_category;
				vArticle_subcategory = new gnHierarchy().vArticle_subcategory;
				vArticle_group = new gnHierarchy().vArticle_group;
				vArticle_subGroup = new gnHierarchy().vArticle_subGroup;

				dsubcatcode.setText(new gnHierarchy().vArticle_subcategory);
				dsubcatname.setText(new gnHierarchy().vArticle_subCatname);
 				dcatcode.setText(vArticle_category);
				dgroupcode.setText(vArticle_group);
				dsubgroupcode.setText(vArticle_subGroup);
 				String vtype = "CatName";
				dcatname.setText(new gnHierarchy().getNameofgivenCode(vtype, dcatcode.getText()));
 				vtype = "GroupName";
				dgroupname.setText(new gnHierarchy().getNameofgivenCode(vtype, dgroupcode.getText()));
 				vtype = "SubGroupName";
				dsubgroupname.setText(new gnHierarchy().getNameofgivenCode(vtype, dsubgroupcode.getText()));
			}
		}
	}

	private void setRefArticle(String vrefArticle, String vverticle) throws Throwable {// nitin
		String vcomp = companycode.getText();
		String SQL = "call Article_RefrencecreateArticle(" + vrefArticle + ", " + vcomp + ")";
		new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {

			name.setText(rs.getString(2));
			new General().msg(rs.getString(2));

			shortname.setText(rs.getString(3));
			new General().msg(rs.getString(3));

			pksize.setText(rs.getString(4));
			uom.setSelectedItem(rs.getString(5));
			tax_code.setSelectedItem(rs.getString(6));
			manufcode.setText(rs.getString(8));
			manufname.setText(rs.getString(9));
			brandcode.setText(rs.getString(10));
			brandname.setText(rs.getString(11));
			String vmrpbase = (rs.getString(12));
			switch (vmrpbase) {
			case "Y":
				chkMrpArticle.setSelected(true);
				break;
			case "N":
				chkMrpArticle.setSelected(false);
			}
			String vsalesarticle = (rs.getString(13));
			switch (vsalesarticle) {
			case "Y":
				chkTradingArticle.setSelected(true);
				break;
			case "N":
				chkTradingArticle.setSelected(false);
			}
			String vbatch = (rs.getString(14));
			switch (vbatch) {
			case "Y":
				chkBatchControl.setSelected(true);
				break;
			case "N":
				chkBatchControl.setSelected(false);
			}
			markup_per.setText(rs.getString(15));
			markdown_per.setText(rs.getString(16));
			a_type_code.setText(rs.getString(17));
			a_class_code.setText(rs.getString(18));
			vArticle_category = rs.getString(19);
			vArticle_subcategory = rs.getString(20);
			vArticle_group = rs.getString(21);
			hierarchycode.setText(rs.getString(22));
			a_packform_code.setText(rs.getString(23));
			a_packtype_code.setText(rs.getString(24));
			hierarchyname.setText(rs.getString(25));
		}
	}

	private void displayInfo(String value, int row) throws Throwable {
		switch (value) {
		case "Article":
			String vrefArticle = (table.getValueAt(row, 1).toString());
			String vverticle = (table.getValueAt(row, 6).toString());
			setRefArticle(vrefArticle, vverticle);
			new General().msgDispose();
			break;
		case "Parent code":
			parentcode.setText(table.getValueAt(row, 1).toString());
			parentname.setText(table.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Manufacturer":
			manufcode.setText(table.getValueAt(row, 1).toString());
			manufname.setText(table.getValueAt(row, 2).toString());
			new General().msgDispose();

			break;
		case "Brand":
			brandcode.setText(table.getValueAt(row, 1).toString());
			brandname.setText(table.getValueAt(row, 2).toString());
			markup_per.setText(table.getValueAt(row, 3).toString());
			markdown_per.setText(table.getValueAt(row, 4).toString());
			discount.setText(table.getValueAt(row, 5).toString());
			markdown_per.setBackground(Color.CYAN);
			markup_per.setBackground(Color.CYAN);
			discount.setBackground(Color.CYAN);
			markdown_per.setForeground(Color.BLUE);
			markup_per.setForeground(Color.BLUE);
			discount.setForeground(Color.BLUE);
			new gnImageSound().playAlertSound();
			;
			new General().msg("Check Markdown / Markup & Disocunt  if you wnat to Change Please Change ..");
			new General().msgDispose();
			break;
		case "Uom":
			uom.setSelectedItem(table.getValueAt(row, 1).toString());
			new General().msgDispose();
			break;
		case "Hierarchy":
			hierarchycode.setText(table.getValueAt(row, 1).toString());
			hierarchyname.setText(table.getValueAt(row, 2).toString());
			vArticle_category = (table.getValueAt(row, 7).toString());
			vArticle_subcategory = (table.getValueAt(row, 5).toString());
			vArticle_group = (table.getValueAt(row, 3).toString());
			vArticle_subGroup = (table.getValueAt(row, 1).toString());
			if (vArticle_category.length() == 0) {
				vArticle_category = "0";
			}
			if (vArticle_subcategory.length() == 0) {
				vArticle_subcategory = "0";
			}
			if (vArticle_group.length() == 0) {
				vArticle_group = "0";
			}
			vArticle_subGroup = (table.getValueAt(row, 1).toString());
			new General().msgDispose();
			break;
		case "Size":
			sizecode.setText(table.getValueAt(row, 1).toString());
			sizeName.setText(table.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Color":
			colorcode.setText(table.getValueAt(row, 1).toString());
			colorName.setText(table.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Fit":
			fitcode.setText(table.getValueAt(row, 1).toString());
			fitName.setText(table.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Fabric":
			fabriccode.setText(table.getValueAt(row, 1).toString());
			fabricName.setText(table.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Style":
			stylecode.setText(table.getValueAt(row, 1).toString());
			styleName.setText(table.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Pattern":
			patterncode.setText(table.getValueAt(row, 1).toString());
			patternName.setText(table.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Pack_Type":
			a_packtype_code.setText(table.getValueAt(row, 1).toString());
			a_packtype_name.setText(table.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Pack_Form":
			a_packform_code.setText(table.getValueAt(row, 1).toString());
			a_packform_name.setText(table.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Article_Class":
			a_class_code.setText(table.getValueAt(row, 1).toString());
			a_class_name.setText(table.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		// Fashion//
		case "Tax":
			tax_code.setSelectedItem(table.getValueAt(row, 1).toString());
			new General().msgDispose();
		}
	}

	private String validate() {// nk
		String status = "Sucess";
		
		switch(verticlecode.getText())
		{
 		    case "3" :
 		        mrp.setText(salesprice.getText());
  		    	description.setText(shortkey.getText()) ;
		    if(description.getText().length()== 0 )
		    {
		    	new General().msg("Enter Shortcut Key...");
		    	shortkey.grabFocus();
		    	status= "Fail" ;		
 		    }
		    break;
			case "9" :
		    mrp.setText(salesprice.getText());
 		    break ; 
			case "11" :
 			mrp.setText(salesprice.getText());
			break ; 
		}

		int vname = new gnComp().getLength(name);
		if (vname > 60) {
			new General().msg("Name Lenght is Limit max char Allow is 50 char .. Check Name");
			status = "Fail";
			name.grabFocus();
		}

		int vShortname = new gnComp().getLength(shortname);
		if (vShortname > 28) {
			new General().msg("POS Name Can Not More then 15 Chars  .. Check Short Name");
			status = "Fail";
			shortname.grabFocus();
		}

		String action = new General().getLength(name, "Enter Name");
		if (action == "Fail") {
			name.grabFocus();
			status = "Fail";
		}

		String action1 = new General().getLength(shortname, "Enter Short Name");
		if (action1 == "Fail") {
			shortname.grabFocus();
			status = "Fail";
		}

		if (pksize.getText().length() == 0) {
			status = "Fail";
			new General().msg("Please Enter Pack Size If UOM is NO then Enter 1");
			pksize.grabFocus();
			pksize.setBackground(Color.yellow);
		}

		if (uom.getSelectedItem().toString().trim().length() == 0) {
			status = "Fail";
			new General().msg("Please Select UOM ");
			uom.grabFocus();
			uom.setBackground(Color.yellow);
		}

		if (tax_code.getSelectedItem().toString().trim().length() == 0) {
			status = "Fail";
			new General().msg("Please Select Tax Code ");
			tax_code.grabFocus();
			tax_code.setBackground(Color.yellow);

		}

		// String action2 = new General().getLength(brandname , "Select Brand
		// Inforamtion");
		// if (action2 == "Fail")
		// {
		// brandcode.grabFocus();
		// status = "Fail" ;
		// }

		// String action3= new General().getLength(hierarchyname , "Select
		// Hiearchy Inforamtion");
		// if (action3 == "Fail")
		// {
		// hierarchycode.grabFocus();
		// status = "Fail" ;
		// }

		double vcost = 0.00;
		double vmrp = 0.00;
		double vsp = 0.00;

		double vpuomcost = 0.00;
		double vpuommrp = 0.00;
		double vpuomsp = 0.00;
		double vmbq = 0.00;
		double vrolevel = 0.00;
		double vvminshelflife = 0.00;
		double vvmaxshelflife = 0.00;

		try {
			vcost = Double.parseDouble(cost.getText());
			vmrp = Double.parseDouble(mrp.getText());
			vsp = Double.parseDouble(salesprice.getText());
			vpuomcost = Double.parseDouble(Puom_cost.getText());
			vpuommrp = Double.parseDouble(Puom_mrp.getText());
			vpuomsp = Double.parseDouble(Puom_sp.getText());

			vvminshelflife = Double.parseDouble(minshelflife.getText());
			vvmaxshelflife = Double.parseDouble(maxshelflife.getText());
			vmbq = Double.parseDouble(mbq.getText());
			vrolevel = Double.parseDouble(rolevel.getText());

		} catch (Exception e) {
			new General()
					.msg("Please Enter Correct Value in Numbers..<Cost/Mrp/SalesPrice/mbq/shelfLife/Reorder Level");
			status = "Fail";
		}

		if (vmrp <= 0.00) {
			new General().msg("Enter MRP ");
			mrp.grabFocus();
			status = "Fail";
		}

		if (vsp <= 0.00) {
			new General().msg("Enter Sales Price ");
			salesprice.grabFocus();
			status = "Fail";
		}

		if (vcost <= 0.00) {
			new General().msg("Enter Purchase Cost ");
			cost.grabFocus();
			status = "Fail";
		}

		String vpuruom = combopurqty.getSelectedItem().toString();
		int vinnerQty = Integer.parseInt(innerpackqty.getText());

		if ((vpuruom == "Stripe" || vpuruom == "Box") && vinnerQty <= 1) {
			new General().msg("Enter Corredct Inner Qty ");
			innerpackqty.grabFocus();
			status = "Fail";
		}

		if (vpuruom == "NO" && vinnerQty > 1) {
			innerpackqty.setText("1");
		}
		return status;
	}

	public void prepareToInsert() throws Throwable {

		new gnDecorate().setBusyCursor(topleft);
		stime.setText(new General().getTime());
		ucode = this.ucode;
		generateArticleCode();
		vautoname = brandname.getText() + " " + hierarchyname.getText() + " " + pksize.getText()
				+ uom.getSelectedItem().toString() + a_packform_name.getText();
		setautoname(vautoname);
		vcomp = companycode.getText();
		vhierarchyno = Hierarchyno.getText();
		vsegment = segmentcode.getText();
		vverticle = verticlecode.getText();
		vdescription = description.getText();
		if (vdescription.length() == 0) {
			vdescription = "";
		}
		String vstore = new gnConfig().getStoreID();
		vcontent = content.getText();
		varticlecode = articleCode.getText();
		this.varticlecode = articleCode.getText();
		vitemcode = articleCode.getText();
		vname = name.getText();
		this.varticlename = vname;
		vposname = shortname.getText();

		boolean vch = applytaxslab.isSelected();
		if (vch) {
			vapplytaxslab = "Y";
		}

		vautoname = autoname.getText();
		vean = eancode.getText();
		int intean = Integer.parseInt(eancode.getText().trim());
		// new General().msg("Ean code int is"+" "+intean);
		if (intean > 0) {
			String result = new gnApp().checkEancode(varticlecode, vean);
			if (result == "Fail") {
				return;
			}
		}
		vsupplier = supplier_code.getText();
		vlocation = defualtLocation.getText();
		vsalesUom = uom.getSelectedItem().toString().trim();
		vpacksize = pksize.getText();

		// nitinjul Apply DropDown

		vuom = uom.getSelectedItem().toString().trim();
		vtaxcode = tax_code.getSelectedItem().toString().trim();
		vtaxper = tax_code.getSelectedItem().toString().trim();
		vbrand = brandcode.getText();
		varticleType = a_type_code.getText();
		varticleClass = a_class_code.getText();
		vshelfcode = shelfcode.getText();
		vmanuf = manufcode.getText();
		vpackform = combopurqty.getSelectedItem().toString();
		vpacktype = a_packtype_code.getText();

		vcost = cost.getText();
		VLC = new gnMath().getLandingCost(vcost, vtaxcode);
		vmrp = mrp.getText();
		vsalesprice = salesprice.getText();
		vmarkdown = markdown_per.getText();
		vmarkup = markup_per.getText();
		vmargin = salesmargin_per.getText();

		// This Portion for Puchase UOM Master Filed is pdated by Same Column is
		// Pack_FOM . PurUOm and SalesUOM
		vpuruom = vpackform;
		vsaleUOM = vpackform;
		// End Here

		vparentcode = parentcode.getText();
		vprocessloss = processloss.getText();
		vactive = "Y";

		vinnerpacksize = "0";
		vinnerpackqty = innerpackqty.getText();

		vfit = fitcode.getText();
		vcolor = colorcode.getText();
		vsize = sizecode.getText();
		vstyle = stylecode.getText();
		vpattern = patterncode.getText();
		vfabric = fabriccode.getText();
		vorderin = combopurqty.getSelectedItem().toString();
		vdate = "2016.10.20";

		boolean vbatch = chkBatchControl.isSelected();
		vmaxshelflife = maxshelflife.getText();
		vminshelflife = minshelflife.getText();
		boolean vtra = chkTradingArticle.isSelected();
		boolean vmrp1 = chkMrpArticle.isSelected();
		boolean vmntInventory = checkMntInventory.isSelected();
		if (vmntInventory) {
			vmntInv = "Y";
		} else {
			vmntInv = "N";
		}

		if (vmrp1) {
			vmrpbase = "Y";
		} else {
			vmrpbase = "N";
		}

		if (vtra) {
			vtradingarticle = "Y";
		} else {
			vtradingarticle = "N";
		}
		if (vbatch) {
			vbatchcontrol = "Y";
		} else {
			vbatchcontrol = "N";
		}

		if (intean > 1) { // new General().msg("Ready to insert Data .
							// "+intean);
							// insertEanArticle() ; // Insert Ean code
		}

		String vtype = "NewArticle";
		String vqty = "0.00";
		String vcompcode = new gnConfig().getCompanyCode();

		if (vcompcode != "0") {
			// new General().Quickmsg("Setting Sales Price For Your Other
			// Stores") ;
			String sql = "call sales_EnterSalesPriceforStores(" + vcompcode + ")";
			rs = this.getSPResult(sql);
			while (rs.next()) {
				vstore = rs.getString(1);
				// String vbatch1 = new
				// gnComp().getCheckBoxValue(chkBatchControl) ;
				String vinvtype = "0";
				new ApplySalesPrice_Action().SalesPriceInsert(vstore, varticlecode, vdate, vmrp, vsalesprice, vcost,
						vcompcode, vverticle, VLC);
			}
		} // sucess

		// vArticle_category = "0" ; //new gnHierarchy().vArticle_category ;
		// vArticle_subcategory = "0" ; //new
		// gnHierarchy().vArticle_subcategory;
		// vArticle_group = "0" ; //new gnHierarchy().vArticle_group ;
		// vArticle_subGroup = "0" ;//new gnHierarchy().vArticle_subGroup ;
		String itemInsert = insertArtcle();

		// String statusEan = insertEanCode();
	}

	/*
	 * ///Ean Insert public void insertEanArticle() throws Exception { prst =
	 * null ; String status = " "; final int batchSize = 10; int
	 * TotalRecordinsert =0; Connection con = this.getConnection();
	 * con.setAutoCommit(false) ; String grndetail =
	 * "Insert into   ms_ean_master(Article_code , " +
	 * "Ean_code, Active,  salesPrice , mrp ,   cost )" + "values(?,?,?,?,?,?)"
	 * ; try { // new General().msg(
	 * " Inside Entry Model Ean code inserting to table" + " "+ vean); prst =
	 * con.prepareStatement(grndetail); prst.setString(1, varticlecode) ;
	 * prst.setString(2,vean); prst.setString(3, "Y" ) ; prst.setString(4,
	 * vsalesprice); prst.setString(5, vmrp); prst.setString(6, vcost);
	 * prst.addBatch(); TotalRecordinsert = TotalRecordinsert +1 ; status =
	 * "Sucess" ; if(++TotalRecordinsert% batchSize == 0) { prst.executeBatch();
	 * status = "Sucess" ; con.commit(); } prst.executeBatch(); // insert
	 * remaining records con.commit(); } catch (SQLException e) { new
	 * General().msg(e.getMessage()); con.rollback(); status = "Fail" ; }
	 * finally { if (prst != null) { prst.close(); } if (con != null) {
	 * con.close(); } } } //Ean Insert End
	 */

	/// Ean Insert for article create at the time.
	public String insertEanCode() throws Exception {
		prst = null;
		String status = "Fail";
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		this.closeconn();
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String grndetail = "Insert into   ms_ean_master(Article_code , "
				+ "Ean_code, Active,  salesPrice , mrp ,  cost )" + "values(?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(grndetail);
			prst.setString(1, varticlecode);
			prst.setString(2, varticlecode);
			prst.setString(3, "Y");
			prst.setString(4, vsalesprice);
			prst.setString(5, vmrp);
			prst.setString(6, vcost);
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				con.commit();
				status = "Sucess";
			}
			prst.executeBatch(); // insert remaining records
			con.commit();
			status = "Sucess";
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
			}
		}
		return status;
	}
	// Ean Insert End

	public String insertArtcle() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		// this.closeconn();
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String hie = "INSERT INTO  msarticle_master ( Company_code , Article_code ,Item_code ,"
				+ " Name ,POS_NAME ,Auto_Generate_Name ," + " UOM ,DefaultEAN ,DefaultVendor ,"
				+ "DefaultLocation , SalesUOM ,Article_Type ," + "Article_Class ,Trading_Article ,MRPBaseArticle ,"
				+ "Article_category ,Article_subCategory ,Article_Group ," + "Article_SubGroup ,Tax_code ,Tax_Per ,"
				+ "Manuf ,Brand ,Markup ," + "MarkDown ,Margin ,MRP ," + "cost ,SalesPrice,Pack_Type ,"
				+ "PackSiZe , Pack_Form ,Active ," + "ParentArticle ,ProcessLoss_per ,Inner_Pack_size ,"
				+ "Inner_Pack_qty ,Color ,Size ," + "Fit ,Fabric ,Style ,"
				+ "Pattern ,Batch_control_Article ,Max_ShelfLife ,"
				+ "Min_shelfLife , ShelfLife_In_days_Month ,Verticle ,"
				+ "CreatedBy ,CreateDate ,segment ,hierarchyno ," + " basecost, basemrp, basesp, srno, mbq, "
				+ "rolevel, ean_article, content, hsncode, drugType , " + "content_code, PurchaseUOM, "
				+ "MaintainInventory, brandname, subCatname , ApplyTaxSlab, Description , shelf , LC)"
				+ "values(?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(hie);
			prst.setString(1, vcomp);
			prst.setString(2, varticlecode);
			prst.setString(3, (varticlecode));
			prst.setString(4, vname);
			prst.setString(5, vposname);
			prst.setString(6, vautoname);
			prst.setString(7, vuom);
			prst.setString(8, vean);
			prst.setString(9, vsupplier);
			prst.setString(10, vlocation);
			prst.setString(11, vpuruom);
			prst.setString(12, varticleType);
			prst.setString(13, varticleClass);
			prst.setString(14, vtradingarticle);
			prst.setString(15, vmrpbase);
			prst.setString(16, vArticle_category);
			prst.setString(17, vArticle_subcategory);
			prst.setString(18, vArticle_group);
			prst.setString(19, vArticle_subGroup);
			prst.setString(20, vtaxcode);
			prst.setString(21, vtaxper);
			prst.setString(22, vmanuf);
			prst.setString(23, vbrand);
			prst.setString(24, vmarkup);
			prst.setString(25, vmarkdown);
			prst.setString(26, vmargin);
			prst.setString(27, vmrp);
			prst.setString(28, vcost);
			prst.setString(29, vsalesprice);
			prst.setString(30, vpacktype);
			prst.setString(31, vpacksize);
			prst.setString(32, vpackform);
			prst.setString(33, vactive);
			prst.setString(34, vparentcode);
			prst.setString(35, vprocessloss);
			prst.setString(36, vinnerpacksize);
			prst.setString(37, vinnerpackqty);
			prst.setString(38, vcolor);
			prst.setString(39, vsize);
			prst.setString(40, vfit);
			prst.setString(41, vfabric);
			prst.setString(42, vstyle);
			prst.setString(43, vpattern);
			prst.setString(44, vbatchcontrol);
			prst.setString(45, vmaxshelflife);
			prst.setString(46, vminshelflife);
			prst.setString(47, "D");
			prst.setString(48, vverticle);
			prst.setString(49, ucode);
			prst.setString(50, vdate);
			prst.setString(51, vsegment);
			prst.setString(52, vhierarchyno);
			prst.setString(53, Puom_cost.getText());
			prst.setString(54, Puom_mrp.getText());
			prst.setString(55, Puom_sp.getText());
			prst.setString(56, "1");
			prst.setString(57, mbq.getText());
			prst.setString(58, rolevel.getText());
			prst.setString(59, eanarticle);
			prst.setString(60, vcontent);
			prst.setString(61, hsncode.getText().trim());
			prst.setString(62, drugCode.getText());
			prst.setString(63, content_code.getText());
			prst.setString(64, vpuruom);
			prst.setString(65, vmntInv);
			prst.setString(66, brandname.getText());
			prst.setString(67, hierarchyname.getText());
			prst.setString(68, vapplytaxslab);
			prst.setString(69, vdescription);
			prst.setString(70, vshelfcode);
			prst.setString(71, VLC);
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con.commit();
			}
			prst.executeBatch();
			con.commit();
			if (vtable.getRowCount() == 0) {
				new General().Quickmsg("Data Saved Sucessfully");
				new gnSeq().updateSeqno("906", "MS");
				createRelationbetweenPArenetandChild();
				setDefaultValue();
			} else {
				// new gnSeq().updateSeqno("906", "MS");
			}
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
				// Sync Ean Master Table
				String SQL55 = "call  EAN_InsertEan(" + vcomp + ")";
				this.getSPResult(SQL55);
				btnSaveVarient.doClick();
				// ArticleDiscGroup();
			}
		}
		return status;
	}

	// Bulk ==> child Article //

	private void createRelationbetweenPArenetandChild() {
		String varticleType1 = a_type_code.getText();
		String SQL = "";
		switch (varticleType1) {
		case "5":
			SQL = "call  Article_ParentRelation(" + vcomp + " , " + varticlecode + ") ";
			try {
				this.getSPResult(SQL);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	private void varientToInsert4() throws Exception { // NKK
		int vsrno = 101;
		String varientno = "";
		int row = vtable.getRowCount();
		String vtype = "MS";
		String vtran = "906";
		for (int i = 0; i < row; i++) {
			try {
				vtable.setValueAt(varticlecode, i, 14);
				String vvsrno = Integer.toString(vsrno);
				varientno = new gnSeq().getSeqno(vtran, vtype);
				vtable.setValueAt(varientno, i, 9);
				new gnSeq().updateSeqno(vtran, vtype);
				vsrno++;
			} catch (Throwable e) {
				e.printStackTrace();
				new General().msg("Child Code Generation.." + e.getLocalizedMessage());
			}
		}
	}

	// fashion//
	private void varientToInsert2() throws Exception {
		// String vCol[] = { "Del", "Type", "varient Name", "Size" , "Color",
		// "Fabric", "Pattern", "Fit" , "Style",
		// "Long Name", "Varient Code", "Cost", "MRP",
		// "Sales Price", "Parent Code", "Short Name"};

		if (articleCode.getText().length() > 0) {
			int vsrno = Integer.parseInt(articleCode.getText());
			vsrno = vsrno + 1;
			String varientno = "";
			int row = vtable.getRowCount();
			for (int i = 0; i < row; i++) {
				vtable.setValueAt(varticlecode, i, 14);
				varientLastno = vsrno;
				String vvsrno = Integer.toString(vsrno);
				varientno = vvsrno;
				vtable.setValueAt(varientno, i, 10);
				vsrno++;
			}
		}

		/*
		 * if ( articleCode.getText().length()>0) { int vsrno = 101; String
		 * varientno = ""; int row = vtable.getRowCount(); for (int i=0 ; i <
		 * row ; i++) { vtable.setValueAt( varticlecode, i, 14); String vvsrno =
		 * Integer.toString(vsrno); varientno = varticlecode.concat(vvsrno) ;
		 * vtable.setValueAt( varientno, i, 10); vsrno++; } }
		 */

		if (articleCode.getText().length() == 0) {
			new General().msg("Please Save Data First...");
		}
	}

	// Fashion//
	private String insert_varent_EanCode() throws Throwable {
		btnSave.setEnabled(false);
		String status = "Sucess";
		prst = null;
		final int batchSize = 5;
		int TotalRecordinsert = 0;
		this.closeconn();
		int row = 0;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String varient = "Insert into   ms_ean_master(Article_code , " + "Ean_code, Active,  salesPrice , mrp ,  cost )"
				+ "values(?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(varient);
			row = vtable.getRowCount();
			for (int i = 0; i < row; i++) {
				String vmytax = tax_code.getSelectedItem().toString().trim();
				String vmycost = vtable.getValueAt(i, 11).toString();
				String VLC = new gnMath().getLandingCost(vmytax, vmytax);
				prst.setString(1, vtable.getValueAt(i, 10).toString());
				prst.setString(2, vtable.getValueAt(i, 10).toString());
				prst.setString(3, "Y");
				prst.setString(4, vtable.getValueAt(i, 13).toString());
				prst.setString(5, vtable.getValueAt(i, 12).toString());
				prst.setString(6, vtable.getValueAt(i, 11).toString());
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				////// !!!!!!!Enter Sales Price & Stock
				String vtype = "NewArticle";
				String vqty = "0.00";
				String vcompcode = new gnConfig().getCompanyCode();
				String vstore = new gnConfig().getStoreID();
				if (vcompcode != "0") {
					String vbatch = new gnComp().getCheckBoxValue(chkBatchControl);
					String vinvtype = "0";
					// new applyInv_Action(). invAction(vstore
					// ,vtable.getValueAt(i, 10).toString() , vtype, vdate, vqty
					// , vlocation, vcompcode, vverticle, vinvtype, vbatch) ;
					new ApplySalesPrice_Action().SalesPriceInsert(vstore, vtable.getValueAt(i, 10).toString(), vdate,
							vtable.getValueAt(i, 12).toString(), vtable.getValueAt(i, 13).toString(),
							vtable.getValueAt(i, 11).toString(), vcompcode, vverticle, VLC);
				}
				////// !!!!!!!Enter Sales Price & Stock

				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					status = "Sucess";
					con.commit();
				}
				prst.executeBatch(); // insert remaining records
				con.commit();
				status = "Sucess";
			} // for
		} // try
		catch (SQLException e) {
			new General().msg(e.getMessage());

			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
				insertVarientArtcle();
			}
			if (con != null) {
				con.close();
			}
			return status;
		}
	}

	// fashion//
	public String insertVarientArtcle() throws Throwable {

		// String vCol[] = {"Del", "Type", "varient Name", "Size" , "Color",
		// "Pattern" ,
		// "Material", "Fit" , "Style",
		// "Long Name", "Varient Code", "Cost", "MRP",
		// "Sales Price", "Parent Code", "Short Name"};

		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		int row = vtable.getRowCount();
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String varientArticle = "INSERT INTO  msarticle_master ( Company_code , Article_code ,Item_code ,"
				+ " Name ,POS_NAME ,Auto_Generate_Name ," + " UOM ,DefaultEAN ,DefaultVendor ,"
				+ "DefaultLocation ,SalesUOM ,Article_Type ," + "Article_Class ,Trading_Article ,MRPBaseArticle ,"
				+ "Article_category ,Article_subCategory ,Article_Group ," + "Article_SubGroup ,Tax_code ,Tax_Per ,"
				+ "Manuf ,Brand ,Markup ," + "MarkDown ,Margin ,MRP ," + "cost ,SalesPrice,Pack_Type ,"
				+ "PackSiZe ,Pack_Form ,Active ," + "ParentArticle ,ProcessLoss_per ,Inner_Pack_size ,"
				+ "Inner_Pack_qty ,Color ,Size ," + "Fit ,Fabric ,Style ,"
				+ "Pattern ,Batch_control_Article ,Max_ShelfLife ,"
				+ "Min_shelfLife , ShelfLife_In_days_Month ,Verticle ," + "CreatedBy ,CreateDate ,segment ,"
				+ "hierarchyno , basecost, basemrp, basesp, srno, mbq, rolevel, content, "
				+ "Drugtype, subcatName, BrandName, ApplyTaxSlab , PurchaseUOM,   shelf)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {

			for (int i = 0; i < row; i++) {
				prst = con.prepareStatement(varientArticle);
				prst.setString(1, vcomp);
				prst.setString(2, vtable.getValueAt(i, 10).toString());
				prst.setString(3, vtable.getValueAt(i, 10).toString());
				prst.setString(4, vtable.getValueAt(i, 9).toString()); // vname);
				prst.setString(5, vtable.getValueAt(i, 15).toString()); // vposname);
				prst.setString(6, vtable.getValueAt(i, 9).toString()); // vautoname)
																		// ;
				prst.setString(7, vuom);
				prst.setString(8, vean);
				prst.setString(9, vsupplier);
				prst.setString(10, vlocation);
				prst.setString(11, vpuruom);
				prst.setString(12, "3"); // varticleType
				prst.setString(13, varticleClass);
				prst.setString(14, "Y");
				prst.setString(15, vmrpbase);
				prst.setString(16, vArticle_category);
				prst.setString(17, vArticle_subcategory);
				prst.setString(18, vArticle_group);
				prst.setString(19, vArticle_subGroup);
				prst.setString(20, vtaxcode);
				prst.setString(21, vtaxper);
				prst.setString(22, vmanuf);
				prst.setString(23, vbrand);
				prst.setString(24, vmarkup);
				prst.setString(25, vmarkdown);
				prst.setString(26, vmargin);
				prst.setString(27, vtable.getValueAt(i, 12).toString()); // vmrp
				prst.setString(28, vtable.getValueAt(i, 11).toString()); // vcost)
																			// ;
				prst.setString(29, vtable.getValueAt(i, 13).toString()); // vsalesprice)
																			// ;
				prst.setString(30, vpacktype);
				prst.setString(31, vpacksize);
				prst.setString(32, vpackform);
				prst.setString(33, vactive);
				prst.setString(34, vtable.getValueAt(i, 14).toString()); // vparenetcode)
																			// ;
				prst.setString(35, vprocessloss);
				prst.setString(36, vinnerpacksize);
				prst.setString(37, vinnerpackqty);
				// String vCol[] = {"Del", "Type", "varient Name", "Size" ,
				// "Color", "Pattern" ,
				// "Fabric", "Fit" , "Style",
				// "Long Name", "Varient Code", "Cost", "MRP",
				// "Sales Price", "Parent Code", "Short Name"};

				prst.setString(38, vtable.getValueAt(i, 4).toString()); // vcolor)
																		// ;
				prst.setString(39, vtable.getValueAt(i, 3).toString()); // vsize)
																		// ;

				// prst.setString(40, vtable.getValueAt(i, 7).toString());
				// //vfit) ;
				// prst.setString(41, vtable.getValueAt(i, 5).toString()); //
				// vfabric) ;
				// prst.setString(42, vtable.getValueAt(i, 8).toString());
				// //vstyle) ;
				prst.setString(40, "0");// vtable.getValueAt(i, 7).toString());
										// //vfit) ;
				prst.setString(41, vtable.getValueAt(i, 6).toString()); // vfabric)
																		// ;
				prst.setString(42, "0");

				prst.setString(43, vtable.getValueAt(i, 5).toString()); // vpattern)
																		// ;
				prst.setString(44, vbatchcontrol);
				prst.setString(45, vmaxshelflife);
				prst.setString(46, vminshelflife);
				prst.setString(47, "D");
				prst.setString(48, vverticle);
				prst.setString(49, ucode);
				prst.setString(50, vdate);
				prst.setString(51, vsegment);
				prst.setString(52, vhierarchyno);
				prst.setString(53, "0.00");
				prst.setString(54, "0.00");
				prst.setString(55, salesprice.getText());
				prst.setString(56, "1");
				prst.setString(57, mbq.getText());
				prst.setString(58, rolevel.getText());
				prst.setString(59, vcontent);
				prst.setString(60, "N");
				prst.setString(61, "None");
				prst.setString(62, brandname.getText());
				prst.setString(63, vapplytaxslab);
				prst.setString(64, vpuruom);
				prst.setString(65, "No");
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				status = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					status = "Sucess";
					con.commit();
				}
				prst.executeBatch();
				con.commit();
			}
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
				new General().Quickmsg("Varient Data Saved Sucessfully");
				btnSave.setEnabled(true);
				new gnTable().RemoveTableRows(vmodel);
				// varientPanel.setVisible(false);
				varientLastno = varientLastno + 1;
				new General().Quickmsg("Updating Varient Last Number " + " " + varientLastno);
				String vvarntLatno = Integer.toString(varientLastno);
				new gnSeq().updateSeqno_Upoad("906", "MS", vvarntLatno);
				setDefaultValue();
			}
			if (con != null) {
				con.close();
			}
		}
		return status;
	}

	// ChildEan Code Entery Fashion//

	private String insert_Child_EanCode() throws Throwable {
		btnSave.setEnabled(false);
		String status = "Sucess";
		prst = null;
		final int batchSize = 5;
		int TotalRecordinsert = 0;
		this.closeconn();
		int row = 0;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String varient = "Insert into   ms_ean_master(Article_code , " + "Ean_code, Active,  salesPrice , mrp ,  cost )"
				+ "values(?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(varient);
			row = vtable.getRowCount();
			for (int i = 0; i < row; i++) {
				// String vCol[] = { "Del", "Type", "Child Item Name",
				// "PackSize" , "UOM" ,
				// "PackForm", "Article Class", "Packed Type", "Item Name",
				// 9"Product Code", 10"Cost", 11"MRP", 12"Sales Price",
				// "Tax%", "Parent Code", "Short Name"};

				prst.setString(1, vtable.getValueAt(i, 9).toString());
				prst.setString(2, vtable.getValueAt(i, 9).toString());
				prst.setString(3, "Y");
				prst.setString(4, vtable.getValueAt(i, 12).toString());
				prst.setString(5, vtable.getValueAt(i, 11).toString());
				prst.setString(6, vtable.getValueAt(i, 10).toString());
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				////// !!!!!!!Enter Sales Price & Stock
				String vtype = "NewArticle";
				String vqty = "0.00";
				String vcompcode = new gnConfig().getCompanyCode();
				String vstore = new gnConfig().getStoreID();
				if (vcompcode != "0") {
					String vbatch = new gnComp().getCheckBoxValue(chkBatchControl);
					String vinvtype = "0";

					new applyInv_Action().invAction(vstore, vtable.getValueAt(i, 9).toString(), vtype, vdate, vqty,
							vlocation, vcompcode, vverticle, vinvtype, vbatch);
					new ApplySalesPrice_Action().SalesPriceInsert(vstore, vtable.getValueAt(i, 9).toString(), vdate,
							vtable.getValueAt(i, 11).toString(), vtable.getValueAt(i, 12).toString(),
							vtable.getValueAt(i, 10).toString(), vcompcode, vverticle, VLC);
				}
				////// !!!!!!!Enter Sales Price & Stock

				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					status = "Sucess";
					con.commit();
				}
				prst.executeBatch(); // insert remaining records
				con.commit();
				status = "Sucess";
			} // for
		} // try
		catch (SQLException e) {
			new General().msg(e.getMessage());

			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
				insertChildArtcle();
			}
			if (con != null) {
				con.close();
			}
			return status;
		}

	}

	// fashion//
	public String insertChildArtcle() throws Throwable {
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		int row = vtable.getRowCount();
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String varientArticle = "INSERT INTO  msarticle_master ( Company_code , Article_code ,Item_code ,"
				+ " Name ,POS_NAME ,Auto_Generate_Name ," + " UOM ,DefaultEAN ,DefaultVendor ,"
				+ "DefaultLocation ,SalesUOM ,Article_Type ," + "Article_Class ,Trading_Article ,MRPBaseArticle ,"
				+ "Article_category ,Article_subCategory ,Article_Group ," + "Article_SubGroup ,Tax_code ,Tax_Per ,"
				+ "Manuf ,Brand ,Markup ," + "MarkDown ,Margin ,MRP ," + "cost ,SalesPrice,Pack_Type ,"
				+ "PackSiZe ,Pack_Form ,Active ," + "ParentArticle ,ProcessLoss_per ,Inner_Pack_size ,"
				+ "Inner_Pack_qty ,Color ,Size ," + "Fit ,Fabric ,Style ,"
				+ "Pattern ,Batch_control_Article ,Max_ShelfLife ,"
				+ "Min_shelfLife , ShelfLife_In_days_Month ,Verticle ," + "CreatedBy ,CreateDate ,segment ,"
				+ "hierarchyno , basecost, basemrp, basesp, srno, mbq, rolevel, content)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {

			for (int i = 0; i < row; i++) {
				prst = con.prepareStatement(varientArticle);
				prst.setString(1, vcomp);
				// String vCol[] = { 0"Del", 1"Type", 2"Child Item Name",
				// 3"PackSize" , 4"UOM" ,
				// 5"PackForm", 6"Article Class", 7"Packed Type", 8"Item Name",
				// 9"Product Code", 10"Cost", 11"MRP", 12"Sales Price",
				// 13"Tax%", 14"Parent Code", 15"Short Name"};
				prst.setString(2, vtable.getValueAt(i, 9).toString());
				prst.setString(3, vtable.getValueAt(i, 9).toString());
				prst.setString(4, vtable.getValueAt(i, 2).toString()); // vname);
				prst.setString(5, vtable.getValueAt(i, 15).toString()); // vposname);
				prst.setString(6, vtable.getValueAt(i, 8).toString()); // vautoname)
																		// ;
				prst.setString(7, vtable.getValueAt(i, 4).toString());// vuom ;
				prst.setString(8, vean);
				prst.setString(9, vsupplier);
				prst.setString(10, vlocation);
				// String vCol[] = { 0"Del", 1"Type", 2"Child Item Name",
				// 3"PackSize" , 4"UOM" ,
				// 5"PackForm", 6"Article Class", 7"Packed Type", 8"Item Name",
				// 9"Product Code", 10"Cost", 11"MRP", 12"Sales Price",
				// 13"Tax%", 14"Parent Code", 15"Short Name"};
				prst.setString(11, vtable.getValueAt(i, 4).toString());// vuom ;
				prst.setString(12, varticleType);
				prst.setString(13, vtable.getValueAt(i, 6).toString());
				prst.setString(14, "Y");
				prst.setString(15, vmrpbase);
				prst.setString(16, vArticle_category);
				prst.setString(17, vArticle_subcategory);
				prst.setString(18, vArticle_group);
				prst.setString(19, vArticle_subGroup);
				prst.setString(20, vtaxcode);
				prst.setString(21, vtaxper);
				prst.setString(22, vmanuf);
				prst.setString(23, vbrand);
				prst.setString(24, vmarkup);
				prst.setString(25, vmarkdown);
				prst.setString(26, vmargin);
				prst.setString(27, vtable.getValueAt(i, 11).toString()); // vmrp
				prst.setString(28, vtable.getValueAt(i, 10).toString()); // vcost)
																			// ;
				prst.setString(29, vtable.getValueAt(i, 12).toString()); // vsalesprice)
																			// ;

				// String vCol[] = { 0"Del", 1"Type", 2"Child Item Name",
				// 3"PackSize" , 4"UOM" ,
				// 5"PackForm", 6"Article Class", 7"Packed Type", 8"Item Name",
				// 9"Product Code", 10"Cost", 11"MRP", 12"Sales Price",
				// 13"Tax%", 14"Parent Code", 15"Short Name"};

				prst.setString(30, vtable.getValueAt(i, 7).toString()); // packtype
				prst.setString(31, vtable.getValueAt(i, 3).toString()); // packsize
				prst.setString(32, vtable.getValueAt(i, 5).toString()); // vpackform
																		// ;
				prst.setString(33, vactive);
				prst.setString(34, vtable.getValueAt(i, 14).toString()); // vparenetcode)
																			// ;
				prst.setString(35, vprocessloss);
				prst.setString(36, vinnerpacksize);
				prst.setString(37, vinnerpackqty);
				prst.setString(38, "0"); // vtable.getValueAt(i, 4).toString());
											// //vcolor) ;
				prst.setString(39, "0");// vtable.getValueAt(i, 3).toString());
										// //vsize) ;
				prst.setString(40, "0");// vtable.getValueAt(i, 7).toString());
										// //vfit) ;
				prst.setString(41, "0");// vtable.getValueAt(i, 5).toString());
										// // vfabric) ;
				prst.setString(42, "0");// vtable.getValueAt(i, 8).toString());
										// //vstyle) ;
				prst.setString(43, "0");// vtable.getValueAt(i, 6).toString());
										// //vpattern) ;
				prst.setString(44, vbatchcontrol);
				prst.setString(45, vmaxshelflife);
				prst.setString(46, vminshelflife);
				prst.setString(47, "D");
				prst.setString(48, vverticle);
				prst.setString(49, ucode);
				prst.setString(50, vdate);
				prst.setString(51, vsegment);
				prst.setString(52, vhierarchyno);
				prst.setString(53, "0.00");
				prst.setString(54, "0.00");
				prst.setString(55, salesprice.getText());
				prst.setString(56, "1");
				prst.setString(57, mbq.getText());
				prst.setString(58, rolevel.getText());
				prst.setString(59, vcontent);
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				status = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					status = "Sucess";
					con.commit();
				}
				prst.executeBatch();
				con.commit();
			}
		} catch (SQLException e) {
			new General().msg(e.getMessage());
			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
				new General().msg("Varient Data Saved Sucessfully");
				btnSave.setEnabled(true);
				new gnTable().RemoveTableRows(vmodel);
				// varientPanel.setVisible(false);
				setDefaultValue();
			}
			if (con != null) {
				con.close();
			}
		}
		return status;
	}

	public void ArticleDiscGroup() throws Throwable {
		// this Section is added for autoMobile Division only
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		// JTable mydiscTable ;
		// DefaultTableModel mydiscModel ;
		// JTable discTable = discTable ; // new
		// Auto_Article_disc_group().rtable;
		int row = discTable.getRowCount();
		if (row > 0) {
			String status = "Fail";
			Connection con = this.getConnection();
			con.setAutoCommit(false);
			String varientArticle = "INSERT INTO     msarticle_group_discounts ( Company_code ,  Type,   Article_code , disc_per)"
					+ "values(?,?,?,?)";
			try {
				for (int i = 0; i < row; i++) {
					prst = con.prepareStatement(varientArticle);
					prst.setString(1, vcomp);
					prst.setString(2, discTable.getValueAt(i, 0).toString());
					prst.setString(3, varticlecode);
					prst.setString(4, discTable.getValueAt(i, 1).toString()); // Disc%;
					prst.addBatch();
					TotalRecordinsert = TotalRecordinsert + 1;
					status = "Sucess";
					if (++TotalRecordinsert % batchSize == 0) {
						prst.executeBatch();
						status = "Sucess";
						con.commit();
					}
					prst.executeBatch();
					con.commit();
				}
			} catch (SQLException e) {
				new General().msg(e.getMessage());
				con.rollback();
				status = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
					new General().msg("Discount Group Saved");
					//new Auto_Article_disc_group().refresh();
				}
				if (con != null) {
					con.close();
				}
			}
		}
	}
} // Last

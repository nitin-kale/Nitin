package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;

public class Article_upload_utility extends getResultSet {

	JFrame ArtcleUploadFrame;
	JPanel rightPanel;
	JPanel leftPanel;
	JButton btnCalculate;
	JButton btnSave;
	JButton btnClose;
	JButton btnStockUpload;
	JButton btnExport;
	JButton btnFile;
	String vapplyTaxSlab = "N";
	JScrollPane rjsp;
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable();
	JScrollPane ljsp;
	private JTextField records;
	JTextPane selectedfile;

	private String vcomp;

	private String varticlecode;
	private String vname;
	private String vposname;
	private String vautoname;
	private String vean;
	private String vsupplier;
	private String vlocation;
	private String vuom;
	private String varticleType;
	private String varticleClass;
	private String vtradingarticle;
	private String vmrpbase;
	private String vArticle_category;
	private String vArticle_subcategory;
	private String vArticle_group;
	private String vArticle_subGroup;
	private String vtaxcode;
	private String vtaxper;
	private String vmanuf;
	private String vbrand;
	private String vmarkup;
	private String vmarkdown;
	private String vmargin;
	private String vmrp;
	private String vcost;
	private String vsalesprice;
	private String vpacktype;
	private String vpacksize;
	private String vpackform;
	private String vactive;
	private String vparentcode;
	private String vprocessloss;
	private String vinnerpacksize;
	private String vinnerpackqty;
	private String vcolor;
	private String vsize;
	private String vfit;
	private String vfabric;
	private String vstyle;
	private String vpattern;
	private String vpurchaseuom = "";
	private String vmaintainInventory = "Y";

	private String vbatchcontrol;
	private String vmaxshelflife;
	private String vminshelflife;
	private String vverticle;
	private String ucode;
	private String vdate;
	private String vsegment;
	private String vhierarchyno;
	private String vbaseprice;
	private String vbasemrp;
	private String vsalesprice1;
	private String vmbq;
	private String vrolevel;
	private String veanarticle;
	private String vcontent;
	private JLabel lblNewLabel_3;
	private JTextField verticlecode;
	private JTextField verticlename;
	private JLabel VerticleName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Article_upload_utility window = new Article_upload_utility();
					window.ArtcleUploadFrame.setVisible(true);
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
	public Article_upload_utility() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		ArtcleUploadFrame = new JFrame();
		ArtcleUploadFrame.getContentPane().setBackground(new Color(204, 204, 255));
		ArtcleUploadFrame.setBounds(1, 1, 1350, 750);
		ArtcleUploadFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ArtcleUploadFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Article/Item Uplaod Utility");
		lblNewLabel.setBounds(0, 0, 1332, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		ArtcleUploadFrame.getContentPane().add(lblNewLabel);
		ActionListener lsbtn = new btnPress();

		leftPanel = new JPanel();
		leftPanel.setForeground(new Color(51, 0, 204));
		leftPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Please check File Upload Details", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		leftPanel.setBackground(Color.CYAN);
		leftPanel.setBounds(1, 10, 763, 223);

		rightPanel = new JPanel();
		rightPanel.setBounds(775, 86, 557, 223);

		JSplitPane mySplt = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
		mySplt.setBounds(10, 79, 1320, 625);
		leftPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Item Upload ",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 102)));
		mySplt.setDividerLocation(950);

		rightPanel.setLayout(null);

		rjsp = new JScrollPane();
		rjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		rjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		rjsp.setBounds(10, 43, 553, 567);

		rightPanel.add(rjsp);
		leftPanel.setLayout(null);

		ljsp = new JScrollPane();
		ljsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		ljsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ljsp.setBounds(0, 44, 949, 566);

		leftPanel.add(ljsp);

		btnFile = new JButton("Select File");
		btnFile.setBounds(412, 13, 109, 26);
		leftPanel.add(btnFile);
		btnFile.setMnemonic('F');
		btnFile.addActionListener(lsbtn);
		btnFile.setToolTipText("Select File From Local Drive To Upload");

		btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(523, 13, 97, 26);
		leftPanel.add(btnCalculate);
		btnCalculate.setMnemonic('C');
		btnCalculate.setToolTipText("Calculate Length");

		btnSave = new JButton("Save");
		btnSave.setBounds(852, 13, 97, 26);
		leftPanel.add(btnSave);
		btnSave.setMnemonic('S');

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(0, 14, 97, 25);
		leftPanel.add(btnClose);

		btnExport = new JButton("Export");
		btnExport.setMnemonic('E');
		btnExport.setBounds(109, 14, 97, 25);
		leftPanel.add(btnExport);

		VerticleName = new JLabel(" ");
		VerticleName.setBounds(255, 18, 344, 16);
		leftPanel.add(VerticleName);

		btnStockUpload = new JButton("Stock Upload");
		btnStockUpload.setBounds(687, 14, 153, 25);
		leftPanel.add(btnStockUpload);

		btnSave.addActionListener(lsbtn);
		btnClose.addActionListener(lsbtn);
		btnExport.addActionListener(lsbtn);
		btnStockUpload.addActionListener(lsbtn);

		btnCalculate.addActionListener(lsbtn);
		ArtcleUploadFrame.getContentPane().add(mySplt);

		JLabel lblNewLabel_1 = new JLabel("Records");
		lblNewLabel_1.setBounds(37, 55, 84, 16);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		ArtcleUploadFrame.getContentPane().add(lblNewLabel_1);

		records = new JTextField();
		records.setBounds(120, 50, 93, 26);
		records.setFont(new Font("Tahoma", Font.BOLD, 14));
		records.setEditable(false);
		ArtcleUploadFrame.getContentPane().add(records);
		records.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Selected File");
		lblNewLabel_2.setBounds(237, 27, 84, 16);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		ArtcleUploadFrame.getContentPane().add(lblNewLabel_2);

		selectedfile = new JTextPane();
		selectedfile.setBounds(213, 51, 439, 26);
		selectedfile.setEditable(false);
		ArtcleUploadFrame.getContentPane().add(selectedfile);

		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setBounds(972, 29, 360, 47);
		lblNewLabel_4.setIcon(new ImageIcon(Article_upload_utility.class.getResource("/RetailProduct/Anim3.gif")));
		ArtcleUploadFrame.getContentPane().add(lblNewLabel_4);

		lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setBounds(0, 3, 1332, 73);
		lblNewLabel_3.setIcon(new ImageIcon(Article_upload_utility.class.getResource("/RetailProduct/panel11.png")));
		ArtcleUploadFrame.getContentPane().add(lblNewLabel_3);

		decorate();

	}

	private void decorate() throws Throwable {
		VerticleName.setText(new gnHierarchy().getVerticleName());

		new gnApp().setFrameTitel(ArtcleUploadFrame);
		new gnStyleButton().getStyleButton(btnSave, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnFile, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnCalculate, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnExport, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnClose, new Color(156, 211, 112), Color.WHITE);

		new gnDecorate().changeOnFocus(btnSave, Color.MAGENTA, Color.WHITE);
		new gnDecorate().changeOnFocus(btnFile, Color.MAGENTA, Color.WHITE);
		new gnDecorate().changeOnFocus(btnCalculate, Color.MAGENTA, Color.WHITE);
		new gnDecorate().changeOnFocus(btnClose, Color.MAGENTA, Color.WHITE);
		new gnDecorate().changeOnFocus(btnExport, Color.MAGENTA, Color.WHITE);

	}

	private String validate() {
		String vstatus = "Sucess";

		int row = table.getRowCount();

		if (row == 0) {
			vstatus = "Fail";
		}

		if (row > 0) {
			for (int i = 0; i < row; i++) {
				// {"Article" , "Name" , "Name Length", "Short Name" , "ShortNm
				// Length", "Pack size" , "UOM", "MRP", "Sales Price", "Cost" }
				// ;

				String vnameln = table.getValueAt(i, 1).toString();
				String vshnameln = table.getValueAt(i, 3).toString();
				int inameln = vnameln.length();
				int ishnameln = vshnameln.length();
				if (inameln > 50) {
					vstatus = "Fail";
					new General().msg("Name Length is > 50 char for Article  " + "" + vnameln);
				}

				if (ishnameln > 30) {
					vstatus = "Fail";
					new General().msg("Short Name Length is >  30 char for Article  " + "" + vshnameln);
				}
			}
		}
		return vstatus;
	}

	class btnPress implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			if (value == "Close") {
				ArtcleUploadFrame.dispose();
			}

			if (value == "Export") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

			if (value == "Stock Upload") {
				try {
					callStockUploadFile();
				} catch (FileNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Save") {
				btnCalculate.doClick();
				String Status = validate();
				if (Status == "Sucess") {
					GenerateArticleCode();
					try {
						preparetoinsert();
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			if (value == "Calculate") {
				calculateLength();
			}

			if (value == "Select File") {
				try {
					callUploadFile();
				} catch (FileNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private void calculateLength() {
		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {
			// {"Article" , "Name" , "Name Length", "Short Name" , "ShortNm
			// Length", "Pack size" , "UOM", "MRP", "Sales Price", "Cost" } ;
			String vnameln = table.getValueAt(i, 1).toString();
			String vshnameln = table.getValueAt(i, 3).toString();
			int inameln = vnameln.length();
			int ishnameln = vshnameln.length();
			table.setValueAt(Integer.toString(inameln), i, 2);
			table.setValueAt(Integer.toString(ishnameln), i, 4);
		}
	}

	private void callUploadFile() throws FileNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		DefaultTableModel xmodel = model;
		String col[] = { "Article", "Name", "Name Length", "Short Name", "ShortNm Length", "Pack size", "UOM", "MRP",
				"Sales Price", "Cost", "Tax", "Batch" };
		xmodel.setColumnIdentifiers(col);
		model.setColumnIdentifiers(col);
		File vfile1 = new File("D:\\akn\\uploadFile\\ArticleUpload.xls");
		File vfdir = new File(ProductPath + "uploadFile");
		String filePath = " ";
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(vfdir);
		FileFilter filter = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
		fileChooser.addChoosableFileFilter(filter);
		String filename = null;
		fileChooser.setDialogTitle("Select File For Upload Article Master");
		fileChooser.setBackground(Color.white);
		fileChooser.setCurrentDirectory(vfile1);
		int returnValue = fileChooser.showOpenDialog(ljsp);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			filename = selectedFile.getAbsolutePath();
			selectedfile.setText(filename);
			filePath = filename;
		}

		if (filename.endsWith("xls") || filename.endsWith("xlsx")) {
			model = new exportToExcel().ArticleMasterExcelData(filePath, xmodel);
		} else {
			new General().msg("Please Check File Format ..Only Excel Files Are Allow");
			new gnImageSound().playAlertSound();
		}
		table.setModel(model);
		records.setText(Double.toString(new gnTable().getRowCount(table)));
		new gnTable().setTableBasics(table);
		new gnTable().setTableColWidth(table, 1, 200);
		new gnTable().setTableColWidth(table, 3, 200);
		JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(table, col);
		prt.setVisible(true);
		ljsp.setViewport(prt);
		btnCalculate.doClick();
	}

	private void callStockUploadFile() throws FileNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		DefaultTableModel xmodel = model;
		String col[] = { "Article", "Name", "Op.Stock", "Pur.Price", "MRP", "Sales Price", "Batch.No" };
		xmodel.setColumnIdentifiers(col);
		model.setColumnIdentifiers(col);
		File vfile1 = new File("D:\\akn\\uploadFile\\ArticleUpload.xls");
		File vfdir = new File(ProductPath + "uploadFile");
		String filePath = " ";
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(vfdir);
		FileFilter filter = new FileNameExtensionFilter("Excel file", "xls", "xlsx");
		fileChooser.addChoosableFileFilter(filter);
		String filename = null;
		fileChooser.setDialogTitle("Select File For Upload Article Master and Op.Stock Data");
		fileChooser.setBackground(Color.white);
		fileChooser.setCurrentDirectory(vfile1);
		int returnValue = fileChooser.showOpenDialog(ljsp);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			filename = selectedFile.getAbsolutePath();
			selectedfile.setText(filename);
			filePath = filename;
		}

		if (filename.endsWith("xls") || filename.endsWith("xlsx")) {
			model = new exportToExcel().uploadOpeningStock(filePath, xmodel);
		} else {
			new General().msg("Please Check File Format ..Only Excel Files Are Allow");
			new gnImageSound().playAlertSound();
		}
		table.setModel(model);
		records.setText(Double.toString(new gnTable().getRowCount(table)));
		new gnTable().setTableBasics(table);
		new gnTable().setTableColWidth(table, 1, 200);
		new gnTable().setTableColWidth(table, 3, 200);
		JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(table, col);
		prt.setVisible(true);
		ljsp.setViewport(prt);
		btnCalculate.doClick();
	}

	private void GenerateArticleCode() {
		// String varientno = "";
		int row = table.getRowCount();
		String vtype = "MS";
		String vtran = "906";

		int varientno = 0;
		try {
			varientno = Integer.parseInt(new gnSeq().getSeqno(vtran, vtype));
		} catch (Throwable e1) {
			e1.printStackTrace();
		}

		for (int i = 0; i < row; i++) {
			try {
				table.setValueAt(varientno, i, 0);
				varientno = varientno + 1;
			} catch (Throwable e) {
				e.printStackTrace();
				new General().msg("Article Code Generation.." + e.getLocalizedMessage());
			} finally {

			}
		}
		try {
			String vlastno = Integer.toString(varientno);
			new gnSeq().updateSeqno_Upoad(vtran, vtype, vlastno);
		} catch (Throwable e) {
			new General().msg(e.getMessage());
		}

	}

	private void preparetoinsert() throws Throwable {

		vcomp = new gnConfig().getCompanyCode();
		varticlecode = "0";
		vname = " ";
		vposname = "";
		vautoname = "";
		vuom = "NO";
		vmrp = "0";
		vcost = "0";
		vsalesprice = "0";
		;
		vuom = "NO";
		vpacksize = "0";
		vtaxcode = "0";
		vtaxper = "0";

		vean = "0";
		vsupplier = "0";
		vlocation = "SL";
		vuom = "NO";
		varticleType = "1";
		varticleClass = "C";
		vtradingarticle = "Y";
		vmrpbase = "Y";
		vArticle_category = "0";
		vArticle_subcategory = "0";
		vArticle_group = "0";
		vArticle_subGroup = "0";
		vmanuf = "0";
		vbrand = "0";
		vmarkup = "0";
		vmarkdown = "0";
		vmargin = "0";
		vpacktype = "0";
		vpackform = "0";
		vactive = "Y";
		vparentcode = "0";
		vprocessloss = "0";
		vinnerpacksize = "0";
		vinnerpackqty = "0";
		vcolor = "0";
		vsize = "0";
		vfit = "0";
		vfabric = "0";
		vstyle = "0";
		vpattern = "0";
		vbatchcontrol = "0";
		vmaxshelflife = "0";
		vminshelflife = "0";
		vverticle = new gnHierarchy().getVerticleCode();
		if (vverticle == "7" | vverticle == "14") {
			vapplyTaxSlab = "Y";
		}

		if (vverticle != "7" | vverticle != "14") {
			vapplyTaxSlab = "N";
		}

		ucode = new gnConfig().getUserCode();
		vdate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
		vsegment = "1";
		vhierarchyno = vverticle;
		vbaseprice = "0";
		vpurchaseuom = "";
		vmaintainInventory = "Y";

		vbasemrp = "0";
		vsalesprice = "0";
		vmbq = "0";
		vrolevel = "0";
		veanarticle = "N";
		vcontent = "";

		insertArtcle();
	}

	public String insertArtcle() throws Throwable {
		prst = null;
		final int batchSize = 100;
		int TotalRecordinsert = 0;
		// this.closeconn();
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String hie = "INSERT INTO  msarticle_master ( Company_code , Article_code ,Item_code ,"
				+ " Name ,POS_NAME ,Auto_Generate_Name ," + " UOM ,DefaultEAN ,DefaultVendor ,"
				+ "DefaultLocation ,SalesUOM ,Article_Type ," + "Article_Class ,Trading_Article ,MRPBaseArticle ,"
				+ "Article_category ,Article_subCategory ,Article_Group ," + "Article_SubGroup ,"
				+ "Tax_code ,Tax_Per ," + "Manuf ,Brand ,Markup ," + "MarkDown ,Margin ,MRP ,"
				+ "cost ,SalesPrice,Pack_Type ," + "PackSiZe ,Pack_Form ,Active ,"
				+ "ParentArticle ,ProcessLoss_per ,Inner_Pack_size ," + "Inner_Pack_qty ,Color ,Size ,"
				+ "Fit ,Fabric ,Style ," + "Pattern ," + "Batch_control_Article ,Max_ShelfLife ,"
				+ "Min_shelfLife , ShelfLife_In_days_Month ,Verticle ,"
				+ "CreatedBy ,CreateDate ,segment ,hierarchyno ,"
				+ " basecost, basemrp, basesp, srno, mbq, rolevel, ean_article, content, PurchaseUOM, MaintainInventory,"
				+ "  BrandName, SubcatName , ApplyTaxSlab, shelf)"
				+ "values(?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,? , ?,?,?,?)";

		try {
			int row = table.getRowCount();
			prst = con.prepareStatement(hie);
			for (int i = 0; i < row; i++) {
				// 0"Article" , 1"Name" , 2"Name Length", 3"Short Name" ,
				// 4"ShortNm Length",
				// 5"Pack size" , 6"UOM", 7"MRP", 8"Sales Price", 9"Cost" } ;

				varticlecode = table.getValueAt(i, 0).toString();
				vname = table.getValueAt(i, 1).toString().toUpperCase();
				vposname = table.getValueAt(i, 3).toString().toUpperCase();
				vautoname = table.getValueAt(i, 1).toString().toUpperCase();
				vpacksize = table.getValueAt(i, 5).toString();
				vuom = table.getValueAt(i, 6).toString().toUpperCase();
				vpurchaseuom = table.getValueAt(i, 6).toString().toUpperCase();
				vmrp = table.getValueAt(i, 7).toString();
				vsalesprice = table.getValueAt(i, 8).toString();
				vcost = table.getValueAt(i, 9).toString();
				vtaxcode = table.getValueAt(i, 10).toString();
				vtaxper = table.getValueAt(i, 10).toString();
				vbatchcontrol = table.getValueAt(i, 11).toString();

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
				prst.setString(11, vuom);
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
				prst.setString(53, "0"); // baseprice.getText() ) ;
				prst.setString(54, "0"); // basemrp.getText()) ;
				prst.setString(55, "0"); // salesprice.getText()) ;
				prst.setString(56, "1");
				prst.setString(57, "0");// mbq
				prst.setString(58, "0");// rolevel
				prst.setString(59, veanarticle);
				prst.setString(60, vcontent);
				prst.setString(61, vpurchaseuom);
				prst.setString(62, vmaintainInventory);
				prst.setString(63, "");
				prst.setString(64, "");
				prst.setString(65, vapplyTaxSlab);
				prst.setString(66, "N");

				prst.addBatch();
				// new General().msg("prst"+" "+prst) ;
				TotalRecordinsert = TotalRecordinsert + 1;
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					status = "Sucess";
					con.commit();
				}
				prst.executeBatch();
				con.commit();
			} // for Loop
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
				new General().msg("Data Saved Sucessfully....");
				showData();
				// reset();
			}
		}
		return status;
	}

	private void showData() throws Throwable {
		String sname = "%%";
		table = new gnAdmin().GetSearchAtricle(sname);
		new gnTable().setTableColWidth(table, 1, 200);
		new gnTable().setTableColWidth(table, 3, 200);
		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.CYAN);
		prt1.add(table);
		prt1.setVisible(true);
		rjsp.setViewport(prt1);

	}

	private void reset() {
		new gnTable().RemoveTableRows(model);
		records.setText("0");
		selectedfile.setText(null);

	}
}// Last

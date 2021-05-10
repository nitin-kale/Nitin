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

public class csvUploadUtility extends getResultSet {

	JFrame csvUploadFrame;
	JPanel rightPanel;
	JPanel leftPanel;
	JButton btnCalculate;
	String mychoice = "";
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
	private JTextField verticlecode;
	private JTextField verticlename;
	private JLabel VerticleName;
	private JButton btnInventory;

	String col[] = { "Srno", "Article", "Name", "shortname", "Pack size", "UOM", "MRP", "Sales Price", "Cost", "Tax",
			"Batch", "HSNCODE", "OpStock", "Batch", "ExpiryDate", "Name Length", "ShortNm Length" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					csvUploadUtility window = new csvUploadUtility();
					window.csvUploadFrame.setVisible(true);
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
	public csvUploadUtility() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		csvUploadFrame = new JFrame();
		csvUploadFrame.setResizable(false);
		csvUploadFrame.setAlwaysOnTop(true);
		csvUploadFrame.getContentPane().setBackground(new Color(51, 0, 102));
		csvUploadFrame.setBounds(1, 1, 1350, 750);
		csvUploadFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		csvUploadFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Data Upload Utility");
		lblNewLabel.setBounds(55, 0, 1277, 25);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		csvUploadFrame.getContentPane().add(lblNewLabel);
		ActionListener lsbtn = new btnPress();

		leftPanel = new JPanel();
		leftPanel.setForeground(new Color(51, 0, 204));
		leftPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Please check File Upload Details", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		leftPanel.setBackground(Color.CYAN);
		leftPanel.setBounds(1, 10, 1300, 223);

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

		btnInventory = new JButton("Check Inventory");
		btnInventory.setBounds(12, 13, 130, 25);
		rightPanel.add(btnInventory);
		leftPanel.setLayout(null);

		ljsp = new JScrollPane();
		ljsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		ljsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ljsp.setBounds(0, 44, 1300, 566);

		leftPanel.add(ljsp);

		btnFile = new JButton("Upload CSV File");
		btnFile.setBounds(376, 13, 145, 26);
		leftPanel.add(btnFile);
		btnFile.setMnemonic('F');
		btnFile.addActionListener(lsbtn);
		btnFile.setToolTipText("Select File From Local Drive To Upload");

		btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(523, 13, 97, 26);
		leftPanel.add(btnCalculate);
		btnCalculate.setMnemonic('C');
		btnCalculate.setToolTipText("Calculate Length");

		btnSave = new JButton("Load Item Master");
		btnSave.setBounds(618, 13, 166, 26);
		leftPanel.add(btnSave);
		btnSave.setMnemonic('S');

		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(0, 14, 97, 25);
		leftPanel.add(btnClose);

		btnExport = new JButton("Export");
		btnExport.setMnemonic('E');
		btnExport.setBounds(98, 14, 97, 25);
		leftPanel.add(btnExport);

		btnStockUpload = new JButton("Stock Upload");
		btnStockUpload.setBounds(796, 14, 153, 25);
		leftPanel.add(btnStockUpload);

		btnSave.addActionListener(lsbtn);
		btnClose.addActionListener(lsbtn);
		btnExport.addActionListener(lsbtn);
		btnStockUpload.addActionListener(lsbtn);
		btnInventory.addActionListener(lsbtn);

		btnCalculate.addActionListener(lsbtn);
		csvUploadFrame.getContentPane().add(mySplt);

		JLabel lblNewLabel_1 = new JLabel("Records");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(37, 55, 84, 16);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		csvUploadFrame.getContentPane().add(lblNewLabel_1);

		records = new JTextField();
		records.setBounds(120, 52, 93, 25);
		records.setFont(new Font("Tahoma", Font.BOLD, 14));
		records.setEditable(false);
		csvUploadFrame.getContentPane().add(records);
		records.setColumns(10);

		selectedfile = new JTextPane();
		selectedfile.setForeground(Color.BLACK);
		selectedfile.setBounds(213, 51, 439, 26);
		selectedfile.setEditable(false);
		csvUploadFrame.getContentPane().add(selectedfile);

		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setBounds(970, 0, 362, 76);
		lblNewLabel_4.setIcon(new ImageIcon(Article_upload_utility.class.getResource("/RetailProduct/Anim3.gif")));
		csvUploadFrame.getContentPane().add(lblNewLabel_4);

		VerticleName = new JLabel(" ");
		VerticleName.setForeground(Color.BLACK);
		VerticleName.setFont(new Font("SansSerif", Font.BOLD, 13));
		VerticleName.setBounds(237, 3, 276, 16);
		csvUploadFrame.getContentPane().add(VerticleName);

		JLabel lblNewLabel_5 = new JLabel(
				"*** While Using Item Upload Utility , Please Make Sure No Other User is Creating Items ..  File Path  \"D:/AKN/FileUpload/Article_master_upload.csv\"");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNewLabel_5.setBounds(65, 26, 855, 16);
		csvUploadFrame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setIcon(new ImageIcon(csvUploadUtility.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel_3.setBounds(0, 3, 975, 74);
		csvUploadFrame.getContentPane().add(lblNewLabel_3);

		decorate();

	}

	private void decorate() throws Throwable {
		VerticleName.setText(new gnHierarchy().getVerticleName());

		new gnApp().setFrameTitel(csvUploadFrame);
		new gnStyleButton().getStyleButton(btnSave, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnFile, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnCalculate, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnExport, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnClose, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnStockUpload, new Color(156, 211, 112), Color.WHITE);

		new gnDecorate().changeOnFocus(btnSave, Color.MAGENTA, Color.WHITE);
		new gnDecorate().changeOnFocus(btnFile, Color.MAGENTA, Color.WHITE);
		new gnDecorate().changeOnFocus(btnCalculate, Color.MAGENTA, Color.WHITE);
		new gnDecorate().changeOnFocus(btnClose, Color.MAGENTA, Color.WHITE);
		new gnDecorate().changeOnFocus(btnExport, Color.MAGENTA, Color.WHITE);
		new gnDecorate().changeOnFocus(btnStockUpload, Color.MAGENTA, Color.WHITE);

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
				csvUploadFrame.dispose();
			}

			if (value == "Export") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

			if (value == "Stock Upload") {
				try {
					callStockUploadFile();
				} catch (FileNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Check Inventory") {
				try {
					CheckInventory window;
					window = new CheckInventory();
					window.frameInventoryApplication.setVisible(true);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

			if (value == "Load Item Master") {
				switch (mychoice) {
				case "A":
					SaveArticleData();
					break;

				}

			}

			if (value == "Calculate") {
				calculateLength();
			}

			if (value == "Upload CSV File") {
				try {
					callArticleUploadFile();
				} catch (FileNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
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

	private void callArticleUploadFile() throws FileNotFoundException, SQLException, ClassNotFoundException {
		String col[] = { "Srno", "Article", "Name", "shortname", "Pack size", "UOM", "MRP", "Sales Price", "Cost",
				"Tax", "Batch", "HSNCODE", "OpStock", "Batch", "ExpiryDate", "Barcode" ,  "Name Length", "ShortNm Length" };
		String filename = "Article_master_upload.csv";
		selectedfile.setText(filename);
		if (filename.endsWith("csv") || filename.endsWith("csv")) {
			new gnUpload().uploadArticleData(filename);
			mychoice = "A";
		} else {
			new General().msg("Please Check File Format ..Only CSV Files Are Allow");
			new gnImageSound().playAlertSound();
		}
		showData(col, 17);
	}

	private void callStockUploadFile() throws FileNotFoundException, SQLException, ClassNotFoundException {

		new gnUpload().uploadOpStockDatainmain();
		new General().Quickmsg("Stock Uploaded Sucessfully ... Please Check Inventory Module..");

	}

	private void showData(String[] col, int colno) throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		String SQL = "";
		model.setColumnIdentifiers(col);
		table.setModel(model);
		switch (mychoice) {
		case "A":
			SQL = "Select *  from tmp_Article_upload";
			table = new gnTableModel().Tablemodel(table, model, SQL, col, colno, "N", "N", "N");
			break;

		// case "S" :
		// SQL = "Select * from tmp_opStock_upload" ;
		// table = new gnTableModel().Tablemodel(table, model, SQL, col, colno,
		// "N", "N","N") ;
		// break ;
		}
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

	private void SaveArticleData() {
		btnCalculate.doClick();
		String Status = validate();
		if (Status == "Sucess") {
			try {
				new gnUpload().generateArticlecode();
				new gnUpload().insertItemDatatomainproduct();
				showData(col, 17);
				showMasterData();
				// new General().msg("Item Master Data Created sucessfully ");
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	private void showMasterData() throws Throwable {
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

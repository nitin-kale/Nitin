package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.mysql.jdbc.Connection;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class updatePrice extends getResultSet {

	JFrame updatePriceFrame;
	private Connection con1;

	
	JButton btnapply;
	JComboBox comboprice;
	JPanel restoprice;
	
	private String SQL;
 	private String vcode;
	private String vchoice;
	
  	private String vname;
	private String vbrand;
	private String vcategory;
	private String vsubcat;
	private String vgroup;
	private String vsubgroup;
	private String vcomp;
 	private String vstore;
	private String vcompname;
	private String vrole;

	JPanel panel;
	JPanel panel_2;

 
	private JRadioButton rb1000 ;
	private JRadioButton rb1;
	private JRadioButton rb2;
	private JRadioButton rb3;
 	private JRadioButton rb101;
	private JButton btnExport;

	private final ButtonGroup buttonGroup = new ButtonGroup();
 	private JTextField name;
 	private JTextField assignname;
	private JTextField assigncode;
	private JTextField companycode;
	private JTextField Companyname;
	private JButton btnUpdate;
 	private JButton btnAssign;
	private JButton btnAssign_1;
  
	private JLabel lblNewLabel_2;
 	private JLabel lblNewLabel_3;
	private JLabel choicename;

 
	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane jsp;
 	private JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 1 || column == 2 || column == 3) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLACK);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}

			if (column == 6 || column == 7 || column == 8 || column == 9 || column == 10) {
				componentt.setBackground(Color.GRAY);
				componentt.setForeground(Color.WHITE);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}

			if (column == 11 || column == 12 || column == 13 || column == 14) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
				componentt.setFont(new Font("Calibri", Font.BOLD, 16));
			}

			if (column == 0 | column == 1 || column == 2 || column == 3 || column == 4 || column == 5) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLACK);
				componentt.setCursor(getCursor());
				componentt.setVisible(false);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}

			if (Language == "H") {
				if (column == 2 || column == 3) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}
			return componentt;
		}
	};

	private JButton btnAssigntoLine;
	private JButton btnClose;
	private JButton btnClose_1;
	private JRadioButton rb4;
	private JTextField scanitem;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField speffect;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatePrice window = new updatePrice();
					window.updatePriceFrame.setVisible(true);

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
	 * @wbp.parser.entryPoint
	 */
	public updatePrice() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		updatePriceFrame = new JFrame();
		updatePriceFrame.getContentPane().setBackground(new Color(255, 255, 255));
		updatePriceFrame.setAlwaysOnTop(true);
		updatePriceFrame.setBounds(1, 100, 1350, 600);
		updatePriceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updatePriceFrame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)));
		panel.setBounds(12, 30, 1308, 145);
		updatePriceFrame.getContentPane().add(panel);
		panel.setLayout(null);
		ActionListener nm = new nameLsnr();

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Select Option  For Info Update",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(530, 13, 703, 130);
		panel.add(panel_2);
		panel_2.setLayout(null);

		rb1 = new JRadioButton("HSNCODE");
		rb1.setBackground(Color.WHITE);
		rb1.setFont(new Font("Segoe UI", Font.BOLD, 13));
		buttonGroup.add(rb1);
		rb1.setBounds(8, 10, 95, 18);
		panel_2.add(rb1);

		rb2 = new JRadioButton("TAXCODE");
		rb2.setBackground(Color.WHITE);
		rb2.setFont(new Font("Segoe UI", Font.BOLD, 13));
		buttonGroup.add(rb2);
		rb2.setBounds(8, 51, 95, 18);
		panel_2.add(rb2);

		choicename = new JLabel("choice");
		choicename.setForeground(new Color(0, 0, 51));
		choicename.setBounds(160, 32, 202, 16);
		panel_2.add(choicename);
		choicename.setFont(new Font("Segoe UI", Font.BOLD, 13));

		// assignname = new JTextField();7
		assignname = new gnRoundTextField(20);

		assignname.setBounds(157, 48, 176, 28);
		panel_2.add(assignname);
		assignname.setColumns(10);

		assigncode = new JTextField();
		assigncode.setBounds(333, 48, 34, 28);
		panel_2.add(assigncode);
		assigncode.setForeground(Color.GREEN);
		assigncode.setBackground(Color.WHITE);
		assigncode.setEditable(false);
		assigncode.setColumns(10);

		// btnAssigntoLine = new JButton("Assign To Selected Item");
		btnAssigntoLine = new gnRoundButton("Assign To Selected Item");
		btnAssigntoLine.setBackground(new Color(153, 255, 255));
		btnAssigntoLine.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		btnAssigntoLine.setBounds(374, 32, 222, 28);
		panel_2.add(btnAssigntoLine);
		btnAssigntoLine.setMnemonic('I');

		btnAssign = new JButton("Assign  to All");
		btnAssign_1 = new gnRoundButton("Assign  to All");
		btnAssign_1.setBackground(new Color(153, 255, 255));
		btnAssign_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		btnAssign_1.setBounds(374, 63, 222, 28);
		panel_2.add(btnAssign_1);
		btnAssign_1.setMnemonic('A');

		rb3 = new JRadioButton("PACKFORM");
		rb3.setBackground(Color.WHITE);
		rb3.setFont(new Font("Segoe UI", Font.BOLD, 13));
		buttonGroup.add(rb3);
		rb3.setToolTipText("IF Packaging is in BOX And Purcase Will Happend in BOX \r\nor Sales Will Happend In BOX.");
		rb3.setBounds(8, 28, 127, 25);
		panel_2.add(rb3);

		rb4 = new JRadioButton("InnerQty");
		rb4.setBackground(Color.WHITE);
		rb4.setFont(new Font("Segoe UI", Font.BOLD, 13));
		buttonGroup.add(rb4);
		rb4.setToolTipText(
				"Enter Inner Qty Only When Item Is Not PCS, If Pack in Box\r\nFor Example If Pack Type is BOX Then Enter Here HowMuch Qty is then \r\ninside the BOX.");
		rb4.setBounds(8, 68, 95, 25);
		panel_2.add(rb4);

		rb101 = new JRadioButton("Shelf ");
		rb101.setFont(new Font("Segoe UI", Font.BOLD, 13));
		rb101.setBackground(Color.WHITE);
		buttonGroup.add(rb101);
		rb101.setBounds(8, 91, 104, 25);
		panel_2.add(rb101);

		lblNewLabel_6 = new JLabel("Note : Update Other Information If Required Select Option ");
		lblNewLabel_6.setFont(new Font("Segoe UI Semibold", Font.ITALIC, 13));
		lblNewLabel_6.setBounds(114, 101, 482, 16);
		panel_2.add(lblNewLabel_6);

		lblNewLabel_3 = new JLabel("Assign");
		lblNewLabel_3.setBounds(775, 27, 55, 16);
		panel.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(148, 13, 345, 123);
		panel.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(0, 0, 0)));
		panel_1.setLayout(null);

		lblNewLabel_2 = new JLabel("Search Items By Name");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_2.setBounds(28, 58, 218, 16);
		panel_1.add(lblNewLabel_2);

		// name = new JTextField() ;
		name = new gnRoundTextField(20);
		name.setForeground(new Color(0, 0, 153));
		name.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		name.setBounds(28, 74, 218, 28);
		name.addActionListener(nm);
		panel_1.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Scan Item");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_4.setBounds(28, 13, 90, 16);
		panel_1.add(lblNewLabel_4);

		// scanitem = new JTextField()
		scanitem = new gnRoundTextField(20) {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		scanitem.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		scanitem.setBounds(28, 30, 218, 28);
		panel_1.add(scanitem);
		scanitem.setColumns(10);

		JLabel lblNewLabel = new JLabel("Update Item Info");
		lblNewLabel.setBounds(-17, 55, 194, 38);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 153));

		JLabel lblNewLabel_5 = new JLabel(" ");
		lblNewLabel_5.setIcon(new ImageIcon(updatePrice.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_5.setBounds(12, 13, 143, 123);
		panel.add(lblNewLabel_5);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(41, 213, 1291, 329);
		updatePriceFrame.getContentPane().add(jsp);

		// btnUpdate = new JButton("Update");
		btnUpdate = new gnRoundButton("Update");
		btnUpdate.setBackground(new Color(102, 255, 204));
		btnUpdate.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApUpdate.png"));
		btnUpdate.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApUpdate1.png"));
		btnUpdate.setForeground(new Color(0, 0, 153));
		btnUpdate.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnUpdate.setMnemonic('U');
		btnUpdate.setBounds(927, 178, 103, 35);
		updatePriceFrame.getContentPane().add(btnUpdate);

		btnClose = new JButton("Close");
		btnClose_1 = new gnRoundButton("Close");
		btnClose_1.setBackground(new Color(102, 255, 204));
		btnClose_1.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose1.png"));
		btnClose_1.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose.png"));
		btnClose_1.setForeground(new Color(0, 0, 153));
		btnClose_1.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnClose_1.setMnemonic('C');
		btnClose_1.setBounds(1230, 178, 90, 35);
		updatePriceFrame.getContentPane().add(btnClose_1);

		// btnExport = new JButton("Export to Excel");
		btnExport = new gnRoundButton("Export to Excel");
		btnExport.setBackground(new Color(102, 255, 204));
		btnExport.setFont(new Font("Arial Narrow", Font.BOLD, 15));
		btnExport.setBounds(1036, 178, 192, 35);
		updatePriceFrame.getContentPane().add(btnExport);

 
		Companyname = new JTextField();
		Companyname.setBounds(12, 0, 1338, 35);
		updatePriceFrame.getContentPane().add(Companyname);
		Companyname.setFont(new Font("Segoe UI", Font.BOLD, 15));
		Companyname.setForeground(Color.BLACK);
		Companyname.setBackground(Color.WHITE);
		Companyname.setEditable(false);
		Companyname.setColumns(10);

		lblNewLabel_7 = new JLabel(" -");
		lblNewLabel_7.setIcon(new ImageIcon(updatePrice.class.getResource("/RetailProduct/ph40.png")));
		lblNewLabel_7.setBounds(0, 213, 40, 329);
		updatePriceFrame.getContentPane().add(lblNewLabel_7);
		
		rb1000 = new JRadioButton("Copy MRP to SalesPrice");
		rb1000.setBounds(22, 184, 211, 25);
		updatePriceFrame.getContentPane().add(rb1000);
		
		 restoprice = new JPanel();
		restoprice.setBounds(497, 178, 385, 35);
		updatePriceFrame.getContentPane().add(restoprice);
		restoprice.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Add/Sub Price by Rs.");
		lblNewLabel_1.setBounds(0, 3, 140, 16);
		restoprice.add(lblNewLabel_1);
		
		speffect = new JTextField();
		speffect.setBounds(122, 0, 116, 22);
		restoprice.add(speffect);
		speffect.setColumns(10);
 		
		 comboprice = new JComboBox();
		comboprice.setBounds(240, 0, 56, 22);
		restoprice.add(comboprice);
		comboprice.setModel(new DefaultComboBoxModel(new String[] {"+", "-"}));
		
		  btnapply = new JButton("Apply");
		btnapply.setBounds(298, -1, 75, 25);
		restoprice.add(btnapply);

		ActionListener asgn = new assignLsnr();
		ActionListener btn = new btnLsnr();
		assignname.addActionListener(asgn);
		btnUpdate.addActionListener(btn);
		btnClose_1.addActionListener(btn);
		btnExport.addActionListener(btn);
		btnAssigntoLine.addActionListener(btn);
		btnAssign_1.addActionListener(btn);

		ActionListener rb = new rbLsnr();
		rb1.addActionListener(rb);
		rb2.addActionListener(rb);
		rb3.addActionListener(rb);
		rb4.addActionListener(rb);
		rb101.addActionListener(rb);
		ActionListener scnitm = new itemLsnr();
		scanitem.addActionListener(scnitm);
 		ActionListener mprcopyLs = new mrpcopyLsnr();
 		rb1000.addActionListener(mprcopyLs);
 		
 		
 		ActionListener xmprcopyLs = new applyLsnr();
 		btnapply.addActionListener(xmprcopyLs);
 		
 		decorate();

	}

	
	class mrpcopyLsnr implements ActionListener {
 		@Override
		public void actionPerformed(ActionEvent arg0) {
 
 			boolean ischecked = rb1000.isSelected() ;
 			if (ischecked )
 			{
 				int row =  table.getRowCount() ;
 				
 				for (int i=0 ; i < row ; i++) 
 				{
 					table.setValueAt(table.getValueAt(i, 12), i, 11);
 				}
 			}
 			
		}
 	}
	
	
	private void decorate() throws Throwable {
		// btnAssigntoLine.setVisible(false);
		
		restoprice.setVisible(false);
		updatePriceFrame.setUndecorated(true);
		
		scanitem.setText(varticlecode);
		name.setText(this.varticlename);
		showname();

		if (Language == "H") {
			name.setFont(new Font("Shivaji02", Font.PLAIN, 19));
		}
		panel_2.setVisible(true);
		new gnApp().setFrameTitel(updatePriceFrame);
		new gnField().closeform(panel, updatePriceFrame);
		new gnDecorate().DispField_Eatch(assigncode, 12);
		new gnDecorate().DispField_Eatch(assignname, 12);
		new gnDecorate().DispField_Eatch(name, 12);
		new gnDecorate().DispField_Eatch(Companyname, 12);
		//new gnDecorate().DispField_Eatch(companycode, 10);

		vrole = new gnConfig().getRoleName();
		vcomp = new gnConfig().getCompanyCode();
		vcompname = new gnConfig().getCompany();
		//companycode.setText(vcomp);
		Companyname.setText(vcompname);
		if (vcomp == "0") {
			updatePriceFrame.dispose();
			name.setEnabled(false);
			assignname.setEnabled(false);
			assigncode.setEnabled(false);
		}
		if (vrole.toUpperCase() != "MANAGER") {
			updatePriceFrame.dispose();

		}
		
		String verticle = new gnHierarchy().getVerticleCode() ;
		switch(verticle)
		{
			case "3":
			restoprice.setVisible(true);
			break;
			
		}
		
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			// new General().msg(value);

			if (value == "Export to Excel") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

			if (value == "Assign To Selected Item") {
				assignToRow();
			}
			if (value == "Assign  to All") {
				assignToAll();
			}

			if (value == "Update") {
				try {
					UpdateRecords();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Close") {
				updatePriceFrame.dispose();
			}

		}
	}

	class itemLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				showname();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void showname() throws ClassNotFoundException, SQLException {
		String vname = scanitem.getText();
		String vtype = "barcode";
		showArticleData(vname, vtype);

	}

	private String validanameentry() {
		String status = "Sucess";
		String vname = name.getText();
		// if (vname.length() <= 0) {
		// new General().msg("Please Enter Search Name at leat 4 chars..");
		// status = "Fail";
		// name.grabFocus();
		// }
		return status;

	}

	class nameLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			String status = validanameentry();
			if (status == "Sucess") {
				String vname = name.getText();
				vname = "%" + vname + "%";
				try {
					String vtype = "Article";
					showArticleData(vname, vtype);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class rbLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand().trim();
			new General().Quickmsg(value + "   " + "Is selecyed for change records");

			switch (value.trim()) {
			case "HSNCODE":
				vchoice = "1";
				choicename.setText("");
				choicename.setText("Enter HSN CODE HERE");
				assignname.setText("");
				assigncode.setText("");
				assignname.grabFocus();
				break;

			case "Shelf":
				vchoice = "5";
				choicename.setText("");
				choicename.setText("Enter Shelf Info");
				assignname.setText("");
				assigncode.setText("");
				assignname.grabFocus();
				break;

			case "TAXCODE":
				vchoice = "2";
				choicename.setText("");
				choicename.setText("ENTER Tax Code HERE");
				choicename.setForeground(Color.BLUE);
				assignname.setText("");
				assigncode.setText("");
				assignname.grabFocus();
				break;

			case "PACKFORM":
				vchoice = "3";
				choicename.setText("");
				choicename.setText("Press Enter to Select PackForm ");
				choicename.setForeground(Color.BLUE);
				assignname.setText("");
				assigncode.setText("");
				assignname.grabFocus();
				break;

			case "InnerQty":
				vchoice = "4";
				choicename.setText("");
				choicename.setText(" Enter  inner Qty Here ");
				choicename.setForeground(Color.BLUE);
				assignname.setText("");
				assigncode.setText("");
				assignname.grabFocus();
				break;

			}
		}
	}

	class assignLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			showchoice();
		}
	}

	private void showchoice() {
		String sname = assignname.getText();
		sname = "%" + sname + "%";
		switch (vchoice.trim()) {

		case "2":
			try {
				String vtype = "TAX";
				new gnAdmin().showMasterTable(vtype, assigncode, assignname);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {

			}
			break;

		case "5":
			try {
				String vtype = "Shelf";
				new gnAdmin().showMasterTable(vtype, assigncode, assignname);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {

			}
			break;

		case "3":
			try {
				String vtype = "PACK_FORM";
				new gnAdmin().showMasterTable(vtype, assigncode, assignname);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {

			}
			break;

		}
	}

	private void assignToRow() {
		int row = table.getSelectedRow();
		if (row > 0) {
			int i = 0;
			switch (vchoice) {
			case "1":
				table.setValueAt(assignname.getText(), row, 3);
				break;
			case "2":
				table.setValueAt(assignname.getText(), row, 14);
				break;
			case "3":
				table.setValueAt(assigncode.getText(), row, 6);
				break;
			case "4":
				table.setValueAt(assignname.getText(), row, 7);
				break;
			}

		} else {
			new General().msg("No Record Found .. Please Select Article First ..");
		}

	}

	private void assignToAll() {
		int row = table.getRowCount();
		if (row > 0) {
			int i = 0;
			switch (vchoice) {
			case "1":
				for (i = 0; i < row; i++) {
					table.setValueAt(assignname.getText(), i, 3);
				}
				break;
			case "2":
				for (i = 0; i < row; i++) {
					table.setValueAt(assignname.getText(), i, 14);
				}
				break;
			case "3":
				for (i = 0; i < row; i++) {
					table.setValueAt(assigncode.getText(), i, 6);
				}
				break;
			case "4":
				for (i = 0; i < row; i++) {
					table.setValueAt(assignname.getText(), i, 7);
				}

			case "5":
				for (i = 0; i < row; i++) {
					table.setValueAt(assigncode.getText(), i, 15);
				}

			}

		} else {
			new General().msg("No Record Found .. Please Select Article First ..");
		}
	}

	private void showArticleData(String vname, String vtype) throws ClassNotFoundException, SQLException {

		String[] col = { "Article Code", "Name", "Short Name", "HSNCODE", "PkSize", "UOM", "Pur/Sales UOM", "InnerQty",
				"Box-PurPrice", "Box-SalesPrice", "Box-MRP", "SalesPrice", "MRP", "Cost", "Tax code", "Shelf",
				"BatchItem" };
		// String vtype = "Article" ;
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(col);
		vcomp = new gnComp().getCompanycode();
		table.setModel(model);
		String vverticlecode = new gnHierarchy().getVerticleCode();
		// new General().msg(vverticlecode);
		String SQL = "Call  article_getDataForupdate('" + vtype + "', " + vcomp + ", '" + vname + "' , " + vverticlecode
				+ ")";
		// new General().msg(SQL);
		new gnTableModel().Tablemodel(table, model, SQL, col, 17, "N", "N", "N");
		String vmsname = "UOM";
		String vverticle = new gnHierarchy().getVerticleCode();
		String search = "%%";
		String SQL1 = "call master_getMasterData('" + vmsname + "' , " + vverticle + ", '" + search + "' )";
		table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL1)));

		vmsname = "PACK_FORM";
		SQL1 = "call master_getMasterData('" + vmsname + "' , " + vverticle + " , '" + search + "' )";
		table.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(new gnTable().generateBox(SQL1)));

		JViewport prt = new JViewport();
		prt.setBackground(new Color(204, 255, 255));
		prt.add(table, col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		table.requestFocus();
		table.grabFocus();

		table.setSelectionBackground(Color.WHITE);
		table.setSelectionForeground(Color.BLACK);
		new gnTable().setTablewidth(table, 1, 300);
		new gnTable().setTablewidth(table, 2, 300);
		new gnTable().setTablewidth(table, 3, 70);
		new gnTable().setTablewidth(table, 4, 50);
		new gnTable().setTableBasics(table);
		table.setRowHeight(30);
		new gnFontSetting().setMyFont(table, "F1", 16);

	}

	public void UpdateRecords() throws Throwable {

		// String[] col = { "Article Code" , "Name" , "Short Name", "HSNCODE",
		// "PkSize" , "UOM" ,
		// "Pur.Sales UOM" , "InnerQty" , "Box-PurPrice" , "Box-SalesPrice" ,
		// "Box-MRP" ,
		// "SalesPrice" ,"MRP" ,"Cost" , "Tax code" , "Batch-Article", "Shelf"
		// };
		String DBdetail = "Fail";
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		String varticle = "0";
		con1 = (Connection) this.getConnection();
		con1.setAutoCommit(false);
		String article = "Update  msArticle_master  set "
				+ "Name=? ,   pos_name = ? ,    HSNCODE = ? , packSize = ? ,   UOM=? ,  "
				+ " pack_form = ?, purchaseUOM = ? , SalesUOM = ?, "
				+ " inner_pack_Qty = ? , basecost= ? , baseSP=?, baseMrp= ?,  SalesPrice = ?  ,   mrp = ?  , "
				+ "cost = ? ,    Tax_code = ? ,   Tax_Per = ?  , shelf = ? "
				+ " where Company_code = ?   and  article_code = ?";
		try {
			int row = table.getRowCount();
			// new General().Quickmsg("Total Items :" + "" +row);
			for (int k = 0; k < row; k++) {
				varticle = table.getValueAt(k, 0).toString();
				prst = con1.prepareStatement(article);
				prst.setString(1, (table.getValueAt(k, 1).toString()));// Name
				prst.setString(2, (table.getValueAt(k, 2).toString()));// PosName
				prst.setString(3, (table.getValueAt(k, 3).toString()));// HSNCODE
				prst.setString(4, (table.getValueAt(k, 4).toString()));// Pksize
 				prst.setString(5, (table.getValueAt(k, 5).toString()));// UOM
 
 				if (table.getValueAt(k, 5).toString().length() == 0)
 				{
 	 				prst.setString(6, (table.getValueAt(k, 5).toString()));// Pack_form
 					prst.setString(7, (table.getValueAt(k, 5).toString()));// puruom
 					prst.setString(8, (table.getValueAt(k, 5).toString()));// salesuom
 	 				prst.setString(9, "1");// innerQty
  				}
 
				if (table.getValueAt(k, 5).toString().length() > 0)
 				{
 	 				prst.setString(6, (table.getValueAt(k, 6).toString()));// Pack_form
 					prst.setString(7, (table.getValueAt(k, 6).toString()));// puruom
 					prst.setString(8, (table.getValueAt(k, 6).toString()));// salesuom
 	 				prst.setString(9, (table.getValueAt(k, 7).toString()));// innerqty
  				}
 
 				prst.setString(10, (table.getValueAt(k, 8).toString()));// Basecost
				prst.setString(11, (table.getValueAt(k, 9).toString()));// BAsesp
				prst.setString(12, (table.getValueAt(k, 10).toString()));// BAsesp
				prst.setString(13, (table.getValueAt(k, 11).toString()));// sp
				prst.setString(14, (table.getValueAt(k, 12).toString()));// mrp
				prst.setString(15, (table.getValueAt(k, 13).toString()));// cost
				prst.setString(16, (table.getValueAt(k, 14).toString()));// tax
				prst.setString(17, (table.getValueAt(k, 14).toString()));// tax
				prst.setString(18, (table.getValueAt(k, 15).toString()));// shelf
				prst.setString(19, vcomp);// company_code
				prst.setString(20, varticle);// article

				prst.addBatch();
				// new General().msg("PRST"+prst) ;
				TotalRecordinsert = TotalRecordinsert + 1;
				DBdetail = "Fail";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			con1.rollback();
			DBdetail = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}

			if (DBdetail == "Sucess") {
				con1.commit();
				syncStockArticle();
				new gnImageSound().playSound();
				new General().Quickmsg("Data Updated Sucessfully");
				new gnTable().RemoveTableRows(model);
				new gnImageSound().playSound();
				name.grabFocus();
				// updatePriceFrame.dispose();
			}
		}

	}

	private void syncStockArticle() throws Throwable {

		String[] col = { "Article Code", "Name", "Short Name", "HSNCODE", "PkSize", "UOM", "Pur/Sales UOM", "InnerQty",
				"Box-PurPrice", "Box-SalesPrice", "Box-MRP", "SalesPrice", "MRP", "Cost", "Tax code" };

		int row = table.getRowCount();
		for (int i = 0; i < row; i++) {

			String varticle = table.getValueAt(i, 0).toString();
			String vmrp = table.getValueAt(i, 12).toString();
			String vcost = table.getValueAt(i, 13).toString();
			String vSP = table.getValueAt(i, 11).toString();
			String vtax = table.getValueAt(i, 14).toString();
			String VLC = new gnMath().getLandingCost(vcost, vtax);
			String vverticle = new gnHierarchy().getVerticleCode();
			String vstore = new gnConfig().getStoreID();
			String vgrnDate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
			new ApplySalesPrice_Action().SalesPriceInsert(vstore, varticle, vgrnDate, vmrp, vSP, vcost, vcomp,
					vverticle, VLC);
		}

		String vfinyear = new gnFinYear().getReportingFinYear();
		String vloc = "SL";
		String vcomp = new gnConfig().getCompanyCode();
		String vstore = new gnConfig().getStoreID();
		// new General().msg(vstore);

		// String vverticlecode = new
		// getConfigurationSetting().getVerticleCode(new
		// gnPublicVariable().vcomp,new gnPublicVariable().vstore);
		// String SQL7 = "call SalesPrice_updateInsert("+vcomp+", "+vstore+" ,
		// "+vverticlecode+")" ;
		// this.getSPResult(SQL7) ;

		// Sync Stock in Tablle for Article master
		// String SQL5 = "call Stock_syncStockArticle("+vcomp+", "+vstore+"
		// ,'"+vloc+"' , '"+vfinyear+"' , "+vverticlecode+")";
		// this.getSPResult(SQL5) ;
		// Sync Stock in Tablle for Article master

		// Sync Ean Master Table
		// String SQL55 = "call EAN_InsertEan("+vcomp+")";
		// this.getSPResult(SQL55) ;

	}

	
	
class applyLsnr implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent arg0) {
 	
 		
 		int choice = new General().msgInput("Are you Sure(Once Changes Apply then can not revert) ?");
 
 		if (choice == 0 )
 		{
 			restoAddSubFunction() ;
 		}
 	}
 }


private void restoAddSubFunction()
{
	
	String vtype = comboprice.getSelectedItem().toString();
	switch(vtype)
	{
	case "+" :
		addprice();
		break;
	case "-" :
		subprice();
		break;
 	}
	
}


private void addprice()
{
	
	//String[] col = { "Article Code", "Name", "Short Name", "HSNCODE", "PkSize", "UOM", 
	//		"Pur/Sales UOM", "InnerQty","Box-PurPrice", "Box-SalesPrice", "Box-MRP", 
	//		"SalesPrice", "MRP", "Cost", "Tax code", "Shelf", "BatchItem" };
	
	double tablevalue =0.0;
	double vspeffect = Double.parseDouble(speffect.getText());
	int row = table.getRowCount();
	for(int i =0 ; i <row ; i++)
	{
		tablevalue= Double.parseDouble(table.getValueAt(i, 11).toString());
		tablevalue = tablevalue+vspeffect;
		table.setValueAt(tablevalue, i, 11);
		table.setValueAt(tablevalue, i, 12);
		
	}
	
}


private void subprice()
{

	
	double tablevalue =0.0;
	double vspeffect = Double.parseDouble(speffect.getText());
	int row = table.getRowCount();
	for(int i =0 ; i <row ; i++)
	{
		tablevalue= Double.parseDouble(table.getValueAt(i, 11).toString());
		tablevalue = tablevalue-vspeffect;
		table.setValueAt(tablevalue, i, 11);
		table.setValueAt(tablevalue, i, 12);
		
	}
 }


	
}// Last

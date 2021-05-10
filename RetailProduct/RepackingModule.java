package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.jidesoft.swing.ComboBoxSearchable;
import com.mysql.jdbc.Connection;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.border.MatteBorder;

public class RepackingModule extends getResultSet {

	private Connection con1, con3;
	JFrame RepackingFrame;
	
	private JPanel dispPanel;

	Connection con2;
 	private String DBhdr;
	private String vcomp;
	private String vstore;
	private String varticlecode;
	private String vtrfdate;
	private String vtrfno;
	private String vfinyear;
	private String DBdetail;
	private String vreqdate = "";
	private String vreqno = "0";


	JComboBox parentcombo;
	private JComboBox fromloc;
	private JComboBox toloc;
	JComboBox combo3;

	private JTextField parentcode;
	private JTextField parentname;
	private JTextField childcode;
	private JTextField childname;
	private JTextField processloss;
	private JTextField parentStock;
	private JTextField requestdate;
	private JTextField requestno;
 	private JTextField requestno3;
  	private JTextField requestdate3;
	private JTextField parentissueqty;
	private JTextField reqBulkQty;
	private JTextField issueBulkStock;
	private JTextField childRequiredQty;

	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_14;

	private JButton btnShowReq;
	private JButton btnPrice;
	private JButton btnClose ;
	JButton btnIssue;
	JButton btnSave;
	JButton btnGenerate;
	JButton btnShowChild;
	JButton btnSaveChild;
	JButton btnSaveReceipts;
	JButton btnShow;
	JButton btnAdd;
	JButton btnReceiveStock;

 
 	ActionListener comboParent;

 
  
	JScrollPane jsp1;
	JScrollPane jsp2;
	JScrollPane jsp3;
	JScrollPane jsp22;
	JScrollPane jsp23;
	JScrollPane jsp4;

	JTable table1 = new JTable();
	JTable table2 = new JTable();
	JTable table22 = new JTable();
	JTable table23 = new JTable();
	JTable table3 = new JTable();
  	JTable table4 = new JTable();

  	DefaultTableModel model4 = new DefaultTableModel();
 	DefaultTableModel model1 = new DefaultTableModel();
	DefaultTableModel model2 = new DefaultTableModel();
	DefaultTableModel model22 = new DefaultTableModel();
	DefaultTableModel model23 = new DefaultTableModel();
	DefaultTableModel model3 = new DefaultTableModel();

	
	private String Col[] = { "Remove", "Article", "Name", "UOM", "Cost", "SalesPrice", "MRP", "Bal.Qty", "From Loc.",
			"TrfQty", "TO Loc.", "Batch Article", "BatchNO", "Manuf.Date", "Expiry date" };

	private String BulkCol[] = { "Remove", "Article", "Name", "UOM", "Cost", "SalesPrice", "MRP", "Bal.Qty",
			"From Loc.", "Bulk-TrfQty", "TO Loc.", "Batch Article", "BatchNO", "Manuf.Date", "Expiry date" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RepackingModule window = new RepackingModule();
					window.RepackingFrame.setVisible(true);
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
	public RepackingModule() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		RepackingFrame = new JFrame();
		RepackingFrame.getContentPane().setBackground(new Color(102, 255, 255));
		RepackingFrame.setBackground(Color.WHITE);
		RepackingFrame.setAlwaysOnTop(true);
		//RepackingFrame.setBounds(1, 1, 1350, 750);
		RepackingFrame.setBounds(1, 100, 1350, 600);
 		RepackingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		RepackingFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Repacking Module");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(207, 0, 834, 40);
		RepackingFrame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(RepackingModule.class.getResource("/RetailProduct/mymainlogo_5.png")));
		lblNewLabel_1.setBounds(0, 0, 152, 161);
		RepackingFrame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setIcon(new ImageIcon(RepackingModule.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel_2.setBounds(152, 0, 868, 40);
		RepackingFrame.getContentPane().add(lblNewLabel_2);

		JTabbedPane tabpane = new JTabbedPane(JTabbedPane.TOP);
		tabpane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.ORANGE, new Color(0, 0, 153),
				new Color(0, 255, 102), new Color(0, 51, 153)));
		tabpane.setBounds(1, 165, 1310, 422);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new LineBorder(Color.GREEN, 4, true));
		panel1.setBackground(Color.WHITE);
		panel1.setBounds(1, 1, 1350, 750);
		tabpane.add("Maintain Child Articles", panel1);
		panel1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Select Parent Article");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(12, 27, 145, 16);
		panel1.add(lblNewLabel_3);

		parentcode = new JTextField();
		parentcode.setEditable(false);
		parentcode.setBounds(157, 24, 48, 28);
		panel1.add(parentcode);
		parentcode.setColumns(10);

		parentname = new JTextField();
		parentname.setBounds(204, 24, 288, 28);
		panel1.add(parentname);
		parentname.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Select Child Code");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(31, 56, 126, 16);
		panel1.add(lblNewLabel_4);

		childcode = new JTextField();
		childcode.setEditable(false);
		childcode.setBounds(157, 53, 48, 28);
		panel1.add(childcode);
		childcode.setColumns(10);

		childname = new JTextField();
		childname.setBounds(204, 53, 287, 28);
		panel1.add(childname);
		childname.setColumns(10);

		jsp1 = new JScrollPane();
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(12, 90, 1277, 285);
		panel1.add(jsp1);

		// btnShow = new JButton("Show Child Articles");
		// btnShow.setBounds(504, 27, 158, 25);
		// panel1.add(btnShow);

		btnSaveChild = new JButton("Save");
		btnSaveChild.setMnemonic('S');
		btnSaveChild.setBounds(986, 52, 97, 25);
		panel1.add(btnSaveChild);

		JLabel lblNewLabel_9 = new JLabel("Process Loss%");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_9.setBounds(513, 27, 107, 16);
		panel1.add(lblNewLabel_9);

		processloss = new JTextField();
		processloss.setBounds(615, 24, 56, 22);
		panel1.add(processloss);
		processloss.setColumns(10);

		JPanel panel2 = new JPanel();
		panel2.setBorder(
				new BevelBorder(BevelBorder.RAISED, Color.MAGENTA, Color.RED, Color.WHITE, new Color(51, 102, 204)));
		panel2.setBounds(1, 1, 1350, 750);
		tabpane.add("Generate Repacking Requirement", panel2);
		panel2.setLayout(null);

		btnGenerate = new JButton("Generate Child Item Requirment List");
		btnGenerate.setBounds(12, 28, 239, 25);
		panel2.add(btnGenerate);

		jsp2 = new JScrollPane();
		jsp2.setToolTipText("Child Item Requirement List ");
		jsp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp2.setBounds(12, 66, 1277, 187);
		panel2.add(jsp2);

		btnSave = new JButton("Save");
		btnSave.setBounds(1192, 13, 97, 40);
		panel2.add(btnSave);

		jsp22 = new JScrollPane();
		jsp22.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp22.setBounds(22, 286, 1267, 89);
		panel2.add(jsp22);

		parentcombo = new JComboBox();
		parentcombo.setForeground(new Color(0, 0, 102));
		parentcombo.setEditable(true);
		parentcombo.setFont(new Font("Tahoma", Font.BOLD, 14));
		AutoCompleteDecorator.decorate(parentcombo);
		parentcombo.setBounds(263, 26, 412, 31);
		panel2.add(parentcombo);

		JLabel lblNewLabel_10 = new JLabel("Filter By Parent Article");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_10.setBounds(263, 9, 177, 16);
		panel2.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Parent Article Stock");
		lblNewLabel_11.setBounds(677, 9, 127, 16);
		panel2.add(lblNewLabel_11);

		parentStock = new JTextField();
		parentStock.setBounds(677, 26, 127, 30);
		panel2.add(parentStock);
		parentStock.setColumns(10);

		btnShowChild = new JButton("Show Child Items");
		btnShowChild.setBounds(812, 28, 142, 25);
		panel2.add(btnShowChild);

		JLabel lblNewLabel_16 = new JLabel("Issue Parent Stock");
		lblNewLabel_16.setBounds(1046, 260, 121, 16);
		panel2.add(lblNewLabel_16);

		parentissueqty = new JTextField();
		parentissueqty.setToolTipText("Parent Stock Required For Child Article Repacking");
		parentissueqty.setFont(new Font("Tahoma", Font.BOLD, 14));
		parentissueqty.setBounds(1156, 257, 86, 22);
		panel2.add(parentissueqty);
		parentissueqty.setColumns(10);

		JLabel lblNewLabel_17 = new JLabel("KG");
		lblNewLabel_17.setBounds(1245, 260, 56, 16);
		panel2.add(lblNewLabel_17);

		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		panel3.setBounds(1, 1, 1350, 750);
		tabpane.add("Process  Requirement", panel3);
		panel3.setLayout(null);

		btnIssue = new JButton("Issue Stock to Repacking Location");
		btnIssue.setBounds(0, 37, 233, 25);
		panel3.add(btnIssue);

		jsp3 = new JScrollPane();
		jsp3.setBounds(0, 62, 1301, 190);
		jsp3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel3.add(jsp3);

		btnReceiveStock = new JButton("Receive Child Stock");
		btnReceiveStock.setBounds(1118, 0, 183, 25);
		panel3.add(btnReceiveStock);

		combo3 = new JComboBox();
		combo3.setBounds(731, 27, 160, 22);
		panel3.add(combo3);

		lblNewLabel_14 = new JLabel("Request No");
		lblNewLabel_14.setBounds(516, 10, 74, 16);
		panel3.add(lblNewLabel_14);

		requestno3 = new JTextField();
		requestno3.setBounds(584, 7, 99, 22);
		panel3.add(requestno3);
		requestno3.setColumns(10);

		lblNewLabel_15 = new JLabel("Request Date");
		lblNewLabel_15.setBounds(468, 40, 110, 16);
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
		panel3.add(lblNewLabel_15);

		requestdate3 = new JTextField();
		requestdate3.setBounds(582, 37, 101, 22);
		panel3.add(requestdate3);
		requestdate3.setColumns(10);

		btnSaveReceipts = new JButton("Save Received Qty");
		btnSaveReceipts.setBounds(1118, 26, 183, 25);
		panel3.add(btnSaveReceipts);

		fromloc = new JComboBox();
		fromloc.setBounds(245, 38, 118, 22);
		panel3.add(fromloc);

		toloc = new JComboBox();
		toloc.setBounds(375, 38, 110, 22);
		panel3.add(toloc);

		JLabel lblNewLabel_19 = new JLabel("Receive Repacked Items");
		lblNewLabel_19.setBounds(934, 9, 176, 16);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_19.setForeground(Color.DARK_GRAY);
		panel3.add(lblNewLabel_19);

		JLabel lblNewLabel_18 = new JLabel(" ");
		lblNewLabel_18.setBounds(695, 0, 606, 59);
		lblNewLabel_18.setIcon(new ImageIcon(RepackingModule.class.getResource("/RetailProduct/panel7.png")));
		panel3.add(lblNewLabel_18);

		jsp4 = new JScrollPane();
		jsp4.setBounds(0, 281, 1301, 107);
		jsp4.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel3.add(jsp4);

		btnShowReq = new JButton("Show Request");
		btnShowReq.setBounds(1150, 318, 151, 25);
		panel3.add(btnShowReq);

		dispPanel = new JPanel();
		dispPanel.setBounds(10, 254, 992, 22);
		dispPanel.setBackground(Color.WHITE);
		dispPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GREEN));
		panel3.add(dispPanel);
		dispPanel.setLayout(null);

		JLabel lblNewLabel_22 = new JLabel("Bulk Qty Required");
		lblNewLabel_22.setBounds(12, 0, 124, 16);
		dispPanel.add(lblNewLabel_22);

		reqBulkQty = new JTextField();
		reqBulkQty.setText("0");
		reqBulkQty.setBounds(126, -3, 95, 25);
		dispPanel.add(reqBulkQty);
		reqBulkQty.setColumns(10);

		JLabel lblNewLabel_23 = new JLabel("Issue Bulk Stock");
		lblNewLabel_23.setBounds(264, 0, 107, 16);
		dispPanel.add(lblNewLabel_23);

		issueBulkStock = new JTextField();
		issueBulkStock.setText("0");
		issueBulkStock.setBounds(360, 0, 80, 22);
		dispPanel.add(issueBulkStock);
		issueBulkStock.setColumns(10);

		JLabel lblNewLabel_24 = new JLabel("Child Required Qty");
		lblNewLabel_24.setBounds(490, 3, 116, 16);
		dispPanel.add(lblNewLabel_24);

		childRequiredQty = new JTextField();
		childRequiredQty.setText("0");
		childRequiredQty.setBounds(611, 0, 116, 22);
		dispPanel.add(childRequiredQty);
		childRequiredQty.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("Issue Bulk Item Stock For Repacking \u25BC");
		lblNewLabel_20.setBounds(739, 1, 247, 16);
		dispPanel.add(lblNewLabel_20);

		btnPrice = new JButton("Assign Price To Child");
		btnPrice.setBounds(991, 318, 160, 25);
		panel3.add(btnPrice);

		tabpane.setIconAt(0, new ImageIcon(RepackingModule.class.getResource("/RetailProduct/mymainIcon3.ico")));
		tabpane.setBackgroundAt(0, Color.WHITE);
		RepackingFrame.getContentPane().add(tabpane);

		JLabel lblNewLabel_5 = new JLabel(" ");
		lblNewLabel_5.setIcon(new ImageIcon(RepackingModule.class.getResource("/RetailProduct/repacking.jpg")));
		lblNewLabel_5.setBounds(1019, 0, 301, 161);
		RepackingFrame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("1. Link All Child Article With Parent Product ");
		lblNewLabel_6.setForeground(new Color(0, 0, 102));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(183, 75, 351, 16);
		RepackingFrame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel(
				"2. Generate Repacking Items Requirement. Please Note-> If Child Item Is Not Link With Parent No Requirement Will Be Generated");
		lblNewLabel_7.setForeground(new Color(0, 0, 102));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(183, 92, 837, 16);
		RepackingFrame.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel(
				"3. Issue  Parent(Bulk) Product To Repacking Location For Repacking (Internal Process)");
		lblNewLabel_8.setForeground(new Color(0, 0, 102));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_8.setBounds(183, 110, 511, 16);
		RepackingFrame.getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_12 = new JLabel("Repacking Request Date");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_12.setBounds(176, 46, 164, 16);
		RepackingFrame.getContentPane().add(lblNewLabel_12);

		requestdate = new JTextField();
		requestdate.setBounds(338, 43, 116, 22);
		RepackingFrame.getContentPane().add(requestdate);
		requestdate.setColumns(10);

		JLabel lblNewLabel_13 = new JLabel("Request No");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_13.setBounds(478, 46, 79, 16);
		RepackingFrame.getContentPane().add(lblNewLabel_13);

		requestno = new JTextField();
		requestno.setBounds(562, 43, 116, 22);
		RepackingFrame.getContentPane().add(requestno);
		requestno.setColumns(10);

		JLabel lblNewLabel_21 = new JLabel("4.After Repackig Receive Repacked Item in Main Location for Sales");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_21.setForeground(new Color(0, 0, 102));
		lblNewLabel_21.setBounds(183, 136, 438, 16);
		RepackingFrame.getContentPane().add(lblNewLabel_21);
		
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClose.setIcon(new ImageIcon(RepackingModule.class.getResource("/RetailProduct/delete.png")));
		btnClose.setBounds(868, 121, 152, 40);
		RepackingFrame.getContentPane().add(btnClose);

		ActionListener mysave = new lsbtnSave();
 		ActionListener mygenerate = new lsbtnGenerate();
		ActionListener mysavechild = new lsbtnSaveChild();
		ActionListener myissue = new lsbtnIssue();
 		ActionListener myclosebtn = new lsBtnLsnrClose() ;
		
		btnIssue.addActionListener(myissue);
		btnSave.addActionListener(mysave);
        btnClose.addActionListener(myclosebtn);   
		btnSaveChild.addActionListener(mysavechild);
		btnGenerate.addActionListener(mygenerate);

		ActionListener lsname1 = new lsname();
		parentname.addActionListener(lsname1);

		ActionListener lschildname1 = new lschildname();
		childname.addActionListener(lschildname1);

		ActionListener comboParent = new comboLsnr();
	    parentcombo.addActionListener(comboParent);

		ActionListener showChildLs = new LsShowChild();
		btnShowChild.addActionListener(showChildLs);

		ActionListener btnreceive = new lsReceive();
		btnReceiveStock.addActionListener(btnreceive);

		ActionListener btnreceipt = new lsbtnReceivedStock();
		btnSaveReceipts.addActionListener(btnreceipt);

		ActionListener lsReqdt = new requestListener();
		requestdate3.addActionListener(lsReqdt);

		ActionListener lsshowreq = new lsShowReq();
		btnShowReq.addActionListener(lsshowreq);

		ActionListener lsprice = new lsPrice();
		btnPrice.addActionListener(lsprice);

		decorate();

	}

	// Start code here

	class lsPrice implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			int row = table4.getSelectedRow();
			if (row >= 0) {
				calculateAndAssignChildPrices(row);
			}
		}
	}

	private void decorate() throws Throwable {
		
		RepackingFrame.setUndecorated(true);
		
		dispPanel.setVisible(false);
		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStorecode();
		vfinyear = new gnFinYear().getReportingFinYear();
		btnIssue.setVisible(false);
		btnReceiveStock.setVisible(false);
		btnSaveReceipts.setVisible(false);

		showRequest();

		new gnApp().setFrameTitel(RepackingFrame);
		fromloc.setVisible(false);
		toloc.setVisible(false);
		combo3.setVisible(false);

		requestdate.setText(new General().getBegindate());

		String verticle = new gnHierarchy().getVerticleCode();
		String vmsname = "Location";
		String search = "%%";
		String SQL1 = "call master_getMasterData('" + vmsname + "' , " + verticle + ", '" + search + "')";
		new gnComp().fillCombo(SQL1, fromloc);
		new gnComp().fillCombo(SQL1, toloc);

	}

	private void addchildtoTable() throws ClassNotFoundException, SQLException {
		String[] colLink = { "Remove", "Parent", "Parent Name", "PKSIZE", "UOM", "Process Loss", "ChildCode", "Name",
				"PKSIZE", "UOM" };
		model1.setColumnIdentifiers(colLink);
		String vpcode = parentcode.getText();
		String vccode = childcode.getText();
		String vpname = parentname.getText();
		String vcname = childname.getText();
		String vprocessloss = processloss.getText();

		String ppksize = new gnArticle().Article_getData(vpcode, "packsize");
		String puom = new gnArticle().Article_getData(vpcode, "UOM");
		String cpksize = new gnArticle().Article_getData(vccode, "packsize");
		String cuom = new gnArticle().Article_getData(vccode, "UOM");

		model1.insertRow(0,
				new Object[] { "", vpcode, vpname, ppksize, puom, vprocessloss, vccode, vcname, cpksize, cuom });
		table1.setModel(model1);
		removeRow(model1, table1);
		JViewport jvp1 = new JViewport();
		jvp1.add(table1);
		jsp1.setViewport(jvp1);
		jsp1.setVisible(true);

	}

	class lsname implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String vname = "%" + parentname.getText() + "%";
			try {
				String sname = parentname.getText().trim();
				sname = "%" + sname + "%";
				String vType = "Article";
				String vtrantype = "POS";
				String varticle = "";
				new gnAdmin().SearchBulkArticle(vType, sname, varticle, vtrantype);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				parentcode.setText(new gnAdmin().rArticle);
				parentname.setText(new gnAdmin().rArticlename);
				try {
					showChildArticle();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class lschildname implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String vname = "%" + childname.getText() + "%";
			try {
				String sname = childname.getText().trim();
				sname = "%" + sname + "%";
				String vType = "Article";
				String vtrantype = "POS";
				String varticle = "";
				new gnAdmin().Search(vType, sname, varticle, vtrantype);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				childcode.setText(new gnAdmin().rArticle);
				childname.setText(new gnAdmin().rArticlename);
				// String vstatus = validate() ;
				String vstatus = "Sucess";
				if (vstatus == "Sucess") {
					try {
						addchildtoTable();
						childname.setText(null);
						childcode.setText(null);
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
						new General().msg(e1.getLocalizedMessage());
					}
				}
			}
		}
	}

	private void showChildArticle() throws ClassNotFoundException, SQLException {
		String[] colLink = { "Remove", "Parent", "Parent Name", "PKSIZE", "UOM", "Process Loss", "ChildCode", "Name",
				"PKSIZE", "UOM" };
		String varticle = parentcode.getText();
		String vtype = "GetChildArticles";
		String SQL = "Call repack_getData( '" + vtype + "' , " + vcomp + " , " + vstore + " , '" + varticle + "' ,  "
				+ vreqno + " , '" + vreqdate + "')";
		table1 = new gnTableModel().Tablemodel(table1, model1, SQL, colLink, 9, "Y", "N", "N");
		removeRow(model1, table1);
		JViewport jvp1 = new JViewport();
		jvp1.add(table1);
		jsp1.setViewport(jvp1);
		jsp1.setVisible(true);
	}

	class lsbtnSaveChild implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				saveChildArticle();
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	
	private void saveChildArticle() throws Throwable {
		new gnLogger().loggerDebugEntry("Repacking Data", "Start Inserting rows");
		String vparentcode = parentcode.getText();
		String SQL = "Delete from bulk_conversion_template where company_code = " + vcomp + " and  site_code = "
				+ vstore + " and parentcode = '" + vparentcode + "' ";
		this.getResult(SQL);
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con2 = (Connection) this.getConnection();
		con2.setAutoCommit(false);
		String Status = "Fail";
		String poshdr = "Insert into bulk_conversion_template(company_code , "
				+ "site_code,  Parentcode , Parentname , ParentPksize , ParentUOM , ProcessLoss ,"
				+ " Childcode , Childname , childpksize , childUOM)" + "values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			int row = table1.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con2.prepareStatement(poshdr);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, table1.getValueAt(k, 1).toString());
				prst.setString(4, table1.getValueAt(k, 2).toString());
				prst.setString(5, table1.getValueAt(k, 3).toString());
				prst.setString(6, table1.getValueAt(k, 4).toString());
				prst.setString(7, table1.getValueAt(k, 5).toString());
				prst.setString(8, table1.getValueAt(k, 6).toString());
				prst.setString(9, table1.getValueAt(k, 7).toString());
				prst.setString(10, table1.getValueAt(k, 8).toString());
				prst.setString(11, table1.getValueAt(k, 9).toString());
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBhdr = "Fail";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBhdr = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DBhdr = "Sucess";
			}
		} catch (SQLException e) {
			con2.rollback();
			DBhdr = "Fail";
			new General().msg(e.getLocalizedMessage());
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") {
				con2.commit();
				con2.close();
				new General().Quickmsg("Data Saved Sucessfully.. ");
			}
		}
	}//// insert end

	// ======TAbbled 2

	class lsbtnGenerate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String varticle = "0";
				generateRequirementList();
				showAllChildRequirment();
				fillcombo(parentcombo);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	private void generateRequirementList() throws ClassNotFoundException, SQLException {
		// new General().Quickmsg("Colleccting Data for Processing ...");
		String vtype = "updateChildInfo";
		String varticle = "0";
		String SQL = "call repack_getData('" + vtype + "' , " + vcomp + " , " + vstore + " , '" + varticle + "' ,  "
				+ vreqno + " , '" + vreqdate + "')";
		this.getSPResult(SQL);

	}

	private void showNowChildRequirment(String varticle) throws ClassNotFoundException, SQLException {
		String vtype = "GetChildRequirement";
		String SQL = "call repack_getData('" + vtype + "' , " + vcomp + " , " + vstore + "  , " + varticle + " ,  "
				+ vreqno + " , '" + vreqdate + "')";
		showChildRequirement(SQL);
	}

	private void showAllChildRequirment() throws ClassNotFoundException, SQLException {
		String vtype = "GetAllChildRequirement";
		String varticle = "0";
		String SQL = "call repack_getData('" + vtype + "' , " + vcomp + " , " + vstore + "  , " + varticle + " , "
				+ vreqno + " , '" + vreqdate + "')";
		showChildRequirement(SQL);
	}

	private void fillcombo(JComboBox mycombo) throws ClassNotFoundException, SQLException {
		String SQL = "select  distinct(ParentName) as name, ParentCode  from bulk_conversion_template order by ParentName ";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			mycombo.addItem(rs.getString(1));
		}
	}

	class LsShowChild implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vname = parentcombo.getSelectedItem().toString().trim();
			String varticle = "Code"; // nitin  "Name" Change to code
			try {
				String varticlecode = new gnArticle().Article_getData(varticle, vname);
				parentStock.setText(Double.toString(new gnStockcheck().getArticleStock(varticlecode, "SL")));
				if (Double.parseDouble(parentStock.getText()) <= 0) {
					parentStock.setBackground(Color.RED);
					parentStock.setForeground(Color.WHITE);
					new gnImageSound().playAlertSound();
				} else {
					parentStock.setBackground(Color.white);
					parentStock.setForeground(Color.BLACK);
				}
				showNowChildRequirment(varticlecode);
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}

		}
	}

	class comboLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnShowChild.doClick();
		}
	}

	private void showChildRequirement(String SQL) throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model2);
		String[] colLink = { "Remove", "Parent", "Parent Name", "PKSIZE", "UOM", "Process Loss", "ChildCode", "Name",
				"PKSIZE", "UOM", "MBQ", "STOCK", "Required Qty" };
		table2 = new gnTableModel().Tablemodel(table2, model2, SQL, colLink, 12, "Y", "N", "N");
		removeRow(model2, table2);
		JViewport jvp2 = new JViewport();
		jvp2.add(table2);
		jsp2.setViewport(jvp2);
		jsp2.setVisible(true);
	}

	
    class  	lsBtnLsnrClose implements ActionListener {
 		@Override
		public void actionPerformed(ActionEvent arg0) {
  			RepackingFrame.dispose();
		}
     }
    
     
    
	class lsbtnSave implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String status = validate2();
 				if (status == "Sucess") {
					String vreqno = new gnSeq().getSeqno("52", "TR");
					requestno.setText(vreqno);
					new General().msg("Repacking Request No :" + " " + vreqno);
					saveRequest();
				}
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	
	
	
	private String validate2() {
		String status = "Sucess";
		if (table22.getRowCount() == 0) {
			new General().Quickmsg("No Data Available...Please Add Data For Repacking");
			new gnImageSound().playAlertSound();
			status = "Fail";
		}
		status = checkStock();
		status = checkIssueQtyandStock();
		return status;
	}

	private String checkStock() {
		String status = "Sucess";
		if (Double.parseDouble(parentStock.getText()) <= 0) {
			new General().Quickmsg(
					" No Parent Article Stock Available To Process Request..Please check Or Purchase Parent Article");
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			status = "Fail";
		}
		return status;
	}

	private String checkIssueQtyandStock() {
		calculateIssueStockRequirement();
		String status = "Sucess";
		if (Double.parseDouble(parentissueqty.getText()) > Double.parseDouble(parentStock.getText())) {
			new General().msg("Stock Requirement is Higher Then  Balance Parenet Article Stock");
			status = "Fail";
		}
		return status;
	}

	private void calculateIssueStockRequirement() {

		// new General().msg("Checking Issue qty and available Stock ");

		String vuom = "";
		Double vpksize = 0.00;
		double vrequiredqty = 0.00;
		double vissueqty = 0.0;
		double vkgqty = 0.0;
		double vgmqty = 0.0;
		double vgmtokg = 0.0;
		// String[] colLink = { "Remove" , "Parent" , "Parent Name" , "PKSIZE" ,
		// "UOM" , "Process Loss", "ChildCode" , "Name" , "PKSIZE" , "UOM" ,
		// "MBQ" , "STOCK", "Required Qty"} ;
		int row = table2.getRowCount();
		if (row > 0) {
			for (int i = 0; i <= row - 1; i++) {
				vuom = table2.getValueAt(i, 9).toString();
				vrequiredqty = Double.parseDouble(table2.getValueAt(i, 12).toString());
				vpksize = Double.parseDouble(table2.getValueAt(i, 8).toString());
				switch (vuom) {
				case "KG":
					vkgqty = vkgqty + (vpksize * vrequiredqty);
					break;
				case "GM":
					vgmqty = vgmqty + (vpksize * vrequiredqty);
				}
			}
			vgmtokg = (vgmqty * 1 / 1000);
			vissueqty = vgmtokg + vkgqty;
			// new General().msg("Issue Qty to Repack Location for Parenet
			// Article is " + ""+vissueqty);
			parentissueqty.setText(Double.toString(vissueqty));
		}
	}

	private void saveRequest() throws Throwable {
		// String[] colLink = { "Remove" , "Parent" , "Parent Name" , "PKSIZE" ,
		// "UOM" , "Process Loss", "ChildCode" , "Name" ,
		// "PKSIZE" , "UOM" , "MBQ" , "STOCK", "Required Qty"} ;
		String vrequestno = requestno.getText();
		String vrequestdate = new gnConfig().date_ConverttoDBforamt(requestdate.getText());
		new gnLogger().loggerDebugEntry("Repacking Request Data Inserting ", "Start Inserting Rows");
		String vparentcode = parentcode.getText();
		String SQL = " Delete from repacking_requirement where company_code = " + vcomp + " and  site_code = " + vstore
				+ "  and Requestno = " + vrequestno + "   and Requestdate  = '" + vrequestdate + "' ";
		// new General().msg(SQL);
		this.getResult(SQL);
		prst = null;
		final int batchSize = 1;
		int TotalRecordinsert = 0;
		con2 = (Connection) this.getConnection();
		con2.setAutoCommit(false);
		String Status = "Fail";
		String poshdr = "Insert into repacking_requirement(company_code, " + "site_code ,  requestno , requestdate,    "
				+ "Parentcode , Parentname , ParentPksize , ParentUOM , ProcessLoss ,"
				+ "Childcode , Childname , childpksize , childUOM , childmbq , childStock , requiredChildQty,parentStock, "
				+ "ParentIssueQty, IssueUOM, status)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
		try {
			int row = table2.getRowCount();
			for (int k = 0; k < row; k++) {
				double vrequredqty = Double.parseDouble(table2.getValueAt(k, 12).toString());
				if (vrequredqty > 0) {
					prst = con2.prepareStatement(poshdr);
					prst.setString(1, vcomp);
					prst.setString(2, vstore);
					prst.setString(3, vrequestno);
					prst.setString(4, vrequestdate);
					prst.setString(5, table2.getValueAt(k, 1).toString());
					prst.setString(6, table2.getValueAt(k, 2).toString());
					prst.setString(7, table2.getValueAt(k, 3).toString());
					prst.setString(8, table2.getValueAt(k, 4).toString());
					prst.setString(9, table2.getValueAt(k, 5).toString());
					prst.setString(10, table2.getValueAt(k, 6).toString());
					prst.setString(11, table2.getValueAt(k, 7).toString());
					prst.setString(12, table2.getValueAt(k, 8).toString());
					prst.setString(13, table2.getValueAt(k, 9).toString());
					prst.setString(14, table2.getValueAt(k, 10).toString());
					prst.setString(15, table2.getValueAt(k, 11).toString());
					prst.setString(16, table2.getValueAt(k, 12).toString());
					prst.setString(17, parentStock.getText());
					prst.setString(18, parentissueqty.getText());
					prst.setString(19, "KG");
					prst.setString(20, "O");
					prst.addBatch();
					TotalRecordinsert = TotalRecordinsert + 1;
					DBhdr = "Fail";
					if (++TotalRecordinsert % batchSize == 0) {
						prst.executeBatch();
						DBhdr = "Sucess";
					}
					prst.executeBatch(); // insert remaining records
					DBhdr = "Sucess";
				}
			}
		} catch (SQLException e) {
			con2.rollback();
			DBhdr = "Fail";
			new General().msg(e.getLocalizedMessage());
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (DBhdr == "Sucess") {
				con2.commit();
				con2.close();
				new General().Quickmsg("Request Saved  Sucessfully.. ");
				new gnSeq().updateSeqno("52", "TR");
				reset2();
				showRequest();

			}
		}
	}//// insert end

	private void reset2() {
		requestno.setText(null);
		new gnTable().RemoveTableRows(model22);
		parentStock.setText(null);
	}

	// Tabbed 3
	class requestListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			performRequestAction();
		}
	}

	private void performRequestAction() {
		try {
			btnReceiveStock.doClick();
			// btnReceiveStock.setVisible(true);
			btnSaveReceipts.setVisible(true);
			String vpara811 = "811";
			String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
					vstore);
			switch (vmaintainbatchforNonBatchItem) {
			case "N":
				IssueBulkLocationTransfer();
				// btnIssue.setVisible(true);
				break;
			case "Y":
				btnIssue.setVisible(false);
				// IssueBulkLocationTransfer() ;
				Batch_IssueBulkLocationTransfer();
				break;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void Batch_IssueBulkLocationTransfer() throws Throwable {
		String vfromloc = fromloc.getSelectedItem().toString();
		String vtoloc = toloc.getSelectedItem().toString();
		String varticle = "0";
		vreqno = requestno3.getText();
		vreqdate = new gnConfig().date_ConverttoDBforamt(requestdate3.getText());
		String Col[] = { "Remove", "Article", "Name", "UOM", "Cost", "SalesPrice", "MRP", "Bal.Qty", "From Loc.",
				"BulkTrfQty", "TO Loc.", "Batch Article", "BatchNO", "Manuf.Date", "Expiry date", "Status" };
		String vtype = "Batch_IssueStockForRequest";
		String SQL = "call repack_getData('" + vtype + "' , " + vcomp + " , " + vstore + "  , " + varticle + "  , "
				+ vreqno + " , '" + vreqdate + "')";
		// new General().msg(SQL);
		// receiveChildRequirement(SQL , Col , 15);
		batchBulkArticleToissueStock(SQL, Col, 15);
		reqBulkQty.setText(new gnRepacking().getBulkIssueQty(vreqno, requestdate3.getText()));

		int row = table4.getRowCount();
		table4.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification7);
		for (int i = 0; i <= row - 1; i++) {
			table4.setValueAt("SL", i, 8);
			table4.setValueAt("Repack", i, 10);
			table4.setValueAt("0", i, 15);
			String vstatus = "C";
			String vissuestatus = "I";
			// reqBulkQty.setText(table4.getValueAt(i, 9).toString());
			issueBulkStock.setText(table4.getValueAt(i, 9).toString());
			// childRequiredQty
		}
	}

	private void IssueBulkLocationTransfer() throws Throwable {
		String vfromloc = fromloc.getSelectedItem().toString();
		String vtoloc = toloc.getSelectedItem().toString();
		String varticle = "0";
		vreqno = requestno3.getText();
		vreqdate = new gnConfig().date_ConverttoDBforamt(requestdate3.getText());
		String Col[] = { "Remove", "Article", "Name", "UOM", "Cost", "SalesPrice", "MRP", "Bal.Qty", "From Loc.",
				"Bulk-TrfQty", "TO Loc.", "Batch Article", "BatchNO", "Manuf.Date", "Expiry date", "Status" };
		String vtype = "IssueStockForRequest";
		String SQL = "call repack_getData('" + vtype + "' , " + vcomp + " , " + vstore + "  , " + varticle + "  , "
				+ vreqno + " , '" + vreqdate + "')";
		// receiveChildRequirement(SQL , Col , 15);
		batchBulkArticleToissueStock(SQL, Col, 15);
		reqBulkQty.setText(new gnRepacking().getBulkIssueQty(vreqno, requestdate3.getText()));
		//
		int row = table4.getRowCount();
		table4.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification7);
		for (int i = 0; i <= row - 1; i++) {
			table4.setValueAt("SL", i, 8);
			table4.setValueAt("Repack", i, 10);
			table4.setValueAt("0", i, 15);
			String vstatus = "C";
			String vissuestatus = "I";
			issueBulkStock.setText(table4.getValueAt(i, 9).toString());
			// issueBulkStock
			// childRequiredQty
		}
		//
	}

	private void ReceiveBulkLocationTransfer() throws ClassNotFoundException, SQLException {

		String varticle = "0";
		vreqno = requestno3.getText();
		vreqdate = new gnConfig().date_ConverttoDBforamt(requestdate3.getText());
		String Col[] = { "Remove", "Parent Code", "Name", "UOM", "Repacked Article", "Repacked Name", "Pk.Size", "UOM",
				"Cost", "SalesPrice", "MRP", "Request Qty.", "From Loc.", "Repacked Qty", "TO Loc.", "Batch Article",
				"BatchNO", "Manuf.Date", "Expiry date", "Status" };
		String vtype = "ReceiveStockForRequest";
		String SQL = "call repack_getData('" + vtype + "' , " + vcomp + " , " + vstore + "  , " + varticle + "  , "
				+ vreqno + " , '" + vreqdate + "')";
		receiveChildRequirement(SQL, Col, 19);
		// int row = table4.getRowCount() ;
		int row = table3.getRowCount();
		for (int i = 0; i <= row - 1; i++) {
			table3.setValueAt("Repack", i, 12);
			table3.setValueAt("SL", i, 14);
			String vstatus = "C";
			new gnTable().setTableColWidth(table3, 2, 175);
			new gnTable().setTableColWidth(table3, 5, 175);
			if (table3.getValueAt(i, 19).toString().trim().equalsIgnoreCase("C")) {
				table3.setBackground(Color.darkGray);
				table3.setForeground(Color.WHITE);
				btnSaveReceipts.setVisible(false);
			} else {
				// btnReceiveStock.setVisible(true);
				btnSaveReceipts.setVisible(true);
				table3.setBackground(Color.WHITE);
				table3.setForeground(Color.BLUE);
			}
		}
	}

	private void receiveChildRequirement(String SQL, String[] col, int colno)
			throws ClassNotFoundException, SQLException {
		// new General().msg(SQL);
		new gnTable().RemoveTableRows(model3);
		table3 = new gnTableModel().Tablemodel(table3, model3, SQL, col, colno, "Y", "N", "N");
		removeRow(model3, table3);
		JViewport jvp3 = new JViewport();
		jvp3.add(table3);
		jsp3.setViewport(jvp3);
		jsp3.setVisible(true);
	}

	private void batchBulkArticleToissueStock(String SQL, String[] col, int colno)
			throws ClassNotFoundException, SQLException {
		// new General().msg(SQL);
		new gnTable().RemoveTableRows(model4);
		String vtypenew = "BulkItem";
		table4 = new gnTableModel().Tablemodel(table4, model4, SQL, col, colno, "N", "Y", vtypenew);
		// removeRow(model4, table4) ;
		JViewport jvp4 = new JViewport();
		jvp4.add(table4);
		jsp4.setViewport(jvp4);
		jsp4.setVisible(true);
		table4.repaint();
		table4.grabFocus();
		table4.setEditingRow(0);
		table4.repaint();
		int row = 0;
		calculateAndAssignChildPrices(row);
	}

	public CellEditorListener ChangeNotification7 = new CellEditorListener() {
		public void editingCanceled(ChangeEvent e) {
		}

		public void editingStopped(ChangeEvent e) {
			// int row = table.getSelectedRow() ;
			// String vchoice = table.getValueAt(row, 0).toString().trim();
			// String value = (String) table.getValueAt(row, 4);//nitin
			// System.out.println(vchoice);
			Double v = new gnTable().getTotal(table4, 9);
			issueBulkStock.setText(Double.toString(v));
			btnPrice.doClick();
			// childRequiredQty
		}
	};

	class lsReceive implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				ReceiveBulkLocationTransfer();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	class lsbtnReceivedStock implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String Status = "Sucess";
			// new General().msg("SAving Data Now...");
			try {
				Status = validateTransafers();
				if (Status == "Sucess") {
					iisuebulkArticletoReduceStock(); // Bulk article posting for
														// stock reduce and
														// posting to recpackign
														// location
					String vpara811 = "811";
					String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811,
							vcomp, vstore);
					switch (vmaintainbatchforNonBatchItem) {
					case "Y":
						GenerateNewBatchForChildItems();
						new gnLogger().loggerInfoEntry("Child Item Posting", "New  Batch no Generated for Child items");
					}

					receiveStockinmainLocation();
					receivestockToInsert();
					requestno3.setText(null);
					requestdate3.setText(null);
				} // If

			} catch (SQLException e) {
				e.printStackTrace();
				new gnLogger().loggerInfoEntry("Child Item Posting", e.getLocalizedMessage());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				new gnLogger().loggerInfoEntry("Child Item Posting", e.getLocalizedMessage());
			} catch (Throwable e) {
				e.printStackTrace();
				new gnLogger().loggerInfoEntry("Child Item Posting", e.getLocalizedMessage());
			}
		}
	}

	private void GenerateNewBatchForChildItems() throws Throwable {
		int row = table3.getRowCount();
		String vbatchno = "";
		for (int i = 0; i < row; i++) {
			vbatchno = new gnBatch().getNewBatch();
			table3.setValueAt(vbatchno, i, 16);
		}
	}

	private void receiveStockinmainLocation() throws SQLException, ClassNotFoundException {
		String vstatus = "C";
		String vreceiveddate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
		int row = table3.getRowCount();
		for (int i = 0; i <= row - 1; i++) {
			String vqty = table3.getValueAt(i, 13).toString();
			String vchildArticle = table3.getValueAt(i, 4).toString();
			String SQL = "Update repacking_requirement set receivedQty = " + vqty + " , receivedDate =  '"
					+ vreceiveddate + "' ,  " + "status = '" + vstatus + "'   where company_code =  " + vcomp
					+ " and site_code = " + vstore + "   and childcode = " + vchildArticle + "   and requestno = "
					+ vreqno + "  " + "and requestdate = '" + vreqdate + "'     ";
			this.getResult(SQL);
		}
		// new General().msg("Data Updated Sucessfully...");
		// new gnTable().RemoveTableRows(model3);
	}

	private void receivestockToInsert() throws Throwable {
		String vstatus = CheckReceivedBatchArticle();
		if (vstatus == "Sucess")
			;
		{
			vtrfdate = new gnConfig().date_ConverttoDBforamt(requestdate3.getText());
			vtrfno = new gnSeq().getLoctrfNo();
			int vvtrfno = Integer.parseInt(vtrfno);
			// new General().msg("Child Location Transfer Number is :" +"
			// "+vtrfno);
			if (vvtrfno > 0) {
				insertLocTransferReceived();
			} else {
				new General().msg("<Check For Location Transfer Number..> Number Not Generated");
				new gnImageSound().playAlertSound();
				return;
			}
		}
	}

	class lsbtnIssue implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// PrepareToInsert() ;
				// iisuebulkArticletoReduceStock() ;
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	private void iisuebulkArticletoReduceStock() throws Throwable {
		// new General().msg("Issue Stock to Repack Location") ;
		// new General().Quickmsg("Bulk Stock Posting ..Starts");
		new gnLogger().loggerInfoEntry("Bulk Item Posting",
				"Bulk item Stock Posting to Repack and Reduce from Main Starts ");
		PrepareToInsert();
		new gnLogger().loggerInfoEntry("Bulk Item Posting",
				"Bulk item Stock Posting to Repack and Reduce from Main Starts ");
		// new General().Quickmsg("Bulk Stock Posting ..Ends");
	}

	private String validateTransafers() throws Throwable {
		// new General().msg("Validation Starts Now==>" );
		String status = "Fail";
		String vpara811 = "811";
		String vstatus = "";
		String vcheck = "Sucess";

		int talerow3 = table3.getRowCount();
		int talerow4 = table4.getRowCount();

		if (talerow3 == 0 || talerow4 == 0) {
			new General().msg("No Records Available  To  Save .. ");
			vcheck = "Fail";
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
		}

		if (vcheck == "Sucess") {
			String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
					vstore);
			switch (vmaintainbatchforNonBatchItem) {
			case "N":
				vstatus = CheckBatchArticle();
				vcheck = validateTransfer();
				break;

			case "Y":
				vstatus = CheckBatchArticle();
				vcheck = validateTransfer();
				break;
			}

			if (vstatus == "Sucess" && vcheck == "Sucess") {
				status = "Sucess";
			}
			new General().Quickmsg("Validation Status ==>" + status);
		}
		return status;
	}

	private String validateTransfer() {
		reqBulkQty.setForeground(Color.blue);
		reqBulkQty.setBackground(Color.white);
		String mainresult = "Sucess";
		String result = "Sucess";
		double vbalqty = 00.00;
		double vtrfqty = 00.00;
		int rw = table4.getRowCount();
		double vbulkeqqty = Double.parseDouble(reqBulkQty.getText());
		double vbulkissueqty = Double.parseDouble(issueBulkStock.getText());
		if (vbulkissueqty < vbulkeqqty) {
			reqBulkQty.setBackground(Color.black);
			reqBulkQty.setForeground(Color.white);
			new General().msg("Please Check Issue Bulk Issue Stock ");
			result = "Fail";
			switch (result) {
			case "Fail":
				mainresult = "Fail";
			}
		}

		if (vbulkissueqty > vbulkeqqty) {
			new General().msg("Please Check Issue Bulk  Stock & Rerquired Stock");
			reqBulkQty.setBackground(Color.black);
			reqBulkQty.setForeground(Color.white);
			result = "Fail";
			switch (result) {
			case "Fail":
				mainresult = "Fail";
			}
		}

		for (int i = 0; i < rw; i++) {
			vtrfqty = Double.parseDouble(table4.getValueAt(i, 9).toString());
			vbalqty = Double.parseDouble(table4.getValueAt(i, 7).toString());
			String varticle = (table4.getValueAt(i, 1).toString());
			if (Double.toString(vtrfqty) == "") {
				result = "Fail";
				switch (result) {
				case "Fail":
					mainresult = "Fail";
				}
				new General().msg("Please Insert Bulk Stock to Consume ..");
			}

			if (vtrfqty > vbalqty) {
				result = "Fail";
				switch (result) {
				case "Fail":
					mainresult = "Fail";
				}
				new General().msg("Transfer Qty Can not be > Bal.Stock  Please Check For Article ==>" + "" + varticle);
			}
		}
		return mainresult;
	}

	private void PrepareToInsert() throws Throwable {
		String vpara811 = "811";
		try {
			vtrfdate = new gnConfig().date_ConverttoDBforamt(requestdate3.getText());
			vtrfno = new gnSeq().getLoctrfNo();
			int vvtrfno = Integer.parseInt(vtrfno);
			// new General().msg("Bulk Location Transfer Number is :" +"
			// "+vtrfno);
			if (vvtrfno > 0) {
				String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp,
						vstore);
				switch (vmaintainbatchforNonBatchItem) {
				case "N":
					// insertLocTransfer() ;
					insertLocTransferForBatch();
					break;
				case "Y":
					insertLocTransferForBatch();
					break;
				}
			}
		} catch (Exception w) {
			new General().msg(w.getLocalizedMessage());
			w.printStackTrace();
		}
	}

	public void insertLocTransferForBatch() throws Throwable {

		prst = null;
		int vbatchSize = table4.getRowCount();
		final int batchSize = vbatchSize;
		int TotalRecordinsert = 0;
		String vmanufdt = "0";
		String vexpdate = "0";
		con3 = (Connection) this.getConnection();
		con3.setAutoCommit(false);
		String Col[] = { "Remove", "Parent Code", "Name", "UOM", "Repacked Article", "Repacked Name", "Pk.Size", "UOM",
				"Cost", "SalesPrice", "MRP", "Request Qty.", "From Loc.", "Repacked Qty", "TO Loc.", "Batch Article",
				"BatchNO", "Manuf.Date", "Expiry date", "Status" };

		String prdetail = "Insert into  locationtransfer(Company_code , Site_code  ,"
				+ "Trf_date  ,  Article_code  ,  cost,    mrp,      salesPrice ,    bal_qty ,"
				+ "From_loc,    trf_qty,    to_loc,      batchArticle , batchno,    manuf_date,    expiry_date, srno, trf_no , "
				+ "finyear , RepackingReqNo , RepackingDate , UserId , Time)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// {"Remove" , 1"Article",2 "Name" , 3"UOM" , 4"Cost" , 5"SalesPrice" ,
		// 6 "MRP" ,
		// 7 "Bal.Qty" , 8 "From Loc." , 9 "Tramsfer Qty" , 10"TO Loc." ,
		// 11"Batch Article" ,
		// 12 "BatchNO" , 13 "Manuf.Date" , 14 "Expiry date" } ;
		try {
			int row = table4.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con3.prepareStatement(prdetail);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vtrfdate);
				prst.setString(4, (table4.getValueAt(k, 1).toString()));
				prst.setString(5, (table4.getValueAt(k, 4).toString()));
				prst.setString(6, (table4.getValueAt(k, 6).toString()));
				prst.setString(7, (table4.getValueAt(k, 5).toString()));
				prst.setString(8, (table4.getValueAt(k, 7).toString()));
				prst.setString(9, (table4.getValueAt(k, 8).toString()));
				prst.setString(10, (table4.getValueAt(k, 9).toString()));
				prst.setString(11, (table4.getValueAt(k, 10).toString().trim()));
				prst.setString(12, (table4.getValueAt(k, 11).toString()));
				prst.setString(13, (table4.getValueAt(k, 12).toString()));
				String vbatcharticle = (table4.getValueAt(k, 11).toString());
				switch (vbatcharticle) {
				case "Y":
					prst.setString(14, new gnConfig().date_ConverttoDBforamt((table4.getValueAt(k, 13).toString())));
					prst.setString(15, new gnConfig().date_ConverttoDBforamt((table4.getValueAt(k, 14).toString())));
					break;
				case "N":
					prst.setString(14, "0000.00.00");
					prst.setString(15, "0000.00.00");
					break;
				}
				prst.setInt(16, k);
				prst.setString(17, vtrfno);
				prst.setString(18, vfinyear);
				prst.setString(19, requestno3.getText());
				prst.setString(20, new gnConfig().date_ConverttoDBforamt(requestdate3.getText()));
				prst.setString(21, new General().getUsercode());
				prst.setString(22, new General().getTime());
				prst.addBatch();
				// new General().msg("Prst For Bulk Stock Entry in Location
				// Trf"+ prst);
				TotalRecordinsert = TotalRecordinsert + 1;
				DBdetail = "Sucess";
				if (TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
				}
				prst.executeBatch();
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg("Detail Error" + e.getMessage());
			System.out.println(e.getLocalizedMessage());
			con3.rollback();
			DBdetail = "Fail";
		} finally {
			if (DBdetail == "Sucess") {
				con3.commit();
				con3.close();
				reduceinv();
			}
			if (prst != null) {
				prst.close();
			}
		}
	}

	private void reduceinv() throws Throwable {

		String vtrntype = "FromLoc";
		String SQL = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype + "',   " + vtrfno + " , '"
				+ vtrfdate + "'  , '" + vfinyear + "')";
		this.getSPResult(SQL);

		String vtrntype1 = "ToLoc";
		String SQL1 = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   " + vtrfno + " , '"
				+ vtrfdate + "' , '" + vfinyear + "')";
		this.getSPResult(SQL1);

		/// Stock for batch updated
		String vtrntype2 = "FromLoc";
		String SQL2 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype2 + "',   " + vtrfno + " , '"
				+ vtrfdate + "' , '" + vfinyear + "')";
		this.getSPResult(SQL2);

		String vtrntype3 = "ToLoc";
		String SQL3 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype3 + "',   " + vtrfno + " , '"
				+ vtrfdate + "' , '" + vfinyear + "')";
		this.getSPResult(SQL3);
		// new gnTable().RemoveTableRows(model3);

		//// For Non Batch Items
		String vpara811 = "811";
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			vtrntype2 = "FromLoc";
			SQL2 = "call Inv_impact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vtrntype2 + "',   " + vtrfno
					+ " , '" + vtrfdate + "' , '" + vfinyear + "')";
			this.getSPResult(SQL2);
			break;
		}

		vpara811 = "811";
		vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			vtrntype3 = "ToLoc";
			SQL3 = "call Inv_impact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vtrntype3 + "',   " + vtrfno
					+ " , '" + vtrfdate + "' , '" + vfinyear + "')";
			this.getSPResult(SQL3);
			break;
		}
		updateIssueStatus();
		new General().msg("Data Saved Sucessfully");
	}

	private void updateIssueStatus() throws SQLException {
		String vstatus = "I";
		String SQL = "Update repacking_requirement set    status = '" + vstatus + "'  " + "where company_code =  "
				+ vcomp + " and site_code = " + vstore + " and requestno = " + vreqno + "  " + "and requestdate = '"
				+ vreqdate + "'     ";
		this.getResult(SQL);

	}

	public String CheckBatchArticle() {
		String Action = "Sucess";
		int rw = table3.getRowCount();
		String vbatch = " ";
		String vExp = "";
		String vbatchno = " ";
		String varticle = "";
		for (int k = 0; k < rw; k++) {
			vbatch = table3.getValueAt(k, 11).toString();
			vExp = table3.getValueAt(k, 14).toString();
			vbatchno = table3.getValueAt(k, 12).toString();
			varticle = table3.getValueAt(k, 1).toString();
			switch (vbatch) {
			case "Y":
				switch (vExp) {
				case "0":
					new General().msg("Enter Batch no and Expiry Date for Item Code " + varticle);
					Action = "Fail";
				}
			}
		}
		return Action;
	}// Method End

	// ====Nitin Receive Repacked Items

	public String CheckReceivedBatchArticle() {
		String Action = "Sucess";
		int rw = table3.getRowCount();
		String vbatch = " ";
		String vExp = "";
		String vbatchno = " ";
		String varticle = "";
		for (int k = 0; k < rw; k++) {
			vbatch = table3.getValueAt(k, 15).toString();
			vExp = table3.getValueAt(k, 18).toString();
			vbatchno = table3.getValueAt(k, 16).toString();
			varticle = table3.getValueAt(k, 4).toString();
			switch (vbatch) {
			case "Y":
				switch (vExp) {
				case "0":
					new General().msg("Enter Batch no and Expiry Date for Item Code " + varticle);
					Action = "Fail";
				}
			}
		}
		return Action;
	}// Method End

	public void insertLocTransferReceived() throws Throwable {
		prst = null;
		int vbatchSize = table3.getRowCount();
		final int batchSize = vbatchSize;
		int TotalRecordinsert = 0;
		String vmanufdt = "0";
		String vexpdate = "0";
		con3 = (Connection) this.getConnection();
		con3.setAutoCommit(false);
		// String Col[] = {"Remove" ,1 "Parent Code",2 "Name" , 3"UOM" ,
		// 4"Repacked Article" ,5 "Repacked Name" ,6 "Pk.Size", 7"UOM",
		// 8"Cost" ,9"SalesPrice" , 10"MRP" ,
		// 11"Request Qty." ,12"From Loc." , 13"Repacked Qty" ,14 "TO Loc." ,15
		// "Batch Article" ,
		// 16"BatchNO" , 17"Manuf.Date" ,18 "Expiry date" , 19"Status"} ;
		String prdetail = "Insert into  locationtransfer(Company_code , Site_code  ,"
				+ "Trf_date  ,  Article_code  ,  cost,    mrp,      salesPrice ,    bal_qty ,"
				+ "From_loc,    trf_qty,    to_loc,      batchArticle , batchno,    manuf_date,    expiry_date, srno, trf_no , "
				+ "finyear , RepackingReqNo , RepackingDate , userid , time)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?)";
		try {
			int row = table3.getRowCount();
			for (int k = 0; k < row; k++) {
				prst = con3.prepareStatement(prdetail);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vtrfdate);
				prst.setString(4, (table3.getValueAt(k, 4).toString()));
				prst.setString(5, (table3.getValueAt(k, 8).toString()));
				prst.setString(6, (table3.getValueAt(k, 10).toString()));
				prst.setString(7, (table3.getValueAt(k, 9).toString()));
				prst.setString(8, "0"); // Bal Qty of child
				prst.setString(9, (table3.getValueAt(k, 12).toString()));
				prst.setString(10, (table3.getValueAt(k, 13).toString()));
				prst.setString(11, (table3.getValueAt(k, 14).toString()));
				prst.setString(12, (table3.getValueAt(k, 15).toString()));
				prst.setString(13, (table3.getValueAt(k, 16).toString()));

				String vbatcharticle = (table3.getValueAt(k, 15).toString());
				switch (vbatcharticle) {
				case "Y":
					prst.setString(14, new gnConfig().date_ConverttoDBforamt((table3.getValueAt(k, 17).toString())));
					prst.setString(15, new gnConfig().date_ConverttoDBforamt((table3.getValueAt(k, 18).toString())));

					break;
				case "N":
					prst.setString(14, "0000.00.00");
					prst.setString(15, "0000.00.00");
					break;
				}
				prst.setInt(16, k);
				prst.setString(17, vtrfno);
				prst.setString(18, vfinyear);
				prst.setString(19, requestno3.getText());
				prst.setString(20, new gnConfig().date_ConverttoDBforamt(requestdate3.getText()));
				prst.setString(21, new General().getUsercode());
				prst.setString(22, new General().getTime());
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBdetail = "Sucess";
				if (TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBdetail = "Sucess";
				}
				prst.executeBatch();
				DBdetail = "Sucess";
			}
		} catch (SQLException e) {
			new General().msg("Detail Error" + e.getMessage());
			System.out.println(e.getLocalizedMessage());
			con3.rollback();
			DBdetail = "Fail";
		} finally {
			if (DBdetail == "Sucess") {
				con3.commit();
				con3.close();
				updateStockinMainLocation();
			}
			if (prst != null) {
				prst.close();
			}
		}
	}

	private void updateStockinMainLocation() throws Throwable {
		String vtrntype1 = "ToLoc";
		String SQL1 = "call Inv_impact(" + vcomp + " , " + vstore + ",  '" + vtrntype1 + "',   " + vtrfno + " , '"
				+ vtrfdate + "' , '" + vfinyear + "')";
		// new General().msg(SQL1);
		this.getSPResult(SQL1);

		/// Stock for batch updated
		String vtrntype3 = "ToLoc";
		String SQL3 = "call Inv_impact_batch(" + vcomp + " , " + vstore + ",  '" + vtrntype3 + "',   " + vtrfno + " , '"
				+ vtrfdate + "' , '" + vfinyear + "')";
		this.getSPResult(SQL3);
		// new General().msg("Data Saved Sucessfully");

		String vpara811 = "811";
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			vtrntype3 = "ToLoc";
			SQL3 = "call Inv_impact_NonbatchItems(" + vcomp + " , " + vstore + ",  '" + vtrntype3 + "',   " + vtrfno
					+ " , '" + vtrfdate + "' , '" + vfinyear + "')";
			this.getSPResult(SQL3);
			break;
		}

		// updateIssueStatus() ;
		new gnTable().RemoveTableRows(model3);
		new gnTable().RemoveTableRows(model4);
		issueBulkStock.setText("0");
		reqBulkQty.setText("0");
		// new General().msg("Data Saved Sucessfully");

	}

	private void reset() {
		new gnTable().RemoveTableRows(model1);
		parentcode.setText(null);
		issueBulkStock.setText("0");
		reqBulkQty.setText("0");
		parentname.setText(null);
		childcode.setText(null);
		childname.setText(null);
		processloss.setText(null);
		new gnImageSound().playSound();
	}

	class lsShowReq implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			try {
				showRequest();
				new gnTable().RemoveTableRows(model3);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void showRequest() throws Throwable {
		//dispPanel.setVisible(false);
		String SQL = "";
		String[] vreqcol = { "Type", "Req.No", "Req.date", "Bulk Item", "Status" };
		String vtype = "GetRequestData";
		String varticle = "";
		SQL = "Call repack_getData( '" + vtype + "' , " + vcomp + " , " + vstore + " , '" + varticle + "' ,  " + vreqno
				+ " , '" + vreqdate + "')";
		new gnTable().RemoveTableRows(model4);
		vtype = "Request";
		table4 = new gnTableModel().Tablemodel(table4, model4, SQL, vreqcol, 4, "N", "Y", vtype);
		JViewport jvp4 = new JViewport();
		jvp4.add(table4);
		jsp4.setViewport(jvp4);
		jsp4.setVisible(true);
		table4.grabFocus();
		selectRequestRow();
	}

	public void selectRequestRow() {
		table4.requestFocus();
		table4.grabFocus();
		table4.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table4.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table4.getSelectedRow();
				String value = (String) table4.getValueAt(row, 0).toString().trim();
				try {
					if (value == "Request") {
						requestno.setText(table4.getValueAt(row, 1).toString());
						requestno3.setText(table4.getValueAt(row, 1).toString());
						requestdate3.setText(table4.getValueAt(row, 2).toString());
						performRequestAction();
						dispPanel.setVisible(true);
						String vpara811 = "811";
						String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811,
								vcomp, vstore);
						switch (vmaintainbatchforNonBatchItem) {
						case "N":
							// btnIssue.setVisible(true);
							btnReceiveStock.setVisible(false);
							btnSaveReceipts.setVisible(true);
							break;
						case "Y":
							btnIssue.setVisible(false);
							btnReceiveStock.setVisible(false);
							// btnReceiveStock.setVisible(true);
							btnSaveReceipts.setVisible(true);
							break;
						}
					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
		table4.removeAll();
	}

	private void calculateAndAssignChildPrices(int bulkrow) {
		table4.setEditingRow(0);
		table4.grabFocus();
		double bulkcost = 0;
		double bulksp = 0;
		double bulkmrp = 0;

		double vpergmprice = 0;
		String vvpergmprice = "0";
		String bulkuom = table4.getValueAt(bulkrow, 3).toString();
		bulkcost = Double.parseDouble(table4.getValueAt(bulkrow, 4).toString());
		bulkmrp = Double.parseDouble(table4.getValueAt(bulkrow, 6).toString());
		bulksp = Double.parseDouble(table4.getValueAt(bulkrow, 5).toString());

		int col = 8;
		vvpergmprice = new gnRepacking().calculatePerGMPrice(bulkcost);
		applyChildPricesonTable(vvpergmprice, col);

		col = 10;
		vvpergmprice = new gnRepacking().calculatePerGMPrice(bulkmrp);
		applyChildPricesonTable(vvpergmprice, col);

		col = 9;
		vvpergmprice = new gnRepacking().calculatePerGMPrice(bulksp);
		applyChildPricesonTable(vvpergmprice, col);

	}

	private void applyChildPricesonTable(String vpergmvalue, int tablecol) {
		double vpergmprice = Double.parseDouble(vpergmvalue);
		double vchilpksize = 0;
		String vchilduom = "";
		double childcost = 0;
		double childsp = 0;
		double childmrp = 0;
		double vmysetvalue = 0;

		int row = table3.getRowCount();
		for (int i = 0; i < row; i++) {
			vchilpksize = Double.parseDouble(table3.getValueAt(i, 6).toString());
			vchilduom = table3.getValueAt(i, 7).toString();

			switch (vchilduom) {
			case "KG":
				vmysetvalue = (1000 * vpergmprice) * vchilpksize;
				table3.setValueAt(vmysetvalue, i, tablecol);
				break;

			case "GM":
				vmysetvalue = vchilpksize * vpergmprice;
				table3.setValueAt(vmysetvalue, i, tablecol);
				break;
			}
		}
	}

	public void removeRow(DefaultTableModel xmodel, JTable xtable) {
		// new General().msg("I REached Here ") ;
		String vauthallow = "N";
		DefaultTableModel modelName = xmodel;
		JTable tableName = xtable;
		TableColumn Del = tableName.getColumnModel().getColumn(0);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setSelected(false);
		chkbox.setVisible(true);
		chkbox.setMargin(new Insets(0, 16, 0, 0));
		chkbox.setIconTextGap(0);
		chkbox.setBackground(new Color(255, 255, 255, 0));
		chkbox.setText("");
		new gnLogger().loggerInfoEntry("POS", "Remove Item From Sales Table  ");
		Del.setCellRenderer(new DefaultTableCellRenderer() {
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
					boolean hasFocus, int row, int column) {
				Del.setCellEditor(new DefaultCellEditor(chkbox));
				return chkbox;
			}
		});

		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int nn = e.getStateChange();
				int lastrow = tableName.getRowCount();
				if (lastrow > 0) {
					int r = tableName.getSelectedRow();
					int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
					if (option == 0) {
						if (vauthallow == "Y") {
							Authorize window = new Authorize();
							window.frameauth.setVisible(true);
							window.frameauth.setAlwaysOnTop(true);
							modelName.removeRow(r);
							new gnLogger().loggerInfoEntry("POS", "Remove Item From Sales Table  Row" + " " + r);
						}
						modelName.removeRow(r);
						new gnLogger().loggerInfoEntry("POS",
								"Recalculating Billing Data After Row Remove Row No" + " " + r);
						new gnLogger().loggerInfoEntry("POS", "Article Billing Process Over");
					}
				}
				return;
			}
		});
	}
}// Last

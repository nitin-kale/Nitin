 package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.mysql.jdbc.Connection;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class ProductionOrder  extends getResultSet{

	JFrame prodOrderFrame;
	Connection con1, con2;
	private String DBdetail;
	private String DBhdr;
	//
	
	String vinvno ;
	String vsalestype; 
	String vinvtype ;
	String vglcode ;
	String vpostingtype = "Y";
	String vcustomer; 
	String vuser ;
	String vinvdate; 
	String vterminal; 
	String vtime  ;
	String vverticle; 
	String vnetamount; 
	String vcreditDays; 
	String vpaytype = "Due";

	//
 	private JTextField templatename;
	private JTextField qty;
	private JTextField rate;
	JButton btnSave;
	JButton btnClose;
  	JComboBox comboUOM;
 	JScrollPane jsp ;
 	JButton btnReceipt ;
    String EditMode ;
 	String vcomp ;
 	String vstore ;
 	JComboBox comboFinishItem ;
  	String vallow;
  	String vfinishArticlecode ;
 	String vmaterailArticlecode ;
 	
 	DefaultTableModel fmodel  = new DefaultTableModel() {
  		@Override
		public boolean isCellEditable(int row, int column) {
 			try {
 					return column == 1 || column == 2 || column == 3 || column == 4   ? false : true;
  			} catch (Throwable e) {
 				e.printStackTrace();
			}
			return false;
  		}
	};

  			
 			
 	JTable ftable = new JTable() ;
 	JScrollPane fjsp ;
 	  	
 	DefaultTableModel model  = new DefaultTableModel() {
  		@Override
		public boolean isCellEditable(int row, int column) {
 			try {
 					return column == 3 || column == 6     ? true : false;
  			} catch (Throwable e) {
 				e.printStackTrace();
			}
			return false;
  		}
	};

 			
 	JTable table = new JTable() 
 	{
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			// 3 4 5 6 9 10 15 16
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 3 || column == 6 ) 
			{
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				//componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				//componentt.setFont(new Font("Calibri", Font.BOLD, 14));
			}

			if (Language == "H") {
				if (column == 2) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}
			return componentt;

		}
	};

 	
 	
 	private JTextField total;
 	private JTextField lossper;
 	private JTextField SONO;
 	private JTextField SODATE;
 	private JTextField FinishItemCode;
 	private JTextField value;
 	private JLabel lblNewLabel_5;
 	private JLabel lblNewLabel_6;
 	private JTextField customer;
 	private JLabel lblNewLabel_7;
 	private JTextField deliverydate;
 	private JTextField customercode;
 	private JButton btnShow;
 	private JLabel lblNewLabel_8;
 	private JLabel lblstatus;
 	private JButton btnCustomer;
 	private JLabel lblNewLabel_9;
 	private JLabel lblNewLabel_14;
 	private JLabel lblNewLabel_15;
 	private JTextField SOAMT;
 	private JLabel lblNewLabel_16;
 	private JTextField twtkg;
 	private JLabel lblNewLabel_17;
 	private JTextField twtgm;
 	private JTextField tfinishvalue;
	
 	
 	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductionOrder window = new ProductionOrder();
					window.prodOrderFrame.setVisible(true);
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
	 * @throws Throwable 
	 */
	public ProductionOrder() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Throwable 
	 */
	private void initialize() throws Throwable {
		prodOrderFrame = new JFrame();
		prodOrderFrame.getContentPane().setBackground(new Color(204, 255, 255));
		prodOrderFrame.setBackground(Color.WHITE);
		prodOrderFrame.setBounds(1, 100, 1350, 600);
		prodOrderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prodOrderFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Production Order");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(12, 43, 131, 29);
		prodOrderFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon(ProductionTemplate.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_1.setBounds(12, 13, 147, 106);
		prodOrderFrame.getContentPane().add(lblNewLabel_1);
		
		//JPanel panel = new JPanel();
		JPanel panel = new gnRoundPanel();
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(148, 13, 1160, 76);
		prodOrderFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel_6 = new JLabel("Select Customer ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(12, 0, 192, 16);
		panel.add(lblNewLabel_6);
		
		customer = new JTextField()
		{
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		customer.setBounds(86, 24, 249, 30);
		panel.add(customer);
		customer.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Delivery Date");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_7.setBounds(350, 0, 167, 16);
		panel.add(lblNewLabel_7);
		
		deliverydate = new JTextField();
		deliverydate.setBounds(347, 24, 116, 30);
		panel.add(deliverydate);
		deliverydate.setColumns(10);
		
		btnReceipt = new JButton("Receipt");
		btnReceipt.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnReceipt.setForeground(new Color(102, 0, 102));
		btnReceipt.setBounds(1037, 13, 97, 50);
		panel.add(btnReceipt);
		
		customercode = new JTextField();
		customercode.setEditable(false);
		customercode.setBounds(12, 24, 73, 30);
		panel.add(customercode);
		customercode.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Order No.");
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(0, 102, 204));
		lblNewLabel_3.setBounds(605, 0, 97, 16);
		panel.add(lblNewLabel_3);
		
		//SONO = new JTextField();
		SONO = new gnRoundTextField(10);
		SONO.setEditable(false);
		SONO.setBackground(new Color(204, 255, 255));
		
		SONO.setBounds(605, 24, 116, 30);
		panel.add(SONO);
		SONO.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		SONO.setColumns(10);
 		SODATE = new gnRoundTextField(10);
 		SODATE.setEditable(false);
 		SODATE.setBackground(new Color(204, 255, 255));
		
		SODATE.setBounds(724, 24, 116, 30);
		panel.add(SODATE);
		SODATE.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		SODATE.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Order Date");
		lblNewLabel_8.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_8.setForeground(new Color(0, 102, 204));
		lblNewLabel_8.setBounds(730, 0, 110, 16);
		panel.add(lblNewLabel_8);
		
		lblstatus = new JLabel("Order");
		lblstatus.setBounds(852, 31, 41, 16);
		panel.add(lblstatus);
		
		btnCustomer = new JButton("Customer");
		btnCustomer.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnCustomer.setForeground(new Color(102, 0, 102));
		btnCustomer.setBounds(932, 13, 97, 50);
		panel.add(btnCustomer);
		
		lblNewLabel_15 = new JLabel("Order Amount");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_15.setBounds(475, 0, 118, 16);
		panel.add(lblNewLabel_15);
		
		//SOAMT = new JTextField();
		SOAMT = new gnRoundTextField(10);
		SOAMT.setBackground(new Color(204, 255, 255));
		SOAMT.setEditable(false);
		SOAMT.setFont(new Font("Tahoma", Font.BOLD, 15));
 		SOAMT.setBounds(475, 24, 124, 30);
		panel.add(SOAMT);
		SOAMT.setColumns(10);
		
		 
		
		jsp = new JScrollPane();
		jsp.setBounds(465, 166, 873, 379);
		prodOrderFrame.getContentPane().add(jsp);
		
		JLabel label = new JLabel("Qty");
		label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(867, 89, 56, 16);
		prodOrderFrame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("UOM");
		label_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(935, 89, 56, 16);
		prodOrderFrame.getContentPane().add(label_1);
		
		JLabel lblRatekg = new JLabel("Rate/Kg");
		lblRatekg.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblRatekg.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRatekg.setBounds(1029, 89, 56, 16);
		prodOrderFrame.getContentPane().add(lblRatekg);
		
		qty = new JTextField();
		qty.setText("1");
		qty.setForeground(new Color(0, 0, 102));
		qty.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		qty.setBackground(Color.WHITE);
		qty.setBounds(888, 105, 68, 30);
		prodOrderFrame.getContentPane().add(qty);
		qty.setColumns(10);
		
 		
		comboUOM = new JComboBox();
		comboUOM.setModel(new DefaultComboBoxModel(new String[] {"KG", "GM"}));
		comboUOM.setForeground(new Color(0, 0, 102));
		comboUOM.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		comboUOM.setBackground(Color.WHITE);
		comboUOM.setBounds(959, 105, 68, 30);
		prodOrderFrame.getContentPane().add(comboUOM);
		
		rate = new JTextField();
		rate.setForeground(new Color(0, 0, 102));
		rate.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		rate.setBackground(Color.WHITE);
		rate.setBounds(1030, 105, 81, 30);
		prodOrderFrame.getContentPane().add(rate);
		rate.setColumns(10);
		
 		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		btnSave.setForeground(new Color(0, 0, 102));
		btnSave.setBounds(512, 549, 97, 38);
		prodOrderFrame.getContentPane().add(btnSave);
		
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		btnClose.setForeground(new Color(0, 0, 102));
		btnClose.setBounds(640, 549, 97, 38);
		prodOrderFrame.getContentPane().add(btnClose);
		
		JLabel lblNewLabel_12 = new JLabel("Material Value");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNewLabel_12.setBounds(986, 549, 171, 38);
		prodOrderFrame.getContentPane().add(lblNewLabel_12);
		
		//total = new JTextField();
		total = new gnRoundTextField(10);
		total.setFont(new Font("Tahoma", Font.BOLD, 16));
 		total.setBackground(new Color(204, 255, 255));
		total.setEditable(false);
		total.setBounds(1161, 549, 159, 38);
		prodOrderFrame.getContentPane().add(total);
		total.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Loss %");
		lblNewLabel_13.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		lblNewLabel_13.setBounds(1231, 89, 56, 16);
		prodOrderFrame.getContentPane().add(lblNewLabel_13);
		
		lossper = new JTextField();
		lossper.setBounds(1234, 105, 44, 30);
		prodOrderFrame.getContentPane().add(lossper);
		lossper.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Item Value");
		lblNewLabel_10.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_10.setBounds(1113, 89, 106, 16);
		prodOrderFrame.getContentPane().add(lblNewLabel_10);
		
		value = new JTextField();
		value.setBounds(1113, 105, 106, 29);
		prodOrderFrame.getContentPane().add(value);
		value.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Template Name");
		lblNewLabel_2.setBounds(558, 87, 205, 16);
		prodOrderFrame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		
		templatename = new JTextField();
		templatename.setBounds(555, 105, 268, 30);
		prodOrderFrame.getContentPane().add(templatename);
		templatename.setEditable(false);
		templatename.setToolTipText("Enter Template Name Here");
		templatename.setText(" ");
		templatename.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Finish Product");
		lblNewLabel_4.setBounds(454, 89, 122, 16);
		prodOrderFrame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
		
		FinishItemCode = new JTextField();
		FinishItemCode.setBounds(480, 105, 68, 30);
		prodOrderFrame.getContentPane().add(FinishItemCode);
		FinishItemCode.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Select Finish Item  Name");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(172, 90, 159, 16);
		prodOrderFrame.getContentPane().add(lblNewLabel_5);
		
		comboFinishItem = new JComboBox();
		comboFinishItem.setForeground(Color.WHITE);
		comboFinishItem.setBounds(158, 105, 316, 30);
		prodOrderFrame.getContentPane().add(comboFinishItem);
		
		//btnShow = new JButton("Show Maerial List");
		btnShow = new gnRoundButton("Show Maerial List");
		btnShow.setForeground(new Color(0, 0, 204));
		btnShow.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
 		btnShow.setBounds(1135, 138, 147, 25);
		prodOrderFrame.getContentPane().add(btnShow);
		
		lblNewLabel_9 = new JLabel("MaterialList");
		lblNewLabel_9.setBounds(394, 148, 106, 16);
		prodOrderFrame.getContentPane().add(lblNewLabel_9);
		
		fjsp = new JScrollPane();
		fjsp.setBounds(12, 166, 441, 379);
		prodOrderFrame.getContentPane().add(fjsp);
		
		JLabel lblNewLabel_11 = new JLabel("Finish Item");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_11.setBounds(12, 147, 131, 16);
		prodOrderFrame.getContentPane().add(lblNewLabel_11);
		
		lblNewLabel_14 = new JLabel("Total Amount");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		lblNewLabel_14.setBounds(134, 557, 122, 25);
		prodOrderFrame.getContentPane().add(lblNewLabel_14);
		
		lblNewLabel_16 = new JLabel("Weight/Kg");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_16.setBounds(816, 549, 75, 16);
		prodOrderFrame.getContentPane().add(lblNewLabel_16);
		
		twtkg = new JTextField();
		twtkg.setFont(new Font("Tahoma", Font.BOLD, 12));
		twtkg.setBackground(new Color(204, 255, 255));
		twtkg.setEditable(false);
		twtkg.setBounds(888, 549, 116, 22);
		prodOrderFrame.getContentPane().add(twtkg);
		twtkg.setColumns(10);
		
		lblNewLabel_17 = new JLabel("Weight/GM");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_17.setBounds(816, 578, 68, 16);
		prodOrderFrame.getContentPane().add(lblNewLabel_17);
		
		twtgm = new JTextField();
		twtgm.setFont(new Font("Tahoma", Font.BOLD, 12));
		twtgm.setBackground(new Color(204, 255, 255));
		twtgm.setEditable(false);
		twtgm.setBounds(888, 575, 116, 22);
		prodOrderFrame.getContentPane().add(twtgm);
		twtgm.setColumns(10);
		
		//tfinishvalue = new JTextField();
		tfinishvalue = new gnRoundTextField(10);
		tfinishvalue.setBackground(new Color(204, 255, 255));
		tfinishvalue.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		tfinishvalue.setBounds(274, 550, 116, 41);
		prodOrderFrame.getContentPane().add(tfinishvalue);
		tfinishvalue.setColumns(10);
		
		JButton btnTest = new JButton("Test");
		btnTest.setBounds(1018, 138, 97, 25);
		//prodOrderFrame.getContentPane().add(btnTest);
			
	    ActionListener btnls = new btnLsnr() ;	
		btnClose.addActionListener(btnls);
		btnSave.addActionListener(btnls);
		btnShow.addActionListener(btnls);
		btnReceipt.addActionListener(btnls);
		btnCustomer.addActionListener(btnls);
		//btnTest.addActionListener(btnls);
		
		ActionListener custls = new custnameLsnr() ;
		customer.addActionListener(custls);
		
		
		ActionListener finishitmtls = new FinishdropdnLsnr() ;
		comboFinishItem.addActionListener(finishitmtls);
		
		ActionListener qtyLs = new qtyLsnr() ;
 		qty.addActionListener(qtyLs);		
		
		decorate();
	}

class qtyLsnr  implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent arg0) {
 
 		String vqty =  qty.getText() ;
 	 	String vrate = rate.getText() ;
 	 	Double vvqty =  Double.parseDouble(vqty) ;
 	 	Double vvrate = Double.parseDouble(vrate) ;
 	 	Double vvvalue = (vvrate* vvqty) ;
 	 	String finishvalue  = Double.toString(vvvalue);
 	  	value.setText(finishvalue);
 		
 		
	}
 }

	
	
class btnLsnr  implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent e) {
 		String value  =  e.getActionCommand() ;
 
 		if (value == "Test")
 		{
 			doTest() ;
 		}
 		
 		if (value == "Show Maerial List")
 		{
  			try {
  				showTemplateForfinishItem(FinishItemCode.getText()) ;
   				addInTable() ;
			} catch (ClassNotFoundException | SQLException e1) {
 				e1.printStackTrace();
			}
 		}

 		
 		if (value  == "Receipt")
 		{
 		
			receiptVoucher window;
			try {
				window = new receiptVoucher();
				window.frmreceiptVoucher.setVisible(true);
 			} catch (Throwable e1) {
 				e1.printStackTrace();
			}
  		}

 		
 		
 		if (value  == "Customer")
 		{
 			try {
 				CustomerMaster window;
  				window = new CustomerMaster();
				window.CustomerFrame.setVisible(true);
			} catch (Throwable e1) {
				new General().msg(e1.getMessage());
				new gnLogger().loggerInfoEntry(" Sales Order",
						"Customer Master Data  Exception...." + " " + e1.getMessage());
			}
  		}
 
 		
 		if (value  == "Save")
 		{
 			new gnLogger().loggerInfoEntry("  Sale Order", "Data Validation  Process Starts....");
			String status = validate();
			if (status == "Sucess") {
				try {
					new gnLogger().loggerInfoEntry(" Sale Order", "Saving Data Process Starts....");
					PrepareToInsert();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
					new gnLogger().loggerInfoEntry(" Sale Order",
							"Saving Data Process Exception...." + " " + e1.getMessage());
				}
			}
  		}
 
 		
 		
 		if (value  == "Close")
 		{
 			prodOrderFrame.dispose();
 		}
 		 
 		
 		
	}
 }



class FinishdropdnLsnr implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent e) {
  	
   		String vcombo = "FinshProduct" ; 
         try {
         	setItemDetails(vcombo) ;
		} catch (ClassNotFoundException | SQLException e1) {
 			e1.printStackTrace();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
  	}
 }



private void setItemDetails(String vcombo  ) throws Throwable
{
	
  	switch(vcombo)
	{
 		case  "Material" :
  			   break ;
 
		case  "FinshProduct" :
 			  String vfinishname = 	comboFinishItem.getSelectedItem().toString().trim() ;
   		 	  String myArticle = "Code" ;
   		 	  vfinishArticlecode = new gnArticle().Article_getData(myArticle, vfinishname) ;
   		 	  FinishItemCode.setText(vfinishArticlecode);	 
 
			  String vtype1 = "UOM" ;
			  String vuom = new gnArticle().Article_getData(vfinishArticlecode, vtype1);
			  comboUOM.setSelectedItem(vuom);

			  vtype1 = "SP" ;
			  String vrate = new gnArticle().Article_getData(vfinishArticlecode, vtype1);
  			  rate.setText(vrate);
   			  templatename.setText(new gnProductionTemplate().getTemplateName(vfinishArticlecode));
  			  
    		break ;

	}
 }


 
private void decorate() throws Throwable {
 	new gnApp().setFrameTitel( prodOrderFrame);
	prodOrderFrame.setUndecorated(true);
 	new  gnComp().fillFinishItemCombo(comboFinishItem) ;
 	int typeno = 2;
	new gnDecorate().SetSeqHdrButton(btnSave, typeno);
 	new gnDecorate().SetSeqHdrButton(btnClose, typeno);
 	new gnDecorate().SetSeqHdrButton(btnReceipt, typeno);
	vcomp = new gnConfig().getCompanycode();
	vstore = new gnConfig().getStoreID();
	try {

		gnProductDetails kk;
		kk = new gnProductDetails();
	} catch (Throwable e) {
		e.printStackTrace();
	}
	chekcFreezeYear();
	this.checkInternet();
	if (Language == "H") {
		customer.setFont(new Font("Shivaji02", Font.PLAIN, 16));
	}
	new gnField().closeform(btnSave, prodOrderFrame);

	String vpara29 = "29";
	String vEditDocumentAllow = new getConfigurationSetting().getSpecificConfiguration(vpara29);
	switch (vEditDocumentAllow) {
	case "N":
		// btnEdit.setVisible(false);
		break;
	}

	vallow = new gnDate().checkDayBegin();
	switch (vallow) {
	case "Y":
		delTableRow(ftable, fmodel);
		//new General().removeRow(model, table);
		vcomp = new gnConfig().getCompanyCode();
		SODATE.setText(new gnConfig().getDaybeginDate());
		new gnField().closeform(btnSave, prodOrderFrame);
		new gnField().showInventory(btnSave, "INV");
		new gnField().showCalc(btnSave, "CAL");
		new gnField().moveDown(table);
 		String vtype = "SALE";
		String vallowDate = new gnDate().checkBackDateTrAllow(vtype, SODATE.getText());
		switch (vallowDate) {
		case "N":
 			SODATE.setBackground(Color.RED);
			SODATE.setForeground(Color.WHITE);
			new General().msg("Back Date For Transaction is not Allow..");
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			SODATE.setText("?");
  			customer.setEditable(false);
			break;
		}

		if (vcomp == "0") {
			System.exit(0);
		}

		if (vcomp != "0") {

		}
		break;
	case "N":
		break;
	}
}


public void delTableRow(JTable xftable ,  DefaultTableModel xfmodel ) {
	InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delAction");
	ActionMap amap = ((JComponent) table).getActionMap();
    amap.put("delAction", new AbstractAction() {
	public void actionPerformed(ActionEvent e) {
			try {
				int frow = xftable.getSelectedRow() ;
				String vfcode  = xftable.getValueAt(frow, 1).toString() ;
  				xfmodel.removeRow(frow);
 				int row  =  table.getRowCount() ;
 				for ( int k=0 ;  k < row ; k++)
				{
					 String vtcode = table.getValueAt(k, 0).toString() ;
					 if (vfcode.equals(vtcode))
					 {
						 model.removeRow(k);
					 }
				}
  			} catch (Throwable e1) 
			{
			e1.printStackTrace();
		   }
			finally{
				getheaderInfo() ;
			}
	}
});
}


class custnameLsnr implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if (vallow == "N") {
			prodOrderFrame.dispose();
			new General().msg("Complete Day Open First ....");
			return;
		}
			String value = e.getActionCommand();
		String vtype = "Customer";
		String sname = customer.getText().trim();
		sname = "%" + sname + "%";
		if (sname.length() == 0) {
			new General().msg("Select Party code ...");
			return;
		}
		try {
			new gnSupplier().rcustcode = "0";
			new gnSupplier().getCustomer(sname);
		} catch (Throwable e1) {
			e1.printStackTrace();
			new gnLogger().loggerInfoEntry("Credit Sale",
					"Customer Get  Process Exception...." + " " + e1.getMessage());
		} finally {
			customercode.setText(new gnSupplier().rcustcode);
			customer.setText(new gnSupplier().rcustName);
			vRefcode = customercode.getText() ;
			vRefname =  customer.getText() ;
 			new gnSupplier().rcustcode = " ";
			new gnSupplier().rcustName = " ";
			deliverydate.grabFocus();
			try {
				if (customercode.getText().length() > 0) {
 				}
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
			try {
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				if (EditMode == "Y") {
					try {
						//getInvoiceNo();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
}

   

 
 


private void callSaveAction() throws SQLException, ClassNotFoundException, IOException
{
 	String vtemplatename = templatename.getText();
    String vfinishcode = 	FinishItemCode.getText() ;
   	
    String vqty =  qty.getText() ;
 	String vrate = rate.getText() ;
 	Double vvqty =  Double.parseDouble(vqty) ;
 	Double vvrate = Double.parseDouble(vrate) ;
 	Double vvvalue = (vvrate* vvqty) ;
 	String finishvalue  = Double.toString(vvvalue);
  	String vorderno =  SONO.getText() ;
  	String vorderdate =  new gnConfig().date_ConverttoDBforamt(SODATE.getText()) ;
   	new gnLogger().loggerDebugEntry("Template Data Inserting ", "Start Inserting Rows");
  	prst = null;
	final int batchSize = 1;
	int TotalRecordinsert = 0;
	con2 = (Connection) this.getConnection();
	con2.setAutoCommit(false);
	String Status = "Fail";
	String poshdr = "Insert into prod_template(company_code, " + "site_code ,  "
  			+ " TemplateName  , TemplateType , FinishItemcode, FinishItemQty, "
  			+ " FinishItemRate,FinishItemValue , "
			+ " materialCode, materialQty, materialUOM , "
			+ " MaterialRate , MaterialWTKG ,  MaterialValue ,"
			+ "   MaterialActualUOM , FinishItemloss)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
	try {
		int row = table.getRowCount();
	 	//String col[] = {"Remove",   "Material" , "Name" , "Qty" , "UOM", "Rate" , "WTKG", "Material Value"} ;
 		for (int k = 0; k < row; k++) {
 			if (vtemplatename.length() > 0) {
				prst = con2.prepareStatement(poshdr);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vtemplatename);
		 		prst.setString(5, vfinishcode) ;  
				prst.setString(6, vqty);  
				prst.setString(7, vrate);  
				prst.setString(8, finishvalue) ;   
				prst.setString(9,  table.getValueAt(k, 1).toString());
				prst.setString(10, table.getValueAt(k, 3).toString());
				prst.setString(11, table.getValueAt(k, 4).toString());
 				prst.setString(12, table.getValueAt(k, 5).toString());
 				prst.setString(13, table.getValueAt(k, 6).toString());
 				prst.setString(14, table.getValueAt(k, 7).toString());
 				prst.setString(15, new gnArticle().Article_getData(table.getValueAt(k, 1).toString(), "UOM"));
 				prst.setString(16,  lossper.getText());
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
			reset();
			new General().Quickmsg("Template Saved..");
		}
	}

 }




private void DeleteTemplateData() throws SQLException
{
 	String vtemplatename = templatename.getText();
 	String SQL = "Delete from  prod_template  where company_code = " + vcomp + " and  site_code = " + vstore +" "
			+ "  and TemplateName = '" + vtemplatename + "'  ";
 	this.getResult(SQL);

}



private void chekcFreezeYear() {
	switch (isFinyearFreeze) {
	case "Y":
 		btnSave.setVisible(false);
		new General().msg("Accounting Year is Freezeed..You Can View Data Only..");
		break;
	}
}



private void reset()
{
	new gnTable().RemoveTableRows(model);
	qty.setText("0");
	rate.setText("0");
	value.setText("0");
  }


private void showTemplateForfinishItem(String varticle)
{
	Double vfinishqty = Double.parseDouble(qty.getText()) ;
 	String vname  = "NA" ;
	String vtype = "GetTemplateItemsforFinishItem" ;
   	String SQL = "call Template_getData( '"+vtype+"' , '"+vcomp+"' , '"+vstore+"', '"+varticle+"' , '"+vname+"')" ;
   	String col[] = { "FinishItem" , "Material" , "Name" , "Qty" , "UOM" , "Weight/KG" , "Rate/Kg" , 
   			           "Value", "ActualUOM" } ;
    model.setColumnIdentifiers(col); 
    table.setModel(model);
	try 
    {
		rs = this.getSPResult(SQL);
		while(rs.next())
		{
 			Double xvqty = Double.parseDouble(rs.getString(4)) *vfinishqty ;
 			Double xvwtkg =   xvqty/1000 ;
			Double xvrate = Double.parseDouble(rs.getString(7)) ;
			Double xvalue =  xvwtkg * xvrate ;
 		 model.addRow(new Object[]{ rs.getString(1), rs.getString(2),
				 rs.getString(3) ,xvqty , 
				 rs.getString(5),
				 xvwtkg ,
				 rs.getString(7),
 				 xvalue,rs.getString(9)});	
		 
		 //table  = new gnTableModel().Tablemodel(table, model, SQL, col, 9, "N ", "N", "N") ;
 		}
	    table.setModel(model);
     } catch (ClassNotFoundException | SQLException e) {
    	e.printStackTrace();
    }	
 	JViewport prt66 = new JViewport();
 	prt66.setToolTipText("Material  Data");
 	prt66.setBackground(Color.white);
	prt66.add(table, col);
 	jsp.setViewport(prt66);
 	jsp.setVisible(true);
 	
	if (table.getRowCount() > 0 )
	{
		new gnTable().setTableBasics(table);
		new gnFontSetting().setMyFontBold(table, "F2", 8);
		new gnTable().setTablewidth(table, 1, 40);
		new gnTable().setTablewidth(table, 0, 40);
		new gnTable().setTablewidth(table, 2, 300);
		new gnTable().setTablewidth(table, 4, 100);
	 	new gnTable().setTablewidth(table, 5, 70);
		table.getDefaultEditor(String.class).addCellEditorListener(ChangeNotification);
 	}

}




public CellEditorListener ChangeNotification = new CellEditorListener() {
	public void editingCanceled(ChangeEvent e) {
		e.notifyAll();
		System.out.println("The user canceled editing.");
	}
		public void editingStopped(ChangeEvent e) {
		int i = table.getSelectedRow();
		String value = (String) table.getValueAt(i, 1);
		try {
			QtychangeImapct(value, i);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Throwable e1) {
			e1.printStackTrace();
		}
	}
};




//Insert Start Here 


private String validate() {
	new gnLogger().loggerInfoEntry("Credit Sale", "Validation Starts");
	
	    String status = "Sucess";
		vcustomer = customercode.getText();

		if (customer.getText().length() == 0) {
		new General().msg("Select Customer Or Create New Customer For  Credit Sales .. ");
		status = "Fail";
		customer.grabFocus();
	}

	 	Double vamt = Double.parseDouble(value.getText());
		if (vamt == 0.00) {
			new General().msg("Order Value can not be Zero ");
			status = "Fail";
		}

	 	if (value.getText().length()== 0 )
		{
			new General().msg("Order Value can not be Zero ");
			status = "Fail";
 		}
		
	String status1 = new gnTable().isAmountnegative(value.getText());
	String status2 = new gnTable().istableColValueNegative(table, 5);
	String status3 = new gnTable().istableColValueNegative(table, 6);
	String status4 = new gnTable().istableColValueNegative(table, 7);
 
	if (status1 == "Fail" || status2 == "Fail" || status3 == "Fail"  || status4 == "Fail") {
		status = "Fail";
	}
  	new gnLogger().loggerInfoEntry("Sale Order", "Validaion Over - Status is" + "" + status);
	return status;
}




private void PrepareToInsert() throws Throwable {

	if (EditMode == "N") {
		SONO.setText(new gnSeq().getSeqno("5", "TR"));
	}
	vinvno = SONO.getText();
	vsalestype = "SO";
	vinvtype = "SO";
	vglcode = new gnSeq().getGlcode("5", "TR");
	vpostingtype = "Y";

	try {
		new gnLogger().loggerInfoEntry("Sale Order", "Data Insert Process Start");
 		vcustomer = customercode.getText();
		vuser = new gnConfig().getUserCode();
		vinvdate = new gnConfig().date_ConverttoDBforamt(SODATE.getText());
		vterminal = "0";
		vtime = new General().getTime();
		vverticle = new gnHierarchy().getVerticleCode();
		vnetamount =  value.getText();
		vcreditDays = "0";
		vpaytype = "Due";
 
	} catch (Exception e) {
		new General().msg("Prepare to insert :" + e.getLocalizedMessage());
	}
		insertintoGLmaster();
		if (EditMode == "Y") {
		new gnEDMiddleWare().SalesModification(vinvtype, SONO.getText(), SODATE.getText());
	}
	//insertSODetails();
}



private void insertintoGLmaster() throws Throwable {
	String vglcode = customercode.getText();
	String vglname = customer.getText();
	String vtype = "N";
	new gnAccountbase().insertGlData(vglcode, vglname, vtype);
}




////  Salesorder Details Start here
public void insertSODetails() throws Throwable {
	prst = null;
	final int batchSize = 10;
	int TotalRecordinsert = 0;
	con1 = (Connection) this.getConnection();
	con1.setAutoCommit(false);
	int pd_seq;
	DBdetail = "Fail";
	String poshdr = "Insert into so_detail (company_code ,"
			+ "site_code,  docType ,  docDate	,  docno,  Finyear ,    "
			+ "Party   , Line_seq , Article_code ,  qty , Rate,  Gross, Bill_disc, Disc ,   "
			+ "NetAmount , taxcode , verticle) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" ;

	prst = con1.prepareStatement(poshdr);
	try {
		int row = table.getRowCount();
		for (int k = 0; k < row; k++) {
			pd_seq = k + 1;
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vsalestype);
				prst.setString(4, vinvdate);
				prst.setString(5, vinvno);
				prst.setString(6, new gnFinYear().getCurrentFinYear(SODATE.getText()));
				prst.setString(7, vcustomer);
				prst.setInt( 8, pd_seq); // lineseq
				prst.setString(9, table.getValueAt(k, 1).toString());
				prst.setString(10, (table.getValueAt(k, 3).toString())); // invqty
				prst.setDouble(11, Double.parseDouble(table.getValueAt(k, 6).toString())); // SP
				prst.setDouble(12, Double.parseDouble(table.getValueAt(k, 8).toString())); // Gross
				prst.setDouble(13, Double.parseDouble(table.getValueAt(k, 10).toString())); // disc
				prst.setDouble(14, Double.parseDouble(table.getValueAt(k, 9).toString())); // hdrdisc
				prst.setDouble(15, Double.parseDouble(table.getValueAt(k, 11).toString())); // netAmt
				prst.setString(16, table.getValueAt(k, 12).toString()); // tax_per
				prst.setString(17, vverticle);
				prst.addBatch();
			// new General().msg("Reahed...POs detail "+prst);
				TotalRecordinsert = TotalRecordinsert + 1;
				if (TotalRecordinsert % batchSize == 0) {
				int[] recordws = prst.executeBatch();
				// con1.commit();
				DBdetail = "Sucess";
			}
			int[] ff = prst.executeBatch(); // insert remaining records
			// con1.commit();
			DBdetail = "Sucess";
		}
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		con1.rollback();
		DBdetail = "Fail";
		new gnLogger().loggerInfoEntry("  Sale Order ", "Detail Data Exception" + " " + e.getMessage());
		new General().msg("Detail:" + e.getMessage());
	} finally {
		if (prst != null) {
			prst.close();
		}
		if (DBdetail == "Sucess") {
			insertSOHdr();
		}
	}
}

public void insertSOHdr() throws Throwable {
	prst = null;
	final int batchSize = 1;
	int TotalRecordinsert = 0;
	con2 = (Connection) this.getConnection();
	con2.setAutoCommit(false);
	DBhdr = "Fail";
	String poshdr = "Insert into SO_hdr(company_code , site_code,"
			+ " doctype ,   docno,   docDate ,  "
			+ " party , finyear , verticle , Gross, "
			+ " Discount,  Roundingamt, NetAmount,"
			+ " DeliveryDate,  remark , time , updatedDate , Createdby ,"
			 	+ " ShippingAddr1 , ShippingAddr2 ,   "
				+ " status ) "
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
	try {
			prst = con2.prepareStatement(poshdr);
			prst.setString(1, vcomp);
			prst.setString(2, vstore);
			prst.setString(3, vsalestype);
			prst.setString(4, vinvno);
			prst.setString(5, vinvdate);
			prst.setString(6, vcustomer);
			prst.setString(7, new gnFinYear().getCurrentFinYear(SODATE.getText()));
			prst.setString(8, vverticle);
			prst.setDouble(9, Double.parseDouble(value.getText()));
			prst.setDouble(10, 0.00);
			prst.setString(11, "0");
			prst.setString(12, vnetamount);
			prst.setString(13, new gnConfig().date_ConverttoDBforamt(deliverydate.getText()));
			prst.setString(14, "Manual Sales Order Generated..") ;
			prst.setString(15, new General().getTime());
			prst.setString(16, vinvdate);
			prst.setString(17, vuser);
			prst.setString(18, "" ) ; //shipaddr1.getText());
			prst.setString(19, "") ; //shipaddr1.getText());
			prst.setString(20, "Order");
			prst.addBatch();
		TotalRecordinsert = TotalRecordinsert + 1;
		DBhdr = "Fail";
		if (++TotalRecordinsert % batchSize == 0) {
			prst.executeBatch();
			DBhdr = "Sucess";
		}
		prst.executeBatch(); // insert remaining records
		DBhdr = "Sucess";
	} catch (SQLException e) {
		System.out.println(e.getMessage());
		con2.rollback();
		DBhdr = "Fail";
		new gnLogger().loggerInfoEntry("  Sale order ", "Hdr Data Exception" + " " + e.getMessage());
		new General().msg("Detail:" + e.getMessage());
	} finally {
		if (prst != null) {
			prst.close();
		}
		if (DBhdr == "Sucess") {
			con1.commit();
			con2.commit();
			con1.close();
			con2.close();
			new gnLogger().loggerInfoEntry("Sales Order", "Detail & Hdr Data  Save- Sucess");
			new General().msg("Sales Order Data Saved Status -->Sucess ");
			reset();
		}
	}
} // Insert Hdr End



private void addInTable() throws ClassNotFoundException, SQLException
{
	
        String vfinishname = 	comboFinishItem.getSelectedItem().toString().trim() ;
        String vfinishProductCode = FinishItemCode.getText() ;
  	 	String vqty =  qty.getText() ;
	 	String vrate = rate.getText() ;
 	 	String vvalue = value.getText() ;
 	 	String vuom = comboUOM.getSelectedItem().toString() ;
 	 	String col[] = {"Remove",   "Item" , "Name" , "Qty" , "Rate",   "Amount"} ;
	 	fmodel.setColumnIdentifiers(col);
	 	fmodel.insertRow(0, new Object[]{"X" , vfinishProductCode , vfinishname, vqty , 
	 										vrate, vvalue}) ;;
 	    JViewport prt = new JViewport();
   		ftable.setModel(fmodel);
		new gnTable().setTableColWidth(ftable, 2, 150);
 		new gnTable().setTableBasics(ftable);
		new gnFontSetting().setMyFont(ftable, "F2", 5);
   		prt.setBackground(Color.WHITE);
		prt.add(ftable, col);
		prt.setVisible(true);
		fjsp.setViewport(prt);
 	 	new General().removeRow(fmodel, ftable);
	 	getheaderInfo() ;
}


private void getheaderInfo()
{
	    int vcount = table.getRowCount();

 		Double vtwtgm = new gnTable().getTotal(table, 3);
 		Double vtwtkg = new gnTable().getTotal(table, 5);
		Double v = new gnTable().getTotal(table, 7);
		
 		total.setText(Double.toString(v)) ;
  		twtkg.setText(Double.toString(vtwtkg)) ;
 		twtgm.setText(Double.toString(vtwtgm)) ;

		Double vtfinishval = new gnTable().getTotal(ftable, 5);
  		tfinishvalue.setText(Double.toString(vtfinishval)) ;
  		SOAMT.setText(Double.toString(vtfinishval)) ;
 		 
		
 }





public void QtychangeImapct(String value, int i) throws Throwable {
	String curqty1 = "  ";
	Double curqty = 0.00;
	Double vtaxamt = 0.00;

   	//String col[] = {"0 FinishItem" , "1 Material" , "2 Name" , "3 Qty" , 
	//"4 UOM" , "5 Weight/KG" , "6 Rate/Kg" , 
	           //"7 Value", "8 ActualUOM" } ;

	
	//Double xvqty = Double.parseDouble(rs.getString(4)) *vfinishqty ;
	//Double xvwtkg =   xvqty/1000 ;
	//Double xvrate = Double.parseDouble(rs.getString(7)) ;
	//Double xvalue =  xvwtkg * xvrate ;

	Double xvqty = Double.parseDouble(table.getValueAt(i, 3).toString());
	Double xvrate = Double.parseDouble(table.getValueAt(i,6 ).toString());
	Double xvwtkg =   xvqty/1000 ;
	Double xvalue =  xvwtkg * xvrate ;

	table.setValueAt(xvwtkg, i, 5);
 	//table.setValueAt(new gnMath().get2DecimaltValue(Double.toString( xvwtkg)), i, 5);
	table.setValueAt(new gnMath().get2DecimaltValue(Double.toString(xvalue)), i, 7);

	
	if (xvqty == 0.00) {
		table.setEditingRow(i);
		table.setGridColor(Color.YELLOW);
		table.setBackground(Color.red);
	}

 	
 	if (xvrate <= 0.00) {
	 	new General().msg("Please Check Cost  at Row" + "  " + i);
		table.setEditingRow(i);
		table.setGridColor(Color.YELLOW);
		table.setBackground(Color.red);
  	}
 	getheaderInfo() ;
  	table.addNotify();
 	new gnLogger().loggerInfoEntry("  Sale order production", "Data Edited" + " Line  " + i + "Value " + value);

}




private void doTest()
{
	 
	String vtype = "MainData" ;
	String vyear = "2020" ;
	String vmonth = "Jun" ;
	String vattr1 = "0" ;
	String SQL = "call MainSalesData( '"+vtype+"' , "+vcomp+" , "+vstore+", '"+vyear+"' , '"+vmonth+"' ,'"+vattr1+"' )" ;
   	String col[] = {"Sr" , "ReportType" , "show" , "headone" , "headtwo" , "value" , "Qty" } ; 
   	new General().msg(SQL);		           
    model.setColumnIdentifiers(col); 
    table.setModel(model);
	try 
    {
		rs = this.getSPResult1(SQL);
		while(rs.next())
		{
  		 model.addRow(new Object[]{rs.getString(1), rs.getString(2),
  				rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6) , rs.getString(7)});	
 		 //table  = new gnTableModel().Tablemodel(table, model, SQL, col, 9, "N ", "N", "N") ;
 		}
	    table.setModel(model);
     } catch (ClassNotFoundException | SQLException e) {
    	e.printStackTrace();
    }	
 	JViewport prt66 = new JViewport();
 	prt66.setToolTipText("Material  Data");
 	prt66.setBackground(Color.white);
	prt66.add(table, col);
 	jsp.setViewport(prt66);
 	jsp.setVisible(true);
 	
 	int row = table.getRowCount() ;
 	new General().msg("Total row Count :" + " "+row);
}



}//Last 

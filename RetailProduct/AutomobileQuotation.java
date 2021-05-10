package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

import RetailProduct.CustomerMaster.btnfocus;
import RetailProduct.CustomerMaster.keyPressedlsnr;

import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
 
public class AutomobileQuotation  extends getResultSet{

	JFrame automQuotationframe;
	JComboBox comboColor;
	JComboBox comboPower;
	String varticlecode="0";
	String vcomp ;
	String vallowday = "N" ;
	String EditMode = "I" ;
	String vstore ;
	String vverticle ;
	JButton btnSave;
  	JButton btnPrint;
	JPanel cardPanel;
	
	JPanel imagePanel ;
	JPanel dataPanel ;
	JScrollPane jsp1 ;
	JScrollPane ijsp ;
	JLabel lblimage ;

	
	String DBStatus;
  	private JTextField custname;
	private JTextField addr1;
	private JTextField addr2;
	private JTextField mobile;
	private JTextField articlename;
	private JTextField price;
	private JTextField rtotax;
	private JTextField insurance;
	private JTextField accer;
	private JTextField others;
	private JTextField gross;
	private JTextField disc;
	private JTextField netamt;
	private JTextField mymodel;
	private JTextField color;
	private JTextField power;
	private JTextField qno;
	private JTextField qdate;
	private JTextField custid;
	private JPanel panel_37;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutomobileQuotation window = new AutomobileQuotation();
					window.automQuotationframe.setVisible(true);
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
	public AutomobileQuotation() throws Throwable {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 * @throws Throwable 
	 */
	private void initialize() throws Throwable {
		automQuotationframe = new JFrame();
		automQuotationframe.getContentPane().setBackground(Color.WHITE);
		automQuotationframe.setAlwaysOnTop(true);
		automQuotationframe.setBounds(10, 90, 1340, 605);
		automQuotationframe.setUndecorated(true);
		automQuotationframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		automQuotationframe.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quotation");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(12, 0, 81, 29);
		automQuotationframe.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Customer Information", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 42, 599, 176);
		automQuotationframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		//custname = new JTextField();
		custname = new gnRoundTextField(10)
		{
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		
		custname.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
 		custname.setBounds(120, 29, 411, 30);
		panel.add(custname);
		custname.setColumns(10);
		
		//addr1 = new JTextField();
		addr1 = new gnRoundTextField(10);
		addr1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
 		addr1.setBounds(120, 64, 411, 30);
		panel.add(addr1);
		addr1.setColumns(10);
		
		//addr2 = new JTextField();
		addr2 = new gnRoundTextField(10);
		addr2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
 		addr2.setBounds(120, 100, 411, 30);
		panel.add(addr2);
		addr2.setColumns(10);
		
		//mobile = new JTextField();
		mobile = new gnRoundTextField(10);
		mobile.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
 		mobile.setBounds(120, 135, 411, 30);
		panel.add(mobile);
		mobile.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(24, 36, 84, 16);
		panel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(24, 71, 84, 16);
		panel.add(lblAddress);
		
		JLabel lblMobile = new JLabel("Mobile");
		lblMobile.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblMobile.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMobile.setBounds(24, 142, 84, 16);
		panel.add(lblMobile);
		
		custid = new JTextField();
		custid.setBounds(462, 13, 69, 16);
		panel.add(custid);
		custid.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 219, 599, 104);
		automQuotationframe.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//articlename = new JTextField();
		articlename = new gnRoundTextField(10);
		articlename.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
 		articlename.setColumns(10);
		articlename.setBounds(122, 7, 356, 30);
		panel_1.add(articlename);
		
 		
		  
		
		JLabel lblNewLabel_1 = new JLabel("Vehile Name");
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(23, 12, 98, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Color");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(254, 46, 56, 16);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Power");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(379, 46, 56, 16);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_13 = new JLabel("Model");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_13.setBounds(127, 46, 56, 16);
		panel_1.add(lblNewLabel_13);
		
		//mymodel = new JTextField();
		mymodel = new gnRoundTextField(10);
		mymodel.setFont(new Font("Tahoma", Font.BOLD, 12));
 		mymodel.setBounds(122, 61, 111, 30);
		panel_1.add(mymodel);
		mymodel.setColumns(10);
		
		//color = new JTextField();
		color = new gnRoundTextField(10);
		color.setFont(new Font("Tahoma", Font.BOLD, 12));
 		color.setBounds(242, 61, 116, 30);
		panel_1.add(color);
		color.setColumns(10);
		
		//power = new JTextField();
		power = new JTextField();
		power.setFont(new Font("Tahoma", Font.BOLD, 12));
 		power.setBounds(362, 61, 116, 30);
		panel_1.add(power);
		power.setColumns(10);
		
 		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 327, 599, 214);
		automQuotationframe.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		//price = new JTextField();
		price = new gnRoundTextField(10);
		price.setText("0");
		price.setFont(new Font("Tahoma", Font.BOLD, 14));
		price.setBounds(130, 12, 116, 30);
		panel_2.add(price);
		price.setColumns(10);
		
		//rtotax = new JTextField();
		rtotax = new gnRoundTextField(10);
		rtotax.setText("0");
		rtotax.setFont(new Font("Tahoma", Font.BOLD, 14));
		rtotax.setBounds(130, 43, 116, 30);
		panel_2.add(rtotax);
		rtotax.setColumns(10);
		
		//insurance = new JTextField();
		insurance = new gnRoundTextField(10);
		insurance.setText("0");
		insurance.setFont(new Font("Tahoma", Font.BOLD, 14));
		insurance.setBounds(130, 73, 116, 30);
		panel_2.add(insurance);
		insurance.setColumns(10);
		
		
		//accer = new JTextField();
		accer = new gnRoundTextField(10);
		accer.setText("0");
		accer.setFont(new Font("Tahoma", Font.BOLD, 14));
		accer.setBounds(130, 106, 116, 30);
		accer.setColumns(10);
		panel_2.add(accer);
		
		//others = new JTextField();
		others = new gnRoundTextField(10);
		others.setText("0");
		others.setFont(new Font("Tahoma", Font.BOLD, 14));
		others.setBounds(130, 142, 116, 30);
		others.setColumns(10);
		panel_2.add(others);
		
		JLabel lblNewLabel_4 = new JLabel("Showroom Price");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(12, 19, 113, 16);
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("RTO Tax");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(38, 50, 74, 16);
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Insurance");
		lblNewLabel_6.setForeground(Color.BLACK);
		lblNewLabel_6.setBounds(12, 80, 102, 16);
		lblNewLabel_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Others");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setBounds(58, 149, 56, 16);
		lblNewLabel_7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Acceries");
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setBounds(38, 113, 76, 16);
		lblNewLabel_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(lblNewLabel_8);
		
		netamt = new JTextField();
		netamt.setBounds(298, 46, 158, 50);
		netamt.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel_2.add(netamt);
		netamt.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Net Amount");
		lblNewLabel_12.setBounds(298, 12, 158, 30);
		lblNewLabel_12.setForeground(Color.BLACK);
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 18));
		panel_2.add(lblNewLabel_12);
		
		btnSave = new JButton("Save");
		btnSave.setMnemonic('S');
		btnSave.setBounds(490, 69, 97, 30);
		panel_2.add(btnSave);
		
 		
	    btnPrint = new JButton("Print");
		btnPrint.setMnemonic('P');
		btnPrint.setBounds(490, 106, 97, 30);
		panel_2.add(btnPrint);
		
		JLabel lblNewLabel_11 = new JLabel(" ");
		lblNewLabel_11.setIcon(new ImageIcon(AutomobileQuotation.class.getResource("/RetailProduct/Rupee-15.png")));
		lblNewLabel_11.setBounds(468, 43, 56, 36);
		panel_2.add(lblNewLabel_11);
		
		JLabel lblNewLabel_16 = new JLabel("Inclusive of all taxes");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(308, 93, 158, 16);
		panel_2.add(lblNewLabel_16);
		
		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(490, 145, 97, 30);
		panel_2.add(btnClose);
		
		JPanel panel_3;
		panel_37 = new JPanel();
		panel_37.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_37.setBackground(new Color(0, 0, 153));
		panel_37.setBounds(12, 540, 599, 52);
		automQuotationframe.getContentPane().add(panel_37);
		panel_37.setLayout(null);
		
		gross = new JTextField();
		gross.setFont(new Font("Tahoma", Font.BOLD, 15));
		gross.setBounds(126, 13, 116, 30);
		panel_37.add(gross);
		gross.setColumns(10);
		
		disc = new JTextField();
		disc.setText("0");
		disc.setFont(new Font("Tahoma", Font.BOLD, 15));
		disc.setBounds(345, 13, 129, 30);
		panel_37.add(disc);
		disc.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Gross");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNewLabel_9.setBounds(58, 20, 62, 16);
		panel_37.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Discount");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 16));
		lblNewLabel_10.setBounds(277, 20, 69, 16);
		panel_37.add(lblNewLabel_10);
		
		qno = new JTextField();
		qno.setBackground(new Color(0, 51, 51));
		qno.setForeground(Color.WHITE);
		qno.setBounds(240, 3, 116, 34);
		automQuotationframe.getContentPane().add(qno);
		qno.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Quotation No:");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_14.setBounds(126, 6, 102, 16);
		automQuotationframe.getContentPane().add(lblNewLabel_14);
		
		qdate = new JTextField();
		qdate.setBackground(new Color(0, 51, 51));
		qdate.setForeground(Color.WHITE);
		qdate.setBounds(436, 3, 116, 34);
		automQuotationframe.getContentPane().add(qdate);
		qdate.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("Date");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_15.setBounds(368, 6, 56, 16);
		automQuotationframe.getContentPane().add(lblNewLabel_15);
		 
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(612, 0, 716, 592);
		automQuotationframe.getContentPane().add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));
		
		imagePanel = new JPanel();
		imagePanel.setBackground(new Color(255, 255, 255));
		panel_3.add(imagePanel, "name_9001183911753");
		imagePanel.setLayout(null);
		
 		
		ijsp = new JScrollPane();
		ijsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		ijsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		ijsp.setBounds(12, 0, 688, 574);
		imagePanel.add(ijsp);
		
		lblimage = new JLabel(" ");
		lblimage.setIcon(new ImageIcon(CustomerMaster.class.getResource("/RetailProduct/resouce/ANIM1.gif")));
		lblimage.setBounds(131, 23, 429, 407);
		//imagePanel.add(lblimage);
		
 
 		
		dataPanel = new JPanel();
		dataPanel.setBorder(null);
		dataPanel.setBackground(Color.WHITE);
		panel_3.add(dataPanel, "name_8981342908390");
		dataPanel.setLayout(null);
		
		jsp1 = new JScrollPane();
		jsp1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp1.setBounds(0, 0, 700, 587);
		dataPanel.add(jsp1);

		
 		KeyListener ky = new keyPressedlsnr();
        custname.addKeyListener(ky);
        addr1.addKeyListener(ky);
        addr2.addKeyListener(ky);
        mobile.addKeyListener(ky);
        articlename.addKeyListener(ky);
        price.addKeyListener(ky);
        insurance.addKeyListener(ky);
        rtotax.addKeyListener(ky);
        others.addKeyListener(ky);
        color.addKeyListener(ky);
        power.addKeyListener(ky);
        mymodel.addKeyListener(ky);
        accer.addKeyListener(ky);
        
		
		FocusListener fsnl = new btnfocus();
		btnSave.addFocusListener(fsnl);

		ActionListener btnLs =  new btnLsnr() ;
		btnSave.addActionListener(btnLs);
		btnPrint.addActionListener(btnLs);
		btnClose.addActionListener(btnLs);
		
		ActionListener custnameLs =  new custnameLsnr();
		custname.addActionListener(custnameLs);		
		
		ActionListener itemnameLs =  new articlenameLsnr();
		articlename.addActionListener(itemnameLs);		
 		
		decorate();
	} 
	
	
	
private void decorate() throws Throwable
{
   	String vitemimage = "e:\\tmp\\batry2.jpeg";
	setImage(vitemimage);
    vallowday = new gnDate().checkDayBegin();
 	switch (vallowday) 
	{
  	  case "Y":
	  	qdate.setText(new gnConfig().getDaybeginDate());
	   	vcomp = new gnConfig().getCompanycode() ;
		vstore = new gnConfig().getStoreID() ;
		vverticle = new gnHierarchy().getVerticleCode() ;
		String vtype = "Quotation";
 		//String vallowDate = new gnDate().checkBackDateTrAllow(vtype, qdate.getText());
 		String vallowDate = "Y";
 		switch (vallowDate) 
		{
		    case "N":
			qdate.setBackground(Color.RED);
			qdate.setForeground(Color.WHITE);
			new General().msg("Back Date For Transaction is not Allow..");
			new gnLogger().loggerInfoEntry("!!!BackDateEntry!!!", "Back Date For Transaction is not Allow..");
			new gnImageSound().playAlertSound();
			qdate.setText("?");
  			btnSave.setVisible(false);
			break;
		}
         break;
	case "N":
		automQuotationframe.dispose();
		break;
	}
 }


class btnLsnr implements  ActionListener {
 	@Override
	public void actionPerformed(ActionEvent e) {
 
 		String value  = e.getActionCommand() ;
 		
 		if (value == "Close")
 		{
 			automQuotationframe.dispose();
 		}

 		if (value == "Save")
 		{
 			
 			String status = validate() ;
 			if (status == "Sucess")
 			{
 				saveCustomer();
 				try {
 					
 					switch (EditMode) {
 					case "I":
  						qno.setText(new gnSeq().getSeqno("105", "TR"));
 						new gnLogger().loggerInfoEntry("POS",
 								"Please Note Qiotation no Generated For Sales ..." + " " + qno.getText());
  						break;
 					case "E":
 	 					//callEditProcess();
  						break;
 					}
   					callSaveEvent();
				} catch (SQLException e1) {
	 				e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
	 				e1.printStackTrace();
				} catch (IOException e1) {
	 				e1.printStackTrace();
				} catch (Throwable e1) {
	 				e1.printStackTrace();
				}
 			}
 		}
 				
 		if (value == "Print")
 		{
 			try {
				callPrint();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 		}
  		
	}
 }
	

private String  validate()
{
 	String status = "Sucess" ;

 	if(custid.getText().length() == 0)
 	{
 		new General().msg("Enter Customer Details..");
 		custname.grabFocus();
 		status = "Fail" ;
 	}
 	
 	if(custname.getText().length() == 0)
 	{
 		new General().msg("Enter Customer Details..");
 		custname.grabFocus();
 		status = "Fail" ;
  	}
 	
 	if(mobile.getText().length() == 0)
 	{
 		new General().msg("Enter Customer Details..");
 		mobile.grabFocus();
 		status = "Fail" ;
  	}

 	if(addr2.getText().length() == 0)
 	{
 		new General().msg("Enter Customer Details..");
 		addr2.grabFocus();
 		status = "Fail" ;
  	}

 	if(addr1.getText().length() == 0)
 	{
 		new General().msg("Enter Customer Details..");
 		addr1.grabFocus();
 		status = "Fail" ;
  	}

	if(articlename.getText().length() == 0)
 	{
 		new General().msg("Select Vechile..");
 		articlename.grabFocus();
 		status = "Fail" ;
  	}

	if(price.getText().length() == 0)
 	{
 		new General().msg("Enter Showroom Price..");
 		price.grabFocus();
 		status = "Fail" ;
  	}
	
	if(rtotax.getText().length() == 0)
 	{
		rtotax.setText("0");
 	}


	if(insurance.getText().length() == 0)
 	{
		insurance.setText("0");
 	}
	
	if(others.getText().length() == 0)
 	{
		others.setText("0");
 	}


	if(accer.getText().length() == 0)
 	{
		accer.setText("0");
 	}

 	return status ;
	
}



private void saveCustomer()
{

	try {
 	String vcode = "";
	String vname = "";
	String vmobile = "";
	String vaddr1 = "";
	String vaddr2 = "";
	String status = "Y";
	String vapplypromo = "Y" ;
	String vpromoStartdate=   new gnConfig().date_ConverttoDBforamt(qdate.getText());
 		String vvalue = custid.getText();
		if (vvalue.length() == 0) {
			// String status = new
			// gnSupplier().checkCustomerExists(custid.getText()) ;
			status = "N";
		} else {
			status = "Y";
		}
		
		switch (status) {
		case "N":
			vname = custname.getText().trim();
			vmobile = mobile.getText();
			vaddr1 =  addr1.getText();
			vaddr2 =  addr2.getText();
			custid.setText(new gnSupplier().getNewCustomerCode());
			vcode = custid.getText();
			new gnSupplier().SaveCustData(vcode, vname, vmobile, vaddr1, vaddr2, vapplypromo , vpromoStartdate);
 			break;
		case "Y":
			vcode = custid.getText();
			vname = custname.getText().trim();
			vmobile = mobile.getText();
			vaddr1 =  addr1.getText();
			vaddr2 =  addr2.getText();
			new gnSupplier().updateCustData(vcode, vname, vmobile, vaddr1, vaddr2);
			}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Throwable e) {
		e.printStackTrace();
	} finally {
	}
 }


private void callSaveEvent() throws Throwable
{
  	prst = null;
	final int batchSize = 10;
	int TotalRecordinsert = 0;
	this.closeconn();
	Connection con1 = this.getConnection();
	con1.setAutoCommit(false);
	String qposhdr = "Insert into ms_quotation_master( company_code, site_code,  Qno , Qdate,  "
 			+ "  Customer , Article_code, Article_Name, model , color, power ,price ,  "
 			+ "  rtotax, insurance,  accer , others ,Gross , Discount ,  netAmt , status )"
			+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? , ?)";
	try 
	{
		prst = con1.prepareStatement(qposhdr);
		prst.setString(1, vcomp);
		prst.setString(2, vstore);
		prst.setString(3, qno.getText());
		prst.setString(4, new gnConfig().date_ConverttoDBforamt(qdate.getText()));
		prst.setString(5, custid.getText());
		prst.setString(6, varticlecode);
		prst.setString(7, articlename.getText());
		prst.setString(8, mymodel.getText());
		prst.setString(9, color.getText());
		prst.setString(10, power.getText());
		prst.setString(11, price.getText());
		prst.setString(12, rtotax.getText());
		prst.setString(13, insurance.getText());
		prst.setString(14, accer.getText());
		prst.setString(15, others.getText());
		prst.setString(16, gross.getText());
		prst.setString(17, disc.getText());
		prst.setString(18, netamt.getText());
		prst.setString(19, "O");
  		prst.addBatch();
		TotalRecordinsert = TotalRecordinsert + 1;
		DBStatus = "Sucess";
		if (++TotalRecordinsert % batchSize == 0) {
			prst.executeBatch();
			DBStatus = "Sucess";
			con1.commit();
			new General().msg("Data Saved Sucessfully ..");
		}
		prst.executeBatch(); // insert remaining records
		con1.commit();
		new General().msg("Data Saved Sucessfully ..");
	} catch (SQLException e) {
		new General().msg(e.getLocalizedMessage());
		con1.rollback();
		DBStatus = "Fail";
	} finally 
	{
		if (prst != null) {
			prst.close();
 			new gnSeq().updateSeqno("105", "TR");
 		}
		if (con1 != null) {
			con1.close();
		}
 	 }
 }



 	
	
	class custnameLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				viewData() ;
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		}
	}

 

private void viewData() throws ClassNotFoundException, SQLException
{
	
    String custCol[] = { "Code ", "Name", "Mobile"};   
 	dataPanel.setVisible(true);
	imagePanel.setVisible(false);
	new gnTable().RemoveTableRows(model);
	String vname = custname.getText();
	vname = "%" + vname + "%";
 	String sql = "call Tb_getbothsuplCustomer('" + vname + "' ," + vcomp + ")";
	rs = this.getSPResult(sql);
	model.setColumnIdentifiers(custCol);
	table.setModel(model);
	while (rs.next()) {
		model.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3) });
		table.setModel(model);
		table.getCellRenderer(1, 2);
	}
	new gnTable().setTablewidth(table, 0, 50);
 	new gnTable().setTablewidth(table, 1, 350);
 	new gnTable().setTablewidth(table, 2, 60);
   	table.setEnabled(true);
	table.setGridColor(Color.gray);
	table.setBackground(Color.WHITE);
	table.setForeground(Color.BLACK);
	table.setAutoCreateRowSorter(true);
	JViewport prt1 = new JViewport();
	prt1.setBackground(Color.CYAN);
	prt1.add(table, custCol);
	prt1.setVisible(true);
	jsp1.setViewport(prt1);
 	new gnFontSetting().setMyFont(table, "F2", 12);
 	table.requestFocusInWindow();
 	table.requestFocus();
	selectRow();
	}


public void selectRow() {
	table.requestFocus();
	table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
	table.getActionMap().put("enter", new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
			int row = table.getSelectedRow();
			String value = (String) table.getValueAt(row, 0);
 			try {
				  showCustomer(value);
 			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	});
}



private  void showCustomer(String value) throws SQLException, ClassNotFoundException {
 	//btnSave.setEnabled(false);
 	String sql1 = "call  Cus_getscancustomer('"+value+"', " + vcomp + ")";
  	try{
 	rs1 = this.getSPResult(sql1);
	if (rs1.next()) 
	{
        //new General().msg(rs1.getString(1)+""+ rs1.getString(2));   
		custid.setText(rs1.getString(1));
		custname.setText(rs1.getString(2));
		String viscustomer = rs1.getString(3);
		String vsupplierType = rs1.getNString(26);
 		addr1.setText(rs1.getString(7));
		addr2.setText(rs1.getString(8));
      	mobile.setText(rs1.getString(15));
   	}
 	}catch(Exception e)
 	{ 
 	    if(e.getMessage() != null)
 	    {
 	    	new General().msg(e.getLocalizedMessage());
 	    }   	
 	}
  	finally{
  		articlename.grabFocus();
  		dataPanel.setVisible(false);
  		imagePanel.setVisible(true);
  	}
}

 
private void callPrint() throws Throwable
{
	
	
    String vpara27 = "27";
	String printinvoice = new getConfigurationSetting().getSpecificConfiguration(vpara27);
	switch (printinvoice) {
	case "Y":
 		String vdocno = qno.getText();
		 //String doctype = "Credit-INV";
		 String doctype = "AutoQ" ;
			new gnDocPrint().callprint(doctype, vdocno, qdate.getText());
			new gnLogger().loggerInfoEntry("Auto Quotation", "Printing quot");
 	    break;
	    
	case "N":
 		 vdocno = qno.getText();
 		 doctype = "AutoQ" ;
		new gnDocPrint().callprint(doctype, vdocno, qdate.getText());
		new gnLogger().loggerInfoEntry("Auto Quotation", "Printing quot");
		break ;
	}

	
 	reset();
}


	
  
 
 

class articlenameLsnr implements  ActionListener {
 	@Override
	public void actionPerformed(ActionEvent arg0) {
 		namesearch() ;
	}
 }



private void namesearch() {
	    String sname = articlename.getText().trim();
 		sname = "%" + sname + "%";
 		String varticle= "0" ;
		String vType = "Article";
		String vtrantype = "POS";
		try {
 			
 						table = new gnAdmin().Searchintabe(vType, sname, varticle, vtrantype);
  						showArticleNameSearchResult(table);
						int row =  table.getRowCount() ;
						if(row > 0 )
						{
							table.grabFocus();
 						}
						else{
							articlename.setText(null);
							articlename.grabFocus();
						}
  			
		} catch (ClassNotFoundException | SQLException e1) {
			new General().msg(e1.getLocalizedMessage());
			e1.printStackTrace();
			try {
			} catch (Throwable e2) {
				e2.printStackTrace();
			}
		} catch (Throwable e1) {
			e1.printStackTrace();
		} 
		finally 
		{
			 
 		}
 }


private void showArticleNameSearchResult(JTable mytable) {
	// new General().msg("item Search Callesd ");;
  	dataPanel.setVisible(true);
	imagePanel.setVisible(false);
	new gnTable().RemoveTableRows(model);
	articlename.setEnabled(true);
  	table = mytable;
    table.requestFocus();
   	new gnTable().setTableColWidth(table, 1, 150);
	new gnTable().setTableColWidth(table, 5, 150);
	table.setBackground(Color.black);
	table.setForeground(Color.WHITE);
	table.setSelectionForeground(Color.white);
	table.setEditingRow(0);
	JViewport prt1101 = new JViewport();
	prt1101.add(table);
	prt1101.setVisible(true);
	jsp1.setViewport(prt1101);
 	new gnTable().setFontBold(table, 14);
	 SelectArticlerow();
	 table.requestFocus(true);
	 table.setCursor(new Cursor(Cursor.HAND_CURSOR));
 }


public void SelectArticlerow() {
	 table.requestFocus(true);
	 table.setCursor(new Cursor(Cursor.HAND_CURSOR));
	 table.grabFocus();
	 table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
	 table.getActionMap().put("enter", new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
  			try{
			int row = table.getSelectedRow();
 			varticlecode = table.getValueAt(row,1).toString() ;
			articlename.setText(table.getValueAt(row,2).toString()) ;
			mymodel.setText(table.getValueAt(row,3).toString()) ;
			color.setText(table.getValueAt(row,4).toString()) ;
			power.setText(table.getValueAt(row,5).toString()) ;
			price.setText(table.getValueAt(row,7).toString()) ;
	 		}
			catch(Exception e1)
			{
				//new General().msg(e.getActionCommand());
			}
			finally{
				price.grabFocus();
			}
		
		}
	});
 }




private void setImage(String itemimage)
{
	  imagePanel.setVisible(true);
	  dataPanel.setVisible(false);
 	 	  ImageIcon ii = new ImageIcon(itemimage);
	 	  int x = ii.getIconWidth() ;
	 	  int y = ii.getIconHeight();
	 	  //imagePanel.removeAll();
	 	  lblimage = new JLabel(ii);
	 	  lblimage.setBounds(1,1, x, y);

	 	   JViewport prt111 = new JViewport();
	  	   prt111.setBackground(Color.CYAN);
	   	   prt111.setVisible(true);
	  	   prt111.add(lblimage);
	   	   ijsp.setViewport(prt111);
	       ijsp.revalidate();
	       ijsp.repaint();
		   ijsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		   ijsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		   ijsp.setAutoscrolls(true);
	       ijsp.setVisible(true);
	}



private void totals()
{
	double vprice =  Double.parseDouble(price.getText());
	double vinsuance = Double.parseDouble(insurance.getText());
	double vrtotax = Double.parseDouble(rtotax.getText());
	double vothers= Double.parseDouble(others.getText());
	double vaccer= Double.parseDouble(accer.getText());
	double vgross =  vprice +vinsuance+vrtotax+vothers+vaccer ;
 	gross.setText(Double.toString(vgross));
  	double vdisc= Double.parseDouble(disc.getText());
    double vnet = vgross - vdisc ;
    netamt.setText(Double.toString(vnet));
}
 

class keyPressedlsnr implements KeyListener {
	@Override
	public void keyPressed(KeyEvent e) {
		int value = e.getKeyCode();
		// new General().msg("Key Pressed "+ value);
		switch (value) {
		case 10:

			if (custname.isFocusOwner()) {
				addr1.grabFocus();
			}

			if (addr1.isFocusOwner()) {
				addr2.grabFocus();
			}

			if (addr2.isFocusOwner()) {
				mobile.grabFocus();
			}

			if (mobile.isFocusOwner()) {
					articlename.grabFocus();
			}

			if (articlename.isFocusOwner()) {
				mymodel.grabFocus();
			}

			if (mymodel.isFocusOwner()) {
				color.grabFocus();
			}

			if (color.isFocusOwner()) {
				power.grabFocus();
			}

			if (power.isFocusOwner()) {
				price.grabFocus();
				totals();
			}

			if (price.isFocusOwner()) {
				rtotax.grabFocus();
				totals();
 			}

			if (rtotax.isFocusOwner()) {
				insurance.grabFocus();
				totals();
 			}

			if (insurance.isFocusOwner()) {
				accer.grabFocus();
				totals();
 			}

			if (accer.isFocusOwner()) {
				others.grabFocus();
				totals();
 			}

			
			if (others.isFocusOwner()) {
				disc.grabFocus();
				totals();
			}
			
			if (disc.isFocusOwner())
			{
				totals();
 				btnSave.grabFocus();
				btnSave.setBackground(Color.white);
				btnSave.setForeground(Color.DARK_GRAY);
 			}
 			}
	}
 	@Override
	public void keyReleased(KeyEvent arg0) {
			btnSave.setBackground(Color.cyan);
		btnSave.setForeground(Color.black);
		}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}




class btnfocus implements FocusListener {
	@Override
	public void focusGained(FocusEvent e) {
			if (btnSave.isFocusOwner()) {
			btnSave.setBackground(Color.darkGray);
			btnSave.setForeground(Color.WHITE);
			} 
	}
		@Override
	public void focusLost(FocusEvent e) {
		btnSave.setBackground(Color.CYAN);
		btnSave.setForeground(Color.black);
		custname.grabFocus();
		}
}


private void reset()
{
	dataPanel.setVisible(false);
	imagePanel.setVisible(true);
	custid=null ;
	custname.setText("");
	addr1.setText("");
	addr2.setText("");
	mobile.setText("");
	price .setText("0");
	mymodel.setText("");
	color.setText("");
	power.setText("");
	others.setText("0");
	accer.setText("0");
	insurance.setText("0");
	rtotax.setText("0");
	disc.setText("0");
	gross.setText("0");
	netamt.setText("0");
 }


}//LAst 

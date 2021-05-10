package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import RetailProduct.ApplicationMenu.btnfocus;
import RetailProduct.ApplicationMenu.keyPressedlsnr;

import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JWindow;

public class ApplicationMenuL1 extends getResultSet {

	JFrame ApplicationMainFrameL1;
	JPanel panel;
	JPanel wnd = new JPanel();
	// Menu
	JMenuItem menuFlush;
	JMenuItem mntmGeneralMaster;
	JMenuItem mntmNumberSeries;
	JMenuItem mntmConfigure;
	String vverticlecode;
	JMenuItem mntmFinyear;
	JMenuItem mntmCreateLedger;
	JButton btnMasters;
	JMenuItem mnitmCreateUser;
	JMenuItem mntmCreateSociety;
	JButton btnOwner;
	JButton btnClose;

	JButton btnCreateSoc;
	JButton btnIncome;
	JButton btnExpense;
	JButton btnParking;
	JButton btnGeneral;
	JButton btnArticle;
	JButton btnDaybegin;
	JButton btnPurchase;

	private JButton btnUser;
	private JButton btnVoucher;
	private JButton btnPayment;
	private JButton btnRecords;

	JButton btnView;
	private JButton btnBill;
	private JButton btnNewButton;
	private JMenuItem mntmSetConfigSettings;
	private JMenuItem mntmBillingHeadConfiguration;
	private JButton btnLdger;
	private JMenuItem menuopenday;
	private JMenuItem menubackup;
	private JButton btnBank;
	private static JButton btnMessage;
	private JButton btnMeretoo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationMenuL1 window = new ApplicationMenuL1();
					window.ApplicationMainFrameL1.setVisible(true);
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

	
	public ApplicationMenuL1() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	
	private void initialize() throws Throwable {
		ApplicationMainFrameL1 = new JFrame();
		ApplicationMainFrameL1.setBackground(new Color(0, 0, 153));
		// ApplicationMainFrame.setForeground(new Color(0, 0, 153));
		ApplicationMainFrameL1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		ApplicationMainFrameL1.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ApplicationMenuL1.class.getResource("/RetailProduct/resouce/mymeretoosmallimage3.png")));
		ApplicationMainFrameL1.setTitle("Meretoo Application ");
		ApplicationMainFrameL1.getContentPane().setBackground(new Color(255, 255, 255));
		ApplicationMainFrameL1.setBounds(0, 4, 1394, 750);
		ApplicationMainFrameL1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ApplicationMainFrameL1.getContentPane().setLayout(null);

		ActionListener myBtnLsnr = new btnLsnr();

		panel = new JPanel();
		panel.setBounds(0, 54, 1370, 619);
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		ApplicationMainFrameL1.getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/tmp7.png")));
		lblNewLabel.setBounds(23, 229, 433, 344);
		panel.add(lblNewLabel);

		lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/tmp3.png")));
		lblNewLabel_1.setBounds(455, 229, 447, 344);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setBackground(new Color(0, 102, 153));
		lblNewLabel_2.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/tmp9.png")));
		lblNewLabel_2.setBounds(895, 229, 433, 344);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setBackground(new Color(204, 153, 204));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/DemoLogo1.png")));
		lblNewLabel_3.setBounds(1059, 13, 269, 212);
		panel.add(lblNewLabel_3);

		btnMessage = new JButton("Contact For Product Demo");
		btnMessage.setBounds(236, 674, 1121, 31);
		ApplicationMainFrameL1.getContentPane().add(btnMessage);

		btnMeretoo = new JButton("MERETOO");
		btnMeretoo.setBackground(Color.WHITE);
		btnMeretoo.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnMeretoo.setBounds(0, 674, 236, 31);
		ApplicationMainFrameL1.getContentPane().add(btnMeretoo);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1369, 53);
		ApplicationMainFrameL1.getContentPane().add(panel_1);
		panel_1.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(255, 102, 204)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);

 
		btnBill = new JButton("Billing");
		btnBill.setBounds(490, 0, 79, 48);
		btnBill.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/resouce/bill20.png")));
		btnBill.setBackground(Color.WHITE);
		btnBill.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnBill.setBorderPainted(false);
		panel_1.add(btnBill);

		// btnVoucher = new JButton("Collection");
		btnVoucher = new gnRoundButton("Voucher");
 		btnVoucher.setBounds(571, 0, 88, 48);
		btnVoucher.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/resouce/acc20.png")));
		panel_1.add(btnVoucher);
		btnVoucher.setForeground(new Color(0, 0, 128));
		btnVoucher.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnVoucher.setBackground(Color.WHITE);

		btnOwner = new JButton("Customer");
		btnOwner.setBounds(227, 0, 79, 48);
		panel_1.add(btnOwner);
		btnOwner.setMnemonic('O');
		btnOwner.setBackground(Color.WHITE);
		btnOwner.setForeground(new Color(0, 51, 0));
		btnOwner.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));

 
		btnView = new JButton("Data View");
		btnView.setBounds(662, 0, 97, 48);
		panel_1.add(btnView);
		btnView.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/resouce/datavie20.png")));
		btnView.setBackground(Color.WHITE);
		btnView.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		btnView.setForeground(new Color(0, 0, 128));
		btnView.setBorderPainted(false);

		btnLdger = new JButton("View Ledger");
		btnLdger.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnLdger.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/resouce/datavie20.png")));
		btnLdger.setBounds(762, 1, 111, 48);
		panel_1.add(btnLdger);

 
		btnDaybegin = new JButton("Open Day");
		btnDaybegin.setBackground(Color.WHITE);
		btnDaybegin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDaybegin.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/resouce/oday20.png")));
		btnDaybegin.setBounds(128, 0, 97, 48);
		panel_1.add(btnDaybegin);

		btnPurchase = new JButton("Purchase");
		btnPurchase.setBackground(Color.WHITE);
		btnPurchase.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPurchase.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/resouce/bill20.png")));
		btnPurchase.setBounds(399, 0, 88, 48);
		panel_1.add(btnPurchase);

		btnArticle = new JButton("Item");
		btnArticle.setBackground(Color.WHITE);
		btnArticle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnArticle.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/resouce/newitem20.png")));
		btnArticle.setBounds(309, 0, 88, 48);
		panel_1.add(btnArticle);

		btnMasters = new JButton("Masters");
		btnMasters.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/resouce/master20.png")));
		btnMasters.setBackground(Color.WHITE);
		btnMasters.setBounds(0, 0, 116, 48);
		panel_1.add(btnMasters);

		btnView.addActionListener(myBtnLsnr);
		btnOwner.addActionListener(myBtnLsnr);
		btnVoucher.addActionListener(myBtnLsnr);

		
		FocusListener fls = new btnfocus();

		KeyListener kk = new keyPressedlsnr();

	 	btnBill.addActionListener(myBtnLsnr);
 	 	btnLdger.addActionListener(myBtnLsnr);
 		btnArticle.addActionListener(myBtnLsnr);
		btnDaybegin.addActionListener(myBtnLsnr);
		btnPurchase.addActionListener(myBtnLsnr);
		btnMasters.addActionListener(myBtnLsnr);
  	
		btnVoucher.addFocusListener(fls);
		btnBill.addFocusListener(fls);
 		btnOwner.addFocusListener(fls);
 		btnView.addFocusListener(fls);
 		btnPurchase.addFocusListener(fls);
		btnArticle.addFocusListener(fls);
		btnDaybegin.addFocusListener(fls);
		
		btnVoucher.addKeyListener(kk);
		btnBill.addKeyListener(kk);
 		btnOwner.addKeyListener(kk);
 		btnView.addKeyListener(kk);
 		btnPurchase.addKeyListener(kk);
		btnArticle.addKeyListener(kk);
		btnDaybegin.addKeyListener(kk);
		btnMeretoo.addActionListener(myBtnLsnr);
 		 
		decorate();

	}

	// Start coding Here"
 	public static void setbottomMessage() {
		btnMessage.setText("Contact For Product Demo www.meretoo.in ");
		String vmeaagaseText = "Contact For Product Demo";
		vmeaagaseText = " " + vmeaagaseText
				+ "        |".concat("   Financial Year-" + ": " + new gnPublicVariable().currentFinYear);
		vmeaagaseText = " " + vmeaagaseText
				+ "        |".concat("   Day Begin Date Is : " + new gnPublicVariable().daybegindate);
		vmeaagaseText = " " + vmeaagaseText + "                |"
				.concat("                         Product Key Valid Upto" + " :: " + new gnPublicVariable().expdate);
		btnMessage.setText(vmeaagaseText);
		btnMessage.setBackground(Color.WHITE);
		// btnMessage.setEnabled(false);
	}

	private void decorate() throws Throwable {
		//new gnApp().setFrameTitel(ApplicationMainFrameL1);

 		setbottomMessage();
		URD();
 		btnVoucher.setVisible(false);
  		switch(EnableAccountingModule)
		{
		    case "Y":
 			btnVoucher.setVisible(true);
 		
		}	
		setOnlyForAdmin();
		vcomp = compcode;
		vstore = storecode;

		vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
 		String vaddress = new gnConfig().getcompanyAdd1() + " " + new gnConfig().getcompanyAdd2();
 		switch (vcomp) 
 		{
 		
		}
 		new gnDecorate().decorateBtn(btnVoucher, Color.BLUE, Color.WHITE);
		new gnDecorate().decorateBtn(btnBill, Color.BLUE, Color.WHITE);
 		new gnDecorate().decorateBtn(btnOwner, Color.BLUE, Color.WHITE);
 		new gnDecorate().decorateBtn(btnView, Color.BLUE, Color.WHITE);
 		new gnDecorate().decorateBtn(btnPurchase, Color.BLUE, Color.WHITE);
		new gnDecorate().decorateBtn(btnArticle, Color.BLUE, Color.WHITE);
		new gnDecorate().decorateBtn(btnDaybegin, Color.BLUE, Color.WHITE);

		btnDaybegin.setIconTextGap(2);
		btnDaybegin.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnDaybegin.setVerticalAlignment(SwingConstants.TOP);
		btnDaybegin.setHorizontalTextPosition(SwingConstants.CENTER);

		btnMasters.setIconTextGap(2);
		btnMasters.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnMasters.setVerticalAlignment(SwingConstants.TOP);
		btnMasters.setHorizontalTextPosition(SwingConstants.CENTER);

		btnPurchase.setIconTextGap(2);
		btnPurchase.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnPurchase.setVerticalAlignment(SwingConstants.TOP);
		btnPurchase.setHorizontalTextPosition(SwingConstants.CENTER);

		btnArticle.setIconTextGap(4);
		btnArticle.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnArticle.setVerticalAlignment(SwingConstants.TOP);
		btnArticle.setHorizontalTextPosition(SwingConstants.CENTER);

		btnView.setIconTextGap(2);
		btnView.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnView.setVerticalAlignment(SwingConstants.TOP);
		btnView.setHorizontalTextPosition(SwingConstants.CENTER);

		btnBill.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBill.setIconTextGap(2);
		btnBill.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBill.setVerticalAlignment(SwingConstants.TOP);
		btnBill.setHorizontalTextPosition(SwingConstants.CENTER);

 
		btnOwner.setVerticalAlignment(SwingConstants.BOTTOM);
		btnOwner.setIconTextGap(2);
		btnOwner.setIcon(new ImageIcon(ApplicationMenuL1.class.getResource("/RetailProduct/resouce/member20.png")));
		btnOwner.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnOwner.setVerticalAlignment(SwingConstants.TOP);
		btnOwner.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOwner.setOpaque(true); // changed false from true.
		btnOwner.setFocusPainted(true); // changed false from true.

		btnVoucher.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVoucher.setIconTextGap(2);
		btnVoucher.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVoucher.setVerticalAlignment(SwingConstants.TOP);
		btnVoucher.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVoucher.setOpaque(true); // changed false from true.
		btnVoucher.setFocusPainted(true); // changed false from true.

 
 
		btnLdger.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLdger.setBackground(Color.WHITE);
		btnLdger.setIconTextGap(2);
		btnLdger.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnLdger.setVerticalAlignment(SwingConstants.TOP);
		btnLdger.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLdger.setOpaque(true); // changed false from true.
		btnLdger.setFocusPainted(true); // changed false from true.
	}

	
	
	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();


			if (value == "Purchase") {
 				
				showPurchaseOption();
			}
			
			
			if (value == "Change Menu Price")
			{
			
 				try {
 					RestoMenuPriceList window;
  					window = new RestoMenuPriceList();
					window.menuPriceListFrame.setVisible(true);
 				} catch (ReflectiveOperationException | SQLException e1) {
 					e1.printStackTrace();
				}
  			}
	
			
			if (value == "Barcode Printing") {
				try {
					barcodePrinting window;
					window = new barcodePrinting();
					window.barcodeframe.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Add Barcode") {
				BarcodeMapping window = new BarcodeMapping();
				window.frameBarcodeMapping.setVisible(true);
			}

			
			if (value == "Close Day") {
				try {
					dayEnd window = new dayEnd();
					window.frameDayEnd.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Open Day") {
				try {
					DayBegin window;
					window = new DayBegin();
					window.DayBeginFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Masters") {
				showMastersOption();
			}

			if (value == "Puchase") {
 
			}

			
			if (value == "Item") {
				try {

					ArticleBase_Master window = new ArticleBase_Master();
					window.articlebasemasterFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}

			}

 
			
			if (value == "View Ledger") {
				try {
					account_ViewLedger window;
					window = new account_ViewLedger();
					window.ledgerViewFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			if (value == "Income") {
				try {
					IncomeVoucher window;
					window = new IncomeVoucher();
					window.frmIncome.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Expense") {
				try {
					ExpenseVoucher window;
					window = new ExpenseVoucher();
					window.frmExpenses.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Close") {
				ApplicationMainFrameL1.dispose();
			}

			if (value == "Create Ledger") {
				try {
					Expences_List_master window;
					window = new Expences_List_master();
					window.expenceFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Add Config Parameter") {
				try {
					CreateConfiguation window;
					window = new CreateConfiguation();
					window.Configframe.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Configuration") {
				try {
					store_configuration window;
					window = new store_configuration();
					window.storeconfigFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Close Financial Year") {
				try {
					FreezeFinYear window;
					window = new FreezeFinYear();
					window.freezefinyearFrame.setVisible(true);
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			
			if (value == "Financial Year") {
				try {
					Finyear window;
					window = new Finyear();
					window.frameFinyear.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			if (value == "Flush Data") {
				try {
					FlushData window;
					window = new FlushData();
					window.flushDataFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			if (value == "Number Series") {

				try {
					numberSeq window;
					window = new numberSeq();
					window.numseqFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			if (value == "Billing") {
				try {
					try {

						switch (vverticlecode) {

						case "1":
							POS window1;
							window1 = new POS();
							window1.POSFrame.setVisible(true);
							break;

					 
						case "15":
							POS15_1 window15;
							window15 = new POS15_1();
							window15.POSFrame15_1.setVisible(true);
							break;

						case "3":
  							//POS3_1 window3;
							//window3 = new POS3_1();
							//window3.POSFrame3_1.setVisible(true);
							//break;
  							POS3_2 window3;
							window3 = new POS3_2();
							window3.POSFrame3_2.setVisible(true);
							break;
 						}
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
					// showSalesOption();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			if (value == "Payment") {
				try {
					paymentVoucher window;
					window = new paymentVoucher();
					window.frmpaymentvoucher.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}

			}

			
			if (value == "Voucher")
			{
				showVoucherpopup();
			}
			
			if (value == "Receipts") {
				try {
					receiptVoucher window;
					window = new receiptVoucher();
					window.frmreceiptVoucher.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			if (value == "Price Change") {
				try {
				
  					updatePrice window;
					window = new updatePrice();
					window.updatePriceFrame.setVisible(true);
	   		} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			if (value == "Update Brand") {
				try {
					Article_AttriHie_Assignment window;
					window = new Article_AttriHie_Assignment();
					window.ArticleAttrHieFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Create Company") {
				try {
					Company_Master window;
					window = new Company_Master();
					window.CompanyFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Create Site") {
				try {
					Site_Master window = new Site_Master();
					window.SiteFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Customer") {
				try {
					CustomerMaster window = new CustomerMaster();
					window.CustomerFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Bank") {
				try {
					bankTransactions window;
					window = new bankTransactions();
					window.frmBusinessApplication.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "MERETOO") {
				try {
					new General().msg("Update Liense Informtion ..");
					UpdateInfo window;
					window = new UpdateInfo();
					window.updateLFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "General Masters") {
				try {
					CreateGeneralMaster window;
					window = new CreateGeneralMaster();
					window.masterFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}

			}

			if (value == "Billing Head configuration") {
				try {
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Backup DB") {
				try {
					BackupDB db = new BackupDB();
					db.TakeBackup(new gnPublicVariable().DbBackupPath());
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Open Date") {
				try {
					DayBegin window;
					window = new DayBegin();
					window.DayBeginFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Data View") {
 				showView();
				try {
				} catch (Throwable e1) {
					e1.printStackTrace();
				}

			}

			
			
			if (value == "Create User") {
				try {
					Create_User window;
					window = new Create_User();
					window.CreateUserFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			
			if (value == "Change Password") {
				try {
					ChangePassword window = new ChangePassword();
					window.ChangePasswordFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	private void URD() {
		// btnMeretoo.setEnabled(false);
		switch (vcomp) {
		case "9999":
			//menuFlush.setVisible(true);
			break;
		}
		
		
		
		
 	}

	
	
	private void setOnlyForAdmin() {
		String vuser = new General().getUsercode();
		switch (vuser) {
		case "ADMIN":
			break;
		}
	}

	
	private void showVoucherpopup()
	{
		PopupMenu pm = new PopupMenu("Voucher Entry");
		MenuItem p1 = new MenuItem("Receipts");
		MenuItem p2 = new MenuItem("Payment");
		MenuItem p3 = new MenuItem("Income");
		MenuItem p4 = new MenuItem("Expense");
		MenuItem p5 = new MenuItem("Bank");
 
		pm.add(p1);
		pm.add(p2);
		pm.add(p3);
		pm.add(p4);
		pm.add(p5);
 
		pm.addSeparator();
		wnd.setBounds(1, 10, 600, 600);
 		panel.add(wnd);
		wnd.setVisible(true);
		wnd.setBackground(Color.WHITE);
		wnd.add(pm);
		pm.show(wnd, 700, 25);

		ActionListener pmls = new btnLsnr();
		pm.addActionListener(pmls);

	}
	
	private void showView() {

		PopupMenu pm = new PopupMenu("Meretoo Data View");
		MenuItem p1 = new MenuItem("Purchase View");
		MenuItem p2 = new MenuItem("Sales View");
		MenuItem p3 = new MenuItem("A/C Voucher View");
		MenuItem p4 = new MenuItem("Inventiry View");
		MenuItem p5 = new MenuItem("GST Data View");
		MenuItem p6 = new MenuItem("GSTR1");
		MenuItem p7 = new MenuItem("GSTR2");
		MenuItem p8 = new MenuItem("GSTR4");
		MenuItem p9 = new MenuItem("Customer View");
		MenuItem p10 = new MenuItem("Supplier View");
		MenuItem p11 = new MenuItem("Day Book");

		pm.add(p1);
		pm.add(p2);
		
 		switch(EnableAccountingModule)
		{
	 		case "Y" :
	 		pm.add(p3);
  		}	
 		pm.add(p4);
		pm.add(p5);
		pm.add(p6);
		pm.add(p7);
		pm.add(p8);
		pm.add(p9);
		pm.add(p10);
		pm.add(p11);

		pm.addSeparator();
		wnd.setBounds(1, 10, 600, 600);
 		panel.add(wnd);
		wnd.setVisible(true);
		wnd.setBackground(Color.WHITE);
		wnd.add(pm);
		pm.show(wnd, 700, 25);

		ActionListener pmls = new popupLsnr();
		pm.addActionListener(pmls);
	}

	
	
	private void showMastersOption() {

		PopupMenu pm = new PopupMenu("Select Master Option");

		MenuItem p15 = null;
		MenuItem p21= null;

		MenuItem p1 = new MenuItem("Open Day");
		MenuItem p2 = new MenuItem("Create User");
		MenuItem p3 = new MenuItem("Change Password");
		MenuItem p4 = new MenuItem("General Masters");
		MenuItem p5 = new MenuItem("Number Series");
		MenuItem p6 = new MenuItem("Configuration");
		MenuItem p7 = new MenuItem("Create Ledger");
		MenuItem p8 = new MenuItem("Financial Year");
		MenuItem p9 = new MenuItem("Backup DB");
		MenuItem p10 = new MenuItem("Add Config Parameter");
		MenuItem p11 = new MenuItem("Price Change");
		MenuItem p12 = new MenuItem("Create Company");
		MenuItem p13 = new MenuItem("Create Site");
		MenuItem p14 = new MenuItem("Update Brand");
 		
		

		switch (vverticlecode) {
		case "1":
			p15 = new MenuItem("Barcode Printing");
			break;
		case "3":
			p21 = new MenuItem("Change Menu Price");
			break;
			
			
		}
		MenuItem p16 = new MenuItem("Add Barcode");
		MenuItem p17 = new MenuItem("Close Day");

		pm.add(p1);
		pm.add(p2);
		pm.add(p3);
		pm.add(p4);
		pm.add(p5);
		pm.add(p6);
		pm.add(p7);
		pm.add(p8);
		pm.add(p9);
		pm.add(p10);
		pm.add(p11);
		pm.add(p12);
		pm.add(p13);
		pm.add(p14);
		switch (vverticlecode) {
		case "1":
			pm.add(p15);
			break;
		case "3":
			pm.add(p21);
			break;
 		}

		pm.add(p16);
		pm.add(p17);

		pm.addSeparator();
		wnd.setBounds(1, 10, 600, 600);
		panel.add(wnd);
		wnd.setVisible(true);
		wnd.setBackground(Color.WHITE);
		wnd.add(pm);
		pm.show(wnd, 600, 25);

		ActionListener maslsnr = new btnLsnr();
		pm.addActionListener(maslsnr);
	}

	private void showSalesOption() {

		PopupMenu pm = new PopupMenu("Select Option");
  		MenuItem p1 = new MenuItem("Credit Sales");
		MenuItem p2 = new MenuItem("Retail");
 
	 	pm.add(p1);
		pm.add(p2);
 		pm.addSeparator();
		wnd.setBounds(1, 25, 600, 300);
		panel.add(wnd);
		wnd.setVisible(true);
		wnd.setBackground(Color.WHITE);
		wnd.add(pm);
		pm.show(wnd, 600, 25);
 		ActionListener salepmls = new SalespopupLsnr();
		pm.addActionListener(salepmls);
	}

	
	private void showPurchaseOption() {

		PopupMenu pm = new PopupMenu("Select Option");
  		MenuItem p1 = new MenuItem("Purchase Order");
		MenuItem p2 = new MenuItem("Purchase");
 
	 	pm.add(p1);
		pm.add(p2);
 		pm.addSeparator();
		wnd.setBounds(1, 25, 600, 300);
		panel.add(wnd);
		wnd.setVisible(true);
		wnd.setBackground(Color.WHITE);
		wnd.add(pm);
		pm.show(wnd, 600, 25);
 		ActionListener salepmls = new PurchasepopupLsnr();
		pm.addActionListener(salepmls);
	}

	
	
	
	class SalespopupLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String value = e.getActionCommand();
  			
			if (value == "Credit Sales") {
				creditSalesPOS window;
				try {
					window = new creditSalesPOS();
					window.creditsalesFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Quotation") {
				AutomobileQuotation window;
				try {
					window = new AutomobileQuotation();
					window.automQuotationframe.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}

			}

			if (value == "Retail") {
				try {

					switch (vverticlecode) {

					case "1":
						POS window1;
						window1 = new POS();
						window1.POSFrame.setVisible(true);
						break;

			 

					case "15":
						POS15_1 window15;
						window15 = new POS15_1();
						window15.POSFrame15_1.setVisible(true);
						break;

					case "3":
						POS3_1 window3;
						window3 = new POS3_1();
						window3.POSFrame3_1.setVisible(true);
						break;

					}
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

		}

	}

	
	
	class PurchasepopupLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
  		String value = e.getActionCommand();

  		
		if (value == "Purchase") 
		{
			try {
				GRNModule window;
				window = new GRNModule();
				window.GRNModuleFrame.setVisible(true);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}

			
			if (value  == "Purchase Order")
			{
 			 	try {
 					ManualPO window;
  					window = new ManualPO();
  					window.frmPOApplication.setVisible(true);
  			 	} catch (Throwable e1) {
 					e1.printStackTrace();
				}
  			}
	
			
 	
 			
		}
 	}


	
	class popupLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();

			
			if (value == "Supplier View") {
				viewSupplier window;
				try {
					window = new viewSupplier();
					window.supplierviewFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			
			if (value == "Customer View") {
				try {
					viewCustomer window;
					window = new viewCustomer();
					window.CustomerviewFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
			
			
			if (value == "Purchase View") {
				Daily_Purchase_View window;
				try {
					window = new Daily_Purchase_View();
					window.PurchaseViewFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			
			if (value == "Sales View") {
				try {
					Daily_Sales_View window;
					window = new Daily_Sales_View();
					window.SalesViewFrame.setVisible(true);
				} catch (Throwable e1) {
 					e1.printStackTrace();
				}
			}

			
			
			
			if (value == "A/C Voucher View") {
				try {
					viewExpIncome window;
					window = new viewExpIncome();
					window.incoFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			
			if (value == "Inventiry View") {
				try {
					CheckInventory window;
					window = new CheckInventory();
					window.frameInventoryApplication.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			
			if (value == "GST Data View") {
				GST_Reports window;
				try {
					window = new GST_Reports();
					window.GSTReportFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			
			if (value == "GSTR1") {
				try {
					GST_Filling_data window;
					window = new GST_Filling_data();
					window.gst_returnFile_data.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			
			
			if (value == "GSTR2") {
				try {
					GST_Filling_GSTR2 window;
					window = new GST_Filling_GSTR2();
					window.gst_GSTR2_Frame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "GSTR4") {
				try {
					GST_Filling_GSTR4 window;
					window = new GST_Filling_GSTR4();
					window.gst_GSTR4_Frame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Day Book") {
				try {
					dayBook window;
					window = new dayBook();
					window.dayBookFrame.setVisible(true);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	
	
	
	class btnfocus implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {

			if (btnMasters.isFocusOwner()) {
				btnMasters.setBackground(Color.BLUE);
				btnMasters.setForeground(Color.WHITE);

			}

			if (btnDaybegin.isFocusOwner()) {
				btnDaybegin.setBackground(Color.BLUE);
				btnDaybegin.setForeground(Color.WHITE);
			}

			if (btnOwner.isFocusOwner()) {
				btnOwner.setBackground(Color.BLUE);
				btnOwner.setForeground(Color.WHITE);
			}

			if (btnArticle.isFocusOwner()) {
				btnArticle.setBackground(Color.BLUE);
				btnArticle.setForeground(Color.WHITE);
			}

			if (btnPurchase.isFocusOwner()) {
				btnPurchase.setBackground(Color.BLUE);
				btnPurchase.setForeground(Color.WHITE);
			}

			if (btnBill.isFocusOwner()) {
				btnBill.setBackground(Color.BLUE);
				btnBill.setForeground(Color.WHITE);
			}

			if (btnVoucher.isFocusOwner()) {
				btnVoucher.setBackground(Color.BLUE);
				btnVoucher.setForeground(Color.WHITE);
			}

			/*
			if (btnPayment.isFocusOwner()) {
				btnPayment.setBackground(Color.BLUE);
				btnPayment.setForeground(Color.WHITE);
			}

			if (btnIncome.isFocusOwner()) {
				btnIncome.setBackground(Color.BLUE);
				btnIncome.setForeground(Color.WHITE);
			}

			if (btnExpense.isFocusOwner()) {

				btnExpense.setBackground(Color.BLUE);
				btnExpense.setForeground(Color.WHITE);
			}

			if (btnBank.isFocusOwner()) {

				btnBank.setBackground(Color.BLUE);
				btnBank.setForeground(Color.WHITE);
			}

		*/
			if (btnView.isFocusOwner()) {

				btnView.setBackground(Color.BLUE);
				btnView.setForeground(Color.WHITE);
			}

		}

		@Override
		public void focusLost(FocusEvent e) {
			setdefaultBackgnd();
			setButtonStyle();

		}
	}

	class keyPressedlsnr implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int value = e.getKeyCode();
			// new General().msg("Key Pressed "+ value);
			switch (value) {
			case 10:

				if (btnMasters.isFocusOwner()) {
					btnDaybegin.doClick();
					;
				}

				if (btnDaybegin.isFocusOwner()) {
					try {
						DayBegin window;
						window = new DayBegin();
						window.DayBeginFrame.setVisible(true);
					} catch (Throwable e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (btnOwner.isFocusOwner()) {
					btnOwner.doClick();
				}

				if (btnArticle.isFocusOwner()) {
					btnArticle.doClick();
					;
				}

				if (btnPurchase.isFocusOwner()) {

					btnPurchase.doClick();
					// btnPurchase.grabFocus();
				}

				if (btnBill.isFocusOwner()) {
					btnBill.doClick();
					btnBill.grabFocus();
				}

				if (btnVoucher.isFocusOwner()) {

					btnVoucher.doClick();
					;
				}

				if (btnPayment.isFocusOwner()) {

					btnPayment.doClick();
					;
				}

				if (btnIncome.isFocusOwner()) {

					btnIncome.doClick();
					;
				}

				if (btnExpense.isFocusOwner()) {

					btnExpense.doClick();
					;

				}

				if (btnBank.isFocusOwner()) {
					btnBank.doClick();
				}

				if (btnView.isFocusOwner()) {
					btnView.doClick();
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

	private void setdefaultBackgnd() {

		btnDaybegin.setForeground(Color.BLUE);
		btnDaybegin.setBackground(Color.WHITE);

		btnMasters.setForeground(Color.BLUE);
		btnMasters.setBackground(Color.WHITE);

		btnPurchase.setForeground(Color.BLUE);
		btnPurchase.setBackground(Color.WHITE);

		btnBill.setForeground(Color.BLUE);
		btnBill.setBackground(Color.WHITE);

		btnArticle.setForeground(Color.BLUE);
		btnArticle.setBackground(Color.WHITE);

		btnOwner.setForeground(Color.BLUE);
		btnOwner.setBackground(Color.WHITE);

		btnVoucher.setForeground(Color.BLUE);
		btnVoucher.setBackground(Color.WHITE);

 
		btnView.setForeground(Color.BLUE);
		btnView.setBackground(Color.WHITE);

 
	}

	private void setButtonStyle() {

		btnDaybegin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnMasters.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnPurchase.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnBill.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnArticle.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnOwner.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoucher.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//btnPayment.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//btnBank.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnView.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//btnIncome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//btnExpense.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

}// Last

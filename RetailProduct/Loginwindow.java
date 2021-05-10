package RetailProduct;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

import static java.awt.GraphicsDevice.WindowTranslucency.*;

import javax.accessibility.AccessibleContext;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import org.apache.commons.configuration.HierarchicalINIConfiguration;
import org.apache.commons.configuration.SubnodeConfiguration;
import org.apache.log4j.xml.DOMConfigurator;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import RetailProduct.ApplicationMenu.btnfocus;

import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Loginwindow extends getResultSet {
	public JFrame frmLoginWindow;
	JInternalFrame internalFrame;
	private JTextField ucode;
	private JPasswordField pwd;
	public JMenuBar menuBar;
	public JMenuBar xxx;
	public JPanel exePanel;
	public JLabel lbl;
	private JPanel panel1;
	private JPanel panel;
	public JMenuItem CreateUSer;
	private JButton btnCancel;
	// JToggleButton btnCancel ;
	private JButton btnSumbit;
	public JButton btnSubmit;
	private JTextField companycode;
	private JLabel complabel;

	// Db
	private String dbname;
	private String driver;
	private String url;
	private String dbuser;
	private String terminal;
	private String nodetype;

	private String Remotedbname;
	private String Remotedriver;
	private String Remoteurl;
	private String Remotedbuser;

	public static String inicompcode;
	public static String inistorecode;
	private String BranchType;
	private JTextField branchcode;
	private JLabel branchlbl;
	private JButton btnResetPassword;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_3;
	// End Db

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginwindow window = new Loginwindow();
					window.frmLoginWindow.setVisible(true);
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
	public Loginwindow() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */

	private void initialize() throws Throwable {
		frmLoginWindow = new JFrame();
		frmLoginWindow.getContentPane().setBackground(Color.WHITE);
		frmLoginWindow.setBackground(Color.WHITE);
		frmLoginWindow.setAlwaysOnTop(true);
		frmLoginWindow.setTitle("MERETOO Business Solutions");
		frmLoginWindow.setResizable(false);
		frmLoginWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLoginWindow.setBounds(350, 100, 323, 475);

		ActionListener lsnr1 = new ulsnr();
		ActionListener pwdl = new pwdLsnr();
		ActionListener ucodel = new usercodeLsnr();
		ActionListener brcodel = new brcodeLsnr();

		frmLoginWindow.getContentPane().setLayout(null);

		 panel1 = new JPanel();
		//panel1 = new gnRoundPanel();

		panel1.setForeground(new Color(102, 0, 102));
		panel1.setBackground(Color.WHITE);
		panel1.setBorder(new MatteBorder(5, 6, 5, 5, (Color) new Color(0, 153, 0)));
		panel1.setBounds(0, 0, 321, 435);
		frmLoginWindow.getContentPane().add(panel1);
		ActionListener lsnr2 = new ulsnr();
		ActionListener cmp = new compLsnr();
		panel1.setLayout(null);

		panel = new JPanel();
		panel.setForeground(Color.CYAN);
		panel.setBounds(12, 89, 293, 276);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new MatteBorder(0, 0, 0, 0, (Color) Color.WHITE));
		panel1.add(panel);
		panel.setLayout(null);

		JLabel lblCompanyCode = new JLabel("Company Code");
		lblCompanyCode.setBounds(60, 0, 139, 27);
		lblCompanyCode.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCompanyCode);
		lblCompanyCode.setForeground(new Color(0, 0, 102));
		lblCompanyCode.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		JLabel lblUserName = new JLabel("User Code");
		lblUserName.setBounds(53, 127, 146, 21);
		panel.add(lblUserName);
		lblUserName.setForeground(new Color(0, 0, 102));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));

		ucode = new gnRoundTextField(15)
		{
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		ucode.setHorizontalAlignment(SwingConstants.CENTER);

		ucode.setBounds(53, 145, 146, 28);
		panel.add(ucode);
		ucode.setForeground(Color.BLACK);
		ucode.setBackground(new Color(204, 255, 255));
		ucode.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));

		ucode.setToolTipText("Max User Code Length is 8 chars");
		ucode.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(53, 176, 146, 25);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPassword);
		lblPassword.setForeground(new Color(0, 0, 102));
		lblPassword.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));

		pwd = new gnRoundPasswordFiled(15);
		pwd.setHorizontalAlignment(SwingConstants.CENTER);
		pwd.setBounds(53, 195, 146, 28);
		panel.add(pwd);
		pwd.setForeground(Color.BLACK);
		pwd.setBackground(new Color(204, 255, 255));
		pwd.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		pwd.setToolTipText("Max 8 Chars Allow");
		pwd.setEchoChar('X');
		pwd.setColumns(10);

		companycode = new gnRoundTextField(15);
		companycode.setOpaque(false);
		companycode.setToolTipText("Enter Company Code");
		companycode.setHorizontalAlignment(SwingConstants.CENTER);
		companycode.setBounds(53, 24, 146, 28);
		panel.add(companycode);
		companycode.setBackground(new Color(204, 255, 255));
		companycode.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		companycode.setForeground(Color.BLACK);
		companycode.setColumns(10);

		complabel = new JLabel(".");
		complabel.setHorizontalAlignment(SwingConstants.CENTER);
		complabel.setBackground(new Color(51, 0, 102));
		complabel.setBounds(12, 54, 252, 16);
		panel.add(complabel);
		complabel.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		complabel.setForeground(new Color(0, 0, 153));

		JLabel lblNewLabel_2 = new JLabel("Branch Code");
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setBounds(60, 75, 129, 16);
		panel.add(lblNewLabel_2);

		branchcode = new gnRoundTextField(15);
		branchcode.setBackground(new Color(204, 255, 255));
		branchcode.setForeground(Color.BLACK);
		branchcode.setToolTipText("Enter Branch Code");
		branchcode.setHorizontalAlignment(SwingConstants.CENTER);
		branchcode.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		branchcode.setBounds(53, 91, 146, 28);
		panel.add(branchcode);
		branchcode.setColumns(10);

		branchlbl = new JLabel(" ");
		branchlbl.setFont(new Font("Calibri", Font.BOLD, 13));
		branchlbl.setBackground(Color.WHITE);
		branchlbl.setForeground(new Color(0, 0, 51));
		branchlbl.setBounds(323, 53, 249, 25);
		panel.add(branchlbl);

		btnSubmit = new JButton("Login");
		btnSubmit.setBounds(26, 235, 95, 30);
		panel.add(btnSubmit);
		btnSubmit.setToolTipText("Press Login Button ");
		btnSubmit.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnLogin1.png"));
		btnSubmit.setBackground(new Color(0, 0, 153));
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 15));
		btnSubmit.setMnemonic('L');
		btnSubmit.setForeground(new Color(0, 0, 51));
		panel1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { pwd, ucode, btnSubmit, btnCancel }));
		frmLoginWindow.getContentPane().setFocusTraversalPolicy(
				new FocusTraversalOnArray(new Component[] { internalFrame, pwd, btnSubmit, btnCancel }));

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(120, 235, 89, 30);
		panel.add(btnCancel);
		btnCancel.setSelectedIcon(new ImageIcon("D:\\AKN\\myProductImage\\btnApClose1.png"));
		btnCancel.setBackground(new Color(0, 0, 153));
		btnCancel.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCancel.setMnemonic('C');
		btnCancel.setForeground(new Color(204, 255, 153));
				
						lblNewLabel = new JLabel(" ");
						lblNewLabel.setBounds(92, 13, 90, 74);
						panel1.add(lblNewLabel);
						lblNewLabel.setIcon(new ImageIcon(Loginwindow.class.getResource("/RetailProduct/loginimage.jpg")));
						
						//lblNewLabel_1 = new JLabel("MERETOO");
						//lblNewLabel_1.setForeground(Color.WHITE);
						//lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 19));
						//lblNewLabel_1.setBounds(81, 368, 167, 30);
						//panel1.add(lblNewLabel_1);
						
						//lblNewLabel_4 = new JLabel("Complete Retail Solution");
						//lblNewLabel_4.setForeground(Color.WHITE);
						//lblNewLabel_4.setBounds(69, 401, 167, 16);
						//panel1.add(lblNewLabel_4);
						
						lblNewLabel_3 = new JLabel(" ");
						lblNewLabel_3.setIcon(new ImageIcon(Loginwindow.class.getResource("/RetailProduct/ph3.png")));
						lblNewLabel_3.setBounds(-12, 364, 333, 71);
						panel1.add(lblNewLabel_3);
		btnCancel.addActionListener(lsnr2);
		companycode.addActionListener(cmp);

		pwd.addActionListener(pwdl);
		ucode.addActionListener(ucodel);
		branchcode.addActionListener(brcodel);

 
		/*
		 * btnResetPassword = new JButton("Forgot Password");
		 * btnResetPassword.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { try { } catch (Throwable e1) {
		 * e1.printStackTrace(); } } }); btnResetPassword.setBounds(10, 441,
		 * 249, 25); //new gnDecorate().setHyperlink(btnResetPassword,
		 * "Forgot Password"); panel1.add(btnResetPassword);
		 */
		MouseListener addm = new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmLoginWindow.getContentPane().add(new pMenu().pmenu(panel1));
				frmLoginWindow.getContentPane().repaint();
				JOptionPane.showMessageDialog(frmLoginWindow, "Mouse clicked");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
		};
		frmLoginWindow.getContentPane().addMouseListener(addm);
		KeyListener keyLS = new keyPressedlsnr();
		FocusListener fls = new btnfocus();

		btnCancel.addKeyListener(keyLS);
		btnCancel.addFocusListener(fls);
		btnSubmit.addActionListener(lsnr1);
		btnSubmit.addKeyListener(keyLS);
		btnSubmit.addFocusListener(fls); 
		
		decorateComp();
	}

	class btnfocus implements FocusListener {
		@Override
		public void focusGained(FocusEvent e) {
			if (btnSubmit.isFocusOwner()) {
				btnSubmit.setBackground(Color.yellow);
			}

			if (btnCancel.isFocusOwner()) {
				btnCancel.setBackground(Color.yellow);
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			new gnStyleButton().getStyleButton(btnCancel, Color.blue, Color.WHITE);
			new gnStyleButton().getStyleButton(btnSubmit, Color.blue, Color.WHITE);
		}
	}

	class keyPressedlsnr implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int value = e.getKeyCode();
			// new General().msg("Key Pressed "+ value);
			switch (value) {
			case 10:
				if (btnSubmit.isFocusOwner()) {
					btnSubmit.doClick();
					btnSubmit.setBackground(Color.BLACK);
				}

				if (btnCancel.isFocusOwner()) {
					btnCancel.doClick();
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

	public void getEnterKeyActionForButtons() {
		frmLoginWindow.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
				.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "clickButton");
		frmLoginWindow.getRootPane().getActionMap().put("clickButton", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				Component ff = frmLoginWindow.getFocusOwner();
				new General().msg("Button Clicked Action Start" + " " + ff);
			}
		});
	}

	class pwdLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			btnSubmit.doClick();
		}
	}

	class usercodeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			pwd.grabFocus();
		}
	}

	class brcodeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ucode.grabFocus();
		}
	}

	class ulsnr implements ActionListener {
		public void actionPerformed(ActionEvent e1) {
			String value = e1.getActionCommand();
			// int i = e1.getID(); //Field id
			if (value == "Cancel") {
				frmLoginWindow.dispose();
			}
			if (value == "Login") {
				try {
					new gnLogger().loggerInfoEntry("POS", "Login Button Pressed .. ");
					String vcheck = chkLic();
					if (vcheck == "Fail") {
						System.exit(0);
					}
					String status = validateFields();
					if (status == "Sucess") {
						validate();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void decorateComp() throws Throwable {
		// getEnterAction();
		frmLoginWindow.setUndecorated(true);

		String status = new General().checkJavaPath();
		if (status == "Fail") {
			System.exit(0);
		}
		frmLoginWindow.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Loginwindow.class.getResource("/RetailProduct/mymain.png")));
		// frmLoginWindow.setIconImage(Toolkit.getDefaultToolkit().getImage(Loginwindow.class.getResource("/RetailProduct/mymainlogo_1.png")));
		new gnStyleButton().getStyleButton(btnCancel, Color.blue, Color.WHITE);
		new gnStyleButton().getStyleButton(btnSubmit, Color.blue, Color.WHITE);
		checkConfigFile(configFilePath);
		String LAF = "Nimbus";
		new gnApp().setLAF(frmLoginWindow, LAF);
		try {
			// If Ini file is used set dbname /user /drivers
			setup(configFilePath);
		} finally {
			try {
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		boolean ss = this.checktConnection();
		if (ss = false) {
			new General().msg("DB Connection Setup -->Fail");
			new General().msg(
					"Database Connection Is Not Availbale Check Connection..Close Application And Restart Your Computer..");
			new gnLogger().loggerInfoEntry("DB Connecion",
					"Database Connection Is Not Availbale Check Connection..Close Application And Restart Your Computer..");
			return;
		} else {
			new gnLogger().loggerInfoEntry("DB Connecion", "Sucess");
		}
	}

	class compLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e1) {

			// int i = e1.getID(); //Field id
			String vcomp = companycode.getText();
			if (vcomp != "9999") {
				ucode.setText(null);
				pwd.setText(null);
				pwd.setEditable(true);
				ucode.setEditable(true);
				branchcode.setText(null);
				branchcode.setBackground(Color.WHITE);
				pwd.setBackground(Color.WHITE);
				ucode.setBackground(Color.WHITE);
				pwd.setForeground(Color.DARK_GRAY);
				ucode.setForeground(Color.DARK_GRAY);
			}
			try {
				String vname = new gnConfig().checkCompany(vcomp);
				if (vname == "No Company") {
					companycode.grabFocus();
				} else {
					// int le = complabel.getText().length() ;
					complabel.setText(vname);
					branchcode.grabFocus();
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private String validateFields() {
		String vstatus = "Sucess";
		String vcomp =   companycode.getText();
		String vvstore = branchcode.getText();

		if (vcomp.length() == 0) {
			new General().msg("Enter Company Code ..");
			companycode.grabFocus();
			vstatus = "N";
		}

		if (vvstore.length() == 0) {
			new General().msg("Enter Branch Code ..");
			branchcode.grabFocus();
			vstatus = "N";
		}
 		return vstatus;
	}

	
	public void validate() throws Throwable {
		String vvstore = "";
		String ucode1 = new gnComp().getText(ucode).toUpperCase();
		String pwd1 = new General().convertPassword(pwd.getText());
	 	String vcomp = companycode.getText();
		vvstore = branchcode.getText();
		String SQl1 = "call login_storecode('" + ucode1 + "', " + vcomp + " ,'" + pwd1 + "' ,  " + vvstore + ")";
		rs1 = this.getSPResult(SQl1);
		if (rs1.next()) {
			new gnLogger().loggerInfoEntry("POS", "USer Validation ...Done");
			compcode = vcomp;
			myvcomp = compcode;
			storecode = vvstore;
			myvstore = storecode;

			new gnPublicVariable().vcomp = vcomp;
			new gnPublicVariable().vstore = vvstore;


			String vdate = new gnlcoalsqliconnection().getVerifyExpKeyForStore(vcomp, vstore);
			expdate = vdate; // Setting expdate to main panel

			String vname = new gnConfig().checkCompany(vcomp);
			complabel.setText(vname);

			new gnPublicVariable().ucode = ucode1;
			new gnPublicVariable().compcode = companycode.getText();
			new gnPublicVariable().role =         rs.getString(4).toUpperCase();
			new gnPublicVariable().storecode =    rs1.getString(1);
			new gnPublicVariable().segmentcode =  rs1.getString(2);
			new gnPublicVariable().segmentname =  rs1.getString(3);
			new gnPublicVariable().verticlecode = rs1.getString(4); // new
 			new gnPublicVariable().verticlename = rs1.getString(5);
			new gnPublicVariable().compname =     rs1.getString(6);
			new gnPublicVariable().storename =    rs1.getString(7);
			new gnPublicVariable().role = rs1.getString(9);

			// Application Configration ..
			String vdrive = "";
			String SQL = "";

			// new General().msg(ApplicationDrivename);
			SQL = "call conf_updateAppliationdrive( " + compcode + ",  " + storecode + ", '" + ApplicationDrivename
					+ "')";
			// new General().msg(SQL);
			this.getResult(SQL);

			switch (ApplicationDrivename) {
			case "D:\\":
				vdrive = "D://";
				SQL = "call conf_updateAppliationdrive( " + compcode + ",  " + storecode + ", '" + vdrive + "')";
				break;

			case "E:\\":
				vdrive = "E://";
				SQL = "call conf_updateAppliationdrive( " + compcode + ",  " + storecode + ", '" + vdrive + "')";
				break;

			case "F:\\":
				vdrive = "F://";
				SQL = "call conf_updateAppliationdrive( " + compcode + ",  " + storecode + ", '" + vdrive + "')";
				break;

			case "G:\\":
				vdrive = "G://";
				SQL = "call conf_updateAppliationdrive( " + compcode + ",  " + storecode + ", '" + vdrive + "')";
				break;

			}

			// new General().msg(SQL);
			this.getResult(SQL);
			new gnLogger().loggerInfoEntry("POS", "Application Drive set...Done");

			//new General().msg("Configuration Starts Now .. ");
 			new gnApplicationSetting().SetApplicationConfiguration(compcode, storecode);
			//new General().msg("Configuration Ends   .. ");
  			new gnLogger().loggerInfoEntry("Login", "  Final Application Configuration  set...Done");
  			new gnLogger().loggerInfoEntry("Login", "  Menu Activation Starts ");
  			
  			// this.closeconn();
    
 			String vpara = "38" ;
 			String menuLevel = new getConfigurationSetting().getSpecificConfiguration(vpara) ;
			//new General().msg("Menu Level Set "+menuLevel);
  			switch(menuLevel.toUpperCase())
 			{
 				case "M" :
 				    new ApplicationMenu().main(null);
   					break ;

 				case "L1" :
 				    //new ApplicationMenuL1().main(null);
					ApplicationMenuL1 window = new ApplicationMenuL1();
					window.ApplicationMainFrameL1.setVisible(true);
    				break ;

 				case "L2" :
	 				new ApplicationMenuL2().main(null);
	 				break ;
	 				
 				case "N" :
 	 				new ApplicationMenuL2().main(null);
 	 				break ;
 				
 				case "Y" :
 	 				new ApplicationMenuL2().main(null);
 	 				break ;
  			}
  			new gnLogger().loggerInfoEntry("Login", "  Menu Activation Complate ");
 			new gnLogger().loggerInfoEntry("Login", "Login Sucess...");
			new gnLogger().loggerInfoEntry("Login", "Storecode.." + new gnPublicVariable().storecode);
			new gnLogger().loggerInfoEntry("Login", "Login User Code is:" + "" + ucode1);
			new gnLogger().loggerInfoEntry("Login", "Setting  Application Configuration...");
			rs1.close();
			this.closeconn();
			frmLoginWindow.dispose();
		} else {
			General a = new General();
			a.msg("Please check User Code   OR Password...");
			new gnLogger().loggerInfoEntry("Login", "Wrong User Name OR Password...");
		}
	}

	private String chkLic() throws Throwable {
		String vcheck = "Sucess";
		new gnLogger().loggerInfoEntry("POS", "Level1 Sucess .. ");
		return vcheck;
	}

	private void setup(String iniFile) throws Throwable {
		new gnLogger().loggerInfoEntry("DB Connecion", "Config File Found in Login .." + iniFile);
		HierarchicalINIConfiguration iniConfObj = new HierarchicalINIConfiguration(iniFile);
		// Get Section names in ini file
		Set setOfSections = iniConfObj.getSections();
		Iterator sectionNames = setOfSections.iterator();
		while (sectionNames.hasNext()) {
			String sectionName = sectionNames.next().toString();
			SubnodeConfiguration sObj = iniConfObj.getSection(sectionName);
			Iterator it1 = sObj.getKeys();

			while (it1.hasNext()) {
				// Get element
				Object key = it1.next();
 				switch (key.toString()) {
				case "dbname":
					dbname = sObj.getString(key.toString());
					new gnLogger().loggerInfoEntry("DB Para Found in Config File ", " Para Name is ." + dbname);
					break;
				case "driver":
					driver = sObj.getString(key.toString());
					new gnLogger().loggerInfoEntry("DB Para Found in Config File ", " Para Driver is ." + driver);
					break;
				case "url":
					url = sObj.getString(key.toString());
					new gnLogger().loggerInfoEntry("DB Para Found in Config File ", " Para URL is ." + url);
					break;
				case "dbuser":
					dbuser = sObj.getString(key.toString());
					new gnLogger().loggerInfoEntry("DB Para Found in Config File ", " Para Dbuser is ." + dbuser);
					break;
				case "nodetype":
					nodetype = sObj.getString(key.toString());
					break;

				// Remote Parameters
				case "Remotedbname":
					Remotedbname = sObj.getString(key.toString());
					break;
				case "Remotedriver":
					Remotedriver = sObj.getString(key.toString());
					break;
				case "Remoteurl":
					Remoteurl = sObj.getString(key.toString());
					break;
				case "Remotedbuser":
					Remotedbuser = sObj.getString(key.toString());
					break;

				case "terminal":
					terminal = sObj.getString(key.toString());
					break;
				case "company":
					// If Company is selected through ini File
					inicompcode = sObj.getString(key.toString());
					compcode = sObj.getString(key.toString());
					companycode.setText(compcode);
					// End Company Selection
					break;
				case "store":
					storecode = sObj.getString(key.toString());
					inistorecode = sObj.getString(key.toString());
					branchcode.setText(storecode);
					break;
				case "BranchType":
					BranchType = sObj.getString(key.toString());
					new gnLogger().loggerInfoEntry("Config File Last Para", " Para Branch Type Name is ." + BranchType);
					break;
				}
			}
		}

		getResultSet setparam = new getResultSet();
		setparam.login = dbuser;
		setparam.baseurl = url;
		setparam.driver = driver;
		setparam.password = myString;
		setparam.dbname = dbname;
		setparam.myterminal = terminal;
		setparam.nodeType = nodetype;

		setparam.login = Remotedbuser;
		setparam.Remotebaseurl = Remoteurl;
		setparam.Remotedriver = Remotedriver;
		setparam.password = myString1;
		setparam.Remotedbname = Remotedbname;
		 
		// new gnBackground().loginSetBackGround(lblNewLabel_4);
		// new General().Quickmsg("DB Para Setting Done.--> DB Para Set to." +
		// ""+setparam.dbname);
		new gnLogger().loggerInfoEntry("DB Para Setting Done..",
				"  DB Para  Set to Global Parameter IS." + setparam.dbname);

 		
		//switch (inicompcode) {
 		//case "9999":
		//	String vtype = "H";
		//	setfortest(vtype);
		//	break;
		//}
	}

	
	private void setfortest(String vtype) {
		new gnLogger().loggerInfoEntry("Login", "Training Company Selected");

		switch (vtype) {
		case "H":
			ucode.setText("GPL");
			pwd.setText("gpl");
			ucode.setEditable(true);
			pwd.setEditable(true);
			break;
	
		case "S":
			ucode.setText("Admin");
			pwd.setText("datgru999");
			// ucode.setEditable(false);
			// pwd.setEditable(false);
			ucode.setEditable(true);
			pwd.setEditable(true);
		}
		
		ucode.setEnabled(true);
		pwd.setEnabled(true);
		// companycode.setBackground(Color.BLACK);
		// companycode.setForeground(Color.WHITE);
		// ucode.setBackground(Color.BLACK);
		// ucode.setForeground(Color.WHITE);
		// pwd.setBackground(Color.BLACK);
		// pwd.setForeground(Color.WHITE);

	}

	
	private void checkConfigFile(String vfile) {
		File file = new File(vfile);
		if (!file.exists()) {
			new General().msg("Config File Not Found...");
			new gnLogger().loggerInfoEntry("Login", "Something is Wrong With Setup  Please Check");
			new gnLogger().loggerInfoEntry("Login", "Check: Image Folder and Image File");
			new gnLogger().loggerInfoEntry("Login", "Exit System - Yes");
			System.exit(0);
		} else {
			new gnLogger().loggerInfoEntry("Login -->Config File Found ", "Sucess");
		}
	}

}// Last

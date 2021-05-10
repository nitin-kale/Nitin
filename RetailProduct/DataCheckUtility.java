package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.ImageIcon;

public class DataCheckUtility extends getResultSet {

	JFrame frameDataCheck;
	private JTextField companycode;
	private JTextField companyname;
	public String vcomp;
	JButton btnSalesPintofview;
	public String vstore;
	private JLabel Msg;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JButton btnStart;
	private JLabel lbl7;
	private JLabel lbl8;

	private JScrollPane jsp;
	public DefaultTableModel model = new DefaultTableModel();
	public JTable table = new JTable();
	public String Col[] = { "Type", "Company code", "Name", "Store Code", "Store Name", "Title", "Count", "Status" };
	public JViewport prt6 = new JViewport();
	private JButton btnLedgercheck;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl12;
	private JLabel lbl13;
	private JLabel lbl14;
	private JLabel lbl15;
	private JLabel lbl16;
	private JLabel lbl17;
	private JLabel lbl18;
	private JLabel lbl19;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					DataCheckUtility window = new DataCheckUtility();
					window.frameDataCheck.setVisible(true);
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
	public DataCheckUtility() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		frameDataCheck = new JFrame();
		frameDataCheck.setAlwaysOnTop(true);
		frameDataCheck.setBounds(50, 100, 1350, 508);
		frameDataCheck.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameDataCheck.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 1282, 26);
		frameDataCheck.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Data Check Utility");
		lblNewLabel.setForeground(new Color(0, 0, 102));
		lblNewLabel.setBounds(430, 0, 124, 16);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(new Color(204, 0, 153));
		panel_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
		panel_1.setBounds(0, 51, 229, 378);
		frameDataCheck.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lbl1 = new JLabel("Company Created");
		lbl1.setForeground(new Color(51, 0, 51));
		lbl1.setToolTipText("Check Company is Created Or Not");
		lbl1.setFont(new Font("Arial", Font.BOLD, 12));
		lbl1.setBounds(12, 13, 185, 16);
		panel_1.add(lbl1);

		lbl2 = new JLabel("Store Created For Company");
		lbl2.setForeground(new Color(51, 0, 51));
		lbl2.setToolTipText("Check Stores Are Created for This Company");
		lbl2.setFont(new Font("Arial", Font.BOLD, 12));
		lbl2.setBounds(12, 29, 185, 16);
		panel_1.add(lbl2);

		lbl3 = new JLabel("Number Series Created For Store");
		lbl3.setForeground(new Color(51, 0, 51));
		lbl3.setToolTipText("Check Number Series is Created or  not");
		lbl3.setFont(new Font("Arial", Font.BOLD, 12));
		lbl3.setBounds(12, 48, 225, 16);
		panel_1.add(lbl3);

		lbl4 = new JLabel("Configuration Set For Store");
		lbl4.setForeground(new Color(51, 0, 51));
		lbl4.setToolTipText("Configuration Setting is created or not ?");
		lbl4.setFont(new Font("Arial", Font.BOLD, 12));
		lbl4.setBounds(12, 65, 200, 16);
		panel_1.add(lbl4);

		lbl5 = new JLabel("Article Listing to Company");
		lbl5.setForeground(new Color(51, 0, 51));
		lbl5.setToolTipText("Articles are ctreated  ot not ");
		lbl5.setFont(new Font("Arial", Font.BOLD, 12));
		lbl5.setBounds(12, 85, 210, 16);
		panel_1.add(lbl5);

		lbl6 = new JLabel("Sales Price For Stores And Article ");
		lbl6.setForeground(new Color(51, 0, 51));
		lbl6.setToolTipText("Sales Price is Uploaded in Sales Price Table");
		lbl6.setFont(new Font("Arial", Font.BOLD, 12));
		lbl6.setBounds(12, 102, 225, 16);
		panel_1.add(lbl6);

		lbl7 = new JLabel("User Created For Each Store");
		lbl7.setForeground(new Color(51, 0, 51));
		lbl7.setToolTipText("User Created For Store ");
		lbl7.setFont(new Font("Arial", Font.BOLD, 12));
		lbl7.setBounds(12, 120, 200, 16);
		panel_1.add(lbl7);

		lbl8 = new JLabel("Role Assigned For Created Users");
		lbl8.setForeground(new Color(51, 0, 51));
		lbl8.setFont(new Font("Arial", Font.BOLD, 12));
		lbl8.setBounds(12, 138, 200, 16);
		panel_1.add(lbl8);

		lbl9 = new JLabel("Party Check in Ledger_df Table");
		lbl9.setFont(new Font("Arial", Font.BOLD, 12));
		lbl9.setForeground(new Color(51, 0, 51));
		lbl9.setToolTipText("Check Supplier/customer is available in Ledger Table And Sync Name with Gl Table");
		lbl9.setBounds(12, 159, 200, 16);
		panel_1.add(lbl9);

		lbl10 = new JLabel("Default Barcode Created for  Articles");
		lbl10.setFont(new Font("Arial", Font.BOLD, 12));
		lbl10.setForeground(new Color(51, 0, 51));
		lbl10.setToolTipText("Check Default Barcode is set with Article Code");
		lbl10.setBounds(12, 177, 210, 16);
		panel_1.add(lbl10);

		lbl11 = new JLabel("Financial Year Created");
		lbl11.setFont(new Font("Arial", Font.BOLD, 12));
		lbl11.setForeground(new Color(51, 0, 51));
		lbl11.setToolTipText("Check Financial Year Created For This Compnay and Store");
		lbl11.setBounds(12, 197, 210, 16);
		panel_1.add(lbl11);

		lbl12 = new JLabel("Check Master Table");
		lbl12.setFont(new Font("Arial", Font.BOLD, 12));
		lbl12.setForeground(new Color(51, 0, 51));
		lbl12.setToolTipText("Check Master Table  For Standard Ref. Masters");
		lbl12.setBounds(12, 215, 200, 16);
		panel_1.add(lbl12);

		lbl13 = new JLabel("Check Brand Master");
		lbl13.setFont(new Font("Arial", Font.BOLD, 12));
		lbl13.setForeground(new Color(51, 0, 51));
		lbl13.setToolTipText("Checking Bands Are Created ?");
		lbl13.setBounds(12, 235, 200, 16);
		panel_1.add(lbl13);

		lbl14 = new JLabel("Check Item Category Master");
		lbl14.setFont(new Font("Arial", Font.BOLD, 12));
		lbl14.setForeground(new Color(51, 0, 51));
		lbl14.setBackground(Color.BLACK);
		lbl14.setBounds(12, 255, 185, 16);
		panel_1.add(lbl14);

		lbl15 = new JLabel("Check SubCategory");
		lbl15.setFont(new Font("Arial", Font.BOLD, 12));
		lbl15.setForeground(new Color(51, 0, 51));
		lbl15.setBounds(12, 275, 169, 16);
		panel_1.add(lbl15);

		lbl16 = new JLabel("Check Group");
		lbl16.setFont(new Font("Arial", Font.BOLD, 12));
		lbl16.setForeground(new Color(51, 0, 51));
		lbl16.setBounds(12, 293, 158, 16);
		panel_1.add(lbl16);

		lbl17 = new JLabel("Check SubGroup");
		lbl17.setFont(new Font("Arial", Font.BOLD, 12));
		lbl17.setForeground(new Color(51, 0, 51));
		lbl17.setBounds(12, 313, 169, 16);
		panel_1.add(lbl17);

		lbl18 = new JLabel("Check Account Groups");
		lbl18.setFont(new Font("Arial", Font.BOLD, 12));
		lbl18.setForeground(Color.DARK_GRAY);
		lbl18.setBounds(12, 332, 210, 16);
		panel_1.add(lbl18);

		lbl19 = new JLabel("Check Account SubGroup");
		lbl19.setFont(new Font("Arial", Font.BOLD, 12));
		lbl19.setForeground(Color.DARK_GRAY);
		lbl19.setBounds(12, 349, 205, 16);
		panel_1.add(lbl19);

		lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setIcon(new ImageIcon(DataCheckUtility.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel_3.setBounds(0, 0, 229, 378);
		panel_1.add(lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(0, 431, 1282, 24);
		frameDataCheck.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		Msg = new JLabel(".");
		Msg.setBounds(362, 0, 908, 24);
		panel_2.add(Msg);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.setBackground(new Color(0, 204, 204));
		panel_3.setBounds(229, 51, 1105, 378);
		frameDataCheck.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		table = new JTable();
		model = new DefaultTableModel();
		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(12, 13, 1073, 365);
		panel_3.add(jsp);

		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setIcon(new ImageIcon(DataCheckUtility.class.getResource("/RetailProduct/panel12.png")));
		lblNewLabel_2.setBounds(0, 0, 1105, 378);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Company Code");
		lblNewLabel_1.setBounds(10, 28, 97, 16);
		frameDataCheck.getContentPane().add(lblNewLabel_1);

		companycode = new JTextField();
		companycode.setEnabled(false);
		companycode.setBounds(106, 25, 61, 22);
		frameDataCheck.getContentPane().add(companycode);
		companycode.setColumns(10);
		ActionListener cmp = new Company();
		companycode.addActionListener(cmp);

		companyname = new JTextField();
		companyname.setEnabled(false);
		companyname.setBounds(166, 25, 400, 22);
		frameDataCheck.getContentPane().add(companyname);
		companyname.setColumns(10);

		btnStart = new JButton("Start");
		btnStart.setMnemonic('S');
		btnStart.setBounds(567, 24, 97, 25);
		frameDataCheck.getContentPane().add(btnStart);

		btnLedgercheck = new JButton("Sync Party & Ledger ");
		btnLedgercheck
				.setToolTipText("Check Supplier/customer is available in Ledger Table And Sync Name with Gl Table");
		btnLedgercheck.setBounds(666, 24, 153, 25);
		frameDataCheck.getContentPane().add(btnLedgercheck);
		
		btnSalesPintofview = new JButton("Sales Impact");
		btnSalesPintofview.setBounds(820, 24, 153, 25);
		frameDataCheck.getContentPane().add(btnSalesPintofview);
		ActionListener strt = new btnLsnt();
		btnStart.addActionListener(strt);
		btnLedgercheck.addActionListener(strt);
		btnSalesPintofview.addActionListener(strt);
		
		Decorate();
	}

	private void Decorate() throws Throwable {
		new gnApp().setFrameTitel(frameDataCheck);
		// new gnApp().setLAF(frameDataCheck);
		new gnDecorate().DispField_Eatch(companycode, 20);
		new gnDecorate().DispField_Eatch(companyname, 20);
		new gnApp().setFrameTitel(frameDataCheck);
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		vcomp = companycode.getText();
		switch (vcomp) {
		case "0":
			companycode.setEnabled(true);
			companycode.setEditable(true);
			break;
		}
	}

	class Company implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			System.out.println(value);
			try {
				new gnAdmin().setcompany(companycode, companyname);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void syncLedgers() throws Throwable {
		new gnUtility().syncLedgerCount();
		new gnUtility().syncGlNames();
		new gnFinYear().InsertAccountBaseMaster() ;
	}

	class btnLsnt implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			// System.out.println(value);
			if (value == "Sync Party & Ledger ") {
				try {
					syncLedgers();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

			if (value == "Sales Impact")
			{
			    try {
					checkForSalesImpact();
				} catch (ClassNotFoundException | SQLException e1) {
 					e1.printStackTrace();
				}	
			}
			
			if (value == "Start") {
				try {
					new gnTable().RemoveTableRows(model);
					startChecking();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	
	private void checkForSalesImpact() throws ClassNotFoundException, SQLException
	{
	
		String vtype = "ALL" ;
		String[] Col1 =  {"Type",  "Title" , "Desc" } ;
		String vverticle = new gnHierarchy().getVerticleCode();
		String SQL = "call   DataCheck_utility1( '" + vtype + "',     " + vcomp + " ," + vstore + " , " + vverticle + ")";
		String vtype1 = "Check Company";
		int colno= 2 ;
	    vtype = "Sales Related" ;			
		showTable(SQL, Col1, vtype, colno);
	
	}
	
	private void startChecking() throws Throwable {
		// new General().msg("Checking Start") ;
		int cnt = 21;
		for (int i = 1; i < cnt; i++) {
			changeClr(i);
		}
	}

	private void changeClr(int i) throws Throwable {
		// vcomp = new ApplicationMenu().getCompanycode() ;
		vcomp = companycode.getText();
		vstore = new gnConfig().getStorecode();
		String SQL = "";
		int colno = 7 ;
		String vtype = "";
		switch (i) {
		case 1:
			lbl1.setForeground(Color.BLUE);
			Msg.setText("Checking Compnay is Created with Right Data Or Not");
			vtype = "lb1";
			String SQL1 = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			String vtype1 = "Check Company";
			showTable(SQL1, Col, vtype1, colno);
			break;
		case 2:
			lbl2.setForeground(Color.BLUE);
			Msg.setText("Checking Store is Created For This Company Or Not");
			vtype = "lb2";
			String SQL2 = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			String vtype2 = "Checking Stores";
			showTable(SQL, Col, vtype2, colno);
 			break;
		case 3:
			lbl3.setForeground(Color.BLUE);
			Msg.setText("Number Series checking for Stores");
			vtype = "lb3";
			String SQL3 = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			String vtype3 = "Number Series";
			showTable(SQL, Col, vtype3, colno);
  			break;
		case 4:
			lbl4.setForeground(Color.BLUE);
			Msg.setText("Configuration check- Stores");
			vtype = "lb4";
			String SQL4 = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			String vtype4 = "Configuration Setting";
			showTable(SQL4, Col, vtype4, colno);
 			break;
		case 5:
			lbl5.setForeground(Color.BLUE);
			Msg.setText("Article Listing to compnay");
			vtype = "lb5";
			String SQL5 = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			String vtype5 = "Article Listing to Compnay";
			showTable(SQL5, Col, vtype5, colno);
 			break;
		case 6:
			lbl6.setForeground(Color.BLUE);
			Msg.setText("Checking Sales Price Maintained for  Stores ");
			vtype = "lb6";
			String SQL6 = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			String vtype6 = "Sales Price Listing Status";
			showTable(SQL6, Col, vtype6, colno);
 			break;

		case 7:
			lbl7.setForeground(Color.BLUE);
			Msg.setText("Checking User is Created For Stores ");
			vtype = "lb7";
			String SQL7 = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			String vtype7 = "USer Created For Stores";
			showTable(SQL7, Col, vtype7, colno);
 			break;

		case 8:
			lbl8.setForeground(Color.BLUE);
			Msg.setText("Checking User Roles ");
			vtype = "lb8";
			String SQL8 = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			String vtype8 = "User Role Created";
			showTable(SQL8, Col, vtype8, colno);
 			break;

		case 9:
			lbl9.setForeground(Color.BLUE);
			vtype = "lb9";
			Msg.setText("Checking All Party is available in Ledger Default Table. ");
			vtype = "lb9";
			String SQL9 = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			String vtype9 = "Ledger Check";
			showTable(SQL9, Col, vtype9, colno);
 			break;

		case 10:
			lbl10.setForeground(Color.BLUE);
			vtype = "lb10";
			Msg.setText("Default Barcode created for Articles. ");
			String SQL10 = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			String vtype10 = "Barcode Cteated";
			showTable(SQL10, Col, vtype10, colno);
 			break;

		case 11:
			lbl11.setForeground(Color.BLUE);
			vtype = "lb11";
			Msg.setText("Checking Financial Year. ");
			String SQL11 = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			String vtype11 = "Checking Fin Year Setting";
			showTable(SQL11, Col, vtype11, colno);
 			break;

		case 12:
			lbl12.setForeground(Color.BLUE);
			vtype = "lb12";
			Msg.setText("Check Master Table");
			SQL = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			vtype = "Check Master Table";
			showTable(SQL, Col, vtype, colno);
 			break;

		case 13:
			lbl13.setForeground(Color.BLUE);
			vtype = "lb13";
			Msg.setText("Checking Bands Are Created - Optional");
			SQL = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			vtype = "Checking Bands Are Created  Optional";
			showTable(SQL, Col, vtype, colno);
  			break;

		case 14:
			lbl14.setForeground(Color.BLUE);
			vtype = "lb14";
			Msg.setText("Check Item Caegory Master -Optional ");
			SQL = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			vtype = "Checking Category Table...Optional";
			showTable(SQL, Col, vtype, colno);
  			break;

		case 15:
			lbl15.setForeground(Color.BLUE);
			vtype = "lb15";
			Msg.setText("Check SubCategory Optional");
			SQL = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			vtype = "Check SubCategory- Optional";
			showTable(SQL, Col, vtype, colno);
  			break;

		case 16:
			lbl16.setForeground(Color.BLUE);
			vtype = "lb16";
			Msg.setText("Check Group Optional");
			SQL = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			vtype = "Check Group Optional ";
			showTable(SQL, Col, vtype, colno);
 			break;

		case 17:
			lbl17.setForeground(Color.BLUE);
			vtype = "lb17";
			Msg.setText("Checking Sub Group. ");
			SQL = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			vtype = "Checking Sub Group";
			showTable(SQL, Col, vtype, colno);
 			break;

		case 18:
			lbl18.setForeground(Color.BLUE);
			vtype = "lb18";
			Msg.setText("Checking Account  Group. ");
			SQL = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			vtype = "Checking Account  Group";
			showTable(SQL, Col, vtype, colno);
  			break;

		case 19:
			lbl19.setForeground(Color.BLUE);
			vtype = "lb19";
			Msg.setText("Checking Account Sub Group. ");
			SQL = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			vtype = "Checking Account Sub Group";
			showTable(SQL, Col, vtype, colno);
  			break;

		case 20:
			// lbl20.setForeground(Color.BLUE);
			vtype = "lb20";
			Msg.setText("Checking Account Ledger . ");
			SQL = "call   DataCheck_utility( '" + vtype + "',     " + vcomp + " ," + vstore + " )";
			vtype = "Checking Account  Ledger";
			showTable(SQL, Col, vtype, colno);
  			break;

		}
	}

	
	private void showTable(String SQL, String Col[], String vtype , int colno) throws ClassNotFoundException, SQLException {
		model.setColumnIdentifiers(Col);
		rs = this.getSPResult(SQL);
		table.setModel(model);
 		try {
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, colno, "N", "Y", vtype);
		} catch (Exception e) {
			new General().msg(e.getMessage());
		}
		new gnTable().setTableMarginHeight(table, 25, 1);
		table.setEnabled(false);

		JTableHeader th = table.getTableHeader();
		th.setBackground(Color.BLACK);
		th.setForeground(Color.DARK_GRAY);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setFont(new Font("Arial", 14, 15));
		((DefaultTableCellHeaderRenderer) th.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);

		JViewport prt = new JViewport();
		prt.setBackground(Color.DARK_GRAY);
		prt.add(table);
		prt.setVisible(true);
		jsp.setViewport(prt);

	}
}// Last

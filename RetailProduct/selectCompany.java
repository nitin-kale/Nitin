package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import org.apache.commons.configuration.HierarchicalINIConfiguration;
import org.apache.commons.configuration.SubnodeConfiguration;

import com.jidesoft.swing.IconBorder;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JEditorPane;

public class selectCompany extends getResultSet {

	public JFrame SelectComFrame;
	String colhead[] = { "Company", "Code", "Name", "Phone", "Fin.Year", "Start Date", "End Date" };
	String colhead1[] = { "Company", "Code", "Name", "Branch", "Branch Name", "Phone", "Fin.Year", "Start Date",
			"End Date" };

	// Db
	private String dbname;
	private String driver;
	private String url;
	JLabel lblmsg ;
	JButton btnClose;

	private String dbuser;
	private String nodetype;

	private String Remotedbname;
	private String Remotedriver;
	private String Remoteurl;
	private String Remotedbuser;

	private String terminal;
	// private String BranchType;

	JScrollPane jsp;
	JLabel lblcompany;
	public DefaultTableModel model = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return column == 0 || column == 1 || column == 2 ? false : true;
		}
	};

	//// Table Related
	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			// 3 4 5 6 9 10 15 16
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 1 || column == 2 || column == 3 || column == 4 || column == 5 || column == 6
					|| column == 7) {
				componentt.setBackground(Color.white);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
				componentt.setCursor(getCursor());
			}

			if (roww != 0) {
				componentt.setBackground(Color.black);
				componentt.setForeground(Color.ORANGE);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
			}

			if (roww == 0) {
				componentt.setBackground(Color.darkGray);
				componentt.setForeground(Color.white);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 11));
			}

			return componentt;

		}
	};
	///

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectCompany window = new selectCompany();
					window.SelectComFrame.setVisible(true);
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
	public selectCompany() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 * 
	 */
	private void initialize() throws Throwable {
		SelectComFrame = new JFrame();
		SelectComFrame.setResizable(false);
		SelectComFrame.getContentPane().setForeground(Color.WHITE);
		SelectComFrame.getContentPane().setFont(new Font("Cambria", Font.BOLD, 16));
		SelectComFrame.getContentPane().setBackground(new Color(0, 255, 255));
		SelectComFrame.setAlwaysOnTop(true);
		SelectComFrame.setBackground(Color.WHITE);
		SelectComFrame.setBounds(325, 250, 489, 403);
		SelectComFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SelectComFrame.getContentPane().setLayout(null);

		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setIcon(new ImageIcon(selectCompany.class.getResource("/RetailProduct/ph11.png")));
		lblNewLabel_4.setBounds(830, 5, 14, 279);
		SelectComFrame.getContentPane().add(lblNewLabel_4);

		// JPanel panel = new JPanel();
		JPanel panel = new gnRoundPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panel.setBounds(0, 5, 471, 365);
		SelectComFrame.getContentPane().add(panel);
		panel.setLayout(null);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 58, 459, 249);
		panel.add(jsp);
		jsp.setViewportBorder(new CompoundBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 0), null, new Color(255, 0, 255), null),
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP,
						null, new Color(0, 0, 0))));
		// JButton btn = new JButton();
		JViewport prt6 = new JViewport();
		prt6.setBackground(Color.WHITE);
		prt6.setBorder(null);

		prt6.setToolTipText("Select Financial Year ");
		prt6.setScrollMode(0);
		prt6.transferFocus();
		prt6.grabFocus();
		prt6.add(table, colhead);
		jsp.setViewport(prt6);

		lblcompany = new JLabel("--");
		lblcompany.setBounds(12, 24, 277, 19);
		panel.add(lblcompany);
		lblcompany.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		new gnFontSetting().setMyFont(lblcompany, "F2", 16);

		lblcompany.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblNewLabel = new JLabel("Select Financial Year ");
		lblNewLabel.setBounds(12, 0, 261, 26);
		panel.add(lblNewLabel);

		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 17));
		new gnFontSetting().setMyFont(lblNewLabel, "F1", 15);
		lblNewLabel.setForeground(new Color(51, 51, 0));

		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SelectComFrame.dispose();
			}
		});
		btnClose.setMnemonic('C');
		btnClose.setIcon(new ImageIcon(selectCompany.class.getResource("/RetailProduct/btnClose.png")));
		btnClose.setBounds(390, 13, 69, 41);
		panel.add(btnClose);
		
		JEditorPane dtrpnNoteChangingFinancial = new JEditorPane();
		dtrpnNoteChangingFinancial.setText("Note: Changing financial will Close Previous Fin Year & Assign Opening Balance For Selected financial Year");
		dtrpnNoteChangingFinancial.setBounds(0, 306, 459, 46);
		panel.add(dtrpnNoteChangingFinancial);
		
		lblmsg = new JLabel(" ");
		lblmsg.setBounds(12, 38, 321, 16);
		panel.add(lblmsg);

		decorate();

	}

	private void decorate() throws Throwable {
		lblcompany.setText(new gnConfig().getCompanyname());
		String status = new General().checkJavaPath();
		if (status == "Fail") {
			System.exit(0);
		}

		SelectComFrame.setTitle("MERETOO Business Appliccation");
		SelectComFrame.setFont(new Font("Cambria", Font.BOLD, 16));
		SelectComFrame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(selectCompany.class.getResource("/RetailProduct/mymain.png")));
		// SelectComFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(Loginwindow.class.getResource("/RetailProduct/mymainlogo_2.png")));

		checkConfigFile(configFilePath);
		setup(configFilePath);

		String SQL = "Call  comp_showcompanyStores(" + myvcomp + ", " + myvstore + ")";
		model.setColumnIdentifiers(colhead);
		// String colhead[] = {"Company", "Code" , "Branch" , "Name", "Phone" ,
		// "Fin.Year", "Start Date" , "End Date"} ;
		String colhead[] = { "Fin.Year", "Start Date", "End Date" };

		String vtype = "Company";
		new gnTableModel().Tablemodel(table, model, SQL, colhead, 3, "N", "N", vtype);
		table.setModel(model);
		show(table);
		removeDefaultComp();
		new gnLogger().loggerInfoEntry("Select Company", "Start Selection");
	}

	private void removeDefaultComp() {
		// int r = 0 ;
		// model.removeRow(r);
	}

	private void show(JTable table) {
		table.requestFocus();
		new gnTable().setTableColWidth(table, 0, 50);
		new gnTable().setTableColWidth(table, 1, 30);
		new gnTable().setTableColWidth(table, 2, 30);
		new gnTable().setTableBasics(table);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		table.setBackground(Color.blue);
		table.setForeground(Color.white);
		table.setRowHeight(27);
		new gnTable().setFontBold(table, 19);
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		table.requestFocus();
		try {
			selectRow();
		} catch (IOException e) {
			e.printStackTrace();
		}
		selectRow1();
	}

	public void selectRow() throws IOException {
		// this.checkInternetConnection() ;
 		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				// String colhead[] = {"Company", "Code" , "Branch" , "Name",
				// "Phone" , "Fin.Year", "Start Date" , "End Date"} ;

				String valuecomp = myvcomp;
				String valuestore = myvstore;
				String vfinyear = (String) table.getValueAt(row, 0);
				try {
					compcode = valuecomp;
					storecode = valuestore;
					vcomp = compcode;
					vstore = storecode;
					// String vcheck = "Sucess" ;

					String vstartDate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(row, 1).toString());
					String vendDate = new gnConfig().date_ConverttoDBforamt(table.getValueAt(row, 2).toString());

					String vdate = new gnlcoalsqliconnection().getVerifyExpKeyForStore(vcomp, vstore);
					expdate = vdate; // Setting expdate to main panel

					
					
					String vcurrentsetFinyear = new gnFinYear().getiniFinYear(compcode, vstore);
					new gnPublicVariable().setfinyearis = vcurrentsetFinyear;
					new gnFinYear().setSelectedFinForSelectedCompany(vfinyear); // Set
 
					isFinyearFreeze = new gnFinYear().getFinyearFreezeStatus();

					/*
					if (setfinyearis.trim().equals(currentFinYear.trim())) {
						SelectComFrame.dispose();
						new gnLogger().loggerInfoEntry("Selected Same Fin year", "Finyear Same...");
					}
					*/

					//if (!setfinyearis.equals(vfinyear)) {
						
					    new General().Quickmsg("Closing Financial  Year Please Wait...");
						new gnLogger().loggerInfoEntry("Login", "Closing Financial Year...");
						new gnDecorate().setBusyCursor(SelectComFrame);
 						
						//Main Section 
					     
						//new gnDecorate().setBusyCursor(SelectComFrame);
						lblmsg.setText("Please Wait..Process may take longer time");
   					    new gnFinYear().closeFinYear(); //new addition below line was old logic 
					      
  					     //Old Logic if didnt work uncomment this
  					     //new gnFinYear().InsertAccountBaseMaster(); //Group/SubGroup/Gl From _Df to main
 					     //new Finyear().calculatePrvYearClosingsAndAssignOpening();
						 //new Finyear().calculateCurrentYearClosings(vstartDate, vendDate);
  					     
  					     //End Old Logic if didnt work uncomment this
  					     
					     //Main Section 
 						 new gnDecorate().setDefaultCursor(SelectComFrame);
 						 new General().msg("New Financial Year Set Restart Application");
 						 SelectComFrame.dispose();
  						 System.exit(0);
 
					//}
  					new gnLogger().loggerInfoEntry("Select Company", "Company Selection Over");
					new gnLogger().loggerInfoEntry("Fin Year Close", "Fin Year Process Sucess");
 				} catch (Throwable e1) {
					new gnLogger().loggerInfoEntry("Fin Year Close", "Fin Year Process Fail <SelectCompany>");
					new General().msg("Fin Year Closing Error Please Check Process <SelectCompany> Process>");
 					e1.printStackTrace();
				} // showCustData();
			}
		});
	}

	public void selectRow1() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, 0), "eqal");
		table.getActionMap().put("eqal", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					String SQL = "Call  comp_showcompany()";
					model.setColumnIdentifiers(colhead);
					String vtype = "Company";
					new gnTable().RemoveTableRows(model);
					new gnTableModel().Tablemodel(table, model, SQL, colhead, 3, "N", "Y", vtype);
					show(table);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void checkConfigFile(String vfile) {
		File file = new File(vfile);
		if (!file.exists()) {
			new General().msg("Something is Wrong With Setup  Please Check (Exit system-1");
			new gnLogger().loggerInfoEntry("Select Company", "Check: Image Folder and Image File");
			new gnLogger().loggerInfoEntry("Select Company", "Exit System - Yes");
			System.exit(0);
		}
	}

	private void setup(String iniFile) throws Throwable {
		// new General().msg( "file 2:"+ iniFile);
		HierarchicalINIConfiguration iniConfObj = new HierarchicalINIConfiguration(iniFile);
		// Get Section names in ini file
		Set setOfSections = iniConfObj.getSections();
		Iterator sectionNames = setOfSections.iterator();
		while (sectionNames.hasNext()) {
			String sectionName = sectionNames.next().toString();
			SubnodeConfiguration sObj = iniConfObj.getSection(sectionName);
			Iterator it1 = sObj.getKeys();

			while (it1.hasNext()) {
				Object key = it1.next();
				switch (key.toString()) {
				case "dbname":
					dbname = sObj.getString(key.toString());

					break;
				case "driver":
					driver = sObj.getString(key.toString());
					break;
				case "url":
					url = sObj.getString(key.toString());
					break;
				case "dbuser":
					dbuser = sObj.getString(key.toString());
					break;
				case "terminal":
					terminal = sObj.getString(key.toString());
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

				case "company":
					break;
				case "store":
					break;
				case "BranchType":
					BranchType = sObj.getString(key.toString());
					break;
				case "ApplicationDrive":
					// ApplicationDrivename = sObj.getString(key.toString())

					;
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

		// new General().Quickmsg("DB Name Set "+ " :"+dbname );
		// new General().Quickmsg("Second Configueation File Set ");

	}
}// Last

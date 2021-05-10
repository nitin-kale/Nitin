package RetailProduct;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

public class numberSeq extends getResultSet {

	JFrame numseqFrame;
	JInternalFrame internalFrame;
	private JTextField companycode;
	private JTextField companyname;
	String vfinyear = "";
	JButton btnExport;
	String SQL;
	String vinsertMaster = "";
	String vinsertTransaction = "";
	JButton btnGl;
	JButton btnSubgroup;
	JButton btnGroup;
	JButton btnNumberseq;

	private JTextField companyname1;
	private JTextField Storecode;
	private JScrollPane cjsp;
	private JTextField storename;
	private JTextField newstorecode;
	private JTextField newstorename;
	private String vcomp;
	private String vstore;
	private JButton btnSave;
	private JButton btnView;
	private JButton btnUpdate;
	private JTextField finyear;
	JButton btnDataCheckUtility;

	String tran[] = { "Compnay Code", "StoreCode", "Tran_type", "Tran_name", "FinYear_start", "FinYear_End",
			"StartNumber", "Max Number", "LastNumber", "FinYear" };

	/// Model for Transaction sequences
	JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 5 || column == 6 || column == 8 || column == 9 || column == 10
					|| column == 16 || column == 17 || column == 18 || column == 21) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.BOLD, 12));
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 12));
			}
			return componentt;

		}
	};

	JTable ctable = new JTable();
	DefaultTableModel cmodel = new DefaultTableModel();

	DefaultTableModel model = new DefaultTableModel() {
		public boolean isCellEditable(int row, int column) {
			return column == 6 || column == 7 || column == 8 ? true : false;
		}
	};

	JScrollPane jsp = new JScrollPane();

	// Model for Master Sequences
	JTable mtable = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (column == 0 || column == 3 || column == 5 || column == 6 || column == 8 || column == 9 || column == 10
					|| column == 16 || column == 17 || column == 18 || column == 21) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Calibri", Font.BOLD, 12));
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Calibri", Font.BOLD, 12));
			}
			return componentt;

		}
	};

	DefaultTableModel mmodel = new DefaultTableModel();
	JScrollPane mjsp = new JScrollPane();

	/// Search Model
	JTable stable = new JTable();
	DefaultTableModel smodel = new DefaultTableModel();
	JScrollPane sjsp = new JScrollPane();
	String mast[] = { "StoreCode", "Master_type", "Tran_name", "FinYear_start", "FinYear_End", "StartNumber",
			"Max Number", "LastNumber" };

	String accCol[] = { "Company", "Site", "Fin.Year", "Code", "Name", "Op.Bal", "Op.Bal DrcrType", "Cl.Bal",
			"Cl.DrcrType", "Active" };
	private JButton btnCreateFinYear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					numberSeq window = new numberSeq();
					window.numseqFrame.setVisible(true);
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
	public numberSeq() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		numseqFrame = new JFrame();
		numseqFrame.setTitle("Business Application - Stand Alone Store");
		numseqFrame.setType(Type.UTILITY);
		numseqFrame.setAlwaysOnTop(true);
		numseqFrame.setBounds(350, 21, 895, 675);
		numseqFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		numseqFrame.getContentPane().setLayout(null);

		internalFrame = new JInternalFrame("Transaction Number Sequence Managment");
		internalFrame.setBounds(0, 0, 900, 675);
		numseqFrame.getContentPane().add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 858, 125);
		panel.setBorder(UIManager.getBorder("DesktopIcon.border"));
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCompnayCode = new JLabel("Compnay Code");
		lblCompnayCode.setFont(new Font("Arial", Font.PLAIN, 13));
		lblCompnayCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompnayCode.setBounds(6, 13, 105, 16);
		panel.add(lblCompnayCode);

		JLabel lblStoreCode = new JLabel("Store Code");
		lblStoreCode.setFont(new Font("Arial", Font.PLAIN, 13));
		lblStoreCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStoreCode.setBounds(22, 35, 89, 16);
		panel.add(lblStoreCode);

		companycode = new JTextField();
		companycode.setFont(new Font("Cambria", Font.BOLD, 12));
		companycode.setForeground(new Color(0, 0, 51));
		companycode.setBackground(Color.WHITE);
		companycode.setToolTipText("Press Enter to getHelp");
		companycode.setBounds(116, 9, 49, 22);
		panel.add(companycode);
		companycode.setEnabled(false);
		companycode.setColumns(10);
		ActionListener cmp = new Company();
		companycode.addActionListener(cmp);

		Storecode = new JTextField();
		Storecode.setFont(new Font("Cambria", Font.BOLD, 12));
		Storecode.setForeground(new Color(0, 0, 51));
		Storecode.setToolTipText("Press Enter to Get Help");
		Storecode.setBounds(116, 32, 49, 22);
		panel.add(Storecode);
		Storecode.setColumns(10);
		// Storecode.setText(new gnConfig().getStoreID());
		ActionListener str = new store();
		Storecode.addActionListener(str);

		storename = new JTextField();
		storename.setFont(new Font("Cambria", Font.BOLD, 12));
		storename.setForeground(new Color(0, 0, 51));
		storename.setBackground(Color.WHITE);
		storename.setEditable(false);
		storename.setBounds(164, 32, 313, 22);
		panel.add(storename);
		storename.setColumns(10);
		ActionListener strnamelsnr = new storenamelsnr();
		ActionListener an3 = new btnLsnr();

		companyname = new JTextField();
		companyname.setFont(new Font("Cambria", Font.BOLD, 12));
		companyname.setForeground(new Color(0, 0, 51));
		companyname.setBackground(Color.WHITE);
		companyname.setEditable(false);
		companyname.setBounds(164, 9, 313, 22);
		panel.add(companyname);
		companyname.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_3.setBounds(0, 56, 477, 69);
		panel.add(panel_3);
		panel_3.setLayout(null);

		newstorename = new JTextField();
		newstorename.setBounds(163, 33, 314, 30);
		newstorename.setForeground(new Color(0, 0, 51));
		panel_3.add(newstorename);
		newstorename.setBackground(Color.WHITE);
		newstorename.setFont(new Font("Cambria", Font.BOLD, 12));
		newstorename.setEditable(false);
		newstorename.setColumns(10);
		// storename.setText(new gnConfig().getStorename(Storecode.getText()));

		newstorecode = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		newstorecode.setBounds(112, 33, 49, 30);
		panel_3.add(newstorecode);
		newstorecode.setToolTipText("Press Enter For Store Selection for Number Seq.");
		newstorecode.setForeground(new Color(0, 0, 51));
		newstorecode.setFont(new Font("Cambria", Font.BOLD, 12));
		newstorecode.setColumns(10);

		JLabel lblNewLabel = new JLabel("Create Seq.");
		lblNewLabel.setBounds(6, 33, 105, 16);
		panel_3.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblNewLabel_1 = new JLabel("For Store");
		lblNewLabel_1.setBounds(15, 51, 96, 16);
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));

		JLabel lblNewLabel_2 = new JLabel("Financial Year");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(6, 4, 105, 16);
		panel_3.add(lblNewLabel_2);

		finyear = new JTextField();
		finyear.setFont(new Font("Cambria", Font.BOLD, 15));
		finyear.setBounds(116, 1, 105, 22);
		panel_3.add(finyear);
		finyear.setColumns(10);
		
				cjsp = new JScrollPane();
				cjsp.setBounds(474, 35, 372, 90);
				panel.add(cjsp);
				cjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				JViewport prt11 = new JViewport();
				prt11.add(ctable);
				prt11.setVisible(true);
				cjsp.setViewport(prt11);
				
				btnCreateFinYear = new JButton("Create Fin Year");
				btnCreateFinYear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
 						try {
 							
 							numseqFrame.dispose();
  							Finyear window;
  							window = new Finyear();
							window.frameFinyear.setVisible(true);
 							 
  						} catch (Throwable e) {
 							e.printStackTrace();
						}
  					}
				});
				btnCreateFinYear.setBounds(663, 2, 183, 32);
				panel.add(btnCreateFinYear);
 
		btnView = new JButton("Edit");
		btnView.setBackground(Color.CYAN);
		btnView.setMnemonic('E');
		btnView.setBounds(692, 436, 75, 25);
		ActionListener an = new btnLsnr();
		btnView.addActionListener(an);
		internalFrame.getContentPane().add(btnView);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.CYAN);
		btnCancel.setMnemonic('C');
		ActionListener an1 = new btnLsnr();
		btnCancel.addActionListener(an1);

		btnCancel.setBounds(767, 436, 91, 25);
		internalFrame.getContentPane().add(btnCancel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(0, 149, 872, 288);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		jsp = new JScrollPane();
		jsp.setViewportBorder(
				new BevelBorder(BevelBorder.RAISED, Color.ORANGE, Color.GREEN, Color.YELLOW, Color.MAGENTA));
		jsp.setBounds(12, 0, 846, 288);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel_1.add(jsp);

		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setIcon(new ImageIcon(numberSeq.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel_3.setBounds(0, 0, 872, 288);
		panel_1.add(lblNewLabel_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 464, 872, 137);
		internalFrame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		mjsp = new JScrollPane();
		mjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		mjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mjsp.setBounds(12, 0, 848, 130);
		panel_2.add(mjsp);

		JLabel lblNewLabel_4 = new JLabel(" ");
		lblNewLabel_4.setIcon(new ImageIcon(numberSeq.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel_4.setBounds(0, 0, 872, 137);
		panel_2.add(lblNewLabel_4);

		JButton btnStoreNumber = new JButton("Branch - Transaction Number Sequence ");
		btnStoreNumber.setEnabled(false);
		btnStoreNumber.setBounds(146, 124, 163, 25);
		internalFrame.getContentPane().add(btnStoreNumber);

		JLabel lblCompnayLevelNumber = new JLabel("Compnay Level Number Sequence For Masters ");
		lblCompnayLevelNumber.setBounds(0, 445, 327, 16);
		internalFrame.getContentPane().add(lblCompnayLevelNumber);

		btnUpdate = new JButton("Update");
		btnUpdate.setBackground(Color.CYAN);
		btnUpdate.setEnabled(false);
		btnUpdate.setMnemonic('U');
		btnUpdate.setBounds(601, 436, 91, 25);
		ActionListener an11 = new btnLsnr();
		btnUpdate.addActionListener(an11);

		internalFrame.getContentPane().add(btnUpdate);

		btnSave = new JButton("Save");
		btnSave.setBounds(516, 436, 86, 25);

		internalFrame.getContentPane().add(btnSave);
		btnSave.setBackground(Color.CYAN);
		btnSave.setMnemonic('S');
		btnSave.setEnabled(false);

		JPanel accpanel = new JPanel();
		accpanel.setBackground(Color.WHITE);
		accpanel.setBounds(480, 124, 378, 24);
		internalFrame.getContentPane().add(accpanel);
		accpanel.setLayout(null);

		btnGroup = new JButton("Group");
		btnGroup.setForeground(new Color(0, 0, 51));
		btnGroup.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGroup.setMnemonic('A');
		btnGroup.setBounds(0, 0, 89, 25);
		accpanel.add(btnGroup);

		btnSubgroup = new JButton("Sub Group");
		btnSubgroup.setForeground(new Color(0, 0, 51));
		btnSubgroup.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubgroup.setMnemonic('S');
		btnSubgroup.setBounds(89, 0, 97, 25);
		accpanel.add(btnSubgroup);

		btnGl = new JButton("Account GL");
		btnGl.setForeground(new Color(0, 0, 51));
		btnGl.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGl.setMnemonic('G');
		btnGl.setBounds(185, 0, 105, 25);
		accpanel.add(btnGl);

		btnExport = new JButton("Export");
		btnExport.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExport.setMnemonic('E');
		btnExport.setBounds(291, 0, 87, 25);
		accpanel.add(btnExport);

		btnNumberseq = new JButton("Number Sequence");
		btnNumberseq.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNumberseq.setMnemonic('N');
		btnNumberseq.setBounds(281, 124, 198, 25);
		internalFrame.getContentPane().add(btnNumberseq);
		
		btnDataCheckUtility = new JButton("Data Check Utility");
		btnDataCheckUtility.setHorizontalAlignment(SwingConstants.LEFT);
		btnDataCheckUtility.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnDataCheckUtility.setBounds(0, 124, 150, 25);
		internalFrame.getContentPane().add(btnDataCheckUtility);
		internalFrame.setVisible(true);
		btnGl.addActionListener(an11);
		btnSubgroup.addActionListener(an11);
		btnGroup.addActionListener(an11);
		btnExport.addActionListener(an11);
		btnNumberseq.addActionListener(an11);
		btnDataCheckUtility.addActionListener(an11);
 		newstorecode.addActionListener(strnamelsnr);

		decorate();
		setData();
	}

	class Company implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			System.out.println("Reached ");
			int i = e.getID(); // Field Id
			try {
				new gnAdmin().setcompany(companycode, companyname);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}

	class store implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			System.out.println("Reached ");
			int i = e.getID(); // Field Id
			try {
				vcomp = companycode.getText();
				new gnAdmin().setstore(Storecode, storename, vcomp);
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				try {
					setData();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class storenamelsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
 			try {
				String vcomp = companycode.getText();
				new gnAdmin().setstore(newstorecode, newstorename, vcomp);
			} catch (SQLException e1) {
				new General().msg(e1.getMessage());
			} catch (Exception e1) {
				e1.printStackTrace();
			} catch (Throwable e1) {
				e1.printStackTrace();
			} finally {
				try {
					// CheckMasterSeq() ;
					CheckForAction();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	class btnLsnr implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id

			if (value == "Number Sequence") {
				try {
					setData();
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
				}
			}

			if (value == "Export") {
				new Export_Table_Data_to_Excel().exportTable(table);
			}

			
			if (value == "Data Check Utility")
			{
 				try {
 					DataCheckUtility window;
  					window = new DataCheckUtility();
					window.frameDataCheck.setVisible(true);
 				} catch (Throwable e1) {
 					e1.printStackTrace();
				}
 	
			}
			
			
			if (value == "Group") {
				String vtype = "Group";
				SQL = "call Account_getRecordCount('" + vtype + "', " + vcomp + ", " + vstore + ", '" + vfinyear + "')";
				try {
					showTransaction(SQL, accCol, vtype);
					if (table.getRowCount() == 0) {
						checkAndPostAccountMasters();
				}
				} catch (Exception e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Sub Group") {
				String vtype = "SubGroup";
				SQL = "call Account_getRecordCount('" + vtype + "', " + vcomp + ", " + vstore + ", '" + vfinyear + "')";
				try {
					showTransaction(SQL, accCol, vtype);
					if (table.getRowCount() == 0) {
						checkAndPostAccountMasters();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
 					e1.printStackTrace();
				}
			}

			if (value == "Account GL") {
				String vtype = "GL";
				SQL = "call Account_getRecordCount('" + vtype + "', " + vcomp + ", " + vstore + ", '" + vfinyear + "')";
				try {
					showTransaction(SQL, accCol, vtype);
					if (table.getRowCount() == 0) {
						checkAndPostAccountMasters();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
 					e1.printStackTrace();
				}
			}

			if (value == "Update") {
				try {
					updateMasterSequnces(mtable);
					updateSequnces(table);
				} catch (Exception e1) {
					new General().msg(e1.getLocalizedMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
				}
			}

			if (value == "Cancel") {
				numseqFrame.dispose();
			}

			if (value == "Create") {
				try {
				} catch (Exception e1) {
					new General().msg(e1.getMessage());
					e1.printStackTrace();
				}
			}

			if (value == "Edit") {
				edit();
			}
		}
	}

	public void decorate() throws Throwable {
		new gnApp().setCompanyTitle(internalFrame);
		new gnApp().setFrameTitel(numseqFrame);
		finyear.setText(new gnFinYear().getReportingFinYear());
		vfinyear = finyear.getText();
		finyear.setEditable(false);
		if (vfinyear.length() == 0) {
			new General().msg("Financial  year is not set , Please set Financial Year");
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			newstorecode.setEditable(false);
			newstorecode.setBackground(Color.RED);
			newstorecode.setText("????");
			finyear.setText("????");
			finyear.setBackground(Color.RED);
			newstorecode.setEnabled(false);
		}
		new gnField().closeform(internalFrame, numseqFrame);
		String vuser = new gnConfig().getUserCode().toUpperCase();
		companycode.setText(new gnConfig().getCompanyCode());
		companyname.setText(new gnConfig().getCompany());
		Storecode.setText(new gnConfig().getStoreID());
		storename.setText(new gnConfig().getStorename(Storecode.getText()));

		new gnDecorate().decorateBtn(btnGl, new Color(56, 189, 112), Color.BLACK);
		new gnDecorate().decorateBtn(btnExport, new Color(178, 11, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnGroup, new Color(178, 11, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnSubgroup, new Color(178, 11, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnNumberseq, new Color(178, 11, 112), Color.WHITE);

		new gnStyleButtonSqr().getStyleButton(btnGl, new Color(178, 11, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnExport, new Color(120, 151, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnGroup, new Color(131, 211, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnSubgroup, new Color(56, 189, 112), Color.BLACK);
		new gnStyleButtonSqr().getStyleButton(btnNumberseq, new Color(56, 189, 112), Color.WHITE);

		vcomp = companycode.getText();
		vstore = Storecode.getText();

		switch (vcomp) {
		case "0":
			companycode.setEnabled(true);
			Storecode.setEditable(true);
		}
	}

	public void setData() throws Throwable {
		vcomp = companycode.getText();
		vstore = Storecode.getText();
		String vvstore = "0";
		String check = "";
		String checkstore = " ";
		String vtypeMS = "MS";
		String vtypeTR = "TR";
		check = "Availbale";

		String SQL = "call num_getSequencesMaster(" + vcomp + " , " + vstore + ",  '" + vtypeTR + "', '" + vfinyear
				+ "')";
		String vtype = "Tran";
		showTransaction(SQL, tran, vtype);

		String SQL1 = "call num_getSequencesMaster(" + vcomp + " , '" + vstore + "',  '" + vtypeMS + "', '" + vfinyear
				+ "')";
		showMaster(SQL1);

		String SQL3 = "call num_SeriesSetStoreList(" + vcomp + " )";
		showStores(SQL3);

	}

	public void shownewData() throws Throwable {
		vcomp = companycode.getText();
		vstore = newstorecode.getText();
		String vvstore = "0";
		String check = "";
		String checkstore = " ";
		String vtypeMS = "MS";
		String vtypeTR = "TR";
		check = "Availbale";
		String SQL = "call num_getSequencesMaster(" + vcomp + " , " + vstore + ",  '" + vtypeTR + "', '" + vfinyear
				+ "')";
		showTransaction(SQL, tran, vtypeTR);
		String vvcomp = "0";
		String SQL1 = "call num_getSequencesMaster(" + vcomp + " , '" + vstore + "',  '" + vtypeMS + "'  , '" + vfinyear
				+ "')";
		showMaster(SQL1);
		String SQL3 = "call num_SeriesSetStoreList(" + vcomp + " )";
		showStores(SQL3);
	}

	private void CheckForAction() throws Throwable {
		int rowstores = table.getRowCount();
		int rowcompany = mtable.getRowCount();
		int option = new General().msgInput("Would You Like To Create Number Sequences For  New Store ");
		CheckStoreSeqExist();
	}

	public String CheckMasterSeq() throws Throwable {
		String vstatus = "Sucess";
		String vcomp = new gnConfig().getCompanyCode();
		// new General().msg("checking Master Seq." );
		String SQL = "Call  Num_checkMasterSeq(" + vcomp + ")";
		rs = this.getSPResult(SQL);
		rs.next();
		String vcount = rs.getString(1);
		new General().msg("Records Available For Master Seq ..." + " " + vcount);
		switch (vcount) {
		case "0":
			vinsertMaster = "Y";
			break;
		default:
			vinsertMaster = "N";
			break;
		}
		return vinsertMaster;
	}

	private String InsertMasterSeq() throws SQLException, ClassNotFoundException {
		// new General().msg("Inserting Rows For Master Seq ...");
		String vstatus = "Sucess";
		vcomp = companycode.getText();
		vstore = newstorecode.getText();
		String SQL = "Call  Num_InsertMasterSeq(" + vcomp + ", " + vstore + ", '" + vfinyear + "')";
		this.getSPResult(SQL);
		return vstatus;
	}

	private void CheckStoreSeqExist() throws Throwable {
		String status = "Fail";
		vcomp = companycode.getText();
		vstore = newstorecode.getText();
		// String SQL5 = "call num_checkSeqForStore("+vcomp+", "+vstore+",
		// '"+vfinyear+"')";
		String SQL5 = "call Num_checkTRSeq(" + vcomp + ", " + vstore + ", '" + vfinyear + "')";
		rs = this.getSPResult(SQL5);
		rs.next();
		if (rs.next()) {
			new General().msg("Number <TR>sequence is present for this store..");
			vinsertMaster = "N";
			vinsertTransaction = "N";
			return;
		} else {
			vinsertTransaction = "Y";
			InsertNewStore();
		}
	}

	private void InsertNewStore() throws Throwable {
		new General().msg("Inserting new Store...");
		String check = "Not Available";
		vcomp = companycode.getText();
		vstore = newstorecode.getText();
		String vstartDate = new gnFinYear().getFirstDateofFinYear();
		String vendDate = new gnFinYear().getLastDateofFinYear();
		vstartDate = new gnConfig().date_ConverttoDBforamt(vstartDate);
		vendDate = new gnConfig().date_ConverttoDBforamt(vendDate);
		vinsertMaster = CheckMasterSeq();

		String SQL7 = "call num_updateNewStore(" + vcomp + ", " + vstore + ",  '" + vstartDate + "' ,  '" + vendDate
				+ "', '" + vfinyear + "')";
		this.getSPResult(SQL7);

		if (vinsertTransaction == "Y" && vinsertMaster == "Y") {
			String SQL9 = "call   num_InsertNewStore(" + vcomp + ", " + vstore + ")";
			this.getSPResult(SQL9);
			shownewData();
		}

		if (vinsertTransaction == "Y" && vinsertMaster == "N") {
			String SQL9 = "call   num_InsertTRSeq(" + vcomp + ", " + vstore + ")";
			this.getSPResult(SQL9);
			shownewData();
		}

		if (vinsertTransaction == "Y") {
			checkAndPostAccountMasters();
		}
	}

	private void edit() {
		int row = table.getRowCount();
		if (row > 0) {
			table.setEnabled(true);
			table.setBackground(Color.WHITE);
			table.setForeground(Color.BLUE);
			DefaultCellEditor nk4 = new gnTable().cellEdit(table);
			DefaultCellEditor nk5 = new gnTable().cellEdit(mtable);
			mtable.setEnabled(true);
			mtable.setBackground(Color.WHITE);
			mtable.setForeground(Color.BLUE);
			btnUpdate.setEnabled(true);
			btnSave.setEnabled(false);
		} else {
			new General().msg("No Record Found");
		}
	}

	/// Transaction
	public void showTransaction(String SQL, String[] col, String vtype) throws SQLException, Exception {
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(col);
		table.setModel(model);
		table = new gnTableModel().Tablemodel(table, model, SQL, col, 10, "N", "N", vtype);
		table.setBackground(Color.CYAN);
		table.setForeground(Color.BLACK);
		table.setEnabled(false);
		boolean cn = this.checktConnection();
		JViewport prt = new JViewport();
		prt.add(table, col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		table.setGridColor(Color.gray);
	}

	/// Master
	public void showMaster(String SQL1) throws SQLException, Exception {
		// String mast[] = {"Company Code", "StoreCode" , "Master_type" ,
		// "Tran_name" ,
		// "FinYear_start" ,"FinYear_End" ,
		// "StartNumber" , "Max Number" , "LastNumber" } ;

		String mast[] = { "Company Code", "StoreCode", "Master_type", "Tran_name", "StartNumber", "Max Number",
				"LastNumber" };

		new gnTable().RemoveTableRows(mmodel);
		mmodel.setColumnIdentifiers(mast);
		mtable.setModel(mmodel);
		String vtype = "Master";

		rs = this.getSPResult(SQL1);
		while (rs.next()) {
			mmodel.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getString(6), rs.getString(7) });
		}
		// mtable = new gnTableModel().Tablemodel(mtable, mmodel, SQL1, mast,
		// 9,"N", "N", vtype);
		mtable.setEnabled(false);
		mtable.setRowHeight(30);
		mtable.setBackground(Color.CYAN);
		mtable.setForeground(Color.BLACK);
		mtable.setEnabled(false);
		JViewport prt1 = new JViewport();
		prt1.add(mtable, mast);
		prt1.setVisible(true);
		mjsp.setViewport(prt1);
		mtable.setGridColor(Color.gray);
	}

	/// Master
	public void showStores(String SQL) throws SQLException, Exception {
		/// new General().msg( SQL1);
		String store[] = { "Store", "Name", "company", "Availbale" };
		new gnTable().RemoveTableRows(cmodel);
		cmodel.setColumnIdentifiers(store);
		ctable.setModel(cmodel);
		String vtype = "Stores";
		ctable = new gnTableModel().Tablemodel(ctable, cmodel, SQL, store, 4, "N", "N", vtype);
		ctable.setEnabled(false);
		ctable.setBackground(Color.CYAN);
		ctable.setForeground(Color.BLACK);
		ctable.setEnabled(false);
		ctable.setGridColor(Color.gray);
	}

	public void updateMasterSequnces(JTable table) throws Throwable {
		String DBhdr = "Sucess";
		prst = null;
		final int batchSize = 8;
		int TotalRecordinsert = 0;
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String seq = "update ms_number_seq set  " + "number_start_series= ?, " + "number_end_series= ? ,"
				+ "Lastnumber = ?   " + "where   transaction_type = ?  and Company_code = ?  and site_code = ?";
		try {
			int row = table.getRowCount();
			for (int i = 0; i < row; i++) {
				// {"Company Code", "StoreCode" , "Master_type" , "Tran_name"
				// ,"StartNumber" , "Max Number" , "LastNumber" } ;
				String startno = table.getValueAt(i, 4).toString();
				String endno = table.getValueAt(i, 5).toString();
				String lastno = table.getValueAt(i, 6).toString();
				String vcomp = table.getValueAt(i, 0).toString();
				String vstore = table.getValueAt(i, 1).toString();
				String vtrantype = table.getValueAt(i, 2).toString();

				// new General().msg(vcomp+" "+vstore+" "+startno + " "+ endno
				// +" "+lastno);
				prst = con1.prepareStatement(seq);
				prst.setString(1, startno);
				prst.setString(2, endno);
				prst.setString(3, lastno);
				prst.setString(4, vtrantype);
				prst.setString(5, vcomp);
				prst.setString(6, vstore);
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBhdr = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBhdr = "Sucess";
					con1.commit();
				}
				prst.executeBatch(); // insert remaining records
				con1.commit();
			}
		} catch (SQLException e) {
			con1.rollback();
			DBhdr = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con1 != null) {
				con1.close();
			}
			// new General().msg(" Updated Sucessfully ..");
			// new gnTable().RemoveTableRows(model);
			btnUpdate.setEnabled(true);
			// setData() ;
		}
	}

	public void updateSequnces(JTable table) throws Throwable {
		String DBhdr = "Sucess";
		prst = null;
		final int batchSize = 8;
		int TotalRecordinsert = 0;
		Connection con1 = this.getConnection();
		con1.setAutoCommit(false);
		String seq = "update ms_number_seq set  " + "number_start_series= ?, " + "number_end_series= ? ,"
				+ "Lastnumber = ?   "
				+ "where   transaction_type = ?  and Company_code = ?  and site_code = ? and finyear = ?";
		try {
			int row = table.getRowCount();
			for (int i = 0; i < row; i++) {
				String startno = table.getValueAt(i, 6).toString();
				String endno = table.getValueAt(i, 7).toString();
				String lastno = table.getValueAt(i, 8).toString();
				String vcomp = table.getValueAt(i, 0).toString();
				String vstore = table.getValueAt(i, 1).toString();
				String vtrantype = table.getValueAt(i, 2).toString();
				// new General().msg(vcomp+" "+vstore+" "+startno + " "+ endno
				// +" "+lastno);
				prst = con1.prepareStatement(seq);
				prst.setString(1, startno);
				prst.setString(2, endno);
				prst.setString(3, lastno);
				prst.setString(4, vtrantype);
				prst.setString(5, vcomp);
				prst.setString(6, vstore);
				prst.setString(7, vfinyear);
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBhdr = "Sucess";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBhdr = "Sucess";
					con1.commit();
				}
				prst.executeBatch(); // insert remaining records
				con1.commit();
			}
		} catch (SQLException e) {
			con1.rollback();
			DBhdr = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con1 != null) {
				con1.close();
			}
			new General().msg(" Updated Sucessfully ..");
			// new gnTable().RemoveTableRows(model);
			btnUpdate.setEnabled(true);
			// setData() ;
		}
	}

	public void checkAndPostAccountMasters() throws Throwable {
		//new gnFinYear().checkAndPostAccountBaseMasters(); old if not work uncomment this 
		new gnLogger().loggerInfoEntry("NumberSeq-->ginfinyear()", "Crating Account Base Msser..");
 		new gnFinYear().closeFinYear();
		
	}
}// last
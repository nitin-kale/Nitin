package RetailProduct;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

public class dayBook extends getResultSet {

	JFrame dayBookFrame;

	Thread dayBookThread ;
	public final static int INTERVAL = 9000;
    String timerStatus = "Stop" ;
 	Timer timer = null ;
 	
 	JButton btnClose ;
 	JButton btnPrint ;
 	
 	private volatile boolean exit = false;
  	private JTextField trdate;
	private JScrollPane jsp1;
	private JScrollPane jsp;
 	private JTextField todate;
	private JLabel lblNewLabel_2;
	private JTextField searchname;
	private JTextField code;
	String vcomp;
	String vparty;
 	String vpartyname;
	String vstore;
	String vdate;
	String showparty = "N";
	String vamount;
  	
	JPanel panel;
 	 
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel smodel = new DefaultTableModel();

	JTable table = new JTable();

	public JTable stable = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			if (getValueAt(roww, 1).toString().equalsIgnoreCase(code.getText())) {
				componentt.setBackground(Color.BLUE);
				componentt.setForeground(Color.white);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			} else {
				componentt.setBackground(Color.white);
				componentt.setForeground(Color.blue);
				componentt.setFont(new Font("Calibri", Font.BOLD, 14));
				componentt.setFont(new Font("Calibri", Font.PLAIN, 14));
			}
			return componentt;
		}
	};
 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dayBook window = new dayBook();
					window.dayBookFrame.setVisible(true);
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
	public dayBook() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		dayBookFrame = new JFrame();
		dayBookFrame.getContentPane().setBackground(Color.WHITE);
		dayBookFrame.setAlwaysOnTop(true);
		dayBookFrame.setBounds(5, 99, 1365, 600);
		dayBookFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dayBookFrame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(12, 13, 988, 41);
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.ORANGE, null, null, null));
		panel.setBackground(Color.WHITE);
		dayBookFrame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(116, 0, 37, 16);
		panel.add(lblNewLabel);

		trdate = new JTextField();
		trdate.setBounds(116, 13, 116, 25);
		trdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		trdate.setForeground(Color.DARK_GRAY);
		trdate.setBackground(Color.WHITE);
		panel.add(trdate);
		trdate.setColumns(10);

		JButton btnLeft = new JButton("Left");
		btnLeft.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLeft.setBounds(366, 10, 97, 35);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				table.requestFocus();
			}
		});
		btnLeft.setMnemonic('L');
		panel.add(btnLeft);

		todate = new JTextField();
		todate.setBounds(238, 13, 116, 25);
		todate.setFont(new Font("Tahoma", Font.BOLD, 15));
		todate.setForeground(Color.DARK_GRAY);
		todate.setBackground(Color.WHITE);
		panel.add(todate);
		todate.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(238, 0, 25, 16);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Party Seach By Name");
		lblNewLabel_2.setBounds(475, 7, 211, 23);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));

		searchname = new JTextField();
		searchname.setBounds(698, 0, 252, 37);
		panel.add(searchname);
		searchname.setColumns(10);

		code = new JTextField();
		code.setBounds(952, 0, 31, 37);
		panel.add(code);
		code.setEnabled(false);
		code.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Day Book");
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 14));
		lblNewLabel_3.setBounds(12, 0, 105, 32);
		panel.add(lblNewLabel_3);

		jsp = new JScrollPane();
		jsp.setBounds(22, 62, 442, 496);
		dayBookFrame.getContentPane().add(jsp);

		jsp1 = new JScrollPane();
		jsp1.setViewportBorder(new CompoundBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP,
						null, new Color(255, 255, 0)),
				new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 0), new Color(255, 0, 255),
						new Color(0, 0, 255), new Color(255, 200, 0))));
		jsp1.setBounds(469, 56, 869, 502);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		dayBookFrame.getContentPane().add(jsp1);
		
		JPanel mainpanel = new JPanel();
		mainpanel.setBorder(new MatteBorder(5, 8, 5, 8, (Color) new Color(0, 0, 153)));
		mainpanel.setBackground(Color.WHITE);
		mainpanel.setBounds(0, 0, 1358, 571);
		dayBookFrame.getContentPane().add(mainpanel);
		mainpanel.setLayout(null);
		
		btnClose = new JButton("Close");
		btnClose.setForeground(new Color(0, 0, 153));
		btnClose.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		btnClose.setMnemonic('C');
		btnClose.setBounds(1194, 13, 141, 40);
		mainpanel.add(btnClose);
		
		btnPrint = new JButton("Print");
		btnPrint.setForeground(new Color(0, 0, 153));
		btnPrint.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 15));
		btnPrint.setBounds(1071, 13, 122, 40);
		mainpanel.add(btnPrint);
		ActionListener trls = new trLsnr();
		todate.addActionListener(trls);

		ActionListener srchls = new searchlsnr();
		searchname.addActionListener(srchls);

		ActionListener btnAction = new btnLsnr();
		btnClose.addActionListener(btnAction);
		btnPrint.addActionListener(btnAction);
 
		decorate();
 	}

	 
	private void decorate() throws Throwable {

		new gnApp().setFrameTitel(dayBookFrame);
 		//dayBookFrame.setUndecorated(true);
  		new gnField().closeform(panel, dayBookFrame);
		trdate.setText(new gnConfig().getDaybeginDate());
		todate.setText(new gnConfig().getDaybeginDate());
		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		new gnField().moveLeft(table);
		showData();

	}

	
 
	private void showData() throws Throwable {
		String vstatus = new gnFinYear().checkDateRanegforFinyear(trdate.getText(), todate.getText());
		if (vstatus == "Sucess") {
			new gnTable().RemoveTableRows(model);
			String Col[] = { "Transaction", "Type", "No.of.Records", "Amount" };
			String vdate1 = new gnConfig().date_ConverttoDBforamt(trdate.getText());
			String vdate2 = new gnConfig().date_ConverttoDBforamt(todate.getText());
			String sql = "call  day_getTransactionforDay( '" + vdate1 + "' ,'" + vdate2 + "' ,  " + vcomp + ", "
					+ vstore + ") ";
			model.setColumnIdentifiers(Col);
			new gnTableModel().Tablemodel(table, model, sql, Col, 4, "N", "N", "N");
			new gnTable().setTablewidth(table, 0, 150);
			new gnTable().setTablewidth(table, 1, 250);
			new gnTable().setTablewidth(table, 2, 130);
			// new gnTable().setTablewidth(table,4,130);
			JViewport prt = new JViewport();
			prt.add(table, Col);
			new gnTable().setTableBasics(table);
			prt.setVisible(true);
			jsp.setViewport(prt);
			prt.setBackground(Color.WHITE);
			// new gnField().moveRightToTable(stable);

			// new General().msg("row"+ " "+super.vmyrow);
			if (table.getRowCount() > 0) {
				if (vmyrow > 0) {
					getTransactions(super.vmyrow);
				} else {
					getTransactions(1);
				}
			}
			table.setFont(new Font("Arial", Font.BOLD, 12));
			//activateTimer() ;
 			Selectrow();
		}
	}

	public void Selectrow() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.requestFocus();
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				try {
					getTransactions(row);
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
				}
				;
			}
		});
	}

	

	public void getTransactions(int row) throws ClassNotFoundException, SQLException {
		String vtransaction = table.getValueAt(row, 0).toString();
 		String vtransactionType = table.getValueAt(row, 1).toString();
		// String vdocno = table.getValueAt(row, 0).toString() ;
		String vdocdate = new gnConfig().date_ConverttoDBforamt(trdate.getText());
		String vdocdate1 = new gnConfig().date_ConverttoDBforamt(todate.getText());
		String SQL = "";
		SQL = "call day_getAllDocument('" + vtransaction + "' , " + vcomp + ", " + vstore + ", '" + vdocdate + "' , '"
				+ vdocdate1 + "')";
 		new General().msg(SQL);
		String col[] = { "Doc.Type", "Code", "Name", "Document Date", "Document No", "Amount" };
		showTransaction(SQL, vtransaction, col);
	}

	
	
	private void showTransaction(String SQL, String vtransaction, String[] col)
			throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(smodel);
		smodel.setColumnIdentifiers(col);
		new gnTableModel().Tablemodel(stable, smodel, SQL, col, 5, "N", "Y", vtransaction);
		if (stable.getRowCount() > 0) {
			new gnTable().setTablewidth(stable, 0, 200);
			new gnTable().setTablewidth(stable, 1, 100);
			new gnTable().setTablewidth(stable, 2, 250);
			stable.setRowHeight(30);
			stable.setShowGrid(false);
			new gnTable().setTableBasics(stable);
			JViewport prt1 = new JViewport();
			prt1.add(stable, col);
			prt1.setVisible(true);
			jsp1.setViewport(prt1);
			prt1.setBackground(Color.WHITE);
			new gnFontSetting().setMyFont(stable, "F2", 10);
			stable.setBackground(Color.black);
			stable.setForeground(Color.WHITE);
 		}
		Selectrow1();
	}

	
	
	public void Selectrow1() {
		stable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		stable.requestFocus();
		stable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = stable.getSelectedRow();
				try {
					showDocumentNow(row);
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
				}
				;
			}
		});
	}

	


	private void showDocumentNow(int row) throws Throwable {
		String vtype = stable.getValueAt(row, 0).toString();
		vparty = stable.getValueAt(row, 1).toString();
		vpartyname = stable.getValueAt(row, 2).toString();
		String vdocno = stable.getValueAt(row, 4).toString();
		String vdocdate = new gnConfig().date_ConverttoDBforamt(stable.getValueAt(row, 3).toString());
		String vdocdate1 = stable.getValueAt(row, 3).toString();
		vamount = stable.getValueAt(row, 5).toString();
 		switch (vtype) {

		case "Sales Order":
			new gnEdit().showSalesOrder(vdocno, vdocdate1);
			break;

 		case "Sales":
			new gnEdit().showSales(vdocno, vdocdate1);
			break;
		case "Purchase":
			new gnEdit().ShowGRN(vparty, vdocno, vdocdate1);
			break;
		case "Receipts":
			new gnEdit().showExpIncome(vdocno, vdocdate1, "RV");
			break;
		case "Payment":
			new gnEdit().showExpIncome(vdocno, vdocdate1, "PV");
			break;
		case "Contra":
			new gnEdit().showExpIncome(vdocno, vdocdate1, "CON");
			break;
		case "PO":
			new gnEdit().ShowPO(vparty, vdocno, vdocdate1);
			break;
		case "Pur.Return":
			new gnEdit().ShowPR(vparty, vdocno, vdocdate1);
			break;
		case "Sales Return":
			new gnEdit().ShowSR(vparty, vdocno, vdocdate1);
			break;
		case "SuplAdvance":
			String vdoctype = "SAD";
			new gnSupplier().rcustcode = vparty;
			new gnSupplier().rcustName = vpartyname;
			new gnEdit().ShowAdvance(vparty, vdocno, vdocdate1, vdoctype, vamount);
			break;
		case "CustAdvance":
			vdoctype = "CAD";
			new gnSupplier().rcustcode = vparty;
			new gnSupplier().rcustName = vpartyname;
			new gnEdit().ShowAdvance(vparty, vdocno, vdocdate1, vdoctype, vamount);
			break;

		case "Expense":
			vdoctype = "EX";
			new gnSupplier().rcustcode = vparty;
			new gnSupplier().rcustName = vpartyname;
			new gnEdit().showExpIncome(vdocno, vdocdate1, "EX");
			break;

		case "Expense-Oth":
			vdoctype = "EXO";
			new gnSupplier().rcustcode = vparty;
			new gnSupplier().rcustName = vpartyname;
			new gnEdit().showExpIncome(vdocno, vdocdate1, "EXO");
			break;

		case "Income":
			vdoctype = "IN";
			new gnSupplier().rcustcode = vparty;
			new gnSupplier().rcustName = vpartyname;
			new gnEdit().showExpIncome(vdocno, vdocdate1, "IN");
			break;
		case "JV":
			vdoctype = "JV";
			new gnSupplier().rcustcode = vparty;
			new gnSupplier().rcustName = vpartyname;
			new gnEdit().showExpIncome(vdocno, vdocdate1, "JV");
			break;
 		}
		//dayBookFrame.dispose();
	}


	
	
//---------------------------
	
	class trLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				showData();
 			} catch (Exception e) {
				new General().msg(e.getMessage());
			} catch (Throwable e) {
				new General().msg(e.getMessage());
			}
		}
	}

	
	class btnLsnr implements ActionListener {
 		@Override
		public void actionPerformed(ActionEvent e) {
  			String value =  e.getActionCommand() ;
 
  			if (value == "Print")
  			{
  			     try {
					callPrint() ;
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
  			}
  			
  			
  			if (value == "Close")
 			{
 				dayBookFrame.dispose();
 			}
  			
		}
 	}
	
	private void callPrint() throws Throwable
	{
		    String doctype = "POSINV";
		    int row = stable.getSelectedRow() ;
			String vinvno =    stable.getValueAt(row, 4).toString() ;
			String vinvdate =  stable.getValueAt(row, 3).toString() ;
 			new gnDocPrint().callprint(doctype, vinvno, vinvdate);

	}
	
	class searchlsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			showsuplier();
		}
	}

	private void showsuplier() {
		String sname = searchname.getText().trim();
		sname = "%" + sname + "%";
		try {
			String vtype = "Vendor";
			JTextField txt = new JTextField();
			new gnSupplier().rvendorcode = "0";
			new gnSupplier().getBoth(sname);
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (Throwable e1) {
			e1.printStackTrace();
		} finally {
			code.setText(new gnSupplier().rvendorcode);
			searchname.setText(new gnSupplier().rvendorName);
			try {
			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	}
   	
public void activateTimer()
{   		    
        timerStatus = "stop" ;
        timer = null ;
  
		timer = new Timer(INTERVAL, new ActionListener() {
   		public void actionPerformed(ActionEvent evt) 
   		{
   			        dayBookThread = new Thread() ;
      	 			dayBookThread.start();
   		   			System.out.println("Reached in Inner Thread");	 
   		   		    timerStatus = "strat" ;
    				exit = true;
   					System.out.println(dayBookThread.getId() + " " + dayBookThread.getName());
   					timerStatus = "start";
   					try {
   						showData();
   						//int row = 0;
   						//getTransactions(row);
   						//timerStatus = "stop";
   						dayBookThread.stop();
   						exit = false;
   					} catch (Throwable e) {
   						e.printStackTrace();
   					}
   		   	  		if ( "stop".equals(timerStatus)) 
   		   	    	{
   		   		        timer.stop();
   		   	  	    }
    				}
		});
   	 	timer.start();
   	    
  }



	private void startNewThread() {

		dayBookThread = new Thread(new Runnable() {
			@Override
			public void run() {
				dayBookThread.start();
				exit = true;
				System.out.println(dayBookThread.getId() + " " + dayBookThread.getName());
				timerStatus = "start";
				try {
					showData();
					int row = 0;
					getTransactions(row);
					timerStatus = "stop";
					dayBookThread.stop();
					exit = false;
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});

	}
}// Last

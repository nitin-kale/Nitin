 package RetailProduct;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;

public class GST_Filling_GSTR3B {

	JFrame GST3BReportFrame;
	private JTextField from;
	private JTextField to;
	JPanel lpanel;
	JPanel rpanel;
	JScrollPane jsp;
	JButton btnTaxExport;
	JInternalFrame internalFrame;
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();

	JTable stable = new JTable();
	DefaultTableModel smodel = new DefaultTableModel();

	JPanel panel;

	String vmode;
	int btnno = 0;
	JButton btnExport;
	JScrollPane jsp1;

	String vfrom;
	String vto;
	String vcomp;

	String vtype = "";

	private JLabel label;
	private JTextField scheme;
	private JLabel label_1;
	private JTextField schedule;
	private JTextField companyname;
	private JLabel label_3;
	private JTextField isgst;
	private JTextField gstno;
	private JLabel label_4;
	private JTextField statecode;
	private JTextField statename;
	private JTextField txbalval;
	private JTextField tvalue;
	private JTextField taxamt;
	private JTextField tigst;
	private JTextField tsgst;
	private JTextField tcgst;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GST_Filling_GSTR3B window = new GST_Filling_GSTR3B();
					window.GST3BReportFrame.setVisible(true);
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
	public GST_Filling_GSTR3B() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		GST3BReportFrame = new JFrame();
		GST3BReportFrame.setResizable(false);
		GST3BReportFrame.setAlwaysOnTop(true);
		//GSTReportFrame.setBounds(1, 100, 1350, 702);
		GST3BReportFrame.setBounds(1, 100, 1350, 611);
		
		GST3BReportFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GST3BReportFrame.getContentPane().setLayout(null);
 		GST3BReportFrame.getContentPane().setBackground(Color.WHITE);
  		GST3BReportFrame.getContentPane().setForeground(Color.WHITE);
 		GST3BReportFrame.getContentPane().setLayout(null);

	
		/*
		internalFrame = new JInternalFrame("");
		internalFrame.setForeground(new Color(51, 0, 153));
 		internalFrame.setBackground(Color.WHITE);
		internalFrame.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
 		internalFrame.setBounds(0, 0, 1340, 665);
   		GSTReportFrame.getContentPane().add(internalFrame);
         */
 
		// lpanel = new JPanel();
		lpanel = new gnRoundPanel();

		lpanel.setBorder(new MatteBorder(3, 1, 2, 3, (Color) new Color(0, 0, 204)));
		lpanel.setBackground(Color.WHITE);
		lpanel.setBounds(1, 1, 199, 408);
		lpanel.setVisible(true);

		rpanel = new JPanel();
		rpanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "GST -Data", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(128, 0, 128)));
		rpanel.setBackground(Color.CYAN);
		rpanel.setBounds(1, 115, 1300, 408);
		rpanel.setLayout(null);

		jsp = new JScrollPane();
		jsp.setViewportBorder(
				new BevelBorder(BevelBorder.RAISED, Color.YELLOW, Color.MAGENTA, Color.BLUE, new Color(0, 0, 51)));
		jsp.setBounds(6, 0, 1121, 280);
		rpanel.add(jsp);

		JSplitPane mysplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lpanel, rpanel);
		mysplit.setEnabled(false);
		mysplit.setBounds(1, 153, 1340, 468);

		jsp1 = new JScrollPane();
		jsp1.setBounds(6, 304, 1116, 149);
		rpanel.add(jsp1);
		jsp1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JLabel lblNewLabel = new JLabel("Transaction Summary");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel.setBounds(16, 282, 153, 16);
		rpanel.add(lblNewLabel);

		btnTaxExport = new JButton("Export Tax Data");
		btnTaxExport.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 11));
		btnTaxExport.setBounds(376, 277, 190, 25);
		rpanel.add(btnTaxExport);
		lpanel.setLayout(null);

		JButton btnNewButton = new JButton(" ");
		btnNewButton.setBounds(0, 0, 9, 527);
		btnNewButton.setIcon(new ImageIcon(GST_Reports.class.getResource("/RetailProduct/panel.png")));
		lpanel.add(btnNewButton);
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		GST3BReportFrame.getContentPane().add(mysplit);
		mysplit.setDividerLocation(200);
		mysplit.setContinuousLayout(true);

		label = new JLabel("GST - Scheme");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(219, 36, 127, 16);
		label.setForeground(new Color(0, 0, 102));
		label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		GST3BReportFrame.getContentPane().add(label);

		scheme = new JTextField();
		scheme.setFont(new Font("MS Gothic", Font.BOLD, 13));
		scheme.setBounds(355, 30, 273, 30);
		scheme.setText((String) null);
		scheme.setForeground(new Color(0, 0, 139));
		scheme.setEditable(false);
		scheme.setColumns(10);
		scheme.setBackground(Color.WHITE);
		GST3BReportFrame.getContentPane().add(scheme);

		label_1 = new JLabel("Return File Schedule");
		label_1.setBounds(206, 65, 144, 16);
		label_1.setForeground(new Color(0, 0, 102));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		GST3BReportFrame.getContentPane().add(label_1);

		schedule = new JTextField();
		schedule.setText("Monthly");
		schedule.setForeground(new Color(0, 0, 139));
		schedule.setBounds(355, 55, 273, 30);
		schedule.setFont(new Font("MS Gothic", Font.BOLD, 13));
		schedule.setEditable(false);
		schedule.setColumns(10);
		schedule.setBackground(Color.WHITE);
		GST3BReportFrame.getContentPane().add(schedule);

		companyname = new JTextField();
		companyname.setHorizontalAlignment(SwingConstants.LEFT);
		companyname.setBounds(354, 0, 348, 30);
		companyname.setText((String) null);
		companyname.setForeground(new Color(0, 0, 139));
		companyname.setFont(new Font("Arial", Font.BOLD, 14));
		companyname.setEditable(false);
		companyname.setColumns(10);
		companyname.setBackground(Color.WHITE);
		GST3BReportFrame.getContentPane().add(companyname);
		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 102));
		panel.setBounds(675, 86, 649, 71);
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new MatteBorder(2, 0, 0, 0, (Color) new Color(0, 51, 51)), "Total ",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 51, 153)));
		GST3BReportFrame.getContentPane().add(panel);

		label_3 = new JLabel("GSTIN");
		label_3.setBounds(284, 97, 62, 16);
		label_3.setForeground(new Color(0, 0, 102));
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		GST3BReportFrame.getContentPane().add(label_3);

		isgst = new JTextField();
		isgst.setBounds(355, 86, 26, 30);
		isgst.setText((String) null);
		isgst.setForeground(new Color(0, 0, 139));
		isgst.setFont(new Font("MS Gothic", Font.BOLD, 13));
		isgst.setEditable(false);
		isgst.setColumns(10);
		isgst.setBackground(Color.WHITE);
		GST3BReportFrame.getContentPane().add(isgst);

		gstno = new JTextField();
		gstno.setBounds(384, 87, 244, 30);
		gstno.setText((String) null);
		gstno.setForeground(new Color(0, 0, 139));
		gstno.setFont(new Font("MS Gothic", Font.BOLD, 13));
		gstno.setEditable(false);
		gstno.setColumns(10);
		gstno.setBackground(Color.WHITE);
		GST3BReportFrame.getContentPane().add(gstno);

		label_4 = new JLabel("State");
		label_4.setBounds(294, 124, 52, 16);
		label_4.setForeground(new Color(0, 0, 102));
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		GST3BReportFrame.getContentPane().add(label_4);

		statecode = new JTextField();
		statecode.setBounds(355, 116, 27, 30);
		statecode.setText((String) null);
		statecode.setForeground(new Color(0, 0, 139));
		statecode.setFont(new Font("MS Gothic", Font.BOLD, 13));
		statecode.setEditable(false);
		statecode.setColumns(10);
		statecode.setBackground(Color.WHITE);
		GST3BReportFrame.getContentPane().add(statecode);

		statename = new JTextField();
		statename.setBounds(384, 116, 244, 30);
		statename.setForeground(new Color(0, 0, 139));
		statename.setFont(new Font("MS Gothic", Font.BOLD, 13));
		statename.setEditable(false);
		statename.setColumns(10);
		statename.setBackground(Color.WHITE);
		GST3BReportFrame.getContentPane().add(statename);
		panel.setLayout(null);

		// tvalue = new JTextField();
		tvalue = new gnRoundTextField(20);
		tvalue.setBounds(12, 29, 91, 29);
		panel.add(tvalue);
		tvalue.setBackground(Color.WHITE);
		tvalue.setEditable(false);
		tvalue.setFont(new Font("Tahoma", Font.BOLD, 13));
		tvalue.setForeground(new Color(0, 51, 102));
		tvalue.setColumns(10);

		// txbalval = new JTextField();
		txbalval = new gnRoundTextField(20);
		txbalval.setBounds(121, 29, 95, 29);
		panel.add(txbalval);
		txbalval.setBackground(Color.WHITE);
		txbalval.setEditable(false);
		txbalval.setFont(new Font("Tahoma", Font.BOLD, 13));
		txbalval.setForeground(new Color(0, 51, 102));
		txbalval.setColumns(10);

		// taxamt = new JTextField();
		taxamt = new gnRoundTextField(20);
		taxamt.setBounds(228, 29, 91, 29);
		panel.add(taxamt);
		taxamt.setBackground(Color.WHITE);
		taxamt.setEditable(false);
		taxamt.setFont(new Font("Tahoma", Font.BOLD, 13));
		taxamt.setForeground(new Color(0, 51, 102));
		taxamt.setColumns(10);

		// tcgst = new JTextField();
		tcgst = new gnRoundTextField(20);
		tcgst.setBounds(331, 29, 103, 29);
		panel.add(tcgst);
		tcgst.setBackground(Color.WHITE);
		tcgst.setEditable(false);
		tcgst.setFont(new Font("Tahoma", Font.BOLD, 13));
		tcgst.setForeground(new Color(0, 51, 102));
		tcgst.setColumns(10);

		// tsgst = new JTextField();
		tsgst = new gnRoundTextField(20);
		tsgst.setBounds(446, 29, 89, 29);
		panel.add(tsgst);
		tsgst.setBackground(Color.WHITE);
		tsgst.setEditable(false);
		tsgst.setFont(new Font("Tahoma", Font.BOLD, 13));
		tsgst.setForeground(new Color(0, 51, 102));
		tsgst.setColumns(10);

		// tigst = new JTextField();
		tigst = new gnRoundTextField(20);

		tigst.setBounds(547, 29, 83, 29);
		panel.add(tigst);
		tigst.setBackground(Color.WHITE);
		tigst.setEditable(false);
		tigst.setFont(new Font("Tahoma", Font.BOLD, 13));
		tigst.setForeground(new Color(0, 51, 102));
		tigst.setColumns(10);

		lblNewLabel_1 = new JLabel("Value");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setBounds(12, 13, 55, 16);
		panel.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Taxable Val");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setBounds(123, 13, 93, 16);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Tax Amt");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_3.setBounds(230, 13, 89, 16);
		panel.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("CGST Tax");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setBounds(343, 13, 91, 16);
		panel.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("SGST Tax");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setForeground(new Color(0, 0, 102));
		lblNewLabel_5.setBounds(446, 13, 89, 16);
		panel.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("IGST Tax");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setForeground(new Color(0, 0, 102));
		lblNewLabel_6.setBounds(555, 13, 75, 16);
		panel.add(lblNewLabel_6);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 56, 206, 93);
		panel_1.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(204, 255, 204)));
		panel_1.setBackground(new Color(204, 51, 153));
		GST3BReportFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel fromdate = new JLabel("From ");
		fromdate.setBounds(12, 32, 45, 16);
		panel_1.add(fromdate);
		fromdate.setHorizontalAlignment(SwingConstants.RIGHT);
		fromdate.setForeground(Color.WHITE);
		fromdate.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel todate = new JLabel("To");
		todate.setBounds(22, 61, 35, 16);
		panel_1.add(todate);
		todate.setHorizontalAlignment(SwingConstants.RIGHT);
		todate.setForeground(Color.WHITE);
		todate.setFont(new Font("Tahoma", Font.BOLD, 14));

		from = new JTextField() {
			public void addNotify() {
				super.addNotify();
				requestFocus();
			}
		};
		from.setBounds(66, 26, 116, 22);
		panel_1.add(from);

		from.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		from.setColumns(10);

		to = new JTextField();
		to.setBounds(66, 55, 116, 22);
		panel_1.add(to);
		to.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		to.setColumns(10);

		btnExport = new JButton("Export Data");
		btnExport.setMnemonic('E');
		btnExport.setBounds(924, 7, 160, 45);
		GST3BReportFrame.getContentPane().add(btnExport);
		btnExport.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnExport.setBackground(Color.WHITE);

		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		btnClose.setIcon(new ImageIcon(GST_Reports.class.getResource("/RetailProduct/delete.png")));
		btnClose.setMnemonic('C');
		btnClose.setBounds(1086, 7, 144, 45);
		GST3BReportFrame.getContentPane().add(btnClose);

		JLabel lblNewLabel_7 = new JLabel("GST 3B DATA");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(12, 17, 140, 27);
		GST3BReportFrame.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel(" ");
		lblNewLabel_8.setIcon(new ImageIcon(GST_Reports.class.getResource("/RetailProduct/panel12.png")));
		lblNewLabel_8.setBounds(1, 2, 200, 57);
		GST3BReportFrame.getContentPane().add(lblNewLabel_8);

		ActionListener btn = new btnLsnr();

  
		ActionListener frmLsnr = new fromLsnr();
		ActionListener toLsnr = new toLsnr();
		to.addActionListener(toLsnr);
		from.addActionListener(frmLsnr);
		decorate();

	}

	
	private void decorate() throws Throwable {
 		GST3BReportFrame.setUndecorated(true);
  		panel.setVisible(false);
  		from.setText(new gnFinYear().getFirstDateofFinYear());
		to.setText(new gnFinYear().getLastDateofFinYear());

		new gnApp().setFrameTitel(GST3BReportFrame);
		new gnField().closeform(lpanel, GST3BReportFrame);
		new gnField().closeform(rpanel, GST3BReportFrame);

		// new gnApp().setCompanyTitle(internalFrame);
		companyname.setText(new gnConfig().getCompany());
		gstno.setText(new gnGST().getComanyGSTno());

 		isgst.setText(new gnGST().ismyComanyGSTRegister());
		statecode.setText(new gnGST().getmyState());
		statename.setText(new gnGST().getmystatename());
		scheme.setText(new gnGST().gst_getmytaxscheme());
		String vschmetype = new gnGST().gst_getmytaxschemecode();
		switch (vschmetype) {
		case "0":
			schedule.setText("No Return File");
			break;
		case "1":
			schedule.setText("Quatarly  Return File");
			break;
		case "2":
			schedule.setText("Monthly  Return File");
		}
  		new gnStyleButton().getStyleButton(btnClose, new Color(156, 211, 112), Color.WHITE);
		new gnStyleButton().getStyleButton(btnExport, new Color(156, 211, 112), Color.WHITE);
 	}

	
	
	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			
			
			setButtonAction(value);
		}
	}

	
	private void setButtonAction(String value) {
		
		switch (value) {
 		
		case "Close":
 			GST3BReportFrame.dispose();
			break;

		case "Table3.a":
			vtype = "PurTax";
			break;
 		}
		try {
			String vstatus = new gnFinYear().checkDateRanegforFinyear(from.getText(), to.getText());
			if (vstatus == "Sucess") {
				processRequest(vtype);
			}
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private void processRequest(String vtype) throws Throwable {

		vfrom = new gnConfig().date_ConverttoDBforamt(from.getText());
		vto = new gnConfig().date_ConverttoDBforamt(to.getText());
		vcomp = new gnConfig().getCompanyCode();
		String SQL = "";
		String col1[] = { "Type", "Table No", "Partucular", "Taxable Value", "Tax Amount", "CGST", "SGST", "IGST" , "Cess"};
 
		String vstore = new gnConfig().getStorecode();
		new gnTable().RemoveTableRows(model);
		switch (vtype) {
		// Purchase

  		case "IntraPur":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
 			new gnTable().RemoveTableRows(smodel);
			break;

		case "InterPur":
			SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
			table = new gnTableModel().Tablemodel(table, model, SQL, col1, 9, "N", "Y", vtype);
			vmode = "C";
			new gnTable().RemoveTableRows(smodel);
			break;

    
		}

		table.setModel(model);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		new gnTable().setTableBasics(table);
		JViewport prt = new JViewport();
		prt.setBackground(Color.WHITE);
		prt.add(table, col1);
		prt.setVisible(true);
		jsp.setViewport(prt);
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);

		new gnTable().setFontBold(table, 11);
		panel.setVisible(true);
		switch (vmode) {
		case "C":
			  
					
			tvalue.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 4))));
			txbalval.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 5))));
			taxamt.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 6))));
			tcgst.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 7))));
			tsgst.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 8))));
			tigst.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 9))));
			break;
		case "B":
			tvalue.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 5))));
			txbalval.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 6))));
			taxamt.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 7))));
			tcgst.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 8))));
			tsgst.setText(new gnMath().get2DecimaltValue( Double.toString(new gnTable().getTotal(table, 9))));
			tigst.setText(new gnMath().get2DecimaltValue(Double.toString(new gnTable().getTotal(table, 10))));
			break;
		}
		if (table.getRowCount() > 0) {
			Selectrow();
		}
	}

	
	
	public void Selectrow(JButton btnname) {
 	}

	class fromLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				from.setText(new gnDate().getmefullDate(from.getText()));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class toLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				to.setText(new gnDate().getmefullDate(to.getText()));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

 
 
	public void Selectrow() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.requestFocus();
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {
					display(row, value);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
			}
		});
	}

	private void display(int row, String value) throws Throwable {
		String vmonthno = " ";
		String vvtype = "";
		String SQL2 = " ";
		int ColNo = 0;
		String vtype = "";

		switch (value) {
		case "SalesBillWise":
			String vdocno = table.getValueAt(row, 3).toString();
			String vdocdate = (table.getValueAt(row, 1).toString());
			new gnSale().showinvoice(vdocno, vdocdate);
			break;
		case "PurchaseBillWise":
			vdocno = table.getValueAt(row, 3).toString();
			vdocdate = (table.getValueAt(row, 1).toString());
			try {
				new gnGrn().viewGrn(vdocno, vdocdate);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}
	}

	private void exportData() {
		new Export_Table_Data_to_Excel().exportTable(table);

	}

	private void exportData1() {
		new Export_Table_Data_to_Excel().exportTable(stable);

	}
 
	private void showTrSummary() throws ClassNotFoundException, SQLException {

		String coltax[] = { "Type", "Description" , "NO" };
		new gnTable().RemoveTableRows(smodel);
		String vtype = "Tr-HeaderSummary";
		String SQL = "call GST_Data_GSTR(" + vcomp + ", '" + vfrom + "', '" + vto + "', '" + vtype + "')";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, coltax, 2, "N", "Y", vtype);
 		stable.setModel(smodel);
		new gnTable().setTableBasics(stable);
		JViewport prt1 = new JViewport();
		prt1.setBackground(Color.WHITE);
		prt1.add(stable, coltax);
		prt1.setVisible(true);
		jsp1.setViewport(prt1);
	}


	
}// Last

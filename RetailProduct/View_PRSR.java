package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class View_PRSR extends getResultSet {

	JFrame PRSRframe;
	JButton btnPRMonthWise;
	JButton btnPRDate;
	JButton btnArticle;
	String SQL;
	private JTextField fromdate;
	private JTextField todate;
	JPanel leftpanel;
	JSplitPane mysplit;
	JScrollPane jsp;
	String vfrom;
	String vto;
	String vfinyear;
	String vverticle;
	String vcode;

	private JPanel rightPanel;
	private JSplitPane mysplitmain;
	private JButton btnSRMonth;
	private JButton btnSRDate;
	private JButton btnSRItems;

	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	private JButton btnPRdocwise;
	private JButton btnSRDocWise;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_PRSR window = new View_PRSR();
					window.PRSRframe.setVisible(true);
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
	public View_PRSR() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		PRSRframe = new JFrame();
		PRSRframe.getContentPane().setBackground(Color.WHITE);
		PRSRframe.setAlwaysOnTop(true);
		PRSRframe.setBounds(1, 1, 1350, 750);
		PRSRframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		PRSRframe.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setBackground(new Color(0, 0, 51));
		lblNewLabel.setBounds(12, 23, 56, 16);
		PRSRframe.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("To Date");
		lblNewLabel_1.setBackground(new Color(0, 0, 51));
		lblNewLabel_1.setBounds(12, 52, 56, 16);
		PRSRframe.getContentPane().add(lblNewLabel_1);

		fromdate = new JTextField();
		fromdate.setBounds(73, 20, 116, 22);
		PRSRframe.getContentPane().add(fromdate);
		fromdate.setColumns(10);

		todate = new JTextField();
		todate.setBounds(73, 49, 116, 22);
		PRSRframe.getContentPane().add(todate);
		todate.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("View - Sales & Purchase Return ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(0, 0, 153));
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		lblNewLabel_2.setBounds(270, 13, 560, 16);
		PRSRframe.getContentPane().add(lblNewLabel_2);

		mysplit = new JSplitPane();
		mysplit.setBounds(12, 98, 333, 159);

		leftpanel = new JPanel();
		leftpanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Purchase Return ",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 153)));
		mysplit.setLeftComponent(leftpanel);
		leftpanel.setLayout(null);

		btnPRMonthWise = new JButton("Month Wise");
		btnPRMonthWise.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnPRMonthWise.setBounds(12, 31, 124, 25);
		leftpanel.add(btnPRMonthWise);

		btnPRDate = new JButton("Date Wise");
		btnPRDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnPRDate.setBounds(12, 69, 124, 25);
		leftpanel.add(btnPRDate);

		btnArticle = new JButton("Article/Items");
		btnArticle.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnArticle.setBounds(12, 111, 124, 25);
		leftpanel.add(btnArticle);

		btnPRdocwise = new JButton("Doc .No Wise");
		btnPRdocwise.setBounds(12, 157, 124, 25);
		leftpanel.add(btnPRdocwise);

		jsp = new JScrollPane();
		mysplit.setRightComponent(jsp);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		mysplit.setDividerLocation(200);

		mysplitmain = new JSplitPane();
		mysplitmain.setBounds(0, 98, 1346, 594);
		PRSRframe.getContentPane().add(mysplitmain);

		rightPanel = new JPanel();
		rightPanel.setBorder(new TitledBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 255, 102)),
				"Sales Return", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mysplitmain.setRightComponent(rightPanel);
		rightPanel.setLayout(null);

		btnSRMonth = new JButton("SR Month Wise");
		btnSRMonth.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		btnSRMonth.setBounds(12, 28, 140, 25);
		rightPanel.add(btnSRMonth);

		btnSRDate = new JButton("SR Date Wise");
		btnSRDate.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		btnSRDate.setBounds(12, 66, 140, 25);
		rightPanel.add(btnSRDate);

		btnSRItems = new JButton("SR Article/Item");
		btnSRItems.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		btnSRItems.setBounds(12, 104, 140, 25);

		rightPanel.add(btnSRItems);

		btnSRDocWise = new JButton("SR-Doc.No Wise");
		btnSRDocWise.setBounds(12, 142, 140, 25);

		rightPanel.add(btnSRDocWise);
		mysplitmain.setLeftComponent(mysplit);
		mysplit.setDividerLocation(150);
		mysplitmain.setDividerLocation(1150);

		ActionListener btnls = new btnLsnr();
		btnSRItems.addActionListener(btnls);
		btnSRDate.addActionListener(btnls);
		btnSRMonth.addActionListener(btnls);
		btnSRDocWise.addActionListener(btnls);
		btnPRdocwise.addActionListener(btnls);
		btnPRDate.addActionListener(btnls);
		btnArticle.addActionListener(btnls);
		btnPRMonthWise.addActionListener(btnls);

		decorate();
	}

	private void decorate() throws Throwable {
		fromdate.setText(new gnFinYear().getFirstDateofFinYear());
		todate.setText(new gnFinYear().getLastDateofFinYear());

		new gnDecorate().decorateBtn(btnSRMonth, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnSRDate, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnSRItems, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnPRMonthWise, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnPRDate, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnArticle, new Color(125, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnArticle, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnPRDate, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnPRMonthWise, new Color(120, 151, 112), Color.WHITE);

		new gnDecorate().decorateBtn(btnSRDocWise, new Color(120, 151, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnPRdocwise, new Color(120, 151, 112), Color.WHITE);

		new gnDecorate().decorateBtn(btnSRItems, new Color(120, 155, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnSRDate, new Color(120, 155, 112), Color.WHITE);
		new gnDecorate().decorateBtn(btnSRMonth, new Color(120, 155, 112), Color.WHITE);

	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String value = e.getActionCommand();
			try {
				porocessAcction(value);
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	private void porocessAcction(String value) throws Throwable {
		vfinyear = new gnFinYear().getReportingFinYear();
		vverticle = new gnHierarchy().getVerticleCode();
		vfrom = new gnConfig().date_ConverttoDBforamt(fromdate.getText());
		vto = new gnConfig().date_ConverttoDBforamt(todate.getText());
		String vcode = "0";
		String vtype = "";
		int col = 0;
		int sumcol = 0;
		switch (value) {
		case "Month Wise":
			String mycol[] = { "Type", "Month", "Mon-Name", "Qty", "Amount" };
			vtype = "PR-Month";
			col = 4;
			SQL = "call   view_PRSRData( '" + vtype + "'  ," + vcomp + "  , " + vstore + "  , '" + vfrom + "' , '" + vto
					+ "' ,   " + vverticle + " , " + vcode + " )";
			vtype = "PR-MonthWise";
			showView(SQL, mycol, col, vtype);
			break;

		case "Date Wise":
			String mycol1[] = { "Type", "Date", "Qty", "Amount" };
			vtype = "PR-Date";
			col = 3;
			SQL = "call   view_PRSRData( '" + vtype + "'  ," + vcomp + "  , " + vstore + "  , '" + vfrom + "' , '" + vto
					+ "' ,   " + vverticle + " , " + vcode + " )";
			vtype = "PR-DateWise";
			showView(SQL, mycol1, col, vtype);
			table.setBackground(Color.WHITE);
			table.setForeground(Color.BLUE);

			break;

		case "Article/Items":
			String mycol12[] = { "Type", "Date", "Article", "Name", "Qty", "Amount" };
			vtype = "PR-Article";
			col = 5;
			SQL = "call   view_PRSRData( '" + vtype + "'  ," + vcomp + "  , " + vstore + "  , '" + vfrom + "' , '" + vto
					+ "' ,   " + vverticle + " , " + vcode + " )";
			vtype = "PR-ArticleWise";
			showView(SQL, mycol12, col, vtype);
			table.setBackground(Color.WHITE);
			table.setForeground(Color.BLUE);
			break;

		case "Doc .No Wise":
			String mycol121[] = { "Type", "Supplier", "Name", "PR.No", "PR.Date", "Qty", "Amount" };
			vtype = "PR-DocWise";
			col = 6;
			SQL = "call   view_PRSRData( '" + vtype + "'  ," + vcomp + "  , " + vstore + "  , '" + vfrom + "' , '" + vto
					+ "' ,   " + vverticle + " , " + vcode + " )";
			vtype = "PR-DocWise";
			showView(SQL, mycol121, col, vtype);
			table.setBackground(Color.WHITE);
			table.setForeground(Color.BLUE);
			break;

		case "SR Month Wise":
			String mycol77[] = { "Type", "Month", "Mon-Name", "Qty", "Amount" };
			vtype = "SR-Month";
			col = 4;
			SQL = "call   view_PRSRData( '" + vtype + "'  ," + vcomp + "  , " + vstore + "  , '" + vfrom + "' , '" + vto
					+ "' ,   " + vverticle + " , " + vcode + " )";
			vtype = "SR-MonthWise";
			showView(SQL, mycol77, col, vtype);
			table.setBackground(Color.BLACK);
			table.setForeground(Color.WHITE);
			break;

		case "SR Date Wise":
			String mycol10[] = { "Type", "Date", "Qty", "Amount" };
			vtype = "SR-Date";
			col = 3;
			SQL = "call   view_PRSRData( '" + vtype + "'  ," + vcomp + "  , " + vstore + "  , '" + vfrom + "' , '" + vto
					+ "' ,   " + vverticle + " , " + vcode + " )";
			vtype = "SR-DateWise";
			showView(SQL, mycol10, col, vtype);
			table.setBackground(Color.BLACK);
			table.setForeground(Color.WHITE);
			break;

		case "SR Article/Item":
			String mycol1211[] = { "Type", "Date", "Article", "Name", "Qty", "Amount" };
			vtype = "SR-Article";
			col = 5;
			SQL = "call   view_PRSRData( '" + vtype + "'  ," + vcomp + "  , " + vstore + "  , '" + vfrom + "' , '" + vto
					+ "' ,   " + vverticle + " , " + vcode + " )";
			vtype = "SR-ItemWise";
			showView(SQL, mycol1211, col, vtype);
			table.setBackground(Color.BLACK);
			table.setForeground(Color.WHITE);
			break;

		case "SR-Doc.No Wise":
			String mycol1231[] = { "Type", "Customer", "Name", "SR.No", "SR.Date", "Qty", "Amount" };
			vtype = "SR-Docwise";
			col = 6;
			SQL = "call   view_PRSRData( '" + vtype + "'  ," + vcomp + "  , " + vstore + "  , '" + vfrom + "' , '" + vto
					+ "' ,   " + vverticle + " , " + vcode + " )";
			vtype = "SR-DocWise";
			showView(SQL, mycol1231, col, vtype);
			table.setBackground(Color.BLACK);
			table.setForeground(Color.WHITE);
			break;
		}

	}

	public void showView(String SQL, String Col[], int colno, String vtype) throws Throwable {
		// new General().msg(SQL) ;
		String vstatus = new gnFinYear().checkDateRanegforFinyear(fromdate.getText(), todate.getText());
		if (vstatus == "Sucess") {
			new gnTable().RemoveTableRows(model);
			// new General().msg("See Table is Emplty ..");
			table = null;
			table = new JTable() {
				public void addNotify() {
					super.addNotify();
					requestFocus();
				}
			};

			model.setColumnIdentifiers(Col);
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, colno, "N", "Y", vtype);
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			table.setFont(new Font("Helvitica", 13, 13));
			JViewport prt = new JViewport();
			prt.setBackground(Color.CYAN);
			prt.add(table, Col);
			prt.setVisible(true);
			jsp.setViewport(prt);
			jsp.requestFocus();
			if (table.getRowCount() > 0) {
				Selectrow();
				new gnTable().setTableBasics(table);
			}
		}
	}

	public void Selectrow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {
					display(row, value);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
					// new General().msgDispose();
			}
		});
	}

	private void display(int row, String value) throws Throwable {
		String vparty = "";
		String vdocno = "";
		String vdocdate = "";
		switch (value) {
		case "PR-DocWise":

			vparty = table.getValueAt(row, 1).toString();
			vdocno = table.getValueAt(row, 3).toString();
			vdocdate = table.getValueAt(row, 4).toString();
			new gnEdit().ShowPR(vparty, vdocno, vdocdate);
			;
			break;
		case "SR-DocWise":
			vparty = table.getValueAt(row, 1).toString();
			vdocno = table.getValueAt(row, 3).toString();
			vdocdate = table.getValueAt(row, 4).toString();
			new gnEdit().ShowSR(vparty, vdocno, vdocdate);
			break;

		}
	}

}// Last

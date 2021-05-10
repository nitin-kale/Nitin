package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class showconfigurationHelp {

	JFrame helpConfiguraion;
	private JTextField companycode;
	private JTextField companyname;
	private JTextField storecode;
	private JTextField storename;
	private JScrollPane jsp;
	private String vcomp;
	private String vstore;

	public DefaultTableModel smodel = new DefaultTableModel();
	public JTable stable = new JTable();
	String Col[] = { "Type ", "Company", "Store", "Module", "Parameter", "Value", "Default Value" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showconfigurationHelp window = new showconfigurationHelp();
					window.helpConfiguraion.setVisible(true);
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
	public showconfigurationHelp() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		helpConfiguraion = new JFrame();
		helpConfiguraion.setAlwaysOnTop(true);
		helpConfiguraion.setBounds(200, 50, 800, 700);
		helpConfiguraion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		helpConfiguraion.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Configuration Help Window",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 102)));
		panel.setBounds(0, 0, 782, 655);
		helpConfiguraion.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Company");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(12, 23, 56, 16);
		panel.add(lblNewLabel);

		companycode = new JTextField();
		companycode.setEditable(false);
		companycode.setBounds(73, 20, 62, 22);
		panel.add(companycode);
		companycode.setColumns(10);

		companyname = new JTextField();
		companyname.setEditable(false);
		companyname.setBounds(134, 20, 226, 22);
		panel.add(companyname);
		companyname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Store");
		lblNewLabel_1.setBounds(391, 23, 56, 16);
		panel.add(lblNewLabel_1);

		storecode = new JTextField();
		storecode.setEditable(false);
		storecode.setBounds(426, 20, 56, 22);
		panel.add(storecode);
		storecode.setColumns(10);

		storename = new JTextField();
		storename.setEditable(false);
		storename.setBounds(483, 20, 116, 22);
		panel.add(storename);
		storename.setColumns(10);

		jsp = new JScrollPane();
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 60, 782, 582);
		panel.add(jsp);
		decorate();
		showConfiguration("%%");
	}

	private void decorate() throws Throwable {
		// vcomp = new gnConfig().getCompanyCode() ;
		// vstore = new gnConfig().getStoreID() ;
		// companycode.setText(" ");
		// companyname.setText(new gnConfig().getCompany());
		// storename.setText(" ");

	}

	public void showConfiguration(String sname) throws Throwable {
		// String vcomp = companycode.getText() ;
		// String vstore = storecode.getText() ;
		String vcomp = "1000";
		String vstore = "1001";

		String SQL = "Call   conf_getAllConfigData( " + vcomp + " ,  " + vstore + ",  '" + sname + "')";
		new General().msg(SQL);
		smodel.setColumnIdentifiers(Col);
		String type = "Configuration";
		stable = new gnTableModel().Tablemodel(stable, smodel, SQL, Col, 6, "N", "Y", type);
		stable.setRowHeight(25);
		stable.setGridColor(Color.darkGray);
		new gnTable().setTableColWidth(stable, 3, 100);
		new gnTable().setTableColWidth(stable, 5, 300);
		new gnTable().setTableColWidth(stable, 6, 300);
		JViewport prt6 = new JViewport();
		jsp.setViewport(null);
		prt6.setToolTipText("Customer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(stable, Col);
		jsp.setViewport(prt6);
		// new General().msgsearch(jsp, stable, "Select Data ", 700, 500);
	}

}

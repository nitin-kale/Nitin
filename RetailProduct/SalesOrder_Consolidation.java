package RetailProduct;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JScrollPane;

public class SalesOrder_Consolidation  extends getResultSet{
 	
	JFrame SOConsolidationFrame;
	private JTextField from;
	private JTextField to;
	JButton btnGenerate;
	JButton btnShow;
	JButton btnClose;
	JComboBox comboLevel ;
	private JScrollPane jsp;

	private JLabel lblNewLabel_4 ;
	
	private DefaultTableModel model = new DefaultTableModel();
	private JTable table = new JTable()   ;

	String vcomp  ;
	String vstore ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesOrder_Consolidation window = new SalesOrder_Consolidation();
					window.SOConsolidationFrame.setVisible(true);
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
	public SalesOrder_Consolidation() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Throwable 
	 */
	private void initialize() throws Throwable {
		SOConsolidationFrame = new JFrame();
		SOConsolidationFrame.setAlwaysOnTop(true);
		//SOConsolidationFrame.setBounds(10, 200,1340, 550);
		SOConsolidationFrame.setBounds(1, 100, 1356, 600);
 		SOConsolidationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		SOConsolidationFrame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 0, 3, 0, (Color) new Color(204, 255, 204)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(121, 0, 1201, 94);
		SOConsolidationFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Select SO Date Range", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(37, 0, 666, 94);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("From Date");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(109, 13, 94, 16);
		panel_1.add(lblNewLabel_2);
		
		from = new JTextField();
		from.setBounds(117, 35, 116, 30);
		panel_1.add(from);
		from.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("To");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setBounds(245, 13, 33, 16);
		panel_1.add(lblNewLabel_3);
		
		to = new JTextField();
		to.setBounds(245, 35, 116, 30);
		panel_1.add(to);
		to.setColumns(10);
		
		lblNewLabel_4 = new JLabel("Consolidation At Level");
		lblNewLabel_4.setBounds(376, 13, 173, 16);
		panel_1.add(lblNewLabel_4);
		
		 comboLevel = new JComboBox();
		comboLevel.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		comboLevel.setModel(new DefaultComboBoxModel(new String[] {"Branch Level", "Company Level"}));
		comboLevel.setBounds(373, 35, 189, 30);
		panel_1.add(comboLevel);
		
		btnGenerate = new JButton("Generate");
		btnGenerate.setMnemonic('G');
		btnGenerate.setBounds(723, 51, 97, 30);
		panel.add(btnGenerate);
		
 		
		btnShow = new JButton("Show");
		btnShow.setMnemonic('S');
		btnShow.setBounds(825, 51, 97, 30);
		panel.add(btnShow);
		
		btnClose = new JButton("Close");
		btnClose.setMnemonic('C');
		btnClose.setBounds(929, 51, 97, 30);
		panel.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("SO Consolidation");
		lblNewLabel.setBounds(12, 34, 97, 37);
		SOConsolidationFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon(SalesOrder_Consolidation.class.getResource("/RetailProduct/resouce/mdf7.jpg")));
		lblNewLabel_1.setBounds(0, 0, 145, 94);
		SOConsolidationFrame.getContentPane().add(lblNewLabel_1);
		
		jsp = new JScrollPane();
		jsp.setBounds(12, 109, 1298, 383);
		SOConsolidationFrame.getContentPane().add(jsp);
	

		ActionListener btnls= new btnLsnr() ;

		btnGenerate.addActionListener(btnls);
		btnShow.addActionListener(btnls);
		btnClose.addActionListener(btnls);

		decorate() ;
		
}
	
private void  decorate() throws Throwable
{
	SOConsolidationFrame.setUndecorated(true);
	vcomp = new gnConfig().getCompanyCode() ;
	vstore = new gnConfig().getStorecode() ;
}
	
class btnLsnr  implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent e) {
 
 		String value  = e.getActionCommand() ;
 		
 		if (value  == "Close")
 		{
 			SOConsolidationFrame.dispose();
 		}
 		
 		if (value  == "Show")
 		{
 			try {
				showAction() ;
			} catch (ClassNotFoundException | SQLException e1) {
 				e1.printStackTrace();
			} catch (Throwable e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
 		}
 		

 		if (value  == "Generate")
 		{
 			try {
				generateAction() ;
			} catch (ClassNotFoundException | SQLException e1) {
 				e1.printStackTrace();
			}
 		}

	}
 }
	
private void showAction() throws Throwable
{
 	String vfrom =  new gnConfig().date_ConverttoDBforamt(from.getText()) ;
	String vto =  new gnConfig().date_ConverttoDBforamt(to.getText()) ;
  	String vvtype = "SOConsolidationData";
 	String vverticle = new gnConfig().date_ConverttoDBforamt(new  gnDate().getBegindate()) ;
  
	String SQL = "Call   view_SOData( '" + vvtype + "', " + vcomp + "," + vstore + ", '"
			+ vfrom + "' ,'" + vto + "'  , '" + vverticle + "')";
	String Col[] = { "Type", "Level" , "From", "To" , "Article" , "Name" ,"Qty" , "Bal_Qty" ,
			"Band" , "SubCat"};
	int ColNo = 9;
 	
		showView(SQL, Col, ColNo, vvtype);
 	
}


private void generateAction() throws ClassNotFoundException, SQLException
{

	String vfrom =  new gnConfig().date_ConverttoDBforamt(from.getText()) ;
	String vto =  new gnConfig().date_ConverttoDBforamt(to.getText()) ;
	String vverticle = new gnConfig().date_ConverttoDBforamt(new  gnDate().getBegindate()) ;
 	String vlevel  = comboLevel.getSelectedItem().toString().trim() ;
 	String SQL = "" ;
 	switch(vlevel)
	{
 	
		case "Branch Level" :
		 	String vtype = "so_consolidation_Branch" ;
		 	SQL  =   " Call view_SOData('"+vtype+"', "+vcomp+","+vstore+",'"+vfrom+"','"+vto+"','"+vverticle+"' )" ;
	 	 	break ;

		case "Company Level" :
			vtype = "so_consolidation_Company" ;
			SQL  =   "Call view_SOData('"+vtype+"', "+vcomp+","+vstore+",'"+vfrom+"','"+vto+"','"+vverticle+"' )" ;
	 		break ;

	}
  	new General().msg(SQL);
 	this.getResult(SQL) ;
	 
 	new General().Quickmsg("Consolidated Data Generated ..");
}




public void showView(String SQL, String Col[], int colno, String vtype) throws Throwable {
	
	new General().msg(SQL) ;
	String vstatus = new gnFinYear().checkDateRanegforFinyear(from.getText(), to.getText());
	if (vstatus == "Sucess") {
		new gnTable().RemoveTableRows(model);
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
			JViewport prt = new JViewport();
		prt.setBackground(Color.CYAN);
		prt.add(table, Col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		jsp.requestFocus();
		new gnFontSetting().setMyFontBold(table, "F1", 12);
		if (table.getRowCount() > 0) 
		{
			table.setShowHorizontalLines(false);
			table.setShowGrid(false);
				table.setRowHeight(28);
			//Selectrow();
			new gnTable().setTableBasics(table);
		}
	}
}

}//Last 

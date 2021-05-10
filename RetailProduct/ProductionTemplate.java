package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.mysql.jdbc.Connection;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class ProductionTemplate  extends getResultSet{

	JFrame prodTemplateFrame;
	Connection con2;

	private JTextField templatename;
	private JTextField materialqty;
	private JTextField materialrate;
	private JTextField qty;
	private JTextField rate;
 	JButton btnAdd;
	JButton btnSave;
	JButton btnClose;

	JComboBox comboMaterialUOM ;
 	JComboBox combotemptype;
  	JComboBox comboUOM;
	JComboBox comboMaterial;
	JComboBox comboFinishProduct;
 	JScrollPane jsp ;

 	String vcomp ;
 	String vstore ;
	private String DBhdr;
 	
 	
 	//FinishProduct 
 	
 	String vfinishArticlecode ;
 	String vmaterailArticlecode ;
 	
 	DefaultTableModel model  = new DefaultTableModel() {
  		@Override
		public boolean isCellEditable(int row, int column) {
 			try {
 					return column == 1 || column == 2 || column == 3 || column == 4   ? false : true;
  			} catch (Throwable e) {
 				e.printStackTrace();
			}
			return false;
  		}
	};

 			
 	JTable table = new JTable() ;
 	private JTextField total;
 	private JTextField lossper;
 	private JTextField materialWeightkg;
	
 	
 	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductionTemplate window = new ProductionTemplate();
					window.prodTemplateFrame.setVisible(true);
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
	public ProductionTemplate() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Throwable 
	 */
	private void initialize() throws Throwable {
		prodTemplateFrame = new JFrame();
		prodTemplateFrame.getContentPane().setBackground(Color.WHITE);
		prodTemplateFrame.setBackground(Color.WHITE);
		prodTemplateFrame.setBounds(1, 100, 1350, 600);
		prodTemplateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		prodTemplateFrame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Production Template");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(12, 43, 131, 29);
		prodTemplateFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setIcon(new ImageIcon(ProductionTemplate.class.getResource("/RetailProduct/mdf7.jpg")));
		lblNewLabel_1.setBounds(12, 13, 147, 115);
		prodTemplateFrame.getContentPane().add(lblNewLabel_1);
		
		 
		comboFinishProduct = new JComboBox();
		comboFinishProduct.setForeground(new Color(0, 0, 102));
		comboFinishProduct.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		comboFinishProduct.setBackground(Color.WHITE);
		comboFinishProduct.setBounds(185, 112, 469, 30);
		prodTemplateFrame.getContentPane().add(comboFinishProduct);
		
		//JPanel panel = new JPanel();
		JPanel panel = new gnRoundPanel();
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(148, 13, 1160, 76);
		prodTemplateFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Template Name");
		lblNewLabel_2.setBounds(139, 13, 205, 16);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		
		templatename = new JTextField();
		templatename.setBounds(138, 35, 226, 30);
		panel.add(templatename);
		templatename.setToolTipText("Enter Template Name Here");
		templatename.setText(" ");
		templatename.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Template Type");
		lblNewLabel_3.setBounds(390, 13, 147, 16);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		
 		
		
		combotemptype = new JComboBox();
		combotemptype.setBounds(381, 35, 190, 30);
		panel.add(combotemptype);
		combotemptype.setBackground(Color.WHITE);
		combotemptype.setForeground(new Color(0, 0, 102));
		combotemptype.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		combotemptype.setModel(new DefaultComboBoxModel(new String[] {"Masala Template", "Production Template", "Bulk Converion Template", " "}));
		
		JLabel lblNewLabel_10 = new JLabel("Bill Of Material");
		lblNewLabel_10.setBounds(875, 40, 253, 16);
		panel.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		
		JLabel lblNewLabel_11 = new JLabel(" ");
		lblNewLabel_11.setBounds(737, 2, 131, 67);
		panel.add(lblNewLabel_11);
		lblNewLabel_11.setIcon(new ImageIcon(ProductionTemplate.class.getResource("/RetailProduct/bomimage2.jpg")));
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(605, 35, 106, 26);
		panel.add(spinner);
		
		comboMaterial = new JComboBox();
		comboMaterial.setBounds(721, 113, 571, 30);
		prodTemplateFrame.getContentPane().add(comboMaterial);
		
	 	
		JLabel lblNewLabel_6 = new JLabel("Qty(Enter In Gram)");
		lblNewLabel_6.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(713, 154, 127, 16);
		prodTemplateFrame.getContentPane().add(lblNewLabel_6);
		
		//materialqty = new JTextField();
		materialqty = new gnRoundTextField(10);
 		materialqty.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		materialqty.setBackground(Color.WHITE);
		materialqty.setBounds(713, 183, 116, 30);
		prodTemplateFrame.getContentPane().add(materialqty);
		materialqty.setColumns(10);
		
		 
		comboMaterialUOM = new JComboBox();
		comboMaterialUOM.setEnabled(false);
		comboMaterialUOM.setModel(new DefaultComboBoxModel(new String[] {"GM"}));
		comboMaterialUOM.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		comboMaterialUOM.setBackground(Color.WHITE);
		comboMaterialUOM.setBounds(862, 183, 60, 30);
		prodTemplateFrame.getContentPane().add(comboMaterialUOM);
		
		materialrate = new JTextField();
		materialrate.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 12));
		materialrate.setBackground(Color.WHITE);
		materialrate.setBounds(1083, 183, 116, 30);
		prodTemplateFrame.getContentPane().add(materialrate);
		materialrate.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("UOM");
		lblNewLabel_7.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_7.setBounds(852, 154, 56, 16);
		prodTemplateFrame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Rate(1 Kg)");
		lblNewLabel_8.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_8.setBounds(1081, 154, 97, 16);
		prodTemplateFrame.getContentPane().add(lblNewLabel_8);
		
		 
		
		jsp = new JScrollPane();
		jsp.setBounds(12, 213, 1308, 329);
		prodTemplateFrame.getContentPane().add(jsp);
		
		JLabel lblNewLabel_4 = new JLabel("Finish Product");
		lblNewLabel_4.setBounds(190, 93, 122, 16);
		prodTemplateFrame.getContentPane().add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		
		JLabel lblNewLabel_9 = new JLabel("Add Material List ");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_9.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		lblNewLabel_9.setToolTipText("Add Material List ");
		lblNewLabel_9.setBounds(702, 87, 147, 29);
		prodTemplateFrame.getContentPane().add(lblNewLabel_9);
		
		JLabel label = new JLabel("Qty");
		label.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(158, 154, 56, 16);
		prodTemplateFrame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("UOM");
		label_1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(294, 154, 56, 16);
		prodTemplateFrame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Rate");
		label_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(418, 156, 56, 16);
		prodTemplateFrame.getContentPane().add(label_2);
		
		qty = new JTextField();
		qty.setEditable(false);
		qty.setText("1");
		qty.setForeground(new Color(0, 0, 102));
		qty.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		qty.setBackground(Color.WHITE);
		qty.setBounds(185, 183, 107, 30);
		prodTemplateFrame.getContentPane().add(qty);
		qty.setColumns(10);
		
 		
		comboUOM = new JComboBox();
		comboUOM.setForeground(new Color(0, 0, 102));
		comboUOM.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		comboUOM.setBackground(Color.WHITE);
		comboUOM.setBounds(304, 183, 122, 30);
		prodTemplateFrame.getContentPane().add(comboUOM);
		
		rate = new JTextField();
		rate.setForeground(new Color(0, 0, 102));
		rate.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		rate.setBackground(Color.WHITE);
		rate.setBounds(438, 183, 124, 30);
		prodTemplateFrame.getContentPane().add(rate);
		rate.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel(" ");
		lblNewLabel_5.setIcon(new ImageIcon(ProductionTemplate.class.getResource("/RetailProduct/panel.png")));
		lblNewLabel_5.setBounds(692, 116, 3, 97);
		prodTemplateFrame.getContentPane().add(lblNewLabel_5);
		
	    btnAdd = new JButton("Add");
		btnAdd.setBounds(1211, 156, 81, 57);
		prodTemplateFrame.getContentPane().add(btnAdd);
		btnAdd.setIcon(null);
		
 		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		btnSave.setForeground(new Color(0, 0, 102));
		btnSave.setBounds(512, 549, 97, 38);
		prodTemplateFrame.getContentPane().add(btnSave);
		
		btnClose = new JButton("Close");
		btnClose.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
		btnClose.setForeground(new Color(0, 0, 102));
		btnClose.setBounds(640, 549, 97, 38);
		prodTemplateFrame.getContentPane().add(btnClose);
		
		JLabel lblNewLabel_12 = new JLabel("Material Value");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_12.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		lblNewLabel_12.setBounds(986, 549, 171, 38);
		prodTemplateFrame.getContentPane().add(lblNewLabel_12);
		
		//total = new JTextField();
		total = new gnRoundTextField(10);
		total.setFont(new Font("Tahoma", Font.BOLD, 16));
 		total.setBackground(Color.WHITE);
		total.setEditable(false);
		total.setBounds(1161, 549, 159, 38);
		prodTemplateFrame.getContentPane().add(total);
		total.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("Actual Weight(out)");
		lblNewLabel_13.setBounds(564, 154, 116, 16);
		prodTemplateFrame.getContentPane().add(lblNewLabel_13);
		
		lossper = new JTextField();
		lossper.setBounds(564, 183, 116, 30);
		prodTemplateFrame.getContentPane().add(lossper);
		lossper.setColumns(10);
		
		JLabel lblNewLabel_14 = new JLabel("Weight(KG)");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_14.setBounds(974, 156, 111, 16);
		prodTemplateFrame.getContentPane().add(lblNewLabel_14);
		
		materialWeightkg = new JTextField();
		materialWeightkg.setFont(new Font("Tahoma", Font.BOLD, 15));
		materialWeightkg.setBounds(970, 183, 115, 30);
		prodTemplateFrame.getContentPane().add(materialWeightkg);
		materialWeightkg.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel(" ");
		lblNewLabel_15.setIcon(new ImageIcon(ProductionTemplate.class.getResource("/RetailProduct/panel.png")));
		lblNewLabel_15.setBounds(938, 154, 15, 59);
		prodTemplateFrame.getContentPane().add(lblNewLabel_15);
		prodTemplateFrame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboFinishProduct, templatename, combotemptype, lblNewLabel_10, comboMaterial, lblNewLabel_6, materialqty, comboMaterialUOM, materialrate, lblNewLabel_7, lblNewLabel_8, jsp, lblNewLabel_4, lblNewLabel_9, qty, comboUOM, rate, lblNewLabel_5}));
	
		ActionListener fnshcombLs = new FinishdropdnLsnr() ;
		ActionListener matrlcombLs = new MaterialdropdnLsnr() ;
		
		
		comboFinishProduct.addActionListener(fnshcombLs);
		comboMaterial.addActionListener(matrlcombLs );
 
			ActionListener btnls  = new  btnLsnr();
			btnAdd.addActionListener(btnls);
			btnClose.addActionListener(btnls);
			btnSave.addActionListener(btnls);
			
			ActionListener  materlqty  = new materialqtyLsnr() ;
			materialqty.addActionListener(materlqty);
		decorate();
	}

	
class materialqtyLsnr implements ActionListener{
 	@Override
	public void actionPerformed(ActionEvent arg0) {
  		Double vmatqty = Double.parseDouble(materialqty.getText())/1000;
 		materialWeightkg.setText(Double.toString(vmatqty));
  	}
 }



private void decorate() throws Throwable
{
	  new General().delTableRow(table, model  );
  	  vcomp = new gnConfig().getCompanyCode() ;
  	  vstore = new gnConfig().getStorecode() ;
	  prodTemplateFrame.setUndecorated(true);
 	  new gnComp().fillArticleNameCombo(comboFinishProduct) ;
	  new gnComp().fillArticleNameCombo(comboMaterial) ;
	  String vname  = "UOM" ;
	  new gnComp().fillMasterCombo(comboUOM, vname) ;
	  //new gnComp().fillMasterCombo(comboMaterialUOM, vname);
 }





class FinishdropdnLsnr implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent e) {
  	
   		String vcombo = "FinshProduct" ; 
         try {
         	setItemDetails(vcombo  ) ;
		} catch (ClassNotFoundException | SQLException e1) {
 			e1.printStackTrace();
		}
  	}
 }


class MaterialdropdnLsnr implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent e) {
      String vcombo = "Material" ; 
     try {
		setItemDetails(vcombo  ) ;
	} catch (ClassNotFoundException | SQLException e1) {
 		e1.printStackTrace();
	}
  	}
 }

 

private void setItemDetails(String vcombo  ) throws ClassNotFoundException, SQLException
{
	
  	switch(vcombo)
	{
 		case  "Material" :
  			
  			    String vmaterialname = 	comboMaterial.getSelectedItem().toString().trim() ;
  			 	String myArticle = "Code" ;
 			 	vmaterailArticlecode = new gnArticle().Article_getData(myArticle, vmaterialname) ;
 			 	 	
			    String vtype1 = "UOM" ;
			    String vuom = new gnArticle().Article_getData(vmaterailArticlecode, vtype1);
			    comboMaterialUOM.setSelectedItem(vuom) ;

			    vtype1 = "baseSP" ;
			    String vrate = new gnArticle().Article_getData(vmaterailArticlecode, vtype1);
 			    materialrate.setText(vrate);

 			   break ;
 
		case  "FinshProduct" :

			
			  String vfinishname = 	comboFinishProduct.getSelectedItem().toString().trim() ;
   		 	  myArticle = "Code" ;
   		 	  vfinishArticlecode = new gnArticle().Article_getData(myArticle, vfinishname) ;
		  	 	 
 
			  vtype1 = "UOM" ;
			  vuom = new gnArticle().Article_getData(vfinishArticlecode, vtype1);
			  comboMaterialUOM.setSelectedItem(vuom);

			  vtype1 = "baseSP" ;
			  vrate = new gnArticle().Article_getData(vfinishArticlecode, vtype1);
  			  rate.setText(vrate);
		 	
    		break ;

	}
	
}

class btnLsnr  implements ActionListener {
 	@Override
	public void actionPerformed(ActionEvent e) {
  		String value  = e.getActionCommand() ;
 		
 		if (value  == "Add")
 		{
 			String validate  =  validateAdd();
 			if (validate == "Sucess") 
 			{
 				try {
					addInTable() ;
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 			}
 		}

 		if (value  == "Save")
 		{
 			getheaderInfo() ;
 			
  			try {
  				DeleteTemplateData() ;
  				callSaveAction();
			} catch (ClassNotFoundException | SQLException | IOException e1) {
 				e1.printStackTrace();
			}
 		}
 		
 		
 		if (value  == "Close")
 		{
 			prodTemplateFrame.dispose();
 		}
 		
 	}
 }
	
 	
private String validateAdd()
{
 	    String status = "Sucess" ;
 	    String vfinishname = 	comboFinishProduct.getSelectedItem().toString().trim() ;
	 	String vmaterialname = 	comboMaterial.getSelectedItem().toString().trim() ;
 	
	 	if (qty.getText().length() == 0 | qty.getText().equals("0"))
	 	{
	 		new General().msg("Please check Qty <<Can't be 0>>");
	 		status = "Fail";
	 		qty.grabFocus();
 	 	}

	 	
	 	if (rate.getText().length() == 0 | rate.getText().equals("0"))
	 	{
	 		new General().msg("Please check Rate <<Can't be 0>>");
	 		status = "Fail";
	 		rate.grabFocus();
 	 	}

	 	if (materialqty.getText().length() == 0 | materialqty.getText().equals("0"))
	 	{
	 		new General().msg("Please check Qty <<Can't be 0>>");
	 		status = "Fail";
	 		materialqty.grabFocus();
 	 	}

	 	if (materialrate.getText().length() == 0 | materialrate.getText().equals("0"))
	 	{
	 		new General().msg("Please check Rate <<Can't be 0>>");
	 		status = "Fail";
	 		materialrate.grabFocus();
 	 	}
	 	
	 	if (vfinishname.equals(vmaterialname))
	 	{
	 		new General().msg("Please check material and finish product..<<Can't be Same>>");
	 		status = "Fail";
	 		comboMaterial.grabFocus();
	 		comboMaterial.setBackground(Color.red);
	 	}
	 	else
	 	{
	 		comboMaterial.setBackground(Color.WHITE);
	 		
	 	}
	 	return status ;
}

private void addInTable() throws ClassNotFoundException, SQLException
{
	
        String vfinishname = 	comboFinishProduct.getSelectedItem().toString().trim() ;
	 	String vmaterialname = 	comboMaterial.getSelectedItem().toString().trim() ;

	 	//To Get Article Code Of given Article Name
	 	String myArticle = "Code" ;
   	 	String vfinishProductCode = new gnArticle().Article_getData(myArticle, vfinishname) ;
  	 	String vmaterialCode = new gnArticle().Article_getData(myArticle, vmaterialname) ;
	 	
	 	String vqty =  qty.getText() ;
	 	String vrate = rate.getText() ;
	 	Double vvqty =  Double.parseDouble(vqty) ;
	 	Double vvrate = Double.parseDouble(vrate) ;
	 	Double vvvalue = (vvrate* vvqty) ;
	 	
	 	String vuom = comboUOM.getSelectedItem().toString() ;
	 	
 	 	
	 	String vmaterialqty =  materialqty.getText() ;
	 	String vmaterialrate = materialrate.getText() ;
	 	String vmaterialwtkg  = materialWeightkg.getText() ;
	 	
	 	Double vvmaterialwtkg =  Double.parseDouble(vmaterialwtkg) ;
	 	Double vvmaterialrate = Double.parseDouble(vmaterialrate) ;
	 	Double vmaterialvalue =  ( vvmaterialwtkg * vvmaterialrate ); 
 	 	
	 	String vmaterialuom =  comboMaterialUOM.getSelectedItem().toString() ;
	 	
	
	 	String col[] = {"Remove",   "Material" , "Name" , "Qty" , "UOM", "Rate/Kg" , "MaterialWT(Kg)", "Material Value"} ;
	 	model.setColumnIdentifiers(col);
	 	model.insertRow(0, new Object[]{"X" , vmaterialCode , vmaterialname, vmaterialqty , 
	 										vmaterialuom, vmaterialrate, vmaterialwtkg ,vmaterialvalue}) ;;
 	    JViewport prt = new JViewport();
   		table.setModel(model);
		new gnTable().setTableColWidth(table, 2, 250);
		//new gnTable().setTableColWidth(table, 8, 250);
		new gnTable().setTableBasics(table);
		new gnFontSetting().setMyFontBold(table, "F1", 11);
   		prt.setBackground(Color.WHITE);
		prt.add(table, col);
		prt.setVisible(true);
		jsp.setViewport(prt);
		disableFinishARticle();
	 	new General().removeRow(model, table);
	 	getheaderInfo() ;
}


private void disableFinishARticle()
{
 	comboFinishProduct.setEnabled(false);
 	comboUOM.setEnabled(false);
  	qty.setEditable(false);
 	rate.setEditable(false);
   }



private void enableFinishARticle()
{
 	comboFinishProduct.setEditable(false);
 	qty.setEditable(false);
 	rate.setEditable(false);
 	comboUOM.setEditable(false);
 }

 

private void getheaderInfo()
{
		Double v = new gnTable().getTotal(table, 6);
		int vcount = table.getRowCount();
		total.setText(Double.toString(v)) ;
		

}



private void callSaveAction() throws SQLException, ClassNotFoundException, IOException
{
 	String vtemplatename = templatename.getText();
  	//
    String vfinishname = 	comboFinishProduct.getSelectedItem().toString().trim() ;
   	String myArticle = "Code" ;
    String vfinishCode = new gnArticle().Article_getData(myArticle, vfinishname) ;
  	String vqty =  qty.getText() ;
 	String vrate = rate.getText() ;
 	Double vvqty =  Double.parseDouble(vqty) ;
 	Double vvrate = Double.parseDouble(vrate) ;
 	Double vvvalue = (vvrate* vvqty) ;
 	String finishvalue  = Double.toString(vvvalue);
  	
 	//
 	
 	new gnLogger().loggerDebugEntry("Template Data Inserting ", "Start Inserting Rows");
 	
   	
	prst = null;
	final int batchSize = 1;
	int TotalRecordinsert = 0;
	con2 = (Connection) this.getConnection();
	con2.setAutoCommit(false);
	String Status = "Fail";
	String poshdr = "Insert into prod_template(company_code, " + "site_code ,  "
  			+ " TemplateName  , TemplateType , FinishItemcode, FinishItemQty, "
  			+ " FinishItemRate,FinishItemValue , "
			+ " materialCode, materialQty, materialUOM , "
			+ " MaterialRate , MaterialWTKG ,  MaterialValue ,"
			+ "   MaterialActualUOM , FinishItemloss)" + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? )";
	try {
		int row = table.getRowCount();
	 	//String col[] = {"Remove",   "Material" , "Name" , "Qty" , "UOM", "Rate" , "WTKG", "Material Value"} ;
 		for (int k = 0; k < row; k++) {
 			if (vtemplatename.length() > 0) {
				prst = con2.prepareStatement(poshdr);
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vtemplatename);
				prst.setString(4, combotemptype.getSelectedItem().toString().trim() );
				prst.setString(5, vfinishCode) ;  
				prst.setString(6, vqty);  
				prst.setString(7, vrate);  
				prst.setString(8, finishvalue) ;   
				prst.setString(9,  table.getValueAt(k, 1).toString());
				prst.setString(10, table.getValueAt(k, 3).toString());
				prst.setString(11, table.getValueAt(k, 4).toString());
 				prst.setString(12, table.getValueAt(k, 5).toString());
 				prst.setString(13, table.getValueAt(k, 6).toString());
 				prst.setString(14, table.getValueAt(k, 7).toString());
 				prst.setString(15, new gnArticle().Article_getData(table.getValueAt(k, 1).toString(), "UOM"));
 				prst.setString(16,  lossper.getText());
  				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				DBhdr = "Fail";
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					DBhdr = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				DBhdr = "Sucess";
			}
		}
	} catch (SQLException e) {
		con2.rollback();
		DBhdr = "Fail";
		new General().msg(e.getLocalizedMessage());
	} finally {
		if (prst != null) {
			prst.close();
		}
		if (DBhdr == "Sucess") {
			con2.commit();
			con2.close();
			reset();
			new General().Quickmsg("Template Saved..");
		}
	}

 }




private void DeleteTemplateData() throws SQLException
{
 	String vtemplatename = templatename.getText();
 	String SQL = "Delete from  prod_template  where company_code = " + vcomp + " and  site_code = " + vstore +" "
			+ "  and TemplateName = '" + vtemplatename + "'  ";
 	this.getResult(SQL);

}


private void reset()
{
	new gnTable().RemoveTableRows(model);
	qty.setText("0");
	rate.setText("0");
	materialqty.setText("0");
	materialrate.setText("0");
 }
}//Last 

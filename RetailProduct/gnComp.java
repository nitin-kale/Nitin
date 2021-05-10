package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.List;
import java.awt.PopupMenu;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
 
public class gnComp extends getResultSet {

	public JFrame frame;
	public JPanel panel;
	public JComboBox<String> combo;
	public JButton btn;
	public JTextField text;
	public JFormattedTextField ftext;
	public ResultSet rs;
	public boolean ans;

	//=====Button 

	
	public JComboBox fillArticleName(JComboBox jbox) throws ClassNotFoundException, SQLException
	{
 		String vverticle = new gnHierarchy().getVerticleCode();
		String SQL = "Select Name from msArticle_master where company_code = "+vcomp+" and verticle = "+vverticle+" " ;
   		rs = this.getSPResult(SQL);
		while (rs.next()) {
			jbox.addItem(rs.getString(1) );
		}
		rs.close();
		this.closeconn();
		jbox.setFont(new Font("Tahoma", Font.BOLD, 13));
		return jbox;
 
	}
	

	public JComboBox<String> setMasterDataIncombo(String vvmastername, JComboBox jbox) throws SQLException, ClassNotFoundException {
	  	 String vtype = "MasterData" ;
	     String vmastername = vvmastername ;
	     String vverticle = "0";
	     String vname = "%%";
	     String SQL = "call master_getmasterData( '"+vmastername+"' , '"+vverticle+"' , '"+vname+"')" ;
	    // new General().msg(SQL);
	     rs = this.getSPResult(SQL);
			while (rs.next()) {
				jbox.addItem(rs.getString(1) );
			}
			rs.close();
			this.closeconn();
			jbox.setFont(new Font("Tahoma", Font.BOLD, 13));
			return jbox;
		}

	
	public JComboBox<String>  mytestcombo(JComboBox jbox  ) throws SQLException, ClassNotFoundException {
		 
		DefaultTableModel model = new DefaultTableModel();
		String vcol[] = {"Code , Name"} ;
		model.addRow(new Object[]{"123" , "Parle" });
		model.addRow(new Object[]{"1231" , "Parle1" });
		model.addRow(new Object[]{"1233" , "Parle2" });
		model.setColumnIdentifiers(vcol);
		JTable  table  = new JTable();
		table.setModel(model);
		
		JScrollPane jsp  = new JScrollPane();
		JViewport prt766 = new JViewport();
		prt766.setBackground(new Color(204, 255, 255));
		prt766.add(table, vcol);
		prt766.setVisible(true);
		jsp.setViewport(prt766);
		jsp.setVisible(true);
 		jsp.setBounds(1,1,200, 200);
		jbox.setBounds(1,1,200, 200);
		
 		jbox.add(jsp);
		jsp.setVisible(true);
  		new General().msgCombo(jbox);
 		new General().msgsearch(jsp, table, "32323", 100, 100);
 		 		
		return jbox;
	}
	
	
	
	
	public JComboBox<String> fillMasterCombo(JComboBox jbox , String Mastername) throws SQLException, ClassNotFoundException {
		 
		String vverticle = new gnHierarchy().getVerticleCode();
 		String SQL = " call   master_getmasterData('" + Mastername + "' , " + vverticle + " , '" + vmastersearchString + "')";
  		rs = this.getSPResult(SQL);
		while (rs.next()) {
			jbox.addItem(rs.getString(2) );
		}
		rs.close();
		this.closeconn();
		jbox.setFont(new Font("Tahoma", Font.BOLD, 13));
		return jbox;
	}
	
	

	public String  getCodeOfMasterDescription(String vmastername , String vdescription ) throws SQLException, ClassNotFoundException {
 		String vcode  = "0" ;
		String vtype = "Code" ;
 		String SQL = "call Master_getDescriptionofCode('"+vtype +"'  , '"+vcode+"'   , '"+vmastername+"' , '"+vdescription+"')";
 		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vcode = rs.getString(1) ;
		}
		rs.close();
		this.closeconn();
  		return vcode;
	}
 	

	public JComboBox<String> fillFinishItemCombo( JComboBox jbox) throws SQLException, ClassNotFoundException {
		
		String vtype = "GetFinishItemName" ;
		String vcode  = "0" ;
		String vname = "" ;
		String varticle = "" ;
		
 		String SQL = "call Template_getData( '"+vtype+"' , '"+vcomp+"' , '"+vstore+"' , '"+varticle+"' , '"+vname+"')" ;
 		rs = this.getSPResult(SQL);
		while (rs.next()) {
			jbox.addItem(rs.getString(1) );
		}
		rs.close();
		this.closeconn();
		jbox.setFont(new Font("Tahoma", Font.BOLD, 13));
		return jbox;
	}

	
	
	public JComboBox<String> fillArticleNameCombo( JComboBox jbox) throws SQLException, ClassNotFoundException {
		
		String vtype = "AllName" ;
		String vcode  = "0" ;
		String SQL = "call Article_getData( '"+vtype+"' , '"+vcomp+"' , '"+vcode+"')" ;
 		rs = this.getSPResult(SQL);
		while (rs.next()) {
			jbox.addItem(rs.getString(1) );
		}
		rs.close();
		this.closeconn();
		jbox.setFont(new Font("Tahoma", Font.BOLD, 13));
		return jbox;
	}

	
	

	
	// ======Combo
	public void setComboValue(JComboBox combo, ResultSet rs) throws SQLException {
		String displayName = rs.getString(1);
		combo.setSelectedItem(displayName);
	}

	public String getCheckBoxValue(JCheckBox chkbox) {
		String value = " ";
		boolean checked = chkbox.isSelected();
		if (checked) {
			value = "Y";
		} else {
			value = "N";
		}
		return value;
	}

	public String getComboValue(JComboBox combo) {
		String SelectedNameis = combo.getSelectedItem().toString();
 		return SelectedNameis;
	}

	
	public JComboBox<String> getDBName(JComboBox<String> jbox)
			throws SQLException, ClassNotFoundException, IOException {
		conn = this.getConnection();
		rs = conn.getMetaData().getCatalogs();
		while (rs.next()) {
			// System.out.println("Schema Name = " +
			// resultSet.getString("TABLE_CAT"));
			jbox.addItem(rs.getString("TABLE_CAT"));
		}
		rs.close();
		this.closeconn();
		return jbox;

	}

	public JComboBox<String> FillMasterName(String vmansterName, JComboBox jbox)
			throws SQLException, ClassNotFoundException {
		String verticle = new gnHierarchy().getVerticleCode();
		String Search = "%%";
		String SQL = "call master_getMasterData('" + vmansterName + "' , " + verticle + "    , '" + Search + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			jbox.addItem(rs.getString(2));
		}
		rs.close();
		this.closeconn();
		return jbox;
	}

	public void FillMasterNameinTable(String vmansterName, JTable table, int col)
			throws SQLException, ClassNotFoundException {

		String verticle = new gnHierarchy().getVerticleCode();
		String Search = "%%";
		String SQL = "call master_getMasterData('" + vmansterName + "' , " + verticle + "    , '" + Search + "')";
		table.getColumnModel().getColumn(col).setCellEditor(new DefaultCellEditor(new gnTable().generateNameBox(SQL)));
	}

	public JComboBox<String> fillCombo(String SQL, JComboBox jbox) throws SQLException, ClassNotFoundException {
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			jbox.addItem(rs.getString(1) );
		}
		rs.close();
		this.closeconn();
		jbox.setFont(new Font("Tahoma", Font.BOLD, 13));
		return jbox;
	}

	
	
	public JComboBox<String> fillCombo2(String SQL, JComboBox jbox) throws SQLException, ClassNotFoundException {
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			jbox.addItem(rs.getString(2));
		}
		rs.close();
		this.closeconn();
		jbox.setFont(new Font("Tahoma", Font.BOLD, 13));
		return jbox;
	}

	public JComboBox<String> generateBox(String SQL) { // used when In Table for
														// Cell ComboBox Needs
														// to Apply
		JComboBox<String> bx = null;
		try {
			ResultSet rs = this.getSPResult(SQL);
			bx = new JComboBox<String>();
			while (rs.next()) {
				bx.addItem(rs.getString(2));
			}
		} catch (Exception x) {
			System.out.println(x.getMessage());
		}
		// new General().msgCombo(bx);
		bx.setFont(new Font("Tahoma", Font.BOLD, 13));
		return bx;
	}

	public JComboBox<String> generateYNBox() { // used when In Table for Cell
												// ComboBox Needs to Apply
		JComboBox<String> bx = null;
		bx = new JComboBox<String>();
		bx.addItem("Y");
		bx.addItem("N");
		// new General().msgCombo(bx);
		return bx;
	}

	public JComboBox<String> generateStatus() { // used when In Table for Cell
												// ComboBox Needs to Apply
		JComboBox<String> bx = null;
		bx = new JComboBox<String>();
		bx.addItem("Pending");
		bx.addItem("Complete");
		bx.setFont(new Font("Tahoma", Font.BOLD, 13));
		return bx;
	}

	public JComboBox<String> generateWsaleBox() { // used when In Table for Cell
													// ComboBox Needs to Apply
		JComboBox<String> bx = null;
		bx = new JComboBox<String>();
		bx.addItem("NO");
		bx.addItem("Box");
		bx.addItem("Carton");
		// new General().msgCombo(bx);
		bx.setFont(new Font("Tahoma", Font.BOLD, 13));
		return bx;
	}

	// Frame Related
	public void enableFrame(JFrame frame) {
		frame.setEnabled(true);
	}

	public void disableFrame(JFrame frame) {
		frame.setEnabled(false);
	}

	public void showFrame(JFrame frame) {
		frame.setVisible(true);
	}

	public void hideFrame(JFrame frame) {
		frame.setVisible(false);
	}

	public boolean isFrameVisible(JFrame frame) {
		boolean ans = frame.isVisible();
		return ans;
	}

	public boolean isFrameActive(JFrame frame) {
		boolean ans = frame.isActive();
		return ans;
	}

	// Button RElated
	public void enableButton(JButton btn) {
		btn.setEnabled(true);
	}

	public void disableButton(JButton btn) {
		btn.setEnabled(false);
	}

	public void hideButton(JButton btn) {
		btn.setVisible(false);
	}

	public void showButton(JButton btn) {
		btn.setVisible(true);
	}

	// Textfield Related

	public int getLength(JTextField text) {
		int length = text.getDocument().getLength();
		return length;
	}

	public String getComboText(JComboBox text) {
		String enterTextis = (String) text.getSelectedItem();
		return enterTextis;
	}

	public String getText(JTextField text) {
		String enterTextis = text.getText();
		return enterTextis;
	}

	public String getFormattedText(JFormattedTextField text) {
		String enterTextis = text.getName();
		return enterTextis;
	}

	public void setText(JTextField text, String value) {
		text.setText(value);
	}

	public void enableText(JTextField text) {
		text.setEnabled(true);
	}

	public void disableText(JTextField text) {
		text.setEnabled(false);
	}

	public void editableText(JTextField text) {
		text.setEditable(true);
	}

	public void noneditableText(JTextField text) {
		text.setEditable(false);
	}

	// FormattedText Related

	public String getfTextValue(JFormattedTextField ftext) {

		String enterTextis = ftext.getText();
		return enterTextis;
	}

	public void setfTextValue(JFormattedTextField ftext, String value) {
		ftext.setText(value);
	}

	public void enablefText(JFormattedTextField ftext) {
		ftext.setEnabled(true);
	}

	public void disablefText(JFormattedTextField ftext) {
		ftext.setEnabled(false);
	}

	public void editablefText(JFormattedTextField text) {
		ftext.setEditable(true);
	}

	public void noneditablefText(JFormattedTextField text) {
		ftext.setEditable(false);
	}

	public static void main(String[] args) {

	}

	public JComboBox fillNameCombo(String SQL, JComboBox state) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			state.addItem(rs.getString(2));
		}
		rs.close();
		this.closeconn();
		return state;
	}
	
	

	
	public static ArrayList<Component> getAllComponents(final Container c) {
	    Component[] comps = c.getComponents();
	    ArrayList<Component> compList = new ArrayList<Component>();
	    for (Component comp : comps) {
	        compList.add(comp);

	        if (comp instanceof JFrame)
	        {
	            compList.addAll(getAllComponents((Container) comp));
	            comp.setBackground(Color.CYAN); 
	        }

	        
	        if (comp instanceof JPanel)
	        {
	            compList.addAll(getAllComponents((Container) comp));
	            comp.setBackground(Color.BLACK); 
	        }

	        
	        if (comp instanceof JTextField)
	        {
	            compList.addAll(getAllComponents((Container) comp));
	            comp.setBackground(Color.BLACK); 
	        }

	        if (comp instanceof JLabel)
	        {
	            compList.addAll(getAllComponents((Container) comp));
	            comp.setBackground(Color.yellow); 
	        }

	        
	    }
	    
	    
	    return compList;
	}
	
	
	
 	

}//Last

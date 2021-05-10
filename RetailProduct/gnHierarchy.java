package RetailProduct;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class gnHierarchy extends getResultSet {

	private String vverticle;
	private String vverticle_name;

	private String vsegment;
	private String vsegment_name;
	private String vhierarchyNo;
	private String vhierarchy_name;
	public String vcomp;

	public static String vArticle_category;
	public static String vArticle_categoryname;

	public static String vArticle_subcategory;
	public static String vArticle_subCatname;

	public static String vArticle_group;
	public static String vArticle_groupname;

	public static String vArticle_subGroup;
	public static String vArticle_subGroupname;

	public static String vlevel1;
	public static String vlevel2;
	public static String vlevel3;
	public static String vlevel4;
	public static String vlevel1name;
	public static String vlevel2name;
	public static String vlevel3name;
	public static String vlevel4name;

	private String Rvsegmentcode;
	private String Rverticlecode;
	private String Rhno;

	public DefaultTableModel model = new DefaultTableModel();
	public JTable table = new JTable();
	public JScrollPane sjsp = new JScrollPane();

	public static String code;
	public static String name;
	public static String vtype;

	public String getmySiteHierarchyNo() throws ClassNotFoundException, SQLException {

		String vhno = "";
		String SQL = "call hie_getMySiteHierarchyNo(" + compcode + " , " + vstore + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vhno = rs.getString(1);
		}
		return vhno;
	}

	public String getmySiteHierarchyName() throws ClassNotFoundException, SQLException {
		String vhname = "";
		String SQL = "call hie_getMySiteHierarchyNo(" + compcode + " , " + vstore + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vhname = rs.getString(2);
		}
		return vhname;
	}

	public String checkHiearchyAssign() throws ClassNotFoundException, SQLException {
		String Available = "Yes";
		String SQL = "Call hie_checkHieAssign()";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			Available = rs.getString(1);
		} else {
			Available = "No";
		}
		rs.close();
		this.closeconn();
		return Available;
	}

	private void getFieldValue() throws Throwable {
		Rvsegmentcode = getSegmentCode();
		Rverticlecode = getVerticleCode();
		Rhno = getHierarchyNo();
	}

	public String getCodeofgivenName(String vtype, String vcode) throws Throwable {
		getFieldValue();
		String vname = "";
		code = vcode;
		String vcomp = "0";
		String SQL = "call   Hierarchy_getInfo( '" + vtype + "' ,   " + Rverticlecode + " , " + Rvsegmentcode + " , "
				+ Rhno + " , '" + code + "')";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vname = rs.getString(1);
		}
		return vname;
	}

	public String getNameofgivenCode(String vtype, String vcode) throws Throwable {
		getFieldValue();
		String vname = "";
		code = vcode;
		String vcomp = "0";
		String SQL = "call   Hierarchy_getInfo( '" + vtype + "' ,   " + Rverticlecode + " , " + Rvsegmentcode + " , "
				+ Rhno + " , '" + code + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vname = rs.getString(2);
			// new General().msg(vname);
		}
		return vname;
	}

	public void getSubcatLevels(String vsubgroupcode) {
		try {
			getFieldValue();
		} catch (Throwable e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		code = vsubgroupcode;
		vtype = "SubcatLevels";
		String vcomp = "0";
		String SQL = "call   Hierarchy_getInfo( '" + vtype + "' ,   " + Rverticlecode + " , " + Rvsegmentcode + " , "
				+ Rhno + " , '" + code + "')";
		// new General().msg(SQL);
		try {
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				vArticle_category = rs.getString(5);
				vArticle_subcategory = rs.getString(1);
				vArticle_group = rs.getString(3);
				vArticle_subGroup = rs.getString(4);
				// vArticle_subGroupname = (table.getValueAt(row, 2).toString())
				// ;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public JTable getHierarchyInfoinmytable(String vvtype, String vsearchname) throws Throwable {
		getFieldValue();
		vtype = vvtype;
		String vcomp = "0";
		String SQL = "call   Hierarchy_getInfo( '" + vtype + "' ,   " + Rverticlecode + " , " + Rvsegmentcode + " , "
				+ Rhno + " , '" + vsearchname + "')";
		// new General().msg(SQL);
		String Col[] = { "Type", "Code", "Name", "Verticle", "Level", "hierarchyNo" };
		model.setColumnIdentifiers(Col);
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 5, "N", "Y", vtype);
		new gnTable().setTableBasics(table);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.black);
		return table;
	}

	public JComboBox<String> fillComboFor(String vvtype, JComboBox jbox) throws Throwable {
		getFieldValue();
		String vsearchname = "%%";
		vtype = vvtype;
		String vcomp = "0";
		String SQL = "call   Hierarchy_getInfo( '" + vtype + "' ,   " + Rverticlecode + " , " + Rvsegmentcode + " , "
				+ Rhno + " , '" + vsearchname + "')";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			jbox.addItem(rs.getString(2));
		}
		rs.close();
		this.closeconn();
		return jbox;
	}

	public void getHierarchyInfo(String vvtype, String vsearchname) throws Throwable {
		getFieldValue();
		vtype = vvtype;
		String vcomp = "0";
		String SQL = "call   Hierarchy_getInfo( '" + vtype + "' ,   " + Rverticlecode + " , " + Rvsegmentcode + " , "
				+ Rhno + " , '" + vsearchname + "')";
		String Col[] = { "Type", "Code", "Name", "Verticle", "Level", "hierarchyNo" };
		model.setColumnIdentifiers(Col);
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 5, "N", "Y", vtype);
		new gnTable().setTableBasics(table);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.black);
		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 2, 400);
		}
		Selectrow();
	}

	public JTable showArticleHierarchy(String vsearchname) throws Throwable {
		getFieldValue();
		if (Rhno.length() != 0) {
			new gnTable().RemoveTableRows(model);
			getFieldValue();
			String vtype = "Hierarchy";
			new gnTable().RemoveTableRows(model);
			// String SQL = "call hie_getDetailHierarchy( "+vhno+",
			// '"+vsegment+"', '"+vverticle+"', '"+vsearchname+"')" ;
			String SQL = "call hie_getDetailHierarchy(  " + Rhno + ", " + Rvsegmentcode + ", " + Rverticlecode + ", '"
					+ vsearchname + "')";
			// new General().msg(SQL);
			String Col[] = { "Type", "Code", "Name", "Catcode", "Cat Name", "subGroup Code", "SubGroup Name",
					"Group Code", "Group Name" };
			// new General().msg(SQL);
			model.setColumnIdentifiers(Col);
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, 8, "N", "Y", vtype);
			new gnTable().setTableBasics(table);
			table.setBackground(Color.DARK_GRAY);
			table.setForeground(Color.WHITE);
			if (table.getRowCount() > 0) {
				new gnTable().setTablewidth(table, 2, 250);
				new gnTable().setTablewidth(table, 4, 250);
				new gnTable().setTablewidth(table, 6, 250);
				new gnTable().setTablewidth(table, 8, 250);
			}
			Selectrow();
		}

		return table;
	}

	public JTable showArticleHierarchyhere(String vsearchname) throws Throwable {
		getFieldValue();
		if (Rhno.length() != 0) {
			new gnTable().RemoveTableRows(model);
			getFieldValue();
			String vtype = "Hierarchy";
			new gnTable().RemoveTableRows(model);
			// String SQL = "call hie_getDetailHierarchy( "+vhno+",
			// '"+vsegment+"', '"+vverticle+"', '"+vsearchname+"')" ;
			String SQL = "call hie_getDetailHierarchy(  " + Rhno + ", " + Rvsegmentcode + ", " + Rverticlecode + ", '"
					+ vsearchname + "')";
			// new General().msg(SQL);
			String Col[] = { "Type", "SubCatCode", "SubCatName", "Catcode", "Cat Name", "subGroup Code",
					"SubGroup Name", "Group Code", "Group Name" };
			// new General().msg(SQL);
			model.setColumnIdentifiers(Col);
			table = new gnTableModel().Tablemodel(table, model, SQL, Col, 8, "N", "Y", vtype);
			new gnTable().setTableBasics(table);
			table.setBackground(Color.DARK_GRAY);
			table.setForeground(Color.WHITE);
			if (table.getRowCount() > 0) {
				new gnTable().setTablewidth(table, 2, 250);
				new gnTable().setTablewidth(table, 4, 250);
				new gnTable().setTablewidth(table, 6, 250);
				new gnTable().setTablewidth(table, 8, 250);
			}
		}
		return table;
	}

	public JTable getlevel1(String vsearchname) throws Throwable {
		getFieldValue();
		vtype = "Level1";
		String vcomp = "0";
		String SQL = "call   Hierarchy_getInfo( '" + vtype + "' ,   " + Rverticlecode + " , " + Rvsegmentcode + " , "
				+ Rhno + " , '" + vsearchname + "')";
		// new General().msg(SQL);
		String Col[] = { "Type", "GroupCode", "GroupName", "Level" };
		model.setColumnIdentifiers(Col);
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 3, "N", "Y", vtype);
		new gnTable().setTableBasics(table);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.black);
		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 2, 400);
		}
		Selectrow();
		return table;
	}

	public JTable getlevel1here(String vsearchname) throws Throwable {
		getFieldValue();
		vtype = "Level1";
		String vcomp = "0";
		String SQL = "call   Hierarchy_getInfo( '" + vtype + "' ,   " + Rverticlecode + " , " + Rvsegmentcode + " , "
				+ Rhno + " , '" + vsearchname + "')";
		// new General().msg(SQL);
		String Col[] = { "Type", "GroupCode", "GroupName", "Level" };
		model.setColumnIdentifiers(Col);
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 3, "N", "Y", vtype);
		new gnTable().setTableBasics(table);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.black);
		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 2, 400);
		}
		return table;
	}

	public JTable getlevel2(String vsearchname) throws Throwable {
		getFieldValue();
		vtype = "Level2";
		String vcomp = "0";
		String SQL = "call   Hierarchy_getInfo( '" + vtype + "' ,   " + Rverticlecode + " , " + Rvsegmentcode + " , "
				+ Rhno + " , '" + vsearchname + "')";
		// new General().msg(SQL);
		String Col[] = { "Type", "SubGroupCode", "SubGroupName", "Group", "Group Name" };
		model.setColumnIdentifiers(Col);
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 4, "N", "Y", vtype);
		new gnTable().setTableBasics(table);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.black);
		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 2, 400);
		}
		Selectrow();
		return table;

	}

	public JTable getlevel2here(String vsearchname) throws Throwable {
		getFieldValue();
		vtype = "Level2";
		String vcomp = "0";
		String SQL = "call   Hierarchy_getInfo( '" + vtype + "' ,   " + Rverticlecode + " , " + Rvsegmentcode + " , "
				+ Rhno + " , '" + vsearchname + "')";
		// new General().msg(SQL);
		String Col[] = { "Type", "SubGroupCode", "SubGroupName", "Group", "Group Name" };
		model.setColumnIdentifiers(Col);
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 4, "N", "Y", vtype);
		new gnTable().setTableBasics(table);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.black);
		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 2, 400);
		}
		return table;
	}

	public JTable getlevel3(String vsearchname) throws Throwable {
		getFieldValue();
		vtype = "Level3";
		String vcomp = "0";
		String SQL = "call   Hierarchy_getInfo( '" + vtype + "' ,   " + Rverticlecode + " , " + Rvsegmentcode + " , "
				+ Rhno + " , '" + vsearchname + "')";
		// new General().msg(SQL);
		String Col[] = { "Type", "Catcode", "CatName", "SubGroupCode", "SubGroupName", "Group", "Group Name" };
		model.setColumnIdentifiers(Col);
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 6, "N", "Y", vtype);
		new gnTable().setTableBasics(table);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.black);
		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 2, 400);
		}
		Selectrow();
		return table;
	}

	public JTable getlevel3here(String vsearchname) throws Throwable {
		getFieldValue();
		vtype = "Level3";
		String vcomp = "0";
		String SQL = "call   Hierarchy_getInfo( '" + vtype + "' ,   " + Rverticlecode + " , " + Rvsegmentcode + " , "
				+ Rhno + " , '" + vsearchname + "')";
		// new General().msg(SQL);
		String Col[] = { "Type", "Catcode", "CatName", "SubGroupCode", "SubGroupName", "Group", "Group Name" };
		model.setColumnIdentifiers(Col);
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 6, "N", "Y", vtype);
		new gnTable().setTableBasics(table);
		table.setBackground(Color.WHITE);
		table.setForeground(Color.black);
		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 2, 400);
		}
		return table;
	}

	public void showHierarchy(String vsearchname) throws Throwable {
		new gnTable().RemoveTableRows(model);
		getFieldValue();
		String vtype = "Hierarchy";
		new gnTable().RemoveTableRows(model);
		String SQL = "call hie_getDetailHierarchy(  " + Rhno + ", " + Rvsegmentcode + ", " + Rverticlecode + ", '"
				+ vsearchname + "')";
		String Col[] = { "Type", "subgroup", "Groupname", "Group code", "Group Name", "Sub cat code", "Sub cat name",
				"Cat Code", "Cat name" };
		model.setColumnIdentifiers(Col);
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 8, "N", "Y", vtype);
		new gnTable().setTableBasics(table);
		table.setBackground(Color.DARK_GRAY);
		table.setForeground(Color.WHITE);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 2, 250);
			new gnTable().setTablewidth(table, 4, 250);
			new gnTable().setTablewidth(table, 6, 250);
			new gnTable().setTablewidth(table, 8, 250);
		}
		Selectrow();
		// new General().msgsearch(sjsp , table , "Select Hierarchy ", 800,400);
	}

	public void Selectrow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {
					displayInfo(value, row);
					table.addNotify();
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		new gnTable().setTableColWidth(table, 1, 250);
		new General().msgsearch(sjsp, table, "Select Data ", 900, 300);
	}

	private void displayInfo(String value, int row) throws Throwable {
		switch (value) {

		case "Level1":
			vlevel1 = (table.getValueAt(row, 1).toString());
			vlevel1name = (table.getValueAt(row, 2).toString());
			code = (table.getValueAt(row, 1).toString());
			name = (table.getValueAt(row, 2).toString());
			break;

		case "Level2":
			vlevel2 = (table.getValueAt(row, 1).toString());
			vlevel2name = (table.getValueAt(row, 2).toString());
			code = (table.getValueAt(row, 1).toString());
			name = (table.getValueAt(row, 2).toString());

			vlevel1 = (table.getValueAt(row, 3).toString());
			vlevel1name = (table.getValueAt(row, 4).toString());
			break;

		case "Level3":
			vlevel3 = (table.getValueAt(row, 1).toString());
			vlevel3name = (table.getValueAt(row, 2).toString());
			code = (table.getValueAt(row, 1).toString());
			name = (table.getValueAt(row, 2).toString());

			vlevel2 = (table.getValueAt(row, 3).toString());
			vlevel2name = (table.getValueAt(row, 4).toString());
			vlevel1 = (table.getValueAt(row, 5).toString());
			vlevel1name = (table.getValueAt(row, 6).toString());
			break;

		case "SubGroup":

			vArticle_subGroup = (table.getValueAt(row, 1).toString());
			vArticle_subGroupname = (table.getValueAt(row, 2).toString());
			code = (table.getValueAt(row, 1).toString());
			name = (table.getValueAt(row, 2).toString());
			break;

		case "Group":
			code = (table.getValueAt(row, 1).toString());
			name = (table.getValueAt(row, 2).toString());
			break;

		case "Category":
			code = (table.getValueAt(row, 1).toString());
			name = (table.getValueAt(row, 2).toString());
			break;

		case "SubCategory":
			vArticle_subcategory = (table.getValueAt(row, 1).toString());
			vArticle_subCatname = (table.getValueAt(row, 2).toString());
			code = (table.getValueAt(row, 1).toString());
			name = (table.getValueAt(row, 2).toString());
			break;

		case "Hierarchy":

			code = (table.getValueAt(row, 1).toString());
			name = (table.getValueAt(row, 2).toString());
			vArticle_subcategory = (table.getValueAt(row, 1).toString());
			vArticle_subCatname = (table.getValueAt(row, 2).toString());
			vArticle_category = (table.getValueAt(row, 3).toString());
			vArticle_categoryname = (table.getValueAt(row, 4).toString());
			vArticle_subGroup = (table.getValueAt(row, 5).toString());
			vArticle_subGroupname = (table.getValueAt(row, 6).toString());
			vArticle_group = (table.getValueAt(row, 7).toString());
			vArticle_groupname = (table.getValueAt(row, 8).toString());

			if (vArticle_category.length() == 0) {
				vArticle_category = "0";
			}
			if (vArticle_subcategory.length() == 0) {
				vArticle_subcategory = "0";
			}
			if (vArticle_group.length() == 0) {
				vArticle_group = "0";
			}
			// vArticle_subGroup =(table.getValueAt(row, 1).toString()) ;
			new General().msgDispose();
			break;
		}
	}

	public void gnHierarchy() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();

	}

	public ResultSet hieDesc_allData() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		String SQL = "call hieDesc_getAllData(" + vcomp + ")";
		rs = this.getSPResult(SQL);
		return rs;
	}

	public String getSegmentCode() {
		// vsegment =new gnPublicVariable().getSegmentCode() ;
		vsegment = "1";

		return vsegment;
	}

	public String getSegmentName() {
		vsegment = new gnPublicVariable().getSegmentName();
		return vsegment_name;
	}

	public String getVerticleCode() {
		try {
			vverticle = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
					new gnPublicVariable().vstore);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		// new General().msg(vverticle);
		return vverticle;
	}

	public String getVerticleName() {
		try {
			vverticle_name = new getConfigurationSetting().getVerticleName(new gnPublicVariable().vcomp,
					new gnPublicVariable().vstore);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		// new General().msg(vverticle_name);
		return vverticle_name;
	}

	public String getHierarchyNo() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call  hieDesc_getDefaultHierarchy(" + vcomp + ", " + vstore + ")";
		rs = this.getSPResult(SQL);
		rs.next();
		vhierarchyNo = rs.getString(1);
		vhierarchy_name = rs.getString(2);
		rs.close();
		this.closeconn();
		return vhierarchyNo;
	}

	public String getHierarchyName() throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String SQL = "call  hieDesc_getDefaultHierarchy(" + vcomp + ", " + vstore + ")";
		rs = this.getSPResult(SQL);
		rs.next();
		vhierarchyNo = rs.getString(1);
		vhierarchy_name = rs.getString(2);
		rs.close();
		this.closeconn();
		return vhierarchy_name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

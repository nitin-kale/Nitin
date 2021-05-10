package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

public class gnAdmin extends getResultSet {

	public String vuser;
	public String sql;
	public String type;
	public String vcomp;
	
	public JComboBox   articleCombo  ; ;

	public DefaultTableModel vmodel = new DefaultTableModel();
	public JScrollPane sjsp = new JScrollPane();
	public JTextField vcompcode;
	public JTextField vcompname;

	public JTextField vstorecode;
	public JTextField vstorename;

	public JTextField vsegmentcode;
	public JTextField vsegmentname;

	public JTextField vverticle;
	public JTextField vverticlename;

	public JTextField vhierarchyno;
	public JTextField vhierarchyname;

	public JTextField vpacktype;
	public JTextField vpacktypename;

	public JTextField code;
	public JTextField name;

	public String varticle = "0";
	public String ACol[] = {};
	public String vtrantype;
	public static String rArticle = " ";
	public static String rArticlename = " ";

	public static String rcompcode;
	public static String rcompname;
	public static String rverticlecode;
	public static String rverticlename;
	public static String rhieno;
	public static String rhiename;
	public static String rsegmentcode;
	public static String rsegmentname;
	String as[];
	Vector vt;

	public JTable vtable = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
 
			if (column == 1 || column == 1 || column == 2 || column == 3 || column == 5 || column == 6 || column == 16
					|| column == 17 || column == 18 || column == 21) {
				componentt.setBackground(Color.white);
				componentt.setForeground(Color.blue);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
			} else {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Cambria", Font.PLAIN, 14));
			}

			if (column == 0) {
				componentt.setBackground(Color.DARK_GRAY);
				componentt.setForeground(Color.YELLOW);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 14));
			}

			if (Language == "H") {
				if (column == 2) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}
			return componentt;
		}
	};

	public JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);
			// if ( column == 0 || column == 3 || column==5|| column== 6||
			// column ==8 || column ==9 || column == 10 || column == 16 ||
			// column == 17 || column == 18|| column == 21)

			if (column == 0 || column == 3 || column == 5 || column == 6 || column == 16 || column == 17 || column == 18
					|| column == 21) {
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setCursor(getCursor());
				componentt.setFont(new Font("Cambria", Font.PLAIN, 12));
			} else {
				componentt.setBackground(Color.CYAN);
				componentt.setForeground(Color.BLACK);
				componentt.setFont(new Font("Cambria", Font.PLAIN, 14));
			}

			if (Language == "H") {
				if (column == 2) {
					componentt.setFont(new Font("Shivaji02", Font.PLAIN, 16));
				}
			}
			return componentt;
		}
	};

	
	
	
	public JTable Searchintabe(String vtype, String sname, String varticle1, String vtrantype1) throws Throwable {
 		vtrantype = vtrantype1;
		varticle = varticle1;
		new gnTable().RemoveTableRows(vmodel);
		vcomp = new gnConfig().getCompanyCode();
		String vverticlecode = new gnHierarchy().getVerticleCode() ; 
		if (vverticlecode.equals("15"))
		{
			//new General().msg(vverticlecode);
			vtype = "Service" ;
			String ACol[] = { "Type", "Service", "Name", "MRP", "Sales Price", "Pk.Size", "UOM" };
 			String SQL = "Select Article_code , Name , MRP, SalesPrice, packSize, uom "
	 				+ "from msArticle_master "
	 				+ "where company_code = "+vcomp+"  and verticle = "+vverticlecode+"   and  name like '"+sname+"' " ;
		    vmodel.setColumnIdentifiers(ACol);
  			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 6, "N", "Y", vtype);
		    vmodel.setColumnIdentifiers(ACol);
		}

		
		if (vverticlecode.equals("1"))// GeneralRetail
		{
			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
 			//new General().msg(SQL);
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "Pk.Size", "UOM" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 12, "N", "Y", vtype);
		}

		if (vverticlecode.equals("2")) // Pharma
		{
			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + "  )";
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "PK.Size", "UOM", "Content", "DrugType" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 14, "N", "Y", vtype);
		}

		if (vverticlecode.equals("3"))// resto & bar
		{
  			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
			// new General().msg(SQL);
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Pk.Size", "UOM" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 6, "N", "Y", vtype);
		}
 
		
 
			if (vverticlecode.equals("11"))// automiblie 
			{
	 			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
	 			String ACol[] = { "Type", "Item Code", "Name", "Model",  "Color", "Power", "MRP", 
	 					           "Sales Price", "Pk.Size", "UOM" };
				table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 9, "N", "Y", vtype);
			}
 
		
		if (vverticlecode.equals("5")) // Fertilizer
		{
			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "PK.Size", "UOM", "Content", "DrugType" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 14, "N", "Y", vtype);
		}

		if (vverticlecode.equals("7")) // Fashion
		{
			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "Material", "Size", "Color", "Pattern" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 14, "N", "Y", vtype);
		}

		if (vverticlecode.equals("12")) // Hardware
		{
			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + "     )";
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "Pk.Size", "UOM" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 12, "N", "Y", vtype);
		}

		if (vverticlecode.equals("13")) // Cosmetics
		{
			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + "  )";
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "Pk.Size", "UOM" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 12, "N", "Y", vtype);
		}

		
		if (table.getRowCount() > 0) {
			table.setEnabled(true);
			new gnTable().setTableColWidth(table, 2, 250);
			new gnTable().setTableColWidth(table, 1, 25);
			// new General().msgsearch(sjsp, table, "Select Data ", 1000,400 );
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			// SelectArticlerow();
		}
		return table;
	}



	
	
	
	public JTable SearchintabeByShortKey(String vtype, String sname )throws Throwable {
 		vtrantype = "NA";
		varticle = "0";
 	 if (sname.length() >= 2)
	 {
 		try{	
		new gnTable().RemoveTableRows(vmodel);
		vcomp = new gnConfig().getCompanyCode();
	 	String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
  		//String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
 		String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Pk.Size", "UOM" };
  		String SQL = "Select Article_code , Name , MRP, SalesPrice, packSize, uom "
 				+ "from msArticle_master "
 				+ "where company_code = "+vcomp+"  and verticle = "+vverticlecode+"   and description  = '"+sname+"' " ;
  		//new General().msg(SQL);
  		table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 6, "N", "Y", vtype);
  		if (table.getRowCount() > 0) {
			table.setEnabled(true);
			new gnTable().setTableColWidth(table, 2, 250);
			new gnTable().setTableColWidth(table, 1, 25);
			// new General().msgsearch(sjsp, table, "Select Data ", 1000,400 );
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			// SelectArticlerow();
		}
	    }catch(Exception e)
		{
	    	new gnLogger().loggerInfoEntry("ShortKey", e.getLocalizedMessage());
		}
 	}
		return table;
 }
	
	
	
	
	public JTable Search(String vtype, String sname, String varticle1, String vtrantype1) throws Throwable {
		// '"+ svsize+"' , '"+svcolor+"', '"+svpattern+"' , '"+svbrand+"',
		// '"+svsubgroup+"'
		vtrantype = vtrantype1;
		varticle = varticle1;
		new gnTable().RemoveTableRows(vmodel);
		vcomp = new gnConfig().getCompanyCode();
		new gnTable().RemoveTableRows(vmodel);
		String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);

		if (vverticlecode.equals("1"))// GeneralRetail
		{
			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
			// new General().msg(SQL);
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "Pk.Size", "UOM" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 12, "N", "Y", vtype);
		}

		if (vverticlecode.equals("2")) // Pharma
		{
			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + "  )";
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "PK.Size", "UOM", "Content", "DrugType" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 14, "N", "Y", vtype);
		}

		if (vverticlecode.equals("5")) // Fertilizer
		{
			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "PK.Size", "UOM", "Content", "DrugType" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 14, "N", "Y", vtype);
		}

		if (vverticlecode.equals("7")) // Fashion
		{
			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "Material", "Size", "Color", "Pattern" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 14, "N", "Y", vtype);
		}


		if (vverticlecode.equals("11")) // Automobile
		{
			//String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
			//String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
			//		"Taxcode", "SubGrooup", "Brand", "Material", "Size", "Color", "Pattern" };
			//table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 14, "N", "Y", vtype);

			if (vverticlecode.equals("11"))// automiblie 
			{
	 			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
	 			String ACol[] = { "Type", "Item Code", "Name", "Model",  "Color", "Power", "MRP", 
	 					           "Sales Price", "Pk.Size", "UOM" };
				table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 9, "N", "Y", vtype);
			}
 
		
		}


		if (vverticlecode.equals("3"))// resto & bar
		{
  			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + " )";
			// new General().msg(SQL);
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Pk.Size", "UOM" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 6, "N", "Y", vtype);
		}

		
		if (vverticlecode.equals("12")) // Hardware
		{
			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + "     )";
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "Pk.Size", "UOM" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 12, "N", "Y", vtype);
		}

		if (vverticlecode.equals("13")) // Cosmetics
		{
			String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + "  )";
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "Pk.Size", "UOM" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 12, "N", "Y", vtype);
		}

		if (table.getRowCount() > 0) {
			table.setEnabled(true);
			new gnTable().setTableColWidth(table, 2, 250);
			new gnTable().setTableColWidth(table, 1, 25);
			// new General().msgsearch(sjsp, table, "Select Data ", 1000,400 );
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			SelectArticlerow();
		}
		return table;
	}

	
	
	public JTable SearchBulkArticle(String vtype, String sname, String varticle1, String vtrantype1) throws Throwable {
		// '"+ svsize+"' , '"+svcolor+"', '"+svpattern+"' , '"+svbrand+"',
		// '"+svsubgroup+"'
		vtrantype = vtrantype1;
		varticle = varticle1;
		String SQL = "";
		new gnTable().RemoveTableRows(vmodel);
		vcomp = new gnConfig().getCompanyCode();
		new gnTable().RemoveTableRows(vmodel);
		String vverticlecode = new getConfigurationSetting().getVerticleCode(new gnPublicVariable().vcomp,
				new gnPublicVariable().vstore);
		vverticlecode = "1";
		if (vverticlecode.equals("1"))// GeneralRetail
		{
			SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , '" + vverticlecode + "' )";
			// new General().msg(SQL);
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode", "SubGrooup", "Brand", "Pk.Size", "UOM" };
			table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 12, "N", "Y", vtype);
		}

		if (table.getRowCount() > 0) {
			table.setEnabled(true);
			new gnTable().setTableColWidth(table, 2, 250);
			new gnTable().setTableColWidth(table, 1, 25);
			// new General().msgsearch(sjsp, table, "Select Data ", 1000,400 );
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			SelectArticlerow();
		}
		return table;
	}

	public String master_getDescriptionofcode(String vtype, String vcode, String vmastername)
			throws ClassNotFoundException, SQLException {
		String vdesc = "";
		String SQL = " call  Master_getDescriptionofCode('" + vtype + "' , '" + vcode + "' , '" + vmastername + "' ,  '"
				+ vdesc + "') ";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vdesc = rs.getString(2);
		}
		return vdesc;
	}

	public void articleNameSearch(String sname, JTextField vcode, JTextField vname) throws Throwable {
		code = vcode;
		name = vname;
		new gnTable().RemoveTableRows(vmodel);
		vcomp = new gnConfig().getCompanyCode();
		new gnTable().RemoveTableRows(vmodel);
		String vverticlecode = new gnHierarchy().getVerticleCode();
		String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + "  , " + vverticlecode + ")";
 		String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
				"Taxcode" };
		String vtype = "Article";
		table = new gnTableModel().Tablemodel(table, vmodel, SQL, ACol, 8, "N", "Y", vtype);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		if (table.getRowCount() > 0) {
			table.setEnabled(true);
			new gnTable().setTableColWidth(table, 2, 250);
			new gnTable().setTableColWidth(table, 1, 250);
			SelectArticlerow();
		}
	}

	public void SelectArticlerowNew() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {
					displayArticle(row, value);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				new General().msgDisposeNew();
			}
		});
		new gnTable().setTableColWidth(table, 1, 50);
		new gnTable().setTableColWidth(table, 2, 300);
		new General().msgsearchNew(sjsp, table, "SelectArticle", 1100, 400);
	}

	public void SelectArticlerow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {

					displayArticle(row, value);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				new General().msgDispose();
			}
		});
		new gnTable().setTableColWidth(table, 1, 50);
		new gnTable().setTableColWidth(table, 2, 300);
		new gnTable().setTableBasics(table);
		new General().msgsearch(sjsp, table, "SelectArticle", 1100, 400);
	}

	public void displayArticle(int row, String value) throws Throwable {
		if (table.getRowCount() > 0) {
			rArticle = (String) table.getValueAt(row, 1);
			rArticlename = (String) table.getValueAt(row, 2);
			code.setText(rArticle);
			name.setText(rArticlename);
			possearcharticle = rArticle;
		} else {
			new General().msg("No Item Found For Such Name..");
		}
		new General().msgDispose();
	}

	public void hierarchy_getHierarchyData(JTextField hno, JTextField hname) throws Throwable {
		code = hno;
		name = hname;
		String vtype1 = "ALL";
		String vverticlecode = "";
		String SQL = "Call     hieDesc_getallData('" + vtype1 + "' , " + vverticlecode + ")";
		String vtype = "Hierarchy";
		String ACol[] = { "Type", "Segment", "Seg.Name", "Verticle", "Verticle Name", "Hie.No", "Name" };
		showTable_comp(SQL, vtype, ACol);
	}

	public void setverticle(JTextField verticlecode, JTextField verticlename, JTextField Hiearchyno, JTextField hname)
			throws Throwable {
		vverticle = verticlecode;
		vverticlename = verticlename;
		vhierarchyno = Hiearchyno;
		vhierarchyname = hname;
		sjsp.setBounds(0, 0, 1184, 425);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		vuser = new gnConfig().getUserCode().toUpperCase();
		String Col[] = { "Type", "Segment", "Segment_Name", "verticle", "Verticle_Name", "HierarchyNo",
				"Hierarchy_Name" };
		switch (vuser) {
		case "ADMIN":
			String vtype = "ALL";
			String vverticlecode = "";
			String SQL = "Call     hieDesc_getallData('" + vtype + "' , '" + vverticlecode + "')";
			type = "Verticle";
			showTable_comp(SQL, type, Col);
			break;
		}
	}

	public void getHierarchyDescOfGivenVerticle(String vverticlecode, JTextField Hiearchyno, JTextField hname)
			throws Throwable {
		vhierarchyno = Hiearchyno;
		vhierarchyname = hname;
		sjsp.setBounds(0, 0, 1184, 425);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		String Col[] = { "Type", "Segment", "Segment_Name", "verticle", "Verticle_Name", "HierarchyNo",
				"Hierarchy_Name" };
		String vtype = "Verticle";
		String SQL = "Call     hieDesc_getallData('" + vtype + "' , " + vverticlecode + ")";
		type = "Verticle-Hie";
		showTable_comp(SQL, type, Col);
	}

	public void Selectrow() {
		vtable.requestFocus();
		vtable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		vtable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = vtable.getSelectedRow();
				String value = (String) vtable.getValueAt(row, 0);
				try {
					display(row, value);
				} catch (Throwable e1) {
					e1.printStackTrace();
				} // showCustData();
				new General().msgDispose();
			}
		});
		new gnTable().setTableColWidth(vtable, 1, 250);
		new General().msgsearch(sjsp, vtable, "Select Data ", 900, 300);
	}

	private void selectRow() {
		vtable.requestFocus();
		vtable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		vtable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = vtable.getSelectedRow();
				vtable.setCursor(new Cursor(Cursor.HAND_CURSOR));
				String value = (String) vtable.getValueAt(row, 0);
				try {
					display(row, value);
					new General().msgDispose();
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
				}
			}
		});
	}

	public void display(int row, String value) throws Throwable {
		value = value.trim();
		new General().msg(value);
		switch (value) {
		case "Article":
			if (table.getRowCount() > 0) {
				rArticle = (String) table.getValueAt(row, 1);
				rArticlename = (String) table.getValueAt(row, 2);
				new General().msg(rArticle + " " + rArticlename);
				code.setText(rArticle);
				name.setText(rArticlename);
				new General().msgDispose();
			} else {
				new General().msg("No Item Found For Such Name..");
			}
			break;

		case "Hierarchy":
			code.setText(vtable.getValueAt(row, 5).toString());
			name.setText(vtable.getValueAt(row, 6).toString());
			break;

		case "Verticle":
			vverticle.setText(vtable.getValueAt(row, 3).toString());
			vverticlename.setText(vtable.getValueAt(row, 4).toString());
			vhierarchyno.setText(vtable.getValueAt(row, 5).toString());
			vhierarchyname.setText(vtable.getValueAt(row, 6).toString());
			break;

		case "Verticle-Hie":
			vhierarchyno.setText(vtable.getValueAt(row, 5).toString());
			vhierarchyname.setText(vtable.getValueAt(row, 6).toString());
			break;

		case "Company":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			break;
		case "CompanyAll":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			vsegmentcode.setText(vtable.getValueAt(row, 5).toString());
			vsegmentname.setText(vtable.getValueAt(row, 6).toString());
			vverticle.setText(vtable.getValueAt(row, 7).toString());
			vverticlename.setText(vtable.getValueAt(row, 8).toString());
			vhierarchyno.setText(vtable.getValueAt(row, 9).toString());
			vhierarchyname.setText(vtable.getValueAt(row, 10).toString());

			rcompcode = vtable.getValueAt(row, 1).toString();
			rcompname = vtable.getValueAt(row, 2).toString();
			rsegmentcode = vtable.getValueAt(row, 5).toString();
			rsegmentname = vtable.getValueAt(row, 6).toString();
			rverticlecode = vtable.getValueAt(row, 7).toString();
			rverticlename = vtable.getValueAt(row, 8).toString();
			rhieno = vtable.getValueAt(row, 9).toString();
			rhiename = vtable.getValueAt(row, 10).toString();
			break;
		case "Store":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			break;

		// Starts Here for Article Master
		case "Parent code":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Uom":

			code.setText(vtable.getValueAt(row, 1).toString());
			new General().msgDispose();
			break;
		case "Country":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Size":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Color":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Fit":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Fabric":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Style":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Pattern":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Pack_Type":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Pack_Form":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Article_Class":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			new General().msgDispose();
			break;
		case "Tax":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			break;
		case "Article_Type":
			code.setText(vtable.getValueAt(row, 1).toString());
			name.setText(vtable.getValueAt(row, 2).toString());
			break;
		//
		}
		new General().msgDispose();

	}

	public JTable GetSearchAtricle(String sname) throws Throwable {
		new gnTable().RemoveTableRows(vmodel);
		vcomp = new gnConfig().getCompanyCode();
		new gnTable().RemoveTableRows(vmodel);
		String vverticlecode = new gnHierarchy().getVerticleCode();
		String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + " , " + vverticlecode + ")";
		String ACol[] = { "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle", "Tax code" };
		vtable = new gnTableModel().Tablemodel(vtable, vmodel, SQL, ACol, 8, "N", "N", "N");
		return vtable;
	}

	public void getCollectionForArticle() throws Throwable {
		String sname = "%%";
		vcomp = new gnConfig().getCompanyCode();
		String SQL = "call  Tb_getAllArticleName('" + sname + "' , " + vcomp + ")";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			{
				as = new String[] { "Article", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) };
				vt.add(as);
 			}
		}
		rs.close();
		this.closeconn();
	}

	public void CollectionSearch(String vtype, String sname, String varticle1, String vtrantype1) throws Throwable {
		getCollectionForArticle();
		vtrantype = vtrantype1;
		varticle = varticle1;
		new gnTable().RemoveTableRows(vmodel);
		vcomp = new gnConfig().getCompanyCode();
		switch (vtype) {
		case "Article":
			new gnTable().RemoveTableRows(vmodel);
			String ACol[] = { "Type", "Item Code", "Name", "MRP", "Sales Price", "Cost", "Batch Article", "Verticle",
					"Taxcode" };
			vmodel.setColumnIdentifiers(ACol);
			vmodel.addRow(vt);
			table.setModel(vmodel);
			table.setCursor(new Cursor(Cursor.HAND_CURSOR));
			break;
		}
		if (table.getRowCount() > 0) {
			table.setEnabled(true);
			new gnTable().setTableColWidth(table, 2, 250);
			SelectArticlerow();
		}
	}

	public void showTax(String Name, JTextField vcode, JTextField vname) throws Throwable {
		code = vcode;
		name = vname;
		sjsp.setBounds(0, 0, 1184, 425);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		vuser = new gnConfig().getUserCode().toUpperCase();
		new gnTable().RemoveTableRows(vmodel);
		String Col[] = { " Type ", "Code ", "Description" };
		String SQL = "call Conf_getAllTaxMasterData()";
		vmodel.setColumnIdentifiers(Col);
		new gnTable().RemoveTableRows(vmodel);
		vtable = new gnTableModel().Tablemodel(vtable, vmodel, SQL, Col, 2, "N", "Y", Name);
		vtable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		SelectMasterRow();
	}

	public void showMasterTable(String Name, JTextField vcode, JTextField vname) throws Throwable {
		code = vcode;
		name = vname;
		sjsp.setBounds(0, 0, 1184, 425);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		vuser = new gnConfig().getUserCode().toUpperCase();
		new gnTable().RemoveTableRows(vmodel);
		String Col[] = { " Type ", "Code ", "Description" };
		String vverticle = new gnHierarchy().getVerticleCode();
		String SQL = " call   master_getmasterData('" + Name + "' , " + vverticle + " , '" + vmastersearchString + "')";
		vmodel.setColumnIdentifiers(Col);
		new gnTable().RemoveTableRows(vmodel);
		vtable = new gnTableModel().Tablemodel(vtable, vmodel, SQL, Col, 2, "N", "Y", Name);
 		vtable.setCursor(new Cursor(Cursor.HAND_CURSOR));
	 	SelectMasterRow();
		vtable.setOpaque(false);
		sjsp.setOpaque(false);
 		vmastersearchString = "%%";
	}


	
	public JTable showMasterTableinTable(String Name, String searchSting) throws Throwable {
 		vmastersearchString  = searchSting ;
		sjsp.setBounds(0, 0, 1184, 425);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		vuser = new gnConfig().getUserCode().toUpperCase();
		new gnTable().RemoveTableRows(vmodel);
		String Col[] = { " Type ", "Code ", "Description" };
		String vverticle = new gnHierarchy().getVerticleCode();
		String SQL = " call   master_getmasterData('" + Name + "' , " + vverticle + " , '" + vmastersearchString + "')";
		vmodel.setColumnIdentifiers(Col);
		new gnTable().RemoveTableRows(vmodel);
		vtable = new gnTableModel().Tablemodel(vtable, vmodel, SQL, Col, 2, "N", "Y", Name);
 		vtable.setCursor(new Cursor(Cursor.HAND_CURSOR));
	 	//SelectMasterRow();
		vtable.setOpaque(false);
		sjsp.setOpaque(false);
 		vmastersearchString = "%%";
 		return vtable ;
		
 	}

	
	
	
	
	public void SelectMasterRow() {
		vtable.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		vtable.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = vtable.getSelectedRow();
				String value = (String) vtable.getValueAt(row, 0);
				try {
					code.setText(vtable.getValueAt(row, 1).toString());
					name.setText(vtable.getValueAt(row, 2).toString());
					new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				new General().msgDispose();
			}
		});
		vtable.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, vtable, "Select Data", 700, 500);
		vtable.requestFocus(true);
		vtable.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	public void checkParameters(String vcomp, String vstore, JTextField total, JTextField storeparam)
			throws ClassNotFoundException, SQLException {

		String SQL = "Call  Conf_getallParamCount()";
		String SQL1 = " call   Conf_getStoreParamCount(" + vcomp + "  , " + vstore + ")";
		rs = this.getSPResult(SQL);
		rs1 = this.getSPResult(SQL1);
		if (rs.next()) {
			rs.first();
			total.setText(rs.getString(1));
		}
		if (rs1.next()) {
			rs.first();
			storeparam.setText(rs1.getString(1));
		}
		rs.close();
		this.closeconn();
	}

	public void setstore(JTextField Storecode, JTextField storename, String vcomp1) throws Throwable {
		code = Storecode;
		name = storename;
		vcomp = vcomp1;
		sjsp.setBounds(0, 0, 1184, 425);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		vuser = new gnConfig().getUserCode().toUpperCase();
		String[] cl = { "Type", "Store code", "Store Name", "Verticle", "Segment" };
		vuser = new gnConfig().getUserCode();
		sql = "Call  Tb_getAllsite(" + vcomp + ")";
		type = "Store";
		showTable_comp(sql, type, cl);

	}

	public void setcompanyAllData(JTextField companycode, JTextField companyname, JTextField segmentcode,
			JTextField segmentname, JTextField verticlecode, JTextField verticlename, JTextField hno, JTextField hname)
			throws Throwable {

		new General().msg("Reached in gnadmin");
		code = companycode;
		name = companyname;
		vsegmentcode = segmentcode;
		vsegmentname = segmentname;
		vverticle = verticlecode;
		vverticlename = verticlename;
		vhierarchyno = hno;
		vhierarchyname = hname;

		sjsp.setBounds(0, 0, 1184, 425);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		vuser = new gnConfig().getUserCode().toUpperCase();
		String[] cl = { "Type", "Company_code", "Company_Name", " VATNO", "Phone", "Segment", "Segment_Name",
				"Verticle", "Verticle_Name", "Hier.No ", "Hier.Name" };
		sql = "Call  Tb_getAllCompnayData() ";
		type = "CompanyAll";
		showTable_comp(sql, type, cl);
	}

	public void setcompany(JTextField companycode, JTextField companyname) throws Throwable {
		code = companycode;
		name = companyname;
		sjsp.setBounds(0, 0, 1184, 425);
		sjsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sjsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		vuser = new gnConfig().getUserCode().toUpperCase();
		String[] cl = { "Type", "Company_code", "Company_Name", " GST NO", "Phone", "Segment", "Segment_Name",
				"Verticle", "Verticle_Name", "Hier.No ", "Hier.Name" };
		sql = "Call  Tb_getAllCompnayData() ";
		type = "Company";
		showTable_comp(sql, type, cl);
	}

	public void showTable_comp(String sql, String type, String[] cl) throws Throwable {
		new gnTable().RemoveTableRows(vmodel);
		rs = this.getSPResult(sql);
		vmodel.setColumnIdentifiers(cl);
		switch (type) {
		case "OnlyVerticle":
			vtable = new gnTableModel().Tablemodel(vtable, vmodel, sql, cl, 6, "N", "Y", type);
			new gnTable().setTablewidth(vtable, 1, 100);
			new gnTable().setTablewidth(vtable, 2, 50);
			break;

		case "Hierarchy":
			new gnTable().RemoveTableRows(vmodel);
 			vtable = new gnTableModel().Tablemodel(vtable, vmodel, sql, cl, 6, "N", "Y", type);
			new gnTable().setTablewidth(vtable, 1, 100);
			new gnTable().setTablewidth(vtable, 2, 50);
			break;
		case "Company":
			new gnTable().RemoveTableRows(vmodel);
			vtable = new gnTableModel().Tablemodel(vtable, vmodel, sql, cl, 10, "N", "Y", type);
			new gnTable().setTablewidth(vtable, 1, 100);
			new gnTable().setTablewidth(vtable, 2, 300);
			break;
		case "CompanyAll":
			new gnTable().RemoveTableRows(vmodel);
			vtable = new gnTableModel().Tablemodel(vtable, vmodel, sql, cl, 10, "N", "Y", type);
			new gnTable().setTablewidth(vtable, 1, 100);
			new gnTable().setTablewidth(vtable, 2, 300);
			break;

		case "Store":
			vtable = new gnTableModel().Tablemodel(vtable, vmodel, sql, cl, 4, "N", "Y", type);
			new gnTable().setTablewidth(vtable, 1, 100);
			new gnTable().setTablewidth(vtable, 2, 300);
			break;

		case "Verticle":
			vtable = new gnTableModel().Tablemodel(vtable, vmodel, sql, cl, 6, "N", "Y", type);
			new gnTable().setTablewidth(vtable, 4, 350);
			new gnTable().setTablewidth(vtable, 6, 300);
			break;

		case "Verticle-Hie":
			vtable = new gnTableModel().Tablemodel(vtable, vmodel, sql, cl, 6, "N", "Y", type);
			new gnTable().setTablewidth(vtable, 4, 350);
			new gnTable().setTablewidth(vtable, 6, 300);
			break;
		}

		vtable.setEnabled(true);
		vtable.setCellSelectionEnabled(false);
		vtable.setRowSelectionAllowed(true);
		vtable.setGridColor(Color.gray);
		vtable.setBackground(Color.WHITE);
		vtable.setForeground(Color.black);
		vtable.setSelectionBackground(Color.CYAN);
		vtable.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
		JViewport prt1 = new JViewport();
		prt1.add(vtable, cl);
		prt1.setVisible(true);
		sjsp.setViewport(prt1);
  		String vmsg = "Select Data For " + type;

		sjsp.setOpaque(false);
		vtable.setOpaque(false);

		selectRow();
		new General().msgsearch(sjsp, vtable, vmsg, 700, 300);

	}// End Show Table

	public void showParent(String vsearchname, JTextField vcode, JTextField vname) throws Throwable {
		code = vcode;
		name = vname;
		vcomp = new gnConfig().getCompanyCode();
		String SQL = "call Bulk_GetAllBulkCode('" + vsearchname + "' , " + vcomp + "  )";
		String Col[] = { "Type", "Article_code", "Name", "Uom", "Trading_article", "cost", "SalesPrice",
				"Article_type", };
		new gnTable().RemoveTableRows(model);
		model.setColumnIdentifiers(Col);
		String vtype = "Parent code";
		table = new gnTableModel().Tablemodel(table, model, SQL, Col, 7, "N", "Y", vtype);
		if (table.getRowCount() > 0) {
			new gnTable().setTablewidth(table, 2, 250);
			new gnTable().setTablewidth(table, 4, 250);
			new gnTable().setTablewidth(table, 6, 250);
		}
		SelectParenetMasterRow();
	}

	public void SelectParenetMasterRow() {
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String value = (String) table.getValueAt(row, 0);
				try {
					code.setText(table.getValueAt(row, 1).toString());
					name.setText(table.getValueAt(row, 2).toString());
					new General().msgDispose();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
				new General().msgDispose();
			}
		});
		table.setSurrendersFocusOnKeystroke(true);
		new General().msgsearch(sjsp, table, "Select Parant Code ", 800, 600);
		table.requestFocus(true);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));

	}

	public static void main(String[] args) {
	}
}

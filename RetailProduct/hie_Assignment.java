package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

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
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;

public class hie_Assignment extends getResultSet {
	private JButton btnLevel1;
	private JButton btnLevel2;
	JPanel panel_6;
	private JButton btnLevel3;
	private JButton btnLevel4;
	String vlevel = "";
	String vtype;
	private JButton btnMessage;
	JButton btnCreate;

	String vparent1 = "0";
	String vparent2 = "0";
	String vparent3 = "0";
	String vparent4 = "0";

	JFrame hie_Assignment_frame;
	private JPanel panel_2;
	private JTextField segmentcode;
	private JTextField segmentname;
	private JTextField verticlecode;
	private JTextField verticlename;
	private JTextField hierarchyno;
	private JTextField nodetype;
	private JLabel lblHierarchyCode;
	private JTextField code;
	private JTextField name;
	private JPanel panel_3;
	private JButton btnSave;
	private JButton btnCancel;
	private JTextField SearchText;
	private JTextField Level;
	JComboBox groupcombo;
	JComboBox subgroupcombo;
	JComboBox categorycombo;
	JComboBox subcatcombo;

	///
	private String Rvsegmentcode;
	private String Rverticlecode;
	private String Rhno;

	///

	private JTable table = new JTable() {
		public Component prepareRenderer(TableCellRenderer rendererr, int roww, int column) {
			Component componentt = super.prepareRenderer(rendererr, roww, column);

			if (column == 0 || column == 1 || column == 2 || column == 3 || column == 4 || column == 6 || column == 7) {
				componentt.setForeground(Color.gray);
				componentt.setCursor(getCursor());
			}
			if (column == 6 || column == 7) // || column ==3 || column ==5 ||
											// column ==8 || column ==9 ||
											// column ==14 )
			{
				// componentt.setBackground(Color.white);
				componentt.setBackground(Color.WHITE);
				componentt.setForeground(Color.BLUE);
				componentt.setFont(new General().getFont(11));
				componentt.setCursor(getCursor());

			}
			return componentt;
		}
	};

	private DefaultTableModel model = new DefaultTableModel();
	private JScrollPane jsp;
	private JScrollPane jsp1;

	private JViewport prt;
	private JPanel panel_4;
	private JTextField hname;
	private JLabel mylabel;
	private JTextField mycode;
	private JTextField myname;

	///

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hie_Assignment window = new hie_Assignment();
					window.hie_Assignment_frame.setVisible(true);
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
	public hie_Assignment() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		hie_Assignment_frame = new JFrame();
		hie_Assignment_frame.setTitle("Business Application");
		hie_Assignment_frame.setAlwaysOnTop(true);
		hie_Assignment_frame.setBounds(125, 50, 1200, 650);
		hie_Assignment_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		hie_Assignment_frame.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1200, 650);
		hie_Assignment_frame.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Hierarchy Assignment Module");
		internalFrame.getContentPane().setBackground(Color.CYAN);
		internalFrame.setBounds(0, 0, 1200, 650);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null),
						new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null)),
				"Click On Button ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 183, 196);
		internalFrame.getContentPane().add(panel);
		panel.setLayout(null);

		btnLevel1 = new JButton("Create Group");
		btnLevel1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnLevel1.setForeground(Color.BLACK);
		btnLevel1.setBounds(12, 37, 159, 25);
		btnLevel1.setBackground(Color.WHITE);
		panel.add(btnLevel1);

		btnLevel2 = new JButton("Create SubGroup");
		btnLevel2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnLevel2.setForeground(Color.BLACK);
		btnLevel2.setBounds(12, 62, 159, 25);
		btnLevel2.setBackground(Color.WHITE);
		panel.add(btnLevel2);

		btnLevel3 = new JButton("Create Category");
		btnLevel3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnLevel3.setForeground(Color.BLACK);
		btnLevel3.setBounds(12, 89, 159, 25);
		btnLevel3.setBackground(Color.WHITE);
		panel.add(btnLevel3);

		btnLevel4 = new JButton("Create SubCategory");
		btnLevel4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 13));
		btnLevel4.setForeground(Color.BLACK);
		btnLevel4.setBounds(12, 115, 159, 25);
		btnLevel4.setBackground(Color.WHITE);
		panel.add(btnLevel4);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.YELLOW, null, null, null));
		panel_1.setBounds(185, 0, 987, 196);
		internalFrame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnMessage = new JButton("Hierarchy Assignment  ");
		btnMessage.setEnabled(false);
		btnMessage.setForeground(Color.BLACK);
		btnMessage.setBackground(Color.CYAN);
		btnMessage.setBounds(0, 0, 987, 25);
		panel_1.add(btnMessage);

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.PINK, 3, true));
		panel_2.setBounds(0, 26, 430, 76);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblSegment = new JLabel("Segment ");
		lblSegment.setBounds(59, 6, 56, 16);
		panel_2.add(lblSegment);

		segmentcode = new JTextField();
		segmentcode.setEditable(false);
		segmentcode.setBackground(Color.CYAN);
		segmentcode.setBounds(125, 4, 49, 22);
		panel_2.add(segmentcode);
		segmentcode.setColumns(10);

		segmentname = new JTextField();
		segmentname.setBackground(Color.CYAN);
		segmentname.setBounds(175, 4, 230, 22);
		panel_2.add(segmentname);
		segmentname.setColumns(10);

		JLabel lblVerticle = new JLabel("Verticle");
		lblVerticle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVerticle.setBounds(57, 30, 56, 16);
		panel_2.add(lblVerticle);

		verticlecode = new JTextField();
		verticlecode.setEditable(false);
		verticlecode.setBackground(Color.CYAN);
		verticlecode.setBounds(125, 27, 49, 22);
		panel_2.add(verticlecode);
		verticlecode.setColumns(10);

		verticlename = new JTextField();
		verticlename.setBackground(Color.CYAN);
		verticlename.setBounds(175, 27, 230, 22);
		panel_2.add(verticlename);
		verticlename.setColumns(10);

		JLabel lblHierarchyNo = new JLabel("Hierarchy No");
		lblHierarchyNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHierarchyNo.setBounds(33, 50, 80, 16);
		panel_2.add(lblHierarchyNo);

		hierarchyno = new JTextField();
		hierarchyno.setEditable(false);
		hierarchyno.setBackground(Color.CYAN);
		hierarchyno.setBounds(125, 49, 49, 22);
		panel_2.add(hierarchyno);
		hierarchyno.setColumns(10);

		hname = new JTextField();
		hname.setBackground(Color.CYAN);
		hname.setBounds(175, 50, 230, 22);
		panel_2.add(hname);
		hname.setColumns(10);

		lblHierarchyCode = new JLabel("Code");
		lblHierarchyCode.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHierarchyCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHierarchyCode.setBounds(10, 134, 104, 16);
		panel_1.add(lblHierarchyCode);

		code = new JTextField();
		code.setBounds(126, 131, 47, 25);
		panel_1.add(code);
		code.setColumns(10);

		name = new JTextField();
		name.setToolTipText("Enter Name Here");
		name.setBounds(173, 131, 257, 25);
		panel_1.add(name);
		name.setColumns(10);

		JLabel lblNodeType = new JLabel("Node Type");
		lblNodeType.setBounds(184, 166, 69, 16);
		panel_1.add(lblNodeType);

		nodetype = new JTextField();
		nodetype.setEnabled(false);
		nodetype.setBackground(Color.CYAN);
		nodetype.setBounds(255, 163, 47, 22);
		panel_1.add(nodetype);
		nodetype.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.ORANGE, Color.BLACK));
		panel_5.setBounds(431, 26, 556, 170);
		panel_1.add(panel_5);
		panel_5.setLayout(null);

		JScrollPane jsp2 = new JScrollPane();
		jsp2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp2.setBounds(0, 0, 556, 138);
		panel_5.add(jsp2);

		JLabel lblSearchHierarchyBy = new JLabel("Search by Name");
		lblSearchHierarchyBy.setBounds(0, 143, 102, 16);
		panel_5.add(lblSearchHierarchyBy);

		SearchText = new JTextField();
		SearchText.setBounds(110, 139, 229, 25);
		panel_5.add(SearchText);
		SearchText.setForeground(Color.BLACK);
		SearchText.setFont(new Font("Tahoma", Font.BOLD, 13));
		SearchText.setColumns(10);

		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(459, 139, 97, 25);
		panel_5.add(btnCancel);
		btnCancel.setMnemonic('C');

		JLabel lblHierarchyLevel = new JLabel("Hierarchy Level");
		lblHierarchyLevel.setBounds(35, 166, 89, 16);
		panel_1.add(lblHierarchyLevel);

		Level = new JTextField();
		Level.setEnabled(false);
		Level.setBackground(Color.CYAN);
		Level.setBounds(126, 163, 47, 22);
		panel_1.add(Level);
		Level.setColumns(10);

		btnSave = new JButton("Save");
		btnSave.setBounds(324, 162, 97, 25);
		panel_1.add(btnSave);
		btnSave.setMnemonic('S');

		mylabel = new JLabel("mylabr");
		mylabel.setForeground(new Color(153, 51, 204));
		mylabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		mylabel.setHorizontalAlignment(SwingConstants.RIGHT);
		mylabel.setBounds(10, 105, 104, 16);
		panel_1.add(mylabel);

		mycode = new JTextField();
		mycode.setBackground(new Color(0, 0, 153));
		mycode.setForeground(new Color(0, 255, 51));
		mycode.setBounds(126, 102, 47, 25);
		panel_1.add(mycode);
		mycode.setColumns(10);

		myname = new JTextField();
		myname.setToolTipText("Press Enter To Select ");
		myname.setBackground(new Color(0, 0, 153));
		myname.setForeground(new Color(0, 255, 51));
		myname.setBounds(173, 102, 257, 25);
		panel_1.add(myname);
		myname.setColumns(10);

		panel_3 = new JPanel();
		panel_3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), Color.DARK_GRAY, Color.BLACK,
				new Color(0, 255, 255)));
		panel_3.setBounds(0, 197, 1172, 47);
		internalFrame.getContentPane().add(panel_3);
		panel_3.setLayout(null);

		panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(12, 6, 1160, 41);
		panel_3.add(panel_6);
		panel_6.setLayout(null);

		subcatcombo = new JComboBox();
		subcatcombo.setBounds(728, 13, 233, 34);
		panel_6.add(subcatcombo);
		subcatcombo.setMaximumRowCount(1000);
		subcatcombo.setFont(new Font("Calibri", Font.PLAIN, 13));

		btnCreate = new JButton("Save Hierarchy");
		btnCreate.setBounds(969, 16, 137, 25);
		panel_6.add(btnCreate);

		categorycombo = new JComboBox();
		categorycombo.setBounds(469, 14, 247, 32);
		panel_6.add(categorycombo);
		categorycombo.setMaximumRowCount(1000);
		categorycombo.setFont(new Font("Calibri", Font.PLAIN, 13));

		JLabel lblNewLabel_3 = new JLabel("SubCategory");
		lblNewLabel_3.setBounds(728, 0, 107, 16);
		panel_6.add(lblNewLabel_3);

		JLabel lblNewLabel_2 = new JLabel("Category");
		lblNewLabel_2.setBounds(469, 0, 56, 16);
		panel_6.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("SubGroup");
		lblNewLabel_1.setBounds(225, -2, 56, 16);
		panel_6.add(lblNewLabel_1);

		subgroupcombo = new JComboBox();
		subgroupcombo.setBounds(224, 15, 233, 32);
		panel_6.add(subgroupcombo);
		subgroupcombo.setMaximumRowCount(1000);
		subgroupcombo.setFont(new Font("Calibri", Font.PLAIN, 13));

		JLabel lblNewLabel = new JLabel("Group");
		lblNewLabel.setBounds(12, -6, 56, 16);
		panel_6.add(lblNewLabel);

		groupcombo = new JComboBox();
		groupcombo.setBounds(12, 9, 212, 32);
		panel_6.add(groupcombo);
		groupcombo.setMaximumRowCount(1000);
		groupcombo.setFont(new Font("Calibri", Font.PLAIN, 13));

		panel_4 = new JPanel();
		panel_4.setBounds(0, 243, 1172, 318);
		internalFrame.getContentPane().add(panel_4);
		panel_4.setLayout(null);

		jsp = new JScrollPane();
		jsp.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, Color.YELLOW, Color.BLUE, null));
		jsp.setBounds(0, 13, 1172, 311);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_4.add(jsp);
		internalFrame.setVisible(true);

		ActionListener btnls = new btnLsnr();
		btnLevel1.addActionListener(btnls);
		btnLevel2.addActionListener(btnls);
		btnLevel3.addActionListener(btnls);
		btnLevel4.addActionListener(btnls);
		ActionListener btnsave = new btnSaveLsnr();
		btnSave.addActionListener(btnsave);
		ActionListener mynamel = new mynamelLsnr();
		myname.addActionListener(mynamel);
		btnCreate.addActionListener(btnsave);
		btnCancel.addActionListener(btnls);

		decorate();
	}

	private void showParentHierarchy() throws Throwable {
		String vtype = "";
		String search = "%%";
		// new General().msg("Clicked Level is "+" "+vlevel) ;
		switch (vlevel) {
		case "2":
			// vtype = "Group" ;
			new gnHierarchy().getlevel1(search);
			mycode.setText(new gnHierarchy().code);
			myname.setText(new gnHierarchy().name);
			vparent1 = new gnHierarchy().vlevel1;
			new gnHierarchy().name = "";
			new gnHierarchy().code = "";
			new gnHierarchy().vlevel1 = "";
			new gnHierarchy().vlevel2 = "";
			new gnHierarchy().vlevel3 = "";
			new gnHierarchy().vlevel4 = "";
			break;

		case "3":
			// vtype = "SubGroup" ;
			new gnHierarchy().getlevel2(search);
			mycode.setText(new gnHierarchy().code);
			myname.setText(new gnHierarchy().name);
			vparent1 = new gnHierarchy().vlevel1;
			vparent2 = new gnHierarchy().vlevel2;
			new gnHierarchy().name = "";
			new gnHierarchy().code = "";
			new gnHierarchy().vlevel1 = "";
			new gnHierarchy().vlevel2 = "";
			new gnHierarchy().vlevel3 = "";
			new gnHierarchy().vlevel4 = "";
			break;

		case "4":
			// vtype = "Category" ;
			// new gnHierarchy().getHierarchyInfo(vtype, search);
			new gnHierarchy().getlevel3(search);
			mycode.setText(new gnHierarchy().code);
			myname.setText(new gnHierarchy().name);
			vparent1 = new gnHierarchy().vlevel1;
			vparent2 = new gnHierarchy().vlevel2;
			vparent3 = new gnHierarchy().vlevel3;
			new gnHierarchy().name = "";
			new gnHierarchy().code = "";
			new gnHierarchy().vlevel1 = "";
			new gnHierarchy().vlevel2 = "";
			new gnHierarchy().vlevel3 = "";
			new gnHierarchy().vlevel4 = "";
			break;
		}
	}

	class mynamelLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				showParentHierarchy();
				name.grabFocus();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private void fillcombo() throws Throwable {

		AutoCompleteDecorator.decorate(groupcombo);
		groupcombo.setSelectedItem("");

		AutoCompleteDecorator.decorate(subgroupcombo);
		subgroupcombo.setSelectedItem("");

		AutoCompleteDecorator.decorate(categorycombo);
		categorycombo.setSelectedItem("");

		AutoCompleteDecorator.decorate(subcatcombo);
		subcatcombo.setSelectedItem("");

		String vtype = "Group";
		new gnHierarchy().fillComboFor(vtype, groupcombo);

		vtype = "SubGroup";
		new gnHierarchy().fillComboFor(vtype, subgroupcombo);

		vtype = "Category";
		new gnHierarchy().fillComboFor(vtype, categorycombo);

		vtype = "SubCategory";
		new gnHierarchy().fillComboFor(vtype, subcatcombo);

	}

	private void decorate() throws Throwable {

		panel_6.setVisible(false);
		new gnDecorate().decorateBtn(btnSave, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnLevel1, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnLevel2, Color.BLUE, Color.WHITE);
		new gnDecorate().decorateBtn(btnLevel3, Color.MAGENTA, Color.WHITE);
		new gnDecorate().decorateBtn(btnLevel4, Color.BLUE, Color.WHITE);
		new gnDecorate().decorateBtn(btnCreate, Color.GREEN, Color.WHITE);
		new gnDecorate().decorateBtn(btnCancel, Color.red, Color.WHITE);

		segmentcode.setText(new gnHierarchy().getSegmentCode());
		segmentname.setText("Retail");
		hierarchyno.setText(new gnHierarchy().getHierarchyNo());
		hname.setText(new gnHierarchy().getHierarchyName());
		verticlecode.setText(new gnPublicVariable().verticlecode);
		verticlename.setText(new gnPublicVariable().verticlename);
		code.setText("");
		name.setText("");
		fillcombo();
	}

	private void saveHierarchy() throws Throwable {
		String vtype = "Groupcode";
		String vname = groupcombo.getSelectedItem().toString().trim();
		String vgroupcode = new gnHierarchy().getCodeofgivenName(vtype, vname);
		// new General().msg(" Group is :" +vgroupcode);
		vtype = "SubGroupcode";
		vname = subgroupcombo.getSelectedItem().toString().trim();
		String vsubgroupcode = new gnHierarchy().getCodeofgivenName(vtype, vname);
		// new General().msg("Subgroup is :" +vsubgroupcode);

		vtype = "catcode";
		vname = categorycombo.getSelectedItem().toString().trim();
		String vcatcode = new gnHierarchy().getCodeofgivenName(vtype, vname);
		// new General().msg("cat code is :" +vcatcode);

		vtype = "SubCatcode";
		vname = subcatcombo.getSelectedItem().toString().trim();
		String vSubcatcode = new gnHierarchy().getCodeofgivenName(vtype, vname);
		// new General().msg("Subcat code is :" +vSubcatcode);

		String vverticle = verticlecode.getText();
		String vhno = hierarchyno.getText();
		String vsegment = segmentcode.getText();

		String SQL = "update msArticle_subcategory set parent_1= " + vgroupcode + " , parent_2 = " + vsubgroupcode
				+ " ," + " parent_3 = " + vcatcode + " where code = " + vSubcatcode + " and  hierarchyno = " + vhno
				+ " and verticle = " + vverticle + " and segment= " + vsegment + "";
		this.getResult(SQL);
		new General().msg("Data Updated Sucessfully... ");

	}

	class btnSaveLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			String value = e.getActionCommand();

			if (value == "Save Hierarchy") {
				try {
					saveHierarchy();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			if (value == "Save") {
				String status = null;
				try {
					status = validate();
				} catch (Throwable e2) {
					e2.printStackTrace();
				}
				if (status == "Sucess") {
					try {
						saveAction();
					} catch (Exception e1) {
						e1.printStackTrace();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
			}

		}
	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			String vtype = "";
			String vtype1 = "";

			if (value == "Cancel") {
				hie_Assignment_frame.dispose();
			}

			if (value == "Create Group") {
				vlevel = "1";
				Level.setText("1");
				nodetype.setText("Parent");
				code.setText("");
				name.setText("");
				name.grabFocus();
				vtype = "Group";
				vtype1 = "Level1";
				mylabel.setText("");
				mycode.setVisible(false);
				myname.setVisible(false);
			}

			if (value == "Create SubGroup") {
				myname.grabFocus();
				mylabel.setText("Select Group");
				lblHierarchyCode.setText("Sub Group");
				mycode.setVisible(true);
				myname.setVisible(true);
				vlevel = "2";
				Level.setText("2");
				nodetype.setText("Child");
				code.setText("");
				name.setText("");
				// name.grabFocus();
				vtype = "SubGroup";
				vtype1 = "Level2";
			}

			if (value == "Create Category") {
				myname.grabFocus();
				mylabel.setText("Select SubGroup");
				lblHierarchyCode.setText("Category");
				mycode.setVisible(true);
				myname.setVisible(true);
				vlevel = "3";
				Level.setText("3");
				nodetype.setText("Child");
				code.setText("");
				name.setText("");
				// name.grabFocus();
				vtype = "Category";
				vtype1 = "Level3";

			}

			if (value == "Create SubCategory") {
				myname.grabFocus();
				mylabel.setText("Select Category");
				lblHierarchyCode.setText("SubCategory");
				mycode.setVisible(true);
				myname.setVisible(true);
				vlevel = "4";
				Level.setText("4");
				nodetype.setText("Last");
				code.setText("");
				name.setText("");
				// name.grabFocus();
				vtype = "SubCategory";
				vtype1 = "Level4";
			}
			try {
				// showExistingData(vtype) ;
				showExistingData1(vtype1);
			} catch (Throwable e1) {
				e1.printStackTrace();
			}

		}
	}

	private String validate() throws Throwable {
		String status = "Sucess";

		getSeqno();

		if ((vlevel == "2" || vlevel == "3" || vlevel == "3") && mycode.getText().length() == 0) {
			status = "Fail";
			new General().msg("Please Select  Parenet Code ");
			myname.grabFocus();

		}

		if (segmentcode.getText().length() == 0) {
			status = "Fail";
			new General().msg("Segment  is not Set Please Attach Segment To  Your Branch");
		}

		if (hierarchyno.getText().length() == 0) {
			status = "Fail";
			new General().msg("Hierarchy No is not Set Please Attach Hiearchy To  Your Branch");
		}

		if (verticlecode.getText().length() == 0) {
			status = "Fail";
			new General().msg("Verticle No is not Set Please Attach Verticle To  Your Branch");
		}

		if (code.getText().length() == 0) {
			status = "Fail";
			new General().msg("Please Enter Name for " + vtype);
			name.grabFocus();
		}

		return status;
	}

	private void saveAction() throws Throwable {
		// new General().msg("Save Action Starts ....") ;
		insertHierarchy();
	}

	private void showExistingData1(String vtype) throws Throwable {
		String vsearchname = "%%";
		switch (vtype) {
		case "Level1":
			table = new gnHierarchy().getlevel1here(vsearchname);
			break;
		case "Level2":
			table = new gnHierarchy().getlevel2here(vsearchname);
			break;
		case "Level3":
			table = new gnHierarchy().getlevel3here(vsearchname);
			break;
		case "Level4":
			table = new gnHierarchy().showArticleHierarchyhere(vsearchname);
			break;
		}
		JViewport prt = new JViewport();
		prt.add(table);
		prt.setVisible(true);
		prt.setBackground(Color.WHITE);
		jsp.setViewport(prt);
		new gnTable().setTableBasics(table);

	}

	private void showExistingData(String vtype) throws Throwable {
		String vsearchname = "%%";
		table = new gnHierarchy().getHierarchyInfoinmytable(vtype, vsearchname);
		JViewport prt = new JViewport();
		prt.add(table);
		prt.setVisible(true);
		prt.setBackground(Color.WHITE);
		jsp.setViewport(prt);

	}

	private void getSeqno() throws Throwable {
		String vtype = "MS";
		String vtran = "906";
		switch (vlevel) {
		case "1":
			vtran = "907";
			code.setText(new gnSeq().getSeqno(vtran, vtype));
			break;
		case "2":
			vtran = "908";
			code.setText(new gnSeq().getSeqno(vtran, vtype));
			break;
		case "3":
			vtran = "909";
			code.setText(new gnSeq().getSeqno(vtran, vtype));
			break;
		case "4":
			vtran = "910";
			code.setText(new gnSeq().getSeqno(vtran, vtype));
			break;
		}

	}

	private void updateSeqno() throws Throwable {
		String vtype = "MS";
		String vtran = "906";
		switch (vlevel) {
		case "1":
			vtran = "907";
			new gnSeq().updateSeqno(vtran, vtype);
			break;
		case "2":
			vtran = "908";
			new gnSeq().updateSeqno(vtran, vtype);
			break;
		case "3":
			vtran = "909";
			new gnSeq().updateSeqno(vtran, vtype);
			break;
		case "4":
			vtran = "910";
			new gnSeq().updateSeqno(vtran, vtype);
			break;
		}

	}

	
	
	public String insertHierarchy() throws Throwable {
		// new General().msg("Stock transfer deail data insertin progress");

		String vtablename = "";
		switch (vlevel) {
		case "1":
			vtablename = "msArticle_group";
			break;
		case "2":
			vtablename = "msArticle_Subgroup";
			break;
		case "3":
			vtablename = "msArticle_Category";
			break;
		case "4":
			vtablename = "msArticle_SubCategory";
			break;
		}
		prst = null;
		final int batchSize = 10;
		int TotalRecordinsert = 0;
		String status = "Fail";
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String hie = "Insert into     " + vtablename + "(Company_code , "
				+ "Segment, Verticle , hierarchyNo, level, code , "
				+ "name,  nodeType ,levelMappedName, Parent_1, Parent_2, Parent_3, Parent_4) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,? )";
		// new General().msg(hie);
		try {
			prst = con.prepareStatement(hie);
			prst.setString(1, "0");
			prst.setString(2, segmentcode.getText());
			prst.setString(3, verticlecode.getText());
			prst.setString(4, hierarchyno.getText());
			prst.setString(5, vlevel);
			prst.setString(6, code.getText());
			prst.setString(7, name.getText());
			prst.setString(8, nodetype.getText());
			prst.setString(9, "0");
			prst.setString(10, vparent1);
			prst.setString(11, vparent2);
			prst.setString(12, vparent3);
			prst.setString(13, "0");
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			status = "Sucess";
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con.commit();
			}
			prst.executeBatch(); // insert remaining records
			con.commit();
			new General().msg("Data Save Sucessfully");
		} catch (SQLException e) {
			new General().msg(e.getMessage() + "<Max Lenght Allow is 30 Chars For Hierarchy Name>");
			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
				code.setText("");
				name.setText("");
				mycode.setText("");
				myname.setText("");
				updateSeqno();
			}
		}
		return status;
	}
}// last

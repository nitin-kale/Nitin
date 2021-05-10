package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Window.Type;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class HierarchyTree extends getResultSet {

	JFrame HierarchyTreeFrame;
	private DefaultMutableTreeNode segment;
	private DefaultMutableTreeNode verticle;
	private String vhcode2;
	private String vhcode3;
	private int no = 0;
	private int no1 = 0;
	private int no2 = 0;
	private int no3 = 0;
	private int no4 = 0;
	private int no5 = 0;

	private String vhcode1;
	private String vhcode4;
	private String vhcode;
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name;
	private DefaultMutableTreeNode Level4;
	private DefaultMutableTreeNode Level3;
	private DefaultMutableTreeNode Level2;
	private DefaultMutableTreeNode Level1;
	private DefaultMutableTreeNode Level5;

	JTree tree = new JTree();

	private String vsegment = "1";
	private String vverticle = "1";
	private String hno = "1";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HierarchyTree window = new HierarchyTree();
					window.HierarchyTreeFrame.setVisible(true);
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
	public HierarchyTree() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		HierarchyTreeFrame = new JFrame();
		HierarchyTreeFrame.setAlwaysOnTop(true);
		HierarchyTreeFrame.setType(Type.UTILITY);
		HierarchyTreeFrame.setResizable(false);
		HierarchyTreeFrame.setTitle("Hierarchy Tree  ");
		HierarchyTreeFrame.setBounds(350, 110, 450, 570);
		HierarchyTreeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		HierarchyTreeFrame.getContentPane().setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 450, 570);
		HierarchyTreeFrame.getContentPane().add(desktopPane);
		desktopPane.setLayout(null);

		JInternalFrame internalFrame = new JInternalFrame("Hierarchy  View");
		internalFrame.setBounds(0, 0, 450, 570);
		desktopPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);

		// createRoot() ;
		createMainRoot();

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 570);
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		tree.setBackground(Color.CYAN);
		JScrollPane jsp = new JScrollPane(tree);
		jsp.setBounds(0, 0, 438, 500);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBackground(Color.DARK_GRAY);
		panel.add(jsp);

		internalFrame.getContentPane().add(panel);
		internalFrame.setVisible(true);

		tree.addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				System.out.println(selectedNode);
			}
		});
		// tree.setCellRenderer(new MyTreeCellRenderer());
	}

	public void createMainRoot() throws Throwable {
		segment = new DefaultMutableTreeNode("Retail");
		verticle = new DefaultMutableTreeNode("General Retail");
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = "call   tree_getTreeData1(" + vcomp + ")";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			name = rs.getString(1);
			Level1 = new DefaultMutableTreeNode(name);
			verticle.insert(Level1, no);
			segment.insert(verticle, 0);
			no = no + 1;
			tree = new JTree(segment);
			tree.setBackground(Color.WHITE);
		}
		createRoot();

	}

	public void createRoot() throws Throwable {
		// int i =0;
		int row = verticle.getChildCount();
		for (int i = 0; i < row; i++) {
			name1 = verticle.getChildAt(i).toString();
			createLeve2(name1);
		}
	}

	public void createLeve2(String vlevel1) throws Throwable {

		String vcomp = new gnConfig().getCompanyCode();
		String SQL1 = "call   tree_getTreeData2(" + vcomp + " , '" + vlevel1 + "')";
		rs1 = this.getSPResult(SQL1);
		while (rs1.next()) {

			String name = (rs1.getString(1));
			if (name1 == vlevel1) {
				Level2 = new DefaultMutableTreeNode(name);
				Level1.add(Level2);
			}
			createLeve3(name);
		}
		return;
	}

	public void createLeve3(String vlevel1) throws Throwable {
		// new General().msg("Level3 " +" "+vlevel1);

		String vcomp = new gnConfig().getCompanyCode();
		String SQL1 = "call   tree_getTreeData3(" + vcomp + " , '" + vlevel1 + "')";
		rs2 = this.getSPResult(SQL1);
		while (rs2.next()) {
			String name = (rs2.getString(1));
			// new General().msg(name);
			Level3 = new DefaultMutableTreeNode(name);
			Level2.add(Level3);
			createLeve4(name);
		}
		tree = new JTree(segment);
		tree.setBackground(Color.WHITE);
		return;
	}

	public void createLeve4(String vlevel1) throws Throwable {
		// new General().msg("Level4" +" "+vlevel1);
		String vcomp = new gnConfig().getCompanyCode();
		String SQL1 = "call   tree_getTreeData4(" + vcomp + " , '" + vlevel1 + "')";
		rs3 = this.getSPResult(SQL1);
		while (rs3.next()) {
			String name = (rs3.getString(1));
			Level4 = new DefaultMutableTreeNode(name);
			Level3.add(Level4);
		}
		return;
	}

	public class MyTreeCellRenderer extends DefaultTreeCellRenderer {

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean exp, boolean leaf,
				int row, boolean hasFocus) {
			super.getTreeCellRendererComponent(tree, value, sel, exp, leaf, row, hasFocus);

			String node = (String) ((DefaultMutableTreeNode) value).getUserObject();

			if (leaf && node.endsWith("xxx")) {
				setForeground(new Color(130, 57, 115));
				setBackground(Color.BLUE);
			}

			return this;
		}
	}
}// last

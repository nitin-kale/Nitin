package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JTree;

import com.itextpdf.text.Font;
import com.sun.xml.internal.ws.api.Component;

import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

public class helpModule {

	JFrame Pdfframe;
	JSplitPane split;
	JScrollPane jsp;
	private JPanel panel;
	private JTree tree;
	SwingController controller = new SwingController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					helpModule window = new helpModule();
					window.Pdfframe.setVisible(true);
				} catch (Throwable e) {
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
	public helpModule() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		Pdfframe = new JFrame();
		Pdfframe.getContentPane().setBackground(Color.WHITE);
		Pdfframe.getContentPane().setLayout(null);

		split = new JSplitPane();
		split.setBounds(0, 0, 1332, 705);
		split.setBackground(Color.WHITE);
		split.setDividerLocation(350);
		Pdfframe.getContentPane().add(split);

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Meretoo Product Help");

		// create the child nodes
		DefaultMutableTreeNode master = new DefaultMutableTreeNode("Master Data");
		master.add(new DefaultMutableTreeNode("Overview Master Data"));
		master.add(new DefaultMutableTreeNode("Company Master"));
		master.add(new DefaultMutableTreeNode("Site Master"));
		master.add(new DefaultMutableTreeNode("Articlce Master"));
		master.add(new DefaultMutableTreeNode("Articlce Hierarchy"));
		master.add(new DefaultMutableTreeNode("Articlce Attributes"));
		master.add(new DefaultMutableTreeNode("User Master"));
		master.add(new DefaultMutableTreeNode("State & City Master"));
		master.add(new DefaultMutableTreeNode("Bank Master"));
		master.add(new DefaultMutableTreeNode("Supplier & Customer Master"));
		master.add(new DefaultMutableTreeNode("Other Masters"));

		DefaultMutableTreeNode purchase = new DefaultMutableTreeNode("Purchase Process");
		purchase.add(new DefaultMutableTreeNode("Overview Purchase Order Management"));
		purchase.add(new DefaultMutableTreeNode("Supplier Management"));
		purchase.add(new DefaultMutableTreeNode("Purchase Without PO"));
		purchase.add(new DefaultMutableTreeNode("Purchase Order"));
		purchase.add(new DefaultMutableTreeNode("Purchase With PO"));

		DefaultMutableTreeNode sales = new DefaultMutableTreeNode("Sales Process");
		sales.add(new DefaultMutableTreeNode("Overview Sales Management"));
		sales.add(new DefaultMutableTreeNode("POS Sales"));
		sales.add(new DefaultMutableTreeNode("Credit Sales"));
		sales.add(new DefaultMutableTreeNode("Customer Price Managment"));

		DefaultMutableTreeNode purchaseRet = new DefaultMutableTreeNode("Purcase Return");
		purchaseRet.add(new DefaultMutableTreeNode("Overview Purchase Return"));
		purchaseRet.add(new DefaultMutableTreeNode("Purchase Return"));

		DefaultMutableTreeNode salesRet = new DefaultMutableTreeNode("Sales Return");
		salesRet.add(new DefaultMutableTreeNode("Overview Sales Return"));
		salesRet.add(new DefaultMutableTreeNode("Sales Return"));

		DefaultMutableTreeNode GST = new DefaultMutableTreeNode("GST Data Management");
		GST.add(new DefaultMutableTreeNode("Overview GST Process"));
		GST.add(new DefaultMutableTreeNode("GSTR-1 Overview"));
		GST.add(new DefaultMutableTreeNode("GSTR-2 Overview"));
		GST.add(new DefaultMutableTreeNode("GSTR-4 Overview"));
		GST.add(new DefaultMutableTreeNode("GST Schedule"));
		GST.add(new DefaultMutableTreeNode("HSN Code List"));

		root.add(master);
		root.add(purchase);
		root.add(sales);
		root.add(purchaseRet);
		root.add(salesRet);
		root.add(GST);

		JLabel selectedLabel = new JLabel();
		tree = new JTree(root);
		tree.setCellRenderer(new meretooTreeCellRenderer());
		jsp = new JScrollPane(tree);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		split.setLeftComponent(jsp);
		// jsp.setColumnHeaderView(tree);

		TreeSelectionListener nktree = new treeListener();
		tree.addTreeSelectionListener(nktree);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		split.setRightComponent(panel);
		Pdfframe.setAlwaysOnTop(true);
		Pdfframe.setBounds(1, 0, 1350, 750);
		decorate();
	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(Pdfframe);

	}

	class meretooTreeCellRenderer extends DefaultTreeCellRenderer {

		@Override
		public java.awt.Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean exp,
				boolean leaf, int row, boolean hasFocus) {
			super.getTreeCellRendererComponent(tree, value, sel, exp, leaf, row, hasFocus);
			String node = (String) ((DefaultMutableTreeNode) value).getUserObject();
			setForeground(new Color(173, 0, 115));
			setBackgroundSelectionColor(Color.yellow);
			return this;
		}
	}

	class treeListener implements TreeSelectionListener {
		@Override
		public void valueChanged(TreeSelectionEvent e) {
			DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			String value = selectedNode.getUserObject().toString();
			// new General().msg(e.getPath().toString());
			// new General().msg(value);

			showPDF(value);

		}
	}

	public void showPDF(String value) {
		String filePath = "";
		controller.dispose();
		panel.removeAll();
		SwingViewBuilder factory = new SwingViewBuilder(controller);
		JPanel viewerComponentPanel = factory.buildViewerPanel();
		ComponentKeyBinding.install(controller, viewerComponentPanel);
		switch (value) {
		case "GSTR-4 Overview":
			filePath = "D://java//UserManual//gstr4.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			break;

		case "HSN Code List":
			filePath = "D://java//UserManual//hsncodelist.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			break;

		case "GST Schedule":
			filePath = "D://java//UserManual//gstschedule.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			break;

		case "Overview Master Data":
			filePath = "D:\\java\\UserManual//MasterDataOverview_1.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(0);
			break;

		case "Company Master":
			filePath = "D:\\java\\UserManual\\MasterDataOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(1);
			break;

		case "Site Master":
			filePath = "D:\\java\\UserManual\\MasterDataOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(2);
			break;

		case "Articlce Master":
			filePath = "D:\\java\\UserManual\\MasterDataOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(3);
			break;

		case "Articlce Hierarchy":
			filePath = "D:\\java\\UserManual\\MasterDataOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(4);
			break;

		case "Articlce Attributes":
			filePath = "D:\\java\\UserManual\\MasterDataOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(5);
			break;

		case "User Master":
			filePath = "D:\\java\\UserManual\\MasterDataOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(6);
			break;

		case "State & City Master":
			filePath = "D:\\java\\UserManual\\MasterDataOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(7);
			break;

		case "Bank Master":
			filePath = "D:\\java\\UserManual\\MasterDataOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(8);
			break;

		case "Supplier & Customer Master":
			filePath = "D:\\java\\UserManual\\MasterDataOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(9);
			break;

		case "Other Masters":
			filePath = "D:\\java\\UserManual\\MasterDataOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(10);
			break;

		case "Overview Purchase Order Management":
			filePath = "D:\\java\\UserManual\\PurchaseOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(0);
			break;

		case "Supplier Management":
			filePath = "D:\\java\\UserManual\\PurchaseOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(1);
			break;

		case "Purchase Without PO":
			filePath = "D:\\java\\UserManual\\PurchaseOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(2);
			break;

		case "Purchase Order":
			filePath = "D:\\java\\UserManual\\PurchaseOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(3);
			break;

		case "Purchase With PO":
			filePath = "D:\\java\\UserManual\\PurchaseOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(4);
			break;

		case "Overview Sales Management":
			filePath = "D:\\java\\UserManual\\SalesOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(0);
			break;

		case "POS Sales":
			filePath = "D:\\java\\UserManual\\SalesOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(1);
			break;

		case "Credit Sales":
			filePath = "D:\\java\\UserManual\\SalesOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(3);
			break;

		case "Customer Price Managment":
			filePath = "D:\\java\\UserManual\\SalesOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(5);
			break;

		case "Overview Purchase Return":
			filePath = "D:\\java\\UserManual\\PurchaseReturnOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(0);
			break;

		case "Purchase Return":
			filePath = "D:\\java\\UserManual\\PurchasereturnOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(1);
			break;

		case "Overview Sales Return":
			filePath = "D:\\java\\UserManual\\salesReturnOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(0);
			break;

		case "Sales Return":
			filePath = "D:\\java\\UserManual\\salesreturnOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(1);
			break;

		case "Overview GST Process":
			filePath = "D:\\java\\UserManual\\GstOverview.pdf";
			panel.add(viewerComponentPanel);
			controller.openDocument(filePath);
			controller.showPage(0);
			break;

		}
	}

}// Last

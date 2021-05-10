package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;

final class gnField {

	public JEditorPane jsp = new JEditorPane();

	String InfoText;
	String Heading;

	public void moveLeft(JTable table) {
		// new General().msg("Left Arrow Key Pressed");
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_END, 0), "CalAction");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.requestFocus();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	public void moveRight(JTable table) {
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_HOME, 0), "CalAction");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.requestFocus();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void moveDown(JTable table) {
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "CalAction");
		// imap.put(KeyStroke.getKeyStroke("VK_X"), "CalAction");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.requestFocus();
					table.setGridColor(Color.gray);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void moveUp(JTable table) {
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "CalAction");
		imap.put(KeyStroke.getKeyStroke("VK_X"), "CalAction");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.requestFocus();
					table.setGridColor(Color.gray);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void pressTabKey(JTable table) {
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), "CalAction");
		imap.put(KeyStroke.getKeyStroke("VK_X"), "CalAction");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!table.isFocusOwner()) {
						table.setFocusable(true);
						table.grabFocus();
					}
					table.requestFocus();
					table.setGridColor(Color.gray);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void closeform(JComponent base, JFrame frame) {
		// new General().msg("Comp is "+ fld +" "+"Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) base).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "CalAction");
		imap.put(KeyStroke.getKeyStroke("VK_X"), "CalAction");
		ActionMap amap = ((JComponent) base).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void showConf(Component fld, String FieldName) {
		// new General().msg("Comp is "+ fld +" "+"Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke("F7"), "ConfAction");
		imap.put(KeyStroke.getKeyStroke("VK_C"), "ConlAction");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("ConfAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					showFieldHelp(vfieldName);
				} catch (IOException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void delTableRow(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg("Comp is "+ fld +" "+"Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "CalAction");
		imap.put(KeyStroke.getKeyStroke("VK_X"), "CalAction");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					new POS().removeRow(model, table);
					new POS().table.setEditingRow(1);
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void POSPayment(JTable table, DefaultTableModel model, String FieldName) {
		// new General().msg("Comp is "+ fld +" "+"Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0), "Payment");
		imap.put(KeyStroke.getKeyStroke("VK_F7"), "CalAction");
		ActionMap amap = ((JComponent) table).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					new POS().processPaymentNow();
					// new POS().table.setEditingRow(1);
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void showCalc(Component fld, String FieldName) {
		// new General().msg("Comp is "+ fld +" "+"Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke("F6"), "CalAction");
		imap.put(KeyStroke.getKeyStroke("VK_X"), "CalAction");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("CalAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					showFieldHelp(vfieldName);
				} catch (IOException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void showInventory(Component fld, String FieldName) {
		// new General().msg("Comp is "+ fld +" "+"Value is"+ " "+FieldName);
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke("F8"), "InvAction");
		imap.put(KeyStroke.getKeyStroke("VK_I"), "InvAction");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("InvAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					showFieldHelp(vfieldName);
				} catch (IOException e1) {
					new General().msg(e1.getMessage());
				} catch (Throwable e1) {
					new General().msg(e1.getMessage());
				}
			}
		});
	}

	public void showFieldInfo(Component fld, String FieldName) {

		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_FOCUSED);
		imap.put(KeyStroke.getKeyStroke("SPACE"), "spaceAction");
		imap.put(KeyStroke.getKeyStroke("F1"), "spaceAction");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("spaceAction", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String vfieldName = FieldName.toUpperCase();
				try {
					showFieldHelp(vfieldName);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void showFieldHelp(String vfieldName) throws Throwable {
		// new General().msg(vfieldName);
		switch (vfieldName) {

		case "INV":
			CheckInventory window1 = new CheckInventory();
			window1.frameInventoryApplication.setVisible(true);
			break;

		case "CAL":
			new General().showCalc();
			break;
		case "CONF":
			showconfigurationHelp window = new showconfigurationHelp();
			window.helpConfiguraion.setVisible(true);
			break;
		case "APPROVE":
			Heading = "Document Approval Policy";
			InfoText = "Approval Policy is used to  Approve Document. In case In a Organation If Document is Created By User."
					+ " Who does not Have Permission to Approve Document System will  not    Allow such users to Approve Document."
					+ "                                                                                                                                                                         "
					+ "                                                                                                                                                                         "
					+ "Only MANAGER's Can Authorzed  to Approve Document.                                                                               "
					+ " 1. After Approval of Document  Inventory will get Impacted                                                                               "
					+ " 2.  After Document Approve user can not EDIT  Document.";
			new showHelp().showHelp(InfoText, Heading);
			break;
		case "ITEMNAMESEARCH":
			Heading = "Item Search Field Inforamtion";
			InfoText = "Article/Item Code is Product Code. Purchase and Sales Article code Needs to be created as a Master Data in Advance."
					+ "Once you Enter Code All Related Information will be populated. If you dont Know  code Get Help by Search Name."
					+ "If you Know Starting Chars of Product, Enter In Search Name Field and Press Enter. As a best Practice you Enter some Starting Chars and Press Enter."
					+ "Select  Required Product Code As per your needs and Press  Mouse Enter for Selection of Article/Item."
					+ ""
					+ "Product Code Help window will Provide Information Abount Product Name and Other Important Information Like"
					+ "Purchase cost , MRP & Sales Price.";
			new showHelp().showHelp(InfoText, Heading);
			break;
		case "ARTICLECODE":
			Heading = "Item Search Field Inforamtion";
			InfoText = "Article/Item Code is Product Code. Purchase and Sales Article code Needs to be created as a Master Data in Advance."
					+ "Once you Enter Code All Related Information will be populate. If you dont know Know Get Help by Search Name."
					+ "If you Know Starting Chars of Product, Enter In Search Name Field and Press Enter. As a best Practice you Enter some Starting Chars and Press Enter."
					+ "Select  Required Product Code As per your needs and Press  Mouse Enter for Selection of Article/Item.";
			new showHelp().showHelp(InfoText, Heading);
			break;
		case "PONO":
			Heading = "What Is PO No ? ";
			InfoText = "PO NO is Purchase order Number and This Number will be Generated Automatically By system."
					+ "This Number will be used to Receive Goods From Vendor. Follow PO Process for More Details...";
			new showHelp().showHelp(InfoText, Heading);
			break;
		case "VENDOR":
			Heading = "Who is Vendor  ? ";
			InfoText = "Vendor is Goods Supplier. When You want to buy goods from Suppler you need to create supplier."
					+ "System will Generate Supplier Number and this number can be used for vendor selection either by code or by name";
			new showHelp().showHelp(InfoText, Heading);
			break;
		case "BRAND":
			Heading = "What Is Brand ? ";
			InfoText = "Brand is associated with Product and usefull for higher level reporting purpose. Press Enter to Select Brand Information"
					+ "to complete further activity related to brand. Brand Needs to be created in advance as a master data.";
			new showHelp().showHelp(InfoText, Heading);
			break;
		case "POLIKE":
			Heading = "What Is PO LIKE Option ? ";
			InfoText = "PO Like is Quick Po Making Techinique. You can use a Reference of PO to Create New PO";
			new showHelp().showHelp(InfoText, Heading);
			break;

		case "CGST":
			Heading = "What is CGST ?";
			InfoText = "GST is a consumption based tax i.e. the tax should be received by the state in which the goods or services are consumed"
					+ "and not by the state in which such goods are manufactured."
					+ "The GST to be levied by the Centre on intra-State supply of goods and/or services is Central GST (CGST) "
					+ " For Example :  If Dealer A Sold Goods  of 100000 to Delare B in Maharashtra & Dealer B sold Goods to End customer"
					+ "In this Case Suppose 18% tax is applicable then tax amount will be 18000 Rs."
					+ " Distribution of Tax Suppose CGST is 9% and SGST is also 9% Then 900 will go Central and 900 will go to State";
			new showHelp().showHelp(InfoText, Heading);
			break;

		case "SGST":
			Heading = "What is SGST ?";
			InfoText = "GST is a consumption based tax i.e. the tax should be received by the state in which the goods or services are consumed"
					+ "and not by the state in which such goods are manufactured."
					+ "The GST to be levied by the Centre on intra-State supply of goods and/or services is Central GST (CGST) "
					+ " For Example :  If Dealer A Sold Goods  of 100000 to Delare B in Maharashtra & Dealer B sold Goods to End customer"
					+ "In this Case Suppose 18% tax is applicable then tax amount will be 18000 Rs."
					+ " Distribution of Tax Suppose CGST is 9% and SGST is also 9% Then 900 will go Central and 900 will go to State";
			new showHelp().showHelp(InfoText, Heading);
			break;
		case "IGST":
			Heading = "What is IGST ?";
			InfoText = "GST is a consumption based tax i.e. the tax should be received by the state in which the goods or services are consumed"
					+ "and not by the state in which such goods are manufactured."
					+ "If the dealer in Maharashtra had sold goods to a dealer in Gujarat worth Rs. 1,00,000. The GST rate is 18% comprising of CGST "
					+ "Rate of 9% and SGST rate of 9%. In such case the dealer has to charge Rs. 18,000 as IGST. This IGST will go to the Centre.";
			new showHelp().showHelp(InfoText, Heading);
			break;
		case "Credit":
			Heading = "What is Credit Adjustment Between State and Central";
			InfoText = "Take A Example"
					+ "Suppose goods worth Rs. 10,000 are sold by manufacturer A in Maharashtra to Dealer B in Maharashtra. "
					+ "B resells them to trader C in Rajasthan for Rs. 17,500. Trader C finally sells to End User D in Rajasthan for Rs. 30,000"
					+ "Suppose CGST= 9%, SGST=9%. Therefore, IGST=9+9=18%"
					+ "Since A is selling this to B in Maharashtra itself, it is an intra-state sale and both CGST @9% and SGST@9% will apply."
					+ "B (Maharashtra) is selling to C (Rajasthan). Since it is an interstate sale, IGST@18% will apply."
					+ "C (Rajasthan) is selling to D also in Rajasthan. Once again it is an intra-state sale and both CGST @9% and SGST@9% will apply."
					+ " See Detail Example Demo :";
			new showHelp().showHelp(InfoText, Heading);
			break;

		}
	}
}

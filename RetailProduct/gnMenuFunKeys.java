package RetailProduct;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class gnMenuFunKeys {

	
	public void setKeyDayBegin(Component fld, String progname, String vkey) {
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(vkey), "Daybegin");
		imap.put(KeyStroke.getKeyStroke("VK_C"), "Daybegin");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("Daybegin", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String menuchoice = progname.toUpperCase();
				try {
					showMenu(menuchoice);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	
	
	
	public void setKeySupplier(Component fld, String progname, String vkey) {
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(vkey), "Supplier");
		imap.put(KeyStroke.getKeyStroke("VK_C"), "Supplier");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("Supplier", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String menuchoice = progname.toUpperCase();
				try {
					showMenu(menuchoice);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	
	
	public void setKeyArticle(Component fld, String progname, String vkey) {
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(vkey), "Article");
		imap.put(KeyStroke.getKeyStroke("VK_C"), "Article");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("Article", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String menuchoice = progname.toUpperCase();
				try {
					showMenu(menuchoice);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void setKeyWs(Component fld, String progname, String vkey) {
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(vkey), "Ws");
		imap.put(KeyStroke.getKeyStroke("VK_C"), "Ws");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("Ws", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String menuchoice = progname.toUpperCase();
				try {
					showMenu(menuchoice);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void setKeyPOS(Component fld, String progname, String vkey) {
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(vkey), "POS");
		imap.put(KeyStroke.getKeyStroke("VK_C"), "POS");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("POS", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String menuchoice = progname.toUpperCase();
				try {
					showMenu(menuchoice);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void setKeyGR(Component fld, String progname, String vkey) {
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(vkey), "GR");
		imap.put(KeyStroke.getKeyStroke("VK_C"), "GR");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("GR", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String menuchoice = progname.toUpperCase();
				try {
					showMenu(menuchoice);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void setKeySAD(Component fld, String progname, String vkey) {
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(vkey), "SAD");
		imap.put(KeyStroke.getKeyStroke("VK_C"), "SAD");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("SAD", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String menuchoice = progname.toUpperCase();
				try {
					showMenu(menuchoice);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void setKeyContra(Component fld, String progname, String vkey) {
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(vkey), "Contra");
		imap.put(KeyStroke.getKeyStroke("VK_C"), "Contra");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("Contra", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String menuchoice = progname.toUpperCase();
				try {
					showMenu(menuchoice);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void setKeyPV(Component fld, String progname, String vkey) {
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(vkey), "PV");
		imap.put(KeyStroke.getKeyStroke("VK_C"), "PV");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("PV", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String menuchoice = progname.toUpperCase();
				try {
					showMenu(menuchoice);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void setKeyRV(Component fld, String progname, String vkey) {
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(vkey), "RV");
		imap.put(KeyStroke.getKeyStroke("VK_C"), "RV");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("RV", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String menuchoice = progname.toUpperCase();
				try {
					showMenu(menuchoice);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void setKeyDayEnd(Component fld, String progname, String vkey) {
		InputMap imap = ((JComponent) fld).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		imap.put(KeyStroke.getKeyStroke(vkey), "Dayend");
		imap.put(KeyStroke.getKeyStroke("VK_C"), "Dayend");
		ActionMap amap = ((JComponent) fld).getActionMap();
		amap.put("Dayend", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				String menuchoice = progname.toUpperCase();
				try {
					showMenu(menuchoice);
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	private void showMenu(String menuchoice) throws Throwable {
		// new General().msg(menuchoice);
		switch (menuchoice) {
		case "BEGIN":
			DayBegin window2 = new DayBegin();
			window2.DayBeginFrame.setVisible(true);
			break;

		case "SUPPLIER":
			CustomerMaster window3 = new CustomerMaster();
			window3.CustomerFrame.setVisible(true);
			break;

		case "ARTICLE":
			// Article_Quick_Master window4 = new Article_Quick_Master();
			// window4.ArticleQMasterFrame.setVisible(true);
			break;

		case "WS":

			break;

		case "POS":
			POS window6 = new POS();
			window6.POSFrame.setVisible(true);
			break;

		case "GR":
			GRNModule window = new GRNModule();
			window.GRNModuleFrame.setVisible(true);
 			break;

		case "SAD":
			// new ApplicationMenu().MenuSelection = "SA" ;
			// Ws_Advance_payment window8 = new Ws_Advance_payment();
			// window8.ws_advance.setVisible(true);
			break;

		case "CONTRA":
			bankTransactions window9 = new bankTransactions();
			window9.frmBusinessApplication.setVisible(true);
			break;

		case "PV":
			paymentVoucher window10 = new paymentVoucher();
			window10.frmpaymentvoucher.setVisible(true);
			break;

		case "RV":
			receiptVoucher window11 = new receiptVoucher();
			window11.frmreceiptVoucher.setVisible(true);
			break;

		case "END":
			dayEnd window12 = new dayEnd();
			window12.frameDayEnd.setVisible(true);
			break;

		}
	}

}// Last

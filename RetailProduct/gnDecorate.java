package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class gnDecorate {

	private Color back;
	private Color fore;

	private Color orgback;
	private Color orgfore;

	int width;
	int height;
	int getx;
	int gety;

	JButton myButton;

	
	
	/// Button Display Decoartion

	
	public void setHyperlink(JButton  btn , String btnText)
	{
		 btn.setText("<HTML> <U> +"+btnText+" </U> <FONT color=\"#000099\">  </FONT> </HTML>") ;
 		 btn.setBounds(122, 13, 143, 74);
		 btn.setHorizontalAlignment(SwingConstants.LEFT);
		 btn.setBorderPainted(false);
		 btn.setOpaque(false);
		 btn.setBackground(Color.WHITE);
		 btn.setBackground(Color.black);
		 
 	}
	
	public void setCYANBackGround(JButton btn) {
		new gnStyleButton().getStyleButton(btn, new Color(56, 211, 112), Color.WHITE);
	}

	public void SetSeqHdrButton(JButton btn, int Type) {

		switch (Type) {
		case 1:
			new gnStyleButtonSqr().getStyleButton(btn, new Color(102, 102, 153), Color.WHITE);
			decorateBtn(btn, new Color(0, 0, 10), Color.green);
			break;

		case 11:
			new gnStyleButtonSqr().getStyleButton(btn, new Color(131, 211, 112), Color.BLACK);
			new gnDecorate().decorateBtn(btn, new Color(120, 151, 112), Color.WHITE);
			break;

		case 2:
			new gnStyleButtonSqr().getStyleButton(btn, new Color(153, 204, 204), Color.black);
			decorateBtn(btn, new Color(0, 0, 10), Color.green);
			break;

		case 3:
			new gnStyleButtonSqr().getStyleButton(btn, new Color(130, 210, 112), Color.WHITE);
			decorateBtn(btn, new Color(0, 0, 10), Color.green);
			break;

		case 4:
			new gnStyleButtonSqr().getStyleButton(btn, new Color(150, 204, 210), Color.black);
			new gnDecorate().decorateBtn(btn, new Color(0, 0, 10), Color.WHITE);
			break;
		}

		/*
		 * new gnStyleButton().getStyleButton(btnDaybegin, new Color(56, 211,
		 * 112), Color.WHITE); new gnStyleButton().getStyleButton(btndayend, new
		 * Color(56, 211, 112), Color.WHITE); new
		 * gnStyleButton().getStyleButton(btnPur, new Color(56, 211, 112),
		 * Color.WHITE); new gnStyleButton().getStyleButton(btnSale, new
		 * Color(56, 211, 112), Color.WHITE); new
		 * gnStyleButton().getStyleButton(btnArticle, new Color(56, 211, 112),
		 * Color.WHITE); new gnStyleButton().getStyleButton(btnSupplier, new
		 * Color(56, 211, 112), Color.WHITE); new
		 * gnStyleButton().getStyleButton(btnreceiptvou, new Color(56, 211,
		 * 112), Color.WHITE); new
		 * gnStyleButton().getStyleButton(btnpaymentvoucher, new Color(56, 211,
		 * 112), Color.WHITE); new gnStyleButton().getStyleButton(btnContra, new
		 * Color(56, 211, 112), Color.WHITE); new
		 * gnStyleButton().getStyleButton(btnPriceupdate, new Color(56, 211,
		 * 112), Color.WHITE);
		 * 
		 * new gnStyleButtonSqr().getStyleButton(btnPriceupdate, new Color(130,
		 * 210, 112), Color.WHITE); new
		 * gnStyleButtonSqr().getStyleButton(btnContra, new Color(130, 210,
		 * 112), Color.WHITE); new
		 * gnStyleButtonSqr().getStyleButton(btnreceiptvou, new Color(130, 210,
		 * 112), Color.WHITE); new
		 * gnStyleButtonSqr().getStyleButton(btnpaymentvoucher, new Color(130,
		 * 210, 112), Color.WHITE); new
		 * gnStyleButtonSqr().getStyleButton(btnSupplier, new Color(130, 210,
		 * 112), Color.WHITE); new gnStyleButtonSqr().getStyleButton(btnArticle,
		 * new Color(130, 210, 112), Color.WHITE); new
		 * gnStyleButtonSqr().getStyleButton(btnSale , new Color(130, 210, 112),
		 * Color.WHITE); new gnStyleButtonSqr().getStyleButton(btnPur, new
		 * Color(130, 210, 112), Color.WHITE); new
		 * gnStyleButtonSqr().getStyleButton(btndayend, new Color(130, 210,
		 * 112), Color.WHITE); new
		 * gnStyleButtonSqr().getStyleButton(btnDaybegin, new Color(130, 210,
		 * 112), Color.WHITE);
		 * 
		 * 
		 * new gnStyleButtonSqr().getStyleButton(TSalesReturn, new Color(130,
		 * 210, 112), Color.WHITE); new
		 * gnStyleButtonSqr().getStyleButton(TPurchaseReturn, new Color(131,
		 * 211, 112), Color.white); new
		 * gnStyleButtonSqr().getStyleButton(TExpense, new Color(130, 210, 112),
		 * Color.white); new gnStyleButtonSqr().getStyleButton(TIncome, new
		 * Color(131, 211, 112), Color.WHITE); new
		 * gnStyleButtonSqr().getStyleButton(TViewLedger, new Color(130, 210,
		 * 112), Color.white); new gnStyleButtonSqr().getStyleButton(TGSTData,
		 * new Color(131, 211, 112), Color.white); new
		 * gnStyleButtonSqr().getStyleButton(TCreditSales, new Color(130, 210,
		 * 112), Color.white); new gnStyleButtonSqr().getStyleButton(TDayBook,
		 * new Color(130, 210, 112), Color.white); new
		 * gnStyleButtonSqr().getStyleButton(TPurView, new Color(131, 211, 112),
		 * Color.white); new gnStyleButtonSqr().getStyleButton(TStockView, new
		 * Color(130, 210, 112), Color.white); new
		 * gnStyleButtonSqr().getStyleButton(TSalesView, new Color(131, 211,
		 * 112), Color.white); new gnStyleButtonSqr().getStyleButton(TScanItem,
		 * new Color(131, 211, 112), Color.white);
		 */

	}

	public void decorateBtn(JButton jbtn, Color Cback, Color Fore) {
		myButton = jbtn;
		MouseListener mk = new Btnmouseeffect();
		jbtn.addMouseListener(mk);
		fore = Fore;
		back = Cback;
	}

	class Btnmouseeffect implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent w) {
		}

		@Override
		public void mouseEntered(MouseEvent w) {
			JButton vname = (JButton) w.getSource();

			orgfore = vname.getForeground();
			orgback = vname.getBackground();

			orgfore = myButton.getForeground();
			orgback = myButton.getBackground();

			vname.setBackground(back);
			vname.setForeground(fore);

			myButton.setBackground(back);
			myButton.setForeground(fore);
			width = vname.getWidth();
			height = vname.getHeight();
			getx = vname.getX();
			gety = vname.getY();

		}

		@Override
		public void mouseExited(MouseEvent w) {
			JButton vname = (JButton) w.getSource();
			// setInitialButton(vname);
			setInitialButton(myButton);

		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// JButton vname = (JButton) e.getSource() ;
			// vname.removeActionListener(null);
		}
	}

	public void setInitialButton(JButton btn) {
		btn.setForeground(orgfore);
		btn.setBackground(orgback);

	}

	// End button Display Decoration

	public void changeOnFocus(JButton jbtn, Color Cback, Color Fore) {
		FocusListener abc = new btnFocus();
		jbtn.addFocusListener(abc);
	}

	class btnFocus implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			JButton vname = (JButton) e.getSource();
			vname.setBackground(back);
			vname.setForeground(fore);
		}

		@Override
		public void focusLost(FocusEvent e) {
			JButton vname = (JButton) e.getSource();
			new gnDecorate().setInitialButton(vname);
		}
	}

	/*
	 * //Color for Button public void setButtonColor12(JButton jbtn) {
	 * jbtn.setBackground(new Color(199, 21, 133)); jbtn.setForeground(new
	 * Color(204, 255, 153)); }
	 * 
	 * public void setButtonColor1(JButton jbtn) { jbtn.setBackground(new
	 * Color(128, 0,128)); jbtn.setForeground(new Color(153,255,153));
	 * 
	 * }
	 * 
	 * 
	 * public void setButtonColor11(JButton jbtn) { jbtn.setBackground(new
	 * Color(153,0,102)); jbtn.setForeground(new Color(153,255,153));
	 * 
	 * }
	 * 
	 * public void setButtonColor2(JButton jbtn) { jbtn.setBackground(new
	 * Color(199, 21, 133)); jbtn.setForeground(new Color(204, 255, 153)); }
	 * 
	 * public void setButtonColor3(JButton jbtn) { jbtn.setBackground(new
	 * Color(0, 0, 102)); jbtn.setForeground(new Color(153, 255, 153)); }
	 */

	public void setTextFieldBackgroud(JTextField jtx) {
		jtx.setBackground(new Color(199, 21, 133));
		jtx.setForeground(new Color(204, 255, 153));

	}

	public void setTextFieldBackgroud1(JTextField jtx) {
		jtx.setBackground(new Color(0, 21, 0));
		jtx.setForeground(new Color(204, 255, 153));

	}
	// Text Field Background

	// Text Field Decoration Starts

	public void decoratejsp(Component vcomp, int x) {
		((JComponent) vcomp).setBorder(BorderFactory.createBevelBorder(x));
	}

	public void DispField_Beval(Component jdisptext) {
		((JComponent) jdisptext).setBorder(BorderFactory.createLoweredSoftBevelBorder());
	}

	public void DispField_BevalRaised(Component jdisptext) {
		((JComponent) jdisptext).setBorder(BorderFactory.createRaisedBevelBorder());
	}

	public void DispField_Eatch(Component jdisptext, int x) {
		((JComponent) jdisptext).setBorder(BorderFactory.createEtchedBorder());
	}

	public void DispField_Beval_int(Component jdisptext, int x) {
		((JComponent) jdisptext).setBorder(BorderFactory.createBevelBorder(x));
	}

	public void decorateField(JTextField jtext) {
		// ((JComponent) jtext).setBorder(new BevelBorder(BevelBorder.RAISED,
		// new Color(255, 255, 255), new Color(255, 255, 255), Color.CYAN,
		// Color.DARK_GRAY));
		MouseListener btncolor = new Txtnmouseeffect();
		jtext.addMouseListener(btncolor);

	}

	class Txtnmouseeffect implements MouseListener {
		@Override
		public void mouseClicked(MouseEvent w) {
		}

		@Override
		public void mouseEntered(MouseEvent w) {
			// TODO Auto-generated method stu.b
			JTextField vname = (JTextField) w.getSource();
			vname.setBackground(Color.WHITE);
			vname.setForeground(Color.BLACK);
			vname.setFont(new Font("Times Roman", 100, 15));
			String vtip = vname.getToolkit().getProperty("ToolTip", "");

		}

		@Override
		public void mouseExited(MouseEvent w) {
			JTextField vname = (JTextField) w.getSource();
			new gnDecorate().decorateField(vname);
			vname.setBackground(Color.WHITE);
			vname.setForeground(Color.BLACK);
			vname.setFont(new Font("VARDANA", 50, 10));
			vname.getToolkit();
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	}
	// Text Field Decoration Starts

	public void setHandCursor(JFrame frame) {
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		frame.setCursor(cursor);

	}

	public void setDefaultCursor(JFrame frame) {
		Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		frame.setCursor(cursor);

	}

	public void setBusyCursor(JFrame frame) {
		Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
		frame.setCursor(cursor);

	}

	public void setBusyCursor(JPanel frame) {
		Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
		frame.setCursor(cursor);

	}

	public void setDefaultCursor(JPanel frame) {
		Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		frame.setCursor(cursor);

	}

}// last

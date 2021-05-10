package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ScrollPaneConstants;

public class showHelp {

	private JEditorPane edtpane;
	private JTextArea textArea;
	private JButton btnInfo;
	private JButton btnMsg;
	private JFrame frmBusinessApplication;
	private JButton btnClose;
	JPanel panel;
	private JScrollPane jsp;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 * @throws MalformedURLException
	 */

	public void showHelp(String vDisplayText, String Title) throws MalformedURLException, IOException {

		// new General().msg(vDisplayText);
		textArea.setText(vDisplayText);
		textArea.setText(vDisplayText);
		System.lineSeparator();
		textArea.setBorder(null);
		btnMsg.setText(Title);
		textArea.setEditable(true);
		textArea.setAutoscrolls(true);
		textArea.setForeground(Color.black);
		textArea.setEnabled(true);
		textArea.setCaretColor(Color.BLUE);
		textArea.setBounds(12, 13, 615, 300);
		textArea.setEnabled(false);
		jsp = new JScrollPane(textArea);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(12, 13, 627, 313);
		panel.setBounds(12, 32, 651, 339);
		panel.add(jsp);
		panel.repaint();
		frmBusinessApplication.getContentPane().add(panel);
		frmBusinessApplication.setVisible(true);
	}

	public void showEdtHelp(String vDisplayText, String Title) throws MalformedURLException, IOException {
		edtpane.setText(vDisplayText);
		System.lineSeparator();
		btnMsg.setText(Title);
		edtpane.setEditable(false);
		edtpane.setAutoscrolls(true);
		edtpane.setForeground(Color.black);
		edtpane.setEnabled(true);
		edtpane.setCaretColor(Color.BLUE);
		frmBusinessApplication.setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showHelp window = new showHelp();
					window.frmBusinessApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public showHelp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBusinessApplication = new JFrame();
		frmBusinessApplication.setResizable(false);
		frmBusinessApplication.setAlwaysOnTop(true);
		frmBusinessApplication.setTitle("Business Application");
		frmBusinessApplication.setType(Type.UTILITY);
		frmBusinessApplication.setBounds(250, 250, 693, 450);
		frmBusinessApplication.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBusinessApplication.getContentPane().setLayout(null);

		edtpane = new JEditorPane();
		edtpane.setBackground(new Color(204, 255, 255));
		edtpane.setForeground(Color.BLACK);
		edtpane.setFont(new Font("SansSerif", Font.PLAIN, 14));
		edtpane.setBounds(12, 34, 651, 238);
		// .getContentPane().add(edtpane);

		btnInfo = new JButton("View More");
		btnInfo.setMnemonic('M');
		btnInfo.setBounds(53, 384, 97, 25);
		frmBusinessApplication.getContentPane().add(btnInfo);
		btnInfo.setEnabled(false);

		btnMsg = new JButton("..");
		btnMsg.setBounds(12, 0, 651, 31);
		frmBusinessApplication.getContentPane().add(btnMsg);

		btnClose = new JButton("Close");
		btnClose.setMnemonic('L');
		btnClose.setFocusable(true);
		btnClose.grabFocus();
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBusinessApplication.dispose();
			}
		});
		btnClose.setBounds(273, 384, 97, 25);
		frmBusinessApplication.getContentPane().add(btnClose);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(204, 204, 204), 6), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 32, 651, 339);
		frmBusinessApplication.getContentPane().add(panel);
		panel.setLayout(null);

		textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setBounds(12, 13, 627, 313);
		textArea.setWrapStyleWord(true);
		textArea.setForeground(new Color(0, 0, 153));
		textArea.setLineWrap(true);
		textArea.setRows(100);
		textArea.setFont(new Font("Verdana", Font.PLAIN, 14));
		/*
		 * jsp =new JScrollPane(textArea);
		 * jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.
		 * VERTICAL_SCROLLBAR_ALWAYS);
		 * jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.
		 * HORIZONTAL_SCROLLBAR_ALWAYS); jsp.setBounds(12, 13, 627, 313);
		 * //panel.add(textArea); panel.add(jsp);
		 */

		try {
			new gnApp().setFrameTitel(frmBusinessApplication);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

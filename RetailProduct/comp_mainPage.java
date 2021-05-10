package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue; 
import java.awt.Toolkit;
import java.awt.Window.Type;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.border.BevelBorder;


 

//chanage in sp day_getCashierwiseSales please note on date 02/3/2021 chnages for float cash in day End 
// as New SP at Client Place <AcctDocPosting_POSalesPaymentData 05/03/2021>
//as SP changes at Client Place <AcctDocPosting_POSalesData 05/03/2021>
// sp chnage <GST_Sales_ReturnFileData>


/**
* @author dell
* 
*/
/** 
* @author dell
*  
*/





public class comp_mainPage extends gnPublicVariable {
	private static JFrame frame;
	
	JPanel panel_1;
	JProgressBar progressBar;

	//AutoCompleteDecorator.decorate(parentcombo);

	/**  
	 * Launch the application.
	 */
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comp_mainPage window = new comp_mainPage();
					window.frame.setVisible(true);
 				} catch (Exception e) {
					new General().msg(e.getLocalizedMessage());
				} catch (Throwable e) {
					new General().msg(e.getLocalizedMessage());
				}
			}
		});
	}

	
	
	/**
	 * Create the application.
	 * 
	 * @throws Throwable
	 */

	public comp_mainPage() throws Throwable {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 *  
	 * @throws Throwable
	 */
 	
	private void initialize() throws Throwable {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\AKN\\myProductImage\\Logo26.png"));
		frame.setBounds(325, 185, 552, 290);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setForeground(Color.ORANGE);
		panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(-12, 0, 564, 326);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setBounds(48, 274, 507, 11);
		panel.add(progressBar);
		progressBar.setToolTipText(" ");
		progressBar.setMaximum(1000);

		JLabel lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setBounds(176, 36, 184, 101);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.CYAN);
		lblNewLabel_1.setIcon(new ImageIcon(comp_mainPage.class.getResource("/RetailProduct/posimage4.jpg")));
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setIcon(new ImageIcon(comp_mainPage.class.getResource("/RetailProduct/panel1.png")));
		lblNewLabel_2.setBounds(12, 0, 37, 285);
		panel.add(lblNewLabel_2);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 204));
		panel_1.setBounds(48, 174, 516, 77);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("MERETOO Business Solutions");
		lblNewLabel_4.setBounds(28, 24, 255, 16);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));

		JLabel lblNewLabel = new JLabel("Pune,");
		lblNewLabel.setBounds(28, 41, 46, 16);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);

		JLabel lblNewLabel_6 = new JLabel("Maharashtra ");
		lblNewLabel_6.setBounds(67, 41, 216, 16);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		lblNewLabel_6.setForeground(Color.WHITE);

		JLabel lblNewLabel_5 = new JLabel("Software Implementaion Partener Of");
		lblNewLabel_5.setBounds(28, 0, 304, 22);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));

		JLabel lblNewLabel_3 = new JLabel("Loading.....");
		lblNewLabel_3.setBounds(58, 251, 70, 16);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_7 = new JLabel(" ");
		//lblNewLabel_7.setIcon(new ImageIcon(comp_mainPage.class.getResource("/RetailProduct/mymainlogo_5.png")));
		lblNewLabel_7.setBounds(62, 13, 89, 146);
		panel.add(lblNewLabel_7);
		Decorate();
	}

	
	/**
	 * @throws Throwable
	 */

	/**
	 * @throws Throwable
	 */
	/**
	 * @throws Throwable
	 */
	private void Decorate() throws Throwable {
	
		frame.setUndecorated(true);
  		panel_1.setVisible(false); // invisble for non farmtrolly only visible
									// for farmtrolly
		String status = new General().checkDrivePath();
 
		if (status == "Fail") {
			System.exit(0);
		} 
		progressBar.setStringPainted(true);
		progressBar.setIndeterminate(true);
		progressBar.setBackground(new Color(51, 255, 255));
		progressBar.setForeground(new Color(204, 0, 204));
		final int i = 0;
		progressBar.setVisible(false);
		ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
		s.schedule(new Runnable() {
			public void run() {
				progressBar.setVisible(false);
				frame.setVisible(true); // should be invoked on the EDT
				try {
					new General().SetApplicationDriveInfo();
					Loginwindow window = new Loginwindow();
					window.frmLoginWindow.setVisible(true);
				} catch (Throwable e) {
					e.printStackTrace();
				} finally {
					frame.setVisible(false);
					frame.dispose();
				}
			} 
		}, 101, TimeUnit.MILLISECONDS);
	}
	 
	
	
	
	
	
	
}// Last

package RetailProduct;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class tmpCheck {

	JButton btnGet;
	JDateChooser dateChooser;
	String selectedDate;

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tmpCheck window = new tmpCheck();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tmpCheck() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("deprecation")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		dateChooser = new JDateChooser();
		dateChooser.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		dateChooser.setBounds(258, 41, 100, 22);
		frame.getContentPane().add(dateChooser);

		btnGet = new JButton("Get Date");
		btnGet.setBounds(80, 41, 97, 25);
		frame.getContentPane().add(btnGet);

		ActionListener btnLs = new btnLsnr();
		btnGet.addActionListener(btnLs);
		decorate();

	}

	@SuppressWarnings("deprecation")
	private void decorate() {

		dateChooser.setDateFormatString("dd/MM/yyyy");

	}

	class btnLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			java.util.Date vdate = dateChooser.getDate();
			SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
			String vdate1 = ft.format(vdate);
			// System.out.println(vdate1);
			new General().msg("Date format is :" + " " + vdate1);
			selectedDate = vdate1;
		}

	}

}

package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.prefs.PreferenceChangeEvent;
import java.util.prefs.PreferenceChangeListener;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;

public class test {

	private JFrame frame;
	JDateChooser dateChooser = null;
	JDateChooser dateChooser_1;
	private JTextField mydate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
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

		JButton btnshow = new JButton("show");
		btnshow.setBounds(138, 46, 63, 25);
		frame.getContentPane().add(btnshow);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(37, 49, 90, 22);
		dateChooser.setDateFormatString("d.MM.YYYY");
		frame.getContentPane().add(dateChooser);

		mydate = new JTextField();
		mydate.setBounds(12, 84, 93, 22);
		frame.getContentPane().add(mydate);
		mydate.setColumns(10);

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(dateChooser.getDate().toString());
		mydate.setText(date);

		ActionListener lt = new btnlsnr();
		dateLsnr dt = new dateLsnr();
		dateChooser.addPropertyChangeListener("date", (PropertyChangeListener) dt);
		btnshow.addActionListener(lt);
	}

	class dateLsnr implements PreferenceChangeListener {

		@Override
		public void preferenceChange(PreferenceChangeEvent arg0) {
			// TODO Auto-generated method stub

			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			String date = sdf.format(dateChooser.getDate());
			mydate.setText(date);
			new General().msg(date);

		}
	}

	class btnlsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			String date = sdf.format(dateChooser.getDate());
			mydate.setText(date);
			new General().msg(date);
		}

	}
}

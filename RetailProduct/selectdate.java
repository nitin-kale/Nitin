package RetailProduct;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class selectdate extends JFrame implements ActionListener {
	JLabel CheckDate;
	JButton check;
	public UtilDateModel model;
	public JFrame frame;
	public JDatePanelImpl datePanel;
	public JDatePickerImpl datePicker;
	public static String vdate;
	public JTextField fld;
	public String setdateAt;
	public JTable table;
	public int row;
	public int col;

	public void setTableCellDate(JTextField Jfield, JTable ntable, int nrow, int ncol) throws Throwable {

		setdateAt = "2";
		fld = Jfield;
		row = nrow;
		table = ntable;
		col = ncol;
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.show(true);
		JPanel panel = new JPanel();
		CheckDate = new JLabel("Date:");
		check = new JButton("Select");
		check.addActionListener(this);
		check.setMnemonic('S');
		panel.add(CheckDate);
		panel.add(datePicker);
		panel.add(check);
		add(panel);
		frame = new JFrame();
		frame.setLocationByPlatform(true);

		new gnApp().setFrameTitel(frame);
		frame.setTitle("Select Date");
		frame.add(panel);
		frame.setBounds(200, 250, 350, 250);
		frame.setResizable(false);
		frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}

	public void selectDate(JTextField Jfield) throws Throwable {
		setdateAt = "1";
		fld = Jfield;
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		datePicker.show(true);
		JPanel panel = new JPanel();
		CheckDate = new JLabel("Date:");
		check = new JButton("Select");
		check.addActionListener(this);
		check.setMnemonic('S');
		panel.add(CheckDate);
		panel.add(datePicker);
		panel.add(check);
		add(panel);
		frame = new JFrame();
		new gnApp().setFrameTitel(frame);
		frame.setTitle("Select Date");
		frame.add(panel);
		frame.setBounds(200, 250, 350, 250);
		frame.setResizable(false);
		frame.setBackground(Color.white);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (check == ((EventObject) e).getSource()) {
			Date selectedDate = (Date) datePicker.getModel().getValue();
			SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
			String date = ft.format(selectedDate);
			vdate = date;
			datePicker.getJFormattedTextField().setText(vdate);
			fld.setText(vdate);
			if (setdateAt == "2") {
				table.setValueAt(vdate, row, col);
			}
			frame.dispose();
		}
	}

	public String getSelectedDate() {
		return vdate;
	}

	public static void main(String[] args) {
		// selectdate nn = new selectdate();
		// nn.selectDate();
	}
}

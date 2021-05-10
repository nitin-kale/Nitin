package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class impExp_shipping {

	JFrame ShippingForm;
	JPanel Export;
	private JTextField shippingbill;
	private JTextField shippingdate;
	JButton btnClose;
	JComboBox portcode;
	JComboBox exporttype;

	// Static Fields
	public static String vbillno;
	public static String vbilldate;
	public static String vportno;
	public static String vBEcode;
	public static String vexportType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					impExp_shipping window = new impExp_shipping();
					window.ShippingForm.setVisible(true);
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
	public impExp_shipping() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		ShippingForm = new JFrame();
		ShippingForm.getContentPane().setBackground(Color.WHITE);
		ShippingForm.setType(Type.UTILITY);
		ShippingForm.setResizable(false);
		ShippingForm.setAlwaysOnTop(true);
		ShippingForm.setBounds(250, 150, 450, 300);
		ShippingForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ShippingForm.getContentPane().setLayout(null);

		Export = new JPanel();
		Export.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Export Shipping Details",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 102)));
		Export.setBackground(Color.WHITE);
		Export.setBounds(0, 36, 432, 116);
		ShippingForm.getContentPane().add(Export);
		Export.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Shipping Bill No");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setBounds(47, 27, 99, 16);
		Export.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Shipping Bill Date");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setBounds(44, 50, 99, 16);
		Export.add(lblNewLabel_2);

		shippingbill = new JTextField();
		shippingbill.setBounds(148, 20, 116, 25);
		Export.add(shippingbill);
		shippingbill.setColumns(10);

		shippingdate = new JTextField();
		shippingdate.setBounds(148, 43, 116, 25);
		Export.add(shippingdate);
		shippingdate.setColumns(10);

		exporttype = new JComboBox();
		exporttype.setModel(new DefaultComboBoxModel(new String[] { "WOPAY", "WPAY" }));
		exporttype.setBounds(148, 68, 106, 26);
		Export.add(exporttype);

		JLabel lblNewLabel_4 = new JLabel("Export Type");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setBounds(80, 74, 63, 16);
		Export.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("WOPAY- Without Payment");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_5.setForeground(new Color(0, 0, 102));
		lblNewLabel_5.setBounds(266, 71, 141, 16);
		Export.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("WPAY - With Paymant");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_6.setForeground(new Color(0, 0, 102));
		lblNewLabel_6.setBounds(266, 90, 128, 16);
		Export.add(lblNewLabel_6);

		JPanel Import = new JPanel();
		Import.setBorder(
				new TitledBorder(null, "Import Port Details", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		Import.setBackground(Color.WHITE);
		Import.setBounds(0, 153, 442, 81);
		ShippingForm.getContentPane().add(Import);
		Import.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Select PORT");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_3.setBounds(63, 25, 77, 16);
		Import.add(lblNewLabel_3);

		portcode = new JComboBox();
		portcode.setModel(new DefaultComboBoxModel(new String[] { "10", "11", "12", "14", "15" }));
		portcode.setBounds(152, 22, 204, 22);
		Import.add(portcode);

		btnClose = new JButton("Close");
		btnClose.setBounds(193, 232, 97, 34);
		ShippingForm.getContentPane().add(btnClose);

		JLabel lblNewLabel = new JLabel("Enter Or Select Details");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 0, 212, 20);
		ShippingForm.getContentPane().add(lblNewLabel);
		ActionListener cl = new closLsnr();
		btnClose.addActionListener(cl);
		decorate();

	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(ShippingForm);
		new gnField().closeform(Export, ShippingForm);

	}

	class closLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String value = e.getActionCommand();
			if (value == "Close") {
				vbillno = shippingbill.getText();
				vbilldate = shippingdate.getText();
				ShippingForm.dispose();
				vexportType = exporttype.getSelectedItem().toString();
			}
		}
	}
}

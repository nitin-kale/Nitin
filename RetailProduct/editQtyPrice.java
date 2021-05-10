package RetailProduct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class editQtyPrice {

	JFrame PriceQtyEditframe;
	private JTextField qty;
	private JTextField price;
	public static String rqty = "0.00";
	public static String rprice = "0.00";
	public static String vname = "";
	public static String vcode = "";
	public JPanel panel;
	JButton btnChnage;
	int colqty;
	int colprice;
	int row;
	JTable mytable;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public editQtyPrice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PriceQtyEditframe = new JFrame();
		PriceQtyEditframe.getContentPane().setBackground(new Color(255, 255, 255));
		PriceQtyEditframe.setBackground(Color.BLACK);
		PriceQtyEditframe.setResizable(false);
		PriceQtyEditframe.setAlwaysOnTop(true);
		PriceQtyEditframe.setBounds(250, 2, 450, 145);
		PriceQtyEditframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		PriceQtyEditframe.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 51)));
		panel.setBounds(12, 13, 408, 99);
		panel.setBackground(Color.WHITE);
		PriceQtyEditframe.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Change Qty");
		lblNewLabel.setBounds(12, 38, 88, 16);
		panel.add(lblNewLabel);

		qty = new JTextField();
		qty.setText(rqty);
		qty.setBounds(100, 35, 80, 22);
		panel.add(qty);
		qty.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Change Price");
		lblNewLabel_1.setBounds(187, 38, 75, 16);
		panel.add(lblNewLabel_1);

		price = new JTextField();
		price.setText(rprice);
		price.setBounds(266, 35, 116, 22);
		panel.add(price);
		price.setColumns(10);

		JLabel vvcode = new JLabel("--");
		vvcode.setBounds(12, 13, 56, 16);
		panel.add(vvcode);

		JLabel vvname = new JLabel("------");
		vvname.setBounds(80, 13, 316, 16);
		vvname.setText(vname);
		vvcode.setText(vcode);
		panel.add(vvname);

		btnChnage = new JButton("Change");
		btnChnage.setBounds(165, 70, 97, 30);
		panel.add(btnChnage);
		btnChnage.setFont(new Font("Calibri", Font.BOLD, 15));
		btnChnage.setMnemonic('C');
		ActionListener chng = new changeLsnr();
		btnChnage.addActionListener(chng);

	}

	class changeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// String value = e.getActionCommand() ;
			rprice = price.getText();
			rqty = qty.getText();
			PriceQtyEditframe.dispose();
			setEditQtyandrate();
		}
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void change(JTable vtable, int Row, int colQty, int colPrice) {
		// editQtyPrice window = new editQtyPrice();
		// window.PriceQtyEditframe.setVisible(true);

		PriceQtyEditframe.setVisible(true);
		PriceQtyEditframe.setAutoRequestFocus(true);
		PriceQtyEditframe.setAlwaysOnTop(true);

		colqty = colQty;
		colprice = colPrice;
		row = Row;
		mytable = vtable;
		// new General().msg(row+" "+colqty+""+colprice);

	}

	public void setEditQtyandrate() {
		new General().msg(row + "  " + colqty + "  " + colprice);
		mytable.setValueAt(rqty, row, colqty);
		mytable.setValueAt(rprice, row, colprice);
		try {

			vcode = "";
			new POS().QtychangeImapct(vcode, row);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}// Last

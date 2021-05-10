package RetailProduct;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class FlushData extends getResultSet {

	JFrame flushDataFrame;
	JButton btnFlush;

	String vcomp;
	String vstore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlushData window = new FlushData();
					window.flushDataFrame.setVisible(true);
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
	public FlushData() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		flushDataFrame = new JFrame();
		flushDataFrame.setAlwaysOnTop(true);
		flushDataFrame.setTitle("Flush Transaction Data");
		flushDataFrame.setBounds(350, 300, 326, 151);
		flushDataFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		flushDataFrame.getContentPane().setLayout(null);

		btnFlush = new JButton("Flush Transction Data");
		btnFlush.setFont(new Font("Agency FB", Font.BOLD, 22));
		btnFlush.setForeground(new Color(51, 0, 102));
		btnFlush.setBounds(12, 48, 281, 59);
		flushDataFrame.getContentPane().add(btnFlush);

		ActionListener hh = new flshBtn();
		btnFlush.addActionListener(hh);

		decorate();
	}

	private void decorate() throws Throwable {
		flushDataFrame.setUndecorated(true);
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		btnFlush.setVisible(false);
		switch (vcomp) {
		case "9999":
			btnFlush.setVisible(true);
			break;
		}
	}

	class flshBtn implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String SQL = "call Akn_newSetup(" + vcomp + ")";
			getResultSet r = new getResultSet();
			try {
				r.getSPResult(SQL);
				new General().Quickmsg("Transaction Data Flushed ....");
				flushDataFrame.dispose();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}// Last

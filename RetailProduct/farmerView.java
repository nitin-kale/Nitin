package RetailProduct;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class farmerView extends getResultSet {

	JFrame framefarmview;
	DefaultTableModel model = new DefaultTableModel();
	JTable table = new JTable();
	JButton btnStock;
	String Edit = "N";

	private JTextField farmername;
	private JTextField farmrcode;
	private JTextField cropname;
	private JTextField cropcode;
	JButton btnCity;
	String vcomp;
	String vstore;
	JScrollPane jsp;
	JButton btnState;
	JButton btnTaluka;
	private JButton btnDist;
	private JButton btnDose;
	private JButton btnshowCrop;
	private JPanel franchPanel;
	private JLabel lblNewLabel_2;
	private JTextField compcode;
	private JButton btnFrPurchase;
	private JButton btnfrSale;
	private JButton btnExport;
	private JTextField compname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					farmerView window = new farmerView();
					window.framefarmview.setVisible(true);
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
	public farmerView() throws Throwable {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Throwable
	 */
	private void initialize() throws Throwable {
		framefarmview = new JFrame();
		framefarmview.setBounds(100, 100, 955, 550);
		framefarmview.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framefarmview.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 432, 117);
		panel.setBackground(Color.WHITE);
		framefarmview.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Select Farmer ");
		lblNewLabel.setBounds(22, 13, 115, 16);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Select Crop");
		lblNewLabel_1.setBounds(22, 50, 91, 16);
		panel.add(lblNewLabel_1);

		farmername = new JTextField();
		farmername.setBounds(149, 10, 116, 22);
		panel.add(farmername);
		farmername.setColumns(10);

		farmrcode = new JTextField();
		farmrcode.setBounds(266, 10, 116, 22);
		panel.add(farmrcode);
		farmrcode.setColumns(10);

		cropname = new JTextField();
		cropname.setBounds(149, 45, 116, 22);
		panel.add(cropname);
		cropname.setColumns(10);

		cropcode = new JTextField();
		cropcode.setBounds(266, 47, 116, 22);
		panel.add(cropcode);
		cropcode.setColumns(10);

		btnshowCrop = new JButton("Show Crop");
		btnshowCrop.setBounds(335, 92, 97, 25);
		panel.add(btnshowCrop);

		btnExport = new JButton("Export to Excel");
		btnExport.setBounds(208, 92, 127, 25);
		panel.add(btnExport);

		btnCity = new JButton("CityWise Crop Details");
		btnCity.setBounds(0, 116, 203, 25);
		framefarmview.getContentPane().add(btnCity);

		btnTaluka = new JButton("Taluka Wise Crop Details");
		btnTaluka.setBounds(0, 140, 203, 25);
		framefarmview.getContentPane().add(btnTaluka);

		btnState = new JButton("State Wise Crop Details");
		btnState.setBounds(0, 166, 203, 25);
		framefarmview.getContentPane().add(btnState);

		jsp = new JScrollPane();
		jsp.setBounds(206, 115, 719, 377);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		framefarmview.getContentPane().add(jsp);

		btnDist = new JButton("District Wise Crop Info");
		btnDist.setBounds(0, 192, 203, 25);
		framefarmview.getContentPane().add(btnDist);

		btnDose = new JButton("Crop Wise Dose Treatment");
		btnDose.setBounds(0, 220, 203, 25);
		framefarmview.getContentPane().add(btnDose);

		franchPanel = new JPanel();
		franchPanel.setBounds(444, 0, 386, 111);
		framefarmview.getContentPane();

		lblNewLabel_2 = new JLabel("Select Franchise");
		lblNewLabel_2.setBounds(447, 13, 116, 16);
		framefarmview.getContentPane().add(lblNewLabel_2);

		compcode = new JTextField();
		compcode.setBounds(864, 10, 61, 22);
		framefarmview.getContentPane().add(compcode);
		compcode.setColumns(10);

		btnFrPurchase = new JButton("Franchise Purchase");
		btnFrPurchase.setBounds(0, 271, 203, 25);
		framefarmview.getContentPane().add(btnFrPurchase);

		btnfrSale = new JButton("Franchise Sales");
		btnfrSale.setBounds(0, 294, 203, 25);
		framefarmview.getContentPane().add(btnfrSale);

		compname = new JTextField();
		compname.setBounds(548, 10, 315, 22);
		framefarmview.getContentPane().add(compname);
		compname.setColumns(10);

		btnStock = new JButton("Franchise Stock View");
		btnStock.setBounds(0, 320, 203, 25);
		framefarmview.getContentPane().add(btnStock);

		franchPanel.setLayout(null);

		ActionListener lscity = new btnCity();
		ActionListener lsstate = new btnstate();
		ActionListener lstaluka = new btnTaluka();
		ActionListener lscrop = new cropLsnr();
		ActionListener lsfarmer = new farmerLsnr();

		ActionListener dist = new btnDist();
		btnDist.addActionListener(dist);

		ActionListener dose = new doseLsnr();
		btnDose.addActionListener(dose);
		farmername.addActionListener(lsfarmer);
		cropname.addActionListener(lscrop);
		btnCity.addActionListener(lscity);
		btnTaluka.addActionListener(lstaluka);
		btnState.addActionListener(lsstate);

		ActionListener cropshw = new craftLsnr();
		btnshowCrop.addActionListener(cropshw);

		ActionListener frsale = new frsaleLsnr();
		btnfrSale.addActionListener(frsale);

		ActionListener frpur = new frpurLsnr();
		btnFrPurchase.addActionListener(frpur);

		ActionListener exprt = new exportLsnr();
		btnExport.addActionListener(exprt);

		ActionListener lscompname = new compnameLsnr();
		compname.addActionListener(lscompname);

		ActionListener lsstock = new frstockLsnr();
		btnStock.addActionListener(lsstock);

		decorate();

	}

	private void decorate() throws Throwable {
		new gnApp().setFrameTitel(framefarmview);
		vcomp = new gnComp().getCompanycode();
		vstore = new gnComp().getStorecode();
	}

	class compnameLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				new gnAdmin().setcompany(compcode, compname);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	class exportLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new Export_Table_Data_to_Excel().exportTable(table);
		}
	}

	class frpurLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				showData("FrPur");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	class frsaleLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				showData("FrSale");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	class frstockLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				showData("FrStock");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

	class doseLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				showData("FarmerCropDose");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class craftLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String vtype = "Crop";
			try {
				new gnAdmin().showMasterTable(vtype, cropcode, cropname);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class cropLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				showData("CropInfo");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	class farmerLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			String vname = farmername.getText().toString();
			vname = "%" + vname + "%";
			try {
				new gnSupplier().getCustomer(vname);
			} catch (Throwable e) {
				e.printStackTrace();
			} finally {
				farmrcode.setText(new gnSupplier().rcustcode);
				farmername.setText(new gnSupplier().rcustName);
				try {
					showData("Farmer");
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private String validatefarmer() {
		String status = "Sucess";
		if (farmrcode.getText().length() == 0) {
			new General().msg("Select Farmer To  View Data");
			farmername.grabFocus();
			status = "Fail";
		}
		return status;
	}

	class btnCity implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				showData("CityCrop");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	class btnDist implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				showData("DistCrop");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	class btnTaluka implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				showData("TalukaCrop");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	class btnstate implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				showData("StateCrop");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void showData(String vtype) throws ClassNotFoundException, SQLException {
		String col1[] = { "", "" };
		new gnTable().RemoveTableRows(model);
		if (vtype == "Farmer") {
			String status = validatefarmer();
			if (status == "Sucess") {
				String vfarmercode = farmrcode.getText();
				String col[] = { "Farmer", "Name", "Season", "Season Name", "Craft", "CraftName", "Land", "From",
						"ToMonth" };
				col1 = col;
				model.setColumnIdentifiers(col);
				String SQL = "call  farm_getFarmerCraftData(" + vcomp + " , " + vstore + ", '" + vfarmercode + "')";
				// new General().msg(SQL);
				rs = this.getSPResult(SQL);
				while (rs.next()) {
					model.insertRow(0,
							new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
									rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
									rs.getString(9) });
				}
			}
		}

		if (vtype == "CropInfo") {
			String vfarmercode = farmrcode.getText();
			String col[] = { "Farmer", "Phone", "Season", "CraftName", "Land", "From", "ToMonth" };
			col1 = col;
			model.setColumnIdentifiers(col);
			String SQL = "call  farmerinfoview(" + vcomp + " , " + vstore + ", '" + vtype + "')";
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				model.insertRow(0, new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7) });
			}
		}

		if (vtype == "FarmerCropDose") {
			String vfarmercode = farmrcode.getText();
			String vcropname = cropcode.getText();
			String col[] = { "Season", "Crop", "Item", "Content", "Qty", "Uom" };
			col1 = col;
			model.setColumnIdentifiers(col);
			String SQL = "call  farmerinfoview1(" + vcomp + " , " + vstore + ", '" + vtype + "' , " + vfarmercode
					+ "  , " + vcropname + ")";
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				model.insertRow(0, new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6) });
			}
		}

		if (vtype == "CityCrop") {
			String vfarmercode = farmrcode.getText();
			String col[] = { "City", "Farmer", "Phone", "Season", "CraftName", "Land", "From", "ToMonth" };
			col1 = col;
			model.setColumnIdentifiers(col);
			String SQL = "call  farmerinfoview(" + vcomp + " , " + vstore + ", '" + vtype + "')";
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				model.insertRow(0, new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		}

		if (vtype == "TalukaCrop") {
			String vfarmercode = farmrcode.getText();
			String col[] = { "Taluka", "Farmer", "Phone", "Season", "CraftName", "Land", "From", "ToMonth" };
			col1 = col;
			model.setColumnIdentifiers(col);
			String SQL = "call  farmerinfoview(" + vcomp + " , " + vstore + ", '" + vtype + "')";
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				model.insertRow(0, new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		}

		if (vtype == "DistCrop") {
			String vfarmercode = farmrcode.getText();
			String col[] = { "District", "Farmer", "Phone", "Season", "CraftName", "Land", "From", "ToMonth" };
			col1 = col;
			model.setColumnIdentifiers(col);
			String SQL = "call  farmerinfoview(" + vcomp + " , " + vstore + ", '" + vtype + "')";
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				model.insertRow(0, new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		}

		if (vtype == "StateCrop") {
			String vfarmercode = farmrcode.getText();
			String col[] = { "State", "Farmer", "Phone", "Season", "CraftName", "Land", "From", "ToMonth" };
			col1 = col;
			model.setColumnIdentifiers(col);
			String SQL = "call  farmerinfoview(" + vcomp + " , " + vstore + ", '" + vtype + "')";
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				model.insertRow(0, new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		}

		//
		if (vtype == "FrPur") {
			String vfarmercode = farmrcode.getText();
			vcomp = compcode.getText();
			vstore = compcode.getText();
			String col[] = { "Date", "item code", "Name", "Qty", "Pur Rate", "Total Amt", };
			col1 = col;
			model.setColumnIdentifiers(col);
			String SQL = "call  farmerinfoview(" + vcomp + " , " + vstore + ", '" + vtype + "')";
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				model.insertRow(0, new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6) });
			}
		}

		if (vtype == "FrSale") {
			String vfarmercode = farmrcode.getText();
			vcomp = compcode.getText();
			vstore = compcode.getText();
			String col[] = { "Date", "item code", "Name", "Qty", "SalesRate", "Total Amt", };
			col1 = col;
			model.setColumnIdentifiers(col);
			String SQL = "call  farmerinfoview(" + vcomp + " , " + vstore + ", '" + vtype + "')";
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				model.insertRow(0, new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6) });
			}
		}

		if (vtype == "FrStock") {
			String vfarmercode = farmrcode.getText();
			vcomp = compcode.getText();
			vstore = compcode.getText();
			String col[] = { "Finyear", "item code", "Name", "OpStock", "Purchase", "Sales", "PurchaseReturn",
					"SalesReturn", "Bal.Stock" };
			col1 = col;
			model.setColumnIdentifiers(col);
			String SQL = "call  farmerinfoview(" + vcomp + " , " + vstore + ", '" + vtype + "')";
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				model.insertRow(0, new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) });
			}
		}

		//

		table.setModel(model);
		JViewport prt6 = new JViewport();
		prt6.setToolTipText("Farmer ScrollPaneport");
		prt6.setScrollMode(0);
		prt6.add(table, col1);
		jsp.setViewport(prt6);
		jsp.setVisible(true);
		// new General().removeRow(model, table);
		// Selectrow( );
	}
}// Last

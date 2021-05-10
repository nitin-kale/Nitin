package RetailProduct;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTextPane;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import com.businessrefinery.barcode.Barcode;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BarcodeMapping extends getResultSet {

	JFrame frameBarcodeMapping;
	private JTextField barcode;
	JTextField name;
	JTextField articlecode;
	JButton btnSave;
	JButton btnRemove;
	JButton btnBarcode;
	JButton btnClose;
	JScrollPane jsp;
	JButton btnshow;
	String barcodefor;

	String col[] = { "Article", "Barcode" };
	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	private JLabel lblNewLabel_5;
	private JTextField qty;
	private JLabel lblNewLabel_6;
	private JTextField mrp;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BarcodeMapping window = new BarcodeMapping();
					window.frameBarcodeMapping.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BarcodeMapping() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameBarcodeMapping = new JFrame();
		frameBarcodeMapping.setAlwaysOnTop(true);
		frameBarcodeMapping.setBounds(325, 20, 450, 529);
		frameBarcodeMapping.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameBarcodeMapping.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setIcon(new ImageIcon(BarcodeMapping.class.getResource("/RetailProduct/barcode.gif")));
		lblNewLabel.setBounds(0, 0, 206, 38);
		frameBarcodeMapping.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("BARCODE MAPPING");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1.setBounds(208, 3, 199, 31);
		frameBarcodeMapping.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Search By Name");
		lblNewLabel_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_2.setBounds(46, 88, 142, 16);
		frameBarcodeMapping.getContentPane().add(lblNewLabel_2);

		articlecode = new JTextField();
		articlecode.setBackground(Color.WHITE);
		articlecode.setEditable(false);
		articlecode.setBounds(307, 104, 70, 30);
		frameBarcodeMapping.getContentPane().add(articlecode);

		name = new JTextField();
		name.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		name.setToolTipText("Press Enter to Search Item");
		name.setBounds(46, 104, 262, 30);
		frameBarcodeMapping.getContentPane().add(name);

		JLabel lblNewLabel_3 = new JLabel(" ");
		lblNewLabel_3.setIcon(new ImageIcon(BarcodeMapping.class.getResource("/RetailProduct/Anim3.gif")));
		lblNewLabel_3.setBounds(10, 47, 410, 31);
		frameBarcodeMapping.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("BARCODE");
		lblNewLabel_4.setForeground(new Color(0, 0, 102));
		lblNewLabel_4.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 13));
		lblNewLabel_4.setBounds(45, 135, 143, 16);
		frameBarcodeMapping.getContentPane().add(lblNewLabel_4);

		// barcode = new JTextField();
		barcode = new gnRoundTextField(20);
		barcode.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		barcode.setToolTipText("Enter Your Barcode Here");
		barcode.setBounds(46, 152, 328, 30);
		frameBarcodeMapping.getContentPane().add(barcode);
		barcode.setColumns(10);

		btnshow = new JButton(" ");
		btnshow.setBackground(Color.WHITE);
		btnshow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnshow.setBounds(10, 251, 395, 58);
		frameBarcodeMapping.getContentPane().add(btnshow);

		jsp = new JScrollPane();
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBounds(0, 347, 432, 137);
		frameBarcodeMapping.getContentPane().add(jsp);

		// btnSave = new JButton("Save");
		btnSave = new gnRoundButton("Save");
		btnSave.setBackground(Color.WHITE);
		btnSave.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btnSave.setMnemonic('S');
		btnSave.setBounds(0, 315, 108, 25);
		frameBarcodeMapping.getContentPane().add(btnSave);

		// btnClose = new JButton("Close");
		btnClose = new gnRoundButton("Close");
		btnClose.setBackground(Color.WHITE);
		btnClose.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClose.setMnemonic('C');
		btnClose.setBounds(247, 315, 130, 25);
		frameBarcodeMapping.getContentPane().add(btnClose);

		qty = new JTextField();
		qty.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		qty.setText("0");
		qty.setBounds(74, 188, 49, 35);
		frameBarcodeMapping.getContentPane().add(qty);
		qty.setColumns(10);

		lblNewLabel_6 = new JLabel("Rate");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(159, 195, 42, 16);
		frameBarcodeMapping.getContentPane().add(lblNewLabel_6);

		mrp = new JTextField();
		mrp.setFont(new Font("Arial Narrow", Font.PLAIN, 17));
		mrp.setText("0");
		mrp.setBounds(203, 188, 130, 35);
		frameBarcodeMapping.getContentPane().add(mrp);
		mrp.setColumns(10);

		// btnRemove = new JButton("Delete ");
		btnRemove = new gnRoundButton("Delete ");
		btnRemove.setBackground(Color.WHITE);
		btnRemove.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btnRemove.setBounds(117, 315, 118, 25);
		frameBarcodeMapping.getContentPane().add(btnRemove);

		// panel = new JPanel();
		panel = new gnRoundPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 76, 410, 153);
		frameBarcodeMapping.getContentPane().add(panel);
		panel.setLayout(null);

		lblNewLabel_5 = new JLabel("Qy");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(26, 121, 29, 16);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Code");
		lblNewLabel_7.setBounds(297, 13, 56, 16);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Scan Barcode Here ");
		lblNewLabel_8.setBounds(119, 58, 151, 16);
		panel.add(lblNewLabel_8);

		btnBarcode = new JButton("Generate Barcode");
		btnBarcode.setVisible(false);
		btnBarcode.setBounds(206, 227, 199, 25);
		frameBarcodeMapping.getContentPane().add(btnBarcode);
		btnBarcode.setBackground(Color.WHITE);
		btnBarcode.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 14));
		btnBarcode.setMnemonic('B');
		
		JButton btnCheckEan = new JButton("Check Duplicate BARCODE");
		btnCheckEan.setBounds(10, 227, 199, 25);

		duplicateLsnr  barcodeDuplicate = new duplicateLsnr();
		btnCheckEan.addActionListener(barcodeDuplicate);

		
		frameBarcodeMapping.getContentPane().add(btnCheckEan);

		ActionListener nm = new lsnritemName();
		name.addActionListener(nm);

		ActionListener btnrmv = new rmvLsnr();
		btnRemove.addActionListener(btnrmv);

		ActionListener barcod = new barcodeLsnr();
		barcode.addActionListener(barcod);

		ActionListener btn = new btnListener();
		btnClose.addActionListener(btn);
		btnSave.addActionListener(btn);
		btnBarcode.addActionListener(btn);
		decorate();
	}

	
	
	private void decorate() {

		// btnBarcode.setVisible(false);
		new gnDecorate().decorateBtn(btnSave, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnClose, Color.darkGray, Color.WHITE);
		new gnDecorate().decorateBtn(btnRemove, Color.darkGray, Color.WHITE);

		articlecode.setText(varticlecode);
		name.setText(this.varticlename);
	}

	class lsnritemName implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String value = e.getActionCommand();
			int i = e.getID(); // Field id
			String sname = name.getText().trim();
			sname = "%" + sname + "%";
			try {
				String vtype = "Article";
				String varticle1 = "";
				String vtrantype1 = "ALL";
				// new gnAdmin().Search(vtype, sname, varticle1, vtrantype1);
				new gnAdmin().articleNameSearch(sname, articlecode, name);
			} catch (SQLException e1) {
				new General().msg(e1.getLocalizedMessage());
			} catch (ClassNotFoundException e1) {
				new General().msg(e1.getLocalizedMessage());
			} catch (Throwable e1) {
				new General().msg(e1.getLocalizedMessage());
			} finally {
				try {
					articlecode.setText(new gnAdmin().rArticle);
					name.setText(new gnAdmin().rArticlename);
				} catch (Throwable e1) {
					new General().msg(e1.getLocalizedMessage());
				} finally {
					try {
						showArticleEanData();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}

	class duplicateLsnr implements ActionListener {
 		@Override
		public void actionPerformed(ActionEvent arg0) {
  			try {
 				showDuplicateBarcode() ;
			} catch (ClassNotFoundException | SQLException e) {
	 			e.printStackTrace();
			}
		}
 	}
	
	private void showDuplicateBarcode() throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		String varticle = articlecode.getText();
		String vcomp = compcode;
			//new General().Quickmsg("Checking Duplicate Barcode");
 		    String col[] = {"Barcode" , "Count" } ;
			String SQL = "select ean_code, count(article_code) from ms_ean_master "
					+ " group by ean_code "
					+ " having count(article_code) >1   ";
 			new gnTableModel().Tablemodel(table, model, SQL, col, 2, "N", "N", "N");
			new gnTable().setTableBasics(table);
			JViewport prt = new JViewport();
			prt.add(table, col);
			prt.setVisible(true);
			prt.setBackground(Color.WHITE);
			jsp.setViewport(prt);
			
			int  row =  table.getRowCount() ;
			if (row == 0 )
			{
				 new General().Quickmsg("No Duplicate Records ... :");
			}
			// removeRow(model , table) ;
  	}

	
	
	private void showArticleEanData() throws ClassNotFoundException, SQLException {
		new gnTable().RemoveTableRows(model);
		String varticle = articlecode.getText();
		String vcomp = compcode;
		if (varticle.length() > 0) {
			String SQL = "Call barcode_getBArcodeInfo(" + vcomp + " , " + varticle + ")";
			new gnTableModel().Tablemodel(table, model, SQL, col, 2, "N", "N", "N");
			new gnTable().setTableBasics(table);
			JViewport prt = new JViewport();
			prt.add(table, col);
			prt.setVisible(true);
			prt.setBackground(Color.WHITE);
			jsp.setViewport(prt);
			// removeRow(model , table) ;
			selectRow();
		}
	}

	class rmvLsnr implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			try {
				removeBarcode();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void removeBarcode() throws SQLException, ClassNotFoundException {
		String varticle = articlecode.getText();
		String vbarcode = barcode.getText().trim();
		String SQL = "Delete from ms_ean_master where Article_code = " + varticle + "  and ean_code = " + vbarcode
				+ " ";
		this.getResult(SQL);
		showArticleEanData();
		new General().Quickmsg("Barcode Removed...");
		;
	}

	private void selectRow() {
		table.requestFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				// String Col[] = { "Company", "Fin.Year", "Start Date" , "End
				// Date" , "Cur.Fin.Yr" } ;
				barcode.setText(table.getValueAt(row, 1).toString());
				articlecode.setText(table.getValueAt(row, 0).toString());
				String vname = "NAME" ;
				String varticle = articlecode.getText();
				try {
					String vvname = new gnArticle().Article_getData(varticle, vname) ;
					name.setText(vvname);
				} catch (ClassNotFoundException | SQLException e1) {
 					e1.printStackTrace();
				}
 			}
 		});
	}

	public void removeRow(DefaultTableModel model, JTable table) {
		TableColumn Del = table.getColumnModel().getColumn(0);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setText("Remove");
		chkbox.setVisible(true);
		chkbox.setOpaque(true);
		chkbox.setToolTipText("Remove Row ");
		chkbox.setSelected(true);
		Del.setCellEditor(new DefaultCellEditor(chkbox));
		TableCellRenderer hdr = Del.getHeaderRenderer();
		table.getColumnModel().setColumnMargin(1);
		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int nn = e.getStateChange();
				if (nn == 2 && model == model) {
					int lastrow = table.getRowCount();
					int r = table.getSelectedRow();
					int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
					if (option == 0) {
						model.removeRow(r);
						// resetFigures();
						// scanItem.grabFocus();
						new gnLogger().loggerInfoEntry("GRN", "Item Removed");
					}
					return;
				}
			}
		});
	}

	class barcodeLsnr implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				show();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void show() throws Exception {
		// BarcodeFactory ft = new BarcodeFactory();g
		btnshow.setIcon(null);
		barcodefor = barcode.getText();
		Barcode barcode = new Barcode();
		barcode.setDisplayText(true);
		barcode.setCode(barcodefor);
		barcode.drawImage2File("D://barcode.gif");
		barcode.setBarcodeHeight(25);
		barcode.setBarcodeWidth(35);
		barcode.setBarcodeUnit(100);
		// new General().msg("Barcode Generated ...");
		btnshow.setIcon(new ImageIcon("D://barcode.gif"));
 		showEanDetails();
 	}

	private void showEanDetails() throws ClassNotFoundException, SQLException
	{
		String vbarcode = barcode.getText().trim() ;
 		String SQL = "Select Article_code, Ean_code from ms_Ean_master where  ean_code = "+vbarcode+"";
 		new gnTableModel().Tablemodel(table, model, SQL, col, 2, "N", "N", "N");
		new gnTable().setTableBasics(table);
		JViewport prt = new JViewport();
		prt.add(table, col);
		prt.setVisible(true);
		prt.setBackground(Color.WHITE);
		jsp.setViewport(prt);
		// removeRow(model , table) ;
		selectRow();
 	}
	
	
	
	class btnListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String value = e.getActionCommand();
			String status = "";

			if (value == "Save") {
				try {
					status = validate();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				if (status == "Sucess") {
					try {
						saveAction();
					} catch (ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					} catch (Throwable e1) {
						e1.printStackTrace();
					}
				}
			}

			if (value == "Close") {
				frameBarcodeMapping.dispose();
			}

			if (value == "Generate Barcode") {
				try {
					GenerateAndPrint();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				} catch (Throwable e1) {
					e1.printStackTrace();
				}
			}

		}
	}

	private String validate() throws ClassNotFoundException, SQLException {
		String status = "Sucess";
		String varticlecode = articlecode.getText();
		String vbarcode = barcode.getText();

		if (articlecode.getText().length() == 0) {
			status = "Fail";
			new General().msg("Please Select Article ..");
			name.grabFocus();
		}

		if (barcode.getText().length() == 0) {
			status = "Fail";
			new General().msg("Please Enter Barcode  ..");
			barcode.grabFocus();

		}

		String result = new gnApp().checkEancode(varticlecode, vbarcode);
		if (result == "Fail") {
			status = "Fail";
			new General().msg("Please Check Barcode   ..");

		}
		return status;
	}

	private String saveAction() throws Throwable {

		// new General().Quickmsg("Saving Data ...");
		String status = "Sucess";
		prst = null;
		final int batchSize = 5;
		int TotalRecordinsert = 0;
		Connection con = this.getConnection();
		con.setAutoCommit(false);
		String varient = "Insert into   ms_ean_master(Article_code , " + "Ean_code, Active,  salesPrice , mrp ,  cost )"
				+ "values(?,?,?,?,?,?)";
		try {
			prst = con.prepareStatement(varient);
			prst.setString(1, articlecode.getText());
			prst.setString(2, barcode.getText());
			prst.setString(3, "Y");
			prst.setString(4, mrp.getText());
			prst.setString(5, mrp.getText());
			prst.setString(6, mrp.getText());
			prst.addBatch();
			TotalRecordinsert = TotalRecordinsert + 1;
			if (++TotalRecordinsert % batchSize == 0) {
				prst.executeBatch();
				status = "Sucess";
				con.commit();
			}
			prst.executeBatch(); // insert remaining records
			con.commit();
			status = "Sucess";
			new General().Quickmsg("Data Saved Status -->Sucess...");
		} // try

		catch (SQLException e) {
			new General().msg("Barcode-->" + " " + e.getMessage());
			con.rollback();
			status = "Fail";
		} finally {
			if (prst != null) {
				prst.close();
			}
			if (con != null) {
				con.close();
			}
			reset();
			return status;
		}
	}

	private void reset() {
		barcode.setText(null);
		articlecode.setText(null);
		mrp.setText("0");
		qty.setText("0");
		name.setText(null);
	}

	private void GenerateAndPrint() throws Throwable {
		String vqty = qty.getText();
		String vmrp = mrp.getText();
		String vname = name.getText();
		String vadr1 = "";
		String vadr2 = "";
		String vadr3 = "";
		String vadr4 = "";
		String vphone = "";
		String vemail = "";
		String vpksize = new gnArticle().Article_getData(articlecode.getText(), "PACKSIZE");
		String vuom = new gnArticle().Article_getData(articlecode.getText(), "UOM");
		String vpackdate = new gnConfig().date_ConverttoDBforamt(new General().getDate());
		String vmon = new gnDate().getMonthName(new General().getDate());
		String vyear = new gnDate().getYear(new General().getDate());
		String vsite = new gnConfig().getStoreName();
		String vparent = "";
		String vbrand = "";
		String vcontent = "";
		String vsp = mrp.getText();
		String vexpdate = "2012.02.02";

		// new General().msg(vmon);
		String SQL = "call printBarcodeData(" + barcodefor + " , '" + vname + "'  , " + vmrp + " , " + vqty + " , '"
				+ vsite + "'  , '" + vadr1 + "' , '" + vadr2 + "' ," + " '" + vadr3 + "' , '" + vadr4 + "' , '" + vphone
				+ "' ,'" + vemail + "' ,'" + vpksize + "' ,'" + vuom + "' , '" + vmon + "' , '" + vyear + "' ," + "   '"
				+ vparent + "'  ,  '" + vbrand + "' , '" + vcontent + "'  , '" + vpackdate + "' , " + vsp + " , '"
				+ vexpdate + "')";
		// new General().msg(SQL);
		this.getSPResult(SQL);
		gnPrintMasters br = new gnPrintMasters();
		br.print(new gnApplicationSetting().PrintBarcodeFrmat);
	}
}// Last

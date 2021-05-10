package RetailProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JWindow;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.MaskFormatter;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalINIConfiguration;
import org.apache.commons.configuration.SubnodeConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import com.mysql.fabric.xmlrpc.base.Data;
import com.sun.glass.events.WindowEvent;
import com.toedter.calendar.JDateChooser;

 
import javafx.embed.swing.JFXPanel;

//<UtilDateModel> 
public class General extends getResultSet {

	JFrame MessageFrame;
	public static String mydrive;
	public JWindow mywindow;
	public static String rArticle = " ";
	public static String rArticlename = " ";

	JPanel panel;
	private JTable table;
	public static JFrame frame;

	private static JOptionPane pane;
	private JTable ptable;

	// private JFrame frame ;
	public static JFrame frame1;
	public static JDialog dialog;
	public static JDialog dialog1;
	static final JPanel contentPanel = new JPanel();
	JLabel lbl = new JLabel();
	private Calendar cl;
	public int keyno;
	public static JEditorPane edp;
	JViewport prt = new JViewport();
    JScrollPane jsp = new JScrollPane() ;
 
	/**
	 * @throws MalformedURLException
	 * @wbp.parser.entryPoint
	 */
	
	public void delTableRow(JTable table ,  DefaultTableModel model ) {
		InputMap imap = ((JComponent) table).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
	    imap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "delAction");
		ActionMap amap = ((JComponent) table).getActionMap();
	    amap.put("delAction", new AbstractAction() {
		public void actionPerformed(ActionEvent e) {
 			try {
 				int row = table.getSelectedRow() ;
  				model.removeRow(row);
  			} catch (Throwable e1) {
				e1.printStackTrace();
			}
		}
	});
}

	
	public void msg(String msg) {
		dialog1 = new JDialog();
		JButton btn = new JButton();
		new gnBackground().setBackground(btn);
		btn.setIcon(new ImageIcon(DayBegin.class.getResource("/RetailProduct/panel.png")));
		btn.setBounds(0, 0, 400, 700);
		dialog1.add(btn);
		contentPanel.setBackground(Color.BLACK);
		lbl.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\nk\\myicon.icon"));
		lbl.setText(msg);
		lbl.setBackground(new Color(112, 0, 112));
		new gnFontSetting().setMyFontBold(lbl, "F1", 15);
		lbl.setForeground(new Color(0, 0, 121));
		contentPanel.add(lbl);
		dialog1.getContentPane().add(contentPanel);
		dialog1.setBackground(Color.BLACK);
		dialog1.setDefaultLookAndFeelDecorated(true);
		dialog1.setAlwaysOnTop(true);
		dialog1.setBackground(new Color(112, 0, 112));
		dialog1.setForeground(Color.WHITE);
		dialog1.setFont(new Font("Calibri", Font.BOLD, 14));

		ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
		s.schedule(new Runnable() {
			public void run() {
				dialog1.setVisible(false); // should be invoked on the EDT
				dialog1.dispose();
			}
		}, 50000, TimeUnit.MILLISECONDS);
		JOptionPane.showMessageDialog(dialog1, lbl);
	}


	public String checkDateLength(String vdate, String varticle, int row) {
		String status = "Sucess";
		if (vdate.length() != 10) {
			new General().msg("Please Enter Correct Expiry Date In Format <<MM.DD.YYYY>> for article  " + varticle
					+ "  At Line " + row);
			status = "Fail";
		}
		return status;
	}

	public void updateLKeyProcess(String vcomp, String vstore, String vcode)
			throws SQLException, ClassNotFoundException, IOException {
		String mycode1 = vcode;
		String mycode2 = vcode;
		String myscode = "";
		String myccode = "";
		String mystatus = getValidateKeyParameter(mycode1, vstore);
		if (mystatus == "Sucess") {
			mycode1 = new General().getcode(mycode1);
			myscode = new General().convertPassword(mycode1);
			myccode = new General().convertPassword(mycode2);
 		}
		String SQL = str1 + "  '" + myccode + "' where company_code = '" + vcomp + "' ";
		String SQL1 = str2 + "  '" + myscode + "' where company_code = '" + vcomp + "'  and site_code =" + vstore + " ";
		this.getResult(SQL);
		this.getResult(SQL1);
		new General().msg("Updated Sucessfully..");
	}

	public void updateLKeyExpProcess(String vcomp, String vstore, String vexp)
			throws SQLException, ClassNotFoundException, IOException {
		String myexp = vexp;
		// myexp = new gnConfig().date_ConverttoDBforamt(myexp) ;
		new gnlcoalsqliconnection().updateexpdate(vcomp, vstore, myexp);

	}

	public String getcode(String vcode) {
		vcode = vcode + vbaseseq;
		return vcode;
	}

	public String checkProduct(String vcomp, String vstore) throws ClassNotFoundException, SQLException, IOException {
		String status = "Fail";
		String vkey = new gnlcoalsqliconnection().getVerifyKeyForStore(vcomp, vstore);
		switch (vkey) {
		case "Sucess":
			try {
				status = new checkLicence().alert1(new gnlcoalsqliconnection().getVerifyExpKeyForStore(vcomp, vstore));
			} catch (Throwable e) {
				e.printStackTrace();
			}
			break;
		}
		return status;
	}

	public String getValidateKeyParameter(String mylickey, String vcompcode) {
		String vpara = "Y";
		String status = "Sucess";
		if (vpara == "Y") {
			String vlickey = mylickey;
			if (vlickey.length() != 27) {
				new General().msg("Please Check Product KeyL..");
				status = "Fail";
			}
			String vcmp = vlickey.substring(16, 20);
			if (!vcmp.equals(vcompcode)) {
				new General().msg("Please check Product KeyC ..");
				status = "Fail";
			}
		}
		return status;
	}

	public String convertPassword(String vname) throws SQLException, ClassNotFoundException, IOException {
		String result = " ";
		conn = this.getConnection();
		st = conn.createStatement();
		String SQL = " select     " + vaccount + "('" + vname + "')  from dual";
		rs = st.executeQuery(SQL);
		rs.next();
		result = rs.getString(1);
		result = EncrypttWithLogic(result);
		// String result = new test9().getCode(vname);
		// new General().msg(result);
		return result;
	}

	private String EncrypttWithLogic(String pass) {

		MessageDigest md;
		try {
			md = MessageDigest.getInstance(vcodetype);
			md = MessageDigest.getInstance(vcodetype1);
			byte[] passBytes = pass.getBytes();
			md.reset();
			byte[] digested = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < digested.length; i++) {
				sb.append(Integer.toHexString(0xff & digested[i]));
			}
			return sb.toString();
		} catch (Exception ex) {
			msg(ex.getLocalizedMessage());
		}
		return null;
	}

	public String checkCompCreatepermission() {
		String status = "Fail";
		if (myvcomp.trim().equals(vdemocomp) & (ucode.trim().equals(vadmin))) {
			status = "Sucess";
		} else {
			status = "Fail";
			new General().msg("You don't have permission to create  <<New Object>>. Please Contact us..");
		}
		return status;
	}

	public String checkSiteCreatepermission() {
		String status = "Fail";
		if (myvcomp.trim().equals(vdemocomp) & (ucode.trim().equals(vadmin))) {
			status = "Sucess";
		} else {
			status = "Fail";
			new General().msg("You Don't Have Permission To Create New Company...");
		}
		return status;
	}

	public void showCalc() throws IOException {

		Calculator cl = new Calculator();
		try {
			cl.Calc();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getDateChooserdate(JDateChooser vdate11) {
		String vdate1 = null;
		// if (inoutdategetDate().toString().length()>0)
		if (vdate11.getDate().toString().length() > 0) {
			Date vdate = (vdate11.getDate());
			if (vdate.toString().length() > 0) {
				SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
				vdate1 = ft.format(vdate);
			}
		}
		return vdate1;
	}

	public String checkDateFormat(String vdate, String varticle, int row) {
		String status = "Sucess";
		if ((!vdate.substring(2, 3).equals(".")) && (!vdate.substring(5, 6).equals("."))) {
			status = "Fail";
			new General()
					.msg("Please Enter Date in  DD.MM.YYYY Format for article   " + varticle + "   At Line " + row);
		}
		return status;
	}

	public String checkValidBatch(String vbatchno, String varticle, int row) {
		String status = "Sucess";
		if (vbatchno.equals("0") || vbatchno.length() == 0) {
			new General().msg("Please Enter Correct Batch No For Batch Articles  " + varticle + "    At Line  " + row);
			status = "Fail";
		}
		return status;
	}

	public String checkDrivePath() {
		String Dstatus = "Fail";
		String Estatus = "Fail";
		String Fstatus = "Fail";
		String Cstatus = "Fail";
 		String status = "Fail";

		
		File CDriveHomePath = new File("C://ConfigApplicationDrive.ini");
		if (CDriveHomePath.exists()) {
			// msg("Error-001: Drive Mapping File Missing.....");
			Cstatus = "Sucess";
		}

		
		
		File DriveHomePath = new File("D://ConfigApplicationDrive.ini");
		if (DriveHomePath.exists()) {
			// msg("Error-001: Drive Mapping File Missing.....");
			Dstatus = "Sucess";
		}

		File EDriveHomePath = new File("E://ConfigApplicationDrive.ini");
		if (EDriveHomePath.exists()) {
			// msg("Error-001: Drive Mapping File Missing.....");
			Estatus = "Sucess";
		}

		File FDriveHomePath = new File("F://ConfigApplicationDrive.ini");
		if (FDriveHomePath.exists()) {
			// msg("Error-001: Drive Mapping File Missing.....");
			Fstatus = "Sucess";
		}

		if (Cstatus == "Sucess" || Fstatus == "Sucess" || Estatus == "Sucess" || Dstatus == "Sucess") {
			status = "Sucess";
			new gnLogger().loggerInfoEntry("General- Checking for Application Conf. File Found ", status);
		}

		return status;
	}

	public String SetApplicationDriveInfo() throws ConfigurationException {
		String status = "Fail";
		String vdrive = "";
		File myfileD = new File("D://ConfigApplicationDrive.ini");
		File myfileE = new File("E://ConfigApplicationDrive.ini");
		File myfileF = new File("F://ConfigApplicationDrive.ini");
		File myfileC = new File("C://ConfigApplicationDrive.ini");

		

		if (myfileC.exists()) {
			vdrive = "C:";
			status = initiateDriveinfo(vdrive);
		}

		
		if (myfileD.exists()) {
			vdrive = "D:";
			status = initiateDriveinfo(vdrive);
		}

		if (myfileE.exists() && status == "Fail") {
			vdrive = "E:";
			status = initiateDriveinfo(vdrive);
		}

		if (myfileF.exists() && status == "Fail") {
			vdrive = "F:";
			status = initiateDriveinfo(vdrive);
		}

		return status;
	}

	private String initiateDriveinfo(String vdrive) throws ConfigurationException {

		String vset = "Fail";
		ApplicationDrivename = "";
		String iniApplicationDrive = vdrive + "//ConfigApplicationDrive.ini";
		new gnLogger().loggerInfoEntry("Application  Drive Config File ..", iniApplicationDrive);
		// String iniApplicationDrive = "d://ConfigApplicationDrive.ini" ;
		HierarchicalINIConfiguration iniConfObj = new HierarchicalINIConfiguration(iniApplicationDrive);
		Set setOfSections = iniConfObj.getSections();
		Iterator sectionNames = setOfSections.iterator();
		while (sectionNames.hasNext()) {
			String sectionName = sectionNames.next().toString();
			SubnodeConfiguration sObj = iniConfObj.getSection(sectionName);
			Iterator it1 = sObj.getKeys();
			while (it1.hasNext()) {
				Object key = it1.next();
				switch (key.toString()) {
				case "ApplicationDrive":
					ApplicationDrivename = sObj.getString(key.toString());
					mydrive = ApplicationDrivename;
					vset = "Sucess";
					new gnLogger().loggerInfoEntry("General-   Application Drive Set  to ApplicationDrivename", vset);
					//new General().msg("General- Application Drive Set to ApplicationDrivename -->"+ vset);
					break;
				}
			}
		}
		// Quickmsg( mydrive +" Drive Mapping Process -->."+ vset);
		return vset;
	}

	public String checkJavaPath() {
		String status = "Sucess";
		String HomePath = null;
		vname = ApplicationDrivename + "AKN\\";
		HomePath = vname;
		if (HomePath == null) {
			new gnLogger().loggerInfoEntry("Application Folder AKN  Missing On Selected Drive Please Check On Drive ..",
					ApplicationDrivename);
			msg("Application Folder AKN  Missing On Selected Drive Please Check On Drive .." + ApplicationDrivename);
			status = "Fail";
		}

		File f = new File(HomePath);
		if (!f.exists()) {
			new gnLogger().loggerInfoEntry("Application Folder AKN  Missing On Selected Drive Please Check On Drive ..",
					ApplicationDrivename);
			msg("Application Folder AKN  Missing On Selected Drive Please Check On Drive .." + ApplicationDrivename);
			status = "Fail";
		}

		if (f.exists()) {
			f = new File(f, "bin");
			configFilePath = f.toString();
			f = new File(f, "my" + vfilename1 + ".ini");

			// new General().msg("ConfigFile is "+ ">>:" + ""+f);
			new gnLogger().loggerInfoEntry("ConfigFile is  Found..>>", f.toString());

			File f5 = new File(HomePath);
			f5 = new File(f5, "bin");
			f5 = new File(f5, "v" + vfilename2 + ".db");
			// new General().msg( "In General checkJavapath"+ "file:" + ""+f5);
			if (!f.exists() || !f5.exists()) {
				msg("Error-002 <<GeneralCheckFolder Path>> :Setup File Missing Please Check...");
				status = "Fail";
				System.exit(0);
			}
			localsqlPath = f5.toString();
			configFilePath = f.toString();
			File F10 = new File("D://MeretooERP", "src");
			F10 = new File(F10, "setup");
			if (F10.exists()) {
				RemoveFolder(F10.toString());
			}
		}

		return status;
	}

	public void RemoveFolder(String folder) {
		File Myfolder = new File(folder);
		String mysetupFolede = Myfolder.toString();
		try {
			FileUtils.deleteDirectory(Myfolder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	///

	private static void copyFile(File sourceFile, File destFile) throws IOException {
		if (!sourceFile.exists()) {
			return;
		}
		if (!destFile.exists()) {
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		source = new FileInputStream(sourceFile).getChannel();
		destination = new FileOutputStream(destFile).getChannel();
		if (destination != null && source != null) {
			destination.transferFrom(source, 0, source.size());
		}
		if (source != null) {
			source.close();
		}
		if (destination != null) {
			destination.close();
		}

	}

	///

	public void showimage() throws MalformedURLException {
		// URL url = new URL("D://AKN//myProductImage//nat1.gif");
		// new General().msg("url "+""+url);

		Image image = Toolkit.getDefaultToolkit().createImage("D://AKN//myProductImage//p1.gif");
		ImageIcon spinIcon = new ImageIcon(image);
		JOptionPane.showMessageDialog(null, new JLabel(spinIcon));

		// create a static version of this icon
		BufferedImage bi = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bi.getGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
		ImageIcon staticIcon = new ImageIcon(bi);

		JButton button = new JButton(staticIcon);
		button.setRolloverIcon(spinIcon);
		JOptionPane.showMessageDialog(null, button);
	}

	public String getTime() throws SQLException, ClassNotFoundException {
		String vtime = " ";
		String SQL = "Call   time_GetTime()";
		rs = this.getSPResult(SQL);
		rs.next();
		vtime = rs.getString(1);
		rs.close();
		this.closeconn();
		return vtime;
	}

	public static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}

	public String chekcBatchControl(String varticle) throws ClassNotFoundException, SQLException {
		String value = " ";
		String SQL = "call  article_checkBatchArticle(" + varticle + ")";
		rs = this.getSPResult(SQL);
		if (rs.next())
			;
		{
			value = rs.getString(2);
			rs.close();
			this.closeconn();

		}
		return value;
	}

	public String checkLength(String fname, int ln) {
		String Result = "Pass";
		if (fname.length() > ln) {
			Result = "Fail";
			new General().msg("Length of field " + fname + "is not allow more then" + ln);
		}
		return Result;
	}

	public void Authentication() {
		String returnValue;
		Authorize abc = new Authorize();
		abc.frameauth.setVisible(true);

	}

	public MaskFormatter FieldFormat() throws ParseException {
		NumberFormat num = new DecimalFormat("###,###");
		MaskFormatter mf3 = new MaskFormatter("(###) ###-####");
		MaskFormatter mf2 = new MaskFormatter("####");
		MaskFormatter AmountFM = new MaskFormatter("#,##,###,###,##.##");
		DefaultFormatter mf1 = new MaskFormatter("##-##-####");
		((MaskFormatter) mf1).setPlaceholderCharacter('_');
		DateFormat format = new SimpleDateFormat("m/d/yyyy");
		return mf2;
	}

	public String TransactionSearchCando(JTable table) {
		String Action = "'No";
		int row = table.getRowCount();
		if (row == 0) {
			Action = "Yes";
		}
		return Action;
	}

	public String getSelectedButton(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}

	public MaskFormatter getNumberFormat() throws ParseException {
		NumberFormat num = new DecimalFormat("####");
		MaskFormatter mf2 = new MaskFormatter("####");
		MaskFormatter mobile = new MaskFormatter("##########");

		return mf2;
	}

	public NumberFormat getDecimalFormat() throws ParseException {
		NumberFormat num = new DecimalFormat("####.##");
		NumberFormat abc = num;
		return num;
	}

	public String setDate(JTextField Field) throws SQLException, ClassNotFoundException {
		Date dt = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd");
		String Vdate = ft.format(dt);
		Vdate = new gnConfig().Date_convertToApplformat(Vdate);
		Field.setText(Vdate);
		return Vdate;

	}

	public void removeRow(DefaultTableModel model, JTable table) { /// This is
 		TableColumn Del = table.getColumnModel().getColumn(0);
		JCheckBox chkbox = new JCheckBox();
		chkbox.setText("Remove Row");
		chkbox.setVisible(true);
		chkbox.setOpaque(true);
		chkbox.setToolTipText("Del Row ");
		chkbox.setSelected(true);
		Del.setCellEditor(new DefaultCellEditor(chkbox));
		chkbox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int nn = e.getStateChange();
				if (nn == 2 && model == model) {
					int lastrow = table.getRowCount();
					int r = table.getSelectedRow();
					int option = new General().msgInput("Row Will be Deleted,  Are You Sure ?");
					if (option == 0) {
						model.removeRow(r);
					}
					return;
				}
			}
		});
	}

	public void msgsearchnotused(JScrollPane jsp, JTable vtable, String vtext, int x, int y) {
		
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBackground(Color.white);
		jsp.setPreferredSize(new Dimension(x, y));
		jsp.setBorder(BorderFactory.createRaisedBevelBorder());
		jsp.setFocusable(true);
		table = null;
		table = new JTable();
		table = vtable;
		table.requestFocus();
		table.setFocusable(true);
		table.grabFocus();
		new gnFontSetting().setMyFont(table, "F2", 14);
		prt.setBackground(Color.WHITE);
		prt.add(table);
		table.setFocusable(true);
		prt.setVisible(true);
		jsp.setViewport(prt);
		table.grabFocus();

		int row = table.getRowCount();
		if (row > 0) {
			String choice = "O";
			switch (choice) {
			case "O":
				// new gnField().pressTabKey(table) ;
				mywindow = new JWindow();
				JButton b = new JButton("click");
				mywindow.getContentPane().setLayout(null);
				mywindow.add(b);
				// setsize of window
				mywindow.setSize(x + 100, y + 100);
				// set visibility of window
				mywindow.setVisible(true);
				// set location of window
				mywindow.setLocation(100, 100);
				// mywindow.setBounds(100,100, x+100, y+100);
				table.grabFocus();
				mywindow.add(jsp);
				mywindow.setAlwaysOnTop(true);
				mywindow.setAutoRequestFocus(true);
				mywindow.setBackground(Color.white);
				// pane.showMessageDialog(dialog, jsp ,vtext,1);
				mywindow.add(jsp);
				mywindow.setVisible(true);
				table.grabFocus();
				SelectArticlerow();
				break;
			}
		} else {
			new General().Quickmsg("!!!!! No Record Found...!!!!!");
		}
	}

	public void msgsearch(JScrollPane vjsp, JTable vtable, String vtext, int x, int y) {
 		
		jsp = vjsp ;
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBackground(Color.white);
		jsp.setFocusable(true);
		table = null;
		table = new JTable();
		table = vtable;
		new gnFontSetting().setMyFont(table, "F2", 14);
		prt.setBackground(Color.WHITE);
		prt.add(table);
		table.setFocusable(true);
		prt.setVisible(true);
		jsp.setViewport(prt);
		frame = new JFrame();
		try {
			new gnApp().setFrameTitel(frame);
		} catch (Throwable e) {

		}
		int row = table.getRowCount();
		if (row > 0) {
			jsp.setPreferredSize(new Dimension(x, y));
			jsp.setBorder(BorderFactory.createRaisedBevelBorder());
			dialog = new JDialog();
			pane = new JOptionPane();
 			FocusListener abc =   new btnfoucs();
			dialog.addFocusListener(abc);
			jsp.addFocusListener(abc);
			pane.addFocusListener(abc);
			dialog = new JDialog();
 			dialog.setAlwaysOnTop(true);
			dialog.setFocusableWindowState(true);
			dialog.requestFocusInWindow();
	 		frame.setVisible(false);
  			String choice = "O";
			switch (choice) {
			case "O":
 				 jsp.requestFocus();
 				 jsp.grabFocus();
 				 table.grabFocus();
 				 if (jsp.isFocusable())
 				 {
 					 table.grabFocus();
 				 }

 				 if (dialog.isFocusable())
 				 {
 					 table.grabFocus();
 				 }
 				 if (pane.isFocusable())
 				 {
 					 table.grabFocus();
 				 }

   				 pane.showMessageDialog(dialog, jsp, vtext, 1);
   				 table.grabFocus();
				 SelectArticlerow();
				break;
			}
			// jsp.addNotify();
		} else {
			new General().Quickmsg("!!!!! No Record Found...!!!!!");
		}
	}
 	
	public void SelectArticlerow() {
		table.requestFocus(true);
		table.setCursor(new Cursor(Cursor.HAND_CURSOR));
		table.grabFocus();
		table.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_INSERT, 0), "enter");
		table.getActionMap().put("enter", new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				table.setEditingRow(0);
				new General().msg("Welcome");
			}
		});
		table.grabFocus();
	}

	public void showwindow(JScrollPane jsp, JTable vtable, String vtext, int x, int y) {
		JPanel pnl = new JPanel();
		JWindow wo = new JWindow();
		wo.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBackground(Color.white);
		jsp.setFocusable(true);
		table = null;
		table = new JTable();
		table = vtable;
		prt.setBackground(Color.WHITE);
		prt.add(table);
		table.setFocusable(true);
		prt.setVisible(true);
		table.grabFocus();
		jsp.setBounds(100, 150, x, y);
		jsp.setViewport(prt);
		jsp.setVisible(true);
		wo.add(jsp);
		jsp.setBounds(100, 150, x, y);
		wo.setBounds(100, 150, x, y);
		wo.setAlwaysOnTop(true);
		wo.setVisible(true);
		wo.setFocusable(true);
		wo.setEnabled(true);
		Component ss = wo.getFocusOwner();
		boolean ss1 = table.isFocusOwner();
		if (false) {
			table.setFocusable(true);
			table.requestFocus();
			table.grabFocus();
		}
	}

	public void msgsearchNew(JScrollPane jsp, JTable vtable, String vtext, int x, int y) {
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.setBackground(Color.white);
		jsp.setFocusable(true);
		table = null;
		table = new JTable();
		table = vtable;
		prt.setBackground(Color.WHITE);
		prt.add(table);
		table.setFocusable(true);
		prt.setVisible(true);
		jsp.setViewport(prt);
		frame = new JFrame();
		try {
			new gnApp().setFrameTitel(frame);
		} catch (Throwable e) {
			new General().msg(e.getLocalizedMessage());
		}

		int row = table.getRowCount();
		if (row > 0) {
			jsp.setPreferredSize(new Dimension(x, y));
			jsp.setBorder(BorderFactory.createRaisedBevelBorder());
			dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			dialog.setFocusableWindowState(true);
			dialog.requestFocusInWindow();
			table.requestFocus();
			table.setFocusable(true);
			table.grabFocus();
			frame.setVisible(false);

			if (!jsp.isRequestFocusEnabled()) {
				table.grabFocus();
				;
				table.requestFocusInWindow();
			}

			if (!table.isRequestFocusEnabled()) {
				table.grabFocus();
				;
				table.requestFocusInWindow();
			}

			String choice = "N";
			switch (choice) {
			case "N":
				frame = new JFrame();
				frame.setBounds(100, 200, x, y);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setAlwaysOnTop(true);
				frame.setFocusableWindowState(true);
				panel = new JPanel();
				panel.setPreferredSize(new Dimension(x, y));
				table.setFocusable(true);
				table.setFocusCycleRoot(true);
				table.grabFocus();
				panel.add(jsp);
				frame.add(panel);
				frame.setAlwaysOnTop(true);
				frame.setVisible(true);
				table.grabFocus();
				frame.pack();
				break;
			}
			// jsp.addNotify();
		} else {
			new General().Quickmsg("!!!!! No Record Found...!!!!!");
		}

	}

	public void msgDispose() {
		// this.frame.pack();;
		// this.frame.dispose();
		dialog.pack();
		dialog.dispose();

	}

	public void msgDisposeNew() {
		this.frame.pack();
		;
		this.frame.dispose();
		// dialog.pack();
		// dialog.dispose();

	}

	public void msgDispose1() {
		// frame.dispose();
		dialog1.pack();
		dialog1.dispose();
	}

	public static void msgFrame(JFrame jsp, String vtext, int x, int y) {
		dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		jsp.setPreferredSize(new Dimension(x, y));
		JOptionPane.showConfirmDialog(dialog, jsp, vtext, 2, 2, null);
		dialog.pack();
		dialog.setDefaultCloseOperation(1);
		dialog.setFocusable(true);

	}

	public static void msgPanel(JPanel jsp, String vtext, int x, int y) {
		dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		jsp.setPreferredSize(new Dimension(x, y));
		jsp.setBorder(BorderFactory.createRaisedBevelBorder());
  		JOptionPane.showMessageDialog(dialog, jsp, "Edit Information-->Press Enter Key", 1);
		//JOptionPane.showMessageDialog(dialog, jsp);

 		
 		dialog.pack();
		dialog.setDefaultCloseOperation(1);
		dialog.setFocusable(true);

	}

	public static void msgJsp(JScrollPane jsp, String vtext) {

		dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		pane.showMessageDialog(dialog, jsp, vtext, 1);
	}

	public static void msgFxPanel(JFXPanel jsp, String vtext, int x, int y) {
		dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		jsp.setPreferredSize(new Dimension(x, y));
		jsp.setBorder(BorderFactory.createRaisedBevelBorder());
		JOptionPane.showConfirmDialog(dialog, jsp, vtext, 2, 2, null);
		// JOptionPane.showMessageDialog(jsp, vtext);
		dialog.pack();
		dialog.setDefaultCloseOperation(1);

	}

	public static void msgTextPane(String vtext, String FieldNameHeader) {
		JTextArea txa = new JTextArea();
		txa.setLineWrap(true); // Makes the text wrap to the next line
		txa.setWrapStyleWord(true); // Makes the text wrap full words, not just
									// letters
		//
		txa.getAutoscrolls();
		txa.setBounds(100, 100, 700, 500);
		txa.setEditable(false);
		txa.setEnabled(false);
		JButton btnInfo = new JButton("View More");
		txa.add("View More Information", btnInfo);
		txa.add(btnInfo);
		dialog = new JDialog();
		dialog.setDefaultLookAndFeelDecorated(true);
		dialog.setAlwaysOnTop(true);
		dialog.setDropTarget(null);
		txa.setText(vtext);
		JOptionPane.showConfirmDialog(dialog, edp, FieldNameHeader, 0, 2, null);
		dialog.pack();
		dialog.setDefaultCloseOperation(1);
	}

	public static void msgEdtPane(String vtext, String FieldNameHeader) throws IOException {
		edp = new JEditorPane("text/html", " ");
		edp.getAutoscrolls();
		edp.setBounds(100, 100, 700, 500);
		edp.setEditable(false);
		edp.setEnabled(false);
		JButton btnInfo = new JButton("View More");
		edp.add("View More Information", btnInfo);
		edp.add(btnInfo);
		dialog = new JDialog();
		dialog.setDefaultLookAndFeelDecorated(true);
		dialog.setAlwaysOnTop(true);
		dialog.setDropTarget(null);
		edp.setText(vtext);
		JOptionPane.showConfirmDialog(dialog, edp, FieldNameHeader, 0, 2, null);
		dialog.pack();
		dialog.setDefaultCloseOperation(1);
	}

	public static void msgDate(Date msg) {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		dialog.setDefaultLookAndFeelDecorated(true);
		JOptionPane.showMessageDialog(dialog, msg);
	}

	public static void msgDateformat(DateFormat msg) {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog, msg);
	}

	public AbstractFormatter setDateFormat() throws ParseException {
		DefaultFormatter mf1 = new MaskFormatter("####-##-##");
		((MaskFormatter) mf1).setPlaceholderCharacter('_');
		return mf1;
	}

	public Font getFont(int no) {
		Font gh = new Font(driver, Font.BOLD, no);

		return gh;

	}

	public String getLength(JTextField vtext, String vmsg) {
		String Action = "Pass";
		int len = vtext.getText().length();
		if (len <= 0) {
			new gnImageSound().playAlertSound();
			new General().msg(vmsg);
			vtext.grabFocus();

			Action = "Fail";
		}
		return Action;

	}

	public String ValidateResultSet(ResultSet rs) throws SQLException {
		String action = "Sucess";
		if (!rs.next()) {
			new General().Quickmsg(" !!! No Record Found .!!!");
			new gnImageSound().playAlertSound();
			action = "Fail";
		}
		// new General().msg(rs.getString(1) + "
		// "+rs.getString(2)+rs.getString(13));

		return action;
	}

	 
	public void Devmsg(String msg) {

		if (DevMessage == "Y") {
			dialog1 = new JDialog();
			contentPanel.setBackground(Color.BLACK);
			lbl.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\nk\\myicon.icon"));
			lbl.setText(msg);
			lbl.setBackground(new Color(112, 0, 112));
			lbl.setForeground(new Color(0, 0, 50));
			lbl.setFont(new Font("Calibri", Font.BOLD, 14));
			contentPanel.add(lbl);
			dialog1.getContentPane().add(contentPanel);
			dialog1.setBackground(Color.BLACK);
			dialog1.setDefaultLookAndFeelDecorated(true);
			dialog1.setAlwaysOnTop(true);
			dialog1.setBackground(new Color(112, 0, 112));
			dialog1.setForeground(Color.WHITE);
			dialog1.setFont(new Font("Calibri", Font.BOLD, 14));

			ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
			s.schedule(new Runnable() {
				public void run() {
					dialog1.setVisible(false); // should be invoked on the EDT
					dialog1.dispose();
				}
			}, 90000, TimeUnit.MILLISECONDS);
			JOptionPane.showMessageDialog(dialog1, lbl);
		}
	}

	public void Quickmsg(String msg) {
		dialog1 = new JDialog();
		dialog1.setDefaultLookAndFeelDecorated(true);
		dialog1.setAlwaysOnTop(true);
		dialog1.setBackground(new Color(112, 0, 112));
		dialog1.setForeground(Color.WHITE);
		JButton btn = new JButton();
		new gnBackground().setBackground(btn);
		btn.setIcon(new ImageIcon(DayBegin.class.getResource("/RetailProduct/panel.png")));
		btn.setBounds(0, 0, 400, 700);
		dialog1.add(btn);
		lbl.setIcon(new ImageIcon("D:\\AKN\\myProductImage\\nk\\myicon.icon"));
		lbl.setText(msg);
		lbl.setBackground(new Color(112, 0, 112));
		lbl.setForeground(new Color(0, 0, 50));
		lbl.setFont(new Font("Calibri", Font.BOLD, 14));
		new gnFontSetting().setMyFont(lbl, "F2", 15);
		lbl.setForeground(new Color(0, 0, 121));
		ScheduledExecutorService s = Executors.newSingleThreadScheduledExecutor();
		s.schedule(new Runnable() {
			public void run() {
				dialog1.setVisible(false); // should be invoked on the EDT
				dialog1.dispose();
			}
		}, 1000, TimeUnit.MILLISECONDS);
		JOptionPane.showMessageDialog(dialog1, lbl);
	}

	public static void msgSheet(HSSFSheet sheet) {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		dialog.setDefaultLookAndFeelDecorated(true);
		JOptionPane.showMessageDialog(dialog, sheet);

	}

	public static void msgDouble(double msg) {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog, msg);
	}

	public static void msgBoolean(boolean msg) {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog, msg);
	}

	public static void msgtable(JTable msg) {
		Window win = null;
		final JDialog dialog = new JDialog();
		// dialog.setAlwaysOnTop(true);
		// dialog.add(win);
		dialog.setTitle("Select Data");
		dialog.setDefaultLookAndFeelDecorated(true);
		dialog.setModal(true);
		dialog.setModalityType(null);
		JOptionPane.showMessageDialog(dialog, msg);
	}

	public static void msgmodel(DefaultTableModel msg) {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog, msg);
	}

	public static void msgVector(Vector<Data> msg) {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog, msg);
	}

	public static void msgCombo(JComboBox msg) {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog, msg);
	}

	public static void msgint(int msg) {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog, msg);
	}

	public static void msgrs(ResultSet msg) {
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog, msg);
	}

	public int msgInput(String msg) {
		String title = "Input Required";
		final JDialog dialog1 = new JDialog();
		dialog.setDefaultLookAndFeelDecorated(true);
		dialog1.setAlwaysOnTop(true);
		int response = JOptionPane.showConfirmDialog(dialog1, msg, title, JOptionPane.YES_NO_OPTION);
		return response;
	}

	public void msgObject(Object msg) {
		final JDialog dialog1 = new JDialog();
		dialog1.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog1, msg);

	}

	public void msgArray(String[] msg) {
		String title = "Input Required";
		final JDialog dialog1 = new JDialog();
		dialog1.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog1, msg);
	}

	public void msgArrayList(ArrayList<String> msg) {
		String title = "Input Required";
		final JDialog dialog1 = new JDialog();
		dialog1.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog1, msg);
	}

	public void msgArrayInt(int[] msg) {
		String title = "Input Required";
		final JDialog dialog1 = new JDialog();
		dialog1.setAlwaysOnTop(true);
		JOptionPane.showMessageDialog(dialog1, msg);

	}

	public String getDate() {
		Date dt = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("dd.MM.yyyy");
		String date = ft.format(dt);
		return date;
	}

	public void handleKeys() { // This Method must call in every FORM for Enter
								// and TAB Key to moveForward cusrsor
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		KeyStroke tab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0);
		KeyStroke ctrlTab = KeyStroke.getKeyStroke(KeyEvent.VK_TAB, KeyEvent.CTRL_DOWN_MASK);
		Set<KeyStroke> keys = new HashSet<>();
		keys.add(enter);
		keys.add(tab);
		keys.add(ctrlTab);
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
				.setDefaultFocusTraversalKeys(KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS, keys);
	}

	public int whatKeyPressed(JTextField Field) {
		Field.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				keyno = e.getKeyCode();
			}
		});
		return keyno;
	}

	public static void setNumericOnly(JFormattedTextField Field) {
		Field.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((!Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
	}

	public static void setNumerOnlyforJtext(JTextField Field) {
		Field.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((!Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();
				}
			}
		});
	}

	public static void main(String[] args) {
		General gn = new General();
		// gn.msgEdtPane( "Wel Come Guest");
	}

	public String getMastermaxseq(String vname) throws ClassNotFoundException, SQLException {
		String vcode = "";
		String SQL = "call N_Master_getMaxCode('" + vname + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vcode = rs.getString(1);
			rs.close();
			this.closeconn();
		} else {
			vcode = "0";
		}
		return vcode;
	}

	
	
	
	

 
	class btnfoucs implements FocusListener{
 		@Override
		public void focusGained(FocusEvent arg0) {
    			 
			if (table.isFocusOwner()) {
				 
			     table.grabFocus();
			     table.requestFocus();
			     table.setRowSelectionAllowed(true);
			     table.setEditingRow(1);
			     table.setFocusTraversalKeysEnabled(true);
			}

 			
			if (prt.isFocusOwner()) {
				 
			     table.grabFocus();
			     table.requestFocus();
			}

			if (pane.isFocusOwner()) {
 
			     table.grabFocus();
			     table.requestFocus();
			}
			
			if (dialog.isFocusOwner()) {
 			     table.grabFocus();
			     table.requestFocus();
			}
			
			if (jsp.isFocusOwner()) {
			     table.grabFocus();
			     table.requestFocus();
			}

 
		}

		@Override
		public void focusLost(FocusEvent arg0) {
 			
		}
		
	}
	
	
}

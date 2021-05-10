package RetailProduct;

import java.io.File;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class gnPublicVariable {

	 
	//To pass auto refernce 
	
	public static String vRefcode = "";
	public static String vRefname = "";
 	//To pass auto refernce 

	
	// App

	
	public static int vmyrow = 0;
	public static String varticlecode = "";
	public static String vmyarticlecode = "";
	public static String varticlename = "";
	public static String vmastersearchString = "%%";
	public static String EnableAccountingModule = "N";

	
	
	public static String vcodetype = "MD5";
	public static String vcodetype1 = "SHA-1";
	public static String str1 = "update ms_company_master set lickey  = ";
	public static String str2 = "update ms_site_master set lickey =";
	public static String str3 = " update  licinfo  set expdate = ";
	public static String str4 = "select lickey  from ms_site_master ";
	public static String str5 = "select * FROM  licinfo";

	public static String svbrand = "%%";
	public static String svsubgroup = "%%";
	public static String svsize = "%5";
	public static String svcolor = "%%";
	public static String svpattern = "%%";

	public static String saccLedCode = "";
	public static String saccLedName = "";
	public static String saccLedopbal = "";
	public static String saccLedopbaldrcr = "";
	public static String saccLedclbal = "";
	public static String saccLedclbaldrcr = "";

	public static String vcomp = "";
	public static String vstore = "";
	public static String myvcomp = "";
	public static String myvstore = "";
	public static String compcode = "";
	public static String storecode = "";
	public static String vdemocomp = "9999";
	public static String vdemouser = "TEST";
	public static String vadmin = "ADMIN";

	public static String SiteAutomationActivate = "Y";
	public static String ifc = "N";
	public static String vbaseceq = "";
	public static String vbaseseq = "AKN";

	public static String compname = "Default Company";
	public static String storename = "Default Store";
	public static String isFinyearFreeze = "";

	public static String ApplicationDrivename;
	public static String ProductPath;
	public static String AccessRemoteDB = "N";
	public static String DevMessage = "N"; // Keep No Only
	public static String configFilePath = null;
	public static String DatabaseBackupPath;
	public static String internetRequired;
	public static String vname = ApplicationDrivename + "AKN\\";
	protected static String memorysqlPath = "nitin.db";
	protected static String localsqlPath = "abc";
	public static String localparam = "jdbc:sqlite:";
	public static String vfilename2 = "linfo";
	public static String vfilename1 = "ConfigRun";
	public static String ProductImagePath;
	public static String ReportEexutionPath;
	public static String ProductScriptPath = "AKN\\Script\\";
	public static String LogConfigurationFileName;
	public static String promoModuleActivated = "N";

	public static String TaxableInvoice = "N"; // 22
	public static String menuAdmin = "Y"; // 20
	public static String ClientLogoFileName = null;
	// public static String PrintInvoiceFormat = "posInvoice.jasper";
	public static String PrintInvoiceFormat = "HardwareInvoice.jasper";
	public static String PrintPOForamt = "po.jasper";
	public static String possearcharticle;

	public static String PrintGRNFormat = "grn.jasper";
	public static String PrintBarcodeFrmat = "myBarcode.jasper";
	public static String CreditSalesFormat = "taxableCreditInvoice.jasper"; // 13
	public static String WholeSalesFormat = "taxableCreditInvoice.jasper"; // 14
	public static String TOformat = "to.jasper"; // 15
	public static String MyCompanyLogo = "";
	public static String TIFormat = "ti.jasper";// 17

	public static String expdate;
	public static String currentFinYear;
	public static String prvFinYear;
	public static String setfinyearis = "";
	public static String ucode = "Admin";
	public static String Daybegindate = null;
	public static String Language = "";
 
	public static String vchqdddate;
	public static String vbankgl;
	public static String vpaymenmode;
	public static String vchqddno;
	// public static String terminal = "1";
	public static String role = "MANAGER";
	public static String validatePath = "L";
	public static String verticlecode = "";
	public static String verticlename = "";
	public static String segmentcode = "1";
	public static String segmentname = "Retail";
	public static String BranchType = " ";
	public static String format = " ";
	public static String formatcode = " ";
	public static String formatname = " ";

	public static String vexcltransactionAmount = "0.0";
	public static String isledgerRun = "N";
	public static String ledgerType = "";

	// Graph Related
	public static String vChartTitle;
	public static String vseriesName;
	public static JTable table;
	public static JTable mytable;
	public static String mylabel = "Party Ledger";
	public static DefaultTableModel mymodel;

	public static int xcol;
	public static int ycol;
	public static String daybegindate = "";
	// Graph

	public static String AppImage = " ";// 18
	
	public static String PostGST_accountEntryAtSaveTime = " ";// 26
	public static String GSTEnable = " "; // 26
	
	public static String AccountingEnable = " "; // 34
	public static String vaccount = "Password";

	public static String ThemeName = "Theme1";// 19
	public static String B2BAllow = "N";
	public static String DeclarationAllow = "N";
	public static String vformat = "";
	public static String CloseDayReopenAllow = "N";// 28
	public static String EditDocAllow = "Y";// 29
	public static String PanelBackgroundImage = "back1.png";// 30
	public static String AppBtnStyle = "1"; // 32;
	public static String alertmsg = "Invalid Porduct Key Please Renew Your Product Key";
	public static String alertmsg1 = "Key Not Issued...Please Contact";
 	
	public static String DBpath = "C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\";
 	public static String user = "root";
   	public static final String myString = "aayushi7";
 	public static final String myString1 = "aayushi7";

	

	// Application font Setting
	public static String myFontName = "Calibri";
	public static String myFontBOLDType = "BOLD";
	public static String myFontPLAINType = "PLAIN";
	public static int myFontSize = 14;

	// End Font Setting

	public String getCompanycode() {
		return compcode;
	}

	public void resetAttributes() {
		svbrand = "%%";
		svsubgroup = "%%";
		svsize = "%%";
		svcolor = "%%";
		svpattern = "%%";

	}

	public String getCompanyname() {
		return compname;
	}

	public String getMemorySqlPath() {
		String vfilename = null;
		File dbname = new File(Loginwindow.class.getResource("/RetailProduct/" + memorysqlPath).getFile());
		vfilename = dbname.toString();
		return vfilename;
	}

	public String getlocalSqlPath() {
		String vfilename = null;
		vfilename = localsqlPath;
		return vfilename;
	}

	public String getStorecode() {
		return storecode;
	}

	public String getStoreName() {
		return storename;
	}

	public String getBranchType() {
		return BranchType;
	}

	public String getUsercode() {
		return ucode;
	}

	public String getBegindate() {
		return daybegindate;
	}

	// public String getTerminal() {
	// return terminal;
	// }

	public String getVerticleCode() {
		// System.out.println(verticlecode);
		return verticlecode;
	}

	public String getRoleName() {
		return role;
	}

	public String getVerticleName() {
		return verticlename;

	}

	public String getSegmentCode() {
		return segmentcode;
	}

	public String getSegmentName() {
		return segmentname;
	}

	public String getformatCode() {
		return formatcode;
	}

	public String getformatName() {
		return formatname;
	}

	// Conf
	public String DbBackupPath() {
		return DatabaseBackupPath;
	}

	public String MyCompanyLogo() {
		if (MyCompanyLogo.length() == 0) {
			MyCompanyLogo = "D://akn//myProductImage//ClientLogo.png";
		}
		// new General().msg(MyCompanyLogo);;
		return MyCompanyLogo;
	}

	public String ClientLogo() {
		return ClientLogoFileName;
	}

	public String ReportEexutionPath() {
		return ReportEexutionPath;
	}

	public String Print_invoiceFormat() {
		return PrintInvoiceFormat;
	}

	public String Print_BarcodeFormat() {
		return PrintBarcodeFrmat;
	}

	public String Print_GrnFormat() {
		return PrintGRNFormat;
	}

	public String Print_poFormat() {
		return PrintPOForamt;
	}

	public String getTheme() {
		return ThemeName;
	}

	public String checkB2BAllow() {
		return B2BAllow;
	}

	public String checkDeclarationAllow() {
		return DeclarationAllow;
	}

	public String DayReopenAllow() {
		return CloseDayReopenAllow;
	}

	public String appBtnStyle() {
		return AppBtnStyle;
	}

}

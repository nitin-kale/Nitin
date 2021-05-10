package RetailProduct;

import java.awt.Toolkit;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.HierarchicalINIConfiguration;
import org.apache.commons.configuration.SubnodeConfiguration;

public class gnApplicationSetting extends getResultSet {

	private String SQL;
	public static String vformat = "";

	// 4 , 5 7 , 16 , 18 is free to use

	public void setAppDesign(JFrame frame, String vvcomp, String vvstore, JButton Bottam, JButton btnImg)
			throws Throwable {
		String vpara = "809";
		frame.setTitle(new getConfigurationSetting().getInitialConfig(vpara, vcomp, vstore));
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage(Loginwindow.class.getResource("/RetailProduct/mymain.png")));
		String vpara1 = "810";
		// Bottam.setText(new getConfigurationSetting().getInitialConfig(vpara1,
		// vcomp, vstore));

	}

	private void setforamt(String compcode, String storecode) throws Throwable {
		String SQl2 = "Call  site_getFormat(" + compcode + " , " + storecode + ")";
		rs2 = this.getSPResult(SQl2);
		if (rs2.next()) {
			vformat = rs2.getString(1);
		}

	}

	private void setotherpath() {
		ProductPath = ApplicationDrivename + "AKN//";
		ProductScriptPath = ApplicationDrivename + "AKN//Script//";
		new gnLogger().loggerInfoEntry("POS", "Appliction Script path set");
	}

	
	
	public void SetApplicationConfiguration(String compcode, String storecode) throws Throwable {
		// new General().msg("Initializing Application Setting..");
		new gnLogger().loggerInfoEntry("POS", "Application Setting Starts Now");
 		try {
			String vstore = storecode;
			String vcomp = compcode;
			String vpara = "";
			setforamt(compcode, storecode);
			String vpara703 = "703";
			String vpara704 = "704";
			String vpara28 = "28";
			String vpara29 = "29";
			String vpara30 = "30";
			String vpara32 = "32";
			String vpara18 = "18";
			String vpara26 = "26";
			String vpara33 = "33";
			String vpara34 = "34";//Accntin Enable
			String vpara36 = "36";
			String vpara713 = "713";

			internetRequired = new getConfigurationSetting().getInitialConfig(vpara36, compcode, storecode);
			daybegindate = new getConfigurationSetting().getDaybeginDate(compcode, storecode);
			Language = new getConfigurationSetting().getInitialConfig(vpara33, compcode, storecode);
			Language.trim();
			B2BAllow = new getConfigurationSetting().getInitialConfig(vpara704, compcode, storecode);
			DeclarationAllow = new getConfigurationSetting().getInitialConfig(vpara703, compcode, storecode);
			CloseDayReopenAllow = new getConfigurationSetting().getInitialConfig(vpara28, compcode, storecode);
			EditDocAllow = new getConfigurationSetting().getInitialConfig(vpara29, compcode, storecode);
			PanelBackgroundImage = new getConfigurationSetting().getInitialConfig(vpara30, compcode, storecode);
			AppBtnStyle = new getConfigurationSetting().getInitialConfig(vpara32, compcode, storecode);
			PostGST_accountEntryAtSaveTime = new getConfigurationSetting().getInitialConfig(vpara26, compcode,
					storecode);
			currentFinYear = new gnFinYear().getiniFinYear(compcode, storecode);
			promoModuleActivated = new getConfigurationSetting().getInitialConfig(vpara713, compcode, storecode);
 			
			//added on 16-jan-2021 needs to handle for payment/received/exepnse/bank/income 
			EnableAccountingModule= new getConfigurationSetting().getInitialConfig(vpara34, compcode, storecode);
			setotherpath();
 
			int i = 0;
			while (i < 23) {
				switch (i) {
				case 1:
					vpara = Integer.toString(i);
					DatabaseBackupPath = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					DatabaseBackupPath = ApplicationDrivename + DatabaseBackupPath;
					checkParavalue(DatabaseBackupPath, i);
					break;
				case 2:
					vpara = Integer.toString(i);
					ProductImagePath = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					ProductImagePath = ApplicationDrivename + ProductImagePath;
					// new General().msg(ProductImagePath);
					checkParavalue(ProductImagePath, i);
					break;
				case 3:
					vpara = Integer.toString(i);
					ReportEexutionPath = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					ReportEexutionPath = ApplicationDrivename + ReportEexutionPath;
					checkParavalue(ReportEexutionPath, i);
					break;
				case 4:
					// vpara = Integer.toString(i);
					// ApplicationDrivename = new
					// getConfigurationSetting().getInitialConfig(vpara,
					// compcode, storecode);
					// checkParavalue(ConfigurationFilePath, i);
					break;
				case 5:
					// vpara = Integer.toString(i);
					// LoggingPath = new
					// getConfigurationSetting().getInitialConfig(vpara,
					// compcode, storecode);
					// checkParavalue( LoggingPath, i);
					break;
				case 6:
					vpara = Integer.toString(i);
					LogConfigurationFileName = new getConfigurationSetting().getInitialConfig(vpara, compcode,
							storecode);
					checkParavalue(LogConfigurationFileName, i);
					break;

				case 7:
					// vpara = Integer.toString(i);
					// LogFileName= new
					// getConfigurationSetting().getInitialConfig(vpara,
					// compcode, storecode);
					// checkParavalue( LogFileName, i);
					break;
				case 8:
					vpara = Integer.toString(i);
					ClientLogoFileName = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					ClientLogoFileName = ProductImagePath + ClientLogoFileName;
					// new General().msg(ClientLogoFileName);
					checkParavalue(ClientLogoFileName, i);
					break;
				case 9:
					vpara = Integer.toString(i);
					PrintInvoiceFormat = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					checkParavalue(PrintInvoiceFormat, i);
					break;
				case 10:
					// new General().msg("Para Value:"+ i);
					vpara = Integer.toString(i);
					PrintPOForamt = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					checkParavalue(PrintPOForamt, i);
					break;
				case 11:
					// new General().msg("Para Value:"+ i);
					vpara = Integer.toString(i);
					PrintGRNFormat = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					checkParavalue(PrintGRNFormat, i);
					break;
				case 12:
					// new General().msg("Para Value:"+ i);
					vpara = Integer.toString(i);
					PrintBarcodeFrmat = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					checkParavalue(PrintBarcodeFrmat, i);
					break;

				case 13:
					// new General().msg("Para Value:"+ i);
					vpara = Integer.toString(i);
					CreditSalesFormat = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					checkParavalue(PrintBarcodeFrmat, i);
					break;
				case 14:
					// new General().msg("Para Value:"+ i);
					vpara = Integer.toString(i);
					WholeSalesFormat = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					checkParavalue(PrintBarcodeFrmat, i);
					break;
				case 15:
					// new General().msg("Para Value:"+ i);
					vpara = Integer.toString(i);
					TOformat = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					checkParavalue(TOformat, i);
					break;
				case 16:
					// new General().msg("Para Value:"+ i);
					// vpara = Integer.toString(i);
					// MyCompanyLogo = new
					// getConfigurationSetting().getInitialConfig(vpara,
					// compcode, storecode);
					// MyCompanyLogo = ProductImagePath+ MyCompanyLogo ;
					// //new General().msg(MyCompanyLogo);
					// checkParavalue( MyCompanyLogo , i);
					break;
				case 17:
					vpara = Integer.toString(i);
					TIFormat = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					checkParavalue(TIFormat, i);
					break;
				case 18:
					vpara = Integer.toString(i);
					AppImage = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					if (AppImage == "") {
						AppImage = ApplicationMenu.class.getResource("/RetailProduct/111.png").toString();
					} else {
						AppImage = ProductImagePath + AppImage;
					}
					// new gnImageSound().playSound();
					break;
				case 19:
					vpara = Integer.toString(i);
					ThemeName = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					new gnImageSound().playSound();
					break;
				case 20:
					vpara = Integer.toString(i);
					menuAdmin = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					new gnImageSound().playSound();
					break;

				case 22:
					vpara = Integer.toString(i);
					TaxableInvoice = new getConfigurationSetting().getInitialConfig(vpara, compcode, storecode);
					new gnImageSound().playSound();
					break;
				}
				i = i + 1;
				new gnLogger().loggerInfoEntry("POS", "Appliction para settting path set" + i);
			}
			showParaValue();
			this.closeconn();
			new gnLogger().loggerInfoEntry("POS", "Application Setting Done");
		} catch (Exception e) {
			new General().msg("Application Configuration Setting Exception .. " + " " + e.getLocalizedMessage());
			new gnLogger().loggerInfoEntry("POS",
					"Application Configuration Setting Exception" + e.getLocalizedMessage());
		}

	}

	private void showParaValue() {

		System.out.println("Application Setting");
		System.out.println(DatabaseBackupPath);
		System.out.println(ProductImagePath);
		System.out.println(ReportEexutionPath);
		System.out.println(LogConfigurationFileName);
		System.out.println(ClientLogoFileName);
		System.out.println(PrintInvoiceFormat);
		System.out.println(PrintPOForamt);
		System.out.println(PrintGRNFormat);
		System.out.println(PrintBarcodeFrmat);
		System.out.println(MyCompanyLogo);
		System.out.println(MyCompanyLogo);
		System.out.println(B2BAllow);
		System.out.println(DeclarationAllow);
		System.out.println(menuAdmin);
		System.out.println(TaxableInvoice);
		System.out.println("Internet Required" + "" + internetRequired);
	}

	private void checkParavalue(String vpara, int i) throws Throwable {
		if (vpara.length() == 0) {
			new General().msg("Value is Not Set For Paramater :" + i + " " + vpara);
		}

	}

}// LAst

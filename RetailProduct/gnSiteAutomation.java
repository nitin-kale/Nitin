package RetailProduct;

import java.io.IOException;
import java.sql.SQLException;

public class gnSiteAutomation extends getResultSet {

	// This is used to auomate site and other master creation automatically
	// At This of Company Creation
	// 1.Site Create Auto when company will create

	// 2.uer create for site
	// 3.Fin year create for site
	// 3.Store Configuration
	// 3.Number SeqCreation
	// 3.1 Group/SubGroup/GL Will Create Here

	String vfinyear;
	String vstartdate;
	String venddate;
	String vcurfinyear;
	int vmon;
	int vyear;

	String vvstore;
	String vvcomp;

	public void doOtherAutomationActivity(String vcomp, String vstore, String vvstorename) throws Throwable {
		
		getBasicData(new General().getDate());

		if (SiteAutomationActivate == "Y") {
			vvstore = vstore;
			vvcomp = vcomp;
			new General().msg("Creating Defaut User for New Store..");
			UserCreation(vvcomp, vvstore, vvstorename);

			new General().msg("Creating Financial Year For  New Store ..");
			FinyearCreation(vvcomp, vvstore);

			
			new General().msg("Creating Store Configuration  New Store ..");
			StoreConfigurationCreation(vvcomp, vvstore);

			new General().msg("Creating Number Sequences For New Store ..");
			NumberSeqCreation(vvcomp, vvstore);

			new General().msg("Creating Accounts Master....");
			AccountMasterDataCreation(vvcomp, vvstore);

			new General().msg("Creating Default Customer ....");
			defaultCustomerCreation(vvcomp, vvstore);
            
		}
	}

	private void getBasicData(String vdate) throws ClassNotFoundException, SQLException {
		vfinyear = new gnFinYear().getFinyearofTodaysDate(vdate);
		vstartdate =   new gnConfig().date_ConverttoDBforamt(new gnFinYear().vstartdate);
		venddate =     new gnConfig().date_ConverttoDBforamt(new gnFinYear().venddate);
		vcurfinyear = "Y";
	}

	private void defaultCustomerCreation(String vcomp, String vvstore) throws Throwable {

		String vname = "Default";
		String vcode = "0";
		String vissupplier = "N";
		String regdlr = "N";
		String vscheme = "0";
		String mystatecode = new gnGST().getmyState();
		String mystatename = new gnGST().getmystatename();
		String vcity = "0";
		String vcityname = "";
		String vverticle = new getConfigurationSetting().getVerticleCode(vcomp, vvstore);

		String SQL = "Insert into ms_customer_master(Company_code , Code, "
				+ "Name,  Site_code, verticle, IsSupplier , reg_delear , Scheme, state, state_name, city, city_name)"
				+ "values(" + vcomp + ", " + vcode + ", '" + vname + "', " + vstore + " , " + vverticle + ", '"
				+ vissupplier + "',  '" + regdlr + "', " + vscheme + "," + "   " + mystatecode + " ,  '" + mystatename
				+ "' , " + mystatecode + " ,  '" + mystatename + "' )";
		this.getResult(SQL);

	}

	public void UserCreation(String vcomp, String vvstore, String vvstorename)
			throws ClassNotFoundException, SQLException, IOException {

		String vcompname = new gnConfig().getCompanyname();
		String vuser = "U" + vcomp;
		String vpass1 = "U" + vcomp;
		String vexpdate = "2020.03.31";
		String vactive = "Y";
		String vrole = "2";
		String vrolename = "Manager";
		String vsegmentcode = "1";
		String vsegmentname = "Retail";

		String vverticlecode = new getConfigurationSetting().getVerticleCode(vcomp, vvstore);
		String vverticlename = new getConfigurationSetting().getVerticleName(vcomp, vvstore);
		String vpass = new General().convertPassword(vpass1);

		String SQL = "insert into user_master(company_code,  company_name,"
				+ "Store_code, store_name, ucode,  name, password, pw_expiry_date,"
				+ "Active_status, Assignrole, role_name , segmentcode, segmentname," + "verticlecode, verticlename)"
				+ "values(" + vcomp + ", '" + vcompname + "', " + vvstore + ", '" + vvstorename + "', '" + vuser
				+ "', '" + vuser + "', '" + vpass + "',  '" + vexpdate + "', " + " '" + vactive + "', " + vrole + ", '"
				+ vrolename + "' ," + "	 " + vsegmentcode + ", '" + vsegmentname + "' , " + vverticlecode + " , '"
				+ vverticlename + "')";

		this.getResult(SQL);

		new General().msg("Your User code is :-->" + " " + vuser + " & Your Password is :" + " " + vpass1);
	}

	private void FinyearCreation(String vcomp, String vvstore) throws ClassNotFoundException, SQLException {
		String vfreezeyear = "N";
		String SQL = "Insert into finyearcontrol(company_code ,  Finyear , Start_date , End_date,"
				+ " current_fin_year, store_code, FreezeYear)" + "values( " + vcomp + " , '" + vfinyear + "' ,   '"
				+ vstartdate + "', '" + venddate + "', " + "'" + vcurfinyear + "', " + vvstore + " ,'" + vfreezeyear
				+ "')";
		// new General().msg(SQL);
		this.getResult(SQL);
	}

	private void StoreConfigurationCreation(String vcomp, String vvstore) throws ClassNotFoundException, SQLException {
		String SQL = "call  conf_addConfigDetails(" + vcomp + ", " + vvstore + ")";
		// new General().msg(SQL);
		this.getResult(SQL);
	}

	private void NumberSeqCreation(String vcomp, String vvstore) throws Throwable {
		String vstartDate = new gnFinYear().getFirstDateofFinYear();
		String vendDate = new gnFinYear().getLastDateofFinYear();
		String SQL7 = "call num_updateNewStore(" + vcomp + ", " + vvstore + ",  '" + vstartdate + "' ,  '" + venddate
				+ "'  , '" + vfinyear + "')";

		// new General().msg(SQL7);
		this.getSPResult(SQL7);

		String SQL9 = "call   num_InsertTRSeq(" + vcomp + ", " + vvstore + ")";
		// new General().msg(SQL9);
		this.getSPResult(SQL9);

		String vmasterAvailable = CheckMasterSeq(vcomp, vvstore);
		new General().msg(vmasterAvailable);
		if (vmasterAvailable == "Y") {
			InsertMasterSeq(vcomp, vvstore);
		}
	}

	public String CheckMasterSeq(String vcomp, String vvstore) throws Throwable {
		String vstatus = "Sucess";
		String vinsertMaster = "";
		// new General().msg("checking Master Seq." );
		String SQL = "Call  Num_checkMasterSeq(" + vcomp + ")";
		rs = this.getSPResult(SQL);
		rs.next();
		String vcount = rs.getString(1);
		new General().Quickmsg("Records Available For Master Seq ..." + " " + vcount);
		switch (vcount) {
		case "0":
			vinsertMaster = "Y";
			break;
		default:
			vinsertMaster = "N";
			break;
		}
		return vinsertMaster;
	}

	private String InsertMasterSeq(String vcomp, String vvstore) throws SQLException, ClassNotFoundException {
		// new General().msg("Inserting Rows For Master Seq ...");
		String vstatus = "Sucess";
		String SQL = "Call  Num_InsertMasterSeq(" + vcomp + ", " + vvstore + ")";
		this.getSPResult(SQL);
		return vstatus;
	}

	private void AccountMasterDataCreation(String vcomp, String vvstore) throws Throwable {
		int row = 0;
		String vtype = "GroupCount";
		String vtype1 = "SubGroupCount";
		String vtype2 = "GLCount";
		String Status = "";
		String SQL = "call Account_getRecordCount('" + vtype + "', " + vcomp + ", " + vvstore + " , '" + vfinyear
				+ "')";
		String SQL1 = "call Account_getRecordCount('" + vtype1 + "', " + vcomp + ", " + vvstore + " , '" + vfinyear
				+ "')";
		String SQL2 = "call Account_getRecordCount('" + vtype2 + "', " + vcomp + ", " + vvstore + " , '" + vfinyear
				+ "')";

		// new General().msg(SQL);
		// new General().msg(SQL1);
		// new General().msg(SQL2);

		Status = insertGroup(SQL, vtype);
		if (Status == "Sucess") {
			Status = insertSubGroup(SQL1, vtype1);
			if (Status == "Sucess") {
				Status = insertGL(SQL2, vtype2);
				// Closing_Opening_processForNewFinYear() ;
			}
		}
	}

	private String insertGroup(String SQL, String vtype) throws ClassNotFoundException, SQLException {
		String Status = "Sucess";
		vtype = "Group";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			int row = Integer.parseInt(rs.getString(1));
			if (row == 0) {
				SQL = "call Account_FinAccountInsert('" + vtype + "' , " + vcomp + " , " + vvstore + " ,  '" + vfinyear
						+ "' )";
				this.getSPResult(SQL);
			} else {
				new General().msg("Account Master For Group is Present for This Company/Site/Finyear ");
			}
		}
		rs.close();
		return Status;

	}

	private String insertSubGroup(String SQL, String vtype) throws ClassNotFoundException, SQLException {
		String Status = "Sucess";
		vtype = "SubGroup";

		rs = this.getSPResult(SQL);
		if (rs.next()) {
			int row = Integer.parseInt(rs.getString(1));
			if (row == 0) {
				SQL = "call Account_FinAccountInsert('" + vtype + "' , " + vcomp + " , " + vvstore + " ,  '" + vfinyear
						+ "' )";
				this.getSPResult(SQL);
			} else {
				new General().msg("Account Master For SubGroup is Present for This Company/Site/Finyear ");
			}
		}
		rs.close();
		return Status;
	}

	private String insertGL(String SQL, String vtype) throws ClassNotFoundException, SQLException {
		String Status = "Sucess";
		vtype = "GL";

		rs = this.getSPResult(SQL);
		if (rs.next()) {
			int row = Integer.parseInt(rs.getString(1));
			if (row == 0) {
				SQL = "call Account_FinAccountInsert('" + vtype + "' , " + vcomp + " , " + vvstore + " ,  '" + vfinyear
						+ "' )";
				rs = this.getSPResult(SQL);
				new General().msg("New  Financial Year Data Created For Account Masters <Group/SubGroup/GL Accounts>");
				new gnImageSound().playSound();
				new gnImageSound().playSound();
				new gnImageSound().playSound();
			} else {
				new General().msg("Account Master For Group is Present for This Company/Site/Finyear ");
			}

		}
		rs.close();
		return Status;
	}

}

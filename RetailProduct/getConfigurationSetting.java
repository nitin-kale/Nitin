package RetailProduct;

import java.awt.Color;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTextField;

public class getConfigurationSetting extends getResultSet {
	public static Vector config = new Vector(61);

	private String vcomp;
	private String vstore;
	private String SQL;

	private void checkConfigurationisRequired() throws Throwable {
		new General().msg("Would You Like to Set  configuration file This Store :");
		store_configuration window = new store_configuration();
		window.storeconfigFrame.setVisible(true);
	}

	
	public String getInitialConfig(String vpara, String vcomp, String vstore) throws Throwable {
		// new General().msg(SQL);
		String nValue = "value ";
		SQL = " call CONF_getSpecificvalue('" + vpara + "', " + vstore + " , " + vcomp + ")";
		// new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
 			nValue = "0";
 		} else {
			nValue = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return nValue;
	}

	// =================Start Specific Configuration ===========

	public String PromoModuleActivated() throws Throwable {
		String status = "N";
		String vpara = "713";

		status = getSpecificConfiguration(vpara);
		return status;
	}

	public String getSpecificConfiguration(String vpara) throws Throwable {

		//new General(). msg(vpara);
 		String nValue = "value ";
  		SQL = " call CONF_getSpecificvalue('" + vpara + "', " + myvstore + " , " + myvcomp + ")";
		//new General(). msg(SQL);
   		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Configuration Data Is Not Available For This Store and Company .. Please Check Missing Para"+"-->"+ vpara);
			nValue = "0";
		} else {
			nValue = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return nValue;
	}

	// =================End Specific Configuration ===========

	public void getConfigValue() throws SQLException, ClassNotFoundException {
		// Either use this if value of configuration is store in variable and
		// refer variable in other calss
		// if this approach is not required then store configuration values
		// directly in array and use array
		String Conf_Get_ = "Conf_Get_";
		String fConf_Get_;
		String conf_value_ = "conf_value_";
		String fconf_value_;
		String NTOS = " ";
		String qt = "();";
		String SP = " ";
		String callSP;
		for (int no = 1; no <= 65; no++) {
			NTOS = Integer.toString(no).toString();
			fConf_Get_ = Conf_Get_.concat(NTOS).concat(qt);
			// new General().msg( fConf_Get_) ;
			Conf_Get_ = "Conf_Get_";
			fconf_value_ = conf_value_.concat(NTOS);
			String vpa = fconf_value_;
			// new General().msg( fconf_value_) ;
			SP = "Call".concat(" ").concat(fConf_Get_);
			// new General().msg( SP) ;
			System.out.println(no);
			rs = this.getSPResult(SP);
			rs.next();
			fconf_value_ = rs.getString(1);
			// new General().msg( fconf_value_) ;
			conf_value_ = " conf_value_";
			Conf_Get_ = "Conf_Get_";
			SP = " ";
		}
		new General().msg("Not in USe Configuration Loded Sucessfully");
	}

	public Vector getVector() {
		return config;
	}

	public void getconfigarry() throws SQLException, ClassNotFoundException {
		// Either use this or
		String Conf_Get_ = "Conf_Get_";
		String fConf_Get_;
		String conf_value_ = "conf_value_";
		String fconf_value_;
		String NTOS = " ";
		String qt = "();";
		String SP = " ";
		String callSP;
		int arrayno;

		for (int no = 1; no <= 63; no++) {
			arrayno = no - 1;
			NTOS = Integer.toString(no).toString();
			fConf_Get_ = Conf_Get_.concat(NTOS).concat(qt);
			Conf_Get_ = "Conf_Get_";
			fconf_value_ = conf_value_.concat(NTOS);
			String vpa = fconf_value_;
			SP = "Call".concat(" ").concat(fConf_Get_);
			System.out.println(no);
			rs = this.getSPResult(SP);
			rs.next();
			fconf_value_ = rs.getString(1).trim();
			config.add(fconf_value_);
		}
		new General().msg("Current Is In Use Configuration Loded Sucessfully");
	}

	public void setTextFielConfig(JTextField txt, String Para) throws Throwable {
		String paravalue = " ";
		String vstore = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = " call CONF_getSpecificvalue('" + Para + "', " + vstore + " , " + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("No Record Found .. Check configuration for Company/Store/Parameter ");
		} else {
			paravalue = rs.getString(1);
			switch (paravalue) {
			case "Y":
				txt.setEnabled(true);
				break;
			case "N":
				txt.setEnabled(false);
				break;
			}
		}
		rs.close();
		this.closeconn();
	}

	public void setBtnConfig(JButton btn, String Para) throws Throwable {
		String paravalue = " ";
		String vstore = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		String SQL = " call CONF_getSpecificvalue('" + Para + "', " + vstore + " , " + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("No Record Found .. Check configuration for Company/Store/Parameter ");
		} else {
			paravalue = rs.getString(1);
			switch (paravalue) {
			case "Y":
				btn.setEnabled(true);
				break;
			case "N":
				btn.setEnabled(false);
				btn.setBackground(Color.CYAN);
				break;
			}
		}
		rs.close();
		this.closeconn();

	}

	public String getCompanyVerticleCode(String vcomp, String vstore) throws ClassNotFoundException, SQLException {
		String nValue = "value ";
		String vtype = "BranchVerticle";
		SQL = " call     CONF_getGeneralInfo(" + vcomp + " , " + vstore + " , '" + vtype + "')";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Verticle is not mention for  this branch- Error Config Setting ");
			nValue = "0";
		} else {
			nValue = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return nValue;

	}

	public String getCompanyVerticleName(String vcomp, String vstore) throws ClassNotFoundException, SQLException {
		String nValue = "value ";
		String vtype = "CompanyVerticle";

		SQL = " call     CONF_getGeneralInfo(" + vcomp + " , " + vstore + " , '" + vtype + "')";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Verticle is not mention for this Company- Error Config Setting ");
			nValue = "0";
		} else {
			nValue = rs.getString(2);
		}
		rs.close();
		this.closeconn();
		return nValue;
	}

	public String getDaybeginDate(String vcomp, String vstore) throws Throwable {
		String beginDate = null;
		String SQL = " call getDaybeginDate(" + vstore + " , " + vcomp + ")";
		try {
			rs = this.getSPResult(SQL);
			rs.next();
			beginDate = rs.getString(1);
			rs.close();
			this.closeconn();

		} catch (Exception e1) {
			new General().msg(e1.getMessage());
		}
		this.closeconn();
		return beginDate;
	}

	public String getVerticleCode(String vcomp, String vstore) throws ClassNotFoundException, SQLException {

		String nValue = "value ";
		String vtype = "Verticle";
		SQL = " call     CONF_getGeneralInfo(" + vcomp + " , " + vstore + " , '" + vtype + "')";
 		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Verticle is not mention for this Site- Error Config Setting ");
			nValue = "0";
		} else {
			nValue = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return nValue;
	}

	public String getVerticleName(String vcomp, String vstore) throws ClassNotFoundException, SQLException {

		String nValue = "";
		String vtype = "Verticle";
		SQL = " call     CONF_getGeneralInfo(" + vcomp + " , " + vstore + " , '" + vtype + "')";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Verticle is not mention for this Site- Error Config Setting ");
			nValue = "0";
		} else {
			nValue = rs.getString(2);
		}
		rs.close();
		this.closeconn();
		return nValue;
	}

	public String getFormatCode(String vcomp, String vstore) throws ClassNotFoundException, SQLException {
		String nValue = "value ";
		String vtype = "Format";
		SQL = " call     CONF_getGeneralInfo(" + vcomp + " , " + vstore + " , '" + vtype + "')";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Format  is not mention for this Site- Error Config Setting ");
			nValue = "0";
		} else {
			nValue = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return nValue;
	}

	public String getFormatName(String vcomp, String vstore) throws ClassNotFoundException, SQLException {
		String nValue = "";
		String vtype = "Format";
		SQL = " call     CONF_getGeneralInfo(" + vcomp + " , " + vstore + " , '" + vtype + "')";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Verticle is not mention for this Site- Error Config Setting ");
			nValue = "0";
		} else {
			nValue = rs.getString(2);
		}
		rs.close();
		this.closeconn();
		return nValue;
	}

	public String getSegmentCode(String vcomp, String vstore) throws ClassNotFoundException, SQLException {
		String nValue = "value ";
		String vtype = "Segment";
		SQL = " call     CONF_getGeneralInfo(" + vcomp + " , " + vstore + " , '" + vtype + "')";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Verticle is not mention for this Site- Error Config Setting ");
			nValue = "0";
		} else {
			nValue = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return nValue;
	}

	public String getSegmentName(String vcomp, String vstore) throws ClassNotFoundException, SQLException {
		String nValue = "";
		String vtype = "Segment";
		SQL = " call     CONF_getGeneralInfo(" + vcomp + " , " + vstore + " , '" + vtype + "')";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Verticle is not mention for this Site- Error Config Setting ");
			nValue = "0";
		} else {
			nValue = rs.getString(2);
		}
		rs.close();
		this.closeconn();
		return nValue;
	}

	public String getBranchTypeCode(String vcomp, String vstore) throws ClassNotFoundException, SQLException {

		String nValue = "value ";
		String vtype = "BranchType";
		SQL = " call     CONF_getGeneralInfo(" + vcomp + " , " + vstore + " , '" + vtype + "')";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Branch Type is  not mention for this Site- Error Config Setting ");
			nValue = "0";
		} else {
			nValue = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return nValue;
	}

	public String getBranchTypeName(String vcomp, String vstore) throws ClassNotFoundException, SQLException {
		String nValue = "value ";
		String vtype = "BranchType";
		SQL = " call     CONF_getGeneralInfo(" + vcomp + " , " + vstore + " , '" + vtype + "')";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("Branch Type is  not mention for this Branch- Error Config Setting ");
			nValue = "0";
		} else {
			nValue = rs.getString(2);
		}
		rs.close();
		this.closeconn();
		return nValue;
	}

	private String getforamtcode(String compcode, String storecode) throws Throwable {
		String SQl2 = "Call  site_getFormat(" + compcode + " , " + storecode + ")";
		String vformat;
		rs2 = this.getSPResult(SQl2);
		if (rs2.next()) {
			vformat = rs2.getString(1);
		}
		rs.close();
		this.closeconn();
		return format;
	}

	public String AllowNegInv() throws Throwable {
		String paravalue = " ";
		String vstore = new gnConfig().getStoreID();
		String vcomp = new gnConfig().getCompanyCode();
		String Para = "710";
		String SQL = " call CONF_getSpecificvalue('" + Para + "', " + vstore + " , " + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (!rs.next()) {
			new General().msg("No Record Found .. Check configuration for Company/Store/Parameter ");
		} else {
			paravalue = rs.getString(1);
		}
		rs.close();
		this.closeconn();
		return paravalue;
	}

	public static void main(String[] args) throws SQLException {
		// new getConfigurationSetting().getconfigarry();
	}
}

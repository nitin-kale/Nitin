package RetailProduct;

import java.sql.Connection;
import java.sql.SQLException;

public class gnPromoGetInfo extends getResultSet {

	Connection con, con1, con2;
	String DBhdr;
	public static String vapplicablity = "N";
	public static double vfromqty = 0.0;

	public static double vtoqty = 0.0;
	public static double vfreearticle = 0.0;
	public static String vvfreearticle = "0";
	public static String vname = "0";

	public static double vfreeqty = 0.0;
	public static double vmyfreeqty = 0.0;
	public static double vdiscper = 0.0;
	public static double vdiscamt = 0.0;
	public static double vconvaluefrom = 0.0;
	public static double vconditionto = 0.0;
	public static String vbrand = "0";
	public static String varticle = "0";
	public static double vpurqty = 0.0;
	public static double vpurvalue = 0.0;
	public static String vtype = "";
	public static String vpromono = "";
	public static String vpromotypecode = "";
	public static String vpromotype = "";
	public static String vconditionOn = "";
	public static String vapplyFreePromoNow = "N";
	public static String vsalesandFreeArticleSame = "N";
	public static String vmyarticle = "";

	public void getPromoInfo(String varticle, String vinvdate) {

	}

	public double promo_getBillQtyForArticle(String vdocno, String vdocdate, String varticlecode)
			throws ClassNotFoundException, SQLException {
		double vbillqty = 0;
		String vtype = "ArticleBillQty";
		String SQL = "call Promo_applyGeneralUpdate( '" + vtype + "' ," + compcode + " , " + vstore + ", " + vdocno
				+ " , '" + vdocdate + "' , " + varticlecode + ")";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vbillqty = Double.parseDouble(rs.getString(1));
		}
		return vbillqty;
	}

	public void refreshPromoTables(String vdocno, String vdocdate) throws Throwable {
		
		switch(promoModuleActivated.trim())
 		{
 			case "Y" :
			String vtype = "RefreshPromoTables";
			vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate);
			String SQL = "call promo_getInfo( '" + vtype + "',    " + compcode + " , " + vstore + ", " + vdocno + " , '"
					+ vdocdate + "')";
			//new General().msg(SQL);
			this.getSPResult(SQL);
			new gnLogger().loggerInfoEntry("Promotion", "All Promo Ralated Tables Are Refresh Sucessfully");
			break ;
 		}
	}

	public String getBillexist1(String vdocno, String vdocdate) throws ClassNotFoundException, SQLException {
		String vexist = "0";
		String vtype = "BillNoExist2";
		String SQL = "call promo_getInfo('" + vtype + "' , " + compcode + " , " + vstore + " , " + vdocno + " , '"
				+ vdocdate + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vexist = rs.getString(1);
		}
		return vexist;
	}

	public void deactivatePromo(String vdocno, String vdocdate) {

		String vtype = "DecativatePromo";
		String SQL = "call promo_getInfo('" + vtype + "' , " + compcode + " , " + vstore + " , " + vdocno + " , '"
				+ vdocdate + "')";
		try {
			// new General().msg(SQL);
			this.getSPResult(SQL);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			new General().msg(e.getLocalizedMessage());
		}
	}

	public String getBillexist2(String vdocno, String vdocdate) throws ClassNotFoundException, SQLException {
		String vexist = "0";
		String vtype = "BillNoExist2";
		String SQL = "call promo_getInfo('" + vtype + "' , " + compcode + " , " + vstore + " , " + vdocno + " , '"
				+ vdocdate + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vexist = rs.getString(1);
		}
		return vexist;
	}

	public String getBillValue(String vdocno, String vdocdate) throws ClassNotFoundException, SQLException {
		String retvalue = "";
		// vdocdate = new gnConfig().date_ConverttoDBforamt(vdocdate) ;
		String vtype = "BillValue";
		String SQL = " call  promo_getInfo('" + vtype + "' , " + compcode + " , " + vstore + " , " + vdocno + " , '"
				+ vdocdate + "')";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			retvalue = rs.getString(1);
		}
		return retvalue;
	}

	public String getPromoInfo(String vtype, String vdate, String vcode, String vqty, String vvalue)
			throws ClassNotFoundException, SQLException {
		vapplicablity = "N";
		// vdate = new gnConfig().date_ConverttoDBforamt(vdate) ;
		String SQL = "Call Promo_CheckApplicablity('" + vtype + "' , " + compcode + " , " + vstore + " ,  '" + vdate
				+ "' ,  '" + vcode + "' , " + vqty + ", " + vvalue + " )";
		// new General().msg("Nitin"+" "+SQL);
		rs1 = this.getSPResult(SQL);
		if (rs1.next()) {
			vapplicablity = "Y";
			new General().msg("Promotion is running on this Items/Bill Level");
			vpromotypecode = rs1.getString(1);
			new General().msg(vpromotypecode);
			vpromotype = rs1.getString(2);
			vtype = rs1.getString(3);
			vpromono = rs1.getString(4);
			vmyarticle = rs1.getString(5);
			vname = rs1.getString(6);
			vconditionOn = rs1.getString(7);
			vconvaluefrom = Double.parseDouble(rs1.getString(8));
			vconditionto = Double.parseDouble(rs1.getString(9));
			vdiscper = Double.parseDouble(rs1.getString(10));
			vdiscamt = Double.parseDouble(rs1.getString(11));
			vfreearticle = Double.parseDouble(rs1.getString(12));
			vvfreearticle = rs1.getString(12);
			vfreeqty = Double.parseDouble(rs1.getString(13));
		}
		return vapplicablity;
	}

}

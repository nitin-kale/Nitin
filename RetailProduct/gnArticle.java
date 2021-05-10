package RetailProduct;

import java.sql.SQLException;

public class gnArticle extends getResultSet {

	// private String vcomp;
	// private String vstore;

	
	
	
	
	
	public String Article_getData(String myarticle, String vtype) throws ClassNotFoundException, SQLException {
		String returnvalue = "";
		String vverticle = new gnHierarchy().getVerticleCode().trim();
		String SQL = "call article_getData( '" + vtype + "' ,   " + compcode + " ,  '" + myarticle + "'  )";
 		//new General().msg(SQL);
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			returnvalue = rs.getString(1);
		}
		return returnvalue;
	}

	
	
	
	
	public String Article_getPurchaseData(String varticle, String vreporttype) throws Throwable {
		String value = "";
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vverticle = new gnHierarchy().getVerticleCode();
		String SQL = "call  view_PurchaseData('" + vreporttype + "' , " + compcode + " , " + storecode + " , '"
				+ vfinyear + "', '" + varticle + "' , " + vverticle + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			value = rs.getString(1);
		}
		return value;

	}

	public String Article_getSalesData(String varticle, String vreporttype) throws Throwable {
		String value = "";
		String vfinyear = new gnFinYear().getReportingFinYear();
		String vverticle = new gnHierarchy().getVerticleCode();
		String SQL = "call  view_SalesData('" + vreporttype + "' , " + compcode + " , " + storecode + " , '" + vfinyear
				+ "', '" + varticle + "' , " + vverticle + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			value = rs.getString(1);
		}
		return value;

	}

 	
	

	public String Article_getArticleTaxSlabCode(String vamount) throws ClassNotFoundException, SQLException {
		String vtaxcode = "0";
		String vverticle = new gnHierarchy().getVerticleCode().trim();
		String SQL = "call article_getSlabTaxcode( '" + vverticle + "' , " + vamount + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vtaxcode = rs.getString(1);
		} else {
			new General().msg("Tax Slab Not Maintained , Please Create Tax Slab ...");
		}
		return vtaxcode;
	}

	public String Article_isTaxSlabAppliccable(String varticle) throws SQLException, ClassNotFoundException {
		String vapplicable = "N";
		String SQL = "call article_getTaxSlabApplicable(" + compcode + ", " + varticle + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vapplicable = rs.getString(1);
		}
		return vapplicable;
	}

	private void setDefault() {
		vcomp = new gnConfig().getCompanycode();
		try {
			vstore = new gnConfig().getStoreID();
		} catch (Throwable e) {
			new General().msg(e.getMessage());
		}
	}

	public String getAvgCostofProduct(String varticle) throws ClassNotFoundException, SQLException {
		setDefault();
		String value = "";
		String vtype = "Avgcost";
		String SQL = "Call Article_getData( '" + vtype + "'  ,  " + vcomp + "   ,  '" + varticle + "'  )";
		rs = this.getSPResult(SQL);
		rs.next();
		value = rs.getString(1);
		rs.close();
		this.closeconn();
		return value;

	}

	public String GetcalculatedAvgCost(String varticle, String vcost)
			throws NumberFormatException, ClassNotFoundException, SQLException {
		String value = "";
		Double vavgcost = Double.parseDouble(getAvgCostofProduct(varticle));
		vavgcost = (vavgcost + Double.parseDouble(vcost)) / 2;
		value = Double.toString(vavgcost);
		return value;

	}

	public void SetAvgcost(String varticle, String vavgcost)
			throws NumberFormatException, ClassNotFoundException, SQLException {
		setDefault();
		String vtype = "SetAvgcost";
		String SQL = "Call Article_SetData( '" + vtype + "'  ,  " + vcomp + "   ,  '" + varticle + "'  , '" + vavgcost
				+ "' )";
		this.getSPResult(SQL);

	}

}

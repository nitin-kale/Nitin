package RetailProduct;

public class gnUomPriceConvert extends getResultSet {

	String vcomp;
	String vstore;
	public static String vpurchaseUOM = "NO";
	public static String vinnerqty = "1";

	public static String vunitcost;
	public static String vunitmrp;
	public static String vunitsp;

	public static String vpuom_cost;
	public static String vpuom_mrp;
	public static String vpuom_sp;
	String SQL;

	public void getpurchaseUOMandInnerQty(String varticlecode) throws Throwable {
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		SQL = "call PurUom_GetPurUOMPriceDetails(" + vcomp + ", " + vstore + ", " + varticlecode + ")";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vpurchaseUOM = rs.getString(2);
			vinnerqty = rs.getString(3);
			vpuom_cost = rs.getString(4);
			vpuom_mrp = rs.getString(5);
			vpuom_sp = rs.getString(6);
		}
		if (vpurchaseUOM != "NO") {
			getUnitPrices(vinnerqty, vpuom_cost, vpuom_mrp, vpuom_sp);
		}

	}

	public void getUnitPrices(String vinnerQty, String vpurUomCOST, String vpurUomMRP, String vpurUomSP) {
		double vpuomcost = Double.parseDouble(vpurUomCOST);
		double vpuommrp = Double.parseDouble(vpurUomMRP);
		double vpuomsp = Double.parseDouble(vpurUomSP);
		double vinnerqty = Double.parseDouble(vinnerQty);

		double vvunitcost = vpuomcost / vinnerqty;
		double vvunitmrp = vpuommrp / vinnerqty;
		double vvunitsp = vpuomsp / vinnerqty;

		vunitcost = new gnMath().get2DecimaltValue(Double.toString(vvunitcost));
		vunitmrp = new gnMath().get2DecimaltValue(Double.toString(vvunitmrp));
		vunitsp = new gnMath().get2DecimaltValue(Double.toString(vvunitsp));

	}

	public void getBoxPrices(String vinnerQty, String vpurUomCOST, String vpurUomMRP, String vpurUomSP) {
		double vpuomcost = Double.parseDouble(vpurUomCOST);
		double vpuommrp = Double.parseDouble(vpurUomMRP);
		double vpuomsp = Double.parseDouble(vpurUomSP);
		double vinnerqty = Double.parseDouble(vinnerQty);

		double vvunitcost = vpuomcost * vinnerqty;
		double vvunitmrp = vpuommrp * vinnerqty;
		double vvunitsp = vpuomsp * vinnerqty;

		vunitcost = new gnMath().get2DecimaltValue(Double.toString(vvunitcost));
		vunitmrp = new gnMath().get2DecimaltValue(Double.toString(vvunitmrp));
		vunitsp = new gnMath().get2DecimaltValue(Double.toString(vvunitsp));

	}

}

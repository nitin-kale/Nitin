package RetailProduct;

import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JTable;

public class gnPromoCheck extends getResultSet {

	Connection con, con1, con2, con8;
	String DBhdr;
	String DBaction;
	public static String vapplicablity = "N";
	public static double vfromqty = 0.0;
	public static double vtoqty = 0.0;
	public static double vfreearticle = 0.0;
	public static String vvfreearticle = "0";
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
	private String vbillno = "";
	private String vbilldate = "";

	private static String vtotalbillvalue;
	String vqty;
	String vvalue;

	public void collectDataForPromocheck(String vinvno, String vinvdate) throws SQLException, ClassNotFoundException {

		new gnLogger().loggerInfoEntry("POS", "Collecting Data for Promo Execution .. ");
		String SQL = "call Promo_collectData(" + compcode + " , " + vstore + " , " + vinvno + " ,  '" + vinvdate
				+ "' )";
		this.getSPResult(SQL);
		new gnLogger().loggerInfoEntry("POS", "Data Collected Sucessfully  .. ");

	}

	private void baseAction(String vinvno, String vinvdate) throws SQLException, ClassNotFoundException {
		String SQL;
		String vtype = "FreeArticle";
		SQL = "call Promo_baseAction( '" + vtype + "' ,  " + compcode + " , " + vstore + " , " + vinvno + " , '"
				+ vinvdate + "')";
		this.getSPResult(SQL);
		/// Insert Data PromoTable Replica of POS Screen in table
		SQL = "call Promo_applyonTable(" + compcode + " , " + vstore + " , " + vinvno + " , '" + vinvdate + "')";
		this.getSPResult(SQL);
		// end of Replica creation

	}

	public void applyPromoNow(String vinvno, String vinvdate) throws Throwable {
		String vword = "FreeArticle";
		vbilldate = vinvdate;
		vbillno = vinvno;
		String vstatus = "Fail";
		baseAction(vinvno, vinvdate);
		newApplyItemLevel(vinvno, vinvdate);

		// Brand Hierarchy Promotion
		String vtype = "Brand";
		newApplyBrandAndHierarchyLevel(vinvno, vinvdate, vtype);

		vtype = "SubCategory";
		newApplyBrandAndHierarchyLevel(vinvno, vinvdate, vtype);

		vtype = "Category";
		newApplyBrandAndHierarchyLevel(vinvno, vinvdate, vtype);
		// End Brand Hierarchy Promotion

		applyFreePromoOntable(vinvno, vinvdate); // Promo For FreeArticle will
													// Apply in Table

 	}

	
	
	
	public void newApplyItemLevel(String vinvno, String vinvdate)
			throws ClassNotFoundException, SQLException, IOException {
		// This Methos is Applicable For Item Level disc% /Amount /Free ARticle
		// and insert data into promo table for apply
		double vtotalbillqty = 0;
		double vtotalbillvalue = 0;
		double vratiobillvalueperpc = 0;
		double vratiobillvalueper = 0;
		String vgivendiscamt = "0";
		String vperpiceqty = "0";
		String vcode = "0";
		String vbillqty = "0";
		String vname = "0";
		String vpromoType = "";
		String vbillvalue;
		double vpurcondfrom = 0.0;
		double vpurcondto = 0.0;
		double vvbillvalue = 0.00;
		double vvdiscper = 0;
		double vvdiscamt = 0;
		double vvdiscperqty = 0.0;
		double vvbillqty = 0.00;
		double vfreeqty = 0.00;
		int vmyfreeqty = 0;
		String vtype = "Article";
		String SQL = "select    code , Name , billdate, billqty , billvalue , "
				+ "TotalBillValue,Brandcode, Catcode , Subcatcode , groupcode, subgroupcode "
				+ "    from  tmp_promo_check where Company_code = " + compcode + " and site_code = " + vstore
				+ "  and BillDate = '" + vinvdate + "' and BillNo =  '" + vinvno + "'  ";
		// new General().msg(SQL);
		rs1 = this.getSPResult(SQL);

		while (rs1.next()) {
			vcode = rs1.getString(1);
			vname = rs1.getString(2);
			vbillqty = rs1.getString(4);
			vbillvalue = rs1.getString(5);
			vvbillvalue = Double.parseDouble(vbillvalue);
			vvbillqty = Double.parseDouble(vbillqty);
			// new General().msg("Outer Loop Checking For Article"+ "" +vcode+ "
			// "+vname);
			SQL = "call Promo_CheckApplicablity( '" + vtype + "'  ,  " + compcode + " , " + vstore + "  , '" + vinvdate
					+ "'  , " + vcode + " , " + vbillqty + "  , " + vbillvalue + ")";
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				// For All Item If Available in into Promo Execution Table
				//
				vpromoType = rs.getString(1).trim();
				switch (vpromoType) {
				case "1":
					// new General().msg("Inserting Item Disc% Promotions");
					new gnLogger().loggerInfoEntry("PromoCheckAndEntry", "Inserting Item Disc% Promotions");
					vvdiscper = Double.parseDouble(rs.getString(10));
					vpurcondfrom = Double.parseDouble(rs.getString(8));
					vpurcondto = Double.parseDouble(rs.getString(9));
					if (vvbillqty > vpurcondto) {
						vratiobillvalueperpc = vvbillvalue / vvbillqty;
						vratiobillvalueper = vratiobillvalueperpc * vpurcondto;
						vvdiscamt = vratiobillvalueper * vvdiscper / 100;
						vgivendiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));
						vvdiscperqty = vvdiscamt / vpurcondto;
						vperpiceqty = new gnMath().get2DecimaltValue(Double.toString(vvdiscperqty));
						if (vperpiceqty.length() == 0 || vperpiceqty == "") {
							vperpiceqty = "0";
						}
					}

					if (vvbillqty <= vpurcondto) {
						vvdiscamt = vvbillvalue * vvdiscper / 100;
						vgivendiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));
						vvdiscperqty = vvdiscamt / vvbillqty;
						vperpiceqty = new gnMath().get2DecimaltValue(Double.toString(vvdiscperqty));
						if (vperpiceqty.length() == 0 || vperpiceqty == "") {
							vperpiceqty = "0";
						}
					}
					break;

				case "2":
					// new General().msg("Inserting Item Disc Amount
					// Promotions");
					new gnLogger().loggerInfoEntry("PromoCheckAndEntry", "Inserting Item Discount Promotions");
					vvdiscamt = Double.parseDouble(rs.getString(11));
					vpurcondfrom = Double.parseDouble(rs.getString(8));
					vpurcondto = Double.parseDouble(rs.getString(9));
					if (vvbillqty > vpurcondto) {
						vvdiscamt = vpurcondto * vvdiscamt;
					}

					if (vvbillqty <= vpurcondto) {
						vvdiscamt = vvbillqty * vvdiscamt;
					}
					vgivendiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));
					vvdiscperqty = vvdiscamt / vvbillqty;
					vperpiceqty = new gnMath().get2DecimaltValue(Double.toString(vvdiscperqty));
					if (vperpiceqty.length() == 0 || vperpiceqty == "") {
						vperpiceqty = "0";
					}
					break;

				case "5":
					// new General().msg("Free Article Discount x on X");
					new gnLogger().loggerInfoEntry("PromoCheckAndEntry", "Free Article Discount x on X");
					vfreeqty = Double.parseDouble(rs.getString(13));
					vpurcondfrom = Double.parseDouble(rs.getString(8));
					vpurcondto = Double.parseDouble(rs.getString(9));
					if (vvbillqty > vpurcondto) {
						vmyfreeqty = (int) (vpurcondto * vfreeqty / vpurcondfrom);
						vvdiscamt = (vvbillvalue / vvbillqty) * vmyfreeqty;
						vvdiscperqty = vvdiscamt / vmyfreeqty;
						vperpiceqty = new gnMath().get2DecimaltValue(Double.toString(vvdiscperqty));
						vgivendiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));

					}

					if (vvbillqty <= vpurcondto) {
						vmyfreeqty = (int) (vvbillqty * vfreeqty / vpurcondfrom);
						vvdiscamt = (vvbillvalue / vvbillqty) * vmyfreeqty;
						vvdiscperqty = vvdiscamt / vmyfreeqty;
						vperpiceqty = new gnMath().get2DecimaltValue(Double.toString(vvdiscperqty));
						vgivendiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));

					}

					break;

				case "6":
					// new General().msg("Free Article Discount x on Y");
					new gnLogger().loggerInfoEntry("PromoCheckAndEntry", "Free Article Discount x on Y");
					vfreeqty = Double.parseDouble(rs.getString(13));
					vpurcondfrom = Double.parseDouble(rs.getString(8));
					vpurcondto = Double.parseDouble(rs.getString(9));
					if (vvbillqty > vpurcondto) {
						vmyfreeqty = (int) (vpurcondto * vfreeqty / vpurcondfrom);
						vvdiscamt = (vvbillvalue / vvbillqty) * vmyfreeqty;
						vvdiscperqty = vvdiscamt / vmyfreeqty;
						vperpiceqty = new gnMath().get2DecimaltValue(Double.toString(vvdiscperqty));
						vgivendiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));

					}
					if (vvbillqty <= vpurcondto) {
						vmyfreeqty = (int) (vvbillqty * vfreeqty / vpurcondfrom);
						vvdiscamt = (vvbillvalue / vvbillqty) * vmyfreeqty;
						vvdiscperqty = vvdiscamt / vmyfreeqty;
						vperpiceqty = new gnMath().get2DecimaltValue(Double.toString(vvdiscperqty));
						vgivendiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));
					}
					break;
				}// Switch
				//
				DBaction = "Fail";
				String mode = " ";
				prst = null;
				final int batchSize = 1;
				int TotalRecordinsert = 0;
				con8 = this.getConnection();
				con8.setAutoCommit(false);
				String Status = "Fail";
				String pospayment = "Insert into     tmp_pos_promoApply(company_code , "
						+ "site_code, billno , billdate,  article_code, name, qty, value, "
						+ "promotypecode, promoTypename, "
						+ " promocode , purchasecondfrom , purcondto, ApplyPromo, DiscPer , DiscAmt, ApplyDiscamt, perqtydiscamt, freearticle , freeqty ) "
						+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				prst = con8.prepareStatement(pospayment);
				try {
					prst.setString(1, vcomp);
					prst.setString(2, vstore);
					prst.setString(3, vinvno);
					prst.setString(4, vinvdate);
					prst.setString(5, vcode);
					prst.setString(6, vname);
					prst.setString(7, vbillqty);
					prst.setString(8, vbillvalue);
					prst.setString(9, rs.getString(1).trim());
					prst.setString(10, rs.getString(2).trim());
					prst.setString(11, rs.getString(4).trim());
					prst.setString(12, rs.getString(8).trim());
					prst.setString(13, rs.getString(9).trim());
					prst.setString(14, "Y");
					prst.setString(15, rs.getString(10).trim());
					prst.setString(16, rs.getString(11).trim());
					prst.setString(17, vgivendiscamt);
					prst.setString(18, vperpiceqty.trim());
					prst.setString(19, rs.getString(12).trim());
					prst.setString(20, Double.toString(vmyfreeqty));
					prst.addBatch();
					TotalRecordinsert = TotalRecordinsert + 1;
					if (++TotalRecordinsert % batchSize == 0) {
						prst.executeBatch();
						con8.commit();
						DBaction = "Sucess";
					}
					prst.executeBatch(); // insert remaining records
					con8.commit();
					DBaction = "Sucess";
				} catch (SQLException e) {
					new General().msg("Item Level Promo Error=>" + e.getMessage());
					new gnLogger().loggerDebugEntry("POS",
							"Promo Bill Level Apply" + "vInvNo:" + "" + vinvno + "" + e.getMessage());
					con8.rollback();
					DBaction = "Fail";
				} finally {
					if (prst != null) {
						// prst.close();
						new gnLogger().loggerDebugEntry("POS", "PS BILL LEVEL PROMO" + "InvNo:" + "" + vinvno);
						try {
						} catch (Exception e2) {
							new General().msg("Free Qty Error :" + e2.getLocalizedMessage());
							e2.printStackTrace();
						}
					}
					if (con8 != null) {
						con8.close();
					}
				}
			}
			//
		} // item promo_check table itertem ate for each article to check First
			// Wfile Rs1 for item

	}// end item level promo check

	private void applyFreePromoOntable(String vinvno, String vinvdate) throws ClassNotFoundException, SQLException {
		// new General().msg("Now Updating in Table Free Qty Process ");
		String SQL = "";
		String SQL1 = "";
		String vfreearticle = "";
		double vfreeqty = 0;
		double vfreerate = 0;
		double vfreediscamt = 0;

		String rowUpdated = "N";
		String tablefreearticle = "";
		double balFreeqty = 0;
		double allocateFreeqty = 0;
		double tableqty = 0;
		double tablerate = 0;
		double freeqty = 0;
		double vtmpissueqty = 0;
		String vsrno = "";
		String vfreedesc = "FreeArticle";
		String vtype = "GetFreeArticlesForPromoApply";
		SQL = "call Promo_getInfo('" + vtype + "' , " + compcode + " , " + vstore + " , " + vinvno + " , '" + vinvdate
				+ "' )";
		// new General().msg("Get Free Article Promo Data From Base Table:" + "
		// "+ SQL);
		rs2 = this.getSPResult(SQL);
		while (rs2.next()) {
			rowUpdated = "N";
			balFreeqty = 0;
			tableqty = 0;
			vfreearticle = "";
			tablerate = 0;
			allocateFreeqty = 0;
			vfreearticle = rs2.getString(1);
			vfreeqty = Double.parseDouble(rs2.getString(2));
			// new General().msg("Fetching Free Article and Qty is ==> :" +
			// vfreearticle + " Free Qty is "+vfreeqty);
			balFreeqty = vfreeqty;
			SQL1 = " select    Article_code , Name, qty, rate, disc  , srno"
					+ "    from  promo_applyontable  where Company_code = " + compcode + " and site_code = " + vstore
					+ "  " + "   and article_code  = " + vfreearticle + "  and BillDate = '" + vinvdate
					+ "' and BillNo =  '" + vinvno + "'   and freeArticle_disc <> '" + vfreedesc + "'  ";
			// new General().msg(SQL1);
			rs1 = this.getSPResult(SQL1);
			while (rs1.next()) {
				rowUpdated = "N";
				tablefreearticle = rs1.getString(1);
				tableqty = Double.parseDouble(rs1.getString(3));
				tablerate = Double.parseDouble(rs1.getString(4));
				vsrno = rs1.getString(6);
				if (tablefreearticle.equalsIgnoreCase(vfreearticle)) {
					// new General().msg("Free found in table Article and Qty is
					// and srno :" + tablefreearticle + "srno-> "+vsrno);
					if (tableqty == balFreeqty && balFreeqty > 0 && rowUpdated.equalsIgnoreCase("N")) {
						// new General().msg("in table qty found :" + tableqty
						// );
						allocateFreeqty = allocateFreeqty + tableqty;
						vfreediscamt = tableqty * tablerate;
						balFreeqty = vfreeqty - allocateFreeqty;
						updateFreeDisconTable(vinvdate, vinvno, vfreearticle, vsrno, vfreediscamt);
						rowUpdated = "Y";
					}

					if (tableqty < balFreeqty && balFreeqty > 0 && rowUpdated.equalsIgnoreCase("N")) {
						allocateFreeqty = allocateFreeqty + tableqty;
						vfreediscamt = tableqty * tablerate;
						balFreeqty = vfreeqty - allocateFreeqty;
						updateFreeDisconTable(vinvdate, vinvno, vfreearticle, vsrno, vfreediscamt);
						rowUpdated = "Y";
					}

					if (tableqty > balFreeqty && balFreeqty > 0 && rowUpdated.equalsIgnoreCase("N")) {
						vfreediscamt = balFreeqty * tablerate;
						allocateFreeqty = allocateFreeqty + balFreeqty;
						balFreeqty = vfreeqty - allocateFreeqty;
						updateFreeDisconTable(vinvdate, vinvno, vfreearticle, vsrno, vfreediscamt);
						rowUpdated = "Y";
					}
				} // inner loop if condition

			} // Inner Rs1 Loop

		} // Outer Rs Loop
	}

	private void updateFreeDisconTable(String vinvdate, String vinvno, String varticlecode, String vsrno,
			double vmydiscamt) {
		// new General().msg("I am in update Methos now") ;
		String vfreedesc = "FreeArticle";
		String vtype = "UpdateBaseFreeDiscamt";
		// new General().msg("FreeDiscmat " + "-->" + vmydiscamt) ;
		String SQL = "update    promo_applyonTable set disc =  " + vmydiscamt + " , freearticle_disc = '" + vfreedesc
				+ "' " + "    where  Company_code = " + compcode + " and site_code = " + vstore + "  " + " and srno = "
				+ vsrno + " and article_code = " + varticlecode + " and BillDate = '" + vinvdate + "' and BillNo =  '"
				+ vinvno + "'  ";

		String SQL1 = "Call Promo_applyGeneralUpdate('" + vtype + "' , " + compcode + " , " + vstore + " ,  '" + vinvno
				+ "'  , '" + vinvdate + "' , " + varticlecode + ")";

		try {
			this.getResult(SQL);
			this.getResult(SQL1);
		} catch (SQLException e) {
			e.printStackTrace();
			new General().msg(e.getLocalizedMessage());
		}
	}

	public void newApplyBrandAndHierarchyLevel(String vinvno, String vinvdate, String vtype) throws Throwable {
		String vgivendiscamt = "0";
		String vperpiceqty = "0";
		String vcode = "0";
		String vbillqty = "0";
		String vname = "0";
		String vpromoType = "";
		String vbillvalue;
		double vpurcondfrom = 0.0;
		double vpurcondto = 0.0;
		double vvbillvalue = 0.00;
		double vvdiscper = 0;
		double vvdiscamt = 0;

		double vvdiscperqty = 0.0;
		double vvbillqty = 0.00;
		double vfreeqty = 0.00;
		int vmyfreeqty = 0;
		// String vtype = "Article" ;
		String SQL = "select    type , code , billqty , billvalue  "
				+ "    from  tmp_promo_brandhierarchy where Company_code = " + compcode + " and site_code = " + vstore
				+ "  and BillDate = '" + vinvdate + "'" + "  and BillNo =  '" + vinvno + "'  and type = '" + vtype
				+ "'  ";
		//
		rs1 = this.getSPResult(SQL);
		while (rs1.next()) {
			vcode = rs1.getString(2);
			switch (vtype) {
			case "Brand":
				String vtype1 = "Description";
				vname = new gnAdmin().master_getDescriptionofcode(vtype1, vcode, vtype);
				break;

			case "Category":
				vtype1 = "CatName";
				vname = new gnHierarchy().getNameofgivenCode(vtype1, vcode);
				break;

			case "SubCategory":
				vtype1 = "SubCatName";
				vname = new gnHierarchy().getNameofgivenCode(vtype1, vcode);
				break;
			}

			vbillqty = rs1.getString(3);
			vbillvalue = rs1.getString(4);
			vbillvalue = new gnMath().get2DecimaltValue(vbillvalue);
			vvbillvalue = Double.parseDouble(vbillvalue);
			vvbillqty = Double.parseDouble(vbillqty);
			//

			SQL = "call Promo_CheckApplicablity( '" + vtype + "'  ,  " + compcode + " , " + vstore + "  , '" + vinvdate
					+ "'  , '" + vcode + "' , " + vbillqty + "  , " + vbillvalue + ")";
			rs2 = this.getSPResult(SQL);
			while (rs2.next()) {
				vpromoType = rs2.getString(1).trim();
				vvdiscper = Double.parseDouble(rs2.getString(10));
				vpurcondfrom = Double.parseDouble(rs2.getString(8));
				vpurcondto = Double.parseDouble(rs2.getString(9));

				if (vvbillvalue <= vpurcondto) {
					vvdiscamt = vvbillvalue * vvdiscper / 100;
					vgivendiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));
					vvdiscperqty = vvdiscamt / vvbillqty;
					vperpiceqty = new gnMath().get2DecimaltValue(Double.toString(vvdiscperqty));
				}

				if (vvbillvalue > vpurcondto) {
					vvdiscamt = vpurcondto * vvdiscper / 100;
					vgivendiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));
					vvdiscperqty = vvdiscamt / vvbillqty;
					vperpiceqty = new gnMath().get2DecimaltValue(Double.toString(vvdiscperqty));
				}

				if (vperpiceqty.length() == 0 || vperpiceqty == "") {
					vperpiceqty = "0";
				}

				// Applying actualdisc on promo_applyontable for all brand and
				// hierarchy
				String SQL7 = "call Promo_ApplyBrandandHierarchy('" + vtype + "', '" + vcode + "',  " + vperpiceqty
						+ " ,  " + compcode + " , " + vstore + " , " + vinvno + " , '" + vinvdate + "')";
				this.getSPResult(SQL7);
				//
			}

			SQL = "call Promo_CheckApplicablity( '" + vtype + "'  ,  " + compcode + " , " + vstore + "  , '" + vinvdate
					+ "'  , '" + vcode + "' , " + vbillqty + "  , " + vbillvalue + ")";
			rs = this.getSPResult(SQL);
			while (rs.next()) {
				DBaction = "Fail";
				String mode = " ";
				prst = null;
				final int batchSize = 1;
				int TotalRecordinsert = 0;
				con8 = this.getConnection();
				con8.setAutoCommit(false);
				String Status = "Fail";
				String pospayment = "Insert into     tmp_pos_promoApply(company_code , "
						+ "site_code, billno , billdate,  article_code, name, qty, value,  promotypecode, promoTypename, "
						+ " promocode , purchasecondfrom , purcondto, ApplyPromo, DiscPer , DiscAmt, ApplyDiscamt, perqtydiscamt, freearticle , freeqty ) "
						+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				prst = con8.prepareStatement(pospayment);
				try {
					vpromoType = rs.getString(1).trim();

					//
					if (vvbillvalue <= vpurcondto) {
						vvdiscamt = vvbillvalue * vvdiscper / 100;
						vgivendiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));
						vvdiscperqty = vvdiscamt / vvbillqty;
						vperpiceqty = new gnMath().get2DecimaltValue(Double.toString(vvdiscperqty));
					}
					if (vvbillvalue > vpurcondto) {
						vvdiscamt = vpurcondto * vvdiscper / 100;
						vgivendiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));
						vvdiscperqty = vvdiscamt / vvbillqty;
						vperpiceqty = new gnMath().get2DecimaltValue(Double.toString(vvdiscperqty));
					}
					//
					if (vperpiceqty.length() == 0 || vperpiceqty == "") {
						vperpiceqty = "0";
					}
					prst.setString(1, vcomp);
					prst.setString(2, vstore);
					prst.setString(3, vinvno);
					prst.setString(4, vinvdate);
					prst.setString(5, vcode);
					prst.setString(6, vname);
					prst.setString(7, vbillqty);
					prst.setString(8, vbillvalue);
					prst.setString(9, rs.getString(1).trim());
					prst.setString(10, rs.getString(2).trim());
					prst.setString(11, rs.getString(4).trim());
					prst.setString(12, rs.getString(8).trim());
					prst.setString(13, rs.getString(9).trim());
					prst.setString(14, "Y");
					prst.setString(15, rs.getString(10).trim());
					prst.setString(16, rs.getString(11).trim());
					prst.setString(17, vgivendiscamt);
					prst.setString(18, vperpiceqty.trim());
					prst.setString(19, rs.getString(12).trim());
					prst.setString(20, Double.toString(vmyfreeqty));
					prst.addBatch();
					TotalRecordinsert = TotalRecordinsert + 1;

					if (++TotalRecordinsert % batchSize == 0) {
						prst.executeBatch();
						con8.commit();
						DBaction = "Sucess";
					}
					prst.executeBatch(); // insert remaining records
					con8.commit();
					DBaction = "Sucess";
				} catch (SQLException e) {
					new General().msg(
							"Promo Brand and Hierarchy  Level Apply Error 01 =>" + " " + vtype + " " + e.getMessage());
					new gnLogger().loggerDebugEntry("POS", "Promo Brand and Hierarchy  Level Apply <1>" + "vInvNo:" + ""
							+ vinvno + "" + e.getMessage());
					e.printStackTrace();
					System.exit(0);
					con8.rollback();
					DBaction = "Fail";
				} finally {
					if (prst != null) {
						prst.close();
						new gnLogger().loggerDebugEntry("POS",
								"PS Brand and Hierarchy  LEVEL PROMO" + "InvNo:" + "" + vinvno);
					}
					if (con8 != null) {
						con8.close();
					}
				}

			} // end inner while rs
				//
		} // Outer While Loop Rs1
	}// end Brand and hierarchy

	
	public void newApplyBillLevel(String vinvno, String vinvdate, String vbillvalue)
			throws ClassNotFoundException, SQLException, IOException {
		String vcode = "0";
		String vbillqty = "0";
		String vname = "0";
		double vvbillvalue = Double.parseDouble(vbillvalue);
		double vvdiscper = 0;
		double vvdiscamt = 0;
		String vmydiscamt = "";
		String vtype = "BillLevel";
		String SQL = "call Promo_CheckApplicablity( '" + vtype + "'  ,  " + compcode + " , " + vstore + "  , '"
				+ vinvdate + "'  , " + vcode + " , " + vbillqty + "  , " + vbillvalue + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			//
			DBaction = "Fail";
			String mode = " ";
			prst = null;
			final int batchSize = 1;
			int TotalRecordinsert = 0;
			con8 = this.getConnection();
			con8.setAutoCommit(false);
			String Status = "Fail";
			String pospayment = "Insert into     tmp_pos_promoApply(company_code , "
					+ "site_code, billno , billdate,  article_code, name, qty, value, promotypecode, promoTypename, "
					+ "   promocode , purchasecondfrom , purcondto, ApplyPromo, DiscPer , DiscAmt, ApplyDiscamt, perqtydiscamt, freearticle , freeqty ) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			prst = con8.prepareStatement(pospayment);
			try {
				vvdiscper = Double.parseDouble(rs.getString(10));
				vvdiscamt = vvbillvalue * vvdiscper / 100;
				vmydiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));
				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vinvno);
				prst.setString(4, vinvdate);
				prst.setString(5, vcode);
				prst.setString(6, vname);
				prst.setString(7, vbillqty);
				prst.setString(8, vbillvalue);
				prst.setString(9, rs.getString(1));
				prst.setString(10, rs.getString(2));
				prst.setString(11, rs.getString(4));
				prst.setString(12, rs.getString(8));
				prst.setString(13, rs.getString(9));
				prst.setString(14, "Y");
				prst.setString(15, rs.getString(10));
				prst.setString(16, rs.getString(11));
				prst.setString(17, vmydiscamt);
				prst.setString(18, "0");
				prst.setString(19, rs.getString(12));
				prst.setString(20, rs.getString(13));
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					con8.commit();
					DBaction = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				con8.commit();
				DBaction = "Sucess";
			} catch (SQLException e) {
				new General().msg("Bill Level Promo Error=>" + e.getMessage());
				new gnLogger().loggerDebugEntry("POS",
						"Promo Bill Level Apply" + "vInvNo:" + "" + vinvno + "" + e.getMessage());
				con8.rollback();
				DBaction = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
					new gnLogger().loggerDebugEntry("POS", "PS BILL LEVEL PROMO" + "InvNo:" + "" + vinvno);
				}
				if (con8 != null) {
					con8.close();
				}
			}
		} else {
			// new General().msg("Bill Level Promo Not Applicable for this Bill
			// ....");
		}
		//
	}// end

	public void newApplyBillLevelSpecialRatePromo(String vinvno, String vinvdate, String vbillvalue)
			throws ClassNotFoundException, SQLException, IOException {
		String vcode = "0";
		String vbillqty = "0";
		String vname = "0";
		double vvbillvalue = Double.parseDouble(vbillvalue);
		double vvdiscper = 0;
		double vvdiscamt = 0;
		String vmydiscamt = "";
		double perqtyvalue = 0.0;
		double vvmaxqty = 0.0;
		double vvbillqty = 0.0;
		String vtype = "Article-SplRate";
		String SQL = "call Promo_CheckApplicablity('" + vtype + "'  ,  " + compcode + " , " + vstore + "  , '"
				+ vinvdate + "'  , " + vcode + " , " + vbillqty + "  , " + vbillvalue + ")";
		rs = this.getSPResult(SQL);
		while (rs.next()) {
			vcode = rs.getString(5);
			vname = rs.getString(6);
			// new General().msg("Article Special rate code :"+ vcode + " name
			// "+ vname);
			DBaction = "Fail";
			String mode = " ";
			prst = null;
			final int batchSize = 1;
			int TotalRecordinsert = 0;
			con8 = this.getConnection();
			con8.setAutoCommit(false);
			String Status = "Fail";
			String pospayment = "Insert into     tmp_pos_promoApply(company_code , "
					+ "site_code, billno , billdate,  article_code, name, qty, value, promotypecode, promoTypename, "
					+ "   promocode , purchasecondfrom , purcondto, ApplyPromo, DiscPer , DiscAmt, ApplyDiscamt, perqtydiscamt, freearticle , freeqty ) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			prst = con8.prepareStatement(pospayment);
			try {

				vvbillqty = new gnPromoGetInfo().promo_getBillQtyForArticle(vinvno, vinvdate, vcode);
				vbillqty = Double.toString(vvbillqty);
				vvdiscper = Double.parseDouble(rs.getString(10));
				vvmaxqty = Double.parseDouble(rs.getString(11)); // vmaxqty
				perqtyvalue = vvbillvalue / vvbillqty;
				if (vvbillqty == vvmaxqty) {
					vvdiscamt = vvbillvalue * vvdiscper / 100;
				}

				if (vvbillqty > vvmaxqty) {
					vvdiscamt = (vvmaxqty * perqtyvalue) * vvdiscper / 100;
				}

				if (vvbillqty < vvmaxqty) {
					vvdiscamt = vvbillvalue * vvdiscper / 100;
				}
				vmydiscamt = new gnMath().get2DecimaltValue(Double.toString(vvdiscamt));

				prst.setString(1, vcomp);
				prst.setString(2, vstore);
				prst.setString(3, vinvno);
				prst.setString(4, vinvdate);
				prst.setString(5, vcode);
				prst.setString(6, vname);
				prst.setString(7, vbillqty);
				prst.setString(8, vbillvalue);
				prst.setString(9, rs.getString(1));
				prst.setString(10, rs.getString(2));
				prst.setString(11, rs.getString(4));
				prst.setString(12, rs.getString(8));
				prst.setString(13, rs.getString(9));
				prst.setString(14, "Y");
				prst.setString(15, rs.getString(10));
				prst.setString(16, rs.getString(11));
				prst.setString(17, vmydiscamt);
				prst.setString(18, "0");
				prst.setString(19, rs.getString(12));
				prst.setString(20, rs.getString(13));
				prst.addBatch();
				TotalRecordinsert = TotalRecordinsert + 1;
				if (++TotalRecordinsert % batchSize == 0) {
					prst.executeBatch();
					con8.commit();
					DBaction = "Sucess";
				}
				prst.executeBatch(); // insert remaining records
				con8.commit();
				DBaction = "Sucess";
			} catch (SQLException e) {
				new General().msg("Bill Level Promo Error=>" + e.getMessage());
				new gnLogger().loggerDebugEntry("POS",
						"Promo Bill Level Specila Article Apply" + "vInvNo:" + "" + vinvno + "" + e.getMessage());
				con8.rollback();
				DBaction = "Fail";
			} finally {
				if (prst != null) {
					prst.close();
					new gnLogger().loggerDebugEntry("POS",
							"PS BILL LEVEL Specila Article PROMO" + "InvNo:" + "" + vinvno);
				}
				if (con8 != null) {
					con8.close();
				}
			}
		}

		//

	}// end

	public void applySpecialRateOntable(String vinvno, String vinvdate) throws ClassNotFoundException, SQLException {
		// new General().msg("Now processing in Table Spcial Article Rat Process
		// ");
		String SQL = "";
		String SQL1 = "";
		String vcode = "0";
		String vfreearticle = "";
		String vspecialarticle = "";

		double vfreeqty = 0;
		double vfreerate = 0;
		double vfreediscamt = 0;

		String rowUpdated = "N";
		String tablefreearticle = "";
		double balFreeqty = 0;
		double allocateFreeqty = 0;
		double tableqty = 0;
		double tablerate = 0;
		double freeqty = 0;
		double vtmpissueqty = 0;

		double vmaxqty = 0;
		double vspecialrate = 0;
		double vconfrom = 0;
		double vcondto = 0;
		String vsrno = "";
		vspecialrate = 0;
		String vbillqty = "0";
		String vname = "0";
		double vvdiscper = 0;
		double vvdiscamt = 0;
		String vmydiscamt = "";
		String vtype = "Article-SplRate";
		String vfreedesc = "FreeArticle";
		vtype = "GetSpecialRateArticle";
		SQL = "call Promo_getInfo('" + vtype + "' , " + compcode + " , " + vstore + " , " + vinvno + " , '" + vinvdate
				+ "' )";
		rs2 = this.getSPResult(SQL);
		while (rs2.next()) {
			rowUpdated = "N";
			balFreeqty = 0;
			tableqty = 0;
			vfreearticle = "";
			tablerate = 0;
			allocateFreeqty = 0;
			vmaxqty = 0;
			vspecialrate = 0;
			vconfrom = 0;
			vcondto = 0;

			vspecialarticle = rs2.getString(1);
			vname = rs2.getString(2);
			vconfrom = Double.parseDouble(rs2.getString(3));
			vcondto = Double.parseDouble(rs2.getString(4));
			vmaxqty = Double.parseDouble(rs2.getString(6));
			vspecialrate = Double.parseDouble(rs2.getString(5));
			balFreeqty = vmaxqty;

			SQL1 = " select    Article_code , Name, qty, rate, disc  , srno"
					+ "    from  promo_applyontable  where Company_code = " + compcode + " and site_code = " + vstore
					+ "  " + "   and article_code  = " + vspecialarticle + "  and BillDate = '" + vinvdate
					+ "' and BillNo =  '" + vinvno + "'   and freeArticle_disc <> '" + vfreedesc + "'  ";
			rs1 = this.getSPResult(SQL1);
			while (rs1.next()) {
				rowUpdated = "N";
				tablefreearticle = rs1.getString(1);
				tableqty = Double.parseDouble(rs1.getString(3));
				tablerate = Double.parseDouble(rs1.getString(4));
				vsrno = rs1.getString(6);
				// new General().msg("balFree Qty & :" + balFreeqty + "Allocate
				// Qty"+" "+allocateFreeqty);
				if (tablefreearticle.equalsIgnoreCase(vspecialarticle.trim())) {
					if (tableqty == balFreeqty && balFreeqty > 0 && rowUpdated.equalsIgnoreCase("N")) {
						// new General().msg( "== applying ") ;
						vfreediscamt = tableqty * (tablerate - vspecialrate);
						allocateFreeqty = allocateFreeqty + tableqty;
						balFreeqty = balFreeqty - allocateFreeqty;
						updateSpecialArticlePricesonTable(vinvdate, vinvno, vspecialarticle, vsrno, vfreediscamt);
						rowUpdated = "Y";
					}

					if (tableqty < balFreeqty && balFreeqty > 0 && rowUpdated.equalsIgnoreCase("N")) {
						// new General().msg( " < applying ") ;
						vfreediscamt = tableqty * (tablerate - vspecialrate);
						allocateFreeqty = allocateFreeqty + tableqty;
						balFreeqty = balFreeqty - allocateFreeqty;
						updateSpecialArticlePricesonTable(vinvdate, vinvno, vspecialarticle, vsrno, vfreediscamt);
						rowUpdated = "Y";
					}

					if (tableqty > balFreeqty && balFreeqty > 0 && rowUpdated.equalsIgnoreCase("N")) {
						// new General().msg( " > applying ") ;
						vfreediscamt = balFreeqty * (tablerate - vspecialrate);
						allocateFreeqty = allocateFreeqty + balFreeqty;
						balFreeqty = balFreeqty - allocateFreeqty;
						updateSpecialArticlePricesonTable(vinvdate, vinvno, vspecialarticle, vsrno, vfreediscamt);
						rowUpdated = "Y";
					}
				} // inner loop if condition

			} // Inner Rs1 Loop

		} // Outer Rs Loop
	}

	private void updateSpecialArticlePricesonTable(String vinvdate, String vinvno, String vspecialarticle, String vsrno,
			double vvmydiscamt) {
		// new General().msg("I am in update Methos now and rate is "+
		// vmydiscamt) ;

		String vmydiscamt = Double.toString(vvmydiscamt);
		vmydiscamt = new gnMath().get2DecimaltValue(vmydiscamt);
		String vfreedesc = "Spl-Rate";
		String vtype = "UpdateBaseFreeDiscamt";
		String SQL = "update    promo_applyonTable set  disc =  " + vmydiscamt + " , freearticle_disc = '" + vfreedesc
				+ "' " + "    where  Company_code = " + compcode + " and site_code = " + vstore + "  " + " and srno = "
				+ vsrno + " and article_code = " + vspecialarticle + " and BillDate = '" + vinvdate
				+ "' and BillNo =  '" + vinvno + "'  ";
		// new General().msg(SQL);
		try {
			this.getResult(SQL);
		} catch (SQLException e) {
			e.printStackTrace();
			new General().msg(e.getLocalizedMessage());
		}
	}

	
public void newApplyMonthlyPromotion(String vcust, String vbilldate , String vpromostartdate   ) throws ClassNotFoundException, SQLException 
{
	try
	{
	   String SQL = "call Promo_Monthely_check(" + compcode + " , " + vstore + " , " + vcust+ ",   '"+vbilldate+"' , '"+vpromostartdate+"')";
	   this.getSPResult(SQL);
	}
	catch(Exception e)
	{
		new General().msg(e.getMessage());
	}
}
	

}// Last

package RetailProduct;

import java.sql.SQLException;

public class gnUpload extends getResultSet {

	String vfilename = "";
	String SQL;
	String vcomp;
	String vstore = "";
	String vfinyear;
	String vhno;
	String vcode;
	String vverticle;
	String vtype;

	public void getDefaults() throws Throwable {
		vcomp = new gnConfig().getCompanycode();
		vstore = new gnConfig().getStoreID();
		vfinyear = new gnFinYear().getReportingFinYear();
		vhno = new gnHierarchy().getHierarchyNo();
		vverticle = new gnHierarchy().getVerticleCode();
	}

	public void uploadArticleData(String vfileName) throws SQLException {
		SQL = "Delete from tmp_Article_upload";
		this.getResult(SQL);
		String vtable = "tmp_article_upload";
		vfilename = vfileName;
		vfilename = "d:/akn/uploadFile//article_Master_upload.csv";
		try {
			SQL = "LOAD DATA LOCAL INFILE   '" + vfilename + "'  INTO   table " + vtable
					+ "  FIELDS TERMINATED BY  \',\'  ";
			// SQL = "LOAD DATA LOCAL INFILE "+vfilename+" INTO Table "+vtable+"
			// FIELDS TERMINATED BY \',\' " ;
			this.getResult(SQL);
 			// generateArticlecode() ;
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void generateArticlecode() throws Throwable {
		getDefaults();
		int cnt = 0;
		int i;
		String vnumber;
		String vtype = "MS";
		String vtran = "906";
		try {
			SQL = "Select Count(*) from tmp_article_upload ";
			rs = this.getSPResult(SQL);
			if (rs.next()) {
				cnt = Integer.parseInt(rs.getString(1));
			}
			if (cnt > 0) {
				vcode = new gnSeq().getSeqno(vtran, vtype);
				vtype = "GenerateNumber";
				SQL = "Call  Article_upload(  '" + vtype + "' , " + vcomp + " , " + vstore + " , " + vverticle + " , "
						+ vhno + " , '" + vfinyear + "' , " + vcode + " )";
				this.getResult(SQL);
			}
		} catch (Exception e) {
			new General().msg(e.getMessage());
		} finally {
			new General().Quickmsg("  Article Number Generated.....");
			// new General().msg("Total Reccords Uploaded is:" + cnt);
			updateArticleLastNumber();
		}
	}

	private void updateArticleLastNumber() throws Throwable {
		getDefaults();
		int lastno = 0;
		SQL = "Select Max(Article_code) as number from tmp_article_upload ";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			lastno = Integer.parseInt(rs.getString(1));
			vtype = "UpdateNumber";
			// lastno = lastno+1 ;
			vcode = Integer.toString(lastno);
			SQL = "Call  Article_upload(  '" + vtype + "' , " + vcomp + " , " + vstore + " , " + vverticle + " , "
					+ vhno + " , '" + vfinyear + "' , " + vcode + " )";
			this.getResult(SQL);
		}
	}

	/// upload Stpock Utility start here

	public void uploadOpStockData(String vfileName) throws SQLException {
		SQL = "Delete from tmp_opStock_upload";
		this.getResult(SQL);
		String vtable = "tmp_opStock_upload";
		vfilename = vfileName;
		vfilename = "d:/akn/uploadFile//article_stock_upload.csv";
		SQL = "LOAD DATA LOCAL INFILE   '" + vfilename + "'  INTO   table " + vtable
				+ "  FIELDS TERMINATED BY  \',\'  ";
		this.getResult(SQL);
		try {
			insertStockData();
			insertBatchwiseStockData();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void uploadOpStockDatainmain() throws SQLException {
		try {
			insertStockData();
			insertBatchwiseStockData();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void insertStockData() throws Throwable {
		getDefaults();
		vtype = "NonBatchStockInsert";
		SQL = "Call  Article_upload(  '" + vtype + "' , " + vcomp + " , " + vstore + " , " + vverticle + " , " + vhno
				+ " , '" + vfinyear + "' , " + vcode + " )";
		this.getResult(SQL);
	}

	private void insertBatchwiseStockData() throws Throwable {
		getDefaults();
		vtype = "BatchStockInsert";
		String vpara811 = "811";
		String vmaintainbatchforNonBatchItem = new getConfigurationSetting().getInitialConfig(vpara811, vcomp, vstore);
		switch (vmaintainbatchforNonBatchItem) {
		case "Y":
			SQL = "Call  Article_upload(  '" + vtype + "' , " + vcomp + " , " + vstore + " , " + vverticle + " , "
					+ vhno + " , '" + vfinyear + "' , " + vcode + " )";
			this.getResult(SQL);
			break;
		}
	}

	public void insertItemDatatomainproduct() throws Throwable {
		getDefaults();
		vtype = "InsertItemMasterData";
		String vcode = "0";
		SQL = "Call  Article_upload(  '" + vtype + "' , " + vcomp + " , " + vstore + " , " + vverticle + " , " + vhno
				+ " , '" + vfinyear + "' , " + vcode + " )";
		this.getResult(SQL);
	}

}

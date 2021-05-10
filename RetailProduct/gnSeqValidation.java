package RetailProduct;

public class gnSeqValidation extends getResultSet {

	private String vcomp;
	private String vstore;
	private String varticleseq;
	private String vmaxarticlenum;
	private double vvarticleseq;
	private double vvmaxarticlenum;
	private String SQL;

	public void validate() throws Throwable {
		varticleseq = new gnSeq().getSeqno("906", "MS");
		vvarticleseq = Double.parseDouble(varticleseq);
		vvmaxarticlenum = getMaxArticleNo();
		// new General().msg( vvarticleseq + " "+ vvmaxarticlenum) ;
		if (vvmaxarticlenum > vvarticleseq) {
			new General().msg("Number Series Sequence Mismatch...Correct Number Series");
		}
	}

	public Double getMaxArticleNo() throws Throwable {
		double varticleno = 0.0;
		vcomp = new gnConfig().getCompanyCode();
		vstore = new gnConfig().getStoreID();
		String vtype = "Article";
		SQL = "Call  getMaxTranNO(" + vcomp + " , " + vstore + ", '" + vtype + "')";
		rs = this.getSPResult(SQL);

		if (!rs.next()) {
			varticleno = 0.0;
		} else {
			varticleno = Double.parseDouble(rs.getString(1));
		}
		return varticleno;
	}

}

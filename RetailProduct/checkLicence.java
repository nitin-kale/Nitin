package RetailProduct;

import com.ibm.icu.text.SimpleDateFormat;

public class checkLicence extends getResultSet {

	private String vdate;
	private String vcomp;
	private String vexpdate;
	private String SQL;
	private String vstatus = "Sucess";
	private String versionType;

	public String alert(String vcomp1) throws Throwable {
		String vallow = "Sucess";
		// vcomp = new gnConfig().getCompanyCode() ;
		vcomp = vcomp1;
		vdate = (new General().getDate());

		SQL = "Call chkproduct(" + vcomp + ")";
		rs = this.getSPResult(SQL);
		if (rs.next()) {
			vexpdate = (rs.getString(1));
			versionType = rs.getString(2);
			// new General().msg("Licence Copy Valid Till Date"+" "+vexpdate+ "
			// "+"Todys is "+" "+vdate );
			//
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy");
			java.util.Date vxexp = sdf1.parse(vexpdate);

			SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy");
			java.util.Date vvdate = sdf2.parse(vdate);
			// new General().msg("Dates Are"+vxexp + " "+vvdate);

			if (vxexp.before(vvdate)) {
				new General().msg(alertmsg);
				vallow = "Fail";
			}
		}
		return vallow;
	}

	public String alert1(String vexpdate) throws Throwable {
		// new General().msg("Exp Date is "+ vexpdate);
		String vallow = "Sucess";
		vdate = Daybegindate;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd.MM.yyyy");
		java.util.Date vxexp = sdf1.parse(vexpdate);

		SimpleDateFormat sdf2 = new SimpleDateFormat("dd.MM.yyyy");
		java.util.Date vvdate = sdf2.parse(vdate);
		if (vxexp.before(vvdate)) {
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new General().msg(alertmsg);
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			new gnImageSound().playAlertSound();
			vallow = "Fail";
		}
		return vallow;
	}

	public void Block() throws Throwable {

		System.exit(0);
	}

}

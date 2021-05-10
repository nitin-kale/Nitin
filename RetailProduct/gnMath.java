package RetailProduct;

import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class gnMath extends getResultSet {

	private String vcomp;
	private String vstore;

	public String getLandingCost(String vcost, String vtaxcode) {
		double vvtax = Double.parseDouble(vtaxcode);
		double vvcost = Double.parseDouble(vcost);

		String VLC = "";

		if (vvtax > 0) {
			vvcost = Double.parseDouble(vcost);
			vvtax = Double.parseDouble(vtaxcode);
			double vvlc = (vvcost * vvtax) / 100;
			vvcost = vvcost + vvlc;
			VLC = new gnMath().get2DecimaltValue(Double.toString(vvcost));
		}

		if (vvtax == 0) {
			VLC = vcost;
		}

		if (vvtax == 0.0) {
			VLC = vcost;
		}

		return VLC;
	}

 	
	
	public Double CalTax_Pur(Double value, Double vper) {
		double taxvalue = 0.00;
		taxvalue = (value * vper) / (100);
		String vvalue = Double.toString(taxvalue);
		vvalue = get2DecimaltValue(vvalue);
		taxvalue = Double.parseDouble(vvalue);
		return taxvalue;
	}

	public Double CalIncluTax_Pur(Double value, Double vper) {
		double taxvalue = 0.00;
		taxvalue = (value * vper) / (100 + vper);
		String vvalue = Double.toString(taxvalue);
		vvalue = get2DecimaltValue(vvalue);
		taxvalue = Double.parseDouble(vvalue);
		return taxvalue;
	}

	public Double CalTax_Pur(String value, String vper) {

		double vvalue = Double.parseDouble(value);
		double vvper = Double.parseDouble(vper);
		double taxvalue = 0.00;
		taxvalue = (vvalue * vvper) / (100);
		String vvalue1 = Double.toString(taxvalue);
		String myvvalue = get2DecimaltValue(vvalue1);
		taxvalue = Double.parseDouble(myvvalue);
		return taxvalue;
	}

	public Double CalTax_Sales(Double value, Double vper) {
		Double taxvalue = 0.00;
		// taxvalue = (double) Math. round((value*vper)/(100+vper)) ;
		taxvalue = (value * vper) / (100 + vper);
		String vvalue = Double.toString(taxvalue);
		vvalue = get2DecimaltValue(vvalue);
		taxvalue = Double.parseDouble(vvalue);
		return taxvalue;

	}

	
	
	
	private void setDefault() {
		try {
			vstore = new gnConfig().getStoreID();
			vcomp = new gnConfig().getCompanycode();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public String calculateMargin(String varticle, String vcost, String vsp) {
		Double Xmargin = 0.00;
		Double Xcost = Double.parseDouble(vcost);
		Double Xsp = Double.parseDouble(vsp);
		Xmargin = (double) Math.round((Xsp - Xcost) / 100) * 100;
		new General().msg("Margin of Item is " + Xmargin);
		String vmargin = Double.toString(Xmargin);
		return vmargin;
	}

	public String getArticleSetMargin(String varticle) throws Throwable {
		String varticlemargin = "0";
		setDefault();
		String SQL = "Call  Article_GetsetMargin(" + vcomp + ", " + varticle + ")";
		rs = this.getSPResult(SQL);
		rs.next();
		varticlemargin = rs.getString(1);
		return varticlemargin;

	}

	public String checkMargin(String varticle, String vcost, String vsp) throws Throwable {
		String check = "Sucess";
		setDefault();
		Double Xmargin = 0.00;
		Double Xcost = Double.parseDouble(vcost);
		Double Xsp = Double.parseDouble(vsp);
		Xmargin = ((Xsp - Xcost) / 100) * 100;
		String vsetMargin = getArticleSetMargin(varticle);
		Double xsetMargin = Double.parseDouble(vsetMargin);
		if (Xmargin < xsetMargin) {
			new gnImageSound().playAlertSound();
			new General().msg("Margin is not Get As per Article  Set Margin,  Set Article Margin% is  " + xsetMargin
					+ " <Actual Margin Got Is   " + Xmargin + ">");

			check = "Fail";
		}
		return check;
	}

	public String get_exclCost(String cost, String taxper) {
		String retcost = "0.00";
		double vcost = (double) Math.round(Double.parseDouble(cost));
		double vtax = (double) Math.round(Double.parseDouble(taxper));
		double result = (double) Math.round((vcost * vtax / 100));
		vcost = vcost - result;
		retcost = Double.toString(vcost);
		return retcost;
	}

	public String get_inclCost(String basecost, String taxper) {
		String retvalue = "0.00";
		double vcost = (double) Math.round(Double.parseDouble(basecost));
		double vtax = (double) Math.round(Double.parseDouble(taxper));
		double result = (double) Math.round((vcost * vtax / 100));
		vcost = vcost + result;
		retvalue = (Double.toString(vcost));
		return retvalue;
	}

	public String get_exclMrp(String mrp, String taxper) {
		String retvalue = "0.00";
		double vmrp = Double.parseDouble(mrp);
		double vtax = Double.parseDouble(taxper);
		double result = (vmrp * vtax / 100);
		vmrp = vmrp - result;
		retvalue = Double.toString(vmrp);
		return retvalue;
	}

	public String get_inclMrp(String basemrp, String taxper) {
		String retvalue = "0.00";
		double vmrp = Double.parseDouble(basemrp);
		double vtax = Double.parseDouble(taxper);
		double result = (vmrp * vtax / 100);
		vmrp = vmrp + result;
		retvalue = Double.toString(vmrp);
		return retvalue;
	}

	public String get_markdownSP(String mrp, String markdownper) {
		String retvalue = "0.00";
		Double vmrp = Double.parseDouble(mrp);
		Double vmarkdownper = Double.parseDouble(markdownper);
		Double vsp = (vmrp - (vmrp * vmarkdownper / 100));
		retvalue = Double.toString(vsp);
		return retvalue;
	}

	public String get_markupSP(String cost, String markupper) {
		String retvalue = "0.00";
		Double vcost = Double.parseDouble(cost);
		Double vmarkupper = Double.parseDouble(markupper);
		Double vsp = (vcost + (vcost * vmarkupper / 100));
		retvalue = Double.toString(vsp);
		return retvalue;
	}

	public String Strget2DecimaltValue(String value) {
		String returnValue = "00.00";
		double converttodecimal = Double.parseDouble(value);
		DecimalFormat mydf = new DecimalFormat("000.##");
		mydf.setRoundingMode(RoundingMode.FLOOR);
		returnValue = mydf.format(converttodecimal);
		System.out.println(returnValue);
		return returnValue;
	}

	public double getmy2DecimaltValue(String value) {
		String returnValue = "00.00";
		Double myvalue = 0.00;
		Double converttodecimal = Double.parseDouble(value);
		DecimalFormat mydf = new DecimalFormat("##.00");
		mydf.setRoundingMode(RoundingMode.CEILING);
		returnValue = mydf.format(converttodecimal);
		myvalue = Double.parseDouble(returnValue);
		System.out.println("Value is :" + " " + myvalue);
		return myvalue;
	}

	
	 

	public double getRound2DecimaltValue(String value) {
		String returnValue = "0.00";
		double myvalue = 0.00;
		double converttodecimal = Math.round(Double.parseDouble(value));
		DecimalFormat mydf = new DecimalFormat(" 00.##");
		// mydf.setRoundingMode(RoundingMode.DOWN);
		String vmyvalue = Double.toString(converttodecimal);
		returnValue = mydf.format(vmyvalue);
		myvalue = Double.parseDouble(returnValue);
		System.out.println(myvalue);
		return myvalue;
	}

	public String getRound22DecimaltValue(String value) {
		String returnValue = "0.00";
		double myvalue = 0.00;
		double converttodecimal = Math.round(Double.parseDouble(value));
		DecimalFormat mydf = new DecimalFormat(" 0.##");
		mydf.setRoundingMode(RoundingMode.UP);
 		returnValue = mydf.format(converttodecimal);
   		returnValue = String.format("%.2f", myvalue);
 		System.out.println(returnValue);
		return returnValue;
	}

	public double getRound2DecimaltValue(double value) {

		String returnValue = "0.00";
		double myvalue = 0.00;
		double converttodecimal = Math.round(value);
		DecimalFormat mydf = new DecimalFormat(" 0.##");
		mydf.setRoundingMode(RoundingMode.UP);
		returnValue = mydf.format(converttodecimal);
		myvalue = Double.parseDouble(returnValue);
  		returnValue = String.format("%.2f", myvalue);
 		return myvalue;
	}

	public Double  get2DecimaltValue(double value) {
		Double  retValue = 0.00;
		double retvalue1 = 0.00 ;
		String returnValue = "00.00";
		double converttodecimal = value;
		DecimalFormat mydf = new DecimalFormat("00.##");
		returnValue = mydf.format(Double.toString(converttodecimal));
  		retValue = Double.parseDouble(returnValue);
		System.out.println(retValue);
		//System.out.println(returnValue);
 		return retValue;
	}

 
	
	public String get2DecimaltValue(String value) {
		// new General().msg(value) ;

		String returnValue = ".00";
		double myvalue = 0.00;
		double converttodecimal = Double.parseDouble(value);
  		DecimalFormat mydf = new DecimalFormat("00.##");
		//mydf.setRoundingMode(RoundingMode.CEILING);
  		returnValue = mydf.format(converttodecimal);
		myvalue = Double.parseDouble(value);
   		returnValue = String.format("%.2f", myvalue);
  		System.out.println(returnValue);
    	//System.out.println(String.format("%.2f", myvalue)); 
  		return returnValue;
	}
 	
	
	
	public static void main(String[] args) {
 	
		gnMath kk = new gnMath();
		kk.get2DecimaltValue("2.512213213");
  	}

}

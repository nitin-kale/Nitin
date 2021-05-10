package RetailProduct;

public class test112 {

	
	
private void test112()
{
     String vdate = "14.10.2020" ;
 	 int vmon = Integer.parseInt(vdate.substring(3, 5));
 	 System.out.println("Mon" + vmon);
	 
 	 if (vmon  > 4)
 	 {
 	 int vyear = Integer.parseInt(vdate.substring(7, 10));
     String fix = "20" ;
		String vvyear = Integer.toString(vyear);
		int vyear1 = vyear + 1;
		System.out.println(vyear1);
		String  vpart1 = vvyear; // vvyear.substring(3,4);
		String vpart2 = Integer.toString(vyear1);
		String vfinyear = vpart1 + "-" + vpart2;
		String vstartdate = "01.04." + fix + vvyear;
		String venddate = "31.03." + fix + vyear1;
		String vxfinyear = vpart1 + "-" + vpart2;
	    new General().msg("Financial Year :"+ " "+vxfinyear);
		System.out.println(vstartdate);
		System.out.println(venddate);
		System.out.println(vxfinyear);
 }
 	 
}
public static void main(String[]  args)
{
	
	test112 k = new test112();
	k.test112();
}

}

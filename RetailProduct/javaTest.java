package RetailProduct;

public class javaTest {

	String name;

	public static String javaTest(String name) {

		String result = "Pass";

		if (name.length() <= 0) {
			new General().msg("Fail");
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javaTest bb = new javaTest();
		bb.javaTest("Nitin");
	}

}

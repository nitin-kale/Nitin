package RetailProduct;

public class gnMemoryTest {

	public void check() {
		Runtime r = Runtime.getRuntime();

		new General().msg("Total Memory: " + r.totalMemory());
		new General().msg("Total Available Processors " + " " + r.availableProcessors());

		for (int i = 0; i < 10000; i++) {

			r.freeMemory();
		}
		System.gc();
		System.runFinalization();

	}

	public static void main(String args[]) throws Exception {

		new gnMemoryTest().check();

	}
}

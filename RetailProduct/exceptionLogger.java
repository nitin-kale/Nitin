package RetailProduct;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class exceptionLogger {

	public void writeToFile(String Text) throws IOException {
		StringBuffer sbf = new StringBuffer();
		sbf.append(Text);
		sbf.append(System.getProperty("line.separator"));

		FileWriter fl = new FileWriter("d:/demo.txt");
		BufferedWriter bwr = new BufferedWriter(fl);
		bwr.write(sbf.toString());
		bwr.flush();
		bwr.close();
		System.out.println("Content of StringBuffer written to File.");
	}

	public static void main(String[] args) throws IOException {
		exceptionLogger ex = new exceptionLogger();
		ex.writeToFile("My Name Is Nitin");
	}
}

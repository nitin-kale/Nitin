package RetailProduct;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class gnUpdaeConfigFile extends getResultSet {

	JTextArea myfile = new JTextArea();

	static void modifyFile(String filePath, String oldString, String newString) {
		File fileToBeModified = new File(filePath);
		String oldContent = "";
		BufferedReader reader = null;
		FileWriter writer = null;
		try {
			reader = new BufferedReader(new FileReader(fileToBeModified));
			// Reading all the lines of input text file into oldContent
			String line = reader.readLine();
			while (line != null) {
				oldContent = oldContent + line + System.lineSeparator();
				line = reader.readLine();
			}
			new General().msg(oldContent);

			// Replacing oldString with newString in the oldContent
			String newContent = oldContent.replaceAll(oldString, newString);
			// Rewriting the input text file with newContent
			writer = new FileWriter(fileToBeModified);
			writer.write(newContent);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// Closing the resources
				reader.close();
				writer.close();
				new General().msg("File Updated Sucessfully");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void showConfigFile() throws IOException {
		String filePath = ApplicationDrivename + "AKN//bin//myConfigRun.ini";
		BufferedReader file = new BufferedReader(new FileReader(filePath));
		StringBuffer inputBuffer = new StringBuffer();
		String line;
		while ((line = file.readLine()) != null) {
			inputBuffer.append(line);
			inputBuffer.append('\n');
		}
		file.close();
		String inputStr = inputBuffer.toString();
		System.out.println(inputStr); // display the original file for debugging
		myfile.append(inputStr);
		myfile.setBounds(150, 150, 300, 800);
		new General().msgTextPane(myfile.getText(), "Config  File");

	}

}

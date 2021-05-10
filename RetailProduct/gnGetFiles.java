package RetailProduct;

import java.io.File;
import java.io.IOException;

public class gnGetFiles {

	public void listFilesHavingTheWord(String directoryName, String word) throws IOException {
		File directory = new File(directoryName);
		// get all the files from a directory
		File[] fList = directory.listFiles(); // code line A
												// code line B
		for (File file : fList) { // code line C
			if (file.isFile()) {
				String filepath = file.getAbsolutePath();
				// if(isWordPresent(word,filepath)){
				int index = file.getName().lastIndexOf(".");
				if (index > 0) {
					String fileNameWithoutExt = file.getName().substring(0, index);
					System.out.println("word \"" + word + "\" present in file--> " + "Path\"" + filepath + "  "
							+ fileNameWithoutExt);
				}
				// }
			} else if (file.isDirectory()) {
				listFilesHavingTheWord(file.getAbsolutePath(), word);
			}
		}
	}

	public static void main(String args[]) {
		gnGetFiles f = new gnGetFiles();
		try {
			f.listFilesHavingTheWord("d://Java//RetailProduct/RetailProduct", "class");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}// last

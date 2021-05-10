package RetailProduct;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class gnMyZipFiles {
	private String password = "";
	private static final String EXTENSION = "zip";
	String Dest = new gnPublicVariable().DbBackupPath();

	public gnMyZipFiles(String password) {
		this.password = password;
	}

	public void pack(File filename) throws ZipException {

		//new General().msg(Dest);
		try{
			ZipParameters zipParameters = new ZipParameters();
			zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
			zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
			zipParameters.setEncryptFiles(true);
			zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
			String baseFileName = FilenameUtils.getBaseName(filename.toString());
			String destinationZipFilePath = Dest + baseFileName + "." + EXTENSION;
			ZipFile zipFile = new ZipFile(destinationZipFilePath);

			zipParameters.setPassword(password);
			// zipFile.setPassword(password);

			zipFile.addFile(new File(filename.toString()), zipParameters);
			zipFile.setPassword(password);
 		}catch(Exception e)
		{
		    new General().msg(e.getLocalizedMessage());	
		}
 	}

	public void unpack(String sourceZipFilePath, String extractedZipFilePath) throws ZipException {
		ZipFile zipFile = new ZipFile(sourceZipFilePath + "." + EXTENSION);

		if (zipFile.isEncrypted()) {
			zipFile.setPassword(password);
		}

		zipFile.extractAll(extractedZipFilePath);
	}
}

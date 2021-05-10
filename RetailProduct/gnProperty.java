package RetailProduct;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class gnProperty extends getResultSet {

	private void loadPropertyData(String iniFile) throws IOException {
		Properties prop = new Properties();
		String propFileName = iniFile;
		InputStream inputStream;
		inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
		}

		dbname = prop.getProperty("Database");
		driver = prop.getProperty("Driver");
		url = prop.getProperty("url");
		myterminal = prop.getProperty("Terminal");

		getResultSet setparam = new getResultSet();
		// setparam.login = dbuser ;
		setparam.baseurl = url;
		setparam.driver = driver;
		setparam.password = myString;
		setparam.dbname = dbname;

	}

}

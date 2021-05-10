package RetailProduct;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class gnPrnFileManager {

	

	
public void printUsingPrnfile(String template)
{
	
 	 Pattern p = Pattern.compile("\\{.*?\\}");
	    Matcher m = p.matcher(template);
	    StringBuffer result = new StringBuffer();
	    while(m.find()) {
	        String key = template.substring(m.start() + 1, m.end() - 1);
	        String replacement = lookupVariable(key);           
	        m.appendReplacement(result, Matcher.quoteReplacement(replacement));
	    }
	    m.appendTail(result);
}


private String lookupVariable(String key )
{
	String value = "" ;
	
	return value ;
	
}


}

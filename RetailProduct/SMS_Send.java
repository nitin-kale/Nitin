package RetailProduct;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SMS_Send {

	String recipient = "+9198";
	String message = " Hi Nitin Here, Testing  SMS by Java code please call once receive this message!";
	String username = "admin";
	String password = "aayushi7";
	String originator = "+9172";

	public void mySMS_Send() {
		try {
			String requestUrl = "http://127.0.0.1:9501/api?action=sendmessage&" + "username="
					+ URLEncoder.encode(username, "UTF-8") + "&password=" + URLEncoder.encode(password, "UTF-8")
					+ "&recipient=" + URLEncoder.encode(recipient, "UTF-8") + "&messagetype=SMS:TEXT" + "&messagedata="
					+ URLEncoder.encode(message, "UTF-8") + "&originator=" + URLEncoder.encode(originator, "UTF-8")
					+ "&serviceprovider=GSMModem1" + "&responseformat=html";
			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection) url.openConnection();
			System.out.println(uc.getResponseMessage());
			uc.disconnect();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {

		SMS_Send a = new SMS_Send();
		a.mySMS_Send();

	}

}

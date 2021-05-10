package RetailProduct;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class gnGetNetworkinfo {

	public static void main(String[] args) {
		System.out.println("Host Name : " + getSystemName());
		System.out.println("Host IP   : " + getIPAddress());
		System.out.println("Host Address : " + getMACID());
	}

	private static String getSystemName() {
		try {
			InetAddress inetaddress = InetAddress.getLocalHost(); // Get
																	// LocalHost
																	// refrence
			String name = inetaddress.getHostName(); // Get Host Name
			return name; // return Host Name
		} catch (Exception E) {
			E.printStackTrace(); // print Exception StackTrace
			return null;
		}
	}

	private static String getIPAddress() {
		try {
			InetAddress inetaddress = InetAddress.getLocalHost();
			String ip = inetaddress.getHostAddress();
			return ip;
		} catch (Exception E) {
			E.printStackTrace(); // print Exception StackTrace
			return null;
		}

	}

	private static String getMACID() {
		try {
			InetAddress inetaddress = InetAddress.getLocalHost(); // Get
																	// LocalHost
																	// refrence
			NetworkInterface network = NetworkInterface.getByInetAddress(inetaddress);
			byte[] macArray = network.getHardwareAddress(); // get Harware
															// address Array
			StringBuilder str = new StringBuilder();

			// Convert Array to String
			for (int i = 0; i < macArray.length; i++) {
				str.append(String.format("%02X%s", macArray[i], (i < macArray.length - 1) ? "-" : ""));
			}
			String macAddress = str.toString();

			return macAddress;
		} catch (Exception E) {
			E.printStackTrace();
			return null;
		}
	}

}

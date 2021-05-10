package RetailProduct;

import java.net.InetAddress;
import java.net.Socket;

public class PortScanner {

	public static void main(String args[]) {
		int startPortRange = 0;
		int stopPortRange = 12;
		// startPortRange = Integer.parseInt(args[0]);
		// stopPortRange = Integer.parseInt(args[2]);
		for (int i = startPortRange; i < stopPortRange; i++) {
			try {
				InetAddress localaddr = InetAddress.getLocalHost();
				System.out.println("Local IP Address : " + localaddr);
				System.out.println("Local hostname   : " + localaddr.getHostName());

				Socket ServerSok = new Socket(localaddr.getHostName(), i);
				System.out.println("Port in use: " + i);

				ServerSok.close();
			} catch (Exception e) {
			}
			System.out.println("Port not in use: " + i);
		}
	}
}

package RetailProduct;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class checkInernet {
	public boolean isInternetAvailable() throws IOException {
		// new General().Quickmsg("Checking Intenet connection...");
		return isHostAvailable("google.com");
	}

	public static boolean isHostAvailable(String hostName) throws IOException {
		try (Socket socket = new Socket()) {
			int port = 80;
			InetSocketAddress socketAddress = new InetSocketAddress(hostName, port);
			socket.connect(socketAddress, 3000);
			return true;
		} catch (UnknownHostException unknownHost) {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		checkInernet chk = new checkInernet();
		boolean status = chk.isHostAvailable("google.com");
		if (status) {
			new General().msg("Connection Available");
		} else {
			new General().msg("Internet Connection Not Available");
		}
	}

}// last

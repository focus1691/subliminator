package controller;

import java.io.IOException;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class NetworkController {

	private static final int PORT = 9999;
	private static ServerSocket socket;

	public static boolean isApplicationRunning() {
		try {
			// Bind to localhost adapter with a zero connection queue
			socket = new ServerSocket(PORT, 0, InetAddress.getByAddress(new byte[] { 127, 0, 0, 1 }));
		} catch (BindException e) {
			return true;
		} catch (IOException e) {
			return true;
		}
		return false;
	}
}

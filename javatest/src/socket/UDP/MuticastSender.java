package socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class MuticastSender {

	public static void main(String[] args) throws UnknownHostException, InterruptedException {
		// TODO Auto-generated method stub
		InetAddress group = InetAddress.getByName("224.0.0.1");
		int port = 4000;
		MulticastSocket ms = null;

		try {
			ms = new MulticastSocket(port);
//			ms.joinGroup(group);
			while (true) {
				String message = "Hello " + new java.util.Date();
				byte[] buffer = message.getBytes();
				DatagramPacket dp = new DatagramPacket(buffer, 0, buffer.length, group, port);
				ms.send(dp);
				System.out.println("发送数据报给 " + group + ":" + port);
				Thread.sleep(10);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ms != null) {
				try {
					ms.leaveGroup(group);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ms.close();
			}
		}

	}

}

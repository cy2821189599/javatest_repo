package socket.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class EchoClient {
	private int port = 8000;
	private String host = "localhost";
	private DatagramSocket socket;
	
	public EchoClient() throws SocketException {
		// TODO Auto-generated constructor stub
		socket = new DatagramSocket();
	}
	
	public void talk() {
		try {
			InetAddress remoteIP = InetAddress.getByName(host);
			BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
			String msg = null;
			while((msg = localReader.readLine())!= null) {
				byte[] outputData = msg.getBytes();
				DatagramPacket outputPacket = new DatagramPacket(outputData, 
						outputData.length, remoteIP, port);
				socket.send(outputPacket);	//给EchoServer发送数据报
				DatagramPacket inputPacket = new DatagramPacket(new byte[512], 512);
				socket.receive(inputPacket);	//接收来自EchoServer的数据报
				System.out.println(new String(inputPacket.getData() ,0 , inputPacket.getLength()));
				if(msg.equals("bye")) {
					break;
				}
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			socket.close();
		}
		
	}

	public static void main(String[] args) throws SocketException {
		// TODO Auto-generated method stub
		new EchoClient().talk();
	}

}

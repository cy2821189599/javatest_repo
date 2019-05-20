package socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class EchoServer {
	private int port = 8000;
	private DatagramSocket socket;
	
	public EchoServer() throws SocketException {
		// TODO Auto-generated constructor stub
		socket = new DatagramSocket(port);
		System.out.println("服务器启动");
	}
	
	public String echo(String msg) {
		return "echo:"+msg;
	}
	
	public void service() {
		while(true) {
			DatagramPacket packet = new DatagramPacket(new byte[512], 512);
			try {
				socket.receive(packet);		//接收来自EchoClient的数据报
				String msg = new String(packet.getData(), 0 ,packet.getLength());
				System.out.println(packet.getAddress()+":"+packet.getPort()+">"+msg);
				packet.setData(echo(msg).getBytes());
				socket.send(packet); 	//给EchoClient 写回一个数据报
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public static void main(String[] args) throws SocketException {
		
		// TODO Auto-generated method stub
		new EchoServer().service();
	}

}

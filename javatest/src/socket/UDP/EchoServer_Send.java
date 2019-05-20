package socket.UDP;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class EchoServer_Send {
	private int port = 8000;
	private DatagramChannel channel = null;
	private int MAX_SIZE = 1024;
	
	

	public EchoServer_Send() throws IOException {
		// TODO Auto-generated constructor stub
		channel = DatagramChannel.open();
		DatagramSocket socket = channel.socket();
		SocketAddress localAddr = new InetSocketAddress(8000);
		socket.bind(localAddr);
		System.out.println("服务器启动...");
	}

	public String echo(String msg) {
		return "echo:"+msg;
	}
	
	public void service() throws IOException {
		ByteBuffer receiveBuffer = ByteBuffer.allocate(MAX_SIZE);
		while(true) {
			receiveBuffer.clear();
			InetSocketAddress client = 
					(InetSocketAddress) channel.receive(receiveBuffer);
			receiveBuffer.flip();
			String msg = Charset.forName("GBK").decode(receiveBuffer).toString();
			System.out.println(client.getAddress()+"::"+client.getPort()
			+">"+msg);
			//给客户端回复一个数据报
			channel.send(ByteBuffer.wrap(echo(msg).getBytes()), client);
			
//			channel.connect(client);
//			channel.write(receiveBuffer);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new EchoServer_Send().service();
	}

}

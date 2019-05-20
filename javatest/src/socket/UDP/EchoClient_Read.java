package socket.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class EchoClient_Read {
	private DatagramChannel datagramChannel = null;
	private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
	private ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);
	private Charset charSet = Charset.forName("GBK");
	private Selector selector;
	
	public EchoClient_Read() throws IOException {
		this(7000);
	}

	public EchoClient_Read(int port) throws IOException {
		datagramChannel = DatagramChannel.open();
		//InetAddress ia = InetAddress.getLocalHost();
		InetSocketAddress isa = new InetSocketAddress(port);
		datagramChannel.configureBlocking(false);	//设置为非阻塞模式
		datagramChannel.bind(isa);
		isa = new InetSocketAddress(8000);
		datagramChannel.connect(isa);	//与远程地址连接
		selector = Selector.open();
		System.out.println("正在连接服务器...");
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int  port = 7000;
		if(args.length > 0) {
			port = Integer.parseInt(args[0]);
		}
		final EchoClient_Read client = new EchoClient_Read(port);
		Thread receiver = new Thread() {
			public void run() {
				try {
					client.ReceiveFromUser();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		receiver.start();
		client.talk();
	}

	public void ReceiveFromUser() throws IOException {
		BufferedReader localReader = 
				new BufferedReader(new InputStreamReader(System.in));
		String msg = null;
		while((msg = localReader.readLine())!= null) {
			synchronized(sendBuffer){
				sendBuffer.put(encode(msg+"\r\n"));
			}
			if(msg.equals("bye"))
			break;
		}
	}
	
	public void talk() throws IOException {
		datagramChannel.register(selector, SelectionKey.OP_READ|
				SelectionKey.OP_WRITE);
		while(selector.select() > 0) {
			Set readyKeys = selector.selectedKeys();
			Iterator it =  readyKeys.iterator();
			while(it.hasNext()) {
				SelectionKey key = null;
				try {
				key = (SelectionKey) it.next();
				it.remove();
				if(key.isReadable()) {
					receive(key);
				}
				if(key.isWritable()) {
					send(key);
				}
				}catch(IOException e) {
					e.printStackTrace();
					try {
					if(key!= null) {
						key.cancel();
						key.channel().close();
					}
					}catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
	}
	
	public void send(SelectionKey key) throws IOException {
		DatagramChannel datagramChannel = (DatagramChannel) key.channel();
		synchronized(sendBuffer) {
			sendBuffer.flip();	//把极限设置为位置
			datagramChannel.write(sendBuffer);
			sendBuffer.compact();
		}
	}
	
	 public void receive(SelectionKey key) throws IOException {
		 DatagramChannel datagramChannel = (DatagramChannel) key.channel();
		 datagramChannel.read(receiveBuffer);
		 receiveBuffer.flip();
		 String receiveData = decode(receiveBuffer);
		 
		 if(receiveData.indexOf("\n")==-1)return;
		 
		 String  outputData = receiveData.substring(0, receiveData.indexOf("\n")+1);
		 System.out.println(outputData);
		 if(outputData.equals("echo:bye\r\n")) {
			 key.cancel();
			 datagramChannel.close();
			 System.out.println("关闭与服务器的连接");
			 selector.close();
			 System.exit(0);
		 }
		 
		 ByteBuffer temp = encode(outputData);
		 receiveBuffer.position(temp.limit());
		 receiveBuffer.compact();
	 }
	 
	 public String decode(ByteBuffer buffer) {
		 CharBuffer charBuffer = charSet.decode(buffer);
		 return charBuffer.toString();
	 }
	 
	 public ByteBuffer encode(String str) {
		 return charSet.encode(str);
	 }
}

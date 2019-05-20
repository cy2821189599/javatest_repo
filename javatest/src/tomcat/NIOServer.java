package tomcat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;


/**
 * NIO的tomcat服务器
 * @param args
 */
 
public class NIOServer {
	
	private Selector selector;
	
	//初始化方法 --选择器，绑定IP地址和端口
	public void init() throws IOException {
		this.selector = Selector.open(); //创建一个连接器
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		//绑定端口
		serverSocketChannel.bind(new InetSocketAddress(8080));//绑定监听端口
		serverSocketChannel.configureBlocking(false);//设置阻塞方式，支持阻塞式通信与非阻塞式通信
		System.out.println("NIO服务器已经启动,端口是8080");
		@SuppressWarnings("unused")
		ServerSocket serverSocket = serverSocketChannel.socket();
		//需要接收请求,把这个接收事件注册 到服务器的通道上
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
	}
	
	
	//运行方法
	public void start() throws IOException {
		while(true) {	//服务一直启动
			//如果有事件请求过来
			selector.select();	//如果有事件过来，请求可能有多个	//阻塞的方法
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while(iterator.hasNext()) {	//有事件过来
				SelectionKey selectionKey = iterator.next();
				iterator.remove();	//删除刚拿到的事件，不然死循环
				if(selectionKey.isAcceptable()) {	//有请求事件的话
					accept(selectionKey);
				}else if(selectionKey.isReadable()) {	//如果是读事件的话，进行读处理
					read(selectionKey);
				}
			}
		}
	}
	
	//连接方法
	public void accept(SelectionKey key) throws IOException {
		ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
		SocketChannel channel = serverSocketChannel.accept(); //如果有事件过来
		channel.configureBlocking(false); //设置为非阻塞
		channel.register(selector, SelectionKey.OP_READ); //请求过来，同时注册一个读事件
	}
	
	//读方法
	public void read(SelectionKey key) throws IOException{
		SocketChannel socketChannel = (SocketChannel) key.channel();
		//缓冲区byte
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024); //分配初始大小
		socketChannel.read(byteBuffer); //读操作，把请求的信息读到缓冲区
		String request = new String(byteBuffer.array()).trim(); // 把byte转成String
		System.out.println("客户端的请求："+request);
		//返回一个html页面(写操作)
		Date date = new Date();
		String dateStr = date.toGMTString();
		String outstring = "HTTP/1.1 200 OK\n Content-Tyep:text/html;charset:UTF-8\n\n"
				+ "<html><head><title>AV</title></head><body><h1>"+dateStr+"<br>Warnning!!!This site is related to salacious and has been monitored by the police.</h1></body></html>";
		ByteBuffer outbuffer = ByteBuffer.wrap(outstring.getBytes()); //构造html页面的返回
		socketChannel.write(outbuffer);  //写数据到客户端
		socketChannel.close(); //关闭流
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		NIOServer server = new NIOServer();
		server.init(); //初始化
		server.start(); //开启
		
	}

}

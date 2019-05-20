package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerPool {
	private int port = 8000;
	private ServerSocket serverSocket;
	private ThreadPool threadPool;
	private final int POOL__SIZE = 4;
	
	public EchoServerPool() throws IOException {
		// TODO Auto-generated constructor stub
		serverSocket = new ServerSocket(port);
		//创建线程池，
		//Runtime 的avariableProcessors()方法返回当前系统的cpu数目
		//系统cpu数目越多，线程池中的工作线程数目越多
		threadPool = new ThreadPool(Runtime.getRuntime().availableProcessors()*POOL__SIZE);
		System.out.println("服务器启动........");
		System.out.println("启动线程数目 "+threadPool.activeCount());
	}
	
	public void service() {
		while(true) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				threadPool.execute(new Handler(socket));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new EchoServerPool().service();
	}

}

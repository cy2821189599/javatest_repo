package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServerExeP {
	private  int port = 8000;
	private ServerSocket serverSocket;
	private ExecutorService executorService;
	private int POOL_SIZE = 5;
	
	public EchoServerExeP() throws IOException {
		// TODO Auto-generated constructor stub
		serverSocket  = new ServerSocket(port);
		//创建线程池
		//Runtime 的avariableProcessors()返回当前系统的CPU的数目
		//系统的CPU越多，线程池中工作的线程数目你也越多
		executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors()*POOL_SIZE);
		
		System.out.println("服务器启动中.......");
		System.out.println("正在等待连接......");
	}
	
	public void service() {
		while(true) {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				executorService.execute(new Handler(socket));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new EchoServerExeP().service();
	}

}

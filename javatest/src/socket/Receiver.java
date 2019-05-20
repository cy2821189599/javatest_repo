package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
	private int port = 8000;
	private ServerSocket serverSocket;
	private static int stopWay = 1; // 结束通信的方式
	private final int NATURAL_STOP = 1; // 自然结束
	private final int SUDDEN_STOP = 2; // 突然终止程序
	private final int SOCKET_STOP = 3; // 关闭Socket，再关闭程序
	private final int INPUT_STOP = 4; // 关闭输入流，再关闭程序
	private final int SERVERSOCKET_STOP = 5; // 关闭serverSocket,再结束程序

	public Receiver() throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("服务器启动...");
	}

	public BufferedReader getReader(Socket socket) throws IOException {
		InputStream sockIn = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(sockIn));
	}

	public void service() throws IOException, InterruptedException {
		Socket socket = null;
		socket = serverSocket.accept();
		BufferedReader br = getReader(socket);

		for (int i = 0; i < 20; i++) {
			String msg = br.readLine();
			System.out.println("receive:" + msg);
			Thread.sleep(1000);
			if (i == 2) {
				if (stopWay == SUDDEN_STOP) {
					System.out.println("突然终止程序");
					System.exit(0);
				} else if (stopWay == SOCKET_STOP) {
					System.out.println("关闭Socket并终止程序");
					socket.close();
					break;
				} else if (stopWay == INPUT_STOP) {
					System.out.println("关闭输入流并终止程序");
					socket.shutdownInput();
					break;
				} else if (stopWay == SERVERSOCKET_STOP) {
					System.out.println("关闭serversocket，并终止程序");
					serverSocket.close();
					break;
				}
			}
		}
		
		if(stopWay == NATURAL_STOP) {
			socket.close();
			serverSocket.close();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		if(args.length > 0) stopWay = Integer.parseInt(args[0]);
		new Receiver().service();
	}

}

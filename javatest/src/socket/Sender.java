package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Sender {
	private int port = 8000;
	private String host = "localhost";
	private Socket socket;
	private static int stopWay = 1;
	private final int NATURAL_STOP = 1;
	private final int SUDDEN_STOP = 2;
	private final int SOCKET_STOP = 3;
	private final int OUTPUT_STOP = 4;
	
	public Sender() throws UnknownHostException, IOException {
		socket = new Socket(host, port);
	}
	
	public PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream socketOut = socket.getOutputStream();
		return new PrintWriter(socketOut, true);
	}
	
	public void send() throws IOException, InterruptedException {
		PrintWriter pw = getWriter(socket);
		for(int i=0; i<20; i++) {
			String msg = "hello_"+i;
			pw.println(msg);
			System.out.println("send:"+msg);
			Thread.sleep(500);
			if(i == 2) {
				if(stopWay == SUDDEN_STOP) {
					System.out.println("突然终止程序");
					System.exit(0);
				}else if(stopWay == SOCKET_STOP) {
					System.out.println("关闭socket,并终止程序");
					socket.close();
					break;
				}else if(stopWay == OUTPUT_STOP) {
					socket.shutdownOutput();
					System.out.println("关闭输出流并终止程序");
					break;
				}
			}
		}
		if(stopWay == NATURAL_STOP) {
			socket.close();
		}
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		if(args.length > 0) stopWay = Integer.parseInt(args[0]);
		new Sender().send();
	}

}

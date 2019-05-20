package socket;

import java.io.*;
import java.net.*;

public  class Server{
	private int port = 8000;
	private ServerSocket serverSocket;
	
	public Server() throws IOException{
		serverSocket = new ServerSocket(port, 3);
		System.out.println("服务器启动");
	}
	public void service(){
		while(true){
			Socket socket = null;
			try{
				socket = serverSocket.accept();
				System.out.println("new connection accepted"+socket.getInetAddress()+":"+socket.getPort());
			}catch(IOException e){
				e.printStackTrace();
			}finally{
				try{
				if(socket!=null)
				socket.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
	public  static void main(String[] args) throws InterruptedException, IOException{
		Server server = new Server();
		//Thread.sleep(60000*10);
		server.service();
	}
}
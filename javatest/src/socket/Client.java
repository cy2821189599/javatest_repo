package socket;

import java.io.*;
import java.net.*;

public class Client{
	public static void main(String[] args) throws InterruptedException, IOException {
	final int length =  10000;
	String host = "localhost";
	int port = 8000;
	
	Socket[] sockets = new Socket[length];
	
	for(int i=0; i<length; i++){
		sockets[i] = new Socket(host, port);
		System.out.println("第"+(i+1)+"次连接成功");
	}
	Thread.sleep(3000);
	for(int j=0; j<length; j++){
		sockets[j].close();
	}
	}
}
package socket;

import java.io.*;
import java.net.*;

import serialized.Person;

public class Client{
	public static void main(String[] args) throws InterruptedException, IOException {
	final int length =  100;
	String host = "localhost";
	int port = 8000;
	
	Socket[] sockets = new Socket[length];
	
	for(int i=0; i<length; i++){
		sockets[i] = new Socket(host, port);
		OutputStream out = sockets[i].getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		Person person = new Person();
		oos.writeObject(person);
		System.out.println("第"+(i+1)+"次连接成功-->发送一个person对象");
	}
	Thread.sleep(3000);
	for(int j=0; j<length; j++){
		sockets[j].close();
	}
	}
}
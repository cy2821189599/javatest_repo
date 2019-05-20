package socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class HttpClient {
	String host = "183.216.176.251";
	int port  = 80;
	Socket socket;
	
	public void createSocket() throws UnknownHostException, IOException {
		socket = new Socket(host, port);
	}
	
	public  void communicate() throws IOException {
		StringBuffer sb = new StringBuffer("GET"+"http://mini.eastday.com/a/190422085754345.html"+"HTTP/1.1\r\n");
		sb.append("Host:183.216.176.251\r\n");
		sb.append("Accept:*/*\r\n");
		sb.append("Accept-Language:zh-cn\r\n");
		sb.append("Accept-Encoding:gzip,deflate\r\n");
		sb.append("User-Agent:Mozilla/4.0(compatible;MSIE 6.0; Windows NT 10.0)\r\n");
		sb.append("Connection:Keep-Alive\r\n\r\n");
		
		//发出Http请求
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(sb.toString().getBytes());
		socket.shutdownOutput();
		
		//接收响应
		InputStream inputStream = socket.getInputStream();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		byte[] buff = new byte[1024];
		int len = -1;
		while((len = inputStream.read(buff)) != -1) {
			buffer.write(buff, 0, len);
		}
		
		System.out.println(new String(buffer.toByteArray()));
		socket.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HttpClient client = new HttpClient();
		client.createSocket();
		client.communicate();
	}

}

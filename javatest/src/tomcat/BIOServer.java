package tomcat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author admin
 *BIO的tomcat
 *服务端
 */
public class BIOServer {

	public static void main(String[] args) throws IOException {
		//监听端口8080
		@SuppressWarnings("resource")
		ServerSocket serverSocket = new  ServerSocket(8080);
		while(true) {
			Socket socket = serverSocket.accept();
			//使用缓冲技术Buffer
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String buffer = null;
			//打印客户端的请求
			while((buffer = bufferedReader.readLine())!=null && !buffer.equals("")) {
				System.out.println("客户端的请求:"+buffer);
			}
			//给客户端一个展示html
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("HTTP/1.1 200 OK\n Content-Type:text/html;charset=UTF-8\n\n");
			bw.write("<html><head><title>bio</title></head><body><h1>Hello  world! BIO...</h1></body></html>");
			bw.flush();//进行提交
			bw.close();
			bufferedReader.close();
			socket.close();
			
		}
	}
}

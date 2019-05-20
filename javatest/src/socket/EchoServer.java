package socket;
import java.io.*;
import java.net.*;

public class EchoServer{
	private int port = 8000;
	private ServerSocket serverSocket;
	
	public EchoServer() throws IOException {
		// TODO Auto-generated constructor stub
		serverSocket = new ServerSocket(port);
		System.out.println("服务器正在启动中........");
	}
	
	public void service() {
		while(true) {
			Socket socket = null;
			try {
				socket =  serverSocket.accept();
				Thread workThread = new Thread(new Handler(socket));
				workThread.start();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		new EchoServer().service();
	}
}

class Handler implements Runnable{
	private Socket socket;
	
	public Handler(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	private PrintWriter getWriter(Socket socket) throws IOException {
		OutputStream outputStream = socket.getOutputStream();
		return new PrintWriter(outputStream,true);
	}
	private BufferedReader getReader(Socket socket) throws IOException {
		InputStream inputStream = socket.getInputStream();
		return new BufferedReader(new InputStreamReader(inputStream));
	}
	public String echo(String msg) {
		return msg;
	}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		System.out.println("new connection accepted:"+socket.getInetAddress()+":"+socket.getPort());
		BufferedReader br = getReader(socket);
		PrintWriter pw = getWriter(socket);
		String mesg = null;
			while((mesg = br.readLine())!=null) {
				pw.println(echo(mesg));
				if(mesg.equals("bye"));
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(socket!=null)
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
}
package socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FTP {
	private static final int port = 8000;
	private ServerSocket serverSocket;
	
	public FTP() {
		try {
			this.serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("服务启动中...");
	}
	
	public void receiveFile(Socket socket){
		try {
			InputStream in = socket.getInputStream();
			ObjectInputStream ois = new ObjectInputStream(in);
			File file = (File) ois.readObject();
			FileInputStream fin = new FileInputStream(file);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(fin));
			String line = null;
			while((line = buffer.readLine())!=null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void service() {
		System.out.println("服务中...");
		Socket socket = null;
		while(true) {
			try {
				socket = serverSocket.accept();
				receiveFile(socket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FTP().service();
	}

}

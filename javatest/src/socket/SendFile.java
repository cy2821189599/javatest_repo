package socket;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SendFile {
	private static final int port = 8000;
	private static final String host = "localhost";
	private Socket socket = null;
	
	

	public SendFile() {
		try {
			this.socket = new Socket(host, port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendFile() throws IOException {
		String fileStr = "/root/shell.sh";
		File file = new File(fileStr);
		System.out.println("正在发送文件"+fileStr+"到主机"+host);
		OutputStream out = socket.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(file);
		out.close();
		oos.close();
		socket.close();
		System.out.println("文件发送完成");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new SendFile().sendFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

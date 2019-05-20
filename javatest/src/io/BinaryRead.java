package io;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file1 = new File("C:\\Users\\cy282\\Pictures\\Saved Pictures\\cb83623191b23bf7db6478919832f363.jpg");
		FileInputStream fis = new FileInputStream(file1);
//		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		DataInputStream dis = new DataInputStream(fis);
		File file2 = new File("C:\\Users\\cy282\\Desktop\\java io\\p1.jpg");
		FileOutputStream fos = new FileOutputStream(file2);
		DataOutputStream dos = new DataOutputStream(fos);
	
//		String data2 = "";
//		
//		while((data2 = br.readLine())!=null) {
//			System.out.println(data2);
//		}
		
		
//		int data3 = -1;
//		
//		while((data3=fis.read())!=-1) {
//			System.out.println(Integer.toBinaryString(data3));
//			fos.write(data3);
//		}
		
		
		byte[] buff = new byte[1024]; 
		
		int length = 0;
		while((length = dis.read(buff,0,buff.length))!=-1) {
			//System.out.println(length);
			dos.write(buff, 0 , length);
		}
		
		
		//效率太低
//		int data = -1;
//		while((data=dis.read())!=-1) {
//			System.out.println(Integer.toBinaryString(data));
//			dos.writeByte(data);
//		}
		System.out.println("文件写入成功!");
		
		fis.close();
		dis.close();
		fos.close();
		dos.close();
		
	}

}

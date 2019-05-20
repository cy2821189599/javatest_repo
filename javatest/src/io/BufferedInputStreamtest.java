package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInputStreamtest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedInputStream bufferins = new  BufferedInputStream(new FileInputStream("C:\\Users\\cy282\\Pictures\\Saved Pictures"
				+ "\\8260f6333fb840d220c2a88f99c7ab14.jpg"));
		BufferedOutputStream bufferos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\cy282\\Desktop\\java io\\p2.jpg"));
		byte[] data = new byte[2048];
		int len = 0;
		long start = System.currentTimeMillis();
		while((len = bufferins.read(data))!=-1) {
			bufferos.write(data ,0 ,len);
		}
		bufferins.close();
		bufferos.close();
		long end = System.currentTimeMillis();
		System.out.println((end - start)+"ms");
		
		//当缓冲区dt和data缓冲区变大时此方法会没有上面的方法快
		FileInputStream fis = new FileInputStream("C:\\Users\\cy282\\Pictures\\Saved Pictures"
				+ "\\8260f6333fb840d220c2a88f99c7ab14.jpg");
		DataInputStream dis = new  DataInputStream(fis);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\cy282\\Desktop\\java io\\p3.jpg");
		
		DataOutputStream dos = new DataOutputStream(fos);
		
		byte [] dt = new byte[2048];
		int length = 0;
		
		
		long start2 = System.currentTimeMillis();
		
		while((length = dis.read(dt))!=-1) {
			dos.write(dt ,0 , length);
		}
		
		fis.close();
		dis.close();
		fos.close();
		dos.close();
		
		long end2 = System.currentTimeMillis();
		
		System.out.println((end2-start2)+"ms");
		
	}

}

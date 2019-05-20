package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class StreamIO {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
		
			//读取二进制流，一个字节一个字节的读取
		
			File file = new File("C:\\Users\\cy282\\Desktop\\java io\\io.txt");
			FileInputStream in = new FileInputStream(file);
			System.out.println("一个字节一个字节地读取数据");
			int size = in.available();
			
			for(int i=0 ; i<size ; i++) {
				System.out.println(in.read());
			}
			
			in.close();
			
			//将字节流转换为字符流
			
			System.out.println("一个字符一个字符地读取数据");
			FileInputStream in2 = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(in2,"gbk");
			int i=0;
			while((i=isr.read())!=-1) {
				System.out.println((char)i);
				System.out.println(i);
			}
			in2.close();
			isr.close();
			
			
			//一次读取一行字符，封装了StreamReader
			
			System.out.println("一次读取一行的数据，效率最高，缓存更大");
			FileInputStream in3 = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(in3,"gbk"));
			String str = null;
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
			
			in3.close();
			br.close();
			
	}

}

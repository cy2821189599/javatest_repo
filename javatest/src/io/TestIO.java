package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestIO {
	public static void main(String [] args) throws IOException {
		
		char c;
		//字符流
		//个人总结，后缀为er的都是字符流，后缀为Stream的都是字节流,纯属为了好记
		//它们真正的区别在于字符流用到了缓存，而字节流没有用到缓存，字节流的效率要低
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("请输入一个字符，输入q结束");
		do {
			c = (char) br.read();
			System.out.println(c);
		}while(c!='q');
		
		String str;
		System.out.println("请输入一个字符串，以end结束");
		
		do {
			
			str = br2.readLine();
			
		}while(!str.equals("end"));
		
		int b = 0x121;
		
		System.out.write(b);
		System.out.write('\n');
	}
}

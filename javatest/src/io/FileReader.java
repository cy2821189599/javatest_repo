package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

class FileReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f = new File("C:\\Users\\cy282\\Desktop\\java io\\binary.txt");
		FileInputStream fis = new FileInputStream(f);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis,"gbk"));
		
		String len = null ;
		String binstr = "";
		
		while((len=br.readLine())!=null) {
			
			System.out.println(len);
			
			char [] ch = len.toCharArray();
			
			for(int i=0 ; i <  ch.length; i++) {
				binstr += Integer.toBinaryString(ch[i])+ " ";
				System.out.println((int)ch[i]);
			}
			
		}
		System.out.println(binstr);
		
		fis.close();
		br.close();
	}

}

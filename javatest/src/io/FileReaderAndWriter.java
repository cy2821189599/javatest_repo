package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FileReaderAndWriter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			File file = new File("C:\\Users\\cy282\\Desktop\\java io\\file.txt");
//			FileWriter writer = new FileWriter(file);
//			writer.append("Hello");
//			writer.append("chenyun");
//			writer.append("早上好");
//			writer.flush();
//			writer.close();
			FileReader reader = new FileReader(file);
			
			char [] ch = new char[100];
			
			reader.read(ch);
			
			for(char a: ch) {
				System.out.print(a);
			}
			
			reader.close();
			
			System.out.print('\n');
			
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis,"utf8");
			int c = -1;
			while((c=isr.read())!=-1) {
				System.out.print((char)c);
			}
			fis.close();
			isr.close();
	}

}

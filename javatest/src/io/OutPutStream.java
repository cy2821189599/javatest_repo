package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class OutPutStream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File f = new File("C:\\Users\\cy282\\Desktop\\java io\\binary.txt");
		OutputStream fos = new FileOutputStream(f);
		
		byte bWrite[] = { 110, 32,34 , 21, 3, 40, 5  };
		
		
		for (int x = 0; x < bWrite.length; x++) {
			System.out.println(bWrite[x]);
            fos.write(bWrite[x]); // writes the bytes
        }
        fos.close();
		
        InputStream is = new FileInputStream("C:\\Users\\cy282\\Desktop\\java io\\binary.txt");
        int size = is.available();

        for (int i = 0; i < size; i++) {
            System.out.print((char) is.read() + "  ");
        }
        is.close();
	}

}

package Lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

import org.junit.jupiter.api.Test;


public class TestLambda {
	
	
	
	public String read(){
	    try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\cy282\\Desktop\\java io\\file.txt"))) {
	        return br.readLine();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    return null;
	}
	
	
	
	public interface BufferedReaderProcessor{
	    String process(BufferedReader b) throws IOException;
	}
	
	
	public String read(BufferedReaderProcessor p) throws IOException{
	    try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\cy282\\Desktop\\java io\\file.txt"))){
	        return p.process(br);
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
		}
	    return  null;
	}
	
	@Test
	public void readFile() throws IOException {
		String oneLine = read(BufferedReader::readLine);
		System.out.println(oneLine);
		String twoLine = read((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLine);
	}
	
	@Test
	public void readFile0() throws IOException {
		String oneLine = read();
		System.out.println(oneLine);
	}
	
	
}

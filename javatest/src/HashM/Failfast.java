package HashM;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;




interface TestIn{
	public static void print() {
		System.out.println("Hello");
	}
	public void run();
}





public class Failfast implements TestIn{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			   
			   
		       Map<String, String> map = new HashMap<>();
	           for (int i = 0 ; i < 10 ; i ++ ) {
	                map.put(i+"", i+"");
	           }
	           Iterator<Entry<String, String>> it = map.entrySet().iterator();
	           int i = 0;
	           while (it.hasNext()) {
	                if (i == 3) {
	                     map.remove(3+"");
	                }
	                Entry<String, String> entry = it.next();
	                System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
	                i++;
	     }
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("running ....i am running");
	}

}

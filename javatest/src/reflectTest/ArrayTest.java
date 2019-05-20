package reflectTest;

import java.lang.reflect.Array;

public class ArrayTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class classType = Class.forName("java.lang.String");
		Object array = Array.newInstance(classType, 5);
		Array.set(array, 4, "hello");
		String s = (String) Array.get(array, 4);
		System.out.println(s);
		
	}

}

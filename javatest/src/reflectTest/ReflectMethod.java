package reflectTest;

import java.lang.reflect.Method;

public class ReflectMethod {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		Class clazz = Class.forName(args[0]);
		ClassLoader loader = ReflectMethod.class.getClassLoader();
		Class clazz2 = loader.loadClass(args[0]);	//通过类加载器加载类对象
		System.out.println(clazz2);
		Method[] methods = clazz.getDeclaredMethods();
		for(int i=0; i<methods.length; i++) {
			System.out.println(methods[i].toString());
		}
	}

}

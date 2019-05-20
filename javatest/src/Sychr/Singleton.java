package Sychr;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

public class Singleton {
	//饿汉式解决线程安全问题
	private static final AtomicReference<Singleton> instance = new AtomicReference<Singleton>();
	private int count = 10;
	
	public Singleton() {
		// TODO Auto-generated constructor stub
	}
	
	public static Singleton getInstance() {
		for(;;) {
			Singleton singleton = instance.get();
			if(null != singleton) {
				return singleton;
			}
			singleton = new Singleton();
			//如果instance的值 为null,更新instance的指为 singleton,并返回true
			if(instance.compareAndSet(null, singleton)){
				return singleton;
			}
		}
	}
	
	public void great() {
		System.out.println("hello");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stu
		Singleton single = Singleton.getInstance();
		single.great();
		try {
			Class<?> clazz = Class.forName("Sychr.Singleton");
			Object obj = clazz.newInstance();
			Method method = clazz.getMethod("great");
			method.invoke(obj);
			Field field = clazz.getDeclaredField("count");
			field.setAccessible(true);
			System.out.println(field.get(obj));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

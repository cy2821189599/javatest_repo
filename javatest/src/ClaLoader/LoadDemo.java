package ClaLoader;

public class LoadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ClassLoader loader = Demo.class.getClassLoader();
		ClassLoader loader = ClassLoader.getSystemClassLoader();
		System.out.println(loader);
		try {
			Class<?> clazz = loader.loadClass("ClaLoader.Demo");
			System.out.println(clazz);
			//创建实例时才会调用静态块
			try {
				Object demo = clazz.newInstance();
				System.out.println(demo);
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

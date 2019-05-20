package ClaLoader;

public class LoadDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//没有创建实例也会调用静态块
		try {
			Class<?> clazz = Class.forName("ClaLoader.Demo");
			System.out.println(clazz);
			try {
				Demo demo = (Demo) clazz.newInstance();
				System.out.println(demo);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

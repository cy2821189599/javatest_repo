package designModel.singleton;

public class Singleton {

	private volatile static Singleton uniqueInstance;
	
	private Singleton() {
		System.out.println("我是唯一的实列！");
	}
	
	public static Singleton getInstance() {
		if(uniqueInstance == null) {
			synchronized(Singleton.class) {
				if(uniqueInstance == null) {
					uniqueInstance = new Singleton();
				}
			}
		}
		return uniqueInstance;
	}
	
	
	public void hello() {
		System.out.println("hello!");
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2);
		Singleton instance3 = Singleton.class.newInstance();
		System.out.println(instance == instance3);
	}
}

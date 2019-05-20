package designModel.singleton;
/**
 * 最有效的单例模式实现方法，且线程安全
 * @author admin
 *
 */
public enum SingletonEnum {
	INSTANCE;
	Object object;
	private SingletonEnum() {
		object = new Object();
	}
	
	public Object getInstance() {
		return object;
	}
}

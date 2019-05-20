package designModel.singleton;

public class TestEnumSingleton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object instance = SingletonEnum.INSTANCE.getInstance();
		Object instance2 = SingletonEnum.INSTANCE.getInstance();
		System.out.println(instance == instance2);
	}

}

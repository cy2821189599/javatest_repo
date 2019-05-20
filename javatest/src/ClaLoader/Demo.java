package ClaLoader;

public class Demo {
	
	private String name;
	
	
	public Demo() {
		super();
	}


	public Demo(String name) {
		this.name = name;
	}


	static {
		System.out.println("调用静态块");
	}
}

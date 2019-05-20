package designModel.staticproxy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloService helloService = new HelloServiceImpl();
		HelloService helloServiceProxy = new HelloServiceProxy(helloService);
		System.out.println(helloServiceProxy.echo("hello"));
	}

}

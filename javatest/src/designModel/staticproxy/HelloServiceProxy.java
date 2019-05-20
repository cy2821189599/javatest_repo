package designModel.staticproxy;

import java.util.Date;

public class HelloServiceProxy implements HelloService {
	private HelloService helloService; //被代理的HelloServivce 实例
	
	

	public HelloServiceProxy(HelloService helloService) {
		this.helloService = helloService;
	}

	public void setHelloServiceProxy(HelloService helloService) {
		this.helloService = helloService;
	}
	@Override
	public String echo(String msg) {
		// TODO Auto-generated method stub
		System.out.println("before calling echo()");
		String result = helloService.echo(msg);
		System.out.println("after calling  echo()");
		return result;
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		System.out.println("before  calling getDate()");
		Date date = helloService.getDate();
		System.out.println("after calling getDate()");
		return date;
	}

}

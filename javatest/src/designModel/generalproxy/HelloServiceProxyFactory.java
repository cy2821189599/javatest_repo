package designModel.generalproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceProxyFactory {
	/**
	 * 创建一个实现了HelloService 接口的动态代理类实例
	 * 参数helloService引用被代理的HelloService实例
	 */
	public static HelloService getHelloServiceProxy(final HelloService helloService) {
		//创建一个实现了InvocationHandler 接口的匿名内嵌类实例，赋值给父类对象
		InvocationHandler handler = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				System.out.println("before calling "+method);
				Object result = method.invoke(helloService, args);
				//调用被代理的HelloService实例的方法
				System.out.println("after calling "+method);
				return result;
			}
		};
		
		Class classType = HelloService.class;
		return (HelloService) Proxy.newProxyInstance(classType.getClassLoader(),
				new Class[] {classType},
				handler);
	}//#getHelloServiceProxy()
}

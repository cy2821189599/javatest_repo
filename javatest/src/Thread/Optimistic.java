package Thread;

import java.util.concurrent.atomic.AtomicInteger;

public class Optimistic {
	private static int value1 = 0;
	private static AtomicInteger value2 = new AtomicInteger(0);
	private static int value3 = 0;
	
	private static synchronized void increaseValue3() {
		value3++;
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		for(int i=0; i<1000; i++) {
			new Thread(new  Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					value1++;
					value2.getAndIncrement();
					increaseValue3();
				}
			}).start();
		}
		Thread.sleep(100);
		System.out.println("线程不安全："+value1);
		System.out.println("乐观锁（AtomiticInteger):"+value2);
		System.out.println("悲观锁（Synchronize):"+value3);
	}

}

package Thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafe2 {
	
	static int count  = 0;
	
	private static Lock lock = new ReentrantLock();
	
	public static void getCount() {
		count++;
		System.out.println(Thread.currentThread().getName()+":"+count);
	}
	
	//使用锁机制保证线程安全
	public static void getLock() {
		lock.lock();
		//使用trylock()方法也行，这是一个非阻塞的方法（当锁加上锁时，此时线程并不会一直等待，等待时间自己设置）
		try {
			System.out.println(Thread.currentThread().getName()+"获得了锁");
			getCount();
		}catch(Exception e) {
			e.getStackTrace();
		}finally {
			lock.unlock();
			System.out.println(Thread.currentThread().getName()+"释放了锁");
		}
	}
	
	
	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		Thread A = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<10; i++) {
					getLock();
				}
			}
		});
		Thread B = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<10; i++) {
					getLock();
				}
			}
		});
		A.start();
		B.start();
	}

}

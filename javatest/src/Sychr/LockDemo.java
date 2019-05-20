package Sychr;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo implements Runnable{
	private int i = 0;
	//公平锁，ReentranLock(true)
	Lock lock = new ReentrantLock();

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LockDemo task = new  LockDemo();
		Thread threadA = new Thread(task, "ThreadA");
		Thread threadB = new Thread(task, "ThreadB");
		threadA.start();
		threadB.start();
	}
	
	@Override
	public void run() {
		for(int j=0; j<100; j++) {
			lock.lock();
			i++;
			System.out.println(Thread.currentThread().getName()+" i="+i);
			lock.unlock();
		}
	}

}

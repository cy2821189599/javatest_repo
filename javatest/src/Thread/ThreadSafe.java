package Thread;


/**
 * @author admin
 *非线程安全的情况，发生在多线程情况下访问共享数据，且没有线程同步机制
 *避免方法，1.加锁,2.同步机制
 */
public class ThreadSafe {
	
	static int  count = 0;//记录访问的次数
	
	//非线程安全
	@Deprecated
		public static void getCount0() {
			count++;
			System.out.println(Thread.currentThread().getName()+":"+count);
		}
	
	//使用同步机制Synchronized
	public static synchronized void getCount() {
		count++;
		System.out.println(Thread.currentThread().getName()+":"+count);
	}
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread  A = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<10; i++) {
				getCount();
				}
			}
		});
		Thread  B = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<10; i++) {
				getCount();
				}
			}
		});
		Thread  C = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int i=0; i<10; i++) {
				getCount();
				}
			}
		});
			A.start();
			B.start();
			C.start();
	}

}

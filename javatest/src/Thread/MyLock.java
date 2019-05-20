package Thread;

import java.util.concurrent.locks.ReentrantLock;

public class MyLock {
		int i = 0;
		
		ReentrantLock lock = new ReentrantLock();
		
		public  void  crs() {
			lock.lock();
			i++;
			lock.unlock();
		}

		public static void main(String[] args) throws InterruptedException{
			MyLock myLock = new MyLock();
			
			for(int j = 0; j< 2;j++) {
				new Thread(()-> {
					
						// TODO Auto-generated method stub
						for(int i = 0; i< 2000; i++) {
							myLock.crs();
						}
				}
				).start();;
			}
			Thread.sleep(1000);
			System.out.println(myLock.i);
		}
		}

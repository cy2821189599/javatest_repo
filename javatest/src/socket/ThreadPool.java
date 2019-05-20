package socket;

import java.util.LinkedList;

public class ThreadPool extends ThreadGroup{


	private boolean isClosed = false;	//线程池是否关闭
	private LinkedList<Runnable> workqueue;		//表示工作队列
	private static int threadPoolID;	//表示线程池ID
	private int threadID;	//表示工作线程ID
	
	public ThreadPool(int poolSize) {	//poolSize指定线程池的工作线程的数量
		// TODO Auto-generated constructor stub
		super("ThreadPool-"+(threadPoolID++));
		setDaemon(true);
		workqueue = new LinkedList<Runnable>();		//创建工作队列
		for(int i=0; i<poolSize; i++) {		//创建并启动工作线程
				new workThread().start();
		}
	}
	
	public synchronized void execute(Runnable task) {
		if(isClosed) {
			throw new IllegalStateException();
		}
		if(task != null) {
			workqueue.add(task);
			notify();	//唤醒一个在getTask()方法等待任务的线程
		}
	}
	
	// 从工作队列中选取出一个任务，工作线程会调用此方法
	protected synchronized Runnable getTask() throws InterruptedException {
		while(workqueue.size() == 0) {
			if(isClosed) return null;
			wait();
		}
		return workqueue.removeFirst();
	}
	
	//关闭线程池
	public synchronized void close() {
		if(!isClosed) {
			isClosed = true;
			workqueue.clear();
			interrupt();
		}
	}
	
	// 等待工作线程把所有任务执行完
	public void join() {
		synchronized(this) {
			isClosed = true;
			notifyAll();	//唤醒所有线程
		}
		
		Thread[] threads = new Thread[activeCount()];
		// enumerate() 方法继承自ThreadGroup类，先把当前线程组的线程拷贝给制定的数组(进行赋值),返回线程组中当前所有活着的工作线程数量 
		int count = enumerate(threads);
		for(int i=0; i<count; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//内部类，工作线程
	private class workThread extends Thread{
		public workThread() {
			//加入到当前ThreadPool线程组中
			super(ThreadPool.this,"WorkThread-"+(threadID++));
		}
		
		public void run() {
			while(!isInterrupted()) {	//isInterrupted()方法继承自Thread类，判断线程是否被中断
				Runnable task = null;
				try {
					task = getTask();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//如果getTask()返回null或者线程执行 getTask()时被中断，则结束此线程
				if(task == null)return;
				task.run();
			}
		}
	}
}

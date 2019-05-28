package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutrueTaskDemo {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService threadPoll = Executors.newCachedThreadPool();
		/**
		 * 关于FutureTask<Runnable task,T Result>的使用
		 * result 只是一个标记。。。。。。。无语了
		 * 之前还以为是过程结果呢。。。。
		 */
		Task3 task3 = new Task3();
		FutureTask<String> rFutureTask = new FutureTask<String>(task3,"任务完成");	//无法执行下去用线程池
//		threadPoll.submit(task3);
 		Task2 task = new Task2();
		FutureTask<Integer> futureTask = new FutureTask<>(task);
		threadPoll.submit(futureTask);
		threadPoll.shutdown();
		
		
		System.out.println("main thread is running");
		new Thread(rFutureTask).start();	//没有这个线程就有问题,使用线程池就不行
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String reString = rFutureTask.get();
			System.out.println(rFutureTask.isDone());
			System.out.println(reString);
			Integer resultInteger = futureTask.get();
			System.out.println(resultInteger);
			System.out.println("subthread is done");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main thread is done");
	}
	
}


class Task2 implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("subthread is running");
		System.out.println("doing task...");
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += i;
		}
		return sum;
	}
}

class Task3 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("l am runnable task, no return.");
	}
	
}
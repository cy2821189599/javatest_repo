package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;




/**
 * Future<T>就是对于具体的Runnable或者Callable任务的执行结果进行取消、
 * 查询是否完成、获取结果。必要时可以通过get方法获取执行结果，该方法会阻塞直到任务返回结果。
 * @author root
 *
 */
public class FutrueDemo {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//线程池
		 ExecutorService executorService = Executors.newCachedThreadPool();
		 Task task = new Task();
		 try {
			Integer rFutue = task.call();
			System.out.println(rFutue);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 Future<Integer> result = executorService.submit(task);
		 Task task2 = new Task();
		 /**
		  * Future<T> 中阻塞的方法，用来处理在多线程情况下获取返回值等等
		  * cancel(boolean)
		  * isCancelled()
		  * isDone()
		  * get()
		  * get(long, TimeUnit)
		  * 
		  */
		 
		 Future<Integer> resFuture = executorService.submit(task2);
		 executorService.shutdown();	//让提交的作业(队列里的作业)执行完后终止线程池,不再接受作业任务
		 //shutdownNow()会将线程池设置为close状态

		 
		 try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("主线程正在执行");
		 try {
			System.out.println("task计算结果"+result.get());
			System.out.println("task计算结果"+resFuture.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("任务执行完毕");
	}

}

class Task implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("子线程正在计算");
		Thread.sleep(1000);
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
		}
		return sum;
	}
	
}

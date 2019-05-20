package Thread;

public class NolmalDeadLock {

	private static Object obj13 = new Object();
	private static Object obj14 = new Object();

	private static void jamesDo() throws InterruptedException {
		String threadName = Thread.currentThread().getName();
		synchronized (obj14) {
			System.out.println(threadName + " get 14");
			Thread.sleep(100);
			synchronized (obj13) {
				System.out.println(threadName + " do sth");
			}
		}
	}

	private static void lisonDo() throws InterruptedException {
		String threadName = Thread.currentThread().getName();
		synchronized (obj13) {
			System.out.println(threadName + " get 13");
			Thread.sleep(100);
			synchronized (obj14) {
				System.out.println(threadName + " do sth");
			}
		}
	}

	private static class James extends Thread {

		private String name;

		public James(String name) {
			this.name = name;
		}

		public void run() {
			Thread.currentThread().setName(name);
			try {
				jamesDo();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Thread.currentThread().setName("Lison");
		James james = new James("James");
		james.start();
		lisonDo();
	}
}
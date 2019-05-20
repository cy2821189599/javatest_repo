package Sychr;

public class NoSych implements Runnable {
	private int i = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NoSych task = new NoSych();
		Thread threadA = new Thread(task, "ThreadA");
		Thread threadB = new Thread(task, "ThreadB");
		threadA.start();
		threadB.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int j = 0; j < 5; j++) {
			synchronized (this) {
				i++;
				System.out.println(Thread.currentThread().getName() + " i=" + i);
			}
		}
	}

}

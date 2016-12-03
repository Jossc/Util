package ThreadUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptiblyTest {
	public void test3() throws InterruptedException{
		final Lock lock = new ReentrantLock();
		lock.lock();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					lock.lockInterruptibly();
				} catch (Exception e) {
					System.out.println(Thread.currentThread().getName()+"3");
				}
			}
		},"Thread-child-3");
		t1.start();
		Thread.sleep(1000);
		t1.interrupt();
		Thread.sleep(100000);
	}
	public static void main(String []args){
		try {
			new InterruptiblyTest().test3();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

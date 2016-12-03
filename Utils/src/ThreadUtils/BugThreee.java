package ThreadUtils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决bugThree
 * ReentrantLock:超时锁
 * @author JossC
 *
 */
public class BugThreee {
	final static ReentrantLock l1 = new ReentrantLock();
	final static ReentrantLock l2 = new ReentrantLock();
	public static void main(String []args) throws InterruptedException{
		Thread t1 = new Thread(){
			public void run(){
				try {
					System.out.println("开始");
					l1.lockInterruptibly();
					Thread.sleep(1000);
					l2.lockInterruptibly();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				try {
					System.out.println("111");
					l2.lockInterruptibly();
					Thread.sleep(1000);
					l1.lockInterruptibly();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		};
		System.out.println("开始执行");
		t1.start();
		t2.start();
		Thread.sleep(1000);
		t1.interrupt();
		t2.interrupt();
		t1.join();
		t2.join();
		System.out.println(System.currentTimeMillis());
	}
}

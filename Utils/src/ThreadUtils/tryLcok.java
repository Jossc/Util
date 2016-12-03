package ThreadUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLcok 返回boolean
 * tryLock()，马上返回，拿到lock就返回true，
 * 不然返回false。 比较潇洒的做法。
 * 带时间限制的tryLock()，拿不到lock，就等一段时间，
 * 超时返回false。比较聪明的做法。
 * @author JossC
 *
 */
public class tryLcok {
	public void test() throws InterruptedException{
		final Lock lock = new ReentrantLock();
		boolean boo =	lock.tryLock();
		System.out.println(boo);
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				boolean bo = lock.tryLock();
				System.out.println(bo);
				System.out.println(Thread.currentThread().getName()+"Threaad -child-2");
			}
		},"thread child-2");
		t1.start();
		Thread.sleep(1000);
		t1.interrupt();
		lock.unlock();
	}
	public static void main(String []args){
		try {
			new tryLcok().test();
		} catch (Exception e) {
			System.out.println(e.getMessage()+"只是测试");
		}
		
	}
}

package ThreadUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * lock(), 拿不到lock就不罢休，不然线程就一直block。 比较无赖的做法。
 * @author JossC
 *
 */
public class LockTest {
		
	public void test() throws InterruptedException{
		final Lock lock = new ReentrantLock() ;
		lock.lock();
		System.out.println("子线程开始");
		Thread t1 = new Thread(new  Runnable(){
			@Override
			public void run() {
				lock.lock();
				//lock.tryLock();
				System.out.println(Thread.currentThread().getName()+"one");
			}
			
		},"child thread -1");
		t1.start();
		Thread.sleep(1000);
		t1.interrupt();
	}
	public static void main(String []args){
		try {
			System.out.println("主线程开始");
			new LockTest().test();
			System.out.println("主线程结束");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

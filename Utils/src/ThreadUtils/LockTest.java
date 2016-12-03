package ThreadUtils;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * lock(), �ò���lock�Ͳ����ݣ���Ȼ�߳̾�һֱblock�� �Ƚ�������������
 * @author JossC
 *
 */
public class LockTest {
		
	public void test() throws InterruptedException{
		final Lock lock = new ReentrantLock() ;
		lock.lock();
		System.out.println("���߳̿�ʼ");
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
			System.out.println("���߳̿�ʼ");
			new LockTest().test();
			System.out.println("���߳̽���");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

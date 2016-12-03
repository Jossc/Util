package ThreadUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * tryLcok ����boolean
 * tryLock()�����Ϸ��أ��õ�lock�ͷ���true��
 * ��Ȼ����false�� �Ƚ�������������
 * ��ʱ�����Ƶ�tryLock()���ò���lock���͵�һ��ʱ�䣬
 * ��ʱ����false���Ƚϴ�����������
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
			System.out.println(e.getMessage()+"ֻ�ǲ���");
		}
		
	}
}

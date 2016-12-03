package ThreadUtils;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 中断线程
 * @author JossC
 *
 */
public class BugFour {
	final static ReentrantLock l1 = new ReentrantLock();
	final static ReentrantLock l2 = new ReentrantLock();
	public  static void main(String []args){
		Thread t1 = new Thread(){
			public void run(){
				try {
					l1.lockInterruptibly();
					Thread.sleep(1000);
					System.out.println("1111111");
					l2.lockInterruptibly();
				} catch (InterruptedException e) {
					System.out.println("t1 Interruptibly  已经打断");
				}
			}
		};
		t1.start();
		t1.interrupt();
		
	
	}
	

}

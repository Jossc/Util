package ThreadUtils;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁和非公平锁 
 * @author JossC
 *
 */
public class D {
	public static final ReentrantLock lock = new ReentrantLock();
	public  static final ReentrantLock fariLock = new ReentrantLock();
	private int n ;
	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	public static void main(String []args){
		D d = new D();
		long s = System.currentTimeMillis();
//		for(int i =0;i<100;i++){
//			Thread fair = new Thread(new FariTestThread(d));
//			fair.start();
//		}
		
		for(int i = 0;i<100;i++){
			Thread fair = new Thread(new NoFariTestThread(d));
			fair.start();
		}
		long a = System.currentTimeMillis();
		System.out.println(a-s+"秒");
	}
	
}

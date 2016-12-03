package ThreadUtils;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * 原子变量
 * 此代码有乱序
 * @author JossC
 *
 */
public class InnCouting {

	final static AtomicInteger counter = new AtomicInteger();
	public static void main(String[] arhs) {
		CountingThread t1 = new CountingThread();
		CountingThread t2 = new CountingThread();
		try {
			t1.start();
			t2.start();
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}

class CountingThread extends Thread {
	public void run() {
		for (int x = 0; x < 20; x++) {
			System.out.println(InnCouting.counter.incrementAndGet());
		}
	}
}

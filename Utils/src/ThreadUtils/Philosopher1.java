package ThreadUtils;
import java.util.Random;
/**
 * 加上判断使得线程更加稳定
 * if (left.getID() > right.getID()) {
			first = left;
			second = right;
		} else {
			first = right;
			second = left;
		}
 * 避免出现死锁情况
 * @author JossC
 *
 */
public class Philosopher1 implements Runnable {
	private Chopstick first, second;
	private Random random;

	public Philosopher1(Chopstick left, Chopstick right) {
		if (left.getID() > right.getID()) {
			first = left;
			second = right;
		} else {
			first = right;
			second = left;
		}
		random = new Random();
	}

	public void run() {
		try {
			while (true) {
				Thread.sleep(random.nextInt(1000));
				System.out.println("思考------");
				synchronized (first) {
					synchronized (second) {
						System.out.println("開始------------");
						Thread.sleep(random.nextInt(1000));
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String []args){
		Chopstick left = new Chopstick();
		Chopstick 	right = new Chopstick();
		new Thread(new Philosopher1(left, right)).start();
		System.identityHashCode(10);
	}

}

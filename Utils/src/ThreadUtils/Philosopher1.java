package ThreadUtils;
import java.util.Random;
/**
 * �����ж�ʹ���̸߳����ȶ�
 * if (left.getID() > right.getID()) {
			first = left;
			second = right;
		} else {
			first = right;
			second = left;
		}
 * ��������������
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
				System.out.println("˼��------");
				synchronized (first) {
					synchronized (second) {
						System.out.println("�_ʼ------------");
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

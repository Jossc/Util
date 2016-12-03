package ThreadUtils;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * trylock(time,timeuntils) ���Ա������������Ǳ��ⲻ��Դ����
 * 
 * @author JossC
 *
 */

public class Philosopher2 extends Thread {
	private ReentrantLock left, righrt;
	private Random randmo;

	public Philosopher2(ReentrantLock left, ReentrantLock righrt) {
		this.left = left;
		this.righrt = righrt;
		randmo = new Random();
	}

	public void run() {
		try {
			while (true) {
				System.out.println("��ʼ�߳�");
				Thread.sleep(randmo.nextInt(1000));
				System.out.println("left׼����");
				left.lock();
				try {
					System.out.println("righrt׼����,tryLock(1000, TimeUnit.MICROSECONDS)");
					if (righrt.tryLock(1000, TimeUnit.MICROSECONDS)) {
						try {
							Thread.sleep(randmo.nextInt(1000));
						} finally {
							System.out.println("righrt�ͷ���");
							righrt.unlock();
						}
					}
				} finally {
					System.out.println("left�ͷ���");
					left.unlock();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String []args){
		 ReentrantLock left = new ReentrantLock();
		 ReentrantLock righrt = new ReentrantLock();
		 new Philosopher2(left, righrt).run();
	}
}

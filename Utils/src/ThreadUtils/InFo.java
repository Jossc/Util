package ThreadUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InFo {
	private static Lock a = new ReentrantLock();
	// a ��c1s��
	private static Condition c1 = a.newCondition();
	// a ��c1s��
	private static Condition c2 = a.newCondition();

	public static void Runl() {
		// a��������ʼͬ��
		a.lock();
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "a c1 ��������");
				// ������
				c2.signal();
				System.err.println("c2 �Ѿ�������");
				try {
					// ��ͣc1��
					c1.await();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} finally {
			// �ͷ���
			a.unlock();
		}
	}

	public static void Run2() {
		a.lock();
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "");
				c1.signal();
				try {
					c2.await();
				} catch (Exception e) {
					System.out.println(e.getMessage() + "44");
				}
			}
		} finally {
			a.unlock();
		}
	}
}

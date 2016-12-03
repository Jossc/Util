package ThreadUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InFo {
	private static Lock a = new ReentrantLock();
	// a 绑定c1s锁
	private static Condition c1 = a.newCondition();
	// a 绑定c1s锁
	private static Condition c2 = a.newCondition();

	public static void Runl() {
		// a上锁，开始同步
		a.lock();
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "a c1 正在运行");
				// 唤醒锁
				c2.signal();
				System.err.println("c2 已经被唤醒");
				try {
					// 暂停c1锁
					c1.await();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} finally {
			// 释放锁
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

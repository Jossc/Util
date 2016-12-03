package ThreadUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 条件锁 模型
 * 一个条件变量需要与一把锁关联
 * 在线程等待的前必须获取这把锁
 * 获取后监查所有等待的条件，如果为true
 * 线程解锁继续执行，反正 现在调用await()
 * 阻塞当前线程
 * @author JossC
 *
 */
public class Boolean_Thread  extends Thread{
	public static void main(String []agrs){
		ReentrantLock lock = new ReentrantLock();
		Condition coon = lock.newCondition();
		lock.lock();
		try {
			//while(判断条件)
			while(true){
				coon.await();
			}
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		  //e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
}

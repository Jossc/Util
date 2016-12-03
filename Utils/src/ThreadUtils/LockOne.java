package ThreadUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * JDk 5
 *  public void m() {
 *     lock.lock();  // block until condition holds
 *     try {
 *       // ... method body
 *     } finally {
 *       lock.unlock()
 *     }
 *     
 *     Lock 使用模型
 * @author JossC
 *
 */
public class LockOne {
	public static void main(String []args){
		Lock l = new ReentrantLock();
		try {
			l.lock();
		} finally {
			l.unlock();
		}
	}
}

package ThreadUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
/**
 * ������ ģ��
 * һ������������Ҫ��һ��������
 * ���̵߳ȴ���ǰ�����ȡ�����
 * ��ȡ�������еȴ������������Ϊtrue
 * �߳̽�������ִ�У����� ���ڵ���await()
 * ������ǰ�߳�
 * @author JossC
 *
 */
public class Boolean_Thread  extends Thread{
	public static void main(String []agrs){
		ReentrantLock lock = new ReentrantLock();
		Condition coon = lock.newCondition();
		lock.lock();
		try {
			//while(�ж�����)
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

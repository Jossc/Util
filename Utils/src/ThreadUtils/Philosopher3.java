package ThreadUtils;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * ����ģ�� ��
 * ��ѧ�ҽ�������
 * @author JossC
 *
 */
public class Philosopher3 extends Thread {
	private boolean eating;
	private Philosopher3 left;
	private Philosopher3 right;
	private ReentrantLock locak;
	private Condition conn;
	private Random random;

	public Philosopher3(ReentrantLock locak) {
		eating = false;
		this.locak = locak;
		conn = locak.newCondition();
		random = new Random();
	}
	public void setLeft(Philosopher3 left) {
		this.left = left;
	}
	public void setRight(Philosopher3 right) {
		this.right = right;
	}

	/**
	 * �����tink ��ô���ͷ�
	 * ����
	 * @throws InterruptedException
	 */
	private void think() throws InterruptedException {
		System.out.println("1111 ˼��");
		locak.lock();
		try {
			eating = false;
			left.conn.signal();
			right.conn.signal();
		} finally {
			System.out.println("2222 ˼�� �ͷ���");
			locak.unlock();
			Thread.sleep(1000);
		}
	}
	/**
	 * �ж����� 
	 * �Ƿ�Ϊtrue���������һ��Ϊtrue
	 * ��ô�ͼ���
	 * @throws InterruptedException
	 */
	private void eat() throws InterruptedException {
		locak.lock();
		try {
			System.out.println("�ж�����");
			while (left.eating || right.eating) {
				conn.await();
			}
			eating = true;
		} finally {
			System.out.println("�ͷ���");
			locak.unlock();
			Thread.sleep(1000);
		}
	}
	public void run(){
		try {
			while(true){
				think();
				eat();
			}
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String []args){
		ReentrantLock lock = new ReentrantLock();
		Philosopher3 p = new Philosopher3(lock);
		Thread d = new  Thread(p);
		d.start();
		
		
	}

}
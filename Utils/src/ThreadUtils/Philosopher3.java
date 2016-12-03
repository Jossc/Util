package ThreadUtils;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 条件模型 ：
 * 哲学家进餐问题
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
	 * 如果在tink 那么就释放
	 * 餐桌
	 * @throws InterruptedException
	 */
	private void think() throws InterruptedException {
		System.out.println("1111 思考");
		locak.lock();
		try {
			eating = false;
			left.conn.signal();
			right.conn.signal();
		} finally {
			System.out.println("2222 思考 释放锁");
			locak.unlock();
			Thread.sleep(1000);
		}
	}
	/**
	 * 判断条件 
	 * 是否为true如果其中有一个为true
	 * 那么就加锁
	 * @throws InterruptedException
	 */
	private void eat() throws InterruptedException {
		locak.lock();
		try {
			System.out.println("判断条件");
			while (left.eating || right.eating) {
				conn.await();
			}
			eating = true;
		} finally {
			System.out.println("释放锁");
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
package ThreadUtils;

import java.util.Random;

/**
 * 哲学家问题
 * @author JossC
 *
 */
public class Philosopher extends Thread {
	private Chopstick left,right;
	private Random random;
	
	public Philosopher(Chopstick left,Chopstick right){
		this.left = left;
		this.right = right;
		random = new Random();
	}
	public void run(){
		try {
			while(true){
				System.out.println("线程睡眠");
				Thread.sleep(random.nextInt(1000));
				
				synchronized (left) {
					System.out.println("左边");
					synchronized (right) {
						System.out.println("右边");
						System.out.println("--------------------");
						System.out.println("线程开始睡眠");
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
		new Thread(new Philosopher(left, right)).start();
	}
}

package Thread_two;

public class Thread2 extends Thread {
	public Thread2(){
		System.out.println("构造方法打印："
				+Thread.currentThread().getName());
	}
	public void run(){
		System.out.println("run :" +Thread.currentThread().getName());
	}
}

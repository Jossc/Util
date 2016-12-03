package Thread_two;

public class Thread1 extends Thread{
	private int i =5;
	public void run(){
		System.out.println("1="
				+(i--)+Thread.currentThread().getName());
	}
	
}

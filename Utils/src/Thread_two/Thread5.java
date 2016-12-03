package Thread_two;

public class Thread5  extends Thread{
	public Thread5(){
		System.out.println("Thread5--");
		System.out.println("Thread currentThread"
				+Thread.currentThread().getName());
		
		System.out.println("Thread.isAlive"+
		Thread.currentThread().isAlive());
		
		System.out.println("this .getName()"+
		this.getName());
		System.out.println("this.isAlive"+
		this.isAlive());
		System.out.println("-------Thread5");
	}
}

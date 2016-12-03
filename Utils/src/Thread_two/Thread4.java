package Thread_two;

public class Thread4  extends Thread{
	public void run(){
		System.out.println("thread name "+
				Thread.currentThread().getName()
				+" "+this.isAlive());
	}
}

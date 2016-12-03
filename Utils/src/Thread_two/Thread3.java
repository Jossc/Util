package Thread_two;

public class Thread3  extends Thread{
	public Thread3(){
		System.out.println("Thread"+
				Thread.currentThread().getName());
		System.out.println("this name" +
				this.getName());
		System.out.println("end");
	}
	public void run(){
		System.out.println("run -begin");
		System.out.println("Thread name"
				+    Thread.currentThread().getName());
		System.out.println("this.getName"+   
				this.getName());
		System.out.println("run -end");
	}
}

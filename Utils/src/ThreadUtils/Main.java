package ThreadUtils;

public class Main {
	public static void main(String []args) throws InterruptedException{
		Thread thrad = new Thread(){
			public void run(){
				System.out.println("Hello from new thread");
			}
		};
		thrad.start();
		Thread.yield();
		//thrad.sleep(50);
		System.out.println("Hello for main thrad");
		thrad.join();
	}
}

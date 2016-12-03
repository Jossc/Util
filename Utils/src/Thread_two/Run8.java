package Thread_two;

public class Run8 {
	public static void main(String []args){
		try {
			Thread8 th = new Thread8();
			th.start();
			Thread.sleep(2000);
			th.interrupt();
		} catch (InterruptedException e) {
			System.out.println("main " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("end");
	}
}

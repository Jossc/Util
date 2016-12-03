package Thread_two;

public class Run9 {
	public static void main(String[] args) {
		try {
			Thread9 tt = new Thread9();
			tt.start();
			Thread.sleep(2000);
			tt.interrupt();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("end");
	}
}

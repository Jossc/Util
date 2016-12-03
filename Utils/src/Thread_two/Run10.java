package Thread_two;

public class Run10 {
	public static void main(String []args){
		try {
			Thread10 tt = new Thread10();
			tt.start();
			Thread.sleep(200);
			tt.interrupt();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("end");
	}
}

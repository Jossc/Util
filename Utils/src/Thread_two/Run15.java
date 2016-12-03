package Thread_two;

public class Run15 {
	public static void main(String []args){
		try {
			Thread16 tt = new Thread16();
			tt.start();
			Thread.sleep(1000);
			tt.suspend();
			System.out.println("ֹͣ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

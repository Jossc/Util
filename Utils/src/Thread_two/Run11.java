package Thread_two;

public class Run11 {
	public static void main(String []args){
		Thread11 tt = new Thread11();
		tt.start();
		tt.interrupt();
		System.out.println("end");
	}
}

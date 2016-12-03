package Thread_two;

public class Run14 {
	public static void main(String []args){
		try {
			Thread14 tt = new Thread14();
			tt.start();
			Thread.sleep(5000);
			//A
			tt.suspend();
			System.out.println("A=" + System.currentTimeMillis()
			+":  i :"+ tt.getI());
			Thread.sleep(5000);
			System.out.println("A=" + System.currentTimeMillis()
			+":  i :"+ tt.getI());
			//B
			tt.resume();
			System.out.println("B=" + System.currentTimeMillis()
			+":  i :"+ tt.getI());
			Thread.sleep(5000);
			System.out.println("B=" + System.currentTimeMillis()
			+":  i :"+ tt.getI());
			
			//C
			tt.suspend();
			System.out.println("C=" + System.currentTimeMillis()
			+":  i :"+ tt.getI());
			Thread.sleep(5000);
			System.out.println("C=" + System.currentTimeMillis()
			+":  i :"+ tt.getI());
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}

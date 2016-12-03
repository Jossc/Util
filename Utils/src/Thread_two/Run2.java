package Thread_two;

public class Run2 {
	public static void main(String []args){
		Thread2 t = new Thread2();
		Thread d = new Thread(t);
		d.start();
	}
}

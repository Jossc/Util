package Thread_two;

public class Run3 {
	public static void main(String []args){
		Thread3 t = new Thread3();
		Thread t1 = new Thread(t);
		t1.setName("CC");
		t1.start();
	}
}

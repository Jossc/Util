package Thread_two;

public class Run1 {
	public 	static void main(String []args){
		Thread1 r = new Thread1();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		Thread t4 = new Thread(r);
		Thread t5 = new Thread(r);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}	

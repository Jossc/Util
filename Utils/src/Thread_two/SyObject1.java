package Thread_two;

public class SyObject1 {
	synchronized public void printStirng(){
		System.out.println("begin");
		if(Thread.currentThread().getName()
				.equals("a")){
			System.out.println("a �߳� ֹͣ");
			Thread.currentThread().suspend();
		}
	}
}

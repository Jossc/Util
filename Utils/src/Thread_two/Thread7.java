package Thread_two;

public class Thread7 extends Thread{
	public void run(){
		for(int i =0;i<500000;i++){
			System.out.println("i"
					+i);
		}
	}
}

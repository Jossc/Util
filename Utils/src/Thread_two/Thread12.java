package Thread_two;

public class Thread12 extends Thread{
	private SyObject object;
	public Thread12(SyObject object){
		super();
		this.object = object;
	}
	public void run(){
		object.printString("c", "ccc");
	}
}

package Thread_two;

public class Run5  {
	public static void main(String []args){
		Thread5 t = new Thread5();
		Thread t1 = new Thread(t);
		System.out.println("--------------");
		System.out.println("is Alive" +t1.isAlive());
		t1.setName("CCCC");
		t1.start();
		System.out.println(t1.isAlive());
		int i = 	t1.activeCount();
		System.out.println(i);
		System.out.println(t1.getId());
	}
}

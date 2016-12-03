package Thread_two;
/**
 * isAlive()
 * 判断当前线程是否活动
 * @author JossC
 *
 */
public class Run4 {
	public static void main(String []args) throws InterruptedException{
		Thread4 tt = new Thread4();
		System.out.println("is Alive()"+ tt.isAlive());
		tt.start();
		Thread.sleep(1000);
		System.out.println("is Alive()"+ tt.isAlive());
	}
}

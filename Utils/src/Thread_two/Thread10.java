package Thread_two;
/**
 * ÏÈË¯Ãß£¬ÔÚÍ£Ö¹
 * @author JossC
 *
 */
public class Thread10 extends Thread {
	public void run(){
		try {	
			System.out.println("run begin");
			Thread.sleep(200000);
			System.out.println("run end");
		} catch (InterruptedException e) {
			System.out.println("Í»È»Í£Ö¹");
			e.printStackTrace();
		}
	}
}

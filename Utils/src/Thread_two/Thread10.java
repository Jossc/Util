package Thread_two;
/**
 * ��˯�ߣ���ֹͣ
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
			System.out.println("ͻȻֹͣ");
			e.printStackTrace();
		}
	}
}

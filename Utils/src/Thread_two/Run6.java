package Thread_two;
/**
 * ��û��ֹͣ�߳�
 * @author JossC
 *
 */
public class Run6 {
	public static void main(String[] args) {
		Thread6 t = new Thread6();
		try {
			Thread tt = new Thread(t);
			tt.start();
			Thread.sleep(1000);
			tt.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

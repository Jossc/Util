package Thread_two;
/**
 * ��ֹͣ��Ȼ����˯��
 * @author JossC
 *
 */
public class Thread11 extends Thread{
	public void run() {
		try {
			for(int i=0;i<100000;i++){
				System.out.println("i="+(i+1));
			}
			System.out.println("run begin");
			Thread.sleep(200000);
			System.out.println("run end");	
		} catch (Exception e) {
			System.out.println("��ֹͣ��Ȼ������˯��");
			System.out.println(e.getMessage());
		}
	}
}

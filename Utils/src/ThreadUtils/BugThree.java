package ThreadUtils;
/**
 * һֱ����
 * 
 * ���������
 * 	1.��ֹjvm
 *  2.�ȴ��׳��쳣
 * @author JossC
 *
 */
public class BugThree {
	public static void main(String []args) throws InterruptedException{
		final Object o1 = new Object();
		final Object o2 = new Object();
		
		Thread t1 = new Thread(){
			public void  run(){
				try {
					synchronized(o1){
						Thread.sleep(1000);
						synchronized (o2) {
							System.out.println("ֻ�ǲ���");
						}
					}
				} catch (Exception e) {
					System.out.println("the thread one ");
					System.out.println(e.getMessage());
				}
			}
		};
		Thread t2 = new Thread(){
			public void run(){
				try {
					synchronized (o2) {
						Thread.sleep(1000);
						synchronized(o1){
							System.out.println("�߳�2");
						}
					}
				} catch (Exception e) {
					System.out.println("the thread two");
					System.out.println(e.getMessage()+"32");
				}
			}
		};
		System.out.println("��ʼִ��");
		t1.start();
		t2.start();
		Thread.sleep(1000);
		t1.interrupt();
		t2.interrupt();
		t1.join();
		t2.join();
	}
}

package Thread_two;
/**
 * return +  interruptֹͣ�߳�
 * @author JossC
 */
public class Thread13 extends Thread{
	public void run(){
		while(true){
			if(this.isInterrupted()){
				System.out.println("���߳�ֹͣ");
				return;
			}
			System.out.println("timer="+System.currentTimeMillis());
		}
	}
}

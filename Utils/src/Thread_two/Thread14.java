package Thread_two;
/**
 * ��ͣ�߳�
 * @author JossC
 *
 */
public class Thread14 extends Thread{
	private long i = 0;

	public long getI() {
		return i;
	}
	public void setI(long i) {
		this.i = i;
	}
	public void run(){
		while(true){
			i++;
		}
	}
}

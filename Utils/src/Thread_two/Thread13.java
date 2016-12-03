package Thread_two;
/**
 * return +  interrupt停止线程
 * @author JossC
 */
public class Thread13 extends Thread{
	public void run(){
		while(true){
			if(this.isInterrupted()){
				System.out.println("此线程停止");
				return;
			}
			System.out.println("timer="+System.currentTimeMillis());
		}
	}
}

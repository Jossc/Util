package Thread_two;
/**
 * 抛出异常直接打断线程
 * @author JossC
 *
 */
public class Thread9 extends Thread{
	public void run(){
		try {
			for(int i=0;i<500000;i++){
				if(this.isInterrupted()){
					System.out.println("已经被中止");
					throw new InterruptedException("Stop");
				}
				System.out.println("i"+(i+1));
			}
			System.err.println("1111111111");
		} catch (Exception e) {
		//	System.out.println("Stop");
			System.out.println(e.getMessage());
		}
	}
}

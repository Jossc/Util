package Thread_two;
/**
 * return +  interruptÍ£Ö¹Ïß³Ì
 * @author JossC
 *
 */
public class Run13 {
	public static void main(String []args){
		try {
			Thread13 tt = new Thread13();
			tt.start();
			Thread.sleep(1000);
			tt.interrupt();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

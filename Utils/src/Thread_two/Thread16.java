package Thread_two;
/**
 *  public void println(long x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }
   	prinln²úÉúÁËËÀËø
 * @author JossC
 *
 */
public class Thread16 extends Thread{
	private long i = 0;
	public void run(){
		while(true){
			i++;
			System.out.println(i);
		}
	}
}

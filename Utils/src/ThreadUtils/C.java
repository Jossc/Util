package ThreadUtils;
/**
 * Object 
 * wati(); 等待释放锁，别的线程获取数据
 * notif(); 
 * notifall()
 * @author JossC
 *
 */
public class C {
	public static void main(String []args) throws InterruptedException{
			R r = new R();
			Thread t = new Thread(){
				public void run(){
					System.out.println(""+ this.getClass().getName());
				}
			};
			Thread t1 = new Thread(r);
			t.start();
			//t1.start();
			//t.wait(10);
			//t1.notify();
			//t.interrupt();
		   //boolean v =	t.isInterrupted();
		   //System.out.println(v);
	}
}
class R implements Runnable{

	@Override
	public void run() {
		System.out.println("Sometimes the hardest part isn't "
				+ "letting go, but rather, learning to start");
	}
	
}
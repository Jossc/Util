package ThreadUtils;
/**
 * 竞态条件
 * 3种可能：
 * 	1.The meaning of life is:42
 * 	2.I dont konw the anser
 *  3.The meaning of life is:0
 * @author JossC
 *
 */
public class BugOne {
	static boolean anser = false;
	static int answer = 0;
	static Thread t1 = new Thread(){
		public void run(){
			answer = 42;
			anser = true;
		}
	};
	static Thread t2 = new Thread(){
		public void run(){
			if(anser){
				System.out.println("The meaning of life is:"
						+ answer);
			}else{
				System.out.println("I dont konw the anser");
			}
		}
	};
	public static void main(String []args){		
		try {
			t1.start();
			t2.start();
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

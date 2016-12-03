package Thread_two;

public class RunObject {
	final static  SyObject1 object  = new SyObject1();
	public static void main(String []args){
		try {
			Thread tt = new Thread(){
				public void run(){
					object.printStirng();
				}
			};
			tt.setName("a");
			tt.start();
			Thread.sleep(1000);
			Thread ttt = new Thread(){
				public void run(){
					System.out.println("Thread2启动,打印不了 begin");
					System.out.println("printStirng 被tt锁住");
					object.printStirng();
				}
			};
			ttt.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

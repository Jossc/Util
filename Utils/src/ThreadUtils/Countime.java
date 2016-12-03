package ThreadUtils;
/**
 * 竞态条件：
 * 	需要increment 和get方法都需要加锁
 * @author JossC
 *
 */
public class Countime {
	public static void main(String []args) throws InterruptedException{
		class Counter{
			private int count = 0;
			
			/**
			 * 访问三次结果不一样
			 * 11372
			   12525
			   12272
			 */
//			public void increment(){
//				++count;
//			}
			/**
			 * 加锁,还有bug
			 * 
			 */
			public synchronized void increment(){
				++count;
			}
			/**
			 * getCoun()也需要加锁
			 * @return
			 */
			public  int getCoun(){
				return count;
			}
		}
		final Counter counter = new Counter();
		class CountiThread extends Thread{
			public void run(){
				for(int x=0;x<10000;++x){
					counter.increment();
				}
			}
		}
		CountiThread t1 = new CountiThread();
		CountiThread t = new CountiThread();
		
			t.start();
			t1.start();
			t.join();
			t1.join();
			System.out.println(counter.getCoun());
	}
}

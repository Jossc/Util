package ThreadUtils;
/**
 * ��̬������
 * 	��Ҫincrement ��get��������Ҫ����
 * @author JossC
 *
 */
public class Countime {
	public static void main(String []args) throws InterruptedException{
		class Counter{
			private int count = 0;
			
			/**
			 * �������ν����һ��
			 * 11372
			   12525
			   12272
			 */
//			public void increment(){
//				++count;
//			}
			/**
			 * ����,����bug
			 * 
			 */
			public synchronized void increment(){
				++count;
			}
			/**
			 * getCoun()Ҳ��Ҫ����
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

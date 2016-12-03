package Thread_two;
/**
 * interrupted：返回boolean值，第一用后，在同一个代码块中调用的话
 * 会抹除第一调用的数据
 * isInterrupted：返回boolean值，不会抹除上一次调用的数据
 * @author JossC
 *
 */
public class Run7 {
	public static void main(String []args){
//		Thread.currentThread().interrupt();
//		System.out.println("是否停止="+Thread.currentThread().interrupted());
//		System.out.println("是否停止2="+Thread.currentThread().isInterrupted());
		new Run7().Test();
	}
	public void Test(){
		Thread7 t7 = new Thread7();
		try {
			t7.start();
			Thread.sleep(3000);
			t7.interrupt();
			System.err.println("是否停止="+t7.isInterrupted());
			System.err.println("是否停止2="+t7.isInterrupted());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("end");
	}
}

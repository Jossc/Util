package Thread_two;
/**
 * interrupted������booleanֵ����һ�ú���ͬһ��������е��õĻ�
 * ��Ĩ����һ���õ�����
 * isInterrupted������booleanֵ������Ĩ����һ�ε��õ�����
 * @author JossC
 *
 */
public class Run7 {
	public static void main(String []args){
//		Thread.currentThread().interrupt();
//		System.out.println("�Ƿ�ֹͣ="+Thread.currentThread().interrupted());
//		System.out.println("�Ƿ�ֹͣ2="+Thread.currentThread().isInterrupted());
		new Run7().Test();
	}
	public void Test(){
		Thread7 t7 = new Thread7();
		try {
			t7.start();
			Thread.sleep(3000);
			t7.interrupt();
			System.err.println("�Ƿ�ֹͣ="+t7.isInterrupted());
			System.err.println("�Ƿ�ֹͣ2="+t7.isInterrupted());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("end");
	}
}

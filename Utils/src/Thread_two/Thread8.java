package Thread_two;

public class Thread8  extends Thread{
	public void run(){
		for(int i=0;i<500000;i++){
			if(this.interrupted()){
				System.out.println("�Ѿ�ֹͣ");
				break;
			}
			System.out.println("i=" + (i+1));
		}
		System.out.println("��ʵ��û��ֹͣ");
	}
}

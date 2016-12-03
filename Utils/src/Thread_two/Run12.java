package Thread_two;

public class Run12 {
	public static void main(String []args){
		
		try {
			SyObject ob = new SyObject();
			Thread12 tt= new Thread12(ob);
			tt.start();
			Thread.sleep(500);
			System.out.println(ob.getPassword()+
					":" + ob.getUsername());
			tt.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

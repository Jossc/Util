package Test;

import java.awt.Event;

public class TTT {
	public static void main(String []args){
		int e = Event.ENTER;
		System.out.println(e);
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("11111111");
			}
		};
		
		for(int i=0;i<10;i++){
			runnable.run();
		}
	}
}

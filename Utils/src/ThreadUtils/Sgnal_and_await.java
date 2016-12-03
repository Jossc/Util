package ThreadUtils;
/**
 * Sgnal_and_await
 * 
 * @author JossC
 *
 */
public class Sgnal_and_await {
	public static void main(String []args){
		A a = new A();
		B b = new B();
		new Thread(a).start();
		new Thread(b).start();
	}
}

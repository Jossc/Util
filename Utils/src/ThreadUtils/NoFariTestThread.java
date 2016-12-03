package ThreadUtils;

public class NoFariTestThread implements Runnable{
	private D d ;
	public NoFariTestThread(D d){
		this.d = d;
	}
	@Override
	public void run() {
		D.lock.lock();
		try {
			d.setN(d.getN()+1);
			System.out.println(Thread.currentThread().getName()+
					"nofar lock "+d.getN());
		} finally {
			D.lock.unlock();
		}
	}
}

package ThreadUtils;
/**
 * ¹«Æ½Ëø
 * @author JossC
 *
 */
public class FariTestThread implements Runnable{
	private D d;	public FariTestThread(D d){
		this.d = d;
	}
	@Override
	public void run() {
		D.fariLock.lock();
		try {
			d.setN(d.getN()+1);
			System.out.println(Thread.currentThread().getName()
					+"fairlock ===== " +d.getN()+" ----"
					+D.fariLock.getHoldCount()+"queuelength="
					+D.fariLock.getQueueLength());
		} finally {
			D.fariLock.unlock();
		}
	}
}

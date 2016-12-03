package ThreadUtils;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class Counter implements Runnable{
	private BlockingQueue<Page> que;
	private Map<String,Integer> counts;
	public Counter(BlockingQueue<Page> que,
			Map<String,Integer> counts){
		this.que = que;
		this.counts = counts;
	}
	@Override
	public void run() {
		try {
			while(true){
				Page page = que.take();
				if(page.isPoisonPill()){
					break;
				}
				Iterable<String> words;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

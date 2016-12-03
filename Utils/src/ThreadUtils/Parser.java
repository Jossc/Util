package ThreadUtils;

import java.util.concurrent.BlockingDeque;

public class Parser implements Runnable {
	private BlockingDeque<Page> que;
	
	public Parser(BlockingDeque<Page> que) {
		this.que = que;
	}
	@Override
	public void run() {
		try {
			Iterable<Page> pages = new Pages(100000,"enwiki.xml");
			for(Page page:pages){
				que.put(page);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

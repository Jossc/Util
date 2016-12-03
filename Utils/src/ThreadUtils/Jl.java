package ThreadUtils;
import java.util.concurrent.locks.ReentrantLock;
/**
 * 交替锁
 * 全局正向获取锁
 * insert,size 
 * 不会违背按照全局固定的顺序获取多把锁头
 * inset,size在某一时间只有一把锁
 * 
 * @author JossC
 *
 */
public class Jl {
	private class Node{
		int value ;
		Node prev;
		Node next;
		ReentrantLock lock = new ReentrantLock();
		Node(){
			
		}
		Node(int value ,Node prev,Node next){
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}
	private final Node head;
	private final Node tail;
	public Jl() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
	}
	/**
	 * 插入锁
	 * 遍历链表找到小于新插入节点的值，
	 * 并在这其之前插入
	 * value 是插入的位置
	 */
	public void insert(int value){
		Node current = head;
		System.out.println("current.lock：开始锁");
		//锁住表头,保证表是有序的
		current.lock.lock();
		Node next = current.next;
		try {
			while(true){
				System.out.println(" next.lock： 开始锁");
				next.lock.lock();
				try {
					/**
					 * 构造新的节点
					 */
					if(next == tail || next.value<value){
						Node node = new Node(value,current,next);
						next.prev = node;
						current.next = node;
						return;
					}
				} finally {
					System.out.println("current.lock：释放锁");
					//解锁当前节点
					current.lock.unlock();
				}
				current = next;
				next = current.next;
			}
		} finally{
			System.out.println(" next.lock： 释放锁");
			next.lock.unlock();
		}
	}
	/**
	 * 倒序遍历链表结算节点
	 * @return
	 */
	public int size(){
		Node current = tail;
		int count = 0;
		while(current.prev!=head){
			ReentrantLock lock = current.lock;
			lock.lock();
			try {
				++count;
				current = current.prev;
			} finally {
				lock.unlock();
			}
			System.out.println(count);
		}
		return count;
	}
	
	
	
	public static void main(String []args){
		Jl j = new Jl();
		j.insert(0);
		int i = j.size();
		System.out.println(i);
	}
}

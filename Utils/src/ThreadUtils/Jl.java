package ThreadUtils;
import java.util.concurrent.locks.ReentrantLock;
/**
 * ������
 * ȫ�������ȡ��
 * insert,size 
 * ����Υ������ȫ�̶ֹ���˳���ȡ�����ͷ
 * inset,size��ĳһʱ��ֻ��һ����
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
	 * ������
	 * ���������ҵ�С���²���ڵ��ֵ��
	 * ��������֮ǰ����
	 * value �ǲ����λ��
	 */
	public void insert(int value){
		Node current = head;
		System.out.println("current.lock����ʼ��");
		//��ס��ͷ,��֤���������
		current.lock.lock();
		Node next = current.next;
		try {
			while(true){
				System.out.println(" next.lock�� ��ʼ��");
				next.lock.lock();
				try {
					/**
					 * �����µĽڵ�
					 */
					if(next == tail || next.value<value){
						Node node = new Node(value,current,next);
						next.prev = node;
						current.next = node;
						return;
					}
				} finally {
					System.out.println("current.lock���ͷ���");
					//������ǰ�ڵ�
					current.lock.unlock();
				}
				current = next;
				next = current.next;
			}
		} finally{
			System.out.println(" next.lock�� �ͷ���");
			next.lock.unlock();
		}
	}
	/**
	 * ��������������ڵ�
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

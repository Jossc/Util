package ObjectUtils;
/**
 * dentityHashCode��hashCode�ą^�e
 * 
 * identityHashCode�Ǹ��ݶ���ĵ�ַ����õ��ģ������κ�������ͬ�Ķ����
 * identityHashCodeֵ���ǲ����
 * @author JossC
 *
 */
public class identityHashCodeTest {
	public static void main(String [] args){
		String s = new String("CC");
		String s1 = new String("CC");
		
		String ss = "cc";
		String s2 = "cc";
		System.out.println("HashCode :" +s.hashCode());
		System.out.println("HasCode1 :" +s1.hashCode());
		System.out.println("identityHashCode :" + System.identityHashCode(ss));
		System.out.println("identityHashCode1:  " + System.identityHashCode(s2));
	}
}

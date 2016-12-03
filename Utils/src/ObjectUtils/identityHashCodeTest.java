package ObjectUtils;
/**
 * dentityHashCode和hashCode的區別
 * 
 * identityHashCode是根据对象的地址计算得到的，所以任何两个不同的对象的
 * identityHashCode值总是不相等
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

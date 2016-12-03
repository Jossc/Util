package ThreadUtils;

public class Chopstick {
	int i = 0 ;
	
	@Override
	public String toString() {
		return "Chopstick [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]" +"Hello";
	}
	//synchronized
	public  int  getID() {
		i++;
		System.out.println(i);
		return	i;
	}
	
}

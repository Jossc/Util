package Thread_two;

/**
 * Created by JossC on 2016/11/18.
 */
public class Thread17 extends  Thread {
    @Override
    public void run() {
    	System.out.println("1111");
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for(int i =0;i<5000;i++){
        	System.out.println(i);
            count = count+(i+1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("鐢ㄦ椂锛�"+ (endTime-beginTime));
    }


}

package Test;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by JossC on 2016/11/25.
 */
public class TT {
    public static void main(String []args){
        Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
        String[] newArray={"上海","天津","广州","杭州","辽宁","南京","武汉","北京","厦门","内蒙"};
        Arrays.sort(newArray,com);
        for(String i:newArray){
            System.out.print(i+"  ");
        }
    }
}

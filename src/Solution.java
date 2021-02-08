import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rambo
 * @date 2020-09-16 20:17
 */
public class Solution {


    public static void main(String[] args){
        String s1 = "466";
        String s2 = "123";
        System.out.println(s2.compareTo(s1));
        String[] s = new String[]{"5","4","3","2"};
        Arrays.sort(s, (a,b) -> a.compareTo(b));
        for(String str: s){
            System.out.println(str);
        }
    }
}

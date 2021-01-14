import java.util.HashMap;
import java.util.Map;

/**
 * @author Rambo
 * @date 2020-09-16 20:17
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[1];

        return result;
    }
    public static void main(String[] args){
        StringBuffer str = new StringBuffer("We are happy");
        int p = str.length() - 1;
        for(int i = 0; i <= p; ++i){
            if(str.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        int q = str.length() - 1;
        while(p >= 0){
            char old = str.charAt(p--);
            if(old == ' ') {
                str.setCharAt(q--, '0');
                str.setCharAt(q--, '2');
                str.setCharAt(q--, '%');
            } else {
                str.setCharAt(q--, old);
            }
        }
        System.out.println(str.toString());
    }
}

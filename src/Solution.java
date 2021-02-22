import java.util.*;

/**
 * @author Rambo
 * @date 2020-09-16 20:17
 */
public class Solution {
    public static int StrToInt(String str) {
        if(str.length() < 1) return 0;

        long sum = 0;
        boolean isPositive = str.charAt(0) != '-';
        for(int i = 0; i < str.length(); ++i){
            char ch = str.charAt(i);
            if(i == 0 && (ch == '+' || ch == '-'))continue;
            int cur = ch - 48;
            if(cur >= 0 && cur <= 9){
                sum = sum * 10 + cur;
            } else{
                return 0;
            }
            if((isPositive && sum > Integer.MAX_VALUE)) return 0;
            if((!isPositive && sum > -1 * (long)Integer.MIN_VALUE)) {
                System.out.println("HHH:"+ sum + " " + (-1 * (long)Integer.MIN_VALUE));
                return 0;
            }
        }
        return isPositive? (int)sum : -1 * (int)sum;
    }

    public static void main(String[] args){
        System.out.println(StrToInt("-123")+ " " +(Integer.MIN_VALUE * -1));
    }
}

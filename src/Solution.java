import java.util.*;

/**
 * @author Rambo
 * @date 2020-09-16 20:17
 */
public class Solution {
    public static boolean match(char[] str, char[] pattern)
    {
        return isMatch(new String(str),new String (pattern));
    }

    public static boolean isMatch(String s, String p){
        if(p.length() == 0) return s.length() == 0;
        if(p.charAt(1) == '*'){
            boolean isFirstEqual = (s.charAt(0) == p.charAt(0)) || ('.' == p.charAt(0));
            return isMatch(s,p.substring(1)) || !s.isEmpty() && isFirstEqual && isMatch(s.substring(1),p);
        }else{
            boolean isFirstEqual = (s.charAt(0) == p.charAt(0)) || ('.' == p.charAt(0));
            return !s.isEmpty() && isFirstEqual && isMatch(s.substring(1),p.substring(1));
        }
    }

    public static void main(String[] args){
        int a = 10;
        System.out.println(a & 0x80000000);
    }
}

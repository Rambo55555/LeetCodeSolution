import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Rambo
 * @date 2020-09-16 20:17
 */
public class Solution {
    public static String removeDuplicateLetters(String s) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); ++i){
            if(stack.contains(s.charAt(i))){
                continue;
            }
            while(!stack.isEmpty() && s.charAt(i) < stack.peek() && s.indexOf(stack.peek(), i) > 0){
                stack.pop();
            }
            stack.push(s.charAt(i));
        }
        char[] res = new char[stack.size()];
        for(int i = 0; i < stack.size(); i++)
            res[i] = stack.get(i);

        return new String(res);
    }


    public static void main(String[] args){
        System.out.println(removeDuplicateLetters("bcbac"));
    }
}

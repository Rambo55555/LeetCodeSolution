import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rambo
 * @date 2020-09-16 20:17
 */
public class Solution {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int p = 0, q = array.length - 1;
        ArrayList<Integer> resultList = new ArrayList();
        //int[] resultList = new int[2];
        int mul = Integer.MAX_VALUE;
        while(p < q) {
            if (array[p] + array[q] == sum) {
                if (p * q < mul){
                    mul = p * q;
                    resultList.clear();
                    resultList.add(array[p++]);
                    resultList.add(array[q--]);
//                     resultList[0] = array[p++];
//                     resultList[1] = array[q--];
                }
            } else if (array[p] + array[q] < sum) {
                p++;
            } else{
                q--;
            }
        }
        return resultList;
    }
    public static void main(String[] args){
        int [] array = new int[]{1,2,4,7,11,17};
        ArrayList<Integer> result = FindNumbersWithSum(array,13);
        for (int i:result
             ) {
            System.out.println(i);
        }

    }
}

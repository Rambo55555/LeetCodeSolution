import java.util.*;

/**
 * @author Rambo
 * @date 2020-09-16 20:17
 */
public class Solution {
    //private static int[] tmp;
    public static void mergeSort(int [] nums, int l, int r){
        if(l < r){
            int mid = (l + r) / 2;
            mergeSort(nums, l, mid);
            mergeSort(nums, mid + 1, r);
            merge(nums, l, mid, r);
        }
    }

    public static void merge(int[] nums, int l, int m, int r){
        int[] tmp = new int[nums.length];
        int i = l, j = m + 1, k = l;
        while(i <= m && j <= r){
            if(nums[i] < nums[j]){
                tmp[k++] = nums[i++];
            } else{
                tmp[k++] = nums[j++];
            }
        }
        while(j <= r){
            tmp[k++] = nums[j++];
        }
        while(i <= m){
            tmp[k++] = nums[i++];
        }
        for(k= l; k <= r; ++k){
            nums[k] = tmp[k];
        }
    }
    public static void main(String[] args){
        int [] array = new int[]{1};
        //tmp = new int[array.length];
        mergeSort(array, 0, array.length-1);
        for (int i: array
             ) {
            System.out.print(i);
        }

    }
}

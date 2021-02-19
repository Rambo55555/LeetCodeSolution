import java.util.*;

/**
 * @author Rambo
 * @date 2020-09-16 20:17
 */
public class Solution {
    public static void findKth(int nums[], int k) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int p = partion(nums, i, j);
            if(p == k) break;
            else if(p < k) {
                i = p + 1;
            }else {
                j = p - 1;
            }
        }
    }
    public static int partion(int nums[], int l, int h) {
        int p = nums[l];
        int i = l, j = h+1;
        while(true) {
            while(i != h && nums[++i] < p);
            while(j != l && nums[--j] > p);
            if(i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void quickSort(int[] nums, int l, int h) {
        if(l >= h) return;
        int p = partion(nums, l, h);
        quickSort(nums, l, p-1);
        quickSort(nums, p+1, h);
    }

    public static void main(String[] args){
        int [] input = {4,3,2,1,8,10,23,7,3,1,8,34};
        quickSort(input, 0, input.length-1);
        for(int i = 0; i< input.length; ++i) {
            System.out.println(input[i]);
        }
    }
}

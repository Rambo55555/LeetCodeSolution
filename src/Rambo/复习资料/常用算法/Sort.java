package Rambo.复习资料.常用算法;

/**
 * @author Rambo
 * @date 2021-02-19 20:24
 */
public class Sort {
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
}

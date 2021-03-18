package Rambo.复习资料.常用算法.排序;

public class InsertSort extends Sort{
    public static void sort(int[] nums, int start, int end) {
        int n = nums.length;
        for(int i = 1; i < n; ++i) {
            int k;
            for(k = i; k-1 >= 0 && nums[k] < nums[k-1]; k--) {
                swap(nums, k-1, k);
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {234,6,5,2,6,3,8,3,9,85,43,21,20,24,};
        print(nums);
        sort(nums, 0, nums.length-1);
        print(nums);
    }
}

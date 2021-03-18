package Rambo.复习资料.常用算法.排序;

public class ShellSort extends Sort{
    public static void sort(int[] nums) {
        int n = nums.length;
        for(int j = n / 2; j > 0; j/=2) {
            for(int i = j; i < n; ++i) {
                int k;
                for(k = i; k-j >= 0 && nums[k] < nums[k-j]; k-=j) {
                    swap(nums, k-j, k);
                }
            }
        }
    }

    public static void main(String[] args){
        int[] nums = {234,6,5,2,6,3,8,3,9,85,43,21,20,24,};
        print(nums);
        sort(nums);
        print(nums);
    }}

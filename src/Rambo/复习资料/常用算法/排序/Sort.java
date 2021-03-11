package Rambo.复习资料.常用算法.排序;

public class Sort {
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void print(int[] nums) {
        for(int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        System.out.println("hhh");
    }

}

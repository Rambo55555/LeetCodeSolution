package Rambo.复习资料.常用算法.排序;

import java.util.Stack;

public class QuickSort extends Sort{

    public static void sort(int[] nums, int start, int end) {
        if(start >= end) return;
        int p = partition(nums, start, end);
        sort(nums, start, p-1);
        sort(nums, p+1, end);
    }
    //非递归
    public static void non_rec_sort(int[] nums, int start, int end) {
        Stack<Integer> stack = new Stack<>();
        if(start < end) {
            stack.push(end);
            stack.push(start);
            while(!stack.isEmpty()) {
                int i = stack.pop();
                int j = stack.pop();
                int p = partition(nums, i, j);
                if(i < p - 1) {
                    stack.push(p-1);
                    stack.push(i);
                }
                if(j > p + 1) {
                    stack.push(j);
                    stack.push(p+1);
                }
            }
        }
    }

    public static int partition(int[] nums, int start, int end){
//        int pivot = start;
//        int j = start + 1;
//        for(int i = j; i <= end; ++i) {
//            if(nums[i] < nums[pivot]){
//                swap(nums, j++, i);
//            }
//        }
//        swap(nums, j-1, pivot);
//        return j-1;
        int pivot = nums[start];
        int i = start, j = end + 1;
        while(true){
            while(i != end && nums[++i] < pivot);
            while(j != start && nums[--j] > pivot);
            if(i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }
    //三相切分快速排序
    public static void threeWaySort(int[] nums, int start, int end) {
        if(start >= end) return;
        int pivot = nums[start];
        int l = start, i = start + 1, h = end;
        while(i <= h) {
            if(nums[i] < pivot) {
                swap(nums, l++, i++);
            } else if(nums[i] > pivot) {
                swap(nums, h--, i);
            } else {
                i++;
            }
        }
        threeWaySort(nums, start, l-1);
        threeWaySort(nums, h+1, end);
    }

    //根据三向切分代码改的
    public static void mySort(int[] nums, int start, int end) {
        if(start >= end) return;
        int pivot = nums[start];
        int l = start, i = start + 1, h = end;
        while(i <= h) {
            if(nums[i] < pivot) {
                swap(nums, l++, i++);
            } else {
                swap(nums, h--, i);
            }
        }
        mySort(nums, start, l-1);
        mySort(nums, h+1, end);
    }

    public static void main(String[] args){
        int[] nums = {4,6,5,2,6,3,8,3,9,85,43,21};
        print(nums);
        mySort(nums, 0, nums.length-1);
        print(nums);
    }

}


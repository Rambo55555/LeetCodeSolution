// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;

import java.util.*;


public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int end = nums.length - 1;
        for(int i = end / 2; i >= 0; --i) {
            maxHeapify(nums, i, end);
        }
        for(int i = end; i > nums.length - k; --i) {
            swap(nums, 0, i);
            end--;
            maxHeapify(nums, 0, end);
        }
        return nums[0];
    }

    public void maxHeapify(int[] nums, int i, int end) {
        while(2 * i + 1 <= end) {
            int l = 2 * i + 1;
            int r = l + 1;
            int large;
            if(l <= end && nums[l] > nums[i]) {
                large = l;
            } else {
                large = i;
            }
            if(r <= end && nums[r] > nums[large]) {
                large = r;
            }
            if( large != i) {
                swap(nums, large, i);
                i = large;
            } else {
                break;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static double computeSqrt(double presision) {
        double x = 1;
        while(Math.abs(2 - x * x) > presision) {
            x = x / 2.0 + 1.0 / x;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,2,4,5,6};
        Solution solution = new Solution();
        List<Integer> list = new LinkedList<>();


        System.out.println(computeSqrt(0.0001));
    }


//    public int solve (int n, int k) {
//        // write code here
//        // write code here
//        int[][] dp = new int[n+1][k+1];
//        for (int i = 1; i <= n; ++i) {
//            dp[i][0] = 0;
//            for(int j = 1; j <= k; ++j) {
//                dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + 1;
//                if(dp[i][j] >= n) {
//                    return i;
//                }
//            }
//        }
//        return n;
//    }
}
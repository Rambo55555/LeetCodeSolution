package Rambo.复习资料.常用算法.排序;

public class MergeSort extends Sort {
   public static void sort(int[] nums) {
       int[] aux = new int[nums.length];
       sort(nums, aux, 0, nums.length-1);
   }

   public static void sort(int[] nums, int[] aux, int start, int end) {
       if(start < end) {
//           int mid = start + (end - start) / 2;
//           sort(nums, aux, start, mid);
//           sort(nums, aux, mid+1, end);
//           merge(nums, aux, start, mid, end);
           int n = nums.length;
           for(int size = 1; size < n; size+=size) {
               for(int l = 0; l < n - size; l+=size*2) {
                   merge(nums, aux, l, l+size-1, Math.min(n-1, l+2*size-1));
               }
           }
       }
   }

   public static void merge(int[] nums, int[] aux, int start, int mid, int end) {
       int i = start, j = mid+1;
       for(int k = start; k <= end; ++k) {
           aux[k] = nums[k];
       }
       for(int k = start; k <= end; ++k) {
           if(i > mid) {
               nums[k] = aux[j++];
           } else if(j > end) {
               nums[k] = aux[i++];
           } else if(aux[i] <= aux[j]) {
               nums[k] = aux[i++];
           } else {
               nums[k] = aux[j++];
           }
       }
   }
    public static void main(String[] args){
        int[] nums = {234,6,5,2,6,3,8,3,9,85,43,21};
        print(nums);
        sort(nums);
        print(nums);
    }
}

//    public static void sort(int[] nums) {
//        int[] aux = new int[nums.length];
//        sort(nums, aux, 0, nums.length-1);
//    }
//
//    public static void sort(int[] nums, int[] aux, int start, int end) {
//        if(start < end) {
////            int mid = start + (end - start) / 2;
////            sort(nums, aux, start, mid);
////            sort(nums, aux,mid+1, end);
////            merge(nums, aux, start, mid, end);
//            int n = nums.length;
//            for(int sz = 1; sz < n; sz+=sz) {
//                for(int lo = 0; lo < n - sz; lo += sz * 2) {
//                    merge(nums, aux, lo, lo+sz-1, Math.min(n-1, lo+2*sz-1));
//                }
//            }
//        }
//    }
//    public static void merge(int[] nums, int[] aux, int start, int mid, int end) {
//        int i = start, j = mid + 1;
//        for(int k = start; k <= end; ++k){
//            aux[k] = nums[k];
//        }
//        for(int k = start; k <= end; ++k) {
//            if(i > mid) {
//                nums[k] = aux[j++];
//            } else if (j > end) {
//                nums[k] = aux[i++];
//            } else if(aux[j] > aux[i]) {
//                nums[k] = aux[i++];
//            } else {
//                nums[k] = aux[j++];
//            }
//        }
//    }

package Rambo.复习资料.常用算法.排序;

public class HeapSort extends Sort{

    public static void sort(int[] nums) {
        int end = nums.length - 1;
        for(int i = (end-1) / 2; i >= 0; --i) {
            maxHeapify(nums, i, end);
        }
        for(int i = end; i >= 1; --i) {
            swap(nums, 0, i);
            end--;
            maxHeapify(nums, 0, end);
        }
    }
    public static void maxHeapify(int[] nums, int i, int end) {
        //这里左孩子要小于end的原因是可能会出现一个节点只有左孩子的情况，如果是2*i+2<=end，就忽略了这个节点。
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
            if(large != i) {
                swap(nums, large, i);
                i = large;
            } else {
                break;
            }

        }
    }


    public static void main(String[] args){
        int[] nums = {234,6,5,2,6,3,8,3,9,85,43,21,20,24,};
        print(nums);
        sort(nums);
        print(nums);
    }

}

//    public static void sort(int[] nums) {
//        int len = nums.length - 1;
//        //建立最大堆
//        for (int i = len / 2; i >= 0; --i) {
//            maxHeapify(nums, i, len);
//        }
//        //将最大元素与数组末尾元素交换，然后重新建堆
//        for (int i = len; i >= 1; --i) {
//            swap(nums, i, 0);
//            len -= 1;
//            maxHeapify(nums, 0, len);
//        }
//    }
//
//
//    //建立最大堆，i为当前要建立最大堆的节点，len为数组长度
//    public static void maxHeapify(int[] nums, int i, int len) {
//        //左孩子节点：2*i + 1， 右孩子节点：2*i + 2
//        for (; (i << 1) + 1 <= len;) {
//            int lson = (i << 1) + 1;
//            int rson = (i << 1) + 2;
//            int large;
//            if (lson <= len && nums[lson] > nums[i]) {
//                large = lson;
//            } else {
//                large = i;
//            }
//            if (rson <= len && nums[rson] > nums[large]) {
//                large = rson;
//            }
//            if (large != i) {
//                swap(nums, i, large);
//                i = large;
//            } else {
//                break;
//            }
//        }
//    }

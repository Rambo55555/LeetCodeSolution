
import java.util.Stack;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxMoney (TreeNode root) {
        // write code here
        if(root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        return is2th(root) + maxMoney(left) + maxMoney(right);
    }

    public int is2th(TreeNode root) {
        if(root == null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        boolean isLeft = false;
        boolean isRight = false;
        if(left != null && left.left == null && left.right == null) {
            isLeft = true;
        }
        if(right != null && right.left == null && right.right == null) {
            isRight = true;
        }
        int result = 0;
        if(isLeft && isRight) {
           result = 5;
        } else if(isLeft || isRight) {
            result = 2;
        }
        System.out.println(result);
        return result;
    }

    public ListNode minusList (ListNode minuendList, ListNode subtrahendList) {
//        long num1 = getInt(minuendList);
//        long num2 = getInt(subtrahendList);
//        System.out.println(num1 + " " + num2);
//        long ans =  num1 - num2;
//        boolean isNegative = num1 - num2 < 0;
//        ListNode dummy = new ListNode(-1);
//        ListNode cur = dummy;
//        while(ans != 0) {
//            long num = ans % 10;
//            if(ans / 10 == 0) {
//                cur.next = new ListNode((int)num);
//            }else {
//                cur.next = new ListNode(Math.abs((int)num));
//            }
//
//            cur = cur.next;
//            ans = ans / 10;
//        }
//        cur = dummy.next;
//        ListNode result = null;
//        while(cur != null) {
//            ListNode next = cur.next;
//            cur.next = result;
//            result = cur;
//            cur = next;
//        }
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        ListNode cur = minuendList;
        while(cur != null) {
            buffer1.append(cur.val);
            cur = cur.next;
        }
        cur = subtrahendList;
        while(cur != null) {
            buffer2.append(cur.val);
            cur = cur.next;
        }
        System.out.println("list1: " + buffer1.toString());
        System.out.println("list2: " + buffer2.toString());
        String s1 = buffer1.toString();
        String s2 = buffer2.toString();
        int len1 = s1.length();
        int len2 = s2.length();
        String resultS = "";
        if(len1 > len2) {
            resultS = subStract(s1,s2);
        } else if(len1 < len2) {
            resultS = subStract(s2,s1);
        } else {
            int compare = s1.compareTo(s2);
            if(compare == 0) return new ListNode(0);
            else if(compare > 0) {
                resultS = resultS = subStract(s1,s2);
            } else {
                resultS = "-" +  subStract(s2,s1);
            }
        }

        int j = 0;
        for(int i = 0; i < resultS.length(); ++i) {
            if(resultS.charAt(i) - '0' == 0) {
                continue;
            }else {
                j = i;
                break;
            }
        }
        resultS = resultS.substring(j);
        System.out.println("result :" + resultS);
        ListNode dummy = new ListNode(-1);
        cur = dummy.next;
        for(int i = 0; i < resultS.length(); ++i) {
            cur = new ListNode(resultS.charAt(i) - '0');
            cur = cur.next;
        }
        return dummy.next;
    }

    public static String subStract(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int max = len1 > len2 ? len1 : len2;
        int brower = 0;
        int res[] = new int[max +1];
        int k = max;
        while(len1 >= 0 || len2 >= 0) {
            int div = 10;
            div += len1>=0?num1.charAt(len1) - '0':0;
            div -= len2>=0?num2.charAt(len2) - '0':0;
            div -= brower;
            res[k--] = div % 10;
            brower = div / 10 == 0 ? 1 : 0;
            len2--;
            len1--;
        }
        int i = 0;
        if(res[i] == 0) i++;
        StringBuffer s = new StringBuffer();
        for(int j = i; j <= max; j++) s.append(res[j]);
        return s.toString();
    }

    public ListNode reverseList(ListNode cur) {
        ListNode result = null;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = result;
            result = cur;
            cur = next;
        }
        return result;
    }

    public long getInt(ListNode node) {
        long result = 0;
        boolean isNegative = false;
        while(node != null) {
            if(node.val < 0) isNegative = true;
            result = 10 * result + Math.abs(node.val);
            node = node.next;
        }
        return isNegative ? -result : result;
    }
    public void printList(ListNode node) {
        ListNode head = node;
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public int maxWater (int[] height) {
        // write code here
//        int n = height.length;
//        int result = 0;
//        if (n == 0) return 0;
//        int left = 0, right = n - 1;
//        int leftMax = height[left], rightMax = height[right];
//        while(left < right) {
//            if(height[left] < height[right]) {
//                if(height[left] < leftMax) {
//                    result += leftMax - height[left];
//                } else {
//                    leftMax = height[left];
//                }
//                left++;
//            } else {
//                if(height[right] < rightMax) {
//                    result += rightMax - height[right];
//                } else {
//                    rightMax = height[right];
//                }
//                right--;
//            }
//        }
        int n = height.length;
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0, max = 0;
        for(int i = 0;  i < n; ++i) {
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]) {
                int left = stack.pop();
                if(stack.isEmpty()) break;
                int d = i - stack.peek() - 1;
                result += d * ((Math.min(height[i], height[stack.peek()])) - height[left]);
            }
            if(stack.isEmpty()) {
                max = Math.max(max, result);
                result = 0;
            }
            stack.push(i);
        }
        return max;
    }
    public static void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        // 1. 水平翻转
        for (int i = 0; i < n / 2; ++i) {
            for(int j = 0; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        // 2. 对角线翻转
        for (int i = 0; i < n; ++i) {
            for(int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    public static void heapSort(int[] nums) {
        // 1. 建堆
        int end = nums.length - 1;
        for(int i = end / 2; i >= 0; --i) {
            heapify(nums, i, end);
        }
        // 2. 交换
        for(int i = end; i >= 0; --i) {
            swap(nums, 0, end);
            heapify(nums, 0, --end);
        }
    }
    public static void heapify(int[] nums, int i, int end) {
        // i 为当前节点，得到其与左右字节点的最大值
        while(2 * i + 1 < end) {
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
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void printNums(int[] nums) {
        for(int i = 0; i < nums.length; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static int minReverse(String str) {
        char[] chs = str.toCharArray();
        char[] temp = new char[chs.length];
        for(int i = 0; i < chs.length; ++i) {
            temp[i] = '0';
        }
        int index = 0, count = 0;
        for(int i = 0; i < chs.length; ++i) {
            if(chs[i] != temp[i]) {
                int j = i;
                while(j < chs.length) {
                    temp[j] = temp[j] == '1' ? '0' : '1';
                    j++;
                }
                count++;
            } else {
                continue;
            }
        }
        return count;
    }
    public int find(int[] nums, int key) {
        int start = 0, end = nums.length - 1, mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if(nums[mid] > key) {
                end = mid - 1;
            } else if(nums[mid] < key) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int strcmp(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int flag = 0;
        int n = str1.length;
        if(str1.length > str2.length) {
            n = str2.length;
        }
        for(int i = 0; i < n; ++i) {
            if(str1[i] == str2[i]) continue;
            else if(str1[i] < str2[i]) {
                flag = -1; break;
            } else if(str1[i] > str2[i]) {
                flag = 1; break;
            }
        }
        if(flag == 0 && (str1.length < str2.length)) flag = -1;
        if(flag == 0 && (str1.length > str2.length)) flag = 1;
        return flag;
    }

    public static int longestCommonString(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int m = str1.length, n = str2.length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; ++i) {
            char ch1 = str1[i-1];
            for (int j = 1; j <= n; ++j) {
                char ch2 = str2[j-1];
                if(ch1 == ch2) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        while(m != 0 && n != 0) {
            if (str1[m-1] == str2[n-1]) {
                sb.append(str1[m-1]);
                m--;n--;
            } else {
                if (dp[m-1][n] < dp[m][n-1]) {
                    n--;
                } else {
                    m--;
                }
            }
        }
        System.out.println(sb.reverse().toString());
        m = str1.length;
        n = str2.length;
        return dp[m][n];
    }

    public static String bigIntegerAdd(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int n = n1.length, m = n2.length;
        // 判断是否进位
        boolean flag = false;
        int idx1 = n-1, idx2 = m-1;
        StringBuffer sb = new StringBuffer();
        while (idx1 >= 0 && idx2 >= 0) {
            char x = n1[idx1];
            char y = n2[idx2];
            int sum = x + y - '0' * 2;
            sum = flag ? sum + 1 : sum;
            flag = sum >= 10 ? true : false;
            sb.append((sum % 10));
            idx1--;
            idx2--;
        }
        while(flag || idx1 >= 0 || idx2 >= 0) {
            if (idx1 >= 0) {
                int sum = n1[idx1] - '0' + (flag ? 1 : 0);
                flag = sum >= 10 ? true : false;
                sb.append((sum % 10));
                idx1--;
            } else if (idx2 >= 0) {
                int sum = n2[idx2] - '0' + (flag ? 1 : 0);
                flag = sum >= 10 ? true : false;
                sb.append((sum % 10));
                idx2--;
            } else {
                sb.append(1);
                flag = false;
            }
        }
        return sb.reverse().toString();
    }

    public static String bigIntegerAdd2(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int n = n1.length, m = n2.length;
        // 判断是否进位
        boolean flag = false;
        int idx1 = n-1, idx2 = m-1;
        StringBuffer sb = new StringBuffer();
        AddResult addResult = new AddResult(false, "");

        while (idx1 >= 0 && idx2 >= 0) {
            String result = "";
            addResult.addTwoChar(n1[idx1], n2[idx2], addResult.flag);
            sb.append(addResult.result);
            idx1--;
            idx2--;
        }
        while(addResult.flag || idx1 >= 0 || idx2 >= 0) {
            if (idx1 >= 0) {
                String result = "";
                addResult.addTwoChar(n1[idx1], '0', addResult.flag);
                sb.append(addResult.result);
                idx1--;
            } else if (idx2 >= 0) {
                String result = "";
                addResult.addTwoChar(n2[idx2], '0', addResult.flag);
                sb.append(addResult.result);
                idx2--;
            } else {
                sb.append(1);
                addResult.flag = false;
            }
        }
        return sb.reverse().toString();
    }

    static class AddResult {
        private boolean flag;
        private String result;
        AddResult(boolean flag, String result) {
            this.flag = flag;
            this.result = result;
        }

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
        public void addTwoChar(char x, char y,  boolean flag) {
            int sum = x + y - '0' * 2;
            sum = flag ? sum + 1 : sum;
            this.flag = sum >= 10 ? true : false;
            this.result = String.valueOf(sum % 10);
        }

    }



    public static void main(String[] args) {
//        TreeNode t1 = new TreeNode(1);
//        TreeNode t2 = new TreeNode(2);
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(4);
//        TreeNode t5 = new TreeNode(5);
//        TreeNode t6 = new TreeNode(6);
//        TreeNode t7 = new TreeNode(7);
//        TreeNode t8 = new TreeNode(8);
//        TreeNode t9 = new TreeNode(9);
//        t1.left = t2;
//        t1.right = t3;
//        t2.left = t4;
//        t3.left = t5;
//        t3.right = t6;
//        t5.left = t7;
//        t5.right = t8;
//        t6.right = t9;

//        ListNode l1 = new ListNode(-1);
//        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(4);
//        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(2);
//        l2.next.next = new ListNode(3);
//
//        Solution solution = new Solution();
//        solution.printList(l1);
//        solution.printList(l2);
//
//        ListNode l3 = solution.minusList(l1,l2);
//        solution.printList(l3);
//        System.out.println(solution.maxWater(new int[]{1,2,1,2,3}));

//        int[] nums = new int[]{2,3,5,4,1};
//        printNums(nums);
//        heapSort(nums);
//        printNums(nums);
        System.out.println(bigIntegerAdd2("99", "1"));
    }
}

 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
      this.val = val;
    }
}
 class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }

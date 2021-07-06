package Rambo;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.*;

//public class Main {
//    public static void main(String[] args) {
//
//        Scanner in = new Scanner(System.in);
//        Map<String, Integer> map = new HashMap<>();
//
//        int N = in.nextInt();
//        int group = 0;
//        for(int i = 0; i < N; ++i) {
//            String name1 = in.next();
//            String name2 = in.next();
//            if(map.containsKey(name1) && map.containsKey(name2)) {
//                int index1 = map.get(name1);
//                int index2 = map.get(name2);
//                for(String key : map.keySet()) {
//                    if(map.get(key).equals(index2)) {
//                        map.put(key, index1);
//                    }
//                }
//            } else if(map.containsKey(name1)) {
//                map.put(name2, map.get(name1));
//            } else if (map.containsKey(name2)) {
//                map.put(name1, map.get(name2));
//            } else {
//                map.put(name1, group);
//                map.put(name2, group);
//                group++;
//            }
//        }
//        Set<Integer> set = new HashSet<>();
//        for(int value  : map.values()) {
//            set.add(value);
//        }
//        System.out.println(set.size());
//    }
//}

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

public class Main {
//    public int buyHouse(int[] nums, int k) {
//        int n = nums.length;
//        int result = 0;
//        double minD = Integer.MAX_VALUE;
//
//        ArrayList<Integer> list0 = new ArrayList<>();
//        ArrayList<Integer> listk = new ArrayList<>();
//        for(int i = 0; i < n; ++i) {
//            if(nums[i] == 0) list0.add(i);
//            if(nums[i] != 0 && nums[i] <= k) listk.add(i);
//        }
//
//
//        for(int i = 0; i < listk.size(); ++i) {
//            double temp = 0;
//            int indexK = listk.get(i);
//            for(int j = 0; j < list0.size(); ++j) {
//                int index0 = list0.get(j);
//                temp += Math.abs(index0 - indexK);
//            }
//            if (temp / list0.size() < minD) {
//                minD = Math.min(minD, temp / list0.size());
//                result = indexK;
//            }
//        }
//
//        return  result+1;
//    }

    public static int maxScore(int[] dn, int[] dm) {
        int n = dn.length;
        int m = dm.length;
        Arrays.sort(dn);
        Arrays.sort(dm);
        int count = 0;
        for(int i = m-1; i >= 0; --i) {
            int countM = m - i;
            // compute countN;
            int countN = 0;
            int start = 0, end = n - 1;
            while(start < end) {
                int mid = (start + end)/2;
                if(dn[mid] == dm[i]) {
                    countN = m - mid;
                } else if (dn[mid] < dm[i]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            if(start >= end) countN = start;
//            for(int j = n - 1; j >= 0; --j) {
//                if(dn[j] >= dm[i]) {
//                    countN++;
//                } else {
//                    break;
//                }
//            }

            if(countM - countN < count)break;
            count = Math.max(countM - countN, count);
        }


        return m - n + count;
    }
    public static int count(int[] dn, int[] dm, int i) {
        int n = dn.length;
        int m = dm.length;
        if(i < 0 || i >= m) return 0;
        int countM = m - i;
        // compute countN;
        int countN = 0;
        for(int j = n - 1; j >= 0; --j) {
            if(dn[j] >= dm[i]) {
                countN++;
            } else {
                break;
            }
        }
        return countM - countN;
    }

    public static int returnMin(int[] nums) {
        int n = nums.length;
        int result = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i) {
            int count = 1;
            if(map.containsKey(nums[i])) count = count + map.get(nums[i]);
            map.put(nums[i], count);
        }
        int temp = Integer.MAX_VALUE;
        for(Integer num : map.keySet()) {
            if(map.get(num) == 1) {
                temp = Math.min(temp, num);
            }
        }
        return temp == Integer.MAX_VALUE ? -1 : temp;
    }
    static class Node {
        long n;
        long p;
        public Node(long n, long p) {
            this.n = n;
            this.p = p;
        }
    }
    public static long cal(long[] nums, long[] pays) {
        PriorityQueue<Node> nodes = new PriorityQueue<>((o1,o2) -> {
            if(o1.n != o2.n) {
                return (int) (o1.n - o2.n);
            } else {
                return (int) (o1.p - o2.p);
            }
        });
        long res = 0;
        for(int i = 0; i < nums.length; i++) {
            Node node = new Node(nums[i], pays[i]);
            nodes.add(node);
        }

        while(!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (!nodes.isEmpty()) {
                if (node.n == nodes.peek().n) {
                    res += node.p;
                    node.n++;
                    nodes.offer(node);
                }
            }
        }
        return res;
    }
    public static void quickSort(int[] nums, int start, int end) {
        if(start < end) {
            int p = partition(nums, start, end);
            quickSort(nums, start, p-1);
            quickSort(nums, p+1, end);
        }
    }
    public static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start, j = end + 1;
        while(true) {
            while(i != end && nums[++i] < pivot);
            while(j != start && nums[--j] > pivot);
            if(i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static int[] getRandom(int n) {
        int[] nums = new int[n];
        Random r = new Random();
        for(int i = 0; i < n; ++i) {
            nums[i] = r.nextInt(10);
        }
        return nums;
    }
    public static void printNums(int[] nums) {
        for(int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static int countOfN(int[] nums, int N) {
        int count = 0;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < (1 << n); ++i) {
            int sum = 0;
            boolean flag = false;
            for(int j = 0; j < n; ++j) {
                if((i & (1 << j)) != 0) {
                    sum += nums[j];
                    if(sum > N) {
                        flag = true;
                        break;
                    }
                }
            }
            //System.out.println("sum: " + sum);
            if(flag) break;
            if(sum == N) count++;
        }
        return count;
    }
    public static boolean isLike(String a, String b) {
        int count = 0;
        for(int i = 0; i < a.length(); ++i) {
            if(a.charAt(i) == b.charAt(i)) {
                count++;
            }
        }
        return count >= 2;
    }

    public static int backTrace(int[] an, int g, int start, int end) {
        if(g == 1) {
            int max = maxN(an, start, end);
            //result = Math.min(temp, result);
            //System.out.println(start + " " + end + " " + max);
            return max;
        } else {
            int tempValue = Integer.MAX_VALUE;
            for(int i = start; i <= end; ++i) {
                int left = backTrace(an, 1, start, i);
                int right = backTrace(an, g-1, i+1, end);
                if(i+1 > end) right = 0;
                tempValue = Math.min(tempValue, left + right);
//                if (tempValue == -2147483626) {
//                    System.out.println("-2147483626: " + g + " " + start + " " + end + " " + i + " " + left + " " + right);
//                }
            }

            //System.out.println("temp: " + tempValue);
            return tempValue;
        }

    }
    public static int maxN(int[] nums, int start, int end) {
        if(start > end) return 0;
        int max = nums[start];
        for(int i = start; i <= end; ++i) {
            max  = Math.max(max, nums[i]);
        }
        int maxResult = 0;
        for(int i = start; i <= end; ++i) {
            maxResult += max - nums[i];
        }
        return maxResult;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int g = in.nextInt();
        int[] an = new int[n];
        for(int i = 0; i < n; ++i) {
            an[i] = in.nextInt();
        }
        int ans = backTrace(an, g, 0, an.length - 1);
        System.out.print(ans);
    }

}
package Rambo;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;

public class Main {
    public static String[] returnPWD(char[] chs, int m) {
        Arrays.sort(chs);
        int numLength = 0, chLength = 0;
        for(int i = 0; i < chs.length; ++i) {
            if(chs[i] >= '0' && chs[i] <= '9') {
                numLength++;
            } else {
                chLength++;
            }
        }
        char[] nums = new char[numLength], alphas = new char[chLength];
        numLength = 0;
        chLength = 0;
        for(int i = 0; i < chs.length; ++i) {
            if(chs[i] >= '0' && chs[i] <= '9') {
                nums[numLength++] = chs[i];
            } else {
                alphas[chLength++] = chs[i];
            }
        }

        List<String> resultList = new ArrayList<>();
        for(int i = 1; i <= Math.min(numLength, m - 2); ++i) {
            //i是字母的个数
            int j = m - i;
            //选取i个数字，和j个字母

        }
        String[] result = new String[666666];
        return result;
    }


//    public static int shortDistance(int[][] walk, int[][] car, int x, int y) {
//        int min = walk[x][y];
//        if(min == 0) {
//            for (int i = 1; i < walk[y].length; ++i) {
//                if()
//            }
//        }
//    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int m = in.nextInt();
//        int n = in.nextInt();
//        char[] chs = new char[n];
//        for(int i = 0; i < n; ++i) {
//            chs[i] = in.next().charAt(0);
//        }
//        String[] result = returnPWD(chs, m);
//        for(int i = 0; i < result.length; ++i) {
//            System.out.println(result[i]);
//        }
        System.out.println(65536L * 65536L / 300000);

    }
}
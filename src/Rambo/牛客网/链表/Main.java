package Rambo.牛客网.链表;

import java.util.*;
public class Main {
    //暴力
    public static int[] pickBook(int[][] scores, int n) {
        int[] sxy = new int[3];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                int temp = getMin(scores[i], scores[j]);
                if(temp > max) {
                    max = temp;
                    sxy[0] = temp;
                    sxy[1] = i+1;
                    sxy[2] = j+1;
                }
            }
        }
        return sxy;
    }
    public static int getMin(int[] a, int[] b) {
        int[] result = new int[a.length];
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < a.length; ++i) {
            result[i] = Math.max(a[i], b[i]);
            max = Math.min(result[i], max);
        }
        return max;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n = in.nextInt();
        int[][] scores = new int[n][5];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < 5; ++j) {
                scores[i][j] = in.nextInt();
            }
        }
        int[] sxy = pickBook(scores, n);
        System.out.println(sxy[0] + " " + sxy[1] + " " + sxy[2]);
    }
}
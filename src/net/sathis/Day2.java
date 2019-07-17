package net.sathis;

import java.util.Arrays;

public class Day2 {

    public static int getCountRecursive(int[] sizes) {
        //start from 1 because 0 always has an parenthesis
        return getCountRecursive(sizes, 1, sizes.length - 1);
    }

    private static int getCountRecursive(int[] sizes, int s, int e) {
        int min = Integer.MAX_VALUE;

        //When you have zero elements, cost is zero
        if (s == e)
            return 0;

        //end at e - 1 as e always has closing parenthesis
        for (int i = s; i < e; i++) {
            int count = getCountRecursive(sizes, s, i)
                    + getCountRecursive(sizes, i + 1, e)
                    + sizes[s - 1] * sizes[i] * sizes[e];
            min = Math.min(min, count);
        }
        return min;
    }

    public static int getCountDP(int[] sizes) {
        int[][] dp = new int[sizes.length][sizes.length];

        //l denotes Chain length
        for (int l = 2; l < sizes.length; l++) {
            //i denotes chain starting position
            for (int i = 1; i < sizes.length - l + 1; i++) {

                //j is the end index
                int j = l + i - 1;

                if (j == sizes.length)
                    continue;

                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int count = dp[i][k]
                            + dp[k + 1][j]
                            + sizes[i - 1] * sizes[k] * sizes[j];
                    min = Math.min(min, count);
                }
                dp[i][j] = min;
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[1][sizes.length - 1];
    }

    public static void main(String[] args) {
        int[] sizes = {40, 20, 30, 10, 30};
        System.out.println(getCountDP(sizes));
    }
}

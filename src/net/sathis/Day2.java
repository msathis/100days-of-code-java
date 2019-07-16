package net.sathis;

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

    private static int getCountDP(int[] sizes) {
        int[][] dp = new int[sizes.length + 1][sizes.length + 1];


        for (int i = 1; i <= sizes.length; i++) {
            for (int j = 1; j <= sizes.length; j++) {

                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int count = dp[i - 1][k - 1]
                            + dp[k][j - 1]
                            + sizes[i - 1] * sizes[k - 1] * sizes[j - 1];
                    min = Math.min(min, count);
                }
                dp[i][j] = min;
            }
        }

        return dp[sizes.length][sizes.length];
    }

    public static void main(String[] args) {
        int[] sizes = {40, 20, 30, 10, 30};
        System.out.println(getCountDP(sizes));
    }
}

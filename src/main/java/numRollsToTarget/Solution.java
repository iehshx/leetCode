package numRollsToTarget;

import java.util.Arrays;

class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return process2(n, k, target, dp);
    }

    int MOD = (int) (Math.pow(10, 9) + 7);


    private int process2(int n, int k, int target, int dp[][]) {

        if (n < 0 || target < 0) {
            return -1;
        }
        if (dp[n][target] != -1) {
            return dp[n][target];
        }
        if (target == 0) {
            return 1;
        }
        int ways = 0;
        for (int j = 1; j <= k; j++) {
            int p = process2(n - 1, k, target - j, dp);
            if (p != -1) {
                ways += p;
            }
        }
        dp[n][target] = ways;
        return ways;
    }


    public int dp(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                int sum = 0;
                for (int l = 1; l <= k; l++) {
                    if (j - l >= 0) {
                        sum += dp[i - 1][j - l];
                    }
                    sum %= MOD;
                }
                dp[i][j] = sum;
            }
        }
        return dp[n][target];
    }

//    private int process(int n, int k, int target) {
//        if (n < 0 || target < 0) {
//            return -1;
//        }
//        if (target == 0) {
//            return 1;
//        }
//        int ways = 0;
//        for (int j = 1; j <= k; j++) {
//            int p = process(n - 1, k, target - j);
//            if (p != -1) {
//                ways += p;
//            }
//        }
//        ways %= MOD;
//        return ways;
//    }


    public static void main(String[] args) {
        int n = 30, k = 30, target = 500;
//        int n = 2, k = 6, target = 7;
//        System.out.println(new Solution().numRollsToTarget(n, k, target));
        System.out.println(new Solution().dp(n, k, target));
    }
}
package climbStairs;

import com.sun.deploy.uitoolkit.impl.fx.ui.FXConsole;

import java.util.Arrays;

class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n + 1];
//        Arrays.fill(dp, -1);
        return process(n, dp);
    }

    public int climbStairs2(int n) {
        //
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private int process(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int p1 = process(n - 1);
        int p2 = process(n - 2);
        //1
        int ans = p1 + p2;
        dp[n] = ans;
        return ans;
    }


    private int process(int n) {
        if (n <= 1) {
            return 1;
        }
        int p1 = process(n - 1);
        int p2 = process(n - 2);
        //1
        return p1 + p2;
    }



    public static void main(String[] args) {
        int n = 15;
        System.out.println(new Solution().climbStairs(n));
        System.out.println(new Solution().climbStairs2(n));
    }

}
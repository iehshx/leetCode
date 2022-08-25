package superEggDrop;

import java.util.Arrays;

class Solution {

    public int superEggDrop(int k, int n) {
        if (n == 1) {
            return k;
        }
        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return process(k, n, dp);
    }

    private int process(int egg, int level, int dp[][]) {
        if (dp[egg][level] != -1) {
            return dp[egg][level];
        }
        if (egg == 1) {
            return level;
        }
        if (level == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= level; i++) {
            //鸡蛋在i层    如果鸡蛋碎了 楼层-1 鸡蛋-1    鸡蛋没碎楼层-i 鸡蛋不变
            ans = Math.min(ans, Math.max(process(egg - 1, i - 1, dp), process(egg, level - i, dp)));
        }
        ans += 1;
        dp[egg][level] = ans;
        return ans;
    }


    public int dp(int level, int egg) {

        int[][] dp = new int[level + 1][level + 1];
        return 0;

    }


    public static void main(String[] args) {
        int k = 2;
        int n = 6;
        System.out.println(new Solution().superEggDrop(k, n));
    }


}

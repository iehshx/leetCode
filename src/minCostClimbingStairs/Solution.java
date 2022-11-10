package minCostClimbingStairs;

import java.util.Random;

class Solution {


    public int minCostClimbingStairs3(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int ans1 = process(cost, 0);
        int ans2 = process(cost, 1);
        return Math.min(ans1, ans2);
    }

    /**
     * 从i到最后的最小代价
     *
     * @param cost
     * @param i
     * @return
     */
    private int process(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }

        int ans;
        if (i == cost.length - 1) {
            ans = cost[i];
        } else {
            int p1 = cost[i] + process(cost, i + 1);
            int p2 = cost[i] + process(cost, i + 2);
            ans = Math.min(p1, p2);
        }
        return ans;
    }


    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int[] dp = new int[cost.length];
        process(cost, 0, dp);
        return Math.min(dp[0], dp[1]);
    }

    /**
     * 从i到最后的最小代价
     *
     * @param cost
     * @param i
     * @return
     */
    private int process(int[] cost, int i, int dp[]) {
        if (i >= cost.length) {
            return 0;
        }

        if (dp[i] != 0) {
            return dp[i];
        }
        int ans;
        if (i == cost.length - 1) {
            ans = cost[i];
        } else {
            int p1 = cost[i] + process(cost, i + 1, dp);
            int p2 = cost[i] + process(cost, i + 2, dp);
            ans = Math.min(p1, p2);
        }
        dp[i] = ans;
        return ans;
    }


    public static int[] createRandomArray(int start, int end, int count) {
        int[] ret = new int[count];
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            ret[i] = random.nextInt(end) + start;
        }
        return ret;
    }


    public int minCostClimbingStairs2(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        int N = cost.length;
        int dp[] = new int[N];
        dp[N - 1] = cost[N - 1];
        dp[N - 2] = cost[N - 2];
        for (int i = N - 3; i >= 0; i--) {
            dp[i] = Math.min(cost[i] + dp[i + 1], cost[i] + dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }


    public static void main(String[] args) {
//        int[] cost = {1, 2, 2, 0};
//        int[] cost = {1, 100, 1, 100, 1, 100, 1, 100, 1, 100, 1, 100};
        int start = 1;
        int end = 1000;
        int count = 1000000;
        for (int i = 0; i < count; i++) {
            int[] cost = createRandomArray(start, end, 10);
            int ans = new Solution().minCostClimbingStairs(cost);
            int ans2 = new Solution().minCostClimbingStairs2(cost);
            int ans3 = new Solution().minCostClimbingStairs3(cost);
            if (ans != ans2 || ans != ans3) {
                System.out.println("oops!");
            }
        }
        System.out.println("finish");
    }
}
package maxProfit2;

import java.util.HashMap;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        return process(prices, false, 0, 0, new HashMap<>());
    }

    private int process(int[] prices, boolean isBuy, int i, int buyPrices, HashMap<String, Integer> map) {
        if (i >= prices.length) {
            return 0;
        }
        if (map.containsKey(i + "_" + isBuy + "_" + buyPrices)) {
            return map.get(i + "_" + isBuy + "_" + buyPrices);
        }
        int ans;
        if (isBuy) {//之前已经购买过了
            int no = process(prices, true, i + 1, buyPrices, map);
            int yes = prices[i] - buyPrices + process(prices, false, i + 2, 0, map);
            ans = Math.max(no, yes);
        } else {
            int no = process(prices, false, i + 1, 0, map);
            int yes = process(prices, true, i + 1, prices[i], map);
            ans = Math.max(no, yes);
        }
        map.put(i + "_" + isBuy + "_" + buyPrices, ans);
        return ans;
    }


    public int dp(int[] prices) {
        int n = prices.length;

        int m = 0;
        for (int i = 0; i < n; i++) {
            m = Math.max(m, prices[i]);
        }
        int[][][] dp = new int[n + 1][m + 1][2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j][0] == 0) {//已经购买了
                    int p1 = dp[i + 1][j][0];
                    int p2 = 0;
                    if (i + 2 < n) {
                        p2 = prices[i] + dp[i + 2][j][1];
                    }
                    dp[i][j][0] = Math.max(p1, p2);
                } else {
                    int p1 = dp[i + 1][j][1];
                    int p2 = dp[i + 1][j][0];
                    dp[i][j][0] = Math.max(p1, p2);
                }
            }
        }
        return dp[0][0][1];
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(new Solution().maxProfit(prices));
        System.out.println(new Solution().dp(prices));
    }
}
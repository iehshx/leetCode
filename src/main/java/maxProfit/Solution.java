package maxProfit;

class Solution {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }
}
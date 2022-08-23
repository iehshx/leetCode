package coinChange;

import java.util.Arrays;

class Solution {


    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) return -1;
        if (amount == 0) return 0;
        if (coins.length == 1) return amount % coins[0] == 0 ? amount / coins[0] : -1;
        int N = coins.length;
        int dp[][] = new int[N + 1][amount + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        return process(coins, 0, amount, dp);
    }

    int process(int[] arr, int index, int rest, int dp[][]) {
        if (rest < 0) {//如果钱消耗到小于0了 就无效
            return Integer.MAX_VALUE;
        }
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == arr.length) {
            dp[index][rest] = rest == 0 ? 0 : Integer.MAX_VALUE;
            return rest == 0 ? 0 : Integer.MAX_VALUE;
        } else {
            int ans = Integer.MAX_VALUE;
            for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                int next = process(arr, index + 1, rest - zhang * arr[index], dp);//剩下的面值搞定剩下的钱 最少多少张
                if (next != Integer.MAX_VALUE) {
                    ans = Math.min(ans, next + zhang);
                    dp[index][rest] = ans;
                }
            }
            return ans;
        }
    }

//    public int coinChange2(int[] coins, int amount) {
//        if (coins == null || coins.length == 0 || amount < 0) return -1;
//        if (amount == 0) return 0;
//        int n = coins.length;
//        if (n == 1) return amount % coins[0] == 0 ? amount / coins[0] : -1;
//
//        int dp[][] = new int[n + 1][amount + 1];
//        dp[n][0] = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = amount; amon; j++) {
//                int ans = Integer.MAX_VALUE;
//                for (int zhang = 0; zhang * coins[i] <= j; zhang++) {
//                    ans = dp[i + 1][j - (zhang * coins[i])] != Integer.MAX_VALUE ? dp[i + 1][j - (zhang * coins[i])] : Integer.MAX_VALUE;
//                }
//                dp[i][j] = ans;
//            }
//        }
//        return dp[0][amount];
//    }


    int dp(int arr[], int aim) {
        if (arr.length < 0 || arr == null || aim <= 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        dp[n][0] = 1;
        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    ways += dp[index + 1][rest - (zhang * arr[index])];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }
//    int coinChange3(int[] coins, int amount) {
//        if (coins == null || coins.length == 0 || amount < 0) return -1;
//        if (amount == 0) return 0;
//        if (coins.length == 1) return amount % coins[0] == 0 ? amount / coins[0] : -1;
//        int dp[][] = new int[coins.length][amount];
//        return process(coins, 0, amount, dp);
//    }


//    int process(int[] arr, int index, int rest, int dp[][]) {
//        if (rest < 0) {//如果钱消耗到小于0了 就无效
//            return Integer.MAX_VALUE;
//        }
//        if (dp[index][rest] != -1) {
//            return dp[index][rest];
//        }
//        if (index == arr.length) {
//            dp[index][rest] = rest == 0 ? 0 : Integer.MAX_VALUE;
//            return rest == 0 ? 0 : Integer.MAX_VALUE;
//        } else {
//            int ans = Integer.MAX_VALUE;
//            for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
//                int next = process(arr, index + 1, rest - zhang * arr[index], dp);//剩下的面值搞定剩下的钱 最少多少张
//                if (next != Integer.MAX_VALUE) {
//                    ans = Math.min(ans, next + zhang);
//                    dp[index][rest] = ans;
//                }
//            }
//            return ans;
//        }
//    }

//    public int coinChange2(int[] coins, int amount) {
//        if (coins == null || coins.length == 0 || amount < 0) return -1;
//        if (amount == 0) return 0;
//        int N = coins.length;
//        if (N == 1) return amount % coins[0] == 0 ? amount / coins[0] : -1;
////        for () {
////
////        }
//        return 0;
//    }

//    int ans = Integer.MAX_VALUE;

//    void process(int[] coins, int index, int rest) {
//        if (rest < 0) return;
//        if (rest == 0) {
//            ans = Math.min(index, ans);
//        }
//        for (int i = 0; i < coins.length; i++) {
//            process(coins, index + 1, rest - coins[i]);
//        }
//    }

    public static void main(String[] args) {
        int[] coins = {411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
//        int[] coins = {1, 2, 5};
//
        int amount = 9864;
//        int amount = 11;
//        System.out.println(new Solution().coinChange2(coins, amount));
        System.out.println(new Solution().coinChange(coins, amount));

//        for (int i = 0; i < 20; i++) {
//        }
//        System.out.println(new Solution().coinChange(coins, amount));
//        System.out.println(new Solution().coinChange2(coins, amount));
    }
}
//package waysToStep;
//
//class Solution {
//
//
//    //    三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
//    public int waysToStep(int n) {
//        int dp[] = new int[n + 1];
//        return process(n, dp);
//    }
//
//    int waysToStep2(int n) {
//        if (n == 1) {
//            return 1;
//        }
//        if (n == 2) {
//            return 2;
//        }
//        long dp[] = new long[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        dp[2] = 2;
//        for (int i = 3; i <= n; i++) {
////            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) %1000000007;
//            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3])%1000000007;
//
//        }
//        return (int) dp[n];
//    }
//
//    int process(int n, int dp[]) {
//        if (n < 0) return 0;
//        if (n == 0) {
//            return 1;
//        }
//        if (dp[n] != 0) return dp[n];
//        dp[n] = process(n - 1, dp) + process(n - 2, dp) + process(n - 3, dp);
//        dp[n] = dp[n] % 1000000007;
//        return dp[n];
//    }
//
//    //752119970
//    public static void main(String[] args) {
////        for (int i = 0; i < 15; i++) {752119970
//        System.out.println("i = " + 61 + "  ans = " + new Solution().waysToStep(61));
//        System.out.println("i = " + 61 + "  ans = " + new Solution().waysToStep2(1000));
////        }
//    }
//}
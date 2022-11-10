package fib;

class Solution {
    public int fib(int n) {
        int dp[] = new int[n + 1];
        return process(n, dp);
    }


    public int fib2(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int sec = 1;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = (first + sec) % 1000000007;
            first = sec;
            sec = cur;
        }
        return cur;
    }


    public int process(int n, int dp[]) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        int ans = process(n - 1, dp) + process(n - 2, dp);
        dp[n] = ans % 1000000007;
        if (dp[n] == 1000000008) {
            dp[n] = 1;
        }
        ans = dp[n];
        return ans;
    }

    public static void main(String[] args) {
//        134903163
        System.out.println(new Solution().fib(61));
        System.out.println(new Solution().fib2(1));
    }
}
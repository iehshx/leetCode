package findPaths;

import java.util.HashMap;

class Solution {

    private int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove <= 0 || m <= 0 || n <= 0) return 0;
//        return process(m, n, maxMove, startRow, startColumn);
        return (int) process(m, n, maxMove, startRow, startColumn, new HashMap<>()) % MOD;
    }

    private long process(int m, int n, int rest, int x, int y, HashMap<String, Long> map) {
        if (map.containsKey(x + "_" + y + "_" + rest)) {
            return map.get(x + "_" + y + "_" + rest);
        }
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return 1;
        }
        if (rest == 0) {
            return (x < 0 || y < 0 || x >= m || y >= n) ? 1 : 0;
        }
        long p1 = (process(m, n, rest - 1, x - 1, y, map) % MOD);
        long p2 = (process(m, n, rest - 1, x + 1, y, map) % MOD);
        long p3 = (process(m, n, rest - 1, x, y - 1, map) % MOD);
        long p4 = (process(m, n, rest - 1, x, y + 1, map) % MOD);
        long ans = ((p1 + p2 + p3 + p4)) % MOD;
//        int ans = 0;
//        ans += (p1 % MOD);
//        ans += (p2 % MOD);
//        ans += (p3 % MOD);
//        ans += (p4 % MOD);
        map.put(x + "_" + y + "_" + rest, ans);
        return ans;
    }

    private int process(int m, int n, int rest, int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return 1;
        }
        if (rest == 0) {
            return (x < 0 || y < 0 || x >= m || y >= n) ? 1 : 0;
        }
        int p1 = (int) (process(m, n, rest - 1, x - 1, y) % (Math.pow(10, 9) + 7));
        int p2 = (int) (process(m, n, rest - 1, x + 1, y) % (Math.pow(10, 9) + 7));
        int p3 = (int) (process(m, n, rest - 1, x, y - 1) % (Math.pow(10, 9) + 7));
        int p4 = (int) (process(m, n, rest - 1, x, y + 1) % (Math.pow(10, 9) + 7));
        int ans = (int) ((p1 + p2 + p3 + p4));
//        int ans = (int) ((p1 + p2 + p3 + p4));
        return ans;
    }



    public int dp(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove <= 0 || m <= 0 || n <= 0) return 0;

        int dp[][][] = new int[n + 2][m + 2][maxMove + 1];//0位置表示出界  1位置是0 所以+2
        for (int i = 1; i < maxMove; i++) {//只要x,y<0 不管有几步都是1
            dp[0][0][i] = 1;
            dp[n + 1][m + 1][i] = 1;
        }
        for (int i = startRow + 1; i <= n; i++) {
            for (int j = startColumn + 1; j <= m; j++) {
                for (int k = maxMove; k >= 0; k--) {
                    int p1 = dp[i - 1][j][k];
                    int p2 = dp[i + 1][j][k];
                    int p3 = dp[i][j - 1][k];
                    int p4 = dp[i][j + 1][k];
                    dp[i][j][k] = p1 + p2 + p3 + p4;
                }
            }
        }
        return dp[n + 1][m + 1][maxMove];
    }

    public static void main(String[] args) {
        int m = 36, n = 5, maxMove = 50, startRow = 15, startColumn = 3;
        System.out.println(new Solution().findPaths(m, n, maxMove, startRow, startColumn));
        System.out.println(new Solution().dp(m, n, maxMove, startRow, startColumn));
    }
}
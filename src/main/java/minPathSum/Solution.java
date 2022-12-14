package minPathSum;

import java.util.HashMap;

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        process(grid, 0, 0, 0);
        return mAns;
    }


    int mAns = Integer.MAX_VALUE;

    private void process(int[][] grid, int i, int j, int pre) {
        if (i > grid.length - 1 || j > grid[0].length - 1) return;
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            mAns = Integer.min(mAns, pre + grid[i][j]);
        }
        process(grid, i + 1, j, pre + grid[i][j]);
        process(grid, i, j + 1, pre + grid[i][j]);
    }

    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int p1 = grid[i][j] + dp[i - 1][j];
                int p2 = grid[i][j] + dp[i][j - 1];
                dp[i][j] = Math.min(p1, p2);
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
//        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        System.out.println(new Solution().minPathSum(grid));
        System.out.println(new Solution().minPathSum2(grid));
    }
}
package maxValue;

import java.util.Arrays;

class Solution {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int dp[][] = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return process(grid, 0, 0, dp);
    }

    int process(int[][] grid, int i, int j, int dp[][]) {
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = grid[i][j];
        int p1 = process(grid, i + 1, j, dp);
        int p2 = process(grid, i, j + 1, dp);
        ans += Math.max(p1, p2);
        dp[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int grid[][] = {
                {1, 2, 5},
                {3, 2, 1}
        };
        System.out.println(new Solution().maxValue(grid));
    }

}
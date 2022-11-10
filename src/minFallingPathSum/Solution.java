package minFallingPathSum;

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            ans = Math.min(ans, process(grid, i, 0));
        }
        return ans;
    }

    //    dev -> release
//     feature->release->master->tag
//                     ->bugfix
//                     ->fix
    private int process(int[][] grid, int i, int j) {
        if (i == grid.length - 1) {
            return grid[i][j];
        }

        if (j >= grid[0].length) {
            return 0;
        }
        if (j < 0) {
            return 0;
        }
        return grid[i][j] + Math.max(process(grid, i + 1, j - 1), process(grid, i + 1, j + 1));
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution().minFallingPathSum(grid));
    }
}
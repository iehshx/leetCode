package cherryPickup;

class Solution {
    public int cherryPickup(int[][] grid) {

        int ans = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) return ans;

        ans = process(grid, 0, 0);
        return ans;
    }

    private int process(int[][] grid, int i, int j) {
        if (i > grid.length - 1 || j > grid[0].length - 1) return Integer.MIN_VALUE;
        if (grid[i][j] == -1) {//挡着的路 无法继续前进
            return Integer.MIN_VALUE;
        }
        int temp = grid[i][j];
        int ans = 0;
        if (i == grid.length - 1 && j == grid.length - 1) {
            grid[i][j] = 0;
            return temp;
        } else if (i == grid.length - 1) {
            grid[i][j] = 0;
            ans = temp + process(grid, i, j + 1);
            grid[i][j] = temp;
            return ans;
        } else if (j == grid[0].length - 1) {
            grid[i][j] = 0;
            ans = temp + process(grid, i + 1, j);
            grid[i][j] = temp;
            return ans;
        } else {
            grid[i][j] = 0;
            int p1 = process(grid, i, j + 1);
            grid[i][j] = temp;
            if (p1 != Integer.MIN_VALUE) {
                ans = p1;
                grid[i][j] = 0;
            } else {
                grid[i][j] = temp;
            }
            grid[i][j] = 0;
            int p2 = process(grid, i + 1, j);
            grid[i][j] = temp;
            if (p2 != Integer.MIN_VALUE) {
                ans = Math.max(ans, p2);
            }
            ans += grid[i][j];
            return ans;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, -1},
                {1, 0, -1},
                {1, 1, 1}};
        System.out.println(new Solution().cherryPickup(grid));
    }
}
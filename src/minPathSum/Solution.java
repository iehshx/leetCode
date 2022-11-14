//package minPathSum;
//
//import java.util.HashMap;
//
//class Solution {
//    public int minPathSum(int[][] grid) {
//        return process(grid, 0, 0);
//    }
//
//    public int minPathSum2(int[][] grid) {
//        return process2(grid, 0, 0, new HashMap<>());
//    }
//
//    public int minPathSum3(int[][] grid) {
//        int N = grid.length;
//        int M = grid[0].length;
//        int dp[][] = new int[N][M];
//        for (int i = N - 1; i >= 0; i--) {
//            for (int j = M - 1; j >= 0; j--) {
//                if (i == N - 1 && j == M - 1) {
//                    dp[i][j] = grid[i][j];
//                } else if (i == N - 1) {
//                    dp[i][j] = grid[i][j] + dp[i][j + 1];
//                } else if (j == M - 1) {
//                    dp[i][j] = grid[i][j] + dp[i + 1][j];
//                } else {
//                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
//                }
//            }
//        }
//        return dp[0][0];
//    }
//
//
//    int process(int[][] grid, int x, int y) {
//        int n = grid.length;
//        int m = grid[0].length;
//        if (x == n - 1 && y == m - 1) {
//            return grid[x][y];
//        }
//        int res = 0;
//        if (x == n - 1) {//下边到头只能往右走
//            res = grid[x][y] + process(grid, x, y + 1);
//            return res;
//        } else if (y == m - 1) {//只能往下走
//            res = grid[x][y] + process(grid, x + 1, y);
//            return res;
//        }
//        res = grid[x][y] + (Math.min(process(grid, x + 1, y), process(grid, x, y + 1)));
//        return res;
//    }
//
//
//    int process2(int[][] grid, int x, int y, HashMap<String, Integer> map) {
//        int n = grid.length;
//        int m = grid[0].length;
//        if (map.containsKey(x + "_" + y)) {
//            return map.get(x + "_" + y);
//        }
//        if (x == n - 1 && y == m - 1) {
//            map.put(x + "_" + y, grid[x][y]);
//            return grid[x][y];
//        }
//        int res = 0;
//        if (x == n - 1) {//下边到头只能往右走
//            res = grid[x][y] + process2(grid, x, y + 1, map);
//            map.put(x + "_" + y, res);
//            return res;
//        } else if (y == m - 1) {//只能往下走
//            res = grid[x][y] + process2(grid, x + 1, y, map);
//            map.put(x + "_" + y, res);
//            return res;
//        }
//        res = grid[x][y] + (Math.min(process2(grid, x + 1, y, map), process2(grid, x, y + 1, map)));
//        map.put(x + "_" + y, res);
//        return res;
//    }
//
//    public static void main(String[] args) {
//        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        int ans = new Solution().minPathSum(grid);
//        int ans2 = new Solution().minPathSum2(grid);
//        int ans3 = new Solution().minPathSum3(grid);
//        System.out.println(ans);
//        System.out.println(ans2);
//        System.out.println(ans3);
//    }
//}
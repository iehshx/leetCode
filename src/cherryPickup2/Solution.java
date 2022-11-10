package cherryPickup2;

class Solution {
    public int cherryPickup(int[][] grid) {
        return process(grid, 0, 0, 0, grid[0].length - 1);
    }


    private int process(int[][] grid, int a, int b, int c, int d) {
        int N = grid.length;
        int M = grid[0].length;
        if (a > N - 1 || c > N - 1 || b > M - 1 || d > M - 1 || b < 0 || d < 0) {
            return 0;
        }
        if (a == N - 1 && c == N - 1) {
            System.out.println("都到了最底层:" + a + "," + b + "，c = " + c + "，d = " + d);
            if (b == d) {
                return grid[a][b];
            } else {
                return grid[a][b] + grid[c][d];
            }
        }
        int best = 0;
        if (a < N - 1) {//a 可以走下
            System.out.println("a可以往下走:" + a + "," + b + "，c = " + c + "，d = " + d);
            if (c < N - 1) {//a,i2可以走下
                best = Math.max(best, process(grid, a + 1, b, c + 1, d));
                //i走下 i2走下
            }
            if (d > 0) {//i走下 i2可以走左
                best = Math.max(best, process(grid, a + 1, b, c, d - 1));
            }

            if (b < M - 1) {
                best = Math.max(best, process(grid, a + 1, b - 1, c + 1, d - 1));
            }

            //i走左下 i2右下
            if (b >= 0) {
                best = Math.max(best, process(grid, a + 1, b + 1, c + 1, d + 1));
            }

        } else {
            System.out.println("a可以往右走:" + a + "," + b + "，c = " + c + "，d = " + d);
            if (b < M - 1) {//a 可以走右
                if (d > 0) {//i2可以走左
                    best = Math.max(best, process(grid, a, b + 1, c, d - 1));
                }
                if (c < N - 1) {// i2可以走下
                    best = Math.max(best, process(grid, a, b + 1, c + 1, d));
                }
                //i走左下 i2右下
//                if (a < N - 1) {
//                    //a 可以右下
//                    best = Math.max(best, process(grid, a + 1, b + 1, c + 1, d + 1));
//                }
//                if (a >= 0) {
//                    best = Math.max(best, process(grid, a + 1, b - 1, c + 1, d - 1));
//                }
            }
        }
        int cur = 0;
        if (a == c && b == d) {
            cur = grid[a][b];//a j在同一个位置
        } else {
            cur = grid[a][b] + grid[c][d];
        }
        System.out.println("a = " + a + ",j = " + b + "，c = " + c + "，d = " + d + ",ans = " + (cur + best));

        return cur + best;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};
        int ans = new Solution().cherryPickup(grid);
        System.out.println(ans);
    }

}
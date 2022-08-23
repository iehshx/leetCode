package gameOfLife;

class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int N = board.length;
        int M = board[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                process(board, i, j);
            }
        }
    }

    private int process(int[][] board, int i, int j) {
        if (i < 0 || i > board.length | j < 0 || j > board[0].length) {
            return 0;
        }
        //up
        int up = process(board, i - 1, j);
        //down
        int down = process(board, i + 1, j);
        //左
        int left = process(board, i, j - 1);
        //右
        int right = process(board, i, j + 1);
        //左上
        int leftUp = process(board, i - 1, j - 1);
        //右上
        int rightUp = process(board, i - 1, j + 1);
        //左下
        int leftDown = process(board, i + 1, j - 1);
        //右下
        int rightDown = process(board, i + 1, j + 1);
        int ans = board[i][j] == 1 ? 1 : 0;
        int total = up + down + left + right + leftUp + leftDown + rightUp + rightDown;
        if (total < 2) {
            board[i][j] = 0;
        } else {
            board[i][j] = 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new Solution().gameOfLife(board);
        for (int[] items : board) {
            for (int item : items) {
                System.out.print(item);
            }
            System.out.println();
        }
    }
}
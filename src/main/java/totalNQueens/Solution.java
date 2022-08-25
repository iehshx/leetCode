package totalNQueens;

class Solution {
    public int totalNQueens(int n) {
        if (n == 1) {
            return 1;
        }

        //存储皇后的位置
        int[] queuens = new int[n];
        return process(n, queuens, 0);
    }

    private int process(int n, int[] queuens, int i) {
        if (i == n) {
            return 1;
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(queuens, i, j)) {
                queuens[i] = j;
                ans += process(n, queuens, i + 1);
            }
        }
        return ans;
    }

    private boolean isValid(int[] queuens, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == queuens[k] || Math.abs(queuens[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int n = 15;
        System.out.println(new Solution().totalNQueens(n));
    }
}
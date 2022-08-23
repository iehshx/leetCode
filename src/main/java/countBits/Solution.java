package countBits;

class Solution {
    public int[] countBits(int n) {
        if (n <= 0) return new int[]{0};
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ans[i] = process(i);
        }
        return ans;
    }

    private int process(int n) {
        int ans = 0;
        while (n > 0) {
            ans += (n & -n) == 1 ? 1 : 0;
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ans = new Solution().countBits(n);
        for (int item : ans) {
            System.out.println(item + ",");
        }
    }
}
package maxCoins;

class Solution {
    public int maxCoins(int[] nums) {

        int N = nums.length;
        int copyNums[] = new int[N + 2];
        copyNums[0] = 1;
        copyNums[N + 1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            copyNums[i] = nums[i - 1];
        }
        int[][] dp = new int[copyNums.length + 1][copyNums.length + 1];
        process(copyNums, 1, N, dp);
        return dp[1][N];
    }

    private int process(int[] nums, int L, int R, int dp[][]) {
        if (dp[L][R] != 0) {
            return dp[L][R];
        }
        if (L == R) {
            dp[L][R] = nums[L - 1] * nums[L] * nums[R + 1];
            return dp[L][R];
        }
        //L最后爆
        int max = process(nums, L + 1, R, dp) + nums[L - 1] * nums[L] * nums[R + 1];
        //R最后爆
        max = Math.max(process(nums, L, R - 1, dp) + nums[L - 1] * nums[R] * nums[R + 1], max);
        for (int i = L + 1; i < R; i++) {
            int left = process(nums, L, i - 1, dp);
            int right = process(nums, i + 1, R, dp);
            int last = nums[L - 1] * nums[i] * nums[R + 1];
            int cur = left + last + right;
            max = Math.max(max, cur);
        }
        dp[L][R] = max;
        return max;
    }


    public static void main(String[] args) {
        int nums[] = {9, 76, 64, 21, 97, 60, 5};
        System.out.println(new Solution().maxCoins(nums));
    }
}
package rob;

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        } else if (n == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int dp1[] = new int[n];
            Arrays.fill(dp1, -1);
            int dp2[] = new int[n - 1];
            Arrays.fill(dp2, -1);
            int p1 = process(nums, 0, n - 2, dp2);
            int p2 = process(nums, 1, n - 1, dp1);
            return Math.max(p1, p2);
        }
    }

    private int process(int[] nums, int i, int end, int[] dp) {
        if (i > end) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int p1 = nums[i] + process(nums, i + 2, end, dp);
        int p2 = process(nums, i + 1, end, dp);
        int ans = Math.max(p1, p2);
        dp[i] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().rob(nums));
    }
}
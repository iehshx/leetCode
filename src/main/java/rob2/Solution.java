package rob2;

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return process(nums, 0, dp);
    }

    private int process(int[] nums, int i, int dp[]) {
        if (i > nums.length - 1) return 0;
        if (dp[i] != -1) {
            return dp[i];
        }
        int p1 = nums[i] + process(nums, i + 2, dp);
        int p2 = process(nums, i + 1, dp);
        int ans = Math.max(p1, p2);
        dp[i] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Solution().rob(nums));
    }
}
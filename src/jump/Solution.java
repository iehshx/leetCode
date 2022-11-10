package jump;

import java.util.Arrays;

class Solution {


    public int jump(int[] nums) {
        int dp[] = new int[nums.length + 1];
        return process(nums, 0, dp);
    }


    private int process(int[] nums, int start) {
        if (start >= nums.length - 1) {
            return 0;
        }
        int ans = Integer.MAX_VALUE - 1000;
        for (int i = 1; i <= nums[start]; i++) {
            ans = Math.min(ans, process(nums, start + i) + 1);
        }
        return ans;
    }

    public int jump2(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1000);
        dp[n] = 0;
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; i + j <= n - 1 && j <= nums[i]; j++) {
                dp[i] = Math.min(dp[i], dp[i + j] + 1);
            }
        }
        return dp[0];
    }

    private int process(int[] nums, int start, int[] dp) {
        if (start >= nums.length - 1) {
            return 0;
        }
        if (dp[start] != 0) {
            return dp[start];
        }
        int ans = Integer.MAX_VALUE - 1000;
        for (int i = 1; i <= nums[start]; i++) {
            ans = Math.min(ans, process(nums, start + i, dp) + 1);
            dp[start] = ans;
        }
        dp[start] = ans;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        System.out.println(new Solution().jump(nums));
        System.out.println(new Solution().jump2(nums));
    }
}
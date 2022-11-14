package canJump;

import java.util.Arrays;

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return nums[0] >= 0;
        }
        return process(nums, 0, new Boolean[nums.length + 1]);
    }


    boolean dp(int nums[]) {

        int N = nums.length;
        if (N == 1) {
            return nums[0] >= 0;
        }
        boolean dp[] = new boolean[N + 1];
        dp[N] = true;
        dp[N - 1] = true;

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i] && i + j <= N; j++) {
                if (dp[i + j]) {
                    return true;
                } else {
                    dp[i] |= dp[i + j];
                }
            }
        }
        return dp[0];
    }


    boolean process(int nums[], int start, Boolean dp[]) {
        if (start >= nums.length - 1) {
            dp[start] = true;
            return true;
        }
        if (dp[start] != null) return dp[start];
        int step = nums[start];
        boolean ans = false;
        for (int i = 1; i <= step; i++) {
            ans = process(nums, start + i);
            dp[start] = ans;
            if (dp[start]) {
                return ans;
            }
        }
        dp[start] = ans;
        return ans;
    }


    boolean process(int nums[], int start) {
        if (start >= nums.length - 1) {
            return true;
        }
        int step = nums[start];
        for (int i = 1; i <= step; i++) {
            if (process(nums, start + i)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int nums[] = {1, 3, 2};
        System.out.println(new Solution().canJump(nums));
        System.out.println(new Solution().dp(nums));
    }

}
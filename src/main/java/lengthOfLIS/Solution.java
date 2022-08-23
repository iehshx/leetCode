package lengthOfLIS;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0) return ans;
        if (nums.length == 1) {
            return 1;
        }
        //dp[i] = 以i为结尾 递增子序列是多长 O(n平方)
        //每次遍历到i位置都看前边的小于自己数字的index，取出他之前有几个数字小于他，然后+1 完善自己 ，取max
        int N = nums.length;
        int dp[] = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
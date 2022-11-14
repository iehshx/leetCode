package maxResult;

class Solution {

    public int maxResult(int[] nums, int k) {

        return process(nums, 0, k);

    }

    private int process(int[] nums, int i, int k) {
        if (i >= nums.length) {
            return 0;
        }
        if (i == nums.length - 1) {
            return nums[i];
        }
        int ans = process(nums, i + 1, k) + nums[i];
        ans = i >= 7 ? ans : 0;
        for (int j = 1; j <= Math.min(nums.length - 1, i + k); j++) {
            ans = Math.max(ans, process(nums, i + j, k) + nums[i]);
            ans = (i + j >= 7 ? ans : 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {10, -5, -2, 4, 0, 3};
        int k = 3;
        System.out.println(new Solution().maxResult(nums, k));
    }
}
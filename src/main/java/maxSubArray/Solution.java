package maxSubArray;

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int preMax = 0;
        int ansMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            preMax = Math.max(preMax + nums[i], nums[i]);
            ansMax = Math.max(ansMax, preMax);
        }
        return ansMax;
    }


    public static void main(String[] args) {
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }
}
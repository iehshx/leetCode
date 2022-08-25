package rob3;

class Solution {
    public int rob(int[] nums) {
        return process(nums, 0);
    }

    private int process(int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        int p1 = process(nums, i + 1);//偷下一家
        int p2 = nums[i] + process(nums, i + 2);//偷当前
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        int nums[] = {2, 7, 9, 3, 1};
        System.out.println(new Solution().rob(nums));

    }

}
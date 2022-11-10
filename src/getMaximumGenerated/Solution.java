package getMaximumGenerated;

class Solution {

    public int getMaximumGenerated(int n) {

        int nums[] = new int[n + 1];
        nums[0] = 0;
        if (n == 0) {
            return 0;
        }
        nums[1] = 1;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        process(nums, 1);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }

    private void process(int[] nums, int i) {
        if (i >= nums.length / 2) {
            return;
        }
        nums[i * 2] = nums[i];
        nums[i * 2 + 1] = nums[i] + nums[i + 1];
        process(nums, i + 1);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            int ans = new Solution().getMaximumGenerated(i);
//            System.out.println("i = " + i + "ans = " + ans);
            System.out.println(i % ans);
        }

//        System.out.println((10+2-1)/2);
    }
}
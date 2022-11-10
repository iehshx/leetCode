package missingTwo;

class Solution {
    public int[] missingTwo(int[] nums) {
        int ans[] = new int[2];
        int N = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, nums[i]);
        }
        for (int i = 0; i < N; i++) {
            process(nums, i, max);
        }

        int index = 0;
        for (int i = 0; i < max; i++) {
            if (index < 2 && i + 1 != nums[i]) {
                ans[index++] = i + 1;
            }
        }
        return ans;
    }

    private void process(int[] nums, int i, int max) {
        int swapIndex = nums[i] - 1 - (max - nums.length) >= nums.length ? nums[i] - 1 - (max - nums.length) : nums[i] - 1;

        while (nums[i] != i + 1 && swapIndex <= nums.length && nums[i] != nums[swapIndex]) {
            swap(nums, i,swapIndex);
        }
    }

    private void swap(int[] nums, int a, int b) {
        //nums[1] = 5
        //tmp = nums[5]
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {2, 5, 7, 4, 1};
        int[] ans = new Solution().missingTwo(nums);
        for (int i :
                ans) {
            System.out.println(i);
        }
    }
}
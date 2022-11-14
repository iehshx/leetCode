package findRepeatNumber;

class Solution {
    public int findRepeatNumber(int[] nums) {

        if (nums.length == 2) {
            return nums[0] == nums[1] ? nums[0] : -1;
        }

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return nums[i];
            }
        }

        return -1;

    }

    void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(new Solution().findRepeatNumber(nums));
    }
}
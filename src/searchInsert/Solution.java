package searchInsert;

class Solution {
    public int searchInsert(int[] nums, int target) {
        return process(nums, 0, nums.length - 1, target);
    }

    private int process(int[] nums, int L, int R, int target) {
        if (L == R) {
            if (nums[L] < target) {
                return L + 1;
            } else if (nums[L] > target) {
                return R + 1;
            } else {
                return L;
            }
        }
        int mid = L + ((R - L) / 2);
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            //往右走
            return process(nums, mid + 1, R, target);
        } else {
            //往左走
            return process(nums, L, mid, target);
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5};
        int target = 3;
        System.out.println(new Solution().searchInsert(nums, target));
    }
}
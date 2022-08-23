package thirdMax;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

class Solution {
    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return process(nums, 0, nums.length - 1, 3 - 1);
    }

    private int process(int[] nums, int l, int r, int index) {
        if (l == r) return nums[l];
        int pivot = nums[l + new Random().nextInt() * (r - l + 1)];
        int[] range = partition(nums, l, r, pivot);
        if (index >= range[0] && index <= range[1]) {
            return nums[index];
        } else if (index < range[0]) {
            return process(nums, l, range[0] - 1, index);
        } else {
            return process(nums, range[1] + 1, r, index);
        }
    }

    int[] partition(int[] nums, int l, int r, int pivot) {
        int less = l - 1;
        int more = r + 1;
//        while(less<more){
//            if (nums[less]<pivot){
//                swap(nums,++less,cur++);
//            }
//        }
        return new int[]{less, more};
    }

    public static void main(String[] args) {
        int nums[] = {2, 2, 3, 4, 4, 1};
        System.out.println(new Solution().thirdMax(nums));
    }
}
package containsDuplicate;

import java.util.Set;
import java.util.TreeSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        Set<Integer> map = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.contains(nums[i])) {
                return true;
            }
            map.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Solution().containsDuplicate(nums));
    }
}
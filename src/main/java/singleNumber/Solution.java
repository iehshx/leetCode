package singleNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {

    public int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(new Solution().singleNumber(nums));
    }
}
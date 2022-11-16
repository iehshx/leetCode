package threeSum;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public List<List<Integer>> twoSum(int[] nums, int end, int target) {
        int L = 0;
        int R = end;
        List<List<Integer>> ans = new ArrayList<>();
        while (L < R) {
            if (nums[L] + nums[R] > target) {
                R--;
            } else if (nums[L] + nums[R] < target) {
                L++;
            } else {
                if (L == 0 || nums[L - 1] != nums[L]) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[L]);
                    cur.add(nums[R]);
                    ans.add(cur);
                }
                L++;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        List<List<Integer>> retValue = new ArrayList<List<Integer>>();
//        HashSet<List<Integer>> ret = new HashSet<>();
        int N = nums.length;
        for (int i = N - 1; i >= 0; i--) {
            if (i + 1 <= N - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            List<List<Integer>> nexts = twoSum(nums, i - 1, -nums[i]);
            for (List<Integer> item : nexts) {
                item.add(nums[i]);
                retValue.add(item);
            }
        }
//        retValue.addAll(ret);
        return retValue;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> ans = new Solution().threeSum(nums);
        for (List<Integer> items : ans) {

            for (Integer item : items) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }
}
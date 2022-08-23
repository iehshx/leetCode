package permute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        List<Integer> items = new ArrayList<>();
        for (int item : nums) {
            items.add(item);
        }
        process(nums.length, items, ans, 0);
        return ans;
    }

    public void process(int n, List<Integer> nums, List<List<Integer>> ans, int i) {
        if (i == n) {
            ans.add(copyList(nums));
        }
        for (int j = i; j < n; j++) {
            Collections.swap(nums, i, j);
            process(n, nums, ans, i + 1);
            Collections.swap(nums, i, j);
        }
    }

    private List<Integer> copyList(List<Integer> items) {
        ArrayList<Integer> ret = new ArrayList();
        for (Integer item : items) {
            ret.add(item);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        List<List<Integer>> ans = new Solution().permute(nums);
        for (List<Integer> items : ans) {
            for (Integer item :
                    items) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }
}
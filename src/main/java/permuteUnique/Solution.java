package permuteUnique;

import kotlin.collections.ArraysKt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        process(nums, 0, ans);
        return ans;
    }

    private void process(int[] nums, int i, List<List<Integer>> ans) {
        if (i == nums.length) {
            //收集
            ans.add(copy(nums));
        } else {
            boolean[] visited = new boolean[nums.length];
            for (int j = i; j < nums.length; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    swap(nums, i, j);
                    process(nums, i + 1, ans);
                    swap(nums, i, j);
                }
            }
        }
    }

    private List<Integer> copy(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            ret.add(nums[i]);
        }
        return ret;
    }

    private void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> ans = new Solution().permuteUnique(nums);
        for (List<Integer> items : ans) {
            for (Integer item : items) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }
}
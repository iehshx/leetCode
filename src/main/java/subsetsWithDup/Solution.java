package subsetsWithDup;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        if (nums == null || nums.length == 0) {
            return ans;
        }
        TreeSet<String> map = new TreeSet<>();

        process(nums, 0, ans, new ArrayList<Integer>(), map);
        return ans;
    }

    private void process(int[] nums, int i, List<List<Integer>> ans, ArrayList<Integer> items, TreeSet<String> map) {
        if (i >= nums.length) return;

        process(nums, i + 1, ans, items, map);
        items.add(nums[i]);
        List<Integer> list = copyList(items, map);
        if (list != null)
            ans.add(list);
        process(nums, i + 1, ans, items, map);
        items.remove(items.size() - 1);
    }

    private List<Integer> copyList(List<Integer> items, TreeSet<String> map) {
        List<Integer> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (Integer item : items) {
            ret.add(item);
            sb.append(item);
        }
        if (!map.contains(sb.toString())) {
            map.add(sb.toString());
            return ret;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 2};
//        List<List<Integer>> ans = new Solution().subsetsWithDup(nums);
//        for (List<Integer> items : ans) {
//            for (Integer item :
//                    items) {
//                System.out.print(item + ",");
//            }
//            System.out.println();
//        }

        System.out.println(0/2);
    }
}
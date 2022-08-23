package combinationSum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target <= 0) return ans;
        process(candidates, target, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void process(int[] candidates, int rest, int i, LinkedList<Integer> items, List<List<Integer>> ans) {
        if (i == candidates.length) return;
        if (rest == 0) {
            ans.add(copyList(items));
            return;
        }
        process(candidates, rest, i + 1, items, ans);
        if (rest - candidates[i] >= 0) {
            items.add(candidates[i]);
            process(candidates, rest - candidates[i], i, items, ans);
            items.removeLast();
        }
    }

    private List<Integer> copyList(List<Integer> items) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int item : items) {
            ret.add(item);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new Solution().combinationSum(candidates, target));
    }
}
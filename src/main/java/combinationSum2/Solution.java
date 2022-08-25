package combinationSum2;

import java.util.ArrayList;
import java.util.List;

class Solution {


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        process(candidates, 0, target, ans, new ArrayList<Integer>(), new boolean[candidates.length]);
        return ans;
    }

    private void process(int[] candidates, int i, int rest, List<List<Integer>> ans, List<Integer> items, boolean[] selected) {
        if (i > candidates.length) {
            return;
        }
        if (i == candidates.length) {
            if (rest == 0) {
                ans.add(copy(items));
                return;
            }
        } else {
            if (rest == 0) {
                ans.add(copy(items));
                return;
            }
            process(candidates, i + 1, rest, ans, items, selected);
            items.add(candidates[i]);
            process(candidates, i + 1, rest - candidates[i], ans, items, selected);
            items.remove(items.size() - 1);
        }
    }

    private List<Integer> copy(List<Integer> items) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < items.size(); i++) {
            ret.add(items.get(i));
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
//        int[] candidates = {2,5,2,1,2};
//        int target = 5;
        List<List<Integer>> ans = new Solution().combinationSum2(candidates, target);
        for (List<Integer> items : ans) {
            for (Integer item : items) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }
}
package combine;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n == 1) {
            List<Integer> items = new ArrayList<>();
            items.add(1);
            ans.add(items);
        }

        process(1, n, k, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void process(int start, int n, int k, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() + (n - start + 1) < k) {
            return;
        }
        if (path.size() == k) {
            //收集答案
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(start);
        process(start + 1, n, k, path, ans);
        path.remove(path.size() - 1);
        process(start + 1, n, k, path, ans);

    }


    public static void main(String[] args) {
        int n = 4, k = 2;
        List<List<Integer>> ans = new Solution().combine(n, k);
        for (List<Integer> items : ans) {
            for (Integer item : items) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }
}
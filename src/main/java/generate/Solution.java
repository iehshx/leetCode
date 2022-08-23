package generate;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;
        if (numRows == 1) {
            ArrayList<Integer> items = new ArrayList<>();
            items.add(1);
            ans.add(items);
            return ans;
        }
        //每一行第一个add 1
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> items = new ArrayList<>();
            items.add(1);
            ans.add(items);
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> items = ans.get(i);
            for (int j = 1; j < i; j++) {
                items.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            items.add(1);
        }
        return ans;
    }


    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> ans = new Solution().generate(numRows);
        for (List<Integer> items : ans) {
            for (Integer item : items) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }
}
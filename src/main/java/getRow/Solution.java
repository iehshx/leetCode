package getRow;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        if (rowIndex == 0) return ans;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                ans.set(j, ans.get(j - 1) + ans.get(j));
            }
            ans.add(1);
        }
        return ans;
    }

    public static void main(String[] args) {

        List<Integer> ans = new Solution().getRow(3);
        for (Integer item : ans) {
            System.out.println(item);
        }
    }
}
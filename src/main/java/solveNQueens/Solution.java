package solveNQueens;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n == 1) {
            ArrayList<String> items = new ArrayList<>();
            items.add("Q");
            ans.add(items);
            return ans;
        }

        int[] queuens = new int[n];
        process(n, queuens, 0, ans);
        return ans;
    }

    private List<String> splitList(List<String> list, int groupSize) {
        int length = list.size();
        // 计算可以分成多少组
        int num = (length + groupSize - 1) / groupSize;
        List<String> newList = new ArrayList<>(num);
        for (int i = 0; i < num; i++) {
            // 开始位置
            int fromIndex = i * groupSize;
            // 结束位置
            int toIndex = (i + 1) * groupSize < length ? (i + 1) * groupSize : length;
            List<String> tempList = list.subList(fromIndex, toIndex);
            StringBuilder sb = new StringBuilder();
            for (String item : tempList) {
                sb.append(item);
            }
            newList.add(sb.toString());
        }
        return newList;
    }

    private void process(int n, int[] queuens, int i, List<List<String>> ans) {
        if (i == n) {
            ArrayList<String> items = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    items.add(".");
                }
            }

            for (int j = 0; j < n; j++) {
                items.set(n * j + queuens[j], "Q");
            }

            List<String> tempRets = splitList(items, n);
            ArrayList<String> ret = new ArrayList<>();
            for (String item : tempRets) {
                ret.add(item);
            }
            ans.add(ret);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(queuens, i, j)) {
                queuens[i] = j;
                process(n, queuens, i + 1, ans);
            }
        }
    }

    private boolean isValid(int[] queuens, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == queuens[k] || Math.abs(queuens[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    private List<String> copy(ArrayList<String> items) {
        ArrayList<String> ret = new ArrayList<String>();
        for (int i = 0; i < items.size(); i++) {
            ret.add(items.get(i));
        }
        return ret;
    }

    public static void main(String[] args) {
        List<List<String>> ans = new Solution().solveNQueens(12);
        for (List<String> items : ans) {
            for (String item : items) {
                System.out.println(item);
            }
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
}
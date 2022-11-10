package partition;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        String s = "aa";
        List<List<String>> ans = new Solution().partition(s);
        for (List<String> items : ans) {
            for (String item :
                    items) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }


    private List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() < 2) {
            List<String> cur = new ArrayList<>();
            cur.add(s);
            ans.add(cur);
        } else {
            boolean checkMap[][] = generatePalindromMap(s);
            int[] dp = new int[n + 1];
            dp[n] = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (checkMap[i][n - 1]) {//i到n-1是回文
                    dp[i] = 1;
                } else {
                    int next = Integer.MAX_VALUE;
                    for (int j = i; j < n; j++) {
                        if (checkMap[i][j]) {
                            next = Math.min(next, dp[j + 1]);
                        }
                    }
                    dp[i] = 1 + next;
                }
            }
            process(s, 0, 1, checkMap, dp, new ArrayList<String>(), ans);
        }
        return ans;
    }



    // s[0....i-1]  存到path里去了
    // s[i..j-1]考察的分出来的第一份
    private void process(String s, int i, int j, boolean[][] checkMap, int[] dp, ArrayList<String> path, List<List<String>> ans) {
        if (j == s.length()) {
            if (checkMap[i][j - 1]) {//i...j-1是回文串 并且 当前切割数量和j+1是一样的
                path.add(s.substring(i, j));
                ans.add(copyStringList(path));
                path.remove(path.size() - 1);
            }
        } else {
            if (checkMap[i][j - 1]) {
                path.add(s.substring(i, j));
                process(s, j, j + 1, checkMap, dp, path, ans);
                path.remove(path.size() - 1);
            }
            process(s, i, j + 1, checkMap, dp, path, ans);
        }
    }

    private List<String> copyStringList(List<String> list) {
        List<String> ans = new ArrayList<>();
        for (String str : list) {
            ans.add(str);
        }
        return ans;
    }

    /**
     * 生成回文表
     *
     * @param s
     * @return
     */
    private boolean[][] generatePalindromMap(String s) {
        int n = s.length();
        boolean ans[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length() - 1; i++) {
            ans[i][i] = true;
            ans[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        ans[n - 1][n - 1] = true;
        for (int i = n - 3; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                ans[i][j] = (s.charAt(i) == s.charAt(j) && ans[i + 1][j - 1]);//[i]  == [j] 并且i...j 中间得是回文，我才是回文;
            }
        }
        return ans;
    }
}
package minDistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class Solution {
    public int minDistance(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 0; i < str1.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int lcs = process(str1, str2, str1.length - 1, str2.length - 1, dp);
        return str1.length - lcs + str2.length - lcs;
    }

    int minDistance2(String word1, String word2) {
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        int n = str1.length;
        int m = str2.length;
        int[][] dp = new int[n][m];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[0][i] = str1[0] == str2[i] ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = str1[i] == str2[0] ? 1 : dp[i - 1][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int p1 = dp[i - 1][j];
                int p2 = dp[i][j - 1];
                int p3 = str1[i] == str2[j] ? (1 + dp[i - 1][j - 1]) : 0;
                dp[i][j] = Math.max(Math.max(p1, p2), p3);
            }
        }
        int lcs = dp[str1.length - 1][str2.length - 1];
        return str1.length - lcs + str2.length - lcs;
    }

    int process(char[] chs1, char[] chs2, int i, int j, int dp[][]) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == 0 && j == 0) {
            return chs1[i] == chs2[j] ? 1 : 0;
        }
        if (i == 0) {
            if (chs2[j] == chs1[i]) {
                return 1;
            } else {
                return process(chs1, chs2, i, j - 1, dp);
            }
        } else if (j == 0) {
            if (chs1[i] == chs2[j]) return 1;
            else return process(chs1, chs2, i - 1, j, dp);
        } else {
            int p1 = process(chs1, chs2, i - 1, j, dp);
            int p2 = process(chs1, chs2, i, j - 1, dp);
            int p3 = chs1[i] == chs2[j] ? (1 + process(chs1, chs2, i - 1, j - 1, dp)) : 0;
            int ans = Math.max(p3, Math.max(p1, p2));
            dp[i][j] = ans;
            return ans;
        }
    }

    public static int fixedRange(int Min, int Max) {
//        try {
//            if (Max <= Min) {
//                throw new Exception("输入的范围无效！");
//            }
//        } catch (Exception e) {
//            System.out.println("请检查输入的范围第一个数字是否比第二个小！");
//            System.exit(1);
//        }
        return (int) Math.round(Math.random() * (Max - Min) + Min);
    }

    static ArrayList<String> createRandomString(int maxLen, int maxSame, int count) {
        ArrayList ans = new ArrayList<String>(count);
        for (int i = 0; i < count; i++) {
            int len = fixedRange(4, maxLen);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                sb.append((char) ('a' + fixedRange(0, 25)));
            }
            int same = fixedRange(1, maxSame);
            for (int z = 0; z < same; z++) {
                sb.insert(fixedRange(1, sb.length() - 1), sb.charAt(fixedRange(1, sb.length() - 1)));
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        String word1 = "01111";
        String word2 = "10101";
        System.out.println(new Solution().minDistance(word1, word2));
//        == new Solution().minDistance2(word1,word2));
        ArrayList<String> ans = createRandomString(10, 3, 100);
        Solution solution = new Solution();
        for (String item : ans) {
            if (solution.minDistance(item, item) != solution.minDistance2(item, item)) {
                System.out.println("ops!");
            }
        }
    }
}
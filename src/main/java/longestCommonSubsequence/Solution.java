package longestCommonSubsequence;

import java.util.Arrays;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int N = text1.length();
        int M = text2.length();
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int dp[][] = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        return process2(str1, str2, N - 1, M - 1, dp);
    }


    public int dp(String text1, String text2) {

        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        int N = text1.length();
        int M = text2.length();
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int dp[][] = new int[N][M];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        for (int i = 1; i < M; i++) {
            if (str1[0] == str2[i]) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }
        for (int i = 1; i < N; i++) {
            if (str1[i] == str2[0]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int p1 = dp[i][j - 1];
                int p2 = dp[i - 1][j];
                int p3 = str1[i] == str2[j] ? (1 + dp[i - 1][j - 1]) : 0;
                dp[i][j] = Math.max(Math.max(p1, p2), p3);
            }
        }
        return dp[N - 1][M - 1];
    }


    private int process2(char[] str1, char[] str2, int i, int j, int dp[][]) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans;
        if (i == 0 && j == 0) {
            ans = str1[i] == str2[j] ? 1 : 0;
            dp[i][j] = ans;
            return ans;
        } else if (i == 0) {
            if (str1[i] == str2[j]) {
                dp[i][j] = 1;
                return 1;
            }
            ans = process(str1, str2, i, j - 1);
            dp[i][j] = ans;
            return ans;
        } else if (j == 0) {
            if (str1[i] == str2[j]) {
                dp[i][j] = 1;
                return 1;
            }
            ans = process(str1, str2, i - 1, j);
            dp[i][j] = ans;
            return ans;
        } else {
            int p1 = process(str1, str2, i, j - 1);
            int p2 = process(str1, str2, i - 1, j);
            int p3 = str1[i] == str2[j] ? (1 + process(str1, str2, i - 1, j - 1)) : 0;
            ans = Math.max(Math.max(p1, p2), p3);
            dp[i][j] = ans;
            return ans;
        }
    }

    private int process(char[] str1, char[] str2, int i, int j) {
        if (i == 0 && j == 0) {
            return str1[i] == str2[j] ? 1 : 0;
        } else if (i == 0) {
            if (str1[i] == str2[j]) {
                return 1;
            }
            return process(str1, str2, i, j - 1);
        } else if (j == 0) {
            if (str1[i] == str2[j]) {
                return 1;
            }
            return process(str1, str2, i - 1, j);
        } else {
            int p1 = process(str1, str2, i, j - 1);
            int p2 = process(str1, str2, i - 1, j);
            int p3 = str1[i] == str2[j] ? (1 + process(str1, str2, i - 1, j - 1)) : 0;
            return Math.max(Math.max(p1, p2), p3);
        }
    }

    public static void main(String[] args) {
//        "abcde"
//        "ace"
        String text1 = "ace", text2 = "abcde";
        System.out.println(new Solution().longestCommonSubsequence(text1, text2));
        System.out.println(new Solution().dp(text1, text2));

    }
}
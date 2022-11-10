package numDistinct;

import java.util.Arrays;

class Solution {

    int numDistinct2(String s, String t) {
        char[] sStr = s.toCharArray();
        char[] tStr = s.toCharArray();
        int dp[][] = new int[sStr.length][tStr.length + 1];

        for (int i = 0; i < sStr.length; i++) {
            Arrays.fill(dp[i], -1);
            dp[i][tStr.length] = 1;
        }

        for (int i = 0; i < sStr.length; i++) {
            if (sStr[i] == tStr[0]) {
                for (int j = i; j < sStr.length; j++) {
                    int ans = 0;
                    for (int z = j; z < sStr.length; z++) {
                        if (sStr[j] == tStr[z]) {
                            if (dp[i][j] != -1) {
                                ans += dp[j][z];
                                continue;
                            }
                        }
                        int ret = dp[j + 1][z + 1];
                        ans += ret;
                        dp[i][j] = ans;
                    }
                    dp[i][0] = ans;
                }
            }
        }
        return dp[0][0];
    }


    private int process(char[] sStr, int k, char[] tStr, int j, int dp[][]) {
        if (j == tStr.length) {
            return 1;
        }
        int ans = 0;
        for (int i = k; i < sStr.length; i++) {//从当前位置往后开始尝试 如果 字符相等就继续 不相等就过
            if (sStr[i] == tStr[j]) {
                if (dp[i][j] != -1) {
                    ans += dp[i][j];
                    continue;
                }
                int ret = process(sStr, i + 1, tStr, j + 1, dp);
                dp[i][j] = ret;
                ans += dp[i][j];
            }
        }
        return ans;
    }

    public int numDistinct(String s, String t) {
        char[] sStr = s.toCharArray();
        char[] tStr = t.toCharArray();

        int count = 0;
        int sum = 0;
        int[][] dp = new int[sStr.length][tStr.length];
        for (int i = 0; i < sStr.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < sStr.length; i++) {//每一个位置往后开始尝试
            if (sStr[i] == tStr[0]) {
                int ret = process(sStr, i + 1, tStr, count + 1, dp);//计算s的第i个字母作为t的第count位有多少解
                dp[i][0] = ret;//存起来
                sum += ret;//求和便是最终答案
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {

        String s = "rabbbit", t = "rabbit";
        System.out.println(new Solution().numDistinct(s, t));
    }
}
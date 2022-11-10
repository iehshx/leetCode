package longestValidParentheses;

import java.util.Random;

class Solution {

    int ans = Integer.MIN_VALUE;

    int longestValidParentheses2(String s) {
        if (s == null || s.length() < 2) return 0;
        char[] str = s.toCharArray();
        process(str, s.length() - 1, new int[str.length]);
        return ans;
    }

    private int process(char[] str, int i) {
        if (i <= 0) return 0;
        int cur = 0;
        if (str[i] == ')') {//左边都是结算过的
            int left = process(str, i - 1);
            int pre = i - left - 1;
            if (pre >= 0 && str[pre] == '(') {
                cur = left + 2 + (pre > 0 ? process(str, pre - 1) : 0);
            }
        } else {
            process(str, i - 1);
        }
        ans = Math.max(ans, cur);
        return cur;
    }

    private int process(char[] str, int i, int[] dp) {
        if (i <= 0) return 0;
        if (dp[i] != 0) return dp[i];
        int cur = 0;
        if (str[i] == ')') {//左边都是结算过的
            int left = process(str, i - 1,dp);
            int pre = i - left - 1;
            if (pre >= 0 && str[pre] == '(') {
                cur = left + 2 + (pre > 0 ? process(str, pre - 1,dp) : 0);
                dp[i] = cur;
            }
        } else {
            process(str, i - 1, dp);
        }
        ans = Math.max(ans, cur);
        return cur;
    }


    // 思路：以i开始往左走都是有效的 从length开始，所有的子长度中求max。如上图
    int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        char[] str = s.toCharArray();
        //dp[i] 字串必须以i为结尾往左最多有多少的有效区域
        int[] dp = new int[str.length];
        int pre, ans = 0;
        for (int i = 1; i < str.length; i++) {//0位置肯定是0
            if (str[i] == ')') {
                pre = i - dp[i - 1] - 1;//与str[i] 配对的左括号的位置
                if (pre >= 0 && str[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    static java.lang.String createRandomString(int len) {
        Random random = new Random();
        char[] ans = new char[len];
        for (int i = 0; i < len; i++) {
            if (random.nextBoolean()) {
                ans[i] = '(';
            } else {
                ans[i] = ')';
            }
        }
        return java.lang.String.valueOf(ans);
    }


    public static void main(String[] args) {
        for (int i = 0; i < Math.pow(10, 6); i++) {
            String s = createRandomString(new Random().nextInt(2000));
            if (new Solution().longestValidParentheses(s) != new Solution().longestValidParentheses2(s)) {
                System.out.println("出错了");
            }
        }
    }
}
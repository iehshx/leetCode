package isMatch;

class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return false;
        char[] str = s.toCharArray();
        char[] exp = p.toCharArray();
        Boolean dp[][] = new Boolean[str.length + 1][exp.length + 1];
        return process(str, exp, 0, 0, dp);
    }

    private boolean process(char[] s, char[] e, int strIndex, int expIndex, Boolean[][] dp) {
        if (dp[strIndex][expIndex] != null) {
            return dp[strIndex][expIndex];
        }
        boolean ans;
        if (expIndex == e.length) {
            ans = strIndex == s.length;//str是否到结束了
            dp[strIndex][expIndex] = ans;
            return ans;
        }
        if (expIndex + 1 == e.length || e[expIndex + 1] != '*') {//exp最后一个字符 或者下一个字符不是* 正常比对
            return strIndex != s.length && (e[expIndex] == s[strIndex] || e[expIndex] == '.') && process(s, e, strIndex + 1, expIndex + 1, dp);//还可以比对字符
        }
        while (strIndex != s.length && (e[expIndex] == s[strIndex] || e[expIndex] == '.')) {
            if (process(s, e, strIndex, expIndex + 2, dp)) {
                dp[strIndex][expIndex + 2] = true;
                return true;
            }
            strIndex++;
        }
        ans = process(s, e, strIndex, expIndex + 2, dp);
        dp[strIndex][expIndex] = ans;
        return ans;
    }

    public static void main(String[] args) {
        String s = "aa", p = "a";
        System.out.println(new Solution().isMatch(s, p));
    }
}
package isSubsequence;

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return true;
        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();
        return process(chs1, chs2, 0, 0);
    }

    private boolean process(char[] chs1, char[] chs2, int i1, int i2) {
        if (i1 == chs1.length) {
            return true;
        }
        if (i2 == chs2.length) {
            return false;
        }
        if (chs1[i1] == chs2[i2]) {
            return process(chs1, chs2, i1 + 1, i2 + 1);
        } else {
            return process(chs1, chs2, i1, i2 + 1);
        }
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(new Solution().isSubsequence(s, t));
    }
}
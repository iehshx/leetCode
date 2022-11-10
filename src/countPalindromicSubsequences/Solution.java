package countPalindromicSubsequences;

import java.util.HashSet;

class Solution {
    public int countPalindromicSubsequences(String s) {

        int ans = 0;

        return ways1(s) - 1;
    }


    public static int ways1(String str) {

        if (str == null || str.length() == 0) {

            return 0;

        }

        char[] s = str.toCharArray();

        char[] path = new char[s.length];

        return process(str.toCharArray(), 0, path, 0, new HashSet<String>());

    }


    public static int process(char[] s, int si, char[] path, int pi, HashSet<String> map) {

        if (si == s.length) {
            boolean p = isP(path, pi);
            if (p) {
                if (!map.contains(String.valueOf(path))) {
                    map.add(String.valueOf(path));
                    return 1;
                }
            }
            return 0;
        }

        int ans = process(s, si + 1, path, pi, map);

        path[pi] = s[si];

        ans += process(s, si + 1, path, pi + 1, map);

        return ans;

    }


    public static boolean isP(char[] path, int pi) {

        if (pi == 0) {

            return false;

        }

        int L = 0;

        int R = pi - 1;

        while (L < R) {

            if (path[L++] != path[R--]) {

                return false;

            }

        }

        return true;

    }


    public static void main(String[] args) {
        String s = "bccb";
        System.out.println(new Solution().countPalindromicSubsequences(s));
    }
}
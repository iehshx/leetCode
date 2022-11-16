package addBinary;

import java.text.DecimalFormat;
import java.util.Arrays;

class Solution {
    public String addBinary(String a, String b) {
        if (a.isEmpty()) {
            return b;
        }
        if (b.isEmpty()) {
            return a;
        }
        char[] strA = a.toCharArray();
        char[] strB = b.toCharArray();

        char[] shortStr = strA.length < strB.length ? strA : strB;
        char[] longStr = shortStr == strB ? strA : strB;
        char[] ans = new char[Math.max(strA.length, strB.length) + 1];
        int jw = 0;
        int i = 0;
        //从末尾开始
        int shortLen = shortStr.length - 1;
        int longLen = longStr.length - 1;
        while (shortLen >= 0) {
            if (longStr[longLen] == '1' && shortStr[shortLen] == '1') {
                ans[i++] = jw == 1 ? '1' : '0';
                jw = jw == 1 ? 1 : 1;
            } else if (longStr[longLen] == '0' && shortStr[shortLen] == '0') {
                ans[i++] = jw == 1 ? '1' : '0';
                jw = 0;
            } else {
                ans[i++] = jw == 1 ? '0' : '1';
                jw = jw == 1 ? 1 : 0;
            }
            longLen--;
            shortLen--;
        }
        while (longLen >= 0) {
            if (jw == 1 && longStr[longLen] == '1') {
                jw = 1;
                ans[i++] = '0';
            } else if (jw == 1 && longStr[longLen] == '0') {
                jw = 0;
                ans[i++] = '1';
            } else {
                ans[i++] = longStr[longLen];
            }
            longLen--;
        }
        ans[i] = jw == 1 ? '1' : '0';
        ans = Arrays.copyOfRange(ans, 0, jw == 1 ? ans.length : ans.length - 1);
        reverse(ans);
        return new String(ans);
    }

    void reverse(char[] chs) {
        int L = 0;
        int R = chs.length - 1;
        while (L < R) {
            swap(chs, L++, R--);
        }
    }

    void swap(char[] chs, int a, int b) {
        char temp = chs[a];
        chs[a] = chs[b];
        chs[b] = temp;
    }

    public static void main(String[] args) {
        String a = "110010", b = "10111";
        System.out.println(new Solution().addBinary(a, b));
    }
}
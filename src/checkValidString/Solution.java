package checkValidString;

import java.util.HashMap;

class Solution {


    public boolean process2(String s) {
        int maxOpen = 0, minOpen = 0;  // 分别代表左括号可能的最大数，最小数
        for (char c : s.toCharArray()) {
            if (c == '(') {
                maxOpen++;
                minOpen++;
            } else if (c == ')') {
                maxOpen--;
                minOpen--;
            } else if (c == '*') {
                maxOpen++;   // 让 * 变成左括号
                minOpen--;   // 让 * 变成右括号
            }
            if (maxOpen < 0) return false;
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0; // 有可能把左括号抵消为0，有效
    }


    public boolean checkValidString(String s) {
        char[] str = s.toCharArray();
        HashMap<String, Boolean> dp = new HashMap<>();
        return process(str, 0, 0);
    }

    private boolean process(char[] str, int i, int count) {
        boolean ans = false;
        if (count < 0) return false;
        for (int j = i; j < str.length; j++) {
            char c = str[j];
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            } else if (c == '*') {
                ans = process(str, i + 1, count + 1)//当成左括号
                        || process(str, i + 1, count - 1)//当成右括号
                        || process(str, i + 1, count);//当成*
                return ans;
            }
        }
        ans = count == 0;
        return ans;
    }

    public static void main(String[] args) {
        String s = "()(*)";
        System.out.println(new Solution().process2(s));
    }
}
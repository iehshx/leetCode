package calculate;

import java.util.Stack;

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        return 0;
        //6*3 + 2
    }

    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(new Solution().calculate(s));
    }
}
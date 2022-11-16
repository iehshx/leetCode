package romanToInt;

class Solution {
    //
//    输入: s = "MCMXCIV"
//    输出: 1994
    public int romanToInt(String s) {
        char[] chs = s.toCharArray();
        int ans = 0;
        int pre = valueOf(chs[0]); //1000
        for (int i = 1; i < chs.length; i++) {
            int value = valueOf(chs[i]);
            if (pre < value) {
                ans -= pre;
            } else {
                ans += pre;
            }
            pre = value;
        }
        ans += pre;
        return ans;
    }


    int valueOf(char ch) {
        switch (ch) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
        return 0;
    }


    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "III";
        System.out.println(new Solution().romanToInt(s));
    }
}
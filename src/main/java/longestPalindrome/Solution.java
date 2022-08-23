package longestPalindrome;

class Solution {
    //    public int longestPalindrome(String s) {
//        if (s == null || s.length() == 0 || s.length() == 1) return 1;
//        char[] chs = s.toCharArray();
//        return process(chs, 0, chs.length - 1);
//    }
//
//    private int process(char[] chs, int start, int end) {
//        if (start == end) {
//            return 1;
//        }
//        if (start == end - 1) {
//            return chs[start] == chs[end] ? 2 : 1;
//        }
//        int p1 = process(chs, start + 1, end - 1);
//        int p2 = process(chs, start, end - 1);
//        int p3 = process(chs, start + 1, end);
//        int p4 = chs[start] == chs[end] ? process(chs, start + 1, end - 1) + 2 : 0;
//        return Math.max(p1, Math.max(p2, Math.max(p3, p4)));
//    }
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) return 1;
        char[] chs = s.toCharArray();
        int[] count = new int[128];
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i];
            count[index]++;
        }
        int ans = 0;
        for (int i = 0; i < count.length; i++) {
            ans += count[i] % 2;
        }
        return ans == 0?chs.length:(chs.length - ans +1);
    }

    public static void main(String[] args) {
        String s = "abccccdd";
//        System.out.println(0 % 2);
//        for (int i = 0; i < 53; i++) {
//            System.out.println('A' + i - 6 - 59);
//        }
//        System.out.println('z' - 'A');
        System.out.println(new Solution().longestPalindrome(s));
    }
}
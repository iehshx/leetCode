package removeDuplicateLetters;

class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return "";
        char[] chs = s.toCharArray();
//        return process(chs,0,);
        return "";
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(new Solution().removeDuplicateLetters(s));
    }
}
package findTheDifference;

class Solution {
    public char findTheDifference(String s, String t) {
        char[] chs1 = s.toCharArray();
        char[] chs2 = t.toCharArray();
        if (chs1.length == 0) return chs2[0];
        int[] chrs = new int[26];
        for (int i = 0; i < chs1.length; i++) {
            chrs[chs1[i]-'a']++;
        }
        for (int i = 0; i < chs2.length; i++) {
            chrs[chs2[i]-'a']++;
        }

        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == 1) {
                return chs2[i];
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        String s = "", t = "y";
        System.out.println(new Solution().findTheDifference(s, t));
    }
}
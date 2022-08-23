package lengthOfLastWord;

class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        char[] chs = s.toCharArray();
        int ans = 0;
        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] == ' ') {
                if (ans == 0) {
                    continue;
                }
                return ans;
            } else {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "a ";
        System.out.println(new Solution().lengthOfLastWord(s));
    }
}
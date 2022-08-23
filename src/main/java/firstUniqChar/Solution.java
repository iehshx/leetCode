package firstUniqChar;

class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int map[] = new int[26];
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            int index = chs[i] - 'a';
            map[index] = ++map[index];
        }
        int index = -1;
        for (int i = 0; i < map.length; i++) {
            if (map[i] == 1) {
                index = i;
            }
        }
        if (index > -1) {
            for (int i = 0; i < chs.length; i++) {
                if ((int) chs[i] == 'a' + index) {
                    return i;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new Solution().firstUniqChar(s));
    }
}
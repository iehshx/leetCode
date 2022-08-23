package reverseString;

class Solution {
    public void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        process(s, 0, s.length - 1);
    }

    private void process(char[] s, int start, int end) {
        if (start < end && start >= 0 && end < s.length) {
            swap(s, start, end);
            process(s, start + 1, end - 1);
        } else {
            return;
        }
    }

    private void swap(char[] s, int a, int b) {
        char temp = s[a];
        s[a] = s[b];
        s[b] = temp;
    }

    public static void main(String[] args) {
        char[] s ={'H','a','n','n','a','h'};
        new Solution().reverseString(s);
        System.out.println(String.valueOf(s));
    }
}
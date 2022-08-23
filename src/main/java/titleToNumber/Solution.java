package titleToNumber;

class Solution {
    public long titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.length() == 0) return 0;
        char[] chs = columnTitle.toCharArray();
        long ans = 0;
        int multiple = 1;
        for (int i = chs.length - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            ans += k * multiple;
            multiple *= 26;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("FXSHRXW"));
    }
}
package numWays;

class Solution {
    public int numWays2(int n) {
        if (n < 2) return 1;
        int first = 1;
        int sec = 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (first + sec) % 1000000007;
            first = sec;
            sec = ans;
        }
        return ans;
    }

    public int numWays(int n) {
        if (n <= 0) {
            return 1;
        }
        return process(0, n);
    }

    private int process(int start, int end) {
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        int p1 = process(start + 1, end);
        int p2 = process(start + 2, end);
        return p1 + p2;
    }


    public static void main(String[] args) {
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println(new Solution().numWays2(7));
        for (int i = 0; i < 20; i++) {
            System.out.println(new Solution().numWays(i) == new Solution().numWays2(i));
//            System.out.println(new Solution().numWays(i));
        }
    }
}
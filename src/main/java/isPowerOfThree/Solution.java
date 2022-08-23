package isPowerOfThree;

class Solution {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree2(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 3) return false;
        int i = 3;
        while (i <= n) {
            if (i == n) return true;
            i *= 3;
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000000000; i++) {
            if (new Solution().isPowerOfThree(i) != new Solution().isPowerOfThree2(i))
                System.out.println(i);
        }
    }
}
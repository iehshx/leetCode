package isPowerOfTwo;

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0 || n < 0) {
            return false;
        }
        int count = 0;
        while (n > 0) {
            if ((n & -n) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count == 1;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(Integer.toBinaryString(i));
//        }
//        System.out.println(Integer.toBinaryString(3));
        System.out.println(new Solution().isPowerOfTwo(32));
    }
}
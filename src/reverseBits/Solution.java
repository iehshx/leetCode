package reverseBits;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int tmp = n;
        int[] stack = new int[32];
        int i = 0;
        while (i < 32) {
            stack[i++] = (tmp % 2);
            tmp >>= 1;
        }

        int res = 1;
        if (n > 0) {
            i--;
            while (i >= 0) {
                if (stack[i] == 1) {
                    res += Math.pow(2, 31 - i);
                }
                i--;
            }
        } else {
            i--;
            while (i >= 0) {
                if (stack[i] == -1) {
                    res += Math.pow(2, 31 - i);
                }
                i--;
            }
        }
        return res - 1;
    }

    public static void main(String[] args) {
        int n = 1175;
//        int m =   3221225471;
        System.out.println(new Solution().reverseBits(n));
    }
}
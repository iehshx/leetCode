package reverseBits2;

class Solution {

    int ans = Integer.MIN_VALUE;

    public int reverseBits(int num) {
        if (num == 0) return 1;
        int[] bits = new int[32];
        int i = 0;
        while (i < bits.length) {
            bits[i++] = (num & 1);
            num >>= 1;
        }
        process(bits, 0, 0, false);
        return ans;
    }

    private void process(int[] bits, int i, int count, boolean isUse) {
        if (i >= bits.length - 1) {
            ans = Math.max(count, ans);
            return;
        }
        int j = i;
        while (j < bits.length && bits[j] == 1) {
            count++;
            j++;
        }
        ans = Math.max(ans, count);
        if (isUse) {
            return;
        } else {
            if (j < bits.length && bits[j] == 0) {
                //当前位置变1
                int temp = bits[i];
                bits[i] = 1;
                process(bits, j + 1, count + 1, true);
                bits[i] = temp;
            }
        }
        process(bits, i + 1, 0, false);
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE > 2147482622);
        System.out.println(new Solution().reverseBits(2147483647));
    }
}
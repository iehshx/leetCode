package reachNumber;

class Solution {
    public int reachNumber(int target) {
        if (target == 0) {
            return 0;
        }
        return process(0, 1, target);
    }

    private int process(int cur, int i, int target) {
        System.out.println(cur);
        if (cur>target) {
            return Integer.MAX_VALUE;
        }
        if (cur == target) {
            return 0;
        }
        //往前走i+步
        int p1 = process(cur + i, i + 1, target);
        if (p1 != Integer.MAX_VALUE) {
            return p1 + 1;
        }

        //0-1 = -1  -1+2 = 1  1+3
        //往后走i+1步
        int p2 = process(cur - i, i + 1, target);
        if (p2 != Integer.MAX_VALUE) {
            return p2 + 1;
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int target = -1;
        System.out.println(new Solution().reachNumber(target));
    }
}
package waysToStep;

class Solution {
    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 1;
        }
        return waysToStep(n - 1) + waysToStep(n - 2) + waysToStep(n - 3);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution().waysToStep(n));
    }
}
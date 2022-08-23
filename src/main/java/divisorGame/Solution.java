package divisorGame;

class Solution {
    public boolean divisorGame(int n) {
        //0<x<n  n%x == 0
        // n = n-x;
        if (n == 1) {
            return false;
        }
        if (n <= 2) {
            return true;
        }
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                return !divisorGame(n - i);
            }
        }
        return false;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            if (new Solution().divisorGame(i) != (i %2 == 0)){
                System.out.println("出错了");
            }
//            System.out.println(" " + i + " = " + new Solution().divisorGame(i));
        }
    }
}
package addDigits;

class Solution {
    public int addDigits(int num) {
        if (num <= 0) {
            return 0;
        }
        if (num < 9) {
            return num;
        }
        int ans = 0;
        while (num >= 0) {
            if (num == 0) {
                if (ans > 9) {
                    num = ans;
                    ans = 0;
                    continue;
                } else {
                    break;
                }
            }
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }

    public static int fib(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibN = Math.pow((1 + sqrt5) / 2, n) - Math.pow((1 - sqrt5) / 2, n);
        return (int) Math.round(fibN / sqrt5);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().addDigits(0));
        for (int i = 1; i < 10; i++) {
            System.out.println(fib(i));
        }
    }
}
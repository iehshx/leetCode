package countchar;

public class Demo {

    public static int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int first = 1;
        int sec = 1;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = first + sec;
            first = sec;
            sec = cur;
        }
        return cur;
    }

    public static int fib2(int n) {
        return process(n);
    }

    public int mySqurt(int x) {

        long left = 0, right = x, ans = 1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int) ans;
    }

    private static int process(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 1;
        return process(n - 1) + process(n - 2);

    }


    public static void main(String[] args) {
//        for (int i = 1; i < 10; i++) {
//            System.out.println(fib(i));
//            System.out.println(fib2(i));
//        }

        System.out.println(new Demo().mySqurt(13));
    }
}

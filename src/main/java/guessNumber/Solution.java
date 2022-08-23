package guessNumber;

/**
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is lower than the guess number
 * 1 if num is higher than the guess number
 * otherwise return 0
 * int guess(int num);
 */

abstract class GuessGame {
    public int guess(int num) {
        if (6 < num) {
            return -1;
        } else if (num == 6) {
            return 0;
        } else {
            return 1;
        }
    }
}

public class Solution extends GuessGame {


    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) <= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().guessNumber(10));
    }
}
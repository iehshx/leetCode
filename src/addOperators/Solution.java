package addOperators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ret = new LinkedList<>();
        if (num.length() == 0) {
            return ret;
        }
        char[] path = new char[num.length() * 2 - 1];
        char[] digits = num.toCharArray();
        long n = 0;
        for (int i = 0; i < digits.length; i++) { // 0~i作为前缀
            n = n * 10 + digits[i] - '0';
            path[i] = digits[i];
            process(digits, i + 1, i + 1, 0, n, target, path, ret);
            if (n == 0) {
                break;
            }
        }
        return ret;
    }

    private void process(char[] nums, int index, int len, long left, long cur, int target, char[] path, List<String> ans) {
        if (index == nums.length) {
            if (left + cur == target) {
                ans.add(new String(path, 0, len));
            }
            return;
        }
        long n = 0;
        int j = len + 1;
        for (int i = index; i < nums.length; i++) {
            // num[index...i] 作为第一个数字
            n = n * 10 + nums[i] - '0';
            path[j++] = nums[i];
            path[len] = '+';
            process(nums, i + 1, j, left + cur, n, target, path, ans);
            path[len] = '-';
            process(nums, i + 1, j, left + cur, -n, target, path, ans);
            path[len] = '*';
            process(nums, i + 1, j, left, cur * n, target, path, ans);
            if (nums[index] == '0') break;
        }

    }


    public static void main(String[] args) {
        String num = "123";
        int target = 6;
        List<String> ans = new Solution().addOperators(num, target);
        for (String item : ans) {
            System.out.println(item);
        }
    }
}
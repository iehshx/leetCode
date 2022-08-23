package combinationSum5;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < 0) return 0;
        return process(nums, 0, target);
    }

    private int process(int[] nums, int i, int rest) {
        if (rest < 0) {
            return Integer.MAX_VALUE;
        }
        if (i == nums.length) {
            return rest == 0 ? 1 : Integer.MAX_VALUE;
        } else {
            int ans = Integer.MAX_VALUE;
            for (int j = 0; j * nums[i] <= rest; j++) {
                int next = process(nums, i + 1, rest - j * nums[i]);
                if (next != Integer.MAX_VALUE) {
                    return Math.min(ans, next + j);
                }
            }
            return ans;
        }
    }


    int dp(int arr[], int aim) {
        if (arr.length < 0 || arr == null || aim <= 0) {
            return 0;
        }
        int n = arr.length;
        int[][] dp = new int[n + 1][aim + 1];
        dp[n][0] = 1;
        for (int index = n - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    ways += dp[index + 1][rest - (zhang * arr[index])];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(new Solution().combinationSum4(nums, target));
        System.out.println(new Solution().dp(nums, target));
    }
}
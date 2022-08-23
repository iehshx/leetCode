package combinationSum4;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target <= 0) return 1;
        if (nums.length == 1) {
            if (nums[0] > target) return 0;
        }
        process(nums, 0, target);
        return mAns;
    }

    int mAns = 0;

    private void process(int[] nums, int i, int rest) {
        if (i >= nums.length) return;
        if (rest == 0) {
            mAns += 1;
        }
        process(nums, i + 1, rest);//不要当前位置
        process(nums, i + 1, rest - nums[i]);//要当前位置
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
//        int[] nums = {};
        int target = 4;
//        int target = 3;
        System.out.println(new Solution().dp(nums, target));
        System.out.println(new Solution().combinationSum4(nums, target));
    }
}
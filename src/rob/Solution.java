//package rob;
//
//import java.util.Arrays;
//import java.util.Random;
//
//class Solution {
//    public int rob(int[] nums) {
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, -1);
//        return process(nums, 0, dp);
//    }
//
//    public int rob2(int[] nums) {
//        int N = nums.length;
//        int dp[] = new int[N];
//        dp[N - 1] = nums[N - 1];
//        dp[N - 2] = Math.max(nums[N - 1], nums[N - 2]);
//        for (int i = N - 3; i >= 0; i--) {
//            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
//        }
//        return dp[0];
//    }
//
//    private int process(int[] nums, int i, int[] dp) {
//        if (i >= nums.length) return 0;
//        if (dp[i] != -1) {
//            return dp[i];
//        }
//        //不从当前位置偷
//        int p1 = process(nums, i + 1, dp);
//        //从当前位置偷
//        int p2 = nums[i] + process(nums, i + 2, dp);
//        dp[i] = Math.max(p1, p2);
//        return dp[i];
//    }
//
//
//    static int[] createRandomArray(int start, int end, int len) {
//        int ret[] = new int[len];
//        Random random = new Random();
//        for (int i = 0; i < len; i++) {
//            ret[i] = random.nextInt(end+1) + start;
//        }
//        return ret;
//    }
//
//
//    public static void main(String[] args) {
//
//        for (int i = 0; i < 10000000; i++) {
//            int nums [] = createRandomArray(0,400,100);
//            if (new Solution().rob(nums) != new Solution().rob2(nums)){
//                System.out.println("出错了");
//            }
//        }
//    }
//}
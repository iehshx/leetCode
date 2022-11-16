package maxUncrossedLines;

class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        return process(nums1, nums1.length - 1, nums2, nums2.length - 1);
    }

    int dp(int nums1[], int nums2[]) {
        int N = nums1.length;
        int M = nums2.length;
        int[][] dp = new int[N][M];
        dp[0][0] = nums1[0] == nums2[0] ? 1 : 0;
        for (int i = 1; i < M; i++) {
            dp[0][i] = nums1[0] == nums2[i] ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < N; i++) {
            dp[i][0] = nums1[i] == nums2[0] ? 1 : dp[i - 1][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                int p1 = dp[i - 1][j];
                int p2 = nums1[i] == nums2[j] ? (1 + dp[i - 1][j - 1]) : 0;
                int p3 = dp[i][j - 1];
                dp[i][j] = Math.max(p3, Math.max(p1, p2));
            }
        }
        return dp[N - 1][M - 1];
    }

    private int process(int[] nums1, int i, int[] nums2, int j) {
        int ans = 0;
        if (i == 0 && j == 0) {
            ans = nums1[i] == nums2[i] ? 1 : 0;
        } else if (i == 0) {//1先到
            if (nums1[i] == nums2[j]) {
                ans = 1;
                return ans;
            }
            ans = process(nums1, i, nums2, j - 1);
        } else if (j == 0) {//2先到
            if (nums1[i] == nums2[j]) {
                return 1;
            }
            ans = process(nums1, i - 1, nums2, j);
        } else {
            int p1 = process(nums1, i - 1, nums2, j);
            int p2 = process(nums1, i, nums2, j - 1);
            int p3 = nums1[i] == nums2[j] ? (1 + process(nums1, i - 1, nums2, j - 1)) : 0;
            ans = Math.max(p3, Math.max(p1, p2));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 5, 1, 2, 5};
        int[] nums2 = {10, 5, 2, 1, 5, 2};
        System.out.println(new Solution().maxUncrossedLines(nums1, nums2));
        System.out.println(new Solution().dp(nums1, nums2));
    }
}
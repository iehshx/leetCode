package candy;

class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int N = ratings.length;
        int[] left = new int[N];
        left[0] = 1;
        for (int i = 1; i < N; i++) {
            left[i] = ratings[i] <= ratings[i - 1] ? 1 : left[i - 1] + 1;
        }
        int[] right = new int[N];
        right[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            right[i] = ratings[i] <= ratings[i + 1] ? 1 : right[i + 1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += Math.max(left[i], right[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] ratings = {1, 2, 2};
        //   1,2,2
        // 2 , 1 ,1
        System.out.println(new Solution().candy(ratings));
    }
}

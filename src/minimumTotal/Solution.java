package minimumTotal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() > 1) {
            int dp[][] = new int[triangle.size()][triangle.size()];
            for (int i = 0; i < dp.length; i++) {
                Arrays.fill(dp[i], Integer.MIN_VALUE);
            }
            int ans = process(triangle, 0, 0, dp);
            return ans != Integer.MAX_VALUE ? ans : triangle.get(0).get(0);
        } else {
            return triangle.get(0).get(0);
        }
    }

    /**
     * i是行
     * j是列
     *
     * @param triangle
     * @param i
     * @param j
     * @return
     */
    private int process(List<List<Integer>> triangle, int i, int j, int dp[][]) {
        if (i == triangle.size()) {
            return 0;
        }
        if (dp[i][j] != Integer.MIN_VALUE) {
            return dp[i][j];
        }
        int ans = 0;
        int p1 = process(triangle, i + 1, j, dp);//下一行的当前位置
        int p2 = process(triangle, i + 1, j + 1, dp);//下一行的i+1位置
        ans = triangle.get(i).get(j) + Math.min(p1, p2);
        dp[i][j] = ans;
        return dp[i][j];
    }

    public static void main(String[] args) {
//        int[][] triangle = {{-1}, {2, 3}, {1, -1, -3}};
//        int[][] triangle = {{-10}};
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};

        List<List<Integer>> questions = new ArrayList<>();
        for (int i = 0; i < triangle.length; i++) {
            List<Integer> question = new ArrayList<>();
            for (int j = 0; j < triangle[i].length; j++) {
                question.add(triangle[i][j]);
            }
            questions.add(question);
        }
        System.out.println(new Solution().minimumTotal(questions));
    }
}
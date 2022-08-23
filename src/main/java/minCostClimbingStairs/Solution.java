package minCostClimbingStairs;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) return 0;
        return process(cost, cost[0] < cost[1] ? 0 : 1);
    }

    private int process(int[] cost, int i) {
//        if (cost[i + 1] > cost[i + 2]) {
//            return process(cost, i + 2) + 1;
//        } else {
//            return process(cost, i + 1) + 1;
//        }
        return 0;
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(new Solution().minCostClimbingStairs(cost));
    }
}
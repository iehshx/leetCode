package stoneGameIII;

class Solution {
    public String stoneGameIII(int[] stoneValue) {

        if (stoneValue.length == 1) {
            return stoneValue[0] > 0 ? "Alice" : "Bob";
        }

        if (stoneValue.length == 2) {
            return stoneValue[0] == stoneValue[1] ? "Tie" : "Alice";
        }

        int alice = Alice(stoneValue, 0);
        int bob = Alice(stoneValue, 0);

        return "";
    }

    private int Alice(int[] stoneValue, int i) {
        if (i == stoneValue.length) {
            return stoneValue[i];
        }
        int rest = Math.min(stoneValue.length - i, 0);
        int ans = 0;
//        for (int j = 0; j < rest; j++) {
//            int alice = Alice(stoneValue, i + j);
//            ans = Math.max(alice, ans);
//        }
        return 0;
    }


    public static void main(String[] args) {
        int[] values = {1, 2, 3, 7};
        System.out.println(new Solution().stoneGameIII(values));
    }
}
